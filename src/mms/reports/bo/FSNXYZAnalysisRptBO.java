package mms.reports.bo;

import mms.reports.dao.FSNXYZAnalysisRptDAO;
import mms.reports.vo.FSNXYZAnalysisRptVO;

public class FSNXYZAnalysisRptBO {
	
public void getStoreList(FSNXYZAnalysisRptVO voObj){
		
		FSNXYZAnalysisRptDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("FSNXYZAnalysisRptBO.getStoreList()-->"+strErr);
				}
				
		}

public void getItemCatList(FSNXYZAnalysisRptVO voObj){
	
	FSNXYZAnalysisRptDAO.getItemCatList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("FSNXYZAnalysisRptBO.getItemCatList()-->"+strErr);
			}
			
	}

}
