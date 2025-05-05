package mms.transactions.controller.data;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.MmsConfigUtil;
import mms.patDtl.PatientDtlHLP;
import mms.transactions.bo.PatientReturnTransBO;
import mms.transactions.controller.fb.PatientReturnTransFB;
import mms.transactions.controller.hlp.PatientReturnTransHLP;
import mms.transactions.vo.PatientReturnTransVO;

public class PatientReturnTransDATA {

	
	public static void getMmsConfigFlags(PatientReturnTransFB formBean, HttpServletRequest request, 
			HttpServletResponse response) 
	{
				formBean.setStrWithOutCrNoFlg("1");
				formBean.setStrCrNoDefault("1");
	}
	
	public static void storeName(PatientReturnTransFB formBean,HttpServletRequest request) {
		PatientReturnTransVO vo=null;
		PatientReturnTransBO bo= null;
		HisUtil hisUtil = null;
		String strCmb = "";
		
		
		try {
			System.out.println("------------ testDATA .issueNoCombo  ------------");
			
			vo = new PatientReturnTransVO();
			bo = new PatientReturnTransBO();
			
			/*String strConfCatCode = MmsConfigUtil.STAFF_CAT_CODE;
			formBean.setStrConfCatCode(strConfCatCode);
			vo.setStrConfCatCode(strConfCatCode);//12
			*/
			
			hisUtil = new HisUtil("mms", "testDATA");
						
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();
			String strMode = request.getParameter("mode");

			System.out.println("hosCode-->"+hosCode);
			System.out.println("seatid-->"+seatid);
			System.out.println("strMode-->"+strMode);
			

			formBean.setStrMode(strMode);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			
			bo.getStoreDtls(vo);

		   	formBean.setStrFromDate(hisUtil.getASDate("dd-MMM-yyyy"));
		   	formBean.setStrToDate(hisUtil.getASDate("dd-MMM-yyyy"));

			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
						
			if(vo.getStrStoreWs()!= null && vo.getStrStoreWs().size() > 0){
				if(vo.getStrStoreWs().next())
				{
				vo.setStrStoreId(vo.getStrStoreWs().getString(1));
				formBean.setStrStoreId(vo.getStrStoreWs().getString(1));
				vo.getStrStoreWs().beforeFirst();
				}
			    strCmb = hisUtil.getOptionValue(vo.getStrStoreWs(),(formBean.getStrId()!=null && !formBean.getStrId().equals(""))?formBean.getStrId():"" , "", true);
			}
			else
			{
				strCmb = "<option value='0'>Select Value</option>";
			}
			formBean.setStrStoreValues(strCmb);
			
						
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "testDATA->storeName()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
		}
	}
	
	public static void itemCategory(PatientReturnTransFB formBean,HttpServletRequest request,HttpServletResponse response)
	{
			String strmsgText = "";
			PatientReturnTransVO vo=null;
			PatientReturnTransBO bo= null;
			HisUtil hisutil = null;	
				String strHospitalCode = "";  
				String storeId = "";
				String mode = "";
				String itemCatCmb = "";
			
				try {
					System.out.println("------------ testDATA .itemCategory  ------------");
		
					bo = new PatientReturnTransBO();
					vo = new PatientReturnTransVO();
					
					strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
					storeId = (String)request.getParameter("storeid");
					mode =  (String)request.getParameter("modeVal");
					
					System.out.println("strHospitalCode-->"+strHospitalCode);
					System.out.println("storeId-->"+storeId);
					System.out.println("modeVal-->"+mode);
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
					
					bo.getItemCategoryList(vo);
					
					if (vo.getStrMsgType().equals("1"))
					{
						throw new Exception(vo.getStrMsgString());
					} 
					
					hisutil = new HisUtil("mms", "testDATA");
					
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
					strmsgText = "transactions.testDATA.itemCategory(vo) --> "+ e.getMessage();
				HisException eObj = new HisException("mms","testDATA->itemCategory()", strmsgText);
				try {
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print("ERROR#### Application Error [ERROR ID : "+ eObj.getErrorID()+ "],Contact System Administrator! ");
				} catch (Exception e1) {
				}
					eObj = null;
				} finally {
					vo = null;
					bo = null;
					hisutil = null;
				}
	}
	
