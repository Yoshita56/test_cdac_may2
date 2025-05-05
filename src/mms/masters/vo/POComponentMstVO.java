package mms.masters.vo;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class POComponentMstVO.
 *  Modify By : Tanvi Sappal
 *  Modify Date : 12/05/2010
 */
public class POComponentMstVO {

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
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str lstmod date. */
	private String strLstmodDate = "";
	
	/** The str lstmod seat id. */
	private String strLstmodSeatId = "";
	
	/** The str entry date. */
	private String strEntryDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str is valid. */
	private String strIsValid = "";
	
	/** The str ct date. */
	private String strCtDate = "";
	
	/** The str msg. */
	private String strMsg = "";
	
	/** The str warning. */
	private String strWarning = "";
	
	/** The str errmsg. */
	private String strErrmsg = "";
	
	/** The str po component sl no. */
	private String strPOComponentSlNo = "";
	
	/** The str indent type id. */
	private String strIndentTypeId = "";
	
	/** The str component id. */
	private String strComponentId = "";
	
	/** The str po type name. */
	private String strPOTypeName = "";
	
	/** The str component name. */
	private String strComponentName = "";
	
	/** The str component value1. */
	private String strComponentValue1 = "";
	
	/** The str component value2. */
	private String strComponentValue2 = "";
	
	/** The str component value1 values. */
	private String strComponentValue1Values = "";
	
	/** The str component value2 values. */
	private String strComponentValue2Values = "";
	
	/** The str component name modify. */
	private String strComponentNameModify = "";
	
	/** The i s data exist. */
	private Boolean iSDataExist = false;
	
	/** The str cat no. */
	private String strCatNo = "";
	
	/** The str cat values. */
	private String strCatValues = "";
	
	/** The item category ws. */
	private WebRowSet itemCategoryWS = null;

	/** Web Row set declaration. */
	private WebRowSet WSPOTypeName = null;
	
	/** The WS component name. */
	private WebRowSet WSComponentName = null;
	
    private String strComponentType = "";
	
	private String strComponentTypeId = "";
	
	
	private String strParameterId;

	public String getStrParameterId() {
		return strParameterId;
	}

	public void setStrParameterId(String strParameterId) {
		this.strParameterId = strParameterId;
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
	 * @param strHospitalCode the new str hospital code
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Gets the str remarks.
	 * 
	 * @return the str remarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the new str remarks
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * Gets the str effective from.
	 * 
	 * @return the str effective from
	 */
	public String getStrEffectiveFrom() {
		return strEffectiveFrom;
	}

	/**
	 * Sets the str effective from.
	 * 
	 * @param strEffectiveFrom the new str effective from
	 */
	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
	}

	/**
	 * Gets the str lstmod date.
	 * 
	 * @return the str lstmod date
	 */
	public String getStrLstmodDate() {
		return strLstmodDate;
	}

	/**
	 * Sets the str lstmod date.
	 * 
	 * @param strLstmodDate the new str lstmod date
	 */
	public void setStrLstmodDate(String strLstmodDate) {
		this.strLstmodDate = strLstmodDate;
	}

	/**
	 * Gets the str lstmod seat id.
	 * 
	 * @return the str lstmod seat id
	 */
	public String getStrLstmodSeatId() {
		return strLstmodSeatId;
	}

	/**
	 * Sets the str lstmod seat id.
	 * 
	 * @param strLstmodSeatId the new str lstmod seat id
	 */
	public void setStrLstmodSeatId(String strLstmodSeatId) {
		this.strLstmodSeatId = strLstmodSeatId;
	}

	/**
	 * Gets the str entry date.
	 * 
	 * @return the str entry date
	 */
	public String getStrEntryDate() {
		return strEntryDate;
	}

	/**
	 * Sets the str entry date.
	 * 
	 * @param strEntryDate the new str entry date
	 */
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
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
	 * @param strSeatId the new str seat id
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * Gets the str component name.
	 * 
	 * @return the str component name
	 */
	public String getStrComponentName() {
		return strComponentName;
	}

	/**
	 * Sets the str component name.
	 * 
	 * @param strComponentName the new str component name
	 */
	public void setStrComponentName(String strComponentName) {
		this.strComponentName = strComponentName;
	}

