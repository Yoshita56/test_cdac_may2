package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;
/**
 * Developer : Pramod Kumar Mehta 
 * Version : 1.0 
 * Date : 23/Jan/2009
 *  Module:MMS
 * Unit:Set/Sachet Details
 *
 */


public class IndentApprovalApproveTransFB extends ActionForm {

	private static final long serialVersionUID = 02L;

	private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
	
	private String strCtDate = "";
	private String strHospitalCode = "";
	private String strIsValid = "";
	private String strSetSachetNo = "";
	private String strSeatId = "";
	private String strSetId="";
	private String strBatchNo="";
	private String strItemSlNo="";
	private String strStoreId="";
	private String strStoreNameValues="";
	private String strPreparedDate="";
	private String strFinancialStartYear="";
	private String strFinancialEndYear="";
	private String strGroupId="";
	private String strGroupNameValues="";
	
	private String strSubGroupId="";
	private String strSubGroupNameValues="";
	private String strSetSachetId="";
	private String strSetSachetNameValues="";
	private String strItemName="";
	private String strBrandName="";
	private String strReqQty="";
	private String strAvlQty="";
	private String strUsedQty="";
	private String strUnitNameValues="";
	private String strUnitId="";
	private String strPreparedQty="";
	private String strBachNO="";
	private String strExpiryDate="";
	private String strSerialNo="";
	private String selectedChkValue="";
	private String strRemarks="";
	private String strUsedQty1[]=null;
	private String strItemDetailsChk[]=null;
	private String strUsedUnitId1[]=null;
	private String strBrandId[]=null;
	
	
	
	public String[] getStrBrandId() {
		return strBrandId;
	}
	public void setStrBrandId(String[] strBrandId) {
		this.strBrandId = strBrandId;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
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
	public String getStrCtDate() {
		return strCtDate;
	}
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrIsValid() {
		return strIsValid;
	}
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}
	public String getStrSetSachetNo() {
		return strSetSachetNo;
	}
	public void setStrSetSachetNo(String strSetSachetNo) {
		this.strSetSachetNo = strSetSachetNo;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getStrSetId() {
		return strSetId;
	}
	public void setStrSetId(String strSetId) {
		this.strSetId = strSetId;
	}
	public String getStrBatchNo() {
		return strBatchNo;
	}
	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}
	public String getStrItemSlNo() {
		return strItemSlNo;
	}
	public void setStrItemSlNo(String strItemSlNo) {
		this.strItemSlNo = strItemSlNo;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrStoreNameValues() {
		return strStoreNameValues;
	}
	public void setStrStoreNameValues(String strStoreNameValues) {
		this.strStoreNameValues = strStoreNameValues;
	}
	public String getStrPreparedDate() {
		return strPreparedDate;
	}
	public void setStrPreparedDate(String strPreparedDate) {
		this.strPreparedDate = strPreparedDate;
	}
	public String getStrFinancialStartYear() {
		return strFinancialStartYear;
	}
	public void setStrFinancialStartYear(String strFinancialStartYear) {
		this.strFinancialStartYear = strFinancialStartYear;
	}
	public String getStrFinancialEndYear() {
		return strFinancialEndYear;
	}
	public void setStrFinancialEndYear(String strFinancialEndYear) {
		this.strFinancialEndYear = strFinancialEndYear;
	}
	public String getStrGroupId() {
		return strGroupId;
	}
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}
	public String getStrGroupNameValues() {
		return strGroupNameValues;
	}
	public void setStrGroupNameValues(String strGroupNameValues) {
		this.strGroupNameValues = strGroupNameValues;
	}
	public String getStrSubGroupId() {
		return strSubGroupId;
	}
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}
	public String getStrSubGroupNameValues() {
		return strSubGroupNameValues;
	}
	public void setStrSubGroupNameValues(String strSubGroupNameValues) {
		this.strSubGroupNameValues = strSubGroupNameValues;
	}
	public String getStrSetSachetNameValues() {
		return strSetSachetNameValues;
	}
	public void setStrSetSachetNameValues(String strSetSachetNameValues) {
		this.strSetSachetNameValues = strSetSachetNameValues;
	}
	public String getStrItemName() {
		return strItemName;
	}
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}
	public String getStrBrandName() {
		return strBrandName;
	}
	public void setStrBrandName(String strBrandName) {
		this.strBrandName = strBrandName;
	}
	public String getStrReqQty() {
		return strReqQty;
	}
	public void setStrReqQty(String strReqQty) {
		this.strReqQty = strReqQty;
	}
	public String getStrAvlQty() {
		return strAvlQty;
	}
	public void setStrAvlQty(String strAvlQty) {
		this.strAvlQty = strAvlQty;
	}
	public String getStrUsedQty() {
		return strUsedQty;
	}
	public void setStrUsedQty(String strUsedQty) {
		this.strUsedQty = strUsedQty;
	}
	
	public String getStrPreparedQty() {
		return strPreparedQty;
	}
	public void setStrPreparedQty(String strPreparedQty) {
		this.strPreparedQty = strPreparedQty;
	}
	public String getStrBachNO() {
		return strBachNO;
	}
	public void setStrBachNO(String strBachNO) {
		this.strBachNO = strBachNO;
	}
	public String getStrExpiryDate() {
		return strExpiryDate;
	}
	public void setStrExpiryDate(String strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
	}
	public String getStrSerialNo() {
		return strSerialNo;
	}
	public void setStrSerialNo(String strSerialNo) {
		this.strSerialNo = strSerialNo;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getStrSetSachetId() {
		return strSetSachetId;
	}
	public void setStrSetSachetId(String strSetSachetId) {
		this.strSetSachetId = strSetSachetId;
	}
	public String getStrUnitId() {
		return strUnitId;
	}
	public void setStrUnitId(String strUnitId) {
		this.strUnitId = strUnitId;
	}
	public String getStrUnitNameValues() {
		return strUnitNameValues;
	}
	public void setStrUnitNameValues(String strUnitNameValues) {
		this.strUnitNameValues = strUnitNameValues;
	}
	
	public String[] getStrUsedQty1() {
		return strUsedQty1;
	}
	public void setStrUsedQty1(String[] strUsedQty1) {
		this.strUsedQty1 = strUsedQty1;
	}
	public String getSelectedChkValue() {
		return selectedChkValue;
	}
	public void setSelectedChkValue(String selectedChkValue) {
		this.selectedChkValue = selectedChkValue;
	}
	public String[] getStrItemDetailsChk() {
		return strItemDetailsChk;
	}
	public void setStrItemDetailsChk(String[] strItemDetailsChk) {
		this.strItemDetailsChk = strItemDetailsChk;
	}
	public String[] getStrUsedUnitId1() {
		return strUsedUnitId1;
	}
	public void setStrUsedUnitId1(String[] strUsedUnitId1) {
		this.strUsedUnitId1 = strUsedUnitId1;
	}
	
	
	
	

}
