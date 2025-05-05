package in.cdac.mhealth.opdRoster.dao;

import in.cdac.mhealth.opdRoster.vo.Department;
import in.cdac.mhealth.opdRoster.vo.DepartmentMember;
import in.cdac.mhealth.global.util.GlobalUtils;
import in.cdac.mhealth.utility.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OPDDepartmentDao {

	public List<Department> getDepartments(int hospitalCode){
		Connection con = null;
		PreparedStatement stmt = null;
		String propertiesFileName = "in.cdac.mhealth.query";
		String queryKey = "GET_DEPARMENT_LIST";
		String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
		
		List<Department> deptList = new ArrayList<Department>();
		
		try {
			con = GlobalUtils.getNimsConnection();		
			stmt = con.prepareStatement(query);
			stmt.setInt(1, hospitalCode);
			ResultSet rs =  stmt.executeQuery();
			while (rs.next()){
				deptList.add(new Department(rs.getInt(1), rs.getString(2)));
			}
			rs.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null) 
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return deptList;
	}
	
	public String getDepartment(String deptId, int hospitalCode){
		Connection con = null;
		String propertiesFileName = "in.cdac.mhealth.query";
		String queryKey = "GET_DEPARMENT_FROM_ID";
		String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
		
		try {
			con = GlobalUtils.getConnection();		
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, hospitalCode);
			stmt.setString(2, deptId);
			ResultSet rs =  stmt.executeQuery();
			rs.next();
			return rs.getString(1);
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
		return null;
	}

	public Department getDepartmentDetail(int deptId, int hospitalCode) {
		Connection con = null;
		String propertiesFileName = "in.cdac.mhealth.query";
		String queryKey = "DEPARTMENT_SERVICE_GET_DEPT_DETAIL";
		String queryMemberKey = "DEPARTMENT_SERVICE_GET_DEPT_MEMBER_DETAIL";
		String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
		String queryMember = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryMemberKey);
		
		Department deptInfo = new Department();
		
		try {
			con = GlobalUtils.getConnection();		
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, hospitalCode);
			stmt.setInt(2, deptId);
			ResultSet rs =  stmt.executeQuery();
			rs.next();
			deptInfo.setDepartmentName(rs.getString(1));
			deptInfo.setHodName(rs.getString(2));
			deptInfo.setLocationName(rs.getString(3));
			deptInfo.setDepartmentType(rs.getString(4));
			
			PreparedStatement stmtMember = con.prepareStatement(queryMember);
			stmtMember.setInt(1, hospitalCode);
			stmtMember.setInt(2, deptId);
			ResultSet rsMember = stmtMember.executeQuery();
			List<DepartmentMember> lst = new ArrayList<DepartmentMember>();
			while (rsMember.next()){
				DepartmentMember member = new DepartmentMember();
				member.setName(rsMember.getString(1));
				member.setGender(rsMember.getString(2));
				member.setDob(rsMember.getString(3));
				member.setDesignation(rsMember.getString(5));
				lst.add(member);
			}
			deptInfo.setMembers(lst);
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
		return deptInfo;
	}
	
	/**
	 * Method to get list of departments by user ID.
	 * For NIMS Database
	 */
	public List<Department>getDepartmentsByUserName(String userId, int hospitalCode){
		Connection con = null;
		PreparedStatement stmt = null;
		String propertiesFileName = "in.cdac.mhealth.query";
		String queryKey = "DEPARTMENT_SERVICE.User_wise_department.1";
		String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);		
		List<Department> deptList = new ArrayList<Department>();		
		try {
			con = GlobalUtils.getNimsConnection();		
			stmt = con.prepareStatement(query);
			stmt.setInt(1, hospitalCode);
			stmt.setString(2, userId);
			ResultSet rs=  stmt.executeQuery();
			while (rs.next()){
				deptList.add(new Department(rs.getInt(1), rs.getString(2)));
			}
			if (rs != null)
				rs.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null) 
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return deptList;
	}
	
	public List<Department>getUnitListByUserName(String userId, String hcode){
		Connection con = null;
		PreparedStatement stmt = null;
		String propertiesFileName = "in.cdac.mhealth.nims_query";
		String queryKey = "DEPARTMENT_SERVICE.Unit_List_User_Wise.1";
		String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);		
		List<Department> deptList = new ArrayList<Department>();		
		try {
			con = GlobalUtils.getHospitalSpecificConnection(Utility.getHospitalSpecificName(hcode));		
			stmt = con.prepareStatement(query);
			stmt.setInt(1, Integer.parseInt(Utility.getHospitalSpecificCode(hcode)));
			stmt.setString(2, userId);
			ResultSet rs=  stmt.executeQuery();
			while (rs.next()){
				deptList.add(new Department(rs.getInt(1), rs.getString(2)));
			}
			if (rs != null)
				rs.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null) 
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return deptList;
	}

	
	/**
	 * Method for NIMS departments for patient provisional registration
	 * @param hospId
	 * @return
	 */
	
	public List<Department> getDepartmentsForRegistration(String hcode) {
		Connection con = null;
		PreparedStatement stmt = null;
		String propertiesFileName = "in.cdac.mhealth.query";
		String queryKey = "GET_DEPARTMENT_LIST_FOR_OPDROSTER_NEW";
		String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
		
		List<Department> deptList = new ArrayList<Department>();
		deptList.add(new Department(0,"ALL"));
		try {
			con = GlobalUtils.getHospitalSpecificConnection(Utility.getHospitalSpecificName(hcode));		
			stmt = con.prepareStatement(query);
			stmt.setString(1, Utility.getHospitalSpecificCode(hcode));
//			stmt.setString(2, Utility.getHospitalSpecificCode(hcode));
//			stmt.setString(3, Utility.getHospitalSpecificCode(hcode));
			ResultSet rs =  stmt.executeQuery();
			while (rs.next()){
				deptList.add(new Department(rs.getInt(1), rs.getString(2)));
			}
			rs.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null) 
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return deptList;
	}

	public List<Department> getCategoriesForRegistration(String hcode) {
		Connection con = null;
		PreparedStatement stmt = null;
		String propertiesFileName = "in.cdac.mhealth.query";
		String queryKey = "GET_CATEGORY_LIST_FOR_REGISTRATION";
		String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
		
		List<Department> categoryList = new ArrayList<Department>();
		//categoryList.add(new Department(-1,"Select Category"));
		try {
			con = GlobalUtils.getHospitalSpecificConnection(Utility.getHospitalSpecificName(hcode));		
			stmt = con.prepareStatement(query);
			stmt.setString(1, Utility.getHospitalSpecificCode(hcode));
			ResultSet rs =  stmt.executeQuery();
			while (rs.next()){
				categoryList.add(new Department(rs.getInt(1), rs.getString(2)));
			}
			rs.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null) 
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return categoryList;
	}

	public String getDepartmentNameFromDepartmentID(String deptId, String hospId) {
		String departmentName="";
		Connection con = null;
		PreparedStatement stmt = null;
		String propertiesFileName = "in.cdac.mhealth.query";
		String queryKey = "GET_DEPARTMENT_NAME_FROM_DEPARTMENT_ID";
		String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
		
		
		
		try {
			con = GlobalUtils.getHospitalSpecificConnection(Utility.getHospitalSpecificName(hospId));		
			stmt = con.prepareStatement(query);
			stmt.setString(1, Utility.getHospitalSpecificCode(hospId));
			stmt.setString(2, deptId);
			//stmt.setString(3, Utility.getHospitalSpecificCode(hospId));
			ResultSet rs =  stmt.executeQuery();
			while (rs.next()){
				departmentName= rs.getString(2);
			}
			rs.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null) 
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return departmentName;
	}

	

}
