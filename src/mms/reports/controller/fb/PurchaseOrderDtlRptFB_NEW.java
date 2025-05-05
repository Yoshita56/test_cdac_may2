/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         PurchaseOrderDtlRptFB.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.controller.fb;

import org.apache.struts.action.ActionForm;

// TODO: Auto-generated Javadoc
/**
 * The Class PurchaseOrderDtlRptFB.
 */
public class PurchaseOrderDtlRptFB_NEW extends ActionForm {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The str err msg. */
	private String strErrMsg = "";

	/** The str normal msg. */
	private String strNormalMsg = "";

	/** The str warning msg. */
	private String strWarningMsg = "";

	/** The str current date. */
	private String strCurrentDate = "";

	/** The str hospital code. */
	private String strHospitalCode = "";

	/** The str seat id. */
	private String strSeatId = "";

	/** The str store id. */
	private String strStoreId = "";

	/** The str store name. */
	private String strStoreName = "";

	/** The str item cat no. */
	private String strItemCatNo = "";

	/** The str po type id. */
	private String strPOTypeId = "";

	/** The str supplier id. */
	private String strSupplierId = "";

	/** The str order status. */
	private String strOrderStatus = "";

	/** The str report format. */
	private String strReportFormat = "";

	/** The str is footer. */
	private String strIsFooter = "";

	/** The str store values. */
	private String strStoreValues = "";

	/** The str po no. */
	private String strPONo = "";

	/** The str case. */
	private String strCase = "1";

	/** The str from date. */
	private String strFromDate = "";

	/** The str to date. */
	private String strToDate = "";

	/** The str report id. */
	private String strReportId = "";

	/** The str user remarks. */
	private String strUserRemarks = "";

	/** The str whether item shown. */
	private String strWhetherItemShown;

	/** The str po status. */
	private String strPoStatus;

	/** The str supplier cmb. */
	private String strSupplierCmb;

	/** The str po type. */
	private String strPoType;

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
	
	private String strFinYearId = "";
	
	private String strFinYearCombo = "";
	
	private String strProgNameId="";
	
	private String strProgName="";
	
	private String strProgId="";
	
	private String strSuppPOStatusName="";
	
	private String strSuppPOStatus="";
	
	private String strCatVal="";
	
	private String strClassificationName="";
	
	private String strItemCatCMB="";

	public String getStrItemCatCMB() {
		return strItemCatCMB;
	}

	public void setStrItemCatCMB(String strItemCatCMB) {
		this.strItemCatCMB = strItemCatCMB;
	}

	/**
	 * Gets the str supplier cmb.
	 * 
	 * @return the str supplier cmb
	 */
	public String getStrSupplierCmb() {
		return strSupplierCmb;
	}

	/**
	 * Sets the str supplier cmb.
	 * 
	 * @param strSupplierCmb
	 *            the new str supplier cmb
	 */
	public void setStrSupplierCmb(String strSupplierCmb) {
		this.strSupplierCmb = strSupplierCmb;
	}

	/**
	 * Gets the str po status.
	 * 
	 * @return the str po status
	 */
	public String getStrPoStatus() {
		return strPoStatus;
	}

	/**
	 * Sets the str po status.
	 * 
	 * @param strPoStatus
	 *            the new str po status
	 */
	public void setStrPoStatus(String strPoStatus) {
		this.strPoStatus = strPoStatus;
	}

	/**
	 * Gets the str whether item shown.
	 * 
	 * @return the str whether item shown
	 */
	public String getStrWhetherItemShown() {
		return strWhetherItemShown;
	}

	/**
	 * Sets the str whether item shown.
	 * 
	 * @param strWhetherItemShown
	 *            the new str whether item shown
	 */
	public void setStrWhetherItemShown(String strWhetherItemShown) {
		this.strWhetherItemShown = strWhetherItemShown;
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
	 * Gets the str err msg.
	 * 
	 * @return the str err msg
	 */
	public String getStrErrMsg() {
		return strErrMsg;
	}

	/**
	 * Sets the str err msg.
	 * 
	 * @param strErrMsg
	 *            the new str err msg
	 */
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}

	/**
	 * Gets the str normal msg.
	 * 
	 * @return the str normal msg
	 */
	public String getStrNormalMsg() {
		return strNormalMsg;
	}

