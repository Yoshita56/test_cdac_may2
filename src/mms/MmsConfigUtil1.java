/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         MmsConfigUtil.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import mms.masters.controller.data.MmsConfigMstDATA;
import mms.masters.dao.MmsConfigMstDAO;
import mms.setup.MmsConfigGeneral;
import mms.setup.MmsConfigType;
import mms.setup.MmsIssueProcessType;

// TODO: Auto-generated Javadoc
/**
 * The Class MmsConfigUtil.
 */
public class MmsConfigUtil1 {

	/** The jax b. */
	private JAXBElement<MmsConfigType> jaxB = readXMLDataObject();

	/** The mms config. */
	private MmsConfigType mmsConfig = jaxB.getValue();

	/** The mms issue config. */
	private MmsIssueProcessType mmsIssueConfig = mmsConfig.getMmsIssueProcess();

	/** The mms config general. */
	private MmsConfigGeneral mmsConfigGen = mmsConfig.getMmsConfigGerneral();

	/** The str financial start date. */
	private String strFinancialStartDate = "";

	/** The str financial end date. */
	private String strFinancialEndDate = "";

	/** The str Residual Cost for Auction. */
	private String strResidualCost = "";

	/** The str period id. */
	private String strPeriodId = "";

	/** The str issue mode. */
	private String strIssueMode = "";

	/** The str last issue patient staff in days. */
	private String strLastIssuePatientStaffInDays = "";

	/** The str last issue employee in days. */
	private String strLastIssueEmployeeInDays = "";

	/** The str online issue details in days. */
	private String strOnlineIssueDetailsInDays = "";

	/** * committe File Path. */
	private String strCommitteeFilePath = "";

	/** * Indian Delivery Time File Path. */
	private String strIndianDeliveryTime = "";

	/** * Impotred Delivery Time File Path. */
	private String strImportedDeliveryTime = "";

	/** The Constant MODULE_ID. */
	public static final String MODULE_ID = "63";

	/** The Constant UNIT_ID. */
	public static final String UNIT_ID = "630001";

	/** The Constant STAFF_CAT_CODE. */
	public static final String STAFF_CAT_CODE = "12";

	/** The Constant PHY_STOCK_ITEM_PER_PAGE. */
	public static final String PHY_STOCK_ITEM_PER_PAGE = "40";

	/** The Constant DEFAULT_CURRENCY_CODE. */
	public static final String DEFAULT_CURRENCY_CODE = "100"; // Default
	// Currency Code
	// INR.

	/** The Constant SUPPLIER_BILL. */
	public static final String SUPPLIER_BILL = "10";

	/** The str batch no. */
	public String strBatchNo = "0";

	/** The str auto return request. */
	private String strAutoReturnRequest = "";

	/** The str a category. */
	public String strACategory = "0";

	/** The str b1 category. */
	public String strB1Category = "0";

	/** The str b2 category. */
	public String strB2Category = "0";

	/** The str c category. */
	public String strCCategory = "0";

	/** The str f category. */
	public String strFCategory = "0";

	/** The str n1 category. */
	public String strN1Category = "0";

	/** The str n2 category. */
	public String strN2Category = "0";

	/** The str s category. */
	public String strSCategory = "0";

	/** The str cost req. */
	private String strCostReq = "0";

	/** The str exp alert days. */
	private String strExpAlertDays = "0";

	/** The str win location. */
	private String strWinLocation = "";

	/** The str lin location. */
	private String strLinLocation = "";
	/* Added by Amit Kumar */
	/** The str store config catg. */
	private String strStoreConfigCatg = "0";

	/** The str country code. */
	private String strCountryCode;

	/** The str state code. */
	private String strStateCode;

	/** The str issue rate config flg. */
	private String strIssueRateConfigFlg;

	/** The str config issue rate. */
	private String strConfigIssueRate;

	/** The str demand active flg. */
	private String strDemandActiveFlg;

	/** The str demand active prd. */
	private String strDemandActivePrd;

	/** The str budget flg. */
	private String strBudgetFlg;

	/** The str with out cr no flg. */
	private String strWithOutCrNoFlg;

	/** The str cr no default. */
	private String strCrNoDefault;

	/** The str return drug validity. */
	private String strReturnDrugValidity;

