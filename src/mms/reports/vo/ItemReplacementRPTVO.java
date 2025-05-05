package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.TransferObject;

public class ItemReplacementRPTVO implements TransferObject {
	
	private static final long serialVersionUID = 02L;
	
	private String strMsgString ="";
	private String strMsgType ="";
	private String strSeatId ="";
	private String strHospitalCode ="";
	private String strCtDate = "";
	private String strEffectiveFrom = "";
	private String strStatus ="";
	private String strSerialNo = "0";
	private String strReceivedItemViewMode = "0";
	private String strStoreId = "0";
	private String strItemCategoryId = "";
	private String strRemarks = "";
	private String strInstituteId ="0";
	
	private String strFinancialStartYear = "";
	private String strFinancialEndYear = "";
	
	private String strReceivedItemApprovedMode = "0";
	private String strReceivedItemRejectedMode = "0";
	private String strConfigIssueRate;

	
	private WebRowSet wsStoreNameCombo = null;
	private WebRowSet wsItemCategoryCombo = null;
	private WebRowSet wsReceivedItemList = null;
	private WebRowSet wsInstituteList = null;
	

	
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
	private String strReceivedDate = "";

	private String strStockStatus = "";
	private String strOldStockStatus = "";
	private WebRowSet strStockStatusWs = null;
	private String strModuleId = "0";
	
	private WebRowSet strUnitNameComboWS = null;
	private String strUnitNameCombo = "";

	private String strStoreName = "";
	private String strGroupId = "";
	private String strGroupName = "";
	private WebRowSet strGroupComboWs = null;
	private String strIssueRateConfigFlg;
	
	private String strSubGroupId = "";
	private String strSubGroupCombo = "";
	private WebRowSet strSubGroupComboWs = null;
	private String strSubGroupCode = "";
	private String strSubGroupName = "";
	private String strItemCategoryNo = "";

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
	private String strReceivedFromThirdPartyName="";
	
	
	private String strItemSpecification = "";
	
	private String strRegFlag = "";
	private String strBrandDetails = "";
	
	private String[] strParamCheck = null;
	private String[] strParamValue = null;
	private String[] strParamDtls = null;
	private String[] strParamStatus = null;
	private String strRackNumber;
	
	private String strMode;
	private String StrLpFlagMode;
	private String strInstituteName;
	private WebRowSet wsSupplierCombo = null;
	private String strSupplierCombo="";
	private String strSupplierName="";
	private String strSupplierId="";
	private WebRowSet wslpItemName = null;
	private String strUserName;
	private String strDebitNoteNo="";
	private WebRowSet wsIssueDetails = null;
	private WebRowSet wsNOSQItemDetail=null;
	private String strcatno="";
	private String strOrderNo;
	

	
	
	   public String getStrcatno() {
		return strcatno;
	}
	public void setStrcatno(String strcatno) {
		this.strcatno = strcatno;
	}
	public String getStrOrderNo() {
		return strOrderNo;
	}
	public void setStrOrderNo(String strOrderNo) {
		this.strOrderNo = strOrderNo;
	}
	public WebRowSet getWsNOSQItemDetail() {
		return wsNOSQItemDetail;
	}
	public void setWsNOSQItemDetail(WebRowSet wsNOSQItemDetail) {
		this.wsNOSQItemDetail = wsNOSQItemDetail;
	}
	public String getStrDebitNoteNo() {
			return strDebitNoteNo;
		}
		public void setStrDebitNoteNo(String strDebitNoteNo) {
			this.strDebitNoteNo = strDebitNoteNo;
		}
	
	public WebRowSet getWsIssueDetails() {
		return wsIssueDetails;
	}
	public void setWsIssueDetails(WebRowSet wsIssueDetails) {
		this.wsIssueDetails = wsIssueDetails;
	}
	public String getStrUserName() {
		return strUserName;
	}
	public void setStrUserName(String strUserName) {
		this.strUserName = strUserName;
	}
	
	private String strLogoName ="";

	
	public String getStrLogoName() {
		return strLogoName;
	}
	public void setStrLogoName(String strLogoName) {
		this.strLogoName = strLogoName;
	}
	
	private String strActId = "";
	public String getStrActId() {
		return strActId;
	}
	public void setStrActId(String strActId) {
		this.strActId = strActId;
	}

	
	private String LpItemvalue = "";

