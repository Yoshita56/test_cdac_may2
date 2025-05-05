/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         StockOnHandRptFB.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.controller.fb;

import org.apache.struts.action.ActionForm;

// TODO: Auto-generated Javadoc
/**
 * The Class StockOnHandRptFB.
 */
public class StockOnHandRptFB_NEW extends ActionForm {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The str hospital code. */
	private String strHospitalCode = "";

	/** The str seat id. */
	private String strSeatId = "";

	/** The str err msg. */
	private String strErrMsg = "";

	/** The str normal msg. */
	private String strNormalMsg = "";

	/** The str warning msg. */
	private String strWarningMsg = "";

	/** The str report id. */
	private String strReportId = "";

	/** The str user remarks. */
	private String strUserRemarks = "";

	/** The str report format. */
	private String strReportFormat = "";

	/** The str is footer. */
	private String strIsFooter = "";

	/** The str item cat no. */
	private String strItemCatNo = "";

	/** The str batch no. */
	private String strBatchNo = "0";

	/** The str store id. */
	private String strStoreId = "";

	/** The str store name. */
	private String strStoreName = "";

	/** The str current stock. */
	private String strCurrentStock = "1";

	/** The str current date. */
	private String strCurrentDate = "";

	/** The str date. */
	private String strDate = "";

	/** The str current stock1. */
	private String strCurrentStock1;

	/** The str status id. */
	private String strStatusId;

	/** The str drug name. */
	private String strDrugName = "";

	/** The str group id. */
	private String strGroupId = "";

	/** The str store values. */
	private String strStoreValues = "";

	/** The str frm expiry days. */
	private String strFrmExpiryDays;

	/** The str item catg combo. */
	private String strItemCatgCombo;

	/** The str group combo. */
	private String strGroupCombo;

	/** The str drug combo. */
	private String strDrugCombo;
	
	private String strProgCombo;

	/** The str district store id. */
	private String strDistrictStoreId;

	/** The str district store values. */
	private String strDistrictStoreValues;

	/** The str circle name. */
	private String strCircleName;

	/** The str district name. */
	private String strDistrictName;

	/** The str store type name. */
	private String strStoreTypeName;

	/** The str sub store name. */
	private String strSubStoreName;

	/** The str circle id. */
	private String strCircleId;

	private String strItemCatId;
	/** The str circle combo. */
	private String strCircleCombo;

	/** The str user level. */
	private String strUserLevel;

	/** The str district id. */
	private String strDistrictId;

	/** The str district combo. */
	private String strDistrictCombo;

	/** The str store type id. */
	private String strStoreTypeId;

	/** The str store type combo. */
	private String strStoreTypeCombo;

	/** The str is ddw flag. */
	private String strIsDdwFlag = "1";

	/** The str left item ids. */
	private String[] strLeftItemIds = null;

	/** The str left item list. */
	private String strLeftItemList = "";

	/** The str right item ids. */
	private String[] strRightItemIds = null;

	/** The str right item list. */
	private String strRightItemList = "";

	/** The str item type. */
	private String strItemType;

	/** The str item type values. */
	private String strItemTypeValues;

	/** The str item brand id. */
	private String strItemBrandId = "0";

	/** The str is group wise. */
	private String strIsGroupWise;

	/** The str is item wise. */
	private String strIsItemWise;

	/** The str prog id. */
	private String strProgId;
	
	private String strCatCode;

	private String strUserName;

	private String strViewItemDtls;

	private String strTableWidth;
	

	private String strGroupName;
	private String strDrugTypeName;
	
	/* ==R47J== */
	private String strUserValue = "";
	
	//private String url = "";

	public String getStrUserValue() {
		return strUserValue;
	}

	public void setStrUserValue(String strUserValue) {
		this.strUserValue = strUserValue;
	}

	public String getStrDrugTypeName() {
		return strDrugTypeName;
	}

	public void setStrDrugTypeName(String strDrugTypeName) {
		this.strDrugTypeName = strDrugTypeName;
	}

	public String getStrGroupName() {
		return strGroupName;
	}

