package hisglobal.utility.filetransfer;

/*
 * @author: CDAC
 */

import hisglobal.utility.filetransfer.config.FTPStaticConfigurator;
import hisglobal.utility.filetransfer.config.FileTransferConfig;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.FileNameMap;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletResponse;

public class FTPFileTransfer
{
	
	/**
	 * Getting File Patch based on Process ID
	 * 
	 * @param strProcessId_p
	 * @param strCRNoHosp_p
	 * @return
	 */
	public static String getFilePath(String strProcessId_p, String strCRNoHosp_p)
	{
		String strFilePath="";
		try
		{
			String processType = FileTransferConfig.MAP_PROCESS_DETIAL.get(strProcessId_p).getValue();
			
			if(processType.equals(FileTransferConfig.PROCESS_TYPE_PATIENT_WISE))
			{
				//	HHH/HHHYYXXX/HHHYYXXXXXXXC/File
				strFilePath = "/" + strCRNoHosp_p.substring(0,3) + "/" + strCRNoHosp_p.substring(0,8) + "/" + strCRNoHosp_p;
				System.out.println(strFilePath);
			}
			else
			{
				//	HHH/ProcessName/File
				strFilePath = "/" + strCRNoHosp_p.substring(0,3) + "/" + FileTransferConfig.MAP_PROCESS_DETIAL.get(strProcessId_p).getLabel();
				System.out.println(strFilePath);
			}
		}
		catch(Exception e)
		{
			strFilePath = "";
			e.printStackTrace();
		}
		return strFilePath;
	}

