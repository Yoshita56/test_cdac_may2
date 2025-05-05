/*
 * Copyright ©.
 */

package hisglobal.backutil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.WebRowSet;

import com.sun.rowset.WebRowSetImpl;

//import oracle.jdbc.OracleTypes;

/**
 * @author Administrator
 */
public final class HisProcedure
{
	String proc = "";
	//added by anshul for postgres compatibilty on 27 nov 2012
	/**
	 * 
	 */
	private String procErrStr = "";
	
	private CallableStatement cs = null;
	private List <String>proc_single_value = null;
	private List <Object[]>proc_multiple_value = null;
	private List <String>proc_out_index = null;
	
	//procedure output value
	Map  <String,Object>proc_out_value = null;	//used to store the value returned by procedure
	
	private int colSize = -1;
	private int rowSize = 0;
	//used for getting value from qry_multiple_value list
	private int gblIndex = 0;
	//used for error messages
	private String errMsg = "";
	//Added by anshul for postgres compatibilty on 27 nov 2012

	/**
	 * flag indicating whether err parameter is defined in procedure or not. It is mandatory parameter
	 */
	private boolean errFlag = false;
	//used for error messages
	private String errMsgCode = "";
	//added by anshul ends here 
	//Make the class Non-instanciable
	private HisProcedure() {}
	
	public HisProcedure(String proc) {
		this.proc = proc;
	}
	
	//returns HisProcedure Instance
	public static HisProcedure getProcInstance(String proc) {
		return (new HisProcedure(proc));
	} 	
	
	//sets the input value for parameterized procedure. It sets value by name
	public void setInValue(String parameterName,String val) {
		//initialize the ArrayList
		if(this.proc_single_value == null) this.proc_single_value = new ArrayList<String>(2);
		this.proc_single_value.add(parameterName);
		this.proc_single_value.add(val);
	}
	
	//Added by anshul for postgres compatibilty on 27 nov 2012
	/**
	 * sets the input value for parameterized procedure. It sets value by name
	 * @param parameterName - Procedure Parameter Name.
	 * @param val - Procedure Parameter Value
	 */
	public void setInValue(String parameterName,String val,int paramIndex) {
		//initialize the ArrayList
		if(this.proc_single_value == null) this.proc_single_value = new ArrayList<String>(2);
		this.proc_single_value.add(paramIndex+":"+parameterName);
					
		this.proc_single_value.add(val);
	}
	
