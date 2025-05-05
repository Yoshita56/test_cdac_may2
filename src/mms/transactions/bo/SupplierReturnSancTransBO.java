package mms.transactions.bo;

import mms.transactions.dao.SupplierReturnSancTransDAO;
import mms.transactions.vo.SupplierReturnSancTransVO;

public class SupplierReturnSancTransBO {
	
	

public void getItemAndPODetails(SupplierReturnSancTransVO voObj){
		
	    SupplierReturnSancTransDAO.getPODetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
			   voObj.setStrMsgString("SupplierReturnSancTransBO.getItemAndPODetails()-->"+strErr);
		
		}
		else
		{
	        SupplierReturnSancTransDAO.getItemDetails(voObj);
		    if (voObj.getStrMsgType().equals("1")) {
			
			   String strErr = voObj.getStrMsgString();
			      voObj.setStrMsgString("SupplierReturnSancTransBO.getItemAndPODetails()-->"+strErr);
		     
		    }
		}
	}
	
	
	/**
	 * This method is used for insert the details.
	 * @param voObj
	 */
	public void insert(SupplierReturnSancTransVO voObj){
	
		SupplierReturnSancTransDAO.update_Return_Details(voObj);
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
			   voObj.setStrMsgString("SupplierReturnSancTransBO.insert()-->"+strErr);
		}
	}
}
