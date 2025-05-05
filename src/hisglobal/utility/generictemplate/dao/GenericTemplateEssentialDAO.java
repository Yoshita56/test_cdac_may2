package hisglobal.utility.generictemplate.dao;

/**
 * @copyright CDAC
 * @developer Pragya Sharma
 */

import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import oracle.jdbc.driver.OracleTypes;

import hisglobal.exceptions.HisApplicationExecutionException;
import hisglobal.exceptions.HisDataAccessException;
import hisglobal.exceptions.HisException;
import hisglobal.exceptions.HisRecordNotFoundException;
import hisglobal.hisconfig.Config;
import hisglobal.persistence.DataAccessObject;
import hisglobal.persistence.HelperMethodsDAO;
import hisglobal.persistence.Procedure;
import hisglobal.persistence.TransactionContext;
import hisglobal.utility.Entry;
import hisglobal.utility.HelperMethods;
import hisglobal.utility.Sequence;
import hisglobal.utility.generictemplate.GenericTemplateConfig;
import hisglobal.utility.generictemplate.TemplateDesignerUtility;
import hisglobal.vo.ParameterRangeMasterVO;
import hisglobal.vo.TemplateCategoryVO;
import hisglobal.vo.TemplateGroupVO;
import hisglobal.vo.UserDeskMenuTemplateMasterVO;
import hisglobal.vo.UserVO;
import hisglobal.vo.ValueObject;

public class GenericTemplateEssentialDAO extends DataAccessObject implements GenericTemplateEssentialDAOi
{
	/**
	 * Constructor for Setting Transaction Context
	 */
	public GenericTemplateEssentialDAO(TransactionContext _transactionContext)
	{
		super(_transactionContext);
	}