	//	sets the output value for parameterized procedure
	//outputType = 1 String & 2 for WebRowSet
	public void setOutValue(String parameterName,int outputType) {
		//initialize the ArrayList
		if(this.proc_single_value == null) this.proc_single_value = new ArrayList<String>(2);
		if(this.proc_out_index == null) this.proc_out_index = new ArrayList<String>(1);
		
		this.proc_single_value.add(parameterName);
		this.proc_single_value.add("OUTPARAMETER#" + String.valueOf(outputType));
		this.proc_out_index.add(parameterName + "#" + String.valueOf(outputType));
	}
//Added By anshul for postgres compatibilty on 27 nov 2012
	/**
	 * sets the output value for parameterized procedure
	 * @param parameterName - Procedure Parameter Name.
	 * @param outputType <b>1</b>-String and <b>2</b>-WebRowSet.
	 */
	public void setOutValue(String parameterName,int outputType,int paramIndex) {
		//initialize the ArrayList
		if(this.proc_single_value == null) this.proc_single_value = new ArrayList<String>(2);
		if(this.proc_out_index == null) this.proc_out_index = new ArrayList<String>(1);
		
		//ERR PARAMETER MUST EXIST IN THE PROCEDURE
		if(parameterName.toUpperCase().trim().equals("ERR")) errFlag = true;
		
		this.proc_single_value.add(paramIndex+":"+parameterName);
		this.proc_single_value.add("OUTPARAMETER#" + String.valueOf(outputType));
		this.proc_out_index.add(parameterName+":" +paramIndex +"#" + String.valueOf(outputType));
	}
	//this function is used to retrive the procedure output value	
	public Object getOutputValue(String parameterName) throws Exception {
		Object outVal = null;
		
		try {
			if(proc_out_value != null) {
				if(!proc_out_value.containsKey(parameterName)) {
					this.errMsg = "Invalid Parameter Name";
					throw new Exception(this.errMsg);
				}
				else
					outVal = proc_out_value.get(parameterName);
			}
			else {
				this.errMsg = "No Out-Parameter Defined";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.errMsg = "HisProcedure.getOutputValue() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		
		return outVal;
	}
	
	/*
		This function executes a single procedure and sets the output value into proc_out_value map.
	*/
	public void executeProc(Connection conn) throws Exception {
		
		CallableStatement cs = null;
		//Map  <String,String>proc_out_value = null;
		
		String keyName = "";
		String[] keyValue;	
		
		Object outValue = null;		//output value for procedure
		
		int lcl_col_size = 0;
		this.errMsg = "";
				
		try {
			if(!this.proc.equals("")) {
				cs = conn.prepareCall(this.proc);
								
				if(this.proc_single_value != null) {
					lcl_col_size = this.proc_single_value.size()/2;
					
					//sets the values in callable statement
					for(int i = 0;i<lcl_col_size;i++) {
						keyName = (String)this.proc_single_value.get(2*i);
						keyValue = ((String)this.proc_single_value.get((2*i)+1)).split("#");
						
						if(keyValue[0].equals("OUTPARAMETER")) {
							if(keyValue[1].equals("1"))		//string
								cs.registerOutParameter(keyName,java.sql.Types.VARCHAR);
							else			//web row set
							{
								//cs.registerOutParameter(keyName,OracleTypes.CURSOR);
								//cs.setNull(keyName, Types.NULL);
								cs.registerOutParameter(keyName,java.sql.Types.REF_CURSOR);
							}
						}
						else
							cs.setString(keyName,keyValue[0]);	
					} //end for loop
										
					//free the qry_single_value arraylist
					this.proc_single_value.clear();
					this.proc_single_value = null;
				} // end if
				
				//execute the procedure
				cs.execute();
				//set the output data into Map
				if(this.proc_out_index != null && this.proc_out_index.size() > 0) {
					lcl_col_size = this.proc_out_index.size();
					//initilize HashMap
					this.proc_out_value = new HashMap<String,Object>(lcl_col_size);	
										
					for(int i = 0; i<lcl_col_size;i++) {
						//keyValue = PARAMETER NAME#OUTPUT TYPE
						keyValue = ((String)this.proc_out_index.get(i)).split("#");
						if(keyValue[1].equals("1"))	{		//string return value
							outValue = cs.getString(keyValue[0]);
							if(outValue == null) outValue = "";
						}
						else {		//resultset/webrowset
							outValue = cs.getObject(keyValue[0]);
						}
						
						proc_out_value.put(keyValue[0],outValue);
					}
				}
				
			} //end outer if block
			else {
				this.errMsg = "Procedure is blank";
				throw new Exception(this.errMsg);
			}
			
		}
		catch(Exception e) {
			this.errMsg = "HisProcedure.executeProc() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			try {
				if(cs != null) {
					cs.close();
					cs = null;
				}
				
				if(this.proc_out_index != null) {
					this.proc_out_index.clear();
					this.proc_out_index = null;
				}
			}
			catch(Exception e) {}
		}
	}
	
	/*
		This function is used to add procedure into batch whether there is parameterized procedure or not  
		It doese not execute the procedure. 
	*/
	public void execute() throws Exception {
		int valueSize = 0;
		Object[] strObj = null;
		this.errMsg = "";
		
		try {
			if(this.proc_single_value != null) valueSize = this.proc_single_value.size()/2;
			if(this.colSize == -1) this.colSize = valueSize;
			
			if(this.colSize == valueSize) {
				//how many times this query will be executed
				this.rowSize++;
				if(this.proc_single_value != null) {
					if(this.proc_multiple_value == null) this.proc_multiple_value = new ArrayList<Object[]>(1); 
					
					//store array list into string [as list is clear, refrences is lost]
					strObj = new Object[this.colSize*2];
					strObj = this.proc_single_value.toArray();
										
					this.proc_multiple_value.add(strObj);
										
					//free the qry_single_value arraylist
					this.proc_single_value.clear();
					this.proc_single_value = null;
					strObj = null;
				}
			}
			else {
				this.errMsg = "Mismatch in previous column size & current size";
				throw new Exception(this.errMsg);
			}
			
		}
		catch(Exception e) {
			this.errMsg = "HisProcedure.execute() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
	}
	
	/*
		This function executes a single procedure at a time which is in batch 
		It is called from HisDAO class (fire() function).
		This function does not set the output parameter.
	*/
	public void executeProc_Batch(Connection conn) throws Exception {
		
		Object[] tempList = null;
		String keyName = "";
		String[] keyValue = null;
		
		int lcl_col_size = 0;
		Object outValue = null;
		
		this.errMsg = "";
		
		try {
			
			if(!this.proc.equals("")) {
				if(this.cs == null) this.cs = conn.prepareCall(this.proc);
				
				if(this.proc_multiple_value != null) {
					tempList = (Object[])this.proc_multiple_value.get(this.gblIndex++);
					
					//sets the values in prepared statement
					for(int i = 0;i<this.colSize;i++) { 
						keyName = (String)tempList[2*i];
						keyValue = ((String)tempList[(2*i) + 1]).split("#");
						
						if(keyValue[0].equals("OUTPARAMETER")) {
							if(keyValue[1].equals("1"))	//string
								this.cs.registerOutParameter(keyName,java.sql.Types.VARCHAR);
							else
								//this.cs.registerOutParameter(keyName,OracleTypes.CURSOR);
								this.cs.registerOutParameter(keyName,java.sql.Types.REF_CURSOR);
						}
						else
							this.cs.setString(keyName,keyValue[0]);
					}
				}
				
				//execute the query
				this.cs.execute();
				
				//get the procedure output value
				if(this.proc_out_index != null && this.proc_out_index.size() > 0) {
					lcl_col_size = this.proc_out_index.size();
					//initilize HashMap
					this.proc_out_value = new HashMap<String,Object>(lcl_col_size);	
										
					for(int i = 0; i<lcl_col_size;i++) {
						//keyValue = PARAMETER NAME#OUTPUT TYPE
						keyValue = ((String)this.proc_out_index.get(i)).split("#");
						if(keyValue[1].equals("1"))	{		//string return value
							outValue = cs.getString(keyValue[0]);
							if(outValue == null) outValue = "";
						}
						else {		//resultset/webrowset
							outValue = cs.getObject(keyValue[0]);
						}
						
						proc_out_value.put(keyValue[0],outValue);
					}
				}
			}
			else {
				this.errMsg = "Procedure is blank";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.errMsg = "HisProcedure.executeProc_Batch() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			tempList = null;
		}
	}
	
	//used to reset value	
	public void resetValue() {
		try {
			if(this.cs != null) {
				cs.close();
				cs = null;
			}
		}
		catch(Exception e) {}
		
		//variable initilization
		if(this.proc_single_value != null) {
			this.proc_single_value.clear();
			this.proc_single_value = null;
		}
		
		if(this.proc_multiple_value != null) {
			this.proc_multiple_value.clear();
			this.proc_multiple_value = null;
		}
		
		if(this.proc_out_index != null) {
			this.proc_out_index.clear();
			this.proc_out_index = null;
		}
		
		if(this.proc_out_value != null) {
			this.proc_out_value.clear();
			this.proc_out_value = null;
		}
		
		this.colSize = -1;
		this.rowSize = 0;
		this.gblIndex = 0;
	}
	
	//Added by anshul for postgres compaibilty on 27 nov 2012
	/**
	 * executes a single procedure and sets the output value into proc_out_value map.
	 * @param conn - Connection Object.
	 * @throws Exception - if any Exception arrives at the time of execution.
	 */
	public void executeProcByPosition(Connection conn) throws Exception {
		
		CallableStatement cs = null;
		//Map  <String,String>proc_out_value = null;
		
		String strProcValue = "";
		String[] strProcArr = null;
		String keyName = "";
		String[] keyValue;	
		String[] paramValue;
		int index=0;
		ArrayList<String> keyNameIndex = null;
		
		String strTemp = "";
		Object outValue = null;		//output value for procedure
		ResultSet rs = null;
		WebRowSet retData = null;
		
		int lcl_col_size = 0;
		this.errMsg = "";
		this.procErrStr = "";
		int counter = 0;
		
		try {
			if(!this.proc.equals("")) {
				cs = conn.prepareCall(this.proc);
								
				if(this.proc_single_value != null) {
					lcl_col_size = this.proc_single_value.size()/2;
					
					//sets the values in callable statement
					for(int i = 0;i<lcl_col_size;i++) {
						
						paramValue = ((String)this.proc_single_value.get(2*i)).split(":");
						index=Integer.parseInt(paramValue[0]);
						
						keyValue = ((String)this.proc_single_value.get((2*i)+1)).split("#");
						//paramValue=((String)keyName[0]).split(":");
										
						if(keyValue[0].equals("OUTPARAMETER")) {
							
						
							strProcValue = ":X" + (++counter);
							
							if(keyValue[1].equals("1"))		//string
								cs.registerOutParameter(index,java.sql.Types.VARCHAR);
							else
							{//web row set
								//cs.setNull(index, java.sql.Types.REF);
								cs.setNull(index, Types.NULL);
								cs.registerOutParameter(index,java.sql.Types.REF_CURSOR);
							}
							
								//cs.registerOutParameter(keyName,OracleTypes.CURSOR);
						}
						else {
														        							
								 strProcValue = (String)this.proc_single_value.get((2*i)+1);
								 if(strProcValue==null || strProcValue.trim().equals(""))
										cs.setNull(index, Types.NULL);
								 else
						         cs.setString(index, strProcValue);
								 
						}
						
						if (i == 0)
							this.procErrStr += (paramValue[1] + "=>'" + strProcValue + "'");
						else
							this.procErrStr += ("," + paramValue[1] + "=>'" + strProcValue + "'");
						
					} //end for loop
										
					//free the qry_single_value arraylist
					this.proc_single_value.clear();
					this.proc_single_value = null;
				} // end if
				
				//execute the procedure
				cs.execute();
			
				//set the output data into Map
				if(this.proc_out_index != null && this.proc_out_index.size() > 0) {
					lcl_col_size = this.proc_out_index.size();
					//initilize HashMap
					this.proc_out_value = new HashMap<String,Object>(lcl_col_size);	
										
					for(int i = 0; i<lcl_col_size;i++) {
						//keyValue = PARAMETER NAME:PARAMETER POSITION#OUTPUT TYPE
						keyValue = ((String)this.proc_out_index.get(i)).split("#");
						paramValue=keyValue[0].split(":");
						index=Integer.parseInt(paramValue[1]);
						if(keyValue[1].equals("1"))	{		//string return value
							outValue = cs.getString(index);
							//outValue = cs.getString(4);
							if(outValue == null) outValue = "";
							//check err message returned by the procedure
							if(paramValue[0].toUpperCase().trim().equals("ERR")) {
								strTemp = (String)outValue;
								if(!strTemp.equals("") || strTemp.trim().length() > 0) {
									this.errMsg = "Error thrown by procedure : " + strTemp;
									throw new Exception(this.errMsg);
								}
							}
							//altered code
							if(paramValue[0].toUpperCase().trim().equals("ERRORMSG")) {
								strTemp = (String)outValue;
								if(!strTemp.equals("DATA FETCHED SUCESSFULLY") ) {
									this.errMsg = "Error thrown by procedure : " + strTemp;
									throw new Exception(this.errMsg);
								}
							}
							
							if(paramValue[0].toUpperCase().trim().equals("ERRORMSGCODE")) {
								strTemp = (String)outValue;
								//imp to check...
								String strTempTocheck="0";
								if(!(strTemp.trim().equalsIgnoreCase("0"))) {
									this.errMsgCode = "Error thrown by procedure : " + strTemp;
									throw new Exception(this.errMsg);
								}
							}
							if(paramValue[0].toUpperCase().trim().equals("ERR")) {
								strTemp = (String)outValue;
								if(!strTemp.equals("") || strTemp.trim().length() > 0) {
									this.errMsg = "Error thrown by procedure : " + strTemp;
									throw new Exception(this.errMsg);
								}
							}
							//altered code
							if(paramValue[0].toUpperCase().trim().equals("ERRORMSG")) {
								strTemp = (String)outValue;
								if(!strTemp.equals("DATA FETCHED SUCESSFULLY") ) {
									this.errMsg = "Error thrown by procedure : " + strTemp;
									throw new Exception(this.errMsg);
								}
							}
							if(paramValue[0].toUpperCase().trim().equals("ERRORMSGCODE")) {
								strTemp = (String)outValue;
								if(!(strTemp.trim().equalsIgnoreCase("0"))) {
									this.errMsg = "Error thrown by procedure : " + strTemp;
									throw new Exception(this.errMsg);
								}
							}
							proc_out_value.put(paramValue[0],outValue);
						}
						else {		//resultset/webrowset
							//rs = (ResultSet)cs.getObject(keyValue[0]);
							rs = (ResultSet)cs.getObject(index);
							
							retData = new WebRowSetImpl();
							retData.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
							retData.populate(rs);
							
							proc_out_value.put(paramValue[0],retData);
							//proc_out_value.put(paramValue[0],rs);
						}
						
						//proc_out_value.put(keyValue[0],outValue);
					}
				}
				
			} //end outer if block
			else {
				this.errMsg = "Procedure is blank";
				throw new Exception(this.errMsg);
			}
			
		}
		catch(Exception e) {
			strProcArr = (this.proc.replace("(", "#")).split("#");
			this.errMsg = "HisProcedure.executeProcByPosition(" + strProcArr[0] + "(" + this.procErrStr + ")) -->\n" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			try {
				if(cs != null) {
					cs.close();
					cs = null;
				}
				
				if (rs != null)
				{
					rs.close();
					rs = null;
				}
				
				outValue = null;
				if(this.proc_out_index != null) {
					this.proc_out_index.clear();
					this.proc_out_index = null;
				}
				this.errFlag = false;
				this.procErrStr = "";
			}
			catch(Exception e) {}
		}
	}
	
}
