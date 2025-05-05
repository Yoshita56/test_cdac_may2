package mms.reports.controller.data;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.reports.bo.ItemReplacementRPTBO;
import mms.reports.controller.fb.ItemReplacementRPTFB;
import mms.reports.controller.hlp.ItemReplacementRPTHLP;
import mms.reports.vo.ItemReplacementRPTVO;

public class ItemReplacementRPTDATA {

	public static void initialGenAdd(ItemReplacementRPTFB fb,HttpServletRequest request) {
		ItemReplacementRPTVO vo = null;
		ItemReplacementRPTBO bo = null;
		HisUtil hisutil = null;
		//String strCurrentDate;

		try {
			vo = new ItemReplacementRPTVO();
			bo = new ItemReplacementRPTBO();
			
			hisutil = new HisUtil("mms", "ItemReplacementRPTDATA");

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			fb.setStrHospitalCode(hosCode);
			fb.setStrSeatId(seatid);
		
			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);
			
			bo.initialGenAdd(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			String temp1 = "";
			
			if (vo.getWsStoreNameCombo() != null && vo.getWsStoreNameCombo().size() > 0) {
				if(vo.getWsStoreNameCombo().next())
				{
					vo.setStrStoreId(vo.getWsStoreNameCombo().getString(1));
					vo.getWsStoreNameCombo().beforeFirst();
				}
				temp1 = hisutil.getOptionValue(vo.getWsStoreNameCombo(), "0","0^Select Value", false, false);

			} else {
				temp1 = "<option value='0'>Select Value</option>";
			}

			fb.setStrStoreNameCombo(temp1);
			
			//Item Category
			bo.getCategoryList(vo);

			
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
			fb.setStrItemCategoryCombo(temp2);
			
		} catch (Exception e) {

			e.printStackTrace();
			
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",	"ItemReplacementRPTDATA->initialGenAdd()", strmsgText);
			fb.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			if (vo != null)
				vo = null;
			hisutil = null;
		}
	}
	
	public static void getRptDtls(ItemReplacementRPTFB fb,HttpServletRequest request,HttpServletResponse response)
	{
	       String strmsgText = "";
		   ItemReplacementRPTVO vo = null;
		   ItemReplacementRPTBO bo = null;
		   
		  /* String reportFormat = "html";
		   String strReportName = "Issue Details";*/
		   Map<String, Object> params = new HashMap<String, Object>();
		   HisUtil util = null;

		 
		   try{
			    String strResult="";
			    vo=new ItemReplacementRPTVO();
			   	bo=new ItemReplacementRPTBO();
			   	
			   	util = new HisUtil("MMS Transactions", "ItemReplacementRPTDATA");
			   	
			   	fb.setStrCurrentDate(util.getASDate("dd-MMM-yyyy  hh:mm"));	
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());	
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			   	vo.setStrStoreId(request.getParameter("storeId"));	 	
			   	vo.setStrItemCategoryId(request.getParameter("strCategoryId"));
			   	vo.setStrFinancialStartYear((String) request.getParameter("startDate"));
				vo.setStrFinancialEndYear((String) request.getParameter("endDate"));
				vo.setStrStoreName(request.getParameter("storeName"));
				vo.setStrCategoryName(request.getParameter("strCategoryName")); 
				
				bo.getReplacementDtl(vo); //pkg_mms_view2.proc_item_transfer_report
				
				 if (vo.getWsItemCategoryCombo().size() > 0) {
					  if (vo.getWsItemCategoryCombo().next()) {
						  vo.setStrUserName(vo.getWsItemCategoryCombo().getString(28)); 
					  	} 
				  }
			    
				vo.getWsItemCategoryCombo().beforeFirst();

				strResult=ItemReplacementRPTHLP.getReplacementDetails(fb,vo);

				if(vo.getStrItemCategoryId()!= null){	
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult); 		 
				}else{
				    HisException eObj = new HisException("MMS", "ItemReplacementRPTDATA->getRptDtls()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	}   
				
		   	}catch(Exception _err){
		   		
		   		strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "ItemReplacementRPTDATA->getRptDtls()", strmsgText);
				fb.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				eObj = null;
		   }	   
	}

	public static void printVoucherDtl(ItemReplacementRPTFB fb, HttpServletRequest request, HttpServletResponse response) {
		
		ItemReplacementRPTBO bo    = null;
		ItemReplacementRPTVO vo    = null;			
		
		String strmsgText  = null;			
	
		  String strStoreId = ""; 
		  String hosCode =""; 
		  String strResult=""; 
		  String startDate=""; 
		  String endDate="";
		  String debitNoteNo="";
	
		try 
		{
			   System.out.println(" ------- ItemReplacementRPTDATA.printVoucherDtl  ---- pkg_mms_view.proc_Ret_And_Condemn_Register [ Mode - 3 ]--- ");
			 
			   bo = new ItemReplacementRPTBO();
			   vo = new ItemReplacementRPTVO();	
			   
			   hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			   strStoreId = request.getParameter("strId");
			   startDate =  request.getParameter("strFromDate");
			   endDate =    request.getParameter("strEndDate");
			   debitNoteNo = request.getParameter("strDebitNoteNo");
			   
			   vo.setStrHospitalCode(hosCode);
			   vo.setStrStoreId(strStoreId);
			   vo.setStrFinancialStartYear(startDate);
			   vo.setStrFinancialEndYear(endDate);
			   vo.setStrDebitNoteNo(debitNoteNo);

			   bo.getVoucherDtl(vo); //  pkg_mms_view.proc_Ret_And_Condemn_Register [ Mode - 3 ]

			 
			   strResult=ItemReplacementRPTHLP.getvoucherPrintDetails(fb,vo);
				
				
			   
				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}	
		
			    response.setHeader("Cache-Control", "no-cache");
			    response.getWriter().print(strResult);	
						
		} catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.ReturnAgainstIssuedRPTDATA.getIssueVoucherDtl --> " + e.getMessage();
			
			HisException eObj = new HisException("mms",
					"ReturnAgainstIssuedRPTDATA->getIssueVoucherDtl()", strmsgText);
			fb.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} finally {
		
			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			
		}
  }

}
