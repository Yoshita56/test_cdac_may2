package mms.transactions.bo;

import mms.transactions.dao.BillApprovalViewTransDAO;
import mms.transactions.vo.BillApprovalViewTransVO;

public class BillApprovalViewTransBO {

	/**
	 * viewData Method is Used to get the Data for view page
	 * 
	 * @param vo
	 */
	public void viewData(BillApprovalViewTransVO _BillApprovalViewTransVO) {
		BillApprovalViewTransDAO.getInitDtlView(_BillApprovalViewTransVO);
		if (!_BillApprovalViewTransVO.getStrMsgType().equals("1")) {
			BillApprovalViewTransDAO.getScheduleView(_BillApprovalViewTransVO);
		}
		if (!_BillApprovalViewTransVO.getStrMsgType().equals("1")) {
			BillApprovalViewTransDAO.getInvoiceView(_BillApprovalViewTransVO);
		}
		if (_BillApprovalViewTransVO.getStrMsgType().equals("1")) {
			_BillApprovalViewTransVO
					.setStrMsgString("BillApprovalViewTransBO.viewData() --> "
							+ _BillApprovalViewTransVO.getStrMsgString());
		}
	}

}
