package mms.reports.bo;

import mms.reports.dao.ConsumptionValueSummaryRptDAO;
import mms.reports.vo.ConsumptionValueSummaryRptVO;

public class ConsumptionValueSummaryRptBO {
	
public void getItemCatList(ConsumptionValueSummaryRptVO voObj){
		
		ConsumptionValueSummaryRptDAO.getItemCatList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("ConsumptionValueSummaryRptBO.getItemCatList()-->"+strErr);
				}
				
		}

public void getStoreList(ConsumptionValueSummaryRptVO voObj){
	
		ConsumptionValueSummaryRptDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("ConsumptionValueSummaryRptBO.getStoreList()-->"+strErr);
				}
				
		}

}


