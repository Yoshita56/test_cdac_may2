package hisglobal.persistence;

import hisglobal.utility.Entry;

import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;
import java.util.Set;

import javax.sql.rowset.WebRowSet;

import java.util.Iterator;
import java.sql.PreparedStatement;
import java.sql.Connection;
import com.sun.rowset.WebRowSetImpl;

public class HelperMethodsDAO
{
	
	/**
	 * used for error messages
	 */
	private String errMsg = "";
	public static ResourceBundle loadPropertiesFile(String _fileName) throws Exception
	{
		//System.out.println("fileName::::::::::::::::::::::::::::");
		String BUNDLE_NAME = _fileName;
		System.out.println("fileName" + _fileName);
		ResourceBundle rb = ResourceBundle.getBundle(BUNDLE_NAME);
		try
		{

		}
		catch (MissingResourceException e)
		{
			//  return '!' +"database"+ '!';
		}

		/*  System.out.println("_fileName::"+_fileName);
		 String _fileName12="E:\\WorkSpace28-09-07WithRenewal\\AHIMS\\src\\his\\global\\dao\\mastersQuery.properties";		    
		 String _fileName1="E:\\WorkSpace28-09-07WithRenewal\\AHIMS\\src\\his\\global\\dao\\registrationQuery.properties";
		String file=RegistrationConfig.QUERY_FILE_FOR_MASTERSDAO;
		 System.out.println("_fileNames:  "+_fileName12);
		Properties properties = new Properties();	 
		System.out.println("sdsd");
		properties.load(new FileInputStream(_fileName12.trim())); 
		properties.load(new FileInputStream(_fileName1.trim()));
		//properties.load(new FileInputStream(file.trim()));
		System.out.println("_fileName:  "+_fileName12);
		OutputStream os=new FileOutputStream("D:\\file_prop_check");
		properties.list(new PrintStream(os));
		OutputStream os1=new ByteArrayOutputStream();
		properties.list(new PrintStream(os1));
		ByteArrayOutputStream bos=(ByteArrayOutputStream)os1;
		byte[] bb=bos.toByteArray();
		ByteArrayInputStream bis=new ByteArrayInputStream(bb);
		PropertyResourceBundle prb=new PropertyResourceBundle(bis);
		String key=prb.getString("SELECT.HRGT_EPISODE_DTL.EMG_EPISODE.RETRIEVE_BY_CRNO");
		System.out.println("key------  "+key);*/
		return rb;
	}

	public static List getAlOfEntryObjects(ResultSet rs) throws SQLException
	{
		rs.beforeFirst();
		List alRecord = new ArrayList();
		ResultSetMetaData rsmd = rs.getMetaData();
		rs.beforeFirst();
		//System.out.println("hi...." + rsmd.getColumnCount());
		if (rsmd.getColumnCount() > 1)
		{
			while (rs.next())
			{
				Entry objEntry = new Entry();
				objEntry.setLabel(rs.getString(2));
				objEntry.setValue(rs.getString(1));
				//System.out.println("Entry: " + objEntry);
				alRecord.add(objEntry);
			}
		}
		else
		{
			while (rs.next())
			{
				Entry objEntry = new Entry();
				objEntry.setLabel(rs.getString(1));
				objEntry.setValue(rs.getString(1));
				//System.out.println("Entry: " + objEntry);
				alRecord.add(objEntry);
			}
		}
		return alRecord;
	}

	public static List getAlOfEntryObjectsCallable(ResultSet rs) throws SQLException
	{
		// rs.beforeFirst();
		List alRecord = new ArrayList();
		ResultSetMetaData rsmd = rs.getMetaData();
		//  rs.beforeFirst();
		//System.out.println("hi...." + rsmd.getColumnCount());
		if (rsmd.getColumnCount() > 1)
		{
			while (rs.next())
			{
				Entry objEntry = new Entry();
				objEntry.setLabel(rs.getString(2));
				objEntry.setValue(rs.getString(1));
				//System.out.println("Entry: " + objEntry);
				alRecord.add(objEntry);
			}
		}
		else
		{
			while (rs.next())
			{
				Entry objEntry = new Entry();
				objEntry.setLabel(rs.getString(1));
				objEntry.setValue(rs.getString(1));
				//System.out.println("Entry: " + objEntry);
				alRecord.add(objEntry);
			}
		}
		return alRecord;
	}

