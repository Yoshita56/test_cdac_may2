
package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;
public class ReplacementCondemnationOrderTransVO {
	private String strMsgType="";
	private String strErr="";
	private String strWarning="";
	private String strMsgString="";
	private String strMsg="";		
	private String strItemCatValues="";	
	private String strHospitalCode="";
	private String strSeatId="";
	private String strStoreId="";
	private String strItemCatNo="";
	private String strRemarks="";		
	private String strItemId="";
	private String strItemPopupData="";	
	private String strSupplierId="";
	private String strPoNo= "";	
	private String 	strcatno="";
	private String strCommitteType= "";	
	private String strOrderHiddenValue="";
	private String[] strPODetailsHidValue = null; 
	private String[] strExpiryDrugs = null;
	private String[] condemqty = null;
	private String[] strRetActionType = null;
	 private String[] strItemRemarks = null;
	 
	public String[] getStrItemRemarks() {
		return strItemRemarks;
	}
	public void setStrItemRemarks(String[] strItemRemarks) {
		this.strItemRemarks = strItemRemarks;
	}
	public String[] getStrRetActionType() {
		return strRetActionType;
	}
	public void setStrRetActionType(String[] strRetActionType) {
		this.strRetActionType = strRetActionType;
	}
	public String[] getCondemqty() {
		return condemqty;
	}
	public void setCondemqty(String[] condemqty) {
		this.condemqty = condemqty;
	}
	public String[] getStrExpiryDrugs() {
		return strExpiryDrugs;
	}
	public void setStrExpiryDrugs(String[] strExpiryDrugs) {
		this.strExpiryDrugs = strExpiryDrugs;
	}
	public String getStrOrderHiddenValue() {
		return strOrderHiddenValue;
	}
	public void setStrOrderHiddenValue(String strOrderHiddenValue) {
		this.strOrderHiddenValue = strOrderHiddenValue;
	}
	public String getStrCommitteType() {
		return strCommitteType;
	}
	public void setStrCommitteType(String strCommitteType) {
		this.strCommitteType = strCommitteType;
	}
	public String getStrcatno() {
		return strcatno;
	}
	public void setStrcatno(String strcatno) {
		this.strcatno = strcatno;
	}
	private WebRowSet wbsStoreNameCombo=null;
	private WebRowSet wbApprovedBy=null;
	private WebRowSet wbCommitteType=null;
	
	public WebRowSet getWbCommitteType() {
		return wbCommitteType;
	}
	public void setWbCommitteType(WebRowSet wbCommitteType) {
		this.wbCommitteType = wbCommitteType;
	}
	private WebRowSet wbExpiryDrug=null;
	private WebRowSet wbSuggestedDrug=null;
	private WebRowSet wbItemName=null;
	public WebRowSet getWbItemName() {
		return wbItemName;
	}
	public void setWbItemName(WebRowSet wbItemName) {
		this.wbItemName = wbItemName;
	}
	private WebRowSet wbRejectedDrug=null;
	private String strMode;  
    //by santosh
    
    private WebRowSet wsNOSQItemDetail=null;
    private WebRowSet wsStockDetails=null;
    private WebRowSet wsOrderScheduleDtl=null;
    private WebRowSet wsScheduleQty=null;
    private WebRowSet wsPendingOrderDtl=null;
    private WebRowSet wsRegularIndentDrugs= null;
    private WebRowSet ItemCategWS= null;
    private WebRowSet supplierWS= null;
    private String strItemBrandId="";
    private String strBatchNo="";
    private String[] strReplacedQty={""};
    private String strTableWidth;
    private String strHiddenItemDtl;
    private String strSchduleNo;
    private String strNosqDrugs="";
    private String strNextDeliveryDate;
    private String[] strQtySchHidValue = null;
    private String strApprovedByVals="";
    private String strVerifiedDate="";
    private String strVerifiedBy="";
    
    private String strActionHiddenValue="";
    private String strReplacementQty="";
    private String strActionsId="";
    private String strDeliveryDate="";
    private String strActionMode="0";


	public String getStrActionHiddenValue() {
		return strActionHiddenValue;
	}
	public void setStrActionHiddenValue(String strActionHiddenValue) {
		this.strActionHiddenValue = strActionHiddenValue;
	}
	public String getStrReplacementQty() {
		return strReplacementQty;
	}
	public void setStrReplacementQty(String strReplacementQty) {
		this.strReplacementQty = strReplacementQty;
	}
	public String getStrActionsId() {
		return strActionsId;
	}
	public void setStrActionsId(String strActionsId) {
		this.strActionsId = strActionsId;
	}
	public String getStrDeliveryDate() {
		return strDeliveryDate;
	}
	public void setStrDeliveryDate(String strDeliveryDate) {
		this.strDeliveryDate = strDeliveryDate;
	}
	public String getStrVerifiedBy() {
		return strVerifiedBy;
	}
	public void setStrVerifiedBy(String strVerifiedBy) {
		this.strVerifiedBy = strVerifiedBy;
	}
	public String getStrApprovedByVals() {
		return strApprovedByVals;
	}
	public void setStrApprovedByVals(String strApprovedByVals) {
		this.strApprovedByVals = strApprovedByVals;
	}
	public String getStrVerifiedDate() {
		return strVerifiedDate;
	}
	public void setStrVerifiedDate(String strVerifiedDate) {
		this.strVerifiedDate = strVerifiedDate;
	}
	
