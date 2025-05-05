package mms.transactions.bo;

import mms.transactions.dao.ImportRecordsTransDAO;
import mms.transactions.vo.ImportRecordsTransVO;

public class ImportRecordsTransBO {

	
	/**
	 * get import template list.
	 * @param vo
	 */
public void getImportTemplateList(ImportRecordsTransVO vo) {
		
		
	ImportRecordsTransDAO.getTemplateList(vo);
		
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("ImportRecordsTransBO.getImportTemplateList()---->"
					+ vo.getStrMsgString());
	}

/**
 * gets parameter details
 * @param vo
 */
public void getParamDetails(ImportRecordsTransVO vo) {
	
	ImportRecordsTransDAO.getTemplateDetails(vo);
 
	
	if (vo.getStrMsgType().equals("1"))
		vo.setStrMsgString("ImportRecordsTransBO.getParamDetails()---->"
				+ vo.getStrMsgString());
}

/**
 * imports records 
 * @param vo
 */
public void importRecords(ImportRecordsTransVO vo) {
	
	ImportRecordsTransDAO.importData(vo);
 
	
	if (vo.getStrMsgType().equals("1"))
		vo.setStrMsgString("ImportRecordsTransBO.importRecords()---->"
				+ vo.getStrMsgString());
}

}
