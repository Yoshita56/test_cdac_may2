package mms.masters.controller.fb;

import hisglobal.masterutil.GenericFormBean;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreCategoryMstFB.
 */
public class StoreCategoryMstFB extends GenericFormBean {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The str err. */
	private String strErr = "";
	
	/** The str msg. */
	private String strMsg = "";
	
	/** The str warning. */
	private String strWarning = "";

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str store id. */
	private String strStoreId = "";
	
	/** The str store name. */
	private String strStoreName = "";
	
	/** The str store category. */
	private String strStoreCategory = "";
	private String strStoreItemCategory;
	
	/** The str ct date. */
	private String strCtDate = "";
	
	/** The str item cat no. */
	private String strItemCatNo = "";
	
	/** The str store cat sl no. */
	private String strStoreCatSlNo = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str effective to. */
	private String strEffectiveTo = "";
	
	/** The str last mode seat id. */
	private String strLastModeSeatId = "";
	
	/** The str last mode date. */
	private String strLastModeDate = "";
	
	/** The str entry date. */
	private String strEntryDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str is valid. */
	private String strIsValid = "";
	
	/** The str chk1. */
	private String strChk1 = "";

	/** The str left store category list. */
	private String strLeftStoreCategoryList = "";
	
	/** The str right store category list. */
	private String strRightStoreCategoryList = "";
	
	/** The str right store categorys. */
	private String strRightStoreCategorys[] = null;
	private String strItemBounded;

	private String 	strIsNewItemFlag;
	private String strTmpNewItemFlag;
	private String strTmpItemBoundedFlag;
	

	public String getStrTmpItemBoundedFlag() {
		return strTmpItemBoundedFlag;
	}

	public void setStrTmpItemBoundedFlag(String strTmpItemBoundedFlag) {
		this.strTmpItemBoundedFlag = strTmpItemBoundedFlag;
	}

	public String getStrTmpNewItemFlag() {
		return strTmpNewItemFlag;
	}

	public void setStrTmpNewItemFlag(String strTmpNewItemFlag) {
		this.strTmpNewItemFlag = strTmpNewItemFlag;
	}

	public String getStrItemBounded() {
		return strItemBounded;
	}

	public void setStrItemBounded(String strItemBounded) {
		this.strItemBounded = strItemBounded;
	}

	public String getStrIsNewItemFlag() {
		return strIsNewItemFlag;
	}

	public void setStrIsNewItemFlag(String strIsNewItemFlag) {
		this.strIsNewItemFlag = strIsNewItemFlag;
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
	 * @param strStoreId the strStoreId to set
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
	 * @param strStoreName the strStoreName to set
	 */
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}

	/**
	 * Gets the str store category.
	 * 
	 * @return the strStoreCategory
	 */
	public String getStrStoreCategory() {
		return strStoreCategory;
	}

	/**
	 * Sets the str store category.
	 * 
	 * @param strStoreCategory the strStoreCategory to set
	 */
	public void setStrStoreCategory(String strStoreCategory) {
		this.strStoreCategory = strStoreCategory;
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
	 * Gets the str item cat no.
	 * 
	 * @return the strItemCatNo
	 */
	public String getStrItemCatNo() {
		return strItemCatNo;
	}

	/**
	 * Sets the str item cat no.
	 * 
	 * @param strItemCatNo the strItemCatNo to set
	 */
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}

	/**
	 * Gets the str store cat sl no.
	 * 
	 * @return the strStoreCatSlNo
	 */
	public String getStrStoreCatSlNo() {
		return strStoreCatSlNo;
	}

	/**
	 * Sets the str store cat sl no.
	 * 
	 * @param strStoreCatSlNo the strStoreCatSlNo to set
	 */
	public void setStrStoreCatSlNo(String strStoreCatSlNo) {
		this.strStoreCatSlNo = strStoreCatSlNo;
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
	 * Gets the str effective to.
	 * 
	 * @return the strEffectiveTo
	 */
	public String getStrEffectiveTo() {
		return strEffectiveTo;
	}

	/**
	 * Sets the str effective to.
	 * 
	 * @param strEffectiveTo the strEffectiveTo to set
	 */
	public void setStrEffectiveTo(String strEffectiveTo) {
		this.strEffectiveTo = strEffectiveTo;
	}

	/**
	 * Gets the str last mode seat id.
	 * 
	 * @return the strLastModeSeatId
	 */
	public String getStrLastModeSeatId() {
		return strLastModeSeatId;
	}

	/**
	 * Sets the str last mode seat id.
	 * 
	 * @param strLastModeSeatId the strLastModeSeatId to set
	 */
	public void setStrLastModeSeatId(String strLastModeSeatId) {
		this.strLastModeSeatId = strLastModeSeatId;
	}

	/**
	 * Gets the str last mode date.
	 * 
	 * @return the strLastModeDate
	 */
	public String getStrLastModeDate() {
		return strLastModeDate;
	}

	/**
	 * Sets the str last mode date.
	 * 
	 * @param strLastModeDate the strLastModeDate to set
	 */
	public void setStrLastModeDate(String strLastModeDate) {
		this.strLastModeDate = strLastModeDate;
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
	 * Gets the str chk1.
	 * 
	 * @return the strChk1
	 */
	public String getStrChk1() {
		return strChk1;
	}

	/**
	 * Sets the str chk1.
	 * 
	 * @param strChk1 the strChk1 to set
	 */
	public void setStrChk1(String strChk1) {
		this.strChk1 = strChk1;
	}

	/**
	 * Gets the str left store category list.
	 * 
	 * @return the strLeftStoreCategoryList
	 */
	public String getStrLeftStoreCategoryList() {
		return strLeftStoreCategoryList;
	}

	/**
	 * Sets the str left store category list.
	 * 
	 * @param strLeftStoreCategoryList the strLeftStoreCategoryList to set
	 */
	public void setStrLeftStoreCategoryList(String strLeftStoreCategoryList) {
		this.strLeftStoreCategoryList = strLeftStoreCategoryList;
	}

	/**
	 * Gets the str right store category list.
	 * 
	 * @return the strRightStoreCategoryList
	 */
	public String getStrRightStoreCategoryList() {
		return strRightStoreCategoryList;
	}

	/**
	 * Sets the str right store category list.
	 * 
	 * @param strRightStoreCategoryList the strRightStoreCategoryList to set
	 */
	public void setStrRightStoreCategoryList(String strRightStoreCategoryList) {
		this.strRightStoreCategoryList = strRightStoreCategoryList;
	}

	/**
	 * Gets the str right store categorys.
	 * 
	 * @return the strRightStoreCategorys
	 */
	public String[] getStrRightStoreCategorys() {
		return strRightStoreCategorys;
	}

	/**
	 * Sets the str right store categorys.
	 * 
	 * @param strRightStoreCategorys the strRightStoreCategorys to set
	 */
	public void setStrRightStoreCategorys(String[] strRightStoreCategorys) {
		this.strRightStoreCategorys = strRightStoreCategorys;
	}

	public String getStrStoreItemCategory() {
		return strStoreItemCategory;
	}

	public void setStrStoreItemCategory(String strStoreItemCategory) {
		this.strStoreItemCategory = strStoreItemCategory;
	}

}