	/** The str dose frq flg. */
	private String strDoseFrqFlg;

	/** The str contract value. */
	private String strContractValue;

	/** The str stamp paper amt. */
	private String strStampPaperAmt;

	/** The str sample send flg. */
	private String strSampleSendFlg = "0";

	/** The str po demnad validity. */
	public static String strPODemnadValidity = "";

	/**
	 * Gets the str PO Demand Active Period For PO Genration Desk.
	 * 
	 * 
	 * @param strHospitalCode
	 *            the str hospital code
	 * 
	 * @return the str strPODemnadValidity
	 */
	public static String getStrPODemnadValidity(String strHospitalCode) {
		strPODemnadValidity = MmsConfigMstDAO
				.getPODemandValidity(strHospitalCode);

		return strPODemnadValidity;
	}

	/**
	 * Gets the str contract value.
	 * 
	 * @return the strDoseFrqFlg
	 */
	public String getStrContractValue() {
		strContractValue = mmsConfigGen.getStrContractValue();
		return strContractValue;
	}

	/**
	 * Gets the stamp paper amt.
	 * 
	 * @return the StampPaperAmt
	 */
	public String getStampPaperAmt() {
		strStampPaperAmt = mmsConfigGen.getStrStampPaperAmt();
		return strStampPaperAmt;
	}

	/**
	 * Gets the str dose frq flg.
	 * 
	 * @return the strDoseFrqFlg
	 */
	public String getStrDoseFrqFlg() {
		strDoseFrqFlg = mmsIssueConfig.getStrDoseFrqFlg();
		return strDoseFrqFlg;
	}

	/**
	 * Gets the str return drug validity.
	 * 
	 * @return the strReturnDrugValidity
	 */
	public String getStrReturnDrugValidity() {
		strReturnDrugValidity = mmsIssueConfig.getStrReturnDrugValidity();
		return strReturnDrugValidity;
	}

	/**
	 * Gets the str cr no default.
	 * 
	 * @return the strCrNoDefault
	 */
	public String getStrCrNoDefault() {
		strCrNoDefault = mmsIssueConfig.getStrCrNoDefault();
		return strCrNoDefault;
	}

	/**
	 * Gets the str with out cr no flg.
	 * 
	 * @return the strWithOutCrNoFlg
	 */
	public String getStrWithOutCrNoFlg() {
		strWithOutCrNoFlg = mmsIssueConfig.getStrWithOutCrNoFlg();
		return strWithOutCrNoFlg;
	}

	/**
	 * Gets the str budget flg.
	 * 
	 * @return the strDemandActiveFlg
	 */
	public String getStrBudgetFlg() {
		strBudgetFlg = mmsConfigGen.getStrBudgetFlg();
		return strBudgetFlg;
	}

	/**
	 * Gets the str demand active prd.
	 * 
	 * @return the strDemandActiveFlg
	 */
	public String getStrDemandActivePrd() {
		strDemandActivePrd = mmsIssueConfig.getStrDemandActivePrd();
		return strDemandActivePrd;
	}

	/**
	 * Gets the str demand active flg.
	 * 
	 * @return the strDemandActiveFlg
	 */
	public String getStrDemandActiveFlg() {
		strDemandActiveFlg = mmsIssueConfig.getStrDemandActiveFlg();
		return strDemandActiveFlg;
	}

	/**
	 * Gets the str config issue rate.
	 * 
	 * @return the strIssueRateConfigFlg
	 */
	public String getStrConfigIssueRate() {
		strConfigIssueRate = mmsConfigGen.getStrConfigIssueRate();
		return strConfigIssueRate;
	}

	/**
	 * Gets the str issue rate config flg.
	 * 
	 * @return the strIssueRateConfigFlg
	 */
	public String getStrIssueRateConfigFlg() {
		strIssueRateConfigFlg = mmsConfigGen.getStrIssueRateConfigFlg();
		return strIssueRateConfigFlg;
	}

	/**
	 * Gets the str state code.
	 * 
	 * @return the strStateCode
	 */
	public String getStrStateCode() {
		strStateCode = mmsConfigGen.getStrStateCode();
		return strStateCode;
	}

