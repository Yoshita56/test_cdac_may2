package mms.reports.controller.data;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.reports.bo.ReturnAcknowledgeRPTBO;
import mms.reports.controller.fb.ReturnAcknowledgeRPTFB;
import mms.reports.controller.hlp.ReturnAcknowledgeRPTHLP;
import mms.reports.vo.ReturnAcknowledgeRPTVO;

public class ReturnAcknowledgeRPTDATA {
	
	/* storecmb itemcategorycmb */
	public static void initialGenAdd(ReturnAcknowledgeRPTFB fb,HttpServletRequest request) {
		ReturnAcknowledgeRPTVO vo = null;
		ReturnAcknowledgeRPTBO bo = null;
		HisUtil hisutil = null;
		//String strCurrentDate;

		try {
			vo = new ReturnAcknowledgeRPTVO();
			bo = new ReturnAcknowledgeRPTBO();
			
			hisutil = new HisUtil("mms", "ReturnAcknowledgeRPTDATA");

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
			HisException eObj = new HisException("mms",	"ReturnAcknowledgeRPTDATA->initialGenAdd()", strmsgText);
			fb.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			if (vo != null)
				vo = null;
			hisutil = null;
		}
	}
	
	public static void getRptDtls(ReturnAcknowledgeRPTFB fb,HttpServletRequest request,HttpServletResponse response)
	{
	       String strmsgText = "";
		   ReturnAcknowledgeRPTVO vo = null;
		   ReturnAcknowledgeRPTBO bo = null;
		   
		  /* String reportFormat = "html";
		   String strReportName = "Issue Details";*/
		   Map<String, Object> params = new HashMap<String, Object>();
		   HisUtil util = null;

		 
		   try{
			    String strResult="";
			    vo=new ReturnAcknowledgeRPTVO();
			   	bo=new ReturnAcknowledgeRPTBO();
			   	
			   	util = new HisUtil("MMS Transactions", "ReturnAcknowledgeRPTDATA");
			   	
			   	fb.setStrCurrentDate(util.getASDate("dd-MMM-yyyy  hh:mm"));	
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());	
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			   	vo.setStrStoreId(request.getParameter("storeId"));	 
				vo.setStrStoreName(request.getParameter("storeName"));
			   	vo.setStrItemCategoryId(request.getParameter("strCategoryId"));
				vo.setStrCategoryName(request.getParameter("strCategoryName")); 
			   	vo.setStrFinancialStartYear((String) request.getParameter("startDate"));
				vo.setStrFinancialEndYear((String) request.getParameter("endDate"));
				
				bo.getReplacementDtl(vo);
				
				 if (vo.getWsItemCategoryCombo().size() > 0) {
					  if (vo.getWsItemCategoryCombo().next()) {
						  vo.setStrUserName(vo.getWsItemCategoryCombo().getString(11)); 
					  	} 
				  }
			    
				vo.getWsItemCategoryCombo().beforeFirst();

				strResult=ReturnAcknowledgeRPTHLP.getReplacementDetails(fb,vo);

				if(vo.getStrItemCategoryId()!= null){	
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult); 		 
				}else{
				    HisException eObj = new HisException("MMS", "ReturnAcknowledgeRPTDATA->getRptDtls()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	}   
				
		   	}catch(Exception _err){
		   		
		   		strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "ReturnAcknowledgeRPTDATA->getRptDtls()", strmsgText);
				fb.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				eObj = null;
		   }	   
	}

}
