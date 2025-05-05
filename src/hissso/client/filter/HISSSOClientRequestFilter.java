package hissso.client.filter;

//import java.io.File;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/***************************Start of Program Header ****************************
## Copyright Information				: C-DAC, Noida  
## Project Name							: Generation 5, HIS
## Name of Developer		 			: Pragya Sharma
## Module Name							: HIS Single Sign On and Web Security 
## Process/Database Object Name			: HISSSOClientRequestFilter
## Purpose								: HIS SSO Client Request Filter
## Date of Creation						:  
## Modification Log						:				
##		Modify Date				: 2016.16.05 
##		Reason	(CR/PRS)		: Session Time out Issue  
##		Modify By				: Pragya Sharma
**************************End of program*****************************/


import hisglobal.config.HISConfig;
import hisglobal.vo.HospitalMstVO;
import hisglobal.vo.UserVO;
import hissso.config.HISSSOClientConfig;
import hissso.config.HISSSOConfig;
import hissso.config.HISSSOSupport;
import hissso.services.HISSSOServiceCLN;
import hissso.ticket.HISServiceGrantTicket;
import hissso.ticket.HISServiceTicket;
import hissso.ticket.registry.HISTicketRegistry;
import hissso.validation.credentails.authorization.HISService;
//import application.filters.RequestWrapper;
//import application.filters.UploadMultipartRequestWrapper;
import vo.usermgmt.HospitalMasterVO;
import vo.usermgmt.UserMasterVO;

public class HISSSOClientRequestFilter implements Filter
{
	// private FilterConfig objFilterConfig;

