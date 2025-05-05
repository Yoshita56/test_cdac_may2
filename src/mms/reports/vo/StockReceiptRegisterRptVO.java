package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

public class StockReceiptRegisterRptVO {
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strMsgType = "";
	private String strMsgString = "";
	
	private String strStoreId = "";
	private String strItemCatId = "";
	private String strMode;
	
	private WebRowSet strItemCatWs = null;
	private WebRowSet strStoreWs = null;
	private WebRowSet StrUserlevelWs = null;
	private WebRowSet strItemWs = null;
	private WebRowSet strSuppWs = null;
	
	
	public WebRowSet getStrItemWs() {
		return strItemWs;
	}
	public void setStrItemWs(WebRowSet strItemWs) {
		this.strItemWs = strItemWs;
	}
	public WebRowSet getStrSuppWs() {
		return strSuppWs;
	}
	public void setStrSuppWs(WebRowSet strSuppWs) {
		this.strSuppWs = strSuppWs;
	}
	public WebRowSet getStrUserlevelWs() {
		return StrUserlevelWs;
	}
	public void setStrUserlevelWs(WebRowSet strUserlevelWs) {
		StrUserlevelWs = strUserlevelWs;
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
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrItemCatId() {
		return strItemCatId;
	}
	public void setStrItemCatId(String strItemCatId) {
		this.strItemCatId = strItemCatId;
	}
	public WebRowSet getStrItemCatWs() {
		return strItemCatWs;
	}
	public void setStrItemCatWs(WebRowSet strItemCatWs) {
		this.strItemCatWs = strItemCatWs;
	}
	public WebRowSet getStrStoreWs() {
		return strStoreWs;
	}
	public void setStrStoreWs(WebRowSet strStoreWs) {
		this.strStoreWs = strStoreWs;
	}
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}

}
