/**********************************************************
 Project:	   DWH_CMSS	
 File:         CrossScriptingFilter.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package application.filters;

import hissso.config.HISSSOConfig;
import hissso.ticket.HISServiceTicket;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class CrossScriptingFilter.
 */
public class CrossScriptingFilter implements Filter {

	/** The filter config. */
	private FilterConfig filterConfig;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {

		this.filterConfig = filterConfig;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		this.filterConfig = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
// System.out.println("ONE");
		
		try 
		{
			HttpServletRequest objRequest = (HttpServletRequest) request;
            String strURI = objRequest.getRequestURI();
            if(strURI.equalsIgnoreCase("/HISRegistration/registration/transactions/attachUploadFile.xxx") ||  strURI.contains("ImageRendererServlet") ||  strURI.contains("EnlargedImage"))
				chain.doFilter(request,response);
			else
			 chain.doFilter(new RequestWrapper((HttpServletRequest) request),response);
		} 
		catch (Exception t) 
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.write("<html><head><title>Exception/Error Detail(s)</title></head><body>");
			out.write("<h3><center><font color='red'>Error Detail(s)</font></center></h3>");
			out.write("<h1><center><font color='red'>Error Name:This Activity/Values Not Allowed.<font></center></h1>");
			out.write("</ul>");
			out.write("<br><br>");
			out.write("</body></html>");
			/*RequestDispatcher rd = request.getRequestDispatcher(HISSSOConfig.SSO_ILLEGAL_ACTIVITY_ERROR_PAGE_URL);
			rd.forward(request, response);*/
			
		}

	}

}