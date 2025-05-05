package in.cdac.mhealth.services;

import in.cdac.mhealth.general.business.GeneralBO;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Path("/generalService")
public class GeneralService {

	@POST
	@Path("/genderList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getGenderLists() {		
		GeneralBO objBO = new GeneralBO();
		return objBO.getGenderList();
	}
	
	@GET
	@Path("/genderList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getGenderList() {		
		GeneralBO objBO = new GeneralBO();
		return objBO.getGenderList();
	}
	
	@POST
	@Path("/stateList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getStateNames() {
		GeneralBO objBO = new GeneralBO();
		return objBO.getStateNames();
	}
	
	@GET
	@Path("/stateList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getStateNamesGet() {
		GeneralBO objBO = new GeneralBO();
		return objBO.getStateNames();
	}
	
	@POST
	@Path("/districtList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDistrictNames(@FormParam("state") String stateId) throws JSONException {
		if (stateId == null) {
			JSONArray jarr = new JSONArray();
			JSONObject jobj = new JSONObject();
			jobj.put("ID", "-1");
			jobj.put("NAME", "Select District");
			jarr.put(jobj);
			return jarr.toString();
		}
		GeneralBO objBO = new GeneralBO();
		return objBO.getDistrictNames(stateId);
	}
	
	@GET
	@Path("/districtList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDistrictNamesGet(@QueryParam("state") String stateId) throws JSONException {
		if (stateId == null) {
			JSONArray jarr = new JSONArray();
			JSONObject jobj = new JSONObject();
			jobj.put("ID", "-1");
			jobj.put("NAME", "Select District");
			jarr.put(jobj);
			return jarr.toString();
		}
		GeneralBO objBO = new GeneralBO();
		return objBO.getDistrictNames(stateId);
	}

	@GET
	@Path("/hospital/list")
	@Produces(MediaType.APPLICATION_JSON)
	public String getHospitalList(@QueryParam("hash") String hash) throws JSONException {		
		GeneralBO objBO = new GeneralBO();
		return objBO.getHospitalList(hash);
	}
	
	@POST
	@Path("/hospital/list")
	@Produces(MediaType.APPLICATION_JSON)
	public String postHospitalList(@FormParam("hash") String hash) throws JSONException {		
		GeneralBO objBO = new GeneralBO();
		return objBO.getHospitalList(hash);
	}
}
