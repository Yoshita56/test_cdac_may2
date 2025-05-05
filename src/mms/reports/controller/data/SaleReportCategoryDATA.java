package mms.reports.controller.data;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.reports.bo.SaleReportCategoryBO;
import mms.reports.controller.fb.SaleReportCategoryFB;
import mms.reports.controller.hlp.SaleReportCategoryHLP;
import mms.reports.vo.SaleReportCategoryVO;

public class SaleReportCategoryDATA {

	public static void getStoreList(SaleReportCategoryFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		SaleReportCategoryBO bo = null;
		SaleReportCategoryVO voObj = null;
		String strmsgText = null;
		String strStoreVal = "";
		HisUtil util = null;
		try {

			bo = new SaleReportCategoryBO();
			voObj = new SaleReportCategoryVO();

			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			voObj.setStrItemCatId("10");

			voObj.setStrMode("5");
			bo.getStoreList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueToPatientDATA");

			strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^SelectValue", false);

			formBean.setStrStoreValues(strStoreVal);
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));

			}catch (Exception e) {
				e.printStackTrace();
				strmsgText = "mms.transactions.IssueToPatientDATA.getStoreList --> " + e.getMessage();
				HisException eObj = new HisException("mms", "IssueToPatientDATA->getStoreList()", strmsgText);
				formBean.setStrErrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
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

	public static void getItemCatList(SaleReportCategoryFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		SaleReportCategoryBO bo = null;
		SaleReportCategoryVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		String strPatCatVal = "";

		try {

			bo = new SaleReportCategoryBO();
			voObj = new SaleReportCategoryVO();

			String strStoreId = request.getParameter("storeId");

			if (strStoreId == null)
				strStoreId = "0";

			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrMode("1");
			bo.getItemCatList(voObj);
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "SaleReportCategoryDATA");
						
			strPatCatVal = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^Select Value", false);

					
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
					
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strPatCatVal);


		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueToPatientDATA.getItemCatList --> " + e.getMessage();
			HisException eObj = new HisException("mms", "IssueToPatientDATA->getItemCatList()", strmsgText);
			formBean.setStrErrMsg(
					"998##Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

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
		
	public static void showReport(SaleReportCategoryFB fb,HttpServletRequest request,HttpServletResponse response)
	{
	       String strmsgText = "";
	       SaleReportCategoryVO vo = null;
	       SaleReportCategoryBO bo = null;

		   Map<String, Object> params = new HashMap<String, Object>();
		   HisUtil util = null;
	
		 
		   try{
			    String strResult="";
			    String strCurrentDate="";

			    vo=new SaleReportCategoryVO();
			   	bo=new SaleReportCategoryBO();
			   	
			   	util = new HisUtil("MMS Transactions", "IssueToPatientDATA");
			   	
			   	fb.setStrCurrentDate(util.getASDate("dd-MMM-yyyy  hh:mm"));	
			   	System.out.println("StrCurrentDate--showReport_DATA"+fb.getStrCurrentDate());
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());	
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			   	vo.setStrStoreId(request.getParameter("storeId"));	 
				vo.setStrStoreName(request.getParameter("storeName"));
			  
			   	vo.setStrFinancialStartYear((String) request.getParameter("startDate"));
				vo.setStrFinancialEndYear((String) request.getParameter("endDate"));
				vo.setStrPatientCategory(request.getParameter("patientType"));
				vo.setStrPatientCategoryName(request.getParameter("patientTypeName"));
	
				
				bo.getReplacementDtl(vo);
				
				strResult=SaleReportCategoryHLP.getSaleDetails(fb,vo);
	
				if(vo.getStrItemCategoryId()!= null){	
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult); 		 
				}else{
				    HisException eObj = new HisException("MMS", "IssueToPatientDATA->showReport()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	}   
				
		   	}catch(Exception e){
		   		
		   		strmsgText = e.getMessage();
				HisException eObj = new HisException("MMS", "IssueToPatientDATA->showReport()", strmsgText);
				fb.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				eObj = null;
		   }	   
	}

}
