package mms.masters.bo;

import mms.masters.dao.StoreReqTypeMstDAO;

import mms.masters.vo.StoreReqTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreReqTypeMstBO.
 */
public class StoreReqTypeMstBO {
	
	/**
	 * for getting values of leftRequest Type list,Right Request Type List on
	 * add page.
	 * 
	 * @param vo the vo
	 */

	public void initAdd(StoreReqTypeMstVO vo) {

		StoreReqTypeMstDAO.initAddQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreReqTypeMstBO.initAdd() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * to insert the data and check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */
	public void insertRecord(StoreReqTypeMstVO vo) {

		StoreReqTypeMstDAO.insertQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreReqTypeMstBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void modifyRecord(StoreReqTypeMstVO vo) {

		StoreReqTypeMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreReqTypeMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * to update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(StoreReqTypeMstVO vo) {

		StoreReqTypeMstDAO.updateQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreReqTypeMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}

	}

}
