package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;

public class CondemnationRegisterViewTransFB extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String strErrMsg = "";
	private String strNormalMsg = "";
	private String strWarningMsg = "";
	private String strHospitalCode = "";
	
	private String strCondemnationNo = "";
	private String strAgendaNo = "";
	private String strAgendaDate = "";
	private String strCondemnationType = "";
	private String strTenderNo = "";
	private String strTenderDate = "";
	private String strQuotationNo = "";
	private String strQuotationDate = "";
	private String strBuyerName = "";
	private String strAmountReceived = "";
	private String strPaymentMode = "";
	private String strInstNumber = "";
	private String strInstDate = "";
	private String strBankName = "";
	private String strCommitteeType = "";	
	private String strStoreId = "";
	private String strPath="";
	private String strSetRequestDetails = "";
	private String strRemarks="";
	private String strWeight="";
	private String strSetItemDetails = "";
	private String strItemDtl="";
	private String strStoreName="";
	private String strItemCategoryName="";
	private String strCondemnationTypeName="";
	private String combo[]=null;
	
	public String[] getCombo() {
		return combo;
	}

	public void setCombo(String[] combo) {
		this.combo = combo;
	}

	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	public String getStrCondemnationNo() {
		return strCondemnationNo;
	}

	public void setStrCondemnationNo(String strCondemnationNo) {
		this.strCondemnationNo = strCondemnationNo;
	}

	public String getStrErrMsg() {
		return strErrMsg;
	}

	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}

	public String getStrNormalMsg() {
		return strNormalMsg;
	}

	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}

	public String getStrWarningMsg() {
		return strWarningMsg;
	}

	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}

	public String getStrSetRequestDetails() {
		return strSetRequestDetails;
	}

	public void setStrSetRequestDetails(String strSetRequestDetails) {
		this.strSetRequestDetails = strSetRequestDetails;
	}

	public String getStrSetItemDetails() {
		return strSetItemDetails;
	}

	public void setStrSetItemDetails(String strSetItemDetails) {
		this.strSetItemDetails = strSetItemDetails;
	}

	public String getStrAgendaNo() {
		return strAgendaNo;
	}

	public void setStrAgendaNo(String strAgendaNo) {
		this.strAgendaNo = strAgendaNo;
	}

	public String getStrAgendaDate() {
		return strAgendaDate;
	}

	public void setStrAgendaDate(String strAgendaDate) {
		this.strAgendaDate = strAgendaDate;
	}

	public String getStrCondemnationType() {
		return strCondemnationType;
	}

	public void setStrCondemnationType(String strCondemnationType) {
		this.strCondemnationType = strCondemnationType;
	}

	public String getStrTenderNo() {
		return strTenderNo;
	}

	public void setStrTenderNo(String strTenderNo) {
		this.strTenderNo = strTenderNo;
	}

	public String getStrTenderDate() {
		return strTenderDate;
	}

	public void setStrTenderDate(String strTenderDate) {
		this.strTenderDate = strTenderDate;
	}

	public String getStrQuotationNo() {
		return strQuotationNo;
	}

	public void setStrQuotationNo(String strQuotationNo) {
		this.strQuotationNo = strQuotationNo;
	}

	public String getStrQuotationDate() {
		return strQuotationDate;
	}

	public void setStrQuotationDate(String strQuotationDate) {
		this.strQuotationDate = strQuotationDate;
	}

	public String getStrBuyerName() {
		return strBuyerName;
	}

	public void setStrBuyerName(String strBuyerName) {
		this.strBuyerName = strBuyerName;
	}

	public String getStrAmountReceived() {
		return strAmountReceived;
	}

	public void setStrAmountReceived(String strAmountReceived) {
		this.strAmountReceived = strAmountReceived;
	}

	public String getStrPaymentMode() {
		return strPaymentMode;
	}

	public void setStrPaymentMode(String strPaymentMode) {
		this.strPaymentMode = strPaymentMode;
	}

	public String getStrInstNumber() {
		return strInstNumber;
	}

	public void setStrInstNumber(String strInstNumber) {
		this.strInstNumber = strInstNumber;
	}

	public String getStrInstDate() {
		return strInstDate;
	}

	public void setStrInstDate(String strInstDate) {
		this.strInstDate = strInstDate;
	}

	public String getStrBankName() {
		return strBankName;
	}

	public void setStrBankName(String strBankName) {
		this.strBankName = strBankName;
	}

	public String getStrCommitteeType() {
		return strCommitteeType;
	}

	public void setStrCommitteeType(String strCommitteeType) {
		this.strCommitteeType = strCommitteeType;
	}

	public String getStrStoreId() {
		return strStoreId;
	}

	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	public String getStrPath() {
		return strPath;
	}

	public void setStrPath(String strPath) {
		this.strPath = strPath;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	public String getStrWeight() {
		return strWeight;
	}

	public void setStrWeight(String strWeight) {
		this.strWeight = strWeight;
	}

	public String getStrItemDtl() {
		return strItemDtl;
	}

	public void setStrItemDtl(String strItemDtl) {
		this.strItemDtl = strItemDtl;
	}

	public String getStrStoreName() {
		return strStoreName;
	}

	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}

	public String getStrItemCategoryName() {
		return strItemCategoryName;
	}

	public void setStrItemCategoryName(String strItemCategoryName) {
		this.strItemCategoryName = strItemCategoryName;
	}

	/**
	 * @return the strCondemnationTypeName
	 */
	public String getStrCondemnationTypeName() {
		return strCondemnationTypeName;
	}

	/**
	 * @param strCondemnationTypeName the strCondemnationTypeName to set
	 */
	public void setStrCondemnationTypeName(String strCondemnationTypeName) {
		this.strCondemnationTypeName = strCondemnationTypeName;
	}

}
