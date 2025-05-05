package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;

public class DrugDistributionMonitoringDetailTransFB extends ActionForm
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strErrMsg = "";
	private String strWarningMsg = "";
	private String strNormalMsg = "";
	
	private String strConfCatCode = "";
	
	
	private String strCurrentDate;
	private String strIssueNo = "";
	private String strIssueDate = "";
	private String strIssueDtl = "";
	
	private String strFromDate;
	private String strToDate;
	private String strPatientDtls;
	
	private String strDeptCode ="";
	private String strUnitCode = "";
	
	private String strCrNo = "";
	private String crNo = "";
	
	private String strDeptId;
	private String strUnitId;
	
	private String strIssuedDtl;
	private String strPrescribedDtl;
	
	private String strUnitValues;
	
	private String disFlag = "0";
	private String strMode = "";
	private String strInvalidCrFlag="0";
	private String strIssueNum= "0";
	private String strPatientDetails = "";
	private String strRequestDetails = "";
	private String strScanFlg="0";
	private String strCrChkFlg="0";
	private String strConfigReq="0";
	private String strDeptValues;
	
	private String strRemarks = "";

	private String strHidReqVal="";
	private String strSDFFlgColor;
	
	private String strVisitNo;
	private String strVisitValues;
	private String index;
	private String strScanDocFlg;
	
	public String getStrSDFFlgColor() {
		return strSDFFlgColor;
	}

	public void setStrSDFFlgColor(String strSDFFlgColor) {
		this.strSDFFlgColor = strSDFFlgColor;
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

	public String getStrConfCatCode() {
		return strConfCatCode;
	}

	public void setStrConfCatCode(String strConfCatCode) {
		this.strConfCatCode = strConfCatCode;
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

	public String getStrCrNo() {
		return strCrNo;
	}

	public void setStrCrNo(String strCrNo) {
		this.strCrNo = strCrNo;
	}

	public String getCrNo() {
		return crNo;
	}

	public void setCrNo(String crNo) {
		this.crNo = crNo;
	}

	public String getDisFlag() {
		return disFlag;
	}

	public void setDisFlag(String disFlag) {
		this.disFlag = disFlag;
	}

	public String getStrMode() {
		return strMode;
	}

	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}

	public String getStrInvalidCrFlag() {
		return strInvalidCrFlag;
	}

	public void setStrInvalidCrFlag(String strInvalidCrFlag) {
		this.strInvalidCrFlag = strInvalidCrFlag;
	}

	public String getStrIssueNum() {
		return strIssueNum;
	}

	public void setStrIssueNum(String strIssueNum) {
		this.strIssueNum = strIssueNum;
	}

	public String getStrPatientDetails() {
		return strPatientDetails;
	}

	public void setStrPatientDetails(String strPatientDetails) {
		this.strPatientDetails = strPatientDetails;
	}

	public String getStrRequestDetails() {
		return strRequestDetails;
	}

	public void setStrRequestDetails(String strRequestDetails) {
		this.strRequestDetails = strRequestDetails;
	}

	public String getStrScanFlg() {
		return strScanFlg;
	}

	public void setStrScanFlg(String strScanFlg) {
		this.strScanFlg = strScanFlg;
	}

	public String getStrCrChkFlg() {
		return strCrChkFlg;
	}

	public void setStrCrChkFlg(String strCrChkFlg) {
		this.strCrChkFlg = strCrChkFlg;
	}

	public String getStrConfigReq() {
		return strConfigReq;
	}

	public void setStrConfigReq(String strConfigReq) {
		this.strConfigReq = strConfigReq;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	public String getStrHidReqVal() {
		return strHidReqVal;
	}

	public void setStrHidReqVal(String strHidReqVal) {
		this.strHidReqVal = strHidReqVal;
	}

	public String getStrDeptValues() {
		return strDeptValues;
	}

	public void setStrDeptValues(String strDeptValues) {
		this.strDeptValues = strDeptValues;
	}

	public String getStrDeptId() {
		return strDeptId;
	}

	public void setStrDeptId(String strDeptId) {
		this.strDeptId = strDeptId;
	}

	public String getStrUnitId() {
		return strUnitId;
	}

	public void setStrUnitId(String strUnitId) {
		this.strUnitId = strUnitId;
	}

	public String getStrUnitValues() {
		return strUnitValues;
	}

	public void setStrUnitValues(String strUnitValues) {
		this.strUnitValues = strUnitValues;
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

	public String getStrPatientDtls() {
		return strPatientDtls;
	}

	public void setStrPatientDtls(String strPatientDtls) {
		this.strPatientDtls = strPatientDtls;
	}

	public String getStrIssuedDtl() {
		return strIssuedDtl;
	}

	public void setStrIssuedDtl(String strIssuedDtl) {
		this.strIssuedDtl = strIssuedDtl;
	}

	public String getStrPrescribedDtl() {
		return strPrescribedDtl;
	}

	public void setStrPrescribedDtl(String strPrescribedDtl) {
		this.strPrescribedDtl = strPrescribedDtl;
	}

	public String getStrVisitNo() {
		return strVisitNo;
	}

	public void setStrVisitNo(String strVisitNo) {
		this.strVisitNo = strVisitNo;
	}

	public String getStrVisitValues() {
		return strVisitValues;
	}

	public void setStrVisitValues(String strVisitValues) {
		this.strVisitValues = strVisitValues;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getStrScanDocFlg() {
		return strScanDocFlg;
	}

	public void setStrScanDocFlg(String strScanDocFlg) {
		this.strScanDocFlg = strScanDocFlg;
	}
	
	
}	