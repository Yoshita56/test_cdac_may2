package mms.masters.bo;

import mms.masters.dao.IndentTypeMstDAO;
import mms.masters.vo.IndentTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class IndentTypeMstBO.
 * 
 * @author Anshul Jindal
 */

public class IndentTypeMstBO {

	/**
	 * to insert the data and check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */
	public void insertRecord(IndentTypeMstVO vo) {

		IndentTypeMstDAO.chkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IndentTypeMstBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			IndentTypeMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("IndentTypeMstBO.insertRecord() --> "
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
	public void modifyRecord(IndentTypeMstVO vo) {

		IndentTypeMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IndentTypeMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(IndentTypeMstVO vo) {

		IndentTypeMstDAO.initialUpdateQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IndentTypeMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			IndentTypeMstDAO.updateQuery(vo);
		}
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IndentTypeMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}

	}

}
