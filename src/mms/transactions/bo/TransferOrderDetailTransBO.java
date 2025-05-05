/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         TransferApprovalTransBO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.bo;

import mms.transactions.dao.TransferOrderDetailTransDAO;
import mms.transactions.vo.TransferOrderDetailTransVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TransferOrderDetailTransBO.
 */
public class TransferOrderDetailTransBO {

	/**
	 * Inits the order generate.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void initOrderGenerate(TransferOrderDetailTransVO vo) {

		TransferOrderDetailTransDAO.getStoreName(vo);
		TransferOrderDetailTransDAO.STORENAMECOMBO(vo);
		TransferOrderDetailTransDAO.getDWHList(vo);
		TransferOrderDetailTransDAO.getDemandRequestDetails(vo);

		// TransferOrderDetailTransDAO.getItemName(vo);
		// TransferOrderDetailTransDAO.getGroupNameCombo(vo);
		// TransferOrderDetailTransDAO.getSubGroupList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("TransferOrderDetailTransBO.demandReject() --> "
					+ strErr);
		}

	}

	/**
	 * Insert order generate.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void insertOrderGenerate(TransferOrderDetailTransVO vo) {

		TransferOrderDetailTransDAO.insertOrderGenerate(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("TransferOrderDetailTransBO.insertOrderGenerate() --> "
					+ strErr);
		}

	}

	/**
	 * Inits the order modify.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void initOrderModify(TransferOrderDetailTransVO vo) {
		TransferOrderDetailTransDAO.getStoreName(vo);
		TransferOrderDetailTransDAO.getOrderDetails(vo);
		TransferOrderDetailTransDAO.getTransferingDetailsModify(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("TransferOrderDetailTransBO.demandReject() --> "
					+ strErr);
		}

	}

	/**
	 * Insert order modify.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void insertOrderModify(TransferOrderDetailTransVO vo) {

		TransferOrderDetailTransDAO.insertOrderModify(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("TransferOrderDetailTransBO.insertOrderModify() --> "
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
	public void getDemandRequestDetails(TransferOrderDetailTransVO vo) {

		TransferOrderDetailTransDAO.getDemandRequestDetails(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("TransferOrderDetailTransBO.getDemandRequestDetails() --> "
					+ strErr);
		}

	}

	public void getGrpItemDetails(TransferOrderDetailTransVO vo) {

		TransferOrderDetailTransDAO.getGroupNameCombo(vo);
		TransferOrderDetailTransDAO.getItemName(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("TransferOrderDetailTransBO.getGrpItemDetails() --> "
					+ strErr);
		}

	}

	/**
	 * Sub grp and item cmb.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void subGrpAndItemCmb(TransferOrderDetailTransVO vo) {
		TransferOrderDetailTransDAO.getSubGroupList(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferOrderDetailTransBO.subGrpAndItemCmb() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo
	 *            the vo
	 */

	public void getItemBrandCmb(TransferOrderDetailTransVO vo) {
		TransferOrderDetailTransDAO.getItemName(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferOrderDetailTransBO.getItemBrandCmb() --> "
					+ vo.getStrMsgString());
		}
	}

	
	/**
	 * Gets the batch no.
	 * 
	 * @param vo the vo
	 */
	public void getBatchNo(TransferOrderDetailTransVO vo) {
		TransferOrderDetailTransDAO.getBatchNoDetails(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferOrderDetailTrans.getItemBrandCmb() --> " + vo.getStrMsgString());
		}
	}

	
	/**
	 * Gets the transfering details.
	 * 
	 * @param vo
	 *            the vo
	 * @return the transfering details
	 */
	public void getTransferingDetails(TransferOrderDetailTransVO vo) {

		TransferOrderDetailTransDAO.getTransferingDetails(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("TransferOrderDetailTransBO.getTransferingDetails() --> "
					+ strErr);
		}

	}

	/**
	 * Demand reject.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void demandReject(TransferOrderDetailTransVO vo) {

		TransferOrderDetailTransDAO.demandReject(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("TransferOrderDetailTransBO.demandReject() --> "
					+ strErr);
		}
	}

	/**
	 * Transfer reject.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void transferReject(TransferOrderDetailTransVO vo) {

		TransferOrderDetailTransDAO.transferReject(vo);

		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("TransferOrderDetailTransBO.transferReject() --> "
					+ strErr);
		}
	}

	/**
	 * Transfer forcefully close.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void transferForcefullyClose(TransferOrderDetailTransVO vo) {

		TransferOrderDetailTransDAO.transferForcefullyClose(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("TransferOrderDetailTransBO.transferForcefullyClose() --> "
					+ strErr);
		}

	}

	/**
	 * Cancel order.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void cancelOrder(TransferOrderDetailTransVO vo) {

		TransferOrderDetailTransDAO.cancelOrder(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("TransferOrderDetailTransBO.cancelOrder() --> "
					+ strErr);
		}

	}

}
