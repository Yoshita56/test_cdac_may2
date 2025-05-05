package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.global.controller.MmsFB;
import mms.reports.bo.MaterialOutwardRegisterRptBO;
import mms.reports.controller.fb.MaterialOutwardRegisterRptFB;
import mms.reports.controller.hlp.MaterialOutwardRegisterRptHLP;
import mms.reports.vo.MaterialOutwardRegisterRptVO;

public class MaterialOutwardRegisterRptDATA {
	
	public static void getInitializedValues(MaterialOutwardRegisterRptFB materialOutwardRegisterRptFB_p,	HttpServletRequest request, HttpServletResponse response) {

		MaterialOutwardRegisterRptBO bo = null;
		MaterialOutwardRegisterRptVO voObj = null;
		String strMsgText = null;
		String strCurrentDate;
		HisUtil hisutil = null;
		
		int strCurrentMonth;
		int CURRENT_YEAR;
		
		String strCurrentFinancialYear;
		String strNextFinancialYear;
		String strHospitalCode,strStoreVal,strDwhTypeVal,strSupplierVal;
		
		try {

			bo = new MaterialOutwardRegisterRptBO();
			voObj = new MaterialOutwardRegisterRptVO();
			
			//String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			materialOutwardRegisterRptFB_p.setStrHospitalCode(strHospitalCode);
			materialOutwardRegisterRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
			hisutil = new HisUtil("DWH","MaterialOutwardRegisterRptDATA");
			
					
			strCurrentDate=hisutil.getASDate("dd-MM-yyyy");
			
			
			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
			
			
			if(strCurrentMonth>=4 ){
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
				
			
			strCurrentFinancialYear = CURRENT_YEAR + " - " + (CURRENT_YEAR + 1); 
			
			voObj.setStrSeatId(materialOutwardRegisterRptFB_p.getStrSeatId());
			voObj.setStrHospitalCode(strHospitalCode);
			/*if(strUserLevel.equals("6")){
				voObj.setStrMode("4");
			}
			else
				*/voObj.setStrMode("5");
			
			bo.getInitializedValues(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
			
	/*		if(strUserLevel.equals("6"))
			{
			strStoreVal = hisutil.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", false);
			}
			else
			*/{
		    strStoreVal = hisutil.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", false);	
			}
			
			
			materialOutwardRegisterRptFB_p.setStrStoreValues(strStoreVal);
			
			strSupplierVal = hisutil.getOptionValue(voObj.getStrManufactureComboWS(), "0", "0^Select Value", false);
			materialOutwardRegisterRptFB_p.setStrManufactureCombo(strSupplierVal);
						
			hisutil = new HisUtil("MMS Transactions", "MaterialOutwardRegisterRptDATA");
			// For setting the financial year 
			materialOutwardRegisterRptFB_p.setStrStartFinancialYear(""+CURRENT_YEAR);
			materialOutwardRegisterRptFB_p.setStrEndFinancialYear(""+(CURRENT_YEAR+1));
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			materialOutwardRegisterRptFB_p.setStrCurrentDate(strCurrentDate);			
		

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.transactions.MaterialOutwardRegisterRptDATA.getInitializedValues --> "+ e.getMessage();
			HisException eObj = new HisException("dwh",	"MaterialOutwardRegisterRptDATA->getInitializedValues()", strMsgText);
			materialOutwardRegisterRptFB_p.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} 
		finally 
		{
			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			if (hisutil != null)
				hisutil = null;
		}
	}
	
	 /**
	  * 
	  * @param formBean
	  * @param request
	  * @param response
	  */
	 public static void getIssueDetails(MaterialOutwardRegisterRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	 {

				MaterialOutwardRegisterRptBO bo = null;
				MaterialOutwardRegisterRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new MaterialOutwardRegisterRptBO();
					vo = new MaterialOutwardRegisterRptVO();
					mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
													
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					vo.setStrStoreId(request.getParameter("StoreId"));
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					vo.setStrToStoreId(request.getParameter("ToStoreId"));
									
					bo.getIssueDetails(vo);
					
					String strItemDetails = MaterialOutwardRegisterRptHLP.getIssueDetails(vo.getStrIssueDtlWs());
					
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
					strmsgText = "mms.transactions.IssueTransDATA.getIssueDetails --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"IssueTransDATA->getIssueDetails()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
							+ eObj.getErrorID() + "],Contact System Administrator! ");
					
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
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
	 public static void printIssueDetailsMain(MaterialOutwardRegisterRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	 {

				MaterialOutwardRegisterRptBO bo = null;
				MaterialOutwardRegisterRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new MaterialOutwardRegisterRptBO();
					vo = new MaterialOutwardRegisterRptVO();
					mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
													
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					vo.setStrStoreId(request.getParameter("StoreId"));
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					vo.setStrToStoreId(request.getParameter("ToStoreId"));
						
					vo.setStrStoreName(request.getParameter("fromStoreName"));
					vo.setStrToStoreName(request.getParameter("toStoreName"));
					
					bo.getIssueDetails(vo);
					
					//String strItemDetails = MaterialOutwardRegisterRptHLP.printIssueDetailsPopUpMain(vo.getStrIssueDtlWs(),vo);
					String strItemDetails = MaterialOutwardRegisterRptHLP.getPrintScreenTwo(vo.getStrIssueDtlWs(),vo);					
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					strmsgText = "mms.transactions.IssueTransDATA.getIssueDetails --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"IssueTransDATA->getIssueDetails()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
							+ eObj.getErrorID() + "],Contact System Administrator! ");
					
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
					if (util != null)
						util = null;
					}
				}
	 
	 public static void getToStoreCmb(MaterialOutwardRegisterRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	 {

				MaterialOutwardRegisterRptBO bo = null;
				MaterialOutwardRegisterRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new MaterialOutwardRegisterRptBO();
					vo = new MaterialOutwardRegisterRptVO();
					mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
													
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					vo.setStrStoreId(request.getParameter("StoreId")!=null?request.getParameter("StoreId"):"0");
					vo.setStrCategoryId("0"); // Category Code for Drugs = 10
					
					// Calling BO
						bo.getToStoreCmb(vo);
						
						if(request.getParameter("StoreId")!=null)
						{
							response.setHeader("Cache-Control", "no-cache");
							response.getWriter().print(vo.getStrToStoreCombo());		
						}
						else							
							formBean.setStrToStoreValues(vo.getStrToStoreCombo());
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
					strmsgText = "mms.transactions.IssueTransDATA.getIssueDetails --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"IssueTransDATA->getToStoreCmb()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
							+ eObj.getErrorID() + "],Contact System Administrator! ");
					
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
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
	 public static void getIssueDtlPopUp1(MaterialOutwardRegisterRptFB formBean,HttpServletRequest request, HttpServletResponse response) 
	 {

				MaterialOutwardRegisterRptBO bo = null;
				MaterialOutwardRegisterRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new MaterialOutwardRegisterRptBO();
					vo = new MaterialOutwardRegisterRptVO();
					mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
																				
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					
					vo.setStrStoreId(request.getParameter("StoreId")!=null?request.getParameter("StoreId"):"0");
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					vo.setStrToStoreId(request.getParameter("ToStoreId")!=null?request.getParameter("ToStoreId"):"0");
					
					
					bo.getIssueDtlPopUp1(vo);
					
					String strItemDetails = MaterialOutwardRegisterRptHLP.getIssueDetailsPopUp1(vo.getStrIssueDtlWs(),vo);
					
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					strmsgText = "mms.transactions.IssueTransDATA.getItemDetails --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"IssueTransDATA->getItemDetails()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
							+ eObj.getErrorID() + "],Contact System Administrator! ");
					
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
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
	 public static void getIssueDtlPopUp2(MaterialOutwardRegisterRptFB formBean,HttpServletRequest request, HttpServletResponse response) 
	 {

				MaterialOutwardRegisterRptBO bo = null;
				MaterialOutwardRegisterRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new MaterialOutwardRegisterRptBO();
					vo = new MaterialOutwardRegisterRptVO();
					mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
																				
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					
					vo.setStrStoreId(request.getParameter("StoreId")!=null?request.getParameter("StoreId"):"0");
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					vo.setStrToStoreId(request.getParameter("ToStoreId")!=null?request.getParameter("ToStoreId"):"0");
					
					
//					vo.setStrStoreId(request.getParameter("StoreId"));
//				    vo.setStrIssueNumber(request.getParameter("IssueNo"));
//					vo.setStrFromDate(request.getParameter("fromDate"));
//					vo.setStrToDate(request.getParameter("toDate"));
					
					
					
					
					bo.getIssueDtlPopUp2(vo);
					
					String strItemDetails = MaterialOutwardRegisterRptHLP.getIssueDetailsPopUp2(vo.getStrIssueDtlWs(),vo);
					
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					strmsgText = "mms.transactions.IssueTransDATA.getItemDetails --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"IssueTransDATA->getItemDetails()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
							+ eObj.getErrorID() + "],Contact System Administrator! ");
					
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
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
	 public static void getIssueItemDtl(MaterialOutwardRegisterRptFB formBean,HttpServletRequest request, HttpServletResponse response) 
	 {

				MaterialOutwardRegisterRptBO bo = null;
				MaterialOutwardRegisterRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new MaterialOutwardRegisterRptBO();
					vo = new MaterialOutwardRegisterRptVO();
					mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
																				
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					vo.setStrStoreId(request.getParameter("StoreId"));
				    vo.setStrIssueNumber(request.getParameter("issueNo"));
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					
					
					
					
					bo.getIssueItemDetails(vo);
					
					String strItemDetails = MaterialOutwardRegisterRptHLP.getIssueDetailsPopUp3(vo.getStrIssueItemDtlWs(),vo);
					
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					strmsgText = "mms.transactions.IssueTransDATA.getItemDetails --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"IssueTransDATA->getItemDetails()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
							+ eObj.getErrorID() + "],Contact System Administrator! ");
					
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
					if (util != null)
						util = null;
					}
				}

	

/*	
	public static void getStoreList(MaterialOutwardRegisterRptFB materialOutwardRegisterRptFB_p,HttpServletRequest request, HttpServletResponse response) 
	{

		MaterialOutwardRegisterRptBO bo = null;
		MaterialOutwardRegisterRptVO voObj = null;
		String strmsgText = null;
		String strHospitalCode, strStoreVal = "";
		String strDwhTypeVal;

		HisUtil util = null;
		try {

			bo = new MaterialOutwardRegisterRptBO();
			voObj = new MaterialOutwardRegisterRptVO();
			
			strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			materialOutwardRegisterRptFB_p.setStrHospitalCode(strHospitalCode);
			materialOutwardRegisterRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			voObj.setStrHospitalCode(strHospitalCode);
			voObj.setStrSeatId(materialOutwardRegisterRptFB_p.getStrSeatId());
			materialOutwardRegisterRptFB_p.setStrDrugWarehouseTypeId(request.getParameter("dwhTypeId"));
			
			
			voObj.setStrDrugWarehouseTypeId(materialOutwardRegisterRptFB_p.getStrDrugWarehouseTypeId());
			
				
			
			bo.getStoreList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("DWH", "MaterialOutwardRegisterRptDATA");
			
			strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^Select Value", false);
						
		
			 response.setHeader("Cache-Control", "no-cache");
			 response.getWriter().print(strStoreVal);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.MaterialOutwardRegisterRptDATA.getStoreList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MaterialOutwardRegisterRptDATA->getStoreList()", strmsgText);
			materialOutwardRegisterRptFB_p.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			if (util != null)
				util = null;
		}
	}
	*/
	
	public static void showReport(MaterialOutwardRegisterRptFB materialOutwardRegisterRptFB_p,HttpServletRequest request, HttpServletResponse response) {
	
		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
	
	
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strProcRelatedValue = request.getParameter("strProcRelatedValue");
			
				
			
			String strHospitalCode = materialOutwardRegisterRptFB_p.getStrHospitalCode();
			String strFromDate = materialOutwardRegisterRptFB_p.getStrFromDate();
			String strToDate = materialOutwardRegisterRptFB_p.getStrToDate();
			
			String strUserRemarks = materialOutwardRegisterRptFB_p.getStrUserRemarks();
			
			reportFormat = materialOutwardRegisterRptFB_p.getStrReportFormat();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			if(materialOutwardRegisterRptFB_p.getStrIsFooter()==null)
				materialOutwardRegisterRptFB_p.setStrIsFooter("0");
			
			if (materialOutwardRegisterRptFB_p.getStrIsFooter().equals("1"))
			{
				footerVisible = false;
				
			}
		
			
			String strReportName = "Material Outward Register Report";
	
							
				String reportPath = "/mms/reports/dwh_materialOutwardRegister_rpt.rptdesign";
			
//			String reportPath = "/mms/reports/dwh_drugWarehouseWiseSupplierDeliveryDetail_rpt.rptdesign";
				
				//System.out.println("store id"+materialOutwardRegisterRptFB_p.getStrStoreId());
				//System.out.println("to store id"+materialOutwardRegisterRptFB_p.getStrToStoreId());
				params.put("mode", "1");
				params.put("report_id", "0");
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				params.put("storeId", materialOutwardRegisterRptFB_p.getStrStoreId());
				params.put("tostoreId", materialOutwardRegisterRptFB_p.getStrToStoreId());
				params.put("hospCode", strHospitalCode);
				params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
				params.put("toDate", sdf.format(sdf.parse(strToDate)));
				params.put("storeName", "add");
				
				
				
											
				ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);
				
			
		      	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
	}

	
	
