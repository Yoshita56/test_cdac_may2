package in.cdac.mhealth.general.vo;

import java.util.ArrayList;
import java.util.List;

public class InvestigationData {
	
	private String testName;
	private String entryDate;
	private List<ParamDetails> param = new ArrayList<>();
	
	
	public InvestigationData(String testName, String entryDate ,List<ParamDetails> param ) {
		super();
		this.testName = testName;
		this.entryDate = entryDate;
		this.param = param;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public List<ParamDetails> getParam() {
		return param;
	}

	public void setParam(List<ParamDetails> param) {
		this.param = param;
	}

	
	
	
	
	

}