	/**
	 * Sets the str normal msg.
	 * 
	 * @param strNormalMsg
	 *            the new str normal msg
	 */
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}

	/**
	 * Gets the str warning msg.
	 * 
	 * @return the str warning msg
	 */
	public String getStrWarningMsg() {
		return strWarningMsg;
	}

	/**
	 * Sets the str warning msg.
	 * 
	 * @param strWarningMsg
	 *            the new str warning msg
	 */
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
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
	 * Gets the str hospital code.
	 * 
	 * @return the str hospital code
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	/**
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode
	 *            the new str hospital code
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Gets the str seat id.
	 * 
	 * @return the str seat id
	 */
	public String getStrSeatId() {
		return strSeatId;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strSeatId
	 *            the new str seat id
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
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
	 * Gets the str store id.
	 * 
	 * @return the str store id
	 */
	public String getStrStoreId() {
		return strStoreId;
	}

	/**
	 * Sets the str store id.
	 * 
	 * @param strStoreId
	 *            the new str store id
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
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
	 * Gets the str order status.
	 * 
	 * @return the str order status
	 */
	public String getStrOrderStatus() {
		return strOrderStatus;
	}

	/**
	 * Sets the str order status.
	 * 
	 * @param strOrderStatus
	 *            the new str order status
	 */
	public void setStrOrderStatus(String strOrderStatus) {
		this.strOrderStatus = strOrderStatus;
	}

	/**
	 * Gets the str report format.
	 * 
	 * @return the str report format
	 */
	public String getStrReportFormat() {
		return strReportFormat;
	}

	/**
	 * Sets the str report format.
	 * 
	 * @param strReportFormat
	 *            the new str report format
	 */
	public void setStrReportFormat(String strReportFormat) {
		this.strReportFormat = strReportFormat;
	}

	/**
	 * Gets the str is footer.
	 * 
	 * @return the str is footer
	 */
	public String getStrIsFooter() {
		return strIsFooter;
	}

	/**
	 * Sets the str is footer.
	 * 
	 * @param strIsFooter
	 *            the new str is footer
	 */
	public void setStrIsFooter(String strIsFooter) {
		this.strIsFooter = strIsFooter;
	}

	/**
	 * Gets the str store values.
	 * 
	 * @return the str store values
	 */
	public String getStrStoreValues() {
		return strStoreValues;
	}

	/**
	 * Sets the str store values.
	 * 
	 * @param strStoreValues
	 *            the new str store values
	 */
	public void setStrStoreValues(String strStoreValues) {
		this.strStoreValues = strStoreValues;
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
	 * Gets the str case.
	 * 
	 * @return the str case
	 */
	public String getStrCase() {
		return strCase;
	}

	/**
	 * Sets the str case.
	 * 
	 * @param strCase
	 *            the new str case
	 */
	public void setStrCase(String strCase) {
		this.strCase = strCase;
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
	 * Gets the str po type.
	 * 
	 * @return the str po type
	 */
	public String getStrPoType() {
		return strPoType;
	}

	/**
	 * Sets the str po type.
	 * 
	 * @param strPoType
	 *            the new str po type
	 */
	public void setStrPoType(String strPoType) {
		this.strPoType = strPoType;
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

	public String getStrFinYearId() {
		return strFinYearId;
	}

	public void setStrFinYearId(String strFinYearId) {
		this.strFinYearId = strFinYearId;
	}

	public String getStrFinYearCombo() {
		return strFinYearCombo;
	}

	public void setStrFinYearCombo(String strFinYearCombo) {
		this.strFinYearCombo = strFinYearCombo;
	}

	public String getStrProgNameId() {
		return strProgNameId;
	}

	public void setStrProgNameId(String strProgNameId) {
		this.strProgNameId = strProgNameId;
	}

	public String getStrProgName() {
		return strProgName;
	}

	public void setStrProgName(String strProgName) {
		this.strProgName = strProgName;
	}

	public String getStrProgId() {
		return strProgId;
	}

	public void setStrProgId(String strProgId) {
		this.strProgId = strProgId;
	}

	public String getStrSuppPOStatusName() {
		return strSuppPOStatusName;
	}

	public void setStrSuppPOStatusName(String strSuppPOStatusName) {
		this.strSuppPOStatusName = strSuppPOStatusName;
	}

	public String getStrSuppPOStatus() {
		return strSuppPOStatus;
	}

	public void setStrSuppPOStatus(String strSuppPOStatus) {
		this.strSuppPOStatus = strSuppPOStatus;
	}

	public String getStrCatVal() {
		return strCatVal;
	}

	public void setStrCatVal(String strCatVal) {
		this.strCatVal = strCatVal;
	}

	public String getStrClassificationName() {
		return strClassificationName;
	}

	public void setStrClassificationName(String strClassificationName) {
		this.strClassificationName = strClassificationName;
	}


	
	
}
