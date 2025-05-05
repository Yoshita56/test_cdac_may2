package in.cdac.invWebServices.general.vo;

public class Report {
	
	private String testName;
	private String reqDNo;
	private String reportDate;
	
	public Report(String testName, String reqDNo, String reportDate) {
		super();
		this.testName = testName;
		this.reqDNo = reqDNo;
		this.reportDate = reportDate;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getReqDNo() {
		return reqDNo;
	}

	public void setReqDNo(String reqDNo) {
		this.reqDNo = reqDNo;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	
	

}
