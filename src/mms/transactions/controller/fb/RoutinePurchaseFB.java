package mms.transactions.controller.fb;
/**
 * Author : Amit Kr
 * Date   :  /  / 
 */
import hisglobal.transactionutil.GenericFormBean;

public class RoutinePurchaseFB extends GenericFormBean 
{
	  private static final long serialVersionUID = 02L;
	  private String strMsg = "";
	  private String strMsgString = "";
	  private String strMsgType = "";
	  private String strErrMsg = "";
	  private String strErr = "";
	  private String strWarning = "";
	  private String strNormalMsg = "";
      private String strHospitalCode = "";
	  private String strGroupId = "";
	  private String strCtDate = "";
	  private String strSeatId = "";
      /*********************************/
	   
		private String strPath ="";
		private String strToStoreCombo = "";
		private String strGrantType = "";
		private String strGrantTypeCombo = "";
		private String strItemCatg = "";
		private String strItemCatgCombo = "";
		private String strStoreName = "";
		private String strToStore ="";
		private String strReqDate ="";
		private String strGroupIdForItemSearch="";
		private String strRemarks = "";
		private String strIsNormal = "0"; 
		private String strIsUrgent  = "0";
		private String strCrNo ="";
		private String  strStoreId ="";
		private String  strStoreTypeId="";
		private String  strReqType = "";
		private String  strItemCategoryNo ="";
		private String  strRecmndBy ="";
		private String  strRecmndByCombo="";
		private String  strPatientDemDtl="";
		
		private String  strTmpStoreName ="";
		private String  strTmpCrNo = "";
		private String  strTmpToStore = "";
		private String  strTmpGrantType = "";
		private String  strTmpItemCatg ="";
		private String  strTmpReqType ="";
		private String  strGoFlg = "0";
		private String[] itemParamValue = {""};
		private String[] itemUserValue = {""};
		private String[] strReqQty ={""};
		private String[] strUnitName={""};	
		
		private String strCostRequired="";
		private String 	strIndentPeriod;

		private String 	strIndentPeriodCombo;
		private String strIndentItemList;

		private String 	strIndentPeriodValue;
		/*****************************/
		private String[] strCHMOQty={""};
		private String[] strMCQty={""};
		private String[] strTotalQty={""};
		private String[] strApproxAmt={""};
		private String strApproxAmtTotal;
		private String strChk ="";
		private String strChkTmp="";
		private String strIndentDetails="";
	
