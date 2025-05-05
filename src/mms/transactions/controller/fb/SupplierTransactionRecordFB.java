package mms.transactions.controller.fb;

import javax.sql.rowset.WebRowSet;

import org.apache.struts.action.ActionForm;

public class SupplierTransactionRecordFB extends ActionForm {
	
	private static final long serialVersionUID = 02L;
	
	private String strNormalMsg="";
	private String strErrMsg="";
	private String strWarningMsg="";
	
	private String strHospitalCode ="";
	private String strSeatId ="";
	
	private String strCtDate = "";

	private String strStoreId = "0";
	private String strItemCategoryId = "";
	
	/*	
	 
	<input type="hidden" name="hmode"/>
	<input type="hidden" name="strStoreName" value=""/>
	<input type="hidden" name="strItemCategoryName" value=""/>
	<input type="hidden" name="strItemCategoryHiddenId" value=""/>
	<input type="hidden" name="strStatus" value=""/>
	<input type="hidden"  name="strConfigIssueRate"  value="">
	<input type="hidden"  name="strPkey"  value="">
	<input type="hidden" name="strCurrentDate" value="${supplierTransactionRecordBean.strCurrentDate}" />
		
	*/
	
	private String strStoreName = "";
	private String strItemCategoryName = "";
	private String strItemCategoryHiddenId;
	private String strCurrentDate;
	private String strStatus = "0";
	private String strConfigIssueRate;
    private String strPkey;

//  HEADER START 
	private String strSupplierId;
	private String strManufacturerId;
	private String strDCNo; //DM No

	private String strLpoNo ; //PO NO 
	private String strPoDate; //PO DT 
	private String strChallanDate; // Challan\Indent Date
	
	private String strInvoiceNo; // Bill NO
	private String strInvoiceDate;// Bill DT
	private String strExpDeliveryDate;
	
	private String strInstituteId = "0";// Purchase Through
	private String strUcChk ;
//	HEADER END
	
//	COMBO VALUES property
	private String strSupplierCombo;
	private String strSuppliedByValues = "";
	private String strInstituteCombo;
	private String strItemBrandCombo;

//	WEBROWSET 

//	HIDDEN DRUG LIST COMBO START 
	private String[] strMultiRowItemId;
//	HIDDEN DRUG LIST COMBO END 

//	ADD ROW FUNCTION Array fields 
	private String[] strSearchDrug;
	private String[] strBrandIdTableArray; // This will store the hidden drug values
	private String[] strItemsIdTableArray; // This will store the hidden drug values
	private String[] strBatchNo;
	private String[] mfgDate;           
	private String[] expDate;           
	private String[] strPackSize;
    private String[] strPacksNo ;
    private String[] strPuRate;        
    private String[] strPurQty;        
    private String[] strGst;    
    private String[] strPuRateWitTax;  
    private String[] strAdm;         
    private String[] strCosttoPat;     
    private String[] strMarkCosttoPat;
    private String[] strDifference ;
    private String[] strTotalMRN ;

//  TOTAL ROW
	private String totalMarkCosttoPat;
	private String totalDifference;
	private String totalMRN;
	
	
	
	
	private String[] supplierName;      
	private String[] strbatchno;
    private String[] strAdmCharges;   
    private String[] strItemDetailsDrug;
	private String[] strDrugValue; 
    private String[] strBrandStringId;
    private String[] strDifferenceAmtSign;
    private String[] strItemOtherDtls = null;
	private String[] strItemPartDtls = null;
	private String[] starMRP;
	private String[] strParamCheck = null;
	private String[] strParamValue = null;
	private String[] strParamDtls = null;
	private String[] strParamStatus = null;
	private String[] strPackNo;
	private String[] strRatePack;
	private String[] strGST;
	private String[] strAdmchg;
	private String[] strTotalQty;
	
	
    private String strLECNo;
	private String strGroupId = "";
	private String strGroupCombo = "";
	private String strItemNameCombo = "";
	
	private String strItemHlp = "";
	private String strReceivedItemApprovedMode = "0";
	private String strReceivedItemRejectedMode = "0";
	private String strReceivedItemViewMode = "0";
	
	private String strStoreNameCombo = "";
	private String strItemCategoryCode = "";
	private String strItemCategoryCombo = "";
	private String strRequestType = "";
	private String strRemarks = "";
	private String strInstituteName = "";
	private String strInstituteValues = "";
	private String strFinancialStartYear = "";
	private String strFinancialEndYear = "";
	
