/**
 * 
 */
package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import mms.MmsConfigUtil;
import mms.transactions.bo.RateContractDtlTransBO;
import mms.transactions.controller.fb.RateContractDtlTransFB;
import mms.transactions.vo.RateContractDtlTransVO;

/**
 * @author Administrator
 *
 */
public class RateContractDtlTransDATA {
	
	/**
	 * to display the current date AND Item Category Combo
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void initialAdd(RateContractDtlTransFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		RateContractDtlTransBO bo = null;
		RateContractDtlTransVO vo = null;
		HisUtil hisutil = null;
		String strHospitalCode = "";
		String cmb = "";
		String strSupplierName = "";
		String strContractType = "";
		String seatid = "";
		MmsConfigUtil mcu=null;
		
		String[] temp = null;
		try {
			bo = new RateContractDtlTransBO();
			vo = new RateContractDtlTransVO();
			strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE")
			.toString();

			seatid = request.getSession().getAttribute("SEATID").toString();
			hisutil = new HisUtil("mms", "RateContractDtlTransDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
			
			mcu = new MmsConfigUtil(strHospitalCode);
			
			formBean.setStrTax(mcu.getStrTaxRate());
			formBean.setStrDeliveryDays(mcu.getStrIndianDeliveryTime());
			Calendar c = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			c.add(Calendar.YEAR, 1);
			String dtStr = dateFormat.format(c.getTime());
			
			System.out.println(dtStr);
			
			formBean.setStrNtDate(dtStr);
			
			
			ResourceBundle resObj = mms.qryHandler_mms.res;
			if(resObj == null) 
			{
				resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
				mms.qryHandler_mms.res = resObj;
			}
			
			formBean.setStrReOrderFlgColor(resObj.getString("RE_ORDER_COLOR"));
			////System.out.println("MmsConfigUtil.unitid"+MmsConfigUtil.UNIT_ID);
			vo.setStrHospitalCode(strHospitalCode);
			
			if( request.getParameter("comboValue")!=null)
			{
			String comboValues = request.getParameter("comboValue");
			
			temp = comboValues.replace("^", "#").split("#");
			strSupplierName = temp[1];
			strContractType = temp[2];
		
			formBean.setStrSupplierName(strSupplierName);
			formBean.setStrContractType(strContractType);
			}
			if( request.getParameterValues("combo")[1]!=null)
			{
			String strSupplierComboID = request.getParameterValues("combo")[1];
			////System.out.println("strSupplierID"+strSupplierComboID);
			temp = strSupplierComboID.replace("^", "#").split("#");
			
			formBean.setStrSupplierId(temp[0]);
			formBean.setStrItemCategoryNo(temp[1]);
			formBean.setStrItemCategoryName(temp[2]);
			}
			if( request.getParameterValues("combo")[1]!=null)
			{
			String strContractTypeID = request.getParameterValues("combo")[2];
		
			formBean.setStrContractTypeID(strContractTypeID);
			}
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(seatid);
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			bo.getGroupCombo(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getGroupCmbWS()!= null
					&& vo.getGroupCmbWS().size() > 0) {
				cmb = hisutil.getOptionValue(vo.getGroupCmbWS(), "0", "0^Select Value", true);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}
			
			formBean.setStrGroupCmbValues(cmb);
			//formBean.setStrShelfLife("365");

		} catch (Exception e) {
			strmsgText = "RateContractDtlTrans.RateContractDtlTransDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"RateContractDtlTransDATA->initialAdd()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			vo = null;
			bo = null;
			hisutil = null;
		}

	}
	
	/**
	 * to insert the data into database
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void insertRecord(RateContractDtlTransFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		RateContractDtlTransBO bo = null;
		RateContractDtlTransVO vo = null;
		//MmsConfigUtil mcu = null;
	
		String strHospitalCode = "";
		String strSeatId = "";
	
		String strFinancialStartYear = "";
		String strFinancialEndYear = "";

		String temp[] = null;
		String temp1[] = null;
		
		String strItemID[] = null;
		String strItemBrandID[] = null;
		String strGroupID[] = null;
		String strLastRate[] = null;
		String strLastRateUnitID[] = null; 
		
		
		String strRateUnitID[] = null; 
		HisUtil util = null;
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		
		
		try {
			bo = new RateContractDtlTransBO();
			//mcu = new MmsConfigUtil();
			util = new HisUtil("","");
            strCurrentDate  = util.getASDate("dd-MM-yyyy");
			
			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
			
			
			System.out.println(formBean.getStrImportedType());
			
			if(strCurrentMonth>=4 )
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
							
			strFinancialStartYear = "01-Apr"+"-" + CURRENT_YEAR; 
			
			strFinancialEndYear = "31-Mar"+"-" + (CURRENT_YEAR+1);	
			
			
			strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			strSeatId = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrHospitalCode(strHospitalCode);
			formBean.setStrSeatId(strSeatId);
			
			vo = (RateContractDtlTransVO) TransferObjectFactory.populateData("mms.transactions.vo.RateContractDtlTransVO", formBean);
			vo.setStrRateArray(formBean.getStrRate());
			vo.setStrSecurityAmt(formBean.getStrSecurityAmt());
			vo.setItemParamValueArray(formBean.getItemParamValue());
			vo.setStrUnitNameArray(formBean.getStrUnitName());
			vo.setStrFinancialStartYr(strFinancialStartYear);
			vo.setStrFinancialEndYr(strFinancialEndYear);
			////System.out.println("vo.getStrRate().length"+vo.getStrRateArray().length);
			
			int nMultiRowLen = vo.getStrRateArray().length;
			
			strItemID = new String[nMultiRowLen];
			strItemBrandID = new String[nMultiRowLen];
			strGroupID = new String[nMultiRowLen];
			strLastRate = new String[nMultiRowLen];
			strLastRateUnitID = new String[nMultiRowLen];
			//strRate = new String[nMultiRowLen];
			strRateUnitID = new String[nMultiRowLen];
			
			
			String strImportedType[]=new String[nMultiRowLen];
					
			for(int i=0;i<nMultiRowLen;i++)
			{
			//////System.out.println("vo.getItemParamValueArray()[i]-"+vo.getItemParamValueArray()[i]);
			

				temp1 = vo.getItemParamValueArray()[i].split("#");
				temp =temp1[2].replace("^", "#").split("#");
				strItemID[i] = temp[0];
				strItemBrandID[i] = temp[1];
				strGroupID[i] = temp[2];
				strLastRate[i] = temp[5];
				strLastRateUnitID[i] = temp[6];
				
				temp1 = vo.getStrUnitNameArray()[i].replace("^", "#").split("#");
				strRateUnitID[i] = temp1[0];
				if(formBean.getStrImportedType() == null)
				strImportedType[i]="0";
				else
				strImportedType[i]="1";	
				
				
			}
			
			vo.setStrItemIDArray(strItemID);
			vo.setStrItemBrandIDArray(strItemBrandID);
			vo.setStrGroupIDArray(strGroupID);
			vo.setStrLastRateArray(strLastRate);
			vo.setStrLastRateUnitIDArray(strLastRateUnitID);
			vo.setStrRateUnitIDArray(strRateUnitID);
			vo.setStrSeatId(strSeatId);
			vo.setStrFinancialEndYr(strFinancialEndYear);
			vo.setStrFinancialStartYr(strFinancialStartYear);
			vo.setStrDeiveryLeadTime("0");
			vo.setStrDeiveryLeadTimeUnit("0");
			vo.setStrDeliveryDays(formBean.getStrDeliveryDays());
			vo.setStrHospitalCode(strHospitalCode);		
			
			vo.setStrNtDate(formBean.getStrContractToDate());
			
			vo.setStrImportedType(strImportedType);
			vo.setStrShelfLife(formBean.getStrShelfLife());
			vo.setStrLevel(formBean.getStrLevel());
			vo.setStrRCChk(formBean.getStrRCChk());
			
			bo.insertRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if(vo.getBExistStatus() == false)
			{
				formBean.setStrWarning("This Supplier Is Already Added For The Same Item And Same Contract Type ");
			}
			else{
			formBean.setStrMsg("Data Saved Successfully");
			}
		

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "RateContractDtlTrans.RateContractDtlTransDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"RateContractDtlTransDATA->insertRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
		
			
			vo = null;
			bo = null;
		}

	}

	/**
	 * to get all the details
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void viewDetails(RateContractDtlTransFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		RateContractDtlTransBO bo = null;
		RateContractDtlTransVO vo = null;
		HisUtil hisutil = null;
		String strSupplierName = "";
		String strContractType = "";
		String strItemCategoryName = "";
		
		String temp[]=null;
		String temp1[]=null;
		String strItemCategoryNo = "";
		
	//	String strPreviousRenewDtls = ""; 
		
		String chk = ""; 
		try {
		
			bo = new RateContractDtlTransBO();
			vo = new RateContractDtlTransVO();

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		    Calendar c1 = Calendar.getInstance();	    
		    c1.add(Calendar.DATE,1);   // or  Calendar.DAY_OF_MONTH which is a synonym
		    //System.out.println("Date + 1 days is : " + sdf.format(c1.getTime()));
		    formBean.setStrNextCurrentDate(sdf.format(c1.getTime()));
			
			hisutil = new HisUtil("mms", "RateContractDtlTransDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
			if( request.getParameter("comboValue")!=null)
			{
				formBean.setComboValue(request.getParameter("comboValue"));
			
			}
			String comboValues =formBean.getComboValue();
			temp = comboValues.replace("^", "#").split("#");
			strSupplierName = temp[1];
			strContractType = temp[2];
			System.out.println("comboValues"+request.getParameter("comboValue"));
			System.out.println("comboValues"+comboValues);
			System.out.println("strSupplierName"+strSupplierName);
			formBean.setStrSupplierName(strSupplierName);
			formBean.setStrContractType(strContractType);
			
			if( request.getParameterValues("combo")[1]!=null)
			{
			String strSupplierComboID = request.getParameterValues("combo")[1];
			////System.out.println("strSupplierID"+strSupplierComboID);
			temp = strSupplierComboID.replace("^", "#").split("#");
			
			formBean.setStrSupplierId(temp[0]);
			formBean.setStrItemCategoryNo(temp[1]);
			strItemCategoryNo = temp[1];
			strItemCategoryName = temp[2];
			}
			
			if(request.getParameter("chk")!=null)
			{
			chk = request.getParameter("chk");
			formBean.setStrChk1(chk);
			}
			
			
			System.out.println("formBean.getStrChk1()-"+formBean.getStrChk1());
			temp = formBean.getStrChk1().replace("@", "#").split("#");
			vo.setStrSupplierId(temp[0]);
			vo.setStrContractTypeID(temp[1]);
			vo.setStrItemID(temp[2]);
			vo.setStrItemBrandID(temp[3]);
			vo.setStrHospitalCode(temp[4]);
			
			
			temp1 = temp[5].replace("$", "#").split("#");
			vo.setStrSlNo(temp1[0]);
			
			bo.viewDetails(vo);
			System.out.println("Outside View Details.....");
			if (vo.getStrMsgType().equals("1")) {
				System.out.println(vo.getStrMsgString());
				throw new Exception(vo.getStrMsgString());
			}

			TransferObjectFactory.populateData(formBean, vo);
			
			formBean.setStrItemCategoryName(strItemCategoryName);
			
			String cmb = hisutil.getOptionValue(vo.getRateUnitWS(), vo.getStrRateUnitID(), "", true);
			formBean.setStrUnitCmbValues(cmb);
			//System.out.println(cmb);
			formBean.setStrItemCategoryNo(strItemCategoryNo);
			//System.out.println(strItemCategoryNo);
			formBean.setStrSupplierName(strSupplierName);
			//System.out.println(strSupplierName);
			formBean.setStrContractType(strContractType);
			//System.out.println(strContractType);
			formBean.setStrQuotationDate(vo.getStrQuotationDate());
			//System.out.println(vo.getStrQuotationDate());
			formBean.setStrTenderDate(vo.getStrTenderDate());
			//System.out.println(vo.getStrTenderDate());
			formBean.setStrTax(vo.getStrTax());
			formBean.setStrTaxType(vo.getStrTaxType());
			formBean.setStrRcTenderSno(vo.getStrRcTenderSno());
			formBean.setStrRenewPackSize(vo.getStrRenewPackSize());
			if(vo.getStrImportTypeViewFlag().equals("0") || vo.getStrImportTypeViewFlag().equals(null) || vo.getStrImportTypeViewFlag().equals(" "))
			formBean.setStrImportTypeViewFlag("NO");
			else
			formBean.setStrImportTypeViewFlag("YES");	
			
			
			System.out.println(" Tax::::"+vo.getStrTax()+"::  Tax value:::"+vo.getStrTaxType());
			System.out.println("Prev Tax::::"+vo.getStrPrevTax()+":: Prev tax value:::"+vo.getStrPrevTaxTypeValue());
			
			formBean.setStrPrevRenewFlag(vo.getStrPrevRenewFlag());
			formBean.setStrPrevTax(vo.getStrPrevTax());
			formBean.setStrPrevTaxType(vo.getStrPrevTaxType());
			formBean.setStrContractValidity(vo.getStrContractValidity());
			formBean.setStrTaxWithType(vo.getStrTax()+" GST ");//+vo.getStrTaxType());
			formBean.setStrPrevTaxWithType(vo.getStrPrevTax()+"   "+vo.getStrPrevTaxTypeValue());
			System.out.println("Prev Renew Flg:::"+vo.getStrPrevRenewFlag());
			System.out.println("Inside HLP::::"+vo.getStrPrevContractQty());
			formBean.setStrPrevContractQty(vo.getStrPrevContractQty());
            formBean.setStrDeliveryDays(vo.getStrDeliveryDays());
            formBean.setStrPreviousContractFromDate(vo.getStrContractFromDate());
            formBean.setStrLastSecurityAmount(vo.getStrLastSecurityAmount());
            
            formBean.setStrRenewShelfLife(vo.getStrRenewShelfLife());
            formBean.setStrRenewLevel(vo.getStrRenewLevel());
            formBean.setStrRenewRate(vo.getStrLastPurchaseRate());
            formBean.setStrRenewRateContQty(vo.getStrLastContractQty());
            
			
		

		} catch (Exception e) {
			strmsgText = "RateContractDtlTrans.RateContractDtlTransDATA.viewDetails(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("mms",	"RateContractDtlTransDATA->viewDetails()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} finally {

			hisutil = null;
			vo=null;
			bo=null;
			
		}

	}
	

	
	/**
	 * to insert the data into database when review
	 * 
	 * @param formBean
	 * @param request
	 */
	public static boolean insertRenew(RateContractDtlTransFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		RateContractDtlTransBO bo = null;
		RateContractDtlTransVO vo = null;
		MmsConfigUtil mcu = null;
		boolean retval=true ;
		String strHospitalCode = "";
		String strSeatId = "";
	
		String strFinancialStartYear = "";
		String strFinancialEndYear = "";
		HisUtil util = null;
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
	
		
		try {
			bo = new RateContractDtlTransBO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			util = new HisUtil("","");
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
							
			strFinancialStartYear = "01-Apr"+"-" + CURRENT_YEAR; 
			
			strFinancialEndYear = "31-Mar"+"-" + (CURRENT_YEAR+1);	
			strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			strSeatId = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrHospitalCode(strHospitalCode);
			formBean.setStrSeatId(strSeatId);
			
			vo = (RateContractDtlTransVO) TransferObjectFactory.populateData(
					"mms.transactions.vo.RateContractDtlTransVO", formBean);
			
			
			vo.setStrRenewLevel(formBean.getStrRenewLevel());
			vo.setStrNtDate(formBean.getStrContractToDate());
			
		
			vo.setStrSeatId(strSeatId);
			vo.setStrFinancialEndYr(strFinancialEndYear);
			vo.setStrFinancialStartYr(strFinancialStartYear);
			
			
			bo.insertRenewData(vo);

			if (vo.getStrMsgType().equals("1")) {
				retval = false;
				throw new Exception(vo.getStrMsgString());
				
			}

		/*	if(vo.getBExistStatus() == false)
			{
				formBean.setStrWarning("This Contract has already been renewed ! ");
				retval = false;
			}*/
			else{
			formBean.setStrMsg("Data Saved Successfully");
			}
		
		

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "RateContractDtlTrans.RateContractDtlTransDATA.insertRenew(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"RateContractDtlTransDATA->insertRenew()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
		
			
			vo = null;
			bo = null;
		}
		return retval;

	}
	
