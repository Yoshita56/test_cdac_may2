package hisglobal.backutil;


/*
Developed By          : Partha P Chattaraj
Creation Dated        : 17-06-2006
Modification Dated    : 07-05-2008
Version               : HIMS 2.0

*/

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import hisglobal.backutil.exception.DataSourceException;
import hisglobal.backutil.exception.EstateException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
public class ServiceLocator {

	//public static String GLOBAL_XML_PATH1=null;
	//public static String GLOBAL_ESTATE_IMAGE_PATH1=null;
		
	private static final String conStr = "java:comp/env/AHIS";// for Eclipse
	//private static final String conStr = "";//for WAS
	private static DataSource dataSource = null;
	//public static String GLOBAL_XML_PATH="E:\\WORKPLACE\\AHIMS\\src\\hisglobal\\transactionmgmnt\\xmlTest";
	//public static final String GLOBAL_ESTATE_IMAGE_PATH="E:\\WORKPLACE\\AHIMS\\WebContent\\hr\\estate\\estateImages";
	
	public static String GLOBAL_XML_PATH=ServiceLocator.getXMLPath();
	public static final String GLOBAL_ESTATE_IMAGE_PATH=getImagePath();
	
	/*************************************************Estate Module******************************************************/
	 
	public static final String EST_XML_PATH=GLOBAL_XML_PATH+"\\buildingSchemaDAO.xml";
	public static final String EST_XML_PATH1=GLOBAL_XML_PATH+"\\blocktypeSchemaDAO.xml";
	public static final String EST_XML_PATH2=GLOBAL_XML_PATH+"\\blockSchemaDAO.xml";
	public static final String EST_XML_PATH3=GLOBAL_XML_PATH+"\\floorSchemaDAO.xml";
	public static final String EST_XML_PATH4=GLOBAL_XML_PATH+"\\landSchemaDAO.xml";
	public static final String EST_XML_PATH5=GLOBAL_XML_PATH+"\\roomtypeSchemaDAO.xml";
	public static final String EST_XML_PATH6=GLOBAL_XML_PATH+"\\roomSchemaDAO.xml";
	public static final String EST_XML_PATH7=GLOBAL_XML_PATH+"\\itemSchemaDAO.xml";
	public static final String EST_XML_PATH8=GLOBAL_XML_PATH+"\\shopSchemaDAO.xml";
	public static final String EST_XML_PATH9=GLOBAL_XML_PATH+"\\compcatSchemaDAO.xml";
	public static final String EST_XML_PATH10=GLOBAL_XML_PATH+"\\comsubcatSchemaDAO.xml";
	public static final String EST_XML_PATH11=GLOBAL_XML_PATH+"\\revgencatSchemaDAO.xml";
	public static final String EST_XML_PATH12=GLOBAL_XML_PATH+"\\revgenSchemaDAO.xml";
	public static final String EST_XML_PATH13=GLOBAL_XML_PATH+"\\offcomtypeSchemaDAO.xml";
	public static final String EST_XML_PATH14=GLOBAL_XML_PATH+"\\offcomareaSchemaDAO.xml";
	public static final String EST_XML_PATH15=GLOBAL_XML_PATH+"\\quartertypeSchemaDAO.xml";
	public static final String EST_XML_PATH16=GLOBAL_XML_PATH+"\\quarterSchemaDAO.xml";
	public static final String EST_XML_PATH17=GLOBAL_XML_PATH+"\\commonareaSchemaDAO.xml";
	public static final String EST_XML_PATH18=GLOBAL_XML_PATH+"\\guesthouseSchemaDAO.xml";
	public static final String EST_XML_PATH19=GLOBAL_XML_PATH+"\\securityperSchemaDAO.xml";
	public static final String EST_XML_PATH20=GLOBAL_XML_PATH+"\\vehicleSchemaDAO.xml";
	public static final String EST_XML_PATH21=GLOBAL_XML_PATH+"\\privateagencySchemaDAO.xml";
	public static final String EST_XML_PATH22=GLOBAL_XML_PATH+"\\servicetypeSchemaDAO.xml";
	public static final String EST_XML_PATH23=GLOBAL_XML_PATH+"\\serviceagencySchemaDAO.xml";
	public static final String EST_XML_PATH24=GLOBAL_XML_PATH+"\\supplierSchemaDAO.xml";
	public static final String EST_XML_PATH25=GLOBAL_XML_PATH+"\\billnatureSchemaDAO.xml"; 
	public static final String EST_XML_PATH26=GLOBAL_XML_PATH+"\\elecmtrSchemaDAO.xml";
	public static final String EST_XML_PATH27=GLOBAL_XML_PATH+"\\wtrmtrSchemaDAO.xml";
	public static final String EST_XML_PATH28=GLOBAL_XML_PATH+"\\telephoneSchemaDAO.xml";
	public static final String EST_XML_PATH29=GLOBAL_XML_PATH+"\\shopallotmentSchemaDAO.xml";
	public static final String EST_XML_PATH30=GLOBAL_XML_PATH+"\\quarterAllotSchemaDAO.xml";
	public static final String EST_XML_PATH31=GLOBAL_XML_PATH+"\\qtrVacateSchemaDAO.xml";
	public static final String EST_XML_PATH32=GLOBAL_XML_PATH+"\\applicationSchemaDAO.xml";
	public static final String EST_XML_PATH33=GLOBAL_XML_PATH+"\\telephoneAllotSchemaDAO.xml";
	public static final String EST_XML_PATH34=GLOBAL_XML_PATH+"\\teleCancelSchemaDAO.xml";
	public static final String EST_XML_PATH35=GLOBAL_XML_PATH+"\\ExtSecCompDetSchemaDAO.xml";
	public static final String EST_XML_PATH36=GLOBAL_XML_PATH+"\\RosterSchemaDAO.xml";
	public static final String EST_XML_PATH37=GLOBAL_XML_PATH+"\\PoliceVeriDAO.xml";
	public static final String EST_XML_PATH38=GLOBAL_XML_PATH+"\\shopvacateSchemaDAO.xml";
	public static final String EST_XML_PATH39=GLOBAL_XML_PATH+"\\billGenerationSchemaDAO.xml";
	public static final String EST_XML_PATH40=GLOBAL_XML_PATH+"\\hospitalBillDtlSchemaDAO.xml";
	public static final String EST_XML_PATH41=GLOBAL_XML_PATH+"\\roomallotSchemaDAO.xml";
	public static final String EST_XML_PATH42=GLOBAL_XML_PATH+"\\roomvacationSchemaDAO.xml";
	public static final String EST_XML_PATH43=GLOBAL_XML_PATH+"\\OPCAreaAllotSchemaDAO.xml";
	public static final String EST_XML_PATH44=GLOBAL_XML_PATH+"\\offpurcomaltcnlSchemaDAO.xml";
	public static final String EST_XML_PATH45=GLOBAL_XML_PATH+"\\offpurmntstatusSchemaDAO.xml";
	public static final String EST_XML_PATH46=GLOBAL_XML_PATH+"\\InternalCompSchemaDAO.xml";
	public static final String EST_XML_PATH47=GLOBAL_XML_PATH+"\\hoscomareamntaltcnlSchemaDAO.xml";
	public static final String EST_XML_PATH48=GLOBAL_XML_PATH+"\\hoscomareamntstatusSchemaDAO.xml";
	public static final String EST_XML_PATH49=GLOBAL_XML_PATH+"\\blkcomareamntaltcnlSchemaDAO.xml";
	public static final String EST_XML_PATH50=GLOBAL_XML_PATH+"\\guesthouseAllotmentSchemaDAO.xml";
	public static final String EST_XML_PATH51=GLOBAL_XML_PATH+"\\guesthouseVacationSchemaDAO.xml";
	public static final String EST_XML_PATH52=GLOBAL_XML_PATH+"\\guesthouseMntAltCnlSchemaDAO.xml";
	public static final String EST_XML_PATH53=GLOBAL_XML_PATH+"\\guesthouseMntStatusSchemaDAO.xml";
	public static final String EST_XML_PATH54=GLOBAL_XML_PATH+"\\prevDuesRecSchemaDAO.xml";
	public static final String EST_XML_PATH55=GLOBAL_XML_PATH+"\\blkcomareamntstatusSchemaDAO.xml";
	public static final String EST_XML_PATH56=GLOBAL_XML_PATH+"\\blkflrcomareamntSchemaDAO.xml";
	public static final String EST_XML_PATH57=GLOBAL_XML_PATH+"\\blkflrcomareamntstatusSchemaDAO.xml";
	public static final String EST_XML_PATH58=GLOBAL_XML_PATH+"\\CivilRequestSchemaDAO.xml";

	
	
