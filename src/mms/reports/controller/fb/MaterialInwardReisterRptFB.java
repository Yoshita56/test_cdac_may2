package mms.reports.controller.fb;

import org.apache.struts.action.ActionForm;

public class MaterialInwardReisterRptFB extends ActionForm 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String strMode;
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
	
	
	private String strWhetherToShowDataForNoBudgetAllocatedCheckBox;
	private String strWhetherToShowNoOfBedsCheckBox;
	
	private String strManufactureCombo;

	private String strBatchNo;
	private String strFromDate;
	private String strToDate;
	private String strPoNumber;
	private String strPoType;
	public String getStrPoType() {
		return strPoType;
	}

	public void setStrPoType(String strPoType) {
		this.strPoType = strPoType;
	}

	private String strProcRelatedValue;
	private String strDateType = "1";

	public String getStrProcRelatedValue() {
		return strProcRelatedValue;
	}

	public void setStrProcRelatedValue(String strProcRelatedValue) {
		this.strProcRelatedValue = strProcRelatedValue;
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

	/**
	 * @return the strHospitalCode
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	/**
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * @return the strSeatId
	 */
	public String getStrSeatId() {
		return strSeatId;
	}

	/**
	 * @param strSeatId the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * @return the strIsFooter
	 */
	public String getStrIsFooter() {
		return strIsFooter;
	}

	/**
	 * @param strIsFooter the strIsFooter to set
	 */
	public void setStrIsFooter(String strIsFooter) {
		this.strIsFooter = strIsFooter;
	}

	/**
	 * @return the strUserRemarks
	 */
	public String getStrUserRemarks() {
		return strUserRemarks;
	}

	/**
	 * @param strUserRemarks the strUserRemarks to set
	 */
	public void setStrUserRemarks(String strUserRemarks) {
		this.strUserRemarks = strUserRemarks;
	}

	/**
	 * @return the strReportFormat
	 */
	public String getStrReportFormat() {
		return strReportFormat;
	}

	/**
	 * @param strReportFormat the strReportFormat to set
	 */
	public void setStrReportFormat(String strReportFormat) {
		this.strReportFormat = strReportFormat;
	}

	/**
	 * @return the strReportId
	 */
	public String getStrReportId() {
		return strReportId;
	}

	/**
	 * @param strReportId the strReportId to set
	 */
	public void setStrReportId(String strReportId) {
		this.strReportId = strReportId;
	}

	/**
	 * @return the strErrMsg
	 */
	public String getStrErrMsg() {
		return strErrMsg;
	}

	/**
	 * @param strErrMsg the strErrMsg to set
	 */
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}

	/**
	 * @return the strWarningMsg
	 */
	public String getStrWarningMsg() {
		return strWarningMsg;
	}

	/**
	 * @param strWarningMsg the strWarningMsg to set
	 */
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}

	/**
	 * @return the strNormalMsg
	 */
	public String getStrNormalMsg() {
		return strNormalMsg;
	}

	/**
	 * @param strNormalMsg the strNormalMsg to set
	 */
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}

	/**
	 * @return the strItemCategoryNo
	 */
	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}

	/**
	 * @param strItemCategoryNo the strItemCategoryNo to set
	 */
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}

	/**
	 * @return the strItemCategoryCombo
	 */
	public String getStrItemCategoryCombo() {
		return strItemCategoryCombo;
	}

	/**
	 * @param strItemCategoryCombo the strItemCategoryCombo to set
	 */
	public void setStrItemCategoryCombo(String strItemCategoryCombo) {
		this.strItemCategoryCombo = strItemCategoryCombo;
	}

	/**
	 * @return the strStatus
	 */
	public String getStrStatus() {
		return strStatus;
	}

	/**
	 * @param strStatus the strStatus to set
	 */
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
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

	public String getStrWhetherToShowDataForNoBudgetAllocatedCheckBox() {
		return strWhetherToShowDataForNoBudgetAllocatedCheckBox;
	}

	public void setStrWhetherToShowDataForNoBudgetAllocatedCheckBox(
			String strWhetherToShowDataForNoBudgetAllocatedCheckBox) {
		this.strWhetherToShowDataForNoBudgetAllocatedCheckBox = strWhetherToShowDataForNoBudgetAllocatedCheckBox;
	}

	public String getStrWhetherToShowNoOfBedsCheckBox() {
		return strWhetherToShowNoOfBedsCheckBox;
	}

	public void setStrWhetherToShowNoOfBedsCheckBox(
			String strWhetherToShowNoOfBedsCheckBox) {
		this.strWhetherToShowNoOfBedsCheckBox = strWhetherToShowNoOfBedsCheckBox;
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

	public String getStrCurrentDate() {
		return strCurrentDate;
	}

	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}

	public String getStrPoNumber() {
		return strPoNumber;
	}

	public void setStrPoNumber(String strPoNumber) {
		this.strPoNumber = strPoNumber;
	}

	public String getStrSupplierName() {
		return strSupplierName;
	}

	public void setStrSupplierName(String strSupplierName) {
		this.strSupplierName = strSupplierName;
	}

	public String getStrDateType() {
		return strDateType;
	}

	public void setStrDateType(String strDateType) {
		this.strDateType = strDateType;
	}

	public String getStrMode() {
		return strMode;
	}

	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
	
}