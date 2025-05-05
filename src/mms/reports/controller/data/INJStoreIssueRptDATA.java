package mms.reports.controller.data;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.ReportUtil;
import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.reports.bo.INJStoreIssueRptBO;
import mms.reports.controller.fb.INJStoreIssueRptFB;
import mms.reports.controller.hlp.INJStoreIssueRptHLP;
import mms.reports.vo.INJStoreIssueRptVO;

public class INJStoreIssueRptDATA {

	public static void initialGenAdd(INJStoreIssueRptFB formBean,HttpServletRequest request) {
		INJStoreIssueRptVO vo = null;
		INJStoreIssueRptBO bo = null;
		HisUtil hisutil = null;
		String strCurrentDate;


		try {
			vo = new INJStoreIssueRptVO();
			bo = new INJStoreIssueRptBO();
			
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
				temp = hisutil.getOptionValue(vo.getWsStoreNameCombo(), "","", false, false);

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
	
	public static void lpitemName(INJStoreIssueRptFB formBean,HttpServletRequest request, HttpServletResponse response) {
		INJStoreIssueRptVO vo=null;
		INJStoreIssueRptBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCat = "";
		
		try {
			hisutil = new HisUtil("MMS","LocalPurchaseMRN_DATA");
			vo = new INJStoreIssueRptVO();
			bo = new INJStoreIssueRptBO();
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			itemCat = (String) request.getParameter("itemCat");
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setlpItemvalue(itemCat);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setlpItemvalue(itemCat);	
			vo.setStrItemCategoryId(itemCat);
			
			bo.lpitemName(vo);	 // PKG_MMS_VIEW.proc_storeitem_brand_list [ Mode - 4 ]
			if (vo.getStrMsgType().equals("1")) 
			{
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
	
	public static void getViewDtl(INJStoreIssueRptFB fb,HttpServletRequest request,HttpServletResponse response)
	{
	       String strmsgText = "";
		   INJStoreIssueRptVO vo = null;
		   INJStoreIssueRptBO bo = null;
		   ReportUtil ts = new ReportUtil();		
		   String reportFormat = "html";
		   String strReportName = "Issue Details";
		   Map<String, Object> params = new HashMap<String, Object>();
		   try
		   {
			    String strResult="";
			    vo=new INJStoreIssueRptVO();
			   	bo=new INJStoreIssueRptBO();
			   				   
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());			   		   	
			   	
			   	vo.setStrStoreId(request.getParameter("storeId"));	 	
			   	vo.setStrItemCategoryId(request.getParameter("strCategoryId"));					
				vo.setStrStoreName(request.getParameter("storeName"));
				vo.setStrCategoryName(request.getParameter("strCategoryName")); 				
				vo.setStrItemBrandId(request.getParameter("strItemId"));			
				vo.setStrGeneType(request.getParameter("strGeneType"));
				
				
								
				bo.setViewPageDtl(vo);
				//strResult=INJStoreIssueRptHLP.getTransferDetails(vo,request);
				if(vo.getStrGeneType().equals("1"))
				{
				    strResult=INJStoreIssueRptHLP.getBarCodeGeneration(vo,request);
				}
				else
				{
					strResult=INJStoreIssueRptHLP.getBarCodeSave(vo,request);
				}	
				
				
				//System.out.println("--strResult---"+strResult);
				if(vo.getStrItemCategoryId()!= null){	
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult+"$"+vo.getStrGeneType()); 		 
				}
				 else{
				    HisException eObj = new HisException("MMS", "BreakageItemDtlTransDATA->getViewDtl()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }   
		   }
		   catch(Exception _err)
		   {
			   _err.printStackTrace();
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "INJStoreIssueRptDATA->getViewDtl()", strmsgText);
				fb.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//fb.setStrMsgType("1");
				eObj = null;
		   }	   
	}
	
	
}
