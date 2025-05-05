package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;
/**
 * @author Amit Kumar
 * Date of Creation : 07/4/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
public class PODeskTransADDFB extends ActionForm
{
	private static final long serialVersionUID = 02L;
    private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
    private String strMsgString = "";
	private String strMsgType = "";
	private String strErrMsg = "";

	private String strHospitalCode = "";
	private String strGroupId = "";
	private String strCtDate = "";
	private String strSeatId = "";
	private String strPOType ="";
	private String strIndentNo="";
	private String strSupplName="";
	/********Trans Variable Start from here*******/
	private String strStoreName ="";
	private String strAgencyName="";
	private String strCAName="";
	private String strCurrencyCode="";
	private String strIACChg="";
	private String strFrghtInsurChg="";
	private String strTenderNo="";
	private String strQutNo="";
	private String strQutDate="";
	private String strTenderDate="";
	private String strItemDtl="";
	private String strAgendaNo ="";
	private String strAdvanceToPay="";
		
	
	/********Trans Variable End from here*********/
	
	public String getStrAdvanceToPay() {
		return strAdvanceToPay;
	}
	public void setStrAdvanceToPay(String strAdvanceToPay) {
		this.strAdvanceToPay = strAdvanceToPay;
	}
	public String getStrAgendaNo() {
		return strAgendaNo;
	}
	public void setStrAgendaNo(String strAgendaNo) {
		this.strAgendaNo = strAgendaNo;
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
	
	public String getStrErr() {
		return strErr;
	}
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}
	public String getStrMsg() {
		return strMsg;
	}
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
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
	public String getStrMsgType() {
		return strMsgType;
	}
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}
	public String getStrErrMsg() {
		return strErrMsg;
	}
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrGroupId() {
		return strGroupId;
	}
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}
	public String getStrCtDate() {
		return strCtDate;
	}
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getStrPOType() {
		return strPOType;
	}
	public void setStrPOType(String strPOType) {
		this.strPOType = strPOType;
	}
	public String getStrIndentNo() {
		return strIndentNo;
	}
	public void setStrIndentNo(String strIndentNo) {
		this.strIndentNo = strIndentNo;
	}
	public String getStrSupplName() {
		return strSupplName;
	}
	public void setStrSupplName(String strSupplName) {
		this.strSupplName = strSupplName;
	}
	public String getStrAgencyName() {
		return strAgencyName;
	}
	public void setStrAgencyName(String strAgencyName) {
		this.strAgencyName = strAgencyName;
	}
	public String getStrCAName() {
		return strCAName;
	}
	public void setStrCAName(String strCAName) {
		this.strCAName = strCAName;
	}
	public String getStrCurrencyCode() {
		return strCurrencyCode;
	}
	public void setStrCurrencyCode(String strCurrencyCode) {
		this.strCurrencyCode = strCurrencyCode;
	}
	public String getStrIACChg() {
		return strIACChg;
	}
	public void setStrIACChg(String strIACChg) {
		this.strIACChg = strIACChg;
	}
	public String getStrFrghtInsurChg() {
		return strFrghtInsurChg;
	}
	public void setStrFrghtInsurChg(String strFrghtInsurChg) {
		this.strFrghtInsurChg = strFrghtInsurChg;
	}
	public String getStrTenderNo() {
		return strTenderNo;
	}
	public void setStrTenderNo(String strTenderNo) {
		this.strTenderNo = strTenderNo;
	}
	public String getStrQutNo() {
		return strQutNo;
	}
	public void setStrQutNo(String strQutNo) {
		this.strQutNo = strQutNo;
	}
	public String getStrQutDate() {
		return strQutDate;
	}
	public void setStrQutDate(String strQutDate) {
		this.strQutDate = strQutDate;
	}
	public String getStrTenderDate() {
		return strTenderDate;
	}
	public void setStrTenderDate(String strTenderDate) {
		this.strTenderDate = strTenderDate;
	}
	
	
	

}
