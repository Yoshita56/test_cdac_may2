/**
 * 
 */
package mms.transactions.bo;

import mms.transactions.dao.PODeskViewTransDAO;
import mms.transactions.vo.PODeskViewTransVO;

/**
 * @author Pankaj Kumar Creation Date:- 15-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskViewTransBO {
	/**
	 * for getting the PO Details
	 * 
	 * @param PODeskViewTransVO
	 */
	public void getPODetails(PODeskViewTransVO _poDeskViewTransVO) {
		PODeskViewTransDAO.getPODetails(_poDeskViewTransVO);
		if (_poDeskViewTransVO.getStrMsgType().equals("1"))
			_poDeskViewTransVO
					.setStrMsgString("PODeskViewTransBO.getPODetails() --> "
							+ _poDeskViewTransVO.getStrMsgString());
	}
	
	/**
	 * for getting the Foreign Details
	 * 
	 * @param PODeskViewTransVO
	 */
	public void getForeignPODetails(PODeskViewTransVO _poDeskViewTransVO) {
		PODeskViewTransDAO.getForeignPODetails(_poDeskViewTransVO);
		if (_poDeskViewTransVO.getStrMsgType().equals("1"))
			_poDeskViewTransVO
					.setStrMsgString("PODeskViewTransBO.getForeignPODetails() --> "
							+ _poDeskViewTransVO.getStrMsgString());
	}
	
	/**
	 * for getting the Request Details
	 * 
	 * @param PODeskViewTransVO
	 */
	public void getRequestDetails(PODeskViewTransVO _poDeskViewTransVO) {
		PODeskViewTransDAO.getRequestDetails(_poDeskViewTransVO);
		if (_poDeskViewTransVO.getStrMsgType().equals("1"))
			_poDeskViewTransVO
					.setStrMsgString("PODeskViewTransBO.getRequestDetails() --> "
							+ _poDeskViewTransVO.getStrMsgString());
	}
	
	/**
	 * for getting the Item Details
	 * 
	 * @param PODeskViewTransVO
	 */
	public void getItemDetails(PODeskViewTransVO _poDeskViewTransVO) {
		PODeskViewTransDAO.getItemDetails(_poDeskViewTransVO);
		if (_poDeskViewTransVO.getStrMsgType().equals("1"))
			_poDeskViewTransVO
					.setStrMsgString("PODeskViewTransBO.getItemDetails() --> "
							+ _poDeskViewTransVO.getStrMsgString());
	}
}
