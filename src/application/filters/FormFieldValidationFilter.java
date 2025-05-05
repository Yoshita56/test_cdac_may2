package application.filters;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.utility.SecurityUtil;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet Filter implementation class FormFieldValidationFilter
 */

public class FormFieldValidationFilter implements Filter {

	private static Set<String> keys = new HashSet<String>();

	static 
	{
		keys.add("uservalue");
		keys.add("varssoticketgrantingticket");
		keys.add("go.x");     //services issu desk(issu to patient)
		keys.add("go.y");      //services issu desk(issu to patient)
		keys.add("cancel.x");  //global group master cancel button
		keys.add("cancel.y");  //global group master cancel button
		//keys.add("billmoduleid");
		//keys.add("usermode");		
	}

	private static final String TOKEN_KEY = "fhttf";

	/**
	 * Default constructor.
	 */
	public FormFieldValidationFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		String fHTokenVal = "";

		List<ParamObject> paramMap = null;
		UploadMultipartRequestWrapper multipartRequest = null;
		HttpServletRequest objRequest=(HttpServletRequest) request; 

		boolean isMultiPart = ServletFileUpload
				.isMultipartContent((HttpServletRequest) request);

		if (isMultiPart) {

			//System.out.println("above getParamsFromMultipartForm :: "
					//+ request.getParameter("hmode"));

			DiskFileItemFactory factory = new DiskFileItemFactory();
			  factory.setSizeThreshold(1024); 
		        factory.setRepository(new File("/")); 
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			multipartRequest = new UploadMultipartRequestWrapper(
					(HttpServletRequest) request, upload);

			paramMap = getParamsFromMultipartForm(multipartRequest);

			//System.out.println("below getParamsFromMultipartForm :: "
					//+ request.getParameter("hmode"));

		} else {

			if (paramMap == null) {

				//System.out.println("above getParamsFromSimpleForm :: "
						//+ request.getParameter("hmode"));

				paramMap = getParamsFromSimpleForm((HttpServletRequest) request);

				/*System.out.println("below getParamsFromSimpleForm :: "
						+ request.getParameter("hmode"));*/

			}

		}

		StringBuffer sb = new StringBuffer("");

		if (paramMap != null && paramMap.size() > 0) {

			Collections.sort(paramMap, new Comparator<ParamObject>() {

				@Override
				public int compare(ParamObject s1, ParamObject s2) {

					return s1.getName().toLowerCase().toString()
							.compareTo(s2.getName().toLowerCase().toString());
				}

			});

			for (ParamObject paramObject : paramMap) {

				 //System.out.println("key : " + paramObject.getName() +	 "  value :  " + paramObject.getValue());
				 
				 if(paramMap.size()==1 && ((paramObject.getName().equals("mode"))||paramObject.getName().equals("billmoduleid")||paramObject.getName().equals("usermode"))) //if only mode available
                 {
                 }
				 else if(paramMap.size()==2 && (((paramObject.getName().equals("usermode")||paramObject.getName().equals("billmoduleid")||(paramObject.getName().equals("mode")))))) //if only mode available
                 {
                	 
                 }
				 else
				 {
				if (TOKEN_KEY.equalsIgnoreCase(paramObject.getName())) {
					fHTokenVal = paramObject.getValue();
				} else {

					/*if((paramObject.getName().equalsIgnoreCase("mode"))) //mode not add with hash
					{
					      System.out.println("mode  not add");
					}*/
					if((paramObject.getName().equalsIgnoreCase("json"))) //mode not add with hash
					{
					      System.out.println("json  not add");
					}
					else
					{
						if(!paramObject.getValue().equalsIgnoreCase("undefined"))
						{
								String val = paramObject.getValue().replaceAll(" ", "_");

									val = val.replaceAll("\\r?\\n", "_");

									sb.append(val);
						}
					}

				}
				 }

			}

		}

		System.out.println("string :: " + sb.toString());

		String fToken = sb.toString().isEmpty() ? "" : SecurityUtil.getMd5Hash(sb.toString());

		System.out.println("fToken :: " + fToken);

		System.out.println("fHTokenVal :: " + fHTokenVal);
		HttpServletRequest objRequest1 = (HttpServletRequest) request;
		String uri = objRequest1.getRequestURI();
		System.out.println("objRequest1.getRequestURI()"+objRequest1.getRequestURI());
		System.out.println("request.getParameter(hmode)"+request.getParameter("hmode"));
		
