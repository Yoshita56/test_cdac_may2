package mms.transactions.bo;

import mms.transactions.dao.ThirdPartyIssueSancTransDAO;
import mms.transactions.vo.ThirdPartyIssueSancTransVO;

public class ThirdPartyIssueSancTransBO {
	
	

public void getItemDetails(ThirdPartyIssueSancTransVO voObj){
		
		ThirdPartyIssueSancTransDAO.getItemDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("ThirdPartyIssueSancTransBO.getItemDetails()-->"+strErr);
		}
		
	}
/*public void getIssueQtyUnitCmbDetails(ThirdPartyIssueSancTransVO voObj){
	
	ThirdPartyIssueSancTransDAO.getIssueQtyUnitCmbDetails(voObj);
	if (voObj.getStrMsgType().equals("1")) {
		
		String strErr = voObj.getStrMsgString();
			
		voObj.setStrMsgString("ThirdPartyIssueSancTransBO.getItemCategoryCmb()-->"+strErr);
	}
	
}*/
	
	
	/**
	 * This method is used for insert the details.
	 * @param voObj
	 */
	public void insert(ThirdPartyIssueSancTransVO voObj){
	
		ThirdPartyIssueSancTransDAO.insert(voObj);
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("ThirdPartyIssueSancTransBO.insert()-->"+strErr);
		}
	}
}
