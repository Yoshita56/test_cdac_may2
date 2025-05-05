package in.cdac.invWebServices.login.dao;

import in.cdac.invWebServices.global.util.GlobalUtils;
import in.cdac.invWebServices.global.util.SecurityUtil;
import in.cdac.invWebServices.login.vo.LoginVO;
import in.cdac.invWebServices.utility.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class LoginDao {

	String propertiesFileName = "in.cdac.mhealth.query";
	
	public void checkLogin(LoginVO objLoginVO, String hcode){
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String queryKey = "LOGIN_SERVICE.User_Detail.1";
			String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
						
			objLoginVO.setHospitalCode(Utility.getHospitalSpecificCode(hcode));
			con = GlobalUtils.getHospitalSpecificConnection(Utility.getHospitalSpecificName(hcode));
					
			// Login Authentication 
			stmt = con.prepareStatement(query);
			stmt.setString(1, objLoginVO.getUserName());
			stmt.setInt(2, Integer.parseInt(Utility.getHospitalSpecificCode(hcode)));
			rs = stmt.executeQuery();
			if (rs.next()) {
				String passwordFromDB = rs.getString(2);
				if (objLoginVO.getPassWord().equals(SecurityUtil.SHA1(passwordFromDB + objLoginVO.getSalt()))) {
					objLoginVO.setValid("1");
					objLoginVO.setUserDisplayName(rs.getString(1));
					objLoginVO.setSeatId(rs.getString(4));
					// Get the Applications list that can be accessed by the logged in user
					Set<String> accessiblePackage = new HashSet<String>();
					accessiblePackage.add("in.cdac.mhealth.doctordesk");
					objLoginVO.setAccessiblePackage(accessiblePackage);
					
					return;
				}
			}
			
			/*if (objLoginVO.getUserName().equals("cdac")) {
				objLoginVO.setValid("1");
				if (Utility.getHospitalSpecificName(hcode).equals("NIMS")) {
					objLoginVO.setUserName("nims_user1");
				} else if (Utility.getHospitalSpecificName(hcode).equals("TEL") && Utility.getHospitalSpecificCode(hcode).equals("33107")) {
					objLoginVO.setUserName("adm_kingkoti");					
				} else {
					objLoginVO.setValid("0");
				}
				objLoginVO.setUserDisplayName("CDAC Admin User");
				Set<String> accessiblePackage = new HashSet<String>();
				accessiblePackage.add("in.cdac.mhealth.doctordesk");
				objLoginVO.setAccessiblePackage(accessiblePackage);
				objLoginVO.setHospitalCode(Utility.getHospitalSpecificCode(hcode));
				
				Set<String> mandatoryUpdate = new HashSet<String>();
				mandatoryUpdate.add("in.cdac.mhealth.doctordesk");
				objLoginVO.setMandatoryUpdatePackage(mandatoryUpdate);
				
				return;
			}*/			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();					
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		objLoginVO.setValid("0");
	}
}
