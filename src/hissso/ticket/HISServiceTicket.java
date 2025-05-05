package hissso.ticket;

import hissso.config.HISSSOConfig;
import hissso.exceptions.TicketGenerationException;
import hissso.exceptions.TicketStatusInitializationException;
import hissso.security.SecureCryptAlgorithm;
import hissso.security.SecureHashAlgorithm;
import hissso.ticket.expiration.ServiceTicketExpiration;
import hissso.validation.credentails.authorization.AuthorizationCredentials;
import hissso.validation.credentails.authorization.HISService;

import javax.servlet.http.HttpSession;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HISServiceTicket extends HISTicket implements ServiceTicket
{
	private static final long serialVersionUID = 12L;
	
	private Boolean expired = false;

	private HISService objService;
	private AuthorizationCredentials objAuthorization;
	private GrantTicket objGrantTicket;

	// Session Object
	private HttpSession objSession;

	// Key Encryption and Salt for Hashing
	private String secretKey; // For Doing SSO and User Specific Encryption
	private String hashSalt; // Future Use for doing one way Hashing of Very Secure Data

//	 public HISServiceTicket()
//	 {
//	 }

	public HISServiceTicket(final GrantTicket objGrantTicket, HttpSession objSession)
			throws TicketGenerationException
	{
		super();
		try
		{
			if (objGrantTicket == null) throw new TicketGenerationException("No Granting Ticket Found");

			// Setting Information
			this.setTicketId(objGrantTicket.getTicketId(), objGrantTicket.getGrantingTicketId());
			this.objExpiration = new ServiceTicketExpiration(objGrantTicket.getExpiry());
			this.objAuthentictaion = objGrantTicket.getAuthentication();
			this.objService = objGrantTicket.getService();
			this.objAuthorization = objGrantTicket.getAuthorization();
			this.objGrantTicket = objGrantTicket;
			this.secretKey = objGrantTicket.getSecretKey();
			this.hashSalt = objGrantTicket.getHashSalt();
			
			// Attaching Session Object
			this.associateServiceAtClient(objSession);
		}
		catch (TicketGenerationException e)
		{
			throw new TicketGenerationException(e.getReason());
		}
		catch (Exception e)
		{
			throw new TicketGenerationException(e.getMessage());
		}
	}

	// Setting Security Essentials
	protected boolean setTicketSecurityEssentials() throws TicketStatusInitializationException
	{
		try
		{
			// Generating and Setting Secret Key
			String secureKey = SecureCryptAlgorithm.generateKey();
			this.secretKey = secureKey;

			// Generating and Setting Hash Salt
			String randomUserLoginSalt = SecureHashAlgorithm.getRandomSalt(HISSSOConfig.LOGIN_USER_SESSION_SALT_BYTE_SIZE);
			this.hashSalt = randomUserLoginSalt;
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
			String ticketId = this.getGrantingTicketId() + HISSSOConfig.SSO_TICKET_ID_INFO_SEPARATOR + userId
					+ HISSSOConfig.SSO_TICKET_ID_INFO_SEPARATOR + this.objService.getContext();
			ticketId = SecureCryptAlgorithm.encrypt(ticketId, this.secretKey);

			// Setting Ticket
			setTicketId(ticketId, this.getGrantingTicketId());
		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}

	public boolean associateServiceAtClient(HttpSession objSession) throws TicketStatusInitializationException
	{
		// Validating Actual Session Object
		if (!this.getGrantingTicketId().equals((String)objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID))) throw new TicketStatusInitializationException(
				"Not a Valid Session Object");

		// Setting Session Object
		this.objSession = objSession;
		if(!this.objExpiration.associateSessionObject(this.objSession)) throw new TicketStatusInitializationException("Session Association Already Found");
		this.objSession = this.objExpiration.getSessionObject();

		// Initializing Ticket Status
		if (!this.initTicketStatus()) throw new TicketStatusInitializationException("Ticket Status can't be Initialzed");
		
		this.expired = false;

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
		this.objSession.setAttribute(HISSSOConfig.LOGGEDIN_USER_SERVICE_TICKET_ID, this.getTicketId());
		//this.objSession.setAttribute(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID, this.getGrantingTicketId());
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


	// Expire Ticket On Service Session Expiration of Client, Not Deleting/Killing Ticket
	public synchronized void expire()
	{
		this.expired = true;
	}

	// Killing Service at Client as well as SSO (Called through TGT) ----
	public void killService()
	{
		// Call ST Servlet to kill Service ST
		// We will call Client SSO Service to detect 
		//RequestDispatcher dis = this.objSession.getServletContext().getContext(this.objService.getContext()).getRequestDispatcher(HISSSOConfig.SSO_SERVICE_TICKET_SERVLET_URL_PATTERN) ;
		
	}

	// Checking Expiration of Service at Client (Called through TGT) ----
	public boolean isExpiredAtClient()
	{
		// Call ST Servlet to check Expiry Service ST
		return false;
	}

	// Forceful Logout Service Ticket
	public synchronized void logout()
	{
		try
		{
			if(!this.isExpired()) this.objSession.invalidate();
		}
		catch(Exception e)
		{
		}
		this.expire();
	}

	public boolean isFromNewLogin()
	{
		return false;
	}

	// Get Service Detail
	public HISService getService()
	{
		return this.objService;
	}

	// Get Grant Service Ticket
	public GrantTicket getServiceGrantTicket()
	{
		return this.objGrantTicket;
	}

	public final boolean equals(final Object object)
	{
		if (object == null || !(object instanceof ServiceTicket))
		{
			return false;
		}
		final Ticket ticket = (Ticket) object;
		return ticket.getTicketId().equals(this.getTicketId());
	}

	@XmlElement
	public Boolean getExpired()
	{
		return expired;
	}

	@XmlElement
	public HISService getObjService()
	{
		return objService;
	}

	@XmlElement
	public AuthorizationCredentials getObjAuthorization()
	{
		return objAuthorization;
	}
}