	public static List getAlOfResultSet(ResultSet rs) throws SQLException
	{
		rs.beforeFirst();
		List alRecord = new ArrayList();
		ResultSetMetaData rsmd = rs.getMetaData();
		rs.beforeFirst();
		//System.out.println("hi...." + rsmd.getColumnCount());
		while (rs.next())
		{
			for (int i = 1; i <= rsmd.getColumnCount(); i++)
				alRecord.add(rs.getString(i));
			/*Entry objEntry=new Entry();
			objEntry.setLabel(rs.getString(2));
			objEntry.setValue(rs.getString(1));
			System.out.println("Entry: "+objEntry);
			alRecord.add(objEntry);*/
		}
		return alRecord;
	}

	public static List getAllOfResultSetAsListColumnWise(ResultSet rs) throws SQLException
	{
		rs.beforeFirst();
		List outerList = new ArrayList();
		ResultSetMetaData rsmd = rs.getMetaData();
		rs.beforeFirst();
		//System.out.println("hi...." + rsmd.getColumnCount());
		int col = 0;
		while (rs.next())
		{
			List alRecord = new ArrayList();
			for (int i = 1; i <= rsmd.getColumnCount(); i++)
				alRecord.add(rs.getString(i));
			outerList.add(col, alRecord);
			col++;
			/*Entry objEntry=new Entry();
			objEntry.setLabel(rs.getString(2));
			objEntry.setValue(rs.getString(1));
			System.out.println("Entry: "+objEntry);
			alRecord.add(objEntry);*/
		}
		return outerList;
	}

	public static String getQuery(String _filename, String _queryKey) throws Exception
	{
		ResourceBundle rb = loadPropertiesFile(_filename);
		System.out.println("_queryKey" + _queryKey);
		String query = rb.getString(_queryKey);
		//System.out.println("query in getQuery(String _filename,String _queryKey):: " + query);
		return query;
	}
    /* 
	public static ResultSet executeQuery(Connection _conn, String _query) throws Exception
	{
		ResultSet rs = null;
		Statement st = null;
		System.out.println("Query :: "+_query);
		
		st = _conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = st.executeQuery(_query);
		
		//System.out.println("inside execute() of class HelperMethodsDAO");
		return rs;
	}
	*/
	/*
	 * Add By Amit Kumar on Date 24-Jul-2024
	 * To Avoid DB Memory Leakage
	 * Above OLD code is Commented
	 * */
	public static WebRowSet	executeQuery(Connection _conn, String _query)	throws Exception
	{
		WebRowSet ws = null;
		ResultSet rs = null;
		Statement st = null;
	
		try 
		{
		st = _conn.createStatement();
		rs = st.executeQuery(_query);
	
		ws = new WebRowSetImpl();
		ws.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
		ws.populate(rs);
		} 
		catch (Exception e) 
		{ 
			throw e; 
		}
		finally 
		{
			if(rs != null) 
			{
				rs.close();
				rs = null;
			}
			if(st != null) 
			{
				st.close();
				st = null;
			}
		}
		return ws;
	}


