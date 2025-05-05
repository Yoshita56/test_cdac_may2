/**
 * 
 */
package mms.transactions.bo;

import mms.transactions.dao.AgendaDeskAddTransDAO;
import mms.transactions.vo.AgendaDeskAddTransVO;

/**
 * @author Pankaj Kumar Creation Date:- 8-4-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class AgendaDeskAddTransBO {
	/**
	 * for getting the Indent Details
	 * 
	 * @param AgendaDeskAddTransVO
	 */
	public void getIndentDetails(AgendaDeskAddTransVO _agendaDeskAddTransVO) {
		AgendaDeskAddTransDAO.setIndentDetails(_agendaDeskAddTransVO);
		if (_agendaDeskAddTransVO.getStrMsgType().equals("1"))
			_agendaDeskAddTransVO
					.setStrMsgString("AgendaDeskAddTransBO.getIndentDetails() --> "
							+ _agendaDeskAddTransVO.getStrMsgString());
	}

	/**
	 * for getting the Indent Item Details
	 * 
	 * @param AgendaDeskAddTransVO
	 */
	public void getIndentItemDetails(AgendaDeskAddTransVO _agendaDeskAddTransVO) {
		AgendaDeskAddTransDAO.getIndentItemDetails(_agendaDeskAddTransVO);
		if (_agendaDeskAddTransVO.getStrMsgType().equals("1"))
			_agendaDeskAddTransVO
					.setStrMsgString("AgendaDeskAddTransBO.getIndentItemDetails() --> "
							+ _agendaDeskAddTransVO.getStrMsgString());
	}

	/**
	 * for getting the Item Popup Data
	 * 
	 * @param AgendaDeskAddTransVO
	 */
	public void getItemPopupData(AgendaDeskAddTransVO _agendaDeskAddTransVO) {
		AgendaDeskAddTransDAO.getItemPopupData(_agendaDeskAddTransVO);
		if (_agendaDeskAddTransVO.getStrMsgType().equals("1"))
			_agendaDeskAddTransVO
					.setStrMsgString("AgendaDeskAddTransBO.getItemPopupData() --> "
							+ _agendaDeskAddTransVO.getStrMsgString());
	}

	/**
	 * for getting the Indent Popup Details
	 * 
	 * @param AgendaDeskAddTransVO
	 */
	public void getIndentPopupDetails(AgendaDeskAddTransVO _agendaDeskAddTransVO) {
		AgendaDeskAddTransDAO.getIndentPopupDetails(_agendaDeskAddTransVO);
		if (_agendaDeskAddTransVO.getStrMsgType().equals("1"))
			_agendaDeskAddTransVO
					.setStrMsgString("AgendaDeskAddTransBO.getIndentPopupDetails() --> "
							+ _agendaDeskAddTransVO.getStrMsgString());
	}

	/**
	 * for getting the ToStore Values
	 * 
	 * @param AgendaDeskAddTransVO
	 */
	public void setToStoreValues(AgendaDeskAddTransVO _agendaDeskAddTransVO) {
		AgendaDeskAddTransDAO.setToStoreValues(_agendaDeskAddTransVO);
		/* This Method is Added By Amit */
		AgendaDeskAddTransDAO.IndentPeriodCombo(_agendaDeskAddTransVO);
		if (_agendaDeskAddTransVO.getStrMsgType().equals("1"))
			_agendaDeskAddTransVO
					.setStrMsgString("AgendaDeskAddTransBO.setToStoreValues() --> "
							+ _agendaDeskAddTransVO.getStrMsgString());
	}

	/**
	 * for getting the Grant Type Values
	 * 
	 * @param AgendaDeskAddTransVO
	 */
	public void setGrantTypeValues(AgendaDeskAddTransVO _agendaDeskAddTransVO) {
		AgendaDeskAddTransDAO.setGrantTypeValues(_agendaDeskAddTransVO);
		if (_agendaDeskAddTransVO.getStrMsgType().equals("1"))
			_agendaDeskAddTransVO
					.setStrMsgString("AgendaDeskAddTransBO.setGrantTypeValues() --> "
							+ _agendaDeskAddTransVO.getStrMsgString());
	}

	/**
	 * for getting the Rate Unit Values
	 * 
	 * @param AgendaDeskAddTransVO
	 */
	public void setRateUnitValues(AgendaDeskAddTransVO _agendaDeskAddTransVO) {
		AgendaDeskAddTransDAO.setRateUnitValues(_agendaDeskAddTransVO);
		if (_agendaDeskAddTransVO.getStrMsgType().equals("1"))
			_agendaDeskAddTransVO
					.setStrMsgString("AgendaDeskAddTransBO.setRateUnitValues() --> "
							+ _agendaDeskAddTransVO.getStrMsgString());
	}

	/**
	 * for Inserting the Data
	 * 
	 * @param AgendaDeskAddTransVO
	 */
	public void insert(AgendaDeskAddTransVO _agendaDeskAddTransVO) {
		AgendaDeskAddTransDAO.insert(_agendaDeskAddTransVO);
		if (_agendaDeskAddTransVO.getStrMsgType().equals("1"))
			_agendaDeskAddTransVO
					.setStrMsgString("AgendaDeskAddTransBO.insert() --> "
							+ _agendaDeskAddTransVO.getStrMsgString());
	}
}
