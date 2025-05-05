package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.TransferObject;

public class IssueDeskPrintTransVO implements TransferObject {

	
	private static final long serialVersionUID = 02L;
	
	private String strMsgString = "";
	private String strMsgType = "0";
	
	
	private String strStoreName = "";
	private String strStoreId = "0";
	private String strRaisingReqTypeId= "0";
	private String strRaisingStoreName = "";
	private String strRaisingStoreId = "0";
	private String strRequestDate="";
	private String strReceivedby="";
	private String strCrNo="";
	private String strEmpNo="";
	private String strLpRequestNo="";
	private String strItemCategNo="";
	private String strFinalCost="0";
	private String strHospitalCode = "";
	private String strRequestTypeId="35";
	private String strFinStartDate="";
	private String strFinEndDate="";
	private String strSeatId = "";	
	private String strRemarks = "";
	private String strItemParamValue[]=null;
	private String strEpisodeCode="0";
	private String strAdmissionNo="0";
	private String strWardCode="0";
	private String strVisitNo="0";
	private String strDeptCode="0";
	private String strDeptUnitCode="0";
	private String strDescription="";
	private String strVisitType="0";
	private String strIssueNo="";
	private String strIssueDate="";
	private String strIssueStoreId="";
	private String strBalanceQtUnitId="";
	private String strUnit[]=null;
	private String strBalanceQty[]=null;
	private String strReturnQty[]=null;
	private String itemCost[]=null;
	private String strItemId;
	private WebRowSet brandDtlWs=null;
	private String strCreditLimit;
	private String strCreditLimitBal;
	private String strNewTreatmentcat;
	private String strBillingHiddenValue; 
	private String strSCMIntegrationflg="";
	
	private WebRowSet strStoreWs=null;
	private WebRowSet strRequestTypeWs=null;
	
	private WebRowSet strDataTableWs=null;
	
	private String strStatusCode;
	
	private String strIndentNo = "";
	private String strIndentDate = "";
	private String strIndentType = "";
	private String strItemCategory = "";
	private String strRaisingStore = "";
	private String strReqNo ="";
	private String strReqTypeId = "";	
	private String strIndentName ="";
	private String strToStoreId = "";
	private String strIndentTypeId="";
	
	
	
	
	
