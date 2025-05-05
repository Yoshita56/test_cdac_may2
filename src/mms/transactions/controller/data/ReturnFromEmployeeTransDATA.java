/**
 * 
 */
package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.transactions.bo.ReturnFromEmployeeTransBO;
import mms.transactions.controller.fb.ReturnFromEmployeeTransFB;
import mms.transactions.controller.hlp.ReturnFromEmployeeTransHLP;
import mms.transactions.vo.ReturnFromEmployeeTransVO;

/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Date : 17/June/2009
 * 
 */

public class ReturnFromEmployeeTransDATA {
	
	/**
	 * This function is used to set initial parameters required to display on main page 
	 * @param formBean
	 */
	public static void storeName(ReturnFromEmployeeTransFB formBean,HttpServletRequest request) {
		ReturnFromEmployeeTransVO vo=null;
		ReturnFromEmployeeTransBO bo= null;
		HisUtil hisutil = null;
		String strCmb = "";
		String strStoreComboId ="";
		String strCategoryValues ="";
		
		try {
			vo = new ReturnFromEmployeeTransVO();
			bo = new ReturnFromEmployeeTransBO();
			
			hisutil = new HisUtil("mms", "ReturnFromEmployeeTransDATA");
						
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();
			
			
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
			    strCmb = hisutil.getOptionValue(vo.getStoreNameWS(),
					"0", "", true);
			}else{
				strCmb = "<option value='0'>Select Value</option>";
			}
			formBean.setStrStoreNameCombo(strCmb);
			
			if(!formBean.getStrStoreId().equals(""))
				strStoreComboId = formBean.getStrStoreId();
			else
					strStoreComboId = request.getParameter("storeComboId");
			vo.setStrStoreId(strStoreComboId);
			
			if (strStoreComboId.equals("0")) 
			{
				strCategoryValues = "<option value='0'>Select Value</option>";
			} 
			else 
			{
				vo.setStrReqTypeId("43");
				bo.getItemCategory(vo);
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}
				if(vo.getItemCategoryWS()!= null
						&& vo.getItemCategoryWS().size() > 0){
					if(vo.getItemCategoryWS().next())
					{
						vo.setStrItemCategoryNo(vo.getItemCategoryWS().getString(1));
						formBean.setStrItemCategoryNo(vo.getItemCategoryWS().getString(1));
						vo.getItemCategoryWS().beforeFirst();
					}
					strCategoryValues = hisutil.getOptionValue(vo.getItemCategoryWS(), "0", "",true);
				} 
				else 
				{
					strCategoryValues = "<option value='0'>Select Value</option>";
					vo.setStrItemCategoryNo("0");
					formBean.setStrItemCategoryNo("0");
				}
				formBean.setStrItemCategoryCombo(strCategoryValues);	
			}
						
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "ReturnFromEmployeeTransDATA->storeName()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
		}
	}
	
	/**
	 * To get values of Item Category
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void itemCategory(ReturnFromEmployeeTransFB formBean,
			HttpServletRequest request,HttpServletResponse response){
		
			
			String strmsgText = "";
			ReturnFromEmployeeTransVO vo=null;
			ReturnFromEmployeeTransBO bo= null;
			HisUtil hisutil = null;	
				String strHospitalCode = "";  
				String storeId = "";
				String itemCatCmb = "";
			
				try {
		
					bo = new ReturnFromEmployeeTransBO();
					vo = new ReturnFromEmployeeTransVO();
					
					strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
				
					storeId =(String) request.getParameter("storeid");
					
					
					if (storeId == null)
							storeId = "0";
				    
					vo.setStrHospitalCode(strHospitalCode);
					vo.setStrStoreId(storeId);
					vo.setStrReqTypeId("43");
					
					
					bo.getItemCategory(vo);
					
					if (vo.getStrMsgType().equals("1"))
					{
						throw new Exception(vo.getStrMsgString());
					} 
					
					hisutil = new HisUtil("mms", "ReturnFromEmployeeTransDATA");
					
					if(vo.getItemCategoryWS()!= null
							&& vo.getItemCategoryWS().size() > 0){
					    itemCatCmb = hisutil.getOptionValue(vo.getItemCategoryWS(), 
							"", "", false);
					}else{
						itemCatCmb = "<option value='0'>Select Value</option>";
					}
						
					try {									
						    response.setHeader("Cache-Control", "no-cache");
							response.getWriter().print(itemCatCmb);
							
					}catch(Exception e){
						}
				
				} catch (Exception e) {
					strmsgText = "transactions.ReturnFromEmployeeTransDATA.itemCategory(vo) --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"ReturnFromEmployeeTransDATA->itemCategory()", strmsgText);
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
	
	public static boolean employeeDetail(ReturnFromEmployeeTransFB formBean,
			HttpServletRequest request){

			boolean fRes = true;
		
		ReturnFromEmployeeTransVO vo=null;
		ReturnFromEmployeeTransBO bo= null;
		
			HisUtil hisutil = null;
			String strmsgText = null;
			String strEmpDetailhlp = "";
					
				try {
					bo = new ReturnFromEmployeeTransBO();
					vo = new ReturnFromEmployeeTransVO();
				
					formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				
					
					vo.setStrEmpNo(formBean.getStrEmpNo());
					vo.setStrHospitalCode(formBean.getStrHospitalCode());
					
					
					bo.getEmpDtl(vo);	
					
					if (vo.getStrMsgType().equals("1")) {
						throw new Exception(vo.getStrMsgString());
					}else{
						
							if(vo.getStrChkEmpExist().equals("0")){
								formBean.setStrChkEmpExist(vo.getStrChkEmpExist());
								formBean.setStrErr("!!!Employee Number does not Exist/Data not Found!!!");
								return false;
							}
							else{
								formBean.setStrChkEmpExist(vo.getStrChkEmpExist());
								strEmpDetailhlp = ReturnFromEmployeeTransHLP.getEmployeeDtl(vo.getEmployeeWs());
								formBean.setStrEmployeeDtl(strEmpDetailhlp);
				       			recommendedBy(formBean,request);
								
								issueNoCombo(formBean, request);
								return true;
				    
							}
					         			  
					}
					
					
					
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
					 strmsgText = "ReturnFromEmployeeTransDATA.employeeDetail(vo) --> "+ e.getMessage();
			         HisException eObj = new HisException("mms","ReturnFromEmployeeTransDATA->employeeDetail()", strmsgText);
			         
			         	if(e.getMessage().contains("C.R.")){
			         		
			         		 formBean.setStrErr("Invalid CR. No.");
			         		
			         	}else{
			         		
			         		formBean.setStrErr("Application Error [ERROR ID : "
									+ eObj.getErrorID()
									+ "],Contact System Administrator! ");
			         	}
			        
			        	
			         
			         fRes = false;
			         
					 eObj = null;
				} finally {
					
					if (bo != null)bo = null;
					if (vo != null)vo = null;
					if (hisutil != null)hisutil = null;
				}
				
				return fRes;
		}
	
	/**
	 * Method is Used to Populate the Data on Same Page.
	 * @param formBean
	 * @param request
	 */
	public static void issueNoCombo(ReturnFromEmployeeTransFB formBean,HttpServletRequest request) 
	{
		ReturnFromEmployeeTransVO vo=null;
		ReturnFromEmployeeTransBO bo= null;
		String strmsgText = "";
		
		MmsConfigUtil mcu = null;
		String hosCode = "";
		String seatId  = "";
		String strIssueCmb = "";
		String strStoreId = "";
		String strCatNo = "";
		String empNO = "";
		HisUtil hisutil = null;
		
		
		try 
		{
			bo = new ReturnFromEmployeeTransBO();
			vo = new ReturnFromEmployeeTransVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
            hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatId = request.getSession().getAttribute("SEATID").toString();
			strStoreId = request.getParameter("strId");
			strCatNo = request.getParameter("itemCategory");
			empNO = (String) request.getParameter("empNo");
			
			
			formBean.setStrStoreId(strStoreId);
			formBean.setStrItemCategoryNo(strCatNo);
			formBean.setStrEmpNo(empNO);
			formBean.setStrReqTypeId("34");
			
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrFinStartDate(mcu.getStrFinancialStartDate(strStoreId ,hosCode ));
			vo.setStrFinEndDate(mcu.getStrFinancialEndDate(strStoreId , hosCode));
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			vo.setStrEmpNo(formBean.getStrEmpNo());
			vo.setStrReqTypeId(formBean.getStrReqTypeId());
			
						
			bo.getIssueNoCombo(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			hisutil = new HisUtil("mms", "ReturnFromEmployeeTransDATA");
			
			if(vo.getIssueNoWS()!= null
					&& vo.getIssueNoWS().size() > 0){
			    strIssueCmb = hisutil.getOptionValue(vo.getIssueNoWS(), 
					"", "0^Select Value", false);
			}else{
				strIssueCmb = "<option value='0'>Select Value</option>";
			}
			
			formBean.setStrIssueNoCombo(strIssueCmb);
									
		}
		  catch (Exception e) 
		  {
			  e.printStackTrace();
			    strmsgText = e.getMessage();
				HisException eObj = new HisException("mms", "ReturnFromEmployeeTransDATA->issueNoCombo()", strmsgText);
				formBean.setStrErr("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	/**
	 * To get Issue details on the basis of Issue no, store id and hosp code
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getIssueDetails(ReturnFromEmployeeTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReturnFromEmployeeTransVO vo=null;
		ReturnFromEmployeeTransBO bo= null;
		String strmsgText = "";
		String hosCode = "";
		String strIssueNo = "";
		String strIssueDetails = "";
		String strHlp = "";
		
		try {

			bo = new ReturnFromEmployeeTransBO();
			vo = new ReturnFromEmployeeTransVO();

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			strIssueNo = (String) request.getParameter("issueNo");
						
			formBean.setStrIssueNo(strIssueNo);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrIssueNo(formBean.getStrIssueNo());
			
			bo.getIssueDetails(vo);
			bo.getItemDetail(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			else {
                  
				strHlp = ReturnFromEmployeeTransHLP.getItemDetails(vo.getStrItemCategoryNo(),vo.getStrHospitalCode(), vo
						.getItemDetailsWS(),vo.getStrStoreId());
				
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
			strmsgText = "ReturnFromEmployeeTransDATA.getIssueDetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReturnFromEmployeeTransDATA->getIssueDetails()", strmsgText);
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
	
	/**
	 * This function is used to set initial parameters required to display on main page 
	 * @param formBean
	 */
	public static void recommendedBy(ReturnFromEmployeeTransFB formBean,HttpServletRequest request) {
		ReturnFromEmployeeTransVO vo=null;
		ReturnFromEmployeeTransBO bo= null;
		HisUtil hisutil = null;
		String strRecommendCmb = "";
		
		
		
		try {
			vo = new ReturnFromEmployeeTransVO();
			bo = new ReturnFromEmployeeTransBO();
			
			hisutil = new HisUtil("mms", "ReturnFromEmployeeTransDATA");
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
			HisException eObj = new HisException("mms", "ReturnFromEmployeeTransDATA->recommendedBy()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
		}
	}
	
	
	
	/**
	 * This function invoke TransferObjectFactory.populateData() to transfer the values of all attributes of form bean into vo and the invoke bo insert method
	 * @param formBean
	 */
	public static void insert(ReturnFromEmployeeTransFB formBean,HttpServletRequest request)
	{
		ReturnFromEmployeeTransVO vo=null;
		ReturnFromEmployeeTransBO bo= null;
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
		String[] strSlNo = null;
		
		HisUtil hisutil = null;
		String strItemCategoryNo = "";
		String strStoreId = "";
		String empNO = "";
		
		 
		
		try
			{
			
			  bo = new ReturnFromEmployeeTransBO();
			  vo = new ReturnFromEmployeeTransVO();
			  mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			  
			  
			  
			  formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			  formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			  
			  strStoreId  = (String) request.getParameter("strId");
			  strItemCategoryNo = (String) request.getParameter("itemCategory");
			  empNO = (String) request.getParameter("empNo");
			  
			  
			  hisutil = new HisUtil("mms", "ReturnFromEmployeeTransDATA");
			  String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			  formBean.setStrReturnDate(ctDate);
			 
			  ////System.out.println("formBean.getStrPatientDtlHidVal();-->"+formBean.getStrPatientDtlHidVal());
			  /*String[] temp = formBean.getStrPatientDtlHidVal().replace("^", "#").split("#");
			  
			  formBean.setStrEmpNo(temp[6]);*/
			  //20-APR-82^1^11^11^^0^PGIPER10000012
			  
			 // //System.out.println("formBean.getStrAdmissionDtlHidVal();-->"+formBean.getStrAdmissionDtlHidVal());
			  
			 /* String[] temp1 = formBean.getStrAdmissionDtlHidVal().replace("^", "#").split("#");
			  
			  formBean.setStrAdmnNo(temp1[0]);*/
			  
			  //2009000186^10809001^1^21-Apr-2009 04:39:01 PM^110900026^10311^101^1016^101101608^11^0^0^0^1^21-Apr-2009 04:39:42 PM^0
			  
			  formBean.setStrFinStartDate(mcu.getStrFinancialStartDate(strStoreId , formBean.getStrHospitalCode()));
			  formBean.setStrFinEndDate(mcu.getStrFinancialEndDate(strStoreId , formBean.getStrHospitalCode()));
			 // formBean.setStrStockStatusCode("10");
			  formBean.setStrReservedFlag("1");
			  formBean.setStrIsValid("1");
			  formBean.setStrReqTypeId("43");
				
			  formBean.setStrStoreId(strStoreId);
			  formBean.setStrEmpNo(empNO);
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
				strSlNo = new String[nMultiRowLen]; 
			 
				 

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
					strSlNo[i] = insertValue[18]; 
					
				} 
			
			    /*vo = (ReturnFromEmployeeTransVO) TransferObjectFactory.populateData(
						"mms.transactions.vo.ReturnFromEmployeeTransVO", formBean);*/
			
				vo.setStrIssueNo(formBean.getStrIssueNo());
				vo.setStrReturnDate(formBean.getStrCtDate());
				vo.setStrReqTypeId(formBean.getStrReqTypeId());
				vo.setStrCrNo("0");
				vo.setStrIssueDate(formBean.getStrIssueDate());
				vo.setStrEmpNo(formBean.getStrEmpNo());
				vo.setStrAdmnNo("0");
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
				
				vo.setStrTotalCost(strTotalCost);
				vo.setStrItemSlNo(strSlNo);
				vo.setStrRecommendedBy(formBean.getStrRecommendedBy());
				
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
				strmsgText = "hisglobaltransactionutil.ReturnFromEmployeeTransDATA.insert(vo) --> "
						+ e.getMessage();
				HisException eObj = new HisException(
						"mms",
						"ReturnFromEmployeeTransDATA->insert()",
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

}
