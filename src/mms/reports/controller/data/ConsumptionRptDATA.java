package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.ConsumptionRptBO;
import mms.reports.controller.fb.ConsumptionRptFB;
import mms.reports.vo.ConsumptionRptVO;

public class ConsumptionRptDATA {
	
	public static void getStoreList(ConsumptionRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ConsumptionRptBO bo = null;
		ConsumptionRptVO voObj = null;
		String strmsgText = null;
		String strStoreVal,strCatVal;
		HisUtil util = null;
		
		String strUserlevel = "";
		try {

			bo = new ConsumptionRptBO();
			voObj = new ConsumptionRptVO();
			//String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			System.out.println("ok1");
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			System.out.println("ok2");
			voObj.setStrSeatId(formBean.getStrSeatId());
			

			/*if(strUserLevel.equals("6")){
				voObj.setStrMode("4");
			}
			else*/
				voObj.setStrMode("8"); //5 to 8 bcz of role based
			
			bo.getStoreList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "ConsumptionRptDATA");
			
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
			voObj.setStrMode("6");
			voObj.setStrItemCatId("0");
			bo.getItemList(voObj);
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
			
			strCatVal = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^Select Value", true);
			
			formBean.setStrStoreValues(strStoreVal);
			
			formBean.setStrCatVal(strCatVal);
			
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));
			//formBean.setStrLeftItemList(util.getOptionValue(voObj.getStrItemWs(), "", "", true));

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.ConsumptionRptDATA.getStoreList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ConsumptionRptDATA->getStoreList()", strmsgText);
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
	
	public static void getItemCatList(ConsumptionRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ConsumptionRptBO bo = null;
		ConsumptionRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new ConsumptionRptBO();
			voObj = new ConsumptionRptVO();
			
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
			util = new HisUtil("MMS Transactions", "ConsumptionRptDATA");
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
			strmsgText = "mms.transactions.ConsumptionRptDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ConsumptionRptDATA->getItemCatList()", strmsgText);
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
	
	public static void getItemList(ConsumptionRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ConsumptionRptBO bo = null;
		ConsumptionRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new ConsumptionRptBO();
			voObj = new ConsumptionRptVO();
			
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
			util = new HisUtil("MMS Transactions", "ConsumptionRptDATA");
			String temp = "<option value='0'>SelectValue</option>";

			if (voObj.getStrItemWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrItemWs(), "0", "0^All",
						true);

			}else{
				
				temp = "<option value='0'>SelectValue</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);
			voObj.getStrItemWs().beforeFirst();
			formBean.setStrLeftItemList(util.getOptionValue(voObj.getStrItemWs(), "", "", true));

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.ConsumptionRptDATA.getItemList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ConsumptionRptDATA->getItemList()", strmsgText);
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
	
	public static void getSupplierList(ConsumptionRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ConsumptionRptBO bo = null;
		ConsumptionRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new ConsumptionRptBO();
			voObj = new ConsumptionRptVO();
			
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
			util = new HisUtil("MMS Transactions", "ConsumptionRptDATA");
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
			strmsgText = "mms.transactions.ConsumptionRptDATA.supplier --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ConsumptionRptDATA->supplier()", strmsgText);
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

	public static void showReport(ConsumptionRptFB formBean,
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
			String strFromDate = "01-Sep-2020";
			String strToDate = formBean.getStrToDate();
			reportFormat = formBean.getStrReportFormat();
			String strItemId = formBean.getStrItemBrandId();
			String strSupplier = formBean.getStrSupplierId();
			String strPOType = formBean.getStrPOType();
			String strItemType = formBean.getStrItemType();
			String strStoreName = formBean.getStrStoreName();
			String strCatName = formBean.getStrCatName();			
			String modeval;
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			
			reportPath = "/mms/reports/Consumption_mmsrpt.rptdesign";
			
			if(strCatCode.equals("10"))
				modeval = "1";
			else
				modeval = "2";
			
			
			/*else
			{
				// For Consolidated
				reportPath = "/mms/reports/Consumption_mmsrpt3.rptdesign";
			}
			*/
			
			String strReportName = "Consumption Report";
	
							
				
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", false);
				params.put("report_user_Remarks", ".");
				params.put("mode", strCatCode);
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
				params.put("storeName", strStoreName);
				params.put("catname",strCatName);
				params.put("report_fix_header","Header");
				

				/*System.out.println("hospCode"+ strHospitalCode);
				System.out.println("catCode"+strCatCode);
			    System.out.println("storeId"+ strStoreId);
								System.out.println("storeName"+ formBean.getStrStoreName());
						System.out.println("fromDate"+ sdf.format(sdf.parse(strFromDate)));
						System.out.println("toDate"+ sdf.format(sdf.parse(strToDate)));
			
				
				System.out.println("reportPath >>>>>>>>>>>>"+reportPath);*/
				ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);
			
				//	ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);
						      	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
	}

}
