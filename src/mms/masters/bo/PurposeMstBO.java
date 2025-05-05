package mms.masters.bo;

import mms.masters.dao.PurposeMstDAO;
import mms.masters.vo.PurposeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PurposeMstBO.
 * 
 * @author Baisakhi Roy
 */
public class PurposeMstBO {
	
	/**
	 * to insert the data and check duplicate.
	 * 
	 * @param vo the vo
	 */

	public void insertQuery(PurposeMstVO vo) {
		PurposeMstDAO.chkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("PurposeMstBO.insertQuery() --> " + strErr);
		}
		if (vo.isBExistStatus() == true) {
			PurposeMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("PurposeMstBO.insertQuery() --> " + strErr);
			}
		}
	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */

	public void modifyQuery(PurposeMstVO vo) {
		PurposeMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("PurposeMstBO.modifyQuery() --> " + strErr);

		}
	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */

	public void updateRecord(PurposeMstVO vo) {

		PurposeMstDAO.checkDuplicateRecord(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("PurposeMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.isBExistStatus() == true) {
			PurposeMstDAO.updateQuery(vo);
		}
		if (vo.getStrMsgType().equals("1")) {

			vo.setStrMsgString("PurposeMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}

	}
}
