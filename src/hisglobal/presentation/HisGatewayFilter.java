package hisglobal.presentation;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HisGatewayFilter implements Filter
{
	public void init(FilterConfig config) throws ServletException
	{
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		try
		{
			System.out.println("HisGatewayFilter");
			if (HisGatewayProcessor.isFilterAllowed(request))
			{
				if (HisGatewayProcessor.isAccessAllowed(request))
				{
					System.out.println("Access is allowed..");
					HttpServletResponse res = (HttpServletResponse) response;

					//System.out.println("Access is allowed..");
					HisGatewayResponseWrapper hisGatewayResponseWrapper = HisGatewayProcessor.getHisGatewayResponseWrapper(response);

					if (HisGatewayProcessor.isStruts((HttpServletRequest) request))
					{
						String strRequestUrl = ((HttpServletRequest) request).getRequestURL().toString();
						System.out.println("((HttpServletRequest) request).getRequestURI().toString();  "
								+ ((HttpServletRequest) request).getRequestURI().toString());
						System.out.println("((HttpServletRequest) request).contextPath().toString(): "
								+ ((HttpServletRequest) request).getContextPath().toString());

						String strRequestUri = ((HttpServletRequest) request).getRequestURI().toString();
						String strContextPath = ((HttpServletRequest) request).getContextPath().toString();

						int idxOfExtension = strRequestUri.lastIndexOf('.');
						System.out.println("forwarding tO strUts..." + strRequestUri.substring(0, idxOfExtension).substring(strContextPath.length())
								+ ".struts");
						RequestDispatcher rd = request.getRequestDispatcher(strRequestUri.substring(0, idxOfExtension).substring(
								strContextPath.length())
								+ ".struts");
						rd.forward((HttpServletRequest) request, res);
						System.out.println("Request is forwarded...");
					}
					else
					{
						chain.doFilter(request, hisGatewayResponseWrapper);
					}

					HisGatewayProcessor.processHisResponse(response, hisGatewayResponseWrapper, request);
					//System.out.println("hisGatewayResponseWrapper.toString(): \n"+hisGatewayResponseWrapper.toString());  			
				}
				else
				{
					System.out.println("redirected.. to Login page");
					((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + HisGatewayProcessor.LOGIN_PAGE);
					return;
				}
			}
			else
			{
				chain.doFilter(request, response);
			}
			System.out.flush();
		}
		catch (Exception e)
		{
			System.out.println("Exception in doFilter():  " + e);
		}
	}

	public void destroy()
	{
	}
}
