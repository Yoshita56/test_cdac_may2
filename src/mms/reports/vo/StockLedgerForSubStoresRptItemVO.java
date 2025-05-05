/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         StockLedgerForSubStoresRptVO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * Developer : Vivek Aggarwal Version : 1.0 Date : 16-Mar-2012 Modification
 * Date:
 * 
 */
public class StockLedgerForSubStoresRptItemVO {

	/** The str hospital code. */
	private String strHospitalCode = "";

	/** The str seat id. */
	private String strSeatId = "";

	/** The str msg type. */
	private String strMsgType = "";

	/** The str msg string. */
	private String strMsgString = "";

	/** The str store id. */
	private String strStoreId = "";

	/** The str group id. */
	private String strGroupId = "";

	/** The str item cat id. */
	private String strItemCatId = "";

	/** The str whether batch wise. */
	private String strWhetherBatchWise;

	/** The str dwh id. */
	private String strDWHId;

	/** The str item id. */
	private String strItemId;

	/** The str mode. */
	private String strMode;

	/** The str from date. */
	private String strFromDate;

	/** The str to date. */
	private String strToDate;

	/** The str batch flag. */
	private String strBatchFlag;

	/** The str item brand id. */
	private String strItemBrandId;

	/** The str drug name. */
	private String strDrugName;

	/** The str store name. */
	private String strStoreName;

	/** The str opening balance. */
	private String strOpeningBalance;

	/** The str item cat ws. */
	private WebRowSet strItemCatWs;

	/** The str store ws. */
	private WebRowSet strStoreWs;

	/** The str group ws. */
	private WebRowSet strGroupWs;

	/** The str item ws. */
	private WebRowSet strItemWs;

	/** The str stock ledger dtl ws. */
	private WebRowSet strStockLedgerDtlWs;

	/** The wrs data. */
	private WebRowSet wrsData;

	/** The str batch no. */
	private String strBatchNo;

	/** The str exp date. */
	private String strExpDate;

	/** The item type ws. */
	private WebRowSet itemTypeWs = null;

	/** The str group cmb ws. */
	private WebRowSet strGroupCmbWS = null;

	/** The str item type. */
	private String strItemType;
	private String strSectionName="",strSectionId="";
	private WebRowSet strSectionbWS = null;

	public String getStrSectionName() {
		return strSectionName;
	}

	public void setStrSectionName(String strSectionName) {
		this.strSectionName = strSectionName;
	}

	public String getStrSectionId() {
		return strSectionId;
	}

	public void setStrSectionId(String strSectionId) {
		this.strSectionId = strSectionId;
	}

	public WebRowSet getStrSectionbWS() {
		return strSectionbWS;
	}

	public void setStrSectionbWS(WebRowSet strSectionbWS) {
		this.strSectionbWS = strSectionbWS;
	}

	/**
	 * Gets the wrs data.
	 * 
	 * @return the wrs data
	 */
	public WebRowSet getWrsData() {
		return wrsData;
	}

	/**
	 * Sets the wrs data.
	 * 
	 * @param wrsData
	 *            the new wrs data
	 */
	public void setWrsData(WebRowSet wrsData) {
		this.wrsData = wrsData;
	}

