/**
 * 
 */
package mms.transactions.bo;

import mms.transactions.dao.PODeskCancelTransDAO;
import mms.transactions.vo.PODeskCancelTransVO;

/**
 * @author Pankaj Kumar Creation Date:- 15-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskCancelTransBO {
	/**
	 * for getting the PO Details
	 * 
	 * @param PODeskCancelTransVO
	 */
	public void getPODetails(PODeskCancelTransVO _poDeskCancelTransVO) {
		PODeskCancelTransDAO.getPODetails(_poDeskCancelTransVO);
		if (_poDeskCancelTransVO.getStrMsgType().equals("1"))
			_poDeskCancelTransVO
					.setStrMsgString("PODeskCancelTransBO.getPODetails() --> "
							+ _poDeskCancelTransVO.getStrMsgString());
	}
	
	/**
	 * for getting the Foreign Details
	 * 
	 * @param PODeskCancelTransVO
	 */
	public void getForeignPODetails(PODeskCancelTransVO _poDeskCancelTransVO) {
		PODeskCancelTransDAO.getForeignPODetails(_poDeskCancelTransVO);
		if (_poDeskCancelTransVO.getStrMsgType().equals("1"))
			_poDeskCancelTransVO
					.setStrMsgString("PODeskCancelTransBO.getForeignPODetails() --> "
							+ _poDeskCancelTransVO.getStrMsgString());
	}
	
	/**
	 * for getting the Employee Values
	 * 
	 * @param PODeskCancelTransVO
	 */
	public void setEmployeeValues(PODeskCancelTransVO _poDeskCancelTransVO) {
		PODeskCancelTransDAO.setEmployeeValues(_poDeskCancelTransVO);
		if (_poDeskCancelTransVO.getStrMsgType().equals("1"))
			_poDeskCancelTransVO
					.setStrMsgString("PODeskCancelTransBO.setEmployeeValues() --> "
							+ _poDeskCancelTransVO.getStrMsgString());
	}
	
	/**
	 * for getting the Schedule Details
	 * 
	 * @param PODeskCancelTransVO
	 */
	public void getScheduleDetails(PODeskCancelTransVO _poDeskCancelTransVO) {
		PODeskCancelTransDAO.getScheduleDetails(_poDeskCancelTransVO);
		if (_poDeskCancelTransVO.getStrMsgType().equals("1"))
			_poDeskCancelTransVO
					.setStrMsgString("PODeskCancelTransBO.getScheduleDetails() --> "
							+ _poDeskCancelTransVO.getStrMsgString());
	}
	
	/**
	 * for Inserting the Data
	 * 
	 * @param PODeskCancelTransVO
	 */
	public void insert(PODeskCancelTransVO _poDeskCancelTransVO) {
		PODeskCancelTransDAO.insert(_poDeskCancelTransVO);
		if (_poDeskCancelTransVO.getStrMsgType().equals("1"))
			_poDeskCancelTransVO
					.setStrMsgString("PODeskCancelTransBO.insert() --> "
							+ _poDeskCancelTransVO.getStrMsgString());
	}
}
