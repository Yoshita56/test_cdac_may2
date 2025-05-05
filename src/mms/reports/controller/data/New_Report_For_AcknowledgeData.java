/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 31/Jan/2009
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
import mms.reports.bo.New_Report_For_AcknowledgeBO;
import mms.reports.controller.fb.New_Report_For_AcknowledgeFB;
import mms.reports.controller.hlp.New_Report_For_AcknowledgeHLP;
import mms.reports.vo.New_Report_For_AcknowledgeVO;

public class New_Report_For_AcknowledgeData {

	public static void initialGenAdd(New_Report_For_AcknowledgeFB formBean,HttpServletRequest request) {
		New_Report_For_AcknowledgeVO vo = null;
		New_Report_For_AcknowledgeBO bo = null;
		HisUtil hisutil = null;
		String strCurrentDate;


		try {
			vo = new New_Report_For_AcknowledgeVO();
			bo = new New_Report_For_AcknowledgeBO();
			
			hisutil = new HisUtil("mms", "LocalPurchaseMRN_DATA");

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
		
			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);

			bo.initialGenAdd(vo);
			
//-------------------------------------Store Name--------------------------------------------
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			String temp = "";
			
			if (vo.getWsStoreNameCombo() != null && vo.getWsStoreNameCombo().size() > 0) {
				if(vo.getWsStoreNameCombo().next())
				{
					vo.setStrStoreId(vo.getWsStoreNameCombo().getString(1));
					vo.getWsStoreNameCombo().beforeFirst();
				}
				temp = hisutil.getOptionValue(vo.getWsStoreNameCombo(), "0","0^Select Value", false, false);

			} else {
				temp = "<option value='0'>Select Value</option>";
			}

			formBean.setStrStoreNameCombo(temp);
			bo.getCategoryList(vo);
//			System.out.println("Store Name------------>"+formBean.getStrStoreNameCombo());
			
//-----------------------------------Item Category----------------------------------------------	
			
			
			if (vo.getStrMsgType().equals("1")) { 
				throw new Exception(vo.getStrMsgString());
			}
			String temp2 = "";

			if (vo.getWsItemCategoryCombo() != null	&& vo.getWsItemCategoryCombo().size() > 0) 
			{
				temp2 = hisutil.getOptionValue(vo.getWsItemCategoryCombo(),"0", "0^Select Value", false);

			} else {

				temp2 = "<option value='0'>Select Value</option>";
			}
			formBean.setStrItemCategoryCombo(temp2);
//			System.out.println("Item Category------------>"+formBean.getStrItemCategoryCombo());
			
//----------------------------------Purchase Through-----------------------------------------------	
			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} 
			
			String temp3 = "";
			
			if (vo.getWsInstituteList() != null	&& vo.getWsInstituteList().size() > 0)
			{
				temp3 = hisutil.getOptionValue(vo.getWsInstituteList(), "0",	"0^All", true);

			} 
			else 
			{
				temp3 = "<option value='0'>Select Value</option>";

			}
			
			formBean.setStrInstituteValues(temp3);
			//System.out.println("Purchase Through------------>"+formBean.getStrInstituteValues());
			
//------------------------------------Supplier Name---------------------------------------------
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} 
			
			String temp4 = "";
			
			if (vo.getWsSupplierCombo() != null	&& vo.getWsSupplierCombo().size() > 0)
			{
				temp4 = hisutil.getOptionValue(vo.getWsSupplierCombo(), "0",	"0^All", true);

			} 
			else 
			{
				temp4 = "<option value='0'>Select Value</option>";
			}
			
			formBean.setStrSupplierCombo(temp4);
//			System.out.println("Supplier Name------------>"+formBean.getStrSupplierCombo());
			
