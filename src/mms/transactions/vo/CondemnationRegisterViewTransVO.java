package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

public class CondemnationRegisterViewTransVO {
	
	private String strMsgType = "0";
	private String strMsgString = "";
	private String strHospitalCode = "";
	
	private String strStoreId ="";
	private String strAgendaNo ="";
	private String strCondemnationType="";
	private String strRemarks="";
	private String strCondemnationNo = "";
	
	private WebRowSet strCondemnDetailsWs = null;
	private WebRowSet strRequestDetailsWs = null;
	private WebRowSet strItemDetailsWs = null;
	private WebRowSet itemDtlWS=null;

	
	public WebRowSet getItemDtlWS() {
		return itemDtlWS;
	}

	public void setItemDtlWS(WebRowSet itemDtlWS) {
		this.itemDtlWS = itemDtlWS;
	}

	public WebRowSet getStrCondemnDetailsWs() {
		return strCondemnDetailsWs;
	}

	public void setStrCondemnDetailsWs(WebRowSet strCondemnDetailsWs) {
		this.strCondemnDetailsWs = strCondemnDetailsWs;
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

	public String getStrCondemnationNo() {
		return strCondemnationNo;
	}

	public void setStrCondemnationNo(String strCondemnationNo) {
		this.strCondemnationNo = strCondemnationNo;
	}

	public String getStrAgendaNo() {
		return strAgendaNo;
	}

	public void setStrAgendaNo(String strAgendaNo) {
		this.strAgendaNo = strAgendaNo;
	}

	public String getStrStoreId() {
		return strStoreId;
	}

	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	public WebRowSet getStrRequestDetailsWs() {
		return strRequestDetailsWs;
	}

	public void setStrRequestDetailsWs(WebRowSet strRequestDetailsWs) {
		this.strRequestDetailsWs = strRequestDetailsWs;
	}

	public WebRowSet getStrItemDetailsWs() {
		return strItemDetailsWs;
	}

	public void setStrItemDetailsWs(WebRowSet strItemDetailsWs) {
		this.strItemDetailsWs = strItemDetailsWs;
	}

	public String getStrCondemnationType() {
		return strCondemnationType;
	}

	public void setStrCondemnationType(String strCondemnationType) {
		this.strCondemnationType = strCondemnationType;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

}
