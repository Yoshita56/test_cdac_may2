package mms.masters.bo;

import mms.masters.dao.DispatchModeMstDAO;
import mms.masters.vo.DispatchModeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class DispatchModeMstBO.
 */
public class DispatchModeMstBO {

	/**
	 * to insert the data and check duplicate.
	 * 
	 * @param vo the vo
	 */

	public void insertQuery(DispatchModeMstVO vo) {
		DispatchModeMstDAO.chkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("DispatchModeMstBO.insertQuery() --> " + strErr);
		}
		if (vo.getBExistStatus() == true) {
			DispatchModeMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("DispatchModeMstBO.insertQuery() --> "
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

	public void modifyQuery(DispatchModeMstVO vo) {
		DispatchModeMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("DispatchModeMstBO.modifyQuery() --> " + strErr);

		}
	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */

	public void updateRecord(DispatchModeMstVO vo) {

		DispatchModeMstDAO.checkDuplicateRecord(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DispatchModeMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			DispatchModeMstDAO.updateQuery(vo);
		}
		if (vo.getStrMsgType().equals("1")) {

			vo.setStrMsgString("DispatchModeMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * Inits the add.
	 * 
	 * @param vo the vo
	 */
	public void initAdd(DispatchModeMstVO vo) {

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DispatchModeMstBO.initAdd() --> "
					+ vo.getStrMsgString());
		}
	}

}
