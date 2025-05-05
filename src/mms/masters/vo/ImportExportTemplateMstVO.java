package mms.masters.vo;

import hisglobal.utility.TransferObject;

import javax.sql.rowset.WebRowSet;

public class ImportExportTemplateMstVO implements TransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 02L;
	private String strMsgString = "";
	private String strMsgType = "0";

	private String strSeatId = "";
	
	private String strTemplate = "";
	private String strTemplateId = "";
	private WebRowSet wsTemplateValues = null;
	private String strProcedure = "";
	private String strProcedureType = "";
	private WebRowSet wsProcedureValues = null;
	 

	private String[] strParamCompType = null;
	private String[] strComboQuery = null;
	
	private WebRowSet wsTemplateDetails = null;
	
	private String[] strProcColumnDtls = null;
	private String[] strExcelHeaderNames = null;
	private String[] strConstantValue = null;
	
	private String[] strProcInColumnDtls = null;
	private String[] strInConstantValue = null;
	
	private String[] strProcOutColumnDtls = null;
	private String[] strProcOutColumnIndex = null;
	private String[] strExcelHeader = null;
	
	private String[] strParamDispalyName = null;
	
	private String strTemplateType = "1";
	
	private String strParamType = "1";
	
	private String strHospitalCode = "";
	
	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
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

	public WebRowSet getWsTemplateValues() {
		return wsTemplateValues;
	}

	public void setWsTemplateValues(WebRowSet wsTemplateValues) {
		this.wsTemplateValues = wsTemplateValues;
	}

	public String getStrProcedure() {
		return strProcedure;
	}

	public void setStrProcedure(String strProcedure) {
		this.strProcedure = strProcedure;
	}

	public WebRowSet getWsProcedureValues() {
		return wsProcedureValues;
	}

	public void setWsProcedureValues(WebRowSet wsProcedureValues) {
		this.wsProcedureValues = wsProcedureValues;
	}

	public String getStrTemplateType() {
		return strTemplateType;
	}

	public void setStrTemplateType(String strTemplateType) {
		this.strTemplateType = strTemplateType;
	}

	public String getStrSeatId() {
		return strSeatId;
	}

	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	public String getStrTemplateId() {
		return strTemplateId;
	}

	public void setStrTemplateId(String strTemplateId) {
		this.strTemplateId = strTemplateId;
	}

	public String[] getStrProcColumnDtls() {
		return strProcColumnDtls;
	}

	public void setStrProcColumnDtls(String[] strProcColumnDtls) {
		this.strProcColumnDtls = strProcColumnDtls;
	}

	public String[] getStrExcelHeaderNames() {
		return strExcelHeaderNames;
	}

	public void setStrExcelHeaderNames(String[] strExcelHeaderNames) {
		this.strExcelHeaderNames = strExcelHeaderNames;
	}

	public WebRowSet getWsTemplateDetails() {
		return wsTemplateDetails;
	}

	public void setWsTemplateDetails(WebRowSet wsTemplateDetails) {
		this.wsTemplateDetails = wsTemplateDetails;
	}

	public String[] getStrConstantValue() {
		return strConstantValue;
	}

	public void setStrConstantValue(String[] strConstantValue) {
		this.strConstantValue = strConstantValue;
	}

	public String getStrParamType() {
		return strParamType;
	}

	public void setStrParamType(String strParamType) {
		this.strParamType = strParamType;
	}

	public String[] getStrProcInColumnDtls() {
		return strProcInColumnDtls;
	}

	public void setStrProcInColumnDtls(String[] strProcInColumnDtls) {
		this.strProcInColumnDtls = strProcInColumnDtls;
	}

	public String[] getStrInConstantValue() {
		return strInConstantValue;
	}

	public void setStrInConstantValue(String[] strInConstantValue) {
		this.strInConstantValue = strInConstantValue;
	}

	public String[] getStrProcOutColumnDtls() {
		return strProcOutColumnDtls;
	}

	public void setStrProcOutColumnDtls(String[] strProcOutColumnDtls) {
		this.strProcOutColumnDtls = strProcOutColumnDtls;
	}

	public String[] getStrProcOutColumnIndex() {
		return strProcOutColumnIndex;
	}

	public void setStrProcOutColumnIndex(String[] strProcOutColumnIndex) {
		this.strProcOutColumnIndex = strProcOutColumnIndex;
	}

	public String[] getStrExcelHeader() {
		return strExcelHeader;
	}

	public void setStrExcelHeader(String[] strExcelHeader) {
		this.strExcelHeader = strExcelHeader;
	}

	public String getStrProcedureType() {
		return strProcedureType;
	}

	public void setStrProcedureType(String strProcedureType) {
		this.strProcedureType = strProcedureType;
	}

	public String[] getStrParamCompType() {
		return strParamCompType;
	}

	public void setStrParamCompType(String[] strParamCompType) {
		this.strParamCompType = strParamCompType;
	}

	public String[] getStrComboQuery() {
		return strComboQuery;
	}

	public void setStrComboQuery(String[] strComboQuery) {
		this.strComboQuery = strComboQuery;
	}

	public String[] getStrParamDispalyName() {
		return strParamDispalyName;
	}

	public void setStrParamDispalyName(String[] strParamDispalyName) {
		this.strParamDispalyName = strParamDispalyName;
	}

	 

}
