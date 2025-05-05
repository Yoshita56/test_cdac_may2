package hissso.client.service;

/***************************Start of Program Header ****************************
## Copyright Information				: C-DAC, Noida  
## Project Name							: Generation 5, HIS
## Name of Developer		 			: Pragya Sharma
## Module Name							: HIS Single Sign On and Web Security 
## Process/Database Object Name			: HISSSOClientService
## Purpose								: 
## Date of Creation						:  
## Modification Log						:				
##		Modify Date				: 2016.16.05 
##		Reason	(CR/PRS)		: Session Time out Issue  
##		Modify By				: Pragya Sharma
**************************End of program*****************************/

import hissso.config.HISSSOSupport;
import hissso.ticket.HISServiceTicket;
import hissso.ticket.ServiceTicket;
import hissso.ticket.registry.HISTicketRegistry;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/HISSSOClientService")
public class HISSSOClientService implements HISSSOClientServiceCON
{

	@POST
	@Path("/isServiceTicketExpiredAtClient")
	@Produces({ MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_XML })
	public HISClientSO isServiceTicketExpiredAtClient(HISClientSO objSO_p, @Context HttpServletRequest objRequest)
	{
		boolean flagExpire = true;
		HISClientSO objHISClientSO = new HISClientSO();
		try
		{
			HISTicketRegistry objRegistry = HISSSOSupport.getSSORegister(objRequest);
			String strServiceTicketId = objSO_p.getServiceTicketId();
			ServiceTicket objServiceTicket = (ServiceTicket) objRegistry.getTicket(strServiceTicketId);
			if(objServiceTicket!=null)
				flagExpire = objServiceTicket.isExpired();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (flagExpire) objHISClientSO.setActionStatus("1");
			else objHISClientSO.setActionStatus("0");
		}
	//	System.out.println("HIS-SSO-CLN::Service: ST Expiry Status-" + objHISClientSO.getActionStatus() + " in TGT-" + objSO_p.getGrantingTicketId()
	//			+ " of ST-" + objSO_p.getServiceTicketId());
		return objHISClientSO;
	}

	@POST
	@Path("/killServiceTicketAtClient")
	@Produces({ MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_XML })
	public HISClientSO killServiceTicketAtClient(HISClientSO objSO_p, @Context HttpServletRequest objRequest)
	{
		HISClientSO objHISClientSO = new HISClientSO();
		objHISClientSO.setActionStatus("0");
		try
		{
			HISTicketRegistry objRegistry = HISSSOSupport.getSSORegister(objRequest);
			String strServiceTicketId = objSO_p.getServiceTicketId();
			ServiceTicket objServiceTicket = (HISServiceTicket) objRegistry.getTicket(strServiceTicketId);

			if(objServiceTicket!=null)
			{
				objServiceTicket.expire();
				objRequest.getSession().invalidate();
				objRegistry.deleteTicket(strServiceTicketId);
			}
			objHISClientSO.setActionStatus("1");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			objHISClientSO.setActionStatus("0");
		}
	//	System.out.println("HIS-SSO-CLN::Service: ST Killing Status-" + objHISClientSO.getActionStatus() + " in TGT-" + objSO_p.getGrantingTicketId()
		//			+ " of ST-" + objSO_p.getServiceTicketId());
		return objHISClientSO;
	}

	@GET
	@Path("/test")
	@Produces({ MediaType.TEXT_PLAIN })
	public String test()
	{
		//System.out.println("HIS-SSO-CLN:: Service Test");
		return "HIS-SSO-CLN:: Service Called";
	}

}
