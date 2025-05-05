package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

public class DrugDistributionMonitoringDetailTransVO {
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strDeptCode = "";
	private String strUnitCode = "";
	private String strItemCat = ""; // in case of search util
	private String strCatCode = "";
	private String strCrNum = "";
	private String strCrNumber = ""; // in case of request no
	private String strPatStaffDays = "";
	private String strEpisCode = "";
	private String strVisitNo = "";
	private String strMsgType = "";
	private String strMsgString = "";
	private String strDocFlg;
	
	private String strMode = "";
	private String strIssueNo = "";
	
	private String strIssueUnitId ="";
	private String strEpisodeCode;
	private String strConfigReq="0";
	
	private WebRowSet departmentWS;
	private WebRowSet strItemCatWs = null;
	private WebRowSet strIssueDetailWs = null;
	private WebRowSet strIssueDtlPopUpWs = null;
	private WebRowSet strRequestWs = null;
	private WebRowSet strRequestDetailWs = null;
	private WebRowSet strDepartmentWs = null;
	private WebRowSet strUnitWs = null;
	private WebRowSet strConsultantWs = null;
	private WebRowSet strItemDetailWs = null;
	private WebRowSet strIssueUnitWs = null;
	private WebRowSet strGroupWs = null;
	private WebRowSet strFrequencyWs = null;
	private WebRowSet strDosageWs = null;
	
	// insert
	
	private String strIssueNumber = "";
	private String strIssueMode = "";
	private String strFinStartDate = "";
	private String strFinEndDate = "";
	private String strReqDate = "";
	private String strPrescriptionDate = "";
	private String strReceiveBy = "";
	private String strPuk = "";
	private String strRemarks = "";
	private String strAdmNo = "";
	private String strEmpNo = "";
	private String strDescription = "";
	private String strDeptUnitCode = "";
	private String strWardCode = "";
	private String strVisitType = ""; 
	private String strPrescribedBy = "";
	private String strPrescriptionFor = "";
	private String strPrescriptionFrom = "";
	private String[] strCostFinal = null;
	private String strApproxAmt = "";
	
	// when req no is not selected	
	private String strReqDeptCode ="";
	private String strReqUnitCode = "";
	private String strReqPrescribedBy = "";
	private String strReqPrescribedFor = "";
	private String strReqPrescriptionDate = "";
	private String strReqPrescriptionFrom = "";
	private String strReqEmpNo = "";
	private String strReqAdmNo = "";
	private String strReqEpisodeCode = "";
	private String strReqVisitNo = "";
	
	private String strPatientName;
	private String strFromDate;
	private String strToDate;
	
	private WebRowSet wrsData;
	private WebRowSet wrsEpisodeVisit;
	
