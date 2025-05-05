package hisglobal.utility.generictemplate.controller.data;

/**
 * @copyright CDAC
 * @developer Pragya Sharma
 */

import hisglobal.utility.Entry;
import hisglobal.utility.generictemplate.delegate.GenericTemplateEssentialDelegate;
import hisglobal.vo.ParameterMasterVO;
import hisglobal.vo.ParameterRangeMasterVO;
import hisglobal.vo.TemplateCategoryVO;
import hisglobal.vo.TemplateGroupVO;
import hisglobal.vo.TemplateMasterVO;
import hisglobal.vo.TemplateParameterMasterVO;
import hisglobal.vo.UserVO;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenericTemplateDATA 
{
	// Getting Template Group List
	public static List<TemplateGroupVO> getTemplateGroupList(UserVO _userVO)
	{
		GenericTemplateEssentialDelegate delegate=new GenericTemplateEssentialDelegate();
		return delegate.getTemplateGroupList(_userVO);
	}

	// Getting Template Category List
	public static List<TemplateCategoryVO> getTemplateCategoryList(UserVO _userVO)
	{
		GenericTemplateEssentialDelegate delegate=new GenericTemplateEssentialDelegate();
		return delegate.getTemplateCategoryList(_userVO);
	}
	
	// Check for Duplicate Template Name
	public static boolean exitsTemplateName(TemplateMasterVO _templateVO, UserVO _userVO)
	{
		GenericTemplateEssentialDelegate delegate=new GenericTemplateEssentialDelegate();
		return delegate.exitsTemplateName(_templateVO, _userVO);		
	}

	// Getting Clinical Parameter List
	public static List<Entry> getClinicalParameterList(UserVO _userVO)
	{
		GenericTemplateEssentialDelegate delegate=new GenericTemplateEssentialDelegate();
		return delegate.getClinicalParameterList(_userVO);
	}

	// Getting Clinical Parameter List Group Wise
	public static List<Entry> getClinicalParameterListGroupWise(String _tempGroupId, UserVO _userVO)
	{
		GenericTemplateEssentialDelegate delegate=new GenericTemplateEssentialDelegate();
		return delegate.getClinicalParameterListGroupWise(_tempGroupId, _userVO);
	}

	// Saving Template
	public static String saveTemplate(TemplateMasterVO _templateVO, UserVO _userVO)
	{
		GenericTemplateEssentialDelegate delegate=new GenericTemplateEssentialDelegate();
		return delegate.saveTemplate(_templateVO, _userVO);		
	}

	// Saving and Getting Back Parameters
	public static List<Entry> saveGetParameters(Set<String> _newParaNames, String _paraType, UserVO _userVO)
	{
		GenericTemplateEssentialDelegate delegate=new GenericTemplateEssentialDelegate();
		return delegate.saveGetParameters(_newParaNames,_paraType,_userVO);		
	}

	// Saving and Getting Back Parameters Map
	public static Map<String,ParameterMasterVO> saveNewAddedParameters(List<ParameterMasterVO> _lstNewParas, Map<String,ParameterMasterVO> _mpAllLocPara, String _tempGroupID, UserVO _userVO)
	{
		GenericTemplateEssentialDelegate delegate=new GenericTemplateEssentialDelegate();
		return delegate.saveNewAddedParameters(_lstNewParas,_mpAllLocPara,_tempGroupID,_userVO);		
	}

	// Saving Template Parameter Detail to TemplateParameterMaster
	public static void saveParametersToTemplate(List<TemplateParameterMasterVO> _lstVOs ,UserVO _userVO)
	{
		GenericTemplateEssentialDelegate delegate=new GenericTemplateEssentialDelegate();
		delegate.saveParametersToTemplate(_lstVOs,_userVO);		
	}

	// Getting Template Master Data By Template ID 
	public static TemplateMasterVO getTemplateDataById(TemplateMasterVO _voTemp, UserVO _userVO)
	{
		GenericTemplateEssentialDelegate delegate=new GenericTemplateEssentialDelegate();
		return delegate.getTemplateDataById(_voTemp,_userVO);
	}

	// Updating Template Data  
	public static void updateTemplateData(TemplateMasterVO _tempVO, UserVO _userVO)
	{
		GenericTemplateEssentialDelegate delegate=new GenericTemplateEssentialDelegate();
		delegate.updateTemplateData(_tempVO,_userVO);		
	}

	// Getting Template Parameter Detail List
	public static List getTempParaDetailList(String _tempId, UserVO _userVO)
	{
		GenericTemplateEssentialDelegate delegate=new GenericTemplateEssentialDelegate();
		return delegate.getTemplateParaDetailListByTempId(_tempId,_userVO);
	}

	// Deleting Old Template Parameter Data By Template Id
	public static void deleteOldTempParaDetialByTempId(String _tempId, UserVO _userVO)
	{
		GenericTemplateEssentialDelegate delegate=new GenericTemplateEssentialDelegate();
		delegate.deleteOldTempParaDetialByTempId(_tempId,_userVO);
	}

	// Getting Parameter Data Dynamically
	public static List<Entry> getParameterDynamicData(String _query, UserVO _userVO)
	{
		GenericTemplateEssentialDelegate delegate=new GenericTemplateEssentialDelegate();
		return delegate.getParameterDynamicData(_query,_userVO);
	}

	// Getting Parameter Range Data
	public static Map<String,ParameterRangeMasterVO> getParameterRangeData(List<String> _lstParaIds, String _gender,String _age, UserVO _userVO)
	{
		GenericTemplateEssentialDelegate delegate=new GenericTemplateEssentialDelegate();
		return delegate.getParameterRangeData(_lstParaIds,_gender,_age,_userVO);
	}
	public static boolean saveParameter(ParameterMasterVO _parameterVO,UserVO _userVO)
	{
		GenericTemplateEssentialDelegate delegate=new GenericTemplateEssentialDelegate();
		return delegate.saveParameter(_parameterVO, _userVO);
	}
	public static ParameterMasterVO getParameterById(String  _paraId,UserVO _userVO)
	{
		GenericTemplateEssentialDelegate delegate=new GenericTemplateEssentialDelegate();
		return delegate.getParameterById(_paraId, _userVO);
	}
	public static boolean updateParameter(ParameterMasterVO  _parameterVO,UserVO _userVO)
	{
		GenericTemplateEssentialDelegate delegate=new GenericTemplateEssentialDelegate();
		return delegate.updateParameter(_parameterVO, _userVO);
	}
	
	// Returns Created Template Count in Given Category for Unique Check 
	public static String getIsUniqueNCountTemp(String catCode,UserVO userVO )
	{
		GenericTemplateEssentialDelegate delegate=new GenericTemplateEssentialDelegate();
		return delegate.getIsUniqueNCountTemp(catCode, userVO);
	}

	/*//* Getting Parameter List
	public static Map getParameterList(UserVO _UserVO)
	{
		OpdEssentialDelegate essentialDelegate=new OpdEssentialDelegate();
		Map mp=essentialDelegate.getAddTempleteParameterMasterParaList(_UserVO);
		return mp;		
	}
	
	//* Saving Template Record
	public static void SaveTemplate(OpdTemplateVO _tmpltVO, UserVO _userVO)
	{
		OpdMasterDelegate masterDelegate=new OpdMasterDelegate();
		masterDelegate.saveTemplate(_tmpltVO,_userVO);		
	}
	
	//* Updating Template Record  
	public static void UpdateTemplate(OpdTemplateVO _tmpltVO, UserVO _userVO)
	{
		OpdMasterDelegate masterDelegate=new OpdMasterDelegate();
		masterDelegate.updateTemplate(_tmpltVO,_userVO);		
	}

	//* Adding Template with New Serial No 
	public static void SaveNewTemp(OpdTemplateVO _tmpltVO, UserVO _userVO)
	{
		OpdMasterDelegate masterDelegate=new OpdMasterDelegate();
		masterDelegate.saveNewTemp(_tmpltVO,_userVO);		
	}

	//* Saving Parameter Record
	public static void SaveOPDParameter(OpdParameterVO _paraVO, UserVO _userVO)
	{
		OpdMasterDelegate masterDelegate=new OpdMasterDelegate();
		masterDelegate.saveOPDParameter(_paraVO,_userVO);		
	}
	
	//* Saving Template Parameter Detail to TemplateParameterMaster
	public static void SaveParameterToTemplate(OpdTemplateParameterVO _tempParaVO ,UserVO _userVO)
	{
		OpdMasterDelegate masterDelegate=new OpdMasterDelegate();
		masterDelegate.saveParameterToTemplate(_tempParaVO,_userVO);		
	}

	//* Getting Template Data
	public static void getTemplateDataById(OpdTemplateVO _voTemp, UserVO _userVO)
	{
		OpdMasterDelegate masterDelegate=new OpdMasterDelegate();
		masterDelegate.getTemplateDataById(_voTemp,_userVO);
	}

	//* Getting Template Parameter Detail List
	public static List getTempParaDetailList(String _tempId, UserVO _userVO)
	{
		OpdEssentialDelegate essentialDelegate=new OpdEssentialDelegate();
		List lst=essentialDelegate.getTemplateParaDetailListByTempId(_tempId,_userVO);
		return lst;		
	}


	//* Getting Parameter Dynamic Data
	public static List getParameterDynamicData(String _query, UserVO _userVO)
	{
		OpdEssentialDelegate essentialDelegate=new OpdEssentialDelegate();
		List lst=essentialDelegate.getParameterDynamicData(_query,_userVO);
		return lst;		
	}*/
	
	
}
