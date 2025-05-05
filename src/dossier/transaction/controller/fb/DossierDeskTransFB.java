package dossier.transaction.controller.fb;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionutil.GenericFormBean;

public class DossierDeskTransFB extends GenericFormBean {

	private static final long serialVersionUID = 02L;
	private String strErr = "";
	private String strWarning = "";
	private String strNormalMsg = "";
	private String strMsg = "";
    private String strMsgString = "";
    private String strMsgType = "";
    private String strErrMsg = "";
    private String strReceivedby="";
	private String strStoreName = "";
	private String strStoreId = "0";
	
	private String strRaisingStoreName = "";
	private String strRaisingStoreId = "0";
	private String strRequestDate="";
	private String strCrNo="";
	private String strFinalCost="0";
	private String strEmpNo="";
	private String strLpRequestNo="";
	private String strHospitalCode = "";
	private String strSeatId = "";	
	private String strRemarks = "";
	private String strPatientDtl="";
	private String strRequestDtl="";
	private String strItemDtls = "";
	private String strRequestItemDtl="";
	private String strRequestTypeId="1";
	private String strIssueItemId="";
	private String strItemParamValue[]=null;
	private String strRaisingReqTypeId="";
	private String strItemCategNo="";
	private String strAdmissionDtlHidVal="";
	private String strPoNo="";
	private String strPoStoreId="";
	private String strIssueNo="";
	private String strIssueDate="";
	private String strIssueStoreId="";
	private String strRecommendByVal="";
	private String strUnit[]=null;
	private String strBalanceQty[]=null;
	private String strReturnQty[]=null;
	private String itemCost[]=null;
	private String strRecommendBy="";
	private String strFlag="1";
	private String strChk="";
	private String strDeptName="";
	private String strPatAccountNo=null;
	private String strPatAccountBal=null;
	private String strReturnNo="";
	private String strSCMIntegration="";
	private String strBSReqNo="0";
	private String strDiagDtl="";
	private String strBudgetFlg="0";
	private String stockDtlsId[]=null;
	private String brandDtlsId[]=null;
	private String strUCReq="";
	private String strBillPaidCat;
	private String strCatgoryCode;
	private String strCreditLimit;
	private String strNewTreatmentcat;
	private String strBillingHiddenValue;
	private String strDossiercat;
	private String strDossiercatValues;
	private String strMode;
	private WebRowSet wsIssueDetails;
	private String strCrno1;
	private String strDossierId;
	private String strServicetype;
	private String strDoseFrqFlg="0";
	private String strItemCatValues;
	private String stritemcat="0";
	private String isBroughtByPatient[]=null;
	private String strQtyText1[]=null;
	private String[] itemParamValue =null;
	private String strSettlementFlag;
	private String strPatientType;
	
