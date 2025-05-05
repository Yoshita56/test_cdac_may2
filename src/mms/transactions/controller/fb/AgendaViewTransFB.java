package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;

public class AgendaViewTransFB extends ActionForm
{
	
	private static final long serialVersionUID = 02L;

	private String strErrMsg = "";
	private String strNormalMsg = "";
	private String strWarningMsg = "";
	private String strCtDate = "";
	private String strHospitalCode = "";
	private String strIsValid = "";
	private String strSeatId = "";
	private String strStoreName="";
	private String strToStore="";
	private String strAgendaPeriod="";
	private String strAgendaPeriodValue ="";
	
	private String strIndentNo="";
	private String strIndentDate="";
	private String strItemCategory="";
	private String strRaisingStore="";
	private String strIndentDetails="";
	
	
	private String strItemName="";
	private String strBrandName="";
	private String strCompiledQty="";
		private String strSaveQty="";
	private String strReqQty="";
	private String strRecevingQty="";
	private String strCompiledItemDetails="";
	
	private String strLastPurchageDate="";
	private String strLastReceiveQty="";
	private String strLastYearConsumption="";
	private String strApprovedBy="";
	private String strApprovedDate="";
	private String strStatus="";
	private String strApprovalDetails="";
	private String strRemarks="";
	
