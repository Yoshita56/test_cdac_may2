package mms.transactions.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.bo.AdvanceRequestTransBO;
import mms.transactions.controller.fb.AdvanceRequestTransFB;
import mms.transactions.controller.hlp.AdvanceRequestTransHLP;
import mms.transactions.vo.AdvanceRequestTransVO;

public class AdvanceRequestTransDATA {
	
	public static void getStoreDtls(AdvanceRequestTransFB formBean) {

		AdvanceRequestTransBO bo = null;
		AdvanceRequestTransVO vo = null;

		HisUtil util = null;
		String strStoreVal = "";
		String strmsgText = null;
		
		try {
			bo = new AdvanceRequestTransBO();
			vo = new AdvanceRequestTransVO();
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.getStoreDtls(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "AdvanceRequestTransDATA");
			if(vo.getStrStoreWs()!=null && vo.getStrStoreWs().size()>0)
			{
				if(vo.getStrStoreWs().next())
				{
					vo.setStrStoreId(vo.getStrStoreWs().getString(1));
					vo.getStrStoreWs().beforeFirst();
				}
				strStoreVal = util.getOptionValue(vo.getStrStoreWs(), "","", false);
			}
						
			formBean.setStrStoreValues(strStoreVal);
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));
			
			vo.setStrReqTypeId("52");
			bo.getItemCatDtls(vo);
			String temp = "";
			if (vo.getStrItemCatWs().size() != 0) {
				
				temp = util.getOptionValue(vo.getStrItemCatWs(), "", "",true);

			}
			else
			{
				
				temp = "<option value='0'>Select Value</option>";
			}
			formBean.setStrItemCatCombo(temp);

		} catch (Exception e) {
			strmsgText = "mms.transactions.AdvanceRequestTransDATA.getStoreDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"AdvanceRequestTransDATA->getStoreDtls()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
		}
	}
	
	public static void getItemCatDtls(AdvanceRequestTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		AdvanceRequestTransBO bo = null;
		AdvanceRequestTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new AdvanceRequestTransBO();
			voObj = new AdvanceRequestTransVO();
			
			String strStoreId = request.getParameter("storeId");
			if (strStoreId == null)
				strStoreId = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrReqTypeId("52");

			bo.getItemCatDtls(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "AdvanceRequestTransDATA");
			String temp = "";

			if (voObj.getStrItemCatWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrItemCatWs(), "", "",
						true);

			}else{
				
				temp = "<option value='0'>Select Value</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			strmsgText = "mms.transactions.AdvanceRequestTransDATA.getItemCatDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"AdvanceRequestTransDATA->getItemCatDtls()", strmsgText);
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
	
	public static void getPONODtls(AdvanceRequestTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		AdvanceRequestTransBO bo = null;
		AdvanceRequestTransVO voObj = null;

		HisUtil util = null;
		String strmsgText = null;
		
		String[] strPrefix = null;
		
		try {
			bo = new AdvanceRequestTransBO();
			voObj = new AdvanceRequestTransVO();
			
			String strStoreId = request.getParameter("storeId");
			String strItemCatId = request.getParameter("itemcatId");
			 
			String strFlag = request.getParameter("chkId");
			
			if (strItemCatId == null)
				strItemCatId = "0";
			if (strStoreId == null)
				strStoreId = "0";

			if (strFlag == null)
				strFlag = "0";
			
			voObj.setStrItemCategoryId(strItemCatId);
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrChkAdvanceReq(strFlag);
			
			bo.getPONODtls(voObj);
		
			while(voObj.getStrPONOWs().next()){
				strPrefix = voObj.getStrPONOWs().getString(1).replace('^', '#').split("#");
				formBean.setPoPrefix(strPrefix[2]);
			}
			voObj.getStrPONOWs().beforeFirst();
						
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "AdvanceRequestTransDATA");
			String temp = "<option value='0'>Select Value</option>";

			if (voObj.getStrPONOWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrPONOWs(), "0", "0^Select Value",
						true);

			}else{
				
				temp = "<option value='0'>Select Value</option>";
			}

			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp+"@"+formBean.getPoPrefix());
			
						
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.AdvanceRequestTransDATA.getPONODtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"AdvanceRequestTransDATA->getPONODtls()", strmsgText);
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
	
	public static void getPODetails(AdvanceRequestTransFB formBean,HttpServletRequest request) {
		
		AdvanceRequestTransVO vo = null;
		AdvanceRequestTransBO bo = null;
		String strmsgText = "";
		String strPODetails = "";
				
		try {
			vo = new AdvanceRequestTransVO();
			bo = new AdvanceRequestTransBO();
			
			String strPONO = formBean.getPonovalue();
					
			
		//	//System.out.println("strPONO---------->"+strPONO);
			
			String[] strTemp = strPONO.replace('^', '#').split("#");
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrPONO(strTemp[0]);
			vo.setStrPOStoreId(strTemp[3]);
			
			bo.getPODetails(vo);
			
			strPODetails = AdvanceRequestTransHLP.getPODetails(vo.getStrPODtlsWs());
			formBean.setStrPODetailsVal(strPODetails);
			
		//	//System.out.println("po details-------->"+strPODetails);
			
		}catch (Exception e) {
			strmsgText = "mms.transactions.AdvanceRequestTransDATA.getPODetails --> "
				+ e.getMessage();
			HisException eObj = new HisException("mms",
				"AdvanceRequestTransDATA->getPODetails()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
				+ eObj.getErrorID() + "],Contact System Administrator! ");

		eObj = null;
		}finally{
			
		}

	}
	
	public static void getPODetailsDup(AdvanceRequestTransFB formBean,HttpServletRequest request) {
		
		AdvanceRequestTransVO vo = null;
		AdvanceRequestTransBO bo = null;
		String strmsgText = "";
		String strPODetailsDup = "";
		
				
		try {
			vo = new AdvanceRequestTransVO();
			bo = new AdvanceRequestTransBO();
			
//			String strPONO = request.getParameter("strPONo");
//			if (strPONO == null)
//				strPONO = "0";
			String strPONO = formBean.getPonovalue();
		//	//System.out.println("strPONO-dup----->"+strPONO);
			
			
			String[] strTemp = strPONO.replace("^","#").split("#");
					
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrPONO(strTemp[0]);
			vo.setStrPOStoreId(strTemp[3]);
			
			bo.getPODetails(vo);
			
			strPODetailsDup = AdvanceRequestTransHLP.getPODetailsDup(vo.getStrPODtlsWs());
			formBean.setStrPODetailsValDup(strPODetailsDup);
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.AdvanceRequestTransDATA.getPODetailsDup --> "
				+ e.getMessage();
			HisException eObj = new HisException("mms",
				"AdvanceRequestTransDATA->getPODetailsDup()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
				+ eObj.getErrorID() + "],Contact System Administrator! ");

		eObj = null;
		}finally{
			
		}

	}

