/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         TransferRequestTransBO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.bo;

import mms.transactions.dao.TransferRequestTransDAO;
import mms.transactions.vo.TransferRequestTransVO;

/**
 * The Class TransferRequestTransBO.
 */
public class TransferRequestTransBO {

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 */

	public void initialAdd(TransferRequestTransVO vo) 
	{
		TransferRequestTransDAO.getOnlineApprovalStatus(vo);
		TransferRequestTransDAO.getItemName(vo);
		TransferRequestTransDAO.getGroupNameCombo(vo);
		TransferRequestTransDAO.getSubGroupList(vo);
		TransferRequestTransDAO.getApprovedByCombo(vo);
		TransferRequestTransDAO.getTimePeriodCombo(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferRequestTransBO.initialAdd() --> " + vo.getStrMsgString());
		}
	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 */

	public void initialModify(TransferRequestTransVO vo) 
	{
		TransferRequestTransDAO.getOnlineApprovalStatus(vo);
		TransferRequestTransDAO.getTransferDtlForModify(vo);
		TransferRequestTransDAO.getApprovedByCombo(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferRequestTransBO.initialModify() --> " + vo.getStrMsgString());
		}
	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 */

	public void initialView(TransferRequestTransVO vo) {
		TransferRequestTransDAO.getTransferDtlForView(vo);
		TransferRequestTransDAO.getTransferOrderDtlForView(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferRequestTransBO.initialView() --> " + vo.getStrMsgString());
		}
	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 */

	public void initialOrderView(TransferRequestTransVO vo) {

		TransferRequestTransDAO.getOrderDtlForView(vo);
		TransferRequestTransDAO.getTransferDtl(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferRequestTransBO.initialOrderView() --> " + vo.getStrMsgString());
		}
	}

	/**
	 * Sub grp and item cmb.
	 * 
	 * @param vo the vo
	 */
	public void subGrpAndItemCmb(TransferRequestTransVO vo) {
		TransferRequestTransDAO.getSubGroupList(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferRequestTransBO.subGrpAndItemCmb() --> " + vo.getStrMsgString());
		}
	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 */

	public void getItemBrandCmb(TransferRequestTransVO vo) {
		TransferRequestTransDAO.getItemName(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferRequestTransBO.getItemBrandCmb() --> " + vo.getStrMsgString());
		}
	}

	/**
	 * Gets the batch no.
	 * 
	 * @param vo the vo
	 */
	public void getBatchNo(TransferRequestTransVO vo) {
		TransferRequestTransDAO.getBatchNoDetails(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferRequestTransBO.getItemBrandCmb() --> " + vo.getStrMsgString());
		}
	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 */

	public void getTransferDtl(TransferRequestTransVO vo) {
		TransferRequestTransDAO.getTransferDtl(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferRequestTransBO.getTransferDtl() --> " + vo.getStrMsgString());
		}
	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 */

	public void getTransferItemDtl(TransferRequestTransVO vo) {
		TransferRequestTransDAO.getTransferItemDtl(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferRequestTransBO.getTransferItemDtl() --> " + vo.getStrMsgString());
		}
	}

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */

	public void insert(TransferRequestTransVO vo) {
		TransferRequestTransDAO.insert(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("TransferRequestTransBO.insert() --> " + strErr);
		}

	}

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */

	public void update(TransferRequestTransVO vo) {
		TransferRequestTransDAO.update(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("TransferRequestTransBO.update() --> " + strErr);
		}

	}

	/**
	 * CANCEL Method is Used to transfer Value Object to Data Access Object.
	 * 
	 * @param vo the vo
	 */
	public void cancel(TransferRequestTransVO vo) {
		TransferRequestTransDAO.cancel(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferRequestTransBO.CANCEL() --> " + vo.getStrMsgString());
		}

	}

}
