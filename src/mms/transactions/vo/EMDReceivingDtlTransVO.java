package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

public class EMDReceivingDtlTransVO {


	private static final long serialVersionUID = 02L;
	
	private String strMsgType = "";
	private String strMsgString = "";
	
	private String strIsValid = "";
	private String strSeatId = "";
	private String strHospitalCode = "";
	
	private String strSupplierName = "";
	private String strSupplierCombo = "";
	private String strTenderNo = "";
	private String strQuotationNo = "";
	private String strReceiptDate = "";
	private String strEmdAmount = "";
	private String strEmdAmountType = "";
	private String strEmdAmountTypeCombo = "";
	private String strPaymentMode = "";
	private String strChequeDDDate = "";
	private String strChequeDDNo = "";
	private String strDraweeBankName = "";
	private String strPayableAt = "";
	private String strChequeValidity = "";
	private String strRemarks = "";
	
	
	
	private String strFinancialStartYear = "";
	private String strFinancialEndYear = "";
	
	private WebRowSet strEmdAmountTypeWs = null;
	private WebRowSet strSupplierWs = null;
	
	public String getStrSupplierName() {
		return strSupplierName;
	}
	public void setStrSupplierName(String strSupplierName) {
		this.strSupplierName = strSupplierName;
	}
	public String getStrSupplierCombo() {
		return strSupplierCombo;
	}
	public void setStrSupplierCombo(String strSupplierCombo) {
		this.strSupplierCombo = strSupplierCombo;
	}
	public String getStrTenderNo() {
		return strTenderNo;
	}
	public void setStrTenderNo(String strTenderNo) {
		this.strTenderNo = strTenderNo;
	}
	public String getStrQuotationNo() {
		return strQuotationNo;
	}
	public void setStrQuotationNo(String strQuotationNo) {
		this.strQuotationNo = strQuotationNo;
	}
	public String getStrReceiptDate() {
		return strReceiptDate;
	}
	public void setStrReceiptDate(String strReceiptDate) {
		this.strReceiptDate = strReceiptDate;
	}
	public String getStrEmdAmount() {
		return strEmdAmount;
	}
	public void setStrEmdAmount(String strEmdAmount) {
		this.strEmdAmount = strEmdAmount;
	}
	public String getStrEmdAmountType() {
		return strEmdAmountType;
	}
	public void setStrEmdAmountType(String strEmdAmountType) {
		this.strEmdAmountType = strEmdAmountType;
	}
	public String getStrEmdAmountTypeCombo() {
		return strEmdAmountTypeCombo;
	}
	public void setStrEmdAmountTypeCombo(String strEmdAmountTypeCombo) {
		this.strEmdAmountTypeCombo = strEmdAmountTypeCombo;
	}
	public String getStrPaymentMode() {
		return strPaymentMode;
	}
	public void setStrPaymentMode(String strPaymentMode) {
		this.strPaymentMode = strPaymentMode;
	}
	public String getStrChequeDDDate() {
		return strChequeDDDate;
	}
	public void setStrChequeDDDate(String strChequeDDDate) {
		this.strChequeDDDate = strChequeDDDate;
	}
	public String getStrChequeDDNo() {
		return strChequeDDNo;
	}
	public void setStrChequeDDNo(String strChequeDDNo) {
		this.strChequeDDNo = strChequeDDNo;
	}
	public String getStrDraweeBankName() {
		return strDraweeBankName;
	}
	public void setStrDraweeBankName(String strDraweeBankName) {
		this.strDraweeBankName = strDraweeBankName;
	}
	public String getStrPayableAt() {
		return strPayableAt;
	}
	public void setStrPayableAt(String strPayableAt) {
		this.strPayableAt = strPayableAt;
	}
	public String getStrChequeValidity() {
		return strChequeValidity;
	}
	public void setStrChequeValidity(String strChequeValidity) {
		this.strChequeValidity = strChequeValidity;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public WebRowSet getStrEmdAmountTypeWs() {
		return strEmdAmountTypeWs;
	}
	public void setStrEmdAmountTypeWs(WebRowSet strEmdAmountTypeWs) {
		this.strEmdAmountTypeWs = strEmdAmountTypeWs;
	}
	public WebRowSet getStrSupplierWs() {
		return strSupplierWs;
	}
	public void setStrSupplierWs(WebRowSet strSupplierWs) {
		this.strSupplierWs = strSupplierWs;
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
	public String getStrFinancialStartYear() {
		return strFinancialStartYear;
	}
	public void setStrFinancialStartYear(String strFinancialStartYear) {
		this.strFinancialStartYear = strFinancialStartYear;
	}
	public String getStrFinancialEndYear() {
		return strFinancialEndYear;
	}
	public void setStrFinancialEndYear(String strFinancialEndYear) {
		this.strFinancialEndYear = strFinancialEndYear;
	}
	
}
