package mms.transactions.controller.fb;
import javax.sql.rowset.WebRowSet;



import hisglobal.exceptions.HisException;

import hisglobal.transactionutil.GenericFormBean;
import hisglobal.utility.HisUtil;



public class CondemnationRegisterTransDeskFB extends GenericFormBean 
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
	/************Variable Start Here******************/
	private String strBkgEntryDate ="";
	private String strStoreName = "";
	private WebRowSet GroupWs  =null;
	private String strStoreTypeId = "";
	private String strGroupIdForItemSearch = "";
	private String[] itemParamValue = {""};
	private String[] strBkgQty ={""};
	private String[] strUnitName={""};
	private String strRemarks = "";
	 private String strFinancialStartYear = "";

     private String strFinancialEndYear = "";
	
	
	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	public String getStrGroupIdForItemSearch() {
		return strGroupIdForItemSearch;
	}

	public void setStrGroupIdForItemSearch(String strGroupIdForItemSearch) {
		this.strGroupIdForItemSearch = strGroupIdForItemSearch;
	}

	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}

	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}

	public WebRowSet getGroupWs() {
		return GroupWs;
	}

	public void setGroupWs(WebRowSet groupWs) {
		GroupWs = groupWs;
	}

	public String getStrStoreName() {
		return strStoreName;
	}

	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}

	public String getStrBkgEntryDate() {
		return strBkgEntryDate;
	}

	public void setStrBkgEntryDate(String strBkgEntryDate) {
		this.strBkgEntryDate = strBkgEntryDate;
	}

	/**********Current Date*************/
	public String getStrCtDate() 
	{
		HisUtil util = new HisUtil("Breakge Item Detail Transaction", "BreakgeItemDtlTransFB");
		try {
			strCtDate = util.getASDate("dd-MMM-yyyy");
			util = null;
		} catch (Exception e) {
			new HisException("MMS Module", "Breakge Item Detail Transaction",
					"BreakgeItemDtlTransFB.getStrCtDate()-->" + e.getMessage());
		}
		return strCtDate;

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

	public String getStrErrMsg() {
		return strErrMsg;
	}

	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}

	public String[] getItemParamValue() {
		return itemParamValue;
	}

	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
	}

	public String[] getStrBkgQty() {
		return strBkgQty;
	}

	public void setStrBkgQty(String[] strBkgQty) {
		this.strBkgQty = strBkgQty;
	}

	public String[] getStrUnitName() {
		return strUnitName;
	}

	public void setStrUnitName(String[] strUnitName) {
		this.strUnitName = strUnitName;
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
}
