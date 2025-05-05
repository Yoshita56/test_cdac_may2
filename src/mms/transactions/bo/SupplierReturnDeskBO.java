/**
 * 
 */
package mms.transactions.bo;

import mms.transactions.dao.SupplierReturnDeskDAO;
import mms.transactions.vo.SupplierReturnDeskVO;

/**
 * @author pankaj
 * 
 */
public class SupplierReturnDeskBO {
	


	public void getItemAndPODetails(SupplierReturnDeskVO voObj){
			
		    SupplierReturnDeskDAO.getPODetails(voObj);
			if (voObj.getStrMsgType().equals("1")) {
				String strErr = voObj.getStrMsgString();
				
				voObj.setStrMsgString("SupplierReturnDeskBO.getItemAndPODetails()-->"+strErr);
			}
			else
			{
		        SupplierReturnDeskDAO.getItemDetails(voObj);
			    if (voObj.getStrMsgType().equals("1")) {
				
				   String strErr = voObj.getStrMsgString();
				   voObj.setStrMsgString("SupplierReturnDeskBO.getItemAndPODetails()-->"+strErr);
			     }
			}
		}
	/*public void getIssueQtyUnitCmbDetails(SupplierReturnDeskVO voObj){
		
		SupplierReturnDeskDAO.getIssueQtyUnitCmbDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("SupplierReturnDeskBO.getItemCategoryCmb()-->"+strErr);
		}
		
	}*/
		
		
		
}
