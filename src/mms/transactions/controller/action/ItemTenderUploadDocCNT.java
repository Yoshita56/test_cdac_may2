package mms.transactions.controller.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import hisglobal.exceptions.HisException;
import mms.transactions.controller.data.ItemTenderUploadDocDATA;
import mms.transactions.controller.fb.ItemTenderUploadDocFB;

public class ItemTenderUploadDocCNT extends DispatchAction{
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException  {
		ItemTenderUploadDocFB formBean = (ItemTenderUploadDocFB) form;
		return this.INITVAL(mapping, formBean, request, response);
	}
	
	public ActionForward CANCELPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	    ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}

	public ActionForward INITVAL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
     
		ItemTenderUploadDocFB formBean = (ItemTenderUploadDocFB) form;
		formBean.reset(mapping, request);
		ItemTenderUploadDocDATA.getInitializedValues(formBean,request,response);
		String target = "initialPage";
		return mapping.findForward(target);
	} 
	
	public ActionForward GETITEMNAMECOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		
		ItemTenderUploadDocFB formBean = (ItemTenderUploadDocFB)form;
		ItemTenderUploadDocDATA.getITEMNameValues(formBean,request,response);
		
		return null;
	}

	public ActionForward SAVE(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException {
	    ItemTenderUploadDocFB formBean = (ItemTenderUploadDocFB) form;
	    
	    ItemTenderUploadDocDATA.getFtpProperties(formBean,request);
	    ItemTenderUploadDocDATA.getwarranty_sl_no(formBean,request,response);
	    
		 System.out.println("---formBean.getStrFtpUsername()---"+formBean.getStrFtpUsername());
		 System.out.println("---formBean.getStrFtpPassword()-----"+formBean.getStrFtpPassword());
		 System.out.println("---formBean.getStrFtpdestpath()-----"+formBean.getStrFtpdestpath());
		 System.out.println("---formBean.getStrFtpConnectionUri()----"+formBean.getStrFtpConnectionUri());
		 System.out.println("---formBean.getStrFtpPort()-----"+formBean.getStrFtpPort());
		 System.out.println("---formBean.getStrFtpRptconnection()-----"+formBean.getStrFtpRptconnection());
		
	    formBean.setStrUploadFileId3(request.getParameter("strUpload1"));
	    formBean.setStrUploadFileId4(request.getParameter("strUpload2"));
	    
	    String strGenericItemId = request.getParameter("strGenericItemId");
	    String strItemId = request.getParameter("strItemId");
	    
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyyhhmmss.SSSa");
	    LocalDateTime now = LocalDateTime.now();
	    String DateTime = dtf.format(now);
	    
	    String strFileName = strGenericItemId + "_" + strItemId+"_"+ DateTime;
	    
	    String[] Fupload = { formBean.getStrUploadFileId3(), formBean.getStrUploadFileId4() };

	    int fileCounter = 1;
	    for (String base64 : Fupload) {
	        if (!base64.isEmpty()) {
	        	
		        	String ftpServer     = formBean.getStrFtpConnectionUri();
		            String ftpUser       = formBean.getStrFtpUsername();
		            String ftpPass       = formBean.getStrFtpPassword();
		            String folder        = formBean.getStrFtpUsername();
		            String pdfName 	     = fileCounter + ".pdf";
		            String fileNameOnFTP = strFileName + pdfName;
	            
	        	
		            //String ftpServer = "uatddpmesushratexchange.dcservices.in";
		           // String ftpUser   = "aiimsm";
		           // String ftpPass   = "aiimsm_123";
		            //String folder    = "aiimsm";
		            //String pdfName = fileCounter + ".pdf";
		            //String fileNameOnFTP = strFileName + pdfName;
				
		            base64 = base64.replaceAll(" ", "+");
		            
	            try (InputStream pdfInputStream = new ByteArrayInputStream(Base64.getDecoder().decode(base64))) {
	                FTPClient ftpClient = new FTPClient();
	                ftpClient.connect(ftpServer);
	                ftpClient.login(ftpUser, ftpPass);
	                // Change the working directory
//	                /opt/FTP/AiimsNagpur/ftpserver/bmed/27916/TenderDoc
	                String ftpWorkingDir = "/opt/FTP/AiimsNagpur/ftpserver/bmed/27916/Item_Warranty";
//	                String ftpWorkingDir = formBean.getStrFtpRptconnection()+"TenderDoc";
	                if (ftpClient.changeWorkingDirectory(ftpWorkingDir)) {
	                    ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
	                   
	                    if (ftpClient.storeFile(fileNameOnFTP, pdfInputStream)) {
	                        System.out.println("File uploaded successfully: " + fileNameOnFTP);
	                    } else {
	                        System.out.println("Failed to upload file: " + fileNameOnFTP);
	                    }
	                } else {
	                    System.out.println("Failed to change working directory to: " + ftpWorkingDir);
	                }
	                ftpClient.logout();
	                ftpClient.disconnect();
	            }
	            catch (IOException e) {
	                e.printStackTrace();
	            }
				catch(Exception e) {
					e.printStackTrace();
				}
	            
	        }
	        fileCounter++;
	    }
	    formBean.setFTPPath(strFileName);
	    ItemTenderUploadDocDATA.saveData(formBean,request);
	    return null;
	}

	/*
	 public ActionForward SAVE(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Throwable {
	      ItemTenderUploadDocFB formBean = (ItemTenderUploadDocFB)form;
	      ItemTenderUploadDocDATA.getFtpProperties(formBean, request);
	      ItemTenderUploadDocDATA.getwarranty_sl_no(formBean, request, response);
	      
	      
	     
	      formBean.setStrUploadFileId3(request.getParameter("strUpload1"));
	      formBean.setStrUploadFileId4(request.getParameter("strUpload2"));
	      
	    
	      String strGenericItemId = request.getParameter("strGenericItemId");
	      String strItemId = request.getParameter("strItemId");
	      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyyhhmmss.SSSa");
	      
	      LocalDateTime now = LocalDateTime.now();
	      String DateTime = dtf.format(now);
	      String strFileName = strGenericItemId + "_" + strItemId + "_" + DateTime;
	      
	      String[] Fupload = new String[]{
	    		  formBean.getStrUploadFileId3(), formBean.getStrUploadFileId4()
	    		  };
	      
	      int fileCounter = 1;
	      String[] var17 = Fupload;
	      int var16 = Fupload.length;

	      for(int var15 = 0; var15 < var16; ++var15) {
	         String base64 = var17[var15];
	         if (!base64.isEmpty()) {
	            String ftpServer = formBean.getStrFtpConnectionUri();
	            String ftpUser = formBean.getStrFtpUsername();
	            String ftpPass = formBean.getStrFtpPassword();
	            String folder = formBean.getStrFtpUsername();
	            String pdfName = fileCounter + ".pdf";
	            String fileNameOnFTP = strFileName + pdfName;

	            try {
	               Throwable var24 = null;
	               Object var25 = null;

	               try(InputStream pdfInputStream = new ByteArrayInputStream(Base64.getDecoder().decode(base64))) {
	                  try {
	                     FTPClient ftpClient = new FTPClient();
	                     ftpClient.connect(ftpServer);
	                     ftpClient.login(ftpUser, ftpPass);
	                     String ftpWorkingDir = "/opt/FTP/AiimsNagpur/ftpserver/bmed/37913/TenderDoc";
	                     if (ftpClient.changeWorkingDirectory(ftpWorkingDir)) {
	                        ftpClient.setFileType(2);
	                        if (ftpClient.storeFile(fileNameOnFTP, pdfInputStream)) {
	                           System.out.println("File uploaded successfully: " + fileNameOnFTP);
	                        } else {
	                           System.out.println("Failed to upload file: " + fileNameOnFTP);
	                        }
	                     } else {
	                        System.out.println("Failed to change working directory to: " + ftpWorkingDir);
	                     }

	                     ftpClient.logout();
	                     ftpClient.disconnect();
	                  } finally {
	                     if (pdfInputStream != null) {
	                        pdfInputStream.close();
	                     }

	                  }
	               } catch (Throwable var38) {
	                  if (var24 == null) {
	                     var24 = var38;
	                  } else if (var24 != var38) {
	                     var24.addSuppressed(var38);
	                  }

	                  throw var24;
	               }
	            } catch (IOException var39) {
	               var39.printStackTrace();
	            } catch (Exception var40) {
	               var40.printStackTrace();
	            }
	         }

	         ++fileCounter;
	      }

	      formBean.setFTPPath(strFileName);
	      ItemTenderUploadDocDATA.saveData(formBean, request);
	      return null;
	   }
*/
}

