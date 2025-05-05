/**
 * 
 */
package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.TransferObject;

/**
 * Developer : Anshul Jindal 
 * Version : 1.0 
 * Date : 27/Apr/2009
 * 
 */
public class IndentForImportItemsVO implements TransferObject{
	

	private static final long serialVersionUID = 02L;
	private String strMsgType="";
	private String strMsgString="";
	
	private String strRemaingStockDtl = "";
	private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
	private String strCtDate = "";
	private String strHospitalCode = "";
	private String strIsValid = "";
	private String strSeatId = "";
	
	private String strDeliveryDate="";
	private String strReturnTypeCmb="";
	
	private String strHiddenStockPosition="";
	private String strHiddenStockDtl ="";
	
	private String strStoreId="";
	private String strStoreTypeId="";
	
	private String strStoreName="";
	private String strReqDate="";
	private String strItemCategoryNo="";
	private String strItemCategory="";
	
	private String strStockDtl="";
	private String strFinancialStartYear = "";
	private String strFinancialEndYear = "";
	
	private String strToStoreCombo ="";
	
	private String strGrantTypeCode="";
	private String strGrantTypeNameCmb="";
	
	private String strIsUrgent="";
	
	private String strGroupId="";
	private String strGroupNameCmb="";
	
	private String strSubGroupId="";
	private String strSubGroupNameCmb="";
	
	private String strItemId="";
	private String strItemNameCmb="";
	
	private String strBrandId=""; 
	private String strBrandNameCmb=""; 
	
	private String strInhandQty="";
	private String strInhandQtyUnit="";
	private String strReqType ="";
	private String strConsumedQty="";
	private String strConsumedQtyUnit="";
	
	private String strManufacturerName="";
	
	private String strCurrencyId="";
	private String strCurrencyNameCmb="";
	
	
	private String StrItemUnitId=""; 
	private String strApproxRate="";
	private String strApproxRateUnitId="";
	private String strApproxRateUnitCmb="";
	
	private String strSupplierId="";
	private String strSupplierNameCmb="";
	
	private String strSupplierAddress="";
	
	private String strPInvoiceRecvd="";
	
	private String strIsLowestQuotation="";
	private String strQuotationJustification="";
	
	private String strWarrantyPeriod="0";
	private String strIsIntallationReq="0";
	private String strInstalationApproxCharges="0";
	
	private String strPurposeId="";
	private String strPurposeCmb="";
	private String strOtherPurpose="";
	
	private String strJustification="";
	

	
	private String  strQunatityReq="";

	private String strQtyUnitName ="";

	private String strQtyUnitCmb ="";
	
	
	
	private String strPath="";  
	
	private WebRowSet  WSGrantTypeNameCmb = null;
	private WebRowSet  WSGroupNameCmb=null;
	private WebRowSet  WSSubGroupNameCmb=null;
	private WebRowSet  WSItemNameCmb=null;
	private WebRowSet  WSBrandNameCmb=null;
	private WebRowSet  WSCurrencyNameCmb=null;
	private WebRowSet  WSApproxRateUnitCmb=null;
	private WebRowSet  WSSupplierNameCmb=null;
	private WebRowSet  WSPurposeCmb=null;
	
