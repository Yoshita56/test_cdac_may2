package hissso.ticket;

/***************************Start of Program Header ****************************
## Copyright Information				: C-DAC, Noida  
## Project Name							: Generation 5, HIS
## Name of Developer		 			: Pragya Sharma
## Module Name							: HIS Single Sign On and Web Security 
## Process/Database Object Name			: HISTicket
## Purpose								: 
## Date of Creation						:  
## Modification Log						:				
##		Modify Date				: 2016.16.05 
##		Reason	(CR/PRS)		: Session Time out Issue  
##		Modify By				: Pragya Sharma
**************************End of program*****************************/

import hissso.exceptions.TicketGenerationException;
import hissso.exceptions.TicketStatusInitializationException;
import hissso.ticket.expiration.HISExpiration;
import hissso.validation.credentails.authentication.AuthenticationCredentials;

// Abstract HIS Ticket Class for TGT and ST
public abstract class HISTicket implements Ticket, TicketStatus
{
	// Serialization ID
	private static final long serialVersionUID = 1L;

	// Ticket ID
	private String ticketId;
	// Granting Ticket ID
	private String grantingTicketId;

	// Expiration Object
	protected HISExpiration objExpiration;
	// Authentication Credentials
	protected AuthenticationCredentials objAuthentictaion;

	// Creation Time
	protected long creationTime;
	// Last Time Used
	protected long lastTimeUsed;
	// Number of Time Accessed
	protected int countOfAccess;

	// Default Constructor
	protected HISTicket()
	{
	}

	// Constructor
	public HISTicket(final AuthenticationCredentials objAuthentictaion, final HISExpiration objExpiration)
			throws TicketGenerationException
	{
		try
		{
			if (objAuthentictaion == null) throw new TicketGenerationException("No Authentication Credentials Found");
			if (objExpiration == null) throw new TicketGenerationException("No Expiration Policy Found");

			this.objAuthentictaion = objAuthentictaion;
			this.objExpiration = objExpiration;

			// Setting Ticket Security Essentials

			if (!this.setTicketSecurityEssentials()) throw new TicketGenerationException("Ticket Security can't be Set");
			// Calculating ticketId and grantingTicketId
			if (!this.calculateTicketId()) throw new TicketGenerationException("Ticket Id can't be Generated");

			// Initializing Ticket Status
			if (!this.initTicketStatus()) throw new TicketGenerationException("Ticket Status can't be Initialzed");

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
	protected abstract boolean setTicketSecurityEssentials() throws TicketStatusInitializationException;

	// Calculate Ticket Id
	protected abstract boolean calculateTicketId();

	// Initializing Ticket Status
	protected abstract boolean initTicketStatus();

	// Refresh Status
	protected abstract boolean refreshStatus();

	// Getting Expiration
	public HISExpiration getExpiration()
	{
		return this.objExpiration;
	}

	// Updating Ticket Access Status and refreshing Status
	protected final void updateStatus()
	{
		this.lastTimeUsed = System.currentTimeMillis();
		this.countOfAccess++;
		// Refresh Status Expiration
		refreshStatus();
	}

	// Setting Ticket Id
	protected void setTicketId(String ticketId, String grantingTicketId)
	{
		this.ticketId = ticketId;
		this.grantingTicketId = grantingTicketId;
	}

	// Setting Granting Ticket Id
	protected void setGrantingTicketId(String grantingTicketId)
	{
		this.grantingTicketId = grantingTicketId;
	}

	public String getTicketId()
	{
		return ticketId;
	}

	public final String getGrantingTicketId()
	{
		return this.grantingTicketId;
	}

	public final int getCountOfAccess()
	{
		return this.countOfAccess;
	}

	public final long getCreationTime()
	{
		return this.creationTime;
	}

	public final long getLastTimeUsed()
	{
		return this.lastTimeUsed;
	}

	public AuthenticationCredentials getAuthentication()
	{
		return this.objAuthentictaion;
	}

	public final int hashCode()
	{
		return 34 ^ this.getTicketId().hashCode();
	}

	public final String toString()
	{
		return this.ticketId;
	}
}
