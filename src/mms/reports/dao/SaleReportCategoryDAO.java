package mms.reports.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.reports.vo.SaleReportCategoryVO;

public class SaleReportCategoryDAO {

	public static void getStoreList(SaleReportCategoryVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.rptm_hstt_store_mst(?,?,?,?,?,?)}";
		int nprocIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "SaleReportCategoryDAO");
			String strproc_name = "{call pkg_mms_rpt.rptm_hstt_store_mst(?,?,?,?,?,?)}";
			nprocIndex = daoObj.setProcedure(strproc_name);

			daoObj.setProcInValue(nprocIndex, "modeval", voObj.getStrMode(), 1);
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

	public static void getItemCatList(SaleReportCategoryVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		int nprocIndex = 0;
		String strErr = "";

		try {
			daoObj = new HisDAO("mms", "SaleReportCategoryDAO");
			//String strProcName = "{call pkg_mms_rpt.Rptm_item_category_list(?,?,?,?,?)}";
			String strProcName = "{call pkg_simple_view.proc_gblt_patient_cat_mst_data(?,?,?,?,? ,?,?,?,?)}";

			
			nprocIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nprocIndex, "modeval", "1", 1);
			daoObj.setProcInValue(nprocIndex, "hosp_code", voObj.getStrHospitalCode(), 2);
			daoObj.setProcInValue(nprocIndex, "puk_no", "", 3);
			daoObj.setProcInValue(nprocIndex, "charge_type_id", "", 4);
			
			daoObj.setProcInValue(nprocIndex, "effect_from", voObj.getStrFinancialStartYear(), 5);
			daoObj.setProcInValue(nprocIndex, "effect_to", voObj.getStrFinancialEndYear(), 6);
	
			daoObj.setProcInValue(nprocIndex, "cat_code", "", 7);
			daoObj.setProcOutValue(nprocIndex, "err", 1, 8);
			daoObj.setProcOutValue(nprocIndex, "resultset", 2, 9);

			daoObj.executeProcedureByPosition(nprocIndex);
			strErr = daoObj.getString(nprocIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nprocIndex, "resultset");
				System.out.println("WS PAT CATEGORY"+ws.size());
				voObj.setStrItemCatWs(ws); 
				/*
				// Loop through the WebRowSet and print each row
				try {
				    while (ws.next()) {
						
				        // Assuming the first column is of type String, adjust based on your schema
				        System.out.println("Column 1: " + ws.getString(1));
				        System.out.println("Column 2: " + ws.getString(2));
				        System.out.println("Column 3: " + ws.getString(3));
				        System.out.println("Column 4: " + ws.getString(4));

				        // Add more columns if needed based on your result set
				    }
				} catch (SQLException e) {
				    e.printStackTrace();
				}
				*/
				

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("StockReceiptRegisterRptDAO.getItemCatList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void getImageHeader(SaleReportCategoryVO vo)
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

	public static void getReplacementDtl(SaleReportCategoryVO vo)
	{
		String strProcName = "{call pkg_mms_rpt.rptm_issue_to_patient_dtl(?,?,?,?,?, ?,?,?,?,?)}"; //10

		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj  = new HisDAO("MMS","SaleReportCategoryDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", 		"3",1);  			
			daoObj.setProcInValue(nProcIndex, "hosp_code", 		vo.getStrHospitalCode(),2);	    
			daoObj.setProcInValue(nProcIndex, "strid", 			vo.getStrStoreId(),3);			
			daoObj.setProcInValue(nProcIndex, "catcode", 	    "",4);      
			daoObj.setProcInValue(nProcIndex, "frmdate", 	    vo.getStrFinancialStartYear(),5);  
			daoObj.setProcInValue(nProcIndex, "todate", 		vo.getStrFinancialEndYear(),6);   
			daoObj.setProcInValue(nProcIndex, "gender", 		"",7);   
		   	System.out.println("patienttype--showReport_DAO "+vo.getStrPatientCategory());
		   	daoObj.setProcInValue(nProcIndex, "patienttype", vo.getStrPatientCategory().split("\\^")[0], 8);
			daoObj.setProcOutValue(nProcIndex, "err",			1,9); 												
			daoObj.setProcOutValue(nProcIndex, "resultset",		2,10);			
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("SIZE SALERPT WS"+ws.size());
			if(strErr.equals(""))
			{
				vo.setWsItemCategoryCombo(ws);
			}
		}
		catch(Exception _err)
		{
			vo.setStrMsgString("SaleReportCategoryDAO.getReplacementDtl() --> "	+ _err.getMessage());
			vo.setStrMsgType("1");
		}
		 finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
		}
	}
}
