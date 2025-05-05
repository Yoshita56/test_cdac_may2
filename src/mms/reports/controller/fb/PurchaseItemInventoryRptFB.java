package mms.reports.controller.fb;

import org.apache.struts.action.ActionForm;

public class PurchaseItemInventoryRptFB extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String strErrMsg = "";
	private String strNormalMsg = "";
	private String strWarningMsg = "";
	
	private String strCurrentDate = "";
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strStoreId = "";
	private String strStoreName = "";
	private String strItemCatNo = "";
	private String strPOTypeId = "";
	private String strSupplierId = "";
	private String strOrderStatus = "";
	private String strReportFormat = "";
	private String strIsFooter = "";
	private String strStoreValues = "";
	private String strPONo = "";
	private String strCase = "1";
	
	private String strItemCombo="";
	
	private String strFromDate="";
	private String strToDate="";
	
	private String strReportId = "";
	private String strUserRemarks = "";
	private String strWhetherItemShown;
	
	private String strPoStatus;
	private String strSupplierCmb;
	private String strHospNameValues="";
	private String strPOType;
	private String strItemBrandId;
	private String printReportDetails;
	
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
	public String getStrItemCombo() {
		return strItemCombo;
	}
	public void setStrItemCombo(String strItemCombo) {
		this.strItemCombo = strItemCombo;
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
	
		
	
	public String getPrintReportDetails() {
		return printReportDetails;
	}
	public void setPrintReportDetails(String printReportDetails) {
		this.printReportDetails = printReportDetails;
	}
	public String getStrItemBrandId() {
		return strItemBrandId;
	}
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}
	public String getStrPOType() {
		return strPOType;
	}
	public void setStrPOType(String strPOType) {
		this.strPOType = strPOType;
	}
	public String getStrSupplierCmb() {
		return strSupplierCmb;
	}
	public void setStrSupplierCmb(String strSupplierCmb) {
		this.strSupplierCmb = strSupplierCmb;
	}
	public String getStrPoStatus() {
		return strPoStatus;
	}
	public void setStrPoStatus(String strPoStatus) {
		this.strPoStatus = strPoStatus;
	}
	public String getStrWhetherItemShown() {
		return strWhetherItemShown;
	}
	public void setStrWhetherItemShown(String strWhetherItemShown) {
		this.strWhetherItemShown = strWhetherItemShown;
	}
	public String getStrUserRemarks() {
		return strUserRemarks;
	}
	public void setStrUserRemarks(String strUserRemarks) {
		this.strUserRemarks = strUserRemarks;
	}
	public String getStrErrMsg() {
		return strErrMsg;
	}
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}
	public String getStrNormalMsg() {
		return strNormalMsg;
	}
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}
	public String getStrWarningMsg() {
		return strWarningMsg;
	}
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
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
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrItemCatNo() {
		return strItemCatNo;
	}
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
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
	public String getStrOrderStatus() {
		return strOrderStatus;
	}
	public void setStrOrderStatus(String strOrderStatus) {
		this.strOrderStatus = strOrderStatus;
	}
	public String getStrReportFormat() {
		return strReportFormat;
	}
	public void setStrReportFormat(String strReportFormat) {
		this.strReportFormat = strReportFormat;
	}
	public String getStrIsFooter() {
		return strIsFooter;
	}
	public void setStrIsFooter(String strIsFooter) {
		this.strIsFooter = strIsFooter;
	}
	public String getStrStoreValues() {
		return strStoreValues;
	}
	public void setStrStoreValues(String strStoreValues) {
		this.strStoreValues = strStoreValues;
	}
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String getStrPONo() {
		return strPONo;
	}
	public void setStrPONo(String strPONo) {
		this.strPONo = strPONo;
	}
	public String getStrCase() {
		return strCase;
	}
	public void setStrCase(String strCase) {
		this.strCase = strCase;
	}
	public String getStrReportId() {
		return strReportId;
	}
	public void setStrReportId(String strReportId) {
		this.strReportId = strReportId;
	}
	public String getStrHospNameValues() {
		return strHospNameValues;
	}
	public void setStrHospNameValues(String strHospNameValues) {
		this.strHospNameValues = strHospNameValues;
	}

}

