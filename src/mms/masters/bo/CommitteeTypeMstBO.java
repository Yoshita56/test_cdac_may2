package mms.masters.bo;

import mms.masters.dao.CommitteeTypeMstDAO;
import mms.masters.vo.CommitteeTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CommitteeTypeMstBO.
 * 
 * @author Tanvi Sappal
 */

public class CommitteeTypeMstBO {

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public void insertQuery(CommitteeTypeMstVO vo) {
		CommitteeTypeMstDAO.chkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("CommitteeTypeMstBO.insertQuery() --> "
							+ strErr);
		}
		if (vo.getBExistStatus() == true) {
			CommitteeTypeMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("CommitteeTypeMstBO.insertQuery() --> "
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

	public void modifyRecord(CommitteeTypeMstVO vo) {
		CommitteeTypeMstDAO.modifyQuery(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("CommitteeTypeMstBO.modifyRecord() --> "
					+ strErr);
		}

	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(CommitteeTypeMstVO vo) {
		CommitteeTypeMstDAO.initialUpdateQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("CommitteeTypeMstBO.updateRecord() --> "
					+ strErr);
		}
		if (vo.getBExistStatus() == true) {
			CommitteeTypeMstDAO.updateQuery(vo);
			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("CommitteeTypeMstBO.updateRecord() --> "
						+ strErr);
			}
		}
	}

}
