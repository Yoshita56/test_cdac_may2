package mms;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.io.File;

/*import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;*/



import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;

import mms.masters.dao.MmsConfigMstDAO;
/*import mms.masters.controller.data.MmsConfigMstDATA;
import mms.setup.MmsConfigGeneral;
import mms.setup.MmsConfigType;
import mms.setup.MmsIssueProcessType;*/

// TODO: Auto-generated Javadoc
/**
 * The Class MmsConfigUtil.
 */
public class MmsConfigUtil {


	////////////  New Code Start Here (By Adil) /////////
	
private static final String pathFileName = "hisglobal.hisconfig.hisPath";
	
	public static final String MODULE_ID = "63";

	/** The Constant UNIT_ID. */
	public static final String UNIT_ID = "6301";
	
	public static final String UNIT_ID_PATNA = "6301";

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
	/** The Constant GLOBAL_HOSPITAL_CODE. */
	public static final String GLOBAL_HOSPITAL_CODE = "100"; //Global Hospital Code
	
	public static final String INDENT_PERIOD_ANNUALY = "10";
	
	public static final String STATE_SHORT_CODE= "NIMS";
	
	private static JCS cacheVOMMSJCS ;	 	
	@SuppressWarnings("unused")
	private String strHospitalCode = "";
	private VOMms vObj = null;
	private String strTax;
	private String strSCMIntegration;

	public String getStrSCMIntegration() {
		return vObj.getStrSCMIntegration();
	}
		public String getStrTax() {
		return vObj.getStrTax();
	}
	public MmsConfigUtil(String hospitalCode)  
	{
		this.strHospitalCode = hospitalCode;		
		try
		{			
			if(cacheVOMMSJCS == null)
			{				
				cacheVOMMSJCS = JCS.getInstance( "cacheVOMMS" );
			}
							
			if(cacheVOMMSJCS.get(hospitalCode) == null )
			{				
				cacheVOMMSJCS.put( hospitalCode, new VOMms(hospitalCode) );
			}
			
			vObj = (VOMms) cacheVOMMSJCS.get(hospitalCode);			 	
			if(vObj.getStrStateCode() == null || vObj.getStrStateCode().equals("") )
				vObj.setStrStateCode("28");//Hard Coded for Andhra
				if(vObj.getStrImportedDeliveryTime() == null || vObj.getStrImportedDeliveryTime().equals("") )
					vObj.setStrImportedDeliveryTime("30");//Hard Coded for Andhra
			if(vObj.getStrIndianDeliveryTime() == null || vObj.getStrIndianDeliveryTime().equals("") )
				vObj.setStrIndianDeliveryTime("12");//Hard Coded for Andhra
			if(vObj.getStrSCMIntegration() == null || vObj.getStrSCMIntegration().equals("") )
				vObj.setStrSCMIntegration("1");//Hard Coded for Andhra
		} 
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
	}
	
	
	public void removeCacheMmsVObj(String hospitalCode)
	{
		VOMms vObj = null;
		
		vObj = (VOMms) cacheVOMMSJCS.get(hospitalCode);		
		if (vObj != null)
		{
			try 
			{
				cacheVOMMSJCS.remove(hospitalCode);
			} 
			catch (CacheException e) 
			{
					e.printStackTrace();
			}
		}	
	}
	public void reloadcacheMmsVObj(String hospitalCode)
	{
		VOMms vObj = null;
		
		vObj = (VOMms) cacheVOMMSJCS.get(hospitalCode);		
		if (vObj != null)
		{
			try 
			{
				cacheVOMMSJCS.remove(hospitalCode);//First remove from cache
				cacheVOMMSJCS.put( hospitalCode, new VOMms(hospitalCode) );
			} 
			catch (CacheException e) 
			{
					e.printStackTrace();
			}
		}
		else
		{
			try 
			{
				cacheVOMMSJCS.put( hospitalCode, new VOMms(hospitalCode) );
			} 
			catch (CacheException e) 
			{
					e.printStackTrace();
			}
		}
	}
	
	
	////////////
	/** The str financial start date. */
	private String strFinancialStartDate = "";

