package mms.masters.controller.fb;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class ImportExportTemplateMstFB extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 02L;

	private String strErrorMsg = "";
	private String strMsg = "";
	private String strWarning = "";
	private String strSeatId = "";
	
	private String strTemplate = "";
	private String strTemplateId = "";
	private String strTemplateValues = "";
	private String strProcedure = "";
	private String strPackage = "";
	private String strProcedureValues = "";
	private String strExcelFilePathName = "";
	
	private String[] strParamCompType = null;
	private String[] strComboQuery = null;
	
	private FormFile  strExcelFilePath = null;
	
	private String strMappingContents = "";
	
	private String strHospitalCode = "";
		
	private String strTemplateType = "1";
	
	private String strParamType = "1";
	
	private String[] strProcColumnDtls = null;
	private String[] strExcelHeaderNames = null;
	private String[] strConstantValue = null;
	
	private String[] strProcInColumnDtls = null;
	private String[] strInConstantValue = null;
	
	private String[] strProcOutColumnDtls = null;
	private String[] strProcOutColumnIndex = null;
	private String[] strExcelHeader = null;
	
	private String[] strParamDispalyName = null;
	
	public String[] getStrParamDispalyName() {
		return strParamDispalyName;
	}
	public void setStrParamDispalyName(String[] strParamDispalyName) {
		this.strParamDispalyName = strParamDispalyName;
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
	public String[] getStrConstantValue() {
		return strConstantValue;
	}
	public void setStrConstantValue(String[] strConstantValue) {
		this.strConstantValue = strConstantValue;
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
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrTemplateValues() {
		return strTemplateValues;
	}
	public void setStrTemplateValues(String strTemplateValues) {
		this.strTemplateValues = strTemplateValues;
	}
	public String getStrProcedureValues() {
		return strProcedureValues;
	}
	public void setStrProcedureValues(String strProcedureValues) {
		this.strProcedureValues = strProcedureValues;
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
	public String getStrTemplate() {
		return strTemplate;
	}
	public void setStrTemplate(String strTemplate) {
		this.strTemplate = strTemplate;
	}
	public String getStrProcedure() {
		return strProcedure;
	}
	public void setStrProcedure(String strProcedure) {
		this.strProcedure = strProcedure;
	}
	 
	public String getStrMappingContents() {
		return strMappingContents;
	}
	public void setStrMappingContents(String strMappingContents) {
		this.strMappingContents = strMappingContents;
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
	public String getStrParamType() {
		return strParamType;
	}
	public void setStrParamType(String strParamType) {
		this.strParamType = strParamType;
	}
	public String getStrPackage() {
		return strPackage;
	}
	public void setStrPackage(String strPackage) {
		this.strPackage = strPackage;
	}
	public FormFile getStrExcelFilePath() {
		return strExcelFilePath;
	}
	public void setStrExcelFilePath(FormFile strExcelFilePath) {
		this.strExcelFilePath = strExcelFilePath;
	}
	public String getStrExcelFilePathName() {
		return strExcelFilePathName;
	}
	public void setStrExcelFilePathName(String strExcelFilePathName) {
		this.strExcelFilePathName = strExcelFilePathName;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
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
	
	
	
}
