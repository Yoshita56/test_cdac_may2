package mms.transactions.controller.fb;

import org.apache.struts.upload.FormFile;

import hisglobal.transactionutil.GenericFormBean;

/**
 * 
 * Developer : Balasubramaniam M Version : 1.0 Date : 12-Jun-2009
 * 
 */

public class ChallanProcessApprovalTransFB extends GenericFormBean {

	private static final long serialVersionUID = 02L;

	private String strErr = "";
	private String strWarning = "";
	private String strMsg = "";
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strCtDate = "";

	private String strVerifyFlag = "0";
	private String strStoreId = "0";
	private String strStoreName = "";
	private String strItemCategoryId = "0";
	private String strItemCategoryName = "";
	private String strPoNo = "0";
	private String strPoNoDisplay = "";
	private String strPoDate = "";
	private String strPoTypeId = "0";
	private String strPoType = "";
	private String strPoStoreId = "0";
	private String strPurchaseSourceId = "0";
	private String strPurchseSource = "";
	private String strSupplierId = "0";
	private String strSupplierName = "";
	private String strScheduleNo = "0";
	private String strScheduleNoValues = "";
	private String strScheduleDate = "";
	private String strScheduleTypeId = "0";
	private String strScheduleType = "";
	private String strDeliveryDate = "";
	private String strAwbNo = "0";
	private String strBeNo = "0";
	private String strBeDate = "";
	private String strNoOfPackets = "0";
	private String strPackageWeight = "0";
	private String strDeliveryMode = "0";
	private String strDeliveryModeValues = "0";
	private String strReceivedByOptionVal="";
	private String strChallanNo = "";
	private String strChallanCount = "";
	private FormFile strLocation=null;
	private String strFileNo = "";
	private String strPageNo = "";
	private String strFileName = "";
	private String[] strReceivedQty = null;
	private String[] strReceivedUnitId = null;

	private String[] strItemDtls = null;

	private String strReceivedBy = "";
	private String strRemarks = "";

	private String strPuk = "";
	private String strEmployeeNo = "";

	private String strScheduleAndReceiveDtls = "";
	private String strScheduledItemDetails = "";

	private String strCurrencyName = "";
	private String strCurrencyCode = "0";
	private String strCurrencyValue = "1";

	private String strReceiveDate = "";
	private String strActualDeliveryDate = "";

	private String strGroupName = "";
	private String strGroupId = "0";
	private String strSubGroupName = "";
	private String strSubGroupId = "";
	private String strGenericItemName = "";
	private String strGenericItemId = "0";
	private String strItemBrandName = "";
	private String strItemBrandId = "0";
	private String strReceivedQuantity = "0";
	private String strReceivedQuantityUnitId = "0";
	private String strReceivedQuantityUnitBaseValue = "0";
	private String strReceivedQuantityView = "";
	private String strRate = "0";
	private String strRateUnit = "0";
	private String strRateView = "";
	private String strBalanceQuantity = "";
	private String strBalanceQuantityUnitId = "";
	private String strBalanceQuantityUnitBaseValue = "";
	private String strBalanceQuantityView = "";
	private String strManufacturerName = "";
	private String strManufacturerId = "0";
	private String strManufacturerValues = "";
	private String strBatchNo = "0";
	private String strExpiryDate = "";
	private String strManufactureDate = "";
	private String strAcceptedQuantity = "0";
	private String strAcceptedQuantityUnitId = "0";
	private String strAcceptedQuantityView = "";
	private String strBreakageQuantity = "0";
	private String strBreakageQuantityUnitId = "0";
	private String strBreakageQuantityView = "0 /";
	private String strRejectedQuantity = "0";
	private String strRejectedQuantityUnitId = "0";
	private String strRejectedQuantityView = "0 /";
	private String strOrderedQuantityView = "0 /";
	private String strExcessQty = "0";
	private String strExcessQtyUnitId = "0";
	private String strSalePrice = "0";
	private String strSalePriceUnitId = "0";
	private String strVerifiedQuantity = "0";
	private String strVerifiedQuantityUnitId = "";
	private String strVerifiedQuantityView = "0 /";
	private String strVerifiedQuantityInBaseVal = "0";
	private String strPreviousExcessQtyView = "";

