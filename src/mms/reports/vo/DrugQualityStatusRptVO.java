package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

public class DrugQualityStatusRptVO 
{
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
	
	private WebRowSet itemCategoryWS = null;
	private WebRowSet groupIdWS = null;
	private WebRowSet subGroupIdWS = null;
	private WebRowSet itemIdWS = null;
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
	public WebRowSet getItemCategoryWS() {
		return itemCategoryWS;
	}
	public void setItemCategoryWS(WebRowSet itemCategoryWS) {
		this.itemCategoryWS = itemCategoryWS;
	}
	public WebRowSet getGroupIdWS() {
		return groupIdWS;
	}
	public void setGroupIdWS(WebRowSet groupIdWS) {
		this.groupIdWS = groupIdWS;
	}
	public WebRowSet getSubGroupIdWS() {
		return subGroupIdWS;
	}
	public void setSubGroupIdWS(WebRowSet subGroupIdWS) {
		this.subGroupIdWS = subGroupIdWS;
	}
	public WebRowSet getItemIdWS() {
		return itemIdWS;
	}
	public void setItemIdWS(WebRowSet itemIdWS) {
		this.itemIdWS = itemIdWS;
	}

}
