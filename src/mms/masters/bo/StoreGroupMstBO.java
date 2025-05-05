package mms.masters.bo;

import mms.masters.dao.StoreGroupMstDAO;
import mms.masters.vo.StoreGroupMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreGroupMstBO.
 * 
 * @author Anshul Jindal
 */
public class StoreGroupMstBO {

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	/*
	 * public void initialAdd(StoreGroupMstVO vo) {
	 * StoreGroupMstDAO.initialAddQuery(vo); if (vo.getStrMsgType().equals("1")) {
	 * vo.setStrMsgString("BOStoreGroupMst.initialAdd() --> " +
	 * vo.getStrMsgString()); }
	 *  }
	 */

	/**
	 * to insert the data
	 * 
	 * @param vo
	 */
	public void insertRecord(StoreGroupMstVO vo) {
		StoreGroupMstDAO.chkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreGroupMstBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			StoreGroupMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("StoreGroupMstBO.insertRecord() --> "
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

	public void modifyRecord(StoreGroupMstVO vo) {
		StoreGroupMstDAO.modifyQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreGroupMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(StoreGroupMstVO vo) {
		StoreGroupMstDAO.initialUpdateQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreGroupMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			StoreGroupMstDAO.updateQuery(vo);
		}
	}

}
