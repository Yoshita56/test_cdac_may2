/*
 * Copyright ©.
 */

package hisglobal.backutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.WebRowSet;

import com.sun.rowset.WebRowSetImpl;

/**
 * @author Administrator
 */
public final class HisQuery
{
	private String qry = "";
	
	PreparedStatement ps = null;
	private List <String>qry_single_value = null;
	private List <String[]>qry_multiple_value = null;
	
	private int colSize = -1;
	private int rowSize = 0;
	//used for getting value from qry_multiple_value list
	private int gblIndex = 0;
	//used for error messages
	private String errMsg = "";
	
	//make the class non-instanciable
	private HisQuery() {}
	
	public HisQuery(String qry) {
		this.qry = qry;
	}
	
	//returns HisQuery Instance
	public static HisQuery getQryInstance(String qry) {
		return (new HisQuery(qry));
	} 	
	
	/*
		sets the value for parameterized query
		parameterIndex = starts with 1
	*/	
	public void setValue(int parameterIndex,String val) {
		//initialize the ArrayList
		if(this.qry_single_value == null) this.qry_single_value = new ArrayList<String>(1);
		this.qry_single_value.add(parameterIndex-1,val);	
	}
	
	/*
		This function is used to add queries into batch whether there is parameterized query or not  
		It doese not execute the queries 
	*/
	public void execute() throws Exception {
		
		int valueSize = 0;
		String[] strObj = null;
		
		this.errMsg = "";
		try {
			if(this.qry_single_value != null) valueSize = this.qry_single_value.size();
			if(this.colSize == -1) this.colSize = valueSize;
			
			if(this.colSize == valueSize) {
				//how many times this query will be executed
				this.rowSize++;
				if(this.qry_single_value != null) {
					if(this.qry_multiple_value == null) this.qry_multiple_value = new ArrayList<String[]>(1); 
					
					//store array list into string [as list is clear, refrences is lost]
					strObj = new String[this.colSize];					
					for(int i =0;i<this.colSize;i++)
						strObj[i] = (String)this.qry_single_value.get(i);
										
					this.qry_multiple_value.add(strObj);
					
					//free the qry_single_value arraylist
					this.qry_single_value.clear();
					this.qry_single_value = null;
					strObj = null;
				}
			}
			else {
				this.errMsg = "Mismatch in previous column size & current size"; 
				throw new Exception(this.errMsg);
			}
			
		}
		catch(Exception e) {
			this.errMsg = "HisQuery.execute() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
	}
	
	/*
		This function executes a single query and is called from HisDAO class.
	*/
	public WebRowSet executeQry(Connection conn) throws Exception {
		
		PreparedStatement ps = null;
		WebRowSet ws = null;
		int lcl_col_size = 0;
		this.errMsg = "";
		
		try {
			if(!this.qry.equals("")) {
				ps = conn.prepareStatement(qry);					
				if(this.qry_single_value != null) {				
					lcl_col_size = this.qry_single_value.size();					
					//sets the values in prepared statement
					for(int i = 0;i<lcl_col_size;i++) 
						ps.setString(i+1,(String)this.qry_single_value.get(i));
										
					//free the qry_single_value arraylist
					this.qry_single_value.clear();
					this.qry_single_value = null;
				}
				
				//execute the query
				ws = new WebRowSetImpl();
				ws.populate(ps.executeQuery());
			}
			else {
				this.errMsg = "Query is blank";
				throw new Exception(this.errMsg);
			}
			
		}
		catch(Exception e) {
			this.errMsg = "HisQuery.executeQry(3 Args) -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			try {
				if(ps != null) {
					ps.close();
					ps = null;
				}
			}
			catch(Exception e) {}
		}
		
		return ws;
	}
	
	/*
		This function executes a single query and is called from HisDAO class.
	*/
	public ArrayList executeQry(Connection conn,int no_of_fields) throws Exception {
		
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		ArrayList <String>qryResult = null;
		String tempValue = "";
		int lcl_col_size = 0;
		this.errMsg = "";
		
		try {
			if(!this.qry.equals("")) {
				ps = conn.prepareStatement(qry);
				
				if(this.qry_single_value != null) {
					lcl_col_size = this.qry_single_value.size();
					
					//sets the values in prepared statement
					for(int i = 0;i<lcl_col_size;i++) 
						ps.setString(i+1,(String)this.qry_single_value.get(i));
										
					//free the qry_single_value arraylist
					this.qry_single_value.clear();
					this.qry_single_value = null;
				}
				
				//execute the query
				rs = ps.executeQuery();
				
				//populate into array list
				if(rs != null) {
					//initilize array list
					qryResult = new ArrayList<String>();
					while(rs.next()) {
						for(int i = 1;i<=no_of_fields;i++) {
							tempValue = rs.getString(i);
							if(tempValue == null) tempValue = "";
							qryResult.add(tempValue);
						}
					}
				}
			}
			else {
				this.errMsg = "Query is blank";
				throw new Exception(this.errMsg);
			}
			
		}
		catch(Exception e) {
			this.errMsg = "HisQuery.executeQry(4 Args) -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			try {
				if(ps != null) {
					ps.close();
					ps = null;
				}
				if(rs != null) {
					rs.close();
					rs = null;
				}
			}
			catch(Exception e) {}
		}
		
		return qryResult;
	}

	/*
		This function executes a single query at a time which is in batch 
		It is called from HisDAO class (fire() function).
	*/
	public void executeQry_Batch(Connection conn) throws Exception {
		
		String[] tempList = null;
		boolean retVal = false;
		this.errMsg = "";
		
		try {
			if(!this.qry.equals("")) {
				if(ps == null) ps = conn.prepareStatement(this.qry);
								
				if(this.qry_multiple_value != null) {
					
					tempList = (String[])this.qry_multiple_value.get(this.gblIndex++);
					//sets the values in prepared statement
					for(int i = 0;i<this.colSize;i++) 
						ps.setString(i+1,tempList[i]);
				}
				
				//execute the query
				ps.execute();
				retVal = true;
			}
			else {
				this.errMsg = "Query is blank";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.errMsg = "HisQuery.executeQry_Batch() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			tempList = null;
		}
	}
	
	//used to reset value
	public void resetValue() {
		try {
			if(this.ps != null) {
				ps.close();
				ps = null;
			}
		}
		catch(Exception e) {}
		
		//variable initilization
		if(this.qry_single_value != null) {
			this.qry_single_value.clear();
			this.qry_single_value = null;
		}
		
		if(this.qry_multiple_value != null) {
			this.qry_multiple_value.clear();
			this.qry_multiple_value = null;
		}
		
		this.colSize = -1;
		this.rowSize = 0;
		this.gblIndex = 0;
	}
}
