package hisglobal.persistence;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import hisglobal.exceptions.HisDataAccessException;
import hisglobal.persistence.TransactionContext;
import hisglobal.hisconfig.Config;
import hisglobal.utility.Sequence;
import hisglobal.vo.ReportVO;

public class ReportDAO extends DataAccessObject
{

	public ReportDAO(TransactionContext _tx)
	{
		super(_tx);
	}

	/*public ResultSet generateGraphAgeWise(ReportVO _reportVO) {
	 System.out.println("IN DAO choice:::::::::::::::::::::::::::::::::::::::::::::::::::::::::"+_reportVO.getChoice());
	 String ch=_reportVO.getChoice();
	
	 String query  = "";
	 ResultSet rs=null;
	 Map populateMAP =new HashMap();
	 String queryKey="";
	 String filename=Config.QUERY_FILE_FOR_REPORT_CHART;
	
	 queryKey="SELECT.AGEWISEREPORT_CHART"; 
	
	
	
	 try{
	 query =HelperMethodsDAO.getQuery(filename,queryKey);
	 }
	 catch(Exception e){
	 throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file"+e);
	 }  
	
	 try{
	 Sequence sq= new Sequence();        	
	 populateMAP.put(sq.next(), _reportVO.getPatGenderCode());
	 populateMAP.put(sq.next(), _reportVO.getPatGenderCode());
	 populateMAP.put(sq.next(), _reportVO.getFromDate());
	 populateMAP.put(sq.next(), _reportVO.getToDate());    	
	 populateMAP.put(sq.next(), _reportVO.getPatPrimaryCatCode());        	
	 populateMAP.put(sq.next(), _reportVO.getPatSecondaryCatCode());
	 populateMAP.put(sq.next(), _reportVO.getDepartmentCode());
	
	 }
	 catch(Exception e){
	 e.printStackTrace();
	 throw new HisDataAccessException("populateMap(_unknownChangeVO,populateMAP)::"+e);
	 }
	 try{
	 System.out.println(query);
	 rs=HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(),query,populateMAP);   
	 return rs;
	 }   
	 catch(Exception e){
	 throw new HisDataAccessException("HelperMethodsDAO.getResultset"+e);
	 }
	 }
	 */