	public void setStrGroupName(String strGroupName) {
		this.strGroupName = strGroupName;
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

	public String getStrViewItemDtls() {
		return strViewItemDtls;
	}

	public void setStrViewItemDtls(String strViewItemDtls) {
		this.strViewItemDtls = strViewItemDtls;
	}

	public String getStrTableWidth() {
		return strTableWidth;
	}

	public void setStrTableWidth(String strTableWidth) {
		this.strTableWidth = strTableWidth;
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
	 * Gets the str item type values.
	 * 
	 * @return the str item type values
	 */
	public String getStrItemTypeValues() {
		return strItemTypeValues;
	}

	/**
	 * Sets the str item type values.
	 * 
	 * @param strItemTypeValues
	 *            the new str item type values
	 */
	public void setStrItemTypeValues(String strItemTypeValues) {
		this.strItemTypeValues = strItemTypeValues;
	}

	/**
	 * Gets the str left item ids.
	 * 
	 * @return the str left item ids
	 */
	public String[] getStrLeftItemIds() {
		return strLeftItemIds;
	}

	/**
	 * Sets the str left item ids.
	 * 
	 * @param strLeftItemIds
	 *            the new str left item ids
	 */
	public void setStrLeftItemIds(String[] strLeftItemIds) {
		this.strLeftItemIds = strLeftItemIds;
	}

	/**
	 * Gets the str left item list.
	 * 
	 * @return the str left item list
	 */
	public String getStrLeftItemList() {
		return strLeftItemList;
	}

	/**
	 * Sets the str left item list.
	 * 
	 * @param strLeftItemList
	 *            the new str left item list
	 */
	public void setStrLeftItemList(String strLeftItemList) {
		this.strLeftItemList = strLeftItemList;
	}

	/**
	 * Gets the str right item ids.
	 * 
	 * @return the str right item ids
	 */
	public String[] getStrRightItemIds() {
		return strRightItemIds;
	}

	/**
	 * Sets the str right item ids.
	 * 
	 * @param strRightItemIds
	 *            the new str right item ids
	 */
	public void setStrRightItemIds(String[] strRightItemIds) {
		this.strRightItemIds = strRightItemIds;
	}

	/**
	 * Gets the str right item list.
	 * 
	 * @return the str right item list
	 */
	public String getStrRightItemList() {
		return strRightItemList;
	}

	/**
	 * Sets the str right item list.
	 * 
	 * @param strRightItemList
	 *            the new str right item list
	 */
	public void setStrRightItemList(String strRightItemList) {
		this.strRightItemList = strRightItemList;
	}

	/**
	 * Gets the str item catg combo.
	 * 
	 * @return the str item catg combo
	 */
	public String getStrItemCatgCombo() {
		return strItemCatgCombo;
	}

	/**
	 * Sets the str item catg combo.
	 * 
	 * @param strItemCatgCombo
	 *            the new str item catg combo
	 */
	public void setStrItemCatgCombo(String strItemCatgCombo) {
		this.strItemCatgCombo = strItemCatgCombo;
	}

	/**
	 * Gets the str frm expiry days.
	 * 
	 * @return the str frm expiry days
	 */
	public String getStrFrmExpiryDays() {
		return strFrmExpiryDays;
	}

	/**
	 * Sets the str frm expiry days.
	 * 
	 * @param strFrmExpiryDays
	 *            the new str frm expiry days
	 */
	public void setStrFrmExpiryDays(String strFrmExpiryDays) {
		this.strFrmExpiryDays = strFrmExpiryDays;
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
	 * Gets the str err msg.
	 * 
	 * @return the strErrMsg
	 */
	public String getStrErrMsg() {
		return strErrMsg;
	}

	/**
	 * Sets the str err msg.
	 * 
	 * @param strErrMsg
	 *            the strErrMsg to set
	 */
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}

	/**
	 * Gets the str normal msg.
	 * 
	 * @return the strNormalMsg
	 */
	public String getStrNormalMsg() {
		return strNormalMsg;
	}

	/**
	 * Sets the str normal msg.
	 * 
	 * @param strNormalMsg
	 *            the strNormalMsg to set
	 */
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}

	/**
	 * Gets the str warning msg.
	 * 
	 * @return the strWarningMsg
	 */
	public String getStrWarningMsg() {
		return strWarningMsg;
	}

	/**
	 * Sets the str warning msg.
	 * 
	 * @param strWarningMsg
	 *            the strWarningMsg to set
	 */
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}

