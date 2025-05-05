package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.TotalValueDrugsSupplyRptBO;
import mms.reports.controller.fb.TotalValueDrugsSupplyRptFB;
import mms.reports.vo.TotalValueDrugsSupplyRptVO;

public class TotalValueDrugsSupplyRptDATA {
	
	public static void getInitializedValues(TotalValueDrugsSupplyRptFB budgetDetailRptFB_p,	HttpServletRequest request, HttpServletResponse response) {

		TotalValueDrugsSupplyRptBO bo = null;
		TotalValueDrugsSupplyRptVO voObj = null;
		String strMsgText = null;
		String strCurrentDate;
		HisUtil hisutil = null;
		
		int strCurrentMonth;
		int CURRENT_YEAR;
		
		String strCurrentFinancialYear;
		String strNextFinancialYear;
		String strHospitalCode,strStoreVal,strDwhTypeVal,strSupplierVal;
		
		try {

			bo = new TotalValueDrugsSupplyRptBO();
			voObj = new TotalValueDrugsSupplyRptVO();
			
			String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			budgetDetailRptFB_p.setStrHospitalCode(strHospitalCode);
			budgetDetailRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
			hisutil = new HisUtil("DWH","TotalValueDrugsSupplyRptDATA");
			
					
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
			
			voObj.setStrSeatId(budgetDetailRptFB_p.getStrSeatId());
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
				strStoreVal = hisutil.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", false);
			}
			else
			{
		    strStoreVal = hisutil.getOptionValue(voObj.getStrStoreWs(), "0", "-1^Select Value", false);	
			}
			
			
			budgetDetailRptFB_p.setStrStoreValues(strStoreVal);
			
			strSupplierVal = hisutil.getOptionValue(voObj.getStrManufactureComboWS(), "0", "0^All", false);
			budgetDetailRptFB_p.setStrManufactureCombo(strSupplierVal);
						
			hisutil = new HisUtil("MMS Transactions", "TotalValueDrugsSupplyRptDATA");
			// For setting the financial year 
			budgetDetailRptFB_p.setStrStartFinancialYear(""+CURRENT_YEAR);
			budgetDetailRptFB_p.setStrEndFinancialYear(""+(CURRENT_YEAR+1));
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			budgetDetailRptFB_p.setStrCurrentDate(strCurrentDate);			
		

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.transactions.TotalValueDrugsSupplyRptDATA.getInitializedValues --> "+ e.getMessage();
			HisException eObj = new HisException("dwh",	"TotalValueDrugsSupplyRptDATA->getInitializedValues()", strMsgText);
			budgetDetailRptFB_p.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

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
	

/*	
	public static void getStoreList(TotalValueDrugsSupplyRptFB budgetDetailRptFB_p,HttpServletRequest request, HttpServletResponse response) 
	{

		TotalValueDrugsSupplyRptBO bo = null;
		TotalValueDrugsSupplyRptVO voObj = null;
		String strmsgText = null;
		String strHospitalCode, strStoreVal = "";
		String strDwhTypeVal;

		HisUtil util = null;
		try {

			bo = new TotalValueDrugsSupplyRptBO();
			voObj = new TotalValueDrugsSupplyRptVO();
			
			strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			budgetDetailRptFB_p.setStrHospitalCode(strHospitalCode);
			budgetDetailRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			voObj.setStrHospitalCode(strHospitalCode);
			voObj.setStrSeatId(budgetDetailRptFB_p.getStrSeatId());
			budgetDetailRptFB_p.setStrDrugWarehouseTypeId(request.getParameter("dwhTypeId"));
			
			
			voObj.setStrDrugWarehouseTypeId(budgetDetailRptFB_p.getStrDrugWarehouseTypeId());
			
				
			
			bo.getStoreList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("DWH", "TotalValueDrugsSupplyRptDATA");
			
			strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^Select Value", false);
						
		
			 response.setHeader("Cache-Control", "no-cache");
			 response.getWriter().print(strStoreVal);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.TotalValueDrugsSupplyRptDATA.getStoreList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"TotalValueDrugsSupplyRptDATA->getStoreList()", strmsgText);
			budgetDetailRptFB_p.setStrErrMsg("Application Error [ERROR ID : "
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
	
	public static void showReport(TotalValueDrugsSupplyRptFB totalValueDrugsSupplyRptFB_p,HttpServletRequest request, HttpServletResponse response) {
	
		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
	
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			totalValueDrugsSupplyRptFB_p.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			totalValueDrugsSupplyRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			String strHospitalCode = totalValueDrugsSupplyRptFB_p.getStrHospitalCode();
			String strReportId = totalValueDrugsSupplyRptFB_p.getStrReportId();
		
		
/*			String strStartYear = totalValueDrugsSupplyRptFB_p.getStrStartFinancialYear();
			String strEndYear = totalValueDrugsSupplyRptFB_p.getStrEndFinancialYearTemp();
*/			
			
			String strFromDate = totalValueDrugsSupplyRptFB_p.getStrFromDate();
			String strToDate = totalValueDrugsSupplyRptFB_p.getStrToDate();
			
			String strUserRemarks = totalValueDrugsSupplyRptFB_p.getStrUserRemarks();
			
			reportFormat = totalValueDrugsSupplyRptFB_p.getStrReportFormat();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			if(totalValueDrugsSupplyRptFB_p.getStrIsFooter()==null)
				totalValueDrugsSupplyRptFB_p.setStrIsFooter("0");
			
			if (totalValueDrugsSupplyRptFB_p.getStrIsFooter().equals("1"))
			{
				footerVisible = false;
				
			}
		
			
			String strReportName = "Total Value Drugs Supply Detail";
	
							
				String reportPath = "/mms/reports/dwh_totalValueDrugsSupply_rpt.rptdesign";
			
//			String reportPath = "/mms/reports/dwh_drugWarehouseWiseSupplierDeliveryDetail_rpt.rptdesign";
				
				
				params.put("mode", "1");
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				params.put("storeName", totalValueDrugsSupplyRptFB_p.getStrStoreName());
				params.put("hospCode", strHospitalCode);
				
				params.put("storeId", totalValueDrugsSupplyRptFB_p.getStrStoreId());		 		
				params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
				params.put("toDate", sdf.format(sdf.parse(strToDate)));
											
				ts.displayReport(request, response, reportPath, reportFormat,params,totalValueDrugsSupplyRptFB_p.getStrStoreId());
				
			
		      	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
	}

}
