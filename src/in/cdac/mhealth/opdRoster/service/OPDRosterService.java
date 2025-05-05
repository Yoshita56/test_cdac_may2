package in.cdac.mhealth.opdRoster.service;

import in.cdac.mhealth.opdRoster.business.OPDRosterBO;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/opdRoster")
public class OPDRosterService {
	
	
	@POST
	@Path("/rosterDeptWiseOnDate")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String getRosterr(
		                	 @FormParam("deptCode") String dept,
		                	 @FormParam("hospCode") String hospCode)
		{
		
		OPDRosterBO objRosterBO = new OPDRosterBO();		
		return objRosterBO.getRosteDeptWise(dept, hospCode);
	}
	
	@GET
	@Path("/rosterDeptWiseOnDate")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String getRoster1(
			@QueryParam("deptCode") String dept,
			@QueryParam("hospCode") String hospCode
			){
		
		OPDRosterBO objRosterBO = new OPDRosterBO();		
		return objRosterBO.getRosteDeptWise(dept, hospCode);
	}

	@POST
	@Path("/rosterOnDate")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String getRoster2(@FormParam("dt") String date,
							@FormParam("type") String shiftType,
							@FormParam("dept") String dept,
							@FormParam("unit") String unit,
							@FormParam("room") String room){
		if (date == null)
			return "{\"error\": \"Null Parameter\"}";
		OPDRosterBO objRosterBO = new OPDRosterBO();		
		return objRosterBO.getRoster(date, shiftType, dept, unit, room);
	}
	
	@GET
	@Path("/rosterOnDate")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String getRoster3(@QueryParam("dt") String date,
			@QueryParam("type") String shiftType,
			@QueryParam("dept") String dept,
			@QueryParam("unit") String unit,
			@QueryParam("room") String room){
		if (date == null)
			return "{\"error\": \"Null Parameter\"}";
		OPDRosterBO objRosterBO = new OPDRosterBO();		
		return objRosterBO.getRoster(date, shiftType, dept, unit, room);
	}
	
	@POST
	@Path("/shiftTypeList")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String getSiftType(@FormParam("date") String date){
		OPDRosterBO objRosterBO = new OPDRosterBO();
		return objRosterBO.getSiftType(date);
	}
	
	@POST
	@Path("/deptList")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String getDepartment(@FormParam("date") String date,
								@FormParam("shift") String shift){
		if (date == null)
			return "{\"error\": \"Null Parameter\"}";
		OPDRosterBO objRosterBO = new OPDRosterBO();
		return objRosterBO.getDepartment(date, shift);
	}
	
	@POST
	@Path("/unitList")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String getUnit(@FormParam("date") String date,
				    	  @FormParam("shift") String shift,
						  @FormParam("dept") String dept){
		if (date == null || shift == null || dept == null)
			return "{\"error\": \"Null Parameter\"}";
		OPDRosterBO objRosterBO = new OPDRosterBO();
		return objRosterBO.getUnit(date, shift, dept);
	}
	
	@POST
	@Path("/roomList")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String getRoom(@FormParam("date") String date,
	    	  			  @FormParam("shift") String shift,
	    	  			  @FormParam("dept") String dept,
	    	  			  @FormParam("unit") String unit){
		if (date == null || shift == null || dept == null || unit == null)
			return "{\"error\": \"Null Parameter\"}";
		OPDRosterBO objRosterBO = new OPDRosterBO();
		return objRosterBO.getRoom(date, shift, dept, unit);
	}
	
	@POST
	@Path("/doctorAvail")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String getRoster(@FormParam("dt") String date,
							@FormParam("doc") String docName){
		OPDRosterBO objRosterBO = new OPDRosterBO();
		return objRosterBO.getDoctorAvailability(date, docName);
	}
}
