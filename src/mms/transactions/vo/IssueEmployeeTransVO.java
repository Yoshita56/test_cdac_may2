package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

public class IssueEmployeeTransVO {
	
	private String strMsgType = "";
	private String strMsgString = "";
	
	private String strDeptCode = "";
	private String strUnitCode = "";
	private String strItemCat = "";
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strStoreId = "";
	private String strReqTypeId = "";
	private String strCatCode = "";
	private String strCrNum = "";
	private String strEmployeeDays = "";
	private String strReceiveBy = "";
	private String strRemarks = "";
	private String strFinStartDate = "";
	private String strFinEndDate = "";
	private String strPrescribedBy = "";
	private String strPrescriptionDate = "";
	private String strChkEmpExist="1";
	private String strIssueNumber = "";
	private String strDeptId = "";
	private WebRowSet strStoreWs = null;
	private WebRowSet strItemCatWs = null;
	private WebRowSet strDepartmentWs = null;
	private WebRowSet strUnitWs = null;
	private WebRowSet strConsultantWs = null;
	private WebRowSet strGroupWs = null;
	private WebRowSet strIssueDetailWs = null;
	private WebRowSet strEmployeeWs = null;
	private String strEmployeeNo = "";
	private String[] strReqQty = null;
	private String[] strUnitName = null;
	private String[] itemParamValue = null;
	private String strCtDate = "";
	private String[] strCostFinal = null;
	private String strApproxAmt = "";
	
	
	public String[] getItemParamValue() {
		return itemParamValue;
	}
	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
	}
	public String[] getStrReqQty() {
		return strReqQty;
	}
	public void setStrReqQty(String[] strReqQty) {
		this.strReqQty = strReqQty;
	}
	public String[] getStrUnitName() {
		return strUnitName;
	}
	public void setStrUnitName(String[] strUnitName) {
		this.strUnitName = strUnitName;
	}
	public WebRowSet getStrIssueDetailWs() {
		return strIssueDetailWs;
	}
	public void setStrIssueDetailWs(WebRowSet strIssueDetailWs) {
		this.strIssueDetailWs = strIssueDetailWs;
	}
	public String getStrItemCat() {
		return strItemCat;
	}
	public void setStrItemCat(String strItemCat) {
		this.strItemCat = strItemCat;
	}
	public WebRowSet getStrGroupWs() {
		return strGroupWs;
	}
	public void setStrGroupWs(WebRowSet strGroupWs) {
		this.strGroupWs = strGroupWs;
	}
	public WebRowSet getStrUnitWs() {
		return strUnitWs;
	}
	public void setStrUnitWs(WebRowSet strUnitWs) {
		this.strUnitWs = strUnitWs;
	}
	public WebRowSet getStrConsultantWs() {
		return strConsultantWs;
	}
	public void setStrConsultantWs(WebRowSet strConsultantWs) {
		this.strConsultantWs = strConsultantWs;
	}
	public WebRowSet getStrDepartmentWs() {
		return strDepartmentWs;
	}
	public void setStrDepartmentWs(WebRowSet strDepartmentWs) {
		this.strDepartmentWs = strDepartmentWs;
	}
	public WebRowSet getStrItemCatWs() {
		return strItemCatWs;
	}
	public void setStrItemCatWs(WebRowSet strItemCatWs) {
		this.strItemCatWs = strItemCatWs;
	}
	public WebRowSet getStrStoreWs() {
		return strStoreWs;
	}
	public void setStrStoreWs(WebRowSet strStoreWs) {
		this.strStoreWs = strStoreWs;
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
	public String getStrMsgType() {
		return strMsgType;
	}
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}
	public String getStrMsgString() {
		return strMsgString;
	}
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrReqTypeId() {
		return strReqTypeId;
	}
	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}
	public String getStrDeptCode() {
		return strDeptCode;
	}
	public void setStrDeptCode(String strDeptCode) {
		this.strDeptCode = strDeptCode;
	}
	public String getStrUnitCode() {
		return strUnitCode;
	}
	public void setStrUnitCode(String strUnitCode) {
		this.strUnitCode = strUnitCode;
	}
	public String getStrCatCode() {
		return strCatCode;
	}
	public void setStrCatCode(String strCatCode) {
		this.strCatCode = strCatCode;
	}
	public String getStrCrNum() {
		return strCrNum;
	}
	public void setStrCrNum(String strCrNum) {
		this.strCrNum = strCrNum;
	}
	public String getStrEmployeeDays() {
		return strEmployeeDays;
	}
	public void setStrEmployeeDays(String strEmployeeDays) {
		this.strEmployeeDays = strEmployeeDays;
	}
	public String getStrReceiveBy() {
		return strReceiveBy;
	}
	public void setStrReceiveBy(String strReceiveBy) {
		this.strReceiveBy = strReceiveBy;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrFinStartDate() {
		return strFinStartDate;
	}
	public void setStrFinStartDate(String strFinStartDate) {
		this.strFinStartDate = strFinStartDate;
	}
	public String getStrFinEndDate() {
		return strFinEndDate;
	}
	public void setStrFinEndDate(String strFinEndDate) {
		this.strFinEndDate = strFinEndDate;
	}
	public String getStrPrescribedBy() {
		return strPrescribedBy;
	}
	public void setStrPrescribedBy(String strPrescribedBy) {
		this.strPrescribedBy = strPrescribedBy;
	}
	public String getStrPrescriptionDate() {
		return strPrescriptionDate;
	}
	public void setStrPrescriptionDate(String strPrescriptionDate) {
		this.strPrescriptionDate = strPrescriptionDate;
	}
	public WebRowSet getStrEmployeeWs() {
		return strEmployeeWs;
	}
	public void setStrEmployeeWs(WebRowSet strEmployeeWs) {
		this.strEmployeeWs = strEmployeeWs;
	}
	public String getStrChkEmpExist() {
		return strChkEmpExist;
	}
	public void setStrChkEmpExist(String strChkEmpExist) {
		this.strChkEmpExist = strChkEmpExist;
	}
	public String getStrEmployeeNo() {
		return strEmployeeNo;
	}
	public void setStrEmployeeNo(String strEmployeeNo) {
		this.strEmployeeNo = strEmployeeNo;
	}
	public String getStrDeptId() {
		return strDeptId;
	}
	public void setStrDeptId(String strDeptId) {
		this.strDeptId = strDeptId;
	}
	public String getStrIssueNumber() {
		return strIssueNumber;
	}
	public void setStrIssueNumber(String strIssueNumber) {
		this.strIssueNumber = strIssueNumber;
	}
	public String getStrCtDate() {
		return strCtDate;
	}
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}
	public String[] getStrCostFinal() {
		return strCostFinal;
	}
	public void setStrCostFinal(String[] strCostFinal) {
		this.strCostFinal = strCostFinal;
	}
	public String getStrApproxAmt() {
		return strApproxAmt;
	}
	public void setStrApproxAmt(String strApproxAmt) {
		this.strApproxAmt = strApproxAmt;
	}
	

}
