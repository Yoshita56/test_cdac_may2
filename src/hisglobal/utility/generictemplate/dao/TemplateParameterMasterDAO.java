package hisglobal.utility.generictemplate.dao;

/**
 * @copyright CDAC
 * @developer Pragya Sharma
 */

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hisglobal.persistence.TransactionContext;
import hisglobal.exceptions.HisApplicationExecutionException;
import hisglobal.exceptions.HisDataAccessException;
import hisglobal.exceptions.HisRecordNotFoundException;
import hisglobal.hisconfig.Config;
import hisglobal.persistence.DataAccessObject;
import hisglobal.persistence.HelperMethodsDAO;
import hisglobal.utility.Entry;
import hisglobal.utility.Sequence;
import hisglobal.utility.generictemplate.GenericTemplateConfig;
import hisglobal.vo.TemplateParameterMasterVO;
import hisglobal.vo.UserVO;

public class TemplateParameterMasterDAO extends DataAccessObject 
{
	public TemplateParameterMasterDAO(TransactionContext _tx) 
	{
		super(_tx);	
	}
	
	// Inserting Template Parameter
	public void create(TemplateParameterMasterVO _vo, UserVO _userVO)
	{
		
		String query  = "";
        Map populateMAP =new HashMap();
        Sequence sq=new Sequence();
		String filename = GenericTemplateConfig.QUERY_FILE_FOR_GENERIC_TEMPLATE;
        String queryKey="INSERT.HGBT_TEMPLATE_PARA_MST";

        try
        {
        	query =HelperMethodsDAO.getQuery(filename,queryKey);
        }
        catch(Exception e)
        {
        	throw new HisApplicationExecutionException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file"+e);
        }
        
        try
        {
    		populateMAP.put(sq.next(),_vo.getTemplateId());
    		populateMAP.put(sq.next(),_vo.getTemplateId());
    		populateMAP.put(sq.next(),_vo.getRow());
    		populateMAP.put(sq.next(),_vo.getCol());
    		populateMAP.put(sq.next(),Config.SUPER_USER_HOSPITAL_CODE);

    		populateMAP.put(sq.next(),_vo.getRow());
    		populateMAP.put(sq.next(),_vo.getCol());
    		populateMAP.put(sq.next(),Config.SUPER_USER_HOSPITAL_CODE);
    		populateMAP.put(sq.next(),_vo.getParaId());
    		populateMAP.put(sq.next(),_vo.getParentParaId());
    		populateMAP.put(sq.next(),_vo.getParentIdLocation());
    		populateMAP.put(sq.next(),_vo.getLocationType());
    		populateMAP.put(sq.next(),_vo.getColspan());
    		populateMAP.put(sq.next(),_vo.getControlType());
    		populateMAP.put(sq.next(),_vo.getDisplayValue());
    		populateMAP.put(sq.next(),_vo.getControlProps());
    		populateMAP.put(sq.next(),_vo.getSourceFlag());
    		populateMAP.put(sq.next(),_vo.getStaticOptions());
    		populateMAP.put(sq.next(),_vo.getDynamicQuery());
    		populateMAP.put(sq.next(),_vo.getHaveDependent());
    		populateMAP.put(sq.next(),_vo.getDependentParaId());
    		populateMAP.put(sq.next(),_vo.getIsCompulsory());
    		populateMAP.put(sq.next(),_vo.getIsRange());
    		populateMAP.put(sq.next(),Config.IS_VALID_ACTIVE);
    		populateMAP.put(sq.next(),_userVO.getSeatId());
        }
        catch(Exception e)
        {
        	throw new HisApplicationExecutionException("TemplateParameterMasterDAO.populateMAP::"+e);
        }
        try
        {
        	HelperMethodsDAO.excecuteUpdate(super.getTransactionContext().getConnection(),query,populateMAP);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	throw new HisDataAccessException("HelperMethodsDAO.getResultset"+e);
        }
	}
	