	/**
	 * Gets the str hospital code.
	 * 
	 * @return the strHospitalCode
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	/**
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode
	 *            the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Gets the str seat id.
	 * 
	 * @return the strSeatId
	 */
	public String getStrSeatId() {
		return strSeatId;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strSeatId
	 *            the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * Gets the str msg type.
	 * 
	 * @return the strMsgType
	 */
	public String getStrMsgType() {
		return strMsgType;
	}

	/**
	 * Sets the str msg type.
	 * 
	 * @param strMsgType
	 *            the strMsgType to set
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	/**
	 * Gets the str msg string.
	 * 
	 * @return the strMsgString
	 */
	public String getStrMsgString() {
		return strMsgString;
	}

	/**
	 * Sets the str msg string.
	 * 
	 * @param strMsgString
	 *            the strMsgString to set
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	/**
	 * Gets the str store id.
	 * 
	 * @return the strStoreId
	 */
	public String getStrStoreId() {
		return strStoreId;
	}

	/**
	 * Sets the str store id.
	 * 
	 * @param strStoreId
	 *            the strStoreId to set
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	/**
	 * Gets the str item cat id.
	 * 
	 * @return the strItemCatId
	 */
	public String getStrItemCatId() {
		return strItemCatId;
	}

	/**
	 * Sets the str item cat id.
	 * 
	 * @param strItemCatId
	 *            the strItemCatId to set
	 */
	public void setStrItemCatId(String strItemCatId) {
		this.strItemCatId = strItemCatId;
	}

	/**
	 * Gets the str item cat ws.
	 * 
	 * @return the strItemCatWs
	 */
	public WebRowSet getStrItemCatWs() {
		return strItemCatWs;
	}

	/**
	 * Sets the str item cat ws.
	 * 
	 * @param strItemCatWs
	 *            the strItemCatWs to set
	 */
	public void setStrItemCatWs(WebRowSet strItemCatWs) {
		this.strItemCatWs = strItemCatWs;
	}

	/**
	 * Gets the str store ws.
	 * 
	 * @return the strStoreWs
	 */
	public WebRowSet getStrStoreWs() {
		return strStoreWs;
	}

	/**
	 * Sets the str store ws.
	 * 
	 * @param strStoreWs
	 *            the strStoreWs to set
	 */
	public void setStrStoreWs(WebRowSet strStoreWs) {
		this.strStoreWs = strStoreWs;
	}

	/**
	 * Gets the str group ws.
	 * 
	 * @return the strGroupWs
	 */
	public WebRowSet getStrGroupWs() {
		return strGroupWs;
	}

	/**
	 * Sets the str group ws.
	 * 
	 * @param strGroupWs
	 *            the strGroupWs to set
	 */
	public void setStrGroupWs(WebRowSet strGroupWs) {
		this.strGroupWs = strGroupWs;
	}

	/**
	 * Gets the str group id.
	 * 
	 * @return the str group id
	 */
	public String getStrGroupId() {
		return strGroupId;
	}

	/**
	 * Sets the str group id.
	 * 
	 * @param strGroupId
	 *            the new str group id
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * Gets the str item ws.
	 * 
	 * @return the str item ws
	 */
	public WebRowSet getStrItemWs() {
		return strItemWs;
	}

	/**
	 * Sets the str item ws.
	 * 
	 * @param strItemWs
	 *            the new str item ws
	 */
	public void setStrItemWs(WebRowSet strItemWs) {
		this.strItemWs = strItemWs;
	}

	/**
	 * Gets the str from date.
	 * 
	 * @return the str from date
	 */
	public String getStrFromDate() {
		return strFromDate;
	}

	/**
	 * Sets the str from date.
	 * 
	 * @param strFromDate
	 *            the new str from date
	 */
	public void setStrFromDate(String strFromDate) {
		this.strFromDate = strFromDate;
	}

	/**
	 * Gets the str to date.
	 * 
	 * @return the str to date
	 */
	public String getStrToDate() {
		return strToDate;
	}

	/**
	 * Sets the str to date.
	 * 
	 * @param strToDate
	 *            the new str to date
	 */
	public void setStrToDate(String strToDate) {
		this.strToDate = strToDate;
	}

	/**
	 * Gets the str whether batch wise.
	 * 
	 * @return the str whether batch wise
	 */
	public String getStrWhetherBatchWise() {
		return strWhetherBatchWise;
	}

	/**
	 * Sets the str whether batch wise.
	 * 
	 * @param strWhetherBatchWise
	 *            the new str whether batch wise
	 */
	public void setStrWhetherBatchWise(String strWhetherBatchWise) {
		this.strWhetherBatchWise = strWhetherBatchWise;
	}

	/**
	 * Gets the str item id.
	 * 
	 * @return the str item id
	 */
	public String getStrItemId() {
		return strItemId;
	}

	/**
	 * Sets the str item id.
	 * 
	 * @param strItemId
	 *            the new str item id
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	/**
	 * Gets the str stock ledger dtl ws.
	 * 
	 * @return the str stock ledger dtl ws
	 */
	public WebRowSet getStrStockLedgerDtlWs() {
		return strStockLedgerDtlWs;
	}

	/**
	 * Sets the str stock ledger dtl ws.
	 * 
	 * @param strStockLedgerDtlWs
	 *            the new str stock ledger dtl ws
	 */
	public void setStrStockLedgerDtlWs(WebRowSet strStockLedgerDtlWs) {
		this.strStockLedgerDtlWs = strStockLedgerDtlWs;
	}

	/**
	 * Gets the str mode.
	 * 
	 * @return the str mode
	 */
	public String getStrMode() {
		return strMode;
	}

	/**
	 * Sets the str mode.
	 * 
	 * @param strMode
	 *            the new str mode
	 */
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}

