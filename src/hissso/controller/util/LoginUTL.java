package hissso.controller.util;

/***************************Start of Program Header ****************************
## Copyright Information				: C-DAC, Noida  
## Project Name							: Generation 5, HIS
## Name of Developer		 			: Pragya Sharma
## Module Name							: HIS Single Sign On and Web Security 
## Process/Database Object Name			: LoginUTL
## Purpose								: 
## Date of Creation						:  
## Modification Log						:				
##		Modify Date				: 2016.16.05 
##		Reason	(CR/PRS)		: Session Time out Issue  
##		Modify By				: Pragya Sharma
**************************End of program*****************************/

import hisglobal.config.HISConfig;
import hisglobal.exceptions.old.HisException;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.helper.DateHelperMethods;
import hislogin.config.HISLoginConfig;
import hissso.config.HISSSOConfig;
import hissso.config.HISSSOServerConfig;
import hissso.config.HISSSOSupport;
import hissso.controller.actionsupport.LoginSUP;
import hissso.controller.data.LoginDATA;
import hissso.security.SecureHashAlgorithm;
import hissso.ticket.HISTicketGrantingTicket;
import hissso.ticket.TicketGrantingTicket;
import hissso.ticket.expiration.HISExpiration;
import hissso.ticket.expiration.TicketGrantingTicketExpiration;
import hissso.ticket.registry.HISTicketRegistry;
import hissso.validation.credentails.authentication.AuthenticationCredentials;
import hissso.validation.credentails.authorization.AuthorizationCredentials;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.WebRowSet;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.util.TokenHelper;

import com.opensymphony.xwork2.ActionContext;

import usermgmt.config.UserManagementConfig;
import vo.hissso.LoginVO;
import vo.usermgmt.HolidayMasterVO;
import vo.usermgmt.MenuMasterVO;
import vo.usermgmt.UserLoginLogVO;
import vo.usermgmt.UserMasterVO;

public class LoginUTL
{
	public static boolean setInititals(LoginSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse)
	{
		boolean flg = true;
		HttpSession objSession = null;
		try
		{
			objSession = objRequest.getSession();
			// Change Session Salt
			String randomSessionSalt = SecureHashAlgorithm.getRandomSalt(HISSSOServerConfig.LOGIN_SESSION_SALT_BYTE_SIZE);
			objSession.setAttribute(HISSSOServerConfig.LOGIN_SESSION_SALT, randomSessionSalt);

			// Clearing Form Data
			objActionSupport.clear();
			dashBoardData(objRequest, objResponse);
			dashBoardData1(objRequest, objResponse);
			circulardata(objRequest, objResponse);
		}
		catch (IllegalStateException e)
		{
			try
			{
				flg = true;
				// Change Session Salt
				String randomSessionSalt = SecureHashAlgorithm.getRandomSalt(HISSSOServerConfig.LOGIN_SESSION_SALT_BYTE_SIZE);
				objRequest.getSession().setAttribute(HISSSOServerConfig.LOGIN_SESSION_SALT, randomSessionSalt);
			}
			catch (Exception ee)
			{
				flg = false;
				// Log or Populate Error Here
				// Set Error Message
				//objActionSupport.addActionError("Unknown Problem Occured!");
				e.printStackTrace();// Hide This for Production
			}
		}
		catch (Exception e)
		{
			flg = false;
			// Log or Populate Error Here
			// Set Error Message
			//objActionSupport.addActionError("Unknown Problem Occured!");
			e.printStackTrace();// Hide This for Production
		}
		return flg;
	}

