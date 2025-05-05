package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

public class CondemnationRegisterTransVO
{
    private static final long serialVersionUID = 02L;
    private String strAgendaNo="";
	private String strAgendaDate="";
	private String strTenderNo="";
	private String strTenderDate="";
	private String strQuotationNo="";
	private String strQuotationDate="";
	private String strBuyerName="";
	private String strAmountRecieved="";
	private String strPaymentMode="";
	private String strInstrumentNo="";
	private String strInstrumentDate="";
	private String strBankName="";
	private String strCommitteType="";
	private String strHospCode="";
	private String strCtDate="";
	private String  strFileExt="";
	private String strWt="";
	private String strMsgType="";
	private String strStoreId="";
	private String strStoreName="";
	private String strMsgString="";
	private String strCondemnationType="";
	private String strItemNetCost="";
	private String strFinStartDate="";
	private String strFinStartEndDate="";
	private String []strMemberRecommendation=null;
	private String strCondemnTypeName="";
	private String []strCommitteeMemberHidden=null;
	private String strItemDtlHidden[]=null;
	private String strItemCategoryNo="";
	private WebRowSet committeTypeWS=null;
	private WebRowSet itemDtlWS=null;
	private WebRowSet requestDtlWS=null;
	private WebRowSet buyerDtlWS=null;
	private WebRowSet CommitteMemberWS=null; 
	private String strRemarks="";
	private String strSeatId="";
	private String strFileNo="";
	private String strPageNo="";
	private String strFileName="";

	public String getStrFileNo() {
		return strFileNo;
	}
	public void setStrFileNo(String strFileNo) {
		this.strFileNo = strFileNo;
	}
	public String getStrPageNo() {
		return strPageNo;
	}
	public void setStrPageNo(String strPageNo) {
		this.strPageNo = strPageNo;
	}
	public String getStrFileName() {
		return strFileName;
	}
	public void setStrFileName(String strFileName) {
		this.strFileName = strFileName;
	}
	public WebRowSet getCommitteMemberWS() {
		return CommitteMemberWS;
	}
	public void setCommitteMemberWS(WebRowSet committeMemberWS) {
		CommitteMemberWS = committeMemberWS;
	}
	public String getStrMsgType() {
		return strMsgType;
	}
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
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
	public String getStrAmountRecieved() {
		return strAmountRecieved;
	}
	public void setStrAmountRecieved(String strAmountRecieved) {
		this.strAmountRecieved = strAmountRecieved;
	}
	public String getStrPaymentMode() {
		return strPaymentMode;
	}
	public void setStrPaymentMode(String strPaymentMode) {
		this.strPaymentMode = strPaymentMode;
	}
	public String getStrInstrumentNo() {
		return strInstrumentNo;
	}
	public void setStrInstrumentNo(String strInstrumentNo) {
		this.strInstrumentNo = strInstrumentNo;
	}
	public String getStrInstrumentDate() {
		return strInstrumentDate;
	}
	public void setStrInstrumentDate(String strInstrumentDate) {
		this.strInstrumentDate = strInstrumentDate;
	}
	public String getStrBankName() {
		return strBankName;
	}
	public void setStrBankName(String strBankName) {
		this.strBankName = strBankName;
	}
	public String getStrCommitteType() {
		return strCommitteType;
	}
	public void setStrCommitteType(String strCommitteType) {
		this.strCommitteType = strCommitteType;
	}
	public String getStrHospCode() {
		return strHospCode;
	}
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
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
	public String getStrMsgString() {
		return strMsgString;
	}
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}
	public WebRowSet getItemDtlWS() {
		return itemDtlWS;
	}
	public void setItemDtlWS(WebRowSet itemDtlWS) {
		this.itemDtlWS = itemDtlWS;
	}
	public WebRowSet getRequestDtlWS() {
		return requestDtlWS;
	}
	public void setRequestDtlWS(WebRowSet requestDtlWS) {
		this.requestDtlWS = requestDtlWS;
	}
	public WebRowSet getCommitteTypeWS() {
		return committeTypeWS;
	}
	public void setCommitteTypeWS(WebRowSet committeTypeWS) {
		this.committeTypeWS = committeTypeWS;
	}
	public String getStrCondemnationType() {
		return strCondemnationType;
	}
	public void setStrCondemnationType(String strCondemnationType) {
		this.strCondemnationType = strCondemnationType;
	}
	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}
	public WebRowSet getBuyerDtlWS() {
		return buyerDtlWS;
	}
	public void setBuyerDtlWS(WebRowSet buyerDtlWS) {
		this.buyerDtlWS = buyerDtlWS;
	}
	public String getStrItemNetCost() {
		return strItemNetCost;
	}
	public void setStrItemNetCost(String strItemNetCost) {
		this.strItemNetCost = strItemNetCost;
	}
	public String[] getStrMemberRecommendation() {
		return strMemberRecommendation;
	}
	public void setStrMemberRecommendation(String[] strMemberRecommendation) {
		this.strMemberRecommendation = strMemberRecommendation;
	}
	public String[] getStrCommitteeMemberHidden() {
		return strCommitteeMemberHidden;
	}
	public void setStrCommitteeMemberHidden(String[] strCommitteeMemberHidden) {
		this.strCommitteeMemberHidden = strCommitteeMemberHidden;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	public String[] getStrItemDtlHidden() {
		return strItemDtlHidden;
	}
	public void setStrItemDtlHidden(String[] strItemDtlHidden) {
		this.strItemDtlHidden = strItemDtlHidden;
	}
	public String getStrWt() {
		return strWt;
	}
	public void setStrWt(String strWt) {
		this.strWt = strWt;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrFinStartDate() {
		return strFinStartDate;
	}
	public void setStrFinStartDate(String strFinStartDate) {
		this.strFinStartDate = strFinStartDate;
	}
	public String getStrFinStartEndDate() {
		return strFinStartEndDate;
	}
	public void setStrFinStartEndDate(String strFinStartEndDate) {
		this.strFinStartEndDate = strFinStartEndDate;
	}
	public String getStrCtDate() {
		return strCtDate;
	}
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}
	public String getStrFileExt() {
		return strFileExt;
	}
	public void setStrFileExt(String strFileExt) {
		this.strFileExt = strFileExt;
	}
	/**
	 * @return the strCondemnTypeName
	 */
	public String getStrCondemnTypeName() {
		return strCondemnTypeName;
	}
	/**
	 * @param strCondemnTypeName the strCondemnTypeName to set
	 */
	public void setStrCondemnTypeName(String strCondemnTypeName) {
		this.strCondemnTypeName = strCondemnTypeName;
	}
}
