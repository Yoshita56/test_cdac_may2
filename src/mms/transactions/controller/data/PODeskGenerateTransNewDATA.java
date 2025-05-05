package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import hisglobal.vo.UserVO;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.transactions.bo.PODeskGenerateTransNewBO;
import mms.transactions.controller.fb.PODeskGenerateTransNewFB;
import mms.transactions.controller.hlp.PODeskGenerateTransNewHLP;
import mms.transactions.vo.PODeskGenerateTransNewVO;

public class PODeskGenerateTransNewDATA {
	
	public static void setItemCatValues(
			PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,
			HttpServletRequest _request) {
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		HisUtil util = null;
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strFinancialStartDate;
		String strFinancialEndDate;
		try 
		{
			util = new HisUtil("Material Management System","PODeskGenerateTransNewDATA.setItemCatValues()");
			PODeskGenerateTransNewVO = new PODeskGenerateTransNewVO();
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			MmsConfigUtil mmscofigutil = new  MmsConfigUtil(_request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			/* This Object is Used to get Re-Order Level Color from hisProperties File  */
			ResourceBundle resObj = mms.qryHandler_mms.res;
			if(resObj == null) 
			{
				resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
				mms.qryHandler_mms.res = resObj;
			}
			
			_PODeskGenerateTransNewFB.setStrReOrderFlgColor(resObj.getString("QC_COLOR"));
			/*****Here We found either Budget Funcanality is Allow or Not******/
			/* If Avalaible then New Cost Column will be Added */
			//_PODeskGenerateTransNewFB.setStrBudgetFlg(mmscofigutil.getStrBudgetFlg());
			
			if(!mmscofigutil.getStrDemandActivePrd().equals("0"))
			{	
				//_PODeskGenerateTransNewFB.setStrIsDemandActiveFlag("1");
			}
			/*******************************************************************/
								
			strCurrentDate  = util.getASDate("dd-MM-yyyy");
						
			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
			
			
			if(strCurrentMonth>=4 )
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
							
			strFinancialStartDate = "01-Apr"+"-" + CURRENT_YEAR; 
			
			strFinancialEndDate = "31-Mar"+"-" + (CURRENT_YEAR+1);	
			
			PODeskGenerateTransNewVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
			PODeskGenerateTransNewVO.setStrSeatId((String) _request.getSession().getAttribute("SEATID"));
			PODeskGenerateTransNewVO.setStrStoreId(_request.getParameterValues("combo")[0]);
			PODeskGenerateTransNewVO.setStrItemCatNo(_request.getParameterValues("combo")[1]);
			PODeskGenerateTransNewVO.setStrPOTypeId(_request.getParameterValues("combo")[2]);
			//System.out.println("PODeskGenerateTransNewVO.getStrItemCatNo():::"+PODeskGenerateTransNewVO.getStrItemCatNo());
			_PODeskGenerateTransNewFB.setStrStoreName(_request.getParameter("comboValue"));
			_PODeskGenerateTransNewFB.setStrStoreId(PODeskGenerateTransNewVO.getStrStoreId());
					
			
			_PODeskGenerateTransNewFB.setStrCurrentDate(util.getDSDate("DD-Mon-yyyy"));
			_PODeskGenerateTransNewFB.setStrINRCurrencyId(MmsConfigUtil.DEFAULT_CURRENCY_CODE);
			
			PODeskGenerateTransNewBO.setItemCatValues(PODeskGenerateTransNewVO);
			
			
			if (PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
				throw new Exception(PODeskGenerateTransNewVO.getStrMsgString());

			_PODeskGenerateTransNewFB.setStrItemCatValues(PODeskGenerateTransNewVO.getStrItemCatValues());
			_PODeskGenerateTransNewFB.setStrPoRefrenceNoCmb(PODeskGenerateTransNewVO.getStrPoRefrenceNoCmb());
			_PODeskGenerateTransNewFB.setStrItemCat(PODeskGenerateTransNewVO.getStrItemCatNo());
			//System.out.println("_PODeskGenerateTransNewFB.setItemCategory:::"+_PODeskGenerateTransNewFB.getStrItemCat());
			_PODeskGenerateTransNewFB.setStrItemCatName(PODeskGenerateTransNewVO.getStrItemCatName());
			_PODeskGenerateTransNewFB.setStrPOTypeId(PODeskGenerateTransNewVO.getStrPOTypeId());
			_PODeskGenerateTransNewFB.setStrPOType(PODeskGenerateTransNewVO.getStrPOType());
			
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.setItemCatValues()---->", _Err
							.getMessage());
			_PODeskGenerateTransNewFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	
	
	public static void setItemCatValues1(
			PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,
			HttpServletRequest _request) {
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		HisUtil util = null;
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strFinancialStartDate;
		String strFinancialEndDate;
		try 
		{
			util = new HisUtil("Material Management System","PODeskGenerateTransNewDATA.setItemCatValues()");
			PODeskGenerateTransNewVO = new PODeskGenerateTransNewVO();
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			MmsConfigUtil mmscofigutil = new  MmsConfigUtil(_request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			/* This Object is Used to get Re-Order Level Color from hisProperties File  */
			ResourceBundle resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			_PODeskGenerateTransNewFB.setStrReOrderFlgColor(resObj.getString("QC_COLOR"));
			/*****Here We found either Budget Funcanality is Allow or Not******/
			/* If Avalaible then New Cost Column will be Added */
			//_PODeskGenerateTransNewFB.setStrBudgetFlg(mmscofigutil.getStrBudgetFlg());
			_PODeskGenerateTransNewFB.setStrRequestId(_request.getParameterValues("combo")[1]);	
			//System.out.println("_PODeskGenerateTransNewFB.setStrRequestId"+_PODeskGenerateTransNewFB.getStrRequestId());
			if(!mmscofigutil.getStrDemandActivePrd().equals("0"))
			{	
				//_PODeskGenerateTransNewFB.setStrIsDemandActiveFlag("1");
			}
			/*******************************************************************/
								
			strCurrentDate  = util.getASDate("dd-MM-yyyy");
						
			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
			
			
			if(strCurrentMonth>=4 )
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
							
			strFinancialStartDate = "01-Apr"+"-" + CURRENT_YEAR; 
			
			strFinancialEndDate = "31-Mar"+"-" + (CURRENT_YEAR+1);	
			
			PODeskGenerateTransNewVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
			PODeskGenerateTransNewVO.setStrSeatId((String) _request.getSession().getAttribute("SEATID"));
			PODeskGenerateTransNewVO.setStrStoreId(_request.getParameterValues("combo")[0]);

			_PODeskGenerateTransNewFB.setStrStoreName(_request.getParameter("comboValue"));
			_PODeskGenerateTransNewFB.setStrStoreId(PODeskGenerateTransNewVO.getStrStoreId());
					
			
			_PODeskGenerateTransNewFB.setStrCurrentDate(util.getDSDate("DD-Mon-yyyy"));
			_PODeskGenerateTransNewFB.setStrINRCurrencyId(MmsConfigUtil.DEFAULT_CURRENCY_CODE);
			
			PODeskGenerateTransNewBO.setItemCatValues1(PODeskGenerateTransNewVO);
			
			
			if (PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
				throw new Exception(PODeskGenerateTransNewVO.getStrMsgString());

			_PODeskGenerateTransNewFB.setStrItemCatValues(PODeskGenerateTransNewVO.getStrItemCatValues());
			
			
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.setItemCatValues1()---->", _Err
							.getMessage());
			_PODeskGenerateTransNewFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	
	
	
	/**
	 * To Get The Financial Year Combo
	 * 
	 * @param budgetAllocationDetailProcessTransFB_p
	 * @param request_p
	 */
	public static void getFinancialYearCombo(PODeskGenerateTransNewFB PODeskGenerateTransNewFB_p,HttpServletRequest request_p)
	{
		PODeskGenerateTransNewBO	PODeskGenerateTransNewBO = null; 
		PODeskGenerateTransNewVO	PODeskGenerateTransNewVO  = null;
		String strCurrentDate;
		String strMsgText;
		HisUtil hisutil = null;
		
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strCurrentFinancialYear="";
		String strNextFinancialYear=""; 
		
		try {
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			PODeskGenerateTransNewVO = new PODeskGenerateTransNewVO();
		 	hisutil = new HisUtil("DWH Transaction","PODeskGenerateTransNewDATA");
			strCurrentDate=hisutil.getASDate("dd-MM-yyyy");
			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
		    if(strCurrentMonth>=4 )
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
		   String DATE_FORMAT = "dd-MM-yyyy";
		   java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		   String strDemandActivePeriod = MmsConfigUtil.getStrPODemnadValidity((String) request_p.getSession().getAttribute("HOSPITAL_CODE"));
		   Calendar calendar1 = Calendar.getInstance();
		   Calendar calendar2 = Calendar.getInstance();
		   calendar1.set(Integer.parseInt(strCurrentDate.split("\\-")[2] ),(Integer.parseInt( strCurrentDate.split("\\-")[1] )-1) , Integer.parseInt( strCurrentDate.split("\\-")[0]));
		   calendar2.set(Integer.parseInt( strCurrentDate.split("\\-")[2] ), 3 ,Integer.parseInt(strDemandActivePeriod));
		     /*   
			    System.out.print("Calender 1:::"+sdf.format(calendar1.getTime()));
			    System.out.print("Calender 2:::"+sdf.format(calendar2.getTime()));
			  */   
		    if (calendar1.before(calendar2)) 
		    {
				strCurrentFinancialYear = (CURRENT_YEAR-1) + " - " + CURRENT_YEAR; 			
				strNextFinancialYear =     CURRENT_YEAR + " - " + (CURRENT_YEAR + 1);
		       
		    }
		    if (calendar1.after(calendar2)) 
		    {
				strCurrentFinancialYear = CURRENT_YEAR + " - " + (CURRENT_YEAR + 1); 			
				strNextFinancialYear = (CURRENT_YEAR+1) + " - " + (CURRENT_YEAR + 2); 
		    } 
		    if (calendar1.equals(calendar2)) 
		    {
				strCurrentFinancialYear = CURRENT_YEAR + " - " + (CURRENT_YEAR + 1); 			
				strNextFinancialYear = (CURRENT_YEAR+1) + " - " + (CURRENT_YEAR + 2);  
		    } 
		 // For setting the financial year combo
			PODeskGenerateTransNewFB_p.setStrCurrentFinancialYear(strCurrentFinancialYear);
			PODeskGenerateTransNewFB_p.setStrNextFinancialYear(strNextFinancialYear);
			
		} 
		catch (Exception e) 
		{
			strMsgText = "mms.transactions.PODeskGenerateTransNewDATA.getFinancialYearCombo() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms","PODeskGenerateTransNewDATA->getFinancialYearCombo()", strMsgText);
			PODeskGenerateTransNewFB_p.setStrErr("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} 
		finally 
		{

		if (PODeskGenerateTransNewBO != null)
			PODeskGenerateTransNewBO = null;
		if (PODeskGenerateTransNewVO != null)
			PODeskGenerateTransNewVO = null;
		if (hisutil != null)
			hisutil = null;
		}
		
	}
	
	
	public static void getScheduleDetails(PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,	HttpServletRequest _request) 
	{
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		HisUtil hisutil = null;		
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strFinancialStartDate;
		String strFinancialEndDate;		
		try 
		{
			hisutil = new HisUtil("DWH Transaction","PODeskGenerateTransNewDATA");
			PODeskGenerateTransNewVO = new PODeskGenerateTransNewVO();
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			
			strCurrentDate  = hisutil.getASDate("dd-MM-yyyy");
			_PODeskGenerateTransNewFB.setStrCurrentDate(strCurrentDate);
            strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
            ResourceBundle resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
            _PODeskGenerateTransNewFB.setStrReOrderFlgColor(resObj.getString("QC_COLOR"));
			
			
			if(strCurrentMonth>=4 )
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
							
			strFinancialStartDate = "01-Apr"+"-" + CURRENT_YEAR; 
			
			strFinancialEndDate = "31-Mar"+"-" + (CURRENT_YEAR+1);	
			
			PODeskGenerateTransNewVO.setStrStoreId(_request.getParameterValues("combo")[0]);
			PODeskGenerateTransNewVO.setStrFinancialStartDate(strFinancialStartDate);
			PODeskGenerateTransNewVO.setStrFinancialToDate(strFinancialEndDate);
			PODeskGenerateTransNewVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));			
			PODeskGenerateTransNewVO.setStrSeatId((String) _request.getSession().getAttribute("SEATID"));
			_PODeskGenerateTransNewFB.setStrHospitalCode(PODeskGenerateTransNewVO.getStrHospitalCode());
			_PODeskGenerateTransNewFB.setStrStoreId(_request.getParameterValues("combo")[0]);
			//System.out.println();
			
			_PODeskGenerateTransNewFB.setStrStoreName(_request.getParameter("comboValue"));
			_PODeskGenerateTransNewFB.setStrPONo(_request.getParameter("chk").replace("@", "#").split("#")[1]);
			PODeskGenerateTransNewVO.setStrPONo(_PODeskGenerateTransNewFB.getStrPONo());
			PODeskGenerateTransNewVO.setStrStoreId(_request.getParameterValues("combo")[0]);	
			PODeskGenerateTransNewVO.setStrItemCat("10");
			PODeskGenerateTransNewVO.setStrPONo(_request.getParameter("chk").replace("@", "#").split("#")[1]);
			// Calling BO Method
			PODeskGenerateTransNewBO.getPODetails(PODeskGenerateTransNewVO);
			
			if (PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
				
				throw new Exception(PODeskGenerateTransNewVO.getStrMsgString());			

			_PODeskGenerateTransNewFB.setStrPODate(PODeskGenerateTransNewVO.getStrPODate());
			_PODeskGenerateTransNewFB.setStrSupplierName(PODeskGenerateTransNewVO.getStrSupplierName());
			_PODeskGenerateTransNewFB.setStrPOType(PODeskGenerateTransNewVO.getStrPOType());
			_PODeskGenerateTransNewFB.setStrSupplierId(PODeskGenerateTransNewVO.getStrSupplierId());
			_PODeskGenerateTransNewFB.setStrPOTypeId(PODeskGenerateTransNewVO.getStrPOTypeId());
			_PODeskGenerateTransNewFB.setStrItemCat(PODeskGenerateTransNewVO.getStrItemCat());
			_PODeskGenerateTransNewFB.setStrItemCatName(PODeskGenerateTransNewVO.getStrItemCatName());		
			_PODeskGenerateTransNewFB.setStrPOHiddenValue(PODeskGenerateTransNewVO.getStrPOHiddenValue());
			_PODeskGenerateTransNewFB.setStrItemId(PODeskGenerateTransNewVO.getStrItemId());
			_PODeskGenerateTransNewFB.setStrItemBrandIds(PODeskGenerateTransNewVO.getStrItemBrandIds());
			_PODeskGenerateTransNewFB.setStrItemRate(PODeskGenerateTransNewVO.getStrItemRate());
			_PODeskGenerateTransNewFB.setStrItemRateUnitId(PODeskGenerateTransNewVO.getStrItemRateUnitId());
			_PODeskGenerateTransNewFB.setStrItemManufacturerId(PODeskGenerateTransNewVO.getStrItemManufacturerId());
			_PODeskGenerateTransNewFB.setStrTotalPOCost(PODeskGenerateTransNewVO.getStrTotalPOCost());
     		 //  (1)PO_DATE ^ (2)SUPP NAME ^ (3)PO TYPE ^ (4)CURRENCY CODE ^(5) NET ADVANCE 
			 //^ (6)PO NET AMOUNT ^(7) SUPPLIER ID ^(8) PO Type ^ (9)Currency Id ^(10) Currency Value ^(11) Item Catg No 
			 //^ (12)Catg Name ^ (13)Purchase Source ID  ^ (14)Purchase Source Name ^ (15)Currency Id ^(16) Currency Value
             //^ (17)Advance Amt ^ (18)PO Prefix With PO No ^ (19)Delivery Date ^ (20)PO PreFix ^ (21)TAX 
             //^ (22)Tender No ^ (23)Tender Date ^ (24)Qutation No ^ (25)Qutation Date ^ (26) PO Date ^ (27) Verify Date ^ (28) Verify BY
			 //^ (29) Financial Start Date ^ (30) Financial End Date
			////System.out.println("Hidden Value:::"+PODeskGenerateTransNewVO.getStrPOHiddenValue());
			_PODeskGenerateTransNewFB.setStrPurchaseSourceID(PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[12]);
			_PODeskGenerateTransNewFB.setStrPoRefrenceNo(PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[19]);
			PODeskGenerateTransNewVO.setStrPoRefrenceNo(PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[19]);
			
			_PODeskGenerateTransNewFB.setStrPORefrenceDate(PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[25]);
			////System.out.println("Over All Tax:::"+PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[20]);
			_PODeskGenerateTransNewFB.setStrDOverAllTax(PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[20]);
			_PODeskGenerateTransNewFB.setStrDTenderNo(PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[21]);
			
			_PODeskGenerateTransNewFB.setStrDQuotationNo(PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[23]);
						
			if(PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[22]==null || PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[22].equals(""))
			{	
			    _PODeskGenerateTransNewFB.setStrDTenderDate("");
			}
			else
			{
				 _PODeskGenerateTransNewFB.setStrDTenderDate(PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[22]);
			}
			
			if(PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[24]==null || PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[24].equals(""))
			{	
			     _PODeskGenerateTransNewFB.setStrDQuotationDate("");
			}
			else
			{
				_PODeskGenerateTransNewFB.setStrDQuotationDate(PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[24]);
			}
			// Calling BO Method
			PODeskGenerateTransNewBO.getPOPrefixCmb(PODeskGenerateTransNewVO);
			_PODeskGenerateTransNewFB.setStrPoRefrenceNoCmb(PODeskGenerateTransNewVO.getStrPoRefrenceNoCmb());
			
			_PODeskGenerateTransNewFB.setStrVerifiedDate(PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[26]);
			_PODeskGenerateTransNewFB.setStrVerifyById(PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[27]);
			//System.out.println("HiddenValues"+PODeskGenerateTransNewVO.getStrPOHiddenValue());
			for(int i = 0;i<PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^").length;i++)
			{
				//System.out.println(i+"::"+PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[i]);
			}
			_PODeskGenerateTransNewFB.setStrApprovedBy(PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[30]);
			_PODeskGenerateTransNewFB.setStrApprovalDate(PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[31]);
			
			//System.out.println("_PODeskGenerateTransNewFB.setStrApprovedBy"+_PODeskGenerateTransNewFB.getStrApprovedBy());
			//System.out.println("PODeskGenerateTransNewFB.setStrApprovalDate"+_PODeskGenerateTransNewFB.getStrApprovalDate());
			_PODeskGenerateTransNewFB.setStrFinancialStartDate(PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[28]);
			_PODeskGenerateTransNewFB.setStrFinancialToDate(PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[29]);
			
			_PODeskGenerateTransNewFB.setStrPODemandYear(PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[28].split("\\-")[2]+"-"+PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[29].split("\\-")[2]);
			PODeskGenerateTransNewVO.setStrFinancialStartDate(PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[28]);
			PODeskGenerateTransNewVO.setStrFinancialToDate(PODeskGenerateTransNewVO.getStrPOHiddenValue().split("\\^")[29]);
			 
			// Calling BO Method
			PODeskGenerateTransNewVO.setStrStoreId(_request.getParameterValues("combo")[0]);	
			_PODeskGenerateTransNewFB.setWbsReqListPO(PODeskGenerateTransNewVO.getWbsReqListPO());
			_PODeskGenerateTransNewFB.setStrModifyFlg("1");
			_PODeskGenerateTransNewFB.setStrPOItemCmb(PODeskGenerateTransNewVO.getStrPOItemCmb());
			
			 PODeskGenerateTransNewDATA.getManufactrerValues(_PODeskGenerateTransNewFB, _request);
			 PODeskGenerateTransNewDATA.setPurchaseSourceValues(_PODeskGenerateTransNewFB, _request);	
				
			
		} 
		catch (Exception _Err) 
		{
			_Err.printStackTrace();
			HisException hisException = new HisException("Material Management System","PODeskGenerateTransNewDATA.getScheduleDetails()---->", _Err.getMessage());
			_PODeskGenerateTransNewFB.setStrErr("ERROR####Application Error [ERROR ID : "+ hisException.getErrorID()+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	
	public static void setPurchaseSourceValues(
			PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,
			HttpServletRequest _request) {
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		String strApprovedByVals="";
		HisUtil util=null;
		try {
			PODeskGenerateTransNewVO = new PODeskGenerateTransNewVO();
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			util = new HisUtil("MMS",
			"transactions.PODeskGenerateTransNewDATA.setPurchaseSourceValues()");
			PODeskGenerateTransNewVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
			PODeskGenerateTransNewVO.setStrSeatId((String) _request.getSession().getAttribute("SEATID"));
			PODeskGenerateTransNewVO.setStrStoreId(_request.getParameterValues("combo")[0]);
			//Calling BO Method
			if(_PODeskGenerateTransNewFB.getStrModifyFlg().equals("1"))
			{
				PODeskGenerateTransNewVO.setStrPurchaseSourceId(_PODeskGenerateTransNewFB.getStrPurchaseSourceID());
			}
			else
			{
				PODeskGenerateTransNewVO.setStrPurchaseSourceId("0");
			}
			PODeskGenerateTransNewBO.setPurchaseSourceValues(PODeskGenerateTransNewVO);
			if (PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
				throw new Exception(PODeskGenerateTransNewVO.getStrMsgString());
			if(PODeskGenerateTransNewVO.getWbApprovedBy()!=null ||PODeskGenerateTransNewVO.getWbApprovedBy().size()!=0)
			{
				if(_PODeskGenerateTransNewFB.getStrModifyFlg().equals("1"))
				{	
				   strApprovedByVals=util.getOptionValue(PODeskGenerateTransNewVO.getWbApprovedBy(),_PODeskGenerateTransNewFB.getStrVerifyById(), "0^Select Value", false);
				}
				else
				{
					strApprovedByVals=util.getOptionValue(PODeskGenerateTransNewVO.getWbApprovedBy(), "", "0^Select Value", false);
				}
			}
			else
			{
				strApprovedByVals="<option value='0'>Select Value</option>";
			}
			
			_PODeskGenerateTransNewFB
					.setStrPurchaseSourceValues(PODeskGenerateTransNewVO
							.getStrPurchaseSourceValues());
		
			_PODeskGenerateTransNewFB.setStrApprovedByVals(strApprovedByVals);
			_PODeskGenerateTransNewFB.setStrCurrentDate(util.getDSDate("DD-Mon-yyyy"));
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.setPurchaseSourceValues()---->",
					_Err.getMessage());
			_PODeskGenerateTransNewFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	

	public static String getModifyUnitValues(PODeskGenerateTransNewVO PODeskGenerateTransNewVO) 
	{
		PODeskGenerateTransNewFB _PODeskGenerateTransNewFB = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		String strCmb = null;
		try 
		{			
			_PODeskGenerateTransNewFB = new PODeskGenerateTransNewFB();
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();			
			
			PODeskGenerateTransNewBO.setModifyUnitValues(PODeskGenerateTransNewVO);
			
			strCmb = PODeskGenerateTransNewVO.getStrRateUnitValues();
			
			
		} 
		catch (Exception _Err)
		{
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.getModifyUnitValues()---->", _Err
							.getMessage());
			_PODeskGenerateTransNewFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
		return strCmb;
	}
	
	
	public static void getPOHLP(PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,HttpServletRequest _request, HttpServletResponse _response) 
	{
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		String strRequestDetails;
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strFinancialStartDate;
		String strFinancialEndDate;
		HisUtil hisutil = null;
		try 
		{
			PODeskGenerateTransNewVO = new PODeskGenerateTransNewVO();
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			PODeskGenerateTransNewVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
			
				PODeskGenerateTransNewVO.setStrMode(_request.getParameter("mode"));
				PODeskGenerateTransNewVO.setStrSupplierId(_request.getParameter("strSupplierId").split("\\^")[0]);
				PODeskGenerateTransNewVO.setStrItemId(_request.getParameter("strPOItemID").split("\\^")[2]);
				PODeskGenerateTransNewVO.setStrItemBrandIds(_request.getParameter("strPOItemID").split("\\^")[0]);
				PODeskGenerateTransNewVO.setStrPOTypeId(_request.getParameter("strComboPOTypeId").split("\\^")[0]);
				PODeskGenerateTransNewVO.setStrStoreId(_request.getParameter("strStoreId"));
				String strPeriodValue = _request.getParameter("strIndentPeriodValue");
				strFinancialStartDate = "01-Apr"+"-" + (strPeriodValue.split("\\-")[0]).trim(); 							
				strFinancialEndDate = "31-Mar"+"-" + (strPeriodValue.split("\\-")[1]).trim();
			
				_PODeskGenerateTransNewFB.setStrMode(PODeskGenerateTransNewVO.getStrMode());
			
			 //  (1)PO_DATE ^ (2)SUPP NAME ^ (3)PO TYPE ^ (4)CURRENCY CODE ^(5) NET ADVANCE 
			 //^ (6)PO NET AMOUNT ^(7) SUPPLIER ID ^(8) PO Type ^ (9)Currency Id ^(10) Currency Value ^(11) Item Catg No 
			 //^ (12)Catg Name ^ (13)Purchase Source ID  ^ (14)Purchase Source Name ^ (15)Currency Id ^(16) Currency Value
            //^ (17)Advance Amt ^ (18)PO Prefix With PO No ^ (19)Delivery Date ^ (20)PO PreFix ^ (21)TAX 
            //^ (22)Tender No ^ (23)Tender Date ^ (24)Qutation No ^ (25)Qutation Date ^ (26) PO Date ^ (27) Verify Date ^ (28) Verify BY
			 //^ (29) Financial Start Date ^ (30) Financial End Date
			
			
			hisutil = new HisUtil("DWH Transaction","PODeskGenerateTransNewDATA");
			strCurrentDate  = hisutil.getASDate("dd-MM-yyyy");
			
			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
			
			
			if(strCurrentMonth>=4 )
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
							
			//strFinancialStartDate = "01-Apr"+"-" + CURRENT_YEAR; 
			
			//strFinancialEndDate = "31-Mar"+"-" + (CURRENT_YEAR+1);	
			
			PODeskGenerateTransNewVO.setStrFinancialStartDate(strFinancialStartDate);
			PODeskGenerateTransNewVO.setStrFinancialToDate(strFinancialEndDate);
				
			// Calling BO Method
			PODeskGenerateTransNewBO.setDWHList(PODeskGenerateTransNewVO);
			
			_PODeskGenerateTransNewFB.setWbsReqListPO(PODeskGenerateTransNewVO.getWbsReqListPO());
			strRequestDetails = PODeskGenerateTransNewHLP.getPOWithItemHLP(_PODeskGenerateTransNewFB);
			
			if (_PODeskGenerateTransNewFB.getStrMsgType().equals("1"))
			
				throw new Exception(_PODeskGenerateTransNewFB.getStrMsgString());

			_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(strRequestDetails);
			
			
		} catch (Exception _Err) 
		{
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.getPOHLP()---->", _Err
							.getMessage());
			_PODeskGenerateTransNewFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	
	
	public static void getPOHLP1(PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,HttpServletRequest _request, HttpServletResponse _response) 
	{
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		String strRequestDetails;
		try 
		{
			PODeskGenerateTransNewVO = new PODeskGenerateTransNewVO();
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			PODeskGenerateTransNewVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
//			//System.out.println("Mode:::"+_request.getParameter("mode"));
//			//System.out.println("Supplier ID:::"+_request.getParameter("strPOItemID").split("\\@")[2]);
//			//System.out.println("PO NO:::"+_request.getParameter("strPOHiddenValue"));
//			//System.out.println("Hidden Value:::"+_request.getParameter("strPOHiddenValue"));
				PODeskGenerateTransNewVO.setStrMode(_request.getParameter("mode"));
				PODeskGenerateTransNewVO.setStrSupplierId(_request.getParameter("strPOItemID").split("\\@")[2]);
				PODeskGenerateTransNewVO.setStrItemId(_request.getParameter("strPOItemID").split("\\@")[1]);
				PODeskGenerateTransNewVO.setStrItemBrandIds(_request.getParameter("strPOItemID").split("\\@")[0]);
				PODeskGenerateTransNewVO.setStrStoreId(_request.getParameter("strStoreId"));
				PODeskGenerateTransNewVO.setStrPOTypeId(_request.getParameter("strPONo"));				
				
			
			_PODeskGenerateTransNewFB.setStrMode(PODeskGenerateTransNewVO.getStrMode());

			
			 //  (1)PO_DATE ^ (2)SUPP NAME ^ (3)PO TYPE ^ (4)CURRENCY CODE ^(5) NET ADVANCE 
			 //^ (6)PO NET AMOUNT ^(7) SUPPLIER ID ^(8) PO Type ^ (9)Currency Id ^(10) Currency Value ^(11) Item Catg No 
			 //^ (12)Catg Name ^ (13)Purchase Source ID  ^ (14)Purchase Source Name ^ (15)Currency Id ^(16) Currency Value
            //^ (17)Advance Amt ^ (18)PO Prefix With PO No ^ (19)Delivery Date ^ (20)PO PreFix ^ (21)TAX 
            //^ (22)Tender No ^ (23)Tender Date ^ (24)Qutation No ^ (25)Qutation Date ^ (26) PO Date ^ (27) Verify Date ^ (28) Verify BY
			 //^ (29) Financial Start Date ^ (30) Financial End Date
			
			
			PODeskGenerateTransNewVO.setStrFinancialStartDate(_request.getParameter("strPOHiddenValue").split("\\^")[28]);
			
			PODeskGenerateTransNewVO.setStrFinancialToDate(_request.getParameter("strPOHiddenValue").split("\\^")[29]);
				
			// Calling BO Method
			PODeskGenerateTransNewBO.setDWHList(PODeskGenerateTransNewVO);
			
			_PODeskGenerateTransNewFB.setWbsReqListPO(PODeskGenerateTransNewVO.getWbsReqListPO());
			//Calling HLP Method
			strRequestDetails = PODeskGenerateTransNewHLP.getPOWithItemHLP(_PODeskGenerateTransNewFB);
			
			
			if (_PODeskGenerateTransNewFB.getStrMsgType().equals("1"))
			
				throw new Exception(_PODeskGenerateTransNewFB.getStrMsgString());

			_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(strRequestDetails);
			
			
		} catch (Exception _Err) 
		{
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.getPOHLP1()---->", _Err
							.getMessage());
			_PODeskGenerateTransNewFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	
	
	public static void getPOHLP2(PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,HttpServletRequest _request, HttpServletResponse _response) 
	{
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		String strRequestDetails;
		try 
		{
			PODeskGenerateTransNewVO = new PODeskGenerateTransNewVO();
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			PODeskGenerateTransNewVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
//			//System.out.println("Mode:::"+_request.getParameter("mode"));
//			//System.out.println("Supplier ID:::"+_request.getParameter("strPOItemID").split("\\@")[2]);
//			//System.out.println("PO NO:::"+_request.getParameter("strPOHiddenValue"));
//			//System.out.println("Hidden Value:::"+_request.getParameter("strPOHiddenValue"));
				PODeskGenerateTransNewVO.setStrMode(_request.getParameter("mode"));
				PODeskGenerateTransNewVO.setStrSupplierId(_request.getParameter("strPOItemID").split("\\@")[2]);
				PODeskGenerateTransNewVO.setStrItemId(_request.getParameter("strPOItemID").split("\\@")[1]);
				PODeskGenerateTransNewVO.setStrItemBrandIds(_request.getParameter("strPOItemID").split("\\@")[0]);
				PODeskGenerateTransNewVO.setStrStoreId(_request.getParameter("strStoreId"));
				PODeskGenerateTransNewVO.setStrPOTypeId(_request.getParameter("strPONo"));				
				
			
			_PODeskGenerateTransNewFB.setStrMode(PODeskGenerateTransNewVO.getStrMode());

			
			 //  (1)PO_DATE ^ (2)SUPP NAME ^ (3)PO TYPE ^ (4)CURRENCY CODE ^(5) NET ADVANCE 
			 //^ (6)PO NET AMOUNT ^(7) SUPPLIER ID ^(8) PO Type ^ (9)Currency Id ^(10) Currency Value ^(11) Item Catg No 
			 //^ (12)Catg Name ^ (13)Purchase Source ID  ^ (14)Purchase Source Name ^ (15)Currency Id ^(16) Currency Value
            //^ (17)Advance Amt ^ (18)PO Prefix With PO No ^ (19)Delivery Date ^ (20)PO PreFix ^ (21)TAX 
            //^ (22)Tender No ^ (23)Tender Date ^ (24)Qutation No ^ (25)Qutation Date ^ (26) PO Date ^ (27) Verify Date ^ (28) Verify BY
			 //^ (29) Financial Start Date ^ (30) Financial End Date
			
			
			PODeskGenerateTransNewVO.setStrFinancialStartDate(_request.getParameter("strPOHiddenValue").split("\\^")[28]);
			
			PODeskGenerateTransNewVO.setStrFinancialToDate(_request.getParameter("strPOHiddenValue").split("\\^")[29]);
				
			// Calling BO Method
			PODeskGenerateTransNewBO.setDWHList(PODeskGenerateTransNewVO);
			
			_PODeskGenerateTransNewFB.setWbsReqListPO(PODeskGenerateTransNewVO.getWbsReqListPO());
			//Calling HLP Method
			//strRequestDetails = PODeskGenerateTransNewHLP.getPOWithItemHLP(_PODeskGenerateTransNewFB);
			strRequestDetails = PODeskGenerateTransNewHLP.getPOWithItemHLPTWO(_PODeskGenerateTransNewFB);
			
			if (_PODeskGenerateTransNewFB.getStrMsgType().equals("1"))
			
				throw new Exception(_PODeskGenerateTransNewFB.getStrMsgString());

			_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(strRequestDetails);
			
			
		} catch (Exception _Err) 
		{
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.getPOHLP2()---->", _Err
							.getMessage());
			_PODeskGenerateTransNewFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	
	public static void getPOHLP3(PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,HttpServletRequest _request, HttpServletResponse _response) 
	{
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		String strRequestDetails;
		try 
		{
			PODeskGenerateTransNewVO = new PODeskGenerateTransNewVO();
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			PODeskGenerateTransNewVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
//			//System.out.println("Mode:::"+_request.getParameter("mode"));
//			//System.out.println("Supplier ID:::"+_request.getParameter("strPOItemID").split("\\@")[2]);
//			//System.out.println("PO NO:::"+_request.getParameter("strPOHiddenValue"));
//			//System.out.println("Hidden Value:::"+_request.getParameter("strPOHiddenValue"));
				PODeskGenerateTransNewVO.setStrMode(_request.getParameter("mode"));
				PODeskGenerateTransNewVO.setStrSupplierId(_request.getParameter("strPOItemID").split("\\@")[2]);
				PODeskGenerateTransNewVO.setStrItemId(_request.getParameter("strPOItemID").split("\\@")[1]);
				PODeskGenerateTransNewVO.setStrItemBrandIds(_request.getParameter("strPOItemID").split("\\@")[0]);
				PODeskGenerateTransNewVO.setStrStoreId(_request.getParameter("strStoreId"));
				PODeskGenerateTransNewVO.setStrPOTypeId(_request.getParameter("strPONo"));				
				PODeskGenerateTransNewVO.setStrStoreId(_PODeskGenerateTransNewFB.getStrStoreId());
			
			_PODeskGenerateTransNewFB.setStrMode(PODeskGenerateTransNewVO.getStrMode());

			
			 //  (1)PO_DATE ^ (2)SUPP NAME ^ (3)PO TYPE ^ (4)CURRENCY CODE ^(5) NET ADVANCE 
			 //^ (6)PO NET AMOUNT ^(7) SUPPLIER ID ^(8) PO Type ^ (9)Currency Id ^(10) Currency Value ^(11) Item Catg No 
			 //^ (12)Catg Name ^ (13)Purchase Source ID  ^ (14)Purchase Source Name ^ (15)Currency Id ^(16) Currency Value
            //^ (17)Advance Amt ^ (18)PO Prefix With PO No ^ (19)Delivery Date ^ (20)PO PreFix ^ (21)TAX 
            //^ (22)Tender No ^ (23)Tender Date ^ (24)Qutation No ^ (25)Qutation Date ^ (26) PO Date ^ (27) Verify Date ^ (28) Verify BY
			 //^ (29) Financial Start Date ^ (30) Financial End Date
			
			
			PODeskGenerateTransNewVO.setStrFinancialStartDate(_request.getParameter("strPOHiddenValue").split("\\^")[28]);
			
			PODeskGenerateTransNewVO.setStrFinancialToDate(_request.getParameter("strPOHiddenValue").split("\\^")[29]);
				
			// Calling BO Method
			PODeskGenerateTransNewBO.setDWHList(PODeskGenerateTransNewVO);
			
			_PODeskGenerateTransNewFB.setWbsReqListPO(PODeskGenerateTransNewVO.getWbsReqListPO());
			//Calling HLP Method
			//strRequestDetails = PODeskGenerateTransNewHLP.getPOWithItemHLP(_PODeskGenerateTransNewFB);
			strRequestDetails = PODeskGenerateTransNewHLP.getPOWithItemHLPForView(_PODeskGenerateTransNewFB);
			
			if (_PODeskGenerateTransNewFB.getStrMsgType().equals("1"))
			
				throw new Exception(_PODeskGenerateTransNewFB.getStrMsgString());

			_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(strRequestDetails);
			
			
		} catch (Exception _Err) 
		{
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.getPOHLP3()---->", _Err
							.getMessage());
			_PODeskGenerateTransNewFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	
	public static void setPOTypeValues(
			PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		try {
			PODeskGenerateTransNewVO = new PODeskGenerateTransNewVO();
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			PODeskGenerateTransNewVO.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			PODeskGenerateTransNewVO.setStrItemCat(_request
					.getParameter("strItemCat"));
			PODeskGenerateTransNewVO.setStrStoreId(_request
					.getParameter("strStoreId"));
			// Calling BO Method
			PODeskGenerateTransNewBO.setPOTypeValues(PODeskGenerateTransNewVO);
			if (PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
				throw new Exception(PODeskGenerateTransNewVO.getStrMsgString());
			_response.getWriter().print(
					PODeskGenerateTransNewVO.getStrPOTypeValues());
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.setPOTypeValues()---->", _Err
							.getMessage());
			_PODeskGenerateTransNewFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	
	public static void getSupplierValues
	(
			PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,
			HttpServletRequest _request, HttpServletResponse _response) 
	{
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		try {
			PODeskGenerateTransNewVO = new PODeskGenerateTransNewVO();
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			PODeskGenerateTransNewVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
			PODeskGenerateTransNewVO.setStrContractType((String)_request.getSession().getAttribute("strContractType"));
			if(_PODeskGenerateTransNewFB.getStrPOTypeId().replace("^", "#").split("#")[0].equals("21"))
				PODeskGenerateTransNewVO.setStrContractType("11");
			else
				PODeskGenerateTransNewVO.setStrContractType("10");
			PODeskGenerateTransNewVO.setStrItemCat(_PODeskGenerateTransNewFB.getStrItemCat());
			// Calling BO Method
			PODeskGenerateTransNewBO.setSupplierValues1(PODeskGenerateTransNewVO);
			
			_PODeskGenerateTransNewFB.setStrSupplierValues(PODeskGenerateTransNewVO.getStrSupplierValues());
			
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.setSupplierValues()---->", _Err
							.getMessage());
			_PODeskGenerateTransNewFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	

	public static void setSupplierValues(
			PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		try {
			PODeskGenerateTransNewVO = new PODeskGenerateTransNewVO();
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			PODeskGenerateTransNewVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
			PODeskGenerateTransNewVO.setStrContractType(_request.getParameter("strContractType"));
			PODeskGenerateTransNewVO.setStrItemCat(_request.getParameter("strItemCat"));
			// Calling BO Method
			PODeskGenerateTransNewBO.setSupplierValues(PODeskGenerateTransNewVO);
			if (PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
				throw new Exception(PODeskGenerateTransNewVO.getStrMsgString());
			_response.getWriter().print(
					PODeskGenerateTransNewVO.getStrSupplierValues()+"$"+PODeskGenerateTransNewVO.getStrHlpSize());
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.setSupplierValues()---->", _Err
							.getMessage());
			_PODeskGenerateTransNewFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}

	

	public static void setAgentNameValues(
			PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		try {
			PODeskGenerateTransNewVO = new PODeskGenerateTransNewVO();
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			PODeskGenerateTransNewVO.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			PODeskGenerateTransNewVO.setStrItemCat(_request
					.getParameter("strItemCat"));
			// Calling BO Method
			PODeskGenerateTransNewBO.setAgentNameValues(PODeskGenerateTransNewVO);
			if (PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
				throw new Exception(PODeskGenerateTransNewVO.getStrMsgString());
			_response.getWriter().print(
					PODeskGenerateTransNewVO.getStrAgentNameValues());
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.setAgentNameValues()---->", _Err
							.getMessage());
			_PODeskGenerateTransNewFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}

	public static void setDeliveryLocationValues(
			PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,
			HttpServletRequest _request) {
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		try {
			PODeskGenerateTransNewVO = new PODeskGenerateTransNewVO();
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			PODeskGenerateTransNewVO.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			PODeskGenerateTransNewVO.setStrSeatId((String) _request.getSession()
					.getAttribute("SEATID"));
			// Calling BO Method
			PODeskGenerateTransNewBO
					.setDeliveryLocationValues(PODeskGenerateTransNewVO);
			if (PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
				throw new Exception(PODeskGenerateTransNewVO.getStrMsgString());
			_PODeskGenerateTransNewFB
					.setStrDeliveryLocationValues(PODeskGenerateTransNewVO
							.getStrDeliveryLocationValues());
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.setDeliveryLocationValues()---->",
					_Err.getMessage());
			_PODeskGenerateTransNewFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	
	public static void getPOItemList(
			PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,
			HttpServletRequest _request,HttpServletResponse _response) {
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		HisUtil util = null;
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strFinancialStartDate ="";
		String strFinancialEndDate ="";

		try 
		{
			util = new HisUtil("MMS","PODeskGenerateTransNewDATA.setItemCatValues()"); 
			PODeskGenerateTransNewVO = new PODeskGenerateTransNewVO();
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			PODeskGenerateTransNewVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
			PODeskGenerateTransNewVO.setStrSeatId((String) _request.getSession().getAttribute("SEATID"));
			PODeskGenerateTransNewVO.setStrItemCat(_request.getParameter("strItemCat"));
			PODeskGenerateTransNewVO.setStrStoreId(_request.getParameter("strPOStoreID"));
			String strPeriodValue = _request.getParameter("strIndentPeriodValue");
			
			PODeskGenerateTransNewVO.setStrSupplierId(_request.getParameter("supplierID"));
			PODeskGenerateTransNewVO.setStrPORefrenceDate(_request.getParameter("poRefDate"));
				
			//		//System.out.println("strPeriodValue:::"+strPeriodValue);	
			strCurrentDate  = util.getASDate("dd-MM-yyyy");
			
			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
			
			
			if(strCurrentMonth>=4 )
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
							
			 strFinancialStartDate = "01-Apr"+"-" + (strPeriodValue.split("\\-")[0]).trim(); 
			
			 strFinancialEndDate = "28-Mar"+"-" + (strPeriodValue.split("\\-")[1]).trim();	
			
			
			PODeskGenerateTransNewVO.setStrFinancialStartDate(strFinancialStartDate);
			PODeskGenerateTransNewVO.setStrFinancialToDate(strFinancialEndDate);
			PODeskGenerateTransNewVO.setStrPOTypeId(_PODeskGenerateTransNewFB.getStrPOTypeId());
			// Calling BO Method
			if(!_PODeskGenerateTransNewFB.getStrPOTypeId().replace("^", "#").split("#")[0].equals("21"))
				PODeskGenerateTransNewBO.getPOItemList(PODeskGenerateTransNewVO);
			else
				PODeskGenerateTransNewBO.getPOItemListWithoutRC(PODeskGenerateTransNewVO);
			if (PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
				throw new Exception(PODeskGenerateTransNewVO.getStrMsgString());
			_PODeskGenerateTransNewFB.setStrPOItemCmb(PODeskGenerateTransNewVO.getStrPOItemCmb());
			
			_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(_PODeskGenerateTransNewFB.getStrPOItemCmb());
			
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.getPOItemList()---->",
					_Err.getMessage());
			_PODeskGenerateTransNewFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}

	public static void setCurrencyValues(
			PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,
			HttpServletRequest _request) {
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		try {
			PODeskGenerateTransNewVO = new PODeskGenerateTransNewVO();
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			PODeskGenerateTransNewVO.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			PODeskGenerateTransNewBO.setCurrencyValues(PODeskGenerateTransNewVO);
			if (PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
				throw new Exception(PODeskGenerateTransNewVO.getStrMsgString());
			_PODeskGenerateTransNewFB.setStrCurrencyValues(PODeskGenerateTransNewVO
					.getStrCurrencyValues());
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.setCurrencyValues()---->", _Err
							.getMessage());
			_PODeskGenerateTransNewFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	
	public static void getUnitValues(PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,HttpServletRequest _request,HttpServletResponse _response) 
	{
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		try 
		{
			PODeskGenerateTransNewVO = new PODeskGenerateTransNewVO();
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			PODeskGenerateTransNewVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
			
			PODeskGenerateTransNewVO.setStrItemId(_request.getParameter("strPOItemID").split("\\^")[2]);
			
			PODeskGenerateTransNewBO.setUnitValues(PODeskGenerateTransNewVO);
			_PODeskGenerateTransNewFB.setStrRateUnitValues(PODeskGenerateTransNewVO.getStrRateUnitValues());
			if (PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
				throw new Exception(PODeskGenerateTransNewVO.getStrMsgString());
			_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(PODeskGenerateTransNewVO.getStrRateUnitValues());
			
		} 
		catch (Exception _Err)
		{
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.getUnitValues()---->", _Err
							.getMessage());
			_PODeskGenerateTransNewFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	
	public static void getUnitValues1(PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,HttpServletRequest _request,HttpServletResponse _response) 
	{
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		try 
		{
			PODeskGenerateTransNewVO = new PODeskGenerateTransNewVO();
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			PODeskGenerateTransNewVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
			
			PODeskGenerateTransNewVO.setStrItemId(_request.getParameter("strPOItemID").split("\\@")[1]);
			PODeskGenerateTransNewVO.setStrRateUnitId(_request.getParameter("strPOItemID").split("\\@")[4]);
			PODeskGenerateTransNewBO.setUnitValues(PODeskGenerateTransNewVO);
			_PODeskGenerateTransNewFB.setStrRateUnitValues(PODeskGenerateTransNewVO.getStrRateUnitValues());
			if (PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
				throw new Exception(PODeskGenerateTransNewVO.getStrMsgString());
			_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(PODeskGenerateTransNewVO.getStrRateUnitValues());
			
		} 
		catch (Exception _Err)
		{
			 _Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.getUnitValues1()---->", _Err
							.getMessage());
			_PODeskGenerateTransNewFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	public static void getManufactrerValues(PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,HttpServletRequest _request) 
	{
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		try 
		{
			PODeskGenerateTransNewVO = new PODeskGenerateTransNewVO();
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			PODeskGenerateTransNewVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
			PODeskGenerateTransNewVO.setStrItemCat("10");
			
			if(_PODeskGenerateTransNewFB.getStrModifyFlg().equals("1"))
			{
				PODeskGenerateTransNewVO.setStrItemManufacturerId(_PODeskGenerateTransNewFB.getStrItemManufacturerId());
			}
			else
			{
				PODeskGenerateTransNewVO.setStrItemManufacturerId("0");	
			}
			PODeskGenerateTransNewBO.setManufacturerValues(PODeskGenerateTransNewVO);
			if (PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
				throw new Exception(PODeskGenerateTransNewVO.getStrMsgString());
			_PODeskGenerateTransNewFB.setStrManufacturerValues(PODeskGenerateTransNewVO.getStrManufacturerValues());
		}
		catch (Exception _Err) 
		{
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.getManufactrerValues()---->", _Err
							.getMessage());
			_PODeskGenerateTransNewFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	
	public static void getRequestDetails(
			PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		String strRequestDetails = "";
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		try {
			PODeskGenerateTransNewVO = new PODeskGenerateTransNewVO();
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();

			PODeskGenerateTransNewVO.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			PODeskGenerateTransNewVO.setStrSeatId((String) _request.getSession().getAttribute("SEATID"));
			PODeskGenerateTransNewVO.setStrItemCat(_request.getParameter("strItemCat"));
			PODeskGenerateTransNewVO.setStrStoreId(_request.getParameter("strStoreId"));
			PODeskGenerateTransNewVO.setStrPOTypeId(_request.getParameter("strPOTypeId"));
			PODeskGenerateTransNewVO.setStrPOGrantType(_request.getParameter("strPOGrantType"));

//			//System.out.println("Item Catg:::"+_request.getParameter("strItemCat"));
//			//System.out.println("Store Id:::"+_request.getParameter("strStoreId"));
//			//System.out.println("PO Type:::"+_request.getParameter("strPOTypeId"));
//			//System.out.println("PO Grant:::"+_request.getParameter("strPOGrantType"));
			
			
			PODeskGenerateTransNewBO.getRequestDetails(PODeskGenerateTransNewVO);
			
			
			if (PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
				throw new Exception(PODeskGenerateTransNewVO.getStrMsgString());

			_PODeskGenerateTransNewFB.setWbRequestDetail(PODeskGenerateTransNewVO.getWbRequestDetail());
			strRequestDetails = PODeskGenerateTransNewHLP.getRequestDetails(_PODeskGenerateTransNewFB);
			if (_PODeskGenerateTransNewFB.getStrMsgType().equals("1"))
				throw new Exception(_PODeskGenerateTransNewFB.getStrMsgString());

			_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(strRequestDetails);
		} catch (Exception _Err) {
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.getRequestDetails()---->", _Err
							.getMessage());
			try {
				_response.getWriter().print(
						"Error####Application Error [ERROR ID : "
								+ hisException.getErrorID()
								+ "], Contact System Administrator! ");
			} catch (Exception _Err1) {
			}
			hisException = null;
		}
	}

	public static void setRateUnitValues(
			PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,
			HttpServletRequest _request) {
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		try {
			PODeskGenerateTransNewVO = new PODeskGenerateTransNewVO();
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			PODeskGenerateTransNewVO.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			PODeskGenerateTransNewVO.setStrSeatId((String) _request.getSession()
					.getAttribute("SEATID"));
			PODeskGenerateTransNewBO.setUnitValues(PODeskGenerateTransNewVO);
			if (PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
				throw new Exception(PODeskGenerateTransNewVO.getStrMsgString());
			_PODeskGenerateTransNewFB.setStrRateUnitValues(PODeskGenerateTransNewVO
					.getStrRateUnitValues());
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.setRateUnitValues()---->", _Err
							.getMessage());
			_PODeskGenerateTransNewFB
					.setStrErr("Error####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	
	
	public static void getSupplierForeignFlag(PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,HttpServletRequest _request, HttpServletResponse _response) 
	{
		
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		HisUtil util = null;
		try 
		{
			util = new HisUtil("Material Management System","PODeskGenerateTransNewDATA.setItemCatValues()");
			PODeskGenerateTransNewVO = new PODeskGenerateTransNewVO();
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			MmsConfigUtil mmsConfig =  new MmsConfigUtil(_request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			PODeskGenerateTransNewVO.setStrSupplierId(_request.getParameter("strSupplierId"));
			PODeskGenerateTransNewVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
			
			PODeskGenerateTransNewBO.getIsForeignFlag(PODeskGenerateTransNewVO);
			
//			//System.out.println("Imported:::"+mmsConfig.getStrImportedDeliveryTime());
//			//System.out.println("Indian:::"+mmsConfig.getStrIndianDeliveryTime());
//			//System.out.println("Curent Date:::"+util.getDSDate("DD-Mon-yyyy"));
			
			SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");  
			Calendar cal = Calendar.getInstance();
				
			 int importedTime  = Integer.parseInt(mmsConfig.getStrImportedDeliveryTime());
			 int   indianTime  = Integer.parseInt(mmsConfig.getStrIndianDeliveryTime());
			 
			 if(PODeskGenerateTransNewVO.getStrIsForeignFlg().equals("1"))
			 {	 
				 cal.add(Calendar.DATE, importedTime);
		         ////System.out.println("Imported Delivery Date: " + dateformat.format(cal.getTime()));
			 }
			 else
			 {
				 cal.add(Calendar.DATE, indianTime);
			     ////System.out.println("Indian Delivery Date: " + dateformat.format(cal.getTime())); 
			 } 
		        
			     ////System.out.println("In Data Supplier Flag:::"+PODeskGenerateTransNewVO.getStrIsForeignFlg());
			if (_PODeskGenerateTransNewFB.getStrMsgType().equals("1"))
				throw new Exception(_PODeskGenerateTransNewFB.getStrMsgString());

			_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(PODeskGenerateTransNewVO.getStrIsForeignFlg()+"^"+dateformat.format(cal.getTime()));
		} catch (Exception _Err) {
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.getSupplierForeignFlag()---->",
					_Err.getMessage());
			try {
				_response.getWriter().print(
						"Error####Application Error [ERROR ID : "
								+ hisException.getErrorID()
								+ "], Contact System Administrator! ");
			} catch (Exception _Err1) {
			}
			hisException = null;
		}
	}
	

	public static void getRequestItemDetails(
			PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,
			HttpServletRequest _request, HttpServletResponse _response) 
	{
		String strIndentDetails = "";
		
		try {
						
			_PODeskGenerateTransNewFB.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
 
			_PODeskGenerateTransNewFB.setStrSupplierId(_request.getParameter("strSupplierId"));
			_PODeskGenerateTransNewFB.setStrContractType(_request.getParameter("strContractType"));
			_PODeskGenerateTransNewFB.setStrPOTypeId(_request.getParameter("strPOTypeId"));
			_PODeskGenerateTransNewFB.setStrItemCat(_request.getParameter("strItemCat"));
			_PODeskGenerateTransNewFB.setStrRequestIds(_request.getParameter("strRequestIds"));
			_PODeskGenerateTransNewFB.setStrReqIdnDate(_request.getParameter("strReqIdnDate"));
			_PODeskGenerateTransNewFB.setStrCheckData(_request.getParameter("strCheckData"));

			strIndentDetails = PODeskGenerateTransNewHLP.getRequestItemDetails(_PODeskGenerateTransNewFB);
			
			if (_PODeskGenerateTransNewFB.getStrMsgType().equals("1"))
				throw new Exception(_PODeskGenerateTransNewFB.getStrMsgString());

			_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(strIndentDetails);
		} catch (Exception _Err) {

			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.getRequestItemDetails()---->",
					_Err.getMessage());
			try {
				_response.getWriter().print(
						"Error####Application Error [ERROR ID : "
								+ hisException.getErrorID()
								+ "], Contact System Administrator! ");
			} catch (Exception _Err1) {
			}
			hisException = null;
		}
	}

	public static void getComponentDetail(
			PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		String strRequestDetails = "";
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		try {
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			PODeskGenerateTransNewVO = new PODeskGenerateTransNewVO();
			_PODeskGenerateTransNewFB.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			_PODeskGenerateTransNewFB.setStrPOTypeId(_request
					.getParameter("strPOTypeId"));
			_PODeskGenerateTransNewFB.setStrItemCat(_request
					.getParameter("strItemCat"));

			PODeskGenerateTransNewVO.setStrHospitalCode(_PODeskGenerateTransNewFB
					.getStrHospitalCode());
			PODeskGenerateTransNewVO.setStrPOTypeId(_PODeskGenerateTransNewFB
					.getStrPOTypeId());
			PODeskGenerateTransNewVO.setStrItemCat(_PODeskGenerateTransNewFB
					.getStrItemCat());

			PODeskGenerateTransNewBO.getComponentDetail(PODeskGenerateTransNewVO);

			if (PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
				throw new Exception(PODeskGenerateTransNewVO.getStrMsgString());

			_PODeskGenerateTransNewFB.setStrComponentID(PODeskGenerateTransNewVO
					.getStrComponentID());
			_PODeskGenerateTransNewFB.setStrComponentName(PODeskGenerateTransNewVO
					.getStrComponentName());
			_PODeskGenerateTransNewFB.setStrComponentValue(PODeskGenerateTransNewVO
					.getStrComponentValue());
			strRequestDetails = PODeskGenerateTransNewHLP
					.getComponentDetail(_PODeskGenerateTransNewFB);
			if (_PODeskGenerateTransNewFB.getStrMsgType().equals("1"))
				throw new Exception(_PODeskGenerateTransNewFB.getStrMsgString());

			_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(strRequestDetails);
		} catch (Exception _Err) {
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.getComponentDetail()---->", _Err
							.getMessage());
			try {
				_response.getWriter().print(
						"Error####Application Error [ERROR ID : "
								+ hisException.getErrorID()
								+ "], Contact System Administrator! ");
			} catch (Exception _Err1) {
			}
			hisException = null;
		}
	}

	public static void getIndentPopupDetails(
			PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		String strIndentDetails = "";
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		try {
			PODeskGenerateTransNewVO = new PODeskGenerateTransNewVO();
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();

			PODeskGenerateTransNewVO.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			PODeskGenerateTransNewVO.setStrIndentNo(_request
					.getParameter("strIndentNo"));
			PODeskGenerateTransNewVO.setStrIndentNo(_request
					.getParameter("strStoreId"));

			PODeskGenerateTransNewBO.getIndentPopupDetails(PODeskGenerateTransNewVO);
			if (PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
				throw new Exception(PODeskGenerateTransNewVO.getStrMsgString());

			_PODeskGenerateTransNewFB.setWbRequestDetail(PODeskGenerateTransNewVO
					.getWbRequestDetail());
			// strIndentDetails = PODeskGenerateTransNewHLP
			// .getIndentPopupDetails(_PODeskGenerateTransNewFB);
			if (_PODeskGenerateTransNewFB.getStrMsgType().equals("1"))
				throw new Exception(_PODeskGenerateTransNewFB.getStrMsgString());
			_response.getWriter().print(strIndentDetails);
		} catch (Exception _Err) {

			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.getIndentPopupDetails()---->",
					_Err.getMessage());
			try {
				_response.getWriter().print(
						"Error####Application Error [ERROR ID : "
								+ hisException.getErrorID()
								+ "], Contact System Administrator! ");
			} catch (Exception _Err1) {
			}
			hisException = null;
		}
	}

	public static void insert(PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,
			HttpServletRequest _request) {
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		try {
			PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			_PODeskGenerateTransNewFB.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			_PODeskGenerateTransNewFB.setStrSeatId((String) _request.getSession()
					.getAttribute("SEATID"));
			_PODeskGenerateTransNewFB.setStrStoreId(_request
					.getParameterValues("combo")[0]);
			_PODeskGenerateTransNewFB.setStrAgendaStatus(_request
					.getParameterValues("combo")[1]);
			
			PODeskGenerateTransNewVO = (PODeskGenerateTransNewVO) TransferObjectFactory.populateData("mms.transactions.vo.PODeskGenerateTransNewVO",	_PODeskGenerateTransNewFB);
           
			PODeskGenerateTransNewBO.insert(PODeskGenerateTransNewVO);
			
			if (PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
				throw new Exception(PODeskGenerateTransNewVO.getStrMsgString());
		} catch (Exception _Err) {
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.insert()---->", _Err.getMessage());
			_PODeskGenerateTransNewFB
					.setStrErr("Error####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	
	
	public static void insertNewPO(PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,HttpServletRequest _request) 
	{
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		try 
		{
			 PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			_PODeskGenerateTransNewFB.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
			_PODeskGenerateTransNewFB.setStrSeatId((String) _request.getSession().getAttribute("SEATID"));
			_PODeskGenerateTransNewFB.setStrStoreId(_request.getParameterValues("combo")[0]);
			_PODeskGenerateTransNewFB.setStrAgendaStatus(_request.getParameterValues("combo")[3]);
			// Set formBean into Vo
			PODeskGenerateTransNewVO = (PODeskGenerateTransNewVO) TransferObjectFactory.populateData("mms.transactions.vo.PODeskGenerateTransNewVO",	_PODeskGenerateTransNewFB);
            // Calling BO Method
			PODeskGenerateTransNewBO.insertNewPO(PODeskGenerateTransNewVO);
			
			if (PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			{
				_PODeskGenerateTransNewFB.setStrMsgType("1");
				throw new Exception(PODeskGenerateTransNewVO.getStrMsgString());
			}	
			else
			{								
				 /* This Method is global method used to Send SMS Here we pass
				  * Mobile e.g 9891925159,9856577577,84848485458
				  * Msg in String format "SMS Alert...."
				  * Mode 1 = Single SMS
				  * Mode 2 = Bulk SMS
				  * Mode 3 = Send Schedule SMS
				  * */
//				//System.out.println("PO Gener Mobile No List==>"+PODeskGenerateTransNewVO.getStrMobileNoList());
//				//System.out.println("Mobile Msg==>"+PODeskGenerateTransNewVO.getStrMobileMsg());
//				//System.out.println("User Name==>"+PODeskGenerateTransNewVO.getStrMobileUserName());
//				//System.out.println("Pwd ==>"+PODeskGenerateTransNewVO.getStrMobilePwd());
				String mode = "2";
				String mobileNos = PODeskGenerateTransNewVO.getStrMobileNoList();
				String message   = PODeskGenerateTransNewVO.getStrMobileMsg();
				String username  = PODeskGenerateTransNewVO.getStrMobileUserName();
				String pwd       = PODeskGenerateTransNewVO.getStrMobilePwd();
				String senderId  = PODeskGenerateTransNewVO.getStrMobileSenderId();	
				String scheduledTime = "";  
				if(!PODeskGenerateTransNewVO.getStrMobileUserName().equals("0"))
				{	
				 // HisUtil.SendSMS(username,pwd,senderId,mode,mobileNos,message,scheduledTime);
				}  
			}
		} 
		catch (Exception _Err) 
		{
			_Err.printStackTrace();
			HisException hisException = new HisException("Purchase Order Save",	"PODeskGenerateTransNewDATA.insertNewPO()---->", _Err.getMessage());
			_PODeskGenerateTransNewFB.setStrErr("Error####Application Error [ERROR ID : "+ hisException.getErrorID()+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	
	public static void updateNewPO(PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,
			HttpServletRequest _request) 
	{
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		try 
		{
			 PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			_PODeskGenerateTransNewFB.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
			_PODeskGenerateTransNewFB.setStrSeatId((String) _request.getSession().getAttribute("SEATID"));
			_PODeskGenerateTransNewFB.setStrStoreId(_request.getParameterValues("combo")[0]);
			_PODeskGenerateTransNewFB.setStrAgendaStatus(_request.getParameterValues("combo")[1]);			
			////System.out.println("PO Item ID==>"+_PODeskGenerateTransNewFB.getStrPOItemID());
			PODeskGenerateTransNewVO = (PODeskGenerateTransNewVO) TransferObjectFactory.populateData("mms.transactions.vo.PODeskGenerateTransNewVO",	_PODeskGenerateTransNewFB);
            
			PODeskGenerateTransNewBO.updateNewPO(PODeskGenerateTransNewVO);
			_PODeskGenerateTransNewFB.setStrMsgType(PODeskGenerateTransNewVO.getStrMsgType());
			if (PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			{	
				throw new Exception(PODeskGenerateTransNewVO.getStrMsgString());
			}
			else
			{								
				 /* This Method is global method used to Send SMS Here we pass
				  * Mobile e.g 9891925159,9856577577,84848485458
				  * Msg in String format "SMS Alert...."
				  * Mode 1 = Single SMS
				  * Mode 2 = Bulk SMS
				  * Mode 3 = Send Schedule SMS
				  * */
				//System.out.println("PO Update Mobile No List==>"+PODeskGenerateTransNewVO.getStrMobileNoList());
				//System.out.println("Mobile Msg==>"+PODeskGenerateTransNewVO.getStrMobileMsg());
				//System.out.println("User Name==>"+PODeskGenerateTransNewVO.getStrMobileUserName());
				//System.out.println("Pwd ==>"+PODeskGenerateTransNewVO.getStrMobilePwd());
				
				String mode = "2";
				String mobileNos = PODeskGenerateTransNewVO.getStrMobileNoList();
				String message   = PODeskGenerateTransNewVO.getStrMobileMsg();
				String scheduledTime = "";  
				String username  = PODeskGenerateTransNewVO.getStrMobileUserName();
				String pwd       = PODeskGenerateTransNewVO.getStrMobilePwd();
				String senderId  = PODeskGenerateTransNewVO.getStrMobileSenderId();	
			
				if(!PODeskGenerateTransNewVO.getStrMobileUserName().equals("0"))
				{	
				  //HisUtil.SendSMS(username,pwd,senderId,mode,mobileNos,message,scheduledTime);
				}  
			}
		}
		catch (Exception _Err) 
		{
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.updateNewPO()---->", _Err.getMessage());
			_PODeskGenerateTransNewFB
					.setStrErr("Error####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	public static void approvedPO(PODeskGenerateTransNewFB _PODeskGenerateTransNewFB,
			HttpServletRequest _request) 
	{
		PODeskGenerateTransNewVO PODeskGenerateTransNewVO = null;
		PODeskGenerateTransNewBO PODeskGenerateTransNewBO = null;
		UserVO _userVO=null;
		String strApprovalType="";
		try 
		{
			 PODeskGenerateTransNewBO = new PODeskGenerateTransNewBO();
			_PODeskGenerateTransNewFB.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
			_PODeskGenerateTransNewFB.setStrSeatId((String) _request.getSession().getAttribute("SEATID"));
			_PODeskGenerateTransNewFB.setStrStoreId(_request.getParameterValues("combo")[0]);
			_PODeskGenerateTransNewFB.setStrAgendaStatus(_request.getParameterValues("combo")[1]);			
			////System.out.println("PO Item ID==>"+_PODeskGenerateTransNewFB.getStrPOItemID());
			PODeskGenerateTransNewVO = (PODeskGenerateTransNewVO) TransferObjectFactory.populateData("mms.transactions.vo.PODeskGenerateTransNewVO",	_PODeskGenerateTransNewFB);
			//strApproved
			if(_PODeskGenerateTransNewFB.getStrPostatus().equals("1"))
		    {
				strApprovalType = "1";
		    }	
		    else
		    {
		    	strApprovalType = "2";
		    }
			PODeskGenerateTransNewVO.setStrApprovalType(strApprovalType);
			//System.out.println("setStrApprovalType(strApprovalType::"+PODeskGenerateTransNewVO.getStrApprovalType());
			
			// Calling BO method
			PODeskGenerateTransNewBO.approvedPO(PODeskGenerateTransNewVO);
			_PODeskGenerateTransNewFB.setStrMsgType(PODeskGenerateTransNewVO.getStrMsgType());
			if (PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			{	
				throw new Exception(PODeskGenerateTransNewVO.getStrMsgString());
			}
			else
			{								
				 /* This Method is global method used to Send SMS Here we pass
				  * Mobile e.g 9891925159,9856577577,84848485458
				  * Msg in String format "SMS Alert...."
				  * Mode 1 = Single SMS
				  * Mode 2 = Bulk SMS
				  * Mode 3 = Send Schedule SMS
				  * */
//				//System.out.println("PO Update Mobile No List==>"+PODeskGenerateTransNewVO.getStrMobileNoList());
//				//System.out.println("Mobile Msg==>"+PODeskGenerateTransNewVO.getStrMobileMsg());
//				//System.out.println("User Name==>"+PODeskGenerateTransNewVO.getStrMobileUserName());
//				//System.out.println("Pwd ==>"+PODeskGenerateTransNewVO.getStrMobilePwd());
				
				String mode = "2";
				String mobileNos = PODeskGenerateTransNewVO.getStrMobileNoList();
				String message   = PODeskGenerateTransNewVO.getStrMobileMsg();
				String scheduledTime = "";  
				String username  = PODeskGenerateTransNewVO.getStrMobileUserName();
				String pwd       = PODeskGenerateTransNewVO.getStrMobilePwd();
				String senderId  = PODeskGenerateTransNewVO.getStrMobileSenderId();	
			
				if(!PODeskGenerateTransNewVO.getStrMobileUserName().equals("0"))
				{	
				 // HisUtil.SendSMS(username,pwd,senderId,mode,mobileNos,message,scheduledTime);
				}  
			}
		}
		catch (Exception _Err) 
		{
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransNewDATA.approvedPO()---->", _Err.getMessage());
			_PODeskGenerateTransNewFB
					.setStrErr("Error####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}

}
