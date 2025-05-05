package hisglobal.utility.generictemplate.dao;

/**
 * @copyright CDAC
 * @developer Pragya Sharma
 */

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import hisglobal.persistence.TransactionContext;

import hisglobal.exceptions.HisApplicationExecutionException;
import hisglobal.exceptions.HisDataAccessException;
import hisglobal.exceptions.HisRecordNotFoundException;
import hisglobal.exceptions.HisUpdateUnsuccesfullException;
import hisglobal.hisconfig.Config;
import hisglobal.persistence.DataAccessObject;
import hisglobal.persistence.HelperMethodsDAO;
import hisglobal.utility.Sequence;
import hisglobal.utility.generictemplate.GenericTemplateConfig;
import hisglobal.vo.TemplateMasterVO;
import hisglobal.vo.UserVO;

public class TemplateMasterDAO extends DataAccessObject implements TemplateMasterDAOi
{
	public TemplateMasterDAO(TransactionContext _tx)
	{
		super(_tx);
	}

	/**
	 * Inserting Template
	 * @param _templateVO Template Master VO
	 * @param _UserVO User Detail
	 * @return Inserted Template ID in format    --  TCXXXXX  -- TC-Template Category XXXXX-Running Seq
	 */
	public String create(TemplateMasterVO _templateVO, UserVO _UserVO)
	{
		String templateId = null;
		
		String query = "";
		Map populateMAP = new HashMap();
		Sequence sq = new Sequence();
		String filename = GenericTemplateConfig.QUERY_FILE_FOR_GENERIC_TEMPLATE;
		String queryKey = "INSERT.FIRST.HGBT_TEMPLATE_MST";

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
			populateMAP.put(sq.next(), _templateVO.getTemplateCategory());
			populateMAP.put(sq.next(),  Config.SUPER_USER_HOSPITAL_CODE);
			populateMAP.put(sq.next(), _templateVO.getTemplateCategory());
			populateMAP.put(sq.next(), Config.IS_VALID_ACTIVE);
			populateMAP.put(sq.next(),Config.SUPER_USER_HOSPITAL_CODE);
			populateMAP.put(sq.next(), _templateVO.getTemplateName().trim());
			populateMAP.put(sq.next(), _templateVO.getTemplateType());
			populateMAP.put(sq.next(), _templateVO.getTemplateCategory());
			populateMAP.put(sq.next(), Config.IS_VALID_ACTIVE);
			populateMAP.put(sq.next(), _UserVO.getSeatId());
			populateMAP.put(sq.next(), _templateVO.getEffectiveFrom());
			populateMAP.put(sq.next(), _templateVO.getEffectiveTo());
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException("TemplateMasterDAO.populateMAP::" + e);
		}
		try
		{
			HelperMethodsDAO.excecuteUpdate(super.getTransactionContext().getConnection(), query, populateMAP);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
		}
		
