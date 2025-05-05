package in.cdac.mhealth.opdRoster.business;

import in.cdac.mhealth.opdRoster.dao.OPDDepartmentDao;
import in.cdac.mhealth.opdRoster.vo.Department;
import in.cdac.mhealth.opdRoster.vo.DepartmentMember;
import in.cdac.mhealth.global.util.GlobalUtils;
import in.cdac.mhealth.utility.Utility;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class OPDDepartmentBO {

	public String getDepartments(){
		OPDDepartmentDao objDepartmentDao = new OPDDepartmentDao();
		List<Department> deptList = objDepartmentDao.getDepartments(GlobalUtils.HOSPITAL_CODE);
		JSONArray jDeptArray = new JSONArray();
		for (int i=0;i<deptList.size();++i){
			JSONObject jObj = new JSONObject();
			try {
				jObj.put("DEPT_ID", String.valueOf(deptList.get(i).getDepartmentId()));
				jObj.put("DEPT_NAME", deptList.get(i).getDepartmentName());
				jDeptArray.put(i, jObj);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return jDeptArray.toString();
	}

	public String getDepartment(String deptId){
		OPDDepartmentDao objDepartmentDao = new OPDDepartmentDao();
		String dept = objDepartmentDao.getDepartment(deptId, GlobalUtils.HOSPITAL_CODE);
		dept = (dept == null) ? "" : dept;
		return dept;
	}

	public String getDepartmentDetail(String deptId){
		OPDDepartmentDao objDepartmentDao = new OPDDepartmentDao();
		Department dept = objDepartmentDao.getDepartmentDetail(Integer.parseInt(deptId), GlobalUtils.HOSPITAL_CODE);		
		JSONObject jobj = new JSONObject();
		try {
			jobj.put("D_NAME", dept.getDepartmentName());
			jobj.put("HOD", dept.getHodName());
			jobj.put("LOC", dept.getLocationName());
			jobj.put("TYPE", dept.getDepartmentType());
			List<DepartmentMember> lst = dept.getMembers();
			JSONArray jArray = new JSONArray();
			for (int i=0;i<lst.size();++i){
				DepartmentMember member = lst.get(i);
				JSONObject jobj1 = new JSONObject();
				jobj1.put("M_NAME", member.getName());
				jobj1.put("M_GENDER", member.getGender());
				jobj1.put("M_DOB", member.getDob());
				jobj1.put("M_DESIG", member.getDesignation());
				jArray.put(i, jobj1);
			}
			jobj.put("MEM", jArray);
		} catch (JSONException e){
			e.printStackTrace();			
		}
		return jobj.toString();
	}

	public String getDepartmentsByUserName(String userName){
		OPDDepartmentDao objDepartmentDao = new OPDDepartmentDao();
		List<Department>deptList = objDepartmentDao.getDepartmentsByUserName(userName, GlobalUtils.HOSPITAL_CODE);
		JSONArray jDeptArray = new JSONArray();
		for (int i=0;i<deptList.size();++i){
			JSONObject jObj = new JSONObject();
			try {
				jObj.put("DEPT_ID", String.valueOf(deptList.get(i).getDepartmentId()));
				jObj.put("DEPT_NAME", deptList.get(i).getDepartmentName());
				jDeptArray.put(i, jObj);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return jDeptArray.toString();
	}

	public String getUnitListByUserName(String userName, String hash, String hcode){
		OPDDepartmentDao objDepartmentDao = new OPDDepartmentDao();
		List<Department> deptList = objDepartmentDao.getUnitListByUserName(userName, hcode);
		JSONArray jDeptArray = new JSONArray();
		String result = "";
		for (int i=0;i<deptList.size();++i){
			JSONObject jObj = new JSONObject();
			try {
				jObj.put("DEPT_ID", String.valueOf(deptList.get(i).getDepartmentId()));
				jObj.put("DEPT_NAME", deptList.get(i).getDepartmentName());
				jDeptArray.put(i, jObj);
				result = Utility.checkForHash(jDeptArray, hash);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * Function to get list of departments for NIMS provisional registration
	 * @param hospCode
	 * @return
	 */
	public String getDepartmentsForRegistration(String hospCode) {
		OPDDepartmentDao objDepartmentDao = new OPDDepartmentDao();

		List<Department> deptList = objDepartmentDao.getDepartmentsForRegistration(hospCode);
		JSONArray jDeptArray = new JSONArray();
		for (int i=0;i<deptList.size();++i){
			JSONObject jObj = new JSONObject();
			try {
				jObj.put("DEPT_ID", String.valueOf(deptList.get(i).getDepartmentId()));
				jObj.put("DEPT_NAME", deptList.get(i).getDepartmentName());
				jDeptArray.put(i, jObj);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return jDeptArray.toString();
	}


	/**
	 * Function to get department name from department ID for NIMS provisional patient registration
	 * @param deptId
	 * @param hospId
	 * @return
	 */
	public static String getDepartmentNameFromDepartmentID(String deptId, String hospId){
		OPDDepartmentDao objDepartmentDao = new OPDDepartmentDao();
		//System.out.println("Department: "+deptId+"\t Hospital: "+hospId);
		return objDepartmentDao.getDepartmentNameFromDepartmentID(deptId, hospId);
	}
	
	
	/**
	 * Function to get patient payment categories for NIMS provisional patient registration
	 * @param hospCode
	 * @return
	 */
	public String getCategoriesForRegistration(String hospCode) {
		OPDDepartmentDao objDepartmentDao = new OPDDepartmentDao();

		List<Department> deptList = objDepartmentDao.getCategoriesForRegistration(hospCode);
		JSONArray jDeptArray = new JSONArray();
		for (int i=0;i<deptList.size();++i){
			JSONObject jObj = new JSONObject();
			try {
				jObj.put("CAT_ID", String.valueOf(deptList.get(i).getDepartmentId()));
				jObj.put("CAT_NAME", deptList.get(i).getDepartmentName());
				jDeptArray.put(i, jObj);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return jDeptArray.toString();
	}
}
