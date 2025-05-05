package mms.masters.bo;

import mms.masters.dao.ItemParameterMstDAO;
import mms.masters.vo.ItemParameterMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemParameterMstBO.
 * 
 * @author manas
 */

public class ItemParameterMstBO {

	/**
	 * to insert the data and check duplicate in insert.
	 * 
	 * @param vo the vo
	 */

	public void insertQuery(ItemParameterMstVO vo) {
		ItemParameterMstDAO.chkDuplicateInsert(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemParameterMstBO.insertRecord() --> "
					+ strErr);
		}

		if (vo.isBExistsStatus()) {
			ItemParameterMstDAO.insertQuery(vo);

		} else {

			vo.setStrMsgType("2");

		}
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemParameterMstBO.insertRecord() --> "
					+ strErr);

		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */

	public void modifyQuery(ItemParameterMstVO vo) {

		ItemParameterMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("ItemParameterMstBO.modifyQuery() --> "
							+ strErr);

		}
	}

	/**
	 * for getting option value of parent parameter name combo on add page.
	 * 
	 * @param vo the vo
	 */

	public void initAdd(ItemParameterMstVO vo) {

		ItemParameterMstDAO.getParentParameter(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemParameterMstBO.initAdd() --> " + strErr);
		}
	}

	/**
	 * to modify and check duplicate in modify.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */

	public void updateQuery(ItemParameterMstVO vo) {

		ItemParameterMstDAO.chkDuplicateupdate(vo);

		if (vo.isBExistsStatus()) {
			ItemParameterMstDAO.updateQuery(vo);
		} else {
			vo.setStrMsgType("2");
		}

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("GenericItemMstBO.updateQuery() --> " + strErr);

		}

	}
}
