package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

public class PurchaseItemInventoryRptVO {
	
	private String strMode;
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strStoreId = "";
	private String strItemCatNo = "";
	private String strReqFor = "";
	
	private String strMsgType = "";
	private String strMsgString = "";
	
	private String strPOTypeId = "";
	private String strSupplierId = "";
	
	private String strPONo = "";
	
	
	
	private String strFromDate="";
	private String strToDate="";	
	private String strItemBrandId;
	private String strSupplierName;
	private String strItemName;
	private String strPoTypeName;
	private String strPoStatusName;
	
	private String strSePOTypeId;
	
	
	
	public String getStrSePOTypeId() {
		return strSePOTypeId;
	}
	public void setStrSePOTypeId(String strSePOTypeId) {
		this.strSePOTypeId = strSePOTypeId;
	}

public String getStrSupplierName() {
	return strSupplierName;
}
public void setStrSupplierName(String strSupplierName) {
	this.strSupplierName = strSupplierName;
}
public String getStrItemName() {
	return strItemName;
}
public void setStrItemName(String strItemName) {
	this.strItemName = strItemName;
}
public String getStrPoTypeName() {
	return strPoTypeName;
}
public void setStrPoTypeName(String strPoTypeName) {
	this.strPoTypeName = strPoTypeName;
}
public String getStrPoStatusName() {
	return strPoStatusName;
}
public void setStrPoStatusName(String strPoStatusName) {
	this.strPoStatusName = strPoStatusName;
}

		
	
	public String getStrItemBrandId() {
		return strItemBrandId;
	}
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}
		
	public String getStrPOTypeId() {
		return strPOTypeId;
	}
	public void setStrPOTypeId(String strPOTypeId) {
		this.strPOTypeId = strPOTypeId;
	}
	public String getStrSupplierId() {
		return strSupplierId;
	}
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}
	public String getStrPONo() {
		return strPONo;
	}
	public void setStrPONo(String strPONo) {
		this.strPONo = strPONo;
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
	public String getStrPoStatus() {
		return strPoStatus;
	}
	public void setStrPoStatus(String strPoStatus) {
		this.strPoStatus = strPoStatus;
	}
	public String getStrPOType() {
		return strPOType;
	}
	public void setStrPOType(String strPOType) {
		this.strPOType = strPOType;
	}
	private String strPoStatus;

	private String strPOType;
	
	private WebRowSet strStoreWs = null;
	private WebRowSet strItemCatWs = null;
	private WebRowSet strPOTypeWs = null;
	private WebRowSet strSupplierWs = null;
	private WebRowSet strItemNameWs=null;
	private WebRowSet reportDtlWs=null;
	
	public WebRowSet getReportDtlWs() {
		return reportDtlWs;
	}
	public void setReportDtlWs(WebRowSet reportDtlWs) {
		this.reportDtlWs = reportDtlWs;
	}
	public WebRowSet getStrItemNameWs() {
		return strItemNameWs;
	}
	public void setStrItemNameWs(WebRowSet strItemNameWs) {
		this.strItemNameWs = strItemNameWs;
	}
	private String strCatgId = "";
	
	public String getStrCatgId() {
		return strCatgId;
	}
	public void setStrCatgId(String strCatgId) {
		this.strCatgId = strCatgId;
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
	
}
