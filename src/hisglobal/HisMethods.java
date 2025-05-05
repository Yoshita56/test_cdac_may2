package hisglobal;

import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import hisglobal.persistence.Conn;
import hisglobal.persistence.HisResultSet;



public class HisMethods
{
	public static LinkedHashMap openMap		= new LinkedHashMap();
	public static LinkedHashMap closeMap	= new LinkedHashMap();
	
 	

	/* Conn Related Methods */
	
	//Getting HisResultSet from Conn
	public synchronized HisResultSet getRecord(String query)throws Exception 
	{
		HisResultSet rs = HisResultSet.getInstance();
		Conn conObj	= Conn.getInstance();
		try
		{
			this.putOpenMap();
			rs = conObj.getRecord(query);
			this.putCloseMap();
		}
		catch(Exception e)
		{
			System.out.println("Exception at getRecord of HisMethods "+e);
			this.putCloseMap();
		} 
		return rs;
	}
	
	// method for prepared query added on 10July2006
	public synchronized HisResultSet getRecord2(String query, String[] val)throws Exception 
	{
		HisResultSet rs = HisResultSet.getInstance();
		Conn conObj	= Conn.getInstance();
		try
		{
			this.putOpenMap();
			rs = null;
			this.putCloseMap();
		}
		catch(Exception e)
		{
			System.out.println("Exception at getRecord of HisMethods "+e);
			this.putCloseMap();
		} 
		return rs;
	}
	
	//Getting HisResultSet from Conn Returns empty string inplace of null
	public synchronized HisResultSet getRecord(String query, boolean dummy)throws Exception 
	{
		HisResultSet rs = HisResultSet.getInstance();
		Conn conObj	= Conn.getInstance();
		try
		{
			this.putOpenMap();
			rs = conObj.getRecord(query, true);
			this.putCloseMap();
		}
		catch(Exception e)
		{
			System.out.println("Exception at getRecord of HisMethods "+e);
			this.putCloseMap();
		} 
		return rs;
	}
	
	//Updating the Record by given query
	public synchronized boolean updateRecord(String query)throws Exception
	{
		
		boolean retValue = false;
		Conn conObj = Conn.getInstance();
		
		try
		{
			this.putOpenMap();
			retValue = conObj.updateRecord(query);
			this.putCloseMap();
		}
		catch(Exception e)
		{
			System.out.println("Exception at updateRecord of HisMethods "+e);
			this.putCloseMap();
			retValue = false;
		}
		return retValue;
	}
	
	//Getting Connection From Conn for multiple update 
	public synchronized Connection getConnection()
	{
		Conn conObj = Conn.getInstance();
		Connection conn = null;
		try
		{
			this.putOpenMap();
			conn = conObj.getConnection();
		}
		catch(Exception e)
		{
			System.out.println("Exception at getConnection of HisMethods "+e);
			e.printStackTrace();
		}
		return conn;
	}
	
	
	//Closing the retrieved Connection
	public synchronized void closeConnection(Connection conn)
	{
		Conn conObj = Conn.getInstance();
		try
		{
			this.putCloseMap();
			conObj.closeConnection(conn);
		}
		catch(Exception e)
		{
			System.out.println("Exception at closeConnection of HisMethods "+e);
		}
	}
	
	
	/* Generally Used Method */ 
	
	
	
	//Getting ArrayList based on Query 
	public synchronized List getDetail(String query)throws Exception
	{
		int i=1;
		List AL_Detail = new ArrayList();

		Conn conObj	= Conn.getInstance();
		
		Connection conn1  = conObj.getConnection();
		Statement st = conn1.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
		java.sql.ResultSet rs = st.executeQuery(query);

		ResultSetMetaData rsmd 	= rs.getMetaData();
		int noOfColumn 			= rsmd.getColumnCount();

		if (rs == null)
			return AL_Detail;
		
		//System.out.println("noOfColumn "+noOfColumn);
		while(rs.next())
		{
			i=1;
			while( i <= noOfColumn )
			{
				AL_Detail.add((rs.getString(i) == null)?"":rs.getString(i).trim());
				i++;
			}
		}

		//myMan.returnConnection(conn1);
		rs.close();
		st.close();
		conObj.closeConnection(conn1);

		return AL_Detail;

	}

	//Getting Next number faatched by query
	public synchronized String getNextNo(String query, String def)
	{

		String 		nextNo 	= 	null;
		HisResultSet 	rs		=	null;

		try
		{
			rs = Conn.getInstance().getRecord(query);
			
			if(rs.next())
				nextNo = rs.getString(1);

			//System.out.println("Next No "+nextNo);
			
			if(nextNo==null || nextNo.trim().equals(""))
				nextNo=def;
			else
				nextNo=(Integer.parseInt(nextNo)+1)+"";

		}
		catch(SQLException se)
		{
			System.out.println("error while fetching data from getNextNo():\n"+se);
		}

		return nextNo;
	}


	//Get the Field based on query  
	public synchronized String getField(String query)
	{
		String 		str		=	"";
		HisResultSet 	rs	=	null;

		try
		{
			rs = Conn.getInstance().getRecord(query);
			if(rs.next())
				str=rs.getString(1);

		}
		catch(SQLException se)
		{
			System.out.println("3.error while fetching data from getField():\n"+se);
		}

		return str;
	}

	
	//Getting hte integer value
	public synchronized String getValue(String query)
	{

		String 		value	=	"";
		HisResultSet 	rs		=	null;

		try
		{
			rs 	= 	Conn.getInstance().getRecord(query);
			if(rs.next())
				value = rs.getString(1);
		}
		catch(SQLException se)
		{
			value="";
			System.out.println("1.error while fetching data from getValue():\n"+se);
		}
	
		return value;
	}

