package mms.reports.bo;

import mms.reports.dao.InvoiceDetailRptDAO;
import mms.reports.vo.InvoiceDetailRptVO;

public class InvoiceDetailRptBO {
	
public void getItemCatList(InvoiceDetailRptVO voObj){
		
		InvoiceDetailRptDAO.getItemCatList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("InvoiceDetailRptBO.getItemCatList()-->"+strErr);
				}
				
		}


}
