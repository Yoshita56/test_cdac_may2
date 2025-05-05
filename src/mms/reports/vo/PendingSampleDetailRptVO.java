package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

public class PendingSampleDetailRptVO {
	
	private static final long serialVersionUID = 1L;
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strIsFooter = "";
	private String strUserRemarks = "";
	private String strReportFormat = "0";
	private String strReportId = "";
	
	private String strMsgString = "";
	private String strMsgType = "";
	
	private String strItemCategoryNo = "";
	private String strGroupId = "";
	private String strSubGroupId = "";
	private String strItemId = "";
	private String strItemBrandName="";
	
	
	private String strLabId;
	private String strLabNameCombo;
	private String strLabSendNo;
	private String strLabName;
	private String strLabCode;
	
	private WebRowSet wsLabNameCombo = null;

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

	public String getStrIsFooter() {
		return strIsFooter;
	}

	public void setStrIsFooter(String strIsFooter) {
		this.strIsFooter = strIsFooter;
	}

	public String getStrUserRemarks() {
		return strUserRemarks;
	}

	public void setStrUserRemarks(String strUserRemarks) {
		this.strUserRemarks = strUserRemarks;
	}

	public String getStrReportFormat() {
		return strReportFormat;
	}

	public void setStrReportFormat(String strReportFormat) {
		this.strReportFormat = strReportFormat;
	}

	public String getStrReportId() {
		return strReportId;
	}

	public void setStrReportId(String strReportId) {
		this.strReportId = strReportId;
	}

	public String getStrMsgString() {
		return strMsgString;
	}

	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	public String getStrMsgType() {
		return strMsgType;
	}

	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}

	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}

	public String getStrGroupId() {
		return strGroupId;
	}

	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	public String getStrSubGroupId() {
		return strSubGroupId;
	}

	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}

	public String getStrItemId() {
		return strItemId;
	}

	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	public String getStrItemBrandName() {
		return strItemBrandName;
	}

	public void setStrItemBrandName(String strItemBrandName) {
		this.strItemBrandName = strItemBrandName;
	}

	public String getStrLabId() {
		return strLabId;
	}

	public void setStrLabId(String strLabId) {
		this.strLabId = strLabId;
	}

	public String getStrLabNameCombo() {
		return strLabNameCombo;
	}

	public void setStrLabNameCombo(String strLabNameCombo) {
		this.strLabNameCombo = strLabNameCombo;
	}

	public String getStrLabSendNo() {
		return strLabSendNo;
	}

	public void setStrLabSendNo(String strLabSendNo) {
		this.strLabSendNo = strLabSendNo;
	}

	public String getStrLabName() {
		return strLabName;
	}

	public void setStrLabName(String strLabName) {
		this.strLabName = strLabName;
	}

	public String getStrLabCode() {
		return strLabCode;
	}

	public void setStrLabCode(String strLabCode) {
		this.strLabCode = strLabCode;
	}

	public WebRowSet getWsLabNameCombo() {
		return wsLabNameCombo;
	}

	public void setWsLabNameCombo(WebRowSet wsLabNameCombo) {
		this.wsLabNameCombo = wsLabNameCombo;
	}
	
	
}
