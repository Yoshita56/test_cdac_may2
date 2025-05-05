/**
 * 
 */
package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

/**
 * @author Pankaj Kumar Creation Date:- 10-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskGenerateTransNewVO {
	private String strMsgType="";
	private String strErr="";
	private String strWarning="";
	private String strMsgString="";
	private String strMsg="";
	private String strToStore="";
	private String strToStoreValues="";
	private String strItemCat="";
	private String strItemCatValues="";
	private String strAgendaPeriod="";
	private String strHospitalCode="";
	private String strSeatId="";
	private String strStoreId="";
	private String strItemCatNo="";
	private String strRemarks="";
	private String strAgendaNo="";
	private String strToStoreId="";
	private String strAgendaDate="";
	private String strAgendaStatus="";
	private String strFinancialStartDate="";
	
	private String strFinancialToDate="";
	private String[] strCheckBox=null;
	private String strIndentNo="";
	private String strGrantTypeValues="";
	private String strGrantTypeId="";
	private String strItemId="";
	private String strItemPopupData="";
	private String strRateUnitValues="";
	private String strInventoryUnitId=""; 
	private String strPOTypeValues="";
	private String strPOTypeId="";
	private String strSupplierValues="";
	private String strSupplierId="";
	private String strContractType="";
	private String strRequestId ="";
	private String strRateUnitId="";
	private String strManufacturerValues="";
	private String strPurchaseSourceValues= "";
	private String strDeliveryLocationValues= "";
	private String strAgentNameValues= "";
	private String strCurrencyValues= "";
	private String strPoNo= "";
	private String strDPurchaseSource= "";
	private String strDDeliveryLocation= "";
	private String strDTenderNo= "";
	private String strDTenderDate= "";
	private String strDQuotationNo= "";
	private String strDQuotationDate= "";
	private String strDRemarks= "";
	private String strDOverAllTax= "";
	private String strVerifiedDate="";
	private String strVerifiedBy="";
	private String strDemandYear;
	
	private WebRowSet wbPODeliveryLocationMobNo=null;
	private WebRowSet wbRequestDetail=null;
	private WebRowSet wbRequestItemDetail=null;
	private WebRowSet wbComponentDetail=null;
	private WebRowSet wbApprovedBy=null;
	private WebRowSet wbsStoreNameCombo=null;
	private WebRowSet wbsReqListPO=null;
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
	private String[] strDTax = null;
	private String[] strDOrderQty = null;
	private String[] strDOrderQtyUnitId = null;
	private String[] strDCRNo = null;
	private String[] strTmpReqNo = null;
	private String[] strTmpRaisingStore = null;
	private String[] strMake = null;
	
	private String strStoreIds="";
	private String strRequestIds="";
	private String strItemIds="";
	private String strItemBrandIds="";
	private String[] strDComponentValue=null;
	private String[] strDComponentId = null;
	private String[] strTmpBalQty = null;
	private String strDDemurrageBy = "";
	private String strDAgentName = "";
	private String strDCAName = "";
	private String strDIACCharge = "";
	private String strDInsuranceCharge = "";
	private String strDCurrencyName = "";
	private String strDCurrencyValue = "";
	private String strDDeliveryDate = "";
	private String strDNetAmount = "";
	private String strPOGrantType = "";
	private String strMatchUnitCmb;
	private String strPoRefrenceNo;
	private String strIsForeignFlg;
	private String strCalDeliveryDate;
	private String strDatePikerFlag;
    private String strPORefrenceDate;
    private String strDDeliveryDays;
    private String strTotalPOCost;
    private int strHlpSize;
    private String strPOItemCmb;
    private String strPOItemID;
    private String strIndentPeriodValue;
    private String strRateTax;
    private String strComboPOTypeId; 
    private String strItemRate;
	private String[] strQrderQty = null;
	private String[] strOrdeCost = null;
	
	private String[] strScheduleOne = null;
	private String[] strScheduleTwo = null;
	private String[] strScheduleThree = null;
	private String[] strScheduleFour = null;
	private String strNextPoDate="";
	private String strPOApprovalFlag="0";

	
	
	private String strItemMake; 
	private String strItemRateTax;
	private String strItemManufacturerId;
	private String strPOFinancialDtl;
	private String strItemRateUnitId;
	private String[] strPODetailsHidValue = null;
	private String strPONo;
	private String strPODate;
	private String strSupplierName;
	private String strPOType;
	private String strItemCatName;
	private String strPOItemDetails;
	private String strPOHiddenValue;
	private String strModifyFlg;
	private String strPurchaseSourceId;
	private String strVerifyById;
	private String strMode;
    private String strPoRefrenceNoCmb;
    private String strMobileNoList="0";
    private String strMobileMsg;
    private String strMobileMsgMode;
    private String strMobileUserName="0";    
    private String strMobilePwd;
    private String strMobileSenderId;
    private String strApprovalType;
	public String getStrMobileNoList() {
		return strMobileNoList;
	}
	public void setStrMobileNoList(String strMobileNoList) {
		this.strMobileNoList = strMobileNoList;
	}
	public String getStrMobileMsg() {
		return strMobileMsg;
	}
	public void setStrMobileMsg(String strMobileMsg) {
		this.strMobileMsg = strMobileMsg;
	}
	public String getStrPoRefrenceNoCmb() {
		return strPoRefrenceNoCmb;
	}
	public void setStrPoRefrenceNoCmb(String strPoRefrenceNoCmb) {
		this.strPoRefrenceNoCmb = strPoRefrenceNoCmb;
	}



public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
public String getStrVerifyById() {
	return strVerifyById;
}
public void setStrVerifyById(String strVerifyById) {
	this.strVerifyById = strVerifyById;
}
public String getStrPurchaseSourceId() {
	return strPurchaseSourceId;
}
public void setStrPurchaseSourceId(String strPurchaseSourceId) {
	this.strPurchaseSourceId = strPurchaseSourceId;
}
public String getStrModifyFlg() {
	return strModifyFlg;
}
public void setStrModifyFlg(String strModifyFlg) {
	this.strModifyFlg = strModifyFlg;
}



private String strStoreName;


public String getStrStoreName() {
	return strStoreName;
}
public void setStrStoreName(String strStoreName) {
	this.strStoreName = strStoreName;
}
public String getStrPOItemDetails() {
	return strPOItemDetails;
}
public void setStrPOItemDetails(String strPOItemDetails) {
	this.strPOItemDetails = strPOItemDetails;
}
public String getStrPONo() {
	return strPONo;
}
public void setStrPONo(String strPONo) {
	this.strPONo = strPONo;
}



public String[] getStrPODetailsHidValue() {
	return strPODetailsHidValue;
}
public void setStrPODetailsHidValue(String[] strPODetailsHidValue) {
	this.strPODetailsHidValue = strPODetailsHidValue;
}
public String getStrItemRateUnitId() {
	return strItemRateUnitId;
}
public void setStrItemRateUnitId(String strItemRateUnitId) {
	this.strItemRateUnitId = strItemRateUnitId;
}
public String getStrPOFinancialDtl() {
	return strPOFinancialDtl;
}
public void setStrPOFinancialDtl(String strPOFinancialDtl) {
	this.strPOFinancialDtl = strPOFinancialDtl;
}
public String getStrItemManufacturerId() {
	return strItemManufacturerId;
}
public void setStrItemManufacturerId(String strItemManufacturerId) {
	this.strItemManufacturerId = strItemManufacturerId;
}


public String getStrItemRateTax() {
	return strItemRateTax;
}
public void setStrItemRateTax(String strItemRateTax) {
	this.strItemRateTax = strItemRateTax;
}
	public String getStrItemMake() {
		return strItemMake;
	}
	public void setStrItemMake(String strItemMake) {
		this.strItemMake = strItemMake;
	}

	
	
	public String[] getStrQrderQty() {
		return strQrderQty;
	}
	public void setStrQrderQty(String[] strQrderQty) {
		this.strQrderQty = strQrderQty;
	}
	public String[] getStrOrdeCost() {
		return strOrdeCost;
	}
	public void setStrOrdeCost(String[] strOrdeCost) {
		this.strOrdeCost = strOrdeCost;
	}
	public String getStrItemRate() {
		return strItemRate;
	}
	public void setStrItemRate(String strItemRate) {
		this.strItemRate = strItemRate;
	}
	public String getStrComboPOTypeId() {
		return strComboPOTypeId;
	}
	public void setStrComboPOTypeId(String strComboPOTypeId) {
		this.strComboPOTypeId = strComboPOTypeId;
	}
	public String getStrRateTax() {
		return strRateTax;
	}
	public void setStrRateTax(String strRateTax) {
		this.strRateTax = strRateTax;
	}
	public String getStrIndentPeriodValue() {
		return strIndentPeriodValue;
	}
	public void setStrIndentPeriodValue(String strIndentPeriodValue) {
		this.strIndentPeriodValue = strIndentPeriodValue;
	}
	
	
	public String getStrPOItemCmb() {
		return strPOItemCmb;
	}
	public void setStrPOItemCmb(String strPOItemCmb) {
		this.strPOItemCmb = strPOItemCmb;
	}
	public String getStrPOItemID() {
		return strPOItemID;
	}
	public void setStrPOItemID(String strPOItemID) {
		this.strPOItemID = strPOItemID;
	}
	public String getStrTotalPOCost() {
		return strTotalPOCost;
	}
	public void setStrTotalPOCost(String strTotalPOCost) {
		this.strTotalPOCost = strTotalPOCost;
	}
	public String getStrPORefrenceDate() {
		return strPORefrenceDate;
	}
	public void setStrPORefrenceDate(String strPORefrenceDate) {
		this.strPORefrenceDate = strPORefrenceDate;
	}
	public String getStrDatePikerFlag() {
		return strDatePikerFlag;
	}
	public void setStrDatePikerFlag(String strDatePikerFlag) {
		this.strDatePikerFlag = strDatePikerFlag;
	}
	public String getStrCalDeliveryDate() {
		return strCalDeliveryDate;
	}
	public void setStrCalDeliveryDate(String strCalDeliveryDate) {
		this.strCalDeliveryDate = strCalDeliveryDate;
	}
	public String getStrIsForeignFlg() {
		return strIsForeignFlg;
	}
	public void setStrIsForeignFlg(String strIsForeignFlg) {
		this.strIsForeignFlg = strIsForeignFlg;
	}
	public String getStrPoRefrenceNo() {
		return strPoRefrenceNo;
	}
	public void setStrPoRefrenceNo(String strPoRefrenceNo) {
		this.strPoRefrenceNo = strPoRefrenceNo;
	}
	public String getStrMatchUnitCmb() {
		return strMatchUnitCmb;
	}
	public void setStrMatchUnitCmb(String strMatchUnitCmb) {
		this.strMatchUnitCmb = strMatchUnitCmb;
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
	 * @return the wbComponentDetail
	 */
	public WebRowSet getWbComponentDetail() {
		return wbComponentDetail;
	}
	/**
	 * @param wbComponentDetail the wbComponentDetail to set
	 */
	public void setWbComponentDetail(WebRowSet wbComponentDetail) {
		this.wbComponentDetail = wbComponentDetail;
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
	 * @return the strRateUnitId
	 */
	public String getStrRateUnitId() {
		return strRateUnitId;
	}
	/**
	 * @param strRateUnitId the strRateUnitId to set
	 */
	public void setStrRateUnitId(String strRateUnitId) {
		this.strRateUnitId = strRateUnitId;
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
	 * @return the strItemCatNo
	 */
	public String getStrItemCatNo() {
		return strItemCatNo;
	}
	/**
	 * @param strItemCatNo the strItemCatNo to set
	 */
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
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
	 * @return the strAgendaNo
	 */
	public String getStrAgendaNo() {
		return strAgendaNo;
	}
	/**
	 * @param strAgendaNo the strAgendaNo to set
	 */
	public void setStrAgendaNo(String strAgendaNo) {
		this.strAgendaNo = strAgendaNo;
	}
	/**
	 * @return the strToStoreId
	 */
	public String getStrToStoreId() {
		return strToStoreId;
	}
	/**
	 * @param strToStoreId the strToStoreId to set
	 */
	public void setStrToStoreId(String strToStoreId) {
		this.strToStoreId = strToStoreId;
	}
	/**
	 * @return the strAgendaDate
	 */
	public String getStrAgendaDate() {
		return strAgendaDate;
	}
	/**
	 * @param strAgendaDate the strAgendaDate to set
	 */
	public void setStrAgendaDate(String strAgendaDate) {
		this.strAgendaDate = strAgendaDate;
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
	 * @return the strFinancialStartDate
	 */
	public String getStrFinancialStartDate() {
		return strFinancialStartDate;
	}
	/**
	 * @param strFinancialStartDate the strFinancialStartDate to set
	 */
	public void setStrFinancialStartDate(String strFinancialStartDate) {
		this.strFinancialStartDate = strFinancialStartDate;
	}
	/**
	 * @return the strFinancialToDate
	 */
	public String getStrFinancialToDate() {
		return strFinancialToDate;
	}
	/**
	 * @param strFinancialToDate the strFinancialToDate to set
	 */
	public void setStrFinancialToDate(String strFinancialToDate) {
		this.strFinancialToDate = strFinancialToDate;
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
	 * @return the strIndentNo
	 */
	public String getStrIndentNo() {
		return strIndentNo;
	}
	/**
	 * @param strIndentNo the strIndentNo to set
	 */
	public void setStrIndentNo(String strIndentNo) {
		this.strIndentNo = strIndentNo;
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
	 * @return the strInventoryUnitId
	 */
	public String getStrInventoryUnitId() {
		return strInventoryUnitId;
	}
	/**
	 * @param strInventoryUnitId the strInventoryUnitId to set
	 */
	public void setStrInventoryUnitId(String strInventoryUnitId) {
		this.strInventoryUnitId = strInventoryUnitId;
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
	 * @return the wbApprovedBy
	 */
	public WebRowSet getWbApprovedBy() {
		return wbApprovedBy;
	}
	/**
	 * @param wbApprovedBy the wbApprovedBy to set
	 */
	public void setWbApprovedBy(WebRowSet wbApprovedBy) {
		this.wbApprovedBy = wbApprovedBy;
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
	public String[] getStrTmpBalQty() {
		return strTmpBalQty;
	}
	public void setStrTmpBalQty(String[] strTmpBalQty) {
		this.strTmpBalQty = strTmpBalQty;
	}
	public String getStrDDeliveryDays() {
		return strDDeliveryDays;
	}
	public void setStrDDeliveryDays(String strDDeliveryDays) {
		this.strDDeliveryDays = strDDeliveryDays;
	}
	public int getStrHlpSize() {
		return strHlpSize;
	}
	public void setStrHlpSize(int strHlpSize) {
		this.strHlpSize = strHlpSize;
	}
	public WebRowSet getWbsStoreNameCombo() {
		return wbsStoreNameCombo;
	}
	public void setWbsStoreNameCombo(WebRowSet wbsStoreNameCombo) {
		this.wbsStoreNameCombo = wbsStoreNameCombo;
	}
	public WebRowSet getWbsReqListPO() {
		return wbsReqListPO;
	}
	public void setWbsReqListPO(WebRowSet wbsReqListPO) {
		this.wbsReqListPO = wbsReqListPO;
	}
	public String getStrPODate() {
		return strPODate;
	}
	public void setStrPODate(String strPODate) {
		this.strPODate = strPODate;
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
	public String getStrItemCatName() {
		return strItemCatName;
	}
	public void setStrItemCatName(String strItemCatName) {
		this.strItemCatName = strItemCatName;
	}
	public String getStrPOHiddenValue() {
		return strPOHiddenValue;
	}
	public void setStrPOHiddenValue(String strPOHiddenValue) {
		this.strPOHiddenValue = strPOHiddenValue;
	}
	public String getStrDemandYear() {
		return strDemandYear;
	}
	public void setStrDemandYear(String strDemandYear) {
		this.strDemandYear = strDemandYear;
	}
	public String[] getStrScheduleOne() {
		return strScheduleOne;
	}
	public void setStrScheduleOne(String[] strScheduleOne) {
		this.strScheduleOne = strScheduleOne;
	}
	public String[] getStrScheduleTwo() {
		return strScheduleTwo;
	}
	public void setStrScheduleTwo(String[] strScheduleTwo) {
		this.strScheduleTwo = strScheduleTwo;
	}
	public String[] getStrScheduleThree() {
		return strScheduleThree;
	}
	public void setStrScheduleThree(String[] strScheduleThree) {
		this.strScheduleThree = strScheduleThree;
	}
	public String[] getStrScheduleFour() {
		return strScheduleFour;
	}
	public void setStrScheduleFour(String[] strScheduleFour) {
		this.strScheduleFour = strScheduleFour;
	}
	
	public WebRowSet getWbPODeliveryLocationMobNo() {
		return wbPODeliveryLocationMobNo;
	}
	public void setWbPODeliveryLocationMobNo(WebRowSet wbPODeliveryLocationMobNo) {
		this.wbPODeliveryLocationMobNo = wbPODeliveryLocationMobNo;
	}
	public String getStrMobileMsgMode() {
		return strMobileMsgMode;
	}
	public void setStrMobileMsgMode(String strMobileMsgMode) {
		this.strMobileMsgMode = strMobileMsgMode;
	}
	public String getStrMobileUserName() {
		return strMobileUserName;
	}
	public void setStrMobileUserName(String strMobileUserName) {
		this.strMobileUserName = strMobileUserName;
	}
	public String getStrMobilePwd() {
		return strMobilePwd;
	}
	public void setStrMobilePwd(String strMobilePwd) {
		this.strMobilePwd = strMobilePwd;
	}
	public String getStrMobileSenderId() {
		return strMobileSenderId;
	}
	public void setStrMobileSenderId(String strMobileSenderId) {
		this.strMobileSenderId = strMobileSenderId;
	}
	public String getStrNextPoDate() {
		return strNextPoDate;
	}
	public void setStrNextPoDate(String strNextPoDate) {
		this.strNextPoDate = strNextPoDate;
	}
	public String getStrPOApprovalFlag() {
		return strPOApprovalFlag;
	}
	public void setStrPOApprovalFlag(String strPOApprovalFlag) {
		this.strPOApprovalFlag = strPOApprovalFlag;
	}
	public String getStrApprovalType() {
		return strApprovalType;
	}
	public void setStrApprovalType(String strApprovalType) {
		this.strApprovalType = strApprovalType;
	}
	
	
}
