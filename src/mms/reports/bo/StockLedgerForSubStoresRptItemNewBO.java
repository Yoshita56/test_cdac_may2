/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         StockLedgerForSubStoresRptItemnewBO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.bo;

import hisglobal.transactionmgnt.HisDAO;
import mms.reports.dao.StockLedgerForSubStoresRptItemNewDAO;
import mms.reports.vo.StockLedgerForSubStoresRptItemNewVO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Vivek Aggarwal Version : 1.0 Date : 16-Mar-2012 Modification Date:
 * 
 */
public class StockLedgerForSubStoresRptItemNewBO {

	/**
	 * Gets the store list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getStoreList(StockLedgerForSubStoresRptItemNewVO voObj ) {

		StockLedgerForSubStoresRptItemNewDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerForSubStoresRptItemNewBO.getStoreList()-->" + strErr);
		}

	}

	/**
	 * Gets the item cat list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getItemCatList(StockLedgerForSubStoresRptItemNewVO voObj) {

		StockLedgerForSubStoresRptItemNewDAO.getItemCatList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerForSubStoresRptItemNewBO.getItemCatList()-->" + strErr);
		}

	}

	/**
	 * Gets the group list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getGroupList(StockLedgerForSubStoresRptItemNewVO voObj) {

		StockLedgerForSubStoresRptItemNewDAO.getGroupList(voObj);
		StockLedgerForSubStoresRptItemNewDAO.getItemTypeValues(voObj);
		//StockLedgerForSubStoresRptItemNewDAO.getSectionList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerForSubStoresRptItemNewBO.getGroupList()-->" + strErr);
		}
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerForSubStoresRptItemNewBO.getGroupList()-->" + strErr);
		}

	}

	/**
	 * Gets the item list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getItemList(StockLedgerForSubStoresRptItemNewVO voObj) {

		StockLedgerForSubStoresRptItemNewDAO.getItemList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerForSubStoresRptItemNewBO.getItemList()-->" + strErr);
		}

	}

	/**
	 * Gets the consolidated stock ledger dtl.
	 * 
	 * @param voObj the vo obj
	 */
	public void getConsolidatedStockLedgerDtl(StockLedgerForSubStoresRptItemNewVO voObj) {

		StockLedgerForSubStoresRptItemNewDAO.getData(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerForSubStoresRptItemNewBO.getItemList()-->" + strErr);
		}

	}

	/**
	 * Gets the detailed stock ledger dtl.
	 * 
	 * @param voObj the vo obj
	 */
	public void getDetailedStockLedgerDtl(StockLedgerForSubStoresRptItemNewVO voObj) {

		StockLedgerForSubStoresRptItemNewDAO.getDetailedStockLedgerDtl(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerForSubStoresRptItemNewBO.getItemList()-->" + strErr);
		}

	}

	/**
	 * Gets the item name.
	 * 
	 * @param voObj the vo obj
	 */
	public void getItemName(StockLedgerForSubStoresRptItemNewVO voObj) {
		HisDAO dao = null;
		String strFuncName = "";
		int nFuncIndex = 0;
		String strDrugName;

		try {
			dao = new HisDAO("MMS Transactions", "StockLedgerForSubStoresRptItemNewDAO");
			strFuncName = "{? = call MMS_MST.get_item_dtl(?,?,?)}";
			nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, voObj.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 4, voObj.getStrItemBrandId());

			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strDrugName = dao.getFuncString(nFuncIndex);

			voObj.setStrDrugName(strDrugName);
		} catch (Exception e) {
			voObj.setStrMsgType("1");
			voObj.setStrMsgString("StockLedgerForSubStoresRptItemNewDAO.getItemName() --> " + e.getMessage());
		}

	}
	
	
	/**
	 * Gets the job initailize date
	 * 
	 * @param voObj the vo obj
	 */
	public void getJobInitializeDate(StockLedgerForSubStoresRptItemNewVO voObj) {

		StockLedgerForSubStoresRptItemNewDAO.getJobInitializeDate(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerForSubStoresRptItemNewBO.getJobInitializeDate()-->" + strErr);
		}

	}

}