	public void init(FilterConfig objFilterConfig)
	{
		// this.objFilterConfig = objFilterConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
	//	System.out.println("INVMGM INSIDE HISSSOClientRequestFilter");
		HttpServletRequest objRequest = (HttpServletRequest) request;
		HttpServletResponse objResponse = (HttpServletResponse) response;
		boolean authenticate = false, authenticatioRequired = true;
		HISServiceTicket objHISServiceTicket = null;
		boolean isMultiPart = ServletFileUpload.isMultipartContent((HttpServletRequest) request);
		
		//System.out.println("isMultiPart"+isMultiPart);
		try
		{
			String strURI = objRequest.getRequestURI();
		//	System.out.println("INVMGM URI HISSSOClientRequestFilter "+strURI);
			// Skipping URLs that can be accessed without Login into AHIMSG5 like strURI.endsWith(".js") || strURI.endsWith(".css") ||
			//SKIP URL RESTFUL FOR PSS WEB SERVICE http://10.226.30.212:8380/INVMGM/services/restful/hisDailyPatientList/3
			
			//System.out.println("INVMGM >> Referer  >> "+objRequest.getHeader("Referer"));
			
			if(!strURI.contains("rest") && !(objRequest.getHeader("Referer") != null && objRequest.getHeader("Referer").trim().length() > 0))
            {
                RequestDispatcher rd = null;
                rd = objRequest.getRequestDispatcher(HISSSOConfig.SSO_AUTHENTICATION_ERROR_PAGE_URL);
                rd.forward(objRequest, objResponse);
               
                return;
            }
			if (strURI.contains(HISSSOClientConfig.SSO_ST_SERVICE_URL) || strURI.contains("rest"))
			{
				// Forward as-it-is
				//chain.doFilter(new RequestWrapper((HttpServletRequest) request), response);
				chain.doFilter(request, response);
			}
			else if(strURI.endsWith(".js") || strURI.endsWith(".css")||strURI.endsWith(".gif")||strURI.endsWith(".png")||strURI.endsWith(".jpg")||strURI.endsWith(".jpeg"))
			{
				// Forward as-it-is
				//chain.doFilter(new RequestWrapper((HttpServletRequest) request), response);
				chain.doFilter(request, response);
			}
			else
			{
				// Fetch Module ST Registry
				HISTicketRegistry registry = HISSSOSupport.getSSORegister(objRequest);

				String strServiceTicketId = "";
				
				// Check Session Validation
				HttpSession session = objRequest.getSession(false);
				
				if (session != null)
				{
				//	System.out.println("INVMGM SESSION HISSSOClientRequestFilter "+session.getId());
					// If Session Already Exists
					// Fetch ST Id from Session
					strServiceTicketId = (String) session.getAttribute(HISSSOConfig.LOGGEDIN_USER_SERVICE_TICKET_ID);
					//System.out.println("HIS-SSO-CLN:: Service Ticket ID Found in Session-"+ strServiceTicketId);

					// Check the same in Registry
					if (strServiceTicketId == null || registry.getTicket(strServiceTicketId) == null)
					{
						authenticate = false;
						authenticatioRequired = true;
					}
					else
					{
						objHISServiceTicket = (HISServiceTicket) registry.getTicket(strServiceTicketId);
						
						String reqGrantingTicketId = (String) objRequest.getParameter(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID_VAR);
						//System.out.println("HIS-SSO-CLN:: Service Ticket Found in Session with ST-"+ strServiceTicketId + " TGT-" + reqGrantingTicketId);						

						if(reqGrantingTicketId!=null && !reqGrantingTicketId.equals("") && !reqGrantingTicketId.equals(objHISServiceTicket.getGrantingTicketId()))
						{
							authenticate = false;
							authenticatioRequired = true;
						}
						else
						{
							// If get ticket then update ticket and go ahead
							// Authenticate
							authenticate = true;
							authenticatioRequired = false;
	
							// if expired
							if (objHISServiceTicket.isExpired())
							{
								// create new session
								objRequest.getSession().invalidate();
								session = objRequest.getSession();
							//	System.out.println("INVMGM SESSION AFTER EXPIRED HISSSOClientRequestFilter "+session.getId());
	
								// Set TGT inSession
								session.setAttribute(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID, objHISServiceTicket.getGrantingTicketId());
	
								// associate with ST
								objHISServiceTicket.associateServiceAtClient(session);
								
								// Update New Session into HIS Registry
								registry.deleteTicket(objHISServiceTicket.getTicketId());
								
								//registry.addTicket(objHISServiceTicket);
								registry.addTicket(objHISServiceTicket  , objRequest.getHeader("User-Agent").toLowerCase());
								
								
							}
						}
					}
				}
				else
				{
					// If session not exists
					// Get TGT ID from Request
					// If found check from SSO

					String grantingTicketId = (String) objRequest.getParameter(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID_VAR);
					//System.out.println("HIS-SSO-CLN:: Session is NUll Ticket Found in Request TGT-" + grantingTicketId);

					if (grantingTicketId == null)
					{
						authenticate = false;
						authenticatioRequired = false;
					}
					else
					{
						authenticate = false;
						authenticatioRequired = true;
					}
				}

				if (authenticatioRequired)
				{
					String grantingTicketId = (String) objRequest.getParameter(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID_VAR);

					HISService objHISService = HISSSOSupport.getHISServiceObject(objRequest);

					// REquest SSO Service for Valid ST
					HISServiceGrantTicket objGrantTicket = authenticateAccess(grantingTicketId, objHISService, objRequest);
					
					if (objGrantTicket != null)
					{
						//System.out.println("HIS-SSO-CLN:: TGT-" + grantingTicketId+ " Registered Service-" + objHISService.getContext() +" ST-"+objGrantTicket.getTicketId());
						authenticate = true;

						// Check Is User Already have a Service based on UserId, IP Address, Session ID, User-Agent
						//HISServiceTicket objST = (HISServiceTicket) registry.getTicketBasedOn(objGrantTicket.getAuthentication().getVarUserId(), 
								//objGrantTicket.getAuthentication().getVoUser().getVarIPAddress(), objRequest.getSession().getId(), objRequest.getHeader("User-Agent"));
						HISServiceTicket objST = (HISServiceTicket) registry.getTicketBasedOn(objGrantTicket.getAuthentication().getVarUserId(), objGrantTicket.getAuthentication().getVoUser().getVarIPAddress(),objRequest.getSession().getId());
						
						// If ticket exist, logout and delete the old ticket
						if (objST != null)
						{
							objST.logout();
							registry.deleteTicket(objST.getTicketId());
						}

						// Setting Session Credentials, New Session, Session Expiration,
						// Creating New Session
						objRequest.getSession().invalidate();
						HttpSession objSession = objRequest.getSession();

						//System.out.println("INVMGM SESSION AFTER EXPIRED AGAIN HISSSOClientRequestFilter "+session.getId());
						//System.out.println("INVMGM SESSION AFTER EXPIRED AGAIN HISSSOClientRequestFilter "+objSession.getId());
						// Set TGT inSession
						objSession.setAttribute(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID, grantingTicketId);

						// Set Session Detail in ST
						objHISServiceTicket = new HISServiceTicket(objGrantTicket, objSession);

						// Register ST in Registry
						//registry.addTicket(objHISServiceTicket);
						registry.addTicket(objHISServiceTicket  , objRequest.getHeader("User-Agent").toLowerCase());
						
						objSession.setAttribute("User-Agent",  objRequest.getHeader("User-Agent").toLowerCase());
						//registry.addTicket(objHISServiceTicket,objSession);

						// Set Credentials in Session
						setCredentialsInSession(objSession, objHISServiceTicket);
					}
					else
					{
						// If User Not Authenticated by WS, then not valid
						authenticate = false;
					}
				}

				if (authenticate)
				{
					// Check for URI Authorization here If not set -------
					if (objHISServiceTicket.getAuthorization().isAuthorizedURL(strURI))
					{
						
						
						if(strURI.equalsIgnoreCase("/HISRegistration/registration/transactions/attachUploadFile.action"))
							chain.doFilter(request, response);
						else if(isMultiPart)
						{
							/*DiskFileItemFactory factory = new DiskFileItemFactory();
							  factory.setSizeThreshold(1024); 
						        factory.setRepository(new File("/")); 
							
							ServletFileUpload upload = new ServletFileUpload(factory);
							chain.doFilter(new UploadMultipartRequestWrapper((HttpServletRequest) request,upload),response);*/
							
							chain.doFilter(request, response);
						}
						else
						//chain.doFilter(new RequestWrapper((HttpServletRequest) request), response);
						chain.doFilter(request, response);
						
					}
					
					else
					{
						RequestDispatcher rd = null;
						rd = objRequest.getRequestDispatcher(HISSSOConfig.SSO_AUTHORIZATION_ERROR_PAGE_URL);
						rd.forward(objRequest, objResponse);
					}
				}
				else
				{
					RequestDispatcher rd = null;
					rd = objRequest.getRequestDispatcher(HISSSOConfig.SSO_AUTHENTICATION_ERROR_PAGE_URL);
					rd.forward(objRequest, objResponse);
				}
			}
		}
		catch (IllegalStateException e)
		{
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher(HISSSOConfig.SSO_ILLEGAL_ACTIVITY_ERROR_PAGE_URL);
		rd.forward(request, response);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			RequestDispatcher rd = null;
			rd = objRequest.getRequestDispatcher(HISSSOConfig.SSO_UNKNOWN_ERROR_PAGE_URL);
			rd.forward(objRequest, objResponse);
		}
	//	System.out.println("INVMGM EXIT HISSSOClientRequestFilter");
	}

