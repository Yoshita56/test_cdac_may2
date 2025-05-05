package mms.reports.controller.data;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.reports.bo.DebtorRegisterRptBO;
import mms.reports.controller.fb.DebtorRegisterRptFB;
import mms.reports.controller.fb.MaterialOutwardRegisterRptFB;
import mms.reports.controller.hlp.DebtorRegisterRptHLP;
import mms.reports.vo.DebtorRegisterRptVO;

public class DebtorRegisterRptDATA 
{
	   public static void getInitializedValues(DebtorRegisterRptFB MaterialInwardRptFB_p,	HttpServletRequest request, HttpServletResponse response) 
	   {

		DebtorRegisterRptBO bo = null;
		DebtorRegisterRptVO voObj = null;
		String strMsgText = null;
		String strCurrentDate;
		HisUtil hisutil = null;
		
		int strCurrentMonth;
		int CURRENT_YEAR;
		
		String strHospitalCode,strStoreVal;
		
		try {

			bo = new DebtorRegisterRptBO();
			voObj = new DebtorRegisterRptVO();
			
			String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			MaterialInwardRptFB_p.setStrHospitalCode(strHospitalCode);
			MaterialInwardRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
			hisutil = new HisUtil("DWH","DebtorRegisterRptDATA");
			
					
			strCurrentDate=hisutil.getASDate("dd-MM-yyyy");
			
			
			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
			
			
			if(strCurrentMonth>=4 ){
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
				
			
			//strCurrentFinancialYear = CURRENT_YEAR + " - " + (CURRENT_YEAR + 1); 
			
			voObj.setStrSeatId(MaterialInwardRptFB_p.getStrSeatId());
			voObj.setStrHospitalCode(strHospitalCode);
			
			if(strUserLevel.equals("6")){
				voObj.setStrMode("4");
			}
			else
				voObj.setStrMode("5");
			
			bo.getInitializedValues(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
			if(strUserLevel.equals("6"))
			{
			strStoreVal = hisutil.getOptionValue(voObj.getStrStoreWs(), "0", "0^Select Value", false);
			}
			else
			{
		    strStoreVal = hisutil.getOptionValue(voObj.getStrStoreWs(), "0", "0^Select Value", false);	
			}
			MaterialInwardRptFB_p.setStrStoreValues(strStoreVal);
			
//			strSupplierVal = hisutil.getOptionValue(voObj.getStrManufactureComboWS(), "0", "0^All", false);
//			MaterialInwardRptFB_p.setStrManufactureCombo(strSupplierVal);
						
			hisutil = new HisUtil("MMS Transactions", "DebtorRegisterRptDATA");
			// For setting the financial year 
			MaterialInwardRptFB_p.setStrStartFinancialYear(""+CURRENT_YEAR);
			MaterialInwardRptFB_p.setStrEndFinancialYear(""+(CURRENT_YEAR+1));
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			MaterialInwardRptFB_p.setStrCurrentDate(strCurrentDate);			
		

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.transactions.DebtorRegisterRptDATA.getInitializedValues --> "+ e.getMessage();
			HisException eObj = new HisException("dwh",	"DebtorRegisterRptDATA->getInitializedValues()", strMsgText);
			MaterialInwardRptFB_p.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

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
	
	
    public static void getUnitDetails(DebtorRegisterRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	{

			DebtorRegisterRptBO bo = null;
			DebtorRegisterRptVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
			
			try 
			{
				bo = new DebtorRegisterRptBO();
				vo = new DebtorRegisterRptVO();
				vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				mcu = new MmsConfigUtil(vo.getStrHospitalCode());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				vo.setStrStoreId(request.getParameter("StoreId"));
				vo.setStrFromDate(request.getParameter("fromDate"));
				vo.setStrToDate(request.getParameter("toDate"));
								
				bo.getUnitDetails(vo);
				
				String strItemDetails = DebtorRegisterRptHLP.getIssuedStoreDetails(vo.getStrConsolidatedStoreWs());
				
				
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

   
    
    public static void getDebetorItemDetails(DebtorRegisterRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	{

			DebtorRegisterRptBO bo = null;
			DebtorRegisterRptVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
			
			try 
			{
				bo = new DebtorRegisterRptBO();
				vo = new DebtorRegisterRptVO();
																			
				vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				mcu = new MmsConfigUtil(vo.getStrHospitalCode());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				vo.setStrStoreId(request.getParameter("StoreId"));
			    vo.setStrIssueNumber(request.getParameter("IssueNo"));
				vo.setStrFromDate(request.getParameter("fromDate"));
				vo.setStrToDate(request.getParameter("toDate"));
				
				bo.getDebetorItemDetails(vo);
				
				String strItemDetails = DebtorRegisterRptHLP.getIssuedDrugDetails(vo.getStrConsolidatedIssuedItemWs());
				
				
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strItemDetails);	
				
				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
					
			} 
			catch (Exception e) 
			{
				strmsgText = "mms.transactions.IssueTransDATA.getIssuedItemDetails --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"IssueTransDATA->getIssuedItemDetails()", strmsgText);
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

	
	
    public static void showReport(DebtorRegisterRptFB debtorRegisterRptFB_p,HttpServletRequest request, HttpServletResponse response) {
    	
		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
	
	
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strProcRelatedValue = request.getParameter("strProcRelatedValue");
			
			String strIssueNo = strProcRelatedValue.split("\\^")[0];
			String	strIssueDate = strProcRelatedValue.split("\\^")[1];
			String strUnitName = strProcRelatedValue.split("\\^")[2];
			
			String	strIndentNo = strProcRelatedValue.split("\\^")[3];
			String	strIndentDate = strProcRelatedValue.split("\\^")[4];
			
			String	strTotalValue = strProcRelatedValue.split("\\^")[5];
			 
			
			String strStoreID =debtorRegisterRptFB_p.getStrStoreId();
			
			
			
			debtorRegisterRptFB_p.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			debtorRegisterRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			String strHospitalCode = debtorRegisterRptFB_p.getStrHospitalCode();
			String strReportId = debtorRegisterRptFB_p.getStrReportId();
		
		
/*			String strStartYear = debtorRegisterRptFB_p.getStrStartFinancialYear();
			String strEndYear = debtorRegisterRptFB_p.getStrEndFinancialYearTemp();
*/			
			
			String strFromDate = debtorRegisterRptFB_p.getStrFromDate();
			String strToDate = debtorRegisterRptFB_p.getStrToDate();
			
			String strUserRemarks = debtorRegisterRptFB_p.getStrUserRemarks();
			
			reportFormat = debtorRegisterRptFB_p.getStrReportFormat();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			if(debtorRegisterRptFB_p.getStrIsFooter()==null)
				debtorRegisterRptFB_p.setStrIsFooter("0");
			
			if (debtorRegisterRptFB_p.getStrIsFooter().equals("1"))
			{
				footerVisible = false;
				
			}
		
			
			String strReportName = "Debtor Register Report";
	
							
				String reportPath = "/mms/reports/dwh_debotorRegister_rpt.rptdesign";
			
//			String reportPath = "/mms/reports/dwh_drugWarehouseWiseSupplierDeliveryDetail_rpt.rptdesign";
				
				
				params.put("mode", "1");
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				
				params.put("issueDate", strIssueDate);
				params.put("indentNo", strIndentNo);
				params.put("indentDate", strIndentDate);
				params.put("unitName", strUnitName);				
				params.put("totalValue", strTotalValue);
				
				params.put("storeid", strStoreID);	
				params.put("issueNo", strIssueNo);
				
				
				params.put("supplierId", "0");
				params.put("pono", "0");
				
			/*//System.out.println("strIssueDate:"+strIssueDate);
			//System.out.println("strIndentNo:"+strIndentNo);
			//System.out.println("strIndentDate:"+strIndentDate);
			//System.out.println("strUnitName:"+strUnitName);
			//System.out.println("strTotalValue:"+strTotalValue);
			//System.out.println("strStoreID:"+strStoreID);
			//System.out.println("strIssueNo:"+strIssueNo);
			
			//System.out.println("strHospitalCode:"+strHospitalCode);
			
			//System.out.println("debtorRegisterRptFB_p.getStrStoreName():"+debtorRegisterRptFB_p.getStrStoreName());
			//System.out.println("sdf.format(sdf.parse(strFromDate)):"+sdf.format(sdf.parse(strFromDate)));
			//System.out.println("sdf.format(sdf.parse(strToDate)):"+sdf.format(sdf.parse(strToDate)));*/
				
				params.put("storeName", debtorRegisterRptFB_p.getStrStoreName());
				
				
				params.put("hospCode", strHospitalCode);
				params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
				params.put("toDate", sdf.format(sdf.parse(strToDate)));
											
				ts.displayReport(request, response, reportPath, reportFormat,params,strStoreID);
				
			
		      	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
	}

    
}