	/** The str financial end date. */
	private String strFinancialEndDate = "";
	/** The str Residual Cost for Auction */
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

	/** * committe File Path */
	private String strCommitteeFilePath = "";
	/** * Indian Delivery Time File Path */
	private String strIndianDeliveryTime = "";
	/** * Impotred Delivery Time File Path */
	private String strImportedDeliveryTime = "";

	/** The Constant MODULE_ID. */
	
	
	/** The str batch no. */
	public String strBatchNo = "0";

	private String strAutoReturnRequest = "";
	public String strCategoryA = "0";
	public String strCategoryB1 = "0";
	public String strCategoryB2 = "0";
	public String strCategoryC = "0";

	public String strCategoryF = "0";
	public String strCategoryN1 = "0";
	public String strCategoryN2 = "0";
	public String strCategoryS = "0";
	private String strCostReq = "0";
	private String strExpAlertDays = "0";
	private String strWinLocation = "";
	private String strLinLocation = "";
	/* Added by Amit Kumar */
	private String strStoreConfigCatg = "0";
	private String strCountryCode;
	private String strStateCode;
	private String strBillingIntegration="0";
	
	private String strTaxRate;
	
	private String strWhetherSingleItemMultiSupplier="";
	


	private String strIssueRateConfigFlg;
	private String strConfigIssueRate;
	private String strDemandActiveFlg;
	private String strDemandActivePrd;
	private String strBudgetFlg;

	private String strWithOutCrNoFlg;

	private String strCrNoDefault;

	private String strReturnDrugValidity;

	private String strDoseFrqFlg;

	private String strContractValue;
	private String strStampPaperAmt;
	

	private String strPurchaseLeadTime="";
	private String strSelfLife="";
	private String strFMSIntegration="0";
	private String strIndentLimitAmt;
	public String getStrIndentLimitAmt() {
		return vObj.getStrIndentLimitAmt();
	}
	public void setStrIndentLimitAmt(String strIndentLimitAmt) {
		this.strIndentLimitAmt = strIndentLimitAmt;
	}
	public String getStrFMSIntegration() {
		return vObj.getStrFMSIntegration();
	}
	public void setStrFMSIntegration(String strFMSIntegration) {
		this.strFMSIntegration = "0";
	}


	public static String strPODemnadValidity = "";
	///////////
	private String strTinNo;
	
	public String getStrTinNo() {
		return vObj.getStrTinNo();
	}
	public void setStrTinNo(String strTinNo) {
		this.strTinNo = strTinNo;
	}
	public static String getStrPODemnadValidity(String strHospitalCode) {
		strPODemnadValidity = MmsConfigMstDAO
				.getPODemandValidity(strHospitalCode);

		return strPODemnadValidity;
	}

	
	
	/**
	 * @return the strDoseFrqFlg
	 */
	public String getStrContractValue() {
		return vObj.getStrContractValue();
	}

	/**
	 * @return the StampPaperAmt
	 */
	public String getStampPaperAmt() {
		return vObj.getStrStampPaperAmt();
	}

	/**
	 * @return the strDoseFrqFlg
	 */
	public String getStrDoseFrqFlg() {
		return vObj.getStrDoseFrqFlg();
	}

	/**
	 * @return the strReturnDrugValidity
	 */
	public String getStrReturnDrugValidity() {
		return vObj.getStrReturnDrugValidity();
	}

	/**
	 * @return the strCrNoDefault
	 */
	public String getStrCrNoDefault() {
		return vObj.getStrCrNoDefault();
	}

	/**
	 * @return the strWithOutCrNoFlg
	 */
	public String getStrWithOutCrNoFlg() {
		return vObj.getStrWithOutCrNoFlg();
	}

