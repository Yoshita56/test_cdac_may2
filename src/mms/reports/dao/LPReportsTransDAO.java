package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.LPReportsTransVO;

public class LPReportsTransDAO {
	
	public static void getStoreList(LPReportsTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.rptm_hstt_store_mst(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","LPReportsTransDAO");
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
					.setStrMsgString("LPReportsTransDAO.getStoreList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getItemCatList(LPReportsTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.Rptm_item_category_list(?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","LPReportsTransDAO");
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
					.setStrMsgString("LPReportsTransDAO.getItemCatList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getPOTypeList(LPReportsTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.Rptm_potype_List(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","LPReportsTransDAO");
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
					.setStrMsgString("LPReportsTransDAO.getPOTypeList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getSupplierList(LPReportsTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","LPReportsTransDAO");
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
					.setStrMsgString("LPReportsTransDAO.getSupplierList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getHospitalName(LPReportsTransVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_rpt.RPT_GET_HOSPITAL_LIST(?,?,?,?,?)}";
		int nProcIndex = 0;	
		String strErr = "";

		try 
		{
			daoObj = new HisDAO("MMS","LPReportsTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue( nProcIndex, "modeval","1",1);
			daoObj.setProcInValue( nProcIndex, "hosp_code",voObj.getStrHospitalCode(),2);
			daoObj.setProcInValue( nProcIndex, "seatId",voObj.getStrSeatId(),3);
			daoObj.setProcOutValue(nProcIndex, "err", 1,4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,5);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrHospitalWs(ws);				
				
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("LPReportsTransDAO.getHospitalName() --> "+ e.getMessage());
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
		
	public static void getReport(LPReportsTransVO vo) 
	{
		String err = "";
		String strProcName = "{call PKG_MMS_VIEW2.rptm_po_local_po_dtl(?,?,?,?,?  ,?,?,?,?,?, ? )}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		try {

			dao = new HisDAO("mms", "LPReportsTransDAO.getReport()");
			
			procIndex1 = dao.setProcedure(strProcName);
			
			// set value
			dao.setProcInValue(procIndex1, "modeval", 			vo.getStrMode());			
			dao.setProcInValue(procIndex1, "supp_id", 			vo.getStrSupplierId());		
			//dao.setProcInValue(procIndex1, "pono", 				(vo.getStrPONo() == null || vo.getStrPONo().equals("")) ? "0" : vo.getStrPONo());
			dao.setProcInValue(procIndex1, "pono", 				"0");
			dao.setProcInValue(procIndex1, "hosp_code",   		vo.getStrHospitalCode());
			//dao.setProcInValue(procIndex1, "item_cat",     		(vo.getStrPOCatgCode() == null || vo.getStrPOCatgCode().equals("")) ? "0" : vo.getStrPOCatgCode());
			dao.setProcInValue(procIndex1, "item_cat",     		"0");
			dao.setProcInValue(procIndex1, "from_date",       	vo.getStrFromDate());
			dao.setProcInValue(procIndex1, "to_date", 	    	vo.getStrToDate());				
			dao.setProcInValue(procIndex1, "seat_id",   	    vo.getStrSeatId());	
			//dao.setProcInValue(procIndex1, "po_type",   	    (vo.getStrPOTypeId() == null || vo.getStrPOTypeId().equals("")) ? "0" : vo.getStrPOTypeId());	
			dao.setProcInValue(procIndex1, "po_type",   	    "0");
			dao.setProcOutValue(procIndex1, "err",              1); // 1 for string return
			dao.setProcOutValue(procIndex1, "resultset",        2); // 2 for object
			// execute procedure
			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null) {
				err = "";
			}

			ws = dao.getWebRowSet(procIndex1, "resultset");
			//vo.setStrStockInHandRecordRptWS(ws);
			vo.setLpDtlsWs(ws);
			//System.out.println("WebRowSet---->"+ws);

		} catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("LPReportsTransDAO.getReport() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
}
