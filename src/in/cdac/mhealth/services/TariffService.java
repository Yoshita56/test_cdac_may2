package in.cdac.mhealth.services;

import in.cdac.mhealth.login.business.TariffBO;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/tariff")
public class TariffService {
	
	@POST
	@Path("/tariffList")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String getTariffsListPOST(
			@FormParam("hospCode") String hospCode)
	{

		TariffBO tariffBO = new TariffBO();		
		return tariffBO.getTariffsList(hospCode);
	}

	@GET
	@Path("/tariffList")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String getTariffsListGET(
			@QueryParam("hospCode") String hospCode
			){

		TariffBO tariffBO = new TariffBO();		
		return tariffBO.getTariffsList(hospCode);
	}

}
