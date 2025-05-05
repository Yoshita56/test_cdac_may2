/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         StockOnHandRptBO.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.masters.bo;

import mms.masters.dao.StoreItemMappingMstDAO;
import mms.masters.vo.StoreItemMappingMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StockOnHandRptBO.
 */
public class StoreItemMappingMstBO {
	/**
	 * Gets the circle list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the circle list
	 */
	public void getCircleList(StoreItemMappingMstVO voObj) {

		StoreItemMappingMstDAO.getCircleList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandRptBO.getCircleList()-->"
					+ strErr);
		}

	}

	/**
	 * Gets the district list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the district list
	 */
	public void getDistrictList(StoreItemMappingMstVO voObj) {

		StoreItemMappingMstDAO.getDistrictList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandRptBO.getDistrictList()-->"
					+ strErr);
		}

	}

	/**
	 * Gets the store list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the store list
	 */
	public void getStoreList(StoreItemMappingMstVO voObj) {

		StoreItemMappingMstDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandRptBO.getStoreList()-->" + strErr);
		}

	}

	/**
	 * Gets the store type list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the store type list
	 */
	public void getStoreTypeList(StoreItemMappingMstVO voObj) {

		StoreItemMappingMstDAO.getDwhTypeCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandRptBO.getStoreTypeList()-->"
					+ strErr);
		}

	}

	/**
	 * Gets the sub store list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the sub store list
	 */
	public void getSubStoreList(StoreItemMappingMstVO voObj) {

		StoreItemMappingMstDAO.getSubStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandRptBO.getStoreList()-->" + strErr);
		}

	}

	
	/**
	 * Gets the item cat list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the item cat list
	 */
	public void getItemCatList(StoreItemMappingMstVO voObj) {

		StoreItemMappingMstDAO.getItemCatList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandRptBO.getItemCatList()-->"
					+ strErr);
		}

	}

	/**
	 * Gets the group list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the group list
	 */
	public void getGroupList(StoreItemMappingMstVO voObj) {

		StoreItemMappingMstDAO.getGroupList(voObj);
		StoreItemMappingMstDAO.getItemTypeValues(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandRptBO.getGroupList()-->" + strErr);
		}

	}

	public void getitemTypecmb(StoreItemMappingMstVO voObj) {

		StoreItemMappingMstDAO.getItemTypeValues(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandRptBO.getGroupList()-->" + strErr);
		}

	}
	/**
	 * Gets the drug list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the drug list
	 */
	public void getDrugList(StoreItemMappingMstVO voObj) {

		StoreItemMappingMstDAO.getDrugList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandRptBO.getDrugList()-->" + strErr);
		}

	}

	/**
	 * Gets the user level.
	 * 
	 * @param voObj
	 *            the vo obj
	 */
	public void GetUserLevel(StoreItemMappingMstVO voObj) {
		StoreItemMappingMstDAO.GetUserLevel(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandRptBO.GetUserLevel()-->" + strErr);
		}
	}

	/**
	 * Gets the programme combo.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the programme combo
	 */
	public void getProgrammeCombo(StoreItemMappingMstVO voObj) {

		StoreItemMappingMstDAO.getProgrammeCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandRptBO.getProgrammeCombo()-->"
					+ strErr);
		}

	}
	public void getReport(StoreItemMappingMstVO vo) {
		StoreItemMappingMstDAO.getReport(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StockOnHandRptBO.getReport() --> " + vo.getStrMsgString());
		}
	}
	
	
	
	
	 
   
}
