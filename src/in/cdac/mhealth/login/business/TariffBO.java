package in.cdac.mhealth.login.business;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import in.cdac.mhealth.login.vo.TariffVO;
import in.cdac.mhealth.login.dao.TariffDAO;

public class TariffBO {

	public String getTariffsList(String hcode){
		TariffDAO tariffDAO = new TariffDAO();
		ArrayList<TariffVO> tariffVOs = tariffDAO.getTariffs(hcode);
		JSONArray jTariffsArray = new JSONArray();
		try{

			for(int i=0; i<tariffVOs.size(); i++){
				JSONObject jObj = new JSONObject();		
				if (tariffVOs.get(i).getPatientCategory()!=null){
					jObj.put("patCategory", tariffVOs.get(i).getPatientCategory());
				}else{
					jObj.put("patCategory", "");
				}
				if (tariffVOs.get(i).getChargeType()!=null){
					jObj.put("chargeType", tariffVOs.get(i).getChargeType());
				}else{
					jObj.put("chargeType", "");
				}
				if (tariffVOs.get(i).getTariffName()!=null){
					jObj.put("tariffName", tariffVOs.get(i).getTariffName());
				}else{
					jObj.put("tariffName", "");
				}
				if (tariffVOs.get(i).getTariffCharge()!=null){
					jObj.put("tariffCharge", tariffVOs.get(i).getTariffCharge());
				}else{
					jObj.put("tariffCharge", "");
				}
				if (tariffVOs.get(i).getTariffServiceID()!=null){
					jObj.put("tariffServiceID", tariffVOs.get(i).getTariffServiceID());
				}else{
					jObj.put("tariffServiceID", "");
				}
				jTariffsArray.put(i, jObj);
			}
		}catch (JSONException e){
			e.printStackTrace();
			return "{\"valid\": \"0\"}";
		}
		return jTariffsArray.toString();
	}
}