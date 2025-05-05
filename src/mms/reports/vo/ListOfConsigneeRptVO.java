package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

public class ListOfConsigneeRptVO {
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	
	private String strErrMsg = "";
	private String strWarningMsg = "";
	private String strNormalMsg = "";
	
	private String strItemCategoryNo = "";
	private String strStatus = "";
	
	private String strItemCategoryCombo = null;
	private String strReportId;
	private String strUserRemarks;
	private String strReportFormat;
	private String strIsFooter;
	
	private String strItemCatNo;
	
	private String strStoreId;
	private String strSupplierId;
	private String strStoreName;
	private String strStoreValues;
	private String strCurrentDate;
	private String strSupplierName;
	
	
	
	private String strDrugWarehouseTypeId;
	private String strDrugWarehouseTypeCmb;
	private String strDwhTypeVal;
	
    private String strStartFinancialYear;
	private String strEndFinancialYear;
	private String strEndFinancialYearTemp;
	
	
	private String strManufactureCombo;

	private String strBatchNo;
	private String strOrderFromDate;
	private String strOrderToDate;
	private String strPoNumber;
	private String strPoDate;
	private String strPoRefNo;
	private String strMsgString="";
	private String StrMsgType="";
	private String strProcRelatedValue;
	private String strStoreList="";
	private String strSecCheckHidValue="";
	private String strStoreIdTmp;
	private String strStoreNameTmp;
	private String strPoListOfConsignee;
	private int intDoneColSize=0;
	
	private WebRowSet strManufactureComboWS=null;
	private WebRowSet strPOWs =null;
	private WebRowSet wrsStoreNameCombo=null;
	private WebRowSet wrsPoListOfConsignee=null;
	
	private String strMode;
	
	public String getStrMode() {
		return strMode;
	}

	public void setStrMode(String strMode) {
		this.strMode = strMode;
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

	public String getStrErrMsg() {
		return strErrMsg;
	}

	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}