	public void destroy()
	{

	}

	// Authenticate User By Calling Authenticate SSO Service
	/*private HISServiceGrantTicket authenticateAccess(String strGrantingTicketId_p, HISService objService_p)
	{
		HISServiceGrantTicket objGrantTicket = null;
		try
		{
			HISSSOServiceCLN objHISSSOServiceClient = new HISSSOServiceCLN();
			objGrantTicket = objHISSSOServiceClient.authenticate(strGrantingTicketId_p, objService_p);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			objGrantTicket = null;
		}
		return objGrantTicket;
	}*/
	
	// Authenticate User By Calling Authenticate SSO Service
		private HISServiceGrantTicket authenticateAccess(String strGrantingTicketId_p, HISService objService_p , HttpServletRequest request)
		{
			HISServiceGrantTicket objGrantTicket = null;
			try
			{
				HISSSOServiceCLN objHISSSOServiceClient = new HISSSOServiceCLN();
				objGrantTicket = objHISSSOServiceClient.authenticate(strGrantingTicketId_p, objService_p , request);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				objGrantTicket = null;
			}
			return objGrantTicket;
		}
	
	// Authenticate User By Calling Authenticate SSO Service
		/*private HISServiceGrantTicket authenticateAccess(String strGrantingTicketId_p, HISService objService_p, String userAgent)
		{
			HISServiceGrantTicket objGrantTicket = null;
			try
			{
				HISSSOServiceCLN objHISSSOServiceClient = new HISSSOServiceCLN();
				objGrantTicket = objHISSSOServiceClient.authenticate(strGrantingTicketId_p, objService_p,  userAgent);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				objGrantTicket = null;
			}
			return objGrantTicket;
		}*/

