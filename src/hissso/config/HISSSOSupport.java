package hissso.config;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import hisglobal.config.HISConfig.APP_TYPE;
import hissso.ticket.TicketGrantingTicket;
import hissso.ticket.registry.HISTicketRegistry;
import hissso.validation.credentails.authentication.AuthenticationCredentials;
import hissso.validation.credentails.authorization.HISService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import vo.usermgmt.HolidayMasterVO;
import application.config.HISApplicationConfig;

public abstract class HISSSOSupport
{
	// Initializing Application HISService Object
	public static boolean initHISServiceObject(ServletContext objContext)
	{
		boolean flg = true;
		try
		{
			/* Setting Service Object */
			HISService serviceObject = new HISService();
			serviceObject.setContext(HISApplicationConfig.APPLICATION_CONTEXT);
			serviceObject.setAppType(APP_TYPE.APPLICATION);
			serviceObject.setDescription("Login, SSO");
			serviceObject.setServerURL((String) objContext.getAttribute(HISApplicationConfig.HIS_SERVICES_SERVER_URL));
			serviceObject.setServicesURL((String) objContext.getAttribute(HISApplicationConfig.HIS_SERVICES_SERVER_URL));

			objContext.setAttribute(HISApplicationConfig.HIS_SERVICE_OBJECT, serviceObject);
			// Setting Application Initial Attributes
		}
		catch (Exception e)
		{
			flg = false;
			// e.printStackTrace();
		}
		return flg;
	}

	// Getting HIS Service Object
	public static HISService getHISServiceObject(Object objContext)
	{
		HISService objService = null;
		try
		{
			if (objContext instanceof ServletContext)
			{
				objService = (HISService) ((ServletContext) objContext).getAttribute(HISApplicationConfig.HIS_SERVICE_OBJECT);
			}
			else if (objContext instanceof HttpSession)
			{
				objService = (HISService) ((HttpSession) objContext).getServletContext().getAttribute(HISApplicationConfig.HIS_SERVICE_OBJECT);
			}
			else if (objContext instanceof HttpServletRequest)
			{
				objService = (HISService) ((HttpServletRequest) objContext).getServletContext().getAttribute(HISApplicationConfig.HIS_SERVICE_OBJECT);
			}
			else if (objContext instanceof PageContext)
			{
				objService = (HISService) ((PageContext) objContext).getServletContext().getAttribute(HISApplicationConfig.HIS_SERVICE_OBJECT);
			}
			else
			{
				objService = null;
			}
		}
		catch (Exception e)
		{
			objService = null;
		}
		return objService;
	}

	// Initializing SSO Register
	public static void initializeSSORegister(ServletContext objContext)
	{
		try
		{
			HISTicketRegistry registry = (HISTicketRegistry) objContext.getAttribute(HISSSOConfig.SSO_TICKET_REGITRY);
			if (registry != null)
			{
				registry.clean();
			}
			else
			{
				registry = new HISTicketRegistry();
				objContext.setAttribute(HISSSOConfig.SSO_TICKET_REGITRY, registry);
			}
		}
		catch (Exception e)
		{
			objContext.removeAttribute(HISSSOConfig.SSO_TICKET_REGITRY);
			e.printStackTrace();
		}
	}

	// Initializing SSO Register
	public static HISTicketRegistry getSSORegister(Object objContext)
	{
		HISTicketRegistry registry = null;
		try
		{
			if (objContext instanceof ServletContext)
			{
				registry = (HISTicketRegistry) ((ServletContext) objContext).getAttribute(HISSSOConfig.SSO_TICKET_REGITRY);
			}
			else if (objContext instanceof HttpSession)
			{
				registry = (HISTicketRegistry) ((HttpSession) objContext).getServletContext().getAttribute(HISSSOConfig.SSO_TICKET_REGITRY);
			}
			else if (objContext instanceof HttpServletRequest)
			{
				registry = (HISTicketRegistry) ((HttpServletRequest) objContext).getServletContext().getAttribute(HISSSOConfig.SSO_TICKET_REGITRY);
			}
			else if (objContext instanceof PageContext)
			{
				registry = (HISTicketRegistry) ((PageContext) objContext).getServletContext().getAttribute(HISSSOConfig.SSO_TICKET_REGITRY);
			}
			else
			{
				registry = null;
			}
		}
		catch (Exception e)
		{
			registry = null;
		}
		return registry;
	}