	////////////////////////////////AgeWise//////////////////////	
	public ResultSet generateGraphAgeWiseDatewise(ReportVO _reportVO)
	{
		System.out.println("IN DAO choice:::::::::::::::::::::::::::::::::::::::::::::::::::::::::" + _reportVO.getChoice());

		String query = "";
		ResultSet rs = null;
		Map populateMAP = new HashMap();
		String queryKey = "";
		String filename = Config.QUERY_FILE_FOR_REPORT_CHART;

		queryKey = "SELECT.AGEWISEREPORT_CHART";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		try
		{
			Sequence sq = new Sequence();
			populateMAP.put(sq.next(), _reportVO.getPatGenderCode());
			populateMAP.put(sq.next(), _reportVO.getPatGenderCode());
			populateMAP.put(sq.next(), _reportVO.getHospitalCode());
			populateMAP.put(sq.next(), _reportVO.getDepartmentCode());
			populateMAP.put(sq.next(), _reportVO.getPatPrimaryCatCode());
			// 	populateMAP.put(sq.next(), _reportVO.getPatSecondaryCatCode());
			populateMAP.put(sq.next(), _reportVO.getFromDate());
			populateMAP.put(sq.next(), _reportVO.getToDate());
			populateMAP.put(sq.next(), _reportVO.getHospitalCode());

		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new HisDataAccessException("populateMap(_unknownChangeVO,populateMAP)::" + e);
		}
		try
		{
			System.out.println(query);
			rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMAP);
			return rs;
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
		}
	}

	public ResultSet generateGraphAgeWiseToday(ReportVO _reportVO)
	{
		String query = "";
		ResultSet rs = null;
		Map populateMAP = new HashMap();
		String filename = Config.QUERY_FILE_FOR_REPORT_CHART;
		String queryKey = "SELECT.AGEWISEREPORT_CHART_TODAY";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		try
		{
			Sequence sq = new Sequence();
			populateMAP.put(sq.next(), _reportVO.getPatGenderCode());
			populateMAP.put(sq.next(), _reportVO.getPatGenderCode());
			populateMAP.put(sq.next(), _reportVO.getHospitalCode());
			populateMAP.put(sq.next(), _reportVO.getPatPrimaryCatCode());
			//	populateMAP.put(sq.next(), _reportVO.getPatSecondaryCatCode());
			populateMAP.put(sq.next(), _reportVO.getDepartmentCode());

			populateMAP.put(sq.next(), _reportVO.getFromHour());
			populateMAP.put(sq.next(), _reportVO.getFromMin());
			populateMAP.put(sq.next(), _reportVO.getToHour());
			populateMAP.put(sq.next(), _reportVO.getToMin());
			populateMAP.put(sq.next(), _reportVO.getHospitalCode());

		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new HisDataAccessException("populateMap(_unknownChangeVO,populateMAP)::" + e);
		}
		try
		{
			System.out.println(query);
			rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMAP);
			return rs;
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
		}

	}

	/////////////////////////////////////GroupWiseCashColl/////////////////////////////////////
	public ResultSet generateGroupWiseCashCollNewGraph(ReportVO _reportVO)
	{
		String query = "";
		ResultSet rs = null;
		Map populateMAP = new HashMap();
		String filename = Config.QUERY_FILE_FOR_REPORT_CHART;
		String queryKey = "SELECT.GROUPWISE_CASH_COLL_NEW_CHART";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		try
		{
			Sequence sq = new Sequence();
			//populateMAP.put(sq.next(), _reportVO.getPatPrimaryCatCode());        	
			//	populateMAP.put(sq.next(), _reportVO.getPatSecondaryCatCode());

			//populateMAP.put(sq.next(), "6");
			populateMAP.put(sq.next(), _reportVO.getHospitalCode());
			populateMAP.put(sq.next(), _reportVO.getHospitalCode());
			populateMAP.put(sq.next(), _reportVO.getFromDate());
			populateMAP.put(sq.next(), _reportVO.getToDate());
			//populateMAP.put(sq.next(),_reportVO.getPatPrimaryCatCode());    

		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new HisDataAccessException("populateMap(_unknownChangeVO,populateMAP)::" + e);
		}
		try
		{
			System.out.println(query);
			rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMAP);
			return rs;
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
		}

	}

	public ResultSet generateGroupWiseCashCollOldGraph(ReportVO _reportVO)
	{
		String query = "";
		ResultSet rs = null;
		Map populateMAP = new HashMap();
		String filename = Config.QUERY_FILE_FOR_REPORT_CHART;
		String queryKey = "SELECT.GROUPWISE_CASH_COLL_OLD_CHART";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		try
		{
			Sequence sq = new Sequence();
			//populateMAP.put(sq.next(), _reportVO.getPatPrimaryCatCode());        	
			//	populateMAP.put(sq.next(), _reportVO.getPatSecondaryCatCode());

			//populateMAP.put(sq.next(), "6");
			populateMAP.put(sq.next(), _reportVO.getHospitalCode());
			populateMAP.put(sq.next(), _reportVO.getHospitalCode());
			populateMAP.put(sq.next(), _reportVO.getFromDate());
			populateMAP.put(sq.next(), _reportVO.getToDate());
			//populateMAP.put(sq.next(),_reportVO.getPatPrimaryCatCode());    

		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new HisDataAccessException("populateMap(_unknownChangeVO,populateMAP)::" + e);
		}
		try
		{
			System.out.println(query);
			rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMAP);
			return rs;
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
		}

	}

	public ResultSet generateGroupWiseCashCollTodayNewGraph(ReportVO _reportVO)
	{
		String query = "";
		ResultSet rs = null;
		Map populateMAP = new HashMap();
		String filename = Config.QUERY_FILE_FOR_REPORT_CHART;
		String queryKey = "SELECT.GROUPWISE_CASH_COLL_TODAY_NEW_CHART";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		try
		{
			Sequence sq = new Sequence();
			//populateMAP.put(sq.next(), _reportVO.getPatPrimaryCatCode());        	
			//	populateMAP.put(sq.next(), _reportVO.getPatSecondaryCatCode());

			//populateMAP.put(sq.next(), "6");
			populateMAP.put(sq.next(), _reportVO.getHospitalCode());
			populateMAP.put(sq.next(), _reportVO.getHospitalCode());
			populateMAP.put(sq.next(), _reportVO.getFromHour());
			populateMAP.put(sq.next(), _reportVO.getFromMin());
			populateMAP.put(sq.next(), _reportVO.getToHour());
			populateMAP.put(sq.next(), _reportVO.getToMin());
			//populateMAP.put(sq.next(),_reportVO.getPatPrimaryCatCode());    

		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new HisDataAccessException("populateMap(_unknownChangeVO,populateMAP)::" + e);
		}
		try
		{
			System.out.println(query);
			rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMAP);
			return rs;
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
		}

	}

	public ResultSet generateGroupWiseCashCollTodayOldGraph(ReportVO _reportVO)
	{
		String query = "";
		ResultSet rs = null;
		Map populateMAP = new HashMap();
		String filename = Config.QUERY_FILE_FOR_REPORT_CHART;
		String queryKey = "SELECT.GROUPWISE_CASH_COLL_TODAY_OLD_CHART";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		try
		{
			Sequence sq = new Sequence();
			//populateMAP.put(sq.next(), _reportVO.getPatPrimaryCatCode());        	
			//	populateMAP.put(sq.next(), _reportVO.getPatSecondaryCatCode());

			//populateMAP.put(sq.next(), "6");
			populateMAP.put(sq.next(), _reportVO.getHospitalCode());
			populateMAP.put(sq.next(), _reportVO.getHospitalCode());
			populateMAP.put(sq.next(), _reportVO.getFromHour());
			populateMAP.put(sq.next(), _reportVO.getFromMin());
			populateMAP.put(sq.next(), _reportVO.getToHour());
			populateMAP.put(sq.next(), _reportVO.getToMin());
			//populateMAP.put(sq.next(),_reportVO.getPatPrimaryCatCode());    

		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new HisDataAccessException("populateMap(_unknownChangeVO,populateMAP)::" + e);
		}
		try
		{
			System.out.println(query);
			rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMAP);
			return rs;
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
		}

	}

	//////////////////////////DepartmentWiseTotalPat///////////////////////////

	public ResultSet generateDepartmentWiseTotalPatTodayGraph(ReportVO _reportVO)
	{
		String query = "";
		ResultSet rs = null;
		Map populateMAP = new HashMap();
		String filename = Config.QUERY_FILE_FOR_REPORT_CHART;
		String queryKey = "SELECT.DEPARTMENTWISE_TOTALPAT_TODAY_CHART";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		try
		{
			Sequence sq = new Sequence();
			//populateMAP.put(sq.next(), _reportVO.getPatPrimaryCatCode());        	
			//	populateMAP.put(sq.next(), _reportVO.getPatSecondaryCatCode());

			//populateMAP.put(sq.next(), "6");
			populateMAP.put(sq.next(), _reportVO.getDepartmentCode());
			populateMAP.put(sq.next(), _reportVO.getFromHour());
			populateMAP.put(sq.next(), _reportVO.getFromMin());
			populateMAP.put(sq.next(), _reportVO.getToHour());
			populateMAP.put(sq.next(), _reportVO.getToMin());
			populateMAP.put(sq.next(), _reportVO.getHospitalCode());

		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new HisDataAccessException("populateMap(_unknownChangeVO,populateMAP)::" + e);
		}
		try
		{
			System.out.println(query);
			rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMAP);
			return rs;
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
		}

	}

	public ResultSet generateDepartmentWiseTotalPatDatewiseGraph(ReportVO _reportVO)
	{
		String query = "";
		ResultSet rs = null;
		Map populateMAP = new HashMap();
		String filename = Config.QUERY_FILE_FOR_REPORT_CHART;
		String queryKey = "SELECT.DEPARTMENTWISE_TOTALPAT_DATEWISE_CHART";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		try
		{
			Sequence sq = new Sequence();
			//populateMAP.put(sq.next(), _reportVO.getPatPrimaryCatCode());        	
			//	populateMAP.put(sq.next(), _reportVO.getPatSecondaryCatCode());

			//populateMAP.put(sq.next(), "6");
			populateMAP.put(sq.next(), _reportVO.getDepartmentCode());
			populateMAP.put(sq.next(), _reportVO.getFromDate());
			populateMAP.put(sq.next(), _reportVO.getToDate());
			populateMAP.put(sq.next(), _reportVO.getHospitalCode());

		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new HisDataAccessException("populateMap(_unknownChangeVO,populateMAP)::" + e);
		}
		try
		{
			System.out.println(query);
			rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMAP);
			return rs;
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
		}

	}

	/////////////////////////////////////////RoomWiseTotalPat//////////////////////////////////////////////////////////////
	public ResultSet generateRoomWiseTotalPatDatewiseGraph(ReportVO _reportVO)
	{
		String query = "";
		ResultSet rs = null;
		Map populateMAP = new HashMap();
		String filename = Config.QUERY_FILE_FOR_REPORT_CHART;
		String queryKey = "SELECT.ROOMWISE_TOTALPAT_DATEWISE_CHART";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		try
		{
			Sequence sq = new Sequence();
			//populateMAP.put(sq.next(), _reportVO.getPatPrimaryCatCode());        	
			//	populateMAP.put(sq.next(), _reportVO.getPatSecondaryCatCode());

			//populateMAP.put(sq.next(), "6");
			populateMAP.put(sq.next(), _reportVO.getRoomCode());
			populateMAP.put(sq.next(), _reportVO.getFromDate());
			populateMAP.put(sq.next(), _reportVO.getToDate());
			populateMAP.put(sq.next(), _reportVO.getHospitalCode());

		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new HisDataAccessException("populateMap(_unknownChangeVO,populateMAP)::" + e);
		}
		try
		{
			System.out.println(query);
			rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMAP);
			return rs;
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
		}

	}

	public ResultSet generateRoomWiseTotalPatTodayGraph(ReportVO _reportVO)
	{
		String query = "";
		ResultSet rs = null;
		Map populateMAP = new HashMap();
		String filename = Config.QUERY_FILE_FOR_REPORT_CHART;
		String queryKey = "SELECT.ROOMWISE_TOTALPAT_TODAY_CHART";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		try
		{
			Sequence sq = new Sequence();
			//populateMAP.put(sq.next(), _reportVO.getPatPrimaryCatCode());        	
			//	populateMAP.put(sq.next(), _reportVO.getPatSecondaryCatCode());

			//populateMAP.put(sq.next(), "6");
			populateMAP.put(sq.next(), _reportVO.getRoomCode());
			populateMAP.put(sq.next(), _reportVO.getFromHour());
			populateMAP.put(sq.next(), _reportVO.getFromMin());
			populateMAP.put(sq.next(), _reportVO.getToHour());
			populateMAP.put(sq.next(), _reportVO.getToMin());
			populateMAP.put(sq.next(), _reportVO.getHospitalCode());

		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new HisDataAccessException("populateMap(_unknownChangeVO,populateMAP)::" + e);
		}
		try
		{
			System.out.println(query);
			rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMAP);
			return rs;
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
		}

	}

	/////////////////////////////////////////////////////generateTotalPatStatGraph//////////////////////////////////////////////////////////////

	public ResultSet generateTotalPatStatDatewiseOldGraph(ReportVO _reportVO)
	{
		String query = "";
		ResultSet rs = null;
		Map populateMAP = new HashMap();
		String filename = Config.QUERY_FILE_FOR_REPORT_CHART;
		String queryKey = "SELECT.TOTAL_PATIENT_STATICS_DATEWISE_OLD_CHART";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		try
		{
			Sequence sq = new Sequence();
			//populateMAP.put(sq.next(), _reportVO.getPatPrimaryCatCode());        	
			//	populateMAP.put(sq.next(), _reportVO.getPatSecondaryCatCode());

			//populateMAP.put(sq.next(), "6");

			populateMAP.put(sq.next(), _reportVO.getHospitalCode());
			populateMAP.put(sq.next(), _reportVO.getFromDate());
			populateMAP.put(sq.next(), _reportVO.getToDate());
			populateMAP.put(sq.next(), _reportVO.getPatPrimaryCatCode());
			//populateMAP.put(sq.next(), _reportVO.getPatSecondaryCatCode());
			populateMAP.put(sq.next(), _reportVO.getHospitalCode());
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new HisDataAccessException("populateMap(_unknownChangeVO,populateMAP)::" + e);
		}
		try
		{
			System.out.println(query);
			rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMAP);
			return rs;
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
		}

	}

	public ResultSet generateTotalPatStatDatewiseNewGraph(ReportVO _reportVO)
	{
		String query = "";
		ResultSet rs = null;
		Map populateMAP = new HashMap();
		String filename = Config.QUERY_FILE_FOR_REPORT_CHART;
		String queryKey = "SELECT.TOTAL_PATIENT_STATICS_DATEWISE_NEW_CHART";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		try
		{
			Sequence sq = new Sequence();
			//populateMAP.put(sq.next(), _reportVO.getPatPrimaryCatCode());        	
			//	populateMAP.put(sq.next(), _reportVO.getPatSecondaryCatCode());

			//populateMAP.put(sq.next(), "6");
			populateMAP.put(sq.next(), _reportVO.getHospitalCode());
			populateMAP.put(sq.next(), _reportVO.getFromDate());
			populateMAP.put(sq.next(), _reportVO.getToDate());
			populateMAP.put(sq.next(), _reportVO.getPatPrimaryCatCode());
			populateMAP.put(sq.next(), _reportVO.getHospitalCode());
			//	populateMAP.put(sq.next(), _reportVO.getPatSecondaryCatCode());    	

		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new HisDataAccessException("populateMap(_unknownChangeVO,populateMAP)::" + e);
		}
		try
		{
			System.out.println(query);
			rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMAP);
			return rs;
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
		}

	}

	public ResultSet generateTotalPatStatTodayOldGraph(ReportVO _reportVO)
	{
		String query = "";
		ResultSet rs = null;
		Map populateMAP = new HashMap();
		String filename = Config.QUERY_FILE_FOR_REPORT_CHART;
		String queryKey = "SELECT.TOTAL_PATIENT_STATICS_TODAY_OLD_CHART";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		try
		{
			Sequence sq = new Sequence();
			//populateMAP.put(sq.next(), _reportVO.getPatPrimaryCatCode());        	
			//	populateMAP.put(sq.next(), _reportVO.getPatSecondaryCatCode());

			//populateMAP.put(sq.next(), "6");
			populateMAP.put(sq.next(), _reportVO.getHospitalCode());
			populateMAP.put(sq.next(), _reportVO.getFromHour());
			populateMAP.put(sq.next(), _reportVO.getFromMin());
			populateMAP.put(sq.next(), _reportVO.getToHour());
			populateMAP.put(sq.next(), _reportVO.getToMin());
			populateMAP.put(sq.next(), _reportVO.getPatPrimaryCatCode());
			populateMAP.put(sq.next(), _reportVO.getHospitalCode());
			//populateMAP.put(sq.next(), _reportVO.getPatSecondaryCatCode());    	

		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new HisDataAccessException("populateMap(_unknownChangeVO,populateMAP)::" + e);
		}
		try
		{
			System.out.println(query);
			rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMAP);
			return rs;
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
		}

	}

	public ResultSet generateTotalPatStatTodayNewGraph(ReportVO _reportVO)
	{
		String query = "";
		ResultSet rs = null;
		Map populateMAP = new HashMap();
		String filename = Config.QUERY_FILE_FOR_REPORT_CHART;
		String queryKey = "SELECT.TOTAL_PATIENT_STATICS_TODAY_NEW_CHART";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		try
		{
			Sequence sq = new Sequence();
			//populateMAP.put(sq.next(), _reportVO.getPatPrimaryCatCode());        	
			//	populateMAP.put(sq.next(), _reportVO.getPatSecondaryCatCode());

			//populateMAP.put(sq.next(), "6");
			populateMAP.put(sq.next(), _reportVO.getHospitalCode());
			populateMAP.put(sq.next(), _reportVO.getFromHour());
			populateMAP.put(sq.next(), _reportVO.getFromMin());
			populateMAP.put(sq.next(), _reportVO.getToHour());
			populateMAP.put(sq.next(), _reportVO.getToMin());
			populateMAP.put(sq.next(), _reportVO.getPatPrimaryCatCode());
			//populateMAP.put(sq.next(), _reportVO.getPatSecondaryCatCode());    	
			populateMAP.put(sq.next(), _reportVO.getHospitalCode());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new HisDataAccessException("populateMap(_unknownChangeVO,populateMAP)::" + e);
		}
		try
		{
			System.out.println(query);
			rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMAP);
			return rs;
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
		}

	}

}//end od DAO

