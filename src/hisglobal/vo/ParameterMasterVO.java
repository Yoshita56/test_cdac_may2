package hisglobal.vo;

public class ParameterMasterVO extends ValueObject
{
	private String paraId;
	private String hospitalCode;
	private String paraName;
	private String isValid;
	private String seatId;
	private String entryDate;
	private String paraBound;
	private String paraType;
	private String parentPara;
	
	private String isParentBased;
	private String key;				// Row&Col Value
	
	public ParameterMasterVO()
	{
		this.isParentBased = "0"; // 0-No, 1-Yes
	}

	public String getParaBound()
	{
		return paraBound;
	}

	public void setParaBound(String paraBound)
	{
		this.paraBound = paraBound;
	}

	public String getParaType()
	{
		return paraType;
	}

	public void setParaType(String paraType)
	{
		this.paraType = paraType;
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

	public String getParentPara()
	{
		return parentPara;
	}

	public void setParentPara(String parentPara)
	{
		this.parentPara = parentPara;
	}

	public String getIsParentBased()
	{
		return isParentBased;
	}

	public void setIsParentBased(String isParentBased)
	{
		this.isParentBased = isParentBased;
	}

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}
}
