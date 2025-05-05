package hisglobal.vo;

public class ParameterRangeMasterVO extends ValueObject
{
	private String paraId;
	private String paraRangeId;
	private String genderCode;
	private String lowAge;
	private String highAge;
	private String lowValue;
	private String highValue;
	private String unitOfMeasure;
	
	private String paraName;
	private String isValid;
	private String seatId;
	private String entryDate;
	private String hospitalCode;

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

	public String getParaId()
	{
		return paraId;
	}

	public void setParaId(String paraId)
	{
		this.paraId = paraId;
	}

	public String getParaName()
	{
		return paraName;
	}

	public void setParaName(String paraName)
	{
		this.paraName = paraName;
	}

	public String getParaRangeId()
	{
		return paraRangeId;
	}

	public void setParaRangeId(String paraRangeId)
	{
		this.paraRangeId = paraRangeId;
	}

	public String getGenderCode()
	{
		return genderCode;
	}

	public void setGenderCode(String genderCode)
	{
		this.genderCode = genderCode;
	}

	public String getLowAge()
	{
		return lowAge;
	}

	public void setLowAge(String lowAge)
	{
		this.lowAge = lowAge;
	}

	public String getHighAge()
	{
		return highAge;
	}

	public void setHighAge(String highAge)
	{
		this.highAge = highAge;
	}

	public String getLowValue()
	{
		return lowValue;
	}

	public void setLowValue(String lowValue)
	{
		this.lowValue = lowValue;
	}

	public String getHighValue()
	{
		return highValue;
	}

	public void setHighValue(String highValue)
	{
		this.highValue = highValue;
	}

	public String getUnitOfMeasure()
	{
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure)
	{
		this.unitOfMeasure = unitOfMeasure;
	}
}
