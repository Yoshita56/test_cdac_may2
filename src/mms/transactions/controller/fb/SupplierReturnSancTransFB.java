package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;

public class SupplierReturnSancTransFB extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 02L;
	private String strErrMsg = "";
	private String strNormalMsg = "";
	private String strWarningMsg = "";
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strStoreTypeId = "";
	private String strCurrentDate = "";
	private String strReqDate ="";
	private String strChk ="";
	private String strStoreId = "";
	private String strInstituteCode = "";
	private String strInstituteValues ="";
	private String strItemCatNo = "";
	private String strItemCategoryNoH = "";
	private String strItemCategoryNameH = "";
	private String strItemCatValues = "";
	private String strGroupIdForItemSearch = "";
	private String strGroupValues = "";
	private String strStoreName = "";
	private String strReturnReason = "";
	private String strPONo = "";
	private String strPODate = "";
	private String strPOType = "";
	private String strPOTypeId = "";
	private String strSupplierId = "";
	private String strScheduleNo = "1";
	private String strSupplierName = "";
	private String strPOStoreId = "";
	private String strPOStoreName = "";
	private String strSearchListPODtlFromDate = "";
	private String strSearchListPODtlToDate = "";
	private String strSearchListPODetails = "";
	private String strDeliveryDate = "";
	private String strReturnType = "1";
	private String strReturnTypeName = "";
	private String strOnlineFlag = "0";
	private String strReturnFlag = "1";
	private String[] strReturnCost = {""};
	private String strTotalReturnCost = "0";
	private String strRemarks = "";
	private String[] itemParamValue = {""};
	private String[] itemUserValue = {""};
	private String[] itemCalcValue = {""};
	private String[] strReturnQty = null;
	private String[] strUnitName = null;
	private String strReqNo = "";
	private String strReqStatus = "";
	private String strItemDtls = "";
	private String strGroupName = "";
	private String strReqDateView = "";
	private String strIssueDate = "";
	private String strIssueDateView = "";
	private String strSancDate = "";
	private String strSancDateView = "";
	
	public String getStrErrMsg() {
		return strErrMsg;
	}
	public String getStrNormalMsg() {
		return strNormalMsg;
	}
	public String getStrWarningMsg() {
		return strWarningMsg;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	
	public String getStrStoreId() {
		return strStoreId;
	}
	public String getStrInstituteCode() {
		return strInstituteCode;
	}
	public String getStrInstituteValues() {
		return strInstituteValues;
	}
	public String getStrItemCatNo() {
		return strItemCatNo;
	}
	public String getStrItemCatValues() {
		return strItemCatValues;
	}
	public String getStrGroupIdForItemSearch() {
		return strGroupIdForItemSearch;
	}
	public String getStrGroupValues() {
		return strGroupValues;
	}
	public String getStrStoreName() {
		return strStoreName;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public String[] getItemParamValue() {
		return itemParamValue;
	}
	public String[] getItemUserValue() {
		return itemUserValue;
	}
	public String[] getItemCalcValue() {
		return itemCalcValue;
	}
	
	public String[] getStrUnitName() {
		return strUnitName;
	}
	public String getStrReqNo() {
		return strReqNo;
	}
	public String getStrReqStatus() {
		return strReqStatus;
	}
	public String getStrItemDtls() {
		return strItemDtls;
	}
	public String getStrGroupName() {
		return strGroupName;
	}
	public String getStrReqDateView() {
		return strReqDateView;
	}
	public String getStrIssueDate() {
		return strIssueDate;
	}
	public String getStrIssueDateView() {
		return strIssueDateView;
	}
	public String getStrSancDate() {
		return strSancDate;
	}
	public String getStrSancDateView() {
		return strSancDateView;
	}
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}

	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public void setStrInstituteCode(String strInstituteCode) {
		this.strInstituteCode = strInstituteCode;
	}
	public void setStrInstituteValues(String strInstituteValues) {
		this.strInstituteValues = strInstituteValues;
	}
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}
	public void setStrItemCatValues(String strItemCatValues) {
		this.strItemCatValues = strItemCatValues;
	}
	public void setStrGroupIdForItemSearch(String strGroupIdForItemSearch) {
		this.strGroupIdForItemSearch = strGroupIdForItemSearch;
	}
	public void setStrGroupValues(String strGroupValues) {
		this.strGroupValues = strGroupValues;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
	}
	public void setItemUserValue(String[] itemUserValue) {
		this.itemUserValue = itemUserValue;
	}
	public void setItemCalcValue(String[] itemCalcValue) {
		this.itemCalcValue = itemCalcValue;
	}
	
	public void setStrUnitName(String[] strUnitName) {
		this.strUnitName = strUnitName;
	}
	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
	}
	public void setStrReqStatus(String strReqStatus) {
		this.strReqStatus = strReqStatus;
	}
	public void setStrItemDtls(String strItemDtls) {
		this.strItemDtls = strItemDtls;
	}
	public void setStrGroupName(String strGroupName) {
		this.strGroupName = strGroupName;
	}
	public void setStrReqDateView(String strReqDateView) {
		this.strReqDateView = strReqDateView;
	}
	public void setStrIssueDate(String strIssueDate) {
		this.strIssueDate = strIssueDate;
	}
	public void setStrIssueDateView(String strIssueDateView) {
		this.strIssueDateView = strIssueDateView;
	}
	public void setStrSancDate(String strSancDate) {
		this.strSancDate = strSancDate;
	}
	public void setStrSancDateView(String strSancDateView) {
		this.strSancDateView = strSancDateView;
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
	public String getStrSearchListPODetails() {
		return strSearchListPODetails;
	}
	public void setStrSearchListPODetails(String strSearchListPODetails) {
		this.strSearchListPODetails = strSearchListPODetails;
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
	public String getStrPOTypeId() {
		return strPOTypeId;
	}
	public void setStrPOTypeId(String strPOTypeId) {
		this.strPOTypeId = strPOTypeId;
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
	public void setStrReturnCost(String[] strReturnCost) {
		this.strReturnCost = strReturnCost;
	}
	public String[] getStrReturnCost() {
		return strReturnCost;
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
	public String getStrReturnFlag() {
		return strReturnFlag;
	}
	public void setStrReturnFlag(String strReturnFlag) {
		this.strReturnFlag = strReturnFlag;
	}
	public String getStrReturnTypeName() {
		return strReturnTypeName;
	}
	public void setStrReturnTypeName(String strReturnTypeName) {
		this.strReturnTypeName = strReturnTypeName;
	}
	public String getStrScheduleNo() {
		return strScheduleNo;
	}
	public void setStrScheduleNo(String strScheduleNo) {
		this.strScheduleNo = strScheduleNo;
	}
	
}
