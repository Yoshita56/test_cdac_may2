package mms.transactions.controller.fb;

import hisglobal.transactionutil.GenericFormBean;

public class IndentTransFB extends GenericFormBean 
{
	private static final long serialVersionUID = 02L;
    private String strHospCode ="";
    private String strSeatId ="";
    private String strChk ="";
    private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
    private String strMsgString = "";
	private String strMsgType = "0";
	private String strErrMsg = "";
	private String strGoFlg ="";
	//Primary Key
	private String strReqNo = "";
	private String strStoreId = "";
	private String strRequestTypeId ="";
	private String strItemCatgNo = "";
	private String strIsUrgentFlg ="";
	private String strIndentPeriod="";	
	
	private String strStoreCombo;
	private String strReqTypeCombo;
	private String strCatgCombo;
	
	private String strStatusCode;
	private String strDataTable;
	
	private String strCrNo;
	
	private String strStoreName;
	private String strCatgName;
	private String strReqName;
	
	
		
	
	
	public String getStrCatgName() {
		return strCatgName;
	}
	public void setStrCatgName(String strCatgName) {
		this.strCatgName = strCatgName;
	}
	public String getStrReqName() {
		return strReqName;
	}
	public void setStrReqName(String strReqName) {
		this.strReqName = strReqName;
	}
	public String getStrRequestTypeId() {
		return strRequestTypeId;
	}
	public void setStrRequestTypeId(String strRequestTypeId) {
		this.strRequestTypeId = strRequestTypeId;
	}
	public String getStrCrNo() {
		return strCrNo;
	}
	public void setStrCrNo(String strCrNo) {
		this.strCrNo = strCrNo;
	}
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String getStrStoreCombo() {
		return strStoreCombo;
	}
	public void setStrStoreCombo(String strStoreCombo) {
		this.strStoreCombo = strStoreCombo;
	}
	public String getStrReqTypeCombo() {
		return strReqTypeCombo;
	}
	public void setStrReqTypeCombo(String strReqTypeCombo) {
		this.strReqTypeCombo = strReqTypeCombo;
	}
	public String getStrCatgCombo() {
		return strCatgCombo;
	}
	public void setStrCatgCombo(String strCatgCombo) {
		this.strCatgCombo = strCatgCombo;
	}
	public String getStrStatusCode() {
		return strStatusCode;
	}
	public void setStrStatusCode(String strStatusCode) {
		this.strStatusCode = strStatusCode;
	}
	public String getStrDataTable() {
		return strDataTable;
	}
	public void setStrDataTable(String strDataTable) {
		this.strDataTable = strDataTable;
	}
	public String getStrGoFlg() {
		return strGoFlg;
	}
	public void setStrGoFlg(String strGoFlg) {
		this.strGoFlg = strGoFlg;
	}
	public String getStrHospCode() {
		return strHospCode;
	}
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getStrChk() {
		return strChk;
	}
	public void setStrChk(String strChk) {
		this.strChk = strChk;
	}
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
	public String getStrReqNo() {
		return strReqNo;
	}
	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	
	public String getStrItemCatgNo() {
		return strItemCatgNo;
	}
	public void setStrItemCatgNo(String strItemCatgNo) {
		this.strItemCatgNo = strItemCatgNo;
	}
	public String getStrIsUrgentFlg() {
		return strIsUrgentFlg;
	}
	public void setStrIsUrgentFlg(String strIsUrgentFlg) {
		this.strIsUrgentFlg = strIsUrgentFlg;
	}
	public String getStrIndentPeriod() {
		return strIndentPeriod;
	}
	public void setStrIndentPeriod(String strIndentPeriod) {
		this.strIndentPeriod = strIndentPeriod;
	}
}