		private String[] itemId = {""};
		private String[] itemBrandId = {""};
		private String strIndentStatus;
		private String strCurrentFinancialYear;
		private String strNextFinancialYear;
		private String strFinancialYearPeriod;
		private String strIndentDate;
		private String strTmpIndentDate;
		
				
		public String getStrTmpIndentDate() {
			return strTmpIndentDate;
		}
		public void setStrTmpIndentDate(String strTmpIndentDate) {
			this.strTmpIndentDate = strTmpIndentDate;
		}
		public String getStrIndentDate() {
			return strIndentDate;
		}
		public void setStrIndentDate(String strIndentDate) {
			this.strIndentDate = strIndentDate;
		}
		public String getStrFinancialYearPeriod() {
			return strFinancialYearPeriod;
		}
		public void setStrFinancialYearPeriod(String strFinancialYearPeriod) {
			this.strFinancialYearPeriod = strFinancialYearPeriod;
		}
		public String getStrIndentStatus() {
			return strIndentStatus;
		}
		public void setStrIndentStatus(String strIndentStatus) {
			this.strIndentStatus = strIndentStatus;
		}
		public String[] getStrCHMOQty() {
			return strCHMOQty;
		}
		public void setStrCHMOQty(String[] strCHMOQty) {
			this.strCHMOQty = strCHMOQty;
		}
		public String[] getStrMCQty() {
			return strMCQty;
		}
		public void setStrMCQty(String[] strMCQty) {
			this.strMCQty = strMCQty;
		}
		public String[] getStrTotalQty() {
			return strTotalQty;
		}
		public void setStrTotalQty(String[] strTotalQty) {
			this.strTotalQty = strTotalQty;
		}
		public String[] getStrApproxAmt() {
			return strApproxAmt;
		}
		public void setStrApproxAmt(String[] strApproxAmt) {
			this.strApproxAmt = strApproxAmt;
		}
		public String getStrApproxAmtTotal() {
			return strApproxAmtTotal;
		}
		public void setStrApproxAmtTotal(String strApproxAmtTotal) {
			this.strApproxAmtTotal = strApproxAmtTotal;
		}
		public String getStrIndentPeriod() {
			return strIndentPeriod;
		}
		public void setStrIndentPeriod(String strIndentPeriod) {
			this.strIndentPeriod = strIndentPeriod;
		}
		public String getStrIndentPeriodCombo() {
			return strIndentPeriodCombo;
		}
		public void setStrIndentPeriodCombo(String strIndentPeriodCombo) {
			this.strIndentPeriodCombo = strIndentPeriodCombo;
		}
		public String getStrIndentPeriodValue() {
			return strIndentPeriodValue;
		}
		public void setStrIndentPeriodValue(String strIndentPeriodValue) {
			this.strIndentPeriodValue = strIndentPeriodValue;
		}
		/**
		 * @return the strCostRequired
		 */
		public String getStrCostRequired() {
			return strCostRequired;
		}
		/**
		 * @param strCostRequired the strCostRequired to set
		 */
		public void setStrCostRequired(String strCostRequired) {
			this.strCostRequired = strCostRequired;
		}
		public String[] getItemParamValue() {
			return itemParamValue;
		}
		public void setItemParamValue(String[] itemParamValue) {
			this.itemParamValue = itemParamValue;
		}
		public String[] getItemUserValue() {
			return itemUserValue;
		}
		public void setItemUserValue(String[] itemUserValue) {
			this.itemUserValue = itemUserValue;
		}
		public static long getSerialVersionUID() {
			return serialVersionUID;
		}
		public String[] getStrReqQty() {
			return strReqQty;
		}
		public void setStrReqQty(String[] strReqQty) {
			this.strReqQty = strReqQty;
		}
		public String[] getStrUnitName() {
			return strUnitName;
		}
		public void setStrUnitName(String[] strUnitName) {
			this.strUnitName = strUnitName;
		}
		public String getStrGoFlg() {
			return strGoFlg;
		}
		public void setStrGoFlg(String strGoFlg) {
			this.strGoFlg = strGoFlg;
		}
		public String getStrTmpReqType() {
			return strTmpReqType;
		}
		public void setStrTmpReqType(String strTmpReqType) {
			this.strTmpReqType = strTmpReqType;
		}
		public String getStrPatientDemDtl() {
			return strPatientDemDtl;
		}
		public void setStrPatientDemDtl(String strPatientDemDtl) {
			this.strPatientDemDtl = strPatientDemDtl;
		}
		public String getStrRecmndBy() {
			return strRecmndBy;
		}
		public void setStrRecmndBy(String strRecmndBy) {
			this.strRecmndBy = strRecmndBy;
		}
		public String getStrRecmndByCombo() {
			return strRecmndByCombo;
		}
		public void setStrRecmndByCombo(String strRecmndByCombo) {
			this.strRecmndByCombo = strRecmndByCombo;
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
		public String getStrReqType() {
			return strReqType;
		}
		public void setStrReqType(String strReqType) {
			this.strReqType = strReqType;
		}
		public String getStrItemCategoryNo() {
			return strItemCategoryNo;
		}
		public void setStrItemCategoryNo(String strItemCategoryNo) {
			this.strItemCategoryNo = strItemCategoryNo;
		}
		public String getStrCrNo() {
			return strCrNo;
		}
		public void setStrCrNo(String strCrNo) {
			this.strCrNo = strCrNo;
		}
		public String getStrToStoreCombo() {
			return strToStoreCombo;
		}
		public void setStrToStoreCombo(String strToStoreCombo) {
			this.strToStoreCombo = strToStoreCombo;
		}
		public String getStrGrantType() {
			return strGrantType;
		}
		public void setStrGrantType(String strGrantType) {
			this.strGrantType = strGrantType;
		}
		public String getStrGrantTypeCombo() {
			return strGrantTypeCombo;
		}
		public void setStrGrantTypeCombo(String strGrantTypeCombo) {
			this.strGrantTypeCombo = strGrantTypeCombo;
		}
		public String getStrItemCatg() {
			return strItemCatg;
		}
		public void setStrItemCatg(String strItemCatg) {
			this.strItemCatg = strItemCatg;
		}
		public String getStrItemCatgCombo() {
			return strItemCatgCombo;
		}
		public void setStrItemCatgCombo(String strItemCatgCombo) {
			this.strItemCatgCombo = strItemCatgCombo;
		}
		public String getStrStoreName() {
			return strStoreName;
		}
		public void setStrStoreName(String strStoreName) {
			this.strStoreName = strStoreName;
		}
		public String getStrToStore() {
			return strToStore;
		}
		public void setStrToStore(String strToStore) {
			this.strToStore = strToStore;
		}
		public String getStrReqDate() {
			return strReqDate;
		}
		public void setStrReqDate(String strReqDate) {
			this.strReqDate = strReqDate;
		}
		public String getStrGroupIdForItemSearch() {
			return strGroupIdForItemSearch;
		}
		public void setStrGroupIdForItemSearch(String strGroupIdForItemSearch) {
			this.strGroupIdForItemSearch = strGroupIdForItemSearch;
		}
		public String getStrRemarks() {
			return strRemarks;
		}
		public void setStrRemarks(String strRemarks) {
			this.strRemarks = strRemarks;
		}
		public String getStrIsNormal() {
			return strIsNormal;
		}
		public void setStrIsNormal(String strIsNormal) {
			this.strIsNormal = strIsNormal;
		}
		public String getStrIsUrgent() {
			return strIsUrgent;
		}
		public void setStrIsUrgent(String strIsUrgent) {
			this.strIsUrgent = strIsUrgent;
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
		public String getStrTmpStoreName() {
			return strTmpStoreName;
		}
		public void setStrTmpStoreName(String strTmpStoreName) {
			this.strTmpStoreName = strTmpStoreName;
		}
		public String getStrTmpCrNo() {
			return strTmpCrNo;
		}
		public void setStrTmpCrNo(String strTmpCrNo) {
			this.strTmpCrNo = strTmpCrNo;
		}
		public String getStrTmpToStore() {
			return strTmpToStore;
		}
		public void setStrTmpToStore(String strTmpToStore) {
			this.strTmpToStore = strTmpToStore;
		}
		public String getStrTmpGrantType() {
			return strTmpGrantType;
		}
		public void setStrTmpGrantType(String strTmpGrantType) {
			this.strTmpGrantType = strTmpGrantType;
		}
		public String getStrTmpItemCatg() {
			return strTmpItemCatg;
		}
		public void setStrTmpItemCatg(String strTmpItemCatg) {
			this.strTmpItemCatg = strTmpItemCatg;
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
		public String getStrPath() {
			return strPath;
		}
		public void setStrPath(String strPath) {
			this.strPath = strPath;
		}
		
		public String getStrIndentItemList() {
			return strIndentItemList;
		}
		public void setStrIndentItemList(String strIndentItemList) {
			this.strIndentItemList = strIndentItemList;
		}
		public String getStrChk() {
			return strChk;
		}
		public void setStrChk(String strChk) {
			this.strChk = strChk;
		}
		public String getStrIndentDetails() {
			return strIndentDetails;
		}
		public void setStrIndentDetails(String strIndentDetails) {
			this.strIndentDetails = strIndentDetails;
		}
		public String getStrChkTmp() {
			return strChkTmp;
		}
		public void setStrChkTmp(String strChkTmp) {
			this.strChkTmp = strChkTmp;
		}
		public String[] getItemId() {
			return itemId;
		}
		public void setItemId(String[] itemId) {
			this.itemId = itemId;
		}
		public String[] getItemBrandId() {
			return itemBrandId;
		}
		public void setItemBrandId(String[] itemBrandId) {
			this.itemBrandId = itemBrandId;
		}
		public String getStrNextFinancialYear() {
			return strNextFinancialYear;
		}
		public void setStrNextFinancialYear(String strNextFinancialYear) {
			this.strNextFinancialYear = strNextFinancialYear;
		}
		public String getStrCurrentFinancialYear() {
			return strCurrentFinancialYear;
		}
		public void setStrCurrentFinancialYear(String strCurrentFinancialYear) {
			this.strCurrentFinancialYear = strCurrentFinancialYear;
		}
		

	}