	public void setlpItemvalue(String LpItemvalue) {
		this.LpItemvalue = LpItemvalue;
	}
	public String getlpItemvalue() {
		return LpItemvalue;
	}
	
	
	private String strCategoryName = "";

	public void setStrCategoryName(String strCategoryName) {
		this.strCategoryName = strCategoryName;
	}
	public String getStrCategoryName() {
		return strCategoryName;
	}
	
	
	
	
	
	private String strlpItemName = "";
	
	public void setStrlpItemName(String strlpItemName) {
		this.strlpItemName = strlpItemName;
	}
	public String getStrlpItemName() {
		return strlpItemName;
	}
	
	
	
	private String strlpItemId = "";
	
	public void setStrlpItemId(String strlpItemId) {
		this.strlpItemId = strlpItemId;
	}
	public String getStrlpItemId() {
		return strlpItemId;
	}
	
	
	
	
	public WebRowSet getWslpItemName() {
		return wslpItemName;
	}
	public void setWslpItemName(WebRowSet wslpItemName) {
		this.wslpItemName = wslpItemName;
	}
	
//private WebRowSet wsInstituteList = null;
	
//	public WebRowSet getWsInstituteList() {
//		return wsInstituteList;
//	}
	
//	public void setWsInstituteList(WebRowSet wsInstituteList) {
//		this.wsInstituteList = wsInstituteList;
//	}
	
	
	
	
	public String getStrSupplierId() {
		return strSupplierId;
	}
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}
	public String getStrSupplierName() {
		return strSupplierName;
	}
	public void setStrSupplierName(String strSupplierName) {
		this.strSupplierName = strSupplierName;
	}
	public WebRowSet getWsSupplierCombo() {
		return wsSupplierCombo;
	}
	public void setWsSupplierCombo(WebRowSet wsSupplierCombo) {
		this.wsSupplierCombo = wsSupplierCombo;
	}
	

	
	
	
	
	public String getStrSupplierCombo() {
		return strSupplierCombo;
	}
	public void setStrSupplierCombo(String strSupplierCombo) {
		this.strSupplierCombo = strSupplierCombo;
	}
	
	
	
	
	
	public String getStrInstituteName() {
		return strInstituteName;
	}
	public void setStrInstituteName(String strInstituteName) {
		this.strInstituteName = strInstituteName;
	}
	public String getStrLpFlagMode() {
		return StrLpFlagMode;
	}
	public void setStrLpFlagMode(String strLpFlagMode) {
		StrLpFlagMode = strLpFlagMode;
	}
	public String getStrRackNumber() {
		return strRackNumber;
	}
	public void setStrRackNumber(String strRackNumber) {
		this.strRackNumber = strRackNumber;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	
	public WebRowSet getStrGroupComboWs() {
		return strGroupComboWs;
	}
	public void setStrGroupComboWs(WebRowSet strGroupComboWs) {
		this.strGroupComboWs = strGroupComboWs;
	}
	public String getStrSerialNo() {
		return strSerialNo;
	}
	public void setStrSerialNo(String strSerialNo) {
		this.strSerialNo = strSerialNo;
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
	
	public String getStrMsgString() {
		return strMsgString;
	}
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}
	public String getStrMsgType() {
		return strMsgType;
	}
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrItemCategoryId() {
		return strItemCategoryId;
	}
	public void setStrItemCategoryId(String strItemCategoryId) {
		this.strItemCategoryId = strItemCategoryId;
	}
	

	public String getStrInstituteId() {
		return strInstituteId;
	}
	public void setStrInstituteId(String strInstituteId) {
		this.strInstituteId = strInstituteId;
	}
	public WebRowSet getWsStoreNameCombo() {
		return wsStoreNameCombo;
	}
	public void setWsStoreNameCombo(WebRowSet wsStoreNameCombo) {
		this.wsStoreNameCombo = wsStoreNameCombo;
	}
	public WebRowSet getWsItemCategoryCombo() {
		return wsItemCategoryCombo;
	}
	public void setWsItemCategoryCombo(WebRowSet wsItemCategoryCombo) {
		this.wsItemCategoryCombo = wsItemCategoryCombo;
	}
	public String getStrCtDate() {
		return strCtDate;
	}
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}
	public String getStrEffectiveFrom() {
		return strEffectiveFrom;
	}
	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
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
	public String getStrSuppliedBy() {
		return strSuppliedBy;
	}
	public void setStrSuppliedBy(String strSuppliedBy) {
		this.strSuppliedBy = strSuppliedBy;
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
	public String getStrInHandQuantity() {
		return strInHandQuantity;
	}
	public void setStrInHandQuantity(String strInHandQuantity) {
		this.strInHandQuantity = strInHandQuantity;
	}
	public String getStrInHandQuantityUnitID() {
		return strInHandQuantityUnitID;
	}
	public void setStrInHandQuantityUnitID(String strInHandQuantityUnitID) {
		this.strInHandQuantityUnitID = strInHandQuantityUnitID;
	}
	public String getStrInHandQuantityUnitName() {
		return strInHandQuantityUnitName;
	}
	public void setStrInHandQuantityUnitName(String strInHandQuantityUnitName) {
		this.strInHandQuantityUnitName = strInHandQuantityUnitName;
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
	public String getStrRate() {
		return strRate;
	}
	public void setStrRate(String strRate) {
		this.strRate = strRate;
	}
	public String getStrSalePrice() {
		return strSalePrice;
	}
	public void setStrSalePrice(String strSalePrice) {
		this.strSalePrice = strSalePrice;
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
	
	public String getStrReceivedDate() {
		return strReceivedDate;
	}
	public void setStrReceivedDate(String strReceivedDate) {
		this.strReceivedDate = strReceivedDate;
	}
	public String getStrStockStatus() {
		return strStockStatus;
	}
	public void setStrStockStatus(String strStockStatus) {
		this.strStockStatus = strStockStatus;
	}
	public String getStrOldStockStatus() {
		return strOldStockStatus;
	}
	public void setStrOldStockStatus(String strOldStockStatus) {
		this.strOldStockStatus = strOldStockStatus;
	}
	public WebRowSet getStrStockStatusWs() {
		return strStockStatusWs;
	}
	public void setStrStockStatusWs(WebRowSet strStockStatusWs) {
		this.strStockStatusWs = strStockStatusWs;
	}
	public String getStrModuleId() {
		return strModuleId;
	}
	public void setStrModuleId(String strModuleId) {
		this.strModuleId = strModuleId;
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
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String getStrGroupId() {
		return strGroupId;
	}
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}
	public String getStrGroupName() {
		return strGroupName;
	}
	public void setStrGroupName(String strGroupName) {
		this.strGroupName = strGroupName;
	}
	public String getStrSubGroupId() {
		return strSubGroupId;
	}
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}
	public String getStrSubGroupCombo() {
		return strSubGroupCombo;
	}
	public void setStrSubGroupCombo(String strSubGroupCombo) {
		this.strSubGroupCombo = strSubGroupCombo;
	}
	public WebRowSet getStrSubGroupComboWs() {
		return strSubGroupComboWs;
	}
	public void setStrSubGroupComboWs(WebRowSet strSubGroupComboWs) {
		this.strSubGroupComboWs = strSubGroupComboWs;
	}
	public String getStrSubGroupCode() {
		return strSubGroupCode;
	}
	public void setStrSubGroupCode(String strSubGroupCode) {
		this.strSubGroupCode = strSubGroupCode;
	}
	public String getStrSubGroupName() {
		return strSubGroupName;
	}
	public void setStrSubGroupName(String strSubGroupName) {
		this.strSubGroupName = strSubGroupName;
	}
	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}
	public String getStrUnitRateID() {
		return strUnitRateID;
	}
	public void setStrUnitRateID(String strUnitRateID) {
		this.strUnitRateID = strUnitRateID;
	}
	public String getStrUnitRateName() {
		return strUnitRateName;
	}
	public void setStrUnitRateName(String strUnitRateName) {
		this.strUnitRateName = strUnitRateName;
	}
	public String getStrUnitRateCombo() {
		return strUnitRateCombo;
	}
	public void setStrUnitRateCombo(String strUnitRateCombo) {
		this.strUnitRateCombo = strUnitRateCombo;
	}
	public WebRowSet getStrUnitRateComboWS() {
		return strUnitRateComboWS;
	}
	public void setStrUnitRateComboWS(WebRowSet strUnitRateComboWS) {
		this.strUnitRateComboWS = strUnitRateComboWS;
	}
	public String getStrUnitSaleID() {
		return strUnitSaleID;
	}
	public void setStrUnitSaleID(String strUnitSaleID) {
		this.strUnitSaleID = strUnitSaleID;
	}
	public String getStrUnitNameSale() {
		return strUnitNameSale;
	}
	public void setStrUnitNameSale(String strUnitNameSale) {
		this.strUnitNameSale = strUnitNameSale;
	}
	public String getStrUnitSaleCombo() {
		return strUnitSaleCombo;
	}
	public void setStrUnitSaleCombo(String strUnitSaleCombo) {
		this.strUnitSaleCombo = strUnitSaleCombo;
	}
	public WebRowSet getStrUnitSaleComboWS() {
		return strUnitSaleComboWS;
	}
	public void setStrUnitSaleComboWS(WebRowSet strUnitSaleComboWS) {
		this.strUnitSaleComboWS = strUnitSaleComboWS;
	}
	public String[] getStrItemOtherDtls() {
		return strItemOtherDtls;
	}
	public void setStrItemOtherDtls(String[] strItemOtherDtls) {
		this.strItemOtherDtls = strItemOtherDtls;
	}
	public String[] getStrItemPartDtls() {
		return strItemPartDtls;
	}
	public void setStrItemPartDtls(String[] strItemPartDtls) {
		this.strItemPartDtls = strItemPartDtls;
	}
	public String[] getStrItemParamDtls() {
		return strItemParamDtls;
	}
	public void setStrItemParamDtls(String[] strItemParamDtls) {
		this.strItemParamDtls = strItemParamDtls;
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
	public WebRowSet getStrWarrantyManufactureComboWS() {
		return strWarrantyManufactureComboWS;
	}
	public void setStrWarrantyManufactureComboWS(
			WebRowSet strWarrantyManufactureComboWS) {
		this.strWarrantyManufactureComboWS = strWarrantyManufactureComboWS;
	}
	public String getStrInstallFlag() {
		return strInstallFlag;
	}
	public void setStrInstallFlag(String strInstallFlag) {
		this.strInstallFlag = strInstallFlag;
	}
	public String getStrIsInstallDetails() {
		return strIsInstallDetails;
	}
	public void setStrIsInstallDetails(String strIsInstallDetails) {
		this.strIsInstallDetails = strIsInstallDetails;
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
	public String getStrReceivedItemViewMode() {
		return strReceivedItemViewMode;
	}
	public void setStrReceivedItemViewMode(String strReceivedItemViewMode) {
		this.strReceivedItemViewMode = strReceivedItemViewMode;
	}
	public WebRowSet getWsReceivedItemList() {
		return wsReceivedItemList;
	}
	public void setWsReceivedItemList(WebRowSet wsReceivedItemList) {
		this.wsReceivedItemList = wsReceivedItemList;
	}
	public WebRowSet getWsInstituteList() {
		return wsInstituteList;
	}
	public void setWsInstituteList(WebRowSet wsInstituteList) {
		this.wsInstituteList = wsInstituteList;
	}
	public String getStrReceivedItemApprovedMode() {
		return strReceivedItemApprovedMode;
	}
	public void setStrReceivedItemApprovedMode(String strReceivedItemApprovedMode) {
		this.strReceivedItemApprovedMode = strReceivedItemApprovedMode;
	}
	public String getStrReceivedItemRejectedMode() {
		return strReceivedItemRejectedMode;
	}
	public void setStrReceivedItemRejectedMode(String strReceivedItemRejectedMode) {
		this.strReceivedItemRejectedMode = strReceivedItemRejectedMode;
	}
	public String getStrStatus() {
		return strStatus;
	}
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
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
	public String getStrBrandDetails() {
		return strBrandDetails;
	}
	public void setStrBrandDetails(String strBrandDetails) {
		this.strBrandDetails = strBrandDetails;
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
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
	public String getStrReceivedFromThirdPartyName() {
		return strReceivedFromThirdPartyName;
	}
	public void setStrReceivedFromThirdPartyName(
			String strReceivedFromThirdPartyName) {
		this.strReceivedFromThirdPartyName = strReceivedFromThirdPartyName;
	}
	
	
	
	
}
