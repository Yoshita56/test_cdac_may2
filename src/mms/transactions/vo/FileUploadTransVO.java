/**********************************************************
 Project:	   DWH_BIHAR	
 File:         ProjectedDemandRequestTransVO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.vo;

import hisglobal.utility.TransferObject;

import javax.sql.rowset.WebRowSet;

import org.apache.struts.upload.FormFile;

// TODO: Auto-generated Javadoc
/**
 * The Class ProjectedDemandRequestTransVO.
 */
public class FileUploadTransVO implements TransferObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The str err. */
	private String strErr = "";

	/** The str warning. */
	private String strWarning = "";

	/** The str normal msg. */
	private String strNormalMsg = "";

	/** The str group id. */
	private String strGroupId = "";

	/** The str msg string. */
	private String strMsgString = "";

	/** The str msg type. */
	private String strMsgType = "0";

	/** The str hospital code. */
	private String strHospitalCode = "";

	/** The str ct date. */
	private String strCtDate = "";

	/** The str seat id. */
	private String strSeatId = "";

	/** The str remarks. */
	private String strRemarks = "";

	/** The str indent period value. */
	private String strIndentPeriodValue;

	/** The str indent period value combo. */
	private String strIndentPeriodValueCombo;

	/** The str drug name. */
	private String strDrugName = "";

	/** The str drug search combo. */
	private String strDrugSearchCombo;

	/** The str left item ids. */
	private String[] strLeftItemIds = null;

	/** The str left item list. */
	private String strLeftItemList = "";

	/** The str right item ids. */
	private String[] strRightItemIds = null;

	/** The str right item list. */
	private String strRightItemList = "";

	/** The str item brand id. */
	private String strItemBrandId = "0";

	/** The str alphbet. */
	private String strAlphabet = "";
	
	private String strProgName = "";
	private String strProgSearchCombo;
	private String strLeftProgIds[] = null;
	private String strLeftProgList = "";
	private String strRightProgIds[] = null;
	private String strRightProgList = "";
	

	private String strDrugClassCode = "";
	private String strDrugClassVal = "";
	
	private String strWhetherDateConstraint = "0";
	private String strWhetherDateConstraintValue = "0";

	private String strWhetherProgConstraint = "0";
	private String strWhetherProgConstraintValue = "0";
	
	private String strWhetherItemConstraint = "0";
	private String strWhetherItemConstraintValue = "0";

	/** The str drug ws. */
	private WebRowSet strDrugWs = null;

	private String strReqTypeCombo;
	private String strDrugClass;
	private WebRowSet drugClassWs= null;	
	private WebRowSet wrsData= null;
	
	private String strMode;
	private String strNotificationNo;
	
	private WebRowSet indentItemWS= null;
	private WebRowSet wbsProgrammeDtl= null;
	private String strStoreId;
	private String strReqType;
	private String strLastDate;
	private String strExtendLastDate;
    private String strDeamandQuater="0";
    private String strFileNo;
    private String strPageNo;
    private String strFileName;
    private FormFile strLocation = null;
	private String strGetNames ="";
	private String strFinacialYear="";
	
	private String strFinancialYearCombo="";
	private String strQuarterPeriod="";
	private String strBudgetClassCmb="";
	private String strProgrammeCmb="";
	private String strFundSourceCmb="";
	private String strDistrictCmb="";
	private String strDWHSubTypeCmb="";
	private String strAllocatedBudget="0.00";
	private String strAvailableBudget="0.00";
	
	
	private String strAllocatedRealizedBudget="0.00";
	private String strAvailableRealizedBudget="0.00";
	private String strAvailableLocalBudget="0.00";
	private String strAvailableCentralBudget="0.00";
	
    private String[] strHtmlCodeHidden = { "" };
    private String strDcsBudget="";
	
	
	public String[] getStrHtmlCodeHidden() {
		return strHtmlCodeHidden;
	}
	public void setStrHtmlCodeHidden(String[] strHtmlCodeHidden) {
		this.strHtmlCodeHidden = strHtmlCodeHidden;
	}
	private WebRowSet strBudgetDtl= null;
	
	public WebRowSet getStrBudgetDtl() {
		return strBudgetDtl;
	}
	public void setStrBudgetDtl(WebRowSet strBudgetDtl) {
		this.strBudgetDtl = strBudgetDtl;
	}
	public String getStrFinancialYearCombo() {
		return strFinancialYearCombo;
	}
	public void setStrFinancialYearCombo(String strFinancialYearCombo) {
		this.strFinancialYearCombo = strFinancialYearCombo;
	}
	public String getStrQuarterPeriod() {
		return strQuarterPeriod;
	}
	public void setStrQuarterPeriod(String strQuarterPeriod) {
		this.strQuarterPeriod = strQuarterPeriod;
	}
	public String getStrBudgetClassCmb() {
		return strBudgetClassCmb;
	}
	public void setStrBudgetClassCmb(String strBudgetClassCmb) {
		this.strBudgetClassCmb = strBudgetClassCmb;
	}
	public String getStrProgrammeCmb() {
		return strProgrammeCmb;
	}
	public void setStrProgrammeCmb(String strProgrammeCmb) {
		this.strProgrammeCmb = strProgrammeCmb;
	}
	public String getStrFundSourceCmb() {
		return strFundSourceCmb;
	}
	public void setStrFundSourceCmb(String strFundSourceCmb) {
		this.strFundSourceCmb = strFundSourceCmb;
	}
	public String getStrDistrictCmb() {
		return strDistrictCmb;
	}
	public void setStrDistrictCmb(String strDistrictCmb) {
		this.strDistrictCmb = strDistrictCmb;
	}
	public String getStrDWHSubTypeCmb() {
		return strDWHSubTypeCmb;
	}
	public void setStrDWHSubTypeCmb(String strDWHSubTypeCmb) {
		this.strDWHSubTypeCmb = strDWHSubTypeCmb;
	}
	public String getStrAllocatedBudget() {
		return strAllocatedBudget;
	}
	public void setStrAllocatedBudget(String strAllocatedBudget) {
		this.strAllocatedBudget = strAllocatedBudget;
	}
	public String getStrAvailableBudget() {
		return strAvailableBudget;
	}
	public void setStrAvailableBudget(String strAvailableBudget) {
		this.strAvailableBudget = strAvailableBudget;
	}
	
	public String getStrFinacialYear() {
		return strFinacialYear;
	}
	public void setStrFinacialYear(String strFinacialYear) {
		this.strFinacialYear = strFinacialYear;
	}
	
	public String getStrGetNames() {
		return strGetNames;
	}
	public void setStrGetNames(String strGetNames) {
		this.strGetNames = strGetNames;
	}
	public FormFile getStrLocation() {
		return strLocation;
	}
	public void setStrLocation(FormFile strLocation) {
		this.strLocation = strLocation;
	}
	public String getStrFileName() {
		return strFileName;
	}
	public void setStrFileName(String strFileName) {
		this.strFileName = strFileName;
	}
	public String getStrPageNo() {
		return strPageNo;
	}
	public void setStrPageNo(String strPageNo) {
		this.strPageNo = strPageNo;
	}
	public String getStrFileNo() {
		return strFileNo;
	}
	public void setStrFileNo(String strFileNo) {
		this.strFileNo = strFileNo;
	}
	public String getStrDeamandQuater() {
		return strDeamandQuater;
	}
	public void setStrDeamandQuater(String strDeamandQuater) {
		this.strDeamandQuater = strDeamandQuater;
	}
	
	
	public String getStrExtendLastDate() {
		return strExtendLastDate;
	}
	public void setStrExtendLastDate(String strExtendLastDate) {
		this.strExtendLastDate = strExtendLastDate;
	}
	public String getStrErr() {
		return strErr;
	}
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}
	public String getStrWarning() {
		return strWarning;
	}
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}
	public String getStrNormalMsg() {
		return strNormalMsg;
	}
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}
	public String getStrGroupId() {
		return strGroupId;
	}
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
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
	public String getStrCtDate() {
		return strCtDate;
	}
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrIndentPeriodValue() {
		return strIndentPeriodValue;
	}
	public void setStrIndentPeriodValue(String strIndentPeriodValue) {
		this.strIndentPeriodValue = strIndentPeriodValue;
	}
	public String getStrIndentPeriodValueCombo() {
		return strIndentPeriodValueCombo;
	}
	public void setStrIndentPeriodValueCombo(String strIndentPeriodValueCombo) {
		this.strIndentPeriodValueCombo = strIndentPeriodValueCombo;
	}
	public String getStrDrugName() {
		return strDrugName;
	}
	public void setStrDrugName(String strDrugName) {
		this.strDrugName = strDrugName;
	}
	public String getStrDrugSearchCombo() {
		return strDrugSearchCombo;
	}
	public void setStrDrugSearchCombo(String strDrugSearchCombo) {
		this.strDrugSearchCombo = strDrugSearchCombo;
	}
	public String[] getStrLeftItemIds() {
		return strLeftItemIds;
	}
	public void setStrLeftItemIds(String[] strLeftItemIds) {
		this.strLeftItemIds = strLeftItemIds;
	}
	public String getStrLeftItemList() {
		return strLeftItemList;
	}
	public void setStrLeftItemList(String strLeftItemList) {
		this.strLeftItemList = strLeftItemList;
	}
	public String[] getStrRightItemIds() {
		return strRightItemIds;
	}
	public void setStrRightItemIds(String[] strRightItemIds) {
		this.strRightItemIds = strRightItemIds;
	}
	public String getStrRightItemList() {
		return strRightItemList;
	}
	public void setStrRightItemList(String strRightItemList) {
		this.strRightItemList = strRightItemList;
	}
	public String getStrItemBrandId() {
		return strItemBrandId;
	}
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}
	public String getStrAlphabet() {
		return strAlphabet;
	}
	public void setStrAlphabet(String strAlphabet) {
		this.strAlphabet = strAlphabet;
	}
	public String getStrProgName() {
		return strProgName;
	}
	public void setStrProgName(String strProgName) {
		this.strProgName = strProgName;
	}
	public String getStrProgSearchCombo() {
		return strProgSearchCombo;
	}
	public void setStrProgSearchCombo(String strProgSearchCombo) {
		this.strProgSearchCombo = strProgSearchCombo;
	}
	public String[] getStrLeftProgIds() {
		return strLeftProgIds;
	}
	public void setStrLeftProgIds(String[] strLeftProgIds) {
		this.strLeftProgIds = strLeftProgIds;
	}
	public String getStrLeftProgList() {
		return strLeftProgList;
	}
	public void setStrLeftProgList(String strLeftProgList) {
		this.strLeftProgList = strLeftProgList;
	}
	public String[] getStrRightProgIds() {
		return strRightProgIds;
	}
	public void setStrRightProgIds(String[] strRightProgIds) {
		this.strRightProgIds = strRightProgIds;
	}
	public String getStrRightProgList() {
		return strRightProgList;
	}
	public void setStrRightProgList(String strRightProgList) {
		this.strRightProgList = strRightProgList;
	}
	public String getStrDrugClassCode() {
		return strDrugClassCode;
	}
	public void setStrDrugClassCode(String strDrugClassCode) {
		this.strDrugClassCode = strDrugClassCode;
	}
	public String getStrDrugClassVal() {
		return strDrugClassVal;
	}
	public void setStrDrugClassVal(String strDrugClassVal) {
		this.strDrugClassVal = strDrugClassVal;
	}
	public String getStrWhetherDateConstraint() {
		return strWhetherDateConstraint;
	}
	public void setStrWhetherDateConstraint(String strWhetherDateConstraint) {
		this.strWhetherDateConstraint = strWhetherDateConstraint;
	}
	public String getStrWhetherDateConstraintValue() {
		return strWhetherDateConstraintValue;
	}
	public void setStrWhetherDateConstraintValue(
			String strWhetherDateConstraintValue) {
		this.strWhetherDateConstraintValue = strWhetherDateConstraintValue;
	}
	public String getStrWhetherProgConstraint() {
		return strWhetherProgConstraint;
	}
	public void setStrWhetherProgConstraint(String strWhetherProgConstraint) {
		this.strWhetherProgConstraint = strWhetherProgConstraint;
	}
	public String getStrWhetherProgConstraintValue() {
		return strWhetherProgConstraintValue;
	}
	public void setStrWhetherProgConstraintValue(
			String strWhetherProgConstraintValue) {
		this.strWhetherProgConstraintValue = strWhetherProgConstraintValue;
	}
	public String getStrWhetherItemConstraint() {
		return strWhetherItemConstraint;
	}
	public void setStrWhetherItemConstraint(String strWhetherItemConstraint) {
		this.strWhetherItemConstraint = strWhetherItemConstraint;
	}
	public String getStrWhetherItemConstraintValue() {
		return strWhetherItemConstraintValue;
	}
	public void setStrWhetherItemConstraintValue(
			String strWhetherItemConstraintValue) {
		this.strWhetherItemConstraintValue = strWhetherItemConstraintValue;
	}
	public WebRowSet getStrDrugWs() {
		return strDrugWs;
	}
	public void setStrDrugWs(WebRowSet strDrugWs) {
		this.strDrugWs = strDrugWs;
	}
	public String getStrReqTypeCombo() {
		return strReqTypeCombo;
	}
	public void setStrReqTypeCombo(String strReqTypeCombo) {
		this.strReqTypeCombo = strReqTypeCombo;
	}
	public String getStrDrugClass() {
		return strDrugClass;
	}
	public void setStrDrugClass(String strDrugClass) {
		this.strDrugClass = strDrugClass;
	}
	public WebRowSet getDrugClassWs() {
		return drugClassWs;
	}
	public void setDrugClassWs(WebRowSet drugClassWs) {
		this.drugClassWs = drugClassWs;
	}
	public WebRowSet getWrsData() {
		return wrsData;
	}
	public void setWrsData(WebRowSet wrsData) {
		this.wrsData = wrsData;
	}
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
	public String getStrNotificationNo() {
		return strNotificationNo;
	}
	public void setStrNotificationNo(String strNotificationNo) {
		this.strNotificationNo = strNotificationNo;
	}
	public WebRowSet getIndentItemWS() {
		return indentItemWS;
	}
	public void setIndentItemWS(WebRowSet indentItemWS) {
		this.indentItemWS = indentItemWS;
	}
	public WebRowSet getWbsProgrammeDtl() {
		return wbsProgrammeDtl;
	}
	public void setWbsProgrammeDtl(WebRowSet wbsProgrammeDtl) {
		this.wbsProgrammeDtl = wbsProgrammeDtl;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrReqType() {
		return strReqType;
	}
	public void setStrReqType(String strReqType) {
		this.strReqType = strReqType;
	}
	public String getStrLastDate() {
		return strLastDate;
	}
	public void setStrLastDate(String strLastDate) {
		this.strLastDate = strLastDate;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getStrAllocatedRealizedBudget() {
		return strAllocatedRealizedBudget;
	}
	public void setStrAllocatedRealizedBudget(String strAllocatedRealizedBudget) {
		this.strAllocatedRealizedBudget = strAllocatedRealizedBudget;
	}
	public String getStrAvailableRealizedBudget() {
		return strAvailableRealizedBudget;
	}
	public void setStrAvailableRealizedBudget(String strAvailableRealizedBudget) {
		this.strAvailableRealizedBudget = strAvailableRealizedBudget;
	}
	public String getStrAvailableLocalBudget() {
		return strAvailableLocalBudget;
	}
	public void setStrAvailableLocalBudget(String strAvailableLocalBudget) {
		this.strAvailableLocalBudget = strAvailableLocalBudget;
	}
	public String getStrAvailableCentralBudget() {
		return strAvailableCentralBudget;
	}
	public void setStrAvailableCentralBudget(String strAvailableCentralBudget) {
		this.strAvailableCentralBudget = strAvailableCentralBudget;
	}
	public String getStrDcsBudget() {
		return strDcsBudget;
	}
	public void setStrDcsBudget(String strDcsBudget) {
		this.strDcsBudget = strDcsBudget;
	}
	
		
}