	/**
	 * Gets the str component value1.
	 * 
	 * @return the str component value1
	 */
	public String getStrComponentValue1() {
		return strComponentValue1;
	}

	/**
	 * Sets the str component value1.
	 * 
	 * @param strComponentValue1 the new str component value1
	 */
	public void setStrComponentValue1(String strComponentValue1) {
		this.strComponentValue1 = strComponentValue1;
	}

	/**
	 * Gets the str component value2.
	 * 
	 * @return the str component value2
	 */
	public String getStrComponentValue2() {
		return strComponentValue2;
	}

	/**
	 * Sets the str component value2.
	 * 
	 * @param strComponentValue2 the new str component value2
	 */
	public void setStrComponentValue2(String strComponentValue2) {
		this.strComponentValue2 = strComponentValue2;
	}

	/**
	 * Gets the str is valid.
	 * 
	 * @return the str is valid
	 */
	public String getStrIsValid() {
		return strIsValid;
	}

	/**
	 * Sets the str is valid.
	 * 
	 * @param strIsValid the new str is valid
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	/**
	 * Gets the str msg.
	 * 
	 * @return the str msg
	 */
	public String getStrMsg() {
		return strMsg;
	}

	/**
	 * Sets the str msg.
	 * 
	 * @param strMsg the new str msg
	 */
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}

	/**
	 * Gets the str ct date.
	 * 
	 * @return the str ct date
	 */
	public String getStrCtDate() {
		return strCtDate;
	}

	/**
	 * Sets the str ct date.
	 * 
	 * @param strCtDate the new str ct date
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}

	/**
	 * Gets the str warning.
	 * 
	 * @return the str warning
	 */
	public String getStrWarning() {
		return strWarning;
	}

	/**
	 * Sets the str warning.
	 * 
	 * @param strWarning the new str warning
	 */
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}

	/**
	 * Gets the str errmsg.
	 * 
	 * @return the str errmsg
	 */
	public String getStrErrmsg() {
		return strErrmsg;
	}

	/**
	 * Sets the str errmsg.
	 * 
	 * @param strErrmsg the new str errmsg
	 */
	public void setStrErrmsg(String strErrmsg) {
		this.strErrmsg = strErrmsg;
	}

	/**
	 * Gets the serial version uid.
	 * 
	 * @return the serial version uid
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
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
	 * Gets the wS component name.
	 * 
	 * @return the wS component name
	 */
	public WebRowSet getWSComponentName() {
		return WSComponentName;
	}

	/**
	 * Sets the wS component name.
	 * 
	 * @param componentName the new wS component name
	 */
	public void setWSComponentName(WebRowSet componentName) {
		WSComponentName = componentName;
	}

	/**
	 * Gets the checks if is data exist.
	 * 
	 * @return the checks if is data exist
	 */
	public Boolean getISDataExist() {
		return iSDataExist;
	}

	/**
	 * Sets the checks if is data exist.
	 * 
	 * @param dataExist the new checks if is data exist
	 */
	public void setISDataExist(Boolean dataExist) {
		iSDataExist = dataExist;
	}

	/**
	 * Gets the str component id.
	 * 
	 * @return the str component id
	 */
	public String getStrComponentId() {
		return strComponentId;
	}

	/**
	 * Sets the str component id.
	 * 
	 * @param strComponentId the new str component id
	 */
	public void setStrComponentId(String strComponentId) {
		this.strComponentId = strComponentId;
	}

	/**
	 * Gets the str component value1 values.
	 * 
	 * @return the str component value1 values
	 */
	public String getStrComponentValue1Values() {
		return strComponentValue1Values;
	}

	/**
	 * Sets the str component value1 values.
	 * 
	 * @param strComponentValue1Values the new str component value1 values
	 */
	public void setStrComponentValue1Values(String strComponentValue1Values) {
		this.strComponentValue1Values = strComponentValue1Values;
	}

	/**
	 * Gets the str component value2 values.
	 * 
	 * @return the str component value2 values
	 */
	public String getStrComponentValue2Values() {
		return strComponentValue2Values;
	}

	/**
	 * Sets the str component value2 values.
	 * 
	 * @param strComponentValue2Values the new str component value2 values
	 */
	public void setStrComponentValue2Values(String strComponentValue2Values) {
		this.strComponentValue2Values = strComponentValue2Values;
	}

	/**
	 * Gets the str component name modify.
	 * 
	 * @return the str component name modify
	 */
	public String getStrComponentNameModify() {
		return strComponentNameModify;
	}

	/**
	 * Sets the str component name modify.
	 * 
	 * @param strComponentNameModify the new str component name modify
	 */
	public void setStrComponentNameModify(String strComponentNameModify) {
		this.strComponentNameModify = strComponentNameModify;
	}

	/**
	 * Gets the str po component sl no.
	 * 
	 * @return the strPOComponentSlNo
	 */
	public String getStrPOComponentSlNo() {
		return strPOComponentSlNo;
	}

	/**
	 * Sets the str po component sl no.
	 * 
	 * @param strPOComponentSlNo the strPOComponentSlNo to set
	 */
	public void setStrPOComponentSlNo(String strPOComponentSlNo) {
		this.strPOComponentSlNo = strPOComponentSlNo;
	}

	/**
	 * Gets the str po type name.
	 * 
	 * @return the strPOTypeName
	 */
	public String getStrPOTypeName() {
		return strPOTypeName;
	}

	/**
	 * Sets the str po type name.
	 * 
	 * @param strPOTypeName the strPOTypeName to set
	 */
	public void setStrPOTypeName(String strPOTypeName) {
		this.strPOTypeName = strPOTypeName;
	}

	/**
	 * Gets the wspo type name.
	 * 
	 * @return the wSPOTypeName
	 */
	public WebRowSet getWSPOTypeName() {
		return WSPOTypeName;
	}

	/**
	 * Sets the wspo type name.
	 * 
	 * @param typeName the wSPOTypeName to set
	 */
	public void setWSPOTypeName(WebRowSet typeName) {
		WSPOTypeName = typeName;
	}

	/**
	 * Gets the str indent type id.
	 * 
	 * @return the strIndentTypeId
	 */
	public String getStrIndentTypeId() {
		return strIndentTypeId;
	}

	/**
	 * Sets the str indent type id.
	 * 
	 * @param strIndentTypeId the strIndentTypeId to set
	 */
	public void setStrIndentTypeId(String strIndentTypeId) {
		this.strIndentTypeId = strIndentTypeId;
	}

	/**
	 * Gets the str cat no.
	 * 
	 * @return the strCatNo
	 */
	public String getStrCatNo() {
		return strCatNo;
	}

	/**
	 * Sets the str cat no.
	 * 
	 * @param strCatNo the strCatNo to set
	 */
	public void setStrCatNo(String strCatNo) {
		this.strCatNo = strCatNo;
	}

	/**
	 * Gets the str cat values.
	 * 
	 * @return the strCatValues
	 */
	public String getStrCatValues() {
		return strCatValues;
	}

	/**
	 * Sets the str cat values.
	 * 
	 * @param strCatValues the strCatValues to set
	 */
	public void setStrCatValues(String strCatValues) {
		this.strCatValues = strCatValues;
	}

	/**
	 * Gets the item category ws.
	 * 
	 * @return the itemCategoryWS
	 */
	public WebRowSet getItemCategoryWS() {
		return itemCategoryWS;
	}

	/**
	 * Sets the item category ws.
	 * 
	 * @param itemCategoryWS the itemCategoryWS to set
	 */
	public void setItemCategoryWS(WebRowSet itemCategoryWS) {
		this.itemCategoryWS = itemCategoryWS;
	}

	/**
	 * @return the strComponentType
	 */
	public String getStrComponentType() {
		return strComponentType;
	}

	/**
	 * @param strComponentType the strComponentType to set
	 */
	public void setStrComponentType(String strComponentType) {
		this.strComponentType = strComponentType;
	}

	/**
	 * @return the strComponentTypeId
	 */
	public String getStrComponentTypeId() {
		return strComponentTypeId;
	}

	/**
	 * @param strComponentTypeId the strComponentTypeId to set
	 */
	public void setStrComponentTypeId(String strComponentTypeId) {
		this.strComponentTypeId = strComponentTypeId;
	}

}
