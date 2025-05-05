package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

public class PODeskTransADDVO 
{
	private static final long serialVersionUID = 02L;
	private String strErr = "";
	private String strMsg = "";
	private String strWarning = "";
    private String strMsgString = "";
	private String strMsgType = "0";
	private String strErrMsg = "";

	private String strHospitalCode = "";
	private String strGroupId = "";
	private String strCtDate = "";
	private String strSeatId = "";
	private String strPOType ="";
	private String strIndentNo="";
	private String strSupplName="";
	/********Trans Variable Start from here*********/
	private WebRowSet strDummyWs = null;
	private String strAgencyName="";
	private String strCAName="";
	private String strCurrencyCode="";
	private String strIACChg="";
	private String strFrghtInsurChg="";
	private String strTenderNo="";
	private String strQutNo="";
	private String strQutDate="";
	private String strTenderDate="";
	private String strAgendaNo ="";
	private String strAdvanceToPay="";
	
	/********Trans Variable END from here*********/
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
	public String getStrSupplName() 
	{
		return strSupplName;
	}
	public void setStrSupplName(String strSupplName) 
	{
		this.strSupplName = strSupplName;
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

	
	public String getStrCtDate() { // function for gettin SYSDATE
		HisUtil util = new HisUtil("PO DESK ADD", "PODeskTransADDVO ");
		try {
			strCtDate = util.getASDate("dd-MMM-yyyy");
			util = null;
		} catch (Exception e) {
			new HisException("MMS Module", "PODeskTransADDVO ",
					"PODeskTransADDVO.getStrCtDate()-->" + e.getMessage());
		}

		return strCtDate;
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

	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
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

	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}
	public WebRowSet getStrDummyWs() {
		return strDummyWs;
	}
	public void setStrDummyWs(WebRowSet strDummyWs) {
		this.strDummyWs = strDummyWs;
	}

}
