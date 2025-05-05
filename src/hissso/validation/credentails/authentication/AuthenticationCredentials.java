package hissso.validation.credentails.authentication;

/***************************Start of Program Header ****************************
## Copyright Information				: C-DAC, Noida  
## Project Name							: Generation 5, HIS
## Name of Developer		 			: Pragya Sharma
## Module Name							: HIS Single Sign On and Web Security 
## Process/Database Object Name			: AuthenticationCredentials
## Purpose								: 
## Date of Creation						:  
## Modification Log						:				
##		Modify Date				: 2016.16.05 
##		Reason	(CR/PRS)		: Session Time out Issue  
##		Modify By				: Pragya Sharma
**************************End of program*****************************/

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.internal.xr.ValueObject;

import vo.usermgmt.HolidayMasterVO;
import vo.usermgmt.HospitalMasterVO;
import vo.usermgmt.MenuMappingVO;
import vo.usermgmt.MenuMasterVO;
import vo.usermgmt.UserLoginLogVO;
import vo.usermgmt.UserMasterVO;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;





@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) // This line was added
public class AuthenticationCredentials extends ValueObject
{
	protected String varUserId;
	protected String varUserSeatId;
	protected String varUserLoginSessionId;
	protected String varUserLoginUserAgent;

	protected String varUsrName;
	protected String varAccessURL;

	protected UserMasterVO voUser;
	protected HospitalMasterVO voHostpital;
	protected UserLoginLogVO voUserLog;
	protected List<HolidayMasterVO> voHolidays;
	protected List<MenuMappingVO> voMenuCntMapping;
	
	public String getVarUserId()
	{
		return varUserId;
	}

	public void setVarUserId(String varUserId)
	{
		this.varUserId = varUserId;
	}

	public String getVarUserSeatId()
	{
		return varUserSeatId;
	}

	public void setVarUserSeatId(String varUserSeatId)
	{
		this.varUserSeatId = varUserSeatId;
	}

	public String getVarUserLoginSessionId()
	{
		return varUserLoginSessionId;
	}

	public void setVarUserLoginSessionId(String varUserLoginSessionId)
	{
		this.varUserLoginSessionId = varUserLoginSessionId;
	}

	public String getVarUsrName()
	{
		return varUsrName;
	}

	public void setVarUsrName(String varUsrName)
	{
		this.varUsrName = varUsrName;
	}

	public String getVarAccessURL()
	{
		return varAccessURL;
	}

	public void setVarAccessURL(String varAccessURL)
	{
		this.varAccessURL = varAccessURL;
	}

	public UserMasterVO getVoUser()
	{
		return voUser;
	}

	public void setVoUser(UserMasterVO voUser)
	{
		this.voUser = voUser;
	}

	public HospitalMasterVO getVoHostpital()
	{
		return voHostpital;
	}

	public void setVoHostpital(HospitalMasterVO voHostpital)
	{
		this.voHostpital = voHostpital;
	}

	public UserLoginLogVO getVoUserLog()
	{
		return voUserLog;
	}

	public void setVoUserLog(UserLoginLogVO voUserLog)
	{
		this.voUserLog = voUserLog;
	}

	public String getVarUserLoginUserAgent() {
		return varUserLoginUserAgent;
	}

	public void setVarUserLoginUserAgent(String varUserLoginUserAgent) {
		this.varUserLoginUserAgent = varUserLoginUserAgent;
	}

	public List<HolidayMasterVO> getVoHolidays() {
		return voHolidays;
	}

	public void setVoHolidays(List<HolidayMasterVO> voHolidays) {
		this.voHolidays = voHolidays;
	}

	public List<MenuMappingVO> getVoMenuCntMapping() {
		return voMenuCntMapping;
	}

	public void setVoMenuCntMapping(List<MenuMappingVO> voMenuCntMapping) {
		this.voMenuCntMapping = voMenuCntMapping;
	}

	

}