	/**
	 * Gets the str country code.
	 * 
	 * @return the strConfigCatg
	 */
	public String getStrCountryCode() {
		strCountryCode = mmsConfigGen.getStrCountryCode();
		return strCountryCode;
	}

	/**
	 * Gets the str store config catg.
	 * 
	 * @return the strConfigCatg
	 */
	public String getStrStoreConfigCatg() {
		strStoreConfigCatg = mmsConfigGen.getStoreCategory();
		return strStoreConfigCatg;
	}

	/**
	 * Gets the str win location.
	 * 
	 * @return the strCostReq
	 */
	public String getStrWinLocation() {
		strWinLocation = mmsConfigGen.getCommitteeFilePathWin();
		return strWinLocation;
	}

	/**
	 * Gets the str lin location.
	 * 
	 * @return the strCostReq
	 */
	public String getStrLinLocation() {
		strLinLocation = mmsConfigGen.getCommitteeFilePathLin();
		return strLinLocation;
	}

	/**
	 * Gets the str exp alert days.
	 * 
	 * @return the strExpAlertDays
	 */
	public String getStrExpAlertDays() {
		strExpAlertDays = mmsConfigGen.getExpAlertDays();
		return strExpAlertDays;
	}

	/**
	 * Gets the str cost req.
	 * 
	 * @return the strCostReq
	 */
	public String getStrCostReq() {
		strCostReq = mmsConfigGen.getCostRequired();
		return strCostReq;
	}

	/**
	 * Gets the str batch no.
	 * 
	 * @return the str batch no
	 */
	public String getStrBatchNo() throws Exception {

		HisUtil util = null;

		try {

			util = new HisUtil("Mms", "MmsConfigUtil");

			strBatchNo = "~" + util.getDSDate("dd/MM/yyyy HH:mm:ss");
		} catch (Exception e) {

			throw e;

		} finally {

			util = null;

		}

		return strBatchNo;
	}

	/**
	 * Gets the str financial start date.
	 * 
	 * @param strStoreId
	 *            the str store id
	 * @param strHospitalCode
	 *            the str hospital code
	 * 
	 * @return the str financial start date
	 */
	public String getStrFinancialStartDate(String strStoreId,
			String strHospitalCode) {

		strFinancialStartDate = MmsConfigMstDAO.getDateDetails(strStoreId, strHospitalCode).replace("^", "#").split("#")[0];

		return strFinancialStartDate;
	}

	/**
	 * Gets the str financial end date.
	 * 
	 * @param strStoreId
	 *            the str store id
	 * @param strHospitalCode
	 *            the str hospital code
	 * 
	 * @return the str financial end date
	 */
	public String getStrFinancialEndDate(String strStoreId,
			String strHospitalCode) {

		strFinancialEndDate = MmsConfigMstDAO
				.getDateDetails(strStoreId, strHospitalCode).replace("^", "#")
				.split("#")[1];

		return strFinancialEndDate;
	}

	/**
	 * common method for creating a XML Root Elements Data Object.
	 * 
	 * @return JAXBElement Object
	 */

	@SuppressWarnings("unchecked")
	private JAXBElement<MmsConfigType> readXMLDataObject() {

		JAXBElement<MmsConfigType> jaxB = null;
		JAXBContext jc = null;
		Unmarshaller u = null;
		// FileInputStream fs = null;

		
		try {
			jaxB = MmsConfigMstDATA.gblJaxB;

			if (jaxB == null) {
				jc = JAXBContext.newInstance("mms.setup");
				u = jc.createUnmarshaller();
				// fs = new
				// FileInputStream(HisUtil.getParameterFromHisPathXML("MMS_CONFIG"));

				jaxB = (JAXBElement<MmsConfigType>) u.unmarshal(new File(
						HisUtil.getParameterFromHisPathXML("MMS_CONFIG")));
				MmsConfigMstDATA.gblJaxB = jaxB;

				

			}

		} catch (Exception e) {

			new HisException("Mms Configuration", "mms.MmsConfigUtil",
					"MmsConfigUtil.readXMLDataObject() -->" + e.getMessage());

		} finally {
			jc = null;
			u = null;

			/*
			 * try { if(fs != null) { fs.close(); fs = null; } }catch(Exception
			 * e1){}
			 */
		}
		return jaxB;

	}

