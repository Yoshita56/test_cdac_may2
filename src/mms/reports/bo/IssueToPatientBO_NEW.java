package mms.reports.bo;

import mms.reports.dao.IssueToPatientDAO_NEW;
import mms.reports.vo.IssueToPatientVO_NEW;

public class IssueToPatientBO_NEW {
	
public void getStoreList(IssueToPatientVO_NEW voObj){
		
		IssueToPatientDAO_NEW.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("PendingIndentStatusRecordRptBO.getStoreList()-->"+strErr);
				}
				
		}

public void getItemCatList(IssueToPatientVO_NEW voObj){
	
	IssueToPatientDAO_NEW.getItemCatList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("PendingIndentStatusRecordRptBO.getItemCatList()-->"+strErr);
			}
			
	}
public void getReqTypeList(IssueToPatientVO_NEW voObj){
	
	IssueToPatientDAO_NEW.getIReqTypeList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("PendingIndentStatusRecordRptBO.getItemCatList()-->"+strErr);
			}
			
	}

}
