package mms.transactions.vo;

import hisglobal.utility.TransferObject;

import javax.sql.rowset.WebRowSet;

public class ExportRecordsTransVO implements TransferObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 02L;
	private String strMsgString = "";
	private String strMsgType = "0";
	
	
	private String strTemplate = "";
	private WebRowSet wsTemplateList = null; 
	
	private String strTemplateId = "0";
	private WebRowSet wsTemplateDetails = null;
	
	private String strInParamName[] = null;
	private String strInConstantValue[] = null;
	 
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strProcedureType = "";
	private String strTemplateType = "";
	
	private String strCallProcedure = "";
	
	private WebRowSet wsExportedDatas = null;
	
	public WebRowSet getWsExportedDatas() {
		return wsExportedDatas;
	}
	public void setWsExportedDatas(WebRowSet wsExportedDatas) {
		this.wsExportedDatas = wsExportedDatas;
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
	public String getStrTemplate() {
		return strTemplate;
	}
	public void setStrTemplate(String strTemplate) {
		this.strTemplate = strTemplate;
	}
	public WebRowSet getWsTemplateList() {
		return wsTemplateList;
	}
	public void setWsTemplateList(WebRowSet wsTemplateList) {
		this.wsTemplateList = wsTemplateList;
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
	public String getStrProcedureType() {
		return strProcedureType;
	}
	public void setStrProcedureType(String strProcedureType) {
		this.strProcedureType = strProcedureType;
	}
	public String getStrTemplateType() {
		return strTemplateType;
	}
	public void setStrTemplateType(String strTemplateType) {
		this.strTemplateType = strTemplateType;
	}
	public String getStrTemplateId() {
		return strTemplateId;
	}
	public void setStrTemplateId(String strTemplateId) {
		this.strTemplateId = strTemplateId;
	}
	public WebRowSet getWsTemplateDetails() {
		return wsTemplateDetails;
	}
	public void setWsTemplateDetails(WebRowSet wsTemplateDetails) {
		this.wsTemplateDetails = wsTemplateDetails;
	}
	public String getStrCallProcedure() {
		return strCallProcedure;
	}
	public void setStrCallProcedure(String strCallProcedure) {
		this.strCallProcedure = strCallProcedure;
	}
	public String[] getStrInParamName() {
		return strInParamName;
	}
	public void setStrInParamName(String[] strInParamName) {
		this.strInParamName = strInParamName;
	}
	public String[] getStrInConstantValue() {
		return strInConstantValue;
	}
	public void setStrInConstantValue(String[] strInConstantValue) {
		this.strInConstantValue = strInConstantValue;
	}
	 
}
