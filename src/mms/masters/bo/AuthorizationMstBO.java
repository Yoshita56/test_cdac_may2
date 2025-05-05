package mms.masters.bo;

import mms.masters.dao.AuthorizationMstDAO;
import mms.masters.vo.AuthorizationMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthorizationMstBO.
 */
public class AuthorizationMstBO {

	/**
	 * Inits the add.
	 * 
	 * @param vo the vo
	 */
	public void initAdd(AuthorizationMstVO vo) {
		AuthorizationMstDAO.getUserName(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("AuthorizationMstBO.initAdd() --> " + strErr);
		}
	}

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public void insertQuery(AuthorizationMstVO vo) {
		AuthorizationMstDAO.chkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("AuthorizationMstBO.insertQuery() --> "
							+ strErr);
		}
		if (vo.getBExistStatus() == true) {
			AuthorizationMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("AuthorizationMstBO.insertQuery() --> "
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

	public void modifyRecord(AuthorizationMstVO vo) {
		AuthorizationMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("AuthorizationMstBO.modifyRecord() --> "
					+ strErr);
		}

	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(AuthorizationMstVO vo) {

		AuthorizationMstDAO.updateQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("AuthorizationMstBO.updateRecord() --> "
					+ strErr);
		}

	}

}
