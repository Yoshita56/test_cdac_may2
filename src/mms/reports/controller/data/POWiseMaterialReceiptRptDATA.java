package mms.reports.controller.data;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.reports.bo.POWiseMaterialReceiptRptBO;
import mms.reports.controller.fb.POWiseMaterialReceiptRptFB;
import mms.reports.controller.hlp.POWiseMaterialReceiptRptHLP;
import mms.reports.vo.POWiseMaterialReceiptRptVO;


public class POWiseMaterialReceiptRptDATA {

	public static void initialGenAdd(POWiseMaterialReceiptRptFB formBean,
			HttpServletRequest request) {
		POWiseMaterialReceiptRptVO vo = null;
		POWiseMaterialReceiptRptBO bo = null;
		HisUtil hisutil = null;
		String strCurrentDate;


		try {
			vo = new POWiseMaterialReceiptRptVO();
			bo = new POWiseMaterialReceiptRptBO();

			hisutil = new HisUtil("mms", "POWiseMaterialRecieptRptDATA");

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
			//System.out.println("Store Name------------>"+formBean.getStrStoreNameCombo());
			bo.getCategoryList(vo);
			
			
//-----------------------------------Item Category----------------------------------------------	
			
			if (vo.getStrMsgType().equals("1")) { 
				throw new Exception(vo.getStrMsgString());
			}
			String temp2 = "";

			if (vo.getWsItemCategoryCombo() != null	&& vo.getWsItemCategoryCombo().size() > 0) 
			{
				temp2 = hisutil.getOptionValue(vo.getWsItemCategoryCombo(),"0", "0^Select Value", false,false);

			} else {

				temp2 = "<option value='0'>Select Value</option>";
			}
			formBean.setStrItemCategoryCombo(temp2);
			//System.out.println("Item Category------------>"+formBean.getStrItemCategoryCombo());
			
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
			
			
			bo.supplierCombo(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} 
			
			String temp4 = "";
			
			
			
			if (vo.getWsSupplierCombo() != null	&& vo.getWsSupplierCombo().size() > 0)
			{
				//System.out.println("Supplier SIZE------------>"+vo.getWsSupplierCombo().size());
				temp4 = hisutil.getOptionValue(vo.getWsSupplierCombo(), "0",	"0^All", true,true);

			} 
			else 
			{
				temp4 = "<option value='0'>Select Value</option>";

			}
			
			formBean.setStrSupplierCombo(temp4);
			//System.out.println("Supplier Name------------>"+formBean.getStrSupplierCombo());
			
//------------------------------------------------------------------------------------------------
			
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCurrentDate(strCurrentDate);	
			
		} catch (Exception e) {

			e.printStackTrace();
			
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",	"POWiseMaterialRecieptRptDATA->initialGenAdd()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			if (vo != null)
				vo = null;
			
			hisutil = null;
	
		}
	}
	public static void lpitemName(POWiseMaterialReceiptRptFB formBean,HttpServletRequest request, HttpServletResponse response) {
		POWiseMaterialReceiptRptVO vo=null;
		POWiseMaterialReceiptRptBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCat = "";
		String strGrpCmb = "";	
		try {
			hisutil = new HisUtil("MMS","POWiseMaterialRecieptRptDATA");
			vo = new POWiseMaterialReceiptRptVO();
			bo = new POWiseMaterialReceiptRptBO();
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
			HisException eObj = new HisException("mms", "POWiseMaterialRecieptRptDATA->groupName()", strmsgText);
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
	public static void getViewDtl(POWiseMaterialReceiptRptFB _POWiseMaterialReceiptRptFB,HttpServletRequest request,HttpServletResponse response)
	{
	       String strmsgText = "";
		   POWiseMaterialReceiptRptVO vo = null;
		   POWiseMaterialReceiptRptBO bo = null;
		   ReportUtil ts = new ReportUtil();		
		   String reportFormat = "html";
		   String strReportName = "Issue Details";
		   Map<String, Object> params = new HashMap<String, Object>();
		   
		   try{
			    String strResult="";
			    vo=new POWiseMaterialReceiptRptVO();
			   	bo=new POWiseMaterialReceiptRptBO();
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
				
				vo.setStrPoNo(_POWiseMaterialReceiptRptFB.getStrPoNo());
				System.out.println("vo.setStrPoNo---------------------------- "+_POWiseMaterialReceiptRptFB.getStrPoNo());
				
				vo.setStrActId(request.getParameter("strActId"));
				
				int ActID =Integer.parseInt(vo.getStrActId());
				 if (ActID == 2) {
					 System.out.println("------mode val 1--------");
					 bo.setViewPageDtl(vo);
					 strResult=POWiseMaterialReceiptRptHLP.getLPMRNDetails(vo);
					
				 }else if(ActID == 4){
					 System.out.println("------mode val 6--------");
					 vo.setStrActId("6");
					 bo.setViewPageDtl(vo);
					 strResult=POWiseMaterialReceiptRptHLP.getConsolidatedDetails(vo);
					 
				 }
				 
				 
//				bo.setViewPageDtl(vo);
//
//			    String strResult=POWiseMaterialReceiptRptHLP.getLPMRNDetails(vo);
			    
			    
				if(vo.getStrItemCategoryId()!= null){	
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult); 		 
				}
				 else{
				    HisException eObj = new HisException("MMS", "POWiseMaterialRecieptRptDATA->getViewDtl()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "POWiseMaterialRecieptRptDATA->getViewDtl()", strmsgText);
				_POWiseMaterialReceiptRptFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//_POWiseMaterialReceiptRptFB.setStrMsgType("1");
				eObj = null;
		   }	   
	}
}
