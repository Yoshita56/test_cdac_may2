package mms.masters.bo;

import mms.masters.dao.SparePartsMstDAO;
import mms.masters.vo.SparePartsMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SparePartsMstBO.
 */
public class SparePartsMstBO {

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void initialModify(SparePartsMstVO vo) {

		SparePartsMstDAO.initialModifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SparePartsMstMst.initialModifyQuery() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void initialAdd(SparePartsMstVO vo) {
		SparePartsMstDAO.initialAddQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SparePartsMstMst.initialAdd() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(SparePartsMstVO vo) {

		SparePartsMstDAO.updateQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SparePartsMst.updateRecord() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public void insertRecord(SparePartsMstVO vo) {

		SparePartsMstDAO.chkDuplicate(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("SparePartsMstBO.insertRecord() --> " + strErr);
		}
		if (vo.getBExistStatus() == true) {
			SparePartsMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("SparePartsMstBO.insertRecord() --> "
						+ strErr);
			}
		}
		/*
		 * SparePartsMstDAO.insertQuery(vo); if (vo.getStrMsgType().equals("1")) {
		 * vo.setStrMsgString("SparePartsMstBO.insertRecord() --> " +
		 * vo.getStrMsgString()); }
		 */

	}

	/*	*//**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	/*
	 * public void getItemNameCombo(SparePartsMstVO vo) {
	 * 
	 * SparePartsMstDAO.getItemNameCombo(vo); if
	 * (vo.getStrMsgType().equals("1")) {
	 * vo.setStrMsgString("SparePartsMstBO.getItemNameCombo() --> " +
	 * vo.getStrMsgString()); }
	 *  }
	 */

	public void getSubGroupName(SparePartsMstVO vo) {
		SparePartsMstDAO.getAddQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("SparePartsMstBO.getLeftList() --> " + strErr);
		}

	}

	/**
	 * Item grp name.
	 * 
	 * @param vo the vo
	 */
	public void itemGrpName(SparePartsMstVO vo) {
		SparePartsMstDAO.getItemGrpQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("SparePartsMstBO.itemGrpName() --> " + strErr);
		}

	}

	/**
	 * Item name.
	 * 
	 * @param vo the vo
	 */
	public void itemName(SparePartsMstVO vo) {
		SparePartsMstDAO.getItemQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("SparePartsMstBO.itemName() --> " + strErr);
		}

	}

	/*
	 * public void getUnitValues(SparePartsMstVO vo) {
	 * SparePartsMstDAO.getUnitValues(vo); if (vo.getStrMsgType().equals("1")) {
	 * 
	 * String strErr = vo.getStrMsgString();
	 * 
	 * vo.setStrMsgString("SparePartsMstBO.getUnitValues() --> " + strErr); } }
	 */

}
