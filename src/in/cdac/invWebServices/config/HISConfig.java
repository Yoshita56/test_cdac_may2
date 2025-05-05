package in.cdac.invWebServices.config;

public class HISConfig {
	
 		//MONGO DB SERVICES for NIMS UAT
		/*public static String HIS_MONGOSERVER_INV_DBNAME = "cdacpatprofile8";
		public static String HIS_MONGOSERVER_INV_CONNECTION = "mongodb://10.226.2.96:27017";*/
		
		//MONGO DB SERVICES for AIIMS Patna Testing
		/*public static String HIS_MONGOSERVER_INV_DBNAME = "cdacpatprofile8";
		public static String HIS_MONGOSERVER_INV_CONNECTION = "mongodb://10.10.10.72:27017";*/
		
	
		//MONGO DB SERVICES for AIIMS Manglagiri
		public static String HIS_MONGOSERVER_INV_DBNAME = "cdacpatprofile8";
		public static String HIS_MONGOSERVER_INV_CONNECTION = "mongodb://10.10.10.72:27017";
	
		//MONGO DB SERVICES for TS UAT
		/*public static String HIS_MONGOSERVER_INV_DBNAME = "cdacpatprofile8";
		public static String HIS_MONGOSERVER_INV_CONNECTION = "mongodb://10.226.2.169:27017";*/
	
		//MONGO DB SERVICES for NIMS UAT
		public static String HIS_FTPSERVER_INV_CONNECTION = "ftp://ftp_raol:Raol12345@10.226.1.173/ftpserver/ftpserver";
		
		//MONGO DB SERVICES for NIMS Prod
		//public static String HIS_FTPSERVER_INV_CONNECTION = "ftp://prdnims:prdnims123@10.10.136.39/ftpserver/ftpserver";
	
		//MONGO DB SERVICES for NIMS Prod
		/*public static String HIS_MONGOSERVER_INV_DBNAME = "cdacpatprofile8_nims";
		public static String HIS_MONGOSERVER_INV_CONNECTION = "mongodb://nimsehms:ts3ehms_IDC@10.10.136.38:27017/?authSource=cdacpatprofile8_nims";*/
	
		public static String IMAGE_FOR_HEADER_WINDOWS="C:/NIMS/AHIMSG5/reportimage/nimsHeaderForDesk.jpg";
		public static String IMAGE_FOR_HEADER_LINUX="/opt/NIMS/AHIMSG5/reportimage/nimsHeaderForDesk.jpg";
}
