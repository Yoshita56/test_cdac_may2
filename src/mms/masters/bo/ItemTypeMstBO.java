package mms.masters.bo;

import mms.masters.dao.ItemTypeMstDAO;
import mms.masters.vo.ItemTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemTypeMstBO.
 * 
 * @author Anshul Jindal
 */

public class ItemTypeMstBO {

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public void insertRecord(ItemTypeMstVO vo) {

		ItemTypeMstDAO.chkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ItemTypeMstBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			ItemTypeMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("ItemTypeMstBO.insertRecord() --> "
						+ vo.getStrMsgString());
			}
		}
	}

	/**
	 * to check duplicate before insert update.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(ItemTypeMstVO vo) {

		ItemTypeMstDAO.initialUpdateQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ItemTypeMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			ItemTypeMstDAO.updateQuery(vo);
		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void modifyRecord(ItemTypeMstVO vo) {

		ItemTypeMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ItemTypeMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}
	}

}