public static void getBankDetailsDup(AdvanceRequestTransFB formBean,HttpServletRequest request) {
		
	////System.out.println("getBankDetailsDup--->");
	
		AdvanceRequestTransVO vo = null;
		AdvanceRequestTransBO bo = null;
		String strmsgText = "";
		
		String strBankDetailsDup = "";
				
		try {
			vo = new AdvanceRequestTransVO();
			bo = new AdvanceRequestTransBO();
			
			String strPONO = formBean.getPonovalue();
			
			String[] strTemp = strPONO.replace("^","#").split("#");
					
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrPONO(strTemp[0]);
			vo.setStrStoreId(formBean.getStrId());
			
			bo.getBankDetails(vo);
			
			
			strBankDetailsDup = AdvanceRequestTransHLP.getBankDetailsDup(vo.getStrBankDtlsWs());
			formBean.setStrBankDetailsValDup(strBankDetailsDup);
			
			
		}catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.AdvanceRequestTransDATA.getBankDetailsDup --> "
				+ e.getMessage();
			HisException eObj = new HisException("mms",
				"AdvanceRequestTransDATA->getBankDetailsDup()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
				+ eObj.getErrorID() + "],Contact System Administrator! ");

		eObj = null;
		}finally{
			
		}

	}
	
	
public static void getReqDetails(AdvanceRequestTransFB formBean,HttpServletRequest request) {
		
		AdvanceRequestTransVO vo = null;
		AdvanceRequestTransBO bo = null;
		String strmsgText = "";
		String strReqDetails = "";
				
		try {
			vo = new AdvanceRequestTransVO();
			bo = new AdvanceRequestTransBO();
			
//			String strPONO = request.getParameter("strPONo");
//			String strStrId = request.getParameter("strStoreId");
//			String strItemCatNo = request.getParameter("strItemCat");
			
			String strPONO = formBean.getPonovalue();
			String strStrId = formBean.getStrId();
			String strItemCatNo = formBean.getItemCategory();
			
	//		//System.out.println("ponoval----------->"+formBean.getPonovalue());
			
			String[] strTemp = strPONO.split("\\^");
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrPONoDup(strTemp[0]);
			vo.setStrItemCatDup(strItemCatNo);
			vo.setStrStrDup(strStrId);
			
			bo.getReqDetails(vo);
			
			
				strReqDetails = AdvanceRequestTransHLP.getReqDetails(vo.getStrReqDetailsWs());
				formBean.setStrReqDetailsVal(strReqDetails);
			
			
			
		}catch (Exception e) {
			strmsgText = "mms.transactions.AdvanceRequestTransDATA.getReqDetails --> "
				+ e.getMessage();
			HisException eObj = new HisException("mms",
				"AdvanceRequestTransDATA->getReqDetails()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
				+ eObj.getErrorID() + "],Contact System Administrator! ");

		eObj = null;
		}finally{
			
		}

	}