	// Setting Credential in Session
	private boolean setCredentialsInSession(HttpSession objSession_p, HISServiceTicket objST_p)
	{
		boolean flg = true;
		try
		{
			// User VO
			UserMasterVO voUser = objST_p.getAuthentication().getVoUser();
			UserVO voGlobalUser = new UserVO();
			populateData(voGlobalUser, voUser);
			objSession_p.setAttribute(HISConfig.USER_VO, voGlobalUser);
			objSession_p.setAttribute("SEATID", voGlobalUser.getUserId());
			objSession_p.setAttribute("IP_ADDR", voGlobalUser.getIpAddress());
			//Added by S. SingaraVelan to keep Hospital's Holiday LIst in Session
			objSession_p.setAttribute("HOLIDAYS_LIST", objST_p.getAuthentication().getVoHolidays());
			//String _holDates=HISSSOSupport.getHolidayDates(objSession_p);
			//System.out.println("Holidays ::: "+_holDates);
			//objSession_p.setAttribute("HOLIDAY_DATES", _holDates);

			// Hospital VO
			HospitalMasterVO voHospital = objST_p.getAuthentication().getVoHostpital();
			HospitalMstVO voGlobalHospital = new HospitalMstVO();
			populateData(voGlobalHospital, voHospital);
			objSession_p.setAttribute(HISConfig.HOSPITAL_VO, voGlobalHospital);
			objSession_p.setAttribute("HOSPITAL_CODE", voGlobalHospital.getHospitalCode());
			objSession_p.setAttribute(HISConfig.SYSDATEOBJECT, objST_p.getAuthentication().getVoUserLog().getVarUserLoginDate());
			//System.out.println("-------date----" + objST_p.getAuthentication().getVoUserLog().getVarUserLoginDate());
			//objSession_p.setAttribute("MENU_CNT_MAPPING", objST_p.getAuthentication().getVoMenuCntMapping());
		}
		catch (Exception ee)
		{
			flg = false;
		}
		return flg;
	}

