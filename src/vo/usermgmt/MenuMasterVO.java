package vo.usermgmt;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.internal.xr.ValueObject;

@XmlRootElement
public class MenuMasterVO extends ValueObject implements Serializable
{
	private static final long serialVersionUID = 3101L;

	@XmlElement
	private String varMenuId;
	private String varEntryDate;
	@XmlElement
	private String varApplicationType;
	@XmlElement
	private String varDisplayOrder;
	private String varHl7Code;
	@XmlElement
	private String varIsPortal;
	private String varIsValid;
	@XmlElement
	private String varMenuLevel;
	@XmlElement
	private String varMenuPosition;
	@XmlElement
	private String varModuleId;
	@XmlElement
	private String varParentId;
	private String varSeatId;
	@XmlElement
	private String varJSFunctionName;
	@XmlElement
	private String varMenuName;
	@XmlElement
	private String varMenuClassId;
	@XmlElement
	private String varURL;

	@XmlElement
	private String varMenuContext;
	@XmlElement
	private String varModuleName;
	private String varHospitalCode;
	private String varUserId;
	

	
	public String getVarMenuId()
	{
		return varMenuId;
	}

	public void setVarMenuId(String varMenuId)
	{
		this.varMenuId = varMenuId;
	}

	public String getVarEntryDate()
	{
		return varEntryDate;
	}

	public void setVarEntryDate(String varEntryDate)
	{
		this.varEntryDate = varEntryDate;
	}

	public String getVarApplicationType()
	{
		return varApplicationType;
	}

	public void setVarApplicationType(String varApplicationType)
	{
		this.varApplicationType = varApplicationType;
	}

	public String getVarDisplayOrder()
	{
		return varDisplayOrder;
	}

	public void setVarDisplayOrder(String varDisplayOrder)
	{
		this.varDisplayOrder = varDisplayOrder;
	}

	public String getVarHl7Code()
	{
		return varHl7Code;
	}

	public void setVarHl7Code(String varHl7Code)
	{
		this.varHl7Code = varHl7Code;
	}

	public String getVarIsPortal()
	{
		return varIsPortal;
	}

	public void setVarIsPortal(String varIsPortal)
	{
		this.varIsPortal = varIsPortal;
	}

	public String getVarIsValid()
	{
		return varIsValid;
	}

	public void setVarIsValid(String varIsValid)
	{
		this.varIsValid = varIsValid;
	}

	public String getVarMenuLevel()
	{
		return varMenuLevel;
	}

	public void setVarMenuLevel(String varMenuLevel)
	{
		this.varMenuLevel = varMenuLevel;
	}

	public String getVarMenuPosition()
	{
		return varMenuPosition;
	}

	public void setVarMenuPosition(String varMenuPosition)
	{
		this.varMenuPosition = varMenuPosition;
	}

	public String getVarModuleId()
	{
		return varModuleId;
	}

	public void setVarModuleId(String varModuleId)
	{
		this.varModuleId = varModuleId;
	}

	public String getVarParentId()
	{
		return varParentId;
	}

	public void setVarParentId(String varParentId)
	{
		this.varParentId = varParentId;
	}

	public String getVarSeatId()
	{
		return varSeatId;
	}

	public void setVarSeatId(String varSeatId)
	{
		this.varSeatId = varSeatId;
	}

	public String getVarJSFunctionName()
	{
		return varJSFunctionName;
	}

	public void setVarJSFunctionName(String varJSFunctionName)
	{
		this.varJSFunctionName = varJSFunctionName;
	}

	public String getVarMenuName()
	{
		return varMenuName;
	}

	public void setVarMenuName(String varMenuName)
	{
		this.varMenuName = varMenuName;
	}

	public String getVarMenuClassId()
	{
		return varMenuClassId;
	}

	public void setVarMenuClassId(String varMenuClassId)
	{
		this.varMenuClassId = varMenuClassId;
	}

	public String getVarURL()
	{
		return varURL;
	}

	public void setVarURL(String varURL)
	{
		this.varURL = varURL;
	}

	public String getVarMenuContext()
	{
		return varMenuContext;
	}

	public void setVarMenuContext(String varMenuContext)
	{
		this.varMenuContext = varMenuContext;
	}

	public String getVarModuleName() {
		return varModuleName;
	}

	public void setVarModuleName(String varModuleName) {
		this.varModuleName = varModuleName;
	}

	public String getVarHospitalCode() {
		return varHospitalCode;
	}

	public void setVarHospitalCode(String varHospitalCode) {
		this.varHospitalCode = varHospitalCode;
	}

	public String getVarUserId() {
		return varUserId;
	}

	public void setVarUserId(String varUserId) {
		this.varUserId = varUserId;
	}

	}
