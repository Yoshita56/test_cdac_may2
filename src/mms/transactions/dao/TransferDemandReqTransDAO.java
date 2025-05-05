/**********************************************************
 Project:	   DWH_PHD_OPEN	
 File:         TransferDemandReqTransDAO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.GlobalFlagUtil;
import mms.transactions.vo.TransferDemandReqTransVO;

/**
 * The Class TransferDemandReqTransDAO.
 */
public class TransferDemandReqTransDAO {

	/**
	 * Gets the transfer item dtl.
	 * 
	 * @param vo the vo
	 */

	public static void getTransferItemDtl(TransferDemandReqTransVO vo) {

		String strProcName = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "TransferDemandReqTransDAO");
			strProcName = "{call PKG_MMS_VIEW.proc_transfer_transitem_dtls(?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "strId", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "tarnsfer_No", vo.getStrRequestNo());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			/* End */
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
					vo.setWbTransferOrderDetail(wb);
				} else {
					throw new Exception("Web Row Set empty!!");
				}

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("TransferDemandReqTransDAO.getTransferItemDtl() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/**
	 * Gets the transfer dtl.
	 * 
	 * @param vo the vo
	 */

	public static void getTransferDtl(TransferDemandReqTransVO vo) 
	{
		String strProcName = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "TransferDemandReqTransDAO");
			strProcName = "{call PKG_MMS_VIEW.proc_trasfer_trans_dtls(?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strProcName);
			System.out.println("In--TransferDemandReqTransDAO-getStrOrderNumber->"+vo.getStrOrderNumber());
			System.out.println("In--TransferDemandReqTransDAO-getStrOrderSlNo->"+vo.getStrOrderSlNo());
			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "order_No", vo.getStrOrderNumber());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "orderSlNo", vo.getStrOrderSlNo());
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
					vo.setWbTransferOrderDetail(wb);

				} else {
					throw new Exception("Web Row Set empty!!");
				}

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("TransferDemandReqTransDAO.getTransferDtl() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/**
	 * Gets the transfer order dtl for view.
	 * 
	 * @param vo the vo
	 */

	public static void getTransferOrderDtlForView(TransferDemandReqTransVO vo) {

		String strProcName = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {

			dao = new HisDAO("mms", "TransferDemandReqTransDAO");
			strProcName = "{call PKG_MMS_VIEW.proc_transfer_order_dtl(?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strProcName);
//			System.out.println("vo.getStrStoreId()--Shortage Order Details-->"+vo.getStrStoreId());
//			System.out.println("vo.getStrRequestNo()---->"+vo.getStrRequestNo());
//			System.out.println("vo.getStrSerialNo()---->"+vo.getStrSerialNo());
			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "strId", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "reqNo", vo.getStrRequestNo()+"^"+vo.getStrSerialNo());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "seatid", vo.getStrSeatId());
			dao.setProcInValue(nprocIndex, "sysConfigValue", GlobalFlagUtil.TRANSFER_ORDER_CONFIG);
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null) {
				strerr = "";
			}

			wb = dao.getWebRowSet(nprocIndex, "resultset");

			if (strerr.equals("")) {
				if (wb != null && wb.size() > 0) {
					vo.setWbTransferOrderDetail(wb);
				}

			}

		} catch (Exception e) {
			vo.setStrMsgString("TransferDemandReqTransDAO.getTransferDtlForView() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/**
	 * Gets the transfer dtl for modify.
	 * 
	 * @param vo the vo
	 */

	public static void getTransferDtlForModify(TransferDemandReqTransVO vo) {

		String strProcName = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {

			dao = new HisDAO("mms", "TransferDemandReqTransDAO");
			strProcName = "{call PKG_MMS_VIEW.proc_transfer_demand_dtls(?,?,?,?,?,?,?)}";  // 7 variables
			nprocIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "strId", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "reqNo", vo.getStrRequestNo());
			dao.setProcInValue(nprocIndex, "slno", vo.getStrSerialNo());
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
					vo.setStrModifyDtlWS(wb);
				} else {
					throw new Exception("Modify Web Row Set empty!!");
				}

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("TransferDemandReqTransDAO.getTransferDtlForModify() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/**
	 * Gets the transfer dtl for view.
	 * 
	 * @param vo the vo
	 */

	public static void getTransferDtlForView(TransferDemandReqTransVO vo) {

		String strProcName = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {

			dao = new HisDAO("mms", "TransferDemandReqTransDAO");
			strProcName = "{call PKG_MMS_VIEW.proc_transfer_demand_dtls(?,?,?,?,?,?,?)}";  // 7 Variables

			nprocIndex = dao.setProcedure(strProcName);
//			System.out.println("vo.getStrStoreId()--Shortage-->"+vo.getStrStoreId());
//			System.out.println("vo.getStrRequestNo()---->"+vo.getStrRequestNo());
//			System.out.println("vo.getStrSerialNo()---->"+vo.getStrSerialNo());
			
			
			dao.setProcInValue(nprocIndex, "modeval", "2");
			dao.setProcInValue(nprocIndex, "strId", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "reqNo", vo.getStrRequestNo());
			dao.setProcInValue(nprocIndex, "slno", vo.getStrSerialNo());
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
				if (wb != null && wb.size() > 0) {
					vo.setStrModifyDtlWS(wb);
				}

			}

		} catch (Exception e) {
			vo.setStrMsgString("TransferDemandReqTransDAO.getTransferDtlForView() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/**
	 * Gets the item name.
	 * 
	 * @param vo the vo
	 */

	public static void getItemName(TransferDemandReqTransVO vo) {

		String strProcName = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		HisUtil hisutil = null;
		String str = null;
		try {
			hisutil = new HisUtil("master", "TransferDemandReqTransDAO");
			dao = new HisDAO("mms", "TransferDemandReqTransDAO");
			strProcName = "{call PKG_MMS_VIEW.proc_storeitem_list(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strProcName);
			
			dao.setProcInValue(nprocIndex, "modeval", "5");
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "item_id", "0");
			dao.setProcInValue(nprocIndex, "cat_no", vo.getStrItemCategoryNo());
			dao.setProcInValue(nprocIndex, "group_id", vo.getStrGroupId());
			dao.setProcInValue(nprocIndex, "sub_group_id", vo.getStrSubGroupId());
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
			vo.setStrMsgString("TransferDemandReqTransDAO.getItemName() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/**
	 * Gets the group name combo.
	 * 
	 * @param vo the vo
	 */
	public static void getGroupNameCombo(TransferDemandReqTransVO vo) {
		String err = "";
		String strProcName = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;
		try {
			hisutil = new HisUtil("master", "TransferDemandReqTransDAO");
			dao = new HisDAO("mms", "TransferDemandReqTransDAO.GetGroupNameCombo(TransferDemandReqTransVO vo)");

			procIndex1 = dao.setProcedure(strProcName);

			// set value

			dao.setProcInValue(procIndex1, "modeval", "2");
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "item_category", vo.getStrItemCategoryNo());
			/* start */
			dao.setProcInValue(procIndex1, "strPhyStockNo", "0");
			dao.setProcInValue(procIndex1, "strStoreId", "0");
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
				str = "<option value='0'>Select Value</option>";
				vo.setStrGroupNameCombo(str);
			}
		} catch (Exception e) {
			vo.setStrMsgString("TransferDemandReqTransDAO.GetGroupNameCombo() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}

	/**
	 * Gets the sub group list.
	 * 
	 * @param vo the vo
	 */
	public static void getSubGroupList(TransferDemandReqTransVO vo) {
		String err = "";
		String strProcName = "{call pkg_MMS_view.proc_store_subgroup_list(?,?,?,?,?)}"; // 5
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = "";
		try {
			hisutil = new HisUtil("master", "TransferDemandReqTransDAO");
			dao = new HisDAO("TransferDemandReqTransDAO", "getSubGroupList");
			procIndex1 = dao.setProcedure(strProcName);
			// set value
			dao.setProcInValue(procIndex1, "modeval", "1");
			dao.setProcInValue(procIndex1, "group_id", vo.getStrGroupId());
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
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
				str = "<option value='0'>Select value</option>";
				vo.setStrSubGroupCombo(str);
			}

		} catch (Exception e) {

			vo.setStrMsgString("TransferDemandReqTransDAO.getSubGroupList() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	/**
	 * Gets the online approval status.
	 * 
	 * @param vo the vo
	 */
	public static void getOnlineApprovalStatus(TransferDemandReqTransVO vo) {

		String strFuncName = "";
		int nFuncIndex = 0;
		String strOnlineAppStatus = "";

		HisDAO daoObj = null;

		try {

			daoObj = new HisDAO("MMSModule", "TransferDemandReqTransDAO");

			strFuncName = "{? = call mms_mst.check_online_app_status(?,?,?,?)}"; // 4 variables
			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId());
			daoObj.setFuncInValue(nFuncIndex, 4, "91");
			daoObj.setFuncInValue(nFuncIndex, 5, "10");
			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);

			strOnlineAppStatus = daoObj.getFuncString(nFuncIndex);
			vo.setStrOnlineAppStatus(strOnlineAppStatus);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("TransferDemandReqTransDAO.getOnlineApprovalStatus() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * Gets the approved by combo.
	 * 
	 * @param vo the vo
	 */
	public static void getApprovedByCombo(TransferDemandReqTransVO vo) {

		String strProcName = "{call PKG_MMS_VIEW.proc_store_emp_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		WebRowSet ws = null;
		HisDAO daoObj = null;
		HisUtil hisutil = null;
		String str = "";
		try {
			hisutil = new HisUtil("master", "TransferDemandReqTransDAO");
			daoObj = new HisDAO("MMSModule", "TransferDemandReqTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeVal", "1");
			daoObj.setProcInValue(nProcIndex, "storeId", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null) {
				strErr = "";
			}
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				if (ws != null) {
					str = hisutil.getOptionValue(ws, "0", "", true);
					str = str + "<option value='1'>Other</option>";
				} else {
					str = "<option value='0'>Select Value</option>";
				}
				vo.setStrApprovedByCombo(str);
			}
		} catch (Exception e) {
			vo.setStrMsgString("TransferDemandReqTransDAO.getApprovedByCombo() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * Gets the time period combo.
	 * 
	 * @param vo the vo
	 */
	public static void getTimePeriodCombo(TransferDemandReqTransVO vo) {
		String err = "";
		String strProcName = "{call PKG_MMS_VIEW.PERIOD_COMBO_SSTT_PERIOD_MST(?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {

			hisutil = new HisUtil("master", "TransferRequestTransDAO");
			dao = new HisDAO("MMSModule", "TransferRequestTransDAO");

			procIndex1 = dao.setProcedure(strProcName);

			// set value

			dao.setProcInValue(procIndex1, "modeval", "1");
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return value
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
				str = hisutil.getOptionValue(ws, "", "", true);
				vo.setStrTimePeriodCombo(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrTimePeriodCombo(str);
			}

		} catch (Exception e) {
			vo.setStrMsgString("TransferRequestTransDAO.getTimePeriodCombo() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}

	/**
	 * Insert.
	 * 
	 * @param vo the vo
	 */
	public static synchronized void insert(TransferDemandReqTransVO vo) {

		String strProcName = "", strFuncName = "";
		int nProcIndex = 0, nFuncIndex = 0;
		HisDAO daoObj = null;
		String strStoreName = "", strReqNo = "";
		int count = 0;
		int lastInsertFlag = 0;
		try {

			daoObj = new HisDAO("MMS", "TransferDemandReqTransDAO");

			strFuncName = "{? = call mms_mst.generate_transfer_short_reqno(?,?,?,?)}"; // 4 variables
			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId());
			daoObj.setFuncInValue(nFuncIndex, 4, "91");
			daoObj.setFuncInValue(nFuncIndex, 5, "10");
			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);

			strReqNo = daoObj.getFuncString(nFuncIndex);

			strProcName = "{call PKG_MMS_DML.dml_transfer_demand_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // 19+1 Variables
			nProcIndex = daoObj.setProcedure(strProcName);
			count = vo.getStrHiddenValue().length;

			for (int i = 0; i < vo.getStrHiddenValue().length; i++) {
				if (i == (count - 1)) {
					lastInsertFlag = 1;
				} else {
					lastInsertFlag = 0;
				}

				daoObj.setProcInValue(nProcIndex, "modval", "1"); // 1
				daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId()); // 2
				daoObj.setProcInValue(nProcIndex, "hospital_code", vo.getStrHospitalCode()); // 3
				daoObj.setProcInValue(nProcIndex, "itemId", "0"); // 4
				daoObj.setProcInValue(nProcIndex, "itemBrandId", vo.getStrHiddenValue()[i].split("\\^")[0]); // 5
				daoObj.setProcInValue(nProcIndex, "demandPriority", vo.getStrReqStatus()); // 6
				daoObj.setProcInValue(nProcIndex, "reqQty", vo.getStrHiddenValue()[i].split("\\^")[4]); // 7
				daoObj.setProcInValue(nProcIndex, "reqQtyUnit", "0"); // 8
				daoObj.setProcInValue(nProcIndex, "approvBy", vo.getStrApprovedBy()); // 9
				daoObj.setProcInValue(nProcIndex, "appDate", vo.getStrApprovedDate()); // 10
				daoObj.setProcInValue(nProcIndex, "remarks", vo.getStrRemarks()); // 11
				daoObj.setProcInValue(nProcIndex, "seat_id", vo.getStrSeatId()); // 12
				daoObj.setProcInValue(nProcIndex, "req_no", strReqNo); // 13
				daoObj.setProcInValue(nProcIndex, "transPeriod", "0"); // 14
				daoObj.setProcInValue(nProcIndex, "slNo", String.valueOf(i + 1)); // 15
				daoObj.setProcInValue(nProcIndex, "lastInsertFlag", String.valueOf(lastInsertFlag)); // 16
				daoObj.setProcInValue(nProcIndex, "appFlag", vo.getStrOnlineAppStatus()); // 17				
				daoObj.setProcInValue(nProcIndex, "reqDate", vo.getStrReqDate()); // 18
				daoObj.setProcInValue(nProcIndex, "processFlag", "0");
				daoObj.setProcOutValue(nProcIndex, "err", 1); // 19
				daoObj.execute(nProcIndex, 1);
			}

			strStoreName = vo.getStrStoreName();
			daoObj.fire();

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> TransferDemandReqTransDAO.INSERT()-->" + e.getMessage());
			vo.setStrStoreName(strStoreName);
			vo.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;

			}
		}
	}

	/**
	 * Update.
	 * 
	 * @param vo the vo
	 */
	public static synchronized void update(TransferDemandReqTransVO vo) {

		String strProcName = "";
		int nProcIndex = 0;
		HisDAO daoObj = null;
		String strStoreName = "";
		try {

			daoObj = new HisDAO("MMS", "TransferDemandReqTransDAO");
			strProcName = "{call PKG_MMS_DML.dml_transfer_demand_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // 19 +1 Variables
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modval", "2"); // 1
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId()); // 2
			daoObj.setProcInValue(nProcIndex, "hospital_code", vo.getStrHospitalCode()); // 3
			daoObj.setProcInValue(nProcIndex, "itemId", "0"); // 4
			daoObj.setProcInValue(nProcIndex, "itemBrandId", "0"); // 5
			daoObj.setProcInValue(nProcIndex, "demandPriority", vo.getStrReqStatus()); // 6
			daoObj.setProcInValue(nProcIndex, "reqQty", vo.getStrDemandedQty()); // 7
			daoObj.setProcInValue(nProcIndex, "reqQtyUnit", "0"); // 8
			daoObj.setProcInValue(nProcIndex, "approvBy", vo.getStrApprovedBy()); // 9
			daoObj.setProcInValue(nProcIndex, "appDate", vo.getStrApprovedDate()); // 10
			daoObj.setProcInValue(nProcIndex, "remarks", vo.getStrRemarks()); // 11
			daoObj.setProcInValue(nProcIndex, "seat_id", vo.getStrSeatId()); // 12
			daoObj.setProcInValue(nProcIndex, "req_no", vo.getStrRequestNo()); // 13
			daoObj.setProcInValue(nProcIndex, "transPeriod", "0"); // 14
			daoObj.setProcInValue(nProcIndex, "slNo", vo.getStrSerialNo()); // 15
			daoObj.setProcInValue(nProcIndex, "lastInsertFlag", "1"); // 16
			daoObj.setProcInValue(nProcIndex, "appFlag", vo.getStrOnlineAppStatus()); // 17
			daoObj.setProcInValue(nProcIndex, "reqDate", vo.getStrReqDate()); // 18
			daoObj.setProcInValue(nProcIndex, "processFlag", "0");
			daoObj.setProcOutValue(nProcIndex, "err", 1); // 19

			daoObj.execute(nProcIndex, 1);

			strStoreName = vo.getStrStoreName();

			daoObj.fire();

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> TransferDemandReqTransDAO.UPDATE()-->" + e.getMessage());
			vo.setStrStoreName(strStoreName);
			vo.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;

			}
		}

	}

	/**
	 * Cancel.
	 * 
	 * @param vo the vo
	 */
	public static synchronized void cancel(TransferDemandReqTransVO vo) {
		String strProcName3 = "";
		int nProcIndex3 = 0;
		HisDAO daoObj = null;
		String strStoreName = "";

		try {
			daoObj = new HisDAO("MMS", "TransferDemandReqTransDAO");
			strProcName3 = "{call PKG_MMS_DML.dml_transfer_demand_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // 19 + 1 Variables
			nProcIndex3 = daoObj.setProcedure(strProcName3);

			daoObj.setProcInValue(nProcIndex3, "modval", "3"); // 1
			daoObj.setProcInValue(nProcIndex3, "store_id", vo.getStrStoreId()); // 2
			daoObj.setProcInValue(nProcIndex3, "hospital_code", vo.getStrHospitalCode()); // 3
			daoObj.setProcInValue(nProcIndex3, "itemId", "0"); // 4
			daoObj.setProcInValue(nProcIndex3, "itemBrandId", "0"); // 5
			daoObj.setProcInValue(nProcIndex3, "demandPriority", "0"); // 6
			daoObj.setProcInValue(nProcIndex3, "reqQty", "0"); // 7
			daoObj.setProcInValue(nProcIndex3, "reqQtyUnit", "0"); // 8
			daoObj.setProcInValue(nProcIndex3, "approvBy", "0"); // 9
			daoObj.setProcInValue(nProcIndex3, "appDate", "0"); // 10
			daoObj.setProcInValue(nProcIndex3, "remarks", vo.getStrCancelReson()); // 11
			daoObj.setProcInValue(nProcIndex3, "seat_id", vo.getStrSeatId()); // 12
			daoObj.setProcInValue(nProcIndex3, "req_no", vo.getStrRequestNo()); // 13
			daoObj.setProcInValue(nProcIndex3, "transPeriod", "0"); // 14
			daoObj.setProcInValue(nProcIndex3, "slNo", vo.getStrSerialNo()); // 15
			daoObj.setProcInValue(nProcIndex3, "lastInsertFlag", "0"); // 16
			daoObj.setProcInValue(nProcIndex3, "appFlag", "0"); // 17
			daoObj.setProcInValue(nProcIndex3, "reqDate", "0"); // 18
			daoObj.setProcInValue(nProcIndex3, "processFlag", "0");
			daoObj.setProcOutValue(nProcIndex3, "err", 1); // 19

			daoObj.execute(nProcIndex3, 1);

			strStoreName = vo.getStrStoreName();

			daoObj.fire(); // Here we Execute in Batch

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> TransferDemandReqTransDAO.CANCEL()-->" + e.getMessage());
			vo.setStrMsgType("1");
			vo.setStrStoreName(strStoreName);
		} finally {
			if (daoObj != null) {
				daoObj.free();
			}
			daoObj = null;
		}

	}

	/**
	 * Check duplicate request.
	 * 
	 * @param vo the vo
	 */
	public static void checkDuplicateRequest(TransferDemandReqTransVO vo) {

		String strFuncName = "";
		int nFuncIndex = 0;
		String strRequestCount = "";

		HisDAO daoObj = null;

		try {

			daoObj = new HisDAO("MMSModule", "TransferDemandReqTransDAO");

			strFuncName = "{? = call mms_mst.check_dup_shortage_req(?,?,?)}"; // 3 variables
			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId());
			daoObj.setFuncInValue(nFuncIndex, 4, vo.getStrItemBrandId());
			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);

			strRequestCount = daoObj.getFuncString(nFuncIndex);
			vo.setStrReqStatus(strRequestCount);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("TransferDemandReqTransDAO.checkDuplicateRequest() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
	}

}
