package hisglobal.utility.generictemplate.controller.fb;

/**
 * @copyright CDAC
 * @developer Pragya Sharma
 */

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class TemplateParameterMasterFB extends ActionForm
{
	private String hmode;
	private String chk[];
	private String isActive;

	private String templateId;
	private String tempSerialNo;
	private String oldTemplateName;
	private String templateName;
	private String templateType;
	private String templateCategory;
	private String templateCategoryName;
	private String templateCategoryType;
	private String templateGroupID;
	private String oldTemplateCategory;
	private String effectiveFrom;
	private String oldEffectiveTo;
	private String effectiveTo;
	private String entryDate;
	
	private String parameterValuesList;
	private String rowCount;
	private String colCount;
	private String controls[];
	
	private String modeTempModify; // 0-No  1-Yes
	private String localLangName;
	

	
	public TemplateParameterMasterFB()
	{
		this.hmode="";
		this.templateId="";
		this.tempSerialNo="";
		this.templateName="";
		this.templateType="0";
		this.parameterValuesList="";
		this.modeTempModify="0";
		this.effectiveFrom="";
		this.effectiveTo="";
		this.entryDate="";
		controls=new String[1];
	}
	
	public void reset(ActionMapping mapping,HttpServletRequest request) 
	{
		super.reset(mapping,request);
		this.templateId="";
		this.templateName="";
		this.templateType="0";
		this.parameterValuesList="";
		this.modeTempModify="0";
		this.effectiveFrom="";
		this.effectiveTo="";
		this.entryDate="";
	}

	public String getHmode()
	{
		return hmode;
	}

	public void setHmode(String hmode)
	{
		this.hmode = hmode;
	}

	public String[] getChk()
	{
		return chk;
	}

	public void setChk(String[] chk)
	{
		this.chk = chk;
	}

	public String getIsActive()
	{
		return isActive;
	}

	public void setIsActive(String isActive)
	{
		this.isActive = isActive;
	}

	public String getTemplateId()
	{
		return templateId;
	}

	public void setTemplateId(String templateId)
	{
		this.templateId = templateId;
	}

	public String getTempSerialNo()
	{
		return tempSerialNo;
	}

	public void setTempSerialNo(String tempSerialNo)
	{
		this.tempSerialNo = tempSerialNo;
	}

	public String getOldTemplateName()
	{
		return oldTemplateName;
	}

	public void setOldTemplateName(String oldTemplateName)
	{
		this.oldTemplateName = oldTemplateName;
	}

	public String getTemplateName()
	{
		return templateName;
	}

	public void setTemplateName(String templateName)
	{
		this.templateName = templateName;
	}

	public String getTemplateType()
	{
		return templateType;
	}

	public void setTemplateType(String templateType)
	{
		this.templateType = templateType;
	}

	public String getEffectiveFrom()
	{
		return effectiveFrom;
	}

	public void setEffectiveFrom(String effectiveFrom)
	{
		this.effectiveFrom = effectiveFrom;
	}

	public String getOldEffectiveTo()
	{
		return oldEffectiveTo;
	}

	public void setOldEffectiveTo(String oldEffectiveTo)
	{
		this.oldEffectiveTo = oldEffectiveTo;
	}

	public String getEffectiveTo()
	{
		return effectiveTo;
	}

	public void setEffectiveTo(String effectiveTo)
	{
		this.effectiveTo = effectiveTo;
	}

	public String getEntryDate()
	{
		return entryDate;
	}

	public void setEntryDate(String entryDate)
	{
		this.entryDate = entryDate;
	}

	public String getParameterValuesList()
	{
		return parameterValuesList;
	}

	public void setParameterValuesList(String parameterValuesList)
	{
		this.parameterValuesList = parameterValuesList;
	}

	public String getRowCount()
	{
		return rowCount;
	}

	public void setRowCount(String rowCount)
	{
		this.rowCount = rowCount;
	}

	public String getColCount()
	{
		return colCount;
	}

	public void setColCount(String colCount)
	{
		this.colCount = colCount;
	}

	public String getModeTempModify()
	{
		return modeTempModify;
	}

	public void setModeTempModify(String modeTempModify)
	{
		this.modeTempModify = modeTempModify;
	}

	public String getTemplateCategory()
	{
		return templateCategory;
	}

	public void setTemplateCategory(String templateCategory)
	{
		this.templateCategory = templateCategory;
	}

	public String getOldTemplateCategory()
	{
		return oldTemplateCategory;
	}

	public void setOldTemplateCategory(String oldTemplateCategory)
	{
		this.oldTemplateCategory = oldTemplateCategory;
	}

	public String getTemplateCategoryType()
	{
		return templateCategoryType;
	}

	public void setTemplateCategoryType(String templateCategoryType)
	{
		this.templateCategoryType = templateCategoryType;
	}

	public String[] getControls() {
		return controls;
	}

	public void setControls(String[] controls) {
		this.controls = controls;
	}

	public String getTemplateCategoryName() {
		return templateCategoryName;
	}

	public void setTemplateCategoryName(String templateCategoryName) {
		this.templateCategoryName = templateCategoryName;
	}

	public String getTemplateGroupID()
	{
		return templateGroupID;
	}

	public void setTemplateGroupID(String templateGroupID)
	{
		this.templateGroupID = templateGroupID;
	}

	public String getLocalLangName() {
		return localLangName;
	}

	public void setLocalLangName(String localLangName) {
		this.localLangName = localLangName;
	}
}
