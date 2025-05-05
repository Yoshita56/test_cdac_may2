package mms.reports.bo;


import mms.reports.dao.ConsumptionRptDAO;
import mms.reports.vo.IssueToThirdPartyRptVO;
import mms.reports.vo.ConsumptionRptVO;

public class ConsumptionRptBO {
	
public void getStoreList(ConsumptionRptVO voObj){
		
		ConsumptionRptDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("ConsumptionRptBO.getStoreList()-->"+strErr);
				}
				
		}

public void getItemCatList(ConsumptionRptVO voObj){
	
	ConsumptionRptDAO.getItemCatList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("ConsumptionRptBO.getItemCatList()-->"+strErr);
			}
			
	}
public void getItemList(ConsumptionRptVO voObj){
	
	ConsumptionRptDAO.getItemList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("ConsumptionRptBO.getItemCatList()-->"+strErr);
			}
			
	}
public void getSupplierList(ConsumptionRptVO voObj){
	
	ConsumptionRptDAO.getSupplierList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("ConsumptionRptBO.getItemCatList()-->"+strErr);
			}
			
	}

public void GetUserLevel(ConsumptionRptVO voObj){
	ConsumptionRptDAO.GetUserLevel(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("ConsumptionRptBO.GetUserLevel()-->"+strErr);
			}
}

}
