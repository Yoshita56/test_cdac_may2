package mms.transactions.dao;

import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import billing.CashCollectionOfflineTransVO;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
//import billing.transactions.LFNoTransVO;
import mms.MmsConfigUtil;
import mms.dao.DmlHsttPatEmpIssueDtlDAO;
import mms.dao.DmlHsttPatEmpIssueDtlWithoutCrNoDAO;
import mms.dao.DmlHsttPatEmpIssueItemDtlDAO;
import mms.dao.DmlHsttPatEmpIssueItemDtlWithoutCrNoDAO;
import mms.transactions.controller.fb.IssueTransFB;
import mms.transactions.vo.IssueTransVO;
import mms.transactions.vo.NewIPDIssueToPatTransVO;
import mms.transactions.vo.IssueTransVO;

public class IssueTransDAO {

	public static void getPatientDepartmentDtls(IssueTransVO vo) {
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

	public static void getPatientAddmissionFlag(IssueTransVO vo) {
		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		try {
			dao = new HisDAO("MMSModule", "IssueTransDAO");

			funcIndex = dao.setFunction("{? = call MMS_MST.get_patient_Admission_status(?,?,?)}");

			System.out.println(" ------- IssueTransDAO .MMS_MST.get_patient_Admission_status  -------- ");

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
			vo.setStrMsgString("IssueTransDAO.getPatientAddmissionFlag() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void getPatientTreatmentDetailfrmIpd(IssueTransVO voObj) { // added by shalini to get treatment detail
																				// given at IPD Doctor Desk

		String strErr = "";

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_IssueItem_Dtl(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		try {

			System.out.println("<<------ RequestForLPPatientDAO.getPatientTreatmentDetailfrmIpd             ------>>");
			System.out.println("<<------ PKG_MMS_VIEW.Proc_IssueItem_Dtl     [Mode - 2 ]    ------>>");

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 2);
			daoObj.setProcInValue(nProcIndex, "reqNo", "10", 3);
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

		} catch (Exception e) {

			voObj.setStrMsgString("AdmissionAdviceTransDAO.getIcd10DiagnosisDtl() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getPatientTreatmentHLPForIssue(IssueTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call PKG_MMS_VIEW2.PROC_HRGT_PATIENT_TREATMENT_DTL(?,?,?,?,? ,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO.getPatientTreatmentHLPForIssue");

			nProcIndex = daoObj.setProcedure(strProcName);

			if (voObj.getStrCrNo() != null && !voObj.getStrCrNo().equals("")) {

				daoObj.setProcInValue(nProcIndex, "modeVal", "3", 1);
				daoObj.setProcInValue(nProcIndex, "puk", voObj.getStrCrNo(), 2);
				daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 3);
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
			voObj.setStrMsgString("PatientDtlDAO.setPatientTreatmentHLPForIssue() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
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
	public static void getIssueDtlsList_OLD(IssueTransVO vo) {
		String err;
		// String strSlNoflg;
		HisDAO dao = null;
		WebRowSet ws = null;
		int procIndex1 = 0;
		String proc_name1 = "{call pkg_mms_view.Proc_Emp_Issue_Detail(?,?,?,?,?,?)}"; // 6
		try {
			System.out.println(" ------- IssueTransDAO .getIssueDtlsList  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_Emp_Issue_Detail  --[ Mode- 2 ]------ ");

			/*
			 * Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line
			 * Issue Voucher) 1.Hospital Name ^ DDC Name ^ Prescribe For ^ Issue No ^ Issued
			 * By Doctor ^ Date ^ Cr No ^ Hindi Text 2.Drug Name 3.Batch No 4.Exp Date
			 * 5.Issue Qty
			 */
			dao = new HisDAO("mms", "global.IssueTransDAO.getStockItemDtlsList(IssueTransVO vo)");
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
			vo.setStrMsgString("IssueTransDAO.getIssueDtlsList() --> " + e.getMessage());
			vo.setStrMsgType("1");

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
	 * @return the issue dtls list
	 * This Function is Used To Get Ajax Voucher Details
	 */// Modified by Neha Sharma on 16th July 2013 ..
	public static void getIssueDtlsList(IssueTransVO vo) 
	{
		String err;
		//String strSlNoflg;
		HisDAO        dao = null;
		WebRowSet      ws = null;
		int    procIndex1 = 0;
		String proc_name1 = "{call pkg_mms_view.Proc_Emp_Issue_Detail(?,?,?,?,?,?)}"; //6
		try 
		{
			System.out.println(" ------- NewIPDIssueToPatTransDAO .getIssueDtlsList  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_Emp_Issue_Detail  --[ Mode- 3 ]------ ");
			
			/*
			  Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line Issue Voucher)
			  1.Hospital Name ^ DDC Name ^ Prescribe For ^ Issue No ^ Issued By Doctor ^ Date ^ Cr No ^ Hindi Text  
			  2.Drug Name
			  3.Batch No 
			  4.Exp Date
			  5.Issue Qty
			 */				
			dao = new HisDAO("mms","IssueTransDAO.IssueTransVO(IssueTransVO vo)");			
			procIndex1 = dao.setProcedure(proc_name1);
			// set value
			dao.setProcInValue(procIndex1, "modeval", 		"3",1);
			dao.setProcInValue(procIndex1, "strId", 		vo.getStrStoreId(),3);			
			dao.setProcInValue(procIndex1, "issueNo", 		vo.getStrIssueNumber(),2);
			dao.setProcInValue(procIndex1, "hosp_code", 	vo.getStrHospitalCode(),4);
			dao.setProcOutValue(procIndex1,"ERR", 			1,5); // 1 for string return
			dao.setProcOutValue(procIndex1, "RESULTSET", 	2,6); // 2 for object
			// execute procedure
			dao.executeProcedureByPosition(procIndex1);
			// get value
			err = dao.getString(procIndex1, "ERR");
			if (err == null)
				err = "";
			ws = dao.getWebRowSet(procIndex1, "RESULTSET");
			vo.setWsIssueDetails(ws);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
            //e.printStackTrace();
			vo.setStrMsgString("NewIPDIssueToPatTransDAO.getIssueDtlsList() --> "+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	public static void getStoreList(IssueTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		try {
			System.out.println(" ------- IssueTransDAO .getStoreList  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_hstt_store_mst  --[ Mode- 12 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");
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
			voObj.setStrMsgString("IssueTransDAO.getStoreList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getViewStoreList(IssueTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- IssueTransDAO .getViewStoreList  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_hstt_store_mst  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");

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
			voObj.setStrMsgString("IssueTransDAO.getViewStoreList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getPatinetTypeCmb(IssueTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_raol_catg_list(?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		try {

			System.out.println(" ------- IssueTransDAO .getPatinetTypeCmb  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_raol_catg_list  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");

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
			voObj.setStrMsgString("IssueTransDAO.getPatinetTypeCmb() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getItemCatDtls(IssueTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- IssueTransDAO .getItemCatDtls  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_item_category_list  --[ Mode- 6 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "6", 1);
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
			voObj.setStrMsgString("IssueTransDAO.getItemCatDtls() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void GET_PAT_ACC_STATUS(IssueTransVO vo) {
		String proc_name1 = "";
		proc_name1 = "{call PKG_MMS_VIEW.proc_hblt_pataccount_dtl(?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		int procIndex1 = 0;
		String strerr = "";
		WebRowSet ws = null;
		try {
			System.out.println("------------- IssueTransDAO.GET_PAT_ACC_STATUS -------------");

			System.out.println("------------- PKG_MMS_VIEW.proc_hblt_pataccount_dtl --[ Mode - 14 ]-----------");

			/*
			 * 0 - Ac Balance 1 - Patient Catg Code 2 - ADMISSION_DATE 3 - DISCHARGE_DATE 4
			 * - PATACCOUNT_STATUS in Text 5 - HBLNUM_PATACCOUNT_STATUS 6 - GETCATGRP 7 -
			 * HBLNUM_ACCOUNT_TYPE 8 - hblnum_finalbill_flag
			 * 
			 */
			dao = new HisDAO("mms", "IssueTransDAO.getAccountDtlWithAcctNo()");
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
			vo.setStrMsgString("IssueTransDAO.GET_PAT_ACC_STATUS() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getItemCatDtls1(IssueTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- IssueTransDAO .getItemCatDtls1  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_item_category_list  --[ Mode- 3 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");

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
			voObj.setStrMsgString("IssueTransDAO.getItemCatDtls() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void getissuetopatient(IssueTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String proc_name1 = "{call Pkg_Mms_View.proc_patient_issue_drug_dtl(?,?,? ,?,?,? ,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";
		System.out.println("<------------- IssueTransDAO.getissuetopatient ------------->");

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
			vo.setStrMsgString("IssueTransDAO.getIssueDetailTwo() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getCancelIssueDtls(IssueTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_issue_item_dtls(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			System.out.println(" ------- IssueTransDAO .getCancelIssueDtls  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_issue_item_dtls  --[ Mode- 3 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");
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
			voObj.setStrMsgString("IssueTransDAO.getCancelIssueDtls() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void getIssueDetail(IssueTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Issue_Details(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- IssueTransDAO .getCancelIssueDtls  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_Issue_Details  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modval", "1", 1);
			daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStoreId(), 2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 3);
			daoObj.setProcInValue(nProcIndex, "crNo", voObj.getStrCrNum(), 4);
			daoObj.setProcInValue(nProcIndex, "catCode", voObj.getStrCatCode(), 5);
			daoObj.setProcInValue(nProcIndex, "days", "10", 6);
			daoObj.setProcInValue(nProcIndex, "empNo", "", 7);// default value.
			daoObj.setProcOutValue(nProcIndex, "err", 1, 8);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 9);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				/*
				 * while(ws.next()) { //System.out.println("ws.getstring()"+ws.getString(1));
				 * //System.out.println("ws.getstring()"+ws.getString(2)); }
				 */
				voObj.setStrIssueDetailWs(ws);

				//// System.out.println("voObj.getStrIssueDetailWs()"+voObj.getStrIssueDetailWs().getString(1));

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("IssueTransDAO.getIssueDetail() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getIssueDetailTwo(IssueTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String proc_name1 = "{call Pkg_Mms_View.proc_patient_issue_drug_dtl(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			System.out.println(" ------- IssueTransDAO .getIssueDetailTwo  -------- ");
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
			vo.setStrMsgString("IssueTransDAO.getIssueDetailTwo() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getIssueDtlPopUp(IssueTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call  Pkg_Mms_View.Proc_IssuePopup_Dtls(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- IssueTransDAO .getIssueDtlPopUp  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_IssuePopup_Dtls  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");

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
			voObj.setStrMsgString("IssueTransDAO.getIssueDtlPopUp() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getRequestDtls(IssueTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Issue_Request_Dtls(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";
		int funcIndex;
		String BillingValue = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");

			System.out.println("<------------- IssueTransDAO.getRequestDtls() ------------->");

			System.out.println("<------------- bill_mst.get_pat_accountdetails_limit [ Mode - 2 ] ------------->");

			funcIndex = daoObj.setFunction("{? = call bill_mst.get_pat_accountdetails_limit(?,?,?)}");

			daoObj.setFuncInValue(funcIndex, 2, voObj.getStrHospitalCode());
			daoObj.setFuncInValue(funcIndex, 3, "2");
			daoObj.setFuncInValue(funcIndex, 4, voObj.getStrCrNumber());
			// daoObj.setFuncInValue(funcIndex, 5,_LPIssueTransVO.getStrItemCategNo());
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
			voObj.setStrMsgString("IssueTransDAO.getRequestDtls() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	public static void getFrontPageOnlineRequestDtls(IssueTransVO voObj) 
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Issue_Request_Dtls(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";
		int funcIndex;
		String BillingValue = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");

			System.out.println("<------------- IssueTransDAO.getFrontPageOnlineRequestDtls() ------------->");
			
			System.out.println("<------------- Pkg_Mms_View.Proc_Issue_Request_Dtls [ Mode - 2 ] ------------->");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", 	 "2", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", 	 voObj.getStrHospitalCode(), 2);
			daoObj.setProcInValue(nProcIndex, "crNo", 		(voObj.getStrCrNo()==null||voObj.getStrCrNo().equals(""))?"0":voObj.getStrCrNo(), 3);
			daoObj.setProcInValue(nProcIndex, "days", 		(voObj.getStrDeptCode()==null||voObj.getStrDeptCode().equals(""))?"0":voObj.getStrDeptCode(), 4);
			daoObj.setProcOutValue(nProcIndex, "err", 		 1, 5);
			daoObj.setProcOutValue(nProcIndex, "resultset",  2, 6);

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
			voObj.setStrMsgString("IssueTransDAO.getRequestDtls() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getOnlineTreatmentDtls(IssueTransFB formBean, IssueTransVO vo) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_mms_view.PROC_HRGT_PATIENT_TREATMENT_DTL_ONLINE(?,?,?,?,?,? ,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		String strCrNum = formBean.getStrCrNo();
		String strHospcode = formBean.getStrHospitalCode();

		String strStoreId = formBean.getStrStoreId().split("\\^")[0];
		try {

			System.out.println(" ------- IssueTransDAO .getOnlineTreatmentDtls  -------- ");
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

	public static void getAlreadyDrugIssue(IssueTransFB formBean, IssueTransVO vo) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_mms_view.PROC_HRGT_PATIENT_TREATMENT_DTL_ONLINE(?,?,?,?,?,? ,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		String strCrNum = formBean.getStrCrNo();
		String strHospcode = vo.getStrHospitalCode();

		try {

			System.out.println(" ------- IssueTransDAO .getAlreadyDrugIssue  -------- ");
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
				System.out.println("Already Development" + ws.size());
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

	public static void getRequestDetails(IssueTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Request_Dtls(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- IssueTransDAO .getRequestDetails  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_Request_Dtls  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");

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
			voObj.setStrMsgString("IssueTransDAO.getRequestDetails() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getFrequencyDetails(IssueTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet strFrequencyWs = null;

		String strProcName = "{call Pkg_Mms_View.proc_frequency_dtl(?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println("<------------- IssueTransDAO.getFrequencyDetails() ------------->");

			System.out.println("<------------- Pkg_Mms_View.proc_frequency_dtl ------------->");

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");

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
			voObj.setStrMsgString("IssueTransDAO.getFrequencyDetails() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getDoseDetails(IssueTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet strDosageWs = null;

		String strProcName = "{call Pkg_Mms_View.proc_dosage_dtl(?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");

			System.out.println("<------------- IssueTransDAO.getDoseDetails() ------------->");

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
			voObj.setStrMsgString("IssueTransDAO.getDoseDetails() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getDeptDetails(IssueTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_department(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- IssueTransDAO .getDeptDetails  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_department  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");

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
			voObj.setStrMsgString("IssueTransDAO.getDeptDetails() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getUnitDetails(IssueTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Unit(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- IssueTransDAO .getUnitDetails  ---(Dept Wise Unit)----- ");
			System.out.println(" ------- pkg_mms_view.Proc_Unit  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");

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
			voObj.setStrMsgString("IssueTransDAO.getUnitDetails() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getPrescribedBy(IssueTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Consultant_Name(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- IssueTransDAO .getPrescribedBy  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_Consultant_Name  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");

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
			voObj.setStrMsgString("IssueTransDAO.getPrescribedBy() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getItemDetails(IssueTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_IssueItem_Dtl(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- IssueTransDAO .getItemDetails  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_IssueItem_Dtl  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");

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
			voObj.setStrMsgString("IssueTransDAO.getItemDetails() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getUnitCombo(IssueTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_mms_view.proc_gblt_unit_mst(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println(" ------- IssueTransDAO .getUnitCombo  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_gblt_unit_mst  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");

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
			voObj.setStrMsgString("IssueTransDAO.getUnitCombo() --> " + e.getMessage());
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

	public static void getStoreGroupList(IssueTransVO vo) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			System.out.println("<------------- IssueTransDAO.getStoreGroupList() ------------->");
			System.out.println("<------------- pkg_mms_view.proc_store_group_list [ Mode - 2 ]------------->");

			dao = new HisDAO("MMS Transactions", "IssueTransDAO");

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
			vo.setStrMsgString("IssueTransDAO.getStoreGroupList() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}

	

	public static synchronized void new_ipd_issue(IssueTransVO vo) {

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
		String strBillBatch = "";
		String strBillRate = "";
		String strBillQty = "";

		MmsConfigUtil mcu;

		String[] temp = null;
		String[] strtemp = null;
		String issueRemarks = "";

		int chkLength = 0;

		String strItemIdArray[] = null;
		String strBrandIdArray[] = null;
		String strReservedFlagArray[] = null;
		String stockDtlsId[] = null; // StoreId^Generic_ItemId^Brand_ItemId^Stock_Status_Code^Batch_No^Serial_No
		String strStochStatusCodeArray[] = null;
		String strGroupIdArray[] = null;
		String strSubGroupIdArray[] = null;
		String strAvlQtyArray[] = null;
		String strAvlQtyUnitIdArray[] = null;
		String strConsumableFlagArray[] = null;

		String[] values = null;

		String strProcName = "";
		int nProcIndex = 0;
		
		String strProcNameIssue = "";
		int nProcIndexIssue = 0;

		try {

			System.out.println(" *********** IssueTransDAO .NEW_IPD_ISSUE  ---- START --[ AUTO BATCH SELECTION ] *********** ");

			System.out.println("-------getStrHospitalCode------" + vo.getStrHospitalCode());
			System.out.println("-------getStrStoreId------" + vo.getStrStoreId());
						
			debugPoint = 1;
			
			dao = new HisDAO("MMS Transactions", "IssueTransDAO");
			dmlhsttpatempissueitemdtl = new DmlHsttPatEmpIssueItemDtlDAO();
			dmlhsttpatempissuedtl = new DmlHsttPatEmpIssueDtlDAO();
			strFuncName = "{? = call MMS_MST.generate_issueNo(?::numeric,?::numeric,?::numeric,?::numeric)}";
			nFuncIndex = dao.setFunction(strFuncName);

			dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId());
			dao.setFuncInValue(nFuncIndex, 4, "35"); // Issue To Patient [IPD]
			dao.setFuncInValue(nFuncIndex, 5, "10");
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strIssueNo = dao.getFuncString(nFuncIndex);
			System.out.println("-------strIssueNo------" + strIssueNo);
			vo.setStrIssueNumber(strIssueNo.split("\\^")[0]);

			debugPoint = 2;

			strVisitDtl = "0";
			String strEpisodeCode = vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[1];
			String strVisitNo = "0";

			dao = new HisDAO("MMS Transactions", "IssueTransDAO");
			// length = vo.getItemParamValue().length;

			debugPoint = 12;

			//System.out.println("-getStrAdmissionDtlHidVal-----" + vo.getStrAdmissionDtlHidVal());
			/*
			 * 0 NVL(HIPNUM_ADMNO, '0') 1 ^ NVL(HRGNUM_EPISODE_CODE, '0') 2 ^
			 * NVL(HRGNUM_VISIT_NO,'0') 3 ^ NVL(TO_CHAR(HIPDT_ADMDATETIME,'DD-Mon-YYYY
			 * HH24:MI:SS'),' ') 4 ^ NVL(HIPNUM_ADM_ADVNO,'0') 5 ^ NVL(GNUM_DEPT_CODE,'000')
			 * 6 ^ NVL(HIPNUM_WARD_CODE,'0') 7 ^ NVL(HIPNUM_ROOM_CODE,'0') 8 ^
			 * NVL(HIPNUM_BED_CODE,'0') 9 ^ NVL(HIPNUM_TREAT_CATEG_CODE,'0') 10 ^
			 * NVL(HIPNUM_ISNEWBORN,'0') 11 ^ NVL(HIPNUM_MOTHADMNO,'0') 12 ^
			 * NVL(HRGNUM_MLC_NO,'0') 13 ^ NVL(HIPNUM_OCCUP_ID,'0') 14 ^
			 * NVL(TO_CHAR(HIPDT_BEDALLOC_DATETIME,'DD-Mon-YYYY HH24:MI:SS'),' ') 15 ^
			 * NVL(HIPNUM_LENGTHOFSTAY,'0')) 16 ^ NVL(GNUM_DEPTUNIT_CODE,'00000') 17 ^
			 * hblnum_pataccount_status
			 */
			
			
            /* 
			dmlhsttpatempissuedtl.setStrStoreId(vo.getStrStoreId());
			dmlhsttpatempissuedtl.setStrIssueNo(vo.getStrIssueNumber());
			dmlhsttpatempissuedtl.setStrHospitalCode(vo.getStrHospitalCode());
			dmlhsttpatempissuedtl.setStrRequestNo(vo.getStrRequestNo());
			dmlhsttpatempissuedtl.setStrOrderBy(vo.getStrReqPrescribedBy());

			debugPoint = 13;

			dmlhsttpatempissuedtl.setStrOrderDate(vo.getStrReqPrescriptionDate());
			dmlhsttpatempissuedtl.setStrDays(vo.getStrPrescriptionFor());
			dmlhsttpatempissuedtl.setStrCrNo(vo.getStrPuk());
			dmlhsttpatempissuedtl.setStrReqTypeId("35");// Issue To Patient [IPD]
			dmlhsttpatempissuedtl.setStrAdmNo(vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[0]);

			debugPoint = 14;

			dmlhsttpatempissuedtl.setStrEmpNo(vo.getStrReqEmpNo());
			dmlhsttpatempissuedtl.setStrItemCatNo(vo.getStrItemCat());
			dmlhsttpatempissuedtl.setStrFinalCost(DmlHsttPatEmpIssueItemDtlDAO.getIntCost() + "");
			dmlhsttpatempissuedtl.setStrFinStartDate("01-Apr-2024");
			dmlhsttpatempissuedtl.setStrFinEndDate("31-Mar-2025");

			debugPoint = 15;

			dmlhsttpatempissuedtl.setStrSeatId(vo.getStrSeatId());
			dmlhsttpatempissuedtl.setStrDeptUnitCode(vo.getStrUnitCode());
			dmlhsttpatempissuedtl.setStrVisitType("2");// hardcoded in case of ipd patient
			dmlhsttpatempissuedtl.setStrDeptCode(vo.getStrDeptCode());

			dmlhsttpatempissuedtl.setStrWardCode(vo.getStrReqWardCode());

			debugPoint = 16;

			issueRemarks = "IPD Issue To Patient " + vo.getStrPatientDtlHidVal().split("\\^")[7] + " Against Issue No "
					+ vo.getStrIssueNo() + " On Date " + vo.getStrIssueDate();

			vo.setStrRemarks(issueRemarks);

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
			*/
			
			issueRemarks = "IPD Issue To Patient " + vo.getStrPatientDtlHidVal().split("\\^")[7] + " Against Issue No "
					+ vo.getStrIssueNo() + " On Date " + vo.getStrIssueDate();
			
			System.out.println("---------- Pkg_Mms_Dml2.Dml_Patemp_Issue_Dtls--[ Mode  - 1 ] ----------");
			strProcNameIssue = "{call Pkg_Mms_Dml2.Dml_Patemp_Issue_Dtls(?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?    ,?,?,?,?,?)}";//40
			nProcIndexIssue = dao.setProcedure(strProcNameIssue);
			
			dao.setProcInValue(nProcIndexIssue, "modeval", 				"1",1);
			dao.setProcInValue(nProcIndexIssue, "strStoreId", 			vo.getStrStoreId(),2);
			dao.setProcInValue(nProcIndexIssue, "req_No",				vo.getStrRequestNo(),3);
			dao.setProcInValue(nProcIndexIssue, "strIssueNo", 			vo.getStrIssueNumber().split("\\^")[0],4); 
			dao.setProcInValue(nProcIndexIssue, "hosp_code", 			vo.getStrHospitalCode(),5);
			dao.setProcInValue(nProcIndexIssue, "strOrderBy", 			vo.getStrReqPrescribedBy(),6);
			dao.setProcInValue(nProcIndexIssue, "strOrderDate",			vo.getStrReqPrescriptionDate(),7);
			dao.setProcInValue(nProcIndexIssue, "days",					vo.getStrPrescriptionFor(),8); 
			dao.setProcInValue(nProcIndexIssue, "strCrNo", 				vo.getStrPuk(),9);
			dao.setProcInValue(nProcIndexIssue, "strReqTypeId",			"35",10);
			dao.setProcInValue(nProcIndexIssue, "stradmno", 			vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[0],11);
			dao.setProcInValue(nProcIndexIssue, "strempno", 			vo.getStrReqEmpNo(),12);
			dao.setProcInValue(nProcIndexIssue, "strItemCatNo", 		"10",13);
			dao.setProcInValue(nProcIndexIssue, "strFinalCost", 		"0",14); 
			dao.setProcInValue(nProcIndexIssue, "strFinStartDate", 		"01-Apr-2024",15);
			dao.setProcInValue(nProcIndexIssue, "strFinEndDate",		"31-Mar-2025",16);						
			dao.setProcInValue(nProcIndexIssue, "strSeatId", 			vo.getStrSeatId(),17);
			dao.setProcInValue(nProcIndexIssue, "strDeptUnitCode",		vo.getStrUnitCode(),18);
			dao.setProcInValue(nProcIndexIssue, "strVisitType", 		"2",19);
			dao.setProcInValue(nProcIndexIssue, "strDeptCode", 			vo.getStrDeptCode(),20);
			dao.setProcInValue(nProcIndexIssue, "strWardCode", 			vo.getStrReqWardCode(),21); 
			dao.setProcInValue(nProcIndexIssue, "strRecieveBy",			vo.getStrReceiveBy(),22); 
			dao.setProcInValue(nProcIndexIssue, "strRemarks",			issueRemarks.trim(),23);
			dao.setProcInValue(nProcIndexIssue, "strReqDate",			"",24);
			dao.setProcInValue(nProcIndexIssue, "strEpiCode",			strEpisodeCode,25);			
			dao.setProcInValue(nProcIndexIssue, "strVisitNo",			strVisitNo.trim(),26);					
			dao.setProcInValue(nProcIndexIssue, "p_first_name",			vo.getStrPatientDtlHidVal().split("\\^")[7],27);
			dao.setProcInValue(nProcIndexIssue, "p_middle_name",		"",28); 
			dao.setProcInValue(nProcIndexIssue, "p_last_name",			"",29);			
			dao.setProcInValue(nProcIndexIssue, "p_hststr_father_name",	vo.getStrPatientDtlHidVal().split("\\^")[8],30);
			dao.setProcInValue(nProcIndexIssue, "p_hstdt_age",		   	vo.getStrPatientDtlHidVal().split("\\^")[0],31);
			dao.setProcInValue(nProcIndexIssue, "p_gnum_gender_code",  	vo.getStrPatientDtlHidVal().split("\\^")[1],32);
			dao.setProcInValue(nProcIndexIssue, "p_hststr_address",    	vo.getStrPatientHiddenValue1().split("\\^")[3],33);
			dao.setProcInValue(nProcIndexIssue, "p_hststr_patient_id", 	vo.getStrPatientId(),34);
			dao.setProcInValue(nProcIndexIssue, "p_hstnum_patient_type","18",35);			
			dao.setProcInValue(nProcIndexIssue, "p_trans_type",         "1",36);
			
			dao.setProcInValue(nProcIndexIssue, "p_age_unit",			"0",37);		
			dao.setProcInValue(nProcIndexIssue, "p_issue_date",			vo.getStrDrugIssueDate(),38);
			dao.setProcInValue(nProcIndexIssue, "p_out_stock",			vo.getStrOutOfStockFlag(),39);			
			dao.setProcOutValue(nProcIndexIssue, "err", 				1,40);		
			dao.execute(nProcIndexIssue, 1);
			

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

					System.out.println(" ########## AUTO With BATCH SELECTION ->  A ##########");
					//System.out.println("-------vo.getStockDtlsId()[" + i + "]------" + vo.getStockDtlsId()[i]);
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

						if (j == 0) {
							System.out.println("----Pkg_Mms_Dml2.Dml_Patemp_Issue_Items_Dtls--[ Mode  - 6 ]----------");
						}

						strProcName = "{call Pkg_Mms_Dml2.Dml_Patemp_Issue_Items_Dtls(?,?,?,?,?,?,?,?,?,?,    ?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?   ,?,?,?,?)}";// 44
						nProcIndex = dao.setProcedure(strProcName);
						
						String admissionDtl = vo.getStrAdmissionDtlHidVal().replaceAll("[!@$%^&]", "#");
						String patDtl = vo.getStrPatientDtlHidVal().replaceAll("[!@$%^&]", "#");
						
						System.out.println("Issue Qty -A.--" + j + "-->>"+strIssueQtyBtchWsArray[j]);
						System.out.println("Catg_Code -A.--" + j + "-->>"+vo.getStrBrandIdArray()[i].substring(0, 2));
						System.out.println("Batch     -A.--" + j + "-->>"+strBatchSlNoArray[j]);

						dao.setProcInValue(nProcIndex, "modeval", 			"6", 1);
						dao.setProcInValue(nProcIndex, "issueNo", 			vo.getStrIssueNumber(), 2);
						dao.setProcInValue(nProcIndex, "req_No", 			vo.getStrRequestNo(), 3);
						dao.setProcInValue(nProcIndex, "issuing_store_id", 	vo.getStrStoreId(), 4);
						dao.setProcInValue(nProcIndex, "reserved_qty_flag", "1", 5);
						dao.setProcInValue(nProcIndex, "category_No", 		vo.getStrBrandIdArray()[i].substring(0, 2), 6);
						dao.setProcInValue(nProcIndex, "reqType_id", 		vo.getStrReqTypeId(), 7);
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
						dao.setProcInValue(nProcIndex, "strEpiCode", 		strEpisodeCode, 29);
						dao.setProcInValue(nProcIndex, "strVisitNo", 		strVisitNo, 30);
						dao.setProcInValue(nProcIndex, "strAdmNo", 			vo.getStrReqAdmNo(), 31);
						dao.setProcInValue(nProcIndex, "strOrderBy", 		"0", 32);
						dao.setProcInValue(nProcIndex, "days", 				"0", 33);
						dao.setProcInValue(nProcIndex, "cost", 				String.valueOf(
								(Double.parseDouble(strRateArray[j]) * Double.parseDouble(strIssueQtyBtchWsArray[j]))),
								34);
						dao.setProcInValue(nProcIndex, "remarks", 	" Batch " + strBatchSlNoArray[j] + " Qty "
								+ strIssueQtyBtchWsArray[j] + "  Exp " + strExpiryDateArray[j], 35);
						dao.setProcInValue(nProcIndex, "seatId", 			vo.getStrSeatId(), 36);
						dao.setProcInValue(nProcIndex, "isUpdateOpdDrugReqDtl", "1", 37);
						//dao.setProcInValue(nProcIndex, "dosage", 			"0", 38);
						//dao.setProcInValue(nProcIndex, "frequency", 		"0", 39);
						dao.setProcInValue(nProcIndex, "dosage", 			admissionDtl, 38);
						dao.setProcInValue(nProcIndex, "frequency", 		patDtl, 39);
						dao.setProcInValue(nProcIndex, "presdays", 			"0", 40);
						dao.setProcInValue(nProcIndex, "patName", 			vo.getStrPatientDtlHidVal().split("\\^")[7], 41);
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
                        

					}
				} 
				else 
				{
					//System.out.println("-getStrTotalBatch----" + i + "---->>" + vo.getStrTotalBatch()[i]);
					if (!vo.getStrTotalBatch()[i].equals("0")) 
					{
						if (vo.getStrCheckBatchExists()[i].equals("1")) 
						{
							System.out.println(" ########## AUTO With OUT BATCH SELECTION ->  C ##########");						

							System.out.println("----Pkg_Mms_Dml2.Dml_Patemp_Issue_Items_Dtls--[ Mod  - 3 ]----------");

							strProcName = "{call Pkg_Mms_Dml2.Dml_Patemp_Issue_Items_Dtls(?,?,?,?,?,?,?,?,?,?,    ?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?   ,?,?,?,?)}";// 44
							nProcIndex = dao.setProcedure(strProcName);

							String admissionDtl = vo.getStrAdmissionDtlHidVal().replaceAll("[!@$%^&]", "#");
							String patDtl = vo.getStrPatientDtlHidVal().replaceAll("[!@$%^&]", "#");

							//System.out.println("admissionDtl---------------" + admissionDtl);
							//System.out.println("patDtl----------------" + patDtl);
							
							System.out.println("Issue Qty - C. --"+i+"-->>"+vo.getStrIssueQtyArray()[i]);
							System.out.println("Catg_Code - C. --"+i+"-->>"+vo.getStrBrandIdArray()[i].substring(0, 2));							
							
							System.out.println("--------------------------------------------------------");
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
							System.out.println("--------------------------------------------------------");

							dao.setProcInValue(nProcIndex, "modeval", 				"3", 1);
							dao.setProcInValue(nProcIndex, "issueNo", 				vo.getStrIssueNumber(), 2);
							dao.setProcInValue(nProcIndex, "req_No", 				vo.getStrRequestNo(), 3);
							dao.setProcInValue(nProcIndex, "issuing_store_id", 		vo.getStrStoreId(), 4);
							dao.setProcInValue(nProcIndex, "reserved_qty_flag", 	"1", 5);
							dao.setProcInValue(nProcIndex, "category_No", 			vo.getStrBrandIdArray()[i].substring(0, 2), 6);
							dao.setProcInValue(nProcIndex, "reqType_id", 			vo.getStrReqTypeId(), 7);
							dao.setProcInValue(nProcIndex, "item_id", 				vo.getStrItemIdArray()[i], 8);
							dao.setProcInValue(nProcIndex, "item_brand_id", 		vo.getStrBrandIdArray()[i], 9);
							dao.setProcInValue(nProcIndex, "batchSl_no", 			"0", 10);
							dao.setProcInValue(nProcIndex, "hospital_code", 		vo.getStrHospitalCode(), 11);
							dao.setProcInValue(nProcIndex, "item_SlNo", "			0", 12);
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
							dao.setProcInValue(nProcIndex, "strEpiCode", 			strEpisodeCode, 29);
							dao.setProcInValue(nProcIndex, "strVisitNo", 			strVisitNo, 30);
							dao.setProcInValue(nProcIndex, "strAdmNo",
									vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[0], 31);
							dao.setProcInValue(nProcIndex, "strOrderBy", 			"0", 32);
							dao.setProcInValue(nProcIndex, "days", 					"0", 33);
							dao.setProcInValue(nProcIndex, "cost", 					"0", 34);
							dao.setProcInValue(nProcIndex, "remarks", 				vo.getStrRemarks(), 35);
							dao.setProcInValue(nProcIndex, "seatId",				vo.getStrSeatId(), 36);
							dao.setProcInValue(nProcIndex, "isUpdateOpdDrugReqDtl", "1", 37);
							dao.setProcInValue(nProcIndex, "dosage", 				admissionDtl, 38);
							dao.setProcInValue(nProcIndex, "frequency", 			patDtl, 39);
							dao.setProcInValue(nProcIndex, "presdays", 				"0", 40);
							dao.setProcInValue(nProcIndex, "patName", 				vo.getStrPatientDtlHidVal().split("\\^")[7], 41);
							dao.setProcInValue(nProcIndex, "issuedate", 			"", 42);
							dao.setProcOutValue(nProcIndex, "err", 					1, 43);
							dao.setProcOutValue(nProcIndex, "costOut", 				1, 44);
							dao.execute(nProcIndex, 1);
						} 
						else 
						{
							
							System.out.println(" ########## SINGLE BATCH SELECTION ->  D ##########");

							System.out.println("----Pkg_Mms_Dml2.Dml_Patemp_Issue_Items_Dtls--[ Mod  - 4 ]----------");
							
							String admissionDtl = vo.getStrAdmissionDtlHidVal().replaceAll("[!@$%^&]", "#");
							String patDtl = vo.getStrPatientDtlHidVal().replaceAll("[!@$%^&]", "#");

							//System.out.println("admissionDtl---------------" + admissionDtl);
							//System.out.println("patDtl----------------" + patDtl);
							
							System.out.println("Issue Qty - D. ---"+i+"->>"+vo.getStrIssueQtyArray()[i]);
							System.out.println("Catg_Code - D. ---"+i+"->>"+vo.getStrBrandIdArray()[i].substring(0, 2));
							System.out.println("Batch_NO  - D. ---"+i+"->>"+vo.getStrSingleBatch()[i]);

							System.out.println("--------------------------------------------------------");
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

							strProcName = "{call Pkg_Mms_Dml2.Dml_Patemp_Issue_Items_Dtls(?,?,?,?,?,?,?,?,?,?,    ?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?   ,?,?,?,?)}";// 44
							nProcIndex = dao.setProcedure(strProcName);

							dao.setProcInValue(nProcIndex, "modeval", 			"4", 1);
							dao.setProcInValue(nProcIndex, "issueNo", 			vo.getStrIssueNumber(), 2);
							dao.setProcInValue(nProcIndex, "req_No", 			vo.getStrRequestNo(), 3);
							dao.setProcInValue(nProcIndex, "issuing_store_id",	vo.getStrStoreId(), 4);
							dao.setProcInValue(nProcIndex, "reserved_qty_flag", "1", 5);
							dao.setProcInValue(nProcIndex, "category_No", 		vo.getStrBrandIdArray()[i].substring(0, 2), 6);
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
							dao.setProcInValue(nProcIndex, "strEpiCode", 		strEpisodeCode, 29);
							dao.setProcInValue(nProcIndex, "strVisitNo", 		strVisitNo, 30);
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
							dao.setProcInValue(nProcIndex, "dosage", 			admissionDtl, 38);
							dao.setProcInValue(nProcIndex, "frequency", 		patDtl, 39);
							dao.setProcInValue(nProcIndex, "presdays", 			"0", 40);
							dao.setProcInValue(nProcIndex, "patName", 			vo.getStrPatientDtlHidVal().split("\\^")[7], 41);
							dao.setProcInValue(nProcIndex, "issuedate", 		"", 42);
							dao.setProcOutValue(nProcIndex, "err", 				1, 43);
							dao.setProcOutValue(nProcIndex, "costOut", 			1, 44);
							dao.execute(nProcIndex, 1);
                            
						}

					} // End Loop If Total Batch is Greater Than > 0

				}
			}

			dao.fire();

			debugPoint = 21;

			System.out.println(" *********** IssueTransDAO .NEW_IPD_ISSUE  ---- END --  *********** ");

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgType("1");
			vo.setStrMsgString("IssueTransDAO.insert() --> " + e.getMessage() + " DAO_DEBUG_POINT :: " + debugPoint
					+ " DAO_VALUE :: " + itemValue);
		} 
		finally 
		{

			if (dao != null) 
			{
				dao.free();
				dao = null;
			}

		}
	}

	/*
	 * public static synchronized void insertipd(IssueTransVO vo) { HisDAO dao =
	 * null; String strFuncName = ""; int nFuncIndex = 0; int length = 0; String
	 * paramVal[] = null; String userValue[] = null; String strIssueNo = ""; String
	 * strVisitDtl = ""; Double netCost = 0.00; DmlHsttPatEmpIssueItemDtlDAO
	 * dmlhsttpatempissueitemdtl = null; DmlHsttPatEmpIssueDtlDAO
	 * dmlhsttpatempissuedtl = null;
	 * 
	 * int debugPoint = 0; String itemValue = "";
	 * 
	 * String strIssueUnitId = "0"; String strBillTariff = ""; String strBillBatch =
	 * ""; String strBillRate = ""; String strBillQty = "";
	 * 
	 * MmsConfigUtil mcu;
	 * 
	 * try {
	 * 
	 * System.out.
	 * println(" ------- IssueTransDAO .insertipd  ---- START --[ OLD ITEM FINDER ISSUE ]-- "
	 * ); System.out.
	 * println(" ------- bill_interface.dml_online_billreq_drugs  --[ Mode- 1 ]------ "
	 * );
	 * 
	 * debugPoint = 1; mcu =new MmsConfigUtil(vo.getStrHospitalCode()); dao = new
	 * HisDAO("MMS Transactions","IssueTransDAO"); dmlhsttpatempissueitemdtl = new
	 * DmlHsttPatEmpIssueItemDtlDAO(); dmlhsttpatempissuedtl = new
	 * DmlHsttPatEmpIssueDtlDAO(); strFuncName =
	 * "{? = call MMS_MST.generate_issueNo(?::numeric,?::numeric,?::numeric,?::numeric)}"
	 * ; nFuncIndex = dao.setFunction(strFuncName);
	 * 
	 * dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
	 * dao.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId());
	 * dao.setFuncInValue(nFuncIndex, 4, "35"); // Issue To Patient [IPD]
	 * dao.setFuncInValue(nFuncIndex, 5, vo.getStrItemCat());
	 * dao.setFuncOutValue(nFuncIndex, 1); dao.executeFunction(nFuncIndex);
	 * strIssueNo = dao.getFuncString(nFuncIndex);
	 * vo.setStrIssueNumber(strIssueNo.split("\\^")[0]);
	 * 
	 * debugPoint = 2;
	 * 
	 * 
	 * 
	 * strVisitDtl = "0" ; String strEpisodeCode = "0"; String strVisitNo = "0" ;
	 * 
	 * dao = new HisDAO("MMS Transactions","IssueTransDAO"); length =
	 * vo.getItemParamValue().length;
	 * 
	 * debugPoint = 12;
	 * 
	 * dmlhsttpatempissuedtl.setStrStoreId(vo.getStrStoreId());
	 * dmlhsttpatempissuedtl.setStrIssueNo(vo.getStrIssueNumber());
	 * dmlhsttpatempissuedtl.setStrHospitalCode(vo.getStrHospitalCode());
	 * dmlhsttpatempissuedtl.setStrRequestNo(vo.getStrRequestNo());
	 * dmlhsttpatempissuedtl.setStrOrderBy(vo.getStrReqPrescribedBy());
	 * 
	 * debugPoint = 13;
	 * 
	 * dmlhsttpatempissuedtl.setStrOrderDate(vo.getStrReqPrescriptionDate());
	 * dmlhsttpatempissuedtl.setStrDays(vo.getStrPrescriptionFor());
	 * dmlhsttpatempissuedtl.setStrCrNo(vo.getStrPuk());
	 * dmlhsttpatempissuedtl.setStrReqTypeId("35"); // Issue To Patient [IPD]
	 * dmlhsttpatempissuedtl.setStrAdmNo(vo.getStrAdmissionDtlHidVal().replace("^",
	 * "#").split("#")[0]);
	 * 
	 * debugPoint = 14;
	 * 
	 * dmlhsttpatempissuedtl.setStrEmpNo(vo.getStrReqEmpNo());
	 * dmlhsttpatempissuedtl.setStrItemCatNo(vo.getStrItemCat());
	 * dmlhsttpatempissuedtl.setStrFinalCost(DmlHsttPatEmpIssueItemDtlDAO.getIntCost
	 * ()+""); dmlhsttpatempissuedtl.setStrFinStartDate(vo.getStrFinStartDate());
	 * dmlhsttpatempissuedtl.setStrFinEndDate(vo.getStrFinEndDate());
	 * 
	 * debugPoint = 15;
	 * 
	 * dmlhsttpatempissuedtl.setStrSeatId(vo.getStrSeatId());
	 * dmlhsttpatempissuedtl.setStrDeptUnitCode(vo.getStrUnitCode());
	 * dmlhsttpatempissuedtl.setStrVisitType("2");//hardcoded in case of ipd patient
	 * dmlhsttpatempissuedtl.setStrDeptCode(vo.getStrDeptCode());
	 * 
	 * dmlhsttpatempissuedtl.setStrWardCode(vo.getStrReqWardCode());
	 * 
	 * debugPoint = 16;
	 * 
	 * dmlhsttpatempissuedtl.setStrReceiveBy(vo.getStrReceiveBy());
	 * dmlhsttpatempissuedtl.setStrRemarks(vo.getStrRemarks());
	 * dmlhsttpatempissuedtl.setStrReqDate("");
	 * dmlhsttpatempissuedtl.setStrVisitNo(strVisitNo);
	 * dmlhsttpatempissuedtl.setStrEpisoCode(strEpisodeCode);
	 * 
	 * debugPoint = 17;
	 * 
	 * // By Vivek // vo.getStrPatientHiddenValue1 Patient Name ^Father
	 * Name^Category Code^Address^Mlc No vo.getStrPatientDtlHidVal() HRGDT_DOB ||
	 * ''^'' ||GNUM_GENDER_CODE ||''^''||HGNUM_PAT_STATUS_CODE || ''^''||
	 * HGNUM_PATIENT_CAT_CODE || ''^'' ||HRGNUM_IS_MLC ||''^''||HRGNUM_ISNEWBORN ||
	 * ''^''|| HRGNUM_ID_NO
	 * 
	 * // By Vivek
	 * 
	 * itemValue += " PatientHiddenValue1 :: " + vo.getStrPatientHiddenValue1() +
	 * " StrPatientDtlHidVal :: " + vo.getStrPatientDtlHidVal();
	 * 
	 * dmlhsttpatempissuedtl.setStrFirstName(vo.getStrPatientDtlHidVal().split("\\^"
	 * )[7]); dmlhsttpatempissuedtl.setStrMiddelName("");
	 * dmlhsttpatempissuedtl.setStrLastName("");
	 * dmlhsttpatempissuedtl.setStrPatientId(vo.getStrPatientId());
	 * dmlhsttpatempissuedtl.setStrPatientType("18");
	 * 
	 * debugPoint = 18;
	 * 
	 * dmlhsttpatempissuedtl.setStrPatientAge(vo.getStrPatientDtlHidVal().split(
	 * "\\^")[0]); dmlhsttpatempissuedtl.setStrPatientAgeUnit("0");
	 * dmlhsttpatempissuedtl.setStrPatientFatherName(vo.getStrPatientDtlHidVal().
	 * split("\\^")[8]);
	 * dmlhsttpatempissuedtl.setStrPatientGenderCode(vo.getStrPatientDtlHidVal().
	 * split("\\^")[1]);
	 * 
	 * debugPoint = 19;
	 * 
	 * dmlhsttpatempissuedtl.setStrPatientAddress(vo.getStrPatientHiddenValue1().
	 * split("\\^")[3]); dmlhsttpatempissuedtl.setStrTransType("1"); // With CR No
	 * dmlhsttpatempissuedtl.setStrDrugIssueDate(vo.getStrDrugIssueDate());
	 * dmlhsttpatempissuedtl.setStrOutOfStockFlag(vo.getStrOutOfStockFlag());
	 * 
	 * debugPoint = 20;
	 * 
	 * 
	 * dmlhsttpatempissuedtl.insert(dao);
	 * 
	 * 
	 * for(int k=0;k<length;k++) {
	 *//**
		 * Hidden Values corresponding to particular ITEM DETAILS
		 *//*
			 * debugPoint = 3; if(vo.getStrQtyText()[k] != null &&
			 * vo.getStrQtyText()[k].length() > 0 && !vo.getStrQtyText()[k].equals("0")) {
			 * itemValue = vo.getItemParamValue()[k];
			 * 
			 * paramVal = vo.getItemParamValue()[k].split("#"); userValue =
			 * paramVal[2].replace('^', '#').split("#");
			 * 
			 * debugPoint = 4;
			 * 
			 * if(strBillTariff != null && strBillTariff != "") strBillTariff=strBillTariff
			 * + "^"+userValue[1]; else strBillTariff = userValue[1]; if(strBillRate != null
			 * && strBillRate != "") strBillRate=strBillRate + "^"+userValue[9]; else
			 * strBillRate = userValue[9]; if(strBillQty != null && strBillQty != "")
			 * strBillQty=strBillQty + "^"+vo.getStrQtyText()[k]; else strBillQty =
			 * vo.getStrQtyText()[k]; if(strBillBatch != null && strBillBatch != "")
			 * strBillBatch=strBillBatch + "^"+userValue[15]; else strBillBatch =
			 * userValue[15];
			 * 
			 * 
			 * System.out.println("---------------------------");
			 * System.out.println("strBillTariff-----"+strBillTariff);
			 * System.out.println("strBillRate-------"+strBillRate);
			 * System.out.println("strBillQty--------"+strBillQty);
			 * System.out.println("strBillBatch------"+strBillBatch);
			 * System.out.println("---------------------------");
			 * 
			 * String strInventoryUnitId = userValue[11];
			 * 
			 * dmlhsttpatempissueitemdtl.setStrStoreId(vo.getStrStoreId());
			 * dmlhsttpatempissueitemdtl.setStrIssueNo(vo.getStrIssueNumber());
			 * dmlhsttpatempissueitemdtl.setStrItemId(userValue[0]);
			 * dmlhsttpatempissueitemdtl.setStrItemBrandId(userValue[1]);
			 * dmlhsttpatempissueitemdtl.setStrBatchSlNo(userValue[15]);
			 * dmlhsttpatempissueitemdtl.setStrHospitalCode(vo.getStrHospitalCode());
			 * 
			 * debugPoint = 5;
			 * 
			 * dmlhsttpatempissueitemdtl.setStrItemSlNo(userValue[18]);
			 * dmlhsttpatempissueitemdtl.setStrStockStatusCode(userValue[32]);
			 * dmlhsttpatempissueitemdtl.setStrGroupId(userValue[2]);
			 * dmlhsttpatempissueitemdtl.setStrSubGroupId(userValue[3]);
			 * dmlhsttpatempissueitemdtl.setStrRate(userValue[9]);
			 * dmlhsttpatempissueitemdtl.setStrRateUnitId(userValue[10]);
			 * 
			 * debugPoint = 6;
			 * 
			 * dmlhsttpatempissueitemdtl.setStrBalQty("0");
			 * dmlhsttpatempissueitemdtl.setStrBalQtyUnitId("");
			 * dmlhsttpatempissueitemdtl.setStrIssueQty(vo.getStrQtyText()[k]);
			 * dmlhsttpatempissueitemdtl.setStrIssueQtyUnitId(strInventoryUnitId);
			 * //Aritra,22nd June dmlhsttpatempissueitemdtl.setStrExpiryDate(userValue[16]);
			 * dmlhsttpatempissueitemdtl.setStrRemarks(vo.getStrRemarks());
			 * 
			 * debugPoint = 7;
			 * 
			 * dmlhsttpatempissueitemdtl.setStrCost("0");
			 * dmlhsttpatempissueitemdtl.setStrInHandQty(userValue[7]);
			 * dmlhsttpatempissueitemdtl.setStrInHandQtyUnitId(userValue[8]);
			 * dmlhsttpatempissueitemdtl.setStrManufDate(userValue[17]);
			 * dmlhsttpatempissueitemdtl.setStrReqNo(vo.getStrRequestNo());
			 * dmlhsttpatempissueitemdtl.setStrCrNo(vo.getStrPuk());
			 * 
			 * debugPoint = 8;
			 * 
			 * dmlhsttpatempissueitemdtl.setStrEmpNo(vo.getStrReqEmpNo());
			 * dmlhsttpatempissueitemdtl.setStrVisitNo(strVisitNo);
			 * dmlhsttpatempissueitemdtl.setStrEpisodeCode(strEpisodeCode);
			 * dmlhsttpatempissueitemdtl.setStrAdmNo(vo.getStrReqAdmNo());
			 * dmlhsttpatempissueitemdtl.setStrOrderBy(vo.getStrReqPrescribedBy());//Id od
			 * the consultant
			 * 
			 * debugPoint = 9;
			 * 
			 * dmlhsttpatempissueitemdtl.setStrDays(vo.getStrReqPrescribedFor());
			 * dmlhsttpatempissueitemdtl.setStrReqTypeId("32"); // Issue To Patient - Direct
			 * dmlhsttpatempissueitemdtl.setStrItemCatNo(vo.getStrItemCat());
			 * 
			 * debugPoint = 10;
			 * 
			 * dmlhsttpatempissueitemdtl.setStrDosage("0");
			 * dmlhsttpatempissueitemdtl.setStrFrequency("0");
			 * dmlhsttpatempissueitemdtl.setStrPresDays("0");
			 * 
			 * dmlhsttpatempissueitemdtl.setStrPatientName(vo.getStrPatientDtlHidVal().split
			 * ("\\^")[7]);// dmlhsttpatempissueitemdtl.setStrSeatId(vo.getStrSeatId());
			 * dmlhsttpatempissueitemdtl.setStrDrugIssueDate(vo.getStrDrugIssueDate());
			 * 
			 * debugPoint = 11;
			 * 
			 * 
			 * dmlhsttpatempissueitemdtl.insert2(dao);
			 * 
			 * 
			 * 
			 * int procIndex2; String proc_name2 =
			 * "{call bill_interface.dml_online_billreq_drugs(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}"
			 * ; procIndex2 = dao.setProcedure(proc_name2); dao.setProcInValue(procIndex2,
			 * "modval", "1", 1); // 1 dao.setProcInValue(procIndex2, "gnum_dept_code",
			 * vo.getStrDeptCode(), 2); dao.setProcInValue(procIndex2,
			 * "sblnum_chargetype_id", "2", 3); dao.setProcInValue(procIndex2,
			 * "sblnum_service_id", "5", 4); dao.setProcInValue(procIndex2, "gstr_req_no",
			 * vo.getStrIssueNumber(), 5); dao.setProcInValue(procIndex2,
			 * "gnum_treatment_cat",
			 * vo.getStrPatientDtlHidVal().replace("^","#").split("#")[3],6);
			 * dao.setProcInValue(procIndex2, "hrgnum_episode_code",
			 * vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[1], 7);
			 * dao.setProcInValue(procIndex2, "hrgnum_puk", vo.getStrPatientId(), 8);
			 * dao.setProcInValue(procIndex2, "hblnum_pat_lfaccount_no", "0", 9);
			 * dao.setProcInValue(procIndex2, "gstr_tariff", userValue[1], 10);
			 * dao.setProcInValue(procIndex2, "gstr_tariff_batch", userValue[15], 11);
			 * dao.setProcInValue(procIndex2, "gstr_tariff_rates", userValue[9], 12);
			 * dao.setProcInValue(procIndex2, "gstr_reqqty", vo.getStrQtyText()[k], 13);
			 * dao.setProcInValue(procIndex2, "hblstr_patient_name", "", 14);
			 * dao.setProcInValue(procIndex2, "hblstr_pat_address", "", 15);
			 * dao.setProcInValue(procIndex2, "hblstr_contact_no", "", 16);
			 * dao.setProcInValue(procIndex2, "age",
			 * vo.getStrPatientDtlHidVal().replace("^","#").split("#")[10].split(" ")[0],
			 * 17); dao.setProcInValue(procIndex2, "ageunit",
			 * vo.getStrPatientDtlHidVal().replace("^","#").split("#")[10].split(" ")[1].
			 * split("/")[0], 18); dao.setProcInValue(procIndex2, "gender",
			 * vo.getStrPatientDtlHidVal().replace("^","#").split("#")[1], 19);
			 * dao.setProcInValue(procIndex2, "refdoctor", "N/A", 20);
			 * dao.setProcInValue(procIndex2, "refdoccontactno", "0000000000", 21);
			 * dao.setProcInValue(procIndex2, "gnum_seatid", vo.getStrSeatId(), 22);
			 * dao.setProcInValue(procIndex2, "hosp_code", vo.getStrHospitalCode(), 23);
			 * dao.setProcInValue(procIndex2, "ward_code",
			 * vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[6], 24);
			 * dao.setProcInValue(procIndex2, "admno",
			 * vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[0], 25);
			 * dao.setProcInValue(procIndex2, "visitno", vo.getStrVisitNo(), 26);
			 * dao.setProcOutValue(procIndex2, "err", 1,27); dao.execute(procIndex2, 1);
			 * 
			 * }
			 * 
			 * }
			 * 
			 * 
			 * 
			 * // DAO Fire synchronized (dao) { dao.fire(); }
			 * 
			 * 
			 * debugPoint = 21;
			 * 
			 * 
			 * System.out.println(" ------- IssueTransDAO .insertipd  ---- END ---- ");
			 * 
			 * 
			 * } catch (Exception e) { e.printStackTrace(); vo.setStrMsgType("1");
			 * vo.setStrMsgString("IssueTransDAO.insert() --> " + e.getMessage() +
			 * " DAO_DEBUG_POINT :: " + debugPoint + " DAO_VALUE :: " + itemValue); }
			 * finally {
			 * 
			 * if (dao != null) { dao.free(); dao = null; }
			 * 
			 * } }
			 */

	public static synchronized void insertipd(IssueTransVO vo) {
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
		String strBillBatch = "";
		String strBillRate = "";
		String strBillQty = "";

		try 
		{

			System.out.println(" ------- IssueTransDAO .insertipd  ---- START --[ OLD ITEM FINDER ISSUE ]-- ");
			System.out.println(" ------- bill_interface.dml_online_billreq_drugs  --[ Mode- 1 ]------ ");

			debugPoint = 1;
			
			dao = new HisDAO("MMS Transactions", "IssueTransDAO");
			dmlhsttpatempissueitemdtl = new DmlHsttPatEmpIssueItemDtlDAO();
			dmlhsttpatempissuedtl = new DmlHsttPatEmpIssueDtlDAO();
			strFuncName = "{? = call MMS_MST.generate_issueNo(?::numeric,?::numeric,?::numeric,?::numeric)}";
			nFuncIndex = dao.setFunction(strFuncName);
			
			System.out.println(" ---- MMS_MST.generate_issueNo [ Req Type 35  Issue To Patient [IPD]] --- ");   
			
			System.out.println(" ---- HOSP_CODE --- "+vo.getStrHospitalCode());  
			System.out.println(" ---- STORE_CODE --- "+vo.getStrStoreId());
			System.out.println(" ---- CATG_CODE --- "+vo.getStrItemCat());
			System.out.println(" ------------------------------------- ");

			dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId());
			dao.setFuncInValue(nFuncIndex, 4, "35"); // Issue To Patient [IPD]
			dao.setFuncInValue(nFuncIndex, 5, vo.getStrItemCat());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strIssueNo = dao.getFuncString(nFuncIndex);
			vo.setStrIssueNumber(strIssueNo.split("\\^")[0]);
			System.out.println(" ---- Issue_NO --- "+vo.getStrIssueNumber());
			System.out.println(" ------------------------------------- ");

			debugPoint = 2;

			strVisitDtl = "0";
			String strEpisodeCode = "0";
			String strVisitNo = "0";

			dao = new HisDAO("MMS Transactions", "IssueTransDAO");
			length = vo.getItemParamValue().length;

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
			dmlhsttpatempissuedtl.setStrReqTypeId("35"); // Issue To Patient [IPD]
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
					
					/*
					if (strBillRate != null && strBillRate != "")
						
						strBillRate = strBillRate + "^" + userValue[9];
					else
						strBillRate = userValue[9];
					*/
					if (strBillRate != null && strBillRate != "")
					{
						if(vo.getStrHospitalCode().equals("98926"))
						{
							strBillRate = strBillRate + "^0";
						}
						else
						{	
						
						   strBillRate = strBillRate + "^" + userValue[9];
						}
					}
					else
					{	
						if(vo.getStrHospitalCode().equals("98926"))
						{
							strBillRate = "0";
						}
						else
						{	
						
							strBillRate = userValue[9];
						}
						
						
					}
					
					if (strBillQty != null && strBillQty != "")
						strBillQty = strBillQty + "^" + vo.getStrQtyText()[k];
					else
						strBillQty = vo.getStrQtyText()[k];
					if (strBillBatch != null && strBillBatch != "")
						strBillBatch = strBillBatch + "^" + userValue[15];
					else
						strBillBatch = userValue[15];

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
					dmlhsttpatempissueitemdtl.setStrReqTypeId("32"); // Issue To Patient - Direct
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

					int procIndex2;
					String proc_name2 = "{call bill_interface.dml_online_billreq_drugs(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}";
					procIndex2 = dao.setProcedure(proc_name2);
					dao.setProcInValue(procIndex2, "modval", "1", 1); // 1
					dao.setProcInValue(procIndex2, "gnum_dept_code", vo.getStrDeptCode(), 2);
					dao.setProcInValue(procIndex2, "sblnum_chargetype_id", "2", 3);
					dao.setProcInValue(procIndex2, "sblnum_service_id", "5", 4);
					dao.setProcInValue(procIndex2, "gstr_req_no", vo.getStrIssueNumber(), 5);
					dao.setProcInValue(procIndex2, "gnum_treatment_cat",
							vo.getStrPatientDtlHidVal().replace("^", "#").split("#")[3], 6);
					dao.setProcInValue(procIndex2, "hrgnum_episode_code",vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[1], 7);
					dao.setProcInValue(procIndex2, "hrgnum_puk", vo.getStrPatientId(), 8);
					dao.setProcInValue(procIndex2, "hblnum_pat_lfaccount_no", "0", 9);
					dao.setProcInValue(procIndex2, "gstr_tariff", userValue[1], 10);
					dao.setProcInValue(procIndex2, "gstr_tariff_batch", userValue[15], 11);
					if(vo.getStrHospitalCode().equals("98926"))
					{	/*
						 * Not Applicable For JodhPur AIIMS
						 * 
						 * */
						dao.setProcInValue(procIndex2, "gstr_tariff_rates", 		"0", 12);
					}
					else
					{
						dao.setProcInValue(procIndex2, "gstr_tariff_rates", 		userValue[9], 12);
					}
					//dao.setProcInValue(procIndex2, "gstr_tariff_rates", userValue[9], 12);
					dao.setProcInValue(procIndex2, "gstr_reqqty", vo.getStrQtyText()[k], 13);
					dao.setProcInValue(procIndex2, "hblstr_patient_name", "", 14);
					dao.setProcInValue(procIndex2, "hblstr_pat_address", "", 15);
					dao.setProcInValue(procIndex2, "hblstr_contact_no", "", 16);
					dao.setProcInValue(procIndex2, "age",vo.getStrPatientDtlHidVal().replace("^", "#").split("#")[10].split(" ")[0], 17);
					dao.setProcInValue(procIndex2, "ageunit",vo.getStrPatientDtlHidVal().replace("^", "#").split("#")[10].split(" ")[1].split("/")[0],
							18);
					dao.setProcInValue(procIndex2, "gender",
							vo.getStrPatientDtlHidVal().replace("^", "#").split("#")[1], 19);
					dao.setProcInValue(procIndex2, "refdoctor", "N/A", 20);
					dao.setProcInValue(procIndex2, "refdoccontactno", "0000000000", 21);
					dao.setProcInValue(procIndex2, "gnum_seatid", vo.getStrSeatId(), 22);
					dao.setProcInValue(procIndex2, "hosp_code", vo.getStrHospitalCode(), 23);
					dao.setProcInValue(procIndex2, "ward_code",
							vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[6], 24);
					dao.setProcInValue(procIndex2, "admno",
							vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[0], 25);
					dao.setProcInValue(procIndex2, "visitno", vo.getStrVisitNo(), 26);
					dao.setProcOutValue(procIndex2, "err", 1, 27);
					dao.execute(procIndex2, 1);

				}

			}

			// DAO Fire
			synchronized (dao) {
				dao.fire();
			}

			debugPoint = 21;

			System.out.println(" ------- IssueTransDAO .insertipd  ---- END ---- ");

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgType("1");
			vo.setStrMsgString("IssueTransDAO.insert() --> " + e.getMessage() + " DAO_DEBUG_POINT :: " + debugPoint
					+ " DAO_VALUE :: " + itemValue);
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}

		

	public static void getGenderCombo(IssueTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_get_Gender_Combo(?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");

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
			voObj.setStrMsgString("IssueTransDAO.getGenderCombo() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getLFAccountDetails(IssueTransVO voObj) {
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_HBLT_PAT_LF_ACCOUNT_DTL(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		// String strDeptCode = voObj.getStrOffLineRaisingDepartment();//Last Visited
		// Department
		String strCrNo = voObj.getStrPuk();

		String strErr = "";

		try {
			System.out.println(" ------- IssueTransDAO .getLFAccountDetails  -------- ");
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

	public static void getLFAccountSummary(IssueTransVO voObj) {
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_lf_account_summary(?,?,?,?,?)}";
		int nProcIndex = 0;

		// String strDeptCode = voObj.getStrOffLineRaisingDepartment();//Last Visited
		// Department
		String strCrNo = voObj.getStrPuk();

		String strErr = "";

		try {
			System.out.println("------------- IssueTransDAO.getLFAccountSummary -------------");
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
	 * @param IssueTransVO the IssueTransVO
	 */
	public static void getPatientDiagDetails(IssueTransVO vo) {

		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";

		try {
			System.out.println("------------- IssueTransDAO.getPatientDiagDetails -------------");
			System.out.println("------------- PKG_MMS_VIEW.proc_diag_emp_view [ Mode - 1 ] -------------");

			String strProcName = "{call PKG_MMS_VIEW.proc_diag_emp_view(?,?::varchar,?::varchar,?,?)}";

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");

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
			vo.setStrMsgString("--> IssueTransDAO.getPatientDiagDetails()-->" + e.getMessage());
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
	 * @param IssueTransVO the IssueTransVO
	 */
	public static void getIcdList(IssueTransVO vo) {

		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";

		try {

			System.out.println("------------- IssueTransDAO.getIcdList -------------");
			System.out.println("------------- PKG_MMS_VIEW.proc_diag_mst [ Mode - 1 ] -------------");

			String strProcName = "{call PKG_MMS_VIEW.proc_diag_mst(?,?,?)}";

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");

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
			vo.setStrMsgString("--> IssueTransDAO.getPatientDiagDetails()-->" + e.getMessage());
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
	 * @param IssueTransVO the IssueTransVO
	 */
	public static void getEmpList(IssueTransVO vo) {

		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";

		try {

			System.out.println("------------- IssueTransDAO.getEmpList -------------");
			System.out.println("------------- PKG_MMS_VIEW.proc_unit_consulatant_view [ Mode - 2 ] -------------");

			String strProcName = "{call PKG_IPD_VIEW.proc_unit_consulatant_view(?,?,?,?,?,?)}";

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");

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
			vo.setStrMsgString("--> IssueTransDAO.getPatientDiagDetails()-->" + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null)
				daoObj.free();
			daoObj = null;
		}

	}

	public static void getBilledItemDtls(IssueTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String proc_name1 = "{call Pkg_Mms_View.proc_patient_issue_drug_dtl(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			System.out.println("------------- IssueTransDAO.getBilledItemDtls -------------");
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
			vo.setStrMsgString("IssueTransDAO.getIssueDetailTwo() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	

	public static void deleteIssueDtls(IssueTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String proc_name1 = "{call Pkg_Mms_dml.proc_patient_issue_delete(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println("------------- IssueTransDAO.deleteIssueDtls -------------");
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
			vo.setStrMsgString("IssueTransDAO.getIssueDetailTwo() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getTariffDtls(IssueTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String proc_name1 = "{call Pkg_Mms_View.proc_tariff_list(?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			System.out.println("------------- IssueTransDAO.getTariffDtls -------------");
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
			vo.setStrMsgString("IssueTransDAO.getTariffDtls() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getStoreListBS(IssueTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		try {

			System.out.println("------------- IssueTransDAO.getStoreListBS -------------");
			System.out.println("------------- Pkg_Mms_dml.proc_hstt_store_mst [ Mode - 12 ] -------------");

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");
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
			voObj.setStrMsgString("IssueTransDAO.getStoreList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getPaymentMode(IssueTransVO vo) {
		// TODO Auto-generated method stub

		String strProcName = "{call pkg_bill_view.sblt_payment_category_mapping_mst(?,?,?,?,?,?,?,?)}";

		int nProcIndex = 0;
		String val = "0";
		String strErr = "";
		WebRowSet ws = null;

		HisDAO daoObj = null;
		try {
			System.out.println(" ------- IssueTransDAO .getPaymentMode  -------- ");
			System.out.println(" ------- pkg_bill_view.sblt_payment_category_mapping_mst  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");
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
			vo.setStrMsgString("IssueTransDAO.getPaymentMode() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void getReqType(IssueTransVO vo) {
		// TODO Auto-generated method stub

		String strProcName = "{call Pkg_Mms_View.proc_sstt_indenttype_dtl(?,?,?,?,?,?,?)}";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;

		HisDAO daoObj = null;
		try {
			System.out.println("------------- IssueTransDAO.getReqType -------------");
			System.out.println("------------- Pkg_Mms_dml.proc_sstt_indenttype_dtl [ Mode - 3 ] -------------");

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");
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
			vo.setStrMsgString("IssueTransDAO.getReqType() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void getEpisodeDtl(IssueTransVO voObj) {
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

			System.out.println("------------- IssueTransDAO.getEpisodeDtl -------------");

			System.out.println(
					"------------- pkg_simple_view.proc_hrgt_episode_unit_based_dtl --[ Mode - 1 ]-----------");

			daoObj = new HisDAO("mms", "IssueTransDAO.getEpisodeDtl");
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
			voObj.setStrMsgString("IssueTransDAO.getEpisodeDtl() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void getPresFormDtl(IssueTransVO voObj) {
		// TODO Auto-generated method stub

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_simple_view.proc_hrgt_visittype_episode_based_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strEpisodeCode = voObj.getStrEpisodeCode();
		String strCrNo = voObj.getStrCrNo();

		String strErr = "";

		try {
			System.out.println("------------- IssueTransDAO.getPresFormDtl -------------");

			System.out.println(
					"------------- pkg_simple_view.proc_hrgt_visittype_episode_based_dtl --[ Mode - 1 ]-----------");

			daoObj = new HisDAO("mms", "IssueTransDAO.getEpisodeDtl");
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
			voObj.setStrMsgString("IssueTransDAO.getEpisodeDtl() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void getAccountDtl(IssueTransVO VO) {
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.PROC_HBLT_PATACCOUNT_DTL(?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		int procIndex1 = 0;
		String strerr = "";
		WebRowSet ws = null;
		try {
			System.out.println("------------- IssueTransDAO.getAccountDtl -------------");

			System.out.println("------------- PKG_BILL_VIEW.PROC_HBLT_PATACCOUNT_DTL --[ Mode - 12 ]-----------");

			dao = new HisDAO("mms", "IssueTransDAO.getAccountDtlWithAcctNo()");
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
			VO.setStrMsgString("IssueTransDAO.getAccountDtl() --> " + e.getMessage());
			VO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getdeptname(IssueTransVO vo) {
		int nFuncIndex;
		String strFuncName2 = "";
		String deptname = "";
		HisDAO dao = null;
		try {
			System.out.println("------------- IssueTransDAO.getdeptname -------------");

			System.out.println("------------- ipd_MST.getdeptname --[ Mode - 12 ]-----------");

			dao = new HisDAO("mms", "IssueTransDAO.getdeptname()");
			strFuncName2 = "{? = call ipd_MST.getdeptname(?,?)}";
			nFuncIndex = dao.setFunction(strFuncName2);
			dao.setFuncInValue(nFuncIndex, 2, vo.getStrDeptCode());
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			deptname = dao.getFuncString(nFuncIndex);
			vo.setStrDeptName(deptname);
		} catch (Exception e) {
			vo.setStrMsgString("IssueTransDAO.getdeptname() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/**
	 * This function is used to GET THE BATCH WISE ITEM DETAILS FOR POPUP.
	 * 
	 * @param vo the vo
	 * @return the single batch item dtl
	 */
	public static void getSingleBatchItemDtl(IssueTransVO vo) {

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
			
			String catgCode = vo.getStrSingleItemDtl().split("\\^")[1].substring(0, 2);

			dao.setProcInValue(nProcIndex, "modeval", 		"7");
			dao.setProcInValue(nProcIndex, "hosp_code", 	vo.getStrHospitalCode());
			dao.setProcInValue(nProcIndex, "item_id", 		vo.getStrSingleItemDtl().split("\\^")[0]);
			dao.setProcInValue(nProcIndex, "itembrand_id", 	vo.getStrSingleItemDtl().split("\\^")[1]);
			dao.setProcInValue(nProcIndex, "store_id", 		vo.getStrSingleItemDtl().split("\\^")[3]);
			dao.setProcInValue(nProcIndex, "batch_no", 		vo.getStrSingleItemDtl().split("\\^")[2]);
			dao.setProcInValue(nProcIndex, "item_sl_no", 	"0");
			dao.setProcInValue(nProcIndex, "sl_no", 		catgCode); // Passing As a ItemCat
																								
			dao.setProcInValue(nProcIndex, "reserved_flag", "0");
			dao.setProcOutValue(nProcIndex, "err", 			1);
			dao.setProcOutValue(nProcIndex, "resultset", 	2);
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

	/**
	 * Gets the item dtls.
	 * 
	 * @param voObj the vo obj
	 * 
	 * @return the item dtls
	 */
	public static void getItemDtls(IssueTransVO voObj) {

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
	public static void getStockItemDtlsList(IssueTransVO vo) {
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

	/**
	 * Gets the stock item dtls list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the stock item dtls list
	 */

	public static void getNALIst(IssueTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call PKG_MMS_VIEW2.PROC_HRGT_PATIENT_TREATMENT_DTL(?,?,?,?,? ,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO.getNALIst");

			nProcIndex = daoObj.setProcedure(strProcName);

			if (voObj.getStrCrNo() != null && !voObj.getStrCrNo().equals("")) {

				daoObj.setProcInValue(nProcIndex, "modeVal", "5", 1);
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
	
	
	 public static void GetData(IssueTransVO vo) 
		{
			/* Declaring Variable */
			HisDAO dao = null;
			WebRowSet wb = null;
			String str1 = null;
			HisUtil hisutil = null;
	    	try 
			{
				
	    		hisutil = new HisUtil("MMS", "OfflineIssueIndentDAO");
				wb      = STORENAMECOMBO(vo);
				if(wb.next())
				{
					vo.setStrStoreId(wb.getString(1));
				}
				wb.beforeFirst();
				if(wb!= null)
				{	
				   str1 = hisutil.getOptionValue(wb, vo.getStrStoreId(),"0^Select Value", true);
				   vo.setStrStoreName(str1);
				  
				}
				 else
	            {
	               str1 = "<option value='0'>DATA N/A</option>";   
	               vo.setStrStoreName(str1);
	            }
				
			
			} 
	    	catch (Exception e) 
	    	{
				
	    		vo.setStrMsgString("--> OfflineIssueIndentDAO.GetData()-->"
						+ e.getMessage());
				vo.setStrMsgType("1");
			} finally {
				if (dao != null)
					dao.free();
				dao = null;
			}

		}
	 
	 
	 public static WebRowSet STORENAMECOMBO(IssueTransVO vo)
		{
			String proc_name = "";

			proc_name = "{call PKG_MMS_VIEW.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
			
			HisDAO dao = null;
				
			int nprocIndex = 0;

			String strerr = "";

			WebRowSet ws = null;

			try {

				dao = new HisDAO("MMS",
						"transactions.IssueTransDAO.STORENAMECOMBO(VO)");

				nprocIndex = dao.setProcedure(proc_name);

				// set value

				dao.setProcInValue(nprocIndex, "modeval", "12",1);
				dao.setProcInValue(nprocIndex, "seatid", vo.getStrSeatId(),2);
				dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),3);
				dao.setProcInValue(nprocIndex, "storeid", "0",4);
				dao.setProcInValue(nprocIndex, "storetype_id", "0",5);
				dao.setProcOutValue(nprocIndex,"err", 1,6); // 1 for string return
				dao.setProcOutValue(nprocIndex,"resultset", 2,7); // 2 for object
				// execute procedure
				dao.executeProcedureByPosition(nprocIndex);

				// get value

				strerr = dao.getString(nprocIndex, "err");

				if (strerr == null)
					strerr = "";

				if (strerr.equals(""))
				{
					ws = dao.getWebRowSet(nprocIndex, "resultset");
					vo.setStrMsgType("0");
				} else {
					throw new Exception(strerr);
				}

			}

			catch (Exception e)
			{		
	            e.printStackTrace();
				vo.setStrMsgString("-->OfflineIssueIndentDAO.STORENAMECOMBO()"+ e.getMessage());

				vo.setStrMsgType("1");

			}

			finally
			{

				if (dao != null) 
				{

					dao.free();

					dao = null;

				}

			}

			return ws;
		}
	 
		
	 public static void itemCategoryCombo1(IssueTransVO vo)
	 {
			int     nProcIndex = 0;
			String      strErr = "";
			String         str = "";
			HisUtil    hisutil = null;
			WebRowSet       ws = null;
			HisDAO      daoObj = null;		
			String strProcName = "{call PKG_MMS_VIEW.proc_item_category_list(?,?,?,?,?,?)}";
		      
			try
			{
				// Creating Object
				   hisutil = new HisUtil("MMS", "IssueTransDAO");
				   daoObj  = new HisDAO ("MMS","IssueTransDAO");
				nProcIndex = daoObj.setProcedure(strProcName);
				// Set Values
				daoObj.setProcInValue(nProcIndex, "modeval", "2");
				daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId());
				daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
				daoObj.setProcInValue(nProcIndex, "reqType","31");
				daoObj.setProcOutValue(nProcIndex,"err",1); 
				daoObj.setProcOutValue(nProcIndex,"resultset",2);
				// execute procedure
				daoObj.executeProcedure(nProcIndex);
				
				strErr = daoObj.getString(nProcIndex, "err");
				if (strErr == null)
					strErr = "";
				// get values
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
						
				if(ws.next())
				{
					vo.setStrItemCagID(ws.getString(1));
				}
	            ws.beforeFirst();
				if (strErr.equals("")) 
				{
					if(ws!=null)
					{
						str = hisutil.getOptionValue(ws, vo.getStrItemCagID(),"0^Select Value", true);
						
						vo.setStrItemCategoryCmb(str);		
						vo.setStrMsgType("0");
					}	
					else
					{
						str = "<option value='0'>DATA N/A</option>";  
						vo.setStrItemCategoryCmb(str);
						vo.setStrMsgType("0");
					}
					
				} else {
					throw new Exception(strErr);
				}
			}
			catch(Exception e)
			{
				//e.printStackTrace();
				vo.setStrMsgString("IssueTransDAO.itemCategoryCombo() --> "
						+ e.getMessage());
				vo.setStrMsgType("1");
			}
		}	
	 
	 
	 /**
		 * To get Issue Details i.e.(Store Name,Issue No.,Issue Date,Indent
		 * Type,Item Category,Raising Store) on 'issue' page
		 * 
		 * @param vo
		 */
		public static void getCRIssueDetail(IssueTransVO vo) 
		{
		    // Declaring Variables 
			String        err = "";
			int    procIndex1 = 0;
			HisDAO        dao = null;
			WebRowSet      ws = null;
			String proc_name1 = "{call Pkg_Mms_View.proc_OffLine_IssueNo_dtl(?,?,?,?,?,?,?,?)}";

			try 
			{
				System.out.println("---------Pkg_Mms_View.proc_OffLine_IssueNo_dtl-[ Mode -5 ]---------"); 
	            // Cerating Object			
				       dao = new HisDAO("MMS",	"IssueTransDAO.getIssueDetail(IssueTransVO vo)");
				procIndex1 = dao.setProcedure(proc_name1);

				// set value
				dao.setProcInValue(procIndex1, "modeval", 	"5",1);                  //1
				dao.setProcInValue(procIndex1, "storeid", 	vo.getStrStoreName(),2);//2
				dao.setProcInValue(procIndex1, "itemCatg", 	vo.getStrCrNo(),3);//3
				dao.setProcInValue(procIndex1, "from_date", vo.getStrFromDate(),4);//4
				dao.setProcInValue(procIndex1, "too_date", 	vo.getStrToDate(),5);//5
				dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),6); //6
				dao.setProcOutValue(procIndex1,"err", 		1,7); // 1 for string return //7
				// value
				dao.setProcOutValue(procIndex1, "resultset", 2,8); // 2 for object //8
				// execute procedure
				dao.executeProcedureByPosition(procIndex1);

				// get value
				err = dao.getString(procIndex1, "err");

				if (err == null)
					err = "";

				/*if (err == null)
					err = "";*/

				if (err.equals("")) {

					ws = dao.getWebRowSet(procIndex1, "resultset");
					vo.setIssueNoDtlWs(ws);
					
				} else {

					throw new Exception(err);
				}

			} catch (Exception e) {
	            e.printStackTrace();
				vo.setStrMsgString("IssueTransDAO.getIssueDetail() --> "
						+ e.getMessage());
				vo.setStrMsgType("1");

			} finally {

				if (dao != null) {
					dao.free();
					dao = null;
				}

			}

		}
		
		public static void getImageHeader(IssueTransVO voObj)
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
}
