package hissso.services;

/***************************Start of Program Header ****************************
## Copyright Information				: C-DAC, Noida  
## Project Name							: Generation 5, HIS
## Name of Developer		 			: Pragya Sharma
## Module Name							: HIS Single Sign On and Web Security 
## Process/Database Object Name			: HISSSOServiceCLN
## Purpose								: 
## Date of Creation						:  
## Modification Log						:				
##		Modify Date				: 2016.16.05 
##		Reason	(CR/PRS)		: Session Time out Issue  
##		Modify By				: Pragya Sharma
**************************End of program*****************************/

import hissso.security.SecureCryptAlgorithm;
import hissso.ticket.HISServiceGrantTicket;
import hissso.validation.credentails.authorization.HISService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import application.config.HISApplicationConfig;

public class HISSSOServiceCLN
{
	// Authenticate Grant Ticket
	public HISServiceGrantTicket authenticate(String grantingTicketId, HISService objHISService, HttpServletRequest request)
	{
		HISServiceGrantTicket objHISGrantTicket = null;
		try
		{
		//	System.out.println("HIS-SSO-CLN:: TGT-" + grantingTicketId+ " Authenticating/Registering Service-" + objHISService.getContext());
			HISServiceSO objHISServiceSO = new HISServiceSO();
			objHISServiceSO.setVarGrantingTicketId(grantingTicketId);
			objHISServiceSO.setObjService(objHISService);

			ResteasyClient client = new ResteasyClientBuilder().build();
			String uri = HISApplicationConfig.HIS_SERVICES_SERVER_URL + HISApplicationConfig.HIS_WEB_MODULE_LOGIN + "/services/restful" + "/HISSSOService"
					+ "/authenticate/"+ SecureCryptAlgorithm.encrypt( request.getHeader("User-Agent").toLowerCase());
			ResteasyWebTarget target = client.target(uri);
			Response response = target.request().post(Entity.entity(objHISServiceSO, MediaType.APPLICATION_XML));
			// Read the entity
			// objHISServiceSO = response.readEntity(HISServiceSO.class);
			// objHISServiceTicket = objHISServiceSO.getObjServiceTicket();
			objHISGrantTicket = response.readEntity(HISServiceGrantTicket.class);
			response.close();

			/*
			 * if(objHISGrantTicket!=null) System.out.println("HIS-SSO-CLN:: TGT-" +
			 * grantingTicketId+ " Registered Service-" + objHISService.getContext()
			 * +" ST-"+objHISGrantTicket.getTicketId()); else
			 * System.out.println("HIS-SSO-CLN:: TGT-" + grantingTicketId+
			 * " Not Registered Service-" + objHISService.getContext());
			 */
		}
		catch (Exception e)
		{
			objHISGrantTicket = null;
			e.printStackTrace();
		}
		return objHISGrantTicket;
	}
}