	public WebRowSet getWrsData() {
		return wrsData;
	}
	public void setWrsData(WebRowSet wrsData) {
		this.wrsData = wrsData;
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
	public String getStrItemCat() {
		return strItemCat;
	}
	public void setStrItemCat(String strItemCat) {
		this.strItemCat = strItemCat;
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
	public String getStrCrNumber() {
		return strCrNumber;
	}
	public void setStrCrNumber(String strCrNumber) {
		this.strCrNumber = strCrNumber;
	}
	public String getStrPatStaffDays() {
		return strPatStaffDays;
	}
	public void setStrPatStaffDays(String strPatStaffDays) {
		this.strPatStaffDays = strPatStaffDays;
	}
	public String getStrEpisCode() {
		return strEpisCode;
	}
	public void setStrEpisCode(String strEpisCode) {
		this.strEpisCode = strEpisCode;
	}
	public String getStrVisitNo() {
		return strVisitNo;
	}
	public void setStrVisitNo(String strVisitNo) {
		this.strVisitNo = strVisitNo;
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
	public String getStrDocFlg() {
		return strDocFlg;
	}
	public void setStrDocFlg(String strDocFlg) {
		this.strDocFlg = strDocFlg;
	}
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
	public String getStrIssueNo() {
		return strIssueNo;
	}
	public void setStrIssueNo(String strIssueNo) {
		this.strIssueNo = strIssueNo;
	}
	public String getStrIssueUnitId() {
		return strIssueUnitId;
	}
	public void setStrIssueUnitId(String strIssueUnitId) {
		this.strIssueUnitId = strIssueUnitId;
	}
	public String getStrEpisodeCode() {
		return strEpisodeCode;
	}
	public void setStrEpisodeCode(String strEpisodeCode) {
		this.strEpisodeCode = strEpisodeCode;
	}
	public String getStrConfigReq() {
		return strConfigReq;
	}
	public void setStrConfigReq(String strConfigReq) {
		this.strConfigReq = strConfigReq;
	}
	public WebRowSet getStrItemCatWs() {
		return strItemCatWs;
	}
	public void setStrItemCatWs(WebRowSet strItemCatWs) {
		this.strItemCatWs = strItemCatWs;
	}
	public WebRowSet getStrIssueDetailWs() {
		return strIssueDetailWs;
	}
	public void setStrIssueDetailWs(WebRowSet strIssueDetailWs) {
		this.strIssueDetailWs = strIssueDetailWs;
	}
	public WebRowSet getStrIssueDtlPopUpWs() {
		return strIssueDtlPopUpWs;
	}
	public void setStrIssueDtlPopUpWs(WebRowSet strIssueDtlPopUpWs) {
		this.strIssueDtlPopUpWs = strIssueDtlPopUpWs;
	}
	public WebRowSet getStrRequestWs() {
		return strRequestWs;
	}
	public void setStrRequestWs(WebRowSet strRequestWs) {
		this.strRequestWs = strRequestWs;
	}
	public WebRowSet getStrRequestDetailWs() {
		return strRequestDetailWs;
	}
	public void setStrRequestDetailWs(WebRowSet strRequestDetailWs) {
		this.strRequestDetailWs = strRequestDetailWs;
	}
	public WebRowSet getStrDepartmentWs() {
		return strDepartmentWs;
	}
	public void setStrDepartmentWs(WebRowSet strDepartmentWs) {
		this.strDepartmentWs = strDepartmentWs;
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
	public WebRowSet getStrItemDetailWs() {
		return strItemDetailWs;
	}
	public void setStrItemDetailWs(WebRowSet strItemDetailWs) {
		this.strItemDetailWs = strItemDetailWs;
	}
	public WebRowSet getStrIssueUnitWs() {
		return strIssueUnitWs;
	}
	public void setStrIssueUnitWs(WebRowSet strIssueUnitWs) {
		this.strIssueUnitWs = strIssueUnitWs;
	}
	public WebRowSet getStrGroupWs() {
		return strGroupWs;
	}
	public void setStrGroupWs(WebRowSet strGroupWs) {
		this.strGroupWs = strGroupWs;
	}
	public WebRowSet getStrFrequencyWs() {
		return strFrequencyWs;
	}
	public void setStrFrequencyWs(WebRowSet strFrequencyWs) {
		this.strFrequencyWs = strFrequencyWs;
	}
	public WebRowSet getStrDosageWs() {
		return strDosageWs;
	}
	public void setStrDosageWs(WebRowSet strDosageWs) {
		this.strDosageWs = strDosageWs;
	}
	public String getStrIssueNumber() {
		return strIssueNumber;
	}
	public void setStrIssueNumber(String strIssueNumber) {
		this.strIssueNumber = strIssueNumber;
	}
	public String getStrIssueMode() {
		return strIssueMode;
	}
	public void setStrIssueMode(String strIssueMode) {
		this.strIssueMode = strIssueMode;
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
	public String getStrReqDate() {
		return strReqDate;
	}
	public void setStrReqDate(String strReqDate) {
		this.strReqDate = strReqDate;
	}
	public String getStrPrescriptionDate() {
		return strPrescriptionDate;
	}
	public void setStrPrescriptionDate(String strPrescriptionDate) {
		this.strPrescriptionDate = strPrescriptionDate;
	}
	public String getStrReceiveBy() {
		return strReceiveBy;
	}
	public void setStrReceiveBy(String strReceiveBy) {
		this.strReceiveBy = strReceiveBy;
	}
	public String getStrPuk() {
		return strPuk;
	}
	public void setStrPuk(String strPuk) {
		this.strPuk = strPuk;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrAdmNo() {
		return strAdmNo;
	}
	public void setStrAdmNo(String strAdmNo) {
		this.strAdmNo = strAdmNo;
	}
	public String getStrEmpNo() {
		return strEmpNo;
	}
	public void setStrEmpNo(String strEmpNo) {
		this.strEmpNo = strEmpNo;
	}
	public String getStrDescription() {
		return strDescription;
	}
	public void setStrDescription(String strDescription) {
		this.strDescription = strDescription;
	}
	public String getStrDeptUnitCode() {
		return strDeptUnitCode;
	}
	public void setStrDeptUnitCode(String strDeptUnitCode) {
		this.strDeptUnitCode = strDeptUnitCode;
	}
	public String getStrWardCode() {
		return strWardCode;
	}
	public void setStrWardCode(String strWardCode) {
		this.strWardCode = strWardCode;
	}
	public String getStrVisitType() {
		return strVisitType;
	}
	public void setStrVisitType(String strVisitType) {
		this.strVisitType = strVisitType;
	}
	public String getStrPrescribedBy() {
		return strPrescribedBy;
	}
	public void setStrPrescribedBy(String strPrescribedBy) {
		this.strPrescribedBy = strPrescribedBy;
	}
	public String getStrPrescriptionFor() {
		return strPrescriptionFor;
	}
	public void setStrPrescriptionFor(String strPrescriptionFor) {
		this.strPrescriptionFor = strPrescriptionFor;
	}
	public String getStrPrescriptionFrom() {
		return strPrescriptionFrom;
	}
	public void setStrPrescriptionFrom(String strPrescriptionFrom) {
		this.strPrescriptionFrom = strPrescriptionFrom;
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
	public String getStrReqDeptCode() {
		return strReqDeptCode;
	}
	public void setStrReqDeptCode(String strReqDeptCode) {
		this.strReqDeptCode = strReqDeptCode;
	}
	public String getStrReqUnitCode() {
		return strReqUnitCode;
	}
	public void setStrReqUnitCode(String strReqUnitCode) {
		this.strReqUnitCode = strReqUnitCode;
	}
	public String getStrReqPrescribedBy() {
		return strReqPrescribedBy;
	}
	public void setStrReqPrescribedBy(String strReqPrescribedBy) {
		this.strReqPrescribedBy = strReqPrescribedBy;
	}
	public String getStrReqPrescribedFor() {
		return strReqPrescribedFor;
	}
	public void setStrReqPrescribedFor(String strReqPrescribedFor) {
		this.strReqPrescribedFor = strReqPrescribedFor;
	}
	public String getStrReqPrescriptionDate() {
		return strReqPrescriptionDate;
	}
	public void setStrReqPrescriptionDate(String strReqPrescriptionDate) {
		this.strReqPrescriptionDate = strReqPrescriptionDate;
	}
	public String getStrReqPrescriptionFrom() {
		return strReqPrescriptionFrom;
	}
	public void setStrReqPrescriptionFrom(String strReqPrescriptionFrom) {
		this.strReqPrescriptionFrom = strReqPrescriptionFrom;
	}
	public String getStrReqEmpNo() {
		return strReqEmpNo;
	}
	public void setStrReqEmpNo(String strReqEmpNo) {
		this.strReqEmpNo = strReqEmpNo;
	}
	public String getStrReqAdmNo() {
		return strReqAdmNo;
	}
	public void setStrReqAdmNo(String strReqAdmNo) {
		this.strReqAdmNo = strReqAdmNo;
	}
	public String getStrReqEpisodeCode() {
		return strReqEpisodeCode;
	}
	public void setStrReqEpisodeCode(String strReqEpisodeCode) {
		this.strReqEpisodeCode = strReqEpisodeCode;
	}
	public String getStrReqVisitNo() {
		return strReqVisitNo;
	}
	public void setStrReqVisitNo(String strReqVisitNo) {
		this.strReqVisitNo = strReqVisitNo;
	}
	public WebRowSet getDepartmentWS() {
		return departmentWS;
	}
	public void setDepartmentWS(WebRowSet departmentWS) {
		this.departmentWS = departmentWS;
	}
	public String getStrPatientName() {
		return strPatientName;
	}
	public void setStrPatientName(String strPatientName) {
		this.strPatientName = strPatientName;
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
	public WebRowSet getWrsEpisodeVisit() {
		return wrsEpisodeVisit;
	}
	public void setWrsEpisodeVisit(WebRowSet wrsEpisodeVisit) {
		this.wrsEpisodeVisit = wrsEpisodeVisit;
	}
	
	
	
}	