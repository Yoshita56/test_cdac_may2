/**
 * 
 */
package mms.transactions.controller.fb;

import javax.sql.rowset.WebRowSet;

import org.apache.struts.action.ActionForm;

/**
 * @author Pankaj Kumar Creation Date:- 15-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskScheduleTransFB extends ActionForm  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String strMsgType="";
	private String strErr="";
	private String strWarning="";
	private String strMsg="";
	
	private String strItemCat="";
	private String strMsgString="";
	private String strHospitalCode="";
	private String strSeatId="";
	private String strStoreId="";
	private String[] strCheckBox=null;
	private String strStoreName="";
	private String strItemCatName="";
	private String strItemId="";
	private String strPOTypeId="";
	private String strSupplierId="";
	private String strSupplierName="";
	private String strRequestId ="";
	private String strCurrency= "";
	private String strCheckData="";
	private String strPONo = "";
	private String strPOType = "";
	private String strPODate = "";
	private String strAgentId = "";
	private String strAgentName = "";
	private String strCAAgent = "";
	private String strCAAgentName = "";
	private String strCurrencyCode="";
	private String strForeignPODetails="";
	private String strDNoOfSchedule="";
	private String strDScheduledQtyUnitValues="";
	private String strCurrentDate = "";
	
	private WebRowSet wbPOItemDetail=null;
	
	private String[] strDItemId = null;
	private String[] strDItemBrandId = null;
	private String[] strDGroupId = null;
	private String[] strDSubGroupId = null;
	private String[] strDOrderQty = null;
	private String[] strDOrderQtyUnitId = null;
	private String[] strDRate = null;
	private String[] strDRateUnitId = null;
	private String[] strDItemTax = null;
	private String[] strDManufacturerId = null;
	private String strDRemarks = null;
	private String[] strDWarrentyReq = null;
	private String[] strDInstallationReq = null;
	private String[] strDDeliveryDate = null;
	private String[] strDScheduleNo = null;
	private String[] strDScheduledQty = null;
	private String[] strDScheduledQtyUnit = null;
	
	private String strItemIds="";
	private String strItemBrandIds="";
	private String strPODeliveryDate;
	private String strDeliveryLocationValues;
	private String[] strDeliveryLocation= null;
	private String[] strOrderUnitWithBaseValue=null;
	private String[] strRateUnitWithBaseValue=null;
	
	
	
	
	public String[] getStrOrderUnitWithBaseValue() {
		return strOrderUnitWithBaseValue;
	}
	public void setStrOrderUnitWithBaseValue(String[] strOrderUnitWithBaseValue) {
		this.strOrderUnitWithBaseValue = strOrderUnitWithBaseValue;
	}
	public String[] getStrDeliveryLocation() {
		return strDeliveryLocation;
	}
	public void setStrDeliveryLocation(String[] strDeliveryLocation) {
		this.strDeliveryLocation = strDeliveryLocation;
	}
	public String getStrDeliveryLocationValues() {
		return strDeliveryLocationValues;
	}
	public void setStrDeliveryLocationValues(String strDeliveryLocationValues) {
		this.strDeliveryLocationValues = strDeliveryLocationValues;
	}
	public String getStrPODeliveryDate() {
		return strPODeliveryDate;
	}
	public void setStrPODeliveryDate(String strPODeliveryDate) {
		this.strPODeliveryDate = strPODeliveryDate;
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
	 * @return the strDScheduledQty
	 */
	public String[] getStrDScheduledQty() {
		return strDScheduledQty;
	}
	/**
	 * @param strDScheduledQty the strDScheduledQty to set
	 */
	public void setStrDScheduledQty(String[] strDScheduledQty) {
		this.strDScheduledQty = strDScheduledQty;
	}
	/**
	 * @return the strDScheduledQtyUnit
	 */
	public String[] getStrDScheduledQtyUnit() {
		return strDScheduledQtyUnit;
	}
	/**
	 * @param strDScheduledQtyUnit the strDScheduledQtyUnit to set
	 */
	public void setStrDScheduledQtyUnit(String[] strDScheduledQtyUnit) {
		this.strDScheduledQtyUnit = strDScheduledQtyUnit;
	}
	/**
	 * @return the strDScheduleNo
	 */
	public String[] getStrDScheduleNo() {
		return strDScheduleNo;
	}
	/**
	 * @param strDScheduleNo the strDScheduleNo to set
	 */
	public void setStrDScheduleNo(String[] strDScheduleNo) {
		this.strDScheduleNo = strDScheduleNo;
	}
	/**
	 * @return the strDDeliveryDate
	 */
	public String[] getStrDDeliveryDate() {
		return strDDeliveryDate;
	}
	/**
	 * @param strDDeliveryDate the strDDeliveryDate to set
	 */
	public void setStrDDeliveryDate(String[] strDDeliveryDate) {
		this.strDDeliveryDate = strDDeliveryDate;
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
	 * @return the strDWarrentyReq
	 */
	public String[] getStrDWarrentyReq() {
		return strDWarrentyReq;
	}
	/**
	 * @param strDWarrentyReq the strDWarrentyReq to set
	 */
	public void setStrDWarrentyReq(String[] strDWarrentyReq) {
		this.strDWarrentyReq = strDWarrentyReq;
	}
	/**
	 * @return the strDInstallationReq
	 */
	public String[] getStrDInstallationReq() {
		return strDInstallationReq;
	}
	/**
	 * @param strDInstallationReq the strDInstallationReq to set
	 */
	public void setStrDInstallationReq(String[] strDInstallationReq) {
		this.strDInstallationReq = strDInstallationReq;
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
	 * @return the strDItemTax
	 */
	public String[] getStrDItemTax() {
		return strDItemTax;
	}
	/**
	 * @param strDItemTax the strDItemTax to set
	 */
	public void setStrDItemTax(String[] strDItemTax) {
		this.strDItemTax = strDItemTax;
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
	 * @return the strDScheduledQtyUnitValues
	 */
	public String getStrDScheduledQtyUnitValues() {
		return strDScheduledQtyUnitValues;
	}
	/**
	 * @param strDScheduledQtyUnitValues the strDScheduledQtyUnitValues to set
	 */
	public void setStrDScheduledQtyUnitValues(String strDScheduledQtyUnitValues) {
		this.strDScheduledQtyUnitValues = strDScheduledQtyUnitValues;
	}
	/**
	 * @return the strDNoOfSchedule
	 */
	public String getStrDNoOfSchedule() {
		return strDNoOfSchedule;
	}
	/**
	 * @param strDNoOfSchedule the strDNoOfSchedule to set
	 */
	public void setStrDNoOfSchedule(String strDNoOfSchedule) {
		this.strDNoOfSchedule = strDNoOfSchedule;
	}
	/**
	 * @return the strForeignPODetails
	 */
	public String getStrForeignPODetails() {
		return strForeignPODetails;
	}
	/**
	 * @param strForeignPODetails the strForeignPODetails to set
	 */
	public void setStrForeignPODetails(String strForeignPODetails) {
		this.strForeignPODetails = strForeignPODetails;
	}
	/**
	 * @return the strAgentId
	 */
	public String getStrAgentId() {
		return strAgentId;
	}
	/**
	 * @param strAgentId the strAgentId to set
	 */
	public void setStrAgentId(String strAgentId) {
		this.strAgentId = strAgentId;
	}
	/**
	 * @return the strAgentName
	 */
	public String getStrAgentName() {
		return strAgentName;
	}
	/**
	 * @param strAgentName the strAgentName to set
	 */
	public void setStrAgentName(String strAgentName) {
		this.strAgentName = strAgentName;
	}
	/**
	 * @return the strCAAgent
	 */
	public String getStrCAAgent() {
		return strCAAgent;
	}
	/**
	 * @param strCAAgent the strCAAgent to set
	 */
	public void setStrCAAgent(String strCAAgent) {
		this.strCAAgent = strCAAgent;
	}
	/**
	 * @return the strCAAgentName
	 */
	public String getStrCAAgentName() {
		return strCAAgentName;
	}
	/**
	 * @param strCAAgentName the strCAAgentName to set
	 */
	public void setStrCAAgentName(String strCAAgentName) {
		this.strCAAgentName = strCAAgentName;
	}
	/**
	 * @return the strCurrencyCode
	 */
	public String getStrCurrencyCode() {
		return strCurrencyCode;
	}
	/**
	 * @param strCurrencyCode the strCurrencyCode to set
	 */
	public void setStrCurrencyCode(String strCurrencyCode) {
		this.strCurrencyCode = strCurrencyCode;
	}
	/**
	 * @return the strPOType
	 */
	public String getStrPOType() {
		return strPOType;
	}
	/**
	 * @param strPOType the strPOType to set
	 */
	public void setStrPOType(String strPOType) {
		this.strPOType = strPOType;
	}
	/**
	 * @return the strPODate
	 */
	public String getStrPODate() {
		return strPODate;
	}
	/**
	 * @param strPODate the strPODate to set
	 */
	public void setStrPODate(String strPODate) {
		this.strPODate = strPODate;
	}
	/**
	 * @return the strPONo
	 */
	public String getStrPONo() {
		return strPONo;
	}
	/**
	 * @param strPONo the strPONo to set
	 */
	public void setStrPONo(String strPONo) {
		this.strPONo = strPONo;
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
	 * @return the strSupplierName
	 */
	public String getStrSupplierName() {
		return strSupplierName;
	}
	/**
	 * @param strSupplierName the strSupplierName to set
	 */
	public void setStrSupplierName(String strSupplierName) {
		this.strSupplierName = strSupplierName;
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
	 * @return the strCurrency
	 */
	public String getStrCurrency() {
		return strCurrency;
	}
	/**
	 * @param strCurrency the strCurrency to set
	 */
	public void setStrCurrency(String strCurrency) {
		this.strCurrency = strCurrency;
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
	 * @return the wbPOItemDetail
	 */
	public WebRowSet getWbPOItemDetail() {
		return wbPOItemDetail;
	}
	/**
	 * @param wbPOItemDetail the wbPOItemDetail to set
	 */
	public void setWbPOItemDetail(WebRowSet wbPOItemDetail) {
		this.wbPOItemDetail = wbPOItemDetail;
	}

	/**
	 * @return the strDItemId
	 */
	public String[] getStrDItemId() {
		return strDItemId;
	}
	/**
	 * @param strDItemId the strDItemId to set
	 */
	public void setStrDItemId(String[] strDItemId) {
		this.strDItemId = strDItemId;
	}
	/**
	 * @return the strDItemBrandId
	 */
	public String[] getStrDItemBrandId() {
		return strDItemBrandId;
	}
	/**
	 * @param strDItemBrandId the strDItemBrandId to set
	 */
	public void setStrDItemBrandId(String[] strDItemBrandId) {
		this.strDItemBrandId = strDItemBrandId;
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
	public String[] getStrRateUnitWithBaseValue() {
		return strRateUnitWithBaseValue;
	}
	public void setStrRateUnitWithBaseValue(String[] strRateUnitWithBaseValue) {
		this.strRateUnitWithBaseValue = strRateUnitWithBaseValue;
	}
	
	
}
