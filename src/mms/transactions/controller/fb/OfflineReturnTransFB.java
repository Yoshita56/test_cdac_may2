package mms.transactions.controller.fb;
/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 16/Sep/2010
 *  
*/
import javax.sql.rowset.WebRowSet;

import org.apache.struts.action.ActionForm;

public class OfflineReturnTransFB extends ActionForm 
{
	private static final long serialVersionUID = 02L;
	private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
    private String strMsgString = "";
	private String strMsgType = "";
	private String strErrMsg = "";

	private String strHospitalCode = "";
	private String strGroupId = "";
	private String strCtDate = "";
	private String strSeatId = "";
	private String strViewChk="";
	/************Variable Start Here******************/
	private String strVerifiedBy;
    private String strReturnNo="0";
	private String strIssueNo="0";
	private String strIsView;
    private String strFromDate;
	private String strToDate;
	private String isNormal ="0";
	private String strItemCatgCombo = "";
	private String strStoreId = "";
	private String strStoreName = "";
	private WebRowSet GroupWs  =null;
	private String strStoreTypeId = "";
	private String strRemarks = "";
	private String strFinancialStartYear = "";
	private String strApprovedBy="";
	private String strAprovedRemarks="";
	private String strApprovedByValues="";
	private String strCurrentDate="";
	private String strApprovedDate="";
    private String strFinancialEndYear = "";
    private String strTmpIssueNo="0";
    private String  strIndentingStoreID;
    private String  strIndentingStoreName;
    private String  strIndentType;
    private String  strIndentPeriodCombo;
    private String  strIndentPeriodValue;
    private String  strIndentNo;
    private String  strIndentDate;
    private String  strReceivedBy;
    private String  strApprovalDate;
    private String  strVerifiedByValues;
    private String  strVerifiedDate;
    private String  strTmpStoreNo;
    private String[] itemParamValue = {""};
	private String[] strUnitName={""};
	private String[] strReturnQty ={""};
	private String[] strReqQty ={""};
	private String[] strAvlQty ={"0"};
	private String strBudgetFlg="0";
	private String strNewDemandFinalApproxAmt="0";
	private String strReOrderFlgColor;
    
	
	public String getStrReOrderFlgColor() {
		return strReOrderFlgColor;
	}
	public void setStrReOrderFlgColor(String strReOrderFlgColor) {
		this.strReOrderFlgColor = strReOrderFlgColor;
	}
	/************Variable END Here******************/
    
