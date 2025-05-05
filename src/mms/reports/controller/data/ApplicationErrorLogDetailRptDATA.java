package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import ipd.HLPipd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPFile;
import org.htmlparser.beans.StringBean;

import mms.global.controller.MmsHLP;
import mms.reports.bo.ApplicationErrorLogDetailRptBO;
import mms.reports.controller.fb.ApplicationErrorLogDetailRptFB;
import mms.reports.vo.ApplicationErrorLogDetailRptVO;


public class ApplicationErrorLogDetailRptDATA {
	
	public static void getInit(ApplicationErrorLogDetailRptFB formBean, HttpServletRequest request) 
	{
		HisUtil util = null;		
		String strmsgText = null;
		ApplicationErrorLogDetailRptBO bo;
		ApplicationErrorLogDetailRptVO voObj;
		
		try 
		{
			bo = new ApplicationErrorLogDetailRptBO();			
			util = new HisUtil("MMS Transactions", "ApplicationErrorLogDetailRptDATA");
			voObj = new ApplicationErrorLogDetailRptVO();
			
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));
			
			voObj.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			bo.getModuleList(voObj);
			
			String temp = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^All",false);
			formBean.setStrModuleList(temp);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.ApplicationErrorLogDetailRptDATA.getInit --> "+ e.getMessage();
			HisException eObj = new HisException("mms","ApplicationErrorLogDetailRptDATA->getInit()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} 
		finally 
		{
			if (util != null)
				util = null;
		}
	}
	
	


