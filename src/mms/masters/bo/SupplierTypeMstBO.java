/**
 * 
 */
package mms.masters.bo;

import mms.masters.dao.SupplierTypeMstDAO;
import mms.masters.vo.SupplierTypeMstVO;

/**
 * Developer : Tanvi Sappal
 * Create Date : 26/Oct/2009
 * Process Name : Supplier Type Master
 * Version : 1.1
 * Modify By/Date : 
 */

public class SupplierTypeMstBO {
	
	/**
	 * to insert the data
	 * 
	 * @param vo
	 */
	public void insertRecord(SupplierTypeMstVO vo) {
		SupplierTypeMstDAO.initialAddQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierTypeMstBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			SupplierTypeMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("SupplierTypeMstBO.insertRecord() --> "
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
	public void modifyRecord(SupplierTypeMstVO vo) {

		SupplierTypeMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierTypeMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(SupplierTypeMstVO vo) {

		SupplierTypeMstDAO.initialUpdateQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierTypeMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			SupplierTypeMstDAO.updateQuery(vo);
		}
		if (vo.getStrMsgType().equals("1")) {

			vo.setStrMsgString("SupplierTypeMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}

	}

}
