package mms.transactions.bo;

import mms.transactions.dao.SupplierReturnReqTransDAO;
import mms.transactions.vo.SupplierReturnReqTransVO;
/**
 * Developer : DEEPAK Tiwari 
 * Version   : 1.0 
 * Date      : 20/Apr/2009
 * Module    : MMS
 * Unit      : Supplier Return  Details
 */

public class SupplierReturnReqTransBO {
	
	/**
	 * This method is used for ITEM CATEGORY LIST
	 * @param voObj
	 */
	public void getItemCategoryCmb(SupplierReturnReqTransVO voObj){
		
		SupplierReturnReqTransDAO.getItemCategoryCmb(voObj);
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("SupplierReturnReqTransBO.getItemCategoryCmb()-->"+strErr);
		}
		
	}

	/**
	 * This method is used for GROUP LIST
	 * @param voObj
	 */
	public void getPODetails(SupplierReturnReqTransVO voObj){

		SupplierReturnReqTransDAO.getPODetails(voObj);
		
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("SupplierReturnReqTransBO.getPODetails()-->"+strErr);
		}
		
	}
	/**
	 * This method is used for GROUP LIST
	 * @param voObj
	 */
	public void getPODetailsSearchList(SupplierReturnReqTransVO voObj){

		SupplierReturnReqTransDAO.getPODetailsSearchList(voObj);
		
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("SupplierReturnReqTransBO.getPODetails()-->"+strErr);
		}
		
	}
	/**
	 * This method is used for GROUP LIST
	 * @param voObj
	 */
	public void getGroupCmb(SupplierReturnReqTransVO voObj){

		SupplierReturnReqTransDAO.getGroupCmb(voObj);
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("SupplierReturnReqTransBO.getGroupCmb()-->"+strErr);
		}
		
	}
	
	/**
	 * This method is used for insert the details.
	 * @param voObj
	 */
	public void insert(SupplierReturnReqTransVO voObj){
	
		SupplierReturnReqTransDAO.insert(voObj);
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("SupplierReturnReqTransBO.insert()-->"+strErr);
		}
	}
	 
    /**
	 * This method is used for insert the details.
	 * @param voObj
	 */
	public void CANCEL_REQUEST(SupplierReturnReqTransVO voObj){
	
		SupplierReturnReqTransDAO.CANCEL_REQUEST(voObj);
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("SupplierReturnReqTransBO.insert()-->"+strErr);
		}
	}
}

