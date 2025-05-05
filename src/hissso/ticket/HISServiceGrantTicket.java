package hissso.ticket;

import hissso.config.HISSSOConfig;
import hissso.exceptions.TicketGenerationException;
import hissso.exceptions.TicketStatusInitializationException;
import hissso.security.SecureCryptAlgorithm;
import hissso.security.SecureHashAlgorithm;
import hissso.ticket.expiration.HISExpiration;
import hissso.validation.credentails.authentication.AuthenticationCredentials;
import hissso.validation.credentails.authorization.AuthorizationCredentials;
import hissso.validation.credentails.authorization.HISService;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HISServiceGrantTicket implements GrantTicket
{
	// Serialization ID
	private static final long serialVersionUID = 2L;

	// Ticket ID
	private String ticketId;
	// Granting Ticket ID
	private String grantingTicketId;

	// Expiration Time in Seconds
	private int timeToExpireInSecond;

	// Authentication Credentials
	protected AuthenticationCredentials objAuthentictaion;

	private HISService objService;
	private AuthorizationCredentials objAuthorization;

	// Secret Key Encryption and Hash Salt
	private String secretKey; // For Doing SSO and User Specific Encryption
	private String hashSalt;

	public HISServiceGrantTicket()
	{
		// Do Thing for Service Calling
	}

	protected HISServiceGrantTicket(final TicketGrantingTicket objTicketGrantingTicket, final HISService objService, final HISExpiration objExpiration)
			throws TicketGenerationException
	{
		try
		{
			if (objTicketGrantingTicket == null) throw new TicketGenerationException("No Granting Ticket Found");
			if (objService == null) throw new TicketGenerationException("No Service Found");
			if (objExpiration == null) throw new TicketGenerationException("No Expiration Policy Found");

			this.objAuthentictaion = objTicketGrantingTicket.getAuthentication();
			this.objService = objService;
			this.timeToExpireInSecond = objExpiration.getExpiry();
			this.grantingTicketId = objTicketGrantingTicket.getTicketId();
			// Extracting and Setting Service Wise Authority  
			this.objAuthorization = objTicketGrantingTicket.getAuthorization().extractContextWiseAuthority(this.objService.getContext());

			// Setting Ticket Security Essentials
			if (!this.setTicketSecurityEssentials()) throw new TicketGenerationException("Ticket Security can't be Set");

			// Calculating ticketId and grantingTicketId
			if (!this.calculateTicketId()) throw new TicketGenerationException("Ticket Id can't be Generated");

		}
		catch (TicketGenerationException e)
		{
			throw new TicketGenerationException(e.getReason());
		}
		catch (TicketStatusInitializationException e)
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
			String userId = this.objAuthentictaion.getVarUserId();

			// Generating Ticket Id
			String ticketId = this.getGrantingTicketId() + HISSSOConfig.SSO_TICKET_ID_INFO_SEPARATOR + userId
					+ HISSSOConfig.SSO_TICKET_ID_INFO_SEPARATOR + this.objService.getContext();
			ticketId = SecureCryptAlgorithm.encrypt(ticketId, this.secretKey);

			// Setting Ticket
			this.ticketId = ticketId;
		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}

	public AuthenticationCredentials getAuthentication()
	{
		return this.objAuthentictaion;
	}

	// Get User Authorization Detail
	public AuthorizationCredentials getAuthorization()
	{
		return this.objAuthorization;
	}

	public HISService getService()
	{
		return this.objService;
	}

	// Get Expiration
	public int getExpiry()
	{
		return this.timeToExpireInSecond;
	}

	public final boolean equals(final Object object)
	{
		if (object == null || !(object instanceof GrantTicket))
		{
			return false;
		}
		final Ticket ticket = (Ticket) object;
		return ticket.getTicketId().equals(this.getTicketId());
	}

	@XmlElement
	public String getTicketId()
	{
		return ticketId;
	}

	@XmlElement
	public final String getGrantingTicketId()
	{
		return this.grantingTicketId;
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

	@XmlElement
	public int getTimeToExpireInSecond()
	{
		return timeToExpireInSecond;
	}

	@XmlElement
	public AuthenticationCredentials getObjAuthentictaion()
	{
		return objAuthentictaion;
	}

	@XmlElement
	public String getSecretKey()
	{
		return secretKey;
	}

	@XmlElement
	public String getHashSalt()
	{
		return hashSalt;
	}

	public void setTicketId(String ticketId)
	{
		this.ticketId = ticketId;
	}

	public void setGrantingTicketId(String grantingTicketId)
	{
		this.grantingTicketId = grantingTicketId;
	}

	public void setTimeToExpireInSecond(int timeToExpireInSecond)
	{
		this.timeToExpireInSecond = timeToExpireInSecond;
	}

	public void setObjAuthentictaion(AuthenticationCredentials objAuthentictaion)
	{
		this.objAuthentictaion = objAuthentictaion;
	}

	public void setObjService(HISService objService)
	{
		this.objService = objService;
	}

	public void setObjAuthorization(AuthorizationCredentials objAuthorization)
	{
		this.objAuthorization = objAuthorization;
	}

	public void setSecretKey(String secretKey)
	{
		this.secretKey = secretKey;
	}

	public void setHashSalt(String hashSalt)
	{
		this.hashSalt = hashSalt;
	}
}
