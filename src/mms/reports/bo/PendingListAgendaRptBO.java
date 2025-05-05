/**
 * 
 */
package mms.reports.bo;

import mms.reports.dao.PendingListAgendaRptDAO;
import mms.reports.vo.PendingListAgendaRptVO;

/**
 * Developer:Anshul Jindal Creation Date: 17-07-2009 Modifying Date:- Used
 * For:-MMS Reports Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PendingListAgendaRptBO {

	public void getStoreNameValues(PendingListAgendaRptVO vo) {
		PendingListAgendaRptDAO.getStoreNames(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("PendingListAgendaRptBO.getStoreNameValues()-->"
					+ strErr);
		}

	}
	
	/**
	 * This method is used to populate the value of category name combo box 
	 * 
	 * @param vo
	 */
	
	public void getCategoryValues(PendingListAgendaRptVO vo) {

		PendingListAgendaRptDAO.getCategoryValues(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("PendingListAgendaRptBO.getCategoryValues() --> "
							+ vo.getStrMsgString());
		}
	}

}