	public String getStrWarningMsg() {
		return strWarningMsg;
	}

	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}

	public String getStrNormalMsg() {
		return strNormalMsg;
	}

	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}

	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}

	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}

	public String getStrStatus() {
		return strStatus;
	}

	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}

	public String getStrItemCategoryCombo() {
		return strItemCategoryCombo;
	}

	public void setStrItemCategoryCombo(String strItemCategoryCombo) {
		this.strItemCategoryCombo = strItemCategoryCombo;
	}

	public String getStrReportId() {
		return strReportId;
	}

	public void setStrReportId(String strReportId) {
		this.strReportId = strReportId;
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

	public String getStrIsFooter() {
		return strIsFooter;
	}

	public void setStrIsFooter(String strIsFooter) {
		this.strIsFooter = strIsFooter;
	}

	public String getStrItemCatNo() {
		return strItemCatNo;
	}

	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}

	public String getStrStoreId() {
		return strStoreId;
	}

	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	public String getStrSupplierId() {
		return strSupplierId;
	}

	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}

	public String getStrStoreName() {
		return strStoreName;
	}

	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}

	public String getStrStoreValues() {
		return strStoreValues;
	}

	public void setStrStoreValues(String strStoreValues) {
		this.strStoreValues = strStoreValues;
	}

	public String getStrCurrentDate() {
		return strCurrentDate;
	}

	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}

	public String getStrSupplierName() {
		return strSupplierName;
	}

	public void setStrSupplierName(String strSupplierName) {
		this.strSupplierName = strSupplierName;
	}

	public String getStrDrugWarehouseTypeId() {
		return strDrugWarehouseTypeId;
	}

	public void setStrDrugWarehouseTypeId(String strDrugWarehouseTypeId) {
		this.strDrugWarehouseTypeId = strDrugWarehouseTypeId;
	}

	public String getStrDrugWarehouseTypeCmb() {
		return strDrugWarehouseTypeCmb;
	}

	public void setStrDrugWarehouseTypeCmb(String strDrugWarehouseTypeCmb) {
		this.strDrugWarehouseTypeCmb = strDrugWarehouseTypeCmb;
	}

	public String getStrDwhTypeVal() {
		return strDwhTypeVal;
	}

	public void setStrDwhTypeVal(String strDwhTypeVal) {
		this.strDwhTypeVal = strDwhTypeVal;
	}

	public String getStrStartFinancialYear() {
		return strStartFinancialYear;
	}

	public void setStrStartFinancialYear(String strStartFinancialYear) {
		this.strStartFinancialYear = strStartFinancialYear;
	}

	public String getStrEndFinancialYear() {
		return strEndFinancialYear;
	}

	public void setStrEndFinancialYear(String strEndFinancialYear) {
		this.strEndFinancialYear = strEndFinancialYear;
	}

	public String getStrEndFinancialYearTemp() {
		return strEndFinancialYearTemp;
	}

	public void setStrEndFinancialYearTemp(String strEndFinancialYearTemp) {
		this.strEndFinancialYearTemp = strEndFinancialYearTemp;
	}

	public String getStrManufactureCombo() {
		return strManufactureCombo;
	}

	public void setStrManufactureCombo(String strManufactureCombo) {
		this.strManufactureCombo = strManufactureCombo;
	}

	public String getStrBatchNo() {
		return strBatchNo;
	}

	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}

	public String getStrOrderFromDate() {
		return strOrderFromDate;
	}

	public void setStrOrderFromDate(String strOrderFromDate) {
		this.strOrderFromDate = strOrderFromDate;
	}

	public String getStrOrderToDate() {
		return strOrderToDate;
	}

	public void setStrOrderToDate(String strOrderToDate) {
		this.strOrderToDate = strOrderToDate;
	}

	public String getStrPoNumber() {
		return strPoNumber;
	}

	public void setStrPoNumber(String strPoNumber) {
		this.strPoNumber = strPoNumber;
	}

	public String getStrPoDate() {
		return strPoDate;
	}

	public void setStrPoDate(String strPoDate) {
		this.strPoDate = strPoDate;
	}

	public String getStrPoRefNo() {
		return strPoRefNo;
	}

	public void setStrPoRefNo(String strPoRefNo) {
		this.strPoRefNo = strPoRefNo;
	}

	public String getStrMsgType() {
		return StrMsgType;
	}

	public void setStrMsgType(String strMsgType) {
		StrMsgType = strMsgType;
	}

	public String getStrMsgString() {
		return strMsgString;
	}

	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	public String getStrProcRelatedValue() {
		return strProcRelatedValue;
	}

	public void setStrProcRelatedValue(String strProcRelatedValue) {
		this.strProcRelatedValue = strProcRelatedValue;
	}

	public String getStrStoreList() {
		return strStoreList;
	}

	public void setStrStoreList(String strStoreList) {
		this.strStoreList = strStoreList;
	}

	
	public String getStrSecCheckHidValue() {
		return strSecCheckHidValue;
	}

	public void setStrSecCheckHidValue(String strSecCheckHidValue) {
		this.strSecCheckHidValue = strSecCheckHidValue;
	}

	
	public String getStrStoreIdTmp() {
		return strStoreIdTmp;
	}

	public void setStrStoreIdTmp(String strStoreIdTmp) {
		this.strStoreIdTmp = strStoreIdTmp;
	}

	public String getStrStoreNameTmp() {
		return strStoreNameTmp;
	}

	public void setStrStoreNameTmp(String strStoreNameTmp) {
		this.strStoreNameTmp = strStoreNameTmp;
	}
	
	

	public String getStrPoListOfConsignee() {
		return strPoListOfConsignee;
	}

	public void setStrPoListOfConsignee(String strPoListOfConsignee) {
		this.strPoListOfConsignee = strPoListOfConsignee;
	}

	public int getIntDoneColSize() {
		return intDoneColSize;
	}

	public void setIntDoneColSize(int intDoneColSize) {
		this.intDoneColSize = intDoneColSize;
	}

	public WebRowSet getStrManufactureComboWS() {
		return strManufactureComboWS;
	}

	public void setStrManufactureComboWS(WebRowSet strManufactureComboWS) {
		this.strManufactureComboWS = strManufactureComboWS;
	}

	public WebRowSet getStrPOWs() {
		return strPOWs;
	}

	public void setStrPOWs(WebRowSet strPOWs) {
		this.strPOWs = strPOWs;
	}

	public WebRowSet getWrsStoreNameCombo() {
		return wrsStoreNameCombo;
	}

	public void setWrsStoreNameCombo(WebRowSet wrsStoreNameCombo) {
		this.wrsStoreNameCombo = wrsStoreNameCombo;
	}

	public WebRowSet getWrsPoListOfConsignee() {
		return wrsPoListOfConsignee;
	}

	public void setWrsPoListOfConsignee(WebRowSet wrsPoListOfConsignee) {
		this.wrsPoListOfConsignee = wrsPoListOfConsignee;
	}
	
	
}
