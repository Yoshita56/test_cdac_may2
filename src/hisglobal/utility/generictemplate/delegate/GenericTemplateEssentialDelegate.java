package hisglobal.utility.generictemplate.delegate;

/**
 * @copyright CDAC
 * @developer Pragya Sharma
 */

import hisglobal.business.Delegate;
import hisglobal.utility.Entry;
import hisglobal.utility.generictemplate.bo.GenericTemplateEssentialBO;
import hisglobal.utility.generictemplate.bo.GenericTemplateEssentialBOi;
import hisglobal.vo.ParameterMasterVO;
import hisglobal.vo.ParameterRangeMasterVO;
import hisglobal.vo.TemplateCategoryVO;
import hisglobal.vo.TemplateGroupVO;
import hisglobal.vo.TemplateMasterVO;
import hisglobal.vo.TemplateParameterMasterVO;
import hisglobal.vo.UserDeskMenuTemplateMasterVO;
import hisglobal.vo.UserVO;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenericTemplateEssentialDelegate extends Delegate
{
	/**
	 * Constructor for Setting Service Provider
	 */
	public GenericTemplateEssentialDelegate()
	{
		super(new GenericTemplateEssentialBO());
	}
	
	/** 
	 * Getting Template Group List
	 * @param _userVO UserVO 
	 * @return List of TemplateGroupVO objects
	 */
	public List<TemplateGroupVO> getTemplateGroupList(UserVO _userVO)
	{
		GenericTemplateEssentialBOi serviceBO = (GenericTemplateEssentialBOi) super.getServiceProvider();
		return (serviceBO.getTemplateGroupList(_userVO));
	}

	/** Getting Template Category List
	 * @param _userVO UserVO 
	 * @return List of TemplateCategoryVO objects
	 */
	public List<TemplateCategoryVO> getTemplateCategoryList(UserVO _userVO)
	{
		GenericTemplateEssentialBOi serviceBO = (GenericTemplateEssentialBOi) super.getServiceProvider();
		return (serviceBO.getTemplateCategoryList(_userVO));
	}

	/** Getting Clinical Parameter List
	 * @param _userVO UserVO 
	 * @return List of Entry objects of Clinical Parameters Id/Value
	 */
	public List<Entry> getClinicalParameterList(UserVO _userVO)
	{
		GenericTemplateEssentialBOi serviceBO = (GenericTemplateEssentialBOi) super.getServiceProvider();
		return (serviceBO.getClinicalParameterList(_userVO));
	}

	/** 
	 * Getting All Clinical Parameter List Group Wise
	 * @param _tempGroupId Template Group Id
	 * @param _userVO UserVO User Detail
	 * @return List of Entry objects of Clinical Parameters Id/Value
	 */
	public List<Entry> getClinicalParameterListGroupWise(String _tempGroupId, UserVO _userVO)
	{
		GenericTemplateEssentialBOi serviceBO = (GenericTemplateEssentialBOi) super.getServiceProvider();
		return (serviceBO.getClinicalParameterListGroupWise(_tempGroupId, _userVO));
	}

	/** Saving anf Getting List of Entry Objects of Parametre Id/Name 
	 * @param _lstNewParas List of Entry Objects for Parameter Name in Label
	 * @param _paraType Parameter Type
	 * @param _userVO UserVO
	 * @return List of Entry objects of ClicalParameters Id/Name
	 */
	public List<Entry> saveGetParameters(Set<String> _newParaNames, String _paraType, UserVO _userVO)
	{
		GenericTemplateEssentialBOi serviceBO = (GenericTemplateEssentialBOi) super.getServiceProvider();
		return (serviceBO.saveGetParameters(_newParaNames,_paraType,_userVO));
	}

	/**
	 * Saving and Getting Back Template Parameters Map 
	 * @param _lstNewParas List of Template Parameters VO to add
	 * @param _mpAllLocPara Map of All Parameters Location & ID of Template
	 * @param _tempGroupID Template Group ID
	 * @param _userVO User Detail
	 * @return Map of All Paremers Loc n ID with Added Ones
	 */
	public Map<String,ParameterMasterVO> saveNewAddedParameters(List<ParameterMasterVO> _lstNewParas, Map<String,ParameterMasterVO> _mpAllLocPara, String _tempGroupID, UserVO _userVO)
	{
		GenericTemplateEssentialBOi serviceBO = (GenericTemplateEssentialBOi) super.getServiceProvider();
		return (serviceBO.saveNewAddedParameters(_lstNewParas,_mpAllLocPara,_tempGroupID,_userVO));
	}

	/** Is Template Name Already Exists 
	 * @param _templateVO Template Master VO
	 * @param _userVO User VO
	 * @return true if exists otherwise false
	 */
	public boolean exitsTemplateName(TemplateMasterVO _templateVO, UserVO _userVO)
	{
		GenericTemplateEssentialBOi serviceBO = (GenericTemplateEssentialBOi)super.getServiceProvider();
		return serviceBO.exitsTemplateName(_templateVO,_userVO);
	}

	/** Saving Template
	 * @param _tmpltVO Template Master VO
	 * @param _userVO UserVO
	 * @return Template Id
	 */
	public String saveTemplate(TemplateMasterVO _templateVO, UserVO _userVO)
	{
		GenericTemplateEssentialBOi serviceBO = (GenericTemplateEssentialBOi)super.getServiceProvider();
		return serviceBO.saveTemplate(_templateVO,_userVO);
	}
	
	/** Saving Parameters To Template
	 * @param _lstVOs List of TemplateParameterMasterVO Objects
	 * @param _userVO UserVO
	 */
	public void saveParametersToTemplate(List<TemplateParameterMasterVO> _lstVOs ,UserVO _userVO)
	{
		GenericTemplateEssentialBOi serviceBO = (GenericTemplateEssentialBOi)super.getServiceProvider();
		serviceBO.saveParametersToTemplate(_lstVOs,_userVO);
	}

	/** Getting Template Record Data By Template ID
	 * @param _voTemp TemplateMasterVO
	 * @param _userVO UserVO
	 * @return Template Data in VO 
	 */
	public TemplateMasterVO getTemplateDataById(TemplateMasterVO _voTemp, UserVO _userVO)
	{
		GenericTemplateEssentialBOi serviceBO = (GenericTemplateEssentialBOi)super.getServiceProvider();
		return serviceBO.getTemplateDataById(_voTemp,_userVO);
	}

	/** Updating Template Data
	 * @param _temoVO Template Master VO 
	 * @param _userVO User VO
	 */
	public void updateTemplateData(TemplateMasterVO _temoVO, UserVO _userVO)
	{
		GenericTemplateEssentialBOi serviceBO = (GenericTemplateEssentialBOi)super.getServiceProvider();
		serviceBO.updateTemplateData(_temoVO,_userVO);
	}

	/** Getting Template Parameter Detail List
	 * @param _tempId Template Id
	 * @param _userVO User VO
	 * @return List Template Parameter VOs
	 */
	public List getTemplateParaDetailListByTempId(String _tempId, UserVO _userVO)
	{
		GenericTemplateEssentialBOi serviceBO = (GenericTemplateEssentialBOi) super.getServiceProvider();
		return (serviceBO.getTemplateParaDetailListByTempId(_tempId, _userVO));
	}
	
	/** Deleting Old Template Para Detail By Template Id 
	 * @param _TempId Template Id
	 * @param _userVO User VO
	 */
	public void deleteOldTempParaDetialByTempId(String _tempId, UserVO _userVO)
	{
		GenericTemplateEssentialBOi serviceBO = (GenericTemplateEssentialBOi)super.getServiceProvider();
		serviceBO.deleteOldTempParaDetialByTempId(_tempId,_userVO);
	}

	/** Getting Parameter Dynamic Data 
	 * @param _query Dynamic Query
	 * @param _userVO User VO
	 * @return Entry Object of Value/Label 
	 */
	public List<Entry> getParameterDynamicData(String _query, UserVO _userVO)
	{
		GenericTemplateEssentialBOi serviceBO = (GenericTemplateEssentialBOi)super.getServiceProvider();
		return (serviceBO.getParameterDynamicData(_query,_userVO));
	}

	/** Getting Parameter Range Data on basis of Gender and Age
	 * @param _lstParaIds List Parameter Ids
	 * @param _gender Gender Code 
	 * @param _age Age for Age Limit
	 * @param _userVO User VO
	 * @return Map of Parameter Id by Parameter Range VO 
	 */
	public Map<String,ParameterRangeMasterVO> getParameterRangeData(List<String> _lstParaIds, String _gender,String _age, UserVO _userVO)
	{
		GenericTemplateEssentialBOi serviceBO = (GenericTemplateEssentialBOi)super.getServiceProvider();
		return (serviceBO.getParameterRangeData(_lstParaIds,_gender,_age,_userVO));
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
		GenericTemplateEssentialBOi serviceBO = (GenericTemplateEssentialBOi)super.getServiceProvider();
		return (serviceBO.getDeskMenuTemplateList(_deskType, _userDeskTempVO,_userVO));
	}
	
	/**
	 * Getting Paremter List by Unit, Ward, Seat, Desk, Desk Menu Wise
	 * @param _deskType DEsk Type
	 * @param _userDeskTempVO User Desk Template Mapping VO containing required Info
	 * @param _userVO User VO
	 * @return List of Entry objects in format tempId#defaultFlag as Value and Temp Name as Label 
	 */
	public List<Entry> getDeskMenuTemplateParametersList(String _deskType, UserDeskMenuTemplateMasterVO _userDeskTempVO, UserVO _userVO)
	{
		GenericTemplateEssentialBOi serviceBO = (GenericTemplateEssentialBOi)super.getServiceProvider();
		return (serviceBO.getDeskMenuTemplateParametersList(_deskType, _userDeskTempVO,_userVO));
	}

	public boolean saveParameter(ParameterMasterVO _parameterVO, UserVO _userVO)
	{
		GenericTemplateEssentialBOi serviceBO = (GenericTemplateEssentialBOi)super.getServiceProvider();
		return serviceBO.saveParameter(_parameterVO, _userVO);
	}
	
	public ParameterMasterVO getParameterById(String _paraId, UserVO _userVO)
	{
		GenericTemplateEssentialBOi serviceBO = (GenericTemplateEssentialBOi)super.getServiceProvider();
		return serviceBO.getParameterById(_paraId, _userVO);
	}
	public boolean updateParameter(ParameterMasterVO _parameterVO, UserVO _userVO)
	{
		GenericTemplateEssentialBOi serviceBO = (GenericTemplateEssentialBOi)super.getServiceProvider();
		return serviceBO.updateParameter(_parameterVO, _userVO);
	}
	
	/**
	 * Returns Created Template Count in Given Category for Unique Check
	 * @param catCode Template Category Code
	 * @param userVO User VO
	 * @return Template Count
	 */
	public String getIsUniqueNCountTemp(String catCode,UserVO userVO )
	{
		GenericTemplateEssentialBOi serviceBO = (GenericTemplateEssentialBOi)super.getServiceProvider();
		return serviceBO.getIsUniqueNCountTemp(catCode, userVO);
	}
}
