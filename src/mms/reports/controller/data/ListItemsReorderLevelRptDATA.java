package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.ListItemsReorderLevelRptBO;
import mms.reports.controller.fb.ListItemsReorderLevelRptFB;
import mms.reports.vo.ListItemsReorderLevelRptVO;

public class ListItemsReorderLevelRptDATA {
	
	public static void getStoreList(ListItemsReorderLevelRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ListItemsReorderLevelRptBO bo = null;
		ListItemsReorderLevelRptVO voObj = null;
		String strmsgText = null;
		String strStoreVal = "";
		HisUtil util = null;
		try {

			bo = new ListItemsReorderLevelRptBO();
			voObj = new ListItemsReorderLevelRptVO();
			String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			voObj.setStrItemCatId("10");
			
			if(strUserLevel.equals("6")){
				voObj.setStrMode("6");
			}
			else
				voObj.setStrMode("5");
			
			bo.getStoreList(voObj);
			formBean.setStrStoreId(voObj.getStrStoreId());

			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());
			}
			util = new HisUtil("MMS Transactions", "ListItemsReorderLevelRptDATA");
			
			strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "", "", false);
						
			formBean.setStrStoreValues(strStoreVal);
			setItemCategCombo(formBean,request);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.ListItemsReorderLevelRptDATA.getStoreList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ListItemsReorderLevelRptDATA->getStoreList()", strmsgText);
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
	
	
	public static void setItemCategCombo(ListItemsReorderLevelRptFB formBean,HttpServletRequest request) 
	{

		ListItemsReorderLevelRptVO vo=null;
		ListItemsReorderLevelRptBO bo=null;
		String strmsgText="";
		HisUtil util = null;
		String strItemVal="";
		
		try {
				bo=new ListItemsReorderLevelRptBO();
				vo=new ListItemsReorderLevelRptVO();
				
				vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrStoreId(formBean.getStrStoreId());
				bo.getItemCatList(vo);
				if(vo.getStrMsgType().equals("1")){
					throw new Exception(vo.getStrMsgString());
				}
				else
				{
				
					util = new HisUtil("Issue Detail Report","ListItemsReorderLevelRptData");
					strItemVal=util.getOptionValue(vo.getStrItemCatWs(),"0","0^Select Value", false);
					
					formBean.setStrItemCategoryCombo(strItemVal);
					
			    	
				}
	
			} 

		 catch (Exception e) 
		 {
                e.printStackTrace();
				strmsgText = "ListItemsReorderLevelRptData.setItemCategComboDtl() --> "
					+ e.getMessage();
				HisException eObj = new HisException("IPD", "ListItemsReorderLevelRptData->setItemCategComboDtl()", strmsgText);
				formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			    
			   
		 }
	}
	
	
	
	
	public static void getItemCatList(ListItemsReorderLevelRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ListItemsReorderLevelRptBO bo = null;
		ListItemsReorderLevelRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new ListItemsReorderLevelRptBO();
			voObj = new ListItemsReorderLevelRptVO();
			
			String strStoreId = request.getParameter("storeId");
			
			if (strStoreId == null)
				strStoreId = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "ListItemsReorderLevelRptDATA");
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
			strmsgText = "mms.transactions.ListItemsReorderLevelRptDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ListItemsReorderLevelRptDATA->getItemCatList()", strmsgText);
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
	
	public static void showReport(ListItemsReorderLevelRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";

		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrItemCatNo();
			String strStoreId = formBean.getStrStoreId();
			String strUserRemarks = formBean.getStrUserRemarks();
			
			reportFormat = formBean.getStrReportFormat();
			
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			String strReportName = "List of Drugs Reaching Reorder Level";
			
			String reportPath = "/mms/reports/listitemsreorderlevel_mmsrpt.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				params.put("hospCode", strHospitalCode);
				params.put("catCode", strCatCode);
				params.put("storeId", strStoreId);
				
				ts.displayReport(request, response, reportPath, reportFormat,
						params,strStoreId);
			
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
