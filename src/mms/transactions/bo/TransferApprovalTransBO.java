/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         TransferApprovalTransBO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.bo;

import mms.transactions.dao.TransferApprovalTransDAO;
import mms.transactions.vo.TransferApprovalTransVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TransferApprovalTransBO.
 */
public class TransferApprovalTransBO {

	/**
	 * Inits the order generate.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void initOrderGenerate(TransferApprovalTransVO vo) {

		TransferApprovalTransDAO.getStoreName(vo);
		TransferApprovalTransDAO.getDWHList(vo);
		TransferApprovalTransDAO.getDemandRequestDetails(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("TransferApprovalTransBO.demandReject() --> "
					+ strErr);
		}

	}

	/**
	 * Insert order generate.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void insertOrderGenerate(TransferApprovalTransVO vo) {

		TransferApprovalTransDAO.insertOrderGenerate(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("TransferApprovalTransBO.insertOrderGenerate() --> "
					+ strErr);
		}

	}

	/**
	 * Inits the order modify.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void initOrderModify(TransferApprovalTransVO vo) {
		TransferApprovalTransDAO.getStoreName(vo);
		TransferApprovalTransDAO.getOrderDetails(vo);
		TransferApprovalTransDAO.getTransferingDetailsModify(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("TransferApprovalTransBO.demandReject() --> "
					+ strErr);
		}

	}

	/**
	 * Insert order modify.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void insertOrderModify(TransferApprovalTransVO vo) {

		TransferApprovalTransDAO.insertOrderModify(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("TransferApprovalTransBO.insertOrderModify() --> "
					+ strErr);
		}

	}

	/**
	 * Gets the demand request details.
	 * 
	 * @param vo
	 *            the vo
	 * @return the demand request details
	 */
	public void getDemandRequestDetails(TransferApprovalTransVO vo) {

		TransferApprovalTransDAO.getDemandRequestDetails(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("TransferApprovalTransBO.getDemandRequestDetails() --> "
					+ strErr);
		}

	}

	/**
	 * Gets the transfering details.
	 * 
	 * @param vo
	 *            the vo
	 * @return the transfering details
	 */
	public void getTransferingDetails(TransferApprovalTransVO vo) {

		TransferApprovalTransDAO.getTransferingDetails(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("TransferApprovalTransBO.getTransferingDetails() --> "
					+ strErr);
		}

	}

	/**
	 * Demand reject.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void demandReject(TransferApprovalTransVO vo) {

		TransferApprovalTransDAO.demandReject(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("TransferApprovalTransBO.demandReject() --> "+ strErr);
		}
	}

	/**
	 * Transfer reject.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void transferReject(TransferApprovalTransVO vo) {

		TransferApprovalTransDAO.transferReject(vo);

		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("TransferApprovalTransBO.transferReject() --> "+ strErr);
		}
	}

	/**
	 * Transfer forcefully close.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void transferForcefullyClose(TransferApprovalTransVO vo) {

		TransferApprovalTransDAO.transferForcefullyClose(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("TransferApprovalTransBO.transferForcefullyClose() --> "
					+ strErr);
		}

	}

	/**
	 * Cancel order.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void cancelOrder(TransferApprovalTransVO vo) {

		TransferApprovalTransDAO.cancelOrder(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("TransferApprovalTransBO.cancelOrder() --> "
					+ strErr);
		}

	}

}
