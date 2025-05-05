/**********************************************************
 Project:	   DWH_BIHAR	
 File:         ProjectedDemandRequestTransDATA.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.controller.data;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.struts.upload.FormFile;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.transactions.bo.FileUploadTransBO;
import mms.transactions.controller.fb.FileUploadTransFB;
//import mms.transactions.controller.hlp.FileUploadTransHLP;
import mms.transactions.vo.FileUploadTransVO;






// TODO: Auto-generated Javadoc
/**
 * The Class ProjectedDemandRequestTransDATA.
 */
public class FileUploadTransDATA {

	/**
	 * Method is Used to Populate the Data for Save Page of Issue To Patient Transaciton ADD Page.
	 *
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public static void GetDataWithItem(FileUploadTransFB formBean, HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		FileUploadTransBO bo = null;
		FileUploadTransVO vo = null;
		String strMsgText = "";
		HisUtil util = null;
		
		String strCurrentDate;
		try {
			bo = new FileUploadTransBO();
			vo = new FileUploadTransVO();
			
			util = new HisUtil("ProjectedDemandRequestTransDATA", "ProjectedDemandRequestTransDATA");
			
			util = new HisUtil("ProjectedDemandRequestTransDATA", "ProjectedDemandRequestTransDATA");
			String strCtDate = util.getASDate("dd-MMM-yyyy");

			

			strCurrentDate = util.getASDate("dd-MM-yyyy");

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);

			vo.setStrIndentPeriodValue(formBean.getStrIndentPeriodValue());
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrCtDate(strCtDate);
			vo.setStrAlphabet("$");
			// Calling BO Method
			bo.GetData(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			bo.getDrugClassificationValue(vo);
			if (vo.getDrugClassWs() != null && vo.getDrugClassWs().size() > 0) {
			formBean.setStrDrugClassVal(util.getOptionValue(vo.getDrugClassWs(), "0", "0^All", false));
			}
			else{
				formBean.setStrDrugClassVal("<option value='0'>All</option>");
			}
			
			formBean.setStrCtDate(strCurrentDate);
			formBean.setStrIndentPeriodValueCombo(vo.getStrIndentPeriodValueCombo());
			

		} catch (Exception e) {
			e.printStackTrace();
			strMsgText =  e.getMessage();
			new HisException("e-Aushadhi", "ProjectedDemandRequestTransDATA->GetDataWithItem()", strMsgText);
		
		} finally {
			bo = null;
			vo = null;
			util = null;
		}
	}

	/**
	 * Gets the existing req dtl.
	 *
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @return the existing req dtl
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public static void getExistingReqDtl(FileUploadTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{

		FileUploadTransBO bo = null;
		FileUploadTransVO voObj = null;
		String strMsgText = null;
		String strReqDtl = "";

		try {
			new HisUtil("MMS Reports", "ProjectedDemandRequestTransDATA");
			bo = new FileUploadTransBO();
			voObj = new FileUploadTransVO();

			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			voObj.setStrIndentPeriodValue(request.getParameter("strIndentPeriodValue"));

			voObj.setStrMode("2");
			bo.getExistingReqDtl(voObj); //pkg_mms_view.proc_notification_dtl [ Mode = 2 ]

			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());
			}
			
			/*if(voObj.getWrsData()!=null && voObj.getWrsData().size()>0)
				strReqDtl = FileUploadTransHLP.getExistingReqDtlHlp(voObj);
			else
				strReqDtl =	"NA"; */