	public static boolean modifyRecord(RateContractDtlTransFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		RateContractDtlTransBO bo = null;
		RateContractDtlTransVO vo = null;
		MmsConfigUtil mcu = null;
		boolean retval=true ;
		String strHospitalCode = "";
		String strSeatId = "";
	
		String strFinancialStartYear = "";
		String strFinancialEndYear = "";
		HisUtil util = null;
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
	
		
		try {
			bo = new RateContractDtlTransBO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			util = new HisUtil("","");
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
							
			strFinancialStartYear = "01-Apr"+"-" + CURRENT_YEAR; 
			
			strFinancialEndYear = "31-Mar"+"-" + (CURRENT_YEAR+1);	
			strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			strSeatId = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrHospitalCode(strHospitalCode);
		
			vo = (RateContractDtlTransVO) TransferObjectFactory.populateData(
					"mms.transactions.vo.RateContractDtlTransVO", formBean);
			
			
			vo.setStrRenewLevel(formBean.getStrRenewLevel());
			vo.setStrNtDate(formBean.getStrContractToDate());
			
		
			vo.setStrSeatId(strSeatId);
			vo.setStrFinancialEndYr(strFinancialEndYear);
			vo.setStrFinancialStartYr(strFinancialStartYear);
			vo.setStrRcTenderSno(formBean.getStrRcTenderSno());
			vo.setStrPackSize(formBean.getStrPackSize());
			
			bo.modifyRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				retval = false;
				throw new Exception(vo.getStrMsgString());
				
			}

		/*	if(vo.getBExistStatus() == false)
			{
				formBean.setStrWarning("This Contract has already been renewed ! ");
				retval = false;
			}*/
			else{
			formBean.setStrMsg("Data Saved Successfully");
			}
		
		

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "RateContractDtlTrans.RateContractDtlTransDATA.insertRenew(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"RateContractDtlTransDATA->insertRenew()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
		
			
			vo = null;
			bo = null;
		}
		return retval;

	}

	
	/**
	 * to get all the details
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void cancelRecord(RateContractDtlTransFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		RateContractDtlTransBO bo = null;
		RateContractDtlTransVO vo = null;
		HisUtil hisutil = null;
		
		String temp[]=null;
		String temp1[]=null;
	//	String strItemCategoryNo = "";
		String seatid = "";
	
		
		String chk = ""; 
		try {
			bo = new RateContractDtlTransBO();
			vo = new RateContractDtlTransVO();

			seatid = request.getSession().getAttribute("SEATID").toString();
			hisutil = new HisUtil("mms", "RateContractDtlTransDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
			vo.setStrSeatId(seatid);
			
			if( request.getParameterValues("combo")[1]!=null)
			{
			String strSupplierComboID = request.getParameterValues("combo")[1];
			////System.out.println("strSupplierID"+strSupplierComboID);
			temp = strSupplierComboID.replace("^", "#").split("#");
			
			formBean.setStrSupplierId(temp[0]);
			formBean.setStrItemCategoryNo(temp[1]);
		//	strItemCategoryNo = temp[1];
			
			}
			
			if(request.getParameter("chk")!=null)
			{
			chk = request.getParameter("chk");
			formBean.setStrChk1(chk);
			}
			////System.out.println("chk-"+chk);
			
			//System.out.println("formBean.getStrChk1()-"+formBean.getStrChk1());
			temp = formBean.getStrChk1().replace("@", "#").split("#");
			vo.setStrSupplierId(temp[0]);
			vo.setStrContractTypeID(temp[1]);
			vo.setStrItemID(temp[2]);
			vo.setStrItemBrandID(temp[3]);
			vo.setStrHospitalCode(temp[4]);
			
			
			temp1 = temp[5].replace("$", "#").split("#");
			vo.setStrSlNo(temp1[0]);
			
			vo.setStrCancelRemarks(temp[7]);
			
			/*bo.viewDetails(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}*/

			bo.updateRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
		

		} catch (Exception e) {
			strmsgText = "RateContractDtlTrans.RateContractDtlTransDATA.cancelRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"RateContractDtlTransDATA->cancelRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			hisutil = null;
			vo=null;
			bo=null;
			
		}

	}
	
	
	
	public static boolean insertRateContractExtension(RateContractDtlTransFB formBean, HttpServletRequest request) {

		String strmsgText = "";
		RateContractDtlTransBO bo = null;
		RateContractDtlTransVO vo = null;
		boolean retval=true ;
		String strHospitalCode = "";
		String strSeatId = "";
	
		
		try {
			bo = new RateContractDtlTransBO();

			strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			strSeatId = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrHospitalCode(strHospitalCode);
			formBean.setStrSeatId(strSeatId);
			
			vo = (RateContractDtlTransVO) TransferObjectFactory.populateData("mms.transactions.vo.RateContractDtlTransVO", formBean);
			//20140001401002@0$1
			vo.setStrContractId(formBean.getStrChk1().split("\\@")[6].replace("$", "#").split("#")[0]);		
			
			vo.setStrLettrNo(formBean.getStrLettrNo());
					    
			vo.setStrSeatId(strSeatId);
			
			bo.insertRateContractExtension(vo);  

			if (vo.getStrMsgType().equals("1")) {
				retval = false;
				throw new Exception(vo.getStrMsgString());
			}
			else{
			formBean.setStrMsg("Data Saved Successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "RateContractDtlTrans.RateContractDtlTransDATA.insertRenew(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("mms","RateContractDtlTransDATA->insertRenew()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
		
			
			vo = null;
			bo = null;
		}
		return retval;
	}
	
	


}