	public static boolean loginUser(LoginSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse)
	{
		boolean flg = true;
		HttpSession objSession = null;
		try
		{
			objSession = objRequest.getSession();
			// Check User Authentication
			// Fetch/Set User Login Credentials
			String strSessionSalt = (String) objSession.getAttribute(HISSSOServerConfig.LOGIN_SESSION_SALT);
			
			String downloadTokenName = TokenHelper.getTokenName();
		    String downloadToken = TokenHelper.getToken(downloadTokenName);
		    
			LoginVO voLogin = new LoginVO();
			BeanUtils.copyProperties(voLogin, objActionSupport);
			voLogin.setVarLoginSessionSalt(strSessionSalt);
			voLogin.setVarIPAddress(objRequest.getRemoteAddr());

			
			/*
			 * System.out.println("HIS-Login::Login objRequest.getHeader(X-Forwarded-For)"
			 * +objRequest.getHeader("X-Forwarded-For"));
			 * System.out.println("HIS-Login::Login objRequest.getHeader(Proxy-Client-IP)"
			 * +objRequest.getHeader("Proxy-Client-IP")); System.out.
			 * println("HIS-Login::Login objRequest.getHeader(WL-Proxy-Client-IP)"
			 * +objRequest.getHeader("WL-Proxy-Client-IP")); System.out.
			 * println("HIS-Login::Login objRequest.getHeader(HTTP_X_FORWARDED_FOR)"
			 * +objRequest.getHeader("HTTP_X_FORWARDED_FOR"));
			 * System.out.println("HIS-Login::Login objRequest.getHeader(HTTP_X_FORWARDED)"
			 * +objRequest.getHeader("HTTP_X_FORWARDED")); System.out.
			 * println("HIS-Login::Login objRequest.getHeader(HTTP_X_CLUSTER_CLIENT_IP)"
			 * +objRequest.getHeader("HTTP_X_CLUSTER_CLIENT_IP"));
			 * System.out.println("HIS-Login::Login objRequest.getHeader(HTTP_CLIENT_IP)"
			 * +objRequest.getHeader("HTTP_CLIENT_IP")); System.out.
			 * println("HIS-Login::Login objRequest.getHeader(HTTP_FORWARDED_FOR)"
			 * +objRequest.getHeader("HTTP_FORWARDED_FOR"));
			 * System.out.println("HIS-Login::Login objRequest.getHeader(HTTP_FORWARDED)"
			 * +objRequest.getHeader("HTTP_FORWARDED"));
			 * System.out.println("HIS-Login::Login objRequest.getHeader(HTTP_VIA)"
			 * +objRequest.getHeader("HTTP_VIA"));
			 * System.out.println("HIS-Login::Login objRequest.getHeader(REMOTE_ADDR)"
			 * +objRequest.getHeader("REMOTE_ADDR"));
			 * System.out.println("HIS-Login::Login objRequest.getRemoteAddr"+objRequest.
			 * getRemoteAddr());
			 * System.out.println("HIS-Login::Login objRequest.getHeader(User-Agent)"
			 * +objRequest.getHeader("User-Agent"));
			 * System.out.println("HIS-Login::Login objRequest.getLocalAddr())"+objRequest.
			 * getLocalAddr());
			 */
			//System.out.println("HIS-Login::Login objRequest.getHeaderNames())"+objRequest.getHeaderNames());
			
			// Checking Valid User Detail from DB
			// Fetching/Setting User Specific Details (User/Hospital Data,
			// Custom Desk, First Process etc.)
			UserMasterVO voUser = LoginDATA.getValidUserDetail(voLogin);

			if (voUser == null || voUser.getVarLoggedIn().equals(HISConfig.NO))
			{
				// If userVO is null, means no valid user found against User Credentials.
				flg = false;

				// Setting Error Message
				if(voUser!=null)
					objActionSupport.addActionError(voUser.getVarLoginMessage());
				else
					objActionSupport.addActionError("Invalid User Name/Password!");
			}
			else
			{
				// If Valid user
				flg = true;
				// If required... Taking Action based User Previous Login, Already Loin somewhere else 
				// Details (Future)....... -----
					// Already Login Some where else ??????? 

				// Get TGT Register
				HISTicketRegistry registry = HISSSOSupport.getSSORegister(objRequest);
				
				// Check Is User Already have a Ticket based on UserId, IP Address, Session ID, User-Agent
				HISTicketGrantingTicket objTGT  = (HISTicketGrantingTicket) registry.getTicketBasedOn(voUser.getVarUserId(), voUser.getVarIPAddress(), 
						objRequest.getSession().getId());
				
				// If ticket exist, logout and delete the old ticket 
				if(objTGT!=null)
				{
					objTGT.logout();
					registry.deleteTicket(objTGT.getTicketId());
					// DB Logout Entry
					UserLoginLogVO voUserLog = objTGT.getAuthentication().getVoUserLog();
					voUserLog.setVarUserLogoutDate(DateHelperMethods.getDateString(System.currentTimeMillis()));
					LoginDATA.logUserLogoutDetail(voUserLog);
					System.out.println("HIS-Login-Log::User -"+voUserLog.getVarUserId()+"Login DateTime-"+voUserLog.getVarUserLoginDate()
							+"Logout DateTime-"+voUserLog.getVarUserLogoutDate());
				}

				
				// Setting Session Credentials, New Session, Session Expiration,
					// Creating New Session
				//Commented by Garima for introducing session token in login page
				//objRequest.getSession().invalidate();
				//objSession = objRequest.getSession();
				
				//Added by Garima for introducing session token in login page--Start
				SessionMap session = (SessionMap) ActionContext.getContext().getSession();

				//invalidate
				session.invalidate();

				//renew servlet session
				session.put("renewServletSession", null);
				session.remove("renewServletSession");

				//populate the struts session
				session.entrySet();
				
				objSession = objRequest.getSession();
				
				//Added by Garima for introducing session token in login page--End
				
					// Setting Key for blocking multiple tab
				objSession.setAttribute(HISSSOServerConfig.LOGIN_TAB_KEY, strSessionSalt);
				//Added by Garima for introducing session token in login page--Start
				TokenHelper.setSessionToken(downloadTokenName, downloadToken);
				//Added by Garima for introducing session token in login page--End
				//String strSessionId = objSession.getId();

				// Preparing Authentication Credentials Object
				AuthenticationCredentials objAuthentictaion = new AuthenticationCredentials();
				// User DB Details
				voUser.setVarIPAddress(objRequest.getRemoteAddr());
				BeanUtils.copyProperties(objAuthentictaion, voUser);
				// User Browser Detail
				objAuthentictaion.setVarAccessURL(objRequest.getRequestURL().toString());
				objAuthentictaion.setVarUserLoginUserAgent(objRequest.getHeader("User-Agent"));
				// User Session Details
				//objAuthentictaion.setVarUserLoginSessionId(strSessionId);
				
				//Holiday List, Added by Singaravelan on 16-Nov-2015
				List<HolidayMasterVO> holidayList =new ArrayList<HolidayMasterVO>();
				holidayList=LoginDATA.getHolidayList(voUser);
				// VOs
				objAuthentictaion.setVoUser(voUser);
				objAuthentictaion.setVoHostpital(voUser.getVoHospital());
				objAuthentictaion.setVoHolidays(holidayList);
				
				// Preparing Expiration Object
				HISExpiration objExpiration = new TicketGrantingTicketExpiration(objSession);
				
				// Create TGT
				objTGT = new HISTicketGrantingTicket(objAuthentictaion, objExpiration);
				String grantingTicketId = objTGT.getTicketId();

				// Setting User Login Detail into DB
				UserLoginLogVO voUserLog = new UserLoginLogVO();
				BeanUtils.copyProperties(voUserLog, voUser);
				voUserLog.setVarSeatId(voUser.getVarUserSeatId());
				voUserLog.setVarIPAddress(objRequest.getRemoteAddr());
				voUserLog.setVarUserLoginDate(DateHelperMethods.getDateString(objTGT.getCreationTime()));
				objAuthentictaion.setVoUserLog(voUserLog);
				voUser.setVarIPAddress(voUserLog.getVarIPAddress());

				// Log User Login Detail
					// Log User Detail
					// Fetch menu List, Favorite List
					// If Already Login somewhere else take action here means update DB etc.
				Map<String, Object> mpData = LoginDATA.logUserLoginDetail(voUserLog);
				System.out.println("HIS-Login-Log::User -"+voUserLog.getVarUserId()+"Login DateTime-"+voUserLog.getVarUserLoginDate());
				
				// Get and Set User Authorization Detail
				// Fetching/Setting User authorization Details and Menu List
				List<MenuMasterVO> lstMenus = (List<MenuMasterVO>) mpData.get(UserManagementConfig.KEY_USER_MENU_LIST); //LoginDATA.getUserAuthorizationDetail(voUser);
				List<MenuMasterVO> lstAllowedMenuURLs = (List<MenuMasterVO>) mpData.get(UserManagementConfig.KEY_USER_ALLOWED_MENU_LIST);
				AuthorizationCredentials objAuthorization = new AuthorizationCredentials(lstMenus,lstAllowedMenuURLs);

								
				
				voUser.setCheckBackDateDayEndFlag((String) mpData.get(UserManagementConfig.KEY_CASH_COLLECTION_ALLOWED));
				objAuthentictaion.setVoUser(voUser);
				
				objTGT.setAuthorization(objAuthorization);

				// Register TGT
				//registry.addTicket(objTGT);	
				registry.addTicket(objTGT ,  objRequest.getHeader("User-Agent").toLowerCase());		
				
				// Setting USER VO, HOSPITAL VO, USER CUSTOM DETAIL, SYSDATE in Session, Login IP Address
				setLoginDetailsInSession(objRequest.getSession(), objTGT, mpData);
				
	     		// Setting User TGT Id into the Session(Already) and request
				objActionSupport.setVarSSOTicketGrantingTicket(grantingTicketId);
			}
		}
		catch (NullPointerException e)
		{
			flg = false;
			// Log or Populate Error Here
			// Set Error Message
			//objActionSupport.addActionError("Unknown Problem Occured While Trying to Login!");
			e.printStackTrace();// Hide This for Production
		}
		catch (Exception e)
		{
			flg = false;
			// Log or Populate Error Here
			// Set Error Message
			objActionSupport.addActionError("Unknown Problem Occured While Trying to Login!");
			e.printStackTrace();// Hide This for Production
		}
		return flg;
	}

