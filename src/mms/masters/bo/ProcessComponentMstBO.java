package mms.masters.bo;

import mms.masters.dao.ProcessComponentMstDAO;
import mms.masters.vo.ProcessComponentMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcessComponentMstBO.
 * 
 * @author Anurudra Goel
 */

public class ProcessComponentMstBO {

	/**
	 * for getting option value of item category name combo on add page.
	 * 
	 * @param vo the vo
	 */

	public void initAdd(ProcessComponentMstVO vo) {

		ProcessComponentMstDAO.initAddQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ProcessComponentMstBO.initAdd() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public void insertRecord(ProcessComponentMstVO vo) {
		ProcessComponentMstDAO.initialAddQuery(vo);
		if (vo.getBExistStatus() == true) {
			ProcessComponentMstDAO.insertQuery(vo);
		}

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreTypeMstBO.insertRecord() --> "
					+ vo.getStrMsgString());

		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void modifyRecord(ProcessComponentMstVO vo) {

		ProcessComponentMstDAO.initAddQuery(vo);
		ProcessComponentMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ProcessComponentMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(ProcessComponentMstVO vo) {

		// StoreTypeMstDAO.initialUpdateQuery(vo);
		/*
		 * if (vo.getStrMsgType().equals("1")) {
		 * vo.setStrMsgString("StoreTypeMstBO.updateRecord() --> " +
		 * vo.getStrMsgString()); }
		 */
		// if (vo.getBExistStatus() == true) {
		ProcessComponentMstDAO.updateQuery(vo);
		// }
		if (vo.getStrMsgType().equals("1")) {

			vo.setStrMsgString("ProcessComponentMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}

	}
}
