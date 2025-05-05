package hissso.ticket;

/***************************Start of Program Header ****************************
## Copyright Information				: C-DAC, Noida  
## Project Name							: Generation 5, HIS
## Name of Developer		 			: Pragya Sharma
## Module Name							: HIS Single Sign On and Web Security 
## Process/Database Object Name			: HISTicketGrantingTicket
## Purpose								: 
## Date of Creation						:  
## Modification Log						:				
##		Modify Date				: 2016.16.05 
##		Reason	(CR/PRS)		: Session Time out Issue  
##		Modify By				: Pragya Sharma
**************************End of program*****************************/

import hisglobal.config.HISConfig;
import hissso.client.service.HISClientSO;
import hissso.client.service.HISSSOClientServiceCLN;
import hissso.config.HISSSOConfig;
import hissso.exceptions.TicketGenerationException;
import hissso.exceptions.TicketStatusInitializationException;
import hissso.security.SecureCryptAlgorithm;
import hissso.security.SecureHashAlgorithm;
import hissso.ticket.expiration.HISExpiration;
import hissso.validation.credentails.authentication.AuthenticationCredentials;
import hissso.validation.credentails.authorization.AuthorizationCredentials;
import hissso.validation.credentails.authorization.HISService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

public final class HISTicketGrantingTicket extends HISTicket implements TicketGrantingTicket
{
	private static final long serialVersionUID = 11L;
	private Boolean expired = false;

	// Session Object
	private HttpSession objSession;

	// Key Encryption and Salt for Hashing
	private String secretKey; // For Doing SSO and User Specific Encryption
	private String hashSalt; // Future Use for doing one way Hashing of Very Secure Data

	private AuthorizationCredentials objAuthorization;

	// Services
	private final List<HISService> lstServicesAccessed = new ArrayList<HISService>();
		// Context URL verses Service
	private final HashMap<String, HISService> mapServices = new HashMap<String, HISService>();
		// Context URL verses Service Grant Ticket
	private final HashMap<String, GrantTicket> mapServicesTickets = new HashMap<String, GrantTicket>();

	// Default Constructor
	// public HISTicketGrantingTicket()
	// {
	// }

	public HISTicketGrantingTicket(final AuthenticationCredentials objAuthentictaion, final HISExpiration objExpiration)
			throws TicketGenerationException
	{
		super(objAuthentictaion, objExpiration);
	}

	public HISTicketGrantingTicket(final AuthenticationCredentials objAuthentictaion, final HISExpiration objExpiration,
			final AuthorizationCredentials objAuthorization) throws TicketGenerationException
	{
		super(objAuthentictaion, objExpiration);
		setAuthorization(objAuthorization);
	}

