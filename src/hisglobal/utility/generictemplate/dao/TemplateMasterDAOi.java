package hisglobal.utility.generictemplate.dao;

import hisglobal.vo.TemplateMasterVO;
import hisglobal.vo.UserVO;


/**
 * @copyright CDAC
 * @developer Pragya Sharma
 */

public interface TemplateMasterDAOi
{
	/**
	 * Inserting Template
	 * @param _templateVO Template Master VO
	 * @param _UserVO User Detail
	 * @return Inserted Template ID
	 */
	public String create(TemplateMasterVO _templateVO, UserVO _UserVO);
	
	/**
	 * Getting Template Id by Template Name
	 * @param _templateName Template Name
	 * @param _UserVO User Detail
	 * @return Template ID
	 */
	public String fetchIdByName(String _templateName, UserVO _UserVO);

	/** 
	 * Getting Template Record Data By Template ID
	 * @param _voTemp TemplateMasterVO
	 * @param _userVO UserVO
	 * @return Template Data in VO 
	 */
	public TemplateMasterVO getTemplateDataById(TemplateMasterVO _voTemp, UserVO _userVO);

	/**
	 * Check Wheather Template Name already Exists
	 * @param _tempVO Template Detail
	 * @param _userVO User Detail
	 * @return true if exists otherwise false
	 */
	public boolean exists(TemplateMasterVO _tempVO, UserVO _userVO);
	
	/**
	 * Updating Template Record
	 * @param _tempVO Template Detail
	 * @param _userVO User Detail
	 */
	public void updateOld(TemplateMasterVO _tempVO, UserVO _userVO);

	/**
	 * Inserting New Template
	 * @param _templateVO Template Detail
	 * @param _userVO User Detail
	 */
	public void createNew(TemplateMasterVO _templateVO, UserVO _userVO);

	/**
	 * Returns Created Template Count in Given Category for Unique Check
	 * @param _catCode Template Category Code
	 * @param _userVO User VO
	 * @return Template Count
	 */
	public String getIsUniqueNCountTemp(String _catCode, UserVO _userVO);
}
