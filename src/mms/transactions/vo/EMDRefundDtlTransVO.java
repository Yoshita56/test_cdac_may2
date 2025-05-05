package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

public class EMDRefundDtlTransVO {

	private static final long serialVersionUID = 02L;
	
	private String strMsgType = "";
	private String strMsgString = "";
	private String strSeatId = "";
	private String strHospitalCode = "";
	private String strSupplierCombo = "";
	private String[] strChkValue = null;
	private String[] strRemarks = null;
	private String strSupplierId = "";
		
	private WebRowSet strSupplierWs = null;
	private WebRowSet strEMDDetailsWs = null;
	
	public WebRowSet getStrSupplierWs() {
		return strSupplierWs;
	}
	public void setStrSupplierWs(WebRowSet strSupplierWs) {
		this.strSupplierWs = strSupplierWs;
	}
	public String getStrSupplierId() {
		return strSupplierId;
	}
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
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
	
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
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
	public WebRowSet getStrEMDDetailsWs() {
		return strEMDDetailsWs;
	}
	public void setStrEMDDetailsWs(WebRowSet strEMDDetailsWs) {
		this.strEMDDetailsWs = strEMDDetailsWs;
	}
	
	public String[] getStrChkValue() {
		return strChkValue;
	}
	public void setStrChkValue(String[] strChkValue) {
		this.strChkValue = strChkValue;
	}

}
