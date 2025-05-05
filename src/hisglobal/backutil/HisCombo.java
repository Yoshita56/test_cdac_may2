package hisglobal.backutil;

import java.util.ArrayList;
 
public class HisCombo
{
	private String optionValue;
	private String optionText;
	
	public HisCombo(String optionValue,String optionText)
	{
		this.optionValue = optionValue;
		this.optionText = optionText;
	}
	
	/*
	Getter
	*/
	public String getOptionValue()
	{
		return this.optionValue;
	}
	
	public String getOptionText()
	{
		return this.optionText;
	}
	
	/*
	Setter
	*/
	
	public void setOptionValue(String optionValue)
	{
		this.optionValue=optionValue;
	}
	
	public void setOptionText(String optionText)
	{
		this.optionText=optionText;
	}
}