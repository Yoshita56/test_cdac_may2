package mms.masters.bo;

import mms.masters.dao.DrugDosegeIndicationMstDAO;
import mms.masters.vo.DrugDosegeIndicationMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugDosegeIndicationMstBO.
 */
public class DrugDosegeIndicationMstBO {

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void initialModify(DrugDosegeIndicationMstVO vo) {

		DrugDosegeIndicationMstDAO.initialModifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DrugDosegeIndicationMstBO.initialModify() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void initialAdd(DrugDosegeIndicationMstVO vo) {

		DrugDosegeIndicationMstDAO.initialAddQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DrugDosegeIndicationMstBO.initialAdd() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void getSubGroupCombo(DrugDosegeIndicationMstVO vo) {

		DrugDosegeIndicationMstDAO.getSubGroupCombo(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("DrugDosegeIndicationMstBO.getSubGroupCombo() --> "
							+ vo.getStrMsgString());
		}

	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void getDrugCombo(DrugDosegeIndicationMstVO vo) {

		DrugDosegeIndicationMstDAO.getDrugCombo(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DrugDosegeIndicationMstBO.getDrugCombo() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public void insertRecord(DrugDosegeIndicationMstVO vo) {
		DrugDosegeIndicationMstDAO.chkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DrugDosegeIndicationMstBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			DrugDosegeIndicationMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo
						.setStrMsgString("DrugDosegeIndicationMstBO.insertRecord() --> "
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

	public void modifyRecord(DrugDosegeIndicationMstVO vo) {
		DrugDosegeIndicationMstDAO.modifyQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DrugDosegeIndicationMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(DrugDosegeIndicationMstVO vo) {

		DrugDosegeIndicationMstDAO.updateQuery(vo);

		/*
		 * DrugDosegeIndicationMstDAO.initialUpdateQuery(vo); if
		 * (vo.getStrMsgType().equals("1")) {
		 * vo.setStrMsgString("BOIndentTypeMst.updateRecord() --> " +
		 * vo.getStrMsgString()); } if (vo.getBExistStatus() == true) {
		 *  }
		 */
	}

}