		try
		{
			templateId = this.fetchIdByTempNameNCat(_templateVO.getTemplateName(), _templateVO.getTemplateCategory(), _UserVO);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new HisDataAccessException("TemplateMasterDAO.getResultset" + e);
		}
		return templateId;
	}

	/**
	 * Getting Template Id by Template Name
	 * @param _templateName Template Name
	 * @param _UserVO User Detail
	 * @return Template ID
	 */
	public String fetchIdByName(String _templateName, UserVO _UserVO)
	{
		String tempId = "";

		String query = "";
		ResultSet rs;
		Map populateMAP = new HashMap();
		Sequence sq = new Sequence();

		String filename = GenericTemplateConfig.QUERY_FILE_FOR_GENERIC_TEMPLATE;
		String queryKey = "SELECT.MAX_TEMPLATE_ID.HGBT_TEMPLATE_MST";

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
			populateMAP.put(sq.next(), _templateName);
			populateMAP.put(sq.next(), Config.SUPER_USER_HOSPITAL_CODE);
			populateMAP.put(sq.next(), Config.IS_VALID_ACTIVE);
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
				tempId = rs.getString(1).trim();
			}
		}
		catch (Exception e)
		{
			if (e.getClass() == HisRecordNotFoundException.class)
			{
				throw new HisRecordNotFoundException(e.getMessage());
			}
			else throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
		}
		return tempId;
	}

	/**
	 * Getting Template Id by Template Name and Template Category
	 * @param _templateName Template Name
	 * @param _tempCat Template Category
	 * @param _UserVO User Detail
	 * @return Template ID
	 */
	public String fetchIdByTempNameNCat(String _templateName, String _tempCat, UserVO _UserVO)
	{
		String tempId = "";

		String query = "";
		ResultSet rs;
		Map populateMAP = new HashMap();
		Sequence sq = new Sequence();

		String filename = GenericTemplateConfig.QUERY_FILE_FOR_GENERIC_TEMPLATE;
		String queryKey = "SELECT.MAX_TEMPLATE_ID_BY_NAME_N_CAT.HGBT_TEMPLATE_MST";

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
			populateMAP.put(sq.next(), _templateName);
			populateMAP.put(sq.next(), _tempCat);
			populateMAP.put(sq.next(), Config.SUPER_USER_HOSPITAL_CODE);
			populateMAP.put(sq.next(), Config.IS_VALID_ACTIVE);
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
				tempId = rs.getString(1).trim();
			}
		}
		catch (Exception e)
		{
			if (e.getClass() == HisRecordNotFoundException.class)
			{
				throw new HisRecordNotFoundException(e.getMessage());
			}
			else throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
		}
		return tempId;
	}

	/** 
	 * Getting Template Record Data By Template ID
	 * @param _voTemp TemplateMasterVO
	 * @param _userVO UserVO
	 * @return Template Data in VO 
	 */
	public TemplateMasterVO getTemplateDataById(TemplateMasterVO _voTemp, UserVO _userVO)
	{
		String query = "";
		ResultSet rs;
		Map populateMAP = new HashMap();
		Sequence sq = new Sequence();

		String filename = GenericTemplateConfig.QUERY_FILE_FOR_GENERIC_TEMPLATE;
		String queryKey = "SELECT.BY_ID.HGBT_TEMPLATE_MST";

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
			populateMAP.put(sq.next(), _voTemp.getTemplateId());
			populateMAP.put(sq.next(), Config.SUPER_USER_HOSPITAL_CODE);
			populateMAP.put(sq.next(), Config.IS_VALID_ACTIVE);
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException("TemplateMasterDAO.populateMAP::" + e);
		}
		TemplateMasterVO vo = new TemplateMasterVO();
		try
		{
			rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMAP);
			if (rs.next())
			{
				vo.setTemplateId(_voTemp.getTemplateId());
				vo.setTempSerialNo(_voTemp.getTempSerialNo());
				
				vo.setTemplateName(rs.getString(1));
				vo.setTemplateCategory(rs.getString(2));
				vo.setTemplateType(rs.getString(3));
				vo.setEffectiveFrom(rs.getString(4));
				if (rs.getString(5)== null)	vo.setEffectiveTo("");
				else	vo.setEffectiveTo(rs.getString(5));								
			}
		}
		catch (Exception e)
		{
			if (e.getClass() == HisRecordNotFoundException.class) throw new HisRecordNotFoundException(e.getMessage());
			else throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
		}
		return vo;
	}

	/**
	 * Check Wheather Template Name already Exists
	 * @param _tempVO Template Detail
	 * @param _userVO User Detail
	 * @return true if exists otherwise false
	 */
	public boolean exists(TemplateMasterVO _tempVO, UserVO _userVO)
	{
		String query = "";
		ResultSet rs;
		Map populateMAP = new HashMap();
		Sequence sq = new Sequence();
		boolean flag = false;

		String filename = GenericTemplateConfig.QUERY_FILE_FOR_GENERIC_TEMPLATE;
		String queryKey = "SELECT.NAME_EXISTS.HGBT_TEMPLATE_MST";

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
			if(_tempVO.getTemplateId()==null || _tempVO.getTemplateId()=="")
			{ 
				populateMAP.put(sq.next(), "0");
			}
			else
			{
				populateMAP.put(sq.next(), _tempVO.getTemplateId());
			}
			populateMAP.put(sq.next(), Config.SUPER_USER_HOSPITAL_CODE);
			populateMAP.put(sq.next(), Config.IS_VALID_ACTIVE);
			populateMAP.put(sq.next(), _tempVO.getTemplateCategory());
			populateMAP.put(sq.next(), _tempVO.getTemplateName());
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

	/**
	 * Updating Template Record
	 * @param _tempVO Template Detail
	 * @param _userVO User Detail
	 */
	public void updateOld(TemplateMasterVO _tempVO, UserVO _userVO)
	{
		String query = "";
		Map populateMAP = new HashMap();
		
		String filename = GenericTemplateConfig.QUERY_FILE_FOR_GENERIC_TEMPLATE;
		String queryKey = "UPDATE.INACTIVE_OLD.HGBT_TEMPLATE_MST";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException(
					"HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		try
		{
			Sequence sq = new Sequence();
			populateMAP.put(sq.next(), Config.IS_VALID_DELETED);
			populateMAP.put(sq.next(), _tempVO.getTemplateId());
			populateMAP.put(sq.next(), _tempVO.getTempSerialNo());
			populateMAP.put(sq.next(), Config.SUPER_USER_HOSPITAL_CODE);
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException("TemplateMasterDAO.populateMAP::" + e);
		}
		try
		{
			int i = HelperMethodsDAO.excecuteUpdate(super.getTransactionContext().getConnection(), query, populateMAP);
			if (i == 0)
			{
				throw new HisUpdateUnsuccesfullException();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new HisUpdateUnsuccesfullException("HelperMethodsDAO.getResultset" + e);
		}
	}

	/**
	 * Inserting New Template
	 * @param _templateVO Template Detail
	 * @param _UserVO User Detail
	 */
	public void createNew(TemplateMasterVO _templateVO, UserVO _UserVO)
	{
		String query = "";
		Map populateMAP = new HashMap();
		Sequence sq = new Sequence();
		String filename = GenericTemplateConfig.QUERY_FILE_FOR_GENERIC_TEMPLATE;
		String queryKey = "INSERT.NEW.HGBT_TEMPLATE_MST";

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
			populateMAP.put(sq.next(), _templateVO.getTemplateId());
			populateMAP.put(sq.next(), Config.SUPER_USER_HOSPITAL_CODE);
			populateMAP.put(sq.next(), _templateVO.getTemplateName().trim());
			populateMAP.put(sq.next(), _templateVO.getTemplateCategory());
			populateMAP.put(sq.next(), _templateVO.getTemplateType());
			populateMAP.put(sq.next(), Config.IS_VALID_ACTIVE);
			populateMAP.put(sq.next(), _UserVO.getSeatId());
			populateMAP.put(sq.next(), _templateVO.getEffectiveFrom());
			populateMAP.put(sq.next(), _templateVO.getEffectiveTo());
			populateMAP.put(sq.next(), _templateVO.getTemplateId());
			populateMAP.put(sq.next(), Config.SUPER_USER_HOSPITAL_CODE);
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException("TemplateMasterDAO.populateMAP::" + e);
		}
		try
		{
			HelperMethodsDAO.excecuteUpdate(super.getTransactionContext().getConnection(), query, populateMAP);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
		}
	}

	/**
	 * Returns Created Template Count in Given Category for Unique Check
	 * @param _catCode Template Category Code
	 * @param _userVO User VO
	 * @return Template Count
	 */
	public String getIsUniqueNCountTemp(String _catCode, UserVO _userVO)
	{
		String str = "";
		String query = "";
		ResultSet rs;
		Map populateMAP = new HashMap();
		Sequence sq = new Sequence();

		String filename = GenericTemplateConfig.QUERY_FILE_FOR_GENERIC_TEMPLATE;
		String queryKey = "GET_IS_UNIQUE_COUNT_TEMPLATE.HGBT_TEMPLATE_MST";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		try
		{
			populateMAP.put(sq.next(), Config.IS_VALID_ACTIVE);
			populateMAP.put(sq.next(), Config.SUPER_USER_HOSPITAL_CODE);
			populateMAP.put(sq.next(), _catCode);
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
				str =rs.getString(1);
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
		return str;
	}
}
