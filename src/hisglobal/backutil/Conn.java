/*
 Project		:	HIS
 FileName	:	Conn.java file
 Version		:	1.0
 Developer	:	HIS Team
 */

/*
 FUNCTIONS DEFINED IN THIS CLASS FILE

 1>	makeConnection
 2>	ResultSet getRecord(String query)
 2.1>ResultSet getRecord(String query, boolean flag)	
 3>	boolean updateRecord(String query)
 4>	PreparedStatement createPrepStatement(String query)
 5>	boolean executePrepStatement(PreparedStatement ps)
 6>  SQLManager getSqlManager() throws SQLException
 7>		

 Note --> serverName/userName/Password defined in poolman.props file whose path 
 is c:\PStudio30\server\lib\pramati
 */

package hisglobal.backutil;

import java.sql.ResultSet;
import javax.naming.*;
import javax.sql.*;
import java.sql.*;
import java.util.Properties;

public final class Conn
{

	private Connection conn;
	private boolean connOpen = false;
	public static int openConnection = 0;
	public static int closeConnection = 0;
	private static final String prefixLookUpStr = "java:comp/env/";//for eclipse
	//private static final String prefixLookUpStr = "";//for WAS

	private Conn()
	{
		//Written For making Class as non instatiable
	}

	public static Conn getInstance()
	{
		return new Conn();
	}

	public synchronized Connection getConnection() throws SQLException
	{
		try
		{
			Context ic = new InitialContext();
			//DataSource ds	= (DataSource)ic.lookup("AHIS_CONN");
			//DataSource ds = (DataSource) ic.lookup(prefixLookUpStr + "jdbc/ahis");
		
			DataSource ds = (DataSource) ic.lookup(prefixLookUpStr + "AHIS");
			//DataSource ds = (DataSource) ic.lookup(prefixLookUpStr + "AYUSH");
			conn = ds.getConnection();

			connOpen = true;
			this.openConnection++;
			//System.out.println("At Open time HISGLOBAL Open/Close Connection "+this.openConnection+"/"+this.closeConnection);
		}
		catch (Exception e)
		{
			System.out.println("Error in Connection with Error :\n" + e);
		}
		return conn;
	}

	public synchronized boolean makeConnection() throws SQLException
	{
		boolean retValue;
		connOpen = false;
		try
		{
			Context ic = new InitialContext();
			//DataSource ds	= (DataSource)ic.lookup("AHIS_CONN");
			DataSource ds = (DataSource) ic.lookup(prefixLookUpStr + "AHIS");
			
		//DataSource ds = (DataSource) ic.lookup(prefixLookUpStr + "jdbc/ahis");
			conn = ds.getConnection();
			connOpen = true;
			retValue = true;
			this.openConnection++;
			//System.out.println("At Open time HISGLOBAL Open/Close Connection "+this.openConnection+"/"+this.closeConnection);
		}
		catch (Exception e)
		{
			System.out.println("Error in Connection with Error :\n" + e);
			retValue = false;
		}
		return retValue;
	}//1

	public synchronized HisResultSet getRecord(String query) throws SQLException
	{
		ResultSet rs = null;
		Statement st = null;
		HisResultSet hrs = HisResultSet.getInstance();

		if (makeConnection()) //Calling Internal function
		{
			try
			{
				st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				rs = st.executeQuery(query);

				if (rs == null) throw new Exception("rs is null"); // piyush
				/*	return hrs;*/

				ResultSetMetaData rsmd = rs.getMetaData();
				hrs.setMetaData(rsmd);
				int noOfColumn = rsmd.getColumnCount();

				String[] recordRow = new String[noOfColumn];

				while (rs.next())
				{
					int i = 1;
					while (i <= noOfColumn)
					{
						//recordRow[i-1] = ( (rs.getString(i) == null)?"":rs.getString(i).trim() );	//comment by Ajay Gupta
						recordRow[i - 1] = rs.getString(i);
						i++;
					}
					hrs.put(recordRow);
					recordRow = new String[noOfColumn];
				}
				rs.close();
			}
			catch (Exception e)
			{
				System.out.println("Error in fetching record with Error :\n" + e + " \n" + query);
				e.printStackTrace();
			}
			finally
			{
				st.close();
				try
				{
					this.closeConnection();
				}
				catch (Exception e)
				{
					System.out.println("Exception at Closing Connection in getRecord " + e);
				}
			}
		}
		return hrs;
	}//2

