package mms.transactions.controller.fb;

import hisglobal.transactionutil.GenericFormBean;

public class DrugInventoryTransFB extends GenericFormBean {

	private static final long serialVersionUID = 02L;

	private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
	private String strCtDate = "";

	private String strEffectiveFrom = "";
	private String strManufactureId = "";
	private String strManufactureName = "";
	private String strManufactureCombo = "";
	
	private String strBillNo="";
	private String strBillDate="";

	private String strSuppliedBy = "0";
	private String strSuppliedByValues = "";

	private String strUnitRateID = "";
	private String strUnitRateName = "";
	private String strUnitRateCombo = "";

	private String strUnitSaleID = "";
	private String strUnitSaleName = "";
	private String strUnitSaleCombo = "";

	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strStoreId = "";
	private String strStoreName = "";

	private String strGroupId = "";
	private String strGroupName = "";
	private String strItemNameCombo = "";

	private String strItemName = "";
	private String strItemId = "";

	private String strBatchNo ;
	private String strExpiryDate = "";
	private String strManufactureDate = "";
	private String strRate = "";
	private String strSalePrice = "";

	private String strPoNo = "";
	private String strPoDate = "";
	private String strReceivedDate = "";

	
	private String strCurrencyCode = "0";
	private String strCurrencyCodeValues = "";
	private String strCurrencyValue = "1";
	private String strDefaultCurrencyCode = "0";
	
	private String strIssueRateConfigFlg;
	
	private String strInHandQuantityUnitValues = "";
	private String strRateUnitValues = "";
	private String strSalesRateUnitValues = "";
	
	private String strStockStatus = "";
	private String strOldStockStatus = "";
	
	private String strStockStatusValues = "";
	private String strUnitId = "0";
	private String strUnitName = "";
	private String strModuleId = "0";
	private String strUnitNameCombo = "";

	private String strUnitCombo = "";
	private String strInHandQuantity = "";
	private String strInHandQuantityUnitID = "";

	private String strItemBrandCombo = "";
	private String strItemBrandName = "";
	private String strItemBrandId = "";
	private String strItemCategoryNo = "";
	private String strSubGroupCombo = "";

	private String strSubGroupCode = "";
	private String strSubGroupName = "";
	private String strUnitIdSale = "0";
	private String strUnitNameSale = "";
	private String strUnitNameComboSale = "";

	private String strChk = "";
	private String strUnitComboSale = "";
	private String strSubGroupId = "";
	private String strInHandQuantityUnitName = "";
	
	private String strItemSpecification;
	private String strRegFlag = "";
	private String strConfigIssueRate;
	
	private String[] strItemOtherDtls = null;
	private String strFreeItemFlag;	
	
	private String strFreeItemQuantity="0";
	private String strFreeItemQuantityUnitID="0";
	private String strRackNumber;
	private String strExistingBatchId;

	private String strExistingBatchCombo;
	private String strExistingBatchFlg;
	private String strExistingBatchDetails;
	private String strGroupNameCombo;
	private String strGroupCmbId;
	private String strBatchExistInStockFlg;
	private String strQcTypeFlg;
	private String strDrugTotCost;
	private String strItemBrandIdValue;
	
	private String strActiveQty;
	private String strInActiveQty;
	private String strQuarantineQty;
	
	public String getStrItemBrandIdValue() {
		return strItemBrandIdValue;
	}

	public void setStrItemBrandIdValue(String strItemBrandIdValue) {
		this.strItemBrandIdValue = strItemBrandIdValue;
	}

	public String getStrDrugTotCost() {
		return strDrugTotCost;
	}

	public void setStrDrugTotCost(String strDrugTotCost) {
		this.strDrugTotCost = strDrugTotCost;
	}

	public String getStrQcTypeFlg() {
		return strQcTypeFlg;
	}

	public void setStrQcTypeFlg(String strQcTypeFlg) {
		this.strQcTypeFlg = strQcTypeFlg;
	}

	public String getStrBatchExistInStockFlg() {
		return strBatchExistInStockFlg;
	}

	public void setStrBatchExistInStockFlg(String strBatchExistInStockFlg) {
		this.strBatchExistInStockFlg = strBatchExistInStockFlg;
	}

	public String getStrGroupCmbId() {
		return strGroupCmbId;
	}

	public void setStrGroupCmbId(String strGroupCmbId) {
		this.strGroupCmbId = strGroupCmbId;
	}

	public String getStrGroupNameCombo() {
		return strGroupNameCombo;
	}

	public void setStrGroupNameCombo(String strGroupNameCombo) {
		this.strGroupNameCombo = strGroupNameCombo;
	}

	public String getStrExistingBatchDetails() {
		return strExistingBatchDetails;
	}

	public void setStrExistingBatchDetails(String strExistingBatchDetails) {
		this.strExistingBatchDetails = strExistingBatchDetails;
	}

