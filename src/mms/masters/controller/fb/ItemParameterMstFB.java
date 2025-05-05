package mms.masters.controller.fb;

import hisglobal.masterutil.GenericFormBean;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemParameterMstFB.
 */
public class ItemParameterMstFB extends GenericFormBean {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The str item category name. */
	private String strItemCategoryName = "";

	/** The str item param id. */
	private String strItemParamId = "0";
	
	/** The str item param name. */
	private String strItemParamName = "";
	
	/** The str categroy no. */
	private String strCategroyNo = "";
	
	/** The str categroy name. */
	private String strCategroyName = "";
	
	/** The str param type. */
	private String strParamType = "";
	
	/** The str param length. */
	private String strParamLength = "";
	
	/** The str parent param id. */
	private String strParentParamId = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str entry date. */
	private String strEntryDate = "";
	
	/** The str last modified date. */
	private String strLastModifiedDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str last modified seat id. */
	private String strLastModifiedSeatId = "";
	
	/** The str is valid. */
	private String strIsValid = "1";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str ct date. */
	private String strCtDate = null;
	
	/** The str err. */
	private String strErr = "";
	
	/** The str msg. */
	private String strMsg = "";
	
	/** The str warning. */
	private String strWarning = "";

	/** The is visible. */
	private String isVisible = "";
	
	/** The str is child. */
	private String strIsChild = "0";
	
	/** The strparent cmb ws. */
	private WebRowSet strparentCmbWs = null;
	
	/** The strparent name combo. */
	private String strparentNameCombo = "";

	/** The str error msg. */
	private String strErrorMsg = "";
	
	/** The str chk. */
	private String strChk = "";
	
	/** The str error. */
	private String strError = "";

	/** The get str msg. */
	private String getStrMsg = "";
	
	private String strSlNo;	

	public String getStrSlNo() {
		return strSlNo;
	}

	public void setStrSlNo(String strSlNo) {
		this.strSlNo = strSlNo;
	}

	/**
	 * Gets the str item category name.
	 * 
	 * @return the str item category name
	 */
	public String getStrItemCategoryName() {
		return strItemCategoryName;
	}

	/**
	 * Sets the str item category name.
	 * 
	 * @param strItemCategoryName the new str item category name
	 */
	public void setStrItemCategoryName(String strItemCategoryName) {
		this.strItemCategoryName = strItemCategoryName;
	}

	/**
	 * Gets the str item param id.
	 * 
	 * @return the strItemParamId
	 */
	public String getStrItemParamId() {
		return strItemParamId;
	}

	/**
	 * Sets the str item param id.
	 * 
	 * @param strItemParamId the strItemParamId to set
	 */
	public void setStrItemParamId(String strItemParamId) {
		this.strItemParamId = strItemParamId;
	}

	/**
	 * Gets the str item param name.
	 * 
	 * @return the strItemParamName
	 */
	public String getStrItemParamName() {
		return strItemParamName;
	}

	/**
	 * Sets the str item param name.
	 * 
	 * @param strItemParamName the strItemParamName to set
	 */
	public void setStrItemParamName(String strItemParamName) {
		this.strItemParamName = strItemParamName;
	}

	/**
	 * Gets the str categroy no.
	 * 
	 * @return the strCategroyNo
	 */
	public String getStrCategroyNo() {
		return strCategroyNo;
	}

	/**
	 * Sets the str categroy no.
	 * 
	 * @param strCategroyNo the strCategroyNo to set
	 */
	public void setStrCategroyNo(String strCategroyNo) {
		this.strCategroyNo = strCategroyNo;
	}

	/**
	 * Gets the str param type.
	 * 
	 * @return the strParamType
	 */
	public String getStrParamType() {
		return strParamType;
	}

	/**
	 * Sets the str param type.
	 * 
	 * @param strParamType the strParamType to set
	 */
	public void setStrParamType(String strParamType) {
		this.strParamType = strParamType;
	}

	/**
	 * Gets the str param length.
	 * 
	 * @return the strParamLength
	 */
	public String getStrParamLength() {
		return strParamLength;
	}

	/**
	 * Sets the str param length.
	 * 
	 * @param strParamLength the strParamLength to set
	 */
	public void setStrParamLength(String strParamLength) {
		this.strParamLength = strParamLength;
	}

	/**
	 * Gets the str parent param id.
	 * 
	 * @return the strParentParamId
	 */
	public String getStrParentParamId() {
		return strParentParamId;
	}

	/**
	 * Sets the str parent param id.
	 * 
	 * @param strParentParamId the strParentParamId to set
	 */
	public void setStrParentParamId(String strParentParamId) {
		this.strParentParamId = strParentParamId;
	}

	/**
	 * Gets the str effective from.
	 * 
	 * @return the strEffectiveFrom
	 */
	public String getStrEffectiveFrom() {
		return strEffectiveFrom;
	}