	public String getStrBudgetFlg() {
		return strBudgetFlg;
	}
	public void setStrBudgetFlg(String strBudgetFlg) {
		this.strBudgetFlg = strBudgetFlg;
	}
	/**
	 * @return the strAvlQty
	 */
	public String[] getStrAvlQty() {
		return strAvlQty;
	}
	/**
	 * @param strAvlQty the strAvlQty to set
	 */
	public void setStrAvlQty(String[] strAvlQty) {
		this.strAvlQty = strAvlQty;
	}
	/**
	 * @return the strErr
	 */
	public String getStrErr() {
		return strErr;
	}
	/**
	 * @param strErr the strErr to set
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}
	/**
	 * @return the strMsg
	 */
	public String getStrMsg() {
		return strMsg;
	}
	/**
	 * @param strMsg the strMsg to set
	 */
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}
	/**
	 * @return the strWarning
	 */
	public String getStrWarning() {
		return strWarning;
	}
	/**
	 * @param strWarning the strWarning to set
	 */
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}
	/**
	 * @return the strMsgString
	 */
	public String getStrMsgString() {
		return strMsgString;
	}
	/**
	 * @param strMsgString the strMsgString to set
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}
	/**
	 * @return the strMsgType
	 */
	public String getStrMsgType() {
		return strMsgType;
	}
	/**
	 * @param strMsgType the strMsgType to set
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
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
	 * @return the strGroupId
	 */
	public String getStrGroupId() {
		return strGroupId;
	}
	/**
	 * @param strGroupId the strGroupId to set
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}
	/**
	 * @return the strCtDate
	 */
	public String getStrCtDate() {
		return strCtDate;
	}
	/**
	 * @param strCtDate the strCtDate to set
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
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
	 * @return the strViewChk
	 */
	public String getStrViewChk() {
		return strViewChk;
	}
	/**
	 * @param strViewChk the strViewChk to set
	 */
	public void setStrViewChk(String strViewChk) {
		this.strViewChk = strViewChk;
	}
	/**
	 * @return the strItemCatgCombo
	 */
	public String getStrItemCatgCombo() {
		return strItemCatgCombo;
	}
	/**
	 * @param strItemCatgCombo the strItemCatgCombo to set
	 */
	public void setStrItemCatgCombo(String strItemCatgCombo) {
		this.strItemCatgCombo = strItemCatgCombo;
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
	/**
	 * @return the strStoreName
	 */
	public String getStrStoreName() {
		return strStoreName;
	}
	/**
	 * @param strStoreName the strStoreName to set
	 */
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	/**
	 * @return the groupWs
	 */
	public WebRowSet getGroupWs() {
		return GroupWs;
	}
	/**
	 * @param groupWs the groupWs to set
	 */
	public void setGroupWs(WebRowSet groupWs) {
		GroupWs = groupWs;
	}
	/**
	 * @return the strStoreTypeId
	 */
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}
	/**
	 * @param strStoreTypeId the strStoreTypeId to set
	 */
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}
	/**
	 * @return the strRemarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}
	/**
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	/**
	 * @return the strFinancialStartYear
	 */
	public String getStrFinancialStartYear() {
		return strFinancialStartYear;
	}
	/**
	 * @param strFinancialStartYear the strFinancialStartYear to set
	 */
	public void setStrFinancialStartYear(String strFinancialStartYear) {
		this.strFinancialStartYear = strFinancialStartYear;
	}
	/**
	 * @return the strApprovedBy
	 */
	public String getStrApprovedBy() {
		return strApprovedBy;
	}
	/**
	 * @param strApprovedBy the strApprovedBy to set
	 */
	public void setStrApprovedBy(String strApprovedBy) {
		this.strApprovedBy = strApprovedBy;
	}
	/**
	 * @return the strAprovedRemarks
	 */
	public String getStrAprovedRemarks() {
		return strAprovedRemarks;
	}
	/**
	 * @param strAprovedRemarks the strAprovedRemarks to set
	 */
	public void setStrAprovedRemarks(String strAprovedRemarks) {
		this.strAprovedRemarks = strAprovedRemarks;
	}
	/**
	 * @return the strApprovedByValues
	 */
	public String getStrApprovedByValues() {
		return strApprovedByValues;
	}
	/**
	 * @param strApprovedByValues the strApprovedByValues to set
	 */
	public void setStrApprovedByValues(String strApprovedByValues) {
		this.strApprovedByValues = strApprovedByValues;
	}
	/**
	 * @return the strCurrentDate
	 */
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	/**
	 * @param strCurrentDate the strCurrentDate to set
	 */
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}
	/**
	 * @return the strApprovedDate
	 */
	public String getStrApprovedDate() {
		return strApprovedDate;
	}
	/**
	 * @param strApprovedDate the strApprovedDate to set
	 */
	public void setStrApprovedDate(String strApprovedDate) {
		this.strApprovedDate = strApprovedDate;
	}
	/**
	 * @return the strFinancialEndYear
	 */
	public String getStrFinancialEndYear() {
		return strFinancialEndYear;
	}
	/**
	 * @param strFinancialEndYear the strFinancialEndYear to set
	 */
	public void setStrFinancialEndYear(String strFinancialEndYear) {
		this.strFinancialEndYear = strFinancialEndYear;
	}
	/**
	 * @return the isNormal
	 */
	public String getIsNormal() {
		return isNormal;
	}
	/**
	 * @param isNormal the isNormal to set
	 */
	public void setIsNormal(String isNormal) {
		this.isNormal = isNormal;
	}
	/**
	 * @return the strIndentingStoreID
	 */
	public String getStrIndentingStoreID() {
		return strIndentingStoreID;
	}
	/**
	 * @param strIndentingStoreID the strIndentingStoreID to set
	 */
	public void setStrIndentingStoreID(String strIndentingStoreID) {
		this.strIndentingStoreID = strIndentingStoreID;
	}
	/**
	 * @return the strIndentingStoreName
	 */
	public String getStrIndentingStoreName() {
		return strIndentingStoreName;
	}
	/**
	 * @param strIndentingStoreName the strIndentingStoreName to set
	 */
	public void setStrIndentingStoreName(String strIndentingStoreName) {
		this.strIndentingStoreName = strIndentingStoreName;
	}
	/**
	 * @return the strIndentType
	 */
	public String getStrIndentType() {
		return strIndentType;
	}
	/**
	 * @param strIndentType the strIndentType to set
	 */
	public void setStrIndentType(String strIndentType) {
		this.strIndentType = strIndentType;
	}
	/**
	 * @return the strIndentPeriodCombo
	 */
	public String getStrIndentPeriodCombo() {
		return strIndentPeriodCombo;
	}
	/**
	 * @param strIndentPeriodCombo the strIndentPeriodCombo to set
	 */
	public void setStrIndentPeriodCombo(String strIndentPeriodCombo) {
		this.strIndentPeriodCombo = strIndentPeriodCombo;
	}
	/**
	 * @return the strIndentPeriodValue
	 */
	public String getStrIndentPeriodValue() {
		return strIndentPeriodValue;
	}
	/**
	 * @param strIndentPeriodValue the strIndentPeriodValue to set
	 */
	public void setStrIndentPeriodValue(String strIndentPeriodValue) {
		this.strIndentPeriodValue = strIndentPeriodValue;
	}
	/**
	 * @return the strIndentNo
	 */
	public String getStrIndentNo() {
		return strIndentNo;
	}
	/**
	 * @param strIndentNo the strIndentNo to set
	 */
	public void setStrIndentNo(String strIndentNo) {
		this.strIndentNo = strIndentNo;
	}
	/**
	 * @return the strIndentDate
	 */
	public String getStrIndentDate() {
		return strIndentDate;
	}
	/**
	 * @param strIndentDate the strIndentDate to set
	 */
	public void setStrIndentDate(String strIndentDate) {
		this.strIndentDate = strIndentDate;
	}
	/**
	 * @return the strReceivedBy
	 */
	public String getStrReceivedBy() {
		return strReceivedBy;
	}
	/**
	 * @param strReceivedBy the strReceivedBy to set
	 */
	public void setStrReceivedBy(String strReceivedBy) {
		this.strReceivedBy = strReceivedBy;
	}
	/**
	 * @return the strApprovalDate
	 */
	public String getStrApprovalDate() {
		return strApprovalDate;
	}
	/**
	 * @param strApprovalDate the strApprovalDate to set
	 */
	public void setStrApprovalDate(String strApprovalDate) {
		this.strApprovalDate = strApprovalDate;
	}
	/**
	 * @return the strVerifiedByValues
	 */
	public String getStrVerifiedByValues() {
		return strVerifiedByValues;
	}
	/**
	 * @param strVerifiedByValues the strVerifiedByValues to set
	 */
	public void setStrVerifiedByValues(String strVerifiedByValues) {
		this.strVerifiedByValues = strVerifiedByValues;
	}
	/**
	 * @return the strVerifiedDate
	 */
	public String getStrVerifiedDate() {
		return strVerifiedDate;
	}
	/**
	 * @param strVerifiedDate the strVerifiedDate to set
	 */
	public void setStrVerifiedDate(String strVerifiedDate) {
		this.strVerifiedDate = strVerifiedDate;
	}
	
	/**
	 * @return the strFromDate
	 */
	public String getStrFromDate() {
		return strFromDate;
	}
	/**
	 * @param strFromDate the strFromDate to set
	 */
	public void setStrFromDate(String strFromDate) {
		this.strFromDate = strFromDate;
	}
	/**
	 * @return the strToDate
	 */
	public String getStrToDate() {
		return strToDate;
	}
	/**
	 * @param strToDate the strToDate to set
	 */
	public void setStrToDate(String strToDate) {
		this.strToDate = strToDate;
	}
	/**
	 * @return the strIsView
	 */
	public String getStrIsView() {
		return strIsView;
	}
	/**
	 * @param strIsView the strIsView to set
	 */
	public void setStrIsView(String strIsView) {
		this.strIsView = strIsView;
	}
	/**
	 * @return the strIssueNo
	 */
	public String getStrIssueNo() {
		return strIssueNo;
	}
	/**
	 * @param strIssueNo the strIssueNo to set
	 */
	public void setStrIssueNo(String strIssueNo) {
		this.strIssueNo = strIssueNo;
	}
	
	/**
	 * @return the strVerifiedBy
	 */
	public String getStrVerifiedBy() {
		return strVerifiedBy;
	}
	/**
	 * @param strVerifiedBy the strVerifiedBy to set
	 */
	public void setStrVerifiedBy(String strVerifiedBy) {
		this.strVerifiedBy = strVerifiedBy;
	}
	/**
	 * @return the itemParamValue
	 */
	public String[] getItemParamValue() {
		return itemParamValue;
	}
	/**
	 * @param itemParamValue the itemParamValue to set
	 */
	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
	}
	/**
	 * @return the strUnitName
	 */
	public String[] getStrUnitName() {
		return strUnitName;
	}
	/**
	 * @param strUnitName the strUnitName to set
	 */
	public void setStrUnitName(String[] strUnitName) {
		this.strUnitName = strUnitName;
	}
	
	/**
	 * @return the strReqQty
	 */
	public String[] getStrReqQty() {
		return strReqQty;
	}
	/**
	 * @param strReqQty the strReqQty to set
	 */
	public void setStrReqQty(String[] strReqQty) {
		this.strReqQty = strReqQty;
	}
	/**
	 * @return the strTmpStoreNo
	 */
	public String getStrTmpStoreNo() {
		return strTmpStoreNo;
	}
	/**
	 * @param strTmpStoreNo the strTmpStoreNo to set
	 */
	public void setStrTmpStoreNo(String strTmpStoreNo) {
		this.strTmpStoreNo = strTmpStoreNo;
	}
	/**
	 * @return the strReturnQty
	 */
	public String[] getStrReturnQty() {
		return strReturnQty;
	}
	/**
	 * @param strReturnQty the strReturnQty to set
	 */
	public void setStrReturnQty(String[] strReturnQty) {
		this.strReturnQty = strReturnQty;
	}
	/**
	 * @return the strReturnNo
	 */
	public String getStrReturnNo() {
		return strReturnNo;
	}
	/**
	 * @param strReturnNo the strReturnNo to set
	 */
	public void setStrReturnNo(String strReturnNo) {
		this.strReturnNo = strReturnNo;
	}
	public String getStrTmpIssueNo() {
		return strTmpIssueNo;
	}
	public void setStrTmpIssueNo(String strTmpIssueNo) {
		this.strTmpIssueNo = strTmpIssueNo;
	}
	public String getStrNewDemandFinalApproxAmt() {
		return strNewDemandFinalApproxAmt;
	}
	public void setStrNewDemandFinalApproxAmt(String strNewDemandFinalApproxAmt) {
		this.strNewDemandFinalApproxAmt = strNewDemandFinalApproxAmt;
	}
}
