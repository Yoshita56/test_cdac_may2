/**********************************************************
 Project:	   DWH_CMSS	
 File:         AntiSamyFilter.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package application.filters;

import hisglobal.utility.HisUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.owasp.validator.html.AntiSamy;
import org.owasp.validator.html.CleanResults;
import org.owasp.validator.html.Policy;

// TODO: Auto-generated Javadoc
/**
 * The Class AntiSamyFilter.
 */
public class AntiSamyFilter implements Filter {

	// private static final Logger LOG = Logger.getLogger(AntiSamyFilter.class);

	/** AntiSamy is unfortunately not immutable, but is threadsafe if we only. */
	private final AntiSamy antiSamy;

	/**
	 * Instantiates a new anti samy filter.
	 */
	public AntiSamyFilter() {
		Policy policy = null;
		String Policy_FilePath = "";
		try {
			Policy_FilePath = HisUtil
					.getParameterFromHisPathXML("CROSS_SCRIPT_ANTISAMY");
			policy = Policy.getInstance(Policy_FilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}

		antiSamy = new AntiSamy(policy);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			if (request instanceof HttpServletRequest) {

				CleanServletRequest cleanRequest = new CleanServletRequest(
						(HttpServletRequest) request, antiSamy);
				chain.doFilter(cleanRequest, response);
			} else {

				chain.doFilter(request, response);
			}
		} catch (Exception t) {
			processError(request, response, t.getMessage());
		}

	}

	/**
	 * Process error.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param ErrMsg
	 *            the err msg
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void processError(ServletRequest request, ServletResponse response,
			String ErrMsg) throws IOException {

		// Set response content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<html><head><title>Exception/Error Detail(s)</title></head><body>");
		out.write("<h3><center>Exception Detail(s)</center></h3>");
		out.write("<h1><center>Exception Name:" + ErrMsg + "</center></h1>");
		out.write("</ul>");
		out.write("<br><br>");
		out.write("</body></html>");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		//System.out.println("AntiSammy Initilizing....");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		//System.out.println("AntiSammy Destroying....");
	}

	/**
	 * Wrapper for a {@link HttpServletRequest} that returns 'safe' parameter
	 * values by passing the raw request parameters through the anti-samy
	 * filter. Should be private
	 */
	private static class CleanServletRequest extends HttpServletRequestWrapper {

		/** The anti samy. */
		private final AntiSamy antiSamy;

		/**
		 * Instantiates a new clean servlet request.
		 * 
		 * @param request
		 *            the request
		 * @param antiSamy
		 *            the anti samy
		 */
		private CleanServletRequest(HttpServletRequest request,
				AntiSamy antiSamy) {
			super(request);
			this.antiSamy = antiSamy;
		}

		/**
		 * overriding getParameter functions in {@link ServletRequestWrapper}.
		 * 
		 * @param name
		 *            the name
		 * @return the parameter values
		 */

		public String[] getParameterValues(String name) {
			String[] originalValues = super.getParameterValues(name);

			if (originalValues == null) {
				return null;
			}
			List<String> newValues = new ArrayList<String>(
					originalValues.length);

			Pattern scriptPattern = Pattern.compile("</table>",
					Pattern.CASE_INSENSITIVE);

			for (String value : originalValues) {

				newValues.add(filterString(value));

			}
			return newValues.toArray(new String[newValues.size()]);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see javax.servlet.ServletRequestWrapper#getParameterMap()
		 */
		public Map getParameterMap() {
			// System.out.println("I");
			Map<String, String[]> originalMap = super.getParameterMap();
			Map<String, String[]> filteredMap = new ConcurrentHashMap<String, String[]>(
					originalMap.size());
			for (String name : originalMap.keySet()) {
				filteredMap.put(name, getParameterValues(name));
			}
			return Collections.unmodifiableMap(filteredMap);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * javax.servlet.ServletRequestWrapper#getParameter(java.lang.String)
		 */
		public String getParameter(String name) {
			// System.out.println("J");
			String potentiallyDirtyParameter = super.getParameter(name);
			return filterString(potentiallyDirtyParameter);
		}

		/**
		 * Filter string.
		 * 
		 * @param potentiallyDirtyParameter
		 *            string to be cleaned
		 * @return a clean version of the same string
		 */
		private String filterString(String potentiallyDirtyParameter) {
			if (potentiallyDirtyParameter == null) {
				return null;
			}

			try {
				CleanResults cr = antiSamy.scan(potentiallyDirtyParameter,
						AntiSamy.DOM);

				if (cr.getNumberOfErrors() > 0) {
					// ("antisamy encountered problem with input: " +
					// cr.getErrorMessages());
					throw new Exception("" + cr.getErrorMessages());
				}
				return cr.getCleanHTML();
			} catch (Exception e) {
				throw new IllegalStateException(e.getMessage());
			}
		}

	}
}