package in.cdac.mhealth.provisionalRegistration.business;

import in.cdac.mhealth.provisionalRegistration.dao.ProvisionalRegistrationDao;
import in.cdac.mhealth.provisionalRegistration.vo.PatientInfo;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class ProvisionalRegistrationBO {

	public String registerPatient (PatientInfo objPatientInfo){
		ProvisionalRegistrationDao objDao = new ProvisionalRegistrationDao();
		objDao.registerPatient(objPatientInfo);
		JSONObject jobj = new JSONObject();
		try {
			jobj.put("SUCCESS", objPatientInfo.isRegisterSuccessful());
			jobj.put("CRNO", objPatientInfo.getCrNo());
			jobj.put("QUEUE", objPatientInfo.getQueueNo());
			jobj.put("msg", objPatientInfo.getMessage());
		} catch (JSONException e){
			e.printStackTrace();
		}
		return jobj.toString();
	}
}
