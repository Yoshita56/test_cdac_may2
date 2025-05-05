package hisglobal.backutil;


import hisglobal.backutil.exception.DataNotFoundException;
import hisglobal.backutil.exception.EstateException;
import hisglobal.backutil.exception.GlobalException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommonDataBaseManip {
	public static synchronized boolean insertData(String query,List dataList) throws GlobalException
	{
		boolean result = false;
		PreparedStatement ps = null;
		Connection conn 	 = null;
		try
		{
			conn = getConnection();
			//conn.setAutoCommit(false);
			ps = conn.prepareStatement(query);
			for(int i=0;i<dataList.size();i++)
			{
				ps.setString(i+1,String.valueOf(dataList.get(i)));
			}
			result = ps.execute();
			 //conn.commit();
			//  conn.setAutoCommit(true);

		}
		catch(SQLException e)
		{
				throw new GlobalException("hisglobal.backutil.CommonDataManip.insertData():"+e.getMessage());
		}
		catch(GlobalException e)
		{
				throw new GlobalException("hisglobal.backutil.CommonDataManip.insertData():"+e.getMessage());
		}
		catch(Exception e)
		{
				throw new GlobalException("hisglobal.backutil.CommonDataManip.insertData():"+e.getMessage());
		}
		finally
		{
				try
				{
					ps.close();
					closeConnection(conn);
				}
				catch(SQLException e)
				{
						throw new GlobalException("hisglobal.backutil.CommonDataManip.insertData():"+e.getMessage());
				}
				catch(GlobalException e)
				{
						throw new GlobalException("hisglobal.backutil.CommonDataManip.insertData():"+e.getMessage());
				}
				catch(Exception e)
				{
						throw new GlobalException("hisglobal.backutil.CommonDataManip.insertData():"+e.getMessage());
				}

		}

		return result;
	}

	public static synchronized List getDetail(String query)throws DataNotFoundException,GlobalException
	{

		List resultList = new ArrayList();
		Connection conn 	 = null;
		Statement st		 = null;
		try
		{
			conn = getConnection();
			st	 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		    ResultSet rs = st.executeQuery(query);

		    if(rs==null)
		    	throw new DataNotFoundException("hisglobal.backutil.CommonDataManip.getDetail():ResultSet is Null");
		    ResultSetMetaData rsmd 	= rs.getMetaData();
			int noOfColumn 			= rsmd.getColumnCount();

			while(rs.next())
			{
				int i=1;
				while( i <= noOfColumn )
				{
					resultList.add((rs.getString(i) == null)?"":rs.getString(i).trim());
					i++;
				}
			}

			rs.close();
		}
		catch(Exception e)
		{

		}
		finally
		{
			try
			{	st.close();
				closeConnection(conn);
			}
			catch(SQLException e)
			{
					throw new GlobalException("hisglobal.backutil.CommonDataManip.getDetail():"+e.getMessage());
			}
			catch(GlobalException e)
			{
					throw new GlobalException("hisglobal.backutil.CommonDataManip.getDetail():"+e.getMessage());
			}
			catch(Exception e)
			{
					throw new GlobalException("hisglobal.backutil.CommonDataManip.getDetail():"+e.getMessage());
			}
		}

		return resultList;

	}


	public static synchronized ResultSet getResultSet(String query)throws DataNotFoundException,GlobalException
	{

		Connection conn 	 = null;
		Statement st		 = null;
		ResultSet rs		 = null;
		try
		{
			conn = getConnection();
			st	 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		    rs = st.executeQuery(query);

		    if(rs==null)
		    	throw new DataNotFoundException("hisglobal.backutil.CommonDataManip.getDetail():ResultSet is Null");

		}
		catch(Exception e)
		{

		}
		finally
		{
			try
			{	st.close();
				closeConnection(conn);
			}
			catch(SQLException e)
			{
					throw new GlobalException("hisglobal.backutil.CommonDataManip.getDetail():"+e.getMessage());
			}
			catch(GlobalException e)
			{
					throw new GlobalException("hisglobal.backutil.CommonDataManip.getDetail():"+e.getMessage());
			}
			catch(Exception e)
			{
					throw new GlobalException("hisglobal.backutil.CommonDataManip.getDetail():"+e.getMessage());
			}
		}

		return rs;

	}






	public static synchronized List getDetail(String query,List dataList) throws GlobalException,DataNotFoundException
	{
		List resultList = new ArrayList();
		PreparedStatement ps = null;
		Connection conn 	 = null;

		try
		{
			conn = getConnection();
			//conn.setAutoCommit(false);
			ps = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			for(int i=0;i<dataList.size();i++)
			{
				ps.setString(i+1,String.valueOf(dataList.get(i)));
			}
			ResultSet resultSet = ps.executeQuery();

			if(resultSet==null)
		    	throw new DataNotFoundException("hisglobal.backutil.CommonDataManip.getDetail():ResultSet is Null");

			ResultSetMetaData rsmd 	= resultSet.getMetaData();
			int noOfColumn 			= rsmd.getColumnCount();

			while(resultSet.next())
			{
				int i=1;
				while( i <= noOfColumn )
				{
					resultList.add( (resultSet.getString(i) == null)?"":resultSet.getString(i).trim());
					i++;
				}
			}

			//myMan.returnConnection(conn1);
			resultSet.close();
		}
		catch(SQLException e)
		{
				throw new GlobalException("hisglobal.backutil.CommonDataManip.getDetail():"+e.getMessage());
		}
		catch(GlobalException e)
		{
				throw new GlobalException("hisglobal.backutil.CommonDataManip.getDetail():"+e.getMessage());
		}
		catch(Exception e)
		{
				throw new GlobalException("hisglobal.backutil.CommonDataManip.getDetail():"+e.getMessage());
		}
		finally
		{
				try
				{
					ps.close();
					closeConnection(conn);
				}
				catch(SQLException e)
				{
						throw new GlobalException("hisglobal.backutil.CommonDataManip.getDetail():"+e.getMessage());
				}
				catch(GlobalException e)
				{
						throw new GlobalException("hisglobal.backutil.CommonDataManip.getDetail():"+e.getMessage());
				}
				catch(Exception e)
				{
						throw new GlobalException("hisglobal.backutil.CommonDataManip.getDetail():"+e.getMessage());
				}

		}
		return resultList;
	}


	public static synchronized ResultSet getResultSet(String query,List dataList) throws GlobalException,DataNotFoundException
	{
		PreparedStatement ps = null;
		Connection conn 	 = null;
		ResultSet resultSet	 = null;
		try
		{
			conn = getConnection();
			//conn.setAutoCommit(false);
			ps = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			for(int i=0;i<dataList.size();i++)
			{
				ps.setString(i+1,String.valueOf(dataList.get(i)));
			}
			resultSet = ps.executeQuery();

			if(resultSet==null)
		    	throw new DataNotFoundException("hisglobal.backutil.CommonDataManip.getDetail():ResultSet is Null");

		}
		catch(SQLException e)
		{
				throw new GlobalException("hisglobal.backutil.CommonDataManip.getDetail():"+e.getMessage());
		}
		catch(GlobalException e)
		{
				throw new GlobalException("hisglobal.backutil.CommonDataManip.getDetail():"+e.getMessage());
		}
		catch(Exception e)
		{
				throw new GlobalException("hisglobal.backutil.CommonDataManip.getDetail():"+e.getMessage());
		}
		finally
		{
				try
				{
					ps.close();
					closeConnection(conn);
				}
				catch(SQLException e)
				{
						throw new GlobalException("hisglobal.backutil.CommonDataManip.getDetail():"+e.getMessage());
				}
				catch(GlobalException e)
				{
						throw new GlobalException("hisglobal.backutil.CommonDataManip.getDetail():"+e.getMessage());
				}
				catch(Exception e)
				{
						throw new GlobalException("hisglobal.backutil.CommonDataManip.getDetail():"+e.getMessage());
				}

		}
		return resultSet;
	}





	public static synchronized String getNextKey(String query)throws GlobalException
	{

		String nextKey	="1";
		Connection conn 	 = null;
		Statement st		 = null;
		try
		{
			conn = getConnection();
			st	 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		    ResultSet rs = st.executeQuery(query);

		    if(rs==null)
		    	nextKey = "1";

			if(rs.next())
			{
				nextKey = ((rs.getString(1) == null)?"1": String.valueOf( Integer.parseInt(rs.getString(1))+1));
			}

			rs.close();
		}
		catch(SQLException e)
		{
				throw new GlobalException("hisglobal.backutil.CommonDataManip.getNextKey():"+e.getMessage());
		}
		catch(GlobalException e)
		{
				throw new GlobalException("hisglobal.backutil.CommonDataManip.getNextKey():"+e.getMessage());
		}
		catch(Exception e)
		{
				throw new GlobalException("hisglobal.backutil.CommonDataManip.getNextKey():"+e.getMessage());
		}
		finally
		{
			try
			{	st.close();
				closeConnection(conn);
			}
			catch(SQLException e)
			{
					throw new GlobalException("hisglobal.backutil.CommonDataManip.getPrimaryKey():"+e.getMessage());
			}
			catch(GlobalException e)
			{
					throw new GlobalException("hisglobal.backutil.CommonDataManip.getPrimaryKey():"+e.getMessage());
			}
			catch(Exception e)
			{
					throw new GlobalException("hisglobal.backutil.CommonDataManip.getPrimaryKey():"+e.getMessage());
			}
		}

		return nextKey;

	}


	//Getting Connection From Conn for multiple update
	public static synchronized Connection getConnection() throws GlobalException
	{
		Connection conn = null;
		try
		{
			Conn conObj = Conn.getInstance();
			conn = conObj.getConnection();

		}
		catch(SQLException e)
		{
			throw new GlobalException("hisglobal.backutil.CommonDataManip.getConnection():"+e.getMessage());
		}
		catch(Exception e)
		{
			throw new GlobalException("hisglobal.backutil.CommonDataManip.getConnection():"+e.getMessage());
		}
		return conn;
	}

	//	Closing the Connection
	public static synchronized void closeConnection(Connection connection) throws GlobalException
	{
		try
		{
			if(connection == null)
				throw new GlobalException("hisglobal.backutil.CommonDataManip.closeConnection():Invalide Argument:Connection==null");
			connection.close();
		}
		catch(SQLException e)
		{
			throw new GlobalException("hisglobal.backutil.CommonDataManip.getConnection():"+e.getMessage());
		}
		catch(Exception e)
		{
			throw new GlobalException("hisglobal.backutil.CommonDataManip.getConnection():"+e.getMessage());
		}
	}

	public static synchronized List getComboList(String query)  throws GlobalException
	{
		List comboList = new ArrayList();
		Connection conn 	 = null;
		Statement st		 = null;

		//HisResultSet rs = null;
		comboList.add(new HisCombo("-1","Select Value"));
		try
		{
			conn = getConnection();
			st	 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			System.out.println("query===="+query);
			ResultSet rs = st.executeQuery(query);

 			//rs = Conn.getInstance().getRecord(query);

 			while(rs.next())
			{
				comboList.add(new HisCombo(rs.getString(1),rs.getString(2)));
			}
 			rs.close();
 			rs=null;
		}
		catch(SQLException e)
		{
			throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboList():"+e.getMessage());
		}
		catch(Exception e)
		{
			throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboList():"+e.getMessage());
		}
		finally
		{
			try
			{
				st.close();
				closeConnection(conn);
				st=null;
				conn = null;
			}
			catch(SQLException e)
			{
					throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboList():"+e.getMessage());
			}
			catch(GlobalException e)
			{
					throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboList():"+e.getMessage());
			}
			catch(Exception e)
			{
					throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboList():"+e.getMessage());
			}

		}
		return comboList;
	}

	
	public static synchronized List getComboSingleValue(String query)  throws GlobalException
	{
		List comboList = new ArrayList();
		Connection conn 	 = null;
		Statement st		 = null;
		
		//HisResultSet rs = null;
		comboList.add(new HisCombo("-1","Select Value"));
		try
		{
			conn = getConnection();
			st	 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			//System.out.println("query===="+query);
			ResultSet rs = st.executeQuery(query);
		    
 			//rs = Conn.getInstance().getRecord(query);
			
 			while(rs.next())
			{	
				comboList.add(new HisCombo(rs.getString(1),rs.getString(1)));
			}
 			rs.close();
 			rs=null;
		}
		catch(SQLException e)
		{
			throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboSingleValue():"+e.getMessage());
		}
		catch(Exception e)
		{
			throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboSingleValue():"+e.getMessage());
		}
		finally
		{
			try
			{
				st.close();
				closeConnection(conn);
				st=null;
				conn = null;
			}
			catch(SQLException e)
			{
					throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboSingleValue():"+e.getMessage());
			}
			catch(GlobalException e)
			{
					throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboSingleValue():"+e.getMessage());
			}
			catch(Exception e)
			{
					throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboSingleValue():"+e.getMessage());
			}
					
		}
		return comboList;
	}
	
	public static synchronized List getComboList1(String query)  throws GlobalException
	{
		List comboList = new ArrayList();
		Connection conn 	 = null;
		Statement st		 = null;

		//HisResultSet rs = null;
		comboList.add(new HisCombo("-1","Select Value"));
		try
		{
			conn = getConnection();
			st	 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			System.out.println("query===="+query);
			ResultSet rs = st.executeQuery(query);

 			//rs = Conn.getInstance().getRecord(query);

 			while(rs.next())
			{
				comboList.add(new HisCombo(rs.getString(1),rs.getString(2)+ "-"+ rs.getString(3)+"-"+ rs.getString(4)));
			}
 			rs.close();
 			rs=null;
		}
		catch(SQLException e)
		{
			throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboList():"+e.getMessage());
		}
		catch(Exception e)
		{
			throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboList():"+e.getMessage());
		}
		finally
		{
			try
			{
				st.close();
				closeConnection(conn);
				st=null;
				conn = null;
			}
			catch(SQLException e)
			{
					throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboList():"+e.getMessage());
			}
			catch(GlobalException e)
			{
					throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboList():"+e.getMessage());
			}
			catch(Exception e)
			{
					throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboList():"+e.getMessage());
			}

		}
		return comboList;
	}

	public static synchronized List getComboList1(String query,List dataList) throws EstateException
	 {
	  List comboList = new ArrayList();
	  PreparedStatement ps = null;
	  Connection conn   = null;
	  String result=null;
	  
	  try 
	  { //comboList.add(new HisCombo("-1","Select Value"));
	   conn = getConnection();
	   //conn.setAutoCommit(false);
	   ps = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	   
	   for(int i=0;i<dataList.size();i++)
	   {
	    ps.setString(i+1,String.valueOf(dataList.get(i)));
	   }
	   
	   ResultSet resultSet = ps.executeQuery();
	   
	   
	   if(resultSet==null)
	       throw new DataNotFoundException("estate.global.CommonDataManip.getComboList():ResultSet is Null");
	      
	   /*ResultSetMetaData rsmd  = resultSet.getMetaData();
	   int noOfColumn    = rsmd.getColumnCount();
	   rsmd = null;*/
	   while(resultSet.next())
	   {
	    comboList.add(resultSet.getString(2));
	     
	     
	   }
	   
	 
	   //myMan.returnConnection(conn1);
	   resultSet.close();
	   resultSet =null;
	  }
	  catch(SQLException e)
	  {
	    throw new EstateException("estate.global.CommonDataManip.getComboList():"+e.getMessage());
	  }
	  catch(EstateException e)
	  {
	    throw new EstateException("estate.global.CommonDataManip.getComboList():"+e.getMessage());
	  }
	  catch(Exception e)
	  {
	    throw new EstateException("estate.global.CommonDataManip.getComboList():"+e.getMessage());
	  }
	  finally
	  {
	    try
	    {
	     ps.close();
	     closeConnection(conn);
	     ps =  null;
	     conn = null;
	    }
	    catch(SQLException e)
	    {
	      throw new EstateException("estate.global.CommonDataManip.getComboList():"+e.getMessage());
	    }
	    catch(EstateException e)
	    {
	      throw new EstateException("estate.global.CommonDataManip.getComboList():"+e.getMessage());
	    }
	    catch(Exception e)
	    {
	      throw new EstateException("estate.global.CommonDataManip.getComboList():"+e.getMessage());
	    }
	      
	  }  
	  //System.out.println("comboList==="+comboList);
	  return comboList ;
	 }
	
	public static synchronized List getComboList(String query,List dataList) throws GlobalException
	{
		List comboList = new ArrayList();
		PreparedStatement ps = null;
		Connection conn 	 = null;

		try
		{	comboList.add(new HisCombo("-1","Select Value"));
			conn = getConnection();
			//conn.setAutoCommit(false);
			ps = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			for(int i=0;i<dataList.size();i++)
			{
				ps.setString(i+1,String.valueOf(dataList.get(i)));
			}
			ResultSet resultSet = ps.executeQuery();

			if(resultSet==null)
		    	throw new DataNotFoundException("hisglobal.backutil.CommonDataManip.getComboList():ResultSet is Null");

			/*ResultSetMetaData rsmd 	= resultSet.getMetaData();
			int noOfColumn 			= rsmd.getColumnCount();
			rsmd = null;*/
			while(resultSet.next())
			{
					comboList.add(new HisCombo(resultSet.getString(1),resultSet.getString(2)));

			}

			//myMan.returnConnection(conn1);
			resultSet.close();
			resultSet =null;
		}
		catch(SQLException e)
		{
				throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboList():"+e.getMessage());
		}
		catch(GlobalException e)
		{
				throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboList():"+e.getMessage());
		}
		catch(Exception e)
		{
				throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboList():"+e.getMessage());
		}
		finally
		{
				try
				{
					ps.close();
					closeConnection(conn);
					ps =  null;
					conn = null;
				}
				catch(SQLException e)
				{
						throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboList():"+e.getMessage());
				}
				catch(GlobalException e)
				{
						throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboList():"+e.getMessage());
				}
				catch(Exception e)
				{
						throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboList():"+e.getMessage());
				}

		}
		//System.out.println("comboList==="+comboList);
		return comboList ;
	}




	public static synchronized List getComboList1(List dataList) throws GlobalException
	{
		List comboList = new ArrayList();
		PreparedStatement ps = null;
		Connection conn 	 = null;

		try
		{
			comboList.add(new HisCombo("-1","Select Value"));
			for(int i=0;i<dataList.size();i++)
			{
				ps.setString(i+1,String.valueOf(dataList.get(i)));
			}
			ResultSet resultSet = ps.executeQuery();

			if(resultSet==null)
		    	throw new DataNotFoundException("hisglobal.backutil.CommonDataManip.getComboList():ResultSet is Null");

			/*ResultSetMetaData rsmd 	= resultSet.getMetaData();
			int noOfColumn 			= rsmd.getColumnCount();
			rsmd = null;*/
			while(resultSet.next())
			{
					comboList.add(new HisCombo(resultSet.getString(1),resultSet.getString(2)));

			}

			//myMan.returnConnection(conn1);
			resultSet.close();
			resultSet =null;
		}
		catch(SQLException e)
		{
				throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboList():"+e.getMessage());
		}
		catch(GlobalException e)
		{
				throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboList():"+e.getMessage());
		}
		catch(Exception e)
		{
				throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboList():"+e.getMessage());
		}
		finally
		{
				try
				{
					ps.close();
					closeConnection(conn);
					ps =  null;
					conn = null;
				}
				catch(SQLException e)
				{
						throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboList():"+e.getMessage());
				}
				catch(GlobalException e)
				{
						throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboList():"+e.getMessage());
				}
				catch(Exception e)
				{
						throw new GlobalException("hisglobal.backutil.CommonDataManip.getComboList():"+e.getMessage());
				}

		}
		//System.out.println("comboList==="+comboList);
		return comboList ;
	}










}//End of class
