package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.StockLedgerRptVO;

/**
 * Developer : Vivek Aggarwal
 * Version : 1.0
 * Date : 16-Mar-2012
 * Modification Date: 
 *  
*/
public class StockLedgerRptDAO {
	
	public static void getStoreList(StockLedgerRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.rptm_hstt_store_mst(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","StockLedgerRptDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

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
	
	public static void getItemCatList(StockLedgerRptVO voObj) {

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
	
	public static void getGroupList(StockLedgerRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.rptm_store_group_list(?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","StockLedgerRptDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "item_category", voObj.getStrItemCatId(),3);
			daoObj.setProcOutValue(nProcIndex, "err", 1,4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,5);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrGroupWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("StockLedgerRptDAO.getGroupList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getItemList(StockLedgerRptVO voObj) {

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
	 * To Get Data
	 * 
	 * @param StockLedgerRptVO_p
	 */
	public static void getData(StockLedgerRptVO stockLedgerRptVO_p) 
	{
		
		String err = "";
		String proc_name1 = "{call Pkg_Mms_rpt.Rptm_cons_stock_ledger_dtl(?,?,?,?,?, ?,?,?,?)}";	// Total 9 Variables  //Done

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

				dao = new HisDAO("MMS Reports","StockLedgerRptDAO");
		
				HisUtil.replaceNullValueWithEmptyString(stockLedgerRptVO_p);
				
				procIndex1 = dao.setProcedure(proc_name1);
				
				//System.out.println("modeval"+ stockLedgerRptVO_p.getStrMode());
				//System.out.println("hosp_code"+ stockLedgerRptVO_p.getStrHospitalCode());
				//System.out.println("storeId"+ stockLedgerRptVO_p.getStrDWHId());
				//System.out.println("itemId"+ stockLedgerRptVO_p.getStrItemBrandId());				
				//System.out.println("frmDate"+ stockLedgerRptVO_p.getStrFromDate());
				//System.out.println("toDate"+ stockLedgerRptVO_p.getStrToDate());
				//System.out.println("StockLedgerRptDAO->getData()-> itemCatId :"+ stockLedgerRptVO_p.getStrItemCatId());
				
				
				
				
				dao.setProcInValue(procIndex1, "modeval", stockLedgerRptVO_p.getStrMode(),1);
				dao.setProcInValue(procIndex1, "hosp_code", stockLedgerRptVO_p.getStrHospitalCode(),4);
				dao.setProcInValue(procIndex1, "storeId", stockLedgerRptVO_p.getStrDWHId(),2);
				dao.setProcInValue(procIndex1, "itemCatId", stockLedgerRptVO_p.getStrItemCatId(),7);
				dao.setProcInValue(procIndex1, "itemId", stockLedgerRptVO_p.getStrItemBrandId(),3);				
				dao.setProcInValue(procIndex1, "frmDate", stockLedgerRptVO_p.getStrFromDate(),5);
				dao.setProcInValue(procIndex1, "toDate", stockLedgerRptVO_p.getStrToDate(),6);
				                        
					
				
				/* Setting Default Value End */
				
				dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
				// value
				dao.setProcOutValue(procIndex1, "resultset", 2,9); // 2 for object
		
				// execute procedure
		
				dao.executeProcedureByPosition(procIndex1);
		
				// get value
				err = dao.getString(procIndex1, "err");
		
				if (err == null)
					err = "";
		
				ws = dao.getWebRowSet(procIndex1, "resultset");
		
				stockLedgerRptVO_p.setWrsData(ws);

		}
		catch (Exception e) 
		{
			//e.printStackTrace();
			stockLedgerRptVO_p.setStrMsgString("StockLedgerRptDAO.getData() --> "	+ e.getMessage());
			stockLedgerRptVO_p.setStrMsgType("1");

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
	 * To Get Data
	 * 
	 * @param StockLedgerRptVO_p
	 */
	public static void getDetailedStockLedgerDtl(StockLedgerRptVO stockLedgerRptVO_p) 
	{
		String err = "";
		String proc_name1 = "{call Pkg_Mms_rpt.Rptm_detail_stock_ledger_dtl(?,?,?,?,?, ?,?,?,?,?)}";	// Total 10 Variables

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

				dao = new HisDAO("MMS Reports","StockLedgerRptDAO");
		
				HisUtil.replaceNullValueWithEmptyString(stockLedgerRptVO_p);
				
				procIndex1 = dao.setProcedure(proc_name1);
				
				
				
				//System.out.println("modeval"+ stockLedgerRptVO_p.getStrMode());
				//System.out.println("storeId"+ stockLedgerRptVO_p.getStrDWHId());
				//System.out.println("itemId"+ stockLedgerRptVO_p.getStrItemBrandId());
				//System.out.println("batchNo"+ stockLedgerRptVO_p.getStrBatchNo());
				//System.out.println("hosp_code"+ stockLedgerRptVO_p.getStrHospitalCode());
				//System.out.println("frmDate"+ stockLedgerRptVO_p.getStrFromDate());
				//System.out.println("toDate"+ stockLedgerRptVO_p.getStrToDate());
				//System.out.println("category"+ stockLedgerRptVO_p.getStrItemCatId());
				
				
				
				dao.setProcInValue(procIndex1, "modeval", stockLedgerRptVO_p.getStrMode(),1);
				dao.setProcInValue(procIndex1, "storeId", stockLedgerRptVO_p.getStrDWHId(),2);
				dao.setProcInValue(procIndex1, "itemId", stockLedgerRptVO_p.getStrItemBrandId(),3);
				dao.setProcInValue(procIndex1, "batchNo", stockLedgerRptVO_p.getStrBatchNo(),4);
				dao.setProcInValue(procIndex1, "hosp_code", stockLedgerRptVO_p.getStrHospitalCode(),5);
				dao.setProcInValue(procIndex1, "frmDate", stockLedgerRptVO_p.getStrFromDate(),6);
				dao.setProcInValue(procIndex1, "toDate", stockLedgerRptVO_p.getStrToDate(),7);
				dao.setProcInValue(procIndex1, "toDate", stockLedgerRptVO_p.getStrItemCatId(),8);
					
				
				/* Setting Default Value End */
				
				dao.setProcOutValue(procIndex1, "err", 1,9); // 1 for string return
				// value
				dao.setProcOutValue(procIndex1, "resultset", 2,10); // 2 for object
		
				// execute procedure
		
				dao.executeProcedureByPosition(procIndex1);
		
				// get value
				err = dao.getString(procIndex1, "err");
		
				if (err == null)
					err = "";
		
				ws = dao.getWebRowSet(procIndex1, "resultset");
		
				stockLedgerRptVO_p.setWrsData(ws);

		}
		catch (Exception e) 
		{
			//e.printStackTrace();
			stockLedgerRptVO_p.setStrMsgString("StockLedgerRptDAO.getData() --> "	+ e.getMessage());
			stockLedgerRptVO_p.setStrMsgType("1");

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
}
