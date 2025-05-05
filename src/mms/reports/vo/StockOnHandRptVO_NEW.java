/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         StockOnHandRptVO.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class StockOnHandRptVO.
 */
public class StockOnHandRptVO_NEW {

	/** The str mode. */
	private String strMode;

	/** The str hospital code. */
	private String strHospitalCode = "";

	/** The str seat id. */
	private String strSeatId = "";

	/** The str batch no. */
	private String strBatchNo = "";

	/** The str msg type. */
	private String strMsgType = "";

	/** The str msg string. */
	private String strMsgString = "";

	/** The str store id. */
	private String strStoreId = "";

	/** The str item cat id. */
	private String strItemCatId = "";

	/** The str drug name. */
	private String strDrugName = "";

	/** The str status id. */
	private String strStatusId = "";

	/** The str item cat no. */
	private String strItemCatNo = "";

	/** The str group id. */
	private String strGroupId = "";

	/** The str item cat ws. */
	private WebRowSet strItemCatWs = null;

	/** The str store ws. */
	private WebRowSet strStoreWs = null;

	/** The str group ws. */
	private WebRowSet strGroupWs = null;

	/** The str district store ws. */
	private WebRowSet strDistrictStoreWs = null;

	/** The str userlevel ws. */
	private WebRowSet strUserlevelWs = null;

	/** The str status id ws. */
	private WebRowSet strStatusIdWs = null;

	/** The str drug ws. */
	private WebRowSet strDrugWs = null;

	/** The str group cmb ws. */
	private WebRowSet strGroupCmbWS = null;

	/** The str circle id. */
	private String strCircleId = "";

	/** The str district id. */
	private String strDistrictId = "";

	/** The str store type id. */
	private String strStoreTypeId = "";
	
	private String strProgNameId = "";

	/** The str user level. */
	private String strUserLevel = "";

	/** The str circle ws. */
	private WebRowSet strCircleWS = null;

	/** The str district ws. */
	private WebRowSet strDistrictWS = null;

	/** The str store type ws. */
	private WebRowSet strStoreTypeWS = null;

	/** The str item type. */
	private String strItemType = "";

	/** The str district store id. */
	private String strDistrictStoreId;

	/** The item type ws. */
	private WebRowSet itemTypeWs = null;

	/** The str prog name combo ws. */
	private WebRowSet strProgNameComboWS = null;
	
	private WebRowSet drugClassWs = null;
	private WebRowSet strSectionWS = null;
	private WebRowSet strStockInHandRptWS = null;
	
	private String strCircleName;

	/** The str district name. */
	private String strDistrictName;

	/** The str store type name. */
	private String strStoreTypeName;

	/** The str sub store name. */
	private String strSubStoreName;
	
	private String strStoreName;
	

	private String strItemBrandId;

	private String strCatCode;

	private String strUserName;
	
	private String strTableWidth;
	


	/** The str header ws. */
	private WebRowSet strHeaderWS = null;

	/** The str drug list ws. */
	private WebRowSet strDrugListWS = null;
	
	
	private String strGroupName;
	private String strDrugTypeName;
	private String strIsItemWise;
	private String strIsGroupWise;
	private String strLogoName ="";

	
	public String getStrLogoName() {
		return strLogoName;
	}
	public void setStrLogoName(String strLogoName) {
		this.strLogoName = strLogoName;
	}
	
	
	

	public String getStrGroupName() {
		return strGroupName;
	}

	public void setStrGroupName(String strGroupName) {
		this.strGroupName = strGroupName;
	}

	public String getStrDrugTypeName() {
		return strDrugTypeName;
	}

	public void setStrDrugTypeName(String strDrugTypeName) {
		this.strDrugTypeName = strDrugTypeName;
	}

	public String getStrIsItemWise() {
		return strIsItemWise;
	}

	public void setStrIsItemWise(String strIsItemWise) {
		this.strIsItemWise = strIsItemWise;
	}

	public String getStrIsGroupWise() {
		return strIsGroupWise;
	}

	public void setStrIsGroupWise(String strIsGroupWise) {
		this.strIsGroupWise = strIsGroupWise;
	}

	public WebRowSet getStrHeaderWS() {
		return strHeaderWS;
	}

	public void setStrHeaderWS(WebRowSet strHeaderWS) {
		this.strHeaderWS = strHeaderWS;
	}

