package hisglobal.presentation;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class HisGatewayProcessor
{
	public static final String LOGIN_PAGE = "/loginPage.jsp";
	public static final String ERROR_PAGE = "/errorPage.jsp";

	static public boolean isAccessAllowed(ServletRequest req)
	{
		HttpServletRequest request = (HttpServletRequest) req;

		//Flag to indicate where the requested page is accessible
		boolean flagCanGoFurther = false;

		System.out.println("requested URL:  " + request.getRequestURL());
		//get Context path
		String strContextPath = request.getContextPath();
		//System.out.println("strContextPath:  "+strContextPath);
		//System.out.println("strContextPath+'/'+LOGIN_PAGE    "+strContextPath+LOGIN_PAGE);

		//System.out.println("strRequestedURI:  "+request.getRequestURI());
		//Fetch a Session Object, if present in the Request
		HttpSession session = request.getSession(false);
		System.out.println("content type: " + request.getContentType());

		// 	check whether Session is Validated
		if (session != null)
		{//  	(YES)--> Valid Session<--(session!=null)
			System.out.println("Session != null");
			// 	Is a Bookmark Submission ? <--Achieved by checking 'referrer'
			String strReferer = request.getHeader("referer");

			if (strReferer == null)
			{//	(a Bookmark Submission) ? request.getHeader("referer")==null
				//System.out.println("strReferer");

				System.out.println("strReferer : nULl");
				//	Invalidate the Session
				session.invalidate();

				//	Is the requested page a 'Login Page'
				//String strRequestedURL = request.getRequestURL().toString();
				//int inParamStart = (strRequestedURL.indexOf("?") == -1) ? (strRequestedURL.length()): strRequestedURL.indexOf("?");
				//strRequestedURL = strRequestedURL.substring(0, inParamStart);

				String strRequestedURI = request.getRequestURI();

				System.out.println("strRequestedURI:   " + strRequestedURI);
				//System.out.println("strRequestedURI.equalsIgnoreCase(strContextPath+LOGIN_PAGE):  "+strRequestedURI.equalsIgnoreCase(strContextPath+LOGIN_PAGE));

				if (strRequestedURI.equalsIgnoreCase(strContextPath + LOGIN_PAGE))
				{
					System.out.println("Login Page Requested");

					//	(YES)? It's a Login Page request
					//	Proceed with the Request
					// session.invalidate();
					flagCanGoFurther = true;
				}
				else
				{
					if (strRequestedURI.equalsIgnoreCase(strContextPath + ERROR_PAGE))
					{
						System.out.println("error Page Requested");
						flagCanGoFurther = true;
					}
					else
					{ //	Redirect tO the Login Page
						System.out.println("Login Page Not Requested");

						flagCanGoFurther = false;
					}
				}
			}
			else
			{ //	(Not a Bookmark Submission) ? request.getHeader("referer")!=null
				//	Proceed with the Request
				System.out.println("referer isn't Null");
				flagCanGoFurther = true;
			}
		}
		else
		{// 	 (NO)--> Invalid Session <--(session==null)

			System.out.println("Invalid Session <--(session==null)");

			//	Is the requested page a 'Login Page'?
			//String strRequestedURL = request.getRequestURL().toString();
			//int inParamStart = (strRequestedURL.indexOf("?") == -1) ? (strRequestedURL.length()): strRequestedURL.indexOf("?");
			//strRequestedURL = strRequestedURL.substring(0, inParamStart);

			String strRequestedURI = request.getRequestURI();

			//System.out.println("strRequestedURI:   "+strRequestedURI);

			if (strRequestedURI.equalsIgnoreCase(strContextPath + LOGIN_PAGE))
			{
				System.out.println("requested Login Page...");
				//	(YES)? It's a Login Page request
				//	Proceed with the Request
				flagCanGoFurther = true;
			}
			else
			{
				if (strRequestedURI.equalsIgnoreCase(strContextPath + ERROR_PAGE))
				{
					System.out.println("error Page Requested");
					flagCanGoFurther = true;
				}
				else
				{
					System.out.println("not requested Login Page..");

					//	Redirect tO the Login Page
					flagCanGoFurther = false;
				}
			}
		}
		System.out.println("flagCanGoFurther:  " + flagCanGoFurther);
		return flagCanGoFurther;
	}

	static public HisGatewayResponseWrapper getHisGatewayResponseWrapper(ServletResponse res) throws IOException
	{

		HttpServletResponse response = (HttpServletResponse) res;

		// Fetch a Wrapper Object with stand-in output stream
		HisGatewayResponseWrapper wrapper;
		wrapper = new HisGatewayResponseWrapper((HttpServletResponse) response);

		return wrapper;
	}

	/*	static public void processHisResponse(HisGatewayResponseWrapper responseWrapper) throws IOException
	 {
	 try{
	 //responseWrapper.set
	 if(responseWrapper.getContentType().equals("text/html"))
	 {
	 responseWrapper.writeToStream(getScript());
	 }
	 }catch(Exception  e){System.out.println("Exception...: "+e);}
	 }*/

	static public void processHisResponse(ServletResponse res, HisGatewayResponseWrapper responseWrapper, ServletRequest req) throws IOException
	{
		System.out.println("ProcessHisResponse...");
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;

		try
		{
			//responseWrapper.set
			PrintWriter out = response.getWriter();
			if (responseWrapper.getContentType().equals("text/html"))
			{
				int posOfBody = responseWrapper.toString().toLowerCase().indexOf("</body>") - 1;
				if (posOfBody < 0)
				{
					out.write(responseWrapper.toString());
					out.write(getScript(request));
				}
				else
				{
					out.write(responseWrapper.toString().substring(0, posOfBody));
					out.write(getScript(request));
					out.write(responseWrapper.toString().substring(posOfBody + 1));
				}
				//			responseWrapper.writeToStream(getScript());

				// Write to the original Response
				//System.out.println("responseWrapper.toString():  ...\n"+responseWrapper.toString());
			}
			else
			{
				//System.out.println("Cookie is set...");
				//Cookie co = new Cookie("chkHasAlreadyLoaded", "false");
				//co.setMaxAge(-1);
				//co.setMaxAge(24 * 60 * 60);

				//response.addCookie(co);

				//System.out.println("CoOokie is set...");

				//Fetch Writer Object of the Original response]
				//<--
				out.write(responseWrapper.toString());
			}
			out.close();
		}
		catch (Exception e)
		{
			System.out.println("Exception...: " + e);
		}
	}

	static private String getScript(HttpServletRequest request)
	{
		StringBuffer sbScript = new StringBuffer();

		//get Context path
		String strContextPath = request.getContextPath();

		sbScript.append("\n<input type = 'hidden' name = 'hidChkHasAlreadyLoaded'/>");
		sbScript.append("\n<script> \n");
		//		sbScript.append("onLoadBackBtnChk(); \n");
		sbScript.append("  var oldonload = window.onload;\n");
		sbScript.append("if (typeof window.onload != 'function') {\n");
		sbScript.append("window.onload = function() {\n");
		sbScript.append("onLoadBackBtnChk();\n");
		sbScript.append("}\n");
		sbScript.append("} else {\n");
		sbScript.append("  window.onload = function() {\n");
		sbScript.append("oldonload();\n");
		sbScript.append("onLoadBackBtnChk();\n");
		sbScript.append("}\n");
		sbScript.append("}\n");

		sbScript.append("function onLoadBackBtnChk(){ \n");
		sbScript.append("alert('page loaded'); \n");
		sbScript.append("valChkHasAlreadyLoaded = document.getElementsByName('hidChkHasAlreadyLoaded')[0].value; \n");
		/*			sbScript.append("valChkHasAlreadyLoaded = readCookie('chkHasAlreadyLoaded'); \n");*/
		sbScript.append("alert(valChkHasAlreadyLoaded);\n");
		sbScript.append("if(valChkHasAlreadyLoaded == null || valChkHasAlreadyLoaded !='true'){ \n");
		sbScript.append("alert('Loading first time:  '+valChkHasAlreadyLoaded); \n");
		sbScript.append("document.getElementsByName('hidChkHasAlreadyLoaded')[0].value = 'true'");
		/*                sbScript.append("eraseCookie('chkHasAlreadyLoaded'); \n");
		 sbScript.append("createCookie('chkHasAlreadyLoaded', 'true' , 0); \n");
		 */sbScript.append("}else{//page is already loaded once \n");
		sbScript.append("self.location = '" + strContextPath + "/errorPage.jsp'; // go to error page \n");
		sbScript.append("alert('not Loading first time: go to error page'); \n");
		sbScript.append("} \n");
		sbScript.append("} \n");

		sbScript.append("function eraseCookie(name){ \n");
		sbScript.append("createCookie(name,'',-1); \n");
		sbScript.append("} \n");

		sbScript.append("function createCookie(name,value,days) \n");
		sbScript.append("{ \n");
		sbScript.append("if (days) \n");
		sbScript.append("{ \n");
		sbScript.append("var date = new Date(); \n");
		sbScript.append("if(days == 0){ \n");
		sbScript.append("var expires = '';// trash the cookie on browser close \n");
		sbScript.append("}else{ \n");
		sbScript.append("date.setTime(date.getTime()+(days*24*60*60*1000)); \n");
		sbScript.append("var expires = '; expires='+date.toGMTString(); \n");
		sbScript.append("} \n");
		sbScript.append("} \n");
		sbScript.append("else var expires = ''; \n");
		sbScript.append("document.cookie = name+'='+value+expires+'; path=/'; \n");
		sbScript.append("} \n");

		sbScript.append("function readCookie(name) \n");
		sbScript.append("{ \n");
		sbScript.append("var nameEQ = name + '='; \n");
		sbScript.append("var ca = document.cookie.split(';'); \n");
		sbScript.append("for(var i=0;i < ca.length;i++) \n");
		sbScript.append("{ \n");
		sbScript.append("var c = ca[i]; \n");
		sbScript.append("while (c.charAt(0)==' ') c = c.substring(1,c.length); \n");
		sbScript.append("if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length); \n");
		sbScript.append("} \n");
		sbScript.append("return null; \n");
		sbScript.append("} \n");

		sbScript.append("</script> \n");

		return sbScript.toString();
	}

	static public boolean isStruts(HttpServletRequest request)
	{
		String strUrl = request.getRequestURL().toString();

		if (strUrl.endsWith(".cnt")) return true;
		else return false;
	}

	static public boolean isFilterAllowed(ServletRequest request)
	{
		String strUrl = ((HttpServletRequest) request).getRequestURL().toString();

		if (strUrl.endsWith(".cnt")) return true;
		if (strUrl.endsWith(".jsp")) return true;

		return false;
	}
}
