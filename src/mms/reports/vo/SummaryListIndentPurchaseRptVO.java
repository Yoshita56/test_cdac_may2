package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

public class SummaryListIndentPurchaseRptVO {
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strMsgType = "";
	private String strMsgString = "";
		
	private WebRowSet strItemCatWs = null;
	private WebRowSet strPurchaseTypeWs = null;
	private WebRowSet strHospitalnameWs = null;
	
	public WebRowSet getStrHospitalnameWs() {
		return strHospitalnameWs;
	}

	public void setStrHospitalnameWs(WebRowSet strHospitalnameWs) {
		this.strHospitalnameWs = strHospitalnameWs;
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

	public WebRowSet getStrItemCatWs() {
		return strItemCatWs;
	}

	public void setStrItemCatWs(WebRowSet strItemCatWs) {
		this.strItemCatWs = strItemCatWs;
	}

	public WebRowSet getStrPurchaseTypeWs() {
		return strPurchaseTypeWs;
	}

	public void setStrPurchaseTypeWs(WebRowSet strPurchaseTypeWs) {
		this.strPurchaseTypeWs = strPurchaseTypeWs;
	}

}
