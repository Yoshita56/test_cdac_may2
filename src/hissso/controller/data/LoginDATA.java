package hissso.controller.data;

import hisglobal.exceptions.HISDataAccessException;

import java.util.List;
import java.util.Map;

import usermgmt.bo.UserManagementBO;
import vo.hissso.LoginVO;
import vo.usermgmt.HolidayMasterVO;
import vo.usermgmt.MenuMasterVO;
import vo.usermgmt.UserLoginLogVO;
import vo.usermgmt.UserMasterVO;

public class LoginDATA
{
	public static UserMasterVO getValidUserDetail(LoginVO voLogin) throws HISDataAccessException
	{
		UserMasterVO voUser = null;
		try
		{
//			UserMgmtBOi objBusiness = new UserMgmtBO();
//			voUser = objBusiness.getValidUserDetail(voLogin);
			UserManagementBO objBusiness = new UserManagementBO();
			voUser = objBusiness.getUserValidLoginDetail(voLogin);
		}
		catch(Exception e)
		{
			voUser = null;
			throw new HISDataAccessException(e.getMessage());
		}
		return voUser;
	}

	public static List<MenuMasterVO> getUserAuthorizationDetail(UserMasterVO voUser) throws HISDataAccessException
	{
		List<MenuMasterVO> lstMenus = null;
		try
		{
//			UserMgmtBOi objBusiness = new UserMgmtBO();
//			lstMenus = objBusiness.getUserAuthorizationDetail(voUser);
			UserManagementBO objBusiness = new UserManagementBO();
			lstMenus = objBusiness.getUserMenusList(voUser);
		}
		catch(Exception e)
		{
			lstMenus = null;
			throw new HISDataAccessException(e.getMessage());
		}
		return lstMenus;
	}

	public static Map<String, Object> logUserLoginDetail(UserLoginLogVO voLogUser) throws HISDataAccessException
	{
		Map<String, Object> mpData = null;
		try
		{
			UserManagementBO objBusiness = new UserManagementBO();
			mpData = objBusiness.logUserSuccessfulLogin(voLogUser);
		}
		catch(Exception e)
		{
			mpData = null;
			throw new HISDataAccessException(e.getMessage());
		}
		return mpData;
	}

	public static boolean logUserLogoutDetail(UserLoginLogVO voLogUser) throws HISDataAccessException
	{
		boolean flg = true;
		try
		{
//			UserMgmtBOi objBusiness = new UserMgmtBO();
//			if(!objBusiness.logUserLogoutDetail(voLogUser))
//				throw new HISDataAccessException("Can't Log User Logout Detail");

			UserManagementBO objBusiness = new UserManagementBO();
			objBusiness.logUserSuccessfulLogout(voLogUser);
		}
		catch(Exception e)
		{
			flg = false;
			throw new HISDataAccessException(e.getMessage());
		}
		return flg;
	}
	
	/**
	 * To Fetch the Holiday Details
	 * @param voUser_p
	 * @return HolidayMasterVO Array
	 * @author Singaravelan 16-Nov-2015
	 */
	public static List<HolidayMasterVO> getHolidayList(UserMasterVO voUser) throws HISDataAccessException
	{
		List<HolidayMasterVO> lstHolidays = null;
		try
		{
			UserManagementBO objBusiness = new UserManagementBO();
			lstHolidays = objBusiness.getHolidayList(voUser);
		}
		catch(Exception e)
		{
			lstHolidays = null;
			throw new HISDataAccessException(e.getMessage());
		}
		return lstHolidays;
	}
}
