package mms.transactions.vo;

import java.util.List;
import java.lang.*;
import javax.sql.rowset.WebRowSet;

public class DupSupplierReturnFromTransVO 
{	
	private String strMsgType="";
	private String strErr="";
	public String[] getStrNosqDrugs() {
		return strNosqDrugs;
	}
	public void setStrNosqDrugs(String[] strNosqDrugs) {
		this.strNosqDrugs = strNosqDrugs;
	}
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
	private String strSupplierId="";
	private String strPoNo= "";	
	private WebRowSet wbsStoreNameCombo=null;
	private WebRowSet ItemCategWS=null;
	private WebRowSet SupplierWS=null;
	
	private String strMode;  
    //by santosh
    
	private String strFromDate;
	private String strToDate;
	private List<Integer> debitNoteList;
	private String strdebitNoteNumber;
	private String strvoucherDate;
	//by shivani
	
    private WebRowSet wsCondemnationTypeDtl=null;
    private String strItemBrandId="";
    private String strBatchNo="";
    private String strHiddenItemDtl;
    private String[] strNosqDrugs={""};
    private String strNextDeliveryDate;
    private String strcatno="";
    
    public String getStrcatno() {
		return strcatno;
	}
	public void setStrcatno(String strcatno) {
		this.strcatno = strcatno;
	}
	private String strAvlQty;
    
    private String strOldPoNo;
    private String strNewPoNo;
    
    private WebRowSet wsNOSQItemDetail=null;
    
	private String strStoreName="";
	private String strCategoryName="";
	public String getStrCategoryName() {
		return strCategoryName;
	}
	public void setStrCategoryName(String strCategoryName) {
		this.strCategoryName = strCategoryName;
	}
	public String getStrSupplierName() {
		return strSupplierName;
	}
	public void setStrSupplierName(String strSupplierName) {
		this.strSupplierName = strSupplierName;
	}
	private String strSupplierName="";
	
    private String strReturnDate;
    private String strCondemnationDate;
    
    private String strCondemnationType="";
    private String strReturnTo="";
    
    private String strActionId="";
    private String strDrugType="";
    
    private String strCondemnationRemarks="";
    private String strOrderNo;
    private String strHiddenValue;
    
	public String getStrHiddenValue() {
		return strHiddenValue;
	}
	public void setStrHiddenValue(String strHiddenValue) {
		this.strHiddenValue = strHiddenValue;
	}
	public String getStrOrderNo() {
		return strOrderNo;
	}
	public void setStrOrderNo(String strOrderNo) {
		this.strOrderNo = strOrderNo;
	}
	public String getStrCondemnationRemarks() {
		return strCondemnationRemarks;
	}
	public void setStrCondemnationRemarks(String strCondemnationRemarks) {
		this.strCondemnationRemarks = strCondemnationRemarks;
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
	public String getStrHiddenItemDtl() {
		return strHiddenItemDtl;
	}
	public void setStrHiddenItemDtl(String strHiddenItemDtl) {
		this.strHiddenItemDtl = strHiddenItemDtl;
	}
	public String getStrNextDeliveryDate() {
		return strNextDeliveryDate;
	}
	public void setStrNextDeliveryDate(String strNextDeliveryDate) {
		this.strNextDeliveryDate = strNextDeliveryDate;
	}
	public String getStrAvlQty() {
		return strAvlQty;
	}
	public void setStrAvlQty(String strAvlQty) {
		this.strAvlQty = strAvlQty;
	}
	public String getStrOldPoNo() {
		return strOldPoNo;
	}
	public void setStrOldPoNo(String strOldPoNo) {
		this.strOldPoNo = strOldPoNo;
	}
	public String getStrNewPoNo() {
		return strNewPoNo;
	}
	public void setStrNewPoNo(String strNewPoNo) {
		this.strNewPoNo = strNewPoNo;
	}
	public WebRowSet getWsNOSQItemDetail() {
		return wsNOSQItemDetail;
	}
	public void setWsNOSQItemDetail(WebRowSet wsNOSQItemDetail) {
		this.wsNOSQItemDetail = wsNOSQItemDetail;
	}
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String getStrReturnDate() {
		return strReturnDate;
	}
	public void setStrReturnDate(String strReturnDate) {
		this.strReturnDate = strReturnDate;
	}
	public String getStrCondemnationDate() {
		return strCondemnationDate;
	}
	public void setStrCondemnationDate(String strCondemnationDate) {
		this.strCondemnationDate = strCondemnationDate;
	}	
	public String getStrCondemnationType() {
		return strCondemnationType;
	}
	public void setStrCondemnationType(String strCondemnationType) {
		this.strCondemnationType = strCondemnationType;
	}
	public String getStrReturnTo() {
		return strReturnTo;
	}
	public void setStrReturnTo(String strReturnTo) {
		this.strReturnTo = strReturnTo;
	}
	public String getStrActionId() {
		return strActionId;
	}
	public void setStrActionId(String strActionId) {
		this.strActionId = strActionId;
	}
	public String getStrDrugType() {
		return strDrugType;
	}
	public void setStrDrugType(String strDrugType) {
		this.strDrugType = strDrugType;
	}
	public WebRowSet getWsCondemnationTypeDtl() {
		return wsCondemnationTypeDtl;
	}
	public void setWsCondemnationTypeDtl(WebRowSet wsCondemnationTypeDtl) {
		this.wsCondemnationTypeDtl = wsCondemnationTypeDtl;
	}
	public WebRowSet getItemCategWS() {
		return ItemCategWS;
	}
	public void setItemCategWS(WebRowSet itemCategWS) {
		ItemCategWS = itemCategWS;
	}
	public WebRowSet getSupplierWS() {
		return SupplierWS;
	}
	public void setSupplierWS(WebRowSet supplierWS) {
		SupplierWS = supplierWS;
	}
	public String getStrFromDate() {
		return strFromDate;
	}
	public void setStrFromDate(String strFromDate) {
		this.strFromDate = strFromDate;
	}
	public String getStrToDate() {
		return strToDate;
	}
	public void setStrToDate(String strToDate) {
		this.strToDate = strToDate;
	}
	public List<Integer> getDebitNoteList() {
		return debitNoteList;
	}
	public void setDebitNoteList(List<Integer> debitNoteList) {
		this.debitNoteList = debitNoteList;
	}
	public String getStrdebitNoteNumber() {
		return strdebitNoteNumber;
	}
	public void setStrdebitNoteNumber(String strdebitNoteNumber) {
		this.strdebitNoteNumber = strdebitNoteNumber;
	}
	public String getStrvoucherDate() {
		return strvoucherDate;
	}
	public void setStrvoucherDate(String strvoucherDate) {
		this.strvoucherDate = strvoucherDate;
	}
	
	
}
