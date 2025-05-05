package hisglobal.utility.servlets;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayByteArrayServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet
{
	static final long serialVersionUID = 1L;

	public DisplayByteArrayServlet()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		byte[] bytes = (byte[]) request.getSession().getAttribute(ServletsUtilityConfig.SERVLET_DISPLAY_BYTE_ARRAY);
		String contentType = (String) request.getSession().getAttribute(ServletsUtilityConfig.SERVLET_DISPLAY_BYTE_ARRAY_CONTENT_TYPE);
		
		OutputStream os = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(os);
		if (bytes != null && contentType!=null)
		{
			response.setContentType(contentType);
			try
			{
				response.setHeader("Pragma", "no-cache");
				bos.write(bytes, 0, bytes.length);
				response.getOutputStream().flush();
				bos.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			String msg="<B>No Data for Display :: Please Contact Administrator</B>";
			bytes=msg.getBytes();
			response.setHeader("Pragma", "no-cache");
			bos.write(bytes, 0, bytes.length);
			response.getOutputStream().flush();
			bos.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request,response);
	}
}