	/**
	 * Gets the issue dtls init view.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the issue dtls init view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String getIssueDtlsInitView(MmsFB formBean,MaterialOutwardRegisterRptFB materialOutwardRegisterRptFB_p) throws Exception 
	{

		StringBuffer sb = new StringBuffer("");
		String strIssueBy = "";
		String strRecivedBy = "";
		/*
		String str2 = "76.39";
		float f = Float.parseFloat(str2);
		String str = "5";
		Float f = new Float(str);
		double d = f.doubleValue();
		
		*/
		double cltamt  = 0.00;
		double totalCost = 0.00;
		String strStoreName="";
		
		int i=1;
		String strItemTotCost="0.00";
		HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}

		WebRowSet ws = formBean.getWsIssueDetails();
        
		String strIssueDate = "";

		if (formBean.getStrIssueDate().length() > 2) 
		{
			strIssueDate = formBean.getStrIssueDate();
		}

		String strTableWidth = "700";

		try 
		{

			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("REPORT_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("FULL_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("CITY"));
			sb.append("</font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");

			
			sb.append(
								"<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
			.append(strTableWidth)
			.append("'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Report For&nbsp;Acknowledge</b></font></td></tr></table> ");
			
			
			
			if (formBean.getStrStoreName().length() != 0) 
			{
				sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
						.append(strTableWidth).append("'><TR> <td align='center' ><b>(").
						append(formBean.getStrStoreName()).append(
								")</b> </td></tr></table>");

			}
			
			
			sb.append("<table border='0' width='").append(strTableWidth)
					.append("' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
            /*   Hide Save Button by Amit 24-Sep-2010
			 
			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'> <img style='cursor: pointer; ' title='Save Page'  ");
			sb.append(" src='../../hisglobal/images/save_all.png' onClick='saveData(\"").append(formBean.getStrIssueNo())
					.append("\");' /> <img style='cursor: pointer; ' title='Print Page'  ");
			*/
			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			sb.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopup();' /> </div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			sb.append(" <br> ");
			sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");

			
			if(!formBean.getStrModeVal().equals("5"))
			{	

				sb.append("<tr> ");
	
				sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Issue No.", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(formBean.getStrIssueNo())
						.append("</b></font></td> ");
	
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Issue Date", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strIssueDate).append(
						"</b></font></td> ");
				sb.append("</tr> ");
							
				if (!formBean.getStrIndentNo().equals("0")) 
				{
					sb.append("<tr> ");
					sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Request No.", 15,0)).append(":</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							formBean.getStrIndentNo()).append("</b></font></td> ");
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Request Date", 15,0)).append(	":</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							formBean.getStrIndentDate()).append("</b></font></td> ");
					sb.append("</tr> ");
	
				}
				/*
				 * This is for Only Issue To
				  sb.append("<tr> ");
				  sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(util.appendSpace("Issue To", 15,0)).append(":</b></font></td> ");
			 	  sb.append("<td width='75%' colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(formBean.getStrIssueTo()).append("</b></font></td> ");
				 */
				if(!formBean.getStrModeVal().equals("3"))
				{
					sb.append("<tr> ");
					sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Issue To", 15,0)).append(":</b></font></td> ");
					sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							formBean.getStrIssueTo()).append("</b></font></td> ");
	
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Budget Avl.", 15,0)).append(":</b></font></td> ");
					sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							formBean.getStrBudget()).append("</b></font></td> ");
					
					sb.append("</tr> ");
				
				    sb.append("<tr><TD COLSPAN='4'>&nbsp;</td></tr>");
				}
				else
				{
					sb.append("<tr> ");
					sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Issue To", 15,0)).append(":</b></font></td> ");
					sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							formBean.getStrIssueTo()).append("</b></font></td> ");
	
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("", 15,0)).append("</b></font></td> ");
					sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("</b></font></td> ");
					
					sb.append("</tr> ");
				
				    sb.append("<tr><TD COLSPAN='4'>&nbsp;</td></tr>");
					
				}	
			}
			else
			{
				sb.append("<tr> ");
				
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Return No.", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(formBean.getStrIssueNo())
						.append("</b></font></td> ");
	
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Return Date", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strIssueDate).append(
						"</b></font></td> ");
				sb.append("</tr> ");
							
				
					sb.append("<tr> ");
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>&nbsp;").append(
							util.appendSpace("Return Req. No.", 15,0)).append(
							":</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							formBean.getStrReturnReqNo()).append("</b></font></td> ");
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>&nbsp;").append(
							util.appendSpace("Return Req. Date", 15,0)).append(
							":</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							formBean.getStrIndentDate()).append("</b></font></td> ");
					sb.append("</tr> ");
	
				
					sb.append("<tr> ");
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Return From", 15,0)).append(":</b></font></td> ");
					sb.append("<td width='75%' colspan='3' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							formBean.getStrIssueTo()).append("</b></font></td> ");

					sb.append("</tr> ");
				
			}				
			
			sb.append("</table> ");

			sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");

			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
			sb.append("</td>");
						
			sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font> ");
			sb.append("</td>");

			if (!formBean.getStrSlNoflg().equals("0")) 
			{
				sb.append("<td align='center' width='14%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Serial No.</b></font> ");
				sb.append("</td> ");
			}

			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font> ");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font>");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit</b></font> ");
			sb.append("</td> ");
			if(!formBean.getStrModeVal().equals("5"))
			{
			   sb.append("<td align='center' width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty</b></font>");
			   sb.append("</td> ");
			   if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5"))
				{
			      sb.append("<td align='center' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost</b></font>");
			      sb.append("</td> ");
				}
			}
			else
			{
				sb.append("<td align='center' width='14%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Return Qty</b></font> ");
				sb.append("</td> ");
			}	
			sb.append("</tr> ");

			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{

					if (formBean.getStrModeVal().equals("4")) 
					{
						strIssueBy = ws.getString(28);
						strRecivedBy = ws.getString(27);
						strItemTotCost = ws.getString(30);
					} 
					else 
					{
						if (formBean.getStrModeVal().equals("2"))
						{
							strRecivedBy   = ws.getString(28);
							strStoreName   = ws.getString(4);
							
							
							//strItemTotCost = ws.getString(29);
							
							NumberFormat formatter = new DecimalFormat("############.##");  
						    
							strItemTotCost = formatter.format(new BigDecimal(ws.getString(29)));  
							
						}
					}
					
					
					cltamt  = Double.parseDouble(strItemTotCost);
										
					totalCost = totalCost + cltamt;
											
					sb.append("<tr> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(i);
					sb.append("</font></td> ");
					
					
					sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(6));
					sb.append("</font></td> ");

					if (!formBean.getStrSlNoflg().equals("0")) 
					{
						sb.append("<td align='center' width='14%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(22));
						sb.append("</font></td> ");
					}

					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(7));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(8));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(9));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(10));
					sb.append("</font></td> ");
					if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5") )
					{
						sb.append("<td align='center' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strItemTotCost);
						sb.append("</font></td> ");  
					}
					
					
					sb.append("</tr> ");
					i++;
								
				}
				
				
				if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5"))
				{	
					NumberFormat formatter = new DecimalFormat("############.##");  
				    
					String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
					
					sb.append("<tr>");
					sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
					sb.append("<td colspan='1' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(FinaltotalCost);				
					sb.append("</font></td>");
					sb.append("</tr>");
					
					 
					
					double avlBudget =  Double.parseDouble(formBean.getStrBudget());
										
					double remainingBudget = avlBudget - totalCost;
										
					////System.out.println(new BigDecimal(remainingBudget));  
						
					    
					String finalBudget = formatter.format(new BigDecimal(remainingBudget));  
					
					////System.out.println("O/P::::"+f);// output --> 0.00007 
					
										 
				       
					sb.append("<tr>");
					sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Balance Budget(Rs.)</b></td>");
					sb.append("<td colspan='1'  style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(finalBudget);				
					sb.append("</font></td>");
					sb.append("</tr>");
				}
				if (formBean.getStrModeVal().equals("4")) 
				{

					
					sb.append("<tr> "); 
					sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
					sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");
					sb.append(formBean.getStrFinalRemarks());
					sb.append("<br></font></td>");
			        sb.append("</tr> ");
					
					
					sb.append("<tr> ");
					sb
							.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b> &nbsp;&nbsp;</font></td> ");
					sb
							.append("<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Issued By<br><b> &nbsp;&nbsp;</font></td> ");
					sb.append("</tr> ");
					sb.append("<tr> ");
					sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>(")
							.append(strRecivedBy).append(
									")<br><b> &nbsp;&nbsp;</font></td> ");
					sb.append("<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>(")
							.append(strIssueBy).append(
									")<br><b> &nbsp;&nbsp;</font></td> ");
					sb.append("</tr> ");

				} 
				
				else 
				{

					if(!formBean.getStrModeVal().equals("5"))
					{
						if(!formBean.getStrModeVal().equals("3"))
						{	
							sb.append("<tr> "); 
							sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
							sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");
							if(!formBean.getStrFinalRemarks().equals("")||!formBean.getStrFinalRemarks().equals(" ")||!formBean.getStrFinalRemarks().equals(null))
							{
							    sb.append(formBean.getStrFinalRemarks());
							} 
							else
							{
								sb.append("--------");	
							}	
							sb.append("<br></font></td>");
					        sb.append("</tr> ");
							
							
							sb.append("<tr> ");
							sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
							sb.append("</tr> ");
							sb.append("<tr> ");
							sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>(").append(strRecivedBy).append(
											")<b> &nbsp;&nbsp;</font></td> ");
							sb.append("</tr> ");
						}
						else
						{
							sb.append("<tr> "); 
							sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
							sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");
							
							sb.append("--------");	
								
							sb.append("<br></font></td>");
					        sb.append("</tr> ");
							
							
							sb.append("<tr> ");
							sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
							sb.append("</tr> ");
							sb.append("<tr> ");
							sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>(").append(strRecivedBy).append(
											")<b> &nbsp;&nbsp;</font></td> ");
							sb.append("</tr> ");
						}	
						
										
					}
					else
					{
						
						sb.append("<tr> ");
						sb
								.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Return By<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("</tr> ");
						
					}	
				}

			} 
			else 
			{

				sb.append("<tr> ");
				sb
						.append("<td colspan='8' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}

		return sb.toString();
	}
}