	private void populateData(Object objTarget, Object objSource)
	{
		if (objSource instanceof UserMasterVO && objTarget instanceof UserVO)
		{
			UserMasterVO objSrc = (UserMasterVO) objSource;
			UserVO objTar = (UserVO) objTarget;
			objTar.setUserId(objSrc.getVarUserId());			// User ID
			objTar.setSeatId(objSrc.getVarUserId());			// User ID
			objTar.setUserSeatId(objSrc.getVarUserSeatId());	// Seat ID
			objTar.setHospitalCode(objSrc.getVarHospitalCode());
			objTar.setIpAddress(objSrc.getVarIPAddress());
			objTar.setUserEmpID(objSrc.getVarEmpNo());
			objTar.setUserLevel(objSrc.getVarUserLevel());
			objTar.setUsrName(objSrc.getVarUsrName());
			objTar.setUserName(objSrc.getVarUserName());		// Login User Name
			objTar.setDesignation(objSrc.getVarDesignation());
			objTar.setDistrictCode(objSrc.getVarDistrictId());
			objTar.setEmailId(objSrc.getVarEmailId());
			objTar.setMobileNo(objSrc.getVarMobileNumber());
			objTar.setDistrictName(objSrc.getVarDistrictName());
			
			// Other User Details
			objTar.setUserType(objSrc.getVarUserTypeId());
			objTar.setSwapcardNo(objSrc.getVarSwapcardNumber());
			objTar.setCheckBackDateDayEndFlag(objSrc.getCheckBackDateDayEndFlag());
			
			objTar.setSmsServiceFlag(objSrc.getSmsServiceFlag());
			objTar.setSmsWebServiceURL(objSrc.getSmsWebServiceURL());
			objTar.setSmsUserName(objSrc.getSmsUserName());
			objTar.setSmsPassword(objSrc.getSmsPassword());
			objTar.setSmsSenderId(objSrc.getSmsSenderId());
			objTar.setSmsSecureKey(objSrc.getSmsSecureKey());
			objTar.setSslVer(objSrc.getSslVer());
			
			objTar.setMailServiceFlag(objSrc.getMailServiceFlag());
			objTar.setSmtpMailServerURL(objSrc.getSmtpMailServerURL());
			objTar.setSmtpHost(objSrc.getSmtpHost());
			objTar.setSmtpPort(objSrc.getSmtpPort());
			objTar.setMailUserId(objSrc.getMailUserId());
			objTar.setMailPassword(objSrc.getMailPassword());
			
		}
		else if (objSource instanceof HospitalMasterVO && objTarget instanceof HospitalMstVO)
		{
			HospitalMasterVO objSrc = (HospitalMasterVO) objSource;
			HospitalMstVO objTar = (HospitalMstVO) objTarget;
			objTar.setHospitalCode(objSrc.getVarHospitalCode());
			objTar.setHospitalName(objSrc.getVarHospitalName());
			objTar.setHospitalShortName(objSrc.getVarHospitalShortName());

			objTar.setAddress1(objSrc.getVarHospitalAddress1());
			objTar.setAddress2(objSrc.getVarHospitalAddress2());
			objTar.setCity(objSrc.getVarCity());
			objTar.setEmail(objSrc.getVarEmail());
			objTar.setPhone(objSrc.getVarPhone());
			objTar.setFax(objSrc.getVarFax());
			objTar.setDistrictCode(objSrc.getVarDistrictId());
			objTar.setState(objSrc.getVarStateCode());
			objTar.setPinCode(objSrc.getVarPinCode());
			objTar.setDistrictName(objSrc.getVarDistrictName());
			objTar.setStateName(objSrc.getVarStateName());

			objTar.setLanguageCode(objSrc.getVarLanguageCode());
			objTar.setLocalLangCode(objSrc.getVarLocalLangCode());
			objTar.setLanguageName(objSrc.getVarLanguageName());
			objTar.setLocalLangName(objSrc.getVarLocalLangName());

			// Other Hospital Details
			objTar.setContactPerson(objSrc.getVarContactPerson());
			objTar.setHospitalTypeCode(objSrc.getVarHospitalType());
			objTar.setHospitalTypeName(objSrc.getVarHospitalTypeName());
			objTar.setBedCapacity(objSrc.getVarBedCapacity());
			objTar.setBusRouteNo(objSrc.getVarBusRouteNo());
			objTar.setHospitalCategory(objSrc.getVarHospitalCategory());
			objTar.setIsAssociated(objSrc.getVarIsAssociated());
			objTar.setLunchTimings(objSrc.getVarLunchBreak());
			objTar.setOrgType(objSrc.getVarOrganizationType());
			objTar.setRemarks(objSrc.getVarRemarks());
			objTar.setSaturdayTimings(objSrc.getVarSaturdayTimings());
			objTar.setWeekdayTimings(objSrc.getVarWeekdaysTimings());
			objTar.setPanNo(objSrc.getVarPANNo());
			objTar.setTanNo(objSrc.getVarTANNo());
			objTar.setUserLiscenceAllowed(objSrc.getVarUserLicenceAllowed());
			objTar.setLicenseCode(objSrc.getLicenseCode());
			objTar.setLicenseExp(objSrc.getLicenseExp());
			objTar.setLattitude(objSrc.getLattitude());
			objTar.setLongitude(objSrc.getLongitude());
			objTar.setWebSite(objSrc.getWebSite());
		}
	}

}