public static void getNewReqDetails(AdvanceRequestTransFB formBean,HttpServletRequest request) {
	
	AdvanceRequestTransVO vo = null;
	AdvanceRequestTransBO bo = null;
	String strmsgText = "";
	String strReqDetails = "";
			
	try {
		vo = new AdvanceRequestTransVO();
		bo = new AdvanceRequestTransBO();
		
//		String strPONO = request.getParameter("strPONo");
//		String strStrId = request.getParameter("strStoreId");
//		String strItemCatNo = request.getParameter("strItemCat");
		
		String strPONO = formBean.getPonovalue();
		String strStrId = formBean.getStrId();
		String strItemCatNo = formBean.getItemCategory();
		
		
		String[] strTemp = strPONO.split("\\^");
		
		vo.setStrHospitalCode(formBean.getStrHospitalCode());
		vo.setStrPONoDup(strTemp[0]);
		vo.setStrItemCatDup(strItemCatNo);
		vo.setStrStrDup(strStrId);
		
		bo.getReqDetails(vo);
		
		
			strReqDetails = AdvanceRequestTransHLP.getNewReqDetails(vo.getStrReqDetailsWs());
			formBean.setStrReqDetailsVal(strReqDetails);
		
		
		
	}catch (Exception e) {
		strmsgText = "mms.transactions.AdvanceRequestTransDATA.getReqDetails --> "
			+ e.getMessage();
		HisException eObj = new HisException("mms",
			"AdvanceRequestTransDATA->getReqDetails()", strmsgText);
		formBean.setStrErrMsg("Application Error [ERROR ID : "
			+ eObj.getErrorID() + "],Contact System Administrator! ");

	eObj = null;
	}finally{
		
	}

}



	public static  boolean insertNew(AdvanceRequestTransFB formBean, HttpServletRequest request,
				HttpServletResponse response)
	{
		AdvanceRequestTransVO vo = null;
		AdvanceRequestTransBO bo = null;
		String  strmsgText = "";
		boolean retValue = true;
		try
		{
			 vo=new AdvanceRequestTransVO();
			 bo=new AdvanceRequestTransBO();
			 
			String strNewStrId = formBean.getStrId();
			String strNewItemCatId = formBean.getItemCategory();
			String strNewPoNo = formBean.getPonovalue();
			
			if (strNewStrId == null)
				strNewStrId = "0";
			if (strNewItemCatId == null)
				strNewItemCatId = "0";
			if (strNewPoNo == null)
				strNewPoNo = "0";
			
			String[] temp = strNewPoNo.split("\\^");
					
		//	//System.out.println("temp------>"+strNewPoNo);
			
			vo.setStrPONO(temp[0]);
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrStoreId(strNewStrId);	
			vo.setStrPODate(formBean.getStrPODate());
			vo.setStrSuppId(formBean.getStrSuppId());
			vo.setStrItemCategoryId(strNewItemCatId);	
			vo.setStrCurrId(formBean.getStrCurrId());
			vo.setStrPOAmt(formBean.getStrPOAmt());
			vo.setStrAdvRequest(formBean.getStrAdvRequest());
			vo.setStrAdvStatus("1");
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrIsValid("1");
			vo.setStrPOStoreId(temp[3]);
			vo.setStrBankAccName(formBean.getStrBankAccName());
			vo.setStrBankAccNo(formBean.getStrBankAccNo());			
						
			bo.insertNew(vo);
			
			formBean.setStrRequestNumber(vo.getStrRequestNumber());
			
			if (vo.getStrMsgType().equals("1")) {
				retValue = false;
		//		//System.out.println("in if-->"+retValue);
				throw new Exception(vo.getStrMsgString());
				
				
			}else{
				
				retValue=showReport(formBean, request, response);
				////System.out.println("retValue in data class--"+retValue);
			}
		}
		catch(Exception e)
		{		
			e.printStackTrace();
		  	strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "AdvanceRequestTransDATA->insertNew()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;
		}
		return retValue;
	}
	
	public static boolean showReport(AdvanceRequestTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
		boolean retVal = true;
	//	String reportFormat = "pdf";
		////System.out.println("show report");
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			String reportPath = "/mms/reports/advRequest_mms.rptdesign";
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strReqNew = formBean.getStrRequestNumber();
			String strReqDup = formBean.getStrRadioVal();
		
			String strReportName = "Advance Request Letter";

			if(formBean.getStrChkAdvanceReq().equals("1")){
			//	//System.out.println("inside if--"+strReqNew);
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("hosp_Code", strHospitalCode);
				params.put("req_No", strReqNew);
				
			}else if(formBean.getStrChkAdvanceReq().equals("2")){
				////System.out.println("inside else--"+strReqDup);
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("hosp_Code", strHospitalCode);
				params.put("req_No", strReqDup);
			}
		
//			ts.displayReport(request, response, reportPath, "pdf",
//						params);
		      	
		} catch (Exception e) {
			retVal = false;
			e.printStackTrace();

		}return retVal;
	}
}
