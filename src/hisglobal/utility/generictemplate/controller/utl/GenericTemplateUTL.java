package hisglobal.utility.generictemplate.controller.utl;

/**
 * @copyright CDAC
 * @developer Pragya Sharma
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import hisglobal.exceptions.HisApplicationExecutionException;
import hisglobal.exceptions.HisDataAccessException;
import hisglobal.exceptions.HisException;
import hisglobal.exceptions.HisRecordNotFoundException;
import hisglobal.presentation.Status;
import hisglobal.presentation.WebUTIL;
import hisglobal.utility.Entry;
import hisglobal.utility.generictemplate.GenericTemplateConfig;
import hisglobal.utility.generictemplate.GenericTemplateUtility;
import hisglobal.utility.generictemplate.InformationControlBean;
import hisglobal.utility.generictemplate.TemplateDesignerUtility;
import hisglobal.utility.generictemplate.controller.data.GenericTemplateDATA;
import hisglobal.vo.ParameterRangeMasterVO;
import hisglobal.vo.TemplateMasterVO;
import hisglobal.vo.TemplateParameterMasterVO;
import hisglobal.vo.UserVO;

public class GenericTemplateUTL 
{
	// Getting Template HTML Code Dynamically
	public static String generateHTMLTemplate(String _templateId, Map<String, String> _mapParaValues, String viewMode, HttpServletRequest _request)
	{
		String htmlCode = "";
		Status  objStatus=new Status();
		try
		{
			UserVO userVO = null;
			
			InformationControlBean infoBean = null;
			if(_request.getSession().getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_INFORMATION_BEAN) != null)
				infoBean = (InformationControlBean)_request.getSession().getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_INFORMATION_BEAN);
			else
				infoBean = new InformationControlBean();

			// Template Data
			List<TemplateParameterMasterVO> lstTempParaVO = new ArrayList<TemplateParameterMasterVO>();
			TemplateMasterVO vo = new TemplateMasterVO();
			vo.setTemplateId(_templateId);
			TemplateMasterVO voTemp = GenericTemplateDATA.getTemplateDataById(vo, userVO);
			WebUTIL.setAttributeInSession(_request, GenericTemplateConfig.GENERIC_TEMPLATE_DETAIL_VO, voTemp);
			
			// Template Parameter Detail
			lstTempParaVO = GenericTemplateDATA.getTempParaDetailList(voTemp.getTemplateId() ,userVO);
			
			// Setting Dynamic Query Data
			getSetDynamicParameterSourceData(lstTempParaVO, _request);
			
			// Getting Parameter Range Data
			Map<String , ParameterRangeMasterVO> mapParaRange = getSetParameterRangeData(lstTempParaVO, _request);
			
			// Getting Gender Type from Session
			String genderType = GenericTemplateConfig.GENERIC_TEMPLATE_PATIENT_INITIAL_GENDER_TYPE;
			if(_request.getSession().getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_PATIENT_GENDER_TYPE)!= null)
				genderType = (String)_request.getSession().getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_PATIENT_GENDER_TYPE);

			// Template HTML Code dynamically  
			if(_mapParaValues==null)
				htmlCode = GenericTemplateUtility.generateHTMLTemplate(voTemp.getTemplateId(), voTemp.getTemplateType(), lstTempParaVO, mapParaRange, infoBean, genderType, viewMode);
			else
				htmlCode = GenericTemplateUtility.generateHTMLTemplate(voTemp.getTemplateId(), voTemp.getTemplateType(), lstTempParaVO, mapParaRange, infoBean, genderType, viewMode, _mapParaValues);
		}
		catch(HisRecordNotFoundException e)
		{
			e.printStackTrace();
			objStatus.add(Status.UNSUCESSFULL,"","Record Not Found Error");
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
		catch(Exception e)
		{
			e.printStackTrace();
			objStatus.add(Status.ERROR,"","Error");
		}
		finally
		{
			WebUTIL.setStatus(_request,objStatus);
		}	
		return htmlCode;
	}

	// Setting Dynamic Query Data
	public static void getSetDynamicParameterSourceData(List<TemplateParameterMasterVO> _lstTempParaVO, HttpServletRequest _request)
	{
		Status  objStatus=new Status();
		List<Entry> dynaData=null;
		try
		{
			UserVO userVO = null;
			
			for(TemplateParameterMasterVO vo : _lstTempParaVO)
			{
				if(vo.getSourceFlag().equalsIgnoreCase(GenericTemplateUtility.SOURCE_FLAG_DYNAMIC))
				{
					dynaData=GenericTemplateDATA.getParameterDynamicData(vo.getDynamicQuery(), userVO);
					String dynamicOptions = GenericTemplateUtility.setParaDynamicData(vo, dynaData);
					vo.setDynamicQuery(dynamicOptions);
				}
			}
		}
		catch(HisRecordNotFoundException e)
		{
			e.printStackTrace();
			objStatus.add(Status.UNSUCESSFULL,"","Record Not Found Error");
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
		catch(Exception e)
		{
			e.printStackTrace();
			objStatus.add(Status.ERROR,"","Error");
		}
		finally
		{
			WebUTIL.setStatus(_request,objStatus);
		}	
	}
	
	// Getting Parameter Range Data
	public static Map<String, ParameterRangeMasterVO> getSetParameterRangeData(List<TemplateParameterMasterVO> _lstTempParaVO, HttpServletRequest _request)
	{
		Status  objStatus=new Status();
		Map<String, ParameterRangeMasterVO> map=null;
		try
		{
			UserVO userVO = null;
			HttpSession session = _request.getSession();			
			
			String age="1";
			String gender = GenericTemplateConfig.GENERIC_TEMPLATE_PATIENT_INITIAL_GENDER_TYPE;
			if(session.getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_PATIENT_GENDER_TYPE)!= null)
				gender = (String)session.getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_PATIENT_GENDER_TYPE);
			if(session.getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_PATIENT_AGE)!= null)
				age = (String)session.getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_PATIENT_AGE);
			
			List<String> lstRangeParaIds = new ArrayList<String>();
			for(TemplateParameterMasterVO vo : _lstTempParaVO)
			{
				if(vo.getIsRange().equals(TemplateDesignerUtility.YES_NO_VALUE_YES))
					lstRangeParaIds.add(vo.getParaId());
			}
			if(lstRangeParaIds.size()>0)
				map = GenericTemplateDATA.getParameterRangeData(lstRangeParaIds, gender, age, userVO);
			else
				map = new HashMap<String, ParameterRangeMasterVO>();				
			
		}
		catch(HisRecordNotFoundException e)
		{
			e.printStackTrace();
			objStatus.add(Status.UNSUCESSFULL,"","Record Not Found Error");
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
		catch(Exception e)
		{
			e.printStackTrace();
			objStatus.add(Status.ERROR,"","Error");
		}
		finally
		{
			WebUTIL.setStatus(_request,objStatus);
		}
		return map;
	}

	// Getting Template Data
	public static TemplateMasterVO getTemplateDataById(String _templateId, HttpServletRequest _request)
	{
		Status  objStatus=new Status();
		TemplateMasterVO voTemp = null;
		try
		{
			UserVO userVO = null;
			
			// Template Data
			voTemp = new TemplateMasterVO();
			voTemp.setTemplateId(_templateId);
			voTemp = GenericTemplateDATA.getTemplateDataById(voTemp, userVO);			
		}
		catch(HisRecordNotFoundException e)
		{
			e.printStackTrace();
			objStatus.add(Status.UNSUCESSFULL,"","Record Not Found Error");
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
		catch(Exception e)
		{
			e.printStackTrace();
			objStatus.add(Status.ERROR,"","Error");
		}
		finally
		{
			WebUTIL.setStatus(_request,objStatus);
		}	
		return voTemp;
	}
}
