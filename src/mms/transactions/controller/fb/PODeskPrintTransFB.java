package mms.transactions.controller.fb;

import javax.sql.rowset.WebRowSet;

import org.apache.struts.action.ActionForm;

public class PODeskPrintTransFB extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String strHospitalCode = "";
	private String strReportId = "";
	private String strPoHlp="";
	private String strMsgType="";
	private String strMsgString="";
	private String strPONO="";
	private String strPOStoreId="";
	private String strPOTypeId="";
	private String strCatgCode="";
	
	private String strErr;
	private String strWarning;
	private String strMsg;
	private String strChk;
	private String strCurrentDate;
	private String strPOStatus="";
	
	private WebRowSet wbPODtls = null;
	private WebRowSet wbTermsCondDtls = null;
	private WebRowSet wbPOComponentDtls = null;
	private WebRowSet wbCopyToDtlsDtls = null;
	
	

	
	public String getStrPOStatus() {
		return strPOStatus;
	}
	public void setStrPOStatus(String strPOStatus) {
		this.strPOStatus = strPOStatus;
	}
	public WebRowSet getWbCopyToDtlsDtls() {
		return wbCopyToDtlsDtls;
	}
	public void setWbCopyToDtlsDtls(WebRowSet wbCopyToDtlsDtls) {
		this.wbCopyToDtlsDtls = wbCopyToDtlsDtls;
	}
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
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
	public String getStrWarning() {
		return strWarning;
	}
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}
	public String getStrMsg() {
		return strMsg;
	}
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}
	public String getStrPONO() {
		return strPONO;
	}
	public void setStrPONO(String strPONO) {
		this.strPONO = strPONO;
	}
	public String getStrPOStoreId() {
		return strPOStoreId;
	}
	public void setStrPOStoreId(String strPOStoreId) {
		this.strPOStoreId = strPOStoreId;
	}
	public String getStrPOTypeId() {
		return strPOTypeId;
	}
	public void setStrPOTypeId(String strPOTypeId) {
		this.strPOTypeId = strPOTypeId;
	}
	public String getStrCatgCode() {
		return strCatgCode;
	}
	public void setStrCatgCode(String strCatgCode) {
		this.strCatgCode = strCatgCode;
	}
	public WebRowSet getWbPODtls() {
		return wbPODtls;
	}
	public void setWbPODtls(WebRowSet wbPODtls) {
		this.wbPODtls = wbPODtls;
	}
	public WebRowSet getWbTermsCondDtls() {
		return wbTermsCondDtls;
	}
	public void setWbTermsCondDtls(WebRowSet wbTermsCondDtls) {
		this.wbTermsCondDtls = wbTermsCondDtls;
	}
	public WebRowSet getWbPOComponentDtls() {
		return wbPOComponentDtls;
	}
	public void setWbPOComponentDtls(WebRowSet wbPOComponentDtls) {
		this.wbPOComponentDtls = wbPOComponentDtls;
	}
	public String getStrPoHlp() {
		return strPoHlp;
	}
	public void setStrPoHlp(String strPoHlp) {
		this.strPoHlp = strPoHlp;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrReportId() {
		return strReportId;
	}
	public void setStrReportId(String strReportId) {
		this.strReportId = strReportId;
	}
	

	public String getStrMsgType() {
		return strMsgType;
	}
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}
	public String getStrMsgString() {
		return strMsgString;
	}
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}
	
	
	

}
