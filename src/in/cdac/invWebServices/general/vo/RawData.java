package in.cdac.invWebServices.general.vo;

import java.util.ArrayList;
import java.util.List;

public class RawData {
	
	
	private String parameterName;
	private List<ParaRawDetails> raw = new ArrayList<>();

	
	public RawData(String parameterName, List<ParaRawDetails> raw ) {
		super();
		
		
		this.parameterName = parameterName;
		this.raw = raw;
	}


	public String getParameterName() {
		return parameterName;
	}


	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}


	public List<ParaRawDetails> getRaw() {
		return raw;
	}


	public void setRaw(List<ParaRawDetails> raw) {
		this.raw = raw;
	}
	
	
	
	
	
}
