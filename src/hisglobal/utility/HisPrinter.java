
package hisglobal.utility;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class HisPrinter
{
	private static final String OS_NAME			=	System.getProperties().getProperty("os.name");
	private static final String BILLING_PRINT_MODE		=	"1";//1-Laser,2-DMP
	private static final String ADT_PRINT_MODE		=	"1";//1-Laser,2-DMP
	
	/**
	 * This function is used to print the contents
	 * Define TEMP_PATH & PRINTER_NAME property in hisPath.xml file
	 * e.g. c:/temp,/root
	 * @param contents 
	 * @param moduleName >> based on this name, printsh & changemode should be created
	 * e.g. if module name is adt then adtPrintSlip.sh & adtChangeMode.sh
	 * @param request
	 * @return
	 */
	public boolean  printFile(String contents,String moduleName,HttpServletRequest request)
   	{
		//pick the temporary path from hisPath.property
 		boolean retValue	=	false;
		
		String fileName	=	"";
		String hostName = "";
		String postName = "";
		String printerName = "";
		String clientOS = "";
		
		//get IP address for the client machine
		hostName = request.getRemoteAddr();
		postName = request.getSession().getAttribute("SEATID").toString();		
		//get client operating system
		clientOS = getClientSystemOsType(request);
		
		//get global parameter from hisPath.property file
		
		fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH") + "/" + moduleName + postName + ".dat";
		printerName = HisUtil.getParameterFromHisPathXML(moduleName+"_"+"PRINTER_NAME");
		if(printerName==null || printerName.equals("") )
			printerName = HisUtil.getParameterFromHisPathXML("PRINTER_NAME");
		
		try
		{
			FileWriter FR 			=   new FileWriter(fileName,false);
			BufferedWriter OS		=	new BufferedWriter(FR);

			for(int i=0;i<contents.length();i++)
			{
				OS.write(contents.charAt(i));
				OS.flush();
			}
			
			OS.close();
			
			if(moduleName.equals("ADT"))
			{
				if(ADT_PRINT_MODE.equals("2"))//-DMP
				//call print function to print the file
				retValue = printSlip(fileName,hostName,printerName,clientOS,moduleName);
			}
			else
			{
				if(BILLING_PRINT_MODE.equals("2"))//-DMP
					//call print function to print the file
					retValue = printSlip(fileName,hostName,printerName,clientOS,moduleName);
			}		
			
			retValue	=	true;
		}
		catch(Exception e)
		{
			System.out.println("Exception in createTempFile() "+e);
			retValue	=	false;
		}

		return retValue;
	}
	
	
	
	/**
	 * This function is used to reprint the file which is created by the function printFile()
	 * @param moduleName >> based on this name, printsh & changemode should be created
	 * e.g. if module name is adt then adtPrintSlip.sh & adtChangeMode.sh
	 * @param request
	 * @return
	 */
	public boolean  reprintFile(String moduleName,HttpServletRequest request)
   	{
		//pick the temporary path from hisPath.property
 		boolean retValue	=	false;
		
		String fileName	=	"";
		String hostName = "";
		String postName = "";
		String printerName = "";
		String clientOS = "";
		
		//get IP address for the client machine
		hostName = request.getRemoteAddr();
		postName = request.getSession().getAttribute("SEATID").toString();
		
		//get client operating system
		clientOS = getClientSystemOsType(request);
		
		//get global parameter from hisPath.property file
		
		fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH") + "/" + moduleName + postName + ".dat";
		
		printerName = HisUtil.getParameterFromHisPathXML(moduleName+"_"+"PRINTER_NAME");
		if(printerName==null || printerName.equals("") )
			printerName = HisUtil.getParameterFromHisPathXML("PRINTER_NAME");
		//System.out.println("fileName = " + fileName);
		
		try
		{
			//call print function to print the file
			retValue = printSlip(fileName,hostName,printerName,clientOS,moduleName);
			
			retValue	=	true;
		}
		catch(Exception e)
		{
			System.out.println("Exception in createTempFile() "+e);
			retValue	=	false;
		}

		return retValue;
	}
	

	//prints the file based on the operating system
	public boolean printSlip(String fileName,String hostName,String printerName,
			String clientOS,String moduleName) throws Exception
	{
		boolean retValue	=	false;
		String printCommand = "";
		String strUserForPrinter = "Administrator%";
		strUserForPrinter = "hisprinter%hisprinter";
		
		//strUserForPrinter = HisUtil.getParameterFromHisPathXML("PRINTER_USER")+" "+HisUtil.getParameterFromHisPathXML("PRINTER_PASSWORD");
		
		if(OS_NAME.startsWith("Linux"))
		{
			if(clientOS.equals("Linux"))
				printCommand = "lpr -P "+hostName+" -l "+fileName;
			else	
				printCommand	=	"echo \"print\" "+fileName+"|smbclient //"+hostName+"/" + printerName + " -U "+strUserForPrinter;
			
			//System.out.println("printCommand :: "+printCommand);
			
			retValue = linuxPrinting(printCommand,moduleName);
		}
		else
		{
			if(OS_NAME.startsWith("Windows")) {
				printCommand = "\\\\" + hostName + "\\" + printerName;
				
				//System.out.println("printCommand :: "+printCommand);
				
				retValue = printFile(printCommand,fileName);//For windows based printing
			}
			else
			{
				System.out.println("Unable to detect the Operating System. Printing Aborted");
				retValue = false;
			}
		}
		
		return retValue;
	}
	
	//print the file if the server is on linux
	public boolean linuxPrinting(String printCommand,String moduleName)
	{
		boolean retValue	=	false;
		String shPrintFile = "";
		//String shChangeModeFile = "";
		
		try
		{
			shPrintFile = "/root/" + moduleName + "PrintSlip.sh";
			//shChangeModeFile = "/root/" + moduleName + "ChangeMode.sh";
			
			FileOutputStream 	os 	= 	new FileOutputStream(shPrintFile);
			PrintStream 		ps 	= 	new PrintStream(os,false);
			ps.print(printCommand+"\n");
			
			ps.close();
			Runtime rt	=	Runtime.getRuntime();
			
			Process prs = rt.exec("sh /root/" + moduleName + "ChangeMode.sh");
			prs.waitFor();
			
			/*
			Process execPrintProcess	=	rt.exec(printCommand);
			execPrintProcess.waitFor();
			Process changeModeProcess	=	rt.exec("chmod 777 "+shPrintFile);
			changeModeProcess.waitFor();
			Process printProcess	=	rt.exec("sh "+shPrintFile);
			printProcess.waitFor();*/
			
			retValue = true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occurred in linuxPrinting() "+e);
			retValue = false;
		}
		return retValue;
	}

	//print the file if the server is on window
	public boolean printFile(String printerPath,String fileName)throws FileNotFoundException,IOException
	{
		boolean retValue = true;
		
		try
		{		
			StringBuffer sb = new StringBuffer();
			FileOutputStream fos = new FileOutputStream(printerPath);
			PrintStream ps = new PrintStream(fos);
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			File f = new File(fileName);
			char[] msg = new char[(int)f.length()+1];
			int i=0;
			boolean eof = false;

			while(!eof)
			{
				int j = bis.read();
				if(j==-1)
					eof = true;
				else
				{
					msg[i] += (char)j;
					i++;
				}

			}
			//System.out.println("msg=="+msg);
			sb.append(msg);
			ps.print(msg);
			ps.close();
		}
		catch(Exception e)
		{
			System.out.println("Error while printing file::::" + e);	
			retValue = false;			
		}
		return retValue;
	}
	
	/**
     * Checks whether the request came from Windows or Linux
     * @param request - HttpServletRequest
     * @return String Windows - if Request Came From Windows OS
     *                        Linux - if the Request Came From Linux OS 
     *                        Others - if the Request Came From Other than Windows and Linux             
     */

    public String getClientSystemOsType(HttpServletRequest request) {

          String strOsType = "";
          String strAgentDtls = "";
          Enumeration<?> names = request.getHeaderNames();

          while (names.hasMoreElements()) {
        	  
        	  String elem = (String) names.nextElement();

        	  if (elem.contains("agent")) {
                      strAgentDtls = request.getHeader(elem);
                      break;
        	  }
          }
          
          if (!strAgentDtls.equals("")) {
        	  
        	  if (strAgentDtls.contains("windows") || strAgentDtls.contains("Windows")
        			  || strAgentDtls.contains("Win") || strAgentDtls.contains("win")) {

                      strOsType = "Windows";
        	  } 
        	  else if (strAgentDtls.contains("linux") || strAgentDtls.contains("Linux")) {
        		  strOsType = "Linux";

              }else{
            	  strOsType = "Other";

              }
          }
          
          return strOsType;
    }
}
