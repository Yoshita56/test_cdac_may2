package mms.masters.bo;

import mms.masters.dao.StoreTypeMstDAO;
import mms.masters.vo.StoreTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreTypeMstBO.
 * 
 * @author Anshul Jindal
 */

public class StoreTypeMstBO {

	/*	*//**
	 * for getting option value of item category name combo on add page.
	 * 
	 * @param vo the vo
	 */
	/*
	 * COMMENTED AFTER CHANGES IN TABLES ON 17TH-FEB-2009
	 * 
	 * public void initAdd(StoreTypeMstVO vo) {
	 * 
	 * StoreTypeMstDAO.initAddQuery(vo);
	 * 
	 * if (vo.getStrMsgType().equals("1")) {
	 * vo.setStrMsgString("StoreTypeMstBO.initAdd() --> " +
	 * vo.getStrMsgString()); } }
	 */

	/**
	 * to insert the data
	 * 
	 * @param vo
	 */
	public void insertRecord(StoreTypeMstVO vo) {
		StoreTypeMstDAO.initialAddQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreTypeMstBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			StoreTypeMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("StoreTypeMstBO.insertRecord() --> "
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
	public void modifyRecord(StoreTypeMstVO vo) {

		StoreTypeMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreTypeMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(StoreTypeMstVO vo) {

		StoreTypeMstDAO.initialUpdateQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreTypeMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			StoreTypeMstDAO.updateQuery(vo);
		}
		if (vo.getStrMsgType().equals("1")) {

			vo.setStrMsgString("StoreTypeMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}

	}
}
