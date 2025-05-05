package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.StockOnHand_oldRptBO;
import mms.reports.controller.fb.StockOnHand_oldRptFB;
import mms.reports.vo.StockOnHand_oldRptVO;

public class StockOnHand_oldRptDATA {
	
	public static void getStoreList(StockOnHand_oldRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		StockOnHand_oldRptBO bo = null;
		StockOnHand_oldRptVO voObj = null;
		String strmsgText = null;
		String strStoreVal = "",strDistrictStoreVal;
		HisUtil util = null;
		try {

			bo = new StockOnHand_oldRptBO();
			voObj = new StockOnHand_oldRptVO();
			
			String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			
			
			
			
			bo.getStoreList(voObj,strUserLevel);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PurchaseOrderDtlRptDATA");
			
			if(strUserLevel.equals("6"))
			{
				strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", false);
				
				strDistrictStoreVal = util.getOptionValue(voObj.getStrDistrictStoreWs(), "0", "0^All", false);
				
			}
			else
			{
				strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "-1^Select Value", false);
				
				strDistrictStoreVal = util.getOptionValue(voObj.getStrDistrictStoreWs(), "0", "-1^Select Value", false);				
			}
			
			
			
			formBean.setStrDistrictStoreValues(strDistrictStoreVal);
			
			formBean.setStrStoreValues(strStoreVal);
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.StockOnHand_oldRptDATA.getStoreList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StockOnHand_oldRptDATA->getStoreList()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
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
	
	public static void getItemCatList(StockOnHand_oldRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		StockOnHand_oldRptBO bo = null;
		StockOnHand_oldRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new StockOnHand_oldRptBO();
			voObj = new StockOnHand_oldRptVO();
			
			String strStoreId = request.getParameter("storeId");
			
			if (strStoreId == null)
				strStoreId = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "StockOnHand_oldRptDATA");
			String temp = "<option value='0'>SelectValue</option>";

			if (voObj.getStrItemCatWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^SelectValue",true);

			}else{
				
				temp = "<option value='0'>SelectValue</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.StockOnHand_oldRptDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",	"StockOnHand_oldRptDATA->getItemCatList()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

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
	
	public static void getGroupList(StockOnHand_oldRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		StockOnHand_oldRptBO bo = null;
		StockOnHand_oldRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new StockOnHand_oldRptBO();
			voObj = new StockOnHand_oldRptVO();
			
			String strItemCatId = request.getParameter("itemcat");
			
			if (strItemCatId == null)
				strItemCatId = "0";
			
			voObj.setStrItemCatId(strItemCatId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			
			////System.out.println("strItemCatId--------->"+strItemCatId);
			
			bo.getGroupList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "StockOnHand_oldRptDATA");
			String temp = "<option value='0'>All</option>";

			if (voObj.getStrGroupWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrGroupWs(), "0", "0^All",
						true);

			}else{
				
				temp = "<option value='0'>All</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.StockOnHand_oldRptDATA.getGroupList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StockOnHand_oldRptDATA->getGroupList()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
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
	
	public static void showReport(StockOnHand_oldRptFB formBean,HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
	
		String reportFormat = "html";
		String strReportName ="";
		String reportPath = "";
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrItemCatNo();
			String strStoreId = formBean.getStrStoreId();
			String strDistrictStoreId = formBean.getStrDistrictStoreId();
			String strUserRemarks = formBean.getStrUserRemarks();
			String strGroupId = formBean.getStrGroupId();
			
			String strCurrentDate  = formBean.getStrCurrentDate();
			String strParticularDate = formBean.getStrDate();
			
			String strCurrentStock = formBean.getStrCurrentStock();
			String strBatchNo = formBean.getStrBatchNo();
			
			reportFormat = formBean.getStrReportFormat();
			String strStoreIdParam = "";
			
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			params.put("storeName", formBean.getStrStoreName());
			params.put("currDate", strCurrentDate);
			params.put("report_Fix_Header","header");
			if(formBean.getWhetherConsolidatedStockForAllInstitutseOfDistrictDrugWarehouse()==null)
			{
				formBean.setWhetherConsolidatedStockForAllInstitutseOfDistrictDrugWarehouse("0");
			}
			if(formBean.getStrCurrentStock1()==null)
			{
				formBean.setStrCurrentStock1("0");
			}
			
			
			if(formBean.getStrCurrentStock1().equals("1"))
			{
				if(formBean.getWhetherConsolidatedStockForAllInstitutseOfDistrictDrugWarehouse().equals("1"))
				{
					strReportName	= "CONSOLIDATED CURRENT STOCK REPORT";
					
					params.put("storeId", strDistrictStoreId);
					strStoreIdParam = strDistrictStoreId;
				}
				
				else
				{
					strReportName	= "CURRENT STOCK REPORT";
					
					params.put("storeId", strStoreId);
					strStoreIdParam = strStoreId;
				}
			}
			else
			{
				if(formBean.getWhetherConsolidatedStockForAllInstitutseOfDistrictDrugWarehouse().equals("1"))
				{
					strReportName	= "CONSOLIDATED STOCK REPORT";
					
					params.put("storeId", strDistrictStoreId);
					strStoreIdParam = strDistrictStoreId;
				}
				
				else
				{
					strReportName	= "STOCK REPORT";
					params.put("storeId", strStoreId);
					strStoreIdParam = strStoreId;
					
				}
			}
			
					
			//String strReportName = "Stock on Hand Record";

			if(strCurrentStock.equals("1")){
				
				if(strBatchNo.equals("1")){
					
					//System.out.println("current with batch");
					
			//		String reportPath = "/mms/reports/stockonhand_mmsrpt.rptdesign";
					
					reportPath = "/mms/reports/stockonhand_old_mmsrpt12.rptdesign";
					params.put("mode", "1");
					params.put("report_id", strReportId);
					params.put("report_Name", strReportName);
					params.put("report_Footer_Visible", footerVisible);
					params.put("report_user_Remarks", strUserRemarks);
					
					params.put("hospCode", strHospitalCode);
					params.put("catCode", strCatCode);
					if(strGroupId.equals("0")){
						params.put("groupId", "0");
					}else{
						params.put("groupId", strGroupId);
					}
					
					params.put("dateVal", "null");
					params.put("currDate", strCurrentDate);
					params.put("report_Fix_Header","header");
					//System.out.println("reportPath>>???????????????????????>>"+reportPath);

					ts.displayReport(request, response, reportPath, reportFormat,
							params,strStoreIdParam);
					
				}else if(strBatchNo.equals("0")){
					
					////System.out.println("current without batch");
					
//					String reportPath = "/mms/reports/stockonhand_mmsrpt1.rptdesign";
					
					reportPath = "/mms/reports/stockonhand_old_mmsrpt11.rptdesign";
					
					////System.out.println("strCatCode"+strCatCode);
					////System.out.println("strStoreId"+strStoreId);
					////System.out.println("strGroupId"+strGroupId);
					
					params.put("mode", "2");
					params.put("report_id", strReportId);
					params.put("report_Name", strReportName);
					params.put("report_Footer_Visible", footerVisible);
					params.put("report_user_Remarks", strUserRemarks);
					
					params.put("hospCode", strHospitalCode);
					params.put("catCode", strCatCode);
					
					if(strGroupId.equals("0")){
						params.put("groupId", "0");
					}else{
						params.put("groupId", strGroupId);
					}
					params.put("dateVal", "null");
					params.put("currDate", strCurrentDate);
					//System.out.println("reportPath>>???????????????????????>>"+reportPath);

					ts.displayReport(request, response, reportPath, reportFormat,
							params,strStoreIdParam);
					
				}
				
			}else if(strCurrentStock.equals("0")){
					
					if(strBatchNo.equals("1")){
						
						////System.out.println("date with batch");
						
					//	String reportPath = "/mms/reports/stockonhand_mmsrpt2.rptdesign";
						
						reportPath = "/mms/reports/stockonhand_old_mmsrpt12.rptdesign";
						
						params.put("report_id", strReportId);
						params.put("report_Name", strReportName);
						params.put("report_Footer_Visible", footerVisible);
						params.put("report_user_Remarks", strUserRemarks);
						
						params.put("hospCode", strHospitalCode);
						params.put("catCode", strCatCode);
						params.put("mode", "1");
						
						if(strGroupId.equals("0")){
							params.put("groupId", "0");
						}else{
							params.put("groupId", strGroupId);
						}
						
						params.put("dateVal", strParticularDate);
						//System.out.println("reportPath>>???????????????????????>>"+reportPath);
					
						ts.displayReport(request, response, reportPath, reportFormat,
								params,strStoreIdParam);
						
					}else if(strBatchNo.equals("0")){
						
						////System.out.println("date without batch");
						
//						String reportPath = "/mms/reports/stockonhand_mmsrpt3.rptdesign";
						
						reportPath = "/mms/reports/stockonhand_old_mmsrpt11.rptdesign";
						
						params.put("mode", "2");
						params.put("report_id", strReportId);
						params.put("report_Name", strReportName);
						params.put("report_Footer_Visible", footerVisible);
						params.put("report_user_Remarks", strUserRemarks);
						
						params.put("hospCode", strHospitalCode);
						params.put("catCode", strCatCode);
						
						if(strGroupId.equals("0")){
							params.put("groupId", "0");
						}else{
							params.put("groupId", strGroupId);
						}
						params.put("dateVal", strParticularDate);
						//System.out.println("reportPath>>???????????????????????>>"+reportPath);
					
						ts.displayReport(request, response, reportPath, reportFormat,
								params,strStoreIdParam);
						
					}
				}

		} catch (Exception e) {

			//System.out.println("reporPath is required-----");
			e.printStackTrace();

		}
		
	}
}
