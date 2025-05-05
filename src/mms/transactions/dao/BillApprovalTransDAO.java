package mms.transactions.dao;
import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.transactions.vo.BillApprovalTransVO; 

/**
 * 
 * @author dell
 *
 */
public class BillApprovalTransDAO 
{
	public static void getSeatUserName(BillApprovalTransVO vo)
	{
		String err="";
        int funcIndex = 0;
		
		String strSeatUserName = "";
		HisDAO daoObj=null;
		try
		{
			
			     System.out.println(" --------------- BillApprovalTransDAO.getSeatUserName ----------------- ");
				 daoObj=new HisDAO("Bill Approval","BillApprovalTransDAO");					 				 
				 String strFuncName = "{? = call MMS_MST.get_username(?::numeric)}";
				 funcIndex = daoObj.setFunction(strFuncName);				
				 daoObj.setFuncInValue(funcIndex, 2, vo.getStrSeatId());
				 daoObj.setFuncOutValue(funcIndex, 1);
				 daoObj.executeFunction(funcIndex);
				 strSeatUserName = daoObj.getFuncString(funcIndex);
				 vo.setStrSeatUserName(strSeatUserName);
				
		}
		catch (Exception e) 
		{
			vo.setStrMsgString("BillApprovalTransDAO.getSeatUserName() -->"+ e.getMessage());
			vo.setStrMsgType("1");
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
	
	/**
	 * This method is used to call the procedure and set the values
	 * corresponding to it for populating the 
	 * PO Details
	 */
	public static void getPODetails(BillApprovalTransVO voObj) 
	{
			HisDAO daoObj = null;
			WebRowSet ws = null;

			String strProcName = "{call Pkg_Mms_View.Proc_Po_Detail_Info(?,?,?,?,?,?,?,?,?,?)}";
			int nProcIndex = 0;
		
			String strErr = "";

			try 
			{
				System.out.println(" --------------- BillApprovalTransDAO.getPODetails ----------------- ");
				
				System.out.println(" --------------- Pkg_Mms_View.Proc_Po_Detail_Info --[ Mode - "+voObj.getStrProcMode()+" ]--------------- ");
				
				daoObj = new HisDAO("MMS","BillApprovalTransDAO");

				nProcIndex = daoObj.setProcedure(strProcName);

				daoObj.setProcInValue(nProcIndex, "modval", 		voObj.getStrProcMode(),1);
				daoObj.setProcInValue(nProcIndex, "item_category",  "1",2);
				daoObj.setProcInValue(nProcIndex, "hosp_code", 		voObj.getStrHospitalCode(),3);
				daoObj.setProcInValue(nProcIndex, "store_Id", 		voObj.getStrStoreId(),4);
				daoObj.setProcInValue(nProcIndex, "poNo", 			voObj.getStrPONo(),5);
				daoObj.setProcInValue(nProcIndex, "po_frmdate", 	"0",6);
				daoObj.setProcInValue(nProcIndex, "po_todate", 		"0",7);
				daoObj.setProcInValue(nProcIndex, "schedule_no", 	voObj.getStrSupplierId().split("\\^")[0],8);  // Pass Supplier Id 
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
				} 
				else 
				{
					throw new Exception(strErr);
				}
			} 
			catch (Exception e) 
			{
				voObj.setStrMsgString("BillApprovalTransDAO.getPODetails() -->"+ e.getMessage());
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
	/**
	 * This method is used to call the procedure and set the values
	 * corresponding to it for populating the 
	 * GROUP LIST
	 */
	public static void getPeneltyDtls(BillApprovalTransVO voObj) {

			HisDAO daoObj = null;
			WebRowSet ws = null;

			String strProcName = "{call Pkg_Mms_View.proc_penalty_dtl(?,?,?,?,?,?,?)}";
			int nProcIndex = 0;
		
			String strErr = "";

			try 
			{
				
				System.out.println(" --------------- BillApprovalTransDAO.getPeneltyDtls ----------------- ");
				
				System.out.println(" --------------- Pkg_Mms_View.proc_penalty_dtl --[ Mode - 1 ]--------------- ");
				
				daoObj = new HisDAO("MMS Transactions","BillApprovalTransDAO");

				nProcIndex = daoObj.setProcedure(strProcName);				
				
				daoObj.setProcInValue(nProcIndex, "modval", "1",1);
				daoObj.setProcInValue(nProcIndex, "strScheduleNo", voObj.getStrScheduleNo(),2);
				daoObj.setProcInValue(nProcIndex, "strPoNo", voObj.getStrPONo(),3);
				daoObj.setProcInValue(nProcIndex, "strId", voObj.getStrPOStoreId(),4);
				daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),5);
				daoObj.setProcOutValue(nProcIndex, "err", 1,6);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);

				daoObj.executeProcedureByPosition(nProcIndex);
				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				if (strErr.equals("")) {

					ws = daoObj.getWebRowSet(nProcIndex, "resultset");
					//System.out.println("Size"+ws.size());
					voObj.setWsPeneltyDtl(ws);
				} else {
					throw new Exception(strErr);
				}

			} catch (Exception e) {
				e.printStackTrace();
				voObj.setStrMsgString("BillApprovalTransDAO.getPeneltyDtls() -->"+ e.getMessage());
				voObj.setStrMsgType("1");
			} finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
		}
	public static void getWaiveOffApprovedBy(BillApprovalTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Consultant_Name(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			
			System.out.println(" --------------- BillApprovalTransDAO.getWaiveOffApprovedBy ----------------- ");
			
			System.out.println(" --------------- Pkg_Mms_View.Proc_Consultant_Name --[ Mode - 2 ]--------------- ");
			
			daoObj = new HisDAO("MMS Transactions","BillApprovalTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
           // System.out.println("hosp_code->"+voObj.getStrHospitalCode());
		   // daoObj.setProcInValue(nProcIndex, "modeval", "2",1);// modeval 2 is for all doctor list in approved by section 
			daoObj.setProcInValue(nProcIndex, "modeval", "3",1);//// modeval 3 is for all users 

			daoObj.setProcInValue(nProcIndex, "deptunitcode", "0",2);

			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "seatId",    voObj.getStrSeatId(),4);
			
			
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				voObj.setStrWaiveOffApprovedByWS(ws);
				//System.out.println("ws size->"+ws.size());
				} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			voObj.setStrMsgString("BillApprovalTransDAO.getWaiveOffApprovedBy() -->"+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	/**
	 * This method is used to call the procedure and set the values
	 * corresponding to it for populating the 
	 * GROUP LIST
	 */
	public static void getPOScheduleDetails(BillApprovalTransVO voObj) {

			HisDAO daoObj = null;
			WebRowSet ws = null;

			String strProcName = "{call Pkg_Mms_View.Proc_Po_Detail_Info(?,?,?,?,?,?,?,?,?,?)}";
			int nProcIndex = 0;
		
			String strErr = "";

			try {
				System.out.println(" --------------- BillApprovalTransDAO.getPOScheduleDetails ----------------- ");
				
				System.out.println(" --------------- Pkg_Mms_View.Proc_Po_Detail_Info --[ Mode - 6 ]--------------- ");
				
				daoObj = new HisDAO("MMS Transactions","BillApprovalTransDAO");

				nProcIndex = daoObj.setProcedure(strProcName);

				daoObj.setProcInValue(nProcIndex, "modval", "6",1);
				daoObj.setProcInValue(nProcIndex, "item_category", "1",2);
				daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
				daoObj.setProcInValue(nProcIndex, "store_Id", voObj.getStrPOStoreId(),4);
				daoObj.setProcInValue(nProcIndex, "poNo", voObj.getStrPONo(),5);
				daoObj.setProcInValue(nProcIndex, "po_frmdate", "0",6);
				daoObj.setProcInValue(nProcIndex, "po_todate", "0",7);
				/* Start */
				
				
				daoObj.setProcInValue(nProcIndex, "schedule_no", "0",8); 
				
				/* End */
				daoObj.setProcOutValue(nProcIndex, "err", 1,9);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,10);

				daoObj.executeProcedureByPosition(nProcIndex);
				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				if (strErr.equals("")) {

					ws = daoObj.getWebRowSet(nProcIndex, "resultset");
					voObj.setStrScheduleDtlsWS(ws);
				} else {
					throw new Exception(strErr);
				}

			} catch (Exception e) {
				voObj
						.setStrMsgString("BillApprovalTransDAO.getPODetails() --> "
								+ e.getMessage());
				voObj.setStrMsgType("1");

			} finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
		}
	
	public static void getPrintDetails(BillApprovalTransVO vo) 
	{
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet ws = null;
		try {
			dao = new HisDAO("mms", "ChallanProcessTransDAO");
			
			System.out.println("---------- BillApprovalTransDAO . getPrintDetails ------------");
			System.out.println("---------- PKG_MMS_VIEW.PROC_HSTT_CHALL_VERIFIITEM_DTL --[ Mode - "+vo.getStrProcMode()+" ]----------");
			
			strproc_name = "{call PKG_MMS_VIEW.PROC_HSTT_CHALL_VERIFIITEM_DTL(?,?,?,?,? ,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);	
			/*
			 * 6 - Mode  for Bulk PO
			 * 7 - Mode  for Local PO
			 * 
			 * */
			
			dao.setProcInValue(nprocIndex, "modval",      vo.getStrProcMode(),1);
			dao.setProcInValue(nprocIndex, "strId",       vo.getStrPOStoreId(),2);
			dao.setProcInValue(nprocIndex, "lPRequestNo", "0",3);
			dao.setProcInValue(nprocIndex, "hosp_code",   vo.getStrHospitalCode(),4);
			dao.setProcInValue(nprocIndex, "poNo",        vo.getStrPONo(),5);
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
			} 
			else 
			{
				throw new Exception(strerr);
			}	

		} catch (Exception e) {
			vo.setStrMsgString("BillApprovalTransDAO.getPrintDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	public static void getPaymentDetails(BillApprovalTransVO vo) 
	{
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet ws = null;
		try 
		{
			dao = new HisDAO("mms", "ChallanProcessTransDAO");			
			System.out.println("---------- BillApprovalTransDAO . getPaymentDetails ------------");
			System.out.println("---------- PKG_MMS_VIEW.proc_hstt_invoice_payment_dtl --[ Mode - 1 ]----------");
			
			strproc_name = "{call PKG_MMS_VIEW.proc_hstt_invoice_payment_dtl(?,?,?,?,?   ,?,?,?,?,? , ?)}";
			nprocIndex = dao.setProcedure(strproc_name);			
			
			dao.setProcInValue(nprocIndex, "modval",      	"1",1);
			dao.setProcInValue(nprocIndex, "strId",       	"0",2);
			dao.setProcInValue(nprocIndex, "invoiceno", 	"0",3);
			dao.setProcInValue(nprocIndex, "hosp_code",  	vo.getStrHospitalCode(),4);
			dao.setProcInValue(nprocIndex, "poNo",        	vo.getStrPONo(),5);
			dao.setProcInValue(nprocIndex, "poStoreId",   	vo.getStrPOStoreId(),6);	
			dao.setProcInValue(nprocIndex, "invoicetype",   vo.getStrBillType(),7);		
			dao.setProcInValue(nprocIndex, "fromdate",   	"0",8);	
			dao.setProcInValue(nprocIndex, "todate",   		"0",9);
			dao.setProcOutValue(nprocIndex, "err",         1,10);
			dao.setProcOutValue(nprocIndex, "resultset",   2,11);
			
			dao.executeProcedureByPosition(nprocIndex);
			
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) 
			{
				ws = dao.getWebRowSet(nprocIndex, "resultset");		
				vo.setWsPaymentDtls(ws);							
			} 
			else 
			{
				throw new Exception(strerr);
			}	

		} catch (Exception e) {
			vo.setStrMsgString("BillApprovalTransDAO.getPaymentDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getSUPP_PaymentDetails(BillApprovalTransVO vo) 
	{
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet ws = null;
		try 
		{
			dao = new HisDAO("mms", "ChallanProcessTransDAO");			
			System.out.println("---------- BillApprovalTransDAO . getSUPP_PaymentDetails ------------");
			System.out.println("---------- PKG_MMS_VIEW.proc_hstt_invoice_payment_dtl --[ Mode - 2 ]----------");
			
			strproc_name = "{call PKG_MMS_VIEW.proc_hstt_invoice_payment_dtl(?,?,?,?,?   ,?,?,?,?,? , ?)}";
			nprocIndex = dao.setProcedure(strproc_name);			
			
			dao.setProcInValue(nprocIndex, "modval",      	"2",1);
			dao.setProcInValue(nprocIndex, "strId",       	vo.getStrSupplierId(),2);   // Pass Supplier Id Here
			dao.setProcInValue(nprocIndex, "invoiceno", 	"0",3);
			dao.setProcInValue(nprocIndex, "hosp_code",  	vo.getStrHospitalCode(),4);
			dao.setProcInValue(nprocIndex, "poNo",        	vo.getStrPONo(),5);
			dao.setProcInValue(nprocIndex, "poStoreId",   	vo.getStrPOStoreId(),6);	
			dao.setProcInValue(nprocIndex, "invoicetype",   vo.getStrBillType(),7);		
			dao.setProcInValue(nprocIndex, "fromdate",   	"0",8);	
			dao.setProcInValue(nprocIndex, "todate",   		"0",9);
			dao.setProcOutValue(nprocIndex, "err",         1,10);
			dao.setProcOutValue(nprocIndex, "resultset",   2,11);
			
			dao.executeProcedureByPosition(nprocIndex);
			
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) 
			{
				ws = dao.getWebRowSet(nprocIndex, "resultset");		
				vo.setWsPaymentDtls(ws);							
			} 
			else 
			{
				throw new Exception(strerr);
			}	

		} catch (Exception e) {
			vo.setStrMsgString("BillApprovalTransDAO.getPaymentDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getSuppInvoice_EnteredPayment_Details(BillApprovalTransVO vo) 
	{
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet ws = null;
		try 
		{
			dao = new HisDAO("mms", "ChallanProcessTransDAO");			
			System.out.println("---------- BillApprovalTransDAO . getSUPP_PaymentDetails ------------");
			System.out.println("---------- PKG_MMS_VIEW.proc_hstt_invoice_payment_dtl --[ Mode - 4 ]----------");
			
			strproc_name = "{call PKG_MMS_VIEW.proc_hstt_invoice_payment_dtl(?,?,?,?,?   ,?,?,?,?,? , ?)}";
			nprocIndex = dao.setProcedure(strproc_name);			
			
			dao.setProcInValue(nprocIndex, "modval",      	"4",1);
			dao.setProcInValue(nprocIndex, "strId",       	vo.getStrSupplierId(),2);   // Pass Supplier Id Here
			dao.setProcInValue(nprocIndex, "invoiceno", 	"0",3);
			dao.setProcInValue(nprocIndex, "hosp_code",  	vo.getStrHospitalCode(),4);
			dao.setProcInValue(nprocIndex, "poNo",        	vo.getStrPONo(),5);
			dao.setProcInValue(nprocIndex, "poStoreId",   	vo.getStrPOStoreId(),6);	
			dao.setProcInValue(nprocIndex, "invoicetype",   vo.getStrBillType(),7);		
			dao.setProcInValue(nprocIndex, "fromdate",   	"0",8);	
			dao.setProcInValue(nprocIndex, "todate",   		"0",9);
			dao.setProcOutValue(nprocIndex, "err",         1,10);
			dao.setProcOutValue(nprocIndex, "resultset",   2,11);
			
			dao.executeProcedureByPosition(nprocIndex);
			
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) 
			{
				ws = dao.getWebRowSet(nprocIndex, "resultset");		
				vo.setWsRegisterPaymentDtls(ws);							
			} 
			else 
			{
				throw new Exception(strerr);
			}	

		} catch (Exception e) {
			vo.setStrMsgString("BillApprovalTransDAO.getPaymentDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getSUPP_InvoiceCombo(BillApprovalTransVO vo) 
	{
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet ws = null;
		try 
		{
			dao = new HisDAO("mms", "ChallanProcessTransDAO");			
			System.out.println("---------- BillApprovalTransDAO . getSUPP_InvoiceCombo ------------");
			System.out.println("---------- PKG_MMS_VIEW.proc_hstt_invoice_payment_dtl --[ Mode - 3 ]----------");
			
			strproc_name = "{call PKG_MMS_VIEW.proc_hstt_invoice_payment_dtl(?,?,?,?,?   ,?,?,?,?,? , ?)}";
			nprocIndex = dao.setProcedure(strproc_name);			
			
			dao.setProcInValue(nprocIndex, "modval",      	"3",1);
			dao.setProcInValue(nprocIndex, "strId",       	vo.getStrSupplierId(),2);   // Pass Supplier Id Here
			dao.setProcInValue(nprocIndex, "invoiceno", 	"0",3);
			dao.setProcInValue(nprocIndex, "hosp_code",  	vo.getStrHospitalCode(),4);
			dao.setProcInValue(nprocIndex, "poNo",        	vo.getStrPONo(),5);
			dao.setProcInValue(nprocIndex, "poStoreId",   	vo.getStrPOStoreId(),6);	
			dao.setProcInValue(nprocIndex, "invoicetype",   vo.getStrBillType(),7);		
			dao.setProcInValue(nprocIndex, "fromdate",   	"0",8);	
			dao.setProcInValue(nprocIndex, "todate",   		"0",9);
			dao.setProcOutValue(nprocIndex, "err",         1,10);
			dao.setProcOutValue(nprocIndex, "resultset",   2,11);
			
			dao.executeProcedureByPosition(nprocIndex);
			
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) 
			{
				ws = dao.getWebRowSet(nprocIndex, "resultset");		
				vo.setWsInvoiceComboDtls(ws);							
			} 
			else 
			{
				throw new Exception(strerr);
			}	

		} catch (Exception e) {
			vo.setStrMsgString("BillApprovalTransDAO.getPaymentDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	/**
	 * This method is used to call the procedure and set the values
	 * corresponding to it for populating the 
	 * GROUP LIST
	 */
	public static void getPOScheduleItemDetails(BillApprovalTransVO voObj) {

			HisDAO daoObj = null;
			WebRowSet ws = null;

			String strProcName = "{call Pkg_Mms_View.Proc_Po_Detail_Info(?,?,?,?,?,?,?,?,?,?)}";
			int nProcIndex = 0;
		
			String strErr = "";

			try {
				
				System.out.println(" --------------- BillApprovalTransDAO.getPOScheduleItemDetails ----------------- ");
				
				System.out.println(" --------------- Pkg_Mms_View.Proc_Po_Detail_Info --[ Mode - 9 ]--------------- ");
				
				daoObj = new HisDAO("MMS Transactions","BillApprovalTransDAO");

				nProcIndex = daoObj.setProcedure(strProcName);

				daoObj.setProcInValue(nProcIndex, "modval", "9",1); //changed from mode 7 to mode 9
				daoObj.setProcInValue(nProcIndex, "item_category", "1",2);
				daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
				daoObj.setProcInValue(nProcIndex, "store_Id", voObj.getStrPOStoreId(),4);
				daoObj.setProcInValue(nProcIndex, "poNo", voObj.getStrPONo(),5);
				daoObj.setProcInValue(nProcIndex, "po_frmdate", "0",6);
				daoObj.setProcInValue(nProcIndex, "po_todate", "0",7);
				daoObj.setProcInValue(nProcIndex, "schedule_no", voObj.getStrScheduleNo(),8);
				
				/* Start */
				
				/* End */
				
				daoObj.setProcOutValue(nProcIndex, "err", 1,9);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,10);

				daoObj.executeProcedureByPosition(nProcIndex);
				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				if (strErr.equals("")) {

					ws = daoObj.getWebRowSet(nProcIndex, "resultset");
					voObj.setStrScheduleItemDtlsWS(ws);
				} else {
					throw new Exception(strErr);
				}

			} catch (Exception e) {
				voObj
						.setStrMsgString("BillApprovalTransDAO.getPODetails() --> "
								+ e.getMessage());
				voObj.setStrMsgType("1");

			} finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
		}
	
	public static void getPODetailsSearchList(BillApprovalTransVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Po_Detail_Info(?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try 
		{

			/* 
			 *  hstt_invoicetype_mst			
			 *  
			 * 10 - Bulk PO
			 * 11 - Local PO
			 * 12 - Supplier Receipt
			 * 
			 * */
			
			System.out.println(" --------------- BillApprovalTransDAO.getPODetailsSearchList ----------------- ");
			
			System.out.println(" --------------- Pkg_Mms_View.Proc_Po_Detail_Info --[ Mode - "+voObj.getStrProcMode()+" ]--[4,  10 - Bulk PO--- 10, 11 - Local PO-- 12 , 12 - Supplier Receipt ]----------- ");
			
			daoObj = new HisDAO("MMS","BillApprovalTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modval", 		voObj.getStrProcMode(),1);
			daoObj.setProcInValue(nProcIndex, "item_category", 	"1",2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", 		voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "store_Id", 		voObj.getStrStoreId(),4);
			daoObj.setProcInValue(nProcIndex, "poNo", 			voObj.getStrPONo(),5);
			daoObj.setProcInValue(nProcIndex, "po_frmdate", 	"0",6);
			daoObj.setProcInValue(nProcIndex, "po_todate", 		"0",7);
			daoObj.setProcInValue(nProcIndex, "schedule_no", 	voObj.getStrSupplierId().split("\\^")[0],8);  // Pass Supplier Id 
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
			}
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			voObj.setStrMsgString("BillApprovalTransDAO.getPODetails() --> "+ e.getMessage());
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
	
	public static void insert(BillApprovalTransVO vo)
	{
		
		
		
		String err="";
        int funcIndex = 0;
		
		String strInvoiceNo = "";
		int nProcIndex = 0;
		HisDAO daoObj=null;
		String strFileName="",amtAfterWavier="0";
		

		try
		{
			
			System.out.println(" --------------- BillApprovalTransDAO.insert ----------------- ");
			
			
			
			
			 daoObj=new HisDAO("Bill Approval","BillApprovalTransDAO");
			 
			 System.out.println(" --------------- MMS_MST.generate_invoice_no --[ 70 ]--------------- ");
			 funcIndex = daoObj.setFunction("{? = call MMS_MST.generate_invoice_no(?,?,?,?)}");
				// Set Value
			 daoObj.setFuncInValue(funcIndex,2,vo.getStrHospitalCode());
			 daoObj.setFuncInValue(funcIndex,3,vo.getStrStoreId());
			 daoObj.setFuncInValue(funcIndex,4,"70");//Bill Verifivation
			 daoObj.setFuncInValue(funcIndex,5,vo.getStrItemCategoryNoH());
			 daoObj.setFuncOutValue(funcIndex,3);
			 daoObj.executeFuncForNumeric(funcIndex);
			
			 strInvoiceNo = daoObj.getFuncNumeric(funcIndex);
			 
			 System.out.println(" -------------------------------- ");
			 
		    for(int i =0 ; i< vo.getStrMultiInvoiceNo().length;i++)
		    {
		    	System.out.println("-Inv_no-"+vo.getStrMultiInvoiceNo()[i]+"-Date--"+vo.getStrMultiInvoiceDate()[i]+"-Tax--"+vo.getStrMultiInvoiceTax()[i]+"-Disc--"+vo.getStrMultiInvoiceDisc()[i]+"--Val-"+vo.getStrMultiInvoiceValue()[i]+"-Amount--"+vo.getStrMultiInvoiceAmount()[i]);
		    }	
				 
			System.out.println(" -------------------------------- ");
					 
					 
			 System.out.println(" --------------- Pkg_Mms_Dml.DML_HSTT_INVOICE_DTL [ Mode - 1 ]--------------- ");
			 
			 String strProcName1 = "{call Pkg_Mms_Dml.DML_HSTT_INVOICE_DTL(?,?,?,?,?   ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?   ,?,?,?,?,?,  ?,?,?,?,?)}";
			 strFileName=vo.getStrStoreId()+"_"+strInvoiceNo+"_"+vo.getStrHospitalCode()/*+"_"+vo.getStrCurrentDateTime()*/+"."+vo.getStrFileExt();
			 vo.setStrFileName(strFileName);
			 //System.out.println("strFileName:::"+strFileName);
			 
			 System.out.println("----------------------------------------");
			 System.out.println("getStrStoreId----"+vo.getStrStoreId());
			 System.out.println("getStrPONo----"+vo.getStrPONo());
			 System.out.println("strInvoiceNo----"+strInvoiceNo);
			 System.out.println("getStrHospitalCode----"+vo.getStrHospitalCode());
			 System.out.println("getStrBillType----"+vo.getStrBillType());
			 System.out.println("getStrSupplierId----"+vo.getStrSupplierId());
			 System.out.println("getStrPOStoreId----"+vo.getStrPOStoreId());
			 System.out.println("getStrBillNo----"+vo.getStrBillNo());
			 System.out.println("getStrBillDate----"+vo.getStrBillDate());
			 System.out.println("getStrPODate----"+vo.getStrPODate());
			 System.out.println("getStrCurrencyId----"+vo.getStrCurrencyId());
			 System.out.println("getStrBillAmount----"+vo.getStrBillAmount());
			 System.out.println("getStrBalanceAdvance----"+vo.getStrBalanceAdvance());
			 System.out.println("getStrAdvanceAdjusted----"+vo.getStrAdvanceAdjusted());
			 System.out.println("getStrNetPenalty----"+vo.getStrNetPenalty());
			 System.out.println("getStrWaiveOffAmt----"+vo.getStrWaiveOffAmt());
			 System.out.println("getStrWaiveOffApprovedBy----"+vo.getStrWaiveOffApprovedBy());
			 System.out.println("getStrWaiveOffApprovedDate----"+vo.getStrWaiveOffApprovedDate());
			 System.out.println("getStrFinancialStartYear----"+vo.getStrFinancialStartYear());
			 System.out.println("getStrFinancialEndYear----"+vo.getStrFinancialEndYear());
			 System.out.println("getStrRemarks----"+vo.getStrRemarks());
			 System.out.println("getStrItemCategoryNoH----"+vo.getStrItemCategoryNoH());
			 System.out.println("getStrNetItemCost----"+vo.getStrNetItemCost());			 
			 System.out.println("strUTRNo----"+vo.getStrUTRNo());
			 System.out.println("getStrPaymentDate----"+vo.getStrPaymentDate());
			 System.out.println("strPaymentStatus----"+vo.getStrPaymentStatus());
			 System.out.println("getStrPONetCost----"+vo.getStrPONetCost());
			 System.out.println("getStrSupplyNetCost----"+vo.getStrSupplyNetCost());			 
			 System.out.println("----------------------------------------");
			 
			 nProcIndex = daoObj.setProcedure(strProcName1);
			 daoObj.setProcInValue(nProcIndex, "modeval", 				"1",1);
		     daoObj.setProcInValue(nProcIndex, "storeId", 				vo.getStrStoreId(),2);
			 daoObj.setProcInValue(nProcIndex, "po_no", 				vo.getStrPONo(),3);
			 daoObj.setProcInValue(nProcIndex, "invoice_no", 			strInvoiceNo,4);
			 daoObj.setProcInValue(nProcIndex, "hosp_code", 			vo.getStrHospitalCode(),5);
			 daoObj.setProcInValue(nProcIndex, "invoice_typeId", 		vo.getStrBillType(),6);
			 daoObj.setProcInValue(nProcIndex, "invoice_date", 			"",7);
			 daoObj.setProcInValue(nProcIndex, "supplierId", 			vo.getStrSupplierId(),8);
			 daoObj.setProcInValue(nProcIndex, "po_storeId",			vo.getStrPOStoreId(),9);
			 daoObj.setProcInValue(nProcIndex, "supp_invoice_no", 		vo.getStrBillNo(),10);
			 daoObj.setProcInValue(nProcIndex, "supp_invoice_date", 	vo.getStrBillDate(),11);
			 daoObj.setProcInValue(nProcIndex, "po_date", 				vo.getStrPODate(),12);
			 daoObj.setProcInValue(nProcIndex, "currencyId", 			vo.getStrCurrencyId(),13);
			 daoObj.setProcInValue(nProcIndex, "supp_invoice_amt", 		vo.getStrBillAmount(),14);			 
			 daoObj.setProcInValue(nProcIndex, "advance_amt",			vo.getStrBalanceAdvance(),15);
			 daoObj.setProcInValue(nProcIndex, "adjusted_advance_amt", 	vo.getStrAdvanceAdjusted(),16);
			 daoObj.setProcInValue(nProcIndex, "penalty_amt",			vo.getStrNetPenalty(),17);
			 daoObj.setProcInValue(nProcIndex, "penalty_waive_amt", 	vo.getStrWaiveOffAmt(),18);			
			 daoObj.setProcInValue(nProcIndex, "waivepenelty_app_by",	vo.getStrWaiveOffApprovedBy(),19);
			 daoObj.setProcInValue(nProcIndex, "waivepenelty_app_date",	vo.getStrWaiveOffApprovedDate(),20);		   
			 daoObj.setProcInValue(nProcIndex, "financial_start_date",  vo.getStrFinancialStartYear(),21);
			 daoObj.setProcInValue(nProcIndex, "financial_end_date",    vo.getStrFinancialEndYear(),22);
			 daoObj.setProcInValue(nProcIndex, "remarks", 			    vo.getStrRemarks(),23);
			 daoObj.setProcInValue(nProcIndex, "seatId", 			    vo.getStrSeatId(),24);
			 daoObj.setProcInValue(nProcIndex, "item_cat_no",		    vo.getStrItemCategoryNoH(),25);
			 daoObj.setProcInValue(nProcIndex, "overall_tax",           vo.getStrOverallPOTax(),26);
			 if(vo.getStrWaiveOffAmt().length()>0 || vo.getStrWaiveOffAmt()!=null)
			 {
				 amtAfterWavier = String.valueOf((Double.parseDouble(vo.getStrBillAmount()) -Double.parseDouble(vo.getStrWaiveOffAmt())));
				 daoObj.setProcInValue(nProcIndex, "calculated_cost",   amtAfterWavier,27);
			 }
			 else
			 {
				 amtAfterWavier = String.valueOf(Double.parseDouble(vo.getStrBillAmount()));
				 daoObj.setProcInValue(nProcIndex, "calculated_cost",   amtAfterWavier,27);
			 }
			 daoObj.setProcInValue(nProcIndex, "payemnt_status",        vo.getStrPaymentStatus(),28);
			 daoObj.setProcInValue(nProcIndex, "utr_no",                vo.getStrUTRNo(),29);
			 daoObj.setProcInValue(nProcIndex, "po_amt",                vo.getStrPONetCost(),30);
			 daoObj.setProcInValue(nProcIndex, "supp_amt",              vo.getStrSupplyNetCost(),31);
			 daoObj.setProcInValue(nProcIndex, "p_key",                 "0",32);
			 daoObj.setProcInValue(nProcIndex, "serial_no",             "1",33);
			 daoObj.setProcInValue(nProcIndex, "inv_tax_amt",           vo.getStrMultiInvoiceTax()[0],34);
			 
			 daoObj.setProcOutValue(nProcIndex,"err",1,35); 
			 
			 daoObj.execute(nProcIndex,1);
			
			 
			
			daoObj.fire();
			
			System.out.println(" --------------- BillApprovalTransDAO.insert ------ END ----------- ");
			
			
			if(err.equals(""))
			{
				vo.setStrMsgType("0");
			}
			else
			{
				throw new Exception(err);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("BillApprovalTransDAO.insert() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void insert_new(BillApprovalTransVO vo)
	{
		
		
		
		String err="";
        int funcIndex = 0,j=1,k=1;
		
		String strInvoiceNo = "",strPaymentNo;
		int nProcIndex = 0,nProcIndex2=0;
		HisDAO daoObj=null;
		String strFileName="",amtAfterWavier="0";
		

		try
		{
			
			System.out.println(" --------------- BillApprovalTransDAO.insert_new ----------------- ");
			
				
			
			
				 daoObj=new HisDAO("Bill Approval","BillApprovalTransDAO");
				 
				 System.out.println(" --------------- MMS_MST.generate_invoice_no --[ 70 ]--------------- ");
				 /*
				 funcIndex = daoObj.setFunction("{? = call MMS_MST.generate_invoice_no_new(?)}");
				 
				 System.out.println(" getStrHospitalCode--------- "+vo.getStrHospitalCode());
				 System.out.println(" getStrStoreId--------- "+vo.getStrStoreId());
				 System.out.println(" getStrItemCategoryNoH--------- "+vo.getStrItemCategoryNoH());
					// Set Value
				 daoObj.setFuncInValue(funcIndex,2,vo.getStrHospitalCode());				
				 daoObj.setFuncOutValue(funcIndex,3);
				 daoObj.executeFuncForNumeric(funcIndex);
				 */
				 if( vo.getStrMultiInvoiceNo() != null && !"".equals(vo.getStrMultiInvoiceNo()) )					
				 {
					 String strFuncName = "{? = call MMS_MST.generate_invoice_no_new(?::numeric,?::numeric)}";
					 funcIndex = daoObj.setFunction(strFuncName);
					 daoObj.setFuncInValue(funcIndex, 2, "1");
					 daoObj.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
					 daoObj.setFuncOutValue(funcIndex, 1);
					 daoObj.executeFunction(funcIndex);
					 strInvoiceNo = daoObj.getFuncString(funcIndex);
				 }
				 
				 System.out.println(" ---------Length------ "+vo.getStrMultiInvoiceNo());
				if( vo.getStrMultiInvoiceNo() != null && !"".equals(vo.getStrMultiInvoiceNo()) )
				//if(vo.getStrMultiInvoiceNo().length >0 && vo.getStrMultiInvoiceNo()!=null)
				{ 
					System.out.println(" -------------------------------- ");
					 
				    for(int i =0 ; i< vo.getStrMultiInvoiceNo().length;i++)
				    {
				    	System.out.println("-Inv_no-"+vo.getStrMultiInvoiceNo()[i]
				    			+"-Date--"+vo.getStrMultiInvoiceDate()[i]
				    					+"-Tax--"+vo.getStrMultiInvoiceTax()[i]
				    							+"-Disc--"+vo.getStrMultiInvoiceDisc()[i]
				    									+"--Val-"+vo.getStrMultiInvoiceValue()[i]
				    											+"-Amount--"+vo.getStrMultiInvoiceAmount()[i]);
				    }	
				    System.out.println(" Inv No--------- "+strInvoiceNo);
				    System.out.println(" InvTotal Amount--------- "+vo.getStrInvoiceNetValue());				 
					System.out.println(" -------------------------------- "); 
							 
					 System.out.println(" --------------- Pkg_Mms_Dml.DML_HSTT_INVOICE_DTL [ Mode - 3 ]--------------- ");		
					 
					 String strProcName1 = "{call Pkg_Mms_Dml.DML_HSTT_INVOICE_DTL(?,?,?,?,?   ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?   ,?,?,?,?,?,  ?,?,?,?,?)}";
					 for(int i =0 ; i< vo.getStrMultiInvoiceNo().length;i++)
					 {
						 
						 System.out.println("----------------------------------------");
						 System.out.println("getStrStoreId----"+vo.getStrStoreId());
						 System.out.println("getStrPONo----"+vo.getStrPONo());
						 System.out.println("strInvoiceNo----"+strInvoiceNo);
						 System.out.println("getStrHospitalCode----"+vo.getStrHospitalCode());
						 System.out.println("getStrBillType----"+vo.getStrBillType());
						 System.out.println("getStrSupplierId----"+vo.getStrSupplierId());
						 System.out.println("getStrPOStoreId----"+vo.getStrPOStoreId());
						 System.out.println("getStrBillNo----"+vo.getStrMultiInvoiceNo()[i]);
						 System.out.println("getStrBillDate----"+vo.getStrBillDate());
						 System.out.println("getStrPODate----"+vo.getStrPODate());
						 System.out.println("getStrCurrencyId----"+vo.getStrCurrencyId());
						 System.out.println("getStrBillAmount----"+vo.getStrBillAmount());
						 System.out.println("getStrBalanceAdvance----"+vo.getStrBalanceAdvance());
						 System.out.println("getStrAdvanceAdjusted----"+vo.getStrAdvanceAdjusted());
						 System.out.println("getStrNetPenalty----"+vo.getStrNetPenalty());
						 System.out.println("getStrWaiveOffAmt----"+vo.getStrWaiveOffAmt());
						 System.out.println("getStrWaiveOffApprovedBy----"+vo.getStrWaiveOffApprovedBy());
						 System.out.println("getStrWaiveOffApprovedDate----"+vo.getStrWaiveOffApprovedDate());
						 System.out.println("getStrFinancialStartYear----"+vo.getStrFinancialStartYear());
						 System.out.println("getStrFinancialEndYear----"+vo.getStrFinancialEndYear());
						 System.out.println("getStrRemarks----"+vo.getStrRemarks());
						 System.out.println("getStrItemCategoryNoH----"+vo.getStrItemCategoryNoH());
						 System.out.println("getStrNetItemCost----"+vo.getStrNetItemCost());			 
						 System.out.println("strUTRNo----"+vo.getStrUTRNo());
						 System.out.println("getStrPaymentDate----"+vo.getStrPaymentDate());
						 System.out.println("strPaymentStatus----"+vo.getStrPaymentStatus());
						 System.out.println("getStrPONetCost----"+vo.getStrPONetCost());
						 System.out.println("getStrSupplyNetCost----"+vo.getStrSupplyNetCost());			 
						 System.out.println("----------------------------------------");
						 
						 System.out.println("-Inv_no-"+vo.getStrMultiInvoiceNo()[i]
					    			+"-Date--"+vo.getStrMultiInvoiceDate()[i]
					    					+"-Tax--"+vo.getStrMultiInvoiceTax()[i]
					    							+"-Disc--"+vo.getStrMultiInvoiceDisc()[i]
					    									+"--Val-"+vo.getStrMultiInvoiceValue()[i]
					    											+"-Amount--"+vo.getStrMultiInvoiceAmount()[i]);
					  
					    System.out.println(" Inv No--------- "+strInvoiceNo);
					    System.out.println(" InvTotal Amount--------- "+vo.getStrInvoiceNetValue());	
					    System.out.println(" getStrConcatPKey--------- "+vo.getStrConcatPKey());
					    
					    /* 
						 *  hstt_invoicetype_mst	
						 * 10 - Bulk PO
						 * 11 - Local PO
						 * 12 - Supplier Receipt
						 * */					 
						 nProcIndex = daoObj.setProcedure(strProcName1);
						 daoObj.setProcInValue(nProcIndex, "modeval", 				"3",1);
					     daoObj.setProcInValue(nProcIndex, "storeId", 				vo.getStrStoreId(),2);				     
						 daoObj.setProcInValue(nProcIndex, "po_no", 				vo.getStrPONo(),3);				     
						 daoObj.setProcInValue(nProcIndex, "invoice_no", 			strInvoiceNo,4);
						 daoObj.setProcInValue(nProcIndex, "hosp_code", 			vo.getStrHospitalCode(),5);
						 daoObj.setProcInValue(nProcIndex, "invoice_typeId", 		vo.getStrBillType(),6);
						 daoObj.setProcInValue(nProcIndex, "invoice_date", 			vo.getStrMultiInvoiceDate()[i],7);
						 daoObj.setProcInValue(nProcIndex, "supplierId", 			vo.getStrSupplierId(),8);
						 daoObj.setProcInValue(nProcIndex, "po_storeId",			vo.getStrPOStoreId(),9);
						 daoObj.setProcInValue(nProcIndex, "supp_invoice_no", 		vo.getStrMultiInvoiceNo()[i],10);
						 daoObj.setProcInValue(nProcIndex, "supp_invoice_date", 	vo.getStrMultiInvoiceDate()[i],11);
						 daoObj.setProcInValue(nProcIndex, "po_date", 				vo.getStrPODate(),12);
						 daoObj.setProcInValue(nProcIndex, "currencyId", 			vo.getStrCurrencyId(),13);
						 daoObj.setProcInValue(nProcIndex, "supp_invoice_amt", 		vo.getStrMultiInvoiceAmount()[i],14);			 
						 daoObj.setProcInValue(nProcIndex, "advance_amt",			vo.getStrBalanceAdvance(),15);
						 daoObj.setProcInValue(nProcIndex, "adjusted_advance_amt", 	vo.getStrAdvanceAdjusted(),16);
						 daoObj.setProcInValue(nProcIndex, "penalty_amt",			vo.getStrNetPenalty(),17);
						 daoObj.setProcInValue(nProcIndex, "penalty_waive_amt", 	vo.getStrMultiInvoiceDisc()[i],18);			
						 daoObj.setProcInValue(nProcIndex, "waivepenelty_app_by",	vo.getStrWaiveOffApprovedBy(),19);
						 daoObj.setProcInValue(nProcIndex, "waivepenelty_app_date",	vo.getStrWaiveOffApprovedDate(),20);		   
						 daoObj.setProcInValue(nProcIndex, "financial_start_date",  vo.getStrFinancialStartYear(),21);
						 daoObj.setProcInValue(nProcIndex, "financial_end_date",    vo.getStrFinancialEndYear(),22);
						 daoObj.setProcInValue(nProcIndex, "remarks", 			    vo.getStrRemarks(),23);
						 daoObj.setProcInValue(nProcIndex, "seatId", 			    vo.getStrSeatId(),24);
						 daoObj.setProcInValue(nProcIndex, "item_cat_no",		    vo.getStrItemCategoryNoH(),25);
						 daoObj.setProcInValue(nProcIndex, "overall_tax",           vo.getStrOverallPOTax(),26);					
						 daoObj.setProcInValue(nProcIndex, "calculated_cost",       vo.getStrInvoiceNetValue(),27);					
						 daoObj.setProcInValue(nProcIndex, "payemnt_status",        vo.getStrPaymentStatus(),28);
						 daoObj.setProcInValue(nProcIndex, "utr_no",                vo.getStrUTRNo(),29);
						 daoObj.setProcInValue(nProcIndex, "po_amt",                vo.getStrPONetCost(),30);
						 daoObj.setProcInValue(nProcIndex, "supp_amt",              vo.getStrPONetCost(),31);
						 daoObj.setProcInValue(nProcIndex, "p_key",                 vo.getStrConcatPKey(),32);
						 daoObj.setProcInValue(nProcIndex, "serial_no",             String.valueOf(j),33);
						 daoObj.setProcInValue(nProcIndex, "inv_tax_amt",           vo.getStrMultiInvoiceTax()[i],34);
						 
						 daoObj.setProcOutValue(nProcIndex,"err",1,35); 
						 
						 daoObj.execute(nProcIndex,1);
						 
						 j++;
					 }		
				 }	 
				if(vo.getStrMultiPayInvoiceType() != null && !"".equals(vo.getStrMultiPayInvoiceType()) )				
				{ 
					
				 String strFuncName = "{? = call MMS_MST.generate_invoice_no_new(?::numeric,?::numeric)}";
				 funcIndex = daoObj.setFunction(strFuncName);
				 daoObj.setFuncInValue(funcIndex, 2, "2");
				 daoObj.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
				 daoObj.setFuncOutValue(funcIndex, 1);
				 daoObj.executeFunction(funcIndex);
				 strPaymentNo = daoObj.getFuncString(funcIndex);	
				 
				 
                 System.out.println(" --------------- Pkg_Mms_Dml.dml_hstt_invoice_payment_dtl [ Mode - 1 ]--------------- ");	
				 String strProcName2= "{call Pkg_Mms_Dml.dml_hstt_invoice_payment_dtl(?,?,?,?,?   ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?, ?)}"; // 21
				 for(int i =0 ; i< vo.getStrMultiPayInvoiceType().length;i++)
				 {
					 
										 
					 System.out.println("-Inv_no-"+vo.getStrMultiPayInvoiceNo()[i]
				    			+"-Type--"+vo.getStrMultiPayInvoiceType()[i]
				    					+"-Tax--"+vo.getStrMultiPayInvoiceTax()[i]
				    							+"-Disc--"+vo.getStrMultiPayInvoiceDisc()[i]
				    									+"--Val-"+vo.getStrMultiPayInvoiceValue()[i]);
				  
				    System.out.println(" Payment No--------- "+strPaymentNo);				   
				    System.out.println(" getStrConcatPKey--------- "+vo.getStrConcatPKey());				    
				    if(Double.parseDouble(vo.getStrMultiPayInvoiceValue()[i])>0)
				    {	
					    /* 
						 *  hstt_invoicetype_mst	
						 * 10 - Bulk PO
						 * 11 - Local PO
						 * 12 - Supplier Receipt
						 * */					 
						 nProcIndex2 = daoObj.setProcedure(strProcName2);
						 daoObj.setProcInValue(nProcIndex2, "modeval", 				"1",1);
						 daoObj.setProcInValue(nProcIndex2, "po_storeId",			vo.getStrPOStoreId(),2);
						 daoObj.setProcInValue(nProcIndex2, "invoice_no", 			vo.getStrMultiPayInvoiceNo()[i].split("\\^")[2],3);					 
						 daoObj.setProcInValue(nProcIndex2, "po_no", 				vo.getStrPONo(),4);		
						 daoObj.setProcInValue(nProcIndex2, "serial_no",             String.valueOf(k),5);					
						 daoObj.setProcInValue(nProcIndex2, "hosp_code", 			vo.getStrHospitalCode(),6);					 
						 daoObj.setProcInValue(nProcIndex2, "invoice_typeId", 		vo.getStrBillType(),7);
						 daoObj.setProcInValue(nProcIndex2, "supplierId", 			vo.getStrSupplierId(),8);
						 daoObj.setProcInValue(nProcIndex2, "supp_invoice_no", 		vo.getStrMultiPayInvoiceNo()[i].split("\\^")[0],9);
						 daoObj.setProcInValue(nProcIndex2, "supp_invoice_date", 	"",10);
						 daoObj.setProcInValue(nProcIndex2, "payemnt_status",       vo.getStrMultiPayInvoiceType()[i],11);
						 daoObj.setProcInValue(nProcIndex2, "supp_invoice_amt", 	vo.getStrMultiPayInvoiceNo()[i].split("\\^")[1],12);					 
						 daoObj.setProcInValue(nProcIndex2, "supp_pay_amt", 		vo.getStrMultiPayInvoiceAmount()[i],13);	
						 daoObj.setProcInValue(nProcIndex2, "supp_pay_tax_amt", 	vo.getStrMultiPayInvoiceTax()[i],14);	
						 daoObj.setProcInValue(nProcIndex2, "supp_pay_wavier_amt", 	vo.getStrMultiPayInvoiceDisc()[i],15);	
						 daoObj.setProcInValue(nProcIndex2, "supp_pay_actual_amt", 	vo.getStrMultiPayInvoiceValue()[i],16);
						 daoObj.setProcInValue(nProcIndex2, "remarks", 			    vo.getStrRemarks(),17);
						 daoObj.setProcInValue(nProcIndex2, "seatId", 			    vo.getStrSeatId(),18);					
						 daoObj.setProcInValue(nProcIndex2, "p_key",                vo.getStrConcatPKey(),19);
						 daoObj.setProcInValue(nProcIndex2, "payment_inv_no", 		strPaymentNo,20);		
						 daoObj.setProcOutValue(nProcIndex2,"err",                  1,21); 
						 
						 daoObj.execute(nProcIndex2,1);
						 
						 k++;
				    }
				 }
			   }
			 			
			  daoObj.fire();
			/*
				else
				{
					throw new Exception("No Invoice To Save !! ");
				}
			*/
			System.out.println(" --------------- BillApprovalTransDAO.insert ------ END ----------- ");
			
			
			if(err.equals(""))
			{
				vo.setStrMsgType("0");
			}
			else
			{
				throw new Exception(err);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("BillApprovalTransDAO.insert() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
}