	/*public static final String XML_PATH1 = "E:\\AHIMSVer2\\src\\transactionMgmnt\\xmlTest\\quartertypeSchemaDAO.xml";
	public static final String XML_PATH4 = "E:\\AHIMSVer2\\src\\transactionMgmnt\\xmlTest\\quarterSchemaDAO.xml";
	public static final String XML_PATH5 = "E:\\AHIMSVer2\\src\\transactionMgmnt\\xmlTest\\quartermapSchemaDAO.xml";
	public static final String XML_PATH6 = "E:\\AHIMSVer2\\src\\transactionMgmnt\\xmlTest\\vehicleSchemaDAO.xml";
	public static final String XML_PATH7 = "E:\\AHIMSVer2\\src\\transactionMgmnt\\xmlTest\\privateagencySchemaDAO.xml";
	public static final String XML_PATH8 = "E:\\AHIMSVer2\\src\\transactionMgmnt\\xmlTest\\commonareaSchemaDAO.xml";
	public static final String XML_PATH9 = "E:\\AHIMSVer2\\src\\transactionMgmnt\\xmlTest\\commonareaMaintSchemaDAO.xml";
	public static final String XML_PATH10 = "E:\\AHIMSVer2\\src\\transactionMgmnt\\xmlTest\\guesthouseSchemaDAO.xml";
	//public static final String XML_PATH11 = "E:\\AHIMSVer2\\src\\transactionMgmnt\\xmlTest\\guesthouseAllotmentSchemaDAO.xml";
	//public static final String XML_PATH12 = "E:\\AHIMSVer2\\src\\transactionMgmnt\\xmlTest\\guesthouseVacationSchemaDAO.xml";
	//public static final String XML_PATH13 = "E:\\AHIMSVer2\\src\\transactionMgmnt\\xmlTest\\guesthouseMntAltCnlSchemaDAO.xml";
	//public static final String XML_PATH14 = "E:\\AHIMSVer2\\src\\transactionMgmnt\\xmlTest\\guesthouseMntStatusSchemaDAO.xml";
	public static final String XML_PATH15 = "E:\\AHIMSVer2\\src\\transactionMgmnt\\xmlTest\\OPCAreaAllotSchemaDAO.xml";
	public static final String XML_PATH16 = "E:\\AHIMSVer2\\src\\transactionMgmnt\\xmlTest\\offpurcomaltcnlSchemaDAO.xml";
	public static final String XML_PATH17 = "E:\\AHIMSVer2\\src\\transactionMgmnt\\xmlTest\\offpurmntstatusSchemaDAO.xml";
	public static final String XML_PATH18 = "E:\\AHIMSVer2\\src\\transactionMgmnt\\xmlTest\\hoscomareamntaltcnlSchemaDAO.xml";
	public static final String XML_PATH19 = "E:\\AHIMSVer2\\src\\transactionMgmnt\\xmlTest\\hoscomareamntstatusSchemaDAO.xml";
	public static final String XML_PATH20 = "E:\\AHIMSVer2\\src\\transactionMgmnt\\xmlTest\\blkcomareamntaltcnlSchemaDAO.xml";
	public static final String XML_PATH21 = "E:\\AHIMSVer2\\src\\transactionMgmnt\\xmlTest\\blkcomareamntstatusSchemaDAO.xml";
	public static final String XML_PATH22 = "E:\\AHIMSVer2\\src\\transactionMgmnt\\xmlTest\\blkflrcomareamntSchemaDAO.xml";
	public static final String XML_PATH23 = "E:\\AHIMSVer2\\src\\transactionMgmnt\\xmlTest\\blkflrcomareamntstatusSchemaDAO.xml";
	*/
	


	
	