	private WebRowSet wsReceivedItemList = null;
		
	private String strEffectiveFrom = "";
	private String strManufactureId = "";
	private String strManufactureName = "";
	private String strManufactureCombo = "";
	
	private String strSuppliedBy = "0";

	private String strUnitRateID = "";
	private String strUnitRateName = "";
	private String strUnitRateCombo = "";

	private String strUnitSaleID = "";
	private String strUnitSaleName = "";
	private String strUnitSaleCombo = "";

	private String strItemName = "";
	private String strItemId = "";

	private String strExpiryDate = "";
	private String strManufactureDate = "";
	private String strRate = "";
	private String strSalePrice = "";
	private String strIssueRateConfigFlg;
	private String strReceivedDate = "";

	
	private String strCurrencyCode = "0";
	private String strCurrencyCodeValues = "";
	private String strCurrencyValue = "1";
	private String strDefaultCurrencyCode = "0";
	
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
	
	private String strSerialNo = "0";
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
	
	private String strItemSpecification = "";
	private String strRegFlag = "";

	private String strRackNumber;
	private String strReceivedFromThirdPartyName;
	private String strMRPPrice = "";
	
	private String strGstTax = "";
	private String strAdminTax = "";
	private String strRatewithGst ="";
	private String strPendingDayEndDetailsTable;
	private String strMRP = "";
	
	
	
	private String strStockStatusCode = "";
	private String strIsValid = "";
	private String strReqTypeId = "";
	private String strItemCategoeryName;
	private String strPrintItemHlpDtl;
	private String strLPNo;
	private String strErr;
	private String strBrandId;
	private String strItemsId;
	private String strPrintDtls;
	