	//Getting Patient Detail ArrayList Such as Name etc 
	public synchronized List getPatientDetail(String crNo)
	{
		String query =	"SELECT INITCAP(HRGSTR_FNAME) || ' ' || INITCAP(HRGSTR_MNAME) || ' ' "+
						"||INITCAP(HRGSTR_LNAME) PNAME, GETAGE(HRGDT_DOB) AGE, "+
						"DECODE(GNUM_GENDER_CODE,'1','Male','2','Female') GENDER, "+
						"(SELECT INITCAP(HGSTR_PATIENT_CAT_NAME) FROM HGBT_PATIENT_CAT_MST "+
						"WHERE HGBT_PATIENT_CAT_MST.HGNUM_PATIENT_CAT_CODE=A.HGNUM_PATIENT_CAT_CODE) PCAT, "+
						"(SELECT INITCAP(HGSTR_PAT_STATUS) FROM HGBT_PATIENT_STATUS_MST WHERE "+ 
						"HGBT_PATIENT_STATUS_MST.HGNUM_PAT_STATUS_CODE=A.HGNUM_PAT_STATUS_CODE) PSTATUS "+
						"FROM HRGT_PATIENT_DTL A "+
						"WHERE HRGNUM_PUK='"+crNo+"'";
		
		List patientDetail = new ArrayList();
		try
		{
			//System.out.println("Query "+query);
			//0 Name 1 Age 2 Gen 3 Cat 4 stat
			patientDetail = this.getDetail(query);
		}
		catch(Exception e)
		{
			System.out.println("Exception at GetPatientDetail "+e);
		}
		return patientDetail;
	}
	
	//Getting Dept Unit Name by Unit Code
	public synchronized List getDeptUnitName(String unitNo)
	{
		String query =	"SELECT INITCAP(GSTR_DEPT_NAME),INITCAP(HGSTR_UNITNAME) "+
						"FROM GBLT_DEPARTMENT_MST A, HGBT_UNIT_MST B "+
						"WHERE A.GNUM_DEPT_CODE=B.GNUM_DEPT_CODE "+
						"AND B.HGNUM_DEPTUNITCODE='"+unitNo+"'";
		
		List patientDetail = new ArrayList();
		try
		{
			//0 Dept 1 Unit
			patientDetail = this.getDetail(query);
		}
		catch(Exception e)
		{
			System.out.println("Exception at getDeptUnitName "+e);
		}
		return patientDetail;
	}
	
	private void putOpenMap()
	{
		String reference = this.getClass().getName();
		String data = (String)this.openMap.get(reference);

		if(data==null)
			this.openMap.put(reference,"1");
		else
			this.openMap.put(reference,(Integer.parseInt(data)+1)+"");
	}
	
	private void putCloseMap()
	{		
		String reference = this.getClass().getName();		
		String data = (String)this.closeMap.get(reference);		
		if(data==null)
			this.closeMap.put(reference,"1");
		else
			this.closeMap.put(reference,(Integer.parseInt(data)+1)+"");					
	}
	
	/*public void finalize()
	{
		java.util.Date date = new java.util.Date();
		
		Set openKs	= this.openMap.keySet();
		Set closeKs	= this.closeMap.keySet();

		Object[] openArr	= openKs.toArray();
		Object[] closeArr	= closeKs.toArray();
		
		String Data = "\nLog Comment created at "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()+"\n";

		Arrays.sort(openArr);
		Arrays.sort(closeArr);
		
		//Open Arr
		for(int i=0;openArr!=null && i<openArr.length;i++)
			Data += "\n\tOpen Connection By\tClass "+openArr[i]+"\t\t\t"+this.openMap.get(openArr[i]);

		Data += "\n";
		//Close Arr
		for(int i=0;closeArr!=null && i<closeArr.length;i++)
			Data += "\n\tClose Connection By\tClass "+closeArr[i]+"\t\t\t"+this.closeMap.get(closeArr[i]);
		
		if(openArr==null && closeArr==null)
			return;
		
		
		try
		{
			File f = new File("Log_"+date.getDate()+"_"+(date.getMonth()+1)+"_"+(date.getYear()+1900)+".txt");
			f.createNewFile();

			FileOutputStream fos = new FileOutputStream(f,false);
			fos.write(Data.getBytes());
			fos.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception on finalizer "+e);
			e.printStackTrace();
		}
	} */
	
	
//	 getField method for the prepared queries added on 12Sep2006
	public synchronized String getField2(String query, String[] val)
	{
		String 		str		=	"";
		HisResultSet 	rs	=	null;
		try
		{
			rs = null;
			if(rs.next())
				str=rs.getString(1);
		}
		catch(Exception se)
		{
			System.out.println("3.error while fetching data from getField():\n"+se);
		}
    return str;
	}
	
	public synchronized String getValue2(String query, String[] val)
	{

		String 		value	=	"";
		HisResultSet 	rs		=	null;

		try
		{
			rs 	= 	null;
			if(rs.next())
				value = rs.getString(1);
		}
		catch(Exception se)
		{
			value="";
			System.out.println("1.error while fetching data from getValue():\n"+se);
		}
	
		return value;
	}
	
}//end of class
