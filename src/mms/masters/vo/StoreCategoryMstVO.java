package mms.masters.vo;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreCategoryMstVO.
 */
public class StoreCategoryMstVO {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The B exist status. */
	private Boolean BExistStatus = false;
	
	/** The str msg string. */
	private String strMsgString = "";
	
	/** The str msg type. */
	private String strMsgType = "";

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str store id. */
	private String strStoreId = "";
	
	/** The str store name. */
	private String strStoreName = "";
	
	/** The str store category. */
	private String strStoreCategory = "";
	
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
	
	/** The str item cat no array. */
	private String strItemCatNoArray[] = null;
	
	/** The str left store category list. */
	private String strLeftStoreCategoryList = "";
	
	/** The str right store category list. */
	private String strRightStoreCategoryList = "";

	/** The str left store category list ws. */
	private WebRowSet strLeftStoreCategoryListWs = null;

	/** The str right store category list ws. */
	private WebRowSet strRightStoreCategoryListWs = null;
	private String strItemBounded;
	private String strStoreItemCategory;
	private String 	strIsNewItemFlag;


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
	 * Gets the b exist status.
	 * 
	 * @return the bExistStatus
	 */
	public Boolean getBExistStatus() {
		return BExistStatus;
	}

	/**
	 * Sets the b exist status.
	 * 
	 * @param existStatus the bExistStatus to set
	 */
	public void setBExistStatus(Boolean existStatus) {
		BExistStatus = existStatus;
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
	 * Gets the str left store category list ws.
	 * 
	 * @return the strLeftStoreCategoryListWs
	 */
	public WebRowSet getStrLeftStoreCategoryListWs() {
		return strLeftStoreCategoryListWs;
	}

	/**
	 * Sets the str left store category list ws.
	 * 
	 * @param strLeftStoreCategoryListWs the strLeftStoreCategoryListWs to set
	 */
	public void setStrLeftStoreCategoryListWs(
			WebRowSet strLeftStoreCategoryListWs) {
		this.strLeftStoreCategoryListWs = strLeftStoreCategoryListWs;
	}

	/**
	 * Gets the str right store category list ws.
	 * 
	 * @return the strRightStoreCategoryListWs
	 */
	public WebRowSet getStrRightStoreCategoryListWs() {
		return strRightStoreCategoryListWs;
	}

	/**
	 * Sets the str right store category list ws.
	 * 
	 * @param strRightStoreCategoryListWs the strRightStoreCategoryListWs to set
	 */
	public void setStrRightStoreCategoryListWs(
			WebRowSet strRightStoreCategoryListWs) {
		this.strRightStoreCategoryListWs = strRightStoreCategoryListWs;
	}

	/**
	 * Gets the str item cat no array.
	 * 
	 * @return the str item cat no array
	 */
	public String[] getStrItemCatNoArray() {
		return strItemCatNoArray;
	}

	/**
	 * Sets the str item cat no array.
	 * 
	 * @param strItemCatNoArray the new str item cat no array
	 */
	public void setStrItemCatNoArray(String[] strItemCatNoArray) {
		this.strItemCatNoArray = strItemCatNoArray;
	}

	public String getStrStoreItemCategory() {
		return strStoreItemCategory;
	}

	public void setStrStoreItemCategory(String strStoreItemCategory) {
		this.strStoreItemCategory = strStoreItemCategory;
	}

}
