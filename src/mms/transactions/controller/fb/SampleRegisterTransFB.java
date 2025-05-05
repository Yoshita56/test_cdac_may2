package mms.transactions.controller.fb;

import javax.sql.rowset.WebRowSet;

import org.apache.struts.upload.FormFile;

import hisglobal.transactionutil.GenericFormBean;



public class SampleRegisterTransFB  extends GenericFormBean{

	private static final long serialVersionUID = 02L;
	
	
	private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
	private String strCtDate = "";
	private String strEffectiveFrom = "";
	private String strRemarks = "";
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strStoreId = "";
	private String strStoreTypeId = "";
	/*private String chk="";
	private String comboValue="";*/
	private String strStoreName = "";
	private String strSupplierValues="";
	private String strChk="";
	private String strChkHidden[]=null;
	private String strUnitId="";
	private String strGatePassNo="";
	private String strItemDtlValues="";
	private String strCommitteeType="";
	private String strQuotationNo="";
	private String strTenderNo="";
	private String strSupplierName="";
	private String strSampleName="";
	private String strGroupValues="";
	private String strGroupName="";
	private String strFinancialStartYear="";
	private String strFinancialEndYear="";
	private String strUnitName[]=null;
	private String strGroupIdForItemSearch="";
	private String strSupplierId="";
	private String  strIsGatePassIssue="0";
	private String itemParamValue []=null;
	private String strQty []=null;
	private FormFile  strLocation=null;
	private String strSampleRecNoHidden="";
	private String strSampleItemIdHidden="";
	private String strSampleItemBrandIdHidden="";
	private String strSampleItemBatchSlNoHidden="";
	private String strQuotationNoHidden[]=null;
	private String strTenderNoHidden[]=null;
	private String strSupplierNoHidden[]=null;
	private String strChkBox[]={"0"};
	private String strRecieveQty[] = {"0"};
	private String strRecieveQtyUnitId[] = {"0"};
	private String strIssueQty[] = {"0"};
	private String strIssueQtyUnitId []= {"0"};
	private String strCondemenedQty[] = {"0"};
	private String strCondemenedQtyUnitId[] = {"0"};
	private String strQtyHidden[]={"0"};
	private String strIssueValues="";
	private String strIssueBy="";
	private String strSubGroupName="";
	private String strConsultantName="";
	private String strConsultantValues="";
	private String strItemIdHidden[]=null;
	private String strItemBrandIdHidden[]=null;
	private String strItemBatchSlnoHidden[]=null;
	private String strSampleRecNo[]=null;
	private String strExpDate[]=null;
	private String strItemName="";
	private String strItemBrandName="";
	private String strRecQty="";
	private String strRecQtyUnitId="";
	private String strItemCategDtl="";
	private String strCommitteeValues="";
	private String strFileNo="";
	private String strPageNo="";
	private String strItemCategory="";
	private String strBatchSlNo[]={"0"};
	private String strBatchSlno="";
	private String	strItemCategoryValue="";
	private String strApprovalStatus="1";
	private String strItemCategoryName="";
	private String strReturnTo="";
	private String strPath="";
	private String strComboValuePersist="";
	private String strCommitteeMemberHidden[]=null;
	private String strMemberRecommendation[]=null;
	private WebRowSet itemDetailsWS=null;
	private String strTendorDate="";
	private String strQuotationDate="";
	private String strCurrentDate="";
	private String strConsumableFlag="0";
	private String strUnitVals="";
	private String strRecQtyVals="";
	private String consumeQty="0";
	private String strConsumeQtyUnit="0";
	private String strUnitBaseVals="";
	
	
	private WebRowSet committeMemberWS=null;
	private WebRowSet unitWS=null;
	
	private String strUnit[]=null; 
	
	
		public String getStrChk() {
		return strChk;
	}

	public void setStrChk(String strChk) {
		this.strChk = strChk;
	}

	public WebRowSet getItemDetailsWS() {
		return itemDetailsWS;
	}

	public void setItemDetailsWS(WebRowSet itemDetailsWS) {
		this.itemDetailsWS = itemDetailsWS;
	}

