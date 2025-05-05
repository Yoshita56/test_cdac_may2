package in.cdac.mhealth.opdRoster.service;

import in.cdac.mhealth.opdRoster.business.ConsultantEnquiryBO;
import in.cdac.mhealth.opdRoster.business.OPDRosterBO;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/consultant")
public class ConsultantEnquiryService {

	@POST
	@Path("/consultantByDept")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String getConsultantListbyDeptPOST(
			@FormParam("deptCode") String dept,
			@FormParam("hospCode") String hospCode)
	{

		ConsultantEnquiryBO consultantEnquiryBO = new ConsultantEnquiryBO();		
		return consultantEnquiryBO.getConsultantEnquiry(dept, hospCode);
	}

	@GET
	@Path("/consultantByDept")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String getConsultantListbyDeptGET(
			@QueryParam("deptCode") String dept,
			@QueryParam("hospCode") String hospCode
			){

		ConsultantEnquiryBO consultantEnquiryBO = new ConsultantEnquiryBO();		
		return consultantEnquiryBO.getConsultantEnquiry(dept, hospCode);
	}
}
