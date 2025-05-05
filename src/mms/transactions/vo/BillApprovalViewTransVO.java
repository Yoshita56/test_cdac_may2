package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

/**
 * Developer : Pramod Kumar Mehta 
 * Version : 1.0 
 * Date : 02/April/2009
 *  Module:MMS
 * Unit:Bill Approval View 
 */
public class BillApprovalViewTransVO {
	
	private static final long serialVersionUID = 02L;

	private String strErrMsg = "";
	private String strNormalMsg = "";
	private String strWarningMsg = "";
	private String strMsgType = "";
	private String strMsgString = "";
	private String strPONetAmount = "";
	private String strAgentName = "";
	private String strAgentNameShow = "";
	private String strCAName = "";
	private String strHospitalCode = "";
	private String strIsValid = "";
	private String strSeatId = "";
	
	private String strStoreId = "";
	private String strPoNo = "";
	private String strInvoiceNo = "";
	private String strPOPrefix = "";
	private String strPoDate="";
	private String strPoType="";
	private String strSupplierDtl="";
	private String strItemCatNo="";
	private String strCurrancyValue="";
	private String strCurrancyName="";
	private String strTax="";
	private String strAdvanceAmount="";
	private String strPeneltyAmt="";
	private String strWaveOffDtl="";
	private String strWaveOffAmt="";
	private String strApprovedBy="";
	private String strApprovalDate= "";
	private String strAdvanceAdjustedAmt="";
	private String strNetcalCost="";
	private String strRemarks=""; 
	private String strBillNo="";
	private String strBillDate="";
	private String strBillAmt="";
	private String strPoStoreId="";
	
	
	private WebRowSet scheduleWS=null;
	public WebRowSet getScheduleWS() {
		return scheduleWS;
	}
	public void setScheduleWS(WebRowSet scheduleWS) {
		this.scheduleWS = scheduleWS;
	}
	public String getStrErrMsg() {
		return strErrMsg;
	}
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}
	public String getStrNormalMsg() {
		return strNormalMsg;
	}
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}
	public String getStrWarningMsg() {
		return strWarningMsg;
	}
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
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
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrIsValid() {
		return strIsValid;
	}
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrPoNo() {
		return strPoNo;
	}
	public void setStrPoNo(String strPoNo) {
		this.strPoNo = strPoNo;
	}
	public String getStrInvoiceNo() {
		return strInvoiceNo;
	}
	public void setStrInvoiceNo(String strInvoiceNo) {
		this.strInvoiceNo = strInvoiceNo;
	}
	public String getStrPoDate() {
		return strPoDate;
	}
	public void setStrPoDate(String strPoDate) {
		this.strPoDate = strPoDate;
	}
	public String getStrPoType() {
		return strPoType;
	}
	public void setStrPoType(String strPoType) {
		this.strPoType = strPoType;
	}
	public String getStrSupplierDtl() {
		return strSupplierDtl;
	}
	public void setStrSupplierDtl(String strSupplierDtl) {
		this.strSupplierDtl = strSupplierDtl;
	}
	public String getStrItemCatNo() {
		return strItemCatNo;
	}
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}
	public String getStrCurrancyName() {
		return strCurrancyName;
	}
	public void setStrCurrancyName(String strCurrancyName) {
		this.strCurrancyName = strCurrancyName;
	}
	public String getStrTax() {
		return strTax;
	}
	public void setStrTax(String strTax) {
		this.strTax = strTax;
	}
	public String getStrAdvanceAmount() {
		return strAdvanceAmount;
	}
	public void setStrAdvanceAmount(String strAdvanceAmount) {
		this.strAdvanceAmount = strAdvanceAmount;
	}
	public String getStrPeneltyAmt() {
		return strPeneltyAmt;
	}
	public void setStrPeneltyAmt(String strPeneltyAmt) {
		this.strPeneltyAmt = strPeneltyAmt;
	}
	public String getStrWaveOffDtl() {
		return strWaveOffDtl;
	}
	public void setStrWaveOffDtl(String strWaveOffDtl) {
		this.strWaveOffDtl = strWaveOffDtl;
	}
	public String getStrWaveOffAmt() {
		return strWaveOffAmt;
	}
	public void setStrWaveOffAmt(String strWaveOffAmt) {
		this.strWaveOffAmt = strWaveOffAmt;
	}
	public String getStrApprovedBy() {
		return strApprovedBy;
	}
	public void setStrApprovedBy(String strApprovedBy) {
		this.strApprovedBy = strApprovedBy;
	}
	public String getStrApprovalDate() {
		return strApprovalDate;
	}
	public void setStrApprovalDate(String strApprovalDate) {
		this.strApprovalDate = strApprovalDate;
	}
	public String getStrAdvanceAdjustedAmt() {
		return strAdvanceAdjustedAmt;
	}
	public void setStrAdvanceAdjustedAmt(String strAdvanceAdjustedAmt) {
		this.strAdvanceAdjustedAmt = strAdvanceAdjustedAmt;
	}
	public String getStrNetcalCost() {
		return strNetcalCost;
	}
	public void setStrNetcalCost(String strNetcalCost) {
		this.strNetcalCost = strNetcalCost;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrBillNo() {
		return strBillNo;
	}
	public void setStrBillNo(String strBillNo) {
		this.strBillNo = strBillNo;
	}
	public String getStrBillDate() {
		return strBillDate;
	}
	public void setStrBillDate(String strBillDate) {
		this.strBillDate = strBillDate;
	}
	public String getStrBillAmt() {
		return strBillAmt;
	}
	public void setStrBillAmt(String strBillAmt) {
		this.strBillAmt = strBillAmt;
	}
	public String getStrCurrancyValue() {
		return strCurrancyValue;
	}
	public void setStrCurrancyValue(String strCurrancyValue) {
		this.strCurrancyValue = strCurrancyValue;
	}
	public String getStrPoStoreId() {
		return strPoStoreId;
	}
	public void setStrPoStoreId(String strPoStoreId) {
		this.strPoStoreId = strPoStoreId;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getStrPONetAmount() {
		return strPONetAmount;
	}
	public String getStrAgentName() {
		return strAgentName;
	}
	public String getStrAgentNameShow() {
		return strAgentNameShow;
	}
	public String getStrCAName() {
		return strCAName;
	}
	public void setStrPONetAmount(String strPONetAmount) {
		this.strPONetAmount = strPONetAmount;
	}
	public void setStrAgentName(String strAgentName) {
		this.strAgentName = strAgentName;
	}
	public void setStrAgentNameShow(String strAgentNameShow) {
		this.strAgentNameShow = strAgentNameShow;
	}
	public void setStrCAName(String strCAName) {
		this.strCAName = strCAName;
	}
	public String getStrPOPrefix() {
		return strPOPrefix;
	}
	public void setStrPOPrefix(String strPOPrefix) {
		this.strPOPrefix = strPOPrefix;
	}
	
	
	
	
}
