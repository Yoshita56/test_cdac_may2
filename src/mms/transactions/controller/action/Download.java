package mms.transactions.controller.action;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Download {


	/**
     * Checks whether the request came from Windows or Linux
     * @param request - HttpServletRequest
     * @return String Windows - if Request Came From Windows OS
     *                        Linux - if the Request Came From Linux OS 
     *                        Others - if the Request Came From Other than Windows and Linux             
     */

    public String getClientSystemOsType(HttpServletRequest request) {

        //System.out.println("Entered"); 
    	String strOsType = "";
          String strAgentDtls = "";
          Enumeration<?> names = request.getHeaderNames();
          
         while (names.hasMoreElements()) {

        	  String elem = (String) names.nextElement();
        	  if (elem.contains("agent") || elem.contains("Agent")) {
                      strAgentDtls = request.getHeader(elem);
                      break;
        	  }
          }
          
          if (!strAgentDtls.equals("")) {
        	  
        	  if (strAgentDtls.contains("windows") || strAgentDtls.contains("Windows")
        			  || strAgentDtls.contains("Win") || strAgentDtls.contains("win")) {

                      strOsType = "Windows";
        	  } 
        	  else if (strAgentDtls.contains("linux") || strAgentDtls.contains("Linux")|| strAgentDtls.contains("X11")) {
        		  strOsType = "Linux";

              }else{
            	  strOsType = "Other";

              }
          }
          
          return strOsType;
    }
	
    /**
     *  Sends a file to the ServletResponse output stream.  Typically
     *  you want the browser to receive a different name than the
     *  name the file has been saved in your local database, since
     *  your local names need to be unique.
     *
     *  @param req The request
     *  @param resp The response
     *  @param filename The name of the file you want to download.
     */
    public void doDownload( HttpServletRequest req, HttpServletResponse resp,
                             String filename )
        throws IOException
        {
  
    	
    // set the buffer size as per the bandwidth
    	int BUFSIZE = 64;
    	
    	
    		String strFilePath = "";
    	
    	//if(getClientSystemOsType(req).equals("Windows")){
    		
    		//strFilePath = "C:/FileUpload/"+filename;
    		
    	//}else{
    		
    		strFilePath = "/opt/optFileUpload/"+filename;
    		
    	//}
    	
    	
        File                f        = new File(strFilePath);
        int                 length   = 0;
        ServletOutputStream op       = resp.getOutputStream();
        HttpSession session = req.getSession();
        ServletContext      context  =session.getServletContext();
       //ServletContext      context  =  req.getServletContext();
        String              mimetype = context.getMimeType( filename );

       String filetype = filename.split("\\.")[1];
     //System.out.println("File Type:::"+filetype);
       
       if(filetype.equalsIgnoreCase("pdf"))
       {
    	 // System.out.println("Entered in IF Block");
    	   resp.setContentType( (mimetype != null) ? mimetype : "application/pdf" );  
       }
       else
       {
      
        resp.setContentType( (mimetype != null) ? mimetype : "application/octet-stream" );
       }
        resp.setContentLength( (int)f.length() );
        resp.setHeader( "Content-Disposition", "attachment; filename=\"" + filename + "\"" );

       
        //  Stream to the requester.
        byte[] bbuf = new byte[BUFSIZE];
        DataInputStream in = new DataInputStream(new FileInputStream(f));

        while ((in != null) && ((length = in.read(bbuf)) != -1))
        {
            op.write(bbuf,0,length);
        }

        in.close();
       op.flush();
        op.close();
    }
    
    
}

