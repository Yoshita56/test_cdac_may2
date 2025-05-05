package mms.transactions.bo;

import mms.transactions.dao.ExportRecordsTransDAO;
import mms.transactions.vo.ExportRecordsTransVO;

public class ExportRecordsTransBO {

	
	public void getExportTemplateList(ExportRecordsTransVO vo) {
			
			
		ExportRecordsTransDAO.getTemplateList(vo);
			
			if (vo.getStrMsgType().equals("1"))
				vo.setStrMsgString("ExportRecordsTransBO.getExportTemplateList()---->"
						+ vo.getStrMsgString());
		}

	
public void exportRecords(ExportRecordsTransVO vo) {
		
		ExportRecordsTransDAO.exportData(vo);
	 
		
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("ExportRecordsTransBO.exportRecords()---->"
					+ vo.getStrMsgString());
	}

	

	public void getParamDetails(ExportRecordsTransVO vo) {
		
		ExportRecordsTransDAO.getTemplateDetails(vo);
	 
		
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("ExportRecordsTransBO.getParamDetails()---->"
					+ vo.getStrMsgString());
	}

	
}
