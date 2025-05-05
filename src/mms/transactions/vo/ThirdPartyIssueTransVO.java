package mms.transactions.vo;


import javax.sql.rowset.WebRowSet;

public class ThirdPartyIssueTransVO {
	
	private static final long serialVersionUID = 1L;
	private String strMsgString = "";
	private String strMsgType = "";
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strFinancialStartYear = "";
	private String strFinancialEndYear = "";
	private String[] strReqDate = {""};
	private String strCurrentDate = "";
	private String strStoreId = "";
	private String strStoreTypeId = "";
	private String strGroupIdForItemSearch = "";
	private String strGroupValues = "";
	private String strInstituteCode = "";
	private String strInstituteValues ="";
	private String strItemCatNo = "";
	private String strItemCatValues = "";
	private String strStoreName = "";
	private String combo = "";
	private String strRemarks = "";
	private String strGroupName = "";
	private String strReqNum = "";
	private String strManufacturerId = "";
	private String[] strQty = null;
	private String[] strUnitName = null;
	private String strReqNo = "";
	private String strReqStatus = "";
	private String[] itemParamValue = {""};
	private String[] itemUserValue = {""};
	private String[] itemCalcValue = {""};
	
	private WebRowSet strInstituteWs = null;
	private WebRowSet strItemCatWs = null;
	private WebRowSet strGroupWs = null;
	
		
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
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrInstituteCode() {
		return strInstituteCode;
	}
	public void setStrInstituteCode(String strInstituteCode) {
		this.strInstituteCode = strInstituteCode;
	}
	public String getStrInstituteValues() {
		return strInstituteValues;
	}
	public void setStrInstituteValues(String strInstituteValues) {
		this.strInstituteValues = strInstituteValues;
	}
	public String getStrItemCatNo() {
		return strItemCatNo;
	}
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}
	public String getStrItemCatValues() {
		return strItemCatValues;
	}
	public void setStrItemCatValues(String strItemCatValues) {
		this.strItemCatValues = strItemCatValues;
	}
	public WebRowSet getStrInstituteWs() {
		return strInstituteWs;
	}
	public void setStrInstituteWs(WebRowSet strInstituteWs) {
		this.strInstituteWs = strInstituteWs;
	}
	public WebRowSet getStrItemCatWs() {
		return strItemCatWs;
	}
	public void setStrItemCatWs(WebRowSet strItemCatWs) {
		this.strItemCatWs = strItemCatWs;
	}
	public String getStrGroupValues() {
		return strGroupValues;
	}
	public void setStrGroupValues(String strGroupValues) {
		this.strGroupValues = strGroupValues;
	}
	public WebRowSet getStrGroupWs() {
		return strGroupWs;
	}
	public void setStrGroupWs(WebRowSet strGroupWs) {
		this.strGroupWs = strGroupWs;
	}
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String getCombo() {
		return combo;
	}
	public void setCombo(String combo) {
		this.combo = combo;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrGroupIdForItemSearch() {
		return strGroupIdForItemSearch;
	}
	public void setStrGroupIdForItemSearch(String strGroupIdForItemSearch) {
		this.strGroupIdForItemSearch = strGroupIdForItemSearch;
	}
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}
	public String[] getStrQty() {
		return strQty;
	}
	public void setStrQty(String[] strQty) {
		this.strQty = strQty;
	}
	public String[] getStrUnitName() {
		return strUnitName;
	}
	public void setStrUnitName(String[] strUnitName) {
		this.strUnitName = strUnitName;
	}
	public String[] getItemParamValue() {
		return itemParamValue;
	}
	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
	}
	public String getStrFinancialStartYear() {
		return strFinancialStartYear;
	}
	public void setStrFinancialStartYear(String strFinancialStartYear) {
		this.strFinancialStartYear = strFinancialStartYear;
	}
	public String getStrFinancialEndYear() {
		return strFinancialEndYear;
	}
	public void setStrFinancialEndYear(String strFinancialEndYear) {
		this.strFinancialEndYear = strFinancialEndYear;
	}
	public String[] getStrReqDate() {
		return strReqDate;
	}
	public void setStrReqDate(String[] strReqDate) {
		this.strReqDate = strReqDate;
	}
	public String getStrReqNum() {
		return strReqNum;
	}
	public void setStrReqNum(String strReqNum) {
		this.strReqNum = strReqNum;
	}
	public String getStrManufacturerId() {
		return strManufacturerId;
	}
	public void setStrManufacturerId(String strManufacturerId) {
		this.strManufacturerId = strManufacturerId;
	}
	public String getStrReqNo() {
		return strReqNo;
	}
	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
	}
	public String getStrGroupName() {
		return strGroupName;
	}
	public void setStrGroupName(String strGroupName) {
		this.strGroupName = strGroupName;
	}
	public String getStrReqStatus() {
		return strReqStatus;
	}
	public void setStrReqStatus(String strReqStatus) {
		this.strReqStatus = strReqStatus;
	}
	public String[] getItemUserValue() {
		return itemUserValue;
	}
	public void setItemUserValue(String[] itemUserValue) {
		this.itemUserValue = itemUserValue;
	}
	public String[] getItemCalcValue() {
		return itemCalcValue;
	}
	public void setItemCalcValue(String[] itemCalcValue) {
		this.itemCalcValue = itemCalcValue;
	}
	
}
