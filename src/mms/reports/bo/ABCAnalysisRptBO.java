package mms.reports.bo;

import mms.reports.dao.ABCAnalysisRptDAO;
import mms.reports.vo.ABCAnalysisRptVO;

public class ABCAnalysisRptBO {
	
public void getStoreList(ABCAnalysisRptVO voObj){
		
		ABCAnalysisRptDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("ABCAnalysisRptBO.getStoreList()-->"+strErr);
				}
				
		}

public void getItemCatList(ABCAnalysisRptVO voObj){
	
	ABCAnalysisRptDAO.getItemCatList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("ABCAnalysisRptBO.getItemCatList()-->"+strErr);
			}
			
	}

}
