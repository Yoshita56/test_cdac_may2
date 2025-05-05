package mms.masters.bo;

import mms.masters.dao.DeliveryModeMstDAO;

import mms.masters.vo.DeliveryModeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class DeliveryModeMstBO.
 * 
 * @author manas meher
 */

public class DeliveryModeMstBO {

	/**
	 * to insert the data and check duplicate.
	 * 
	 * @param vo the vo
	 */

	public void insertQuery(DeliveryModeMstVO vo) {
		DeliveryModeMstDAO.chkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("DeliveryModeMstBO.insertQuery() --> " + strErr);
		}
		if (vo.getBExistStatus() == true) {
			DeliveryModeMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("DeliveryModeMstBO.insertQuery() --> "
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

	public void modifyQuery(DeliveryModeMstVO vo) {
		DeliveryModeMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("DeliveryModeMstBO.modifyQuery() --> " + strErr);

		}
	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */

	public void updateRecord(DeliveryModeMstVO vo) {

		DeliveryModeMstDAO.checkDuplicateRecord(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DeliveryModeMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			DeliveryModeMstDAO.updateQuery(vo);
		}
		if (vo.getStrMsgType().equals("1")) {

			vo.setStrMsgString("DeliveryModeMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * Inits the add.
	 * 
	 * @param vo the vo
	 */
	public void initAdd(DeliveryModeMstVO vo) {

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DeliveryModeMstBO.initAdd() --> "
					+ vo.getStrMsgString());
		}
	}
}
