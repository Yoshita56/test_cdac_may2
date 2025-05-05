package hisglobal.utility.generictemplate.dao;

import hisglobal.utility.Entry;
import hisglobal.vo.ParameterRangeMasterVO;
import hisglobal.vo.TemplateCategoryVO;
import hisglobal.vo.TemplateGroupVO;
import hisglobal.vo.UserDeskMenuTemplateMasterVO;
import hisglobal.vo.UserVO;

import java.util.List;

/**
 * @copyright CDAC
 * @developer Pragya Sharma
 */

public interface GenericTemplateEssentialDAOi
{
	/** 
	 * Getting Template Group List
	 * @param _userVO UserVO 
	 * @return List of TemplateGroupVO objects
	 */
	public List<TemplateGroupVO> getTemplateGroupList(UserVO _userVO);

	/** Getting Template Category List
	 * @param _userVO UserVO 
	 * @return List of TemplateCategoryVO objects
	 */
	public List<TemplateCategoryVO> getAllTemplateCategoryList(UserVO _userVO);

	/** Getting Clinical Parameter List
	 * @param _userVO UserVO 
	 * @return List of Entry objects of Clinical Parameters Id/Value
	 */
	public List<Entry> getAllClinicalParameterList(UserVO _userVO);

	/** 
	 * Getting All Clinical Parameter List Group Wise
	 * @param _tempGroupId Template Group Id
	 * @param _userVO UserVO User Detail
	 * @return List of Entry objects of Clinical Parameters Id/Value
	 */
	public List<Entry> getAllClinicalParameterListGroupWise(String _tempGroupId, UserVO _userVO);

	/** Getting Parameter Dynamic Data 
	 * @param _query Dynamic Query
	 * @param _userVO User VO
	 * @return Entry Object of Value/Label 
	 */
	public List<Entry> getParameterDynamicData(String _query, UserVO _userVO);

	/** Getting Parameter Range Data on basis of para id Gender and Age
	 * @param _paraId Parameter Id
	 * @param _gender Gender Code 
	 * @param _age Age for Age Limit
	 * @param _userVO User VO
	 * @return Parameter Range VO 
	 */
	public ParameterRangeMasterVO getParameterRangeData(String _paraId, String _gender,String _age, UserVO _userVO);

	/**
	 * Getting Template List by Unit, Ward, Seat, Desk, Desk Menu Wise
	 * @param _deskType DEsk Type
	 * @param _userDeskTempVO User Desk Template Mapping VO containing required Info
	 * @param _userVO User VO
	 * @return List of Entry objects in format tempId#defaultFlag as Value and Temp Name as Label 
	 */
	public List<Entry> getDeskMenuTemplateList(String _deskType, UserDeskMenuTemplateMasterVO _userDeskTempVO, UserVO _userVO);

	/**
	 * Getting Paremter List by Template Wise
	 * @param _lstTemp List of Entry TempId/TempName
	 * @param _userVO User VO
	 * @return List of Entry objects in format ParaId/ParaName 
	 */
	public List<Entry> getTemplateParametersList(List<Entry> _lstTemp, UserVO _userVO);

	/**
	 * Getting Template List by Template Category
	 * @param _tempCategory 	Array of Template Category IDs
	 * @param _userVO 			User VO
	 * @return 					List of Entry objects in format TempId/TempName 
	 */
	public List<Entry> getTemplateListByCategory(String _tempCategory, UserVO _userVO);

	/**
	 * Getting Template List by Template Category
	 * @param _tempCategory 	Array of Template Category IDs
	 * @param _userVO 			User VO
	 * @return 					List of Entry objects in format TempId/TempName 
	 */
	public List<Entry> getTemplateListByCategories(String[] _tempCategory, UserVO _userVO);
}