	public String getStrBudgetFlg() {
		return vObj.getStrBudgetFlg();
	}

	/**
	 * @return the strDemandActivePrd
	 */
	public String getStrDemandActivePrd() {
		return vObj.getStrDemandActivePrd();
	}

	/**
	 * @return the strDemandActiveFlg
	 */
	public String getStrDemandActiveFlg() {
		return vObj.getStrDemandActiveFlg();
	}

	/**
	 * @return the strIssueRateConfigFlg
	 */
	public String getStrConfigIssueRate() {
		return vObj.getStrConfigIssueRate();
	}

	/**
	 * @return the strIssueRateConfigFlg
	 */
	public String getStrIssueRateConfigFlg() {
		return vObj.getStrIssueRateConfigFlg();
	}

	/**
	 * @return the strStateCode
	 */
	public String getStrStateCode() {
		return vObj.getStrStateCode();
	}

	/**
	 * @return the strConfigCatg
	 */
	public String getStrCountryCode() {
		return vObj.getStrCountryCode();
	}

	/**
	 * @return the strConfigCatg
	 */
	public String getStrStoreConfigCatg() {
		return vObj.getStrStoreConfigCatg();
	}

	public String getStrWinLocation() {
		return vObj.getStrWinLocation();
	}

	public String getStrLinLocation() {
		return vObj.getStrLinLocation();
	}

	/**
	 * @return the strExpAlertDays
	 */
	public String getStrExpAlertDays() {
		return vObj.getStrExpAlertDays();
	}

	/**
	 * @return the strCostReq
	 */
	public String getStrCostReq() {
		return vObj.getStrCostReq();
	}

	/**
	 * Gets the str batch no.
	 * 
	 * @return the str batch no
	 * 
	 * @throws Exception
	 *             the exception
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

		strFinancialStartDate = MmsConfigMstDAO.getDateDetails(strStoreId,
				strHospitalCode).replace("^", "#").split("#")[0];

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

		strFinancialEndDate = MmsConfigMstDAO.getDateDetails(strStoreId,strHospitalCode).replace("^", "#").split("#")[1];

		return strFinancialEndDate;
	}

	/**
	 * common method for creating a XML Root Elements Data Object.
	 * 
	 * @return JAXBElement Object
	 */
	
		
	/*@SuppressWarnings("unchecked")
	private JAXBElement<MmsConfigType> readXMLDataObject() {

		JAXBElement<MmsConfigType> jaxB = null;
		JAXBContext jc = null;
		Unmarshaller u = null;
//		FileInputStream fs = null;
		
		//System.out.println("jaxb==>called");
		
		
		try {
			jaxB = MmsConfigMstDATA.gblJaxB;

			if(jaxB == null)
			{
				jc = JAXBContext.newInstance("mms.setup");
				u = jc.createUnmarshaller();
			// fs = new
			// FileInputStream(HisUtil.getParameterFromHisPathXML("MMS_CONFIG"));
	
				jaxB = (JAXBElement<MmsConfigType>) u.unmarshal(new File(HisUtil.getParameterFromHisPathXML("MMS_CONFIG")));
				MmsConfigMstDATA.gblJaxB = jaxB;
				
				//System.out.println("jaxb :: "+MmsConfigMstDATA.gblJaxB);
				
				
				
			}

		} catch (Exception e) {

			new HisException("Mms Configuration", "mms.MmsConfigUtil",
					"MmsConfigUtil.readXMLDataObject() -->" + e.getMessage());

		}
		finally {
			jc = null;
			u = null;
			
			
			 * try { if(fs != null) { fs.close(); fs = null; } }catch(Exception
			 * e1){}
			 
		 }
		return jaxB;

	}*/

	


	/**
	 * Gets the str issue mode.
	 * 
	 * @return the str issue mode
	 */
	public String getStrIssueMode() {
		return vObj.getStrIssueMode();
	}

