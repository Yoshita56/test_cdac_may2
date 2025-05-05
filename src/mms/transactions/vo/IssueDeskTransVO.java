/**
 * 
 */
package mms.transactions.vo;

import hisglobal.utility.TransferObject;

import javax.sql.rowset.WebRowSet;


/**
 * Developer : Balasubramaniam M
 * Version : 1.0
 * Date : 01/Apr/2009
 *  
 */

public class IssueDeskTransVO implements TransferObject {

	
	
	private static final long serialVersionUID = 02L;
	
	private String strMsgString = "";
	private String strMsgType = "0";
	
	private String strRequestTypeId="";
	private String strReservedFlag = "";
	private String strReqTypeId = "";
	private String strReqStatusName = "";
	private String[] strItemRemarksArray = null; 
	private String strViewItemName = "";
	private String strViewAvlQty = "";
	private String strViewSancQty = "";
	private String strViewItemDtls = ""; 
	private String strFinancialStartYear="";
	private String strFinancialEndYear="";
	
	private String strFinancialStartDate="";
	private String strFinancialEndDate="";
	
	private String strStoreName = "";
	private String strStoreId = "0";
	
	private String strRaisingStoreName = "";
	private String strRaisingStoreId = "0";
	
	private String strIndentNo = "0";
	private String strIndentDate = "";
	private String strIndentType = "";
	private String strItemCategory = "";
	private String strItemCategoryNo = "";
	
	private String strHospitalCode = "";
	private String strSeatId = "";	
	private String strRemarks = "";
	
	private String strSancUnitId = "";
	private String strItemId = "";
	private String strItemBrand = "";
	
	private String StrPopUpData = "";
	private WebRowSet itemDetailsWS = null;
	private WebRowSet unitComboWS = null;
	private WebRowSet popupWS = null;
	private WebRowSet recievedByWS= null;
	//private String[] strRate = null; 
	//private String[] strRateUnitId = null; 
	private String strItemIdArray[] = null;
	private String strBrandIdArray[] = null;
	private String strReservedFlagArray[] = null;
	private String strRateArray[] = null;
	private String strRateUnitIdArray[] = null;
	private String stockDtlsId[] = null; // from userHiddenFld= StoreId^Generic_ItemId^Brand_ItemId^Stock_Status_Code^Batch_No^Serial_No
	private String strStochStatusCodeArray[] = null;
	private String strBatchSlNoArray[] = null;
	private String strItemSlNoArray[] = null;
	private String strGroupIdArray[] = null;
	private String strSubGroupIdArray[] = null;
	private String strAvlQtyArray[] = null;
	private String strAvlQtyUnitIdArray[] = null;
	private String strBalQtyArray[] = null;
	private String strBalQtyUnitIdArray[] = null;
	private String strIssueQtyArray[] = null;
	private String strIssueQtyUnitIdArray[] = null;
	private String strManufDateArray[] = null;
	private String strExpiryDateUnitIdArray[] = null;
	private String strConsumableFlagArray[] = null;
	private String strCostArray[] = null;
	private String strRateBaseValArray[] = null;
	private String strReceivedBy = "";
	private String[] strFinalCost = null;

	private String strIssueNo = "0";
	private String strIssueDate = "0";
	private String strReOrderFlgColor;
	private String strBudgetFlg;


	private String strFinalApproxAmt;
	

	private String strAvalaibleBudget;
	private String strAvalaibleBudgetDtl;
	private String strIsDemandActiveFlag;
	private String strReqStoreId;
	
	
	private String strFromStoreId= "";
	private String strModeVal= "";
	private String strItemCategoryId= "";
	private String strStockStatus= "";
	private String strGenricItemId= "";	
	private String strIssueQtyInBase= "";	
	private String strHiddenVal= "";
	private String strUnitName= "";
	private String strIndentIssueQty = "";
	private String strItemName= "";
	private WebRowSet WsStockDetails= null;
	private String strRateUnit= "";
	private String strRateInBaseValue= "";
	private String strUnitId="";
	private WebRowSet strUnitListWs= null;
	private WebRowSet strSingleBatchDtlWs=null;
	private String strSingleItemDtl;
	private String strBSIndent;
	private String[] strBSQuantity=null;
	private String strBSReqNo;
	
