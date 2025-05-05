/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         StockOnHandRptBO.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.bo;

import mms.reports.dao.ConsolidatedChallanDAO_NEW;
import mms.reports.vo.ConsolidatedChallanVO_NEW;

// TODO: Auto-generated Javadoc
/**
 * The Class StockOnHandRptBO.
 */
public class ConsolidatedChallanBO_NEW {

	/**
	 * Gets the circle list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the circle list
	 */
	public void getCircleList(ConsolidatedChallanVO_NEW voObj) {

		ConsolidatedChallanDAO_NEW.getCircleList(voObj);
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
	public void getDistrictList(ConsolidatedChallanVO_NEW voObj) {

		ConsolidatedChallanDAO_NEW.getDistrictList(voObj);
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
	public void getStoreList(ConsolidatedChallanVO_NEW voObj) {

		ConsolidatedChallanDAO_NEW.getStoreList(voObj);
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
	public void getStoreTypeList(ConsolidatedChallanVO_NEW voObj) {

		ConsolidatedChallanDAO_NEW.getDwhTypeCombo(voObj);
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
	public void getSubStoreList(ConsolidatedChallanVO_NEW voObj) {

		ConsolidatedChallanDAO_NEW.getSubStoreList(voObj);
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
	public void getItemCatList(ConsolidatedChallanVO_NEW voObj) {

		ConsolidatedChallanDAO_NEW.getItemCatList(voObj);
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
	public void getGroupList(ConsolidatedChallanVO_NEW voObj) {

		ConsolidatedChallanDAO_NEW.getGroupList(voObj);
		ConsolidatedChallanDAO_NEW.getItemTypeValues(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandRptBO.getGroupList()-->" + strErr);
		}

	}

	public void getitemTypecmb(ConsolidatedChallanVO_NEW voObj) {

		ConsolidatedChallanDAO_NEW.getItemTypeValues(voObj);
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
	public void getDrugList(ConsolidatedChallanVO_NEW voObj) {

		ConsolidatedChallanDAO_NEW.getDrugList(voObj);
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
	public void GetUserLevel(ConsolidatedChallanVO_NEW voObj) {
		ConsolidatedChallanDAO_NEW.GetUserLevel(voObj);
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
	public void getProgrammeCombo(ConsolidatedChallanVO_NEW voObj) {

		ConsolidatedChallanDAO_NEW.getProgrammeCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandRptBO.getProgrammeCombo()-->"
					+ strErr);
		}

	}
	
	public void getPoCombo(ConsolidatedChallanVO_NEW voObj) {

		ConsolidatedChallanDAO_NEW.getPoCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandRptBO.getProgrammeCombo()-->"
					+ strErr);
		}

	}
}
