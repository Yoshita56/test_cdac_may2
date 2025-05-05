/*
 Name		Ajay Kumar Gupta
*/
package hisglobal.backutil;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;

//import javax.naming.Context;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.WebRowSet;
//import javax.jms.*;

public final class HisUtil {
	
	private boolean retValue = false;
	private String moduleName = "";
	private String fileName = "";
	//used for error messages
	private String errMsg = "";
	
	//used in getDatePicker() function
	//private static final String jsPath = "../../hisglobal/js/calendar.js";
	//private static final String cssPath = "../../hisglobal/css/calendar-tas.css";
	private static final String imgPath = "../../hisglobal/images/iconPicDate.gif";
	
	//used in auditLog() function
	//private static Context auditLogCtx = null;
	//private static QueueConnectionFactory auditLogConnFactory = null;
	//private static Queue auditLogQueue = null;

	//private static final String AUDITLOG_QUEUE_NAME = "AUDIT_LOG_QUEUE";
	//private static final String AUDITLOG_FACTORY_NAME = "AUDIT_LOG_QUEUE_CONNECTION_FACTORY";
	//private static final String AUDITLOG_PATH = "C:/logs/";	
	
	//constructor
	public HisUtil(String moduleName,String fileName) {
		this.moduleName = moduleName;
		this.fileName = fileName;
	}
	
	//Returns retValue
	public boolean getReturnValue() {
		return retValue;
	}
	