	private String strCrno="0";
	private String strReturnReqNo;
	private String strSlNoflg="0"; 
	private String strBudget;
	private String strIssueTo = "";
	private WebRowSet wsIssueDetails = null;
	private WebRowSet wsItemOtherDtls = null;
	private String strFinalRemarks=""; 
	private String strItemWiseCost=""; 
	private String strApprovalRemarks=""; 
	private String strOrgName=""; 
	private String strTableWidth="";
	private String strIndentName="";
	
	private WebRowSet strIndentDetailsWs=null;
	
	private WebRowSet strItemDetailsWs=null;
	private String strLogoName ="";
	
    private String[] strTotalBatch=null;
    
    private String[] strSingleBatch=null;
	private String[] strSingleExpiry=null;
	private String[] strStockRate=null;
	private String[] strSingleManufId=null;
	
	

	
	public String[] getStrSingleBatch() {
		return strSingleBatch;
	}
	public void setStrSingleBatch(String[] strSingleBatch) {
		this.strSingleBatch = strSingleBatch;
	}
	public String[] getStrSingleExpiry() {
		return strSingleExpiry;
	}
	public void setStrSingleExpiry(String[] strSingleExpiry) {
		this.strSingleExpiry = strSingleExpiry;
	}
	public String[] getStrStockRate() {
		return strStockRate;
	}
	public void setStrStockRate(String[] strStockRate) {
		this.strStockRate = strStockRate;
	}
	public String[] getStrSingleManufId() {
		return strSingleManufId;
	}
	public void setStrSingleManufId(String[] strSingleManufId) {
		this.strSingleManufId = strSingleManufId;
	}
	public String[] getStrTotalBatch() {
		return strTotalBatch;
	}
	public void setStrTotalBatch(String[] strTotalBatch) {
		this.strTotalBatch = strTotalBatch;
	}

	
	public String getStrLogoName() {
		return strLogoName;
	}
	public void setStrLogoName(String strLogoName) {
		this.strLogoName = strLogoName;
	}
	
	public WebRowSet getStrItemDetailsWs() {
		return strItemDetailsWs;
	}
	public void setStrItemDetailsWs(WebRowSet strItemDetailsWs) {
		this.strItemDetailsWs = strItemDetailsWs;
	}
	public WebRowSet getStrIndentDetailsWs() {
		return strIndentDetailsWs;
	}
	public void setStrIndentDetailsWs(WebRowSet strIndentDetailsWs) {
		this.strIndentDetailsWs = strIndentDetailsWs;
	}
	public String getStrIndentName() {
		return strIndentName;
	}
	public void setStrIndentName(String strIndentName) {
		this.strIndentName = strIndentName;
	}
	public String getStrTableWidth() {
		return strTableWidth;
	}
	public void setStrTableWidth(String strTableWidth) {
		this.strTableWidth = strTableWidth;
	}
	public String getStrRequestTypeId() {
		return strRequestTypeId;
	}
	public void setStrRequestTypeId(String strRequestTypeId) {
		this.strRequestTypeId = strRequestTypeId;
	}
	public String getStrSingleItemDtl() {
		return strSingleItemDtl;
	}
	public void setStrSingleItemDtl(String strSingleItemDtl) {
		this.strSingleItemDtl = strSingleItemDtl;
	}
		