	public String getTotalMarkCosttoPat() {
		return totalMarkCosttoPat;
	}
	public void setTotalMarkCosttoPat(String totalMarkCosttoPat) {
		this.totalMarkCosttoPat = totalMarkCosttoPat;
	}
	public String getTotalDifference() {
		return totalDifference;
	}
	public void setTotalDifference(String totalDifference) {
		this.totalDifference = totalDifference;
	}
	public String getTotalMRN() {
		return totalMRN;
	}
	public void setTotalMRN(String totalMRN) {
		this.totalMRN = totalMRN;
	}
	public String[] getStrMarkCosttoPat() {
		return strMarkCosttoPat;
	}
	public void setStrMarkCosttoPat(String[] strMarkCosttoPat) {
		this.strMarkCosttoPat = strMarkCosttoPat;
	}
	public String[] getStrDifferenceAmtSign() {
		return strDifferenceAmtSign;
	}
	public void setStrDifferenceAmtSign(String[] strDifferenceAmtSign) {
		this.strDifferenceAmtSign = strDifferenceAmtSign;
	}
	public String getStrPkey() {
		return strPkey;
	}
	public void setStrPkey(String strPkey) {
		this.strPkey = strPkey;
	}
	public String getStrLECNo() {
		return strLECNo;
	}
	public void setStrLECNo(String strLECNo) {
		this.strLECNo = strLECNo;
	}
	public String[] getStrPacksNo() {
		return strPacksNo;
	}
	public void setStrPacksNo(String[] strPacksNo) {
		this.strPacksNo = strPacksNo;
	}
	public String[] getStrDifference() {
		return strDifference;
	}
	public void setStrDifference(String[] strDifference) {
		this.strDifference = strDifference;
	}
	public String[] getStrTotalMRN() {
		return strTotalMRN;
	}
	public void setStrTotalMRN(String[] strTotalMRN) {
		this.strTotalMRN = strTotalMRN;
	}
	public String getStrItemCategoryHiddenId() {
		return strItemCategoryHiddenId;
	}
	public void setStrItemCategoryHiddenId(String strItemCategoryHiddenId) {
		this.strItemCategoryHiddenId = strItemCategoryHiddenId;
	}
	public String[] getStrBrandIdTableArray() {
		return strBrandIdTableArray;
	}
	public void setStrBrandIdTableArray(String[] strBrandIdTableArray) {
		this.strBrandIdTableArray = strBrandIdTableArray;
	}
	public String[] getStrItemsIdTableArray() {
		return strItemsIdTableArray;
	}
	public void setStrItemsIdTableArray(String[] strItemsIdTableArray) {
		this.strItemsIdTableArray = strItemsIdTableArray;
	}
	public String[] getStrItemDetailsDrug() {
		return strItemDetailsDrug;
	}
	public void setStrItemDetailsDrug(String[] strItemDetailsDrug) {
		this.strItemDetailsDrug = strItemDetailsDrug;
	} 
    public String getStrItemsId() {
		return strItemsId;
	}
	public void setStrItemsId(String strItemsId) {
		this.strItemsId = strItemsId;
	}
	public String[] getStrBrandStringId() {
		return strBrandStringId;
	}
	public void setStrBrandStringId(String[] strBrandStringId) {
		this.strBrandStringId = strBrandStringId;
	}
	public String[] getStrDrugValue() {
		return strDrugValue;
	}
	public void setStrDrugValue(String[] strDrugValue) {
		this.strDrugValue = strDrugValue;
	}
    public String[] getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String[] supplierName) {
		this.supplierName = supplierName;
	}
	public String[] getMfgDate() {
		return mfgDate;
	}
	public void setMfgDate(String[] mfgDate) {
		this.mfgDate = mfgDate;
	}
	public String[] getExpDate() {
		return expDate;
	}
	public void setExpDate(String[] expDate) {
		this.expDate = expDate;
	}
	public String[] getStrPurQty() {
		return strPurQty;
	}
	public void setStrPurQty(String[] strPurQty) {
		this.strPurQty = strPurQty;
	}
	public String[] getStrGst() {
		return strGst;
	}
	public void setStrGst(String[] strGst) {
		this.strGst = strGst;
	}
	public String[] getStrAdmCharges() {
		return strAdmCharges;
	}
	public void setStrAdmCharges(String[] strAdmCharges) {
		this.strAdmCharges = strAdmCharges;
	}
	
	
	public String getStrMRP() {
		return strMRP;
	}
	public void setStrMRP(String strMRP) {
		this.strMRP = strMRP;
	}
	public String[] getStarMRP() {
		return starMRP;
	}
	public void setStarMRP(String[] starMRP) {
		this.starMRP = starMRP;
	}
	public String[] getStrSearchDrug() {
		return strSearchDrug;
	}
	public void setStrSearchDrug(String[] strSearchDrug) {
		this.strSearchDrug = strSearchDrug;
	}
	public String getStrStockStatusCode() {
		return strStockStatusCode;
	}
	public void setStrStockStatusCode(String strStockStatusCode) {
		this.strStockStatusCode = strStockStatusCode;
	}
	public String getStrIsValid() {
		return strIsValid;
	}
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}
	public String getStrReqTypeId() {
		return strReqTypeId;
	}
	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}
	public String getStrSupplierId() {
		return strSupplierId;
	}
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}
	public String getStrSupplierCombo() {
		return strSupplierCombo;
	}
	public void setStrSupplierCombo(String strSupplierCombo) {
		this.strSupplierCombo = strSupplierCombo;
	}
	public String getStrDCNo() {
		return strDCNo;
	}
	public void setStrDCNo(String strDCNo) {
		this.strDCNo = strDCNo;
	}
	public String getStrChallanDate() {
		return strChallanDate;
	}
	public void setStrChallanDate(String strChallanDate) {
		this.strChallanDate = strChallanDate;
	}
	public String getStrInvoiceNo() {
		return strInvoiceNo;
	}
	public void setStrInvoiceNo(String strInvoiceNo) {
		this.strInvoiceNo = strInvoiceNo;
	}
	public String getStrInvoiceDate() {
		return strInvoiceDate;
	}
	public void setStrInvoiceDate(String strInvoiceDate) {
		this.strInvoiceDate = strInvoiceDate;
	}
	public String[] getStrbatchno() {
		return strbatchno;
	}
	public void setStrbatchno(String[] strbatchno) {
		this.strbatchno = strbatchno;
	}
	public String[] getStrPackSize() {
		return strPackSize;
	}
	public void setStrPackSize(String[] strPackSize) {
		this.strPackSize = strPackSize;
	}
	public String[] getStrPackNo() {
		return strPackNo;
	}
	public void setStrPackNo(String[] strPackNo) {
		this.strPackNo = strPackNo;
	}
	public String[] getStrRatePack() {
		return strRatePack;
	}
	public void setStrRatePack(String[] strRatePack) {
		this.strRatePack = strRatePack;
	}
	public String[] getStrGST() {
		return strGST;
	}
	public void setStrGST(String[] strGST) {
		this.strGST = strGST;
	}
	public String[] getStrAdmchg() {
		return strAdmchg;
	}
	public void setStrAdmchg(String[] strAdmchg) {
		this.strAdmchg = strAdmchg;
	}
	public String[] getStrTotalQty() {
		return strTotalQty;
	}
	public void setStrTotalQty(String[] strTotalQty) {
		this.strTotalQty = strTotalQty;
	}
	public String[] getStrPuRate() {
		return strPuRate;
	}
	public void setStrPuRate(String[] strPuRate) {
		this.strPuRate = strPuRate;
	}
	public String[] getStrPuRateWitTax() {
		return strPuRateWitTax;
	}
	public void setStrPuRateWitTax(String[] strPuRateWitTax) {
		this.strPuRateWitTax = strPuRateWitTax;
	}
	public String[] getStrAdm() {
		return strAdm;
	}
	public void setStrAdm(String[] strAdm) {
		this.strAdm = strAdm;
	}
	public String[] getStrCosttoPat() {
		return strCosttoPat;
	}
	public void setStrCosttoPat(String[] strCosttoPat) {
		this.strCosttoPat = strCosttoPat;
	}
	public String getStrItemCategoeryName() {
		return strItemCategoeryName;
	}
	public void setStrItemCategoeryName(String strItemCategoeryName) {
		this.strItemCategoeryName = strItemCategoeryName;
	}
	public String getStrPrintItemHlpDtl() {
		return strPrintItemHlpDtl;
	}
	public void setStrPrintItemHlpDtl(String strPrintItemHlpDtl) {
		this.strPrintItemHlpDtl = strPrintItemHlpDtl;
	}
	public String getStrLPNo() {
		return strLPNo;
	}
	public void setStrLPNo(String strLPNo) {
		this.strLPNo = strLPNo;
	}
	public String[] getStrMultiRowItemId() {
		return strMultiRowItemId;
	}
	public void setStrMultiRowItemId(String[] strMultiRowItemId) {
		this.strMultiRowItemId = strMultiRowItemId;
	}
	public String getStrErr() {
		return strErr;
	}
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}
	public String getStrBrandId() {
		return strBrandId;
	}
	public void setStrBrandId(String strBrandId) {
		this.strBrandId = strBrandId;
	}
	public String getStrPrintDtls() {
		return strPrintDtls;
	}
	public void setStrPrintDtls(String strPrintDtls) {
		this.strPrintDtls = strPrintDtls;
	}
	public String getStrLpoNo() {
		return strLpoNo;
	}
	public void setStrLpoNo(String strLpoNo) {
		this.strLpoNo = strLpoNo;
	}
	public String getStrUcChk() {
		return strUcChk;
	}
	public void setStrUcChk(String strUcChk) {
		this.strUcChk = strUcChk;
	}
	public WebRowSet getInstituteListWs() {
		return InstituteListWs;
	}
	public void setInstituteListWs(WebRowSet instituteListWs) {
		InstituteListWs = instituteListWs;
	}
	public WebRowSet getStrSupplierWs() {
		return strSupplierWs;
	}
	public void setStrSupplierWs(WebRowSet strSupplierWs) {
		this.strSupplierWs = strSupplierWs;
	}
	public String getStrInstituteCombo() {
		return strInstituteCombo;
	}
	public void setStrInstituteCombo(String strInstituteCombo) {
		this.strInstituteCombo = strInstituteCombo;
	}
	public String getStrExpDeliveryDate() {
		return strExpDeliveryDate;
	}
	public void setStrExpDeliveryDate(String strExpDeliveryDate) {
		this.strExpDeliveryDate = strExpDeliveryDate;
	}
	public String getStrPoDate() {
		return strPoDate;
	}
	public void setStrPoDate(String strPoDate) {
		this.strPoDate = strPoDate;
	}
	public String getStrManufacturerName() {
		return strManufacturerName;
	}
	public void setStrManufacturerName(String strManufacturerName) {
		this.strManufacturerName = strManufacturerName;
	}
	public String[] getStrPurRate1() {
		return strPurRate1;
	}
	public void setStrPurRate1(String[] strPurRate1) {
		this.strPurRate1 = strPurRate1;
	}
	public String getStrDifferenceAmt() {
		return strDifferenceAmt;
	}
	public void setStrDifferenceAmt(String strDifferenceAmt) {
		this.strDifferenceAmt = strDifferenceAmt;
	}
	private WebRowSet InstituteListWs;
	private WebRowSet strSupplierWs;
	
	
	private String  strManufacturerName;
	
	private String[] strPurRate1;
	private String strDifferenceAmt;
	
	
