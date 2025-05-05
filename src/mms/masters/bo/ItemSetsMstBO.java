package mms.masters.bo;

import mms.masters.dao.ItemSetsMstDAO;
import mms.masters.vo.ItemSetsMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemSetsMstBO.
 */
public class ItemSetsMstBO {

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void initialAdd(ItemSetsMstVO vo) {
		ItemSetsMstDAO.initialAddQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemSetsMstBO.initialAdd() --> " + strErr);
		}

	}

	/**
	 * Gets the sub group name.
	 * 
	 * @param vo the vo
	 * 
	 * @return the sub group name
	 */
	public void getSubGroupName(ItemSetsMstVO vo) {
		ItemSetsMstDAO.getAddQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemSetsMstBO.getSubGroupName() --> " + strErr);
		}

	}

	/**
	 * Item name.
	 * 
	 * @param vo the vo
	 */
	public void itemName(ItemSetsMstVO vo) {
		ItemSetsMstDAO.getItemQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemSetsMstBO.itemName() --> " + strErr);
		}

	}

	/**
	 * Gets the gen item name combo.
	 * 
	 * @param vo the vo
	 * 
	 * @return the gen item name combo
	 */
	public void getGenItemNameCombo(ItemSetsMstVO vo) {
		ItemSetsMstDAO.getGenItemNameCombo(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemSetsMstBO.getGenItemNameCombo() --> "
					+ strErr);
		}

	}

	/**
	 * Gets the group name.
	 * 
	 * @param vo the vo
	 * 
	 * @return the group name
	 */
	public void getGroupName(ItemSetsMstVO vo) {
		ItemSetsMstDAO.getGroupNameCombo(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemSetsMstBO.getGroupName() --> " + strErr);
		}

	}

	/**
	 * Item grp name.
	 * 
	 * @param vo the vo
	 */
	public void itemGrpName(ItemSetsMstVO vo) {
		ItemSetsMstDAO.getItemGrpQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemSetsMstBO.itemGrpName() --> " + strErr);
		}

	}

	/**
	 * Gets the unit values.
	 * 
	 * @param vo the vo
	 * 
	 * @return the unit values
	 */
	public void getUnitValues(ItemSetsMstVO vo) {
		ItemSetsMstDAO.getUnitValues(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemSetsMstBO.getUnitValues() --> " + strErr);
		}
	}

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public void insertQuery(ItemSetsMstVO vo) {

		ItemSetsMstDAO.chkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("ItemSetsMstBO.insertQuery() --> " + strErr);
		}
		if (vo.getBExistStatus() == true) {
			ItemSetsMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("ItemSetsMstBO.insertQuery() --> " + strErr);
			}
		}
	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */

	public void modifyRecord(ItemSetsMstVO vo) {
		ItemSetsMstDAO.modifyQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ItemSetsMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(ItemSetsMstVO vo) {
		ItemSetsMstDAO.updateQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ItemSetsMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}
	}

	public void getUnitValuesFromItemId(ItemSetsMstVO vo) {
		ItemSetsMstDAO.getUnitValuesFromItemId(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemSetsMstBO.getUnitValuesFromItemId(vo) --> " + strErr);
		}
		
	}

	public void getItemId(ItemSetsMstVO vo) {
		ItemSetsMstDAO.getItemId(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemSetsMstBO.getItemId() --> " + strErr);
		}
		
	}

}