	/**
	 * Gets the str issue mode.
	 * 
	 * @return the str issue mode
	 */
	public String getStrIssueMode() {

		strIssueMode = mmsIssueConfig.getIssueMode();

		return strIssueMode;
	}

	/**
	 * Gets the str last issue patient staff in days.
	 * 
	 * @return the str last issue patient staff in days
	 */
	public String getStrLastIssuePatientStaffInDays() {

		strLastIssuePatientStaffInDays = mmsIssueConfig
				.getLastIssuePatientStaffInDays();

		return strLastIssuePatientStaffInDays;
	}

	/**
	 * Gets the str last issue employee in days.
	 * 
	 * @return the str last issue employee in days
	 */
	public String getStrLastIssueEmployeeInDays() {

		strLastIssueEmployeeInDays = mmsIssueConfig
				.getLastIssueEmployeeInDays();

		return strLastIssueEmployeeInDays;
	}

	/**
	 * Gets the str online issue details in days.
	 * 
	 * @return the str online issue details in days
	 */
	public String getStrOnlineIssueDetailsInDays() {

		strOnlineIssueDetailsInDays = mmsIssueConfig
				.getOnlineIssueDetailsInDays();

		return strOnlineIssueDetailsInDays;
	}

	/**
	 * Gets the str period id.
	 * 
	 * @param strStoreId
	 *            the str store id
	 * @param strItemCatCode
	 *            the str item cat code
	 * @param strHospitalCode
	 *            the str hospital code
	 * 
	 * @return the str period id
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public String getStrPeriodId(String strStoreId, String strItemCatCode,
			String strHospitalCode) throws Exception {

		try {
			strPeriodId = MmsConfigMstDAO.getPeriodId(strStoreId,
					strItemCatCode, strHospitalCode);
		} catch (Exception e) {

			throw e;
		}

		return strPeriodId;
	}

	/**
	 * Gets the module id.
	 * 
	 * @return the module id
	 */
	public static String getMODULE_ID() {
		return MODULE_ID;
	}

	/**
	 * Gets the unit id.
	 * 
	 * @return the unit id
	 */
	public static String getUNIT_ID() {
		return UNIT_ID;
	}

	/**
	 * Gets the staff cat code.
	 * 
	 * @return the staff cat code
	 */
	public static String getSTAFF_CAT_CODE() {
		return STAFF_CAT_CODE;
	}

	/**
	 * Gets the phy stock item per page.
	 * 
	 * @return the phy stock item per page
	 */
	public static String getPHY_STOCK_ITEM_PER_PAGE() {
		return PHY_STOCK_ITEM_PER_PAGE;
	}

	/**
	 * Gets the default currency code.
	 * 
	 * @return the default currency code
	 */
	public static String getDEFAULT_CURRENCY_CODE() {
		return DEFAULT_CURRENCY_CODE;
	}

	/**
	 * Gets the supplier bill.
	 * 
	 * @return the supplier bill
	 */
	public static String getSUPPLIER_BILL() {
		return SUPPLIER_BILL;
	}

	/**
	 * Gets the str a category.
	 * 
	 * @param strHospitalCode
	 *            the str hospital code
	 * @return the str a category
	 * @throws Exception
	 *             the exception
	 */
	public String getStrACategory(String strHospitalCode) throws Exception {

		try {
			strACategory = MmsConfigMstDAO.getParamValue("ABC", 0,
					strHospitalCode);
		} catch (Exception e) {

			throw e;
		}

		return strACategory;
	}

	/**
	 * Gets the str b1 category.
	 * 
	 * @param strHospitalCode
	 *            the str hospital code
	 * @return the str b1 category
	 * @throws Exception
	 *             the exception
	 */
	public String getStrB1Category(String strHospitalCode) throws Exception {

		try {
			strACategory = MmsConfigMstDAO.getParamValue("ABC", 1,
					strHospitalCode);
		} catch (Exception e) {

			throw e;
		}

		return strB1Category;
	}

	/**
	 * Gets the str b2 category.
	 * 
	 * @param strHospitalCode
	 *            the str hospital code
	 * @return the str b2 category
	 * @throws Exception
	 *             the exception
	 */
	public String getStrB2Category(String strHospitalCode) throws Exception {

		try {
			strACategory = MmsConfigMstDAO.getParamValue("ABC", 2,
					strHospitalCode);
		} catch (Exception e) {

			throw e;
		}

		return strB2Category;
	}