	/********************************************************************************************************/
	
	private static DataSource datasource=null;

	public static synchronized DataSource getDataSource() throws DataSourceException
	{
		try
		{
				if(dataSource==null)
				{
					Context ic		= new InitialContext();
					dataSource	= (DataSource)ic.lookup(conStr);
				}
		}
		catch(NamingException e)
		{
			throw new DataSourceException("hisglobal.backutil.ServicLocator.getDataSource():"+e.getMessage());
		}
		return dataSource;
	}

	public static synchronized String  getImagePath()  
	{
		Connection con		= null;
		Statement stmt		= null;
		ResultSet resultSet 	= null;
		String GLOBAL_ESTATE_IMAGE_PATH1=null;
		String Query=null;
		try
		{
			
			DataSource ds = ServiceLocator.getDataSource();
			con 		= ds.getConnection();
			Query 	="SELECT T.ATTRIBUTE_PATH FROM ACT_GBL_PATH_CONFIG_MST T WHERE T.GNUM_ISVALID=1 AND T.ATTRIBUTE_NAME='IMAGEPATH'";	
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(Query);
			
			if(resultSet!=null && resultSet.next())
			{
				GLOBAL_ESTATE_IMAGE_PATH1 = resultSet.getString(1);
			}
			
		}
		catch(Exception e)
		{
			//throw new Exception("hisglobal.backutil.ServicLocator.getImagePath():"+e.getMessage());
		}
		finally
		{
			closeConnection(con);
		}
		
		return GLOBAL_ESTATE_IMAGE_PATH1;
	}
	
