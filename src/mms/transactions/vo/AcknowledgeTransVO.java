package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

public class AcknowledgeTransVO {
	
	private String strHospitalCode = "";
	private String strSeatId ="";
	private String strMsgType = "";
	private String strMsgString = "";
	
	private String strStoreId = "";
	private String strTransNo = "";
	private String strReqTypeId = "";
	private String strRemarks = "";
	private WebRowSet strAcknowledgeDtlWsBS = null;
	private WebRowSet strAcknowledgeDtlWs = null;
	private WebRowSet strItemDtlWs = null;
	private WebRowSet strAckDtlWs = null;
	
	private String strItemId = "";
	private String strItemBrandId = "";
	private String strBatchNo = "";
	private String strQty = "";
	private String strQtyUnitId = "";
	private String strItemSlNo = "";
	private String strStockStatusCode = "";
	private String strStrId = "";
	private String strToStrName = "";
	private String strToStrId = "";
	private String strItemCatNo = "";
	private String strAckDate = "";
	
	private String strReservedFlag = "";
	private String strBlockedQtyFlag = "";
	
	 private String[] strHiddenValue  = null;
	 private String[] strBkgQty = null;
	 private String[] strReceivedQty = null;
	 private WebRowSet transferDtlWs  =null;
	 
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
	    private String strCrno="0";	   
		private String strStoreName="";
	    private String strIndentNo="";
	    private String strIndentDate="";
	    
	    private String strFromStoreId="";
	    private String strModeVal="";
	    private String strIssueNo="";
	    
	    private String strIssueDate="";
	    private String strItemCategoryNo="";
	    
	    private String strAckAppFlg="0";
	    
	    
	    public String getStrAckAppFlg() {
			return strAckAppFlg;
		}
		public void setStrAckAppFlg(String strAckAppFlg) {
			this.strAckAppFlg = strAckAppFlg;
		}
		public String getStrIssueDate() {
			return strIssueDate;
		}
		public void setStrIssueDate(String strIssueDate) {
			this.strIssueDate = strIssueDate;
		}
		public String getStrItemCategoryNo() {
			return strItemCategoryNo;
		}
		public void setStrItemCategoryNo(String strItemCategoryNo) {
			this.strItemCategoryNo = strItemCategoryNo;
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
		public String getStrIssueNo() {
			return strIssueNo;
		}
		public void setStrIssueNo(String strIssueNo) {
			this.strIssueNo = strIssueNo;
		}
		

	    
	    
	    public String getStrStoreName() {
			return strStoreName;
		}
		public void setStrStoreName(String strStoreName) {
			this.strStoreName = strStoreName;
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
		

		

	public WebRowSet getTransferDtlWs() {
		return transferDtlWs;
	}

	public void setTransferDtlWs(WebRowSet transferDtlWs) {
		this.transferDtlWs = transferDtlWs;
	}

	public String[] getStrBkgQty() {
		return strBkgQty;
	}

	public void setStrBkgQty(String[] strBkgQty) {
		this.strBkgQty = strBkgQty;
	}

	public String[] getStrReceivedQty() {
		return strReceivedQty;
	}

	public void setStrReceivedQty(String[] strReceivedQty) {
		this.strReceivedQty = strReceivedQty;
	}

	public String[] getStrHiddenValue() {
		return strHiddenValue;
	}

	public void setStrHiddenValue(String[] strHiddenValue) {
		this.strHiddenValue = strHiddenValue;
	}

	public String getStrAckDate() {
		return strAckDate;
	}

	public String getStrReservedFlag() {
		return strReservedFlag;
	}

	public void setStrReservedFlag(String strReservedFlag) {
		this.strReservedFlag = strReservedFlag;
	}

	public String getStrBlockedQtyFlag() {
		return strBlockedQtyFlag;
	}

	public void setStrBlockedQtyFlag(String strBlockedQtyFlag) {
		this.strBlockedQtyFlag = strBlockedQtyFlag;
	}

	public void setStrAckDate(String strAckDate) {
		this.strAckDate = strAckDate;
	}

	public String getStrStrId() {
		return strStrId;
	}

	public void setStrStrId(String strStrId) {
		this.strStrId = strStrId;
	}

	public String getStrToStrId() {
		return strToStrId;
	}

	public void setStrToStrId(String strToStrId) {
		this.strToStrId = strToStrId;
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

	public String getStrBatchNo() {
		return strBatchNo;
	}

	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}

	public String getStrQty() {
		return strQty;
	}

	public void setStrQty(String strQty) {
		this.strQty = strQty;
	}

	public String getStrQtyUnitId() {
		return strQtyUnitId;
	}

	public void setStrQtyUnitId(String strQtyUnitId) {
		this.strQtyUnitId = strQtyUnitId;
	}

	public String getStrItemSlNo() {
		return strItemSlNo;
	}

	public void setStrItemSlNo(String strItemSlNo) {
		this.strItemSlNo = strItemSlNo;
	}

	public String getStrStockStatusCode() {
		return strStockStatusCode;
	}

	public void setStrStockStatusCode(String strStockStatusCode) {
		this.strStockStatusCode = strStockStatusCode;
	}

	public WebRowSet getStrAcknowledgeDtlWs() {
		return strAcknowledgeDtlWs;
	}

	public void setStrAcknowledgeDtlWs(WebRowSet strAcknowledgeDtlWs) {
		this.strAcknowledgeDtlWs = strAcknowledgeDtlWs;
	}

	
	public WebRowSet getStrAcknowledgeDtlWsBS() {
		return strAcknowledgeDtlWsBS;
	}

	public void setStrAcknowledgeDtlWsBS(WebRowSet strAcknowledgeDtlWsBS) {
		this.strAcknowledgeDtlWsBS = strAcknowledgeDtlWsBS;
	}

	public String getStrMsgType() {
		return strMsgType;
	}

	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	public String getStrMsgString() {
		return strMsgString;
	}

	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	public WebRowSet getStrItemDtlWs() {
		return strItemDtlWs;
	}

	public void setStrItemDtlWs(WebRowSet strItemDtlWs) {
		this.strItemDtlWs = strItemDtlWs;
	}

	public String getStrStoreId() {
		return strStoreId;
	}

	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	public String getStrTransNo() {
		return strTransNo;
	}

	public void setStrTransNo(String strTransNo) {
		this.strTransNo = strTransNo;
	}

	public String getStrReqTypeId() {
		return strReqTypeId;
	}

	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}

	public WebRowSet getStrAckDtlWs() {
		return strAckDtlWs;
	}

	public void setStrAckDtlWs(WebRowSet strAckDtlWs) {
		this.strAckDtlWs = strAckDtlWs;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	public String getStrSeatId() {
		return strSeatId;
	}

	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	public String getStrItemCatNo() {
		return strItemCatNo;
	}

	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}

	public String getStrToStrName() {
		return strToStrName;
	}

	public void setStrToStrName(String strToStrName) {
		this.strToStrName = strToStrName;
	}

	
}
