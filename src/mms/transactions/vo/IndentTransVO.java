package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

/**
 * @author Amit Kumar
 * Date of Creation : 31/3/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
public class IndentTransVO 
{
	private String strHospCode ="";
    private String strSeatId ="";
    private String strChk ="";
    private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
    private String strMsgString = "";
	private String strMsgType = "0";
	private String strErrMsg = "";
	//Primary Key
	private String strReqNo = "";
	private String strStoreId = "";
	//private String strReqTypeId ="";
	private String strItemCatgNo = "";
	private String strIsUrgentFlg ="";
	private String strIndentPeriod="";
	private String strCancelReson="";
	
	private WebRowSet strStoreWs=null;
	private WebRowSet strRequestTypeWs=null;
	private WebRowSet strCatgWs=null;	
	private WebRowSet strDataTableWs=null;	
	private String strStatusCode;
	private String strRequestTypeId;
	private String strItemCategNo;
	
	
	
	
	public String getStrRequestTypeId() {
		return strRequestTypeId;
	}
	public void setStrRequestTypeId(String strRequestTypeId) {
		this.strRequestTypeId = strRequestTypeId;
	}
	public String getStrItemCategNo() {
		return strItemCategNo;
	}
	public void setStrItemCategNo(String strItemCategNo) {
		this.strItemCategNo = strItemCategNo;
	}
	public WebRowSet getStrStoreWs() {
		return strStoreWs;
	}
	public void setStrStoreWs(WebRowSet strStoreWs) {
		this.strStoreWs = strStoreWs;
	}
	public WebRowSet getStrRequestTypeWs() {
		return strRequestTypeWs;
	}
	public void setStrRequestTypeWs(WebRowSet strRequestTypeWs) {
		this.strRequestTypeWs = strRequestTypeWs;
	}
	public WebRowSet getStrCatgWs() {
		return strCatgWs;
	}
	public void setStrCatgWs(WebRowSet strCatgWs) {
		this.strCatgWs = strCatgWs;
	}
	public WebRowSet getStrDataTableWs() {
		return strDataTableWs;
	}
	public void setStrDataTableWs(WebRowSet strDataTableWs) {
		this.strDataTableWs = strDataTableWs;
	}
	public String getStrStatusCode() {
		return strStatusCode;
	}
	public void setStrStatusCode(String strStatusCode) {
		this.strStatusCode = strStatusCode;
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
	public String getStrCancelReson() {
		return strCancelReson;
	}
	public void setStrCancelReson(String strCancelReson) {
		this.strCancelReson = strCancelReson;
	}	

}
