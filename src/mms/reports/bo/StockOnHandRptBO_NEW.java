/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         StockOnHandRptBO.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.bo;

import mms.reports.dao.StockOnHandRptDAO_NEW;
import mms.reports.vo.StockOnHandRptVO_NEW;

// TODO: Auto-generated Javadoc
/**
 * The Class StockOnHandRptBO.
 */
public class StockOnHandRptBO_NEW {
	/**
	 * Gets the circle list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the circle list
	 */
	public void getCircleList(StockOnHandRptVO_NEW voObj) {

		StockOnHandRptDAO_NEW.getCircleList(voObj);
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
	public void getDistrictList(StockOnHandRptVO_NEW voObj) {

		StockOnHandRptDAO_NEW.getDistrictList(voObj);
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
	public void getStoreList(StockOnHandRptVO_NEW voObj) {

		StockOnHandRptDAO_NEW.getStoreList(voObj);
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
	public void getStoreTypeList(StockOnHandRptVO_NEW voObj) {

		StockOnHandRptDAO_NEW.getDwhTypeCombo(voObj);
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
	public void getSubStoreList(StockOnHandRptVO_NEW voObj) {

		StockOnHandRptDAO_NEW.getSubStoreList(voObj);
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
	public void getItemCatList(StockOnHandRptVO_NEW voObj) {

		StockOnHandRptDAO_NEW.getItemCatList(voObj);
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
	public void getGroupList(StockOnHandRptVO_NEW voObj) {

		StockOnHandRptDAO_NEW.getGroupList(voObj);
		StockOnHandRptDAO_NEW.getItemTypeValues(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandRptBO.getGroupList()-->" + strErr);
		}

	}

	public void getitemTypecmb(StockOnHandRptVO_NEW voObj) {

		StockOnHandRptDAO_NEW.getItemTypeValues(voObj);
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
	public void getDrugList(StockOnHandRptVO_NEW voObj) {

		StockOnHandRptDAO_NEW.getDrugList(voObj);
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
	public void GetUserLevel(StockOnHandRptVO_NEW voObj) {
		StockOnHandRptDAO_NEW.GetUserLevel(voObj);
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
	public void getProgrammeCombo(StockOnHandRptVO_NEW voObj) {

		StockOnHandRptDAO_NEW.getProgrammeCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandRptBO.getProgrammeCombo()-->"
					+ strErr);
		}

	}
	
	public void getImgHeader(StockOnHandRptVO_NEW voObj){
	    StockOnHandRptDAO_NEW.getImageHeader(voObj);
			
	    if (voObj.getStrMsgType().equals("1")){
				voObj.setStrMsgString("StockOnHandRptBO.getImgHeader() --> "+ voObj.getStrMsgString());
	    }
	}

	public void getReport(StockOnHandRptVO_NEW vo) {
		StockOnHandRptDAO_NEW.getReport(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StockOnHandRptBO.getReport() --> " + vo.getStrMsgString());
		}
	}
	
	public void getReportZeroStock(StockOnHandRptVO_NEW vo) {
		StockOnHandRptDAO_NEW.getReportZeroStock(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StockOnHandRptBO.getReport() --> " + vo.getStrMsgString());
		}
	}
	
	
	 
   
}
