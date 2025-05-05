package mms.transactions.vo;


import javax.sql.rowset.WebRowSet;

public class ThirdPartyIssueSancTransVO {
	
	private static final long serialVersionUID = 1L;
	private String strMsgString = "";
	private String strMsgType = "";
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strFinancialStartYear = "";
	private String strFinancialEndYear = "";
	private String strReqDate = "";
	private String strChk = "";
	private String strReqNo = "0";
	private String strCurrentDate = "";
	private String strStoreId = "";
	private String strStoreTypeId = "";
	private String strGroupIdForItemSearch = "";
	private String strGroupValues = "";
	private String strGroupName = "";
	private String strInstituteCode = "";
	private String strReceiveBy = "";
	private String strInstituteValues ="";
	private String strItemCatNo = "";
	private String strItemCatValues = "";
	private String strItemUnitId = "";
	private String strStoreName = "";
	private String strItemsSancId = "";
	private String combo = "";
	private String strRemarks = "";
	private String strReqNum = "";
	private String strManufacturerId = "";
	private String[] strQty = null;
	private String[] strIssuedQty = null;
	private String[] strUnitName = null;
	
	private String[] itemParamValue = {""}; //hidden field
	
	private WebRowSet strInstituteWs = null;
	private WebRowSet strItemCatWs = null;
	private WebRowSet strItemDetailsWS = null;
	private WebRowSet strGroupWs = null;
	private WebRowSet unitNameWS = null;
		
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
	public String getStrReqDate() {
		return strReqDate;
	}
	public String getStrChk() {
		return strChk;
	}
	public void setStrReqDate(String strReqDate) {
		this.strReqDate = strReqDate;
	}
	public void setStrChk(String strChk) {
		this.strChk = strChk;
	}
	public String getStrReqNo() {
		return strReqNo;
	}
	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
	}
	public WebRowSet getUnitNameWS() {
		return unitNameWS;
	}
	public void setUnitNameWS(WebRowSet unitNameWS) {
		this.unitNameWS = unitNameWS;
	}
	public String getStrItemUnitId() {
		return strItemUnitId;
	}
	public void setStrItemUnitId(String strItemUnitId) {
		this.strItemUnitId = strItemUnitId;
	}
	public String getStrGroupName() {
		return strGroupName;
	}
	public void setStrGroupName(String strGroupName) {
		this.strGroupName = strGroupName;
	}
	public String getStrItemsSancId() {
		return strItemsSancId;
	}
	public void setStrItemsSancId(String strItemsSancId) {
		this.strItemsSancId = strItemsSancId;
	}

	public String[] getStrIssuedQty() {
		return strIssuedQty;
	}
	public void setStrIssuedQty(String[] strIssuedQty) {
		this.strIssuedQty = strIssuedQty;
	}
	public WebRowSet getStrItemDetailsWS() {
		return strItemDetailsWS;
	}
	public void setStrItemDetailsWS(WebRowSet strItemDetailsWS) {
		this.strItemDetailsWS = strItemDetailsWS;
	}
	public String getStrReceiveBy() {
		return strReceiveBy;
	}
	public void setStrReceiveBy(String strReceiveBy) {
		this.strReceiveBy = strReceiveBy;
	}
	
}
