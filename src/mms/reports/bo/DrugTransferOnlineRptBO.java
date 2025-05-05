package mms.reports.bo;

import mms.reports.dao.DrugQualityStatusRptDAO;
import mms.reports.dao.DrugTransferOnlineRptDAO;
import mms.reports.vo.DrugTransferOnlineRptVO;

public class DrugTransferOnlineRptBO {
	
public void getInitValues(DrugTransferOnlineRptVO voObj){
		
		DrugTransferOnlineRptDAO.getStoreList(voObj);
		DrugTransferOnlineRptDAO.getToStoreCombo(voObj);
		DrugTransferOnlineRptDAO.ItemName(voObj);
		
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("DrugTransferOnlineRptBO.getStoreList()-->"+strErr);
				}
				
		}

	public void getStoreList(DrugTransferOnlineRptVO voObj){
	
	DrugTransferOnlineRptDAO.getStoreList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("DrugTransferOnlineRptBO.getStoreList()-->"+strErr);
			}
			
	}


	public void getToStoreList(DrugTransferOnlineRptVO voObj){
	
	DrugTransferOnlineRptDAO.getToStoreCombo(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("DrugTransferOnlineRptBO.getStoreList()-->"+strErr);
			}
			
	}

public void getItemCatList(DrugTransferOnlineRptVO voObj){
	
	DrugTransferOnlineRptDAO.getItemCatList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("DrugTransferOnlineRptBO.getItemCatList()-->"+strErr);
			}
			
	}

}
