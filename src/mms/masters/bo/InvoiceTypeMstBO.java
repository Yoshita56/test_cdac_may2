package mms.masters.bo;

import mms.masters.dao.InvoiceTypeMstDAO;
import mms.masters.vo.InvoiceTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class InvoiceTypeMstBO.
 * 
 * @author manas meher
 */

public class InvoiceTypeMstBO {

	/**
	 * to insert the data and check duplicate.
	 * 
	 * @param vo the vo
	 */

	public void insertQuery(InvoiceTypeMstVO vo) {

		InvoiceTypeMstDAO.chkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("InvoiceTypeMstBO.insertRecord() --> " + strErr);
		}
		if (vo.getBExistStatus() == true) {
			InvoiceTypeMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("InvoiceTypeMstBO.insertRecord() --> "
						+ strErr);
			}
		}
	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */

	public void modifyQuery(InvoiceTypeMstVO vo) {
		InvoiceTypeMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("InvoiceTypeMstBO.modifyQuery() --> " + strErr);

		}
	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */

	public void updateRecord(InvoiceTypeMstVO vo) {

		InvoiceTypeMstDAO.checkDuplicateRecord(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("InvoiceTypeMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			InvoiceTypeMstDAO.updateQuery(vo);
		}
		if (vo.getStrMsgType().equals("1")) {

			vo.setStrMsgString("InvoiceTypeMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * Inits the add.
	 * 
	 * @param vo the vo
	 */
	public void initAdd(InvoiceTypeMstVO vo) {

		// ComponentMstDAO.comboQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ComponentMstBO.initAdd() --> "
					+ vo.getStrMsgString());
		}
	}
}