	/**
	 * Gets the str dwh id.
	 * 
	 * @return the str dwh id
	 */
	public String getStrDWHId() {
		return strDWHId;
	}

	/**
	 * Sets the str dwh id.
	 * 
	 * @param strDWHId
	 *            the new str dwh id
	 */
	public void setStrDWHId(String strDWHId) {
		this.strDWHId = strDWHId;
	}

	/**
	 * Gets the str batch flag.
	 * 
	 * @return the str batch flag
	 */
	public String getStrBatchFlag() {
		return strBatchFlag;
	}

	/**
	 * Sets the str batch flag.
	 * 
	 * @param strBatchFlag
	 *            the new str batch flag
	 */
	public void setStrBatchFlag(String strBatchFlag) {
		this.strBatchFlag = strBatchFlag;
	}

	/**
	 * Gets the str item brand id.
	 * 
	 * @return the str item brand id
	 */
	public String getStrItemBrandId() {
		return strItemBrandId;
	}

	/**
	 * Sets the str item brand id.
	 * 
	 * @param strItemBrandId
	 *            the new str item brand id
	 */
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}

	/**
	 * Gets the str drug name.
	 * 
	 * @return the str drug name
	 */
	public String getStrDrugName() {
		return strDrugName;
	}

	/**
	 * Sets the str drug name.
	 * 
	 * @param strDrugName
	 *            the new str drug name
	 */
	public void setStrDrugName(String strDrugName) {
		this.strDrugName = strDrugName;
	}

	/**
	 * Gets the str store name.
	 * 
	 * @return the str store name
	 */
	public String getStrStoreName() {
		return strStoreName;
	}

	/**
	 * Sets the str store name.
	 * 
	 * @param strStoreName
	 *            the new str store name
	 */
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}

	/**
	 * Gets the str opening balance.
	 * 
	 * @return the str opening balance
	 */
	public String getStrOpeningBalance() {
		return strOpeningBalance;
	}

	/**
	 * Sets the str opening balance.
	 * 
	 * @param strOpeningBalance
	 *            the new str opening balance
	 */
	public void setStrOpeningBalance(String strOpeningBalance) {
		this.strOpeningBalance = strOpeningBalance;
	}

	/**
	 * Gets the str batch no.
	 * 
	 * @return the str batch no
	 */
	public String getStrBatchNo() {
		return strBatchNo;
	}

	/**
	 * Sets the str batch no.
	 * 
	 * @param strBatchNo
	 *            the new str batch no
	 */
	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}

	/**
	 * Gets the str exp date.
	 * 
	 * @return the str exp date
	 */
	public String getStrExpDate() {
		return strExpDate;
	}

	/**
	 * Sets the str exp date.
	 * 
	 * @param strExpDate
	 *            the new str exp date
	 */
	public void setStrExpDate(String strExpDate) {
		this.strExpDate = strExpDate;
	}

	/**
	 * Gets the item type ws.
	 * 
	 * @return the item type ws
	 */
	public WebRowSet getItemTypeWs() {
		return itemTypeWs;
	}

	/**
	 * Sets the item type ws.
	 * 
	 * @param itemTypeWs
	 *            the new item type ws
	 */
	public void setItemTypeWs(WebRowSet itemTypeWs) {
		this.itemTypeWs = itemTypeWs;
	}

	/**
	 * Gets the str group cmb ws.
	 * 
	 * @return the str group cmb ws
	 */
	public WebRowSet getStrGroupCmbWS() {
		return strGroupCmbWS;
	}

	/**
	 * Sets the str group cmb ws.
	 * 
	 * @param strGroupCmbWS
	 *            the new str group cmb ws
	 */
	public void setStrGroupCmbWS(WebRowSet strGroupCmbWS) {
		this.strGroupCmbWS = strGroupCmbWS;
	}

	/**
	 * Gets the str item type.
	 * 
	 * @return the str item type
	 */
	public String getStrItemType() {
		return strItemType;
	}

	/**
	 * Sets the str item type.
	 * 
	 * @param strItemType
	 *            the new str item type
	 */
	public void setStrItemType(String strItemType) {
		this.strItemType = strItemType;
	}

}
