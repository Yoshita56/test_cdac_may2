package mms.masters.bo;

import mms.masters.dao.IndentAuthorizationMstDAO;
import mms.masters.vo.IndentAuthorizationMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class IndentAuthorizationMstBO.
 */
public class IndentAuthorizationMstBO {
	
	/**
	 * Inits the add.
	 * 
	 * @param vo the vo
	 */
	public void initAdd(IndentAuthorizationMstVO vo) {

		IndentAuthorizationMstDAO.initAddQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IndentAuthorizationMstBO.initAdd() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public void insertQuery(IndentAuthorizationMstVO vo) {

		IndentAuthorizationMstDAO.chkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("IndentAuthorizationMstBO.insertQuery() --> "
					+ strErr);
		}
		if (vo.isBExistStatus() == true) {
			IndentAuthorizationMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo
						.setStrMsgString("IndentAuthorizationMstBO.insertQuery() --> "
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
	public void modifyRecord(IndentAuthorizationMstVO vo) {

		IndentAuthorizationMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IndentAuthorizationMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(IndentAuthorizationMstVO vo) {

		IndentAuthorizationMstDAO.initialUpdateQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IndentAuthorizationMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.isBExistStatus() == true) {

			IndentAuthorizationMstDAO.updateQuery(vo);
		}
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IndentAuthorizationMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}

	}

}
