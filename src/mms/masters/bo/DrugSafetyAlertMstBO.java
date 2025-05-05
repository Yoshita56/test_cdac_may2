package mms.masters.bo;

import mms.masters.dao.DrugSafetyAlertMstDAO;

import mms.masters.vo.DrugSafetyAlertMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugSafetyAlertMstBO.
 */
public class DrugSafetyAlertMstBO {

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void initialModify(DrugSafetyAlertMstVO vo) {

		DrugSafetyAlertMstDAO.initialModifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DrugSafetyAlertMstBO.initialModify() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void initialAdd(DrugSafetyAlertMstVO vo) {

		DrugSafetyAlertMstDAO.initialAddQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DrugSafetyAlertMstBO.initialAdd() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void getSubGroupCombo(DrugSafetyAlertMstVO vo) {

		DrugSafetyAlertMstDAO.getSubGroupCombo(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DrugSafetyAlertMstBO.getSubGroupCombo() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void getDrugCombo(DrugSafetyAlertMstVO vo) {

		DrugSafetyAlertMstDAO.getDrugCombo(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DrugSafetyAlertMstBO.getDrugCombo() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public void insertRecord(DrugSafetyAlertMstVO vo) {
		DrugSafetyAlertMstDAO.chkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DrugSafetyAlertMstBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			DrugSafetyAlertMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("DrugSafetyAlertMstBO.insertRecord() --> "
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

	public void modifyRecord(DrugSafetyAlertMstVO vo) {
		DrugSafetyAlertMstDAO.modifyQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DrugSafetyAlertMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(DrugSafetyAlertMstVO vo) {

		DrugSafetyAlertMstDAO.updateQuery(vo);

		/*
		 * DrugSafetyAlertMstDAO.initialUpdateQuery(vo);
		 */
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DrugSafetyAlertMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}
		/*
		 * if (vo.getBExistStatus() == true) {
		 *  }
		 */
	}

}
