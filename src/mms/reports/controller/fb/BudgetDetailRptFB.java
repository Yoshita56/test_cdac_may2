package mms.reports.controller.fb;

import org.apache.struts.action.ActionForm;

public class BudgetDetailRptFB extends ActionForm
{

	private static final long serialVersionUID = 1L;
	
	private String strHospitalCode;
	private String strSeatId;
	private String hmode;
	
	
	private String strErrMsg;
	private String strNormalMsg;
	private String strWarningMsg;
	
	private String strReportId;
	private String strUserRemarks;
	private String strReportFormat;
	private String strIsFooter;
	
	private String strItemCatNo;
	
	private String strStoreId;
	private String strStoreName;
	private String strStoreValues;
	private String strDwhStoreName;
		
	
	private String strDrugWarehouseTypeId;
	private String strDrugWarehouseTypeCmb;
	private String strDwhTypeVal;
	
	private String strCurrentDate;
	private String strFromDate;
	private String strToDate;
	
	private String strStartFinancialYear;
	private String strEndFinancialYear;
	private String strEndFinancialYearTemp;
	private String strNextFinancialYear;
	private String strCurrentFinancialYear;
	private String strIndentPeriodValue;
	
	
	private String strWhetherToShowDataForNoBudgetAllocatedCheckBox;
	private String strWhetherToShowNoOfBedsCheckBox;
	
	public String getStrWhetherToShowNoOfBedsCheckBox() {
		return strWhetherToShowNoOfBedsCheckBox;
	}
	public void setStrWhetherToShowNoOfBedsCheckBox(
			String strWhetherToShowNoOfBedsCheckBox) {
		this.strWhetherToShowNoOfBedsCheckBox = strWhetherToShowNoOfBedsCheckBox;
	}
	public String getStrWhetherToShowDataForNoBudgetAllocatedCheckBox() {
		return strWhetherToShowDataForNoBudgetAllocatedCheckBox;
	}
	public void setStrWhetherToShowDataForNoBudgetAllocatedCheckBox(
			String strWhetherToShowDataForNoBudgetAllocatedCheckBox) {
		this.strWhetherToShowDataForNoBudgetAllocatedCheckBox = strWhetherToShowDataForNoBudgetAllocatedCheckBox;
	}
	/**
	 * Setters and Getters for the above attributes
	 */
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
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
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
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
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
	public String getHmode() {
		return hmode;
	}
	public void setHmode(String hmode) {
		this.hmode = hmode;
	}
	public String getStrDwhStoreName() {
		return strDwhStoreName;
	}
	public void setStrDwhStoreName(String strDwhStoreName) {
		this.strDwhStoreName = strDwhStoreName;
	}
	public String getStrNextFinancialYear() {
		return strNextFinancialYear;
	}
	public void setStrNextFinancialYear(String strNextFinancialYear) {
		this.strNextFinancialYear = strNextFinancialYear;
	}
	public String getStrCurrentFinancialYear() {
		return strCurrentFinancialYear;
	}
	public void setStrCurrentFinancialYear(String strCurrentFinancialYear) {
		this.strCurrentFinancialYear = strCurrentFinancialYear;
	}
	public String getStrIndentPeriodValue() {
		return strIndentPeriodValue;
	}
	public void setStrIndentPeriodValue(String strIndentPeriodValue) {
		this.strIndentPeriodValue = strIndentPeriodValue;
	}
	
	
}
