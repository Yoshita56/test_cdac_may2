package in.cdac.mhealth.opdRoster.dao;

import in.cdac.mhealth.global.util.GlobalUtils;
import in.cdac.mhealth.opdRoster.vo.Department;
import in.cdac.mhealth.opdRoster.vo.Room;
import in.cdac.mhealth.opdRoster.vo.RosterInfo;
import in.cdac.mhealth.opdRoster.vo.ShiftType;
import in.cdac.mhealth.opdRoster.vo.Unit;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OPDRosterDao implements OPDRosterDaoi {

	public List<ShiftType> getSiftType(int hospitalCode, Date dt){
		
		Connection con = null;
		
		String propertiesFileName = "in.cdac.mhealth.query";
		String queryKey = "DUTY_ROSTER_SERVICE_GET_SHIFT_TYPE";
		String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
		
		List<ShiftType> shiftList = new ArrayList<ShiftType>();
		
		try {
			con = GlobalUtils.getNimsConnection();		
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, hospitalCode);
			stmt.setInt(2, hospitalCode);
			stmt.setDate(3, dt);
			stmt.setDate(4, dt);
			ResultSet rs =  stmt.executeQuery();
			while (rs.next()){
				shiftList.add(new ShiftType(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if (con != null) 
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return shiftList;
	}
	
	public List<Department> getDepartment(int hospitalCode, Date dt, int shift){
		
		Connection con = null;
		
		String propertiesFileName = "in.cdac.mhealth.query";
		String queryKey = "DUTY_ROSTER_SERVICE_GET_DEPARTMENT";
		String queryKeyWithShift = "DUTY_ROSTER_SERVICE_GET_DEPARTMENT_WITH_SHIFT";
		String query = "";
		if (shift == -1)
			query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
		else
			query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKeyWithShift);
		
		List<Department> lst = new ArrayList<Department>();
		
		try {
			con = GlobalUtils.getNimsConnection();		
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, hospitalCode);
			stmt.setDate(2, dt);
			stmt.setDate(3, dt);
			if (shift != -1){
				stmt.setInt(4, shift);
			}
			ResultSet rs =  stmt.executeQuery();
			while (rs.next()){
				lst.add(new Department(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if (con != null) 
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lst;
	}
	
	public List<Unit> getUnit(int hospitalCode, Date dt, int shift, int dept){
		
		Connection con = null;
		
		String propertiesFileName = "in.cdac.mhealth.query";
		String queryKey = "DUTY_ROSTER_SERVICE_GET_UNIT";
		String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
		
		List<Unit> lst = new ArrayList<Unit>();
		
		try {
			con = GlobalUtils.getNimsConnection();		
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, hospitalCode);
			stmt.setInt(2, hospitalCode);
			stmt.setDate(3, dt);
			stmt.setDate(4, dt);
			stmt.setInt(5, dept);
			ResultSet rs =  stmt.executeQuery();
			while (rs.next()){
				lst.add(new Unit(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if (con != null) 
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lst;
	}
	
	public List<Room> getRoom(int hospitalCode, Date dt, int shift, int dept, int unit){
		
		Connection con = null;
		
		String propertiesFileName = "in.cdac.mhealth.query";
		String queryKey = "DUTY_ROSTER_SERVICE_GET_ROOM";
		String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
		
		List<Room> lst = new ArrayList<Room>();
		
		try {
			con = GlobalUtils.getNimsConnection();		
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, hospitalCode);
			stmt.setInt(2, hospitalCode);
			stmt.setDate(3, dt);
			stmt.setDate(4, dt);
			stmt.setInt(5, dept);
			stmt.setInt(6, unit);
			ResultSet rs =  stmt.executeQuery();
			while (rs.next()){
				lst.add(new Room(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if (con != null) 
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lst;
	}
	
	
	
	
	public List<RosterInfo> getRosterDeptWise(int dept,int hospitalCode) {
		Connection con = null;
		
		String propertiesFileName = "in.cdac.mhealth.query";
		String queryKey = "OPD_ROSTER_SERVICE_GET_ROSTER_DEPTWISE";
		String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
		
		String condition = " ";
		
		
		
		if (dept != 0){
			condition += " and gnum_dept_code = " + dept;
			
		}
		
		query = query.replaceFirst("--condition--", condition);
		 
		List<RosterInfo> lst = new ArrayList<RosterInfo>();
		
		try {
			con = GlobalUtils.getNimsConnection();		
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, hospitalCode);
			//stmt.setString(2, date);
			//stmt.setString(3, date);
			//stmt.setInt(4, hospitalCode);
			//stmt.setInt(5, hospitalCode);
//			System.out.println("query_opdRoster final----->"+stmt.toString());
			ResultSet rs =  stmt.executeQuery();
			while (rs.next()){
				RosterInfo obj = new RosterInfo();
				
				obj.setDepartment(rs.getString(2));
				obj.setRoom(rs.getString(6));
				obj.setConsultant(rs.getString(11));
				obj.setOpdTime(rs.getString(9));
				obj.setUnit(rs.getString(4));
				obj.setDays(rs.getString(8));
				obj.setRosterType(rs.getString(10));
				obj.setOpdName(rs.getString(7));
				obj.setLocation(rs.getString(12));
				
				/*obj.setType(rs.getString(2));
				obj.setFromTime(rs.getString(3));
				obj.setToTime(rs.getString(4));
				obj.setWorkingDays(rs.getString(7));
				*/
				lst.add(obj);
				}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if (con != null) 
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lst;
	}

	@Override
	public List<RosterInfo> getRoster(Date date, int type, int dept, int unit, int room, int hospitalCode) {
		Connection con = null;
		
		String propertiesFileName = "in.cdac.mhealth.query";
		String queryKey = "DUTY_ROSTER_SERVICE_GET_ROSTER";
		String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
		
		String condition = " ";
		
		if (type != -1){
			condition += " and HGNUM_SHIFT_CODE = " + type;
		}
		
		if (dept != -1){
			condition += " and SUBSTR (HGNUM_DEPTUNITCODE, 1, 3) = " + dept;
			if (unit != -1) { 
				condition += " and HGNUM_DEPTUNITCODE = " + unit;
				if (room != -1) 
					condition += " and HGNUM_ROOM_CODE = " + room;
			}
		}
		
		query = query.replaceFirst("--condition--", condition);
		
		List<RosterInfo> lst = new ArrayList<RosterInfo>();
		
		try {
			con = GlobalUtils.getNimsConnection();		
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, hospitalCode);
			stmt.setDate(2, date);
			stmt.setDate(3, date);
			stmt.setInt(4, hospitalCode);
			stmt.setInt(5, hospitalCode);
			ResultSet rs =  stmt.executeQuery();
			while (rs.next()){
				RosterInfo obj = new RosterInfo();
				obj.setDepartment(rs.getString(1));
				obj.setType(rs.getString(2));
				obj.setFromTime(rs.getString(3));
				obj.setToTime(rs.getString(4));
				obj.setUnit(rs.getString(6));
				lst.add(obj);
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if (con != null) 
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lst;
	}

	public List<RosterInfo> getDoctorAvailability(Date date, String docName, int hospitalCode) {
		Connection con = null;
		
		String dName = "%" + docName.toUpperCase() + "%";
		
		String propertiesFileName = "in.cdac.mhealth.query";
		String queryKeyName = "DUTY_ROSTER_SERVICE_GET_DOC_AVAILABILITY_BY_NAME";
		String queryKeyNameDate = "DUTY_ROSTER_SERVICE_GET_DOC_AVAILABILITY_BY_NAME_DATE";
		
		List<RosterInfo> lst = new ArrayList<RosterInfo>();
		
		try {
			con = GlobalUtils.getNimsConnection();
			PreparedStatement stmt = null;
			if (date != null){				
				String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKeyNameDate);		
				stmt = con.prepareStatement(query);
				stmt.setInt(1, hospitalCode);
				stmt.setDate(2, date);
				stmt.setDate(3, date);
				stmt.setInt(4, hospitalCode);
				stmt.setInt(5, hospitalCode);
				stmt.setString(6, dName);
			} else if (date == null){
				String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKeyName);		
				stmt = con.prepareStatement(query);
				stmt.setInt(1, hospitalCode);
				stmt.setInt(2, hospitalCode);
				stmt.setInt(3, hospitalCode);
				stmt.setString(4, dName);
			}
			ResultSet rs =  stmt.executeQuery();
			while (rs.next()){
				String name = rs.getString(8);
				if (!docName.equals("")){					
					String[] n = name.split(",");
					name = "";
					for (int i=0;i<n.length;++i){
						if (n[i].toUpperCase().contains(docName.toUpperCase())){
							name += n[i] + ",";
						}
					}
					if (name.length() > 1)
						name = name.substring(0, name.length()-1);
				}
				RosterInfo obj = new RosterInfo();
				obj.setDepartment(rs.getString(1));
				obj.setType(rs.getString(2));
				obj.setFromTime(rs.getString(3));
				obj.setToTime(rs.getString(4));
				obj.setUnit(rs.getString(6));
				obj.setDocName(name);
				obj.setWorkingDays(rs.getString(9));
				lst.add(obj);
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if (con != null) 
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lst;
	}
	
}
