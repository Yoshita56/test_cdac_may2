package mms.reports.bo;

import mms.reports.dao.PurchaseItemInventoryRptDAO;
import mms.reports.vo.PurchaseItemInventoryRptVO;

public class PurchaseItemInventoryRptBO {
	
public void getStoreList(PurchaseItemInventoryRptVO voObj){
		
		PurchaseItemInventoryRptDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("PurchaseItemInventoryRptBO.getStoreList()-->"+strErr);
				}
				
		}

public void getItemCatList(PurchaseItemInventoryRptVO voObj){
	
	PurchaseItemInventoryRptDAO.getItemCatList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("PurchaseItemInventoryRptBO.getItemCatList()-->"+strErr);
			}
			
	}
public void getPOTypeList(PurchaseItemInventoryRptVO voObj){
	
	PurchaseItemInventoryRptDAO.getPOTypeList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("PurchaseItemInventoryRptBO.getPOTypeList()-->"+strErr);
			}
			
	}
public void getSupplierList(PurchaseItemInventoryRptVO voObj){
	
	PurchaseItemInventoryRptDAO.getSupplierList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("PurchaseItemInventoryRptBO.getSupplierList()-->"+strErr);
			}
			
	}


	public void getItemName(PurchaseItemInventoryRptVO voObj)
	{
		PurchaseItemInventoryRptDAO.getItemName(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
			String strErr = voObj.getStrMsgString();
			voObj.setStrMsgString("PurchaseItemInventoryRptBO.getItemName()-->"+strErr);
		}		
	}
	
	public void getReportDtl(PurchaseItemInventoryRptVO voObj)
	{
		PurchaseItemInventoryRptDAO.getReportDtl(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
			String strErr = voObj.getStrMsgString();
			voObj.setStrMsgString("PurchaseItemInventoryRptBO.getReportDtl()-->"+strErr);
		}		
	}
}