	public String getStrExistingBatchFlg() {
		return strExistingBatchFlg;
	}

	public void setStrExistingBatchFlg(String strExistingBatchFlg) {
		this.strExistingBatchFlg = strExistingBatchFlg;
	}

	public String getStrRackNumber() {
		return strRackNumber;
	}

	public void setStrRackNumber(String strRackNumber) {
		this.strRackNumber = strRackNumber;
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

	public String getStrFreeItemFlag() {
		return strFreeItemFlag;
	}

	public void setStrFreeItemFlag(String strFreeItemFlag) {
		this.strFreeItemFlag = strFreeItemFlag;
	}

	public String[] getStrItemOtherDtls() {
		return strItemOtherDtls;
	}

	public void setStrItemOtherDtls(String[] strItemOtherDtls) {
		this.strItemOtherDtls = strItemOtherDtls;
	}

	
	public String getStrOldStockStatus() {
		return strOldStockStatus;
	}

	public void setStrOldStockStatus(String strOldStockStatus) {
		this.strOldStockStatus = strOldStockStatus;
	}

	public String getStrInHandQuantityUnitValues() {
		return strInHandQuantityUnitValues;
	}

	public void setStrInHandQuantityUnitValues(String strInHandQuantityUnitValues) {
		this.strInHandQuantityUnitValues = strInHandQuantityUnitValues;
	}

	public String getStrRateUnitValues() {
		return strRateUnitValues;
	}

	public void setStrRateUnitValues(String strRateUnitValues) {
		this.strRateUnitValues = strRateUnitValues;
	}

	public String getStrSalesRateUnitValues() {
		return strSalesRateUnitValues;
	}

	public void setStrSalesRateUnitValues(String strSalesRateUnitValues) {
		this.strSalesRateUnitValues = strSalesRateUnitValues;
	}

	public String getStrDefaultCurrencyCode() {
		return strDefaultCurrencyCode;
	}

	public void setStrDefaultCurrencyCode(String strDefaultCurrencyCode) {
		this.strDefaultCurrencyCode = strDefaultCurrencyCode;
	}

	public String getStrCurrencyCode() {
		return strCurrencyCode;
	}

	public void setStrCurrencyCode(String strCurrencyCode) {
		this.strCurrencyCode = strCurrencyCode;
	}

	public String getStrCurrencyCodeValues() {
		return strCurrencyCodeValues;
	}

	public void setStrCurrencyCodeValues(String strCurrencyCodeValues) {
		this.strCurrencyCodeValues = strCurrencyCodeValues;
	}

	public String getStrCurrencyValue() {
		return strCurrencyValue;
	}

	public void setStrCurrencyValue(String strCurrencyValue) {
		this.strCurrencyValue = strCurrencyValue;
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

	
	public String getStrStockStatusValues() {
		return strStockStatusValues;
	}

	public void setStrStockStatusValues(String strStockStatusValues) {
		this.strStockStatusValues = strStockStatusValues;
	}

	

	// private String strItemNameCombo = "";
	
	public String getStrStockStatus() {
		return strStockStatus;
	}

	public void setStrStockStatus(String strStockStatus) {
		this.strStockStatus = strStockStatus;
	}
	

	public String getStrSuppliedBy() {
		return strSuppliedBy;
	}

	public void setStrSuppliedBy(String strSuppliedBy) {
		this.strSuppliedBy = strSuppliedBy;
	}

	public String getStrSuppliedByValues() {
		return strSuppliedByValues;
	}

	public void setStrSuppliedByValues(String strSuppliedByValues) {
		this.strSuppliedByValues = strSuppliedByValues;
	}

	/**
	 * @return the strSubGroupId
	 */
	public String getStrSubGroupId() {
		return strSubGroupId;
	}

	/**
	 * @param strSubGroupId
	 *            the strSubGroupId to set
	 */
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
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
	 * @return the strErr
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * @param strErr
	 *            the strErr to set
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

	/**
	 * @return the strMsg
	 */
	public String getStrMsg() {
		return strMsg;
	}

	/**
	 * @param strMsg
	 *            the strMsg to set
	 */
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}

	/**
	 * @return the strWarning
	 */
	public String getStrWarning() {
		return strWarning;
	}

	/**
	 * @param strWarning
	 *            the strWarning to set
	 */
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}

	/**
	 * @return the strStoreId
	 */
	public String getStrStoreId() {
		return strStoreId;
	}

	/**
	 * @param strStoreId
	 *            the strStoreId to set
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	/**
	 * @return the strStoreName
	 */
	public String getStrStoreName() {
		return strStoreName;
	}

	/**
	 * @param strStoreName
	 *            the strStoreName to set
	 */
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
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

	public String getStrItemNameCombo() {
		return strItemNameCombo;
	}

