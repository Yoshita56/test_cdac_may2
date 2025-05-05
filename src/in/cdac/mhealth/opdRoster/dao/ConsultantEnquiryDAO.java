package in.cdac.mhealth.opdRoster.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar; 

import org.apache.commons.lang.RandomStringUtils;




import in.cdac.mhealth.opdRoster.vo.ConsultantEnquiryVO;
import in.cdac.mhealth.global.util.CdacSmsGatewayPushUtil;
import in.cdac.mhealth.global.util.GlobalUtils;
import in.cdac.mhealth.login.vo.PatientVO;
import in.cdac.mhealth.login.vo.PatientsVO;
import in.cdac.mhealth.utility.Utility;



public class ConsultantEnquiryDAO {
	
private String propertiesFileName = "in.cdac.mhealth.query";
	
	public ArrayList<ConsultantEnquiryVO> getConsultantEnquiry(String deptCode, String hcode){
		
		ArrayList<ConsultantEnquiryVO> consultantEnquiryVOs = null;
		
		Connection con = null;
		PreparedStatement stmt = null;
		String queryKey = "CONSULTANT_ENQUIRY";
		String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
		
		try {
			con = GlobalUtils.getHospitalSpecificConnection(Utility.getHospitalSpecificName(hcode));		
			
//			Handle department
			String condition = " ";
			if (!deptCode.equalsIgnoreCase("0")){
				condition += " and gnum_dept_code = " + deptCode;

			}

			query = query.replaceFirst("--condition--", condition);
			

			
			stmt = con.prepareStatement(query);
			stmt.setString(1, Utility.getHospitalSpecificCode(hcode));
			
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("MMM-yyyy");
			String startDate= formatter.format(date);
			Calendar calendar = Calendar.getInstance();
	         calendar.add(Calendar.MONTH, 1);  
	         calendar.set(Calendar.DAY_OF_MONTH, 1);  
	         calendar.add(Calendar.DATE, -1);  
			 Date lastDayOfMonth = calendar.getTime(); 
			 DateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");  
			 sdf.format(lastDayOfMonth);
			stmt.setString(2, "01-"+startDate);
			stmt.setString(3,  sdf.format(lastDayOfMonth));
			
		
			
			
			
			//System.out.println(stmt);
			
			ResultSet rs =  stmt.executeQuery();
			
			consultantEnquiryVOs = new ArrayList<ConsultantEnquiryVO>();
			while (rs.next()){
				ConsultantEnquiryVO consultantEnquiryVO = new ConsultantEnquiryVO();
				consultantEnquiryVO.setDeptCode(rs.getString(1));
				consultantEnquiryVO.setDeptName(rs.getString(2));
				consultantEnquiryVO.setDeptUnitCode(rs.getString(3));
				consultantEnquiryVO.setUnitName(rs.getString(4));
				consultantEnquiryVO.setRoomCode(rs.getString(5));
				consultantEnquiryVO.setRoomName(rs.getString(6));
				consultantEnquiryVO.setOpdName(rs.getString(7));
				consultantEnquiryVO.setUnitDays(rs.getString(8));
				consultantEnquiryVO.setShiftTime(rs.getString(9));
				consultantEnquiryVO.setRoster(rs.getString(10));
				consultantEnquiryVOs.add(consultantEnquiryVO);
			}
			rs.close();
			
//		System.out.println("***Consultant search found results: "+consultantEnquiryVOs.size());
			
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
		
		
		return consultantEnquiryVOs;
		
	}

	
	public static void main(String arr[]){
		Calendar c = Calendar.getInstance();   // this takes current date
	    c.set(Calendar.DAY_OF_MONTH, 1);
	 //   System.out.println(c.getTime());       // this returns java.util.Date
	}
}
