package mms.reports.bo;

import mms.reports.dao.IssueToThirdPartyRptDAO;
import mms.reports.vo.IssueToThirdPartyRptVO;

public class IssueToThirdPartyRptBO {
	
public void getInitValues(IssueToThirdPartyRptVO voObj){
		
		IssueToThirdPartyRptDAO.getStoreList(voObj);
		IssueToThirdPartyRptDAO.getThirdPartyList(voObj);
		
		
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToThirdPartyRptBO.getStoreList()-->"+strErr);
				}
				
		}

public void getStoreList(IssueToThirdPartyRptVO voObj){
	
	IssueToThirdPartyRptDAO.getStoreList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("IssueToThirdPartyRptBO.getStoreList()-->"+strErr);
			}
			
	}

public void getItemCatList(IssueToThirdPartyRptVO voObj){
	
	IssueToThirdPartyRptDAO.getItemCatList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("IssueToThirdPartyRptBO.getItemCatList()-->"+strErr);
			}
			
	}

}
