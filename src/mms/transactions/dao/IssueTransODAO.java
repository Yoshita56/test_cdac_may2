package mms.transactions.dao;

import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import billing.CashCollectionOfflineTransVO;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
//import billing.transactions.LFNoTransVO;
//import mms.MmsConfigUtil;
import mms.dao.DmlHsttPatEmpIssueDtlDAO;
import mms.dao.DmlHsttPatEmpIssueDtlWithoutCrNoDAO;
import mms.dao.DmlHsttPatEmpIssueItemDtlDAO;
import mms.dao.DmlHsttPatEmpIssueItemDtlWithoutCrNoDAO;
import mms.transactions.controller.fb.IssueTransOFB;
import mms.transactions.vo.IssueTransOVO;

public class IssueTransODAO 
{
	
	public static void getPatientAddmissionFlag(IssueTransOVO vo) 
	{
		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		try {
			dao = new HisDAO("MMSModule", "IssueTransODAO");
						
			funcIndex = dao.setFunction("{? = call MMS_MST.get_patient_Admission_status(?,?,?)}");	
			
			System.out.println(" ------- IssueTransODAO .MMS_MST.get_patient_Admission_status  -------- ");
			
			// Set Value
			dao.setFuncInValue(funcIndex, 2, "1");
			dao.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4, vo.getStrCrNo());			
			dao.setFuncOutValue(funcIndex, 1);
			// Execute Function
			dao.executeFunction(funcIndex);
			retVal = dao.getFuncString(funcIndex);
			if (retVal != null && retVal!="0") 
			{
				vo.setStrInvalidCrFlag("2");
			} 
			else 
			{				
				vo.setStrInvalidCrFlag("0");
			}
			
			System.out.println(" -----vo.setStrInvalidCrFlag -------- "+vo.getStrInvalidCrFlag());

		} catch (Exception e) 
		{
			vo.setStrMsgString("IssueTransODAO.getPatientAddmissionFlag() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
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
	public static void getIssueDtlsList(IssueTransOVO vo) 
	{
		String err;
		//String strSlNoflg;
		HisDAO        dao = null;
		WebRowSet      ws = null;
		int    procIndex1 = 0;
		String proc_name1 = "{call pkg_mms_view.Proc_Emp_Issue_Detail(?,?,?,?,?,?)}"; //6
		try 
		{
			System.out.println(" ------- IssueTransODAO .getIssueDtlsList  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_Emp_Issue_Detail  --[ Mode- 3 ]------ ");
			
			/*
			  Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line Issue Voucher)
			  1.Hospital Name ^ DDC Name ^ Prescribe For ^ Issue No ^ Issued By Doctor ^ Date ^ Cr No ^ Hindi Text  
			  2.Drug Name
			  3.Batch No 
			  4.Exp Date
			  5.Issue Qty
			 */				
			dao = new HisDAO("mms","global.IssueTransODAO.getStockItemDtlsList(IssueTransOVO vo)");			
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
			vo.setStrMsgString("IssueTransODAO.getIssueDtlsList() --> "+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	public static void getStoreList(IssueTransOVO voObj) {

		HisDAO      daoObj = null;
		WebRowSet       ws = null;
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int     nProcIndex = 0;	
		String strErr = "";
		try
		{
			System.out.println(" ------- IssueTransODAO .getStoreList  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_hstt_store_mst  --[ Mode- 12 ]------ ");
			
			    daoObj = new HisDAO("MMS Transactions","IssueTransODAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			////System.out.println("In DAO==>"+nProcIndex);
             
			daoObj.setProcInValue(nProcIndex, "modeval", "12",1);
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			
			/* Setting Default Value Start*/
			daoObj.setProcInValue(nProcIndex, "storeid", "0",4);
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0",5);
			/* Setting Default Value End */
			
			daoObj.setProcOutValue(nProcIndex, "err", 1,6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			   strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) 
			{

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrStoreWs(ws);
							
			} 
			else
			{
				throw new Exception(strErr);
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			voObj.setStrMsgString("IssueTransODAO.getStoreList() --> "+ e.getMessage());
			voObj.setStrMsgType("1");

		} 
		finally 
		{
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getViewStoreList(IssueTransOVO voObj) 
	{

		HisDAO  daoObj = null;
		WebRowSet   ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			
			System.out.println(" ------- IssueTransODAO .getViewStoreList  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_hstt_store_mst  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions","IssueTransODAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			////System.out.println("In DAO==>"+nProcIndex);
             
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			
			/* Setting Default Value Start*/
			daoObj.setProcInValue(nProcIndex, "storeid", "0",4);
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0",5);
			/* Setting Default Value End */
			
			daoObj.setProcOutValue(nProcIndex, "err", 1,6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);

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
			voObj
					.setStrMsgString("IssueTransODAO.getViewStoreList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	
	public static void getPatinetTypeCmb(IssueTransOVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_raol_catg_list(?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		try {

			System.out.println(" ------- IssueTransODAO .getPatinetTypeCmb  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_raol_catg_list  --[ Mode- 1 ]------ ");
			
			daoObj = new HisDAO("MMS Transactions","IssueTransODAO");

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

			if (strErr.equals("")) 
			{
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				if(ws!=null && ws.size()>0)
				{	
				   voObj.setStrPatientTypeWs(ws);
				}							
			} 
			else 
			{
				throw new Exception(strErr);
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			voObj.setStrMsgString("IssueTransODAO.getPatinetTypeCmb() --> "+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	
	public static void getItemCatDtls(IssueTransOVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			
			System.out.println(" ------- IssueTransODAO .getItemCatDtls  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_item_category_list  --[ Mode- 6 ]------ ");


			daoObj = new HisDAO("MMS Transactions","IssueTransODAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval",    "6",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code",  voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "store_id",  (voObj.getStrStoreId().equals("") || voObj.getStrStoreId() == null)?"0":voObj.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "reqType",    voObj.getStrReqTypeId(),4);
			
			daoObj.setProcOutValue(nProcIndex, "err",       1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

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
			voObj
					.setStrMsgString("IssueTransODAO.getItemCatDtls() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
		public static void GET_PAT_ACC_STATUS(IssueTransOVO vo) 
		{
			String proc_name1 = "";
			proc_name1 = "{call PKG_MMS_VIEW.proc_hblt_pataccount_dtl(?,?,?,?,?,?,?,?)}";
			HisDAO dao = null;
			int procIndex1 = 0;
			String strerr = "";
			WebRowSet ws = null;
			try 
			{
	            System.out.println("------------- IssueTransODAO.GET_PAT_ACC_STATUS -------------");
				
				System.out.println("------------- PKG_MMS_VIEW.proc_hblt_pataccount_dtl --[ Mode - 14 ]-----------");
				
				/*
	                0 -  Ac Balance
	                1 -  Patient Catg Code
	                2 -  ADMISSION_DATE
	                3 -  DISCHARGE_DATE
	                4 -  PATACCOUNT_STATUS in Text
	                5 -  HBLNUM_PATACCOUNT_STATUS 
	                6 -  GETCATGRP
	                7 -  HBLNUM_ACCOUNT_TYPE
	                8 -  hblnum_finalbill_flag
	                
	             */				
				dao = new HisDAO("mms","IssueTransODAO.getAccountDtlWithAcctNo()");
				procIndex1 = dao.setProcedure(proc_name1);
				dao.setProcInValue(procIndex1, "accNo", 		"", 1);
				dao.setProcInValue(procIndex1, "modeVal", 		"14", 5);
				dao.setProcInValue(procIndex1, "puk",			vo.getStrCrNo(), 2);
				dao.setProcInValue(procIndex1, "chargeTypeId", 	"", 3);
				dao.setProcInValue(procIndex1, "activeAccount", "", 4);
				dao.setProcInValue(procIndex1, "hosp_code",		vo.getStrHospitalCode(), 6);
				dao.setProcOutValue(procIndex1, "ERR", 			1, 7);
				dao.setProcOutValue(procIndex1, "RESULTSET", 	2, 8);
				
				dao.executeProcedureByPosition(procIndex1);
				strerr = dao.getString(procIndex1, "ERR");

				if (strerr == null)
					strerr = "";

				if (strerr.equals("")) 
				{
					ws = dao.getWebRowSet(procIndex1, "RESULTSET");
					vo.setStrAccDtl(ws);
					
					vo.setStrMsgType("0");
				} 
				else 
				{
					throw new Exception(strerr);
				}
			} 
			catch (Exception e) 
			{
				vo.setStrMsgString("IssueTransODAO.GET_PAT_ACC_STATUS() --> "+ e.getMessage());
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
		}
	public static void getItemCatDtls1(IssueTransOVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			
			System.out.println(" ------- IssueTransODAO .getItemCatDtls1  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_item_category_list  --[ Mode- 3 ]------ ");

			daoObj = new HisDAO("MMS Transactions","IssueTransODAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "3",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "store_id", (voObj.getStrStoreId().equals("") || voObj.getStrStoreId() == null)?"001":voObj.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "reqType", voObj.getStrReqTypeId(),4);
			
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

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
			voObj
					.setStrMsgString("IssueTransODAO.getItemCatDtls() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	public static void getissuetopatient(IssueTransOVO vo) 
	{

		HisDAO dao = null;
		WebRowSet ws = null;

		String proc_name1 = "{call Pkg_Mms_View.proc_patient_issue_drug_dtl(?,?,? ,?,?,? ,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";
		 System.out.println("<------------- IssueTransODAO.getissuetopatient ------------->");
		 

		try 
		{
			    System.out.println("<------------- Pkg_Mms_View.proc_patient_issue_drug_dtl [ Mode - 3]------------->");
			    
			    dao = new HisDAO("MMS",	"OfflineIssueIndentTransDAO.getissuetopatient(OfflineIssueIndentTransVO vo)");
			    nProcIndex = dao.setProcedure(proc_name1);
				// set value
				dao.setProcInValue(nProcIndex, "modeval", "3",1);                  //1
				dao.setProcInValue(nProcIndex, "storeid",  vo.getStrStoreId(),2);//2
				dao.setProcInValue(nProcIndex, "itemCatg", vo.getStrItemCat(),3);//3
				dao.setProcInValue(nProcIndex, "from_date",vo.getStrCrNo(),4);//4
				dao.setProcInValue(nProcIndex, "too_date", "",5);//5
				dao.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),6); //6
				dao.setProcInValue(nProcIndex, "crno",vo.getStrCrNo(),7); //6
				dao.setProcOutValue(nProcIndex,"err", 1,8); // 1 for string return //7
				dao.setProcOutValue(nProcIndex, "resultset", 2,9);//8
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
			vo
					.setStrMsgString("IssueTransODAO.getIssueDetailTwo() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	public static void getCancelIssueDtls(IssueTransOVO voObj)
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_issue_item_dtls(?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try 
		{
			System.out.println(" ------- IssueTransODAO .getCancelIssueDtls  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_issue_item_dtls  --[ Mode- 3 ]------ ");
			
			daoObj = new HisDAO("MMS Transactions","IssueTransODAO");
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
			voObj
					.setStrMsgString("IssueTransODAO.getCancelIssueDtls() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	public static void getIssueDetail(IssueTransOVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Issue_Details(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			
			System.out.println(" ------- IssueTransODAO .getCancelIssueDtls  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_Issue_Details  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions","IssueTransODAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modval", "1",1);
			daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "crNo", voObj.getStrCrNum(),4);
			daoObj.setProcInValue(nProcIndex, "catCode", voObj.getStrCatCode(),5);
			daoObj.setProcInValue(nProcIndex, "days", "10",6);
			daoObj.setProcInValue(nProcIndex, "empNo", "",7);//default value.
			daoObj.setProcOutValue(nProcIndex, "err", 1,8);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,9);
			

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
					.setStrMsgString("IssueTransODAO.getIssueDetail() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getIssueDetailTwo(IssueTransOVO vo) 
	{

		HisDAO dao = null;
		WebRowSet ws = null;

		String proc_name1 = "{call Pkg_Mms_View.proc_patient_issue_drug_dtl(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try 
		{
			System.out.println(" ------- IssueTransODAO .getIssueDetailTwo  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_Issue_Details  --[ Mode- 1 ]------ ");
			
			    dao = new HisDAO("MMS",	"OfflineIssueIndentTransDAO.getIssueDetailTwo(OfflineIssueIndentTransVO vo)");
			    nProcIndex = dao.setProcedure(proc_name1);
				// set value
				dao.setProcInValue(nProcIndex, "modeval", "1",1);                  //1
				dao.setProcInValue(nProcIndex, "storeid",  vo.getStrStoreName(),2);//2
				dao.setProcInValue(nProcIndex, "itemCatg", vo.getStrItemCategoryNo(),3);//3
				dao.setProcInValue(nProcIndex, "from_date",vo.getStrFromDate(),4);//4
				dao.setProcInValue(nProcIndex, "too_date", vo.getStrToDate(),5);//5
				dao.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),6); //6
				dao.setProcInValue(nProcIndex, "crno",vo.getStrCrNo(),7); //6
				dao.setProcOutValue(nProcIndex,"err", 1,8); // 1 for string return //7
				dao.setProcOutValue(nProcIndex, "resultset", 2,9);//8
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
			vo
					.setStrMsgString("IssueTransODAO.getIssueDetailTwo() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getIssueDtlPopUp(IssueTransOVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call  Pkg_Mms_View.Proc_IssuePopup_Dtls(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			
			System.out.println(" ------- IssueTransODAO .getIssueDtlPopUp  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_IssuePopup_Dtls  --[ Mode- 1 ]------ ");
			

			daoObj = new HisDAO("MMS Transactions","IssueTransODAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code",voObj.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStoreId(),4);
			daoObj.setProcInValue(nProcIndex, "issueno", voObj.getStrIssueNo(),3);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset",2,6);
			
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
			voObj
					.setStrMsgString("IssueTransODAO.getIssueDtlPopUp() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getRequestDtls(IssueTransOVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Issue_Request_Dtls(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";
		int funcIndex;
		String BillingValue="";

		try {

			daoObj = new HisDAO("MMS Transactions","IssueTransODAO");

			System.out.println("<------------- IssueTransODAO.getRequestDtls() ------------->"); 
			
			System.out.println("<------------- bill_mst.get_pat_accountdetails_limit [ Mode - 2 ] ------------->"); 

			funcIndex = daoObj.setFunction("{? = call bill_mst.get_pat_accountdetails_limit(?,?,?)}");

			daoObj.setFuncInValue(funcIndex, 2,voObj.getStrHospitalCode());
			daoObj.setFuncInValue(funcIndex, 3,"2");
			daoObj.setFuncInValue(funcIndex, 4,voObj.getStrCrNumber());
			//daoObj.setFuncInValue(funcIndex, 5,vo.getStrItemCategNo());
			daoObj.setFuncOutValue(funcIndex, 1);
			daoObj.executeFunction(funcIndex);
			BillingValue = daoObj.getFuncString(funcIndex);			
			voObj.setStrBillingHiddenValue(BillingValue);
			
			
			System.out.println("<------------- Pkg_Mms_View.Proc_Issue_Request_Dtls [ Mode - 1 ] ------------->"); 
			
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "crNo", voObj.getStrCrNumber(),3);
			daoObj.setProcInValue(nProcIndex, "days", voObj.getStrOnlineIssueReqDays(),4);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

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
			voObj
					.setStrMsgString("IssueTransODAO.getRequestDtls() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	
	public static void getOnlineTreatmentDtls(IssueTransOFB formBean,IssueTransOVO vo) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_mms_view.PROC_HRGT_PATIENT_TREATMENT_DTL_ONLINE(?,?,?,?,?,? ,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		String strCrNum = formBean.getStrCrNo();
		String strHospcode = formBean.getStrHospitalCode();
		
		String strStoreId = formBean.getStrStoreId().split("\\^")[0];
		try {
			
			System.out.println(" ------- IssueTransODAO .getOnlineTreatmentDtls  -------- ");
			System.out.println(" ------- pkg_mms_view.PROC_HRGT_PATIENT_TREATMENT_DTL_ONLINE  --[ Mode- 3 ]------ ");
			
			daoObj = new HisDAO("Global Patient Details","PatientDtlDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			if (strCrNum != null && !strCrNum.equals("")) {
				
				daoObj.setProcInValue(nProcIndex, "modeVal", "3",1);
				daoObj.setProcInValue(nProcIndex, "puk", strCrNum,2);
				daoObj.setProcInValue(nProcIndex, "hosp_code",strHospcode,3);
				daoObj.setProcInValue(nProcIndex, "store_id",strStoreId,4);
				
				daoObj.setProcInValue(nProcIndex, "episode", formBean.getStrEpisodeCode(),5);
				daoObj.setProcInValue(nProcIndex, "deptcode",formBean.getStrDeptCode(),6);
				daoObj.setProcInValue(nProcIndex, "deptunit",formBean.getStrUnitCode(),7);
				
				
				daoObj.setProcOutValue(nProcIndex, "err", 1,8);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,9);
				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
            	if (strErr.equals("")) {
            		vo.setOnlineTreatmentDtlsWs(ws);
				} 
            	else 
            	{
					throw new Exception(strErr);
				}
				
			 } 

			} catch (Exception e) 
			{
			 vo.setStrMsgString("PatientDtlDAO.setPatientTreatmentDtl() --> "+ e.getMessage());
			 vo.setStrMsgType("1");

			} 
			finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
				}
			}
	}

	
	public static void getAlreadyDrugIssue(IssueTransOFB formBean,IssueTransOVO vo) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_mms_view.PROC_HRGT_PATIENT_TREATMENT_DTL_ONLINE(?,?,?,?,?,? ,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		String strCrNum = formBean.getStrCrNo();
		String strHospcode = vo.getStrHospitalCode();
		
		try {
			
			System.out.println(" ------- IssueTransODAO .getAlreadyDrugIssue  -------- ");
			System.out.println(" ------- pkg_mms_view.PROC_HRGT_PATIENT_TREATMENT_DTL_ONLINE  --[ Mode- 1 ]------ ");
			
			daoObj = new HisDAO("Global Patient Details","PatientDtlDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			if (strCrNum != null && !strCrNum.equals("")) {
				
				daoObj.setProcInValue(nProcIndex, "modeVal", "1",1);
				daoObj.setProcInValue(nProcIndex, "puk", strCrNum,2);
				daoObj.setProcInValue(nProcIndex, "hosp_code",strHospcode,3);
				daoObj.setProcInValue(nProcIndex, "store_id",vo.getTariff(),4);
				
				daoObj.setProcInValue(nProcIndex, "episode", formBean.getStrEpisodeCode(),5);
				daoObj.setProcInValue(nProcIndex, "deptcode",formBean.getStrDeptCode(),6);
				daoObj.setProcInValue(nProcIndex, "deptunit",formBean.getStrUnitCode(),7);
				
				
				daoObj.setProcOutValue(nProcIndex, "err", 1,8);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,9);
				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				System.out.println("Already Development"+ws.size());
            	if (strErr.equals("")) {
            		vo.setAlreadyIssueDrug(ws);
				} 
            	else 
            	{
					throw new Exception(strErr);
				}
				
			 } 

			} catch (Exception e) 
			{
			 vo.setStrMsgString("PatientDtlDAO.setPatientTreatmentDtl() --> "+ e.getMessage());
			 vo.setStrMsgType("1");

			} 
			finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
				}
			}
	}

	
	public static void getRequestDetails(IssueTransOVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Request_Dtls(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			
			System.out.println(" ------- IssueTransODAO .getRequestDetails  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_Request_Dtls  --[ Mode- 1 ]------ ");

			
			daoObj = new HisDAO("MMS Transactions","IssueTransODAO");

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
			voObj
					.setStrMsgString("IssueTransODAO.getRequestDetails() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getFrequencyDetails(IssueTransOVO voObj) {

		HisDAO daoObj = null;
		WebRowSet strFrequencyWs = null;

		String strProcName = "{call Pkg_Mms_View.proc_frequency_dtl(?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			
            System.out.println("<------------- IssueTransODAO.getFrequencyDetails() ------------->"); 
			
			System.out.println("<------------- Pkg_Mms_View.proc_frequency_dtl ------------->"); 

			daoObj = new HisDAO("MMS Transactions","IssueTransODAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),1);
			daoObj.setProcOutValue(nProcIndex, "err", 1,2);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,3);

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
			voObj
					.setStrMsgString("IssueTransODAO.getFrequencyDetails() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getDoseDetails(IssueTransOVO voObj) {

		HisDAO daoObj = null;
		WebRowSet strDosageWs = null;

		String strProcName = "{call Pkg_Mms_View.proc_dosage_dtl(?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","IssueTransODAO");
			
			  System.out.println("<------------- IssueTransODAO.getDoseDetails() ------------->"); 
				
				System.out.println("<------------- Pkg_Mms_View.proc_dosage_dtl ------------->"); 


			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),1);
			daoObj.setProcOutValue(nProcIndex, "err", 1,2);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,3);

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
			voObj
					.setStrMsgString("IssueTransODAO.getDoseDetails() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getDeptDetails(IssueTransOVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_department(?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			
			System.out.println(" ------- IssueTransODAO .getDeptDetails  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_department  --[ Mode- 1 ]------ "); 

			daoObj = new HisDAO("MMS Transactions","IssueTransODAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "seatid", voObj.getStrSeatId(),3);
			daoObj.setProcOutValue(nProcIndex, "err", 1,4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,5);

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
			voObj
					.setStrMsgString("IssueTransODAO.getDeptDetails() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getUnitDetails(IssueTransOVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Unit(?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			
			System.out.println(" ------- IssueTransODAO .getUnitDetails  ---(Dept Wise Unit)----- ");
			System.out.println(" ------- pkg_mms_view.Proc_Unit  --[ Mode- 1 ]------ "); 

			daoObj = new HisDAO("MMS Transactions","IssueTransODAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "dept_code", voObj.getStrDeptCode(),1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId(),3);
			daoObj.setProcOutValue(nProcIndex, "err", 1,4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,5);

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
			voObj
					.setStrMsgString("IssueTransODAO.getUnitDetails() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getPrescribedBy(IssueTransOVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Consultant_Name(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			
			System.out.println(" ------- IssueTransODAO .getPrescribedBy  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_Consultant_Name  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions","IssueTransODAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "deptunitcode", voObj.getStrUnitCode(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId(),4);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

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
			voObj
					.setStrMsgString("IssueTransODAO.getPrescribedBy() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	public static void getItemDetails(IssueTransOVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_IssueItem_Dtl(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			System.out.println(" ------- IssueTransODAO .getItemDetails  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_IssueItem_Dtl  --[ Mode- 1 ]------ ");
			
			daoObj = new HisDAO("MMS Transactions","IssueTransODAO");

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
			voObj
					.setStrMsgString("IssueTransODAO.getItemDetails() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getUnitCombo(IssueTransOVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_mms_view.proc_gblt_unit_mst(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			
			System.out.println(" ------- IssueTransODAO .getUnitCombo  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_gblt_unit_mst  --[ Mode- 1 ]------ ");

			daoObj = new HisDAO("MMS Transactions","IssueTransODAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "unit_id", voObj.getStrIssueUnitId());
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "module_id", "");//Default Value
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
			voObj
					.setStrMsgString("IssueTransODAO.getUnitCombo() --> "
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
	 * This function is fetch details from database for group combo
	 * @param vo
	 */

	public static void getStoreGroupList(IssueTransOVO vo) {
		

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {
			
			    System.out.println("<------------- IssueTransODAO.getStoreGroupList() ------------->"); 
			    System.out.println("<------------- pkg_mms_view.proc_store_group_list [ Mode - 2 ]------------->"); 

				dao = new HisDAO("MMS Transactions","IssueTransODAO");
		
				procIndex1 = dao.setProcedure(proc_name1);
				dao.setProcInValue(procIndex1, "modeval", "2",1);
				// set value
				dao.setProcInValue(procIndex1, "item_category", vo.getStrItemCat(),3);
				dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),2);
				
				/* Setting Default Value Start*/
				dao.setProcInValue(procIndex1, "strPhyStockNo", "",4);
				dao.setProcInValue(procIndex1, "strStoreId", "",5);
				/* Setting Default Value End */
				
				dao.setProcOutValue(procIndex1, "ERR", 1,6); // 1 for string return
				// value
				dao.setProcOutValue(procIndex1, "RESULTSET", 2,7); // 2 for object
		
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
			vo.setStrMsgString("IssueTransODAO.getStoreGroupList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	
	
	public static synchronized void insert(IssueTransOVO vo) 
	{
		HisDAO         dao = null;		
		String strFuncName = "";
		int     nFuncIndex = 0;
		int         length = 0;
		String  paramVal[] = null;
		String userValue[] = null;
		String  strIssueNo = "";
		String strVisitDtl = "";
		Double     netCost = 0.00;
		DmlHsttPatEmpIssueItemDtlDAO dmlhsttpatempissueitemdtl = null;
		DmlHsttPatEmpIssueDtlDAO         dmlhsttpatempissuedtl = null;
		
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
	//	MmsConfigUtil mcu;

		try 
		{
			
			System.out.println("------------- IssueTransODAO.insert ------  START ------");
			System.out.println(" ------- bill_interface.dml_online_billreq_drugs  --[ Mode- 2 ]------ ");

			
			debugPoint = 1;
		//	mcu =new MmsConfigUtil(vo.getStrHospitalCode());
			dao = new HisDAO("MMS Transactions","IssueTransODAO");
			dmlhsttpatempissueitemdtl = new DmlHsttPatEmpIssueItemDtlDAO();
			    dmlhsttpatempissuedtl = new DmlHsttPatEmpIssueDtlDAO();			
			              strFuncName = "{? = call MMS_MST.generate_issueNo(?::numeric,?::numeric,?::numeric,?::numeric)}";
			               nFuncIndex = dao.setFunction(strFuncName);
			               
			dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId());
			dao.setFuncInValue(nFuncIndex, 4, "32");
			dao.setFuncInValue(nFuncIndex, 5, vo.getStrItemCat());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strIssueNo = dao.getFuncString(nFuncIndex);
			vo.setStrIssueNumber(strIssueNo.split("\\^")[0]);
			
			System.out.println(" ------- MMS_MST.generate_issueNo  --[ Mode- 1 ]------ ");
			
			System.out.println(" ------- strIssueNo------ "+strIssueNo);
			
			debugPoint = 2;
			
			
		
			          strVisitDtl = "0"	;	
			String strEpisodeCode = "0";
			String     strVisitNo = "0" ;
			
			                  dao = new HisDAO("MMS Transactions","IssueTransODAO");
			               length = vo.getItemParamValue().length;	
			               
			for(int k=0;k<length;k++)
			{				
				/**
				 * Hidden Values corresponding to particular
				 * ITEM DETAILS
				 */	
				debugPoint = 3;
						if(vo.getStrQtyText()[k] != null && vo.getStrQtyText()[k].length() > 0 && !vo.getStrQtyText()[k].equals("0"))
						{	
							itemValue = vo.getItemParamValue()[k];
							
											 paramVal = vo.getItemParamValue()[k].split("#");						
											userValue = paramVal[2].replace('^', '#').split("#");	
											
											debugPoint = 4;
											
											if(strBillTariff != null && strBillTariff != "")
												strBillTariff=strBillTariff + "^"+userValue[1];
												else
													strBillTariff = userValue[1];
											/*
												if(strBillRate != null && strBillRate != "")
												{
													strBillRate=strBillRate + "^"+userValue[9];
												}
												else
												{	
														strBillRate = userValue[9];
												}
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
												
												if(strBillQty != null && strBillQty != "")
													strBillQty=strBillQty + "^"+vo.getStrQtyText()[k];
													else
														strBillQty = vo.getStrQtyText()[k];
												if(strBillBatch != null && strBillBatch != "")
													strBillBatch=strBillBatch + "^"+userValue[15];
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
							dmlhsttpatempissueitemdtl.setStrIssueQtyUnitId(strInventoryUnitId); //Aritra,22nd June							
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
							dmlhsttpatempissueitemdtl.setStrOrderBy(vo.getStrReqPrescribedBy());//Id od the consultant
							
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
			if(vo.getStrLFAccountNo() != null && vo.getStrLFAccountNo() !="")
			{
			//if(mcu.getStrBillingIntegration().equals("1"))
			//{
				int procIndex2;
				procIndex2 = dao.setProcedure(proc_name2);
				
				
				
				
				dao.setProcInValue(procIndex2, "modval", "2", 1); // 1
				dao.setProcInValue(procIndex2, "gnum_dept_code", vo.getStrDeptCode(), 2);
				dao.setProcInValue(procIndex2, "sblnum_chargetype_id", "1", 3);
				dao.setProcInValue(procIndex2, "sblnum_service_id", "5", 4);
				dao.setProcInValue(procIndex2, "gstr_req_no", vo.getStrIssueNumber(), 5);
				dao.setProcInValue(procIndex2, "gnum_treatment_cat", "11",6);
				dao.setProcInValue(procIndex2, "hrgnum_episode_code","1", 7);
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
				dao.setProcInValue(procIndex2, "admno","1", 25);
				dao.setProcInValue(procIndex2, "visitno", vo.getStrVisitNo(), 26);
				dao.setProcOutValue(procIndex2, "err", 1, 27);
				dao.execute(procIndex2, 1);
				
			//}
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
					dmlhsttpatempissuedtl.setStrFinalCost(DmlHsttPatEmpIssueItemDtlDAO.getIntCost()+"");
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
                    // vo.getStrPatientHiddenValue1	    Patient Name ^Father Name^Category Code^Address^Mlc No						
					/* vo.getStrPatientDtlHidVal()
		              HRGDT_DOB || ''^'' ||GNUM_GENDER_CODE ||''^''||HGNUM_PAT_STATUS_CODE || ''^''||
			          HGNUM_PATIENT_CAT_CODE || ''^'' ||HRGNUM_IS_MLC    ||''^''||HRGNUM_ISNEWBORN      || ''^''|| HRGNUM_ID_NO
					*/
					// By Vivek	
					
					itemValue += " PatientHiddenValue1 :: " + vo.getStrPatientHiddenValue1() + " StrPatientDtlHidVal :: " + vo.getStrPatientDtlHidVal();

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
					dmlhsttpatempissuedtl.setStrTransType("1");  // With CR No	
					dmlhsttpatempissuedtl.setStrDrugIssueDate(vo.getStrDrugIssueDate());
					dmlhsttpatempissuedtl.setStrOutOfStockFlag(vo.getStrOutOfStockFlag());
					
					debugPoint = 20;
					
					dmlhsttpatempissuedtl.insert(dao);
					
					
					// DAO Fire
					synchronized (dao) {
						dao.fire();
					}
					
					
					debugPoint = 21;
					
					System.out.println("------------- IssueTransODAO.insert ------  END  ------");
		  
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgType("1");
			vo.setStrMsgString("IssueTransODAO.insert() --> "
					+ e.getMessage() + " DAO_DEBUG_POINT :: " + debugPoint + " DAO_VALUE :: " + itemValue);
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
	
	public static synchronized void insertipd(IssueTransOVO vo) 
	{
		HisDAO         dao = null;		
		String strFuncName = "";
		int     nFuncIndex = 0;
		int         length = 0;
		String  paramVal[] = null;
		String userValue[] = null;
		String  strIssueNo = "";
		String strVisitDtl = "";
		Double     netCost = 0.00;
		DmlHsttPatEmpIssueItemDtlDAO dmlhsttpatempissueitemdtl = null;
		DmlHsttPatEmpIssueDtlDAO         dmlhsttpatempissuedtl = null;
		
		int debugPoint = 0;
		String itemValue = "";
	
		String strIssueUnitId = "0";
		String strBillTariff = "";
		String strBillBatch = "";
		String strBillRate = "";
		String strBillQty = "";
		
		String strProcName = "";
		int nProcIndex = 0;
		
		String admissionDtl ="";
		String patDtl = "";
		
		//MmsConfigUtil mcu;

		try 
		{
			
			System.out.println(" ------- IssueTransODAO .insertipd  ---- START --[ Item Finder Selection ]-- ");
			//System.out.println(" ------- bill_interface.dml_online_billreq_drugs  --[ Mode- 1 ]------ ");
			
			debugPoint = 1;
			//mcu =new MmsConfigUtil(vo.getStrHospitalCode());
			dao = new HisDAO("MMS Transactions","IssueTransODAO");
			dmlhsttpatempissueitemdtl = new DmlHsttPatEmpIssueItemDtlDAO();
			    dmlhsttpatempissuedtl = new DmlHsttPatEmpIssueDtlDAO();			
			    
			System.out.println(" ---- MMS_MST.generate_issueNo  --- ");    
			
			System.out.println(" ---- HOSP_CODE --- "+vo.getStrHospitalCode());  
			System.out.println(" ---- STORE_CODE --- "+vo.getStrStoreId());
			System.out.println(" ---- CATG_CODE --- "+vo.getStrItemCat());
			System.out.println(" ------------------------------------- ");
			
			              strFuncName = "{? = call MMS_MST.generate_issueNo(?::numeric,?::numeric,?::numeric,?::numeric)}";
			               nFuncIndex = dao.setFunction(strFuncName);
			               
			dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId());
			dao.setFuncInValue(nFuncIndex, 4, "32");
			dao.setFuncInValue(nFuncIndex, 5, vo.getStrItemCat());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strIssueNo = dao.getFuncString(nFuncIndex);
			vo.setStrIssueNumber(strIssueNo.split("\\^")[0]);
			
			System.out.println(" Issue No ---- "+vo.getStrIssueNumber());
			
			debugPoint = 2;
			
			
		
			          strVisitDtl = "0"	;	
			String strEpisodeCode = "0";
			String     strVisitNo = "0" ;
			
			                  dao = new HisDAO("MMS Transactions","IssueTransODAO");
			               length = vo.getItemParamValue().length;	
			               
			               debugPoint = 12;
			               
			               System.out.println("-getStrAdmissionDtlHidVal-----" + vo.getStrAdmissionDtlHidVal());
			               
			   			
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
							dmlhsttpatempissuedtl.setStrAdmNo(vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[0]);
							
							debugPoint = 14;
							
							dmlhsttpatempissuedtl.setStrEmpNo(vo.getStrReqEmpNo());
							dmlhsttpatempissuedtl.setStrItemCatNo(vo.getStrItemCat());
							dmlhsttpatempissuedtl.setStrFinalCost(DmlHsttPatEmpIssueItemDtlDAO.getIntCost()+"");
							dmlhsttpatempissuedtl.setStrFinStartDate(vo.getStrFinStartDate());
							dmlhsttpatempissuedtl.setStrFinEndDate(vo.getStrFinEndDate());
							
							debugPoint = 15;
							
							dmlhsttpatempissuedtl.setStrSeatId(vo.getStrSeatId());
							dmlhsttpatempissuedtl.setStrDeptUnitCode(vo.getStrUnitCode());
							dmlhsttpatempissuedtl.setStrVisitType("2");// hardcoded in case of ipd patient
							dmlhsttpatempissuedtl.setStrDeptCode(vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[5]);
							
							dmlhsttpatempissuedtl.setStrWardCode(vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[6]);
							
							debugPoint = 16;
							
							dmlhsttpatempissuedtl.setStrReceiveBy(vo.getStrReceiveBy());
							dmlhsttpatempissuedtl.setStrRemarks(vo.getStrRemarks());
							dmlhsttpatempissuedtl.setStrReqDate("");
							dmlhsttpatempissuedtl.setStrVisitNo(strVisitNo);
							dmlhsttpatempissuedtl.setStrEpisoCode(strEpisodeCode);
							
							/*
				       		0	   NVL(HIPNUM_ADMNO, '0') 
				       		1	^  NVL(HRGNUM_EPISODE_CODE, '0') 
				       	    2	^  NVL(HRGNUM_VISIT_NO,'0') 
				       		3	^  NVL(TO_CHAR(HIPDT_ADMDATETIME,'DD-Mon-YYYY HH24:MI:SS'),' ')
				       		4	^  NVL(HIPNUM_ADM_ADVNO,'0') 
				       		5	^  NVL(GNUM_DEPT_CODE,'000')
				       		6	^  NVL(HIPNUM_WARD_CODE,'0') 
				       		7	^  NVL(HIPNUM_ROOM_CODE,'0') 
				       		8	^  NVL(HIPNUM_BED_CODE,'0')
				       		9	^  NVL(HIPNUM_TREAT_CATEG_CODE,'0')  
				       	   10	^  NVL(HIPNUM_ISNEWBORN,'0') 
				       	   11	^  NVL(HIPNUM_MOTHADMNO,'0') 
				       	   12	^  NVL(HRGNUM_MLC_NO,'0')
				       	   13	^  NVL(HIPNUM_OCCUP_ID,'0') 
				       	   14	^  NVL(TO_CHAR(HIPDT_BEDALLOC_DATETIME,'DD-Mon-YYYY HH24:MI:SS'),' ') 
				       	   15	^  NVL(HIPNUM_LENGTHOFSTAY,'0'))
				       	   16	^  NVL(GNUM_DEPTUNIT_CODE,'00000')
				       	   17	^  hblnum_pataccount_status
		       		*/		
							
							debugPoint = 17;
							
							// By Vivek		
		                    // vo.getStrPatientHiddenValue1	    Patient Name ^Father Name^Category Code^Address^Mlc No						
							/* vo.getStrPatientDtlHidVal()
				              HRGDT_DOB || ''^'' ||GNUM_GENDER_CODE ||''^''||HGNUM_PAT_STATUS_CODE || ''^''||
					          HGNUM_PATIENT_CAT_CODE || ''^'' ||HRGNUM_IS_MLC    ||''^''||HRGNUM_ISNEWBORN      || ''^''|| HRGNUM_ID_NO
							*/
							// By Vivek	
							
							itemValue += " PatientHiddenValue1 :: " + vo.getStrPatientHiddenValue1() + " StrPatientDtlHidVal :: " + vo.getStrPatientDtlHidVal();

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
							dmlhsttpatempissuedtl.setStrTransType("1");  // With CR No	
							dmlhsttpatempissuedtl.setStrDrugIssueDate(vo.getStrDrugIssueDate());
							dmlhsttpatempissuedtl.setStrOutOfStockFlag(vo.getStrOutOfStockFlag());
							
							debugPoint = 20;
							
						
							dmlhsttpatempissuedtl.insert(dao);  // Pkg_Mms_Dml2.Dml_Patemp_Issue_Dtls  --[ Mode- 1 ]
							
							System.out.println(" ------- Pkg_Mms_Dml2.Dml_Patemp_Issue_Dtls  --[ Mode- 1 ] ---- ");	
							
			               
			for(int k=0;k<length;k++)
			{				
				/**
				 * Hidden Values corresponding to particular
				 * ITEM DETAILS
				 */	
				debugPoint = 3;
						if(vo.getStrQtyText()[k] != null && vo.getStrQtyText()[k].length() > 0 && !vo.getStrQtyText()[k].equals("0"))
						{	
							itemValue = vo.getItemParamValue()[k];
							
							 paramVal = vo.getItemParamValue()[k].split("#");						
							userValue = paramVal[2].replace('^', '#').split("#");	
							
							//System.out.println(" ------- userValue --"+k+"-- "+userValue);	
							
							debugPoint = 4;
							
							if(strBillTariff != null && strBillTariff != "")
								strBillTariff=strBillTariff + "^"+userValue[1];
								else
									strBillTariff = userValue[1];
								
							      /*
							      if(strBillRate != null && strBillRate != "")
									strBillRate=strBillRate + "^"+userValue[9];
								  else
									strBillRate = userValue[9];
									*/
							      
							      if(vo.getStrHospitalCode().equals("98926"))
								  {
										if (strBillRate != null && strBillRate != "") {
											strBillRate = strBillRate + "^0";
										} 
										else 
										{
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
								
								
								if(strBillQty != null && strBillQty != "")
									strBillQty=strBillQty + "^"+vo.getStrQtyText()[k];
									else
										strBillQty = vo.getStrQtyText()[k];
								if(strBillBatch != null && strBillBatch != "")
									strBillBatch=strBillBatch + "^"+userValue[15];
									else
										strBillBatch = userValue[15];
								
								
								System.out.println("---------------------------");					
								System.out.println("strBillTariff-----"+strBillTariff);	
								System.out.println("strBillRate-------"+strBillRate);
								System.out.println("strBillQty--------"+strBillQty);
								System.out.println("strBillBatch------"+strBillBatch);
								System.out.println("group_id----------"+userValue[2]);
								System.out.println("item_id-----------"+userValue[0]);
								System.out.println("item_brand_id-----"+userValue[1]);
								System.out.println("---------------------------");	
							
						    admissionDtl = vo.getStrAdmissionDtlHidVal().replaceAll("[!@$%^&]", "#");
							patDtl       = vo.getStrPatientDtlHidVal().replaceAll("[!@$%^&]", "#");
							 
							System.out.println(" ------- Pkg_Mms_Dml2.Dml_Patemp_Issue_Items_Dtls  --[ Mode- 5 ] ---- ");	
							
							strProcName = "{call Pkg_Mms_Dml2.Dml_Patemp_Issue_Items_Dtls(?,?,?,?,?,?,?,?,?,?,    ?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?   ,?,?,?,?)}";// 44
							nProcIndex = dao.setProcedure(strProcName);

							dao.setProcInValue(nProcIndex, "modeval", 			"5", 1);
							dao.setProcInValue(nProcIndex, "issueNo", 			vo.getStrIssueNumber(), 2);
							dao.setProcInValue(nProcIndex, "req_No", 			vo.getStrRequestNo(), 3);
							dao.setProcInValue(nProcIndex, "issuing_store_id",	vo.getStrStoreId(), 4);
							dao.setProcInValue(nProcIndex, "reserved_qty_flag", "1", 5);
							dao.setProcInValue(nProcIndex, "category_No", 		vo.getStrItemCat(), 6);
							dao.setProcInValue(nProcIndex, "reqType_id", 		"32", 7);
							dao.setProcInValue(nProcIndex, "item_id", 			userValue[0], 8);
							dao.setProcInValue(nProcIndex, "item_brand_id", 	userValue[1], 9);
							dao.setProcInValue(nProcIndex, "batchSl_no", 		userValue[15], 10);
							dao.setProcInValue(nProcIndex, "hospital_code", 	vo.getStrHospitalCode(), 11);
							dao.setProcInValue(nProcIndex, "item_SlNo", 		"0", 12);
							dao.setProcInValue(nProcIndex, "stock_status_code", "10", 13);
							dao.setProcInValue(nProcIndex, "group_id", 			userValue[2], 14);
							dao.setProcInValue(nProcIndex, "subgroup_id", 		userValue[3], 15);
							dao.setProcInValue(nProcIndex, "inhand_qty", 		userValue[7], 16);
							dao.setProcInValue(nProcIndex, "inhand_qty_unitid", "6301", 17);
							dao.setProcInValue(nProcIndex, "bal_qty", 			"0", 18);
							dao.setProcInValue(nProcIndex, "bal_qty_unitid", 	"6301", 19);
							dao.setProcInValue(nProcIndex, "issue_qty", 		vo.getStrQtyText()[k], 20);
							dao.setProcInValue(nProcIndex, "issue_qty_unitid", "6301", 21);
							dao.setProcInValue(nProcIndex, "manuf_date", 		userValue[17], 22);
							dao.setProcInValue(nProcIndex, "expiry_date", 		userValue[16], 23);
							dao.setProcInValue(nProcIndex, "rate", 				userValue[9], 24);
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
									String.valueOf((Double.parseDouble(userValue[9])
											* Double.parseDouble(vo.getStrQtyText()[k]))),
									34);
							dao.setProcInValue(nProcIndex, "remarks", " Batch " + userValue[15] + " Qty "
									+ vo.getStrQtyText()[k] + "  Exp " + userValue[16], 35);
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
							
							/*
				       		0	   NVL(HIPNUM_ADMNO, '0') 
				       		1	^  NVL(HRGNUM_EPISODE_CODE, '0') 
				       	    2	^  NVL(HRGNUM_VISIT_NO,'0') 
				       		3	^  NVL(TO_CHAR(HIPDT_ADMDATETIME,'DD-Mon-YYYY HH24:MI:SS'),' ')
				       		4	^  NVL(HIPNUM_ADM_ADVNO,'0') 
				       		5	^  NVL(GNUM_DEPT_CODE,'000')
				       		6	^  NVL(HIPNUM_WARD_CODE,'0') 
				       		7	^  NVL(HIPNUM_ROOM_CODE,'0') 
				       		8	^  NVL(HIPNUM_BED_CODE,'0')
				       		9	^  NVL(HIPNUM_TREAT_CATEG_CODE,'0')  
				       	   10	^  NVL(HIPNUM_ISNEWBORN,'0') 
				       	   11	^  NVL(HIPNUM_MOTHADMNO,'0') 
				       	   12	^  NVL(HRGNUM_MLC_NO,'0')
				       	   13	^  NVL(HIPNUM_OCCUP_ID,'0') 
				       	   14	^  NVL(TO_CHAR(HIPDT_BEDALLOC_DATETIME,'DD-Mon-YYYY HH24:MI:SS'),' ') 
				       	   15	^  NVL(HIPNUM_LENGTHOFSTAY,'0'))
				       	   16	^  NVL(GNUM_DEPTUNIT_CODE,'00000')
				       	   17	^  hblnum_pataccount_status
		       		*/		
							/*
							int procIndex2;				
							String proc_name2 = "{call bill_interface.dml_online_billreq_drugs(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}";
							procIndex2 = dao.setProcedure(proc_name2);
							dao.setProcInValue(procIndex2, "modval", 					"1", 1); // 1
							dao.setProcInValue(procIndex2, "gnum_dept_code", 			vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[5], 2);
							dao.setProcInValue(procIndex2, "sblnum_chargetype_id", 		"2", 3);
							dao.setProcInValue(procIndex2, "sblnum_service_id", 		"5", 4);
							dao.setProcInValue(procIndex2, "gstr_req_no", 				vo.getStrIssueNumber(), 5);
							dao.setProcInValue(procIndex2, "gnum_treatment_cat", 		vo.getStrPatientDtlHidVal().replace("^","#").split("#")[3],6);
							dao.setProcInValue(procIndex2, "hrgnum_episode_code", 		vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[1], 7);
							dao.setProcInValue(procIndex2, "hrgnum_puk", 				vo.getStrPatientId(), 8);
							dao.setProcInValue(procIndex2, "hblnum_pat_lfaccount_no", 	"0", 9);
							dao.setProcInValue(procIndex2, "gstr_tariff", 				userValue[1], 10);
							dao.setProcInValue(procIndex2, "gstr_tariff_batch", 		userValue[15], 11);							
							if(vo.getStrHospitalCode().equals("98926"))
							{	
								dao.setProcInValue(procIndex2, "gstr_tariff_rates", 		"0", 12);
							}
							else
							{
								dao.setProcInValue(procIndex2, "gstr_tariff_rates", 		userValue[9], 12);
							}
							dao.setProcInValue(procIndex2, "gstr_reqqty", 				vo.getStrQtyText()[k], 13);
							dao.setProcInValue(procIndex2, "hblstr_patient_name", 		"", 14);
							dao.setProcInValue(procIndex2, "hblstr_pat_address", 		"", 15);
							dao.setProcInValue(procIndex2, "hblstr_contact_no", 		"", 16);
							dao.setProcInValue(procIndex2, "age", 						vo.getStrPatientDtlHidVal().replace("^","#").split("#")[10].split(" ")[0], 17);
							dao.setProcInValue(procIndex2, "ageunit",					vo.getStrPatientDtlHidVal().replace("^","#").split("#")[10].split(" ")[1].split("/")[0], 18);
							dao.setProcInValue(procIndex2, "gender", 					vo.getStrPatientDtlHidVal().replace("^","#").split("#")[1], 19);
							dao.setProcInValue(procIndex2, "refdoctor", 				"N/A", 20);
							dao.setProcInValue(procIndex2, "refdoccontactno", 			"0000000000", 21);
							dao.setProcInValue(procIndex2, "gnum_seatid", 				vo.getStrSeatId(), 22);
							dao.setProcInValue(procIndex2, "hosp_code", 				vo.getStrHospitalCode(), 23);
							dao.setProcInValue(procIndex2, "ward_code", 				vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[6], 24);
							dao.setProcInValue(procIndex2, "admno", 					vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[0], 25);
							dao.setProcInValue(procIndex2, "visitno", 					vo.getStrVisitNo(), 26);
							dao.setProcOutValue(procIndex2, "err", 						1, 27);
							dao.execute(procIndex2, 1);		
							*/					
							
						 }	
					
				}	
						
					dao.fire();
					
					
					
					debugPoint = 21;
					
					
					System.out.println(" ------- IssueTransODAO .insertipd  ---- END ---- ");	
		  
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgType("1");
			System.out.println("Error_Msg--DAO--"+e.getMessage());
			vo.setStrMsgString(e.getMessage());
			
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
	
	public static synchronized void REPEAT_ISSUE_INSERT(IssueTransOVO vo) 
	{
		HisDAO         dao = null;		
		String strFuncName = "";
		int     nFuncIndex = 0;
		int         length = 0;
		String  paramVal[] = null;
		String userValue[] = null;
		String  strIssueNo = "";
		String strVisitDtl = "";
		Double     netCost = 0.00;
		DmlHsttPatEmpIssueItemDtlDAO dmlhsttpatempissueitemdtl = null;
		DmlHsttPatEmpIssueDtlDAO         dmlhsttpatempissuedtl = null;
		
		int debugPoint = 0;
		String itemValue = "";
	
		String strIssueUnitId = "0";
		String strBillTariff = "";
		String strBillBatch = "";
		String strBillRate = "";
		String strBillQty = "";
		
		//MmsConfigUtil mcu;

		try 
		{
			
			System.out.println(" ------- IssueTransODAO .REPEAT_ISSUE_INSERT  ---- START ---- ");
			System.out.println(" ------- bill_interface.dml_online_billreq_drugs  --[ Mode- 1 ]------ ");
			
			debugPoint = 1;
			//mcu =new MmsConfigUtil(vo.getStrHospitalCode());
			dao = new HisDAO("MMS Transactions","IssueTransODAO");
			dmlhsttpatempissueitemdtl = new DmlHsttPatEmpIssueItemDtlDAO();
			    dmlhsttpatempissuedtl = new DmlHsttPatEmpIssueDtlDAO();			
			    
			System.out.println(" ---- MMS_MST.generate_issueNo  --- ");    
			
			System.out.println(" ---- HOSP_CODE --- "+vo.getStrHospitalCode());  
			System.out.println(" ---- STORE_CODE --- "+vo.getStrStoreId());
			System.out.println(" ---- CATG_CODE --- "+vo.getStrItemCat());
			System.out.println(" ------------------------------------- ");
			
			              strFuncName = "{? = call MMS_MST.generate_issueNo(?::numeric,?::numeric,?::numeric,?::numeric)}";
			               nFuncIndex = dao.setFunction(strFuncName);
			               
			dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId());
			dao.setFuncInValue(nFuncIndex, 4, "32");
			dao.setFuncInValue(nFuncIndex, 5, vo.getStrItemCat());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strIssueNo = dao.getFuncString(nFuncIndex);
			vo.setStrIssueNumber(strIssueNo.split("\\^")[0]);
			
			System.out.println(" Issue No ---- "+vo.getStrIssueNumber());
			
			debugPoint = 2;
			
			
		
			          strVisitDtl = "0"	;	
			String strEpisodeCode = "0";
			String     strVisitNo = "0" ;
			
			                  dao = new HisDAO("MMS Transactions","IssueTransODAO");
			               length = vo.getItemParamValue().length;	
			               
			               debugPoint = 12;
			               
			               System.out.println("-getStrAdmissionDtlHidVal-----" + vo.getStrAdmissionDtlHidVal());
			               
			   			
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
							dmlhsttpatempissuedtl.setStrAdmNo(vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[0]);
							
							debugPoint = 14;
							
							dmlhsttpatempissuedtl.setStrEmpNo(vo.getStrReqEmpNo());
							dmlhsttpatempissuedtl.setStrItemCatNo(vo.getStrItemCat());
							dmlhsttpatempissuedtl.setStrFinalCost(DmlHsttPatEmpIssueItemDtlDAO.getIntCost()+"");
							dmlhsttpatempissuedtl.setStrFinStartDate(vo.getStrFinStartDate());
							dmlhsttpatempissuedtl.setStrFinEndDate(vo.getStrFinEndDate());
							
							debugPoint = 15;
							
							dmlhsttpatempissuedtl.setStrSeatId(vo.getStrSeatId());
							dmlhsttpatempissuedtl.setStrDeptUnitCode(vo.getStrUnitCode());
							dmlhsttpatempissuedtl.setStrVisitType("2");// hardcoded in case of ipd patient
							dmlhsttpatempissuedtl.setStrDeptCode(vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[5]);
							
							dmlhsttpatempissuedtl.setStrWardCode(vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[6]);
							
							debugPoint = 16;
							
							dmlhsttpatempissuedtl.setStrReceiveBy(vo.getStrReceiveBy());
							dmlhsttpatempissuedtl.setStrRemarks(vo.getStrRemarks());
							dmlhsttpatempissuedtl.setStrReqDate("");
							dmlhsttpatempissuedtl.setStrVisitNo(strVisitNo);
							dmlhsttpatempissuedtl.setStrEpisoCode(strEpisodeCode);
							
							/*
				       		0	   NVL(HIPNUM_ADMNO, '0') 
				       		1	^  NVL(HRGNUM_EPISODE_CODE, '0') 
				       	    2	^  NVL(HRGNUM_VISIT_NO,'0') 
				       		3	^  NVL(TO_CHAR(HIPDT_ADMDATETIME,'DD-Mon-YYYY HH24:MI:SS'),' ')
				       		4	^  NVL(HIPNUM_ADM_ADVNO,'0') 
				       		5	^  NVL(GNUM_DEPT_CODE,'000')
				       		6	^  NVL(HIPNUM_WARD_CODE,'0') 
				       		7	^  NVL(HIPNUM_ROOM_CODE,'0') 
				       		8	^  NVL(HIPNUM_BED_CODE,'0')
				       		9	^  NVL(HIPNUM_TREAT_CATEG_CODE,'0')  
				       	   10	^  NVL(HIPNUM_ISNEWBORN,'0') 
				       	   11	^  NVL(HIPNUM_MOTHADMNO,'0') 
				       	   12	^  NVL(HRGNUM_MLC_NO,'0')
				       	   13	^  NVL(HIPNUM_OCCUP_ID,'0') 
				       	   14	^  NVL(TO_CHAR(HIPDT_BEDALLOC_DATETIME,'DD-Mon-YYYY HH24:MI:SS'),' ') 
				       	   15	^  NVL(HIPNUM_LENGTHOFSTAY,'0'))
				       	   16	^  NVL(GNUM_DEPTUNIT_CODE,'00000')
				       	   17	^  hblnum_pataccount_status
		       		*/		
							
							debugPoint = 17;
							
							// By Vivek		
		                    // vo.getStrPatientHiddenValue1	    Patient Name ^Father Name^Category Code^Address^Mlc No						
							/* vo.getStrPatientDtlHidVal()
				              HRGDT_DOB || ''^'' ||GNUM_GENDER_CODE ||''^''||HGNUM_PAT_STATUS_CODE || ''^''||
					          HGNUM_PATIENT_CAT_CODE || ''^'' ||HRGNUM_IS_MLC    ||''^''||HRGNUM_ISNEWBORN      || ''^''|| HRGNUM_ID_NO
							*/
							// By Vivek	
							
							itemValue += " PatientHiddenValue1 :: " + vo.getStrPatientHiddenValue1() + " StrPatientDtlHidVal :: " + vo.getStrPatientDtlHidVal();

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
							dmlhsttpatempissuedtl.setStrTransType("1");  // With CR No	
							dmlhsttpatempissuedtl.setStrDrugIssueDate(vo.getStrDrugIssueDate());
							dmlhsttpatempissuedtl.setStrOutOfStockFlag(vo.getStrOutOfStockFlag());
							
							debugPoint = 20;
							
						
							dmlhsttpatempissuedtl.insert(dao);  // Pkg_Mms_Dml2.Dml_Patemp_Issue_Dtls  --[ Mode- 1 ]
							
			               
			for(int k=0;k<length;k++)
			{				
				/**
				 * Hidden Values corresponding to particular
				 * ITEM DETAILS
				 */	
				debugPoint = 3;
						if(vo.getStrQtyText()[k] != null && vo.getStrQtyText()[k].length() > 0 && !vo.getStrQtyText()[k].equals("0"))
						{	
							              		

											userValue = vo.getItemParamValue()[k].replace('^', '#').split("#");	
											/*
										      HSTNUM_ITEM_ID ||'^'|| HSTNUM_ITEMBRAND_ID||'^'||HSTNUM_GROUP_ID||'^'||HSTNUM_SUBGROUP_ID||'^'||sstnum_item_cat_no
									         */
											
											debugPoint = 4;
											
											if(strBillTariff != null && strBillTariff != "")
												strBillTariff=strBillTariff + "^"+userValue[1];
												else
													strBillTariff = userValue[1];
											
												if(strBillRate != null && strBillRate != "")
												{	
													if(vo.getStrHospitalCode().equals("98926"))
													{
														strBillRate=strBillRate + "^0";
													}
													else
													{	
													    strBillRate=strBillRate + "^"+vo.getStrSalePrice()[k];
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
														strBillRate = vo.getStrSalePrice()[k];
													}
												}
												
												
												if(strBillQty != null && strBillQty != "")
													strBillQty=strBillQty + "^"+vo.getStrQtyText()[k];
													else
														strBillQty = vo.getStrQtyText()[k];
												if(strBillBatch != null && strBillBatch != "")
													strBillBatch=strBillBatch + "^"+vo.getStrBatch()[k];
													else
														strBillBatch = vo.getStrBatch()[k];
												
												
												System.out.println("---------------------------");					
												System.out.println("strBillTariff-----"+strBillTariff);	
												System.out.println("strBillRate-------"+strBillRate);
												System.out.println("strBillQty--------"+strBillQty);
												System.out.println("strBillBatch------"+strBillBatch);
												System.out.println("---------------------------");	
											
							String strInventoryUnitId = "6301";
							
							dmlhsttpatempissueitemdtl.setStrStoreId(vo.getStrStoreId());
							dmlhsttpatempissueitemdtl.setStrIssueNo(vo.getStrIssueNumber());
							dmlhsttpatempissueitemdtl.setStrItemId(userValue[0]);
							dmlhsttpatempissueitemdtl.setStrItemBrandId(userValue[1]);
							dmlhsttpatempissueitemdtl.setStrBatchSlNo(vo.getStrBatch()[k]);
							dmlhsttpatempissueitemdtl.setStrHospitalCode(vo.getStrHospitalCode());
							
							debugPoint = 5;
							
							dmlhsttpatempissueitemdtl.setStrItemSlNo("0");
							dmlhsttpatempissueitemdtl.setStrStockStatusCode("10");
							dmlhsttpatempissueitemdtl.setStrGroupId("0");
							dmlhsttpatempissueitemdtl.setStrSubGroupId("0");
							dmlhsttpatempissueitemdtl.setStrRate(vo.getStrSalePrice()[k]);
							dmlhsttpatempissueitemdtl.setStrRateUnitId("6301");
							
							debugPoint = 6;
							
							dmlhsttpatempissueitemdtl.setStrBalQty("0");
							dmlhsttpatempissueitemdtl.setStrBalQtyUnitId("");
							dmlhsttpatempissueitemdtl.setStrIssueQty(vo.getStrQtyText()[k]);
							dmlhsttpatempissueitemdtl.setStrIssueQtyUnitId(strInventoryUnitId); //Aritra,22nd June							
							dmlhsttpatempissueitemdtl.setStrExpiryDate("31-"+vo.getStrExpDate()[k]);
							dmlhsttpatempissueitemdtl.setStrRemarks(vo.getStrRemarks());
							
							debugPoint = 7;
							
							dmlhsttpatempissueitemdtl.setStrCost("0");
							dmlhsttpatempissueitemdtl.setStrInHandQty(vo.getStrAvlQty()[k]);
							dmlhsttpatempissueitemdtl.setStrInHandQtyUnitId("6301");
							dmlhsttpatempissueitemdtl.setStrManufDate("");
							dmlhsttpatempissueitemdtl.setStrReqNo(vo.getStrRequestNo());
							dmlhsttpatempissueitemdtl.setStrCrNo(vo.getStrPuk());
							
							debugPoint = 8;
							
							dmlhsttpatempissueitemdtl.setStrEmpNo(vo.getStrReqEmpNo());
							dmlhsttpatempissueitemdtl.setStrVisitNo(strVisitNo);
							dmlhsttpatempissueitemdtl.setStrEpisodeCode(strEpisodeCode);
							dmlhsttpatempissueitemdtl.setStrAdmNo(vo.getStrReqAdmNo());
							dmlhsttpatempissueitemdtl.setStrOrderBy(vo.getStrReqPrescribedBy());//Id od the consultant
							
							debugPoint = 9;
							
							dmlhsttpatempissueitemdtl.setStrDays(vo.getStrReqPrescribedFor());
							dmlhsttpatempissueitemdtl.setStrReqTypeId("32");
							dmlhsttpatempissueitemdtl.setStrItemCatNo(vo.getStrItemCat());
							
							debugPoint = 10;
							
							dmlhsttpatempissueitemdtl.setStrDosage("0");
							dmlhsttpatempissueitemdtl.setStrFrequency("0");
							dmlhsttpatempissueitemdtl.setStrPresDays("0");
							
							dmlhsttpatempissueitemdtl.setStrPatientName(vo.getStrPatientDtlHidVal().split("\\^")[7]);//    									
							dmlhsttpatempissueitemdtl.setStrSeatId(vo.getStrSeatId());
							dmlhsttpatempissueitemdtl.setStrDrugIssueDate(vo.getStrDrugIssueDate());
							
							debugPoint = 11;
							
							
							dmlhsttpatempissueitemdtl.insert2(dao);  // Pkg_Mms_Dml2.Dml_Patemp_Issue_Items_Dtls  --[ Mode- 1 ]
							 
							/*
				       		0	   NVL(HIPNUM_ADMNO, '0') 
				       		1	^  NVL(HRGNUM_EPISODE_CODE, '0') 
				       	    2	^  NVL(HRGNUM_VISIT_NO,'0') 
				       		3	^  NVL(TO_CHAR(HIPDT_ADMDATETIME,'DD-Mon-YYYY HH24:MI:SS'),' ')
				       		4	^  NVL(HIPNUM_ADM_ADVNO,'0') 
				       		5	^  NVL(GNUM_DEPT_CODE,'000')
				       		6	^  NVL(HIPNUM_WARD_CODE,'0') 
				       		7	^  NVL(HIPNUM_ROOM_CODE,'0') 
				       		8	^  NVL(HIPNUM_BED_CODE,'0')
				       		9	^  NVL(HIPNUM_TREAT_CATEG_CODE,'0')  
				       	   10	^  NVL(HIPNUM_ISNEWBORN,'0') 
				       	   11	^  NVL(HIPNUM_MOTHADMNO,'0') 
				       	   12	^  NVL(HRGNUM_MLC_NO,'0')
				       	   13	^  NVL(HIPNUM_OCCUP_ID,'0') 
				       	   14	^  NVL(TO_CHAR(HIPDT_BEDALLOC_DATETIME,'DD-Mon-YYYY HH24:MI:SS'),' ') 
				       	   15	^  NVL(HIPNUM_LENGTHOFSTAY,'0'))
				       	   16	^  NVL(GNUM_DEPTUNIT_CODE,'00000')
				       	   17	^  hblnum_pataccount_status
		       		*/		
													
							int procIndex2;				
							String proc_name2 = "{call bill_interface.dml_online_billreq_drugs(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}";
							procIndex2 = dao.setProcedure(proc_name2);
							dao.setProcInValue(procIndex2, "modval", 					"1", 1); // 1
							dao.setProcInValue(procIndex2, "gnum_dept_code", 			vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[5], 2);
							dao.setProcInValue(procIndex2, "sblnum_chargetype_id", 		"2", 3);
							dao.setProcInValue(procIndex2, "sblnum_service_id", 		"5", 4);
							dao.setProcInValue(procIndex2, "gstr_req_no", 				vo.getStrIssueNumber(), 5);
							dao.setProcInValue(procIndex2, "gnum_treatment_cat", 		vo.getStrPatientDtlHidVal().replace("^","#").split("#")[3],6);
							dao.setProcInValue(procIndex2, "hrgnum_episode_code", 		vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[1], 7);
							dao.setProcInValue(procIndex2, "hrgnum_puk", 				vo.getStrPatientId(), 8);
							dao.setProcInValue(procIndex2, "hblnum_pat_lfaccount_no", 	"0", 9);
							dao.setProcInValue(procIndex2, "gstr_tariff", 				userValue[1], 10);
							dao.setProcInValue(procIndex2, "gstr_tariff_batch", 		vo.getStrBatch()[k], 11);
							if(vo.getStrHospitalCode().equals("98926"))
							{
							   dao.setProcInValue(procIndex2, "gstr_tariff_rates", 		"0", 12);
							}
							else
							{
							   dao.setProcInValue(procIndex2, "gstr_tariff_rates", 		vo.getStrSalePrice()[k], 12);
							}
							dao.setProcInValue(procIndex2, "gstr_reqqty", 				vo.getStrQtyText()[k], 13);
							dao.setProcInValue(procIndex2, "hblstr_patient_name", 		"", 14);
							dao.setProcInValue(procIndex2, "hblstr_pat_address", 		"", 15);
							dao.setProcInValue(procIndex2, "hblstr_contact_no", 		"", 16);
							dao.setProcInValue(procIndex2, "age", 						vo.getStrPatientDtlHidVal().replace("^","#").split("#")[10].split(" ")[0], 17);
							dao.setProcInValue(procIndex2, "ageunit",					vo.getStrPatientDtlHidVal().replace("^","#").split("#")[10].split(" ")[1].split("/")[0], 18);
							dao.setProcInValue(procIndex2, "gender", 					vo.getStrPatientDtlHidVal().replace("^","#").split("#")[1], 19);
							dao.setProcInValue(procIndex2, "refdoctor", 				"N/A", 20);
							dao.setProcInValue(procIndex2, "refdoccontactno", 			"0000000000", 21);
							dao.setProcInValue(procIndex2, "gnum_seatid", 				vo.getStrSeatId(), 22);
							dao.setProcInValue(procIndex2, "hosp_code", 				vo.getStrHospitalCode(), 23);
							dao.setProcInValue(procIndex2, "ward_code", 				vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[6], 24);
							dao.setProcInValue(procIndex2, "admno", 					vo.getStrAdmissionDtlHidVal().replace("^", "#").split("#")[0], 25);
							dao.setProcInValue(procIndex2, "visitno", 					vo.getStrVisitNo(), 26);
							dao.setProcOutValue(procIndex2, "err", 						1, 27);
							dao.execute(procIndex2, 1);							
							
						 }	
					
				}	
						
				dao.fire();
					
					
					
					debugPoint = 21;
					
					
					System.out.println(" ------- IssueTransODAO .insertipd  ---- END ---- ");	
		  
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgType("1");
			vo.setStrMsgString("IssueTransODAO.insert() --> "
					+ e.getMessage() + " DAO_DEBUG_POINT :: " + debugPoint + " DAO_VALUE :: " + itemValue);
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
	
	public static synchronized void inserttemp(IssueTransOVO vo) 
	{
		HisDAO         dao = null;		
		String strFuncName = "";
		int     nFuncIndex = 0;
		int         length = 0;
		String  paramVal[] = null;
		String userValue[] = null;
		String  strIssueNo = "";
		String strVisitDtl = "";
		Double     netCost = 0.00;
		DmlHsttPatEmpIssueItemDtlDAO dmlhsttpatempissueitemdtl = null;
		DmlHsttPatEmpIssueDtlDAO         dmlhsttpatempissuedtl = null;
		String visitType="1";
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
		//MmsConfigUtil mcu;

		try 
		{
			System.out.println(" ------- IssueTransODAO.inserttemp --- START --- ");
			
			debugPoint = 1;
			//mcu =new MmsConfigUtil(vo.getStrHospitalCode());
			dao = new HisDAO("MMS Transactions","IssueTransODAO");
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
			
			
		
			          strVisitDtl = "0"	;	
			String strEpisodeCode = "0";
			String     strVisitNo = "0" ;
			
			                  dao = new HisDAO("MMS Transactions","IssueTransODAO");
			               length = vo.getItemParamValue().length;	
			               
			for(int k=0;k<length;k++)
			{				
				/**
				 * Hidden Values corresponding to particular
				 * ITEM DETAILS
				 */	
				debugPoint = 3;
						if(vo.getStrQtyText()[k] != null && vo.getStrQtyText()[k].length() > 0 && !vo.getStrQtyText()[k].equals("0"))
						{	
							itemValue = vo.getItemParamValue()[k];
							
											 paramVal = vo.getItemParamValue()[k].split("#");						
											userValue = paramVal[2].replace('^', '#').split("#");	
											
											debugPoint = 4;
											
											if(strBillTariff != null && strBillTariff != "")
												strBillTariff=strBillTariff + "^"+userValue[1];
												else
													strBillTariff = userValue[1];
												if(strBillRate != null && strBillRate != "")
												{	
													if(vo.getStrHospitalCode().equals("98926"))
													{
													   strBillRate=strBillRate + "^0";
													}
													else
													{
													   strBillRate=strBillRate + "^"+userValue[9];
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
												if(strBillQty != null && strBillQty != "")
													strBillQty=strBillQty + "^"+vo.getStrQtyText()[k];
													else
														strBillQty = vo.getStrQtyText()[k];
												if(strBillBatch != null && strBillBatch != "")
													strBillBatch=strBillBatch + "^"+userValue[15];
													else
														strBillBatch = userValue[15];
												
												System.out.println("----------------------");					
												System.out.println("strBillTariff-----"+strBillTariff);	
												System.out.println("strBillRate-------"+strBillRate);
												System.out.println("strBillQty--------"+strBillQty);
												System.out.println("strBillBatch------"+strBillBatch);
												System.out.println("----------------------");	
											
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
							dmlhsttpatempissueitemdtl.setStrIssueQtyUnitId(strInventoryUnitId); //Aritra,22nd June							
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
							dmlhsttpatempissueitemdtl.setStrEpisodeCode(vo.getStrEpisodeCode());
							dmlhsttpatempissueitemdtl.setStrAdmNo(vo.getStrReqAdmNo());
							dmlhsttpatempissueitemdtl.setStrOrderBy(vo.getStrReqPrescribedBy());//Id od the consultant
							
							debugPoint = 9;
							
							dmlhsttpatempissueitemdtl.setStrDays(vo.getStrReqPrescribedFor());
							dmlhsttpatempissueitemdtl.setStrReqTypeId("32");
							dmlhsttpatempissueitemdtl.setStrItemCatNo(vo.getStrItemCat());
							
							debugPoint = 10;
							
							dmlhsttpatempissueitemdtl.setStrDosage("0");
							dmlhsttpatempissueitemdtl.setStrFrequency("0");
							dmlhsttpatempissueitemdtl.setStrPresDays("0");
							
							dmlhsttpatempissueitemdtl.setStrPatientName(vo.getStrPatientDtlHidVal().split("\\^")[7]);//    									
							dmlhsttpatempissueitemdtl.setStrSeatId(vo.getStrSeatId());
							dmlhsttpatempissueitemdtl.setStrDrugIssueDate(vo.getStrDrugIssueDate());
							
							debugPoint = 11;
							
							
							dmlhsttpatempissueitemdtl.insert2temp(dao);
							
						 }	
					
				}	
			
			if(vo.getStrVisitType().equals("2") || vo.getStrVisitType().equals("3"))
				visitType = "3";
			else if(vo.getStrVisitType().equals("4"))
				visitType="4";
			
			if(vo.getStrLFAccountNo() != null && vo.getStrLFAccountNo() !="")
			{
				/*
				 * if(mcu.getStrBillingIntegration().equals("1")) { int procIndex2; procIndex2 =
				 * dao.setProcedure(proc_name2);
				 * 
				 * 
				 * 
				 * 
				 * dao.setProcInValue(procIndex2, "modval", "2", 1); // 1
				 * dao.setProcInValue(procIndex2, "gnum_dept_code", vo.getStrDeptCode(), 2);
				 * dao.setProcInValue(procIndex2, "sblnum_chargetype_id", visitType, 3);
				 * dao.setProcInValue(procIndex2, "sblnum_service_id", "5", 4);
				 * dao.setProcInValue(procIndex2, "gstr_req_no", vo.getStrIssueNumber(), 5);
				 * dao.setProcInValue(procIndex2, "gnum_treatment_cat",
				 * vo.getStrCatgoryCode(),6); dao.setProcInValue(procIndex2,
				 * "hrgnum_episode_code",vo.getStrEpisodeCode(), 7);
				 * dao.setProcInValue(procIndex2, "hrgnum_puk", vo.getStrCrNo(), 8);
				 * dao.setProcInValue(procIndex2, "hblnum_pat_lfaccount_no",
				 * vo.getStrLFAccountNo(), 9); dao.setProcInValue(procIndex2, "gstr_tariff",
				 * strBillTariff, 10); dao.setProcInValue(procIndex2, "gstr_tariff_batch",
				 * strBillBatch, 11); dao.setProcInValue(procIndex2, "gstr_tariff_rates",
				 * strBillRate, 12); dao.setProcInValue(procIndex2, "gstr_reqqty", strBillQty,
				 * 13); dao.setProcInValue(procIndex2, "hblstr_patient_name", "", 14);
				 * dao.setProcInValue(procIndex2, "hblstr_pat_address", "", 15);
				 * dao.setProcInValue(procIndex2, "hblstr_contact_no", "", 16);
				 * dao.setProcInValue(procIndex2, "age", "1", 17);
				 * dao.setProcInValue(procIndex2, "ageunit", "1", 18);
				 * dao.setProcInValue(procIndex2, "gender", "1", 19);
				 * dao.setProcInValue(procIndex2, "refdoctor", "1", 20);
				 * dao.setProcInValue(procIndex2, "refdoccontactno", "1", 21);
				 * dao.setProcInValue(procIndex2, "gnum_seatid", vo.getStrSeatId(), 22);
				 * dao.setProcInValue(procIndex2, "hosp_code", vo.getStrHospitalCode(), 23);
				 * dao.setProcInValue(procIndex2, "ward_code", vo.getStrWardCode(), 24);
				 * dao.setProcInValue(procIndex2, "admno","0", 25);
				 * dao.setProcInValue(procIndex2, "visitno", vo.getStrVisitNo(), 26);
				 * dao.setProcOutValue(procIndex2, "err", 1, 27); dao.execute(procIndex2, 1);
				 * 
				 * }
				 */
		}	
			
		else
		{
			
				int procIndex2;
				procIndex2 = dao.setProcedure(proc_name2);
				
				
				
				
				
				dao.setProcInValue(procIndex2, "modval", "1", 1); // 1
				dao.setProcInValue(procIndex2, "gnum_dept_code", vo.getStrDeptCode(), 2);
				dao.setProcInValue(procIndex2, "sblnum_chargetype_id", visitType, 3);
				dao.setProcInValue(procIndex2, "sblnum_service_id", "5", 4);
				dao.setProcInValue(procIndex2, "gstr_req_no", vo.getStrIssueNumber(), 5);
				dao.setProcInValue(procIndex2, "gnum_treatment_cat", vo.getStrCatgoryCode(),6);
				dao.setProcInValue(procIndex2, "hrgnum_episode_code",vo.getStrEpisodeCode(), 7);
				dao.setProcInValue(procIndex2, "hrgnum_puk", vo.getStrPuk(), 8);
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
				dao.setProcInValue(procIndex2, "admno","0", 25);
				dao.setProcInValue(procIndex2, "visitno", vo.getStrVisitNo(), 26);
				dao.setProcOutValue(procIndex2, "err", 1, 27);
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
					dmlhsttpatempissuedtl.setStrReqTypeId("32");
					dmlhsttpatempissuedtl.setStrAdmNo(vo.getStrReqAdmNo());
					
					debugPoint = 14;
					
					dmlhsttpatempissuedtl.setStrEmpNo(vo.getStrReqEmpNo());
					dmlhsttpatempissuedtl.setStrItemCatNo(vo.getStrItemCat());
					dmlhsttpatempissuedtl.setStrFinalCost(DmlHsttPatEmpIssueItemDtlDAO.getIntCost()+"");
					dmlhsttpatempissuedtl.setStrFinStartDate(vo.getStrFinStartDate());
					dmlhsttpatempissuedtl.setStrFinEndDate(vo.getStrFinEndDate());
					
					debugPoint = 15;
					
					dmlhsttpatempissuedtl.setStrSeatId(vo.getStrSeatId());
					dmlhsttpatempissuedtl.setStrDeptUnitCode(vo.getStrUnitCode());
					dmlhsttpatempissuedtl.setStrVisitType(vo.getStrVisitType());
					dmlhsttpatempissuedtl.setStrDeptCode(vo.getStrDeptCode());
					
					dmlhsttpatempissuedtl.setStrWardCode(vo.getStrReqWardCode());
					
					debugPoint = 16;
					if(vo.getStrEmpCode().equals("")||vo.getStrEmpCode() == null)
						vo.setStrEmpCode("0");
					if(vo.getStrDiagCode().equals("")||vo.getStrDiagCode() == null)
						vo.setStrDiagCode("0");
					dmlhsttpatempissuedtl.setStrReceiveBy(vo.getStrReceiveBy());
					dmlhsttpatempissuedtl.setStrRemarks(vo.getStrRemarks());
					dmlhsttpatempissuedtl.setStrReqDate("");
					dmlhsttpatempissuedtl.setStrVisitNo(strVisitNo);
					dmlhsttpatempissuedtl.setStrEpisoCode(strEpisodeCode);
					dmlhsttpatempissuedtl.setStrEmpCode(vo.getStrEmpCode());
					dmlhsttpatempissuedtl.setStrIcdCode(vo.getStrDiagCode());
					
					debugPoint = 17;
					
					// By Vivek		
                    // vo.getStrPatientHiddenValue1	    Patient Name ^Father Name^Category Code^Address^Mlc No						
					/* vo.getStrPatientDtlHidVal()
		              HRGDT_DOB || ''^'' ||GNUM_GENDER_CODE ||''^''||HGNUM_PAT_STATUS_CODE || ''^''||
			          HGNUM_PATIENT_CAT_CODE || ''^'' ||HRGNUM_IS_MLC    ||''^''||HRGNUM_ISNEWBORN      || ''^''|| HRGNUM_ID_NO
					*/
					// By Vivek	
					
					itemValue += " PatientHiddenValue1 :: " + vo.getStrPatientHiddenValue1() + " StrPatientDtlHidVal :: " + vo.getStrPatientDtlHidVal();

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
					dmlhsttpatempissuedtl.setStrTransType("1");  // With CR No	
					dmlhsttpatempissuedtl.setStrDrugIssueDate(vo.getStrDrugIssueDate());
					dmlhsttpatempissuedtl.setStrOutOfStockFlag(vo.getStrOutOfStockFlag());
					
					debugPoint = 20;
					
				
					dmlhsttpatempissuedtl.inserttemp(dao);
		}
					
					
					// DAO Fire
					synchronized (dao) {
						dao.fire();
					}
					
					
					debugPoint = 21;
					
					System.out.println(" ------- IssueTransODAO.inserttemp --- END --- ");
		  
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgType("1");
			vo.setStrMsgString("IssueTransODAO.insert() --> "
					+ e.getMessage() + " DAO_DEBUG_POINT :: " + debugPoint + " DAO_VALUE :: " + itemValue);
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
	
	//Change Request
	/**
	 *  
	 * @param vo
	 */
	public static synchronized void insertWithoutCrNo(IssueTransOVO vo)
	{
	
		HisDAO           dao  = null;
		String    strFuncName = "";
		int        nFuncIndex = 0;
		int       nFuncIndex2 = 0;
		String     strIssueNo = "",strCrNum="0";
		String     strVisitNo = "0";
		Double        netCost = 0.00;
		String strPatientName = "";
		String strFuncName2   = "";
		StringBuffer sb       = new StringBuffer("");
		ResourceBundle   res  = null;	
		String strTableWidth  = "825";
		int                 j = 1;
		int debug_point = 0;
		
		DmlHsttPatEmpIssueItemDtlWithoutCrNoDAO dmlhsttpatempissueitemdtlWithoutCrNo = null;
		DmlHsttPatEmpIssueDtlWithoutCrNoDAO      dmlHsttPatEmpIssueDtlWithoutCrNoDAO = null;

		try 
		{
			
			System.out.println(" ------- IssueTransODAO.insertWithoutCrNo --- START --- ");
			
			debug_point = 1;
			vo.setStrReqTypeId("32");
			
            dao = new HisDAO("MMS Transactions","IssueTransODAO");
            res = mms.qryHandler_mms.res;
			if(res == null) 
			{
				res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
				mms.qryHandler_mms.res = res;
			}
            
			dmlhsttpatempissueitemdtlWithoutCrNo = new DmlHsttPatEmpIssueItemDtlWithoutCrNoDAO();
			dmlHsttPatEmpIssueDtlWithoutCrNoDAO  = new DmlHsttPatEmpIssueDtlWithoutCrNoDAO();			
			
			debug_point = 2;
			strFuncName2 = "{? = call MMS_MST.generate_new_CRNo(?,?)}";
			nFuncIndex2 = dao.setFunction(strFuncName2);
			dao.setFuncInValue(nFuncIndex2, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex2, 3, vo.getStrStoreId());
			dao.setFuncOutValue(nFuncIndex2, 1);
			dao.executeFunction(nFuncIndex2);
			strCrNum = dao.getFuncString(nFuncIndex2);
			vo.setStrCrNum(strCrNum);
			
			debug_point = 3;
			
		     strFuncName = "{? = call MMS_MST.generate_issueNo(?,?,?,?)}";
			 nFuncIndex = dao.setFunction(strFuncName);
			
			dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrReqTypeId());
			dao.setFuncInValue(nFuncIndex, 5, vo.getStrItemCat());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strIssueNo = dao.getFuncString(nFuncIndex);			
			vo.setStrIssueNumber(strIssueNo.split("\\^")[0]);			
			strPatientName = vo.getStrFirstName();	
			
			debug_point = 4;
			
			if(vo.getStrIssueMode().equals("0") || vo.getStrIssueMode().equals("1") ||vo.getStrIssueMode().equals("2"))
			{
				sb.append("<table align='center' width='").append(strTableWidth + "' border='0' cellspacing='0' cellpadding='0' height='69'> ");
				sb.append("<tr>");
				sb.append("<td width='10%'></td>");			
				sb.append("<td width='80%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
				sb.append(res.getString("PAT_ISSUE_TITLE1"));
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb.append("</tr> ");
				sb.append("<tr>");
				sb.append("<td width='10%'></td>");					
				sb.append("<td width='90%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
				sb.append(res.getString("PAT_ISSUE_TITLE2"));
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb.append("</tr> ");		
				sb.append("<tr>");
				sb.append("<td width='10%'></td>");					
				sb.append("<td width='90%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
				sb.append(vo.getStrHospitalName());
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb.append("</tr> ");
				sb.append("</table>"); 	
				
				debug_point = 5;
				
				sb.append("<table border='0' width='" + strTableWidth + "' align='center'> ");
				sb.append("<tr> ");
				sb.append("<td align='right'>");
	 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
				sb.append("<img style='cursor: pointer; '  name='PrintPage' tabindex='1' title='Print Page'");
				sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne(1);' onkeypress='initPrint(event);'/> <img style='cursor: pointer; ' title='Cancel Process'  ");
				sb.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopupOne();' /></div>");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append(" </table> ");
				sb.append(" <br> ");
				
				debug_point = 6;
				
				sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");	
				/*************************************************1*******************************************************************/
				sb.append("<tr> ");	
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Patient:</b></font></td> ");
//				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(formBean.getStrIssueNo())
//							.append("</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >"+vo.getStrFirstName()+"</font></td> ");		
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("DDC:</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(vo.getStrStoreName()).append(
							"</font></td> ");
				sb.append("</tr> ");
				/**************************************************2*****************************************************************/
				
				debug_point = 7;
				
				sb.append("<tr> ");	
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Doctor:</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' > Dr. ").append(vo.getStrReqPrescribedBy())
							.append("</font></td> ");		
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Issue No:</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(vo.getStrIssueNumber()).append(
							"</font></td> ");
				sb.append("</tr> ");
				/**************************************************3******************************************************************/
				sb.append("<tr> ");	
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Reg.No:</b></font></td> ");
//				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(formBean.getStrIssueNo())
//							.append("</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >"+vo.getStrPatientId()+"</font></td> ");		
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Issue Date:</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(vo.getStrDrugIssueDate()).append(
							"</font></td> ");
				sb.append("</tr> ");
				/***************************************************4*****************************************************************/
				sb.append("<tr> ");			
				sb.append("<td width='25%' align='right'></td> ");
				sb.append("<td width='25%' ></td> ");
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("CR No:</b></font></td> ");
			     sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(strCrNum)
						.append("</font></td> ");
				sb.append("</tr> ");
				/***************************************************5*****************************************************************/
				sb.append("</table> ");
				
				debug_point = 8;
				
				sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
				sb.append("<tr>");
				sb.append("<td colspan='4' align='left'><hr size='2'></td>");
				sb.append("<td colspan='1' align='center'><hr size='2'></td>");					
				sb.append("</tr>");
				sb.append("<tr bgcolor='#cdc9c9'> ");
				sb.append("<td align='center' width='5%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
				sb.append("</td>");						
				sb.append("<td align='center' width='35%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font> ");
				sb.append("</td>");
				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font> ");
				sb.append("</td> ");
				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font>");
				sb.append("</td> ");
				sb.append("<td align='right' width='10%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty</b></font>");
				sb.append("</td> ");
				sb.append("</tr> ");
				sb.append("<tr>");
				sb.append("<td colspan='4' align='left'><hr size='2'></td>");
				sb.append("<td colspan='1' align='center'><hr size='2'></td>");					
				sb.append("</tr>");
				
				debug_point = 9;
				
				for (int i = 0; i < vo.getStrItemIdArray().length; i++) 
				{
					debug_point = 10;
					
					if(vo.getStrIssueQty()[i] != null && vo.getStrIssueQty()[i].length() > 0 && !vo.getStrIssueQty()[i].equals("0"))
					{
						    String strModfExp;				    	  
				    		String[] temp1 = vo.getStrExpiryDate()[i].replace("-", "#").split("#");
				    		strModfExp   = temp1[1]+"/"+temp1[2];
				    	    sb.append("<tr> ");
							sb.append("<td style=\'text-align:center;\'  width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
							sb.append(j+".");
							sb.append("</font></td> ");					
							sb.append("<td style=\'text-align:left;\'    width='35%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
							sb.append(vo.getStrItemNameArray()[i]);
							sb.append("</font></td> ");
							sb.append("<td style=\'text-align:center;\'  width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
							sb.append(vo.getStrBatchNo()[i]);
							sb.append("</font></td> ");
							sb.append("<td style=\'text-align:center;\'  width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
							sb.append(strModfExp);
							sb.append("</font></td> ");
							sb.append("<td style=\'text-align:right;\'   width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
							sb.append(vo.getStrIssueQty()[i]);
							sb.append("</font></td> ");
							sb.append("</tr> ");
							
							debug_point = 11;
						
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrStoreId(vo.getStrStoreId());
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrIssueNo(vo.getStrIssueNumber());
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrItemId(vo.getStrItemIdArray()[i]);
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrItemBrandId(vo.getStrBrandIdArray()[i]);
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrHospitalCode(vo.getStrHospitalCode());
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrGroupId(vo.getStrGroupIdArray()[i]);
							
							debug_point = 12;
							
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrSubGroupId(vo.getStrSubGroupIdArray()[i]);
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrStockStatusCode(vo.getStrStockStatusCode()[i]);
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrItemSlNo(vo.getStrItemSlNo()[i]);
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrItemSlNo(vo.getStrManufDate()[i]);
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrBalQty("0");
							
							debug_point = 13;
							
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrBalQtyUnitId("");
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrInHandQty(vo.getStrInhandQtyArray()[i]);
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrInHandQtyUnitId(vo.getStrInhandQtyUnitId()[i]);
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrBatchSlNo(vo.getStrBatchNo()[i]);							
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrManufDate(vo.getStrManufDate()[i]);
							
							debug_point = 14;
							
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrExpiryDate(vo.getStrExpiryDate()[i]);
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrRemarks(vo.getStrRemarks());
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrDescription(vo.getStrDescription());
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrReqNo(vo.getStrRequestNo());
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrItemCatNo(vo.getStrItemCat());
							
							debug_point = 15;
							
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrIssueQtyUnitId(vo.getStrInhandQtyUnitId()[i]);
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrCrNo(strCrNum);    // Generated CR No.
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrEmpNo(vo.getStrEmpNo());
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrVisitNo(vo.getStrVisitNo());
							
							debug_point = 16;
							
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrEpisodeCode(vo.getStrEpisCode());
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrAdmNo(vo.getStrAdmNo());							
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrOrderBy(vo.getStrReqPrescribedBy());
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrDays(vo.getStrReqPrescribedFor());
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrReqTypeId("32");
							
							debug_point = 17;
							
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrRate(vo.getStrRate()[i]);
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrRateUnitId(vo.getStrRateUnitId()[i]);
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrIssueQty(vo.getStrIssueQty()[i]);	
							
							debug_point = 18;
							
							/*
							if(vo.getStrDose()!=null && !vo.getStrDose()[i].equals(""))
							{
								dmlhsttpatempissueitemdtlWithoutCrNo.setStrDosage(vo.getStrDose()[i].replace('^', '#').split("#")[0]);
								dmlhsttpatempissueitemdtlWithoutCrNo.setStrFrequency(vo.getStrFrequency()[i].replace('^', '#').split("#")[0]);
								dmlhsttpatempissueitemdtlWithoutCrNo.setStrPresDays(vo.getStrDays()[i]);
							}
							else
							{
								dmlhsttpatempissueitemdtlWithoutCrNo.setStrDosage("0");
								dmlhsttpatempissueitemdtlWithoutCrNo.setStrFrequency("0");
								dmlhsttpatempissueitemdtlWithoutCrNo.setStrPresDays("0");
							}		
												
												*/
							
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrDosage("0");
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrFrequency("0");
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrPresDays("0");
							
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrSeatId(vo.getStrSeatId());
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrPatientName(strPatientName);
							dmlhsttpatempissueitemdtlWithoutCrNo.setStrDrugIssueDate(vo.getStrDrugIssueDate());
							
							debug_point = 19;
							
							dmlhsttpatempissueitemdtlWithoutCrNo.insert1(dao);    // Dml_Patemp_Issue_Items_Dtls  Mode 1
							debug_point = 20;
							
							
							j++;
					}	
										
				}
				// Total 36 Variable
								
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrStoreId(vo.getStrStoreId());
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrIssueNo(vo.getStrIssueNumber());
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrHospitalCode(vo.getStrHospitalCode());
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrRequestNo(vo.getStrRequestNo());
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrOrderBy("Dr. "+vo.getStrReqPrescribedBy());	
				
				debug_point = 21;
				
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrOrderDate(vo.getStrReqPrescriptionDate());  // Check It
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrDays(vo.getStrReqPrescribedFor());
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrCrNo(strCrNum);                        // Generated CR No
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrReqTypeId("32");
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrAdmNo(vo.getStrAdmNo());
				
				debug_point = 22;
				
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrEmpNo(vo.getStrEmpNo());
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrItemCatNo(vo.getStrItemCat());
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrCost(""+netCost);
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrFinStartDate(vo.getStrFinStartDate());
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrFinEndDate(vo.getStrFinEndDate());
				
				debug_point = 23;
				
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrSeatId(vo.getStrSeatId());
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrDeptUnitCode(vo.getStrReqUnitCode());
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrVisitNo(strVisitNo);
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrVisitType(vo.getStrReqPrescriptionFrom());
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrDeptCode(vo.getStrReqDeptCode());
				
				debug_point = 24;
				
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrWardCode("0");
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrReceiveBy(vo.getStrReceiveBy());
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrRemarks(vo.getStrRemarks());
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrReqDate(vo.getStrReqDate());
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrVisitNo(vo.getStrVisitNo());
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrEpisoCode(vo.getStrEpisCode());	
				
				debug_point = 25;
				// By Vivek			
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrPatientId(vo.getStrPatientId());				
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrPatientType(vo.getStrPatientType());
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrFirstName(vo.getStrFirstName());
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrMiddelName("");
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrLastName("");
				
				debug_point = 26;
				
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrPatientAge(vo.getStrPatientAge());
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrPatientAgeUnit(vo.getStrPatientAgeUnit());
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrPatientFatherName(vo.getStrPatientFatherName());
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrPatientGenderCode(vo.getStrPatientGenderCode());
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrPatientAddress(vo.getStrPatientAddress());
				
				debug_point = 27;
				
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrTransType("2"); //Without Cr No
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrOutOfStockFlag(vo.getStrOutOfStockFlag());
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.setStrDrugIssueDate(vo.getStrDrugIssueDate());
				debug_point = 28;
				
				// By Vivek end				
				dmlHsttPatEmpIssueDtlWithoutCrNoDAO.insert(dao);  // Dml_Patemp_Issue_Dtls  Mode =1
				debug_point = 29;
				//dmlHsttPatEmpIssueDtlWithoutCrNoDAO.update(dao);
				dao.fire();
				debug_point = 30;
				
				sb.append("<tr>");
				sb.append("<td colspan='4' align='left'><hr size='2'></td>");
				sb.append("<td colspan='1' align='center'><hr size='2'></td>");					
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td colspan='4' align='left'></td>");
				sb.append("<td colspan='1' align='center'></td>");					
				sb.append("</tr>");	
				sb.append("<tr>");
				sb.append("<td colspan='4' align='left'></td>");
				sb.append("<td colspan='1' align='center'></td>");					
				sb.append("</tr>");
				sb.append("</table> ");		
				
				debug_point = 31;
				/************************************************6********************************************************************/
				sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
				sb.append("<tr>");
				sb.append("<td width='10%'></td>");			
				sb.append("<td width='80%' align='center'><b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
				sb.append(strIssueNo.split("\\^")[1]);
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb.append("</tr> ");				
				sb.append("</table>"); 
				
				debug_point = 32;
				/************************************************7********************************************************************/

				
				vo.setStrVocherHLPString(sb.toString());
				
				System.out.println(" ------- IssueTransODAO.insertWithoutCrNo --- END --- ");
			}
		} 
		catch (Exception e) 
		{
		 	  e.printStackTrace();
			  vo.setStrMsgType("1");
			  vo.setStrMsgString(e.getMessage() + " :: DAO_DEBUG_POINT = " + debug_point);
			  vo.setStrVocherHLPString("");
		} 
		finally 
		{

			if (dao != null) {
				dao.free();
				dao = null;
			}
			
			sb = null;
			res = null;
		}
	}
	
	
	public static void getGenderCombo(IssueTransOVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_get_Gender_Combo(?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","IssueTransODAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "p_mode", "1",1);
			daoObj.setProcInValue(nProcIndex, "p_gnum_hospital_code", voObj.getStrHospitalCode(),2);
			daoObj.setProcOutValue(nProcIndex, "err", 1,3);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,4);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) 
			{

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrGenderWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("IssueTransODAO.getGenderCombo() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	public static void getLFAccountDetails(IssueTransOVO voObj)
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_HBLT_PAT_LF_ACCOUNT_DTL(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		//String strDeptCode = voObj.getStrOffLineRaisingDepartment();//Last Visited Department
		String strCrNo = voObj.getStrPuk();

		String strErr = "";

		try
		{
			System.out.println(" ------- IssueTransODAO .getLFAccountDetails  -------- ");
			System.out.println(" ------- pkg_bill_view.proc_HBLT_PAT_LF_ACCOUNT_DTL  --[ Mode- 1 ]------ "); 
			
			daoObj = new HisDAO("Billing", "LFNoTransDAO.getEpisodeList");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
			//daoObj.setProcInValue(nProcIndex, "deptCode", strDeptCode, 2);
			if(strCrNo!=null && strCrNo!="")
			{daoObj.setProcInValue(nProcIndex, "puk", strCrNo, 2);	
			}
			else
			{
				daoObj.setProcInValue(nProcIndex, "puk", "0", 2);
			}
			
			if(voObj.getStrLFNo()!=null && voObj.getStrLFNo()!="")
			daoObj.setProcInValue(nProcIndex, "accno",voObj.getStrLFNo(), 3);
			else
				daoObj.setProcInValue(nProcIndex, "accno","0", 3);
			daoObj.setProcInValue(nProcIndex, "hosp_code",voObj.getStrHospitalCode(),4);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 5);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
          
			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");		
				if(ws.next())
				{
					voObj.setStrLFAccountNo (ws.getString(1));
					voObj.setStrLFAccountOpenDate(ws.getString(2));
					voObj.setStrLFDepositedAmount(ws.getString(3));
					voObj.setStrLFBalanceAmount(ws.getString(4));
					voObj.setStrLFAccountStatus(ws.getString(5));
					voObj.setStrCrNo(ws.getString(6));
					//ws.beforeFirst();
				}
				
			//	voObj.setAdmEpisodeTreatCatDeptDtls(ws);
			} 
			else
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			voObj.setStrMsgString("LFNoTransDAO.getEpisodeList() --> " + e.getMessage());
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
	
	public static void getLFAccountSummary(IssueTransOVO voObj)
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_lf_account_summary(?,?,?,?,?)}";
		int nProcIndex = 0;

		//String strDeptCode = voObj.getStrOffLineRaisingDepartment();//Last Visited Department
		String strCrNo = voObj.getStrPuk();

		String strErr = "";

		try
		{
			System.out.println("------------- IssueTransODAO.getLFAccountSummary -------------");
			System.out.println("------------- pkg_bill_view.proc_lf_account_summary [ Mode - 1 ] -------------");
			
			daoObj = new HisDAO("Billing", "LFNoTransDAO.getEpisodeList");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code",voObj.getStrHospitalCode(),2);
			if(voObj.getStrLFAccountNo()!=null && voObj.getStrLFAccountNo()!="")
			daoObj.setProcInValue(nProcIndex, "lfaccount_no",voObj.getStrLFAccountNo(), 3);
			else
				daoObj.setProcInValue(nProcIndex, "lfaccount_no","0", 3);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 5);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");				
				voObj.setWsLFAccountSummary(ws);
				
			//	voObj.setAdmEpisodeTreatCatDeptDtls(ws);
			} 
			else
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e)
		{	e.printStackTrace();
			voObj.setStrMsgString("LFNoTransDAO.getEpisodeList() --> " + e.getMessage());
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
	 * To get Diagnosis details of patient 
	 * 
	 * @param IssueTransOVO	the IssueTransOVO
	 */
	public static void getPatientDiagDetails(IssueTransOVO vo)
	{
		
		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";
		
    	try 
		{
    		System.out.println("------------- IssueTransODAO.getPatientDiagDetails -------------");
			System.out.println("------------- PKG_MMS_VIEW.proc_diag_emp_view [ Mode - 1 ] -------------");
			
    		String strProcName = "{call PKG_MMS_VIEW.proc_diag_emp_view(?,?::varchar,?::varchar,?,?)}";

			daoObj = new HisDAO("MMS Transactions","IssueTransODAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
     		daoObj.setProcInValue(nProcIndex, "modval", "1",1);
	     	daoObj.setProcInValue(nProcIndex, "crno",vo.getStrCrNo() ,2);
			daoObj.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),3);
						
			daoObj.setProcOutValue(nProcIndex,"err", 1,4);
			daoObj.setProcOutValue(nProcIndex,"resultset", 2,5);

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
    		
		
		
		} 
    	catch (Exception e) 
    	{
    		e.printStackTrace();
			vo.setStrMsgString("--> IssueTransODAO.getPatientDiagDetails()-->"
					+ e.getMessage());
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
	 * @param IssueTransOVO	the IssueTransOVO
	 */
	public static void getIcdList(IssueTransOVO vo)
	{
		
		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";
		
    	try 
		{
    		
    		System.out.println("------------- IssueTransODAO.getIcdList -------------");
			System.out.println("------------- PKG_MMS_VIEW.proc_diag_mst [ Mode - 1 ] -------------");
			
    		String strProcName = "{call PKG_MMS_VIEW.proc_diag_mst(?,?,?)}";

			daoObj = new HisDAO("MMS Transactions","IssueTransODAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
     		daoObj.setProcInValue(nProcIndex, "modval", "1",1);						
			daoObj.setProcOutValue(nProcIndex,"err", 1,2);
			daoObj.setProcOutValue(nProcIndex,"resultset", 2,3);

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
    		
		
		
		} 
    	catch (Exception e) 
    	{
			vo.setStrMsgString("--> IssueTransODAO.getPatientDiagDetails()-->"
					+ e.getMessage());
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
	 * @param IssueTransOVO	the IssueTransOVO
	 */
	public static void getEmpList(IssueTransOVO vo)
	{
		
		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";
		
    	try 
		{
    		
    		System.out.println("------------- IssueTransODAO.getEmpList -------------");
			System.out.println("------------- PKG_MMS_VIEW.proc_unit_consulatant_view [ Mode - 2 ] -------------");
			
    		String strProcName = "{call PKG_IPD_VIEW.proc_unit_consulatant_view(?,?,?,?,?,?)}";

			daoObj = new HisDAO("MMS Transactions","IssueTransODAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
     		daoObj.setProcInValue(nProcIndex, "modval", "2",1);
     		daoObj.setProcInValue(nProcIndex, "deptunitcode", "0",2);	
     		daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
     		daoObj.setProcInValue(nProcIndex, "seatid", "0",4);
			daoObj.setProcOutValue(nProcIndex,"err", 1,5);
			daoObj.setProcOutValue(nProcIndex,"resultset", 2,6);

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
    		
		
		
		} 
    	catch (Exception e) 
    	{
			vo.setStrMsgString("--> IssueTransODAO.getPatientDiagDetails()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null)
				daoObj.free();
				daoObj = null;
			}

	}
	
	
	public static void getBilledItemDtls(IssueTransOVO vo) 
	{

		HisDAO dao = null;
		WebRowSet ws = null;

		String proc_name1 = "{call Pkg_Mms_View.proc_patient_issue_drug_dtl(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try 
		{
			System.out.println("------------- IssueTransODAO.getBilledItemDtls -------------");
			System.out.println("------------- PKG_MMS_VIEW.proc_patient_issue_drug_dtl [ Mode - 2 ] -------------");
			
			    dao = new HisDAO("MMS",	"OfflineIssueIndentTransDAO.getIssueDetailTwo(OfflineIssueIndentTransVO vo)");
			    nProcIndex = dao.setProcedure(proc_name1);
				// set value
				dao.setProcInValue(nProcIndex, "modeval", "2",1);                  //1
				dao.setProcInValue(nProcIndex, "storeid",  vo.getStrStoreId(),2);//2
				dao.setProcInValue(nProcIndex, "itemCatg", vo.getStrIssueNo(),3);//3   item category has been used as issue no here
				dao.setProcInValue(nProcIndex, "from_date","",4);//4
				dao.setProcInValue(nProcIndex, "too_date", "",5);//5
				dao.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),6); //6
				dao.setProcInValue(nProcIndex, "crno",vo.getStrCrNo(),7); //6
				dao.setProcOutValue(nProcIndex,"err", 1,8); // 1 for string return //7
				dao.setProcOutValue(nProcIndex, "resultset", 2,9);//8
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
			//e.printStackTrace();
			vo
					.setStrMsgString("IssueTransODAO.getIssueDetailTwo() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void save(IssueTransOVO vo) 
	{

		HisDAO dao = null;
		WebRowSet ws = null;

		String proc_name1 = "{call Pkg_Mms_dml.dml_issue_billed_item(?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try 
		{
			System.out.println("------------- IssueTransODAO.save -------------");
			System.out.println("------------- Pkg_Mms_dml.dml_issue_billed_item [ Mode - 1 ] -------------");
			
			    dao = new HisDAO("MMS",	"OfflineIssueIndentTransDAO.getIssueDetailTwo(OfflineIssueIndentTransVO vo)");
			    nProcIndex = dao.setProcedure(proc_name1);
				// set value
				dao.setProcInValue(nProcIndex, "modeval", "1",1);                  //1
				dao.setProcInValue(nProcIndex, "storeid",  vo.getStrStoreId(),4);//2
				dao.setProcInValue(nProcIndex, "issueNo", vo.getStrIssueNo(),3);//3   
				dao.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),2); //6
				dao.setProcOutValue(nProcIndex,"err", 1,5); // 1 for string return //7
				dao.executeProcedureByPosition(nProcIndex);
				
			    strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {
			
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			//e.printStackTrace();
			vo
					.setStrMsgString("IssueTransODAO.getIssueDetailTwo() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void deleteIssueDtls(IssueTransOVO vo) 
	{

		HisDAO dao = null;
		WebRowSet ws = null;

		String proc_name1 = "{call Pkg_Mms_dml.proc_patient_issue_delete(?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try 
		{
			
			System.out.println("------------- IssueTransODAO.deleteIssueDtls -------------");
			System.out.println("------------- Pkg_Mms_dml.proc_patient_issue_delete [ Mode - 1 ] -------------");
			
			    dao = new HisDAO("MMS",	"OfflineIssueIndentTransDAO.getIssueDetailTwo(OfflineIssueIndentTransVO vo)");
			    nProcIndex = dao.setProcedure(proc_name1);
				// set value
				dao.setProcInValue(nProcIndex, "modeval", "1",1);                  //1
				dao.setProcInValue(nProcIndex, "storeid",  vo.getStrStoreId(),4);//2
				dao.setProcInValue(nProcIndex, "issueNo", vo.getStrIssueNo(),3);//3   item category has been used as issue no here
				dao.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),2); //6
				dao.setProcOutValue(nProcIndex,"err", 1,5); // 1 for string return //7
				dao.executeProcedureByPosition(nProcIndex);
				
				 strErr = dao.getString(nProcIndex, "err");

					if (strErr == null)
						strErr = "";

					if (strErr.equals("")) {
					
									
					} else {
						throw new Exception(strErr);
					}

		} catch (Exception e) {
			//e.printStackTrace();
			vo
					.setStrMsgString("IssueTransODAO.getIssueDetailTwo() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getTariffDtls(IssueTransOVO vo) 
	{

		HisDAO dao = null;
		WebRowSet ws = null;

		String proc_name1 = "{call Pkg_Mms_View.proc_tariff_list(?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try 
		{
			
			System.out.println("------------- IssueTransODAO.getTariffDtls -------------");
			System.out.println("------------- Pkg_Mms_dml.proc_tariff_list [ Mode - 1 ] -------------");
			
			
			    dao = new HisDAO("MMS",	"OfflineIssueIndentTransDAO.getIssueDetailTwo(OfflineIssueIndentTransVO vo)");
			    nProcIndex = dao.setProcedure(proc_name1);
				// set value
				dao.setProcInValue(nProcIndex, "modeval", "1",1);                  //1
				dao.setProcInValue(nProcIndex, "tariffid", vo.getTariff() ,2);//2
				dao.setProcOutValue(nProcIndex,"err", 1,3); // 1 for string return //7
				dao.setProcOutValue(nProcIndex, "resultset", 2,4);//8
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
			vo.setStrMsgString("IssueTransODAO.getTariffDtls() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	public static void getStoreListBS(IssueTransOVO voObj) {

		HisDAO      daoObj = null;
		WebRowSet       ws = null;
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int     nProcIndex = 0;	
		String strErr = "";
		try
		{
			
			System.out.println("------------- IssueTransODAO.getStoreListBS -------------");
			System.out.println("------------- Pkg_Mms_dml.proc_hstt_store_mst [ Mode - 12 ] -------------");
			
			    daoObj = new HisDAO("MMS Transactions","IssueTransODAO");
			nProcIndex = daoObj.setProcedure(strProcName);
             
			daoObj.setProcInValue(nProcIndex, "modeval", "12",1);
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			
			/* Setting Default Value Start*/
			daoObj.setProcInValue(nProcIndex, "storeid", "0",4);
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0",5);
			/* Setting Default Value End */
			
			daoObj.setProcOutValue(nProcIndex, "err", 1,6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			   strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) 
			{

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrStoreWs(ws);
							
			} 
			else
			{
				throw new Exception(strErr);
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			voObj.setStrMsgString("IssueTransODAO.getStoreList() --> "+ e.getMessage());
			voObj.setStrMsgType("1");

		} 
		finally 
		{
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getPaymentMode(IssueTransOVO vo) {
		// TODO Auto-generated method stub
		
		
		String strProcName ="{call pkg_bill_view.sblt_payment_category_mapping_mst(?,?,?,?,?,?,?,?)}";	
		
		int nProcIndex = 0;
		String val="0";
		String strErr="";
		WebRowSet ws=null;
	
		HisDAO daoObj = null;
		try 
		{
			System.out.println(" ------- IssueTransODAO .getPaymentMode  -------- ");
			System.out.println(" ------- pkg_bill_view.sblt_payment_category_mapping_mst  --[ Mode- 1 ]------ ");
			
				daoObj = new HisDAO("MMS Transactions","IssueTransODAO");
				nProcIndex = daoObj.setProcedure(strProcName);
			//	nProcIndex = daoObj.setFunction(strProcName);
				

				
				daoObj.setProcInValue(nProcIndex,"modeval","1" ,1);
				daoObj.setProcInValue(nProcIndex,"hosp_code", vo.getStrHospitalCode() ,2);
				daoObj.setProcInValue(nProcIndex,"req_type","1",3);
				daoObj.setProcInValue(nProcIndex,"pat_category", "11" ,4);
				daoObj.setProcInValue(nProcIndex,"pat_reciept_paymode","",5);

				daoObj.setProcInValue(nProcIndex,"charge_id", "" ,6);
				daoObj.setProcOutValue(nProcIndex, "err",1,7); // 1 for string return				
				daoObj.setProcOutValue(nProcIndex, "resultset",2,8);	
				
				daoObj.executeProcedureByPosition(nProcIndex);
				
				strErr = daoObj.getString(nProcIndex, "err");
				if (strErr == null)
					strErr = "";
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				if (strErr.equals("")) {
					vo.setStrPayMode(ws);
				}
				
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("IssueTransODAO.getPaymentMode() --> "+ e.getMessage());
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
	public static void getReqType(IssueTransOVO vo) {
		// TODO Auto-generated method stub
		
		String strProcName ="{call Pkg_Mms_View.proc_sstt_indenttype_dtl(?,?,?,?,?,?,?)}";	
		
		int nProcIndex = 0;
		String strErr="";
		WebRowSet ws=null;
	
		HisDAO daoObj = null;
		try 
		{					
			System.out.println("------------- IssueTransODAO.getReqType -------------");
			System.out.println("------------- Pkg_Mms_dml.proc_sstt_indenttype_dtl [ Mode - 3 ] -------------");
			
				daoObj = new HisDAO("MMS Transactions","IssueTransODAO");
				nProcIndex = daoObj.setProcedure(strProcName);
			//	nProcIndex = daoObj.setFunction(strProcName);
				

				
				daoObj.setProcInValue(nProcIndex,"modeval","3" ,1);
				daoObj.setProcInValue(nProcIndex,"hosp_code", vo.getStrHospitalCode() ,2);
				daoObj.setProcInValue(nProcIndex,"req_for","3",3);
				daoObj.setProcInValue(nProcIndex,"item_cat","10" ,4);
				daoObj.setProcInValue(nProcIndex,"store_id",vo.getStrStoreId(),5);

				daoObj.setProcOutValue(nProcIndex, "err",1,6); // 1 for string return				
				daoObj.setProcOutValue(nProcIndex, "resultset",2,7);	
				
				daoObj.executeProcedureByPosition(nProcIndex);
				
				strErr = daoObj.getString(nProcIndex, "err");
				if (strErr == null)
					strErr = "";
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				if (strErr.equals("")) {
					vo.setStrReqTypeWs(ws);
				}
				
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("IssueTransODAO.getReqType() --> "+ e.getMessage());
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
	
	public static synchronized void directIssue(IssueTransOVO vo) 
	{
		HisDAO         dao = null;		
		String strFuncName = "";
		int     nFuncIndex = 0;
		int         length = 0;
		String  paramVal[] = null;
		String userValue[] = null;
		String  strIssueNo = "";
		String strVisitDtl = "";
		Double     netCost = 0.00;
		DmlHsttPatEmpIssueItemDtlDAO dmlhsttpatempissueitemdtl = null;
		DmlHsttPatEmpIssueDtlDAO         dmlhsttpatempissuedtl = null;
		
		int debugPoint = 0;
		String itemValue = "";
	
		String strIssueUnitId = "0";
		String strBillTariff = "";
		//String strBillingTariff = "";
		String strBillBatch = "";
		String strBillRate = "";
		String strBillQty = "";
		
		//MmsConfigUtil mcu;
		int procIndex2=0;

		try 
		{
			
			System.out.println("------------- IssueTransODAO.directIssue ------  START ------");
			
			debugPoint = 1;
			//mcu =new MmsConfigUtil(vo.getStrHospitalCode());
			dao = new HisDAO("MMS Transactions","IssueTransODAO");
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
			
			
		
			          strVisitDtl = "0"	;	
			String strEpisodeCode = "0";
			String     strVisitNo = "0" ;
			
			                  dao = new HisDAO("MMS Transactions","IssueTransODAO");
			               length = vo.getItemParamValue().length;	
			               
			for(int k=0;k<length;k++)
			{				
				/**
				 * Hidden Values corresponding to particular
				 * ITEM DETAILS
				 */	
				debugPoint = 3;
						if(vo.getStrQtyText()[k] != null && vo.getStrQtyText()[k].length() > 0 && !vo.getStrQtyText()[k].equals("0"))
						{	
							                 itemValue = vo.getItemParamValue()[k];
							
											 paramVal = vo.getItemParamValue()[k].split("#");						
											userValue = paramVal[2].replace('^', '#').split("#");	
											
											debugPoint = 4;
											
											    if(strBillTariff != null && strBillTariff != "")
											    {
												
												    strBillTariff=strBillTariff + "^"+userValue[1];
											    }
												else 
												{												
													strBillTariff = userValue[1];													
												}													
												if(strBillRate != null && strBillRate != "")
												{	
													strBillRate=strBillRate + "^"+userValue[9];
												}
												else
												{	
													strBillRate = userValue[9];
												}
												if(strBillQty != null && strBillQty != "")
												{
													strBillQty=strBillQty + "^"+vo.getStrQtyText()[k];
												}
												else
												{	
													strBillQty = vo.getStrQtyText()[k];
												}
												if(strBillBatch != null && strBillBatch != "")
												{	
													strBillBatch=strBillBatch + "^"+userValue[15];
												}
												else
												{	
													strBillBatch = userValue[15];
												}
								System.out.println("---------------------------");					
								System.out.println("strBillTariff-----"+strBillTariff);	
								System.out.println("strBillRate-------"+strBillRate);
								System.out.println("strBillQty--------"+strBillQty);
								System.out.println("strBillBatch------"+strBillBatch);
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
							dmlhsttpatempissueitemdtl.setStrIssueQtyUnitId(strInventoryUnitId); //Aritra,22nd June							
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
							dmlhsttpatempissueitemdtl.setStrOrderBy(vo.getStrReqPrescribedBy());//Id od the consultant
							
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
			//	int procIndex2;
				procIndex2 = dao.setProcedure(proc_name2);
				
				dao.setProcInValue(procIndex2, "modval", "1", 1); 
				dao.setProcInValue(procIndex2, "gnum_dept_code", vo.getStrDeptCode(), 2);
				dao.setProcInValue(procIndex2, "sblnum_chargetype_id",(vo.getStrRequestType().replace("^","#").split("#")[0]).equals("35")?"2":"1" , 3);
				dao.setProcInValue(procIndex2, "sblnum_service_id", "5", 4);
				dao.setProcInValue(procIndex2, "gstr_req_no", strIssueNo, 5);
				dao.setProcInValue(procIndex2, "gnum_treatment_cat", vo.getStrPatientDtlHidVal().replace("^","#").split("#")[3],6);
				dao.setProcInValue(procIndex2, "hrgnum_episode_code",vo.getStrEpisodeCode().replace("^","#").split("#")[0], 7);
				dao.setProcInValue(procIndex2, "hrgnum_puk", vo.getStrPatientId(), 8);
				dao.setProcInValue(procIndex2, "hblnum_pat_lfaccount_no", "0", 9);
				dao.setProcInValue(procIndex2, "gstr_tariff", strBillTariff, 10);
				dao.setProcInValue(procIndex2, "gstr_tariff_batch", strBillBatch, 11);
				dao.setProcInValue(procIndex2, "gstr_tariff_rates", strBillRate, 12);
				dao.setProcInValue(procIndex2, "gstr_reqqty", strBillQty, 13);
				dao.setProcInValue(procIndex2, "hblstr_patient_name", "", 14);
				dao.setProcInValue(procIndex2, "hblstr_pat_address", "", 15);
				dao.setProcInValue(procIndex2, "hblstr_contact_no", "", 16);
				dao.setProcInValue(procIndex2, "age", vo.getStrPatientDtlHidVal().replace("^","#").split("#")[10].split(" ")[0], 17);
				dao.setProcInValue(procIndex2, "ageunit","1", 18);
				dao.setProcInValue(procIndex2, "gender", "1", 19);
				dao.setProcInValue(procIndex2, "refdoctor", "N/A", 20);
				dao.setProcInValue(procIndex2, "refdoccontactno", "0000000000", 21);
				dao.setProcInValue(procIndex2, "gnum_seatid", vo.getStrSeatId(), 22);
				dao.setProcInValue(procIndex2, "hosp_code", vo.getStrHospitalCode(), 23);
				dao.setProcInValue(procIndex2, "ward_code", "0", 24);
				dao.setProcInValue(procIndex2, "admno",	"0", 25);
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
					dmlhsttpatempissuedtl.setStrFinalCost(DmlHsttPatEmpIssueItemDtlDAO.getIntCost()+"");
					dmlhsttpatempissuedtl.setStrFinStartDate(vo.getStrFinStartDate());
					dmlhsttpatempissuedtl.setStrFinEndDate(vo.getStrFinEndDate());
					
					debugPoint = 15;
					
					dmlhsttpatempissuedtl.setStrSeatId(vo.getStrSeatId());
					dmlhsttpatempissuedtl.setStrDeptUnitCode(vo.getStrUnitCode());
					dmlhsttpatempissuedtl.setStrVisitType("2");//hardcoded in case of ipd patient
					dmlhsttpatempissuedtl.setStrDeptCode(vo.getStrDeptCode());
					
					dmlhsttpatempissuedtl.setStrWardCode(vo.getStrReqWardCode());
					
					debugPoint = 16;
					
					dmlhsttpatempissuedtl.setStrReceiveBy(vo.getStrReceiveBy());
					dmlhsttpatempissuedtl.setStrRemarks(vo.getStrRemarks());
					dmlhsttpatempissuedtl.setStrReqDate("");
					dmlhsttpatempissuedtl.setStrVisitNo(strVisitNo);
					dmlhsttpatempissuedtl.setStrEpisoCode(strEpisodeCode);
					
					debugPoint = 17;					
										
					itemValue += " PatientHiddenValue1 :: " + vo.getStrPatientHiddenValue1() + " StrPatientDtlHidVal :: " + vo.getStrPatientDtlHidVal();

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
					dmlhsttpatempissuedtl.setStrTransType("1");  // With CR No	
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
					 System.out.println("----- vo.setStrBillNo----"+vo.getStrBillNo());
					
					
					System.out.println("------------- IssueTransODAO.directIssue ------ END -------");
		  
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgType("1");
			vo.setStrMsgString("IssueTransODAO.insert() --> "
					+ e.getMessage() + " DAO_DEBUG_POINT :: " + debugPoint + " DAO_VALUE :: " + itemValue);
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
	private static void insertDirectIssueBilling(IssueTransOVO vo) {
		// TODO Auto-generated method stub
		CashCollectionOfflineTransVO cashVo=null;
		try {
			cashVo= new CashCollectionOfflineTransVO();
			cashVo.setStrHospitalCode(vo.getStrHospitalCode());
			cashVo.setStrCrNo(vo.getStrCrNo());
			cashVo.setStrOffLineAdmissionNo(vo.getStrAdmNo());
			 cashVo.setStrOffLineEpisode(vo.getStrEpisodeCode());
			 cashVo.setStrOffLineTreatmentCategory(vo.getStrPatientDtlHidVal().replace("^","#").split("#")[3]);
			
			/*
			 * cashVo.setStrOfflineTotalRecAmount(vo.getstr);
			 * cashVo.setStrOfflineMaxClientBenefitAmount(vo.getStr);
			 * cashVo.setStrOfflinePatNetPayAmount(vo.getStr);
			 * cashVo.setStrOfflineTotalActualTariffAmount(vo.getStrta);
			 * cashVo.setStrOfflineTotalDiscountAmount(vo.getStr);
			 * cashVo.setStrOfflineTotalServiceTaxAmount(vo.getStr);
			 * cashVo.setStrOffLineRaisingDepartment(vo.getStrDeptCode());
			 * cashVo.setStrOffLineHospitalService(vo.getStrReqType());
			 * cashVo.setStrOffLineSpecialWard(""); cashVo.setStrOffLineBillingService(");
			 * cashVo.setStrGroupId(vo.getStr); cashVo.setStrQtyUnitId(vo.getStr);
			 * cashVo.setStrSeatId(vo.getStrSeatId()); cashVo.setStrModuleId();
			 * cashVo.setStrIpAddress("0.0.0.0.0");
			 * cashVo.setStrOffLineWard(vo.getStrWardCode());
			 */
			 
			 
			
		}catch(Exception e) {
			e.printStackTrace();
			vo.setStrMsgType("1");
			vo.setStrMsgString("Application Error -->"+e.getMessage());
		}
		
		
	}
	public static void getEpisodeDtl(IssueTransOVO voObj) {
		// TODO Auto-generated method stub
		

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_simple_view.proc_hrgt_episode_unit_based_dtl(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strDeptCode = voObj.getStrDeptCode();//Admitted Department/Last Visited Department
		String strCrNo = voObj.getStrCrNo();
		String strUnit=voObj.getStrUnitCode();

		String strErr = "";

		try
		{
			
			System.out.println("------------- IssueTransODAO.getEpisodeDtl -------------");
			
			System.out.println("------------- pkg_simple_view.proc_hrgt_episode_unit_based_dtl --[ Mode - 1 ]-----------");
			
			daoObj = new HisDAO("mms", "IssueTransODAO.getEpisodeDtl");
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

			if (strErr.equals(""))
			{
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				
				voObj.setStrOffLineEpisodeValues(ws);
			} 
			else
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e)
		{
			voObj.setStrMsgString("IssueTransODAO.getEpisodeDtl() --> " + e.getMessage());
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
	public static void getPresFormDtl(IssueTransOVO voObj) {
		// TODO Auto-generated method stub
		

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_simple_view.proc_hrgt_visittype_episode_based_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strEpisodeCode = voObj.getStrEpisodeCode();
		String strCrNo = voObj.getStrCrNo();

		String strErr = "";

		try
		{
			System.out.println("------------- IssueTransODAO.getPresFormDtl -------------");
			
			System.out.println("------------- pkg_simple_view.proc_hrgt_visittype_episode_based_dtl --[ Mode - 1 ]-----------");
			
			daoObj = new HisDAO("mms", "IssueTransODAO.getEpisodeDtl");
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

			if (strErr.equals(""))
			{
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				
				voObj.setStrPrescFormValues(ws);
			} 
			else
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e)
		{
			voObj.setStrMsgString("IssueTransODAO.getEpisodeDtl() --> " + e.getMessage());
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
	public static void getAccountDtl(IssueTransOVO VO) 
	{
		String proc_name1 = "";
		proc_name1 = "{call PKG_BILL_VIEW.PROC_HBLT_PATACCOUNT_DTL(?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		int procIndex1 = 0;
		String strerr = "";
		WebRowSet ws = null;
		try 
		{
            System.out.println("------------- IssueTransODAO.getAccountDtl -------------");
			
			System.out.println("------------- PKG_BILL_VIEW.PROC_HBLT_PATACCOUNT_DTL --[ Mode - 12 ]-----------");
			
			dao = new HisDAO("mms","IssueTransODAO.getAccountDtlWithAcctNo()");
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "accNo", "", 1);
			dao.setProcInValue(procIndex1, "modeVal", "12", 5);
			dao.setProcInValue(procIndex1, "puk",VO.getStrCrNo(), 2);
			dao.setProcInValue(procIndex1, "chargeTypeId", "", 3);
			dao.setProcInValue(procIndex1, "activeAccount", "", 4);
			dao.setProcInValue(procIndex1, "hosp_code",VO.getStrHospitalCode(), 6);
			dao.setProcOutValue(procIndex1, "ERR", 1, 7);
			dao.setProcOutValue(procIndex1, "RESULTSET", 2, 8);
			dao.executeProcedureByPosition(procIndex1);
			strerr = dao.getString(procIndex1, "ERR");

			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) 
			{
				ws = dao.getWebRowSet(procIndex1, "RESULTSET");
				VO.setStrAccDtl(ws);
				
				VO.setStrMsgType("0");
			} 
			else 
			{
				throw new Exception(strerr);
			}
		} 
		catch (Exception e) 
		{
			VO.setStrMsgString("IssueTransODAO.getAccountDtl() --> "+ e.getMessage());
			VO.setStrMsgType("1");
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
	public static void getdeptname(IssueTransOVO vo) 
	{
		int nFuncIndex;
		String strFuncName2 = "";
		String deptname = "";
		HisDAO dao = null;
		try 
		{
			System.out.println("------------- IssueTransODAO.getdeptname -------------");
				
			System.out.println("------------- ipd_MST.getdeptname --[ Mode - 12 ]-----------");
				
			dao = new HisDAO("mms","IssueTransODAO.getdeptname()");
			strFuncName2 = "{? = call ipd_MST.getdeptname(?,?)}";
			nFuncIndex = dao.setFunction(strFuncName2);
			dao.setFuncInValue(nFuncIndex, 2, vo.getStrDeptCode());
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			deptname = dao.getFuncString(nFuncIndex);
			vo.setStrDeptName(deptname);
		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("IssueTransODAO.getdeptname() --> "+ e.getMessage());
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
	}
	

	
	public static void getIssuedItemDtlview(IssueTransOVO vo) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.Proc_patemp_issue_item_dtl(?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms",	"LPIssueDeskTransDAO.getIndentDetail(LPIssueDeskTransVO vo)");

			
			
			dao.setProcInValue(procIndex1, "modval", "4", 1);

			// set value
			dao.setProcInValue(procIndex1, "issue_No",		vo.getStrIssueNo(), 4);//Request number is being passed name is wrong......discuss

			dao.setProcInValue(procIndex1, "store_id",		vo.getStrStoreId(), 2);

			dao.setProcInValue(procIndex1, "hosp_code",		vo.getStrHospitalCode(), 3);
		

			dao.setProcOutValue(procIndex1, "err", 1, 5); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2, 6); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");
				vo.setIssuedItemDtlWS(ws);

			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			e.printStackTrace();
			vo
					.setStrMsgString("LPIssueDeskTransDAO.getIssuedItemDtl() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
	 public static void getPatientAccountDetails(final IssueTransOVO vo) {
	        final String strProcName = "{call PKG_MMS_VIEW.proc_hstt_pat_account_dtl(?,?,?,?,?)}";
	        int nProcIndex = 0;
	        String strErr = "";
	        WebRowSet ws = null;
	        HisDAO daoObj = null;
	        try {
	            daoObj = new HisDAO("MMSModule", "LPIssueDeskTransDAO");
	            nProcIndex = daoObj.setProcedure(strProcName);
	            daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
	            daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(), 2);
	            daoObj.setProcInValue(nProcIndex, "cr_no", vo.getStrCrNo(), 3);
	            daoObj.setProcOutValue(nProcIndex, "err", 1, 4);
	            daoObj.setProcOutValue(nProcIndex, "resultset", 2, 5);
	            daoObj.executeProcedureByPosition(nProcIndex);
	            strErr = daoObj.getString(nProcIndex, "err");
	            if (strErr == null) {
	                strErr = "";
	            }
	            ws = daoObj.getWebRowSet(nProcIndex, "resultset");
	            if (strErr.equals("")) {
	                vo.setPatAccountDtl(ws);
	            }
	        }
	        catch (Exception _err) {
	            vo.setStrMsgString("LPIssueDeskTransDAO.getPatientAccountBalance() --> " + _err.getMessage());
	            vo.setStrMsgType("1");
	        }
	    }
	 
	 public static void getImageHeader(IssueTransOVO voObj)
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
	 
	 public static void GetData(IssueTransOVO vo) 
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
		
	 public static void itemCategoryCombo1(IssueTransOVO vo)
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
				   hisutil = new HisUtil("MMS", "ReturnFromTransDAO");
				   daoObj  = new HisDAO ("MMS","ReturnFromTransDAO");
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
				vo.setStrMsgString("ReturnFromTransDAO.itemCategoryCombo() --> "
						+ e.getMessage());
				vo.setStrMsgType("1");
			}
		}	 
	 
	 public static WebRowSet STORENAMECOMBO(IssueTransOVO vo)
		{
			String proc_name = "";

			proc_name = "{call PKG_MMS_VIEW.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
			
			HisDAO dao = null;
				
			int nprocIndex = 0;

			String strerr = "";

			WebRowSet ws = null;

			try {

				dao = new HisDAO("MMS",
						"transactions.ReturnFromTransDAO.STORENAMECOMBO(VO)");

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
	 
	 
	 /**
		 * To get Issue Details i.e.(Store Name,Issue No.,Issue Date,Indent
		 * Type,Item Category,Raising Store) on 'issue' page
		 * 
		 * @param vo
		 */
		public static void getCRIssueDetail(IssueTransOVO vo) 
		{
		    // Declaring Variables 
			String        err = "";
			int    procIndex1 = 0;
			HisDAO        dao = null;
			WebRowSet      ws = null;
			String proc_name1 = "{call Pkg_Mms_View.proc_OffLine_IssueNo_dtl(?,?,?,?,?,?,?,?)}";

			try 
			{
				System.out.println("---------Pkg_Mms_View.proc_OffLine_IssueNo_dtl-[ Mode -4 ]---------"); 
	            // Cerating Object			
				       dao = new HisDAO("MMS",	"ReturnFromTransDAO.getIssueDetail(ReturnFromTransVO vo)");
				procIndex1 = dao.setProcedure(proc_name1);

				// set value
				dao.setProcInValue(procIndex1, "modeval", 	"4",1);                  //1
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
				vo.setStrMsgString("ReturnFromTransDAO.getIssueDetail() --> "
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
		 * Get the Recommend Name in Combo.
		 * @param vo
		 */
		public static void getRecommendName(IssueTransOVO vo)
		{
			String strProcName = "{call PKG_MMS_VIEW.proc_consultant_name(?,?,?,?,?,?)}";
			
			int nProcIndex = 0;
			String strErr = "";
			WebRowSet ws = null;
			HisDAO daoObj=null;
			
			try
			{
				System.out.println("------------ ReturnFromTransDAO .getRecommendName  ------------");
				System.out.println("------------  Pkg_Mms_View.proc_consultant_name  - [ Mode - 2 ] -----------");
				
				daoObj=new HisDAO("Return From","IssueTransODAO");
				nProcIndex = daoObj.setProcedure(strProcName);
				daoObj.setProcInValue(nProcIndex, "modeval", 		"2",1);
				daoObj.setProcInValue(nProcIndex, "hosp_code", 		vo.getStrHospitalCode(),3);
				daoObj.setProcInValue(nProcIndex, "seatId",    		vo.getStrSeatId(),4);
				daoObj.setProcInValue(nProcIndex, "deptunitcode", 	"0",2);
				daoObj.setProcOutValue(nProcIndex, "err",			1,5); 
				daoObj.setProcOutValue(nProcIndex, "resultset",		2,6);
				daoObj.executeProcedureByPosition(nProcIndex);
				
				strErr = daoObj.getString(nProcIndex, "err");
				if (strErr == null)
					strErr = "";
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				if (strErr.equals("")) {
					vo.setRecommendNameWS(ws);
				} else {
					throw new Exception(strErr);
				}
			}
			catch(Exception e)
			{
				vo.setStrMsgString("IssueTransODAO.getRecommendName() --> "
						+ e.getMessage());
				vo.setStrMsgType("1");
			}
		}
		
		
		/**
		 * To get Item Details on 'Issue' page
		 * 
		 * @param vo
		 */
		public static void getItem_ALL_LIST(IssueTransOVO vo) {

			String err = "";
			String proc_name1 = "{call Pkg_Mms_View.proc_hrgt_patient_treatment_dtl_drugwise(?,?,?,?,?, ?)}";

			int procIndex1 = 0;
			HisDAO dao = null;
			WebRowSet ws = null;
			try 
			{
				dao = new HisDAO("mms", "ReturnFromTransDAO");				
				System.out.println("------------  ReturnFromTransDAO . getItem_ALL_LIST  ----Pkg_Mms_View.proc_hrgt_patient_treatment_dtl_drugwise  - [ Mode - 4 ]--------");

				procIndex1 = dao.setProcedure(proc_name1);
				// set value
				dao.setProcInValue(procIndex1, "modeval",     "4",1);
				dao.setProcInValue(procIndex1, "puk",          vo.getStrCrNo(),2);
				dao.setProcInValue(procIndex1, "hosp_code",    vo.getStrHospitalCode(),3);
				dao.setProcInValue(procIndex1, "store_id",     vo.getStrStoreId(),4);
				dao.setProcOutValue(procIndex1, "err",         1,5); // 1 for string return value
				dao.setProcOutValue(procIndex1, "resultset",   2,6); // 2 for object
				// execute procedure
				dao.executeProcedureByPosition(procIndex1);

				// get value
				err = dao.getString(procIndex1, "err");

				if (err == null)
					err = "";
				if (err.equals("")) {
					ws = dao.getWebRowSet(procIndex1, "resultset");
					vo.setItemDetailsWS(ws);
				} else {

					throw new Exception(err);
				}

			} catch (Exception e) {
	            e.printStackTrace();
				vo.setStrMsgString("ReturnFromTransDAO.getItem_ALL_LIST() --> "
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
