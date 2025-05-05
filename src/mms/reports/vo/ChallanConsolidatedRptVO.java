/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         ChallanConsolidatedRptVO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class ChallanConsolidatedRptVO.
 */
public class ChallanConsolidatedRptVO {

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

	/** The str user level. */
	private String strUserLevel = "";

	/** The str circle ws. */
	private WebRowSet strCircleWS = null;

	/** The str district ws. */
	private WebRowSet strDistrictWS = null;

	/** The str store type ws. */
	private WebRowSet strStoreTypeWS = null;

	/** The str po combo ws. */
	private WebRowSet strPOComboWS = null;

	/** The str item type. */
	private String strItemType = "";

	/** The str district store id. */
	private String strDistrictStoreId;

	/** The item type ws. */
	private WebRowSet itemTypeWs = null;

	/** The str header ws. */
	private WebRowSet strHeaderWS = null;

	/** The str drug list ws. */
	private WebRowSet strDrugListWS = null;

	/** The str challan dtl ws. */
	private WebRowSet strChallanDtlWS = null;

	/** The str supplier ws. */
	private WebRowSet strSupplierWS = null;

	/** The str report id. */
	private String strReportId = "";

	/** The str cat code. */
	private String strCatCode = "";

	/** The str user remarks. */
	private String strUserRemarks = "";

	/** The str current date. */
	private String strCurrentDate = "";

	/** The str particular date. */
	private String strParticularDate = "";

	/** The str item brand id. */
	private String strItemBrandId = "";

	/** The str is group wise. */
	private String strIsGroupWise = "";

	/** The str is item wise. */
	private String strIsItemWise = "";

	/** The str table width. */
	private String strTableWidth = "";

	/** The str zero vital flg. */
	private String strZeroVitalFlg = "";

	/** The str from date. */
	private String strFromDate = "";

	/** The str to date. */
	private String strToDate = "";

	/** The str item id. */
	private String strItemId = "";

	/** The str po no. */
	private String strPONo = "";

	/** The str user name. */
	private String strUserName = "";

	/** The str circle name. */
	private String strCircleName = "";

	/** The str district name. */
	private String strDistrictName = "";

	/** The str district store name. */
	private String strDistrictStoreName = "";

	/** The str supplier wise rpt flg. */
	private String strSupplierWiseRptFlg = "";

	/** The str supplier id. */
	private String strSupplierId = "";

	/** The str po type id. */
	private String strPOTypeId = "";

	/**
	 * Gets the str po type id.
	 * 
	 * @return the str po type id
	 */
	public String getStrPOTypeId() {
		return strPOTypeId;
	}

	/**
	 * Sets the str po type id.
	 * 
	 * @param strPOTypeId
	 *            the new str po type id
	 */
	public void setStrPOTypeId(String strPOTypeId) {
		this.strPOTypeId = strPOTypeId;
	}

	/**
	 * Gets the str supplier id.
	 * 
	 * @return the str supplier id
	 */
	public String getStrSupplierId() {
		return strSupplierId;
	}

