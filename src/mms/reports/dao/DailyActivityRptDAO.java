package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.DailyActivityRptVO;
import mms.reports.vo.StockReceiptRegisterRptVO;

public class DailyActivityRptDAO
{

	/**
	 * To get Drug Warehouse Type Combo
	 *  
	 * @param voObj
	 * 
	 */
	public static void getDwhTypeCombo(DailyActivityRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_sstt_dwh_type_mst_cmb(?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("DWH","DailyActivityRptDAO");
			
			
			nProcIndex = daoObj.setProcedure(strProcName);    
		       
			
			daoObj.setProcInValue(nProcIndex, "p_mode", "1");
			daoObj.setProcInValue(nProcIndex, "p_gnum_hospital_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_sstnum_is_district_dwh", "0");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
//				voObj.setStrDrugWarehouseTypeWs(ws);
				
				voObj.setStrStoreWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("DailyActivityRptDAO.getStoreList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void GetUserLevel(DailyActivityRptVO voObj) {
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.get_userlevel_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","DailyActivityRptDAO");
			
			
			nProcIndex = daoObj.setProcedure(strProcName);
			
			////System.out.println("seatid"+voObj.getStrSeatId());
			////System.out.println("hosp_code"+voObj.getStrHospitalCode());

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hospCode", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrUserlevelWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("DailyActivityRptDAO.getUserLevel() --> "	+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
		
	}
	
	public static void getIssueVoucherDetailsPopUp(DailyActivityRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try 
		{						
			dao = new HisDAO("mms", "DailyActivityRptDAO");
			
			strproc_name = "{call PKG_MMS_RPT.proc_dailyActivityIssuedtl_Rpt(?,?,?,?,?,?,?,?,?,?,?)}";  // 11 Variable
						
			nprocIndex = dao.setProcedure(strproc_name);
						
			dao.setProcInValue(nprocIndex, "modeval", "2");
			dao.setProcInValue(nprocIndex, "pono", "0");
			dao.setProcInValue(nprocIndex, "supplierId", "0");			
			dao.setProcInValue(nprocIndex, "storeId", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate());
			dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate());
			dao.setProcInValue(nprocIndex, "toStoreId", "0");
			dao.setProcInValue(nprocIndex, "issueNo", "0");
			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");
			
                vo.setStrIssueVoucherDtlOneWS(wb); 
				

			} else {
				throw new Exception(strerr);
			}

		}
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("DailyActivityRptDAO.getIssueVoucherDetailsPopUp() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getRecieveVoucherDetailsPopUp(DailyActivityRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try 
		{						
			dao = new HisDAO("mms", "DailyActivityRptDAO");
			
			
			strproc_name = "{call PKG_MMS_RPT.proc_dailyActivityIssuedtl_Rpt(?,?,?,?,?,?,?,?,?,?,?)}";  // 11 Variable
						
			nprocIndex = dao.setProcedure(strproc_name);
			////System.out.println("DAO StoreId:"+vo.getStrStoreId());
			////System.out.println("DAO hospcode:"+vo.getStrHospitalCode());
			////System.out.println("DAO fromdate:"+vo.getStrFromDate());
			////System.out.println("DAO todate:"+vo.getStrToDate());
			
						
			dao.setProcInValue(nprocIndex, "modeval", "5");
			dao.setProcInValue(nprocIndex, "pono", "0");
			dao.setProcInValue(nprocIndex, "supplierId", "0");			
			dao.setProcInValue(nprocIndex, "storeId", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate());
			dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate());
			dao.setProcInValue(nprocIndex, "toStoreId", "0");
			dao.setProcInValue(nprocIndex, "issueNo", "0");
			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");
			
                vo.setStrReceiveVoucherDtlOneWS(wb); 
                
				

			} else {
				throw new Exception(strerr);
			}

		}
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("DailyActivityRptDAO.getIssueVoucherDetailsPopUp() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getSampleSendDetailsPopUp(DailyActivityRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try 
		{						
			dao = new HisDAO("mms", "DailyActivityRptDAO");
			
			strproc_name = "{call PKG_MMS_RPT.proc_dailyActivityIssuedtl_Rpt(?,?,?,?,?,?,?,?,?,?,?)}";  // 11 Variable
						
			nprocIndex = dao.setProcedure(strproc_name);
			////System.out.println("DAO StoreId:"+vo.getStrStoreId());
			////System.out.println("DAO hospcode:"+vo.getStrHospitalCode());
			////System.out.println("DAO fromdate:"+vo.getStrFromDate());
			////System.out.println("DAO todate:"+vo.getStrToDate());
			
						
			dao.setProcInValue(nprocIndex, "modeval", "8");
			dao.setProcInValue(nprocIndex, "pono", "0");
			dao.setProcInValue(nprocIndex, "supplierId", "0");			
			dao.setProcInValue(nprocIndex, "storeId", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate());
			dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate());
			dao.setProcInValue(nprocIndex, "toStoreId", "0");
			dao.setProcInValue(nprocIndex, "issueNo", "0");
			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");
			
                vo.setStrSampleSendDtlDtlOneWS(wb); 
                
				

			} else {
				throw new Exception(strerr);
			}

		}
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("DailyActivityRptDAO.getSampleSendDetailsPopUp() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getSampleSendItemBatchDetailsPopUp(DailyActivityRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try 
		{						
			dao = new HisDAO("mms", "DailyActivityRptDAO");
			
			strproc_name = "{call PKG_MMS_RPT.proc_dailyActivityIssuedtl_Rpt(?,?,?,?,?,?,?,?,?,?,?,?,?)}";  // 13 Variable
						
			nprocIndex = dao.setProcedure(strproc_name);
			
			////System.out.println("DAO StoreId:"+vo.getStrStoreId());
			////System.out.println("DAO hospcode:"+vo.getStrHospitalCode());
			////System.out.println("DAO fromdate:"+vo.getStrFromDate());
			////System.out.println("DAO todate:"+vo.getStrToDate());
			////System.out.println("itemId :"+vo.getSampleSendItemBatchHiddenVal().split("\\^")[2]);
			
						
			dao.setProcInValue(nprocIndex, "modeval", "9");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "pono", "0");
			dao.setProcInValue(nprocIndex, "supplierId", "0");			
			dao.setProcInValue(nprocIndex, "storeId", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "toStoreId", "0");
			dao.setProcInValue(nprocIndex, "issueNo", "0");
			dao.setProcInValue(nprocIndex, "challanNo", "0");
			dao.setProcInValue(nprocIndex, "itemId", vo.getSampleSendItemBatchHiddenVal().split("\\^")[2]);
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate());
			dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate());
			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");
			
                vo.setStrSampleSendDtlDtlTwoWS(wb); 
                
				

			} else {
				throw new Exception(strerr);
			}

		}
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("DailyActivityRptDAO.getSampleSendItemBatchDetailsPopUp() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	public static void getInstituteIssueDetailsPopUp(DailyActivityRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try 
		{						
			dao = new HisDAO("mms", "DailyActivityRptDAO");
			
			strproc_name = "{call PKG_MMS_RPT.proc_dailyActivityIssuedtl_Rpt(?,?,?,?,?,?,?,?,?,?,?)}";  // 11 Variable
						
			nprocIndex = dao.setProcedure(strproc_name);
						
			dao.setProcInValue(nprocIndex, "modeval", "3");
			dao.setProcInValue(nprocIndex, "pono", "0");
			dao.setProcInValue(nprocIndex, "supplierId", "0");			
			dao.setProcInValue(nprocIndex, "storeId", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate());
			dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate());
			dao.setProcInValue(nprocIndex, "toStoreId", vo.getStrReqStoreID());
			dao.setProcInValue(nprocIndex, "issueNo", "0");
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");
			
                vo.setStrIssueVoucherDtlTwoWS(wb); 
				

			} else {
				throw new Exception(strerr);
			}

		}
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("DailyActivityRptDAO.getInstituteIssueDetailsPopUp() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	public static void getIssueNoDetailsPopUp(DailyActivityRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try 
		{						
			dao = new HisDAO("mms", "DailyActivityRptDAO");
			
			strproc_name = "{call PKG_MMS_RPT.proc_dailyActivityIssuedtl_Rpt(?,?,?,?,?,?,?,?,?,?,?)}";  // 11 Variable
						
			nprocIndex = dao.setProcedure(strproc_name);
						
			dao.setProcInValue(nprocIndex, "modeval", "4");
			dao.setProcInValue(nprocIndex, "pono", "0");
			dao.setProcInValue(nprocIndex, "supplierId", "0");			
			dao.setProcInValue(nprocIndex, "storeId", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate());
			dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate());
			dao.setProcInValue(nprocIndex, "toStoreId", vo.getStrReqStoreID());
			dao.setProcInValue(nprocIndex, "issueNo", vo.getStrIssueNumber());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");
			
                vo.setStrIssueVoucherDtlThreeWS(wb); 
				

			} else {
				throw new Exception(strerr);
			}

		}
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("DailyActivityRptDAO.getInstituteIssueDetailsPopUp() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	
	public static void getIssueDetails(DailyActivityRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try 
		{						
			dao = new HisDAO("mms", "DailyActivityRptDAO");
			
			strproc_name = "{call PKG_MMS_RPT.proc_DailyActivity_Rpt(?,?,?,?,?,?,?,?,?)}";
						
			nprocIndex = dao.setProcedure(strproc_name);
				
			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "storeId", vo.getStrStoreId());			
			dao.setProcInValue(nprocIndex, "pono", "0");
			dao.setProcInValue(nprocIndex, "supplierId", "0");			
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate());
			dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");
			    vo.setStrIssueDtlWs(wb); 
				

			} else {
				throw new Exception(strerr);
			}

		}
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("DailyActivityRptDAO.getIssueDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getIssueItemDetails(DailyActivityRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "DailyActivityRptDAO");
			
			strproc_name = "{call PKG_MMS_RPT.proc_dailyActivityIssuedtl_Rpt(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			
			
			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "pono", "0");
