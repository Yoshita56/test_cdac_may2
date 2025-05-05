package mms.transactions.controller.data;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import billing.BillConfigUtil;
import billing.PrintHLP;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import ipd.IpdConfigUtil;
import mms.MmsConfigUtil;
import mms.patDtl.PatientDtlHLP;
import mms.patDtl.PatientDtlHLPNew;
import mms.transactions.bo.OPDIssueToPatAutoTransBO;
import mms.transactions.controller.fb.OPDIssueToPatAutoTransFB;
import mms.transactions.controller.hlp.OPDIssueToPatAutoTransHLP;
import mms.transactions.vo.OPDIssueToPatAutoTransVO;

public class OPDIssueToPatAutoTransDATA 
{

//  private String   contents;
//   private String   rptContents;	
	/**
	 * This function used to set initial parameters for view Page.
	 * @param _OPDIssueToPatAutoTransFB
	 * @param request
	 */
	
	public static int printLine = 0;
	public static void getViewDtl(OPDIssueToPatAutoTransFB _OPDIssueToPatAutoTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   OPDIssueToPatAutoTransVO vo = null;
		   OPDIssueToPatAutoTransBO bo = null;
		   HisUtil util = null;
		   String strResult = "";
		   try
		   {
			    /* Creating Object */   	
			    vo=new OPDIssueToPatAutoTransVO();
			   	bo=new OPDIssueToPatAutoTransBO();
			   	util = new HisUtil("MMS Transactions", "OPDIssueToPatAutoTransDATA");
			   	/* Value set in Value Object */
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreName(request.getParameter("storeId"));
			   	vo.setStrItemCategoryNo(request.getParameter("itemCatNo"));
			   	vo.setStrCrNo(request.getParameter("crNo"));
			   //System.out.println("Flag==>"+request.getParameter("strFlagVal"));
			   	vo.setStrFlagVal(request.getParameter("strFlagVal"));
			   	if(request.getParameter("strFlagVal").equals("1"))
			   	{
			   		vo.setStrFromDate(util.getASDate("dd-MMM-yyyy"));
				   	vo.setStrToDate(util.getASDate("dd-MMM-yyyy"));
			   	}
			   	else
			   	{
			   		vo.setStrFromDate(request.getParameter("fromDate"));
				   	vo.setStrToDate(request.getParameter("ToDate"));
			   	}
               
               /* Calling BO method */
			    bo.setViewPageDtl(vo);
			    
			       strResult = OPDIssueToPatAutoTransHLP.getIssuedDetail(vo.getStrIssueDetailWs());

			    if(strResult!= null && !strResult.equals(""))
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult);
				 		 
				}
				else
				{
				    HisException eObj = new HisException("MMS", "OPDIssueToPatAutoTransDATA->getViewDtl()", vo.getStrMsgString());
					       String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "OPDIssueToPatAutoTransDATA->getViewDtl()", strmsgText);
				_OPDIssueToPatAutoTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//_OPDIssueToPatAutoTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   finally 
		   {
			    util = null;
				  bo = null;
				  vo = null;
			}
		   
	}
	
			
	public static void getStoreDtls(OPDIssueToPatAutoTransFB formBean, HttpServletRequest request) 
	{
		OPDIssueToPatAutoTransBO       bo = null;
		OPDIssueToPatAutoTransVO       vo = null;
		
		HisUtil          util = null;
		
		String    strStoreVal = "";
		String 	strCatVal="";
		String     strmsgText = null;
		ResourceBundle resObj = null;
		SimpleDateFormat  sdf = null;
		Calendar           c1 = null;
		
		try 
		{
			               bo = new OPDIssueToPatAutoTransBO();
			               vo = new OPDIssueToPatAutoTransVO();
			             util = new HisUtil("MMS Transactions", "IssueToPatTransDATA");			
			              sdf = new SimpleDateFormat("dd-MMM-yyyy");
		                   c1 = Calendar.getInstance();	    
		    c1.add(Calendar.DATE,0);   // or  Calendar.DAY_OF_MONTH which is a synonym
		    //System.out.println("Date + 1 days is : " + sdf.format(c1.getTime()));			
			
			//String strCtDate = util.getASDate("dd-MMM-yyyy");
			
			String strConfCatCode = MmsConfigUtil.STAFF_CAT_CODE;
			formBean.setStrConfCatCode(strConfCatCode);
			vo.setStrConfCatCode(strConfCatCode);
			formBean.setStrCtDate(sdf.format(c1.getTime()));
			
			System.out.println("------------------STRMODE------------------"+request.getParameter("mode"));
			
			if(request.getParameter("mode") != null){
				String strMode = request.getParameter("mode");
				formBean.setStrMode(strMode);
				System.out.println("------------------STRMODE------------------"+strMode);
			}
			
			vo.setStrMode(formBean.getStrMode());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());

			// Calling Bo Method
			bo.getStoreDtls(vo); 
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
		
			if(vo.getStrStoreWs()!=null && vo.getStrStoreWs().size()>0)
			{
				while(vo.getStrStoreWs().next())
				{
					vo.setStrStoreId(vo.getStrStoreWs().getString(1));
				}
			}
			
			vo.getStrStoreWs().beforeFirst();
			
			System.out.println(" ----XX--- formBean.getStrStoreId()-- "+formBean.getStrStoreId());
			if(vo.getStrStoreWs()!=null && vo.getStrStoreWs().size()>0)
			{
				if((formBean.getStrStoreId()==null||formBean.getStrStoreId().equals("")))
				{
					strStoreVal = util.getOptionValue(vo.getStrStoreWs(),"","", false);
				}
				else
				{	
				    strStoreVal = util.getOptionValue(vo.getStrStoreWs(),formBean.getStrStoreId(),"0^Select Value", false);
				}
				
				//strStoreVal = util.getOptionValue(vo.getStrStoreWs(),formBean.getStrStoreId(),"0^Select Value", false);
			}
			else
			{
				strStoreVal = "<option value='0'>Select Value</option>";
			}
			
						
			formBean.setStrStoreValues(strStoreVal);			
			
			vo.setStrReqTypeId("32");
			
			
			strCatVal = "<option value='0'>Select Value</option>";
			
			formBean.setStrCatValues(strCatVal);	
			formBean.setStrOfflineOPDFlag(vo.getStrOfflineOPDFlag());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.OPDIssueToPatAutoTransDATA.getStoreDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"OPDIssueToPatAutoTransDATA->getStoreDtls()", strmsgText);
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
			
			resObj = null;
			sdf = null;
			c1 = null;
		}
	}		
	public static void getStoreDtlsView(OPDIssueToPatAutoTransFB formBean, HttpServletRequest request) {

		OPDIssueToPatAutoTransBO bo       = null;
		OPDIssueToPatAutoTransVO vo       = null;
		HisUtil util          = null;
		String strStoreVal    = "";
	
		String strmsgText     = null;
		/* C OUT RJ47
		 * ResourceBundle resObj = null; SimpleDateFormat sdf = null; Calendar c1 =
		 * null; String strConfCatCode = "";
		 */
		
		try 
		{
           bo = new OPDIssueToPatAutoTransBO();
           vo = new OPDIssueToPatAutoTransVO();
         util = new HisUtil("MMS Transactions", "OPDIssueToPatAutoTransDATA");	
         
			
			
			if(request.getParameter("mode") != null)
			{
				String strMode = request.getParameter("mode");
				formBean.setStrMode(strMode);
			}
			
			vo.setStrMode(formBean.getStrMode());
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			// Calling Bo Method
			
			/* ==For View Page== */
			bo.getStoreDtlsView(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
		
			if(vo.getStrStoreWs()!=null && vo.getStrStoreWs().size()>0)
			{
				/*
				if(vo.getStrStoreWs().next())
				{
					vo.setStrStoreId(vo.getStrStoreWs().getString(1));
					vo.getStrStoreWs().beforeFirst();
				}
				*/
				strStoreVal = util.getOptionValue(vo.getStrStoreWs(), "","", false);
			}
			else
			{
				strStoreVal = "<option value='0'>Select Value</option>";
			}
						
			formBean.setStrStoreValues(strStoreVal);            			
			// Calling Bo Method
			
			/* ==For View Page== */
			bo.getItemCatDtls1(vo);
			

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			String temp = "";

			if (vo.getStrItemCatWs().size() != 0) {
				
				temp = util.getOptionValue(vo.getStrItemCatWs(), "", "0^Select Value",false);

			}else{
				
				temp = "<option value='0'>Select Value</option>";
			}

			formBean.setStrCatValues(temp);
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.OPDIssueToPatAutoTransDATA.getStoreDtlsView --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"OPDIssueToPatAutoTransDATA->getStoreDtlsView()", strmsgText);
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
			/*C OUT RJ47
			 * resObj = null; sdf = null; c1 = null;
			 */
		}
	}
	
	public static void getGroupDetails(OPDIssueToPatAutoTransFB formBean, HttpServletRequest request) {

		OPDIssueToPatAutoTransBO bo = null;
		OPDIssueToPatAutoTransVO vo = null;

		HisUtil util = null;
		String strGroupVal = "";
		String strmsgText = null;
		
		try {
			bo = new OPDIssueToPatAutoTransBO();
			vo = new OPDIssueToPatAutoTransVO();
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrItemCat(formBean.getItemCategory());
			
			bo.getStoreGroupDtls(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "OPDIssueToPatAutoTransDATA");
			
			strGroupVal = util.getOptionValue(vo.getStrGroupWs(), "0",
					"0^Select Value", false);
						
			formBean.setStrGroupValues(strGroupVal);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.OPDIssueToPatAutoTransDATA.getGroupDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"OPDIssueToPatAutoTransDATA->getGroupDetails()", strmsgText);
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
	
	public static void getItemCatDtls(OPDIssueToPatAutoTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		OPDIssueToPatAutoTransBO bo = null;
		OPDIssueToPatAutoTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new OPDIssueToPatAutoTransBO();
			voObj = new OPDIssueToPatAutoTransVO();
			
			String strStoreId = request.getParameter("storeId");
			String strModeVal = request.getParameter("modeVal");
			
			if (strStoreId == null)
				strStoreId = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			if(strModeVal.equals("0")){
				voObj.setStrReqTypeId("32");
				
			}else if(strModeVal.equals("1")){
				voObj.setStrReqTypeId("33");
				
			}else if(strModeVal.equals("2")){
				voObj.setStrReqTypeId("32");
			}
			
			bo.getItemCatDtls(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "OPDIssueToPatAutoTransDATA");
			String temp = "<option value='0'>Select Value</option>";

			if (voObj.getStrItemCatWs().size() != 0) {
				
				//temp = util.getOptionValue(voObj.getStrItemCatWs(), "10", "0^Select Value",true);
				temp = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^Select Value",true);


			}else{
				
				temp = "<option value='0'>Select Value</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.OPDIssueToPatAutoTransDATA.getItemCatDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"OPDIssueToPatAutoTransDATA->getItemCatDtls()", strmsgText);
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
	
	public static void GET_PAT_ACC_STATUS(OPDIssueToPatAutoTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) 
	{

		OPDIssueToPatAutoTransBO bo = null;
		OPDIssueToPatAutoTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		String temp = "";
		try {

			bo = new OPDIssueToPatAutoTransBO();
			voObj = new OPDIssueToPatAutoTransVO();
			
			String strStoreId = request.getParameter("strId");
			String strCrNo    = request.getParameter("crNo");
			if (strStoreId == null)
				strStoreId = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrCrNo(strCrNo);
						
			bo.GET_PAT_ACC_STATUS(voObj);

			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());

			}
			if(voObj.getStrAccDtl().next() && voObj.getStrAccDtl().size() > 0)
			{
				/*
	                0 -  Ac Balance
	                1 -  Patient Catg Code
	                2 -  ADMISSION_DATE
	                3 -  DISCHARGE_DATE
	                4 -  PATACCOUNT_STATUS in Text
	                5 -  HBLNUM_PATACCOUNT_STATUS 
	                6 -  GETCATGRP
	                7 -  HBLNUM_ACCOUNT_TYPE
	                8 -  hblnum_finalbill_flag
	            */
				 temp = voObj.getStrAccDtl().getString(1);
				
			}
			else
			{
				temp = "0@0@0@0@0@0@0@0@0@0";
			}
			
						
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.OPDIssueToPatAutoTransDATA.GET_PAT_ACC_STATUS --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"OPDIssueToPatAutoTransDATA->GET_PAT_ACC_STATUS()", strmsgText);
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
	public static int getissuetopatientcount(OPDIssueToPatAutoTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		OPDIssueToPatAutoTransBO bo = null;
		OPDIssueToPatAutoTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		int temp =0;
		try {

			bo = new OPDIssueToPatAutoTransBO();
			voObj = new OPDIssueToPatAutoTransVO();
			
			voObj.setStrStoreId(formBean.getStrStoreId());
			voObj.setStrItemCat(formBean.getItemCategory());
			voObj.setStrCrNo(formBean.getStrCrNo());
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			
			bo.issueTopatientCount(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "OPDIssueToPatAutoTransDATA");
			

			if (voObj.getWsissuetopatcount().size() != 0) {
				WebRowSet wb=voObj.getWsissuetopatcount();
				 while(wb.next())
				 {
					 temp=Integer.parseInt(wb.getString(1));
				 }

			}else{
				
				temp=0;
			}

			

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.OPDIssueToPatAutoTransDATA.getItemCatDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"OPDIssueToPatAutoTransDATA->getItemCatDtls()", strmsgText);
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
		return temp;
	}
	
	public static void getPatientDetails(OPDIssueToPatAutoTransFB formBean, HttpServletRequest request, 
						HttpServletResponse response) {

		OPDIssueToPatAutoTransBO bo = null;
		OPDIssueToPatAutoTransVO vo = null;
		MmsConfigUtil mcu = null;
		HisUtil util = null;
		String strmsgText = null;
		ResourceBundle resObj =  null;
		
		try 
		{
			System.out.println("------------- OPDIssueToPatAutoTransDATA . getPatientDetails ---------------");
			
			     bo = new OPDIssueToPatAutoTransBO();
			     vo = new OPDIssueToPatAutoTransVO();
			    mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   util = new HisUtil("","");
			
			formBean.setStrCtDate(util.getASDate("dd-MMM-yyyy"));
			String strIssueMode = mcu.getStrIssueMode();
			formBean.setStrIssueMode("0");  // Please Check			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrStoreId(formBean.getStrStoreId());
			
			vo.setStrCrNo(formBean.getStrCrNo());
			
											
			System.out.println("------B------- mms.patDtl.PatientDtlHLP.patientTreatmentDtl_OPD ---------------");	
		
			//String strPatientTreatmentDtl =  PatientDtlHLP.patientTreatmentDtl_Selection(formBean.getStrCrNo(), formBean.getStrHospitalCode());
		
			String strPatientTreatmentDtl =  PatientDtlHLP.patientTreatmentDtl_OPD(formBean.getStrCrNo(), formBean.getStrHospitalCode());
			
			//System.out.println("strPatientTreatmentDtl--------------"+strPatientTreatmentDtl);

			System.out.println("------D------- OPDIssueToPatAutoTransDATA.patientDiagDtl ---------------");
			
			String strPatientDiagDetails = patientDiagDtl(formBean.getStrCrNo(), formBean.getStrHospitalCode());			
			
			formBean.setStrPatientTreatmentDtl(strPatientTreatmentDtl);
			//formBean.setStrPatientTreatmentDtl_BS(strPatientTreatmentDtl_BS);
			formBean.setStrPatientDiagDetails(strPatientDiagDetails);
			//bo.getLFAccountDetail(vo);
			
			bo.getPatientTreatmentHLPForIssue(vo);  // PKG_MMS_VIEW2.PROC_HRGT_PATIENT_TREATMENT_DTL [ Mode - 6 ]
			
			String strIpdIssueDrugHLP =  OPDIssueToPatAutoTransHLP.getItemDetails_Drug(vo.getStrItemCat(), vo.getStrHospitalCode(), vo.getTreatmentDtlHLPWs(), "0","0",vo.getStrStoreId());
			
			formBean.setStrIpdIssueDrugHLP(strIpdIssueDrugHLP);
			
			System.out.println("------------- OPDIssueToPatAutoTransDATA . getPatientDetails ------- END --------");
			
			formBean.setStrDoseFrqFlg("0");
		
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
					
		} catch (Exception e) 
		{
			e.printStackTrace();
			
			System.out.println("---e.getMessage()-----"+e.getMessage());
			
			
			if(e.getMessage().equals("Invalid CR No"))
			{
				System.out.println("--A-IN OUT-----");
				
				formBean.setStrErrMsg("Invalid CR. No./ Data Not Found");
				formBean.setStrInvalidCrFlag(vo.getStrInvalidCrFlag());	
				formBean.setStrCrNo(formBean.getStrHospitalCode());
					
			}			
			else if(e.getMessage().equals("Invalid CR. No."))
			{
				formBean.setStrErrMsg("Invalid CR. No. [ "+formBean.getStrCrNo()+" ]");
				formBean.setStrInvalidLFFlag("1");
			}
			else
			{
				strmsgText = "mms.transactions.OPDIssueToPatAutoTransDATA.getPatientDetails --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"OPDIssueToPatAutoTransDATA->getPatientDetails()", strmsgText);
				formBean.setStrErrMsg("Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");
	
				eObj = null;
			}
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
			
			if (mcu != null)
				mcu = null;
			
			if (resObj != null)
				resObj = null;
			
		}
	}
	
	public static void getPatientStatus(OPDIssueToPatAutoTransFB formBean, HttpServletRequest request, 
			HttpServletResponse response) 
	{

			OPDIssueToPatAutoTransBO bo = null;
			OPDIssueToPatAutoTransVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
			ResourceBundle resObj =  null;
			
			try 
			{
			System.out.println("------------- OPDIssueToPatAutoTransDATA . getPatientDetails ---------------");
			
			     bo = new OPDIssueToPatAutoTransBO();
			     vo = new OPDIssueToPatAutoTransVO();
			    mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   util = new HisUtil("","");
			
			formBean.setStrCtDate(util.getASDate("dd-MMM-yyyy"));
			String strIssueMode = mcu.getStrIssueMode();
			formBean.setStrIssueMode("0");  // Please Check			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			vo.setStrCrNo(formBean.getStrCrNo());
			
			bo.getPatientCRStatus(vo);
			
			formBean.setStrInvalidCrFlag(vo.getStrInvalidCrFlag());
			
					
			
			System.out.println("------------- OPDIssueToPatAutoTransDATA . getPatientStatus ------- END --------");
			
			formBean.setStrDoseFrqFlg("0");
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
					
			}
			catch (Exception e) 
			{
			e.printStackTrace();
			
			System.out.println("---e.getMessage()-----"+e.getMessage());
			
				strmsgText = "mms.transactions.OPDIssueToPatAutoTransDATA.getPatientDetails --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"OPDIssueToPatAutoTransDATA->getPatientDetails()", strmsgText);
				formBean.setStrErrMsg("Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");
			
				eObj = null;
			
			}
			
			 finally {
			
			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
			
			if (mcu != null)
				mcu = null;
			
			if (resObj != null)
				resObj = null;
			
			}
}
	
	

   /*
	
	public static void getOnlineReqDtl(OPDIssueToPatAutoTransFB formBean, HttpServletRequest request, HttpServletResponse response) 
	{

			OPDIssueToPatAutoTransBO bo = null;
			OPDIssueToPatAutoTransVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
		
		try 
		{
			 System.out.println(" ------- OPDIssueToPatAutoTransDATA.getOnlineReqDtl  ------- ");
			 
				bo = new OPDIssueToPatAutoTransBO();
				vo = new OPDIssueToPatAutoTransVO();
				mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				
				String strIssueMode = mcu.getStrIssueMode();
				formBean.setStrIssueMode(strIssueMode);
				
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				vo.setStrCrNumber(formBean.getCrNo());
				
				String strOnlineIssueReqDays = mcu.getStrOnlineIssueDetailsInDays();
				vo.setStrOnlineIssueReqDays(strOnlineIssueReqDays);
				
				bo.getRequestDtls(vo);
				
				System.out.println("getStrBillingHiddenValue-----"+vo.getStrBillingHiddenValue());				
									
				String strReqValues = OPDIssueToPatAutoTransHLP.getRequestDtls(vo.getStrRequestWs());
				formBean.setStrReqValues(strReqValues);
				formBean.setStrBillingHiddenValue(vo.getStrBillingHiddenValue());
		if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
				
		} catch (Exception e) {
				strmsgText = "mms.transactions.OPDIssueToPatAutoTransDATA.getOnlineReqDtl --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"OPDIssueToPatAutoTransDATA->getOnlineReqDtl()", strmsgText);
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
		*/
	
	public static void getItemDetails(OPDIssueToPatAutoTransFB formBean, HttpServletRequest request, 
			HttpServletResponse response ) {

		OPDIssueToPatAutoTransBO bo = null;
		OPDIssueToPatAutoTransVO vo = null;
		MmsConfigUtil mcu = null;
		HisUtil util = null;
		String strmsgText = null;
		String strItemDetails ="";
		
		try {
			
			 System.out.println(" ------- OPDIssueToPatAutoTransDATA.getItemDetails  ------- ");
			 
			bo = new OPDIssueToPatAutoTransBO();
			vo = new OPDIssueToPatAutoTransVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			String strIssueMode = mcu.getStrIssueMode();
			formBean.setStrIssueMode(strIssueMode);
						
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrRequestNo(request.getParameter("reqNo"));
			vo.setStrCrNumber(request.getParameter("crNo"));
			vo.setStrStoreId(request.getParameter("strId"));		
			
			bo.getItemDetails(vo);
			
			strItemDetails = OPDIssueToPatAutoTransHLP.getItemDetails(vo.getStrHospitalCode(),vo.getStrItemDetailWs());
			
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strItemDetails);	
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
				
		} catch (Exception e) {
			strmsgText = "mms.transactions.OPDIssueToPatAutoTransDATA.getItemDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"OPDIssueToPatAutoTransDATA->getItemDetails()", strmsgText);
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
	
	public static void getIssuePopUp(OPDIssueToPatAutoTransFB formBean, HttpServletRequest request, 
						HttpServletResponse response) {
			
			OPDIssueToPatAutoTransBO bo    = null;
			OPDIssueToPatAutoTransVO vo    = null;			
			
			String strmsgText  = null;			
			String strStoreId  = "";
			String strIssueNo  = "";
			String strHospCode = "";
			String strPopUp    = "";
			String strCrNo    = "";
			try 
			{
				 System.out.println(" ------- OPDIssueToPatAutoTransDATA.getIssuePopUp  ------- ");
				 
				   bo = new OPDIssueToPatAutoTransBO();
				   vo = new OPDIssueToPatAutoTransVO();							
				   strHospCode = formBean.getStrHospitalCode();
				   strStoreId = formBean.getStrStoreId();
				   strIssueNo = formBean.getStrIssueNum();
				   strCrNo   = formBean.getStrCrNo();
				   
				 System.out.println(" strHospCode-----------------------"+strHospCode);
				 System.out.println(" strStoreId-----------------------"+strStoreId);
				 System.out.println(" strIssueNo-----------------------"+strIssueNo);

				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
				
				OPDIssueToPatAutoTransHLP.getIssuePopUpForDotMatrix(strHospCode,strStoreId,strIssueNo,strCrNo,request);												
				String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
				formBean.setStrPrintBill(fileName);
				request.setAttribute("filePath", fileName);
				formBean.setIsOpenPopUp("1");
				
							
			} catch (Exception e) {
				strmsgText = "mms.transactions.OPDIssueToPatAutoTransDATA.getIssuePopUp --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"OPDIssueToPatAutoTransDATA->getIssuePopUp()", strmsgText);
				formBean.setStrErrMsg("Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");
			
				eObj = null;
			} finally {
			
				if (bo != null)
					bo = null;
				if (vo != null)
					vo = null;
				
			}
		}
	
	public static void getIssuePopUp_ORG(OPDIssueToPatAutoTransFB formBean, HttpServletRequest request, 
			HttpServletResponse response) {

		OPDIssueToPatAutoTransBO bo    = null;
		OPDIssueToPatAutoTransVO vo    = null;			
		
		String strmsgText  = null;			
		String strStoreId  = "";
		String strIssueNo  = "";
		String strHospCode = "";
		String strPopUp    = "";
		String strCrNo    = "";
		try 
		{
			 System.out.println(" ------- OPDIssueToPatAutoTransDATA.getIssuePopUp  ------- ");
			 
			   bo = new OPDIssueToPatAutoTransBO();
			   vo = new OPDIssueToPatAutoTransVO();							
			   strHospCode = formBean.getStrHospitalCode();
			   strStoreId = request.getParameter("strId");
			   strIssueNo = request.getParameter("issueNo");
			   strCrNo   = request.getParameter("strCrNo");
			   
			 System.out.println(" strHospCode-----------------------"+strHospCode);
			 System.out.println(" strStoreId-----------------------"+strStoreId);
			 System.out.println(" strIssueNo-----------------------"+strIssueNo);
		
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			/*
			strPopUp = OPDIssueToPatAutoTransHLP.getIssuePopUpBS(strHospCode,strStoreId,strIssueNo,strCrNo);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strPopUp);	
			*/
			
			OPDIssueToPatAutoTransHLP.getIssuePopUpForDotMatrix(strHospCode,strStoreId,strIssueNo,strCrNo,request);												
			String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
			formBean.setStrPrintBill(fileName);
			request.setAttribute("filePath", fileName);
			formBean.setIsOpenPopUp("1");
			
						
		} catch (Exception e) {
			strmsgText = "mms.transactions.OPDIssueToPatAutoTransDATA.getIssuePopUp --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"OPDIssueToPatAutoTransDATA->getIssuePopUp()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
		
			eObj = null;
		} finally {
		
			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			
		}
    }
	
	public static void getIssueDetails(OPDIssueToPatAutoTransFB formBean, HttpServletRequest request, HttpServletResponse response)
		{
			
			OPDIssueToPatAutoTransBO bo = null;
			OPDIssueToPatAutoTransVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
			WebRowSet ws = null;
			try {
				 System.out.println(" ------- OPDIssueToPatAutoTransDATA.getIssueDetails  ------- ");
				 
				bo = new OPDIssueToPatAutoTransBO();
				vo = new OPDIssueToPatAutoTransVO();
				mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				
				vo.setStrStoreId(request.getParameter("strId"));
				//vo.setStrCatCode(request.getParameter("itemCategory"));
				
				vo.setStrCrNum(request.getParameter("crNo"));
				//System.out.println(">>>>>>>>>>>>>>>>>>"+request.getParameter("crNo"));

				vo.setStrFromDate(request.getParameter("fromDate"));
			   	vo.setStrToDate(request.getParameter("ToDate"));
				
				vo.setStrIssueNo(request.getParameter("strIssueNo"));
				vo.setStrPrescribedBy(request.getParameter("prescribedBy"));				
				vo.setStrPatStaffDays(mcu.getStrLastIssuePatientStaffInDays());		
				
				
			   	
				// Calling BO Method --issue no issue date & store id 
				bo.getIssueDetail(vo);
				  
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}
				
				ws = vo.getStrIssueDetailWs(); 
			/*	while(ws.next())
				{
					System.out.println("ws.strings()"+ws.getString(1));
					System.out.println("ws.strings()"+ws.getString(2));
				//	System.out.println("ws.strings()"+ws.getString(3));
					
				}*/
			
				/* replace HLP method  getIssueDetailsBS >> getPreviousIssueDetails*/
			    String strIssueDetails = OPDIssueToPatAutoTransHLP.getPreviousIssueDetails(vo,ws);
				
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strIssueDetails);
				
			} catch (Exception e) {
				strmsgText = "mms.transactions.OPDIssueToPatAutoTransDATA.getIssueDetails --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"OPDIssueToPatAutoTransDATA->getIssueDetails()", strmsgText);
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
	
	public static void getRequestDetails(OPDIssueToPatAutoTransFB formBean, HttpServletRequest request, HttpServletResponse response) {

		OPDIssueToPatAutoTransBO bo = null;
		OPDIssueToPatAutoTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		WebRowSet ws = null;
		MmsConfigUtil mcu = null;
		
		try {
			 System.out.println(" ------- OPDIssueToPatAutoTransDATA.getRequestDetails  ------- ");
			 
			bo = new OPDIssueToPatAutoTransBO();
			vo = new OPDIssueToPatAutoTransVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrRequestNo(request.getParameter("reqNo"));
			vo.setStrCrNumber(request.getParameter("crNo"));
			
			String strOnlineIssueReqDays = mcu.getStrOnlineIssueDetailsInDays();
			vo.setStrOnlineIssueReqDays(strOnlineIssueReqDays);
			
		//	//System.out.println("1-----"+vo.getStrOnlineIssueReqDays());
		//	//System.out.println("2-----"+vo.getStrRequestNo());
		//	//System.out.println("3----"+vo.getStrCrNumber());
			
			bo.getRequestDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
				
			ws = vo.getStrRequestDetailWs();
			
			String strRequestDetails=OPDIssueToPatAutoTransHLP.getRequestDetails(ws);
			
			////System.out.println("strRequestDetails---------->"+strRequestDetails);
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strRequestDetails);
						
		} catch (Exception e) {
			strmsgText = "mms.transactions.OPDIssueToPatAutoTransDATA.getRequestDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"OPDIssueToPatAutoTransDATA->getRequestDetails()", strmsgText);
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
	/*
	public static void getFrequencyDetails(OPDIssueToPatAutoTransFB formBean, HttpServletRequest request) {

		OPDIssueToPatAutoTransBO bo = null;
		OPDIssueToPatAutoTransVO vo = null;

		HisUtil util = null;
		String strFrequencyVal = "";
		String strmsgText = null;
		
		try {
			bo = new OPDIssueToPatAutoTransBO();
			vo = new OPDIssueToPatAutoTransVO();
			util = new HisUtil("MMS Transactions", "OPDIssueToPatAutoTransDATA");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
						
			bo.getFrequencyDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "OPDIssueToPatAutoTransDATA");
			
			strFrequencyVal = util.getOptionValue(vo.getStrFrequencyWs(), "0",
					"0^Select Value", false);
						
			formBean.setStrFrequencyValues(strFrequencyVal);
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.OPDIssueToPatAutoTransDATA.getFrequencyDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"OPDIssueToPatAutoTransDATA->getFrequencyDetails()", strmsgText);
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
	*/
	/*
	public static void getDoseDetails(OPDIssueToPatAutoTransFB formBean, HttpServletRequest request) {

		OPDIssueToPatAutoTransBO bo = null;
		OPDIssueToPatAutoTransVO vo = null;

		HisUtil util = null;
		String strDosageVal = "";
		String strmsgText = null;
		
		try {
			bo = new OPDIssueToPatAutoTransBO();
			vo = new OPDIssueToPatAutoTransVO();
			util = new HisUtil("MMS Transactions", "OPDIssueToPatAutoTransDATA");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
						
			bo.getDoseDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "OPDIssueToPatAutoTransDATA");
			
			strDosageVal = util.getOptionValue(vo.getStrDosageWs(), "0",
					"0^Select Value", false);
			formBean.setStrDosageValues(strDosageVal);
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.OPDIssueToPatAutoTransDATA.getDoseDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"OPDIssueToPatAutoTransDATA->getDoseDetails()", strmsgText);
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
	*/
	
	public static void getDeptDetails(OPDIssueToPatAutoTransFB formBean, HttpServletRequest request) {

		OPDIssueToPatAutoTransBO bo = null;
		OPDIssueToPatAutoTransVO vo = null;

		HisUtil util = null;
		String strDeptVal = "";
		String strmsgText = null;
		
		try {
			 System.out.println(" ------- OPDIssueToPatAutoTransDATA.getDeptDetails  ------- ");
			 
			bo = new OPDIssueToPatAutoTransBO();
			vo = new OPDIssueToPatAutoTransVO();
			util = new HisUtil("MMS Transactions", "OPDIssueToPatAutoTransDATA");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.getDeptDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "OPDIssueToPatAutoTransDATA");
			
			strDeptVal = util.getOptionValue(vo.getStrDepartmentWs(), "","0^Select Value", false);
						
			formBean.setStrDeptValues(strDeptVal);
			formBean.setStrCtDate(util.getASDate("dd-MMM-yyyy"));
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.OPDIssueToPatAutoTransDATA.getDeptDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"OPDIssueToPatAutoTransDATA->getDeptDetails()", strmsgText);
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
	
	public static void getUnitDetails(OPDIssueToPatAutoTransFB formBean, HttpServletRequest request, HttpServletResponse response) {

		OPDIssueToPatAutoTransBO bo = null;
		OPDIssueToPatAutoTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		
		try {
			bo = new OPDIssueToPatAutoTransBO();
			vo = new OPDIssueToPatAutoTransVO();
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			vo.setStrDeptCode(request.getParameter("deptCode"));
			
			
			bo.getUnitDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "OPDIssueToPatAutoTransDATA");
			String temp = "<option value='0'>SelectValue</option>";

			if (vo.getStrUnitWs().size() != 0) {
				
				temp = util.getOptionValue(vo.getStrUnitWs(), "", "0^select Value",
						true);

			}else{
				
				temp = "<option value='0'>SelectValue</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);
			
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.OPDIssueToPatAutoTransDATA.getUnitDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"OPDIssueToPatAutoTransDATA->getUnitDetails()", strmsgText);
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
	
	
	public static void getPrescribedBy(OPDIssueToPatAutoTransFB formBean, HttpServletRequest request, HttpServletResponse response) {

		OPDIssueToPatAutoTransBO bo = null;
		OPDIssueToPatAutoTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		
		try {
			bo = new OPDIssueToPatAutoTransBO();
			vo = new OPDIssueToPatAutoTransVO();

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrUnitCode(request.getParameter("unitCode"));
//	System.out.println("vo.getStrUnitCode"+vo.getStrUnitCode());		
			bo.getPrescribedBy(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "OPDIssueToPatAutoTransDATA");
			String temp = "<option value='0'>SelectValue</option>";

			if (vo.getStrConsultantWs().size() != 0) {
				
				temp = util.getOptionValue(vo.getStrConsultantWs(), "0", "0^Select Value",
						true);

			}else{
				
				temp = "<option value='0'>SelectValue</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.OPDIssueToPatAutoTransDATA.getPrescribedBy --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"OPDIssueToPatAutoTransDATA->getPrescribedBy()", strmsgText);
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
			

	public static void getGenderCombo(OPDIssueToPatAutoTransFB formBean,HttpServletRequest request) 
	{
		OPDIssueToPatAutoTransBO bo = null;
		OPDIssueToPatAutoTransVO vo = null;

		HisUtil util = null;
		String strPatientGenderCodeCmbValues = "";
		String strmsgText = null;
		
		try {
			bo = new OPDIssueToPatAutoTransBO();
			vo = new OPDIssueToPatAutoTransVO();
			util = new HisUtil("MMS Transactions", "OPDIssueToPatAutoTransDATA");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.getGenderCombo(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "OPDIssueToPatAutoTransDATA");
			
			strPatientGenderCodeCmbValues = util.getOptionValue(vo.getStrGenderWs(), "",	"", false);
						
			formBean.setStrPatientGenderCodeCmbValues(strPatientGenderCodeCmbValues);
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.OPDIssueToPatAutoTransDATA.getDeptDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",	"OPDIssueToPatAutoTransDATA->getGenderCombo()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

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
	
	
	public static String patientDiagDtl(String strCrNo,String strHospitalCode)
	{
		OPDIssueToPatAutoTransBO bo = new OPDIssueToPatAutoTransBO();
		OPDIssueToPatAutoTransVO vo	= new OPDIssueToPatAutoTransVO();
		HisUtil util =  new HisUtil("MMS Transactions", "OPDIssueToPatAutoTransDATA");	;
			StringBuffer sb = new StringBuffer("");
			vo.setStrCrNo(strCrNo);
			vo.setStrHospitalCode(strHospitalCode);
			
			WebRowSet ws = null;
			String diagName;
			
			sb.append("");
			
			try 
			{
				 System.out.println(" ------- OPDIssueToPatAutoTransDATA.patientDiagDtl  ------- ");
				 
				bo.getPatientDiagDetails(vo);
				
				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
			
				ws = vo.getDiagEmpWs();
				
				sb.append("<table class='table'>");
				sb.append("<thead>");
				sb.append("<tr>");							
				sb.append("<th align='center' style='width:50%;text-align: center !important;'><b>Diagnosis Name(Code)</b></th>");			
				sb.append("<th align='center' style='width:50%;text-align: center !important;'><b>Treatment Consultant</b></th>");
				sb.append("</tr>");
				sb.append("</thead>");			
			
				if (ws != null && ws.size() > 0) 
				{
					
					while (ws.next()) 
					{
						diagName = ws.getString(1);
						String diagCode = ws.getString(2);
						String empName = ws.getString(3);
						String empcode = ws.getString(4);
								
						if (diagName == null)
							diagName = "----";
						if (empName == null)
							empName = "----";
						if (empcode == null)
							empcode = "----";
						
						sb.append("<tbody>");	
						sb.append("<tr>");
						sb.append("<td   style='width:50%;font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;'>");
						sb.append(diagName+"(<b>"+diagCode+")");
						sb.append("</td>");
						
						sb.append("<td   style='width:50%;font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;'>");
						sb.append(empName);
						sb.append("<input type='hidden' name='strDiagCode' value='"+ diagCode + "'><input type='hidden' name='strEmpCode' value='"+ empcode + "'></div>");
						sb.append("</td>");												
					}
					
				}
				else
				{
					bo.getIcdList(vo);
					diagName = util.getOptionValue(vo.getDiagMstWs(), "0^Select Value", "Select Value", false);
					String empName = util.getOptionValue(vo.getEmpWs(), "0^Select Value", "Select Value", false);
					
					sb.append("<tbody>");	
					sb.append("<tr>");
					
					sb.append("<td style='width:50%;font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;'><div align='center'><select name ='strDiagCode'  class='comboMax' onchange='' name=strDiagName >"+ diagName +"</select></div>");
					sb.append("</td>");
					sb.append("<td style='width:50%;font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;'><div align='center'><select name='strEmpCode' class='comboMax' onchange='' name=strDiagName >"+ empName +"</select></div>");
					sb.append("</td>");
					sb.append("</tr>");
				}
				sb.append("</table>");
			} 
			catch (Exception e) 
			{
				try {
					throw new Exception("RequestforLPPAtientDATA-->patientDtl-->"	+ e.getMessage());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} 
			finally 
			{
				if (ws != null) 
				{
					try 
					{
						ws.close();
					} 
					catch (SQLException e) 
					{
					    e.printStackTrace();
					}
					ws = null;
				}
			}
	       return sb.toString();
	}


	
	
	
	public static void getOnlineTreatmentDtl(OPDIssueToPatAutoTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{
	
			OPDIssueToPatAutoTransBO bo = null;
			OPDIssueToPatAutoTransVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
		
		try 
		{
			    System.out.println(" ------- OPDIssueToPatAutoTransDATA.getOnlineTreatmentDtl  ------- ");
				bo = new OPDIssueToPatAutoTransBO();
				vo = new OPDIssueToPatAutoTransVO();
				mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				
				String strIssueMode = mcu.getStrIssueMode();
				formBean.setStrIssueMode(strIssueMode);
				
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				//vo.setStrCrNumber(formBean.getStrCrNo());
				
				formBean.setStrStoreId(request.getParameter("storeId"));
				formBean.setStrCrNo(request.getParameter("strCrNum"));
				formBean.setStrEpisodeCode(request.getParameter("episodeDtl"));
				formBean.setStrDeptCode(request.getParameter("deptID"));
				formBean.setStrUnitCode(request.getParameter("strDeptUnit"));
				
				String strOnlineIssueReqDays = mcu.getStrOnlineIssueDetailsInDays();
				vo.setStrOnlineIssueReqDays(strOnlineIssueReqDays);
				
				bo.getTreamentDtls(formBean,vo);
				int  rowcount=vo.getOnlineTreatmentDtlsWs().size();		
				String strReqValues = OPDIssueToPatAutoTransHLP.getOnlineTreatmentDtls(vo.getOnlineTreatmentDtlsWs() , formBean);
				formBean.setStrOnlineTreatment(strReqValues);
				
				
				
				formBean.setStrRowCount(String.valueOf(rowcount));
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strReqValues + "##" + String.valueOf(rowcount)+"##");
				
		if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
				
		} catch (Exception e) {
				e.printStackTrace();
				strmsgText = "mms.transactions.OPDIssueToPatAutoTransDATA.getOnlineReqDtl --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"OPDIssueToPatAutoTransDATA->getOnlineReqDtl()", strmsgText);
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
	
	public static void getBilledItemDtls(OPDIssueToPatAutoTransFB _OPDIssueToPatAutoTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	      String strmsgText = "";
		   OPDIssueToPatAutoTransVO vo = null;
		   OPDIssueToPatAutoTransBO bo = null;
		   HisUtil util = null;
		   String strResult = "";
		   try
		   {
			   System.out.println(" ------- OPDIssueToPatAutoTransDATA.getBilledItemDtls  ------- ");
			   
			    /* Creating Object */   	
			    vo=new OPDIssueToPatAutoTransVO();
			   	bo=new OPDIssueToPatAutoTransBO();
			   	util = new HisUtil("MMS Transactions", "OPDIssueToPatAutoTransDATA");
			   	/* Value set in Value Object */
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreId(request.getParameter("strStoreId"));
			   	vo.setStrIssueNo(request.getParameter("strIssueNo"));
			   
	           /* Calling BO method */
			    bo.getBilledItemDtls(vo);
			    
			       strResult = OPDIssueToPatAutoTransHLP.getBilledItemDtls(vo);
	
			    if(strResult!= null && !strResult.equals(""))
			    	
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult);
				 		 
				}
				else
				{
				    HisException eObj = new HisException("MMS", "OPDIssueToPatAutoTransDATA->getViewDtl()", vo.getStrMsgString());
					       String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "OPDIssueToPatAutoTransDATA->getViewDtl()", strmsgText);
				_OPDIssueToPatAutoTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//_OPDIssueToPatAutoTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   finally 
		   {
			    util = null;
				  bo = null;
				  vo = null;
			}
		   
	}

	

	public static void getTariffDtl(OPDIssueToPatAutoTransFB _OPDIssueToPatAutoTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	      String strmsgText = "";
		   OPDIssueToPatAutoTransVO vo = null;
		   OPDIssueToPatAutoTransBO bo = null;
		   HisUtil util = null;
		   String strResult="" ;
		   int i=0;
		   try
		   {
			   System.out.println(" ------- OPDIssueToPatAutoTransDATA.getTariffDtl  ------- ");
			   
			    /* Creating Object */   	
			    vo=new OPDIssueToPatAutoTransVO();
			   	bo=new OPDIssueToPatAutoTransBO();
			   	util = new HisUtil("MMS Transactions", "OPDIssueToPatAutoTransDATA");
			   	/* Value set in Value Object */
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setTariff(request.getParameter("itemTmp"));
		
			    bo.getTariffDtls(vo);
			    
			    if(vo.getStrTariffDtl().size() > 0)
			    {
			    	while(vo.getStrTariffDtl().next())
			    	{
			    		if(vo.getStrTariffDtl().getString(2).equals("0"))     //Tariff Count is 0 i.e. Tariff not mapped
			    		{
			    			if(i==0)
			    				strResult = vo.getStrTariffDtl().getString(1) ;
			    			else
			    				strResult += "," + vo.getStrTariffDtl().getString(1);
			    			i++;
			    		}
			    	}
			    }
	
			    response.setHeader("Cache-Control", "no-cache");
			    response.getWriter().print(strResult);  // if strResult is zero blank will be set
						   
			   
		   }catch(Exception _err){
			   _err.printStackTrace();
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "OPDIssueToPatAutoTransDATA->getTariffDtl()", strmsgText);
				_OPDIssueToPatAutoTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//_OPDIssueToPatAutoTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   finally 
		   {
			    util = null;
				  bo = null;
				  vo = null;
			}
		   
	}


	public static void getAlreadyIssueDrug(OPDIssueToPatAutoTransFB formBean,HttpServletRequest request,HttpServletResponse response)
	{
	
	
		OPDIssueToPatAutoTransBO bo = null;
		OPDIssueToPatAutoTransVO vo = null;
		MmsConfigUtil mcu = null;
		HisUtil util = null;
		String strmsgText = null;
	
	try 
	{
		System.out.println(" ------- OPDIssueToPatAutoTransDATA.getAlreadyIssueDrug  ------- ");
		
			bo = new OPDIssueToPatAutoTransBO();
			vo = new OPDIssueToPatAutoTransVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			String strIssueMode = mcu.getStrIssueMode();
			formBean.setStrIssueMode(strIssueMode);
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			//vo.setStrCrNumber(formBean.getStrCrNo());
			vo.setTariff(request.getParameter("itemTmp"));
			vo.setStrStoreId(request.getParameter("storeId"));
			formBean.setStrCrNo(request.getParameter("strCrNum"));
			formBean.setStrEpisodeCode(request.getParameter("episodeDtl"));
			//formBean.setStrDeptCode(request.getParameter("deptID"));
			//formBean.setStrUnitCode(request.getParameter("strDeptUnit"));
			
			String strOnlineIssueReqDays = mcu.getStrOnlineIssueDetailsInDays();
			vo.setStrOnlineIssueReqDays(strOnlineIssueReqDays);
			
			bo.getAlreadyIssueDrug(formBean, vo);		
			
			StringBuffer sb=new StringBuffer();
			if(vo.getAlreadyIssueDrug().size()>0) {
				while (vo.getAlreadyIssueDrug().next()) {
					sb.append(vo.getAlreadyIssueDrug().getString(2) +"\n");
					
				}
			}
		//	formBean.setStrRowCount(String.valueOf(rowcount));
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(sb.toString());
			
	if (vo.getStrMsgType().equals("1")) {
			throw new Exception(vo.getStrMsgString());
		}
			
	} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.OPDIssueToPatAutoTransDATA.getOnlineReqDtl --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"OPDIssueToPatAutoTransDATA->getOnlineReqDtl()", strmsgText);
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

  public static void getDiirecIssueInitData(OPDIssueToPatAutoTransFB formBean, HttpServletRequest request,HttpServletResponse response) 
  {
	// TODO Auto-generated method stub
	
	   OPDIssueToPatAutoTransVO vo = null;
	   OPDIssueToPatAutoTransBO bo = null;
	   HisUtil util = null;
	   String strCatVal=null;
	   String strStoreVal=null;
	   String strPayModeVal=null;
	   String strAdmDtl=null;
	   String strIssueByCombo=null;
	   try
	   {
	    	 
	    	    System.out.println(" ------- OPDIssueToPatAutoTransDATA.getDiirecIssueInitData  ------- ");
	    	 	vo=new OPDIssueToPatAutoTransVO();
			   	bo=new OPDIssueToPatAutoTransBO();
			   	util = new HisUtil("MMS Transactions", "OPDIssueToPatAutoTransDATA");
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	
			   	vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				vo.setStrCrNo(formBean.getStrCrNo());
								
				vo.setStrStoreId(formBean.getStrStoreId());
				
				// Calling Bo Method
				bo.getStoreDtlsBS(vo);
				//bo.getAccDtl(vo);
				System.out.println(" ------- PatientDtlHLPNew.admissionAccDtl  ------- ");
				
				strAdmDtl=PatientDtlHLPNew.admissionAccDtl(formBean.getStrCrNo(), vo.getStrHospitalCode());
				
			
				if(strAdmDtl.trim().equals(""))
					formBean.setStrPatStatus("1");
				else
					formBean.setStrPatStatus("2");
					
				formBean.setStrAdmDtl(strAdmDtl);
				
				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
			
				if(vo.getStrStoreWs()!=null && vo.getStrStoreWs().size()>0)
				{
					strStoreVal = util.getOptionValue(vo.getStrStoreWs(),formBean.getStrStoreId(),"0^Select Value", false);
				}
				else
				{
					strStoreVal = "<option value='0'>Select Value</option>";
				}
							
				formBean.setStrStoreValues(strStoreVal);	
				
				if(vo.getStrPrescFormValues()!=null && vo.getStrPrescFormValues().size()>0)
				{
					strIssueByCombo = util.getOptionValue(vo.getStrPrescFormValues(),"","0^Select Value", false);
				}
				else
				{
					strIssueByCombo = "<option value='0'>Select Value</option>";
				}
				
		
				bo.getItemCatDtls(vo);
				
				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
			
				if(vo.getStrItemCatWs()!=null && vo.getStrItemCatWs().size()>0)
				{
					strCatVal = util.getOptionValue(vo.getStrItemCatWs(),"","0^Select Value", false);
				}
				else
				{
					strCatVal = "<option value='0'>Select Value</option>";
				}
				
							
				formBean.setStrCatValues(strCatVal);
				
				formBean.setStrIssueByCombo(strIssueByCombo);
				
				/********************* Drug Name Combo For Add ************************/
				
				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
			
				String strItemNameValues = "";
				
				if (vo.getStrBrandItemListWs()!= null && vo.getStrBrandItemListWs().size() > 0) 
				{				   
					strItemNameValues = util.getOptionValue(vo.getStrBrandItemListWs(), "", "", true);
				}
				else 
				{
					strItemNameValues = "<option value='0'>Select Value</option>";
				}
				
				//System.out.println("strItemNameValues---->"+strItemNameValues);	
				
				formBean.setStrItemNameValues(strItemNameValues);				
								
				System.out.println(" ------- getPayMode ------- ");
				bo.getPayMode(vo);
				strPayModeVal = util.getOptionValue(vo.getStrPayMode(),"","", false);
				
				formBean.setStrPayModeValues(strPayModeVal);
			   	
			 
		   
		   
		   
	   }catch(Exception _err){
			HisException eObj = new HisException("MMS", "OPDIssueToPatAutoTransDATA->getTariffDtl()", _err.getMessage());
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
	   }
	   finally 
	   {
		   	  util = null;
			  bo = null;
			  vo = null;
		}
	
}

public static void getReqType(OPDIssueToPatAutoTransFB fb, HttpServletRequest request, HttpServletResponse response) {
	// TODO Auto-generated method stub
	
    String strmsgText = "";
	   OPDIssueToPatAutoTransVO vo = null;
	   OPDIssueToPatAutoTransBO bo = null;
	   HisUtil util = null;
	   String temp="";

	   try
	   {
		    /* Creating Object */   	
		    vo=new OPDIssueToPatAutoTransVO();
		   	bo=new OPDIssueToPatAutoTransBO();
		   	
		   	util = new HisUtil("MMS Transactions", "OPDIssueToPatAutoTransDATA");
		   	/* Value set in Value Object */
		   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		   	vo.setStrStoreId(request.getParameter("storeId"));
			vo.setStrItemCat("10");
			
			System.out.println(" request.getParameter(strStoreId)----- "+request.getParameter("storeId"));		       
		   
		        
					
		    bo.getReqType(vo);
		    
		
		    temp=util.getOptionValue(vo.getStrReqTypeWs(),"32^10","0^Select Value", false);

			 	response.setHeader("Cache-Control", "no-cache");
			 	response.getWriter().print(temp);
			 		 
			
		
		   
		   
	   }catch(Exception _err){
		   strmsgText = _err.getMessage();
			HisException eObj = new HisException("MMS", "OPDIssueToPatAutoTransDATA->getReqType()", strmsgText);
			fb.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			//_OPDIssueToPatAutoTransFB.setStrMsgType("1");
			eObj = null;
	   }
	   finally 
	   {
		    util = null;
			  bo = null;
			  vo = null;
		}
	   
	
}




public static void getEpisodeDtl(OPDIssueToPatAutoTransFB fb, HttpServletRequest request, HttpServletResponse response) {
	// TODO Auto-generated method stub
	
	OPDIssueToPatAutoTransBO bo = null;
	OPDIssueToPatAutoTransVO voObj = null;
	HisUtil util = null;

	try
	{

		bo = new OPDIssueToPatAutoTransBO();
		voObj = new OPDIssueToPatAutoTransVO();

		String strCrNo = request.getParameter("crNo");
		String strDeptCode = request.getParameter("deptCode");
		String strUnitCode = request.getParameter("unit");


		if (strCrNo == null)
			strCrNo = "0";
		if (strDeptCode == null)
			strDeptCode = "0";

		voObj.setStrCrNo(strCrNo);
		voObj.setStrDeptCode(strDeptCode);
		voObj.setStrUnitCode(strUnitCode);
		voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		bo.getEpisodeDetails(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{
			throw new Exception(voObj.getStrMsgString());

		}

		util = new HisUtil("MMS Transactions", "OPDIssueToPatAutoTransDATA");
		String temp = "<option value='0'>Select Value</option>";
		

		if (voObj.getStrOffLineEpisodeValues().size() != 0)
		{

			temp = util.getOptionValue(voObj.getStrOffLineEpisodeValues(),"", "", true);

	

		}

		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().print(temp);

	} catch (Exception e)
	{
		String strmsgText = e.getMessage();
		new HisException("Billing", "OPDIssueToPatAutoTransDATA->getEpisodeDetails()", strmsgText);

	} finally
	{

		bo = null;

		voObj = null;

		util = null;
	}
	
}

public static void getPresFormDtl(OPDIssueToPatAutoTransFB fb, HttpServletRequest request, HttpServletResponse response) {
	// TODO Auto-generated method stub
	OPDIssueToPatAutoTransBO bo = null;
	OPDIssueToPatAutoTransVO voObj = null;
	HisUtil util = null;

	try
	{

		bo = new OPDIssueToPatAutoTransBO();
		voObj = new OPDIssueToPatAutoTransVO();

		String strCrNo = request.getParameter("crNo");
		String episodeCode = request.getParameter("episodeCode");


	

		voObj.setStrCrNo(strCrNo);
		voObj.setStrEpisodeCode(episodeCode.replace("^", "#").split("#")[0]);

		voObj.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		bo.getPresFormDetails(voObj);;

		if (voObj.getStrMsgType().equals("1"))
		{
			throw new Exception(voObj.getStrMsgString());

		}
			String precForm="0";
		if (voObj.getStrPrescFormValues().size() != 0)
		{
			while(voObj.getStrPrescFormValues().next()) {
				precForm=voObj.getStrPrescFormValues().getString(1);
			}
		}

	
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().print(precForm);

	} catch (Exception e)
	{
		String strmsgText = e.getMessage();
		new HisException("Billing", "CashCollectionOfflineTransBSDATA->getPresFormDtl()", strmsgText);

	} finally
	{
	bo = null;
		voObj = null;
		util = null;
	}
}

	public static void afterIssueSave(OPDIssueToPatAutoTransFB fb,HttpServletRequest request)
	{
	
		OPDIssueToPatAutoTransBO bo = null;
		OPDIssueToPatAutoTransVO vo = null;
		String strPatientDtl="";
		String strmsgText = "";
		String strRequestTypeId="";
		String strRaisingReqTypeId="";
		String strIssueItemId="";
		String strRequestDtl="";
		String strChk="";
		String temp[]=null;
		String hosCode="";
		String strRequestItemDtl="";
		String strStoreId="";
		MmsConfigUtil mmsConfig=null;
		String strCostReq="";
		StringBuffer buff=null;
		BillConfigUtil billConfig=null;
		String RaisingStoreId="RaisingStoreI";
		try 
		{
			System.out.println("************** OPDIssueToPatAutoTransDATA --> afterIssueSave()  **********CHK****"+request.getParameter("chk"));
			
				bo = new OPDIssueToPatAutoTransBO();
				vo = new OPDIssueToPatAutoTransVO();
				hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();		
							
				vo.setStrIssueNumber(fb.getStrIssueNum());	
				vo.setStrIssueNumber(fb.getStrIssueNo());
				vo.setStrAdmissionDtlHidVal(fb.getStrAdmissionDtlHidVal());				
				vo.setStrDeptName(fb.getStrDeptName());
				vo.setStrPatientDtlHidVal(fb.getStrPatientDtlHidVal());
				vo.setStrStoreId(fb.getStrStoreId());
				vo.setStrItemCat(fb.getStrItemCat());				
				vo.setStrPuk(fb.getStrCrNo());
				
				System.out.println("-Issue No ----"+vo.getStrIssueNumber());
				System.out.println("-Issue No ----"+fb.getStrIssueNo());
				System.out.println("-Admn_Dtl ----"+vo.getStrAdmissionDtlHidVal());
				System.out.println("-Dept Name ----"+vo.getStrDeptName());
				System.out.println("-Pat Dtl----"+vo.getStrPatientDtlHidVal());
				System.out.println("-Store Id ----"+vo.getStrStoreId());
				System.out.println("-Catg ----"+vo.getStrItemCat());
				System.out.println("-Cr No ----"+vo.getStrPuk());
				
				
				
				/* vo.getStrPatientDtlHidVal()
	              HRGDT_DOB || ''^'' ||GNUM_GENDER_CODE ||''^''||HGNUM_PAT_STATUS_CODE || ''^''||
		          HGNUM_PATIENT_CAT_CODE || ''^'' ||HRGNUM_IS_MLC    ||''^''||HRGNUM_ISNEWBORN      || ''^''|| HRGNUM_ID_NO
				*/
				
								
				strRequestTypeId="32";
				
				System.out.println("************** OPDIssueToPatAutoTransDATA --> afterIssueSave() --> PatientDtlHLP.patientWithAdmissionDtl **************");
	
				strPatientDtl=PatientDtlHLP.patientWithAdmissionDtl(fb.getStrCrNo(), hosCode, true);
				
				System.out.println("*************************************************");
	
			   vo.setStrPatientDtl(strPatientDtl);
			   vo.setStrHospitalCode(hosCode);
			   bo.getIssueDtlsInitDtls(vo);  // pkg_mms_view.Proc_Emp_Issue_Detail [ Mode - 3 ]
			
			if (vo.getStrMsgType().equals("1")) 
				throw new Exception(vo.getStrMsgString());
			
				 			
				System.out.println("-WsIssueDetails --Size in HLP ----"+vo.getWsIssueDetails().size());
				
				while(vo.getWsIssueDetails().next())
				{
					vo.setStrIssueDate(vo.getWsIssueDetails().getString(2));
					vo.setStrStoreName(vo.getWsIssueDetails().getString(4));
					
				}
				vo.getWsIssueDetails().beforeFirst();
				
			System.out.println("---  LPIssueDeskTransHLP.getIssueDtlsInitView  ----");
			 
			String strAfterSaveVoucher = OPDIssueToPatAutoTransHLP.getAfterSaveVoucher(vo,"1");	
			
			fb.setStrAfterSaveVoucher(strAfterSaveVoucher);
			
			System.out.println("---strAfterSaveVoucher  ----"+strAfterSaveVoucher);
			
			
		} catch (Exception e) {
	
			e.printStackTrace();
			strmsgText = "Issue Desk.OPDIssueToPatAutoTransDATA.getInitDetailForIssuePage(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"OPDIssueToPatAutoTransDATA->getIndentDetails()", strmsgText);
			fb.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
	
			eObj = null;
		} finally {
			bo = null;
			vo = null;
	
		}
	
	}
	
	
	/**
	 * Stock item dtls init.
	 * 
	 * @param request the request
	 * @param response the response
	 * @param formBean the form bean
	 */
	public static void stockItemDtlsInit(HttpServletRequest request,HttpServletResponse response, OPDIssueToPatAutoTransFB formBean) 
	{
	
		String strSearchItemInitView = "";
		OPDIssueToPatAutoTransBO bo = null;
		OPDIssueToPatAutoTransVO vo = null;
		String                 strMode = "";
		String          strStockStatus = "";
		String         strGenricItemId = "";
		String               strItemId = "";
		String             strIssueQty = "";
		String       strIssueQtyInBase = "";
		String          strFromStoreId = "";
		String         strItemCategory = "";
		String   	   strReservedFlag = "";
		String            strHiddenVal = "";
		String             strUnitName = "";
		try 
		{
			                 strMode = (String) request.getParameter("strMode").split("\\^")[0];  // This is Combination of [ Mode ^ Budget Flag ^ Index ] 
			          strStockStatus = (String) request.getParameter("strStockStatus");
			         strGenricItemId = (String) request.getParameter("strGenItemId");
			               strItemId = (String) request.getParameter("strItemId");
			             strIssueQty = (String) request.getParameter("strIssueQty");
			       strIssueQtyInBase = (String) request.getParameter("strIssueQtyInBase");
			          strFromStoreId = (String) request.getParameter("strStoreId");
			         strItemCategory = (String) request.getParameter("strCatCode");
			   	     strReservedFlag = (String) request.getParameter("strReservedFlag");
			            strHiddenVal = (String) request.getParameter("strHiddenFieldVal");			
			             strUnitName = (String) request.getParameter("strUnitName"); 		
			                      bo = new OPDIssueToPatAutoTransBO();
			                      vo = new OPDIssueToPatAutoTransVO();
			                      
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString()); 
			formBean.setStrFromStoreId(strFromStoreId);
			formBean.setStrModeVal(strMode);
			formBean.setStrItemCategoryId(strItemCategory);
			formBean.setStrStockStatus(strStockStatus);
			formBean.setStrGenricItemId(strGenricItemId);
			formBean.setStrItemId(strItemId);
			formBean.setStrIndentIssueQty(strIssueQty);
			formBean.setStrIssueQtyInBase(strIssueQtyInBase);
			formBean.setStrReservedFlag(strReservedFlag);
			formBean.setStrHiddenVal(strHiddenVal);
			
			
			vo.setStrModeVal(strMode);
			vo.setStrFromStoreId(formBean.getStrFromStoreId());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryId());
			vo.setStrStockStatus(formBean.getStrStockStatus());
			vo.setStrGenricItemId(formBean.getStrGenricItemId());
			vo.setStrItemId(formBean.getStrItemId());
			vo.setStrIndentIssueQty(formBean.getStrIndentIssueQty());
			vo.setStrIssueQtyInBase(formBean.getStrIssueQtyInBase());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrReservedFlag(formBean.getStrReservedFlag());
			
			 System.out.println("-----OPDIssueToPatAutoTransDATA.stockItemDtlsInit ------");
		
			// Calling BO Method
			bo.getStockItemDtlsInitDtls(vo);
	
			if (vo.getStrMsgType().equals("1")) 
			{
	
				throw new Exception(vo.getStrMsgString());
			}
			
			formBean.setStrItemName(vo.getStrItemName());
			formBean.setWsStockDetails(vo.getWsStockDetails());
			formBean.setStrRateUnit(vo.getStrRateUnit());
			formBean.setStrRateInBaseValue(vo.getStrRateInBaseValue());
			//formBean.setStrParentIndex(strParentIndex);
			
			// This Variable is used to set Budget Avalaible or Not Flag
			formBean.setUsrArg((String) request.getParameter("strMode").split("\\^")[1]);
			// This Variable is Used To Set Index
			formBean.setStrIndex((String) request.getParameter("strMode").split("\\^")[2]);
			
			strSearchItemInitView = OPDIssueToPatAutoTransHLP.getStockItemDtlsInitView(formBean);
			
			//System.out.println("-strSearchItemInitView-----"+strSearchItemInitView);
	
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strSearchItemInitView);
		}
		catch (Exception e) 
		{
		     e.printStackTrace();	 
			 String strmsgText = "OPDIssueToPatAutoTransDATA.stockItemDtlsInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("IssueDeskTrans",
					"OPDIssueToPatAutoTransDATA.stockItemDtlsInit(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;
			  
		} finally {
	
			bo = null;
			vo = null;
		}
	
	}
	
	public static void DIRECTISSUE_OFFLINE(OPDIssueToPatAutoTransFB formBean, HttpServletRequest request) 
	{

		OPDIssueToPatAutoTransBO bo = null;
		OPDIssueToPatAutoTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		String[] temp = null;
		String[] strtemp = null;
		
		String[] patDtl = null;
		String[] patAdmissionDtl = null;
		
		MmsConfigUtil mcu = null;
		HisUtil hisUtil = null;
		int debugPoint = 0;
		IpdConfigUtil ipdC=new IpdConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
		try 
		{
			debugPoint = 1;
			bo = new OPDIssueToPatAutoTransBO();
			vo = new OPDIssueToPatAutoTransVO();
			
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			hisUtil = new HisUtil("MMS", "DirectPharmacy");
			
			formBean.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			formBean.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
			
			//System.out.println("in issue mode 1 in data");
			vo.setStrReqQty(formBean.getStrReqQty());
			vo.setStrUnitName(formBean.getStrUnitName());
			vo.setItemParamValue(formBean.getItemParamValue());
			vo.setStrReqEmpNo("0");
			vo.setStrReqPatCatCode("0");
			vo.setStrReqAdmNo("0");
			vo.setStrReqWardCode("0");
			vo.setStrPatientType("18");
			vo.setStrReqType(formBean.getStrRequestType());
			
			debugPoint = 2;
			
			vo.setStrPrescribedBy("0");
		    vo.setStrReqPrescribedBy("0");
			vo.setStrPatientName(formBean.getStrPatientName());
			vo.setStrPatientId((formBean.getCrNo()!=null && !formBean.getCrNo().equals("0")) ?formBean.getCrNo() : "0");
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			debugPoint = 3;
			
			vo.setStrStoreId(formBean.getStrStoreId());		
			//vo.setStrItemCat(formBean.getStrItemCat());
			//vo.setStrCatgoryCode(formBean.getStrItemCat());
			vo.setStrIssueMode("0");
			vo.setStrFinStartDate(mcu.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStrFinEndDate(mcu.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStrReceiveBy(formBean.getStrReceiveBy());
			vo.setStrPuk(formBean.getCrNo());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrCostFinal(formBean.getStrCostFinal());
			vo.setStrApproxAmt(formBean.getStrApproxAmt());
			//vo.setStrEpisodeCode(formBean.getStrOffLineEpisode());
			
			debugPoint = 4;
					
			vo.setStrReqTypeId("32");
			
			debugPoint = 5;
			
			vo.setStrQtyText(formBean.getStrQtyText());
			vo.setStrDose(formBean.getStrDose());
			vo.setStrDays(formBean.getStrDays());
			vo.setStrFrequency(formBean.getStrFrequency());
			vo.setStrPatientHiddenValue1(formBean.getStrPatientHiddenValue1());
			vo.setStrPatientDtlHidVal(formBean.getStrPatientDtlHidVal());
			vo.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			vo.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
			vo.setStrDrugIssueDate(formBean.getStrDrugIssueDate());
			
			vo.setStrPayModeVal(formBean.getStrPayMode());
			vo.setStrPayDtlVal(formBean.getStrPayDtl());	
			vo.setStrNetCost(formBean.getStrNetCost());
			vo.setItemCalcValue(formBean.getItemCalcValue());
			vo.setItemParamValue(formBean.getItemParamValue());
			vo.setItemUserValue(formBean.getItemUserValue());
			
			vo.setStrOutOfStockFlag("0");
			
			debugPoint = 6;
			
			vo.setStrDeptCode("0");
			vo.setStrAdmissionDtlHidVal(formBean.getStrAdmissionDtlHidVal());
			
			
			
			bo.getOPDPatientDtls(vo);
			
			/*
			 * 
			  String[] temp = = vo.getStrOPDDetails().split("\\$");
			   1 
			     $'||v_patient_status_code||'$'||v_reg_cat_code
			  ||'$'||v_hrgnum_episode_code||'$'||v_hrgnum_visit_no
			  ||'$'||v_gnum_dept_code  ||'$'||v_gnum_deptunit_code
			  ||'$'||v_hipnum_admno||'$'||AHIS_FUNCTION.getDeptName(v_gnum_dept_code,hosp_code) ||'$'|| Patient Mobile No;
			  
			   '2 $'||v_patient_status_code||'$'||v_reg_cat_code||'$'||'IPD Patient Cr No ['||crno||'] Not Allowed !!';
			   
			  */
			temp = vo.getStrOPDDetails().split("\\$");
			
			formBean.setStrDeptName(temp[8]);
			formBean.setStrPatMobileNo(temp[9]);
			
			//vo.setStrOPDDetails
			
			if (temp[0].equals("2"))
			{	
				throw new Exception(temp[3]);
			}		
			
			//vo = ( OPDIssueToPatAutoTransVO) TransferObjectFactory.populateData("mms.transactions.vo.OPDIssueToPatAutoTransVO",	formBean);
			
			
			bo.DIRECTISSUE_OFFLINE(vo);		
			
			debugPoint = 7;			
			
			if (vo.getStrMsgType().equals("1"))
				throw new Exception(vo.getStrMsgString());
			else 
			{
					formBean.setStrNormalMsg("Drug Successfully Dispensing To CrNo [ "+vo.getStrPuk()+" ] ");
					formBean.setStrIssueNum(vo.getStrIssueNumber());
					formBean.setStrVisitDtl("1");				
					formBean.setStrStoreId(vo.getStrStoreId());		
					formBean.setStrItemCat("10");
					formBean.setStrCatgoryCode("10");
					formBean.setStrIssueMode("0");				
					formBean.setStrCrNo(vo.getStrPuk());				
					formBean.setStrCostFinal(vo.getStrCostFinal());
					formBean.setStrApproxAmt(vo.getStrApproxAmt());
					formBean.setStrPayDtl(vo.getStrPayDtlVal());				
					formBean.setStrAdmissionDtlHidVal(vo.getStrAdmissionDtlHidVal());				
					formBean.setStrDeptName(temp[8]);
					formBean.setStrPatientDtlHidVal(vo.getStrPatientDtlHidVal());
					formBean.setStrPatientHiddenValue1(vo.getStrPatientHiddenValue1());
					/*
					System.out.println("---------------------------------------------------------------");
					System.out.println("getStrAdmissionDtlHidVal----"+formBean.getStrAdmissionDtlHidVal());
					System.out.println("getStrPatientHiddenValue1----"+formBean.getStrPatientHiddenValue1());
					System.out.println("getStrPatientDtlHidVal----"+formBean.getStrPatientDtlHidVal());
					System.out.println("getStrDrugIssueDate----"+formBean.getStrDrugIssueDate());
					System.out.println("getStrDeptName----"+formBean.getStrDeptName());
					System.out.println("getStrDeptNametemp[8]----"+temp[8]);
					System.out.println("getStrPatMobileNo----"+formBean.getStrPatMobileNo());
					System.out.println("---------------------------------------------------------------");
					*/
					
					patDtl          = formBean.getStrPatientDtlHidVal().split("\\^");
					patAdmissionDtl = formBean.getStrAdmissionDtlHidVal().split("\\^");
					
					/* vo.getStrPatientDtlHidVal()
					 getStrPatientDtlHidVal----08-jun-1987^F^1^11^0^0^^Anshul^Ramesh^NA^36 Yr/Female^0^0^9891925158^0^All India Institute of Medical Sciences, Mangalagiri^0^08-JUN-2022 12:13:26^^NO^37913^- 
					*/				
					
					String smsOrgMsg1 = "Dear "+patDtl[7]+","+vo.getItemParamValue().length+" number of items are issued successfully on "+hisUtil.getASDate("dd-MMM-yyyy")+" to CR Number:"+formBean.getStrCrNo()+". In case above item has not been requested ,kindly inform EHS Pharmacy immediately. AIIMS Jodhpur";

					String smsOrgMsg = "Dear "+patDtl[7]+","+formBean.getStrDeptName()+" prescribed "+vo.getItemParamValue().length+" medicine/item/s are issued successfully on "+hisUtil.getASDate("dd-MMM-yyyy")+" at - with CR Number:"+formBean.getStrCrNo()+". In case above medicine/item/s has not been requested by you; kindly inform EHS Pharmacy immediately.-AIIMS Jodhpur.";
					System.out.println("SMS_MSG--To--"+formBean.getStrPatMobileNo()+"--"+smsOrgMsg);
					
					String strBillNo=vo.getStrBillNo();
					//String strBillNo="0";
					Map tariffPrintMap=null;
									
					String patMobileNo=formBean.getStrPatMobileNo();
				//	String smsMsg1=formBean.getStrPatientDtlHidVal().replace("^","#").split("#")[7]+"^"+formBean.getStrOfflineTotalRecAmount()+"^"+formBean.getStrBillNo()+"/1";
					
					 String templateid = "34";
					 
					 if(patMobileNo!=null && !patMobileNo.equals(""))
						
						new Thread( new Runnable() {
					           public void run(){

					        	  // SMSHttpPostClientNew.sendSMS (patMobileNo,smsOrgMsg,templateid,formBean.getStrHospitalCode());

					          return; // to stop the thread
					                          }
					         }).start();
					
					if(formBean.getStrPatStatus().equals("1")) 
					{
					
						System.out.println("PatStatus------[ PrintHLP.OPD_SERVICES ]-------"+strBillNo+"----------------->  1");
						PrintHLP.OPD_SERVICES(strBillNo, "5", vo.getStrHospitalCode(), "1", request, tariffPrintMap, "0", 0, "0", "");
						
						/*
						 * public static boolean OPD_SERVICES(String strBillNo, String
						 * strBServiceId,String strHospitalCode, String strReceiptNo ,
						 * HttpServletRequest request , Map tariffPrintMap , String strIsDirectMode,int
						 * isDuplicateBill,String isCreditBill,String printCopyType )
						 */
						
						//PrintHLP.OPD_SERVICES(strBillNo, "5", vo.getStrHospitalCode(), "1", request, tariffPrintMap, "1", 0, "0", "");
						
						String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
						formBean.setStrPrintBill(fileName);
						request.setAttribute("filePath", fileName);
						formBean.setIsOpenPopUp("1");

					}
					else 
					{
						System.out.println("PatStatus--------------"+strBillNo+"----------------->  2");
						String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
						formBean.setStrPrintBill(fileName);
						request.setAttribute("filePath", fileName);
						formBean.setIsOpenPopUp("2");

					}
					
					
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.OPDIssueToPatAutoTransDATA.insertWithoutCrNo()--> "+e.getMessage() + String.valueOf(" :: Debug Point = " + debugPoint);
			
			if(e.getMessage().contains("##") && (e.getMessage().split("\\##")[2].equals("999") || e.getMessage().split("\\##")[2].equals("103")))
				formBean.setStrErrMsg(e.getMessage().split("\\##")[1]);
			else	
			formBean.setStrIssueNo("0");
		    formBean.setStrIssueNum("0");
		  
			
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
		}
	}
	
	public static void NEW_OPD_ISSUE_INSERT(OPDIssueToPatAutoTransFB formBean, HttpServletRequest request) 
	 {

		OPDIssueToPatAutoTransBO bo = null;
		OPDIssueToPatAutoTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		String[] temp = null;
		String[] strtemp = null;
		
		MmsConfigUtil mcu = null;

		int debugPoint = 0;
		int chkLength = 0;
		
		String strItemIdArray[] = null;
		String strBrandIdArray[] = null;
		String strReservedFlagArray[] = null;
		String stockDtlsId[] = null; // StoreId^Generic_ItemId^Brand_ItemId^Stock_Status_Code^Batch_No^Serial_No
		String strStochStatusCodeArray[] = null;
		String strGroupIdArray[] = null;
		String strSubGroupIdArray[] = null;
		String strAvlQtyArray[] = null;
		String strAvlQtyUnitIdArray[] = null;
		String strConsumableFlagArray[] = null;
		String strTotalBatch[]          = null;
		
		String[] values = null;
			
		
		try 
		{
			
			System.out.println("-------------- OPDIssueToPatAutoTransDATA . NEW_OPD_ISSUE_INSERT --------------");
			
			debugPoint = 1;
			bo = new OPDIssueToPatAutoTransBO();
			vo = new OPDIssueToPatAutoTransVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			formBean.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
			
					  chkLength  	= formBean.getStrItemDetailsChk().length;		
			strBrandIdArray 	 	= new String[chkLength];
			strItemIdArray 		 	= new String[chkLength];
			strBrandIdArray 	 	= new String[chkLength];
			strReservedFlagArray 	= new String[chkLength];
			stockDtlsId 		 	= new String[chkLength]; // from userHiddenFld=
													// StoreId^Generic_ItemId^Brand_ItemId^Stock_Status_Code^Batch_No^Serial_No
			strStochStatusCodeArray = new String[chkLength];
			strGroupIdArray 		= new String[chkLength];
			strSubGroupIdArray 		= new String[chkLength];
			strAvlQtyArray 			= new String[chkLength];
			strAvlQtyUnitIdArray 	= new String[chkLength];
			strConsumableFlagArray 	= new String[chkLength];
			strTotalBatch           = new String[chkLength];
			
			vo.setStrCheckBatchExists(formBean.getStrCheckBatchExists());						
			for (int i = 0; i < chkLength; i++) 
			{

				                   values = formBean.getStrItemDetailsChk()[i].replace("^", "#").split("#");
				        strItemIdArray[i] = values[0];
				       strBrandIdArray[i] = values[1];
				  strReservedFlagArray[i] = values[2];
				       strGroupIdArray[i] = values[3];
				    strSubGroupIdArray[i] = values[4];
				strConsumableFlagArray[i] = values[5];
				
				//System.out.println("--Sock Dtls--"+i+"---"+formBean.getStockDtlsId());
				
							  stockDtlsId = formBean.getStockDtlsId();			
				                   values = formBean.getStrAvlQty()[i].replace("^", "#").split("#"); 
				// avl qty unit name^ avlqty@unit ^ avl base val

				                     temp = formBean.getStrAvlQty()[i].replace("@", "#").split("#");			
				        strAvlQtyArray[i] = temp[0];
				  strAvlQtyUnitIdArray[i] = temp[1];
				  
				         strTotalBatch[i] = formBean.getStrTotalBatch()[i];
		
			}
			
			/*      Single Batch Details        */
			vo.setStrSingleExpiry(formBean.getStrSingleExpiry());
			vo.setStrSingleBatch(formBean.getStrSingleBatch());
			vo.setStrSingleStockRate(formBean.getStrSingleStockRate());
			vo.setStrSingleMfgDate(formBean.getStrSingleMfgDate());		
			vo.setStrStockRate(formBean.getStrStockRate());
			vo.setStrStockQty(formBean.getStrStockQty());
			
		                  	
			
			vo.setStrItemDetailsChk(formBean.getStrItemDetailsChk());
			vo.setStockDtlsId(stockDtlsId);
			vo.setStrItemIdArray(strItemIdArray); 
			vo.setStrBrandIdArray(strBrandIdArray); 
			vo.setStrReservedFlagArray(strReservedFlagArray); 
			vo.setStrStochStatusCodeArray(strStochStatusCodeArray); 
			vo.setStrGroupIdArray(strGroupIdArray); 
			vo.setStrSubGroupIdArray(strSubGroupIdArray); 
			vo.setStrAvlQtyArray(strAvlQtyArray); 
			vo.setStrAvlQtyUnitIdArray(strAvlQtyUnitIdArray); 	
			vo.setStrIssueQtyArray(formBean.getStrIssueQty()); // 19
			vo.setStrTotalBatch(strTotalBatch);
			
			//System.out.println("in issue mode 1 in data");
			vo.setStrReqQty(formBean.getStrReqQty());
			vo.setStrUnitName(formBean.getStrUnitName());
			vo.setItemParamValue(formBean.getItemParamValue());
			vo.setStrReqEmpNo("0");
			vo.setStrReqPatCatCode("0");
			vo.setStrReqAdmNo("0");
			vo.setStrReqWardCode("0");
			vo.setStrPatientType("18");
			vo.setStrReqType(formBean.getStrRequestType());
			
			
			
			debugPoint = 2;
			
			vo.setStrPrescribedBy(formBean.getStrPrescribedBy());
		    vo.setStrReqPrescribedBy(formBean.getStrPrescribedBy());
			vo.setStrPatientName(formBean.getStrPatientName());
			vo.setStrPatientId((formBean.getCrNo()!=null && !formBean.getCrNo().equals("0")) ?formBean.getCrNo() : "0");
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			
			debugPoint = 3;
			
			vo.setStrStoreId(formBean.getStrStoreId());		
			vo.setStrItemCat(formBean.getStrItemCat());
			vo.setStrCatgoryCode(formBean.getStrItemCat());
			vo.setStrIssueMode("0");
			vo.setStrFinStartDate(mcu.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStrFinEndDate(mcu.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStrReceiveBy(formBean.getStrReceiveBy());
			vo.setStrPuk(formBean.getCrNo());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrCostFinal(formBean.getStrCostFinal());
			vo.setStrApproxAmt(formBean.getStrApproxAmt());
			vo.setStrEpisodeCode(formBean.getStrOffLineEpisode());
			
			debugPoint = 4;
			
			vo.setStrReqTypeId("32");
			
			debugPoint = 5;
			
			vo.setStrQtyText(formBean.getStrQtyText());
			vo.setStrDose(formBean.getStrDose());
			vo.setStrDays(formBean.getStrDays());
			vo.setStrFrequency(formBean.getStrFrequency());
			vo.setStrPatientHiddenValue1(formBean.getStrHiddenPatDtl()); 
			/* 
			 *  Naman
			 * ^AMAN/
			 * ^General
			 * ^28 Yr/M
			 * ^,Guntur,Andhra Pradesh
			 * ^All India Institute of Medical Sciences, Mangalagiri
			 * ^null
			 * ^7088563254 */
			vo.setStrPatientDtlHidVal(formBean.getStrHiddenPatDtl());
						
			System.out.println("-formBean.getStrPatientHiddenValue1-----"+formBean.getStrHiddenPatDtl());
			System.out.println("-formBean.getStrPatientDtlHidVal-----"+formBean.getStrPatientDtlHidVal());
			
			vo.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			vo.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
			vo.setStrDrugIssueDate(formBean.getStrDrugIssueDate());
			
			vo.setStrPayModeVal(formBean.getStrPayMode());
			vo.setStrPayDtlVal(formBean.getStrPayDtl());	
			vo.setStrNetCost(formBean.getStrNetCost());
			
			vo.setStrOutOfStockFlag(formBean.getStrOutOfStockFlag());
			
			debugPoint = 6;
						
			vo.setStrDeptCode("0");
			vo.setStrAdmissionDtlHidVal(formBean.getStrAdmissionDtlHidVal());
			vo.setStrDeptPKey(formBean.getStrDeptPKey());
									
			bo.getOPDPatientDtls(vo);
			
			/*
			 * 
			  String[] temp = = vo.getStrOPDDetails().split("\\$");
			   1 
			     $'||v_patient_status_code||'$'||v_reg_cat_code
			  ||'$'||v_hrgnum_episode_code||'$'||v_hrgnum_visit_no
			  ||'$'||v_gnum_dept_code  ||'$'||v_gnum_deptunit_code
			  ||'$'||v_hipnum_admno||'$'||AHIS_FUNCTION.getDeptName(v_gnum_dept_code,hosp_code) ||'$'|| Patient Mobile No;
			  
			   '2 $'||v_patient_status_code||'$'||v_reg_cat_code||'$'||'IPD Patient Cr No ['||crno||'] Not Allowed !!';
			   
			  */
			temp = vo.getStrOPDDetails().split("\\$");
			
			formBean.setStrDeptName(temp[8]);
			formBean.setStrPatMobileNo(temp[9]);			
						
			//vo.setStrOPDDetails
			
			if (temp[0].equals("2"))
			{	
				throw new Exception(temp[3]);
			}		
			
			
			
			/*
			System.out.println("------------------------------ NEW_OPD_ISSUE_INSERT -------------------------------------");
			System.out.println("-getStrDeptName-----"+vo.getStrDeptName());
			System.out.println("-getStrRequestType-----"+formBean.getStrRequestType());
			System.out.println("-getStrPrescribedBy-----"+formBean.getStrPrescribedBy());
			System.out.println("-getStrPrescribedBy-----"+formBean.getStrPrescribedBy());
			System.out.println("-getStrPatientName-----"+formBean.getStrPatientName());
			System.out.println("-getCrNo-----"+formBean.getCrNo());		
			System.out.println("-getStrStoreId-----"+formBean.getStrStoreId());
			System.out.println("-getStrItemCat-----"+formBean.getStrItemCat());
			System.out.println("-getStrReceiveBy-----"+formBean.getStrReceiveBy());
			System.out.println("-getStrRemarks-----"+formBean.getStrRemarks());
			System.out.println("-getStrCostFinal-----"+formBean.getStrCostFinal());		
			System.out.println("-getStrOffLineEpisode-----"+formBean.getStrOffLineEpisode());
			System.out.println("-getStrApproxAmt-----"+formBean.getStrApproxAmt());		
			System.out.println("-getStrQtyText-----"+formBean.getStrQtyText());
			System.out.println("-getStrDose-----"+formBean.getStrDose());
			System.out.println("-getStrDays-----"+formBean.getStrDays());
			System.out.println("-getStrFrequency-----"+formBean.getStrFrequency());
			System.out.println("-getStrPatientHiddenValue1-----"+formBean.getStrPatientHiddenValue1());
			System.out.println("-getStrPatientDtlHidVal-----"+formBean.getStrPatientDtlHidVal());
			System.out.println("-getStrDrugIssueDate-----"+formBean.getStrDrugIssueDate());
			System.out.println("-getStrPayMode-----"+formBean.getStrPayMode());
			System.out.println("-getStrPayDtl-----"+formBean.getStrPayDtl());
			System.out.println("-getStrNetCost-----"+formBean.getStrNetCost());		
			System.out.println("-getStrDeptCode-----"+formBean.getStrDeptCode());
			System.out.println("-getStrAdmissionDtlHidVal-----"+vo.getStrAdmissionDtlHidVal());
			System.out.println("-getStrPatStatus-----"+formBean.getStrPatStatus()+"--- ISSUE_OPD  ---");
			System.out.println("-------------------------------------------------------------------");	
			*/
			/*
			int                       batchLength = 0;	
			
			
			String            strBatchSlNoArray[] = null;
			String             strItemSlNoArray[] = null;
			String       strIssueQtyBtchWsArray[] = null;
			String   strIssueQtyUnitBtchWsArray[] = null;
			String            strManufDateArray[] = null;
			String           strExpiryDateArray[] = null;
			String                 strRateArray[] = null;
			String           strRateUnitIdArray[] = null;
			
			
			for (int i = 0; i < vo.getStrItemIdArray().length; i++) 
			{   
							
				if (vo.getStockDtlsId()[i]!=null && vo.getStockDtlsId()[i].length()>0 && !vo.getStockDtlsId()[i].equals(""))
				{			
					
					    System.out.println("------------AUTO Batch With Selection  ------ A -----------");
						System.out.println("-------vo.getStockDtlsId()["+i+"]------"+vo.getStockDtlsId()[i]);
						values = vo.getStockDtlsId()[i].split("#"); 
			            //    0       1         		2			3	            4        5         6           7                8               9               10                  11              12      13          14           15          16   17  18      19       
						// StoreId^Generic_ItemId^Brand_ItemId^Stock_Status_Code^Batch_No^Serial_No^Expiry date^Manufactre Date^In Hand Qty ^ In Hand Qty Unit ^ Purchase Rate ^ Purchase Rate Unit ^ Rate ^ Rate Unit ^ Issue Qty ^ Issue Qty Unit ^   ^   ^ Cost ^ Cost
						// 99901120^10000067^10100067^UIT11738^10^0^31-May-2014^01-Dec-2011^24990^6301^21.54^6306^22.62^6306^10^6301^1^0^2.26^2.26
						batchLength = values.length;
						for (int j = 0; j < batchLength; j++) 
						{
							   strStochStatusCodeArray = new String[batchLength];
							         strBatchSlNoArray = new String[batchLength];
							          strItemSlNoArray = new String[batchLength];
							    strIssueQtyBtchWsArray = new String[batchLength];
							strIssueQtyUnitBtchWsArray = new String[batchLength];
							         strManufDateArray = new String[batchLength];
							        strExpiryDateArray = new String[batchLength];
							              strRateArray = new String[batchLength];
							        strRateUnitIdArray = new String[batchLength];							
							                      temp = values[j].replace("^", "#").split("#");
							strStochStatusCodeArray[j] = temp[4];
								  strBatchSlNoArray[j] = temp[3];
							
							if(temp[4]==null)
							{	
								strStochStatusCodeArray[j] = "0";
							}
							else
							{
								strStochStatusCodeArray[j] = temp[4];
							}
							
							if(temp[5]==null)
							{
								strItemSlNoArray[j] = "0";
							}
							else
							{
								strItemSlNoArray[j] = temp[5];
							}
							if(temp[7]==null)
							{
								strManufDateArray[j] = "";
							}
							else
							{
								strManufDateArray[j]  = temp[7];
							}
							if(temp[6]!=null && temp.length > 10 )
							{
								strExpiryDateArray[j] = temp[6];
							}
							else
							{
								strExpiryDateArray[j] = "";
							}
							              strRateArray[j] = temp[12];                 // O.V 10
							        strRateUnitIdArray[j] = temp[13];                 // O.V 11
							    strIssueQtyBtchWsArray[j] = temp[14];
							strIssueQtyUnitBtchWsArray[j] = temp[15];
							
							//System.out.println("-getStrBalQtyArray-->>"+vo.getStrBalQtyArray()[i]);
							//System.out.println("-getStrBalQtyUnitIdArray-->>"+vo.getStrBalQtyUnitIdArray()[i]);
							System.out.println("-getStrGroupIdArray-->>"+vo.getStrGroupIdArray()[i]);
							System.out.println("-getStrAvlQtyArray-->>"+vo.getStrAvlQtyArray()[i]);
							System.out.println("-getStrAvlQtyUnitIdArray-->>"+vo.getStrAvlQtyUnitIdArray()[i]);
							
							
							System.out.println("-getStrBrandIdArray-->>"+vo.getStrBrandIdArray()[i]);
							System.out.println("-getStrItemIdArray-->>"+vo.getStrItemIdArray()[i]);
							
							
							System.out.println("-getStrSubGroupIdArray-->>"+vo.getStrSubGroupIdArray()[i]);
							System.out.println("-getStrReservedFlagArray-->>"+vo.getStrReservedFlagArray()[i]);
							
							
							//System.out.println("-getStrConsumableFlagArray-->>"+vo.getStrConsumableFlagArray()[i]);
							
							System.out.println("-strStochStatusCodeArray-->>"+strStochStatusCodeArray[j]);
							System.out.println("-strBatchSlNoArray-->>"+strBatchSlNoArray[j]);
							System.out.println("-strItemSlNoArray-->>"+strItemSlNoArray[j]);
							System.out.println("-strManufDateArray-->>"+strManufDateArray[j]);
							
							System.out.println("-strExpiryDateArray-->>"+strExpiryDateArray[j]);
							System.out.println("-strRateArray-->>"+strRateArray[j]);
							System.out.println("-strRateUnitIdArray-->>"+strRateUnitIdArray[j]);
							
							System.out.println("-strIssueQtyBtchWsArray-->>"+strIssueQtyBtchWsArray[j]);
							System.out.println("-strIssueQtyUnitBtchWsArray-->>"+strIssueQtyUnitBtchWsArray[j]);
								
							
					}
					
				}
				else 
				{
					if(vo.getStrCheckBatchExists()[i].equals("1"))
					{
						System.out.println("------------AUTO Batch No Selection  ------ C -----------");
						System.out.println("-StrItemDetailsChk-->>"+vo.getStrItemDetailsChk()[i]);
						System.out.println("-getStrGroupIdArray-->>"+vo.getStrGroupIdArray()[i]);
						System.out.println("-getStrAvlQtyArray-->>"+vo.getStrAvlQtyArray()[i]);
						System.out.println("-getStrAvlQtyUnitIdArray-->>"+vo.getStrAvlQtyUnitIdArray()[i]);						
						System.out.println("-getStrIssueQtyArray-->>"+vo.getStrIssueQtyArray()[i]);
						System.out.println("-getStrBrandIdArray-->>"+vo.getStrBrandIdArray()[i]);
						System.out.println("-getStrItemIdArray-->>"+vo.getStrItemIdArray()[i]);					
						System.out.println("-getStrSubGroupIdArray-->>"+vo.getStrSubGroupIdArray()[i]);
						System.out.println("-getStrReservedFlagArray-->>"+vo.getStrReservedFlagArray()[i]);	
					}
					else
					{
						System.out.println("------------Single Batch Selection  ------ D -----------");	
						
						
						System.out.println("-StrItemDetailsChk-->>"+vo.getStrItemDetailsChk()[i]);
						System.out.println("-strSingleExpiry-->>"+vo.getStrSingleExpiry()[i]);
						System.out.println("-strSingleBatch-->>"+vo.getStrSingleBatch()[i]);
						System.out.println("-strSingleManufId-->>"+vo.getStrSingleStockRate()[i]);					
						System.out.println("-getStrGroupIdArray-->>"+vo.getStrGroupIdArray()[i]);
						System.out.println("-getStrAvlQtyArray-->>"+vo.getStrAvlQtyArray()[i]);
						System.out.println("-getStrAvlQtyUnitIdArray-->>"+vo.getStrAvlQtyUnitIdArray()[i]);						
						System.out.println("-getStrIssueQtyArray-->>"+vo.getStrIssueQtyArray()[i]);
						System.out.println("-getStrBrandIdArray-->>"+vo.getStrBrandIdArray()[i]);
						System.out.println("-getStrItemIdArray-->>"+vo.getStrItemIdArray()[i]);					
						System.out.println("-getStrSubGroupIdArray-->>"+vo.getStrSubGroupIdArray()[i]);
						System.out.println("-getStrReservedFlagArray-->>"+vo.getStrReservedFlagArray()[i]);				
					}
					
					
					
				}
		     }
			*/
		    
			
			bo.NEW_OPD_ISSUE_INSERT(vo);
			
			debugPoint = 7;			
			
			if (vo.getStrMsgType().equals("1"))
			{	
				throw new Exception(vo.getStrMsgString());
			}
			else 
			{
					formBean.setStrNormalMsg("Drug Successfully Dispensing To CrNo [ "+vo.getStrPuk()+" ] ");
					formBean.setStrIssueNum(vo.getStrIssueNumber());							
					formBean.setStrStoreId(vo.getStrStoreId());		
					formBean.setStrItemCat("10");
					formBean.setStrCatgoryCode("10");
					formBean.setStrIssueMode("0");				
					formBean.setStrCrNo(vo.getStrPuk());				
										
					/*
					System.out.println("---------------------------------------------------------------");
					System.out.println("getStrAdmissionDtlHidVal----"+formBean.getStrAdmissionDtlHidVal());
					System.out.println("getStrPatientHiddenValue1----"+formBean.getStrPatientHiddenValue1());
					System.out.println("getStrPatientDtlHidVal----"+formBean.getStrPatientDtlHidVal());
					System.out.println("getStrDrugIssueDate----"+formBean.getStrDrugIssueDate());
					System.out.println("getStrDeptName----"+formBean.getStrDeptName());
					System.out.println("getStrDeptNametemp[8]----"+temp[8]);
					System.out.println("getStrPatMobileNo----"+formBean.getStrPatMobileNo());
					System.out.println("---------------------------------------------------------------");
					*/
										
					OPDIssueToPatAutoTransHLP.getIssuePopUpForDotMatrix(vo.getStrHospitalCode(),vo.getStrStoreId(),vo.getStrIssueNumber(),vo.getStrPuk(),request);												
					String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
					formBean.setStrPrintBill(fileName);
					request.setAttribute("filePath", fileName);
					formBean.setIsOpenPopUp("1");
					
					
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.OPDIssueToPatAutoTransDATA.insertWithoutCrNo()--> "+e.getMessage() + String.valueOf(" :: Debug Point = " + debugPoint);
			
			if(e.getMessage().contains("##") && (e.getMessage().split("\\##")[2].equals("999") || e.getMessage().split("\\##")[2].equals("103")))
				formBean.setStrErrMsg(e.getMessage().split("\\##")[1]);
			else
			//	formBean.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");
			
			formBean.setStrIssueNo("0");
		    formBean.setStrIssueNum("0");
		    
			//eObj = null;
			
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
		}
	}
	
	
	/**
	 * Stock item dtls init.
	 * 
	 * @param request the request
	 * @param response the response
	 * @param formBean the form bean
	 */
	public static void getNALIst(HttpServletRequest request,HttpServletResponse response, OPDIssueToPatAutoTransFB formBean) 
	{
	
		String strSearchItemInitView 	= "";
		OPDIssueToPatAutoTransBO 			  bo	= null;
		OPDIssueToPatAutoTransVO 		      vo    = null;
		String                 strCrNo  = "";
		String               storeName  = "";
		String             itemCatName  = "";
		String         strHiddenPatDtl  = "";
		String   strAdmissionDtlHidVal  = "";
		String       strIssueQtyInBase  = "";
		String          strFromStoreId  = "";
		String         strItemCategory  = "";
		HisUtil                   util  = null;	
		try 
		{
			
			 
			 
			         			strCrNo = (String) request.getParameter("crNo");			                
			         	 strFromStoreId = (String) request.getParameter("strStoreId");
			         	strItemCategory = (String) request.getParameter("strCatCode");
			                  storeName = (String) request.getParameter("storeName");
			                itemCatName = (String) request.getParameter("itemCatName");			
			            strHiddenPatDtl = (String) request.getParameter("strHiddenPatDtl"); 	
			      strAdmissionDtlHidVal = (String) request.getParameter("strAdmissionDtlHidVal"); 	
			         
			                         bo = new OPDIssueToPatAutoTransBO();
			                         vo = new OPDIssueToPatAutoTransVO();
			                       util = new HisUtil("MMS Reports", "getNALIst");               
         	formBean.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			formBean.setStrSeatId((String) request.getSession().getAttribute("SEATID")); 
						
			vo.setStrStoreId(strFromStoreId);
			vo.setStrItemCategoryNo(strItemCategory);
			vo.setStrCrNo(strCrNo);			
			vo.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			vo.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
			vo.setStrCurrentDate(util.getASDate("dd-MMM-yyyy  hh:mm"));	
			
			vo.setStrHiddenPatDtl(strHiddenPatDtl);
			/*
			 * Amika Soni Kumar^
			 * HARISH SONI/Suman Koni^
			 * General^
			 * 24 Yr/F^
			 * HN4543,Venue2 24,Noida,Gautam Buddha Nagar,Uttar Pradesh-230230^
			 * All India Institute of Medical Sciences, Mangalagiri^
			 * null^
			 * 9829234234
			 * */
			vo.setStrAdmissionDtlHidVal(strAdmissionDtlHidVal);
			/*
			   ADMNO^
			   EPCODE^
			   VISITNO^
			   ADMDATETIME^
			   ADMADVNO^
			   DEPTCODE^
			   WARDCODE^
			   ROOMCODE^
			   BEDCODE^
			   TREATCATCODE^
			   ISNEWBORN^
			   MOTHERADMNO^
			   MLCNO^
			   OCCUPID^
			   BEDALLOCDATETIME^
			   LENGTHOFSTAY
			*/									
			
			System.out.println("-----IssueToPatientBSDATA.getNALIst ---PKG_MMS_VIEW2.PROC_HRGT_PATIENT_TREATMENT_DTL-[ Mode - 7 ]--");
		
			// Calling BO Method
			bo.getNALIst(vo);
	
			if (vo.getStrMsgType().equals("1")) {
	
				throw new Exception(vo.getStrMsgString());
			}
						
			strSearchItemInitView = OPDIssueToPatAutoTransHLP.getNAList(vo);			
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strSearchItemInitView);
		}
		catch (Exception e) 
		{
		     e.printStackTrace();	 
			 String strmsgText = "IssueToPatientBSDATA.getNALIst(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("IssueDeskTrans",
					"IssueToPatientBSDATA.getNALIst(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;
			  
		} finally {
	
			bo = null;
			vo = null;
		}
	
	}
	


}