	/**
	 * Sets the str supplier id.
	 * 
	 * @param strSupplierId
	 *            the new str supplier id
	 */
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}

	/**
	 * Gets the str supplier wise rpt flg.
	 * 
	 * @return the str supplier wise rpt flg
	 */
	public String getStrSupplierWiseRptFlg() {
		return strSupplierWiseRptFlg;
	}

	/**
	 * Sets the str supplier wise rpt flg.
	 * 
	 * @param strSupplierWiseRptFlg
	 *            the new str supplier wise rpt flg
	 */
	public void setStrSupplierWiseRptFlg(String strSupplierWiseRptFlg) {
		this.strSupplierWiseRptFlg = strSupplierWiseRptFlg;
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
	 * Gets the str table width.
	 * 
	 * @return the str table width
	 */
	public String getStrTableWidth() {
		return strTableWidth;
	}

	/**
	 * Sets the str table width.
	 * 
	 * @param strTableWidth
	 *            the new str table width
	 */
	public void setStrTableWidth(String strTableWidth) {
		this.strTableWidth = strTableWidth;
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

	/**
	 * Gets the str report id.
	 * 
	 * @return the str report id
	 */
	public String getStrReportId() {
		return strReportId;
	}

	/**
	 * Sets the str report id.
	 * 
	 * @param strReportId
	 *            the new str report id
	 */
	public void setStrReportId(String strReportId) {
		this.strReportId = strReportId;
	}

	/**
	 * Gets the str cat code.
	 * 
	 * @return the str cat code
	 */
	public String getStrCatCode() {
		return strCatCode;
	}

	/**
	 * Sets the str cat code.
	 * 
	 * @param strCatCode
	 *            the new str cat code
	 */
	public void setStrCatCode(String strCatCode) {
		this.strCatCode = strCatCode;
	}

	/**
	 * Gets the str user remarks.
	 * 
	 * @return the str user remarks
	 */
	public String getStrUserRemarks() {
		return strUserRemarks;
	}

	/**
	 * Sets the str user remarks.
	 * 
	 * @param strUserRemarks
	 *            the new str user remarks
	 */
	public void setStrUserRemarks(String strUserRemarks) {
		this.strUserRemarks = strUserRemarks;
	}

	/**
	 * Gets the str current date.
	 * 
	 * @return the str current date
	 */
	public String getStrCurrentDate() {
		return strCurrentDate;
	}

	/**
	 * Sets the str current date.
	 * 
	 * @param strCurrentDate
	 *            the new str current date
	 */
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}

	/**
	 * Gets the str particular date.
	 * 
	 * @return the str particular date
	 */
	public String getStrParticularDate() {
		return strParticularDate;
	}

	/**
	 * Sets the str particular date.
	 * 
	 * @param strParticularDate
	 *            the new str particular date
	 */
	public void setStrParticularDate(String strParticularDate) {
		this.strParticularDate = strParticularDate;
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
	 * Gets the str is group wise.
	 * 
	 * @return the str is group wise
	 */
	public String getStrIsGroupWise() {
		return strIsGroupWise;
	}

	/**
	 * Sets the str is group wise.
	 * 
	 * @param strIsGroupWise
	 *            the new str is group wise
	 */
	public void setStrIsGroupWise(String strIsGroupWise) {
		this.strIsGroupWise = strIsGroupWise;
	}

	/**
	 * Gets the str is item wise.
	 * 
	 * @return the str is item wise
	 */
	public String getStrIsItemWise() {
		return strIsItemWise;
	}

	/**
	 * Sets the str is item wise.
	 * 
	 * @param strIsItemWise
	 *            the new str is item wise
	 */
	public void setStrIsItemWise(String strIsItemWise) {
		this.strIsItemWise = strIsItemWise;
	}

	/**
	 * Gets the str header ws.
	 * 
	 * @return the str header ws
	 */
	public WebRowSet getStrHeaderWS() {
		return strHeaderWS;
	}

	/**
	 * Sets the str header ws.
	 * 
	 * @param strHeaderWS
	 *            the new str header ws
	 */
	public void setStrHeaderWS(WebRowSet strHeaderWS) {
		this.strHeaderWS = strHeaderWS;
	}

	/**
	 * Gets the str drug list ws.
	 * 
	 * @return the str drug list ws
	 */
	public WebRowSet getStrDrugListWS() {
		return strDrugListWS;
	}

	/**
	 * Sets the str drug list ws.
	 * 
	 * @param strDrugListWS
	 *            the new str drug list ws
	 */
	public void setStrDrugListWS(WebRowSet strDrugListWS) {
		this.strDrugListWS = strDrugListWS;
	}

	/**
	 * Gets the str zero vital flg.
	 * 
	 * @return the str zero vital flg
	 */
	public String getStrZeroVitalFlg() {
		return strZeroVitalFlg;
	}

	/**
	 * Sets the str zero vital flg.
	 * 
	 * @param strZeroVitalFlg
	 *            the new str zero vital flg
	 */
	public void setStrZeroVitalFlg(String strZeroVitalFlg) {
		this.strZeroVitalFlg = strZeroVitalFlg;
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
	 * Gets the str po combo ws.
	 * 
	 * @return the str po combo ws
	 */
	public WebRowSet getStrPOComboWS() {
		return strPOComboWS;
	}

	/**
	 * Sets the str po combo ws.
	 * 
	 * @param strPOComboWS
	 *            the new str po combo ws
	 */
	public void setStrPOComboWS(WebRowSet strPOComboWS) {
		this.strPOComboWS = strPOComboWS;
	}

	/**
	 * Gets the str po no.
	 * 
	 * @return the str po no
	 */
	public String getStrPONo() {
		return strPONo;
	}

	/**
	 * Sets the str po no.
	 * 
	 * @param strPONo
	 *            the new str po no
	 */
	public void setStrPONo(String strPONo) {
		this.strPONo = strPONo;
	}

	/**
	 * Gets the str challan dtl ws.
	 * 
	 * @return the str challan dtl ws
	 */
	public WebRowSet getStrChallanDtlWS() {
		return strChallanDtlWS;
	}

	/**
	 * Sets the str challan dtl ws.
	 * 
	 * @param strChallanDtlWS
	 *            the new str challan dtl ws
	 */
	public void setStrChallanDtlWS(WebRowSet strChallanDtlWS) {
		this.strChallanDtlWS = strChallanDtlWS;
	}

	/**
	 * Gets the str user name.
	 * 
	 * @return the str user name
	 */
	public String getStrUserName() {
		return strUserName;
	}

	/**
	 * Sets the str user name.
	 * 
	 * @param strUserName
	 *            the new str user name
	 */
	public void setStrUserName(String strUserName) {
		this.strUserName = strUserName;
	}

	/**
	 * Gets the str circle name.
	 * 
	 * @return the str circle name
	 */
	public String getStrCircleName() {
		return strCircleName;
	}

	/**
	 * Sets the str circle name.
	 * 
	 * @param strCircleName
	 *            the new str circle name
	 */
	public void setStrCircleName(String strCircleName) {
		this.strCircleName = strCircleName;
	}

	/**
	 * Gets the str district name.
	 * 
	 * @return the str district name
	 */
	public String getStrDistrictName() {
		return strDistrictName;
	}

	/**
	 * Sets the str district name.
	 * 
	 * @param strDistrictName
	 *            the new str district name
	 */
	public void setStrDistrictName(String strDistrictName) {
		this.strDistrictName = strDistrictName;
	}

	/**
	 * Gets the str district store name.
	 * 
	 * @return the str district store name
	 */
	public String getStrDistrictStoreName() {
		return strDistrictStoreName;
	}

	/**
	 * Sets the str district store name.
	 * 
	 * @param strDistrictStoreName
	 *            the new str district store name
	 */
	public void setStrDistrictStoreName(String strDistrictStoreName) {
		this.strDistrictStoreName = strDistrictStoreName;
	}

	/**
	 * Gets the str supplier ws.
	 * 
	 * @return the str supplier ws
	 */
	public WebRowSet getStrSupplierWS() {
		return strSupplierWS;
	}

	/**
	 * Sets the str supplier ws.
	 * 
	 * @param strSupplierWS
	 *            the new str supplier ws
	 */
	public void setStrSupplierWS(WebRowSet strSupplierWS) {
		this.strSupplierWS = strSupplierWS;
	}

}
