package mms.transactions.vo;

import java.util.ArrayList;

import hisglobal.utility.TransferObject;

import javax.sql.rowset.WebRowSet;

import org.apache.struts.upload.FormFile;

public class ImportRecordsTransVO implements TransferObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 02L;
	private String strMsgString = "";
	private String strMsgType = "0";
	
	private String strMsgErrString = "";
	
	private String strTemplate = "";
	private String strTemplateName = "";
	private WebRowSet wsTemplateList = null; 
	
	private FormFile strExcelFilePath = null;
	private String strExcelFileName = "";
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strIpAddress = "";
	
	private String strProcedureType = "";
	private String strTemplateType = "";
	
	private WebRowSet wsTemplateDetails = null;
	
	private String strTemplateId = "";
	
	private String[] strParamName = null;
	private String[] strXlsColumnIndex = null;
	private String[] strXlsColumnName = null;
	private String[] strConstantValue = null;
	
	private String strInsertRowCount = "0";
	
	private ArrayList<String[]> strExcelContents = null;
	
	private String strCallProcedure = "";
	
	
	public ArrayList<String[]> getStrExcelContents() {
		return strExcelContents;
	}
	public void setStrExcelContents(ArrayList<String[]> strExcelContents) {
		this.strExcelContents = strExcelContents;
	}
	public String getStrCallProcedure() {
		return strCallProcedure;
	}
	public void setStrCallProcedure(String strCallProcedure) {
		this.strCallProcedure = strCallProcedure;
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
	public FormFile getStrExcelFilePath() {
		return strExcelFilePath;
	}
	public void setStrExcelFilePath(FormFile strExcelFilePath) {
		this.strExcelFilePath = strExcelFilePath;
	}
	public String getStrExcelFileName() {
		return strExcelFileName;
	}
	public void setStrExcelFileName(String strExcelFileName) {
		this.strExcelFileName = strExcelFileName;
	}
	public String[] getStrParamName() {
		return strParamName;
	}
	public void setStrParamName(String[] strParamName) {
		this.strParamName = strParamName;
	}
	public String[] getStrXlsColumnIndex() {
		return strXlsColumnIndex;
	}
	public void setStrXlsColumnIndex(String[] strXlsColumnIndex) {
		this.strXlsColumnIndex = strXlsColumnIndex;
	}
	public String[] getStrXlsColumnName() {
		return strXlsColumnName;
	}
	public void setStrXlsColumnName(String[] strXlsColumnName) {
		this.strXlsColumnName = strXlsColumnName;
	}
	public String[] getStrConstantValue() {
		return strConstantValue;
	}
	public void setStrConstantValue(String[] strConstantValue) {
		this.strConstantValue = strConstantValue;
	}
	public String getStrInsertRowCount() {
		return strInsertRowCount;
	}
	public void setStrInsertRowCount(String strInsertRowCount) {
		this.strInsertRowCount = strInsertRowCount;
	}
	public String getStrMsgErrString() {
		return strMsgErrString;
	}
	public void setStrMsgErrString(String strMsgErrString) {
		this.strMsgErrString = strMsgErrString;
	}
	public String getStrIpAddress() {
		return strIpAddress;
	}
	public void setStrIpAddress(String strIpAddress) {
		this.strIpAddress = strIpAddress;
	}
	public String getStrTemplateName() {
		return strTemplateName;
	}
	public void setStrTemplateName(String strTemplateName) {
		this.strTemplateName = strTemplateName;
	}
	
}
