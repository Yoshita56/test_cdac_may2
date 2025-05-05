package hisglobal.vo;

public class TemplateParameterMasterVO extends ValueObject
{
	private String templateId;
	private String serialNo;
	private String row;
	private String col;
	private String paraId;
	private String parentParaId;
	private String parentIdLocation;
	private String locationType;
	private String colspan;
	private String controlType;
	private String displayValue;
	private String controlProps;
	private String sourceFlag;
	private String staticOptions;
	private String dynamicQuery;
	private String isCompulsory;
	private String isRange;
	private String isValid;
	private String haveDependent;
	private String dependentParaId;
	private String seatId;
	private String entryDate;
	private String hospitalCode;
	
	private String paraName;
	
	public TemplateParameterMasterVO()
	{
		
	}

	public String getTemplateId()
	{
		return templateId;
	}
	public void setTemplateId(String templateId)
	{
		this.templateId = templateId;
	}
	public String getRow()
	{
		return row;
	}
	public void setRow(String row)
	{
		this.row = row;
	}
	public String getCol()
	{
		return col;
	}
	public void setCol(String col)
	{
		this.col = col;
	}
	public String getParaId()
	{
		return paraId;
	}
	public void setParaId(String paraId)
	{
		this.paraId = paraId;
	}
	public String getParentParaId()
	{
		return parentParaId;
	}
	public void setParentParaId(String parentParaId)
	{
		this.parentParaId = parentParaId;
	}
	public String getLocationType()
	{
		return locationType;
	}
	public void setLocationType(String locationType)
	{
		this.locationType = locationType;
	}
	public String getColspan()
	{
		return colspan;
	}
	public void setColspan(String colspan)
	{
		this.colspan = colspan;
	}
	public String getControlType()
	{
		return controlType;
	}
	public void setControlType(String controlType)
	{
		this.controlType = controlType;
	}
	public String getDisplayValue()
	{
		return displayValue;
	}
	public void setDisplayValue(String displayValue)
	{
		this.displayValue = displayValue;
	}
	public String getControlProps()
	{
		return controlProps;
	}
	public void setControlProps(String controlProps)
	{
		this.controlProps = controlProps;
	}
	public String getSourceFlag()
	{
		return sourceFlag;
	}
	public void setSourceFlag(String sourceFlag)
	{
		this.sourceFlag = sourceFlag;
	}
	public String getStaticOptions()
	{
		return staticOptions;
	}
	public void setStaticOptions(String staticOptions)
	{
		this.staticOptions = staticOptions;
	}
	public String getDynamicQuery()
	{
		return dynamicQuery;
	}
	public void setDynamicQuery(String dynamicQuery)
	{
		this.dynamicQuery = dynamicQuery;
	}
	public String getIsCompulsory()
	{
		return isCompulsory;
	}
	public void setIsCompulsory(String isCompulsory)
	{
		this.isCompulsory = isCompulsory;
	}
	public String getIsRange()
	{
		return isRange;
	}
	public void setIsRange(String isRange)
	{
		this.isRange = isRange;
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
	public String getHospitalCode()
	{
		return hospitalCode;
	}
	public void setHospitalCode(String hospitalCode)
	{
		this.hospitalCode = hospitalCode;
	}

	public String getSerialNo()
	{
		return serialNo;
	}

	public void setSerialNo(String serialNo)
	{
		this.serialNo = serialNo;
	}

	public String getParentIdLocation()
	{
		return parentIdLocation;
	}

	public void setParentIdLocation(String parentIdLocation)
	{
		this.parentIdLocation = parentIdLocation;
	}

	public String getHaveDependent()
	{
		return haveDependent;
	}

	public void setHaveDependent(String haveDependent)
	{
		this.haveDependent = haveDependent;
	}

	public String getDependentParaId()
	{
		return dependentParaId;
	}

	public void setDependentParaId(String dependentParaId)
	{
		this.dependentParaId = dependentParaId;
	}

	public String getParaName()
	{
		return paraName;
	}

	public void setParaName(String paraName)
	{
		this.paraName = paraName;
	}
}
