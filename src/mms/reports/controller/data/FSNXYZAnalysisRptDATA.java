package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.reports.bo.FSNXYZAnalysisRptBO;
import mms.reports.controller.fb.FSNXYZAnalysisRptFB;
import mms.reports.vo.FSNXYZAnalysisRptVO;

public class FSNXYZAnalysisRptDATA {
	
	public static void getStoreList(FSNXYZAnalysisRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		FSNXYZAnalysisRptBO bo = null;
		FSNXYZAnalysisRptVO voObj = null;
		String strmsgText = null;
		String strStoreVal = "";
		HisUtil util = null;
		MmsConfigUtil mcu = null;
		try {

			bo = new FSNXYZAnalysisRptBO();
			voObj = new FSNXYZAnalysisRptVO();
			
			mcu = new MmsConfigUtil(formBean.getStrHospitalCode());
			formBean.setStrYnDays1(mcu.getStrFCategory());
			formBean.setStrYnDays2(mcu.getStrSCategory());
			
		//	//System.out.println("1-"+formBean.getStrHospitalCode());
			////System.out.println("2-"+mcu.getStrFCategory(formBean.getStrHospitalCode()));
			////System.out.println("3-"+mcu.getStrSCategory(formBean.getStrHospitalCode()));
			
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
						
			bo.getStoreList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "FSNXYZAnalysisRptDATA");
			
			strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^SelectValue", false);
						
			formBean.setStrStoreValues(strStoreVal);
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.FSNXYZAnalysisRptDATA.getStoreList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"FSNXYZAnalysisRptDATA->getStoreList()", strmsgText);
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
	
	public static void getItemCatList(FSNXYZAnalysisRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		FSNXYZAnalysisRptBO bo = null;
		FSNXYZAnalysisRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new FSNXYZAnalysisRptBO();
			voObj = new FSNXYZAnalysisRptVO();
			
			String strStoreId = request.getParameter("storeId");
			
			if (strStoreId == null)
				strStoreId = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "FSNXYZAnalysisRptDATA");
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
			strmsgText = "mms.transactions.FSNXYZAnalysisRptDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"FSNXYZAnalysisRptDATA->getItemCatList()", strmsgText);
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
	
	public static void showReport(FSNXYZAnalysisRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {
	
		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
	
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrItemCatNo();
			String strStoreId = formBean.getStrStoreId();
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			String strUserRemarks = formBean.getStrUserRemarks();
			reportFormat = formBean.getStrReportFormat();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			String strReportName = "FSN / XYZ Analysis";
	
							
				String reportPath = "/mms/reports/fsnxyzanalysis_mms_rpt.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				
				params.put("hospCode", strHospitalCode);
				params.put("catCode", strCatCode);
				params.put("storeId", strStoreId);
				params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
				params.put("toDate", sdf.format(sdf.parse(strToDate)));
								
				ts.displayReport(request, response, reportPath, reportFormat,
						params,strStoreId);
				
			
		      	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
	}

}
