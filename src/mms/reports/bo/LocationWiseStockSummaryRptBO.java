/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         LocationWiseStockSummaryRptBO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.bo;

import mms.reports.dao.LocationWiseStockSummaryRptDAO;
import mms.reports.dao.StockOnHandRptDAO;
import mms.reports.vo.LocationWiseStockSummaryRptVO;
import mms.reports.vo.StockOnHandRptVO;

// TODO: Auto-generated Javadoc
/**
 * The Class LocationWiseStockSummaryRptBO.
 */
public class LocationWiseStockSummaryRptBO {

	/**
	 * Gets the circle list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getCircleList(LocationWiseStockSummaryRptVO voObj) {

		LocationWiseStockSummaryRptDAO.getCircleList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("LocationWiseStockSummaryRptBO.getCircleList()-->" + strErr);
		}

	}

	/**
	 * Gets the district list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getDistrictList(LocationWiseStockSummaryRptVO voObj) {

		LocationWiseStockSummaryRptDAO.getDistrictList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("LocationWiseStockSummaryRptBO.getDistrictList()-->" + strErr);
		}

	}

	/**
	 * Gets the store list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getStoreList(LocationWiseStockSummaryRptVO voObj) {

		LocationWiseStockSummaryRptDAO.getDistrictStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("LocationWiseStockSummaryRptBO.getStoreList()-->" + strErr);
		}

	}

	/**
	 * Gets the store type list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getStoreTypeList(LocationWiseStockSummaryRptVO voObj) {

		LocationWiseStockSummaryRptDAO.getDwhTypeCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("LocationWiseStockSummaryRptBO.getStoreTypeList()-->" + strErr);
		}

	}

	/**
	 * Gets the dwh sub type combo.
	 * 
	 * @param voObj the vo obj
	 */
	public void getDwhSubTypeCombo(LocationWiseStockSummaryRptVO voObj) {

		LocationWiseStockSummaryRptDAO.getDwhSubTypeCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("LocationWiseStockSummaryRptBO.getDwhSubTypeCombo()-->" + strErr);
		}

	}

	/**
	 * Gets the sub store list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getSubStoreList(LocationWiseStockSummaryRptVO voObj) {

		LocationWiseStockSummaryRptDAO.getSubStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("LocationWiseStockSummaryRptBO.getStoreList()-->" + strErr);
		}

	}

	/**
	 * To get Drug Store Type Combo.
	 * 
	 * @param voObj the vo obj
	 */
	public void getInitializedValues(LocationWiseStockSummaryRptVO voObj) {

		LocationWiseStockSummaryRptDAO.getDistrictStoreList(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("LocationWiseStockSummaryRptBO.getDwhTypeCombo()-->" + strErr);
		}
	}

	/**
	 * Gets the item cat list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getItemCatList(LocationWiseStockSummaryRptVO voObj) {

		LocationWiseStockSummaryRptDAO.getItemCatList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("LocationWiseStockSummaryRptBO.getItemCatList()-->" + strErr);
		}

	}

	/**
	 * Gets the group list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getGroupList(LocationWiseStockSummaryRptVO voObj) {

		LocationWiseStockSummaryRptDAO.getGroupList(voObj);
		LocationWiseStockSummaryRptDAO.getItemTypeValues(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("LocationWiseStockSummaryRptBO.getGroupList()-->" + strErr);
		}

	}

	/**
	 * Gets the drug list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getDrugList(LocationWiseStockSummaryRptVO voObj) {

		LocationWiseStockSummaryRptDAO.getDrugList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("LocationWiseStockSummaryRptBO.getDrugList()-->" + strErr);
		}

	}

	/**
	 * Gets the drug classification value.
	 * 
	 * @param vo the vo
	 */
	public void getDrugClassificationValue(LocationWiseStockSummaryRptVO vo) {
		LocationWiseStockSummaryRptDAO.getDrugClassificationValue(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("LocationWiseStockSummaryRptBO.getDrugClassificationValue---->" + vo.getStrMsgString());
		}
	}

	/**
	 * Gets the user level.
	 * 
	 * @param voObj the vo obj
	 */
	public void getUserLevel(LocationWiseStockSummaryRptVO voObj) {
		LocationWiseStockSummaryRptDAO.getUserLevel(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("LocationWiseStockSummaryRptBO.GetUserLevel()-->" + strErr);
		}
	}

	/**
	 * GetData Method is Used to Populate the Data for.
	 * 
	 * @param vo the vo
	 */
	public void getLocationStockDtl(LocationWiseStockSummaryRptVO vo) {

		LocationWiseStockSummaryRptDAO.GetVitalDrugDtlPrint(vo);
		LocationWiseStockSummaryRptDAO.getStoreListForViewPrint(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("LocationWiseStockSummaryRptBO.GetViewIndent() --> " + vo.getStrMsgString());
		}

	}

	/**
	 * Gets the sub store type list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getSubStoreTypeList(LocationWiseStockSummaryRptVO voObj) {

		LocationWiseStockSummaryRptDAO.getSubDwhTypeCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("LocationWiseStockSummaryRptBO.getStoreTypeList()-->" + strErr);
		}

	}
	
	/**
	 * Gets the programme combo.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the programme combo
	 */
	public void getProgrammeCombo(LocationWiseStockSummaryRptVO voObj) {

		LocationWiseStockSummaryRptDAO.getProgrammeCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("LocationWiseStockSummaryRptBO.getProgrammeCombo()-->"+ strErr);
		}

	}

}
