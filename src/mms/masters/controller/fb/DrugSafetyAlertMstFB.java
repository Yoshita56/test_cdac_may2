package mms.masters.controller.fb;

import javax.sql.rowset.WebRowSet;

import org.apache.struts.action.ActionForm;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugSafetyAlertMstFB.
 */
public class DrugSafetyAlertMstFB extends ActionForm {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The str err. */
	private String strErr = "";
	
	/** The str msg. */
	private String strMsg = "";
	
	/** The str warning. */
	private String strWarning = "";

	/** The str msg string. */
	private String strMsgString = "";
	
	/** The str msg type. */
	private String strMsgType = "";

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str group id. */
	private String strGroupId = "";
	
	/** The str ct date. */
	private String strCtDate = "";
	
	/** The str chk1. */
	private String strChk1 = "";

	/** ***********Master Variable************. */
	private String strDrugName = "";
	
	/** The str drug name combo. */
	private String strDrugNameCombo = "";
	
	/** The str group name combo. */
	private String strGroupNameCombo = "";
	
	/** The str group name. */
	private String strGroupName = "";
	
	/** The str sub group name. */
	private String strSubGroupName = "";
	
	/** The str sub group name combo. */
	private String strSubGroupNameCombo = "";
	
	/** The str added data. */
	private String[] strAddedData = { "0" };

	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str store type id. */
	private String strStoreTypeId = "";
	
	/** The str item dtl hlp. */
	private String strItemDtlHlp = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str added data ws. */
	private WebRowSet strAddedDataWs = null;
	
	/** The str get view. */
	private String strGetView = "";

	/**
	 * Gets the str get view.
	 * 
	 * @return the str get view
	 */
	public String getStrGetView() {
		return strGetView;
	}

	/**
	 * Sets the str get view.
	 * 
	 * @param strGetView the new str get view
	 */
	public void setStrGetView(String strGetView) {
		this.strGetView = strGetView;
	}

	/**
	 * Gets the str added data ws.
	 * 
	 * @return the str added data ws
	 */
	public WebRowSet getStrAddedDataWs() {
		return strAddedDataWs;
	}

	/**
	 * Sets the str added data ws.
	 * 
	 * @param strAddedDataWs the new str added data ws
	 */
	public void setStrAddedDataWs(WebRowSet strAddedDataWs) {
		this.strAddedDataWs = strAddedDataWs;
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
	 * Gets the str item dtl hlp.
	 * 
	 * @return the str item dtl hlp
	 */
	public String getStrItemDtlHlp() {
		return strItemDtlHlp;
	}

	/**
	 * Sets the str item dtl hlp.
	 * 
	 * @param strItemDtlHlp the new str item dtl hlp
	 */
	public void setStrItemDtlHlp(String strItemDtlHlp) {
		this.strItemDtlHlp = strItemDtlHlp;
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
	 * @param strDrugName the new str drug name
	 */
	public void setStrDrugName(String strDrugName) {
		this.strDrugName = strDrugName;
	}

	/**
	 * Gets the str drug name combo.
	 * 
	 * @return the str drug name combo
	 */
	public String getStrDrugNameCombo() {
		return strDrugNameCombo;
	}

	/**
	 * Sets the str drug name combo.
	 * 
	 * @param strDrugNameCombo the new str drug name combo
	 */
	public void setStrDrugNameCombo(String strDrugNameCombo) {
		this.strDrugNameCombo = strDrugNameCombo;
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
	 * Gets the str err.
	 * 
	 * @return the str err
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * Sets the str err.
	 * 
	 * @param strErr the new str err
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
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
	 * Gets the str msg string.
	 * 
	 * @return the str msg string
	 */
	public String getStrMsgString() {
		return strMsgString;
	}

	/**
	 * Sets the str msg string.
	 * 
	 * @param strMsgString the new str msg string
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	/**
	 * Gets the str msg type.
	 * 
	 * @return the str msg type
	 */
	public String getStrMsgType() {
		return strMsgType;
	}

	/**
	 * Sets the str msg type.
	 * 
	 * @param strMsgType the new str msg type
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
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
	 * @param strGroupId the new str group id
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
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
	 * @param strStoreTypeId the new str store type id
	 */
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}

	/**
	 * Gets the str group name combo.
	 * 
	 * @return the str group name combo
	 */
	public String getStrGroupNameCombo() {
		return strGroupNameCombo;
	}

	/**
	 * Sets the str group name combo.
	 * 
	 * @param strGroupNameCombo the new str group name combo
	 */
	public void setStrGroupNameCombo(String strGroupNameCombo) {
		this.strGroupNameCombo = strGroupNameCombo;
	}

	/**
	 * Gets the str group name.
	 * 
	 * @return the str group name
	 */
	public String getStrGroupName() {
		return strGroupName;
	}

	/**
	 * Sets the str group name.
	 * 
	 * @param strGroupName the new str group name
	 */
	public void setStrGroupName(String strGroupName) {
		this.strGroupName = strGroupName;
	}

	/**
	 * Gets the str sub group name.
	 * 
	 * @return the str sub group name
	 */
	public String getStrSubGroupName() {
		return strSubGroupName;
	}

	/**
	 * Sets the str sub group name.
	 * 
	 * @param strSubGroupName the new str sub group name
	 */
	public void setStrSubGroupName(String strSubGroupName) {
		this.strSubGroupName = strSubGroupName;
	}

	/**
	 * Gets the str sub group name combo.
	 * 
	 * @return the str sub group name combo
	 */
	public String getStrSubGroupNameCombo() {
		return strSubGroupNameCombo;
	}

	/**
	 * Sets the str sub group name combo.
	 * 
	 * @param strSubGroupNameCombo the new str sub group name combo
	 */
	public void setStrSubGroupNameCombo(String strSubGroupNameCombo) {
		this.strSubGroupNameCombo = strSubGroupNameCombo;
	}

	/**
	 * Gets the str added data.
	 * 
	 * @return the str added data
	 */
	public String[] getStrAddedData() {
		return strAddedData;
	}

	/**
	 * Sets the str added data.
	 * 
	 * @param strAddedData the new str added data
	 */
	public void setStrAddedData(String[] strAddedData) {
		this.strAddedData = strAddedData;
	}

	/**
	 * Gets the str chk1.
	 * 
	 * @return the str chk1
	 */
	public String getStrChk1() {
		return strChk1;
	}

	/**
	 * Sets the str chk1.
	 * 
	 * @param strChk1 the new str chk1
	 */
	public void setStrChk1(String strChk1) {
		this.strChk1 = strChk1;
	}

	/**
	 * Sets the str ct date.
	 * 
	 * @param strCtDate the strCtDate to set
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}
}
