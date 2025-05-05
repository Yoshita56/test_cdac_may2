package in.cdac.mhealth.opdRoster.business;

import in.cdac.mhealth.opdRoster.dao.ConsultantEnquiryDAO;
import in.cdac.mhealth.opdRoster.vo.ConsultantEnquiryVO;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class ConsultantEnquiryBO {

	public String getConsultantEnquiry(String deptCode, String hcode){

		JSONArray jEnquiryArray = new JSONArray();

		try{
			ConsultantEnquiryDAO consultantEnquiryDAO = new ConsultantEnquiryDAO();
			ArrayList<ConsultantEnquiryVO> consultantEnquiryVOs = consultantEnquiryDAO.getConsultantEnquiry(deptCode, hcode);
			for (int i=0;i<consultantEnquiryVOs.size();i++){
				JSONObject jObj = new JSONObject();		
				jObj.put("deptCode", consultantEnquiryVOs.get(i).getDeptCode());		
				jObj.put("deptName", consultantEnquiryVOs.get(i).getDeptName());		
				jObj.put("deptUnitCode", consultantEnquiryVOs.get(i).getDeptUnitCode());		
				jObj.put("unitName", consultantEnquiryVOs.get(i).getUnitName());		
				jObj.put("roomCode", consultantEnquiryVOs.get(i).getRoomCode());		
				jObj.put("roomName", consultantEnquiryVOs.get(i).getRoomName());		
				jObj.put("opdName", consultantEnquiryVOs.get(i).getOpdName());		
				jObj.put("unitDays", consultantEnquiryVOs.get(i).getUnitDays());		
				jObj.put("shiftTime", consultantEnquiryVOs.get(i).getShiftTime());		
				jObj.put("rosterType", consultantEnquiryVOs.get(i).getRoster());				
				jEnquiryArray.put(i, jObj);
			}

		}catch (JSONException e){
			e.printStackTrace();
			return "{\"valid\": \"0\"}";
		}
		return jEnquiryArray.toString();
	}
}
