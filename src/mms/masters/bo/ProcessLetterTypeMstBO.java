package mms.masters.bo;

import mms.masters.dao.ProcessLetterTypeMstDAO;
import mms.masters.vo.ProcessLetterTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcessLetterTypeMstBO.
 * 
 * @author Tanvi Sappal
 */
public class ProcessLetterTypeMstBO {

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void initialAdd(ProcessLetterTypeMstVO vo) {
		ProcessLetterTypeMstDAO.initialAddQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ProcessLetterTypeMstBO.initialAdd() --> "
					+ strErr);
		}

	}

	/**
	 * Gets the left list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the left list
	 */
	public void getLeftList(ProcessLetterTypeMstVO vo) {
		ProcessLetterTypeMstDAO.leftListAddQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ProcessLetterTypeMstBO.getLeftList() --> "
					+ strErr);
		}

	}

	/**
	 * Gets the right list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the right list
	 */
	public void getRightList(ProcessLetterTypeMstVO vo) {
		ProcessLetterTypeMstDAO.rightListAddQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ProcessLetterTypeMstBO.getRightList() --> "
					+ strErr);
		}

	}

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public void insertQuery(ProcessLetterTypeMstVO vo) {
		ProcessLetterTypeMstDAO.chkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ProcessLetterTypeMstBO.insertRecord() --> "
					+ strErr);
		}
		if (vo.getBExistStatus() == true) {
			ProcessLetterTypeMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("ProcessLetterTypeMstBO.insertRecord() --> "
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

	public void modifyRecord(ProcessLetterTypeMstVO vo) {
		ProcessLetterTypeMstDAO.modifyQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ProcessLetterTypeMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(ProcessLetterTypeMstVO vo) {
		ProcessLetterTypeMstDAO.initialUpdateQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ProcessLetterTypeMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			ProcessLetterTypeMstDAO.updateQuery(vo);
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("ProcessLetterTypeMstBO.updateRecord() --> "
						+ vo.getStrMsgString());
			}
		}
	}

}
