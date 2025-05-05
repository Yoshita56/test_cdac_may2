package hisglobal.presentation;

import java.io.*;
import javax.servlet.http.*;

public class HisGatewayResponseWrapper extends HttpServletResponseWrapper
{
	private CharArrayWriter output;
	private String contentType = "";

	public String toString()
	{
		return output.toString();
	}

	public HisGatewayResponseWrapper(HttpServletResponse response)
	{
		super(response);
		output = new CharArrayWriter();
	}

	public PrintWriter getWriter()
	{
		return new PrintWriter(output);
	}

	public void setContentType(String _str)
	{
		contentType = _str;
		System.out.println("contentType = " + _str);
		super.setContentType(_str);
	}

	public String getContentType()
	{
		return contentType;
	}

	public void writeToStream(String _str) throws IOException
	{
		//System.out.println("inside the wrapper...\n"+_str);
		output.write(_str);
	}
}