	public String getStrIndentNo() {
		return strIndentNo;
	}
	public void setStrIndentNo(String strIndentNo) {
		this.strIndentNo = strIndentNo;
	}
	public String getStrIndentDate() {
		return strIndentDate;
	}
	public void setStrIndentDate(String strIndentDate) {
		this.strIndentDate = strIndentDate;
	}
	public String getStrIndentType() {
		return strIndentType;
	}
	public void setStrIndentType(String strIndentType) {
		this.strIndentType = strIndentType;
	}
	public String getStrItemCategory() {
		return strItemCategory;
	}
	public void setStrItemCategory(String strItemCategory) {
		this.strItemCategory = strItemCategory;
	}
	public String getStrRaisingStore() {
		return strRaisingStore;
	}
	public void setStrRaisingStore(String strRaisingStore) {
		this.strRaisingStore = strRaisingStore;
	}
	public String getStrReqNo() {
		return strReqNo;
	}
	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
	}
	public String getStrReqTypeId() {
		return strReqTypeId;
	}
	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}
	public String getStrIndentName() {
		return strIndentName;
	}
	public void setStrIndentName(String strIndentName) {
		this.strIndentName = strIndentName;
	}
	public String getStrToStoreId() {
		return strToStoreId;
	}
	public void setStrToStoreId(String strToStoreId) {
		this.strToStoreId = strToStoreId;
	}
	public String getStrIndentTypeId() {
		return strIndentTypeId;
	}
	public void setStrIndentTypeId(String strIndentTypeId) {
		this.strIndentTypeId = strIndentTypeId;
	}
	public WebRowSet getStrDataTableWs() {
		return strDataTableWs;
	}
	public void setStrDataTableWs(WebRowSet strDataTableWs) {
		this.strDataTableWs = strDataTableWs;
	}
	public String getStrStatusCode() {
		return strStatusCode;
	}
	public void setStrStatusCode(String strStatusCode) {
		this.strStatusCode = strStatusCode;
	}
	
	
	public WebRowSet getStrRequestTypeWs() {
		return strRequestTypeWs;
	}
	public void setStrRequestTypeWs(WebRowSet strRequestTypeWs) {
		this.strRequestTypeWs = strRequestTypeWs;
	}
	public WebRowSet getStrStoreWs() {
		return strStoreWs;
	}
	public void setStrStoreWs(WebRowSet strStoreWs) {
		this.strStoreWs = strStoreWs;
	}
	public String getStrBillingHiddenValue() {
		return strBillingHiddenValue;
	}
	public void setStrBillingHiddenValue(String strBillingHiddenValue) {
		this.strBillingHiddenValue = strBillingHiddenValue;
	}
	public String getStrNewTreatmentcat() {
		return strNewTreatmentcat;
	}
	public void setStrNewTreatmentcat(String strNewTreatmentcat) {
		this.strNewTreatmentcat = strNewTreatmentcat;
	}
	public WebRowSet getBrandDtlWs() {
		return brandDtlWs;
	}
	public void setBrandDtlWs(WebRowSet brandDtlWs) {
		this.brandDtlWs = brandDtlWs;
	}
	public String getStrItemId() {
		return strItemId;
	}
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}
	private String strIssueQuantity[]=null;
	
	private String strPoNo="";
	private String strPoStoreId="";
	private String strRecommendBy="";
	private String strDeptName="";
	private String strReturnNo="";
	private String strSingleItemDtl="";
	private String stockDtlsId[]=null;
	private String strItemIdArray[]=null;
	private String strBSReqNo; 
	private String strItembrandIdNew[]=null;
	private String strItemIdNew[]=null;
	private String strBatchNoNew[]=null;
	private String strRateNew[]=null;
	public String getStrBSReqNo() {
		return strBSReqNo;
	}
	public void setStrBSReqNo(String strBSReqNo) {
		this.strBSReqNo = strBSReqNo;
	}
	public String[] getStrItemIdArray() {
		return strItemIdArray;
	}
	public void setStrItemIdArray(String[] strItemIdArray) {
		this.strItemIdArray = strItemIdArray;
	}
	public String[] getStockDtlsId() {
		return stockDtlsId;
	}
	public String getStrCreditLimit() {
		return strCreditLimit;
	}
	public void setStrCreditLimit(String strCreditLimit) {
		this.strCreditLimit = strCreditLimit;
	}
	public String getStrCreditLimitBal() {
		return strCreditLimitBal;
	}
	public void setStrCreditLimitBal(String strCreditLimitBal) {
		this.strCreditLimitBal = strCreditLimitBal;
	}
	public void setStockDtlsId(String[] stockDtlsId) {
		this.stockDtlsId = stockDtlsId;
	}
	public String getStrSingleItemDtl() {
		return strSingleItemDtl;
	}
	public void setStrSingleItemDtl(String strSingleItemDtl) {
		this.strSingleItemDtl = strSingleItemDtl;
	}
	public String getStrReturnNo() {
		return strReturnNo;
	}
	public void setStrReturnNo(String strReturnNo) {
		this.strReturnNo = strReturnNo;
	}
	/**
	 * Web row set declaration
	 */
	
	
	private WebRowSet requestItemDtlWS=null;
	private WebRowSet issueItemDtlWS=null;
	private WebRowSet issuedItemDtlWS=null;
	private WebRowSet unitComboWs=null;
	private WebRowSet approvedBy=null;
	private WebRowSet patAccountDtl=null;
	private WebRowSet diagEmpWs=null;
	private WebRowSet strSingleBatchDtlWs=null;
	private String strBSQuantity[]=null;
	private String strBSIndent;
	private String strUrgentFlg;
	private WebRowSet indentLimitWs=null;
	private WebRowSet strPatientCatWs=null;
	private WebRowSet strItemDetailsWs=null;
	private WebRowSet strIndentDetailsWs=null;
	
	
	
	public WebRowSet getStrIndentDetailsWs() {
		return strIndentDetailsWs;
	}
	public void setStrIndentDetailsWs(WebRowSet strIndentDetailsWs) {
		this.strIndentDetailsWs = strIndentDetailsWs;
	}
	public WebRowSet getStrItemDetailsWs() {
		return strItemDetailsWs;
	}
	public void setStrItemDetailsWs(WebRowSet strItemDetailsWs) {
		this.strItemDetailsWs = strItemDetailsWs;
	}
	public WebRowSet getStrPatientCatWs() {
		return strPatientCatWs;
	}
	public void setStrPatientCatWs(WebRowSet strPatientCatWs) {
		this.strPatientCatWs = strPatientCatWs;
	}
	public String getStrUrgentFlg() {
		return strUrgentFlg;
	}
	public WebRowSet getIndentLimitWs() {
		return indentLimitWs;
	}
	public void setIndentLimitWs(WebRowSet indentLimitWs) {
		this.indentLimitWs = indentLimitWs;
	}
	public void setStrUrgentFlg(String strUrgentFlg) {
		this.strUrgentFlg = strUrgentFlg;
	}
			
	public String[] getStrBSQuantity() {
		return strBSQuantity;
	}
	public void setStrBSQuantity(String[] strBSQuantity) {
		this.strBSQuantity = strBSQuantity;
	}
	public String getStrBSIndent() {
		return strBSIndent;
	}
	public void setStrBSIndent(String strBSIndent) {
		this.strBSIndent = strBSIndent;
	}
	
	public WebRowSet getStrSingleBatchDtlWs() {
		return strSingleBatchDtlWs;
	}
	public void setStrSingleBatchDtlWs(WebRowSet strSingleBatchDtlWs) {
		this.strSingleBatchDtlWs = strSingleBatchDtlWs;
	}
	public WebRowSet getDiagEmpWs() {
		return diagEmpWs;
	}
	public void setDiagEmpWs(WebRowSet diagEmpWs) {
		this.diagEmpWs = diagEmpWs;
	}
	public WebRowSet getPatAccountDtl() {
		return patAccountDtl;
	}
	public void setPatAccountDtl(WebRowSet patAccountDtl) {
		this.patAccountDtl = patAccountDtl;
	}
	private String strTreatmentCat=null;
	
	
		
	
	public String getStrTreatmentCat() {
		return strTreatmentCat;
	}
	public void setStrTreatmentCat(String strTreatmentCat) {
		this.strTreatmentCat = strTreatmentCat;
	}
	public String[] getStrIssueQuantity() {
		return strIssueQuantity;
	}
	public void setStrIssueQuantity(String[] strIssueQuantity) {
		this.strIssueQuantity = strIssueQuantity;
	}
	public WebRowSet getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(WebRowSet approvedBy) {
		this.approvedBy = approvedBy;
	}
	public WebRowSet getUnitComboWs() {
		return unitComboWs;
	}
	public void setUnitComboWs(WebRowSet unitComboWs) {
		this.unitComboWs = unitComboWs;
	}
	public WebRowSet getRequestItemDtlWS() {
		return requestItemDtlWS;
	}
	public void setRequestItemDtlWS(WebRowSet requestItemDtlWS) {
		this.requestItemDtlWS = requestItemDtlWS;
	}
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrRaisingStoreName() {
		return strRaisingStoreName;
	}
	public void setStrRaisingStoreName(String strRaisingStoreName) {
		this.strRaisingStoreName = strRaisingStoreName;
	}
	public String getStrRaisingStoreId() {
		return strRaisingStoreId;
	}
	public void setStrRaisingStoreId(String strRaisingStoreId) {
		this.strRaisingStoreId = strRaisingStoreId;
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
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
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
	public String getStrRequestDate() {
		return strRequestDate;
	}
	public void setStrRequestDate(String strRequestDate) {
		this.strRequestDate = strRequestDate;
	}
	public String getStrCrNo() {
		return strCrNo;
	}
	public void setStrCrNo(String strCrNo) {
		this.strCrNo = strCrNo;
	}
	public String getStrEmpNo() {
		return strEmpNo;
	}
	public void setStrEmpNo(String strEmpNo) {
		this.strEmpNo = strEmpNo;
	}
	public String getStrLpRequestNo() {
		return strLpRequestNo;
	}
	public void setStrLpRequestNo(String strLpRequestNo) {
		this.strLpRequestNo = strLpRequestNo;
	}
	public WebRowSet getIssueItemDtlWS() {
		return issueItemDtlWS;
	}
	public void setIssueItemDtlWS(WebRowSet issueItemDtlWS) {
		this.issueItemDtlWS = issueItemDtlWS;
	}
	public String[] getStrItemParamValue() {
		return strItemParamValue;
	}
	public void setStrItemParamValue(String[] strItemParamValue) {
		this.strItemParamValue = strItemParamValue;
	}
	public String getStrItemCategNo() {
		return strItemCategNo;
	}
	public void setStrItemCategNo(String strItemCategNo) {
		this.strItemCategNo = strItemCategNo;
	}
	public String getStrFinalCost() {
		return strFinalCost;
	}
	public void setStrFinalCost(String strFinalCost) {
		this.strFinalCost = strFinalCost;
	}
	public String getStrRequestTypeId() {
		return strRequestTypeId;
	}
	public void setStrRequestTypeId(String strRequestTypeId) {
		this.strRequestTypeId = strRequestTypeId;
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
	public String getStrEpisodeCode() {
		return strEpisodeCode;
	}
	public void setStrEpisodeCode(String strEpisodeCode) {
		this.strEpisodeCode = strEpisodeCode;
	}
	public String getStrAdmissionNo() {
		return strAdmissionNo;
	}
	public void setStrAdmissionNo(String strAdmissionNo) {
		this.strAdmissionNo = strAdmissionNo;
	}
	public String getStrWardCode() {
		return strWardCode;
	}
	public void setStrWardCode(String strWardCode) {
		this.strWardCode = strWardCode;
	}
	public String getStrVisitNo() {
		return strVisitNo;
	}
	public void setStrVisitNo(String strVisitNo) {
		this.strVisitNo = strVisitNo;
	}
	public String getStrDeptCode() {
		return strDeptCode;
	}
	public void setStrDeptCode(String strDeptCode) {
		this.strDeptCode = strDeptCode;
	}
	public String getStrDeptUnitCode() {
		return strDeptUnitCode;
	}
	public void setStrDeptUnitCode(String strDeptUnitCode) {
		this.strDeptUnitCode = strDeptUnitCode;
	}
	public String getStrVisitType() {
		return strVisitType;
	}
	public void setStrVisitType(String strVisitType) {
		this.strVisitType = strVisitType;
	}
	public String getStrReceivedby() {
		return strReceivedby;
	}
	public void setStrReceivedby(String strReceivedby) {
		this.strReceivedby = strReceivedby;
	}
	public String getStrDescription() {
		return strDescription;
	}
	public void setStrDescription(String strDescription) {
		this.strDescription = strDescription;
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
	public String getStrIssueStoreId() {
		return strIssueStoreId;
	}
	public void setStrIssueStoreId(String strIssueStoreId) {
		this.strIssueStoreId = strIssueStoreId;
	}
	public WebRowSet getIssuedItemDtlWS() {
		return issuedItemDtlWS;
	}
	public void setIssuedItemDtlWS(WebRowSet issuedItemDtlWS) {
		this.issuedItemDtlWS = issuedItemDtlWS;
	}
	public String getStrBalanceQtUnitId() {
		return strBalanceQtUnitId;
	}
	public void setStrBalanceQtUnitId(String strBalanceQtUnitId) {
		this.strBalanceQtUnitId = strBalanceQtUnitId;
	}
	public String[] getStrUnit() {
		return strUnit;
	}
	public void setStrUnit(String[] strUnit) {
		this.strUnit = strUnit;
	}
	public String[] getStrBalanceQty() {
		return strBalanceQty;
	}
	public void setStrBalanceQty(String[] strBalanceQty) {
		this.strBalanceQty = strBalanceQty;
	}
	public String[] getStrReturnQty() {
		return strReturnQty;
	}
	public void setStrReturnQty(String[] strReturnQty) {
		this.strReturnQty = strReturnQty;
	}
	public String[] getItemCost() {
		return itemCost;
	}
	public void setItemCost(String[] itemCost) {
		this.itemCost = itemCost;
	}
	public String getStrPoNo() {
		return strPoNo;
	}
	public void setStrPoNo(String strPoNo) {
		this.strPoNo = strPoNo;
	}
	public String getStrPoStoreId() {
		return strPoStoreId;
	}
	public void setStrPoStoreId(String strPoStoreId) {
		this.strPoStoreId = strPoStoreId;
	}
	public String getStrRecommendBy() {
		return strRecommendBy;
	}
	public void setStrRecommendBy(String strRecommendBy) {
		this.strRecommendBy = strRecommendBy;
	}
	public String getStrRaisingReqTypeId() {
		return strRaisingReqTypeId;
	}
	public void setStrRaisingReqTypeId(String strRaisingReqTypeId) {
		this.strRaisingReqTypeId = strRaisingReqTypeId;
	}
	public String getStrDeptName() {
		return strDeptName;
	}
	public void setStrDeptName(String strDeptName) {
		this.strDeptName = strDeptName;
	}
	public String getStrSCMIntegrationflg() {
		return strSCMIntegrationflg;
	}
	public void setStrSCMIntegrationflg(String strSCMIntegrationflg) {
		this.strSCMIntegrationflg = strSCMIntegrationflg;
	}
	public String[] getStrItembrandIdNew() {
		return strItembrandIdNew;
	}
	public void setStrItembrandIdNew(String[] strItembrandIdNew) {
		this.strItembrandIdNew = strItembrandIdNew;
	}
	public String[] getStrItemIdNew() {
		return strItemIdNew;
	}
	public void setStrItemIdNew(String[] strItemIdNew) {
		this.strItemIdNew = strItemIdNew;
	}
	public String[] getStrBatchNoNew() {
		return strBatchNoNew;
	}
	public void setStrBatchNoNew(String[] strBatchNoNew) {
		this.strBatchNoNew = strBatchNoNew;
	}
	public String[] getStrRateNew() {
		return strRateNew;
	}
	public void setStrRateNew(String[] strRateNew) {
		this.strRateNew = strRateNew;
	}

}
