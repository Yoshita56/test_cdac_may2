/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         StockLedgerForSubStoresRptItemBO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.bo;

import hisglobal.transactionmgnt.HisDAO;
import mms.reports.dao.StockLedgerForSubStoresRptItemDAO;
import mms.reports.vo.StockLedgerForSubStoresRptItemVO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Vivek Aggarwal Version : 1.0 Date : 16-Mar-2012 Modification Date:
 * 
 */
public class StockLedgerForSubStoresRptItemBO {

	/**
	 * Gets the store list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getStoreList(StockLedgerForSubStoresRptItemVO voObj ) {

		StockLedgerForSubStoresRptItemDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerForSubStoresRptItemBO.getStoreList()-->" + strErr);
		}

	}

	/**
	 * Gets the item cat list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getItemCatList(StockLedgerForSubStoresRptItemVO voObj) {

		StockLedgerForSubStoresRptItemDAO.getItemCatList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerForSubStoresRptItemBO.getItemCatList()-->" + strErr);
		}

	}

	/**
	 * Gets the group list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getGroupList(StockLedgerForSubStoresRptItemVO voObj) {

		StockLedgerForSubStoresRptItemDAO.getGroupList(voObj);
		StockLedgerForSubStoresRptItemDAO.getItemTypeValues(voObj);
		//StockLedgerForSubStoresRptItemDAO.getSectionList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerForSubStoresRptItemBO.getGroupList()-->" + strErr);
		}
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerForSubStoresRptItemBO.getGroupList()-->" + strErr);
		}

	}

	/**
	 * Gets the item list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getItemList(StockLedgerForSubStoresRptItemVO voObj) {

		StockLedgerForSubStoresRptItemDAO.getItemList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerForSubStoresRptItemBO.getItemList()-->" + strErr);
		}

	}

	/**
	 * Gets the consolidated stock ledger dtl.
	 * 
	 * @param voObj the vo obj
	 */
	public void getConsolidatedStockLedgerDtl(StockLedgerForSubStoresRptItemVO voObj) {

		StockLedgerForSubStoresRptItemDAO.getData(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerForSubStoresRptItemBO.getItemList()-->" + strErr);
		}

	}

	/**
	 * Gets the detailed stock ledger dtl.
	 * 
	 * @param voObj the vo obj
	 */
	public void getDetailedStockLedgerDtl(StockLedgerForSubStoresRptItemVO voObj) {

		StockLedgerForSubStoresRptItemDAO.getDetailedStockLedgerDtl(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerForSubStoresRptItemBO.getItemList()-->" + strErr);
		}

	}

	/**
	 * Gets the item name.
	 * 
	 * @param voObj the vo obj
	 */
	public void getItemName(StockLedgerForSubStoresRptItemVO voObj) {
		HisDAO dao = null;
		String strFuncName = "";
		int nFuncIndex = 0;
		String strDrugName;

		try {
			dao = new HisDAO("MMS Transactions", "StockLedgerForSubStoresRptItemDAO");
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
			voObj.setStrMsgString("StockLedgerForSubStoresRptItemDAO.getItemName() --> " + e.getMessage());
		}

	}

}
