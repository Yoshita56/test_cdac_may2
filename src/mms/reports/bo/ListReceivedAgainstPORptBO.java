package mms.reports.bo;

import mms.reports.dao.ListReceivedAgainstPORptDAO;
import mms.reports.vo.ListReceivedAgainstPORptVO;

public class ListReceivedAgainstPORptBO {
	
public void getItemCatList(ListReceivedAgainstPORptVO voObj){
		
		ListReceivedAgainstPORptDAO.getItemCatList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("ListReceivedAgainstPORptBO.getItemCatList()-->"+strErr);
				}
				
		}

}
