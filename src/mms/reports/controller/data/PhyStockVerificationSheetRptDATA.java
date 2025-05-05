package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.PhyStockVerificationSheetRptBO;
import mms.reports.controller.fb.PhyStockVerificationSheetRptFB;
import mms.reports.vo.PhyStockVerificationSheetRptVO;

public class PhyStockVerificationSheetRptDATA {
	
	public static void getStoreList(PhyStockVerificationSheetRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PhyStockVerificationSheetRptBO bo = null;
		PhyStockVerificationSheetRptVO voObj = null;
		String strmsgText = null;
		String strStoreVal = "";
		HisUtil util = null;
		try {

			bo = new PhyStockVerificationSheetRptBO();
			voObj = new PhyStockVerificationSheetRptVO();
			
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			
			bo.getStoreList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PhyStockVerificationSheetRptDATA");
			
			strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "", "", false);
						
			formBean.setStrStoreValues(strStoreVal);
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));
			formBean.setStrStoreId(voObj.getStrStoreId());
			setItemCategCombo(formBean,request);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.PhyStockVerificationSheetRptDATA.getStoreList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PhyStockVerificationSheetRptDATA->getStoreList()", strmsgText);
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
	
	
	public static void setItemCategCombo(PhyStockVerificationSheetRptFB formBean,HttpServletRequest request) 
	{

		PhyStockVerificationSheetRptVO vo=null;
		PhyStockVerificationSheetRptBO bo=null;
		String strmsgText="";
		HisUtil util = null;
		String strItemVal="";
		
		try {
				bo=new PhyStockVerificationSheetRptBO();
				vo=new PhyStockVerificationSheetRptVO();
				
				vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrStoreId(formBean.getStrStoreId());
				
				bo.getItemCatList(vo);
				if(vo.getStrMsgType().equals("1")){
					throw new Exception(vo.getStrMsgString());
				}
				else
				{
				
					util = new HisUtil("Issue Detail Report","PhyStockVerificationSheetRptData");
					strItemVal=util.getOptionValue(vo.getStrItemCatWs(),"0","0^Select Value", false);
					formBean.setStrItemCategCmb(strItemVal);
					
			    	
				}
	
			} 

		 catch (Exception e) 
		 {
                e.printStackTrace();
				strmsgText = "PhyStockVerificationSheetRptData.setItemCategComboDtl() --> "
					+ e.getMessage();
				HisException eObj = new HisException("IPD", "PhyStockVerificationSheetRptData->setItemCategComboDtl()", strmsgText);
				formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			    
			   
		 }
	}
	
	
	
	public static void getItemCatList(PhyStockVerificationSheetRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PhyStockVerificationSheetRptBO bo = null;
		PhyStockVerificationSheetRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new PhyStockVerificationSheetRptBO();
			voObj = new PhyStockVerificationSheetRptVO();
			
			String strStoreId = request.getParameter("storeId");
			
			if (strStoreId == null)
				strStoreId = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PhyStockVerificationSheetRptDATA");
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
			strmsgText = "mms.transactions.PhyStockVerificationSheetRptDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PhyStockVerificationSheetRptDATA->getItemCatList()", strmsgText);
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
	
	public static void getGroupList(PhyStockVerificationSheetRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PhyStockVerificationSheetRptBO bo = null;
		PhyStockVerificationSheetRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new PhyStockVerificationSheetRptBO();
			voObj = new PhyStockVerificationSheetRptVO();
			
			String strItemCatId = request.getParameter("itemCatId");
			
			if (strItemCatId == null)
				strItemCatId = "0";
			
			voObj.setStrItemCatId(strItemCatId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			bo.getGroupList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PhyStockVerificationSheetRptDATA");
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
			strmsgText = "mms.transactions.PhyStockVerificationSheetRptDATA.getGroupList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PhyStockVerificationSheetRptDATA->getGroupList()", strmsgText);
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
	
	public static void getItemList(PhyStockVerificationSheetRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PhyStockVerificationSheetRptBO bo = null;
		PhyStockVerificationSheetRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new PhyStockVerificationSheetRptBO();
			voObj = new PhyStockVerificationSheetRptVO();
			
			String strStoreId = request.getParameter("storeId");
			String strItemCatId = request.getParameter("itemCatId");
			String strGroupId = request.getParameter("groupId");
			
			if (strItemCatId == null)
				strItemCatId = "0";
			if (strStoreId == null)
				strStoreId = "0";
			if (strGroupId == null)
				strGroupId = "0";
			
			voObj.setStrItemCatId(strItemCatId);
			voObj.setStrStoreId(strStoreId);
			voObj.setStrGroupId(strGroupId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			bo.getItemList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PhyStockVerificationSheetRptDATA");
			String temp = "<option value='0'>All</option>";

			if (voObj.getStrItemWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrItemWs(), "0", "0^All",
						true);

			}else{
				
				temp = "<option value='0'>All</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.PhyStockVerificationSheetRptDATA.getGroupList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PhyStockVerificationSheetRptDATA->getGroupList()", strmsgText);
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
	
	public static void showReport(PhyStockVerificationSheetRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";

		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strStoreId = formBean.getStrStoreId();
			String strCatCode = formBean.getStrItemCatNo();
			String strGroupId = formBean.getStrGroupId();
			String[] strItemId = formBean.getStrItemId().replace("^", "#").split("#");
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			
			String strUserRemarks = formBean.getStrUserRemarks();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			reportFormat = formBean.getStrReportFormat();
			
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			String strReportName = "Physical Stock Verification Sheet";
			
			String reportPath = "/mms/reports/phystockverification_mmsrpt.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				params.put("hospCode", strHospitalCode);
				params.put("storeId", strStoreId);
				params.put("catCode", strCatCode);
				if(strGroupId.equals("0")){
					params.put("groupId", "0");
				}else{
					params.put("groupId", strGroupId);
				}
				if(strItemId[0].equals("0")){
					params.put("itemId", "0");
				}else{
					params.put("itemId", strItemId[0]);
				}
				params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
				params.put("toDate", sdf.format(sdf.parse(strToDate)));
				
			
				ts.displayReport(request, response, reportPath, reportFormat,
						params,strStoreId);
			
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
