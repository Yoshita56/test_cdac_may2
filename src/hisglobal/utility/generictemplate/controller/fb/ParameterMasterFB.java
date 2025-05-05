package hisglobal.utility.generictemplate.controller.fb;

/**
 * @copyright CDAC
 * @developer Pragya Sharma
 */

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ParameterMasterFB extends ActionForm
{
	private String hmode;
	private String chk;
	private String isActive;
	private String paraId;
	private String paraName;
	private String paraBound;
	private String paraType;
	private String parameterValuesList;
	private String rowCount;
	private String colCount;
	private String paraTypeLabel;
	
	private String modeTempModify; // 0-No  1-Yes
	
	public ParameterMasterFB()
	{
		this.hmode="";
		this.paraName="";
		this.paraBound="";
		this.paraType="";
		this.parameterValuesList="";
		this.modeTempModify="0";
	}
	
	public void reset(ActionMapping mapping,HttpServletRequest request) 
	{
		super.reset(mapping,request);
		this.paraName="";
		this.paraBound="";
		this.paraType="";
		this.parameterValuesList="";
		this.modeTempModify="0";
		
	}

	public String getHmode() {
		return hmode;
	}

	public void setHmode(String hmode) {
		this.hmode = hmode;
	}

	public String getChk() {
		return chk;
	}

	public void setChk(String chk) {
		this.chk = chk;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getParaName() {
		return paraName;
	}

	public void setParaName(String paraName) {
		this.paraName = paraName;
	}
	public String getParameterValuesList() {
		return parameterValuesList;
	}

	public void setParameterValuesList(String parameterValuesList) {
		this.parameterValuesList = parameterValuesList;
	}

	public String getRowCount() {
		return rowCount;
	}

	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
	}

	public String getColCount() {
		return colCount;
	}

	public void setColCount(String colCount) {
		this.colCount = colCount;
	}

	public String getModeTempModify() {
		return modeTempModify;
	}

	public void setModeTempModify(String modeTempModify) {
		this.modeTempModify = modeTempModify;
	}

	public String getParaBound() {
		return paraBound;
	}

	public void setParaBound(String paraBound) {
		this.paraBound = paraBound;
	}

	public String getParaType() {
		return paraType;
	}

	public void setParaType(String paraType) {
		this.paraType = paraType;
	}

	public String getParaId() {
		return paraId;
	}

	public void setParaId(String paraId) {
		this.paraId = paraId;
	}

	public String getParaTypeLabel() {
		return paraTypeLabel;
	}

	public void setParaTypeLabel(String paraTypeLabel) {
		this.paraTypeLabel = paraTypeLabel;
	}

	
}
