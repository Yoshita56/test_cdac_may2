/**
 * 
 */
package mms.transactions.controller.data;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.MmsConfigUtil;
import mms.patDtl.PatientDtlHLP;
import mms.transactions.bo.ReturnFromTransBO;
import mms.transactions.controller.fb.ReturnFromTransFB;
import mms.transactions.controller.hlp.ReturnFromTransHLP;
import mms.transactions.vo.ReturnFromTransVO;

/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Date : 23/April/2009
 * Mod Date : 11/June/2009
 * 
 */
public class ReturnFromTransDATA {

	//Change Request
	public static void getMmsConfigFlags(ReturnFromTransFB formBean, HttpServletRequest request, 
			HttpServletResponse response) 
	{

				formBean.setStrWithOutCrNoFlg("1");
				formBean.setStrCrNoDefault("1");
//				formBean.setStrDoseFrqFlg(mcu.getStrDoseFrqFlg());
	}
	
	public static void storeName(ReturnFromTransFB formBean,HttpServletRequest request) {
		ReturnFromTransVO vo=null;
		ReturnFromTransBO bo= null;
		HisUtil hisutil = null;
		String strCmb = "";
		String strStoreComboId ="";
		String strCategoryValues ="";
		
		
		try {
			System.out.println("------------ ReturnFromTransDATA .issueNoCombo  ------------");
			
			vo = new ReturnFromTransVO();
			bo = new ReturnFromTransBO();
			
			String strConfCatCode = MmsConfigUtil.STAFF_CAT_CODE;
			formBean.setStrConfCatCode(strConfCatCode);
			vo.setStrConfCatCode(strConfCatCode);//12

			
			hisutil = new HisUtil("mms", "ReturnFromTransDATA");
						
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();
			String strMode = request.getParameter("mode");
					System.out.println("strMode-->"+strMode);
					System.out.println("hosCode-->"+hosCode);
					System.out.println("seatid-->"+seatid);

			formBean.setStrMode(strMode);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			
			bo.storeName(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			/* Changed By Niharika Srivastava on 21-sep-2010*/
			
			
						
			if(vo.getStoreNameWS()!= null
					&& vo.getStoreNameWS().size() > 0){
				if(vo.getStoreNameWS().next())
				{
				vo.setStrStoreId(vo.getStoreNameWS().getString(1));
				formBean.setStrStoreId(vo.getStoreNameWS().getString(1));
				vo.getStoreNameWS().beforeFirst();
				}
			    strCmb = hisutil.getOptionValue(vo.getStoreNameWS(),(formBean.getStrId()!=null && !formBean.getStrId().equals(""))?formBean.getStrId():"" , "", true);
			}
			else
			{
				strCmb = "<option value='0'>Select Value</option>";
			}
			formBean.setStrStoreNameCombo(strCmb);
			
						
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "ReturnFromTransDATA->storeName()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
		}
	}
	
	public static void itemCategory(ReturnFromTransFB formBean,	HttpServletRequest request,HttpServletResponse response)
	{
		
			
			String strmsgText = "";
			ReturnFromTransVO vo=null;
			ReturnFromTransBO bo= null;
			HisUtil hisutil = null;	
				String strHospitalCode = "";  
				String storeId = "";
				String mode = "";
				String itemCatCmb = "";
			
				try {
					System.out.println("------------ ReturnFromTransDATA .itemCategory  ------------");
		
					bo = new ReturnFromTransBO();
					vo = new ReturnFromTransVO();
					
					strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
					storeId =(String) request.getParameter("storeid");
					mode = (String) request.getParameter("modeVal");
					
					System.out.println("modeVal"+mode);
					if (storeId == null) {
							storeId = "0";
					}
					vo.setStrHospitalCode(strHospitalCode);
					vo.setStrStoreId(storeId);
					/*
					if(mode.equals("0")){
						vo.setStrReqTypeId("41");
					}else if(mode.equals("1")){
						vo.setStrReqTypeId("42");
					}else if(mode.equals("2")){
							vo.setStrReqTypeId("41");
					}
					*/
					
					vo.setStrReqTypeId("41");  // Return From Patient
					
					bo.getItemCategory(vo);
					
					if (vo.getStrMsgType().equals("1"))
					{
						throw new Exception(vo.getStrMsgString());
					} 
					
					hisutil = new HisUtil("mms", "ReturnFromTransDATA");
					
					if(vo.getItemCategoryWS()!= null
							&& vo.getItemCategoryWS().size() > 0){
					    itemCatCmb = hisutil.getOptionValue(vo.getItemCategoryWS(),"10", "", false);
					}else{
						itemCatCmb = "<option value='0'>Select Value</option>";
					}
						
					try {									
						    response.setHeader("Cache-Control", "no-cache");
							response.getWriter().print(itemCatCmb);
							
					}catch(Exception e){
						}
				
				} catch (Exception e) {
					strmsgText = "transactions.ReturnFromTransDATA.itemCategory(vo) --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"ReturnFromTransDATA->itemCategory()", strmsgText);
				try {
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(
							"ERROR#### Application Error [ERROR ID : "
									+ eObj.getErrorID()
									+ "],Contact System Administrator! ");
		
				} catch (Exception e1) {
						
					}
				
					eObj = null;
				} finally {
					vo = null;
					bo = null;
					hisutil = null;
				}
	}
	
	public static boolean patientDetail(ReturnFromTransFB formBean,
			HttpServletRequest request){

		boolean fRes = true;
		
		ReturnFromTransVO vo=null;
		ReturnFromTransBO bo= null;
		MmsConfigUtil mcu = null;
			HisUtil hisutil = null;
			String strmsgText = null;
			String strPatientDetailhlp = "";
					
				try {
					System.out.println("------------ ReturnFromTransDATA .patientDetail  ------------");
					
					bo = new ReturnFromTransBO();
					vo = new ReturnFromTransVO();
					mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
									
					String strIssueMode = mcu.getStrIssueMode();
					formBean.setStrIssueMode(strIssueMode);
					
					formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					
					vo.setStrHospitalCode(formBean.getStrHospitalCode());
					vo.setStrSeatId(formBean.getStrSeatId());
					
					try
					{
						System.out.println("------------ PatientDtlHLP .patientWithAdmissionDtl  ------------");
						strPatientDetailhlp = hisglobal.tools.hlp.PatientDtlHLP.patientWithAdmissionDtl(formBean.getStrCrNo(), formBean.getStrHospitalCode(), true);
						
					 }
					catch(Exception e)
					{							
							throw new Exception("Invalid C.R. No.");
							
					 }
						
					formBean.setStrPatientDetail(strPatientDetailhlp);
					
					recommendedBy(formBean,request);
					
					issueNoCombo(formBean, request);
					
					if (vo.getStrMsgType().equals("1")) {
						throw new Exception(vo.getStrMsgString());
					}
					
					
				} 
				catch (Exception e) 
				{
					
			         if(e.getMessage().contains("C.R."))
			         {
			         		
		         		 formBean.setStrErr("Invalid CR. No.");
		         		
		         	}
			         else
			         {
		         		
		         		strmsgText = "ReturnFromTransDATA.patientDetail(vo) --> "+ e.getMessage();
				        HisException eObj = new HisException("mms","ReturnFromTransDATA->patientDetail()", strmsgText);
		         		
				        formBean.setStrErr("Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");
		         		
		         		eObj = null;
		         	}
		        
		        	
		         
		         fRes = false;
		         
				 
				} finally {
					
					if (bo != null)bo = null;
					if (vo != null)vo = null;
					if (hisutil != null)hisutil = null;
				}
				
				return fRes;
		}

	public static boolean patientDetailNEW(ReturnFromTransFB formBean,
			HttpServletRequest request){

		boolean fRes = true;
		
		ReturnFromTransVO vo=null;
		ReturnFromTransBO bo= null;
		MmsConfigUtil mcu = null;
			HisUtil hisutil = null;
			String strmsgText = null;
			String strPatientDetailhlp = "";
					
				try {
					System.out.println("------------ ReturnFromTransDATA .patientDetailNEW  ------------");
					
					bo = new ReturnFromTransBO();
					vo = new ReturnFromTransVO();
					mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					System.out.println("------------ HOSPITAL_CODE------------>"+mcu);

					String strIssueMode = mcu.getStrIssueMode();
					formBean.setStrIssueMode(strIssueMode);
					System.out.println("------------ strIssueMode------------>"+strIssueMode);

					formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					System.out.println("------------ HOSPITAL_CODE------------>"+request.getSession().getAttribute("HOSPITAL_CODE").toString());

					vo.setStrHospitalCode(formBean.getStrHospitalCode());
					vo.setStrSeatId(formBean.getStrSeatId());
					
					try
					{
						System.out.println("------------ PatientDtlHLP .patientWithAdmissionDtlNEW  ------------");
						
						strPatientDetailhlp = hisglobal.tools.hlp.PatientDtlHLP.patientWithAdmissionDtlNEW(formBean.getStrCrNo(), formBean.getStrHospitalCode(), true);
						
					 }
					catch(Exception e)
					{							
							throw new Exception("Invalid C.R. No.");
							
					 }
						
					formBean.setStrPatientDetail(strPatientDetailhlp);
					
					recommendedBy(formBean,request);
					
					issueNoCombo(formBean, request);
					
					if (vo.getStrMsgType().equals("1")) {
						throw new Exception(vo.getStrMsgString());
					}
					
					
				} 
				catch (Exception e) 
				{
			         if(e.getMessage().contains("C.R."))
			         {
		         		 formBean.setStrErr("Invalid CR. No.");
		         	 }
			         else
			         {
		         		strmsgText = "ReturnFromTransDATA.patientDetail(vo) --> "+ e.getMessage();
				        HisException eObj = new HisException("mms","ReturnFromTransDATA->patientDetail()", strmsgText);
				        formBean.setStrErr("Application Error [ERROR ID : "+ eObj.getErrorID()+ "],Contact System Administrator! ");
		         		eObj = null;
		         	}
		         fRes = false;
				} finally {
					
					if (bo != null)bo = null;
					if (vo != null)vo = null;
					if (hisutil != null)hisutil = null;
				}
				return fRes;
		}

	public static void issueNoCombo(ReturnFromTransFB formBean,HttpServletRequest request) 
	{
		ReturnFromTransVO vo=null;
		ReturnFromTransBO bo= null;
		String strmsgText = "";
		
		MmsConfigUtil mcu = null;
		String hosCode = "";
		String seatId  = "";
		String strIssueCmb = "";
		String strStoreId = "";
		String strCatNo = "";
		String strCrNo = "";
		String mode = "";
		HisUtil hisutil = null;
		
		
		try 
		{
			System.out.println("------------ ReturnFromTransDATA .issueNoCombo  ------------");
			
			bo = new ReturnFromTransBO();
			vo = new ReturnFromTransVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			hisutil = new HisUtil("","");
			
            hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatId = request.getSession().getAttribute("SEATID").toString();
			
			strStoreId = request.getParameter("strId");
			strCatNo = request.getParameter("itemCategory");
			strCrNo = request.getParameter("crNo");
			mode = request.getParameter("strMode");
			
			System.out.println("strStoreId-->"+strStoreId);
			System.out.println("strCatNo-->"+strCatNo);
			System.out.println("strCrNo-->"+strCrNo);
			System.out.println("mode-->"+mode);
			System.out.println("hosCode-->"+hosCode);
			System.out.println("seatId-->"+seatId);

			
			formBean.setStrStoreId(strStoreId);
			formBean.setStrItemCategoryNo(strCatNo);
			formBean.setStrCrNo(strCrNo);
			//vo.setStrReqTypeId("32");	
			
			if(mode.equals("0"))
			{
				vo.setStrReqTypeId("32");
			}
			else if(mode.equals("1"))
			{
				vo.setStrReqTypeId("33");
			}
			else if(mode.equals("2"))
			{
//				if(formBean.getStrChkBoth().equals("1"))
//				{
					vo.setStrReqTypeId("32");
//				}
//				else
//				{
//					vo.setStrReqTypeId("33");
//				}
			}else
			{
				vo.setStrReqTypeId("32");
			}
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			vo.setStrCrNo(formBean.getStrCrNo());
			
			System.out.println("setStrReqTypeId-->"+vo.getStrReqTypeId());

			
			vo.setStrFinStartDate(mcu.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStrFinEndDate(mcu.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			
			System.out.println("setStrFinStartDate-->"+vo.getStrFinStartDate());
			System.out.println("setStrFinEndDate-->"+vo.getStrFinEndDate());

			vo.setStrCtDate(hisutil.getASDate("dd-MMM-yyyy"));
						
			bo.getIssueNoCombo(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			hisutil = new HisUtil("mms", "ReturnFromTransDATA");
			
			if(vo.getIssueNoWS()!= null
					&& vo.getIssueNoWS().size() > 0){
			    strIssueCmb = hisutil.getOptionValue(vo.getIssueNoWS(), "", "1^All", false);
			}else{
				strIssueCmb = "<option value='1'>All</option>";
			}
			
			formBean.setStrIssueNoCombo(strIssueCmb);
									
		}
		  catch (Exception e) 
		  {
			  e.printStackTrace();
			    strmsgText = e.getMessage();
				HisException eObj = new HisException("mms", "ReturnFromTransDATA->issueNoCombo()", strmsgText);
				formBean.setStrErr("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	public static void getIssueDetails(ReturnFromTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReturnFromTransVO vo=null;
		ReturnFromTransBO bo= null;
		String strmsgText = "";
		String hosCode = "";
		String strIssueNo = "";
		String strIssueDetails = "";
		String strHlp = "";
		String strStoreId  = "";
		
		try {

			bo = new ReturnFromTransBO();
			vo = new ReturnFromTransVO();

			hosCode    = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			strIssueNo = (String) request.getParameter("issueNo");
			strStoreId = (String) request.getParameter("strId");
			
			//String temp[] = strIssueNo.replace("^", "#").split("#");
			
			formBean.setStrIssueNo(strIssueNo);
			//formBean.setStrEmpNo(temp[1]);
			vo.setStrHospitalCode(hosCode);
			vo.setStrIssueNo(formBean.getStrIssueNo());
			vo.setStrStoreId(strStoreId);
			bo.getIssueDetails(vo);
			bo.getItemDetail(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			else {
                  
				strHlp = ReturnFromTransHLP.getItemDetails(vo.getStrItemCategoryNo(),vo.getStrHospitalCode(), vo.getItemDetailsWS(),vo.getStrStoreId());
				
				strIssueDetails = vo.getStrIssueDate()+ "^" + vo.getStrDepartmentUnitName()
						+ "^" + vo.getStrConsultantName()+"@@@"+strHlp;

			
				try {
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strIssueDetails);

				} catch (Exception e) {
					
				}
			}
			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {			
			
			}

		} catch (Exception e) {

		//	e.printStackTrace();
			strmsgText = "ReturnFromTransDATA.getIssueDetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReturnFromTransDATA->getIssueDetails()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				
			}
			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
	}
	
	public static void getIssueDetailsNEW(ReturnFromTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReturnFromTransVO vo=null;
		ReturnFromTransBO bo= null;
		String strmsgText = "";
		String hosCode = "";
		String strIssueNo = "";
		String strIssueDetails = "";
		String strHlp = "";
		String strStoreId  = "";
		
		try {

			bo = new ReturnFromTransBO();
			vo = new ReturnFromTransVO();

			hosCode    = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			strIssueNo = (String) request.getParameter("issueNo");
			strStoreId = (String) request.getParameter("strId");
			
			//String temp[] = strIssueNo.replace("^", "#").split("#");
			
			System.out.println("------------ ReturnFromTransDATA . getIssueDetailsNEW -> ReturnFromTransHLP.getItemDetailsNEW()----------");
			
			formBean.setStrIssueNo(strIssueNo);
			//formBean.setStrEmpNo(temp[1]);
			vo.setStrHospitalCode(hosCode);
			vo.setStrIssueNo(formBean.getStrIssueNo());
			vo.setStrStoreId(strStoreId);
			bo.getIssueDetails(vo);
			bo.getItemDetail(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			else {
                  
				System.out.println("------------ ReturnFromTransDATA . getIssueDetailsNEW -> ReturnFromTransHLP.getItemDetailsNEW()----------");
				
				strHlp = ReturnFromTransHLP.getItemDetailsNEW(vo.getStrItemCategoryNo(),vo.getStrHospitalCode(), vo.getItemDetailsWS(),vo.getStrStoreId());
				
				strIssueDetails = vo.getStrIssueDate()+ "^" + vo.getStrDepartmentUnitName()
						+ "^" + vo.getStrConsultantName()+"@@@"+strHlp;

			
				try {
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strIssueDetails);

				} catch (Exception e) {
					
				}
			}
			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {			
			
			}

		} catch (Exception e) {

		//	e.printStackTrace();
			strmsgText = "ReturnFromTransDATA.getIssueDetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReturnFromTransDATA->getIssueDetails()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				
			}
			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
	}
	
	
	public static void getItem_ALL_LIST(ReturnFromTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReturnFromTransVO vo=null;
		ReturnFromTransBO bo= null;
		String strmsgText = "";
		String hosCode = "";
		String strIssueNo = "";
		String strIssueDetails = "";
		String strHlp = "";
		String strStoreId  = "",crNo="";
		
		try {

			bo = new ReturnFromTransBO();
			vo = new ReturnFromTransVO();

			hosCode    = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			strIssueNo = (String) request.getParameter("issueNo");
			strStoreId = (String) request.getParameter("strId");
			crNo       = (String) request.getParameter("crNo");
			//String temp[] = strIssueNo.replace("^", "#").split("#");
			
			System.out.println("------------ ReturnFromTransDATA . getItem_ALL_LIST -> ReturnFromTransHLP.getItemDetailsNEW()----------");
			
			formBean.setStrIssueNo(strIssueNo);
			//formBean.setStrEmpNo(temp[1]);
			vo.setStrHospitalCode(hosCode);
			vo.setCrNo(crNo);
			vo.setStrStoreId(strStoreId);
			
			bo.getItem_ALL_LIST(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			else {
                  
				System.out.println("------------ ReturnFromTransDATA . getIssueDetailsNEW -> ReturnFromTransHLP.getItem_ALL_LIST()----------");
				
				strHlp = ReturnFromTransHLP.getItem_ALL_LIST(vo.getStrItemCategoryNo(),vo.getStrHospitalCode(), vo.getItemDetailsWS(),vo.getStrStoreId());
				
				strIssueDetails = strHlp;
                 
				//System.out.println("---"+strHlp);
			
				try {
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strIssueDetails);

				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {			
			
			}

		} catch (Exception e) {

		//	e.printStackTrace();
			strmsgText = "ReturnFromTransDATA.getIssueDetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReturnFromTransDATA->getIssueDetails()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				
			}
			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
	}

	public static void recommendedBy(ReturnFromTransFB formBean,HttpServletRequest request) {
		ReturnFromTransVO vo=null;
		ReturnFromTransBO bo= null;
		HisUtil hisutil = null;
		String strRecommendCmb = "";
		
		
		
		try {
			System.out.println("------------ PatientDtlHLP .recommendedBy  ------------");
			
			vo = new ReturnFromTransVO();
			bo = new ReturnFromTransBO();
			
			hisutil = new HisUtil("mms", "ReturnFromTransDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
					
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			String strMode = request.getParameter("strMode");
						
			formBean.setStrMode(strMode);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
								
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
						
			bo.getRecommendName(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			
			if(vo.getRecommendNameWS()!= null
					&& vo.getRecommendNameWS().size() > 0){
			
			    strRecommendCmb = hisutil.getOptionValue(vo.getRecommendNameWS(),
					"0", "0^Select Value", true);
			}else{
				strRecommendCmb = "<option value='0'>Select Value</option>";
			}
			formBean.setStrRecommendNameCombo(strRecommendCmb);
						
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "ReturnFromTransDATA->recommendedBy()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
		}
	}
	
	public static void insert(ReturnFromTransFB formBean,HttpServletRequest request)
	{
		ReturnFromTransVO vo=null;
		ReturnFromTransBO bo= null;
		MmsConfigUtil mcu = null;
		String strmsgText = "";
		
		String[] strReturnQTY = null;
		String[] strReturnQtyUnitID = null;
		String[] strItemID = null;
		String[] strItemBrandID = null;
		String[] strBatchSlNo = null;
		String[] strGrpID = null;
		String[] strSubGrpID = null;
		String[] strBalQty = null;
		String[] strBalQtyUnitID = null;
		String[] strTotalCost = null;
		String[] strRate = null;
		String[] strRateUnitID = null;
		String[] strSrNo = null;
		String[] strExpiry=null;
		HisUtil hisutil = null;
		String mode = "";
		String strItemCategoryNo = "";
		String strStoreId = "";
		String strCrNo = "";
		
		 
		
		try
			{
			
			  bo = new ReturnFromTransBO();
			  vo = new ReturnFromTransVO();
			  mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			  
			  
			  formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			  formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			  
			  strStoreId  = (String) request.getParameter("strId");
			  strItemCategoryNo = (String) request.getParameter("itemCategory");
			  mode = (String) request.getParameter("mode");
			  strCrNo  = (String) request.getParameter("crNo");
			  
			  formBean.setStrFinStartDate(mcu.getStrFinancialStartDate(strStoreId , formBean.getStrHospitalCode()));
			  formBean.setStrFinEndDate(mcu.getStrFinancialEndDate(strStoreId , formBean.getStrHospitalCode()));
			 
			  
			  
			  hisutil = new HisUtil("mms", "ReturnFromTransDATA");
			  String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			  formBean.setStrReturnDate(ctDate);
			 
			  ////System.out.println("formBean.getStrPatientDtlHidVal();-->"+formBean.getStrPatientDtlHidVal());
			  String[] temp = formBean.getStrPatientDtlHidVal().replace("^", "#").split("#");
			  
			  if(temp.length>=7)
				  formBean.setStrEmpNo(temp[6]);
			  else
				  formBean.setStrEmpNo("0");
			  //20-APR-82^1^11^11^^0^PGIPER10000012
			  
			 // ////System.out.println("formBean.getStrAdmissionDtlHidVal();-->"+formBean.getStrAdmissionDtlHidVal());
			  if(formBean.getStrAdmissionDtlHidVal()!=null && formBean.getStrAdmissionDtlHidVal().equals(""))
			  {
				  String[] temp1 = formBean.getStrAdmissionDtlHidVal().replace("^", "#").split("#");
				  formBean.setStrAdmnNo(temp1[0]);
			  }else{
			 
				  formBean.setStrAdmnNo("0");
			  }
			  
			  //2009000186^10809001^1^21-Apr-2009 04:39:01 PM^110900026^10311^101^1016^101101608^11^0^0^0^1^21-Apr-2009 04:39:42 PM^0
			  formBean.setStrStockStatusCode("10");
			  formBean.setStrReservedFlag("1");
			  formBean.setStrIsValid("1");
			 
			  if(mode.equals("0")){
				  formBean.setStrReqTypeId("41");
				}else if(mode.equals("1")){
					formBean.setStrReqTypeId("42");
				}else if(mode.equals("2")){
					//if(formBean.getStrChkBoth().equals("1")){
						formBean.setStrReqTypeId("41");
					//}else{
					//	formBean.setStrReqTypeId("42");
					//}
				}else{
					formBean.setStrReqTypeId("41");
				}
			  formBean.setStrStoreId(strStoreId);
			  formBean.setStrCrNo(strCrNo);
			  formBean.setStrItemCategoryNo(strItemCategoryNo);				  
			
			
			  ////System.out.println("formBean.getStrRecommendedBy()--"+formBean.getStrRecommendedBy());
			  
			  formBean.getStrIssueDate();
			  
			  //10100000^11100030^310000^310000100^1000^6301^200 Each^200^6301^1^12-JUN-09^Yes^10 Each^5 Each^100^6301^1
					  
			  
			  int nMultiRowLen = formBean.getStrReturnQty().length;
			    strReturnQTY = new String[nMultiRowLen];
			    strReturnQtyUnitID = new String[nMultiRowLen];
				strItemID = new String[nMultiRowLen];
				strItemBrandID = new String[nMultiRowLen];
				strBatchSlNo = new String[nMultiRowLen];
				strGrpID = new String[nMultiRowLen];
				strSubGrpID = new String[nMultiRowLen];
				strBalQty = new String[nMultiRowLen];
				strBalQtyUnitID = new String[nMultiRowLen];
				strTotalCost = new String[nMultiRowLen];
				strRate = new String[nMultiRowLen];
				strRateUnitID = new String[nMultiRowLen];
				strSrNo = new String[nMultiRowLen]; 
				strExpiry = new String[nMultiRowLen]; 
				 

				for(int i=0;i<nMultiRowLen;i++)
				{	  						
					////System.out.println("formBean.getStrTotalCost()[i]-->"+formBean.getStrTotalCost()[i]);
					String[] insertValue = formBean.getStrHidParamVal()[i].replace("^", "#").split("#");
					
					strReturnQTY[i] = formBean.getStrReturnQty()[i];
					
					String[] Temp = formBean.getStrReturnQtyUnitId()[i].replace("^", "#").split("#");
					strReturnQtyUnitID[i] = Temp[0];
					strTotalCost[i] = formBean.getStrTotalCost()[i];
					strItemID[i] = insertValue[0];
					strItemBrandID[i] = insertValue[1];
					strBatchSlNo[i] = insertValue[16];
					strGrpID[i] = insertValue[2];
					strSubGrpID[i] = insertValue[3];
					strBalQty[i] = insertValue[14];
					strBalQtyUnitID[i] = insertValue[15];
					strRate[i] = insertValue[7];
					strRateUnitID[i] = insertValue[8];
					strSrNo[i] = insertValue[17];
					strExpiry[i]=insertValue[18];
				} 
			
			    /*vo = (ReturnFromTransVO) TransferObjectFactory.populateData(
						"mms.transactions.vo.ReturnFromTransVO", formBean);*/
				String isuueNo=formBean.getStrIssueNo().replace("^", "#");
				//System.out.println("formBean.getStrIssueNo()"+isuueNo.split("#")[0]);
				vo.setStrIssueNo(isuueNo.split("#")[0]);
				vo.setStrChargeTypeId(isuueNo.split("#")[1]);
				vo.setStrIssueNo(formBean.getStrIssueNo());
				vo.setStrReturnDate(formBean.getStrCtDate());
				vo.setStrReqTypeId(formBean.getStrReqTypeId());
				vo.setStrCrNo(formBean.getStrCrNo());
				vo.setStrIssueDate(formBean.getStrIssueDate());
				vo.setStrEmpNo(formBean.getStrEmpNo());
				vo.setStrAdmnNo(formBean.getStrAdmnNo());
				vo.setStrNetCost(formBean.getStrNetCost());
				vo.setStrStoreId(formBean.getStrStoreId());
				vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
				vo.setStrItemId(strItemID);
				vo.setStrItemBrandId(strItemBrandID);
				vo.setStrBatchSlNo(strBatchSlNo);
				vo.setStrReturnQty(strReturnQTY);
				vo.setStrReturnQtyUnitId(strReturnQtyUnitID);
				vo.setStrFinStartDate(formBean.getStrFinStartDate());
				vo.setStrFinEndDate(formBean.getStrFinEndDate());
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				vo.setStrReturnDate(formBean.getStrCtDate());
				vo.setStrReservedFlag("1");
				vo.setStrStockStatusCode(formBean.getStrStockStatusCode());
				vo.setStrIsValid("1");
				vo.setStrGroupId(strGrpID);
				vo.setStrSubGroupId(strSubGrpID);
				vo.setStrBalanceQty(strBalQty);
				vo.setStrBalanceQtyUnitId(strBalQtyUnitID);
				vo.setStrRate(strRate);
				vo.setStrRateQtyUnitId(strRateUnitID);
				vo.setStrRemarks(formBean.getStrRemarks());
				vo.setStrStockStatusCode(formBean.getStrStockStatusCode());
				vo.setStrIsValid("1");
				vo.setStrTotalCost(strTotalCost);
				vo.setStrItemSlNo(strSrNo);
				vo.setStrExpiry(strExpiry);
				
				if(formBean.getStrRecommendedBy()!=null && !formBean.getStrRecommendedBy().equals(""))
				{
					vo.setStrRecommendedBy(formBean.getStrRecommendedBy());
				}
				else
				{
					vo.setStrRecommendedBy("0");
				}
				
				if(formBean.getStrRecommendDate()!=null && !formBean.getStrRecommendDate().equals(""))
				{
					vo.setStrRecommendDate(formBean.getStrRecommendDate());
				}
				else
				{
					vo.setStrRecommendDate("");
				}
				
			  bo.insert(vo);
				
			 formBean.setStrReturnNo(vo.getStrReturnNo());
			  if(vo.getStrMsgType().equals("1"))
			  {
				  if(vo.getStrMsgString().split("\\##")[2].equals("999"))
				    {
	    				////System.out.println("In Insufficent Drug:::"+vo.getStrMsgString().split("\\##")[1]);
					    formBean.setStrErr(vo.getStrMsgString().split("\\##")[1]);
				    }
					else
					{
						formBean.setStrErr(vo.getStrMsgString());
					    throw new Exception(vo.getStrMsgString());
					}	
			  }
			  else{
				  formBean.setStrMsg("Return Request No [ "+vo.getStrReturnNo()+" ] Saved Successfully!!");
			  }
			}
			catch(Exception e)
			{
				e.printStackTrace();
				strmsgText = "hisglobaltransactionutil.ReturnFromTransDATA.insert(vo) --> "
						+ e.getMessage();
				HisException eObj = new HisException(
						"mms",
						"ReturnFromTransDATA->insert()",
						strmsgText);
				formBean.setStrErr("Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");

				eObj = null;
			}
			finally {
				if (vo != null) vo = null;
				if(formBean != null) formBean = null;
				hisutil = null;
			}
		}
	
	public static void insert_LIST(ReturnFromTransFB formBean,HttpServletRequest request)
	{
		ReturnFromTransVO vo=null;
		ReturnFromTransBO bo= null;
		
		String strmsgText = "";
		
		String[] strReturnQTY = null;
		String[] strReturnQtyUnitID = null;
		String[] strItemID = null;
		String[] strItemBrandID = null;
		String[] strBatchSlNo = null;
		String[] strGrpID = null;
		String[] strSubGrpID = null;
		String[] strBalQty = null;
		String[] strBalQtyUnitID = null;
		String[] strTotalCost = null;
		String[] strRate = null;
		String[] strRateUnitID = null;
		String[] strSrNo = null;
		String[] strExpiry=null;
		HisUtil hisutil = null;
		String mode = "";
		String strItemCategoryNo = "";
		String strStoreId = "";
		String strCrNo = "";
		
		 
		
		try
			{
			
			  bo = new ReturnFromTransBO();
			  vo = new ReturnFromTransVO();
			  
			  formBean.setStrMsg("----------- DATA. insert_LIST------START---------");
			  
			  formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			  formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			  
			  strStoreId  = (String) request.getParameter("strId");
			  strItemCategoryNo = (String) request.getParameter("itemCategory");
			  mode = (String) request.getParameter("mode");
			  strCrNo  = (String) request.getParameter("crNo");
			  
			  formBean.setStrFinStartDate("01-Apr-2023");
			  formBean.setStrFinEndDate("31-Mar-2024");
			 		  
			  
			  hisutil = new HisUtil("mms", "ReturnFromTransDATA");
			  String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			  formBean.setStrReturnDate(ctDate);
			 
			  ////System.out.println("formBean.getStrPatientDtlHidVal();-->"+formBean.getStrPatientDtlHidVal());
			  String[] temp = formBean.getStrPatientDtlHidVal().replace("^", "#").split("#");
			  
			  if(temp.length>=7)
				  formBean.setStrEmpNo(temp[6]);
			  else
				  formBean.setStrEmpNo("0");
			  //20-APR-82^1^11^11^^0^PGIPER10000012
			  
			 // ////System.out.println("formBean.getStrAdmissionDtlHidVal();-->"+formBean.getStrAdmissionDtlHidVal());
			  if(formBean.getStrAdmissionDtlHidVal()!=null && formBean.getStrAdmissionDtlHidVal().equals(""))
			  {
				  String[] temp1 = formBean.getStrAdmissionDtlHidVal().replace("^", "#").split("#");
				  formBean.setStrAdmnNo(temp1[0]);
			  }else{
			 
				  formBean.setStrAdmnNo("0");
			  }
			  
			  //2009000186^10809001^1^21-Apr-2009 04:39:01 PM^110900026^10311^101^1016^101101608^11^0^0^0^1^21-Apr-2009 04:39:42 PM^0
			  formBean.setStrStockStatusCode("10");
			  formBean.setStrReservedFlag("1");
			  formBean.setStrIsValid("1");
			 
			  if(mode.equals("0")){
				  formBean.setStrReqTypeId("41");
				}else if(mode.equals("1")){
					formBean.setStrReqTypeId("42");
				}else if(mode.equals("2")){
					//if(formBean.getStrChkBoth().equals("1")){
						formBean.setStrReqTypeId("41");
					//}else{
					//	formBean.setStrReqTypeId("42");
					//}
				}else{
					formBean.setStrReqTypeId("41");
				}
			  formBean.setStrStoreId(strStoreId);
			  formBean.setStrCrNo(strCrNo);
			  formBean.setStrItemCategoryNo(strItemCategoryNo);				  
			
			
			  ////System.out.println("formBean.getStrRecommendedBy()--"+formBean.getStrRecommendedBy());
			  
			  formBean.getStrIssueDate();
			  
			  //10100000^11100030^310000^310000100^1000^6301^200 Each^200^6301^1^12-JUN-09^Yes^10 Each^5 Each^100^6301^1
					  
			  
			  int nMultiRowLen = formBean.getStrReturnQty().length;
			    strReturnQTY = new String[nMultiRowLen];
			    strReturnQtyUnitID = new String[nMultiRowLen];
				strItemID = new String[nMultiRowLen];
				strItemBrandID = new String[nMultiRowLen];
				strBatchSlNo = new String[nMultiRowLen];
				strGrpID = new String[nMultiRowLen];
				strSubGrpID = new String[nMultiRowLen];
				strBalQty = new String[nMultiRowLen];
				strBalQtyUnitID = new String[nMultiRowLen];
				strTotalCost = new String[nMultiRowLen];
				strRate = new String[nMultiRowLen];
				strRateUnitID = new String[nMultiRowLen];
				strSrNo = new String[nMultiRowLen]; 
				strExpiry = new String[nMultiRowLen]; 
				 

				for(int i=0;i<nMultiRowLen;i++)
				{	  						
					////System.out.println("formBean.getStrTotalCost()[i]-->"+formBean.getStrTotalCost()[i]);
					String[] insertValue = formBean.getStrHidParamVal()[i].replace("^", "#").split("#");
					
					strReturnQTY[i] = formBean.getStrReturnQty()[i];
					
					String[] Temp = formBean.getStrReturnQtyUnitId()[i].replace("^", "#").split("#");
					strReturnQtyUnitID[i] = Temp[0];
					strTotalCost[i] = formBean.getStrTotalCost()[i];
					strItemID[i] = insertValue[0];
					strItemBrandID[i] = insertValue[1];
					strBatchSlNo[i] = insertValue[16];
					strGrpID[i] = insertValue[2];
					strSubGrpID[i] = insertValue[3];
					strBalQty[i] = insertValue[14];
					strBalQtyUnitID[i] = insertValue[15];
					strRate[i] = insertValue[7];
					strRateUnitID[i] = insertValue[8];
					strSrNo[i] = insertValue[17];
					strExpiry[i]=insertValue[18];
				} 
						
				vo.setStrIssueNo(formBean.getStrIssueNo());
				vo.setStrReturnDate(formBean.getStrCtDate());
				vo.setStrReqTypeId(formBean.getStrReqTypeId());
				vo.setStrCrNo(formBean.getStrCrNo());
				vo.setStrIssueDate(formBean.getStrIssueDate());
				vo.setStrEmpNo(formBean.getStrEmpNo());
				vo.setStrAdmnNo(formBean.getStrAdmnNo());
				vo.setStrNetCost(formBean.getStrNetCost());
				vo.setStrStoreId(formBean.getStrStoreId());
				vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
				vo.setStrItemId(strItemID);
				vo.setStrItemBrandId(strItemBrandID);
				vo.setStrBatchSlNo(strBatchSlNo);
				vo.setStrReturnQty(strReturnQTY);
				vo.setStrReturnQtyUnitId(strReturnQtyUnitID);
				vo.setStrFinStartDate(formBean.getStrFinStartDate());
				vo.setStrFinEndDate(formBean.getStrFinEndDate());
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				vo.setStrReturnDate(formBean.getStrCtDate());
				vo.setStrReservedFlag("1");
				vo.setStrStockStatusCode(formBean.getStrStockStatusCode());
				vo.setStrIsValid("1");
				vo.setStrGroupId(strGrpID);
				vo.setStrSubGroupId(strSubGrpID);
				vo.setStrBalanceQty(strBalQty);
				vo.setStrBalanceQtyUnitId(strBalQtyUnitID);
				vo.setStrRate(strRate);
				vo.setStrRateQtyUnitId(strRateUnitID);
				vo.setStrRemarks(formBean.getStrRemarks());
				vo.setStrStockStatusCode(formBean.getStrStockStatusCode());
				vo.setStrIsValid("1");
				vo.setStrTotalCost(strTotalCost);
				vo.setStrItemSlNo(strSrNo);
				vo.setStrExpiry(strExpiry);
				
				vo.setStrIssueNoList(formBean.getStrIssueNoList());
				vo.setStrOrgIssueStoreList(formBean.getStrOrgIssueStoreList());
				
				if(formBean.getStrRecommendedBy()!=null && !formBean.getStrRecommendedBy().equals(""))
				{
					vo.setStrRecommendedBy(formBean.getStrRecommendedBy());
				}
				else
				{
					vo.setStrRecommendedBy("0");
				}
				
				if(formBean.getStrRecommendDate()!=null && !formBean.getStrRecommendDate().equals(""))
				{
					vo.setStrRecommendDate(formBean.getStrRecommendDate());
				}
				else
				{
					vo.setStrRecommendDate("");
				}
				
			  bo.insert_LIST(vo);
				
			 formBean.setStrReturnNo(vo.getStrReturnNo());
			  if(vo.getStrMsgType().equals("1"))
			  {
				  if(vo.getStrMsgString().split("\\##")[2].equals("999"))
				    {
	    				////System.out.println("In Insufficent Drug:::"+vo.getStrMsgString().split("\\##")[1]);
					    formBean.setStrErr(vo.getStrMsgString().split("\\##")[1]);
				    }
					else
					{
						formBean.setStrErr(vo.getStrMsgString());
					    throw new Exception(vo.getStrMsgString());
					}	
			  }
			  else{
				  formBean.setStrMsg("Return Request No [ "+vo.getStrReturnNo()+" ] for CR No [ "+vo.getStrCrNo()+" ] Saved Successfully!!");
				  formBean.setCrNo(vo.getStrCrNo());
			  }
			  
			  formBean.setStrMsg("----------- DATA. insert_LIST------END---------");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				strmsgText = "hisglobaltransactionutil.ReturnFromTransDATA.insert(vo) --> "
						+ e.getMessage();
				HisException eObj = new HisException(
						"mms",
						"ReturnFromTransDATA->insert()",
						strmsgText);
				formBean.setStrErr("Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");

				eObj = null;
			}
			finally {
				if (vo != null) vo = null;
				if(formBean != null) formBean = null;
				hisutil = null;
			}
		}
	
	public static boolean validateIssueNumber(ReturnFromTransFB formBean, HttpServletRequest request,HttpServletResponse response) 
	{
		ReturnFromTransVO vo=null;
		ReturnFromTransBO bo= null;
		MmsConfigUtil mcu = null;
		boolean bFlag=false;
		String strCurrentDate;
		HisUtil hisutil = null;
		try {
			vo = new ReturnFromTransVO();
			bo = new ReturnFromTransBO();
			hisutil = new HisUtil("mms", "ReturnFromTransDATA");
			
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			formBean.setStrHospitalCode(strHospitalCode);
			System.out.println("strHospitalCode-->"+strHospitalCode);

			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(strCurrentDate);
			
			vo.setStrReturnDrugValidity(mcu.getStrReturnDrugValidity());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrIssueNumber(formBean.getStrIssueNumber());
			
			System.out.println("setStrReturnDrugValidity-->"+formBean.getStrReturnDrugValidity());
			System.out.println("setStrHospitalCode-->"+formBean.getStrHospitalCode());
			System.out.println("setStrIssueNumber-->"+formBean.getStrIssueNumber());

			
			bo.validateIssueNumber(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
		
			if(vo.getStrIssueNumberValidationFlag()!=null && vo.getStrIssueNumberValidationFlag().equals("0"))
			{
				formBean.setStrMsg("Drugs Return Validity Date Exceeded");
			}
			else
			{
				bFlag=true;
			}
			
						
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "ReturnFromTransDATA->validateIssueNumber()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
		}
		
		return bFlag;
	}
	
	public static void getIssueDetailsBasedOnPatientNameOrCrNo(ReturnFromTransFB formBean, HttpServletRequest request,HttpServletResponse response) 
	{
		ReturnFromTransVO vo=null;
		ReturnFromTransBO bo= null;
		MmsConfigUtil mcu = null;
		String mode = "";
		String strEnteredIssueDetailsTable;
		try {
			vo = new ReturnFromTransVO();
			bo = new ReturnFromTransBO();
			
			mode = request.getParameter("strMode");
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			formBean.setStrHospitalCode(strHospitalCode);
	
			
			vo.setStrReturnDrugValidity(mcu.getStrReturnDrugValidity());
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrIssueNumber(formBean.getStrIssueNumber());
			
			 vo.setStrMode("1");
			 vo.setStrStoreId(formBean.getStrId());
			 vo.setStrIssueNo( (formBean.getStrIssueNumber()!=null && !formBean.getStrIssueNumber().equals("")) ? formBean.getStrIssueNumber() : "0"  );
			 vo.setStrHospitalCode(formBean.getStrHospitalCode());
			 vo.setStrReqNo("0");
			 vo.setStrCrNo( (formBean.getStrSearchByPatientNameOrCrNo()!=null && formBean.getStrSearchByPatientNameOrCrNo().equals("1")) ? formBean.getStrPatNameOrCrNo() : "0" );
			 vo.setStrAdmnNo("0");
			 vo.setStrEmpNo("0");
			 
			 if(mode.equals("0"))
			 {
					vo.setStrReqTypeId("32");
			 }
			 else if(mode.equals("1"))
			 {
					vo.setStrReqTypeId("33");
			 }else if(mode.equals("2"))
			 {
					if(formBean.getStrChkBoth().equals("1"))
					{
						vo.setStrReqTypeId("32");
					}
					else
					{
						vo.setStrReqTypeId("33");
					}
			}
			 vo.setStrItemCategoryNo("0");
			 vo.setStrIssueDate("0");
			 vo.setStrPatName( (formBean.getStrSearchByPatientNameOrCrNo()!=null && formBean.getStrSearchByPatientNameOrCrNo().equals("2")) ? formBean.getStrPatNameOrCrNo() : "0" );
			 vo.setStrFromDate(formBean.getStrFromDate());
			 vo.setStrToDate(formBean.getStrToDate());
			 vo.setStrDays("0");
	
			
			
			bo.getIssueDetailsBasedOnPatientNameOrCrNo(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
		
			strEnteredIssueDetailsTable	=	getEnteredIssueDetailsTable(vo.getWrsData(),"WITH_RADIO_BUTTON");
			formBean.setStrEnteredIssueDetailsTable(strEnteredIssueDetailsTable);

			
						
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "ReturnFromTransDATA->getIssueDetailsBasedOnPatientNameOrCrNo()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
		}
		
	}
	
	private static String getEnteredIssueDetailsTable(WebRowSet wrsData_p,String strDisplayMode_p) throws SQLException {

		StringBuffer sbHeader = new StringBuffer(100);
		StringBuffer sbBody = new StringBuffer(100);
		
		int nWidth;
		int nColspan;
		int index=0;
		if (strDisplayMode_p.equals("WITH_RADIO_BUTTON")) {
			nWidth = 17;
			nColspan = 7;
		} else {
			nWidth = 19;
			nColspan = 6;
		}

		/*
		 * Header Row:
		 */

		sbHeader.append("<tr>");
		if (strDisplayMode_p.equals("WITH_RADIO_BUTTON")) {
			sbHeader.append("<td width=\"5%\" class=\"LABEL\" style=\"text-align: center;\"></td>");
		}
		sbHeader.append("<td width=\""	+ nWidth	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Issue No.</td>");
		sbHeader.append("<td width=\""	+ nWidth	+ "%\" class=\"LABEL\" style=\"text-align: center;\">CR No.</td>");
		sbHeader.append("<td width=\""	+ nWidth	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Issue Date</td>");
		sbHeader.append("<td width=\""	+ nWidth	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Patient Name</td>");
		sbHeader.append("<td width=\""	+ nWidth	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Father Name</td>");
		sbHeader.append("<td width=\""	+ nWidth	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Age/Gender</td>");
		sbHeader.append("</tr>");

		if (wrsData_p != null && wrsData_p.size() > 0) {
			/* Result Index */
			
//			HSTNUM_ISSUE_NO:1
//			HRGNUM_PUK:2
//			HSTDT_ISSUE_DATE:3
//			HSTSTR_PATIENT_NAME:4 
//			HSTSTR_FATHER_NAME:5
//			AGE_GENDER:6
			
			String strIssueNo="";

			while (wrsData_p.next()) {

					   strIssueNo = wrsData_p.getString("HSTNUM_ISSUE_NO");
				String strCrNo = wrsData_p.getString("HRGNUM_PUK");
				String strIssueDate = wrsData_p.getString("HSTDT_ISSUE_DATE");
				String strPatientName = wrsData_p.getString("HSTSTR_PATIENT_NAME");
				String strFatherName = wrsData_p.getString("HSTSTR_FATHER_NAME");
				
				String strAgeAndGender = wrsData_p.getString("AGE_GENDER");

				if (strIssueNo == null) {
					strIssueNo = "---";
				}
				if (strCrNo == null) {
					strCrNo = "---";
				}
				if (strIssueDate == null) {
					strIssueDate = "---";
				}
				if (strPatientName == null) {
					strPatientName = "---";
				}
				if (strFatherName == null) {
					strFatherName = "---";
				}
				if (strAgeAndGender == null) {
					strAgeAndGender = "---";
				}
				

				/*
				 * Table Body
				 */

				sbBody.append("<tr>");
				if (strDisplayMode_p.equals("WITH_RADIO_BUTTON")) {
					sbBody.append("<td width=\"5%\"  class=\"CONTROL\" style=\"text-align: center;\"><input type=\"radio\" name=\"strPatientDetails\" value=\""+ strCrNo+"^"+strIssueNo+ "\"/></td>");
				}
				sbBody.append("<td width=\""	+ nWidth	+ "%\" class=\"CONTROL\" style=\"text-align: center;\">"	+ strIssueNo + "</td>");				
				sbBody.append("<td width=\""	+ nWidth	+ "%\" class=\"CONTROL\" style=\"text-align: center;\">"	+ strCrNo + "</td>");
				sbBody.append("<td width=\""	+ nWidth	+ "%\" class=\"CONTROL\" style=\"text-align: center;\">"	+ strIssueDate + "</td>");
				sbBody.append("<td width=\""	+ nWidth	+ "%\" class=\"CONTROL\" style=\"text-align: center;\">"	+ strPatientName + "</td>");
				sbBody.append("<td width=\""	+ nWidth	+ "%\" class=\"CONTROL\" style=\"text-align: center;\">"	+ strFatherName + "</td>");
				sbBody.append("<td width=\""	+ nWidth	+ "%\" class=\"CONTROL\" style=\"text-align: center;\">"	+ strAgeAndGender + "</td>");
			
				sbBody.append("</tr>");

			index++;	
			}
			sbBody.append("<tr>");
			sbBody.append("<td colspan=\""	+ nColspan	+ "\" class=\"CONTROL\" style=\"text-align: center; color: red;\"></td>");
			sbBody.append("</tr>");
			sbBody.append("<tr>");
			sbBody.append("<td colspan=\""	+ nColspan	+ "\" class=\"CONTROL\" style=\"text-align: center;\">"	+ "<input type=\"image\" style=\"cursor: pointer; \" title=\"Click Ok\" align=\"top\" src=\"../../hisglobal/images/btn-ok.png\" name=\"ok\" value=\"Ok\"	onclick=\"return getPatDtlsBasedOnPatientIssueNo();\" onkeypress=\"if(event.keyCode==13) getPatDtlsBasedOnPatientIssueNo();\">" + "</td>");
			sbBody.append("</tr>");
		} else {
			sbBody.append("<tr>");
			sbBody.append("<td colspan=\""	+ nColspan	+ "\" class=\"CONTROL\" style=\"text-align: center; color: red;\">No Data Found!</td>");
			sbBody.append("</tr>");
		}

		return sbHeader.toString() + sbBody.toString();
	}

	public static void getpatientDemographicDetail(ReturnFromTransFB formBean,
			HttpServletRequest request) 
	{
		
		ReturnFromTransVO vo=null;
		ReturnFromTransBO bo= null;
		MmsConfigUtil mcu = null;
			HisUtil hisutil = null;
			String strmsgText = null;
			String strPatientDetailhlp = "";
					
				try {
					bo = new ReturnFromTransBO();
					vo = new ReturnFromTransVO();
					mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
									
					String strIssueMode = mcu.getStrIssueMode();
					formBean.setStrIssueMode(strIssueMode);
					
					formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					
					vo.setStrHospitalCode(formBean.getStrHospitalCode());
					vo.setStrSeatId(formBean.getStrSeatId());
					vo.setStrId(formBean.getStrId());
					vo.setStrIssueNumber(formBean.getStrIssueNumber());
					
				/*	if(formBean.getStrCrNo()!=null && formBean.getStrCrNo())
					try{
						strPatientDetailhlp = hisglobal.tools.hlp.PatientDtlHLP.patientWithAdmissionDtl(formBean.getStrCrNo(), formBean.getStrHospitalCode(), true);
						 //////System.out.println("formBean.getStrPatientDtlHidVal();-->"+formBean.getStrPatientDtlHidVal());
						}catch(Exception e){
							
							throw new Exception("Invalid C.R. No.");
							
						}
						
					formBean.setStrPatientDetail(strPatientDetailhlp);
					*/
					
					
					bo.getpatientDemographicDetail(vo);
					
					if(vo.getWrsData().next())
					{
						formBean.setStrPatientName(vo.getWrsData().getString("HSTSTR_PATIENT_NAME"));
						formBean.setStrPatientAge(vo.getWrsData().getString("AGE"));
			//			formBean.setStrPatientAgeUnit(vo.getStrPatientAgeUnit());
						formBean.setStrPatientFatherName(vo.getWrsData().getString("HSTSTR_FATHER_NAME"));
						formBean.setStrPatientGenderCode(vo.getWrsData().getString("GENDER"));
						formBean.setStrPatientAddress(vo.getWrsData().getString("HSTSTR_ADDRESS"));

					}
									
					if (vo.getStrMsgType().equals("1"))
					{
						throw new Exception(vo.getStrMsgString());
					}
				} 
				catch (Exception e) 
				{
				e.printStackTrace();
				 strmsgText = "ReturnFromTransDATA.getpatientDemographicDetail(vo) --> "+ e.getMessage();
		         HisException eObj = new HisException("mms","ReturnFromTransDATA->getpatientDemographicDetail()", strmsgText);
				 eObj = null;
				} 
				finally
				{
					
					if (bo != null)bo = null;
					if (vo != null)vo = null;
					if (hisutil != null)hisutil = null;
				}
							
	}
	
	public static void insertWithoutCrNo(ReturnFromTransFB formBean,HttpServletRequest request)
	{
		ReturnFromTransVO vo=null;
		ReturnFromTransBO bo= null;
		MmsConfigUtil mcu = null;
		String strmsgText = "";
		
		String[] strReturnQTY = null;
		String[] strReturnQtyUnitID = null;
		String[] strItemID = null;
		String[] strItemBrandID = null;
		String[] strBatchSlNo = null;
		String[] strGrpID = null;
		String[] strSubGrpID = null;
		String[] strBalQty = null;
		String[] strBalQtyUnitID = null;
		String[] strTotalCost = null;
		String[] strRate = null;
		String[] strRateUnitID = null;
		String[] strSrNo = null;
		
		HisUtil hisutil = null;
		String mode = "";
		String strItemCategoryNo = "";
		String strStoreId = "";
		String strCrNo = "";
		
		 
		
		try
			{
			
			  bo = new ReturnFromTransBO();
			  vo = new ReturnFromTransVO();
			  mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			  
			  
			  formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			  formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			  
			  strStoreId  = (String) request.getParameter("strId");
			  strItemCategoryNo = (String) request.getParameter("itemCategory");
			  mode = (String) request.getParameter("mode");
		//	  strCrNo  = (String) request.getParameter("crNo");
			  
			  formBean.setStrFinStartDate(mcu.getStrFinancialStartDate(strStoreId , formBean.getStrHospitalCode()));
			  formBean.setStrFinEndDate(mcu.getStrFinancialEndDate(strStoreId , formBean.getStrHospitalCode()));
			 
			  
			  
			  hisutil = new HisUtil("mms", "ReturnFromTransDATA");
			  String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			  formBean.setStrReturnDate(ctDate);
			 
			  ////System.out.println("formBean.getStrPatientDtlHidVal();-->"+formBean.getStrPatientDtlHidVal());
			  String[] temp = formBean.getStrPatientDtlHidVal().replace("^", "#").split("#");
			  
			  if(temp.length>=7)
				  formBean.setStrEmpNo(temp[6]);
			  else
				  formBean.setStrEmpNo("0");
			  //20-APR-82^1^11^11^^0^PGIPER10000012
			  
			 // ////System.out.println("formBean.getStrAdmissionDtlHidVal();-->"+formBean.getStrAdmissionDtlHidVal());
			  if(formBean.getStrAdmissionDtlHidVal()!=null && formBean.getStrAdmissionDtlHidVal().equals(""))
			  {
				  String[] temp1 = formBean.getStrAdmissionDtlHidVal().replace("^", "#").split("#");
				  formBean.setStrAdmnNo(temp1[0]);
			  }else{
			 
				  formBean.setStrAdmnNo("0");
			  }
			  
			  //2009000186^10809001^1^21-Apr-2009 04:39:01 PM^110900026^10311^101^1016^101101608^11^0^0^0^1^21-Apr-2009 04:39:42 PM^0
			  formBean.setStrStockStatusCode("10");
			  formBean.setStrReservedFlag("1");
			  formBean.setStrIsValid("1");
			 
			  if(mode.equals("0")){
				  formBean.setStrReqTypeId("41");
				}else if(mode.equals("1")){
					formBean.setStrReqTypeId("42");
				}else if(mode.equals("2")){
					if(formBean.getStrChkBoth().equals("1")){
						formBean.setStrReqTypeId("41");
					}else{
						formBean.setStrReqTypeId("42");
					}
				}
			  formBean.setStrStoreId(strStoreId);
//			  formBean.setStrCrNo(strCrNo);
			  formBean.setStrItemCategoryNo(strItemCategoryNo);				  
			
			
			  ////System.out.println("formBean.getStrRecommendedBy()--"+formBean.getStrRecommendedBy());
			  
			  formBean.getStrIssueDate();
			  
			  //10100000^11100030^310000^310000100^1000^6301^200 Each^200^6301^1^12-JUN-09^Yes^10 Each^5 Each^100^6301^1
					  
			  
			  int nMultiRowLen = formBean.getStrReturnQty().length;
			    strReturnQTY = new String[nMultiRowLen];
			    strReturnQtyUnitID = new String[nMultiRowLen];
				strItemID = new String[nMultiRowLen];
				strItemBrandID = new String[nMultiRowLen];
				strBatchSlNo = new String[nMultiRowLen];
				strGrpID = new String[nMultiRowLen];
				strSubGrpID = new String[nMultiRowLen];
				strBalQty = new String[nMultiRowLen];
				strBalQtyUnitID = new String[nMultiRowLen];
				strTotalCost = new String[nMultiRowLen];
				strRate = new String[nMultiRowLen];
				strRateUnitID = new String[nMultiRowLen];
				strSrNo = new String[nMultiRowLen]; 
			 
				 

				for(int i=0;i<nMultiRowLen;i++)
				{	  						
					////System.out.println("formBean.getStrTotalCost()[i]-->"+formBean.getStrTotalCost()[i]);
					String[] insertValue = formBean.getStrHidParamVal()[i].replace("^", "#").split("#");
					
					strReturnQTY[i] = formBean.getStrReturnQty()[i];
					
					String[] Temp = formBean.getStrReturnQtyUnitId()[i].replace("^", "#").split("#");
					strReturnQtyUnitID[i] = Temp[0];
					strTotalCost[i] = formBean.getStrTotalCost()[i];
					strItemID[i] = insertValue[0];
					strItemBrandID[i] = insertValue[1];
					strBatchSlNo[i] = insertValue[16];
					strGrpID[i] = insertValue[2];
					strSubGrpID[i] = insertValue[3];
					strBalQty[i] = insertValue[14];
					strBalQtyUnitID[i] = insertValue[15];
					strRate[i] = insertValue[7];
					strRateUnitID[i] = insertValue[8];
					strSrNo[i] = insertValue[17];
					
				} 
			
			    /*vo = (ReturnFromTransVO) TransferObjectFactory.populateData(
						"mms.transactions.vo.ReturnFromTransVO", formBean);*/
			
				vo.setStrIssueNo((formBean.getStrIssueNumber()!=null && !formBean.getStrIssueNumber().equals("")) ?formBean.getStrIssueNumber():formBean.getStrIssueNo());
				vo.setStrReturnDate(formBean.getStrCtDate());
				vo.setStrReqTypeId(formBean.getStrReqTypeId());
				
				if(formBean.getStrCrNo()!=null && !formBean.getStrCrNo().equals(""))
				{
					vo.setStrCrNo(formBean.getStrCrNo());
				}
				
				
				
				vo.setStrIssueDate(formBean.getStrIssueDate());
				vo.setStrEmpNo(formBean.getStrEmpNo());
				vo.setStrAdmnNo(formBean.getStrAdmnNo());
				vo.setStrNetCost(formBean.getStrNetCost());
				vo.setStrStoreId(formBean.getStrStoreId());
				vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
				vo.setStrItemId(strItemID);
				vo.setStrItemBrandId(strItemBrandID);
				vo.setStrBatchSlNo(strBatchSlNo);
				vo.setStrReturnQty(strReturnQTY);
				vo.setStrReturnQtyUnitId(strReturnQtyUnitID);
				vo.setStrFinStartDate(formBean.getStrFinStartDate());
				vo.setStrFinEndDate(formBean.getStrFinEndDate());
				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());
				vo.setStrReturnDate(formBean.getStrCtDate());
				vo.setStrReservedFlag("1");
				vo.setStrStockStatusCode(formBean.getStrStockStatusCode());
				vo.setStrIsValid("1");
				vo.setStrGroupId(strGrpID);
				vo.setStrSubGroupId(strSubGrpID);
				vo.setStrBalanceQty(strBalQty);
				vo.setStrBalanceQtyUnitId(strBalQtyUnitID);
				vo.setStrRate(strRate);
				vo.setStrRateQtyUnitId(strRateUnitID);
				vo.setStrRemarks(formBean.getStrRemarks());
				vo.setStrIsValid("1");
				vo.setStrTotalCost(strTotalCost);
				vo.setStrItemSlNo(strSrNo);
				if(formBean.getStrRecommendedBy()!=null && !formBean.getStrRecommendedBy().equals(""))
				{
					vo.setStrRecommendedBy(formBean.getStrRecommendedBy());
				}
				else
				{
					vo.setStrRecommendedBy("0");
				}
				
				if(formBean.getStrRecommendDate()!=null && !formBean.getStrRecommendDate().equals(""))
				{
					vo.setStrRecommendDate(formBean.getStrRecommendDate());
				}
				else
				{
					vo.setStrRecommendDate("");
				}
				
				///////
				for(int i=0;i<nMultiRowLen;i++)
				{	  						
					////System.out.println("formBean.getStrTotalCost()[i]-->"+formBean.getStrTotalCost()[i]);
					
				/*	//System.out.println("strReturnQTY[i]-->"+strReturnQTY[i]);
					
					//System.out.println("strReturnQtyUnitID[i]-->"+strReturnQtyUnitID[i]);
					//System.out.println("strTotalCost[i]-->"+strTotalCost[i]);
					//System.out.println("strItemID[i]-->"+strItemID[i]);
					//System.out.println("strItemBrandID[i]-->"+strItemBrandID[i]);
					//System.out.println("strBatchSlNo[i]-->"+strBatchSlNo[i]);
					//System.out.println("strGrpID[i]-->"+strGrpID[i]);
					//System.out.println("strSubGrpID[i]-->"+strSubGrpID[i]);
					//System.out.println("strBalQty[i]-->"+strBalQty[i]);
					//System.out.println("strBalQtyUnitID[i]-->"+strBalQtyUnitID[i]);
					//System.out.println("strRate[i]-->"+strRate[i]);
					//System.out.println("strRateUnitID[i]-->"+strRateUnitID[i]);
					//System.out.println("strSrNo[i]-->"+strSrNo[i]);
					
					//System.out.println("vo.getStrIssueDate"+vo.getStrIssueDate());
					//System.out.println("vo.getStrEmpNo"+vo.getStrEmpNo());
					//System.out.println("vo.getStrAdmnNo"+vo.getStrAdmnNo());
					//System.out.println("vo.getStrNetCost"+vo.getStrNetCost());
					//System.out.println("vo.getStrStoreId"+vo.getStrStoreId());
					//System.out.println("vo.getStrItemCategoryNo"+vo.getStrItemCategoryNo());
					//System.out.println("vo.getStrItemId"+vo.getStrItemId()[i]);
					
					//System.out.println("vo.getStrItemBrandId"+vo.getStrItemBrandId()[i]);
					//System.out.println("vo.getStrBatchSlNo"+vo.getStrBatchSlNo()[i]);
					//System.out.println("vo.getStrReturnQty"+vo.getStrReturnQty()[i]);
					//System.out.println("vo.getStrReturnQtyUnitId"+vo.getStrReturnQtyUnitId()[i]);
					//System.out.println("vo.getStrFinStartDate"+vo.getStrFinStartDate());
					//System.out.println("vo.getStrFinEndDate"+vo.getStrFinEndDate());
					//System.out.println("vo.getStrReturnDate"+vo.getStrReturnDate());
					//System.out.println("vo.getStrHospitalCode"+vo.getStrHospitalCode());
					//System.out.println("vo.getStrStockStatusCode"+vo.getStrStockStatusCode());
					//System.out.println("vo.getStrGroupId"+vo.getStrGroupId()[i]);
					
					
					
					//System.out.println("vo.getStrSubGroupId"+vo.getStrSubGroupId()[i]);
					//System.out.println("vo.getStrBalanceQty"+vo.getStrBalanceQty()[i]);
					//System.out.println("vo.getStrBalanceQtyUnitId"+vo.getStrBalanceQtyUnitId()[i]);
					//System.out.println("vo.getStrRate"+vo.getStrRate()[i]);
					//System.out.println("vo.getStrRateQtyUnitId"+vo.getStrRateQtyUnitId()[i]);
					//System.out.println("vo.getStrRemarks"+vo.getStrRemarks());
					//System.out.println("vo.getStrTotalCost"+vo.getStrTotalCost()[i]);
					//System.out.println("vo.getStrItemSlNo"+vo.getStrItemSlNo()[i]);*/
				} 
				
				//////
				
				
				
				
				
				
			  bo.insert(vo);
				
			 
			  if(vo.getStrMsgType().equals("1")){
					throw new Exception(vo.getStrMsgString());
			  }
			  else{
				  formBean.setStrMsg("Record saved successfully");
			  }
			}
			catch(Exception e)
			{
				e.printStackTrace();
				strmsgText = "hisglobaltransactionutil.ReturnFromTransDATA.insert(vo) --> "
						+ e.getMessage();
				HisException eObj = new HisException(
						"mms",
						"ReturnFromTransDATA->insert()",
						strmsgText);
				formBean.setStrErr("Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");

				eObj = null;
			}
			finally {
				if (vo != null) vo = null;
				if(formBean != null) formBean = null;
				hisutil = null;
			}
		}
	
	public static void issueDtlsInitNEW(HttpServletRequest request,	HttpServletResponse response, ReturnFromTransFB formBean) 
	{

		String strSearchItemInitView = "",strPatientDtl="";

		ReturnFromTransBO bo = null;
		ReturnFromTransVO vo = null;

		try 
		{

			String strMode = (String) request.getParameter("strMode");
			String strFromStoreId = (String) request.getParameter("strStoreId");
			String strIssueNo = (String) request.getParameter("strIssueNo");
			String strIndentNo = (String) request.getParameter("strIndentNo");
			String crNo = (String) request.getParameter("crNo")==null?"0":(String) request.getParameter("crNo");			
			String strIndentDate = (String) request.getParameter("strIndentDate");
			bo = new ReturnFromTransBO();
			vo = new ReturnFromTransVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			System.out.println("---- ReturnFromTransDATA . issueDtlsInitNEW --[ pkg_mms_view.proc_issue_detail ]--");
			System.out.println("----------------------------------");
			System.out.println("--strMode        ----"+strMode);
			System.out.println("--strFromStoreId ----"+strFromStoreId);
			System.out.println("--strIssueNo     ----"+strIssueNo);
			System.out.println("--strIndentNo    ----"+strIndentNo);
			System.out.println("--crNo           ----"+crNo);
			System.out.println("----------------------------------");
			formBean.setStrFromStoreId(strFromStoreId);
			formBean.setStrModeVal(strMode);
			formBean.setStrIssueNo(strIssueNo);

			vo.setStrModeVal(formBean.getStrModeVal());
			vo.setStrFromStoreId(formBean.getStrFromStoreId());
			vo.setStrIssueNo(formBean.getStrIssueNo());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrStoreId(formBean.getStrFromStoreId());
			
			formBean.setStrCrno(crNo);
			vo.setStrCrno(crNo);
			
			System.out.println("************** IssueTransODATA --> afterIssueSave() --> PatientDtlHLP.patientWithAdmissionDtl **************");
			
			strPatientDtl=PatientDtlHLP.patientWithAdmissionDtl(crNo, formBean.getStrHospitalCode(), true);
			
			System.out.println("*************************************************");

		    vo.setStrPatientDtl(strPatientDtl);
		    
		    vo.setStrHospitalCode(formBean.getStrHospitalCode());		    
			bo.getIssueDtlsInitDtls(vo); // pkg_mms_view.Proc_Emp_Issue_Detail  --[ Mode- 5 ]
			
			/*
            1. Return No
            2. Return Date
            3. Patient Name ( Cr No ) @ issue By
            4. Store Name
            5. Generic Name
            6. Brand Name
            7. Batch No
            8. Expiry Date 
            9. Rate Wth Unit
           10. Issue Qty wth Unit
           11. Store Id
           12. Item Id
           13. Brand Id
           14. Batch No
           15. Exp Date
           16. Rate Per Unit
           17. Unit Id
           18. Rate Base Value
           19. NVL
           20. Req Unit Id
           21. Qty Base Value
           22. SL No
           23. Sl No
           24. Catg Code
           25. Rec by
           26. Remarks
           27.Loc @ Dl No
           28.CR No   
         */
			

			if (vo.getStrMsgType().equals("1"))
			{

				throw new Exception(vo.getStrMsgString());
			}
			
			while (vo.getWsIssueDetails().next()) 
			{
				
				vo.setStrIssueDate(vo.getWsIssueDetails().getString(2));
				vo.setStrNameWthCRNo(vo.getWsIssueDetails().getString(3).split("\\@")[0]);
 				vo.setStrStoreName(vo.getWsIssueDetails().getString(4));
 				vo.setStrUserName(vo.getWsIssueDetails().getString(3).split("\\@")[1]);
			}
			vo.getWsIssueDetails().beforeFirst();	
			
			if (vo.getStrMsgType().equals("1")) 
				throw new Exception(vo.getStrMsgString());			
 			 			
 			System.out.println("-WsIssueDetails --Size in HLP ----"+vo.getWsIssueDetails().size());
 			
 			vo.getWsIssueDetails().beforeFirst();
 			
 			String strAfterSaveVoucher = ReturnFromTransHLP.getAfterSaveVoucher(vo,"1");
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strAfterSaveVoucher);
			System.out.println("---- ReturnFromTransDATA . issueDtlsInitNEW --[ END ]--");
			
		} catch (Exception e) {
			e.printStackTrace();

			String strmsgText = "MmsDATA.issueDtlsInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.issueDtlsInit(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}
	
	public static void issueDtlsInitNEW_II(HttpServletRequest request,	HttpServletResponse response, ReturnFromTransFB formBean) 
	{

		String strSearchItemInitView = "",strPatientDtl="";

		ReturnFromTransBO bo = null;
		ReturnFromTransVO vo = null;

		try 
		{

			String strMode = (String) request.getParameter("strMode");
			String strFromStoreId = (String) request.getParameter("strStoreId");
			String strIssueNo = (String) request.getParameter("strIssueNo");
			String strIndentNo = (String) request.getParameter("strIndentNo");
			String crNo = (String) request.getParameter("crNo")==null?"0":(String) request.getParameter("crNo");			
			String strIndentDate = (String) request.getParameter("strIndentDate");
			bo = new ReturnFromTransBO();
			vo = new ReturnFromTransVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			System.out.println("---- ReturnFromTransDATA . issueDtlsInitNEW --[ pkg_mms_view.proc_issue_detail ]--");
			System.out.println("----------------------------------");
			System.out.println("--strMode        ----"+strMode);
			System.out.println("--strFromStoreId ----"+strFromStoreId);
			System.out.println("--strIssueNo     ----"+strIssueNo);
			System.out.println("--strIndentNo    ----"+strIndentNo);
			System.out.println("--crNo           ----"+crNo);
			System.out.println("----------------------------------");
			formBean.setStrFromStoreId(strFromStoreId);
			formBean.setStrModeVal(strMode);
			formBean.setStrIssueNo(strIssueNo);

			vo.setStrModeVal(formBean.getStrModeVal());
			vo.setStrFromStoreId(formBean.getStrFromStoreId());
			vo.setStrIssueNo(formBean.getStrIssueNo());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			//vo.setStrValue8(crNo);
			formBean.setStrCrno(crNo);
			
			System.out.println("************** IssueTransODATA --> afterIssueSave() --> PatientDtlHLP.patientWithAdmissionDtl **************");
			
			strPatientDtl=PatientDtlHLP.patientWithAdmissionDtl(formBean.getStrCrNo(), formBean.getStrHospitalCode(), true);
			
			System.out.println("*************************************************");

		    vo.setStrPatientDtl(strPatientDtl);
		    
		    vo.setStrHospitalCode(formBean.getStrHospitalCode());			
			bo.getImgHeader(vo);		    
			bo.getIssueDtlsInitDtls(vo); // pkg_mms_view.proc_issue_detail []

			if (vo.getStrMsgType().equals("1"))
			{

				throw new Exception(vo.getStrMsgString());
			}
			if (vo.getStrModeVal().equals("5")) 
			{
				formBean.setStrReturnReqNo(vo.getStrReturnReqNo());
				formBean.setStrSlNoflg("0");
				formBean.setStrBudget("0");
			}
			formBean.setStrIssueNo(strIssueNo);
			formBean.setStrIssueDate(vo.getStrIssueDate());
			formBean.setStrIssueTo(vo.getStrIssueTo());
			formBean.setStrItemCategoryId(vo.getStrItemCategoryNo());
			formBean.setWsIssueDetails(vo.getWsIssueDetails());

			while (formBean.getWsIssueDetails().next()) 
			{
				if (vo.getStrModeVal().equals("2")) 
				{
					formBean.setStrStoreName(formBean.getWsIssueDetails()
							.getString(4));
					formBean.setStrFinalRemarks(formBean.getWsIssueDetails()
							.getString(27));
					formBean.setStrItemWiseCost(formBean.getWsIssueDetails()
							.getString(29));
					formBean.setStrBudget(formBean.getWsIssueDetails()
							.getString(30));
					formBean.setStrIndentNo(formBean.getWsIssueDetails()
							.getString(31));
					formBean.setStrIndentDate(formBean.getWsIssueDetails()
							.getString(32));

				}
				 if(vo.getStrModeVal().equals("1")) {
						formBean.setStrStoreName(formBean.getWsIssueDetails()
								.getString(4)); 
						formBean.setStrUserName(formBean.getWsIssueDetails()
								.getString(34));
					 }
				if (vo.getStrModeVal().equals("4")) {
					formBean.setStrFinalRemarks(formBean.getWsIssueDetails()
							.getString(29));
					formBean.setStrItemWiseCost(formBean.getWsIssueDetails()
							.getString(30));
					formBean.setStrBudget(formBean.getWsIssueDetails()
							.getString(31));
					formBean.setStrStoreName(formBean.getWsIssueDetails()
							.getString(3).split("@")[0]);
					formBean.setStrOrgName(formBean.getWsIssueDetails().getString(4));
				}
			}

			formBean.getWsIssueDetails().beforeFirst();

			if (!vo.getStrModeVal().equals("2")) {
				formBean.setStrIndentDate(strIndentDate);
				formBean.setStrIndentNo(strIndentNo);
			}
			formBean.setStrSlNoflg(vo.getStrSlNoflg());
			System.out.println("---- ReturnFromTransHLP.getIssueDtlsInitViewNEW ----");
			strSearchItemInitView = ReturnFromTransHLP.getIssueDtlsInitViewNEW(formBean);
			//System.out.println("strSearchItemInitView" + strSearchItemInitView);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strSearchItemInitView);
			System.out.println("---- ReturnFromTransDATA . issueDtlsInitNEW --[ END ]--");
			
		} catch (Exception e) {
			e.printStackTrace();

			String strmsgText = "MmsDATA.issueDtlsInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.issueDtlsInit(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}
	
	public static void initViewPageDtl(ReturnFromTransFB formBean,HttpServletRequest request)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
	       ReturnFromTransVO vo = null;
		   ReturnFromTransBO bo = null;
		   HisUtil hisUtil;
		   try
		   {
			    /* Create Object */
			    hisUtil = new HisUtil("MMS", "ReturnFromTransDATA");
			         vo = new ReturnFromTransVO();
			   	     bo = new ReturnFromTransBO();
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			   	/* Calling BO method */
			   	bo.initForViewPage(vo);
			   
			   	formBean.setStrStoreName(vo.getStrStoreName());
			   	formBean.setStrFromDate(hisUtil.getASDate("dd-MMM-yyyy"));
			   	formBean.setStrToDate(hisUtil.getASDate("dd-MMM-yyyy"));
			   	formBean.setStrItemCatgCombo(vo.getStrItemCategoryCmb());
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "OfflineIssueIndentTransDATA->initViewPageDtl()", strmsgText);
				formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				formBean.setStrMsgType("1");
				eObj = null;
		   }
		   
	}
	
	public static void getViewDtlNEW(ReturnFromTransFB formBean,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   ReturnFromTransVO vo = null;
		   ReturnFromTransBO bo = null;
		   try
		   {
			    /* Creating Object */   	
			    vo=new ReturnFromTransVO();
			   	bo=new ReturnFromTransBO();
			   	/* Value set in Value Object */
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreName(request.getParameter("storeId"));
			   	vo.setStrCrNo(request.getParameter("itemCatNo"));
			   	vo.setStrFromDate(request.getParameter("fromDate"));
			   	vo.setStrToDate(request.getParameter("ToDate"));
                
                /* Calling BO method */
			   	
			    bo.setViewPageDtl(vo);
			    
			    String strReturnDtl = ReturnFromTransHLP.getReturnDetailNEW(vo.getReturnNoDtlWs());

			   // bo.getCRViewDtl(vo);
			    
			   //String strIssueDtl = ReturnFromTransHLP.getIssuedDetailNEW(vo.getIssueNoDtlWs());

			    
			    if(strReturnDtl!= null && !strReturnDtl.equals(""))
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	//response.getWriter().print(strIssueDtl+"$"+strReturnDtl);
				 	response.getWriter().print(strReturnDtl); 
				}
				else
				{
				    HisException eObj = new HisException("MMS", "ReturnFromTransDATA->getViewDtl()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }
			   
			    
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "ReturnFromTransDATA->getViewDtl()", strmsgText);
				formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				formBean.setStrMsgType("1");
				eObj = null;
		   }
		   
	}
	
	
	
	
}
