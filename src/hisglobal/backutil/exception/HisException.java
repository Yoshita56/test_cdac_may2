
/**
	Purpose --> This HisException class logs the error/DAO status into log file. 
	
	Path for Property File have been defined in hisPath.properties file that has been kept into
	WEB-INF\classes\ folder.
	
	Path for log file has been defined in property file
	
	Recommendations --> put configuration file into WEB-INF/hisConfig folder. sothat while making war file
	these files automatically include in the WAR 
*/

package hisglobal.backutil.exception;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class HisException extends Exception {
	
	private static final long serialVersionUID = 1L;

	private static Logger log = null;
				
	private static final String pathFileName = "hisconfig.hisPath";		//containing into class folder
	private static String errConfigPath = "";
	private static String DAOConfigPath = ""; 
		
	/*
		constructor. Developer will throw HisException rather than Exception
		e.g. throw new HisException("Store","Indent Register.getIndentNo()","Null Pointer Exception")
	*/
	public HisException(String moduleName,String fileName,String msgtest) {
	
		//internal function to set config path
		setConfigPath();
		
		if(log == null) log = Logger.getLogger("");
					
		//put message
		PropertyConfigurator.configure(errConfigPath);
		log.info("[" + moduleName + " --> " + fileName + "] [" + msgtest + "]");
	}
		
	/*
		This function is being called through HisDAO.java file. 
		This function will record status of HisDAO usage 
		
		sts = 0	msg = "hisDAO OPEN"
		sts = 1 msg = "hisDAO CLOSE"
	*/	 
	public static void putHisDAOStatus(String moduleName,String fileName,int sts) {
		
		String msg = "hisDAO OPEN";
		if(sts == 1) msg = "hisDAO CLOSE";
		
		setConfigPath();
		
		if(log == null) log = Logger.getLogger("");
					
		//put message
		PropertyConfigurator.configure(DAOConfigPath);
		log.info("[" + moduleName + " --> " + fileName + "] [" + msg + "]");
	}
		
	//This function sets the config path
	private static void setConfigPath() {
		
		if(DAOConfigPath.equals("") || errConfigPath.equals("")) {
			ResourceBundle rsBundle = ResourceBundle.getBundle(pathFileName);
			errConfigPath = rsBundle.getString("ERROR_CONFIG");
			DAOConfigPath = rsBundle.getString("DAO_CONFIG");
			rsBundle = null;
		}
	}//end setConfigPath() function
	
}

