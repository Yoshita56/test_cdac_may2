/**
 * 
 */
package mms.transactions.controller.fb;

import javax.sql.rowset.WebRowSet;

import org.apache.struts.action.ActionForm;

/**
 * @author Pankaj Kumar Creation Date:- 10-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskGenerateTransFB extends ActionForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String strMsgType="";
	private String strErr="";
	private String strWarning="";
	private String strMsg="";
	private String strToStore="";
	private String strToStoreValues="";
	private String strItemCat="";
	private String strItemCatValues="";
	private String strAgendaPeriod="";
	private String strIndentDetails="";
	private String strMsgString="";
	private String strRemarks="";
	private String strHospitalCode="";
	private String strSeatId="";
	private String strStoreId="";
	private String strAgendaStatus="";
	private String[] strCheckBox=null;
	private String strGrantTypeValues="";
	private String strGrantTypeId="";
	private String strPopupId="";
	private String strStoreName="";
	private String strItemCatName="";
	private String strItemPopupData="";
	private String strItemId="";
	private String strRateUnitValues="";
	private String strPOTypeValues="";
	private String strPOTypeId="";
	private String strSupplierValues="";
	private String strSupplierId="";
	private String strRequestId ="";
	private String strContractType="";
	private String strReqIdnDate="";
	private String strManufacturerValues="";
	private String strPurchaseSourceValues= "";
	private String strDeliveryLocationValues= "";
	private String strAgentNameValues= "";
	private String strCurrencyValues= "";
	private String strCheckData="";
	private String strPoNo= "";
	private String strDPurchaseSource= "";
	private String strDDeliveryLocation= "";
	private String strDTenderNo= "";
	private String strDTenderDate= "";
	private String strDQuotationNo= "";
	private String strDQuotationDate= "";
	private String strDRemarks= "";
	private String strDOverAllTax= "0";
	private String strCurrentDate = "";
	private String strVerifiedDate="";
	private String strVerifiedBy="";
	private String strINRCurrencyId = "";
	private String strApprovedByVals="";
	private WebRowSet wbRequestDetail=null; 
	private WebRowSet wbRequestItemDetail=null;
	private WebRowSet wbItemDetail=null;
	private String supplierDetail=null;
	private String strTempUnit="";
	private String strDivId="";
	private String[] strHiddenValue;
	private String[] strDPhoneEmail;
	private String strpoDateId="";
	private String  strpoDate="";
	private String strFromDate;
	private String strToDate;
	private String tmpPONO;
	private String tmpPoType;
	private String strDraftPoDetails;
	private String strDraftPoDetailsBS;
	private String strDComments;
	private String strDNotes;
	private String[] strDFinalNotes=null;
	private String strExclTax;
	private String[] supptotamt=null;
	private String strGroupId;
	private String strReqModifyItemDtls=null;
	private String[] strDMRPCol;
	private String[] strDMRP;
	
	private String[] strDPackSize;
	private String[] strDPack;
	

	public String[] getStrDPackSize() {
		return strDPackSize;
	}
	public void setStrDPackSize(String[] strDPackSize) {
		this.strDPackSize = strDPackSize;
	}
	public String[] getStrDPack() {
		return strDPack;
	}
	public void setStrDPack(String[] strDPack) {
		this.strDPack = strDPack;
	}

	public String[] getStrDMRP() {
		return strDMRP;
	}
	public void setStrDMRP(String[] strDMRP) {
		this.strDMRP = strDMRP;
	}
	public String[] getStrDMRPCol() {
		return strDMRPCol;
	}
	public void setStrDMRPCol(String[] strDMRPCol) {
		this.strDMRPCol = strDMRPCol;
	}
	public String getStrReqModifyItemDtls() {
		return strReqModifyItemDtls;
	}
	public void setStrReqModifyItemDtls(String strReqModifyItemDtls) {
		this.strReqModifyItemDtls = strReqModifyItemDtls;
	}
	public String getStrGroupId() {
		return strGroupId;
	}
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}
	public String[] getSupptotamt() {
		return supptotamt;
	}
	public void setSupptotamt(String[] supptotamt) {
		this.supptotamt = supptotamt;
	}
	public String getStrExclTax() {
		return strExclTax;
	}
	public void setStrExclTax(String strExclTax) {
		this.strExclTax = strExclTax;
	}
	public String[] getStrDFinalNotes() {
		return strDFinalNotes;
	}
	public void setStrDFinalNotes(String[] strDFinalNotes) {
		this.strDFinalNotes = strDFinalNotes;
	}
	public String getStrDNotes() {
		return strDNotes;
	}
	public void setStrDNotes(String strDNotes) {
		this.strDNotes = strDNotes;
	}
	public String getStrDComments() {
		return strDComments;
	}
	public void setStrDComments(String strDComments) {
		this.strDComments = strDComments;
	}
	public String getStrDraftPoDetails() {
		return strDraftPoDetails;
	}
	public void setStrDraftPoDetails(String strDraftPoDetails) {
		this.strDraftPoDetails = strDraftPoDetails;
	}
	
	
	
	public String getStrDraftPoDetailsBS() {
		return strDraftPoDetailsBS;
	}
	public void setStrDraftPoDetailsBS(String strDraftPoDetailsBS) {
		this.strDraftPoDetailsBS = strDraftPoDetailsBS;
	}
	public String getTmpPoType() {
		return tmpPoType;
	}
	public void setTmpPoType(String tmpPoType) {
		this.tmpPoType = tmpPoType;
	}
	public String getTmpPONO() {
		return tmpPONO;
	}
	public void setTmpPONO(String tmpPONO) {
		this.tmpPONO = tmpPONO;
	}
	public String getStrFromDate() {
		return strFromDate;
	}
	public void setStrFromDate(String strFromDate) {
		this.strFromDate = strFromDate;
	}
	public String getStrToDate() {
		return strToDate;
	}
	public void setStrToDate(String strToDate) {
		this.strToDate = strToDate;
	}
	public String getStrpoDate() {
		return strpoDate;
	}
	public void setStrpoDate(String strpoDate) {
		this.strpoDate = strpoDate;
	}
	public String getStrpoDateId() {
		return strpoDateId;
	}
	public void setStrpoDateId(String strpoDateId) {
		this.strpoDateId = strpoDateId;
	}
	public String[] getStrDPhoneEmail() {
		return strDPhoneEmail;
	}
	public void setStrDPhoneEmail(String[] strDPhoneEmail) {
		this.strDPhoneEmail = strDPhoneEmail;
	}
	private String strSetItemDetails="";
	
	private String[] strQrderQty=null;
	
	private String[] strPOHiddenVal;
	public String[] getStrPOHiddenVal() {
		return strPOHiddenVal;
	}
	public void setStrPOHiddenVal(String[] strPOHiddenVal) {
		this.strPOHiddenVal = strPOHiddenVal;
	}
	public String[] getStrQrderQty() {
		return strQrderQty;
	}
	public void setStrQrderQty(String[] strQrderQty) {
		this.strQrderQty = strQrderQty;
	}
	public String getStrSetItemDetails() {
		return strSetItemDetails;
	}
	public void setStrSetItemDetails(String strSetItemDetails) {
		this.strSetItemDetails = strSetItemDetails;
	}
	public String[] getStrHiddenValue() {
		return strHiddenValue;
	}
	public void setStrHiddenValue(String[] strHiddenValue) {
		this.strHiddenValue = strHiddenValue;
	}
	private String strIndex;
	public String getStrIndex() {
		return strIndex;
	}
	public void setStrIndex(String strIndex) {
		this.strIndex = strIndex;
	}
	public String getStrDivId() {
		return strDivId;
	}
	public void setStrDivId(String strDivId) {
		this.strDivId = strDivId;
	}
	public String getStrTempUnit() {
		return strTempUnit;
	}
	public void setStrTempUnit(String strTempUnit) {
		this.strTempUnit = strTempUnit;
	}
	public String getSupplierDetail() {
		return supplierDetail;
	}
	public void setSupplierDetail(String supplierDetail) {
		this.supplierDetail = supplierDetail;
	}
	public WebRowSet getWbItemDetail() {
		return wbItemDetail;
	}
	public void setWbItemDetail(WebRowSet wbItemDetail) {
		this.wbItemDetail = wbItemDetail;
	}
	private String[] strDApproxRateUnit = null;
	private String[] strDApproxRate = null;
	private String[] strDitemId = null;
	private String[] strDitemBrandId = null;
	private String[] strDGroupId = null;
	private String[] strDSubGroupId = null;
	private String[] strDCompiledQty = null;
	private String[] strDCompiledQtyUnit = null;
	private String[] strDRequestNo = null;
	private String[] strDRequestDate = null;
	private String[] strDRequestPeriod = null;
	private String[] strDRaisingStore = null;
	private String[] strDLstPoNo = null;
	private String[] strDLstPoDate = null;
	private String[] strDLstSupplierId = null;
	private String[] strDLstSupplierInterface= null;
	public String[] getStrDLstSupplierInterface() {
		return strDLstSupplierInterface;
	}
	public void setStrDLstSupplierInterface(String[] strDLstSupplierInterface) {
		this.strDLstSupplierInterface = strDLstSupplierInterface;
	}
	private String[] strDLstRecQty = null;
	private String[] strDLstRecQtyUnit = null;
	private String[] strDLstRecDate = null;
	private String[] strDLstPurRate = null;
	private String[] strDLstPurRateUnit  = null;
	private String[] strDRequestType = null; 
	private String[] strCheckBoxItem = null;
	private String[] strComponentID = null;
	private String[] strComponentName = null;
	private String[] strComponentValue = null;

	private String[] strDManufacturerId = null;
	private String[] strDWarrantyRequired = null;
	private String[] strDInstallationRequired = null;
	private String[] strDRate = null;
	private String[] strDRateUnitId = null;
	private String[] strDTax = {"0"};
	private String[] strDCRNo = null;
	private String[] strMake = null;
	private String strStoreIds="";
	private String strRequestIds="";
	private String strItemIds="";
	private String strItemBrandIds="";
	private String[] strDComponentValue=null;
	private String[] strDComponentId = null;
	private String strDDemurrageBy = "";
	private String strDAgentName = "";
	private String strDCAName = "";
	private String strDIACCharge = "";
	private String strDInsuranceCharge = "";
	private String strDCurrencyName = "";
	private String strDCurrencyValue = "";
	private String strDDeliveryDate = "";
	private String strDNetAmount = "";
	private String[] strDOrderQty = null;
	private String[] strDOrderQtyUnitId = null;
	private String strPOGrantType = "";
	private String[] strTmpReqNo = null;
	private String[] strTmpRaisingStore = null;
    private String strSupplierType;
    private String strIndianDeleivryDate;
    private String strImportedDeleivryDate;
    private String strIndianImportedFlg;
	
    private String strSDFFlgColor ;
    private String strDPORefNo;
    private String strDPORefDate;
	private String strReOrderFlgColor;
	private String strPONo;
	private String strPostatus;
	private String strModifyFlg;
	private String strApprovedBy;
	private String strSupplierName;
	private String strPOType;
	private String strPOHiddenValue;
	private String strItemRate;
	private String strItemRateUnitId;
	private String strItemManufacturerId;
	private String strTotalPOCost;
	private String strPurchaseSourceID;
	private String strPoRefrenceNo;
	private String strPORefrenceDate;
	private String strPoRefrenceNoCmb;
	private String strVerifyById;
	private String strApprovalDate;
	private String strFinancialStartDate;
	private String strFinancialToDate;
	private String strPODemandYear;
	//private String wbsReqListPO;
	private String strPOItemCmb;
	private String strPODate;
	private String strCurrentFinancialYear;
	private String strNextFinancialYear;
	private String strNextPoDate;
	private String strPOApprovalFlag;
	private String strMode;
	private String strTax;
	private String strtQty;
	private String[] strDExpectedDeliveryDate;
	public String[] getStrDExpectedDeliveryDate() {
		return strDExpectedDeliveryDate;
	}
	public void setStrDExpectedDeliveryDate(String[] strDExpectedDeliveryDate) {
		this.strDExpectedDeliveryDate = strDExpectedDeliveryDate;
	}
	public String getStrtQty() {
		return strtQty;
	}
	public void setStrtQty(String strtQty) {
		this.strtQty = strtQty;
	}
	public String getStrTax() {
		return strTax;
	}
	public void setStrTax(String strTax) {
		this.strTax = strTax;
	}
	private WebRowSet wbsReqListPO=null;
	public WebRowSet getWbsReqListPO() {
		return wbsReqListPO;
	}
	public void setWbsReqListPO(WebRowSet wbsReqListPO) {
		this.wbsReqListPO = wbsReqListPO;
	}
	
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
	public String getStrPOApprovalFlag() {
		return strPOApprovalFlag;
	}
	public void setStrPOApprovalFlag(String strPOApprovalFlag) {
		this.strPOApprovalFlag = strPOApprovalFlag;
	}
	public String getStrNextPoDate() {
		return strNextPoDate;
	}
	public void setStrNextPoDate(String strNextPoDate) {
		this.strNextPoDate = strNextPoDate;
	}
	public String getStrCurrentFinancialYear() {
		return strCurrentFinancialYear;
	}
	public void setStrCurrentFinancialYear(String strCurrentFinancialYear) {
		this.strCurrentFinancialYear = strCurrentFinancialYear;
	}
	public String getStrNextFinancialYear() {
		return strNextFinancialYear;
	}
	public void setStrNextFinancialYear(String strNextFinancialYear) {
		this.strNextFinancialYear = strNextFinancialYear;
	}
	public String getStrPODate() {
		return strPODate;
	}
	public void setStrPODate(String strPODate) {
		this.strPODate = strPODate;
	}
	public String getStrPoRefrenceNoCmb() {
		return strPoRefrenceNoCmb;
	}
	public void setStrPoRefrenceNoCmb(String strPoRefrenceNoCmb) {
		this.strPoRefrenceNoCmb = strPoRefrenceNoCmb;
	}
	public String getStrVerifyById() {
		return strVerifyById;
	}
	public void setStrVerifyById(String strVerifyById) {
		this.strVerifyById = strVerifyById;
	}
	public String getStrApprovalDate() {
		return strApprovalDate;
	}
	public void setStrApprovalDate(String strApprovalDate) {
		this.strApprovalDate = strApprovalDate;
	}
	public String getStrFinancialStartDate() {
		return strFinancialStartDate;
	}
	public void setStrFinancialStartDate(String strFinancialStartDate) {
		this.strFinancialStartDate = strFinancialStartDate;
	}
	public String getStrFinancialToDate() {
		return strFinancialToDate;
	}
	public void setStrFinancialToDate(String strFinancialToDate) {
		this.strFinancialToDate = strFinancialToDate;
	}
	public String getStrPODemandYear() {
		return strPODemandYear;
	}
	public void setStrPODemandYear(String strPODemandYear) {
		this.strPODemandYear = strPODemandYear;
	}
	/*public String getWbsReqListPO() {
		return wbsReqListPO;
	}
	public void setWbsReqListPO(String wbsReqListPO) {
		this.wbsReqListPO = wbsReqListPO;
	}*/
	public String getStrPOItemCmb() {
		return strPOItemCmb;
	}
	public void setStrPOItemCmb(String strPOItemCmb) {
		this.strPOItemCmb = strPOItemCmb;
	}
	public String getStrApprovedBy() {
		return strApprovedBy;
	}
	public void setStrApprovedBy(String strApprovedBy) {
		this.strApprovedBy = strApprovedBy;
	}
	public String getStrSupplierName() {
		return strSupplierName;
	}
	public void setStrSupplierName(String strSupplierName) {
		this.strSupplierName = strSupplierName;
	}
	public String getStrPOType() {
		return strPOType;
	}
	public void setStrPOType(String strPOType) {
		this.strPOType = strPOType;
	}
	public String getStrPOHiddenValue() {
		return strPOHiddenValue;
	}
	public void setStrPOHiddenValue(String strPOHiddenValue) {
		this.strPOHiddenValue = strPOHiddenValue;
	}
	public String getStrItemRate() {
		return strItemRate;
	}
	public void setStrItemRate(String strItemRate) {
		this.strItemRate = strItemRate;
	}
	public String getStrItemRateUnitId() {
		return strItemRateUnitId;
	}
	public void setStrItemRateUnitId(String strItemRateUnitId) {
		this.strItemRateUnitId = strItemRateUnitId;
	}
	public String getStrItemManufacturerId() {
		return strItemManufacturerId;
	}
	public void setStrItemManufacturerId(String strItemManufacturerId) {
		this.strItemManufacturerId = strItemManufacturerId;
	}
	public String getStrTotalPOCost() {
		return strTotalPOCost;
	}
	public void setStrTotalPOCost(String strTotalPOCost) {
		this.strTotalPOCost = strTotalPOCost;
	}
	public String getStrPurchaseSourceID() {
		return strPurchaseSourceID;
	}
	public void setStrPurchaseSourceID(String strPurchaseSourceID) {
		this.strPurchaseSourceID = strPurchaseSourceID;
	}
	public String getStrPoRefrenceNo() {
		return strPoRefrenceNo;
	}
	public void setStrPoRefrenceNo(String strPoRefrenceNo) {
		this.strPoRefrenceNo = strPoRefrenceNo;
	}
	public String getStrPORefrenceDate() {
		return strPORefrenceDate;
	}
	public void setStrPORefrenceDate(String strPORefrenceDate) {
		this.strPORefrenceDate = strPORefrenceDate;
	}
	public String getStrModifyFlg() {
		return strModifyFlg;
	}
	public void setStrModifyFlg(String strModifyFlg) {
		this.strModifyFlg = strModifyFlg;
	}
	public String getStrPostatus() {
		return strPostatus;
	}
	public void setStrPostatus(String strPostatus) {
		this.strPostatus = strPostatus;
	}
	public String getStrPONo() {
		return strPONo;
	}
	public void setStrPONo(String strPONo) {
		this.strPONo = strPONo;
	}
	public String getStrReOrderFlgColor() {
		return strReOrderFlgColor;
	}
	public void setStrReOrderFlgColor(String strReOrderFlgColor) {
		this.strReOrderFlgColor = strReOrderFlgColor;
	}
	public String getStrSDFFlgColor() {
		return strSDFFlgColor;
	}
	public void setStrSDFFlgColor(String strSDFFlgColor) {
		this.strSDFFlgColor = strSDFFlgColor;
	}
	
	public String getStrIndianImportedFlg() {
		return strIndianImportedFlg;
	}
	public void setStrIndianImportedFlg(String strIndianImportedFlg) {
		this.strIndianImportedFlg = strIndianImportedFlg;
	}
	public String getStrIndianDeleivryDate() {
		return strIndianDeleivryDate;
	}
	public void setStrIndianDeleivryDate(String strIndianDeleivryDate) {
		this.strIndianDeleivryDate = strIndianDeleivryDate;
	}
	public String getStrImportedDeleivryDate() {
		return strImportedDeleivryDate;
	}
	public void setStrImportedDeleivryDate(String strImportedDeleivryDate) {
		this.strImportedDeleivryDate = strImportedDeleivryDate;
	}
	public String getStrSupplierType() {
		return strSupplierType;
	}
	public void setStrSupplierType(String strSupplierType) {
		this.strSupplierType = strSupplierType;
	}
	/**
	 * @return the strINRCurrencyId
	 */
	public String getStrINRCurrencyId() {
		return strINRCurrencyId;
	}
	/**
	 * @param strINRCurrencyId the strINRCurrencyId to set
	 */
	public void setStrINRCurrencyId(String strINRCurrencyId) {
		this.strINRCurrencyId = strINRCurrencyId;
	}
	/**
	 * @return the strCurrentDate
	 */
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	/**
	 * @param strCurrentDate the strCurrentDate to set
	 */
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}
	/**
	 * @return the strTmpReqNo
	 */
	public String[] getStrTmpReqNo() {
		return strTmpReqNo;
	}
	/**
	 * @param strTmpReqNo the strTmpReqNo to set
	 */
	public void setStrTmpReqNo(String[] strTmpReqNo) {
		this.strTmpReqNo = strTmpReqNo;
	}
	/**
	 * @return the strTmpRaisingStore
	 */
	public String[] getStrTmpRaisingStore() {
		return strTmpRaisingStore;
	}
	/**
	 * @param strTmpRaisingStore the strTmpRaisingStore to set
	 */
	public void setStrTmpRaisingStore(String[] strTmpRaisingStore) {
		this.strTmpRaisingStore = strTmpRaisingStore;
	}
	/**
	 * @return the strPOGrantType
	 */
	public String getStrPOGrantType() {
		return strPOGrantType;
	}
	/**
	 * @param strPOGrantType the strPOGrantType to set
	 */
	public void setStrPOGrantType(String strPOGrantType) {
		this.strPOGrantType = strPOGrantType;
	}
	/**
	 * @return the strDNetAmount
	 */
	public String getStrDNetAmount() {
		return strDNetAmount;
	}
	/**
	 * @param strDNetAmount the strDNetAmount to set
	 */
	public void setStrDNetAmount(String strDNetAmount) {
		this.strDNetAmount = strDNetAmount;
	}
	/**
	 * @return the strDCRNo
	 */
	public String[] getStrDCRNo() {
		return strDCRNo;
	}
	/**
	 * @param strDCRNo the strDCRNo to set
	 */
	public void setStrDCRNo(String[] strDCRNo) {
		this.strDCRNo = strDCRNo;
	}
	/**
	 * @return the strDOrderQty
	 */
	public String[] getStrDOrderQty() {
		return strDOrderQty;
	}
	/**
	 * @param strDOrderQty the strDOrderQty to set
	 */
	public void setStrDOrderQty(String[] strDOrderQty) {
		this.strDOrderQty = strDOrderQty;
	}
	
	/**
	 * @return the strDOrderQtyUnitId
	 */
	public String[] getStrDOrderQtyUnitId() {
		return strDOrderQtyUnitId;
	}
	/**
	 * @param strDOrderQtyUnitId the strDOrderQtyUnitId to set
	 */
	public void setStrDOrderQtyUnitId(String[] strDOrderQtyUnitId) {
		this.strDOrderQtyUnitId = strDOrderQtyUnitId;
	}
	/**
	 * @return the strDDeliveryDate
	 */
	public String getStrDDeliveryDate() {
		return strDDeliveryDate;
	}
	/**
	 * @param strDDeliveryDate the strDDeliveryDate to set
	 */
	public void setStrDDeliveryDate(String strDDeliveryDate) {
		this.strDDeliveryDate = strDDeliveryDate;
	}
	/**
	 * @return the strDDemurrageBy
	 */
	public String getStrDDemurrageBy() {
		return strDDemurrageBy;
	}
	/**
	 * @param strDDemurrageBy the strDDemurrageBy to set
	 */
	public void setStrDDemurrageBy(String strDDemurrageBy) {
		this.strDDemurrageBy = strDDemurrageBy;
	}
	/**
	 * @return the strDAgentName
	 */
	public String getStrDAgentName() {
		return strDAgentName;
	}
	/**
	 * @param strDAgentName the strDAgentName to set
	 */
	public void setStrDAgentName(String strDAgentName) {
		this.strDAgentName = strDAgentName;
	}
	/**
	 * @return the strDCAName
	 */
	public String getStrDCAName() {
		return strDCAName;
	}
	/**
	 * @param strDCAName the strDCAName to set
	 */
	public void setStrDCAName(String strDCAName) {
		this.strDCAName = strDCAName;
	}
	/**
	 * @return the strDIACCharge
	 */
	public String getStrDIACCharge() {
		return strDIACCharge;
	}
	/**
	 * @param strDIACCharge the strDIACCharge to set
	 */
	public void setStrDIACCharge(String strDIACCharge) {
		this.strDIACCharge = strDIACCharge;
	}
	/**
	 * @return the strDInsuranceCharge
	 */
	public String getStrDInsuranceCharge() {
		return strDInsuranceCharge;
	}
	/**
	 * @param strDInsuranceCharge the strDInsuranceCharge to set
	 */
	public void setStrDInsuranceCharge(String strDInsuranceCharge) {
		this.strDInsuranceCharge = strDInsuranceCharge;
	}
	/**
	 * @return the strDCurrencyName
	 */
	public String getStrDCurrencyName() {
		return strDCurrencyName;
	}
	/**
	 * @param strDCurrencyName the strDCurrencyName to set
	 */
	public void setStrDCurrencyName(String strDCurrencyName) {
		this.strDCurrencyName = strDCurrencyName;
	}
	/**
	 * @return the strDCurrencyValue
	 */
	public String getStrDCurrencyValue() {
		return strDCurrencyValue;
	}
	/**
	 * @param strDCurrencyValue the strDCurrencyValue to set
	 */
	public void setStrDCurrencyValue(String strDCurrencyValue) {
		this.strDCurrencyValue = strDCurrencyValue;
	}

	/**
	 * @return the strDComponentValue
	 */
	public String[] getStrDComponentValue() {
		return strDComponentValue;
	}
	/**
	 * @param strDComponentValue the strDComponentValue to set
	 */
	public void setStrDComponentValue(String[] strDComponentValue) {
		this.strDComponentValue = strDComponentValue;
	}
	/**
	 * @return the strDComponentId
	 */
	public String[] getStrDComponentId() {
		return strDComponentId;
	}
	/**
	 * @param strDComponentId the strDComponentId to set
	 */
	public void setStrDComponentId(String[] strDComponentId) {
		this.strDComponentId = strDComponentId;
	}
	/**
	 * @return the strDTax
	 */
	public String[] getStrDTax() {
		return strDTax;
	}
	/**
	 * @param strDTax the strDTax to set
	 */
	public void setStrDTax(String[] strDTax) {
		this.strDTax = strDTax;
	}
	/**
	 * @return the strDRate
	 */
	public String[] getStrDRate() {
		return strDRate;
	}
	/**
	 * @param strDRate the strDRate to set
	 */
	public void setStrDRate(String[] strDRate) {
		this.strDRate = strDRate;
	}
	/**
	 * @return the strDRateUnitId
	 */
	public String[] getStrDRateUnitId() {
		return strDRateUnitId;
	}
	/**
	 * @param strDRateUnitId the strDRateUnitId to set
	 */
	public void setStrDRateUnitId(String[] strDRateUnitId) {
		this.strDRateUnitId = strDRateUnitId;
	}
	/**
	 * @return the strDManufacturerId
	 */
	public String[] getStrDManufacturerId() {
		return strDManufacturerId;
	}
	/**
	 * @param strDManufacturerId the strDManufacturerId to set
	 */
	public void setStrDManufacturerId(String[] strDManufacturerId) {
		this.strDManufacturerId = strDManufacturerId;
	}
	/**
	 * @return the strDWarrantyRequired
	 */
	public String[] getStrDWarrantyRequired() {
		return strDWarrantyRequired;
	}
	/**
	 * @param strDWarrantyRequired the strDWarrantyRequired to set
	 */
	public void setStrDWarrantyRequired(String[] strDWarrantyRequired) {
		this.strDWarrantyRequired = strDWarrantyRequired;
	}
	/**
	 * @return the strDInstallationRequired
	 */
	public String[] getStrDInstallationRequired() {
		return strDInstallationRequired;
	}
	/**
	 * @param strDInstallationRequired the strDInstallationRequired to set
	 */
	public void setStrDInstallationRequired(String[] strDInstallationRequired) {
		this.strDInstallationRequired = strDInstallationRequired;
	}
	/**
	 * @return the strDRequestType
	 */
	public String[] getStrDRequestType() {
		return strDRequestType;
	}
	/**
	 * @param strDRequestType the strDRequestType to set
	 */
	public void setStrDRequestType(String[] strDRequestType) {
		this.strDRequestType = strDRequestType;
	}
	/**
	 * @return the strPoNo
	 */
	public String getStrPoNo() {
		return strPoNo;
	}
	/**
	 * @param strPoNo the strPoNo to set
	 */
	public void setStrPoNo(String strPoNo) {
		this.strPoNo = strPoNo;
	}
	/**
	 * @return the strDPurchaseSource
	 */
	public String getStrDPurchaseSource() {
		return strDPurchaseSource;
	}
	/**
	 * @param strDPurchaseSource the strDPurchaseSource to set
	 */
	public void setStrDPurchaseSource(String strDPurchaseSource) {
		this.strDPurchaseSource = strDPurchaseSource;
	}
	/**
	 * @return the strDDeliveryLocation
	 */
	public String getStrDDeliveryLocation() {
		return strDDeliveryLocation;
	}
	/**
	 * @param strDDeliveryLocation the strDDeliveryLocation to set
	 */
	public void setStrDDeliveryLocation(String strDDeliveryLocation) {
		this.strDDeliveryLocation = strDDeliveryLocation;
	}
	/**
	 * @return the strDTenderNo
	 */
	public String getStrDTenderNo() {
		return strDTenderNo;
	}
	/**
	 * @param strDTenderNo the strDTenderNo to set
	 */
	public void setStrDTenderNo(String strDTenderNo) {
		this.strDTenderNo = strDTenderNo;
	}
	/**
	 * @return the strDTenderDate
	 */
	public String getStrDTenderDate() {
		return strDTenderDate;
	}
	/**
	 * @param strDTenderDate the strDTenderDate to set
	 */
	public void setStrDTenderDate(String strDTenderDate) {
		this.strDTenderDate = strDTenderDate;
	}
	/**
	 * @return the strDQuotationNo
	 */
	public String getStrDQuotationNo() {
		return strDQuotationNo;
	}
	/**
	 * @param strDQuotationNo the strDQuotationNo to set
	 */
	public void setStrDQuotationNo(String strDQuotationNo) {
		this.strDQuotationNo = strDQuotationNo;
	}
	/**
	 * @return the strDQuotationDate
	 */
	public String getStrDQuotationDate() {
		return strDQuotationDate;
	}
	/**
	 * @param strDQuotationDate the strDQuotationDate to set
	 */
	public void setStrDQuotationDate(String strDQuotationDate) {
		this.strDQuotationDate = strDQuotationDate;
	}
	/**
	 * @return the strDRemarks
	 */
	public String getStrDRemarks() {
		return strDRemarks;
	}
	/**
	 * @param strDRemarks the strDRemarks to set
	 */
	public void setStrDRemarks(String strDRemarks) {
		this.strDRemarks = strDRemarks;
	}
	/**
	 * @return the strDOverAllTax
	 */
	public String getStrDOverAllTax() {
		return strDOverAllTax;
	}
	/**
	 * @param strDOverAllTax the strDOverAllTax to set
	 */
	public void setStrDOverAllTax(String strDOverAllTax) {
		this.strDOverAllTax = strDOverAllTax;
	}
	/**
	 * @return the strCheckData
	 */
	public String getStrCheckData() {
		return strCheckData;
	}
	/**
	 * @param strCheckData the strCheckData to set
	 */
	public void setStrCheckData(String strCheckData) {
		this.strCheckData = strCheckData;
	}
	/**
	 * @return the strComponentValue
	 */
	public String[] getStrComponentValue() {
		return strComponentValue;
	}
	/**
	 * @param strComponentValue the strComponentValue to set
	 */
	public void setStrComponentValue(String[] strComponentValue) {
		this.strComponentValue = strComponentValue;
	}
	/**
	 * @return the strManufacturerValues
	 */
	public String getStrManufacturerValues() {
		return strManufacturerValues;
	}
	/**
	 * @param strManufacturerValues the strManufacturerValues to set
	 */
	public void setStrManufacturerValues(String strManufacturerValues) {
		this.strManufacturerValues = strManufacturerValues;
	}
	/**
	 * @return the strPurchaseSourceValues
	 */
	public String getStrPurchaseSourceValues() {
		return strPurchaseSourceValues;
	}
	/**
	 * @param strPurchaseSourceValues the strPurchaseSourceValues to set
	 */
	public void setStrPurchaseSourceValues(String strPurchaseSourceValues) {
		this.strPurchaseSourceValues = strPurchaseSourceValues;
	}
	/**
	 * @return the strDeliveryLocationValues
	 */
	public String getStrDeliveryLocationValues() {
		return strDeliveryLocationValues;
	}
	/**
	 * @param strDeliveryLocationValues the strDeliveryLocationValues to set
	 */
	public void setStrDeliveryLocationValues(String strDeliveryLocationValues) {
		this.strDeliveryLocationValues = strDeliveryLocationValues;
	}
	/**
	 * @return the strAgentNameValues
	 */
	public String getStrAgentNameValues() {
		return strAgentNameValues;
	}
	/**
	 * @param strAgentNameValues the strAgentNameValues to set
	 */
	public void setStrAgentNameValues(String strAgentNameValues) {
		this.strAgentNameValues = strAgentNameValues;
	}
	/**
	 * @return the strCurrencyValues
	 */
	public String getStrCurrencyValues() {
		return strCurrencyValues;
	}
	/**
	 * @param strCurrencyValues the strCurrencyValues to set
	 */
	public void setStrCurrencyValues(String strCurrencyValues) {
		this.strCurrencyValues = strCurrencyValues;
	}
	/**
	 * @return the strComponentID
	 */
	public String[] getStrComponentID() {
		return strComponentID;
	}
	/**
	 * @param strComponentID the strComponentID to set
	 */
	public void setStrComponentID(String[] strComponentID) {
		this.strComponentID = strComponentID;
	}
	/**
	 * @return the strComponentName
	 */
	public String[] getStrComponentName() {
		return strComponentName;
	}
	/**
	 * @param strComponentName the strComponentName to set
	 */
	public void setStrComponentName(String[] strComponentName) {
		this.strComponentName = strComponentName;
	}
	/**
	 * @return the strReqIdnDate
	 */
	public String getStrReqIdnDate() {
		return strReqIdnDate;
	}
	/**
	 * @param strReqIdnDate the strReqIdnDate to set
	 */
	public void setStrReqIdnDate(String strReqIdnDate) {
		this.strReqIdnDate = strReqIdnDate;
	}
	/**
	 * @return the strContractType
	 */
	public String getStrContractType() {
		return strContractType;
	}
	/**
	 * @param strContractType the strContractType to set
	 */
	public void setStrContractType(String strContractType) {
		this.strContractType = strContractType;
	}
	/**
	 * @return the strRequestId
	 */
	public String getStrRequestId() {
		return strRequestId;
	}
	/**
	 * @param strRequestId the strRequestId to set
	 */
	public void setStrRequestId(String strRequestId) {
		this.strRequestId = strRequestId;
	}
	/**
	 * @return the strSupplierValues
	 */
	public String getStrSupplierValues() {
		return strSupplierValues;
	}
	/**
	 * @param strSupplierValues the strSupplierValues to set
	 */
	public void setStrSupplierValues(String strSupplierValues) {
		this.strSupplierValues = strSupplierValues;
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
	 * @return the strPOTypeValues
	 */
	public String getStrPOTypeValues() {
		return strPOTypeValues;
	}
	/**
	 * @param strPOTypeValues the strPOTypeValues to set
	 */
	public void setStrPOTypeValues(String strPOTypeValues) {
		this.strPOTypeValues = strPOTypeValues;
	}
	/**
	 * @return the strPOTypeId
	 */
	public String getStrPOTypeId() {
		return strPOTypeId;
	}
	/**
	 * @param strPOTypeId the strPOTypeId to set
	 */
	public void setStrPOTypeId(String strPOTypeId) {
		this.strPOTypeId = strPOTypeId;
	}
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
	 * @return the strToStore
	 */
	public String getStrToStore() {
		return strToStore;
	}
	/**
	 * @param strToStore the strToStore to set
	 */
	public void setStrToStore(String strToStore) {
		this.strToStore = strToStore;
	}
	/**
	 * @return the strToStoreValues
	 */
	public String getStrToStoreValues() {
		return strToStoreValues;
	}
	/**
	 * @param strToStoreValues the strToStoreValues to set
	 */
	public void setStrToStoreValues(String strToStoreValues) {
		this.strToStoreValues = strToStoreValues;
	}
	/**
	 * @return the strItemCat
	 */
	public String getStrItemCat() {
		return strItemCat;
	}
	/**
	 * @param strItemCat the strItemCat to set
	 */
	public void setStrItemCat(String strItemCat) {
		this.strItemCat = strItemCat;
	}
	/**
	 * @return the strItemCatValues
	 */
	public String getStrItemCatValues() {
		return strItemCatValues;
	}
	/**
	 * @param strItemCatValues the strItemCatValues to set
	 */
	public void setStrItemCatValues(String strItemCatValues) {
		this.strItemCatValues = strItemCatValues;
	}
	/**
	 * @return the strAgendaPeriod
	 */
	public String getStrAgendaPeriod() {
		return strAgendaPeriod;
	}
	/**
	 * @param strAgendaPeriod the strAgendaPeriod to set
	 */
	public void setStrAgendaPeriod(String strAgendaPeriod) {
		this.strAgendaPeriod = strAgendaPeriod;
	}
	/**
	 * @return the strIndentDetails
	 */
	public String getStrIndentDetails() {
		return strIndentDetails;
	}
	/**
	 * @param strIndentDetails the strIndentDetails to set
	 */
	public void setStrIndentDetails(String strIndentDetails) {
		this.strIndentDetails = strIndentDetails;
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
	 * @return the strRemarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}
	/**
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
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
	 * @return the strAgendaStatus
	 */
	public String getStrAgendaStatus() {
		return strAgendaStatus;
	}
	/**
	 * @param strAgendaStatus the strAgendaStatus to set
	 */
	public void setStrAgendaStatus(String strAgendaStatus) {
		this.strAgendaStatus = strAgendaStatus;
	}
	/**
	 * @return the strCheckBox
	 */
	public String[] getStrCheckBox() {
		return strCheckBox;
	}
	/**
	 * @param strCheckBox the strCheckBox to set
	 */
	public void setStrCheckBox(String[] strCheckBox) {
		this.strCheckBox = strCheckBox;
	}
	/**
	 * @return the strGrantTypeValues
	 */
	public String getStrGrantTypeValues() {
		return strGrantTypeValues;
	}
	/**
	 * @param strGrantTypeValues the strGrantTypeValues to set
	 */
	public void setStrGrantTypeValues(String strGrantTypeValues) {
		this.strGrantTypeValues = strGrantTypeValues;
	}
	/**
	 * @return the strGrantTypeId
	 */
	public String getStrGrantTypeId() {
		return strGrantTypeId;
	}
	/**
	 * @param strGrantTypeId the strGrantTypeId to set
	 */
	public void setStrGrantTypeId(String strGrantTypeId) {
		this.strGrantTypeId = strGrantTypeId;
	}
	/**
	 * @return the strPopupId
	 */
	public String getStrPopupId() {
		return strPopupId;
	}
	/**
	 * @param strPopupId the strPopupId to set
	 */
	public void setStrPopupId(String strPopupId) {
		this.strPopupId = strPopupId;
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
	 * @return the strItemCatName
	 */
	public String getStrItemCatName() {
		return strItemCatName;
	}
	/**
	 * @param strItemCatName the strItemCatName to set
	 */
	public void setStrItemCatName(String strItemCatName) {
		this.strItemCatName = strItemCatName;
	}
	/**
	 * @return the strItemPopupData
	 */
	public String getStrItemPopupData() {
		return strItemPopupData;
	}
	/**
	 * @param strItemPopupData the strItemPopupData to set
	 */
	public void setStrItemPopupData(String strItemPopupData) {
		this.strItemPopupData = strItemPopupData;
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
	 * @return the strRateUnitValues
	 */
	public String getStrRateUnitValues() {
		return strRateUnitValues;
	}
	/**
	 * @param strRateUnitValues the strRateUnitValues to set
	 */
	public void setStrRateUnitValues(String strRateUnitValues) {
		this.strRateUnitValues = strRateUnitValues;
	}
	
	/**
	 * @return the wbRequestDetail
	 */
	public WebRowSet getWbRequestDetail() {
		return wbRequestDetail;
	}
	/**
	 * @param wbRequestDetail the wbRequestDetail to set
	 */
	public void setWbRequestDetail(WebRowSet wbRequestDetail) {
		this.wbRequestDetail = wbRequestDetail;
	}
	
	/**
	 * @return the wbRequestItemDetail
	 */
	public WebRowSet getWbRequestItemDetail() {
		return wbRequestItemDetail;
	}
	/**
	 * @param wbRequestItemDetail the wbRequestItemDetail to set
	 */
	public void setWbRequestItemDetail(WebRowSet wbRequestItemDetail) {
		this.wbRequestItemDetail = wbRequestItemDetail;
	}
	/**
	 * @return the strDApproxRateUnit
	 */
	public String[] getStrDApproxRateUnit() {
		return strDApproxRateUnit;
	}
	/**
	 * @param strDApproxRateUnit the strDApproxRateUnit to set
	 */
	public void setStrDApproxRateUnit(String[] strDApproxRateUnit) {
		this.strDApproxRateUnit = strDApproxRateUnit;
	}
	/**
	 * @return the strDApproxRate
	 */
	public String[] getStrDApproxRate() {
		return strDApproxRate;
	}
	/**
	 * @param strDApproxRate the strDApproxRate to set
	 */
	public void setStrDApproxRate(String[] strDApproxRate) {
		this.strDApproxRate = strDApproxRate;
	}
	/**
	 * @return the strDitemId
	 */
	public String[] getStrDitemId() {
		return strDitemId;
	}
	/**
	 * @param strDitemId the strDitemId to set
	 */
	public void setStrDitemId(String[] strDitemId) {
		this.strDitemId = strDitemId;
	}
	/**
	 * @return the strDitemBrandId
	 */
	public String[] getStrDitemBrandId() {
		return strDitemBrandId;
	}
	/**
	 * @param strDitemBrandId the strDitemBrandId to set
	 */
	public void setStrDitemBrandId(String[] strDitemBrandId) {
		this.strDitemBrandId = strDitemBrandId;
	}
	/**
	 * @return the strDGroupId
	 */
	public String[] getStrDGroupId() {
		return strDGroupId;
	}
	/**
	 * @param strDGroupId the strDGroupId to set
	 */
	public void setStrDGroupId(String[] strDGroupId) {
		this.strDGroupId = strDGroupId;
	}
	/**
	 * @return the strDSubGroupId
	 */
	public String[] getStrDSubGroupId() {
		return strDSubGroupId;
	}
	/**
	 * @param strDSubGroupId the strDSubGroupId to set
	 */
	public void setStrDSubGroupId(String[] strDSubGroupId) {
		this.strDSubGroupId = strDSubGroupId;
	}
	/**
	 * @return the strDCompiledQty
	 */
	public String[] getStrDCompiledQty() {
		return strDCompiledQty;
	}
	/**
	 * @param strDCompiledQty the strDCompiledQty to set
	 */
	public void setStrDCompiledQty(String[] strDCompiledQty) {
		this.strDCompiledQty = strDCompiledQty;
	}
	/**
	 * @return the strDCompiledQtyUnit
	 */
	public String[] getStrDCompiledQtyUnit() {
		return strDCompiledQtyUnit;
	}
	/**
	 * @param strDCompiledQtyUnit the strDCompiledQtyUnit to set
	 */
	public void setStrDCompiledQtyUnit(String[] strDCompiledQtyUnit) {
		this.strDCompiledQtyUnit = strDCompiledQtyUnit;
	}
	
	/**
	 * @return the strDRequestNo
	 */
	public String[] getStrDRequestNo() {
		return strDRequestNo;
	}
	/**
	 * @param strDRequestNo the strDRequestNo to set
	 */
	public void setStrDRequestNo(String[] strDRequestNo) {
		this.strDRequestNo = strDRequestNo;
	}
	/**
	 * @return the strDRequestDate
	 */
	public String[] getStrDRequestDate() {
		return strDRequestDate;
	}
	/**
	 * @param strDRequestDate the strDRequestDate to set
	 */
	public void setStrDRequestDate(String[] strDRequestDate) {
		this.strDRequestDate = strDRequestDate;
	}
	/**
	 * @return the strDRequestPeriod
	 */
	public String[] getStrDRequestPeriod() {
		return strDRequestPeriod;
	}
	/**
	 * @param strDRequestPeriod the strDRequestPeriod to set
	 */
	public void setStrDRequestPeriod(String[] strDRequestPeriod) {
		this.strDRequestPeriod = strDRequestPeriod;
	}
	/**
	 * @return the strDRaisingStore
	 */
	public String[] getStrDRaisingStore() {
		return strDRaisingStore;
	}
	/**
	 * @param strDRaisingStore the strDRaisingStore to set
	 */
	public void setStrDRaisingStore(String[] strDRaisingStore) {
		this.strDRaisingStore = strDRaisingStore;
	}
	/**
	 * @return the strDLstPoNo
	 */
	public String[] getStrDLstPoNo() {
		return strDLstPoNo;
	}
	/**
	 * @param strDLstPoNo the strDLstPoNo to set
	 */
	public void setStrDLstPoNo(String[] strDLstPoNo) {
		this.strDLstPoNo = strDLstPoNo;
	}
	/**
	 * @return the strDLstPoDate
	 */
	public String[] getStrDLstPoDate() {
		return strDLstPoDate;
	}
	/**
	 * @param strDLstPoDate the strDLstPoDate to set
	 */
	public void setStrDLstPoDate(String[] strDLstPoDate) {
		this.strDLstPoDate = strDLstPoDate;
	}
	/**
	 * @return the strDLstSupplierId
	 */
	public String[] getStrDLstSupplierId() {
		return strDLstSupplierId;
	}
	/**
	 * @param strDLstSupplierId the strDLstSupplierId to set
	 */
	public void setStrDLstSupplierId(String[] strDLstSupplierId) {
		this.strDLstSupplierId = strDLstSupplierId;
	}
	/**
	 * @return the strDLstRecQty
	 */
	public String[] getStrDLstRecQty() {
		return strDLstRecQty;
	}
	/**
	 * @param strDLstRecQty the strDLstRecQty to set
	 */
	public void setStrDLstRecQty(String[] strDLstRecQty) {
		this.strDLstRecQty = strDLstRecQty;
	}
	/**
	 * @return the strDLstRecQtyUnit
	 */
	public String[] getStrDLstRecQtyUnit() {
		return strDLstRecQtyUnit;
	}
	/**
	 * @param strDLstRecQtyUnit the strDLstRecQtyUnit to set
	 */
	public void setStrDLstRecQtyUnit(String[] strDLstRecQtyUnit) {
		this.strDLstRecQtyUnit = strDLstRecQtyUnit;
	}
	/**
	 * @return the strDLstRecDate
	 */
	public String[] getStrDLstRecDate() {
		return strDLstRecDate;
	}
	/**
	 * @param strDLstRecDate the strDLstRecDate to set
	 */
	public void setStrDLstRecDate(String[] strDLstRecDate) {
		this.strDLstRecDate = strDLstRecDate;
	}
	/**
	 * @return the strDLstPurRate
	 */
	public String[] getStrDLstPurRate() {
		return strDLstPurRate;
	}
	/**
	 * @param strDLstPurRate the strDLstPurRate to set
	 */
	public void setStrDLstPurRate(String[] strDLstPurRate) {
		this.strDLstPurRate = strDLstPurRate;
	}
	/**
	 * @return the strDLstPurRateUnit
	 */
	public String[] getStrDLstPurRateUnit() {
		return strDLstPurRateUnit;
	}
	/**
	 * @param strDLstPurRateUnit the strDLstPurRateUnit to set
	 */
	public void setStrDLstPurRateUnit(String[] strDLstPurRateUnit) {
		this.strDLstPurRateUnit = strDLstPurRateUnit;
	}
	/**
	 * @return the strCheckBoxItem
	 */
	public String[] getStrCheckBoxItem() {
		return strCheckBoxItem;
	}
	/**
	 * @param strCheckBoxItem the strCheckBoxItem to set
	 */
	public void setStrCheckBoxItem(String[] strCheckBoxItem) {
		this.strCheckBoxItem = strCheckBoxItem;
	}
	/**
	 * @return the strStoreIds
	 */
	public String getStrStoreIds() {
		return strStoreIds;
	}
	/**
	 * @param strStoreIds the strStoreIds to set
	 */
	public void setStrStoreIds(String strStoreIds) {
		this.strStoreIds = strStoreIds;
	}
	/**
	 * @return the strRequestIds
	 */
	public String getStrRequestIds() {
		return strRequestIds;
	}
	/**
	 * @param strRequestIds the strRequestIds to set
	 */
	public void setStrRequestIds(String strRequestIds) {
		this.strRequestIds = strRequestIds;
	}
	/**
	 * @return the strItemIds
	 */
	public String getStrItemIds() {
		return strItemIds;
	}
	/**
	 * @param strItemIds the strItemIds to set
	 */
	public void setStrItemIds(String strItemIds) {
		this.strItemIds = strItemIds;
	}
	/**
	 * @return the strItemBrandIds
	 */
	public String getStrItemBrandIds() {
		return strItemBrandIds;
	}
	/**
	 * @param strItemBrandIds the strItemBrandIds to set
	 */
	public void setStrItemBrandIds(String strItemBrandIds) {
		this.strItemBrandIds = strItemBrandIds;
	}
	/**
	 * @return the strApprovedByVals
	 */
	public String getStrApprovedByVals() {
		return strApprovedByVals;
	}
	/**
	 * @param strApprovedByVals the strApprovedByVals to set
	 */
	public void setStrApprovedByVals(String strApprovedByVals) {
		this.strApprovedByVals = strApprovedByVals;
	}
	/**
	 * @return the strVerifiedDate
	 */
	public String getStrVerifiedDate() {
		return strVerifiedDate;
	}
	/**
	 * @param strVerifiedDate the strVerifiedDate to set
	 */
	public void setStrVerifiedDate(String strVerifiedDate) {
		this.strVerifiedDate = strVerifiedDate;
	}
	/**
	 * @return the strVerifiedBy
	 */
	public String getStrVerifiedBy() {
		return strVerifiedBy;
	}
	/**
	 * @param strVerifiedBy the strVerifiedBy to set
	 */
	public void setStrVerifiedBy(String strVerifiedBy) {
		this.strVerifiedBy = strVerifiedBy;
	}
	/**
	 * @return the strMake
	 */
	public String[] getStrMake() {
		return strMake;
	}
	/**
	 * @param strMake the strMake to set
	 */
	public void setStrMake(String[] strMake) {
		this.strMake = strMake;
	}
	public String getStrDPORefNo() {
		return strDPORefNo;
	}
	public void setStrDPORefNo(String strDPORefNo) {
		this.strDPORefNo = strDPORefNo;
	}
	public String getStrDPORefDate() {
		return strDPORefDate;
	}
	public void setStrDPORefDate(String strDPORefDate) {
		this.strDPORefDate = strDPORefDate;
	}
	
}
