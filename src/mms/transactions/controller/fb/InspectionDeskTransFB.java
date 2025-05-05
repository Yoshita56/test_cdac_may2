/**
 * 
 */
package mms.transactions.controller.fb;

import hisglobal.transactionutil.GenericFormBean;

/**
 * Developer : Anshul Jindal 
 * Version : 1.0 Date : 09/Apr/2009
 * 
 */
public class InspectionDeskTransFB extends GenericFormBean {

	private static final long serialVersionUID = 02L;

	private String strErr = "";
	private String strWarning = "";
	private String strNormalMsg = "";

	private String strStoreName = "";
	private String strStoreId = "0";

	private String strRaisingStoreName = "";
	private String strRaisingStoreId = "0";

	private String strIndentNo = "0";
	private String strIndentDate = "";
	private String strIndentType = "";
	private String strItemCategory = "";

	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strRemarks = "";

	private String strItemDtls = "";

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
	 * @return the strNormalMsg
	 */
	public String getStrNormalMsg() {
		return strNormalMsg;
	}

	/**
	 * @param strNormalMsg the strNormalMsg to set
	 */
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
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
	 * @return the strRaisingStoreName
	 */
	public String getStrRaisingStoreName() {
		return strRaisingStoreName;
	}

	/**
	 * @param strRaisingStoreName the strRaisingStoreName to set
	 */
	public void setStrRaisingStoreName(String strRaisingStoreName) {
		this.strRaisingStoreName = strRaisingStoreName;
	}

	/**
	 * @return the strRaisingStoreId
	 */
	public String getStrRaisingStoreId() {
		return strRaisingStoreId;
	}

	/**
	 * @param strRaisingStoreId the strRaisingStoreId to set
	 */
	public void setStrRaisingStoreId(String strRaisingStoreId) {
		this.strRaisingStoreId = strRaisingStoreId;
	}

	/**
	 * @return the strIndentNo
	 */
	public String getStrIndentNo() {
		return strIndentNo;
	}

	/**
	 * @param strIndentNo the strIndentNo to set
	 */
	public void setStrIndentNo(String strIndentNo) {
		this.strIndentNo = strIndentNo;
	}

	/**
	 * @return the strIndentDate
	 */
	public String getStrIndentDate() {
		return strIndentDate;
	}

	/**
	 * @param strIndentDate the strIndentDate to set
	 */
	public void setStrIndentDate(String strIndentDate) {
		this.strIndentDate = strIndentDate;
	}

	/**
	 * @return the strIndentType
	 */
	public String getStrIndentType() {
		return strIndentType;
	}

	/**
	 * @param strIndentType the strIndentType to set
	 */
	public void setStrIndentType(String strIndentType) {
		this.strIndentType = strIndentType;
	}

	/**
	 * @return the strItemCategory
	 */
	public String getStrItemCategory() {
		return strItemCategory;
	}

	/**
	 * @param strItemCategory the strItemCategory to set
	 */
	public void setStrItemCategory(String strItemCategory) {
		this.strItemCategory = strItemCategory;
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
	 * @return the strRemarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}

	/**
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * @return the strItemDtls
	 */
	public String getStrItemDtls() {
		return strItemDtls;
	}

	/**
	 * @param strItemDtls the strItemDtls to set
	 */
	public void setStrItemDtls(String strItemDtls) {
		this.strItemDtls = strItemDtls;
	}

}
