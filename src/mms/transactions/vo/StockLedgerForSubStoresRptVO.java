package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

/**
 * Developer : Vivek Aggarwal
 * Version : 1.0
 * Date : 16-Mar-2012
 * Modification Date: 
 *  
*/
public class StockLedgerForSubStoresRptVO {
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strMsgType = "";
	private String strMsgString = "";
	
	private String strStoreId = "";
	private String strGroupId = "";
	private String strItemCatId = "";
	private String strWhetherBatchWise;
	
	private String strDWHId;
	private String strItemId;
	private String strMode;
	
	private String strFromDate;
	private String strToDate;
	private String strBatchFlag;
	private String strItemBrandId;
	private String strDrugName;
	private String strStoreName;
	
	private String strOpeningBalance;
	
	private WebRowSet strItemCatWs;
	private WebRowSet strStoreWs;
	private WebRowSet strGroupWs;
	private WebRowSet strItemWs;
	private WebRowSet strStockLedgerDtlWs;
	private WebRowSet wrsData;
	
	private String strBatchNo;
	private String strExpDate;
	
	private WebRowSet itemTypeWs=null;
	private WebRowSet strGroupCmbWS=null;
	
	private String strItemType;
	private String strProgId;
	private String strProgName;
	
	public WebRowSet getWrsData() {
		return wrsData;
	}
	public void setWrsData(WebRowSet wrsData) {
		this.wrsData = wrsData;
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
	 * @return the strItemCatId
	 */
	public String getStrItemCatId() {
		return strItemCatId;
	}
	/**
	 * @param strItemCatId the strItemCatId to set
	 */
	public void setStrItemCatId(String strItemCatId) {
		this.strItemCatId = strItemCatId;
	}
	/**
	 * @return the strItemCatWs
	 */
	public WebRowSet getStrItemCatWs() {
		return strItemCatWs;
	}
	/**
	 * @param strItemCatWs the strItemCatWs to set
	 */
	public void setStrItemCatWs(WebRowSet strItemCatWs) {
		this.strItemCatWs = strItemCatWs;
	}
	/**
	 * @return the strStoreWs
	 */
	public WebRowSet getStrStoreWs() {
		return strStoreWs;
	}
	/**
	 * @param strStoreWs the strStoreWs to set
	 */
	public void setStrStoreWs(WebRowSet strStoreWs) {
		this.strStoreWs = strStoreWs;
	}
	/**
	 * @return the strGroupWs
	 */
	public WebRowSet getStrGroupWs() {
		return strGroupWs;
	}
	/**
	 * @param strGroupWs the strGroupWs to set
	 */
	public void setStrGroupWs(WebRowSet strGroupWs) {
		this.strGroupWs = strGroupWs;
	}
	public String getStrGroupId() {
		return strGroupId;
	}
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}
	public WebRowSet getStrItemWs() {
		return strItemWs;
	}
	public void setStrItemWs(WebRowSet strItemWs) {
		this.strItemWs = strItemWs;
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
	public String getStrWhetherBatchWise() {
		return strWhetherBatchWise;
	}
	public void setStrWhetherBatchWise(String strWhetherBatchWise) {
		this.strWhetherBatchWise = strWhetherBatchWise;
	}
	public String getStrItemId() {
		return strItemId;
	}
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}
	public WebRowSet getStrStockLedgerDtlWs() {
		return strStockLedgerDtlWs;
	}
	public void setStrStockLedgerDtlWs(WebRowSet strStockLedgerDtlWs) {
		this.strStockLedgerDtlWs = strStockLedgerDtlWs;
	}
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
	public String getStrDWHId() {
		return strDWHId;
	}
	public void setStrDWHId(String strDWHId) {
		this.strDWHId = strDWHId;
	}
	public String getStrBatchFlag() {
		return strBatchFlag;
	}
	public void setStrBatchFlag(String strBatchFlag) {
		this.strBatchFlag = strBatchFlag;
	}
	public String getStrItemBrandId() {
		return strItemBrandId;
	}
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}
	public String getStrDrugName() {
		return strDrugName;
	}
	public void setStrDrugName(String strDrugName) {
		this.strDrugName = strDrugName;
	}
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String getStrOpeningBalance() {
		return strOpeningBalance;
	}
	public void setStrOpeningBalance(String strOpeningBalance) {
		this.strOpeningBalance = strOpeningBalance;
	}
	public String getStrBatchNo() {
		return strBatchNo;
	}
	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}
	public String getStrExpDate() {
		return strExpDate;
	}
	public void setStrExpDate(String strExpDate) {
		this.strExpDate = strExpDate;
	}
	public WebRowSet getItemTypeWs() {
		return itemTypeWs;
	}
	public void setItemTypeWs(WebRowSet itemTypeWs) {
		this.itemTypeWs = itemTypeWs;
	}
	public WebRowSet getStrGroupCmbWS() {
		return strGroupCmbWS;
	}
	public void setStrGroupCmbWS(WebRowSet strGroupCmbWS) {
		this.strGroupCmbWS = strGroupCmbWS;
	}
	public String getStrItemType() {
		return strItemType;
	}
	public void setStrItemType(String strItemType) {
		this.strItemType = strItemType;
	}
	public String getStrProgId() {
		return strProgId;
	}
	public void setStrProgId(String strProgId) {
		this.strProgId = strProgId;
	}
	public String getStrProgName() {
		return strProgName;
	}
	public void setStrProgName(String strProgName) {
		this.strProgName = strProgName;
	}

}
