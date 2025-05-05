
package mms.transactions.controller.fb;
/**
 * Developer : Adil Wasi
 * Version   : 1.0
 * Date 	 : 09-Jan-2012
 * Modify Date : 
*/
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class SampleReceiveDetailProcessTransFB extends ActionForm 
{
	private static final long serialVersionUID = 02L;
	private String strNormalMsg = "";
	private String strWarningMsg = "";
    private String strMsgString = "";
	private String strMsgType = "";
	private String strErrMsg = "";

	private String strHospitalCode = "";
	private String strSeatId = "";
	private String hmode;
	private String strCurrentDate;
	
	private String strFromDate="";
	private String strToDate="";
	
	/************Variable Start Here******************/
	private String strViewCheckBox;
	
	private String strDrugWareHouseId;
	private String strDrugWareHouseName;
	private String strDrugWareHouseNameCmb;
	
	
	private WebRowSet wrsDrugWareHouseNameCmb;
	
//	private String strFinancialYearCombo;
//	
//	private String strFinancialYear;
//	private WebRowSet strFinancialYearCmb;
//	
//	private String strCurrentFinancialYear;
//	private String strNextFinancialYear;
//	
	private String strItemCategoryNo;
	private String strItemCatNoCmb;
	private String strIssueNo;
	private String strItemBrandId;
	private String strBatchNo;
	private String strItemSlNo;
	private String strStockStatusCode;
	private String strIssueDate;
	private String strItemID;
	private String strToStoreId;
	private String strExpiryDate;
	private String strIsValid;
	
	
	private String strRemarks;
	private WebRowSet itemCategoryComboWS;
	private String strStoreId;
	
	private String[] strCheckHidValue;
	private String[] strIssueChkIndex;
	private String[] strPrintLabelValue;
	private String strSampleSentDWHId;
	private String strItemBrandID;
	private String strSampleSentDWHCombo;
	private String strItemBrandIDCombo;
	private String[] strBkgQty;

	
	
	public String[] getStrBkgQty() {
		return strBkgQty;
	}
	public void setStrBkgQty(String[] strBkgQty) {
		this.strBkgQty = strBkgQty;
	}
	public String getStrItemBrandIDCombo() {
		return strItemBrandIDCombo;
	}
	public void setStrItemBrandIDCombo(String strItemBrandIDCombo) {
		this.strItemBrandIDCombo = strItemBrandIDCombo;
	}
	public String getStrSampleSentDWHCombo() {
		return strSampleSentDWHCombo;
	}
	public void setStrSampleSentDWHCombo(String strSampleSentDWHCombo) {
		this.strSampleSentDWHCombo = strSampleSentDWHCombo;
	}
	public String getStrItemBrandID() {
		return strItemBrandID;
	}
	public void setStrItemBrandID(String strItemBrandID) {
		this.strItemBrandID = strItemBrandID;
	}
	public String getStrSampleSentDWHId() {
		return strSampleSentDWHId;
	}
	public void setStrSampleSentDWHId(String strSampleSentDWHId) {
		this.strSampleSentDWHId = strSampleSentDWHId;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	/*
	 * Getters And Setters
	 */
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
	
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getHmode() {
		return hmode;
	}
	public void setHmode(String hmode) {
		this.hmode = hmode;
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
	public String getStrViewCheckBox() {
		return strViewCheckBox;
	}
	public void setStrViewCheckBox(String strViewCheckBox) {
		this.strViewCheckBox = strViewCheckBox;
	}
	
	public String getStrDrugWareHouseId() {
		return strDrugWareHouseId;
	}
	public void setStrDrugWareHouseId(String strDrugWareHouseId) {
		this.strDrugWareHouseId = strDrugWareHouseId;
	}
	
	public String getStrDrugWareHouseName() {
		return strDrugWareHouseName;
	}
	public void setStrDrugWareHouseName(String strDrugWareHouseName) {
		this.strDrugWareHouseName = strDrugWareHouseName;
	}
	public String getStrDrugWareHouseNameCmb() {
		return strDrugWareHouseNameCmb;
	}
	public void setStrDrugWareHouseNameCmb(String strDrugWareHouseNameCmb) {
		this.strDrugWareHouseNameCmb = strDrugWareHouseNameCmb;
	}
	
	public WebRowSet getWrsDrugWareHouseNameCmb() {
		return wrsDrugWareHouseNameCmb;
	}
	public void setWrsDrugWareHouseNameCmb(WebRowSet wrsDrugWareHouseNameCmb) {
		this.wrsDrugWareHouseNameCmb = wrsDrugWareHouseNameCmb;
	}
	
	
	
	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}
	public String getStrItemCatNoCmb() {
		return strItemCatNoCmb;
	}
	public void setStrItemCatNoCmb(String strItemCatNoCmb) {
		this.strItemCatNoCmb = strItemCatNoCmb;
	}
	public String getStrIssueNo() {
		return strIssueNo;
	}
	public void setStrIssueNo(String strIssueNo) {
		this.strIssueNo = strIssueNo;
	}
	public String getStrItemBrandId() {
		return strItemBrandId;
	}
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
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
	public String getStrStockStatusCode() {
		return strStockStatusCode;
	}
	public void setStrStockStatusCode(String strStockStatusCode) {
		this.strStockStatusCode = strStockStatusCode;
	}
	public String getStrIssueDate() {
		return strIssueDate;
	}
	public void setStrIssueDate(String strIssueDate) {
		this.strIssueDate = strIssueDate;
	}
	public String getStrItemID() {
		return strItemID;
	}
	public void setStrItemID(String strItemID) {
		this.strItemID = strItemID;
	}
	public String getStrToStoreId() {
		return strToStoreId;
	}
	public void setStrToStoreId(String strToStoreId) {
		this.strToStoreId = strToStoreId;
	}
	public String getStrExpiryDate() {
		return strExpiryDate;
	}
	public void setStrExpiryDate(String strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
	}
	public String getStrIsValid() {
		return strIsValid;
	}
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	
	/**
	 * @return the itemCategoryComboWS
	 */
	public WebRowSet getItemCategoryComboWS() {
		return itemCategoryComboWS;
	}
	/**
	 * @param itemCategoryComboWS the itemCategoryComboWS to set
	 */
	public void setItemCategoryComboWS(WebRowSet itemCategoryComboWS) {
		this.itemCategoryComboWS = itemCategoryComboWS;
	}
	

	public String[] getStrCheckHidValue() {
		return strCheckHidValue;
	}
	public void setStrCheckHidValue(String[] strCheckHidValue) {
		this.strCheckHidValue = strCheckHidValue;
	}
	public String[] getStrIssueChkIndex() {
		return strIssueChkIndex;
	}
	public void setStrIssueChkIndex(String[] strIssueChkIndex) {
		this.strIssueChkIndex = strIssueChkIndex;
	}
	
	public String[] getStrPrintLabelValue() {
		return strPrintLabelValue;
	}
	public void setStrPrintLabelValue(String[] strPrintLabelValue) {
		this.strPrintLabelValue = strPrintLabelValue;
	}
	/*
	 * 	To reset the values on the Add Page
	 */
	public void reset(ActionMapping mapping,HttpServletRequest request)
	{		
		this.setStrDrugWareHouseId("0");
		
	}
}
