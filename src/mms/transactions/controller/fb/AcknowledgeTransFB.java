package mms.transactions.controller.fb;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionutil.GenericFormBean;


public class AcknowledgeTransFB extends GenericFormBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private String chk = "";
	
	
	private String strErrMsg = "";
	private String strWarningMsg = "";
	private String strNormalMsg = "";
	
	private String strComboVal = "";
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strRemarks = "";
	private String strRequestType = "";
	private String strPath = "";
	
	private String strAcknowledgeDetails = "";
	private String strAcknowledgeDetailsBS = "";
	private String strItemDetails = "";
	private String strItemDetailsBS = "";
	private String strAckDtls = "";
	private String strAckDtlsBS = "";
	private String strAckStatus="0";
	private String strReturnStatus="0";
	private String strTransNo="0";
	private String strStoreId="";
	private String cnt_page="";
	private WebRowSet strAcknowledgeDtlWs = null;
	private WebRowSet strAcknowledgeDtlWsBS = null;
	private WebRowSet strItemDtlWs = null;
	//Hidden Fields
	
	 private String[] strHiddenValue  = null;
	 private String[] strBkgQty = null;
	 private String[] strReceivedQty = null;
	 private String strHidVal = "";
	 private String strViewMode="0";
	 private String strReqTypeId = "";
	 private String strRequestMode ="0";
	 
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
	    private String strItemCategoryId="";
	    
	    private String strAckAppFlg="0";
	        
	    
	    public String getStrAckAppFlg() {
			return strAckAppFlg;
		}
		public void setStrAckAppFlg(String strAckAppFlg) {
			this.strAckAppFlg = strAckAppFlg;
		}
		public String getStrItemCategoryId() {
			return strItemCategoryId;
		}
		public void setStrItemCategoryId(String strItemCategoryId) {
			this.strItemCategoryId = strItemCategoryId;
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
		

	 
	public String getStrReqTypeId() {
		return strReqTypeId;
	}
	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}
	public String getStrHidVal() {
		return strHidVal;
	}
	public void setStrHidVal(String strHidVal) {
		this.strHidVal = strHidVal;
	}
	public String getStrAcknowledgeDetails() {
		return strAcknowledgeDetails;
	}
	public void setStrAcknowledgeDetails(String strAcknowledgeDetails) {
		this.strAcknowledgeDetails = strAcknowledgeDetails;
	}
	
	
	public WebRowSet getStrAcknowledgeDtlWsBS() {
		return strAcknowledgeDtlWsBS;
	}
	public void setStrAcknowledgeDtlWsBS(WebRowSet strAcknowledgeDtlWsBS) {
		this.strAcknowledgeDtlWsBS = strAcknowledgeDtlWsBS;
	}
	public String getStrAcknowledgeDetailsBS() {
		return strAcknowledgeDetailsBS;
	}
	public void setStrAcknowledgeDetailsBS(String strAcknowledgeDetailsBS) {
		this.strAcknowledgeDetailsBS = strAcknowledgeDetailsBS;
	}
	
	public String getStrItemDetails() {
		return strItemDetails;
	}
	public void setStrItemDetails(String strItemDetails) {
		this.strItemDetails = strItemDetails;
	}
	
	
	
	public String getStrItemDetailsBS() {
		return strItemDetailsBS;
	}
	public void setStrItemDetailsBS(String strItemDetailsBS) {
		this.strItemDetailsBS = strItemDetailsBS;
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
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrPath() {
		return strPath;
	}
	public void setStrPath(String strPath) {
		this.strPath = strPath;
	}
	public String getStrAckDtls() {
		return strAckDtls;
	}
	public void setStrAckDtls(String strAckDtls) {
		this.strAckDtls = strAckDtls;
	}
	
	
	public String getStrAckDtlsBS() {
		return strAckDtlsBS;
	}
	public void setStrAckDtlsBS(String strAckDtlsBS) {
		this.strAckDtlsBS = strAckDtlsBS;
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
	
	public String[] getStrHiddenValue() {
		return strHiddenValue;
	}
	public void setStrHiddenValue(String[] strHiddenValue) {
		this.strHiddenValue = strHiddenValue;
	}
	public String getStrComboVal() {
		return strComboVal;
	}
	public void setStrComboVal(String strComboVal) {
		this.strComboVal = strComboVal;
	}
	/**
	 * @return the strAckStatus
	 */
	public String getStrAckStatus() {
		return strAckStatus;
	}
	/**
	 * @param strAckStatus the strAckStatus to set
	 */
	public void setStrAckStatus(String strAckStatus) {
		this.strAckStatus = strAckStatus;
	}
	/**
	 * @return the strTransNo
	 */
	public String getStrTransNo() {
		return strTransNo;
	}
	/**
	 * @param strTransNo the strTransNo to set
	 */
	public void setStrTransNo(String strTransNo) {
		this.strTransNo = strTransNo;
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
	 * @return the cnt_page
	 */
	public String getCnt_page() {
		return cnt_page;
	}
	/**
	 * @param cnt_page the cnt_page to set
	 */
	public WebRowSet getStrAcknowledgeDtlWs() {
		return strAcknowledgeDtlWs;
	}
	public void setStrAcknowledgeDtlWs(WebRowSet strAcknowledgeDtlWs) {
		this.strAcknowledgeDtlWs = strAcknowledgeDtlWs;
	}
	public WebRowSet getStrItemDtlWs() {
		return strItemDtlWs;
	}
	public void setStrItemDtlWs(WebRowSet strItemDtlWs) {
		this.strItemDtlWs = strItemDtlWs;
	}
	public String getStrRequestType() {
		return strRequestType;
	}
	public void setStrRequestType(String strRequestType) {
		this.strRequestType = strRequestType;
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
	public String getStrViewMode() {
		return strViewMode;
	}
	public void setStrViewMode(String strViewMode) {
		this.strViewMode = strViewMode;
	}
	public String getStrRequestMode() {
		return strRequestMode;
	}
	public void setStrRequestMode(String strRequestMode) {
		this.strRequestMode = strRequestMode;
	}
	public String getStrReturnStatus() {
		return strReturnStatus;
	}
	public void setStrReturnStatus(String strReturnStatus) {
		this.strReturnStatus = strReturnStatus;
	}
	
}
