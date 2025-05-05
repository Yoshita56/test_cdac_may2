package mms.transactions.bo;

import mms.transactions.dao.ThirdPartyIssueReqTransDAO;
import mms.transactions.vo.ThirdPartyIssueReqTransVO;

public class ThirdPartyIssueReqTransBO {
	
	/**
	 * This method is used for THIRD PARTY LIST
	 * @param voObj
	 */
	public void getThirdPartyCmb(ThirdPartyIssueReqTransVO voObj){
		
		ThirdPartyIssueReqTransDAO.getThirdPartyCmb(voObj);
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("ThirdPartyIssueReqTransBO.getThirdPartyCmb()-->"+strErr);
		}
		
	}
	
public void getItemDetails(ThirdPartyIssueReqTransVO voObj){
		
		ThirdPartyIssueReqTransDAO.getItemDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("ThirdPartyIssueReqTransBO.getItemDetails()-->"+strErr);
		}
		
	}
	/**
	 * This method is used for ITEM CATEGORY LIST
	 * @param voObj
	 */
	public void getItemCategoryCmb(ThirdPartyIssueReqTransVO voObj){
		
		ThirdPartyIssueReqTransDAO.getItemCategoryCmb(voObj);
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("ThirdPartyIssueReqTransBO.getItemCategoryCmb()-->"+strErr);
		}
		
	}

	/**
	 * This method is used for GROUP LIST
	 * @param voObj
	 */
	public void getGroupCmb(ThirdPartyIssueReqTransVO voObj){

		ThirdPartyIssueReqTransDAO.getGroupCmb(voObj);
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("ThirdPartyIssueReqTransBO.getGroupCmb()-->"+strErr);
		}
		
	}
	
	/**
	 * This method is used for insert the details.
	 * @param voObj
	 */
	public void insert(ThirdPartyIssueReqTransVO voObj){
	
		ThirdPartyIssueReqTransDAO.insert(voObj);
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("ThirdPartyIssueReqTransBO.insert()-->"+strErr);
		}
	}
	
	/**
	 * This method is used for insert the details.
	 * @param voObj
	 */
	public void insertNew(ThirdPartyIssueReqTransVO voObj){
	
		ThirdPartyIssueReqTransDAO.insertNew(voObj);
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("ThirdPartyIssueReqTransBO.insertNew()-->"+strErr);
		}
	}
	 
    /**
	 * This method is used for insert the details.
	 * @param voObj
	 */
	public void CANCEL_REQUEST(ThirdPartyIssueReqTransVO voObj){
	
		ThirdPartyIssueReqTransDAO.CANCEL_REQUEST(voObj);
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("ThirdPartyIssueReqTransBO.insert()-->"+strErr);
		}
	}
}
