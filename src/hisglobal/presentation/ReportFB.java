package hisglobal.presentation;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ReportFB extends ActionForm
{

	private String reportType;// rtf/pdf
	private String reportMode;// report or chart
	private String mode;// report or chart
	private String fromHour;
	private String toHour;
	private String fromMin;
	private String toMin;
	private String choice;
	private String fromDate = "";
	private String toDate = "";
	private String jrxmlName;
	private String graphOrText;
	private String chartType;
	private String sysDate;
	private String jrxmlPath;
	private String title;

	private String year;
	private String hospitalName;
	private String hospitalCode;
	private String deptCode;
	private String serviceAreaCode="";
	private String strStatus="";
	
	
	public void reset(ActionMapping mapping, HttpServletRequest request)
	{
		this.setReportType("");// rtf/pdf
		this.setReportMode("");// report or chart
		this.setMode("");// report or chart
		this.setFromHour("");
		this.setToHour("");
		this.setFromMin("");
		this.setToMin("");
		this.setChoice("");
		this.setFromDate("");
		this.setToDate("");
		this.setJrxmlName("");
		this.setGraphOrText("");
		this.setChartType("");
		this.setYear("");
	}
	
	

	public String getJrxmlPath()
	{
		return jrxmlPath;
	}

	public void setJrxmlPath(String jrxmlPath)
	{
		this.jrxmlPath = jrxmlPath;
	}

	public String getSysDate()
	{
		return sysDate;
	}

	public void setSysDate(String sysDate)
	{
		this.sysDate = sysDate;
	}

	public String getChoice()
	{
		return choice;
	}

	public void setChoice(String choice)
	{
		this.choice = choice;
	}

	public String getFromDate()
	{
		return fromDate;
	}

	public void setFromDate(String fromDate)
	{
		this.fromDate = fromDate;
	}

	public String getFromHour()
	{
		return fromHour;
	}

	public void setFromHour(String fromHour)
	{
		this.fromHour = fromHour;

	}

	public String getFromMin()
	{
		return fromMin;
	}

	public void setFromMin(String fromMin)
	{
		this.fromMin = fromMin;
	}

	public String getGraphOrText()
	{
		return graphOrText;
	}

	public void setGraphOrText(String graphOrText)
	{
		this.graphOrText = graphOrText;
	}

	public String getJrxmlName()
	{
		return jrxmlName;
	}

	public void setJrxmlName(String jrxmlName)
	{
		this.jrxmlName = jrxmlName;
	}

	public String getToDate()
	{
		return toDate;
	}

	public void setToDate(String toDate)
	{
		this.toDate = toDate;
	}

	public String getToHour()
	{
		return toHour;
	}

	public void setToHour(String toHour)
	{
		this.toHour = toHour;
	}

	public String getToMin()
	{
		return toMin;
	}

	public void setToMin(String toMin)
	{
		this.toMin = toMin;

	}

	public String getMode()
	{
		return mode;
	}

	public void setMode(String mode)
	{
		this.mode = mode;
	}

	public String getReportMode()
	{
		return reportMode;
	}

	public void setReportMode(String reportMode)
	{
		this.reportMode = reportMode;
	}

	public String getReportType()
	{
		return reportType;
	}

	public void setReportType(String reportType)
	{
		this.reportType = reportType;
	}

	public String getChartType()
	{
		return chartType;
	}

	public void setChartType(String chartType)
	{
		this.chartType = chartType;
	}

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}



	public String getHospitalName() {
		return hospitalName;
	}



	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}



	public String getHospitalCode() {
		return hospitalCode;
	}



	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}



	



	public String getServiceAreaCode() {
		return serviceAreaCode;
	}



	public void setServiceAreaCode(String serviceAreaCode) {
		this.serviceAreaCode = serviceAreaCode;
	}



	public String getStrStatus() {
		return strStatus;
	}



	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}



	public String getDeptCode() {
		return deptCode;
	}



	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}


}