	/**
	 * Gets the str c category.
	 * 
	 * @param strHospitalCode
	 *            the str hospital code
	 * @return the str c category
	 * @throws Exception
	 *             the exception
	 */
	public String getStrCCategory(String strHospitalCode) throws Exception {

		try {
			strACategory = MmsConfigMstDAO.getParamValue("ABC", 3,
					strHospitalCode);
		} catch (Exception e) {

			throw e;
		}

		return strCCategory;
	}

	/**
	 * Gets the str f category.
	 * 
	 * @param strHospitalCode
	 *            the str hospital code
	 * @return the str f category
	 * @throws Exception
	 *             the exception
	 */
	public String getStrFCategory(String strHospitalCode) throws Exception {

		try {
			strACategory = MmsConfigMstDAO.getParamValue("XYZ", 0,
					strHospitalCode);
		} catch (Exception e) {

			throw e;
		}

		return strFCategory;
	}

	/**
	 * Gets the str n1 category.
	 * 
	 * @param strHospitalCode
	 *            the str hospital code
	 * @return the str n1 category
	 * @throws Exception
	 *             the exception
	 */
	public String getStrN1Category(String strHospitalCode) throws Exception {

		try {
			strACategory = MmsConfigMstDAO.getParamValue("XYZ", 1,
					strHospitalCode);
		} catch (Exception e) {

			throw e;
		}

		return strN1Category;
	}

	/**
	 * Gets the str n2 category.
	 * 
	 * @param strHospitalCode
	 *            the str hospital code
	 * @return the str n2 category
	 * @throws Exception
	 *             the exception
	 */
	public String getStrN2Category(String strHospitalCode) throws Exception {

		try {
			strACategory = MmsConfigMstDAO.getParamValue("XYZ", 2,
					strHospitalCode);
		} catch (Exception e) {

			throw e;
		}

		return strN2Category;
	}

	/**
	 * Gets the str s category.
	 * 
	 * @param strHospitalCode
	 *            the str hospital code
	 * @return the str s category
	 * @throws Exception
	 *             the exception
	 */
	public String getStrSCategory(String strHospitalCode) throws Exception {

		try {
			strACategory = MmsConfigMstDAO.getParamValue("XYZ", 3,
					strHospitalCode);
		} catch (Exception e) {

			throw e;
		}

		return strSCategory;
	}

	/**
	 * Gets the * committe File Path.
	 * 
	 * @return the * committe File Path
	 */
	public String getStrCommitteeFilePath() {
		strCommitteeFilePath = mmsConfigGen.getCommitteeFilePath();
		return strCommitteeFilePath;
	}

	/**
	 * Gets the * Indian Delivery Time File Path.
	 * 
	 * @return the strIndianDeliveryTime
	 */
	public String getStrIndianDeliveryTime() {
		strIndianDeliveryTime = mmsConfigGen.getIndianDeliveryTime();
		return strIndianDeliveryTime;
	}

	/**
	 * Gets the * Impotred Delivery Time File Path.
	 * 
	 * @return the strImportedDeliveryTime
	 */
	public String getStrImportedDeliveryTime() {
		strImportedDeliveryTime = mmsConfigGen.getImportedDeliveryTime();
		return strImportedDeliveryTime;
	}

	/**
	 * Gets the str auto return request.
	 * 
	 * @return the strAutoReturnRequest
	 */
	public String getStrAutoReturnRequest() {
		strAutoReturnRequest = mmsIssueConfig.getAutoReturnRequest();
		return strAutoReturnRequest;
	}

	/**
	 * Gets the str Residual Cost for Auction.
	 * 
	 * @return the strResidualCost
	 */
	public String getStrResidualCost() {
		strResidualCost = mmsConfigGen.getResidualCostAuction();
		return strResidualCost;
	}

	/**
	 * Gets the str sample send flg.
	 * 
	 * @return the str sample send flg
	 */
	/*public String getStrSampleSendFlg() {
		strSampleSendFlg = mmsConfigGen.getStrSampleSendFlg();
		return strSampleSendFlg;
	}*/

}
