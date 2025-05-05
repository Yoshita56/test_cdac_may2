package application.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HISApplicationRequestFilter implements Filter
{
	// private FilterConfig objFilterConfig;

	public void init(FilterConfig objFilterConfig)
	{
		// this.objFilterConfig = objFilterConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		// Nothing to do right now
	}

	public void destroy()
	{
		// Nothing to do right now
	}
}
