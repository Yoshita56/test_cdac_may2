
package mms.transactions.controller.fb;

import hisglobal.transactionutil.GenericFormBean;

import javax.sql.rowset.WebRowSet;

public class ReplacementCondemnationOrderTransFB extends GenericFormBean {	

	private static final long serialVersionUID = 1L;
	
	private String strMsgType="";
	private String strErr="";
	private String strWarning="";
	private String strMsg="";	
	private String strMsgString="";
	private String strRemarks="";
	private String strHospitalCode="";
	private String strSeatId="";
	private String strStoreId="";	
	private String strStoreName="";
	private String strItemId="";	
	private String strSupplierId="";	
	private String strPoNo= "";	
	private String strCommitteType= "";	
	public String getStrCommitteType() {
		return strCommitteType;
	}
	public void setStrCommitteType(String strCommitteType) {
		this.strCommitteType = strCommitteType;
	}
	private WebRowSet wbsStoreNameCombo=null;
	
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
	private String strMode;    
    private String strApprovedByVals="";
    private String strVerifiedDate="";
    private String strVerifiedBy="";
    private String strCatName="";
    private String strcatno="";
    private String strsupplierno="";
    private String strSupplierName="";
    private String strItemCode="";
    private String strItemNameValues="";
    private String strCase="";
   
	private String strOrderHiddenValue="";
  
    public String getStrCase() {
		return strCase;
	}
	public void setStrCase(String strCase) {
		this.strCase = strCase;
	}
	public String getStrsupplierno() {
		return strsupplierno;
	}
	public void setStrsupplierno(String strsupplierno) {
		this.strsupplierno = strsupplierno;
	}
	public String getStrItemCode() {
		return strItemCode;
	}
	public void setStrItemCode(String strItemCode) {
		this.strItemCode = strItemCode;
	}
	public String getStrItemNameValues() {
		return strItemNameValues;
	}
	public void setStrItemNameValues(String strItemNameValues) {
		this.strItemNameValues = strItemNameValues;
	}
	public String getStrSupplierName() {
		return strSupplierName;
	}
	public void setStrSupplierName(String strSupplierName) {
		this.strSupplierName = strSupplierName;
	}
	public String getStrCatName() {
		return strCatName;
	}
	public void setStrCatName(String strCatName) {
		this.strCatName = strCatName;
	}
	public String getStrcatno() {
		return strcatno;
	}
	public void setStrcatno(String strcatno) {
		this.strcatno = strcatno;
	}
	//added by santosh
    private String strCtDate;
    private String strNextDeliveryDate;
    private WebRowSet wsOrderScheduleDtl=null;
    private String[] strReplacedQty={""};
    private String strNosqDrugs="";
    private String[] strQtySchHidValue = null;
    private String strActionHiddenValue="";
    private String strReplacementQty="";
    private String strActionsId="";
    private String strDeliveryDate="";
    private String strActionMode="0";
    private String strByCurrentAndDate="0";
    
    private String strIndentedDrugs;
    private String strIndentedDrugFlg;
    
	public String getStrIndentedDrugFlg() {
		return strIndentedDrugFlg;
	}
	public void setStrIndentedDrugFlg(String strIndentedDrugFlg) {
		this.strIndentedDrugFlg = strIndentedDrugFlg;
	}
	public String getStrIndentedDrugs() {
		return strIndentedDrugs;
	}
	public void setStrIndentedDrugs(String strIndentedDrugs) {
		this.strIndentedDrugs = strIndentedDrugs;
	}
	public String getStrActionMode() {
		return strActionMode;
	}
	public void setStrActionMode(String strActionMode) {
		this.strActionMode = strActionMode;
	}
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
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
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
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String getStrItemId() {
		return strItemId;
	}
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
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
	public String[] getStrPODetailsHidValue() {
		return strPODetailsHidValue;
	}
	public void setStrPODetailsHidValue(String[] strPODetailsHidValue) {
		this.strPODetailsHidValue = strPODetailsHidValue;
	}
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
	public String getStrCtDate() {
		return strCtDate;
	}
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}
	public String getStrNextDeliveryDate() {
		return strNextDeliveryDate;
	}
	public void setStrNextDeliveryDate(String strNextDeliveryDate) {
		this.strNextDeliveryDate = strNextDeliveryDate;
	}
	public WebRowSet getWsOrderScheduleDtl() {
		return wsOrderScheduleDtl;
	}
	public void setWsOrderScheduleDtl(WebRowSet wsOrderScheduleDtl) {
		this.wsOrderScheduleDtl = wsOrderScheduleDtl;
	}
	public String[] getStrReplacedQty() {
		return strReplacedQty;
	}
	public void setStrReplacedQty(String[] strReplacedQty) {
		this.strReplacedQty = strReplacedQty;
	}
	public String getStrNosqDrugs() {
		return strNosqDrugs;
	}
	public void setStrNosqDrugs(String strNosqDrugs) {
		this.strNosqDrugs = strNosqDrugs;
	}
	public String[] getStrQtySchHidValue() {
		return strQtySchHidValue;
	}
	public void setStrQtySchHidValue(String[] strQtySchHidValue) {
		this.strQtySchHidValue = strQtySchHidValue;
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
	public String getStrVerifiedBy() {
		return strVerifiedBy;
	}
	public void setStrVerifiedBy(String strVerifiedBy) {
		this.strVerifiedBy = strVerifiedBy;
	}	
	 public String getStrOrderHiddenValue() {
			return strOrderHiddenValue;
		}
		public void setStrOrderHiddenValue(String strOrderHiddenValue) {
			this.strOrderHiddenValue = strOrderHiddenValue;
		}
	
}

