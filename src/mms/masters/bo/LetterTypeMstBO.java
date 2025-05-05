package mms.masters.bo;

import mms.masters.dao.LetterTypeMstDAO;
import mms.masters.vo.LetterTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class LetterTypeMstBO.
 */
public class LetterTypeMstBO {

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public void insertQuery(LetterTypeMstVO vo) {
		LetterTypeMstDAO.chkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("LetterTypeMstBO.insertQuery() --> " + strErr);
		}
		if (vo.getBExistStatus() == true) {
			LetterTypeMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("LetterTypeMstBO.insertQuery() --> "
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

	public void modifyRecord(LetterTypeMstVO vo) {
		LetterTypeMstDAO.modifyQuery(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("LetterTypeMstBO.modifyRecord() --> " + strErr);
		}

	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(LetterTypeMstVO vo) {
		LetterTypeMstDAO.initialUpdateQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("LetterTypeMstBO.updateRecord() --> " + strErr);
		}
		if (vo.getBExistStatus() == true) {
			LetterTypeMstDAO.updateQuery(vo);
			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("LetterTypeMstBO.updateRecord() --> "
						+ strErr);
			}
		}
	}

}
