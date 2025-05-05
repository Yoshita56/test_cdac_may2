/**
 * 
 */
package mms.transactions.bo;

import mms.transactions.dao.BillApprovalOtherTransDAO;
import mms.transactions.vo.BillApprovalOtherTransVO;



/**
 * Developer : Anshul Jindal 
 * Version : 1.0 Date : 23/June/2009
 * 
 */
public class BillApprovalOtherTransBO {
	

	/**
	 * To get option value of PO No combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void getPOCombo(BillApprovalOtherTransVO vo){

		BillApprovalOtherTransDAO.getPOCombo(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("BillApprovalOtherTransBO.getPOCombo() --> "
					+ vo.getStrMsgString());
		}

	}
	
	/**
	 * To get option value of PO details
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void getPODetails(BillApprovalOtherTransVO vo){

		BillApprovalOtherTransDAO.getPODetails(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("BillApprovalOtherTransBO.getPODetails() --> "
					+ vo.getStrMsgString());
		}

	}
	
	/**
	 * To SAVE THE DATA 
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void insertData(BillApprovalOtherTransVO vo){

		BillApprovalOtherTransDAO.insertData(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("BillApprovalOtherTransBO.insertData() --> "
					+ vo.getStrMsgString());
		}

	}

}
