package mms.masters.bo;

import mms.masters.dao.GatePassTypeMstDAO;
import mms.masters.vo.GatePassTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class GatePassTypeMstBO.
 */
public class GatePassTypeMstBO {

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public void insertQuery(GatePassTypeMstVO vo) {
		GatePassTypeMstDAO.chkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("GatePassTypeMstBO.insertQuery() --> " + strErr);
		}
		if (vo.getBExistStatus() == true) {
			GatePassTypeMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("GatePassTypeMstBO.insertQuery() --> "
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
	public void modifyQuery(GatePassTypeMstVO vo) {
		GatePassTypeMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("GatePassTypeMstBO.modifyQuery() --> " + strErr);

		}
	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateQuery(GatePassTypeMstVO vo) {

		GatePassTypeMstDAO.initialUpdateQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("GatePassTypeMstBO.updateQuery() --> " + strErr);
		}
		if (vo.getBExistStatus() == true) {
			GatePassTypeMstDAO.updateQuery(vo);
			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("GatePassTypeMstBO.updateQuery() --> "
						+ strErr);
			}
		}
	}

}
