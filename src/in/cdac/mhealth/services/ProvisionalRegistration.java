package in.cdac.mhealth.services;

import in.cdac.mhealth.provisionalRegistration.business.ProvisionalRegistrationBO;
import in.cdac.mhealth.provisionalRegistration.vo.PatientInfo;
import in.cdac.mhealth.utility.Utility;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

@Path("/registration")
public class ProvisionalRegistration {
	
	private static final int RELATION_NAME_LENGTH = 60;
	private static final int NAME_LENGTH = 33;
	
	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	public String registerPatient(MultivaluedMap<String, String> formParams) {
		PatientInfo objPatientInfo = new PatientInfo();
		Utility.populateFromParamMap(formParams, objPatientInfo);
		ProvisionalRegistrationBO objBO = new ProvisionalRegistrationBO();
		return objBO.registerPatient(objPatientInfo);
	}
	
	@POST
	@Path("/aadhaarRegister")
	@Produces(MediaType.APPLICATION_JSON)
	public String registerPatientWithAadhaar(MultivaluedMap<String, String> formParams) {
		PatientInfo objPatientInfo = new PatientInfo();
		Utility.populateFromParamMap(formParams, objPatientInfo);
		if (objPatientInfo.getFatherName().length() > RELATION_NAME_LENGTH) {
			objPatientInfo.setFatherName(objPatientInfo.getFatherName().substring(0, RELATION_NAME_LENGTH-1));
		}
		String[] name = objPatientInfo.getFirstName().split(" ");
		objPatientInfo.setFirstName(name[0].length() > NAME_LENGTH?name[0].substring(0, NAME_LENGTH-1):name[0]);
		if (name.length >= 2) {
			String s = "";
			int i=1;
			for (;i<name.length-1;++i) {
				s += name[i] + " ";
			}
			if (s.length() > 2) {
				s = s.substring(0, s.length()-1);
			}
			objPatientInfo.setMiddleName(s.length() > NAME_LENGTH ? s.substring(0, NAME_LENGTH-1) : s);
			objPatientInfo.setLastName(name[i].length() > NAME_LENGTH?name[i].substring(0, NAME_LENGTH-1):name[i]);
		}
		ProvisionalRegistrationBO objBO = new ProvisionalRegistrationBO();
		return objBO.registerPatient(objPatientInfo);
	}
}
