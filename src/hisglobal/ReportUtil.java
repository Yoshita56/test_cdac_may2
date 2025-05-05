package hisglobal;

import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.HTMLServerImageHandler;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.ReportEngine;

public class ReportUtil {


	private static final String pathFileName = "hisglobal.hisconfig.hisReport";
	
//	private String path = "";

	private String storagePath = "";
	
	/**
	 * Saves the Specified Report in the Configured Location based on Modules.
	 * Displays the Saved Report if required.
	 * 
	 * @param request  HttpServletRequest to get the Report Details.
	 * @param response HttpServletResponse to display the Report.
	 * @param reportPath partially specified Report Path.
	 * @param strModuleName Current Module.
	 * @param fileName Name of the File for the Report at the Storage Location.
	 * @param reportFormat pdf or html (other formats wont support)
	 * @param params a Map which contains Key, Value Parameters. (ds_conn_path property is set by default, no need to set this property)
	 * @param shouldDisplay true - should Display after saving the file. false - should not Display after saving the file.
	 * @throws Exception if any of the required parameter is <code>null</code> or empty.
	 */
	public void saveReport(HttpServletRequest request,
			HttpServletResponse response, String reportPath, String strModuleName,
			String fileName, String reportFormat, Map<String, Object> params,
			boolean shouldDisplay) throws Exception {

		EngineConfig conf = null;
		ReportEngine eng = null;
		IReportRunnable design = null;
		IRunAndRenderTask task = null;
		HTMLRenderOption options = null;
		ByteArrayOutputStream out = null;

		String storageLocation = null;

		boolean bRptFormat = true;
		
		String strFileNameTemp = fileName;
		
		File f = null;
		FileOutputStream fos = null;

		String strReportRealPath = "";

		try {

			out = new ByteArrayOutputStream();

			conf = new EngineConfig();

			eng = new ReportEngine(conf);

			if (strModuleName == null || strModuleName.equals("")) {
				throw new Exception("Invalid Module Name");
			}

			//storageLocation = HisUtil.getParameterFromHisPathXML(strModuleName.toUpperCase()+ "_PATH");
			storageLocation = HisUtil.getParameterFromHisPathXML("TEMP_PATH");

			if (reportPath == null || reportPath.equals("")) {
				throw new Exception("Report Path is Blank");
			}

			strReportRealPath = request.getSession().getServletContext()
					.getRealPath(reportPath);

			design = eng.openReportDesign(strReportRealPath);

			
			
			task = eng.createRunAndRenderTask(design);

			options = new HTMLRenderOption();
	
			options.setImageHandler(new HTMLServerImageHandler());
			options.setImageDirectory(request.getSession().getServletContext().getRealPath("/images")); 
			options.setBaseImageURL(request.getContextPath()+"/images");
			
			if (reportFormat.equalsIgnoreCase("pdf")) {
				options.setOutputFormat(HTMLRenderOption.OUTPUT_FORMAT_PDF);

				strFileNameTemp = strFileNameTemp + ".pdf";

			} else {
				options.setOutputFormat(HTMLRenderOption.OUTPUT_FORMAT_HTML);
				strFileNameTemp = strFileNameTemp + ".html";
			}
			options.setOutputStream(out);

			task.setRenderOption(options);

			if (params == null || params.isEmpty()) {

				params = new HashMap<String, Object>();

				params.put("jndi_ds_conn", this.getPath());
				params.put("report_Header", this.getStoragePath("REPORT_HEADER"));
				params.put("report_Address", this.getStoragePath("REPORT_ADDRESS"));
				params.put("report_Contact", this.getStoragePath("REPORT_CONTACT"));
				params.put("report_Footer", this.getStoragePath("REPORT_FOOTER"));
				
			} else {
				params.put("jndi_ds_conn", this.getPath());
				params.put("report_Header", this.getStoragePath("REPORT_HEADER"));
				params.put("report_Address", this.getStoragePath("REPORT_ADDRESS"));
				params.put("report_Contact", this.getStoragePath("REPORT_CONTACT"));
				params.put("report_Footer", this.getStoragePath("REPORT_FOOTER"));
			}

			
			if(!reportFormat.equals("pdf"))
				bRptFormat = false;
						
			params.put("rpt_format", bRptFormat);
			
			
			task.setParameterValues(params);

			// task.setParameter("fromDate",
			// request.getParameter("fromDate"),"fromDate");
			// task.setParameterValue("toDate", request.getParameter("toDate"));

			task.run();

			f = new File(storageLocation + File.separator + strFileNameTemp);

			fos = new FileOutputStream(f.getAbsolutePath());

			fos.write(out.toByteArray());

			if (shouldDisplay) {

				displayReportFromFile(response, strModuleName, fileName,
						reportFormat);
			}

		} catch (Exception e) {

			throw e;

		} finally {

			if (fos != null) {
				fos.close();
				fos = null;
			}

			if (out != null)
				out = null;

			if (task != null) {
				task.close();
				task = null;
			}

			if (design != null)
				design = null;

			if (eng != null) {
				eng.destroy();
				eng = null;
			}

			if (conf != null)
				conf = null;
		}
	}

