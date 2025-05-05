package mms.masters.bo;

import mms.masters.dao.SupplierItemMstDAO;

import mms.masters.vo.SupplierItemMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierItemMstBO.
 * 
 * @author Anshul Jindal
 */
public class SupplierItemMstBO {
	
	/**
	 * for getting option value of item name combo and rate unit combo on add
	 * page.
	 * 
	 * @param vo the vo
	 */

	public void initAdd(SupplierItemMstVO vo) {

		SupplierItemMstDAO.initAddQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierItemMstBO.initAdd() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * to insert the data and check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */
	public void insertRecord(SupplierItemMstVO vo) {

		/*
		 * SupplierItemMstDAO.chkDuplicate(vo);
		 * 
		 * if (vo.getStrMsgType().equals("1")) {
		 * vo.setStrMsgString("SupplierItemMstBO.insertRecord() --> " +
		 * vo.getStrMsgString()); }
		 */

		SupplierItemMstDAO.insertQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierItemMstBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void modifyRecord(SupplierItemMstVO vo) {

		SupplierItemMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierItemMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(SupplierItemMstVO vo) {

		SupplierItemMstDAO.updateQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierItemMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * To get option value of left item list on ADD page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void getLeftItemList(SupplierItemMstVO vo) {

		SupplierItemMstDAO.getLeftItemList(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierItemMstBO.getLeftItemList() --> "
					+ vo.getStrMsgString());
		}

	}

	/*	*//**
			 * To get option value of brand combo on MODIFY page
			 * 
			 * @param vo
			 * @throws Exception
			 */
	/*
	 * public void getBrandName(SupplierItemMstVO vo){
	 * 
	 * SupplierItemMstDAO.getBrandNameQuery(vo); if
	 * (vo.getStrMsgType().equals("1")) {
	 * vo.setStrMsgString("SupplierItemMstBO.getBrandName() --> " +
	 * vo.getStrMsgString()); }
	 *  }
	 *//**
		 * To get option value of Unit combo
		 * 
		 * @param vo
		 * @throws Exception
		 */
	/*
	 * public void getUnitValues(SupplierItemMstVO vo){
	 * 
	 * SupplierItemMstDAO.getUnitValues(vo); if (vo.getStrMsgType().equals("1")) {
	 * vo.setStrMsgString("SupplierItemMstBO.getUnitValues() --> " +
	 * vo.getStrMsgString()); }
	 *  }
	 *//**
		 * To get option value of sub group combo on ADD page
		 * 
		 * @param vo
		 * @throws Exception
		 */
	/*
	 * public void getSubGroupCombo(SupplierItemMstVO vo){
	 * 
	 * SupplierItemMstDAO.getSubGroupComboQuery(vo); if
	 * (vo.getStrMsgType().equals("1")) {
	 * vo.setStrMsgString("SupplierItemMstBO.getSubGroupCombo() --> " +
	 * vo.getStrMsgString()); }
	 *  }
	 * 
	 *//**
		 * To get option value of Item Name combo on ADD page
		 * 
		 * @param vo
		 * @throws Exception
		 */
	/*
	 * public void getItemNameCombo(SupplierItemMstVO vo){
	 * 
	 * SupplierItemMstDAO.getItemNameComboQuery(vo); if
	 * (vo.getStrMsgType().equals("1")) {
	 * vo.setStrMsgString("SupplierItemMstBO.getItemNameCombo() --> " +
	 * vo.getStrMsgString()); }
	 *  }
	 */

}