	private String strAgendaNo="";
	private String strAgendaDate="";
	private String strToStoreName="";
	private String strGrantType="";
	/**
	 * @return the strErrMsg
	 */
	public String getStrErrMsg() {
		return strErrMsg;
	}
	/**
	 * @param strErrMsg the strErrMsg to set
	 */
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}
	/**
	 * @return the strNormalMsg
	 */
	public String getStrNormalMsg() {
		return strNormalMsg;
	}
	/**
	 * @param strNormalMsg the strNormalMsg to set
	 */
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}
	/**
	 * @return the strWarningMsg
	 */
	public String getStrWarningMsg() {
		return strWarningMsg;
	}
	/**
	 * @param strWarningMsg the strWarningMsg to set
	 */
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}
	/**
	 * @return the strCtDate
	 */
	public String getStrCtDate() {
		return strCtDate;
	}
	/**
	 * @param strCtDate the strCtDate to set
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
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
	 * @return the strIsValid
	 */
	public String getStrIsValid() {
		return strIsValid;
	}
	/**
	 * @param strIsValid the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
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
	/**
	 * @return the strToStore
	 */
	public String getStrToStore() {
		return strToStore;
	}
	/**
	 * @param strToStore the strToStore to set
	 */
	public void setStrToStore(String strToStore) {
		this.strToStore = strToStore;
	}
	/**
	 * @return the strAgendaPeriod
	 */
	public String getStrAgendaPeriod() {
		return strAgendaPeriod;
	}
	/**
	 * @param strAgendaPeriod the strAgendaPeriod to set
	 */
	public void setStrAgendaPeriod(String strAgendaPeriod) {
		this.strAgendaPeriod = strAgendaPeriod;
	}
	/**
	 * @return the strIndentNo
	 */
	public String getStrIndentNo() {
		return strIndentNo;
	}
	/**
	 * @param strIndentNo the strIndentNo to set
	 */
	public void setStrIndentNo(String strIndentNo) {
		this.strIndentNo = strIndentNo;
	}
	/**
	 * @return the strIndentDate
	 */
	public String getStrIndentDate() {
		return strIndentDate;
	}
	/**
	 * @param strIndentDate the strIndentDate to set
	 */
	public void setStrIndentDate(String strIndentDate) {
		this.strIndentDate = strIndentDate;
	}
	/**
	 * @return the strItemCategory
	 */
	public String getStrItemCategory() {
		return strItemCategory;
	}
	/**
	 * @param strItemCategory the strItemCategory to set
	 */
	public void setStrItemCategory(String strItemCategory) {
		this.strItemCategory = strItemCategory;
	}
	/**
	 * @return the strRaisingStore
	 */
	public String getStrRaisingStore() {
		return strRaisingStore;
	}
	/**
	 * @param strRaisingStore the strRaisingStore to set
	 */
	public void setStrRaisingStore(String strRaisingStore) {
		this.strRaisingStore = strRaisingStore;
	}
	/**
	 * @return the strIndentDetails
	 */
	public String getStrIndentDetails() {
		return strIndentDetails;
	}
	/**
	 * @param strIndentDetails the strIndentDetails to set
	 */
	public void setStrIndentDetails(String strIndentDetails) {
		this.strIndentDetails = strIndentDetails;
	}
	/**
	 * @return the strItemName
	 */
	public String getStrItemName() {
		return strItemName;
	}
	/**
	 * @param strItemName the strItemName to set
	 */
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}
	/**
	 * @return the strBrandName
	 */
	public String getStrBrandName() {
		return strBrandName;
	}
	/**
	 * @param strBrandName the strBrandName to set
	 */
	public void setStrBrandName(String strBrandName) {
		this.strBrandName = strBrandName;
	}
	/**
	 * @return the strCompiledQty
	 */
	public String getStrCompiledQty() {
		return strCompiledQty;
	}
	/**
	 * @param strCompiledQty the strCompiledQty to set
	 */
	public void setStrCompiledQty(String strCompiledQty) {
		this.strCompiledQty = strCompiledQty;
	}
	/**
	 * @return the strSaveQty
	 */
	public String getStrSaveQty() {
		return strSaveQty;
	}
	/**
	 * @param strSaveQty the strSaveQty to set
	 */
	public void setStrSaveQty(String strSaveQty) {
		this.strSaveQty = strSaveQty;
	}
	/**
	 * @return the strReqQty
	 */
	public String getStrReqQty() {
		return strReqQty;
	}
	/**
	 * @param strReqQty the strReqQty to set
	 */
	public void setStrReqQty(String strReqQty) {
		this.strReqQty = strReqQty;
	}
	/**
	 * @return the strRecevingQty
	 */
	public String getStrRecevingQty() {
		return strRecevingQty;
	}
	/**
	 * @param strRecevingQty the strRecevingQty to set
	 */
	public void setStrRecevingQty(String strRecevingQty) {
		this.strRecevingQty = strRecevingQty;
	}
	/**
	 * @return the strCompiledItemDetails
	 */
	public String getStrCompiledItemDetails() {
		return strCompiledItemDetails;
	}
	/**
	 * @param strCompiledItemDetails the strCompiledItemDetails to set
	 */
	public void setStrCompiledItemDetails(String strCompiledItemDetails) {
		this.strCompiledItemDetails = strCompiledItemDetails;
	}
	/**
	 * @return the strLastPurchageDate
	 */
	public String getStrLastPurchageDate() {
		return strLastPurchageDate;
	}
	/**
	 * @param strLastPurchageDate the strLastPurchageDate to set
	 */
	public void setStrLastPurchageDate(String strLastPurchageDate) {
		this.strLastPurchageDate = strLastPurchageDate;
	}
	/**
	 * @return the strLastReceiveQty
	 */
	public String getStrLastReceiveQty() {
		return strLastReceiveQty;
	}
	/**
	 * @param strLastReceiveQty the strLastReceiveQty to set
	 */
	public void setStrLastReceiveQty(String strLastReceiveQty) {
		this.strLastReceiveQty = strLastReceiveQty;
	}
	/**
	 * @return the strLastYearConsumption
	 */
	public String getStrLastYearConsumption() {
		return strLastYearConsumption;
	}
	/**
	 * @param strLastYearConsumption the strLastYearConsumption to set
	 */
	public void setStrLastYearConsumption(String strLastYearConsumption) {
		this.strLastYearConsumption = strLastYearConsumption;
	}
	/**
	 * @return the strApprovedBy
	 */
	public String getStrApprovedBy() {
		return strApprovedBy;
	}
	/**
	 * @param strApprovedBy the strApprovedBy to set
	 */
	public void setStrApprovedBy(String strApprovedBy) {
		this.strApprovedBy = strApprovedBy;
	}
	/**
	 * @return the strApprovedDate
	 */
	public String getStrApprovedDate() {
		return strApprovedDate;
	}
	/**
	 * @param strApprovedDate the strApprovedDate to set
	 */
	public void setStrApprovedDate(String strApprovedDate) {
		this.strApprovedDate = strApprovedDate;
	}
	/**
	 * @return the strStatus
	 */
	public String getStrStatus() {
		return strStatus;
	}
	/**
	 * @param strStatus the strStatus to set
	 */
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}
	/**
	 * @return the strApprovalDetails
	 */
	public String getStrApprovalDetails() {
		return strApprovalDetails;
	}
	/**
	 * @param strApprovalDetails the strApprovalDetails to set
	 */
	public void setStrApprovalDetails(String strApprovalDetails) {
		this.strApprovalDetails = strApprovalDetails;
	}
	/**
	 * @return the strRemarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}
	/**
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	/**
	 * @return the strAgendaNo
	 */
	public String getStrAgendaNo() {
		return strAgendaNo;
	}
	/**
	 * @param strAgendaNo the strAgendaNo to set
	 */
	public void setStrAgendaNo(String strAgendaNo) {
		this.strAgendaNo = strAgendaNo;
	}
	/**
	 * @return the strAgendaDate
	 */
	public String getStrAgendaDate() {
		return strAgendaDate;
	}
	/**
	 * @param strAgendaDate the strAgendaDate to set
	 */
	public void setStrAgendaDate(String strAgendaDate) {
		this.strAgendaDate = strAgendaDate;
	}
	/**
	 * @return the strToStoreName
	 */
	public String getStrToStoreName() {
		return strToStoreName;
	}
	/**
	 * @param strToStoreName the strToStoreName to set
	 */
	public void setStrToStoreName(String strToStoreName) {
		this.strToStoreName = strToStoreName;
	}
	/**
	 * @return the strGrantType
	 */
	public String getStrGrantType() {
		return strGrantType;
	}
	/**
	 * @param strGrantType the strGrantType to set
	 */
	public void setStrGrantType(String strGrantType) {
		this.strGrantType = strGrantType;
	}
	public String getStrAgendaPeriodValue() {
		return strAgendaPeriodValue;
	}
	public void setStrAgendaPeriodValue(String strAgendaPeriodValue) {
		this.strAgendaPeriodValue = strAgendaPeriodValue;
	}
	
	

}
