package in.cdac.mhealth.login.business;

import in.cdac.mhealth.login.dao.LoginDao;
import in.cdac.mhealth.login.vo.LoginVO;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class LoginBO {

	public String checkLogin(String userName, String passWord, String salt, String hcode) {
		LoginDao objLoginDao = new LoginDao();
		LoginVO objLoginVO = new LoginVO(userName, passWord);
		objLoginVO.setSalt(salt);
		objLoginDao.checkLogin(objLoginVO, hcode);
		JSONObject jObj = new JSONObject();
		try {
			jObj.put("valid", objLoginVO.getValid());
			jObj.put("username", objLoginVO.getUserName());
			jObj.put("userdisplayname", objLoginVO.getUserDisplayName() == null ? "" : objLoginVO.getUserDisplayName());
			jObj.put("userseatid",objLoginVO.getSeatId());
			jObj.put("pkgname", objLoginVO.getAccessiblePackage());
			jObj.put("manupdate", objLoginVO.getMandatoryUpdatePackage());
			jObj.put("update", objLoginVO.getUpdatePackage());
		}catch (JSONException e){
			e.printStackTrace();
			return "{\"valid\": \"0\"}";
		}
		return jObj.toString();
	}
}
