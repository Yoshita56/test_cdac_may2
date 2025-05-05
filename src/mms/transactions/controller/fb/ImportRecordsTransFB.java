package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class ImportRecordsTransFB extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 02L;
	
	private String strErrorMsg = "";
	private String strMsg = "";
	private String strWarning = "";
	
	private String strTemplate = "";
	private String strTemplateName = "";
	private String strTemplateValues = "";
	
	private FormFile strExcelFilePath = null;
	private String strExcelFileName = "";
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strIpAddress = "";
	
	private String[] strParamName = null;
	private String[] strXlsColumnIndex = null;
	private String[] strXlsColumnName = null;
	private String[] strConstantValue = null;
	 
	
	
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
	public String getStrTemplate() {
		return strTemplate;
	}
	public void setStrTemplate(String strTemplate) {
		this.strTemplate = strTemplate;
	}
	public String getStrTemplateValues() {
		return strTemplateValues;
	}
	public void setStrTemplateValues(String strTemplateValues) {
		this.strTemplateValues = strTemplateValues;
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
	public String getStrErrorMsg() {
		return strErrorMsg;
	}
	public void setStrErrorMsg(String strErrorMsg) {
		this.strErrorMsg = strErrorMsg;
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