//SUPPLR RECEIPT END 
	public String getStrManufacturerId() {
		return strManufacturerId;
	}
	public void setStrManufacturerId(String strManufacturerId) {
		this.strManufacturerId = strManufacturerId;
	}

	public String getStrPendingDayEndDetailsTable() {
		return strPendingDayEndDetailsTable;
	}
	public void setStrPendingDayEndDetailsTable(String strPendingDayEndDetailsTable) {
		this.strPendingDayEndDetailsTable = strPendingDayEndDetailsTable;
	}
	public String getStrGstTax() {
		return strGstTax;
	}
	public void setStrGstTax(String strGstTax) {
		this.strGstTax = strGstTax;
	}
	public String getStrAdminTax() {
		return strAdminTax;
	}
	public void setStrAdminTax(String strAdminTax) {
		this.strAdminTax = strAdminTax;
	}
	public String getStrMRPPrice() {
		return strMRPPrice;
	}
	public void setStrMRPPrice(String strMRPPrice) {
		this.strMRPPrice = strMRPPrice;
	}
	public String getStrReceivedFromThirdPartyName() {
		return strReceivedFromThirdPartyName;
	}
	public void setStrReceivedFromThirdPartyName(
			String strReceivedFromThirdPartyName) {
		this.strReceivedFromThirdPartyName = strReceivedFromThirdPartyName;
	}
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
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
	
	public String getStrInstituteName() {
		return strInstituteName;
	}
	public void setStrInstituteName(String strInstituteName) {
		this.strInstituteName = strInstituteName;
	}
	public String getStrGroupCombo() {
		return strGroupCombo;
	}
	public void setStrGroupCombo(String strGroupCombo) {
		this.strGroupCombo = strGroupCombo;
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
	public String getStrUnitSaleID() {
		return strUnitSaleID;
	}
	public void setStrUnitSaleID(String strUnitSaleID) {
		this.strUnitSaleID = strUnitSaleID;
	}
	public String getStrUnitSaleName() {
		return strUnitSaleName;
	}
	public void setStrUnitSaleName(String strUnitSaleName) {
		this.strUnitSaleName = strUnitSaleName;
	}
	public String getStrUnitSaleCombo() {
		return strUnitSaleCombo;
	}
	public void setStrUnitSaleCombo(String strUnitSaleCombo) {
		this.strUnitSaleCombo = strUnitSaleCombo;
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
	
	public String getStrItemCategoryName() {
		return strItemCategoryName;
	}
	public void setStrItemCategoryName(String strItemCategoryName) {
		this.strItemCategoryName = strItemCategoryName;
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
	
	public String getStrReceivedDate() {
		return strReceivedDate;
	}
	public void setStrReceivedDate(String strReceivedDate) {
		this.strReceivedDate = strReceivedDate;
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
	public String getStrDefaultCurrencyCode() {
		return strDefaultCurrencyCode;
	}
	public void setStrDefaultCurrencyCode(String strDefaultCurrencyCode) {
		this.strDefaultCurrencyCode = strDefaultCurrencyCode;
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
	public String getStrStockStatusValues() {
		return strStockStatusValues;
	}
	public void setStrStockStatusValues(String strStockStatusValues) {
		this.strStockStatusValues = strStockStatusValues;
	}
	public String getStrUnitId() {
		return strUnitId;
	}
	public void setStrUnitId(String strUnitId) {
		this.strUnitId = strUnitId;
	}
	public String getStrUnitName() {
		return strUnitName;
	}
	public void setStrUnitName(String strUnitName) {
		this.strUnitName = strUnitName;
	}
	public String getStrModuleId() {
		return strModuleId;
	}
	public void setStrModuleId(String strModuleId) {
		this.strModuleId = strModuleId;
	}
	public String getStrUnitNameCombo() {
		return strUnitNameCombo;
	}
	public void setStrUnitNameCombo(String strUnitNameCombo) {
		this.strUnitNameCombo = strUnitNameCombo;
	}
	public String getStrUnitCombo() {
		return strUnitCombo;
	}
	public void setStrUnitCombo(String strUnitCombo) {
		this.strUnitCombo = strUnitCombo;
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
	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}
	public String getStrSubGroupCombo() {
		return strSubGroupCombo;
	}
	public void setStrSubGroupCombo(String strSubGroupCombo) {
		this.strSubGroupCombo = strSubGroupCombo;
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
	public String getStrUnitIdSale() {
		return strUnitIdSale;
	}
	public void setStrUnitIdSale(String strUnitIdSale) {
		this.strUnitIdSale = strUnitIdSale;
	}
	public String getStrUnitNameSale() {
		return strUnitNameSale;
	}
	public void setStrUnitNameSale(String strUnitNameSale) {
		this.strUnitNameSale = strUnitNameSale;
	}
	public String getStrUnitNameComboSale() {
		return strUnitNameComboSale;
	}
	public void setStrUnitNameComboSale(String strUnitNameComboSale) {
		this.strUnitNameComboSale = strUnitNameComboSale;
	}
	public String getStrChk() {
		return strChk;
	}
	public void setStrChk(String strChk) {
		this.strChk = strChk;
	}
	public String getStrUnitComboSale() {
		return strUnitComboSale;
	}
	public void setStrUnitComboSale(String strUnitComboSale) {
		this.strUnitComboSale = strUnitComboSale;
	}
	public String getStrSubGroupId() {
		return strSubGroupId;
	}
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}
	public String getStrInHandQuantityUnitName() {
		return strInHandQuantityUnitName;
	}
	public void setStrInHandQuantityUnitName(String strInHandQuantityUnitName) {
		this.strInHandQuantityUnitName = strInHandQuantityUnitName;
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
	public String getStrSerialNo() {
		return strSerialNo;
	}
	public void setStrSerialNo(String strSerialNo) {
		this.strSerialNo = strSerialNo;
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
	public String getStrRequestType() {
		return strRequestType;
	}
	public void setStrRequestType(String strRequestType) {
		this.strRequestType = strRequestType;
	}
	public String getStrNormalMsg() {
		return strNormalMsg;
	}
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}
	public String getStrErrMsg() {
		return strErrMsg;
	}
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}
	public String getStrWarningMsg() {
		return strWarningMsg;
	}
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
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
	public String getStrStoreNameCombo() {
		return strStoreNameCombo;
	}
	public void setStrStoreNameCombo(String strStoreNameCombo) {
		this.strStoreNameCombo = strStoreNameCombo;
	}
	public String getStrItemCategoryId() {
		return strItemCategoryId;
	}
	public void setStrItemCategoryId(String strItemCategoryId) {
		this.strItemCategoryId = strItemCategoryId;
	}
	public String getStrItemCategoryCombo() {
		return strItemCategoryCombo;
	}
	public void setStrItemCategoryCombo(String strItemCategoryCombo) {
		this.strItemCategoryCombo = strItemCategoryCombo;
	}
	public String getStrInstituteId() {
		return strInstituteId;
	}
	public void setStrInstituteId(String strInstituteId) {
		this.strInstituteId = strInstituteId;
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
	public String getStrInstituteValues() {
		return strInstituteValues;
	}
	public void setStrInstituteValues(String strInstituteValues) {
		this.strInstituteValues = strInstituteValues;
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
	public String getStrItemCategoryCode() {
		return strItemCategoryCode;
	}
	public void setStrItemCategoryCode(String strItemCategoryCode) {
		this.strItemCategoryCode = strItemCategoryCode;
	}
	public String getStrItemHlp() {
		return strItemHlp;
	}
	public void setStrItemHlp(String strItemHlp) {
		this.strItemHlp = strItemHlp;
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
	public String getStrRatewithGst() {
		return strRatewithGst;
	}
	public void setStrRatewithGst(String strRatewithGst) {
		this.strRatewithGst = strRatewithGst;
	}
	public String[] getStrBatchNo() {
		return strBatchNo;
	}
	public void setStrBatchNo(String[] strBatchNo) {
		this.strBatchNo = strBatchNo;
	}
		
}
