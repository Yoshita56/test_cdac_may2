package hissso.client.service;

/***************************Start of Program Header ****************************
## Copyright Information				: C-DAC, Noida  
## Project Name							: Generation 5, HIS
## Name of Developer		 			: Pragya Sharma
## Module Name							: HIS Single Sign On and Web Security 
## Process/Database Object Name			: HISSSOClientServiceCLN
## Purpose								: 
## Date of Creation						:  
## Modification Log						:				
##		Modify Date				: 2016.16.05 
##		Reason	(CR/PRS)		: Session Time out Issue  
##		Modify By				: Pragya Sharma
**************************End of program*****************************/

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import application.config.HISApplicationConfig;

public class HISSSOClientServiceCLN
{

	public HISClientSO isServiceTicketExpired(HISClientSO objSO_p)
	{
		HISClientSO objHISClientSO = null;
		try
		{
			ResteasyClient client = new ResteasyClientBuilder().build();
			String uri = HISApplicationConfig.HIS_SERVICES_SERVER_URL + objSO_p.getObjService().getContext() + "/services/restful" + "/HISSSOClientService"
					+ "/isServiceTicketExpiredAtClient";
			System.out.println("HIS-SSO-SRV:: Service URI:"+uri);
			ResteasyWebTarget target = client.target(uri);
			Response response = target.request().post(Entity.entity(objSO_p, MediaType.APPLICATION_XML));
			// Read the entity
			// objHISServiceSO = response.readEntity(HISServiceSO.class);
			// objHISServiceTicket = objHISServiceSO.getObjServiceTicket();
			objHISClientSO = response.readEntity(HISClientSO.class);
			response.close();

		//	System.out.println("HIS-SSO-SRV:: Service Expiry Status-" + objHISClientSO.getActionStatus() + " of TGT-" + objSO_p.getGrantingTicketId()
			//		+ " of ST-" + objSO_p.getServiceTicketId());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			objHISClientSO = null;
		}
		return objHISClientSO;
	}

	public HISClientSO killServiceTicket(HISClientSO objSO_p)
	{
		HISClientSO objHISClientSO = null;
		try
		{

			ResteasyClient client = new ResteasyClientBuilder().build();
			String uri = HISApplicationConfig.HIS_SERVICES_SERVER_URL + objSO_p.getObjService().getContext() + "/services/restful" + "/HISSSOClientService"
					+ "/killServiceTicketAtClient";
		//	System.out.println("HIS-SSO-SRV:: Service URI:"+uri);
			ResteasyWebTarget target = client.target(uri);
			Response response = target.request().post(Entity.entity(objSO_p, MediaType.APPLICATION_XML));
			// Read the entity
			// objHISServiceSO = response.readEntity(HISServiceSO.class);
			// objHISServiceTicket = objHISServiceSO.getObjServiceTicket();
			objHISClientSO = response.readEntity(HISClientSO.class);
			response.close();
		//	System.out.println("HIS-SSO-SRV:: Service Killing Status-" + objHISClientSO.getActionStatus() + " of TGT-" + objSO_p.getGrantingTicketId()
			//		+ " of ST-" + objSO_p.getServiceTicketId());
		}
		catch (Exception e)
		{
			objHISClientSO = null;
			e.printStackTrace();
		}
		return objHISClientSO;
	}

}
