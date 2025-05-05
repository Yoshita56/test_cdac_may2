/**
 * 
 */
package mms.transactions.bo;

import mms.transactions.dao.AgendaDeskCancelTransDAO;
import mms.transactions.vo.AgendaDeskCancelTransVO;

/**
 * @author Pankaj Kumar Creation Date:- 9-jun-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class AgendaDeskCancelTransBO {
	/**
	 * for getting the Grant Type Values
	 * 
	 * @param vo
	 */
	public void cancelAgenda(AgendaDeskCancelTransVO _AgendaVO) {
		AgendaDeskCancelTransDAO.cancelAgenda(_AgendaVO);
		if (_AgendaVO.getStrMsgType().equals("1"))
			_AgendaVO
					.setStrMsgString("AgendaDeskCancelTransBO.cancelAgenda() --> "
							+ _AgendaVO.getStrMsgString());
	}
}
