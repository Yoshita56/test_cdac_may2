package mms.transactions.vo;

import hisglobal.utility.TransferObject;

import javax.sql.rowset.WebRowSet;

/**
 * 
 * Developer : Balasubramaniam M Version : 1.0 Date : 12-Jun-2009
 * 
 */
public class ChallanProcessTransVO implements TransferObject {

	private static final long serialVersionUID = 02L;

	private String strMsgString = "";
	private String strMsgType = "";
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
	private String strPoStoreId = "0";
	private String strPoType = "";
	private String strPurchaseSourceId = "0";
	private String strPurchseSource = "";
	private String strSupplierId = "0";
	private String strSupplierName = "";
	private String strScheduleNo = "0";
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
	private String strTmpChkVal;

	private String strChallanNo = "";
	private String strChallanCount = "0";
	private String strPoItemCount = "0";
	
	private String strPuk = "";
	private String strEmployeeNo = "";
	private String strFinancialStartDate = "";
	private String strFinancialEndDate = "";
	private String strFileNo = "";
	private String strPageNo = "";
	private String strFileName = "";
	private String combo[] = null;

	private String strUnitId = "";

	private WebRowSet wsScheduleNo = null;
	private WebRowSet wsDeliveryMode = null;
	private WebRowSet wsScheduleItemList = null;
	private WebRowSet wsUnitList = null;
	private WebRowSet wsManufacturer = null;
	private WebRowSet wsRateUnit = null;
	private WebRowSet RecievedByWS=null;
	private String[] strReceivedQty = null;
	private String[] strReceivedUnitId = null;

	private String[] strItemDtls = null;

	private String strReceivedBy = "";
	private String strRemarks = "";

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
	private String strAcceptedQuantityView = "0 /";
	private String strBreakageQuantity = "0";
	private String strBreakageQuantityUnitId = "0";
	private String strBreakageQuantityView = "0 /";
	private String strRejectedQuantity = "0";
	private String strRejectedQuantityUnitId = "0";
	private String strRejectedQuantityView = "0 /";
	private String strOrderedQuantityView = "0 /";
	private String strExcessQty = "0";
	private String strExcessQtyUnitId = "0";
	private String strVerifiedQuantity = "0";
	private String strVerifiedQuantityUnitId = "";
	private String strVerifiedQuantityView = "0 /";
	private String strVerifiedQuantityInBaseVal = "0";
	private String strPreviousExcessQtyView = "";
	private String strSalePrice = "0";
	private String strSalePriceUnitId = "0";

	private String strSupplierReceiptNo = "0";
	private String strSupplierReceiptDate = "";

	private String strCommitteeType = "0";
	private WebRowSet wsCommitteeType = null;
	private WebRowSet wsCommitteeMemberList = null;
	
	private String[] strCommitteeMemberHidden = null;
	private String[] strMemberRecommendation = null;

	private String isBatchReq = "";
	private String isExpirtReq = "";

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
	private String strOtherDeliveryModeFlg;
	private String strOtherDeliveryModeTxtValue;
	private String strDeliveryModeText;

	private String strRackNumber;
	private String strCompositeUnitId;
	private String strCompRateUnitId;
	private String strDummySalePrice;
	private String strQcTypeFlg;
	private String  isTestReport;
	private String  strReportNumber;
	private String  strReportDate;
	private String  isGoodCond;
	private String  isNotForSale;
	private String  isGenricName;
	private String  isBrandName;
	private String  isMRPPrint;
	
	private String strItemId="0";
	public WebRowSet wsPrintItemDtls;
	
	private String strSupplierInvNo = "0"; 
	private String strSupplierInvDate ; 
					
		public String getStrSupplierInvNo() {
			return strSupplierInvNo;
		}
		public void setStrSupplierInvNo(String strSupplierInvNo) {
			this.strSupplierInvNo = strSupplierInvNo;
		}
		public String getStrSupplierInvDate() {
			return strSupplierInvDate;
		}
		public void setStrSupplierInvDate(String strSupplierInvDate) {
			this.strSupplierInvDate = strSupplierInvDate;
		}
		
