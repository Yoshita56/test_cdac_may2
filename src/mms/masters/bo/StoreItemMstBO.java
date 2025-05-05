package mms.masters.bo;

import mms.masters.dao.StoreItemMstDAO;
import mms.masters.vo.StoreItemMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreItemMstBO.
 * 
 * @author Anshul Jindal
 */

/**
 * Developer : Tanvi Sappal Version : 1.0 Modify Date : 13/May/2009
 * 
 */
public class StoreItemMstBO {

	/**
	 * for getting option value of level unit combo.
	 * 
	 * @param vo the vo
	 */

	public void getUnitCombo(StoreItemMstVO vo) {

		StoreItemMstDAO.getUnitCombo(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreItemMstBO.getUnitCombo() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * for getting option value of item name combo and level unit combo on add
	 * page.
	 * 
	 * @param vo the vo
	 */

	public void initAdd(StoreItemMstVO vo) {

		StoreItemMstDAO.initAddQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreItemMstBO.initAdd() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * to insert the data and check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */
	public void insertRecord(StoreItemMstVO vo) {

		StoreItemMstDAO.chkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreItemMstBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			StoreItemMstDAO.InsertQueryLogic(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("StoreItemMstBO.insertRecord() --> "
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
	public void modifyRecord(StoreItemMstVO vo) {

		StoreItemMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreItemMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(StoreItemMstVO vo) {

		//StoreItemMstDAO.initialUpdateQuery(vo);
		StoreItemMstDAO.updateQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreItemMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}

//		if (vo.getBExistStatus() == true) {
//			StoreItemMstDAO.updateQuery(vo);
//		}
//		if (vo.getStrMsgType().equals("1")) {
//			vo.setStrMsgString("StoreItemMstBO.updateRecord() --> "
//					+ vo.getStrMsgString());
//		}

	}
	
	
	
	/**
	 * To get option value of Item brand combo on on basis of Group Id.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void getGrpAllItemNameCombo(StoreItemMstVO vo) {

		StoreItemMstDAO.getGrpAllItemNameCombo(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreItemMstBO.getGrpAllItemNameCombo() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * To get option value of brand combo on MODIFY page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void getBrandName(StoreItemMstVO vo) {

		StoreItemMstDAO.getBrandNameQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreItemMstBO.getBrandName() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * To get option value of sub group combo on ADD page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void getSubGroupCombo(StoreItemMstVO vo) {

		StoreItemMstDAO.getSubGroupComboQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreItemMstBO.getSubGroupCombo() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * To get option value of Item Name combo on ADD page associate with Group
	 * Id.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void itemGrpNameCombo(StoreItemMstVO vo) {
		StoreItemMstDAO.getItemGrpComboQuery(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("ItemSetsMstBO.itemGrpNameCombo() --> "
							+ strErr);
		}

	}

	/**
	 * To get option value of Item Name combo on ADD page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void getItemNameCombo(StoreItemMstVO vo) {

		StoreItemMstDAO.getItemNameComboQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreItemMstBO.getItemNameCombo() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * for getting option value of store combo on batch update page.
	 * 
	 * @param vo the vo
	 */

	public void getBatchUpdateStoreCombo(StoreItemMstVO vo) {

		StoreItemMstDAO.getBatchUpdateStoreCombo(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreItemMstBO.getBatchUpdateStoreCombo() --> "
					+ vo.getStrMsgString());
		}
	}

}
