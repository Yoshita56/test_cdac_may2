package in.cdac.mhealth.opdRoster.business;

import in.cdac.mhealth.global.util.GlobalUtils;
import in.cdac.mhealth.opdRoster.dao.OPDRosterDao;
import in.cdac.mhealth.opdRoster.dao.OPDRosterDaoi;
import in.cdac.mhealth.opdRoster.vo.Department;
import in.cdac.mhealth.opdRoster.vo.Room;
import in.cdac.mhealth.opdRoster.vo.RosterInfo;
import in.cdac.mhealth.opdRoster.vo.ShiftType;
import in.cdac.mhealth.opdRoster.vo.Unit;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class OPDRosterBO {
	
	public String getSiftType(String date){
		
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(date.substring(6, 10)), Integer.parseInt(date.substring(3, 5)) - 1, Integer.parseInt(date.substring(0, 2)));
		Date dt = new Date(cal.getTimeInMillis());
		
		OPDRosterDaoi objRosterDao = new OPDRosterDao(); 
		List<ShiftType> shiftList = objRosterDao.getSiftType(GlobalUtils.HOSPITAL_CODE, dt);
		JSONArray jarray = new JSONArray();
		try{
			for (int i=0;i<shiftList.size();++i){
				JSONObject jObj = new JSONObject();
				jObj.put("ID", shiftList.get(i).getShiftCode());
				jObj.put("TYPE", shiftList.get(i).getShiftName());
				jarray.put(i, jObj);
			}
		} catch (JSONException e){
			e.printStackTrace();
		}
		
		return jarray.toString();
	}
	
	public String getDepartment(String date, String shift){
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(date.substring(6, 10)), Integer.parseInt(date.substring(3, 5)) - 1, Integer.parseInt(date.substring(0, 2)));
		Date dt = new Date(cal.getTimeInMillis());
		
		OPDRosterDaoi objRosterDao = new OPDRosterDao(); 
		List<Department> lst = objRosterDao.getDepartment(GlobalUtils.HOSPITAL_CODE, dt, Integer.parseInt(shift));
		JSONArray jarray = new JSONArray();
		try{
			for (int i=0;i<lst.size();++i){
				JSONObject jObj = new JSONObject();
//				jObj.put("ID", lst.get(i).getDeptCode());
//				jObj.put("NAME", lst.get(i).getDeptName());
				jarray.put(i, jObj);
			}
		} catch (JSONException e){
			e.printStackTrace();
		}
		
		return jarray.toString();
	}
	
	public String getUnit(String date, String shift, String dept){
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(date.substring(6, 10)), Integer.parseInt(date.substring(3, 5)) - 1, Integer.parseInt(date.substring(0, 2)));
		Date dt = new Date(cal.getTimeInMillis());
						
		OPDRosterDaoi objRosterDao = new OPDRosterDao(); 
		List<Unit> lst = objRosterDao.getUnit(GlobalUtils.HOSPITAL_CODE, dt, Integer.parseInt(shift), Integer.parseInt(dept));
		JSONArray jarray = new JSONArray();
		try{
			for (int i=0;i<lst.size();++i){
				JSONObject jObj = new JSONObject();
				jObj.put("ID", lst.get(i).getUnitCode());
				jObj.put("NAME", lst.get(i).getUnitName());
				jarray.put(i, jObj);
			}
		} catch (JSONException e){
			e.printStackTrace();
		}
		
		return jarray.toString();
	}
	
	public String getRoom(String date, String shift, String dept, String unit) {
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(date.substring(6, 10)), Integer.parseInt(date.substring(3, 5)) - 1, Integer.parseInt(date.substring(0, 2)));
		Date dt = new Date(cal.getTimeInMillis());
		
		OPDRosterDaoi objRosterDao = new OPDRosterDao(); 
		List<Room> lst = objRosterDao.getRoom(GlobalUtils.HOSPITAL_CODE, dt, Integer.parseInt(shift), Integer.parseInt(dept), Integer.parseInt(unit));
		JSONArray jarray = new JSONArray();
		try{
			for (int i=0;i<lst.size();++i){
				JSONObject jObj = new JSONObject();
				jObj.put("ID", lst.get(i).getRoomCode());
				jObj.put("NAME", lst.get(i).getRoomName());
				jarray.put(i, jObj);
			}
		} catch (JSONException e){
			e.printStackTrace();
		}
		
		return jarray.toString();
	}
	
	
	
	public String getRosteDeptWise(String dept, String hospCode){
		
		//Calendar cal = Calendar.getInstance();
		//cal.set(Integer.parseInt(date.substring(6, 10)), Integer.parseInt(date.substring(3, 5)) - 1, Integer.parseInt(date.substring(0, 2)));
		//Date dt = new Date(cal.getTimeInMillis());
		//if (!dept.equalsIgnoreCase("0"))
		//dept=dept.substring(0, 3);
		
		OPDRosterDaoi objRosterDao = new OPDRosterDao();
		List<RosterInfo> lst = objRosterDao.getRosterDeptWise(Integer.parseInt(dept),Integer.parseInt(hospCode));
		JSONArray jarray = new JSONArray();
		try{
			for (int i=0;i<lst.size();++i){
				JSONObject jObj = new JSONObject();
				RosterInfo obj = lst.get(i);
				
				
				jObj.put("DEPT", obj.getDepartment());
				jObj.put("UNIT", obj.getUnit());
				jObj.put("UNIT_TYPE", obj.getRosterType());
				jObj.put("LOCATION", obj.getLocation());
				jObj.put("ROOM", obj.getRoom());
				jObj.put("OPD_TIME", obj.getOpdTime());
				jObj.put("DAYS", obj.getDays());
				jObj.put("HEADOFUNIT", obj.getOpdName());
				jObj.put("CONSULTANT", obj.getConsultant());
				jarray.put(i, jObj);
				/*jObj.put("DEPT", obj.getDepartment());
				jObj.put("UNIT", obj.getUnit());
				jObj.put("TYPE", obj.getType());
				jObj.put("FROM_TM", obj.getFromTime());
				jObj.put("TO_TM", obj.getToTime());
				jarray.put(i, jObj);*/
			}
		} catch (JSONException e){
			e.printStackTrace();
		}
		
		return jarray.toString();
	}
	
	public String getRoster(String date, String type, String dept, String unit, String room){
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(date.substring(6, 10)), Integer.parseInt(date.substring(3, 5)) - 1, Integer.parseInt(date.substring(0, 2)));
		Date dt = new Date(cal.getTimeInMillis());
		
		OPDRosterDaoi objRosterDao = new OPDRosterDao();
		List<RosterInfo> lst = objRosterDao.getRoster(dt,													  
													  Integer.parseInt(type),
													  Integer.parseInt(dept),
													  Integer.parseInt(unit),
													  Integer.parseInt(room),
													  GlobalUtils.HOSPITAL_CODE);
		JSONArray jarray = new JSONArray();
		try{
			for (int i=0;i<lst.size();++i){
				JSONObject jObj = new JSONObject();
				RosterInfo obj = lst.get(i);
				jObj.put("DEPT", obj.getDepartment());
				jObj.put("UNIT", obj.getUnit());
				jObj.put("TYPE", obj.getType());
				jObj.put("FROM_TM", obj.getFromTime());
				jObj.put("TO_TM", obj.getToTime());
				jarray.put(i, jObj);
			}
		} catch (JSONException e){
			e.printStackTrace();
		}
		
		return jarray.toString();
	}
	
	public String getDoctorAvailability(String date, String docName){
		Date dt = null;
		
		if (!date.equals("")){
			Calendar cal = Calendar.getInstance();
			cal.set(Integer.valueOf(date.substring(6, 10)), Integer.valueOf(date.substring(3, 5)) - 1, Integer.valueOf(date.substring(0, 2)));
			dt = new Date(cal.getTimeInMillis());
		}
		
		OPDRosterDaoi objRosterDao = new OPDRosterDao();
		List<RosterInfo> lst = objRosterDao.getDoctorAvailability(dt, docName, GlobalUtils.HOSPITAL_CODE);
		
		JSONArray jarray = new JSONArray();
		
		try{
			for (int i=0;i<lst.size();++i){
				JSONObject jObj = new JSONObject();
				RosterInfo obj = lst.get(i);
				jObj.put("DEPT", obj.getDepartment());
				jObj.put("UNIT", obj.getUnit());
				jObj.put("TYPE", obj.getType());
				jObj.put("DOC_NAME", obj.getDocName());
				jObj.put("DAYS", obj.getWorkingDays());
				jObj.put("FROM_TM", obj.getFromTime());
				jObj.put("TO_TM", obj.getToTime());
				jarray.put(i, jObj);
			}
		} catch (JSONException e){
			e.printStackTrace();
		}
		
		return jarray.toString();
	}
	
}