		if(request.getParameter("hmode")!=null && ( request.getParameter("hmode").equalsIgnoreCase("BEDSTATUSIPD")||request.getParameter("hmode").equalsIgnoreCase("ADDNURSINGDESKIPD")||
			request.getParameter("hmode").equalsIgnoreCase("NOTREPORTEDNURSINGDESKIPD") || request.getParameter("hmode").equalsIgnoreCase("GOIPDDESK") ||
			request.getParameter("hmode").equalsIgnoreCase("ADDNURSINGDESKIPDCANCEL") || request.getParameter("hmode").equalsIgnoreCase("NOTREPORTINGNURSINGDESKIPD") || request.getParameter("hmode").equalsIgnoreCase("BEDSTATUSDASHBOARD") || uri.contains("DynamicReportsTransCNT")))
		{
			//System.out.println("INSIDE IPD PROCESSES");
			chain.doFilter(request, response);
		}
		else if(uri.contains("DynamicReportsTransCNT") ||uri.contains("DynamicReports") || uri.contains("/INVMGM/ipd/transactions/AdmissionAdviceTransCNT.cnt")|| uri.contains("/INVMGM/ipd/transactions/PatientFinalDischargeCNT.cnt") || uri.contains("/INVMGM/billing/transactions/CompulsoryChargesByConsultantCNT.cnt"))
		{
			chain.doFilter(request, response);
		}
		else
		{
			//HttpServletResponse res = (HttpServletResponse) response;
			
			
			if(objRequest1.getRequestURI().equalsIgnoreCase("/INVMGM/billing/transactions/CashCollectionOnlineTransCNT.cnt"))
			{
				if (isMultiPart)
					chain.doFilter(multipartRequest, response);
				else
					chain.doFilter(request, response);
			}
			else {
	
				
	
				if (isMultiPart) {
					
					//System.out.println("multipartRequest hmode before invoke next filter :: "
							//+ multipartRequest.getParameter("hmode"));
	
					chain.doFilter(multipartRequest, response);
	
					
				} else {
	
	
					//System.out.println("request hmode before invoke next filter :: "
							//+ request.getParameter("hmode"));
					
					chain.doFilter(request, response);
	
				}
	
			} /*else {
	
				HttpServletResponse res = (HttpServletResponse) response;
	
				res.setContentType("text/html");
				PrintWriter pw = res.getWriter();
				pw.write("ERROR####<html><head><title>Error</title></head><body><h1 align='center' style='color:red;'>Form Data Tampered</h1></body></html>");
	
			}*/
		}

		// pass the request along the filter chain

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	private static List<ParamObject> getParamsFromSimpleForm(
			HttpServletRequest request) {

		Enumeration<String> paramNames = request.getParameterNames();

		List<ParamObject> paramMap = new ArrayList<ParamObject>();

		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
		//	System.out.println(" param name is " + paramName);
			if (!keys.contains(paramName.toLowerCase())) {

				String[] paramValues = request.getParameterValues(paramName);
				if (paramValues.length == 1) {
					String paramValue = paramValues[0];
					if (paramValue.length() > 0)
						// paramValue= "108";
						paramMap.add(new ParamObject(paramName.toLowerCase(),
								paramValue));

				} else {
					for (int i = 0; i < paramValues.length; i++) {
						if (!("hmode".equalsIgnoreCase(paramName) && i == 0))
							paramMap.add(new ParamObject(paramName
									.toLowerCase(), paramValues[i]));
					}

				}

			}

		}

		return paramMap;
	}

	private static List<ParamObject> getParamsFromMultipartForm(
			HttpServletRequest request) {

		Enumeration<String> paramNames = request.getParameterNames();

		List<ParamObject> paramMap = new ArrayList<ParamObject>();

		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			//System.out.println(" param name is " + paramName);
			if (!keys.contains(paramName.toLowerCase())) {

				String[] paramValues = request.getParameterValues(paramName);
				if (paramValues.length == 1) {
					String paramValue = paramValues[0];
					if (paramValue.length() > 0)
						// paramValue= "108";
						System.out.println(paramName +"  >>  "+paramValue);
						paramMap.add(new ParamObject(paramName.toLowerCase(),
								paramValue));

				} else {
					for (int i = 0; i < paramValues.length; i++) {
						if (!("hmode".equalsIgnoreCase(paramName) && i == 0))
						{
							paramMap.add(new ParamObject(paramName
									.toLowerCase(), paramValues[i]));
							//System.out.println(paramName +"  >>  "+paramValues[i]);
						}
						
						
						
						
					}

				}

			}

		}

		return paramMap;
	}

}
