package mms.transactions.controller.data;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import billing.BillConfigUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.MmsConfigUtil;
import mms.patDtl.PatientDtlHLP;
import mms.patDtl.PatientDtlHLPNew;
import mms.transactions.bo.InjAdministrationTransBO;
import mms.transactions.controller.fb.InjAdministrationTransFB;
import mms.transactions.controller.hlp.InjAdministrationTransHLP;
import mms.transactions.vo.InjAdministrationTransVO;

public class InjAdministrationTransDATA {

	
public static void getStoreDtls(InjAdministrationTransFB formBean, HttpServletRequest request) 
{
	InjAdministrationTransBO       bo = null;
	InjAdministrationTransVO       vo = null;
	
	HisUtil          util = null;
	
	String    strStoreVal = "" , strItemTypeCmb="";
	String 	    strCatVal = "";
	String     strmsgText = null;
	ResourceBundle resObj = null;
	SimpleDateFormat  sdf = null;
	Calendar           c1 = null;
	
	try 
	{
		               bo = new InjAdministrationTransBO();
		               vo = new InjAdministrationTransVO();
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
		
		
	    /* Item Type Combo */
	    if(vo.getStrItemTypeWs()!=null && vo.getStrItemTypeWs().size()>0)
		{					
	    	strItemTypeCmb = util.getOptionValue(vo.getStrItemTypeWs(),"0","ALL", false);					
		}
		else
		{
			strItemTypeCmb = "<option value='0'>Select Value</option>";
		}
	    
	    formBean.setStrItemTypeCmb(strItemTypeCmb);
		
		vo.setStrReqTypeId("32");
		
		
		strCatVal = "<option value='0'>Select Value</option>";
		
		formBean.setStrCatValues(strCatVal);	
		formBean.setStrOfflineOPDFlag(vo.getStrOfflineOPDFlag());
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
		strmsgText = "mms.transactions.InjAdministrationTransDATA.getStoreDtls --> "
				+ e.getMessage();
		HisException eObj = new HisException("mms",
				"InjAdministrationTransDATA->getStoreDtls()", strmsgText);
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
	
public static int printLine = 0;
	
public static void getViewDtl(InjAdministrationTransFB _InjAdministrationTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   InjAdministrationTransVO vo = null;
		   InjAdministrationTransBO bo = null;
		   HisUtil util = null;
		   String strResult = "";
		   try
		   {
			    /* Creating Object */   	
			    vo=new InjAdministrationTransVO();
			   	bo=new InjAdministrationTransBO();
			   	util = new HisUtil("MMS Transactions", "InjAdministrationTransDATA");
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
			    
			       strResult = InjAdministrationTransHLP.getIssuedDetail(vo.getStrIssueDetailWs());

			    if(strResult!= null && !strResult.equals(""))
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult);
				 		 
				}
				else
				{
				    HisException eObj = new HisException("MMS", "InjAdministrationTransDATA->getViewDtl()", vo.getStrMsgString());
					       String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "InjAdministrationTransDATA->getViewDtl()", strmsgText);
				_InjAdministrationTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//_InjAdministrationTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   finally 
		   {
			    util = null;
				  bo = null;
				  vo = null;
			}
		   
	}
	
	
	public static void getStoreDtlsView(InjAdministrationTransFB formBean, HttpServletRequest request) {

		InjAdministrationTransBO bo       = null;
		InjAdministrationTransVO vo       = null;
		HisUtil util          = null;
		String strStoreVal    = "";
	
		String strmsgText     = null;
		/* C OUT RJ47
		 * ResourceBundle resObj = null; SimpleDateFormat sdf = null; Calendar c1 =
		 * null; String strConfCatCode = "";
		 */
		
		try 
		{
           bo = new InjAdministrationTransBO();
           vo = new InjAdministrationTransVO();
         util = new HisUtil("MMS Transactions", "InjAdministrationTransDATA");	
         
			
			
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
			strmsgText = "mms.transactions.InjAdministrationTransDATA.getStoreDtlsView --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"InjAdministrationTransDATA->getStoreDtlsView()", strmsgText);
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
	
	
	
	public static void getItemCatDtls(InjAdministrationTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		InjAdministrationTransBO bo = null;
		InjAdministrationTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new InjAdministrationTransBO();
			voObj = new InjAdministrationTransVO();
			
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
			util = new HisUtil("MMS Transactions", "InjAdministrationTransDATA");
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
			strmsgText = "mms.transactions.InjAdministrationTransDATA.getItemCatDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"InjAdministrationTransDATA->getItemCatDtls()", strmsgText);
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
	
	public static void GET_PAT_ACC_STATUS(InjAdministrationTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) 
	{

		InjAdministrationTransBO bo = null;
		InjAdministrationTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		String temp = "";
		try {

			bo = new InjAdministrationTransBO();
			voObj = new InjAdministrationTransVO();
			
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
			strmsgText = "mms.transactions.InjAdministrationTransDATA.GET_PAT_ACC_STATUS --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"InjAdministrationTransDATA->GET_PAT_ACC_STATUS()", strmsgText);
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
	public static int getissuetopatientcount(InjAdministrationTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		InjAdministrationTransBO bo = null;
		InjAdministrationTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		int temp =0;
		try {

			bo = new InjAdministrationTransBO();
			voObj = new InjAdministrationTransVO();
			
			voObj.setStrStoreId(formBean.getStrStoreId());
			voObj.setStrItemCat(formBean.getItemCategory());
			voObj.setStrCrNo(formBean.getStrCrNo());
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			
			bo.issueTopatientCount(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "InjAdministrationTransDATA");
			

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
			strmsgText = "mms.transactions.InjAdministrationTransDATA.getItemCatDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"InjAdministrationTransDATA->getItemCatDtls()", strmsgText);
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
	
	public static void getPatientTreatmentAdviceDetails(InjAdministrationTransFB formBean, HttpServletRequest request, 
						HttpServletResponse response) 
	{

		InjAdministrationTransBO bo = null;
		InjAdministrationTransVO vo = null;
		MmsConfigUtil mcu = null;
		HisUtil util = null;
		String strmsgText = null;
		ResourceBundle resObj =  null;
		
		try 
		{
			System.out.println("------------- InjAdministrationTransDATA . getPatientTreatmentAdviceDetails ---------------");
			
			     bo = new InjAdministrationTransBO();
			     vo = new InjAdministrationTransVO();
			    mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   util = new HisUtil("","");
			
			formBean.setStrCtDate(util.getASDate("dd-MMM-yyyy"));
			
			formBean.setStrIssueMode("0");  // Please Check			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());			
			vo.setStrStoreId(formBean.getStrStoreId());			
			if(formBean.getCheckFlg().equals("1"))
			{	
			   System.out.println("---- Search Type - I ----");	
			   vo.setStrCrNo(formBean.getStrCrNo());			   
			   vo.setStrRecommendDate("0");
			   vo.setStrStatus("0");
			   vo.setStrTypeId("0");
			   vo.setCheckFlg(formBean.getCheckFlg());
			   String strSearchStr = formBean.getStrCrNo()+"$0$0$0";
			   formBean.setStrSearchStr(strSearchStr);
			}
			else
			{
			   System.out.println("---- Search Type - II ----");	
			   vo.setStrCrNo("0");	
			   vo.setStrRecommendDate(formBean.getStrRecommendDate());
			   vo.setStrStatus(formBean.getStrStatus());
			   vo.setStrTypeId(formBean.getStrTypeId());
			   vo.setCheckFlg(formBean.getCheckFlg());
			   
			   String strSearchStr = formBean.getStrCrNo()+"$"+formBean.getStrRecommendDate()+"$"+formBean.getStrStatus()+"$0";
			   formBean.setStrSearchStr(strSearchStr);
			   
			}
					
			bo.getPatientTreatmentHLPForIssue(vo);  // PKG_MMS_VIEW2-proc_hrgt_patient_inj_advice_dtl [ Mode - 1]
			/*   PKG_MMS_VIEW2-proc_hrgt_patient_inj_advice_dtl [ Mode - 1]
	    	 * 
	    	 *  1.Hidden Id [ Item_Id ^ Brand_Id]
                2.Brand Name
                3.Req Qty
                4.Item Type
                5.Frequency Name
                6.Dept Name
                7.Dosage Name
                8.Dept_code ^ Episode Code
                9.Stock Combo  { BrandId ^ Batch No ^ In Hand Qty ^ Sale Price ^ Exp Date } 
               10.Advice By
               11.Advice Date
               12.Shivendra ( 25 Yr/Male ) <br> [ 939112400014286 ]  @ 8778755457" 
               13. Issue Qty
               14. BATCH_COUNT
               15. INJ_STATUS
                CASE WHEN TRUNC(ENTRY_DATE) < TRUNC(SYSDATE) AND BATCH_COUNT > 0 THEN ''PENDING''
				     WHEN TRUNC(ENTRY_DATE) = TRUNC(SYSDATE) AND BATCH_COUNT > 0 THEN ''ADMINISTER''
				     WHEN TRUNC(ENTRY_DATE) = TRUNC(SYSDATE) AND BATCH_COUNT = 0 THEN ''NA''
				     WHEN TRUNC(ENTRY_DATE) < TRUNC(SYSDATE) AND BATCH_COUNT = 0 THEN ''NA''      
				     WHEN ISSUE_QTY  = REQ_QTY                    THEN ''ADMINISTERED''  
				END AS INJ_STATUS   
			   16.CR_NO	   
			  */
			System.out.println("------E------- DRUG_LIST_HLP  -------[ InjAdministrationTransHLP.patientInjectioAdministrationDtl() , PKG_MMS_VIEW2.proc_hrgt_patient_inj_advice_dtl [ Mode - 1 ]]--------");
			
			String strIpdIssueDrugHLP =  InjAdministrationTransHLP.patientInjectioAdministrationDtl(vo.getStrItemCat(), vo.getStrHospitalCode(), vo.getTreatmentDtlHLPWs(), "0","0",vo.getStrStoreId(),vo.getStrAdmnModeCombo());
			
			formBean.setStrIpdIssueDrugHLP(strIpdIssueDrugHLP);
			
			System.out.println("------------- InjAdministrationTransDATA . getPatientDetails ------- END --------");
			
			formBean.setStrDoseFrqFlg("0");						
		
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
					
		} catch (Exception e) 
		{
			    e.printStackTrace();
				strmsgText = "mms.transactions.InjAdministrationTransDATA.getPatientDetails --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"InjAdministrationTransDATA->getPatientDetails()", strmsgText);
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
			
			if (mcu != null)
				mcu = null;
			
			if (resObj != null)
				resObj = null;
			
		}
	}
	
	public static void getPatientStatus(InjAdministrationTransFB formBean, HttpServletRequest request, 
			HttpServletResponse response) 
	{

			InjAdministrationTransBO bo = null;
			InjAdministrationTransVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
			ResourceBundle resObj =  null;
			
			try 
			{
			System.out.println("------------- InjAdministrationTransDATA . getPatientDetails ---------------");
			
			     bo = new InjAdministrationTransBO();
			     vo = new InjAdministrationTransVO();
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
			
					
			
			System.out.println("------------- InjAdministrationTransDATA . getPatientStatus ------- END --------");
			
			formBean.setStrDoseFrqFlg("0");
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
					
			}
			catch (Exception e) 
			{
			e.printStackTrace();
			
			System.out.println("---e.getMessage()-----"+e.getMessage());
			
				strmsgText = "mms.transactions.InjAdministrationTransDATA.getPatientDetails --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"InjAdministrationTransDATA->getPatientDetails()", strmsgText);
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
	
	public static void getOnlineReqDtl(InjAdministrationTransFB formBean, HttpServletRequest request, HttpServletResponse response) 
	{

			InjAdministrationTransBO bo = null;
			InjAdministrationTransVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
		
		try 
		{
			 System.out.println(" ------- InjAdministrationTransDATA.getOnlineReqDtl  ------- ");
			 
				bo = new InjAdministrationTransBO();
				vo = new InjAdministrationTransVO();
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
									
				String strReqValues = InjAdministrationTransHLP.getRequestDtls(vo.getStrRequestWs());
				formBean.setStrReqValues(strReqValues);
				formBean.setStrBillingHiddenValue(vo.getStrBillingHiddenValue());
		if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
				
		} catch (Exception e) {
				strmsgText = "mms.transactions.InjAdministrationTransDATA.getOnlineReqDtl --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"InjAdministrationTransDATA->getOnlineReqDtl()", strmsgText);
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
	
	public static void getItemDetails(InjAdministrationTransFB formBean, HttpServletRequest request, 
			HttpServletResponse response ) {

		InjAdministrationTransBO bo = null;
		InjAdministrationTransVO vo = null;
		MmsConfigUtil mcu = null;
		HisUtil util = null;
		String strmsgText = null;
		String strItemDetails ="";
		
		try {
			
			 System.out.println(" ------- InjAdministrationTransDATA.getItemDetails  ------- ");
			 
			bo = new InjAdministrationTransBO();
			vo = new InjAdministrationTransVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			String strIssueMode = mcu.getStrIssueMode();
			formBean.setStrIssueMode(strIssueMode);
						
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrRequestNo(request.getParameter("reqNo"));
			vo.setStrCrNumber(request.getParameter("crNo"));
			vo.setStrStoreId(request.getParameter("strId"));		
			
			bo.getItemDetails(vo);
			
			strItemDetails = InjAdministrationTransHLP.getItemDetails(vo.getStrHospitalCode(),vo.getStrItemDetailWs());
			
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strItemDetails);	
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
				
		} catch (Exception e) {
			strmsgText = "mms.transactions.InjAdministrationTransDATA.getItemDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"InjAdministrationTransDATA->getItemDetails()", strmsgText);
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
	
	public static void getIssuePopUp(InjAdministrationTransFB formBean, HttpServletRequest request, 
						HttpServletResponse response) {
			
			InjAdministrationTransBO bo    = null;
			InjAdministrationTransVO vo    = null;			
			
			String strmsgText  = null;			
			String strStoreId  = "";
			String strIssueNo  = "";
			String strHospCode = "";
			String strPopUp    = "";
			String strCrNo    = "";
			try 
			{
				 System.out.println(" ------- InjAdministrationTransDATA.getIssuePopUp  ------- ");
				 
				   bo = new InjAdministrationTransBO();
				   vo = new InjAdministrationTransVO();							
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
				
				InjAdministrationTransHLP.getIssuePopUpForDotMatrix_V1(strHospCode,strStoreId,strIssueNo,strCrNo,request);												
				String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
				formBean.setStrPrintBill(fileName);
				request.setAttribute("filePath", fileName);
				formBean.setIsOpenPopUp("1");
				
							
			} catch (Exception e) {
				strmsgText = "mms.transactions.InjAdministrationTransDATA.getIssuePopUp --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"InjAdministrationTransDATA->getIssuePopUp()", strmsgText);
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
	
	public static void getIssuePopUp_ORG(InjAdministrationTransFB formBean, HttpServletRequest request, 
			HttpServletResponse response) {

		InjAdministrationTransBO bo    = null;
		InjAdministrationTransVO vo    = null;			
		
		String strmsgText  = null;			
		String strStoreId  = "";
		String strIssueNo  = "";
		String strHospCode = "";
		String strPopUp    = "";
		String strCrNo    = "";
		try 
		{
			 System.out.println(" ------- InjAdministrationTransDATA.getIssuePopUp  ------- ");
			 
			   bo = new InjAdministrationTransBO();
			   vo = new InjAdministrationTransVO();							
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
			strPopUp = InjAdministrationTransHLP.getIssuePopUpBS(strHospCode,strStoreId,strIssueNo,strCrNo);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strPopUp);	
			*/
			
			InjAdministrationTransHLP.getIssuePopUpForDotMatrix(strHospCode,strStoreId,strIssueNo,strCrNo,request);												
			String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
			formBean.setStrPrintBill(fileName);
			request.setAttribute("filePath", fileName);
			formBean.setIsOpenPopUp("1");
			
						
		} catch (Exception e) {
			strmsgText = "mms.transactions.InjAdministrationTransDATA.getIssuePopUp --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"InjAdministrationTransDATA->getIssuePopUp()", strmsgText);
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
	
	public static void getIssueDetails(InjAdministrationTransFB formBean, HttpServletRequest request, HttpServletResponse response)
		{
			
			InjAdministrationTransBO bo = null;
			InjAdministrationTransVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
			String strCurrentDate = "";
			WebRowSet ws = null;
			try {
				 System.out.println(" ------- InjAdministrationTransDATA.getIssueDetails  ------- ");
				util = new HisUtil("mms", "InjAdministrationTransDATA");
				bo = new InjAdministrationTransBO();
				vo = new InjAdministrationTransVO();
				mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				strCurrentDate=util.getASDate("dd-MMM-yyyy");
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				
				vo.setStrStoreId(request.getParameter("strId").split("\\^")[0]);
				//vo.setStrCatCode(request.getParameter("itemCategory"));
				
				vo.setStrCrNum(request.getParameter("crNo"));
				//System.out.println(">>>>>>>>>>>>>>>>>>"+request.getParameter("crNo"));

				vo.setStrFromDate(request.getParameter("fromDate"));
			   	vo.setStrToDate(request.getParameter("ToDate"));
			   	vo.setStrCurrentDate(strCurrentDate);
				vo.setStrIssueNo(request.getParameter("strIssueNo"));
				vo.setStrPrescribedBy(request.getParameter("prescribedBy"));				
				vo.setStrPatStaffDays(mcu.getStrLastIssuePatientStaffInDays());		
				vo.setStrStoreName(request.getParameter("storeName"));
				vo.setAdministerMode(request.getParameter("strAdmnMode"));
				vo.setAdministerType(request.getParameter("strAdmnType"));
				System.out.println("Store Id->"+vo.getStrStoreId());
				System.out.println("Pin->"+vo.getStrCrNum());
				System.out.println("From Date->"+vo.getStrFromDate());
				System.out.println("To Date->"+vo.getStrToDate());
				System.out.println("Store Name->"+vo.getStrStoreName());
				System.out.println("Admn Mode->"+vo.getAdministerMode());
				System.out.println("Admn Type->"+vo.getAdministerType());
				
				
			   	
				// Calling BO Method --issue no issue date & store id 
				bo.getIssueDetail(vo);
				  
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}
				
				ws = vo.getStrIssueDetailWs(); 
				
				if (ws.size() > 0) {
					if (ws.next()) {
						vo.setStrPatientName(ws.getString(2)); 
				  	} 
					ws.beforeFirst();
				}
				else {
					vo.setStrPatientName("N/A");
				}
			/*	while(ws.next())
				{
					System.out.println("ws.strings()"+ws.getString(1));
					System.out.println("ws.strings()"+ws.getString(2));
				//	System.out.println("ws.strings()"+ws.getString(3));
					
				}*/
			
				/* replace HLP method  getIssueDetailsBS >> getPreviousIssueDetails*/
			    String strIssueDetails = InjAdministrationTransHLP.getPreviousIssueDetails(vo,ws);
				
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strIssueDetails);
				
			} catch (Exception e) {
				strmsgText = "mms.transactions.InjAdministrationTransDATA.getIssueDetails --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"InjAdministrationTransDATA->getIssueDetails()", strmsgText);
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
	
	public static void getRequestDetails(InjAdministrationTransFB formBean, HttpServletRequest request, HttpServletResponse response) {

		InjAdministrationTransBO bo = null;
		InjAdministrationTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		WebRowSet ws = null;
		MmsConfigUtil mcu = null;
		
		try {
			 System.out.println(" ------- InjAdministrationTransDATA.getRequestDetails  ------- ");
			 
			bo = new InjAdministrationTransBO();
			vo = new InjAdministrationTransVO();
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
			
			String strRequestDetails=InjAdministrationTransHLP.getRequestDetails(ws);
			
			////System.out.println("strRequestDetails---------->"+strRequestDetails);
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strRequestDetails);
						
		} catch (Exception e) {
			strmsgText = "mms.transactions.InjAdministrationTransDATA.getRequestDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"InjAdministrationTransDATA->getRequestDetails()", strmsgText);
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
	public static void getFrequencyDetails(InjAdministrationTransFB formBean, HttpServletRequest request) {

		InjAdministrationTransBO bo = null;
		InjAdministrationTransVO vo = null;

		HisUtil util = null;
		String strFrequencyVal = "";
		String strmsgText = null;
		
		try {
			bo = new InjAdministrationTransBO();
			vo = new InjAdministrationTransVO();
			util = new HisUtil("MMS Transactions", "InjAdministrationTransDATA");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
						
			bo.getFrequencyDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "InjAdministrationTransDATA");
			
			strFrequencyVal = util.getOptionValue(vo.getStrFrequencyWs(), "0",
					"0^Select Value", false);
						
			formBean.setStrFrequencyValues(strFrequencyVal);
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.InjAdministrationTransDATA.getFrequencyDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"InjAdministrationTransDATA->getFrequencyDetails()", strmsgText);
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
	public static void getDoseDetails(InjAdministrationTransFB formBean, HttpServletRequest request) {

		InjAdministrationTransBO bo = null;
		InjAdministrationTransVO vo = null;

		HisUtil util = null;
		String strDosageVal = "";
		String strmsgText = null;
		
		try {
			bo = new InjAdministrationTransBO();
			vo = new InjAdministrationTransVO();
			util = new HisUtil("MMS Transactions", "InjAdministrationTransDATA");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
						
			bo.getDoseDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "InjAdministrationTransDATA");
			
			strDosageVal = util.getOptionValue(vo.getStrDosageWs(), "0",
					"0^Select Value", false);
			formBean.setStrDosageValues(strDosageVal);
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.InjAdministrationTransDATA.getDoseDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"InjAdministrationTransDATA->getDoseDetails()", strmsgText);
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
	
	public static void getDeptDetails(InjAdministrationTransFB formBean, HttpServletRequest request) {

		InjAdministrationTransBO bo = null;
		InjAdministrationTransVO vo = null;

		HisUtil util = null;
		String strDeptVal = "";
		String strmsgText = null;
		
		try {
			 System.out.println(" ------- InjAdministrationTransDATA.getDeptDetails  ------- ");
			 
			bo = new InjAdministrationTransBO();
			vo = new InjAdministrationTransVO();
			util = new HisUtil("MMS Transactions", "InjAdministrationTransDATA");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.getDeptDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "InjAdministrationTransDATA");
			
			strDeptVal = util.getOptionValue(vo.getStrDepartmentWs(), "","0^Select Value", false);
						
			formBean.setStrDeptValues(strDeptVal);
			formBean.setStrCtDate(util.getASDate("dd-MMM-yyyy"));
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.InjAdministrationTransDATA.getDeptDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"InjAdministrationTransDATA->getDeptDetails()", strmsgText);
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
	
	public static void getUnitDetails(InjAdministrationTransFB formBean, HttpServletRequest request, HttpServletResponse response) {

		InjAdministrationTransBO bo = null;
		InjAdministrationTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		
		try {
			bo = new InjAdministrationTransBO();
			vo = new InjAdministrationTransVO();
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			vo.setStrDeptCode(request.getParameter("deptCode"));
			
			
			bo.getUnitDetails(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "InjAdministrationTransDATA");
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
			strmsgText = "mms.transactions.InjAdministrationTransDATA.getUnitDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"InjAdministrationTransDATA->getUnitDetails()", strmsgText);
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
	
	
	public static void getPrescribedBy(InjAdministrationTransFB formBean, HttpServletRequest request, HttpServletResponse response) {

		InjAdministrationTransBO bo = null;
		InjAdministrationTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		
		try {
			bo = new InjAdministrationTransBO();
			vo = new InjAdministrationTransVO();

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrUnitCode(request.getParameter("unitCode"));
//	System.out.println("vo.getStrUnitCode"+vo.getStrUnitCode());		
			bo.getPrescribedBy(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "InjAdministrationTransDATA");
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
			strmsgText = "mms.transactions.InjAdministrationTransDATA.getPrescribedBy --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"InjAdministrationTransDATA->getPrescribedBy()", strmsgText);
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
			

	public static void getGenderCombo(InjAdministrationTransFB formBean,HttpServletRequest request) 
	{
		InjAdministrationTransBO bo = null;
		InjAdministrationTransVO vo = null;

		HisUtil util = null;
		String strPatientGenderCodeCmbValues = "";
		String strmsgText = null;
		
		try {
			bo = new InjAdministrationTransBO();
			vo = new InjAdministrationTransVO();
			util = new HisUtil("MMS Transactions", "InjAdministrationTransDATA");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.getGenderCombo(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "InjAdministrationTransDATA");
			
			strPatientGenderCodeCmbValues = util.getOptionValue(vo.getStrGenderWs(), "",	"", false);
						
			formBean.setStrPatientGenderCodeCmbValues(strPatientGenderCodeCmbValues);
			
		} catch (Exception e) {
			strmsgText = "mms.transactions.InjAdministrationTransDATA.getDeptDetails --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",	"InjAdministrationTransDATA->getGenderCombo()", strmsgText);
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
		InjAdministrationTransBO bo = new InjAdministrationTransBO();
		InjAdministrationTransVO vo	= new InjAdministrationTransVO();
		HisUtil util =  new HisUtil("MMS Transactions", "InjAdministrationTransDATA");	;
			StringBuffer sb = new StringBuffer("");
			vo.setStrCrNo(strCrNo);
			vo.setStrHospitalCode(strHospitalCode);
			
			WebRowSet ws = null;
			String diagName;
			
			sb.append("");
			
			try 
			{
				 System.out.println(" ------- InjAdministrationTransDATA.patientDiagDtl  ------- ");
				 
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


	
	
	
	public static void getOnlineTreatmentDtl(InjAdministrationTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{
	
			InjAdministrationTransBO bo = null;
			InjAdministrationTransVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
		
		try 
		{
			    System.out.println(" ------- InjAdministrationTransDATA.getOnlineTreatmentDtl  ------- ");
				bo = new InjAdministrationTransBO();
				vo = new InjAdministrationTransVO();
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
				String strReqValues = InjAdministrationTransHLP.getOnlineTreatmentDtls(vo.getOnlineTreatmentDtlsWs() , formBean);
				formBean.setStrOnlineTreatment(strReqValues);
				
				
				
				formBean.setStrRowCount(String.valueOf(rowcount));
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strReqValues + "##" + String.valueOf(rowcount)+"##");
				
		if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
				
		} catch (Exception e) {
				e.printStackTrace();
				strmsgText = "mms.transactions.InjAdministrationTransDATA.getOnlineReqDtl --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"InjAdministrationTransDATA->getOnlineReqDtl()", strmsgText);
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
	
		

	public static void getAlreadyIssueDrug(InjAdministrationTransFB formBean,HttpServletRequest request,HttpServletResponse response)
	{
	
	
		InjAdministrationTransBO bo = null;
		InjAdministrationTransVO vo = null;
		MmsConfigUtil mcu = null;
		HisUtil util = null;
		String strmsgText = null;
	
	try 
	{
		System.out.println(" ------- InjAdministrationTransDATA.getAlreadyIssueDrug  ------- ");
		
			bo = new InjAdministrationTransBO();
			vo = new InjAdministrationTransVO();
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
			strmsgText = "mms.transactions.InjAdministrationTransDATA.getOnlineReqDtl --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"InjAdministrationTransDATA->getOnlineReqDtl()", strmsgText);
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

  public static void getDiirecIssueInitData(InjAdministrationTransFB formBean, HttpServletRequest request,HttpServletResponse response) 
  {
	// TODO Auto-generated method stub
	
	   InjAdministrationTransVO vo = null;
	   InjAdministrationTransBO bo = null;
	   HisUtil util = null;
	   String strCatVal=null;
	   String strStoreVal=null;
	   String strPayModeVal=null;
	   String strAdmDtl=null;
	   String strIssueByCombo=null;
	   try
	   {
	    	 
	    	    System.out.println(" ------- InjAdministrationTransDATA.getDiirecIssueInitData  ------- ");
	    	 	vo=new InjAdministrationTransVO();
			   	bo=new InjAdministrationTransBO();
			   	util = new HisUtil("MMS Transactions", "InjAdministrationTransDATA");
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
			HisException eObj = new HisException("MMS", "InjAdministrationTransDATA->getTariffDtl()", _err.getMessage());
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





public static void getPresFormDtl(InjAdministrationTransFB fb, HttpServletRequest request, HttpServletResponse response) {
	// TODO Auto-generated method stub
	InjAdministrationTransBO bo = null;
	InjAdministrationTransVO voObj = null;
	HisUtil util = null;

	try
	{

		bo = new InjAdministrationTransBO();
		voObj = new InjAdministrationTransVO();

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

	public static void afterIssueSave(InjAdministrationTransFB fb,HttpServletRequest request)
	{
	
		InjAdministrationTransBO bo = null;
		InjAdministrationTransVO vo = null;
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
			System.out.println("************** InjAdministrationTransDATA --> afterIssueSave()  **********CHK****"+request.getParameter("chk"));
			
				bo = new InjAdministrationTransBO();
				vo = new InjAdministrationTransVO();
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
				System.out.println("-PIN ----"+vo.getStrPuk());
				
				
				
				/* vo.getStrPatientDtlHidVal()
	              HRGDT_DOB || ''^'' ||GNUM_GENDER_CODE ||''^''||HGNUM_PAT_STATUS_CODE || ''^''||
		          HGNUM_PATIENT_CAT_CODE || ''^'' ||HRGNUM_IS_MLC    ||''^''||HRGNUM_ISNEWBORN      || ''^''|| HRGNUM_ID_NO
				*/
				
								
				strRequestTypeId="32";
				
				System.out.println("************** InjAdministrationTransDATA --> afterIssueSave() --> PatientDtlHLP.patientWithAdmissionDtl **************");
	
				strPatientDtl=PatientDtlHLP.patientWithAdmissionDtl(fb.getStrCrNo(), hosCode, true);
				
				System.out.println("*************************************************");
	
			   vo.setStrPatientDtl(strPatientDtl);
			   vo.setStrHospitalCode(hosCode);			
			   bo.getImgHeader(vo);
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
			 
			String strAfterSaveVoucher = InjAdministrationTransHLP.getAfterSaveVoucher(vo,"1");	
			
			fb.setStrAfterSaveVoucher(strAfterSaveVoucher);
			
			System.out.println("---strAfterSaveVoucher  ----"+strAfterSaveVoucher);
			
			
		} catch (Exception e) {
	
			e.printStackTrace();
			strmsgText = "Issue Desk.InjAdministrationTransDATA.getInitDetailForIssuePage(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"InjAdministrationTransDATA->getIndentDetails()", strmsgText);
			fb.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
	
			eObj = null;
		} finally {
			bo = null;
			vo = null;
	
		}
	
	}
	
	
	
	public static void NEW_OPD_ISSUE_INSERT(InjAdministrationTransFB formBean, HttpServletRequest request) 
	 {

		InjAdministrationTransBO bo = null;
		InjAdministrationTransVO vo = null;

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
			
			System.out.println("-------------- InjAdministrationTransDATA . NEW_OPD_ISSUE_INSERT --------------");
			
			debugPoint = 1;
			bo = new InjAdministrationTransBO();
			vo = new InjAdministrationTransVO();
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
			System.out.println("-formBean.getStrIssueQty().length--"+formBean.getStrIssueQty().length);
			for (int i = 0; i < formBean.getStrIssueQty().length; i++) 
			{
			
			System.out.println("-formBean.getStrIssueQty--"+i+"---"+formBean.getStrIssueQty()[i]);
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
			vo.setStrDeptPKey(formBean.getStrDeptPKey());			
			
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
			  
			   '2 $'||v_patient_status_code||'$'||v_reg_cat_code||'$'||'IPD Patient PIN ['||crno||'] Not Allowed !!';
			   
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
										
					InjAdministrationTransHLP.getIssuePopUpForDotMatrix_V1(vo.getStrHospitalCode(),vo.getStrStoreId(),vo.getStrIssueNumber(),vo.getStrPuk(),request);												
					String fileName = HisUtil.getParameterFromHisPathXML("TEMP_PATH")+ "/"+ "Billing"+ request.getSession().getAttribute("SEATID").toString() + ".dat";
					formBean.setStrPrintBill(fileName);
					request.setAttribute("filePath", fileName);
					formBean.setIsOpenPopUp("1");
					
					
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.InjAdministrationTransDATA.insertWithoutCrNo()--> "+e.getMessage() + String.valueOf(" :: Debug Point = " + debugPoint);
			
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
	
	
	public static void saveInjAdministratedDtl_Ajax(InjAdministrationTransFB fb,HttpServletRequest request, HttpServletResponse response)
	{
	
		InjAdministrationTransBO bo = null;
		InjAdministrationTransVO vo = null;
		String strPatientDtl="";
		String strmsgText = "";
		String strRequestTypeId="";
		String strRaisingReqTypeId="";
		String strIssueItemId="";
		String strRequestDtl="";
		String strChk="";
		String temp[]=null;
		String strHospitalCode="";
		String strRequestItemDtl="";
		
		MmsConfigUtil mmsConfig=null;
		String strCostReq="";
		StringBuffer buff=null;
		BillConfigUtil billConfig=null;
		String RaisingStoreId="RaisingStoreI";
		String strIpdIssueDrugHLP = "";
		try 
		{
			System.out.println("************** InjAdministrationTransDATA --> saveInjAdministratedDtl_Ajax()  **********CHK****"+request.getParameter("chk"));
			
				bo = new InjAdministrationTransBO();
				vo = new InjAdministrationTransVO();
				strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();		
						
				String  	itemParamValue 			= (String) request.getParameter("itemParamValue");  // Item_Id ^ Brand_Id ^ CR NO
			   	String  	strStoreId    			= (String) request.getParameter("strId");
			   	String  	selectedBatchDetails	= (String) request.getParameter("selectedBatchDetails");  // BrandId ^ Batch No ^ In Hand Qty ^ Sale Price ^ Exp Date
			   	String  	issueQty 				= (String) request.getParameter("issueQty");
				String  	checkFlg 				= (String) request.getParameter("checkFlg");      // 1 - C R No Wise Search , 2 - Date Wise , Status Wise , Type Wise Search
				String  	strSearchStr			= (String) request.getParameter("strSearchStr");  // CR NO  $  RecommendDate $  StrStatus $ StrTypeId 
				String  	admType					= (String) request.getParameter("admType");
				String  	administerMode					= (String) request.getParameter("administerMode");
				String  	administerType					= (String) request.getParameter("administerType");
				String  	strDoses					= (String) request.getParameter("strDoses");
				
			   	
			   	String        itemParamValueArray[] = new String[1];
			   	String              issueQtyArray[] = new String[1];
				String  selectedBatchDetailsArray[] = new String[1]; 
			   	
				System.out.println("-itemParamValue----"+itemParamValue);
				System.out.println("-Store Id ----"+strStoreId);
				System.out.println("-SelectedBatchDetails ----"+selectedBatchDetails);
				System.out.println("-StrIssueQty ----"+issueQty);
				System.out.println("-StrAdministerType ----"+admType);
				System.out.println("-administerMode ----"+administerMode);
				System.out.println("-administerType ----"+administerType);
				System.out.println("-strDoses ----"+strDoses);
				
				vo.setStrStoreId(strStoreId);
				vo.setStrCrNo(itemParamValue.split("\\^")[2]);
				vo.setStrHospitalCode(strHospitalCode);
				
				itemParamValueArray[0] = itemParamValue;
		  		      issueQtyArray[0] = issueQty;
		  selectedBatchDetailsArray[0] = selectedBatchDetails;
				     
				     
				vo.setStrIssueQty(issueQtyArray);     
				vo.setItemParamValue(itemParamValueArray);
				vo.setItemUserValue(selectedBatchDetailsArray);
				vo.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
				vo.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
				vo.setStrAdministerType(admType);
				vo.setAdministerMode(administerMode);
				vo.setAdministerType(administerType);
				vo.setStrDoses(strDoses);
				vo.setCheckFlg(checkFlg);
				
			    bo.saveInjAdministratedDtl_Ajax(vo);  // pkg_mms_view.Proc_Emp_Issue_Detail [ Mode - 3 ]
			
			if (vo.getStrMsgType().equals("1")) 
			{	
				
				throw new Exception(vo.getStrMsgString());
				
				
			}
			else
			{
				  	checkFlg 				= (String) request.getParameter("checkFlg");       // 1 - C R No Wise Search , 2 - Date Wise , Status Wise , Type Wise Search
				  	strSearchStr			= (String) request.getParameter("strSearchStr");   // CR NO  $  RecommendDate $  StrStatus $ StrTypeId 
				  	
	
				  	vo.setCheckFlg(checkFlg);
				    vo.setStrSearchStr(strSearchStr);
				
				    bo.getPatientTreatmentHLP_AfterSave(vo);  // PKG_MMS_VIEW2-proc_hrgt_patient_inj_advice_dtl [ Mode - 1]
					/*   PKG_MMS_VIEW2-proc_hrgt_patient_inj_advice_dtl [ Mode - 1]
			    	 * 
			    	 *  1.Hidden Id [ Item_Id ^ Brand_Id]
		                2.Brand Name
		                3.Req Qty
		                4.Item Type
		                5.Frequency Name
		                6.Dept Name
		                7.Dosage Name
		                8.Dept_code ^ Episode Code
		                9.Stock Combo  { BrandId ^ Batch No ^ In Hand Qty ^ Sale Price ^ Exp Date } 
		               10.Advice By
		               11.Advice Date
		               12.Shivendra ( 25 Yr/Male ) <br> [ 939112400014286 ]  @ 8778755457" 
		               13. Issue Qty
		               14. BATCH_COUNT
		               15. INJ_STATUS
		                CASE WHEN ROUND(ISSUE_QTY)  = ROUND(REQ_QTY)                    				             THEN ''ADMINISTERED'' 
					     WHEN TRUNC(ENTRY_DATE) < TRUNC(SYSDATE) AND BATCH_COUNT > 0 AND  REQ_QTY > ISSUE_QTY                    THEN ''PENDING''
					     WHEN TRUNC(ENTRY_DATE) = TRUNC(SYSDATE) AND BATCH_COUNT > 0 AND  REQ_QTY > ISSUE_QTY                    THEN ''ADMINISTER''
					     WHEN TRUNC(ENTRY_DATE) = TRUNC(SYSDATE) AND BATCH_COUNT = 0 			  		     THEN ''NA''
					     WHEN TRUNC(ENTRY_DATE) < TRUNC(SYSDATE) AND BATCH_COUNT = 0 			                     THEN ''NA''    
					   16.CR_NO	   
					  */
				      System.out.println("------E------- DRUG_LIST_HLP  -------[ InjAdministrationTransHLP.patientInjectioAdministrationDtl() , PKG_MMS_VIEW2.PROC_HRGT_PATIENT_TREATMENT_DTL [ Mode - 8 ]]--------");
				
				      strIpdIssueDrugHLP =  InjAdministrationTransHLP.patientInjectioAdministrationDtl(vo.getStrItemCat(), vo.getStrHospitalCode(), vo.getTreatmentDtlHLPWs(), "0","0",vo.getStrStoreId(),vo.getStrAdmnModeCombo());
					
			}		
				 			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strIpdIssueDrugHLP);

		} catch (Exception e)
		{
			//998## Not Valid OPD Patient Mr.Khad Test!!
			strmsgText = e.getMessage().split("\\##")[1];
			response.setHeader("Cache-Control", "no-cache");
			try 
			{
				HisException eObj = new HisException("Global Mms File",	"mms.global.controller.getMmsListingDtls()", strmsgText);
				String response1 = "Application Error [ERROR ID : "+ eObj.getErrorID()+ "], "+strmsgText+"!";
				
				StringBuffer str = new StringBuffer("");
				
				str.append("<table class='table'>");
				str.append("<thead>");
				str.append("<tr>");
				str.append("<th  style='width:100%;text-align: center;color: black;'><b>"+response1+"</b></th>");
				str.append("</tr>");
				str.append("</thead>");
				
				response.getWriter().print(str.toString());
				eObj = null;
			} 
			catch (IOException e1) 
			{
				// //System.out.println("Inside IInd Else::::"+e1.getMessage());
			}
			
			strmsgText = e.getMessage();
			new HisException("mms", "InjAdministrationTransDATA->saveInjAdministratedDtl_Ajax()", strmsgText);

		} finally
		{
		    bo = null;
			vo = null;			
		}
	}
	
	public static void getInjAdministratedDtl_Ajax(InjAdministrationTransFB fb,HttpServletRequest request, HttpServletResponse response)
	{
		HisUtil hisutil = null;
		InjAdministrationTransBO bo = null;
		InjAdministrationTransVO vo = null;
		String strPatientDtl="";
		String strmsgText = "";
		String strRequestTypeId="";
		String strRaisingReqTypeId="";
		String strIssueItemId="";
		String strRequestDtl="";
		String strChk="";
		String temp[]=null;
		String strHospitalCode="";
		String strRequestItemDtl="";
		
		MmsConfigUtil mmsConfig=null;
		String strCostReq="";
		StringBuffer buff=null;
		BillConfigUtil billConfig=null;
		String RaisingStoreId="RaisingStoreI";
		String strAdministratedDetailsHLP = "";
		String strCurrentDate = "";
		try 
		{
			System.out.println("************** InjAdministrationTransDATA --> getInjAdministratedDtl_Ajax()  **************");
				hisutil = new HisUtil("mms", "InjAdministrationTransDATA");
				bo = new InjAdministrationTransBO();
				vo = new InjAdministrationTransVO();
				strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();		
				strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
				String itemParamValue = (String) request.getParameter("itemParamValue");  // Item_Id ^ Brand_Id ^ CR NO
				String strStoreId     = (String) request.getParameter("strId");
				String storeName     = (String) request.getParameter("storeName");
				String checkFlg     = (String) request.getParameter("checkFlg");
				String strSearchStr     = (String) request.getParameter("strSearchStr");
		
				String itemParamValueArray[] = new String[1];
			   	
				System.out.println("-itemParamValue----"+itemParamValue);
				System.out.println("-strStoreId----"+strStoreId);
				System.out.println("-strStoreName----"+storeName);
				System.out.println("-checkFlg----"+checkFlg);
				System.out.println("-strSearchStr----"+strSearchStr);
				
				vo.setStrCrNo(itemParamValue.split("\\^")[2]);
				vo.setStrHospitalCode(strHospitalCode);
				vo.setStrStoreId(strStoreId);
				vo.setStrStoreName(storeName);
				vo.setStrCurrentDate(strCurrentDate);
				vo.setCheckFlg(checkFlg);
				vo.setStrSearchStr(strSearchStr);
				
				itemParamValueArray[0] = itemParamValue;
				
				vo.setItemParamValue(itemParamValueArray);
				     
				vo.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
				vo.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
			  
			    bo.getInjAdministratedDtl_Ajax(vo);  // pkg_mms_view2.proc_hrgt_patient_inj_advice_dtl [ Mode - 2 ]
			    
			    if (vo.getStrMsgType().equals("1")) 
				{	
					throw new Exception(vo.getStrMsgString());
				}
				else
				{
					strAdministratedDetailsHLP =  InjAdministrationTransHLP.patientInjectioAdministratedDtl(vo,vo.getStrItemCat(), vo.getStrHospitalCode(), vo.getAdministratedDetailWs(), "0","0",vo.getStrStoreId());
					
				}
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strAdministratedDetailsHLP);

		} catch (Exception e)
		{
			strmsgText = e.getMessage();
			new HisException("MMS", "InjAdministrationTransDATA->getInjAdministratedDtl_Ajax()", strmsgText);

		} finally
		{
		    bo = null;
			vo = null;			
		}
	}
	
	public static void reloadAdministrationDtl_Ajax(InjAdministrationTransFB fb,HttpServletRequest request, HttpServletResponse response)
	{
		HisUtil hisutil = null;
		InjAdministrationTransBO bo = null;
		InjAdministrationTransVO vo = null;
		String strPatientDtl="";
		String strmsgText = "";
		String strRequestTypeId="";
		String strRaisingReqTypeId="";
		String strIssueItemId="";
		String strRequestDtl="";
		String strChk="";
		String temp[]=null;
		String strHospitalCode="";
		String strRequestItemDtl="";
		
		MmsConfigUtil mmsConfig=null;
		String strCostReq="";
		StringBuffer buff=null;
		BillConfigUtil billConfig=null;
		String RaisingStoreId="RaisingStoreI";
		String strAdministratedDetailsHLP = "";
		String strCurrentDate = "";
		try 
		{
			System.out.println("************** InjAdministrationTransDATA --> reloadAdministrationDtl_Ajax()  **************");
				hisutil = new HisUtil("mms", "InjAdministrationTransDATA");
				bo = new InjAdministrationTransBO();
				vo = new InjAdministrationTransVO();
				strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();		
				strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
				//checkFlg="+checkFlg+"&strSearchStr="+strSearchStr+"&storeId="+storeId; 
				String strStoreId     = (String) request.getParameter("storeId");
				String checkFlg     = (String) request.getParameter("checkFlg");
				String strSearchStr     = (String) request.getParameter("strSearchStr");
				
				System.out.println("first->"+strSearchStr.split("\\$")[1]);
				vo.setStrStoreId(strStoreId);
				if(checkFlg.equals("1"))
				{	
				   System.out.println("---- Search Type - I ----");	
				   vo.setStrCrNo(strSearchStr.split("\\$")[0]);			   
				   vo.setStrRecommendDate("0");
				   vo.setStrStatus("0");
				   vo.setStrTypeId("0");
				}
				else
				{
				   System.out.println("---- Search Type - II ----");	
				   vo.setStrCrNo("0");	
				   vo.setStrRecommendDate(strSearchStr.split("\\$")[1]);
				   vo.setStrStatus(strSearchStr.split("\\$")[2]);
				   vo.setStrTypeId(strSearchStr.split("\\$")[3]);
				   
				}
			/*
			 * String itemParamValueArray[] = new String[1];
			 * 
			 * System.out.println("-itemParamValue----"+itemParamValue);
			 * System.out.println("-strStoreId----"+strStoreId);
			 * System.out.println("-strStoreName----"+storeName);
			 * System.out.println("-checkFlg----"+checkFlg);
			 * System.out.println("-strSearchStr----"+strSearchStr);
			 * 
			 * vo.setStrCrNo(itemParamValue.split("\\^")[2]);
			 * vo.setStrHospitalCode(strHospitalCode); vo.setStrStoreId(strStoreId);
			 * vo.setStrStoreName(storeName); vo.setStrCurrentDate(strCurrentDate);
			 * vo.setCheckFlg(checkFlg); vo.setStrSearchStr(strSearchStr);
			 * 
			 * itemParamValueArray[0] = itemParamValue;
			 * 
			 * vo.setItemParamValue(itemParamValueArray);
			 */
				     
				vo.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
				vo.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
			  
				bo.getPatientTreatmentHLPForIssue(vo);
			    String strIpdIssueDrugHLP="";
			    if (vo.getStrMsgType().equals("1")) 
				{	
					throw new Exception(vo.getStrMsgString());
				}
				else
				{
					strIpdIssueDrugHLP =  InjAdministrationTransHLP.patientInjectioAdministrationDtl(vo.getStrItemCat(), vo.getStrHospitalCode(), vo.getTreatmentDtlHLPWs(), "0","0",vo.getStrStoreId(),vo.getStrAdmnModeCombo());
					
				}
			    fb.setStrIpdIssueDrugHLP(strIpdIssueDrugHLP);
				System.out.println("hlp output string->>"+strIpdIssueDrugHLP);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strIpdIssueDrugHLP);

		} catch (Exception e)
		{
			strmsgText = e.getMessage();
			new HisException("MMS", "InjAdministrationTransDATA->reloadAdministrationDtl_Ajax()", strmsgText);

		} finally
		{
		    bo = null;
			vo = null;			
		}
	}
	
	
	public static void getAdministerModeCombo(InjAdministrationTransFB formBean, HttpServletRequest request) {

		InjAdministrationTransBO bo       = null;
		InjAdministrationTransVO vo       = null;
		HisUtil util          = null;
		String strAdmnModeVal    = "";
	
		String strmsgText     = null;
		/* C OUT RJ47
		 * ResourceBundle resObj = null; SimpleDateFormat sdf = null; Calendar c1 =
		 * null; String strConfCatCode = "";
		 */
		
		try 
		{
           bo = new InjAdministrationTransBO();
           vo = new InjAdministrationTransVO();
         util = new HisUtil("MMS Transactions", "InjAdministrationTransDATA");	
         
			
			
			if(request.getParameter("mode") != null)
			{
				String strMode = request.getParameter("mode");
				formBean.setStrMode(strMode);
			}
			
			vo.setStrMode(formBean.getStrMode());
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			// Calling Bo Method
			bo.getAdministerModeCombo(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			strAdmnModeVal = "<option value='0'>All</option>";
			
			if(vo.getStrAdmnModeCombo()!=null && !vo.getStrAdmnModeCombo().equals(""))
			{
				strAdmnModeVal+=vo.getStrAdmnModeCombo();
			}
						
			formBean.setStrAdmnModeCombo(strAdmnModeVal);            			
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.InjAdministrationTransDATA.getAdministerModeCombo --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"InjAdministrationTransDATA->getAdministerModeCombo()", strmsgText);
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
	
		


}