/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         TransferApprovalTransDAO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.transactions.vo.TransferExcessApprovalTransVO;

/**
 * The Class TransferExcessApprovalTransDAO.
 */
public class TransferExcessApprovalTransDAO {

	
	/**
	 * Method used to get Indent Details for Approval Desk Approval.
	 * 
	 * @param vo the vo
	 * @return the indent details
	 */

	public static void getIndentDetails(TransferExcessApprovalTransVO vo) {
		WebRowSet wb = null;
		HisDAO daoObj = null;
		String strProcName = "";
		int nProcIndex = 0;
		String strErr = "";
		daoObj = new HisDAO("MMS Transactions", "TransferShortageApprovalTransDAO");
		try {

			strProcName = "{call PKG_MMS_VIEW.Get_Indent_Details(?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "storeId", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "reqNo", vo.getStrRequestNo());
			daoObj.setProcInValue(nProcIndex, "reqTypeId", (vo.getStrReqTypeId()==null||vo.getStrReqTypeId().equals(""))?"0":vo.getStrReqTypeId());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null) {
				strErr = "";
			}

			if (strErr.equals("")) {
				wb = daoObj.getWebRowSet(nProcIndex, "RESULTSET");				
				vo.setStrIndentDetailsWs(wb);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> TransferShortageApprovalTransDAO.getIndentDetails()-->" + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
			}
			daoObj = null;
		}

	}
	
	/**
	 * This Function is used to get Store Name by Passing variable.
	 * 
	 * @param vo the vo
	 */
	public static void callingFunctionIndentName(TransferExcessApprovalTransVO vo) {
		
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		try {
			dao = new HisDAO("MMSModule", "ReturnRequestApprovalTransDAO");
			funcIndex = dao.setFunction("{? = call MMS_MST.get_indentType_Name(?,?,?)}");
			
			dao.setFuncInValue(funcIndex, 2, "1");
			dao.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4, (vo.getStrReqTypeId()==null||vo.getStrReqTypeId().equals(""))?"0":vo.getStrReqTypeId());
			dao.setFuncOutValue(funcIndex, 1);			
			dao.executeFunction(funcIndex);
			retVal = dao.getFuncString(funcIndex);

			if (retVal != null) {
				vo.setStrIndentName(retVal);
			} else {
				retVal = "-----";
				vo.setStrIndentName(retVal);
			}

		} catch (Exception e) {
			vo.setStrMsgString("TransferShortageApprovalTransDAO.callingFunctionIndentName() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	

	/**
	 * Gets the transfer approval item dtl.
	 * 
	 * @param vo the vo
	 */
	public static void getTransferApprovalItemDtl(TransferExcessApprovalTransVO vo) {

		String strProcName = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "TransferExcessApprovalTransDAO");
			strProcName = "{call PKG_MMS_VIEW.proc_transfer_transreq_dtls(?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nprocIndex, "modeval", "3");
			dao.setProcInValue(nprocIndex, "strid", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "reqno", vo.getStrRequestNo());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);

			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null) {
				strerr = "";
			}
			wb = dao.getWebRowSet(nprocIndex, "resultset");

			if (strerr.equals("")) {
				if (wb.size() > 0 && wb != null) {
					vo.setWbTransferRequestDtl(wb);
				} else {
					throw new Exception("Web Row Set empty!!");
				}

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("TransferExcessApprovalTransDAO.getTransferApprovalItemDtl() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	
	
	/**
	 * Insert into Table DML_APPROVAL_DTL.
	 * 
	 * @param vo the vo
	 */
	public static void INSERT(TransferExcessApprovalTransVO vo) {
		String proc_name = "";
		int procIndex = 0, nProcIndex1 = 0, nProcIndex2 = 0;
		String strReqQty = "";
		String strSancQty = "";
		int funcIndex = 0;
		String appNo = "";
		HisDAO dao = null;
		String[] temp = null;
		String strReqUnit = "";
		try {

			dao = new HisDAO("MMSModule", "TransferExcessApprovalTransDAO");
			/*********************** APPROVAL NO GENERATION **************************/
			if (vo.getStrReApprovalFlag().equals("1")) {
				appNo = vo.getStrApprovalNo();
			} else {
				/*********************** APPROVAL NO GENERATION **************************/
				funcIndex = dao.setFunction("{? = call MMS_MST.generate_approval_no(?,?,?)}");
				// Set Value
				dao.setFuncInValue(funcIndex, 2, vo.getStrHospitalCode());
				dao.setFuncInValue(funcIndex, 3, vo.getStrReqNo());
				dao.setFuncInValue(funcIndex, 4, vo.getStrStoreId());
				dao.setFuncOutValue(funcIndex, 1);
				// Execute Function
				dao.executeFunction(funcIndex);
				appNo = dao.getFuncString(funcIndex);
			}			

			/******************************** [ PPROCEDURE ONE ] *******************************/
			proc_name = "{call PKG_MMS_DML.DML_APPROVALITEM_DTL(?,?,?,?,?,   ?,?,?,?,?,   ?,?,?,?,?,   ?,?,?)}"; // 18
			procIndex = dao.setProcedure(proc_name);

			int length = vo.getStrInsertHiddenValue().length;

			for (int i = 0; i < length; i++) {
				temp = vo.getStrInsertHiddenValue()[i].split("\\^"); // Indent Qty ^ Indent Qty Unit
				strReqQty = temp[0];
				strReqUnit = temp[1];
				strSancQty = vo.getStrInsSancQty()[i];
				/*
				 * pkKey = HSTNUM_STORE_ID^HSTNUM_ITEM_ID^HSTNUM_ITEMBRAND_ID^HSTSTR_BATCH_NO^HSTNUM_STOCK_STATUS_CODE approvalStatus = 1 >> Approved
				 * = 2 >> Rejected reApprovalFlag = 1 >> Re-Approve = 0 >> Default
				 */
				if(Integer.parseInt(strSancQty) > 0){
					dao.setProcInValue(procIndex, "modval", "1");
					dao.setProcInValue(procIndex, "approvalNo", appNo);
					dao.setProcInValue(procIndex, "strid", vo.getStrStoreId());
					dao.setProcInValue(procIndex, "tostrid", "0");
					dao.setProcInValue(procIndex, "reqno", vo.getStrReqNo());
					dao.setProcInValue(procIndex, "reqtypeid", (vo.getStrReqTypeId()==null||vo.getStrReqTypeId().equals(""))?"0":vo.getStrReqTypeId());
					dao.setProcInValue(procIndex, "catno", vo.getStrItemCatgNo());
					dao.setProcInValue(procIndex, "approvalStatus", vo.getStrApprovalType());
					dao.setProcInValue(procIndex, "reApprovalFlag", vo.getStrReApprovalFlag());
					dao.setProcInValue(procIndex, "pkKey", vo.getStrPrimaryKey()[i]);
					dao.setProcInValue(procIndex, "reqqty", strReqQty);
					dao.setProcInValue(procIndex, "reqQtyUnitId", strReqUnit);
					dao.setProcInValue(procIndex, "sancqty", strSancQty);
					dao.setProcInValue(procIndex, "expiryDate", "");
					dao.setProcInValue(procIndex, "hosp_code", vo.getStrHospitalCode());
					dao.setProcInValue(procIndex, "seatid", vo.getStrSeatId());
					dao.setProcInValue(procIndex, "strRemarks", "");
					dao.setProcOutValue(procIndex, "err", 1);
					dao.execute(procIndex, 1);					
				}
				
			}
			/******************************** [ PPROCEDURE TWO ] *******************************/
			if (vo.getStrReApprovalFlag().equals("1")) {

				String strProcName2 = "{call PKG_MMS_DML.dml_approval_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // 13
				nProcIndex2 = dao.setProcedure(strProcName2);
				dao.setProcInValue(nProcIndex2, "modval", "2");
				dao.setProcInValue(nProcIndex2, "approvalNo", appNo);
				dao.setProcInValue(nProcIndex2, "strid", vo.getStrStoreId());
				dao.setProcInValue(nProcIndex2, "reqno", vo.getStrReqNo());
				dao.setProcInValue(nProcIndex2, "userId", vo.getStrUserId());
				dao.setProcInValue(nProcIndex2, "userLevel", vo.getStrUserLevel());
				dao.setProcInValue(nProcIndex2, "levelType", vo.getStrLevelType());
				dao.setProcInValue(nProcIndex2, "approvalStatus", vo.getStrApprovalType());
				dao.setProcInValue(nProcIndex2, "reApprovalFlag", vo.getStrReApprovalFlag());
				dao.setProcInValue(nProcIndex2, "ipaddress", vo.getStrIpAddr());
				dao.setProcInValue(nProcIndex2, "remarks", vo.getStrRemarks());
				dao.setProcInValue(nProcIndex2, "hosp_code", vo.getStrHospitalCode());
				dao.setProcOutValue(nProcIndex2, "err", 1);
				dao.execute(nProcIndex2, 1);
			}

			String strProcName1 = "{call PKG_MMS_DML.dml_approval_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // 13

			nProcIndex1 = dao.setProcedure(strProcName1);
			dao.setProcInValue(nProcIndex1, "modval", "1");
			dao.setProcInValue(nProcIndex1, "approvalNo", appNo);
			dao.setProcInValue(nProcIndex1, "strid", vo.getStrStoreId());
			dao.setProcInValue(nProcIndex1, "reqno", vo.getStrReqNo());
			dao.setProcInValue(nProcIndex1, "userId", vo.getStrUserId());
			dao.setProcInValue(nProcIndex1, "userLevel", vo.getStrUserLevel());
			dao.setProcInValue(nProcIndex1, "levelType", vo.getStrLevelType());
			dao.setProcInValue(nProcIndex1, "approvalStatus", vo.getStrApprovalType());
			dao.setProcInValue(nProcIndex1, "reApprovalFlag", vo.getStrReApprovalFlag());
			dao.setProcInValue(nProcIndex1, "ipaddress", vo.getStrIpAddr());
			dao.setProcInValue(nProcIndex1, "remarks", vo.getStrRemarks());
			dao.setProcInValue(nProcIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcOutValue(nProcIndex1, "err", 1);
			dao.execute(nProcIndex1, 1);

			dao.fire();

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> TransferExcessApprovalTransDAO.INSERT()-->" + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
			}
			dao = null;
		}

	}

	

}
