package mms.reports.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.reports.vo.IssueTrackRptVO;
import mms.transactions.vo.IssueDeskTransVO;

public class IssueTrackRptDAO
{
	
	public static void getStoreList(IssueTrackRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			
			System.out.println("---------IssueTrackRptDAO.getStoreList---------");

			daoObj = new HisDAO("DWH","IssueTrackRptDAO");
			//
			nProcIndex = daoObj.setProcedure(strProcName);

			
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
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
				System.out.println(" ----------Pkg_Mms_View.proc_hstt_store_mst || Size---------"+ ws.size());
				voObj.setStrStoreWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("IssueTrackRptDAO.getStoreList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getReportViewDtl(IssueTrackRptVO voObj)
	{
		
		String strProcName = "{call Pkg_Mms_RPT.rptm_issue_count_dtls(?,?,?,?,?   ,?,?,?)}";
		
		System.out.println(" ------- IssueTrackRptDAO .getReportViewDtl  -------- ");
		System.out.println(" ------- Pkg_Mms_RPT.rptm_issue_count_dtls  --[ Mode- 1 ]------ ");
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try 
		{
			daoObj = new HisDAO("DWH","IssueTrackRptDAO");
			nProcIndex = daoObj.setProcedure(strProcName);	
			
			daoObj.setProcInValue(nProcIndex, "p_mode",              "1",1);  	 
			daoObj.setProcInValue(nProcIndex, "p_gnum_hospital_code",  voObj.getStrHospitalCode(),2);	    
			daoObj.setProcInValue(nProcIndex, "p_hstnum_store_id",     voObj.getStrStoreId(),3);				
			
			daoObj.setProcInValue(nProcIndex, "p_from_date",  		voObj.getStrStartDate(),4);  
			daoObj.setProcInValue(nProcIndex, "p_to_date",    		voObj.getStrEndDate(),5);    
			daoObj.setProcInValue(nProcIndex, "p_hstnum_breakable_lost_flag",   "1",6);			 
			
			daoObj.setProcOutValue(nProcIndex, "err",         1,7); 	
			daoObj.setProcOutValue(nProcIndex, "resultset",   2,8);		

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				System.out.println(" ----------Pkg_Mms_RPT.rptm_issue_count_dtls || Size---------"+ ws.size());
				voObj.setWsBreakageDtlRpt(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("IssueTrackRptDAO.getViewDtl() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getVoucherViewDtl(IssueTrackRptVO voObj)
	{
		String strProcName = "{call pkg_mms_view2.proc_issue_track_rpt(?,?,?,?,?   ,?,?,?,?,?)}";
		
		System.out.println(" ------- IssueTrackRptDAO .getVoucherViewDtl  -------- ");
		System.out.println(" ------- pkg_mms_view2.proc_issue_track_rpt  --[ Mode- 1 ]------ ");
		
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try 
		{
			daoObj = new HisDAO("DWH","IssueTrackRptDAO");
			nProcIndex = daoObj.setProcedure(strProcName);	
			
			//daoObj.setProcInValue(nProcIndex, "modeval",              "2",1);  	
			daoObj.setProcInValue(nProcIndex, "modeval",   	voObj.getStrCmodeId(),1);  	 

			daoObj.setProcInValue(nProcIndex, "hosp_code",   voObj.getStrHospitalCode(),2);	
			daoObj.setProcInValue(nProcIndex, "storeid",     voObj.getStrStoreId(),3);		 // Issuing Store Id	
			daoObj.setProcInValue(nProcIndex, "tostoreid",   voObj.getStrReqStoreId(),4);	 // Indenting Store Id			
			daoObj.setProcInValue(nProcIndex, "issueno",     "",5);				
			daoObj.setProcInValue(nProcIndex, "itemid",     "",6);				
			daoObj.setProcInValue(nProcIndex, "frmdate",  	voObj.getStrStartDate(),7); 
			daoObj.setProcInValue(nProcIndex, "todate",    	voObj.getStrEndDate(),8);    
			daoObj.setProcOutValue(nProcIndex, "err",         1,9); 	
			daoObj.setProcOutValue(nProcIndex, "resultset",   2,10);	
			/*
			System.out.println("--------------------hosp_code--------------------" +voObj.getStrHospitalCode());
			System.out.println("--------------------storeid--------------------"  +voObj.getStrStoreId());
			System.out.println("--------------------frmdate--------------------"  +voObj.getStrStartDate());
			System.out.println("--------------------todate--------------------"  +voObj.getStrEndDate());
			*/

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				voObj.setStrIndentDetailsWs(ws);
				System.out.println(" ----------pkg_mms_view2.proc_issue_track_rpt || Size---------"+ ws.size());
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("IssueTrackRptDAO.getVoucherViewDtl() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getImageHeader(IssueTrackRptVO voObj)
	{
		String strFuncName = "";
		String strLogoName = "";
		
		int nFuncIndex = 0;
		HisDAO dao = null;
		try 
		{
			dao = new HisDAO("DWH","IssueTrackRptDAO");
			
			strFuncName = "{? = call MMS_MST.logo_config_dtl(?,?)}";
			nFuncIndex = dao.setFunction(strFuncName);
			
			dao.setFuncInValue(nFuncIndex, 2, voObj.getStrMode());
			dao.setFuncInValue(nFuncIndex, 3, voObj.getStrHospitalCode());
			dao.setFuncOutValue(nFuncIndex, 1);
			
			dao.executeFunction(nFuncIndex);
			
			strLogoName = dao.getFuncString(nFuncIndex);
			voObj.setStrLogoName(strLogoName);

		} catch (Exception e) {
			
			e.printStackTrace();
			voObj.setStrMsgType("1");
			voObj.setStrMsgString("IssueTrackRptDAO.getImageHeader() --> "+ e.getMessage());
			
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}
		}	
	}
	
	public static void getIssueDetail(IssueTrackRptVO vo) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view2.proc_issue_track_rpt(?,?,?,?,?   ,?,?,?,?,?)}";  //10

		int nProcIndex = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms","IssueTrackRptDAO.getIssueDetail(IssueTrackRptVO vo)");

			nProcIndex = dao.setProcedure(proc_name1);
			
			
			// cmode = 1 => receive  and cmode = 2 => issue 	
			// set value
			dao.setProcInValue(nProcIndex, "modeval",   	"16",1);  	 

			dao.setProcInValue(nProcIndex, "hosp_code",   vo.getStrHospitalCode(),2);	
			dao.setProcInValue(nProcIndex, "storeid",     vo.getStrStoreId(),3);		 // Issuing Store Id	
			dao.setProcInValue(nProcIndex, "tostoreid",   vo.getStrReqStoreId(),4);	 // Indenting Store Id			
			dao.setProcInValue(nProcIndex, "issueno",     vo.getStrIssueNo(),5);				
			dao.setProcInValue(nProcIndex, "itemid",     "",6);			
			dao.setProcInValue(nProcIndex, "frmdate",  	vo.getStrStartDate(),7); 
			dao.setProcInValue(nProcIndex, "todate",    	vo.getStrEndDate(),8);    
			dao.setProcOutValue(nProcIndex, "err",         1,9); 	
			dao.setProcOutValue(nProcIndex, "resultset",   2,10);
			
			// execute procedure

			dao.executeProcedureByPosition(nProcIndex);
			
			
			// get value
			err = dao.getString(nProcIndex, "err");

			if (err == null)
				err = "";

			/*if (err == null)
				err = "";*/

			if (err.equals("")) {

				ws = dao.getWebRowSet(nProcIndex, "resultset");
				System.out.println("ws.size()::"+ws.size());
                while(ws.next())
                {
                	vo.setStrRaisingStoreName(ws.getString(10));
                }
                ws.beforeFirst();
				vo.setItemDetailsWS(ws);
				
			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			vo.setStrMsgString("IssueDeskTransDAO.getIssueDetail() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
	public static void getIssueDtlForSubStore(IssueTrackRptVO vo) {
		
		String err = "";
		String proc_name1 = "{call pkg_mms_view2.proc_sub_store_issue_track_dtls(?,?,?,?,?   ,?,?,?,?,?  ,?)}";  //11

		int nProcIndex = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms","IssueTrackRptDAO.getIssueDtlForSubStore(IssueTrackRptVO vo)");

			nProcIndex = dao.setProcedure(proc_name1);
			
			
			// cmode = 1 => receive  and cmode = 2 => issue 
			
			// modeval =1 => Issue Detail mode
			
			
			dao.setProcInValue(nProcIndex, "modeval",   	"2",1);  	 

			dao.setProcInValue(nProcIndex, "hosp_code",   vo.getStrHospitalCode(),2);	
			dao.setProcInValue(nProcIndex, "strid",       vo.getStrReqStoreId(),3);		 
			dao.setProcInValue(nProcIndex, "catcode",     vo.getStrCategoryCode(),4);	
			dao.setProcInValue(nProcIndex, "itemId",      vo.getStrItemId(),5);
			dao.setProcInValue(nProcIndex, "brandId",     vo.getStrItemBrandId(),6); 
			dao.setProcInValue(nProcIndex, "batchNo",     vo.getStrBatchNo(),7); 
			dao.setProcInValue(nProcIndex, "frmdate",     vo.getStrStartDate(),8); 
			dao.setProcInValue(nProcIndex, "todate",      vo.getStrEndDate(),9); 
			dao.setProcOutValue(nProcIndex, "err",         1,10); 	
			dao.setProcOutValue(nProcIndex, "resultset",   2,11);
			
			// execute procedure

			dao.executeProcedureByPosition(nProcIndex);
			
			
			// get value
			err = dao.getString(nProcIndex, "err");

			if (err == null)
				err = "";


			if (err.equals("")) {

				ws = dao.getWebRowSet(nProcIndex, "resultset");
				System.out.println("ws.size()::"+ws.size());
				vo.setItemCurrStockWS(ws);
				
			} else {

				throw new Exception(err);
			}
			
			
			dao.setProcInValue(nProcIndex, "modeval",   	"1",1);  	 

			dao.setProcInValue(nProcIndex, "hosp_code",   vo.getStrHospitalCode(),2);	
			dao.setProcInValue(nProcIndex, "strid",       vo.getStrReqStoreId(),3);		 
			dao.setProcInValue(nProcIndex, "catcode",     vo.getStrCategoryCode(),4);	
			dao.setProcInValue(nProcIndex, "itemId",      vo.getStrItemId(),5);
			dao.setProcInValue(nProcIndex, "brandId",     vo.getStrItemBrandId(),6); 
			dao.setProcInValue(nProcIndex, "batchNo",     vo.getStrBatchNo(),7); 
			dao.setProcInValue(nProcIndex, "frmdate",     vo.getStrStartDate(),8); 
			dao.setProcInValue(nProcIndex, "todate",     vo.getStrEndDate(),9); 
			dao.setProcOutValue(nProcIndex, "err",         1,10); 	
			dao.setProcOutValue(nProcIndex, "resultset",   2,11);
			
			// execute procedure

			dao.executeProcedureByPosition(nProcIndex);
			
			
			// get value
			err = dao.getString(nProcIndex, "err");

			if (err == null)
				err = "";


			if (err.equals("")) {

				ws = dao.getWebRowSet(nProcIndex, "resultset");
				System.out.println("ws.size()::"+ws.size());
                while(ws.next())
                {
                	vo.setStrIssueStatus(ws.getString(12));
                }
                ws.beforeFirst();
				vo.setItemDetailsWS(ws);
				
			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			vo.setStrMsgString("IssueDeskTransDAO.getIssueDtlForSubStore() --> "
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

