/**
 * 
 */
package mms.transactions.bo;

import mms.transactions.dao.TransferShortageApprovalTransDAO;
import mms.transactions.vo.TransferShortageApprovalTransVO;

/**
 * @author santoshsinghchauhan
 * @date Jul 22, 2014
 * @file TransferShortageApprovalTransBO.java
 */

/**
 * The Class TransferShortageApprovalTransBO.
 */
public class TransferShortageApprovalTransBO {

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 */

	public void initialApproval(TransferShortageApprovalTransVO vo) {

		TransferShortageApprovalTransDAO.getIndentDetails(vo);
		TransferShortageApprovalTransDAO.getTransferApprovalItemDtl(vo);
		TransferShortageApprovalTransDAO.callingFunctionIndentName(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferShortageApprovalTransBO.initialAdd() --> " + vo.getStrMsgString());
		}
	}

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */

	public void INSERT(TransferShortageApprovalTransVO vo) {
		TransferShortageApprovalTransDAO.INSERT(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("TransferShortageApprovalTransBO.insert() --> " + strErr);
		}

	}
	
	public void viewData(TransferShortageApprovalTransVO vo) {

		TransferShortageApprovalTransDAO.getIndentDetails(vo);
		TransferShortageApprovalTransDAO.getTransferApprovalItemDtl(vo);
		TransferShortageApprovalTransDAO.callingFunctionIndentName(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferShortageApprovalTransBO.viewData() --> " + vo.getStrMsgString());
		}
	}

	/**
	 * CANCEL Method is Used to transfer Value Object to Data Access Object.
	 * 
	 * @param vo the vo
	 */
	public void cancel(TransferShortageApprovalTransVO vo) {
		TransferShortageApprovalTransDAO.cancel(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferShortageApprovalTransBO.CANCEL() --> " + vo.getStrMsgString());
		}

	}

}
