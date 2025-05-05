package mms.masters.bo;

import mms.masters.dao.ComponentMstDAO;

import mms.masters.vo.ComponentMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ComponentMstBO.
 * 
 * @author manas
 */

public class ComponentMstBO {

	/**
	 * for getting option value of item category name combo on add page.
	 * 
	 * @param vo the vo
	 */

	public void initAdd(ComponentMstVO vo) {

		ComponentMstDAO.comboQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ComponentMstBO.initAdd() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */

	public void insertRecord(ComponentMstVO vo) {
		ComponentMstDAO.checkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ComponentMstBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			ComponentMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("ComponentMstBO.insertRecord() --> "
						+ vo.getStrMsgString());
			}
		}
	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */

	public void modifyRecord(ComponentMstVO vo) {

		ComponentMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ComponentMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */

	public void updateRecord(ComponentMstVO vo) {

		ComponentMstDAO.checkDuplicateRecord(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ComponentMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			ComponentMstDAO.updateQuery(vo);
		}
		if (vo.getStrMsgType().equals("1")) {

			vo.setStrMsgString("ComponentMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}

	}
}
