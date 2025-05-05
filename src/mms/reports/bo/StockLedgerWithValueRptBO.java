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
import mms.reports.dao.FTDStockLedgerRptDAO;
import mms.reports.dao.StockLedgerWithValueRptDAO;
import mms.reports.vo.FTDStockLedgerRptVO;
import mms.reports.vo.StockLedgerWithValueRptVO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Vivek Aggarwal Version : 1.0 Date : 16-Mar-2012 Modification Date:
 * 
 */
public class StockLedgerWithValueRptBO {

	/**
	 * Gets the store list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getStoreList(StockLedgerWithValueRptVO voObj ) {

		StockLedgerWithValueRptDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerWithValueRptBO.getStoreList()-->" + strErr);
		}

	}
	
	public void getFYCombo(StockLedgerWithValueRptVO voObj) {

		StockLedgerWithValueRptDAO.getFYCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerWithValueRptBO.getFYCombo()-->" + strErr);
		}

	}

	/**
	 * Gets the item cat list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getItemCatList(StockLedgerWithValueRptVO voObj) {

		StockLedgerWithValueRptDAO.getItemCatList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerWithValueRptBO.getItemCatList()-->" + strErr);
		}

	}

	/**
	 * Gets the group list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getGroupList(StockLedgerWithValueRptVO voObj) {

		StockLedgerWithValueRptDAO.getGroupList(voObj);
		StockLedgerWithValueRptDAO.getItemTypeValues(voObj);
		//StockLedgerWithValueRptDAO.getSectionList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerWithValueRptBO.getGroupList()-->" + strErr);
		}
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerWithValueRptBO.getGroupList()-->" + strErr);
		}

	}

	/**
	 * Gets the item list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getItemList(StockLedgerWithValueRptVO voObj) {

		StockLedgerWithValueRptDAO.getItemList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerWithValueRptBO.getItemList()-->" + strErr);
		}

	}

	/**
	 * Gets the consolidated stock ledger dtl.
	 * 
	 * @param voObj the vo obj
	 */
	public void getConsolidatedStockLedgerDtl(StockLedgerWithValueRptVO voObj) {

		StockLedgerWithValueRptDAO.getData(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerWithValueRptBO.getItemList()-->" + strErr);
		}

	}

	/**
	 * Gets the detailed stock ledger dtl.
	 * 
	 * @param voObj the vo obj
	 */
	public void getDetailedStockLedgerDtl(StockLedgerWithValueRptVO voObj) {

		StockLedgerWithValueRptDAO.getDetailedStockLedgerDtl(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerWithValueRptBO.getItemList()-->" + strErr);
		}

	}

	/**
	 * Gets the item name.
	 * 
	 * @param voObj the vo obj
	 */
	public void getItemName(StockLedgerWithValueRptVO voObj) {
		HisDAO dao = null;
		String strFuncName = "";
		int nFuncIndex = 0;
		String strDrugName;

		try {
			dao = new HisDAO("MMS Transactions", "StockLedgerWithValueRptDAO");
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
			voObj.setStrMsgString("StockLedgerWithValueRptDAO.getItemName() --> " + e.getMessage());
		}

	}
	
	
	/**
	 * Gets the job initailize date
	 * 
	 * @param voObj the vo obj
	 */
	public void getJobInitializeDate(StockLedgerWithValueRptVO voObj) {

		StockLedgerWithValueRptDAO.getJobInitializeDate(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("StockLedgerWithValueRptBO.getJobInitializeDate()-->" + strErr);
		}

	}

}
