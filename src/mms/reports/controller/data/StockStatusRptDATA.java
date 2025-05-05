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

import mms.reports.bo.ReturnDetailRptBO;
import mms.reports.bo.StockStatusRptBO;
import mms.reports.controller.fb.ReturnDetailRptFB;
import mms.reports.controller.fb.StockStatusRptFB;
import mms.reports.vo.ReturnDetailRptVO;
import mms.reports.vo.StockStatusRptVO;

/**
 * Developer : Tanvi Sappal
 * Version : 1.0 
 * Date : 21/July/2009
 * Module : MMS 
 */
public class StockStatusRptDATA {
	
	/**
	 * This function is used to set initial parameters required to display on main page 
	 * @param formBean
	 */
	public static void initialAdd(StockStatusRptFB formBean,HttpServletRequest request) {
		StockStatusRptVO vo=null;
		StockStatusRptBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String storeCmb = "";
		String strHospName;
			
		try {
			vo = new StockStatusRptVO();
			bo = new StockStatusRptBO();
			
			hisutil = new HisUtil("mms", "StockStatusRptDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			
				
			bo.getHospitalName(vo);	
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			
			else{
				hisutil = new HisUtil("Stock Status Report",
					"StockStatusRptDATA");
										
					strHospName= hisutil.getOptionValue(vo.getStrHospitalWs(),"0","0^Select Value", false);
					formBean.setStrHospNameValues(strHospName);
			}
			
			
												
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "StockStatusRptDATA->initialAdd()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
			hisutil = null;
		}
	}
	
	
	
	
	public static void setItemCategCombo(StockStatusRptFB formBean,HttpServletRequest request) 
	{

		StockStatusRptVO vo=null;
		StockStatusRptBO bo=null;
		String strmsgText="";
		HisUtil util = null;
		String strItemVal="";
		
		try {
				bo=new StockStatusRptBO();
				vo=new StockStatusRptVO();
				
				vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrStoreId(formBean.getStrStoreId());
				bo.getItemCategory(vo);
				if(vo.getStrMsgType().equals("1")){
					throw new Exception(vo.getStrMsgString());
				}
				else
				{
				
					util = new HisUtil("Issue Detail Report","StockStatusRptData");
					
					
					
				
					strItemVal=util.getOptionValue(vo.getItemCategoryWS(),"0","0^Select Value", false);
					
					formBean.setStrItemCategoryCombo(strItemVal);
					
			    	
				}
	
			} 

		 catch (Exception e) 
		 {
                e.printStackTrace();
				strmsgText = "StockStatusRptData.setItemCategComboDtl() --> "
					+ e.getMessage();
				HisException eObj = new HisException("IPD", "StockStatusRptData->setItemCategComboDtl()", strmsgText);
				formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			    
			   
		 }
	}
	
	
	
	
	public static void setStoreComboDtl(StockStatusRptFB formBean,HttpServletRequest request,HttpServletResponse response) {

		StockStatusRptVO vo=null;
		StockStatusRptBO bo=null;
		String strmsgText="";
		HisUtil util = null;
		String strStoreVal="";
		String storeCmb="";
		
		try {
				bo=new StockStatusRptBO();
				vo=new StockStatusRptVO();
				
				vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				vo.setStrItemCategoryNo("10");//vo.setStrStoreId(request.getParameter("strId"));
				bo.initialAdd(vo);
				if(vo.getStrMsgType().equals("1")){
					throw new Exception(vo.getStrMsgString());
				}else{
				
					util = new HisUtil("Issue Detail Report",
					"IssueDetailRptData");
							
					
					
					
					strStoreVal=util.getOptionValue(vo.getStoreIdWS(), "0",
							"0^Select Value", false);
				//	formBean.setStrStoreId(strStoreVal);
					response.getWriter().print(strStoreVal);
					
					setItemCategCombo(formBean,request);
					
			    	
				}
	
			} 

		 catch (Exception e) {

				strmsgText = "ReturnDetailRptDATA.setItemCategComboDtl() --> "
					+ e.getMessage();
				HisException eObj = new HisException("IPD", "ReturnDetailRptDATA->setItemCategComboDtl()", strmsgText);
			    String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
			    try
			    {
			    	response.getWriter().print(response1);
			    	eObj=null;
			    }
			    catch(Exception e1)
			    {
			    	
			    }
		 }
	}
	

	/**
	 * This function is used to display Group Name on the basis of ItemCategory Name: 
	 * @param formBean
	 */
	public static void itemCategory(StockStatusRptFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		StockStatusRptVO vo=null;
		StockStatusRptBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCatNO = "";
		String storeID = "";
		
		
			
		try {
			hisutil = new HisUtil("MMS","StockStatusRptDATA");
			vo = new StockStatusRptVO();
			bo = new StockStatusRptBO();
		
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			storeID = (String) request.getParameter("storeid");
			
					
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrStoreId(storeID);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(formBean.getStrStoreId());
				
			bo.getItemCategory(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if(vo.getItemCategoryWS()!=null
					&& vo.getItemCategoryWS().size() > 0){			
				itemCatNO = hisutil.getOptionValue(vo.getItemCategoryWS(),
					"", "0^Select Value", true);
			}else {
				itemCatNO = "<option value='0'>Select Value</option>";
			}
			
			try {									
				response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(itemCatNO);
					
				}catch(Exception e){
					
				}
			
									
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "StockStatusRptDATA->itemCategory()", strmsgText);
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
	 * This function is used to display Group Name on the basis of ItemCategory Name: 
	 * @param formBean
	 */
	public static void groupName(StockStatusRptFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		StockStatusRptVO vo=null;
		StockStatusRptBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCatNO = "";
		String strGrpCmb = "";
		
			
		try {
			hisutil = new HisUtil("MMS","StockStatusRptDATA");
			vo = new StockStatusRptVO();
			bo = new StockStatusRptBO();
		
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
			
			if(vo.getGroupIdWS()!=null
					&& vo.getGroupIdWS().size() > 0){			
				strGrpCmb = hisutil.getOptionValue(vo.getGroupIdWS(),
					"", "0^All", true);
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
			HisException eObj = new HisException("mms", "StockStatusRptDATA->groupName()", strmsgText);
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
	
	public static void showReport(StockStatusRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {
	
		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
	
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrItemCategoryNo();
			String strStoreId = formBean.getStrStoreVal();
			String strGroupId = formBean.getStrGroupId();
			String strUserRemarks = formBean.getStrUserRemarks();
			String strDate = formBean.getStrDate();
			reportFormat = formBean.getStrReportFormat();
		    
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			
			boolean footerVisible = true;
			boolean IsGroupWise = true;
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			String strReportName = "Stock Status";
			

			String reportPath = "/mms/reports/stockStatus_mms_rptNEW.rptdesign";
			
			if(formBean.getStrGroupWise().equals("1")){
				
				IsGroupWise = false;
				
				params.put("IsGroupWise", IsGroupWise);
				
				if(strGroupId.equals("0")){
					params.put("groupId", "0");
				}else{
					params.put("groupId", strGroupId);
				}
				
			}
			params.put("report_id", strReportId);
			params.put("report_Name", strReportName);
			params.put("report_Footer_Visible", footerVisible);
			params.put("report_user_Remarks", strUserRemarks);
			
			
			params.put("hospCode", Double.parseDouble(strHospitalCode));
			params.put("catCode", Double.parseDouble(strCatCode));
			params.put("storeId", Double.parseDouble(strStoreId));
			params.put("datVal", sdf.parse(strDate));
			
			ts.displayReport(request, response, reportPath, reportFormat,
					params,strHospitalCode);
					      	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
	}

}
