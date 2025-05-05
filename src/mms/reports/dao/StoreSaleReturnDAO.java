package mms.reports.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.reports.vo.StoreSaleReturnVO;

public class StoreSaleReturnDAO
{
	
	public static void getStoreList(StoreSaleReturnVO voObj) {

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
	
	public static void getReportViewDtl(StoreSaleReturnVO voObj)
	{
		
		String strProcName = "{call pkg_mms_view2.Store_Wise_Sale_Return_report(?,?,?,?,?   ,?,?)}";
		
		System.out.println(" ------- pkg_mms_view2.Store_Wise_Sale_Return_report  --[ Mode- 1 ]------ ");
		
//		System.out.println("----------getStrHospitalCode-----"+voObj.getStrHospitalCode());
//		System.out.println("----------getStrStoreId----------"+voObj.getStrStoreId());
//		System.out.println("----------getStrStartDate--------"+voObj.getStrStartDate());
//		System.out.println("----------getStrEndDate----------"+voObj.getStrEndDate());
		
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try 
		{
			daoObj = new HisDAO("DWH","StoreSaleReturnDAO");
			nProcIndex = daoObj.setProcedure(strProcName);	
			daoObj.setProcInValue(nProcIndex, "modeval",        "1",1);  	 
			daoObj.setProcInValue(nProcIndex, "hosp_code",  	voObj.getStrHospitalCode(),2);	    
			daoObj.setProcInValue(nProcIndex, "strid",     		voObj.getStrStoreId(),3);				
			daoObj.setProcInValue(nProcIndex, "frmdate",  		voObj.getStrStartDate(),4);  
			daoObj.setProcInValue(nProcIndex, "todate",    		voObj.getStrEndDate(),5);    
			daoObj.setProcOutValue(nProcIndex, "err",         	1,6); 	
			daoObj.setProcOutValue(nProcIndex, "resultset",   	2,7);		
			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				//System.out.println("Size---------"+ ws.size());
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
	
	/*
	public static void getYearWiseViewDtl(StoreSaleReturnVO voObj)
	{
		
		String strProcName = "{call pkg_mms_view2.Store_Wise_Sale_Return_report(?,?,?,?,?   ,?,?)}";
		
		System.out.println(" ------- pkg_mms_view2.Store_Wise_Sale_Return_report  --[ Mode- 1 ]------ ");

		
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try 
		{
			daoObj = new HisDAO("DWH","StoreSaleReturnDAO");
			nProcIndex = daoObj.setProcedure(strProcName);	
			daoObj.setProcInValue(nProcIndex, "modeval",        "2",1);  	 
			daoObj.setProcInValue(nProcIndex, "hosp_code",  	voObj.getStrHospitalCode(),2);	    
			daoObj.setProcInValue(nProcIndex, "strid",     		voObj.getStrStoreId(),3);				
			daoObj.setProcInValue(nProcIndex, "frmdate",  		voObj.getStrStartDate(),4);  
			daoObj.setProcInValue(nProcIndex, "todate",    		"0",5);    
			daoObj.setProcOutValue(nProcIndex, "err",         	1,6); 	
			daoObj.setProcOutValue(nProcIndex, "resultset",   	2,7);		
			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				System.out.println("Size---------"+ ws.size());
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
	*/
	
	public static void getYearWiseViewDtl(StoreSaleReturnVO voObj) {
	    String strProcName = "{call pkg_mms_view2.Store_Wise_Sale_Return_report(?,?,?,?,?   ,?,?)}";

	    int nProcIndex = 0;
	    String strErr = "";
	    WebRowSet ws = null;
	    HisDAO daoObj = null;

	    try {
	        daoObj = new HisDAO("DWH", "StoreSaleReturnDAO");
	        nProcIndex = daoObj.setProcedure(strProcName);

	        // Set parameters for the first procedure call (modeval = 2)
	        daoObj.setProcInValue(nProcIndex, "modeval", "2", 1);
	        daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 2);
	        daoObj.setProcInValue(nProcIndex, "strid", voObj.getStrStoreId(), 3);
	        daoObj.setProcInValue(nProcIndex, "frmdate", voObj.getStrStartDate(), 4);
	        daoObj.setProcInValue(nProcIndex, "todate", "0", 5);
	        daoObj.setProcOutValue(nProcIndex, "err", 1, 6);
	        daoObj.setProcOutValue(nProcIndex, "resultset", 2, 7);
	        daoObj.executeProcedureByPosition(nProcIndex);
	        strErr = daoObj.getString(nProcIndex, "err");

	        if (strErr == null)
	            strErr = "";

	        if (strErr.equals("")) {
	            ws = daoObj.getWebRowSet(nProcIndex, "resultset");
	            voObj.setWsBreakageDtlRpt(ws);
	            System.out.println("----voObj.setWsyearDtlRpt-----"+voObj.getWsBreakageDtlRpt());
	        } else {
	            throw new Exception(strErr);
	        }

	       
	        daoObj.setProcInValue(nProcIndex, "modeval", "3", 1);
	        daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 2);
	        daoObj.setProcInValue(nProcIndex, "strid", voObj.getStrStoreId(), 3);
	        daoObj.setProcInValue(nProcIndex, "frmdate", voObj.getStrStartDate(), 4);
	        daoObj.setProcInValue(nProcIndex, "todate", "0", 5);
	        daoObj.setProcOutValue(nProcIndex, "err", 1, 6);
	        daoObj.setProcOutValue(nProcIndex, "resultset", 2, 7);
	        daoObj.executeProcedureByPosition(nProcIndex);
	        strErr = daoObj.getString(nProcIndex, "err");

	        if (strErr == null)
	            strErr = "";

	        if (strErr.equals("")) {
	            ws = daoObj.getWebRowSet(nProcIndex, "resultset");
	            voObj.setWsyearDtlRpt(ws);
	            
	            System.out.println("----voObj.setWsyearDtlRpt-----"+voObj.getWsyearDtlRpt());
	            
	        } else {
	            throw new Exception(strErr);
	        }

	    } catch (Exception e) {
	        voObj.setStrMsgString("IssueTrackRptDAO.getViewDtl() --> " + e.getMessage());
	        voObj.setStrMsgType("1");

	    } finally {
	        if (daoObj != null) {
	            daoObj.free();
	        }
	    }
	}
	
	public static void getVoucherViewDtl(StoreSaleReturnVO voObj)
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
	
	public static void getImageHeader(StoreSaleReturnVO voObj)
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
			voObj.setStrMsgString("IssueTransDAO.getImageHeader() --> "+ e.getMessage());
			
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}
		}	
	}
	

	
}

