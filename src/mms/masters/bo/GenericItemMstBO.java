package mms.masters.bo;

import mms.masters.dao.GenericItemMstDAO;
import mms.masters.vo.GenericItemMstVO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Anshul Jindal Version : 1.0 Date : 31/Jan/2009-May/09
 * 
 * 
 * 
 * Developer : Balasubramaniam M 
 * Version : 1.1 
 * Modified Date : 13/Jan/2010
 * Desc : Generic Master Inventory Unit cannot be Modified.
 * 
 */

public class GenericItemMstBO {

	/**
	 * Gets the inventory unit cmb.
	 * 
	 * @param vo the vo
	 * 
	 * @return the inventory unit cmb
	 */
	public void getInventoryUnitCmb(GenericItemMstVO vo) {
		GenericItemMstDAO.getStockMaintainedValues(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("GenericItemMstBO.getInventoryUnitCmb---->"
					+ vo.getStrMsgString());
	}

	
	/**
	 * Insert.
	 * 
	 * @param vo the vo
	 */
	public void insert(GenericItemMstVO vo) {

		GenericItemMstDAO.duplicacyAddQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("GenericItemMstbo.insert() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			GenericItemMstDAO.insert(vo);
			if (vo.getStrMsgType().equals("1"))
				vo.setStrMsgString("GenericItemMstBO.insert---->"
						+ vo.getStrMsgString());
		}
	}

	/**
	 * Modify.
	 * 
	 * @param vo the vo
	 */
	public void modify(GenericItemMstVO vo) {

		GenericItemMstDAO.modify(vo);
		GenericItemMstDAO.getItemCodeRequired(vo);
		
		//GenericItemMstDAO.getStockMaintainedValues(vo);
		// GenericItemMstDAO.getItemValues(vo);
		// GenericItemMstDAO.getUnitValues(vo);
		// GenericItemMstDAO.getManufacturerValues(vo);

		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("GenericItemMstBO.modify---->"
					+ vo.getStrMsgString());
	}

	/**
	 * Update.
	 * 
	 * @param vo the vo
	 */
	public void update(GenericItemMstVO vo) {
		GenericItemMstDAO.duplicacyUpdateQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("GenericItemMstbo.insert() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			GenericItemMstDAO.update(vo);
			if (vo.getStrMsgType().equals("1"))
				vo.setStrMsgString("GenericItemMstBO.update---->"
						+ vo.getStrMsgString());
		}
	}

	/*
	 * public void getUnitValues(GenericItemMstVO vo) { //
	 * GenericItemMstDAO.getUnitValues(vo); if (vo.getStrMsgType().equals("1"))
	 * vo.setStrMsgString("GenericItemMstBO.getUnitValues---->" +
	 * vo.getStrMsgString()); }
	 */

	/*
	 * public void getManufacturerValues(GenericItemMstVO vo) {
	 * GenericItemMstDAO.getManufacturerValues(vo); if
	 * (vo.getStrMsgType().equals("1"))
	 * vo.setStrMsgString("GenericItemMstBO.getManufacturerValues---->" +
	 * vo.getStrMsgString()); }
	 */

	/**
	 * Gets the stock maintained values.
	 * 
	 * @param vo the vo
	 * 
	 * @return the stock maintained values
	 */
	public void getStockMaintainedValues(GenericItemMstVO vo) {
		GenericItemMstDAO.getStockMaintainedValues(vo);
		GenericItemMstDAO.getItemCodeRequired(vo);
		
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("GenericItemMstBO.getStockMaintainedValues---->"
					+ vo.getStrMsgString());
	}

	/*
	 * public void getItemValues(GenericItemMstVO vo) {
	 * GenericItemMstDAO.getItemValues(vo); if (vo.getStrMsgType().equals("1"))
	 * vo.setStrMsgString("GenericItemMstBO.getItemValues---->" +
	 * vo.getStrMsgString()); }
	 */

	/*
	 * public void setBrandItemMstDtl(GenericItemMstVO vo) {
	 * GenericItemMstDAO.getBrandItemDtl(vo); if
	 * (vo.getStrMsgType().equals("1"))
	 * vo.setStrMsgString("GenericItemMstBO.setBrandItemMstDtl---->" +
	 * vo.getStrMsgString()); }
	 */

	/**
	 * View.
	 * 
	 * @param vo the vo
	 */
	public void view(GenericItemMstVO vo) {
		GenericItemMstDAO.view(vo);
		// GenericItemMstDAO.getItemValues(vo);
		// GenericItemMstDAO.getUnitValues(vo);
		GenericItemMstDAO.getStockMaintainedValues(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("GenericItemMstBO.view---->"
					+ vo.getStrMsgString());
	}

}
