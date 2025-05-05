package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.PurchaseItemInventoryRptVO;

public class PurchaseItemInventoryRptDAO {
	
	public static void getStoreList(PurchaseItemInventoryRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.rptm_hstt_store_mst(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","PurchaseItemInventoryRptDAO");
		//	daoObj.setConnType("2");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "item_category", "0",4);
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

			voObj
					.setStrMsgString("PurchaseItemInventoryRptDAO.getStoreList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getItemCatList(PurchaseItemInventoryRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.Rptm_item_category_list(?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","PurchaseItemInventoryRptDAO");
		//	daoObj.setConnType("2");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
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

			voObj
					.setStrMsgString("PurchaseItemInventoryRptDAO.getItemCatList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getPOTypeList(PurchaseItemInventoryRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.Rptm_potype_List(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","PurchaseItemInventoryRptDAO");
		//	daoObj.setConnType("2");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "store_Id", voObj.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "item_cat", voObj.getStrItemCatNo(),4);
			daoObj.setProcInValue(nProcIndex, "req_For", voObj.getStrReqFor(),5);
			daoObj.setProcOutValue(nProcIndex, "err", 1,6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);
			
			//System.out.println("1--"+voObj.getStrStoreId());
			//System.out.println("2--"+voObj.getStrItemCatNo());

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrPOTypeWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
e.printStackTrace();
			voObj
					.setStrMsgString("PurchaseItemInventoryRptDAO.getPOTypeList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getSupplierList(PurchaseItemInventoryRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","PurchaseItemInventoryRptDAO");
		//daoObj.setConnType("2");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeVal", "19",1);
			daoObj.setProcInValue(nProcIndex, "catCode", "10",2);
			daoObj.setProcInValue(nProcIndex, "branditem_id", voObj.getStrSeatId(),3);
			daoObj.setProcInValue(nProcIndex, "contractType", "0",4);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),5);
			daoObj.setProcOutValue(nProcIndex, "err", 1,6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrSupplierWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("PurchaseItemInventoryRptDAO.getSupplierList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	
	
	public static void getItemName(PurchaseItemInventoryRptVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_MMS_rpt.rptm_itembrand_list(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;	
		String strErr = "";		
	
		try 
		{
			daoObj = new HisDAO("MMS","PurchaseItemInventoryRptDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue( nProcIndex, "modeval",  "7",1);
			daoObj.setProcInValue( nProcIndex, "catcode",  voObj.getStrItemCatNo(),2);
			daoObj.setProcInValue( nProcIndex, "groupid",  "0",3);
			daoObj.setProcInValue( nProcIndex, "subgrpid", "0",4);
			daoObj.setProcInValue( nProcIndex, "hosp_code",voObj.getStrHospitalCode(),5);			
			daoObj.setProcOutValue(nProcIndex, "err",      1,6);
			daoObj.setProcOutValue(nProcIndex, "resultset",2,7);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrItemNameWs(ws);				
				
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PurchaseItemInventoryRptDAO.getItemName() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	
	public static void getReportDtl(PurchaseItemInventoryRptVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_MMS_View2.rptm_po_purchase_inv_dtl(?,?,?,?,?,   ?,?,?,?,?,   ?,?)}";  //12 
		int nProcIndex = 0;	
		String strErr = "";		
	
		try 
		{
			System.out.println("voObj.getStrSePOTypeId()--"+voObj.getStrSePOTypeId());
			
			daoObj = new HisDAO("MMS","PurchaseItemInventoryRptDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue( nProcIndex, "modeval",   "1",1);
			daoObj.setProcInValue( nProcIndex, "hosp_code", voObj.getStrHospitalCode(),2);
			daoObj.setProcInValue( nProcIndex, "store_id",  "0",3);
			daoObj.setProcInValue( nProcIndex, "frmdate",   voObj.getStrFromDate(),4);
			daoObj.setProcInValue( nProcIndex, "todate",   voObj.getStrToDate(),5);	
			
			daoObj.setProcInValue( nProcIndex, "pono",     voObj.getStrPONo(),6);
			daoObj.setProcInValue( nProcIndex, "itemid",  voObj.getStrItemBrandId(),7);
			daoObj.setProcInValue( nProcIndex, "suppid",    voObj.getStrSupplierId(),8);
			daoObj.setProcInValue( nProcIndex, "potypeid",  voObj.getStrSePOTypeId(),9);
			daoObj.setProcInValue( nProcIndex, "catcode",  voObj.getStrItemCatNo(),10);			
			
			daoObj.setProcOutValue(nProcIndex, "err",      1,11);
			daoObj.setProcOutValue(nProcIndex, "resultset",2,12);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setReportDtlWs(ws);				
				
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("PurchaseItemInventoryRptDAO.getReportDtl() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
	}
}