	public String getStrFinalRemarks() {
		return strFinalRemarks;
	}
	public void setStrFinalRemarks(String strFinalRemarks) {
		this.strFinalRemarks = strFinalRemarks;
	}
	public String getStrItemWiseCost() {
		return strItemWiseCost;
	}
	public void setStrItemWiseCost(String strItemWiseCost) {
		this.strItemWiseCost = strItemWiseCost;
	}
	public String getStrApprovalRemarks() {
		return strApprovalRemarks;
	}
	public void setStrApprovalRemarks(String strApprovalRemarks) {
		this.strApprovalRemarks = strApprovalRemarks;
	}
	public String getStrOrgName() {
		return strOrgName;
	}
	public void setStrOrgName(String strOrgName) {
		this.strOrgName = strOrgName;
	}
	public String getStrCrno() {
		return strCrno;
	}
	public void setStrCrno(String strCrno) {
		this.strCrno = strCrno;
	}
	public String getStrReturnReqNo() {
		return strReturnReqNo;
	}
	public void setStrReturnReqNo(String strReturnReqNo) {
		this.strReturnReqNo = strReturnReqNo;
	}
	public String getStrSlNoflg() {
		return strSlNoflg;
	}
	public void setStrSlNoflg(String strSlNoflg) {
		this.strSlNoflg = strSlNoflg;
	}
	public String getStrBudget() {
		return strBudget;
	}
	public void setStrBudget(String strBudget) {
		this.strBudget = strBudget;
	}
	public String getStrIssueTo() {
		return strIssueTo;
	}
	public void setStrIssueTo(String strIssueTo) {
		this.strIssueTo = strIssueTo;
	}
	public WebRowSet getWsIssueDetails() {
		return wsIssueDetails;
	}
	public void setWsIssueDetails(WebRowSet wsIssueDetails) {
		this.wsIssueDetails = wsIssueDetails;
	}
	public WebRowSet getWsItemOtherDtls() {
		return wsItemOtherDtls;
	}
	public void setWsItemOtherDtls(WebRowSet wsItemOtherDtls) {
		this.wsItemOtherDtls = wsItemOtherDtls;
	}
	public String getStrBSReqNo() {
		return strBSReqNo;
	}
	public void setStrBSReqNo(String strBSReqNo) {
		this.strBSReqNo = strBSReqNo;
	}
	public String getStrBSIndent() {
		return strBSIndent;
	}
	public void setStrBSIndent(String strBSIndent) {
		this.strBSIndent = strBSIndent;
	}
	public String[] getStrBSQuantity() {
		return strBSQuantity;
	}
	public void setStrBSQuantity(String[] strBSQuantity) {
		this.strBSQuantity = strBSQuantity;
	}
	public WebRowSet getStrSingleBatchDtlWs() {
		return strSingleBatchDtlWs;
	}
	public void setStrSingleBatchDtlWs(WebRowSet strSingleBatchDtlWs) {
		this.strSingleBatchDtlWs = strSingleBatchDtlWs;
	}
	public String getStrReqStoreId() {
		return strReqStoreId;
	}
	public void setStrReqStoreId(String strReqStoreId) {
		this.strReqStoreId = strReqStoreId;
	}
	public String getStrIsDemandActiveFlag() {
		return strIsDemandActiveFlag;
	}
	public void setStrIsDemandActiveFlag(String strIsDemandActiveFlag) {
		this.strIsDemandActiveFlag = strIsDemandActiveFlag;
	}
	public String getStrAvalaibleBudgetDtl() {
		return strAvalaibleBudgetDtl;
	}
	public void setStrAvalaibleBudgetDtl(String strAvalaibleBudgetDtl) {
		this.strAvalaibleBudgetDtl = strAvalaibleBudgetDtl;
	}
	public String getStrBudgetFlg() {
		return strBudgetFlg;
	}
	public void setStrBudgetFlg(String strBudgetFlg) {
		this.strBudgetFlg = strBudgetFlg;
	}
	public String getStrReOrderFlgColor() {
		return strReOrderFlgColor;
	}
	public void setStrReOrderFlgColor(String strReOrderFlgColor) {
		this.strReOrderFlgColor = strReOrderFlgColor;
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
	 * @return the strIssueDate
	 */
	public String getStrIssueDate() {
		return strIssueDate;
	}
	/**
	 * @param strIssueDate the strIssueDate to set
	 */
	public void setStrIssueDate(String strIssueDate) {
		this.strIssueDate = strIssueDate;
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
	 * @return the strReqTypeId
	 */
	public String getStrReqTypeId() {
		return strReqTypeId;
	}
	/**
	 * @param strReqTypeId the strReqTypeId to set
	 */
	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}
	/**
	 * @return the strItemIdArray
	 */
	public String[] getStrItemIdArray() {
		return strItemIdArray;
	}
	/**
	 * @param strItemIdArray the strItemIdArray to set
	 */
	public void setStrItemIdArray(String[] strItemIdArray) {
		this.strItemIdArray = strItemIdArray;
	}
	/**
	 * @return the strBrandIdArray
	 */
	public String[] getStrBrandIdArray() {
		return strBrandIdArray;
	}
	/**
	 * @param strBrandIdArray the strBrandIdArray to set
	 */
	public void setStrBrandIdArray(String[] strBrandIdArray) {
		this.strBrandIdArray = strBrandIdArray;
	}
	/**
	 * @return the strReservedFlagArray
	 */
	public String[] getStrReservedFlagArray() {
		return strReservedFlagArray;
	}
	/**
	 * @param strReservedFlagArray the strReservedFlagArray to set
	 */
	public void setStrReservedFlagArray(String[] strReservedFlagArray) {
		this.strReservedFlagArray = strReservedFlagArray;
	}
	/**
	 * @return the strRateArray
	 */
	public String[] getStrRateArray() {
		return strRateArray;
	}
	/**
	 * @param strRateArray the strRateArray to set
	 */
	public void setStrRateArray(String[] strRateArray) {
		this.strRateArray = strRateArray;
	}
	/**
	 * @return the strRateUnitIdArray
	 */
	public String[] getStrRateUnitIdArray() {
		return strRateUnitIdArray;
	}
	/**
	 * @param strRateUnitIdArray the strRateUnitIdArray to set
	 */
	public void setStrRateUnitIdArray(String[] strRateUnitIdArray) {
		this.strRateUnitIdArray = strRateUnitIdArray;
	}
	/**
	 * @return the stockDtlsId
	 */
	public String[] getStockDtlsId() {
		return stockDtlsId;
	}
	/**
	 * @param stockDtlsId the stockDtlsId to set
	 */
	public void setStockDtlsId(String[] stockDtlsId) {
		this.stockDtlsId = stockDtlsId;
	}
	/**
	 * @return the strStochStatusCodeArray
	 */
	public String[] getStrStochStatusCodeArray() {
		return strStochStatusCodeArray;
	}
	/**
	 * @param strStochStatusCodeArray the strStochStatusCodeArray to set
	 */
	public void setStrStochStatusCodeArray(String[] strStochStatusCodeArray) {
		this.strStochStatusCodeArray = strStochStatusCodeArray;
	}
	/**
	 * @return the strBatchSlNoArray
	 */
	public String[] getStrBatchSlNoArray() {
		return strBatchSlNoArray;
	}
	/**
	 * @param strBatchSlNoArray the strBatchSlNoArray to set
	 */
	public void setStrBatchSlNoArray(String[] strBatchSlNoArray) {
		this.strBatchSlNoArray = strBatchSlNoArray;
	}
	/**
	 * @return the strItemSlNoArray
	 */
	public String[] getStrItemSlNoArray() {
		return strItemSlNoArray;
	}
	/**
	 * @param strItemSlNoArray the strItemSlNoArray to set
	 */
	public void setStrItemSlNoArray(String[] strItemSlNoArray) {
		this.strItemSlNoArray = strItemSlNoArray;
	}
	/**
	 * @return the strGroupIdArray
	 */
	public String[] getStrGroupIdArray() {
		return strGroupIdArray;
	}
	/**
	 * @param strGroupIdArray the strGroupIdArray to set
	 */
	public void setStrGroupIdArray(String[] strGroupIdArray) {
		this.strGroupIdArray = strGroupIdArray;
	}
	/**
	 * @return the strSubGroupIdArray
	 */
	public String[] getStrSubGroupIdArray() {
		return strSubGroupIdArray;
	}
	/**
	 * @param strSubGroupIdArray the strSubGroupIdArray to set
	 */
	public void setStrSubGroupIdArray(String[] strSubGroupIdArray) {
		this.strSubGroupIdArray = strSubGroupIdArray;
	}
	/**
	 * @return the strAvlQtyArray
	 */
	public String[] getStrAvlQtyArray() {
		return strAvlQtyArray;
	}
	/**
	 * @param strAvlQtyArray the strAvlQtyArray to set
	 */
	public void setStrAvlQtyArray(String[] strAvlQtyArray) {
		this.strAvlQtyArray = strAvlQtyArray;
	}
	/**
	 * @return the strAvlQtyUnitIdArray
	 */
	public String[] getStrAvlQtyUnitIdArray() {
		return strAvlQtyUnitIdArray;
	}
	/**
	 * @param strAvlQtyUnitIdArray the strAvlQtyUnitIdArray to set
	 */
	public void setStrAvlQtyUnitIdArray(String[] strAvlQtyUnitIdArray) {
		this.strAvlQtyUnitIdArray = strAvlQtyUnitIdArray;
	}
	/**
	 * @return the strBalQtyArray
	 */
	public String[] getStrBalQtyArray() {
		return strBalQtyArray;
	}
	/**
	 * @param strBalQtyArray the strBalQtyArray to set
	 */
	public void setStrBalQtyArray(String[] strBalQtyArray) {
		this.strBalQtyArray = strBalQtyArray;
	}
	/**
	 * @return the strBalQtyUnitIdArray
	 */
	public String[] getStrBalQtyUnitIdArray() {
		return strBalQtyUnitIdArray;
	}
	/**
	 * @param strBalQtyUnitIdArray the strBalQtyUnitIdArray to set
	 */
	public void setStrBalQtyUnitIdArray(String[] strBalQtyUnitIdArray) {
		this.strBalQtyUnitIdArray = strBalQtyUnitIdArray;
	}
	/**
	 * @return the strIssueQtyArray
	 */
	public String[] getStrIssueQtyArray() {
		return strIssueQtyArray;
	}
	/**
	 * @param strIssueQtyArray the strIssueQtyArray to set
	 */
	public void setStrIssueQtyArray(String[] strIssueQtyArray) {
		this.strIssueQtyArray = strIssueQtyArray;
	}
	/**
	 * @return the strIssueQtyUnitIdArray
	 */
	public String[] getStrIssueQtyUnitIdArray() {
		return strIssueQtyUnitIdArray;
	}
	/**
	 * @param strIssueQtyUnitIdArray the strIssueQtyUnitIdArray to set
	 */
	public void setStrIssueQtyUnitIdArray(String[] strIssueQtyUnitIdArray) {
		this.strIssueQtyUnitIdArray = strIssueQtyUnitIdArray;
	}
	/**
	 * @return the strManufDateArray
	 */
	public String[] getStrManufDateArray() {
		return strManufDateArray;
	}
	/**
	 * @param strManufDateArray the strManufDateArray to set
	 */
	public void setStrManufDateArray(String[] strManufDateArray) {
		this.strManufDateArray = strManufDateArray;
	}
	/**
	 * @return the strExpiryDateUnitIdArray
	 */
	public String[] getStrExpiryDateUnitIdArray() {
		return strExpiryDateUnitIdArray;
	}
	/**
	 * @param strExpiryDateUnitIdArray the strExpiryDateUnitIdArray to set
	 */
	public void setStrExpiryDateUnitIdArray(String[] strExpiryDateUnitIdArray) {
		this.strExpiryDateUnitIdArray = strExpiryDateUnitIdArray;
	}
	/**
	 * @return the strConsumableFlagArray
	 */
	public String[] getStrConsumableFlagArray() {
		return strConsumableFlagArray;
	}
	/**
	 * @param strConsumableFlagArray the strConsumableFlagArray to set
	 */
	public void setStrConsumableFlagArray(String[] strConsumableFlagArray) {
		this.strConsumableFlagArray = strConsumableFlagArray;
	}
	/**
	 * @return the strCostArray
	 */
	public String[] getStrCostArray() {
		return strCostArray;
	}
	/**
	 * @param strCostArray the strCostArray to set
	 */
	public void setStrCostArray(String[] strCostArray) {
		this.strCostArray = strCostArray;
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
	/**
	 * @return the itemDetailsWS
	 */
	public WebRowSet getItemDetailsWS() {
		return itemDetailsWS;
	}
	/**
	 * @param itemDetailsWS the itemDetailsWS to set
	 */
	public void setItemDetailsWS(WebRowSet itemDetailsWS) {
		this.itemDetailsWS = itemDetailsWS;
	}
	/**
	 * @return the unitComboWS
	 */
	public WebRowSet getUnitComboWS() {
		return unitComboWS;
	}
	/**
	 * @param unitComboWS the unitComboWS to set
	 */
	public void setUnitComboWS(WebRowSet unitComboWS) {
		this.unitComboWS = unitComboWS;
	}
	/**
	 * @return the strSancUnitId
	 */
	public String getStrSancUnitId() {
		return strSancUnitId;
	}
	/**
	 * @param strSancUnitId the strSancUnitId to set
	 */
	public void setStrSancUnitId(String strSancUnitId) {
		this.strSancUnitId = strSancUnitId;
	}
	/**
	 * @return the strItemId
	 */
	public String getStrItemId() {
		return strItemId;
	}
	/**
	 * @param strItemId the strItemId to set
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}
	/**
	 * @return the strItemBrand
	 */
	public String getStrItemBrand() {
		return strItemBrand;
	}
	/**
	 * @param strItemBrand the strItemBrand to set
	 */
	public void setStrItemBrand(String strItemBrand) {
		this.strItemBrand = strItemBrand;
	}
	/**
	 * @return the popupWS
	 */
	public WebRowSet getPopupWS() {
		return popupWS;
	}
	/**
	 * @param popupWS the popupWS to set
	 */
	public void setPopupWS(WebRowSet popupWS) {
		this.popupWS = popupWS;
	}
	/**
	 * @return the strItemCategoryNo
	 */
	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}
	/**
	 * @param strItemCategoryNo the strItemCategoryNo to set
	 */
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}
	/**
	 * @return the strPopUpData
	 */
	public String getStrPopUpData() {
		return StrPopUpData;
	}
	/**
	 * @param strPopUpData the strPopUpData to set
	 */
	public void setStrPopUpData(String strPopUpData) {
		StrPopUpData = strPopUpData;
	}
	/**
	 * @return the strReqStatusName
	 */
	public String getStrReqStatusName() {
		return strReqStatusName;
	}
	/**
	 * @param strReqStatusName the strReqStatusName to set
	 */
	public void setStrReqStatusName(String strReqStatusName) {
		this.strReqStatusName = strReqStatusName;
	}
	
