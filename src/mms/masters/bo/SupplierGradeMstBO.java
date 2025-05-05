package mms.masters.bo;

import mms.masters.dao.SupplierGradeMstDAO;
import mms.masters.vo.SupplierGradeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierGradeMstBO.
 * 
 * @author Tanvi Sappal
 */

public class SupplierGradeMstBO {

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public void insertQuery(SupplierGradeMstVO vo) {
		SupplierGradeMstDAO.chkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("SupplierGradeMstBO.insertQuery() --> "
							+ strErr);
		}
		if (vo.getBExistStatus() == true) {
			SupplierGradeMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("SupplierGradeMstBO.insertQuery() --> "
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
	public void modifyQuery(SupplierGradeMstVO vo) {
		SupplierGradeMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("SupplierGradeMstBO.modifyQuery() --> "
							+ strErr);

		}
	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateQuery(SupplierGradeMstVO vo) {

		SupplierGradeMstDAO.initialUpdateQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("SupplierGradeMstBO.updateQuery() --> "
							+ strErr);
		}
		if (vo.getBExistStatus() == true) {
			SupplierGradeMstDAO.updateQuery(vo);
			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("SupplierGradeMstBO.updateQuery() --> "
						+ strErr);
			}
		}
	}

}
