/**
 * 
 */
package mms.reports.controller.fb;

import org.apache.struts.action.ActionForm;

// TODO: Auto-generated Javadoc
/**
 * The Class ListItemWiseSupplierRptFB.
 * 
 * @author user
 */
public class ListItemWiseSupplierRptFB_NEW extends ActionForm {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The str hospital code. */
	private String strHospitalCode = "";

	/** The str seat id. */
	private String strSeatId = "";

	/** The str is footer. */
	private String strIsFooter = "1";

	/** The str user remarks. */
	private String strUserRemarks = "";

	/** The str report format. */
	private String strReportFormat = "0";

	/** The str report id. */
	private String strReportId = "";

	/** The str err msg. */
	private String strErrMsg = "";

	/** The str warning msg. */
	private String strWarningMsg = "";

	/** The str normal msg. */
	private String strNormalMsg = "";

	/** The str item category no. */
	private String strItemCategoryNo = "";

	/** The str group id. */
	private String strGroupId = "";

	/** The str sub group id. */
	private String strSubGroupId = "";

	/** The str item id. */
	private String strItemId = "";

	/** The str item category combo. */
	private String strItemCategoryCombo = null;

	/** The str group combo. */
	private String strGroupCombo = null;

	/** The str sub group combo. */
	private String strSubGroupCombo = null;

	/** The str item combo. */
	private String strItemCombo = null;

	/** The str supplier id. */
	private String strSupplierId;

	/** The str manufacture combo. */
	private String strManufactureCombo;

	/** The str frm expiry days. */
	private String strFrmExpiryDays;

	/** The str active or near expiry. */
	private String strActiveOrNearExpiry;

	/** The str code combo. */
	private String strCodeCombo;

	/** The str rate contract type id. */
	private String strRateContractTypeId = "";

	/** The str rate contract type combo. */
	private String strRateContractTypeCombo = "";
	
	private String strFullName="";

	/**
	 * Gets the str code combo.
	 * 
	 * @return the str code combo
	 */
	public String getStrCodeCombo() {
		return strCodeCombo;
	}

	/**
	 * Sets the str code combo.
	 * 
	 * @param strCodeCombo
	 *            the new str code combo
	 */
	public void setStrCodeCombo(String strCodeCombo) {
		this.strCodeCombo = strCodeCombo;
	}

	/**
	 * Gets the str active or near expiry.
	 * 
	 * @return the str active or near expiry
	 */
	public String getStrActiveOrNearExpiry() {
		return strActiveOrNearExpiry;
	}

	/**
	 * Sets the str active or near expiry.
	 * 
	 * @param strActiveOrNearExpiry
	 *            the new str active or near expiry
	 */
	public void setStrActiveOrNearExpiry(String strActiveOrNearExpiry) {
		this.strActiveOrNearExpiry = strActiveOrNearExpiry;
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
	 * Gets the str manufacture combo.
	 * 
	 * @return the str manufacture combo
	 */
	public String getStrManufactureCombo() {
		return strManufactureCombo;
	}

	/**
	 * Sets the str manufacture combo.
	 * 
	 * @param strManufactureCombo
	 *            the new str manufacture combo
	 */
	public void setStrManufactureCombo(String strManufactureCombo) {
		this.strManufactureCombo = strManufactureCombo;
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
	 * Gets the str item category no.
	 * 
	 * @return the strItemCategoryNo
	 */
	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}

	/**
	 * Sets the str item category no.
	 * 
	 * @param strItemCategoryNo
	 *            the strItemCategoryNo to set
	 */
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
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
	 * Gets the str sub group id.
	 * 
	 * @return the strSubGroupId
	 */
	public String getStrSubGroupId() {
		return strSubGroupId;
	}

	/**
	 * Sets the str sub group id.
	 * 
	 * @param strSubGroupId
	 *            the strSubGroupId to set
	 */
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}

	/**
	 * Gets the str item id.
	 * 
	 * @return the strItemId
	 */
	public String getStrItemId() {
		return strItemId;
	}

	/**
	 * Sets the str item id.
	 * 
	 * @param strItemId
	 *            the strItemId to set
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	/**
	 * Gets the str item category combo.
	 * 
	 * @return the strItemCategoryCombo
	 */
	public String getStrItemCategoryCombo() {
		return strItemCategoryCombo;
	}

	/**
	 * Sets the str item category combo.
	 * 
	 * @param strItemCategoryCombo
	 *            the strItemCategoryCombo to set
	 */
	public void setStrItemCategoryCombo(String strItemCategoryCombo) {
		this.strItemCategoryCombo = strItemCategoryCombo;
	}

	/**
	 * Gets the str group combo.
	 * 
	 * @return the strGroupCombo
	 */
	public String getStrGroupCombo() {
		return strGroupCombo;
	}

	/**
	 * Sets the str group combo.
	 * 
	 * @param strGroupCombo
	 *            the strGroupCombo to set
	 */
	public void setStrGroupCombo(String strGroupCombo) {
		this.strGroupCombo = strGroupCombo;
	}

	/**
	 * Gets the str sub group combo.
	 * 
	 * @return the strSubGroupCombo
	 */
	public String getStrSubGroupCombo() {
		return strSubGroupCombo;
	}

	/**
	 * Sets the str sub group combo.
	 * 
	 * @param strSubGroupCombo
	 *            the strSubGroupCombo to set
	 */
	public void setStrSubGroupCombo(String strSubGroupCombo) {
		this.strSubGroupCombo = strSubGroupCombo;
	}

	/**
	 * Gets the str item combo.
	 * 
	 * @return the strItemCombo
	 */
	public String getStrItemCombo() {
		return strItemCombo;
	}

	/**
	 * Sets the str item combo.
	 * 
	 * @param strItemCombo
	 *            the strItemCombo to set
	 */
	public void setStrItemCombo(String strItemCombo) {
		this.strItemCombo = strItemCombo;
	}

	/**
	 * Gets the str rate contract type id.
	 * 
	 * @return the str rate contract type id
	 */
	public String getStrRateContractTypeId() {
		return strRateContractTypeId;
	}

	/**
	 * Sets the str rate contract type id.
	 * 
	 * @param strRateContractTypeId
	 *            the new str rate contract type id
	 */
	public void setStrRateContractTypeId(String strRateContractTypeId) {
		this.strRateContractTypeId = strRateContractTypeId;
	}

	/**
	 * Gets the str rate contract type combo.
	 * 
	 * @return the str rate contract type combo
	 */
	public String getStrRateContractTypeCombo() {
		return strRateContractTypeCombo;
	}

	/**
	 * Sets the str rate contract type combo.
	 * 
	 * @param strRateContractTypeCombo
	 *            the new str rate contract type combo
	 */
	public void setStrRateContractTypeCombo(String strRateContractTypeCombo) {
		this.strRateContractTypeCombo = strRateContractTypeCombo;
	}

	public String getStrFullName() {
		return strFullName;
	}

	public void setStrFullName(String strFullName) {
		this.strFullName = strFullName;
	}

	
}
