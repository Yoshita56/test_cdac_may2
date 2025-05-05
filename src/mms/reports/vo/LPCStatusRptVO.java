package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.TransferObject;

public class LPCStatusRptVO implements TransferObject {
	private static final long serialVersionUID = 02L;
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strCategoryId = "";
	private String strCategoryName = "";
	private String StrUserName = "";
	private String strMsgType = "";
	private String strMsgString = "";
	private String strLogoName = "";
	private WebRowSet wsViewDtl = null;
	
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
	public String getStrCategoryId() {
		return strCategoryId;
	}
	public void setStrCategoryId(String strCategoryId) {
		this.strCategoryId = strCategoryId;
	}
	public String getStrCategoryName() {
		return strCategoryName;
	}
	public void setStrCategoryName(String strCategoryName) {
		this.strCategoryName = strCategoryName;
	}
	public String getStrUserName() {
		return StrUserName;
	}
	public void setStrUserName(String strUserName) {
		StrUserName = strUserName;
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
	public String getStrLogoName() {
		return strLogoName;
	}
	public void setStrLogoName(String strLogoName) {
		this.strLogoName = strLogoName;
	}
	public WebRowSet getWsViewDtl() {
		return wsViewDtl;
	}
	public void setWsViewDtl(WebRowSet wsViewDtl) {
		this.wsViewDtl = wsViewDtl;
	}
	
	
}