	// Setting User Authorization Detail
	public void setAuthorization(AuthorizationCredentials objAuthorization)
	{
		this.objAuthorization = objAuthorization;
		this.objSession.setAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHORIZATION_OBJECT, this.objAuthorization);
	}

	// Setting Security Essentials
	protected boolean setTicketSecurityEssentials() throws TicketStatusInitializationException
	{
		try
		{
			// Setting Session Object
			if (this.objExpiration.getSessionObject() == null) throw new TicketStatusInitializationException("No Ticket Session Found");
			this.objSession = this.objExpiration.getSessionObject();

			// Validating Actual Session Object
//			if (!this.getAuthentication().getVarUserLoginSessionId().equals(this.objSession.getId()))
//					throw new TicketStatusInitializationException("Not a Valid Session Object");

			// Generating and Setting Secret Key
			String secureKey = SecureCryptAlgorithm.generateKey();
			this.secretKey = secureKey;

			// Generating and Setting Hash Salt
			String randomUserLoginSalt = SecureHashAlgorithm.getRandomSalt(HISSSOConfig.LOGIN_USER_SESSION_SALT_BYTE_SIZE);
			this.hashSalt = randomUserLoginSalt;
		}
		catch (TicketStatusInitializationException e)
		{
			throw new TicketStatusInitializationException(e.getReason());
		}
		catch (Exception e)
		{
			throw new TicketStatusInitializationException(e.getMessage());
		}
		return true;
	}

	// Calculate Ticket Id
	protected boolean calculateTicketId()
	{
		try
		{
			// Ticket Generation Essentials
			String userId = this.getAuthentication().getVarUserId();

			// Generating Ticket Id
			String ticketId = userId + HISSSOConfig.SSO_TICKET_ID_INFO_SEPARATOR + this.objSession.getId();
			ticketId = SecureCryptAlgorithm.encrypt(ticketId, this.secretKey);

			// Setting Ticket
			setTicketId(ticketId, ticketId);
		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}

	// Initializing Ticket Status
	protected boolean initTicketStatus()
	{
		// Login Initial Status
		this.creationTime = this.objSession.getCreationTime();
		this.lastTimeUsed = this.objSession.getCreationTime();
		this.countOfAccess = 0;

		// Setting Session Initials
		this.objSession.setAttribute(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID, this.getTicketId());
		this.objSession.setAttribute(HISSSOConfig.LOGGEDIN_USER_HASH_SALT, this.hashSalt);
		this.objSession.setAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT, this.objAuthentictaion);
		this.objSession.setAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHORIZATION_OBJECT, this.objAuthorization);

		// Setting Session Expiration
		this.objExpiration.setExpiry();
		return true;
	}

	// Refresh Status
	protected boolean refreshStatus()
	{
		this.objExpiration.refershExpiry();
		return true;
	}

	// Get User Authorization Detail
	public AuthorizationCredentials getAuthorization()
	{
		return this.objAuthorization;
	}

	// Granting Service Ticket
	public GrantTicket grantServiceTicket(HISService objService, HISExpiration expirationPolicy)
	{
		GrantTicket grantTicket = null;
		try
		{
			grantTicket = new HISServiceGrantTicket(this, objService, expirationPolicy);
			this.setService(objService, grantTicket);
		}
		catch (TicketGenerationException e)
		{
			grantTicket = null;
		}
		catch (Exception e)
		{
			grantTicket = null;
		}
		return grantTicket;
	}

	// Internal Set Service to Ticket
	private void setService(HISService objService, GrantTicket objGrantTicket)
	{
		this.updateStatus();

		this.lstServicesAccessed.add(objService);
		this.mapServices.put(objService.getContext(), objService);
		this.mapServicesTickets.put(objService.getContext(), objGrantTicket);
	}

	public final boolean isExpired()
	{
		if(this.expired)	return this.expired;
		
		boolean isExpired = false;
		try
		{
			// Checking Session Expiration Check here
			this.objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT);
		}
		catch (IllegalStateException e)
		{
			isExpired = true;
		}
		this.expired = isExpired;
		return isExpired;
	}


	// Expire Ticket On logout
	public synchronized void logout()
	{
		// Removing Session on Different Servers
			// Removing Login Session from AS-Application Context and Logged-in Applications
		logOutOfServices();
			// Invalidating Current Session Details
		try
		{
			if(!this.expired) this.objSession.invalidate();
		}
		catch(Exception e)
		{
		}
		this.expired = true;
	}

	// Logout from all Other Services
	private void logOutOfServices()
	{
		for (final GrantTicket grantTicket : this.mapServicesTickets.values())
		{
			killService(grantTicket);
		}
	}

	// Expire Ticket On Session Expiration if all Services are expired
	public synchronized boolean expire()
	{
		if (checkExpireOfServices())
		{
			this.expired = true;
			this.logout();
			return true;
		}
		else return false;
	}

	// Check Expiration of Other Services
	private boolean checkExpireOfServices()
	{
		for (final GrantTicket grantTicket : this.mapServicesTickets.values())
		{
			if (!isExpiredAtClient(grantTicket))
			{
				return false;
			}
		}
		return true;
	}
	
	
	private boolean isExpiredAtClient(GrantTicket grantTicket)
	{
		boolean flg = true;
		try
		{
			HISSSOClientServiceCLN objHISSSOClientService = new HISSSOClientServiceCLN();
			HISClientSO soClient = new HISClientSO();
			soClient.setGrantingTicketId(grantTicket.getGrantingTicketId());
			soClient.setServiceTicketId(grantTicket.getTicketId());
			soClient.setObjService(grantTicket.getService());
			soClient = objHISSSOClientService.isServiceTicketExpired(soClient);
			
			if(soClient!=null && soClient.getActionStatus().equals(HISConfig.YES))
				flg = true;
			else
				flg = false;
		}
		catch (Exception e)
		{
			flg = true;
			e.printStackTrace();
		}
		return flg;
	}

	private boolean killService(GrantTicket grantTicket)
	{
		// Here, we need to ensure that Service should get Killed on Expire of Login..---- if not try again n again
		boolean flg = false;
		try
		{
			HISSSOClientServiceCLN objHISSSOClientService = new HISSSOClientServiceCLN();
			HISClientSO soClient = new HISClientSO();
			soClient.setGrantingTicketId(grantTicket.getGrantingTicketId());
			soClient.setServiceTicketId(grantTicket.getTicketId());
			soClient.setObjService(grantTicket.getService());
			soClient = objHISSSOClientService.killServiceTicket(soClient);
			
			if(soClient!=null && soClient.getActionStatus().equals(HISConfig.YES))
				flg = true;
			else
				flg = false;
		}
		catch (Exception e)
		{
			flg = false;
			e.printStackTrace();
		}
		return flg;
	}

	public List<HISService> getServiceUsed()
	{
		return this.lstServicesAccessed;
	}

	public final boolean equals(final Object object)
	{
		if (object == null || !(object instanceof TicketGrantingTicket))
		{
			return false;
		}
		final Ticket ticket = (Ticket) object;
		return ticket.getTicketId().equals(this.getTicketId());
	}
}
