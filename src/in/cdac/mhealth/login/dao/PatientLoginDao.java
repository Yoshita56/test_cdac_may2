package in.cdac.mhealth.login.dao;

import in.cdac.mhealth.global.util.CdacSmsGatewayPushUtil;
import in.cdac.mhealth.global.util.GlobalUtils;
import in.cdac.mhealth.login.vo.PatientVO;
import in.cdac.mhealth.login.vo.PatientsVO;
import in.cdac.mhealth.utility.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.lang.RandomStringUtils;

public class PatientLoginDao {

	private String propertiesFileName = "in.cdac.mhealth.query";
	
	public PatientsVO getOTPforPatient(String mobileNo, String hcode){
		
		PatientsVO patientsVO = null;
		
		Connection con = null;
		PreparedStatement stmt = null;
		String propertiesFileName = "in.cdac.mhealth.query";
		String queryKey = "PATIENT_LOGIN_USING_MOBILENO";
		String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
		
		try {
			con = GlobalUtils.getHospitalSpecificConnection(Utility.getHospitalSpecificName(hcode));		
			stmt = con.prepareStatement(query);
			stmt.setString(1, Utility.getHospitalSpecificCode(hcode));
			stmt.setString(2, mobileNo);
			ResultSet rs =  stmt.executeQuery();
			ArrayList<PatientVO> patientVOList = new ArrayList<PatientVO>();
			while (rs.next()){
				PatientVO patientVO=new PatientVO();
				patientVO.setCrNo(rs.getString(1));
				patientVO.setMobileNo(rs.getString(2));
				patientVO.setPatientName(rs.getString(3));
				patientVO.setPatientHasWallet(rs.getString(4));				
				patientVOList.add(patientVO);
				
			}
			rs.close();
			
			String OTP = RandomStringUtils.random(6,"123456789");
			String message = "Your OTP for login to CDAC mHealth App is "+OTP;
			CdacSmsGatewayPushUtil.sendSingleSMSThroughSMSGateway(message,mobileNo);
			
			patientsVO = new PatientsVO();
			patientsVO.setPatientsVO(patientVOList);
			patientsVO.setOTP(OTP);
			
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
		
		return patientsVO;
	}
	
	
	
	
	
	
	
public PatientsVO getOTPforPatientUsingCr(String crno, String hcode){
		
		PatientsVO patientsVO = null;
		
		Connection con = null;
		PreparedStatement stmt = null;
		String propertiesFileName = "in.cdac.mhealth.query";
		String queryKey = "PATIENT_LOGIN_USING_CRNO";
		String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
		
		try {
			con = GlobalUtils.getHospitalSpecificConnection(Utility.getHospitalSpecificName(hcode));		
			stmt = con.prepareStatement(query);
			stmt.setString(1, Utility.getHospitalSpecificCode(hcode));
			stmt.setString(2,crno);
			ResultSet rs =  stmt.executeQuery();
			ArrayList<PatientVO> patientVOList = new ArrayList<PatientVO>();
			String mobileNo="";
			while (rs.next()){
				PatientVO patientVO=new PatientVO();
				patientVO.setCrNo(rs.getString(1));
				patientVO.setMobileNo(rs.getString(2));
				patientVO.setPatientName(rs.getString(3));
				patientVO.setPatientHasWallet(rs.getString(4));				
				patientVOList.add(patientVO);
				 mobileNo=rs.getString(2);
			}
			rs.close();
			
			String OTP = RandomStringUtils.random(6,"123456789");
			String message = "Your OTP is "+OTP;
			CdacSmsGatewayPushUtil.sendSingleSMSThroughSMSGateway(message,mobileNo);
			
			patientsVO = new PatientsVO();
			patientsVO.setPatientsVO(patientVOList);
			patientsVO.setOTP(OTP);
			
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
		
		return patientsVO;
	}
	
	
}
