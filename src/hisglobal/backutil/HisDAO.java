/*
		Name		Ajay Kumar Gupta
*/

package hisglobal.backutil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.sql.rowset.WebRowSet;

import com.sun.rowset.WebRowSetImpl;

public final class HisDAO
{
	private static Context ic = null;
	private static DataSource ds = null;
	private final static String lookUpName = "java:comp/env/AHIS";
	
	private List <HisQuery>qryObj = null;
	private List <HisProcedure>procObj = null;
	private List <String>finalObj = null; 
	//
	//private Map proc_out_value = null;
	
	private int qryIndex = 0;
	private int procIndex = 0;
	
	private String moduleName = "";
	private String fileName = "";
	private boolean retValue = false;
	//used for error messages
	private String errMsg = "";
	private String errorMsg = "";
	private String errorMsgCode = "";
	
	//constructor with arguments
	public HisDAO(String moduleName,String fileName) {
		
		//put HisDAO Open status into log file
		this.moduleName = moduleName;
		this.fileName = fileName;
		
		/**
		 * Commented by Balasubramaniam on 12-03-2008 
		 * since hisDAO.log and hisErr.log file is not here..
		 * 
		 * this problem will be cleared when it integrate with billing and ipd 
		 * module.
		 */
		
		//HisException.putHisDAOStatus(this.moduleName,this.fileName,0);
	}
	
