/*
		Name		Ajay Kumar Gupta
 */

package hisglobal.transactionmgnt;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.sql.rowset.WebRowSet;

import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;

import com.sun.rowset.WebRowSetImpl;

/**
 * 
 * Global Class for Queries, Functions and Procedure execution Processes. 
 * Database Connectivity is also handle by the Class, user no need to create 
 * Database Connections, just set Query or Function or Procedure and execute it. 
 * 
 * @author Ajay Kumar Gupta <br> Copyright ©C-DAC Noida
 *
 */
public final class HisDAO {
	private static Context ic = null;
	private static DataSource ds = null;
	
	private static String lookUpName = "";
	private static String lookUpName_EDB = "AHIS_EDB";
	//private static String connURL = "";
	private static JCS hisDAOCacheVO;
	//private static String userName = "";
	//private static String pwd = "";
	
	private List<HisQuery> qryObj = null;
	private List<HisProcedure> procObj = null;
	private List<HisFunction> funcObj = null;
	private List<String> finalObj = null;

	// private Map proc_out_value = null;

	private int qryIndex = 0;
	private int procIndex = 0;
	private int funcIndex = 0;

	private String moduleName = "";
	private String fileName = "";
	private boolean retValue = false;
	private Connection gblConn = null;

	/**
	 * used for error messages
	 */
	private String errMsg = "";
	
