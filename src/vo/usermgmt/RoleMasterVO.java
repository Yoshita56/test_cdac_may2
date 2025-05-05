package vo.usermgmt;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.internal.xr.ValueObject;

@XmlRootElement
public class RoleMasterVO extends ValueObject
{
	private String varRoleId;
	private String varHospitalCode;
	private String varIsValid;
	private String varEffectDate;
	private String varEntryDate;
	private String varModuleId;
	private String varSeatId;
	private String varRoleName;

	protected List<MenuMasterVO> lstRoleMenus;

	public String getVarRoleId()
	{
		return varRoleId;
	}

	public void setVarRoleId(String varRoleId)
	{
		this.varRoleId = varRoleId;
	}

	public String getVarHospitalCode()
	{
		return varHospitalCode;
	}

	public void setVarHospitalCode(String varHospitalCode)
	{
		this.varHospitalCode = varHospitalCode;
	}

	public String getVarIsValid()
	{
		return varIsValid;
	}

	public void setVarIsValid(String varIsValid)
	{
		this.varIsValid = varIsValid;
	}

	public String getVarEffectDate()
	{
		return varEffectDate;
	}

	public void setVarEffectDate(String varEffectDate)
	{
		this.varEffectDate = varEffectDate;
	}

	public String getVarEntryDate()
	{
		return varEntryDate;
	}

	public void setVarEntryDate(String varEntryDate)
	{
		this.varEntryDate = varEntryDate;
	}

	public String getVarModuleId()
	{
		return varModuleId;
	}

	public void setVarModuleId(String varModuleId)
	{
		this.varModuleId = varModuleId;
	}

	public String getVarSeatId()
	{
		return varSeatId;
	}

	public void setVarSeatId(String varSeatId)
	{
		this.varSeatId = varSeatId;
	}

	public String getVarRoleName()
	{
		return varRoleName;
	}

	public void setVarRoleName(String varRoleName)
	{
		this.varRoleName = varRoleName;
	}

	public List<MenuMasterVO> getLstRoleMenus()
	{
		return lstRoleMenus;
	}

	public void setLstRoleMenus(List<MenuMasterVO> lstRoleMenus)
	{
		this.lstRoleMenus = lstRoleMenus;
	}
}
