/**
 * 
 */
package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

/**
 * @author Pankaj Kumar
 *
 */
public class PODeskCancelTransVO {
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
	private String strPONo ="";
	private String strPODate = "";
	private String strPOType = "";
	private String strAgentId = "";
	private String strAgentName = "";
	private String strCAAgent = "";
	private String strCAAgentName = "";
	private String strCurrencyCode="";
	private String strInventoryUnitId="";
	private String StrEmployeeValues="";
	private String strDScheduleNo = "";

	private String strCanceldQtyUnitValues="";
	
	private WebRowSet wbScheduleDetail=null;
	
	private String[] strDitemId = null;
	private String[] strDitemBrandId = null;
	private String[] strDGroupId = null;
	private String[] strDSubGroupId = null;
	
	private String strItemIds="";
	private String strItemBrandIds="";
	private String strDCancelBy = "";
	private String strDRemarks = "";
	private String strDPOCancelOrModify = "";
	private String strDApprovedBy = "";
	private String strDDeliveryDate = "";
	private String strDApprovedDate = "";
	private String strDOldDeliveryDate = "";
	private String strDCancelRemarks = "";
	
	
	
	/**
	 * @return the strDCancelRemarks
	 */
	public String getStrDCancelRemarks() {
		return strDCancelRemarks;
	}
	/**
	 * @param strDCancelRemarks the strDCancelRemarks to set
	 */
	public void setStrDCancelRemarks(String strDCancelRemarks) {
		this.strDCancelRemarks = strDCancelRemarks;
	}
	/**
	 * @return the strDApprovedBy
	 */
	public String getStrDApprovedBy() {
		return strDApprovedBy;
	}
	/**
	 * @param strDApprovedBy the strDApprovedBy to set
	 */
	public void setStrDApprovedBy(String strDApprovedBy) {
		this.strDApprovedBy = strDApprovedBy;
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
	 * @return the strDApprovedDate
	 */
	public String getStrDApprovedDate() {
		return strDApprovedDate;
	}
	/**
	 * @param strDApprovedDate the strDApprovedDate to set
	 */
	public void setStrDApprovedDate(String strDApprovedDate) {
		this.strDApprovedDate = strDApprovedDate;
	}
	/**
	 * @return the strDOldDeliveryDate
	 */
	public String getStrDOldDeliveryDate() {
		return strDOldDeliveryDate;
	}
	/**
	 * @param strDOldDeliveryDate the strDOldDeliveryDate to set
	 */
	public void setStrDOldDeliveryDate(String strDOldDeliveryDate) {
		this.strDOldDeliveryDate = strDOldDeliveryDate;
	}
	/**
	 * @return the strDPOCancelOrModify
	 */
	public String getStrDPOCancelOrModify() {
		return strDPOCancelOrModify;
	}
	/**
	 * @param strDPOCancelOrModify the strDPOCancelOrModify to set
	 */
	public void setStrDPOCancelOrModify(String strDPOCancelOrModify) {
		this.strDPOCancelOrModify = strDPOCancelOrModify;
	}
	/**
	 * @return the strDCancelBy
	 */
	public String getStrDCancelBy() {
		return strDCancelBy;
	}
	/**
	 * @param strDCancelBy the strDCancelBy to set
	 */
	public void setStrDCancelBy(String strDCancelBy) {
		this.strDCancelBy = strDCancelBy;
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
	 * @return the strDScheduleNo
	 */
	public String getStrDScheduleNo() {
		return strDScheduleNo;
	}
	/**
	 * @param strDScheduleNo the strDScheduleNo to set
	 */
	public void setStrDScheduleNo(String strDScheduleNo) {
		this.strDScheduleNo = strDScheduleNo;
	}
	/**
	 * @return the strEmployeeValues
	 */
	public String getStrEmployeeValues() {
		return StrEmployeeValues;
	}
	/**
	 * @param strEmployeeValues the strEmployeeValues to set
	 */
	public void setStrEmployeeValues(String strEmployeeValues) {
		StrEmployeeValues = strEmployeeValues;
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
	 * @return the strDCanceldQtyUnitValues
	 */
	public String getStrCanceldQtyUnitValues() {
		return strCanceldQtyUnitValues;
	}
	/**
	 * @param strDCanceldQtyUnitValues the strDCanceldQtyUnitValues to set
	 */
	public void setStrCanceldQtyUnitValues(String strCanceldQtyUnitValues) {
		this.strCanceldQtyUnitValues = strCanceldQtyUnitValues;
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
	 * @return the strDate
	 */
	public String getStrPODate() {
		return strPODate;
	}
	/**
	 * @param strDate the strDate to set
	 */
	public void setStrPODate(String strPODate) {
		this.strPODate = strPODate;
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
	 * @return the wbScheduleDetail
	 */
	public WebRowSet getWbScheduleDetail() {
		return wbScheduleDetail;
	}
	/**
	 * @param wbScheduleDetail the wbScheduleDetail to set
	 */
	public void setWbScheduleDetail(WebRowSet wbScheduleDetail) {
		this.wbScheduleDetail = wbScheduleDetail;
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
	
	
}
