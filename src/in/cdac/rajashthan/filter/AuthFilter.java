package in.cdac.rajashthan.filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthFilter implements javax.servlet.Filter {
	public static final String AUTHENTICATION_HEADER = "Authorization";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {
		if (request instanceof HttpServletRequest) {
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			String authCredentials = httpServletRequest
					.getHeader(AUTHENTICATION_HEADER);

			// better injected
			AuthService authenticationService = new AuthService();
 
			String authenticationStatus = authenticationService
					.authenticate(authCredentials);
			
			if ("NO_CREDENTIALS".equals(authenticationStatus)){
				
				HttpServletResponse httpServletResponse = (HttpServletResponse) response;
				String responseToClient = "<newDataSet><error>Un Authorized Request</error><dateTime>"
						+ new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss")
				.format(new Date())
						+ "</dateTime></newDataSet>";

				httpServletResponse
						.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				httpServletResponse.getWriter().write(responseToClient);
				httpServletResponse.getWriter().flush();
				httpServletResponse.getWriter().close();
				
			}else {
				 				
				if ("SUCCESS".equals(authenticationStatus)) {
					filter.doFilter(request, response);
				} else {
					if (response instanceof HttpServletResponse) {
						HttpServletResponse httpServletResponse = (HttpServletResponse) response;

						String responseToClient = "<newDataSet><error>Not a Valid User Credentials</error><dateTime>"
								+ new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss")
						.format(new Date())
								+ "</dateTime></newDataSet>";

						httpServletResponse
								.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
						httpServletResponse.getWriter().write(responseToClient);
						httpServletResponse.getWriter().flush();
						httpServletResponse.getWriter().close();

					}
				}
				
			}
				
			
			
			
		}
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}