package mms.reports.bo;

import mms.reports.dao.DailyActivityRptDAO;
import mms.reports.dao.StockOnHandRptDAO;
import mms.reports.vo.DailyActivityRptVO;
import mms.reports.vo.StockOnHandRptVO;

public class StockOnHandRptBO {
	
public void getStoreList(StockOnHandRptVO voObj){
		
		StockOnHandRptDAO.getStoreList(voObj);
		//StockOnHandRptDAO.getDistrictStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("StockOnHandRptBO.getStoreList()-->"+strErr);
				}
				
		}

public void getItemCatList(StockOnHandRptVO voObj){
	
	StockOnHandRptDAO.getItemCatList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("StockOnHandRptBO.getItemCatList()-->"+strErr);
			}
			
	}

public void getGroupList(StockOnHandRptVO voObj){
	
	StockOnHandRptDAO.getGroupList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("StockOnHandRptBO.getGroupList()-->"+strErr);
			}
			
	}

public void GetUserLevel(StockOnHandRptVO voObj){
	StockOnHandRptDAO.GetUserLevel(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("StockOnHandRptBO.GetUserLevel()-->"+strErr);
			}
}

}
