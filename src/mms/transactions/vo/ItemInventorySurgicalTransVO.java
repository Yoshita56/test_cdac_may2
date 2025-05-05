/**
 * 
 */
package mms.transactions.vo;

import hisglobal.utility.TransferObject;

import javax.sql.rowset.WebRowSet;

/**
 * @author pankaj
 *
 */
public class ItemInventorySurgicalTransVO implements TransferObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Boolean BExistStatus = false;
	private String strMsgString = "";
	private String strMsgType = "";
	private String strCtDate = "";
	private String strBillNo="";
	private String strBillDate="";
	private String strModifyValue = "0";
	
	private String strFinancialStartYear = "";
	private String strFinancialEndYear = "";
	
	
	private String strEffectiveFrom = "";
	private String strHospitalCode = "";
	private String strSeatId = "";

	private String strManufactureId = "";
	private String strManufactureName = "";
	private String strManufactureCombo = "";
	private WebRowSet strManufactureComboWS = null;

	private String strSuppliedBy = "0";

	private WebRowSet strItemBrandComboWS = null;
	private String strItemBrandCombo = "";
	private String strItemBrandName = "";
	private String strItemBrandId = "";

	private String strItemNameCombo = "";
	private WebRowSet strItemNameComboWS = null;
	private String strItemName = "";
	private String strItemId = "";

	private String strInHandQuantity = "";
	private String strInHandQuantityUnitID = "";
	private String strInHandQuantityUnitName = "";
	private String strBatchNo = "";
	private String strExpiryDate = "";
	private String strManufactureDate = "";
	private String strRate = "";
	private String strSalePrice = "";

	private String strCurrencyCode = "0";
	private WebRowSet strCurrencyCodeWs = null;
	private String strCurrencyValue = "0";

	private String strPoNo = "";
	private String strPoDate = "";
	private String strReceivedDate = "";

	private String strStockStatus = "";
	private String strOldStockStatus = "";
	private WebRowSet strStockStatusWs = null;
	private String strModuleId = "0";
	private String strConsumable_flag = "";

	private WebRowSet strUnitNameComboWS = null;
	private String strUnitNameCombo = "";

	private String strStoreId = "";
	private String strStoreName = "";
	private String strGroupId = "";
	private String strGroupName = "";

	private String strSubGroupId = "";
	private String strSubGroupCombo = "";
	private WebRowSet strSubGroupComboWs = null;
	private String strSubGroupCode = "";
	private String strSubGroupName = "";
	private String strItemCategoryNo = "";
	private String strFreeItemFlag;
	private String strItemSpecification = "";
	
	private String strRegFlag = "";
	private String strBrandDetails = "";
	
	private String strFreeItemQuantity="0";
	private String strFreeItemQuantityUnitID="0";
	private String strConfigIssueRate;
	private String strIssueRateConfigFlg;
		
	public String getStrIssueRateConfigFlg() {
		return strIssueRateConfigFlg;
	}

	public void setStrIssueRateConfigFlg(String strIssueRateConfigFlg) {
		this.strIssueRateConfigFlg = strIssueRateConfigFlg;
	}

	public String getStrConfigIssueRate() {
		return strConfigIssueRate;
	}

	public void setStrConfigIssueRate(String strConfigIssueRate) {
		this.strConfigIssueRate = strConfigIssueRate;
	}

	public String getStrFreeItemQuantity() {
		return strFreeItemQuantity;
	}

	public void setStrFreeItemQuantity(String strFreeItemQuantity) {
		this.strFreeItemQuantity = strFreeItemQuantity;
	}

	public String getStrFreeItemQuantityUnitID() {
		return strFreeItemQuantityUnitID;
	}

	public void setStrFreeItemQuantityUnitID(String strFreeItemQuantityUnitID) {
		this.strFreeItemQuantityUnitID = strFreeItemQuantityUnitID;
	}

	public String getStrBrandDetails() {
		return strBrandDetails;
	}

	public void setStrBrandDetails(String strBrandDetails) {
		this.strBrandDetails = strBrandDetails;
	}

	public String getStrRegFlag() {
		return strRegFlag;
	}

	public void setStrRegFlag(String strRegFlag) {
		this.strRegFlag = strRegFlag;
	}

	public String getStrOldStockStatus() {
		return strOldStockStatus;
	}

	public void setStrOldStockStatus(String strOldStockStatus) {
		this.strOldStockStatus = strOldStockStatus;
	}

	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}

	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}

	private String strUnitRateID = "";
	private String strUnitRateName = "";
	private String strUnitRateCombo = "";
	private WebRowSet strUnitRateComboWS = null;

	private String strUnitSaleID = "";
	private String strUnitNameSale = "";
	private String strUnitSaleCombo = "";
	private WebRowSet strUnitSaleComboWS = null;
	
	private String[] strItemOtherDtls = null;
		
	private String[] strItemPartDtls = null;
	private String[] strItemParamDtls = null;
	
	
	private String strWarrantyFlag = "0";
	
	
	private String strIsWarrantyDetails = "0";
	private String strWarrantyDate = "";
	private String strWarantyManufacturer = "";
	private String strWarrantyUpTo = "";
	private String strWarrantyUpToUnit = "0";
	private String strWarrantyRemarks = "";
	
	private WebRowSet strWarrantyManufactureComboWS = null;
	
	private String strInstallFlag = "0";
	
	private String strIsInstallDetails = "0";
	private String strInstallStartDate = "";
	private String strInstallEndDate = "";
	private String strInstallStatus = "0";
	private String strInstallBy = "";
	private String strInstallerContactNo = "";
	private String strInstallRemarks = "";
	
	private String[] strParamCheck = null;
	private String[] strParamValue = null;
	private String[] strParamDtls = null;
	private String[] strParamStatus = null;
	
	
	public String[] getStrParamDtls() {
		return strParamDtls;
	}

	public void setStrParamDtls(String[] strParamDtls) {
		this.strParamDtls = strParamDtls;
	}

	public String[] getStrParamStatus() {
		return strParamStatus;
	}

	public void setStrParamStatus(String[] strParamStatus) {
		this.strParamStatus = strParamStatus;
	}

	public String[] getStrParamCheck() {
		return strParamCheck;
	}

	public void setStrParamCheck(String[] strParamCheck) {
		this.strParamCheck = strParamCheck;
	}

	public String[] getStrParamValue() {
		return strParamValue;
	}

	public void setStrParamValue(String[] strParamValue) {
		this.strParamValue = strParamValue;
	}
	
	public String getStrInstallStartDate() {
		return strInstallStartDate;
	}

	public void setStrInstallStartDate(String strInstallStartDate) {
		this.strInstallStartDate = strInstallStartDate;
	}

	public String getStrInstallEndDate() {
		return strInstallEndDate;
	}

	public void setStrInstallEndDate(String strInstallEndDate) {
		this.strInstallEndDate = strInstallEndDate;
	}

	public String getStrInstallStatus() {
		return strInstallStatus;
	}

	public void setStrInstallStatus(String strInstallStatus) {
		this.strInstallStatus = strInstallStatus;
	}

	public String getStrInstallBy() {
		return strInstallBy;
	}

	public void setStrInstallBy(String strInstallBy) {
		this.strInstallBy = strInstallBy;
	}

	public String getStrInstallerContactNo() {
		return strInstallerContactNo;
	}

	public void setStrInstallerContactNo(String strInstallerContactNo) {
		this.strInstallerContactNo = strInstallerContactNo;
	}

	public String getStrInstallRemarks() {
		return strInstallRemarks;
	}

	public void setStrInstallRemarks(String strInstallRemarks) {
		this.strInstallRemarks = strInstallRemarks;
	}
	
	
	private String strSerialNo = "0";
	
	public String getStrSerialNo() {
		return strSerialNo;
	}

	public void setStrSerialNo(String strSerialNo) {
		this.strSerialNo = strSerialNo;
	}

	public String[] getStrItemParamDtls() {
		return strItemParamDtls;
	}

	public void setStrItemParamDtls(String[] strItemParamDtls) {
		this.strItemParamDtls = strItemParamDtls;
	}

	public String[] getStrItemPartDtls() {
		return strItemPartDtls;
	}

	public void setStrItemPartDtls(String[] strItemPartDtls) {
		this.strItemPartDtls = strItemPartDtls;
	}

	
	public String getStrWarrantyFlag() {
		return strWarrantyFlag;
	}

	public void setStrWarrantyFlag(String strWarrantyFlag) {
		this.strWarrantyFlag = strWarrantyFlag;
	}

	public String getStrIsWarrantyDetails() {
		return strIsWarrantyDetails;
	}

	public void setStrIsWarrantyDetails(String strIsWarrantyDetails) {
		this.strIsWarrantyDetails = strIsWarrantyDetails;
	}

	public String getStrWarrantyDate() {
		return strWarrantyDate;
	}

	public void setStrWarrantyDate(String strWarrantyDate) {
		this.strWarrantyDate = strWarrantyDate;
	}

	public String getStrWarantyManufacturer() {
		return strWarantyManufacturer;
	}

	public void setStrWarantyManufacturer(String strWarantyManufacturer) {
		this.strWarantyManufacturer = strWarantyManufacturer;
	}

	public String getStrWarrantyUpTo() {
		return strWarrantyUpTo;
	}

	public void setStrWarrantyUpTo(String strWarrantyUpTo) {
		this.strWarrantyUpTo = strWarrantyUpTo;
	}

	public String getStrWarrantyUpToUnit() {
		return strWarrantyUpToUnit;
	}

	public void setStrWarrantyUpToUnit(String strWarrantyUpToUnit) {
		this.strWarrantyUpToUnit = strWarrantyUpToUnit;
	}

	public String getStrWarrantyRemarks() {
		return strWarrantyRemarks;
	}

	public void setStrWarrantyRemarks(String strWarrantyRemarks) {
		this.strWarrantyRemarks = strWarrantyRemarks;
	}

	public String getStrInstallFlag() {
		return strInstallFlag;
	}

	public void setStrInstallFlag(String strInstallFlag) {
		this.strInstallFlag = strInstallFlag;
	}

	public String[] getStrItemOtherDtls() {
		return strItemOtherDtls;
	}

	public void setStrItemOtherDtls(String[] strItemOtherDtls) {
		this.strItemOtherDtls = strItemOtherDtls;
	}

	public String getStrCurrencyCode() {
		return strCurrencyCode;
	}

	public void setStrCurrencyCode(String strCurrencyCode) {
		this.strCurrencyCode = strCurrencyCode;
	}

	public WebRowSet getStrCurrencyCodeWs() {
		return strCurrencyCodeWs;
	}

	public void setStrCurrencyCodeWs(WebRowSet strCurrencyCodeWs) {
		this.strCurrencyCodeWs = strCurrencyCodeWs;
	}

	public String getStrCurrencyValue() {
		return strCurrencyValue;
	}

	public void setStrCurrencyValue(String strCurrencyValue) {
		this.strCurrencyValue = strCurrencyValue;
	}

	public WebRowSet getStrStockStatusWs() {
		return strStockStatusWs;
	}

	public void setStrStockStatusWs(WebRowSet strStockStatusWs) {
		this.strStockStatusWs = strStockStatusWs;
	}

	public String getStrStockStatus() {
		return strStockStatus;
	}

	public void setStrStockStatus(String strStockStatus) {
		this.strStockStatus = strStockStatus;
	}

	public String getStrPoDate() {
		return strPoDate;
	}

	public void setStrPoDate(String strPoDate) {
		this.strPoDate = strPoDate;
	}

	public String getStrReceivedDate() {
		return strReceivedDate;
	}

	public void setStrReceivedDate(String strReceivedDate) {
		this.strReceivedDate = strReceivedDate;
	}

	public String getStrSuppliedBy() {
		return strSuppliedBy;
	}

	public void setStrSuppliedBy(String strSuppliedBy) {
		this.strSuppliedBy = strSuppliedBy;
	}

	/**
	 * @return the strEffectiveFrom
	 */
	public String getStrEffectiveFrom() {
		return strEffectiveFrom;
	}

	/**
	 * @param strEffectiveFrom
	 *            the strEffectiveFrom to set
	 */
	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
	}

	/**
	 * @return the strHospitalCode
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	/**
	 * @param strHospitalCode
	 *            the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * @return the strSeatId
	 */
	public String getStrSeatId() {
		return strSeatId;
	}

	/**
	 * @param strSeatId
	 *            the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * @return the strConsumable_flag
	 */
	public String getStrConsumable_flag() {
		return strConsumable_flag;
	}

	/**
	 * @param strConsumable_flag
	 *            the strConsumable_flag to set
	 */
	public void setStrConsumable_flag(String strConsumable_flag) {
		this.strConsumable_flag = strConsumable_flag;
	}

	/**
	 * @return the strMsgString
	 */
	public String getStrMsgString() {
		return strMsgString;
	}

	/**
	 * @param strMsgString
	 *            the strMsgString to set
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	/**
	 * @return the strMsgType
	 */
	public String getStrMsgType() {
		return strMsgType;
	}

	/**
	 * @param strMsgType
	 *            the strMsgType to set
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	/**
	 * @return the strSubGroupCombo
	 */
	public String getStrSubGroupCombo() {
		return strSubGroupCombo;
	}

	/**
	 * @param strSubGroupCombo
	 *            the strSubGroupCombo to set
	 */
	public void setStrSubGroupCombo(String strSubGroupCombo) {
		this.strSubGroupCombo = strSubGroupCombo;
	}

	/**
	 * @return the strCtDate
	 */
	public String getStrCtDate() {
		return strCtDate;
	}

	/**
	 * @param strCtDate
	 *            the strCtDate to set
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}

	/**
	 * @return the bExistStatus
	 */
	public Boolean getBExistStatus() {
		return BExistStatus;
	}

	/**
	 * @param existStatus
	 *            the bExistStatus to set
	 */
	public void setBExistStatus(Boolean existStatus) {
		BExistStatus = existStatus;
	}

	/**
	 * @return the strSubGroupComboWs
	 */
	public WebRowSet getStrSubGroupComboWs() {
		return strSubGroupComboWs;
	}

	/**
	 * @param strSubGroupComboWs
	 *            the strSubGroupComboWs to set
	 */
	public void setStrSubGroupComboWs(WebRowSet strSubGroupComboWs) {
		this.strSubGroupComboWs = strSubGroupComboWs;
	}

	/**
	 * @return the strSubGroupCode
	 */
	public String getStrSubGroupCode() {
		return strSubGroupCode;
	}

	/**
	 * @param strSubGroupCode
	 *            the strSubGroupCode to set
	 */
	public void setStrSubGroupCode(String strSubGroupCode) {
		this.strSubGroupCode = strSubGroupCode;
	}

	/**
	 * @return the strGroupId
	 */
	public String getStrGroupId() {
		return strGroupId;
	}

	/**
	 * @param strGroupId
	 *            the strGroupId to set
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * @return the strGroupName
	 */
	public String getStrGroupName() {
		return strGroupName;
	}

	/**
	 * @param strGroupName
	 *            the strGroupName to set
	 */
	public void setStrGroupName(String strGroupName) {
		this.strGroupName = strGroupName;
	}

	public String getStrStoreId() {
		return strStoreId;
	}

	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	public String getStrStoreName() {
		return strStoreName;
	}

	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}

	public String getStrSubGroupId() {
		return strSubGroupId;
	}

	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}

	public String getStrItemNameCombo() {
		return strItemNameCombo;
	}

	public void setStrItemNameCombo(String strItemNameCombo) {
		this.strItemNameCombo = strItemNameCombo;
	}

	public WebRowSet getStrItemNameComboWS() {
		return strItemNameComboWS;
	}

	public void setStrItemNameComboWS(WebRowSet strItemNameComboWS) {
		this.strItemNameComboWS = strItemNameComboWS;
	}

	public String getStrItemName() {
		return strItemName;
	}

	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}

	public String getStrItemId() {
		return strItemId;
	}

	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	public WebRowSet getStrItemBrandComboWS() {
		return strItemBrandComboWS;
	}

	public void setStrItemBrandComboWS(WebRowSet strItemBrandComboWS) {
		this.strItemBrandComboWS = strItemBrandComboWS;
	}

	public String getStrItemBrandCombo() {
		return strItemBrandCombo;
	}

	public void setStrItemBrandCombo(String strItemBrandCombo) {
		this.strItemBrandCombo = strItemBrandCombo;
	}

	public String getStrItemBrandName() {
		return strItemBrandName;
	}

	public void setStrItemBrandName(String strItemBrandName) {
		this.strItemBrandName = strItemBrandName;
	}

	public String getStrItemBrandId() {
		return strItemBrandId;
	}

	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}

	public String getStrBatchNo() {
		return strBatchNo;
	}

	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}

	public String getStrExpiryDate() {
		return strExpiryDate;
	}

	public void setStrExpiryDate(String strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
	}

	public String getStrManufactureDate() {
		return strManufactureDate;
	}

	public void setStrManufactureDate(String strManufactureDate) {
		this.strManufactureDate = strManufactureDate;
	}

	/**
	 * @return the strRate
	 */
	public String getStrRate() {
		return strRate;
	}

	/**
	 * @param strRate
	 *            the strRate to set
	 */
	public void setStrRate(String strRate) {
		this.strRate = strRate;
	}

	public String getStrPoNo() {
		return strPoNo;
	}

	public void setStrPoNo(String strPoNo) {
		this.strPoNo = strPoNo;
	}

	/**
	 * @return the strSalePrice
	 */
	public String getStrSalePrice() {
		return strSalePrice;
	}

	/**
	 * @param strSalePrice
	 *            the strSalePrice to set
	 */
	public void setStrSalePrice(String strSalePrice) {
		this.strSalePrice = strSalePrice;
	}

	public String getStrManufactureId() {
		return strManufactureId;
	}

	public void setStrManufactureId(String strManufactureId) {
		this.strManufactureId = strManufactureId;
	}

	public String getStrManufactureName() {
		return strManufactureName;
	}

	public void setStrManufactureName(String strManufactureName) {
		this.strManufactureName = strManufactureName;
	}

	public String getStrManufactureCombo() {
		return strManufactureCombo;
	}

	public void setStrManufactureCombo(String strManufactureCombo) {
		this.strManufactureCombo = strManufactureCombo;
	}

	public WebRowSet getStrManufactureComboWS() {
		return strManufactureComboWS;
	}

	public void setStrManufactureComboWS(WebRowSet strManufactureComboWS) {
		this.strManufactureComboWS = strManufactureComboWS;
	}

	public WebRowSet getStrUnitNameComboWS() {
		return strUnitNameComboWS;
	}

	public void setStrUnitNameComboWS(WebRowSet strUnitNameComboWS) {
		this.strUnitNameComboWS = strUnitNameComboWS;
	}

	public String getStrUnitNameCombo() {
		return strUnitNameCombo;
	}

	public void setStrUnitNameCombo(String strUnitNameCombo) {
		this.strUnitNameCombo = strUnitNameCombo;
	}

	public String getStrModuleId() {
		return strModuleId;
	}

	public void setStrModuleId(String strModuleId) {
		this.strModuleId = strModuleId;
	}

	/**
	 * @return the strInHandQuantity
	 */
	public String getStrInHandQuantity() {
		return strInHandQuantity;
	}

	/**
	 * @param strInHandQuantity
	 *            the strInHandQuantity to set
	 */
	public void setStrInHandQuantity(String strInHandQuantity) {
		this.strInHandQuantity = strInHandQuantity;
	}

	/**
	 * @return the strInHandQuantityUnitID
	 */
	public String getStrInHandQuantityUnitID() {
		return strInHandQuantityUnitID;
	}

	/**
	 * @param strInHandQuantityUnitID
	 *            the strInHandQuantityUnitID to set
	 */
	public void setStrInHandQuantityUnitID(String strInHandQuantityUnitID) {
		this.strInHandQuantityUnitID = strInHandQuantityUnitID;
	}

	/**
	 * @return the strSubGroupName
	 */
	public String getStrSubGroupName() {
		return strSubGroupName;
	}

	/**
	 * @param strSubGroupName
	 *            the strSubGroupName to set
	 */
	public void setStrSubGroupName(String strSubGroupName) {
		this.strSubGroupName = strSubGroupName;
	}

	/**
	 * @return the strUnitRateID
	 */
	public String getStrUnitRateID() {
		return strUnitRateID;
	}

	/**
	 * @param strUnitRateID
	 *            the strUnitRateID to set
	 */
	public void setStrUnitRateID(String strUnitRateID) {
		this.strUnitRateID = strUnitRateID;
	}

	/**
	 * @return the strUnitRateName
	 */
	public String getStrUnitRateName() {
		return strUnitRateName;
	}

	/**
	 * @param strUnitRateName
	 *            the strUnitRateName to set
	 */
	public void setStrUnitRateName(String strUnitRateName) {
		this.strUnitRateName = strUnitRateName;
	}

	/**
	 * @return the strUnitRateCombo
	 */
	public String getStrUnitRateCombo() {
		return strUnitRateCombo;
	}

	/**
	 * @param strUnitRateCombo
	 *            the strUnitRateCombo to set
	 */
	public void setStrUnitRateCombo(String strUnitRateCombo) {
		this.strUnitRateCombo = strUnitRateCombo;
	}

	/**
	 * @return the strUnitRateComboWS
	 */
	public WebRowSet getStrUnitRateComboWS() {
		return strUnitRateComboWS;
	}

	/**
	 * @param strUnitRateComboWS
	 *            the strUnitRateComboWS to set
	 */
	public void setStrUnitRateComboWS(WebRowSet strUnitRateComboWS) {
		this.strUnitRateComboWS = strUnitRateComboWS;
	}

	/**
	 * @return the strUnitSaleID
	 */
	public String getStrUnitSaleID() {
		return strUnitSaleID;
	}

	/**
	 * @param strUnitSaleID
	 *            the strUnitSaleID to set
	 */
	public void setStrUnitSaleID(String strUnitSaleID) {
		this.strUnitSaleID = strUnitSaleID;
	}

	/**
	 * @return the strUnitNameSale
	 */
	public String getStrUnitNameSale() {
		return strUnitNameSale;
	}

	/**
	 * @param strUnitNameSale
	 *            the strUnitNameSale to set
	 */
	public void setStrUnitNameSale(String strUnitNameSale) {
		this.strUnitNameSale = strUnitNameSale;
	}

	/**
	 * @return the strUnitSaleCombo
	 */
	public String getStrUnitSaleCombo() {
		return strUnitSaleCombo;
	}

	/**
	 * @param strUnitSaleCombo
	 *            the strUnitSaleCombo to set
	 */
	public void setStrUnitSaleCombo(String strUnitSaleCombo) {
		this.strUnitSaleCombo = strUnitSaleCombo;
	}

	/**
	 * @return the strUnitSaleComboWS
	 */
	public WebRowSet getStrUnitSaleComboWS() {
		return strUnitSaleComboWS;
	}

	/**
	 * @param strUnitSaleComboWS
	 *            the strUnitSaleComboWS to set
	 */
	public void setStrUnitSaleComboWS(WebRowSet strUnitSaleComboWS) {
		this.strUnitSaleComboWS = strUnitSaleComboWS;
	}

	/**
	 * @return the strInHandQuantityUnitName
	 */
	public String getStrInHandQuantityUnitName() {
		return strInHandQuantityUnitName;
	}

	/**
	 * @param strInHandQuantityUnitName
	 *            the strInHandQuantityUnitName to set
	 */
	public void setStrInHandQuantityUnitName(String strInHandQuantityUnitName) {
		this.strInHandQuantityUnitName = strInHandQuantityUnitName;
	}

	public String getStrFinancialStartYear() {
		return strFinancialStartYear;
	}

	public void setStrFinancialStartYear(String strFinancialStartYear) {
		this.strFinancialStartYear = strFinancialStartYear;
	}

	public String getStrFinancialEndYear() {
		return strFinancialEndYear;
	}

	public void setStrFinancialEndYear(String strFinancialEndYear) {
		this.strFinancialEndYear = strFinancialEndYear;
	}

	public WebRowSet getStrWarrantyManufactureComboWS() {
		return strWarrantyManufactureComboWS;
	}

	public void setStrWarrantyManufactureComboWS(
			WebRowSet strWarrantyManufactureComboWS) {
		this.strWarrantyManufactureComboWS = strWarrantyManufactureComboWS;
	}

	public String getStrIsInstallDetails() {
		return strIsInstallDetails;
	}

	public void setStrIsInstallDetails(String strIsInstallDetails) {
		this.strIsInstallDetails = strIsInstallDetails;
	}

	public String getStrModifyValue() {
		return strModifyValue;
	}

	public void setStrModifyValue(String strModifyValue) {
		this.strModifyValue = strModifyValue;
	}

	/**
	 * @return the strBillNo
	 */
	public String getStrBillNo() {
		return strBillNo;
	}

	/**
	 * @param strBillNo the strBillNo to set
	 */
	public void setStrBillNo(String strBillNo) {
		this.strBillNo = strBillNo;
	}

	/**
	 * @return the strBillDate
	 */
	public String getStrBillDate() {
		return strBillDate;
	}

	/**
	 * @param strBillDate the strBillDate to set
	 */
	public void setStrBillDate(String strBillDate) {
		this.strBillDate = strBillDate;
	}

	public String getStrItemSpecification() {
		return strItemSpecification;
	}

	public void setStrItemSpecification(String strItemSpecification) {
		this.strItemSpecification = strItemSpecification;
	}

	public String getStrFreeItemFlag() {
		return strFreeItemFlag;
	}

	public void setStrFreeItemFlag(String strFreeItemFlag) {
		this.strFreeItemFlag = strFreeItemFlag;
	}

}