	public static boolean patientDetailNEW(PatientReturnTransFB formBean, HttpServletRequest request){

	boolean fRes = true;
	
	PatientReturnTransVO vo=null;
	PatientReturnTransBO bo= null;
		
		HisUtil hisutil = null;
		String strmsgText = null;
		String strPatientDetailhlp = "";
				
			try {
				bo = new PatientReturnTransBO();
				vo = new PatientReturnTransVO();
			
				formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

				vo.setStrHospitalCode(formBean.getStrHospitalCode());
				vo.setStrSeatId(formBean.getStrSeatId());

				System.out.println("formBean.getStrHospitalCode()-->"+formBean.getStrHospitalCode());
				System.out.println("formBean.getStrSeatId()-->"+formBean.getStrSeatId());
				
				System.out.println("formBean.getStrStoreId()-->"+formBean.getStrStoreId());
				System.out.println("formBean.getStrItemCatId()-->"+formBean.getStrItemCatId());
				System.out.println("formBean.getStrCrNo()-->"+formBean.getStrCrNo());

				try
				{
					strPatientDetailhlp = hisglobal.tools.hlp.PatientDtlHLP.patientWithAdmissionDtlNEW(formBean.getStrCrNo(), formBean.getStrHospitalCode(), true);
				} 
				catch(Exception e)
				{							
					throw new Exception("Invalid C.R. No.");
				}
				formBean.setStrPatientDetail(strPatientDetailhlp);
				
				get_Issued_Item_All_List(formBean,request);
				recommendedBy(formBean,request);
				
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}
			} 
			catch (Exception e) 
			{
		         if(e.getMessage().contains("C.R."))
		         {
	         		 formBean.setStrErrMsg("Invalid CR. No.");
	         	 }
		         else
		         {
	         		strmsgText = "PatientReturnTransDATA.patientDetail(vo) --> "+ e.getMessage();
			        HisException eObj = new HisException("mms","testDATA->patientDetail()", strmsgText);
			        formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
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
/*
	public static boolean validateIssueNumber(PatientReturnTransFB formBean, HttpServletRequest request,HttpServletResponse response) 
	{
		PatientReturnTransVO vo=null;
		PatientReturnTransBO bo= null;
		MmsConfigUtil mcu = null;
		boolean bFlag=false;
		String strCurrentDate;
		HisUtil hisutil = null;
		try {
			vo = new PatientReturnTransVO();
			bo = new PatientReturnTransBO();
			hisutil = new HisUtil("mms", "testDATA");
			
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			formBean.setStrHospitalCode(strHospitalCode);
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(strCurrentDate);
			
			vo.setStrReturnDrugValidity(mcu.getStrReturnDrugValidity());
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrIssueNumber(formBean.getStrIssueNumber());
			
			
			bo.validateIssueNumber(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
		
			if(vo.getStrIssueNumberValidationFlag()!=null && vo.getStrIssueNumberValidationFlag().equals("0"))
			{
				formBean.setStrErrMsg("Drugs Return Validity Date Exceeded");
			}
			else
			{
				bFlag=true;
			}
			
						
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "testDATA->validateIssueNumber()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
		}
		
		return bFlag;
	}
*/
	
	/*public static void issueNoCombo(PatientReturnTransFB formBean,HttpServletRequest request) 
	{
		PatientReturnTransVO vo=null;
		PatientReturnTransBO bo= null;
		String strmsgText = "";
		
		MmsConfigUtil mcu = null;
		String strIssueCmb = "";
		String strStoreId = "";
		String strCatNo = "";
		String strCrNo = "";
		String mode = "";
	
		HisUtil hisutil = null;
		
		try 
		{
			bo = new PatientReturnTransBO();
			vo = new PatientReturnTransVO();
			
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			hisutil = new HisUtil("","");
	        
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			strStoreId = request.getParameter("storeHidId");
			strCatNo = request.getParameter("itemCatHidId");
			strCrNo = request.getParameter("crNoHid");
			mode = request.getParameter("strMode");
			
			System.out.println("formBean.getStrHospitalCode()-->"+formBean.getStrHospitalCode());
			System.out.println("formBean.getStrSeatId()-->"+formBean.getStrSeatId());
			System.out.println("storeHidId-->"+strStoreId);
			System.out.println("itemCatHidId-->"+strCatNo);
			System.out.println("crNoHid-->"+strCrNo);
			System.out.println("strMode-->"+mode);
	
			formBean.setStrStoreId(strStoreId);
			formBean.setStrItemCategoryNo(strCatNo);
			formBean.setStrCrNo(strCrNo);
	
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrItemCatId(formBean.getStrItemCatId());
			vo.setStrCrNo(formBean.getStrCrNo());
			
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
					vo.setStrReqTypeId("32");
			}else
			{
				vo.setStrReqTypeId("32");
			}
			
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
			
			hisutil = new HisUtil("mms", "testDATA");
			
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
				HisException eObj = new HisException("mms", "testDATA->issueNoCombo()", strmsgText);
				formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
	
	}
	*/
	
	public static void recommendedBy(PatientReturnTransFB formBean,HttpServletRequest request) {
		PatientReturnTransVO vo=null;
		PatientReturnTransBO bo= null;
		HisUtil hisutil = null;
		String strRecommendCmb = "";
		
		
		
		try {
			System.out.println("------------ PatientDtlHLP .recommendedBy  ------------");
			
			vo = new PatientReturnTransVO();
			bo = new PatientReturnTransBO();
			
			hisutil = new HisUtil("mms", "testDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
					
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
								
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
						
			bo.getRecommendName(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			if(vo.getRecommendNameWS()!= null && vo.getRecommendNameWS().size() > 0){
			    strRecommendCmb = hisutil.getOptionValue(vo.getRecommendNameWS(),"", "", false);
			}else{
				strRecommendCmb = "<option value='0'>Select Value</option>";
			}
			formBean.setStrRecommendNameCombo(strRecommendCmb);
						
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "testDATA->recommendedBy()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
		}
	}
	
	public static void getpatientDemographicDetail(PatientReturnTransFB formBean,
			HttpServletRequest request) 
	{
		
		PatientReturnTransVO vo=null;
		PatientReturnTransBO bo= null;
		MmsConfigUtil mcu = null;
			HisUtil hisutil = null;
			String strmsgText = null;
			String strPatientDetailhlp = "";
					
				try {
					bo = new PatientReturnTransBO();
					vo = new PatientReturnTransVO();
					mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
									
					String strIssueMode = mcu.getStrIssueMode();
					formBean.setStrIssueMode(strIssueMode);
					
					formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					
					vo.setStrHospitalCode(formBean.getStrHospitalCode());
					vo.setStrSeatId(formBean.getStrSeatId());
					vo.setStrId(formBean.getStrId());
					vo.setStrIssueNumber(formBean.getStrIssueNumber());
					
					bo.getpatientDemographicDetail(vo);
					
					if(vo.getWrsData().next())
					{
						formBean.setStrPatientName(vo.getWrsData().getString("HSTSTR_PATIENT_NAME"));
						formBean.setStrPatientAge(vo.getWrsData().getString("AGE"));
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
				 strmsgText = "testDATA.getpatientDemographicDetail(vo) --> "+ e.getMessage();
		         HisException eObj = new HisException("mms","testDATA->getpatientDemographicDetail()", strmsgText);
				 eObj = null;
				} 
				finally
				{
					
					if (bo != null)bo = null;
					if (vo != null)vo = null;
					if (hisutil != null)hisutil = null;
				}
							
	}

	public static void get_Issued_Item_All_List(PatientReturnTransFB formBean,
			HttpServletRequest request) {
	
		PatientReturnTransVO vo=null;
		PatientReturnTransBO bo= null;
		String strmsgText = "";
		String hosCode = "";
		String strHlp = "";
		String storeId  = "",itemCatgId="",crNo="" ;
		
		try {
	
			bo = new PatientReturnTransBO();
			vo = new PatientReturnTransVO();
	
				hosCode    = request.getSession().getAttribute("HOSPITAL_CODE").toString();
				crNo       = (String)formBean.getCrNoHid();
				storeId    = (String)formBean.getStoreHidId();
				itemCatgId = (String)formBean.getItemCatHidId();
				
		/*  <forward name="index" path="/transactions/patientReturn_mms_trans.jsp"> </forward>

			<input type="hidden" name="storeHidId" value="${patientReturnBean.storeHidId}" />
			<input type="hidden" name="itemCatHidId" value="${patientReturnBean.itemCatHidId}" />
			<input type="hidden" name="crNoHid" value="${patientReturnBean.crNoHid}" />				*/
				
				System.out.println("hosCode--->"+hosCode+"itemCatgId-->"+itemCatgId+"storeId-->"+storeId+"crNo-->"+crNo);
	
				vo.setStrHospitalCode(hosCode);
				vo.setStrStoreId(storeId);
				vo.setStrItemCat(itemCatgId);
				vo.setStrCrNo(crNo);
				
				bo.getItem_ALL_LIST(vo);
		
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}
				else 
				{
					strHlp = PatientReturnTransHLP.patientInjectioAdministrationDtl(vo.getStrHospitalCode(), vo.getItemDetailsWS(),vo);
					formBean.setStrIpdIssueDrugHLP(strHlp);
				}
				//recommendedBy(formBean,request);
				
				//issueNoCombo(formBean, request);
		
		 }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "PatientReturnTransDATA->getItem_ALL_LIST()", strmsgText);
				formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				eObj = null;
		   }
		   finally 
		   {
				  bo = null;
				  vo = null;
			}
	}
	
	public static void insert_LIST(PatientReturnTransFB formBean,HttpServletRequest request)
	{
		PatientReturnTransVO vo=null;
		PatientReturnTransBO bo= null;
		
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
			  bo = new PatientReturnTransBO();
			  vo = new PatientReturnTransVO();
			  
			  formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			  formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			  
			  strStoreId    = (String) request.getParameter("storeHidId");
			  strItemCategoryNo = (String) request.getParameter("itemCatHidId");
			  strCrNo  = (String) request.getParameter("crNoHid");
			  mode = (String) request.getParameter("mode");
	
			  System.out.println("strStoreId---->"+strStoreId);
			  System.out.println("strItemCategoryNo----->"+strItemCategoryNo);
			  System.out.println("strCrNo----->"+strCrNo);
			  System.out.println("mode----->"+mode);

System.out.println("strStoreId-->"+formBean.getStoreHidId() +"strItemCategoryNo-->"+formBean.getItemCatHidId()+"strCrNo-->"+formBean.getCrNoHid()+"mode-->"+mode);
			  
			  hisutil = new HisUtil("mms", "testDATA");
			  String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			  formBean.setStrReturnDate(ctDate);
			  
			  String[] temp = formBean.getStrPatientDtlHidVal().replace("^", "#").split("#");
			  System.out.println(Arrays.toString(temp));
			  System.out.println("Contents of the array:");
			  for (String element : temp) {
			      System.out.println(element);
			  }
			  
			  if(temp.length>=7)
				  formBean.setStrEmpNo(temp[6]);
			  else
				  formBean.setStrEmpNo("0");
			  //20-APR-82^1^11^11^^0^PGIPER10000012
			  
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
			 
			 /* if(mode.equals("0")){
				  formBean.setStrReqTypeId("41");
				}else if(mode.equals("1")){
					formBean.setStrReqTypeId("42");
				}else if(mode.equals("2")){
					//if(formBean.getStrChkBoth().equals("1")){
						formBean.setStrReqTypeId("41");
					//}else{
					//	formBean.setStrReqTypeId("42");
					//}
				}else{*/
					formBean.setStrReqTypeId("41");
			//	}
			  formBean.setStrStoreId(strStoreId);
			  formBean.setStrCrNo(strCrNo);
			  formBean.setStrItemCategoryNo(strItemCategoryNo);				  
			  formBean.getStrIssueDate();
			  
			  //10100000^11100030^310000^310000100^1000^6301^200 Each^200^6301^1^12-JUN-09^Yes^10 Each^5 Each^100^6301^1
					  
			  
			  int nMultiRowLen = formBean.getStrReturnQty().length;
			  System.out.println("nMultiRowLen"+nMultiRowLen);
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
					
					//String[] Temp = formBean.getStrReturnQtyUnitId()[i].replace("^", "#").split("#"); //value="6301^1^0">
					//strReturnQtyUnitID[i] = Temp[0];
					strReturnQtyUnitID[i] = "6301";
	
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
					    formBean.setStrErrMsg(vo.getStrMsgString().split("\\##")[1]);
				    }
					else
					{
						formBean.setStrErrMsg(vo.getStrMsgString());
					    throw new Exception(vo.getStrMsgString());
					}	
			  }
			  else{
				  formBean.setStrNormalMsg("Return Request No [ "+vo.getStrReturnNo()+" ] for CR No [ "+vo.getStrCrNo()+" ] Saved Successfully!!");
				  formBean.setCrNoHid(vo.getStrCrNo());
			  }
			  
			  formBean.setStrNormalMsg("----------- DATA. insert_LIST------END---------");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				strmsgText = "hisglobaltransactionutil.testDATA.insert(vo) --> "+ e.getMessage();
				HisException eObj = new HisException("mms","testDATA->insert()",strmsgText);
				formBean.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");
				eObj = null;
			}
			finally {
				if (vo != null) 
					vo = null;
				if(formBean != null) 
					formBean = null;
				hisutil = null;
			}
		}
	
	public static void issueDtlsInitNEW_Voucher(HttpServletRequest request,	HttpServletResponse response, PatientReturnTransFB formBean) 
	{

		String strSearchItemInitView = "",strPatientDtl="";

		PatientReturnTransBO bo = null;
		PatientReturnTransVO vo = null;

		try 
		{

			bo = new PatientReturnTransBO();
			vo = new PatientReturnTransVO();
			
			String strMode = (String) request.getParameter("strMode");
			String strFromStoreId = (String) request.getParameter("strStoreId");
			String strReturnNo = (String) request.getParameter("strIssueNo");
			String crNo = (String) request.getParameter("crNo")==null?"0":(String) request.getParameter("crNo");			
		
			System.out.println("---- PatientReturnTransDATA.issueDtlsInitNEW_Voucher --[ pkg_mms_view.proc_issue_detail ]--");
			System.out.println("----------------------------------");
			System.out.println("--strMode ------------"+strMode);
			System.out.println("--strStoreId ---------"+strFromStoreId);
			System.out.println("--strReturnNo     ----"+strReturnNo);
			System.out.println("--crNo           -----"+crNo);
			System.out.println("----------------------------------");
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			formBean.setStrModeVal(strMode);
			formBean.setStrFromStoreId(strFromStoreId);
			formBean.setStrReturnNo(strReturnNo);

			vo.setStrModeVal(formBean.getStrModeVal());
			vo.setStrFromStoreId(formBean.getStrFromStoreId());
			vo.setStrReturnNo(formBean.getStrReturnNo());
			
			formBean.setCrNoHid(crNo);
			vo.setStrCrNo(crNo);
			
			strPatientDtl=PatientDtlHLP.patientWithAdmissionDtl(crNo, formBean.getStrHospitalCode(), true);
		    vo.setStrPatientDtl(strPatientDtl);
		    
			bo.issueDtlsInitNEW_Voucher(vo); // pkg_mms_view.Proc_Emp_Issue_Detail  --[ Mode- 5 ]

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
	       29.
	       30.
	     */
			

			if (vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			while (vo.getWsIssueDetails().next()) 
			{
				vo.setStrIssueDate(vo.getWsIssueDetails().getString(2));
				vo.setStrNameWthCRNo(vo.getWsIssueDetails().getString(3).split("\\@")[0]);
				vo.setStrUserName(vo.getWsIssueDetails().getString(3).split("\\@")[1]);
				vo.setStrStoreName(vo.getWsIssueDetails().getString(4));
				
				vo.setStrReturnNo(vo.getWsIssueDetails().getString(1));
				vo.setStrReturnDate(vo.getWsIssueDetails().getString(2));
				vo.setStrCrNo(vo.getWsIssueDetails().getString(28));


			}
			
			vo.getWsIssueDetails().beforeFirst();

			String strAfterSaveVoucher = PatientReturnTransHLP.getAfterSaveVoucher(vo,"1");
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strAfterSaveVoucher);
			
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
	
	public static void initViewPageDtl(PatientReturnTransFB formBean,HttpServletRequest request)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
	       PatientReturnTransVO vo = null;
		   PatientReturnTransBO bo = null;
		   HisUtil hisUtil;
		   try
		   {
			    /* Create Object */
			    hisUtil = new HisUtil("MMS", "testDATA");
			         vo = new PatientReturnTransVO();
			   	     bo = new PatientReturnTransBO();
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			   	/* Calling BO method */
			   	bo.initForViewPage(vo);
			   
			   	formBean.setStrStoreValues(vo.getStrStoreName());
			   	formBean.setStrFromDate(hisUtil.getASDate("dd-MMM-yyyy"));
			   	formBean.setStrToDate(hisUtil.getASDate("dd-MMM-yyyy"));
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "OfflineIssueIndentTransDATA->initViewPageDtl()", strmsgText);
				formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				formBean.setStrMsgType("1");
				eObj = null;
		   }
		   
	}
	
	public static void getViewDtlNEW(PatientReturnTransFB formBean,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   PatientReturnTransVO vo = null;
		   PatientReturnTransBO bo = null;
		   try
		   {
			    vo=new PatientReturnTransVO();
			   	bo=new PatientReturnTransBO();

			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreName(request.getParameter("storeId"));
			   	vo.setStrCrNo(request.getParameter("crNo"));
			   	vo.setStrFromDate(request.getParameter("fromDate"));
			   	vo.setStrToDate(request.getParameter("ToDate"));
			   	
			   	System.out.println("request.getParameter('storeId')"+request.getParameter("storeId"));
			   	System.out.println("request.getParameter('crNo')"+request.getParameter("crNo"));
			   	System.out.println("request.getParameter('fromDate')"+request.getParameter("fromDate"));
			   	System.out.println("request.getParameter('ToDate')"+request.getParameter("ToDate"));
			   	
			    bo.setViewPageDtl(vo);
			    
			    String strReturnDtl = PatientReturnTransHLP.getReturnDetailNEW(vo.getReturnNoDtlWs());

			    if(strReturnDtl!= null && !strReturnDtl.equals(""))
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strReturnDtl); 
				}
				else
				{
				    HisException eObj = new HisException("MMS", "PatientReturnTransDATA->getViewDtl()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	}
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "PatientReturnTransDATA->getViewDtl()", strmsgText);
				formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				formBean.setStrMsgType("1");
				eObj = null;
		   }
		   
	}
	
	
}