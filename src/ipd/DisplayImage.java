package ipd;

import hisglobal.utility.HisUtil;

import java.io.*;  

import javax.servlet.*;  
import javax.servlet.http.*;  
public class DisplayImage extends HttpServlet

{  
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)  
             throws IOException  
    {  
		
	//System.out.println("servlet has called....."+request.getParameter("stradm"));
    response.setContentType("image/png");  
    ServletOutputStream out;  
    out = response.getOutputStream();
    String filePath2=HisUtil.getParameterFromHisPathXML("TEMP_PATH");
    //String filePath = "C:\\PHDM\\AHIMS\\Qrcode images\\"+formBean.getStrAdmNo()+".png";
	FileInputStream fin = new FileInputStream(filePath2+ File.separator + request.getParameter("stradm")+".png");  
    BufferedInputStream bin = new BufferedInputStream(fin);  
    BufferedOutputStream bout = new BufferedOutputStream(out);  
    int ch =0; ;  
    while((ch=bin.read())!=-1)  
    {  
    bout.write(ch);  
    }  
      
    bin.close();  
    fin.close();  
    bout.close();  
    out.close();  
    }  
}  
