package hisglobal.utility.generictemplate.dao;

/**
 * @copyright CDAC
 * @developer Pragya Sharma
 */

import hisglobal.exceptions.HisApplicationExecutionException;
import hisglobal.exceptions.HisDataAccessException;
import hisglobal.exceptions.HisRecordNotFoundException;
import hisglobal.hisconfig.Config;
import hisglobal.persistence.DataAccessObject;
import hisglobal.persistence.HelperMethodsDAO;
import hisglobal.persistence.TransactionContext;
import hisglobal.utility.HelperMethods;
import hisglobal.utility.Sequence;
import hisglobal.utility.generictemplate.GenericTemplateConfig;
import hisglobal.vo.ParameterMasterVO;
import hisglobal.vo.UserVO;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class ParameterMasterDAO extends DataAccessObject
{
	public ParameterMasterDAO(TransactionContext _tx)
	{
		super(_tx);
	}

	// Inserting Parameter
	public String create(ParameterMasterVO _paraVO, UserVO _userVO)
	{
		String paraId = null;
		String query = "";
		Map populateMAP = new HashMap();
		Sequence sq = new Sequence();
		String filename = GenericTemplateConfig.QUERY_FILE_FOR_GENERIC_TEMPLATE;
		String queryKey = "INSERT.IN_GROUP_HGBT_PARAMETER_MST";

		try
		{
			if(_paraVO.getIsParentBased().equalsIgnoreCase("0") || _paraVO.getParentPara()==null || _paraVO.getParentPara().trim().equals(""))
				queryKey = "INSERT.IN_GROUP_PARAID_IN_PARENT.HGBT_PARAMETER_MST";
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException(
					"HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		try
		{
			populateMAP.put(sq.next(), _paraVO.getParaType());
			populateMAP.put(sq.next(), Config.SUPER_USER_HOSPITAL_CODE);
			populateMAP.put(sq.next(), _paraVO.getParaType());
			populateMAP.put(sq.next(), Config.SUPER_USER_HOSPITAL_CODE);
			populateMAP.put(sq.next(), _paraVO.getParaName());
			populateMAP.put(sq.next(), _paraVO.getParaBound());
			populateMAP.put(sq.next(), _paraVO.getParaType());
			populateMAP.put(sq.next(), Config.IS_VALID_ACTIVE);
			populateMAP.put(sq.next(), _userVO.getSeatId());
			if(_paraVO.getIsParentBased().equalsIgnoreCase("0") || _paraVO.getParentPara()==null || _paraVO.getParentPara().trim().equals(""))
			{
				populateMAP.put(sq.next(), _paraVO.getParaType());
				populateMAP.put(sq.next(), Config.SUPER_USER_HOSPITAL_CODE);
				populateMAP.put(sq.next(), _paraVO.getParaType());
			}
			else
				populateMAP.put(sq.next(), _paraVO.getParentPara());

		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException("ParameterMasterDAO.populateMAP::" + e);
		}
		try
		{
			HelperMethodsDAO.excecuteUpdate(super.getTransactionContext().getConnection(), query, populateMAP);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new HisDataAccessException("ParameterMasterDAO.getResultset" + e);
		}

		try
		{
			paraId = this.fetchIdByNameInGroup(_paraVO.getParaName(), _paraVO.getParaType(), _userVO);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new HisDataAccessException("ParameterMasterDAO.getResultset" + e);
		}
		return paraId;
	}

	// Fetching Parameter Id by Parameter Name
	public String fetchIdByName(String _paraName, UserVO _userVO)
	{
		String paraId = null;
		String query = "";
		ResultSet rs;
		Map populateMAP = new HashMap();
		Sequence sq = new Sequence();

		String filename = GenericTemplateConfig.QUERY_FILE_FOR_GENERIC_TEMPLATE;
		String queryKey = "SELECT.ID_BY_NAME.HGBT_PARAMETER_MST";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException(
					"HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		try
		{
			populateMAP.put(sq.next(), _paraName);
			populateMAP.put(sq.next(), Config.SUPER_USER_HOSPITAL_CODE);
			populateMAP.put(sq.next(), Config.IS_VALID_ACTIVE);
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException("ParameterMasterDAO.populateMAP::" + e);
		}

		try
		{
			rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMAP);
			if (rs.next())
			{
				paraId =rs.getString(1);
			}
		}
		catch (Exception e)
		{
			if (e.getClass() == HisRecordNotFoundException.class)
			{
				throw new HisRecordNotFoundException(e.getMessage());
			}
			else throw new HisDataAccessException("ParameterMasterDAO.getResultset" + e);
		}
		return paraId;
	}
	
	// Fetching Parameter Id by Parameter Name In Given Template Group
	public String fetchIdByNameInGroup(String _paraName, String _tempGroupID, UserVO _userVO)
	{
		String paraId = null;
		String query = "";
		ResultSet rs;
		Map populateMAP = new HashMap();
		Sequence sq = new Sequence();

		String filename = GenericTemplateConfig.QUERY_FILE_FOR_GENERIC_TEMPLATE;
		String queryKey = "SELECT.ID_BY_NAME_IN_GROUP.HGBT_PARAMETER_MST";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException(
					"HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		try
		{
			populateMAP.put(sq.next(), _paraName);
			populateMAP.put(sq.next(), _tempGroupID);
			populateMAP.put(sq.next(), Config.SUPER_USER_HOSPITAL_CODE);
			populateMAP.put(sq.next(), Config.IS_VALID_ACTIVE);
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException("ParameterMasterDAO.populateMAP::" + e);
		}

		try
		{
			rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMAP);
			if (rs.next())
			{
				paraId = rs.getString(1);
			}
		}
		catch (Exception e)
		{
			if (e.getClass() == HisRecordNotFoundException.class)
			{
				throw new HisRecordNotFoundException(e.getMessage());
			}
			else throw new HisDataAccessException("ParameterMasterDAO.getResultset" + e);
		}
		return paraId;
	}

	// Fetching Parameter Id by Parameter Name In Given Template Group
	public String fetchIdByParentInGroup(String _paraParent, String _tempGroupID, UserVO _userVO)
	{
		String paraId = null;
		String query = "";
		ResultSet rs;
		Map populateMAP = new HashMap();
		Sequence sq = new Sequence();

		String filename = GenericTemplateConfig.QUERY_FILE_FOR_GENERIC_TEMPLATE;
		String queryKey = "SELECT.ID_BY_PARENT_IN_GROUP.HGBT_PARAMETER_MST";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException(
					"HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		try
		{
			populateMAP.put(sq.next(), _tempGroupID);
			populateMAP.put(sq.next(), _paraParent);
			populateMAP.put(sq.next(), Config.SUPER_USER_HOSPITAL_CODE);
			populateMAP.put(sq.next(), Config.IS_VALID_ACTIVE);
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException("ParameterMasterDAO.populateMAP::" + e);
		}

		try
		{
			rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMAP);
			if (rs.next())
			{
				paraId = rs.getString(1);
			}
		}
		catch (Exception e)
		{
			if (e.getClass() == HisRecordNotFoundException.class)
			{
				throw new HisRecordNotFoundException(e.getMessage());
			}
			else throw new HisDataAccessException("ParameterMasterDAO.getResultset" + e);
		}
		return paraId;
	}

	public ParameterMasterVO getParameterById(String _paraId, UserVO _userVO)
	{
		ParameterMasterVO parameterVO=new ParameterMasterVO();
		String query = "";
		ResultSet rs;
		Map populateMAP = new HashMap();
		Sequence sq = new Sequence();

		String filename = GenericTemplateConfig.QUERY_FILE_FOR_GENERIC_TEMPLATE;
		String queryKey = "SELECT.ALL_BY_PARA_ID.HGBT_PARAMETER_MST";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException(
					"HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		try
		{
			populateMAP.put(sq.next(), Config.SUPER_USER_HOSPITAL_CODE);
			//populateMAP.put(sq.next(), Config.IS_VALID_ACTIVE);
			populateMAP.put(sq.next(), _paraId);
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException("ParameterMasterDAO.populateMAP::" + e);
		}

		try
		{
			rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMAP);
			
			
			 if(!rs.next()){
		 	    	throw new HisRecordNotFoundException("Parameter Details Not Found");	 	    
		 	    }
		 	    else{
		 	    	rs.beforeFirst();
		 	    	
		 	    	while(rs.next()){
		 	    		
		 	 	    	HelperMethods.populateVOfrmRS(parameterVO,rs); 	
		 	 	    	
		 	    	}
		 	    }
		}
		catch (Exception e)
		{
			if (e.getClass() == HisRecordNotFoundException.class)
			{
				throw new HisRecordNotFoundException(e.getMessage());
			}
			else throw new HisDataAccessException("ParameterMasterDAO.getResultset" + e);
		}
		return parameterVO;
	}

	public void update(ParameterMasterVO _paraVO, UserVO _userVO)
	{
		String query = "";
		Map populateMAP = new HashMap();
		Sequence sq = new Sequence();
		String filename = GenericTemplateConfig.QUERY_FILE_FOR_GENERIC_TEMPLATE;
		String queryKey = "UPDATE.HGBT_PARAMETER_MST";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException(
					"HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		try
		{
			populateMAP.put(sq.next(), _paraVO.getParaName());
			populateMAP.put(sq.next(), _paraVO.getIsValid());
			populateMAP.put(sq.next(), _paraVO.getParaBound());
			populateMAP.put(sq.next(), _paraVO.getParaType());
			populateMAP.put(sq.next(), Config.SUPER_USER_HOSPITAL_CODE);
			populateMAP.put(sq.next(), _paraVO.getParaId());
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException("ParameterMasterDAO.populateMAP::" + e);
		}
		try
		{
			HelperMethodsDAO.excecuteUpdate(super.getTransactionContext().getConnection(), query, populateMAP);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new HisDataAccessException("ParameterMasterDAO.getResultset" + e);
		}

	} 
	public boolean exists(ParameterMasterVO _parameterVO, UserVO _userVO)
	{
		String query = "";
		ResultSet rs;
		Map populateMAP = new HashMap();
		Sequence sq = new Sequence();
		boolean flag = false;

		String filename = GenericTemplateConfig.QUERY_FILE_FOR_GENERIC_TEMPLATE;
		String queryKey = "SELECT.NAME_EXISTS.HGBT_PARAMETER_MST";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException(
					"HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		try
		{
			populateMAP.put(sq.next(), _parameterVO.getParaId());
			populateMAP.put(sq.next(), Config.SUPER_USER_HOSPITAL_CODE);
			populateMAP.put(sq.next(), Config.IS_VALID_ACTIVE);
			populateMAP.put(sq.next(), _parameterVO.getParaName());
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException("TemplateMasterDAO.populateMAP::" + e);
		}
		try
		{
			rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMAP);
			if (rs.next())
			{
				if(Integer.parseInt(rs.getString(1))>0)
					flag=true;
				else
					flag=false;
			}
		}
		catch (Exception e)
		{
			if (e.getClass() == HisRecordNotFoundException.class) throw new HisRecordNotFoundException(e.getMessage());
			else throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
		}
		return flag;
	}
}
