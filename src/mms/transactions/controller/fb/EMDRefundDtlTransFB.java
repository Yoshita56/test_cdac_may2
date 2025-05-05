package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;

public class EMDRefundDtlTransFB extends ActionForm {

private static final long serialVersionUID = 02L;
	
	
	private String strErrMsg = "";
	private String strWarningMsg = "";
	private String strNormalMsg = "";
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strIsValid = "";
	private String strSupplierId = "";
	private String strSupplierCombo = "";
	private String[] strChkValue = null;
	private String[] strRemarks = null;
	private String strEMDDetail="";
	
	public String getStrSupplierId() {
		return strSupplierId;
	}
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}
	public String getStrSupplierCombo() {
		return strSupplierCombo;
	}
	public void setStrSupplierCombo(String strSupplierCombo) {
		this.strSupplierCombo = strSupplierCombo;
	}
	
	
	public String[] getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String[] strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrErrMsg() {
		return strErrMsg;
	}
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}
	public String getStrWarningMsg() {
		return strWarningMsg;
	}
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}
	public String getStrNormalMsg() {
		return strNormalMsg;
	}
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getStrIsValid() {
		return strIsValid;
	}
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}
	public String getStrEMDDetail() {
		return strEMDDetail;
	}
	public void setStrEMDDetail(String strEMDDetail) {
		this.strEMDDetail = strEMDDetail;
	}
	
	public String[] getStrChkValue() {
		return strChkValue;
	}
	public void setStrChkValue(String[] strChkValue) {
		this.strChkValue = strChkValue;
	}
	
}
