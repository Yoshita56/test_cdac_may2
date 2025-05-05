package hisglobal.utility.servlets;

import hisglobal.utility.HisFileControlUtil;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayFileServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet
{
	static final long serialVersionUID = 1L;

	public DisplayFileServlet()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String winPath = request.getParameter(ServletsUtilityConfig.FILE_PATH_WINDOWS);
		String linuxPath = request.getParameter(ServletsUtilityConfig.FILE_PATH_LINUX);
		String fileName = request.getParameter(ServletsUtilityConfig.FILE_NAME);
		
		HisFileControlUtil fileUtil = new HisFileControlUtil(fileName, winPath, linuxPath);
		OutputStream os = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(os);
		response.setContentType(fileUtil.getFileContentType());
		if(fileUtil.readFile())
		{
		byte[] bytes = fileUtil.getFileContent();
		
		try
		{
			
			if (bytes != null)
			{
				response.setHeader("Pragma", "no-cache");
				bos.write(bytes, 0, bytes.length);
				response.getOutputStream().flush();
				bos.close();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		}
		else
		{
			String msg="<B>This file does not exist:: Please Contact Administrator</B>";
			byte[] bytes=msg.getBytes();
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
