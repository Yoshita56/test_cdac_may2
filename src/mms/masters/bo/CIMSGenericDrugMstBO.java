package mms.masters.bo;

import mms.masters.dao.CIMSGenericDrugMstDAO;
import mms.masters.vo.CIMSGenericDrugMstVO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Anshul Jindal Version : 1.0 Date : 31/Jan/2009-May/09
 */

public class CIMSGenericDrugMstBO {

	/**
	 * Insert.
	 * 
	 * @param vo the vo
	 */
	public void insert(CIMSGenericDrugMstVO vo) {
		//CIMSGenericDrugMstDAO.duplicacyAddQuery(vo);

				//if (vo.getBExistStatus() == true) {
			CIMSGenericDrugMstDAO.save(vo);
			if (vo.getStrMsgType().equals("1"))
				vo.setStrMsgString("GenericDrugMstBO.insert---->"
						+ vo.getStrMsgString());
		
	}

	/**
	 * Modify.
	 * 
	 * @param vo the vo
	 */
	public void modify(CIMSGenericDrugMstVO vo) {
		CIMSGenericDrugMstDAO.modify(vo);
		//CIMSGenericDrugMstDAO.getItemCodeRequired(vo);
		//CIMSGenericDrugMstDAO.getStockMaintainedValues(vo);
		//CIMSGenericDrugMstDAO.getSubgroupName(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("GenericDrugMstBO.modify---->"
					+ vo.getStrMsgString());
	}

	/**
	 * Update.
	 * 
	 * @param vo the vo
	 */
	public void update(CIMSGenericDrugMstVO vo) {
	/*	CIMSGenericDrugMstDAO.dupliUpdateQuery(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("GenericDrugMstBO.update---->"
					+ vo.getStrMsgString());
		if (vo.getBExistStatus() == true) {*/
			CIMSGenericDrugMstDAO.update(vo);
			if (vo.getStrMsgType().equals("1"))
				vo.setStrMsgString("GenericDrugMstBO.update---->"
						+ vo.getStrMsgString());
		
	}

	// change on 13 may09 after changes in table
	/*
	 * public void getUnitValues(CIMSGenericDrugMstVO vo) {
	 * CIMSGenericDrugMstDAO.getUnitValues(vo); if (vo.getStrMsgType().equals("1"))
	 * vo.setStrMsgString("GenericDrugMstBO.getUnitValues---->" +
	 * vo.getStrMsgString()); }
	 */

	/*
	 * public void getManufacturerValues(CIMSGenericDrugMstVO vo) {
	 * CIMSGenericDrugMstDAO.getManufacturerValues(vo); if
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
	public void getStockMaintainedValues(CIMSGenericDrugMstVO vo) 
	{
		CIMSGenericDrugMstDAO.getStockMaintainedValues(vo);		
		//CIMSGenericDrugMstDAO.getItemCodeRequired(vo);
		
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("GenericDrugMstBO.getStockMaintainedValues---->"+ vo.getStrMsgString());
	}

	// change on 14 may09 after changes in table
	/*
	 * public void getItemValues(CIMSGenericDrugMstVO vo) {
	 * CIMSGenericDrugMstDAO.getItemValues(vo); if (vo.getStrMsgType().equals("1"))
	 * vo.setStrMsgString("GenericDrugMstBO.getItemValues---->" +
	 * vo.getStrMsgString()); }
	 */

	/**
	 * Sets the brand item mst dtl.
	 * 
	 * @param vo the new brand item mst dtl
	 */
	public void setBrandItemMstDtl(CIMSGenericDrugMstVO vo) {
		CIMSGenericDrugMstDAO.getBrandItemDtl(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("GenericDrugMstBO.setBrandItemMstDtl---->"
					+ vo.getStrMsgString());
	}

	/**
	 * View.
	 * 
	 * @param vo the vo
	 */
	public void view(CIMSGenericDrugMstVO vo) {
		CIMSGenericDrugMstDAO.view(vo);
		// CIMSGenericDrugMstDAO.getItemValues(vo);
		// CIMSGenericDrugMstDAO.getUnitValues(vo);
		//CIMSGenericDrugMstDAO.getStockMaintainedValues(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("GenericDrugMstBO.view---->"
					+ vo.getStrMsgString());
	}
	
	public void getSubgroupName(CIMSGenericDrugMstVO vo) {
		CIMSGenericDrugMstDAO.getSubgroupName(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("GenericDrugMstBO.view---->"
					+ vo.getStrMsgString());
	}
	
	
	public void getPregCat(CIMSGenericDrugMstVO vo) {
		CIMSGenericDrugMstDAO.getPregCatValues(vo);
		
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("CIMSGenericDrugMstBO.getPregCat---->"
					+ vo.getStrMsgString());
	}
	public void getContracdictoryDrugList(CIMSGenericDrugMstVO vo) {
		CIMSGenericDrugMstDAO.getContracdictoryDrugList(vo);
		
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("CIMSGenericDrugMstBO.getDrug---->"
					+ vo.getStrMsgString());
	}
	public void getAdministartion(CIMSGenericDrugMstVO vo) {
		CIMSGenericDrugMstDAO.getAdministartion(vo);
		
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("CIMSGenericDrugMstBO.getAdmin---->"
					+ vo.getStrMsgString());
	}
	public void getStorage(CIMSGenericDrugMstVO vo) {
		CIMSGenericDrugMstDAO.getStorage(vo);
		
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("CIMSGenericDrugMstBO.getStorage---->"
					+ vo.getStrMsgString());
	}
	public void getContraindicationsList(CIMSGenericDrugMstVO vo) {
		CIMSGenericDrugMstDAO.getContraindicationsList(vo);
		
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("CIMSGenericDrugMstBO.getContraind---->"
					+ vo.getStrMsgString());
	}
	public void getAdminRoute(CIMSGenericDrugMstVO vo) {
		CIMSGenericDrugMstDAO.getAdminRoute(vo);
		
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("CIMSGenericDrugMstBO.getAdminRoute---->"
					+ vo.getStrMsgString());
	}
}
