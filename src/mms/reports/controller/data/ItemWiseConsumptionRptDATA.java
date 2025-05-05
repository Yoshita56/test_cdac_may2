/**
 * 
 */
package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.ItemWiseConsumptionRptBO;
import mms.reports.controller.fb.ItemWiseConsumptionRptFB;
import mms.reports.vo.ItemWiseConsumptionRptVO;

/**
 * Developer : Tanvi Sappal
 * Version : 1.0 Date : 17/July/2009
 * Module : MMS 
 */
public class ItemWiseConsumptionRptDATA {
	
	/**
	 * This function is used to set initial parameters required to display on main page 
	 * @param formBean
	 */
	public static void initialAdd(ItemWiseConsumptionRptFB formBean,HttpServletRequest request) {
		ItemWiseConsumptionRptVO vo=null;
		ItemWiseConsumptionRptBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCatCmb = "";
		String strHospName="";
		
			
		try {
			vo = new ItemWiseConsumptionRptVO();
			bo = new ItemWiseConsumptionRptBO();
			
			
			hisutil = new HisUtil("MMS", "ItemWiseConsumptionRptDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			bo.getHospitalName(vo);
			strHospName= hisutil.getOptionValue(vo.getStrHospitalWs(),"33101","", false);
			formBean.setStrHospNameValues(strHospName);
						
			bo.initialAdd(vo);	
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if (vo.getItemCategoryWS() != null
					&& vo.getItemCategoryWS().size() > 0) {			
			     itemCatCmb = hisutil.getOptionValue(vo.getItemCategoryWS(),
					   "", "0^Select Value", true);
			}
			else {
				itemCatCmb = "<option value='0'>Select Value</option>";
			}
			
			formBean.setStrItemCategoryCombo(itemCatCmb);
			
												
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "ItemWiseConsumptionRptDATA->initialAdd()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
			hisutil = null;
		}
	}
	
	/**
	 * This function is used to display Group Name on the basis of ItemCategory Name: 
	 * @param formBean
	 */
	public static void groupName(ItemWiseConsumptionRptFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		ItemWiseConsumptionRptVO vo=null;
		ItemWiseConsumptionRptBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCatNO = "";
		String strGrpCmb = "";
		
			
		try {
			hisutil = new HisUtil("MMS","ItemWiseConsumptionRptDATA");
			vo = new ItemWiseConsumptionRptVO();
			bo = new ItemWiseConsumptionRptBO();
		
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			itemCatNO = (String) request.getParameter("itemCatNo");
			
					
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrItemCategoryNo(itemCatNO);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
				
			bo.getGroupName(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if(vo.getGroupIdWS()!=null && vo.getGroupIdWS().size() > 0){			
				strGrpCmb = hisutil.getOptionValue(vo.getGroupIdWS(),"", "0^All", true);
			}else {
				strGrpCmb = "<option value='0'>All</option>";
			}
			
			try {									
				response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strGrpCmb);
					
				}catch(Exception e){
					
				}
			
									
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "ItemWiseConsumptionRptDATA->groupName()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print("ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");

		     } catch (Exception e1) {
				
			}
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
			hisutil = null;
		}
	}

	/**
	 * This function is used to display SubGroup Name on the basis of Group Name: 
	 * @param formBean
	 */
	public static void subGroupName(ItemWiseConsumptionRptFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		ItemWiseConsumptionRptVO vo=null;
		ItemWiseConsumptionRptBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String groupId = "";
		String strSubGrpCmb = "";
		String strItemCmb = "";
		String itemCateg="";
		
				
			
		try {
			hisutil = new HisUtil("MMS","ItemWiseConsumptionRptDATA");
			vo = new ItemWiseConsumptionRptVO();
			bo = new ItemWiseConsumptionRptBO();
		
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			groupId = (String) request.getParameter("groupId");
			itemCateg= request.getParameter("itemCateg");
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrGroupId(groupId);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrItemCategoryNo(itemCateg);	
			bo.getSubGroupName(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			
			if(vo.getSubGroupIdWS()!=null
					&& vo.getSubGroupIdWS().size() > 0){			
				strSubGrpCmb = hisutil.getOptionValue(vo.getSubGroupIdWS(),
					"", "0^All", true);
			}else {
				strSubGrpCmb = "<option value='0'>All</option>";
			}
				
			bo.getItemName(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if(vo.getItemIdWS()!=null
					&& vo.getItemIdWS().size() > 0){			
				strItemCmb = hisutil.getOptionValue(vo.getItemIdWS(),
					"", "0^Select Value", true);
			}else {
				strItemCmb = "<option value='0'>Select Value</option>";
			}
			try {									
				response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strSubGrpCmb+"@"+strItemCmb);
					
				}catch(Exception e){
					
				}
			
									
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "ItemWiseConsumptionRptDATA->subGroupName()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print("ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");

		     } catch (Exception e1) {
				
			}
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
			hisutil = null;
		}
	}
	