	// Getting List By Temp Id
	public List<TemplateParameterMasterVO> getTempParaList(String _tempId, UserVO _userVO)
	{
		ResultSet rs = null;
		String query = "";
		Map populateMAP = new HashMap();

		String filename = GenericTemplateConfig.QUERY_FILE_FOR_GENERIC_TEMPLATE;
		String queryKey = "SELECT.ALL_PARA_BY_TEMP_ID.HGBT_TEMPLATE_PARA_MST";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException(
					"HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		Sequence sq = new Sequence();
		try
		{
			populateMAP.put(sq.next(), _tempId);
			populateMAP.put(sq.next(), Config.SUPER_USER_HOSPITAL_CODE);
			populateMAP.put(sq.next(), Config.IS_VALID_ACTIVE);
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException("TemplateParameterMasterDAO.populateMAP::" + e);
		}

		try
		{
			rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMAP);
		}
		catch (Exception e)
		{
			if (e.getClass() == HisRecordNotFoundException.class)
			{
				throw new HisRecordNotFoundException(e.getMessage());
			}
			else throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
		}
		
		List<TemplateParameterMasterVO> lst = new ArrayList();
		try
		{
			while (rs.next())
			{
				TemplateParameterMasterVO vo = new TemplateParameterMasterVO();
				int i=1;
				vo.setTemplateId(rs.getString(i++));
				vo.setRow(rs.getString(i++));
				vo.setCol(rs.getString(i++));
				vo.setParaId(rs.getString(i++));
				vo.setParentParaId(rs.getString(i++));
				vo.setParentIdLocation(rs.getString(i++));
				vo.setLocationType(rs.getString(i++));
				vo.setColspan(rs.getString(i++));
				vo.setControlType(rs.getString(i++));
				vo.setDisplayValue(rs.getString(i++));
				vo.setControlProps(rs.getString(i++));
				vo.setSourceFlag(rs.getString(i++));
				vo.setStaticOptions(rs.getString(i++));
				vo.setDynamicQuery(rs.getString(i++));
				vo.setIsCompulsory(rs.getString(i++));
				vo.setIsRange(rs.getString(i++));
				vo.setHaveDependent(rs.getString(i++));
				vo.setDependentParaId(rs.getString(i++));
				vo.setParaName(rs.getString(i++));
				lst.add(vo);
			}
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HisDataAccessException  :getTemplateParaDetailListByTempId" + e);
		}
		return lst;
	}

	/**
	 * Geting List All Parameters of given Template
	 * @param _lstTemps List of Template Ids
	 * @param _userVO User VO
	 * @return List of TempaParaVos
	 */
	public List<TemplateParameterMasterVO> getAllTempsParasList(List<Entry> _lstTemps, UserVO _userVO)
	{
		ResultSet rs = null;
		String query = "";
		Map populateMAP = new HashMap();

		String filename = GenericTemplateConfig.QUERY_FILE_FOR_GENERIC_TEMPLATE;
		String queryKey = "SELECT.ALL_TEMP_PARA_LIST.HGBT_TEMPLATE_PARA_MST";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException(
					"HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		Sequence sq = new Sequence();
		try
		{
			String tempIds ="";
			for(Entry e : _lstTemps)
				tempIds+=e.getValue()+",";
			if(tempIds.length()>0) tempIds = tempIds.substring(0, tempIds.length()-1);
			query = query.replace("@", tempIds);
			populateMAP.put(sq.next(), Config.SUPER_USER_HOSPITAL_CODE);
			populateMAP.put(sq.next(), Config.IS_VALID_ACTIVE);
			populateMAP.put(sq.next(), Config.IS_VALID_ACTIVE);
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException("TemplateParameterMasterDAO.populateMAP::" + e);
		}

		try
		{
			rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMAP);
		}
		catch (Exception e)
		{
			if (e.getClass() == HisRecordNotFoundException.class)
			{
				throw new HisRecordNotFoundException(e.getMessage());
			}
			else throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
		}
		
		List<TemplateParameterMasterVO> lst = new ArrayList();
		try
		{
			while (rs.next())
			{
				TemplateParameterMasterVO vo = new TemplateParameterMasterVO();
				int i=1;
				vo.setTemplateId(rs.getString(i++));
				vo.setParaId(rs.getString(i++));
				vo.setParentParaId(rs.getString(i++));
				vo.setControlType(rs.getString(i++));
				vo.setParaName(rs.getString(i++));
				lst.add(vo);
			}
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HisDataAccessException  :getTemplateParaDetailListByTempId" + e);
		}
		return lst;
	}

	// Deleting Old Template Parameter Record
	public void deleteOld(String _tempId, UserVO _UserVO)
	{
		
		String query  = "";
        Map populateMAP =new HashMap();
        Sequence sq=new Sequence();
		String filename = GenericTemplateConfig.QUERY_FILE_FOR_GENERIC_TEMPLATE;
        String queryKey="UPDATE.DELETE_BY_TEMP_ID.HGBT_TEMPLATE_PARA_MST";

        try
        {
        	query =HelperMethodsDAO.getQuery(filename,queryKey);
        }
        catch(Exception e)
        {
        	throw new HisApplicationExecutionException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file"+e);
        }
        
        try
        {
    		populateMAP.put(sq.next(),Config.IS_VALID_DELETED);
    		populateMAP.put(sq.next(),_tempId);
    		populateMAP.put(sq.next(),Config.SUPER_USER_HOSPITAL_CODE);
        }
        catch(Exception e)
        {
        	throw new HisApplicationExecutionException("TemplateParameterMasterDAO.populateMAP::"+e);
        }
        try
        {
        	HelperMethodsDAO.excecuteUpdate(super.getTransactionContext().getConnection(),query,populateMAP);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	throw new HisDataAccessException("HelperMethodsDAO.getResultset"+e);
        }
	}
}