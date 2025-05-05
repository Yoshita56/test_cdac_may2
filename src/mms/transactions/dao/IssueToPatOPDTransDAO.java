package mms.transactions.dao;

import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import billing.CashCollectionOfflineTransVO;
import hisglobal.transactionmgnt.HisDAO;
//import billing.transactions.LFNoTransVO;
import mms.MmsConfigUtil;
import mms.dao.DmlHsttPatEmpIssueDtlDAO;
import mms.dao.DmlHsttPatEmpIssueDtlWithoutCrNoDAO;
import mms.dao.DmlHsttPatEmpIssueItemDtlDAO;
import mms.dao.DmlHsttPatEmpIssueItemDtlWithoutCrNoDAO;
import mms.patDtl.GlobalVO;
import mms.transactions.controller.fb.IssueToPatOPDTransFB;
import mms.transactions.vo.IssueToPatOPDTransVO;

public class IssueToPatOPDTransDAO 
{
	public static void getIssueConfigFlag(IssueToPatOPDTransVO vo) 
	{
		// Declaring Variable
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		try {
			dao = new HisDAO("MMSModule", "IssueToPatOPDTransDAO");

			funcIndex = dao.setFunction("{? = call MMS_MST.config_dtl(?,?,?)}");

			System.out.println(
					" ------- IssueToPatOPDTransDAO .MMS_MST.config_dtl  --[ 0 - On-Line , 1 - Off-Line]------ ");

			// Set Value
			dao.setFuncInValue(funcIndex, 2, "1");
			dao.setFuncInValue(funcIndex, 3, "105");
			dao.setFuncInValue(funcIndex, 4, "ISSUE_OPD_OFFLINE");
			dao.setFuncOutValue(funcIndex, 1);
			// Execute Function
			dao.executeFunction(funcIndex);
			retVal = dao.getFuncString(funcIndex);
			if (retVal != null && retVal != "0") {
				vo.setStrOfflineOPDFlag(retVal);
			} else {
				vo.setStrOfflineOPDFlag(retVal);
			}

			System.out.println(" -----vo.getStrOfflineOPDFlag -------- " + vo.getStrOfflineOPDFlag());

		} catch (Exception e) {
			vo.setStrMsgString("IssueToPatOPDTransDAO.getIssueConfigFlag() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void getStoreList(IssueToPatOPDTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		try {
			System.out.println(" ------- IssueToPatOPDTransDAO .getStoreList  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_hstt_store_mst  --[ Mode- 12 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			//// System.out.println("In DAO==>"+nProcIndex);

			daoObj.setProcInValue(nProcIndex, "modeval", "12", 1);
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId(), 2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 3);

			/* Setting Default Value Start */
			daoObj.setProcInValue(nProcIndex, "storeid", "0", 4);
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0", 5);
			/* Setting Default Value End */

			daoObj.setProcOutValue(nProcIndex, "err", 1, 6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 7);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				voObj.setStrStoreWs(ws);
				System.out.println("getStoreList--voObj.setStrStoreWs(ws);--Size"+ws.size());
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("IssueToPatOPDTransDAO.getStoreList() --> " + e.getMessage());
			voObj.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getCRNO_PatientDtl(IssueToPatOPDTransVO  vo) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_simple_view.PROC_HRGT_PATIENT_DTL(?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";
		String strCrNum = vo.getStrCrNo();
		//System.out.println("strCrNum"+strCrNum);
		try 
		{
			daoObj = new HisDAO("Global Patient Details","PatientDtlDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			if (strCrNum != null && !strCrNum.equals("")) 
			{
				daoObj.setProcInValue(nProcIndex, "modeVal", 	"1",1);
				daoObj.setProcInValue(nProcIndex, "puk", 		strCrNum,2);
				daoObj.setProcOutValue(nProcIndex, "err", 		1,3);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,4);
				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				if (strErr.equals("")) 
				{
					vo.setGblWs1(ws);
				} 
				else 
				{
					throw new Exception(strErr);
				}
			}
		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("PatientDtlDAO.setPatientDtl() --> "+ e.getMessage());
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
	

	public static void getApprovedByCombo(IssueToPatOPDTransVO vo)

	{

		String strProcName = "{call PKG_MMS_VIEW.proc_store_emp_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		WebRowSet ws = null;
		HisDAO daoObj = null;
		try {
			daoObj = new HisDAO("MMSModule", "IssueDeskTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeVal", "1", 1);
			daoObj.setProcInValue(nProcIndex, "storeId", vo.getStrStoreId(), 2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(), 3);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 5);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setStrPrescFormValues(ws);
			}
		} catch (Exception _err) {
			vo.setStrMsgString("IssueDeskTransDAO.setApprovedByCombo() --> " + _err.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void getPatientCRStatus(IssueToPatOPDTransVO vo) {

		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		try {
			dao = new HisDAO("MMSModule", "IssueToPatOPDTransDAO");

			funcIndex = dao.setFunction("{? = call MMS_MST.get_crno_status_code(?,?)}");

			System.out.println(
					" ------- IssueToPatOPDTransDAO .MMS_MST.get_crno_status_code  --[ 2 - IPD Patient , 3- OPD Patinet]------ ");

			// Set Value
			dao.setFuncInValue(funcIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3, vo.getStrCrNo());
			dao.setFuncOutValue(funcIndex, 1);
			// Execute Function
			dao.executeFunction(funcIndex);

			retVal = dao.getFuncString(funcIndex);

			System.out.println(" ------- retVal  -------- " + retVal);
			if (retVal.equals("2")) {
				vo.setStrInvalidCrFlag("2");
			} else {
				vo.setStrInvalidCrFlag("0");
			}

			System.out.println(" -----vo.setStrInvalidCrFlag -------- " + vo.getStrInvalidCrFlag());

		} catch (Exception e) {
			vo.setStrMsgString("IssueToPatOPDTransDAO.getPatientAddmissionFlag() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void getPatientAddmissionFlag(IssueToPatOPDTransVO vo) {
		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		try {
			dao = new HisDAO("MMSModule", "IssueToPatOPDTransDAO");

			funcIndex = dao.setFunction("{? = call MMS_MST.get_patient_Admission_status(?,?,?)}");

			System.out.println(" ------- IssueToPatOPDTransDAO .MMS_MST.get_patient_Admission_status  -------- ");

			// Set Value
			dao.setFuncInValue(funcIndex, 2, "1");
			dao.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4, vo.getStrCrNo());
			dao.setFuncOutValue(funcIndex, 1);
			// Execute Function
			dao.executeFunction(funcIndex);
			retVal = dao.getFuncString(funcIndex);
			if (retVal != null && retVal != "0") {
				vo.setStrInvalidCrFlag("2");
			} else {
				vo.setStrInvalidCrFlag("0");
			}

			System.out.println(" -----vo.setStrInvalidCrFlag -------- " + vo.getStrInvalidCrFlag());

		} catch (Exception e) {
			vo.setStrMsgString("IssueToPatOPDTransDAO.getPatientAddmissionFlag() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * Gets the issue dtls list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the issue dtls list This Function is Used To Get Ajax Voucher Details
	 */// Modified by Neha Sharma on 16th July 2013 ..
	public static void getIssueDtlsList(IssueToPatOPDTransVO vo) {
		String err;
		// String strSlNoflg;
		HisDAO dao = null;
		WebRowSet ws = null;
		int procIndex1 = 0;
		String proc_name1 = "{call pkg_mms_view.Proc_Emp_Issue_Detail(?,?,?,?,?,?)}"; // 6
		try {
			System.out.println(" ------- IssueToPatOPDTransDAO .getIssueDtlsList  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_Emp_Issue_Detail  --[ Mode- 2 ]------ ");

			/*
			 * Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line
			 * Issue Voucher) 1.Hospital Name ^ DDC Name ^ Prescribe For ^ Issue No ^ Issued
			 * By Doctor ^ Date ^ Cr No ^ Hindi Text 2.Drug Name 3.Batch No 4.Exp Date
			 * 5.Issue Qty
			 */
			dao = new HisDAO("mms", "global.IssueToPatOPDTransDAO.getStockItemDtlsList(IssueToPatOPDTransVO vo)");
			procIndex1 = dao.setProcedure(proc_name1);
			// set value
			dao.setProcInValue(procIndex1, "modeval", "2", 1);
			dao.setProcInValue(procIndex1, "strId", vo.getStrStoreId(), 3);
			if (vo.getStrIssueNo() == null || vo.getStrIssueNo() == "")
				dao.setProcInValue(procIndex1, "issueNo", "0", 2);
			else
				dao.setProcInValue(procIndex1, "issueNo", vo.getStrIssueNo(), 2);
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(), 4);
			dao.setProcOutValue(procIndex1, "ERR", 1, 5); // 1 for string return
			dao.setProcOutValue(procIndex1, "RESULTSET", 2, 6); // 2 for object
			// execute procedure
			dao.executeProcedureByPosition(procIndex1);
			// get value
			err = dao.getString(procIndex1, "ERR");
			if (err == null)
				err = "";
			ws = dao.getWebRowSet(procIndex1, "RESULTSET");
			vo.setWsIssueDetails(ws);
		} catch (Exception e) {
			e.printStackTrace();
			// e.printStackTrace();
			vo.setStrMsgString("IssueToPatOPDTransDAO.getIssueDtlsList() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	public static void getViewStoreList(IssueToPatOPDTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- IssueToPatOPDTransDAO .getViewStoreList  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_hstt_store_mst  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			//// System.out.println("In DAO==>"+nProcIndex);

			daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId(), 2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 3);

			/* Setting Default Value Start */
			daoObj.setProcInValue(nProcIndex, "storeid", "0", 4);
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0", 5);
			/* Setting Default Value End */

			daoObj.setProcOutValue(nProcIndex, "err", 1, 6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 7);

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
			e.printStackTrace();
			voObj.setStrMsgString("IssueToPatOPDTransDAO.getViewStoreList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getPatinetTypeCmb(IssueToPatOPDTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_raol_catg_list(?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		try {

			System.out.println(" ------- IssueToPatOPDTransDAO .getPatinetTypeCmb  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_raol_catg_list  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "seatid", voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				if (ws != null && ws.size() > 0) {
					voObj.setStrPatientTypeWs(ws);
				}
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("IssueToPatOPDTransDAO.getPatinetTypeCmb() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getItemCatDtls(IssueToPatOPDTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- IssueToPatOPDTransDAO .getItemCatDtls  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_item_category_list  --[ Mode- 7 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "7", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 3);
			daoObj.setProcInValue(nProcIndex, "store_id",
					(voObj.getStrStoreId().equals("") || voObj.getStrStoreId() == null) ? "0" : voObj.getStrStoreId(),
					2);
			daoObj.setProcInValue(nProcIndex, "reqType", voObj.getStrReqTypeId(), 4);

			daoObj.setProcOutValue(nProcIndex, "err", 1, 5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 6);

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
			e.printStackTrace();
			voObj.setStrMsgString("IssueToPatOPDTransDAO.getItemCatDtls() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * Gets the item brand list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the item brand list
	 */
	public static void getItemBrandList(IssueToPatOPDTransVO vo) {

		String err = "";
		String proc_name1 = "";

		proc_name1 = "{call pkg_mms_view.Proc_Itembrand_Detail(?,?,?,?,?   ,?,?,?,?,?   ,?)}"; // 11

		System.out.println("-- MMSDAO . getItemBrandList -- - " + proc_name1 + " - [ Mode - 8 ]---");

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms", "IssueToPatOPDTransDAO.getItemBrandList(IssueToPatOPDTransVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "modeval", "8", 1);
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(), 2);
			dao.setProcInValue(procIndex1, "itemCat", "1", 3);
			dao.setProcInValue(procIndex1, "frmStrId", vo.getStrStoreId(), 4);
			dao.setProcInValue(procIndex1, "genericItemId", "0", 5);
			dao.setProcInValue(procIndex1, "reqType", "32", 6);
			dao.setProcInValue(procIndex1, "userInfo", "0", 7);
			dao.setProcInValue(procIndex1, "grpId", "0", 8);
			dao.setProcInValue(procIndex1, "subGrpId", "0", 9);
			dao.setProcOutValue(procIndex1, "err", 1, 10); // 1 for string return
			dao.setProcOutValue(procIndex1, "resultset", 2, 11); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			vo.setStrBrandItemListWs(ws);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("MmsDAO.getItemBrandList() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	public static void GET_PAT_ACC_STATUS(IssueToPatOPDTransVO vo) {
		String proc_name1 = "";
		proc_name1 = "{call PKG_MMS_VIEW.PROC_HBLT_PATACCOUNT_DTL(?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		int procIndex1 = 0;
		String strerr = "";
		WebRowSet ws = null;
		try {
			System.out.println("------------- IssueToPatOPDTransDAO.GET_PAT_ACC_STATUS -------------");

			System.out.println("------------- PKG_MMS_VIEW.PROC_HBLT_PATACCOUNT_DTL --[ Mode - 14 ]-----------");

			/*
			 * 0 - Ac Balance 1 - Patient Catg Code 2 - ADMISSION_DATE 3 - DISCHARGE_DATE 4
			 * - PATACCOUNT_STATUS in Text 5 - HBLNUM_PATACCOUNT_STATUS 6 - GETCATGRP 7 -
			 * HBLNUM_ACCOUNT_TYPE 8 - hblnum_finalbill_flag
			 * 
			 */
			dao = new HisDAO("mms", "IssueToPatOPDTransDAO.getAccountDtlWithAcctNo()");
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "accNo", "", 1);
			dao.setProcInValue(procIndex1, "modeVal", "14", 5);
			dao.setProcInValue(procIndex1, "puk", vo.getStrCrNo(), 2);
			dao.setProcInValue(procIndex1, "chargeTypeId", "", 3);
			dao.setProcInValue(procIndex1, "activeAccount", "", 4);
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(), 6);
			dao.setProcOutValue(procIndex1, "ERR", 1, 7);
			dao.setProcOutValue(procIndex1, "RESULTSET", 2, 8);

			dao.executeProcedureByPosition(procIndex1);
			strerr = dao.getString(procIndex1, "ERR");

			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "RESULTSET");
				vo.setStrAccDtl(ws);

				vo.setStrMsgType("0");
			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("IssueToPatOPDTransDAO.GET_PAT_ACC_STATUS() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/* ==For View Page== */
	public static void getItemCatDtls1(IssueToPatOPDTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- IssueToPatOPDTransDAO .getItemCatDtls1  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_item_category_list  --[ Mode- 3 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "3", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 3);
			daoObj.setProcInValue(nProcIndex, "store_id",
					(voObj.getStrStoreId().equals("") || voObj.getStrStoreId() == null) ? "001" : voObj.getStrStoreId(),
					2);
			daoObj.setProcInValue(nProcIndex, "reqType", voObj.getStrReqTypeId(), 4);

			daoObj.setProcOutValue(nProcIndex, "err", 1, 5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 6);

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
			e.printStackTrace();
			voObj.setStrMsgString("IssueToPatOPDTransDAO.getItemCatDtls() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void getissuetopatient(IssueToPatOPDTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String proc_name1 = "{call Pkg_Mms_View.proc_patient_issue_drug_dtl(?,?,? ,?,?,? ,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";
		System.out.println("<------------- IssueToPatOPDTransDAO.getissuetopatient ------------->");

		try {
			System.out.println("<------------- Pkg_Mms_View.proc_patient_issue_drug_dtl [ Mode - 3]------------->");

			dao = new HisDAO("MMS", "OfflineIssueIndentTransDAO.getissuetopatient(OfflineIssueIndentTransVO vo)");
			nProcIndex = dao.setProcedure(proc_name1);
			// set value
			dao.setProcInValue(nProcIndex, "modeval", "3", 1); // 1
			dao.setProcInValue(nProcIndex, "storeid", vo.getStrStoreId(), 2);// 2
			dao.setProcInValue(nProcIndex, "itemCatg", vo.getStrItemCat(), 3);// 3
			dao.setProcInValue(nProcIndex, "from_date", vo.getStrCrNo(), 4);// 4
			dao.setProcInValue(nProcIndex, "too_date", "", 5);// 5
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(), 6); // 6
			dao.setProcInValue(nProcIndex, "crno", vo.getStrCrNo(), 7); // 6
			dao.setProcOutValue(nProcIndex, "err", 1, 8); // 1 for string return //7
			dao.setProcOutValue(nProcIndex, "resultset", 2, 9);// 8
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = dao.getWebRowSet(nProcIndex, "resultset");
				vo.setWsissuetopatcount(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IssueToPatOPDTransDAO.getIssueDetailTwo() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getCancelIssueDtls(IssueToPatOPDTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_issue_item_dtls(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			System.out.println(" ------- IssueToPatOPDTransDAO .getCancelIssueDtls  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_issue_item_dtls  --[ Mode- 3 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "3");
			daoObj.setProcInValue(nProcIndex, "hoscode", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "issueno", voObj.getStrIssueNo());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setWsCancelIssueDtl(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("IssueToPatOPDTransDAO.getCancelIssueDtls() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/* changed to new one below is new method dated 17 Aug 23
	 * 
	 * public static void getIssueDetail(IssueToPatOPDTransVO voObj) {
	 * 
	 * HisDAO daoObj = null; WebRowSet ws = null;
	 * 
	 * String strProcName =
	 * "{call Pkg_Mms_View.Proc_Issue_Details(?,?,?,?,?,?,?,?,?)}"; int nProcIndex =
	 * 0;
	 * 
	 * String strErr = "";
	 * 
	 * try {
	 * 
	 * System.out.
	 * println(" ------- IssueToPatOPDTransDAO .getCancelIssueDtls  -------- ");
	 * System.out.
	 * println(" ------- pkg_mms_view.Proc_Issue_Details  --[ Mode- 1 ]------ ");
	 * 
	 * daoObj = new HisDAO("MMS Transactions","IssueToPatOPDTransDAO");
	 * 
	 * nProcIndex = daoObj.setProcedure(strProcName);
	 * 
	 * daoObj.setProcInValue(nProcIndex, "modval", "1",1);
	 * daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStoreId(),2);
	 * daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
	 * daoObj.setProcInValue(nProcIndex, "crNo", voObj.getStrCrNum(),4);
	 * daoObj.setProcInValue(nProcIndex, "catCode", voObj.getStrCatCode(),5);
	 * daoObj.setProcInValue(nProcIndex, "days", "10",6);
	 * daoObj.setProcInValue(nProcIndex, "empNo", "",7);//default value.
	 * daoObj.setProcOutValue(nProcIndex, "err", 1,8);
	 * daoObj.setProcOutValue(nProcIndex, "resultset", 2,9);
	 * 
	 * 
	 * daoObj.executeProcedureByPosition(nProcIndex);
	 * 
	 * strErr = daoObj.getString(nProcIndex, "err");
	 * 
	 * if (strErr == null) strErr = "";
	 * 
	 * if (strErr.equals("")) {
	 * 
	 * ws = daoObj.getWebRowSet(nProcIndex, "resultset");
	 * 
	 * while(ws.next()) { //System.out.println("ws.getstring()"+ws.getString(1));
	 * //System.out.println("ws.getstring()"+ws.getString(2)); }
	 * voObj.setStrIssueDetailWs(ws);
	 * 
	 * ////System.out.println("voObj.getStrIssueDetailWs()"+voObj.
	 * getStrIssueDetailWs().getString(1));
	 * 
	 * } else { throw new Exception(strErr); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); voObj
	 * .setStrMsgString("IssueToPatOPDTransDAO.getIssueDetail() --> " +
	 * e.getMessage()); voObj.setStrMsgType("1");
	 * 
	 * } finally { if (daoObj != null) { daoObj.free(); daoObj = null; } } }
	 */

	public static void getIssueDetail(IssueToPatOPDTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		//String strProcName = "{call Pkg_Mms_View.Proc_Issue_Details(?,?,?,? ,?,?,?,? ,?,?)}";
		String strProcName = "{call Pkg_Mms_View2.proc_issue_cmb_rpt(?,?,?,?  ,?,?,?,?  ,?,?)}";

		int nProcIndex = 0;
	
		String strErr = "";

		try {
			
			System.out.println(" ------- IssueToPatOPDTransDAO .getCancelIssueDtls  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_Issue_Details  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions","IssueToPatOPDTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modval", "1",1);
			daoObj.setProcInValue(nProcIndex, "storeid", voObj.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "crNo", voObj.getStrCrNum(),4);
			//daoObj.setProcInValue(nProcIndex, "catCode", voObj.getStrCatCode(),5);
			daoObj.setProcInValue(nProcIndex, "from_date", voObj.getStrFromDate(),5);
			daoObj.setProcInValue(nProcIndex, "too_date", voObj.getStrToDate(),6);
			daoObj.setProcInValue(nProcIndex, "days", "10",7);
			daoObj.setProcInValue(nProcIndex, "empno", "",8);//default value.
			daoObj.setProcOutValue(nProcIndex, "err", 1,9);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,10);
			

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			
			/*while(ws.next())
			{
			//System.out.println("ws.getstring()"+ws.getString(1));	
			//System.out.println("ws.getstring()"+ws.getString(2));
			}*/
			voObj.setStrIssueDetailWs(ws);		
			
			////System.out.println("voObj.getStrIssueDetailWs()"+voObj.getStrIssueDetailWs().getString(1));
						
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("IssueToPatOPDTransDAO.getIssueDetail() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getIssueDetailTwo(IssueToPatOPDTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String proc_name1 = "{call Pkg_Mms_View.proc_patient_issue_drug_dtl(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			System.out.println(" ------- IssueToPatOPDTransDAO .getIssueDetailTwo  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_Issue_Details  --[ Mode- 1 ]------ ");

			dao = new HisDAO("MMS", "OfflineIssueIndentTransDAO.getIssueDetailTwo(OfflineIssueIndentTransVO vo)");
			nProcIndex = dao.setProcedure(proc_name1);
			// set value
			dao.setProcInValue(nProcIndex, "modeval", "1", 1); // 1
			dao.setProcInValue(nProcIndex, "storeid", vo.getStrStoreName(), 2);// 2
			dao.setProcInValue(nProcIndex, "itemCatg", vo.getStrItemCategoryNo(), 3);// 3
			dao.setProcInValue(nProcIndex, "from_date", vo.getStrFromDate(), 4);// 4
			dao.setProcInValue(nProcIndex, "too_date", vo.getStrToDate(), 5);// 5
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(), 6); // 6
			dao.setProcInValue(nProcIndex, "crno", vo.getStrCrNo(), 7); // 6
			dao.setProcOutValue(nProcIndex, "err", 1, 8); // 1 for string return //7
			dao.setProcOutValue(nProcIndex, "resultset", 2, 9);// 8
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = dao.getWebRowSet(nProcIndex, "resultset");

				vo.setStrIssueDetailWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IssueToPatOPDTransDAO.getIssueDetailTwo() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getIssueDtlPopUp(IssueToPatOPDTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call  Pkg_Mms_View.Proc_IssuePopup_Dtls(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- IssueToPatOPDTransDAO .getIssueDtlPopUp  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_IssuePopup_Dtls  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 2);
			daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStoreId(), 4);
			daoObj.setProcInValue(nProcIndex, "issueno", voObj.getStrIssueNo(), 3);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				voObj.setStrIssueDtlPopUpWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("IssueToPatOPDTransDAO.getIssueDtlPopUp() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getRequestDtls(IssueToPatOPDTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Issue_Request_Dtls(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";
		int funcIndex;
		String BillingValue = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");

			System.out.println("<------------- IssueToPatOPDTransDAO.getRequestDtls() ------------->");

			System.out.println("<------------- bill_mst.get_pat_accountdetails_limit [ Mode - 2 ] ------------->");

			funcIndex = daoObj.setFunction("{? = call bill_mst.get_pat_accountdetails_limit(?,?,?)}");

			daoObj.setFuncInValue(funcIndex, 2, voObj.getStrHospitalCode());
			daoObj.setFuncInValue(funcIndex, 3, "2");
			daoObj.setFuncInValue(funcIndex, 4, voObj.getStrCrNumber());
			// daoObj.setFuncInValue(funcIndex, 5,_LPIssueDeskTransVO.getStrItemCategNo());
			daoObj.setFuncOutValue(funcIndex, 1);
			daoObj.executeFunction(funcIndex);
			BillingValue = daoObj.getFuncString(funcIndex);
			voObj.setStrBillingHiddenValue(BillingValue);

			System.out.println("<------------- Pkg_Mms_View.Proc_Issue_Request_Dtls [ Mode - 1 ] ------------->");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 2);
			daoObj.setProcInValue(nProcIndex, "crNo", voObj.getStrCrNumber(), 3);
			daoObj.setProcInValue(nProcIndex, "days", voObj.getStrOnlineIssueReqDays(), 4);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrRequestWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("IssueToPatOPDTransDAO.getRequestDtls() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getOnlineTreatmentDtls(IssueToPatOPDTransFB formBean, IssueToPatOPDTransVO vo) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_mms_view.PROC_HRGT_PATIENT_TREATMENT_DTL_ONLINE(?,?,?,?,?,? ,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		String strCrNum = formBean.getStrCrNo();
		String strHospcode = formBean.getStrHospitalCode();

		String strStoreId = formBean.getStrStoreId().split("\\^")[0];
		try {

			System.out.println(" ------- IssueToPatOPDTransDAO .getOnlineTreatmentDtls  -------- ");
			System.out.println(" ------- pkg_mms_view.PROC_HRGT_PATIENT_TREATMENT_DTL_ONLINE  --[ Mode- 3 ]------ ");

			daoObj = new HisDAO("Global Patient Details", "PatientDtlDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			if (strCrNum != null && !strCrNum.equals("")) {

				daoObj.setProcInValue(nProcIndex, "modeVal", "3", 1);
				daoObj.setProcInValue(nProcIndex, "puk", strCrNum, 2);
				daoObj.setProcInValue(nProcIndex, "hosp_code", strHospcode, 3);
				daoObj.setProcInValue(nProcIndex, "store_id", strStoreId, 4);

				daoObj.setProcInValue(nProcIndex, "episode", formBean.getStrEpisodeCode(), 5);
				daoObj.setProcInValue(nProcIndex, "deptcode", formBean.getStrDeptCode(), 6);
				daoObj.setProcInValue(nProcIndex, "deptunit", formBean.getStrUnitCode(), 7);

				daoObj.setProcOutValue(nProcIndex, "err", 1, 8);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2, 9);
				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				if (strErr.equals("")) {
					vo.setOnlineTreatmentDtlsWs(ws);
				} else {
					throw new Exception(strErr);
				}

			}

		} catch (Exception e) {
			vo.setStrMsgString("PatientDtlDAO.setPatientTreatmentDtl() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getAlreadyDrugIssue(IssueToPatOPDTransFB formBean, IssueToPatOPDTransVO vo) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_mms_view.PROC_HRGT_PATIENT_TREATMENT_DTL_ONLINE(?,?,?,?,?,? ,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		String strCrNum = formBean.getStrCrNo();
		String strHospcode = vo.getStrHospitalCode();

		try {

			System.out.println(" ------- IssueToPatOPDTransDAO .getAlreadyDrugIssue  -------- ");
			System.out.println(" ------- pkg_mms_view.PROC_HRGT_PATIENT_TREATMENT_DTL_ONLINE  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("Global Patient Details", "PatientDtlDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			if (strCrNum != null && !strCrNum.equals("")) {

				daoObj.setProcInValue(nProcIndex, "modeVal", "1", 1);
				daoObj.setProcInValue(nProcIndex, "puk", strCrNum, 2);
				daoObj.setProcInValue(nProcIndex, "hosp_code", strHospcode, 3);
				daoObj.setProcInValue(nProcIndex, "store_id", vo.getTariff(), 4);
				daoObj.setProcInValue(nProcIndex, "episode", formBean.getStrEpisodeCode(), 5);
				daoObj.setProcInValue(nProcIndex, "deptcode", formBean.getStrDeptCode(), 6);
				daoObj.setProcInValue(nProcIndex, "deptunit", formBean.getStrUnitCode(), 7);
				daoObj.setProcOutValue(nProcIndex, "err", 1, 8);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2, 9);
				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				System.out.println("Already Issue Drugs----" + ws.size());
				if (strErr.equals("")) {
					vo.setAlreadyIssueDrug(ws);
				} else {
					throw new Exception(strErr);
				}

			}

		} catch (Exception e) {
			vo.setStrMsgString("PatientDtlDAO.setPatientTreatmentDtl() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getRequestDetails(IssueToPatOPDTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Request_Dtls(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- IssueToPatOPDTransDAO .getRequestDetails  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_Request_Dtls  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modval", "1");
			daoObj.setProcInValue(nProcIndex, "reqNo", voObj.getStrRequestNo());
			daoObj.setProcInValue(nProcIndex, "crNo", voObj.getStrCrNumber());
			daoObj.setProcInValue(nProcIndex, "days", voObj.getStrOnlineIssueReqDays());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrRequestDetailWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("IssueToPatOPDTransDAO.getRequestDetails() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getFrequencyDetails(IssueToPatOPDTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet strFrequencyWs = null;

		String strProcName = "{call Pkg_Mms_View.proc_frequency_dtl(?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println("<------------- IssueToPatOPDTransDAO.getFrequencyDetails() ------------->");

			System.out.println("<------------- Pkg_Mms_View.proc_frequency_dtl ------------->");

			daoObj = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 1);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 2);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 3);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				strFrequencyWs = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrFrequencyWs(strFrequencyWs);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("IssueToPatOPDTransDAO.getFrequencyDetails() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getDoseDetails(IssueToPatOPDTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet strDosageWs = null;

		String strProcName = "{call Pkg_Mms_View.proc_dosage_dtl(?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");

			System.out.println("<------------- IssueToPatOPDTransDAO.getDoseDetails() ------------->");

			System.out.println("<------------- Pkg_Mms_View.proc_dosage_dtl ------------->");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 1);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 2);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 3);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				strDosageWs = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrDosageWs(strDosageWs);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("IssueToPatOPDTransDAO.getDoseDetails() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getDeptDetails(IssueToPatOPDTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_department(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- IssueToPatOPDTransDAO .getDeptDetails  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_department  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 2);
			daoObj.setProcInValue(nProcIndex, "seatid", voObj.getStrSeatId(), 3);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 5);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrDepartmentWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("IssueToPatOPDTransDAO.getDeptDetails() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getUnitDetails(IssueToPatOPDTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Unit(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- IssueToPatOPDTransDAO .getUnitDetails  ---(Dept Wise Unit)----- ");
			System.out.println(" ------- pkg_mms_view.Proc_Unit  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "dept_code", voObj.getStrDeptCode(), 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 2);
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId(), 3);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 5);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrUnitWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("IssueToPatOPDTransDAO.getUnitDetails() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getPrescribedBy(IssueToPatOPDTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Consultant_Name(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- IssueToPatOPDTransDAO .getPrescribedBy  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_Consultant_Name  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
			daoObj.setProcInValue(nProcIndex, "deptunitcode", voObj.getStrUnitCode(), 2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 3);
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId(), 4);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrConsultantWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("IssueToPatOPDTransDAO.getPrescribedBy() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getItemDetails(IssueToPatOPDTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_IssueItem_Dtl(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- IssueToPatOPDTransDAO .getItemDetails  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_IssueItem_Dtl  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "reqNo", voObj.getStrRequestNo());
			daoObj.setProcInValue(nProcIndex, "crNo", voObj.getStrCrNumber());
			daoObj.setProcInValue(nProcIndex, "strId", voObj.getStrStoreId());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrItemDetailWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("IssueToPatOPDTransDAO.getItemDetails() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getUnitCombo(IssueToPatOPDTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_mms_view.proc_gblt_unit_mst(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- IssueToPatOPDTransDAO .getUnitCombo  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_gblt_unit_mst  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "unit_id", voObj.getStrIssueUnitId());
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "module_id", "");// Default Value
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrIssueUnitWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("IssueToPatOPDTransDAO.getUnitCombo() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	/**
	 * This function is fetch details from database for group combo
	 * 
	 * @param vo
	 */

	public static void getStoreGroupList(IssueToPatOPDTransVO vo) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			System.out.println("<------------- IssueToPatOPDTransDAO.getStoreGroupList() ------------->");
			System.out.println("<------------- pkg_mms_view.proc_store_group_list [ Mode - 2 ]------------->");

			dao = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");

			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "modeval", "2", 1);
			// set value
			dao.setProcInValue(procIndex1, "item_category", vo.getStrItemCat(), 3);
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(), 2);

			/* Setting Default Value Start */
			dao.setProcInValue(procIndex1, "strPhyStockNo", "", 4);
			dao.setProcInValue(procIndex1, "strStoreId", "", 5);
			/* Setting Default Value End */

			dao.setProcOutValue(procIndex1, "ERR", 1, 6); // 1 for string return
			// value
			dao.setProcOutValue(procIndex1, "RESULTSET", 2, 7); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			vo.setStrGroupWs(ws);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IssueToPatOPDTransDAO.getStoreGroupList() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	/*
	 * NOT IN USE
	 */

	public static synchronized void insert(IssueToPatOPDTransVO vo) {
		HisDAO dao = null;
		String strFuncName = "";
		int nFuncIndex = 0;
		int length = 0;
		String paramVal[] = null;
		String userValue[] = null;
		String strIssueNo = "";
		String strVisitDtl = "";
		Double netCost = 0.00;
		DmlHsttPatEmpIssueItemDtlDAO dmlhsttpatempissueitemdtl = null;
		DmlHsttPatEmpIssueDtlDAO dmlhsttpatempissuedtl = null;

		int debugPoint = 0;
		String itemValue = "";
		/*
		 * Added by shefali garg
		 */
		String strIssueUnitId = "0";
		String strBillTariff = "";
		String strBillBatch = "";
		String strBillRate = "";
		String strBillQty = "";
		String proc_name2 = "{call bill_interface.dml_online_billreq_drugs(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}";
		MmsConfigUtil mcu;

		try {

			System.out.println("------------- IssueToPatOPDTransDAO.insert ------  START ------");
			System.out.println(" ------- bill_interface.dml_online_billreq_drugs  --[ Mode- 2 ]------ ");

			debugPoint = 1;
			mcu = new MmsConfigUtil(vo.getStrHospitalCode());
			dao = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");
			dmlhsttpatempissueitemdtl = new DmlHsttPatEmpIssueItemDtlDAO();
			dmlhsttpatempissuedtl = new DmlHsttPatEmpIssueDtlDAO();
			strFuncName = "{? = call MMS_MST.generate_issueNo(?::numeric,?::numeric,?::numeric,?::numeric)}";
			nFuncIndex = dao.setFunction(strFuncName);

			dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId());
			dao.setFuncInValue(nFuncIndex, 4, "1");
			dao.setFuncInValue(nFuncIndex, 5, vo.getStrItemCat());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strIssueNo = dao.getFuncString(nFuncIndex);
			vo.setStrIssueNumber(strIssueNo.split("\\^")[0]);

			System.out.println(" ------- MMS_MST.generate_issueNo  --[ Mode- 1 ]------ ");

			System.out.println(" ------- strIssueNo------ " + strIssueNo);

			debugPoint = 2;

			strVisitDtl = "0";
			String strEpisodeCode = "0";
			String strVisitNo = "0";

			dao = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");
			length = vo.getItemParamValue().length;

			for (int k = 0; k < length; k++) {
				/**
				 * Hidden Values corresponding to particular ITEM DETAILS
				 */
				debugPoint = 3;
				if (vo.getStrQtyText()[k] != null && vo.getStrQtyText()[k].length() > 0
						&& !vo.getStrQtyText()[k].equals("0")) {
					itemValue = vo.getItemParamValue()[k];

					paramVal = vo.getItemParamValue()[k].split("#");
					userValue = paramVal[2].replace('^', '#').split("#");

					debugPoint = 4;

					if (strBillTariff != null && strBillTariff != "")
						strBillTariff = strBillTariff + "^" + userValue[1];
					else
						strBillTariff = userValue[1];
					if (strBillRate != null && strBillRate != "")
						strBillRate = strBillRate + "^" + userValue[9];
					else
						strBillRate = userValue[9];
					if (strBillQty != null && strBillQty != "")
						strBillQty = strBillQty + "^" + vo.getStrQtyText()[k];
					else
						strBillQty = vo.getStrQtyText()[k];
					if (strBillBatch != null && strBillBatch != "")
						strBillBatch = strBillBatch + "^" + userValue[15];
					else
						strBillBatch = userValue[15];

					String strInventoryUnitId = userValue[11];

					dmlhsttpatempissueitemdtl.setStrStoreId(vo.getStrStoreId());
					dmlhsttpatempissueitemdtl.setStrIssueNo(vo.getStrIssueNumber());
					dmlhsttpatempissueitemdtl.setStrItemId(userValue[0]);
					dmlhsttpatempissueitemdtl.setStrItemBrandId(userValue[1]);
					dmlhsttpatempissueitemdtl.setStrBatchSlNo(userValue[15]);
					dmlhsttpatempissueitemdtl.setStrHospitalCode(vo.getStrHospitalCode());

					debugPoint = 5;

					dmlhsttpatempissueitemdtl.setStrItemSlNo(userValue[18]);
					dmlhsttpatempissueitemdtl.setStrStockStatusCode(userValue[32]);
					dmlhsttpatempissueitemdtl.setStrGroupId(userValue[2]);
					dmlhsttpatempissueitemdtl.setStrSubGroupId(userValue[3]);
					dmlhsttpatempissueitemdtl.setStrRate(userValue[9]);
					dmlhsttpatempissueitemdtl.setStrRateUnitId(userValue[10]);

					debugPoint = 6;

					dmlhsttpatempissueitemdtl.setStrBalQty("0");
					dmlhsttpatempissueitemdtl.setStrBalQtyUnitId("");
					dmlhsttpatempissueitemdtl.setStrIssueQty(vo.getStrQtyText()[k]);
					dmlhsttpatempissueitemdtl.setStrIssueQtyUnitId(strInventoryUnitId); // Aritra,22nd June
					dmlhsttpatempissueitemdtl.setStrExpiryDate(userValue[16]);
					dmlhsttpatempissueitemdtl.setStrRemarks(vo.getStrRemarks());

					debugPoint = 7;

					dmlhsttpatempissueitemdtl.setStrCost("0");
					dmlhsttpatempissueitemdtl.setStrInHandQty(userValue[7]);
					dmlhsttpatempissueitemdtl.setStrInHandQtyUnitId(userValue[8]);
					dmlhsttpatempissueitemdtl.setStrManufDate(userValue[17]);
					dmlhsttpatempissueitemdtl.setStrReqNo(vo.getStrRequestNo());
					dmlhsttpatempissueitemdtl.setStrCrNo(vo.getStrPuk());

					debugPoint = 8;

					dmlhsttpatempissueitemdtl.setStrEmpNo(vo.getStrReqEmpNo());
					dmlhsttpatempissueitemdtl.setStrVisitNo(strVisitNo);
					dmlhsttpatempissueitemdtl.setStrEpisodeCode(strEpisodeCode);
					dmlhsttpatempissueitemdtl.setStrAdmNo(vo.getStrReqAdmNo());
					dmlhsttpatempissueitemdtl.setStrOrderBy(vo.getStrReqPrescribedBy());// Id od the consultant

					debugPoint = 9;

					dmlhsttpatempissueitemdtl.setStrDays(vo.getStrReqPrescribedFor());
					dmlhsttpatempissueitemdtl.setStrReqTypeId(vo.getStrReqTypeId());
					dmlhsttpatempissueitemdtl.setStrItemCatNo(vo.getStrItemCat());

					debugPoint = 10;

					dmlhsttpatempissueitemdtl.setStrDosage("0");
					dmlhsttpatempissueitemdtl.setStrFrequency("0");
					dmlhsttpatempissueitemdtl.setStrPresDays("0");

					dmlhsttpatempissueitemdtl.setStrPatientName(vo.getStrPatientDtlHidVal().split("\\^")[7]);//
					dmlhsttpatempissueitemdtl.setStrSeatId(vo.getStrSeatId());
					dmlhsttpatempissueitemdtl.setStrDrugIssueDate(vo.getStrDrugIssueDate());

					debugPoint = 11;
					dmlhsttpatempissueitemdtl.insert2(dao);

				}

			}
			if (vo.getStrLFAccountNo() != null && vo.getStrLFAccountNo() != "") {
				// if(mcu.getStrBillingIntegration().equals("1"))
				// {
				int procIndex2;
				procIndex2 = dao.setProcedure(proc_name2);

				dao.setProcInValue(procIndex2, "modval", "2", 1); // 1
				dao.setProcInValue(procIndex2, "gnum_dept_code", vo.getStrDeptCode(), 2);
				dao.setProcInValue(procIndex2, "sblnum_chargetype_id", "1", 3);
				dao.setProcInValue(procIndex2, "sblnum_service_id", "5", 4);
				dao.setProcInValue(procIndex2, "gstr_req_no", strIssueNo, 5);
				dao.setProcInValue(procIndex2, "gnum_treatment_cat", "11", 6);
				dao.setProcInValue(procIndex2, "hrgnum_episode_code", "1", 7);
				dao.setProcInValue(procIndex2, "hrgnum_puk", vo.getStrCrNo(), 8);
				dao.setProcInValue(procIndex2, "hblnum_pat_lfaccount_no", vo.getStrLFAccountNo(), 9);
				dao.setProcInValue(procIndex2, "gstr_tariff", strBillTariff, 10);
				dao.setProcInValue(procIndex2, "gstr_tariff_batch", strBillBatch, 11);
				dao.setProcInValue(procIndex2, "gstr_tariff_rates", strBillRate, 12);
				dao.setProcInValue(procIndex2, "gstr_reqqty", strBillQty, 13);
				dao.setProcInValue(procIndex2, "hblstr_patient_name", "", 14);
				dao.setProcInValue(procIndex2, "hblstr_pat_address", "", 15);
				dao.setProcInValue(procIndex2, "hblstr_contact_no", "", 16);
				dao.setProcInValue(procIndex2, "age", "1", 17);
				dao.setProcInValue(procIndex2, "ageunit", "1", 18);
				dao.setProcInValue(procIndex2, "gender", "1", 19);
				dao.setProcInValue(procIndex2, "refdoctor", "1", 20);
				dao.setProcInValue(procIndex2, "refdoccontactno", "1", 21);
				dao.setProcInValue(procIndex2, "gnum_seatid", vo.getStrSeatId(), 22);
				dao.setProcInValue(procIndex2, "hosp_code", vo.getStrHospitalCode(), 23);
				dao.setProcInValue(procIndex2, "ward_code", vo.getStrWardCode(), 24);
				dao.setProcInValue(procIndex2, "admno", "1", 25);
				dao.setProcInValue(procIndex2, "visitno", vo.getStrVisitNo(), 26);
				dao.setProcOutValue(procIndex2, "err", 1, 27);
				dao.execute(procIndex2, 1);

				// }
			}
			debugPoint = 12;

			dmlhsttpatempissuedtl.setStrStoreId(vo.getStrStoreId());
			dmlhsttpatempissuedtl.setStrIssueNo(vo.getStrIssueNumber());
			dmlhsttpatempissuedtl.setStrHospitalCode(vo.getStrHospitalCode());
			dmlhsttpatempissuedtl.setStrRequestNo(vo.getStrRequestNo());
			dmlhsttpatempissuedtl.setStrOrderBy(vo.getStrReqPrescribedBy());

			debugPoint = 13;

			dmlhsttpatempissuedtl.setStrOrderDate(vo.getStrReqPrescriptionDate());
			dmlhsttpatempissuedtl.setStrDays(vo.getStrPrescriptionFor());
			dmlhsttpatempissuedtl.setStrCrNo(vo.getStrPuk());
			dmlhsttpatempissuedtl.setStrReqTypeId("32");
			dmlhsttpatempissuedtl.setStrAdmNo(vo.getStrReqAdmNo());

			debugPoint = 14;

			dmlhsttpatempissuedtl.setStrEmpNo(vo.getStrReqEmpNo());
			dmlhsttpatempissuedtl.setStrItemCatNo(vo.getStrItemCat());
			dmlhsttpatempissuedtl.setStrFinalCost(DmlHsttPatEmpIssueItemDtlDAO.getIntCost() + "");
			dmlhsttpatempissuedtl.setStrFinStartDate(vo.getStrFinStartDate());
			dmlhsttpatempissuedtl.setStrFinEndDate(vo.getStrFinEndDate());

			debugPoint = 15;

			dmlhsttpatempissuedtl.setStrSeatId(vo.getStrSeatId());
			dmlhsttpatempissuedtl.setStrDeptUnitCode(vo.getStrUnitCode());
			dmlhsttpatempissuedtl.setStrVisitType(vo.getStrReqPrescriptionFrom());
			dmlhsttpatempissuedtl.setStrDeptCode(vo.getStrDeptCode());

			dmlhsttpatempissuedtl.setStrWardCode(vo.getStrReqWardCode());

			debugPoint = 16;

			dmlhsttpatempissuedtl.setStrReceiveBy(vo.getStrReceiveBy());
			dmlhsttpatempissuedtl.setStrRemarks(vo.getStrRemarks());
			dmlhsttpatempissuedtl.setStrReqDate("");
			dmlhsttpatempissuedtl.setStrVisitNo(strVisitNo);
			dmlhsttpatempissuedtl.setStrEpisoCode(strEpisodeCode);

			debugPoint = 17;

			// By Vivek
			// vo.getStrPatientHiddenValue1 Patient Name ^Father Name^Category
			// Code^Address^Mlc No
			/*
			 * vo.getStrPatientDtlHidVal() HRGDT_DOB || ''^'' ||GNUM_GENDER_CODE
			 * ||''^''||HGNUM_PAT_STATUS_CODE || ''^''|| HGNUM_PATIENT_CAT_CODE || ''^''
			 * ||HRGNUM_IS_MLC ||''^''||HRGNUM_ISNEWBORN || ''^''|| HRGNUM_ID_NO
			 */
			// By Vivek

			itemValue += " PatientHiddenValue1 :: " + vo.getStrPatientHiddenValue1() + " StrPatientDtlHidVal :: "
					+ vo.getStrPatientDtlHidVal();

			dmlhsttpatempissuedtl.setStrFirstName(vo.getStrPatientDtlHidVal().split("\\^")[7]);
			dmlhsttpatempissuedtl.setStrMiddelName("");
			dmlhsttpatempissuedtl.setStrLastName("");
			dmlhsttpatempissuedtl.setStrPatientId(vo.getStrPatientId());
			dmlhsttpatempissuedtl.setStrPatientType("18");

			debugPoint = 18;

			dmlhsttpatempissuedtl.setStrPatientAge(vo.getStrPatientDtlHidVal().split("\\^")[0]);
			dmlhsttpatempissuedtl.setStrPatientAgeUnit("0");
			dmlhsttpatempissuedtl.setStrPatientFatherName(vo.getStrPatientDtlHidVal().split("\\^")[8]);
			dmlhsttpatempissuedtl.setStrPatientGenderCode(vo.getStrPatientDtlHidVal().split("\\^")[1]);

			debugPoint = 19;

			dmlhsttpatempissuedtl.setStrPatientAddress(vo.getStrPatientHiddenValue1().split("\\^")[3]);
			dmlhsttpatempissuedtl.setStrTransType("1"); // With CR No
			dmlhsttpatempissuedtl.setStrDrugIssueDate(vo.getStrDrugIssueDate());
			dmlhsttpatempissuedtl.setStrOutOfStockFlag(vo.getStrOutOfStockFlag());

			debugPoint = 20;

			dmlhsttpatempissuedtl.insert(dao);

			// DAO Fire
			synchronized (dao) {
				dao.fire();
			}

			debugPoint = 21;

			System.out.println("------------- IssueToPatOPDTransDAO.insert ------  END  ------");

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgType("1");
			vo.setStrMsgString("IssueToPatOPDTransDAO.insert() --> " + e.getMessage() + " DAO_DEBUG_POINT :: "
					+ debugPoint + " DAO_VALUE :: " + itemValue);
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	

	

	public static void getGenderCombo(IssueToPatOPDTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_get_Gender_Combo(?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "p_mode", "1", 1);
			daoObj.setProcInValue(nProcIndex, "p_gnum_hospital_code", voObj.getStrHospitalCode(), 2);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 3);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 4);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrGenderWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("IssueToPatOPDTransDAO.getGenderCombo() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getLFAccountDetails(IssueToPatOPDTransVO voObj) {
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_HBLT_PAT_LF_ACCOUNT_DTL(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		// String strDeptCode = voObj.getStrOffLineRaisingDepartment();//Last Visited
		// Department
		String strCrNo = voObj.getStrPuk();

		String strErr = "";

		try {
			System.out.println(" ------- IssueToPatOPDTransDAO .getLFAccountDetails  -------- ");
			System.out.println(" ------- pkg_bill_view.proc_HBLT_PAT_LF_ACCOUNT_DTL  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("Billing", "LFNoTransDAO.getEpisodeList");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
			// daoObj.setProcInValue(nProcIndex, "deptCode", strDeptCode, 2);
			if (strCrNo != null && strCrNo != "") {
				daoObj.setProcInValue(nProcIndex, "puk", strCrNo, 2);
			} else {
				daoObj.setProcInValue(nProcIndex, "puk", "0", 2);
			}

			if (voObj.getStrLFNo() != null && voObj.getStrLFNo() != "")
				daoObj.setProcInValue(nProcIndex, "accno", voObj.getStrLFNo(), 3);
			else
				daoObj.setProcInValue(nProcIndex, "accno", "0", 3);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 4);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 5);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				if (ws.next()) {
					voObj.setStrLFAccountNo(ws.getString(1));
					voObj.setStrLFAccountOpenDate(ws.getString(2));
					voObj.setStrLFDepositedAmount(ws.getString(3));
					voObj.setStrLFBalanceAmount(ws.getString(4));
					voObj.setStrLFAccountStatus(ws.getString(5));
					voObj.setStrCrNo(ws.getString(6));
					// ws.beforeFirst();
				}

				// voObj.setAdmEpisodeTreatCatDeptDtls(ws);
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("LFNoTransDAO.getEpisodeList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getLFAccountSummary(IssueToPatOPDTransVO voObj) {
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_lf_account_summary(?,?,?,?,?)}";
		int nProcIndex = 0;

		// String strDeptCode = voObj.getStrOffLineRaisingDepartment();//Last Visited
		// Department
		String strCrNo = voObj.getStrPuk();

		String strErr = "";

		try {
			System.out.println("------------- IssueToPatOPDTransDAO.getLFAccountSummary -------------");
			System.out.println("------------- pkg_bill_view.proc_lf_account_summary [ Mode - 1 ] -------------");

			daoObj = new HisDAO("Billing", "LFNoTransDAO.getEpisodeList");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 2);
			if (voObj.getStrLFAccountNo() != null && voObj.getStrLFAccountNo() != "")
				daoObj.setProcInValue(nProcIndex, "lfaccount_no", voObj.getStrLFAccountNo(), 3);
			else
				daoObj.setProcInValue(nProcIndex, "lfaccount_no", "0", 3);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 5);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				voObj.setWsLFAccountSummary(ws);

				// voObj.setAdmEpisodeTreatCatDeptDtls(ws);
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("LFNoTransDAO.getEpisodeList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	/**
	 * To get Diagnosis details of patient
	 * 
	 * @param IssueToPatOPDTransVO the IssueToPatOPDTransVO
	 */
	public static void getPatientDiagDetails(IssueToPatOPDTransVO vo) {

		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";

		try {
			System.out.println("------------- IssueToPatOPDTransDAO.getPatientDiagDetails -------------");
			System.out.println("------------- PKG_MMS_VIEW.proc_diag_emp_view [ Mode - 1 ] -------------");

			String strProcName = "{call PKG_MMS_VIEW.proc_diag_emp_view(?,?::varchar,?::varchar,?,?)}";

			daoObj = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modval", "1", 1);
			daoObj.setProcInValue(nProcIndex, "crno", vo.getStrCrNo(), 2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(), 3);

			daoObj.setProcOutValue(nProcIndex, "err", 1, 4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 5);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				wb = daoObj.getWebRowSet(nProcIndex, "resultset");

				vo.setDiagEmpWs(wb);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> IssueToPatOPDTransDAO.getPatientDiagDetails()-->" + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null)
				daoObj.free();
			daoObj = null;
		}

	}

	/**
	 * To get Diagnosis combo
	 * 
	 * @param IssueToPatOPDTransVO the IssueToPatOPDTransVO
	 */
	public static void getIcdList(IssueToPatOPDTransVO vo) {

		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";

		try {

			System.out.println("------------- IssueToPatOPDTransDAO.getIcdList -------------");
			System.out.println("------------- PKG_MMS_VIEW.proc_diag_mst [ Mode - 1 ] -------------");

			String strProcName = "{call PKG_MMS_VIEW.proc_diag_mst(?,?,?)}";

			daoObj = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modval", "1", 1);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 2);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 3);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				wb = daoObj.getWebRowSet(nProcIndex, "resultset");

				vo.setDiagMstWs(wb);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			vo.setStrMsgString("--> IssueToPatOPDTransDAO.getPatientDiagDetails()-->" + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null)
				daoObj.free();
			daoObj = null;
		}

	}

	/**
	 * To get doctor details
	 * 
	 * @param IssueToPatOPDTransVO the IssueToPatOPDTransVO
	 */
	public static void getEmpList(IssueToPatOPDTransVO vo) {

		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";

		try {

			System.out.println("------------- IssueToPatOPDTransDAO.getEmpList -------------");
			System.out.println("------------- PKG_MMS_VIEW.proc_unit_consulatant_view [ Mode - 2 ] -------------");

			String strProcName = "{call PKG_IPD_VIEW.proc_unit_consulatant_view(?,?,?,?,?,?)}";

			daoObj = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modval", "2", 1);
			daoObj.setProcInValue(nProcIndex, "deptunitcode", "0", 2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(), 3);
			daoObj.setProcInValue(nProcIndex, "seatid", "0", 4);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				wb = daoObj.getWebRowSet(nProcIndex, "resultset");

				vo.setEmpWs(wb);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			vo.setStrMsgString("--> IssueToPatOPDTransDAO.getPatientDiagDetails()-->" + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null)
				daoObj.free();
			daoObj = null;
		}

	}

	public static void getBilledItemDtls(IssueToPatOPDTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String proc_name1 = "{call Pkg_Mms_View.proc_patient_issue_drug_dtl(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			System.out.println("------------- IssueToPatOPDTransDAO.getBilledItemDtls -------------");
			System.out.println("------------- PKG_MMS_VIEW.proc_patient_issue_drug_dtl [ Mode - 2 ] -------------");

			dao = new HisDAO("MMS", "OfflineIssueIndentTransDAO.getIssueDetailTwo(OfflineIssueIndentTransVO vo)");
			nProcIndex = dao.setProcedure(proc_name1);
			// set value
			dao.setProcInValue(nProcIndex, "modeval", "2", 1); // 1
			dao.setProcInValue(nProcIndex, "storeid", vo.getStrStoreId(), 2);// 2
			dao.setProcInValue(nProcIndex, "itemCatg", vo.getStrIssueNo(), 3);// 3 item category has been used as issue
																				// no here
			dao.setProcInValue(nProcIndex, "from_date", "", 4);// 4
			dao.setProcInValue(nProcIndex, "too_date", "", 5);// 5
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(), 6); // 6
			dao.setProcInValue(nProcIndex, "crno", vo.getStrCrNo(), 7); // 6
			dao.setProcOutValue(nProcIndex, "err", 1, 8); // 1 for string return //7
			dao.setProcOutValue(nProcIndex, "resultset", 2, 9);// 8
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = dao.getWebRowSet(nProcIndex, "resultset");

				vo.setStrBilledItemDetailWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("IssueToPatOPDTransDAO.getIssueDetailTwo() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/*
	 * NOT IN USE
	 */
	public static void save(IssueToPatOPDTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String proc_name1 = "{call Pkg_Mms_dml.dml_issue_billed_item(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			System.out.println("------------- IssueToPatOPDTransDAO.save -------------");
			System.out.println("------------- Pkg_Mms_dml.dml_issue_billed_item [ Mode - 1 ] -------------");

			dao = new HisDAO("MMS", "OfflineIssueIndentTransDAO.getIssueDetailTwo(OfflineIssueIndentTransVO vo)");
			nProcIndex = dao.setProcedure(proc_name1);
			// set value
			dao.setProcInValue(nProcIndex, "modeval", "1", 1); // 1
			dao.setProcInValue(nProcIndex, "storeid", vo.getStrStoreId(), 4);// 2
			dao.setProcInValue(nProcIndex, "issueNo", vo.getStrIssueNo(), 3);// 3
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(), 2); // 6
			dao.setProcOutValue(nProcIndex, "err", 1, 5); // 1 for string return //7
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("IssueToPatOPDTransDAO.getIssueDetailTwo() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void deleteIssueDtls(IssueToPatOPDTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String proc_name1 = "{call Pkg_Mms_dml.proc_patient_issue_delete(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println("------------- IssueToPatOPDTransDAO.deleteIssueDtls -------------");
			System.out.println("------------- Pkg_Mms_dml.proc_patient_issue_delete [ Mode - 1 ] -------------");

			dao = new HisDAO("MMS", "OfflineIssueIndentTransDAO.getIssueDetailTwo(OfflineIssueIndentTransVO vo)");
			nProcIndex = dao.setProcedure(proc_name1);
			// set value
			dao.setProcInValue(nProcIndex, "modeval", "1", 1); // 1
			dao.setProcInValue(nProcIndex, "storeid", vo.getStrStoreId(), 4);// 2
			dao.setProcInValue(nProcIndex, "issueNo", vo.getStrIssueNo(), 3);// 3 item category has been used as issue
																				// no here
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(), 2); // 6
			dao.setProcOutValue(nProcIndex, "err", 1, 5); // 1 for string return //7
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("IssueToPatOPDTransDAO.getIssueDetailTwo() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getTariffDtls(IssueToPatOPDTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String proc_name1 = "{call Pkg_Mms_View.proc_tariff_list(?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println("------------- IssueToPatOPDTransDAO.getTariffDtls -------------");
			System.out.println("------------- Pkg_Mms_dml.proc_tariff_list [ Mode - 1 ] -------------");

			dao = new HisDAO("MMS", "OfflineIssueIndentTransDAO.getIssueDetailTwo(OfflineIssueIndentTransVO vo)");
			nProcIndex = dao.setProcedure(proc_name1);
			// set value
			dao.setProcInValue(nProcIndex, "modeval", "1", 1); // 1
			dao.setProcInValue(nProcIndex, "tariffid", vo.getTariff(), 2);// 2
			dao.setProcOutValue(nProcIndex, "err", 1, 3); // 1 for string return //7
			dao.setProcOutValue(nProcIndex, "resultset", 2, 4);// 8
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = dao.getWebRowSet(nProcIndex, "resultset");

				vo.setStrTariffDtl(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IssueToPatOPDTransDAO.getTariffDtls() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getStoreListBS(IssueToPatOPDTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		try {

			System.out.println("------------- IssueToPatOPDTransDAO.getStoreListBS -------------");
			System.out.println("------------- Pkg_Mms_dml.proc_hstt_store_mst [ Mode - 12 ] -------------");

			daoObj = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "12", 1);
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId(), 2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 3);

			/* Setting Default Value Start */
			daoObj.setProcInValue(nProcIndex, "storeid", "0", 4);
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0", 5);
			/* Setting Default Value End */

			daoObj.setProcOutValue(nProcIndex, "err", 1, 6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 7);

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
			e.printStackTrace();
			voObj.setStrMsgString("IssueToPatOPDTransDAO.getStoreList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getPaymentMode(IssueToPatOPDTransVO vo) {
		// TODO Auto-generated method stub

		String strProcName = "{call pkg_bill_view.sblt_payment_category_mapping_mst(?,?,?,?,?,?,?,?)}";

		int nProcIndex = 0;
		String val = "0";
		String strErr = "";
		WebRowSet ws = null;

		HisDAO daoObj = null;
		try {
			System.out.println(" ------- IssueToPatOPDTransDAO .getPaymentMode  -------- ");
			System.out.println(" ------- pkg_bill_view.sblt_payment_category_mapping_mst  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			// nProcIndex = daoObj.setFunction(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(), 2);
			daoObj.setProcInValue(nProcIndex, "req_type", "1", 3);
			daoObj.setProcInValue(nProcIndex, "pat_category", "11", 4);
			daoObj.setProcInValue(nProcIndex, "pat_reciept_paymode", "", 5);

			daoObj.setProcInValue(nProcIndex, "charge_id", "", 6);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 7); // 1 for string return
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 8);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setStrPayMode(ws);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IssueToPatOPDTransDAO.getPaymentMode() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void getReqType(IssueToPatOPDTransVO vo) {
		// TODO Auto-generated method stub

		String strProcName = "{call Pkg_Mms_View.proc_sstt_indenttype_dtl(?,?,?,?,?,?,?)}";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;

		HisDAO daoObj = null;
		try {
			System.out.println("------------- IssueToPatOPDTransDAO.getReqType -------------");
			System.out.println("------------- Pkg_Mms_dml.proc_sstt_indenttype_dtl [ Mode - 3 ] -------------");

			daoObj = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			// nProcIndex = daoObj.setFunction(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "3", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(), 2);
			daoObj.setProcInValue(nProcIndex, "req_for", "3", 3);
			daoObj.setProcInValue(nProcIndex, "item_cat", "10", 4);
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId(), 5);

			daoObj.setProcOutValue(nProcIndex, "err", 1, 6); // 1 for string return
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 7);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setStrReqTypeWs(ws);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IssueToPatOPDTransDAO.getReqType() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static synchronized void directIssue(IssueToPatOPDTransVO vo) {
		HisDAO dao = null;
		String strFuncName = "";
		int nFuncIndex = 0;
		int length = 0;
		String paramVal[] = null;
		String userValue[] = null;
		String strIssueNo = "";
		String strVisitDtl = "";
		Double netCost = 0.00;
		DmlHsttPatEmpIssueItemDtlDAO dmlhsttpatempissueitemdtl = null;
		DmlHsttPatEmpIssueDtlDAO dmlhsttpatempissuedtl = null;

		int debugPoint = 0;
		String itemValue = "";

		String strIssueUnitId = "0";
		String strBillTariff = "";
		// String strBillingTariff = "";
		String strBillBatch = "";
		String strBillRate = "";
		String strBillQty = "";

		MmsConfigUtil mcu;
		int procIndex2 = 0;

		try {

			System.out.println("------------- IssueToPatOPDTransDAO.directIssue ------  START ------");

			debugPoint = 1;
			mcu = new MmsConfigUtil(vo.getStrHospitalCode());
			dao = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");
			dmlhsttpatempissueitemdtl = new DmlHsttPatEmpIssueItemDtlDAO();
			dmlhsttpatempissuedtl = new DmlHsttPatEmpIssueDtlDAO();
			strFuncName = "{? = call MMS_MST.generate_issueNo(?::numeric,?::numeric,?::numeric,?::numeric)}";
			nFuncIndex = dao.setFunction(strFuncName);

			dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId());
			dao.setFuncInValue(nFuncIndex, 4, "1");
			dao.setFuncInValue(nFuncIndex, 5, vo.getStrItemCat());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strIssueNo = dao.getFuncString(nFuncIndex);
			vo.setStrIssueNumber(strIssueNo.split("\\^")[0]);

			debugPoint = 2;

			strVisitDtl = "0";
			String strEpisodeCode = "0";
			String strVisitNo = "0";

			dao = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");
			length = vo.getItemParamValue().length;

			for (int k = 0; k < length; k++) {
				/**
				 * Hidden Values corresponding to particular ITEM DETAILS
				 */
				debugPoint = 3;
				if (vo.getStrQtyText()[k] != null && vo.getStrQtyText()[k].length() > 0
						&& !vo.getStrQtyText()[k].equals("0")) {
					itemValue = vo.getItemParamValue()[k];

					paramVal = vo.getItemParamValue()[k].split("#");
					userValue = paramVal[2].replace('^', '#').split("#");

					debugPoint = 4;

					if (strBillTariff != null && strBillTariff != "") {

						strBillTariff = strBillTariff + "^" + userValue[1];
					} else {
						strBillTariff = userValue[1];
					}
					if (strBillRate != null && strBillRate != "") {
						strBillRate = strBillRate + "^" + userValue[9];
					} else {
						strBillRate = userValue[9];
					}
					if (strBillQty != null && strBillQty != "") {
						strBillQty = strBillQty + "^" + vo.getStrQtyText()[k];
					} else {
						strBillQty = vo.getStrQtyText()[k];
					}
					if (strBillBatch != null && strBillBatch != "") {
						strBillBatch = strBillBatch + "^" + userValue[15];
					} else {
						strBillBatch = userValue[15];
					}
					System.out.println("---------------------------");
					System.out.println("strBillTariff-----" + strBillTariff);
					System.out.println("strBillRate-------" + strBillRate);
					System.out.println("strBillQty--------" + strBillQty);
					System.out.println("strBillBatch------" + strBillBatch);
					System.out.println("---------------------------");

					String strInventoryUnitId = userValue[11];

					dmlhsttpatempissueitemdtl.setStrStoreId(vo.getStrStoreId());
					dmlhsttpatempissueitemdtl.setStrIssueNo(vo.getStrIssueNumber());
					dmlhsttpatempissueitemdtl.setStrItemId(userValue[0]);
					dmlhsttpatempissueitemdtl.setStrItemBrandId(userValue[1]);
					dmlhsttpatempissueitemdtl.setStrBatchSlNo(userValue[15]);
					dmlhsttpatempissueitemdtl.setStrHospitalCode(vo.getStrHospitalCode());

					debugPoint = 5;

					dmlhsttpatempissueitemdtl.setStrItemSlNo(userValue[18]);
					dmlhsttpatempissueitemdtl.setStrStockStatusCode(userValue[32]);
					dmlhsttpatempissueitemdtl.setStrGroupId(userValue[2]);
					dmlhsttpatempissueitemdtl.setStrSubGroupId(userValue[3]);
					dmlhsttpatempissueitemdtl.setStrRate(userValue[9]);
					dmlhsttpatempissueitemdtl.setStrRateUnitId(userValue[10]);

					debugPoint = 6;

					dmlhsttpatempissueitemdtl.setStrBalQty("0");
					dmlhsttpatempissueitemdtl.setStrBalQtyUnitId("");
					dmlhsttpatempissueitemdtl.setStrIssueQty(vo.getStrQtyText()[k]);
					dmlhsttpatempissueitemdtl.setStrIssueQtyUnitId(strInventoryUnitId); // Aritra,22nd June
					dmlhsttpatempissueitemdtl.setStrExpiryDate(userValue[16]);
					dmlhsttpatempissueitemdtl.setStrRemarks(vo.getStrRemarks());

					debugPoint = 7;

					dmlhsttpatempissueitemdtl.setStrCost("0");
					dmlhsttpatempissueitemdtl.setStrInHandQty(userValue[7]);
					dmlhsttpatempissueitemdtl.setStrInHandQtyUnitId(userValue[8]);
					dmlhsttpatempissueitemdtl.setStrManufDate(userValue[17]);
					dmlhsttpatempissueitemdtl.setStrReqNo(vo.getStrRequestNo());
					dmlhsttpatempissueitemdtl.setStrCrNo(vo.getStrPuk());

					debugPoint = 8;

					dmlhsttpatempissueitemdtl.setStrEmpNo(vo.getStrReqEmpNo());
					dmlhsttpatempissueitemdtl.setStrVisitNo(strVisitNo);
					dmlhsttpatempissueitemdtl.setStrEpisodeCode(strEpisodeCode);
					dmlhsttpatempissueitemdtl.setStrAdmNo(vo.getStrReqAdmNo());
					dmlhsttpatempissueitemdtl.setStrOrderBy(vo.getStrReqPrescribedBy());// Id od the consultant

					debugPoint = 9;

					dmlhsttpatempissueitemdtl.setStrDays(vo.getStrReqPrescribedFor());
					dmlhsttpatempissueitemdtl.setStrReqTypeId(vo.getStrReqTypeId());
					dmlhsttpatempissueitemdtl.setStrItemCatNo(vo.getStrItemCat());

					debugPoint = 10;

					dmlhsttpatempissueitemdtl.setStrDosage("0");
					dmlhsttpatempissueitemdtl.setStrFrequency("0");
					dmlhsttpatempissueitemdtl.setStrPresDays("0");

					dmlhsttpatempissueitemdtl.setStrPatientName(vo.getStrPatientDtlHidVal().split("\\^")[7]);//
					dmlhsttpatempissueitemdtl.setStrSeatId(vo.getStrSeatId());
					dmlhsttpatempissueitemdtl.setStrDrugIssueDate(vo.getStrDrugIssueDate());
					dmlhsttpatempissueitemdtl.setStrEpisodeCode(vo.getStrEpisodeCode());

					debugPoint = 11;

					dmlhsttpatempissueitemdtl.insert2(dao);

				}

			}

			System.out.println("------------- bill_interface.dml_direct_pharmacy ------------");

			String proc_name2 = "{call bill_interface.dml_direct_pharmacy(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?)}";
			// int procIndex2;
			procIndex2 = dao.setProcedure(proc_name2);

			dao.setProcInValue(procIndex2, "modval", "1", 1);
			dao.setProcInValue(procIndex2, "gnum_dept_code", vo.getStrDeptCode(), 2);
			dao.setProcInValue(procIndex2, "sblnum_chargetype_id",
					(vo.getStrRequestType().replace("^", "#").split("#")[0]).equals("35") ? "2" : "1", 3);
			dao.setProcInValue(procIndex2, "sblnum_service_id", "5", 4);
			dao.setProcInValue(procIndex2, "gstr_req_no", strIssueNo, 5);
			dao.setProcInValue(procIndex2, "gnum_treatment_cat",
					vo.getStrPatientDtlHidVal().replace("^", "#").split("#")[3], 6);
			dao.setProcInValue(procIndex2, "hrgnum_episode_code",
					vo.getStrEpisodeCode().replace("^", "#").split("#")[0], 7);
			dao.setProcInValue(procIndex2, "hrgnum_puk", vo.getStrPatientId(), 8);
			dao.setProcInValue(procIndex2, "hblnum_pat_lfaccount_no", "0", 9);
			dao.setProcInValue(procIndex2, "gstr_tariff", strBillTariff, 10);
			dao.setProcInValue(procIndex2, "gstr_tariff_batch", strBillBatch, 11);
			dao.setProcInValue(procIndex2, "gstr_tariff_rates", strBillRate, 12);
			dao.setProcInValue(procIndex2, "gstr_reqqty", strBillQty, 13);
			dao.setProcInValue(procIndex2, "hblstr_patient_name", "", 14);
			dao.setProcInValue(procIndex2, "hblstr_pat_address", "", 15);
			dao.setProcInValue(procIndex2, "hblstr_contact_no", "", 16);
			dao.setProcInValue(procIndex2, "age",
					vo.getStrPatientDtlHidVal().replace("^", "#").split("#")[10].split(" ")[0], 17);
			dao.setProcInValue(procIndex2, "ageunit", "1", 18);
			dao.setProcInValue(procIndex2, "gender", "1", 19);
			dao.setProcInValue(procIndex2, "refdoctor", "N/A", 20);
			dao.setProcInValue(procIndex2, "refdoccontactno", "0000000000", 21);
			dao.setProcInValue(procIndex2, "gnum_seatid", vo.getStrSeatId(), 22);
			dao.setProcInValue(procIndex2, "hosp_code", vo.getStrHospitalCode(), 23);
			dao.setProcInValue(procIndex2, "ward_code", "0", 24);
			dao.setProcInValue(procIndex2, "admno", "0", 25);
			dao.setProcInValue(procIndex2, "visitno", vo.getStrVisitNo(), 26);
			dao.setProcInValue(procIndex2, "pay_mode", vo.getStrPayModeVal().split("#")[0], 27);
			dao.setProcInValue(procIndex2, "pay_dtl", vo.getStrPayDtlVal(), 28);
			dao.setProcInValue(procIndex2, "net_cost", vo.getStrNetCost(), 29);

			dao.setProcOutValue(procIndex2, "err", 1, 30);
			dao.setProcOutValue(procIndex2, "bill_no_out", 1, 31);
			dao.execute(procIndex2, 1);

			debugPoint = 12;

			dmlhsttpatempissuedtl.setStrStoreId(vo.getStrStoreId());
			dmlhsttpatempissuedtl.setStrIssueNo(vo.getStrIssueNumber());
			dmlhsttpatempissuedtl.setStrHospitalCode(vo.getStrHospitalCode());
			dmlhsttpatempissuedtl.setStrRequestNo(vo.getStrRequestNo());
			dmlhsttpatempissuedtl.setStrOrderBy(vo.getStrReqPrescribedBy());

			debugPoint = 13;

			dmlhsttpatempissuedtl.setStrOrderDate(vo.getStrReqPrescriptionDate());
			dmlhsttpatempissuedtl.setStrDays(vo.getStrPrescriptionFor());
			dmlhsttpatempissuedtl.setStrCrNo(vo.getStrPuk());
			dmlhsttpatempissuedtl.setStrReqTypeId(vo.getStrReqTypeId());
			dmlhsttpatempissuedtl.setStrAdmNo(vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[0]);

			debugPoint = 14;

			dmlhsttpatempissuedtl.setStrEmpNo(vo.getStrReqEmpNo());
			dmlhsttpatempissuedtl.setStrItemCatNo(vo.getStrItemCat());
			dmlhsttpatempissuedtl.setStrFinalCost(DmlHsttPatEmpIssueItemDtlDAO.getIntCost() + "");
			dmlhsttpatempissuedtl.setStrFinStartDate(vo.getStrFinStartDate());
			dmlhsttpatempissuedtl.setStrFinEndDate(vo.getStrFinEndDate());

			debugPoint = 15;

			dmlhsttpatempissuedtl.setStrSeatId(vo.getStrSeatId());
			dmlhsttpatempissuedtl.setStrDeptUnitCode(vo.getStrUnitCode());
			dmlhsttpatempissuedtl.setStrVisitType("2");// hardcoded in case of ipd patient
			dmlhsttpatempissuedtl.setStrDeptCode(vo.getStrDeptCode());

			dmlhsttpatempissuedtl.setStrWardCode(vo.getStrReqWardCode());

			debugPoint = 16;

			dmlhsttpatempissuedtl.setStrReceiveBy(vo.getStrReceiveBy());
			dmlhsttpatempissuedtl.setStrRemarks(vo.getStrRemarks());
			dmlhsttpatempissuedtl.setStrReqDate("");
			dmlhsttpatempissuedtl.setStrVisitNo(strVisitNo);
			dmlhsttpatempissuedtl.setStrEpisoCode(strEpisodeCode);

			debugPoint = 17;

			itemValue += " PatientHiddenValue1 :: " + vo.getStrPatientHiddenValue1() + " StrPatientDtlHidVal :: "
					+ vo.getStrPatientDtlHidVal();

			dmlhsttpatempissuedtl.setStrFirstName(vo.getStrPatientDtlHidVal().split("\\^")[7]);
			dmlhsttpatempissuedtl.setStrMiddelName("");
			dmlhsttpatempissuedtl.setStrLastName("");
			dmlhsttpatempissuedtl.setStrPatientId(vo.getStrPatientId());
			dmlhsttpatempissuedtl.setStrPatientType("18");

			debugPoint = 18;

			dmlhsttpatempissuedtl.setStrPatientAge(vo.getStrPatientDtlHidVal().split("\\^")[0]);
			dmlhsttpatempissuedtl.setStrPatientAgeUnit("0");
			dmlhsttpatempissuedtl.setStrPatientFatherName(vo.getStrPatientDtlHidVal().split("\\^")[8]);
			dmlhsttpatempissuedtl.setStrPatientGenderCode(vo.getStrPatientDtlHidVal().split("\\^")[1]);

			debugPoint = 19;

			dmlhsttpatempissuedtl.setStrPatientAddress(vo.getStrPatientHiddenValue1().split("\\^")[3]);
			dmlhsttpatempissuedtl.setStrTransType("1"); // With CR No
			dmlhsttpatempissuedtl.setStrDrugIssueDate(vo.getStrDrugIssueDate());
			dmlhsttpatempissuedtl.setStrOutOfStockFlag(vo.getStrOutOfStockFlag());

			debugPoint = 20;

			dmlhsttpatempissuedtl.insert(dao);

			// DAO Fire
			synchronized (dao) {
				dao.fire();
			}

			debugPoint = 21;

			vo.setStrBillNo(dao.getString(procIndex2, "bill_no_out"));
			System.out.println("----- vo.setStrBillNo----" + vo.getStrBillNo());

			System.out.println("------------- IssueToPatOPDTransDAO.directIssue ------ END -------");

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgType("1");
			vo.setStrMsgString("IssueToPatOPDTransDAO.insert() --> " + e.getMessage() + " DAO_DEBUG_POINT :: "
					+ debugPoint + " DAO_VALUE :: " + itemValue);
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}



	public static void getEpisodeDtl(IssueToPatOPDTransVO voObj) {
		// TODO Auto-generated method stub

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_simple_view.proc_hrgt_episode_unit_based_dtl(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strDeptCode = voObj.getStrDeptCode();// Admitted Department/Last Visited Department
		String strCrNo = voObj.getStrCrNo();
		String strUnit = voObj.getStrUnitCode();

		String strErr = "";

		try {

			System.out.println("------------- IssueToPatOPDTransDAO.getEpisodeDtl -------------");

			System.out.println(
					"------------- pkg_simple_view.proc_hrgt_episode_unit_based_dtl --[ Mode - 1 ]-----------");

			daoObj = new HisDAO("mms", "IssueToPatOPDTransDAO.getEpisodeDtl");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "deptcode", strDeptCode, 2);
			daoObj.setProcInValue(nProcIndex, "unitcode", strUnit, 3);
			daoObj.setProcInValue(nProcIndex, "puk", strCrNo, 4);
			daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 5);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				voObj.setStrOffLineEpisodeValues(ws);
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			voObj.setStrMsgString("IssueToPatOPDTransDAO.getEpisodeDtl() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void getPresFormDtl(IssueToPatOPDTransVO voObj) {
		// TODO Auto-generated method stub

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_simple_view.proc_hrgt_visittype_episode_based_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strEpisodeCode = voObj.getStrEpisodeCode();
		String strCrNo = voObj.getStrCrNo();

		String strErr = "";

		try {
			System.out.println("------------- IssueToPatOPDTransDAO.getPresFormDtl -------------");

			System.out.println(
					"------------- pkg_simple_view.proc_hrgt_visittype_episode_based_dtl --[ Mode - 1 ]-----------");

			daoObj = new HisDAO("mms", "IssueToPatOPDTransDAO.getEpisodeDtl");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "episodecode", strEpisodeCode, 2);
			daoObj.setProcInValue(nProcIndex, "puk", strCrNo, 3);
			daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 4);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 5);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				voObj.setStrPrescFormValues(ws);
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			voObj.setStrMsgString("IssueToPatOPDTransDAO.getEpisodeDtl() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void getAccountDtl(IssueToPatOPDTransVO VO) {
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.PROC_HBLT_PATACCOUNT_DTL(?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		int procIndex1 = 0;
		String strerr = "";
		WebRowSet ws = null;
		try {
			System.out.println("------------- IssueToPatOPDTransDAO.getAccountDtl -------------");

			System.out.println("------------- PKG_BILL_VIEW.PROC_HBLT_PATACCOUNT_DTL --[ Mode - 12 ]-----------");

			dao = new HisDAO("mms", "IssueToPatOPDTransDAO.getAccountDtlWithAcctNo()");
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "accNo", "", 1);
			dao.setProcInValue(procIndex1, "modeVal", "12", 5);
			dao.setProcInValue(procIndex1, "puk", VO.getStrCrNo(), 2);
			dao.setProcInValue(procIndex1, "chargeTypeId", "", 3);
			dao.setProcInValue(procIndex1, "activeAccount", "", 4);
			dao.setProcInValue(procIndex1, "hosp_code", VO.getStrHospitalCode(), 6);
			dao.setProcOutValue(procIndex1, "ERR", 1, 7);
			dao.setProcOutValue(procIndex1, "RESULTSET", 2, 8);
			dao.executeProcedureByPosition(procIndex1);
			strerr = dao.getString(procIndex1, "ERR");

			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "RESULTSET");
				VO.setStrAccDtl(ws);

				VO.setStrMsgType("0");
			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			VO.setStrMsgString("IssueToPatOPDTransDAO.getAccountDtl() --> " + e.getMessage());
			VO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getdeptname(IssueToPatOPDTransVO vo) {
		int nFuncIndex;
		String strFuncName2 = "";
		String deptname = "";
		HisDAO dao = null;
		try {
			System.out.println("------------- IssueToPatOPDTransDAO.getdeptname -------------");

			System.out.println("------------- ipd_MST.getdeptname --[ Mode - 12 ]-----------");

			dao = new HisDAO("mms", "IssueToPatOPDTransDAO.getdeptname()");
			strFuncName2 = "{? = call ipd_MST.getdeptname(?,?)}";
			nFuncIndex = dao.setFunction(strFuncName2);
			dao.setFuncInValue(nFuncIndex, 2, vo.getStrDeptCode());
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			deptname = dao.getFuncString(nFuncIndex);
			vo.setStrDeptName(deptname);
		} catch (Exception e) {
			vo.setStrMsgString("IssueToPatOPDTransDAO.getdeptname() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getOPDPatientDtls(IssueToPatOPDTransVO vo) {
		int nFuncIndex;
		String strFuncName2 = "";
		String opdPatDtls = "";
		HisDAO dao = null;
		try {
			System.out.println("------------- IssueToPatOPDTransDAO.getOPDPatientDtls -------------");

			System.out.println("------------- MMS_MST.get_opd_patient_dtl --[ Mode - 1 ]-----------");

			dao = new HisDAO("mms", "IssueToPatOPDTransDAO.getdeptname()"); // String moduleName, String fileName
			strFuncName2 = "{? = call MMS_MST.get_opd_patient_dtl(?,?,?)}";
			System.out.println("---getStrHospitalCode-----" + vo.getStrHospitalCode());
			System.out.println("---getStrPuk-----" + vo.getStrPuk());

			nFuncIndex = dao.setFunction(strFuncName2);
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrPuk());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			opdPatDtls = dao.getFuncString(nFuncIndex);
			vo.setStrOPDDetails(opdPatDtls);
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IssueToPatOPDTransDAO.getOPDPatientDtls() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	/*
	 * IN USE
	 */

	public static synchronized void DIRECTISSUE_OFFLINE(IssueToPatOPDTransVO vo) {
		HisDAO dao = null;
		String strFuncName = "";
		int nFuncIndex = 0;
		int length = 0;
		String paramVal[] = null;
		String userValue[] = null;
		String strIssueNo = "";
		String strVisitDtl = "";
		Double netCost = 0.00;

		int debugPoint = 0;
		String itemValue = "";
		String strIssueUnitId = "0";
		int nProcIndex = 0, procIndex2 = 0, nProcIndex3 = 0;

		String strProcName, strProcName3;
		String strBillTariff = "";
		String strBillBatch = "";
		String strBillRate = "";
		String strBillQty = "";
		try {

			System.out.println("------------- IssueToPatOPDTransDAO.DIRECTISSUE_OFFLINE ------  START ------");

			debugPoint = 1;
			dao = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");

			System.out.println("------------- MMS_MST.generate_issueNo ------  A ------");

			strFuncName = "{? = call MMS_MST.generate_issueNo(?::numeric,?::numeric,?::numeric,?::numeric)}";
			nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId());
			dao.setFuncInValue(nFuncIndex, 4, "32");
			dao.setFuncInValue(nFuncIndex, 5, "0");
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strIssueNo = dao.getFuncString(nFuncIndex);

			

			vo.setStrIssueNumber(strIssueNo.split("\\^")[0]);
			
			System.out.println("Issue No---" + vo.getStrIssueNumber());

			debugPoint = 2;
			dao = new HisDAO("MMS Transactions", "IssueToPatOPDTransDAO");
			length = vo.getItemParamValue().length;

			System.out.println("-------------Pkg_Mms_Dml2.Dml_Patemp_Issue_Items_Dtls ------  B ---[ Issue Drug Count "
					+ length + " ]---");

			String[] temp = vo.getStrOPDDetails().split("\\$");

			for (int k = 0; k < length; k++) {
				/**
				 * Hidden Values corresponding to particular ITEM DETAILS
				 */
				debugPoint = 3;
				if (vo.getStrQtyText()[k] != null && vo.getStrQtyText()[k].length() > 0
						&& !vo.getStrQtyText()[k].equals("0")) {
					itemValue = vo.getItemParamValue()[k];

					paramVal = vo.getItemParamValue()[k].split("#");
					userValue = vo.getItemUserValue()[k].replace('^', '#').split("#");

					debugPoint = 4;

					if (strBillTariff != null && strBillTariff != "") {

						strBillTariff = strBillTariff + "^" + userValue[1];
					} else {
						strBillTariff = userValue[1];
					}
					if(vo.getStrHospitalCode().equals("98926"))
					{
						if (strBillRate != null && strBillRate != "") {
							strBillRate = strBillRate + "^0";
						} else {
							strBillRate = "0";
						}
					}
					else
					{
						if (strBillRate != null && strBillRate != "") {
							strBillRate = strBillRate + "^" + userValue[9];
						} else {
							strBillRate = userValue[9];
						}
						
					}
					if (strBillQty != null && strBillQty != "") {
						strBillQty = strBillQty + "^" + vo.getStrQtyText()[k];
					} else {
						strBillQty = vo.getStrQtyText()[k];
					}
					if (strBillBatch != null && strBillBatch != "") {
						strBillBatch = strBillBatch + "^" + userValue[15];
					} else {
						strBillBatch = userValue[15];
					}

					strProcName = "{call Pkg_Mms_Dml2.Dml_Patemp_Issue_Items_Dtls(?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?   ,?,?,?,?)}";// 44
					nProcIndex = dao.setProcedure(strProcName);

					System.out.println("issue no---" + vo.getStrIssueNumber());
					System.out.println("getStrStoreId---" + vo.getStrStoreId());
					System.out.println("Item_Id---" + userValue[0]);
					System.out.println("Brand_Id---" + userValue[1]);
					System.out.println("Batch_No---" + userValue[15]);
					System.out.println("Req_Qty--" + k + "--" + vo.getStrQtyText()[k]);
					System.out.println("manuf_date---" + userValue[17]);
					System.out.println("expiry_date---" + userValue[16]);
					System.out.println("getStrPuk---" + vo.getStrPuk());
					System.out.println("getStrSeatId---" + vo.getStrSeatId());
					System.out.println("getStrHospitalCode---" + vo.getStrHospitalCode());

					dao.setProcInValue(nProcIndex, "modeval", "1", 1);
					dao.setProcInValue(nProcIndex, "issueNo", vo.getStrIssueNumber(), 2);
					dao.setProcInValue(nProcIndex, "req_No", "0", 3);
					dao.setProcInValue(nProcIndex, "issuing_store_id", vo.getStrStoreId(), 4);
					dao.setProcInValue(nProcIndex, "reserved_qty_flag", "0", 5);
					dao.setProcInValue(nProcIndex, "category_no", "0", 6);
					dao.setProcInValue(nProcIndex, "reqType_id", vo.getStrReqTypeId(), 7);
					dao.setProcInValue(nProcIndex, "item_id", userValue[0], 8);
					dao.setProcInValue(nProcIndex, "item_brand_id", userValue[1], 9);
					dao.setProcInValue(nProcIndex, "batchSl_no", userValue[15], 10);
					dao.setProcInValue(nProcIndex, "hospital_code", vo.getStrHospitalCode(), 11);
					dao.setProcInValue(nProcIndex, "item_SlNo", "0", 12);
					dao.setProcInValue(nProcIndex, "stock_status_code", "10", 13);

					dao.setProcInValue(nProcIndex, "group_id", userValue[2], 14);
					dao.setProcInValue(nProcIndex, "subgroup_id", userValue[3], 15);
					dao.setProcInValue(nProcIndex, "inhand_qty", userValue[7], 16);
					dao.setProcInValue(nProcIndex, "inhand_qty_unitid", userValue[8], 17);
					dao.setProcInValue(nProcIndex, "bal_qty", "0", 18);
					dao.setProcInValue(nProcIndex, "bal_qty_unitid", "6301", 19);
					dao.setProcInValue(nProcIndex, "issue_qty", vo.getStrQtyText()[k], 20);
					dao.setProcInValue(nProcIndex, "issue_qty_unitid", userValue[11], 21);
					dao.setProcInValue(nProcIndex, "manuf_date", userValue[17], 22);
					dao.setProcInValue(nProcIndex, "expiry_date", userValue[16], 23);
					dao.setProcInValue(nProcIndex, "rate", userValue[9], 24);
					dao.setProcInValue(nProcIndex, "rate_unitid", userValue[10], 25);
					dao.setProcInValue(nProcIndex, "comsumable_flag", "0", 26);
					dao.setProcInValue(nProcIndex, "empNo", "0", 27);
					dao.setProcInValue(nProcIndex, "crNo", vo.getStrPuk(), 28);
					dao.setProcInValue(nProcIndex, "strEpiCode", temp[3], 29);
					dao.setProcInValue(nProcIndex, "strVisitNo", temp[4], 30);
					dao.setProcInValue(nProcIndex, "strAdmNo", temp[7], 31);
					dao.setProcInValue(nProcIndex, "strOrderBy", "NA", 32);
					dao.setProcInValue(nProcIndex, "days", "0", 33);
					dao.setProcInValue(nProcIndex, "cost", "0", 34);
					dao.setProcInValue(nProcIndex, "remarks", "Issue To OPD Patient", 35);
					dao.setProcInValue(nProcIndex, "seatId", vo.getStrSeatId(), 36);
					dao.setProcInValue(nProcIndex, "isUpdateOpdDrugReqDtl", "1", 37);
					dao.setProcInValue(nProcIndex, "dosage", "0", 38);
					dao.setProcInValue(nProcIndex, "frequency", "0", 39);
					dao.setProcInValue(nProcIndex, "presdays", "1", 40);
					dao.setProcInValue(nProcIndex, "patName", vo.getStrPatientDtlHidVal().split("\\^")[7], 41);
					dao.setProcInValue(nProcIndex, "issuedate", "", 42);
					dao.setProcOutValue(nProcIndex, "err", 1, 43);
					dao.setProcOutValue(nProcIndex, "costOut", 1, 44);
					dao.execute(nProcIndex, 1);
					/*
					 * 1 $'||v_patient_status_code||'$'||v_reg_cat_code
					 * ||'$'||v_hrgnum_episode_code||'$'||v_hrgnum_visit_no ||'$'||v_gnum_dept_code
					 * ||'$'||v_gnum_deptunit_code
					 * ||'$'||v_hipnum_admno||'$'||AHIS_FUNCTION.getDeptName(v_gnum_dept_code,
					 * hosp_code);
					 * 
					 * '2 $'||v_patient_status_code||'$'||v_reg_cat_code||'$'||'IPD Patient Cr No
					 * ['||crno||'] Not Allowed !!';
					 * 
					 */

				}

			}
			System.out.println("-------------Pkg_Mms_Dml2.Dml_Patemp_Issue_Dtls ------  C ------");

			strProcName3 = "{call Pkg_Mms_Dml2.Dml_Patemp_Issue_Dtls(?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?    ,?,?,?,?,?)}";// 40
			nProcIndex3 = dao.setProcedure(strProcName3);

			/*
			 * 1 $'||v_patient_status_code||'$'||v_reg_cat_code
			 * ||'$'||v_hrgnum_episode_code||'$'||v_hrgnum_visit_no ||'$'||v_gnum_dept_code
			 * ||'$'||v_gnum_deptunit_code
			 * ||'$'||v_hipnum_admno||'$'||AHIS_FUNCTION.getDeptName(v_gnum_dept_code,
			 * hosp_code);
			 * 
			 * '2 $'||v_patient_status_code||'$'||v_reg_cat_code||'$'||'IPD Patient Cr No
			 * ['||crno||'] Not Allowed !!';
			 * 
			 */
			dao.setProcInValue(nProcIndex3, "modeval", "3", 1);// 1
			dao.setProcInValue(nProcIndex3, "strStoreId", vo.getStrStoreId(), 2);// 2
			dao.setProcInValue(nProcIndex3, "req_No", "0", 3);
			dao.setProcInValue(nProcIndex3, "strIssueNo", vo.getStrIssueNumber(), 4); // 3
			dao.setProcInValue(nProcIndex3, "hosp_code", vo.getStrHospitalCode(), 5);// 4
			dao.setProcInValue(nProcIndex3, "strOrderBy", "NA", 6);// 6
			dao.setProcInValue(nProcIndex3, "strOrderDate", "NA", 7);// 7
			dao.setProcInValue(nProcIndex3, "days", "0", 8); // 8
			dao.setProcInValue(nProcIndex3, "strCrNo", vo.getStrPuk(), 9);// 9
			dao.setProcInValue(nProcIndex3, "strReqTypeId", vo.getStrReqTypeId(), 10);// 10
			dao.setProcInValue(nProcIndex3, "stradmno", temp[7], 11);// 11
			dao.setProcInValue(nProcIndex3, "strempno", "0", 12);// 12
			dao.setProcInValue(nProcIndex3, "strItemCatNo", "0", 13);// 13
			dao.setProcInValue(nProcIndex3, "strFinalCost", "0", 14); // 14
			dao.setProcInValue(nProcIndex3, "strFinStartDate", "", 15);// 15
			dao.setProcInValue(nProcIndex3, "strFinEndDate", "", 16);// 16

			dao.setProcInValue(nProcIndex3, "strSeatId", vo.getStrSeatId(), 17);// 17
			dao.setProcInValue(nProcIndex3, "strDeptUnitCode", temp[6], 18);// 18
			dao.setProcInValue(nProcIndex3, "strVisitType", temp[1], 19);// 19
			dao.setProcInValue(nProcIndex3, "strDeptCode", temp[5], 20);// 20
			dao.setProcInValue(nProcIndex3, "strWardCode", "0", 21); // 21
			dao.setProcInValue(nProcIndex3, "strRecieveBy", "0", 22); // 22
			dao.setProcInValue(nProcIndex3, "strRemarks", "Issue to OPD Patient", 23);// 23
			dao.setProcInValue(nProcIndex3, "strReqDate", "0", 24);// 24
			dao.setProcInValue(nProcIndex3, "strEpiCode", temp[3], 25);// 25
			dao.setProcInValue(nProcIndex3, "strVisitNo", temp[4], 26);// 26

			dao.setProcInValue(nProcIndex3, "p_first_name", vo.getStrPatientDtlHidVal().split("\\^")[7], 27);// 27
			dao.setProcInValue(nProcIndex3, "p_middle_name", "-", 28); // 28
			dao.setProcInValue(nProcIndex3, "p_last_name", "-", 29); // 29
			dao.setProcInValue(nProcIndex3, "p_hststr_father_name", "-", 30);// 32
			dao.setProcInValue(nProcIndex3, "p_hstdt_age",
					vo.getStrPatientDtlHidVal().replace("^", "#").split("#")[10].split(" ")[0], 31);// 33
			dao.setProcInValue(nProcIndex3, "p_gnum_gender_code",
					vo.getStrPatientDtlHidVal().replace("^", "#").split("#")[1], 32);// 34
			dao.setProcInValue(nProcIndex3, "p_hststr_address", "NA", 33);// 35
			dao.setProcInValue(nProcIndex3, "p_hststr_patient_id", "0", 34);
			dao.setProcInValue(nProcIndex3, "p_hstnum_patient_type", "0", 35);

			dao.setProcInValue(nProcIndex3, "p_trans_type", "0", 36);// 36

			dao.setProcInValue(nProcIndex3, "p_age_unit", "0", 37);// 37

			dao.setProcInValue(nProcIndex3, "p_issue_date", "", 38);// 38
			dao.setProcInValue(nProcIndex3, "p_out_stock", "0", 39);// 39

			dao.setProcOutValue(nProcIndex3, "err", 1, 40);// 40

			dao.execute(nProcIndex3, 1);
			
			
				System.out.println("------------- bill_interface.dml_direct_pharmacy ------  D ------");
	
				String proc_name2 = "{call bill_interface.dml_direct_pharmacy(?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?)}";
				// int procIndex2;
				procIndex2 = dao.setProcedure(proc_name2);
	
				System.out.println("---------------------------");
				System.out.println("strBillTariff-----" + strBillTariff);
				System.out.println("strBillRate-------" + strBillRate);
				System.out.println("strBillQty--------" + strBillQty);
				System.out.println("strBillBatch------" + strBillBatch);
				System.out.println("---------------------------");
	
				/*
				 * 1 $'||v_patient_status_code||'$'||v_reg_cat_code
				 * ||'$'||v_hrgnum_episode_code||'$'||v_hrgnum_visit_no ||'$'||v_gnum_dept_code
				 * ||'$'||v_gnum_deptunit_code
				 * ||'$'||v_hipnum_admno||'$'||AHIS_FUNCTION.getDeptName(v_gnum_dept_code,
				 * hosp_code);
				 * 
				 * '2 $'||v_patient_status_code||'$'||v_reg_cat_code||'$'||'IPD Patient Cr No
				 * ['||crno||'] Not Allowed !!';
				 * 
				 */
				dao.setProcInValue(procIndex2, "modval", "1", 1);
				dao.setProcInValue(procIndex2, "gnum_dept_code", vo.getStrDeptCode(), 2);
				// dao.setProcInValue(procIndex2, "sblnum_chargetype_id",
				// vo.getStrRequestType().equals("35")?"2":"1" , 3);
				dao.setProcInValue(procIndex2, "sblnum_chargetype_id", temp[1], 3);
				dao.setProcInValue(procIndex2, "sblnum_service_id", "5", 4);
				dao.setProcInValue(procIndex2, "gstr_req_no", vo.getStrIssueNumber(), 5);
				dao.setProcInValue(procIndex2, "gnum_treatment_cat", temp[2], 6);
				dao.setProcInValue(procIndex2, "hrgnum_episode_code", temp[3], 7);
				dao.setProcInValue(procIndex2, "hrgnum_puk", vo.getStrPuk(), 8);
				dao.setProcInValue(procIndex2, "hblnum_pat_lfaccount_no", "0", 9);
				dao.setProcInValue(procIndex2, "gstr_tariff", strBillTariff, 10);
				dao.setProcInValue(procIndex2, "gstr_tariff_batch", strBillBatch, 11);				
				dao.setProcInValue(procIndex2, "gstr_tariff_rates", strBillRate, 12);				
				dao.setProcInValue(procIndex2, "gstr_reqqty", strBillQty, 13);
				dao.setProcInValue(procIndex2, "hblstr_patient_name", vo.getStrPatientDtlHidVal().split("\\^")[7], 14);
				dao.setProcInValue(procIndex2, "hblstr_pat_address", "-", 15);
				dao.setProcInValue(procIndex2, "hblstr_contact_no", "0", 16);
				dao.setProcInValue(procIndex2, "age",vo.getStrPatientDtlHidVal().replace("^", "#").split("#")[10].split(" ")[0], 17);
				dao.setProcInValue(procIndex2, "ageunit", "1", 18);
				dao.setProcInValue(procIndex2, "gender", "1", 19);
				dao.setProcInValue(procIndex2, "refdoctor", "N/A", 20);
				dao.setProcInValue(procIndex2, "refdoccontactno", "0000000000", 21);
				dao.setProcInValue(procIndex2, "gnum_seatid", vo.getStrSeatId(), 22);
				dao.setProcInValue(procIndex2, "hosp_code", vo.getStrHospitalCode(), 23);
				dao.setProcInValue(procIndex2, "ward_code", "0", 24);
				dao.setProcInValue(procIndex2, "admno", "0", 25);
				dao.setProcInValue(procIndex2, "visitno", temp[4], 26);
				dao.setProcInValue(procIndex2, "pay_mode", vo.getStrPayModeVal().split("#")[0], 27);
				dao.setProcInValue(procIndex2, "pay_dtl", vo.getStrPayDtlVal(), 28);
				dao.setProcInValue(procIndex2, "net_cost", vo.getStrNetCost(), 29);
				dao.setProcOutValue(procIndex2, "err", 1, 30);
				dao.setProcOutValue(procIndex2, "bill_no_out", 1, 31);
				dao.execute(procIndex2, 1);
			

			System.out.println("------------- bill_interface.dml_direct_pharmacy ------ END ------");

			dao.fire();

			debugPoint = 21;

			vo.setStrBillNo(dao.getString(procIndex2, "bill_no_out"));
			System.out.println("----- vo.setStrBillNo----" + vo.getStrBillNo());

			System.out.println("------------- IssueToPatOPDTransDAO.DIRECTISSUE_OFFLINE ------ END -------");

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgType("1");
			vo.setStrMsgString("IssueToPatOPDTransDAO.insert() --> " + e.getMessage() + " DAO_DEBUG_POINT :: "
					+ debugPoint + " DAO_VALUE :: " + itemValue);
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}

	 public static void getImageHeader(IssueToPatOPDTransVO voObj)
		{
			String strFuncName = "";
			String strLogoName = "";
			
			int nFuncIndex = 0;
			HisDAO dao = null;
			try 
			{
				dao = new HisDAO("DWH","BreakageAndLostDrugDetailsRptDAO");
				
				strFuncName = "{? = call MMS_MST.logo_config_dtl(?,?)}";
				nFuncIndex = dao.setFunction(strFuncName);
				
				dao.setFuncInValue(nFuncIndex, 2, "1");
				dao.setFuncInValue(nFuncIndex, 3, voObj.getStrHospitalCode());
				dao.setFuncOutValue(nFuncIndex, 1);
				
				dao.executeFunction(nFuncIndex);
				
				strLogoName = dao.getFuncString(nFuncIndex);
				voObj.setStrLogoName(strLogoName);
				//System.out.println("======strLogoName======="+strLogoName);

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
	 
	 
	 /**
		 * Gets the issue dtls list.
		 * 
		 * @param vo the vo
		 * 
		 * @return the issue dtls list This Function is Used To Get Ajax Voucher Details
		 */// Modified by Neha Sharma on 16th July 2013 ..
		public static void getPrintIssueDtls(IssueToPatOPDTransVO vo) {
			String err;
			// String strSlNoflg;
			HisDAO dao = null;
			WebRowSet ws = null;
			int procIndex1 = 0;
			String proc_name1 = "{call pkg_mms_view.Proc_Emp_Issue_Detail(?,?,?,?,?,?)}"; // 6
			try {
				System.out.println(" ------- IssueToPatOPDTransDAO .getPrintIssueDtls  -------- ");
				System.out.println(" ------- pkg_mms_view.Proc_Emp_Issue_Detail  --[ Mode- 3 ]------ ");

				/*
				 * Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line
				 * Issue Voucher) 1.Hospital Name ^ DDC Name ^ Prescribe For ^ Issue No ^ Issued
				 * By Doctor ^ Date ^ Cr No ^ Hindi Text 2.Drug Name 3.Batch No 4.Exp Date
				 * 5.Issue Qty
				 */
				dao = new HisDAO("mms", "global.IssueToPatOPDTransDAO.getStockItemDtlsList(IssueToPatOPDTransVO vo)");
				procIndex1 = dao.setProcedure(proc_name1);
				// set value
				dao.setProcInValue(procIndex1, "modeval", "3", 1);
				dao.setProcInValue(procIndex1, "strId", vo.getStrStoreId(), 3);
				if (vo.getStrIssueNo() == null || vo.getStrIssueNo() == "")
					dao.setProcInValue(procIndex1, "issueNo", "0", 2);
				else
					dao.setProcInValue(procIndex1, "issueNo", vo.getStrIssueNo(), 2);
				dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(), 4);
				dao.setProcOutValue(procIndex1, "ERR", 1, 5); // 1 for string return
				dao.setProcOutValue(procIndex1, "RESULTSET", 2, 6); // 2 for object
				// execute procedure
				dao.executeProcedureByPosition(procIndex1);
				// get value
				err = dao.getString(procIndex1, "ERR");
				if (err == null)
					err = "";
				ws = dao.getWebRowSet(procIndex1, "RESULTSET");
				vo.setWsIssueDetails(ws);
			} catch (Exception e) {
				e.printStackTrace();
				// e.printStackTrace();
				vo.setStrMsgString("IssueToPatOPDTransDAO.getIssueDtlsList() --> " + e.getMessage());
				vo.setStrMsgType("1");

			} finally {

				if (dao != null) {
					dao.free();
					dao = null;
				}

			}

		}
	 
	 

}
