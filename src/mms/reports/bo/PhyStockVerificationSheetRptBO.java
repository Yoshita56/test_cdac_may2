package mms.reports.bo;

import mms.reports.dao.PhyStockVerificationSheetRptDAO;
import mms.reports.vo.PhyStockVerificationSheetRptVO;

public class PhyStockVerificationSheetRptBO {
	
public void getStoreList(PhyStockVerificationSheetRptVO voObj){
		
		PhyStockVerificationSheetRptDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("PhyStockVerificationSheetRptBO.getStoreList()-->"+strErr);
				}
				
		}

public void getItemCatList(PhyStockVerificationSheetRptVO voObj){
	
	PhyStockVerificationSheetRptDAO.getItemCatList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("PhyStockVerificationSheetRptBO.getItemCatList()-->"+strErr);
			}
			
	}


public void getGroupList(PhyStockVerificationSheetRptVO voObj){
	
	PhyStockVerificationSheetRptDAO.getGroupList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("PhyStockVerificationSheetRptBO.getGroupList()-->"+strErr);
			}
			
	}

public void getItemList(PhyStockVerificationSheetRptVO voObj){
	
	PhyStockVerificationSheetRptDAO.getItemList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("PhyStockVerificationSheetRptBO.getItemList()-->"+strErr);
			}
			
	}


}