	public synchronized HisResultSet getRecord(String query, boolean dummy) throws SQLException
	{
		ResultSet rs = null;
		Statement st = null;
		HisResultSet hrs = HisResultSet.getInstance();

		if (makeConnection()) //Calling Internal function
		{
			try
			{
				st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				rs = st.executeQuery(query);

				if (rs == null) throw new Exception("rs is null"); // piyush
				/*	return hrs;*/

				ResultSetMetaData rsmd = rs.getMetaData();
				hrs.setMetaData(rsmd);
				int noOfColumn = rsmd.getColumnCount();

				String[] recordRow = new String[noOfColumn];

				while (rs.next())
				{
					int i = 1;
					while (i <= noOfColumn)
					{
						recordRow[i - 1] = ((rs.getString(i) == null) ? "" : rs.getString(i).trim());
						//recordRow[i-1] = rs.getString(i); 
						i++;
					}
					hrs.put(recordRow);
					recordRow = new String[noOfColumn];
				}
				rs.close();
			}
			catch (Exception e)
			{
				System.out.println("Error in fetching record with Error :\n" + e + " \n" + query);
				e.printStackTrace();
			}
			finally
			{
				st.close();
				try
				{
					this.closeConnection();
				}
				catch (Exception e)
				{
					System.out.println("Exception at Closing Connection in getRecord " + e);
				}
			}
		}
		return hrs;
	}//2

	public synchronized boolean updateRecord(String query) throws SQLException
	{
		boolean retValue = false;

		if (makeConnection()) //Calling Internal function
		{
			try
			{
				Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				int num = st.executeUpdate(query);
				conn.commit();
				st.close();
				closeConnection(); //return connection to connection pool
				retValue = true;
			}
			catch (Exception e)
			{
				System.out.println("Error in query with Error :\n" + e);
			}
		}
		return retValue;
	}//3

	public synchronized PreparedStatement createPrepStatement(String query) throws SQLException
	{
		PreparedStatement ps = null;

		if (makeConnection()) //Calling Internal function
		{
			try
			{
				ps = conn.prepareStatement(query);
			}
			catch (Exception e)
			{
				System.out.println("Error in PrepareStatement with Error :\n" + e);
			}
		}

		return ps;
	}//4

	public synchronized boolean executePrepStatement(PreparedStatement ps) throws SQLException
	{
		boolean retValue = false;

		try
		{
			ps.execute();
			retValue = true;
		}
		catch (Exception e)
		{
			System.out.println("Error in excuting prepared statement with Error:\n" + e);
		}
		return retValue;
	}//5

	public synchronized void closeConnection() throws Exception
	{
		conn.close();
		connOpen = false;

		this.closeConnection++;
		//System.out.println("At Close time HISGLOBAL Open/Close Connection "+this.openConnection+"/"+this.closeConnection);
	}

	public synchronized void closeConnection(Connection conObj) throws Exception
	{
		conObj.close();
		connOpen = false;

		this.closeConnection++;
		//System.out.println("At Close time HISGLOBAL Open/Close Connection "+this.openConnection+"/"+this.closeConnection);

	}
	public static String getDatabaseConnection() {
		String url="";
		Properties props=new Properties();
		Context ctx;
		try {
			ctx = new InitialContext(props);
		
		System.out.println("ctx" + ctx);
		
		//DataSource newDS = (DataSource) ctx.lookup(prefixLookUpStr + "jdbc/ahis");
		//DataSource newDS = (DataSource) ctx.lookup(prefixLookUpStr + "ahis");
		DataSource newDS = (DataSource) ctx.lookup(prefixLookUpStr + "AHIS");
		System.out.println("newDS" + newDS);
		
		Connection conn = newDS.getConnection();
		url=conn.getMetaData().getURL();
		System.out.println("url  == "+url);
		conn.close();
		
		} catch (NamingException e) {
		
			e.printStackTrace();
		}catch (SQLException e) {
		
			e.printStackTrace();
		}
		return url;
	}
}//conn class

