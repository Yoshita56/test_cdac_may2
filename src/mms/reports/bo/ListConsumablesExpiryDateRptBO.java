package mms.reports.bo;

import mms.reports.dao.BreakageAndLostDrugDetailsRptDAO;
import mms.reports.dao.ListConsumablesExpiryDateRptDAO;
import mms.reports.vo.BreakageAndLostDrugDetailsRptVO;
import mms.reports.vo.ListConsumablesExpiryDateRptVO;

	public class ListConsumablesExpiryDateRptBO {
	
	public void getStoreList(ListConsumablesExpiryDateRptVO voObj,String strUserLevel){
		
		if(strUserLevel.equals("6")){
			voObj.setStrMode("6");
		}
		else
			voObj.setStrMode("1");
		ListConsumablesExpiryDateRptDAO.getStoreList(voObj);
		
		if(strUserLevel.equals("6")){
			voObj.setStrMode("4");
		}
		else
			voObj.setStrMode("5");
		
	//	ListConsumablesExpiryDateRptDAO.getDistrictStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("ListConsumablesExpiryDateRptBO.getStoreList()-->"+strErr);
				}
				
		}

	public void getItemCatList(ListConsumablesExpiryDateRptVO voObj){
	
	ListConsumablesExpiryDateRptDAO.getItemCatList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
			String strErr = voObj.getStrMsgString();
			voObj.setStrMsgString("ListConsumablesExpiryDateRptBO.getItemCatList()-->"+strErr);
		}
	}
	
	public void getImgHeader(ListConsumablesExpiryDateRptVO voObj){
		ListConsumablesExpiryDateRptDAO.getImageHeader(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("ListConsumablesExpiryDateRptBO.getImgHeader() --> "+ voObj.getStrMsgString());
		  }
	}

	public void setViewPageDtl(ListConsumablesExpiryDateRptVO voObj){
		ListConsumablesExpiryDateRptDAO.getExpiryViewDtl(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("ListConsumablesExpiryDateRptBO.setViewPageDtl() --> "+ voObj.getStrMsgString());
		  }
	}
	
	public void setInvoiceViewPageDtl(ListConsumablesExpiryDateRptVO voObj){
		ListConsumablesExpiryDateRptDAO.getInvoiceWiseExpiryDetails(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("ListConsumablesExpiryDateRptBO.setInvoiceViewPageDtl() --> "+ voObj.getStrMsgString());
		  }
	}
	
	
	
}
