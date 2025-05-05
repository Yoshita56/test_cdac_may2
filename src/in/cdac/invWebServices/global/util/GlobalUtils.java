package in.cdac.invWebServices.global.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class GlobalUtils {

	public static int HOSPITAL_CODE = 101;
	public static int NIMS_HOSPITAL_CODE = 33107;
	public static String COUNTRY_CODE = "IND";
	public static String MESSAGING_NUMBER = "+918527890790";
	public static int INVESTIGATION_MODULE_ID = 15;
	
	public static String getQueryFromPropertiesFile(String fileName, String queryKey){
		ResourceBundle rb = ResourceBundle.getBundle(fileName);
		String query = rb.getString(queryKey);
		return query;
	}
	
	public static Connection getConnection(){
		Connection con = null;
		try {
			InitialContext ic = new InitialContext();
			DataSource dataSource = (DataSource) ic.lookup("mobHIS");
			con = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static Connection getConnection52(){
		Connection con = null;
		try {
			InitialContext ic = new InitialContext();
			DataSource dataSource = (DataSource) ic.lookup("mobHIS52");
			con = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static Connection getMsgConnection(){
		Connection con = null;
		try {
			InitialContext ic = new InitialContext();
			DataSource dataSource = (DataSource) ic.lookup("msgDataSource");
			con = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static Connection getAppWriteConnection(){
		Connection con = null;
		try {
			InitialContext ic = new InitialContext();
			DataSource dataSource = (DataSource) ic.lookup("AppWriteDataSource");
			con = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static Connection getAppStoreConnection(){
		Connection con = null;
		try {
			InitialContext ic = new InitialContext();
			DataSource dataSource = (DataSource) ic.lookup("AppStoreDataSource");
			con = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static Connection getPaybillConnection(){
		Connection con = null;
		try {
			InitialContext ic = new InitialContext();
			DataSource dataSource = (DataSource) ic.lookup("mobPaybill");
			con = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static Connection getNimsConnection(){
		Connection con = null;
		try {
//			InitialContext ic = new InitialContext();
//			DataSource dataSource = (DataSource) ic.lookup("mob_nims");
//			con = dataSource.getConnection();
			
			
			//Class.forName("org.postgresql.Driver");
			Class.forName("com.edb.Driver");
			//development
		//	con = DriverManager.getConnection("jdbc:edb://10.226.2.98:5444/nimsnew", "nimsnew", "nimsnew");
			
			
		    //UAT
			con = DriverManager.getConnection("jdbc:edb://10.226.2.63:5444/nims_uat", "nims_uat", "nims_uat");
			
			//UAT - NEW
			//con = DriverManager.getConnection("jdbc:edb://10.10.10.72:5444/tstaiimspatna", "aiimspatna", "aiimspatna");
			
			//PRODUCTION
			//con = DriverManager.getConnection("jdbc:edb://10.226.1.83:5444/nimsdb", "nimsdb", "nimsdb");
			
			//PRODUCTION - DMZ
			//con = DriverManager.getConnection("jdbc:edb://10.10.136.37:5444/nimsdb", "nimsdb", "Ni$!@#Ms");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static Connection getNimsUATConnection(){
		Connection con = null;
		try {
			InitialContext ic = new InitialContext();
			DataSource dataSource = (DataSource) ic.lookup("mob_nims_uat");
			con = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static Connection getTelenganaConnection(){
		Connection con = null;
		try {
//			InitialContext ic = new InitialContext();
//			DataSource dataSource = (DataSource) ic.lookup("mob_tel");
//			con = dataSource.getConnection();
			
			//Class.forName("org.postgresql.Driver");
			Class.forName("com.edb.Driver");
		    //UAT
			con = DriverManager.getConnection("jdbc:edb://10.226.2.63:5444/ehms_tel", "ehms_tel", "ehms_tel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	public static Connection getHospitalSpecificConnection(String hcode) {
		Connection con = null;
		try {		
			if (hcode.equals("NIMS")) {
				con = GlobalUtils.getNimsConnection();				
			} else if (hcode.equals("TEL")) {
				con = GlobalUtils.getTelenganaConnection();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static Connection getBloodBankConnection(){
		Connection con = null;
		try {
			InitialContext ic = new InitialContext();
			DataSource dataSource = (DataSource) ic.lookup("mob_blood_bank");
			con = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static Connection getBloodBankUATConnection(){
		Connection con = null;
		try {
			InitialContext ic = new InitialContext();
			DataSource dataSource = (DataSource) ic.lookup("mob_blood_bank_uat");
			con = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static Connection getRAOLConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@10.226.2.16:1522/raoldb", "AHIS", "Ahis123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static String getGenderFromCode(int genCode){
		String gen = "";
		switch (genCode) {
		case 0: gen = "O";			
			break;
		case 1: gen = "M";			
			break;
		case 2: gen = "F";			
			break;
		}
		return gen;
	}
		
	public static int getAge(Date dob){
		Calendar today = Calendar.getInstance();
		Calendar db = Calendar.getInstance();
		db.setTime(dob);
		int age = today.get(Calendar.YEAR) - db.get(Calendar.YEAR);
		if (today.get(Calendar.MONTH) < db.get(Calendar.MONTH))
			age--;
		else if (today.get(Calendar.MONTH) == db.get(Calendar.MONTH) 
				&& today.get(Calendar.DAY_OF_MONTH) < db.get(Calendar.DAY_OF_MONTH))
			age--;
		return  age;
	}
	
	public static String getName(String fName, String mName, String lName){
		String name = "";
		name += (fName == null) ? "" : fName;
		name += (mName == null) ? "" : " " + mName;
		name += (lName == null) ? "" : " " + lName;
		return name;
	}
	
	public static int checkDateValidity(java.sql.Date fromDate, java.sql.Date toDate){
		Calendar fDate = Calendar.getInstance();
		fDate.setTime(fromDate);
		Calendar tDate = Calendar.getInstance();
		if (toDate == null){
			tDate.add(Calendar.DATE, 1);
		}
		else
			tDate.setTime(toDate);
		
		Calendar sysdate = Calendar.getInstance();
		
		if (!(fDate.getTimeInMillis() <= sysdate.getTimeInMillis() && tDate.getTimeInMillis() >= sysdate.getTimeInMillis()))
			return 0;
		return 1;
	}
	
	public static String getDateAfterDays(int days){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, days);  // number of days to add
		return sdf.format(c.getTime());  // dt is now the new date
	}
	
	
}
