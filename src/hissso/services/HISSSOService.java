package hissso.services;

/***************************Start of Program Header ****************************
## Copyright Information				: C-DAC, Noida  
## Project Name							: Generation 5, HIS
## Name of Developer		 			: Pragya Sharma
## Module Name							: HIS Single Sign On and Web Security 
## Process/Database Object Name			: HISSSOService
## Purpose								: 
## Date of Creation						:  
## Modification Log						:				
##		Modify Date				: 2016.16.05 
##		Reason	(CR/PRS)		: Session Time out Issue  
##		Modify By				: Pragya Sharma
**************************End of program*****************************/

import hissso.config.HISSSOSupport;
import hissso.security.SecureCryptAlgorithm;
import hissso.ticket.HISServiceGrantTicket;
import hissso.ticket.TicketGrantingTicket;
import hissso.ticket.expiration.ServiceTicketExpiration;
import hissso.ticket.registry.HISTicketRegistry;
import hissso.validation.credentails.authorization.HISService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/HISSSOService")
public class HISSSOService implements HISSSOServiceCON
{

	@POST
	@Path("/authenticate/{agentId}")
	@Consumes({ MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_XML })
	public HISServiceGrantTicket authenticate(HISServiceSO objHISServiceSO, @Context HttpServletRequest objRequest, @PathParam("agentId") String agentId)
	{
		HISServiceGrantTicket objHISGrantTicket = null;
		try
		{
			String strGrantingTicketId = objHISServiceSO.getVarGrantingTicketId();
			HISService objHISService = objHISServiceSO.getObjService();
		//	System.out.println("HIS-SSO-SRV::Service: Authenticating Service Context-" + objHISService.getContext()+" Granting Ticket Id-" + strGrantingTicketId);

			HISTicketRegistry registry = HISSSOSupport.getSSORegister(objRequest);
			
			String userAgentId = SecureCryptAlgorithm.decrypt(agentId)
					.replace("& #40;", "(").replace("& #41;", ")");

			String catchedAgentId = registry.getAgentId(strGrantingTicketId);

			catchedAgentId = SecureCryptAlgorithm.decrypt(catchedAgentId);

			
		//System.out.println("userAgentId :: "+userAgentId);
		//	System.out.println("catchedAgentId :: "+catchedAgentId);
			
			if (catchedAgentId != null) {

				if (!catchedAgentId.equals(userAgentId))
					return null;

			}
			TicketGrantingTicket objTicketGrantingTicket = (TicketGrantingTicket) registry.getTicket(strGrantingTicketId);
			
			if (objTicketGrantingTicket != null)
			{
				// Check Is Ticket already present for the Service within given TGT
				objHISGrantTicket = (HISServiceGrantTicket) registry.getTicketBasedOn(strGrantingTicketId, objHISService);
				if(objHISGrantTicket==null)
				{
					objHISGrantTicket = (HISServiceGrantTicket) objTicketGrantingTicket.grantServiceTicket(objHISService, new ServiceTicketExpiration(null));
					// Adding Grant Ticket to Registry
					 //registry.addTicket(objHISGrantTicket);
					registry.addTicket(objHISGrantTicket , agentId);
				}
			//	System.out.println("HIS-SSO-SRV::Service: Grant Ticket ID-" + objHISGrantTicket.getTicketId());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		}
		return objHISGrantTicket;
	}


	@GET
	@Path("/test")
	@Produces({ MediaType.TEXT_PLAIN })
	public String test()
	{
		//System.out.println("HIS-SSO-SRV::Service test");

		return "called";
	}
}