//			dao.setProcInValue(nprocIndex, "issueNo", "0");
			dao.setProcInValue(nprocIndex, "storeId", vo.getStrStoreId());
			////System.out.println("Store ID:::"+vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate());
			dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate());
			dao.setProcInValue(nprocIndex, "supplierId", "0");
			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");
				////System.out.println("Size Issue Item Dtl:::"+wb.size());
                vo.setStrIssueItemDtlWs(wb); 
				

			} else {
				throw new Exception(strerr);
			}

		} 
		catch (Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("DailyActivityRptDAO.receiveInit() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	public static void getReceivedDetails(DailyActivityRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try
		{
			dao = new HisDAO("mms", "DailyActivityRptDAO");
			
			strproc_name = "{call PKG_MMS_RPT.proc_Received_Rpt(?,?,?,?,?,?,?,?,?)}";
						
			nprocIndex = dao.setProcedure(strproc_name);
						
			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "pono", "0");
			dao.setProcInValue(nprocIndex, "storeId", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate());
			dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate());
			dao.setProcInValue(nprocIndex, "supplierId", "0");
			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");
				////System.out.println("Size Received Dtl:::"+wb.size());
                vo.setStrReceivedItemDtlWs(wb); 
				

			} else {
				throw new Exception(strerr);
			}

		} 
		catch (Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("DailyActivityRptDAO.getReceivedDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getChallanItemDetails(DailyActivityRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try
		{
			dao = new HisDAO("mms", "DailyActivityRptDAO");
			
			strproc_name = "{call PKG_MMS_RPT.proc_dailyActivityIssuedtl_Rpt(?,?,?,?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);			
			
			 /*
			1.Recipt No(Challan)
			2.Challan No
			3.Challan Date
			4.Received Date
			5.No Packet
			6.Supplied Value(SUM)
			+++++++++++++++++++++++++++  
			7.Supplier Name,
			8.Supplier Id,
			9.PO With Ref No,
			10.PO Date,
			11.PO No
			12.Supplied Value
			13.Received Count
			++++++++++++++++++++++++++++++++++++++++++++
	    	14. Issue Count
	    	15. Receive Count
            16. DWH Name
            17. Store ID
            18.Sample Sent Count
			*/		
			/*
			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "pono",  vo.getStrReceiveVoucherHiddenVal().split("\\^")[10]);
			dao.setProcInValue(nprocIndex, "storeId", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate());
			dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate());
			dao.setProcInValue(nprocIndex, "challanNo", vo.getStrReceiveVoucherHiddenVal().split("\\^")[0]);
			dao.setProcInValue(nprocIndex, "scheduleNo", vo.getStrReceiveVoucherHiddenVal().split("\\^")[4]);			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			
			*/
			dao.setProcInValue(nprocIndex, "modeval", "7");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "pono", vo.getStrReceiveVoucherHiddenVal().split("\\^")[10]);
			dao.setProcInValue(nprocIndex, "supplierId", "0");
			dao.setProcInValue(nprocIndex, "storeId", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "toStoreId", "0");
			dao.setProcInValue(nprocIndex, "issueNo", "0");
			dao.setProcInValue(nprocIndex, "challanNo", vo.getStrReceiveVoucherHiddenVal().split("\\^")[1]);
			
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate());
			dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate());
					
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
			    vo.setStrChallanItemDtlWs(wb); 
				

			} else {
				throw new Exception(strerr);
			}

		} 
		catch (Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("DailyActivityRptDAO.getChallanItemDetails() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	public static void getPOChallanDetails(DailyActivityRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try
		{
			dao = new HisDAO("mms", "DailyActivityRptDAO");
			
			strproc_name = "{call PKG_MMS_RPT.proc_dailyActivityIssuedtl_Rpt(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			
			/*
			1.Supplier Name,
			2.Supplier Id,
			3.PO With Ref No,
			4.PO Date,
			5.PO No
			6.Supplied Value
			7.Received Count
			++++++++++++++++++++++++++++++++++++++++++++
	    	8. Issue Count
	    	9. Receive Count
            10. DWH Name
            11. Store ID
            12.Sample Sent Count
			*/
			
			////System.out.println("DAO PO No: "+vo.getStrReceiveVoucherHiddenVal().split("\\^")[4]);
			////System.out.println("DAO Storeid: "+vo.getStrStoreId());
			////System.out.println("DAO hospcode: "+vo.getStrHospitalCode());
			////System.out.println("DAO Fromdate: "+vo.getStrFromDate());
			////System.out.println("DAO todate: "+vo.getStrToDate());
			
			dao.setProcInValue(nprocIndex, "modeval", "6");
			dao.setProcInValue(nprocIndex, "pono", vo.getStrReceiveVoucherHiddenVal().split("\\^")[4]);
			dao.setProcInValue(nprocIndex, "storeId", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate());
			dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate());
			dao.setProcInValue(nprocIndex, "supplierId", "0");			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");
			    vo.setStrPOChallanItemDtlWs(wb); 
				

			} else {
				throw new Exception(strerr);
			}

		} 
		catch (Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("DailyActivityRptDAO.getPOChallanDetails() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	
	
	/**
	 * To get Store Combo  from the hstt_store_mst
	 *  
	 * @param voObj
	 */
	public static void getStoreList(DailyActivityRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("DWH","DailyActivityRptDAO");
			
			
			nProcIndex = daoObj.setProcedure(strProcName);

			
			daoObj.setProcInValue(nProcIndex, "modeval", voObj.getStrMode());
			daoObj.setProcInValue(nProcIndex, "seatid", voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeid", "0");
			daoObj.setProcInValue(nProcIndex, "storetype_id","0"); 
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
	
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
					.setStrMsgString("DailyActivityRptDAO.getStoreList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	/**
	 * The following procedure is used to populate the value of Supplier Name
	 * combo using Pkg_Mms_View.proc_supplier_list procedure.
	 * 
	 * 
	 */

	public static void getSuppliedByList(DailyActivityRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "1");
			dao.setProcInValue(nprocIndex, "catCode", "10");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			
			/* Start */
			dao.setProcInValue(nprocIndex, "branditem_id", "0");
			dao.setProcInValue(nprocIndex, "contractType", "0");
			/* End */
			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {
				// //System.out.println("DAO -->" + wb.size());
				vo.setStrManufactureComboWS(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("DrugInventoryTransDAO.getSuppliedByList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
}
