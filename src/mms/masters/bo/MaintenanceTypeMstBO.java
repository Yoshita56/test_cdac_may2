package mms.masters.bo;

import mms.masters.dao.MaintenanceTypeMstDAO;
import mms.masters.vo.MaintenanceTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class MaintenanceTypeMstBO.
 */
public class MaintenanceTypeMstBO {

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public void insertQuery(MaintenanceTypeMstVO vo) {
		MaintenanceTypeMstDAO.chkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MaintenanceTypeMstBO.insertQuery() --> "
					+ strErr);
		}
		if (vo.getBExistStatus() == true) {
			MaintenanceTypeMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("MaintenanceTypeMstBO.insertQuery() --> "
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
	public void modifyQuery(MaintenanceTypeMstVO vo) {
		MaintenanceTypeMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MaintenanceTypeMstBO.modifyQuery() --> "
					+ strErr);

		}
	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateQuery(MaintenanceTypeMstVO vo) {

		MaintenanceTypeMstDAO.initialUpdateQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MaintenanceTypeMstBO.updateQuery() --> "
					+ strErr);
		}
		if (vo.getBExistStatus() == true) {
			MaintenanceTypeMstDAO.updateQuery(vo);
			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("MaintenanceTypeMstBO.updateQuery() --> "
						+ strErr);
			}
		}
	}

}
