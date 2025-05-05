package mms.masters.bo;

import mms.masters.dao.ImportExportTemplateMstDAO;
import mms.masters.vo.ImportExportTemplateMstVO;

public class ImportExportTemplateMstBO {

	/**
	 * main page values, gets procedure list and template list. 
	 * @param vo
	 */
	public void getMainPageValues(ImportExportTemplateMstVO vo) {
		
		ImportExportTemplateMstDAO.getProcedureList(vo);
		ImportExportTemplateMstDAO.getTemplateList(vo);
		
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("ImportExportTemplateMstBO.getMainPageValues---->"
					+ vo.getStrMsgString());
	}
	
	/**
	 * save import or export template based on the template type.
	 * @param vo
	 */
	public void saveMapping(ImportExportTemplateMstVO vo) {
		
		if(vo.getStrTemplateType().equals("1")){
			
			ImportExportTemplateMstDAO.insertImportTemplateDetails(vo);
			
		}else{
			
			ImportExportTemplateMstDAO.insertExportTemplateDetails(vo);
		}
		
		
	 
		
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("ImportExportTemplateMstBO.saveMapping---->"
					+ vo.getStrMsgString());
	}
	
	
	/**
	 * gets the template details
	 * @param vo
	 */
public void getParamDetails(ImportExportTemplateMstVO vo) {
		
		ImportExportTemplateMstDAO.getTemplateDetails(vo);
	 
		
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("ImportExportTemplateMstBO.getParamDetails---->"
					+ vo.getStrMsgString());
	}


/**
 * gets the template list.
 * @param vo
 */
public void getTemplateList(ImportExportTemplateMstVO vo) {
		
		ImportExportTemplateMstDAO.getTemplateList(vo);
	 
		
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("ImportExportTemplateMstBO.getTemplateList---->"
					+ vo.getStrMsgString());
	}

/**
 * gets the procedure list.
 * @param vo
 */
public void getProcedureList(ImportExportTemplateMstVO vo) {
	
	ImportExportTemplateMstDAO.getProcedureList(vo);
 
	
	if (vo.getStrMsgType().equals("1"))
		vo.setStrMsgString("ImportExportTemplateMstBO.getProcedureList---->"
				+ vo.getStrMsgString());
}

/**
 * deletes the procedure list.
 * @param vo
 */
public void deleteTemplate(ImportExportTemplateMstVO vo) {
	
	ImportExportTemplateMstDAO.deleteTemplateDetails(vo);
 
	
	if (vo.getStrMsgType().equals("1"))
		vo.setStrMsgString("ImportExportTemplateMstBO.deleteTemplate---->"
				+ vo.getStrMsgString());
}


}
