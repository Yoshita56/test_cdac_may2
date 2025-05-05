/**********************************************************
 Project:	   DWH_PHSC	
 File:         StockLedgerForSubStoresRptBO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.bo;

import hisglobal.transactionmgnt.HisDAO;
import mms.reports.dao.StockLedgerForSubStoresRptDAO;
import mms.reports.vo.StockLedgerForSubStoresRptVO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Vivek Aggarwal Version : 1.0 Date : 16-Mar-2012 Modification Date:
 * 
 */
public class StockLedgerForSubStoresRptBO {

	/**
	 * Gets the store list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getStoreList(StockLedgerForSubStoresRptVO voObj) {

		StockLedgerForSubStoresRptDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerForSubStoresRptBO.getStoreList()-->" + strErr);
		}

	}

	/**
	 * Gets the item cat list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getItemCatList(StockLedgerForSubStoresRptVO voObj) {

		StockLedgerForSubStoresRptDAO.getItemCatList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerForSubStoresRptBO.getItemCatList()-->" + strErr);
		}

	}

	/**
	 * Gets the group list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getGroupList(StockLedgerForSubStoresRptVO voObj) {

		StockLedgerForSubStoresRptDAO.getGroupList(voObj);
		StockLedgerForSubStoresRptDAO.getItemTypeValues(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerForSubStoresRptBO.getGroupList()-->" + strErr);
		}
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerForSubStoresRptBO.getGroupList()-->" + strErr);
		}

	}

	/**
	 * Gets the item list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getItemList(StockLedgerForSubStoresRptVO voObj) {

		StockLedgerForSubStoresRptDAO.getItemList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerForSubStoresRptBO.getItemList()-->" + strErr);
		}

	}

	/**
	 * Gets the consolidated stock ledger dtl.
	 * 
	 * @param voObj the vo obj
	 */
	public void getConsolidatedStockLedgerDtl(StockLedgerForSubStoresRptVO voObj) {

		StockLedgerForSubStoresRptDAO.getData(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerForSubStoresRptBO.getItemList()-->" + strErr);
		}

	}

	/**
	 * Gets the detailed stock ledger dtl.
	 * 
	 * @param voObj the vo obj
	 */
	public void getDetailedStockLedgerDtl(StockLedgerForSubStoresRptVO voObj) {

		StockLedgerForSubStoresRptDAO.getDetailedStockLedgerDtl(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerForSubStoresRptBO.getItemList()-->" + strErr);
		}

	}

	/**
	 * Gets the item name.
	 * 
	 * @param voObj the vo obj
	 */
	public void getItemName(StockLedgerForSubStoresRptVO voObj) {
		HisDAO dao = null;
		String strFuncName = "";
		int nFuncIndex = 0;
		String strDrugName;

		try {
			dao = new HisDAO("MMS Transactions", "StockLedgerForSubStoresRptDAO");
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
			voObj.setStrMsgString("StockLedgerForSubStoresRptDAO.getItemName() --> " + e.getMessage());
		}

	}

}
