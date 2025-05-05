package mms.reports.bo;

import mms.reports.dao.DrugTransferRptDAO;
import mms.reports.vo.DrugTransferRptVO;

public class DrugTransferRptBO {
	
public void getInitValues(DrugTransferRptVO voObj){
		
		DrugTransferRptDAO.getStoreList(voObj);
		DrugTransferRptDAO.getToStoreCombo(voObj);
		
		
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("DrugTransferRptBO.getStoreList()-->"+strErr);
				}
				
		}

	public void getStoreList(DrugTransferRptVO voObj){
	
	DrugTransferRptDAO.getStoreList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("DrugTransferRptBO.getStoreList()-->"+strErr);
			}
			
	}


	public void getToStoreList(DrugTransferRptVO voObj){
	
	DrugTransferRptDAO.getToStoreCombo(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("DrugTransferRptBO.getStoreList()-->"+strErr);
			}
			
	}

public void getItemCatList(DrugTransferRptVO voObj){
	
	DrugTransferRptDAO.getItemCatList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("DrugTransferRptBO.getItemCatList()-->"+strErr);
			}
			
	}

}