	public static synchronized String getXMLPath() 
	{
		
		Connection con		= null;
		Statement stmt		= null;
		ResultSet resultSet 	= null;
		String GLOBAL_XML_PATH1=null;
		String Query=null;
		try
		{
				
			DataSource ds = ServiceLocator.getDataSource();
			con 		= ds.getConnection();
			Query 	="SELECT T.ATTRIBUTE_PATH FROM ACT_GBL_PATH_CONFIG_MST T WHERE T.GNUM_ISVALID=1 AND T.ATTRIBUTE_NAME='XMLPATH'";	
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(Query);
			
			if(resultSet!=null && resultSet.next())
			{
				GLOBAL_XML_PATH1 = resultSet.getString(1);
			}
			
		}
		catch(Exception e)
		{
			//throw new Exception("hisglobal.backutil.ServicLocator.getXMLPath():"+e.getMessage());
		}
		finally
		{
			closeConnection(con);
		}
		return GLOBAL_XML_PATH1;
	}
	
	
	public  static void closeConnection(Connection connection) throws EstateException
	{		
		try
		{
			if(connection == null)
				throw new EstateException("hisglobal.backutil.ServicLocator.closeConnection():Invalide Argument:Connection==null");
			connection.close();
		}
		catch(SQLException e)
		{
			throw new EstateException("hisglobal.backutil.ServicLocator.getConnection():"+e.getMessage());
		}
		catch(Exception e)
		{
			throw new EstateException("hisglobal.backutil.ServicLocator.getConnection():"+e.getMessage());
		}
	}
	
}







	