	public WebRowSet getWsPrintItemDtls() {
		return wsPrintItemDtls;
	}
	public void setWsPrintItemDtls(WebRowSet wsPrintItemDtls) {
		this.wsPrintItemDtls = wsPrintItemDtls;
	}
	public String getStrItemId() {
		return strItemId;
	}
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}
	private String  strTestReportFlg;
	private String  strMedicienCondFlg;
	private String  strGovtSupplyFlg;
	private String  strMedicineTypeFlg;
	private String  strMrpPrintedFlg;
	private String strSupplierPerformanceInfo;
	private String strSupplierPerformanceFlag;
	private String strDrugTotCost;
    private String strPageNumber;
    private String strDeliveryModeTextValue;
    private WebRowSet wsReceivedItemDtls = null;
    private WebRowSet wsChallanDtls = null;
    private WebRowSet wsPODtls = null;
    private WebRowSet wsVerifiedItemDtls = null;
    private WebRowSet wsNewReceivedItemDtls = null;
    

    public WebRowSet getWsNewReceivedItemDtls() {
		return wsNewReceivedItemDtls;
	}
	public void setWsNewReceivedItemDtls(WebRowSet wsNewReceivedItemDtls) {
		this.wsNewReceivedItemDtls = wsNewReceivedItemDtls;
	}
    
	public WebRowSet getWsVerifiedItemDtls() {
		return wsVerifiedItemDtls;
	}
	public void setWsVerifiedItemDtls(WebRowSet wsVerifiedItemDtls) {
		this.wsVerifiedItemDtls = wsVerifiedItemDtls;
	}
	public WebRowSet getWsPODtls() {
		return wsPODtls;
	}
	public void setWsPODtls(WebRowSet wsPODtls) {
		this.wsPODtls = wsPODtls;
	}
	public String getStrPageNumber() {
		return strPageNumber;
	}
	public void setStrPageNumber(String strPageNumber) {
		this.strPageNumber = strPageNumber;
	}
	
	
	
	public String getStrDrugTotCost() {
		return strDrugTotCost;
	}
	public void setStrDrugTotCost(String strDrugTotCost) {
		this.strDrugTotCost = strDrugTotCost;
	}
	public String getStrSupplierPerformanceInfo() {
		return strSupplierPerformanceInfo;
	}
	public void setStrSupplierPerformanceInfo(String strSupplierPerformanceInfo) {
		this.strSupplierPerformanceInfo = strSupplierPerformanceInfo;
	}
	public String getIsTestReport() {
		return isTestReport;
	}
	public void setIsTestReport(String isTestReport) {
		this.isTestReport = isTestReport;
	}
	public String getStrReportNumber() {
		return strReportNumber;
	}
	public void setStrReportNumber(String strReportNumber) {
		this.strReportNumber = strReportNumber;
	}
	public String getStrReportDate() {
		return strReportDate;
	}
	public void setStrReportDate(String strReportDate) {
		this.strReportDate = strReportDate;
	}
	public String getIsGoodCond() {
		return isGoodCond;
	}
	public void setIsGoodCond(String isGoodCond) {
		this.isGoodCond = isGoodCond;
	}
	public String getIsNotForSale() {
		return isNotForSale;
	}
	public void setIsNotForSale(String isNotForSale) {
		this.isNotForSale = isNotForSale;
	}
	public String getIsGenricName() {
		return isGenricName;
	}
	public void setIsGenricName(String isGenricName) {
		this.isGenricName = isGenricName;
	}
	public String getIsBrandName() {
		return isBrandName;
	}
	public void setIsBrandName(String isBrandName) {
		this.isBrandName = isBrandName;
	}
	public String getIsMRPPrint() {
		return isMRPPrint;
	}
	public void setIsMRPPrint(String isMRPPrint) {
		this.isMRPPrint = isMRPPrint;
	}
	public String getStrDummySalePrice() {
		return strDummySalePrice;
	}
	public void setStrDummySalePrice(String strDummySalePrice) {
		this.strDummySalePrice = strDummySalePrice;
	}
	public String getStrCompRateUnitId() {
		return strCompRateUnitId;
	}
	public void setStrCompRateUnitId(String strCompRateUnitId) {
		this.strCompRateUnitId = strCompRateUnitId;
	}
	public String getStrCompositeUnitId() {
		return strCompositeUnitId;
	}
	public void setStrCompositeUnitId(String strCompositeUnitId) {
		this.strCompositeUnitId = strCompositeUnitId;
	}
	public String getStrRackNumber() {
		return strRackNumber;
	}
	public void setStrRackNumber(String strRackNumber) {
		this.strRackNumber = strRackNumber;
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

	public String getStrReceivedQuantity() {
		return strReceivedQuantity;
	}

	public void setStrReceivedQuantity(String strReceivedQuantity) {
		this.strReceivedQuantity = strReceivedQuantity;
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

	public String getStrUnitId() {
		return strUnitId;
	}

	public void setStrUnitId(String strUnitId) {
		this.strUnitId = strUnitId;
	}

	public String getStrSeatId() {
		return strSeatId;
	}

	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
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

	public String getStrPoStoreId() {
		return strPoStoreId;
	}

	public void setStrPoStoreId(String strPoStoreId) {
		this.strPoStoreId = strPoStoreId;
	}

	public WebRowSet getWsScheduleNo() {
		return wsScheduleNo;
	}

	public void setWsScheduleNo(WebRowSet wsScheduleNo) {
		this.wsScheduleNo = wsScheduleNo;
	}

	public WebRowSet getWsDeliveryMode() {
		return wsDeliveryMode;
	}

	public void setWsDeliveryMode(WebRowSet wsDeliveryMode) {
		this.wsDeliveryMode = wsDeliveryMode;
	}

	public WebRowSet getWsScheduleItemList() {
		return wsScheduleItemList;
	}

	public void setWsScheduleItemList(WebRowSet wsScheduleItemList) {
		this.wsScheduleItemList = wsScheduleItemList;
	}

	public WebRowSet getWsUnitList() {
		return wsUnitList;
	}

	public void setWsUnitList(WebRowSet wsUnitList) {
		this.wsUnitList = wsUnitList;
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

	public String getStrFinancialStartDate() {
		return strFinancialStartDate;
	}

	public void setStrFinancialStartDate(String strFinancialStartDate) {
		this.strFinancialStartDate = strFinancialStartDate;
	}

	public String getStrFinancialEndDate() {
		return strFinancialEndDate;
	}

	public void setStrFinancialEndDate(String strFinancialEndDate) {
		this.strFinancialEndDate = strFinancialEndDate;
	}

	public String[] getStrItemDtls() {
		return strItemDtls;
	}

	public void setStrItemDtls(String[] strItemDtls) {
		this.strItemDtls = strItemDtls;
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

	public WebRowSet getWsManufacturer() {
		return wsManufacturer;
	}

	public void setWsManufacturer(WebRowSet wsManufacturer) {
		this.wsManufacturer = wsManufacturer;
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

	public WebRowSet getWsRateUnit() {
		return wsRateUnit;
	}

	public void setWsRateUnit(WebRowSet wsRateUnit) {
		this.wsRateUnit = wsRateUnit;
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

	public WebRowSet getWsCommitteeType() {
		return wsCommitteeType;
	}

	public void setWsCommitteeType(WebRowSet wsCommitteeType) {
		this.wsCommitteeType = wsCommitteeType;
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

	public WebRowSet getWsCommitteeMemberList() {
		return wsCommitteeMemberList;
	}

	public void setWsCommitteeMemberList(WebRowSet wsCommitteeMemberList) {
		this.wsCommitteeMemberList = wsCommitteeMemberList;
	}

		public String getStrChallanCount() {
		return strChallanCount;
	}

	public void setStrChallanCount(String strChallanCount) {
		this.strChallanCount = strChallanCount;
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

	public String getStrPoItemCount() {
		return strPoItemCount;
	}

	public void setStrPoItemCount(String strPoItemCount) {
		this.strPoItemCount = strPoItemCount;
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

	public WebRowSet getRecievedByWS() {
		return RecievedByWS;
	}

	public void setRecievedByWS(WebRowSet recievedByWS) {
		RecievedByWS = recievedByWS;
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
	public String getStrOtherDeliveryModeFlg() {
		return strOtherDeliveryModeFlg;
	}
	public void setStrOtherDeliveryModeFlg(String strOtherDeliveryModeFlg) {
		this.strOtherDeliveryModeFlg = strOtherDeliveryModeFlg;
	}
	public String getStrOtherDeliveryModeTxtValue() {
		return strOtherDeliveryModeTxtValue;
	}
	public void setStrOtherDeliveryModeTxtValue(String strOtherDeliveryModeTxtValue) {
		this.strOtherDeliveryModeTxtValue = strOtherDeliveryModeTxtValue;
	}
	public String getStrDeliveryModeText() {
		return strDeliveryModeText;
	}
	public void setStrDeliveryModeText(String strDeliveryModeText) {
		this.strDeliveryModeText = strDeliveryModeText;
	}
	public String getStrTmpChkVal() {
		return strTmpChkVal;
	}
	public void setStrTmpChkVal(String strTmpChkVal) {
		this.strTmpChkVal = strTmpChkVal;
	}
	public String getStrQcTypeFlg() {
		return strQcTypeFlg;
	}
	public void setStrQcTypeFlg(String strQcTypeFlg) {
		this.strQcTypeFlg = strQcTypeFlg;
	}
	public String getStrTestReportFlg() {
		return strTestReportFlg;
	}
	public void setStrTestReportFlg(String strTestReportFlg) {
		this.strTestReportFlg = strTestReportFlg;
	}
	public String getStrMedicienCondFlg() {
		return strMedicienCondFlg;
	}
	public void setStrMedicienCondFlg(String strMedicienCondFlg) {
		this.strMedicienCondFlg = strMedicienCondFlg;
	}
	public String getStrGovtSupplyFlg() {
		return strGovtSupplyFlg;
	}
	public void setStrGovtSupplyFlg(String strGovtSupplyFlg) {
		this.strGovtSupplyFlg = strGovtSupplyFlg;
	}
	public String getStrMedicineTypeFlg() {
		return strMedicineTypeFlg;
	}
	public void setStrMedicineTypeFlg(String strMedicineTypeFlg) {
		this.strMedicineTypeFlg = strMedicineTypeFlg;
	}
	public String getStrMrpPrintedFlg() {
		return strMrpPrintedFlg;
	}
	public void setStrMrpPrintedFlg(String strMrpPrintedFlg) {
		this.strMrpPrintedFlg = strMrpPrintedFlg;
	}
	public String getStrSupplierPerformanceFlag() {
		return strSupplierPerformanceFlag;
	}
	public void setStrSupplierPerformanceFlag(String strSupplierPerformanceFlag) {
		this.strSupplierPerformanceFlag = strSupplierPerformanceFlag;
	}
	public String[] getCombo() {
		return combo;
	}
	public void setCombo(String[] combo) {
		this.combo = combo;
	}
	public String getStrDeliveryModeTextValue() {
		return strDeliveryModeTextValue;
	}
	public void setStrDeliveryModeTextValue(String strDeliveryModeTextValue) {
		this.strDeliveryModeTextValue = strDeliveryModeTextValue;
	}
	public WebRowSet getWsChallanDtls() {
		return wsChallanDtls;
	}
	public void setWsChallanDtls(WebRowSet wsChallanDtls) {
		this.wsChallanDtls = wsChallanDtls;
	}
	public WebRowSet getWsReceivedItemDtls() {
		return wsReceivedItemDtls;
	}
	public void setWsReceivedItemDtls(WebRowSet wsReceivedItemDtls) {
		this.wsReceivedItemDtls = wsReceivedItemDtls;
	}

}
