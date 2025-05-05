package mms.reports.bo;

import mms.reports.dao.FinancialEndYearRptDAO;
import mms.reports.vo.FinancialEndYearRptVO;

public class FinancialEndYearRptBO {
	
public void getStoreList(FinancialEndYearRptVO voObj){
		
		FinancialEndYearRptDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("FinancialEndYearRptBO.getStoreList()-->"+strErr);
				}
				
		}

public void getItemCatList(FinancialEndYearRptVO voObj){
	
	FinancialEndYearRptDAO.getItemCatList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("FinancialEndYearRptBO.getItemCatList()-->"+strErr);
			}
			
	}

}
