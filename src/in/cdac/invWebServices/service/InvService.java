package in.cdac.invWebServices.service;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import in.cdac.invWebServices.general.business.GeneralBO;

@Path("/invService")
public class InvService {

	@POST
	@Path("/genderList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getGenderLists() {		
		GeneralBO objBO = new GeneralBO();
		//return objBO.getGenderList();
		return "Rishubh";
	}
	
	@GET
	@Path("/genderList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getGenderList() {		
		GeneralBO objBO = new GeneralBO();
		return objBO.getGenderList();
	}
	
	
	@POST
	@Path("/reportList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getReportLists(@FormParam("crNo") String crNo,@FormParam("hosCode") String hosCode) {		
		GeneralBO objBO = new GeneralBO();
		return objBO.getReportList(crNo,hosCode);
	}
	
	@GET
	@Path("/reportList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getReportList(@QueryParam("crNo") String crNo,@QueryParam("hosCode") String hosCode) {		
		GeneralBO objBO = new GeneralBO();
		return objBO.getReportList(crNo,hosCode);
	}
	

	
	@POST
	@Path("/investigationDataList")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getInvestigationDataLists(@FormParam("crNo") String crNo,@FormParam("hosCode") String hosCode) {		
		GeneralBO objBO = new GeneralBO();
		//return objBO.getInvestigationDataList(crNo,hosCode);
		 return Response.status(200).entity(objBO.getInvestigationDataList(crNo,hosCode)).build();
	}
	
	@GET
	@Path("/investigationDataList")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getInvestigationDataList(@QueryParam("crNo") String crNo,@QueryParam("hosCode") String hosCode) {		
		GeneralBO objBO = new GeneralBO();
		//return objBO.getInvestigationDataList(crNo,hosCode);
		 return Response.status(200).entity(objBO.getInvestigationDataList(crNo,hosCode)).build();
	}
	
	
	
	@POST
	@Path("/reportData")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReportDatas(@FormParam("crNo") String crNo,@FormParam("reqDNo") String reqDNo,@FormParam("hosCode") String hosCode) {		
		GeneralBO objBO = new GeneralBO();
		//return objBO.getReportData(crNo,reqDNo,hosCode);
		return Response.status(200).entity(objBO.getReportData(crNo,reqDNo,hosCode)).build();
	}
	
	@GET
	@Path("/reportData")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReportData(@QueryParam("crNo") String crNo,@QueryParam("reqDNo") String reqDNo,@QueryParam("hosCode") String hosCode) {		
		GeneralBO objBO = new GeneralBO();
		//return objBO.getReportData(crNo,reqDNo,hosCode);
		return Response.status(200).entity(objBO.getReportData(crNo,reqDNo,hosCode)).build();
	}
	
	
	@POST
	@Path("/paraRawData")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getparaRawDatas(@FormParam("crNo") String crNo,@FormParam("hosCode") String hosCode,@FormParam("paraCode") String paraCode) {		
		GeneralBO objBO = new GeneralBO();
	//	System.out.println("paraCode "+paraCode);
		//return objBO.getInvestigationDataList(crNo,hosCode);
		 return Response.status(200).entity(objBO.getParaRawData(crNo,hosCode,paraCode)).build();
	}
	
	@GET
	@Path("/paraRawData")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getparaRawData(@QueryParam("crNo") String crNo,@QueryParam("hosCode") String hosCode,@QueryParam("paraCode") String paraCode) {		
		GeneralBO objBO = new GeneralBO();
	//	System.out.println("paraCode "+paraCode);
		//return objBO.getInvestigationDataList(crNo,hosCode);
		 return Response.status(200).entity(objBO.getParaRawData(crNo,hosCode,paraCode)).build();
	}
	
}
