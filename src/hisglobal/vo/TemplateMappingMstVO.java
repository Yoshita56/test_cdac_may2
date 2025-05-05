package hisglobal.vo;

public class TemplateMappingMstVO extends ValueObject
{
	private String templateMappingId;
	private String templateId;
	private String templateName;
	private String templateCategory;
	private String isDefault;
	private String isValid;
	private String deptCode;
	private String deptUnitCode;
	private String wardCode;
	
	public String getTemplateMappingId() {
		return templateMappingId;
	}
	public void setTemplateMappingId(String templateMappingId) {
		this.templateMappingId = templateMappingId;
	}
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public String getTemplateCategory() {
		return templateCategory;
	}
	public void setTemplateCategory(String templateCategory) {
		this.templateCategory = templateCategory;
	}
	public String getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	public String getIsValid() {
		return isValid;
	}
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getDeptUnitCode() {
		return deptUnitCode;
	}
	public void setDeptUnitCode(String deptUnitCode) {
		this.deptUnitCode = deptUnitCode;
	}
	public String getWardCode() {
		return wardCode;
	}
	public void setWardCode(String wardCode) {
		this.wardCode = wardCode;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	
	
}
