/**********************************************************
 Project:DWH_GUJARAT	
 File:         TransferExcessApprovalTransBO.java
 Created:      Jul 23, 2014
 Last Changed: Jul 23, 2014
 Author:       santoshsinghchauhan

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.bo;

/**
 * @author santoshsinghchauhan
 * @date Jul 23, 2014
 * @file TransferExcessApprovalTransBO.java
 */

import mms.transactions.dao.TransferExcessApprovalTransDAO;
import mms.transactions.vo.TransferExcessApprovalTransVO;

/**
 * The Class TransferExcessApprovalTransBO.
 */
public class TransferExcessApprovalTransBO {

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 */

	public void initialApproval(TransferExcessApprovalTransVO vo) {
		TransferExcessApprovalTransDAO.getIndentDetails(vo);
		TransferExcessApprovalTransDAO.getTransferApprovalItemDtl(vo);
		TransferExcessApprovalTransDAO.callingFunctionIndentName(vo);
		

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferExcessApprovalTransBO.initialApproval() --> " + vo.getStrMsgString());
		}
	}
	
	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */

	public void INSERT(TransferExcessApprovalTransVO vo) {
		TransferExcessApprovalTransDAO.INSERT(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("TransferExcessApprovalTransBO.insert() --> " + strErr);
		}

	}
	
	public void viewData(TransferExcessApprovalTransVO vo) {

		TransferExcessApprovalTransDAO.getIndentDetails(vo);
		TransferExcessApprovalTransDAO.getTransferApprovalItemDtl(vo);
		TransferExcessApprovalTransDAO.callingFunctionIndentName(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferExcessApprovalTransBO.viewData() --> " + vo.getStrMsgString());
		}
	}

}
