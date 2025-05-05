package mms.reports.bo;

import mms.reports.dao.StoreWiseIssueRptDAO;
import mms.reports.vo.StoreWiseIssueRptVO;

public class StoreWiseIssueRptBO {
	
public void getStoreList(StoreWiseIssueRptVO voObj){
	
	StoreWiseIssueRptDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
			String strErr = voObj.getStrMsgString();
			voObj.setStrMsgString("PendingIndentStatusRecordRptBO.getStoreList()-->"+strErr);
		}
	}

public void getPartialIssueDtls(StoreWiseIssueRptVO voObj){
	
	StoreWiseIssueRptDAO.getPartialIssueDtls(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("PendingIndentStatusRecordRptBO.getPartialIssueDtls()-->"+strErr);
			}
			
	}

public void getItemCatList(StoreWiseIssueRptVO voObj){
	
	StoreWiseIssueRptDAO.getItemCatList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("PendingIndentStatusRecordRptBO.getItemCatList()-->"+strErr);
			}
			
	}
public void getReqTypeList(StoreWiseIssueRptVO voObj){
	
	StoreWiseIssueRptDAO.getIReqTypeList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("PendingIndentStatusRecordRptBO.getItemCatList()-->"+strErr);
			}
			
	}

	/* ==new Added== */
public void setViewPageDtl(StoreWiseIssueRptVO voObj){
	StoreWiseIssueRptDAO.getViewDtl(voObj);
	if (voObj.getStrMsgType().equals("1")){
		
		String strErr = voObj.getStrMsgString();

		voObj.setStrMsgString("PendingIndentStatusRecordRptBO.setViewPageDtl() --> "+strErr);
	  }
}

}