	public String getStrMsgType() {
		return strMsgType;
	}
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
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
	public String getStrMsgString() {
		return strMsgString;
	}
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}
	public String getStrMsg() {
		return strMsg;
	}
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}
	public String getStrItemCatValues() {
		return strItemCatValues;
	}
	public void setStrItemCatValues(String strItemCatValues) {
		this.strItemCatValues = strItemCatValues;
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
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrItemCatNo() {
		return strItemCatNo;
	}
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrItemId() {
		return strItemId;
	}
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}
	public String getStrItemPopupData() {
		return strItemPopupData;
	}
	public void setStrItemPopupData(String strItemPopupData) {
		this.strItemPopupData = strItemPopupData;
	}
	public String getStrSupplierId() {
		return strSupplierId;
	}
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}
	public String getStrPoNo() {
		return strPoNo;
	}
	public void setStrPoNo(String strPoNo) {
		this.strPoNo = strPoNo;
	}
	public WebRowSet getWbsStoreNameCombo() {
		return wbsStoreNameCombo;
	}
	public void setWbsStoreNameCombo(WebRowSet wbsStoreNameCombo) {
		this.wbsStoreNameCombo = wbsStoreNameCombo;
	}
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
	public WebRowSet getWsNOSQItemDetail() {
		return wsNOSQItemDetail;
	}
	public void setWsNOSQItemDetail(WebRowSet wsNOSQItemDetail) {
		this.wsNOSQItemDetail = wsNOSQItemDetail;
	}
	public WebRowSet getWsStockDetails() {
		return wsStockDetails;
	}
	public void setWsStockDetails(WebRowSet wsStockDetails) {
		this.wsStockDetails = wsStockDetails;
	}
	public WebRowSet getWsOrderScheduleDtl() {
		return wsOrderScheduleDtl;
	}
	public void setWsOrderScheduleDtl(WebRowSet wsOrderScheduleDtl) {
		this.wsOrderScheduleDtl = wsOrderScheduleDtl;
	}
	public WebRowSet getWsScheduleQty() {
		return wsScheduleQty;
	}
	public void setWsScheduleQty(WebRowSet wsScheduleQty) {
		this.wsScheduleQty = wsScheduleQty;
	}
	public WebRowSet getWsPendingOrderDtl() {
		return wsPendingOrderDtl;
	}
	public void setWsPendingOrderDtl(WebRowSet wsPendingOrderDtl) {
		this.wsPendingOrderDtl = wsPendingOrderDtl;
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
	public String[] getStrReplacedQty() {
		return strReplacedQty;
	}
	public void setStrReplacedQty(String[] strReplacedQty) {
		this.strReplacedQty = strReplacedQty;
	}
	public String getStrTableWidth() {
		return strTableWidth;
	}
	public void setStrTableWidth(String strTableWidth) {
		this.strTableWidth = strTableWidth;
	}
	public String getStrHiddenItemDtl() {
		return strHiddenItemDtl;
	}
	public void setStrHiddenItemDtl(String strHiddenItemDtl) {
		this.strHiddenItemDtl = strHiddenItemDtl;
	}
	public String getStrSchduleNo() {
		return strSchduleNo;
	}
	public void setStrSchduleNo(String strSchduleNo) {
		this.strSchduleNo = strSchduleNo;
	}
	public String getStrNosqDrugs() {
		return strNosqDrugs;
	}
	public void setStrNosqDrugs(String strNosqDrugs) {
		this.strNosqDrugs = strNosqDrugs;
	}
	public String getStrNextDeliveryDate() {
		return strNextDeliveryDate;
	}
	public void setStrNextDeliveryDate(String strNextDeliveryDate) {
		this.strNextDeliveryDate = strNextDeliveryDate;
	}
	public String[] getStrQtySchHidValue() {
		return strQtySchHidValue;
	}
	public void setStrQtySchHidValue(String[] strQtySchHidValue) {
		this.strQtySchHidValue = strQtySchHidValue;
	}
	public String[] getStrPODetailsHidValue() {
		return strPODetailsHidValue;
	}
	public void setStrPODetailsHidValue(String[] strPODetailsHidValue) {
		this.strPODetailsHidValue = strPODetailsHidValue;
	}
	public WebRowSet getWbApprovedBy() {
		return wbApprovedBy;
	}
	public void setWbApprovedBy(WebRowSet wbApprovedBy) {
		this.wbApprovedBy = wbApprovedBy;
	}
	public WebRowSet getWbExpiryDrug() {
		return wbExpiryDrug;
	}
	public void setWbExpiryDrug(WebRowSet wbExpiryDrug) {
		this.wbExpiryDrug = wbExpiryDrug;
	}
	public WebRowSet getWbRejectedDrug() {
		return wbRejectedDrug;
	}
	public void setWbRejectedDrug(WebRowSet wbRejectedDrug) {
		this.wbRejectedDrug = wbRejectedDrug;
	}
	public String getStrActionMode() {
		return strActionMode;
	}
	public void setStrActionMode(String strActionMode) {
		this.strActionMode = strActionMode;
	}
	public WebRowSet getWsRegularIndentDrugs() {
		return wsRegularIndentDrugs;
	}
	public void setWsRegularIndentDrugs(WebRowSet wsRegularIndentDrugs) {
		this.wsRegularIndentDrugs = wsRegularIndentDrugs;
	}
	public WebRowSet getSupplierWS() {
		return supplierWS;
	}
	public void setSupplierWS(WebRowSet supplierWS) {
		this.supplierWS = supplierWS;
	}
	public WebRowSet getItemCategWS() {
		return ItemCategWS;
	}
	public void setItemCategWS(WebRowSet itemCategWS) {
		ItemCategWS = itemCategWS;
	}
	public WebRowSet getWbSuggestedDrug() {
		return wbSuggestedDrug;
	}
	public void setWbSuggestedDrug(WebRowSet wbSuggestedDrug) {
		this.wbSuggestedDrug = wbSuggestedDrug;
	}
}