	public WebRowSet getUnitWS() {
		return unitWS;
	}

	public void setUnitWS(WebRowSet unitWS) {
		this.unitWS = unitWS;
	}

		public String getStrSupplierValues() {
		return strSupplierValues;
	}

	public void setStrSupplierValues(String strSupplierValues) {
		this.strSupplierValues = strSupplierValues;
	}

		/**
	 * @param strCtDate the strCtDate to set
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}

	/**
	 * @return the strEffectiveFrom
	 */
	public String getStrEffectiveFrom() {
		return strEffectiveFrom;
	}

	/**
	 * @param strEffectiveFrom the strEffectiveFrom to set
	 */
	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
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

	public String getStrCtDate() {
		return strCtDate;
	}

	public String getStrUnitId() {
		return strUnitId;
	}

	public void setStrUnitId(String strUnitId) {
		this.strUnitId = strUnitId;
	}

	public String getStrItemDtlValues() {
		return strItemDtlValues;
	}

	public void setStrItemDtlValues(String strItemDtlValues) {
		this.strItemDtlValues = strItemDtlValues;
	}

	public String getStrQuotationNo() {
		return strQuotationNo;
	}

	public void setStrQuotationNo(String strQuotationNo) {
		this.strQuotationNo = strQuotationNo;
	}

	public String getStrTenderNo() {
		return strTenderNo;
	}

	public void setStrTenderNo(String strTenderNo) {
		this.strTenderNo = strTenderNo;
	}

	public String getStrSupplierName() {
		return strSupplierName;
	}

	public void setStrSupplierName(String strSupplierName) {
		this.strSupplierName = strSupplierName;
	}

	public String getStrSampleName() {
		return strSampleName;
	}

	public void setStrSampleName(String strSampleName) {
		this.strSampleName = strSampleName;
	}

	public String getStrGroupValues() {
		return strGroupValues;
	}

	public void setStrGroupValues(String strGroupValues) {
		this.strGroupValues = strGroupValues;
	}

	public String getStrGroupName() {
		return strGroupName;
	}