	public String getStrPatientType() {
		return strPatientType;
	}
	public void setStrPatientType(String strPatientType) {
		this.strPatientType = strPatientType;
	}
	public String getStrSettlementFlag() {
		return strSettlementFlag;
	}
	public void setStrSettlementFlag(String strSettlementFlag) {
		this.strSettlementFlag = strSettlementFlag;
	}
	public String[] getItemParamValue() {
		return itemParamValue;
	}
	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
	}
	public String[] getIsBroughtByPatient() {
		return isBroughtByPatient;
	}
	public void setIsBroughtByPatient(String[] isBroughtByPatient) {
		this.isBroughtByPatient = isBroughtByPatient;
	}
	public String[] getStrQtyText1() {
		return strQtyText1;
	}
	public void setStrQtyText1(String[] strQtyText1) {
		this.strQtyText1 = strQtyText1;
	}
	public String getStrItemCatValues() {
		return strItemCatValues;
	}
	public void setStrItemCatValues(String strItemCatValues) {
		this.strItemCatValues = strItemCatValues;
	}
	public String getStritemcat() {
		return stritemcat;
	}
	public void setStritemcat(String stritemcat) {
		this.stritemcat = stritemcat;
	}
	public String getStrDoseFrqFlg() {
		return strDoseFrqFlg;
	}
	public void setStrDoseFrqFlg(String strDoseFrqFlg) {
		this.strDoseFrqFlg = strDoseFrqFlg;
	}
	public String getStrDossierId() {
		return strDossierId;
	}
	public void setStrDossierId(String strDossierId) {
		this.strDossierId = strDossierId;
	}
	public String getStrServicetype() {
		return strServicetype;
	}
	public void setStrServicetype(String strServicetype) {
		this.strServicetype = strServicetype;
	}
	public String getStrCrno1() {
		return strCrno1;
	}
	public void setStrCrno1(String strCrno1) {
		this.strCrno1 = strCrno1;
	}
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
	public WebRowSet getWsIssueDetails() {
		return wsIssueDetails;
	}
	public void setWsIssueDetails(WebRowSet wsIssueDetails) {
		this.wsIssueDetails = wsIssueDetails;
	}
	public String getStrPatientName() {
		return strPatientName;
	}
	public void setStrPatientName(String strPatientName) {
		this.strPatientName = strPatientName;
	}
	public String getPrintReq() {
		return printReq;
	}
	public void setPrintReq(String printReq) {
		this.printReq = printReq;
	}
	private String strPatientName;
	private String printReq="0";
	
	public String getStrDossiercat() {
		return strDossiercat;
	}
	public void setStrDossiercat(String strDossiercat) {
		this.strDossiercat = strDossiercat;
	}
	public String getStrDossiercatValues() {
		return strDossiercatValues;
	}
	public void setStrDossiercatValues(String strDossiercatValues) {
		this.strDossiercatValues = strDossiercatValues;
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
	public String getStrCreditLimit() {
		return strCreditLimit;
	}
	public void setStrCreditLimit(String strCreditLimit) {
		this.strCreditLimit = strCreditLimit;
	}
	private String strCreditLimitBal;
	public String getStrCreditLimitBal() {
		return strCreditLimitBal;
	}
	public void setStrCreditLimitBal(String strCreditLimitBal) {
		this.strCreditLimitBal = strCreditLimitBal;
	}
	public String getStrBillPaidCat() {
		return strBillPaidCat;
	}
	public void setStrBillPaidCat(String strBillPaidCat) {
		this.strBillPaidCat = strBillPaidCat;
	}
	public String getStrUCReq() {
		return strUCReq;
	}
	public void setStrUCReq(String strUCReq) {
		this.strUCReq = strUCReq;
	}
	public String[] getBrandDtlsId() {
		return brandDtlsId;
	}
	public void setBrandDtlsId(String[] brandDtlsId) {
		this.brandDtlsId = brandDtlsId;
	}
	private String strBSQuantity[]=null;
	private String strBSIndent;
	private String strUrgentFlg="0";
			
	public String getStrUrgentFlg() {
		return strUrgentFlg;
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
	public String[] getStockDtlsId() {
		return stockDtlsId;
	}
	public void setStockDtlsId(String[] stockDtlsId) {
		this.stockDtlsId = stockDtlsId;
	}
	public String getStrCatgoryCode() {
		return strCatgoryCode;
	}
	public void setStrCatgoryCode(String strCatgoryCode) {
		this.strCatgoryCode = strCatgoryCode;
	}
	public String getStrBudgetFlg() {
		return strBudgetFlg;
	}
	public void setStrBudgetFlg(String strBudgetFlg) {
		this.strBudgetFlg = strBudgetFlg;
	}
	public String getStrDiagDtl() {
		return strDiagDtl;
	}
	public void setStrDiagDtl(String strDiagDtl) {
		this.strDiagDtl = strDiagDtl;
	}
	public String getStrBSReqNo() {
		return strBSReqNo;
	}
	public void setStrBSReqNo(String strBSReqNo) {
		this.strBSReqNo = strBSReqNo;
	}
	public String getStrSCMIntegration() {
		return strSCMIntegration;
	}
	public void setStrSCMIntegration(String strSCMIntegration) {
		this.strSCMIntegration = strSCMIntegration;
	}
	public String getStrReturnNo() {
		return strReturnNo;
	}
	public void setStrReturnNo(String strReturnNo) {
		this.strReturnNo = strReturnNo;
	}
	public String getStrPatAccountNo() {
		return strPatAccountNo;
	}
	public void setStrPatAccountNo(String strPatAccountNo) {
		this.strPatAccountNo = strPatAccountNo;
	}
	public String getStrPatAccountBal() {
		return strPatAccountBal;
	}
	public void setStrPatAccountBal(String strPatAccountBal) {
		this.strPatAccountBal = strPatAccountBal;
	}
	private String strIssueQuantity[]=null;
	private String strBrandQuantity[]=null;
	private String strBrandDtlsChk[]=null;

	public String[] getStrBrandDtlsChk() {
		return strBrandDtlsChk;
	}
	public void setStrBrandDtlsChk(String[] strBrandDtlsChk) {
		this.strBrandDtlsChk = strBrandDtlsChk;
	}
	public String[] getStrBrandQuantity() {
		return strBrandQuantity;
	}
	public void setStrBrandQuantity(String[] strBrandQuantity) {
		this.strBrandQuantity = strBrandQuantity;
	}
	public String[] getStrIssueQuantity() {
		return strIssueQuantity;
	}
	public void setStrIssueQuantity(String[] strIssueQuantity) {
		this.strIssueQuantity = strIssueQuantity;
	}
	public String getStrDeptName() {
		return strDeptName;
	}
	public void setStrDeptName(String strDeptName) {
		this.strDeptName = strDeptName;
	}
	public String getStrChk() {
		return strChk;
	}
	public void setStrChk(String strChk) {
		this.strChk = strChk;
	}
	public String getStrFlag() {
		return strFlag;
	}
	public void setStrFlag(String strFlag) {
		this.strFlag = strFlag;
	}
	public String getStrRecommendBy() {
		return strRecommendBy;
	}
	public void setStrRecommendBy(String strRecommendBy) {
		this.strRecommendBy = strRecommendBy;
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
	public String getStrRecommendByVal() {
		return strRecommendByVal;
	}
	public void setStrRecommendByVal(String strRecommendByVal) {
		this.strRecommendByVal = strRecommendByVal;
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
	public String getStrAdmissionDtlHidVal() {
		return strAdmissionDtlHidVal;
	}
	public void setStrAdmissionDtlHidVal(String strAdmissionDtlHidVal) {
		this.strAdmissionDtlHidVal = strAdmissionDtlHidVal;
	}
	public String getStrItemCategNo() {
		return strItemCategNo;
	}
	public void setStrItemCategNo(String strItemCategNo) {
		this.strItemCategNo = strItemCategNo;
	}
	public String[] getStrItemParamValue() {
		return strItemParamValue;
	}
	public void setStrItemParamValue(String[] strItemParamValue) {
		this.strItemParamValue = strItemParamValue;
	}
	public String getStrIssueItemId() {
		return strIssueItemId;
	}
	public void setStrIssueItemId(String strIssueItemId) {
		this.strIssueItemId = strIssueItemId;
	}
	public String getStrRequestTypeId() {
		return strRequestTypeId;
	}
	public void setStrRequestTypeId(String strRequestTypeId) {
		this.strRequestTypeId = strRequestTypeId;
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
	/**
	 * @return the strItemDtls
	 */
	public String getStrItemDtls() {
		return strItemDtls;
	}
	/**
	 * @param strItemDtls the strItemDtls to set
	 */
	public void setStrItemDtls(String strItemDtls) {
		this.strItemDtls = strItemDtls;
	}
	public String getStrMsg() {
		return strMsg;
	}
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
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
	public String getStrLpRequestNo() {
		return strLpRequestNo;
	}
	public void setStrLpRequestNo(String strLpRequestNo) {
		this.strLpRequestNo = strLpRequestNo;
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
	public String getStrRequestDate() {
		return strRequestDate;
	}
	public void setStrRequestDate(String strRequestDate) {
		this.strRequestDate = strRequestDate;
	}
	public String getStrPatientDtl() {
		return strPatientDtl;
	}
	public void setStrPatientDtl(String strPatientDtl) {
		this.strPatientDtl = strPatientDtl;
	}
	public String getStrRequestDtl() {
		return strRequestDtl;
	}
	public void setStrRequestDtl(String strRequestDtl) {
		this.strRequestDtl = strRequestDtl;
	}
	public String getStrRequestItemDtl() {
		return strRequestItemDtl;
	}
	public void setStrRequestItemDtl(String strRequestItemDtl) {
		this.strRequestItemDtl = strRequestItemDtl;
	}
	public String getStrRaisingReqTypeId() {
		return strRaisingReqTypeId;
	}
	public void setStrRaisingReqTypeId(String strRaisingReqTypeId) {
		this.strRaisingReqTypeId = strRaisingReqTypeId;
	}
	public String getStrReceivedby() {
		return strReceivedby;
	}
	public void setStrReceivedby(String strReceivedby) {
		this.strReceivedby = strReceivedby;
	}
	public String getStrFinalCost() {
		return strFinalCost;
	}
	public void setStrFinalCost(String strFinalCost) {
		this.strFinalCost = strFinalCost;
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
	
	private String strDossierName = "";
	private String strServiceTypeName = "";

	public String getStrDossierName() {
		return strDossierName;
	}
	public void setStrDossierName(String strDossierName) {
		this.strDossierName = strDossierName;
	}
	public String getStrServiceTypeName() {
		return strServiceTypeName;
	}
	public void setStrServiceTypeName(String strServiceTypeName) {
		this.strServiceTypeName = strServiceTypeName;
	}
	
	private String strId = "";

	public String getStrId() {
		return strId;
	}
	public void setStrId(String strId) {
		this.strId = strId;
	}
	
}