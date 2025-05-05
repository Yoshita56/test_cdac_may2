package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 13/Apr/2009
 * Modif Date : / /2009 
*/
public class IssueToEmployeeTransVO 
{
	private static final long serialVersionUID = 02L;
	private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
    private String strMsgString = "";
	private String strMsgType = "0";
	private String strErrMsg = "";

	private String strHospitalCode = "";
	private String strGroupId = "";
	private String strCtDate = "";
	private String strReqNo = "";
	private String strSeatId = "";
	private String strPOType ="";
	private String strIndentNo="";
	private String strSupplName="";
	private String strStoreName ="";
	private String strItemCategory="";
	private String strGroupIdForItemSearch="";
	private String strDeptCombo="";
    private String strUnitCombo="";
    private String strPrescBy="";
    private String strPrescFor="";
    private String strStoreId="";
    private String strStoreTypeId="";
    private String strCrNo="";
    private String[] itemParamValue = {""};
	private String[] strIssuedQty ={""};
	private String[] strUnitName={""};
	private String strRemarks = "";
	private String strEmpNo="";
	private String strTempEmpNo ="";
	/********Trans Variable Start from here*********/
	private WebRowSet strDummyWs = null;
	private WebRowSet strDummyWs1 = null;
	private String strStoreNameCmb="";
	private String strItemCategoryCmb="";
	public String getStrErr() {
		return strErr;
	}
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}
	public String getStrMsg() {
		return strMsg;
	}
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}
	public String getStrWarning() {
		return strWarning;
	}
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}
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
	public String getStrErrMsg() {
		return strErrMsg;
	}
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrGroupId() {
		return strGroupId;
	}
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}
	
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getStrPOType() {
		return strPOType;
	}
	public void setStrPOType(String strPOType) {
		this.strPOType = strPOType;
	}
	public String getStrIndentNo() {
		return strIndentNo;
	}
	public void setStrIndentNo(String strIndentNo) {
		this.strIndentNo = strIndentNo;
	}
	public String getStrSupplName() {
		return strSupplName;
	}
	public void setStrSupplName(String strSupplName) {
		this.strSupplName = strSupplName;
	}
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String getStrItemCategory() {
		return strItemCategory;
	}
	public void setStrItemCategory(String strItemCategory) {
		this.strItemCategory = strItemCategory;
	}
	public String getStrGroupIdForItemSearch() {
		return strGroupIdForItemSearch;
	}
	public void setStrGroupIdForItemSearch(String strGroupIdForItemSearch) {
		this.strGroupIdForItemSearch = strGroupIdForItemSearch;
	}
	public String getStrDeptCombo() {
		return strDeptCombo;
	}
	public void setStrDeptCombo(String strDeptCombo) {
		this.strDeptCombo = strDeptCombo;
	}
	public String getStrUnitCombo() {
		return strUnitCombo;
	}
	public void setStrUnitCombo(String strUnitCombo) {
		this.strUnitCombo = strUnitCombo;
	}
	public String getStrPrescBy() {
		return strPrescBy;
	}
	public void setStrPrescBy(String strPrescBy) {
		this.strPrescBy = strPrescBy;
	}
	public String getStrPrescFor() {
		return strPrescFor;
	}
	public void setStrPrescFor(String strPrescFor) {
		this.strPrescFor = strPrescFor;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}
	public String getStrCrNo() {
		return strCrNo;
	}
	public void setStrCrNo(String strCrNo) {
		this.strCrNo = strCrNo;
	}
	public String[] getItemParamValue() {
		return itemParamValue;
	}
	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
	}
	public String[] getStrIssuedQty() {
		return strIssuedQty;
	}
	public void setStrIssuedQty(String[] strIssuedQty) {
		this.strIssuedQty = strIssuedQty;
	}
	public String[] getStrUnitName() {
		return strUnitName;
	}
	public void setStrUnitName(String[] strUnitName) {
		this.strUnitName = strUnitName;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public WebRowSet getStrDummyWs() {
		return strDummyWs;
	}
	public void setStrDummyWs(WebRowSet strDummyWs) {
		this.strDummyWs = strDummyWs;
	}
	public String getStrStoreNameCmb() {
		return strStoreNameCmb;
	}
	public void setStrStoreNameCmb(String strStoreNameCmb) {
		this.strStoreNameCmb = strStoreNameCmb;
	}
	public String getStrItemCategoryCmb() {
		return strItemCategoryCmb;
	}
	public void setStrItemCategoryCmb(String strItemCategoryCmb) {
		this.strItemCategoryCmb = strItemCategoryCmb;
	}
	public String getStrReqNo() {
		return strReqNo;
	}
	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
	}
	public String getStrEmpNo() {
		return strEmpNo;
	}
	public void setStrEmpNo(String strEmpNo) {
		this.strEmpNo = strEmpNo;
	}
	public WebRowSet getStrDummyWs1() {
		return strDummyWs1;
	}
	public void setStrDummyWs1(WebRowSet strDummyWs1) {
		this.strDummyWs1 = strDummyWs1;
	}
	public String getStrTempEmpNo() {
		return strTempEmpNo;
	}
	public void setStrTempEmpNo(String strTempEmpNo) {
		this.strTempEmpNo = strTempEmpNo;
	}
	public String getStrCtDate() {
		return strCtDate;
	}
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}

}
