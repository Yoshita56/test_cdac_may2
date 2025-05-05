package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

public class ApprovalDtlHlpVO 
{
	private static final long serialVersionUID = 02L;
	
	private String strMsgString = "";
	private String strMsgType = "0";
	
	private String strFrmStoreId = "0";
	private String strToStoreId = "0";
	private String strItemCatgCode = "0";
	private String strReqTypeId = "0";
	private String strReqNo = "0";
	private String strHospCode = "0";
	private String strSeatId ="0";
	
	private String strLevel = "";
	private String strValue6 = "";
	private String strValue7 = "";
		
	private WebRowSet gblWs1 = null;
	private WebRowSet gblWs2 = null;
	private WebRowSet gblWs3 = null;
	
	private String strReqStatus="";
	
	
	
	public String getStrReqStatus() {
		return strReqStatus;
	}
	public void setStrReqStatus(String strReqStatus) {
		this.strReqStatus = strReqStatus;
	}
	public String getStrFrmStoreId() {
		return strFrmStoreId;
	}
	public void setStrFrmStoreId(String strFrmStoreId) {
		this.strFrmStoreId = strFrmStoreId;
	}
	public String getStrToStoreId() {
		return strToStoreId;
	}
	public void setStrToStoreId(String strToStoreId) {
		this.strToStoreId = strToStoreId;
	}
	public String getStrItemCatgCode() {
		return strItemCatgCode;
	}
	public void setStrItemCatgCode(String strItemCatgCode) {
		this.strItemCatgCode = strItemCatgCode;
	}
	public String getStrReqTypeId() {
		return strReqTypeId;
	}
	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}
	public String getStrReqNo() {
		return strReqNo;
	}
	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
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
	public WebRowSet getGblWs1() {
		return gblWs1;
	}
	public void setGblWs1(WebRowSet gblWs1) {
		this.gblWs1 = gblWs1;
	}
	public WebRowSet getGblWs2() {
		return gblWs2;
	}
	public void setGblWs2(WebRowSet gblWs2) {
		this.gblWs2 = gblWs2;
	}
	public WebRowSet getGblWs3() {
		return gblWs3;
	}
	public void setGblWs3(WebRowSet gblWs3) {
		this.gblWs3 = gblWs3;
	}
	public String getStrHospCode() {
		return strHospCode;
	}
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
	}
	public String getStrLevel() {
		return strLevel;
	}
	public void setStrLevel(String strLevel) {
		this.strLevel = strLevel;
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
}
