/**
 * 
 */
package mms.transactions.bo;

import mms.transactions.dao.PODeskScheduleTransDAO;
import mms.transactions.vo.PODeskScheduleTransVO;

/**
 * @author Pankaj Kumar Creation Date:- 15-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskScheduleTransBO {
	/**
	 * for getting the PO Details
	 * 
	 * @param PODeskScheduleTransVO
	 */
	public void getPODetails(PODeskScheduleTransVO _poDeskScheduleTransVO) {
		PODeskScheduleTransDAO.getPODetails(_poDeskScheduleTransVO);
		if (_poDeskScheduleTransVO.getStrMsgType().equals("1"))
			_poDeskScheduleTransVO
					.setStrMsgString("PODeskScheduleTransBO.getPODetails() --> "
							+ _poDeskScheduleTransVO.getStrMsgString());
	}
	
	/**
	 * for getting the Foreign Details
	 * 
	 * @param PODeskScheduleTransVO
	 */
	public void getForeignPODetails(PODeskScheduleTransVO _poDeskScheduleTransVO) {
		PODeskScheduleTransDAO.getForeignPODetails(_poDeskScheduleTransVO);
		if (_poDeskScheduleTransVO.getStrMsgType().equals("1"))
			_poDeskScheduleTransVO
					.setStrMsgString("PODeskScheduleTransBO.getForeignPODetails() --> "
							+ _poDeskScheduleTransVO.getStrMsgString());
	}
	
	/**
	 * for getting the Scheduled Qty Unit Values
	 * 
	 * @param PODeskScheduleTransVO
	 */
	public void setStrScheduledQtyUnitValues(PODeskScheduleTransVO _poDeskScheduleTransVO) {
		PODeskScheduleTransDAO.setStrScheduledQtyUnitValues(_poDeskScheduleTransVO);
		if (_poDeskScheduleTransVO.getStrMsgType().equals("1"))
			_poDeskScheduleTransVO
					.setStrMsgString("PODeskScheduleTransBO.setStrScheduledQtyUnitValues() --> "
							+ _poDeskScheduleTransVO.getStrMsgString());
	}
	
	/**
	 * for getting the PO Item Details
	 * 
	 * @param PODeskScheduleTransVO
	 */
	public void getPOItemDetails(PODeskScheduleTransVO _poDeskScheduleTransVO) {
		PODeskScheduleTransDAO.getPOItemDetails(_poDeskScheduleTransVO);
		PODeskScheduleTransDAO.setDeliveryLocationValues(_poDeskScheduleTransVO);
		if (_poDeskScheduleTransVO.getStrMsgType().equals("1"))
			_poDeskScheduleTransVO
					.setStrMsgString("PODeskScheduleTransBO.getPOItemDetails() --> "
							+ _poDeskScheduleTransVO.getStrMsgString());
	}
	
	/**
	 * for Inserting the Data
	 * 
	 * @param PODeskScheduleTransVO
	 */
	public void insert(PODeskScheduleTransVO _poDeskScheduleTransVO) {
		PODeskScheduleTransDAO.insert(_poDeskScheduleTransVO);
		if (_poDeskScheduleTransVO.getStrMsgType().equals("1"))
			_poDeskScheduleTransVO
					.setStrMsgString("PODeskScheduleTransBO.insert() --> "
							+ _poDeskScheduleTransVO.getStrMsgString());
	}
	
}