	/**
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void showReport(ApplicationErrorLogDetailRptFB formBean,
			HttpServletRequest request, HttpServletResponse response)
	{

		ReportUtil ts = new ReportUtil();		
		String reportFormat = "html";

		Map<String, Object> params = new HashMap<String, Object>();
		
		try 
		{
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			String strPreferredFromTime = (formBean.getStrPreferredFromTime()==null || formBean.getStrPreferredFromTime().equals(""))?"00:00":formBean.getStrPreferredFromTime();
			String strPreferredToTime = (formBean.getStrPreferredToTime()==null || formBean.getStrPreferredToTime().equals(""))?"23:59":formBean.getStrPreferredToTime();
			String strErrorId = (formBean.getStrErrorId()==null || formBean.getStrErrorId().equals(""))?"0":formBean.getStrErrorId();
			
			String strWhetherConsolidated = formBean.getStrWhetherConsolidated();
			String strUserRemarks = formBean.getStrUserRemarks();
			reportFormat = formBean.getStrReportFormat();
			String reportPath = ""; 
			
			String module=formBean.getStrModuleName();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			String strReportName = "Application Error Log Detail";
			
			if( strWhetherConsolidated==null || strWhetherConsolidated.equals("") )
				strWhetherConsolidated="0";
			
			if(strWhetherConsolidated.equals("1"))
			{
				 reportPath = "/mms/reports/dwh_applicationErrorLogDtl1_rpt.rptdesign"; // Consolidated
			}
			else
			{
				 reportPath = "/mms/reports/dwh_applicationErrorLogDtl_rpt.rptdesign"; // Detailed
			}
				
		
			
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				
				params.put("hospCode", strHospitalCode);
				//System.out.println("hosp code:::   "+strHospitalCode);
				params.put("from_Date", sdf.format(sdf.parse(strFromDate))+" "+strPreferredFromTime);
				params.put("to_Date", sdf.format(sdf.parse(strToDate))+" "+strPreferredToTime);
				params.put("error_Id",strErrorId);
				params.put("module",module);
				
				
				ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);
			
		      	
		}
		catch (Exception e) 
		{
			//e.printStackTrace();
		}
	}
	
	public static void showServerLog(ApplicationErrorLogDetailRptFB formBean,HttpServletRequest request, HttpServletResponse response)
	{
		request.getSession().removeAttribute("serverFilePath");
		try 
		{
			//String file="E:/wildfly-16.0.0.Fresh/standalone/log/server.log";
			//String directory="E:/wildfly-16.0.0.Fresh/standalone/log/server.log";
			
			//E:\wildfly-16.0.0.Fresh\standalone\deployments\INVMGM.war
			
			String webAppPath = request.getServletContext().getRealPath("/");
			
			//JBOSS_HOME
			String logPath="";
			
			String logFile="server.log";
			
			if(formBean.getStrServerLogType().equals("server"))
				logFile="server.log";
			
			
			//System.out.println("Log Dir"+System.getProperty("jboss.server.log.dir"));
			//System.out.println("os.name"+System.getProperties().getProperty("os.name"));
			
			String osType = System.getProperties().getProperty("os.name");
			
			 if(osType.startsWith("Win"))
			 {
				 if(formBean.getStrServerType().equals("jboss"))
				 {
					 if(formBean.getStrServerLogType().equals("boot"))
							logFile="boot.log";
					 
					 //logPath=webAppPath.split("default")[0].replace("\\","/")+"log/"+logFile+"";
					 logPath=System.getProperty("jboss.server.log.dir")+"/"+logFile;
				 }
				 
				 if(formBean.getStrServerType().equals("wildfly"))
				 {
					 //System.out.println("System.getProperty(\"jboss.server.log.dir\")"+System.getProperty("jboss.server.log.dir"));
					 //logPath=webAppPath.split("deployments")[0].replace("\\","/")+"log/"+logFile+"";
					 logPath=System.getProperty("jboss.server.log.dir")+"\\"+logFile;
				 }
				 if(formBean.getStrServerType().equals("tomcat7"))
					 logPath=System.getProperty("catalina.base") + "/logs/"+logFile+"";
				 if(formBean.getStrServerType().equals("tomcat8"))
					 logPath=System.getProperty("catalina.base") + "/logs/"+logFile+"";
				 //System.getProperty("catalina.base") + "/logs".
				 
			 }
			 else
			 {
				 if(formBean.getStrServerType().equals("jboss"))
				 {
					 if(formBean.getStrServerLogType().equals("boot"))
							logFile="boot.log";
					 //logPath=webAppPath.split("default")[0].replace("\\","/")+"log/"+logFile+"";
					 logPath=System.getProperty("jboss.server.log.dir")+"/"+logFile;
				 }
				 if(formBean.getStrServerType().equals("wildfly"))
					 //logPath=webAppPath.split("deployments")[0].replace("\\","/")+"log/"+logFile+"";
					 logPath=System.getProperty("jboss.server.log.dir")+"/"+logFile;
				 if(formBean.getStrServerType().equals("tomcat7"))
					 logPath=System.getProperty("catalina.base") + "/logs/"+logFile+"";
				 if(formBean.getStrServerType().equals("tomcat8"))
					 logPath=System.getProperty("catalina.base") + "/logs/"+logFile+"";
			 }			
			
			request.getSession().setAttribute("serverFilePath", logPath);
			
			//E:\wildfly-16.0.0.Fresh\standalone\
			
			//System.out.println("webAppPath"+webAppPath);
			//System.out.println("logPath"+logPath);
			
			/*System.out.println("App Deployed Directory path: " + request.getServletContext().getRealPath("/"));
			System.out.println("getContextPath(): " + request.getServletContext().getContextPath());
			System.out.println("Apache Tomcat Server: " + request.getServletContext().getServerInfo());
			System.out.println("Servlet API version: " + request.getServletContext().getMajorVersion() + "."+ request.getServletContext().getMinorVersion());
			System.out.println("Tomcat Project Name: " + request.getServletContext().getServletContextName());
			
			
			 * String osType = System.getProperties().getProperty("os.name");
			 * if(osType.startsWith("Win")){ _Param += "_WIN"; //paramValue =
			 * getParameterFromXML("c:/RAOL/AHIMS/hisPath.xml", _Param); paramValue =
			 * getParameterFromXML("c:/AIIMSBBW/AHIMSG5/hisPath.xml", _Param); }else{ _Param
			 * += "_LIN"; paramValue =
			 * getParameterFromXML("/opt/AIIMSBBW/AHIMSG5/hisPath.xml", _Param);
			 * 
			 * 
			 * if(formBean.getStrServerType().equals("jboss"))
			 * request.getSession().setAttribute("serverFilePath", "");
			 * if(formBean.getStrServerType().equals("jboss"))
			 * if(formBean.getStrServerType().equals("jboss"))
			 */
			
			
		}
		catch (Exception e) 
		{
			//e.printStackTrace();
		}
	}
	
	public static void viewHisPath(ApplicationErrorLogDetailRptFB formBean,HttpServletRequest request, HttpServletResponse response)
	{
		request.getSession().removeAttribute("serverFilePath");
		try 
		{
			String osType = System.getProperties().getProperty("os.name");
			String logPath="";
			if(osType.startsWith("Win"))
			{
				logPath="c:/AIIMSBBW/AHIMSG5/hisPath.xml";
			}
			else
			{
				logPath= "/opt/AIIMSBBW/AHIMSG5/hisPath.xml";
			}			
			 
			request.getSession().setAttribute("serverFilePath", logPath);
		}
		catch (Exception e) 
		{
			//e.printStackTrace();
		}
	}
	
	public static void checkFTP(ApplicationErrorLogDetailRptFB formBean,HttpServletRequest request, HttpServletResponse response)
	{
		request.getSession().removeAttribute("serverFilePath");
		String ftp="";
		try 
	    {
			 FTPClient f=new FTPClient();
			 
			 ftp=HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL").replace("/", "#").split("#")[0];
			 String ftpuser=HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_USERNAME");
			 String ftppwd=HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_PASSWORD");
			 
			 //System.out.println("ftp"+ftp);
			 //System.out.println("ftpuser"+ftpuser);
			 //System.out.println("ftppwd"+ftppwd);
			 
			 //f.connect("10.10.10.143");
			 //boolean status=f.login("aiimsb", "FTP123aiims@$");
			 f.connect(ftp);
			 boolean status=f.login(ftpuser, ftppwd);
			 
			 // Sends a NOOP command to the FTP server. 
			//FTPClient ftpClient = new FTPClient();
	        //boolean answer = ftpClient.sendNoOp();
	        if(status)
	        {
	        	System.out.println("Server connection success!");
	        	formBean.setStrNormalMsg("FTP Connection to "+ftp+" Successful");
	        	String dirToList = "/opt/FTP/aiims_bhubaneswar";
	            //listDirectory(f, dirToList, "", 0);
	        }
	        else
	        {
	            System.out.println("Server connection failed!");
	            formBean.setStrErrMsg("FTP Connection to "+ftp+" Failed");
	            /*boolean success = reconnect();
	            if(success)
	            {
	                System.out.println("Reconnect attampt have succeeded!");
	                return true;
	            }
	            else
	            {
	                System.out.println("Reconnect attampt failed!");
	                return false;
	            }*/
	        }
	    }
	    catch (FTPConnectionClosedException e) 
	    {
	        System.out.println("Server connection is closed!");
	        formBean.setStrErrMsg("FTP Connection to "+ftp+"Closed");
	        /*boolean recon = reconnect();
	        if(recon)
	        {
	            System.out.println("Reconnect attampt have succeeded!");
	            return true;
	        }
	        else
	        {
	            System.out.println("Reconnect attampt have failed!");
	            return false;
	        }*/

	    }
	    catch (IOException e) 
	    {
	        System.out.println("Server connection failed!");
	        formBean.setStrErrMsg("FTP Connection to "+ftp+" Failed");
	        /*boolean recon = reconnect();
	        if(recon)
	        {
	            System.out.println("Reconnect attampt have succeeded!");
	            return true;
	        }
	        else
	        {
	            System.out.println("Reconnect attampt have failed!");
	            return false;
	        }  */ 
	    }
	    catch (NullPointerException e) 
	    {
	        System.out.println("Server connection is closed!");
	        formBean.setStrErrMsg("FTP Connection to "+ftp+" Failed");
	        /*boolean recon = reconnect();
	        if(recon)
	        {
	            System.out.println("Reconnect attampt have succeeded!");
	            return true;
	        }
	        else
	        {
	            System.out.println("Reconnect attampt have failed!");
	            return false;
	        }   */
	    }
	}
	
	static String listDirectory(FTPClient ftpClient, String parentDir,String currentDir, int level) throws IOException 
	{
        String dirToList = parentDir;
        StringBuffer sb=new StringBuffer();
        if (!currentDir.equals("")) 
        {
            dirToList += "/" + currentDir;
        }
        FTPFile[] subFiles = ftpClient.listFiles(dirToList);
        if (subFiles != null && subFiles.length > 0) 
        {
        	
            for (FTPFile aFile : subFiles) 
            {
                String currentFileName = aFile.getName();
                
    	        if (currentFileName.equals(".") || currentFileName.equals("..")) 
                {
                    // skip parent directory and directory itself
                    continue;
                }
                for (int i = 0; i < level; i++) 
                {
                    System.out.print("\t");
                    
                }
                if (aFile.isDirectory()) 
                {
                    System.out.println("[" + currentFileName + "]");
                    /*sb.append("<div class='row rowFlex reFlex'>");
        	        sb.append("<div class='col-sm-2'></div>");
        	        sb.append("<div class='col-sm-10'>"+currentFileName+"</div>");
        	        sb.append("</div>");*/
                  
                    sb.append("<li><span class='caret'>"+currentFileName+"</span>");
                    sb.append("<ul class='nested'>");
      	            
        	        sb.append(listDirectory(ftpClient, dirToList, currentFileName, level + 1));
        	        sb.append("</ul></li>");
                } 
                else 
                {
                	/* sb.append("<div class='row rowFlex reFlex'>");
        	        sb.append("<div class='col-sm-2'></div>");
        	        sb.append("<div class='col-sm-10'><li>"+currentFileName+"<li></div>");
        	        sb.append("</div>"); */
        	        
                	 sb.append("<li class='file'>"+currentFileName+"</li>");
                	 
                    System.out.println(currentFileName);
                }
            }
            
        }
        return sb.toString();
    }
	
	public static void viewStandalone(ApplicationErrorLogDetailRptFB formBean,HttpServletRequest request, HttpServletResponse response)
	{
		request.getSession().removeAttribute("serverFilePath");
		
		try 
		{
			String webAppPath = request.getServletContext().getRealPath("/");
			
			String logPath="";
			String logFile="standalone.xml";
			//System.out.println("Server Dir"+System.getProperty("jboss.server.config.dir"));
			String osType = System.getProperties().getProperty("os.name");
			
			 if(osType.startsWith("Win"))
			 {
				 logPath=System.getProperty("jboss.server.config.dir")+"\\"+logFile;				  
			 }
			 else
			 {
				logPath=System.getProperty("jboss.server.config.dir")+"/"+logFile;				
			 }			
			
			request.getSession().setAttribute("serverFilePath", logPath);		
			
		}
		catch (Exception e) 
		{
			//e.printStackTrace();
		}
	}
	public static void viewWAR(ApplicationErrorLogDetailRptFB formBean,HttpServletRequest request, HttpServletResponse response)
	{
		request.getSession().removeAttribute("serverFilePath");
		try 
		{
			StringBuffer sb=null;
			String webAppPath = request.getServletContext().getRealPath("/");
			
			String logPath="";
			//System.out.println("Log Dir"+System.getProperty("jboss.home.dir"));
			String osType = System.getProperties().getProperty("os.name");
			
			File directoryPath = new File(System.getProperty("jboss.home.dir")+"\\standalone\\deployments");
			
			if(osType.startsWith("Win"))
			{
				 directoryPath = new File(System.getProperty("jboss.home.dir")+"\\standalone\\deployments");
			}
			else
			{
				 directoryPath = new File(System.getProperty("jboss.home.dir")+"/standalone/deployments");
			}	
			
			String contents[] = directoryPath.list();
		    //System.out.println("List of files and directories in the specified directory:");
			 sb=new StringBuffer();
	         sb.append("<div class='row rowFlex reFlex'>");
	         sb.append("<div class='col-sm-2'></div>");
	         sb.append("<div class='col-sm-4'>Application Name</div>");
	         sb.append("<div class='col-sm-2'>Status</div>");
	         sb.append("<div class='col-sm-4'>Information</div>");
	         sb.append("</div>");
	         sb.append("<hr>");
	         
		    for(int i=0; i<contents.length; i++) 
		    {
		         System.out.println(contents[i]);
		         if(contents[i].contains("deployed") || contents[i].contains("failed"))
		         {		         
			         sb.append("<div class='row rowFlex reFlex'>");
			         sb.append("<div class='col-sm-2'><img src='/INVMGM/hisglobal/images/cloud.png' width='12%' /></div>");
			         sb.append("<div class='col-sm-4'>"+contents[i].replace(".","#").split("#")[0]+"</div>");
			         if(contents[i].contains("deployed"))
			         {
			        	 sb.append("<div class='col-sm-2'><i class='far fa-check-circle text-success'></i></div>");
			        	 sb.append("<div class='col-sm-4'><label class='text-success'>Running</label></div>");
			         }
			         else
			         {
			        	 sb.append("<div class='col-sm-2'><i class='far fa-check-circle text-danger'></i></div>");
			        	 sb.append("<div class='col-sm-4'><label class='text-danger'>Not Running</label></div>");
			         }			         
			         sb.append("</div>");
		         }
		    }
			
			//request.getSession().setAttribute("serverFilePath", logPath);
			formBean.setStrData(sb.toString());			
		}
		catch (Exception e) 
		{
			//e.printStackTrace();
		}
	}
	public static void viewJAR(ApplicationErrorLogDetailRptFB formBean,HttpServletRequest request, HttpServletResponse response)
	{
		StringBuffer sb=null;
		request.getSession().removeAttribute("serverFilePath");
		try 
		{
			String logPath="";
			//System.out.println("Log Dir"+System.getProperty("jboss.home.dir"));
			String osType = System.getProperties().getProperty("os.name");
			
			File directoryPath = new File(System.getProperty("jboss.home.dir")+"\\modules\\system\\layers\\base\\com\\hmis\\main");
			if(osType.startsWith("Win"))
			{
				 directoryPath =  new File(System.getProperty("jboss.home.dir")+"\\modules\\system\\layers\\base\\com\\hmis\\main");
			}
			else
			{
				 directoryPath =  new File(System.getProperty("jboss.home.dir")+"/modules/system/layers/base/com/hmis/main");
			}
			
			String contents[] = directoryPath.list();
		    //System.out.println("List of files and directories in the specified directory:");

		    sb=new StringBuffer();
	        sb.append("<div class='row rowFlex reFlex'>");
	        sb.append("<div class='col-sm-2'></div>");
	        sb.append("<div class='col-sm-10'>JAR Name</div>");
	        sb.append("</div>");
	        sb.append("<hr>");
	         
		    for(int i=0; i<contents.length; i++) 
		    {
		         System.out.println(contents[i]);
		         sb.append("<div class='row rowFlex reFlex'>");
		         sb.append("<div class='col-sm-2'><img src='/INVMGM/hisglobal/images/jar.png' width='12%' /></div>");
		         sb.append("<div class='col-sm-10'>"+contents[i]+"</div>");
			     sb.append("</div>");		        
		    }			
			//request.getSession().setAttribute("serverFilePath", logPath);
			formBean.setStrData(sb.toString());
		}
		catch (Exception e) 
		{
			//e.printStackTrace();
		}
	}
	public static void viewModule(ApplicationErrorLogDetailRptFB formBean,HttpServletRequest request, HttpServletResponse response)
	{
		request.getSession().removeAttribute("serverFilePath");
		try 
		{
			String logPath="";
			String logFile="module.xml";
			//System.out.println("Server Dir"+System.getProperty("jboss.server.config.dir"));
			String osType = System.getProperties().getProperty("os.name");
			if(osType.startsWith("Win"))
			{
				 logPath=System.getProperty("jboss.home.dir")+"\\modules\\system\\layers\\base\\com\\hmis\\main\\"+logFile;				  
			}
			else
			{
				logPath=new File(System.getProperty("jboss.home.dir")+"/modules/system/layers/base/com/hmis/main")+"/"+logFile;				
			}			
			
			request.getSession().setAttribute("serverFilePath", logPath);		
			
		}
		catch (Exception e) 
		{
			//e.printStackTrace();
		}
	}
	
	public static void viewFtpFiles(ApplicationErrorLogDetailRptFB formBean,HttpServletRequest request, HttpServletResponse response)
	{
		request.getSession().removeAttribute("serverFilePath");
		String ftp="";
		StringBuffer sb=new StringBuffer();
		try 
	    {
			 FTPClient f=new FTPClient();
			 
			 ftp=HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL").replace("/", "#").split("#")[0];
			 String ftpuser=HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_USERNAME");
			 String ftppwd=HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_PASSWORD");
			 
			 //System.out.println("ftp"+ftp);
			 //System.out.println("ftpuser"+ftpuser);
			 //System.out.println("ftppwd"+ftppwd);
			 
			 //f.connect("10.10.10.143");
			 //boolean status=f.login("aiimsb", "FTP123aiims@$");
			 f.connect(ftp);
			 boolean status=f.login(ftpuser, ftppwd);
			 
			 // Sends a NOOP command to the FTP server. 
			//FTPClient ftpClient = new FTPClient();
	        //boolean answer = ftpClient.sendNoOp();
	        if(status)
	        {
	        	System.out.println("Server connection success!");
	        	formBean.setStrNormalMsg("FTP Connection to "+ftp+" Successful");
	        	//String dirToList = "/opt/FTP/aiims_bhubaneswar";
	        	String dirToList = "/opt/FTP";
	        	sb.append("<div class='row rowFlex reFlex'>");
    	        sb.append("<div class='col-sm-2'></div>");
    	        sb.append("<div class='col-sm-10'>File Name</div>");
    	        sb.append("</div>");
    	        
    	        sb.append("<ul id='myUL'>");
    	        
	            String s=listDirectory(f, dirToList, "", 0);
	            sb.append(s);
	            sb.append("</ul>");
	           
	        }
	        else
	        {
	            System.out.println("Server connection failed!");
	            formBean.setStrNormalMsg("FTP Connection to "+ftp+" Failed");
	            /*boolean success = reconnect();
	            if(success)
	            {
	                System.out.println("Reconnect attampt have succeeded!");
	                return true;
	            }
	            else
	            {
	                System.out.println("Reconnect attampt failed!");
	                return false;
	            }*/
	        }
	    }
	    catch (FTPConnectionClosedException e) 
	    {
	        System.out.println("Server connection is closed!");
	        formBean.setStrNormalMsg("FTP Connection to "+ftp+"Closed");
	        /*boolean recon = reconnect();
	        if(recon)
	        {
	            System.out.println("Reconnect attampt have succeeded!");
	            return true;
	        }
	        else
	        {
	            System.out.println("Reconnect attampt have failed!");
	            return false;
	        }*/

	    }
	    catch (IOException e) 
	    {
	        System.out.println("Server connection failed!");
	        formBean.setStrNormalMsg("FTP Connection to "+ftp+" Failed");
	        /*boolean recon = reconnect();
	        if(recon)
	        {
	            System.out.println("Reconnect attampt have succeeded!");
	            return true;
	        }
	        else
	        {
	            System.out.println("Reconnect attampt have failed!");
	            return false;
	        }  */ 
	    }
	    catch (NullPointerException e) 
	    {
	        System.out.println("Server connection is closed!");
	        formBean.setStrNormalMsg("FTP Connection to "+ftp+" Failed");
	        /*boolean recon = reconnect();
	        if(recon)
	        {
	            System.out.println("Reconnect attampt have succeeded!");
	            return true;
	        }
	        else
	        {
	            System.out.println("Reconnect attampt have failed!");
	            return false;
	        }   */
	    }
		
		formBean.setStrData(sb.toString());
	}
	
	public static void getDBData(ApplicationErrorLogDetailRptFB formBean, HttpServletRequest request,HttpServletResponse response) 
	{
		HisUtil util = null;		
		String strmsgText = null;
		ApplicationErrorLogDetailRptBO bo;
		ApplicationErrorLogDetailRptVO voObj;
		
		try 
		{
			bo = new ApplicationErrorLogDetailRptBO();			
			util = new HisUtil("AuditLog", "ApplicationErrorLogDetailRptDATA");
			voObj = new ApplicationErrorLogDetailRptVO();
			
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));
			
			voObj.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			bo.getDBData(voObj);
			
			if (voObj.getStrMsgType().equals("0")) 
			{
				String val = "";
				val = MmsHLP.getDBData(voObj.getStrStoreWs(),voObj.getStrHospitalCode());
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(val);				
			}
		} 
		catch (Exception e) 
		{
			//e.printStackTrace();
			strmsgText = "mms.transactions.ApplicationErrorLogDetailRptDATA.getInit --> "+ e.getMessage();
			HisException eObj = new HisException("AuditLog","ApplicationErrorLogDetailRptDATA->getInit()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} 
		finally 
		{
			if (util != null)
				util = null;
		}
	}
}