package in.cdac.mhealth.login.dao;

import in.cdac.mhealth.opdRoster.vo.ConsultantEnquiryVO;
import in.cdac.mhealth.login.vo.TariffVO;
import in.cdac.mhealth.global.util.GlobalUtils;
import in.cdac.mhealth.utility.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TariffDAO {
	
	private String propertiesFileName = "in.cdac.mhealth.query";
	
	public ArrayList<TariffVO> getTariffs(String hcode){
		ArrayList<TariffVO> tariffVOs = null;
		
		Connection con = null;
		PreparedStatement stmt = null;
		String queryKey = "TARIFF_ENQUIRY";
		String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
		
		try {
			con = GlobalUtils.getHospitalSpecificConnection(Utility.getHospitalSpecificName(hcode));		
			stmt = con.prepareStatement(query);
			stmt.setString(1, Utility.getHospitalSpecificCode(hcode));
			stmt.setString(2, Utility.getHospitalSpecificCode(hcode));
			stmt.setString(3, Utility.getHospitalSpecificCode(hcode));
			stmt.setString(4, Utility.getHospitalSpecificCode(hcode));
			
			
			ResultSet rs =  stmt.executeQuery();
			
			tariffVOs = new ArrayList<TariffVO>();
			while (rs.next()){
				TariffVO tariffVO = new TariffVO();
				tariffVO.setPatientCategory(rs.getString(1));
				tariffVO.setChargeType(rs.getString(2));
				tariffVO.setTariffName(rs.getString(3));
				tariffVO.setTariffServiceID(rs.getString(4));
				tariffVO.setTariffCharge(rs.getString(5));
				tariffVOs.add(tariffVO);
			}
			rs.close();
		}catch (SQLException e){
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
		
		return tariffVOs;
	}

}