	/** 
	 * Getting Template Group List
	 * @param _userVO UserVO 
	 * @return List of TemplateGroupVO objects
	 */
	public List<TemplateGroupVO> getTemplateGroupList(UserVO _userVO)
	{
		ResultSet rs = null;
		String query = "";
		Map populateMAP = new HashMap();

		String filename = GenericTemplateConfig.QUERY_FILE_FOR_GENERIC_TEMPLATE;
		String queryKey = "SELECT.ALL.HGBT_TEMPLATE_GROUP_MST";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException(
					"HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		System.out.println("   -------> query :: " + query);
		Sequence sq = new Sequence();

		try
		{
			populateMAP.put(sq.next(), Config.SUPER_USER_HOSPITAL_CODE);
			populateMAP.put(sq.next(), Config.IS_VALID_ACTIVE);
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException("GenericTemplateEssentialDAO.populateMAP::" + e);
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

		ValueObject[] vos = null;
		List<TemplateGroupVO> lstTempGrp = new ArrayList();
		try
		{
			while(rs.next())
			{				
				rs.beforeFirst();
				vos = HelperMethods.populateVOfrmRS(TemplateGroupVO.class, rs);
				
				for (ValueObject vo : vos)
					lstTempGrp.add((TemplateGroupVO)vo);
			}
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HisDataAccessException  :getAllTemplateCategoryList" + e);
		}
		return lstTempGrp;
	}

	/** Getting Template Category List
	 * @param _userVO UserVO 
	 * @return List of TemplateCategoryVO objects
	 */
	public List<TemplateCategoryVO> getAllTemplateCategoryList(UserVO _userVO)
	{
		ResultSet rs = null;
		String query = "";
		Map populateMAP = new HashMap();

		String filename = GenericTemplateConfig.QUERY_FILE_FOR_GENERIC_TEMPLATE;
		String queryKey = "SELECT.ALL.HGBT_TEMPLATE_CATEGORY_MST";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException(
					"HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		System.out.println("   -------> query :: " + query);
		Sequence sq = new Sequence();

		try
		{
			populateMAP.put(sq.next(), Config.SUPER_USER_HOSPITAL_CODE);
			populateMAP.put(sq.next(), Config.IS_VALID_ACTIVE);
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException("GenericTemplateEssentialDAO.populateMAP::" + e);
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

		ValueObject[] vos = null;
		List<TemplateCategoryVO> lstTempCat = new ArrayList();
		try
		{
			while(rs.next())
			{				
				rs.beforeFirst();
				vos = HelperMethods.populateVOfrmRS(TemplateCategoryVO.class, rs);
				
				for (ValueObject vo : vos)
					lstTempCat.add((TemplateCategoryVO)vo);
			}
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HisDataAccessException  :getAllTemplateCategoryList" + e);
		}
		return lstTempCat;
	}

	/** Getting All Clinical Parameter List
	 * @param _userVO UserVO 
	 * @return List of Entry objects of Clinical Parameters Id/Value
	 */
	public List<Entry> getAllClinicalParameterList(UserVO _userVO)
	{
		ResultSet rs = null;
		String query = "";
		Map populateMAP = new HashMap();

		String filename = GenericTemplateConfig.QUERY_FILE_FOR_GENERIC_TEMPLATE;
		String queryKey = "SELECT.ALL.HGBT_PARAMETER_MST";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException(
					"HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		System.out.println("   -------> query :: " + query);
		Sequence sq = new Sequence();

		try
		{
			populateMAP.put(sq.next(), _userVO.getHospitalCode());
			populateMAP.put(sq.next(), Config.IS_VALID_ACTIVE);
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException("GenericTemplateEssentialDAO.populateMAP::" + e);
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
		List<Entry> alRecord = new ArrayList();
		try
		{
			if (rs.next()) alRecord = HelperMethodsDAO.getAlOfEntryObjects(rs);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HisDataAccessException  :getAllClinicalParameterList" + e);
		}
		return alRecord;
	}
	
	/** 
	 * Getting All Clinical Parameter List Group Wise
	 * @param _tempGroupId Template Group Id
	 * @param _userVO UserVO User Detail
	 * @return List of Entry objects of Clinical Parameters Id/Value
	 */
	public List<Entry> getAllClinicalParameterListGroupWise(String _tempGroupId, UserVO _userVO)
	{
		ResultSet rs = null;
		String query = "";
		Map populateMAP = new HashMap();

		String filename = GenericTemplateConfig.QUERY_FILE_FOR_GENERIC_TEMPLATE;
		String queryKey = "SELECT.ALL_GROUP_WISE.HGBT_PARAMETER_MST";

		try
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException(
					"HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
		}

		System.out.println("   -------> query :: " + query);
		Sequence sq = new Sequence();

		try
		{
			populateMAP.put(sq.next(), _tempGroupId);	// Template Group Id in Para Type
			populateMAP.put(sq.next(), Config.SUPER_USER_HOSPITAL_CODE);
			populateMAP.put(sq.next(), Config.IS_VALID_ACTIVE);
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException("GenericTemplateEssentialDAO.populateMAP::" + e);
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
		List<Entry> alRecord = new ArrayList();
		try
		{
			if (rs.next()) alRecord = HelperMethodsDAO.getAlOfEntryObjects(rs);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HisDataAccessException  :getAllClinicalParameterList" + e);
		}
		return alRecord;
	}

	/** Getting Parameter Dynamic Data 
	 * @param _query Dynamic Query
	 * @param _userVO User VO
	 * @return Entry Object of Value/Label 
	 */
	public List<Entry> getParameterDynamicData(String _query, UserVO _userVO)
	{
		ResultSet rs = null;
		Map populateMAP = new HashMap();

		System.out.println("   -------> query :: " + _query);
		Sequence sq = new Sequence();
		try
		{
			populateMAP.put(sq.next(), _userVO.getHospitalCode());
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException("GenericTemplateEssentialDAO.populateMAP::" + e);
		}

		try
		{
			rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), _query, populateMAP);
		}
		catch (Exception e)
		{
			if (e.getClass() == HisRecordNotFoundException.class)
			{
				throw new HisRecordNotFoundException(e.getMessage());
			}
			else throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
		}

		List<Entry> alRecord = null;
		try
		{
			if (rs.next()) alRecord = HelperMethodsDAO.getAlOfEntryObjects(rs);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HisDataAccessException  :getParameterDynamicData" + e);
		}
		return alRecord;
	}

	/** Getting Parameter Range Data on basis of para id Gender and Age
	 * @param _paraId Parameter Id
	 * @param _gender Gender Code 
	 * @param _age Age for Age Limit
	 * @param _userVO User VO
	 * @return Parameter Range VO 
	 */
	public ParameterRangeMasterVO getParameterRangeData(String _paraId, String _gender,String _age, UserVO _userVO)
	{
		ResultSet rs = null;
		String errorMsg = null;

		try
		{
			Procedure strProc = new Procedure(GenericTemplateConfig.GET_PARAMETER_RANGE_PROC);
			strProc.addInParameter(1, Types.VARCHAR, Config.IS_VALID_ACTIVE);
			strProc.addInParameter(2, Types.VARCHAR, _paraId);
			strProc.addInParameter(3, Types.VARCHAR, _gender);
			strProc.addInParameter(4, Types.VARCHAR, _age);
			strProc.addInParameter(5, Types.VARCHAR, _userVO.getHospitalCode());
			strProc.addOutParameter(6, Types.VARCHAR);
			strProc.addOutParameter(7, Types.REF);//OracleTypes.CURSOR);

			strProc.execute(super.getTransactionContext().getConnection());
			errorMsg = (String) strProc.getParameterAt(6);
			rs = (ResultSet) strProc.getParameterAt(7);
		}
		catch (HisException e)
		{
			throw new HisDataAccessException((errorMsg != null ? "" : errorMsg) + e);
		}

		ParameterRangeMasterVO vo = new ParameterRangeMasterVO();
		try
		{
			if(rs.next())
			{
				HelperMethods.populateVOfrmRS(vo, rs);
			}
			else
				vo =null;
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("DepartmentDAO:HelperMethodsDAO.getAlOfEntryObjects(rs)" + e);

		}
		return vo;
	}

	/**
	 * Getting Template List by Unit, Ward, Seat, Desk, Desk Menu Wise
	 * @param _deskType DEsk Type
	 * @param _userDeskTempVO User Desk Template Mapping VO containing required Info
	 * @param _userVO User VO
	 * @return List of Entry objects in format tempId#defaultFlag as Value and Temp Name as Label 
	 */
	public List<Entry> getDeskMenuTemplateList(String _deskType, UserDeskMenuTemplateMasterVO _userDeskTempVO, UserVO _userVO)
	{
		ResultSet rs = null;
		String errorMsg="";
		
		try
		{
			Procedure strProc=new Procedure(GenericTemplateConfig.PROC_FOR_TEMPLATE_LIST);
		    strProc.addInParameter(1,Types.VARCHAR,_deskType);
			strProc.addInParameter(2,Types.VARCHAR,_userDeskTempVO.getDeptUnitCode());
			if(_userDeskTempVO.getWardCode()==null || _userDeskTempVO.getWardCode().equals("")) _userDeskTempVO.setWardCode("-1");
			strProc.addInParameter(3,Types.VARCHAR,_userDeskTempVO.getWardCode());
			//strProc.addInParameter(4,Types.VARCHAR,_userDeskTempVO.getUserSeatId());
			strProc.addInParameter(4,Types.VARCHAR,_userVO.getSeatId());
			strProc.addInParameter(5,Types.VARCHAR,_userDeskTempVO.getDeskId());
			strProc.addInParameter(6,Types.VARCHAR,_userDeskTempVO.getDeskMenuId());
			strProc.addInParameter(7,Types.VARCHAR,_userVO.getHospitalCode());
			strProc.addOutParameter(8,Types.VARCHAR);
			strProc.addOutParameter(9,Types.REF);//OracleTypes.CURSOR);
			
			strProc.execute(super.getTransactionContext().getConnection());
			
			errorMsg=(String) strProc.getParameterAt(8);
			rs=(ResultSet) strProc.getParameterAt(9) ;
		}
		catch(HisRecordNotFoundException e)
		{
			throw new HisRecordNotFoundException("No Record Found");
		}
		catch (HisException e)
		{
			throw new HisDataAccessException((errorMsg != null ? "" : errorMsg) + e);
		}
		List<Entry> lstTemplates = new ArrayList<Entry>();
		try
		{
			while(rs.next())
			{
				Entry e = new Entry();
				e.setValue(rs.getString(1));
				e.setLabel(rs.getString(2));
				lstTemplates.add(e);
			}
		}
		catch(Exception e)
		{
			throw new HisDataAccessException("AlertDAO::getDeskMenuTemplateList"+e);
		}
		return lstTemplates;
	}

	/**
	 * Getting Paremter List by Template Wise
	 * @param _lstTemp List of Entry TempId/TempName
	 * @param _userVO User VO
	 * @return List of Entry objects in format ParaId/ParaName 
	 */
	public List<Entry> getTemplateParametersList(List<Entry> _lstTemp, UserVO _userVO)
	{
		ResultSet rs = null;
		String query = "";
		Map populateMAP = new HashMap();

		String filename = GenericTemplateConfig.QUERY_FILE_FOR_GENERIC_TEMPLATE;
		String queryKey = "SELECT.PARAS_IN_TEMPLATES.HGBT_TEMPLATE_PARA_MST";

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
			String tempIds="";
			for(Entry e: _lstTemp)
				tempIds+=e.getValue()+",";
			if(!tempIds.equals("")) tempIds=tempIds.substring(0, tempIds.length()-1);
			query = query.replace("#", tempIds);
			query = query.replace("@", Integer.toString(TemplateDesignerUtility.CONTROL_TYPES_LABEL));
			
			populateMAP.put(sq.next(), Config.SUPER_USER_HOSPITAL_CODE);
			populateMAP.put(sq.next(), Config.IS_VALID_ACTIVE);
			populateMAP.put(sq.next(), Config.IS_VALID_ACTIVE);
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException("GenericTemplateEssentialDAO.populateMAP::" + e);
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
		List<Entry> alRecord = new ArrayList();
		try
		{
			if (rs.next()) alRecord = HelperMethodsDAO.getAlOfEntryObjects(rs);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HisDataAccessException  :getTemplateParametersList" + e);
		}
		return alRecord;
	}
	/**
	 * Getting Template List by Template Category
	 * @param _tempCategory 	Array of Template Category IDs
	 * @param _userVO 			User VO
	 * @return 					List of Entry objects in format TempId/TempName 
	 */
	public List<Entry> getTemplateListByCategory(String _tempCategory, UserVO _userVO)
	{
		return getTemplateListByCategories(new String[]{_tempCategory}, _userVO);
	}
	
	/**
	 * Getting Template List by Template Category
	 * @param _tempCategory 	Array of Template Category IDs
	 * @param _userVO 			User VO
	 * @return 					List of Entry objects in format TempId/TempName 
	 */
	public List<Entry> getTemplateListByCategories(String[] _tempCategory, UserVO _userVO)
	{
		ResultSet rs = null;
		String query = "";
		Map populateMAP = new HashMap();

		String filename = GenericTemplateConfig.QUERY_FILE_FOR_GENERIC_TEMPLATE;
		String queryKey = "SELECT.TEMP_BY_CAT.HGBT_TEMPLATE_MST";

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
			String tempCatIds="";
			for(String str: _tempCategory)
				tempCatIds+=str+",";
			if(!tempCatIds.equals("")) tempCatIds=tempCatIds.substring(0, tempCatIds.length()-1);
			query = query.replace("#", tempCatIds);
			
			populateMAP.put(sq.next(), _userVO.getHospitalCode());
			populateMAP.put(sq.next(), Config.IS_VALID_ACTIVE);
		}
		catch (Exception e)
		{
			throw new HisApplicationExecutionException("GenericTemplateEssentialDAO.populateMAP::" + e);
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
		List<Entry> alRecord = new ArrayList<Entry>();
		try
		{
			if (rs.next()) alRecord = HelperMethodsDAO.getAlOfEntryObjects(rs);
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("HisDataAccessException  :getTemplateListByCategories" + e);
		}
		return alRecord;
	}
}
