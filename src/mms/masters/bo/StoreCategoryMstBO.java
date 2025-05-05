package mms.masters.bo;

import mms.masters.dao.StoreCategoryMstDAO;

import mms.masters.vo.StoreCategoryMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreCategoryMstBO.
 */
public class StoreCategoryMstBO {
	
	/**
	 * for getting values of left Category list,Right Category List on add page.
	 * 
	 * @param vo the vo
	 */

	public void initAdd(StoreCategoryMstVO vo) {

		StoreCategoryMstDAO.initAddQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreCategoryMstBO.initAdd() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * to insert the data and check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */
	public void insertRecord(StoreCategoryMstVO vo) {

		StoreCategoryMstDAO.insertQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreCategoryMstBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void modifyRecord(StoreCategoryMstVO vo) {

		StoreCategoryMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreCategoryMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * to update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(StoreCategoryMstVO vo) {

		StoreCategoryMstDAO.updateQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreCategoryMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}

	}

}