	public static ResultSet executeQuery(Connection _conn, String _query, Map _populateMap) throws Exception
	{
		ResultSet rs = null;
		//rs.TYPE_SCROLL_SENSITIVE;
		PreparedStatement pst = null;
		pst = _conn.prepareStatement(_query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		//System.out.println("inside executeQuery() of class HelperMethodsDAO");
		//System.out.println("size of map::" + _populateMap.size());
		StringBuffer stb = new StringBuffer(_query);
		Set set = _populateMap.keySet();
		//System.out.println("sd2");
		Iterator itr = set.iterator();
		//System.out.println("ww2");
		System.out.println("size of map::" + _populateMap.size());
		java.util.ArrayList al = new java.util.ArrayList();
		for (int i = 0; i < set.size(); i++)
		{
			al.add(null);
		}
		//int i=1;
		while (itr.hasNext())
		{
			//System.out.println("SDSDsdd");
			Integer objKey = (Integer) itr.next();
			//objKey.getClass();
			//System.out.println("SDSDsdd");
			String val = (String) _populateMap.get(objKey);
			//System.out.println("SDSDsdd1");
			//System.out.println("[" + objKey.intValue() + ", " + val + "]");

			if(val==null || val.trim().equals("")) // Added By Pragya
				pst.setNull(objKey.intValue(), Types.NULL);
			else
				pst.setString(objKey.intValue(), val);
			//pst.setString(objKey.intValue(), val);
			al.set(objKey.intValue() - 1, val); //<><<<<<<<
			//i++;	
		}

		String[] value = new String[]
		{};
		value = (String[]) al.toArray(value);
		for (int i = 0; i < value.length; i++)
		{
			//System.out.println("value["+i+"]"+value[i]);
			int x = stb.indexOf("?");
			if (value[i] == null) stb.replace(x, x + 1, "null");
			else if (value[i].equals("")) stb.replace(x, x + 1, "\' \'");
			else stb.replace(x, x + 1, value[i]);

		}
		System.out.println("stb....  " + stb);

		//System.out.println("al:   +   " + al); //<><<<<<<
		//System.out.println("after setting values for prepare st. in class helpermethodsDAo");
		try{
		rs = pst.executeQuery();
		}catch(Exception e){
		e.printStackTrace();
		}
		//System.out.println("after executing query");
		return rs;
	}

	public static int excecuteUpdate(Connection _conn, String _query, Map _populateMap) throws SQLException
	{
		PreparedStatement pst = null;
		//System.out.println("_conn:   +   " + _conn);
		System.out.println("_query:   +   " + _query);
		//System.out.println("_populateMap:   +   " + _populateMap);

		pst = _conn.prepareStatement(_query);
		//System.out.println("inside excecuteUpdate() of class HelperMethodsDAO");
		//System.out.println("size of map::" + _populateMap.size());
		Set set = _populateMap.keySet();
		Iterator itr = set.iterator();
		java.util.ArrayList al = new java.util.ArrayList(); //<><<<<<<<
		for (int i = 0; i < set.size(); i++)
		{
			al.add(null);
		}
		//int i=1;
		// pst.setString(1,"1");
		//pst.setString(2,"2");
		//pst.setString(3,"1");
		///<<<<<<<
		// pst.setString(4,"03-May-2006");
		StringBuffer stb = new StringBuffer(_query);
		while (itr.hasNext())
		{
			Integer objKey = (Integer) itr.next();
			//objKey.getClass();
			//System.out.println();		
			String val = (String) _populateMap.get(objKey);
			//System.out.println("[" + objKey.intValue() + ", " + val + "]");
			if(val==null || val.trim().equals("")) // Added By Pragya
				pst.setNull(objKey.intValue(), Types.NULL);
			else
				pst.setString(objKey.intValue(), val);
			al.set(objKey.intValue() - 1, val); //<><<<<<<<
			/*int x=objKey.intValue();
			//int x=stb.indexOf("?");
			stb.replace(x,x+1,val);*/
			//i++;	
		}
		//System.out.println("al:   +   " + al); //<><<<<<<
		String[] value = new String[]
		{};
		value = (String[]) al.toArray(value);
		for (int i = 0; i < value.length; i++)
		{
			//System.out.println("value["+i+"]"+value[i]);
			int x = stb.indexOf("?");
			if (value[i] == null) stb.replace(x, x + 1, "null");
			else if (value[i].equals("")) stb.replace(x, x + 1, "\' \'");
			else stb.replace(x, x + 1, value[i]);

		}
		System.out.println("stb....  " + stb);
		//System.out.println("al:   +   " + al); //<><<<<<<
		//System.out.println("after setting values for prepare st. in class helpermethodsDAo");

		return pst.executeUpdate();
	}

	public static int excecuteUpdateForMasters(Connection _conn, String _query) throws SQLException
	{
		Statement st = null;
		//System.out.println("_conn:   +   " + _conn);
		System.out.println("_query:   +   " + _query);
		st = _conn.createStatement();
		int num = st.executeUpdate(_query);
		return num;
	}
	
	
	/*
	 * Added By Pawan Kumar B N on 16-05-2012
	 */
	public static StringBuffer populateQuery(StringBuffer query_p, List<String> lstParams_p) {
		for (String param : lstParams_p)
		{
			int x = query_p.indexOf("?");
			if (param == null) query_p.replace(x, x + 1, "null");
			else if (param.equals("")) query_p.replace(x, x + 1, "\' \'");
			else query_p.replace(x, x + 1, param);
		}
		//System.out.println("strBuff....  " + strBuff);
		return query_p;
	}
}
