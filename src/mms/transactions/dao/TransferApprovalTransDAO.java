/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         TransferApprovalTransDAO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.GlobalFlagUtil;
import mms.transactions.vo.TransferApprovalTransVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TransferApprovalTransDAO.
 */
public class TransferApprovalTransDAO {

	/**
	 * Gets the store name.
	 * 
	 * @param voObj the vo obj
	 * @return the store name
	 */
	public static void getStoreName(TransferApprovalTransVO voObj) {

		HisDAO daoObj = null;
		String strFuncName = "";
		String strNewItemFlag = "";
		int nFuncIndex = 0;
		try {
			daoObj = new HisDAO("mms", "SetSachetDetailsTransDAO");
			strFuncName = "{? = call MMS_MST.get_store_dtl(?,?,?)}"; // 3
			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, "1");
			daoObj.setFuncInValue(nFuncIndex, 3, voObj.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 4, voObj.getStrTmpStoreId());
			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);
			strNewItemFlag = daoObj.getFuncString(nFuncIndex);

			voObj.setStrStoreName(strNewItemFlag);

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("TransferApprovalTransDAO.getStoreName --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;

			}
		}

	}

	/**
	 * Gets the DWH list.
	 * 
	 * @param vo the vo
	 * @return the DWH list
	 */
	public static void getDWHList(TransferApprovalTransVO vo) {

		String err = "";
		int procIndex1 = 0;

		WebRowSet ws = null;

		HisDAO dao = null;

		try {

			dao = new HisDAO("mms", "TransferApprovalTransDAO.getDWHList()");

			String proc_name1 = "{call PKG_MMS_VIEW.proc_transfer_order_dtl(?,?,?,?,?,?,?,?)}"; // 8
			procIndex1 = dao.setProcedure(proc_name1);

			// System.out.println("vo.getStrTmpStoreId()"+vo.getStrTmpStoreId());

			dao.setProcInValue(procIndex1, "modeval", "4");
			dao.setProcInValue(procIndex1, "strId", vo.getStrTmpStoreId());
			dao.setProcInValue(procIndex1, "reqNo", "0");
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());			
			dao.setProcInValue(procIndex1, "seatid", vo.getStrSeatId());
			dao.setProcInValue(procIndex1, "sysConfigValue", GlobalFlagUtil.TRANSFER_ORDER_CONFIG);

			dao.setProcOutValue(procIndex1, "ERR", 1);
			dao.setProcOutValue(procIndex1, "resultset", 2);

			dao.executeProcedure(procIndex1);

			err = dao.getString(procIndex1, "ERR");

			if (err == null) {
				err = "";
			}

			if (!err.equals("")) {
				throw new Exception(err);
			}

			ws = dao.getWebRowSet(procIndex1, "resultset");

			vo.setWsDwhList(ws);

		} catch (Exception e) {

			vo.setStrMsgString("TransferApprovalTransDAO.getDWHList() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	/**
	 * Gets the demand request details.
	 * 
	 * @param vo the vo
	 * @return the demand request details
	 */
	public static void getDemandRequestDetails(TransferApprovalTransVO vo) {

		String err = "";
		int procIndex1 = 0;

		WebRowSet ws = null;

		HisDAO dao = null;

		try {

			dao = new HisDAO("mms", "TransferApprovalTransDAO.getDemandRequestDetails()");
			String proc_name1 = "{call PKG_MMS_VIEW.proc_transfer_order_dtl(?,?,?,?,?,?,?,?)}"; // 8
			procIndex1 = dao.setProcedure(proc_name1);
            //System.out.println("vo.getStrStoreId()---->"+vo.getStrStoreId());   
            //System.out.println("vo.Req No()---->"+vo.getStrTmpStoreId()); 
			dao.setProcInValue(procIndex1, "modeval", "5");
			dao.setProcInValue(procIndex1, "strId", vo.getStrStoreId() == null || vo.getStrStoreId().equals("") ? "0" : vo.getStrStoreId());
			dao.setProcInValue(procIndex1, "reqNo", vo.getStrTmpStoreId());
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "seatid", vo.getStrSeatId());
			dao.setProcInValue(procIndex1, "sysConfigValue", GlobalFlagUtil.TRANSFER_ORDER_CONFIG);
			dao.setProcOutValue(procIndex1, "ERR", 1);
			dao.setProcOutValue(procIndex1, "resultset", 2);

			dao.executeProcedure(procIndex1);

			err = dao.getString(procIndex1, "ERR");

			if (err == null) {
				err = "";
			}

			if (!err.equals("")) {
				throw new Exception(err);
			}

			ws = dao.getWebRowSet(procIndex1, "resultset");

			vo.setWsDemandRequestDetails(ws);

		} catch (Exception e) {

			vo.setStrMsgString("TransferApprovalTransDAO.getDemandRequestDetails() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	/**
	 * Gets the transfering details.
	 * 
	 * @param vo the vo
	 * @return the transfering details
	 */
	public static void getTransferingDetails(TransferApprovalTransVO vo) {

		String err = "";
		int procIndex1 = 0;

		WebRowSet ws = null;

		HisDAO dao = null;

		try {

			dao = new HisDAO("mms", "TransferApprovalTransDAO.getTransferingDetails()");

			String proc_name1 = "{call PKG_MMS_VIEW.proc_transfer_order_dtl(?,?,?,?,?,?,?,?)}";
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modeval", "6");
			dao.setProcInValue(procIndex1, "strId", vo.getStrStoreId());
			dao.setProcInValue(procIndex1, "reqNo", vo.getStrItemBrandId());			
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "seatid", vo.getStrSeatId());
			dao.setProcInValue(procIndex1, "sysConfigValue", GlobalFlagUtil.TRANSFER_ORDER_CONFIG);
			dao.setProcOutValue(procIndex1, "ERR", 1);
			dao.setProcOutValue(procIndex1, "resultset", 2);

			dao.executeProcedure(procIndex1);

			err = dao.getString(procIndex1, "ERR");

			if (err == null) {
				err = "";
			}

			if (!err.equals("")) {
				throw new Exception(err);
			}

			ws = dao.getWebRowSet(procIndex1, "resultset");

			vo.setWsTransferingDetails(ws);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("TransferApprovalTransDAO.getTransferingDetails() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	/**
	 * Gets the order details.
	 * 
	 * @param vo the vo
	 * @return the order details
	 */
	public static void getOrderDetails(TransferApprovalTransVO vo) {

		String err = "";
		int procIndex1 = 0;
		WebRowSet ws = null;
		HisDAO dao = null;
		String OrderNo = "";

		try {

			dao = new HisDAO("mms", "TransferApprovalTransDAO.getDemandRequestDetails()");

			String proc_name1 = "{call PKG_MMS_VIEW.proc_transfer_order_dtl(?,?,? ,?,?,?,?,?)}";
			procIndex1 = dao.setProcedure(proc_name1);
			OrderNo = vo.getStrOrderNo() + "^" + vo.getStrOrderSlNo();

			dao.setProcInValue(procIndex1, "modeval", "3");
			dao.setProcInValue(procIndex1, "strId", "0");
			dao.setProcInValue(procIndex1, "reqNo", OrderNo);
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());			
			dao.setProcInValue(procIndex1, "seatid", vo.getStrSeatId());
			dao.setProcInValue(procIndex1, "sysConfigValue", GlobalFlagUtil.TRANSFER_ORDER_CONFIG);
			dao.setProcOutValue(procIndex1, "ERR", 1);
			dao.setProcOutValue(procIndex1, "resultset", 2);

			dao.executeProcedure(procIndex1);

			err = dao.getString(procIndex1, "ERR");

			if (err == null) {
				err = "";
			}

			if (!err.equals("")) {
				throw new Exception(err);
			}

			ws = dao.getWebRowSet(procIndex1, "resultset");
			vo.setWsOrderDetails(ws);

		} catch (Exception e) {
			e.printStackTrace();

			vo.setStrMsgString("TransferApprovalTransDAO.getDemandRequestDetails() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	/**
	 * Insert order generate.
	 * 
	 * @param vo the vo
	 */
	public synchronized static void insertOrderGenerate(TransferApprovalTransVO vo) {

		String err = "";
		int procIndex1 = 0;
		int slno = 0;
		int funcIndex = 0;
		String orderNo = "";
		HisDAO dao = null;

		try {

			dao = new HisDAO("mms", "TransferApprovalTransDAO.getDWHList()");

			funcIndex = dao.setFunction("{? = call MMS_MST.generate_transfer_orderno(?,?,?)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3, "93");
			dao.setFuncInValue(funcIndex, 4, "10");
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			orderNo = dao.getFuncString(funcIndex);
			vo.setStrOrderNo(orderNo);

			String proc_name1 = "{call PKG_MMS_DML.dml_transfer_order_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // 16 Variable

			for (int j = 0; j < vo.getStrTransferOrderQtys().length; j++)
			{

				if (vo.getStrTransferOrderQtys()[j] != null && vo.getStrTransferOrderQtys()[j].trim().length() > 0
						&& !vo.getStrTransferOrderQtys()[j].trim().equals("")) 
				{

					slno = slno + 1;
					procIndex1 = dao.setProcedure(proc_name1);
//                    System.out.println("Trans Store ID-->>"+vo.getStrTransferStoreIds()[j]);
//                    System.out.println("Order Qty ID-->>"+vo.getStrTransferOrderQtys()[j]);
//                    System.out.println("Primary Key-->>"+vo.getStrPrimaryKey()[j]);
               
					dao.setProcInValue(procIndex1, "modval", "1");
					dao.setProcInValue(procIndex1, "demandStrId", vo.getStrStoreId());
					dao.setProcInValue(procIndex1, "demandNo", vo.getStrRequestNo());
					dao.setProcInValue(procIndex1, "demandSlNo", vo.getStrDemandSlNo());
					dao.setProcInValue(procIndex1, "transstrid", vo.getStrTransferStoreIds()[j]);
					dao.setProcInValue(procIndex1, "transNo", vo.getStrTransferRequestNos()[j]);
					dao.setProcInValue(procIndex1, "transSlNo", vo.getStrTransferReqSlNo()[j]);
					dao.setProcInValue(procIndex1, "orderQty", vo.getStrTransferOrderQtys()[j]);
					dao.setProcInValue(procIndex1, "hospital_code", vo.getStrHospitalCode());
					dao.setProcInValue(procIndex1, "seat_id", vo.getStrSeatId());
					dao.setProcInValue(procIndex1, "remarks", vo.getStrRemarks());
					dao.setProcInValue(procIndex1, "orderStore", vo.getStrTmpStoreId());
					dao.setProcInValue(procIndex1, "orderNo", orderNo);
					dao.setProcInValue(procIndex1, "slNo", String.valueOf(slno));
					dao.setProcInValue(procIndex1, "pkKey", vo.getStrPrimaryKey()[j]);
					dao.setProcOutValue(procIndex1, "err", 1);
					dao.execute(procIndex1, 1);
				}
			}
			dao.fire();
			err = dao.getString(procIndex1, "err");

			if (err == null) {
				err = "";
			}
			if (!err.equals("")) {
				throw new Exception(err);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("TransferApprovalTransDAO.insertOrderGenerate() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}

	/**
	 * Insert order modify.
	 * 
	 * @param vo the vo
	 */
	public static synchronized void insertOrderModify(TransferApprovalTransVO vo) {

		String err = "", slN0 = "";
		int procIndex1 = 0;
		int count = 0;
		int funcIndex = 0;
		String procName = "";

		HisDAO dao = null;

		try {

			dao = new HisDAO("mms", "TransferApprovalTransDAO.getDWHList()");

			procName = "{call PKG_MMS_DML.dml_transfer_order_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // 16

			procIndex1 = dao.setProcedure(procName);

			dao.setProcInValue(procIndex1, "modval", "2");
			dao.setProcInValue(procIndex1, "demandstrid", "0");
			dao.setProcInValue(procIndex1, "demandno", "0");
			dao.setProcInValue(procIndex1, "demandSlNo", "0");
			dao.setProcInValue(procIndex1, "transstrid", "0");
			dao.setProcInValue(procIndex1, "transno", "0");
			dao.setProcInValue(procIndex1, "transSlNo", "0");
			dao.setProcInValue(procIndex1, "orderqty", "0");
			dao.setProcInValue(procIndex1, "hospital_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "seat_id", vo.getStrSeatId());
			dao.setProcInValue(procIndex1, "remarks", vo.getStrRemarks());
			dao.setProcInValue(procIndex1, "orderstore", "0");
			dao.setProcInValue(procIndex1, "orderNo", vo.getStrOrderNo());
			dao.setProcInValue(procIndex1, "slNo", vo.getStrOrderSlNo());
			dao.setProcInValue(procIndex1, "pkKey", "0");
			dao.setProcOutValue(procIndex1, "err", 1);
			dao.execute(procIndex1, 1);

			funcIndex = dao.setFunction("{? = call MMS_MST.generate_transfer_order_slno(?,?)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3, vo.getStrOrderNo());
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			slN0 = dao.getFuncString(funcIndex);
			count = Integer.parseInt(slN0);

			procName = "{call PKG_MMS_DML.dml_transfer_order_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // 16

			for (int j = 0; j < vo.getStrTransferOrderQtys().length; j++) {

				if (vo.getStrTransferOrderQtys()[j] != null && vo.getStrTransferOrderQtys()[j].trim().length() > 0
						&& !vo.getStrTransferOrderQtys()[j].trim().equals("")) {

					procIndex1 = dao.setProcedure(procName);
					String[] temp = vo.getStrPrimaryKey1()[j].split("\\^");
					System.out.println("count -->" + count);
					System.out.println("Qty -"+j+"->" + vo.getStrTransferOrderQtys()[j]);

					dao.setProcInValue(procIndex1, "modval", "1");
					dao.setProcInValue(procIndex1, "demandstrid", temp[0]);
					dao.setProcInValue(procIndex1, "demandno", temp[1]);
					dao.setProcInValue(procIndex1, "demandSlNo", temp[2]);
					dao.setProcInValue(procIndex1, "transstrid", temp[3]);
					dao.setProcInValue(procIndex1, "transno", temp[4]);
					dao.setProcInValue(procIndex1, "transSlNo", temp[5]);
					dao.setProcInValue(procIndex1, "orderqty", vo.getStrTransferOrderQtys()[j]);
					dao.setProcInValue(procIndex1, "hospital_code", vo.getStrHospitalCode());
					dao.setProcInValue(procIndex1, "seat_id", vo.getStrSeatId());
					dao.setProcInValue(procIndex1, "remarks", vo.getStrRemarks());
					dao.setProcInValue(procIndex1, "orderstore", vo.getStrTmpStoreId());
					dao.setProcInValue(procIndex1, "orderNo", vo.getStrOrderNo());
					dao.setProcInValue(procIndex1, "slNo", String.valueOf(count));
					dao.setProcInValue(procIndex1, "pkKey", vo.getStrPrimaryKey()[j]);
					dao.setProcOutValue(procIndex1, "err", 1);
					dao.execute(procIndex1, 1);
					count++;

				}

			}

			dao.fire();

			err = dao.getString(procIndex1, "err");

			if (err == null) {
				err = "";
			}
			if (!err.equals("")) {
				throw new Exception(err);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("TransferApprovalTransDAO.insertOrderModification() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}

	/**
	 * Gets the transfering details modify.
	 * 
	 * @param vo the vo
	 * @return the transfering details modify
	 */
	public static void getTransferingDetailsModify(TransferApprovalTransVO vo) {

		String err = "";
		int procIndex1 = 0;
		WebRowSet ws = null;
		HisDAO dao = null;

		try {

			dao = new HisDAO("mms", "TransferApprovalTransDAO.getTransferingDetails()");
			String strItemBrandId = vo.getStrOrderNo() + "^" + vo.getStrOrderSlNo();
			String strStoreId = vo.getStrTransStoreId();

			String proc_name1 = "{call PKG_MMS_VIEW.proc_transfer_order_dtl(?,?,?,?,?,?,?,?)}";
			procIndex1 = dao.setProcedure(proc_name1);
		/*	modeval character varying DEFAULT '1':: character varying,
			strid character varying DEFAULT '0'::character varying,
			reqno character varying DEFAULT '0'::character varying, 
			hosp_code character varying DEFAULT '0'::character varying,
			seatid character varying DEFAULT NULL::character varying, 
			sysconfigvalue character varying DEFAULT '0'::character varying,
			OUT err character varying, OUT resultset ahis_type.refcursor) IS*/
			
			dao.setProcInValue(procIndex1, "modeval", "7");
			dao.setProcInValue(procIndex1, "strId",  (strStoreId.equals("")|| strStoreId==null) ? "0" :strStoreId);
			dao.setProcInValue(procIndex1, "reqNo", (strItemBrandId==null ||strItemBrandId.equals("")) ? "0" :strItemBrandId );			
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "seatid", vo.getStrSeatId());
			dao.setProcInValue(procIndex1, "sysConfigValue", GlobalFlagUtil.TRANSFER_ORDER_CONFIG);
			dao.setProcOutValue(procIndex1, "ERR", 1);
			dao.setProcOutValue(procIndex1, "resultset", 2);
			dao.executeProcedure(procIndex1);

			err = dao.getString(procIndex1, "ERR");

			if (err == null) {
				err = "";
			}

			if (!err.equals("")) {
				throw new Exception(err);
			}

			ws = dao.getWebRowSet(procIndex1, "resultset");
			vo.setWsTransferingDetails(ws);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("TransferApprovalTransDAO.getTransferingDetails() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/**
	 * Demand reject.
	 * 
	 * @param vo the vo
	 */
	public synchronized static void demandReject(TransferApprovalTransVO vo) {

		String err = "";
		int procIndex1 = 0;
		HisDAO dao = null;

		try {

			dao = new HisDAO("mms", "TransferApprovalTransDAO.demandReject()");

			String proc_name1 = "{call PKG_MMS_DML.dml_transfer_demand_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";// 19 +1
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modval", "4");
			dao.setProcInValue(procIndex1, "store_id", vo.getStrStoreId());
			dao.setProcInValue(procIndex1, "hospital_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "itemid", "0");
			dao.setProcInValue(procIndex1, "itembrandid", "0");
			dao.setProcInValue(procIndex1, "demandpriority", "0");
			dao.setProcInValue(procIndex1, "reqqty", "0");
			dao.setProcInValue(procIndex1, "reqqtyunit", "0");
			dao.setProcInValue(procIndex1, "approvby", "0");
			dao.setProcInValue(procIndex1, "appdate", "0");
			dao.setProcInValue(procIndex1, "remarks", vo.getStrRemarks());
			dao.setProcInValue(procIndex1, "seat_id", vo.getStrSeatId());
			dao.setProcInValue(procIndex1, "req_no", vo.getStrRequestNo());
			dao.setProcInValue(procIndex1, "transperiod", "0");
			dao.setProcInValue(procIndex1, "slNo", vo.getStrDemandSlNo());
			dao.setProcInValue(procIndex1, "lastInsertFlag", "0");
			dao.setProcInValue(procIndex1, "appFlag", "0");
			dao.setProcInValue(procIndex1, "reqDate", "0");
			dao.setProcInValue(procIndex1, "processFlag", "0");			
			dao.setProcOutValue(procIndex1, "err", 1);

			dao.execute(procIndex1, 1);

			dao.fire();

			err = dao.getString(procIndex1, "err");

			if (err == null) {
				err = "";
			}

			if (!err.equals("")) {
				throw new Exception(err);
			}

		} catch (Exception e) {
			vo.setStrMsgString("TransferApprovalTransDAO.demandReject() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/**
	 * Transfer reject.
	 * 
	 * @param vo the vo
	 */
	public synchronized static void transferReject(TransferApprovalTransVO vo) {

		String err = "";
		int procIndex1 = 0;
		HisDAO dao = null;

		try {

			dao = new HisDAO("mms", "TransferApprovalTransDAO.transferReject()");

			String proc_name1 = "{call PKG_MMS_DML.dml_transfer_transreq_dtls(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}"; // 17+1
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modval", "4");
			dao.setProcInValue(procIndex1, "store_id", vo.getStrStoreId());
			dao.setProcInValue(procIndex1, "hospital_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "reqqty", "0");
			dao.setProcInValue(procIndex1, "reqqtyunit", "0");
			dao.setProcInValue(procIndex1, "approvby", "0");
			dao.setProcInValue(procIndex1, "appdate", "0");
			dao.setProcInValue(procIndex1, "remarks", vo.getStrRemarks());
			dao.setProcInValue(procIndex1, "seat_id", vo.getStrSeatId());
			dao.setProcInValue(procIndex1, "req_no", vo.getStrRequestNo());
			dao.setProcInValue(procIndex1, "transperiod", "0");
			dao.setProcInValue(procIndex1, "slNo", vo.getStrDemandSlNo());
			dao.setProcInValue(procIndex1, "lastInsertFlag", "0");
			dao.setProcInValue(procIndex1, "appFlag", "0");
			dao.setProcInValue(procIndex1, "reqDate", "0");
			dao.setProcInValue(procIndex1, "pkKey", "0");
			dao.setProcInValue(procIndex1, "processFlag", "0");
			dao.setProcOutValue(procIndex1, "err", 1);
			dao.execute(procIndex1, 1);

			dao.fire();

			err = dao.getString(procIndex1, "err");

			if (err == null) {
				err = "";
			}

			if (!err.equals("")) {
				throw new Exception(err);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("TransferApprovalTransDAO.transferReject() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/**
	 * Transfer forcefully close.
	 * 
	 * @param vo the vo
	 */
	public synchronized static void transferForcefullyClose(TransferApprovalTransVO vo) {

		String err = "";
		int procIndex1 = 0;

		HisDAO dao = null;

		try {

			dao = new HisDAO("mms", "TransferApprovalTransDAO.transferForcefullyClose()");

			String proc_name1 = "{call PKG_MMS_DML.dml_transfer_transreq_dtls(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?)}"; // 18+1
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modval", "5");
			dao.setProcInValue(procIndex1, "store_id", vo.getStrStoreId());
			dao.setProcInValue(procIndex1, "groupId", "0");
			dao.setProcInValue(procIndex1, "hospital_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "itemId", "0");
			dao.setProcInValue(procIndex1, "itemBrandId", "0");
			dao.setProcInValue(procIndex1, "reqQty", "0");
			dao.setProcInValue(procIndex1, "reqQtyUnit", "0");
			dao.setProcInValue(procIndex1, "approvBy", "0");
			dao.setProcInValue(procIndex1, "appDate", "0");
			dao.setProcInValue(procIndex1, "remarks", vo.getStrRemarks());
			dao.setProcInValue(procIndex1, "seat_id", vo.getStrSeatId());
			dao.setProcInValue(procIndex1, "req_No", vo.getStrRequestNo());
			dao.setProcInValue(procIndex1, "transPeriod", "0");
			dao.setProcInValue(procIndex1, "batchNo", "0");
			dao.setProcInValue(procIndex1, "expDate", "0");
			dao.setProcInValue(procIndex1, "mgfDate", "0");
			dao.setProcInValue(procIndex1, "processFlag", "0");
			dao.setProcOutValue(procIndex1, "err", 1);

			dao.execute(procIndex1, 1);

			dao.fire();

			err = dao.getString(procIndex1, "err");

			if (err == null) {
				err = "";
			}

			if (!err.equals("")) {
				throw new Exception(err);
			}

		} catch (Exception e) {

			vo.setStrMsgString("TransferApprovalTransDAO.transferForcefullyClose() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	/**
	 * Cancel order.
	 * 
	 * @param vo the vo
	 */
	public synchronized static void cancelOrder(TransferApprovalTransVO vo) {

		String err = "";
		int procIndex1 = 0;

		HisDAO dao = null;

		try {

			dao = new HisDAO("mms", "TransferApprovalTransDAO.cancelOrder()");

			String proc_name1 = "{call PKG_MMS_DML.dml_transfer_order_cancel_dtls(?,?,?,?,?,?,?)}";
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modval", "1");
			dao.setProcInValue(procIndex1, "orderNo", vo.getStrOrderNo());
			dao.setProcInValue(procIndex1, "slNo", vo.getStrDemandSlNo());
			dao.setProcInValue(procIndex1, "hospital_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "seat_id", vo.getStrSeatId());
			dao.setProcInValue(procIndex1, "remarks", vo.getStrRemarks());
			dao.setProcOutValue(procIndex1, "err", 1);
			dao.execute(procIndex1, 1);

			dao.fire();

			err = dao.getString(procIndex1, "err");

			if (err == null) {
				err = "";
			}

			if (!err.equals("")) {
				throw new Exception(err);
			}

		} catch (Exception e) {

			vo.setStrMsgString("TransferApprovalTransDAO.cancelOrder() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

}
