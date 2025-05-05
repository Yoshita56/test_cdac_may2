/**
## Copyright Information		: 	C-DAC, Noida  
## Project Name					: 	HIS-NIMS
## Name of Developer		 	: 	
## Module Name					: 	OPD, IPD For template design
## Process/Database Object Name	:	TemplateParameterMaster
## Purpose						:	Util File for taking FB Value to userDeskVO
## Date of Creation				: 	16-December-2014
## Modification Log				:					
##		Modify Date				: 	31-12-2014
##		Reason	(CR/PRS)		: 	Multilingual Suport fro "Display Value"
##		Modify By				:	Akash Singh
*/
package hisglobal.utility.generictemplate;

import hisglobal.hisconfig.Config;
import hisglobal.presentation.WebUTIL;
import hisglobal.utility.Entry;
import hisglobal.utility.HisFileControlUtil;
import hisglobal.vo.ParameterMasterVO;
import hisglobal.vo.ParameterRangeMasterVO;
import hisglobal.vo.TemplateMasterVO;
import hisglobal.vo.TemplateParameterMasterVO;
import hisglobal.vo.ValueObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * @copyright CDAC
 * @developer Pragya Sharma
 */

public class GenericTemplateUtility 
{	
	/** Getting Template Parameters VOs from Values String
	 * @param _values
	 * @param _tempVO
	 * @param _lstNewParas
	 * @param _mapParaRowCol
	 * @return
	 */
	public static List<TemplateParameterMasterVO> getTempParaVOListFromValues(String _values, TemplateMasterVO _tempVO, List<ParameterMasterVO> _lstNewParas, Map<String, TemplateParameterMasterVO> _mapParaRowCol, Map<String,String> _mpImageViewNameExt)
	{
		List<TemplateParameterMasterVO> lst = new ArrayList<TemplateParameterMasterVO>();
		try
		{			
			String[] arrParams = _values.split(SEP_VAL_IN_PARA);
			Map<String, String> mapParaNames = new HashMap<String, String>();
			
			for(int i=0;i<arrParams.length;i++)
			{
				TemplateParameterMasterVO vo = new TemplateParameterMasterVO();
				vo.setTemplateId(_tempVO.getTemplateId());

				String arrVals[]= arrParams[i].split(SEP_VAL_PARA_FEATURES);
				
				int j=0;
				// Row, Col
				vo.setRow(arrVals[j++]);
				vo.setCol(arrVals[j++]);

				// Para Id , Para Name, Parent
				String paraId = arrVals[j++].trim();
				String paraName = arrVals[j++].trim();
					//********* Parameter Present Map
				if(!paraName.equals(""))
					mapParaNames.put( vo.getRow()+SEP_IN_PARA_ROW_COL+vo.getCol(), paraName);
				vo.setParaId(paraId);			
				vo.setParentParaId(arrVals[j++].trim());
				// Adding to List if new Parameter
				if( !paraName.equals("") && paraId.equals(""))
				{
					ParameterMasterVO paraVO = new ParameterMasterVO();
					paraVO.setParaName(paraName);
					String key = vo.getRow()+SEP_IN_PARA_ROW_COL+vo.getCol();
					//paraVO.setParaId(key);//------------Those have name but no id  (as key in id,key)
					if(vo.getParentParaId()!=null && !vo.getParentParaId().trim().equals(""))
						paraVO.setParentPara(vo.getParentParaId());
					paraVO.setKey(key);
					_lstNewParas.add(paraVO);
					_mapParaRowCol.put(key, vo);
				}
				else if(!paraId.equals("") || (vo.getParentParaId()!=null && !vo.getParentParaId().trim().equals("")) )
				{
					String key = vo.getRow()+SEP_IN_PARA_ROW_COL+vo.getCol();
					_mapParaRowCol.put(key, vo);  // putting for reference
				}
					
				
				// Location Type, Colspan
				vo.setLocationType(arrVals[j++]);
				vo.setColspan(arrVals[j++]);
				
				// Control Type
				vo.setControlType(arrVals[j++]);
				
				// Display Value
				String strDisVal = arrVals[j++];
				//byte[] bytes = strDisVal.getBytes();
				//strDisVal = new String(bytes, "UTF-8");
				//byte[] utf = strDisVal.getBytes("UTF-8");
				//strDisVal = new String(utf, "UTF-8");
				//strDisVal = new String(utf);
				String param1 = strDisVal;
				//if(param1!=null)
				//{
				//  param1 = new String(param1.getBytes("ISO-8859-1"));
				//}
				strDisVal = StringEscapeUtils.unescapeHtml(param1); 
				vo.setDisplayValue(strDisVal);
				
				// Control Properties
					//String controlProps[] = arrVals[j++].split(SEP_VAL_IN_PROPS);
					//String propValue = controlProps[Arrays.asList(CONTROL_PROPS_ARR).indexOf("propName")];
				vo.setControlProps(arrVals[j++]);
				
				// Source Flag , Static Options, Dynamic Query
				vo.setSourceFlag(arrVals[j++]);
				vo.setStaticOptions(arrVals[j++]);
				vo.setDynamicQuery(arrVals[j++]);

				// Have Dependent And Dependent Para Id
				vo.setHaveDependent(arrVals[j++]);
				vo.setDependentParaId(arrVals[j++]);

				// Compulsory Flag, Range Flag
				vo.setIsCompulsory(arrVals[j++]);
				vo.setIsRange(arrVals[j++]);

				lst.add(vo);				

				
				//*********** Image View Case
				if(vo.getControlType().equals(CONTROL_TYPES_IMAGEVIEW))
				{
					// Control Properties
					String controlProps[] = vo.getControlProps().split(SEP_VAL_IN_PROPS);
					String defaultValue = controlProps[Arrays.asList(CONTROL_PROPS_ARR).indexOf("defaultValue")];
					_mpImageViewNameExt.put(vo.getRow()+SEP_IMAGEVIEW_KEY_ROW_COL+vo.getCol(), defaultValue);
				}
			}
			
			// Adding Mixed Parameters in Case of Matrix Template
			if(_tempVO.getTemplateType().equalsIgnoreCase(GenericTemplateConfig.TEMPLATE_TYPE_MATRIX))
			{
				// Here we can create a new Array for the location Parent Based Parameters  
				for(TemplateParameterMasterVO vo : lst)
				{
					if( vo.getParentParaId()!=null && !vo.getParentParaId().trim().equals("") 
							&& !vo.getControlType().equals(GenericTemplateUtility.CONTROL_TYPES_LABEL) 
							&& !vo.getControlType().equals(GenericTemplateUtility.CONTROL_TYPES_COMMENT) 
							&& !vo.getControlType().equals(GenericTemplateUtility.CONTROL_TYPES_IMAGEVIEW) 
							&& !vo.getControlType().equals(GenericTemplateUtility.CONTROL_TYPES_INFORMATION) )
					{
						String paraName ="";
						String arrParentsLoc[] = vo.getParentParaId().split(GenericTemplateUtility.SEP_IN_PARA_PARENT);
						for(int i=0;i<arrParentsLoc.length;i++)
						{
							paraName+=mapParaNames.get(arrParentsLoc[i])+" ";
						}
						paraName = paraName.trim();
						if( !paraName.equals("") && vo.getParaId().equals(""))
						{
							ParameterMasterVO paraVO = new ParameterMasterVO();
							paraVO.setParaName(paraName);
							String key = vo.getRow()+SEP_IN_PARA_ROW_COL+vo.getCol();
							//paraVO.setParaId(key);//---------- for non 
							paraVO.setKey(key);
							paraVO.setParentPara(vo.getParentParaId());
							paraVO.setIsParentBased("1");
							_lstNewParas.add(paraVO);

							_mapParaRowCol.put(key, vo);
						}
					}
				}
			}		
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}
		return lst;
	}
	
