package mms.transactions.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.MmsConfigUtil;
import mms.transactions.controller.fb.OPDIssueToPatAutoTransFB;
import mms.transactions.vo.OPDIssueToPatAutoTransVO;



public class OPDIssueToPatAutoTransDAO 
{
	
	public static void getCRNO_PatientDtl(OPDIssueToPatAutoTransVO  vo) 
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
	public static void getIssueConfigFlag(OPDIssueToPatAutoTransVO vo) 
	{
		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		try {
			dao = new HisDAO("MMSModule", "OPDIssueToPatAutoTransDAO");

			funcIndex = dao.setFunction("{? = call MMS_MST.config_dtl(?,?,?)}");

			System.out.println(
					" ------- OPDIssueToPatAutoTransDAO .MMS_MST.config_dtl  --[ 0 - On-Line , 1 - Off-Line]------ ");

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
			vo.setStrMsgString("OPDIssueToPatAutoTransDAO.getIssueConfigFlag() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void getApprovedByCombo(OPDIssueToPatAutoTransVO vo)

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

	public static void getPatientCRStatus(OPDIssueToPatAutoTransVO vo) {

		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		try {
			dao = new HisDAO("MMSModule", "OPDIssueToPatAutoTransDAO");

			funcIndex = dao.setFunction("{? = call MMS_MST.get_crno_status_code(?,?)}");

			System.out.println(
					" ------- OPDIssueToPatAutoTransDAO .MMS_MST.get_crno_status_code  --[ 2 - IPD Patient , 3- OPD Patinet]------ ");

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
			vo.setStrMsgString("OPDIssueToPatAutoTransDAO.getPatientAddmissionFlag() --> " + e.getMessage());
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
	public static void getIssueDtlsList(OPDIssueToPatAutoTransVO vo) {
		String err;
		// String strSlNoflg;
		HisDAO dao = null;
		WebRowSet ws = null;
		int procIndex1 = 0;
		String proc_name1 = "{call pkg_mms_view.Proc_Emp_Issue_Detail(?,?,?,?,?,?)}"; // 6
		try {
			System.out.println(" ------- OPDIssueToPatAutoTransDAO .getIssueDtlsList  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_Emp_Issue_Detail  --[ Mode- 2 ]------ ");

			/*
			 * Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line
			 * Issue Voucher) 1.Hospital Name ^ DDC Name ^ Prescribe For ^ Issue No ^ Issued
			 * By Doctor ^ Date ^ Cr No ^ Hindi Text 2.Drug Name 3.Batch No 4.Exp Date
			 * 5.Issue Qty
			 */
			dao = new HisDAO("mms", "global.OPDIssueToPatAutoTransDAO.getStockItemDtlsList(OPDIssueToPatAutoTransVO vo)");
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
			vo.setStrMsgString("OPDIssueToPatAutoTransDAO.getIssueDtlsList() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	public static void getStoreList(OPDIssueToPatAutoTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		try {
			System.out.println(" ------- OPDIssueToPatAutoTransDAO .getStoreList  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_hstt_store_mst  --[ Mode- 12 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "OPDIssueToPatAutoTransDAO");
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
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("OPDIssueToPatAutoTransDAO.getStoreList() --> " + e.getMessage());
			voObj.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getViewStoreList(OPDIssueToPatAutoTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- OPDIssueToPatAutoTransDAO .getViewStoreList  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_hstt_store_mst  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "OPDIssueToPatAutoTransDAO");

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
			voObj.setStrMsgString("OPDIssueToPatAutoTransDAO.getViewStoreList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	
	public static void getItemCatDtls(OPDIssueToPatAutoTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- OPDIssueToPatAutoTransDAO .getItemCatDtls  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_item_category_list  --[ Mode- 7 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "OPDIssueToPatAutoTransDAO");

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
			voObj.setStrMsgString("OPDIssueToPatAutoTransDAO.getItemCatDtls() --> " + e.getMessage());
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
	public static void getItemBrandList(OPDIssueToPatAutoTransVO vo) {

		String err = "";
		String proc_name1 = "";

		proc_name1 = "{call pkg_mms_view.Proc_Itembrand_Detail(?,?,?,?,?   ,?,?,?,?,?   ,?)}"; // 11

		System.out.println("-- OPDIssueToPatAutoTransDAO . getItemBrandList -- - " + proc_name1 + " - [ Mode - 8 ]---");

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms", "OPDIssueToPatAutoTransDAO.getItemBrandList(OPDIssueToPatAutoTransVO vo)");

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

	public static void GET_PAT_ACC_STATUS(OPDIssueToPatAutoTransVO vo) {
		String proc_name1 = "";
		proc_name1 = "{call PKG_MMS_VIEW.PROC_HBLT_PATACCOUNT_DTL(?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		int procIndex1 = 0;
		String strerr = "";
		WebRowSet ws = null;
		try {
			System.out.println("------------- OPDIssueToPatAutoTransDAO.GET_PAT_ACC_STATUS -------------");

			System.out.println("------------- PKG_MMS_VIEW.PROC_HBLT_PATACCOUNT_DTL --[ Mode - 14 ]-----------");

			/*
			 * 0 - Ac Balance 1 - Patient Catg Code 2 - ADMISSION_DATE 3 - DISCHARGE_DATE 4
			 * - PATACCOUNT_STATUS in Text 5 - HBLNUM_PATACCOUNT_STATUS 6 - GETCATGRP 7 -
			 * HBLNUM_ACCOUNT_TYPE 8 - hblnum_finalbill_flag
			 * 
			 */
			dao = new HisDAO("mms", "OPDIssueToPatAutoTransDAO.getAccountDtlWithAcctNo()");
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
			vo.setStrMsgString("OPDIssueToPatAutoTransDAO.GET_PAT_ACC_STATUS() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/* ==For View Page== */
	public static void getItemCatDtls1(OPDIssueToPatAutoTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- OPDIssueToPatAutoTransDAO .getItemCatDtls1  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_item_category_list  --[ Mode- 3 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "OPDIssueToPatAutoTransDAO");

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
			voObj.setStrMsgString("OPDIssueToPatAutoTransDAO.getItemCatDtls() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void getissuetopatient(OPDIssueToPatAutoTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String proc_name1 = "{call Pkg_Mms_View.proc_patient_issue_drug_dtl(?,?,? ,?,?,? ,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";
		System.out.println("<------------- OPDIssueToPatAutoTransDAO.getissuetopatient ------------->");

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
			vo.setStrMsgString("OPDIssueToPatAutoTransDAO.getIssueDetailTwo() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getCancelIssueDtls(OPDIssueToPatAutoTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_issue_item_dtls(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			System.out.println(" ------- OPDIssueToPatAutoTransDAO .getCancelIssueDtls  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_issue_item_dtls  --[ Mode- 3 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "OPDIssueToPatAutoTransDAO");
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
			voObj.setStrMsgString("OPDIssueToPatAutoTransDAO.getCancelIssueDtls() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	

	public static void getIssueDetail(OPDIssueToPatAutoTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		//String strProcName = "{call Pkg_Mms_View.Proc_Issue_Details(?,?,?,? ,?,?,?,? ,?,?)}";
		String strProcName = "{call Pkg_Mms_View2.proc_issue_cmb_rpt(?,?,?,?  ,?,?,?,?  ,?,?)}";

		int nProcIndex = 0;
	
		String strErr = "";

		try {
			
			System.out.println(" ------- OPDIssueToPatAutoTransDAO .getCancelIssueDtls  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_Issue_Details  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions","OPDIssueToPatAutoTransDAO");

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
					.setStrMsgString("OPDIssueToPatAutoTransDAO.getIssueDetail() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getIssueDetailTwo(OPDIssueToPatAutoTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String proc_name1 = "{call Pkg_Mms_View.proc_patient_issue_drug_dtl(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			System.out.println(" ------- OPDIssueToPatAutoTransDAO .getIssueDetailTwo  -------- ");
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
			vo.setStrMsgString("OPDIssueToPatAutoTransDAO.getIssueDetailTwo() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getIssueDtlPopUp(OPDIssueToPatAutoTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call  Pkg_Mms_View.Proc_IssuePopup_Dtls(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- OPDIssueToPatAutoTransDAO .getIssueDtlPopUp  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_IssuePopup_Dtls  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "OPDIssueToPatAutoTransDAO");

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
			voObj.setStrMsgString("OPDIssueToPatAutoTransDAO.getIssueDtlPopUp() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getRequestDtls(OPDIssueToPatAutoTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Issue_Request_Dtls(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";
		int funcIndex;
		String BillingValue = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "OPDIssueToPatAutoTransDAO");

			System.out.println("<------------- OPDIssueToPatAutoTransDAO.getRequestDtls() ------------->");

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
			voObj.setStrMsgString("OPDIssueToPatAutoTransDAO.getRequestDtls() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getOnlineTreatmentDtls(OPDIssueToPatAutoTransFB formBean, OPDIssueToPatAutoTransVO vo) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_mms_view.PROC_HRGT_PATIENT_TREATMENT_DTL_ONLINE(?,?,?,?,?,? ,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		String strCrNum = formBean.getStrCrNo();
		String strHospcode = formBean.getStrHospitalCode();

		String strStoreId = formBean.getStrStoreId().split("\\^")[0];
		try {

			System.out.println(" ------- OPDIssueToPatAutoTransDAO .getOnlineTreatmentDtls  -------- ");
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
	
	public static void getPatientTreatmentHLPForIssue(OPDIssueToPatAutoTransVO voObj) 
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call PKG_MMS_VIEW2.PROC_HRGT_PATIENT_TREATMENT_DTL(?,?,?,?,? ,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO.getPatientTreatmentHLPForIssue");

			nProcIndex = daoObj.setProcedure(strProcName);

			if (voObj.getStrCrNo() != null && !voObj.getStrCrNo().equals("")) 
			{

				daoObj.setProcInValue(nProcIndex, "modeVal", 	"6", 1);
				daoObj.setProcInValue(nProcIndex, "puk", 		voObj.getStrCrNo(), 2);
				daoObj.setProcInValue(nProcIndex, "hosp_code", 	voObj.getStrHospitalCode(), 3);
				daoObj.setProcInValue(nProcIndex, "store_id", 	voObj.getStrStoreId(), 4);
				daoObj.setProcOutValue(nProcIndex, "err", 		1, 5);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2, 6);
				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				if (strErr.equals("")) {
					voObj.setTreatmentDtlHLPWs(ws);
				} else {
					throw new Exception(strErr);
				}

			}

		} catch (Exception e) {
			System.out.println("Error Msg is-->" + e.getMessage());
			voObj.setStrMsgString("PatientDtlDAO.setPatientTreatmentHLPForIssue() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void getAlreadyDrugIssue(OPDIssueToPatAutoTransFB formBean, OPDIssueToPatAutoTransVO vo) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_mms_view.PROC_HRGT_PATIENT_TREATMENT_DTL_ONLINE(?,?,?,?,?,? ,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		String strCrNum = formBean.getStrCrNo();
		String strHospcode = vo.getStrHospitalCode();

		try {

			System.out.println(" ------- OPDIssueToPatAutoTransDAO .getAlreadyDrugIssue  -------- ");
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

	public static void getRequestDetails(OPDIssueToPatAutoTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Request_Dtls(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- OPDIssueToPatAutoTransDAO .getRequestDetails  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_Request_Dtls  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "OPDIssueToPatAutoTransDAO");

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
			voObj.setStrMsgString("OPDIssueToPatAutoTransDAO.getRequestDetails() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
  
	public static void getDeptDetails(OPDIssueToPatAutoTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_department(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- OPDIssueToPatAutoTransDAO .getDeptDetails  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_department  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "OPDIssueToPatAutoTransDAO");

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
			voObj.setStrMsgString("OPDIssueToPatAutoTransDAO.getDeptDetails() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getUnitDetails(OPDIssueToPatAutoTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Unit(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- OPDIssueToPatAutoTransDAO .getUnitDetails  ---(Dept Wise Unit)----- ");
			System.out.println(" ------- pkg_mms_view.Proc_Unit  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "OPDIssueToPatAutoTransDAO");

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
			voObj.setStrMsgString("OPDIssueToPatAutoTransDAO.getUnitDetails() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getPrescribedBy(OPDIssueToPatAutoTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Consultant_Name(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- OPDIssueToPatAutoTransDAO .getPrescribedBy  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_Consultant_Name  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "OPDIssueToPatAutoTransDAO");

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
			voObj.setStrMsgString("OPDIssueToPatAutoTransDAO.getPrescribedBy() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getItemDetails(OPDIssueToPatAutoTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_IssueItem_Dtl(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- OPDIssueToPatAutoTransDAO .getItemDetails  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_IssueItem_Dtl  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "OPDIssueToPatAutoTransDAO");

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
			voObj.setStrMsgString("OPDIssueToPatAutoTransDAO.getItemDetails() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getUnitCombo(OPDIssueToPatAutoTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_mms_view.proc_gblt_unit_mst(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- OPDIssueToPatAutoTransDAO .getUnitCombo  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_gblt_unit_mst  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "OPDIssueToPatAutoTransDAO");

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
			voObj.setStrMsgString("OPDIssueToPatAutoTransDAO.getUnitCombo() --> " + e.getMessage());
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

	public static void getStoreGroupList(OPDIssueToPatAutoTransVO vo) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			System.out.println("<------------- OPDIssueToPatAutoTransDAO.getStoreGroupList() ------------->");
			System.out.println("<------------- pkg_mms_view.proc_store_group_list [ Mode - 2 ]------------->");

			dao = new HisDAO("MMS Transactions", "OPDIssueToPatAutoTransDAO");

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
			vo.setStrMsgString("OPDIssueToPatAutoTransDAO.getStoreGroupList() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	
	public static void getGenderCombo(OPDIssueToPatAutoTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_get_Gender_Combo(?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "OPDIssueToPatAutoTransDAO");

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
			voObj.setStrMsgString("OPDIssueToPatAutoTransDAO.getGenderCombo() --> " + e.getMessage());
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
	 * @param OPDIssueToPatAutoTransVO the OPDIssueToPatAutoTransVO
	 */
	public static void getPatientDiagDetails(OPDIssueToPatAutoTransVO vo) {

		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";

		try {
			System.out.println("------------- OPDIssueToPatAutoTransDAO.getPatientDiagDetails -------------");
			System.out.println("------------- PKG_MMS_VIEW.proc_diag_emp_view [ Mode - 1 ] -------------");

			String strProcName = "{call PKG_MMS_VIEW.proc_diag_emp_view(?,?::varchar,?::varchar,?,?)}";

			daoObj = new HisDAO("MMS Transactions", "OPDIssueToPatAutoTransDAO");

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
			vo.setStrMsgString("--> OPDIssueToPatAutoTransDAO.getPatientDiagDetails()-->" + e.getMessage());
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
	 * @param OPDIssueToPatAutoTransVO the OPDIssueToPatAutoTransVO
	 */
	public static void getIcdList(OPDIssueToPatAutoTransVO vo) {

		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";

		try {

			System.out.println("------------- OPDIssueToPatAutoTransDAO.getIcdList -------------");
			System.out.println("------------- PKG_MMS_VIEW.proc_diag_mst [ Mode - 1 ] -------------");

			String strProcName = "{call PKG_MMS_VIEW.proc_diag_mst(?,?,?)}";

			daoObj = new HisDAO("MMS Transactions", "OPDIssueToPatAutoTransDAO");

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
			vo.setStrMsgString("--> OPDIssueToPatAutoTransDAO.getPatientDiagDetails()-->" + e.getMessage());
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
	 * @param OPDIssueToPatAutoTransVO the OPDIssueToPatAutoTransVO
	 */
	public static void getEmpList(OPDIssueToPatAutoTransVO vo) {

		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";

		try {

			System.out.println("------------- OPDIssueToPatAutoTransDAO.getEmpList -------------");
			System.out.println("------------- PKG_MMS_VIEW.proc_unit_consulatant_view [ Mode - 2 ] -------------");

			String strProcName = "{call PKG_IPD_VIEW.proc_unit_consulatant_view(?,?,?,?,?,?)}";

			daoObj = new HisDAO("MMS Transactions", "OPDIssueToPatAutoTransDAO");

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
			vo.setStrMsgString("--> OPDIssueToPatAutoTransDAO.getPatientDiagDetails()-->" + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null)
				daoObj.free();
			daoObj = null;
		}

	}

	public static void getBilledItemDtls(OPDIssueToPatAutoTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String proc_name1 = "{call Pkg_Mms_View.proc_patient_issue_drug_dtl(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			System.out.println("------------- OPDIssueToPatAutoTransDAO.getBilledItemDtls -------------");
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
			vo.setStrMsgString("OPDIssueToPatAutoTransDAO.getIssueDetailTwo() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}


	public static void getTariffDtls(OPDIssueToPatAutoTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String proc_name1 = "{call Pkg_Mms_View.proc_tariff_list(?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println("------------- OPDIssueToPatAutoTransDAO.getTariffDtls -------------");
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
			vo.setStrMsgString("OPDIssueToPatAutoTransDAO.getTariffDtls() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getStoreListBS(OPDIssueToPatAutoTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		try {

			System.out.println("------------- OPDIssueToPatAutoTransDAO.getStoreListBS -------------");
			System.out.println("------------- Pkg_Mms_dml.proc_hstt_store_mst [ Mode - 12 ] -------------");

			daoObj = new HisDAO("MMS Transactions", "OPDIssueToPatAutoTransDAO");
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
			voObj.setStrMsgString("OPDIssueToPatAutoTransDAO.getStoreList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getPaymentMode(OPDIssueToPatAutoTransVO vo) {
		// TODO Auto-generated method stub

		String strProcName = "{call pkg_bill_view.sblt_payment_category_mapping_mst(?,?,?,?,?,?,?,?)}";

		int nProcIndex = 0;
		String val = "0";
		String strErr = "";
		WebRowSet ws = null;

		HisDAO daoObj = null;
		try {
			System.out.println(" ------- OPDIssueToPatAutoTransDAO .getPaymentMode  -------- ");
			System.out.println(" ------- pkg_bill_view.sblt_payment_category_mapping_mst  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "OPDIssueToPatAutoTransDAO");
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
			vo.setStrMsgString("OPDIssueToPatAutoTransDAO.getPaymentMode() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void getReqType(OPDIssueToPatAutoTransVO vo) {
		// TODO Auto-generated method stub

		String strProcName = "{call Pkg_Mms_View.proc_sstt_indenttype_dtl(?,?,?,?,?,?,?)}";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;

		HisDAO daoObj = null;
		try {
			System.out.println("------------- OPDIssueToPatAutoTransDAO.getReqType -------------");
			System.out.println("------------- Pkg_Mms_dml.proc_sstt_indenttype_dtl [ Mode - 3 ] -------------");

			daoObj = new HisDAO("MMS Transactions", "OPDIssueToPatAutoTransDAO");
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
			vo.setStrMsgString("OPDIssueToPatAutoTransDAO.getReqType() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void getEpisodeDtl(OPDIssueToPatAutoTransVO voObj) 
	{
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

			System.out.println("------------- OPDIssueToPatAutoTransDAO.getEpisodeDtl -------------");

			System.out.println(
					"------------- pkg_simple_view.proc_hrgt_episode_unit_based_dtl --[ Mode - 1 ]-----------");

			daoObj = new HisDAO("mms", "OPDIssueToPatAutoTransDAO.getEpisodeDtl");
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
			voObj.setStrMsgString("OPDIssueToPatAutoTransDAO.getEpisodeDtl() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void getPresFormDtl(OPDIssueToPatAutoTransVO voObj) {
		// TODO Auto-generated method stub

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_simple_view.proc_hrgt_visittype_episode_based_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strEpisodeCode = voObj.getStrEpisodeCode();
		String strCrNo = voObj.getStrCrNo();

		String strErr = "";

		try {
			System.out.println("------------- OPDIssueToPatAutoTransDAO.getPresFormDtl -------------");

			System.out.println(
					"------------- pkg_simple_view.proc_hrgt_visittype_episode_based_dtl --[ Mode - 1 ]-----------");

			daoObj = new HisDAO("mms", "OPDIssueToPatAutoTransDAO.getEpisodeDtl");
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
			voObj.setStrMsgString("OPDIssueToPatAutoTransDAO.getEpisodeDtl() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void getAccountDtl(OPDIssueToPatAutoTransVO VO) {
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.PROC_HBLT_PATACCOUNT_DTL(?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		int procIndex1 = 0;
		String strerr = "";
		WebRowSet ws = null;
		try {
			System.out.println("------------- OPDIssueToPatAutoTransDAO.getAccountDtl -------------");

			System.out.println("------------- PKG_BILL_VIEW.PROC_HBLT_PATACCOUNT_DTL --[ Mode - 12 ]-----------");

			dao = new HisDAO("mms", "OPDIssueToPatAutoTransDAO.getAccountDtlWithAcctNo()");
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
			VO.setStrMsgString("OPDIssueToPatAutoTransDAO.getAccountDtl() --> " + e.getMessage());
			VO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getdeptname(OPDIssueToPatAutoTransVO vo) {
		int nFuncIndex;
		String strFuncName2 = "";
		String deptname = "";
		HisDAO dao = null;
		try {
			System.out.println("------------- OPDIssueToPatAutoTransDAO.getdeptname -------------");

			System.out.println("------------- ipd_MST.getdeptname --[ Mode - 12 ]-----------");

			dao = new HisDAO("mms", "OPDIssueToPatAutoTransDAO.getdeptname()");
			strFuncName2 = "{? = call ipd_MST.getdeptname(?,?)}";
			nFuncIndex = dao.setFunction(strFuncName2);
			dao.setFuncInValue(nFuncIndex, 2, vo.getStrDeptCode());
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			deptname = dao.getFuncString(nFuncIndex);
			vo.setStrDeptName(deptname);
		} catch (Exception e) {
			vo.setStrMsgString("OPDIssueToPatAutoTransDAO.getdeptname() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getOPDPatientDtls(OPDIssueToPatAutoTransVO vo) {
		int nFuncIndex;
		String strFuncName2 = "";
		String opdPatDtls = "";
		HisDAO dao = null;
		try {
			System.out.println("------------- OPDIssueToPatAutoTransDAO.getOPDPatientDtls -------------");

			System.out.println("------------- MMS_MST.get_opd_patient_dtl --[ Mode - 1 ]-----------");

			dao = new HisDAO("mms", "OPDIssueToPatAutoTransDAO.getdeptname()"); // String moduleName, String fileName
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
			vo.setStrMsgString("OPDIssueToPatAutoTransDAO.getOPDPatientDtls() --> " + e.getMessage());
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

	

	 public static void getImageHeader(OPDIssueToPatAutoTransVO voObj)
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
		public static void getPrintIssueDtls(OPDIssueToPatAutoTransVO vo) {
			String err;
			// String strSlNoflg;
			HisDAO dao = null;
			WebRowSet ws = null;
			int procIndex1 = 0;
			String proc_name1 = "{call pkg_mms_view.Proc_Emp_Issue_Detail(?,?,?,?,?,?)}"; // 6
			try {
				System.out.println(" ------- OPDIssueToPatAutoTransDAO .getPrintIssueDtls  -------- ");
				System.out.println(" ------- pkg_mms_view.Proc_Emp_Issue_Detail  --[ Mode- 3 ]------ ");

				/*
				 * Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line
				 * Issue Voucher) 1.Hospital Name ^ DDC Name ^ Prescribe For ^ Issue No ^ Issued
				 * By Doctor ^ Date ^ Cr No ^ Hindi Text 2.Drug Name 3.Batch No 4.Exp Date
				 * 5.Issue Qty
				 */
				dao = new HisDAO("mms", "global.OPDIssueToPatAutoTransDAO.getStockItemDtlsList(OPDIssueToPatAutoTransVO vo)");
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
				vo.setStrMsgString("OPDIssueToPatAutoTransDAO.getIssueDtlsList() --> " + e.getMessage());
				vo.setStrMsgType("1");

			} finally {

				if (dao != null) {
					dao.free();
					dao = null;
				}

			}

		}
		
		
		/**
		 * Gets the stock item dtls list.
		 * 
		 * @param vo the vo
		 * 
		 * @return the stock item dtls list
		 */

		public static void getNALIst(OPDIssueToPatAutoTransVO voObj) {

			HisDAO daoObj = null;
			WebRowSet ws = null;

			String strProcName = "{call PKG_MMS_VIEW2.PROC_HRGT_PATIENT_TREATMENT_DTL(?,?,?,?,? ,?)}";
			int nProcIndex = 0;

			String strErr = "";

			try {

				daoObj = new HisDAO("MMS Transactions", "IssueTransDAO.getNALIst");

				nProcIndex = daoObj.setProcedure(strProcName);

				if (voObj.getStrCrNo() != null && !voObj.getStrCrNo().equals("")) {

					daoObj.setProcInValue(nProcIndex, "modeVal", "7", 1);
					daoObj.setProcInValue(nProcIndex, "puk", voObj.getStrCrNo(), 2);
					daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode() + "$" + voObj.getStrSeatId(),
							3);
					daoObj.setProcInValue(nProcIndex, "store_id", voObj.getStrStoreId(), 4);
					daoObj.setProcOutValue(nProcIndex, "err", 1, 5);
					daoObj.setProcOutValue(nProcIndex, "resultset", 2, 6);
					daoObj.executeProcedureByPosition(nProcIndex);

					strErr = daoObj.getString(nProcIndex, "err");

					if (strErr == null)
						strErr = "";

					ws = daoObj.getWebRowSet(nProcIndex, "resultset");
					if (strErr.equals("")) {
						voObj.setTreatmentDtlHLPWs(ws);
					} else {
						throw new Exception(strErr);
					}

				}

			} catch (Exception e) {
				System.out.println("Error Msg is-->" + e.getMessage());
				voObj.setStrMsgString("PatientDtlDAO.getNALIst() --> " + e.getMessage());
				voObj.setStrMsgType("1");

			} finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}

		}
		
		/**
		 * This function is used to GET THE BATCH WISE ITEM DETAILS FOR POPUP.
		 * 
		 * @param vo the vo
		 * @return the single batch item dtl
		 */
		public static void getSingleBatchItemDtl(OPDIssueToPatAutoTransVO vo) {

			HisDAO dao = null;
			WebRowSet ws = null;

			String strProcName = "";
			int nProcIndex = 0;

			String strErr = "";

			try {
				dao = new HisDAO("mms", "IssueTransDAO");

				strProcName = "{call Pkg_Mms_View.proc_itemStock_dtl(?,?,?,?,?,?,?,?,?,?,?)}";
				nProcIndex = dao.setProcedure(strProcName);

				// Item ID ^ ItemBrand Id ^ Batch No ^ StoreID ^ Catg NO

				dao.setProcInValue(nProcIndex, "modeval", "7");
				dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
				dao.setProcInValue(nProcIndex, "item_id", vo.getStrSingleItemDtl().split("\\^")[0]);
				dao.setProcInValue(nProcIndex, "itembrand_id", vo.getStrSingleItemDtl().split("\\^")[1]);
				dao.setProcInValue(nProcIndex, "store_id", vo.getStrSingleItemDtl().split("\\^")[3]);
				dao.setProcInValue(nProcIndex, "batch_no", vo.getStrSingleItemDtl().split("\\^")[2]);
				dao.setProcInValue(nProcIndex, "item_sl_no", "0");
				dao.setProcInValue(nProcIndex, "sl_no", vo.getStrSingleItemDtl().split("\\^")[4]); // Passing As a ItemCat
																									// No.
				dao.setProcInValue(nProcIndex, "reserved_flag", "0");
				dao.setProcOutValue(nProcIndex, "err", 1);
				dao.setProcOutValue(nProcIndex, "resultset", 2);
				dao.executeProcedure(nProcIndex);

				strErr = dao.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = dao.getWebRowSet(nProcIndex, "resultset");

				if (strErr.equals("")) {

					vo.setStrSingleBatchDtlWs(ws);

				} else {
					throw new Exception(strErr);
				}

			} catch (Exception e) {
				e.printStackTrace();
				vo.setStrMsgString("IssueTransDAO.getPopUpInfoProc() --> " + e.getMessage());
				vo.setStrMsgType("1");

			} finally {

				if (dao != null) {
					dao.free();
					dao = null;
				}

			}

		}
		
		
		public static void getPatientTreatmentDetailfrmIpd(OPDIssueToPatAutoTransVO voObj) 
		{ // added by shalini to get treatment detail
			// given at IPD Doctor Desk

			String strErr = "";
			
			HisDAO daoObj = null;
			WebRowSet ws = null;
			
			String strProcName = "{call Pkg_Mms_View.Proc_IssueItem_Dtl(?,?,?,?,?,?,?)}";
			int nProcIndex = 0;
			
			try 
			{
			
				System.out.println("<<------ RequestForLPPatientDAO.getPatientTreatmentDetailfrmIpd             ------>>");
				System.out.println("<<------ PKG_MMS_VIEW.Proc_IssueItem_Dtl     [Mode - 2 ]    ------>>");
				
				daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");
				
				nProcIndex = daoObj.setProcedure(strProcName);
				
				daoObj.setProcInValue(nProcIndex, "modeval", "2", 1);
				daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 2);
				daoObj.setProcInValue(nProcIndex, "reqNo", voObj.getStrItemCat(), 3);
				daoObj.setProcInValue(nProcIndex, "crNo", voObj.getStrCrNo(), 4);
				daoObj.setProcInValue(nProcIndex, "strId", voObj.getStrStoreId(), 5);
				daoObj.setProcOutValue(nProcIndex, "err", 1, 6);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2, 7);
				
				daoObj.executeProcedureByPosition(nProcIndex);
				
				strErr = daoObj.getString(nProcIndex, "err");
				
				if (strErr == null)
				strErr = "";
				
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				
				if (strErr.equals("")) {
				
				voObj.setTreatmentDetailWs(ws);
			
			} else {
			throw new Exception(strErr);
			}
			
			} catch (Exception e) 
			{
			
			voObj.setStrMsgString("AdmissionAdviceTransDAO.getIcd10DiagnosisDtl() --> " + e.getMessage());
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
		
		
		public static void getPatientDepartmentDtls(OPDIssueToPatAutoTransVO vo) {
			// Declearing Variable
			String retVal = null;
			int funcIndex = 0;
			HisDAO dao = null;
			try {
				dao = new HisDAO("MMSModule", "RequestForLPPatientDAO");

				funcIndex = dao.setFunction("{? = call MMS_MST.get_patient_department(?,?,?,?)}");
				// Set Value
				dao.setFuncInValue(funcIndex, 2, "1");
				dao.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
				dao.setFuncInValue(funcIndex, 4, vo.getStrCrNo());
				dao.setFuncInValue(funcIndex, 5, vo.getStrStoreId());
				dao.setFuncOutValue(funcIndex, 1);
				// Execute Function
				dao.executeFunction(funcIndex);
				retVal = dao.getFuncString(funcIndex);
				if (retVal != null) {
					vo.setStrPatientDepartmentDtls(retVal);
				} else {
					vo.setStrPatientDepartmentDtls("1$-");

				}

			} catch (Exception e) {
				vo.setStrMsgString("IndentDeskCondemnationReqTransDAO.callingFunctionStoreName() --> " + e.getMessage());
				vo.setStrMsgType("1");
			}
		}
		
		
		/**
		 * Gets the item dtls.
		 * 
		 * @param voObj the vo obj
		 * 
		 * @return the item dtls
		 */
		public static void getItemDtls(OPDIssueToPatAutoTransVO voObj) {

			HisDAO daoObj = null;
			String strFuncName = "";
			String strItemName = "";
			int nFuncIndex = 0;

			try {
				daoObj = new HisDAO("IssueDeskTrans", "SetSachetDetailsTransDAO");

				strFuncName = "{? = call MMS_MST.get_item_dtl(?::numeric,?::numeric,?::numeric)}"; // 4
				nFuncIndex = daoObj.setFunction(strFuncName);
				daoObj.setFuncInValue(nFuncIndex, 2, "1");
				daoObj.setFuncInValue(nFuncIndex, 3, voObj.getStrHospitalCode());
				daoObj.setFuncInValue(nFuncIndex, 4, voObj.getStrItemId());
				daoObj.setFuncOutValue(nFuncIndex, 1);
				daoObj.executeFunction(nFuncIndex);
				strItemName = daoObj.getFuncString(nFuncIndex);

				voObj.setStrItemName(strItemName);

			} catch (Exception e) {
				e.printStackTrace();
				voObj.setStrMsgString("IssueDeskTransDAO.getItemDtls --> " + e.getMessage());
				voObj.setStrMsgType("1");

			} finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;

				}
			}

		}

		/**
		 * Gets the stock item dtls list.
		 * 
		 * @param vo the vo
		 * 
		 * @return the stock item dtls list
		 */
		public static void getStockItemDtlsList(OPDIssueToPatAutoTransVO vo) {
			// This Procedure Return 44 Value(Ist Generic Item Name + Last : Rack No(44))
			String err = "";
			String proc_name1 = "{call pkg_mms_view.Proc_stock_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // 10+3=13

			int procIndex1 = 0;
			HisDAO dao = null;
			WebRowSet ws = null;
			String strMode = "1";
			try {

				System.out.println("-----IssueDeskTransDAO.stockItemDtlsInit --- [pkg_mms_view.Proc_stock_dtl  Mode - "
						+ strMode + "]---");

				dao = new HisDAO("IssueDeskTrans", "global.IssueDeskTransDAO.getStockItemDtlsList(IssueTransVO vo)");
				procIndex1 = dao.setProcedure(proc_name1);
				// set value
				// System.out.println("Mode::IN IssueDeskTrans DAO::"+strMode);

				dao.setProcInValue(procIndex1, "modval", "1", 1);
				dao.setProcInValue(procIndex1, "store_id", vo.getStrFromStoreId(), 2);
				dao.setProcInValue(procIndex1, "catCode", vo.getStrItemId().substring(0, 2), 3);
				dao.setProcInValue(procIndex1, "item_id", vo.getStrGenricItemId(), 4);
				dao.setProcInValue(procIndex1, "itembrand_id", vo.getStrItemId(), 5);
				dao.setProcInValue(procIndex1, "stock_status", "10", 7);
				dao.setProcInValue(procIndex1, "reservedStockFlag", vo.getStrReservedFlag(), 10);
				dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(), 8);
				dao.setProcOutValue(procIndex1, "err", 1, 12); // 1 for string return
				dao.setProcOutValue(procIndex1, "resultset", 2, 13); // 2 for object
				dao.setProcInValue(procIndex1, "batch_no", "0", 6);
				dao.setProcInValue(procIndex1, "itemSlNo", "0", 9);
				dao.setProcInValue(procIndex1, "blockedQtyFlag", "1", 11);
				/* End Adding Default value */

				// execute procedure

				dao.executeProcedureByPosition(procIndex1);

				// get value
				err = dao.getString(procIndex1, "err");

				if (err == null)
					err = "";

				ws = dao.getWebRowSet(procIndex1, "resultset");

				if (vo.getStrModeVal().equals("3") && ws != null && ws.size() > 0) {

					if (ws.next()) {
						vo.setStrRateUnit(ws.getString(41));
						vo.setStrRateInBaseValue(ws.getString(42));
					}
					ws.beforeFirst();

				}
				vo.setWsStockDetails(ws);

			} catch (Exception e) {

				e.printStackTrace();

				vo.setStrMsgString("IssueDeskTransDAO.getStockItemDtlsList() --> " + e.getMessage());
				vo.setStrMsgType("1");

			} finally {

				if (dao != null) {
					dao.free();
					dao = null;
				}

			}

		}

		
		public static synchronized void DIRECTISSUE_OFFLINE(OPDIssueToPatAutoTransVO vo) {
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

				System.out.println("------------- OPDIssueToPatAutoTransDAO.DIRECTISSUE_OFFLINE ------  START ------");

				debugPoint = 1;
				dao = new HisDAO("MMS Transactions", "OPDIssueToPatAutoTransDAO");

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
				dao = new HisDAO("MMS Transactions", "OPDIssueToPatAutoTransDAO");
				length = vo.getItemParamValue().length;

				System.out.println("-------------Pkg_Mms_Dml2.Dml_Patemp_Issue_Items_Dtls ------  B ---[ Issue Drug Count "
						+ length + " ]---");

				String[] temp = vo.getStrOPDDetails().split("\\$");

				for (int k = 0; k < length; k++) 
				{
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

				System.out.println("------------- OPDIssueToPatAutoTransDAO.DIRECTISSUE_OFFLINE ------ END -------");

			} catch (Exception e) {
				e.printStackTrace();
				vo.setStrMsgType("1");
				vo.setStrMsgString("OPDIssueToPatAutoTransDAO.insert() --> " + e.getMessage() + " DAO_DEBUG_POINT :: "
						+ debugPoint + " DAO_VALUE :: " + itemValue);
			} finally {

				if (dao != null) {
					dao.free();
					dao = null;
				}

			}
		}
         
		/**
		 * Method Used To Save Auto Selected BATCH
		 * Logic Here		 
		 * @param vo
		 */

		public static synchronized void NEW_OPD_ISSUE_INSERT(OPDIssueToPatAutoTransVO vo) {

			HisDAO dao = null;
			String strFuncName = "",strProcName3="";
			int nFuncIndex = 0;
			int length = 0;
			String paramVal[] = null;
			String userValue[] = null;
			String strIssueNo = "";
			String strVisitDtl = "";
			Double netCost = 0.00;
			int nProcIndex = 0, procIndex2 = 0, nProcIndex3 = 0;
			

			int debugPoint = 0;
			String itemValue = "";

			MmsConfigUtil mcu;

			String[] temp = null;
			String[] strtemp = null;
				
			String strStochStatusCodeArray[] = null;			
			String[] values = null;

			String strProcName = "";
			String strBillTariff = "";
			String strBillBatch = "";
			String strBillRate = "";
			String strBillQty = "";

			try 
			{

				System.out.println(" ------- OPDIssueToPatAutoTransDAO .NEW_OPD_ISSUE  ---- START --[ AUTO BATCH SELECTION ]-- ");

				System.out.println("-------getStrHospitalCode------" + vo.getStrHospitalCode());
				System.out.println("-------getStrStoreId------" + vo.getStrStoreId());
			

				debugPoint = 1;
				mcu = new MmsConfigUtil(vo.getStrHospitalCode());
				dao = new HisDAO("MMS Transactions", "IssueTransDAO");
				
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

				
				dao = new HisDAO("MMS Transactions", "IssueTransDAO");
				
				String[] temp1 = vo.getStrOPDDetails().split("\\$");
				
				System.out.println("----------------------------------------");
				System.out.println("getStrStoreId---" + vo.getStrStoreId());
				System.out.println("getStrHospitalCode---" + vo.getStrHospitalCode());
				System.out.println("getStrPuk---" + vo.getStrPuk());
				System.out.println("getStrReqTypeId---" + vo.getStrReqTypeId());
				System.out.println("stradmno---" + temp1[7]);
				System.out.println("getStrSeatId---" + vo.getStrSeatId());
				System.out.println("strVisitType---" + temp1[1]);
				System.out.println("strDeptUnitCode---" + temp1[6]);
				System.out.println("strDeptCode---" + temp1[5]);
				System.out.println("strEpiCode---" + temp1[3]);
				System.out.println("strVisitNo---" + temp1[4]);
				/* 
				 *  Naman
				 * ^AMAN/
				 * ^General
				 * ^28 Yr/M
				 * ^,Guntur,Andhra Pradesh
				 * ^All India Institute of Medical Sciences, Mangalagiri
				 * ^null
				 * ^7088563254 */
				System.out.println("p_first_name---" + vo.getStrPatientDtlHidVal().split("\\^")[0]);
				System.out.println("p_hstdt_age---" + vo.getStrPatientDtlHidVal().replace("^", "#").split("#")[3].split(" ")[0]);
				System.out.println("p_gnum_gender_code---" + vo.getStrPatientDtlHidVal().replace("^", "#").split("#")[3].split("/")[1]);
					
				System.out.println("----------------------------------------");

				debugPoint = 12;

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
				dao.setProcInValue(nProcIndex3, "strReqTypeId", "32", 10);// 10
				dao.setProcInValue(nProcIndex3, "stradmno", temp1[7], 11);// 11
				dao.setProcInValue(nProcIndex3, "strempno", "0", 12);// 12
				dao.setProcInValue(nProcIndex3, "strItemCatNo", "0", 13);// 13
				dao.setProcInValue(nProcIndex3, "strFinalCost", "0", 14); // 14
				dao.setProcInValue(nProcIndex3, "strFinStartDate", "", 15);// 15
				dao.setProcInValue(nProcIndex3, "strFinEndDate", "", 16);// 16
				dao.setProcInValue(nProcIndex3, "strSeatId", vo.getStrSeatId(), 17);// 17
				dao.setProcInValue(nProcIndex3, "strDeptUnitCode", temp1[6], 18);// 18				
				dao.setProcInValue(nProcIndex3, "strVisitType", temp1[1], 19);// 19				
				dao.setProcInValue(nProcIndex3, "strDeptCode", temp1[5], 20);// 20				
				dao.setProcInValue(nProcIndex3, "strWardCode", "0", 21); // 21
				dao.setProcInValue(nProcIndex3, "strRecieveBy", "0", 22); // 22
				dao.setProcInValue(nProcIndex3, "strRemarks", "Issue to OPD Patient", 23);// 23
				dao.setProcInValue(nProcIndex3, "strReqDate", "0", 24);// 24
				dao.setProcInValue(nProcIndex3, "strEpiCode", temp1[3], 25);// 25				
				dao.setProcInValue(nProcIndex3, "strVisitNo", temp1[4], 26);// 26				
				dao.setProcInValue(nProcIndex3, "p_first_name", vo.getStrPatientDtlHidVal().split("\\^")[0], 27);// 27
				dao.setProcInValue(nProcIndex3, "p_middle_name", "-", 28); // 28
				dao.setProcInValue(nProcIndex3, "p_last_name", "-", 29); // 29
				dao.setProcInValue(nProcIndex3, "p_hststr_father_name", "-", 30);// 32
				dao.setProcInValue(nProcIndex3, "p_hstdt_age",vo.getStrPatientDtlHidVal().replace("^", "#").split("#")[3].split(" ")[0], 31);// 33
				dao.setProcInValue(nProcIndex3, "p_gnum_gender_code",vo.getStrPatientDtlHidVal().replace("^", "#").split("#")[3].split("/")[1], 32);// 34
				dao.setProcInValue(nProcIndex3, "p_hststr_address", "NA", 33);// 35
				dao.setProcInValue(nProcIndex3, "p_hststr_patient_id", "0", 34);
				dao.setProcInValue(nProcIndex3, "p_hstnum_patient_type", "0", 35);
				dao.setProcInValue(nProcIndex3, "p_trans_type", "0", 36);// 36
				dao.setProcInValue(nProcIndex3, "p_age_unit", "0", 37);// 37
				dao.setProcInValue(nProcIndex3, "p_issue_date", "", 38);// 38
				dao.setProcInValue(nProcIndex3, "p_out_stock", "0", 39);// 39
				dao.setProcOutValue(nProcIndex3, "err", 1, 40);// 40

				dao.execute(nProcIndex3, 1);
				
				

				int batchLength = 0;

				String strBatchSlNoArray[] = null;
				String strItemSlNoArray[] = null;
				String strIssueQtyBtchWsArray[] = null;
				String strIssueQtyUnitBtchWsArray[] = null;
				String strManufDateArray[] = null;
				String strExpiryDateArray[] = null;
				String strRateArray[] = null;
				String strRateUnitIdArray[] = null;

				for (int i = 0; i < vo.getStrItemIdArray().length; i++) 
				{

					if (vo.getStockDtlsId()[i] != null && vo.getStockDtlsId()[i].length() > 0
							&& !vo.getStockDtlsId()[i].equals("")) 
					{

						System.out.println("------------AUTO -- With BATCH Selection  ------ A -----------");
						System.out.println("-------vo.getStockDtlsId()[" + i + "]------" + vo.getStockDtlsId()[i]);
						values = vo.getStockDtlsId()[i].split("#");
						// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
						// StoreId^Generic_ItemId^Brand_ItemId^Stock_Status_Code^Batch_No^Serial_No^Expiry
						// date^Manufactre Date^In Hand Qty ^ In Hand Qty Unit ^ Purchase Rate ^
						// Purchase Rate Unit ^ Rate ^ Rate Unit ^ Issue Qty ^ Issue Qty Unit ^ ^ ^ Cost
						// ^ Cost
						// 99901120^10000067^10100067^UIT11738^10^0^31-May-2014^01-Dec-2011^24990^6301^21.54^6306^22.62^6306^10^6301^1^0^2.26^2.26
						batchLength = values.length;
						for (int j = 0; j < batchLength; j++) 
						{
							
							
							   strStochStatusCodeArray = new String[batchLength];
								     strBatchSlNoArray = new String[batchLength];
							          strItemSlNoArray = new String[batchLength];
							    strIssueQtyBtchWsArray = new String[batchLength];
							strIssueQtyUnitBtchWsArray = new String[batchLength];
									 strManufDateArray = new String[batchLength];
									strExpiryDateArray = new String[batchLength];
										  strRateArray = new String[batchLength];
								    strRateUnitIdArray = new String[batchLength];						
								                  temp = values[j].replace("^", "#").split("#");
							strStochStatusCodeArray[j] = temp[4];
								  strBatchSlNoArray[j] = temp[3];
						 			  

							if (temp[4] == null) 
							{
								strStochStatusCodeArray[j] = "0";
							} 
							else 
							{
								strStochStatusCodeArray[j] = temp[4];
							}

							if (temp[5] == null) 
							{
								strItemSlNoArray[j] = "0";
							} 
							else 
							{
								strItemSlNoArray[j] = temp[5];
							}
							if (temp[7] == null) 
							{
								strManufDateArray[j] = "";
							} 
							else 
							{
								strManufDateArray[j] = temp[7];
							}
							if (temp[6] != null && temp.length > 10) 
							{
								strExpiryDateArray[j] = temp[6];
							} 
							else 
							{
								strExpiryDateArray[j] = "";
							}
							
							
							
							strRateArray[j] 				= temp[12]; // O.V 10												
							strRateUnitIdArray[j] 			= temp[13]; // O.V 11
							strIssueQtyBtchWsArray[j] 		= temp[14];
							strIssueQtyUnitBtchWsArray[j] 	= temp[15];
							
					    if(Integer.parseInt(strIssueQtyBtchWsArray[j])>0) 
						{

							if (j == 0) 
							{
								System.out.println("----Pkg_Mms_Dml2.Dml_Patemp_Issue_Items_Dtls--[ Mod  - 1 ]----------");
							}
							System.out.println("------------------------" + j + "----------------------------");
							// strProcName = "{call
							// Pkg_Mms_Dml2.Dml_Patemp_Issue_Items_Dtls(?,?,?,?,?,?,?,?,?,?,
							// ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?
							// ,?,?,?,?)}";//44
							strProcName = "{call Pkg_Mms_Dml2.Dml_Patemp_Issue_Items_Dtls(?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?   ,?,?,?,?)}";// 44
							nProcIndex = dao.setProcedure(strProcName);
							
							System.out.println("issue no---" + vo.getStrIssueNumber());
							System.out.println("Catg Code---" + vo.getStrBrandIdArray()[i].substring(0,2));
							System.out.println("getStrStoreId---" + vo.getStrStoreId());
							System.out.println("Item_Id---" + vo.getStrItemIdArray()[i]);
							System.out.println("Brand_Id---" + vo.getStrBrandIdArray()[i]);
							System.out.println("Batch_No---" + strBatchSlNoArray[j]);
							System.out.println("Req_Qty--" + j + "--" + strIssueQtyBtchWsArray[j]);
							System.out.println("manuf_date---" + strManufDateArray[j]);
							System.out.println("expiry_date---" + strExpiryDateArray[j]);
							System.out.println("getStrPuk---" + vo.getStrPuk());
							System.out.println("getStrSeatId---" + vo.getStrSeatId());
							System.out.println("getStrHospitalCode---" + vo.getStrHospitalCode());

							dao.setProcInValue(nProcIndex, "modeval", 			"1", 1);
							dao.setProcInValue(nProcIndex, "issueNo", 			vo.getStrIssueNumber(), 2);
							dao.setProcInValue(nProcIndex, "req_No", 			vo.getStrRequestNo(), 3);
							dao.setProcInValue(nProcIndex, "issuing_store_id", 	vo.getStrStoreId(), 4);
							dao.setProcInValue(nProcIndex, "reserved_qty_flag", "1", 5);
							dao.setProcInValue(nProcIndex, "category_No", 		vo.getStrBrandIdArray()[i].substring(0,2), 6);
							dao.setProcInValue(nProcIndex, "reqType_id", 		"32", 7);
							dao.setProcInValue(nProcIndex, "item_id", 			vo.getStrItemIdArray()[i], 8);
							dao.setProcInValue(nProcIndex, "item_brand_id", 	vo.getStrBrandIdArray()[i], 9);
							dao.setProcInValue(nProcIndex, "batchSl_no", 		strBatchSlNoArray[j], 10);
							dao.setProcInValue(nProcIndex, "hospital_code", 	vo.getStrHospitalCode(), 11);
							dao.setProcInValue(nProcIndex, "item_SlNo", 		strItemSlNoArray[j], 12);
							dao.setProcInValue(nProcIndex, "stock_status_code", "10", 13);
							dao.setProcInValue(nProcIndex, "group_id", 			vo.getStrGroupIdArray()[i], 14);
							dao.setProcInValue(nProcIndex, "subgroup_id", 		vo.getStrSubGroupIdArray()[i], 15);
							dao.setProcInValue(nProcIndex, "inhand_qty", 		"0", 16);
							dao.setProcInValue(nProcIndex, "inhand_qty_unitid", "6301", 17);
							dao.setProcInValue(nProcIndex, "bal_qty", 			"0", 18);
							dao.setProcInValue(nProcIndex, "bal_qty_unitid", 	"6301", 19);
							dao.setProcInValue(nProcIndex, "issue_qty", 		strIssueQtyBtchWsArray[j], 20);
							dao.setProcInValue(nProcIndex, "issue_qty_unitid", "6301", 21);
							dao.setProcInValue(nProcIndex, "manuf_date", 		strManufDateArray[j], 22);
							dao.setProcInValue(nProcIndex, "expiry_date", 		strExpiryDateArray[j], 23);
							dao.setProcInValue(nProcIndex, "rate", 				strRateArray[j], 24);
							dao.setProcInValue(nProcIndex, "rate_unitid", 		strRateUnitIdArray[j], 25);
							dao.setProcInValue(nProcIndex, "comsumable_flag", 	"0", 26);
							dao.setProcInValue(nProcIndex, "empNo", 			vo.getStrReqEmpNo(), 27);
							dao.setProcInValue(nProcIndex, "crNo", 				vo.getStrPuk(), 28);
							dao.setProcInValue(nProcIndex, "strEpiCode", 		temp[3], 29);
							dao.setProcInValue(nProcIndex, "strVisitNo", 		temp[4], 30);
							dao.setProcInValue(nProcIndex, "strAdmNo", 			temp[7], 31);
							dao.setProcInValue(nProcIndex, "strOrderBy", 		"0", 32);
							dao.setProcInValue(nProcIndex, "days", 				"0", 33);
							dao.setProcInValue(nProcIndex, "cost", 				String.valueOf(
									(Double.parseDouble(strRateArray[j]) * Double.parseDouble(strIssueQtyBtchWsArray[j]))),
									34);
							dao.setProcInValue(nProcIndex, "remarks", 	" OPD Issue Batch " + strBatchSlNoArray[j] + " Qty "
									+ strIssueQtyBtchWsArray[j] + "  Exp " + strExpiryDateArray[j], 35);
							dao.setProcInValue(nProcIndex, "seatId", 			vo.getStrSeatId(), 36);
							dao.setProcInValue(nProcIndex, "isUpdateOpdDrugReqDtl", "1", 37);
							dao.setProcInValue(nProcIndex, "dosage", 			"0", 38);
							dao.setProcInValue(nProcIndex, "frequency", 		"0", 39);
							dao.setProcInValue(nProcIndex, "presdays", 			"1", 40);
							dao.setProcInValue(nProcIndex, "patName", 			vo.getStrPatientDtlHidVal().split("\\^")[0], 41);
							dao.setProcInValue(nProcIndex, "issuedate", 		"", 42);
							dao.setProcOutValue(nProcIndex, "err", 				1, 	43);
							dao.setProcOutValue(nProcIndex, "costOut", 			1, 	44);
							dao.execute(nProcIndex, 1);
							/*
							System.out.println("-getStrRemarks------------>>" + vo.getStrRemarks());
							System.out.println("-getStrGroupIdArray------->>" + vo.getStrGroupIdArray()[i]);
							System.out.println("-getStrAvlQtyArray-------->>" + vo.getStrAvlQtyArray()[i]);
							System.out.println("-getStrAvlQtyUnitIdArray-->>" + vo.getStrAvlQtyUnitIdArray()[i]);
							System.out.println("-getStrBrandIdArray------->>" + vo.getStrBrandIdArray()[i]);
							System.out.println("-getStrItemIdArray-------->>" + vo.getStrItemIdArray()[i]);
							System.out.println("-getStrSubGroupIdArray---->>" + vo.getStrSubGroupIdArray()[i]);
							System.out.println("-getStrReservedFlagArray-->>" + vo.getStrReservedFlagArray()[i]);
							System.out.println("-strStochStatusCodeArray-->>" + strStochStatusCodeArray[j]);
							System.out.println("-strBatchSlNoArray-------->>" + strBatchSlNoArray[j]);
							System.out.println("-strItemSlNoArray--------->>" + strItemSlNoArray[j]);
							System.out.println("-strManufDateArray-------->>" + strManufDateArray[j]);
							System.out.println("-strExpiryDateArray------->>" + strExpiryDateArray[j]);
							System.out.println("-strRateArray------------->>" + strRateArray[j]);
							System.out.println("-strRateUnitIdArray------->>" + strRateUnitIdArray[j]);
							System.out.println("-strIssueQtyBtchWsArray--->>" + strIssueQtyBtchWsArray[j]);
							System.out.println("-strIssueQtyUnitBtchWsAr-->>" + strIssueQtyUnitBtchWsArray[j]);
							System.out.println("--------------------------------------------------------");
							*/
							/*
							 * 
							System.out.println("------------- bill_interface.dml_direct_pharmacy ------  D ------");							
							String proc_name2 = "{call bill_interface.dml_direct_pharmacy(?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?)}";
							procIndex2 = dao.setProcedure(proc_name2);			
							if (strBillTariff != null && strBillTariff != "") {

								strBillTariff = strBillTariff + "^" + vo.getStrBrandIdArray()[i];
							} else {
								strBillTariff = vo.getStrBrandIdArray()[i];
							}
							
							if (strBillRate != null && strBillRate != "") 
							{
								//strBillRate = strBillRate + "^" + userValue[9];
								strBillRate = strBillRate + "^0";
							} 
							else 
							{
								strBillRate = "0";
							}								
							
							if (strBillQty != null && strBillQty != "") {
								strBillQty = strBillQty + "^" + strIssueQtyBtchWsArray[j];
							} else {
								strBillQty = strIssueQtyBtchWsArray[j];
							}
							if (strBillBatch != null && strBillBatch != "") 
							{
								strBillBatch = strBillBatch + "^" + strBatchSlNoArray[j];
							} 
							else 
							{
								strBillBatch = strBatchSlNoArray[j];
							}	
							System.out.println("---------------------------");
							System.out.println("strBillTariff-----" + strBillTariff);
							System.out.println("strBillRate-------" + strBillRate);
							System.out.println("strBillQty--------" + strBillQty);
							System.out.println("strBillBatch------" + strBillBatch);
							System.out.println("---------------------------");				
							dao.setProcInValue(procIndex2, "modval", "1", 1);
							dao.setProcInValue(procIndex2, "gnum_dept_code", vo.getStrDeptCode(), 2);							
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
							*/
						   } // Check Qty >  0

						} // End Batch Wise Length
					} 
					else 
					{
						
						if (!vo.getStrTotalBatch()[i].equals("0")) 
						{
							if (vo.getStrCheckBatchExists()[i].equals("1") && Integer.parseInt(vo.getStrIssueQtyArray()[i])>0) 
							{
								System.out.println("------------AUTO -- NO  Batch Selection  ------ C -----------");
								System.out.println("-getStrTotalBatch----" + i + "---->>" + vo.getStrTotalBatch()[i]);	
								System.out.println("issue no---" + vo.getStrIssueNumber());
								System.out.println("Catg Code---" + vo.getStrBrandIdArray()[i].substring(0,2));
								System.out.println("getStrStoreId---" + vo.getStrStoreId());
								/*
								System.out.println("-StrItemDetailsChk-------->>" + vo.getStrItemDetailsChk()[i]);
								System.out.println("-getStrGroupIdArray------->>" + vo.getStrGroupIdArray()[i]);
								System.out.println("-getStrAvlQtyArray-------->>" + vo.getStrAvlQtyArray()[i]);
								System.out.println("-getStrAvlQtyUnitIdArray-->>" + vo.getStrAvlQtyUnitIdArray()[i]);
								System.out.println("-getStrIssueQtyArray------>>" + vo.getStrIssueQtyArray()[i]);
								System.out.println("-getStrBrandIdArray------->>" + vo.getStrBrandIdArray()[i]);
								System.out.println("-getStrItemIdArray-------->>" + vo.getStrItemIdArray()[i]);
								System.out.println("-getStrSubGroupIdArray---->>" + vo.getStrSubGroupIdArray()[i]);
								System.out.println("-getStrReservedFlagArray-->>" + vo.getStrReservedFlagArray()[i]);
								System.out.println("-getStrRemarks------------>>" + vo.getStrRemarks());
								*/
								System.out.println("--------------------------------------------------------");

								System.out.println("----Pkg_Mms_Dml2.Dml_Patemp_Issue_Items_Dtls--[ Mod  - 2 ]----------");

								strProcName = "{call Pkg_Mms_Dml2.Dml_Patemp_Issue_Items_Dtls(?,?,?,?,?,?,?,?,?,?,    ?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?   ,?,?,?,?)}";// 44
								nProcIndex = dao.setProcedure(strProcName);
							
								dao.setProcInValue(nProcIndex, "modeval", 				"2", 1);
								dao.setProcInValue(nProcIndex, "issueNo", 				vo.getStrIssueNumber(), 2);
								dao.setProcInValue(nProcIndex, "req_No", 				vo.getStrRequestNo(), 3);
								dao.setProcInValue(nProcIndex, "issuing_store_id", 		vo.getStrStoreId(), 4);
								dao.setProcInValue(nProcIndex, "reserved_qty_flag", 	"1", 5);
								dao.setProcInValue(nProcIndex, "category_No", 			vo.getStrBrandIdArray()[i].substring(0,2), 6);
								dao.setProcInValue(nProcIndex, "reqType_id", 			"32", 7);
								dao.setProcInValue(nProcIndex, "item_id", 				vo.getStrItemIdArray()[i], 8);
								dao.setProcInValue(nProcIndex, "item_brand_id", 		vo.getStrBrandIdArray()[i], 9);
								dao.setProcInValue(nProcIndex, "batchSl_no", 			"0", 10);
								dao.setProcInValue(nProcIndex, "hospital_code", 		vo.getStrHospitalCode(), 11);
								dao.setProcInValue(nProcIndex, "item_SlNo",             "0", 12);
								dao.setProcInValue(nProcIndex, "stock_status_code", 	"10", 13);
								dao.setProcInValue(nProcIndex, "group_id", 				vo.getStrGroupIdArray()[i], 14);
								dao.setProcInValue(nProcIndex, "subgroup_id", 			vo.getStrSubGroupIdArray()[i], 15);
								dao.setProcInValue(nProcIndex, "inhand_qty", 			vo.getStrAvlQtyArray()[i], 16);
								dao.setProcInValue(nProcIndex, "inhand_qty_unitid", 	"6301", 17);
								dao.setProcInValue(nProcIndex, "bal_qty", 				"0", 18);
								dao.setProcInValue(nProcIndex, "bal_qty_unitid", 		"6301", 19);
								dao.setProcInValue(nProcIndex, "issue_qty", 			vo.getStrIssueQtyArray()[i], 20);
								dao.setProcInValue(nProcIndex, "issue_qty_unitid", 		"6301", 21);
								dao.setProcInValue(nProcIndex, "manuf_date", 			"", 22);
								dao.setProcInValue(nProcIndex, "expiry_date", 			"", 23);
								dao.setProcInValue(nProcIndex, "rate", 					"0", 24);
								dao.setProcInValue(nProcIndex, "rate_unitid", 			"6301", 25);
								dao.setProcInValue(nProcIndex, "comsumable_flag", 		"0", 26);
								dao.setProcInValue(nProcIndex, "empNo", 				vo.getStrReqEmpNo(), 27);
								dao.setProcInValue(nProcIndex, "crNo", 					vo.getStrPuk(), 28);
								dao.setProcInValue(nProcIndex, "strEpiCode", 			"0", 29);
								dao.setProcInValue(nProcIndex, "strVisitNo", 			"0", 30);
								dao.setProcInValue(nProcIndex, "strAdmNo",
										vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[0], 31);
								dao.setProcInValue(nProcIndex, "strOrderBy", 			"0", 32);
								dao.setProcInValue(nProcIndex, "days", 					"0", 33);
								dao.setProcInValue(nProcIndex, "cost", 					"0", 34);
								dao.setProcInValue(nProcIndex, "remarks", 				vo.getStrRemarks(), 35);
								dao.setProcInValue(nProcIndex, "seatId",				vo.getStrSeatId(), 36);
								dao.setProcInValue(nProcIndex, "isUpdateOpdDrugReqDtl", "1", 37);
								dao.setProcInValue(nProcIndex, "dosage", 				"0", 38);
								dao.setProcInValue(nProcIndex, "frequency", 			"0", 39);
								dao.setProcInValue(nProcIndex, "presdays", 				"0", 40);
								dao.setProcInValue(nProcIndex, "patName", 				vo.getStrPatientDtlHidVal().split("\\^")[0], 41);
								dao.setProcInValue(nProcIndex, "issuedate", 			"", 42);
								dao.setProcOutValue(nProcIndex, "err", 					1, 43);
								dao.setProcOutValue(nProcIndex, "costOut", 				1, 44);
								dao.execute(nProcIndex, 1);
							} // Check Qty >  0
							else 
							{
								if (vo.getStrIssueQtyArray()[i] != null && vo.getStrIssueQtyArray()[i].length() > 0	&& !vo.getStrIssueQtyArray()[i].equals("")&& Integer.parseInt(vo.getStrIssueQtyArray()[i])>0) 
								{
									System.out.println("------------ Single Batch Selection  ------ D -----------");
									System.out.println("issue no---" + vo.getStrIssueNumber());
									System.out.println("Catg Code---" + vo.getStrBrandIdArray()[i].substring(0,2));
									System.out.println("-getStrIssueQtyArray----->>" + vo.getStrIssueQtyArray()[i]);
	
									System.out.println("----Pkg_Mms_Dml2.Dml_Patemp_Issue_Items_Dtls--[ Mod  - 1 ]----------");
									/*
									System.out.println("issue no---" + vo.getStrIssueNumber());
									System.out.println("Catg Code---" + vo.getStrBrandIdArray()[i].substring(0,2));
									System.out.println("getStrStoreId---" + vo.getStrStoreId());
									System.out.println("-StrItemDetailsChk------->>" + vo.getStrItemDetailsChk()[i]);
									System.out.println("-strSingleExpiry--------->>" + vo.getStrSingleExpiry()[i]);
									System.out.println("-setStrSingleBatch------->>" + vo.getStrSingleBatch()[i]);
									System.out.println("-getStrStockRate--------->>" + vo.getStrStockRate()[i]);
									System.out.println("-getStrStockQty---------->>" + vo.getStrStockQty()[i]);
									System.out.println("-getStrGroupIdArray------>>" + vo.getStrGroupIdArray()[i]);
									System.out.println("-getStrIssueQtyArray----->>" + vo.getStrIssueQtyArray()[i]);
									System.out.println("-getStrBrandIdArray------>>" + vo.getStrBrandIdArray()[i]);
									System.out.println("-getStrItemIdArray------->>" + vo.getStrItemIdArray()[i]);
									System.out.println("-getStrSubGroupIdArray--->>" + vo.getStrSubGroupIdArray()[i]);
									System.out.println("-getStrReservedFlagArray->>" + vo.getStrReservedFlagArray()[i]);
									System.out.println("-getStrSingleMfgDate----->>" + vo.getStrSingleMfgDate()[i]);
									System.out.println("-getStrRemarks----------->>" + vo.getStrRemarks());
									System.out.println("--------------------------------------------------------");
									*/
	
									strProcName = "{call Pkg_Mms_Dml2.Dml_Patemp_Issue_Items_Dtls(?,?,?,?,?,?,?,?,?,?,    ?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?   ,?,?,?,?)}";// 44
									nProcIndex = dao.setProcedure(strProcName);
	
									dao.setProcInValue(nProcIndex, "modeval", 			"1", 1);
									dao.setProcInValue(nProcIndex, "issueNo", 			vo.getStrIssueNumber(), 2);
									dao.setProcInValue(nProcIndex, "req_No", 			vo.getStrRequestNo(), 3);
									dao.setProcInValue(nProcIndex, "issuing_store_id",	vo.getStrStoreId(), 4);
									dao.setProcInValue(nProcIndex, "reserved_qty_flag", "1", 5);
									dao.setProcInValue(nProcIndex, "category_No", 		vo.getStrBrandIdArray()[i].substring(0,2), 6);
									dao.setProcInValue(nProcIndex, "reqType_id", 		vo.getStrReqTypeId(), 7);
									dao.setProcInValue(nProcIndex, "item_id", 			vo.getStrItemIdArray()[i], 8);
									dao.setProcInValue(nProcIndex, "item_brand_id", 	vo.getStrBrandIdArray()[i], 9);
									dao.setProcInValue(nProcIndex, "batchSl_no", 		vo.getStrSingleBatch()[i], 10);
									dao.setProcInValue(nProcIndex, "hospital_code", 	vo.getStrHospitalCode(), 11);
									dao.setProcInValue(nProcIndex, "item_SlNo", 		"0", 12);
									dao.setProcInValue(nProcIndex, "stock_status_code", "10", 13);
									dao.setProcInValue(nProcIndex, "group_id", 			vo.getStrGroupIdArray()[i], 14);
									dao.setProcInValue(nProcIndex, "subgroup_id", 		vo.getStrSubGroupIdArray()[i], 15);
									dao.setProcInValue(nProcIndex, "inhand_qty", 		vo.getStrStockQty()[i], 16);
									dao.setProcInValue(nProcIndex, "inhand_qty_unitid", "6301", 17);
									dao.setProcInValue(nProcIndex, "bal_qty", 			"0", 18);
									dao.setProcInValue(nProcIndex, "bal_qty_unitid", 	"6301", 19);
									dao.setProcInValue(nProcIndex, "issue_qty", 		vo.getStrIssueQtyArray()[i], 20);
									dao.setProcInValue(nProcIndex, "issue_qty_unitid", "6301", 21);
									dao.setProcInValue(nProcIndex, "manuf_date", 		vo.getStrSingleMfgDate()[i], 22);
									dao.setProcInValue(nProcIndex, "expiry_date", 		vo.getStrSingleExpiry()[i], 23);
									dao.setProcInValue(nProcIndex, "rate", 				vo.getStrStockRate()[i], 24);
									dao.setProcInValue(nProcIndex, "rate_unitid", 		"6301", 25);
									dao.setProcInValue(nProcIndex, "comsumable_flag", 	"0", 26);
									dao.setProcInValue(nProcIndex, "empNo", 			vo.getStrReqEmpNo(), 27);
									dao.setProcInValue(nProcIndex, "crNo", 				vo.getStrPuk(), 28);
									dao.setProcInValue(nProcIndex, "strEpiCode", 		"0", 29);
									dao.setProcInValue(nProcIndex, "strVisitNo", 		"0", 30);
									dao.setProcInValue(nProcIndex, "strAdmNo", 			vo.getStrReqAdmNo(), 31);
									dao.setProcInValue(nProcIndex, "strOrderBy", 		"0", 32);
									dao.setProcInValue(nProcIndex, "days", 				"0", 33);
									dao.setProcInValue(nProcIndex, "cost",
											String.valueOf((Double.parseDouble(vo.getStrStockRate()[i])
													* Double.parseDouble(vo.getStrIssueQtyArray()[i]))),
											34);
									dao.setProcInValue(nProcIndex, "remarks", " Batch " + vo.getStrSingleBatch()[i] + " Qty "
											+ vo.getStrIssueQtyArray()[i] + "  Exp " + vo.getStrSingleExpiry()[i], 35);
									dao.setProcInValue(nProcIndex, "seatId", 			vo.getStrSeatId(), 36);
									dao.setProcInValue(nProcIndex, "isUpdateOpdDrugReqDtl", "1", 37);
									dao.setProcInValue(nProcIndex, "dosage", 			"0", 38);
									dao.setProcInValue(nProcIndex, "frequency", 		"0", 39);
									dao.setProcInValue(nProcIndex, "presdays", 			"0", 40);
									dao.setProcInValue(nProcIndex, "patName", 			vo.getStrPatientDtlHidVal().split("\\^")[0], 41);
									dao.setProcInValue(nProcIndex, "issuedate", 		"", 42);
									dao.setProcOutValue(nProcIndex, "err", 				1, 43);
									dao.setProcOutValue(nProcIndex, "costOut", 			1, 44);
									dao.execute(nProcIndex, 1);
									
									/*
									if (strBillTariff != null && strBillTariff != "") {
	
										strBillTariff = strBillTariff + "^" + vo.getStrBrandIdArray()[i];
									} else {
										strBillTariff = vo.getStrBrandIdArray()[i];
									}
									
									if (strBillRate != null && strBillRate != "") 
									{
										//strBillRate = strBillRate + "^" + userValue[9];
										strBillRate = strBillRate + "^0";
									} 
									else 
									{
										strBillRate = "0";
									}								
									
									if (strBillQty != null && strBillQty != "") {
										strBillQty = strBillQty + "^" + vo.getStrIssueQtyArray()[i];
									} else {
										strBillQty = vo.getStrIssueQtyArray()[i];
									}
									if (strBillBatch != null && strBillBatch != "") 
									{
										strBillBatch = strBillBatch + "^" + vo.getStrSingleBatch()[i];
									} 
									else 
									{
										strBillBatch = vo.getStrSingleBatch()[i];
									}
									
									
									System.out.println("------------- bill_interface.dml_direct_pharmacy ------  D ------");							
									String proc_name2 = "{call bill_interface.dml_direct_pharmacy(?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?)}";
									procIndex2 = dao.setProcedure(proc_name2);				
									System.out.println("---------------------------");
									System.out.println("strBillTariff-----" + strBillTariff);
									System.out.println("strBillRate-------" + strBillRate);
									System.out.println("strBillQty--------" + strBillQty);
									System.out.println("strBillBatch------" + strBillBatch);
									System.out.println("---------------------------");				
									dao.setProcInValue(procIndex2, "modval", "1", 1);
									dao.setProcInValue(procIndex2, "gnum_dept_code", vo.getStrDeptCode(), 2);							
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
									*/
							   }// Check Qty >  0
	                           
							}

						} // End Loop If Total Batch is Greater Than > 0
					}
				}
				dao.fire();

				debugPoint = 21;

				System.out.println(" -------- OPDIssueToPatAutoTransDAO .NEW_OPD_ISSUE  ---- END ---- ");

			} catch (Exception e) {
				e.printStackTrace();
				vo.setStrMsgType("1");
				vo.setStrMsgString("OPDIssueToPatAutoTransDAO.insert() --> " + e.getMessage() + " DAO_DEBUG_POINT :: " + debugPoint
						+ " DAO_VALUE :: " + itemValue);
			} finally {

				if (dao != null) {
					dao.free();
					dao = null;
				}

			}
		}


	 
	 

}