	/**
	 * Getting File Content Type
	 * 
	 * @param strFileName File Name with Extension 
	 * @return Content Type in String
	 */
	public static String getFileContentType(String strFileName_p)
	{
		String strContentType = "";
		try
		{
			FileNameMap fileNameMap = URLConnection.getFileNameMap();
			strContentType = fileNameMap.getContentTypeFor(strFileName_p);
		}
		catch(Exception e)
		{
			strContentType = "";
		}
		if(strContentType==null)	strContentType = "";
		return strContentType;
	}

	
	/**
	 * Uploading File to FTP Server
	 * Test Case : Concurrent Folder Structure Creation, File Save and File Modify
	 * 
	 * @param strProcessId_p	Process ID
	 * @param strFileName_p		File Name
	 * @param inputStream_p		File Content 
	 * @param strCRNoHosp_p		In case of Patient-Wise CRNo otherwise Hospital Code
	 * @throws IOException
	 */
	public static void uploadFile(String strProcessId_p, String strFileName_p, InputStream inputStream_p, String strCRNoHosp_p) throws IOException
	{
		BufferedOutputStream bos = null;
		try
		{
			// Fetching FTP Server Address with Complete URL and User Name: Password
			String ftpServerURL = FTPStaticConfigurator.HIS_FTP_SERVER_ADDRESS_COMPLETE; // <ftpServerUserName>:<ftpServerPassword>@<ftpServerURL>;
			String ftpServerUserName = FTPStaticConfigurator.HIS_FTP_SERVER_USERNAME;
			String ftpServerPassword = FTPStaticConfigurator.HIS_FTP_SERVER_PASSWORD;

			String strFileFtpURL = "ftp://" + ftpServerURL;
			String strFTPFilePath = getFilePath(strProcessId_p, strCRNoHosp_p);
			URL urlftp = new URL(strFileFtpURL + strFTPFilePath + "/" + strFileName_p);
			
			URLConnection urlc = urlftp.openConnection();

			try
			{
				bos = new BufferedOutputStream(urlc.getOutputStream());
			}
			catch (Exception ex)
			{
				System.out.println("Folder Structure Not Created or Not a Vlaid FTP Server");
				//ex.printStackTrace();
			}

			if (bos == null)
			{
				String[] folder = strFTPFilePath.replace("/", "#").split("#");
				String strFileFtpServerURLOnly = "";
				if (strFileFtpURL.contains("@")) strFileFtpServerURLOnly = ftpServerURL.split("@")[1];
				else strFileFtpServerURLOnly = ftpServerURL;
				//folder[0] = strFTPFilePath.split("/")[1];
				createFTPDirectoryStructure(strFileFtpServerURLOnly, ftpServerUserName, ftpServerPassword, folder);

				urlc = urlftp.openConnection();
				bos = new BufferedOutputStream(urlc.getOutputStream());
			}

			byte[] buf = new byte[1024];

			for (int readNum; (readNum = inputStream_p.read(buf)) != -1;)
			{
				bos.write(buf, 0, readNum); // no doubt here is 0
				// Writes len bytes from the specified byte array
				// starting at
				// offset off to this byte array output stream.
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (bos != null) bos.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * Retrieving File to FTP Server
	 * Test Case : Concurrent Folder Structure Creation, File Save and File Modify
	 * 
	 * @param strProcessId_p	Process ID
	 * @param strFileName_p		File Name
	 * @param inputStream_p		File Content 
	 * @param strCRNoHosp_p		In case of Patient-Wise CRNo otherwise Hospital Code
	 * @throws IOException
	 */
	public static InputStream retrieveFile(String strProcessId_p, String strFileName_p, String strCRNoHosp_p) throws FileNotFoundException
	{
		InputStream inputStream = null;
		//StringBuffer sb = new StringBuffer();
		try
		{
			// Fetching FTP Server Address with Complete URL and User Name: Password
			String ftpServerURL = FTPStaticConfigurator.HIS_FTP_SERVER_ADDRESS_COMPLETE; // <ftpServerUserName>:<ftpServerPassword>@<ftpServerURL>;
			//String ftpServerUserName = FTPStaticConfigurator.HIS_FTP_SERVER_USERNAME;
			//String ftpServerPassword = FTPStaticConfigurator.HIS_FTP_SERVER_PASSWORD;

			String strFileFtpURL = "ftp://" + ftpServerURL;
			String strFTPFilePath = getFilePath(strProcessId_p, strCRNoHosp_p);
			URL urlftp = new URL(strFileFtpURL + strFTPFilePath + "/" + strFileName_p);

			URLConnection urlc = urlftp.openConnection();

			inputStream = urlc.getInputStream();
//			DataInputStream dataInputStream = new DataInputStream(inputStream);
//			BufferedReader buffRead = new BufferedReader(new InputStreamReader(dataInputStream));
//			String strLine;
//			// Read File Line By Line
//			while ((strLine = buffRead.readLine()) != null)
//			{
//				// Print the content on the console
//				System.out.println(strLine);
//				sb.append(strLine);
//			}
			//content = sb.toString();

			//inputStream.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new FileNotFoundException("File Not Found");
		}
		//return content;
		return inputStream;
	}

	/**
	 * Retrieving and Writing File to FTP Server
	 * Test Case : Concurrent Folder Structure Creation, File Save and File Modify
	 * 
	 * @param strProcessId_p	Process ID
	 * @param strFileName_p		File Name
	 * @param inputStream_p		File Content 
	 * @param strCRNoHosp_p		In case of Patient-Wise CRNo otherwise Hospital Code
	 * @throws IOException
	 */
	public static boolean retrieveWriteFile(String strProcessId_p, String strFileName_p, String strCRNoHosp_p, HttpServletResponse response_p) throws FileNotFoundException
	{
		InputStream inputStream = null;
		BufferedOutputStream bos = null;
		try
		{
			// Fetching FTP Server Address with Complete URL and User Name: Password
			String ftpServerURL = FTPStaticConfigurator.HIS_FTP_SERVER_ADDRESS_COMPLETE; // <ftpServerUserName>:<ftpServerPassword>@<ftpServerURL>;
			//String ftpServerUserName = FTPStaticConfigurator.HIS_FTP_SERVER_USERNAME;
			//String ftpServerPassword = FTPStaticConfigurator.HIS_FTP_SERVER_PASSWORD;

			String strFileFtpURL = "ftp://" + ftpServerURL;
			String strFTPFilePath = getFilePath(strProcessId_p, strCRNoHosp_p);
			URL urlftp = new URL(strFileFtpURL + strFTPFilePath + "/" + strFileName_p);

			URLConnection urlc = urlftp.openConnection();
			urlc.connect();

			OutputStream os = response_p.getOutputStream();
			bos = new BufferedOutputStream(os);

			inputStream = urlc.getInputStream();
			int c;
			while ((c = inputStream.read()) != -1)
			{
				os.write(c);
			}    
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			try
			{
				if(inputStream!=null) inputStream.close();
				response_p.getOutputStream().flush();
				if(bos!=null)	bos.close();
			}
			catch(Exception e)
			{
			}
		}
		return true;
	}
	
//	public static void saveFileToLocation(String htmlString,String pdfFileurl, String pdfFtpurl, String pdfFileName) throws IOException, FtpException
//	{
//		System.out.println("Step 1 saveFileToLocation");
//		/*InputStream in = new ByteArrayInputStream(imageUtilityVO.getImageByteArray());
//		BufferedImage image;
//		*/
//		
//		System.out.println("inside DAO func---printReportInPdfFormat-->ResultEntryVOGroupByValidatedBy--------->saveFileToLocation");
//		Document document = new Document(); 
//		InputStream s = new ByteArrayInputStream(htmlString.getBytes()); 
//		try {
//			
//						
//			URL urlftp =new URL(pdfFtpurl+"/"+pdfFileName);
//			URLConnection urlc=	urlc= urlftp.openConnection();
//			BufferedOutputStream bos = null ;
//			try
//			{
//				bos=new BufferedOutputStream(urlc.getOutputStream());
//				
//			}
//			catch(Exception ex)
//			{
//				System.out.println("  catch ");
//			}
//			System.out.println("urlftp  :"+urlc);
//			if(bos==null)
//			{
//				String[] folder=pdfFileurl.replace("/", "#").split("#");
//				createDirectoryStructure(folder[2],folder);
//				bos=new BufferedOutputStream(urlc.getOutputStream());
//			}
//			System.out.println("urlftp  :"+urlc);
//			
//			try {
//				
//				PdfWriter.getInstance(document,	bos);
//				document.open();
//				 List<Element> elementlist = HTMLWorker.parseToList(new InputStreamReader(s), new StyleSheet()); 
//			        for (int i = 0; i < elementlist.size(); i++) {
//						Element element = (Element)elementlist.get(i); 
//			        if(elementlist.size()>0) { 
//			                document.add(element);  
//			        } 
//			    	System.out.println("before closing"); 
//					}
//				
//			} catch (DocumentException e) {
//				e.printStackTrace();
//			}
//			document.close();
//			bos.close();
//			
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//			throw new IOException();
//		}
//		
//	}

	
	private static void createFTPDirectoryStructure(String strFTPHost_p, String strFTPServerUserName_p, String strFTPServerPassword_p,
			String[] arrFolders_p)
	{
		HISFTPWrapper ftp = null;
		try
		{
			ftp = new HISFTPWrapper();
			String strFTPHostOnly = strFTPHost_p.split("/")[0];
			String strFTPHostPath = strFTPHost_p.split("/")[1];

			System.out.println("Connecting to Host" + strFTPHostOnly + "  Host Path :"+ strFTPHostPath +" UN:"+strFTPServerUserName_p+" PW:"+strFTPServerPassword_p);
			if (ftp.connectAndLogin(strFTPHostOnly, strFTPServerUserName_p, strFTPServerPassword_p))
			{
				 System.out.println("Connected to " + strFTPHostOnly);
				ftp.changeWorkingDirectory(strFTPHostPath);
				 System.out.println("Move to " + strFTPHostPath);
				ftp.setPassiveMode(true);
				// System.out.println("Present Working Directory :" + ftp.pwd());
				for (int i = 0; i < (arrFolders_p.length); i++)
				{
					if(arrFolders_p[i]!=null && !arrFolders_p[i].trim().equals(""))
					{
						// System.out.println("directory " + arrFolders_p[i] + " created");
						int result = ftp.mkd(arrFolders_p[i]);
						ftp.changeWorkingDirectory(arrFolders_p[i]);
						System.out.println("FTP Folder Created Succesfully :: " + arrFolders_p[i] + " :: " + result);
					}
				}
				System.out.println("FTP Folder Structure Succesfully Created");
			}
			else
			{
				throw new Exception("Can't Login to FTP Server");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (ftp != null)
				{
					ftp.logout();
					ftp.disconnect();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	

	/*
	 * From Rabinder Sir Code
	private static void createDirectoryStructure(String ftpserver, String[] folders) {
			
			JakartaFtpWrapper ftp=null;
			try {
				 ftp = new JakartaFtpWrapper();
				
				HisAppletConfigurator hisAppletConfigurator=new HisAppletConfigurator();
				new TemplateProcessingClass(1,"101").readingAppletConfiguratorXML(hisAppletConfigurator);
				
				
				String ftpUserName=hisAppletConfigurator.getResultprintingusername();
				String ftpUserPassword=hisAppletConfigurator.getResultprintinguserpassword();
				
				
				System.out.println("Connecting to " + ftpserver);
				if (ftp.connectAndLogin(ftpserver, ftpUserName, ftpUserPassword)) 
				{
					System.out.println("Connected to " + ftpserver);
					ftp.setPassiveMode(true);
					ftp.changeWorkingDirectory("ftpserver");
					System.out.println("Present Working Directory :"+ftp.pwd());
					for(int i=4;i<folders.length;i++)
					{
							System.out.println("directory "+folders[i]+" created");
							ftp.mkd(folders[i]);
							ftp.changeWorkingDirectory(folders[i]);
					}
						
					
				}
				else
				{
					System.out.println("Unable to connect to" + ftpserver);
				}
				System.out.println("Finished");
			} catch(Exception e) {
				e.printStackTrace();
			} 
			finally {
				try
				{
					if(ftp!=null)
					{
						ftp.logout();
						ftp.disconnect();
					}
				}
			catch(Exception e) {
				e.printStackTrace();
			}
			}
		}
		*/

		
		
		
		
		
		
		
		
	
	

	/**
	 *--------------------- 
	 * @param Fileurl
	 * @param FileName
	 */
	/*public static void readFileFromFTPLocation(String strFileFtpURL_p, String ftpServerUsrNam_p, String ftpServerPass_p, String fileName_p)
	{
		InputStream inputStream = null;
		try
		{
			URL urlftp = new URL(strFileFtpURL_p + "/" + fileName_p);
			URLConnection urlc = urlftp.openConnection();
			inputStream = urlc.getInputStream();
			DataInputStream dataInputStream = new DataInputStream(inputStream);
			BufferedReader buffRead = new BufferedReader(new InputStreamReader(dataInputStream));
			String strLine;
			// Read File Line By Line
			while ((strLine = buffRead.readLine()) != null)
			{
				// Print the content on the console
				System.out.println(strLine);
			}
			// Close the input stream
			inputStream.close();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public static void saveAudioVideoFileInFTP(byte[] _arr, String _fileName) throws FileNotFoundException, IOException
	{
		try
		{
			String server = "10.103.0.20";
			String user = "administrator";
			String passwd = "hisregistration";
			// String fileName = "leave office.mpg";
//			byte[] b = _arr;

			FtpClient ftpClient = new FtpClient();
			ftpClient.openServer(server);
			ftpClient.login(user, passwd);
			ftpClient.binary();
			ftpClient.cd("dir");

			// FileOutputStream fos= new FileOutputStream("out.txt");
			// fos.write(b);
			// fos.close();

			OutputStream netOut = ftpClient.put(_fileName);

			FileInputStream fileIn = new FileInputStream("out.txt");

			int read = 0;

			while ((read = fileIn.read()) != -1)
			{
				netOut.write(read);
			}
			fileIn.close();
			netOut.close();
			ftpClient.closeServer();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}*/






	
	
	
	
	
	
	
//	/**
//	 * here we get Up-Load file
//	 * 
//	 * @param ItemWarrantyDtlsFB_p
//	 * @param request_p
//	 * @param response_p
//	 */
//	public static void getUploadedFile(ItemWarrantyDtlsFB ItemWarrantyDtlsFB_p, HttpServletRequest request_p, HttpServletResponse response_p)
//	{
//
//		String strmsgText = null;
//		String strFileName = "";
//		File f = null;
//		FileInputStream fis = null;
//		byte[] fileContent = new byte[1024];
//		BmedConfigUtil bmed = null;
//		String strFtpFolderName = "";
//		UserVO userVo = null;
//
//		try
//		{
//
//			bmed = new BmedConfigUtil();
//			userVo = ControllerUTIL.getUserVO(request_p);
//			strFtpFolderName = bmed.getStrFtpFileFolder("15", userVo.getHospitalCode());
//
//			if (strFtpFolderName.equals("") || strFtpFolderName == null)
//			{
//				strFtpFolderName = "adil123";
//			}
//
//			strFileName = ItemWarrantyDtlsFB_p.getStrUploadFileId();
//
//			// System.out.println("File Name::::::"+ItemWarrantyDtlsFB_p.getStrUploadFileId());
//			String[] strTemp = strFileName.replace(".", "#").split("#");
//			String strExt = strTemp[strTemp.length - 1];
//
//			if (strExt.equalsIgnoreCase("txt") || strExt.equalsIgnoreCase("txt"))
//			{
//
//				response_p.setContentType("application/txt");
//				response_p.setHeader("Content-disposition", " filename=" + strFtpFolderName + "" + strFileName);
//
//			}
//			else if (strExt.equalsIgnoreCase("pdf"))
//			{
//
//				response_p.setContentType("application/pdf");
//				response_p.setHeader("Content-disposition", "attachment; filename=" + strFtpFolderName + "" + strFileName);
//
//			}
//			else if (strExt.equalsIgnoreCase("html") || strExt.equalsIgnoreCase("htm"))
//			{
//
//				response_p.setContentType("text/html;charset=utf-8");
//				response_p.setHeader("Content-disposition", "attachment; filename=" + strFtpFolderName + "" + strFileName);
//
//			}
//			else if (strExt.equalsIgnoreCase("xml"))
//			{
//
//				response_p.setContentType("application/xml");
//				response_p.setHeader("Content-disposition", "attachment; filename=" + strFtpFolderName + "" + strFileName);
//
//			}
//			else if (strExt.equalsIgnoreCase("doc") || strExt.equalsIgnoreCase("docx"))
//			{
//
//				response_p.setContentType("application/msword");
//				response_p.setHeader("Content-disposition", "attachment; filename=" + strFtpFolderName + "" + strFileName);
//
//			}
//			else if (strExt.equalsIgnoreCase("rdf"))
//			{
//
//				response_p.setContentType("application/msword");
//				response_p.setHeader("Content-disposition", "attachment; filename=" + strFtpFolderName + "" + strFileName);
//
//			}
//			else if (strExt.equalsIgnoreCase("rtf"))
//			{
//
//				response_p.setContentType("application/msword");
//				response_p.setHeader("Content-disposition", "attachment; filename=" + strFtpFolderName + "" + strFileName);
//
//			}
//			else
//			{
//
//				response_p.setContentType("text/html;charset=utf-8");
//				response_p.setHeader("Content-disposition", "attachment; filename=" + strFtpFolderName + "" + strFileName);
//
//			}
//			/** **************************************************************** */
//
//			String sessionFtpAddress = "10.0.1.78/ftpserver"; // populate from session 10.0.5.152/ftpserver
//			String logicalName = sessionFtpAddress.replace('/', '#').split("#")[1];
//			String Fileurl = "ftp://" + sessionFtpAddress + "/" + strFtpFolderName;
//
//			System.out.println("test:::" + Fileurl);
//
//			URL urlftp = new URL(Fileurl + "/" + strFileName);
//			URLConnection urlc = urlftp.openConnection();
//			InputStream io = urlc.getInputStream();
//
//			FileOutputStream fos = new FileOutputStream(strFileName);
//			byte[] buf = new byte[4096];
//			int read = 0;
//			while ((read = io.read(buf)) > 0)
//			{
//				fos.write(buf, 0, read);
//			}
//
//			f = new File(strFileName);
//
//			if (!f.isFile())
//			{
//
//				throw new Exception("Invalid File Path");
//			}
//
//			fis = new FileInputStream(f);
//
//			while (fis.read(fileContent) != -1)
//			{
//
//				response_p.getOutputStream().write(fileContent);
//			}
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//			strmsgText = "mms.master.PreTechApprovalTransDATA.getUploadedFile --> " + e.getMessage();
//			HisException eObj = new HisException("mms", "PreTechApprovalTransDATA->getUploadedFile()", strmsgText);
//			ItemWarrantyDtlsFB_p.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
//
//			eObj = null;
//		}
//		finally
//		{
//
//			if (f != null) f = null;
//			if (fis != null) fis = null;
//		}
//	}
//
//	/**
//	 * Method is Used to Save Data into table HEMT_ITEM_MC_DTL
//	 * 
//	 * @param ItemWarrantyDtlsFB_p
//	 * @param request_p
//	 */
//	public static void saveData(ItemWarrantyDtlsFB ItemWarrantyDtlsFB_p, HttpServletRequest request_p)
//	{
//		String strErrMsg;
//
//		String strSeatId_p;
//		String strHospitalCode_p;
//		UserVO userVo = null;
//
//		WarrantyDtlVO hsttWarrantyDtlVO = null;
//		String strFileId = "0";
//		HisUtil hisutil = null;
//		BmedConfigUtil bmed = null;
//		String strFtpFolderName = "";
//		try
//		{
//			bmed = new BmedConfigUtil();
//			hisutil = new HisUtil("BMED Transactions", "ItemWarrantyTransDATA");
//			hsttWarrantyDtlVO = new WarrantyDtlVO();
//			userVo = ControllerUTIL.getUserVO(request_p);
//			strHospitalCode_p = userVo.getHospitalCode();
//			strSeatId_p = userVo.getSeatId();
//			FormFile myFile = ItemWarrantyDtlsFB_p.getStrLocation();
//
//			strFileId = BmedTransBO.getFileName(myFile, strHospitalCode_p, "2");
//
//			// Testing data to Save record in FTP Server
//			strFtpFolderName = bmed.getStrFtpFileFolder("15", strHospitalCode_p);
//
//			if (strFtpFolderName.equals("") || strFtpFolderName == null)
//			{
//				strFtpFolderName = "bmedDocs";
//			}
//			strFtpFolderName = "bmedDocs";
//			String sessionFtpAddress = "10.0.1.78/ftpserver"; // populate from session 10.0.5.152/ftpserver
//
//			sessionFtpAddress = FTPStaticConfigurator.bmedpath;
//
//			String logicalName = sessionFtpAddress.replace('/', '#').split("#")[1];
//			String Fileurl = "ftp://" + sessionFtpAddress + "/" + strFtpFolderName;
//			// String Fileurl= "ftp://"+sessionFtpAddress+"/"+logicalName+"/"+strFtpFolderName;
//			System.out.println("File Url:::::" + Fileurl);
//			String Ftpurl = "ftp://" + sessionFtpAddress + "/" + strFtpFolderName;
//			System.out.println("Ftp Url::::" + Ftpurl);
//			String FileName = strFileId; // generated by us at run time (Adil Wasi)
//			System.out.println("File Name::::" + strFileId);
//			SaveFileInFtpGlobal.saveFileToLocation(Fileurl, Ftpurl, FileName, myFile.getInputStream());
//			System.out.println("file Created Successfully");
//
//			/* End Test Data */
//
//			ItemWarrantyDtlsFB_p.setStrUploadFileId(strFileId);
//
//			if (ItemWarrantyDtlsFB_p.getStrTermsAndCond().equals("") || ItemWarrantyDtlsFB_p.getStrTermsAndCond().equals(" "))
//			{
//				ItemWarrantyDtlsFB_p.setStrTermsAndCond("---");
//			}
//			/*
//			 * System.out.println("In Data"); System.out.println("Check Wheteher Item or
//			 * Non-Item:::"+ItemWarrantyDtlsFB_p.getStrCheck()); //System.out.println("Dept
//			 * ID::"+ItemWarrantyDtlsFB_p.getStrDeptId()); //System.out.println("Store
//			 * ID::"+ItemWarrantyDtlsFB_p.getStrStoreId()); System.out.println("Engg Item
//			 * Type::"+ItemWarrantyDtlsFB_p.getStrEnggItemTypeId()); System.out.println("Engg Item Sub
//			 * Type::"+ItemWarrantyDtlsFB_p.getStrEnggItemSubTypeId()); System.out.println("Item Brand
//			 * Id::"+ItemWarrantyDtlsFB_p.getStrItemBrandId()); System.out.println("Contr Supp
//			 * Id::"+ItemWarrantyDtlsFB_p.getStrSupplierId()); System.out.println("Warranty Start
//			 * Date::"+ItemWarrantyDtlsFB_p.getStrWarrantyStartDate()); System.out.println("Warranty
//			 * UpTo::"+ItemWarrantyDtlsFB_p.getStrWarrantyUpTo()); System.out.println("Warranty
//			 * Id:::"+ItemWarrantyDtlsFB_p.getStrWarrantyId()); System.out.println("Tender
//			 * No::"+ItemWarrantyDtlsFB_p.getStrTenderNo()); System.out.println("Tender
//			 * Date::"+ItemWarrantyDtlsFB_p.getStrTenderDate()); System.out.println("Order
//			 * No::"+ItemWarrantyDtlsFB_p.getStrOrderNo()); System.out.println("Order
//			 * Date::"+ItemWarrantyDtlsFB_p.getStrOrderDate());
//			 * System.out.println("remarks:::"+ItemWarrantyDtlsFB_p.getStrRemarks()); System.out.println("term
//			 * Cod:::"+ItemWarrantyDtlsFB_p.getStrTermsAndCond());
//			 */
//
//			// HSTNUM_STORE_ID^HSTNUM_ITEM_ID^HSTNUM_ITEMBRAND_ID^HSTSTR_BATCH_NO^HSTSTR_ITEM_SL_NO^GNUM_HOSPITAL_CODE^HSTNUM_STOCK_STATUS_CODE
//			hsttWarrantyDtlVO.setStrMode("1");
//			hsttWarrantyDtlVO.setStrSlNo("0"); // Function Genrated
//			hsttWarrantyDtlVO.setStrTermsAndCondition(ItemWarrantyDtlsFB_p.getStrTermsAndCond());
//			if (ItemWarrantyDtlsFB_p.getStrCheck().equals("1"))
//			{
//				// System.out.println("Stock Info:::"+ItemWarrantyDtlsFB_p.getStrStockInfoVal());
//				// System.out.println("Item Sl No::::"+ItemWarrantyDtlsFB_p.getStrStockInfoVal().split("\\^")[4]);
//				// System.out.println("Batch No::::"+ItemWarrantyDtlsFB_p.getStrStockInfoVal().split("\\^")[3]);
//				hsttWarrantyDtlVO.setStrItemId(ItemWarrantyDtlsFB_p.getStrStockInfoVal().split("\\^")[1]);
//				hsttWarrantyDtlVO.setStrItemBrandId(ItemWarrantyDtlsFB_p.getStrStockInfoVal().split("\\^")[2]);
//				hsttWarrantyDtlVO.setStrIsItem("1");
//				hsttWarrantyDtlVO.setStrItemSlNo(ItemWarrantyDtlsFB_p.getStrStockInfoVal().split("\\^")[4]);
//				hsttWarrantyDtlVO.setStrBatchSlNo(ItemWarrantyDtlsFB_p.getStrStockInfoVal().split("\\^")[3]);
//			}
//			else
//			{
//				hsttWarrantyDtlVO.setStrItemId(ItemWarrantyDtlsFB_p.getStrItemBrandId()); /* In Case of Non-Item */
//				hsttWarrantyDtlVO.setStrItemBrandId("0");
//				hsttWarrantyDtlVO.setStrIsItem("0");
//				hsttWarrantyDtlVO.setStrItemSlNo("0");
//				hsttWarrantyDtlVO.setStrBatchSlNo("0");
//			}
//			hsttWarrantyDtlVO.setStrIsValid("1");
//			hsttWarrantyDtlVO.setStrSeatId(strSeatId_p);
//			hsttWarrantyDtlVO.setStrHospitalCode(strHospitalCode_p);
//			hsttWarrantyDtlVO.setStrTenderNo(ItemWarrantyDtlsFB_p.getStrTenderNo());
//			hsttWarrantyDtlVO.setStrUploadNo(ItemWarrantyDtlsFB_p.getStrDocRefNo()); // Getting By Function
//			hsttWarrantyDtlVO.setStrWarrentyDate(ItemWarrantyDtlsFB_p.getStrWarrantyStartDate());
//			hsttWarrantyDtlVO.setStrWarrentyUpto(ItemWarrantyDtlsFB_p.getStrWarrantyUpTo());
//			hsttWarrantyDtlVO.setStrWarrentyUptoUnit(ItemWarrantyDtlsFB_p.getStrWarrantyId());
//			hsttWarrantyDtlVO.setStrTermsAndCondition(ItemWarrantyDtlsFB_p.getStrTermsAndCond());
//			hsttWarrantyDtlVO.setStrDocRefNo(strFileId);
//			hsttWarrantyDtlVO.setStrTenderDate(ItemWarrantyDtlsFB_p.getStrTenderDate());
//			hsttWarrantyDtlVO.setStrDocRefDate(ItemWarrantyDtlsFB_p.getStrDocRefDate()); // SYSDATE
//			hsttWarrantyDtlVO.setStrOrderNo(ItemWarrantyDtlsFB_p.getStrOrderNo());
//			hsttWarrantyDtlVO.setStrOrderDate(ItemWarrantyDtlsFB_p.getStrOrderDate());
//			hsttWarrantyDtlVO.setStrManufId(ItemWarrantyDtlsFB_p.getStrSupplierId());
//			hsttWarrantyDtlVO.setStrRemarks(ItemWarrantyDtlsFB_p.getStrRemarks());
//			hsttWarrantyDtlVO.setStrFinancialStartYear(hisutil.getASDate("dd-MMM-yyyy")); // Get By Function
//			hsttWarrantyDtlVO.setStrFinancialEndYear(hisutil.getASDate("dd-MMM-yyyy")); // Get By Function
//
//			hsttWarrantyDtlVO.setStrCancelId(""); // Only in Case of Cancel
//			hsttWarrantyDtlVO.setStrCancelDate("");// Only in Case of Cancel
//			hsttWarrantyDtlVO.setStrCancelRemarks("");// Only in Case of Cancel
//			hsttWarrantyDtlVO.setStrExtTermsAndCondition(""); // Only in Case of Warranty Extend
//			hsttWarrantyDtlVO.setStrExtendedStartDate(""); // Only in Case of Warranty Extend
//			hsttWarrantyDtlVO.setStrIsExtended("0"); // Only in Case of Warranty Extend
//			hsttWarrantyDtlVO.setStrExtendedUpto(""); // Only in Case of Warranty Extend
//			hsttWarrantyDtlVO.setStrExtendedUptoUnit(""); // Only in Case of Warranty Extend
//			hsttWarrantyDtlVO.setStrExtUploadNo("00");// Only in Case of Warranty Extend
//			hsttWarrantyDtlVO.setStrExtDocRefNo(""); // Only in Case of Warranty Extend
//			hsttWarrantyDtlVO.setStrExtDocRefDate(hisutil.getASDate("dd-MMM-yyyy"));// Only in Case of Warranty Extend
//
//			/** Calling BO Method Here* */
//			BmedTransBO.saveItemWarrantyDetails(hsttWarrantyDtlVO);
//
//			if (hsttWarrantyDtlVO.getStrMsgType().equals("0"))
//			{
//				ItemWarrantyDtlsFB_p.setStrNormalMsg("Data Saved Successfully");
//			}
//
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//			strErrMsg = "ItemWarrantyDtlsTransDATA.saveData() --> " + e.getMessage();
//			HisException eObj = new HisException("BMED", "ItemWarrantyDtlsDATA", strErrMsg);
//			ItemWarrantyDtlsFB_p.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
//
//			eObj = null;
//		}
//
//	}
//
//	/**
//	 * this method is used Renew Data
//	 * 
//	 * @param ItemWarrantyDtlsFB_p
//	 * @param request_p
//	 */
//	public static void saveExtendWarrantyData(ItemWarrantyDtlsFB ItemWarrantyDtlsFB_p, HttpServletRequest request_p)
//	{
//		String strErrMsg;
//		String strSeatId_p;
//		String strHospitalCode_p;
//		UserVO userVo = null;
//		BmedConfigUtil bmed = null;
//		// AttachFileGlobal fs=null;
//		WarrantyDtlVO hsttWarrantyDtlVO = null;
//		String strFileId;
//		String strFtpFolderName = "";
//		HisUtil hisutil;
//		try
//		{
//			hsttWarrantyDtlVO = new WarrantyDtlVO();
//			bmed = new BmedConfigUtil();
//			userVo = ControllerUTIL.getUserVO(request_p);
//			strHospitalCode_p = userVo.getHospitalCode();
//			strSeatId_p = userVo.getSeatId();
//			hisutil = new HisUtil("BMED Transactions", "ItemWarrantyTransDATA");
//
//			FormFile myFile = ItemWarrantyDtlsFB_p.getStrLocation();
//			strFileId = BmedTransBO.getFileName(myFile, strHospitalCode_p, "2");
//			System.out.println("File ID::::" + strFileId);
//
//			/* Testing data to Save record in FTP Server */
//			strFtpFolderName = bmed.getStrFtpFileFolder("15", strHospitalCode_p);
//			strFtpFolderName = "bmedDocs";
//			if (strFtpFolderName.equals("") || strFtpFolderName == null)
//			{
//				strFtpFolderName = "bmedDocs";
//			}
//			String sessionFtpAddress = "10.0.1.78"; // populate from session 10.0.5.152/ftpserver
//			sessionFtpAddress = FTPStaticConfigurator.bmedpath;
//
//			String logicalName = sessionFtpAddress.replace('/', '#').split("#")[1];
//			String Fileurl = "ftp://" + sessionFtpAddress + "/" + strFtpFolderName;
//			// String Fileurl= "ftp://"+sessionFtpAddress+"/"+logicalName+"/"+strFtpFolderName;
//			System.out.println("File Url:::::" + Fileurl);
//			String Ftpurl = "ftp://" + sessionFtpAddress + "/" + strFtpFolderName;
//			System.out.println("Ftp Url::::" + Ftpurl);
//			String FileName = strFileId; // generated by us at run time (Adil Wasi)
//			System.out.println("File Name::::" + strFileId);
//			SaveFileInFtpGlobal.saveFileToLocation(Fileurl, Ftpurl, FileName, myFile.getInputStream());
//			// System.out.println("file Created Successfully");
//
//			/* End Test Data */
//
//			ItemWarrantyDtlsFB_p.setStrUploadFileId(strFileId);
//			hsttWarrantyDtlVO.setStrSeatId(strSeatId_p);
//
//			if (ItemWarrantyDtlsFB_p.getStrExtndTermsAndCond().equals("") || ItemWarrantyDtlsFB_p.getStrExtndTermsAndCond().equals(" "))
//			{
//				ItemWarrantyDtlsFB_p.setStrExtndTermsAndCond("---");
//			}
//			/*
//			 * 
//			 * private String strIsExtendPK; 0 1 2 3 4 5 6 7 // Item Id ^ Item BrandId ^ Batch No ^ Hosp Code ^ Item Sl No ^
//			 * Manuf Id ^ Manu Fat Sl No ^ Sl No
//			 */
//			// System.out.println("File ID::::"+strFileId);
//			// System.out.println("Upload File name::::"+myFile.getFileName());
//			// System.out.println("Check Wheteher Item or Non-Item:::"+ItemWarrantyDtlsFB_p.getStrCheck());
//			// System.out.println("Terms & Cond:::"+ItemWarrantyDtlsFB_p.getStrExtndTermsAndCond());
//			// System.out.println("Strat Date::::"+ItemWarrantyDtlsFB_p.getStrExtndWarrantyStartDate());
//			// System.out.println("Extnd Up To::::"+ItemWarrantyDtlsFB_p.getStrExtndWarrantyUpTo());
//			// System.out.println("Entnd Up To Unit::::"+ItemWarrantyDtlsFB_p.getStrExtndWarrantyId());
//			// System.out.println("Doc Ref No::::"+ItemWarrantyDtlsFB_p.getStrDocRefNo());
//			// System.out.println("Doc Ref Date::::"+ItemWarrantyDtlsFB_p.getStrDocRefDate());
//			hsttWarrantyDtlVO.setStrMode("2");
//			if (ItemWarrantyDtlsFB_p.getStrCheck().equals("1"))
//			{
//				hsttWarrantyDtlVO.setStrIsItem("1");
//			}
//			else
//			{
//				hsttWarrantyDtlVO.setStrIsItem("0");
//			}
//
//			hsttWarrantyDtlVO.setStrIsValid("1");
//			hsttWarrantyDtlVO.setStrItemId(ItemWarrantyDtlsFB_p.getStrIsExtendPK().split("\\^")[0]);
//			hsttWarrantyDtlVO.setStrItemBrandId(ItemWarrantyDtlsFB_p.getStrIsExtendPK().split("\\^")[1]);
//			hsttWarrantyDtlVO.setStrItemSlNo(ItemWarrantyDtlsFB_p.getStrIsExtendPK().split("\\^")[4]);
//			hsttWarrantyDtlVO.setStrBatchSlNo(ItemWarrantyDtlsFB_p.getStrIsExtendPK().split("\\^")[2]);
//			hsttWarrantyDtlVO.setStrSlNo(ItemWarrantyDtlsFB_p.getStrIsExtendPK().split("\\^")[7]);
//
//			hsttWarrantyDtlVO.setStrSeatId(strSeatId_p);
//			hsttWarrantyDtlVO.setStrHospitalCode(strHospitalCode_p);
//
//			hsttWarrantyDtlVO.setStrExtTermsAndCondition(ItemWarrantyDtlsFB_p.getStrExtndTermsAndCond());
//			hsttWarrantyDtlVO.setStrExtendedStartDate(ItemWarrantyDtlsFB_p.getStrExtndWarrantyStartDate());
//			hsttWarrantyDtlVO.setStrIsExtended("1");
//			hsttWarrantyDtlVO.setStrExtendedUpto(ItemWarrantyDtlsFB_p.getStrExtndWarrantyUpTo());
//			hsttWarrantyDtlVO.setStrExtendedUptoUnit(ItemWarrantyDtlsFB_p.getStrExtndWarrantyId());
//			hsttWarrantyDtlVO.setStrExtUploadNo(ItemWarrantyDtlsFB_p.getStrDocRefNo());
//			hsttWarrantyDtlVO.setStrExtDocRefNo(strFileId);
//			hsttWarrantyDtlVO.setStrExtDocRefDate(ItemWarrantyDtlsFB_p.getStrDocRefDate());
//			hsttWarrantyDtlVO.setStrRemarks(ItemWarrantyDtlsFB_p.getStrExtndRemarks());
//
//			// Set Default Value [these dummy Value not use in final Update Statement ]
//			hsttWarrantyDtlVO.setStrFinancialStartYear(hisutil.getASDate("dd-MMM-yyyy")); // Get By Function
//			hsttWarrantyDtlVO.setStrFinancialEndYear(hisutil.getASDate("dd-MMM-yyyy")); // Get By Function
//			hsttWarrantyDtlVO.setStrWarrentyDate(hisutil.getASDate("dd-MMM-yyyy"));
//			hsttWarrantyDtlVO.setStrFinancialStartYear(hisutil.getASDate("dd-MMM-yyyy"));
//			hsttWarrantyDtlVO.setStrDocRefDate(hisutil.getASDate("dd-MMM-yyyy"));
//			hsttWarrantyDtlVO.setStrTenderDate(hisutil.getASDate("dd-MMM-yyyy"));
//			hsttWarrantyDtlVO.setStrOrderDate(hisutil.getASDate("dd-MMM-yyyy"));
//			hsttWarrantyDtlVO.setStrCancelDate(hisutil.getASDate("dd-MMM-yyyy"));
//
//			/** Calling BO Method Here* */
//			BmedTransBO.saveItemWarrantyDetails(hsttWarrantyDtlVO);
//
//			if (hsttWarrantyDtlVO.getStrMsgType().equals("0"))
//			{
//				ItemWarrantyDtlsFB_p.setStrNormalMsg("Data Extended Successfully");
//			}
//
//		}
//		catch (Exception e)
//		{
//			// e.printStackTrace();
//
//			strErrMsg = "ItemWarrantyDtlsTransDATA.saveExtendWarrantyData() --> " + e.getMessage();
//			HisException eObj = new HisException("BMED", "ItemWarrantyDtlsDATA", strErrMsg);
//			ItemWarrantyDtlsFB_p.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
//
//			eObj = null;
//		}
//
//	}

	
	
//	public static void saveFileToLocation(String htmlString,String pdfFileurl, String pdfFtpurl, String pdfFileName) throws IOException, FtpException
//	{
//		System.out.println("Step 1 saveFileToLocation");
//		/*InputStream in = new ByteArrayInputStream(imageUtilityVO.getImageByteArray());
//		BufferedImage image;
//		*/
//		
//		System.out.println("inside DAO func---printReportInPdfFormat-->ResultEntryVOGroupByValidatedBy--------->saveFileToLocation");
//		Document document = new Document(); 
//		InputStream s = new ByteArrayInputStream(htmlString.getBytes()); 
//		try {
//			
//						
//			URL urlftp =new URL(pdfFtpurl+"/"+pdfFileName);
//			URLConnection urlc=	urlc= urlftp.openConnection();
//			BufferedOutputStream bos = null ;
//			try
//			{
//				bos=new BufferedOutputStream(urlc.getOutputStream());
//				
//			}
//			catch(Exception ex)
//			{
//				System.out.println("  catch ");
//			}
//			System.out.println("urlftp  :"+urlc);
//			if(bos==null)
//			{
//				String[] folder=pdfFileurl.replace("/", "#").split("#");
//				createDirectoryStructure(folder[2],folder);
//				bos=new BufferedOutputStream(urlc.getOutputStream());
//			}
//			System.out.println("urlftp  :"+urlc);
//			
//			try {
//				
//				PdfWriter.getInstance(document,	bos);
//				document.open();
//				 List<Element> elementlist = HTMLWorker.parseToList(new InputStreamReader(s), new StyleSheet()); 
//			        for (int i = 0; i < elementlist.size(); i++) {
//						Element element = (Element)elementlist.get(i); 
//			        if(elementlist.size()>0) { 
//			                document.add(element);  
//			        } 
//			    	System.out.println("before closing"); 
//					}
//				
//			} catch (DocumentException e) {
//				e.printStackTrace();
//			}
//			document.close();
//			bos.close();
//			
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//			throw new IOException();
//		}
//		
//	}

	

//	/**
//	 * here we get Up-Load file
//	 * 
//	 * @param ItemWarrantyDtlsFB_p
//	 * @param request_p
//	 * @param response_p
//	 */
//	public static void getUploadedFile(ItemWarrantyDtlsFB ItemWarrantyDtlsFB_p, HttpServletRequest request_p, HttpServletResponse response_p)
//	{
//
//		String strmsgText = null;
//		String strFileName = "";
//		File f = null;
//		FileInputStream fis = null;
//		byte[] fileContent = new byte[1024];
//		BmedConfigUtil bmed = null;
//		String strFtpFolderName = "";
//		UserVO userVo = null;
//
//		try
//		{
//
//			bmed = new BmedConfigUtil();
//			userVo = ControllerUTIL.getUserVO(request_p);
//			strFtpFolderName = bmed.getStrFtpFileFolder("15", userVo.getHospitalCode());
//
//			if (strFtpFolderName.equals("") || strFtpFolderName == null)
//			{
//				strFtpFolderName = "adil123";
//			}
//
//			strFileName = ItemWarrantyDtlsFB_p.getStrUploadFileId();
//
//			// System.out.println("File Name::::::"+ItemWarrantyDtlsFB_p.getStrUploadFileId());
//			String[] strTemp = strFileName.replace(".", "#").split("#");
//			String strExt = strTemp[strTemp.length - 1];
//
//			if (strExt.equalsIgnoreCase("txt") || strExt.equalsIgnoreCase("txt"))
//			{
//
//				response_p.setContentType("application/txt");
//				response_p.setHeader("Content-disposition", " filename=" + strFtpFolderName + "" + strFileName);
//
//			}
//			else if (strExt.equalsIgnoreCase("pdf"))
//			{
//
//				response_p.setContentType("application/pdf");
//				response_p.setHeader("Content-disposition", "attachment; filename=" + strFtpFolderName + "" + strFileName);
//
//			}
//			else if (strExt.equalsIgnoreCase("html") || strExt.equalsIgnoreCase("htm"))
//			{
//
//				response_p.setContentType("text/html;charset=utf-8");
//				response_p.setHeader("Content-disposition", "attachment; filename=" + strFtpFolderName + "" + strFileName);
//
//			}
//			else if (strExt.equalsIgnoreCase("xml"))
//			{
//
//				response_p.setContentType("application/xml");
//				response_p.setHeader("Content-disposition", "attachment; filename=" + strFtpFolderName + "" + strFileName);
//
//			}
//			else if (strExt.equalsIgnoreCase("doc") || strExt.equalsIgnoreCase("docx"))
//			{
//
//				response_p.setContentType("application/msword");
//				response_p.setHeader("Content-disposition", "attachment; filename=" + strFtpFolderName + "" + strFileName);
//
//			}
//			else if (strExt.equalsIgnoreCase("rdf"))
//			{
//
//				response_p.setContentType("application/msword");
//				response_p.setHeader("Content-disposition", "attachment; filename=" + strFtpFolderName + "" + strFileName);
//
//			}
//			else if (strExt.equalsIgnoreCase("rtf"))
//			{
//
//				response_p.setContentType("application/msword");
//				response_p.setHeader("Content-disposition", "attachment; filename=" + strFtpFolderName + "" + strFileName);
//
//			}
//			else
//			{
//
//				response_p.setContentType("text/html;charset=utf-8");
//				response_p.setHeader("Content-disposition", "attachment; filename=" + strFtpFolderName + "" + strFileName);
//
//			}
//			/** **************************************************************** */
//
//			String sessionFtpAddress = "10.0.1.78/ftpserver"; // populate from session 10.0.5.152/ftpserver
//			String logicalName = sessionFtpAddress.replace('/', '#').split("#")[1];
//			String Fileurl = "ftp://" + sessionFtpAddress + "/" + strFtpFolderName;
//
//			System.out.println("test:::" + Fileurl);
//
//			URL urlftp = new URL(Fileurl + "/" + strFileName);
//			URLConnection urlc = urlftp.openConnection();
//			InputStream io = urlc.getInputStream();
//
//			FileOutputStream fos = new FileOutputStream(strFileName);
//			byte[] buf = new byte[4096];
//			int read = 0;
//			while ((read = io.read(buf)) > 0)
//			{
//				fos.write(buf, 0, read);
//			}
//
//			f = new File(strFileName);
//
//			if (!f.isFile())
//			{
//
//				throw new Exception("Invalid File Path");
//			}
//
//			fis = new FileInputStream(f);
//
//			while (fis.read(fileContent) != -1)
//			{
//
//				response_p.getOutputStream().write(fileContent);
//			}
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//			strmsgText = "mms.master.PreTechApprovalTransDATA.getUploadedFile --> " + e.getMessage();
//			HisException eObj = new HisException("mms", "PreTechApprovalTransDATA->getUploadedFile()", strmsgText);
//			ItemWarrantyDtlsFB_p.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
//
//			eObj = null;
//		}
//		finally
//		{
//
//			if (f != null) f = null;
//			if (fis != null) fis = null;
//		}
//	}
//
//	/**
//	 * Method is Used to Save Data into table HEMT_ITEM_MC_DTL
//	 * 
//	 * @param ItemWarrantyDtlsFB_p
//	 * @param request_p
//	 */
//	public static void saveData(ItemWarrantyDtlsFB ItemWarrantyDtlsFB_p, HttpServletRequest request_p)
//	{
//		String strErrMsg;
//
//		String strSeatId_p;
//		String strHospitalCode_p;
//		UserVO userVo = null;
//
//		WarrantyDtlVO hsttWarrantyDtlVO = null;
//		String strFileId = "0";
//		HisUtil hisutil = null;
//		BmedConfigUtil bmed = null;
//		String strFtpFolderName = "";
//		try
//		{
//			bmed = new BmedConfigUtil();
//			hisutil = new HisUtil("BMED Transactions", "ItemWarrantyTransDATA");
//			hsttWarrantyDtlVO = new WarrantyDtlVO();
//			userVo = ControllerUTIL.getUserVO(request_p);
//			strHospitalCode_p = userVo.getHospitalCode();
//			strSeatId_p = userVo.getSeatId();
//			FormFile myFile = ItemWarrantyDtlsFB_p.getStrLocation();
//
//			strFileId = BmedTransBO.getFileName(myFile, strHospitalCode_p, "2");
//
//			// Testing data to Save record in FTP Server
//			strFtpFolderName = bmed.getStrFtpFileFolder("15", strHospitalCode_p);
//
//			if (strFtpFolderName.equals("") || strFtpFolderName == null)
//			{
//				strFtpFolderName = "bmedDocs";
//			}
//			strFtpFolderName = "bmedDocs";
//			String sessionFtpAddress = "10.0.1.78/ftpserver"; // populate from session 10.0.5.152/ftpserver
//
//			sessionFtpAddress = FTPStaticConfigurator.bmedpath;
//
//			String logicalName = sessionFtpAddress.replace('/', '#').split("#")[1];
//			String Fileurl = "ftp://" + sessionFtpAddress + "/" + strFtpFolderName;
//			// String Fileurl= "ftp://"+sessionFtpAddress+"/"+logicalName+"/"+strFtpFolderName;
//			System.out.println("File Url:::::" + Fileurl);
//			String Ftpurl = "ftp://" + sessionFtpAddress + "/" + strFtpFolderName;
//			System.out.println("Ftp Url::::" + Ftpurl);
//			String FileName = strFileId; // generated by us at run time (Adil Wasi)
//			System.out.println("File Name::::" + strFileId);
//			SaveFileInFtpGlobal.saveFileToLocation(Fileurl, Ftpurl, FileName, myFile.getInputStream());
//			System.out.println("file Created Successfully");
//
//			/* End Test Data */
//
//			ItemWarrantyDtlsFB_p.setStrUploadFileId(strFileId);
//
//			if (ItemWarrantyDtlsFB_p.getStrTermsAndCond().equals("") || ItemWarrantyDtlsFB_p.getStrTermsAndCond().equals(" "))
//			{
//				ItemWarrantyDtlsFB_p.setStrTermsAndCond("---");
//			}
//			/*
//			 * System.out.println("In Data"); System.out.println("Check Wheteher Item or
//			 * Non-Item:::"+ItemWarrantyDtlsFB_p.getStrCheck()); //System.out.println("Dept
//			 * ID::"+ItemWarrantyDtlsFB_p.getStrDeptId()); //System.out.println("Store
//			 * ID::"+ItemWarrantyDtlsFB_p.getStrStoreId()); System.out.println("Engg Item
//			 * Type::"+ItemWarrantyDtlsFB_p.getStrEnggItemTypeId()); System.out.println("Engg Item Sub
//			 * Type::"+ItemWarrantyDtlsFB_p.getStrEnggItemSubTypeId()); System.out.println("Item Brand
//			 * Id::"+ItemWarrantyDtlsFB_p.getStrItemBrandId()); System.out.println("Contr Supp
//			 * Id::"+ItemWarrantyDtlsFB_p.getStrSupplierId()); System.out.println("Warranty Start
//			 * Date::"+ItemWarrantyDtlsFB_p.getStrWarrantyStartDate()); System.out.println("Warranty
//			 * UpTo::"+ItemWarrantyDtlsFB_p.getStrWarrantyUpTo()); System.out.println("Warranty
//			 * Id:::"+ItemWarrantyDtlsFB_p.getStrWarrantyId()); System.out.println("Tender
//			 * No::"+ItemWarrantyDtlsFB_p.getStrTenderNo()); System.out.println("Tender
//			 * Date::"+ItemWarrantyDtlsFB_p.getStrTenderDate()); System.out.println("Order
//			 * No::"+ItemWarrantyDtlsFB_p.getStrOrderNo()); System.out.println("Order
//			 * Date::"+ItemWarrantyDtlsFB_p.getStrOrderDate());
//			 * System.out.println("remarks:::"+ItemWarrantyDtlsFB_p.getStrRemarks()); System.out.println("term
//			 * Cod:::"+ItemWarrantyDtlsFB_p.getStrTermsAndCond());
//			 */
//
//			// HSTNUM_STORE_ID^HSTNUM_ITEM_ID^HSTNUM_ITEMBRAND_ID^HSTSTR_BATCH_NO^HSTSTR_ITEM_SL_NO^GNUM_HOSPITAL_CODE^HSTNUM_STOCK_STATUS_CODE
//			hsttWarrantyDtlVO.setStrMode("1");
//			hsttWarrantyDtlVO.setStrSlNo("0"); // Function Genrated
//			hsttWarrantyDtlVO.setStrTermsAndCondition(ItemWarrantyDtlsFB_p.getStrTermsAndCond());
//			if (ItemWarrantyDtlsFB_p.getStrCheck().equals("1"))
//			{
//				// System.out.println("Stock Info:::"+ItemWarrantyDtlsFB_p.getStrStockInfoVal());
//				// System.out.println("Item Sl No::::"+ItemWarrantyDtlsFB_p.getStrStockInfoVal().split("\\^")[4]);
//				// System.out.println("Batch No::::"+ItemWarrantyDtlsFB_p.getStrStockInfoVal().split("\\^")[3]);
//				hsttWarrantyDtlVO.setStrItemId(ItemWarrantyDtlsFB_p.getStrStockInfoVal().split("\\^")[1]);
//				hsttWarrantyDtlVO.setStrItemBrandId(ItemWarrantyDtlsFB_p.getStrStockInfoVal().split("\\^")[2]);
//				hsttWarrantyDtlVO.setStrIsItem("1");
//				hsttWarrantyDtlVO.setStrItemSlNo(ItemWarrantyDtlsFB_p.getStrStockInfoVal().split("\\^")[4]);
//				hsttWarrantyDtlVO.setStrBatchSlNo(ItemWarrantyDtlsFB_p.getStrStockInfoVal().split("\\^")[3]);
//			}
//			else
//			{
//				hsttWarrantyDtlVO.setStrItemId(ItemWarrantyDtlsFB_p.getStrItemBrandId()); /* In Case of Non-Item */
//				hsttWarrantyDtlVO.setStrItemBrandId("0");
//				hsttWarrantyDtlVO.setStrIsItem("0");
//				hsttWarrantyDtlVO.setStrItemSlNo("0");
//				hsttWarrantyDtlVO.setStrBatchSlNo("0");
//			}
//			hsttWarrantyDtlVO.setStrIsValid("1");
//			hsttWarrantyDtlVO.setStrSeatId(strSeatId_p);
//			hsttWarrantyDtlVO.setStrHospitalCode(strHospitalCode_p);
//			hsttWarrantyDtlVO.setStrTenderNo(ItemWarrantyDtlsFB_p.getStrTenderNo());
//			hsttWarrantyDtlVO.setStrUploadNo(ItemWarrantyDtlsFB_p.getStrDocRefNo()); // Getting By Function
//			hsttWarrantyDtlVO.setStrWarrentyDate(ItemWarrantyDtlsFB_p.getStrWarrantyStartDate());
//			hsttWarrantyDtlVO.setStrWarrentyUpto(ItemWarrantyDtlsFB_p.getStrWarrantyUpTo());
//			hsttWarrantyDtlVO.setStrWarrentyUptoUnit(ItemWarrantyDtlsFB_p.getStrWarrantyId());
//			hsttWarrantyDtlVO.setStrTermsAndCondition(ItemWarrantyDtlsFB_p.getStrTermsAndCond());
//			hsttWarrantyDtlVO.setStrDocRefNo(strFileId);
//			hsttWarrantyDtlVO.setStrTenderDate(ItemWarrantyDtlsFB_p.getStrTenderDate());
//			hsttWarrantyDtlVO.setStrDocRefDate(ItemWarrantyDtlsFB_p.getStrDocRefDate()); // SYSDATE
//			hsttWarrantyDtlVO.setStrOrderNo(ItemWarrantyDtlsFB_p.getStrOrderNo());
//			hsttWarrantyDtlVO.setStrOrderDate(ItemWarrantyDtlsFB_p.getStrOrderDate());
//			hsttWarrantyDtlVO.setStrManufId(ItemWarrantyDtlsFB_p.getStrSupplierId());
//			hsttWarrantyDtlVO.setStrRemarks(ItemWarrantyDtlsFB_p.getStrRemarks());
//			hsttWarrantyDtlVO.setStrFinancialStartYear(hisutil.getASDate("dd-MMM-yyyy")); // Get By Function
//			hsttWarrantyDtlVO.setStrFinancialEndYear(hisutil.getASDate("dd-MMM-yyyy")); // Get By Function
//
//			hsttWarrantyDtlVO.setStrCancelId(""); // Only in Case of Cancel
//			hsttWarrantyDtlVO.setStrCancelDate("");// Only in Case of Cancel
//			hsttWarrantyDtlVO.setStrCancelRemarks("");// Only in Case of Cancel
//			hsttWarrantyDtlVO.setStrExtTermsAndCondition(""); // Only in Case of Warranty Extend
//			hsttWarrantyDtlVO.setStrExtendedStartDate(""); // Only in Case of Warranty Extend
//			hsttWarrantyDtlVO.setStrIsExtended("0"); // Only in Case of Warranty Extend
//			hsttWarrantyDtlVO.setStrExtendedUpto(""); // Only in Case of Warranty Extend
//			hsttWarrantyDtlVO.setStrExtendedUptoUnit(""); // Only in Case of Warranty Extend
//			hsttWarrantyDtlVO.setStrExtUploadNo("00");// Only in Case of Warranty Extend
//			hsttWarrantyDtlVO.setStrExtDocRefNo(""); // Only in Case of Warranty Extend
//			hsttWarrantyDtlVO.setStrExtDocRefDate(hisutil.getASDate("dd-MMM-yyyy"));// Only in Case of Warranty Extend
//
//			/** Calling BO Method Here* */
//			BmedTransBO.saveItemWarrantyDetails(hsttWarrantyDtlVO);
//
//			if (hsttWarrantyDtlVO.getStrMsgType().equals("0"))
//			{
//				ItemWarrantyDtlsFB_p.setStrNormalMsg("Data Saved Successfully");
//			}
//
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//			strErrMsg = "ItemWarrantyDtlsTransDATA.saveData() --> " + e.getMessage();
//			HisException eObj = new HisException("BMED", "ItemWarrantyDtlsDATA", strErrMsg);
//			ItemWarrantyDtlsFB_p.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
//
//			eObj = null;
//		}
//
//	}
//
//	/**
//	 * this method is used Renew Data
//	 * 
//	 * @param ItemWarrantyDtlsFB_p
//	 * @param request_p
//	 */
//	public static void saveExtendWarrantyData(ItemWarrantyDtlsFB ItemWarrantyDtlsFB_p, HttpServletRequest request_p)
//	{
//		String strErrMsg;
//		String strSeatId_p;
//		String strHospitalCode_p;
//		UserVO userVo = null;
//		BmedConfigUtil bmed = null;
//		// AttachFileGlobal fs=null;
//		WarrantyDtlVO hsttWarrantyDtlVO = null;
//		String strFileId;
//		String strFtpFolderName = "";
//		HisUtil hisutil;
//		try
//		{
//			hsttWarrantyDtlVO = new WarrantyDtlVO();
//			bmed = new BmedConfigUtil();
//			userVo = ControllerUTIL.getUserVO(request_p);
//			strHospitalCode_p = userVo.getHospitalCode();
//			strSeatId_p = userVo.getSeatId();
//			hisutil = new HisUtil("BMED Transactions", "ItemWarrantyTransDATA");
//
//			FormFile myFile = ItemWarrantyDtlsFB_p.getStrLocation();
//			strFileId = BmedTransBO.getFileName(myFile, strHospitalCode_p, "2");
//			System.out.println("File ID::::" + strFileId);
//
//			/* Testing data to Save record in FTP Server */
//			strFtpFolderName = bmed.getStrFtpFileFolder("15", strHospitalCode_p);
//			strFtpFolderName = "bmedDocs";
//			if (strFtpFolderName.equals("") || strFtpFolderName == null)
//			{
//				strFtpFolderName = "bmedDocs";
//			}
//			String sessionFtpAddress = "10.0.1.78"; // populate from session 10.0.5.152/ftpserver
//			sessionFtpAddress = FTPStaticConfigurator.bmedpath;
//
//			String logicalName = sessionFtpAddress.replace('/', '#').split("#")[1];
//			String Fileurl = "ftp://" + sessionFtpAddress + "/" + strFtpFolderName;
//			// String Fileurl= "ftp://"+sessionFtpAddress+"/"+logicalName+"/"+strFtpFolderName;
//			System.out.println("File Url:::::" + Fileurl);
//			String Ftpurl = "ftp://" + sessionFtpAddress + "/" + strFtpFolderName;
//			System.out.println("Ftp Url::::" + Ftpurl);
//			String FileName = strFileId; // generated by us at run time (Adil Wasi)
//			System.out.println("File Name::::" + strFileId);
//			SaveFileInFtpGlobal.saveFileToLocation(Fileurl, Ftpurl, FileName, myFile.getInputStream());
//			// System.out.println("file Created Successfully");
//
//			/* End Test Data */
//
//			ItemWarrantyDtlsFB_p.setStrUploadFileId(strFileId);
//			hsttWarrantyDtlVO.setStrSeatId(strSeatId_p);
//
//			if (ItemWarrantyDtlsFB_p.getStrExtndTermsAndCond().equals("") || ItemWarrantyDtlsFB_p.getStrExtndTermsAndCond().equals(" "))
//			{
//				ItemWarrantyDtlsFB_p.setStrExtndTermsAndCond("---");
//			}
//			/*
//			 * 
//			 * private String strIsExtendPK; 0 1 2 3 4 5 6 7 // Item Id ^ Item BrandId ^ Batch No ^ Hosp Code ^ Item Sl No ^
//			 * Manuf Id ^ Manu Fat Sl No ^ Sl No
//			 */
//			// System.out.println("File ID::::"+strFileId);
//			// System.out.println("Upload File name::::"+myFile.getFileName());
//			// System.out.println("Check Wheteher Item or Non-Item:::"+ItemWarrantyDtlsFB_p.getStrCheck());
//			// System.out.println("Terms & Cond:::"+ItemWarrantyDtlsFB_p.getStrExtndTermsAndCond());
//			// System.out.println("Strat Date::::"+ItemWarrantyDtlsFB_p.getStrExtndWarrantyStartDate());
//			// System.out.println("Extnd Up To::::"+ItemWarrantyDtlsFB_p.getStrExtndWarrantyUpTo());
//			// System.out.println("Entnd Up To Unit::::"+ItemWarrantyDtlsFB_p.getStrExtndWarrantyId());
//			// System.out.println("Doc Ref No::::"+ItemWarrantyDtlsFB_p.getStrDocRefNo());
//			// System.out.println("Doc Ref Date::::"+ItemWarrantyDtlsFB_p.getStrDocRefDate());
//			hsttWarrantyDtlVO.setStrMode("2");
//			if (ItemWarrantyDtlsFB_p.getStrCheck().equals("1"))
//			{
//				hsttWarrantyDtlVO.setStrIsItem("1");
//			}
//			else
//			{
//				hsttWarrantyDtlVO.setStrIsItem("0");
//			}
//
//			hsttWarrantyDtlVO.setStrIsValid("1");
//			hsttWarrantyDtlVO.setStrItemId(ItemWarrantyDtlsFB_p.getStrIsExtendPK().split("\\^")[0]);
//			hsttWarrantyDtlVO.setStrItemBrandId(ItemWarrantyDtlsFB_p.getStrIsExtendPK().split("\\^")[1]);
//			hsttWarrantyDtlVO.setStrItemSlNo(ItemWarrantyDtlsFB_p.getStrIsExtendPK().split("\\^")[4]);
//			hsttWarrantyDtlVO.setStrBatchSlNo(ItemWarrantyDtlsFB_p.getStrIsExtendPK().split("\\^")[2]);
//			hsttWarrantyDtlVO.setStrSlNo(ItemWarrantyDtlsFB_p.getStrIsExtendPK().split("\\^")[7]);
//
//			hsttWarrantyDtlVO.setStrSeatId(strSeatId_p);
//			hsttWarrantyDtlVO.setStrHospitalCode(strHospitalCode_p);
//
//			hsttWarrantyDtlVO.setStrExtTermsAndCondition(ItemWarrantyDtlsFB_p.getStrExtndTermsAndCond());
//			hsttWarrantyDtlVO.setStrExtendedStartDate(ItemWarrantyDtlsFB_p.getStrExtndWarrantyStartDate());
//			hsttWarrantyDtlVO.setStrIsExtended("1");
//			hsttWarrantyDtlVO.setStrExtendedUpto(ItemWarrantyDtlsFB_p.getStrExtndWarrantyUpTo());
//			hsttWarrantyDtlVO.setStrExtendedUptoUnit(ItemWarrantyDtlsFB_p.getStrExtndWarrantyId());
//			hsttWarrantyDtlVO.setStrExtUploadNo(ItemWarrantyDtlsFB_p.getStrDocRefNo());
//			hsttWarrantyDtlVO.setStrExtDocRefNo(strFileId);
//			hsttWarrantyDtlVO.setStrExtDocRefDate(ItemWarrantyDtlsFB_p.getStrDocRefDate());
//			hsttWarrantyDtlVO.setStrRemarks(ItemWarrantyDtlsFB_p.getStrExtndRemarks());
//
//			// Set Default Value [these dummy Value not use in final Update Statement ]
//			hsttWarrantyDtlVO.setStrFinancialStartYear(hisutil.getASDate("dd-MMM-yyyy")); // Get By Function
//			hsttWarrantyDtlVO.setStrFinancialEndYear(hisutil.getASDate("dd-MMM-yyyy")); // Get By Function
//			hsttWarrantyDtlVO.setStrWarrentyDate(hisutil.getASDate("dd-MMM-yyyy"));
//			hsttWarrantyDtlVO.setStrFinancialStartYear(hisutil.getASDate("dd-MMM-yyyy"));
//			hsttWarrantyDtlVO.setStrDocRefDate(hisutil.getASDate("dd-MMM-yyyy"));
//			hsttWarrantyDtlVO.setStrTenderDate(hisutil.getASDate("dd-MMM-yyyy"));
//			hsttWarrantyDtlVO.setStrOrderDate(hisutil.getASDate("dd-MMM-yyyy"));
//			hsttWarrantyDtlVO.setStrCancelDate(hisutil.getASDate("dd-MMM-yyyy"));
//
//			/** Calling BO Method Here* */
//			BmedTransBO.saveItemWarrantyDetails(hsttWarrantyDtlVO);
//
//			if (hsttWarrantyDtlVO.getStrMsgType().equals("0"))
//			{
//				ItemWarrantyDtlsFB_p.setStrNormalMsg("Data Extended Successfully");
//			}
//
//		}
//		catch (Exception e)
//		{
//			// e.printStackTrace();
//
//			strErrMsg = "ItemWarrantyDtlsTransDATA.saveExtendWarrantyData() --> " + e.getMessage();
//			HisException eObj = new HisException("BMED", "ItemWarrantyDtlsDATA", strErrMsg);
//			ItemWarrantyDtlsFB_p.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
//
//			eObj = null;
//		}
//
//	}
	
	public static void main(String args[])
	{
		String[] folder={"10","235","456"};
		
		createFTPDirectoryStructure("10.0.1.78","ggs","ggs123",folder);
		
	}
}
