package mms.transactions.controller.fb;
import javax.sql.rowset.WebRowSet;
import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;




public class CondemnationRegisterTransFB extends ActionForm 
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
	private String strItemCategoryNo="";
	private String strBankName="";
	private String strCommitteType="";
	private String strHospCode="";
	private String strCtDate="";
	private String chk="";
	private String strItemNetCost="";
	private String combo[]=null;
	private String strStoreId="";
	private String strStoreName="";
	private String strItemDetailsValue="";
	private String strItemCategoryName="";
	private String strRequestDetailsValue="";
	private String strCondemnationTypeName="";
	
	private String strErr="";
	private String strWarning="";
	private String strMsg="";
	private String strCommitteTypeValue="";
	private String strSeatId="";
	private String strCondemnationType="";
	private String cnt_page="";
	private String strBuyerListValues="";
	private String comboName="";
	private String strItemDtlHidden[]=null;
	private String strWt="";
	private String strPath="";
	private String strFileNo="";
	private String strPageNo="";
	private String strFileName="";
	private String []strMemberRecommendation=null;
	private String []strCommitteeMemberHidden=null;
	private String strRemarks="";
	private String strResult="1";
	private WebRowSet CommitteMemberWS=null; 
	private FormFile strLocation=null;
	public String getStrPath() {
		return strPath;
	}
	public void setStrPath(String strPath) {
		this.strPath = strPath;
	}
	public String getComboName() {
		return comboName;
	}
	public void setComboName(String comboName) {
		this.comboName = comboName;
	}
	public String getStrCondemnationType() {
		return strCondemnationType;
	}
	public void setStrCondemnationType(String strCondemnationType) {
		this.strCondemnationType = strCondemnationType;
	}
	public String getStrCommitteTypeValue() {
		return strCommitteTypeValue;
	}
	public void setStrCommitteTypeValue(String strCommitteTypeValue) {
		this.strCommitteTypeValue = strCommitteTypeValue;
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
	public String getStrItemDetailsValue() {
		return strItemDetailsValue;
	}
	public void setStrItemDetailsValue(String strItemDetailsValue) {
		this.strItemDetailsValue = strItemDetailsValue;
	}
	public String getStrCtDate() {
		return strCtDate;
	}
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
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
	public String getStrRequestDetailsValue() {
		return strRequestDetailsValue;
	}
	public void setStrRequestDetailsValue(String strRequestDetailsValue) {
		this.strRequestDetailsValue = strRequestDetailsValue;
	}
	public String getChk() {
		return chk;
	}
	public void setChk(String chk) {
		this.chk = chk;
	}
	
	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}
	public String getStrBuyerListValues() {
		return strBuyerListValues;
	}
	public void setStrBuyerListValues(String strBuyerListValues) {
		this.strBuyerListValues = strBuyerListValues;
	}
	public String getStrItemCategoryName() {
		return strItemCategoryName;
	}
	public void setStrItemCategoryName(String strItemCategoryName) {
		this.strItemCategoryName = strItemCategoryName;
	}
	public String getStrItemNetCost() {
		return strItemNetCost;
	}
	public void setStrItemNetCost(String strItemNetCost) {
		this.strItemNetCost = strItemNetCost;
	}
	public WebRowSet getCommitteMemberWS() {
		return CommitteMemberWS;
	}
	public void setCommitteMemberWS(WebRowSet committeMemberWS) {
		CommitteMemberWS = committeMemberWS;
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
	public void setCombo(String[] combo) {
		this.combo = combo;
	}
	public String[] getCombo() {
		return combo;
	}
	public String getCnt_page() {
		return cnt_page;
	}
	public void setCnt_page(String cnt_page) {
		this.cnt_page = cnt_page;
	}
	public String getStrCondemnationTypeName() {
		return strCondemnationTypeName;
	}
	public void setStrCondemnationTypeName(String strCondemnationTypeName) {
		this.strCondemnationTypeName = strCondemnationTypeName;
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
	public String getStrResult() {
		return strResult;
	}
	public void setStrResult(String strResult) {
		this.strResult = strResult;
	}
	public FormFile getStrLocation() {
		return strLocation;
	}
	public void setStrLocation(FormFile strLocation) {
		this.strLocation = strLocation;
	}
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

	
}