	/**
	 * This function is used to display GenItem Name on the basis of StoreId,ItemCtNo,GrpId,SubGrpId: 
	 * @param formBean
	 */
	public static void itemName(ItemWiseConsumptionRptFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		ItemWiseConsumptionRptVO vo=null;
		ItemWiseConsumptionRptBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCatNO = "";
		String groupId = "";
		String subGrpId = "";
		String strItemCmb = "";	
			
		try {
			hisutil = new HisUtil("MMS","ItemWiseConsumptionRptDATA");
			vo = new ItemWiseConsumptionRptVO();
			bo = new ItemWiseConsumptionRptBO();
		
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
						
			itemCatNO = (String) request.getParameter("itemCatNo");
			groupId = (String) request.getParameter("groupId");
			subGrpId = (String) request.getParameter("subgrpid");
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrItemCategoryNo(itemCatNO);
			formBean.setStrGroupId(groupId);
			formBean.setStrSubGroupId(subGrpId);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrSubGroupId(formBean.getStrSubGroupId());
				
						
			bo.getItemName(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if(vo.getItemIdWS()!=null
					&& vo.getItemIdWS().size() > 0){			
				strItemCmb = hisutil.getOptionValue(vo.getItemIdWS(),
					"", "0^Select Value", true);
			}else {
				strItemCmb = "<option value='0'>Select Value</option>";
			}
			
			try {									
				response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemCmb);	
				
				}catch(Exception e){
					
				}
			
									
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "ItemWiseConsumptionRptDATA->genItemName()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print("ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");

		     } catch (Exception e1) {
				
			}
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
			hisutil = null;
		}
	}
	
	public static void showReport(ItemWiseConsumptionRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";

		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrItemCategoryNo();
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			String strFromYear = formBean.getStrFromYear();
			String strToYear = formBean.getStrToYear();
			String strUserRemarks = formBean.getStrUserRemarks();
			String strItemId = formBean.getStrItemId();
			reportFormat = formBean.getStrReportFormat();
			
			System.out.println("strCatCode----"+strCatCode);
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			String strReportName = "Item Wise Consumption Details";

			 
		//System.out.println("formBean.getStrDateYear()::"+formBean.getStrDateYear());
		//System.out.println("item wise cosumption ");
		if(formBean.getStrDateYear().equals("1")){
				
				String reportPath = "/mms/reports/itemWiseConsumption_mms_rpt.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				
				params.put("hospCode", strHospitalCode);
				params.put("catCode", strCatCode);
				if(strItemId.equals("0")){
					params.put("itemId", "0");
				}else{
					params.put("itemId", strItemId);
				}				
				params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
				params.put("toDate", sdf.format(sdf.parse(strToDate)));
				params.put("fromyear", "0");
				params.put("toYear", "0");
				
				System.out.println(reportPath);
				ts.displayReport(request, response, reportPath, reportFormat,
						params,strHospitalCode);
				
			}else if(formBean.getStrDateYear().equals("2")){
				
				String reportPath = "/mms/reports/itemWiseConsumption_mms_rpt1.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				
				params.put("hospCode", strHospitalCode);
				params.put("catCode", strCatCode);
				if(strItemId.equals("0")){
					params.put("itemId", "0");
				}else{
					params.put("itemId", strItemId);
				}
				
				params.put("fromDate", "null");
				params.put("toDate", "null");
				params.put("fromyear", strFromYear);
				params.put("toYear", strToYear);
				System.out.println(reportPath);
				ts.displayReport(request, response, reportPath, reportFormat,
						params,strHospitalCode);
			}
		
			
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	public static void showReportNew(ItemWiseConsumptionRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
		ItemWiseConsumptionRptVO vo = new ItemWiseConsumptionRptVO();
		ItemWiseConsumptionRptBO bo = new ItemWiseConsumptionRptBO();
		String reportFormat = "html";

		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrItemCategoryNo();
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			String strFromYear = formBean.getStrFromYear();
			String strToYear = formBean.getStrToYear();
			String strUserRemarks = formBean.getStrUserRemarks();
			String strItemId = formBean.getStrItemId();
			reportFormat = formBean.getStrReportFormat();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrReportId(strReportId);
			vo.setStrItemCategoryNo(strCatCode);
			vo.setStrFromDate(strFromDate);
			vo.setStrToDate(strToDate);
			vo.setStrFromYear(strFromYear);
			vo.setStrToYear(strToYear);
			vo.setStrUserRemarks(strUserRemarks);
			vo.setStrItemId(strItemId);
			
			bo.showReportNew(vo);
			

			 
		//System.out.println("formBean.getStrDateYear()::"+formBean.getStrDateYear());
		//System.out.println("item wise cosumption ");
		if(formBean.getStrDateYear().equals("1")){
				
				String reportPath = "/mms/reports/itemWiseConsumption_mms_rpt.rptdesign";
				
				
				ts.displayReport(request, response, reportPath, reportFormat,
						params,strHospitalCode);
				
			}else if(formBean.getStrDateYear().equals("2")){
				
				String reportPath = "/mms/reports/itemWiseConsumption_mms_rpt1.rptdesign";
				
				
				
				ts.displayReport(request, response, reportPath, reportFormat,
						params,strHospitalCode);
			}
		
			
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	


}