	/**
	 * Gets the str report id.
	 * 
	 * @return the strReportId
	 */
	public String getStrReportId() {
		return strReportId;
	}

	/**
	 * Sets the str report id.
	 * 
	 * @param strReportId
	 *            the strReportId to set
	 */
	public void setStrReportId(String strReportId) {
		this.strReportId = strReportId;
	}

	/**
	 * Gets the str user remarks.
	 * 
	 * @return the strUserRemarks
	 */
	public String getStrUserRemarks() {
		return strUserRemarks;
	}

	/**
	 * Sets the str user remarks.
	 * 
	 * @param strUserRemarks
	 *            the strUserRemarks to set
	 */
	public void setStrUserRemarks(String strUserRemarks) {
		this.strUserRemarks = strUserRemarks;
	}

	/**
	 * Gets the str report format.
	 * 
	 * @return the strReportFormat
	 */
	public String getStrReportFormat() {
		return strReportFormat;
	}

	/**
	 * Sets the str report format.
	 * 
	 * @param strReportFormat
	 *            the strReportFormat to set
	 */
	public void setStrReportFormat(String strReportFormat) {
		this.strReportFormat = strReportFormat;
	}

	/**
	 * Gets the str is footer.
	 * 
	 * @return the strIsFooter
	 */
	public String getStrIsFooter() {
		return strIsFooter;
	}

	/**
	 * Sets the str is footer.
	 * 
	 * @param strIsFooter
	 *            the strIsFooter to set
	 */
	public void setStrIsFooter(String strIsFooter) {
		this.strIsFooter = strIsFooter;
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
	 * Gets the str store name.
	 * 
	 * @return the strStoreName
	 */
	public String getStrStoreName() {
		return strStoreName;
	}

	/**
	 * Sets the str store name.
	 * 
	 * @param strStoreName
	 *            the strStoreName to set
	 */
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}

	/**
	 * Gets the str store values.
	 * 
	 * @return the strStoreValues
	 */
	public String getStrStoreValues() {
		return strStoreValues;
	}