	public WebRowSet getStrDrugListWS() {
		return strDrugListWS;
	}

	public void setStrDrugListWS(WebRowSet strDrugListWS) {
		this.strDrugListWS = strDrugListWS;
	}

	public String getStrTableWidth() {
		return strTableWidth;
	}

	public void setStrTableWidth(String strTableWidth) {
		this.strTableWidth = strTableWidth;
	}

	public String getStrItemBrandId() {
		return strItemBrandId;
	}

	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}

	public String getStrCatCode() {
		return strCatCode;
	}

	public void setStrCatCode(String strCatCode) {
		this.strCatCode = strCatCode;
	}

	public String getStrUserName() {
		return strUserName;
	}

	public void setStrUserName(String strUserName) {
		this.strUserName = strUserName;
	}

	public WebRowSet getDrugClassWs() {
		return drugClassWs;
	}

	public void setDrugClassWs(WebRowSet drugClassWs) {
		this.drugClassWs = drugClassWs;
	}

	public WebRowSet getStrSectionWS() {
		return strSectionWS;
	}

	public void setStrSectionWS(WebRowSet strSectionWS) {
		this.strSectionWS = strSectionWS;
	}

	public WebRowSet getStrStockInHandRptWS() {
		return strStockInHandRptWS;
	}

	public void setStrStockInHandRptWS(WebRowSet strStockInHandRptWS) {
		this.strStockInHandRptWS = strStockInHandRptWS;
	}

	public String getStrCircleName() {
		return strCircleName;
	}

	public void setStrCircleName(String strCircleName) {
		this.strCircleName = strCircleName;
	}

	public String getStrDistrictName() {
		return strDistrictName;
	}

	public void setStrDistrictName(String strDistrictName) {
		this.strDistrictName = strDistrictName;
	}

	public String getStrStoreTypeName() {
		return strStoreTypeName;
	}

	public void setStrStoreTypeName(String strStoreTypeName) {
		this.strStoreTypeName = strStoreTypeName;
	}

	public String getStrSubStoreName() {
		return strSubStoreName;
	}

	public void setStrSubStoreName(String strSubStoreName) {
		this.strSubStoreName = strSubStoreName;
	}

	public String getStrStoreName() {
		return strStoreName;
	}

	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}

	/**
	 * Gets the str prog name combo ws.
	 * 
	 * @return the str prog name combo ws
	 */
	public WebRowSet getStrProgNameComboWS() {
		return strProgNameComboWS;
	}

	/**
	 * Sets the str prog name combo ws.
	 * 
	 * @param strProgNameComboWS
	 *            the new str prog name combo ws
	 */
	public void setStrProgNameComboWS(WebRowSet strProgNameComboWS) {
		this.strProgNameComboWS = strProgNameComboWS;
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
	 * Gets the str district store id.
	 * 
	 * @return the str district store id
	 */
	public String getStrDistrictStoreId() {
		return strDistrictStoreId;
	}

	/**
	 * Sets the str district store id.
	 * 
	 * @param strDistrictStoreId
	 *            the new str district store id
	 */
	public void setStrDistrictStoreId(String strDistrictStoreId) {
		this.strDistrictStoreId = strDistrictStoreId;
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
	 * Gets the str drug ws.
	 * 
	 * @return the str drug ws
	 */
	public WebRowSet getStrDrugWs() {
		return strDrugWs;
	}

	/**
	 * Sets the str drug ws.
	 * 
	 * @param strDrugWs
	 *            the new str drug ws
	 */
	public void setStrDrugWs(WebRowSet strDrugWs) {
		this.strDrugWs = strDrugWs;
	}

	/**
	 * Gets the str status id ws.
	 * 
	 * @return the str status id ws
	 */
	public WebRowSet getStrStatusIdWs() {
		return strStatusIdWs;
	}

	/**
	 * Sets the str status id ws.
	 * 
	 * @param strStatusIdWs
	 *            the new str status id ws
	 */
	public void setStrStatusIdWs(WebRowSet strStatusIdWs) {
		this.strStatusIdWs = strStatusIdWs;
	}

	/**
	 * Gets the str userlevel ws.
	 * 
	 * @return the str userlevel ws
	 */
	public WebRowSet getStrUserlevelWs() {
		return strUserlevelWs;
	}

	/**
	 * Sets the str userlevel ws.
	 * 
	 * @param strUserlevelWs
	 *            the new str userlevel ws
	 */
	public void setStrUserlevelWs(WebRowSet strUserlevelWs) {
		this.strUserlevelWs = strUserlevelWs;
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
	 * Gets the str district store ws.
	 * 
	 * @return the str district store ws
	 */
	public WebRowSet getStrDistrictStoreWs() {
		return strDistrictStoreWs;
	}

	/**
	 * Sets the str district store ws.
	 * 
	 * @param strDistrictStoreWs
	 *            the new str district store ws
	 */
	public void setStrDistrictStoreWs(WebRowSet strDistrictStoreWs) {
		this.strDistrictStoreWs = strDistrictStoreWs;
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
	 * Gets the str status id.
	 * 
	 * @return the str status id
	 */
	public String getStrStatusId() {
		return strStatusId;
	}

	/**
	 * Sets the str status id.
	 * 
	 * @param strStatusId
	 *            the new str status id
	 */
	public void setStrStatusId(String strStatusId) {
		this.strStatusId = strStatusId;
	}

	/**
	 * Gets the str item cat no.
	 * 
	 * @return the str item cat no
	 */
	public String getStrItemCatNo() {
		return strItemCatNo;
	}

	/**
	 * Sets the str item cat no.
	 * 
	 * @param strItemCatNo
	 *            the new str item cat no
	 */
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
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
	 * Gets the str circle ws.
	 * 
	 * @return the str circle ws
	 */
	public WebRowSet getStrCircleWS() {
		return strCircleWS;
	}

	/**
	 * Sets the str circle ws.
	 * 
	 * @param strCircleWS
	 *            the new str circle ws
	 */
	public void setStrCircleWS(WebRowSet strCircleWS) {
		this.strCircleWS = strCircleWS;
	}

	/**
	 * Gets the str circle id.
	 * 
	 * @return the str circle id
	 */
	public String getStrCircleId() {
		return strCircleId;
	}

	/**
	 * Sets the str circle id.
	 * 
	 * @param strCircleId
	 *            the new str circle id
	 */
	public void setStrCircleId(String strCircleId) {
		this.strCircleId = strCircleId;
	}

	/**
	 * Gets the str user level.
	 * 
	 * @return the str user level
	 */
	public String getStrUserLevel() {
		return strUserLevel;
	}

	/**
	 * Sets the str user level.
	 * 
	 * @param strUserLevel
	 *            the new str user level
	 */
	public void setStrUserLevel(String strUserLevel) {
		this.strUserLevel = strUserLevel;
	}

	/**
	 * Gets the str district ws.
	 * 
	 * @return the str district ws
	 */
	public WebRowSet getStrDistrictWS() {
		return strDistrictWS;
	}

	/**
	 * Sets the str district ws.
	 * 
	 * @param strDistrictWS
	 *            the new str district ws
	 */
	public void setStrDistrictWS(WebRowSet strDistrictWS) {
		this.strDistrictWS = strDistrictWS;
	}

	/**
	 * Gets the str district id.
	 * 
	 * @return the str district id
	 */
	public String getStrDistrictId() {
		return strDistrictId;
	}

	/**
	 * Sets the str district id.
	 * 
	 * @param strDistrictId
	 *            the new str district id
	 */
	public void setStrDistrictId(String strDistrictId) {
		this.strDistrictId = strDistrictId;
	}

	/**
	 * Gets the str store type ws.
	 * 
	 * @return the str store type ws
	 */
	public WebRowSet getStrStoreTypeWS() {
		return strStoreTypeWS;
	}

	/**
	 * Sets the str store type ws.
	 * 
	 * @param strStoreTypeWS
	 *            the new str store type ws
	 */
	public void setStrStoreTypeWS(WebRowSet strStoreTypeWS) {
		this.strStoreTypeWS = strStoreTypeWS;
	}

	/**
	 * Gets the str store type id.
	 * 
	 * @return the str store type id
	 */
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}

	/**
	 * Sets the str store type id.
	 * 
	 * @param strStoreTypeId
	 *            the new str store type id
	 */
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
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

	public String getStrProgNameId() {
		return strProgNameId;
	}

	public void setStrProgNameId(String strProgNameId) {
		this.strProgNameId = strProgNameId;
	}

}
