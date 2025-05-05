package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;

public class IssueEmployeeTransFB extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strErrMsg = "";
	private String strWarningMsg = "";
	private String strNormalMsg = "";
	
	private String strCtDate = "";
	private String strDeptCode ="";
	private String strPrescribedBy = "";
	private String strPrescriptionDate = "";
	private String strCrNo = "";
	
	private String strIssueNum = "0";
	private String strIssueNo = "0";
	private String strIssueDate = "";
	private String strIssueDtl = "";
	private String[] strCostFinal = null;
	private String strApproxAmt = "";
	private String empNo = "";
	private String storeName = "";
	private String itemCatName = "";
	private String strId = "";
	private String itemCategory = "";
	private String strReceiveBy = "";
	private String strRemarks = "";
	
	private String strStoreValues = "";
	private String strConsultantValues = ""; 
		
	private String strDeptValues = "";
	private String strGroupValues = "";
	
	private String strPatientDetails = "";
	private String strEmployeeNo = "";
	private String strDeptId = "";
	private String strEmployeeName = "";
	
	private String[] itemParamValue = null;
	private String[] strReqQty = null;
	private String[] strUnitName = null;
		
	private String strChkEmpExist = "1";
	private String strStoreId= "";
	private String ItemCatValues ="";
	

	/**
	 * @return the itemCatValues
	 */
	public String getItemCatValues() {
		return ItemCatValues;
	}
	/**
	 * @param itemCatValues the itemCatValues to set
	 */
	public void setItemCatValues(String itemCatValues) {
		ItemCatValues = itemCatValues;
	}
	/**
	 * @return the strStoreId
	 */
	public String getStrStoreId() {
		return strStoreId;
	}
	/**
	 * @param strStoreId the strStoreId to set
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String[] getItemParamValue() {
		return itemParamValue;
	}
	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
	}
	public String getStrPatientDetails() {
		return strPatientDetails;
	}
	public void setStrPatientDetails(String strPatientDetails) {
		this.strPatientDetails = strPatientDetails;
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
	public String getStrStoreValues() {
		return strStoreValues;
	}
	public void setStrStoreValues(String strStoreValues) {
		this.strStoreValues = strStoreValues;
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
	public String getStrCrNo() {
		return strCrNo;
	}
	public void setStrCrNo(String strCrNo) {
		this.strCrNo = strCrNo;
	}
	
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getItemCatName() {
		return itemCatName;
	}
	public void setItemCatName(String itemCatName) {
		this.itemCatName = itemCatName;
	}
	public String getStrId() {
		return strId;
	}
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	public String getStrCtDate() {
		return strCtDate;
	}
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}
	public String getStrDeptCode() {
		return strDeptCode;
	}
	public void setStrDeptCode(String strDeptCode) {
		this.strDeptCode = strDeptCode;
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
	
	public String getStrDeptValues() {
		return strDeptValues;
	}
	public void setStrDeptValues(String strDeptValues) {
		this.strDeptValues = strDeptValues;
	}
	public String getStrGroupValues() {
		return strGroupValues;
	}
	public void setStrGroupValues(String strGroupValues) {
		this.strGroupValues = strGroupValues;
	}
	public String getStrIssueNo() {
		return strIssueNo;
	}
	public void setStrIssueNo(String strIssueNo) {
		this.strIssueNo = strIssueNo;
	}
	public String getStrIssueDate() {
		return strIssueDate;
	}
	public void setStrIssueDate(String strIssueDate) {
		this.strIssueDate = strIssueDate;
	}
	public String getStrIssueDtl() {
		return strIssueDtl;
	}
	public void setStrIssueDtl(String strIssueDtl) {
		this.strIssueDtl = strIssueDtl;
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
	public String getStrEmployeeNo() {
		return strEmployeeNo;
	}
	public void setStrEmployeeNo(String strEmployeeNo) {
		this.strEmployeeNo = strEmployeeNo;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getStrDeptId() {
		return strDeptId;
	}
	public void setStrDeptId(String strDeptId) {
		this.strDeptId = strDeptId;
	}
	public String getStrChkEmpExist() {
		return strChkEmpExist;
	}
	public void setStrChkEmpExist(String strChkEmpExist) {
		this.strChkEmpExist = strChkEmpExist;
	}
	public String getStrConsultantValues() {
		return strConsultantValues;
	}
	public void setStrConsultantValues(String strConsultantValues) {
		this.strConsultantValues = strConsultantValues;
	}
	public String getStrIssueNum() {
		return strIssueNum;
	}
	public void setStrIssueNum(String strIssueNum) {
		this.strIssueNum = strIssueNum;
	}
	public String getStrEmployeeName() {
		return strEmployeeName;
	}
	public void setStrEmployeeName(String strEmployeeName) {
		this.strEmployeeName = strEmployeeName;
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