	private String strSupplierReceiptNo = "0";
	private String strSupplierReceiptDate = "";

	private String strCommitteeType = "0";
	private String strCommitteeTypeValues = "";
	private String[] strCommitteeMemberHidden = null;
	private String[] strMemberRecommendation = null;

	private String strUnitValues = "";
	private String strRateUnitValues = "";

	private String isBatchReq = "";
	private String isExpirtReq = "";

	private String[] strItemOtherDtls = null;

	private String[] strItemPartDtls = null;
	private String[] strItemParamDtls = null;

	private String strWarrantyFlag = null;

	private String strIsWarrantyDetails = "0";
	private String strWarrantyDate = "";
	private String strWarantyManufacturer = "";
	private String strWarrantyUpTo = "";
	private String strWarrantyUpToUnit = "0";
	private String strWarrantyRemarks = "";

	private String strInstallFlag = null;

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
	
	private String strIssueRateConfigFlg;
	private String strConfigIssueRate;
	
	
	private String strChallanHlpDtl="";	
	private String strReceivedItemHlpDtl = "";
	private String strVerifiedItemHlpDtl = "";
	
	private String strSupplierInterfaceFlag="0";
	
	private String []strHiddenVerifiedChallanValue;
	
	private String strPrintItemHlpDtl;

	public String getStrPrintItemHlpDtl() {
		return strPrintItemHlpDtl;
	}

	public void setStrPrintItemHlpDtl(String strPrintItemHlpDtl) {
		this.strPrintItemHlpDtl = strPrintItemHlpDtl;
	}

	public String[] getStrHiddenVerifiedChallanValue() {
		return strHiddenVerifiedChallanValue;
	}

	public void setStrHiddenVerifiedChallanValue(
			String[] strHiddenVerifiedChallanValue) {
		this.strHiddenVerifiedChallanValue = strHiddenVerifiedChallanValue;
	}

	public String getStrSupplierInterfaceFlag() {
		return strSupplierInterfaceFlag;
	}

	public void setStrSupplierInterfaceFlag(String strSupplierInterfaceFlag) {
		this.strSupplierInterfaceFlag = strSupplierInterfaceFlag;
	}

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

	public String getStrCurrencyName() {
		return strCurrencyName;
	}

	public void setStrCurrencyName(String strCurrencyName) {
		this.strCurrencyName = strCurrencyName;
	}

	public String getStrCurrencyCode() {
		return strCurrencyCode;
	}

	public void setStrCurrencyCode(String strCurrencyCode) {
		this.strCurrencyCode = strCurrencyCode;
	}

	public String getStrCurrencyValue() {
		return strCurrencyValue;
	}

	public void setStrCurrencyValue(String strCurrencyValue) {
		this.strCurrencyValue = strCurrencyValue;
	}

	public String getStrReceiveDate() {
		return strReceiveDate;
	}

	public void setStrReceiveDate(String strReceiveDate) {
		this.strReceiveDate = strReceiveDate;
	}

	public String getStrActualDeliveryDate() {
		return strActualDeliveryDate;
	}

	public void setStrActualDeliveryDate(String strActualDeliveryDate) {
		this.strActualDeliveryDate = strActualDeliveryDate;
	}

	public String getStrGroupName() {
		return strGroupName;
	}

	public void setStrGroupName(String strGroupName) {
		this.strGroupName = strGroupName;
	}

	public String getStrGroupId() {
		return strGroupId;
	}

	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	public String getStrSubGroupName() {
		return strSubGroupName;
	}

