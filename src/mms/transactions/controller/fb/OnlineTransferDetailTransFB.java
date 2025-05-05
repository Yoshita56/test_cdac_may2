package mms.transactions.controller.fb;



import org.apache.struts.action.ActionForm;

public class OnlineTransferDetailTransFB extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String strMode;
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strCtDate = "";
	
	private String strMsg;
	private String strMsgType;
	private String strErrMsg = "";
	private String strWarningMsg = "";
	private String strNormalMsg = "";
	
    private String strStoreName = "";
	private String strItemName = "";
	
	private String strStoreId;
	private String strStoreValues = "";

	private String[] strBatchNo = null;
	private String[] strAvailableQty = null;
	private String[] strRatePerUnit = null;
	private String[] strHidValue = null;
	private String[] strTransferQty = null;
	private String[] strCost = null;
	private String[] batchCheckbox=null;

	private String[] checkboxFlag= null;
	
	private String strTransferDateTime;
	private String strViewChk;

	private String strOrderNoValues;
	private String strOrderNo;
	private String strOrderDate;
	private String orderNO; // For selectedText of order No Combo
	
	private String strDrugName;
	private String strOrderQty;
	private String strOrderQtyBase;
	private String strReceivingDDWName;
	
	private String strBatchDetailsTable; 
	private String strTransferDetailsTable;
	
	private String strTotalTransferredCost;
	private String strTotalTransferredQty;
	private String strRemarks;
	
	private String strItemId;
	private String strItemBrandId;
	private String strTransferNo;
	private String strToStoreId;
	
	private String strFromDate;
	private String strToDate;
	
	private String strTransferDate;
	 
    private String strTmpTransferNo="0";
    private String strTmpStoreName;
    private String strTmpTransferDate;
    private String strTmpStoreNo;
    private String strDwhName;
    
    private String tempTransferNo;
	
	public String getTempTransferNo() {
		return tempTransferNo;
	}


	public void setTempTransferNo(String tempTransferNo) {
		this.tempTransferNo = tempTransferNo;
	}


	public String getStrTmpTransferNo() {
		return strTmpTransferNo;
	}


	public void setStrTmpTransferNo(String strTmpTransferNo) {
		this.strTmpTransferNo = strTmpTransferNo;
	}


	public String getStrTmpStoreName() {
		return strTmpStoreName;
	}


	public void setStrTmpStoreName(String strTmpStoreName) {
		this.strTmpStoreName = strTmpStoreName;
	}


	public String getStrTmpTransferDate() {
		return strTmpTransferDate;
	}


	public void setStrTmpTransferDate(String strTmpTransferDate) {
		this.strTmpTransferDate = strTmpTransferDate;
	}


	public String getStrTmpStoreNo() {
		return strTmpStoreNo;
	}


	public void setStrTmpStoreNo(String strTmpStoreNo) {
		this.strTmpStoreNo = strTmpStoreNo;
	}


	public String getStrDwhName() {
		return strDwhName;
	}


	public void setStrDwhName(String strDwhName) {
		this.strDwhName = strDwhName;
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


	public String getStrRemarks() {
		return strRemarks;
	}


	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}


	public String getStrBatchDetailsTable() {
		return strBatchDetailsTable;
	}


	public void setStrBatchDetailsTable(String strBatchDetailsTable) {
		this.strBatchDetailsTable = strBatchDetailsTable;
	}


	public String getStrDrugName() {
		return strDrugName;
	}


	public void setStrDrugName(String strDrugName) {
		this.strDrugName = strDrugName;
	}


	public String getStrOrderQty() {
		return strOrderQty;
	}


	public void setStrOrderQty(String strOrderQty) {
		this.strOrderQty = strOrderQty;
	}


	public String getStrReceivingDDWName() {
		return strReceivingDDWName;
	}


	public void setStrReceivingDDWName(String strReceivingDDWName) {
		this.strReceivingDDWName = strReceivingDDWName;
	}


	public String getOrderNO() {
		return orderNO;
	}


	public void setOrderNO(String orderNO) {
		this.orderNO = orderNO;
	}


	public String getStrOrderNoValues() {
		return strOrderNoValues;
	}


	public void setStrOrderNoValues(String strOrderNoValues) {
		this.strOrderNoValues = strOrderNoValues;
	}


	public String getStrOrderNo() {
		return strOrderNo;
	}


	public void setStrOrderNo(String strOrderNo) {
		this.strOrderNo = strOrderNo;
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


	public String getStrCtDate() {
		return strCtDate;
	}


	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}


	public String getStrErrMsg() {
		return strErrMsg;
	}


	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}


	public String getStrWarningMsg() {
		return strWarningMsg;
	}


	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}


	public String getStrNormalMsg() {
		return strNormalMsg;
	}


	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}


	public String getStrStoreName() {
		return strStoreName;
	}


	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}


	public String getStrItemName() {
		return strItemName;
	}


	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}


	public String getStrStoreId() {
		return strStoreId;
	}


	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}


	public String getStrStoreValues() {
		return strStoreValues;
	}


	public void setStrStoreValues(String strStoreValues) {
		this.strStoreValues = strStoreValues;
	}


	public String[] getStrBatchNo() {
		return strBatchNo;
	}


	public void setStrBatchNo(String[] strBatchNo) {
		this.strBatchNo = strBatchNo;
	}


	public String[] getStrAvailableQty() {
		return strAvailableQty;
	}


	public void setStrAvailableQty(String[] strAvailableQty) {
		this.strAvailableQty = strAvailableQty;
	}


	public String[] getStrRatePerUnit() {
		return strRatePerUnit;
	}


	public void setStrRatePerUnit(String[] strRatePerUnit) {
		this.strRatePerUnit = strRatePerUnit;
	}


	public String[] getStrHidValue() {
		return strHidValue;
	}


	public void setStrHidValue(String[] strHidValue) {
		this.strHidValue = strHidValue;
	}


	public String[] getStrTransferQty() {
		return strTransferQty;
	}


	public void setStrTransferQty(String[] strTransferQty) {
		this.strTransferQty = strTransferQty;
	}


	public String[] getStrCost() {
		return strCost;
	}


	public void setStrCost(String[] strCost) {
		this.strCost = strCost;
	}


	public String getStrViewChk() {
		return strViewChk;
	}


	public void setStrViewChk(String strViewChk) {
		this.strViewChk = strViewChk;
	}


	public String getStrMode() {
		return strMode;
	}


	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}


	public String getStrTransferDateTime() {
		return strTransferDateTime;
	}


	public void setStrTransferDateTime(String strTransferDateTime) {
		this.strTransferDateTime = strTransferDateTime;
	}


	public String getStrOrderDate() {
		return strOrderDate;
	}


	public void setStrOrderDate(String strOrderDate) {
		this.strOrderDate = strOrderDate;
	}


	public String[] getBatchCheckbox() {
		return batchCheckbox;
	}


	public void setBatchCheckbox(String[] batchCheckbox) {
		this.batchCheckbox = batchCheckbox;
	}


	public String getStrTotalTransferredCost() {
		return strTotalTransferredCost;
	}


	public void setStrTotalTransferredCost(String strTotalTransferredCost) {
		this.strTotalTransferredCost = strTotalTransferredCost;
	}


	public String getStrTotalTransferredQty() {
		return strTotalTransferredQty;
	}


	public void setStrTotalTransferredQty(String strTotalTransferredQty) {
		this.strTotalTransferredQty = strTotalTransferredQty;
	}


	public String getStrItemId() {
		return strItemId;
	}


	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}


	public String getStrItemBrandId() {
		return strItemBrandId;
	}


	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}


	public String getStrTransferDetailsTable() {
		return strTransferDetailsTable;
	}


	public void setStrTransferDetailsTable(String strTransferDetailsTable) {
		this.strTransferDetailsTable = strTransferDetailsTable;
	}


	public String getStrMsg() {
		return strMsg;
	}


	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}


	public String getStrMsgType() {
		return strMsgType;
	}


	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}


	public String getStrTransferDate() {
		return strTransferDate;
	}


	public void setStrTransferDate(String strTransferDate) {
		this.strTransferDate = strTransferDate;
	}


	public String getStrToStoreId() {
		return strToStoreId;
	}


	public void setStrToStoreId(String strToStoreId) {
		this.strToStoreId = strToStoreId;
	}


	public String getStrTransferNo() {
		return strTransferNo;
	}


	public void setStrTransferNo(String strTransferNo) {
		this.strTransferNo = strTransferNo;
	}


	public String[] getCheckboxFlag() {
		return checkboxFlag;
	}


	public void setCheckboxFlag(String[] checkboxFlag) {
		this.checkboxFlag = checkboxFlag;
	}


	public String getStrOrderQtyBase() {
		return strOrderQtyBase;
	}


	public void setStrOrderQtyBase(String strOrderQtyBase) {
		this.strOrderQtyBase = strOrderQtyBase;
	}
 

	
}
