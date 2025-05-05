package hisglobal.exceptions;




import java.io.FileInputStream;
import java.util.Properties;

import hisglobal.utility.HisUtil;

import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import hisglobal.transactionmgnt.HisDAO;

/**
 * <pre>
 * Purpose --> This HisException class logs the error/DAO status into log file. 
	
	Path for Property File have been defined in hisPath.properties file that has been kept into
	WEB-INF\classes\ folder.
	
	Path for log file has been defined in property file
	
	Recommendations --> put configuration file into WEB-INF/hisConfig folder. sothat while making war file
	these files automatically include in the WAR
	 </pre>
	 
 * @author Ajay Kumar Gupta <br> Copyright ©C-DAC Noida
 *
 */

public class HisException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private static Logger log = null;
	//private static final String pathFileName = "hisglobal.hisconfig.hisPath"; // containing into class folder

	private static String errConfigPath = "";
	private static String DAOConfigPath = "";
	
	private static JCS hisExceptionCacheVO;
	private String errID = "";
	
	public HisException()
	{
		super("HiS Exception");
		
	}

	public HisException(String _msg)
	{
		super(_msg);
		if(hisExceptionCacheVO==null)
		{
			try {
				hisExceptionCacheVO = JCS.getInstance("hisExceptionCacheVO");
			} catch (CacheException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Properties loadPropertiesFilesinCache(String fileName, String cacheName)
	{
		// put message
		
		//System.out.println("<--------------------------------------------initializing   loadPropertiesFilesinCache "+cacheName+" ------------------------------------------------------------>");
		Properties props = new Properties();
	    FileInputStream istream = null;
	    try {
	      istream = new FileInputStream(fileName);
	      props.load(istream);
	      istream.close();
	      hisExceptionCacheVO.put(cacheName,props);
	    }
	    catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	    return props;
	    
	}
	
	/**
	 * Parameterized Constructor for HisException. This is used to Log the Exceptions in a Log file.
	 * Developer will throw HisException rather than Exception
	 * <code>
	 * e.g. throw new HisException("Store","Indent Register.getIndentNo()","Null Pointer Exception");
		</code>	
	 * @param moduleName - The Current Working Module.
	 * @param fileName - The Current Working Java File.
	 * @param msgtest - The Exception Message thrown by the try block.
	 */
	public HisException(String moduleName, String fileName, String msgtest) {

		
		String strMsg1 = "0";
		String strMsg2 = "0";
		String strMsg3 = "0";
		String strTemp = "";
		String strSeatId = "0";

		int intLen = 0;

		String strProcName = "{call PKG_MMS_DML.dml_application_error_log_dtl(?,?,?,?,?,?,?,?,?,?)}";// 11 Varibale's
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";
		
		
		// internal function to set config path
		try {
			hisExceptionCacheVO = JCS.getInstance("hisExceptionCacheVO");
		} catch (CacheException e) {
			e.printStackTrace();
		}
		
		/*setConfigPath();

		if (log == null)
			log = Logger.getLogger("");
		
		Properties errConfigPathProperties= (Properties)hisExceptionCacheVO.get("errConfigPathProperties");
		
		if(errConfigPathProperties==null)
		{
			errConfigPathProperties=loadPropertiesFilesinCache(errConfigPath,"errConfigPathProperties");
		}
		
		// put message
		PropertyConfigurator.configure(errConfigPathProperties);

		errID = getErrID(); // get error id
		log.info("[ERROR ID :: " + errID + "]" + "[" + moduleName + " --> "
				+ fileName + "] [" + msgtest + "]");*/
		
		// logging error into db
		try {
			intLen = msgtest.length();
			if (intLen > 4000) {
				strMsg1 = msgtest.substring(0, 4000);
				strTemp = msgtest.substring(4000);

				intLen = strTemp.length();
				if (intLen > 4000) {
					strMsg2 = strTemp.substring(0, 4000);
					strMsg3 = strTemp.substring(4000, 4000);
				} else
					strMsg2 = strTemp;
			} else
				strMsg1 = msgtest;

			daoObj = new HisDAO("HisException", "HisException");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "p_mode", "1"); // 1
			daoObj.setProcInValue(nProcIndex, "p_GSTR_ERROR_MSG1",strMsg1.trim()); // 2
			daoObj.setProcInValue(nProcIndex, "p_GSTR_ERROR_MSG2",strMsg2.trim()); // 3
			daoObj.setProcInValue(nProcIndex, "p_GSTR_ERROR_MSG3",strMsg3.trim()); // 4
			daoObj.setProcInValue(nProcIndex, "p_GSTR_MODULE_NAME", moduleName); // 5
			daoObj.setProcInValue(nProcIndex, "p_GSTR_FILE_NAME", fileName); // 6
			daoObj.setProcInValue(nProcIndex, "p_GNUM_SEAT_ID", strSeatId); // 7
			daoObj.setProcInValue(nProcIndex, "p_GNUM_HOSPITAL_CODE", "998"); // 8
			daoObj.setProcOutValue(nProcIndex, "p_ERROR_ID", 1); // 9
			daoObj.setProcOutValue(nProcIndex, "err", 1); // 10
			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			errID = daoObj.getString(nProcIndex, "p_ERROR_ID");
		} catch (Exception e) {
			// do nothing here
			e.printStackTrace();
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
		
		
		
		
	}

		
	/**
	 *
		This function is being called through HisDAO.java file. 
		This function will record status of HisDAO usage 
		
	 * @param moduleName - The Current Working Module.
	 * @param fileName - The Current Working Java File.
	 * @param sts - 0 is "hisDAO OPEN" and 1 is "hisDAO CLOSE"
	 */ 
	public static void putHisDAOStatus(String moduleName, String fileName,
			int sts) {

		String msg = "hisDAO OPEN";
		if (sts == 1)
			msg = "hisDAO CLOSE";

		setConfigPath();

		if (log == null)
			log = Logger.getLogger("");

		
		Properties DAOConfigPathProperties= (Properties)hisExceptionCacheVO.get("DAOConfigPathProperties");
		
		if(DAOConfigPathProperties==null)
		{
			DAOConfigPathProperties=loadPropertiesFilesinCache(DAOConfigPath,"DAOConfigPathProperties");
		}
		
		// put message
		PropertyConfigurator.configure(DAOConfigPathProperties);
		// put message
		//PropertyConfigurator.configure(DAOConfigPath);
		log.info("[" + moduleName + " --> " + fileName + "] [" + msg + "]");
	}
		
	/**
	 * This function sets the config path
	 */
	private static void setConfigPath() {
		
		if(hisExceptionCacheVO==null)
		{
			try {
				hisExceptionCacheVO = JCS.getInstance("hisExceptionCacheVO");
			} catch (CacheException e) {
				e.printStackTrace();
			}
		}
		
		DAOConfigPath=(String)hisExceptionCacheVO.get("hisExceptionCacheVO_DAOConfigPath");
		if (DAOConfigPath==null||DAOConfigPath.equals("") ) 
		{
			//System.out.println("--------------------------initailizing DAO_CONFIG from file --------------------");
			DAOConfigPath = HisUtil.getParameterFromHisPathXML("DAO_CONFIG");
			try {
				hisExceptionCacheVO.put("hisExceptionCacheVO_DAOConfigPath",DAOConfigPath);
			} catch (CacheException e) {
					e.printStackTrace();
			}
		}
		errConfigPath =(String)hisExceptionCacheVO.get("hisExceptionCacheVO_errConfigPath");
		
		if(errConfigPath==null || errConfigPath.equals(""))
		{
			//System.out.println("--------------------------initailizing ERROR_CONFIG from file --------------------");
			errConfigPath =  HisUtil.getParameterFromHisPathXML("ERROR_CONFIG");
			try {
				hisExceptionCacheVO.put("hisExceptionCacheVO_errConfigPath",errConfigPath);
			} catch (CacheException e) {
				e.printStackTrace();
			}
		}
	}// end setConfigPath() function

	/**
	 * Format of errNo will be yyyyxxxxxx
	 * 
	 */
	private static synchronized String getErrID() {
		int errNo = 0;
		String year = "";
		String temp = "";
		ErrorCounter errObj = null;
		HisUtil util = null;

		try {
			errObj = new ErrorCounter();
			util = new HisUtil("hisglobal", "HisException");

			errNo = Integer.parseInt(errObj.getErrorCount());
			year = util.getASDate("yyyy");
			if (errNo == 0) {

				errNo = Integer.parseInt(year + "000001");

			} else {
				temp = (String.valueOf(errNo)).substring(0, 4);

				if (Integer.parseInt(temp) == Integer.parseInt(year))
					errNo = errNo + 1;
				else
					errNo = Integer.parseInt(year + "000001");
			}

			// set the value in xml file
			errObj.setErrorCount(String.valueOf(errNo));
		} catch (Exception e) {

			e.printStackTrace();

			errNo = 0;
		} finally {
			if (errObj != null)
				errObj = null;
			if (util != null)
				util = null;
		}

		return String.valueOf(errNo);

	}

	/**
	 * To get Error ID that user has to display
	 * 
	 * @return
	 */
	public String getErrorID() {
		return this.errID;
	}
}

