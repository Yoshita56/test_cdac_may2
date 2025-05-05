package mms.transactions.vo;


import javax.sql.rowset.WebRowSet;

public class SupplierReturnSancTransVO {
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
	private WebRowSet strItemDetailsWS = null;
	private String strStoreTypeId = "";
	private String strGroupIdForItemSearch = "";
	private String strGroupValues = "";
	private String strInstituteCode = "";
	private String strInstituteValues ="";
	private String strItemCatNo = "";
	private String strItemCategoryNoH = "";
	private String strItemCategoryNameH = "";
	private String strItemCatValues = "";
	private String strStoreName = "";
	private String combo = "";
	private String strOnlineFlag = "0";
	private String strReturnFlag = "1";
	private String[] strReturnCost = {""};
	private String strTotalReturnCost = "0";
	private String strRemarks = "";
	private String strGroupName = "";
	private String strScheduleNo = "1";
	private String strReturnReason = "";
	private String strPONo = "";
	private String strPODate = "";
	private String strPOType = "";
	private String strPOTypeId = "";
	private String strSupplierId = "";
	private String strSupplierName = "";
	private String strPOStoreId = "";
	private String strPOStoreName = "";
	private String strSearchListPODtlFromDate = "";
	private String strSearchListPODtlToDate = "";
	private String strDeliveryDate = "";
	private String strReturnType = "1";
	private String strReqNum = "";
	private String strManufacturerId = "";
	private String[] strReturnQty = null;
	private String[] strUnitName = null;
	private String strReqNo = "";
	private String strReqStatus = "";
	private String[] itemParamValue = {""};
	private String[] itemUserValue = {""};
	private String[] itemCalcValue = {""};
	
	private WebRowSet strInstituteWs = null;
	private WebRowSet strItemCatWs = null;
	private WebRowSet strGroupWs = null;
	private WebRowSet strPODetailsWs = null;
		
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
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getStrReturnReason() {
		return strReturnReason;
	}
	public String getStrPODate() {
		return strPODate;
	}
	public String getStrPOType() {
		return strPOType;
	}
	public String getStrSupplierId() {
		return strSupplierId;
	}
	public String getStrSupplierName() {
		return strSupplierName;
	}
	public String getStrPOStoreId() {
		return strPOStoreId;
	}
	
	public String getStrDeliveryDate() {
		return strDeliveryDate;
	}
	public String getStrReturnType() {
		return strReturnType;
	}
	public void setStrReturnReason(String strReturnReason) {
		this.strReturnReason = strReturnReason;
	}
	public void setStrPODate(String strPODate) {
		this.strPODate = strPODate;
	}
	public void setStrPOType(String strPOType) {
		this.strPOType = strPOType;
	}
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}
	public void setStrSupplierName(String strSupplierName) {
		this.strSupplierName = strSupplierName;
	}
	public void setStrPOStoreId(String strPOStoreId) {
		this.strPOStoreId = strPOStoreId;
	}
	
	public void setStrDeliveryDate(String strDeliveryDate) {
		this.strDeliveryDate = strDeliveryDate;
	}
	public void setStrReturnType(String strReturnType) {
		this.strReturnType = strReturnType;
	}
	public String getStrPOStoreName() {
		return strPOStoreName;
	}
	public void setStrPOStoreName(String strPOStoreName) {
		this.strPOStoreName = strPOStoreName;
	}
	public WebRowSet getStrPODetailsWs() {
		return strPODetailsWs;
	}
	public void setStrPODetailsWs(WebRowSet strPODetailsWs) {
		this.strPODetailsWs = strPODetailsWs;
	}
	
	public String getStrSearchListPODtlFromDate() {
		return strSearchListPODtlFromDate;
	}
	public String getStrSearchListPODtlToDate() {
		return strSearchListPODtlToDate;
	}
	public void setStrSearchListPODtlFromDate(String strSearchListPODtlFromDate) {
		this.strSearchListPODtlFromDate = strSearchListPODtlFromDate;
	}
	public void setStrSearchListPODtlToDate(String strSearchListPODtlToDate) {
		this.strSearchListPODtlToDate = strSearchListPODtlToDate;
	}
	public String getStrPONo() {
		return strPONo;
	}
	public void setStrPONo(String strPONo) {
		this.strPONo = strPONo;
	}
	
	public String getStrPOTypeId() {
		return strPOTypeId;
	}
	public void setStrPOTypeId(String strPOTypeId) {
		this.strPOTypeId = strPOTypeId;
	}
	public String getStrItemCategoryNoH() {
		return strItemCategoryNoH;
	}
	public String getStrItemCategoryNameH() {
		return strItemCategoryNameH;
	}
	public void setStrItemCategoryNoH(String strItemCategoryNoH) {
		this.strItemCategoryNoH = strItemCategoryNoH;
	}
	public void setStrItemCategoryNameH(String strItemCategoryNameH) {
		this.strItemCategoryNameH = strItemCategoryNameH;
	}
	public String[] getStrReturnQty() {
		return strReturnQty;
	}
	public void setStrReturnQty(String[] strReturnQty) {
		this.strReturnQty = strReturnQty;
	}
	public String getStrOnlineFlag() {
		return strOnlineFlag;
	}
	
	public String getStrTotalReturnCost() {
		return strTotalReturnCost;
	}
	public void setStrOnlineFlag(String strOnlineFlag) {
		this.strOnlineFlag = strOnlineFlag;
	}
	
	public void setStrTotalReturnCost(String strTotalReturnCost) {
		this.strTotalReturnCost = strTotalReturnCost;
	}
	public String[] getStrReturnCost() {
		return strReturnCost;
	}
	public void setStrReturnCost(String[] strReturnCost) {
		this.strReturnCost = strReturnCost;
	}
	public WebRowSet getStrItemDetailsWS() {
		return strItemDetailsWS;
	}
	public void setStrItemDetailsWS(WebRowSet strItemDetailsWS) {
		this.strItemDetailsWS = strItemDetailsWS;
	}
	public String getStrScheduleNo() {
		return strScheduleNo;
	}
	public void setStrScheduleNo(String strScheduleNo) {
		this.strScheduleNo = strScheduleNo;
	}
	public String getStrReturnFlag() {
		return strReturnFlag;
	}
	public void setStrReturnFlag(String strReturnFlag) {
		this.strReturnFlag = strReturnFlag;
	}
	
	
	
}
