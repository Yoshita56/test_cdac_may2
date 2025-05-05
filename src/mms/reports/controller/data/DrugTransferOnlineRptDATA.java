package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.DrugTransferOnlineRptBO;
import mms.reports.controller.fb.DrugTransferOnlineRptFB;
import mms.reports.vo.DrugTransferOnlineRptVO;

public class DrugTransferOnlineRptDATA {
	
	public static void getInitValues(DrugTransferOnlineRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		DrugTransferOnlineRptBO bo = null;
		DrugTransferOnlineRptVO voObj = null;
		String strmsgText = null;
		String strStoreVal = "",strToStoreValues,strItemCategoryValues,strCatId="0";
		HisUtil util = null;
		try {

			bo = new DrugTransferOnlineRptBO();
			voObj = new DrugTransferOnlineRptVO();
			util = new HisUtil("MMS Transactions", "DrugTransferOnlineRptDATA");
			
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
			
			voObj.setStrItemCatId(strCatId);
			voObj.setStrStoreId("0");
			
			if(strUserLevel.equals("6")){
				voObj.setStrMode("6");
			}
			else
				voObj.setStrMode("5");
			
			bo.getInitValues(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
			
			if (voObj.getStrStoreWs().size() != 0) {
				
				/*if(strUserLevel.equals("6"))
				{
				strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", false);
				}
				else
				{
			    strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "-1^Select Value", false);	
				}*/
				strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "-1^Select Value", false);

			}else{
				
				strStoreVal = "<option value='-1'>Data N/A</option>";
			}
			
			
			strToStoreValues = util.getOptionValue(voObj.getStrToStoreComboWS(), "0", "0^All", false);
			
			
			
			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());
			}

			
			String cmbstr = "";

			if (voObj.getItemIdWS() != null	&& voObj.getItemIdWS().size() > 0)
			{

				cmbstr = util.getOptionValue(voObj.getItemIdWS(),"0", "0^All", false);

			} else {

				cmbstr = "<option value='0'>All</option>";
			}
			formBean.setStrDrugNameCmb(cmbstr);
			
			
			formBean.setStrItemCategoryValues(strItemCategoryValues);
			formBean.setStrToStoreValues(strToStoreValues);
			
			formBean.setStrStoreValues(strStoreVal);
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));

		} catch (Exception e) 
		{
			//e.printStackTrace();
			strmsgText = "mms.transactions.DrugTransferOnlineRptDATA.getInitValues --> "	+ e.getMessage();
			HisException eObj = new HisException("mms",	"DrugTransferOnlineRptDATA->getInitValues()", strmsgText);
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
	
	public static void getDDWList(DrugTransferOnlineRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		DrugTransferOnlineRptBO bo = null;
		DrugTransferOnlineRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new DrugTransferOnlineRptBO();
			voObj = new DrugTransferOnlineRptVO();
			
			String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
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
			util = new HisUtil("MMS Transactions", "DrugTransferOnlineRptDATA");
			String temp = "<option value='0'>All</option>";

			if (voObj.getStrStoreWs().size() != 0) {
				
				if(strUserLevel.equals("6"))
				{
					temp = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", false);
				}
				else
				{
					temp = util.getOptionValue(voObj.getStrStoreWs(), "0", "-1^Select Value", false);	
				}
				

			}else{
				
				temp = "<option value='-1'>Data N/A</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
//			e.printStackTrace();
			strmsgText = "mms.transactions.DrugTransferOnlineRptDATA.getDDWList --> "+ e.getMessage();
			HisException eObj = new HisException("mms",	"DrugTransferOnlineRptDATA->getDDWList()", strmsgText);
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
	
	public static void getToDDWList(DrugTransferOnlineRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		DrugTransferOnlineRptBO bo = null;
		DrugTransferOnlineRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new DrugTransferOnlineRptBO();
			voObj = new DrugTransferOnlineRptVO();
			
			String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			String strCatId = request.getParameter("categoryId");
			
			if (strCatId == null)
				strCatId = "0";
			
			voObj.setStrStoreId(request.getParameter("storeId")==null?"0":request.getParameter("storeId"));
			voObj.setStrItemCatId(strCatId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			bo.getToStoreList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "DrugTransferOnlineRptDATA");
			String temp = "<option value='0'>All</option>";

			if (voObj.getStrToStoreComboWS().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrToStoreComboWS(), "0", "0^All",true);

			}else{
				
				temp = "<option value='0'>All</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
//			e.printStackTrace();
			strmsgText = "mms.transactions.DrugTransferOnlineRptDATA.getDDWList --> "+ e.getMessage();
			HisException eObj = new HisException("mms",	"DrugTransferOnlineRptDATA->getDDWList()", strmsgText);
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
	
	
	public static void showReport(DrugTransferOnlineRptFB formBean,HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
	
		String reportFormat = "html";
		String strReportName ="";
		String reportPath = "";
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strInwardOrOutward = (formBean.getStrInwardOrOutward()==null || formBean.getStrInwardOrOutward().equals(""))?"1":formBean.getStrInwardOrOutward();			
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrItemCatNo();
			String strStoreId = formBean.getStrStoreId();
			String strDateWise = (formBean.getStrDateWise()==null || formBean.getStrDateWise().equals(""))?"0":formBean.getStrDateWise();
			String strBatchWise = (formBean.getStrBatchNo()==null || formBean.getStrBatchNo().equals(""))?"0":formBean.getStrBatchNo();
			
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			
			String strUserRemarks = formBean.getStrUserRemarks();
			
			String strCurrentDate  = formBean.getStrCurrentDate();
			
			 strReportName = "Transfer Inward Detail";
			
			reportFormat = formBean.getStrReportFormat();
			
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
						
			
			if(strInwardOrOutward.equals("2"))
			{
				reportPath = "/mms/reports/dwh_drugTransferOnlineDetail_mms_rpt1.rptdesign";
				params.put("mode", "1");
				strReportName = "Transfer Outward Report";
			}
			else
			{
				reportPath = "/mms/reports/dwh_drugTransferOnlineDetail_mms_rpt2.rptdesign";
				params.put("mode", "2");
				 strReportName = "Transfer Inward Report";
			}
			
			
					
					 						
					params.put("report_id", strReportId);
					params.put("report_Name", strReportName);
					params.put("report_Footer_Visible", footerVisible);
					params.put("report_user_Remarks", strUserRemarks);
					
					params.put("hospCode", strHospitalCode);
					params.put("catCode", strCatCode);
					
					params.put("fromStoreId", formBean.getStrStoreId());
					params.put("toStoreId", formBean.getStrToStoreId());
					
					params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
					params.put("toDate", sdf.format(sdf.parse(strToDate)));
					
					params.put("fromStoreName", formBean.getStrStoreName());
					params.put("toStoreName", formBean.getStrToStoreName());
			
					ts.displayReport(request, response, reportPath, reportFormat,params,formBean.getStrStoreId());
						
				
				
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
