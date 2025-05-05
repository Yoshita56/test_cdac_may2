package in.cdac.mhealth.provisionalRegistration.dao;

import in.cdac.mhealth.department.business.DepartmentBO;
import in.cdac.mhealth.general.vo.State;
import in.cdac.mhealth.global.dao.QueryParam;
import in.cdac.mhealth.global.dao.TransactionMgmnt;
import in.cdac.mhealth.global.util.CdacSmsGatewayPushUtil;
import in.cdac.mhealth.global.util.GlobalUtils;
import in.cdac.mhealth.global.util.Mail;
import in.cdac.mhealth.global.util.NICSmsGatewayPushUtil;
import in.cdac.mhealth.global.util.SMSHttpPostClient;
import in.cdac.mhealth.provisionalRegistration.vo.PatientInfo;
import in.cdac.mhealth.utility.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;

public class ProvisionalRegistrationDao {

	private String propertiesFileName = "in.cdac.mhealth.query";
	
	public void registerPatient (final PatientInfo objPatientInfo) {
		Connection con = null;
		List<QueryParam> params = new ArrayList<QueryParam>();
		TransactionMgmnt obj = new TransactionMgmnt();
		String queryKey = null, query = null;
		PreparedStatement stmt = null;
		ResultSet rs =  null;
		ResultSet rs1 =  null;
		ResultSet rs2 =  null;
		String hospitalName="";
		try {
			//con = GlobalUtils.getNimsConnection();
			con=GlobalUtils.getHospitalSpecificConnection(Utility.getHospitalSpecificName(objPatientInfo.getHcode()));
			
			if (con == null) {
				objPatientInfo.setRegisterSuccessful(false);
				objPatientInfo.setMessage("Error in Getting Connection");
				return;
			}
			con.setAutoCommit(false);
			
			/* For Aadhaar Based Registration. Check if Aadhaar Number is already registered for Today.*/
			if (objPatientInfo.getAadhaarNo() != null && objPatientInfo.getAadhaarNo().length()>0) {
				queryKey = "AADHAAR_SERVICE.Duplicate_Aadhaar_Registeration.1";
				query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
				int count = 0;
				try{
					params.clear();
					params.add(new QueryParam(objPatientInfo.getAadhaarNo(), Types.VARCHAR));
					params.add(new QueryParam(Utility.getHospitalSpecificCode(objPatientInfo.getHcode()), Types.INTEGER));
					params.add(new QueryParam(objPatientInfo.getHcode(), Types.VARCHAR));
					count = Integer.parseInt(obj.getSingleResult(query, params, con));
					if (count != 0) {
						objPatientInfo.setMessage("Aadhaar No. " + objPatientInfo.getAadhaarNo() + " already registered.");
						objPatientInfo.setRegisterSuccessful(false);
						return;
					}
				} catch (Exception e){
					e.printStackTrace();
					Utility.logQueryAndParams(query, params);
					objPatientInfo.setMessage("ERROR in Checking Duplicacy of Aadhaar No.");
					objPatientInfo.setRegisterSuccessful(false);
					return;
				}
			}
			
			
			/* Previous code for provisional registration based on new CR number generation
			
			// Get Max CR Number 
			queryKey = "PROVISIONAL_REGISTRATION.Max_CR_No.1";
			query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
			String maxCr = null;
			try{
				params.clear();
				params.add(new QueryParam(Utility.getHospitalSpecificCode(objPatientInfo.getHcode()), Types.INTEGER));
				params.add(new QueryParam(objPatientInfo.getHcode(), Types.VARCHAR));
				maxCr = obj.getSingleResult(query, params, con);
			} catch (Exception e){
				e.printStackTrace();
				Utility.logQueryAndParams(query, params);
				objPatientInfo.setMessage("ERROR in Getting Max CR No.");
				objPatientInfo.setRegisterSuccessful(false);
				return;
			}

			if (maxCr == null) {
				maxCr = "";
			}
			
			// Generate New CR Number 
			queryKey = "PROVISIONAL_REGISTRATION.New_CR_No.1";
			query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
			String newCr = null;
			try{
				params.clear();
				params.add(new QueryParam(maxCr, Types.VARCHAR));
				params.add(new QueryParam(maxCr, Types.VARCHAR));
				params.add(new QueryParam(maxCr, Types.VARCHAR));
				newCr = obj.getSingleResult(query, params, con);
			} catch (Exception e){
				e.printStackTrace();
				Utility.logQueryAndParams(query, params);
				objPatientInfo.setMessage("ERROR in Getting New CR No.");
				objPatientInfo.setRegisterSuccessful(false);
				return;
			}
			
			if (newCr == null){
				Utility.logQueryAndParams(query, params);
				System.out.println("Error in Getting New CR No.");
				objPatientInfo.setMessage("Error in Getting New CR No.");
				objPatientInfo.setRegisterSuccessful(false);
				return;
			}
			
			// Generate Queue Number 
			queryKey = "PROVISIONAL_REGISTRATION.New_Queue_No.1";
			query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
			String queueNo = null;
			try{
				params.clear();
				params.add(new QueryParam(Utility.getHospitalSpecificCode(objPatientInfo.getHcode()), Types.INTEGER));
				params.add(new QueryParam(objPatientInfo.getHcode(), Types.VARCHAR));
				queueNo = obj.getSingleResult(query, params, con);
			} catch (Exception e){
				queueNo = "1";
				Utility.logQueryAndParams(query, params);
				e.printStackTrace();
			}
			
			if (queueNo == null){
				Utility.logQueryAndParams(query, params);
				System.out.println("Error in Getting New Queue No.");
				objPatientInfo.setMessage("Error in Getting New Queue No.");
				objPatientInfo.setRegisterSuccessful(false);
				return;
			}
			
			objPatientInfo.setQueueNo(Integer.parseInt(queueNo));
			
			*/
			
//			queryKey = "PROVISIONAL_REGISTRATION.Register.1";
//			query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
//			try {
//				params.clear();
//				params.add(new QueryParam(objPatientInfo.getAadhaarNo(), Types.VARCHAR));
//				params.add(new QueryParam(newCr, Types.VARCHAR));
//				params.add(new QueryParam(objPatientInfo.getFirstName(), Types.VARCHAR));
//				params.add(new QueryParam("", Types.VARCHAR));
//				params.add(new QueryParam(objPatientInfo.getLastName(), Types.VARCHAR));
//				params.add(new QueryParam(objPatientInfo.getGender(), Types.VARCHAR));
//				params.add(new QueryParam(objPatientInfo.getFatherName(), Types.VARCHAR));
//				params.add(new QueryParam(objPatientInfo.getMotherName(), Types.VARCHAR));
//				params.add(new QueryParam(objPatientInfo.getSpouseName(), Types.VARCHAR));
//				params.add(new QueryParam(objPatientInfo.getAge(), Types.VARCHAR));
//				params.add(new QueryParam(Utility.getHospitalSpecificCode(objPatientInfo.getHcode()), Types.INTEGER));
//				params.add(new QueryParam(objPatientInfo.getCity(), Types.VARCHAR));
//				params.add(new QueryParam(objPatientInfo.getPincode(), Types.VARCHAR));
//				params.add(new QueryParam(objPatientInfo.getMobileNo(), Types.VARCHAR));
//				params.add(new QueryParam(objPatientInfo.getState(), Types.VARCHAR));
//				params.add(new QueryParam(objPatientInfo.getDistrict(), Types.VARCHAR));
//				params.add(new QueryParam(GlobalUtils.COUNTRY_CODE, Types.VARCHAR));
//				params.add(new QueryParam(objPatientInfo.getEmail(), Types.VARCHAR));
//				params.add(new QueryParam(objPatientInfo.getQueueNo(), Types.INTEGER));
//				params.add(new QueryParam(objPatientInfo.getIp(), Types.VARCHAR));
//				params.add(new QueryParam(objPatientInfo.getImei(), Types.VARCHAR));
//				params.add(new QueryParam(objPatientInfo.getHcode(), Types.VARCHAR));
//				if (obj.executeUpdate(query, params, con)) {
//					objPatientInfo.setRegisterSuccessful(true);
//					objPatientInfo.setCrNo(newCr);
//				} else {
//					Utility.logQueryAndParams(query, params);
//					objPatientInfo.setMessage("Error in Saving Patient Details");
//					objPatientInfo.setRegisterSuccessful(false);
//				}
//			} catch (SQLException e){
//				e.printStackTrace();			
//				Utility.logQueryAndParams(query, params);
//				objPatientInfo.setRegisterSuccessful(false);
//			}
			
			
			
//			queryKey="GLOBAL_SERVICE.Check_date";
//			query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
//			stmt = con.prepareStatement(query);
//			rs =  stmt.executeQuery();
//			int crno=0;
//			int crNo = 0;
//			
			 
			
				queryKey="GLOBAL_SERVICE.insert_into_gccst_max_provisional_regno";
				query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
				//params.add(new QueryParam(GlobalUtils.getDateYYYYMMDD()+"00001", Types.VARCHAR));
				 stmt=con.prepareStatement(query);   
				stmt.setString(1,GlobalUtils.getDateYYYYMMDD()+"00000");  
				stmt.executeUpdate();  
			//    System.out.println("No data"); 
			 
			
				queryKey="GLOBAL_SERVICE.update_gccst_max_provisional_regno";
				query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
				stmt=con.prepareStatement(query);
				 //stmt.setInt(1,Integer.parseInt(crno)+1);
				//stmt.setString(1,String.valueOf(crno));
				stmt.executeUpdate();
			
			
			queryKey="GLOBAL_SERVICE.Check_date";
			query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
			stmt = con.prepareStatement(query);
			rs =  stmt.executeQuery();
			String newCr=null;
			while (rs.next() ) {
				newCr="";
				 newCr	=rs.getString(1);
			}
			
			
			
			
			
			
			// code to get hospital name from hospital code
			queryKey="GLOBAL_SERVICE.Hospital_Name_From_Code";
			query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
			stmt = con.prepareStatement(query);
			stmt.setString(1, objPatientInfo.getHcode());
			rs =  stmt.executeQuery();
			while (rs.next()){
				hospitalName=rs.getString(1);
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
//			String newCr=GlobalUtils.getDateYYYYMMDD()+
//					RandomStringUtils.random(10,"123456789");
			
			
			
			
			
			
			long newCRLong=Long.parseLong(newCr);
		//	System.out.println("Generated CR NO: "+newCRLong);
//			queryKey="PROVISIONAL_REGISTRATION_NIMS.Register.1";
			queryKey="PROVISIONAL_REGISTRATION_NIMS.Register.2";
			query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
			
			
			try {
				params.clear();
				
				if (objPatientInfo.getAadhaarNo()==null){
					params.add(new QueryParam("", Types.VARCHAR));
				}else{
					params.add(new QueryParam(objPatientInfo.getAadhaarNo(), Types.VARCHAR));
				}
				params.add(new QueryParam(newCRLong, Types.VARCHAR)); // temporary registration number
				params.add(new QueryParam(objPatientInfo.getFirstName(), Types.VARCHAR));
				
				//middlename required as blank
				if (objPatientInfo.getMiddleName()==null){
					params.add(new QueryParam("", Types.VARCHAR));
				}
				else{
					params.add(new QueryParam(objPatientInfo.getMiddleName(), Types.VARCHAR));
				}
				
				params.add(new QueryParam(objPatientInfo.getLastName(), Types.VARCHAR));
				params.add(new QueryParam(objPatientInfo.getGender(), Types.VARCHAR));
				
				if (objPatientInfo.getFatherName()==null){
					params.add(new QueryParam("", Types.VARCHAR));
				}else{
					params.add(new QueryParam(objPatientInfo.getFatherName(), Types.VARCHAR));
				}
				
				if (objPatientInfo.getMotherName()==null){
					params.add(new QueryParam("", Types.VARCHAR));
				}
				else{
					params.add(new QueryParam(objPatientInfo.getMotherName(), Types.VARCHAR));
				}
				
				if (objPatientInfo.getSpouseName()==null){
					params.add(new QueryParam("", Types.VARCHAR));
				}else{
					params.add(new QueryParam(objPatientInfo.getSpouseName(), Types.VARCHAR));
				}
				params.add(new QueryParam("1", Types.VARCHAR)); //isvalid
				params.add(new QueryParam(objPatientInfo.getAge()+"-Yr", Types.VARCHAR));
				params.add(new QueryParam(Utility.getHospitalSpecificCode(objPatientInfo.getHcode()), Types.INTEGER));
				params.add(new QueryParam(objPatientInfo.getCity(), Types.VARCHAR));
				
//				System.out.println(objPatientInfo.getPincode());
				
				if (objPatientInfo.getPincode().equals("")){
					params.add(new QueryParam("0", Types.VARCHAR));
				}else{
					params.add(new QueryParam(objPatientInfo.getPincode(), Types.VARCHAR));
				}
				
				
				
				params.add(new QueryParam(objPatientInfo.getMobileNo(), Types.VARCHAR));
				params.add(new QueryParam(objPatientInfo.getState(), Types.VARCHAR));
				params.add(new QueryParam(objPatientInfo.getDistrict(), Types.VARCHAR));
				params.add(new QueryParam(GlobalUtils.COUNTRY_CODE, Types.VARCHAR));
				
				if (objPatientInfo.getEmail()==null){
					params.add(new QueryParam("", Types.VARCHAR));
				}else{
					params.add(new QueryParam(objPatientInfo.getEmail(), Types.VARCHAR));
				}
				
				params.add(new QueryParam(objPatientInfo.getDepartmentId(), Types.INTEGER));
				params.add(new QueryParam(objPatientInfo.getDepartmentId().substring(0,3), Types.INTEGER));
//				params.add(new QueryParam(objPatientInfo.getQueueNo(), Types.INTEGER));
//				params.add(new QueryParam(objPatientInfo.getIp(), Types.VARCHAR));
//				params.add(new QueryParam(objPatientInfo.getImei(), Types.VARCHAR));
//				params.add(new QueryParam(objPatientInfo.getHcode(), Types.VARCHAR));
				if (obj.executeUpdate(query, params, con)) {
					objPatientInfo.setRegisterSuccessful(true);
					objPatientInfo.setCrNo(newCr);
					
					//send SMS
					final String message="Provisional Registration Successful!\n Name: "+objPatientInfo.getFirstName()+
							" "+objPatientInfo.getLastName()+
							"\n"+"Prov Reg No.: "+newCr+
							"\n"+"Dept.: "+
							DepartmentBO.getDepartmentNameFromDepartmentID(
									objPatientInfo.getDepartmentId(),objPatientInfo.getHcode())+
							"\n"+"Hospital: "+hospitalName+
							"\n"+"Valid till: "+GlobalUtils.getDateAfterDays(7)+
							"\n"+"Visit between 8.00-11.30 AM (Working Days).";
					
			//		System.out.println("SMS: "+message);
					
					// Send SMS on new thread
					new Thread(new Runnable() {
					     public void run() {
					    	 
//					    	 // Using CDAC SMS Gateway
					    	 CdacSmsGatewayPushUtil.sendSingleSMSThroughSMSGateway(message,objPatientInfo.getMobileNo());
					    	 
					    	 //Using NIC SMS Gateway - 30 Oct 2017
					    	 //NICSmsGatewayPushUtil.sendSingleSMS(message,objPatientInfo.getMobileNo());
					    	 
					    	 //Sending email - 30 Oct 2017
					    	 if (objPatientInfo.getEmail()!=null){
					    		 //Mail.sendNIMSEmail(objPatientInfo.getEmail(), "Your Provisional Registration at eHMS-Odisha", message);
					    	 }
					     }
					}).start();
					
					
					//CdacSmsGatewayPushUtil.sendSingleSMS(message , objPatientInfo.getMobileNo());
					
				} else {
					Utility.logQueryAndParams(query, params);
					objPatientInfo.setMessage("Error in Saving Patient Details");
					objPatientInfo.setRegisterSuccessful(false);
				}
			} catch (SQLException e){
				e.printStackTrace();			
				Utility.logQueryAndParams(query, params);
				objPatientInfo.setRegisterSuccessful(false);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			objPatientInfo.setRegisterSuccessful(false);
		} finally {
			if (con != null)
				try {
					if (objPatientInfo.isRegisterSuccessful())
						con.commit();
					else 
						con.rollback();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			con = null;
		}
	}
}
