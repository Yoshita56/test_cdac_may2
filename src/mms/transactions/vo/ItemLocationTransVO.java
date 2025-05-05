/**
 * 
 */
package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.TransferObject;

/**
 * Developer : Tanvi sappal
 * Version : 1.0
 * Date : 18/Jun/09
 */
public class ItemLocationTransVO implements TransferObject {
	
	private static final long serialVersionUID = 02L;
	
	private String strMsgString = "";
	private String strMsgType = "";
	
	private String strStoreTypeId = "";
	private String strItemCategoryNo = "10";
	private String strGroupId = "0";
	private String strSubGroupId = "0";
	private String strGenItemId = "0";
	private String strItemId = "";
	private String strItemName="";
	private String strBatchNo = "";
	private String strBatchItem = "";
	private String strItemSlNo = "";
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strIsValid = "";
	private String strIsSachet = "";
	private String strStockStatusCode = "";
	private String strStoreId = "";
	private String strReqTypeId = "";
	private String strReservedFlag = "";
	
	private String strIsBatchNo = "0";
	private String strIsSlNo = "0"; 
	private String strMode;
	
	//WebRowSet
	private WebRowSet strStoreWs=null;
	private WebRowSet strStoreTypeWs=null;
	private WebRowSet itemCategoryWS = null;
	private WebRowSet groupWS = null;
	private WebRowSet subGroupWS = null;
	private WebRowSet genItemWS = null;
	private WebRowSet itemWS = null;
	private WebRowSet batchNoWS = null;
	private WebRowSet itemSlNoWS = null;
	private WebRowSet stockDetailsWS = null;
	private WebRowSet emplyeeStockDetailsWS = null;
	
	
	
	
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
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
	 * @return the strItemSlNo
	 */
	public String getStrItemSlNo() {
		return strItemSlNo;
	}
	/**
	 * @param strItemSlNo the strItemSlNo to set
	 */
	public void setStrItemSlNo(String strItemSlNo) {
		this.strItemSlNo = strItemSlNo;
	}
	
	public WebRowSet getStrStoreWs() {
		return strStoreWs;
	}
	public void setStrStoreWs(WebRowSet strStoreWs) {
		this.strStoreWs = strStoreWs;
	}
	
	public WebRowSet getStrStoreTypeWs() {
		return strStoreTypeWs;
	}
	public void setStrStoreTypeWs(WebRowSet strStoreTypeWs) {
		this.strStoreTypeWs = strStoreTypeWs;
	}
	/**
	 * @return the itemCategoryWS
	 */
	public WebRowSet getItemCategoryWS() {
		return itemCategoryWS;
	}
	/**
	 * @param itemCategoryWS the itemCategoryWS to set
	 */
	public void setItemCategoryWS(WebRowSet itemCategoryWS) {
		this.itemCategoryWS = itemCategoryWS;
	}
	/**
	 * @return the groupWS
	 */
	public WebRowSet getGroupWS() {
		return groupWS;
	}
	/**
	 * @param groupWS the groupWS to set
	 */
	public void setGroupWS(WebRowSet groupWS) {
		this.groupWS = groupWS;
	}
	/**
	 * @return the subGroupWS
	 */
	public WebRowSet getSubGroupWS() {
		return subGroupWS;
	}
	/**
	 * @param subGroupWS the subGroupWS to set
	 */
	public void setSubGroupWS(WebRowSet subGroupWS) {
		this.subGroupWS = subGroupWS;
	}
	/**
	 * @return the genItemWS
	 */
	public WebRowSet getGenItemWS() {
		return genItemWS;
	}
	/**
	 * @param genItemWS the genItemWS to set
	 */
	public void setGenItemWS(WebRowSet genItemWS) {
		this.genItemWS = genItemWS;
	}
	/**
	 * @return the itemWS
	 */
	public WebRowSet getItemWS() {
		return itemWS;
	}
	/**
	 * @param itemWS the itemWS to set
	 */
	public void setItemWS(WebRowSet itemWS) {
		this.itemWS = itemWS;
	}
	/**
	 * @return the itemSlNoWS
	 */
	public WebRowSet getItemSlNoWS() {
		return itemSlNoWS;
	}
	/**
	 * @param itemSlNoWS the itemSlNoWS to set
	 */
	public void setItemSlNoWS(WebRowSet itemSlNoWS) {
		this.itemSlNoWS = itemSlNoWS;
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
	 * @return the strBatchNo
	 */
	public String getStrBatchNo() {
		return strBatchNo;
	}
	/**
	 * @param strBatchNo the strBatchNo to set
	 */
	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}
	/**
	 * @return the strBatchItem
	 */
	public String getStrBatchItem() {
		return strBatchItem;
	}
	/**
	 * @param strBatchItem the strBatchItem to set
	 */
	public void setStrBatchItem(String strBatchItem) {
		this.strBatchItem = strBatchItem;
	}
	/**
	 * @return the strIsSachet
	 */
	public String getStrIsSachet() {
		return strIsSachet;
	}
	/**
	 * @param strIsSachet the strIsSachet to set
	 */
	public void setStrIsSachet(String strIsSachet) {
		this.strIsSachet = strIsSachet;
	}
	/**
	 * @return the batchNoWS
	 */
	public WebRowSet getBatchNoWS() {
		return batchNoWS;
	}
	/**
	 * @param batchNoWS the batchNoWS to set
	 */
	public void setBatchNoWS(WebRowSet batchNoWS) {
		this.batchNoWS = batchNoWS;
	}
	/**
	 * @return the stockDetails
	 */
	public WebRowSet getStockDetailsWS() {
		return stockDetailsWS;
	}
	/**
	 * @param stockDetails the stockDetails to set
	 */
	public void setStockDetailsWS(WebRowSet stockDetailsWS) {
		this.stockDetailsWS = stockDetailsWS;
	}
	/**
	 * @return the emplyeeStockDetails
	 */
	public WebRowSet getEmplyeeStockDetailsWS() {
		return emplyeeStockDetailsWS;
	}
	/**
	 * @param emplyeeStockDetails the emplyeeStockDetails to set
	 */
	public void setEmplyeeStockDetailsWS(WebRowSet emplyeeStockDetailsWS) {
		this.emplyeeStockDetailsWS = emplyeeStockDetailsWS;
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
	 * @return the strReqTypeId
	 */
	public String getStrReqTypeId() {
		return strReqTypeId;
	}
	/**
	 * @param strReqTypeId the strReqTypeId to set
	 */
	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}
	/**
	 * @return the strIsBatchNo
	 */
	public String getStrIsBatchNo() {
		return strIsBatchNo;
	}
	/**
	 * @param strIsBatchNo the strIsBatchNo to set
	 */
	public void setStrIsBatchNo(String strIsBatchNo) {
		this.strIsBatchNo = strIsBatchNo;
	}
	/**
	 * @return the strIsSlNo
	 */
	public String getStrIsSlNo() {
		return strIsSlNo;
	}
	/**
	 * @param strIsSlNo the strIsSlNo to set
	 */
	public void setStrIsSlNo(String strIsSlNo) {
		this.strIsSlNo = strIsSlNo;
	}
	/**
	 * @return the strReservedFlag
	 */
	public String getStrReservedFlag() {
		return strReservedFlag;
	}
	/**
	 * @param strReservedFlag the strReservedFlag to set
	 */
	public void setStrReservedFlag(String strReservedFlag) {
		this.strReservedFlag = strReservedFlag;
	}
	public String getStrItemName() {
		return strItemName;
	}
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}

	

}
