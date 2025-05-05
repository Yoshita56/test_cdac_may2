package hisglobal.vo;

public class TemplateCategoryVO extends ValueObject
{
	private String templateCategory;
	private String templateCategoryType;
	private String hospitalCode;
	private String isValid;
	private String seatId;
	private String isUnique;
	private String templateGroupID;

	public String getTemplateCategory()
	{
		return templateCategory;
	}

	public void setTemplateCategory(String templateCategory)
	{
		this.templateCategory = templateCategory;
	}

	public String getTemplateCategoryType()
	{
		return templateCategoryType;
	}

	public void setTemplateCategoryType(String templateCategoryType)
	{
		this.templateCategoryType = templateCategoryType;
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

	public String getIsUnique()
	{
		return isUnique;
	}

	public void setIsUnique(String isUnique)
	{
		this.isUnique = isUnique;
	}

	public String getTemplateGroupID()
	{
		return templateGroupID;
	}

	public void setTemplateGroupID(String templateGroupID)
	{
		this.templateGroupID = templateGroupID;
	}
}
