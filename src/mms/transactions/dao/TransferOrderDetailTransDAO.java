/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         TransferApprovalTransDAO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
import mms.GlobalFlagUtil;


import mms.transactions.vo.TransferOrderDetailTransVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TransferOrderDetailTransDAO.
 */
public class TransferOrderDetailTransDAO {

	/**
	 * Gets the store name.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the store name
	 */
	public static void getStoreName(TransferOrderDetailTransVO voObj) {

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
			voObj.setStrMsgString("TransferOrderDetailTransDAO.getStoreName --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;

			}
		}

	}

	public static void STORENAMECOMBO(TransferOrderDetailTransVO vo) {
		String proc_name = "";

		proc_name = "{call PKG_MMS_VIEW.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet ws = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.TransferOrderDetailTransDAO.STORENAMECOMBO(VO)");

			nprocIndex = dao.setProcedure(proc_name);

			dao.setProcInValue(nprocIndex, "modeval", "4");
			dao.setProcInValue(nprocIndex, "seatid", vo.getStrSeatId());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "storeid", "0");
			dao.setProcInValue(nprocIndex, "storetype_id", "0");
			dao.setProcOutValue(nprocIndex, "err", 1); // 1 for string return
			dao.setProcOutValue(nprocIndex, "resultset", 2); // 2 for object

			// execute procedure
			dao.executeProcedure(nprocIndex);

			// get value
			strerr = dao.getString(nprocIndex, "err");

			if (strerr == null) {
				strerr = "";
			}

			if (strerr.equals("")) {
				ws = dao.getWebRowSet(nprocIndex, "resultset");

				vo.setWbsStoreDetails(ws);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			 e.printStackTrace();
			vo.setStrMsgString("-->TransferOrderDetailTransDAO.STORENAMECOMBO()"
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
	 * The following procedure is used to populate the value of Drug Name combo.
	 * 
	 * @param vo
	 *            the vo
	 */

	public static void getItemName(TransferOrderDetailTransVO vo) {

		String strProcName = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		HisUtil hisutil = null;
		String str = null;
		try {
			hisutil = new HisUtil("master", "TransferRequestTransDAO");
			dao = new HisDAO("mms", "TransferRequestTransDAO");
			strProcName = "{call PKG_MMS_VIEW.proc_storeitem_list(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strProcName);
			dao.setProcInValue(nprocIndex, "modeval", "6");
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "item_id", "0");
			dao.setProcInValue(nprocIndex, "cat_no",   vo.getStrItemCategoryNo());
			dao.setProcInValue(nprocIndex, "group_id", vo.getStrGroupId());
			dao.setProcInValue(nprocIndex, "sub_group_id",vo.getStrSubGroupId());			
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
				if (wb != null && wb.size() != 0) {
					str = hisutil.getOptionValue(wb, "0", "Select Value", true);
					vo.setStrItemNameCombo(str);
				} else {
					str = "<option value='0'>Select Value</option>";
					vo.setStrItemNameCombo(str);
				}

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("TransferRequestTransDAO.getItemName() --> "
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
	 * Gets the batch no details.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void getBatchNoDetails(TransferOrderDetailTransVO vo) {

		String strProcName = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "TransferRequestTransDAO");
			strProcName = "{call PKG_MMS_VIEW.proc_transfer_excess_stock_dtl(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strProcName);
			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "item_id", vo.getStrItemId());
			dao.setProcInValue(nprocIndex, "itembrand_id",
					vo.getStrItemBrandId());
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");

			if (strerr == null) {
				strerr = "";
			}

			wb = dao.getWebRowSet(nprocIndex, "resultset");
			
			if (strerr.equals("")) {
				vo.setStrBatchDtlWs(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("TransferRequestTransDAO.getItemName() --> "
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
	 * The following procedure is used to populate the value of Group Name
	 * combo.
	 * 
	 * @param vo
	 *            the vo
	 */

	public static void getGroupNameCombo(TransferOrderDetailTransVO vo) {

		String err = "";
		String strProcName = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;
		try {
			hisutil = new HisUtil("master", "TransferRequestTransDAO");
			dao = new HisDAO("mms",
					"TransferRequestTransDAO.GetGroupNameCombo(TransferOrderDetailTransVO vo)");

			procIndex1 = dao.setProcedure(strProcName);

			dao.setProcInValue(procIndex1, "modeval", "5");
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "item_category",	vo.getStrItemCategoryNo());			
			dao.setProcInValue(procIndex1, "strPhyStockNo", "0");
			dao.setProcInValue(procIndex1, "strStoreId", vo.getStrStoreId());
			/* end */

			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null) {
				err = "";
			}

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "-1", "0^All", true);
				vo.setStrGroupNameCombo(str);
			} else {
				str = "<option value='0'>All</option>";
				vo.setStrGroupNameCombo(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("TransferRequestTransDAO.GetGroupNameCombo() --> "
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
	 * The following procedure is used to populate the value of Sub - Group Name
	 * combo.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void getSubGroupList(TransferOrderDetailTransVO vo) {
		String err = "";
		String strProcName = "{call pkg_MMS_view.proc_subgroup_list(?,?,?,?,?,?,?)}"; // 5
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = "";
		try {
			hisutil = new HisUtil("master", "TransferRequestTransDAO");
			dao = new HisDAO("TransferRequestTransDAO", "getSubGroupList");
			procIndex1 = dao.setProcedure(strProcName);
			// set value

			dao.setProcInValue(procIndex1, "modeval", "1");
			dao.setProcInValue(procIndex1, "group_id", vo.getStrGroupId());
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "strId", vo.getStrStoreId());
			dao.setProcInValue(procIndex1, "catCode", vo.getStrItemCategoryNo());
			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object
			// execute procedure
			dao.executeProcedure(procIndex1);
			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null) {
				err = "";
			}

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "-1", "0^All", true);
				vo.setStrSubGroupCombo(str);
			} else {
				str = "<option value='0'>All</option>";
				vo.setStrSubGroupCombo(str);
			}

		} catch (Exception e) {

			e.printStackTrace();

			vo.setStrMsgString("TransferRequestTransDAO.getSubGroupList() --> "
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
	 * Gets the DWH list.
	 * 
	 * @param vo
	 *            the vo
	 * @return the DWH list
	 */
	public static void getDWHList(TransferOrderDetailTransVO vo) {

		String err = "";
		int procIndex1 = 0;

		WebRowSet ws = null;

		HisDAO dao = null;

		try {

			dao = new HisDAO("mms", "TransferOrderDetailTransDAO.getDWHList()");

			String proc_name1 = "{call PKG_MMS_VIEW.proc_transfer_order_dtl(?,?,?,?,?,?,?,?)}"; // 8
			procIndex1 = dao.setProcedure(proc_name1);
			
			dao.setProcInValue(procIndex1, "modeval", "4");
			dao.setProcInValue(procIndex1, "strId", vo.getStrTmpStoreId());
			dao.setProcInValue(procIndex1, "reqNo", "0");
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());			
			dao.setProcInValue(procIndex1, "seatid", vo.getStrSeatId());
			dao.setProcInValue(procIndex1, "sysConfigValue",GlobalFlagUtil.TRANSFER_ORDER_CONFIG);
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
            System.out.println("Size-->>"+ws.size());
			vo.setWsDwhList(ws);

		} catch (Exception e) {
            e.printStackTrace();
			vo.setStrMsgString("TransferOrderDetailTransDAO.getDWHList() --> "
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
	 * Gets the demand request details.
	 * 
	 * @param vo
	 *            the vo
	 * @return the demand request details
	 */
	public static void getDemandRequestDetails(TransferOrderDetailTransVO vo) {

		String err = "";
		int procIndex1 = 0;

		WebRowSet ws = null;

		HisDAO dao = null;

		try {

			dao = new HisDAO("mms",
					"TransferOrderDetailTransDAO.getDemandRequestDetails()");
			String proc_name1 = "{call PKG_MMS_VIEW.proc_transfer_order_dtl(?,?,?,?,?,?,?,?)}"; // 8
			procIndex1 = dao.setProcedure(proc_name1);
			// System.out.println("vo.getStrStoreId()---->"+vo.getStrStoreId());
			// System.out.println("vo.Req No()---->"+vo.getStrTmpStoreId());
			dao.setProcInValue(procIndex1, "modeval", "5");
			dao.setProcInValue(procIndex1, "strId", vo.getStrStoreId() == null
					|| vo.getStrStoreId().equals("") ? "0" : vo.getStrStoreId());
			dao.setProcInValue(procIndex1, "reqNo", vo.getStrTmpStoreId());
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "seatid", vo.getStrSeatId());
			dao.setProcInValue(procIndex1, "sysConfigValue",
					GlobalFlagUtil.TRANSFER_ORDER_CONFIG);
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
            e.printStackTrace();
			vo.setStrMsgString("TransferOrderDetailTransDAO.getDemandRequestDetails() --> "
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
	 * Gets the transfering details.
	 * 
	 * @param vo
	 *            the vo
	 * @return the transfering details
	 */
	public static void getTransferingDetails(TransferOrderDetailTransVO vo) {

		String err = "";
		int procIndex1 = 0;

		WebRowSet ws = null;

		HisDAO dao = null;

		try {

			dao = new HisDAO("mms",
					"TransferOrderDetailTransDAO.getTransferingDetails()");

			String proc_name1 = "{call PKG_MMS_VIEW.proc_transfer_order_dtl(?,?,?,?,?,?,?,?)}";
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modeval", "6");
			dao.setProcInValue(procIndex1, "reqNo", vo.getStrItemBrandId());
			dao.setProcInValue(procIndex1, "strId", vo.getStrStoreId());
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "seatid", vo.getStrSeatId());
			dao.setProcInValue(procIndex1, "sysConfigValue",
					GlobalFlagUtil.TRANSFER_ORDER_CONFIG);
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
			vo.setStrMsgString("TransferOrderDetailTransDAO.getTransferingDetails() --> "
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
	 * Gets the order details.
	 * 
	 * @param vo
	 *            the vo
	 * @return the order details
	 */
	public static void getOrderDetails(TransferOrderDetailTransVO vo) {

		String err = "";
		int procIndex1 = 0;
		WebRowSet ws = null;
		HisDAO dao = null;
		String OrderNo = "";

		try {

			dao = new HisDAO("mms",
					"TransferOrderDetailTransDAO.getDemandRequestDetails()");

			String proc_name1 = "{call PKG_MMS_VIEW.proc_transfer_order_dtl(?,?,? ,?,?,?,?,?)}";
			procIndex1 = dao.setProcedure(proc_name1);
			OrderNo = vo.getStrOrderNo() + "^" + vo.getStrOrderSlNo();

			dao.setProcInValue(procIndex1, "modeval", "3");
			dao.setProcInValue(procIndex1, "reqNo", OrderNo);
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "strId", "0");
			dao.setProcInValue(procIndex1, "seatid", vo.getStrSeatId());
			dao.setProcInValue(procIndex1, "sysConfigValue",
					GlobalFlagUtil.TRANSFER_ORDER_CONFIG);
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

			vo.setStrMsgString("TransferOrderDetailTransDAO.getDemandRequestDetails() --> "
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
	 * Insert order generate.
	 * 
	 * @param vo
	 *            the vo
	 */
	public synchronized static void insertOrderGenerate(
			TransferOrderDetailTransVO vo) {

		String strProcName = "", strFuncName = "";
		int nProcIndex = 0, nFuncIndex = 0;
		HisDAO daoObj = null;
		String strReqNo = "";

		String strProcName3 = "";
		int nProcIndex3 = 0;

		String strRequestNo = "";
		int nSlno = 0;
		int lastDrugFlg = 0;
		int funcIndex = 0;

		 
		int procIndex1 = 0;
		int slno = 0;

		String orderNo = "";

		Map<String, Double> strItemDetails = new HashMap<String, Double>();

		try {

			final int count = vo.getStrHiddenValue().length;

			// loop till added items
			for (int i = 0; i < count; i++) {

				String strItemId = vo.getStrHiddenValue()[i].split("\\^")[0];
				Double reqQty = Double.parseDouble(vo.getStrHiddenValue()[i]
						.split("\\^")[6]);

				// if item already exists update the quantity
				if (strItemDetails.containsKey(strItemId)) {

					Double preQty = strItemDetails.get(strItemId);

					strItemDetails.put(strItemId, (preQty + reqQty));

					// add new item with qty
				} else {

					strItemDetails.put(strItemId, reqQty);

				}

			}

			// shortage details

			daoObj = new HisDAO("MMS", "TransferDemandReqTransDAO");

			strFuncName = "{? = call mms_mst.generate_transfer_short_reqno(?,?,?,?)}"; // 4
																						// variables
			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrRequestingStoreId());
			daoObj.setFuncInValue(nFuncIndex, 4, "91");
			daoObj.setFuncInValue(nFuncIndex, 5, "10");
			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);

			strReqNo = daoObj.getFuncString(nFuncIndex);

			strProcName = "{call PKG_MMS_DML.dml_transfer_demand_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // 19+1

			int x = 1;
			int mapCount = strItemDetails.size();
			for (Map.Entry<String, Double> entry : strItemDetails.entrySet()) {
				if (x == mapCount) {
					lastDrugFlg = 1;
				}

			
				// Variables
				nProcIndex = daoObj.setProcedure(strProcName);
				
				daoObj.setProcInValue(nProcIndex, "modval", "1"); // 1
				daoObj.setProcInValue(nProcIndex, "store_id",
						vo.getStrRequestingStoreId()); // 2
				daoObj.setProcInValue(nProcIndex, "hospital_code",
						vo.getStrHospitalCode()); // 3
				daoObj.setProcInValue(nProcIndex, "itemId", "0"); // 4
				daoObj.setProcInValue(nProcIndex, "itemBrandId", entry.getKey()); // 5
				daoObj.setProcInValue(nProcIndex, "demandPriority","1"); // 6
				daoObj.setProcInValue(nProcIndex, "reqQty",
						String.valueOf(entry.getValue())); // 7
				daoObj.setProcInValue(nProcIndex, "reqQtyUnit", "0"); // 8
				daoObj.setProcInValue(nProcIndex, "approvBy", ""); // 9
				daoObj.setProcInValue(nProcIndex, "appDate", ""); // 10
				daoObj.setProcInValue(nProcIndex, "remarks", vo.getStrRemarks()); // 11
				daoObj.setProcInValue(nProcIndex, "seat_id", vo.getStrSeatId()); // 12
				daoObj.setProcInValue(nProcIndex, "req_no", strReqNo); // 13
				daoObj.setProcInValue(nProcIndex, "transPeriod", "0"); // 14
				daoObj.setProcInValue(nProcIndex, "slNo", String.valueOf(x)); // 15
				daoObj.setProcInValue(nProcIndex, "lastInsertFlag",
						String.valueOf(lastDrugFlg)); // 16
				daoObj.setProcInValue(nProcIndex, "appFlag", "1"); // 17
				daoObj.setProcInValue(nProcIndex, "reqDate", vo.getStrOrderDate()); // 18
				daoObj.setProcInValue(nProcIndex, "processFlag", "1");
				daoObj.setProcOutValue(nProcIndex, "err", 1); // 19
				daoObj.execute(nProcIndex, 1);

				x = x + 1;
				
				
			}

			// Excess details
			 
		 
			funcIndex = daoObj
					.setFunction("{? = call MMS_MST.generate_transfer_excess_reqno(?,?,?,?)}");
			// Set Value
			daoObj.setFuncInValue(funcIndex, 2, vo.getStrHospitalCode());
			daoObj.setFuncInValue(funcIndex, 3, vo.getStrTransferingStoreId());
			daoObj.setFuncInValue(funcIndex, 4, "92");
			daoObj.setFuncInValue(funcIndex, 5, "10");
			daoObj.setFuncOutValue(funcIndex, 1);
			// Execute Function
			daoObj.executeFunction(funcIndex);
			strRequestNo = daoObj.getFuncString(funcIndex);
			vo.setStrRequestNo(strRequestNo);

			strProcName3 = "{call PKG_MMS_DML.dml_transfer_transreq_dtls(?,?,?,?,?,?,?,?,?,? , ?,?,?,?,?,?,?,?)}"; // 17

			for (int i = 0; i < count; i++) {

				nSlno = i + 1;

				if (nSlno == count) {
					lastDrugFlg = 1;
				}

				nProcIndex3 = daoObj.setProcedure(strProcName3);
				daoObj.setProcInValue(nProcIndex3, "modval", "1");
				daoObj.setProcInValue(nProcIndex3, "store_id",
						vo.getStrTransferingStoreId());
				daoObj.setProcInValue(nProcIndex3, "hospital_code",
						vo.getStrHospitalCode());
				daoObj.setProcInValue(nProcIndex3, "reqqty",
						vo.getStrHiddenValue()[i].split("\\^")[6]);
				daoObj.setProcInValue(nProcIndex3, "reqqtyunit",
						vo.getStrHiddenValue()[i].split("\\^")[7]);
				daoObj.setProcInValue(nProcIndex3, "approvby", "");
				daoObj.setProcInValue(nProcIndex3, "appdate", "");
				daoObj.setProcInValue(nProcIndex3, "remarks",
						vo.getStrRemarks());
				daoObj.setProcInValue(nProcIndex3, "seat_id", vo.getStrSeatId());
				daoObj.setProcInValue(nProcIndex3, "req_no",
						strRequestNo);
				daoObj.setProcInValue(nProcIndex3, "transperiod", "0");
				daoObj.setProcInValue(nProcIndex3, "slNo",
						String.valueOf(nSlno));
				daoObj.setProcInValue(nProcIndex3, "lastInsertFlag",
						String.valueOf(lastDrugFlg));
				daoObj.setProcInValue(nProcIndex3, "appFlag", "1");
				daoObj.setProcInValue(nProcIndex3, "reqDate",
						vo.getStrOrderDate());
				daoObj.setProcInValue(nProcIndex3, "pkKey", vo.getStrPKey()[i]);
				daoObj.setProcInValue(nProcIndex3, "processFlag", "1");
				daoObj.setProcOutValue(nProcIndex3, "err", 1);
				daoObj.execute(nProcIndex3, 1);
 
				
			}

			// order details
		 
			 
			funcIndex = daoObj
					.setFunction("{? = call MMS_MST.generate_transfer_orderno(?,?,?)}");
			// Set Value
			daoObj.setFuncInValue(funcIndex, 2, vo.getStrHospitalCode());
			daoObj.setFuncInValue(funcIndex, 3, "93");
			daoObj.setFuncInValue(funcIndex, 4, "10");
			daoObj.setFuncOutValue(funcIndex, 1);
			daoObj.executeFunction(funcIndex);
			orderNo = daoObj.getFuncString(funcIndex);
			vo.setStrOrderNo(orderNo);

			String proc_name1 = "{call PKG_MMS_DML.dml_transfer_order_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // 16
																												// Variable

			int shortageSlNo = 0;
			String previousItemId = "";
			
			for (int j = 0; j < count; j++) {
 
				
				if(!previousItemId.equals(vo.getStrHiddenValue()[j].split("\\^")[0])){
					
					previousItemId = vo.getStrHiddenValue()[j].split("\\^")[0];
					shortageSlNo = shortageSlNo + 1;
				}
				

					slno = slno + 1;
					procIndex1 = daoObj.setProcedure(proc_name1);

					daoObj.setProcInValue(procIndex1, "modval", "1");
					daoObj.setProcInValue(procIndex1, "demandStrId",
							vo.getStrRequestingStoreId());
					daoObj.setProcInValue(procIndex1, "demandNo",
							strReqNo);
					daoObj.setProcInValue(procIndex1, "demandSlNo",
							String.valueOf(shortageSlNo));
					daoObj.setProcInValue(procIndex1, "transstrid",
							vo.getStrTransferingStoreId());
					daoObj.setProcInValue(procIndex1, "transNo",
							strRequestNo);
					daoObj.setProcInValue(procIndex1, "transSlNo",
							String.valueOf(slno));
					daoObj.setProcInValue(procIndex1, "orderQty",
							vo.getStrHiddenValue()[j].split("\\^")[6]);
					daoObj.setProcInValue(procIndex1, "hospital_code",
							vo.getStrHospitalCode());
					daoObj.setProcInValue(procIndex1, "seat_id",
							vo.getStrSeatId());
					daoObj.setProcInValue(procIndex1, "remarks",
							vo.getStrRemarks());
					daoObj.setProcInValue(procIndex1, "orderStore",
							vo.getStrTmpStoreId());
					daoObj.setProcInValue(procIndex1, "orderNo", orderNo);
					daoObj.setProcInValue(procIndex1, "slNo",
							String.valueOf(slno));
					daoObj.setProcInValue(procIndex1, "pkKey",
							vo.getStrPKey()[j]);
					daoObj.setProcOutValue(procIndex1, "err", 1);
					daoObj.execute(procIndex1, 1);
			 
			} 

			daoObj.fire();
 
			  
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("TransferOrderDetailTransDAO.insertOrderGenerate() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}

		}
	}

	/**
	 * Insert order modify.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static synchronized void insertOrderModify(
			TransferOrderDetailTransVO vo) {

		String err = "", slN0 = "";
		int procIndex1 = 0;
		int count = 0;
		int funcIndex = 0;
		String procName = "";

		HisDAO dao = null;

		try {

			dao = new HisDAO("mms", "TransferOrderDetailTransDAO.getDWHList()");

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
			dao.setProcInValue(procIndex1, "hospital_code",
					vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "seat_id", vo.getStrSeatId());
			dao.setProcInValue(procIndex1, "remarks", vo.getStrRemarks());
			dao.setProcInValue(procIndex1, "orderstore", "0");
			dao.setProcInValue(procIndex1, "orderNo", vo.getStrOrderNo());
			dao.setProcInValue(procIndex1, "slNo", vo.getStrOrderSlNo());
			dao.setProcInValue(procIndex1, "pkKey", "0");
			dao.setProcOutValue(procIndex1, "err", 1);
			dao.execute(procIndex1, 1);

			funcIndex = dao
					.setFunction("{? = call MMS_MST.generate_transfer_order_slno(?,?)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3, vo.getStrOrderNo());
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			slN0 = dao.getFuncString(funcIndex);
			count = Integer.parseInt(slN0);

			procName = "{call PKG_MMS_DML.dml_transfer_order_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // 16

			for (int j = 0; j < vo.getStrTransferOrderQtys().length; j++) {

				if (vo.getStrTransferOrderQtys()[j] != null
						&& vo.getStrTransferOrderQtys()[j].trim().length() > 0
						&& !vo.getStrTransferOrderQtys()[j].trim().equals("")) {

					procIndex1 = dao.setProcedure(procName);
					String[] temp = vo.getStrPrimaryKey1()[j].split("\\^");
					System.out.println("count -->" + count);
					System.out.println("Qty -" + j + "->"
							+ vo.getStrTransferOrderQtys()[j]);

					dao.setProcInValue(procIndex1, "modval", "1");
					dao.setProcInValue(procIndex1, "demandstrid", temp[0]);
					dao.setProcInValue(procIndex1, "demandno", temp[1]);
					dao.setProcInValue(procIndex1, "demandSlNo", temp[2]);
					dao.setProcInValue(procIndex1, "transstrid", temp[3]);
					dao.setProcInValue(procIndex1, "transno", temp[4]);
					dao.setProcInValue(procIndex1, "transSlNo", temp[5]);
					dao.setProcInValue(procIndex1, "orderqty",
							vo.getStrTransferOrderQtys()[j]);
					dao.setProcInValue(procIndex1, "hospital_code",
							vo.getStrHospitalCode());
					dao.setProcInValue(procIndex1, "seat_id", vo.getStrSeatId());
					dao.setProcInValue(procIndex1, "remarks",
							vo.getStrRemarks());
					dao.setProcInValue(procIndex1, "orderstore",
							vo.getStrTmpStoreId());
					dao.setProcInValue(procIndex1, "orderNo",
							vo.getStrOrderNo());
					dao.setProcInValue(procIndex1, "slNo",
							String.valueOf(count));
					dao.setProcInValue(procIndex1, "pkKey",
							vo.getStrPrimaryKey()[j]);
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
			vo.setStrMsgString("TransferOrderDetailTransDAO.insertOrderModification() --> "
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
	 * Gets the transfering details modify.
	 * 
	 * @param vo
	 *            the vo
	 * @return the transfering details modify
	 */
	public static void getTransferingDetailsModify(TransferOrderDetailTransVO vo) {

		String err = "";
		int procIndex1 = 0;
		WebRowSet ws = null;
		HisDAO dao = null;

		try {

			dao = new HisDAO("mms",
					"TransferOrderDetailTransDAO.getTransferingDetails()");
			String strItemBrandId = vo.getStrOrderNo() + "^"
					+ vo.getStrOrderSlNo();
			String strStoreId = vo.getStrTransStoreId();

			String proc_name1 = "{call PKG_MMS_VIEW.proc_transfer_order_dtl(?,?,?,?,?,?,?,?)}";
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modeval", "7");
			dao.setProcInValue(procIndex1, "reqNo", strItemBrandId);
			dao.setProcInValue(procIndex1, "strId", strStoreId);
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "seatid", vo.getStrSeatId());
			dao.setProcInValue(procIndex1, "sysConfigValue",
					GlobalFlagUtil.TRANSFER_ORDER_CONFIG);
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
			vo.setStrMsgString("TransferOrderDetailTransDAO.getTransferingDetails() --> "
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
	 * Demand reject.
	 * 
	 * @param vo
	 *            the vo
	 */
	public synchronized static void demandReject(TransferOrderDetailTransVO vo) {

		String err = "";
		int procIndex1 = 0;
		HisDAO dao = null;

		try {

			dao = new HisDAO("mms",
					"TransferOrderDetailTransDAO.demandReject()");

			String proc_name1 = "{call PKG_MMS_DML.dml_transfer_demand_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";// 19
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modval", "4");
			dao.setProcInValue(procIndex1, "store_id", vo.getStrStoreId());
			dao.setProcInValue(procIndex1, "hospital_code",
					vo.getStrHospitalCode());
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
			vo.setStrMsgString("TransferOrderDetailTransDAO.demandReject() --> "
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
	 * Transfer reject.
	 * 
	 * @param vo
	 *            the vo
	 */
	public synchronized static void transferReject(TransferOrderDetailTransVO vo) {

		String err = "";
		int procIndex1 = 0;
		HisDAO dao = null;

		try {

			dao = new HisDAO("mms",
					"TransferOrderDetailTransDAO.transferReject()");

			String proc_name1 = "{call PKG_MMS_DML.dml_transfer_transreq_dtls(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?)}"; // 18
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modval", "4");
			dao.setProcInValue(procIndex1, "store_id", vo.getStrStoreId());
			dao.setProcInValue(procIndex1, "hospital_code",
					vo.getStrHospitalCode());
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
			vo.setStrMsgString("TransferOrderDetailTransDAO.transferReject() --> "
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
	 * Transfer forcefully close.
	 * 
	 * @param vo
	 *            the vo
	 */
	public synchronized static void transferForcefullyClose(
			TransferOrderDetailTransVO vo) {

		String err = "";
		int procIndex1 = 0;

		HisDAO dao = null;

		try {

			dao = new HisDAO("mms",
					"TransferOrderDetailTransDAO.transferForcefullyClose()");

			String proc_name1 = "{call PKG_MMS_DML.dml_transfer_transreq_dtls(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}"; // 18
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modval", "5");
			dao.setProcInValue(procIndex1, "store_id", vo.getStrStoreId());
			dao.setProcInValue(procIndex1, "groupId", "0");
			dao.setProcInValue(procIndex1, "hospital_code",
					vo.getStrHospitalCode());
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

			vo.setStrMsgString("TransferOrderDetailTransDAO.transferForcefullyClose() --> "
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
	 * Cancel order.
	 * 
	 * @param vo
	 *            the vo
	 */
	public synchronized static void cancelOrder(TransferOrderDetailTransVO vo) {

		String err = "";
		int procIndex1 = 0;

		HisDAO dao = null;

		try {

			dao = new HisDAO("mms", "TransferOrderDetailTransDAO.cancelOrder()");

			String proc_name1 = "{call PKG_MMS_DML.dml_transfer_order_cancel_dtls(?,?,?,?,?,?,?)}";
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modval", "1");
			dao.setProcInValue(procIndex1, "orderNo", vo.getStrOrderNo());
			dao.setProcInValue(procIndex1, "slNo", vo.getStrDemandSlNo());
			dao.setProcInValue(procIndex1, "hospital_code",
					vo.getStrHospitalCode());
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

			vo.setStrMsgString("TransferOrderDetailTransDAO.cancelOrder() --> "
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