//------------------------------------------------------------------------------------------------
			
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCurrentDate(strCurrentDate);	
			
		} catch (Exception e) {

			e.printStackTrace();
			
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",	"ReceiveFromThirdPartyTransDATA->initialGenAdd()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			if (vo != null)
				vo = null;
			
			hisutil = null;
	
		}
	}
	
	public static void lpitemName(New_Report_For_AcknowledgeFB formBean,HttpServletRequest request, HttpServletResponse response) {
		New_Report_For_AcknowledgeVO vo=null;
		New_Report_For_AcknowledgeBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCat = "";
		String strGrpCmb = "";	
		try {
			hisutil = new HisUtil("MMS","LocalPurchaseMRN_DATA");
			vo = new New_Report_For_AcknowledgeVO();
			bo = new New_Report_For_AcknowledgeBO();
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			itemCat = (String) request.getParameter("itemCat");
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setlpItemvalue(itemCat);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setlpItemvalue(formBean.getlpItemvalue());	
			
			bo.lpitemName(vo);	
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			String temp1 = "";
			if (vo.getWslpItemName() != null	&& vo.getWslpItemName().size() > 0){
				temp1 = hisutil.getOptionValue(vo.getWslpItemName(), "0",	"0^All", true);
			} 
			else {
				temp1 = "<option value='0'>All</option>";
			}

			formBean.setlpItemName(temp1);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp1);
									
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
	
	public static void getViewDtl(New_Report_For_AcknowledgeFB _LocalPurchaseMRN_FB,HttpServletRequest request,HttpServletResponse response)
	{
	       String strmsgText = "";
		   New_Report_For_AcknowledgeVO vo = null;
		   New_Report_For_AcknowledgeBO bo = null;
		   ReportUtil ts = new ReportUtil();		
		   String reportFormat = "html";
		   String strReportName = "Issue Details";
		   Map<String, Object> params = new HashMap<String, Object>();
		   try{
			    String strResult="";
			    vo=new New_Report_For_AcknowledgeVO();
			   	bo=new New_Report_For_AcknowledgeBO();
			   	
			   	String strHospitalCode = vo.getStrHospitalCode();
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());	
			   	
			   	vo.setStrStoreId(request.getParameter("storeId"));	 	
			   	vo.setStrItemCategoryId(request.getParameter("strCategoryId"));
			   	vo.setStrInstituteId(request.getParameter("strInstituteId"));
			   	
			   	vo.setStrFinancialStartYear((String) request.getParameter("startDate"));
				System.out.println("---------vo.setStrFinancialStartYear----------"+vo.getStrFinancialStartYear());
				vo.setStrFinancialEndYear((String) request.getParameter("endDate"));
			
				vo.setStrStoreName(request.getParameter("storeName"));
				vo.setStrInstituteName(request.getParameter("strInstituteName"));			
				vo.setStrSupplierName(request.getParameter("strSupplierName"));				
				vo.setStrSupplierId(request.getParameter("strSupplierId"));		
				vo.setStrlpItemName(request.getParameter("strItemName"));	
				vo.setStrlpItemId(request.getParameter("strItemId"));
				vo.setStrCategoryName(request.getParameter("strCategoryName")); 
				
				System.out.println("---------vo.setStrCategoryName----------"+vo.getStrCategoryName());
				
				vo.setStrActId(request.getParameter("strActId"));
				
				System.out.println("-------vo.getStrActId()-------"+vo.getStrActId());
			
				int ActID =Integer.parseInt(vo.getStrActId());
				 if (ActID == 17) 
				 {
					 System.out.println("------mode val 17----ISSUE----");
					 vo.setStrActId("1");
					 bo.setViewPageDtl(vo);
					strResult=New_Report_For_AcknowledgeHLP.getIssueDetails(vo);
				 }else if(ActID == 51)
				 {
					 System.out.println("------mode val 51----ItemTransfer----");
					 vo.setStrActId("2");
					 bo.setViewPageDtl(vo);
					 strResult=New_Report_For_AcknowledgeHLP.getTransferDetails(vo);
				 }
				 else if(ActID == 99)
				 {
					 System.out.println("------mode val 99----Acknowledge Pending----");
					 vo.setStrActId("3");
					 bo.setViewPageDtl(vo);
					 strResult=New_Report_For_AcknowledgeHLP.getTransferDetails(vo);
				 }
				
			    
			    //////////////
				if(vo.getStrItemCategoryId()!= null){	
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult); 		 
				}
				 else{
				    HisException eObj = new HisException("MMS", "BreakageItemDtlTransDATA->getViewDtl()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "BreakageItemDtlTransDATA->getViewDtl()", strmsgText);
				_LocalPurchaseMRN_FB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//_LocalPurchaseMRN_FB.setStrMsgType("1");
				eObj = null;
		   }	   
	}
}
