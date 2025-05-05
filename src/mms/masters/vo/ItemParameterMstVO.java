package mms.masters.vo;

import javax.sql.rowset.WebRowSet;
import hisglobal.utility.TransferObject;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemParameterMstVO.
 */
public class ItemParameterMstVO implements TransferObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The str item param id. */
	private String strItemParamId = "0";
	
	/** The str item param name. */
	private String strItemParamName = "";
	
	/** The str categroy no. */
	private String strCategroyNo = "";
	
	/** The str param type. */
	private String strParamType = "";
	
	/** The str param length. */
	private String strParamLength = "";
	
	/** The str parent param id. */
	private String strParentParamId = "0";
	
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

	/** The str item category cmb ws. */
	private WebRowSet strItemCategoryCmbWs = null;
	
	/** The str item category name combo. */
	private String strItemCategoryNameCombo = "";
	
	/** The strparent cmb ws. */
	private WebRowSet strparentCmbWs = null;
	
	/** The strparent name combo. */
	private String strparentNameCombo = "";

	/** The b exists status. */
	private boolean bExistsStatus = false;

	/** The str chk. */
	private String strChk = "";
	
	/** The str store type id. */
	private String strStoreTypeId = "";

	/** The str msg string. */
	private String strMsgString = "";
	
	/** The str msg type. */
	private String strMsgType = "";
	
	private String strSlNo;	

	public String getStrSlNo() {
		return strSlNo;
	}

	public void setStrSlNo(String strSlNo) {
		this.strSlNo = strSlNo;
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
	 * Gets the str store type id.
	 * 
	 * @return the strStoreTypeId
	 */
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}

	/**
	 * Sets the str store type id.
	 * 
	 * @param strStoreTypeId the strStoreTypeId to set
	 */
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
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
	 * @param strMsgString the strMsgString to set
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
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
	 * @param strMsgType the strMsgType to set
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	/**
	 * Checks if is b exists status.
	 * 
	 * @return the bExistsStatus
	 */
	public boolean isBExistsStatus() {
		return bExistsStatus;
	}

	/**
	 * Sets the b exists status.
	 * 
	 * @param existsStatus the bExistsStatus to set
	 */
	public void setBExistsStatus(boolean existsStatus) {
		bExistsStatus = existsStatus;
	}

	/**
	 * Gets the str item category cmb ws.
	 * 
	 * @return the strItemCategoryCmbWs
	 */
	public WebRowSet getStrItemCategoryCmbWs() {
		return strItemCategoryCmbWs;
	}

	/**
	 * Sets the str item category cmb ws.
	 * 
	 * @param strItemCategoryCmbWs the strItemCategoryCmbWs to set
	 */
	public void setStrItemCategoryCmbWs(WebRowSet strItemCategoryCmbWs) {
		this.strItemCategoryCmbWs = strItemCategoryCmbWs;
	}

	/**
	 * Gets the str item category name combo.
	 * 
	 * @return the strItemCategoryNameCombo
	 */
	public String getStrItemCategoryNameCombo() {
		return strItemCategoryNameCombo;
	}

	/**
	 * Sets the str item category name combo.
	 * 
	 * @param strItemCategoryNameCombo the strItemCategoryNameCombo to set
	 */
	public void setStrItemCategoryNameCombo(String strItemCategoryNameCombo) {
		this.strItemCategoryNameCombo = strItemCategoryNameCombo;
	}

	/**
	 * Gets the strparent cmb ws.
	 * 
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

}
