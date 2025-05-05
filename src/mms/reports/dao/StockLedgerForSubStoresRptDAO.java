/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         StockLedgerForSubStoresRptDAO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.StockLedgerForSubStoresRptVO;


/**
 * Developer : Vivek Aggarwal Version : 1.0 Date : 16-Mar-2012 Modification Date:
 * 
 */
public class StockLedgerForSubStoresRptDAO {

	/**
	 * Gets the store list.
	 * 
	 * @param voObj the vo obj
	 */
	public static void getStoreList(StockLedgerForSubStoresRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "StockLedgerForSubStoresRptDAO");
			//daoObj.setConnType("2");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", voObj.getStrMode());
			daoObj.setProcInValue(nProcIndex, "seatid", voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeid", "0");
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null) {
				strErr = "";
			}

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrStoreWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("StockLedgerForSubStoresRptDAO.getStoreList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	/**
	 * Gets the item cat list.
	 * 
	 * @param voObj the vo obj
	 */
	public static void getItemCatList(StockLedgerForSubStoresRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.Rptm_item_category_list(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "StockLedgerForSubStoresRptDAO");
			//daoObj.setConnType("2");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null) {
				strErr = "";
			}

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrItemCatWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("StockLedgerForSubStoresRptDAO.getItemCatList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	/**
	 * Gets the group list.
	 * 
	 * @param voObj the vo obj
	 */
	public static void getSectionList(StockLedgerForSubStoresRptVO vo) 
	{
		String strproc_name = "{call pkg_mms_view.proc_section_list(?,?,?,?)}";

		HisDAO dao = null;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet wsResult = null;

		try {
			
			dao = new HisDAO("MMS", "StockLedgerForSubStoresRptdao");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1");
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);
			dao.executeProcedure(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			if (strErr.equals("")) 
			{
				wsResult = dao.getWebRowSet(nProcIndex, "resultset");
				vo.setStrSectionbWS(wsResult);
				vo.setStrMsgType("0");
			} else {
				throw new Exception(strErr);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("-->StockLedgerForSubStoresRptdao.getSectionList"+ e.getMessage());
			vo.setStrMsgType("1");
		}
		finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
		
	}
	
	
	
	public static void getGroupList(StockLedgerForSubStoresRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.rptm_store_group_list(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "StockLedgerForSubStoresRptDAO");
			//daoObj.setConnType("2");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", "100");
			daoObj.setProcInValue(nProcIndex, "item_category", voObj.getStrItemCatId() == null ? "10" : voObj.getStrItemCatId());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null) {
				strErr = "";
			}

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrGroupCmbWS(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("StockLedgerForSubStoresRptDAO.getGroupList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	/**
	 * Gets the item list.
	 * 
	 * @param voObj the vo obj
	 */
	public static void getItemList(StockLedgerForSubStoresRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.rptm_itembrand_list(?,?,?,?,? ,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "StockLedgerRptDAO");
			//daoObj.setConnType("2");

			nProcIndex = daoObj.setProcedure(strProcName);

			/*
			 * System.out.println("voObj.getStrItemCatId()"+voObj.getStrItemCatId ()); System.out.println("voObj.getStrGroupId()"+voObj.getStrGroupId
			 * ());
			 */
String p=voObj.getStrSectionId()==null || voObj.getStrSectionId()==""?"0":voObj.getStrSectionId();
String strore=voObj.getStrStoreId()==null || voObj.getStrStoreId()==""?"0":voObj.getStrStoreId();

			daoObj.setProcInValue(nProcIndex, "modeval", "3");
			daoObj.setProcInValue(nProcIndex, "catCode", "10");
			daoObj.setProcInValue(nProcIndex, "groupid", voObj.getStrGroupId());
			daoObj.setProcInValue(nProcIndex, "subgrpid", "0");
			daoObj.setProcInValue(nProcIndex, "hosp_code", "100");
			//daoObj.setProcInValue(nProcIndex, "drug_class", "0");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null) {
				strErr = "";
			}

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrItemWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("StockLedgerRptDAO.getItemList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	/**
	 * To Get Data.
	 * 
	 * @param vo the stock ledger for sub stores rpt v o_p
	 */
	public static void getData(StockLedgerForSubStoresRptVO vo) {
		String err = "";
		String strProcName = "{call Pkg_Mms_rpt.rptm_cons_substore_ledger_dtl_old(?,?,?,?,?, ?,?,?,?,?)}"; // Total
																									// 8
																									// Variables

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("MMS Reports", "StockLedgerForSubStoresRptDAO");
			//dao.setConnType("2");

			HisUtil.replaceNullValueWithEmptyString(vo);

			procIndex1 = dao.setProcedure(strProcName);
			
			//System.out.println("Brand Id--->>"+vo.getStrItemBrandId());

			dao.setProcInValue(procIndex1, "modeval", "1"); // Batch Wise Or Without Batch Wise
			dao.setProcInValue(procIndex1, "storeId", vo.getStrDWHId());
			dao.setProcInValue(procIndex1, "itemId", vo.getStrItemBrandId());
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "frmDate", vo.getStrFromDate());
			dao.setProcInValue(procIndex1, "toDate", vo.getStrToDate());
			dao.setProcInValue(procIndex1, "catId", "10");
			dao.setProcInValue(procIndex1, "grpId", "0");
			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return value
			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object

			// execute procedure
			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null) {
				err = "";
			}

			ws = dao.getWebRowSet(procIndex1, "resultset");

			vo.setWrsData(ws);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("StockLedgerForSubStoresRptDAO.getData() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

	/**
	 * To Get Data.
	 * 
	 * @param vo the stock ledger for sub stores rpt v o_p
	 */
	public static void getDetailedStockLedgerDtl(StockLedgerForSubStoresRptVO vo) {
		String err = "";
		String strProcName = "{call Pkg_Mms_rpt.rptm_dtl_substore_ledger_dtl_old(?,?,?,?,?, ?,?,?,?)}"; // Total
																									// 9
																									// Variables

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("MMS Reports", "StockLedgerForSubStoresRptDAO");
			//dao.setConnType("2");

			HisUtil.replaceNullValueWithEmptyString(vo);

			procIndex1 = dao.setProcedure(strProcName);
						
			dao.setProcInValue(procIndex1, "modeval", "1");
			dao.setProcInValue(procIndex1, "storeId", vo.getStrDWHId());
			dao.setProcInValue(procIndex1, "itemId", vo.getStrItemBrandId());
			dao.setProcInValue(procIndex1, "batchNo", vo.getStrBatchNo());
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "frmDate", vo.getStrFromDate());
			dao.setProcInValue(procIndex1, "toDate", vo.getStrToDate());

			/* Setting Default Value End */

			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
			// value
			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null) {
				err = "";
			}

			ws = dao.getWebRowSet(procIndex1, "resultset");

			vo.setWrsData(ws);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("StockLedgerForSubStoresRptDAO.getData() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

	/**
	 * Gets the item type values.
	 * 
	 * @param vo the vo
	 */
	public static  void  getItemTypeValues (StockLedgerForSubStoresRptVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("MMS", "StockLedgerForSubStoresRptDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.drugbrand.itemtype.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, "100");
			dao.setQryValue(nQueryIndex, 2, "10");

			web = dao.executeQry(nQueryIndex);

			vo.setItemTypeWs(web);

		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("StockLedgerForSubStoresRptDAO.getItemValues() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
			}
			dao = null;
			web = null;
		}
	}
}
