package billing;

import hisglobal.utility.TransferObject;

import javax.sql.rowset.WebRowSet;
public class BillingVO implements TransferObject
{
	
	private static final long serialVersionUID = 02L;
	
		
	private String strMsgString = "";
	private String strMsgType = "0";
	
	private String strValue1 = "0";
	private String strValue2 = "0";
	private String strValue3 = "0";
	private String strValue4 = "";
	private String strValue5 = "";
	private String strValue6 = "";
	private String strValue7 = "";
	private String strValue8 = "";
	private String strValue9 = "";
	private String strValue10 = "";
	private String strCatCode = "";
	private String strHospitalCode = "";
	private String strServiceType= "";//OPD-11-CONSULATION ONLY,12-OP & INV,13-IP ONLY,14-IP & INV
	private WebRowSet strTariffWs = null;
	private String strPackageId ="";
	private String strCrNo ="";
	private String strAccNo = "0";
	
	private WebRowSet packagews = null;
	private WebRowSet gblWs1 = null;
	private WebRowSet gblWs2 = null;
	private WebRowSet gblWs3 = null;
	private WebRowSet gblWs4 = null;//Credit Letter Types
	private WebRowSet creditLetterListWS = null;//Credit Letter Types
	
	public String getStrPackageId() {
		return strPackageId;
	}

	public void setStrPackageId(String strPackageId) {
		this.strPackageId = strPackageId;
	}

	public String getStrCrNo() {
		return strCrNo;
	}

	public void setStrCrNo(String strCrNo) {
		this.strCrNo = strCrNo;
	}

	public String getStrAccNo() {
		return strAccNo;
	}

	public void setStrAccNo(String strAccNo) {
		this.strAccNo = strAccNo;
	}

	public WebRowSet getStrTariffWs() {
		return strTariffWs;
	}

	public void setStrTariffWs(WebRowSet strTariffWs) {
		this.strTariffWs = strTariffWs;
	}

	public String getStrValue1() {
		return strValue1;
	}

	public void setStrValue1(String strValue1) {
		this.strValue1 = strValue1;
	}
	public WebRowSet getGblWs1() {
		return gblWs1;
	}

	public void setGblWs1(WebRowSet gblWs1) {
		this.gblWs1 = gblWs1;
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

	public WebRowSet getGblWs2() {
		return gblWs2;
	}

	public void setGblWs2(WebRowSet gblWs2) {
		this.gblWs2 = gblWs2;
	}

	public String getStrValue2() {
		return strValue2;
	}

	public void setStrValue2(String strValue2) {
		this.strValue2 = strValue2;
	}

	public WebRowSet getGblWs3() {
		return gblWs3;
	}

	public void setGblWs3(WebRowSet gblWs3) {
		this.gblWs3 = gblWs3;
	}

	public String getStrValue3() {
		return strValue3;
	}

	public void setStrValue3(String strValue3) {
		this.strValue3 = strValue3;
	}

	public String getStrValue4() {
		return strValue4;
	}

	public void setStrValue4(String strValue4) {
		this.strValue4 = strValue4;
	}

	public String getStrValue5() {
		return strValue5;
	}

	public void setStrValue5(String strValue5) {
		this.strValue5 = strValue5;
	}

	public String getStrValue6() {
		return strValue6;
	}

	public void setStrValue6(String strValue6) {
		this.strValue6 = strValue6;
	}

	public String getStrValue7() {
		return strValue7;
	}

	public void setStrValue7(String strValue7) {
		this.strValue7 = strValue7;
	}

	public String getStrValue8() {
		return strValue8;
	}

	public void setStrValue8(String strValue8) {
		this.strValue8 = strValue8;
	}

	public String getStrValue9() {
		return strValue9;
	}

	public void setStrValue9(String strValue9) {
		this.strValue9 = strValue9;
	}

	public String getStrValue10() {
		return strValue10;
	}

	public void setStrValue10(String strValue10) {
		this.strValue10 = strValue10;
	}

	public WebRowSet getGblWs4() {
		return gblWs4;
	}

	public void setGblWs4(WebRowSet gblWs4) {
		this.gblWs4 = gblWs4;
	}

	public String getStrCatCode() {
		return strCatCode;
	}

	public void setStrCatCode(String strCatCode) {
		this.strCatCode = strCatCode;
	}

	public WebRowSet getCreditLetterListWS() {
		return creditLetterListWS;
	}

	public void setCreditLetterListWS(WebRowSet creditLetterListWS) {
		this.creditLetterListWS = creditLetterListWS;
	}

	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	public String getStrServiceType() {
		return strServiceType;
	}

	public WebRowSet getPackagews() {
		return packagews;
	}

	public void setPackagews(WebRowSet packagews) {
		this.packagews = packagews;
	}

	public void setStrServiceType(String strServiceType) {
		this.strServiceType = strServiceType;
	}	
}
