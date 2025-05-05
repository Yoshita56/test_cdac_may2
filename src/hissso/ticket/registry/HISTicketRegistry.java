package hissso.ticket.registry;

/***************************Start of Program Header ****************************
## Copyright Information				: C-DAC, Noida  
## Project Name							: Generation 5, HIS
## Name of Developer		 			: Pragya Sharma
## Module Name							: HIS Single Sign On and Web Security 
## Process/Database Object Name			: HISTicketRegistry
## Purpose								: 
## Date of Creation						:  
## Modification Log						:				
##		Modify Date				: 2016.16.05 
##		Reason	(CR/PRS)		: Session Time out Issue  
##		Modify By				: Pragya Sharma
**************************End of program*****************************/

import hissso.security.SecureCryptAlgorithm;
import hissso.ticket.HISServiceGrantTicket;
import hissso.ticket.HISTicket;
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
	
	private final Map<String , String> agentCatche;
	
	// User ID vs Ticket
	private final Map<String, Ticket> userTicketCache;

	// User ID#IP Address vs Ticket
	private final Map<String, Ticket> userIPTicketCache;

	// TGT ID#SeviceContext vs Ticket
	private final Map<String, Ticket> tgtServiceTicketCache;

	public HISTicketRegistry()
	{
		this.cache = new ConcurrentHashMap<String, Ticket>();
		this.agentCatche = new ConcurrentHashMap<String, String>();
		this.userTicketCache = new ConcurrentHashMap<String, Ticket>();
		this.userIPTicketCache = new ConcurrentHashMap<String, Ticket>();
		this.tgtServiceTicketCache = new ConcurrentHashMap<String, Ticket>();
		//System.out.println("HIS-SSO:: Ticket Registry Initalized");
	}

	public void addTicket(final Ticket ticket)
	{
		// Adding Ticket to Registry Cache
		this.cache.put(ticket.getTicketId(), ticket);
		
		// In case of ST, Putting Ticket in TGT#Context Cache  otherwise in User Cache with User Id and Unique cache with key "UserId#IP#SessionID#UserAgent"  
		if(ticket instanceof HISServiceGrantTicket)
		{
			HISServiceGrantTicket objServiceTicket = (HISServiceGrantTicket)ticket;
			this.tgtServiceTicketCache.put(objServiceTicket.getGrantingTicketId()+"#"+objServiceTicket.getService().getContext(), ticket);
			/*
			 * System.out.println("HIS-SSO:: Ticket Registry: Service Ticket Registered-" +
			 * ticket.getTicketId() +
			 * " of Service-"+objServiceTicket.getService().getContext()+" in TGT-"
			 * +objServiceTicket.getGrantingTicketId());
			 */
		}
		else if(ticket instanceof HISTicket)
		{
			HISTicket hisTicket = (HISTicket) ticket;
			this.userTicketCache.put(hisTicket.getAuthentication().getVarUserId(), hisTicket);
			//String key = hisTicket.getAuthentication().getVarUserId()+"#"+hisTicket.getAuthentication().getVoUser().getVarIPAddress()+"#"
					//+hisTicket.getExpiration().getSessionObject().getId()+"#"+hisTicket.getAuthentication().getVarUserLoginUserAgent();
			String key = hisTicket.getAuthentication().getVarUserId()+"#"+hisTicket.getAuthentication().getVoUser().getVarIPAddress()+"#"
					+hisTicket.getExpiration().getSessionObject().getId();
			this.userIPTicketCache.put(key, hisTicket);
			//System.out.println("HIS-SSO:: Ticket Registry: HIS Ticket Registered-" + hisTicket.getTicketId() + " of Credential-"+key);
		}
		else
		{
			this.userTicketCache.put(ticket.getAuthentication().getVarUserId(), ticket);
			//String key = ticket.getAuthentication().getVarUserId()+"#"+ticket.getAuthentication().getVoUser().getVarIPAddress()+"#"
					//+ticket.getAuthentication().getVarUserLoginSessionId()+"#"+ticket.getAuthentication().getVarUserLoginUserAgent();
			String key = ticket.getAuthentication().getVarUserId()+"#"+ticket.getAuthentication().getVoUser().getVarIPAddress()+"#"
					+ticket.getAuthentication().getVarUserLoginSessionId();
			this.userIPTicketCache.put(key, ticket);
			//System.out.println("HIS-SSO:: Ticket Registry: Ticket Registered-" + ticket.getTicketId() + " of Credential-"+key);
		}
	}
	
	public void addTicket(final Ticket ticket, final String userAgent)
	{
		// Adding Ticket to Registry Cache
		//this.cache.put(ticket.getTicketId(), ticket);
		//System.out.println("IMCS HIS Ticket Registry --> Ticket Added::" + ticket.getTicketId()+"#"+userAgent);
		this.cache.put(ticket.getTicketId(), ticket);
		
		this.agentCatche.put(ticket.getTicketId(), SecureCryptAlgorithm.encrypt(userAgent));
		
		// In case of ST, Putting Ticket in TGT#Context Cache  otherwise in User Cache with User Id and Unique cache with key "UserId#IP#SessionID#UserAgent"  
		if(ticket instanceof HISServiceGrantTicket)
		{
			HISServiceGrantTicket objServiceTicket = (HISServiceGrantTicket)ticket;
			this.tgtServiceTicketCache.put(objServiceTicket.getGrantingTicketId()+"#"+objServiceTicket.getService().getContext(), ticket);
			/*
			 * System.out.println("HIS-SSO:: Ticket Registry: Service Ticket Registered-" +
			 * ticket.getTicketId() +
			 * " of Service-"+objServiceTicket.getService().getContext()+" in TGT-"
			 * +objServiceTicket.getGrantingTicketId());
			 */
		}
		else if(ticket instanceof HISTicket)
		{
			HISTicket hisTicket = (HISTicket) ticket;
			this.userTicketCache.put(hisTicket.getAuthentication().getVarUserId(), hisTicket);
			//String key = hisTicket.getAuthentication().getVarUserId()+"#"+hisTicket.getAuthentication().getVoUser().getVarIPAddress()+"#"
					//+hisTicket.getExpiration().getSessionObject().getId()+"#"+hisTicket.getAuthentication().getVarUserLoginUserAgent();
			
			String key = hisTicket.getAuthentication().getVarUserId()+"#"+hisTicket.getAuthentication().getVoUser().getVarIPAddress()+"#"
					+hisTicket.getExpiration().getSessionObject().getId();
			this.userIPTicketCache.put(key, hisTicket);
			//System.out.println("HIS-SSO:: Ticket Registry: HIS Ticket Registered-" + hisTicket.getTicketId() + " of Credential-"+key);
		}
		else
		{
			this.userTicketCache.put(ticket.getAuthentication().getVarUserId(), ticket);
			//String key = ticket.getAuthentication().getVarUserId()+"#"+ticket.getAuthentication().getVoUser().getVarIPAddress()+"#"
					//+ticket.getAuthentication().getVarUserLoginSessionId()+"#"+ticket.getAuthentication().getVarUserLoginUserAgent();
			String key = ticket.getAuthentication().getVarUserId()+"#"+ticket.getAuthentication().getVoUser().getVarIPAddress()+"#"
					+ticket.getAuthentication().getVarUserLoginSessionId();
			this.userIPTicketCache.put(key, ticket);
			//System.out.println("HIS-SSO:: Ticket Registry: Ticket Registered-" + ticket.getTicketId() + " of Credential-"+key);
		}
	}

	
	/*public void addTicket(final Ticket ticket, HttpSession objSession)
	{
		// Adding Ticket to Registry Cache
		this.cache.put(ticket.getTicketId(), ticket);
		
		// In case of ST, Putting Ticket in TGT#Context Cache  otherwise in User Cache with User Id and Unique cache with key "UserId#IP#SessionID#UserAgent"  
		if(ticket instanceof HISServiceGrantTicket)
		{
			HISServiceGrantTicket objServiceTicket = (HISServiceGrantTicket)ticket;
			this.tgtServiceTicketCache.put(objServiceTicket.getGrantingTicketId()+"#"+objServiceTicket.getService().getContext(), ticket);
		}
		else
		{
			this.userTicketCache.put(ticket.getAuthentication().getVarUserId(), ticket);
			this.userIPTicketCache.put(ticket.getAuthentication().getVarUserId()+"#"+ticket.getAuthentication().getVoUser().getVarIPAddress()+"#"+objSession.getId()+"#"+ticket.getAuthentication().getVoUser().getVarUserAgent(), ticket);
		}
		System.out.println("HIS-SSO:: Ticket Registered-" + ticket.getTicketId());
	}
	
	public void addTicket(final Ticket ticket)
	{
		// Adding Ticket to Registry Cache
		this.cache.put(ticket.getTicketId(), ticket);
		
		// In case of ST, Putting Ticket in TGT#Context Cache  otherwise in User Cache with User Id and Unique cache with key "UserId#IP#SessionID#UserAgent"  
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
		System.out.println("HIS-SSO:: Ticket Registered-" + ticket.getTicketId());
	}*/

	public Ticket getTicket(final String ticketId)
	{
		if (ticketId == null)
		{
			return null;
		}

		final Ticket ticket = this.cache.get(ticketId);
		/*
		 * if (ticket == null)
		 * System.out.println("HIS-SSO:: Ticket Registry: Ticket Not Found-" +
		 * ticketId); else System.out.println("HIS-SSO:: Ticket Registry: Ticket Found-"
		 * + ticketId);
		 */
		return ticket;
	}
	
	/*public Ticket getTicket(final String ticketId , final String userAgent)
	{
		if (ticketId == null)
		{
			return null;
		}
		System.out.println("AHIMSG5 HIS Ticket Registry --> Retrieving Ticket ::" + ticketId+"#"+userAgent);

		final Ticket ticket = this.cache.get(ticketId+"#"+userAgent);
		if (ticket == null)
			System.out.println("HIS Ticket Registry --> Ticket Not Found::" + ticketId);

		return ticket;
	}*/
	
	public boolean deleteTicket(final String ticketId)
	{
		if (ticketId == null)
		{
			return false;
		}
		final Ticket ticket = this.cache.get(ticketId);
		if(ticket != null)
		{
			this.cache.remove(ticketId);
			
			this.agentCatche.remove(ticketId);
			
			if(ticket instanceof HISServiceGrantTicket)
			{
				HISServiceGrantTicket objServiceTicket = (HISServiceGrantTicket)ticket;
				this.tgtServiceTicketCache.remove(objServiceTicket.getGrantingTicketId()+"#"+objServiceTicket.getService().getContext());
			//	System.out.println("HIS-SSO:: Ticket Registry: Service Ticket Removed-" + ticketId + " of Service-"+objServiceTicket.getService().getContext()+" in TGT-"+objServiceTicket.getGrantingTicketId());
			}
			else if(ticket instanceof HISTicket)
			{
				HISTicket hisTicket = (HISTicket) ticket;
				this.userTicketCache.remove(hisTicket.getAuthentication().getVarUserId());
				//String key = hisTicket.getAuthentication().getVarUserId()+"#"+hisTicket.getAuthentication().getVoUser().getVarIPAddress()+"#"
						//+ hisTicket.getExpiration().getSessionObject().getId()+"#"+hisTicket.getAuthentication().getVarUserLoginUserAgent();
				String key = hisTicket.getAuthentication().getVarUserId()+"#"+hisTicket.getAuthentication().getVoUser().getVarIPAddress()+"#"
						+ hisTicket.getExpiration().getSessionObject().getId();
				this.userIPTicketCache.remove(key);
			//	System.out.println("HIS-SSO:: Ticket Registry: HIS Ticket Removed-" + ticketId + " of Credential-"+key);
			}
			else
			{
				this.userTicketCache.remove(ticket.getAuthentication().getVarUserId());
				//String key = ticket.getAuthentication().getVarUserId()+"#"+ticket.getAuthentication().getVoUser().getVarIPAddress()+"#"
						//+ ticket.getAuthentication().getVarUserLoginSessionId()+"#"+ticket.getAuthentication().getVarUserLoginUserAgent();
				String key = ticket.getAuthentication().getVarUserId()+"#"+ticket.getAuthentication().getVoUser().getVarIPAddress()+"#"
						+ ticket.getAuthentication().getVarUserLoginSessionId();
				this.userIPTicketCache.remove(key);
			//	System.out.println("HIS-SSO:: Ticket Registry: Ticket Removed-" + ticketId + " of Credential-"+key);
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

		final Ticket ticket = this.userTicketCache.get(userId);
		/*
		 * if (ticket == null)
		 * System.out.println("HIS-SSO:: Ticket Registry: Ticket Not Found, User-" +
		 * userId); else
		 * System.out.println("HIS-SSO:: Ticket Registry: Ticket Found, User-" + userId
		 * + " of Id-" + ticket.getTicketId());
		 */
		return ticket;
	}

	public Ticket getTicketBasedOn(final String grantingTicketId, final HISService objService)
	{
		if (grantingTicketId == null || objService==null || objService.getContext()==null)
		{
			return null;
		}

		final Ticket ticket = this.tgtServiceTicketCache.get(grantingTicketId+"#"+objService.getContext());
		/*
		 * if (ticket == null) System.out.
		 * println("HIS-SSO:: Ticket Registry: Service Ticket Not Found, TGT-" +
		 * grantingTicketId + " ,Service-" + objService.getContext()); else
		 * System.out.println("HIS-SSO:: Ticket Registry: Service Ticket Found, TGT-" +
		 * grantingTicketId + " ,Service-" + objService.getContext() + " of Id-" +
		 * ticket.getTicketId());
		 */

		return ticket;
	}

	/*public Ticket getTicketBasedOn(final String userId, final String ipAddress)
	{
		if (userId == null || ipAddress==null)
		{
			return null;
		}
		System.out.println("HIS Ticket Registry --> Retrieving Ticket By User ID & IP Address ::" + userId + " & " + ipAddress);

		final Ticket ticket = this.userIPTicketCache.get(userId+"#"+ipAddress);
		if (ticket == null)
			System.out.println("HIS Ticket Registry --> Ticket Not Found By User ID & IP Address ::" + userId + " & " + ipAddress);

		return ticket;
	}
	
	public Ticket getTicketBasedOn(final String userId, final String ipAddress,HttpSession objSession)
	{
		if (userId == null || ipAddress==null)
		{
			return null;
		}
		System.out.println("HIS Ticket Registry --> Retrieving Ticket By User ID & IP Address & User Session ::" + userId + " & " + ipAddress + " & " + objSession.getId());

		final Ticket ticket = this.userIPTicketCache.get(userId+"#"+ipAddress+"#"+objSession.getId());
		if (ticket == null)
			System.out.println("HIS Ticket Registry --> Ticket Not Found By User ID & IP Address & User Session ::" + userId + " & " + ipAddress + " & " + objSession.getId());

		return ticket;
	}*/

	public Ticket getTicketBasedOn(final String userId, final String ipAddress, final String sessionID)
	{
		if (userId == null || ipAddress==null)
		{
			return null;
		}

		String key = userId+"#"+ipAddress+"#"+sessionID;
		final Ticket ticket = this.userIPTicketCache.get(key);
		/*
		 * if (ticket == null) System.out.
		 * println("HIS-SSO:: Ticket Registry: Service Ticket Not Found, Credentials-" +
		 * key); else System.out.
		 * println("HIS-SSO:: Ticket Registry: Service Ticket Found, Credentials-" + key
		 * + " of Id-"+ ticket.getTicketId());
		 */
		return ticket;
	}
	
	/* New Methods added by Garima on 1st July 2016 for Capturing User-Agent Information*/
	
public String getAgentId(final String ticketId){
		
		if (ticketId == null)
		{
			return null;
		}
		
		final String agentId = this.agentCatche.get(ticketId);
		
	 return agentId;
		
	}
}