	/**
	 * Displays the Report from the Specified Report Path by retrieving the parameters. 
	 * 
	 * @param request  HttpServletRequest to get the Report Details.
	 * @param response HttpServletResponse to display the Report.
	 * @param strReportPath Fully Qualified Report Path.
	 * @param strReportFormat pdf or html (other formats wont support)
	 * @param params a Map which contains Key, Value Parameters.(ds_conn_path property is set by default, no need to set this property)
	 * @throws Exception if any of the required parameter is <code>null</code> or empty.
	 */
	public void displayReport(HttpServletRequest request,HttpServletResponse response, String strReportPath,String strReportFormat, Map<String, Object> params,String strHosCode) throws Exception 
	{
		EngineConfig conf = null;
		ReportEngine eng = null;
		IReportRunnable design = null;
		IRunAndRenderTask task = null;
		HTMLRenderOption options = null;
		ByteArrayOutputStream out = null;
		Map logoRequirement=null;

	//	HTMLRenderContext renderContext = null; 
	//	HashMap contextMap = null;
		
		boolean bRptFormat = true;
		
		String strReportRealPath = "";

		try 
		{
			out = new ByteArrayOutputStream();
			conf = new EngineConfig();
			eng = new ReportEngine(conf);
			strReportRealPath = request.getSession().getServletContext().getRealPath(strReportPath);
			design = eng.openReportDesign(strReportRealPath);
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(strHosCode);
			task = eng.createRunAndRenderTask(design);
			options = new HTMLRenderOption();
		//	options.setImageDirectory("image");
			options.setImageHandler(new HTMLServerImageHandler());
			options.setImageDirectory(request.getSession().getServletContext().getRealPath("/images")); 
			options.setBaseImageURL(request.getContextPath()+"/images");
/*
			renderContext = new HTMLRenderContext();
			renderContext.setImageDirectory("C:\\image");
			contextMap = new HashMap();
			contextMap.put( EngineConstants.APPCONTEXT_HTML_RENDER_CONTEXT, renderContext );
			task.setAppContext( contextMap );
*/
			//options.setImageHandler( new HTMLServerImageHandler());

			String hospLogoPath = request.getSession().getServletContext().getRealPath("hisglobal/images/logo.png");
			
			
			if (strReportFormat.equalsIgnoreCase("pdf")) 
			{				
				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition","inline; filename=output.pdf");
				options.setOutputFormat(HTMLRenderOption.OUTPUT_FORMAT_PDF);
				//fileName = fileName + ".pdf";

			} 
			else if (strReportFormat.equalsIgnoreCase("xls")) 
			{
				response.setContentType("application/xls");
				response.setHeader("Content-Disposition","inline; filename=output.xls");
				displayReportInExcel( request,response,  strReportPath,strReportFormat,  params);
				//fileName = fileName + ".xls";
			} 	
			else if (strReportFormat.equalsIgnoreCase("excel")) 
			{				
				response.setContentType("application/xls");
				response.setHeader("Content-Disposition","inline; filename=output.xls");
				displayReportInExcel( request,response,  strReportPath,strReportFormat,  params);
			}
			else  
			{
				options.setOutputFormat(HTMLRenderOption.OUTPUT_FORMAT_HTML);
				response.setHeader("Content-Disposition","inline; filename=output.html");
			}
			//String strFixHeader ="Computer Generated Report";
			String strFixHeader =
					//"<script> var heightW=window.innerHeight-210; var tdForNavigator = document.createElement('td'); tdForNavigator.setAttribute('colspan', '8'); var divForNavigator = document.createElement('div'); divForNavigator.style.cssText ='height:'+heightW+'px;overflow:auto; border-bottom: 7px solid #1274B0;'; tdForNavigator.appendChild(divForNavigator); divForNavigator.className = 'x-panel-header'; divForNavigator.setAttribute('id', 'fixedtable'); var navigatorCell = document.getElementById('myElementId'); var navigatorMain = document.getElementById('myTable'); navigatorMain.style.cssText='border-collapse:collapse;empty-cells: show;width: 100%;'; navigatorCell.appendChild(tdForNavigator);  var theadForNavigator = document.createElement('thead'); theadForNavigator.style.cssText='display:table-header-group;border-top-style: solid;        border-top-width: 3px;';   var tdForHeader = document.createElement('td'); tdForHeader.setAttribute('colspan', '8'); var divForHeader = document.createElement('div'); var tableForHeader = document.createElement('table'); tableForHeader.setAttribute('id', 'tabheader'); tableForHeader.setAttribute('cellspacing', '0'); tableForHeader.style.cssText ='width:100%;'; divForHeader.appendChild(tableForHeader); tdForHeader.appendChild(divForHeader); var headerCell = document.getElementById('headerElementId'); var colgroup=document.getElementsByTagName('colgroup'); var navigator1 = document.getElementById('tableHeader'); if(navigatorMain.offsetHeight > heightW) { var thForScroll=document.createElement('th'); thForScroll.setAttribute('id', 'fixedtableThlast'); thForScroll.style.cssText ='padding: 0 14px 0 3px;width:1%;'; navigator1.appendChild(thForScroll); }  headerCell.appendChild(tdForHeader); tableForHeader.appendChild(navigator1.cloneNode(true)); tableForHeader.appendChild(colgroup[3].cloneNode(true)); theadForNavigator.appendChild(navigator1); navigatorMain.appendChild(theadForNavigator); divForNavigator.appendChild(navigatorMain); headerCell.deleteCell(0); navigatorCell.deleteCell(0); var navigatorHeader = document.getElementById('tableHeader'); navigatorHeader.setAttribute('id', 'firstHeader'); var navigatorHeaderHide = document.getElementById('tableHeader'); navigatorHeaderHide.style.cssText ='display:none;'; </script> ";
					//Fixed Header With Scroll "<script> var heightW=window.innerHeight-210; var tdForNavigator = document.createElement('td'); tdForNavigator.setAttribute('colspan', '8'); var divForNavigator = document.createElement('div');  tdForNavigator.appendChild(divForNavigator); divForNavigator.className = 'x-panel-header'; divForNavigator.setAttribute('id', 'fixedtable'); var navigatorCell = document.getElementById('myElementId'); var navigatorMain = document.getElementById('myTable'); navigatorMain.style.cssText='empty-cells: show;width: 100%;'; navigatorCell.appendChild(tdForNavigator);  var theadForNavigator = document.createElement('thead'); theadForNavigator.style.cssText='display:table-header-group;';   var tdForHeader = document.createElement('td'); tdForHeader.setAttribute('colspan', '8'); var divForHeader = document.createElement('div'); var tableForHeader = document.createElement('table'); tableForHeader.setAttribute('id', 'tabheader'); tableForHeader.setAttribute('cellspacing', '0'); tableForHeader.style.cssText ='width:100%;'; divForHeader.appendChild(tableForHeader); tdForHeader.appendChild(divForHeader); var headerCell = document.getElementById('headerElementId'); var navigator1 = document.getElementById('tableHeader'); if(navigatorMain.offsetHeight > heightW) { var thForScroll=document.createElement('th'); thForScroll.setAttribute('id', 'fixedtableThlast'); thForScroll.style.cssText ='padding: 0 14px 0 3px;width:1%;'; navigator1.appendChild(thForScroll); }  headerCell.appendChild(tdForHeader); tableForHeader.appendChild(navigator1.cloneNode(true));  theadForNavigator.appendChild(navigator1); navigatorMain.appendChild(theadForNavigator); divForNavigator.appendChild(navigatorMain); headerCell.deleteCell(0); navigatorCell.deleteCell(0); var navigatorHeader = document.getElementById('tableHeader'); navigatorHeader.setAttribute('id', 'firstHeader'); var navigatorHeaderHide = document.getElementById('tableHeader'); navigatorHeaderHide.style.cssText ='display:none;'; var tableBillDtls = document.getElementById('tableBillDtls');  tableBillDtls.style.cssText='empty-cells: show;width: 100%;';  var theadBillDtls = document.createElement('thead'); theadBillDtls.setAttribute('id', 'theadBillDtls'); theadBillDtls.style.cssText='display:table-header-group;'; var billDtlsHeader = document.getElementById('billDtlsHeader');theadBillDtls.appendChild(billDtlsHeader); tableBillDtls.appendChild(theadBillDtls);  </script> ";
					//HTML Print Printable Header On Each Page
					"<script> var navigatorMain = document.getElementById('myTable'); navigatorMain.style.cssText='empty-cells: show;width: 100%;'; var theadForNavigator = document.createElement('thead'); theadForNavigator.style.cssText='display:table-header-group;'; theadForNavigator.setAttribute('id', 'theadCrdDtls');   var tableHeader = document.getElementById('tableHeader');theadForNavigator.appendChild(tableHeader); navigatorMain.appendChild(theadForNavigator); var tableBillDtls = document.getElementById('tableBillDtls');  tableBillDtls.style.cssText='empty-cells: show;width: 100%;';  var theadBillDtls = document.createElement('thead'); theadBillDtls.setAttribute('id', 'theadBillDtls'); theadBillDtls.style.cssText='display:table-header-group;'; var billDtlsHeader = document.getElementById('billDtlsHeader');theadBillDtls.appendChild(billDtlsHeader); tableBillDtls.appendChild(theadBillDtls);  </script> ";
			
			// strPrintCancelImg =
			// "<table> <tr> <td> <div id='printAreaDivId' class='hidecontrol'> <img  src='../../hisglobal/images/print_tab.gif' style='cursor: pointer' onclick='resetHeight();printContent();setHeight();'>  </td> </div> <td> <div id='backDivId' class='hidecontrol'> <img  src='../../hisglobal/images/back_tab.png' style='cursor: pointer' onclick='goBack();'>  </td> </div> </tr> </table>";
			
			options.setOutputStream(out);
			task.setRenderOption(options);
			
			logoRequirement=new HashMap<String, Object>();
			
			logoRequirement.put("HOSPCODE", strHosCode);
			logoRequirement.put("FORMAT", strReportFormat);
			logoRequirement.put("REQUEST", request);

			if (params == null || params.isEmpty()) 
			{
				params = new HashMap<String, Object>();
				params.put("jndi_ds_conn", this.getPath());
				//params.put("report_Header", this.getStoragePath("REPORT_HEADER"));
				//params.put("report_Header", hospitalVO.getHospitalName());
				params.put("report_Header", hisUtil.getHospitalHeaderMain(logoRequirement));
				//params.put("report_Address", this.getStoragePath("REPORT_ADDRESS"));
				//params.put("report_Address", ((hospitalVO.getAddress1()==""||hospitalVO.getAddress1()==null)?" ":(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2()==""||hospitalVO.getAddress2()==null)?" ":(hospitalVO.getAddress2()+","))+ ((hospitalVO.getCity()==""||hospitalVO.getCity()==null)?" ":(hospitalVO.getCity()+","))+((hospitalVO.getPinCode()==""||hospitalVO.getPinCode()==null)?" ":(hospitalVO.getPinCode()))+"");
				//params.put("report_Address", ((hospitalVO.getAddress1()==""||hospitalVO.getAddress1()==null)?" ":(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2()==""||hospitalVO.getAddress2()==null)?" ":(hospitalVO.getAddress2()+","))+ ((hospitalVO.getCity()==""||hospitalVO.getCity()==null)?" ":(hospitalVO.getCity()+"-"))+((hospitalVO.getPinCode()==""||hospitalVO.getPinCode()==null)?"***":(hospitalVO.getPinCode()))+",");
				params.put("report_Address", "&nbsp;");
				//params.put("report_Contact", this.getStoragePath("REPORT_CONTACT"));
				//params.put("report_Contact", "-----------------------------------------------------------------------");
				//params.put("report_Contact","Phone :"+(hospitalVO.getPhone()!=null && !hospitalVO.getPhone().equals("")? hospitalVO.getPhone():" -")+", "+"Fax :"+(hospitalVO.getFax()!=null && !hospitalVO.getFax().equals("")?hospitalVO.getFax():" -")+", "+"Email :"+(hospitalVO.getEmail()!=null && !hospitalVO.getEmail().equals("")?hospitalVO.getEmail():" -"));
				params.put("report_Contact","&nbsp;");
				params.put("report_Footer", strFixHeader);
								
			} 
			else 
			{
			//	System.out.println("path :: "+this.getPath());
				params.put("jndi_ds_conn", this.getPath());
				//params.put("report_Header", this.getStoragePath("REPORT_HEADER"));
				//params.put("report_Header", hospitalVO.getHospitalName());
				params.put("report_Header", hisUtil.getHospitalHeaderMain(logoRequirement));
				//params.put("report_Address", this.getStoragePath("REPORT_ADDRESS"));
				//params.put("report_Address", ((hospitalVO.getAddress1()==""||hospitalVO.getAddress1()==null)?" ":(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2()==""||hospitalVO.getAddress2()==null)?" ":(hospitalVO.getAddress2()+","))+ ((hospitalVO.getCity()==""||hospitalVO.getCity()==null)?" ":(hospitalVO.getCity()+","))+((hospitalVO.getPinCode()==""||hospitalVO.getPinCode()==null)?" ":(hospitalVO.getPinCode()))+"");
				params.put("report_Address", "&nbsp;");
				//params.put("report_Contact", this.getStoragePath("REPORT_CONTACT"));
				//params.put("report_Contact","-----------------------------------------------------------------------");
				//params.put("report_Contact","Phone :"+(hospitalVO.getPhone()!=null && !hospitalVO.getPhone().equals("")? hospitalVO.getPhone():" -")+", "+"Fax :"+(hospitalVO.getFax()!=null && !hospitalVO.getFax().equals("")?hospitalVO.getFax():" -")+", "+"Email :"+(hospitalVO.getEmail()!=null && !hospitalVO.getEmail().equals("")?hospitalVO.getEmail():" -"));
				params.put("report_Contact","&nbsp;");
				params.put("report_Footer", strFixHeader);
			}

						
			if(!strReportFormat.equals("pdf"))
				bRptFormat = false;
						
			params.put("rpt_format", bRptFormat);
			task.setParameterValues(params);
			task.run();
			response.getOutputStream().write(out.toByteArray());
		} 
		catch (Exception e) 
		{	
			e.printStackTrace();
			throw e;
		} 
		finally 
		{
			if (out != null)
				out = null;
			if (task != null) 
			{
				task.close();
				task = null;
			}
			if (design != null)
				design = null;
			if (eng != null) 
			{
				eng.destroy();
				eng = null;
			}
			if (conf != null)
				conf = null;
		}
	}

