package mms.reports.bo;

import mms.reports.dao.ListItemsReorderLevelRptDAO;
import mms.reports.vo.ListItemsReorderLevelRptVO;

public class ListItemsReorderLevelRptBO {
	
public void getStoreList(ListItemsReorderLevelRptVO voObj){
		
		ListItemsReorderLevelRptDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("ListItemsReorderLevelRptBO.getStoreList()-->"+strErr);
				}
				
		}

public void getItemCatList(ListItemsReorderLevelRptVO voObj){
	
	ListItemsReorderLevelRptDAO.getItemCatList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("ListItemsReorderLevelRptBO.getItemCatList()-->"+strErr);
			}
			
	}

}