	public static boolean logoutUser(LoginSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse)
	{
		boolean flg = true;
		HttpSession objSession = null;
		try
		{
			objSession = objRequest.getSession();
			if (objActionSupport.getVarSSOTicketGrantingTicket() == null || objActionSupport.getVarSSOTicketGrantingTicket().equals(""))
				objActionSupport.setVarSSOTicketGrantingTicket((String) objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID));

			// Fetching TGT from Registry
			HISTicketRegistry registry = HISSSOSupport.getSSORegister(objRequest);
			TicketGrantingTicket objTGT = (TicketGrantingTicket) registry.getTicket(objActionSupport.getVarSSOTicketGrantingTicket());
			

			if(objTGT!=null)
			{
				// Logout the TGT and all related ST
				objTGT.logout();
	
				// Updating Logout Status from DB
				UserLoginLogVO voUserLog = objTGT.getAuthentication().getVoUserLog();
				voUserLog.setVarUserLogoutDate(DateHelperMethods.getDateString(System.currentTimeMillis()));
				LoginDATA.logUserLogoutDetail(voUserLog);
	
				// Delete Ticket from Registry
				registry.deleteTicket(objActionSupport.getVarSSOTicketGrantingTicket());
			}
			// Removing Token And User Details form Request
			objActionSupport.setVarSSOTicketGrantingTicket(null);

			// Redirecting to User Login Page
		}
		catch (Exception e)
		{
			flg = false;
			// Log or Populate Error Here
			// Set Error Message
			//objActionSupport.addActionError("Unknown Problem Occured While Trying to Logout!");
			e.printStackTrace();// Hide This for Production
		}
		return flg;
	}
	
	public static boolean setEssentialforFirstLogin(LoginSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse)
	{
		boolean flg = true;
		//HttpSession objSession = null;
		try
		{
			//objSession = objRequest.getSession();
			// Setting First Login Info
		}
		catch (IllegalStateException e)
		{
			try
			{
				flg = true;
				// Change Session Salt
				String randomSessionSalt = SecureHashAlgorithm.getRandomSalt(HISSSOServerConfig.LOGIN_SESSION_SALT_BYTE_SIZE);
				objRequest.getSession().setAttribute(HISSSOServerConfig.LOGIN_SESSION_SALT, randomSessionSalt);
			}
			catch (Exception ee)
			{
				flg = false;
				// Log or Populate Error Here
				// Set Error Message
				//objActionSupport.addActionError("Unknown Problem Occured!");
				e.printStackTrace();// Hide This for Production
			}
		}
		catch (Exception e)
		{
			flg = false;
			// Log or Populate Error Here
			// Set Error Message
			//objActionSupport.addActionError("Unknown Problem Occured!");
			e.printStackTrace();// Hide This for Production
		}
		return flg;
	}