	//private static final String pathFileName = "hisglobal.hisconfig.hisPath"; // containing into class folder
	/**
	 * constructor with arguments Enters HisDAO Open status into log file.
	 * 
	 * @param moduleName -The
	 *            Current Working Module.
	 * @param fileName -
	 *            The Current Working Java File.
	 */
	public HisDAO(String moduleName, String fileName) {
		
		this.moduleName = moduleName;
		this.fileName = fileName;
		//HisException.putHisDAOStatus(this.moduleName, this.fileName, 0);
		try {
			hisDAOCacheVO = JCS.getInstance("hisDAOCacheVO");
		} catch (CacheException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function sets the config path
	 */
	private static void setConfigPath() {
		
		if(lookUpName!=null && lookUpName.equals(""))
		{
			lookUpName=(String)hisDAOCacheVO.get("hisDAOCacheVO_lookUpName");
		}
		
		if(lookUpName==null || lookUpName.equals(""))
		{
		ResourceBundle rsBundle = null;
		
		try {	
			
				lookUpName = HisUtil.getParameterFromHisPathXML("JNDI_LOOKUP");
				System.out.println("setConfigPath()::lookUpName"+lookUpName);
				hisDAOCacheVO.put("hisDAOCacheVO_lookUpName",lookUpName);
				//connURL = rsBundle.getString("DIRECT_CONN_URL");
				//userName = rsBundle.getString("CONN_USER_NAME");
				//pwd = rsBundle.getString("CONN_PWD");
				rsBundle = null;
			
		}
		catch(Exception e) {
			
			System.out.println("error :: " + e.getMessage());
		}
		finally {
			if(rsBundle != null) rsBundle = null;
		}
		}
		
	}// end setConfigPath() function
	
	/**
	 * returns connection. This function will be used within this class
	 * 
	 * @return Connection by retrieving from IntialContext through DataSource.
	 * @throws Exception
	 */
	private Connection getConnection() throws Exception {

		Connection conn = null;

		retValue = false;
		this.errMsg = "";

		try {
			setConfigPath();
			if(lookUpName == null) lookUpName = "";
			//if(connURL == null) connURL = "";
			
		//	System.out.println("lookUpName [DAO] = " + lookUpName);
			//System.out.println("connURL = " + connURL);
			
			if(!lookUpName.equals("")) { 
				/*
				if (ic == null || ds == null) {
					ic = new InitialContext();
					ds = (DataSource) ic.lookup(lookUpName);
				}
				*/
				ic = new InitialContext();
				ds = (DataSource) ic.lookup(lookUpName);
				conn = ds.getConnection();
			}
			/*
			else {
				if(!connURL.equals("")) {
					System.out.println("entyered in driver");
					Class.forName("oracle.jdbc.OracleDriver");
					conn = DriverManager.getConnection(connURL,userName,pwd);
				}
				else {
					throw new Exception("Neither JNDI_LOOKUP nor DIRECT_CONN_URL defined in hisPath.properties file !!");
				}
			}*/
			retValue = true;
		} catch (Exception e) {
			this.errMsg = "HisDAO.getConnection() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		return conn;
	}

	/**
	 * returns return value
	 * 
	 * @return boolean
	 */
	public boolean getReturnValue() {
		return this.retValue;
	}

	/**
	 * retrieves Query from user and returns HisQuery Index
	 * 
	 * @param qry -
	 *            SQL Query.
	 * @return int - query Index
	 * @see hisglobal.transactionmgnt#HisQuery
	 * 
	 */
	public int setQuery(String qry) {

		retValue = false;
		if (qryObj == null)
			qryObj = new ArrayList<HisQuery>(1);
		// create instance of query class and store into arraylist
		qryObj.add(qryIndex++, HisQuery.getQryInstance(qry));
		retValue = true;
		return (qryIndex - 1);
	}

	/**
	 * retrieves Procedure from user and returns HisProcedure Index
	 * 
	 * @param proc -
	 *            Stored Procedures
	 * @return int - procedure Index
	 * @see hisglobal.transactionmgnt#HisProcedure
	 */
	public int setProcedure(String proc) {

		retValue = false;
		if (procObj == null)
			procObj = new ArrayList<HisProcedure>(1);
		// create instance of query class and store into arraylist
		procObj.add(procIndex++, HisProcedure.getProcInstance(proc));
		retValue = true;
		return (procIndex - 1);
	}

	/**
	 * retrieves Function from user and returns HisFunction Index
	 * 
	 * @param func -
	 *            SQL Functions
	 * @return int - function Index
	 * @see hisglobal.transactionmgnt#HisFunction
	 */
	public int setFunction(String func) {

		retValue = false;
		if (funcObj == null)
			funcObj = new ArrayList<HisFunction>(1);
		// create instance of query class and store into arraylist
		funcObj.add(funcIndex++, HisFunction.getFuncInstance(func));
		retValue = true;
		return (funcIndex - 1);
	}

	/**
	 * sets the value for the parameterized query.
	 * 
	 * @param qryIndex -
	 *            query Index which obtained by {@link #setQuery(String)} method.
	 * @param parameterIndex -
	 *            starts with <b>1</b>
	 * @param value -
	 *            SQL Query Parameter value, for corresponding parameterIndex.
	 * @throws Exception -
	 *             HisException if Query Index is Invalid.
	 *             
	 * @see hisglobal.exceptions.HisException            
	 *             
	 */
	public void setQryValue(int qryIndex, int parameterIndex, String value)
			throws Exception {

		retValue = false;
		this.errMsg = "";

		// get HisQuery Instance based on qryIndex & call setValue method to set
		// the value
		if (this.qryIndex > qryIndex) {
			((HisQuery) qryObj.get(qryIndex)).setValue(parameterIndex, value);
			retValue = true;
		} else {
			this.errMsg = "HisDAO.setQryValue() -->Invalid query index";
			throw new Exception(this.errMsg);
		}
	}

	/**
	 * sets the input value for the parameterized procedure
	 * 
	 * @param procIndex - procedure Index which obtained by {@link #setProcedure(String)} method.
	 * @param parameterName - name of the Procedure Parameter.
	 * @param value - values for the corresponding Procedure Parameter.
	 * @throws Exception - HisException if Procedure Index is Invalid.
	 * 
	 * @see hisglobal.exceptions.HisException     
	 */
	public void setProcInValue(int procIndex, String parameterName, String value)
			throws Exception {

		retValue = false;
		this.errMsg = "";

		// get HisProcedure Instance based on procIndex & call setValue method
		// to set the value
		if (this.procIndex > procIndex) {
			((HisProcedure) procObj.get(procIndex)).setInValue(parameterName,
					value);
			retValue = true;
		} else {
			this.errMsg = "HisDAO.setProcInValue() -->Invalid procedure index";
			throw new Exception(this.errMsg);
		}
	}
	
	/**
	 * sets the input value for the parameterized procedure
	 * 
	 * @param procIndex - procedure Index which obtained by {@link #setProcedure(String)} method.
	 * @param parameterName - name of the Procedure Parameter.
	 * @param value - values for the corresponding Procedure Parameter.
	 * @throws Exception - HisException if Procedure Index is Invalid.
	 * 
	 * @see hisglobal.exceptions.HisException     
	 */
	public void setProcInValue(int procIndex, String parameterName, String value,int paramIndex)
			throws Exception {

		retValue = false;
		this.errMsg = "";

		// get HisProcedure Instance based on procIndex & call setValue method
		// to set the value
		if (this.procIndex > procIndex) {
			((HisProcedure) procObj.get(procIndex)).setInValue(parameterName,
					value,paramIndex);
			retValue = true;
		} else {
			this.errMsg = "HisDAO.setProcInValue() -->Invalid procedure index";
			throw new Exception(this.errMsg);
		}
	}

	/*
	 * this function 
	 * 
	 */
	
/**
 * sets the input value for the parameterized function type
 * 1 for integer, 2 for double and 3 for string
 * @param funcIndex - function Index which obtained by {@link #setFunction(String)} method.
 * @param parameterIndex - starts with <b>2</b>.
 * @param value - values for the corresponding Function Parameter.
 * @throws Exception - HisException if Function Index is Invalid.
 * 
 * @see hisglobal.exceptions.HisException     
 */
	public void setFuncInValue(int funcIndex, int parameterIndex, String value)
			throws Exception {

		retValue = false;
		this.errMsg = "";

		// get HisFunction Instance based on funcIndex & call setValue method
		// to set the value
		if (this.funcIndex > funcIndex) {
			((HisFunction) funcObj.get(funcIndex)).setInValue(String
					.valueOf(parameterIndex), value);
			retValue = true;
		} else {
			this.errMsg = "HisDAO.setFuncInValue() -->Invalid function index";
			throw new Exception(this.errMsg);
		}
	}


	/**
	 * sets the output value for the parameterized query.
	 * @param procIndex - procedure Index which obtained by {@link #setProcedure(String)} method.
	 * @param parameterName - name of Procedure Parameter.
	 * @param outputType - <b>1</b> for String and <b>2</b> for Object
	 * @throws Exception - HisException if Procedure Index is Invalid.
	 * 
	 * @see hisglobal.exceptions.HisException     
	 */
	public void setProcOutValue(int procIndex, String parameterName,
			int outputType) throws Exception {

		retValue = false;
		this.errMsg = "";

		// get HisProcedure Instance based on procIndex & call setValue method
		// to set the value
		if (this.procIndex > procIndex) {
			((HisProcedure) procObj.get(procIndex)).setOutValue(parameterName,
					outputType);
			retValue = true;
		} else {
			this.errMsg = "HisDAO.setProcOutValue() -->Invalid procedure index";
			throw new Exception(this.errMsg);
		}
	}

	//added by shalini for fire_without_commit
		public void setProcOutValue_new(int procIndex, String parameterName,
				int outputType) throws Exception {

			retValue = false;
			this.errMsg = "";

			// get HisProcedure Instance based on procIndex & call setValue method
			// to set the value
			if (this.procIndex > procIndex) {
				((HisProcedure) procObj.get(procIndex)).setOutValue_new(parameterName,
						outputType);
				retValue = true;
			} else {
				this.errMsg = "HisDAO.setProcOutValue() -->Invalid procedure index";
				throw new Exception(this.errMsg);
			}
		}
		
	/**
	 * sets the output value for the parameterized query.
	 * @param procIndex - procedure Index which obtained by {@link #setProcedure(String)} method.
	 * @param parameterName - name of Procedure Parameter.
	 * @param outputType - <b>1</b> for String and <b>2</b> for Object
	 * @throws Exception - HisException if Procedure Index is Invalid.
	 * 
	 * @see hisglobal.exceptions.HisException     
	 */
	public void setProcOutValue(int procIndex, String parameterName,
			int outputType,int paramIndex) throws Exception {

		retValue = false;
		this.errMsg = "";

		// get HisProcedure Instance based on procIndex & call setValue method
		// to set the value
		if (this.procIndex > procIndex) {
			((HisProcedure) procObj.get(procIndex)).setOutValue(parameterName,
					outputType,paramIndex);
			retValue = true;
		} else {
			this.errMsg = "HisDAO.setProcOutValue() -->Invalid procedure index";
			throw new Exception(this.errMsg);
		}
	}

		
	/**
	 * sets the output value for the parameterized query
	 * @param funcIndex - function Index which obtained by {@link #setFunction(String)} method.
	 * @param outputType - <b>1</b> for int/double/string and <b>2</b> for resultset
	 * @throws Exception - HisException if Function Index is Invalid.
	 * 
	 *  @see hisglobal.exceptions.HisException   
	 */
	public void setFuncOutValue(int funcIndex, int outputType) throws Exception {

		retValue = false;
		this.errMsg = "";

		// get HisProcedure Instance based on procIndex & call setValue method
		// to set the value
		if (this.funcIndex > funcIndex) {
			((HisFunction) funcObj.get(funcIndex)).setOutValue(outputType);
			retValue = true;
		} else {
			this.errMsg = "HisDAO.setFuncOutValue() -->Invalid function index";
			throw new Exception(this.errMsg);
		}
	}

		
	/**
	 * used to add queries/procedure into batch. Call this method after setting value for parameterized query/procedure if there
	 * is parameterized query/procedure.
	 * 
	 * It does not execute the query/procedure.
	 *  
	 * Logic --> add 1000 in index while storing index into arraylist for
	 * procedure. At the time of execution, we could know whether we have to
	 * execute either query or procedure
	 *  
	 * @param index - queryIndex or procedureIndex which obtained by {@link #setQuery(String)} or {@link #setProcedure(String)} method.
	 * @param mode - <b>0</b> if query are added into batch and <b>1</b> if procedures are added into batch
	 * @throws Exception - HisException if Query or Procedure Index is Invalid.
	 * 
	 *  @see hisglobal.exceptions.HisException  
	 * 
	 * 
	 */
	public void execute(int index, int mode) throws Exception {

		retValue = false;
		this.errMsg = "";

		if (finalObj == null)
			finalObj = new ArrayList<String>(1);
		// for query
		if (mode == 0) {
			if (this.qryIndex > index) {
				// add into final list
				finalObj.add(String.valueOf(index));
				System.out.println("Query"+this.qryObj.get(index));
				((HisQuery) this.qryObj.get(index)).execute();
				retValue = true;
			} else {
				this.errMsg = "HisDAO.execute() -->Invalid query index";
				throw new Exception(this.errMsg);
			}
		} else {
			if (this.procIndex > index) {
				// add into final list [add 1000 for identifying procedure]
				finalObj.add(String.valueOf(index + 1000));
				((HisProcedure) this.procObj.get(index)).execute();
				retValue = true;
			} else {
				this.errMsg = "HisDAO.execute() -->Invalid procedure index";
				throw new Exception(this.errMsg);
			}
		}
	}

		
	/**
	 * executes a single query whether query is parameterized or not and returns WebRowSet. 
	 * qryIndex is index returned by {@link #setQuery(String)} method.
	 * Use this function when query is parameterized.
	 * 
	 * @param qryIndex - query Index which obtained by {@link #setQuery(String)} method.
	 * @return Query Results in WebRowSet 
	 * @throws Exception - HisException if Query Index is Invalid.
	 * 
	 *  @see hisglobal.exceptions.HisException  
	 */
	public WebRowSet executeQry(int qryIndex) throws Exception {

		Connection conn = null;
		WebRowSet ws = null;
		retValue = false;
		this.errMsg = "";

		try {
			if (this.qryIndex > qryIndex) {
				conn = this.getConnection();
				ws = ((HisQuery) qryObj.get(qryIndex)).executeQry(conn);
				retValue = true;
			} else {
				this.errMsg = "Invalid query index";
				throw new Exception(this.errMsg);
			}
		} catch (Exception e) {
			this.retValue = false;
			this.errMsg = "HisDAO.executeQry(1 Args) -->" + e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			// close connection
			if (conn != null) {
				try {
					conn.close();
					conn = null;
				} catch (Exception e) {
				}
			}
		}

		return ws;
	}

		
	/**
	 * executes a single query whether query is parameterized or not and returns Array List. 
	 * qryIndex is index returned by {@link #setQuery(String)} method.
	 * Use this function when query is parameterized.
	 * 
	 * @param qryIndex - query Index which obtained by {@link #setQuery(String)} method.
	 * @param no_of_fields - Number of Fields specified in SQL Query.
	 * @return ArrayList - ArrayList Object contain Results. 
	 * @throws Exception - HisException if Query Index is Invalid.
	 *  @see hisglobal.exceptions.HisException  
	 */
	public ArrayList<String> executeQry(int qryIndex, int no_of_fields)
			throws Exception {

		Connection conn = null;
		ArrayList<String> qryResult = null;

		this.retValue = false;
		this.errMsg = "";

		try {
			if (this.qryIndex > qryIndex) {
				conn = this.getConnection();
				qryResult = ((HisQuery) qryObj.get(qryIndex)).executeQry(conn,
						no_of_fields);
				retValue = true;
			} else {
				this.errMsg = "Invalid query index";
				throw new Exception(this.errMsg);
			}
		} catch (Exception e) {
			this.retValue = false;
			this.errMsg = "HisDAO.executeQry(2 Args) -->" + e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			// close connection
			if (conn != null) {
				try {
					conn.close();
					conn = null;
				} catch (Exception e) {
				}
			}
		}

		return qryResult;
	}

	/*
	 * This function consult.
	 */
	
	/**
	 * executes a single Function. 
	 * funcIndex is index returned by {@link #setFunction(String)} method. 
	 * If there is output parameter defined for the
	 * function then {@link #getFuncString(int)} is used to get the value of output
	 * parameterized
	 * 
	 * @param funcIndex - function Index which obtained by {@link #setFunction(String)} method.
	 * @throws Exception - HisException if Function Index is Invalid.
	 * @see hisglobal.exceptions.HisException 
	 */
	public void executeFunction(int funcIndex) throws Exception {

		Connection conn = null;
		retValue = false;
		this.errMsg = "";

		try {
			if (this.funcIndex > funcIndex) {
				conn = this.getConnection();
				((HisFunction) funcObj.get(funcIndex)).executeFunc(conn);
				retValue = true;
			} else {
				this.errMsg = "Invalid function index";
				throw new Exception(this.errMsg);
			}
		} catch (Exception e) {
			this.retValue = false;
			this.errMsg = "HisDAO.executeFunction() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			try {
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
			}
		}
	}
	
	/**
	 * executes a single Function. 
	 * funcIndex is index returned by {@link #setFunction(String)} method. 
	 * If there is output parameter defined for the
	 * function then {@link #getFuncString(int)} is used to get the value of output
	 * parameterized
	 * 
	 * @param funcIndex - function Index which obtained by {@link #setFunction(String)} method.
	 * @throws Exception - HisException if Function Index is Invalid.
	 * @see hisglobal.exceptions.HisException 
	 */
	public void executeFunction_new(int funcIndex) throws Exception {

		retValue = false;
		this.errMsg = "";

		try {
			if (this.funcIndex > funcIndex) {
				if(this.gblConn == null) 
				{
					gblConn = this.getConnection();
					gblConn.setAutoCommit(false);
				}
				
				((HisFunction) funcObj.get(funcIndex)).executeFunc(gblConn);
				retValue = true;
			} else {
				this.errMsg = "Invalid function index";
				throw new Exception(this.errMsg);
			}
		} catch (Exception e) {
			this.retValue = false;
			this.errMsg = "HisDAO.executeFunction() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}finally {
			try {
				if (gblConn != null) {
					gblConn.close();
					gblConn = null;
				}
			} catch (Exception e) {
			}
		} 
	}
	
	
	

	/**
	 * executes a single Function. 
	 * funcIndex is index returned by {@link #setFunction(String)} method. 
	 * If there is output parameter defined for the
	 * function then {@link #getFuncString(int)} is used to get the value of output
	 * parameterized
	 * 
	 * @param funcIndex - function Index which obtained by {@link #setFunction(String)} method.
	 * @throws Exception - HisException if Function Index is Invalid.
	 * @see hisglobal.exceptions.HisException 
	 */
	public void executeFuncForNumeric(int funcIndex) throws Exception {

		Connection conn = null;
		retValue = false;
		this.errMsg = "";

		try {
			if (this.funcIndex > funcIndex) {
				conn = this.getConnection();
				((HisFunction) funcObj.get(funcIndex)).executeFuncForNumeric(conn);
				retValue = true;
			} else {
				this.errMsg = "Invalid function index";
				throw new Exception(this.errMsg);
			}
		} catch (Exception e) {
			this.retValue = false;
			this.errMsg = "HisDAO.executeFunction() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			try {
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
			}
		}
	}

	/*
	 * This function  consult.
	 */
	
	/**
	 * executes a single procedure. 
	 * procIndex is index returned by {@link #setProcedure(String)} method. 
	 * If there is output parameter defined for the
	 * procedure then getOutputValue() is used to get the value of output
	 * parameterized
	 * 
	 * @param procIndex - procedure Index which obtained by {@link #setProcedure(String)} method.
	 * @throws Exception  - HisException if Procedure Index is Invalid.
	 * @see hisglobal.exceptions.HisException 
	 */
	public void executeProcedure(int procIndex) throws Exception {

		Connection conn = null;
		retValue = false;
		this.errMsg = "";

		try {
			if (this.procIndex > procIndex) {
				conn = this.getConnection();
				conn.setAutoCommit(false);
				((HisProcedure) procObj.get(procIndex)).executeProc(conn);
				retValue = true;
			} else {
				this.errMsg = "Invalid procedure index";
				throw new Exception(this.errMsg);
			}
		} catch (Exception e) {
			this.retValue = false;
			this.errMsg = "HisDAO.executeProcedure() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			try {
				if(this.retValue == true)
					conn.commit();
				else
					conn.rollback();
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
			}
		}
	}

	
	/**
	 * executes a single procedure. 
	 * procIndex is index returned by {@link #setProcedure(String)} method. 
	 * If there is output parameter defined for the
	 * procedure then getOutputValue() is used to get the value of output
	 * parameterized
	 * 
	 * @param procIndex - procedure Index which obtained by {@link #setProcedure(String)} method.
	 * @throws Exception  - HisException if Procedure Index is Invalid.
	 * @see hisglobal.exceptions.HisException 
	 */
	public boolean executeProcedureByPosition(Connection conn,int procIndex) throws Exception {

		//Connection conn = null;
		retValue = false;
		this.errMsg = "";

		try {
			if (this.procIndex > procIndex) {
				//conn = this.getConnection();
				//conn.setAutoCommit(false);
				((HisProcedure) procObj.get(procIndex)).executeProcByPosition(conn);
				retValue = true;
			} else {
				this.errMsg = "Invalid procedure index";
				throw new Exception(this.errMsg);
			}
		} catch (Exception e) {
			this.retValue = false;
			this.errMsg = "HisDAO.executeProcedureByPosition(Conn,procIndex) -->" + e.getMessage();
			throw new Exception(this.errMsg);
		} 
		return retValue;
	}

	
	/**
	 * executes a single procedure. 
	 * procIndex is index returned by {@link #setProcedure(String)} method. 
	 * If there is output parameter defined for the
	 * procedure then getOutputValue() is used to get the value of output
	 * parameterized
	 * 
	 * @param procIndex - procedure Index which obtained by {@link #setProcedure(String)} method.
	 * @throws Exception  - HisException if Procedure Index is Invalid.
	 * @see hisglobal.exceptions.HisException 
	 */
	public void executeProcedureByPosition(int procIndex) throws Exception {

		Connection conn = null;
		retValue = false;
		this.errMsg = "";

		try {
			if (this.procIndex > procIndex) {
				conn = this.getConnection();
				conn.setAutoCommit(false);
				((HisProcedure) procObj.get(procIndex)).executeProcByPosition(conn);
				retValue = true;
			} else {
				this.errMsg = "Invalid procedure index";
				throw new Exception(this.errMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.retValue = false;
			this.errMsg = "HisDAO.executeProcedureByPosition() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			try {
				if(this.retValue == true)
					conn.commit();
				else
					conn.rollback();
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
			}
		}
	}

	/**
	 * used to get the String value for output parameter of procedure. 
	 * If procedure is executed using {@link #executeProcedure(int)} method.
	 * 
	 * @param procIndex - procedure Index which obtained by {@link #setProcedure(String)} method.
	 * @param parameterName - Name which has been defined for output parameter.
	 * @return String - value for output parameter of procedure.
	 * @throws Exception  - HisException if Procedure Index is Invalid.
	 * @see hisglobal.exceptions.HisException 
	 */
	public String getString(int procIndex, String parameterName)
			throws Exception {
		String retData = null;
		retValue = false;

		try {
			if (this.procIndex > procIndex) {
				retData = (String) ((HisProcedure) procObj.get(procIndex))
						.getOutputValue(parameterName);
				retValue = true;
			} else {
				this.errMsg = "Invalid procedure index";
				throw new Exception(this.errMsg);
			}
		} catch (Exception e) {
			this.errMsg = "HisDAO.getString() --> " + e.getMessage();
			throw new Exception(this.errMsg);
		}

		return retData;
	}
	
	/*
	 * 
	 * procIndex --> Object returened while setting the procedure parameterName
	 * --> Name which has been defined for output parameter
	 */

	/**
	 * This function is used to get the WebRowSet value for output parameter of procedure. 
	 * If procedure is executed using {@link #executeProcedure(int)} method.
	 * 
	 * @param procIndex - procedure Index which obtained by {@link #setProcedure(String)} method.
	 * @param parameterName - Name which has been defined for output parameter.
	 * @return WebRowSet - which contains Results.
	 * @throws Exception  - HisException if Procedure Index is Invalid.
	 * @see hisglobal.exceptions.HisException 
	 */
	/*public WebRowSet getWebRowSet(int procIndex, String parameterName)
			throws Exception {
		WebRowSet retData = null;
		ResultSet rs = null;
		retValue = false;

		try {
			if (this.procIndex > procIndex) {
				
				rs = (ResultSet) ((HisProcedure) procObj.get(procIndex))
						.getOutputValue(parameterName);
				
				// initilize webrowset
				//retData = new WebRowSetImpl();
				//retData.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
								
				//retData.populate(rs);
				
				retData = (WebRowSet) ((HisProcedure) procObj.get(procIndex))
				.getOutputValue(parameterName);
				
				retValue = true;
			} else {
				this.errMsg = "Invalid procedure index";
				throw new Exception(this.errMsg);
			}
		} catch (Exception e) {
			this.errMsg = "HisDAO.getWebRowSet() --> " + e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		}

		return retData;
	}*/

	
	/**
	 * This function is used to get the WebRowSet value for output parameter of procedure. 
	 * If procedure is executed using {@link #executeProcedure(int)} method.
	 * 
	 * @param procIndex - procedure Index which obtained by {@link #setProcedure(String)} method.
	 * @param parameterName - Name which has been defined for output parameter.
	 * @return WebRowSet - which contains Results.
	 * @throws Exception  - HisException if Procedure Index is Invalid.
	 * @see hisglobal.exceptions.HisException 
	 */
	public WebRowSet getWebRowSet(int procIndex, String parameterName)
			throws Exception {
		WebRowSet retData = null;
		ResultSet rs = null;
		retValue = false;

		try {
			if (this.procIndex > procIndex) {
				
				/*rs = (ResultSet) ((HisProcedure) procObj.get(procIndex))
				
						.getOutputValue(parameterName);
				
				// initilize webrowset
				retData = new WebRowSetImpl();
				retData.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
								
				retData.populate(rs);*/
				
				retData = (WebRowSet) ((HisProcedure) procObj.get(procIndex))
				.getOutputValue(parameterName);
				
				retValue = true;
			} else {
				this.errMsg = "Invalid procedure index";
				throw new Exception(this.errMsg);
			}
		} catch (Exception e) {
			this.errMsg = "HisDAO.getWebRowSet() --> " + e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		}

		return retData;
	}

	/**
	 * This function is used to get the WebRowSet value for output parameter of procedure. 
	 * If procedure is executed using {@link #executeProcedure(int)} method.
	 * 
	 * @param procIndex - procedure Index which obtained by {@link #setProcedure(String)} method.
	 * @param parameterName - Name which has been defined for output parameter.
	 * @return WebRowSet - which contains Results.
	 * @throws Exception  - HisException if Procedure Index is Invalid.
	 * @see hisglobal.exceptions.HisException 
	 */
	public WebRowSet getWebRowSet(int procIndex, int paramIndex)
			throws Exception {
		WebRowSet retData = null;
		ResultSet rs = null;
		retValue = false;

		try {
			if (this.procIndex > procIndex) {
				
				/*rs = (ResultSet) ((HisProcedure) procObj.get(procIndex))
				
						.getOutputValue(parameterName);*/
				
				// initilize webrowset
				//retData = new WebRowSetImpl();
				//retData.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
								
				//retData.populate(rs);
				
				retData = (WebRowSet) ((HisProcedure) procObj.get(procIndex))
				.getOutputValue(paramIndex);
				
				retValue = true;
			} else {
				this.errMsg = "Invalid procedure index";
				throw new Exception(this.errMsg);
			}
		} catch (Exception e) {
			this.errMsg = "HisDAO.getWebRowSet() --> " + e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		}

		return retData;
	}

	
	/*
	 * This function is  funcIndex --> Object returened while setting the function
	 */
	
	/**
	 * used to get the String value for output parameter of function.
	 * @param funcIndex - function Index which obtained by {@link #setFunction(String)} method.
	 * @return String - output of the function.
	 * @throws Exception - HisException if Function Index is Invalid.
	 * @see hisglobal.exceptions.HisException 
	 */
	public String getFuncString(int funcIndex) throws Exception {
		String retData = null;
		retValue = false;

		try {
			if (this.funcIndex > funcIndex) {
				retData = (String) ((HisFunction) funcObj.get(funcIndex))
						.getOutputValue();
					retValue = true;
			} else {
				this.errMsg = "Invalid function index";
				throw new Exception(this.errMsg);
			}
		} catch (Exception e) {
			this.errMsg = "HisDAO.getFuncString() --> " + e.getMessage();
			throw new Exception(this.errMsg);
		}

		return retData;
	}

	
	/*
	 * This function is  funcIndex --> Object returened while setting the function
	 */
	
	/**
	 * used to get the String value for output parameter of function.
	 * @param funcIndex - function Index which obtained by {@link #setFunction(String)} method.
	 * @return String - output of the function.
	 * @throws Exception - HisException if Function Index is Invalid.
	 * @see hisglobal.exceptions.HisException 
	 */
	public String getFuncNumeric(int funcIndex) throws Exception {
		String retData = null;
		retValue = false;

		try {
			if (this.funcIndex > funcIndex) {
				retData=((HisFunction) funcObj.get(funcIndex))
				               .getOutputValue().toString();
				retValue = true;
			} else {
				this.errMsg = "Invalid function index";
				throw new Exception(this.errMsg);
			}
		} catch (Exception e) {
			this.errMsg = "HisDAO.getFuncString() --> " + e.getMessage();
			throw new Exception(this.errMsg);
		}

		return retData;
	}

	/*
	 * This function is  funcIndex --> Object returened while setting the function
	 */
	/**
	 * used to get the WebRowSet value for output parameter of function.
	 * 
	 * @param funcIndex - function Index which obtained by {@link #setFunction(String)} method.
	 * @return WebRowSet - which contains Results.
	 * @throws Exception - HisException if Function Index is Invalid.
	 * @see hisglobal.exceptions.HisException 
	 */
	public WebRowSet getFuncWebRowSet(int funcIndex) throws Exception {
		WebRowSet retData = null;
		ResultSet rs = null;
		retValue = false;

		try {
			if (this.funcIndex > funcIndex) {
				/*
				rs = (ResultSet) ((HisFunction) funcObj.get(funcIndex))
						.getOutputValue();
				// initilize webrowset
				retData = new WebRowSetImpl();
				retData.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
				retData.populate(rs);
				*/
				
				retData = (WebRowSet)((HisFunction) funcObj.get(funcIndex))
				.getOutputValue();
				retValue = true;
			} else {
				this.errMsg = "Invalid function index";
				throw new Exception(this.errMsg);
			}
		} catch (Exception e) {
			this.errMsg = "HisDAO.getFuncWebRowSet() --> " + e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		}

		return retData;
	}

	/*
	 * This function 
	 * This 
	 */
	
	/**
	 * executes all queries/procedures which has been kept into
	 * batch. 
	 * 
	 * This method either commits or rollback the entire transaction.
	 * 
	 * method does not free the objects. It only resets the value defined
	 * for query/procedure meaning that the query index/procedure index returned
	 * by {@link #setQuery(String)}/{@link #setProcedure(String)} method remains valid but the values disappears
	 * 
	 * @throws Exception - HisException if No Query/Procedure added into batch.
	 * @see hisglobal.exceptions.HisException 
	 */
	public void fire() throws Exception {

		Connection conn = null;
		int tempIndex = 0;

		retValue = false;
		this.errMsg = "";

		try {
			// finalObj contains the object index. Query/procedure will be
			// executed in same order as it is contained
			if (this.finalObj != null && this.finalObj.size() > 0) {

				// get connection
				conn = this.getConnection();
				conn.setAutoCommit(false);
				this.retValue = false;

				for (int i = 0; i < this.finalObj.size(); i++) {
					// getting object if index is less than 1000 then there is
					// query object else procedure object
					tempIndex = Integer.parseInt((String) this.finalObj.get(i));
					if (tempIndex < 1000) {
						// query object
						((HisQuery) this.qryObj.get(tempIndex))
								.executeQry_Batch(conn);
					} else {
						// procedure object
						((HisProcedure) this.procObj.get(tempIndex - 1000))
								.executeProc_BatchByPosition(conn);
					}
				}// end for loop

				this.retValue = true;
			} // end if block
			else {
				this.errMsg = "No Query/Procedure added into batch";
				throw new Exception(this.errMsg);
			}
		} catch (Exception e) {
			this.retValue = false;
			this.errMsg = "HisDAO.fire() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			// free used resources
			try {
				if (this.retValue == true)
					conn.commit();
				else
					conn.rollback();

				// free connection
				if (conn != null) {
					conn.close();
					conn = null;
				}
				// destroy final object
				if (this.finalObj != null) {
					this.finalObj.clear();
					this.finalObj = null;
				}
			} catch (Exception e) {
			}
		}

	} // end fire() function

	/**
	 * Returns query result which are not parameterized. It returns WebRowSet
	 * 
	 * @param qry - SQL Query.
	 * @return WebRowSet - contains Query Results.
	 * @throws Exception - HisException if any Problem occurs at the time of execution.
	 * @see hisglobal.exceptions.HisException 
	 */
	public WebRowSet getQryResultFiltered(String qry,String fromRow,String maxRows) throws Exception {

		Connection conn = null;
		WebRowSet ws = null;
		this.errMsg = "";
		
		//System.out.println("HisDAO.getQryResultFiltered----"+qry);

		try {
			ws = new WebRowSetImpl();
			ws.setMaxRows(Integer.parseInt(maxRows));
			ws.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
			ws.setCommand(qry);
			conn = this.getConnection();
			ws.execute(conn);
			if(Integer.parseInt(fromRow)!=0)
				ws.absolute(Integer.parseInt(fromRow));
			/*else
				ws.absolute(Integer.parseInt(fromRow));*/
		} catch (Exception e) {
			this.errMsg = "HisDAO.getQryResult(qry,Query : " + qry + ") -->" + e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			try {
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return ws;
	}
	
	/**
	 * Returns query result which are not parameterized. It returns WebRowSet
	 * 
	 * @param qry - SQL Query.
	 * @return WebRowSet - contains Query Results.
	 * @throws Exception - HisException if any Problem occurs at the time of execution.
	 * @see hisglobal.exceptions.HisException 
	 */
	public WebRowSet getQryResult(String qry) throws Exception {

		Connection conn = null;
		WebRowSet ws = null;
		this.errMsg = "";

		try {
			ws = new WebRowSetImpl();			
			ws.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
			ws.setCommand(qry);
			//System.out.println("Direct Query in HisDAO "+qry);
			conn = this.getConnection();
			ws.execute(conn);
		} catch (Exception e) {
			this.errMsg = "HisDAO.getQryResult(qry,Query : " + qry + ") -->" + e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			try {
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
			}
		}

		return ws;
	}
	
	/**
	 * Returns query result which are not parameterized.
	 * 
	 * @param qry - SQL Query.
	 * @param no_of_fields - Number of Fields Query Contains.
	 * @return ArrayList - Query Result in ArrayList.
	 * @throws Exception - HisException if any Problem occurs at the time of execution.
	 * @see hisglobal.exceptions.HisException 
	 */
	public ArrayList<String> getQryResult(String qry, int no_of_fields)
			throws Exception {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		ArrayList<String> qryResult = null;
		String tempValue = "";

		this.retValue = false;
		this.errMsg = "";

		try {
			conn = this.getConnection();
			st = conn.createStatement();

			rs = st.executeQuery(qry);
		
			if (rs != null) {
				// initilize array list
				qryResult = new ArrayList<String>(1);
				while (rs.next()) {
					for (int i = 1; i <= no_of_fields; i++) {
						tempValue = rs.getString(i);
						if (tempValue == null)
							tempValue = "";
						qryResult.add(tempValue);
					}

				}
			}
			this.retValue = true;
		} catch (Exception e) {
			this.errMsg = "HisDAO.getQryResult(qry,fields,Query : " + qry + ") -->"
					+ e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			try {
				if (st != null) {
					st.close();
					st = null;
				}
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
			}
		}

		return qryResult;
	}

	/**
	 * free all the objects. 
	 * call the method when all your DataBase process for the required task have been completed.
	 */
	public void free() {
		// put HisDAO Open status into log file
		//HisException.putHisDAOStatus(this.moduleName, this.fileName, 1);

		int counter = 0;
		int tempSize = 0;

		// free the used resources
		if (this.qryObj != null) {
			tempSize = qryObj.size();
			for (counter = 0; counter < tempSize; counter++) {
				((HisQuery) qryObj.get(counter)).resetValue();
			}
			this.qryObj.clear();
			this.qryObj = null;
		}

		if (this.procObj != null) {
			tempSize = procObj.size();
			for (counter = 0; counter < tempSize; counter++) {
				((HisProcedure) procObj.get(counter)).resetValue();
			}
			this.procObj.clear();
			this.procObj = null;
		}

		if (this.finalObj != null) {
			this.finalObj.clear();
			this.finalObj = null;
		}

		this.qryIndex = 0;
		this.procIndex = 0;
		this.moduleName = "";
		this.fileName = "";
		this.retValue = false;
	}
	/*
	 * firstFireFlag = 1 meaning the first calling lstFireFlag = 1 meaning that
	 * connection should be closed else connection will be alive
	 */
	/**
	 * Fire_without_commit.
	 * 
	 * @param firstFireFlag
	 *            the first fire flag
	 * @param lstFireFlag
	 *            the lst fire flag
	 * @throws Exception
	 *             the exception
	 */
	public void fire_without_commit(int firstFireFlag, int lstFireFlag)
			throws Exception {

		int tempIndex = 0;
		int gblConnCloseFlag = 0;

		retValue = false;
		this.errMsg = "";

		if (firstFireFlag != 1 && gblConn == null) {
			this.retValue = false;
			this.errMsg = "HisDAO.fire() -->You have not catched the exception, please check coding !!";
			throw new Exception(this.errMsg);
		} else {
			try {
				// finalObj contains the object index. Query/procedure will be
				// executed in same order as it is contained
				if (this.finalObj != null && this.finalObj.size() > 0) {

					// get connection
					if (firstFireFlag == 1 && gblConn == null) {
						gblConn = this.getConnection();
						gblConn.setAutoCommit(false);
					}

					this.retValue = false;

					for (int i = 0; i < this.finalObj.size(); i++) {
						// getting object if index is less than 1000 then there
						// is
						// query object else procedure object
						tempIndex = Integer.parseInt((String) this.finalObj
								.get(i));
						if (tempIndex < 1000) {
							// query object
							((HisQuery) this.qryObj.get(tempIndex))
									.executeQry_Batch_new(gblConn);
						} else {
							// procedure object
							((HisProcedure) this.procObj.get(tempIndex - 1000))
									.executeProc_Batch_new(gblConn);
						}
					}// end for loop

					this.retValue = true;
				} // end if block
				else {
					this.errMsg = "No Query/Procedure added into batch";
					throw new Exception(this.errMsg);
				}
			} catch (Exception e) {
				this.retValue = false;
				this.errMsg = "HisDAO.fire() -->" + e.getMessage();
				throw new Exception(this.errMsg);
			} finally {
				// free used resources
				try {
					if (lstFireFlag == 1 || this.retValue == false)
						gblConnCloseFlag = 1;

					if (gblConnCloseFlag == 1) {
						if (this.retValue == true)
							gblConn.commit();
						else
							gblConn.rollback();

						// free connection
						if (gblConn != null) {
							gblConn.close();
							gblConn = null;
						}
					}

					// destroy final object
					if (this.finalObj != null) {
						this.finalObj.clear();
						this.finalObj = null;
					}
				} catch (Exception e) {
				}
			}
		}

	} // end fire_without_commit() function
	
	public Connection getDBConnection() throws SQLException
	{
		Connection con=null;
		try {
			con= this.getConnection();
		} catch (Exception e) {
			 con=null;
			e.printStackTrace();
		}
		return con;
	}
	/**
	 * This function sets the config path
	 */
	private static void setConfigPath_EDB() {
		
		if(lookUpName_EDB!=null && lookUpName_EDB.equals(""))
		{
			lookUpName_EDB=(String)hisDAOCacheVO.get("hisDAOCacheVO_lookUpName_EDB");
		}
		
		if(lookUpName_EDB==null || lookUpName_EDB.equals(""))
		{
		ResourceBundle rsBundle = null;
		
		try {	
			
			lookUpName_EDB = HisUtil.getParameterFromHisPathXML("JNDI_EDB_LOOKUP");
				System.out.println("setConfigPath()::lookUpName"+lookUpName_EDB);
				hisDAOCacheVO.put("hisDAOCacheVO_lookUpName_EDB",lookUpName_EDB);
				//connURL = rsBundle.getString("DIRECT_CONN_URL");
				//userName = rsBundle.getString("CONN_USER_NAME");
				//pwd = rsBundle.getString("CONN_PWD");
				rsBundle = null;
			
		}
		catch(Exception e) {
			
			System.out.println("error :: " + e.getMessage());
		}
		finally {
			if(rsBundle != null) rsBundle = null;
		}
		}
		
	}// end setConfigPath() function
	/**
	 * returns connection. This function will be used within this class
	 * 
	 * @return Connection by retrieving from IntialContext through DataSource.
	 * @throws Exception
	 */
	private Connection getConnection_EDB() throws Exception {

		Connection conn = null;

		retValue = false;
		this.errMsg = "";

		try {
			//setConfigPath_EDB();
			if(lookUpName_EDB == null) lookUpName_EDB = "";
			//if(connURL == null) connURL = "";
			
		//	System.out.println("lookUpName [DAO] = " + lookUpName);
			//System.out.println("connURL = " + connURL);
			
			if(!lookUpName_EDB.equals("")) { 
				/*
				if (ic == null || ds == null) {
					ic = new InitialContext();
					ds = (DataSource) ic.lookup(lookUpName);
				}
				*/
				ic = new InitialContext();
				ds = (DataSource) ic.lookup(lookUpName_EDB);
				conn = ds.getConnection();
			}
			/*
			else {
				if(!connURL.equals("")) {
					System.out.println("entyered in driver");
					Class.forName("oracle.jdbc.OracleDriver");
					conn = DriverManager.getConnection(connURL,userName,pwd);
				}
				else {
					throw new Exception("Neither JNDI_LOOKUP nor DIRECT_CONN_URL defined in hisPath.properties file !!");
				}
			}*/
			retValue = true;
		} catch (Exception e) {
			this.errMsg = "HisDAO.getConnection() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		return conn;
	}
	
	public void executeProcedureByPosition_EDB(int procIndex) throws Exception {

		Connection conn = null;
		retValue = false;
		this.errMsg = "";

		try {
			if (this.procIndex > procIndex) {
				conn = this.getConnection_EDB();
				conn.setAutoCommit(false);
				((HisProcedure) procObj.get(procIndex)).executeProcByPosition(conn);
				retValue = true;
			} else {
				this.errMsg = "Invalid procedure index";
				throw new Exception(this.errMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.retValue = false;
			this.errMsg = "HisDAO.executeProcedureByPosition() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			try {
				if(this.retValue == true)
					conn.commit();
				else
					conn.rollback();
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
			}
		}
	}
	
	public WebRowSet getQryResult_EDB(String qry) throws Exception {

		Connection conn = null;
		WebRowSet ws = null;
		this.errMsg = "";

		try {
			ws = new WebRowSetImpl();			
			ws.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
			ws.setCommand(qry);
			//System.out.println("SYSOUT 1");
			conn = this.getConnection_EDB();
			//System.out.println("SYSOUT 2");
			ws.execute(conn);
			//System.out.println("SYSOUT 3");
		} catch (Exception e) {
			e.printStackTrace();
			this.errMsg = "HisDAO.getQryResult(qry,Query : " + qry + ") -->" + e.getMessage();
			throw new Exception(this.errMsg);
		} finally {
			try {
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
			}
		}

		return ws;
	}
	
	
	
}
