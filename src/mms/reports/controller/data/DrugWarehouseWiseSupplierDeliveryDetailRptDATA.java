package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.DrugWarehouseWiseSupplierDeliveryDetailRptBO;
import mms.reports.controller.fb.DrugWarehouseWiseSupplierDeliveryDetailRptFB;
import mms.reports.vo.DrugWarehouseWiseSupplierDeliveryDetailRptVO;

public class DrugWarehouseWiseSupplierDeliveryDetailRptDATA {
	
	public static void getInitializedValues(DrugWarehouseWiseSupplierDeliveryDetailRptFB budgetDetailRptFB_p,	HttpServletRequest request, HttpServletResponse response) {

		DrugWarehouseWiseSupplierDeliveryDetailRptBO bo = null;
		DrugWarehouseWiseSupplierDeliveryDetailRptVO voObj = null;
		String strMsgText = null;
		String strCurrentDate;
		HisUtil hisutil = null;
		
		int strCurrentMonth;
		int CURRENT_YEAR;
		
		String strCurrentFinancialYear;
		String strNextFinancialYear;
		String strHospitalCode,strStoreVal,strDwhTypeVal,strSupplierVal;
		
		try {

			bo = new DrugWarehouseWiseSupplierDeliveryDetailRptBO();
			voObj = new DrugWarehouseWiseSupplierDeliveryDetailRptVO();
			
			String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			budgetDetailRptFB_p.setStrHospitalCode(strHospitalCode);
			budgetDetailRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
			hisutil = new HisUtil("DWH","DrugWarehouseWiseSupplierDeliveryDetailRptDATA");
			
					
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
				voObj.setStrMode("1");
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
			
			
			//strStoreVal = hisutil.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", false);
			
			budgetDetailRptFB_p.setStrStoreValues(strStoreVal);
			
			strSupplierVal = hisutil.getOptionValue(voObj.getStrManufactureComboWS(), "0", "0^All", false);
			budgetDetailRptFB_p.setStrManufactureCombo(strSupplierVal);
						
			hisutil = new HisUtil("MMS Transactions", "DrugWarehouseWiseSupplierDeliveryDetailRptDATA");
			// For setting the financial year 
			budgetDetailRptFB_p.setStrStartFinancialYear(""+CURRENT_YEAR);
			budgetDetailRptFB_p.setStrEndFinancialYear(""+(CURRENT_YEAR+1));
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			budgetDetailRptFB_p.setStrCurrentDate(strCurrentDate);			
		

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.transactions.DrugWarehouseWiseSupplierDeliveryDetailRptDATA.getInitializedValues --> "+ e.getMessage();
			HisException eObj = new HisException("dwh",	"DrugWarehouseWiseSupplierDeliveryDetailRptDATA->getInitializedValues()", strMsgText);
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
	public static void getStoreList(DrugWarehouseWiseSupplierDeliveryDetailRptFB budgetDetailRptFB_p,HttpServletRequest request, HttpServletResponse response) 
	{

		DrugWarehouseWiseSupplierDeliveryDetailRptBO bo = null;
		DrugWarehouseWiseSupplierDeliveryDetailRptVO voObj = null;
		String strmsgText = null;
		String strHospitalCode, strStoreVal = "";
		String strDwhTypeVal;

		HisUtil util = null;
		try {

			bo = new DrugWarehouseWiseSupplierDeliveryDetailRptBO();
			voObj = new DrugWarehouseWiseSupplierDeliveryDetailRptVO();
			
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
			util = new HisUtil("DWH", "DrugWarehouseWiseSupplierDeliveryDetailRptDATA");
			
			strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^Select Value", false);
						
		
			 response.setHeader("Cache-Control", "no-cache");
			 response.getWriter().print(strStoreVal);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.DrugWarehouseWiseSupplierDeliveryDetailRptDATA.getStoreList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugWarehouseWiseSupplierDeliveryDetailRptDATA->getStoreList()", strmsgText);
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
	
	public static void showReport(DrugWarehouseWiseSupplierDeliveryDetailRptFB drugWarehouseWiseSupplierDeliveryDetailRptFB_p,HttpServletRequest request, HttpServletResponse response) {
	
		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
	
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			drugWarehouseWiseSupplierDeliveryDetailRptFB_p.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			drugWarehouseWiseSupplierDeliveryDetailRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			String strHospitalCode = drugWarehouseWiseSupplierDeliveryDetailRptFB_p.getStrHospitalCode();
			String strReportId = drugWarehouseWiseSupplierDeliveryDetailRptFB_p.getStrReportId();
		
		
			String strStartYear = drugWarehouseWiseSupplierDeliveryDetailRptFB_p.getStrStartFinancialYear();
			String strEndYear = drugWarehouseWiseSupplierDeliveryDetailRptFB_p.getStrEndFinancialYearTemp();
			
			
			String strFromDate = drugWarehouseWiseSupplierDeliveryDetailRptFB_p.getStrFromDate();
			String strToDate = drugWarehouseWiseSupplierDeliveryDetailRptFB_p.getStrToDate();
			
			String strUserRemarks = drugWarehouseWiseSupplierDeliveryDetailRptFB_p.getStrUserRemarks();
			
			reportFormat = drugWarehouseWiseSupplierDeliveryDetailRptFB_p.getStrReportFormat();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			if(drugWarehouseWiseSupplierDeliveryDetailRptFB_p.getStrIsFooter()==null)
				drugWarehouseWiseSupplierDeliveryDetailRptFB_p.setStrIsFooter("0");
			
			if (drugWarehouseWiseSupplierDeliveryDetailRptFB_p.getStrIsFooter().equals("1"))
			{
				footerVisible = false;
				
			}
			if(drugWarehouseWiseSupplierDeliveryDetailRptFB_p.getStrBatchNo()==null)
			{
				drugWarehouseWiseSupplierDeliveryDetailRptFB_p.setStrBatchNo("0");
			}
			
			
			if(drugWarehouseWiseSupplierDeliveryDetailRptFB_p.getStrBatchNo().equals("0"))
			{
				
				params.put("batchNo", false);
			}
			else
			{
				
				params.put("batchNo", true);
			}
			
			String strReportName = "Drug Warehouse Wise Supplier Delivery Detail";
	
							
			//	String reportPath = "/mms/reports/dwh_totalValueDrugsSupply_rpt.rptdesign";
			
			String reportPath = "/mms/reports/dwh_drugWarehouseWiseSupplierDeliveryDetail_rpt.rptdesign";
				
				params.put("mode", "1");
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				params.put("storeName", drugWarehouseWiseSupplierDeliveryDetailRptFB_p.getStrStoreName());
				params.put("hospCode", strHospitalCode);
				
				params.put("storeId", drugWarehouseWiseSupplierDeliveryDetailRptFB_p.getStrStoreId()+"^"+drugWarehouseWiseSupplierDeliveryDetailRptFB_p.getStrSupplierId()+"^"+drugWarehouseWiseSupplierDeliveryDetailRptFB_p.getStrBatchNo());		// In the storeId parameter we concatenate the supplierId and Batch No. along with the storeId 		
				params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
				params.put("toDate", sdf.format(sdf.parse(strToDate)));
				
				
				
//				params.put("fromYear", strStartYear);
//				params.put("toYear", strEndYear);
								
				ts.displayReport(request, response, reportPath, reportFormat,params,drugWarehouseWiseSupplierDeliveryDetailRptFB_p.getStrStoreId());
				
			
		      	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
	}

}
