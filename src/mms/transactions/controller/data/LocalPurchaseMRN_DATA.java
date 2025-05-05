/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 31/Jan/2009
 *  
*/

package mms.transactions.controller.data;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.transactions.bo.LocalPurchaseMRN_BO;
import mms.transactions.controller.fb.LocalPurchaseMRN_FB;
import mms.transactions.controller.hlp.LocalPurchaseMRN_HLP;
import mms.transactions.vo.LocalPurchaseMRN_VO;

public class LocalPurchaseMRN_DATA {

	public static void initialGenAdd(LocalPurchaseMRN_FB formBean,
			HttpServletRequest request) {
		LocalPurchaseMRN_VO vo = null;
		LocalPurchaseMRN_BO bo = null;
		HisUtil hisutil = null;
		String strCurrentDate;


		try {
			vo = new LocalPurchaseMRN_VO();
			bo = new LocalPurchaseMRN_BO();

			hisutil = new HisUtil("mms", "LocalPurchaseMRN_DATA");

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
		
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);

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
	
	public static void getGroupList(LocalPurchaseMRN_FB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		LocalPurchaseMRN_BO bo = null;
		LocalPurchaseMRN_VO voObj = null;
		String strmsgText = null,temp="";
		HisUtil util = null;
		try {

			bo = new LocalPurchaseMRN_BO();
			voObj = new LocalPurchaseMRN_VO();

			String strItemCatId = request.getParameter("itemCat");
			
			//System.out.println("strItemCatId------------>"+strItemCatId);

			if (strItemCatId == null)
				strItemCatId = "0";

			voObj.setStrItemCategoryId(strItemCatId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());

			
			bo.getGroupList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Reports", "StockOnHandRptDATA");
			
			//System.out.println("Catg------------>"+voObj.getStrItemCategoryId());
			//System.out.println("Grp Combo Size------------>"+voObj.getStrGroupCmbWS().size());
				
			if (voObj.getStrGroupCmbWS().size() != 0) {

				temp = util.getOptionValue(voObj.getStrGroupCmbWS(), "0",
						"0^All", true);

			} else {

				temp = "<option value='0'>All</option>";
			}
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.reports.StockOnHandRptDATA.getGroupList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StockOnHandRptDATA->getGroupList()", strmsgText);
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
	
	public static void lpitemName(LocalPurchaseMRN_FB formBean,HttpServletRequest request, HttpServletResponse response) {
		LocalPurchaseMRN_VO vo=null;
		LocalPurchaseMRN_BO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCat = "";
		String strGrpCmb = "";	
		try {
			hisutil = new HisUtil("MMS","LocalPurchaseMRN_DATA");
			vo = new LocalPurchaseMRN_VO();
			bo = new LocalPurchaseMRN_BO();
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
	public static void getViewDtl(LocalPurchaseMRN_FB _LocalPurchaseMRN_FB,HttpServletRequest request,HttpServletResponse response)
	{
	       String strmsgText = "";
		   LocalPurchaseMRN_VO vo = null;
		   LocalPurchaseMRN_BO bo = null;
		   ReportUtil ts = new ReportUtil();		
		   String reportFormat = "html";
		   String strReportName = "Issue Details";
		   Map<String, Object> params = new HashMap<String, Object>();
		   try{
			   String strResult="";
			    vo=new LocalPurchaseMRN_VO();
			   	bo=new LocalPurchaseMRN_BO();
			   	String strHospitalCode = vo.getStrHospitalCode();
			   	
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());	   	
			   	vo.setStrStoreId(request.getParameter("storeId"));	 	
			   	vo.setStrItemCategoryId(request.getParameter("strCategoryId"));
			   	vo.setStrInstituteId(request.getParameter("strInstituteId"));
			   	vo.setStrFinancialStartYear((String) request.getParameter("startDate"));
				vo.setStrFinancialEndYear((String) request.getParameter("endDate"));
				vo.setStrStoreName(request.getParameter("storeName"));
				vo.setStrInstituteName(request.getParameter("strInstituteName"));			
				vo.setStrSupplierName(request.getParameter("strSupplierName"));				
				vo.setStrSupplierId(request.getParameter("strSupplierId"));		
				vo.setStrlpItemName(request.getParameter("strItemName"));	
				vo.setStrlpItemId(request.getParameter("strItemId"));
				vo.setStrCategoryName(request.getParameter("strCategoryName"));
				
				vo.setStrGroupId(request.getParameter("strGroupId"));
				vo.setStrGroupName(request.getParameter("strGroupName"));
				
				vo.setStrActId(request.getParameter("strActId"));
				
				System.out.println("------Action--------"+vo.getStrActId());
				System.out.println("------setStrGroupId--------"+vo.getStrGroupId());
				System.out.println("------Grp name--------"+vo.getStrGroupName());
			
				int ActID =Integer.parseInt(vo.getStrActId());
				 if (ActID == 1) {
					 System.out.println("------mode val 1--------");
					 
					 bo.setViewPageDtl(vo);
					strResult=LocalPurchaseMRN_HLP.getLPMRNDetails(vo);
				 }else if(ActID == 3){
					 System.out.println("------mode val 3--------");
					 bo.setViewPageDtl(vo);
					 strResult=LocalPurchaseMRN_HLP.getConsolidatedDetails(vo);
				 }
				 
				 System.out.println("----strResult-------"+strResult);
				 
//				bo.setViewPageDtl(vo);
//
//			    String strResult=LocalPurchaseMRN_HLP.getLPMRNDetails(vo);
			    
			    
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
