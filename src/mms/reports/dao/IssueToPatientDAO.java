package mms.reports.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.reports.vo.IssueToPatientVO;

public class IssueToPatientDAO {

	public static void getStoreList(IssueToPatientVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.rptm_hstt_store_mst(?,?,?,?,?,?)}";
		int nprocIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "IssueToPatientDAO");
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

			voObj.setStrMsgString("IssueToPatientDAO.getStoreList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getItemCatList(IssueToPatientVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		int nprocIndex = 0;
		String strErr = "";

		try {
			daoObj = new HisDAO("mms", "PendingIndentStatusRecordRptDAO");
			String strProcName = "{call pkg_mms_rpt.Rptm_item_category_list(?,?,?,?,?)}";
			nprocIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nprocIndex, "modeval", voObj.getStrMode(), 1);
			daoObj.setProcInValue(nprocIndex, "hosp_code", voObj.getStrHospitalCode(), 2);
			daoObj.setProcInValue(nprocIndex, "storeId", voObj.getStrStoreId(), 3);
			daoObj.setProcOutValue(nprocIndex, "err", 1, 4);
			daoObj.setProcOutValue(nprocIndex, "resultset", 2, 5);

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

			voObj.setStrMsgString("StockReceiptRegisterRptDAO.getItemCatList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void getIReqTypeList(IssueToPatientVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		int nprocIndex = 0;
		String strErr = "";

		try {
			daoObj = new HisDAO("mms", "PendingIndentStatusRecordRptDAO");
			String strProcName = "{call pkg_mms_rpt.rptm_request_type_cmb(?,?,?,?,?,?)}";
			nprocIndex = daoObj.setProcedure(strProcName);
			// System.out.println("modeval"+voObj.getStrMode());
			daoObj.setProcInValue(nprocIndex, "modeval", "1", 1);
			daoObj.setProcInValue(nprocIndex, "hosp_code", voObj.getStrHospitalCode(), 2);
			daoObj.setProcInValue(nprocIndex, "catcode", voObj.getStrItemCatId(), 3);
			daoObj.setProcInValue(nprocIndex, "strid", voObj.getStrStoreId(), 4);
			daoObj.setProcOutValue(nprocIndex, "err", 1, 5);
			daoObj.setProcOutValue(nprocIndex, "resultset", 2, 6);

			daoObj.executeProcedureByPosition(nprocIndex);
			strErr = daoObj.getString(nprocIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nprocIndex, "resultset");
				// System.out.println("ws.size"+ws.size());
				voObj.setStrReqTypeWs(ws);

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

	public static void getImageHeader(IssueToPatientVO vo)
	{
		String strFuncName = "";
		String strLogoName = "";
		
		int nFuncIndex = 0;
		HisDAO dao = null;
		try 
		{
			dao = new HisDAO("DWH","IssueToPatientDAO");
			
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
			vo.setStrMsgString("IssueToPatientDAO.getImageHeader() --> "+ e.getMessage());
			
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}
		}	
	}

	public static void getReplacementDtl(IssueToPatientVO vo)
	{
		String strProcName = "{call pkg_mms_rpt.rptm_issue_to_patient_dtl(?,?,?,?,?, ?,?,?,?,?)}"; //10

		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj  = new HisDAO("MMS","IssueToPatientDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", 		"2",1);  			
			daoObj.setProcInValue(nProcIndex, "hosp_code", 		vo.getStrHospitalCode(),2);	    
			daoObj.setProcInValue(nProcIndex, "strid", 			vo.getStrStoreId(),3);			
			daoObj.setProcInValue(nProcIndex, "catcode", 	    vo.getStrItemCategoryId(),4);      
			daoObj.setProcInValue(nProcIndex, "frmdate", 	    vo.getStrFinancialStartYear(),5);  
			daoObj.setProcInValue(nProcIndex, "todate", 		vo.getStrFinancialEndYear(),6);   
			daoObj.setProcInValue(nProcIndex, "gender", 		vo.getStrPatientGenderCode(),7);   
			daoObj.setProcInValue(nProcIndex, "patienttype", 	vo.getStrPatientType(),8);   
			daoObj.setProcOutValue(nProcIndex, "err",			1,9); 												
			daoObj.setProcOutValue(nProcIndex, "resultset",		2,10);			
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			System.out.println("SIZE WS"+ws.size());
			if(strErr.equals(""))
			{
				vo.setWsItemCategoryCombo(ws);
			}
		}
		catch(Exception _err)
		{
			vo.setStrMsgString("IssueToPatientDAO.getReplacementDtl() --> "	+ _err.getMessage());
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
