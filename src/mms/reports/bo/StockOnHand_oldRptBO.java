package mms.reports.bo;

import mms.reports.dao.StockOnHand_oldRptDAO;
import mms.reports.vo.StockOnHand_oldRptVO;

public class StockOnHand_oldRptBO {
	
public void getStoreList(StockOnHand_oldRptVO voObj, String strUserLevel){
		
	if(strUserLevel.equals("6")){
		voObj.setStrMode("7");
	}
	else
		voObj.setStrMode("1");
	
		StockOnHand_oldRptDAO.getStoreList(voObj);
		
		if(strUserLevel.equals("6")){
			voObj.setStrMode("4");
		}
		else
			voObj.setStrMode("1");
		
		StockOnHand_oldRptDAO.getDistrictStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("StockOnHand_oldRptBO.getStoreList()-->"+strErr);
				}
				
		}

public void getItemCatList(StockOnHand_oldRptVO voObj){
	
	StockOnHand_oldRptDAO.getItemCatList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("StockOnHand_oldRptBO.getItemCatList()-->"+strErr);
			}
			
	}

public void getGroupList(StockOnHand_oldRptVO voObj){
	
	StockOnHand_oldRptDAO.getGroupList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("StockOnHand_oldRptBO.getGroupList()-->"+strErr);
			}
			
	}

}