	/**
	 * Sets the str effective from.
	 * 
	 * @param strEffectiveFrom the strEffectiveFrom to set
	 */
	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
	}

	/**
	 * Gets the str remarks.
	 * 
	 * @return the strRemarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * Gets the str entry date.
	 * 
	 * @return the strEntryDate
	 */
	public String getStrEntryDate() {
		return strEntryDate;
	}

	/**
	 * Sets the str entry date.
	 * 
	 * @param strEntryDate the strEntryDate to set
	 */
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}

	/**
	 * Gets the str last modified date.
	 * 
	 * @return the strLastModifiedDate
	 */
	public String getStrLastModifiedDate() {
		return strLastModifiedDate;
	}

	/**
	 * Sets the str last modified date.
	 * 
	 * @param strLastModifiedDate the strLastModifiedDate to set
	 */
	public void setStrLastModifiedDate(String strLastModifiedDate) {
		this.strLastModifiedDate = strLastModifiedDate;
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
	 * @param strSeatId the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * Gets the str last modified seat id.
	 * 
	 * @return the strLastModifiedSeatId
	 */
	public String getStrLastModifiedSeatId() {
		return strLastModifiedSeatId;
	}

	/**
	 * Sets the str last modified seat id.
	 * 
	 * @param strLastModifiedSeatId the strLastModifiedSeatId to set
	 */
	public void setStrLastModifiedSeatId(String strLastModifiedSeatId) {
		this.strLastModifiedSeatId = strLastModifiedSeatId;
	}

	/**
	 * Gets the str is valid.
	 * 
	 * @return the strIsValid
	 */
	public String getStrIsValid() {
		return strIsValid;
	}

	/**
	 * Sets the str is valid.
	 * 
	 * @param strIsValid the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
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
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Gets the str ct date.
	 * 
	 * @return the strCtDate
	 */
	public String getStrCtDate() {
		return strCtDate;
	}

	/**
	 * Sets the str ct date.
	 * 
	 * @param strCtDate the strCtDate to set
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}

	/**
	 * Gets the str err.
	 * 
	 * @return the strErr
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * Sets the str err.
	 * 
	 * @param strErr the strErr to set
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

	/**
	 * Gets the str msg.
	 * 
	 * @return the strMsg
	 */
	public String getStrMsg() {
		return strMsg;
	}

	/**
	 * Sets the str msg.
	 * 
	 * @param strMsg the strMsg to set
	 */
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}

	/**
	 * Gets the str warning.
	 * 
	 * @return the strWarning
	 */
	public String getStrWarning() {
		return strWarning;
	}

	/**
	 * Sets the str warning.
	 * 
	 * @param strWarning the strWarning to set
	 */
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}

	/**
	 * Gets the str error msg.
	 * 
	 * @return the strErrorMsg
	 */
	public String getStrErrorMsg() {
		return strErrorMsg;
	}

	/**
	 * Sets the str error msg.
	 * 
	 * @param strErrorMsg the strErrorMsg to set
	 */
	public void setStrErrorMsg(String strErrorMsg) {
		this.strErrorMsg = strErrorMsg;
	}

	/**
	 * Gets the str chk.
	 * 
	 * @return the strChk
	 */
	public String getStrChk() {
		return strChk;
	}

	/**
	 * Sets the str chk.
	 * 
	 * @param strChk the strChk to set
	 */
	public void setStrChk(String strChk) {
		this.strChk = strChk;
	}

	/**
	 * Gets the str error.
	 * 
	 * @return the strError
	 */
	public String getStrError() {
		return strError;
	}

	/**
	 * Sets the str error.
	 * 
	 * @param strError the strError to set
	 */
	public void setStrError(String strError) {
		this.strError = strError;
	}

	/**
	 * Gets the get str msg.
	 * 
	 * @return the getStrMsg
	 */
	public String getGetStrMsg() {
		return getStrMsg;
	}

	/**
	 * Sets the get str msg.
	 * 
	 * @param getStrMsg the getStrMsg to set
	 */
	public void setGetStrMsg(String getStrMsg) {
		this.getStrMsg = getStrMsg;
	}

	/**
	 * Gets the is visible.
	 * 
	 * @return the isVisible
	 */
	public String getIsVisible() {
		return isVisible;
	}

	/**
	 * Sets the is visible.
	 * 
	 * @param isVisible the isVisible to set
	 */
	public void setIsVisible(String isVisible) {
		this.isVisible = isVisible;
	}

	/**
	 * Gets the strparent cmb ws.
	 * 
	 * @return the isParent
	 */

	/**
	 * @return the strparentCmbWs
	 */
	public WebRowSet getStrparentCmbWs() {
		return strparentCmbWs;
	}

	/**
	 * Sets the strparent cmb ws.
	 * 
	 * @param strparentCmbWs the strparentCmbWs to set
	 */
	public void setStrparentCmbWs(WebRowSet strparentCmbWs) {
		this.strparentCmbWs = strparentCmbWs;
	}

	/**
	 * Gets the strparent name combo.
	 * 
	 * @return the strparentNameCombo
	 */
	public String getStrparentNameCombo() {
		return strparentNameCombo;
	}

	/**
	 * Sets the strparent name combo.
	 * 
	 * @param strparentNameCombo the strparentNameCombo to set
	 */
	public void setStrparentNameCombo(String strparentNameCombo) {
		this.strparentNameCombo = strparentNameCombo;
	}

	/**
	 * Gets the str is child.
	 * 
	 * @return the strIsChild
	 */
	public String getStrIsChild() {
		return strIsChild;
	}

	/**
	 * Sets the str is child.
	 * 
	 * @param strIsChild the strIsChild to set
	 */
	public void setStrIsChild(String strIsChild) {
		this.strIsChild = strIsChild;
	}

	/**
	 * Gets the str categroy name.
	 * 
	 * @return the strCategroyName
	 */
	public String getStrCategroyName() {
		return strCategroyName;
	}

	/**
	 * Sets the str categroy name.
	 * 
	 * @param strCategroyName the strCategroyName to set
	 */
	public void setStrCategroyName(String strCategroyName) {
		this.strCategroyName = strCategroyName;
	}

}
