package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.ConsumptionValueSummaryRptBO;
import mms.reports.controller.fb.ConsumptionValueSummaryRptFB;
import mms.reports.vo.ConsumptionValueSummaryRptVO;

public class ConsumptionValueSummaryRptDATA {
	
	public static void getItemCatList(ConsumptionValueSummaryRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ConsumptionValueSummaryRptBO bo = null;
		ConsumptionValueSummaryRptVO voObj = null;
		String strmsgText = null;
		String strItemCatVal = "";
		HisUtil util = null;
		try {

			bo = new ConsumptionValueSummaryRptBO();
			voObj = new ConsumptionValueSummaryRptVO();
			
						
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "ConsumptionValueSummaryRptDATA");
			
			strItemCatVal = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^SelectValue", false);
						
			formBean.setStrItemCatValues(strItemCatVal);
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.ConsumptionValueSummaryRptDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ConsumptionValueSummaryRptDATA->getItemCatList()", strmsgText);
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
	
	public static void getStoreList(ConsumptionValueSummaryRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ConsumptionValueSummaryRptBO bo = null;
		ConsumptionValueSummaryRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		String temp = "";
		try {

			bo = new ConsumptionValueSummaryRptBO();
			voObj = new ConsumptionValueSummaryRptVO();
			
			String strItemCatId = request.getParameter("itemCatId");
			
			if (strItemCatId == null)
				strItemCatId = "0";
			
			voObj.setStrItemCatId(strItemCatId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
				
			bo.getStoreList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "ConsumptionValueSummaryRptDATA");
			

			if (voObj.getStrStoreWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrStoreWs(), "0", "",
						true);

			}
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.ConsumptionValueSummaryRptDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ConsumptionValueSummaryRptDATA->getItemCatList()", strmsgText);
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
	
	public static void showReport(ConsumptionValueSummaryRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
		String strStoreListVal = "";
		
		String reportFormat = "html";

		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrItemCatNo();
			String strUserRemarks = formBean.getStrUserRemarks();
			String strStoreId = formBean.getStrStoreId();
			String[] strStoreList = formBean.getStrStoreName();
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			
			////System.out.println("strStoreId-"+strStoreId);
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			
		
			
			reportFormat = formBean.getStrReportFormat();
			
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			String strReportName = "Consumption Value Summary";
			
			String reportPath = "/mms/reports/consumptionvaluesummary_mmsrpt.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				params.put("hospCode", strHospitalCode);
				params.put("catCode", strCatCode);
				params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
				params.put("toDate", sdf.format(sdf.parse(strToDate)));
				if(strStoreId.equals("0")){
					params.put("storeId", strStoreId);
				}else{
					
					for(int i = 0, stopI = strStoreList.length; i < stopI; i++)
					{
						strStoreListVal = strStoreListVal + "^" + strStoreList[i];
					}
					params.put("storeId", strStoreListVal);
					
					////System.out.println("strStoreListVal-"+strStoreListVal);
				}
								
				//ts.displayReport(request, response, reportPath, reportFormat,params);
			
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
