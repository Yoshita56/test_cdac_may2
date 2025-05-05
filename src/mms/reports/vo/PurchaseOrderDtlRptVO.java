package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

public class PurchaseOrderDtlRptVO {
	
	private String strMode;
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strStoreId = "";
	private String strItemCatNo = "";
	private String strReqFor = "";
	
	private String strMsgType = "";
	private String strMsgString = "";
	
	private WebRowSet strStoreWs = null;
	private WebRowSet strItemCatWs = null;
	private WebRowSet strPOTypeWs = null;
	private WebRowSet strSupplierWs = null;
	private WebRowSet strHospitalWs=null;
	
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
	public WebRowSet getStrStoreWs() {
		return strStoreWs;
	}
	public void setStrStoreWs(WebRowSet strStoreWs) {
		this.strStoreWs = strStoreWs;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public WebRowSet getStrItemCatWs() {
		return strItemCatWs;
	}
	public void setStrItemCatWs(WebRowSet strItemCatWs) {
		this.strItemCatWs = strItemCatWs;
	}
	public String getStrItemCatNo() {
		return strItemCatNo;
	}
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}
	public WebRowSet getStrPOTypeWs() {
		return strPOTypeWs;
	}
	public void setStrPOTypeWs(WebRowSet strPOTypeWs) {
		this.strPOTypeWs = strPOTypeWs;
	}
	public WebRowSet getStrSupplierWs() {
		return strSupplierWs;
	}
	public void setStrSupplierWs(WebRowSet strSupplierWs) {
		this.strSupplierWs = strSupplierWs;
	}
	public String getStrReqFor() {
		return strReqFor;
	}
	public void setStrReqFor(String strReqFor) {
		this.strReqFor = strReqFor;
	}
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
	public WebRowSet getStrHospitalWs() {
		return strHospitalWs;
	}
	public void setStrHospitalWs(WebRowSet strHospitalWs) {
		this.strHospitalWs = strHospitalWs;
	}
}
