package hisglobal.utility.generictemplate.controller.utl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @copyright CDAC
 * @developer Pragya Sharma
 */

import hisglobal.exceptions.HisApplicationExecutionException;
import hisglobal.exceptions.HisDataAccessException;
import hisglobal.exceptions.HisException;
import hisglobal.exceptions.HisRecordNotFoundException;
import hisglobal.hisconfig.Config;
import hisglobal.presentation.Status;
import hisglobal.presentation.WebUTIL;
import hisglobal.utility.Entry;
import hisglobal.utility.generictemplate.GenericTemplateConfig;
import hisglobal.utility.generictemplate.GenericTemplateUtility;
import hisglobal.utility.generictemplate.InformationControlBean;
import hisglobal.utility.generictemplate.TemplateDesignerUtility;
import hisglobal.utility.generictemplate.controller.data.GenericTemplateDATA;
import hisglobal.utility.generictemplate.controller.fb.TemplateParameterMasterFB;
import hisglobal.vo.ParameterMasterVO;
import hisglobal.vo.TemplateCategoryVO;
import hisglobal.vo.TemplateMasterVO;
import hisglobal.vo.TemplateParameterMasterVO;
import hisglobal.vo.UserVO;;

public class TemplateParameterMasterUTL 
{
	// Setting Template Parameter Master Essentials
	public static void setEssentials(TemplateParameterMasterFB _fb,HttpServletRequest _request)
	{
		Status  objStatus=new Status();
		String tempCatName="", isUnique = "", tempGroupId = "";
		String count = "";
		try
		{
			UserVO userVO = null;
			
			String categoryCode=_fb.getControls()[0];
			if(categoryCode!=null)
				_fb.setTemplateCategory(categoryCode);

			List<TemplateCategoryVO> lstTempCategory = GenericTemplateDATA.getTemplateCategoryList(userVO);
			WebUTIL.setAttributeInSession(_request, GenericTemplateConfig.ESSENTIAL_LIST_ALL_TEMPLATE_CATEGORY, lstTempCategory);
			if(lstTempCategory==null || lstTempCategory.size()==0)
			{
				throw new HisRecordNotFoundException("No Template Category Found");
			}
			
			count = GenericTemplateDATA.getIsUniqueNCountTemp(_fb.getTemplateCategory(),userVO);
			
			for(TemplateCategoryVO tempCatVO : lstTempCategory)
			{
			    if( tempCatVO.getTemplateCategory().equalsIgnoreCase(_fb.getTemplateCategory()))
			    {
			    	isUnique=tempCatVO.getIsUnique();
			    	tempCatName=tempCatVO.getTemplateCategoryType();
			    	tempGroupId=tempCatVO.getTemplateGroupID();
			    	break;
			    }
			}
			if(isUnique.trim().equals("1") && count.trim().equals("1"))
			{				
				throw new HisApplicationExecutionException(tempCatName);
			}
			_fb.setTemplateCategoryName(tempCatName);
			_fb.setTemplateCategoryType(tempCatName);
			_fb.setTemplateGroupID(tempGroupId);
			
			objStatus.add(Status.NEW);
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
			
			Status reqstatus = (Status) _request.getAttribute(Config.STATUS_OBJECT);
			reqstatus=null;
			_request.setAttribute(Config.STATUS_OBJECT, reqstatus);
			objStatus.add(Status.DONE,"","You Cannot Add More Than 1 Template in "+e.getMessage());
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

	// Checking Template Type for Template Designer Essentials
	public static void checkTemplateType(TemplateParameterMasterFB _fb,HttpServletRequest _request)
	{
		Status  objStatus=new Status();
		try
		{
			UserVO userVO = null;
			//setSysdate(_request);
			List<Entry> lstPara =null;
			HttpSession session = _request.getSession();
			
			// Check for Duplicate Template Name
			TemplateMasterVO voTemplate= new TemplateMasterVO();
			voTemplate.setTemplateId("-1");
			voTemplate.setTempSerialNo("-1");
			voTemplate.setTemplateName(_fb.getTemplateName().trim());
			voTemplate.setTemplateCategory(_fb.getTemplateCategory());
			voTemplate.setTemplateType(_fb.getTemplateType());
			voTemplate.setEffectiveFrom(_fb.getEffectiveFrom());
			voTemplate.setEffectiveTo(_fb.getEffectiveTo());
			
			if(GenericTemplateDATA.exitsTemplateName(voTemplate, userVO))
			{
				_fb.setHmode("ADD");
				throw new HisRecordNotFoundException("Template Name already exists");
			}
			
			// Set Template Category Description
			List<TemplateCategoryVO> lstTempCat = (List<TemplateCategoryVO>)session.getAttribute(GenericTemplateConfig.ESSENTIAL_LIST_ALL_TEMPLATE_CATEGORY);
			for(TemplateCategoryVO vo : lstTempCat)
			{
				if(vo.getTemplateCategory().equals(_fb.getTemplateCategory()))
				{
					_fb.setTemplateCategoryType(vo.getTemplateCategoryType());
					_fb.setTemplateCategoryName(vo.getTemplateCategoryType());
					_fb.setTemplateGroupID(vo.getTemplateGroupID());
					break;
				}
			}			
			
			
			WebUTIL.setAttributeInSession(_request, GenericTemplateConfig.ESSENTIAL_LIST_ALL_INFORMATION_CONTROL_VALUES, InformationControlBean.fetchInformationList());
			
			if(_fb.getTemplateType().equalsIgnoreCase(GenericTemplateConfig.TEMPLATE_TYPE_NORMAL) ||
					_fb.getTemplateType().equalsIgnoreCase(GenericTemplateConfig.TEMPLATE_TYPE_MATRIX) ||
					_fb.getTemplateType().equalsIgnoreCase(GenericTemplateConfig.TEMPLATE_TYPE_CONSENT) )
			{
				lstPara=GenericTemplateDATA.getClinicalParameterListGroupWise(_fb.getTemplateGroupID(), userVO);
				WebUTIL.setAttributeInSession(_request,GenericTemplateConfig.ESSENTIAL_LIST_ALL_CLINICAL_PARAMETERS, lstPara);
				_fb.setHmode("ADDTEMP");
				objStatus.add(Status.NEW);
			}
			else if(_fb.getTemplateType().equalsIgnoreCase(GenericTemplateConfig.TEMPLATE_TYPE_GUIDELINE))
			{
				lstPara= new ArrayList();
				WebUTIL.setAttributeInSession(_request,GenericTemplateConfig.ESSENTIAL_LIST_ALL_CLINICAL_PARAMETERS, lstPara);
				_fb.setHmode("ADDTEMP");
				objStatus.add(Status.NEW);
			}
			else
			{
				_fb.setHmode("ADD");
				objStatus.add(Status.INPROCESS);
			}
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
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			WebUTIL.setStatus(_request,objStatus);
		}	
	}

	// Saving Template Parameter Master
	public static boolean saveParametersToTemplate(TemplateParameterMasterFB _fb,HttpServletRequest _request)
	{
		Status  objStatus = new Status();
		HttpSession session = _request.getSession();
		boolean saveFlag=true;
		try
		{
			UserVO userVO = null;
			//setSysdate(_request);
			
			TemplateMasterVO voTemplate= new TemplateMasterVO();
			voTemplate.setTemplateName(_fb.getTemplateName().trim());
			voTemplate.setTemplateType(_fb.getTemplateType());
			voTemplate.setTemplateCategory(_fb.getTemplateCategory());
			voTemplate.setEffectiveFrom(_fb.getEffectiveFrom());
			voTemplate.setEffectiveTo(_fb.getEffectiveTo());
			
			// Saving and Getting Template Id
			String tempId = GenericTemplateDATA.saveTemplate(voTemplate,userVO);
			voTemplate.setTemplateId(tempId);
			_fb.setTemplateId(voTemplate.getTemplateId());
			
			
			// Getting Parameter VO List to Add
			List<ParameterMasterVO> lstNewParas = new ArrayList<ParameterMasterVO>();
			// Getting Template Parameter VOs List
			Map<String, TemplateParameterMasterVO> mapParaRowCol = new HashMap<String, TemplateParameterMasterVO>();
				// Image View Image Files
			Map<String,String> mpImageViewKeyExt = new HashMap<String, String>();
			List<TemplateParameterMasterVO> lstVOs = GenericTemplateUtility.getTempParaVOListFromValues(_fb.getParameterValuesList(),voTemplate,lstNewParas,mapParaRowCol,mpImageViewKeyExt);
			
			
			// Saving and Setting New Parameters
			if(lstNewParas.size()>0)
			{
				// Setting Map of Loc & Para Id of All
				Map<String, ParameterMasterVO> mpLocParaVO = new HashMap<String, ParameterMasterVO>();
				for(String k : mapParaRowCol.keySet())
				{
					ParameterMasterVO paraVO = new ParameterMasterVO();
					paraVO.setParaId(mapParaRowCol.get(k).getParaId());
					paraVO.setParaName(mapParaRowCol.get(k).getParaName());
					mpLocParaVO.put(k, paraVO);
				}
				Map<String,ParameterMasterVO> mpAllLocParaId = GenericTemplateDATA.saveNewAddedParameters(lstNewParas, mpLocParaVO, _fb.getTemplateGroupID(), userVO);

				for(ParameterMasterVO paraVO : lstNewParas)
				{
					String key = paraVO.getKey();
					String paraId = mpAllLocParaId.get(key).getParaId();					
					if(paraId!=null)
					{
						TemplateParameterMasterVO vo = mapParaRowCol.get(key);
						vo.setParaId(paraId);
					}
				}
			}
			
			// Setting Parents and Dependent Para Ids 
			boolean isHTMLSave = TemplateParameterMasterUTL.setParentIdLocNDependents(lstVOs);
			// Saving in HTML File
			GenericTemplateUtility.saveTemplateInHTMLFile(isHTMLSave, voTemplate,lstVOs);
			
			// Saving ImageView Images Files			
			Map<String, byte[]> mpImageViewImageData = null;
			if(session.getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_IMAGEVIEW_UPLOADED_IMAGE_FILE_DATA_MAP)!=null)
				mpImageViewImageData = (Map<String, byte[]>)session.getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_IMAGEVIEW_UPLOADED_IMAGE_FILE_DATA_MAP);
			GenericTemplateUtility.saveTemplateImageViewImagesInFile(voTemplate, mpImageViewImageData, mpImageViewKeyExt);

			// Saving Parameters 
			GenericTemplateDATA.saveParametersToTemplate(lstVOs, userVO);			
			
			objStatus.add(Status.NEW,"","Template and its Parameter Detail Successfully Saved");
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
	
	// Setting Parents in Format paraId#paraId and Parent Id location in format parentId@row&Col # ...
	// Get is Template have Any Dynamic Data
	private static boolean setParentIdLocNDependents(List<TemplateParameterMasterVO> lstVOs)
	{
		boolean isHTMLSave = true;
		try
		{
			for(TemplateParameterMasterVO vo : lstVOs)
			{
				// If Template have Dynamic Data or have any Range Based Parameter, it can't be saved as HTML
				if(vo.getSourceFlag().equals(GenericTemplateUtility.SOURCE_FLAG_DYNAMIC) 
						|| vo.getIsRange().equals(TemplateDesignerUtility.YES_NO_VALUE_YES)
						|| vo.getControlType().equals(GenericTemplateUtility.CONTROL_TYPES_INFORMATION)) isHTMLSave = false;
				// Setting Parents Ids
				if(!vo.getParentParaId().equals(""))
				{
					String arrParentsLoc[] = vo.getParentParaId().split(GenericTemplateUtility.SEP_IN_PARA_PARENT);					
					
					String parentsIds="";
					String parentsIdsLoc="";
					
					for(int i=0;i<arrParentsLoc.length;i++)
					{
						String row = arrParentsLoc[i].split(GenericTemplateUtility.SEP_IN_PARA_ROW_COL)[0];
						String col = arrParentsLoc[i].split(GenericTemplateUtility.SEP_IN_PARA_ROW_COL)[1];
						String id = null;
						
						for(TemplateParameterMasterVO parentVO : lstVOs)
							if(parentVO.getControlType().equals(GenericTemplateUtility.CONTROL_TYPES_LABEL))
								if(parentVO.getRow().equals(row) && parentVO.getCol().equals(col))
									id = parentVO.getParaId();
						parentsIds+=id+GenericTemplateUtility.SEP_IN_PARA_PARENT;
						parentsIdsLoc+=row+GenericTemplateUtility.SEP_IN_PARA_ROW_COL+col+GenericTemplateUtility.SEP_IN_PARA_PARENT;
					}
					if(parentsIds!="") parentsIds=parentsIds.substring(0,parentsIds.length()-1);
					if(parentsIdsLoc!="") parentsIdsLoc=parentsIdsLoc.substring(0,parentsIdsLoc.length()-1);

					vo.setParentParaId(parentsIds);
					vo.setParentIdLocation(parentsIdsLoc);
				}
			}
			
			// Setting Dependents Para Id/Source Id is Any
			for(TemplateParameterMasterVO vo : lstVOs)
			{				
				//if(vo.getHaveDependent().equals(TemplateDesignerUtility.YES_NO_VALUE_YES))
				if(!vo.getDependentParaId().trim().equalsIgnoreCase(""))
				{
					String[] arrDependents = vo.getDependentParaId().split(GenericTemplateUtility.SEP_IN_PARA_DEPENDENTS);
					StringBuffer dependentsIds = new StringBuffer("");
					for(String dependentId : arrDependents)
					{
						if(!dependentId.equals(""))
						{
							String row = dependentId.split(GenericTemplateUtility.SEP_IN_PARA_ROW_COL)[0];
							String col = dependentId.split(GenericTemplateUtility.SEP_IN_PARA_ROW_COL)[1];
							TemplateParameterMasterVO dependentCell = null;
							for(TemplateParameterMasterVO tempParaVO : lstVOs)
								if(tempParaVO.getRow().equals(row) && tempParaVO.getCol().equals(col))
								{
									dependentCell = tempParaVO;
									break;
								}
							dependentsIds.append(dependentCell.getParaId() + GenericTemplateUtility.SEP_IN_PARA_DEPENDENTS);
						}
						else
							dependentsIds.append("" + GenericTemplateUtility.SEP_IN_PARA_DEPENDENTS);
					}
					dependentsIds.replace(dependentsIds.length() - GenericTemplateUtility.SEP_IN_PARA_DEPENDENTS.length(), dependentsIds.length(), "");
					vo.setDependentParaId(dependentsIds.toString());
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new HisException(e.getMessage());
		}
		return isHTMLSave;
	}

	// Fetch Template for Modification
	public static void fetchTemplateForModification(TemplateParameterMasterFB _fb,HttpServletRequest _request)
	{
		Status  objStatus=new Status();
		try
		{
			UserVO userVO = null;
			//setSysdate(_request);
			HttpSession session = _request.getSession();
			
			// Fetching Selected Record Primary Key
			String chk=_fb.getChk()[0].replace("^","@");
			String[] concatid=chk.split("@");
			
			_fb.setTemplateId(concatid[0]);
			_fb.setTempSerialNo(concatid[1]);
			
			// Template	Name & Type
			TemplateMasterVO voTemp=new TemplateMasterVO();
			voTemp.setTemplateId(_fb.getTemplateId());
			voTemp.setTempSerialNo(_fb.getTempSerialNo());
			voTemp = GenericTemplateDATA.getTemplateDataById(voTemp, userVO);

			_fb.setOldTemplateName(voTemp.getTemplateName());
			_fb.setTemplateName(voTemp.getTemplateName());
			_fb.setOldTemplateCategory(voTemp.getTemplateCategory());
			_fb.setTemplateCategory(voTemp.getTemplateCategory());			
			_fb.setTemplateType(voTemp.getTemplateType());
			_fb.setEffectiveFrom(voTemp.getEffectiveFrom());
			_fb.setOldEffectiveTo(voTemp.getEffectiveTo());
			_fb.setEffectiveTo(voTemp.getEffectiveTo());

			List<TemplateCategoryVO> lstTempCategory = GenericTemplateDATA.getTemplateCategoryList(userVO);
			WebUTIL.setAttributeInSession(_request, GenericTemplateConfig.ESSENTIAL_LIST_ALL_TEMPLATE_CATEGORY, lstTempCategory);
			
			// Set Template Category Description
			List<TemplateCategoryVO> lstTempCat = (List<TemplateCategoryVO>)session.getAttribute(GenericTemplateConfig.ESSENTIAL_LIST_ALL_TEMPLATE_CATEGORY);
			for(TemplateCategoryVO vo : lstTempCat)
			{
				if(vo.getTemplateCategory().equals(_fb.getTemplateCategory()))
				{
					_fb.setTemplateCategoryType(vo.getTemplateCategoryType());
					_fb.setTemplateCategoryName(vo.getTemplateCategoryType());
					_fb.setTemplateGroupID(vo.getTemplateGroupID());
					break;
				}
			}			

			objStatus.add(Status.NEW);
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
		finally
		{
			WebUTIL.setStatus(_request,objStatus);
		}	
	}
	
	// Fetch Template for Modification
	public static void fetchTemplateParaForModification(TemplateParameterMasterFB _fb,HttpServletRequest _request)
	{
		Status  objStatus=new Status();
		List<Entry> lstPara = new ArrayList<Entry>();
		List<TemplateParameterMasterVO> lstParaDetail = null;
		try
		{
			UserVO userVO = null;
			//setSysdate(_request);
			
			// Fetching Parameter List

			WebUTIL.setAttributeInSession(_request, GenericTemplateConfig.ESSENTIAL_LIST_ALL_INFORMATION_CONTROL_VALUES, InformationControlBean.fetchInformationList());

			if(_fb.getTemplateType().equalsIgnoreCase(GenericTemplateConfig.TEMPLATE_TYPE_NORMAL) ||
					_fb.getTemplateType().equalsIgnoreCase(GenericTemplateConfig.TEMPLATE_TYPE_MATRIX) ||
					_fb.getTemplateType().equalsIgnoreCase(GenericTemplateConfig.TEMPLATE_TYPE_CONSENT) )
			{
				lstPara=GenericTemplateDATA.getClinicalParameterListGroupWise(_fb.getTemplateGroupID(), userVO);
			}
			WebUTIL.setAttributeInSession(_request,GenericTemplateConfig.ESSENTIAL_LIST_ALL_CLINICAL_PARAMETERS, lstPara);

			// Parameter Detail  
			lstParaDetail=GenericTemplateDATA.getTempParaDetailList(_fb.getTemplateId() ,userVO);
			
			Map<String,String> mapParaName = new HashMap<String, String>();
			for(Entry e : lstPara)
			{
				mapParaName.put(e.getValue() , e.getLabel());
			}
			
			// RowCount, ColCount , ParameterValuesList
			int rows=0, cols=0;
			for(TemplateParameterMasterVO vo: lstParaDetail)
			{
				if(rows<Integer.parseInt(vo.getRow())) rows=Integer.parseInt(vo.getRow());
				if(cols<(Integer.parseInt(vo.getCol()) + Integer.parseInt(vo.getColspan())-1) ) cols=Integer.parseInt(vo.getCol())+Integer.parseInt(vo.getColspan())-1;
			}
			String paraValue = GenericTemplateUtility.getValueStringFromTempParaVOList(lstParaDetail, mapParaName);
			_fb.setRowCount(Integer.toString(rows));
			_fb.setColCount(Integer.toString(cols));
			_fb.setParameterValuesList(paraValue);
			
			// Getting ImageView Images & set In Session
			Map<String, byte[]> mpImageViewImageData = GenericTemplateUtility.getTemplateImageViewImageFilesData(_fb.getTemplateId(), lstParaDetail);
			WebUTIL.setAttributeInSession(_request, GenericTemplateConfig.GENERIC_TEMPLATE_IMAGEVIEW_UPLOADED_IMAGE_FILE_DATA_MAP, mpImageViewImageData);
			
			objStatus.add(Status.NEW);
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
		finally
		{
			WebUTIL.setStatus(_request,objStatus);
		}	
	}

	// Modify Template 
	public static void updateTemplate(TemplateParameterMasterFB _fb,HttpServletRequest _request)
	{
		Status  objStatus=new Status();
		HttpSession session = _request.getSession();
		try
		{
			UserVO userVO = null;
			//setSysdate(_request);
			
			// Set Template Category Description
			List<TemplateCategoryVO> lstTempCat = (List<TemplateCategoryVO>)session.getAttribute(GenericTemplateConfig.ESSENTIAL_LIST_ALL_TEMPLATE_CATEGORY);
			for(TemplateCategoryVO vo :lstTempCat)
			{
				if(vo.getTemplateCategory().equals(_fb.getTemplateCategory()))
				{
					_fb.setTemplateCategoryType(vo.getTemplateCategoryType());
					_fb.setTemplateCategoryName(vo.getTemplateCategoryType());
					_fb.setTemplateGroupID(vo.getTemplateGroupID());
					break;
				}
			}			

			if(!_fb.getOldTemplateName().equalsIgnoreCase(_fb.getTemplateName().trim())
					|| !_fb.getOldTemplateCategory().equalsIgnoreCase(_fb.getTemplateCategory())
					|| !_fb.getOldEffectiveTo().equalsIgnoreCase(_fb.getEffectiveTo()))
			{
				TemplateMasterVO voTemplate= new TemplateMasterVO();

				voTemplate.setTemplateId(_fb.getTemplateId());
				voTemplate.setTempSerialNo(_fb.getTempSerialNo());
				voTemplate.setTemplateName(_fb.getTemplateName());
				voTemplate.setTemplateCategory(_fb.getTemplateCategory());
				voTemplate.setTemplateType(_fb.getTemplateType());
				voTemplate.setEffectiveFrom(_fb.getEffectiveFrom());
				if(_fb.getEffectiveTo().trim().equals("")) _fb.setEffectiveTo(null);
				voTemplate.setEffectiveTo(_fb.getEffectiveTo());
				
				GenericTemplateDATA.updateTemplateData(voTemplate,userVO);
				
				if(_fb.getEffectiveTo()==null) _fb.setEffectiveTo("");
				
				objStatus.add(Status.NEW,"Template Modified Successfully","");		
			}
			else
				objStatus.add(Status.NEW);
		}
		catch(HisRecordNotFoundException e)
		{
			e.printStackTrace();
			_fb.setHmode("NOTFOUND");
			if(_fb.getEffectiveTo()== null) _fb.setEffectiveTo("");
			objStatus.add(Status.NEW,"",e.getMessage());
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
	
	//* Update Parameters to Template
	public static void updateParameterToTemplateMaster(TemplateParameterMasterFB _fb,HttpServletRequest _request)
	{
		Status  objStatus=new Status();
		HttpSession session = _request.getSession();
		try
		{
			//CharacterEncoding.setCharacterEncoding(_request);
			_fb.setParameterValuesList(_request.getParameter("parameterValuesList"));
			UserVO userVO = null;
			//setSysdate(_request);
			
			// Removing Old Data
			GenericTemplateDATA.deleteOldTempParaDetialByTempId(_fb.getTemplateId(),userVO);

			TemplateMasterVO voTemplate= new TemplateMasterVO();
			voTemplate.setTemplateName(_fb.getTemplateName().trim());
			voTemplate.setTemplateType(_fb.getTemplateType());
			voTemplate.setEffectiveFrom(_fb.getEffectiveFrom());
			voTemplate.setEffectiveTo(_fb.getEffectiveTo());
			voTemplate.setTemplateId(_fb.getTemplateId());
			
			// Getting Parameter VO List to Add
			List<ParameterMasterVO> lstNewParas = new ArrayList<ParameterMasterVO>();
			// Getting Template Parameter VOs List
			Map<String, TemplateParameterMasterVO> mapParaRowCol = new HashMap<String, TemplateParameterMasterVO>();
				// Image View Image Files
			Map<String,String> mpImageViewKeyExt = new HashMap<String, String>();
			List<TemplateParameterMasterVO> lstVOs = GenericTemplateUtility.getTempParaVOListFromValues(_fb.getParameterValuesList(),voTemplate,lstNewParas,mapParaRowCol,mpImageViewKeyExt); 
			
			// Saving and Setting New Parameters
			if(lstNewParas.size()>0)
			{
				// Setting Map of Loc & Para Id of All
				Map<String, ParameterMasterVO> mpLocParaVO = new HashMap<String, ParameterMasterVO>();
				for(String k : mapParaRowCol.keySet())
				{
					ParameterMasterVO paraVO = new ParameterMasterVO();
					paraVO.setParaId(mapParaRowCol.get(k).getParaId());
					paraVO.setParaName(mapParaRowCol.get(k).getParaName());
					mpLocParaVO.put(k, paraVO);
				}
				Map<String,ParameterMasterVO> mpAllLocParaId = GenericTemplateDATA.saveNewAddedParameters(lstNewParas, mpLocParaVO, _fb.getTemplateGroupID(), userVO);

				for(ParameterMasterVO paraVO : lstNewParas)
				{
					String key = paraVO.getKey();
					String paraId = mpAllLocParaId.get(key).getParaId();					
					if(paraId!=null)
					{
						TemplateParameterMasterVO vo = mapParaRowCol.get(key);
						vo.setParaId(paraId);
					}
				}
			}

			// Setting Parents and Dependent Para Ids
			boolean isHTMLSave = TemplateParameterMasterUTL.setParentIdLocNDependents(lstVOs);
			// Saving in HTML File
			GenericTemplateUtility.saveTemplateInHTMLFile(isHTMLSave, voTemplate,lstVOs);

			// Saving ImageView Images Files			
			Map<String, byte[]> mpImageViewImageData = null;
			if(session.getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_IMAGEVIEW_UPLOADED_IMAGE_FILE_DATA_MAP)!=null)
				mpImageViewImageData = (Map<String, byte[]>)session.getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_IMAGEVIEW_UPLOADED_IMAGE_FILE_DATA_MAP);
			GenericTemplateUtility.saveTemplateImageViewImagesInFile(voTemplate, mpImageViewImageData, mpImageViewKeyExt);

			// Saving Parameters 
			GenericTemplateDATA.saveParametersToTemplate(lstVOs, userVO);			
			
			objStatus.add(Status.NEW,"","Template and its Parameter Detail Successfully Modified");
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
		finally
		{
			WebUTIL.setStatus(_request,objStatus);
		}	
	}

	// Get Template & its Parameter Detail for View
	public static void getTemplateParameterDetailForView(TemplateParameterMasterFB _fb,HttpServletRequest _request)
	{
		Status  objStatus=new Status();
		try
		{
			UserVO userVO = null;
			//setSysdate(_request);
			HttpSession session = _request.getSession();
			
			// Fetching Selected Record Primary Key
			String chk=_fb.getChk()[0].replace("^","@");
			String[] concatid=chk.split("@");
			
			_fb.setTemplateId(concatid[0]);
			_fb.setTempSerialNo(concatid[1]);
			
			// Template	Name & Type
			TemplateMasterVO voTemp=new TemplateMasterVO();
			voTemp.setTemplateId(_fb.getTemplateId());
			voTemp.setTempSerialNo(_fb.getTempSerialNo());
			voTemp = GenericTemplateDATA.getTemplateDataById(voTemp, userVO);

			_fb.setOldTemplateName(voTemp.getTemplateName());
			_fb.setTemplateName(voTemp.getTemplateName());
			_fb.setOldTemplateCategory(voTemp.getTemplateCategory());
			_fb.setTemplateCategory(voTemp.getTemplateCategory());			
			_fb.setTemplateType(voTemp.getTemplateType());
			_fb.setEffectiveFrom(voTemp.getEffectiveFrom());
			_fb.setOldEffectiveTo(voTemp.getEffectiveTo());
			_fb.setEffectiveTo(voTemp.getEffectiveTo());

			List<TemplateCategoryVO> lstTempCategory = GenericTemplateDATA.getTemplateCategoryList(userVO);
			WebUTIL.setAttributeInSession(_request, GenericTemplateConfig.ESSENTIAL_LIST_ALL_TEMPLATE_CATEGORY, lstTempCategory);
			
			// Set Template Category Description
			List<TemplateCategoryVO> lstTempCat = (List<TemplateCategoryVO>)session.getAttribute(GenericTemplateConfig.ESSENTIAL_LIST_ALL_TEMPLATE_CATEGORY);
			for(TemplateCategoryVO vo : lstTempCat)
			{
				if(vo.getTemplateCategory().equals(_fb.getTemplateCategory()))
				{
					_fb.setTemplateCategoryType(vo.getTemplateCategoryType());
					_fb.setTemplateCategoryName(vo.getTemplateCategoryType());
					_fb.setTemplateGroupID(vo.getTemplateGroupID());
					break;
				}
			}			

			objStatus.add(Status.NEW);
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
		finally
		{
			WebUTIL.setStatus(_request,objStatus);
		}	
	}
}