	/**
	 * Displays the Report by retrieving the parameters. 
	 * @param response HttpServletResponse to display the Report.
	 * @param strModuleName Current Module.
	 * @param strFileName Name of the File for the Report at the Storage Location.
	 * @param strReportFormat pdf or html (other formats wont support)
	 * @throws Exception if File Not Exists or any of the required parameter is <code>null</code> or empty.
	 */
	public void displayReportFromFile(HttpServletResponse response,
			String strModuleName, String strFileName, String strReportFormat)
			throws Exception {

		// declare a global var for byte range.
		byte[] bReportContent = new byte[1024];
		File f = null;
		FileInputStream fis = null;
		
		String strReportFullPath = null;

		//String strReportLocation = HisUtil.getParameterFromHisPathXML(strModuleName.toUpperCase()+ "_PATH");
		String strReportLocation = HisUtil.getParameterFromHisPathXML("TEMP_PATH");

		if (strReportLocation == null || strReportLocation.equals("")) 
		{
			throw new Exception("Invalid Path");
		}

		if (strFileName == null || strFileName.equals("")) 
		{
			throw new Exception("Invalid File Name/Path");
		}

		if (strReportFormat == null) 
		{
			throw new Exception("Invalid Report Format");
		}

		strReportFullPath = strReportLocation + File.separator + strFileName ;

			
		if (strReportFormat.equals("")) {
			strReportFullPath = strReportFullPath+"."+ "pdf";
		} else {
			strReportFullPath = strReportFullPath+"." + strReportFormat;
		}

			
		String[] strTemp = strReportFullPath.replace(".", "#").split("#");
		String strExt = strTemp[strTemp.length - 1];

		try {

			if (strExt.equalsIgnoreCase("pdf")) {

				response.setContentType("application/pdf");
				response.setHeader("Content-disposition",
						"attachment; filename="+strFileName+".pdf");

			} else if (strExt.equalsIgnoreCase("html")
					|| strExt.equalsIgnoreCase("htm")) {
				response.setContentType("text/html;charset=utf-8");
				response.setHeader("cache-control", "no-cache");
			} else {

				throw new Exception(
						"UnSupportFile : Only PDF and HTML Supports");

			}
			
		
			f = new File(strReportFullPath);

			if (!f.isFile()) {

				throw new Exception("Invalid File Path");
			}

			fis = new FileInputStream(f);

			while (fis.read(bReportContent) != -1) {

				response.getOutputStream().write(bReportContent);
			}

		} catch (Exception e) {

			throw e;

		} finally {

			if (fis != null) {
				fis.close();
				fis = null;
			}

			if (f != null)
				f = null;

			if (bReportContent != null)
				bReportContent = null;
		}

	}

