package hisglobal.utility.generictemplate.controller.utl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @copyright CDAC
 * @developer Pragya Sharma
 */

import hisglobal.exceptions.HisApplicationExecutionException;
import hisglobal.exceptions.HisDataAccessException;
import hisglobal.exceptions.HisException;
import hisglobal.exceptions.HisRecordNotFoundException;
import hisglobal.presentation.Status;
import hisglobal.presentation.WebUTIL;
import hisglobal.utility.generictemplate.GenericTemplateConfig;
import hisglobal.utility.generictemplate.controller.data.GenericTemplateDATA;
import hisglobal.utility.generictemplate.controller.fb.ParameterMasterFB;
import hisglobal.vo.ParameterMasterVO;
import hisglobal.vo.TemplateGroupVO;
import hisglobal.vo.UserVO;

public class ParameterMasterUTL 
{
	// Setting Template Parameter Master Essentials
	public static void setEssentials(ParameterMasterFB _fb,HttpServletRequest _request)
	{
		Status  objStatus=new Status();
		try
		{
			UserVO userVO = null;
			List<TemplateGroupVO> lstTempGroup = GenericTemplateDATA.getTemplateGroupList(userVO);
			WebUTIL.setAttributeInSession(_request, GenericTemplateConfig.ESSENTIAL_LIST_ALL_TEMPLATE_GROUP, lstTempGroup);
		}
		catch(HisRecordNotFoundException e)
		{
			e.printStackTrace();
			objStatus.add(Status.NEW ,"",e.getMessage());
		}
		catch(HisDataAccessException e)
		{
			e.printStackTrace();
			objStatus.add(Status.ERROR_DA,"","Data Access Error");
		}
		catch(HisApplicationExecutionException e)
		{		
			e.printStackTrace();
			objStatus.add(Status.ERROR_AE,"","Application Execution Error");
		}
		catch(HisException e)
		{
			e.printStackTrace();
			objStatus.add(Status.ERROR,"","Error");
		}		
		finally
		{
			WebUTIL.setStatus(_request,objStatus);
		}	
	}

	public static boolean saveParameter(ParameterMasterFB _fb,HttpServletRequest _request)
	{
		Status  objStatus=new Status();
		boolean saveFlag=false;
		try
		{
			UserVO userVO = null;
			
			ParameterMasterVO parameterVO= new ParameterMasterVO();
			parameterVO.setParaName(_fb.getParaName());
			parameterVO.setParaBound(_fb.getParaBound());
			parameterVO.setParaType(_fb.getParaType());
			saveFlag=GenericTemplateDATA.saveParameter(parameterVO, userVO);
			if(saveFlag){
				objStatus.add(Status.DONE,"","Parameter Added Successfully");
			}
			else
				objStatus.add(Status.DONE,"","Parameter Already Exists");
		}
		catch(HisRecordNotFoundException e)
		{
			e.printStackTrace();
			objStatus.add(Status.UNSUCESSFULL,"",e.getMessage());
			saveFlag=false;
		}
		catch(HisDataAccessException e)
		{
			e.printStackTrace();
			objStatus.add(Status.ERROR_DA,"","Data Access Error");
			saveFlag=false;
		}
		catch(HisApplicationExecutionException e)
		{		
			e.printStackTrace();
			objStatus.add(Status.ERROR_AE,"","Application Execution Error");
			saveFlag=false;
		}
		catch(HisException e)
		{
			e.printStackTrace();
			objStatus.add(Status.ERROR,"","Error");
			saveFlag=false;
		}		
		finally
		{
			WebUTIL.setStatus(_request,objStatus);
		}
		return saveFlag;
	}
	
	public static void  getParameterById(ParameterMasterFB _fb,HttpServletRequest _request)
	{
		Status  objStatus=new Status();
		String id=_fb.getChk();	//.substring(0,_fb.getChk().indexOf("^"));
		ParameterMasterVO parameterVO;
		//String paraId[]=id.split("^");
		try
		{
			UserVO userVO =null;
			setEssentials(_fb, _request);
			String listId="";
			parameterVO=GenericTemplateDATA.getParameterById(id, userVO);
			List<TemplateGroupVO> list=(ArrayList<TemplateGroupVO>)_request.getSession().getAttribute(GenericTemplateConfig.ESSENTIAL_LIST_ALL_TEMPLATE_GROUP);
			for(TemplateGroupVO tempGrpVO : list)
				if(tempGrpVO.getTemplateGroupID().equalsIgnoreCase(parameterVO.getParaType()))
				{
					listId=tempGrpVO.getTemplateGroupName();
					break;
				}
			_fb.setParaId(parameterVO.getParaId());
			_fb.setParaName(parameterVO.getParaName());
			_fb.setParaBound(parameterVO.getParaBound());
			_fb.setParaType(parameterVO.getParaType());
			_fb.setIsActive(parameterVO.getIsValid());
			_fb.setParaTypeLabel(listId);
		}
		catch(HisRecordNotFoundException e)
		{
			e.printStackTrace();
			objStatus.add(Status.UNSUCESSFULL,"",e.getMessage());
			
		}
		catch(HisDataAccessException e)
		{
			e.printStackTrace();
			objStatus.add(Status.ERROR_DA,"","Data Access Error");
			
		}
		catch(HisApplicationExecutionException e)
		{		
			e.printStackTrace();
			objStatus.add(Status.ERROR_AE,"","Application Execution Error");
			
		}
		catch(HisException e)
		{
			e.printStackTrace();
			objStatus.add(Status.ERROR,"","Error");
			
		}		
		finally
		{
			WebUTIL.setStatus(_request,objStatus);
		}
	}
	public static boolean updateParameter(ParameterMasterFB _fb,HttpServletRequest _request)
	{
		boolean flag =  true;
		Status  objStatus=new Status();
		ParameterMasterVO parameterVO;
		try
		{
			UserVO userVO = null;
			parameterVO= new ParameterMasterVO();
			parameterVO.setParaId(_fb.getParaId());
			parameterVO.setParaName(_fb.getParaName());
			parameterVO.setParaBound(_fb.getParaBound());
			parameterVO.setParaType(_fb.getParaType());
			parameterVO.setIsValid(_fb.getIsActive());
			parameterVO.setHospitalCode(userVO.getHospitalCode());
			flag=GenericTemplateDATA.updateParameter(parameterVO, userVO);
			if(flag)
				objStatus.add(Status.DONE,"","Parameter updated Successfully");
			else
				objStatus.add(Status.UNSUCESSFULL,"","Parameter Already Exists");
		}
		catch(HisRecordNotFoundException e)
		{
			flag = false;
			e.printStackTrace();
			objStatus.add(Status.UNSUCESSFULL,"",e.getMessage());
		}
		catch(HisDataAccessException e)
		{
			flag = false;
			e.printStackTrace();
			objStatus.add(Status.ERROR_DA,"","Data Access Error");
		}
		catch(HisApplicationExecutionException e)
		{		
			flag = false;
			e.printStackTrace();
			objStatus.add(Status.ERROR_AE,"","Application Execution Error");
		}
		catch(HisException e)
		{
			flag = false;
			e.printStackTrace();
			objStatus.add(Status.ERROR,"","Error");
		}		
		finally
		{
			WebUTIL.setStatus(_request,objStatus);
		}
		return flag;		
	}
}
