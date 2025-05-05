package in.cdac.rajashthan.services;

import in.cdac.rajashthan.dao.HospotalMgmtDao;

import javax.ws.rs.GET; 
import javax.ws.rs.POST;
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;  
import javax.ws.rs.core.Response;

import org.json.JSONException;
@Path("/HospitalMgmtService")
public class HospitalMgmtService {

	
		@GET
		@Path("/getAllHospitalStats") 
		@Produces(MediaType.APPLICATION_JSON) 
	   public Response getAllHospitalStats(@QueryParam("ModVal") String ModVal , @QueryParam("hosp_code") String hosp_code ,@QueryParam("stateCode") String stateCode,@QueryParam("fromDate") String fromDate ,@QueryParam("toDate") String toDate) throws JSONException{ 
		   String response=null;
		   response=HospotalMgmtDao.getHospitalMgmtData(ModVal ,hosp_code, stateCode ,fromDate ,toDate);
		   return Response.status(200).entity(response).build();
		  }  
}
