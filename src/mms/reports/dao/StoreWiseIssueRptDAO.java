package mms.reports.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.reports.vo.StoreWiseIssueRptVO;

public class StoreWiseIssueRptDAO {
	
	public static void getStoreList(StoreWiseIssueRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.rptm_hstt_store_mst(?,?,?,?,?,?)}";
		int nprocIndex = 0;
	
		String strErr = "";

	
		try {

			daoObj = new HisDAO("MMS Transactions","PendingIndentStatusRecordRptDAO");
		String strproc_name = "{call pkg_mms_rpt.rptm_hstt_store_mst(?,?,?,?,?,?)}";
		nprocIndex = daoObj.setProcedure(strproc_name);
		
		daoObj.setProcInValue(nprocIndex, "modeval",voObj.getStrMode(),1);
		daoObj.setProcInValue(nprocIndex, "seatid",voObj.getStrSeatId(),2);
		daoObj.setProcInValue(nprocIndex, "hosp_code", voObj.getStrHospitalCode(),3);
		daoObj.setProcInValue(nprocIndex, "item_category", "0",4);
		daoObj.setProcOutValue(nprocIndex, "err", 1,5);
		daoObj.setProcOutValue(nprocIndex, "resultset", 2,6); 
		daoObj.executeProcedureByPosition(nprocIndex);
		strErr = daoObj.getString(nprocIndex, "err");
			strErr = daoObj.getString(nprocIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nprocIndex, "resultset");
		
				voObj.setStrStoreWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("PendingIndentStatusRecordRptDAO.getStoreList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getIssueDtls(StoreWiseIssueRptVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		int nprocIndex = 0;
		String strErr = "";

		try 
		{							 
			daoObj = new HisDAO("MMS Transactions","StoreWiseIssueRptDAO");
		    String strproc_name = "{call PKG_MMS_RPT_BIRT.RPTM_PENDINGINDENT_STATUS(?,?,?,?,?,?,?)}";
		    nprocIndex = daoObj.setProcedure(strproc_name);		
			daoObj.setProcInValue(nprocIndex, "modeval",	"1",1);
			daoObj.setProcInValue(nprocIndex, "hosp_code",	voObj.getStrHospitalCode(),2);
			daoObj.setProcInValue(nprocIndex, "strId", 	voObj.getStrFromDate(),3);
			daoObj.setProcInValue(nprocIndex, "catcode", 	voObj.getStrItemCatId(),4);
			daoObj.setProcInValue(nprocIndex, "fromdate", 	voObj.getStrFromDate(),5);
			daoObj.setProcInValue(nprocIndex, "todate", 	voObj.getStrToDate(),6);	
			daoObj.setProcInValue(nprocIndex, "reqTypeId", 	voObj.getStrReqTypeId(),7);

			daoObj.setProcOutValue(nprocIndex, "err", 		1,8);
			daoObj.setProcOutValue(nprocIndex, "resultset", 2,9); 
			daoObj.executeProcedureByPosition(nprocIndex);
			strErr = daoObj.getString(nprocIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nprocIndex, "resultset");
		
				voObj.setStrPartialIssueWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("PendingIndentStatusRecordRptDAO.getStoreList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getItemCatList(StoreWiseIssueRptVO voObj) {

/*		HisDAO dao = null;
		WebRowSet ws = null;

		String strproc_name = "{call Pkg_Mms_Rpt.Rptm_item_category_list(?,?,?,?,?)}";
		int nprocIndex = 0;
	
		String strerr = "";
		try{
		dao = new HisDAO("MMS Transactions","PendingIndentStatusRecordRptDAO");
		nprocIndex = dao.setProcedure(strproc_name);
		System.out.println("modeval"+voObj.getStrMode());
		dao.setProcInValue(nprocIndex, "modeval",voObj.getStrMode(),1);
		dao.setProcInValue(nprocIndex, "hosp_code", voObj.getStrHospitalCode(),2);
		dao.setProcInValue(nprocIndex, "storeId",voObj.getStrStoreId(),3);							
		dao.setProcOutValue(nprocIndex, "err", 1,4);
		dao.setProcOutValue(nprocIndex, "resultset", 2,5); 
		
		dao.executeProcedureByPosition(nprocIndex);
		strerr = dao.getString(nprocIndex, "err");
		
		if (strerr == null)
			strerr = "";*/
		/*String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet ws = null;
		
		try 
		{
				dao = new HisDAO("mms", "IssueDetailRptDAO");
				strproc_name = "{call pkg_mms_rpt.Rptm_item_category_list(?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				System.out.println("modeval"+voObj.getStrMode());
				dao.setProcInValue(nprocIndex, "modeval",voObj.getStrMode(),1);
				dao.setProcInValue(nprocIndex, "hosp_code", voObj.getStrHospitalCode(),2);
				dao.setProcInValue(nprocIndex, "storeId",voObj.getStrStoreId(),3);							
				dao.setProcOutValue(nprocIndex, "err", 1,4);
				dao.setProcOutValue(nprocIndex, "resultset", 2,5); 
				
				dao.executeProcedureByPosition(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				
				if (strerr == null)
					strerr = "";

			if (strerr.equals("")) {

				ws = dao.getWebRowSet(nprocIndex, "resultset");
		
				voObj.setStrItemCatWs(ws);
							
			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("PendingIndentStatusRecordRptDAO.getItemCatList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
*/

	HisDAO daoObj = null;
	WebRowSet ws = null;
	int nprocIndex = 0;
	String strErr = "";
	/*String strProcName = "{call Pkg_Mms_Rpt.Rptm_item_category_list(?,?,?,?,?)}";
	

	

	try {

		daoObj = new HisDAO("MMS Transactions","StockReceiptRegisterRptDAO");
	//	daoObj.setConnType("2");
		nProcIndex = daoObj.setProcedure(strProcName);

		daoObj.setProcInValue(nProcIndex, "modeval", voObj.getStrMode());
		daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStoreId());
		daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
		daoObj.setProcOutValue(nProcIndex, "err", 1);
		daoObj.setProcOutValue(nProcIndex, "resultset", 2);

		daoObj.executeProcedure(nProcIndex);

		strErr = daoObj.getString(nProcIndex, "err");*/
	
	try
	{daoObj = new HisDAO("mms", "PendingIndentStatusRecordRptDAO");
	String strProcName = "{call pkg_mms_rpt.Rptm_item_category_list(?,?,?,?,?)}";
	nprocIndex = daoObj.setProcedure(strProcName);
	System.out.println("modeval"+voObj.getStrMode());
	daoObj.setProcInValue(nprocIndex, "modeval",voObj.getStrMode(),1);
	daoObj.setProcInValue(nprocIndex, "hosp_code", voObj.getStrHospitalCode(),2);
	daoObj.setProcInValue(nprocIndex, "storeId",voObj.getStrStoreId(),3);							
	daoObj.setProcOutValue(nprocIndex, "err", 1,4);
	daoObj.setProcOutValue(nprocIndex, "resultset", 2,5); 
	
	daoObj.executeProcedureByPosition(nprocIndex);
	strErr = daoObj.getString(nprocIndex, "err");

		if (strErr == null)
			strErr = "";

		if (strErr.equals("")) {

			ws = daoObj.getWebRowSet(nprocIndex, "resultset");
	
			voObj.setStrItemCatWs(ws);
						
		} else {
			throw new Exception(strErr);
		}

	} catch (Exception e) {

		voObj
				.setStrMsgString("StockReceiptRegisterRptDAO.getItemCatList() --> "
						+ e.getMessage());
		voObj.setStrMsgType("1");

	} finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	}
	
	}
	
	public static void getIReqTypeList(StoreWiseIssueRptVO voObj) {

	HisDAO daoObj = null;
	WebRowSet ws = null;
	int nprocIndex = 0;
	String strErr = "";
	
	
	try
	{daoObj = new HisDAO("mms", "PendingIndentStatusRecordRptDAO");
	String strProcName = "{call pkg_mms_rpt.rptm_request_type_cmb(?,?,?,?,?,?)}";
	nprocIndex = daoObj.setProcedure(strProcName);
	//System.out.println("modeval"+voObj.getStrMode());
	// added by Vipul on 10.05.2021
	daoObj.setProcInValue(nprocIndex, "modeval",voObj.getStrMode(),1);
	//daoObj.setProcInValue(nprocIndex, "modeval","2",1);
	daoObj.setProcInValue(nprocIndex, "hosp_code", voObj.getStrHospitalCode(),2);
	daoObj.setProcInValue(nprocIndex, "catcode",voObj.getStrItemCatId(),3);
	daoObj.setProcInValue(nprocIndex, "strid",voObj.getStrStoreId(),4);
	daoObj.setProcOutValue(nprocIndex, "err", 1,5);
	daoObj.setProcOutValue(nprocIndex, "resultset", 2,6); 
	
	daoObj.executeProcedureByPosition(nprocIndex);
	strErr = daoObj.getString(nprocIndex, "err");

		if (strErr == null)
			strErr = "";

		if (strErr.equals("")) {

			ws = daoObj.getWebRowSet(nprocIndex, "resultset");
			System.out.println("ws.size"+ws.size());
			voObj.setStrReqTypeWs(ws);
						
		} else {
			throw new Exception(strErr);
		}

	} catch (Exception e) {

		voObj
				.setStrMsgString("StockReceiptRegisterRptDAO.getItemCatList() --> "
						+ e.getMessage());
		voObj.setStrMsgType("1");

	} finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	}
	
	}
	
	/* ==new Added== */
	public static void getViewDtl(StoreWiseIssueRptVO voObj)
	{
		String strProcName = "{call Pkg_Mms_VIEW2.rptm_na_report_generation(?::character varying,?::character varying,?::character varying,?::character varying,? ::character varying,?::character varying,?::character varying,?::character varying,?)}";

		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try 
		{
			daoObj = new HisDAO("DWH","PendingIndentStatusRecordRptDAO");
			nProcIndex = daoObj.setProcedure(strProcName);	
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);  	 
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),2);	     
			daoObj.setProcInValue(nProcIndex, "strid",  voObj.getStrStoreId(),3);				     
			daoObj.setProcInValue(nProcIndex, "catcode", voObj.getStrItemCatNo(),4);     
			daoObj.setProcInValue(nProcIndex, "frmdate",voObj.getStrFromDate(),5);  
			daoObj.setProcInValue(nProcIndex, "todate",voObj.getStrToDate(),6);    
			daoObj.setProcInValue(nProcIndex, "reqtypeid",voObj.getStrReqTypeId(),7);    
			daoObj.setProcOutValue(nProcIndex, "err",         1,8); 	
			daoObj.setProcOutValue(nProcIndex, "resultset",   2,9);		

			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");
			
			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				//System.out.println(" ----------> Size---------"+ ws.size());
				voObj.setWsIssueDtlRpt(ws);
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("PendingIndentStatusRecordRptDAO.getViewDtl() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getPartialIssueDtls(StoreWiseIssueRptVO voObj) 
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;
		
		int nprocIndex = 0;
	
		String strErr = "";
	
		try 
		{							 

			daoObj = new HisDAO("MMS Transactions","PendingIndentStatusRecordRptDAO");
		    String strproc_name = "{call pkg_mms_rpt.rptm_storewise_issue(?,?,?,?,?  ,?,?,?,?)}";
		    nprocIndex = daoObj.setProcedure(strproc_name);		
			daoObj.setProcInValue(nprocIndex, "modeval",	"1",1);
			daoObj.setProcInValue(nprocIndex, "hosp_code",	voObj.getStrHospitalCode(),2);
			daoObj.setProcInValue(nprocIndex, "fromdate", 	voObj.getStrFromDate(),3);
			daoObj.setProcInValue(nprocIndex, "todate", 	voObj.getStrToDate(),4);		
			daoObj.setProcInValue(nprocIndex, "strid", 		voObj.getStrStoreId(),5);
			daoObj.setProcInValue(nprocIndex, "reqtypeid", 	voObj.getStrReqTypeId(),6);
			daoObj.setProcInValue(nprocIndex, "catcode", 	voObj.getStrItemCatId(),7);
			daoObj.setProcOutValue(nprocIndex, "err", 		1,8);
			daoObj.setProcOutValue(nprocIndex, "resultset", 2,9); 
			daoObj.executeProcedureByPosition(nprocIndex);
			strErr = daoObj.getString(nprocIndex, "err");
			

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nprocIndex, "resultset");
		
				voObj.setStrPartialIssueWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("PendingIndentStatusRecordRptDAO.getStoreList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
}

