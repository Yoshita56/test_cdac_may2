package mms.reports.bo;

import mms.reports.dao.ListSlowFastMovingItemsRptDAO;
import mms.reports.vo.ListSlowFastMovingItemsRptVO;

public class ListSlowFastMovingItemsRptBO {
	
public void getStoreList(ListSlowFastMovingItemsRptVO voObj){
		
		ListSlowFastMovingItemsRptDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("ListSlowFastMovingItemsRptBO.getStoreList()-->"+strErr);
				}
				
		}

public void getItemCatList(ListSlowFastMovingItemsRptVO voObj){
	
	ListSlowFastMovingItemsRptDAO.getItemCatList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("ListSlowFastMovingItemsRptBO.getItemCatList()-->"+strErr);
			}
			
	}

}