	// Call on Session SSO TGT Expiration
	public static void onSSOTGTSessionExpiration(HttpSession objSession)
	{
		try
		{
			String strTicketId = (String) objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID);
			if (strTicketId != null)
			{
				HISTicketRegistry objRegistry = HISSSOSupport.getSSORegister(objSession);
				TicketGrantingTicket objTicketGrantingTicket = (TicketGrantingTicket) objRegistry.getTicket(strTicketId);
				if (objTicketGrantingTicket != null)
				{
					if(objTicketGrantingTicket.expire())
					{
						objRegistry.deleteTicket(objTicketGrantingTicket.getTicketId());
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// Call on Session SSO Logout
	public static void onSSOLogout(HttpSession objSession)
	{
		try
		{
			String strTicketId = (String) objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID);
			if (strTicketId != null)
			{
				HISTicketRegistry objRegistry = HISSSOSupport.getSSORegister(objSession);
				TicketGrantingTicket objTicketGrantingTicket = (TicketGrantingTicket) objRegistry.getTicket(strTicketId);
				if (objTicketGrantingTicket != null)
				{
					objTicketGrantingTicket.logout();
					objRegistry.deleteTicket(objTicketGrantingTicket.getTicketId());
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// Authenticate Request on SSO Server
	public static boolean onServerCheckAuthenticateRequest(HttpServletRequest objRequest)
	{
		boolean authenticate = true;
		try
		{
			// Getting Registry
			HISTicketRegistry registry = getSSORegister(objRequest);

			String strGrantingTicketId = "";
			// Check Session Validation
			HttpSession objSession = objRequest.getSession(false);
			if (objSession != null)
			{
				// If Session Already Exists
				// Fetch TGT Id from Session
				strGrantingTicketId = (String) objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID);
				if (strGrantingTicketId == null)
				{
					authenticate = false;
				}
				else
				{
					// Check the TGT in Registry
					TicketGrantingTicket objGrantingTicket = (TicketGrantingTicket) registry.getTicket(strGrantingTicketId);
					if (objGrantingTicket == null)
					{
						authenticate = false;
					}
					else
					{
						// Checking Valid Ticket
						AuthenticationCredentials objAuthen = (AuthenticationCredentials) objSession
								.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT);
						if (!objGrantingTicket.getAuthentication().getVarUserId().equals(objAuthen.getVarUserId()))
						{
							authenticate = false;
						}
					}
				}
			}
			else
			{
				// If session not exists
				authenticate = false;
			}
		}
		catch (Exception e)
		{
			authenticate = false;
			e.printStackTrace();
		}
		return authenticate;
	}

	// Call on Session SSO ST Expiration
	public static void onSSOSTSessionExpiration(HttpSession objSession)
	{
		try
		{
//			String strServiceTicketId = (String) objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID);
//			if (strServiceTicketId != null)
//			{
//				HISTicketRegistry objRegistry = HISSSOSupport.getSSORegister(objSession);
//				TicketGrantingTicket objTicketGrantingTicket = (TicketGrantingTicket) objRegistry.getTicket(strServiceTicketId);
//				if (objTicketGrantingTicket != null) objTicketGrantingTicket.expire();
//			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//To put the Holiday Dates in the Date Picker recognizable format in Session, Added by Singaravelan on 16-Nov-2015
	/*public static String getHolidayDates(HttpSession objSession)
	{
		StringBuffer holidays=new StringBuffer();
		int i=0;
		try{
			List<HolidayMasterVO> holMstVos=(List)objSession.getAttribute("HOLIDAYS_LIST");
			if(holMstVos.size()>0){
				for (HolidayMasterVO holidayMasterVO : holMstVos) {
					String _holDate=holidayMasterVO.getVarHolidayDate();
					if(_holDate!=null && _holDate!=""){
						DateFormat _dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Format _strformat = new SimpleDateFormat("dd MM yyyy");
						Date holidaydate=_dateformat.parse(_holDate);
						_holDate=_strformat.format(holidaydate);	
						if(i==holMstVos.size()-1)
							holidays.append("'"+_holDate+"'");
						else
							holidays.append("'"+_holDate+"'"+",");

						i++;
					}
				}
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return holidays.toString();
	}*/
}
