/**
 * 
 */
package mms.reports.controller.data;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.reports.bo.ListItemWiseSupplierRptBO;
import mms.reports.controller.fb.ListItemWiseSupplierRptFB;
import mms.reports.controller.hlp.ListItemWiseSupplierRptHLP;
import mms.reports.vo.ListItemWiseSupplierRptVO;

/**
 * @author user
 *
 */
public class ListItemWiseSupplierRptDATA {
	
	/**
	 * This function is used to set initial parameters required to display on main page 
	 * @param formBean
	 */
	public static void initialAdd(ListItemWiseSupplierRptFB formBean,HttpServletRequest request) {
		ListItemWiseSupplierRptVO vo=null;
		ListItemWiseSupplierRptBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCatCmb,strSupplierVal,hospCmb;
		
			
		try {
			vo = new ListItemWiseSupplierRptVO();
			bo = new ListItemWiseSupplierRptBO();
			
			hisutil = new HisUtil("mms", "ListItemWiseSupplierRptDATA");
			
			String strUserLevel ="1";// request.getSession().getAttribute("USER_LEVEL").toString();
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			
			if(strUserLevel.equals("6"))
			{
				vo.setStrMode("12");
			}
			else
				vo.setStrMode("1");
			
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
			
			
			//if(strUserLevel.equals("6"))
			//{
				strSupplierVal = hisutil.getOptionValue(vo.getStrManufactureComboWS(), "0", "0^All", false);
			//}
			//else
			//{
			//	strSupplierVal = hisutil.getOptionValue(vo.getStrManufactureComboWS(), "0", "-1^Select Value", false);	
			//}
			
			if (vo.getStrHospitalWs() != null
					&& vo.getStrHospitalWs().size() > 0) {			
				hospCmb = hisutil.getOptionValue(vo.getStrHospitalWs(),
					   "", "", true);
			}
			else {
				hospCmb = "<option value='0'>Select Value</option>";
			}
			
			
			formBean.setStrManufactureCombo(strSupplierVal);
			
			formBean.setStrItemCategoryCombo(itemCatCmb);
			
			formBean.setStrhospCmb(hospCmb);	
			
			/******************** TYPE Combo ********************/
			
			bo.getTypeCombo(vo);  //  PKG_MMS_VIEW2.proc [ Mode - 1]
			
			String strTypeCombo = "";

			if (vo.getStrTypeCmbWS() != null && vo.getStrTypeCmbWS().size() > 0) 
			{
				strTypeCombo = hisutil.getOptionValue(vo.getStrTypeCmbWS(), "0","", false);

			} 
			else
			{	
				strTypeCombo = "<option value='0'>Select Value</option>";
			}
			
			
			formBean.setStrTypeCombo(strTypeCombo);
			
			/******************** TYPE Combo ********************/
			
			
												
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "ListItemWiseSupplierRptDATA->initialAdd()", strmsgText);
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
	public static void groupName(ListItemWiseSupplierRptFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		ListItemWiseSupplierRptVO vo=null;
		ListItemWiseSupplierRptBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCatNO = "";
		String strGrpCmb = "";
		
			
		try {
			hisutil = new HisUtil("MMS","ListItemWiseSupplierRptDATA");
			vo = new ListItemWiseSupplierRptVO();
			bo = new ListItemWiseSupplierRptBO();
		
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
			HisException eObj = new HisException("mms", "ListItemWiseSupplierRptDATA->groupName()", strmsgText);
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
	public static void subGroupName(ListItemWiseSupplierRptFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		ListItemWiseSupplierRptVO vo=null;
		ListItemWiseSupplierRptBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String groupId = "";
		String strSubGrpCmb = "";
		String strItemCmb = "";
		String itemCateg="";
		
				
			
		try {
			hisutil = new HisUtil("MMS","ListItemWiseSupplierRptDATA");
			vo = new ListItemWiseSupplierRptVO();
			bo = new ListItemWiseSupplierRptBO();
		
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
					"", "0^All", true);
			}else {
				strItemCmb = "<option value='0'>All</option>";
			}
			try {									
				response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strSubGrpCmb+"@"+strItemCmb);
					
				}catch(Exception e){
					
				}
			
									
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "ListItemWiseSupplierRptDATA->subGroupName()", strmsgText);
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
	public static void itemName(ListItemWiseSupplierRptFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		ListItemWiseSupplierRptVO vo=null;
		ListItemWiseSupplierRptBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCatNO = "";
		String groupId = "";
		String subGrpId = "";
		String strItemCmb = "";	
			
		try {
			hisutil = new HisUtil("MMS","ListItemWiseSupplierRptDATA");
			vo = new ListItemWiseSupplierRptVO();
			bo = new ListItemWiseSupplierRptBO();
		
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
					"", "0^All", true);
			}else {
				strItemCmb = "<option value='0'>All</option>";
			}
			
			try {									
				response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemCmb);	
				
				}catch(Exception e){
					
				}
			
									
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "ListItemWiseSupplierRptDATA->genItemName()", strmsgText);
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
	
	public static void showReport(ListItemWiseSupplierRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
		String reportPath ="";
		String strReportName = "";
			
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrItemCategoryNo();
			String strUserRemarks = formBean.getStrUserRemarks();
			String strItemId = ( formBean.getStrItemId()==null || formBean.getStrItemId().equals(""))?"0":formBean.getStrItemId() ;
			String strSuppId = ( formBean.getStrSupplierId()==null || formBean.getStrSupplierId().equals(""))?"0":formBean.getStrSupplierId() ;
			String strExpiryDays = ( formBean.getStrFrmExpiryDays()==null || formBean.getStrFrmExpiryDays().equals(""))?"0":formBean.getStrFrmExpiryDays() ;
			
			reportFormat = formBean.getStrReportFormat();
			
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			 
			if(formBean.getStrActiveOrNearExpiry().equals("1"))
			{
				strReportName = "Active Rate Contract Details";
				reportPath = "/mms/reports/dwh_listItemWiseSupplier_rptNEW.rptdesign";
			}
			else
			{
				strReportName = "Rate Contract Details <br> Expiry After " + strExpiryDays + " Days";
				 reportPath = "/mms/reports/dwh_listItemWiseSupplier_rpt2.rptdesign";
			}
			
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				params.put("hospCode", strHospitalCode);
				params.put("catCode", strCatCode);
				params.put("itemId", strItemId);
				
				params.put("suppId", strSuppId);
				params.put("expiryDays", strExpiryDays);
				params.put("report_Fix_Header","header");
				
				//System.out.println("hospCode"+ strHospitalCode);
				//System.out.println("catCode"+ strCatCode);
						//System.out.println("itemId"+ strItemId);
				
								//System.out.println("suppId"+ strSuppId);
										//System.out.println("expiryDays"+strExpiryDays);
				

				ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);
			
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	public static void showReportNew(ListItemWiseSupplierRptFB formBean,HttpServletRequest request, HttpServletResponse response) {
		
    	String strmsgText = "";
        ListItemWiseSupplierRptVO vo = null;
        ListItemWiseSupplierRptBO bo = null;
		ReportUtil ts = new ReportUtil();
		
		try {
			 String strResult="";
             vo=new ListItemWiseSupplierRptVO();
             bo=new ListItemWiseSupplierRptBO();
             
             vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());	
             vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
          
             
			 vo.setStrItemCategoryNo(request.getParameter("strItemCatId"));
			 vo.setStrItemCategoryName(request.getParameter("strItemCategoryName"));
			 vo.setStrGroupId(request.getParameter("strGroupId")); 	
			 vo.setStrGroupName(request.getParameter("strGroupName")); 
			 vo.setStrSuppId((String) request.getParameter("strSupplierId"));
			 vo.setStrSupplierName((String) request.getParameter("strSupplierName"));
			 
			 System.out.println("strItemCatId"+vo.getStrItemCategoryNo());
			 System.out.println("strItemCategoryName-----"+vo.getStrItemCategoryName());
			 System.out.println("strGroupId-----"+vo.getStrGroupId());
			 System.out.println("strGroupName-----"+vo.getStrGroupName());
			 System.out.println("strSupplierId-----"+vo.getStrSuppId());
			 System.out.println("strSupplierName-----"+vo.getStrSupplierName());
			 
          	 vo.setStrMode("1");
				
			 bo.getRateContRptDtl(vo);

			
			 strResult=ListItemWiseSupplierRptHLP.getBreakageDetails(vo);
			  
			  if(vo.getStrSuppId()!= null) { 
				  response.setHeader("Cache-Control","no-cache"); 
				  response.getWriter().print(strResult); 
			  } else{ 
				  HisException eObj= new HisException("MMS", "ListItemWiseSupplierRptDATA->showReportNew()",
			  vo.getStrMsgString()); String str = "ERROR####Application Error [ERROR ID : "
			  + eObj.getErrorID() + "], Contact System Administrator! ";
			  response.getWriter().print(str); }
			 
		   }catch(Exception _err){
			   
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "ListItemWiseSupplierRptDATA->showReportNew()", strmsgText);
				formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				eObj = null;
		   }	   
	}
}
