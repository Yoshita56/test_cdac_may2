/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         CovidStockLedgerRptBO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.bo;

import hisglobal.transactionmgnt.HisDAO;
import mms.reports.dao.CovidStockLedgerRptDAO;
import mms.reports.vo.CovidStockLedgerRptVO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Vivek Aggarwal Version : 1.0 Date : 16-Mar-2012 Modification Date:
 * 
 */
public class CovidStockLedgerRptBO {

	/**
	 * Gets the store list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getStoreList(CovidStockLedgerRptVO voObj) 
	{
		System.out.println("--------------------- BO ----------------------------");

		CovidStockLedgerRptDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("CovidStockLedgerRptBO.getStoreList()-->" + strErr);
		}

	}

	/**
	 * Gets the item cat list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getItemCatList(CovidStockLedgerRptVO voObj) {

		CovidStockLedgerRptDAO.getItemCatList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("CovidStockLedgerRptBO.getItemCatList()-->" + strErr);
		}

	}

	/**
	 * Gets the group list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getGroupList(CovidStockLedgerRptVO voObj) {

		//CovidStockLedgerRptDAO.getGroupList(voObj);
		CovidStockLedgerRptDAO.getItemTypeValues(voObj);
		//CovidStockLedgerRptDAO.getSectionList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("CovidStockLedgerRptBO.getGroupList()-->" + strErr);
		}
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("CovidStockLedgerRptBO.getGroupList()-->" + strErr);
		}

	}

	/**
	 * Gets the item list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getItemList(CovidStockLedgerRptVO voObj) {

		CovidStockLedgerRptDAO.getItemList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("CovidStockLedgerRptBO.getItemList()-->" + strErr);
		}

	}

	/**
	 * Gets the consolidated stock ledger dtl.
	 * 
	 * @param voObj the vo obj
	 */
	public void getConsolidatedStockLedgerDtl(CovidStockLedgerRptVO voObj) {

		CovidStockLedgerRptDAO.getData(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("CovidStockLedgerRptBO.getItemList()-->" + strErr);
		}

	}

	/**
	 * Gets the detailed stock ledger dtl.
	 * 
	 * @param voObj the vo obj
	 */
	public void getDetailedStockLedgerDtl(CovidStockLedgerRptVO voObj) {

		CovidStockLedgerRptDAO.getDetailedStockLedgerDtl(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("CovidStockLedgerRptBO.getItemList()-->" + strErr);
		}

	}

	/**
	 * Gets the item name.
	 * 
	 * @param voObj the vo obj
	 */
	public void getItemName(CovidStockLedgerRptVO voObj) {
		HisDAO dao = null;
		String strFuncName = "";
		int nFuncIndex = 0;
		String strDrugName;

		try {
			dao = new HisDAO("MMS Transactions", "CovidStockLedgerRptDAO");
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
			voObj.setStrMsgString("CovidStockLedgerRptDAO.getItemName() --> " + e.getMessage());
		}

	}

}
