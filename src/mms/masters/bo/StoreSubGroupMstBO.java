package mms.masters.bo;

import mms.masters.dao.StoreSubGroupMstDAO;
import mms.masters.vo.StoreSubGroupMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreSubGroupMstBO.
 * 
 * @author Anshul Jindal
 */
public class StoreSubGroupMstBO {
	
	/**
	 * for getting option value of group name combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */

	public void initAdd(StoreSubGroupMstVO vo) {

		StoreSubGroupMstDAO.initAddQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreSubGroupMstBO.initAdd() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public void insertRecord(StoreSubGroupMstVO vo) {
		StoreSubGroupMstDAO.initialAddQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreSubGroupMstBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			StoreSubGroupMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("StoreSubGroupMstBO.insertRecord() --> "
						+ vo.getStrMsgString());
			}
		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void modifyRecord(StoreSubGroupMstVO vo) {

		StoreSubGroupMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreSubGroupMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(StoreSubGroupMstVO vo) {
		StoreSubGroupMstDAO.initialUpdateQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreSubGroupMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			StoreSubGroupMstDAO.updateQuery(vo);
		}
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreSubGroupMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}
	}

}
