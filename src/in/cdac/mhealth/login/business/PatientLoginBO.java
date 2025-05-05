package in.cdac.mhealth.login.business;

import in.cdac.mhealth.login.dao.PatientLoginDao;
import in.cdac.mhealth.login.vo.PatientsVO;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class PatientLoginBO {

	public String getOTP(String mobileNo, String hcode) {
		PatientLoginDao patientLoginDAO=new PatientLoginDao();
		PatientsVO patientsVO= patientLoginDAO.getOTPforPatient(mobileNo, hcode);
		JSONObject jFinalObj = null;
		try {
			JSONArray jPatientsArray = new JSONArray();

			for (int i=0;i<patientsVO.getPatientsVO().size();i++){
				JSONObject jObj = new JSONObject();		
				jObj.put("crno", patientsVO.getPatientsVO().get(i).getCrNo());
				jObj.put("mobileNo", patientsVO.getPatientsVO().get(i).getMobileNo());
				jObj.put("patName", patientsVO.getPatientsVO().get(i).getPatientName());
				jObj.put("patientHasWallet", patientsVO.getPatientsVO().get(i).getPatientHasWallet());
				jPatientsArray.put(i, jObj);
			}

			jFinalObj= new JSONObject();		
			jFinalObj.put("OTP",patientsVO.getOTP());
			jFinalObj.put("patientdetails", jPatientsArray);
		}catch (JSONException e){
			e.printStackTrace();
			return "{\"valid\": \"0\"}";
		}
		return jFinalObj.toString();
	}
	
	
	
	
	
	
	public String getOTPFromCr(String crno, String hcode) {
		PatientLoginDao patientLoginDAO=new PatientLoginDao();
		PatientsVO patientsVO= patientLoginDAO.getOTPforPatientUsingCr(crno, hcode);
		JSONObject jFinalObj = null;
		try {
			JSONArray jPatientsArray = new JSONArray();

			for (int i=0;i<patientsVO.getPatientsVO().size();i++){
				JSONObject jObj = new JSONObject();		
				jObj.put("crno", patientsVO.getPatientsVO().get(i).getCrNo());
				jObj.put("mobileNo", patientsVO.getPatientsVO().get(i).getMobileNo());
				jObj.put("patName", patientsVO.getPatientsVO().get(i).getPatientName());
				jObj.put("patientHasWallet", patientsVO.getPatientsVO().get(i).getPatientHasWallet());
				jPatientsArray.put(i, jObj);
			}

			jFinalObj= new JSONObject();		
			jFinalObj.put("OTP",patientsVO.getOTP());
			jFinalObj.put("patientdetails", jPatientsArray);
		}catch (JSONException e){
			e.printStackTrace();
			return "{\"valid\": \"0\"}";
		}
		return jFinalObj.toString();
	}
	
	
	
	
	
}
