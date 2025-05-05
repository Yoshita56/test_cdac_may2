package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;

public class EMDReceivingDtlTransFB extends ActionForm{

	private static final long serialVersionUID = 02L;
	
	
	private String strErrMsg = "";
	private String strWarningMsg = "";
	private String strNormalMsg = "";
	
	
	private String strCtDate = null;
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strIsValid = "";
	
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

	
	
	public String getStrIsValid() {
		return strIsValid;
	}
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
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
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrCtDate() {
		
		
/*
		HisUtil util = new HisUtil("EMD Receiving Detail","EMDReceivingDtlTransFB");

			try {
					strCtDate = util.getASDate("dd-MMM-yyyy");

			} catch (Exception e) {

				new HisException("EMD Receiving Detail",
						"EMDReceivingDtlTransFB.getStrCtDate()", e.getMessage());
				} finally {
					util = null;
				}*/
		
				return strCtDate;
	}
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}
	public String getStrChequeValidity() {
		return strChequeValidity;
	}
	public void setStrChequeValidity(String strChequeValidity) {
		this.strChequeValidity = strChequeValidity;
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
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	
	
}