	public static void saveTemplateInHTMLFile(boolean isHTMLSave, TemplateMasterVO _tempVO, List<TemplateParameterMasterVO> _lstVOs)
	{
		try
		{
			// Saving in HTML File
			HisFileControlUtil fileUtil = new HisFileControlUtil();
			fileUtil.setFileName(Config.GENERIC_TEMPLATE_HTML_DOCUMENT_FILE_STORAGE_NAME+_tempVO.getTemplateId()+Config.GENERIC_TEMPLATE_HTML_DOCUMENT_FILE_STORAGE_EXT);
			fileUtil.setWindowsFilePath(Config.GENERIC_TEMPLATE_HTML_DOCUMENT_FILE_STORAGE_PATH_WINDOWS);
			fileUtil.setLinuxFilePath(Config.GENERIC_TEMPLATE_HTML_DOCUMENT_FILE_STORAGE_PATH_LINUX);
			if(isHTMLSave)
			{
				String templateHTMLCode = GenericTemplateUtility.generateHTMLTemplate(_tempVO.getTemplateId(),_tempVO.getTemplateType(), _lstVOs, new HashMap<String, ParameterRangeMasterVO>(), new InformationControlBean(), Config.GENDER_TYPE_OTHER, GenericTemplateConfig.GENERIC_TEMPLATE_MODE_EDITABLE);
				fileUtil.setFileContent(templateHTMLCode.getBytes());
				fileUtil.saveFile();
			}
			else
			{
				fileUtil.deleteFile();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void saveTemplateImageViewImagesInFile(TemplateMasterVO _tempVO, Map<String, byte[]> _mpImageViewImageData, Map<String, String> _mpImageViewExts)
	{
		try
		{
			if(_mpImageViewImageData!=null && _mpImageViewImageData.keySet().size()>0)
			{
				// Saving in Image Files
				for(String key : _mpImageViewExts.keySet())
				{
					String fileName = Config.GENERIC_TEMPLATE_IMAGE_VIEW_FILE_STORAGE_NAME + _tempVO.getTemplateId() 
						+ "_" + key + _mpImageViewExts.get(key);
					
					HisFileControlUtil fileUtil = new HisFileControlUtil();
					fileUtil.setFileName(fileName);
					fileUtil.setWindowsFilePath(Config.GENERIC_TEMPLATE_HTML_DOCUMENT_FILE_STORAGE_PATH_WINDOWS);
					fileUtil.setLinuxFilePath(Config.GENERIC_TEMPLATE_HTML_DOCUMENT_FILE_STORAGE_PATH_LINUX);
					fileUtil.setFileContent(_mpImageViewImageData.get(key));
					fileUtil.saveFile();
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static String readTemplateFromHTMLFile(String _templateId)
	{
		String htmlCode = null;
		try
		{
			boolean isHTMLSave;
			// Reading From HTML File
			HisFileControlUtil fileUtil = new HisFileControlUtil();
			fileUtil.setFileName(Config.GENERIC_TEMPLATE_HTML_DOCUMENT_FILE_STORAGE_NAME+_templateId+Config.GENERIC_TEMPLATE_HTML_DOCUMENT_FILE_STORAGE_EXT);
			fileUtil.setWindowsFilePath(Config.GENERIC_TEMPLATE_HTML_DOCUMENT_FILE_STORAGE_PATH_WINDOWS);
			fileUtil.setLinuxFilePath(Config.GENERIC_TEMPLATE_HTML_DOCUMENT_FILE_STORAGE_PATH_LINUX);
			isHTMLSave = fileUtil.readFile();
			if(isHTMLSave) htmlCode = fileUtil.getFileContentInString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return htmlCode;
	}

	public static Map<String, byte[]> getTemplateImageViewImageFilesData(String _templateId, List<TemplateParameterMasterVO> _lstTempParaVO)
	{
		Map<String, byte[]> mpImageViewImageData = new HashMap<String, byte[]>();
		try
		{
			for(TemplateParameterMasterVO vo: _lstTempParaVO)
			{
				if(vo.getControlType().equalsIgnoreCase(CONTROL_TYPES_IMAGEVIEW))
				{
					// Control Properties
					String controlProps[] = vo.getControlProps().split(SEP_VAL_IN_PROPS);
					String defaultValue = controlProps[Arrays.asList(CONTROL_PROPS_ARR).indexOf("defaultValue")];				

					String key = vo.getRow() + SEP_IMAGEVIEW_KEY_ROW_COL + vo.getCol();
					String fileName = Config.GENERIC_TEMPLATE_IMAGE_VIEW_FILE_STORAGE_NAME + vo.getTemplateId() 
						+ "_" + key + defaultValue;
			
					HisFileControlUtil fileUtil = new HisFileControlUtil();
					fileUtil.setFileName(fileName);
					fileUtil.setWindowsFilePath(Config.GENERIC_TEMPLATE_HTML_DOCUMENT_FILE_STORAGE_PATH_WINDOWS);
					fileUtil.setLinuxFilePath(Config.GENERIC_TEMPLATE_HTML_DOCUMENT_FILE_STORAGE_PATH_LINUX);
					
					if(fileUtil.readFile())
					{
						mpImageViewImageData.put(key, fileUtil.getFileContent());
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return mpImageViewImageData;
	}

	public static String getValueStringFromTempParaVOList(List<TemplateParameterMasterVO> _lstTempParaVO, Map<String,String> _mapParaName)
	{
		StringBuilder paraValues = new StringBuilder("");		
		try
		{
			for(TemplateParameterMasterVO vo: _lstTempParaVO)
			{
				StringBuilder temp= new StringBuilder("");
				
				// Row, Col				
				temp.append(vo.getRow() + SEP_VAL_PARA_FEATURES);
				temp.append(vo.getCol() + SEP_VAL_PARA_FEATURES);
				// Para Id , Para Name, Parent
				if(vo.getParaId()==null) 
					temp.append(""+ SEP_VAL_PARA_FEATURES + "" + SEP_VAL_PARA_FEATURES);
				else
					temp.append(vo.getParaId()+ SEP_VAL_PARA_FEATURES + _mapParaName.get(vo.getParaId()) + SEP_VAL_PARA_FEATURES);
				if(vo.getParentIdLocation()==null)
					temp.append("" + SEP_VAL_PARA_FEATURES);
				else
					temp.append(vo.getParentIdLocation() + SEP_VAL_PARA_FEATURES);
				// Location Type, Colspan
				temp.append(vo.getLocationType() + SEP_VAL_PARA_FEATURES);
				temp.append(vo.getColspan() + SEP_VAL_PARA_FEATURES);
				// Control Type
				temp.append(vo.getControlType() + SEP_VAL_PARA_FEATURES);
				if(vo.getDisplayValue()==null)
					temp.append("" + SEP_VAL_PARA_FEATURES);
				else
					//byte[] bytes = vo.getDisplayValue().getBytes();
					//String disValue = new String(bytes, "UTF-8");
					temp.append(vo.getDisplayValue() + SEP_VAL_PARA_FEATURES);
				// Control Properties
					// bold, i, u, color, align, validfunc, maxlen, format, re, defaultval			
				temp.append( vo.getControlProps()+SEP_VAL_PARA_FEATURES);
				// Source Flag , Static Options, Dynamic Query
				temp.append(vo.getSourceFlag() + SEP_VAL_PARA_FEATURES);
				if(vo.getStaticOptions()==null)
					temp.append("" + SEP_VAL_PARA_FEATURES);
				else
					temp.append(vo.getStaticOptions() + SEP_VAL_PARA_FEATURES);
				if(vo.getDynamicQuery()==null)
					temp.append("" + SEP_VAL_PARA_FEATURES);
				else
					temp.append(vo.getDynamicQuery() + SEP_VAL_PARA_FEATURES);
				
				// Have Dependent And Dependent Para Id
				temp.append(vo.getHaveDependent() + SEP_VAL_PARA_FEATURES);
				if(vo.getDependentParaId()==null)
					temp.append("" + SEP_VAL_PARA_FEATURES);
				else
					temp.append(vo.getDependentParaId() + SEP_VAL_PARA_FEATURES);

				// Compulsory Flag, Range Flag
				temp.append(vo.getIsCompulsory() + SEP_VAL_PARA_FEATURES);
				temp.append(vo.getIsRange() + SEP_VAL_PARA_FEATURES);

				paraValues.append(temp.append(SEP_VAL_IN_PARA));
			}
			if(paraValues.length()!=0)
				paraValues.setLength(paraValues.length()-5);
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}
		return paraValues.toString();
	}

	/** Generating HTML Code for Template
	 * @param _temptype Template Type
	 * @param _lstTempParaVO List og Template Parameters Vos of Template
	 * @return String of HTML code
	 */
	public static String generateHTMLTemplate(String _tempId, String _temptype, List<TemplateParameterMasterVO> _lstTempParaVO, Map<String , ParameterRangeMasterVO> _mapParaRange, InformationControlBean _infoBean, String _genderType, String _viewMode)
	{
		String htmlCode = "";
		try
		{
			TemplateDesignerUtility.Template temp = TemplateDesignerUtility.Template.getTemplate(_tempId,_temptype, _lstTempParaVO, _mapParaRange, _infoBean, _genderType);
			if(!_viewMode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_SHORT_SUMMARIZED_REPORT))
				htmlCode = temp.generateTemplate();
			else
				htmlCode = temp.generateTemplateView(_viewMode);
			System.out.print(htmlCode);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return htmlCode;
	}

	/** Generating HTML Code for Template
	 * @param _temptype Template Type
	 * @param _lstTempParaVO List og Template Parameters Vos of Template
	 * @param _mapParaValues Map of Para Id/ Para Value
	 * @return String of HTML code
	 */
	public static String generateHTMLTemplate(String _tempId, String _temptype, List<TemplateParameterMasterVO> _lstTempParaVO, Map<String , ParameterRangeMasterVO> _mapParaRange, InformationControlBean _infoBean, String _genderType, String _viewMode, Map<String, String> _mapParaValues)
	{
		String htmlCode = "";
		try
		{
			TemplateDesignerUtility.Template temp = TemplateDesignerUtility.Template.getTemplate(_tempId, _temptype, _lstTempParaVO, _mapParaRange, _infoBean, _genderType, _mapParaValues);
			if(!_viewMode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_SHORT_SUMMARIZED_REPORT))
				htmlCode = temp.generateTemplate();
			else
				htmlCode = temp.generateTemplateView(_viewMode);
			System.out.print(htmlCode);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return htmlCode;
	}

	/** Creating Tepa
	 * @param _vo
	 * @param _dynaminData
	 * @return
	 */
	public static String setParaDynamicData(TemplateParameterMasterVO _vo, List<Entry> _dynaminData)
	{
		String dynamicOptions="";
		switch(Integer.parseInt(_vo.getControlType()))
		{
			case TemplateDesignerUtility.CONTROL_TYPES_COMBO:
			case TemplateDesignerUtility.CONTROL_TYPES_RADIO:
				for(Entry entObj :_dynaminData)
				{					
					dynamicOptions+=entObj.getValue()+GenericTemplateUtility.SEP_IN_PARA_OPTIONS_LABEL_VALUE
								+entObj.getLabel()+GenericTemplateUtility.SEP_IN_PARA_OPTIONS;
				}
				if(!dynamicOptions.equals(""))dynamicOptions=dynamicOptions.substring(0,dynamicOptions.length()-1);
				break;
			case TemplateDesignerUtility.CONTROL_TYPES_CHECKBOX:
				Entry entObj=_dynaminData.get(0);
				dynamicOptions+=entObj.getValue()+GenericTemplateUtility.SEP_IN_PARA_OPTIONS_LABEL_VALUE
				+entObj.getLabel()+GenericTemplateUtility.SEP_IN_PARA_OPTIONS;
				break;
		}
		return dynamicOptions;
	}

	// Static Class to Hold Parameter Values
	public static class TempParameter extends ValueObject
	{
		private String templateId;
		private String paraId;
		private String paraParentId;
		private String paraValue;
		private String paraName;
		private String recordDate;
		
		public String getTemplateId()
		{
			return templateId;
		}
		public void setTemplateId(String templateId)
		{
			this.templateId = templateId;
		}
		public String getParaId()
		{
			return paraId;
		}
		public void setParaId(String paraId)
		{
			this.paraId = paraId;
		}
		public String getParaValue()
		{
			return paraValue;
		}
		public void setParaValue(String paraValue)
		{
			this.paraValue = paraValue;
		}
		public String getParaParentId()
		{
			return paraParentId;
		}
		public void setParaParentId(String paraParentId)
		{
			this.paraParentId = paraParentId;
		}
		public String getParaName() {
			return paraName;
		}
		public void setParaName(String paraName) {
			this.paraName = paraName;
		}
		public String getRecordDate() {
			return recordDate;
		}
		public void setRecordDate(String recordDate) {
			this.recordDate = recordDate;
		}		
	}
	
	/** Getting Parameter-Values List
	 * @param _request 
	 * @return List of Parameters Values in TempParameter class Objects
	 */
	public static List<GenericTemplateUtility.TempParameter> getTempParameterValueList(HttpServletRequest _request)
	{
		List<TempParameter> lstParaValues= new ArrayList<TempParameter>();
		
		Enumeration requestParameters = _request.getParameterNames();
		while (requestParameters.hasMoreElements())
		{
			String nextElement = (String) requestParameters.nextElement();
			if (nextElement.toString().startsWith(GenericTemplateConfig.PARAMETER_STARTS_WITH))
			{
				String requestDataArray[] = _request.getParameterValues(nextElement);
				if (requestDataArray.length != 0) 
					for (int i = 0; i < requestDataArray.length; i++)
						if (!requestDataArray[i].trim().equals(""))
						{
							TempParameter tempPara = new TempParameter();
							String pId = (String) nextElement;
							pId = pId.replace(GenericTemplateConfig.PARAMETER_STARTS_WITH, "");							
							tempPara.setTemplateId(pId.split(SEP_IN_PARA_NAMEID_TEMPID)[2]);
							tempPara.setParaParentId(pId.split(SEP_IN_PARA_NAMEID_TEMPID)[1]);
							tempPara.setParaId(pId.split(SEP_IN_PARA_NAMEID_TEMPID)[0]);
							tempPara.setParaValue(requestDataArray[i]);
							lstParaValues.add(tempPara);
						}
			}
		}
		return lstParaValues;
	}
	
	/**
	 * Getting Chart Code
	 * @param _mpTemps 
	 * @param _mpVisits
	 * @param _mpTempParas
	 * @param _mpTempParaValues
	 * @return
	 */
	public static String generateChart(Map<String, String> _mpTemps, Map<String, String> _mpVisits, 
			Map<String, Map<String, String>> _mpTempParas, Map<String, Map<String, Map<String, String>>> _mpTempParaValues)
	{
		String chartCode="";
		return chartCode;
	}
	
	public static void setVOInInfoBean(HttpServletRequest _request, ValueObject _vo)
	{
		InformationControlBean infoBean = null;
		if(_request.getSession().getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_INFORMATION_BEAN) != null)
			infoBean = (InformationControlBean)_request.getSession().getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_INFORMATION_BEAN);
		else
			{
			infoBean = new InformationControlBean();
		infoBean.putDataInInfoBean(_vo);
		WebUTIL.setAttributeInSession(_request, GenericTemplateConfig.GENERIC_TEMPLATE_INFORMATION_BEAN, infoBean);
	}
	}
	//****************** Separators
	public static String SEP_IN_PARA_OPTIONS = TemplateDesignerUtility.SEP_IN_PARA_OPTIONS;
	public static String SEP_IN_PARA_OPTIONS_LABEL_VALUE = TemplateDesignerUtility.SEP_IN_PARA_OPTIONS_LABEL_VALUE;
	public static String SEP_VAL_PARA_FEATURES = TemplateDesignerUtility.SEP_VAL_PARA_FEATURES;
	public static String SEP_VAL_IN_PARA = TemplateDesignerUtility.SEP_VAL_IN_PARA;
	public static String SEP_VAL_IN_PROPS = TemplateDesignerUtility.SEP_VAL_IN_PROPS;
	public static String SEP_IN_PARA_PARENT = TemplateDesignerUtility.SEP_IN_PARA_PARENT;
	public static String SEP_IN_PARA_ROW_COL = TemplateDesignerUtility.SEP_IN_PARA_ROW_COL;
	public static String SEP_IN_PARA_NAME_ID = TemplateDesignerUtility.SEP_IN_PARA_NAME_ID;
	public static String SEP_IN_PARA_NAMEID_TEMPID = TemplateDesignerUtility.SEP_IN_PARA_NAMEID_TEMPID;
	public static String SEP_IN_PARA_DEPENDENTS = TemplateDesignerUtility.SEP_IN_PARA_DEPENDENTS;
	public static String SEP_IMAGEVIEW_KEY_ROW_COL = TemplateDesignerUtility.SEP_IMAGEVIEW_KEY_ROW_COL;
	public static String SEP_IN_FONT_SIZE_LANG = TemplateDesignerUtility.SEP_IN_FONT_SIZE_LANG;
	

	//****************** Control Type List
	public static String CONTROL_TYPES_LABEL = Integer.toString(TemplateDesignerUtility.CONTROL_TYPES_LABEL);
	public static String CONTROL_TYPES_TEXTBOX = Integer.toString(TemplateDesignerUtility.CONTROL_TYPES_TEXTBOX);
	public static String CONTROL_TYPES_TEXTAREA = Integer.toString(TemplateDesignerUtility.CONTROL_TYPES_TEXTAREA);
	public static String CONTROL_TYPES_COMBO = Integer.toString(TemplateDesignerUtility.CONTROL_TYPES_COMBO);
	public static String CONTROL_TYPES_RADIO = Integer.toString(TemplateDesignerUtility.CONTROL_TYPES_RADIO);
	public static String CONTROL_TYPES_YESNO = Integer.toString(TemplateDesignerUtility.CONTROL_TYPES_YESNO);
	public static String CONTROL_TYPES_CHECKBOX = Integer.toString(TemplateDesignerUtility.CONTROL_TYPES_CHECKBOX);
	public static String CONTROL_TYPES_COMMENT = Integer.toString(TemplateDesignerUtility.CONTROL_TYPES_COMMENT);
	public static String CONTROL_TYPES_FORMULATED = Integer.toString(TemplateDesignerUtility.CONTROL_TYPES_FORMULATED);
	public static String CONTROL_TYPES_INFORMATION = Integer.toString(TemplateDesignerUtility.CONTROL_TYPES_INFORMATION);
	public static String CONTROL_TYPES_DURATION = Integer.toString(TemplateDesignerUtility.CONTROL_TYPES_DURATION);
	public static String CONTROL_TYPES_DATE = Integer.toString(TemplateDesignerUtility.CONTROL_TYPES_DATE);
	public static String CONTROL_TYPES_TIME = Integer.toString(TemplateDesignerUtility.CONTROL_TYPES_TIME);
	public static String CONTROL_TYPES_IMAGEVIEW = Integer.toString(TemplateDesignerUtility.CONTROL_TYPES_IMAGEVIEW);


	//****************** Control Type List
	public static String[] CONTROL_PROPS_ARR = {"bold","italic","underlined","color","maxlength","colsize","rowsize",
		"validationFunction","defaultValue","regularExpression","format","formula","info","align","genderType",
		"childPresentation","childPresentationOn","presentation","size","fontsize","printingStyle","formulaOutput"};
	
	//****************** Source Flag Value
	public static String SOURCE_FLAG_STATIC = Integer.toString(TemplateDesignerUtility.SOURCE_FLAG_STATIC);
	public static String SOURCE_FLAG_DYNAMIC = Integer.toString(TemplateDesignerUtility.SOURCE_FLAG_DYNAMIC);
	
}