	/**
	 * Gets the str last issue patient staff in days.
	 * 
	 * @return the str last issue patient staff in days
	 */
	public String getStrLastIssuePatientStaffInDays() {
		return vObj.getStrLastIssuePatientStaffInDays();
	}

	/**
	 * Gets the str last issue employee in days.
	 * 
	 * @return the str last issue employee in days
	 */
	public String getStrLastIssueEmployeeInDays() {
		return vObj.getStrLastIssueEmployeeInDays();
	}

	/**
	 * Gets the str online issue details in days.
	 * 
	 * @return the str online issue details in days
	 */
	public String getStrOnlineIssueDetailsInDays() {
		return vObj.getStrOnlineIssueDetailsInDays();
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
			strPeriodId = MmsConfigMstDAO.getPeriodId(strStoreId,strItemCatCode, strHospitalCode);
		} catch (Exception e) {

			throw e;
		}

		return strPeriodId;
	}

	/*public static String getMODULE_ID() {
		return MODULE_ID;
	}

	public static String getUNIT_ID() {
		return UNIT_ID;
	}

	public static String getSTAFF_CAT_CODE() {
		return STAFF_CAT_CODE;
	}

	public static String getPHY_STOCK_ITEM_PER_PAGE() {
		return PHY_STOCK_ITEM_PER_PAGE;
	}

	public static String getDEFAULT_CURRENCY_CODE() {
		return DEFAULT_CURRENCY_CODE;
	}

	public static String getSUPPLIER_BILL() {
		return SUPPLIER_BILL;
	}*/

	public String getStrCategoryA() throws Exception {

		return vObj.getStrCategoryA();
	}

	public String getStrCategoryB1() throws Exception {

		return vObj.getStrCategoryB1();
	}

	public String getStrCategoryB2() throws Exception {

		return vObj.getStrCategoryB2();
	}

	public String getStrCCategory() throws Exception {

		return vObj.getStrCategoryC();
	}

	public String getStrFCategory() throws Exception {

		return vObj.getStrCategoryF();
	}
	public String getStrCategoryF() throws Exception {

		return vObj.getStrCategoryF();
	}

	public String getStrCategoryN1() throws Exception {

		return vObj.getStrCategoryN1();
	}

	public String getStrCategoryN2() throws Exception {

		return vObj.getStrCategoryN2();
	}

	public String getStrCategoryS() throws Exception {

		return vObj.getStrCategoryS();
	}
	public String getStrSCategory() throws Exception {

		return vObj.getStrCategoryS();
	}

	/**
	 * 
	 * @return
	 */
	public String getStrCommitteeFilePath() {
		return vObj.getStrCommitteeFilePath();
	}

	/**
	 * @return the strIndianDeliveryTime
	 */
	public String getStrIndianDeliveryTime() {
		return vObj.getStrIndianDeliveryTime();
	}

	/**
	 * @return the strImportedDeliveryTime
	 */
	public String getStrImportedDeliveryTime() {
		return vObj.getStrImportedDeliveryTime();
	}

	/**
	 * @return the strAutoReturnRequest
	 */
	public String getStrAutoReturnRequest() {
		return vObj.getStrAutoReturnRequest();
	}

	/**
	 * @return the strResidualCost
	 */
	public String getStrResidualCost() {
		return vObj.getStrResidualCost();
	}
	
	
	
	
	public String getStrBillingIntegration() {
		 return vObj.getStrBillingIntegration();
	}


	public String getStrTaxRate() {
		return vObj.getStrTaxRate();
	}


	public String getStrWhetherSingleItemMultiSupplier() {
		return vObj.getStrWhetherSingleItemMultiSupplier();
	}
	
	
	public String getStrPurchaseLeadTime() {
		return vObj.getStrPurchaseLeadTime();
	}
	
	public String getStrSelfLife() {
		return vObj.getStrSelfLife();
	}
}
