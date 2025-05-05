package mms.reports.controller.fb;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import org.apache.struts.action.ActionForm;

public class SampleIssueDetailRptFB extends ActionForm 
{
	private static final long serialVersionUID = 02L;
	private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
    private String strMsgString = "";
	private String strMsgType = "";
	private String strErrMsg = "";

	private String strHospitalCode = "";
	private String strCtDate = "";
	private String strSeatId = "";
	private String strViewChk="";
	/************Variable Start Here******************/
	private String strStoreId = "";
	private String strStoreName = "";
	private String[] itemParamValue = {""};
	private String strFromDate;
    private String strToDate;
	 
	
	
	private String strLabId;
	private String strLabName;
	private String strLabNameCombo;
	
	private String strReportFormat;
	private String strIsFooter="";
	private String strUserRemarks="";
	
	public String getStrErr() {
		return strErr;
	}
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}
	public String getStrMsg() {
		return strMsg;
	}
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}
	public String getStrWarning() {
		return strWarning;
	}
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}
	public String getStrMsgString() {
		return strMsgString;
	}
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}
	public String getStrMsgType() {
		return strMsgType;
	}
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}
	public String getStrErrMsg() {
		return strErrMsg;
	}
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrCtDate() {
		return strCtDate;
	}
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getStrViewChk() {
		return strViewChk;
	}
	public void setStrViewChk(String strViewChk) {
		this.strViewChk = strViewChk;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	
	public String[] getItemParamValue() {
		return itemParamValue;
	}
	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
	}
	
	public String getStrFromDate() {
		return strFromDate;
	}
	public void setStrFromDate(String strFromDate) {
		this.strFromDate = strFromDate;
	}
	public String getStrToDate() {
		return strToDate;
	}
	public void setStrToDate(String strToDate) {
		this.strToDate = strToDate;
	}
	
	public String getStrLabId() {
		return strLabId;
	}
	public void setStrLabId(String strLabId) {
		this.strLabId = strLabId;
	}
	public String getStrLabName() {
		return strLabName;
	}
	public void setStrLabName(String strLabName) {
		this.strLabName = strLabName;
	}
	
	public String getStrLabNameCombo() {
		return strLabNameCombo;
	}
	public void setStrLabNameCombo(String strLabNameCombo) {
		this.strLabNameCombo = strLabNameCombo;
	}
	
	public String getStrReportFormat() {
		return strReportFormat;
	}
	public void setStrReportFormat(String strReportFormat) {
		this.strReportFormat = strReportFormat;
	}
	public String getStrIsFooter() {
		return strIsFooter;
	}
	public void setStrIsFooter(String strIsFooter) {
		this.strIsFooter = strIsFooter;
	}
	public String getStrUserRemarks() {
		return strUserRemarks;
	}
	public void setStrUserRemarks(String strUserRemarks) {
		this.strUserRemarks = strUserRemarks;
	}

	
	
	
}