	/*
		returns connection. This function will be used within this class
	*/
	private Connection getConnection() throws Exception {
		
		Connection conn = null;
        
		retValue = false;
		this.errMsg = "";
		
		try {
			if(ic == null || ds == null) {
				ic	= new InitialContext();
				ds	= (DataSource)ic.lookup(lookUpName);
			}
					
			conn	 = ds.getConnection();
			retValue = true; 
		}
		catch(Exception e) {
			this.errMsg = "HisDAO.getConnection() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		return conn;
	}

	//returns return value
	public boolean getReturnValue() {
		return this.retValue;
	}
	
	//returns HisQuery Index
	public int setQuery(String qry) {
		
		retValue = false;
		if(qryObj == null) 
            qryObj = new ArrayList<HisQuery>(1);
		//create instance of query class and store into arraylist
		qryObj.add(qryIndex++,HisQuery.getQryInstance(qry));
		retValue = true;
		return (qryIndex-1);
	}
	
	//returns HisProcedure Index
	public int setProcedure(String proc) {
		
		retValue = false;
		if(procObj == null) procObj = new ArrayList<HisProcedure>(1);
		//create instance of query class and store into arraylist
		procObj.add(procIndex++,HisProcedure.getProcInstance(proc));
		retValue = true;
		return (procIndex-1);
	}
	
	/*
		This function sets the value for the parameterized query
		parameterIndex = starts with 1
	*/	
	public void setQryValue(int qryIndex,int parameterIndex,String value) throws Exception {
		
		retValue = false;
		this.errMsg = "";
		
		//get HisQuery Instance based on qryIndex & call setValue method to set the value
		if(this.qryIndex > qryIndex) {
			((HisQuery)qryObj.get(qryIndex)).setValue(parameterIndex,value);
			retValue = true;			
		}
		else {
			this.errMsg = "HisDAO.setQryValue() -->Invalid query index";
			throw new Exception(this.errMsg);
		}
	}
	
	//this function sets the input value for the parameterized procedure
	public void setProcInValue(int procIndex,String parameterName,String value) throws Exception {
		
		retValue = false;
		this.errMsg = "";
		
		//get HisProcedure Instance based on procIndex & call setValue method to set the value
		if(this.procIndex > procIndex) {
			((HisProcedure)procObj.get(procIndex)).setInValue(parameterName,value);
			retValue = true;
		}
		else {
			this.errMsg = "HisDAO.setProcInValue() -->Invalid procedure index";
			throw new Exception(this.errMsg);
		}
	}
	
	/*
		This function sets the output value for the parameterized query
		outputType = 1 for String
				   = 2 for Object	
	*/	
	public void setProcOutValue(int procIndex,String parameterName,int outputType) throws Exception {
		
		retValue = false;
		this.errMsg = "";
		
		//get HisProcedure Instance based on procIndex & call setValue method to set the value
		if(this.procIndex > procIndex) {
			((HisProcedure)procObj.get(procIndex)).setOutValue(parameterName,outputType);
			retValue = true;
		}
		else {
			this.errMsg = "HisDAO.setProcOutValue() -->Invalid procedure index";
			throw new Exception(this.errMsg);
		}
	}
	//Added by anshul for postgres compatibilty on 27 nov 2012
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
	/*
		This function is used to add queries/procedure into batch. Call this function after setting value for
		parameterized query/procedure if there is parameterized query/procedure.
		
		It does not execute the query/procedure
		
		mode = 0 if query are added into batch
			 = 1 if procedures are added into batch
		
		Logic -->
		add 1000 in index while storing index into arraylist for procedure. At the time of execution,
		we could know whether we have to execute either query or procedure  	 	
	*/
	public void execute(int index,int mode) throws Exception {
		
		retValue = false;
		this.errMsg = "";
		
		if(finalObj == null) finalObj = new ArrayList<String>(1);
		//for query
		if(mode == 0) {
			if(this.qryIndex > index) {
				//add into final list
				finalObj.add(String.valueOf(index));
				((HisQuery)this.qryObj.get(index)).execute();
				retValue = true;
			}
			else {
				this.errMsg = "HisDAO.execute() -->Invalid query index";
				throw new Exception(this.errMsg);
			}
		}
		else {
			if(this.procIndex > index) {
				//add into final list [add 1000 for identifying procedure]
				finalObj.add(String.valueOf(index+1000));
				((HisProcedure)this.procObj.get(index)).execute();
				retValue = true;	
			}
			else {
				this.errMsg = "HisDAO.execute() -->Invalid procedure index";
				throw new Exception(this.errMsg);
			}
		}
	}
		
	/*
		This function executes a single query whether query is parameterized or not
		and returns WebRowSet.
		qryIndex is index returned by setQuery() function.
		
		Use this function when query is parameterized
	*/
	public WebRowSet executeQry(int qryIndex) throws Exception {
				
		Connection conn = null;
		WebRowSet ws = null;
		retValue = false;	
		this.errMsg = "";
		
		try {
			if(this.qryIndex > qryIndex) {
				conn = this.getConnection();		
				ws = ((HisQuery)qryObj.get(qryIndex)).executeQry(conn);				
				retValue = true;
			}
			else {
				this.errMsg = "Invalid query index";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.retValue = false;
			this.errMsg = "HisDAO.executeQry(1 Args) -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			//close connection 
			if(conn != null) {
				try {
					conn.close();
					conn = null;
				}
				catch(Exception e) {}
			}
		}
		
		return ws;
	}
	
	/*
		This function executes a single query whether query is parameterized or not
		and returns Array List.
		qryIndex is index returned by setQuery() function.
		
		Use this function when query is parameterized
	*/
	public ArrayList executeQry(int qryIndex,int no_of_fields) throws Exception {
		
		Connection conn = null;
		ArrayList qryResult = null;
		
		this.retValue = false;
		this.errMsg = "";
		
		try {
			if(this.qryIndex > qryIndex) {
				conn = this.getConnection();
				qryResult = ((HisQuery)qryObj.get(qryIndex)).executeQry(conn,no_of_fields);
				retValue = true;
			}
			else {
				this.errMsg = "Invalid query index";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.retValue = false;
			this.errMsg = "HisDAO.executeQry(2 Args) -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			//close connection 
			if(conn != null) {
				try {
					conn.close();
					conn = null;
				}
				catch(Exception e) {}
			}
		}
		
		return qryResult;
	}

	/*
		This function executes a single procedure.
		procIndex is index returned by setProcedure function.
		If there is output parameter defined for the procedure then getOutputValue() is used to get 
		the value of output parameterized 
	*/
	public void executeProcedure(int procIndex) throws Exception {
		
		Connection conn = null;
		retValue = false;
		this.errMsg = "";
		
		try {
			if(this.procIndex > procIndex) {
				conn = this.getConnection();
				((HisProcedure)procObj.get(procIndex)).executeProc(conn);
				retValue = true;
			}
			else {
				this.errMsg = "Invalid procedure index";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.retValue = false;
			this.errMsg = "HisDAO.executeProcedure() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			try {
				if(conn != null) {
					conn.close();
					conn = null;
				}
			}
			catch(Exception e) {}
		}
	}
	
	/*
		This function is used to get the String value for output parameter of procedure. If procedure
		is executed using executeProcedure() function
		procIndex --> Object returened while setting the procedure
		parameterName --> Name which has been defined for output parameter
	*/
	public String getString(int procIndex,String parameterName) throws Exception {
		String retData = null;
		retValue = false;
		
		try {
			if(this.procIndex > procIndex) {
				retData = (String)((HisProcedure)procObj.get(procIndex)).getOutputValue(parameterName);
				retValue = true;
			}
			else {
				this.errMsg = "Invalid procedure index";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.errMsg = "HisDAO.getString() --> " + e.getMessage();
			throw new Exception(this.errMsg);
		}
		
		return retData;
	}
	
	/*
	This function is used to get the webrowset value for output parameter of procedure. If procedure
	is executed using executeProcedure() function
	procIndex --> Object returened while setting the procedure
	parameterName --> Name which has been defined for output parameter
	*/
	public WebRowSet getWebRowSet(int procIndex,String parameterName) throws Exception {
		WebRowSet retData = null;
		ResultSet rs = null;
		retValue = false;
		
		try {
			if(this.procIndex > procIndex) {
				rs = (ResultSet)((HisProcedure)procObj.get(procIndex)).getOutputValue(parameterName);
				//initilize webrowset
				retData = new WebRowSetImpl();
				retData.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
				retData.populate(rs);
				
				retValue = true;
			}
			else {
				this.errMsg = "Invalid procedure index";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.errMsg = "HisDAO.getWebRowSet() --> " + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			if(rs != null) {
				rs.close();
				rs = null;
			}
		}
		
		return retData;
	}

	/*
		This function executes all queries/procedures which has been kept into batch. This function 
		either commits or rollback the entire transaction.
		
		This function does not free the objects. It only resets the value defined for query/procedure 
		meaning that the query index/procedure index returned by setQuery/setProcedure function 
		remains valid but the values disappears 
		 
	*/
	public void fire() throws Exception {
		
		Connection conn = null;
		int tempIndex = 0;
						
		retValue = false;
		this.errMsg = "";
		
		try {
			//finalObj contains the object index. Query/procedure will be executed in same order as it is contained
			if(this.finalObj != null && this.finalObj.size() > 0) {
				
				//get connection
				conn = this.getConnection();
				conn.setAutoCommit(false);
				this.retValue = false;
					
				for(int i = 0;i<this.finalObj.size();i++) {
					//getting object if index is less than 1000 then there is query object else procedure object
					tempIndex = Integer.parseInt((String)this.finalObj.get(i));
					if(tempIndex < 1000) {		
						//query object
						((HisQuery)this.qryObj.get(tempIndex)).executeQry_Batch(conn);
					}
					else {
						//procedure object
						((HisProcedure)this.procObj.get(tempIndex-1000)).executeProc_Batch(conn);
					}
				}//end for loop
				
				this.retValue = true;
			} //end if block
			else {
				this.errMsg = "No Query/Procedure added into batch";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.retValue = false;
			this.errMsg = "HisDAO.fire() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			//free used resources
			try {
				if(this.retValue == true)
					conn.commit();
				else
					conn.rollback();
								
				//free connection
				if(conn != null) {
					conn.close();
					conn = null;
				}	
				//destroy final object
				if(this.finalObj != null) {
					this.finalObj.clear();
					this.finalObj = null;
				}
			}
			catch(Exception e) {}
		}
		
	} //end fire() function
	
	/*
	 	Returns query result which are not parameterized.
	 	It returns WebRowSet
	*/ 
	public WebRowSet getQryResult(String qry) throws Exception {
		
		Connection conn = null;
		WebRowSet ws = null;
		this.errMsg = "";
		
		try {
			ws = new WebRowSetImpl();
			ws.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
			ws.setCommand(qry);
			conn = this.getConnection();
			ws.execute(conn);
		}
		catch(Exception e) {
			this.errMsg = "HisDAO.getQryResult(qry) -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			try {
				if(conn != null) {
					conn.close();
					conn = null;
				}
			}
			catch(Exception e) {}
		}
		
		return ws;
	}
	
	/*
 		Returns query result which are not parameterized.
 		It returns ArrayList and takes two arguments
	*/ 
	public ArrayList getQryResult(String qry,int no_of_fields) throws Exception {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		ArrayList <String>qryResult = null;
		String tempValue = "";
		
		this.retValue = false;
		this.errMsg = "";
		
		try {
			conn = this.getConnection();
			st = conn.createStatement();
			
			rs = st.executeQuery(qry);
			if(rs != null) {
				//initilize array list
				qryResult = new ArrayList<String>(1);
				while(rs.next()) {
					for(int i = 1;i<=no_of_fields;i++) {
						tempValue = rs.getString(i);
						if(tempValue == null) tempValue = "";
						qryResult.add(tempValue);
					}
						
				}
			}
			this.retValue = true;
		}
		catch(Exception e) {
			this.errMsg = "HisDAO.getQryResult(qry,fields) -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			try {
				if(st != null) {
					st.close();
					st = null;
				}
				if(rs != null) {
					rs.close();
					rs = null;
				}
				if(conn != null) {
					conn.close();
					conn = null;
				}
			}
			catch(Exception e) {}
		}
		
		return qryResult;
	}

	//free all the objects
	public void free() {
		//put HisDAO Open status into log file
	//	HisException.putHisDAOStatus(this.moduleName,this.fileName,1);
		
		int counter = 0;
		int tempSize = 0;
		
		//free the used resources
		if(this.qryObj != null) {
			tempSize = qryObj.size();
			for(counter=0;counter<tempSize;counter++) {
				((HisQuery)qryObj.get(counter)).resetValue();
			}
			this.qryObj.clear();
			this.qryObj = null;
		}
		
		if(this.procObj != null) {
			tempSize = procObj.size();
			for(counter=0;counter<tempSize;counter++) {
				((HisProcedure)procObj.get(counter)).resetValue();
			}
			this.procObj.clear();
			this.procObj = null;
		}
		
		if(this.finalObj != null) {
			this.finalObj.clear();
			this.finalObj = null;
		}
		
		this.qryIndex = 0;
		this.procIndex = 0;
		this.moduleName = "";
		this.fileName = "";
		this.retValue = false;
	}
	//added by anshul for postgres compatibilty on 27 nov 2012
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
//Added by anshul for postgres compatibilty on 27 nov 2012
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
		this.errorMsg="";
		this.errorMsgCode="";

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

}
