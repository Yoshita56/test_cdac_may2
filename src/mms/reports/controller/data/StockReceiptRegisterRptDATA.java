package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.StockReceiptRegisterRptBO;
import mms.reports.controller.fb.StockReceiptRegisterRptFB;
import mms.reports.vo.StockReceiptRegisterRptVO;

public class StockReceiptRegisterRptDATA {
	
	public static void getStoreList(StockReceiptRegisterRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		StockReceiptRegisterRptBO bo = null;
		StockReceiptRegisterRptVO voObj = null;
		String strmsgText = null;
		String strStoreVal,strCatVal;
		HisUtil util = null;
		
		String strUserlevel = "";
		try {

			bo = new StockReceiptRegisterRptBO();
			voObj = new StockReceiptRegisterRptVO();
			//String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			//System.out.println("ok1");
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			//System.out.println("ok2");
			voObj.setStrSeatId(formBean.getStrSeatId());
			

			/*if(strUserLevel.equals("6")){
				voObj.setStrMode("4");
			}
			else*/
				voObj.setStrMode("5");
			
			bo.getStoreList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "StockReceiptRegisterRptDATA");
			
			/*if(strUserLevel.equals("6"))
			{
			strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", false);
			}
			else
			{*/
		    strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", false);	
		//	}
			voObj.setStrStoreId("0");
			//voObj.setStrMode("1");
			voObj.setStrMode("2");
			bo.getItemCatList(voObj);
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
			strCatVal = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^Select Value", true);
			
			formBean.setStrStoreValues(strStoreVal);
			
			formBean.setStrCatVal(strCatVal);
			
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.StockReceiptRegisterRptDATA.getStoreList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StockReceiptRegisterRptDATA->getStoreList()", strmsgText);
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
	
	public static void getItemCatList(StockReceiptRegisterRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		StockReceiptRegisterRptBO bo = null;
		StockReceiptRegisterRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new StockReceiptRegisterRptBO();
			voObj = new StockReceiptRegisterRptVO();
			
			String strStoreId = request.getParameter("storeId");
			
			if (strStoreId == null)
				strStoreId = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			voObj.setStrMode("2");
			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "StockReceiptRegisterRptDATA");
			String temp = "<option value='0'>SelectValue</option>";

			if (voObj.getStrItemCatWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^SelectValue",
						true);

			}else{
				
				temp = "<option value='0'>SelectValue</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.StockReceiptRegisterRptDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StockReceiptRegisterRptDATA->getItemCatList()", strmsgText);
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
	
	public static void getItemList(StockReceiptRegisterRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		StockReceiptRegisterRptBO bo = null;
		StockReceiptRegisterRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new StockReceiptRegisterRptBO();
			voObj = new StockReceiptRegisterRptVO();
			
			String strStoreId = request.getParameter("storeId");
			String strCatId = request.getParameter("catId");
			
			if (strStoreId == null)
				strStoreId = "0";
			if (strCatId == null)
				strCatId = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrItemCatId(strCatId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			voObj.setStrMode("1");
			bo.getItemList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "StockReceiptRegisterRptDATA");
			String temp = "<option value='0'>SelectValue</option>";

			if (voObj.getStrItemWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrItemWs(), "0", "0^All",
						true);

			}else{
				
				temp = "<option value='0'>SelectValue</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.StockReceiptRegisterRptDATA.getItemList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StockReceiptRegisterRptDATA->getItemList()", strmsgText);
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
	
	public static void getSupplierList(StockReceiptRegisterRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		StockReceiptRegisterRptBO bo = null;
		StockReceiptRegisterRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new StockReceiptRegisterRptBO();
			voObj = new StockReceiptRegisterRptVO();
			
			//String strStoreId = request.getParameter("storeId");
			String strCatId = request.getParameter("catId");
			
			//if (strStoreId == null)
				//strStoreId = "0";
			if (strCatId == null)
				strCatId = "0";
			
		//	voObj.setStrStoreId(strStoreId);
			voObj.setStrItemCatId(strCatId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			voObj.setStrMode("2");
			bo.getSupplierList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "StockReceiptRegisterRptDATA");
			String temp = "<option value='0'>SelectValue</option>";

			if (voObj.getStrSuppWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrSuppWs(), "0", "0^All",
						true);

			}else{
				
				temp = "<option value='0'>SelectValue</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.StockReceiptRegisterRptDATA.supplier --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StockReceiptRegisterRptDATA->supplier()", strmsgText);
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

	public static void showReport(StockReceiptRegisterRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {
	
		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
		String reportPath = " ";
	
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrItemCatNo();
			String strStoreId = formBean.getStrStoreId();
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			reportFormat = formBean.getStrReportFormat();
			String strItemId = formBean.getStrItemId();
			String strSupplier = formBean.getStrSupplierId();
			String strPOType = formBean.getStrPOType();
			String strItemType = formBean.getStrItemType();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			
			
			//if (formBean.getStrWhetherConsolidated() == null
			//		|| formBean.getStrWhetherConsolidated().equals("0")
			//		|| formBean.getStrWhetherConsolidated().equals("")) {
				// For Location Wise
			if(!strPOType.equals("3"))
				reportPath = "/mms/reports/stockreceiptregister_mmsrpt2.rptdesign";
			else
				reportPath = "/mms/reports/stockreceiptregister_mmsrpt4.rptdesign";
			//}
			
			
			/*else
			{
				// For Consolidated
				reportPath = "/mms/reports/stockreceiptregister_mmsrpt3.rptdesign";
			}
			*/
			
			String strReportName = "Receipt Register(Challan)";
	
							
				
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", false);
				params.put("report_user_Remarks", ".");
				
				params.put("hospCode", strHospitalCode);
				params.put("catCode", strCatCode);
				params.put("storeId", strStoreId);
				params.put("itemId", strItemId);
				params.put("suppId", strSupplier);
				params.put("poType", strPOType);
				params.put("itemType", strItemType);
				params.put("storeName", formBean.getStrStoreName());
				params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
				params.put("toDate", sdf.format(sdf.parse(strToDate)));
				params.put("report_fix_header","Header");
				

				/*//System.out.println("hospCode"+ strHospitalCode);
				//System.out.println("catCode"+strCatCode);
			    //System.out.println("storeId"+ strStoreId);
								//System.out.println("storeName"+ formBean.getStrStoreName());
						//System.out.println("fromDate"+ sdf.format(sdf.parse(strFromDate)));
						//System.out.println("toDate"+ sdf.format(sdf.parse(strToDate)));
			
				
				//System.out.println("reportPath >>>>>>>>>>>>"+reportPath);*/
				ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);
			
				//	ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);
						      	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
	}

}
