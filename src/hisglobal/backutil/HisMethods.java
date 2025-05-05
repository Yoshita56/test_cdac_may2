package hisglobal.backutil;

import java.sql.*;
import java.util.*;
import java.io.*;	//third party API





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
			conn.setAutoCommit(false);
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
		Statement st = conn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	    ResultSet rs = st.executeQuery(query);

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
	public synchronized List getDetail(String query , int column )throws Exception
	{
		int i=1;
		List AL_Detail = new ArrayList();

		Conn conObj	= Conn.getInstance();
		
		Connection conn1  = conObj.getConnection();
		Statement st = conn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	    ResultSet rs = st.executeQuery(query);

		ResultSetMetaData rsmd 	= rs.getMetaData();
		int noOfColumn 			= rsmd.getColumnCount();

		if (rs == null)
			return AL_Detail;
		
		//System.out.println("noOfColumn "+noOfColumn);
		while(rs.next())
		{
				AL_Detail.add((rs.getString(column) == null)?"":rs.getString(column).trim());
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
	
	private void putOpenMap()
	{
		/*String reference = this.getClass().getName();
		String data = (String)this.openMap.get(reference);

		if(data==null)
			this.openMap.put(reference,"1");
		else
			this.openMap.put(reference,(Integer.parseInt(data)+1)+"");*/
	}
	
	public boolean insertQuery(String query,List masterList)throws Exception
	{
		String status = "";
		PreparedStatement ps = null;
		Conn conObj	= Conn.getInstance();
		Connection conn =conObj.getConnection();
		status = "Record Succesfully Inserted !";
		boolean retValue=true;
		try
		{
			List temp=new ArrayList();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(query);
			for(int j=0;j<masterList.size();j++)
			{
				temp=(List)masterList.get(j);
				int k=0;
				for(int i=0;i<temp.size();i++)
				{
					k++;
					ps.setString(k,String.valueOf(temp.get(i)));
				}
				ps.execute();
			}
			  conn.commit();
			  conn.setAutoCommit(true);
			}
		catch(Exception e)
		{
			status = String.valueOf(e);
			System.out.println("Error While Inserting Record:"+e);
		}
		finally
		{
		   ps.close();
		   conn.close();
		}
		return  retValue;
	}
	
	public boolean updateQuery(String query,List masterList)throws Exception
	{
		String status = new String("Succesfully updated!");
		status = "Record Updated Successfully.";
		boolean retValue=true;
		Connection conn = getConnection();
		PreparedStatement ps = null;
		try
		{
			List temp=new ArrayList();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(query);
			 for(int j=0;j<masterList.size();j++)
				{

					temp=(List)masterList.get(j);
					int k=0;
					for(int i=0;i<temp.size();i++)
					{
						k++;
						ps.setString(k,String.valueOf(temp.get(i)));
					}
				  ps.execute();
				}

				  conn.commit();
				  conn.setAutoCommit(true);

			}
			catch(Exception e)
			{
				status = "Error While Updating Record: "+e;
				System.out.println(status);
			}
		  finally
		  {
		   ps.close();
		   conn.close();
		  }


		return retValue;
	}

	public String deleteQuery(String query,List masterList)throws Exception
	{
		 String status	=	"Successfully deleted !";
		Connection conn = getConnection();
		PreparedStatement ps = null;
		int counter = 0;
		try
		{
			List temp=null;
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(query);
			for(int j=0;j<masterList.size();j++)
			{
				temp=(List)masterList.get(j);
				int k=0;
				for(int i=0;i<temp.size();i++)
				{
					k++;
					ps.setString(k,String.valueOf(temp.get(i)));
				 }
				 ps.execute();
				 counter++;
			  }
			  conn.commit();
			  conn.setAutoCommit(true);
			  status = counter + " Record(s) Deleted Successfully.";
		   }
		   /* catch(Exception e)
				{
					return "Error while deleting selected record(s)";
				}
			}

			status = i + " Record(s) Deleted Successfully.";
		}*/

		catch(Exception e)
		{
			status = "Error in deleting Record(s): " + e;
			System.out.println(status);
		}
		finally
		{
			try
			{
				ps.close();
				conn.close();

			}
			catch(Exception e2)
			{
			}
		}


		return status;
	}
	
	private void putCloseMap()
	{		
		/*String reference = this.getClass().getName();		
		String data = (String)this.closeMap.get(reference);		
		if(data==null)
			this.closeMap.put(reference,"1");
		else
			this.closeMap.put(reference,(Integer.parseInt(data)+1)+"");*/					
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
	*/		
		/*else
			System.out.println("Open Arr "+openArr.length+" Close Arr "+closeArr.length);
		*/
		
	/*	try
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
	} 
	*/
	
}//end of class