	public void setStrItemNameCombo(String strItemNameCombo) {
		this.strItemNameCombo = strItemNameCombo;
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

	public String getStrPoNo() {
		return strPoNo;
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

	public void setStrPoNo(String strPoNo) {
		this.strPoNo = strPoNo;
	}

	
	public String getStrUnitCombo() {
		return strUnitCombo;
	}

	public void setStrUnitCombo(String strUnitCombo) {
		this.strUnitCombo = strUnitCombo;
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

	public String getStrUnitNameCombo() {
		return strUnitNameCombo;
	}

	public void setStrUnitNameCombo(String strUnitNameCombo) {
		this.strUnitNameCombo = strUnitNameCombo;
	}

	/**
	 * @return the strUnitId
	 */
	public String getStrUnitId() {
		return strUnitId;
	}

	/**
	 * @param strUnitId
	 *            the strUnitId to set
	 */
	public void setStrUnitId(String strUnitId) {
		this.strUnitId = strUnitId;
	}

	/**
	 * @return the strUnitName
	 */
	public String getStrUnitName() {
		return strUnitName;
	}

	/**
	 * @param strUnitName
	 *            the strUnitName to set
	 */
	public void setStrUnitName(String strUnitName) {
		this.strUnitName = strUnitName;
	}

	/**
	 * @return the strModuleId
	 */
	public String getStrModuleId() {
		return strModuleId;
	}

	/**
	 * @param strModuleId
	 *            the strModuleId to set
	 */
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
	 * @return the strSlno
	 */

	/**
	 * @return the strUnitIdSale
	 */
	public String getStrUnitIdSale() {
		return strUnitIdSale;
	}

	/**
	 * @param strUnitIdSale
	 *            the strUnitIdSale to set
	 */
	public void setStrUnitIdSale(String strUnitIdSale) {
		this.strUnitIdSale = strUnitIdSale;
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
	 * @return the strUnitNameComboSale
	 */
	public String getStrUnitNameComboSale() {
		return strUnitNameComboSale;
	}

	/**
	 * @param strUnitNameComboSale
	 *            the strUnitNameComboSale to set
	 */
	public void setStrUnitNameComboSale(String strUnitNameComboSale) {
		this.strUnitNameComboSale = strUnitNameComboSale;
	}

	/**
	 * @return the strUnitComboSale
	 */
	public String getStrUnitComboSale() {
		return strUnitComboSale;
	}

	/**
	 * @param strUnitComboSale
	 *            the strUnitComboSale to set
	 */
	public void setStrUnitComboSale(String strUnitComboSale) {
		this.strUnitComboSale = strUnitComboSale;
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
	 * @return the strUnitSaleName
	 */
	public String getStrUnitSaleName() {
		return strUnitSaleName;
	}

	/**
	 * @param strUnitSaleName
	 *            the strUnitSaleName to set
	 */
	public void setStrUnitSaleName(String strUnitSaleName) {
		this.strUnitSaleName = strUnitSaleName;
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
	 * @return the strChk
	 */
	public String getStrChk() {
		return strChk;
	}

	/**
	 * @param strChk
	 *            the strChk to set
	 */
	public void setStrChk(String strChk) {
		this.strChk = strChk;
	}

	/**
	 * @return the strItemCategoryNo
	 */
	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}

	/**
	 * @param strItemCategoryNo
	 *            the strItemCategoryNo to set
	 */
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
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

	public String getStrRegFlag() {
		return strRegFlag;
	}

	public void setStrRegFlag(String strRegFlag) {
		this.strRegFlag = strRegFlag;
	}

	public String getStrConfigIssueRate() {
		return strConfigIssueRate;
	}

	public void setStrConfigIssueRate(String strConfigIssueRate) {
		this.strConfigIssueRate = strConfigIssueRate;
	}

	public String getStrIssueRateConfigFlg() {
		return strIssueRateConfigFlg;
	}

	public void setStrIssueRateConfigFlg(String strIssueRateConfigFlg) {
		this.strIssueRateConfigFlg = strIssueRateConfigFlg;
	}

	public String getStrExistingBatchId() {
		return strExistingBatchId;
	}

	public void setStrExistingBatchId(String strExistingBatchId) {
		this.strExistingBatchId = strExistingBatchId;
	}

	public String getStrExistingBatchCombo() {
		return strExistingBatchCombo;
	}

	public void setStrExistingBatchCombo(String strExistingBatchCombo) {
		this.strExistingBatchCombo = strExistingBatchCombo;
	}

	public String getStrActiveQty() {
		return strActiveQty;
	}

	public void setStrActiveQty(String strActiveQty) {
		this.strActiveQty = strActiveQty;
	}

	public String getStrInActiveQty() {
		return strInActiveQty;
	}

	public void setStrInActiveQty(String strInActiveQty) {
		this.strInActiveQty = strInActiveQty;
	}

	public String getStrQuarantineQty() {
		return strQuarantineQty;
	}

	public void setStrQuarantineQty(String strQuarantineQty) {
		this.strQuarantineQty = strQuarantineQty;
	}

}