	public void setStrGroupName(String strGroupName) {
		this.strGroupName = strGroupName;
	}

	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}

	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}

	public String[] getStrUnitName() {
		return strUnitName;
	}

	public void setStrUnitName(String[] strUnitName) {
		this.strUnitName = strUnitName;
	}

	public String[] getItemParamValue() {
		return itemParamValue;
	}

	public void setItemParamValue(String[] itemParamValue) {
		this.itemParamValue = itemParamValue;
	}

	public String[] getStrQty() {
		return strQty;
	}

	public void setStrQty(String[] strQty) {
		this.strQty = strQty;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
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

	public String getStrGroupIdForItemSearch() {
		return strGroupIdForItemSearch;
	}

	public void setStrGroupIdForItemSearch(String strGroupIdForItemSearch) {
		this.strGroupIdForItemSearch = strGroupIdForItemSearch;
	}

	
	public String[] getStrChkHidden() {
		return strChkHidden;
	}

	public void setStrChkHidden(String[] strChkHidden) {
		this.strChkHidden = strChkHidden;
	}

	public String getStrSupplierId() {
		return strSupplierId;
	}

	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}

	public String getStrIsGatePassIssue() {
		return strIsGatePassIssue;
	}

	public void setStrIsGatePassIssue(String strIsGatePassIssue) {
		this.strIsGatePassIssue = strIsGatePassIssue;
	}

	public String[] getStrUnit() {
		return strUnit;
	}

	public void setStrUnit(String[] strUnit) {
		this.strUnit = strUnit;
	}

	

	public String getStrReturnTo() {
		return strReturnTo;
	}

	public void setStrReturnTo(String strReturnTo) {
		this.strReturnTo = strReturnTo;
	}

	public String getStrSampleRecNoHidden() {
		return strSampleRecNoHidden;
	}

	public void setStrSampleRecNoHidden(String strSampleRecNoHidden) {
		this.strSampleRecNoHidden = strSampleRecNoHidden;
	}

	public String getStrSampleItemIdHidden() {
		return strSampleItemIdHidden;
	}

	public void setStrSampleItemIdHidden(String strSampleItemIdHidden) {
		this.strSampleItemIdHidden = strSampleItemIdHidden;
	}

	public String getStrSampleItemBrandIdHidden() {
		return strSampleItemBrandIdHidden;
	}

	public void setStrSampleItemBrandIdHidden(String strSampleItemBrandIdHidden) {
		this.strSampleItemBrandIdHidden = strSampleItemBrandIdHidden;
	}

	public String getStrSampleItemBatchSlNoHidden() {
		return strSampleItemBatchSlNoHidden;
	}

	public void setStrSampleItemBatchSlNoHidden(String strSampleItemBatchSlNoHidden) {
		this.strSampleItemBatchSlNoHidden = strSampleItemBatchSlNoHidden;
	}

	public String[] getStrQuotationNoHidden() {
		return strQuotationNoHidden;
	}

	public void setStrQuotationNoHidden(String[] strQuotationNoHidden) {
		this.strQuotationNoHidden = strQuotationNoHidden;
	}

	public String[] getStrTenderNoHidden() {
		return strTenderNoHidden;
	}

	public void setStrTenderNoHidden(String[] strTenderNoHidden) {
		this.strTenderNoHidden = strTenderNoHidden;
	}

	public String[] getStrSupplierNoHidden() {
		return strSupplierNoHidden;
	}

	public void setStrSupplierNoHidden(String[] strSupplierNoHidden) {
		this.strSupplierNoHidden = strSupplierNoHidden;
	}

	public String[] getStrChkBox() {
		return strChkBox;
	}

	public void setStrChkBox(String[] strChkBox) {
		this.strChkBox = strChkBox;
	}

	public String[] getStrRecieveQty() {
		return strRecieveQty;
	}

	public void setStrRecieveQty(String[] strRecieveQty) {
		this.strRecieveQty = strRecieveQty;
	}

	public String[] getStrRecieveQtyUnitId() {
		return strRecieveQtyUnitId;
	}

	public void setStrRecieveQtyUnitId(String[] strRecieveQtyUnitId) {
		this.strRecieveQtyUnitId = strRecieveQtyUnitId;
	}

	public String[] getStrIssueQty() {
		return strIssueQty;
	}

	public void setStrIssueQty(String[] strIssueQty) {
		this.strIssueQty = strIssueQty;
	}

	public String[] getStrIssueQtyUnitId() {
		return strIssueQtyUnitId;
	}

	public void setStrIssueQtyUnitId(String[] strIssueQtyUnitId) {
		this.strIssueQtyUnitId = strIssueQtyUnitId;
	}

	public String[] getStrCondemenedQty() {
		return strCondemenedQty;
	}

	public void setStrCondemenedQty(String[] strCondemenedQty) {
		this.strCondemenedQty = strCondemenedQty;
	}

	public String[] getStrCondemenedQtyUnitId() {
		return strCondemenedQtyUnitId;
	}

	public void setStrCondemenedQtyUnitId(String[] strCondemenedQtyUnitId) {
		this.strCondemenedQtyUnitId = strCondemenedQtyUnitId;
	}

	public String[] getStrQtyHidden() {
		return strQtyHidden;
	}

	public void setStrQtyHidden(String[] strQtyHidden) {
		this.strQtyHidden = strQtyHidden;
	}

	public String getStrIssueValues() {
		return strIssueValues;
	}

	public void setStrIssueValues(String strIssueValues) {
		this.strIssueValues = strIssueValues;
	}

	public String getStrIssueBy() {
		return strIssueBy;
	}

	public void setStrIssueBy(String strIssueBy) {
		this.strIssueBy = strIssueBy;
	}

	public String getStrSubGroupName() {
		return strSubGroupName;
	}

	public void setStrSubGroupName(String strSubGroupName) {
		this.strSubGroupName = strSubGroupName;
	}

	public String getStrConsultantName() {
		return strConsultantName;
	}

	public void setStrConsultantName(String strConsultantName) {
		this.strConsultantName = strConsultantName;
	}

	public String getStrConsultantValues() {
		return strConsultantValues;
	}

	public void setStrConsultantValues(String strConsultantValues) {
		this.strConsultantValues = strConsultantValues;
	}

	public String[] getStrItemIdHidden() {
		return strItemIdHidden;
	}

	public void setStrItemIdHidden(String[] strItemIdHidden) {
		this.strItemIdHidden = strItemIdHidden;
	}

	public String[] getStrItemBrandIdHidden() {
		return strItemBrandIdHidden;
	}

	public void setStrItemBrandIdHidden(String[] strItemBrandIdHidden) {
		this.strItemBrandIdHidden = strItemBrandIdHidden;
	}

	public String[] getStrItemBatchSlnoHidden() {
		return strItemBatchSlnoHidden;
	}

	public void setStrItemBatchSlnoHidden(String[] strItemBatchSlnoHidden) {
		this.strItemBatchSlnoHidden = strItemBatchSlnoHidden;
	}

	public String[] getStrSampleRecNo() {
		return strSampleRecNo;
	}

	public void setStrSampleRecNo(String[] strSampleRecNo) {
		this.strSampleRecNo = strSampleRecNo;
	}

	public String getStrItemCategory() {
		return strItemCategory;
	}

	public void setStrItemCategory(String strItemCategory) {
		this.strItemCategory = strItemCategory;
	}

	public String getStrItemCategoryValue() {
		return strItemCategoryValue;
	}

	public void setStrItemCategoryValue(String strItemCategoryValue) {
		this.strItemCategoryValue = strItemCategoryValue;
	}

	public String[] getStrBatchSlNo() {
		return strBatchSlNo;
	}

	public void setStrBatchSlNo(String[] strBatchSlNo) {
		this.strBatchSlNo = strBatchSlNo;
	}

	public String getStrItemName() {
		return strItemName;
	}

	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}

	public String getStrItemBrandName() {
		return strItemBrandName;
	}

	public void setStrItemBrandName(String strItemBrandName) {
		this.strItemBrandName = strItemBrandName;
	}

	public String getStrRecQty() {
		return strRecQty;
	}

	public void setStrRecQty(String strRecQty) {
		this.strRecQty = strRecQty;
	}

	public String getStrRecQtyUnitId() {
		return strRecQtyUnitId;
	}

	public void setStrRecQtyUnitId(String strRecQtyUnitId) {
		this.strRecQtyUnitId = strRecQtyUnitId;
	}

	public String getStrItemCategDtl() {
		return strItemCategDtl;
	}

	public void setStrItemCategDtl(String strItemCategDtl) {
		this.strItemCategDtl = strItemCategDtl;
	}

	public String getStrBatchSlno() {
		return strBatchSlno;
	}

	public void setStrBatchSlno(String strBatchSlno) {
		this.strBatchSlno = strBatchSlno;
	}

	public String getStrCommitteeValues() {
		return strCommitteeValues;
	}

	public void setStrCommitteeValues(String strCommitteeValues) {
		this.strCommitteeValues = strCommitteeValues;
	}

	public String getStrGatePassNo() {
		return strGatePassNo;
	}

	public void setStrGatePassNo(String strGatePassNo) {
		this.strGatePassNo = strGatePassNo;
	}

	public String getStrCommitteeType() {
		return strCommitteeType;
	}

	public void setStrCommitteeType(String strCommitteeType) {
		this.strCommitteeType = strCommitteeType;
	}

	public String[] getStrCommitteeMemberHidden() {
		return strCommitteeMemberHidden;
	}

	public void setStrCommitteeMemberHidden(String[] strCommitteeMemberHidden) {
		this.strCommitteeMemberHidden = strCommitteeMemberHidden;
	}

	public String[] getStrMemberRecommendation() {
		return strMemberRecommendation;
	}

	public void setStrMemberRecommendation(String[] strMemberRecommendation) {
		this.strMemberRecommendation = strMemberRecommendation;
	}

	public WebRowSet getCommitteMemberWS() {
		return committeMemberWS;
	}

	public void setCommitteMemberWS(WebRowSet committeMemberWS) {
		this.committeMemberWS = committeMemberWS;
	}

	public String getStrApprovalStatus() {
		return strApprovalStatus;
	}

	public void setStrApprovalStatus(String strApprovalStatus) {
		this.strApprovalStatus = strApprovalStatus;
	}



	/*public void setChk(String chk) {
		this.chk = chk;
	}*/

	public String getStrPath() {
		return strPath;
	}

	public void setStrPath(String strPath) {
		this.strPath = strPath;
	}

	public String getStrItemCategoryName() {
		return strItemCategoryName;
	}

	public void setStrItemCategoryName(String strItemCategoryName) {
		this.strItemCategoryName = strItemCategoryName;
	}

	public String getStrComboValuePersist() {
		return strComboValuePersist;
	}

	public void setStrComboValuePersist(String strComboValuePersist) {
		this.strComboValuePersist = strComboValuePersist;
	}

	public String[] getStrExpDate() {
		return strExpDate;
	}

	public void setStrExpDate(String[] strExpDate) {
		this.strExpDate = strExpDate;
	}

	public String getStrTendorDate() {
		return strTendorDate;
	}

	public void setStrTendorDate(String strTendorDate) {
		this.strTendorDate = strTendorDate;
	}

	public String getStrQuotationDate() {
		return strQuotationDate;
	}

	public void setStrQuotationDate(String strQuotationDate) {
		this.strQuotationDate = strQuotationDate;
	}

	public String getStrCurrentDate() {
		return strCurrentDate;
	}

	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}

	public FormFile getStrLocation() {
		return strLocation;
	}

	public void setStrLocation(FormFile strLocation) {
		this.strLocation = strLocation;
	}

	public String getStrFileNo() {
		return strFileNo;
	}

	public void setStrFileNo(String strFileNo) {
		this.strFileNo = strFileNo;
	}

	public String getStrPageNo() {
		return strPageNo;
	}

	public void setStrPageNo(String strPageNo) {
		this.strPageNo = strPageNo;
	}

	/**
	 * @return the strConsumableFlag
	 */
	public String getStrConsumableFlag() {
		return strConsumableFlag;
	}

	/**
	 * @param strConsumableFlag the strConsumableFlag to set
	 */
	public void setStrConsumableFlag(String strConsumableFlag) {
		this.strConsumableFlag = strConsumableFlag;
	}

	/**
	 * @return the strUnitVals
	 */
	public String getStrUnitVals() {
		return strUnitVals;
	}

	/**
	 * @param strUnitVals the strUnitVals to set
	 */
	public void setStrUnitVals(String strUnitVals) {
		this.strUnitVals = strUnitVals;
	}

	/**
	 * @return the strUnitBaseVals
	 */
	public String getStrUnitBaseVals() {
		return strUnitBaseVals;
	}

	/**
	 * @param strUnitBaseVals the strUnitBaseVals to set
	 */
	public void setStrUnitBaseVals(String strUnitBaseVals) {
		this.strUnitBaseVals = strUnitBaseVals;
	}

	/**
	 * @return the strRecQtyVals
	 */
	public String getStrRecQtyVals() {
		return strRecQtyVals;
	}

	/**
	 * @param strRecQtyVals the strRecQtyVals to set
	 */
	public void setStrRecQtyVals(String strRecQtyVals) {
		this.strRecQtyVals = strRecQtyVals;
	}

	/**
	 * @return the consumeQty
	 */
	public String getConsumeQty() {
		return consumeQty;
	}

	/**
	 * @param consumeQty the consumeQty to set
	 */
	public void setConsumeQty(String consumeQty) {
		this.consumeQty = consumeQty;
	}

	/**
	 * @return the strConsumeQtyUnit
	 */
	public String getStrConsumeQtyUnit() {
		return strConsumeQtyUnit;
	}

	/**
	 * @param strConsumeQtyUnit the strConsumeQtyUnit to set
	 */
	public void setStrConsumeQtyUnit(String strConsumeQtyUnit) {
		this.strConsumeQtyUnit = strConsumeQtyUnit;
	}

	

	

	

		/**
	 * @return the strSubGroupCombo
	 */
	
}
