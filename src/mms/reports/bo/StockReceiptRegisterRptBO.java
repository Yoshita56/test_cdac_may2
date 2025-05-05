package mms.reports.bo;


import mms.reports.dao.StockReceiptRegisterRptDAO;
import mms.reports.vo.IssueToThirdPartyRptVO;
import mms.reports.vo.StockReceiptRegisterRptVO;

public class StockReceiptRegisterRptBO {
	
public void getStoreList(StockReceiptRegisterRptVO voObj){
		
		StockReceiptRegisterRptDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("StockReceiptRegisterRptBO.getStoreList()-->"+strErr);
				}
				
		}

public void getItemCatList(StockReceiptRegisterRptVO voObj){
	
	StockReceiptRegisterRptDAO.getItemCatList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("StockReceiptRegisterRptBO.getItemCatList()-->"+strErr);
			}
			
	}
public void getItemList(StockReceiptRegisterRptVO voObj){
	
	StockReceiptRegisterRptDAO.getItemList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("StockReceiptRegisterRptBO.getItemCatList()-->"+strErr);
			}
			
	}
public void getSupplierList(StockReceiptRegisterRptVO voObj){
	
	StockReceiptRegisterRptDAO.getSupplierList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("StockReceiptRegisterRptBO.getItemCatList()-->"+strErr);
			}
			
	}

public void GetUserLevel(StockReceiptRegisterRptVO voObj){
	StockReceiptRegisterRptDAO.GetUserLevel(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("StockReceiptRegisterRptBO.GetUserLevel()-->"+strErr);
			}
}

}
