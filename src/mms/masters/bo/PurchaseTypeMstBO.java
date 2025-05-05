package mms.masters.bo;

import mms.masters.dao.PurchaseTypeMstDAO;
import mms.masters.vo.PurchaseTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PurchaseTypeMstBO.
 * 
 * @author Anshul Jindal
 */
public class PurchaseTypeMstBO {

	/**
	 * to insert the data and check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */
	public void insertRecord(PurchaseTypeMstVO vo) {
		PurchaseTypeMstDAO.initialAddQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("PurchaseTypeMstBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			PurchaseTypeMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("PurchaseTypeMstBO.insertRecord() --> "
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
	public void modifyRecord(PurchaseTypeMstVO vo) {

		PurchaseTypeMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("PurchaseTypeMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(PurchaseTypeMstVO vo) {
		PurchaseTypeMstDAO.initialUpdateQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("PurchaseTypeMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			PurchaseTypeMstDAO.updateQuery(vo);
		}
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("PurchaseTypeMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}

	}

}