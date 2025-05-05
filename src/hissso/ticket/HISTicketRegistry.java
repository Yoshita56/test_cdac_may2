package hissso.ticket;

import hissso.ticket.HISServiceGrantTicket;
import hissso.ticket.ServiceTicket;
import hissso.ticket.Ticket;
import hissso.ticket.TicketGrantingTicket;
import hissso.validation.credentails.authorization.HISService;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class HISTicketRegistry implements TicketRegistry
{
	// Ticket ID vs Ticket
	private final Map<String, Ticket> cache;
	
	// User ID vs Ticket
	private final Map<String, Ticket> userTicketCache;

	// User ID#IP Address vs Ticket
	private final Map<String, Ticket> userIPTicketCache;

	// TGT ID#SeviceContext vs Ticket
	private final Map<String, Ticket> tgtServiceTicketCache;

	public HISTicketRegistry()
	{
		this.cache = new ConcurrentHashMap<String, Ticket>();
		this.userTicketCache = new ConcurrentHashMap<String, Ticket>();
		this.userIPTicketCache = new ConcurrentHashMap<String, Ticket>();
		this.tgtServiceTicketCache = new ConcurrentHashMap<String, Ticket>();
		//System.out.println("HIS Ticket Registry --> Registry Initalized");
	}

	public void addTicket(final Ticket ticket)
	{
		//System.out.println("HIS Ticket Registry --> Ticket Added::" + ticket.getTicketId());
		this.cache.put(ticket.getTicketId(), ticket);
		
		if(ticket instanceof HISServiceGrantTicket)
		{
			HISServiceGrantTicket objServiceTicket = (HISServiceGrantTicket)ticket;
			this.tgtServiceTicketCache.put(objServiceTicket.getGrantingTicketId()+"#"+objServiceTicket.getService().getContext(), ticket);
		}
		else
		{
			this.userTicketCache.put(ticket.getAuthentication().getVarUserId(), ticket);
			this.userIPTicketCache.put(ticket.getAuthentication().getVarUserId()+"#"+ticket.getAuthentication().getVoUser().getVarIPAddress(), ticket);
		}
	}

	public Ticket getTicket(final String ticketId)
	{
		if (ticketId == null)
		{
			return null;
		}
		//System.out.println("HIS Ticket Registry --> Retrieving Ticket ::" + ticketId);

		final Ticket ticket = this.cache.get(ticketId);
		//if (ticket == null)
			//System.out.println("HIS Ticket Registry --> Ticket Not Found::" + ticketId);

		return ticket;
	}

	public boolean deleteTicket(final String ticketId)
	{
		if (ticketId == null)
		{
			return false;
		}
		//System.out.println("HIS Ticket Registry --> Removing Ticket::" + ticketId);
		final Ticket ticket = this.cache.get(ticketId);
		if(ticket != null)
		{
			this.cache.remove(ticketId);
			if(ticket instanceof HISServiceGrantTicket)
			{
				HISServiceGrantTicket objServiceTicket = (HISServiceGrantTicket)ticket;
				this.tgtServiceTicketCache.remove(objServiceTicket.getGrantingTicketId()+"#"+objServiceTicket.getService().getContext());
			}
			else
			{
				this.userTicketCache.remove(ticket.getAuthentication().getVarUserId());
				this.userIPTicketCache.remove(ticket.getAuthentication().getVarUserId()+"#"+ticket.getAuthentication().getVoUser().getVarIPAddress());
			}

			return true;
		}
		else
			return false;
	}

	public Collection<Ticket> getTickets()
	{
		return Collections.unmodifiableCollection(this.cache.values());
	}

	public int ticketCount()
	{
		int count = 0;
		for (Ticket t : this.cache.values())
		{
			if (t instanceof TicketGrantingTicket)
			{
				count++;
			}
		}
		return count;
	}

	public int serviceTicketCount()
	{
		int count = 0;
		for (Ticket t : this.cache.values())
		{
			if (t instanceof ServiceTicket)
			{
				count++;
			}
		}
		return count;
	}
	
	// Cleaning Whole Registry
	public void clean()
	{
		for (Ticket t : this.cache.values())
		{
			deleteTicket(t.getTicketId());
		}
		
	}

	public Ticket getTicketBasedOn(final String userId)
	{
		if (userId == null)
		{
			return null;
		}
		//System.out.println("HIS Ticket Registry --> Retrieving Ticket By User ID ::" + userId);

		final Ticket ticket = this.userTicketCache.get(userId);
		//if (ticket == null)
			//System.out.println("HIS Ticket Registry --> Ticket Not Found By User ID ::" + userId);

		return ticket;
	}

	public Ticket getTicketBasedOn(final String grantingTicketId, final HISService objService)
	{
		if (grantingTicketId == null || objService==null || objService.getContext()==null)
		{
			return null;
		}
		//System.out.println("HIS Ticket Registry --> Retrieving Ticket By TGT ID and Service Context ::" + grantingTicketId + " & " + objService.getContext());

		final Ticket ticket = this.tgtServiceTicketCache.get(grantingTicketId+"#"+objService.getContext());
		//if (ticket == null)
			//System.out.println("HIS Ticket Registry --> Ticket Not Found By TGT ID and Service Context ::" + grantingTicketId + " & " + objService.getContext());

		return ticket;
	}

	public Ticket getTicketBasedOn(final String userId, final String ipAddress)
	{
		if (userId == null || ipAddress==null)
		{
			return null;
		}
		//System.out.println("HIS Ticket Registry --> Retrieving Ticket By User ID & IP Address ::" + userId + " & " + ipAddress);

		final Ticket ticket = this.userIPTicketCache.get(userId+"#"+ipAddress);
		//if (ticket == null)
			//System.out.println("HIS Ticket Registry --> Ticket Not Found By User ID & IP Address ::" + userId + " & " + ipAddress);

		return ticket;
	}
}
