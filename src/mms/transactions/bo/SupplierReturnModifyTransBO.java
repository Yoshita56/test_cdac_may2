package mms.transactions.bo;

import mms.transactions.dao.SupplierReturnModifyTransDAO;
import mms.transactions.vo.SupplierReturnModifyTransVO;

public class SupplierReturnModifyTransBO {
	
	

	public void getItemAndPODetails(SupplierReturnModifyTransVO voObj){
			
		    SupplierReturnModifyTransDAO.getPODetails(voObj);
			if (voObj.getStrMsgType().equals("1")) {
				String strErr = voObj.getStrMsgString();
				
				voObj.setStrMsgString("SupplierReturnModifyTransBO.getItemAndPODetails()-->"+strErr);
			}
			else
			{
		        SupplierReturnModifyTransDAO.getItemDetails(voObj);
			    if (voObj.getStrMsgType().equals("1")) {
				
				   String strErr = voObj.getStrMsgString();
				   voObj.setStrMsgString("SupplierReturnModifyTransBO.getItemAndPODetails()-->"+strErr);
			     }
			}
		}
	/*public void getIssueQtyUnitCmbDetails(SupplierReturnModifyTransVO voObj){
		
		SupplierReturnModifyTransDAO.getIssueQtyUnitCmbDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("SupplierReturnModifyTransBO.getItemCategoryCmb()-->"+strErr);
		}
		
	}*/
		
		
		/**
		 * This method is used for insert the details.
		 * @param voObj
		 */
		public void insert(SupplierReturnModifyTransVO voObj){
		
			SupplierReturnModifyTransDAO.modify_Return_Request_Details(voObj);
			if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("SupplierReturnModifyTransBO.insert()-->"+strErr);
			}
		}
}