	/*
	 	returns option value for combo/list.
	 	qry will be non-parameterized query and will have only two fields, one
	 	for option value and other for option name
	 	
	 	defOption -->If you want to add more than one option then concatenate with #
	 	e.g. 
	 	For More than one
	 	0^Select Value#1^All Value [0/1 represent option value & Select Value/
	 	All Value represent option name]
	 	
	 	if developer does not define option value then the system will start with 0 
	 	and then increment by 1 
	*/	 
	public String getOptionValue(String qry,String selValue,String defOption) throws Exception {
		
		HisDAO daoObj = null;
		WebRowSet ws = null;
		
		String optStr = new String("");
		String optVal = "";
		String optName = "";
		StringBuffer strBuffer = new StringBuffer(1000);
		String[] defOptionStr = null;
		String[] optValueStr = null;
		
		int i = 0;
		int index = 0;
		
		this.retValue = false;
		this.errMsg = "";
		
		try {
			if(!qry.equals("")) {
				//initilize HisDAO object
				daoObj = new HisDAO(this.moduleName,"HisUtil." + this.fileName);
				ws = daoObj.getQryResult(qry);
							
				if(ws != null) {
					if(!defOption.equals("")) {
						defOptionStr = defOption.split("#");
						for(int j = 0;j<defOptionStr.length;j++) {
							optValueStr = defOptionStr[j].replace('^','#').split("#");
							if(optValueStr.length == 1) {
								optVal = String.valueOf(index++);
								optName = optValueStr[0];
							}
							else {
								optVal = optValueStr[0];
								optName = optValueStr[1];
							}
							
							if(j==0)
								strBuffer.append("<option selected value = \"" + optVal + "\">" + optName + "</option>\n");
							else
								strBuffer.append("<option value = \"" + optVal + "\">" + optName + "</option>\n");	
						}
					}

					while(ws.next()) {
						if((selValue.equals("") && (i++==0) && defOption.equals("")) || 
								(selValue != "" &&  selValue.compareTo(ws.getString(1)) == 0))
							strBuffer.append("<option selected value = \"" + ws.getString(1) + "\">" + ws.getString(2) + "</option>\n");
						else
							strBuffer.append("<option value = \"" + ws.getString(1) + "\">" + ws.getString(2) + "</option>\n");
					} //end while block
					
					optStr = strBuffer.toString();
					this.retValue = true;
				} //end if block
			}
			else {
				this.errMsg = "HisUtil.getOptionValue(qry) -->Query is blank !!";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.errMsg = "HisUtil.getOptionValue(qry) -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			if(strBuffer != null) strBuffer = null;
			try {
				if(ws != null) {
					ws.close();
					ws = null;
				}
			}
			catch(Exception e) {}
			
			if(daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
			
			defOptionStr = null;
			optValueStr = null;
		}
		
		return optStr;
	}
	
	/*
	 	returns option value for combo/list.
	 	WebRowSet will have only two fields, one for option value and other for option name
		
		if query is parameterized then call using HisDAO class and pass WebRowSet to this 
		function
		
		defOption -->If you want to add more than one option then concatenate with #
	 	e.g. 
	 	For More than one
	 	0^Select Value#1^All Value [0/1 represent option value & Select Value/
	 	All Value represent option name]
	 	
	 	if developer does not define option value then the system will start with 0 
	 	and then increment by 1 
	*/	 
	public String getOptionValue(List data,String selValue,String defOption) throws Exception {
		
		String optStr = new String("");
		String optVal = "";
		String optName = "";
		StringBuffer strBuffer = new StringBuffer(1000);
		
		String[] defOptionStr = null;
		String[] optValueStr = null;
		
		int i = 0;
		int index = 0;
		
		this.retValue = false;
		this.errMsg = "";
		
		try {
			if(data != null) {
				if(!defOption.equals("")) {
					defOptionStr = defOption.split("#");
					for(i = 0;i<defOptionStr.length;i++) {
						optValueStr = defOptionStr[i].replace('^','#').split("#");
						if(optValueStr.length == 1) {
							optVal = String.valueOf(index++);
							optName = optValueStr[0];
						
						}
						else {
							
							optVal = optValueStr[0];
							optName = optValueStr[1];
						}
						
						if(i==0)
							strBuffer.append("<option selected value = \"" + optVal + "\">" + optName + "</option>\n");
						else
							strBuffer.append("<option value = \"" + optVal + "\">" + optName + "</option>\n");	
					}
				}
				
				for(i=0;i<data.size();i=i+2) {
					if((selValue.equals("") && (i==0) && defOption.equals("")) || 
							(selValue != "" &&  selValue.compareTo((String)data.get(i)) == 0))
						strBuffer.append("<option selected value = \"" + (String)data.get(i) + "\">" + (String)data.get(i+1) + "</option>\n");
					else
						strBuffer.append("<option value = \"" + (String)data.get(i) + "\">" + (String)data.get(i+1) + "</option>\n");
				} //end while block
					
				optStr = strBuffer.toString();
				this.retValue = true;
			} //end if block
			else {
				
				
			this.errMsg = "HisUtil.getOptionValue(ws) -->WebRowSet is blank!!";
			throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.errMsg = "HisUtil.getOptionValue(ws) -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			if(strBuffer != null) strBuffer = null;
			defOptionStr = null;
			optValueStr = null;
		}
		
		return optStr;
	}
	
	/*
 	returns option value for combo/list.
 	qry will be non-parameterized query and will have only more than two fields, one
 	for option name but could be more than one for option id. In this case the system
 	will concatenate fields with ^
 	
 	concateId --> If it is true then this function will concatenate all the column except
 					the last name which will be used for display name.
 				  If it is false then this function will assume the first column as ID
 				  and the last one as display name	
 	
 	defOption -->If you want to add more than one option then concatenate with #
 	e.g. 
 	For More than one
 	0^Select Value#1^All Value [0/1 represent option value & Select Value/
 	All Value represent option name]
 	
 	if developer does not define option value then the system will start with 0 
 	and then increment by 1 
*/	 
public String getOptionValue(WebRowSet ws,String selValue,String defOption,boolean concateId) throws Exception {
	
	String optStr = new String("");
	String optVal = "";
	String optName = "";
	StringBuffer strBuffer = new StringBuffer(1000);
	String[] defOptionStr = null;
	String[] optValueStr = null;
	
	int i = 0, j = 0;
	int index = 0;
	int colCount = 0;
	
	this.retValue = false;
	this.errMsg = "";
	
	try {
		if(ws != null) {
			if(!defOption.equals("")) {
				defOptionStr = defOption.split("#");
				for(j = 0;j<defOptionStr.length;j++) {
					optValueStr = defOptionStr[j].replace('^','#').split("#");
					if(optValueStr.length == 1) {
						optVal = String.valueOf(index++);
						optName = optValueStr[0];
					}
					else {
						optVal = optValueStr[0];
						optName = optValueStr[1];
					}
						
					if(j==0)
						strBuffer.append("<option selected value = \"" + optVal + "\">" + optName + "</option>\n");
					else
						strBuffer.append("<option value = \"" + optVal + "\">" + optName + "</option>\n");	
				}
			}
				
			//count the column provided
			colCount = ws.getMetaData().getColumnCount();
										
			while(ws.next()) {
				optVal = "";
				optName = "";
					
				//concatenate the id
				if(concateId) {
					for(j = 0;j<(colCount-1);j++) {
						if(j == 0)
							optVal = ws.getString(j + 1);
						else
							optVal += "^" + ws.getString(j + 1);
					}
				}
				else {
					optVal = ws.getString(1);
					j = colCount - 1;
				}
				
				//option value
				optName = ws.getString(j + 1);
									
				if((selValue.equals("") && (i++==0) && defOption.equals("")) || 
						(selValue != "" &&  selValue.compareTo(optVal) == 0))
					strBuffer.append("<option selected value = \"" + optVal + "\">" + optName + "</option>\n");
				else
					strBuffer.append("<option value = \"" + optVal + "\">" + optName + "</option>\n");
			} //end while block
				
			optStr = strBuffer.toString();
			this.retValue = true;
		} //end if block
		else {
			
			this.errMsg = "HisUtil.getOptionValue(4 parameters) -->WebRowSet is blank!!";
		throw new Exception(this.errMsg);
		}
	}
	catch(Exception e) {
		this.errMsg = "HisUtil.getOptionValue(4 parameters) -->" + e.getMessage();
		throw new Exception(this.errMsg);
	}
	finally {
		if(strBuffer != null) strBuffer = null;
		/*try {
			if(ws != null) {
				ws.close();
				ws = null;
			}
		}
		catch(Exception e) {}*/

		defOptionStr = null;
		optValueStr = null;
	}
	
	return optStr;
}

	//Returns amount in words
	public String getAmountStr(String amt) throws Exception {
		
		WebRowSet ws = null;
		HisDAO daoObj = null;
		String amtStr = "";
		String sql = "";
		String rupees = "";
		String paisa  = "";
		int pos = -1;
		
		this.retValue = false;
		this.errMsg = "";
		
		if (Double.parseDouble(amt) == 0) return "Zero Rupee Only";
		if(Double.parseDouble(amt)<0) amt = amt.substring(1);
		
		rupees = amt;
		pos = amt.indexOf(".");		
		
		if(pos != -1) {
			rupees = amt.substring(0,pos);
			paisa = amt.substring(pos+1);
			if(!paisa.equals(""))
				if(Integer.parseInt(paisa) == 0) paisa = "";
		}
		
		if(!rupees.equals(""))
			if(Integer.parseInt(rupees) == 0) rupees = "";
					
		//execte function that converts amount in word
		if(paisa.equals(""))
			sql = "SELECT  DIGITWORD(to_number('" + rupees + "'))||' '||'' FROM DUAL";
		else {
			if(rupees.equals(""))
				sql = "SELECT  DIGITWORD(to_number('" + paisa + "'))||' '||'' FROM DUAL";
			else { 
				sql = "SELECT  DIGITWORD(to_number('" + rupees + "'))||' '||''||DIGITWORD(to_number('" + 
				  	  paisa + "'))||' '||'' FROM DUAL";
			}
		}
		
		try {
			if(!sql.equals("")) {
				//initilize HisDao object
				daoObj = new HisDAO(moduleName,"HisUtil." + fileName);
				ws = daoObj.getQryResult(sql);
				if(ws != null) {
					if(ws.next()) {
						amtStr = ws.getString(1);
						this.retValue = true;
					}
				}
			}
		}
		catch(Exception e) {
			this.errMsg = "HisUtil.getAmountStr() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			try {
				if(ws != null) {
					ws.close();
					ws = null;
				}
				if(daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
			catch(Exception e) {}
		}
				
		return amtStr;
	}
	
	//returns string in initcap [e.g. Ajay Kumar Gupta]
	public String toInitCap(String myString) throws Exception {
		
		StringTokenizer st = new StringTokenizer(myString," ");
		
		String initCapStr = "";
		String temp1 = "";
		String temp = "";
		
		this.retValue = false;
		this.errMsg = "";
		
		try {
			while(st.hasMoreTokens()) {
				temp = st.nextToken();
				temp1 = temp.substring(0,1).toUpperCase();
				temp1 = temp1 + temp.substring(1).toLowerCase() ;
				initCapStr = initCapStr + temp1 + " ";
			}
			
			this.retValue = true;
		}
		catch(Exception e) {
			this.errMsg = "HisUtil.toInitCap() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			st = null;
		}
				
		return initCapStr;
	}
	
	/*
	 	Returns key value based on key name [keyName should be integer]
	 	lstData should have two fields first for key Value and last for Key Name
	 	The Data in lstData should be either in ascending order or descending order
	 	
	 	dataOrder = 0		//Ascending order
	 			  = 1		//Descending order
	 	
	 	This method uses Binary Search Algo 
	*/
	public String search(List lstData,int keyName,int dataOrder) 
		throws Exception {
		
		String keyValue = "No Data Found !!";
		
		int recSize = 0;
		int lowValue = 0;
		int midValue = 0;
		int highValue = 0;
		int index = 0;
		int tempKeyName = 0;
		
		this.retValue = false;
		this.errMsg = "";
		
		try {
			if(lstData != null) {
		
				recSize = lstData.size()/2;		//record count
				lowValue = 0;
				highValue = recSize;
				
				if(recSize > 0) {
					while(lowValue<=highValue) {
						midValue = (int)((lowValue + highValue)/2);
						index = (midValue*2-1);
						
						if(index < 0) index = 1;
						tempKeyName = Integer.parseInt((String)lstData.get(index));
						if(keyName == tempKeyName) {
							keyValue = (String)lstData.get(index-1);
							break;
						}
						else {
							if(dataOrder == 0) {		//data is in ascending order
								if(keyName>tempKeyName)
									lowValue = midValue + 1;
								else
									highValue = midValue - 1;
							}
							else {						//data is in descending order
								if(keyName>tempKeyName)
									highValue = midValue - 1;
								else
									lowValue = midValue + 1;
							}
						}
					} // end while loop
				} //end if block (recSize > 0)
			} //end if block 
			this.retValue = true;
		}
		catch(Exception e) {
			this.errMsg = "HisUtil.search(int)-->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		
		return keyValue;
	}
	
	/*
	 	Returns key value based on key name [keyName should be string]
	 	lstData should have two fields first for key Value and last for Key Name
	 	The Data in lstData should be either in ascending order or descending order
	 	
	 	dataOrder = 0		//Ascending order
	 			  = 1		//Descending order
	 	
	 	This method uses Binary Search Algo 
	*/
	public String search(List lstData,String keyName,int dataOrder) 
		throws Exception {
		
		String keyValue = "No Data Found !!";
		String tempKeyName = "";
		
		int recSize = 0;
		int lowValue = 0;
		int midValue = 0;
		int highValue = 0;
		int index = 0;
				
		this.retValue = false;
		this.errMsg = "";
		
		try {
			if(lstData != null) {
		
				recSize = lstData.size()/2;		//record count
				lowValue = 0;
				highValue = recSize;
				
				if(recSize > 0) {
					while(lowValue<=highValue) {
						midValue = (int)((lowValue + highValue)/2);
						index = (midValue*2-1);
						
						if(index < 0) index = 1;
						tempKeyName = (String)lstData.get(index);
						if(keyName.equals(tempKeyName)) {
							keyValue = (String)lstData.get(index-1);
							break;
						}
						else {
							if(dataOrder == 0) {		//data is in ascending order
								if(keyName.compareTo(tempKeyName) > 0)
									lowValue = midValue + 1;
								else
									highValue = midValue - 1;
							}
							else {						//data is in descending order
								if(keyName.compareTo(tempKeyName) > 0)
									highValue = midValue - 1;
								else
									lowValue = midValue + 1;
							}
						}
					} // end while loop
				} //end if block (recSize > 0)
			} //end if block 
			this.retValue = true;
		}
		catch(Exception e) {
			this.errMsg = "HisUtil.search(String) -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		
		return keyValue;
	}

	/*
	 	Returns Application Server Date
	 	dtFormat --> date format[dd/MM/yyyy, dd/MMM/yyyy etc] 
	 	
	 	if dtFormat is blank then default format is dd/MM/yyyy
	*/
	public String getASDate(String dtFormat) throws Exception {
		
		String dtStr = "";
		String defFormat = "";
		Calendar c = null;
		SimpleDateFormat dateFormat = null;
		
		this.retValue = false;
		this.errMsg = "";
		
		defFormat = dtFormat;
		if(defFormat.equals("")) defFormat = "dd/MM/yyyy";
		
		try {
			c = Calendar.getInstance();
			dateFormat = new SimpleDateFormat(defFormat);
			dtStr = dateFormat.format(c.getTime());
			this.retValue = true;
		}
		catch(Exception e) {
			this.errMsg = "HisUtil.getASDate() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			if(c != null) {
				c.clear();
				c = null;
			}
			if(dateFormat != null) dateFormat = null;
		}
		
		return dtStr;
	}
	
	/*
 		Returns Database Server Date
 		dtFormat --> date format[dd/mm/yyyy, dd/mon/yyyy etc] 
 		
 		if dtFormat is blank then default format is dd/mm/yyyy
 	*/
	public String getDSDate(String dtFormat) throws Exception {
		
		HisDAO daoObj = null;
		WebRowSet ws = null;
		
		String dtStr = "";
		String qry = "";
		String defFormat = "";
		
		this.retValue = false;
		this.errMsg = "";
		
		defFormat = dtFormat;
		if(defFormat.equals("")) defFormat = "dd/mm/yyyy";
		qry = "SELECT TO_CHAR(SYSDATE,'" + defFormat + "') FROM DUAL";
		
		try {
			//initilize HisDAO object
			daoObj = new HisDAO(this.moduleName,"HisUtil." + this.fileName);
			ws = daoObj.getQryResult(qry);
			if(ws != null) {
				if(ws.next()) {
					dtStr = ws.getString(1);
					this.retValue = true;
				}
			}
		}
		catch(Exception e) {
			this.errMsg = "HisUtil.getDSDate()-->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			try {
				if(ws != null) {
					ws.close();
					ws = null;
				}
				if(daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
			catch(Exception e) {}
		}
		
		return dtStr;
	}
	
	/*
	 	Returns date picker string
	 	dateValue --> Default date that could be blank
	*/
	public static String getDatePicker(String fieldName,String dateValue,boolean readOnly) {
		  
		  String dateString = "";
		  StringBuilder strBuffer = new StringBuilder(500);
		  
		  //strBuffer.append("<script language=\"JavaScript\" src=\"" + jsPath + "\"></script>\n");
		  //strBuffer.append("<link href=\"" + cssPath + "\" rel=\"stylesheet\" type=\"text/css\">\n");
		  
		  strBuffer.append(" <input size='9%' type=\"text\" name=\"" + fieldName + "\" id=\"" + fieldName + "\" ");
		  if(readOnly){ strBuffer.append(" readonly = \"false\" ");}
		  strBuffer.append(" value='"+dateValue+"'>");
		  strBuffer.append(" <img src=\"" + imgPath + "\" id=\"" + fieldName + "1\" style=\"cursor: pointer; border: 1px solid red;\" title=\"Date selector\" ");
		  strBuffer.append(" onmouseover=\"this.style.background='red';\" onmouseout=\"this.style.background=''\"> \n");
		  strBuffer.append(" <script language=\"JavaScript\">\n Calendar.setup\n(\n{ \n");
		  strBuffer.append(" inputField : \"" + fieldName + "\",ifFormat : \"%d-%b-%Y\",button : \"" + fieldName + "1\",singleClick : true\n");
		  strBuffer.append(" }\n);\n</script>\n");
		      
		  dateString = strBuffer.toString();
		  strBuffer = null;
		   
		  return dateString;
	}

	/*
	  Returns date picker string
	  dateValue --> Default date that could be blank
	*/
	 
	public static String getDatePicker(String fieldName,String dateValue,String idValue,boolean readOnly) {
	 
	 String dateString = "";
	 StringBuilder strBuffer = new StringBuilder(500);
	 
	 //strBuffer.append("<script language=\"JavaScript\" src=\"" + jsPath + "\"></script>\n");
	 //strBuffer.append("<link href=\"" + cssPath + "\" rel=\"stylesheet\" type=\"text/css\">\n");
	 
	 strBuffer.append("<input size='9%' type=\"text\" name=\"" + fieldName + "\" id=\"" + (fieldName + idValue) + "\" class=\"dtBox\" ");
	 if(readOnly) strBuffer.append(" readonly ");
	 strBuffer.append("value='"+dateValue+"'>");
	 strBuffer.append("<img src=\"" + imgPath + "\" id=\"" + (fieldName + idValue) + "1\" align=\"absmiddle\" style=\"cursor: pointer; border: 1px solid red;\" title=\"Date selector\" ");
	 strBuffer.append("onmouseover=\"this.style.background='red';\" onmouseout=\"this.style.background=''\"> \n");
	 strBuffer.append("<script language=\"JavaScript\">\n Calendar.setup\n(\n{ \n");
	 strBuffer.append("inputField : \"" + (fieldName + idValue) + "\",ifFormat : \"%d-%b-%Y\",button : \"" + (fieldName + idValue) + "1\",singleClick : true\n");
	 strBuffer.append("}\n);\n</script>\n");
	     
	 dateString = strBuffer.toString();
	 strBuffer = null;
	  
	 return dateString;
	}

	
	//function that appends space upto given length
	public String appendSpace(String strValue,int len) {

		String retStrValue = "";
		int diffLen = 0;
		int i = 0;

		diffLen = len - strValue.length();
		retStrValue = strValue;

		if(diffLen > 0) {
			for(i = 0;i<diffLen;i++)
				retStrValue += " ";			
		}

		return retStrValue;	
	} //end function

	/*function that breaks up the string based on given length 
		[len --> total length, symbol --> used if string breaks up to identify the string]
		len should be greater than 2
	*/
	public List breakString(String strValue,int len,String symbol) {

		List <String>retStrValue = new ArrayList<String>();
		String tempStr = "";
		int diffLen = 0;

		tempStr = strValue;

		while(true) {
			diffLen = tempStr.length()-len;
			if(diffLen > 0) {		//break up
				retStrValue.add(tempStr.substring(0,len-2) + " " + symbol);
				tempStr = tempStr.substring(len-2);
			}
			else {
				retStrValue.add(appendSpace(tempStr,len));
				break;					
			}
		}

		return retStrValue;
	} //end function

	/*
		This function is used to read the entire contents from the file
	*/
	public String readFile(String filePath) throws Exception {

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		File f = null;
		int j = 0;
		boolean eof = false;
		StringBuffer strBuff = null;

		this.errMsg = "";
		
		try {
			if(!filePath.trim().equals("")) {
				fis = new FileInputStream(filePath);
				bis = new BufferedInputStream(fis);
				f   = new File(filePath);
				strBuff = new StringBuffer((int)f.length());

				while(!eof) {
					j = bis.read();
					if(j==-1)
						eof = true;
					else 
						strBuff.append((new Character((char)j)).toString());
				}
			}
		}
		catch(Exception e) {
			this.errMsg = "HisUtil.readFile()-->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			try {
				if(bis != null) bis.close();
				if(fis != null) fis.close();
				f = null;			
				fis = null;
				bis = null;
			}
			catch(Exception e) {}
		}

		return strBuff.toString();
	} //end

	/*
		This function is used to write the contents into file. It will always overwrite into file
	*/
	public boolean writeFile(String contents,String filePath) throws Exception {

		FileWriter FR 		= null;
		BufferedWriter OS	= null;
		boolean retValue	= false;
		this.errMsg = "";
		
		try {
			FR 	= new FileWriter(filePath,false);
			OS	= new BufferedWriter(FR);
			OS.write(contents);
			retValue = true;
		}
		catch(Exception e) {
			this.errMsg = "HisUtil.writeFile()-->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			try {
				if(OS != null) OS.close();
				if(FR != null) FR.close();

				OS = null;
				FR = null;
			}
			catch(Exception e) {}
		}

		return retValue;
	}
	
	/*
	This method is used to send the messgae to JMS server. It accepts the following parameter

	session : this is session object which is created at the time of login. So you don't worry about 
				its attributes.

	modName : Name of Module
	task : Name of process
	
	tabFieldInfo : This field will have the table.field details with unique index that will be used
				   with linking with oldValue/newValue	
					1^tableName^fieldName#2^tableName^fieldName

	oldValue : This field will have the old value in the following format if there is more than one 
			   row then each & every row will be concatenated with # symbol

			   1^value1^value2^value3...#2^value1^value2....

	newValue : This field will have the new value in the following format if there is more than one 
			   row then each & every row will be concatenated with # symbol

			   1^value1^value2^value3...#2^value1^value2....

	Note >> There is not necessary that index order should be same with tabFieldInfo/oldVale/newValue

	fileName >> Audit Log File Name (do n't specify the path)
	remarks : Any other info that you want to display [you can pass primary key]		   
*/
	
	public static boolean auditLog(HttpSession session,String modName,String task,
		String tabFieldInfo,String oldValue,String newValue,String remarks,String fileName) throws Exception {
		
		boolean retVal = false;
		String errorStr = "";
		
		/*commented b'coz Tomacat is not application server
		String userName = "";
		String ipAddr = "";
		String auditMsg = "";
	
		QueueConnection auditLogConn = null;
		QueueSession auditLogSession = null;
		QueueSender audiLogSender = null;
		MapMessage audiLogInfo = null;

		try
		{
			//extract module/process name from session
			userName = (String)session.getAttribute("userName");
			ipAddr = (String)session.getAttribute("IP_ADDR");
	
			if(userName == null) userName = "";
			if(ipAddr == null) ipAddr = "";
	
			if(fileName.equals("") || userName.equals("") || modName.equals("")) {
				errorStr = "HisUtil.auditLog()-->FileName/user/module is blank";
				throw new Exception(errorStr);
			}
			
			//java.util.Hashtable props = new java.util.Hashtable();
			//props.put("java.naming.factory.initial", "com.pramati.naming.client.PramatiClientContextFactory");
			//props.put("java.naming.provider.url", "rmi://10.103.0.18:9191");
			//props.put("java.naming.provider.url", "rmi://localhost:9191");
			//props.put(Context.SECURITY_PRINCIPAL,"root");
			//props.put(Context.SECURITY_CREDENTIALS,"pramati");
			//props.put("com.pramati.naming.realm","system");
			

			//getting connection factory & queue reference
			//if(auditLogCtx == null) auditLogCtx = new InitialContext(props);
			if(auditLogCtx == null) auditLogCtx = new InitialContext();
			if(auditLogConnFactory == null) auditLogConnFactory = (QueueConnectionFactory) auditLogCtx.lookup(AUDITLOG_FACTORY_NAME);
			if(auditLogQueue == null) auditLogQueue = (Queue) auditLogCtx.lookup(AUDITLOG_QUEUE_NAME);
	
			//getting queue connection
			auditLogConn = auditLogConnFactory.createQueueConnection();
			auditLogSession = auditLogConn.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
			audiLogSender = auditLogSession.createSender(auditLogQueue);
			audiLogInfo = auditLogSession.createMapMessage();

			//create message that is to be sent to JMS server
			audiLogInfo.setString("1",modName);
			audiLogInfo.setString("2",task);
			audiLogInfo.setString("3",userName);
			audiLogInfo.setString("4",ipAddr);
			audiLogInfo.setString("5",tabFieldInfo);
			audiLogInfo.setString("6",oldValue);
			audiLogInfo.setString("7",newValue);
			audiLogInfo.setString("8",remarks);
			audiLogInfo.setString("9",AUDITLOG_PATH + fileName);
	
			audiLogSender.send(audiLogInfo);
			retVal = true;
		}
		catch(NamingException ne)
		{
			errorStr = "HisUtil.auditLog()-->" + ne.getMessage();
			throw new Exception(errorStr);
		}
		catch(JMSException je)
		{
			errorStr = "HisUtil.auditLog() -->" + je.getMessage();
			throw new Exception(errorStr);
		}
		finally
		{
			try
			{
				if(auditLogConn != null) auditLogConn.close();
				if(auditLogSession != null) auditLogSession.close();
				if(audiLogSender != null) audiLogSender.close();
	
				auditLogConn = null;
				auditLogSession = null;
				audiLogSender = null;
				audiLogInfo = null;
			}
			catch(Exception e) {
				errorStr = "HisUtil.auditLog()-->" + e.getMessage();
				throw new Exception(errorStr);
			}
		}*/

		return retVal;
	}
	
}