	/**
	 * Sets the str store values.
	 * 
	 * @param strStoreValues
	 *            the strStoreValues to set
	 */
	public void setStrStoreValues(String strStoreValues) {
		this.strStoreValues = strStoreValues;
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
	 * Gets the str current stock.
	 * 
	 * @return the str current stock
	 */
	public String getStrCurrentStock() {
		return strCurrentStock;
	}

	/**
	 * Sets the str current stock.
	 * 
	 * @param strCurrentStock
	 *            the new str current stock
	 */
	public void setStrCurrentStock(String strCurrentStock) {
		this.strCurrentStock = strCurrentStock;
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
	 * Gets the str date.
	 * 
	 * @return the str date
	 */
	public String getStrDate() {
		return strDate;
	}

	/**
	 * Sets the str date.
	 * 
	 * @param strDate
	 *            the new str date
	 */
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}

	/**
	 * Gets the str group id.
	 * 
	 * @return the strGroupId
	 */
	public String getStrGroupId() {
		return strGroupId;
	}

	/**
	 * Sets the str group id.
	 * 
	 * @param strGroupId
	 *            the strGroupId to set
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * Gets the str district store values.
	 * 
	 * @return the str district store values
	 */
	public String getStrDistrictStoreValues() {
		return strDistrictStoreValues;
	}

	/**
	 * Sets the str district store values.
	 * 
	 * @param strDistrictStoreValues
	 *            the new str district store values
	 */
	public void setStrDistrictStoreValues(String strDistrictStoreValues) {
		this.strDistrictStoreValues = strDistrictStoreValues;
	}

	/**
	 * Gets the str current stock1.
	 * 
	 * @return the str current stock1
	 */
	public String getStrCurrentStock1() {
		return strCurrentStock1;
	}

	/**
	 * Sets the str current stock1.
	 * 
	 * @param strCurrentStock1
	 *            the new str current stock1
	 */
	public void setStrCurrentStock1(String strCurrentStock1) {
		this.strCurrentStock1 = strCurrentStock1;
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
	 * Gets the str group combo.
	 * 
	 * @return the str group combo
	 */
	public String getStrGroupCombo() {
		return strGroupCombo;
	}

	/**
	 * Sets the str group combo.
	 * 
	 * @param strGroupCombo
	 *            the new str group combo
	 */
	public void setStrGroupCombo(String strGroupCombo) {
		this.strGroupCombo = strGroupCombo;
	}

	/**
	 * Gets the str drug combo.
	 * 
	 * @return the str drug combo
	 */
	public String getStrDrugCombo() {
		return strDrugCombo;
	}

	/**
	 * Sets the str drug combo.
	 * 
	 * @param strDrugCombo
	 *            the new str drug combo
	 */
	public void setStrDrugCombo(String strDrugCombo) {
		this.strDrugCombo = strDrugCombo;
	}

	/**
	 * Gets the str circle combo.
	 * 
	 * @return the str circle combo
	 */
	public String getStrCircleCombo() {
		return strCircleCombo;
	}

	/**
	 * Sets the str circle combo.
	 * 
	 * @param strCircleCombo
	 *            the new str circle combo
	 */
	public void setStrCircleCombo(String strCircleCombo) {
		this.strCircleCombo = strCircleCombo;
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
	 * Gets the str district combo.
	 * 
	 * @return the str district combo
	 */
	public String getStrDistrictCombo() {
		return strDistrictCombo;
	}

	/**
	 * Sets the str district combo.
	 * 
	 * @param strDistrictCombo
	 *            the new str district combo
	 */
	public void setStrDistrictCombo(String strDistrictCombo) {
		this.strDistrictCombo = strDistrictCombo;
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
	 * Gets the str store type combo.
	 * 
	 * @return the str store type combo
	 */
	public String getStrStoreTypeCombo() {
		return strStoreTypeCombo;
	}

	/**
	 * Sets the str store type combo.
	 * 
	 * @param strStoreTypeCombo
	 *            the new str store type combo
	 */
	public void setStrStoreTypeCombo(String strStoreTypeCombo) {
		this.strStoreTypeCombo = strStoreTypeCombo;
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
	 * Gets the str store type name.
	 * 
	 * @return the str store type name
	 */
	public String getStrStoreTypeName() {
		return strStoreTypeName;
	}

	/**
	 * Sets the str store type name.
	 * 
	 * @param strStoreTypeName
	 *            the new str store type name
	 */
	public void setStrStoreTypeName(String strStoreTypeName) {
		this.strStoreTypeName = strStoreTypeName;
	}

	/**
	 * Gets the str sub store name.
	 * 
	 * @return the str sub store name
	 */
	public String getStrSubStoreName() {
		return strSubStoreName;
	}

	/**
	 * Sets the str sub store name.
	 * 
	 * @param strSubStoreName
	 *            the new str sub store name
	 */
	public void setStrSubStoreName(String strSubStoreName) {
		this.strSubStoreName = strSubStoreName;
	}

	/**
	 * Gets the str is ddw flag.
	 * 
	 * @return the str is ddw flag
	 */
	public String getStrIsDdwFlag() {
		return strIsDdwFlag;
	}

	/**
	 * Sets the str is ddw flag.
	 * 
	 * @param strIsDdwFlag
	 *            the new str is ddw flag
	 */
	public void setStrIsDdwFlag(String strIsDdwFlag) {
		this.strIsDdwFlag = strIsDdwFlag;
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
	 * Gets the str prog id.
	 * 
	 * @return the str prog id
	 */
	public String getStrProgId() {
		return strProgId;
	}

	/**
	 * Sets the str prog id.
	 * 
	 * @param strProgId
	 *            the new str prog id
	 */
	public void setStrProgId(String strProgId) {
		this.strProgId = strProgId;
	}

	public String getStrProgCombo() {
		return strProgCombo;
	}

	public void setStrProgCombo(String strProgCombo) {
		this.strProgCombo = strProgCombo;
	}

	public String getStrItemCatId() {
		return strItemCatId;
	}

	public void setStrItemCatId(String strItemCatId) {
		this.strItemCatId = strItemCatId;
	}

	
}
