package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;

public class ExportRecordsTransFB extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 02L;

	private String strErrorMsg = "";
	private String strMsg = "";
	private String strWarning = "";
	
	private String strTemplate = "";
	private String strTemplateValues = "";
 	
	private String strExportType = "0";
	private String strFooter = "";
	
	private String strReportName = "";
	
	private String strTableWidth = "";
	private String strTableWidthUnit = "";
	private String strIsBorderReq = "";
	
	private String strInParamName[] = null;
	private String strInConstantValue[] = null;
	
	private String strOutParamName[] = null;
	private String strXlsColumnIndex[] = null;
	private String strXlsColumnName[] = null;
	private String strOutConstantValue[] = null;
	private String strGrandTotalStatus[] = null;
	private String strArgName[] = null;
	
	private String strColumnWidth[] = null ;
	private String strColumnWidthUnit[] = null;
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	
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
	public String getStrTemplateValues() {
		return strTemplateValues;
	}
	public void setStrTemplateValues(String strTemplateValues) {
		this.strTemplateValues = strTemplateValues;
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
	public String getStrExportType() {
		return strExportType;
	}
	public void setStrExportType(String strExportType) {
		this.strExportType = strExportType;
	}
	public String getStrFooter() {
		return strFooter;
	}
	public void setStrFooter(String strFooter) {
		this.strFooter = strFooter;
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
	public String[] getStrOutParamName() {
		return strOutParamName;
	}
	public void setStrOutParamName(String[] strOutParamName) {
		this.strOutParamName = strOutParamName;
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
	public String[] getStrOutConstantValue() {
		return strOutConstantValue;
	}
	public void setStrOutConstantValue(String[] strOutConstantValue) {
		this.strOutConstantValue = strOutConstantValue;
	}
	public String[] getStrGrandTotalStatus() {
		return strGrandTotalStatus;
	}
	public void setStrGrandTotalStatus(String[] strGrandTotalStatus) {
		this.strGrandTotalStatus = strGrandTotalStatus;
	}
	public String[] getStrArgName() {
		return strArgName;
	}
	public void setStrArgName(String[] strArgName) {
		this.strArgName = strArgName;
	}
	public String getStrTableWidth() {
		return strTableWidth;
	}
	public void setStrTableWidth(String strTableWidth) {
		this.strTableWidth = strTableWidth;
	}
	public String getStrTableWidthUnit() {
		return strTableWidthUnit;
	}
	public void setStrTableWidthUnit(String strTableWidthUnit) {
		this.strTableWidthUnit = strTableWidthUnit;
	}
	public String getStrIsBorderReq() {
		return strIsBorderReq;
	}
	public void setStrIsBorderReq(String strIsBorderReq) {
		this.strIsBorderReq = strIsBorderReq;
	}
	public String[] getStrColumnWidth() {
		return strColumnWidth;
	}
	public void setStrColumnWidth(String[] strColumnWidth) {
		this.strColumnWidth = strColumnWidth;
	}
	public String[] getStrColumnWidthUnit() {
		return strColumnWidthUnit;
	}
	public void setStrColumnWidthUnit(String[] strColumnWidthUnit) {
		this.strColumnWidthUnit = strColumnWidthUnit;
	}
	public String getStrReportName() {
		return strReportName;
	}
	public void setStrReportName(String strReportName) {
		this.strReportName = strReportName;
	}
		
}