//	private static boolean generateTGT()
//	{
//		boolean flg = true;
//		
//		return flg;
//	}

	private static boolean setLoginDetailsInSession(HttpSession objSession_p, HISTicketGrantingTicket objTGT_p, Map<String,Object> mapData_p)
	{
		boolean flg = true;
		try
		{
			UserMasterVO voSysDate = (UserMasterVO) mapData_p.get(UserManagementConfig.KEY_SYSTEM_DATETIME);

			// User VO
			objSession_p.setAttribute(HISSSOConfig.LOGGEDIN_USER_VO, objTGT_p.getAuthentication().getVoUser());
			// Hospital VO
			objSession_p.setAttribute(HISSSOConfig.LOGGEDIN_HOSPITALVO, objTGT_p.getAuthentication().getVoHostpital());
			// Current Year
			objSession_p.setAttribute(HISSSOConfig.LOGGEDIN_CURRENT_YEAR, voSysDate.getVarCurrentYear());
			objSession_p.setAttribute(HISSSOConfig.LOGGEDIN_CURRENT_MONTH, voSysDate.getVarCurrentMonth());
			
			String strDate = voSysDate.getVarCurrentDate() + "-" + voSysDate.getVarCurrentMonth() + "-" + voSysDate.getVarCurrentYear()
					+ " " + voSysDate.getVarCurrentHour() + ":" + voSysDate.getVarCurrentMinute() + ":" + voSysDate.getVarCurrentSecond(); 
			//dd-MMM-yyyy HH:mm:ss
			Date objSysDate = DateHelperMethods.getDateObject(strDate);

			objSession_p.setAttribute(HISSSOConfig.LOGGEDIN_SYSDATE_STRING, strDate);
			objSession_p.setAttribute(HISSSOConfig.LOGGEDIN_SYSDATE_OBJECT, objSysDate);
			
			// For User Desk
			objSession_p.setAttribute(HISLoginConfig.LOGGEDIN_USER_FAVAOURITE_LIST, mapData_p.get(UserManagementConfig.KEY_USER_FAVORITE_MENU_LIST));
			
			objSession_p.setAttribute(HISSSOConfig.KEY_CASH_COLLECTION_ALLOWED, mapData_p.get(UserManagementConfig.KEY_CASH_COLLECTION_ALLOWED));
			System.out.println("HIS-Login-Log::Set Login Detail in Session: Back Date Day End Check Flag-"+objSession_p.getAttribute(HISSSOConfig.KEY_CASH_COLLECTION_ALLOWED));

			
		}
		catch (Exception ee)
		{
			flg = false;
		}
		return flg;
	}

	/*private static boolean setAuthorization()
	{
		boolean flg = true;
		
		return flg;
	}*/
	public static void setCaptcha(LoginSUP objActionSupport,HttpServletRequest objRequest, HttpServletResponse objResponse) throws ServletException, IOException
	{
		int width = 160;
		int height = 50;
		try{
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
	    Graphics2D graphics2D = image.createGraphics();
	    Random r = new Random();
	    String token = Long.toString(Math.abs(r.nextLong()), 36);
	    String ch = token.substring(0,6);
	    Color c = new Color(0.6662f, 0.4569f, 0.3232f);
	    
	    graphics2D.setColor(Color.decode("#002820"));
	    graphics2D.fillRect(0, 0, image.getWidth(), image.getHeight());
	   
	    //Color c = new Color(0,0,255);
	    GradientPaint gp = new GradientPaint(30, 30, c, 15, 25, Color.white, true);
	    graphics2D.setPaint(gp);
	    Font font=new Font("Verdana", Font.CENTER_BASELINE , 26);
	    graphics2D.setFont(font);
	    graphics2D.drawString(ch,26,33);
	    graphics2D.dispose();
	    
	    HttpSession session = objRequest.getSession(true);
	    session.setAttribute("CAPTCHA_KEY",ch);

	    OutputStream outputStream = objResponse.getOutputStream();
	    objResponse.setContentType("image/*"); 
	    ImageIO.write(image, "jpeg", outputStream);
	    outputStream.close();
		}
		catch(Exception ee)
		{
			objActionSupport.addActionError("Unknown Problem Occured While Trying to fetch Captcha!");
		}
	}
	
	public static WebRowSet dashBoardData(HttpServletRequest request,HttpServletResponse response) throws HisException
	{
		HisDAO hisdao = new HisDAO("LoginPageDashBoard", "dashBoardData()");
		int nIndex;
		WebRowSet wb = null;
		WebRowSet wb1 = null;
		WebRowSet wb2 = null;
		WebRowSet wb3 = null;
		WebRowSet wb4 = null;
		WebRowSet wb5 = null;
		WebRowSet wb6 = null;
		WebRowSet wb7 = null;
		WebRowSet wb8 = null;
		 
		int i;
		try
		{
			String query = "SELECT Count(HRGNUM_EPISODE_CODE)  FROM hrgt_daily_patient_dtl WHERE TRUNC(GDT_ENTRY_DATE)=TRUNC(SYSDATE) and gnum_isvalid=1";
			nIndex = hisdao.setQuery(query);		
			wb=hisdao.executeQry(nIndex);
			
			//System.out.println("WB"+wb.size());
			
			if(wb.next())
			{
				System.out.println("OPD Count "+wb.getString(1));
				//request.setAttribute("OPD_COUNT", wb.getString(1));
				request.getSession().setAttribute("OPD_COUNT", wb.getString(1));
				
				
				//request.getAtrribute("OPD_COUNT").toString();
			}
		
			String query4 = "SELECT Count(hrgnum_puk)  FROM HIPT_PATADMISSION_DTL WHERE TRUNC(HIPDT_ADMDATETIME)=TRUNC(SYSDATE) and gnum_isvalid=1";
			nIndex = hisdao.setQuery(query4);		
			wb4=hisdao.executeQry(nIndex);
			
			//System.out.println("WB"+wb4.size());
			
			if(wb4.next())
			{
				System.out.println("IPD Count "+wb4.getString(1));
				//request.setAttribute("IPD_COUNT", wb4.getString(1));
				request.getSession().setAttribute("IPD_COUNT", wb4.getString(1));
				
				
				//request.getAtrribute("OPD_COUNT").toString();
			}
			
			String query5 = "SELECT Count(hivtnum_req_dno)  FROM HIVT_REQUISITION_DTL WHERE TRUNC(HIVT_ENTRY_DATE)=TRUNC(SYSDATE)";
			nIndex = hisdao.setQuery(query5);		
			wb5=hisdao.executeQry(nIndex);
			
			//System.out.println("WB"+wb5.size());
			
			if(wb5.next())
			{
				System.out.println("INV_COUNT "+wb5.getString(1));
				//request.setAttribute("INV_COUNT", wb5.getString(1));
				request.getSession().setAttribute("INV_COUNT", wb5.getString(1));
				
				
				//request.getAtrribute("OPD_COUNT").toString();
			}
			
			
		
		String query3 = "select Count(GNUM_USERID) from GBLT_USER_LOG where TRUNC(GDT_LOGIN_DATE)= TRUNC(SYSDATE) and GDT_LOGUTT_DATE is null";
		nIndex = hisdao.setQuery(query3);			
		
		wb3=hisdao.executeQry(nIndex);
		
		//System.out.println("WB"+wb3.size());
		if(wb3.next())
		{
			System.out.println("Cur_User_Count "+wb3.getString(1));
			//request.setAttribute("Cur_User_Count", wb3.getString(1));
			request.getSession().setAttribute("Cur_User_Count", wb3.getString(1));
		}
			
		
		String query7 = "SELECT count(HRGNUM_TEMP_REG_NO) FROM hrgt_portal_regist_dtl";
		nIndex = hisdao.setQuery(query7);			
		
		wb7=hisdao.executeQry(nIndex);
		
		//System.out.println("WB"+wb7.size());
		if(wb7.next())
		{
			System.out.println("ONLINE_TEMP_REGISTRATION "+wb7.getString(1));
			//request.setAttribute("MOBILE_REG_DATA_TOTAL", wb7.getString(1));
			request.getSession().setAttribute("MOBILE_REG_DATA_TOTAL", wb7.getString(1));
		}
		String query8 = "SELECT count(HRGNUM_TEMP_PUK) FROM hrgt_patient_temp_dtl";
		nIndex = hisdao.setQuery(query8);			
		
		wb8=hisdao.executeQry(nIndex);
		
		//System.out.println("WB"+wb8.size());
		if(wb8.next())
		{
			System.out.println("ONLINE_TEMP_REGISTRATION "+wb7.getString(1));
			//request.setAttribute("ONLINE_REGISTRATION_TOTAL", wb8.getString(1));
			request.getSession().setAttribute("ONLINE_REGISTRATION_TOTAL", wb8.getString(1));
		}
		
		}
		
		
		catch(Exception e)
		{			
			e.printStackTrace();			
			throw new HisException(e.getMessage());
		}
		finally
		{
				
		}		
		return wb;
		
	} 
	public static WebRowSet dashBoardData1(HttpServletRequest request,HttpServletResponse response) throws HisException
	{
		HisDAO hisdao = new HisDAO("LoginPageDashBoard", "dashBoardData()");
		int nIndex;
		WebRowSet wb = null;
		WebRowSet wb1 = null;
		WebRowSet wb2 = null;
		WebRowSet wb3 = null;
		WebRowSet wb4 = null;
		WebRowSet wb5 = null;
		WebRowSet wb6 = null;
		int i;
		try
		{
			String query = "SELECT nvl(TOTAL_OPD_STATS,0), nvl(TOTAL_IPD_STATS,0), nvl(TOTAL_LABTEST_STATS,0) FROM HDST_LOGIN_DASHBOARD_DATA";
			nIndex = hisdao.setQuery(query);		
			wb=hisdao.executeQry(nIndex);
			
			//System.out.println("WB"+wb.size());
			
			if(wb.next())
			{
				int OPD_COUNT_TOTAL=Integer.parseInt(request.getSession().getAttribute("OPD_COUNT").toString())+Integer.parseInt(wb.getString(1));
				int IPD_COUNT_TOTAL=Integer.parseInt(request.getSession().getAttribute("IPD_COUNT").toString())+Integer.parseInt(wb.getString(2));
				int INV_COUNT_TOTAL=Integer.parseInt(request.getSession().getAttribute("INV_COUNT").toString())+Integer.parseInt(wb.getString(3));
				/*
				 * System.out.println("OPD Count_TOTAL"+OPD_COUNT_TOTAL);
				 * System.out.println("IPD Count_TOTAL"+IPD_COUNT_TOTAL);
				 * System.out.println("INV Count_TOTAL"+INV_COUNT_TOTAL);
				 */
				request.setAttribute("OPD_COUNT_TOTAL", OPD_COUNT_TOTAL);
				request.setAttribute("IPD_COUNT_TOTAL", IPD_COUNT_TOTAL);
				request.setAttribute("INV_COUNT_TOTAL", INV_COUNT_TOTAL);
				request.getSession().setAttribute("OPD_Count_TOTAL1", OPD_COUNT_TOTAL);
				request.getSession().setAttribute("IPD_COUNT_TOTAL1", IPD_COUNT_TOTAL);
				request.getSession().setAttribute("INV_COUNT_TOTAL1", INV_COUNT_TOTAL);
				
				//request.getAtrribute("OPD_COUNT").toString();
			}
		}
		
		
		catch(Exception e)
		{			
			e.printStackTrace();			
			throw new HisException(e.getMessage());
		}
		finally
		{
			
				
		}		
		return wb;
		
	}
	public static WebRowSet circulardata(HttpServletRequest request,HttpServletResponse response) throws HisException
	{
		HisDAO hisdao = new HisDAO("circulardata", "circulardata()");
		int nIndex;
		WebRowSet wb = null;
		try
		{
			String query = "select hstnum_circular_id  , hststr_subject ,  to_char(hstdt_circular_date,'DD-MON-YYYY') , hststr_file_name ,gnum_ispubliccircular , nvl(hststr_download_link,'@')  from hstt_circular_dtl";
			nIndex = hisdao.setQuery(query);		
			wb=hisdao.executeQry(nIndex);
			
			ArrayList<String> al = new ArrayList<String>();
			
			while(wb.next())
			{
				al.add(wb.getString(1)+"#"+wb.getString(2)+"#"+wb.getString(3)+"#"+wb.getString(4)+"#"+wb.getString(5)+"#"+wb.getString(6));
			}
			request.getSession().setAttribute("circulardata", al);
		}
		
		
		catch(Exception e)
		{			
			e.printStackTrace();			
			throw new HisException(e.getMessage());
		}
		finally
		{
			
				
		}		
		return wb;
		
	} 
}
