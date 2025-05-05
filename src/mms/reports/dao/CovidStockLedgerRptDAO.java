/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         CovidStockLedgerRptDAO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
import mms.reports.vo.CovidStockLedgerRptVO;
import mms.reports.vo.StockLedgerRptVO;

/**
 * Developer : Vivek Aggarwal Version : 1.0 Date : 16-Mar-2012 Modification Date:
 * 
 */
public class CovidStockLedgerRptDAO 
{

	/**
	 * Gets the store list.
	 * 
	 * @param voObj the vo obj
	 */
	
	public static void getStoreList(CovidStockLedgerRptVO voObj) 
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.rptm_hstt_store_mst(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","StockLedgerRptDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			
			System.out.println("--------------------- DAO ----------------------------");

			daoObj.setProcInValue(nProcIndex, "modeval", "5",1);
			daoObj.setProcInValue(nProcIndex, "seatid", voObj.getStrSeatId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "item_category","0",4);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				
				//System.out.println("--------------------- DAO ----------------------------"+ws.size());
		
				voObj.setStrStoreWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			e.printStackTrace();
			voObj.setStrMsgString("StockLedgerRptDAO.getStoreList() --> "+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getItemList(CovidStockLedgerRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.rptm_itembrand_list(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","StockLedgerRptDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "catCode", voObj.getStrItemCatId(),2);
			daoObj.setProcInValue(nProcIndex, "groupid", "0",3);
			daoObj.setProcInValue(nProcIndex, "subgrpid", "0",4);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),5);
			daoObj.setProcOutValue(nProcIndex, "err", 1,6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
	
			strErr = daoObj.getString(nProcIndex, "err");
			
			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				//System.out.println("ws size======>>"+ws.size());
				voObj.setStrItemWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			e.printStackTrace();
			voObj.setStrMsgString("StockLedgerRptDAO.getItemList() --> "+ e.getMessage());
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
	public static void getSectionList(CovidStockLedgerRptVO vo) 
	{
		String strproc_name = "{call pkg_mms_view.proc_section_list(?,?,?,?)}";

		HisDAO dao = null;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet wsResult = null;

		try {
			
			dao = new HisDAO("MMS", "CovidStockLedgerRptdao");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcOutValue(nProcIndex, "err", 1,3);
			dao.setProcOutValue(nProcIndex, "resultset", 2,4);
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
			vo.setStrMsgString("-->CovidStockLedgerRptdao.getSectionList"+ e.getMessage());
			vo.setStrMsgType("1");
		}
		finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
		
	}
	
	
	
	public static void getGroupList(CovidStockLedgerRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.rptm_store_group_list(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "CovidStockLedgerRptDAO");
			

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "item_category", voObj.getStrItemCatId() == null ? "10" : voObj.getStrItemCatId(),3);
			daoObj.setProcOutValue(nProcIndex, "err", 1,4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,5);

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

			voObj.setStrMsgString("CovidStockLedgerRptDAO.getGroupList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getItemCatList(CovidStockLedgerRptVO voObj) 
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.Rptm_item_category_list(?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";
		String strMode="";
		try {

			daoObj = new HisDAO("MMS Transactions","StockLedgerRptDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			if(voObj.getStrStoreId()!=null && !voObj.getStrStoreId().equals(""))
				strMode="2";
			else
				strMode="1";
			
			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStoreId(),3);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),2);
			daoObj.setProcOutValue(nProcIndex, "err", 1,4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,5);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrItemCatWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			e.printStackTrace();
			voObj.setStrMsgString("StockLedgerRptDAO.getItemCatList() --> "	+ e.getMessage());
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
	/*
	public static void getData(CovidStockLedgerRptVO vo) {
		String err = "";
		String strProcName = "{call Pkg_Mms_rpt.proc_covid_stock_ledger_rpt(?,?,?,?,?, ?,?,?)}"; 
		int procIndex1 = 0;
		HisDAO dao = null;
		
		String brandIds ="";
		WebRowSet ws = null;
		try {

			dao = new HisDAO("MMS Reports", "CovidStockLedgerRptDAO");
			
			
			procIndex1 = dao.setProcedure(strProcName);
			//System.out.println("Brand Id--->>"+vo.getStrItemBrandId());
			String[] ids = vo.getStrItemBrandId().split("\\,");
			for(int i=0;i<ids.length;i++)
			{
				String brandid=ids[i].split("\\^")[0];
				if(i==0)
					brandIds = brandid;
				else
					brandIds = brandIds+","+ brandid;
			}
			//System.out.println("brandIds-->"+brandIds);
			
			dao.setProcInValue(procIndex1, "modeval", "1",1);
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(procIndex1, "store_id", vo.getStrDWHId(),3);
			dao.setProcInValue(procIndex1, "itembrand_id", brandIds,4);
			
			dao.setProcInValue(procIndex1, "fromdate", vo.getStrFromDate(),5);
			dao.setProcInValue(procIndex1, "todate", vo.getStrToDate(),6);
			dao.setProcOutValue(procIndex1, "err", 1,7); // 1 for string return value
			dao.setProcOutValue(procIndex1, "resultset", 2,8); // 2 for object

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
			vo.setStrMsgString("CovidStockLedgerRptDAO.getData() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}
	*/
	
	/**
	 * To Get Data
	 * 
	 * @param StockLedgerRptVO_p
	 */
	public static void getData(CovidStockLedgerRptVO vo) 
	{
		String err = "";
		String proc_name1 = "{call Pkg_Mms_rpt.proc_covid_stock_ledger_rpt(?,?,?,?,?, ?,?,?)}";	// Total 8 Variables

		int procIndex1 = 0;
		HisDAO dao = null;
		String brandIds ="";
		WebRowSet ws = null;

		try {

				dao = new HisDAO("MMS Reports","StockLedgerRptDAO");
		
				HisUtil.replaceNullValueWithEmptyString(vo);
				
				procIndex1 = dao.setProcedure(proc_name1);
				
				String[] ids = vo.getStrItemBrandId().split("\\,");
				for(int i=0;i<ids.length;i++)
				{
					String brandid=ids[i].split("\\^")[0];
					if(i==0)
						brandIds = brandid;
					else
						brandIds = brandIds+","+ brandid;
				}
				System.out.println("brandIds-->"+brandIds);
				
				dao.setProcInValue(procIndex1, "modeval",     "1",1);
				dao.setProcInValue(procIndex1, "hosp_code",    vo.getStrHospitalCode(),2);
				dao.setProcInValue(procIndex1, "store_id",     vo.getStrDWHId(),3);
				dao.setProcInValue(procIndex1, "itembrand_id", brandIds,4);
				
				dao.setProcInValue(procIndex1, "fromdate",     vo.getStrFromDate(),5);
				dao.setProcInValue(procIndex1, "todate",       vo.getStrToDate(),6);							
				/* Setting Default Value End */				
				dao.setProcOutValue(procIndex1, "err",         1,7); // 1 for string return
				// value
				dao.setProcOutValue(procIndex1, "resultset",   2,8); // 2 for object
		
				// execute procedure
		
				dao.executeProcedureByPosition(procIndex1);
		
				// get value
				err = dao.getString(procIndex1, "err");
		
				if (err == null)
					err = "";
		
				ws = dao.getWebRowSet(procIndex1, "resultset");		
				
				vo.setWrsData(ws);

		}
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("StockLedgerRptDAO.getData() --> "	+ e.getMessage());
			vo.setStrMsgType("1");

		}
		finally 
		{
			if (dao != null) 
			{
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
	public static void getDetailedStockLedgerDtl(CovidStockLedgerRptVO vo) {
		String err = "";
		String strProcName = "{call Pkg_Mms_rpt.Rptm_dtl_substore_ledger_dtl(?,?,?,?,?, ?,?,?,?)}"; // Total
																									// 9
																									// Variables

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("MMS Reports", "CovidStockLedgerRptDAO");
			

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
			vo.setStrMsgString("CovidStockLedgerRptDAO.getData() --> " + e.getMessage());
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
	public static  void  getItemTypeValues (CovidStockLedgerRptVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("MMS", "CovidStockLedgerRptDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.drugbrand.itemtype.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, "10");

			web = dao.executeQry(nQueryIndex);

			vo.setItemTypeWs(web);

		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("CovidStockLedgerRptDAO.getItemValues() --> " + e.getMessage());
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
