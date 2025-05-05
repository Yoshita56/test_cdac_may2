package mms.reports.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.MmsConfigUtil;
import mms.reports.vo.BillApprovalVerificationRptVO;

public class BillApprovalVerificationRptDAO {

	public static void getStoreList(BillApprovalVerificationRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		
		int nprocIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "SaleReportCategoryDAO");
			String strproc_name = "{call pkg_mms_rpt.rptm_hstt_store_mst(?,?,?,?,?,?)}";
			nprocIndex = daoObj.setProcedure(strproc_name);

			daoObj.setProcInValue(nprocIndex, "modeval", "5", 1);
			daoObj.setProcInValue(nprocIndex, "seatid", voObj.getStrSeatId(), 2);
			daoObj.setProcInValue(nprocIndex, "hosp_code", voObj.getStrHospitalCode(), 3);
			daoObj.setProcInValue(nprocIndex, "item_category", "0", 4);
			daoObj.setProcOutValue(nprocIndex, "err", 1, 5);
			daoObj.setProcOutValue(nprocIndex, "resultset", 2, 6);
			daoObj.executeProcedureByPosition(nprocIndex);
			strErr = daoObj.getString(nprocIndex, "err");
			strErr = daoObj.getString(nprocIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {
				
				ws = daoObj.getWebRowSet(nprocIndex, "resultset");
				voObj.setStrStoreWs(ws);
				System.out.println("DAO: Store List ::vo.setStrStoreWs(ws) size" + ws.size());

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("SaleReportCategoryDAO.getStoreList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getSupplierList(BillApprovalVerificationRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("MMS Transactions", "BillApprovalVerificationRptDAO");
			String strproc_name = "{call Pkg_Mms_View.proc_supplier_list(?,?,?,?,? ,?,?)}";
			nProcIndex = daoObj.setProcedure(strproc_name);

			daoObj.setProcInValue(nProcIndex, "modeval", "20", 1);
			daoObj.setProcInValue(nProcIndex, "catcode", voObj.getStrItemCategoryId(), 2);
			daoObj.setProcInValue(nProcIndex, "branditem_id", "0", 3);
			daoObj.setProcInValue(nProcIndex, "contracttype", "12", 4);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 5);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 7);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				voObj.setStrSupplierWs(ws);
				System.out.println("DAO: Supplier List ::vo.setStrSupplierWs(ws) size" + ws.size());

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("BillApprovalVerificationRptDAO.getSupplierList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getItemCatList(BillApprovalVerificationRptVO voObj) {
				int nProcIndex = 0;
				String strErr = "";
				WebRowSet ws = null;
				HisDAO daoObj=null;
				
				try
				{
					daoObj=new HisDAO("Item Location","BillApprovalVerificationRptDAO");
					String strProcName = "{call Pkg_Mms_Rpt.Rptm_item_category_list(?,?,?,?,?)}";
					nProcIndex = daoObj.setProcedure(strProcName);

					daoObj.setProcInValue(nProcIndex, "modeval", 		"2",1);
					daoObj.setProcInValue(nProcIndex, "hosp_code", 		MmsConfigUtil.GLOBAL_HOSPITAL_CODE,2);
					daoObj.setProcInValue(nProcIndex, "storeid", 		voObj.getStrStoreId(),3);
					daoObj.setProcOutValue(nProcIndex, "err",			1,4); 
					daoObj.setProcOutValue(nProcIndex, "resultset",		2,5);
					daoObj.executeProcedureByPosition(nProcIndex);
					
					strErr = daoObj.getString(nProcIndex, "err");
					if (strErr == null)
						strErr = "";
		
					if (strErr.equals("")) {
		
						ws = daoObj.getWebRowSet(nProcIndex, "resultset");
						voObj.setStrItemCatWs(ws);
						System.out.println("DAO: Item Category List ::vo.setStrItemCatWs(ws) size" + ws.size());

					} else {
						throw new Exception(strErr);
					}
				} catch (Exception e) {
					voObj.setStrMsgString("BillApprovalVerificationRptDAO.getItemCatList() --> "+ e.getMessage());
					voObj.setStrMsgType("1");
				} finally {
					if (daoObj != null) {
						daoObj.free();
						daoObj = null;
					}
				}
			}

	public static void getBillTypeList(BillApprovalVerificationRptVO voObj) {
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Item Location","BillApprovalVerificationRptDAO");
			String strProcName = "{call PKG_MMS_VIEW2.proc_bill_tpye_list(?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", 		"1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", 		MmsConfigUtil.GLOBAL_HOSPITAL_CODE,2);
			daoObj.setProcOutValue(nProcIndex, "err",			1,3); 
			daoObj.setProcOutValue(nProcIndex, "resultset",		2,4);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				voObj.setStrBillTypeWs(ws);
				System.out.println("DAO: BillTypeList ::vo.setStrBillTypeWs(ws) size" + ws.size());

			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			voObj.setStrMsgString("BillApprovalVerificationRptDAO.getItemCatList() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getPOCombo(BillApprovalVerificationRptVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		int nProcIndex = 0;
	
		String strErr = "";
		try 
		{
//		hstt_invoicetype_mst	10 - Bulk PO 11 - Local PO 12 - Supplier Receipt
			System.out.println(" --------------- BillApprovalVerificationRptDAO.getPODetailsSearchList ----------------- ");
			System.out.println(" --------------- Pkg_Mms_View.Proc_Po_Detail_Info --[ Mode--"+voObj.getStrProcMode()+"]--[<4,  10 - Bulk PO>--- <10, 11 - Local PO>-- <12 , 12 - Supplier Receipt> ]----------- ");

			daoObj = new HisDAO("MMS","BillApprovalVerificationRptDAO");
			String strProcName = "{call Pkg_Mms_View.Proc_Po_Detail_Info(?,?,?,?,?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modval", 		voObj.getStrProcMode(),1);
			daoObj.setProcInValue(nProcIndex, "item_category", 	"1",2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", 		voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "store_Id", 		voObj.getStrStoreId(),4);
//			daoObj.setProcInValue(nProcIndex, "store_Id", 		"10201100",4);
			daoObj.setProcInValue(nProcIndex, "poNo", 			voObj.getStrPoNoId(),5);
//			daoObj.setProcInValue(nProcIndex, "poNo", 			"PO ",5);
			daoObj.setProcInValue(nProcIndex, "po_frmdate", 	"0",6);
			daoObj.setProcInValue(nProcIndex, "po_todate", 		"0",7);
			daoObj.setProcInValue(nProcIndex, "schedule_no", 	voObj.getStrSupplierId(),8);  // Pass Supplier Id 
//			daoObj.setProcInValue(nProcIndex, "schedule_no", 	"1010005",8);  // Pass Supplier Id 
			daoObj.setProcOutValue(nProcIndex, "err", 			1,9);
			daoObj.setProcOutValue(nProcIndex, "resultset",     2,10);
			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";
			if (strErr.equals("")) 
			{
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				voObj.setStrPOSearchDetailsWs(ws);
				System.out.println("DAO: setStrPOSearchDetailsList ::vo.setStrPOSearchDetailsWs(ws) size" + ws.size());

			}
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			voObj.setStrMsgString("BillApprovalVerificationRptDAO.getPODetails() --> "+ e.getMessage());
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
	
	public static void getImageHeader(BillApprovalVerificationRptVO vo)
	{
		String strFuncName = "";
		String strLogoName = "";
		
		int nFuncIndex = 0;
		HisDAO dao = null;
		try 
		{
			dao = new HisDAO("DWH","SaleReportCategoryDAO");
			
			strFuncName = "{? = call MMS_MST.logo_config_dtl(?,?)}";
			nFuncIndex = dao.setFunction(strFuncName);
			
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncOutValue(nFuncIndex, 1);
			
			dao.executeFunction(nFuncIndex);
			
			strLogoName = dao.getFuncString(nFuncIndex);
			vo.setStrLogoName(strLogoName);

		} catch (Exception e) {
			
			e.printStackTrace();
			vo.setStrMsgType("1");
			vo.setStrMsgString("SaleReportCategoryDAO.getImageHeader() --> "+ e.getMessage());
			
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}
		}	
	}

	
	public static void getPOPrintDetails(BillApprovalVerificationRptVO voObj) 
	{
			HisDAO daoObj = null;
			WebRowSet ws = null;

			String strProcName = "{call Pkg_Mms_View.Proc_Po_Detail_Info(?,?,?,?,?,?,?,?,?,?)}";
			int nProcIndex = 0;
		
			String strErr = "";

			try 
			{
				System.out.println(" --------------- BillApprovalVerificationRptDAO.getPODetails ----------------- ");
				
				System.out.println(" --------------- Pkg_Mms_View.Proc_Po_Detail_Info --[ Mode - "+voObj.getStrProcMode()+" ]--------------- ");
				
				daoObj = new HisDAO("MMS","BillApprovalVerificationRptDAO");

				nProcIndex = daoObj.setProcedure(strProcName);
				 if(voObj.getStrBillTypeId().equals("10"))
				    {	
					 voObj.setStrProcMode("5");
				    }
				 if(voObj.getStrBillTypeId().equals("11"))
				    {	
					 voObj.setStrProcMode("11");
				    }
				 if(voObj.getStrBillTypeId().equals("12"))
				    {	
					 voObj.setStrProcMode("13");
				    }
				
				daoObj.setProcInValue(nProcIndex, "modval", 		voObj.getStrProcMode(),1);
				daoObj.setProcInValue(nProcIndex, "item_category",  "1",2);
				daoObj.setProcInValue(nProcIndex, "hosp_code", 		voObj.getStrHospitalCode(),3);
				daoObj.setProcInValue(nProcIndex, "store_Id", 		voObj.getStrStoreId(),4);
				daoObj.setProcInValue(nProcIndex, "poNo", 			voObj.getStrPoNoId(),5);
//				daoObj.setProcInValue(nProcIndex, "poNo", 			"PO-34345",5);
				daoObj.setProcInValue(nProcIndex, "po_frmdate", 	"0",6);
				daoObj.setProcInValue(nProcIndex, "po_todate", 		"0",7);
				daoObj.setProcInValue(nProcIndex, "schedule_no", 	voObj.getStrSupplierId(),8);  // Pass Supplier Id 
				daoObj.setProcOutValue(nProcIndex, "err", 			1,9);
				daoObj.setProcOutValue(nProcIndex, "resultset", 	2,10);

				daoObj.executeProcedureByPosition(nProcIndex);
				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				if (strErr.equals("")) 
				{
					ws = daoObj.getWebRowSet(nProcIndex, "resultset");
					voObj.setStrPODetailsWs(ws);
					System.out.println("DAO: getPOPrintDetails ::vo.setStrPODetailsWs(ws) size" + ws.size());
				} 
				else 
				{
					throw new Exception(strErr);
				}
			} 
			catch (Exception e) 
			{
				voObj.setStrMsgString("BillApprovalVerificationRptDAO.getPODetails() -->"+ e.getMessage());
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
	
	
	public static void getPrintDetails(BillApprovalVerificationRptVO vo) 
	{
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet ws = null;
		try {
			dao = new HisDAO("mms", "ChallanProcessTransDAO");
			
			System.out.println("---------- BillApprovalVerificationRptDAO . getPrintDetails ------------");
			System.out.println("---------- PKG_MMS_VIEW.PROC_HSTT_CHALL_VERIFIITEM_DTL --[ Mode - "+vo.getStrProcMode()+" ]----------");
			
			strproc_name = "{call PKG_MMS_VIEW.PROC_HSTT_CHALL_VERIFIITEM_DTL(?,?,?,?,? ,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);	
			/*
			 * 8 - Mode  for Supplier Receipt
			 * 6 - Mode  for Bulk PO
			 * 7 - Mode  for Local PO
			 * 
			 * */
			
			dao.setProcInValue(nprocIndex, "modval",      vo.getStrProcMode(),1);
			dao.setProcInValue(nprocIndex, "strId",       vo.getStrPOStoreId(),2);
			dao.setProcInValue(nprocIndex, "lPRequestNo", "0",3);
			dao.setProcInValue(nprocIndex, "hosp_code",   vo.getStrHospitalCode(),4);
			dao.setProcInValue(nprocIndex, "poNo",        vo.getStrPoNoId(),5);
			dao.setProcInValue(nprocIndex, "poStoreId",   "0",6);			
			dao.setProcOutValue(nprocIndex, "err",         1,7);
			dao.setProcOutValue(nprocIndex, "resultset",   2,8);
			
			dao.executeProcedureByPosition(nprocIndex);
			
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) 
			{
				ws = dao.getWebRowSet(nprocIndex, "resultset");		
				vo.setWsPrintItemDtls(ws);	
				System.out.println("PROC_HSTT_CHALL_VERIFIITEM_DTL:getPrintDetails: setWsPrintItemDtls size->"+ws.size());
				System.out.println("DAO: getPrintDetails ::vo.setWsPrintItemDtls(ws) size" + ws.size());


			} 
			else 
			{
				throw new Exception(strerr);
			}	

		} catch (Exception e) {
			vo.setStrMsgString("BillApprovalVerificationRptDAO.getPrintDetails() --> "
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