	/**
	 * @return the strMsgType
	 */
	public String getStrMsgType() {
		return strMsgType;
	}
	/**
	 * @param strMsgType the strMsgType to set
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}
	/**
	 * @return the strMsgString
	 */
	public String getStrMsgString() {
		return strMsgString;
	}
	/**
	 * @param strMsgString the strMsgString to set
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}
	/**
	 * @return the strErr
	 */
	public String getStrErr() {
		return strErr;
	}
	/**
	 * @param strErr the strErr to set
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
	 * @param strMsg the strMsg to set
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
	 * @param strWarning the strWarning to set
	 */
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}
	/**
	 * @return the strCtDate
	 */
	public String getStrCtDate() {
		return strCtDate;
	}
	/**
	 * @param strCtDate the strCtDate to set
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}
	/**
	 * @return the strHospitalCode
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	/**
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	/**
	 * @return the strIsValid
	 */
	public String getStrIsValid() {
		return strIsValid;
	}
	/**
	 * @param strIsValid the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}
	/**
	 * @return the strSeatId
	 */
	public String getStrSeatId() {
		return strSeatId;
	}
	/**
	 * @param strSeatId the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	/**
	 * @return the strStoreId
	 */
	public String getStrStoreId() {
		return strStoreId;
	}
	/**
	 * @param strStoreId the strStoreId to set
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
	 * @param strStoreName the strStoreName to set
	 */
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	/**
	 * @return the strReqDate
	 */
	public String getStrReqDate() {
		return strReqDate;
	}
	/**
	 * @param strReqDate the strReqDate to set
	 */
	public void setStrReqDate(String strReqDate) {
		this.strReqDate = strReqDate;
	}
	/**
	 * @return the strItemCategory
	 */
	public String getStrItemCategory() {
		return strItemCategory;
	}
	/**
	 * @param strItemCategory the strItemCategory to set
	 */
	public void setStrItemCategory(String strItemCategory) {
		this.strItemCategory = strItemCategory;
	}
	/**
	 * @return the strGrantTypeCode
	 */
	public String getStrGrantTypeCode() {
		return strGrantTypeCode;
	}
	/**
	 * @param strGrantTypeCode the strGrantTypeCode to set
	 */
	public void setStrGrantTypeCode(String strGrantTypeCode) {
		this.strGrantTypeCode = strGrantTypeCode;
	}
	/**
	 * @return the strGrantTypeNameCmb
	 */
	public String getStrGrantTypeNameCmb() {
		return strGrantTypeNameCmb;
	}
	/**
	 * @param strGrantTypeNameCmb the strGrantTypeNameCmb to set
	 */
	public void setStrGrantTypeNameCmb(String strGrantTypeNameCmb) {
		this.strGrantTypeNameCmb = strGrantTypeNameCmb;
	}
	/**
	 * @return the strIsUrgent
	 */
	public String getStrIsUrgent() {
		return strIsUrgent;
	}
	/**
	 * @param strIsUrgent the strIsUrgent to set
	 */
	public void setStrIsUrgent(String strIsUrgent) {
		this.strIsUrgent = strIsUrgent;
	}
	/**
	 * @return the strGroupId
	 */
	public String getStrGroupId() {
		return strGroupId;
	}
	/**
	 * @param strGroupId the strGroupId to set
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}
	/**
	 * @return the strGroupNameCmb
	 */
	public String getStrGroupNameCmb() {
		return strGroupNameCmb;
	}
	/**
	 * @param strGroupNameCmb the strGroupNameCmb to set
	 */
	public void setStrGroupNameCmb(String strGroupNameCmb) {
		this.strGroupNameCmb = strGroupNameCmb;
	}
	/**
	 * @return the strSubGroupId
	 */
	public String getStrSubGroupId() {
		return strSubGroupId;
	}
	/**
	 * @param strSubGroupId the strSubGroupId to set
	 */
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}
	/**
	 * @return the strSubGroupNameCmb
	 */
	public String getStrSubGroupNameCmb() {
		return strSubGroupNameCmb;
	}
	/**
	 * @param strSubGroupNameCmb the strSubGroupNameCmb to set
	 */
	public void setStrSubGroupNameCmb(String strSubGroupNameCmb) {
		this.strSubGroupNameCmb = strSubGroupNameCmb;
	}
	/**
	 * @return the strItemId
	 */
	public String getStrItemId() {
		return strItemId;
	}
	/**
	 * @param strItemId the strItemId to set
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}
	/**
	 * @return the strItemNameCmb
	 */
	public String getStrItemNameCmb() {
		return strItemNameCmb;
	}
	/**
	 * @param strItemNameCmb the strItemNameCmb to set
	 */
	public void setStrItemNameCmb(String strItemNameCmb) {
		this.strItemNameCmb = strItemNameCmb;
	}
	/**
	 * @return the strBrandId
	 */
	public String getStrBrandId() {
		return strBrandId;
	}
	/**
	 * @param strBrandId the strBrandId to set
	 */
	public void setStrBrandId(String strBrandId) {
		this.strBrandId = strBrandId;
	}
	/**
	 * @return the strBrandNameCmb
	 */
	public String getStrBrandNameCmb() {
		return strBrandNameCmb;
	}
	/**
	 * @param strBrandNameCmb the strBrandNameCmb to set
	 */
	public void setStrBrandNameCmb(String strBrandNameCmb) {
		this.strBrandNameCmb = strBrandNameCmb;
	}
	/**
	 * @return the strInhandQty
	 */
	public String getStrInhandQty() {
		return strInhandQty;
	}
	/**
	 * @param strInhandQty the strInhandQty to set
	 */
	public void setStrInhandQty(String strInhandQty) {
		this.strInhandQty = strInhandQty;
	}
	/**
	 * @return the strInhandQtyUnit
	 */
	public String getStrInhandQtyUnit() {
		return strInhandQtyUnit;
	}
	/**
	 * @param strInhandQtyUnit the strInhandQtyUnit to set
	 */
	public void setStrInhandQtyUnit(String strInhandQtyUnit) {
		this.strInhandQtyUnit = strInhandQtyUnit;
	}
	/**
	 * @return the strConsumedQty
	 */
	public String getStrConsumedQty() {
		return strConsumedQty;
	}
	/**
	 * @param strConsumedQty the strConsumedQty to set
	 */
	public void setStrConsumedQty(String strConsumedQty) {
		this.strConsumedQty = strConsumedQty;
	}
	/**
	 * @return the strConsumedQtyUnit
	 */
	public String getStrConsumedQtyUnit() {
		return strConsumedQtyUnit;
	}
	/**
	 * @param strConsumedQtyUnit the strConsumedQtyUnit to set
	 */
	public void setStrConsumedQtyUnit(String strConsumedQtyUnit) {
		this.strConsumedQtyUnit = strConsumedQtyUnit;
	}
	/**
	 * @return the strManufacturerName
	 */
	public String getStrManufacturerName() {
		return strManufacturerName;
	}
	/**
	 * @param strManufacturerName the strManufacturerName to set
	 */
	public void setStrManufacturerName(String strManufacturerName) {
		this.strManufacturerName = strManufacturerName;
	}
	/**
	 * @return the strCurrencyId
	 */
	public String getStrCurrencyId() {
		return strCurrencyId;
	}
	/**
	 * @param strCurrencyId the strCurrencyId to set
	 */
	public void setStrCurrencyId(String strCurrencyId) {
		this.strCurrencyId = strCurrencyId;
	}
	/**
	 * @return the strCurrencyNameCmb
	 */
	public String getStrCurrencyNameCmb() {
		return strCurrencyNameCmb;
	}
	/**
	 * @param strCurrencyNameCmb the strCurrencyNameCmb to set
	 */
	public void setStrCurrencyNameCmb(String strCurrencyNameCmb) {
		this.strCurrencyNameCmb = strCurrencyNameCmb;
	}
	/**
	 * @return the strApproxRate
	 */
	public String getStrApproxRate() {
		return strApproxRate;
	}
	/**
	 * @param strApproxRate the strApproxRate to set
	 */
	public void setStrApproxRate(String strApproxRate) {
		this.strApproxRate = strApproxRate;
	}
	/**
	 * @return the strApproxRateUnitId
	 */
	public String getStrApproxRateUnitId() {
		return strApproxRateUnitId;
	}
	/**
	 * @param strApproxRateUnitId the strApproxRateUnitId to set
	 */
	public void setStrApproxRateUnitId(String strApproxRateUnitId) {
		this.strApproxRateUnitId = strApproxRateUnitId;
	}
	/**
	 * @return the strApproxRateUnitCmb
	 */
	public String getStrApproxRateUnitCmb() {
		return strApproxRateUnitCmb;
	}
	/**
	 * @param strApproxRateUnitCmb the strApproxRateUnitCmb to set
	 */
	public void setStrApproxRateUnitCmb(String strApproxRateUnitCmb) {
		this.strApproxRateUnitCmb = strApproxRateUnitCmb;
	}
	/**
	 * @return the strSupplierId
	 */
	public String getStrSupplierId() {
		return strSupplierId;
	}
	/**
	 * @param strSupplierId the strSupplierId to set
	 */
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}
	/**
	 * @return the strSupplierNameCmb
	 */
	public String getStrSupplierNameCmb() {
		return strSupplierNameCmb;
	}
	/**
	 * @param strSupplierNameCmb the strSupplierNameCmb to set
	 */
	public void setStrSupplierNameCmb(String strSupplierNameCmb) {
		this.strSupplierNameCmb = strSupplierNameCmb;
	}
	/**
	 * @return the strSupplierAddress
	 */
	public String getStrSupplierAddress() {
		return strSupplierAddress;
	}
	/**
	 * @param strSupplierAddress the strSupplierAddress to set
	 */
	public void setStrSupplierAddress(String strSupplierAddress) {
		this.strSupplierAddress = strSupplierAddress;
	}
	/**
	 * @return the strIsLowestQuotation
	 */
	public String getStrIsLowestQuotation() {
		return strIsLowestQuotation;
	}
	/**
	 * @param strIsLowestQuotation the strIsLowestQuotation to set
	 */
	public void setStrIsLowestQuotation(String strIsLowestQuotation) {
		this.strIsLowestQuotation = strIsLowestQuotation;
	}
	/**
	 * @return the strQuotationJustification
	 */
	public String getStrQuotationJustification() {
		return strQuotationJustification;
	}
	/**
	 * @param strQuotationJustification the strQuotationJustification to set
	 */
	public void setStrQuotationJustification(String strQuotationJustification) {
		this.strQuotationJustification = strQuotationJustification;
	}
	/**
	 * @return the strWarrantyPeriod
	 */
	public String getStrWarrantyPeriod() {
		return strWarrantyPeriod;
	}
	/**
	 * @param strWarrantyPeriod the strWarrantyPeriod to set
	 */
	public void setStrWarrantyPeriod(String strWarrantyPeriod) {
		this.strWarrantyPeriod = strWarrantyPeriod;
	}
	/**
	 * @return the strIsIntallationReq
	 */
	public String getStrIsIntallationReq() {
		return strIsIntallationReq;
	}
	/**
	 * @param strIsIntallationReq the strIsIntallationReq to set
	 */
	public void setStrIsIntallationReq(String strIsIntallationReq) {
		this.strIsIntallationReq = strIsIntallationReq;
	}
	/**
	 * @return the strInstalationApproxCharges
	 */
	public String getStrInstalationApproxCharges() {
		return strInstalationApproxCharges;
	}
	/**
	 * @param strInstalationApproxCharges the strInstalationApproxCharges to set
	 */
	public void setStrInstalationApproxCharges(String strInstalationApproxCharges) {
		this.strInstalationApproxCharges = strInstalationApproxCharges;
	}
	/**
	 * @return the strPurposeId
	 */
	public String getStrPurposeId() {
		return strPurposeId;
	}
	/**
	 * @param strPurposeId the strPurposeId to set
	 */
	public void setStrPurposeId(String strPurposeId) {
		this.strPurposeId = strPurposeId;
	}
	/**
	 * @return the strPurposeCmb
	 */
	public String getStrPurposeCmb() {
		return strPurposeCmb;
	}
	/**
	 * @param strPurposeCmb the strPurposeCmb to set
	 */
	public void setStrPurposeCmb(String strPurposeCmb) {
		this.strPurposeCmb = strPurposeCmb;
	}
	/**
	 * @return the strOtherPurpose
	 */
	public String getStrOtherPurpose() {
		return strOtherPurpose;
	}
	/**
	 * @param strOtherPurpose the strOtherPurpose to set
	 */
	public void setStrOtherPurpose(String strOtherPurpose) {
		this.strOtherPurpose = strOtherPurpose;
	}
	/**
	 * @return the strJustification
	 */
	public String getStrJustification() {
		return strJustification;
	}
	/**
	 * @param strJustification the strJustification to set
	 */
	public void setStrJustification(String strJustification) {
		this.strJustification = strJustification;
	}
	/**
	 * @return the strPath
	 */
	public String getStrPath() {
		return strPath;
	}
	/**
	 * @param strPath the strPath to set
	 */
	public void setStrPath(String strPath) {
		this.strPath = strPath;
	}
	/**
	 * @return the wSGrantTypeNameCmb
	 */
	public WebRowSet getWSGrantTypeNameCmb() {
		return WSGrantTypeNameCmb;
	}
	/**
	 * @param grantTypeNameCmb the wSGrantTypeNameCmb to set
	 */
	public void setWSGrantTypeNameCmb(WebRowSet grantTypeNameCmb) {
		WSGrantTypeNameCmb = grantTypeNameCmb;
	}
	/**
	 * @return the wSGroupNameCmb
	 */
	public WebRowSet getWSGroupNameCmb() {
		return WSGroupNameCmb;
	}
	/**
	 * @param groupNameCmb the wSGroupNameCmb to set
	 */
	public void setWSGroupNameCmb(WebRowSet groupNameCmb) {
		WSGroupNameCmb = groupNameCmb;
	}
	/**
	 * @return the wSSubGroupNameCmb
	 */
	public WebRowSet getWSSubGroupNameCmb() {
		return WSSubGroupNameCmb;
	}
	/**
	 * @param subGroupNameCmb the wSSubGroupNameCmb to set
	 */
	public void setWSSubGroupNameCmb(WebRowSet subGroupNameCmb) {
		WSSubGroupNameCmb = subGroupNameCmb;
	}
	/**
	 * @return the wSItemNameCmb
	 */
	public WebRowSet getWSItemNameCmb() {
		return WSItemNameCmb;
	}
	/**
	 * @param itemNameCmb the wSItemNameCmb to set
	 */
	public void setWSItemNameCmb(WebRowSet itemNameCmb) {
		WSItemNameCmb = itemNameCmb;
	}
	/**
	 * @return the wSBrandNameCmb
	 */
	public WebRowSet getWSBrandNameCmb() {
		return WSBrandNameCmb;
	}
	/**
	 * @param brandNameCmb the wSBrandNameCmb to set
	 */
	public void setWSBrandNameCmb(WebRowSet brandNameCmb) {
		WSBrandNameCmb = brandNameCmb;
	}
	/**
	 * @return the wSCurrencyNameCmb
	 */
	public WebRowSet getWSCurrencyNameCmb() {
		return WSCurrencyNameCmb;
	}
	/**
	 * @param currencyNameCmb the wSCurrencyNameCmb to set
	 */
	public void setWSCurrencyNameCmb(WebRowSet currencyNameCmb) {
		WSCurrencyNameCmb = currencyNameCmb;
	}
	/**
	 * @return the wSApproxRateUnitCmb
	 */
	public WebRowSet getWSApproxRateUnitCmb() {
		return WSApproxRateUnitCmb;
	}
	/**
	 * @param approxRateUnitCmb the wSApproxRateUnitCmb to set
	 */
	public void setWSApproxRateUnitCmb(WebRowSet approxRateUnitCmb) {
		WSApproxRateUnitCmb = approxRateUnitCmb;
	}
	/**
	 * @return the wSSupplierNameCmb
	 */
	public WebRowSet getWSSupplierNameCmb() {
		return WSSupplierNameCmb;
	}
	/**
	 * @param supplierNameCmb the wSSupplierNameCmb to set
	 */
	public void setWSSupplierNameCmb(WebRowSet supplierNameCmb) {
		WSSupplierNameCmb = supplierNameCmb;
	}
	/**
	 * @return the wSPurposeCmb
	 */
	public WebRowSet getWSPurposeCmb() {
		return WSPurposeCmb;
	}
	/**
	 * @param purposeCmb the wSPurposeCmb to set
	 */
	public void setWSPurposeCmb(WebRowSet purposeCmb) {
		WSPurposeCmb = purposeCmb;
	}
	/**
	 * @return the strItemCategoryNo
	 */
	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}
	/**
	 * @param strItemCategoryNo the strItemCategoryNo to set
	 */
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}
	/**
	 * @return the strPInvoiceRecvd
	 */
	public String getStrPInvoiceRecvd() {
		return strPInvoiceRecvd;
	}
	/**
	 * @param strPInvoiceRecvd the strPInvoiceRecvd to set
	 */
	public void setStrPInvoiceRecvd(String strPInvoiceRecvd) {
		this.strPInvoiceRecvd = strPInvoiceRecvd;
	}
	/**
	 * @return the strStoreTypeId
	 */
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}
	/**
	 * @param strStoreTypeId the strStoreTypeId to set
	 */
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}
	/**
	 * @return the strItemUnitId
	 */
	public String getStrItemUnitId() {
		return StrItemUnitId;
	}
	/**
	 * @param strItemUnitId the strItemUnitId to set
	 */
	public void setStrItemUnitId(String strItemUnitId) {
		StrItemUnitId = strItemUnitId;
	}
	/**
	 * @return the strStockDtl
	 */
	public String getStrStockDtl() {
		return strStockDtl;
	}
	/**
	 * @param strStockDtl the strStockDtl to set
	 */
	public void setStrStockDtl(String strStockDtl) {
		this.strStockDtl = strStockDtl;
	}
	public String getStrReqType() {
		return strReqType;
	}
	public void setStrReqType(String strReqType) {
		this.strReqType = strReqType;
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
	public String getStrToStoreCombo() {
		return strToStoreCombo;
	}
	public void setStrToStoreCombo(String strToStoreCombo) {
		this.strToStoreCombo = strToStoreCombo;
	}
	public String getStrRemaingStockDtl() {
		return strRemaingStockDtl;
	}
	public void setStrRemaingStockDtl(String strRemaingStockDtl) {
		this.strRemaingStockDtl = strRemaingStockDtl;
	}
	public String getStrHiddenStockPosition() {
		return strHiddenStockPosition;
	}
	public void setStrHiddenStockPosition(String strHiddenStockPosition) {
		this.strHiddenStockPosition = strHiddenStockPosition;
	}
	public String getStrHiddenStockDtl() {
		return strHiddenStockDtl;
	}
	public void setStrHiddenStockDtl(String strHiddenStockDtl) {
		this.strHiddenStockDtl = strHiddenStockDtl;
	}
	public String getStrQunatityReq() {
		return strQunatityReq;
	}
	public void setStrQunatityReq(String strQunatityReq) {
		this.strQunatityReq = strQunatityReq;
	}
	public String getStrQtyUnitName() {
		return strQtyUnitName;
	}
	public void setStrQtyUnitName(String strQtyUnitName) {
		this.strQtyUnitName = strQtyUnitName;
	}
	public String getStrQtyUnitCmb() {
		return strQtyUnitCmb;
	}
	public void setStrQtyUnitCmb(String strQtyUnitCmb) {
		this.strQtyUnitCmb = strQtyUnitCmb;
	}
	public String getStrDeliveryDate() {
		return strDeliveryDate;
	}
	public void setStrDeliveryDate(String strDeliveryDate) {
		this.strDeliveryDate = strDeliveryDate;
	}
	public String getStrReturnTypeCmb() {
		return strReturnTypeCmb;
	}
	public void setStrReturnTypeCmb(String strReturnTypeCmb) {
		this.strReturnTypeCmb = strReturnTypeCmb;
	}

}
