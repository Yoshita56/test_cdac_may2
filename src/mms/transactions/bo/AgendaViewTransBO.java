package mms.transactions.bo;

import mms.transactions.dao.AgendaViewTransDAO;
import mms.transactions.vo.AgendaViewTransVO;

public class AgendaViewTransBO {

	/*
	 * Developer : Pramod Kumar Mehta Version : 1.0 Date : 08/April/2009
	 * Module:MMS Unit:Agenda View
	 */
	/**
	 * viewData Method is Used to get the Data for view page
	 * 
	 * @param vo
	 */
	public void viewData(AgendaViewTransVO _agendaViewTransVO) {
		AgendaViewTransDAO.getAgendaDetails(_agendaViewTransVO);
		AgendaViewTransDAO.getIndentDetails(_agendaViewTransVO);
		AgendaViewTransDAO.getCompiledItemDetails(_agendaViewTransVO);

		if (_agendaViewTransVO.getStrMsgType().equals("1"))
			_agendaViewTransVO
					.setStrMsgString("AgendaViewTransBO.viewData() --> "
							+ _agendaViewTransVO.getStrMsgString());
	}
}