			try 
			{
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strReqDtl);

			} 
			catch (Exception e) 
			{

			}

		} catch (Exception e) {
			strMsgText = e.getMessage();
			new HisException("e-Aushadhi", "ProjectedDemandRequestTransDATA->GetDataWithItem()", strMsgText);
			
		} finally {
			if (voObj != null) {
				voObj = null;
			}
			if (formBean != null) {
				formBean = null;
			}
		}
	}

	public static void getDrugName(FileUploadTransFB formBean,HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{

		FileUploadTransBO bo = null;
		FileUploadTransVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;

		String hosCode = "";
		String strItemCmb = "";

		try {
			util = new HisUtil("MMS Reports", "ProjectedDemandRequestTransDATA");
			bo = new FileUploadTransBO();
			voObj = new FileUploadTransVO();

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strAlphabet = request.getParameter("strAlphabet");
			String drugClass = request.getParameter("drugClass");

			formBean.setStrHospitalCode(hosCode);

			voObj.setStrHospitalCode(hosCode);
			voObj.setStrAlphabet(strAlphabet);
			voObj.setStrDrugClass(drugClass);

			bo.getDrugList(voObj); // Pkg_Mms_RPT.rptm_itembrand_list [Mode - 6]

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}

			if (voObj.getStrDrugWs() != null && voObj.getStrDrugWs().size() > 0) {
				strItemCmb = util.getOptionValue(voObj.getStrDrugWs(), "", "", true);
			} else {
				strItemCmb = "";
			}
		 
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strItemCmb);

		} catch (Exception e) {
			strMsgText = e.getMessage();			
			new HisException("e-Aushadhi", "ProjectedDemandRequestTransDATA->GetDataWithItem()", strMsgText);
		} finally {
			if (voObj != null) {
				voObj = null;
			}
			if (formBean != null) {
				formBean = null;
			}
			util = null;
		}
	}

	public static void getProgName(FileUploadTransFB formBean,HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		FileUploadTransBO bo = null;
		FileUploadTransVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;

		String strLeftProgList = "";

		try {
			util = new HisUtil("MMS Reports", "ProjectedDemandRequestTransDATA");
			bo = new FileUploadTransBO();
			voObj = new FileUploadTransVO();


			voObj.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			bo.getProgList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}

			if (voObj.getWbsProgrammeDtl() != null && voObj.getWbsProgrammeDtl().size() > 0) {
				strLeftProgList = util.getOptionValue(voObj.getWbsProgrammeDtl(), "", "", false);
			}
			else
			{
				strLeftProgList = "<option value='0'>All</option>";
			}
		 
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strLeftProgList);

		} catch (Exception e) {
			strMsgText = e.getMessage();		
			new HisException("e-Aushadhi", "ProjectedDemandRequestTransDATA->GetDataWithItem()", strMsgText);
		} finally {
			if (voObj != null) {
				voObj = null;
			}
			if (formBean != null) {
				formBean = null;
			}
			util = null;
		}
	}

	public static void getDemandType(FileUploadTransFB formBean,HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException 
	{

		FileUploadTransBO bo = null;
		FileUploadTransVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;
		String strData = "";

		try {
			util = new HisUtil("MMS Reports", "ProjectedDemandRequestTransDATA");
			bo = new FileUploadTransBO();
			voObj = new FileUploadTransVO();

			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			voObj.setStrIndentPeriodValue(request.getParameter("strIndentPeriodValue"));
			voObj.setStrMode("1");
			
			bo.getDemandType(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}

			if (voObj.getWrsData() != null && voObj.getWrsData().size() > 0) {
				strData = util.getOptionValue(voObj.getWrsData(), "0", "0^Select Value", true);
			} else {
				strData = "<option value='0'>Select Value</option>";
			}
		 
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strData);

		} catch (Exception e) {
			strMsgText = e.getMessage();			
			new HisException("e-Aushadhi", "ProjectedDemandRequestTransDATA->GetDataWithItem()", strMsgText);
		} finally {
			if (voObj != null) {
				voObj = null;
			}
			if (formBean != null) {
				formBean = null;
			}
			util = null;
		}
	}

	
	public static void deleteDetails(FileUploadTransFB formBean,HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException  
	{

		FileUploadTransBO bo = null;
		FileUploadTransVO voObj = null;
		String strMsgText = null;
		String strReqDtl = "";

		try {
			new HisUtil("MMS Reports", "ProjectedDemandRequestTransDATA");
			bo = new FileUploadTransBO();
			voObj = new FileUploadTransVO();

			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			voObj.setStrIndentPeriodValue(request.getParameter("strIndentPeriodValue"));
			voObj.setStrNotificationNo(request.getParameter("notificationNo"));

			voObj.setStrMode("3");
			bo.getExistingReqDtl(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}
			
				//strReqDtl = FileUploadTransHLP.getDeleteReqDtlHlp(voObj);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strReqDtl);

			} catch (Exception e) {

			}

		} catch (Exception e) {
			strMsgText = e.getMessage();			
			new HisException("e-Aushadhi", "ProjectedDemandRequestTransDATA->GetDataWithItem()", strMsgText);
			
		} finally {
			if (voObj != null) {
				voObj = null;
			}
			if (formBean != null) {
				formBean = null;
			}
		}
	}

	public static void extendDetails(FileUploadTransFB formBean,
			HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException{

		FileUploadTransBO bo = null;
		FileUploadTransVO voObj = null;
		String strMsgText = null;
		String strReqDtl = "";

		try {
			new HisUtil("MMS Reports", "ProjectedDemandRequestTransDATA");
			bo = new FileUploadTransBO();
			voObj = new FileUploadTransVO();

			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			voObj.setStrIndentPeriodValue(request.getParameter("strIndentPeriodValue"));
			voObj.setStrNotificationNo(request.getParameter("notificationNo"));

			voObj.setStrMode("3");
			bo.getExistingReqDtl(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}
			
				//strReqDtl = FileUploadTransHLP.getExtendSubmissionDateReqDtlHlp(voObj);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strReqDtl);

			} catch (Exception e) {

			}

		} catch (Exception e) {
			strMsgText = e.getMessage();		
			new HisException("e-Aushadhi", "ProjectedDemandRequestTransDATA->GetDataWithItem()", strMsgText);
			
		} finally {
			if (voObj != null) {
				voObj = null;
			}
			if (formBean != null) {
				formBean = null;
			}
		}
	}
	
	public static void viewDetails(FileUploadTransFB formBean,
			HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException{

		FileUploadTransBO bo = null;
		FileUploadTransVO voObj = null;
		String strMsgText = null;
		String strReqDtl = "";

		try {
			new HisUtil("MMS Reports", "ProjectedDemandRequestTransDATA");
			bo = new FileUploadTransBO();
			voObj = new FileUploadTransVO();

			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			voObj.setStrIndentPeriodValue(request.getParameter("strIndentPeriodValue"));
			voObj.setStrNotificationNo(request.getParameter("notificationNo"));

			voObj.setStrMode("3");
			bo.getExistingReqDtl(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}
			
			//	strReqDtl = FileUploadTransHLP.getViewReqDtlHlp(voObj);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strReqDtl);

			} catch (Exception e) {

			}

		} catch (Exception e) {
			strMsgText = e.getMessage();			
			new HisException("e-Aushadhi", "ProjectedDemandRequestTransDATA->GetDataWithItem()", strMsgText);
			
		} finally {
			if (voObj != null) {
				voObj = null;
			}
			if (formBean != null) {
				formBean = null;
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static void save(FileUploadTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{
		/*---------------------------- HLP --------------------------  */
		StringBuffer br = new StringBuffer();
		int count = 0;
		WebRowSet ws = null;
		int i = 1;		
		int width1 = 5;
		int width2 = 22;
		int width3 = 20;
		int width4 = 14;	
		int width5 = 13;
		int width6 = 13;	
		int width7 = 13;
		
		double cltamt1 = 0.00;
		double cltamt2 = 0.00;
		double totalCost1 = 0.00;
		double totalCost2 = 0.00;
		String strItemTotCost1 = "0.00";
		String strItemTotCost2 = "0.00";
		String FinaltotalCost1="";
		String FinaltotalCost2="";
		
		String amtStr1="";
		String amtStr2="";
		
		HisUtil util = new HisUtil("mms", "ViewPage");
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		NumberFormat formatter = new DecimalFormat("############.##");
		/*---------------------------- HLP --------------------------  */
		
		//System.out.println("save");
		String strFileName = "";
		String strFileExt = "";
		String temp[] = null;
		HisUtil hisutil = null;
		String strFileSaveMsg = "";
		FileUploadTransBO bo = null;
		FileUploadTransVO vo = null;
		String strStringObj ="",finalStr="",strSplit="",strRandomNo="";
		try
		{
			bo = new FileUploadTransBO();
			vo = new FileUploadTransVO();
			hisutil = new HisUtil("DWH Transaction","FileUploadTransDATA");
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId = request.getSession().getAttribute("SEATID").toString();
			vo.setStrSeatId(seatId);
			vo.setStrHospitalCode(hosCode);
			vo = (FileUploadTransVO) TransferObjectFactory.populateData("mms.transactions.vo.FileUploadTransVO", formBean);
		
			
			/* File Up-Loading Facility */		

			FormFile myFile = formBean.getStrLocation();			
			System.out.println("-strFileName------------"+strFileName);
            File pdfFile = null;			
			try 
			{
				
				myFile = formBean.getStrLocation();							
				FileInputStream fis=(FileInputStream) myFile.getInputStream();  
				
				org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory.create(fis);
				org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
				//evaluating cell type   
				FormulaEvaluator formulaEvaluator=workbook.getCreationHelper().createFormulaEvaluator(); 
				
				System.out.println("-----------------------------------------------------------------------");
				br.append("<div id='reportDivId'>");

				
				br.append("<table align='center' width='85%;' border='0' cellspacing='0' cellpadding='0' height='69'> ");
				br.append("<tr><td style='text-align:center;' colspan='6' ><img  align='absmiddle' src='http://" + request.getServerName() + ":"
						+ request.getServerPort() + "/INVMGM/hisglobal/images/aiims_inv_header.png' /></td>");
				br.append("</tr></table>");
				
								
				br.append("<table border='0' width='100%' align='center'> ");
				br.append("<tr> ");
				br.append("<td colspan='9' width='90%' align='center'>");
				br.append("<h2>Budget Allocation Detail Report</h2>");		
				br.append("</td>");
				br.append("<td colspan='3' align='right' width='40%'>");
				br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'><div id='printImg'>");
				br.append("<img style='cursor: pointer; ' title='Print Page'  ");
				//br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(1);' />");
				//br.append("<img style='cursor: pointer; ' title='Save as Pdf' src='../../hisglobal/images/pdf.png' onClick='generatePdfCommon(\"challanStatusDtlDivId\");' />");
				br.append("<img style='cursor: pointer; ' title='Save as Excel' src='../../hisglobal/images/excel1.png' onClick='generateXLSCommon(event,\"reportDivId\");' />");
				br.append("<img style='cursor: pointer; ' title='Cancel Process' src='../../hisglobal/images/stop.png' onClick='initPage1();' /> </div></div></div>");
				br.append(" </td> ");
				br.append(" </tr> ");
				br.append(" </table> ");
				
				br.append("<div id='wrapper' style='width:1500;'><table id='mainTableRptId' width='1250' border='0' align='center' cellspacing='1px' cellpadding='1px'>");
				// header
				br.append("<tr id='tableHeaderId'> ");
				br.append("<th style=\"text-align: center;\" colspan='1' width='" + width1
						+ "%'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No<b></font></th>\n");
				br.append("<th style=\"text-align: center;\" colspan='1' width='" + width2
						+ "%'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><b>Secret Code<b></font></th>\n");			
				br.append("<th style=\"text-align: center;\" colspan='1' width='" + width3
						+ "%'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><b>Store Name<b></font></th>\n");				
				br.append("<th style=\"text-align: center;\" colspan='1' width='" + width2
						+ "%'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><b>Allocated CENTRAL BUDGET(In Rs.)<b></font></th>\n");					
				br.append("</tr>");				
				System.out.println("-----------------------------------------------------------------------");
				
				
				
				int l=0;
				int rowCount =0;
				for(Row row: sheet)     //iteration over row using for each loop  
				{  
					//System.out.print("row--->>"+row.getRowNum());
					char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
					StringBuilder sb = new StringBuilder();
					Random random = new Random();
					for (int k = 0; k < 10; k++) {
					    char c = chars[random.nextInt(chars.length)];
					    sb.append(c);
					}
					strRandomNo = sb.toString().toUpperCase();
					br.append("<tr> ");
										
						if(row.getRowNum()>0)
						{
							br.append("<td style=\"text-align: center;\" colspan='1' width='" + width1
									+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + (row.getRowNum()) + "</font></td>\n"); // 1 Sr No
						}
						for(Cell cell: row)    //iteration over cell using for each loop  
						{  
							if(row.getRowNum()>0)
							{	
								//cell.getColumnIndex()
								br.append("<td style=\"text-align: left;\" colspan='1' width='" + width2+ "%'>");
								if(l>0)
								{
									
									switch(formulaEvaluator.evaluateInCell(cell).getCellType())  
									{  
									
										case Cell.CELL_TYPE_NUMERIC:   //field that represents numeric cell type  
										//getting the value of the cell as a number  
										//System.out.print("NUMERIC--->>"+cell.getNumericCellValue()+ "\t\t");   
										if(strStringObj.length()==0)
										{	
											if(cell.getNumericCellValue()!=0)
											{	
											   strStringObj = String.valueOf(cell.getNumericCellValue());
											}
											else
											{
											   strStringObj = "0.00";
											}
										}
										else
										{	if(cell.getNumericCellValue()!=0)
										    {
										      strStringObj = strStringObj+"@"+cell.getNumericCellValue();
										    }
										    else
										    {
										    	strStringObj = strStringObj+"@0.00";
										    }
										}
										
										br.append("<font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + cell.getNumericCellValue()+ "</font>\n");
										
										break;  
										case Cell.CELL_TYPE_STRING:   
										if(strStringObj.length()==0)
										{	
											strStringObj = cell.getStringCellValue();
										}
										else
										{	
										    strStringObj = strStringObj+"@"+cell.getStringCellValue();
										}
										if(!cell.getStringCellValue().contains("^"))
										{
										   br.append("<font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + cell.getStringCellValue()+ "</font>\n");
										}
										else
										{
											 br.append("<font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + strRandomNo+ "</font>\n");
											 br.append("<input type='hidden' id='strHQRealBudgetAvl' name='strHQRealBudgetAvl' value='"+cell.getStringCellValue()+"'/>\n");
										}
										break;  
									}
									
								}
								br.append("</td>\n");
							}
							
							l++;
							
						  }	
						br.append("<input type='hidden'  name='strHtmlCodeHidden' value='"+strStringObj+"'/>\n");
						br.append("</tr> ");
						
						if(rowCount==1)
						{	
							  
						     finalStr = strStringObj;
						      
						} 
						else
						{
							  
							 finalStr = finalStr+"#"+strStringObj;
							
						}
						rowCount++;
						
						strStringObj="";
						
						//System.out.print("finalStr--->>"+finalStr);   
								
					//System.out.println("\n---------------------------------------------------------------");  
				} 
				//br.append("<input type='hidden' id='setStrHtmlCodeHidden' name='setStrHtmlCodeHidden' value='"+finalStr.split("\\#").toString()+"'/>\n");
				
				String srr[] = finalStr.split("\\#");
				for(int m=0;m<srr.length;m++)
				{	
				  strSplit = srr[m].split("\\@")[0];  //used to split the string data
				  
				 // 89900001^140^101^15027^12^19^99901083^2019 - 2020@Bihta Rh@1000.0
				  //System.out.println("strSplit--->"+strSplit);  //89900001^140^101^15027^12^19^99901086^2019 - 2020
				  if(m==0)
				  {	  
				    if((srr[m].split("\\@")[2].length()>0) //&& (srr[m].split("\\@")[3].length()>0)
				    	)
				    {
				     strItemTotCost1 = formatter.format(new BigDecimal(srr[m].split("\\@")[2]));
				     //strItemTotCost2 = formatter.format(new BigDecimal(srr[m].split("\\@")[3]));
				     cltamt1 = Double.parseDouble(strItemTotCost1);
				     //cltamt2 = Double.parseDouble(strItemTotCost2);
				    }
				    totalCost1 = cltamt1;
				    //totalCost2 = cltamt2;
				  }
				  else
				  {
					  if((srr[m].split("\\@")[2].length()>0)// && (srr[m].split("\\@")[3].length()>0)
							  )
					    {
					     strItemTotCost1 = formatter.format(new BigDecimal(srr[m].split("\\@")[2]));
					     //strItemTotCost2 = formatter.format(new BigDecimal(srr[m].split("\\@")[3]));
					     cltamt1 = Double.parseDouble(strItemTotCost1);
					    // cltamt2 = Double.parseDouble(strItemTotCost2);
					     
					    }
					  
				      totalCost1 = totalCost1 + cltamt1;
				      //totalCost2 = totalCost2 + cltamt2;
				  }  
				//fetching Dwh Type Id For Validation Of Dcs Budget anruag verma
				  if(srr[m].split("\\@")[0].split("\\^")[5].equals("12") || srr[m].split("\\@")[0].split("\\^")[5]=="12")
				  {	
					 System.out.println("Dwh_type_id-->"+srr[m].split("\\@")[0].split("\\^")[5]);
					 formBean.setStrDcsBudget(srr[m].split("\\@")[2]);
				  }
				} 
				
			  
				//89900001^140^101^15027^12^19^99901083^2019 - 2020

				bo.getNames(vo,strSplit);	
				formBean.setStrFinancialYearCombo(strSplit.split("\\^")[7]);  //financial year value
				formBean.setStrQuarterPeriod(vo.getStrGetNames().split("\\^")[4]);
				formBean.setStrProgrammeCmb(vo.getStrGetNames().split("\\^")[1]);
				formBean.setStrFundSourceCmb(vo.getStrGetNames().split("\\^")[2]);
				formBean.setStrDistrictCmb(vo.getStrGetNames().split("\\^")[3]);
				formBean.setStrDWHSubTypeCmb(vo.getStrGetNames().split("\\^")[5]);
				
				formBean.setStrHiddenQuarterPeriod(vo.getStrGetNames().split("\\^")[4]);
				
				vo.setStrFinancialYearCombo(strSplit.split("\\^")[6]);
				vo.setStrQuarterPeriod(strSplit.split("\\^")[4]);
				vo.setStrProgrammeCmb(strSplit.split("\\^")[1]);
				vo.setStrFundSourceCmb(strSplit.split("\\^")[2]);
				vo.setStrDistrictCmb(strSplit.split("\\^")[3]);
				vo.setStrDWHSubTypeCmb(strSplit.split("\\^")[5]);
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				
				 bo.getBudgetDetails(vo); 
				 //TOTAL_CENTRAL_BUDGET^USED_CENTRAL_BUDGET^AVLAIBLE_CENTRAL_BUDGET  --previous
				 //TOTAL_REALIZED_BUDGET [1]^USED_REALIZED_BUDGET [2]^ AVLAIBLE_REALIZED_BUDGET [3]^ AVLAIBLE_CP_BUDGET [4]^ AVLAIBLE_LP_BUDGET [5]
				 formBean.setStrAllocatedRealizedBudget(vo.getStrAllocatedRealizedBudget());
				 formBean.setStrAvailableRealizedBudget(vo.getStrAvailableRealizedBudget());
				 formBean.setStrAvailableLocalBudget(vo.getStrAvailableLocalBudget());
				 formBean.setStrAvailableCentralBudget(vo.getStrAvailableCentralBudget());
				 formBean.setStrAvalHiddenBudget(vo.getStrAvailableRealizedBudget());
				
				/* System.out.println("AllocatedRealizedBudget--->"+formBean.getStrAllocatedRealizedBudget());
				 System.out.println("AvailableRealizedBudget-->"+formBean.getStrAvailableRealizedBudget());
				 System.out.println("AvailableLocalBudget-->"+formBean.getStrAvailableLocalBudget());
				 System.out.println("AvailableCentralBudget-->"+formBean.getStrAvailableCentralBudget());
				 System.out.println("setStrAvalHiddenBudget-->"+formBean.getStrAvalHiddenBudget());*/
				 //hidden value
				
				 //formBean.setStrHtmlCodeHidden(finalStr);
					  	
				
				FinaltotalCost1 = formatter.format(new BigDecimal(totalCost1));
				//FinaltotalCost2 = formatter.format(new BigDecimal(totalCost2));
				//formBean.setStrTotalLocalHiddenCost(Double.toString(totalCost1));
				formBean.setStrTotalCentralHiddenCost(Double.toString(totalCost1));
				
					
				//System.out.print("Total COst --->>"+totalCost1+" Rs.");  			
				amtStr1 = "("+ util.toInitCap(util.getAmountStr(myFormatter.format(totalCost1))) + ")";
				amtStr2 = "("+ util.toInitCap(util.getAmountStr(myFormatter.format(totalCost2))) + ")";
				//System.out.println("\n---------------------------------------------------------------");  
				br.append("<tr>");
				br.append("<td CLASS='multiControl' colspan='1' width='" + width1+"'></td>");
				br.append("<td CLASS='multiControl' colspan='2' width='" + width2+"' style=\"text-align:right; font-weight: bold;\">Total Cost(Rs.)</td>");
				br.append("<td CLASS='multiControl' colspan='1' width='"+width2+"' style=\"text-align:right; font-weight: bold;\">"
						+ FinaltotalCost1 + "</td>");
				//br.append("<td CLASS='multiControl' colspan='1' width='"+width2+"' style=\"text-align:right; font-weight: bold;\">"
				//		+ FinaltotalCost2 + "</td>");
				br.append("</tr>");
				//System.out.println("Total cost1-"+FinaltotalCost1+"2-"+FinaltotalCost2+"3-"+FinaltotalCost3);
				
				br.append("<tr>");
				br.append("<td CLASS='multiControl' colspan='1' width='" + width1+"' bgcolor='#FFEBD5'></td>");
				br.append("<td colspan='2' width='" + width2+"' bgcolor='#FFEBD5'  style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1' color='#653232' ><b>Total Cost(Words)</b></font></td>");
				br.append("<td colspan='1' width='" + width2+"' bgcolor='#F1ECE2'   style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
				br.append(amtStr1);
				br.append("</font></td>");
				//br.append("<td colspan='1' width='" + width2+"' bgcolor='#F1ECE2'   style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
				//br.append(amtStr2);
				br.append("</font></td>");
				br.append("</tr>");
				br.append("</table></div>");
				//System.out.println("\n---------------------------------------------------------------");  
				//System.out.println("HLP STring-----------"+br.toString());
				
			     String strHtmlData =
							"<html><head><title>Budget Allocation Deatil</title></head><body>"
									+ br.toString() + "</body></html>";
			     formBean.setHtmlCode(strHtmlData);
			     
			     //System.out.println("finalStr----------------------------------"+finalStr);
			     
			    
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				formBean.setStrWarning("Kindly upload valid excel file.");
			}
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			//formBean.setStrMsg("Data Saved Successfully!!");
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	
	public static void saveBudgetDtl(FileUploadTransFB formBean,HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		FileUploadTransBO bo = null;
		FileUploadTransVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;

		try {
			util = new HisUtil("MMS Reports", "FileUploadTransDATA");
			bo   = new FileUploadTransBO();
			
			voObj = new FileUploadTransVO();
			
			voObj.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		    voObj.setStrHtmlCodeHidden(formBean.getStrHtmlCodeHidden());
		    voObj.setStrDcsBudget(formBean.getStrDcsBudget());
		    //System.out.println("hiddenvalue-->"+voObj.getStrHtmlCodeHidden().length);
			
		    //
		    bo.saveBudgetIntoDB(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}
			formBean.setStrMsg("Data Saved Successfully!!");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("e.getMessage()->"+e.getMessage().toString().split("\\::")[1]);
			if (e.getMessage().toString().split("\\::")[1].equals(" Budget is already Allocated!!!")) 
			{
				formBean.setStrWarning("Budget is already Allocated for this Store Type!!!");
			}
		}
		finally {
			if (voObj != null) {
				voObj = null;
			}
			if (formBean != null) {
				formBean = null;
			}
			util = null;
		}
	}
	public static void saveDelete(FileUploadTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {
		
		
		FileUploadTransBO bo = null;
		FileUploadTransVO vo = null;
		try{
			bo = new FileUploadTransBO();
			vo = new FileUploadTransVO();
		
			vo = (FileUploadTransVO) TransferObjectFactory.populateData("mms.transactions.vo.FileUploadTransVO", formBean);
			
			bo.saveDelete(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			
			formBean.setStrMsg("Data Saved Successfully!!");
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static void saveExtend(FileUploadTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {
		
		
		FileUploadTransBO bo = null;
		FileUploadTransVO vo = null;
		try{
			bo = new FileUploadTransBO();
			vo = new FileUploadTransVO();
		
			vo = (FileUploadTransVO) TransferObjectFactory.populateData("mms.transactions.vo.FileUploadTransVO", formBean);
			
			bo.saveExtend(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			
			formBean.setStrMsg("Data Saved Successfully!!");
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
