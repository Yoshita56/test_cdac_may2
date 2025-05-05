package mms.reports.bo;

import mms.reports.dao.WarrantyDetailRptDAO;
import mms.reports.vo.WarrantyDetailRptVO;

public class WarrantyDetailRptBO {
	
public void getItemCatList(WarrantyDetailRptVO voObj){
		
		WarrantyDetailRptDAO.getItemCatList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("WarrantyDetailRptBO.getItemCatList()-->"+strErr);
				}
				
		}


}
