package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

public class InstallationTransVO {
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strMsgType = "";
	private String strMsgString = "";
	
	private String strStoreId = "";
	private String strGroupId = "";
	private String strSubGroupId = "";
	private String strItemCatNo = "";
	private String strGenItemId = "";
	
	private WebRowSet strStoreComboWs = null;
	private WebRowSet strItemCatComboWs = null;
	private WebRowSet strGroupComboWs = null;
	private WebRowSet strSubGroupComboWs = null;
	private WebRowSet strGenItemComboWs = null;
	private WebRowSet strItemComboWs = null;
	private WebRowSet strBatchSlNoComboWs = null;
	private WebRowSet strItemSlNoComboWs = null;
	private WebRowSet strInstallationDtlWs = null;
	
	private String strIsBatchNoReq = "";
	private String strIsSerialNoReq = "";
	private String strStockStatusCode = "";
	private String strItemBrandId = "";
	
	private String strFinStartDate = "";
	private String strFinEndDate = "";
	
	private String strHidStoreName = "";
	private String strItemCategoryName = "";
	
	
	/**
	 * @return the strHidStoreName
	 */
	public String getStrHidStoreName() {
		return strHidStoreName;
	}
	/**
	 * @param strHidStoreName the strHidStoreName to set
	 */
	public void setStrHidStoreName(String strHidStoreName) {
		this.strHidStoreName = strHidStoreName;
	}
	/**
	 * @return the strFinStartDate
	 */
	public String getStrFinStartDate() {
		return strFinStartDate;
	}
	/**
	 * @param strFinStartDate the strFinStartDate to set
	 */
	public void setStrFinStartDate(String strFinStartDate) {
		this.strFinStartDate = strFinStartDate;
	}
	/**
	 * @return the strFinEndDate
	 */
	public String getStrFinEndDate() {
		return strFinEndDate;
	}
	/**
	 * @param strFinEndDate the strFinEndDate to set
	 */
	public void setStrFinEndDate(String strFinEndDate) {
		this.strFinEndDate = strFinEndDate;
	}
	/**
	 * @return the strItemBrandId
	 */
	public String getStrItemBrandId() {
		return strItemBrandId;
	}
	/**
	 * @param strItemBrandId the strItemBrandId to set
	 */
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}
	/**
	 * @return the strStockStatusCode
	 */
	public String getStrStockStatusCode() {
		return strStockStatusCode;
	}
	/**
	 * @param strStockStatusCode the strStockStatusCode to set
	 */
	public void setStrStockStatusCode(String strStockStatusCode) {
		this.strStockStatusCode = strStockStatusCode;
	}
	/**
	 * @return the strIsBatchNoReq
	 */
	public String getStrIsBatchNoReq() {
		return strIsBatchNoReq;
	}
	/**
	 * @param strIsBatchNoReq the strIsBatchNoReq to set
	 */
	public void setStrIsBatchNoReq(String strIsBatchNoReq) {
		this.strIsBatchNoReq = strIsBatchNoReq;
	}
	/**
	 * @return the strStoreComboWs
	 */
	public WebRowSet getStrStoreComboWs() {
		return strStoreComboWs;
	}
	/**
	 * @param strStoreComboWs the strStoreComboWs to set
	 */
	public void setStrStoreComboWs(WebRowSet strStoreComboWs) {
		this.strStoreComboWs = strStoreComboWs;
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
	 * @return the strItemCatComboWs
	 */
	public WebRowSet getStrItemCatComboWs() {
		return strItemCatComboWs;
	}
	/**
	 * @param strItemCatComboWs the strItemCatComboWs to set
	 */
	public void setStrItemCatComboWs(WebRowSet strItemCatComboWs) {
		this.strItemCatComboWs = strItemCatComboWs;
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
	 * @return the strGroupComboWs
	 */
	public WebRowSet getStrGroupComboWs() {
		return strGroupComboWs;
	}
	/**
	 * @param strGroupComboWs the strGroupComboWs to set
	 */
	public void setStrGroupComboWs(WebRowSet strGroupComboWs) {
		this.strGroupComboWs = strGroupComboWs;
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
	 * @return the strSubGroupComboWs
	 */
	public WebRowSet getStrSubGroupComboWs() {
		return strSubGroupComboWs;
	}
	/**
	 * @param strSubGroupComboWs the strSubGroupComboWs to set
	 */
	public void setStrSubGroupComboWs(WebRowSet strSubGroupComboWs) {
		this.strSubGroupComboWs = strSubGroupComboWs;
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
	 * @return the strGenItemComboWs
	 */
	public WebRowSet getStrGenItemComboWs() {
		return strGenItemComboWs;
	}
	/**
	 * @param strGenItemComboWs the strGenItemComboWs to set
	 */
	public void setStrGenItemComboWs(WebRowSet strGenItemComboWs) {
		this.strGenItemComboWs = strGenItemComboWs;
	}
	/**
	 * @return the strGenItemId
	 */
	public String getStrGenItemId() {
		return strGenItemId;
	}
	/**
	 * @param strGenItemId the strGenItemId to set
	 */
	public void setStrGenItemId(String strGenItemId) {
		this.strGenItemId = strGenItemId;
	}
	/**
	 * @return the strItemComboWs
	 */
	public WebRowSet getStrItemComboWs() {
		return strItemComboWs;
	}
	/**
	 * @param strItemComboWs the strItemComboWs to set
	 */
	public void setStrItemComboWs(WebRowSet strItemComboWs) {
		this.strItemComboWs = strItemComboWs;
	}
	/**
	 * @return the strIsSerialNoReq
	 */
	public String getStrIsSerialNoReq() {
		return strIsSerialNoReq;
	}
	/**
	 * @param strIsSerialNoReq the strIsSerialNoReq to set
	 */
	public void setStrIsSerialNoReq(String strIsSerialNoReq) {
		this.strIsSerialNoReq = strIsSerialNoReq;
	}
	/**
	 * @return the strBatchSlNoComboWs
	 */
	public WebRowSet getStrBatchSlNoComboWs() {
		return strBatchSlNoComboWs;
	}
	/**
	 * @param strBatchSlNoComboWs the strBatchSlNoComboWs to set
	 */
	public void setStrBatchSlNoComboWs(WebRowSet strBatchSlNoComboWs) {
		this.strBatchSlNoComboWs = strBatchSlNoComboWs;
	}
	/**
	 * @return the strItemSlNoComboWs
	 */
	public WebRowSet getStrItemSlNoComboWs() {
		return strItemSlNoComboWs;
	}
	/**
	 * @param strItemSlNoComboWs the strItemSlNoComboWs to set
	 */
	public void setStrItemSlNoComboWs(WebRowSet strItemSlNoComboWs) {
		this.strItemSlNoComboWs = strItemSlNoComboWs;
	}
	/**
	 * @return the strInstallationDtlWs
	 */
	public WebRowSet getStrInstallationDtlWs() {
		return strInstallationDtlWs;
	}
	/**
	 * @param strInstallationDtlWs the strInstallationDtlWs to set
	 */
	public void setStrInstallationDtlWs(WebRowSet strInstallationDtlWs) {
		this.strInstallationDtlWs = strInstallationDtlWs;
	}
	/**
	 * @return the strItemCategoryName
	 */
	public String getStrItemCategoryName() {
		return strItemCategoryName;
	}
	/**
	 * @param strItemCategoryName the strItemCategoryName to set
	 */
	public void setStrItemCategoryName(String strItemCategoryName) {
		this.strItemCategoryName = strItemCategoryName;
	}
	

}