	/**
	 * @return the strViewItemName
	 */
	public String getStrViewItemName() {
		return strViewItemName;
	}
	/**
	 * @param strViewItemName the strViewItemName to set
	 */
	public void setStrViewItemName(String strViewItemName) {
		this.strViewItemName = strViewItemName;
	}
	/**
	 * @return the strViewAvlQty
	 */
	public String getStrViewAvlQty() {
		return strViewAvlQty;
	}
	/**
	 * @param strViewAvlQty the strViewAvlQty to set
	 */
	public void setStrViewAvlQty(String strViewAvlQty) {
		this.strViewAvlQty = strViewAvlQty;
	}
	/**
	 * @return the strViewSancQty
	 */
	public String getStrViewSancQty() {
		return strViewSancQty;
	}
	/**
	 * @param strViewSancQty the strViewSancQty to set
	 */
	public void setStrViewSancQty(String strViewSancQty) {
		this.strViewSancQty = strViewSancQty;
	}
	/**
	 * @return the strViewItemDtls
	 */
	public String getStrViewItemDtls() {
		return strViewItemDtls;
	}
	/**
	 * @param strViewItemDtls the strViewItemDtls to set
	 */
	public void setStrViewItemDtls(String strViewItemDtls) {
		this.strViewItemDtls = strViewItemDtls;
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
	 * @return the strItemRemarksArray
	 */
	public String[] getStrItemRemarksArray() {
		return strItemRemarksArray;
	}
	/**
	 * @param strItemRemarksArray the strItemRemarksArray to set
	 */
	public void setStrItemRemarksArray(String[] strItemRemarksArray) {
		this.strItemRemarksArray = strItemRemarksArray;
	}
	/**
	 * @return the strRateBaseValArray
	 */
	public String[] getStrRateBaseValArray() {
		return strRateBaseValArray;
	}
	/**
	 * @param strRateBaseValArray the strRateBaseValArray to set
	 */
	public void setStrRateBaseValArray(String[] strRateBaseValArray) {
		this.strRateBaseValArray = strRateBaseValArray;
	}
	/**
	 * @return the strReservedFlag
	 */
	public String getStrReservedFlag() {
		return strReservedFlag;
	}
	/**
	 * @param strReservedFlag the strReservedFlag to set
	 */
	public void setStrReservedFlag(String strReservedFlag) {
		this.strReservedFlag = strReservedFlag;
	}
	/**
	 * @return the recievedByWS
	 */
	public WebRowSet getRecievedByWS() {
		return recievedByWS;
	}
	/**
	 * @param recievedByWS the recievedByWS to set
	 */
	public void setRecievedByWS(WebRowSet recievedByWS) {
		this.recievedByWS = recievedByWS;
	}
	
	public String[] getStrFinalCost() {
		return strFinalCost;
	}
	public void setStrFinalCost(String[] strFinalCost) {
		this.strFinalCost = strFinalCost;
	}
	public String getStrFinalApproxAmt() {
		return strFinalApproxAmt;
	}
	public void setStrFinalApproxAmt(String strFinalApproxAmt) {
		this.strFinalApproxAmt = strFinalApproxAmt;
	}
	public String getStrAvalaibleBudget() {
		return strAvalaibleBudget;
	}
	public void setStrAvalaibleBudget(String strAvalaibleBudget) {
		this.strAvalaibleBudget = strAvalaibleBudget;
	}
	public String getStrFinancialStartDate() {
		return strFinancialStartDate;
	}
	public void setStrFinancialStartDate(String strFinancialStartDate) {
		this.strFinancialStartDate = strFinancialStartDate;
	}
	public String getStrFinancialEndDate() {
		return strFinancialEndDate;
	}
	public void setStrFinancialEndDate(String strFinancialEndDate) {
		this.strFinancialEndDate = strFinancialEndDate;
	}
	public String getStrFromStoreId() {
		return strFromStoreId;
	}
	public void setStrFromStoreId(String strFromStoreId) {
		this.strFromStoreId = strFromStoreId;
	}
	public String getStrModeVal() {
		return strModeVal;
	}
	public void setStrModeVal(String strModeVal) {
		this.strModeVal = strModeVal;
	}
	public String getStrItemCategoryId() {
		return strItemCategoryId;
	}
	public void setStrItemCategoryId(String strItemCategoryId) {
		this.strItemCategoryId = strItemCategoryId;
	}
	public String getStrStockStatus() {
		return strStockStatus;
	}
	public void setStrStockStatus(String strStockStatus) {
		this.strStockStatus = strStockStatus;
	}
	public String getStrGenricItemId() {
		return strGenricItemId;
	}
	public void setStrGenricItemId(String strGenricItemId) {
		this.strGenricItemId = strGenricItemId;
	}
	public String getStrIssueQtyInBase() {
		return strIssueQtyInBase;
	}
	public void setStrIssueQtyInBase(String strIssueQtyInBase) {
		this.strIssueQtyInBase = strIssueQtyInBase;
	}
	public String getStrHiddenVal() {
		return strHiddenVal;
	}
	public void setStrHiddenVal(String strHiddenVal) {
		this.strHiddenVal = strHiddenVal;
	}
	public String getStrUnitName() {
		return strUnitName;
	}
	public void setStrUnitName(String strUnitName) {
		this.strUnitName = strUnitName;
	}
	public String getStrIndentIssueQty() {
		return strIndentIssueQty;
	}
	public void setStrIndentIssueQty(String strIndentIssueQty) {
		this.strIndentIssueQty = strIndentIssueQty;
	}
	public String getStrItemName() {
		return strItemName;
	}
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}
	public WebRowSet getWsStockDetails() {
		return WsStockDetails;
	}
	public void setWsStockDetails(WebRowSet wsStockDetails) {
		WsStockDetails = wsStockDetails;
	}
	public String getStrRateUnit() {
		return strRateUnit;
	}
	public void setStrRateUnit(String strRateUnit) {
		this.strRateUnit = strRateUnit;
	}
	public String getStrRateInBaseValue() {
		return strRateInBaseValue;
	}
	public void setStrRateInBaseValue(String strRateInBaseValue) {
		this.strRateInBaseValue = strRateInBaseValue;
	}
	public String getStrUnitId() {
		return strUnitId;
	}
	public void setStrUnitId(String strUnitId) {
		this.strUnitId = strUnitId;
	}
	public WebRowSet getStrUnitListWs() {
		return strUnitListWs;
	}
	public void setStrUnitListWs(WebRowSet strUnitListWs) {
		this.strUnitListWs = strUnitListWs;
	}
	
}
