/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         StockSummaryDateWiseRptBO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.bo;

import mms.reports.dao.ConsolidatedChallanDAO_NEW;
import mms.reports.dao.StockSummaryDateWiseRptDAO;
import mms.reports.vo.ConsolidatedChallanVO_NEW;
import mms.reports.vo.StockSummaryDateWiseRptVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StockSummaryDateWiseRptBO.
 */
public class StockSummaryDateWiseRptBO {

	/**
	 * Gets the circle list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getCircleList(StockSummaryDateWiseRptVO voObj) {

		StockSummaryDateWiseRptDAO.getCircleList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockSummaryDateWiseRptBO.getCircleList()-->" + strErr);
		}

	}

	/**
	 * Gets the district list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getDistrictList(StockSummaryDateWiseRptVO voObj) {

		StockSummaryDateWiseRptDAO.getDistrictList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockSummaryDateWiseRptBO.getDistrictList()-->" + strErr);
		}

	}

	/**
	 * Gets the store list.
	 * 
	 * @param voObj the vo obj
	 */
	

	/**
	 * Gets the store type list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getStoreTypeList(StockSummaryDateWiseRptVO voObj) {

		StockSummaryDateWiseRptDAO.getDwhTypeCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockSummaryDateWiseRptBO.getStoreTypeList()-->" + strErr);
		}

	}

	/**
	 * Gets the dwh sub type combo.
	 * 
	 * @param voObj the vo obj
	 */
	public void getDwhSubTypeCombo(StockSummaryDateWiseRptVO voObj) {

		StockSummaryDateWiseRptDAO.getDwhSubTypeCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockSummaryDateWiseRptBO.getDwhSubTypeCombo()-->" + strErr);
		}

	}

	/**
	 * Gets the sub store list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getSubStoreList(StockSummaryDateWiseRptVO voObj) {

		StockSummaryDateWiseRptDAO.getSubStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockSummaryDateWiseRptBO.getStoreList()-->" + strErr);
		}

	}

	/**
	 * To get Drug Store Type Combo.
	 * 
	 * @param voObj the vo obj
	 */
	public void getInitializedValues(StockSummaryDateWiseRptVO voObj) {

		StockSummaryDateWiseRptDAO.getDistrictStoreList(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockSummaryDateWiseRptBO.getDwhTypeCombo()-->" + strErr);
		}
	}

	/**
	 * Gets the item cat list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getItemCatList(StockSummaryDateWiseRptVO voObj) {

		StockSummaryDateWiseRptDAO.getItemCatList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockSummaryDateWiseRptBO.getItemCatList()-->" + strErr);
		}

	}

	/**
	 * Gets the group list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getGroupList(StockSummaryDateWiseRptVO voObj) {

		StockSummaryDateWiseRptDAO.getGroupList(voObj);
		StockSummaryDateWiseRptDAO.getItemTypeValues(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockSummaryDateWiseRptBO.getGroupList()-->" + strErr);
		}

	}

	/**
	 * Gets the drug list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getDrugList(StockSummaryDateWiseRptVO voObj) {

		StockSummaryDateWiseRptDAO.getDrugList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockSummaryDateWiseRptBO.getDrugList()-->" + strErr);
		}

	}
	
	public void getDrugList1(StockSummaryDateWiseRptVO voObj) {

		StockSummaryDateWiseRptDAO.getDrugList1(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockSummaryDateWiseRptBO.getDrugList()-->" + strErr);
		}

	}
	public void getStoreList(StockSummaryDateWiseRptVO voObj) {

		StockSummaryDateWiseRptDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockOnHandRptBO.getStoreList()-->" + strErr);
		}

	}
	/**
	 * Gets the user level.
	 * 
	 * @param voObj the vo obj
	 */
	public void getUserLevel(StockSummaryDateWiseRptVO voObj) {
		StockSummaryDateWiseRptDAO.getUserLevel(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockSummaryDateWiseRptBO.GetUserLevel()-->" + strErr);
		}
	}

	/**
	 * GetData Method is Used to Populate the Data for.
	 * 
	 * @param vo the vo
	 */
	public void getRportData(StockSummaryDateWiseRptVO vo) {

		StockSummaryDateWiseRptDAO.getStockDtlDateWisePrint(vo);
		StockSummaryDateWiseRptDAO.getStoreListForViewPrint(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StockSummaryDateWiseRptBO.getRportData() --> " + vo.getStrMsgString());
		}

	}

	/**
	 * Gets the sub store type list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getSubStoreTypeList(StockSummaryDateWiseRptVO voObj) {

		StockSummaryDateWiseRptDAO.getSubDwhTypeCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockSummaryDateWiseRptBO.getSubStoreTypeList()-->" + strErr);
		}

	}

}
