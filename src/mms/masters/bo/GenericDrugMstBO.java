package mms.masters.bo;

import mms.masters.dao.GenericDrugMstDAO;
import mms.masters.vo.GenericDrugMstVO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Anshul Jindal Version : 1.0 Date : 31/Jan/2009-May/09
 */

public class GenericDrugMstBO {

	/**
	 * Insert.
	 * 
	 * @param vo the vo
	 */
	public void insert(GenericDrugMstVO vo) {
		GenericDrugMstDAO.duplicacyAddQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("GenericDrugMsttbo.insert() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			GenericDrugMstDAO.insert(vo);
			if (vo.getStrMsgType().equals("1"))
				vo.setStrMsgString("GenericDrugMstBO.insert---->"
						+ vo.getStrMsgString());
		}
	}

	/**
	 * Modify.
	 * 
	 * @param vo the vo
	 */
	public void modify(GenericDrugMstVO vo) {
		GenericDrugMstDAO.modify(vo);
		GenericDrugMstDAO.getItemCodeRequired(vo);
		//GenericDrugMstDAO.getStockMaintainedValues(vo);
		//GenericDrugMstDAO.getSubgroupName(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("GenericDrugMstBO.modify---->"
					+ vo.getStrMsgString());
	}

	/**
	 * Update.
	 * 
	 * @param vo the vo
	 */
	public void update(GenericDrugMstVO vo) {
		GenericDrugMstDAO.dupliUpdateQuery(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("GenericDrugMstBO.update---->"
					+ vo.getStrMsgString());
		if (vo.getBExistStatus() == true) {
			GenericDrugMstDAO.update(vo);
			if (vo.getStrMsgType().equals("1"))
				vo.setStrMsgString("GenericDrugMstBO.update---->"
						+ vo.getStrMsgString());
		}
	}

	// change on 13 may09 after changes in table
	/*
	 * public void getUnitValues(GenericDrugMstVO vo) {
	 * GenericDrugMstDAO.getUnitValues(vo); if (vo.getStrMsgType().equals("1"))
	 * vo.setStrMsgString("GenericDrugMstBO.getUnitValues---->" +
	 * vo.getStrMsgString()); }
	 */

	/*
	 * public void getManufacturerValues(GenericDrugMstVO vo) {
	 * GenericDrugMstDAO.getManufacturerValues(vo); if
	 * (vo.getStrMsgType().equals("1"))
	 * vo.setStrMsgString("GenericDrugMstBO.getManufacturerValues---->" +
	 * vo.getStrMsgString()); }
	 */

	/**
	 * Gets the stock maintained values.
	 * 
	 * @param vo the vo
	 * 
	 * @return the stock maintained values
	 */
	public void getStockMaintainedValues(GenericDrugMstVO vo) {
		GenericDrugMstDAO.getStockMaintainedValues(vo);
		
		GenericDrugMstDAO.getItemCodeRequired(vo);
		
		
		
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("GenericDrugMstBO.getStockMaintainedValues---->"
					+ vo.getStrMsgString());
	}

	// change on 14 may09 after changes in table
	/*
	 * public void getItemValues(GenericDrugMstVO vo) {
	 * GenericDrugMstDAO.getItemValues(vo); if (vo.getStrMsgType().equals("1"))
	 * vo.setStrMsgString("GenericDrugMstBO.getItemValues---->" +
	 * vo.getStrMsgString()); }
	 */

	/**
	 * Sets the brand item mst dtl.
	 * 
	 * @param vo the new brand item mst dtl
	 */
	public void setBrandItemMstDtl(GenericDrugMstVO vo) {
		GenericDrugMstDAO.getBrandItemDtl(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("GenericDrugMstBO.setBrandItemMstDtl---->"
					+ vo.getStrMsgString());
	}

	/**
	 * View.
	 * 
	 * @param vo the vo
	 */
	public void view(GenericDrugMstVO vo) {
		GenericDrugMstDAO.view(vo);
		// GenericDrugMstDAO.getItemValues(vo);
		// GenericDrugMstDAO.getUnitValues(vo);
		GenericDrugMstDAO.getStockMaintainedValues(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("GenericDrugMstBO.view---->"
					+ vo.getStrMsgString());
	}
	
	public void getSubgroupName(GenericDrugMstVO vo) {
		GenericDrugMstDAO.getSubgroupName(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("GenericDrugMstBO.view---->"
					+ vo.getStrMsgString());
	}
	
	
	

}
