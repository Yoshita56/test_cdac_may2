/**
 * 
 */
package mms.transactions.controller.fb;


import javax.sql.rowset.WebRowSet;

import hisglobal.transactionutil.GenericFormBean;

/**
 * @author Balasubramaniam M
 * @version 1.0
 * @since 01/Apr/2009
 * 
 */
public class IssueDeskTransFB extends GenericFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 02L;

	
	private String strErr = "";
	private String strWarning = "";
	private String strNormalMsg = "";
	
	private String strItemCategoryNo = "";
	
	
	private String[] strAvlQty = null; 
	private String[] strBalQty = null; 
	private String[] strSancUnitId = null; 
	private String[] stockDtlsId = null; 
	//private String[] strRate = null; 
	//private String[] strRateUnitId = null; 
	private String[] strItemDetailsChk = null; 
	private String[] strIssueQty = null; 
	private String[] strIssueUnitId = null; 
	private String strReqStatusName = ""; 
	private String[] strItemRemarks = null; 
	private String strViewItemName = "";
	private String strViewAvlQty = "";
	private String strViewSancQty = ""; 
	private String strViewItemDtls = "";  
	private String strIssuedItemDtls = "";
	
	private String strStoreName = "";
	private String strStoreId = "0";
	
	private String strRaisingStoreName = "";
	private String strRaisingStoreId = "0";
	
	private String strIndentNo = "0";
	private String strIndentDate = "";
	private String strIndentType = "";
	private String strItemCategory = "";
	
	private String strHospitalCode = "";
	private String strSeatId = "";	
	private String strRemarks = "";
	
	private String strItemDtls = "";
	
	private String strReceivedBy = "";
	
	private String strChk = "";
	
	
	private String strIssueNo = "0";
	private String strIssueDate = "0";
	private String strReceivedByOptionVal="";
	private String strReOrderFlgColor;
	private String strBudgetFlg;

    private String[] strFinalCost = null;
	private String strFinalApproxAmt;

	private String strAvalaibleBudget;
	private String strAvalaibleBudgetDtl;
	private String strIsDemandActiveFlag="0";
	
	private String strFromStoreId= "";
	private String strModeVal= "";
	private String strItemCategoryId= "";
	private String strStockStatus= "";
	private String strGenricItemId= "";
	private String strItemId= "";
	private String strIssueQtyInBase= "";
	private String strReservedFlag= "";
	private String strHiddenVal= "";
	private String strUnitName= "";
	private String strIndentIssueQty = "";
	private String strItemName= "";
	private WebRowSet WsStockDetails= null;
	private String strRateUnit= "";
	private String strRateInBaseValue= "";
	private String usrArg = "";
	private String strIndex;
	private String strGblVal;
	private String strParentIndex;
	
	private String strPath; 
	private String strBSIndent;
	private String[] strBSQuantity=null;
	private String strRemarksIndent;
	private String strRemarksAppone;
	private String strRemarksApptwo;
	
	
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
	public String getStrRemarksIndent() {
		return strRemarksIndent;
	}
	public void setStrRemarksIndent(String strRemarksIndent) {
		this.strRemarksIndent = strRemarksIndent;
	}
	public String getStrRemarksAppone() {
		return strRemarksAppone;
	}
	public void setStrRemarksAppone(String strRemarksAppone) {
		this.strRemarksAppone = strRemarksAppone;
	}
	public String getStrRemarksApptwo() {
		return strRemarksApptwo;
	}
	public void setStrRemarksApptwo(String strRemarksApptwo) {
		this.strRemarksApptwo = strRemarksApptwo;
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
	public String getStrPath() {
		return strPath;
	}
	public void setStrPath(String strPath) {
		this.strPath = strPath;
	}
	public String getStrParentIndex() {
		return strParentIndex;
	}
	public void setStrParentIndex(String strParentIndex) {
		this.strParentIndex = strParentIndex;
	}
	public String getStrGblVal() {
		return strGblVal;
	}
	public void setStrGblVal(String strGblVal) {
		this.strGblVal = strGblVal;
	}
	public String getUsrArg() {
		return usrArg;
	}
	public void setUsrArg(String usrArg) {
		this.usrArg = usrArg;
	}
	public String getStrIndex() {
		return strIndex;
	}
	public void setStrIndex(String strIndex) {
		this.strIndex = strIndex;
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
	 * @return the strReceivedByOptionVal
	 */
	public String getStrReceivedByOptionVal() {
		return strReceivedByOptionVal;
	}
	/**
	 * @param strReceivedByOptionVal the strReceivedByOptionVal to set
	 */
	public void setStrReceivedByOptionVal(String strReceivedByOptionVal) {
		this.strReceivedByOptionVal = strReceivedByOptionVal;
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
	 * @return the strIssuedItemDtls
	 */
	public String getStrIssuedItemDtls() {
		return strIssuedItemDtls;
	}
	/**
	 * @param strIssuedItemDtls the strIssuedItemDtls to set
	 */
	public void setStrIssuedItemDtls(String strIssuedItemDtls) {
		this.strIssuedItemDtls = strIssuedItemDtls;
	}
	/**
	 * @return the strIssueQty
	 */
	public String[] getStrIssueQty() {
		return strIssueQty;
	}
	/**
	 * @param strIssueQty the strIssueQty to set
	 */
	public void setStrIssueQty(String[] strIssueQty) {
		this.strIssueQty = strIssueQty;
	}
	/**
	 * @return the strIssueUnitId
	 */
	public String[] getStrIssueUnitId() {
		return strIssueUnitId;
	}
	/**
	 * @param strIssueUnitId the strIssueUnitId to set
	 */
	public void setStrIssueUnitId(String[] strIssueUnitId) {
		this.strIssueUnitId = strIssueUnitId;
	}
	/**
	 * @return the strItemDetailsChk
	 */
	public String[] getStrItemDetailsChk() {
		return strItemDetailsChk;
	}
	/**
	 * @param strItemDetailsChk the strItemDetailsChk to set
	 */
	public void setStrItemDetailsChk(String[] strItemDetailsChk) {
		this.strItemDetailsChk = strItemDetailsChk;
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
	 * @return the strBalQty
	 */
	public String[] getStrBalQty() {
		return strBalQty;
	}
	/**
	 * @param strBalQty the strBalQty to set
	 */
	public void setStrBalQty(String[] strBalQty) {
		this.strBalQty = strBalQty;
	}
	/**
	 * @return the strSancUnitId
	 */
	public String[] getStrSancUnitId() {
		return strSancUnitId;
	}
	/**
	 * @param strSancUnitId the strSancUnitId to set
	 */
	public void setStrSancUnitId(String[] strSancUnitId) {
		this.strSancUnitId = strSancUnitId;
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
	 * @return the strItemRemarks
	 */
	public String[] getStrItemRemarks() {
		return strItemRemarks;
	}
	/**
	 * @param strItemRemarks the strItemRemarks to set
	 */
	public void setStrItemRemarks(String[] strItemRemarks) {
		this.strItemRemarks = strItemRemarks;
	}
	/**
	 * @return the strChk
	 */
	public String getStrChk() {
		return strChk;
	}
	/**
	 * @param strChk the strChk to set
	 */
	public void setStrChk(String strChk) {
		this.strChk = strChk;
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
	public String getStrAvalaibleBudgetDtl() {
		return strAvalaibleBudgetDtl;
	}
	public void setStrAvalaibleBudgetDtl(String strAvalaibleBudgetDtl) {
		this.strAvalaibleBudgetDtl = strAvalaibleBudgetDtl;
	}
	public String getStrIsDemandActiveFlag() {
		return strIsDemandActiveFlag;
	}
	public void setStrIsDemandActiveFlag(String strIsDemandActiveFlag) {
		this.strIsDemandActiveFlag = strIsDemandActiveFlag;
	}
	public String[] getStrFinalCost() {
		return strFinalCost;
	}
	public void setStrFinalCost(String[] strFinalCost) {
		this.strFinalCost = strFinalCost;
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
	public String getStrItemId() {
		return strItemId;
	}
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}
	public String getStrIssueQtyInBase() {
		return strIssueQtyInBase;
	}
	public void setStrIssueQtyInBase(String strIssueQtyInBase) {
		this.strIssueQtyInBase = strIssueQtyInBase;
	}
	public String getStrReservedFlag() {
		return strReservedFlag;
	}
	public void setStrReservedFlag(String strReservedFlag) {
		this.strReservedFlag = strReservedFlag;
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
	
	
}
