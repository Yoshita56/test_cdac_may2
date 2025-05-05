/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         TransferDemandReqTransBO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.bo;

import mms.transactions.dao.TransferDemandReqTransDAO;
import mms.transactions.vo.TransferDemandReqTransVO;

/**
 * The Class TransferDemandReqTransBO.
 */
public class TransferDemandReqTransBO {

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 */

	public void initialAdd(TransferDemandReqTransVO vo) 
	{
		TransferDemandReqTransDAO.getItemName(vo);
		TransferDemandReqTransDAO.getGroupNameCombo(vo);
		TransferDemandReqTransDAO.getSubGroupList(vo);		
		TransferDemandReqTransDAO.getOnlineApprovalStatus(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferDemandReqTransBO.initialAdd() --> " + vo.getStrMsgString());
		}
	}

	/**
	 * Gets the approval details.
	 * 
	 * @param vo the vo
	 */
	public void getApprovalDetails(TransferDemandReqTransVO vo) {
		TransferDemandReqTransDAO.getApprovedByCombo(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferDemandReqTransBO.getApprovalDetails() --> " + vo.getStrMsgString());
		}
	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 */

	public void initialModify(TransferDemandReqTransVO vo) {
		TransferDemandReqTransDAO.getTransferDtlForModify(vo);
		TransferDemandReqTransDAO.getOnlineApprovalStatus(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferDemandReqTransBO.initialModify() --> " + vo.getStrMsgString());
		}
	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 */

	public void initialView(TransferDemandReqTransVO vo) {
		TransferDemandReqTransDAO.getTransferDtlForView(vo);
		TransferDemandReqTransDAO.getTransferOrderDtlForView(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferDemandReqTransBO.initialView() --> " + vo.getStrMsgString());
		}
	}

	/**
	 * Sub grp and item cmb.
	 * 
	 * @param vo the vo
	 */
	public void subGrpAndItemCmb(TransferDemandReqTransVO vo) {
		TransferDemandReqTransDAO.getSubGroupList(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferDemandReqTransBO.subGrpAndItemCmb() --> " + vo.getStrMsgString());
		}
	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 */

	public void getItemBrandCmb(TransferDemandReqTransVO vo) {
		TransferDemandReqTransDAO.getItemName(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferDemandReqTransBO.getItemBrandCmb() --> " + vo.getStrMsgString());
		}
	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 */

	public void getTransferDtl(TransferDemandReqTransVO vo) {
		TransferDemandReqTransDAO.getTransferDtl(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferDemandReqTransBO.getTransferDtl() --> " + vo.getStrMsgString());
		}
	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 */

	public void getTransferItemDtl(TransferDemandReqTransVO vo) {
		TransferDemandReqTransDAO.getTransferItemDtl(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferDemandReqTransBO.getTransferItemDtl() --> " + vo.getStrMsgString());
		}
	}

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */

	public void insert(TransferDemandReqTransVO vo) {
		TransferDemandReqTransDAO.insert(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("TransferDemandReqTransBO.insert() --> " + strErr);
		}

	}

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */

	public void update(TransferDemandReqTransVO vo) {
		TransferDemandReqTransDAO.update(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("TransferDemandReqTransBO.update() --> " + strErr);
		}

	}

	/**
	 * CANCEL Method is Used to transfer Value Object to Data Access Object.
	 * 
	 * @param vo the vo
	 */
	public void cancel(TransferDemandReqTransVO vo) {
		TransferDemandReqTransDAO.cancel(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferDemandReqTransBO.CANCEL() --> " + vo.getStrMsgString());
		}

	}

	/**
	 * Check duplicate request.
	 * 
	 * @param vo the vo
	 */
	public void checkDuplicateRequest(TransferDemandReqTransVO vo) {
		TransferDemandReqTransDAO.checkDuplicateRequest(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("TransferDemandReqTransBO.checkDuplicateRequest() --> " + vo.getStrMsgString());
		}

	}

}
