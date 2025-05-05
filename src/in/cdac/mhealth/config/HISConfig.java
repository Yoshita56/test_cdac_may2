package in.cdac.mhealth.config;

public class HISConfig {
	
 		//MONGO DB SERVICES for NIMS UAT
		//public static String HIS_MONGOSERVER_INV_DBNAME = "cdacpatprofile8";
		//public static String HIS_MONGOSERVER_INV_CONNECTION = "mongodb://10.226.2.96:27017";
		
		//MONGO DB SERVICES for AIIMS Patna Testing
		public static String HIS_MONGOSERVER_INV_DBNAME = "cdacpatprofile8";
		public static String HIS_MONGOSERVER_INV_CONNECTION = "mongodb://10.10.10.72:27017";
		
		public static String IMAGE_FOR_HEADER_WINDOWS="C:/NIMS/AHIMSG5/reportimage/nimsHeader.jpg";
		public static String IMAGE_FOR_HEADER_LINUX="/opt/NIMS/AHIMSG5/reportimage/nimsHeader.jpg";
}