	public void setStrSubGroupName(String strSubGroupName) {
		this.strSubGroupName = strSubGroupName;
	}

	public String getStrSubGroupId() {
		return strSubGroupId;
	}

	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}

	public String getStrGenericItemName() {
		return strGenericItemName;
	}

	public void setStrGenericItemName(String strGenericItemName) {
		this.strGenericItemName = strGenericItemName;
	}

	public String getStrGenericItemId() {
		return strGenericItemId;
	}

	public void setStrGenericItemId(String strGenericItemId) {
		this.strGenericItemId = strGenericItemId;
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

	public String getStrRateUnit() {
		return strRateUnit;
	}

	public void setStrRateUnit(String strRateUnit) {
		this.strRateUnit = strRateUnit;
	}

	public String getStrManufacturerName() {
		return strManufacturerName;
	}

	public void setStrManufacturerName(String strManufacturerName) {
		this.strManufacturerName = strManufacturerName;
	}

	public String getStrManufacturerId() {
		return strManufacturerId;
	}

	public void setStrManufacturerId(String strManufacturerId) {
		this.strManufacturerId = strManufacturerId;
	}

	public String getStrManufacturerValues() {
		return strManufacturerValues;
	}

	public void setStrManufacturerValues(String strManufacturerValues) {
		this.strManufacturerValues = strManufacturerValues;
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

	public String getStrAcceptedQuantity() {
		return strAcceptedQuantity;
	}

	public void setStrAcceptedQuantity(String strAcceptedQuantity) {
		this.strAcceptedQuantity = strAcceptedQuantity;
	}

	public String getStrAcceptedQuantityUnitId() {
		return strAcceptedQuantityUnitId;
	}

	public void setStrAcceptedQuantityUnitId(String strAcceptedQuantityUnitId) {
		this.strAcceptedQuantityUnitId = strAcceptedQuantityUnitId;
	}

	public String getStrRejectedQuantity() {
		return strRejectedQuantity;
	}

	public void setStrRejectedQuantity(String strRejectedQuantity) {
		this.strRejectedQuantity = strRejectedQuantity;
	}

	public String getStrRejectedQuantityUnitId() {
		return strRejectedQuantityUnitId;
	}

	public void setStrRejectedQuantityUnitId(String strRejectedQuantityUnitId) {
		this.strRejectedQuantityUnitId = strRejectedQuantityUnitId;
	}

	public String getStrExcessQty() {
		return strExcessQty;
	}

	public void setStrExcessQty(String strExcessQty) {
		this.strExcessQty = strExcessQty;
	}

	public String getStrExcessQtyUnitId() {
		return strExcessQtyUnitId;
	}

	public void setStrExcessQtyUnitId(String strExcessQtyUnitId) {
		this.strExcessQtyUnitId = strExcessQtyUnitId;
	}

	public String getStrSalePrice() {
		return strSalePrice;
	}

	public void setStrSalePrice(String strSalePrice) {
		this.strSalePrice = strSalePrice;
	}

	public String getStrSalePriceUnitId() {
		return strSalePriceUnitId;
	}

	public void setStrSalePriceUnitId(String strSalePriceUnitId) {
		this.strSalePriceUnitId = strSalePriceUnitId;
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

	public String getStrPoStoreId() {
		return strPoStoreId;
	}

	public void setStrPoStoreId(String strPoStoreId) {
		this.strPoStoreId = strPoStoreId;
	}

	public String getStrScheduleAndReceiveDtls() {
		return strScheduleAndReceiveDtls;
	}

	public void setStrScheduleAndReceiveDtls(String strScheduleAndReceiveDtls) {
		this.strScheduleAndReceiveDtls = strScheduleAndReceiveDtls;
	}

	public String getStrScheduledItemDetails() {
		return strScheduledItemDetails;
	}

	public void setStrScheduledItemDetails(String strScheduledItemDetails) {
		this.strScheduledItemDetails = strScheduledItemDetails;
	}

	public String getStrErr() {
		return strErr;
	}

	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

	public String getStrWarning() {
		return strWarning;
	}

	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}

	public String getStrMsg() {
		return strMsg;
	}

	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}

	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	public String getStrCtDate() {
		return strCtDate;
	}

	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
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

	public String getStrItemCategoryId() {
		return strItemCategoryId;
	}

	public void setStrItemCategoryId(String strItemCategoryId) {
		this.strItemCategoryId = strItemCategoryId;
	}

	public String getStrItemCategoryName() {
		return strItemCategoryName;
	}

	public void setStrItemCategoryName(String strItemCategoryName) {
		this.strItemCategoryName = strItemCategoryName;
	}

	public String getStrPoNo() {
		return strPoNo;
	}

	public void setStrPoNo(String strPoNo) {
		this.strPoNo = strPoNo;
	}

	public String getStrPoTypeId() {
		return strPoTypeId;
	}

	public void setStrPoTypeId(String strPoTypeId) {
		this.strPoTypeId = strPoTypeId;
	}

	public String getStrPoType() {
		return strPoType;
	}

	public void setStrPoType(String strPoType) {
		this.strPoType = strPoType;
	}

	public String getStrPurchaseSourceId() {
		return strPurchaseSourceId;
	}

	public void setStrPurchaseSourceId(String strPurchaseSourceId) {
		this.strPurchaseSourceId = strPurchaseSourceId;
	}

	public String getStrPurchseSource() {
		return strPurchseSource;
	}

	public void setStrPurchseSource(String strPurchseSource) {
		this.strPurchseSource = strPurchseSource;
	}

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

	public String getStrScheduleNo() {
		return strScheduleNo;
	}

	public void setStrScheduleNo(String strScheduleNo) {
		this.strScheduleNo = strScheduleNo;
	}

	public String getStrScheduleNoValues() {
		return strScheduleNoValues;
	}

	public void setStrScheduleNoValues(String strScheduleNoValues) {
		this.strScheduleNoValues = strScheduleNoValues;
	}

	public String getStrScheduleDate() {
		return strScheduleDate;
	}

	public void setStrScheduleDate(String strScheduleDate) {
		this.strScheduleDate = strScheduleDate;
	}

	public String getStrScheduleTypeId() {
		return strScheduleTypeId;
	}

	public void setStrScheduleTypeId(String strScheduleTypeId) {
		this.strScheduleTypeId = strScheduleTypeId;
	}

	public String getStrScheduleType() {
		return strScheduleType;
	}

	public void setStrScheduleType(String strScheduleType) {
		this.strScheduleType = strScheduleType;
	}

	public String getStrDeliveryDate() {
		return strDeliveryDate;
	}

	public void setStrDeliveryDate(String strDeliveryDate) {
		this.strDeliveryDate = strDeliveryDate;
	}

	public String getStrAwbNo() {
		return strAwbNo;
	}

	public void setStrAwbNo(String strAwbNo) {
		this.strAwbNo = strAwbNo;
	}

	public String getStrBeNo() {
		return strBeNo;
	}

	public void setStrBeNo(String strBeNo) {
		this.strBeNo = strBeNo;
	}

	public String getStrBeDate() {
		return strBeDate;
	}

	public void setStrBeDate(String strBeDate) {
		this.strBeDate = strBeDate;
	}

	public String getStrNoOfPackets() {
		return strNoOfPackets;
	}

	public void setStrNoOfPackets(String strNoOfPackets) {
		this.strNoOfPackets = strNoOfPackets;
	}

	public String getStrPackageWeight() {
		return strPackageWeight;
	}

	public void setStrPackageWeight(String strPackageWeight) {
		this.strPackageWeight = strPackageWeight;
	}

	public String getStrDeliveryMode() {
		return strDeliveryMode;
	}

	public void setStrDeliveryMode(String strDeliveryMode) {
		this.strDeliveryMode = strDeliveryMode;
	}

	public String getStrDeliveryModeValues() {
		return strDeliveryModeValues;
	}

	public void setStrDeliveryModeValues(String strDeliveryModeValues) {
		this.strDeliveryModeValues = strDeliveryModeValues;
	}

	public String[] getStrReceivedQty() {
		return strReceivedQty;
	}

	public void setStrReceivedQty(String[] strReceivedQty) {
		this.strReceivedQty = strReceivedQty;
	}

	public String[] getStrReceivedUnitId() {
		return strReceivedUnitId;
	}

	public void setStrReceivedUnitId(String[] strReceivedUnitId) {
		this.strReceivedUnitId = strReceivedUnitId;
	}

	public String getStrReceivedBy() {
		return strReceivedBy;
	}

	public void setStrReceivedBy(String strReceivedBy) {
		this.strReceivedBy = strReceivedBy;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	public String[] getStrItemDtls() {
		return strItemDtls;
	}

	public void setStrItemDtls(String[] strItemDtls) {
		this.strItemDtls = strItemDtls;
	}

	public String getStrSeatId() {
		return strSeatId;
	}

	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	public String getStrPoDate() {
		return strPoDate;
	}

	public void setStrPoDate(String strPoDate) {
		this.strPoDate = strPoDate;
	}

	public String getStrPuk() {
		return strPuk;
	}

	public void setStrPuk(String strPuk) {
		this.strPuk = strPuk;
	}

	public String getStrEmployeeNo() {
		return strEmployeeNo;
	}

	public void setStrEmployeeNo(String strEmployeeNo) {
		this.strEmployeeNo = strEmployeeNo;
	}

	public String getStrChallanNo() {
		return strChallanNo;
	}

	public void setStrChallanNo(String strChallanNo) {
		this.strChallanNo = strChallanNo;
	}

	public String getStrReceivedQuantityUnitId() {
		return strReceivedQuantityUnitId;
	}

	public void setStrReceivedQuantityUnitId(String strReceivedQuantityUnitId) {
		this.strReceivedQuantityUnitId = strReceivedQuantityUnitId;
	}

	public String getStrReceivedQuantityView() {
		return strReceivedQuantityView;
	}

	public void setStrReceivedQuantityView(String strReceivedQuantityView) {
		this.strReceivedQuantityView = strReceivedQuantityView;
	}

	public String getStrRate() {
		return strRate;
	}

	public void setStrRate(String strRate) {
		this.strRate = strRate;
	}

	public String getStrRateView() {
		return strRateView;
	}

	public void setStrRateView(String strRateView) {
		this.strRateView = strRateView;
	}

	public String getStrBalanceQuantity() {
		return strBalanceQuantity;
	}

	public void setStrBalanceQuantity(String strBalanceQuantity) {
		this.strBalanceQuantity = strBalanceQuantity;
	}

	public String getStrBalanceQuantityUnitId() {
		return strBalanceQuantityUnitId;
	}

	public void setStrBalanceQuantityUnitId(String strBalanceQuantityUnitId) {
		this.strBalanceQuantityUnitId = strBalanceQuantityUnitId;
	}

	public String getStrBalanceQuantityView() {
		return strBalanceQuantityView;
	}

	public void setStrBalanceQuantityView(String strBalanceQuantityView) {
		this.strBalanceQuantityView = strBalanceQuantityView;
	}

	public String getIsBatchReq() {
		return isBatchReq;
	}

	public void setIsBatchReq(String isBatchReq) {
		this.isBatchReq = isBatchReq;
	}

	public String getIsExpirtReq() {
		return isExpirtReq;
	}

	public void setIsExpirtReq(String isExpirtReq) {
		this.isExpirtReq = isExpirtReq;
	}

	public String getStrUnitValues() {
		return strUnitValues;
	}

	public void setStrUnitValues(String strUnitValues) {
		this.strUnitValues = strUnitValues;
	}

	public String getStrRateUnitValues() {
		return strRateUnitValues;
	}

	public void setStrRateUnitValues(String strRateUnitValues) {
		this.strRateUnitValues = strRateUnitValues;
	}

	public String getStrReceivedQuantity() {
		return strReceivedQuantity;
	}

	public void setStrReceivedQuantity(String strReceivedQuantity) {
		this.strReceivedQuantity = strReceivedQuantity;
	}

	public String getStrReceivedQuantityUnitBaseValue() {
		return strReceivedQuantityUnitBaseValue;
	}

	public void setStrReceivedQuantityUnitBaseValue(
			String strReceivedQuantityUnitBaseValue) {
		this.strReceivedQuantityUnitBaseValue = strReceivedQuantityUnitBaseValue;
	}

	public String getStrBalanceQuantityUnitBaseValue() {
		return strBalanceQuantityUnitBaseValue;
	}

	public void setStrBalanceQuantityUnitBaseValue(
			String strBalanceQuantityUnitBaseValue) {
		this.strBalanceQuantityUnitBaseValue = strBalanceQuantityUnitBaseValue;
	}

	public String getStrCommitteeType() {
		return strCommitteeType;
	}

	public void setStrCommitteeType(String strCommitteeType) {
		this.strCommitteeType = strCommitteeType;
	}

	public String[] getStrCommitteeMemberHidden() {
		return strCommitteeMemberHidden;
	}

	public void setStrCommitteeMemberHidden(String[] strCommitteeMemberHidden) {
		this.strCommitteeMemberHidden = strCommitteeMemberHidden;
	}

	public String[] getStrMemberRecommendation() {
		return strMemberRecommendation;
	}

	public void setStrMemberRecommendation(String[] strMemberRecommendation) {
		this.strMemberRecommendation = strMemberRecommendation;
	}

	public String getStrCommitteeTypeValues() {
		return strCommitteeTypeValues;
	}

	public void setStrCommitteeTypeValues(String strCommitteeTypeValues) {
		this.strCommitteeTypeValues = strCommitteeTypeValues;
	}

	public String getStrBreakageQuantity() {
		return strBreakageQuantity;
	}

	public void setStrBreakageQuantity(String strBreakageQuantity) {
		this.strBreakageQuantity = strBreakageQuantity;
	}

	public String getStrBreakageQuantityUnitId() {
		return strBreakageQuantityUnitId;
	}

	public void setStrBreakageQuantityUnitId(String strBreakageQuantityUnitId) {
		this.strBreakageQuantityUnitId = strBreakageQuantityUnitId;
	}

	public String getStrVerifiedQuantity() {
		return strVerifiedQuantity;
	}

	public void setStrVerifiedQuantity(String strVerifiedQuantity) {
		this.strVerifiedQuantity = strVerifiedQuantity;
	}

	public String getStrVerifiedQuantityUnitId() {
		return strVerifiedQuantityUnitId;
	}

	public void setStrVerifiedQuantityUnitId(String strVerifiedQuantityUnitId) {
		this.strVerifiedQuantityUnitId = strVerifiedQuantityUnitId;
	}

	public String getStrVerifiedQuantityView() {
		return strVerifiedQuantityView;
	}

	public void setStrVerifiedQuantityView(String strVerifiedQuantityView) {
		this.strVerifiedQuantityView = strVerifiedQuantityView;
	}

	public String getStrPreviousExcessQtyView() {
		return strPreviousExcessQtyView;
	}

	public void setStrPreviousExcessQtyView(String strPreviousExcessQtyView) {
		this.strPreviousExcessQtyView = strPreviousExcessQtyView;
	}

	public String getStrChallanCount() {
		return strChallanCount;
	}

	public void setStrChallanCount(String strChallanCount) {
		this.strChallanCount = strChallanCount;
	}

	public String getStrSupplierReceiptNo() {
		return strSupplierReceiptNo;
	}

	public void setStrSupplierReceiptNo(String strSupplierReceiptNo) {
		this.strSupplierReceiptNo = strSupplierReceiptNo;
	}

	public String getStrSupplierReceiptDate() {
		return strSupplierReceiptDate;
	}

	public void setStrSupplierReceiptDate(String strSupplierReceiptDate) {
		this.strSupplierReceiptDate = strSupplierReceiptDate;
	}

	public String getStrAcceptedQuantityView() {
		return strAcceptedQuantityView;
	}

	public void setStrAcceptedQuantityView(String strAcceptedQuantityView) {
		this.strAcceptedQuantityView = strAcceptedQuantityView;
	}

	public String getStrBreakageQuantityView() {
		return strBreakageQuantityView;
	}

	public void setStrBreakageQuantityView(String strBreakageQuantityView) {
		this.strBreakageQuantityView = strBreakageQuantityView;
	}

	public String getStrRejectedQuantityView() {
		return strRejectedQuantityView;
	}

	public void setStrRejectedQuantityView(String strRejectedQuantityView) {
		this.strRejectedQuantityView = strRejectedQuantityView;
	}

	public String getStrOrderedQuantityView() {
		return strOrderedQuantityView;
	}

	public void setStrOrderedQuantityView(String strOrderedQuantityView) {
		this.strOrderedQuantityView = strOrderedQuantityView;
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

	public String getStrVerifyFlag() {
		return strVerifyFlag;
	}

	public void setStrVerifyFlag(String strVerifyFlag) {
		this.strVerifyFlag = strVerifyFlag;
	}

	public String getStrVerifiedQuantityInBaseVal() {
		return strVerifiedQuantityInBaseVal;
	}

	public void setStrVerifiedQuantityInBaseVal(String strVerifiedQuantityInBaseVal) {
		this.strVerifiedQuantityInBaseVal = strVerifiedQuantityInBaseVal;
	}

	public String getStrPoNoDisplay() {
		return strPoNoDisplay;
	}

	public void setStrPoNoDisplay(String strPoNoDisplay) {
		this.strPoNoDisplay = strPoNoDisplay;
	}

	public String getStrReceivedByOptionVal() {
		return strReceivedByOptionVal;
	}

	public void setStrReceivedByOptionVal(String strReceivedByOptionVal) {
		this.strReceivedByOptionVal = strReceivedByOptionVal;
	}

	

	public String getStrFileNo() {
		return strFileNo;
	}

	public void setStrFileNo(String strFileNo) {
		this.strFileNo = strFileNo;
	}

	public String getStrPageNo() {
		return strPageNo;
	}

	public void setStrPageNo(String strPageNo) {
		this.strPageNo = strPageNo;
	}

	public String getStrFileName() {
		return strFileName;
	}

	public void setStrFileName(String strFileName) {
		this.strFileName = strFileName;
	}

	public FormFile getStrLocation() {
		return strLocation;
	}

	public void setStrLocation(FormFile strLocation) {
		this.strLocation = strLocation;
	}

	public String getStrChallanHlpDtl() {
		return strChallanHlpDtl;
	}

	public void setStrChallanHlpDtl(String strChallanHlpDtl) {
		this.strChallanHlpDtl = strChallanHlpDtl;
	}

	public String getStrReceivedItemHlpDtl() {
		return strReceivedItemHlpDtl;
	}

	public void setStrReceivedItemHlpDtl(String strReceivedItemHlpDtl) {
		this.strReceivedItemHlpDtl = strReceivedItemHlpDtl;
	}

	public String getStrVerifiedItemHlpDtl() {
		return strVerifiedItemHlpDtl;
	}

	public void setStrVerifiedItemHlpDtl(String strVerifiedItemHlpDtl) {
		this.strVerifiedItemHlpDtl = strVerifiedItemHlpDtl;
	}

}
