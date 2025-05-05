package hisglobal.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.tiles.*;

public class HisRequestProcessor extends TilesRequestProcessor
{

	public void process(HttpServletRequest arg0, HttpServletResponse arg1) throws IOException, ServletException
	{
		//System.out.println("inside process of HisRequestProcessor");
		HisHttpServletRequest request = new HisHttpServletRequest(arg0);
		super.process(request, arg1);
	}

}
