package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.IssueToThirdPartyRptBO;
import mms.reports.controller.fb.IssueToThirdPartyRptFB;
import mms.reports.vo.IssueToThirdPartyRptVO;

public class IssueToThirdPartyRptDATA {
	
	public static void getInitValues(IssueToThirdPartyRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		IssueToThirdPartyRptBO bo = null;
		IssueToThirdPartyRptVO voObj = null;
		String strmsgText = null;
		String strStoreVal = "",strThirdPartyVal,strItemCategoryValues,strCatId="0";
		HisUtil util = null;
		try {

			bo = new IssueToThirdPartyRptBO();
			voObj = new IssueToThirdPartyRptVO();
			util = new HisUtil("MMS Transactions", "IssueToThirdPartyRptDATA");
			String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			
			bo.getItemCatList(voObj);
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
			if(voObj.getStrItemCatWs()!=null && voObj.getStrItemCatWs().next() && voObj.getStrItemCatWs().size()>0)
			{
				strCatId=voObj.getStrItemCatWs().getString(1);
			}
			
			voObj.getStrItemCatWs().beforeFirst();
			formBean.setStrItemCatNo(strCatId);
			strItemCategoryValues = util.getOptionValue(voObj.getStrItemCatWs(), "", "0^Select Value", false);
			
			
			if(strUserLevel.equals("6")){
				voObj.setStrMode("6");
			}
			else
				voObj.setStrMode("5");
			
			voObj.setStrItemCatId(strCatId);
			bo.getInitValues(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
			
			if (voObj.getStrStoreWs().size() != 0) {
				
				if(strUserLevel.equals("6"))
					strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^All",true);				
				else
					strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "-1^Select Value",true);					
					

			}else{
				
				strStoreVal = "<option value='-1'>Data N/A</option>";
			}
			
			strThirdPartyVal = util.getOptionValue(voObj.getStrThirdPartyWs(), "0", "0^All", false);
			
			formBean.setStrItemCategoryValues(strItemCategoryValues);
			formBean.setStrThirdPartyVal(strThirdPartyVal);
			
			formBean.setStrStoreValues(strStoreVal);
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));

		} catch (Exception e) 
		{
			//e.printStackTrace();
			strmsgText = "mms.transactions.IssueToThirdPartyRptDATA.getInitValues --> "	+ e.getMessage();
			HisException eObj = new HisException("mms",	"IssueToThirdPartyRptDATA->getInitValues()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

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
	
	public static void getDDWList(IssueToThirdPartyRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		IssueToThirdPartyRptBO bo = null;
		IssueToThirdPartyRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {
			
			
			bo = new IssueToThirdPartyRptBO();
			voObj = new IssueToThirdPartyRptVO();
			
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			
			String strCatId = request.getParameter("categoryId");
			
			if (strCatId == null)
				strCatId = "0";
			
			voObj.setStrItemCatId(strCatId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			
			if(strUserLevel.equals("6")){
				voObj.setStrMode("6");
			}
			else
				voObj.setStrMode("5");
			
			bo.getStoreList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueToThirdPartyRptDATA");
			String temp = "<option value='0'>All</option>";

			if (voObj.getStrStoreWs().size() != 0) {
				
				if(strUserLevel.equals("6"))
					temp = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^All",true);				
				else
					temp = util.getOptionValue(voObj.getStrStoreWs(), "0", "-1^Select Value",true);
					

			}else{
				
				temp = "<option value='-1'>Data N/A</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
//			e.printStackTrace();
			strmsgText = "mms.transactions.IssueToThirdPartyRptDATA.getDDWList --> "+ e.getMessage();
			HisException eObj = new HisException("mms",	"IssueToThirdPartyRptDATA->getDDWList()", strmsgText);
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
	
	
	
	public static void showReport(IssueToThirdPartyRptFB formBean,HttpServletRequest request, HttpServletResponse response) {

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
			String strDateWise = (formBean.getStrDateWise()==null || formBean.getStrDateWise().equals(""))?"0":formBean.getStrDateWise();
			String strBatchWise = (formBean.getStrBatchNo()==null || formBean.getStrBatchNo().equals(""))?"0":formBean.getStrBatchNo();
			
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			String strSourceId =	(formBean.getStrThirdPartyId()==null || formBean.getStrThirdPartyId().equals(""))?"0":formBean.getStrThirdPartyId().split("\\^")[0]; 
				
				
			
	//		//System.out.println("strSourceId"+strSourceId);
			String strUserRemarks = formBean.getStrUserRemarks();
			
			String strCurrentDate  = formBean.getStrCurrentDate();
			
			 strReportName = "Issue To Third Party Detail";
			
			reportFormat = formBean.getStrReportFormat();
			
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
						
			
			
					if(strDateWise.equals("0"))
					{
						if(strBatchWise.equals("0"))
						{
							reportPath = "/mms/reports/thirdpartyissuedtl_withoutbatch_withoutdate1.rptdesign";
							params.put("mode", "1");
						}
						else
						{
							reportPath = "/mms/reports/thirdpartyissuedtl_withbatch_withoutissuedate2.rptdesign";
							params.put("mode", "2");
							
						}
					}
					else
					{
						if(strBatchWise.equals("0"))
						{
							reportPath = "/mms/reports/thirdpartyissuedtl_withoutbatch_withissuedate3.rptdesign";
							params.put("mode", "3");
						}
						else
						{
							reportPath = "/mms/reports/thirdpartyissuedtl_withbatch_withissuedate4.rptdesign";
							params.put("mode", "4");
						}
					}
					
					 						
					params.put("report_id", strReportId);
					params.put("report_Name", strReportName);
					params.put("report_Footer_Visible", footerVisible);
					params.put("report_user_Remarks", strUserRemarks);
					
					params.put("hospCode", strHospitalCode);
					params.put("catCode", strCatCode);
					
					params.put("storeId", formBean.getStrStoreId());
					params.put("sourceId", strSourceId);
					
					params.put("frmdate", sdf.format(sdf.parse(strFromDate)));
					params.put("todate", sdf.format(sdf.parse(strToDate)));
					
					params.put("storeName", formBean.getStrStoreName());
					params.put("sourceName", formBean.getStrSourceName());
			
			
												
				ts.displayReport(request, response, reportPath, reportFormat,params,formBean.getStrStoreId());
						
				
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