	/**
	 * method used to return the path of the IPD_CONFIG file from resource
	 * bundle
	 * 
	 * @return - path of the REPORT_DS_PATH file in String
	 */
	private String getPath() {
		return HisUtil.getParameterFromHisPathXML("JNDI_LOOKUP");
	}

	/**
	 * method used to return the path of the IPD_CONFIG file from resource
	 * bundle
	 * 
	 * @return - path of the REPORT_DS_PATH file in String
	 */
	private String getStoragePath(String key) {

		ResourceBundle rsBundle = ResourceBundle.getBundle(pathFileName);
		storagePath = rsBundle.getString(key);
		return storagePath;
	}
	
	/**
	Tweaked to force download pdf for bill Enquiry Report
	 */
	public void displayReportBilling(HttpServletRequest request,
			HttpServletResponse response, String strReportPath,
			String strReportFormat, Map<String, Object> params,String strHosCode) throws Exception {

		EngineConfig conf = null;
		ReportEngine eng = null;
		IReportRunnable design = null;
		IRunAndRenderTask task = null;
		HTMLRenderOption options = null;
		ByteArrayOutputStream out = null;
		Map logoRequirement=null;

	//	HTMLRenderContext renderContext = null; 
	//	HashMap contextMap = null;
		
		boolean bRptFormat = true;
		
		String strReportRealPath = "";

		try {

			out = new ByteArrayOutputStream();

			conf = new EngineConfig();

			eng = new ReportEngine(conf);

			strReportRealPath = request.getSession().getServletContext()
					.getRealPath(strReportPath);

			design = eng.openReportDesign(strReportRealPath);

			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(strHosCode);
						
						
			task = eng.createRunAndRenderTask(design);

						
			options = new HTMLRenderOption();
			
			
			
		//	options.setImageDirectory("image");
			
			options.setImageHandler(new HTMLServerImageHandler());
			options.setImageDirectory(request.getSession().getServletContext().getRealPath("/images")); 
			options.setBaseImageURL(request.getContextPath()+"/images");
			
/*
			renderContext = new HTMLRenderContext();
			renderContext.setImageDirectory("C:\\image");
			contextMap = new HashMap();
			contextMap.put( EngineConstants.APPCONTEXT_HTML_RENDER_CONTEXT, renderContext );
			task.setAppContext( contextMap );
*/
			//options.setImageHandler( new HTMLServerImageHandler());

		
			
			if (strReportFormat.equalsIgnoreCase("pdf")) {
				
				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition",
						"inline; filename=output.pdf");
				
				//force download pdf
				response.setHeader("Content-Disposition","attachment; filename=output.pdf");
					
				options.setOutputFormat(HTMLRenderOption.OUTPUT_FORMAT_PDF);
				
				//fileName = fileName + ".pdf";

			} else if (strReportFormat.equalsIgnoreCase("xls")) {
				
				response.setContentType("application/xls");
				response.setHeader("Content-Disposition",
						"inline; filename=output.xls");
					
				options.setOutputFormat(HTMLRenderOption.OUTPUT_FORMAT_HTML);
				
				//fileName = fileName + ".pdf";

			} else  {
				options.setOutputFormat(HTMLRenderOption.OUTPUT_FORMAT_HTML);

				response.setHeader("Content-Disposition",
				"inline; filename=output.html");

			}
			options.setOutputStream(out);

			task.setRenderOption(options);
			
			
			logoRequirement=new HashMap<String, Object>();
			
			logoRequirement.put("HOSPCODE", strHosCode);
			logoRequirement.put("FORMAT", strReportFormat);
			logoRequirement.put("REQUEST", request);

			if (params == null || params.isEmpty()) {

				params = new HashMap<String, Object>();
//System.out.println("path :: "+this.getPath());
				
				params.put("jndi_ds_conn", this.getPath());
				//params.put("report_Header", this.getStoragePath("REPORT_HEADER"));
				//params.put("report_Header", hospitalVO.getHospitalName());
				params.put("report_Header", hisUtil.getHospitalHeaderMain(logoRequirement));
				//params.put("report_Address", this.getStoragePath("REPORT_ADDRESS"));
				//params.put("report_Address", ((hospitalVO.getAddress1()==""||hospitalVO.getAddress1()==null)?" ":(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2()==""||hospitalVO.getAddress2()==null)?" ":(hospitalVO.getAddress2()+","))+ ((hospitalVO.getCity()==""||hospitalVO.getCity()==null)?" ":(hospitalVO.getCity()+","))+((hospitalVO.getPinCode()==""||hospitalVO.getPinCode()==null)?" ":(hospitalVO.getPinCode()))+"");
				params.put("report_Address", "&nbsp;");
				//params.put("report_Contact", this.getStoragePath("REPORT_CONTACT"));
				//params.put("report_Contact", "-----------------------------------------------------------------------");
				params.put("report_Contact","&nbsp;");
				params.put("report_Footer", this.getStoragePath("REPORT_FOOTER"));
								
			} else {
			//	System.out.println("path :: "+this.getPath());
				params.put("jndi_ds_conn", this.getPath());
				//params.put("report_Header", this.getStoragePath("REPORT_HEADER"));
				//params.put("report_Header", hospitalVO.getHospitalName());
				params.put("report_Header", hisUtil.getHospitalHeaderMain(logoRequirement));
				//params.put("report_Address", this.getStoragePath("REPORT_ADDRESS"));
				//params.put("report_Address", ((hospitalVO.getAddress1()==""||hospitalVO.getAddress1()==null)?" ":(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2()==""||hospitalVO.getAddress2()==null)?" ":(hospitalVO.getAddress2()+","))+ ((hospitalVO.getCity()==""||hospitalVO.getCity()==null)?" ":(hospitalVO.getCity()+","))+((hospitalVO.getPinCode()==""||hospitalVO.getPinCode()==null)?" ":(hospitalVO.getPinCode()))+"");
				params.put("report_Address", "&nbsp;");
				//params.put("report_Contact", this.getStoragePath("REPORT_CONTACT"));
				//params.put("report_Contact","-----------------------------------------------------------------------");
				params.put("report_Contact","&nbsp;");
				params.put("report_Footer", this.getStoragePath("REPORT_FOOTER"));
			}

						
			if(!strReportFormat.equals("pdf"))
				bRptFormat = false;
						
			params.put("rpt_format", bRptFormat);
			
			//System.out.println("Path :"+this.getPath());
			
			task.setParameterValues(params);

		
			
			task.run();

			
			
			response.getOutputStream().write(out.toByteArray());

		} catch (Exception e) {

		
			e.printStackTrace();
			throw e;

			
			
		} finally {

			if (out != null)
				out = null;

			if (task != null) {
				task.close();
				task = null;
			}

			if (design != null)
				design = null;

			if (eng != null) {
				eng.destroy();
				eng = null;
			}

			if (conf != null)
				conf = null;
		}

	}
	
	//added by shalini to get po print pdf by po no as report name
		public void displayReportWithName(HttpServletRequest request,
				HttpServletResponse response, String strReportPath,
				String strReportFormat, Map<String, Object> params,String strHosCode,String strReportName) throws Exception {

			EngineConfig conf = null;
			ReportEngine eng = null;
			IReportRunnable design = null;
			IRunAndRenderTask task = null;
			HTMLRenderOption options = null;
			ByteArrayOutputStream out = null;

		//	HTMLRenderContext renderContext = null; 
		//	HashMap contextMap = null;
			
			boolean bRptFormat = true;
			
			String strReportRealPath = "";
			String strConsolidatedAddress="";
			String strAddress1="";
			
			try {

				out = new ByteArrayOutputStream();

				conf = new EngineConfig();

				eng = new ReportEngine(conf);

				strReportRealPath = request.getSession().getServletContext()
						.getRealPath(strReportPath);

				design = eng.openReportDesign(strReportRealPath);
				HisUtil hisUtil=new HisUtil("Global","ReportUtil");
				HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(strHosCode);
							
						//HelperMethods.populatetToNullOrEmpty(obj1, obj2)	
				task = eng.createRunAndRenderTask(design);

							
				options = new HTMLRenderOption();
				
				
				
			//	options.setImageDirectory("image");
				
				options.setImageHandler(new HTMLServerImageHandler());
				options.setImageDirectory(request.getSession().getServletContext().getRealPath("/images")); 
				options.setBaseImageURL(request.getContextPath()+"/images");
				
	/*
				renderContext = new HTMLRenderContext();
				renderContext.setImageDirectory("C:\\image");
				contextMap = new HashMap();
				contextMap.put( EngineConstants.APPCONTEXT_HTML_RENDER_CONTEXT, renderContext );
				task.setAppContext( contextMap );
	*/
				//options.setImageHandler( new HTMLServerImageHandler());

			
				
				if (strReportFormat.equalsIgnoreCase("pdf")) {
					
					response.setContentType("application/pdf");
					response.setHeader("Content-Disposition",
							"inline; filename="+strReportName+".pdf");
						
					options.setOutputFormat(HTMLRenderOption.OUTPUT_FORMAT_PDF);
					
					//fileName = fileName + ".pdf";

				} else if (strReportFormat.equalsIgnoreCase("xls")) {
					
					response.setContentType("application/xls");
					response.setHeader("Content-Disposition",
							"inline; filename="+strReportName+".xls");
						
					options.setOutputFormat(HTMLRenderOption.OUTPUT_FORMAT_HTML);
					
					//fileName = fileName + ".pdf";

				} else  {
					options.setOutputFormat(HTMLRenderOption.OUTPUT_FORMAT_HTML);

					response.setHeader("Content-Disposition",
					"inline; filename="+strReportName+".html");

				}
				options.setOutputStream(out);

				task.setRenderOption(options);
				
				
				
			//	HelperMethods.setNullToEmpty(hospitalVO);
				////strConsolidatedAddress=((hospitalVO.getAddress1().equals(" ")||hospitalVO.getAddress1().equals(null))?" ":(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2().equals(" ")||hospitalVO.getAddress2().equals(null))?" ":(hospitalVO.getAddress2()+","))+ ((hospitalVO.getCity().equals(" ")||hospitalVO.getCity().equals(null))?" ":(hospitalVO.getCity()+","))+((hospitalVO.getPinCode().equals(" ")||hospitalVO.getPinCode().equals(null))?" ":(hospitalVO.getPinCode()+","))+" (RAJASTHAN)";
				//strConsolidatedAddress.replace(", ,", ",");
				//strConsolidatedAddress.replace(",,", ",");
				
				//strConsolidatedAddress=hospitalVO.getConsolidatedHospAddress();
				
				//System.out.println("consolidated address is::"+strConsolidatedAddress);
				if (params == null || params.isEmpty()) 
				{
					
					
					
					if(hospitalVO.getAddress1()!=null)
					params = new HashMap<String, Object>();

					params.put("jndi_ds_conn", this.getPath());
					//params.put("report_Header", this.getStoragePath("REPORT_HEADER"));
					params.put("report_Header", hospitalVO.getHospitalName());
					//params.put("report_Address", this.getStoragePath("REPORT_ADDRESS"));
					
				//	params.put("report_Address", ((hospitalVO.getAddress1()==""||hospitalVO.getAddress1()==null)?" ":(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2()==""||hospitalVO.getAddress2()==null)?" ":(hospitalVO.getAddress2()+","))+ ((hospitalVO.getCity()==""||hospitalVO.getCity()==null)?" ":(hospitalVO.getCity()+","))+((hospitalVO.getPinCode()==""||hospitalVO.getPinCode()==null)?" ":(hospitalVO.getPinCode()+","))+" (RAJASTHAN)");
					
					//params.put("report_Address", strConsolidatedAddress);
					//params.put("report_Contact", this.getStoragePath("REPORT_CONTACT"));
					//params.put("report_Contact", (hospitalVO.getPhone()=="" || hospitalVO.getPhone() == null)?" ":(hospitalVO.getPhone()));
					params.put("report_Address", ((hospitalVO.getAddress1()==""||hospitalVO.getAddress1()==null)?" ":(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2()==""||hospitalVO.getAddress2()==null)?" ":(hospitalVO.getAddress2()+","))+ ((hospitalVO.getCity()==""||hospitalVO.getCity()==null)?" ":(hospitalVO.getCity()+","))+((hospitalVO.getPinCode()==""||hospitalVO.getPinCode()==null)?" ":(hospitalVO.getPinCode()))+"");
					//params.put("report_Contact", this.getStoragePath("REPORT_CONTACT"));
					params.put("report_Contact", "-----------------------------------------------------------------------");
					params.put("report_Footer", this.getStoragePath("REPORT_FOOTER"));
									
				} else {
					params.put("jndi_ds_conn", this.getPath());
					//params.put("report_Header", this.getStoragePath("REPORT_HEADER"));
					params.put("report_Header", hospitalVO.getHospitalName());
					//params.put("report_Address", this.getStoragePath("REPORT_ADDRESS"));
				//	params.put("report_Address", strConsolidatedAddress);
					//params.put("report_Contact", this.getStoragePath("REPORT_CONTACT"));
					//params.put("report_Contact",(hospitalVO.getPhone()=="" || hospitalVO.getPhone() == null)?" ":(hospitalVO.getPhone()));
					params.put("report_Address", ((hospitalVO.getAddress1()==""||hospitalVO.getAddress1()==null)?" ":(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2()==""||hospitalVO.getAddress2()==null)?" ":(hospitalVO.getAddress2()+","))+ ((hospitalVO.getCity()==""||hospitalVO.getCity()==null)?" ":(hospitalVO.getCity()+","))+((hospitalVO.getPinCode()==""||hospitalVO.getPinCode()==null)?" ":(hospitalVO.getPinCode()))+"");
					//params.put("report_Contact", this.getStoragePath("REPORT_CONTACT"));
					params.put("report_Contact", "-----------------------------------------------------------------------");
					params.put("report_Footer", this.getStoragePath("REPORT_FOOTER"));
				}

							
				if(!strReportFormat.equals("pdf"))
					bRptFormat = false;
							
				params.put("rpt_format", bRptFormat);
				
				//System.out.println("Path :"+this.getPath());
				
				task.setParameterValues(params);

			
				
				task.run();

				
				
				response.getOutputStream().write(out.toByteArray());

			} catch (Exception e) {

			
				e.printStackTrace();
				throw e;

				
				
			} finally {

				if (out != null)
					out = null;

				if (task != null) {
					task.close();
					task = null;
				}

				if (design != null)
					design = null;

				if (eng != null) {
					eng.destroy();
					eng = null;
				}

				if (conf != null)
					conf = null;
			}

		}
		
		/* For EXCEL FORMAT in RAOL BY SHRIYANSH JAIN*/
		
		public void displayReportInExcel(HttpServletRequest request,HttpServletResponse response, String strReportPath,String strReportFormat, Map<String, Object> params) throws Exception 
		{
			EngineConfig conf = null;
			IReportRunnable design = null;
			IRunAndRenderTask task = null;
			HTMLRenderOption options = null;
			ByteArrayOutputStream out = null;
			boolean bRptFormat = true;		
			String strReportRealPath = "";
			strReportRealPath = request.getSession().getServletContext().getRealPath(strReportPath);
			
			IReportEngine birtReportEngine = null;
			
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment; filename=output.xls");
			//response.setHeader("Content-Disposition","inline; filename=output.xls");
			//options.setOutputStream(out);
			  
			try 
			{
			    conf = new EngineConfig();
			    conf.setEngineHome("ReportEngine");
			    conf.setLogConfig(null, Level.FINE);
			    IReportEngineFactory factory = (IReportEngineFactory) Platform.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
			    birtReportEngine = factory.createReportEngine(conf);

			    design = birtReportEngine.openReportDesign(strReportRealPath);
			    task = birtReportEngine.createRunAndRenderTask(design);
			    options = new HTMLRenderOption();
			    options.setOutputFormat("html");
			    options.setOutputStream(response.getOutputStream());
			    task.setRenderOption(options);
			    
			    if (params == null || params.isEmpty()) 
			    {
					params = new HashMap<String, Object>();

					params.put("jndi_ds_conn", this.getPath());
					params.put("report_Header", this.getStoragePath("REPORT_HEADER"));
					params.put("report_Address", this.getStoragePath("REPORT_ADDRESS"));
					params.put("report_Contact", this.getStoragePath("REPORT_CONTACT"));
					params.put("report_Footer", this.getStoragePath("REPORT_FOOTER"));								
				} 
			    else 
			    {
					params.put("jndi_ds_conn", this.getPath());
					params.put("report_Header", this.getStoragePath("REPORT_HEADER"));
					params.put("report_Address", this.getStoragePath("REPORT_ADDRESS"));
					params.put("report_Contact", this.getStoragePath("REPORT_CONTACT"));
					params.put("report_Footer", this.getStoragePath("REPORT_FOOTER"));
				}

							
			    if(strReportFormat.equals("html"))
					bRptFormat = false;
							
				params.put("rpt_format", bRptFormat);
				task.setParameterValues(params);
				task.run();
				task.close();
				//response.getOutputStream().write(out.toByteArray());		   
			} 
			catch (Exception e) 
			{
			    e.printStackTrace();		    
			}
			finally 
			{
				if (out != null)
					out = null;
				if (task != null) 
				{
					task.close();
					task = null;
				}
				if (design != null)
					design = null;
				if (birtReportEngine != null) {
					birtReportEngine.destroy();
					birtReportEngine = null;
				}
				if (conf != null)
					conf = null;
			}
		} 
}
