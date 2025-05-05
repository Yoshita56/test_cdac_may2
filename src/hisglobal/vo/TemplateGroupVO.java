package hisglobal.vo;

public class TemplateGroupVO extends ValueObject
{
	private String templateGroupID;
	private String templateGroupName;
	private String hospitalCode;
	private String isValid;
	private String seatId;
	private String entryDate;

	public String getTemplateGroupID()
	{
		return templateGroupID;
	}

	public void setTemplateGroupID(String templateGroupID)
	{
		this.templateGroupID = templateGroupID;
	}

	public String getTemplateGroupName()
	{
		return templateGroupName;
	}

	public void setTemplateGroupName(String templateGroupName)
	{
		this.templateGroupName = templateGroupName;
	}

	public String getHospitalCode()
	{
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode)
	{
		this.hospitalCode = hospitalCode;
	}

	public String getIsValid()
	{
		return isValid;
	}

	public void setIsValid(String isValid)
	{
		this.isValid = isValid;
	}

	public String getSeatId()
	{
		return seatId;
	}

	public void setSeatId(String seatId)
	{
		this.seatId = seatId;
	}

	public String getEntryDate()
	{
		return entryDate;
	}

	public void setEntryDate(String entryDate)
	{
		this.entryDate = entryDate;
	}
}
