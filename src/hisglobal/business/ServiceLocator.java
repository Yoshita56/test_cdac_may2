package hisglobal.business;

import hisglobal.exceptions.ServiceLocatorException;

import java.util.*;
import java.sql.*;
import javax.sql.DataSource;
import javax.naming.*;


public class ServiceLocator
{
	private static ServiceLocator serviceLocatorRef = null;
	//hashtables for keeping the instances of JNDI Returned object
	private static Hashtable ejbHomeCache = null;
	private static Hashtable dataSourceCache = null;
	private static Hashtable queueConnectionFactoryCache = null;
	private static Hashtable queueCache = null;
	private static Hashtable ejbLocalHomeCache = null;
	private static final String prefixLookUpStr = "java:comp/env/";// for eclipse
	//private static final String prefixLookUpStr = "";//for WAS

	/*CONSTRUCTOR FOR THE SERVICELOCATOR*/
	private ServiceLocator()
	{
		ejbHomeCache = new Hashtable();
		ejbLocalHomeCache = new Hashtable();
		dataSourceCache = new Hashtable();
		queueConnectionFactoryCache = new Hashtable();
		queueCache = new Hashtable();
	}

	/*
	 * The ServiceLocator is implemented as a Singleton.  The getInstance()
	 * method will return the static reference to the ServiceLocator stored
	 * inside of the ServiceLocator Class.
	 */
	public static ServiceLocator getInstance()
	{
		System.out.println();
		if (serviceLocatorRef == null)
		{
			serviceLocatorRef = new ServiceLocator();
		}
		return serviceLocatorRef;
	}

	/*
	 * This method will be used to create a look uo for 
	   enterprise java bean using cache 
	 */
	/* public EJBHome getEjbHome(int serviceId){
	      EJBHome ejbHome=null;
	      
	      //get respected JNDI NAME
	      String serviceName= JNDI_NAME[serviceId];
	      
	      // get respected EJB HOME reference Class Instance
	      Class  ejbHomeRef  = EJBHOME_CLASSREF[serviceId];
	      
	     try{
	           //Check whether the requested Service's instance is in cache
	           if(ejbHomeCache.contains(serviceName))
	                   ejbHome=  (EJBHome) ejbHomeCache.get(serviceName) ;     
	           else{
	                 // LookUp for the Service
	                  Context ctx= new InitialContext();
	                  Object jndiRef = ctx.lookup(serviceName);
	                  
	                  //narrow the jndiRef to a protableRemoteObject
	                  Object portRemoteObj= PortableRemoteObject.narrow(jndiRef,ejbHomeRef);
	                  ejbHome = (EJBHome) portRemoteObj;
	                
	                  //PUt the ejbHome in the
	                  ejbHomeCache.put(serviceName, ejbHome);
	            }
	     }catch(NamingException e){
	         throw new ServiceLocatorException("Naming exception has occured in ServiceLocator.getEjbHome: \n"+e); 
	     }catch(Exception e){
	         throw new ServiceLocatorException(" Exception has occured in ServiceLocator.getEjbHome: \n"+e);
	     }
	     return  ejbHome; 
	 }*/
	/*
	 * This method will be used to create a database connection.It also keeps a cache to
	 *    minimize the look ups
	 */
	public Connection getDBConn(int serviceId) throws Exception
	{

		//System.out.println("inside getDb connection");
		Connection conn = null;
		//System.out.println("serviceId" + serviceId);
		//get respected JNDI NAME
		String seviceName = JNDI_NAME[serviceId];
		Properties props = new Properties();
		//props.put("INITIAL_CONTEXT_FACTORY", "com.pramati.naming.client.PramatiClientContextFactory");

		try
		{
			//Check if this datasource is there in the cache
			if (dataSourceCache.contains(seviceName))
			{
				//System.out.println("seviceName" + seviceName);
				DataSource ds = (DataSource) dataSourceCache.get(seviceName);
				//System.out.println("ds" + ds);
				conn = ds.getConnection();

			}
			else
			{
				Context ctx = new InitialContext(props);
				//System.out.println("ctx" + ctx);
				//System.out.println("seviceName" + seviceName);
				DataSource newDS = (DataSource) ctx.lookup(prefixLookUpStr + seviceName);
				//System.out.println("newDS" + newDS);
				// System.out.println("after connection");
				dataSourceCache.put(seviceName, newDS);
				//System.out.println("dataSourceCache" + dataSourceCache);
				conn = newDS.getConnection();
			}
		}
		catch (SQLException e)
		{
			throw new ServiceLocatorException("A sql Exception has occured: \n" + e);
		}
		catch (NamingException e)
		{
			e.printStackTrace();
			throw new ServiceLocatorException("naming Exception has occured: \n" + e);

		}
		catch (Exception e)
		{
			throw new ServiceLocatorException("An Exception has occured: \n" + e);
		}

		return conn;
	}

	//SERVICES AVAILABLE FROM SERVICE LOCATOR
	public static final int AHIS = 0;
	public static final int OLD = 1;
	public static final int AYUSH = 4;
	public static final int PATIENTSB = 2;
	public static final int ESSENTIALSSB = 3;
	//public static final int AHSI_RAO=3;

	//JNDI NAME USED TO LOOK UP A SERVICE
	//protected static String[] JNDI_NAME =
	//{ "jdbc/ahis", "AHIS_RAO", "EJB_PATIENTSB", "EJB_ESSENTIALSSB", "AYUSH"};
	protected static String[] JNDI_NAME =
	{ "AHIS", "AHIS_RAO", "EJB_PATIENTSB", "EJB_ESSENTIALSSB", "AYUSH"};

	//REFERENCE TO DIFFERENT EJB HOME INTERFACES
	/*protected static Class[] EJBHOME_CLASSREF={
	                                       null,
	                                       PatientSBHome.class,
	                                       EssentialsSBHome.class
	                                  };*/

}
