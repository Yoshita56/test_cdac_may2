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
import hisglobal.utility.HisUtil;
import mms.GlobalFlagUtil;
import mms.transactions.vo.TransferRequestTransVO;

/**
 * The Class TransferRequestTransDAO.
 */
public class TransferRequestTransDAO {

	/**
	 * The following procedure is used to get Transfer Item Detail(s).
	 * 
	 * @param vo the vo
	 */

	public static void getTransferItemDtl(TransferRequestTransVO vo) {

		String strProcName = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "TransferRequestTransDAO");
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
				if (wb != null && wb.size() > 0) {
					vo.setWbTransferOrderDetail(wb);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("TransferRequestTransDAO.getTransferItemDtl() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/**
	 * The following procedure is used to populate the Transfer Order Detail(s).
	 * 
	 * @param vo the vo
	 */

	public static void getOrderDtlForView(TransferRequestTransVO vo) {

		String strProcName = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		String strReqNo="";
		try {
			dao = new HisDAO("mms", "TransferRequestTransDAO");
			strProcName = "{call PKG_MMS_VIEW.proc_transfer_order_dtl(?,?,?,?,?,?,?,?)}";
			strReqNo = vo.getStrOrderNumber()+"^"+vo.getStrDemandSlNo();			
			nprocIndex = dao.setProcedure(strProcName);
			dao.setProcInValue(nprocIndex, "modeval", "3");
			dao.setProcInValue(nprocIndex, "strId", "0");
			dao.setProcInValue(nprocIndex, "reqNo", strReqNo);
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
					vo.setWbTransferOrderDetailView(wb);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("TransferRequestTransDAO.getOrderDtlForView() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/**
	 * The following procedure is used to populate the Transfer Details(s).
	 * 
	 * @param vo the vo
	 */

	public static void getTransferDtl(TransferRequestTransVO vo) {

		String strProcName = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "TransferRequestTransDAO");

			strProcName = "{call PKG_MMS_VIEW.proc_trasfer_trans_dtls(?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strProcName);

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
				if (wb != null && wb.size() > 0) {
					vo.setWbTransferOrderDetail(wb);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("TransferRequestTransDAO.getTransferDtl() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/**
	 * The following procedure is used to populate the Transfer Order Detail(s).
	 * 
	 * @param vo the vo
	 */

	public static void getTransferOrderDtlForView(TransferRequestTransVO vo) {

		String strProcName = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "TransferRequestTransDAO");
			strProcName = "{call PKG_MMS_VIEW.proc_transfer_order_dtl(?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strProcName);
			//System.out.println("222222222---------------------------------");
			String strStoreId = vo.getStrStoreId().split("\\^")[0];
			//String strRequestNo = vo.getStrRequestNo();
//            System.out.println("vo.getStrRequestNo()--Excess Voucher Oder Dtal-->"+vo.getStrRequestNo()); 
//            System.out.println("vo.getStrSlNo()---->"+vo.getStrSlNo()); 
//            System.out.println("vo.getStrStoreId()---->"+vo.getStrStoreId()); 
			
			dao.setProcInValue(nprocIndex, "modeval", "2");
			dao.setProcInValue(nprocIndex, "strId", strStoreId);
			dao.setProcInValue(nprocIndex, "reqNo", vo.getStrRequestNo()+"^"+vo.getStrSlNo());
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
			e.printStackTrace();
			vo.setStrMsgString("TransferRequestTransDAO.getTransferDtlForView() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/**
	 * The following procedure is used to get Drug Transfer Detial(s) for Modify.
	 * 
	 * @param vo the vo
	 */

	public static void getTransferDtlForModify(TransferRequestTransVO vo) {

		String strProcName = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {

			dao = new HisDAO("mms", "TransferRequestTransDAO");
			strProcName = "{call PKG_MMS_VIEW.proc_transfer_transreq_dtls(?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "strId", vo.getStrStoreId().split("\\^")[0]);
			dao.setProcInValue(nprocIndex, "reqNo", vo.getStrRequestNo()+"^"+vo.getStrSlNo());
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
				if (wb != null && wb.size() > 0) {
					vo.setStrModifyDtlWS(wb);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("TransferRequestTransDAO.getTransferDtlForModify() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/**
	 * The following procedure is used to get The Drug Transfer Details for View.
	 * 
	 * @param vo the vo
	 */

	public static void getTransferDtlForView(TransferRequestTransVO vo) {

		String strProcName = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "TransferRequestTransDAO");
			strProcName = "{call PKG_MMS_VIEW.proc_transfer_transreq_dtls(?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strProcName);
			//System.out.println("1111------");
			dao.setProcInValue(nprocIndex, "modeval", "2");
			dao.setProcInValue(nprocIndex, "strId", vo.getStrStoreId().split("\\^")[0]);
			dao.setProcInValue(nprocIndex, "reqNo", vo.getStrRequestNo()+"^"+vo.getStrSlNo());
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
			e.printStackTrace();
			vo.setStrMsgString("TransferRequestTransDAO.getTransferDtlForView() --> " + e.getMessage());
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
	public static void getOnlineApprovalStatus(TransferRequestTransVO vo) {

		String strFuncName ="";
		int nFuncIndex = 0;
		String strOnlineAppStatus = "";

		HisDAO daoObj = null;

		try {

			daoObj = new HisDAO("MMSModule", "TransferRequestTransDAO");

			strFuncName = "{? = call mms_mst.check_online_app_status(?,?,?,?)}"; // 4 variables
			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId().split("\\^")[0]);
			daoObj.setFuncInValue(nFuncIndex, 4, "92");
			daoObj.setFuncInValue(nFuncIndex, 5, "10");
			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);

			strOnlineAppStatus = daoObj.getFuncString(nFuncIndex);
			vo.setStrOnlineAppStatus(strOnlineAppStatus);

		} catch (Exception e) {
			vo.setStrMsgString("TransferRequestTransDAO.getOnlineApprovalStatus() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * The following procedure is used to populate the value of Drug Name combo.
	 * 
	 * @param vo the vo
	 */

	public static void getItemName(TransferRequestTransVO vo) {

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
			e.printStackTrace();
			vo.setStrMsgString("TransferRequestTransDAO.getItemName() --> " + e.getMessage());
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
	 * @param vo the vo
	 */
	public static void getBatchNoDetails(TransferRequestTransVO vo) {

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
			dao.setProcInValue(nprocIndex, "itembrand_id", vo.getStrItemBrandId());
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId());			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");

			if (strerr == null) {
				strerr = "";
			}

			wb = dao.getWebRowSet(nprocIndex, "resultset");
			 System.out.println("Size of WS:::"+wb.size());
			if (strerr.equals("")) {
				vo.setStrBatchDtlWs(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("TransferRequestTransDAO.getItemName() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/**
	 * The following procedure is used to populate the value of Group Name combo.
	 * 
	 * @param vo the vo
	 */

	public static void getGroupNameCombo(TransferRequestTransVO vo) {

		String err = "";
		String strProcName = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;
		try {
			hisutil = new HisUtil("master", "TransferRequestTransDAO");
			dao = new HisDAO("mms", "TransferRequestTransDAO.GetGroupNameCombo(TransferRequestTransVO vo)");

			procIndex1 = dao.setProcedure(strProcName);

			// set value

			dao.setProcInValue(procIndex1, "modeval", "5");
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "item_category", vo.getStrItemCategoryNo());
			
			/* start */
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
				str = "<option value='0'>Select Value</option>";
				vo.setStrGroupNameCombo(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("TransferRequestTransDAO.GetGroupNameCombo() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}

	/**
	 * The following procedure is used to populate the value of Sub - Group Name combo.
	 * 
	 * @param vo the vo
	 */
	public static void getSubGroupList(TransferRequestTransVO vo) {
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
				str = "<option value='0'>Select value</option>";
				vo.setStrSubGroupCombo(str);
			}

		} catch (Exception e) {

			e.printStackTrace();

			vo.setStrMsgString("TransferRequestTransDAO.getSubGroupList() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	/**
	 * This function is used to set initial values in Received by combo.
	 * 
	 * @param vo the vo
	 */
	public static void getApprovedByCombo(TransferRequestTransVO vo) {

		String strProcName = "{call PKG_MMS_VIEW.proc_store_emp_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		WebRowSet ws = null;
		HisDAO daoObj = null;
		HisUtil hisutil = null;
		String str = "";
		try {
			hisutil = new HisUtil("master", "TransferRequestTransDAO");
			daoObj = new HisDAO("MMSModule", "TransferRequestTransDAO");

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
			if (strErr.equals(""))
			{
				if (ws != null) 
				{
				   
				    	str = hisutil.getOptionValue(ws, "0", "", true);
						str = str + "<option value='1'>Other</option>";
				    
				}
				else 
				{
					str = "<option value='0'>Select Value</option>";
				}
				vo.setStrApprovedByCombo(str);
			}
		} catch (Exception e) {
			vo.setStrMsgString("TransferRequestTransDAO.getApprovedByCombo() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * This function is used to set initial values in Time Period combo.
	 * 
	 * @param vo the vo
	 */

	public static void getTimePeriodCombo(TransferRequestTransVO vo) {
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
				str = hisutil.getOptionValue(ws, "", "", true);
				vo.setStrTimePeriodCombo(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrTimePeriodCombo(str);
			}

		} catch (Exception e) {
			e.printStackTrace();
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
	public static synchronized void insert(TransferRequestTransVO vo) 
	{
		String strProcName3 = "";
		int nProcIndex3 = 0;
		HisDAO daoObj = null;
		String strStoreName = "",strRequestNo="";
	    int nSlno = 0;
	    int lastDrugFlg = 0;
	    int funcIndex = 0;
		try 
		{
			
			   daoObj = new HisDAO("MMS", "TransferRequestTransDAO");
			funcIndex = daoObj.setFunction("{? = call MMS_MST.generate_transfer_excess_reqno(?,?,?,?)}");
			// Set Value			
			daoObj.setFuncInValue(funcIndex, 2, vo.getStrHospitalCode());
			daoObj.setFuncInValue(funcIndex, 3, vo.getStrStoreId().split("\\^")[0]);
			daoObj.setFuncInValue(funcIndex, 4, "92");
			daoObj.setFuncInValue(funcIndex, 5, "10");
			daoObj.setFuncOutValue(funcIndex, 1);
			// Execute Function
			daoObj.executeFunction(funcIndex);
			strRequestNo = daoObj.getFuncString(funcIndex);			
			vo.setStrRequestNo(strRequestNo);
			
			strProcName3 = "{call PKG_MMS_DML.dml_transfer_transreq_dtls(?,?,?,?,?,?,?,?,?,? , ?,?,?,?,?,?,?,?)}"; // 17 + 1 Varibale's
//			System.out.println("Length of Drug---->"+vo.getStrHiddenValue().length);
			int drugLen = vo.getStrHiddenValue().length;
			for (int i = 0; i < vo.getStrHiddenValue().length; i++) 
			{
 			 
				nSlno = i+1;	
 
				if(nSlno==drugLen)
				{
					lastDrugFlg = 1;
				}		
 
			    nProcIndex3 = daoObj.setProcedure(strProcName3);
				daoObj.setProcInValue(nProcIndex3, "modval", 		"1"); 
				daoObj.setProcInValue(nProcIndex3, "store_id", 		vo.getStrStoreId().split("\\^")[0]);			
				daoObj.setProcInValue(nProcIndex3, "hospital_code", vo.getStrHospitalCode()); 			
				daoObj.setProcInValue(nProcIndex3, "reqqty", 		vo.getStrHiddenValue()[i].split("\\^")[6]);
				daoObj.setProcInValue(nProcIndex3, "reqqtyunit", 	vo.getStrHiddenValue()[i].split("\\^")[7]); 
				daoObj.setProcInValue(nProcIndex3, "approvby", 		vo.getStrApprovedBy()); 
				daoObj.setProcInValue(nProcIndex3, "appdate", 	    vo.getStrApprovalDate());				  
				daoObj.setProcInValue(nProcIndex3, "remarks", 		vo.getStrRemarks()); 
				daoObj.setProcInValue(nProcIndex3, "seat_id",       vo.getStrSeatId()); 
				daoObj.setProcInValue(nProcIndex3, "req_no",        vo.getStrRequestNo()); 
				daoObj.setProcInValue(nProcIndex3, "transperiod",   "0"); 		
				daoObj.setProcInValue(nProcIndex3, "slNo", 			String.valueOf(nSlno)); 
				daoObj.setProcInValue(nProcIndex3, "lastInsertFlag",String.valueOf(lastDrugFlg)); 
				daoObj.setProcInValue(nProcIndex3, "appFlag",    	vo.getStrOnlineAppStatus()); 
				daoObj.setProcInValue(nProcIndex3, "reqDate", 		vo.getStrReqDate());
				daoObj.setProcInValue(nProcIndex3, "pkKey", 		vo.getStrPKey()[i]);
				daoObj.setProcInValue(nProcIndex3, "processFlag", "0");
				daoObj.setProcOutValue(nProcIndex3, "err", 			1); 
				daoObj.execute(nProcIndex3, 1);
				strStoreName = vo.getStrStoreName();

			}
			daoObj.fire();

		} catch (Exception e) {
			vo.setStrMsgString("--> TransferRequestTransDAO.INSERT()-->" + e.getMessage());
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
	public static synchronized void update(TransferRequestTransVO vo) {

		String strProcName3 = "";
		int nProcIndex3 = 0;
		HisDAO daoObj = null;
		String strStoreName = "";
		try 
		{
		    	daoObj = new HisDAO("MMS", "TransferRequestTransDAO");
			    strProcName3 = "{call PKG_MMS_DML.dml_transfer_transreq_dtls(?,?,?,?,?,?,?,?,?,? , ?,?,?,?,?,?,?,?)}"; // 17 Varibale's
			    
//				System.out.println("getStrStoreId ---->"+vo.getStrStoreId());
//				System.out.println("vo.getStrDemandedQty()---->"+vo.getStrDemandedQty());				
//				System.out.println("vo.getStrApprovedBy()---->"+vo.getStrApprovedBy());
//				System.out.println("vo.getStrSlNo()---->"+vo.getStrSlNo());
//				System.out.println("vo.getStrOnlineAppStatus()---->"+vo.getStrOnlineAppStatus());
//				System.out.println("vo.getStrApprovalDate()---->"+vo.getStrApprovedDate());
//				System.out.println("vo.getStrRemarks()---->"+vo.getStrRemarks());
//				System.out.println("Request No---->"+vo.getStrRequestNo());
			    
			    nProcIndex3 = daoObj.setProcedure(strProcName3);
				daoObj.setProcInValue(nProcIndex3, "modval", 		"2"); 
				daoObj.setProcInValue(nProcIndex3, "store_id", 		vo.getStrStoreId().split("\\^")[0]);			
				daoObj.setProcInValue(nProcIndex3, "hospital_code", vo.getStrHospitalCode()); 			
				daoObj.setProcInValue(nProcIndex3, "reqqty", 		vo.getStrDemandedQty());
				daoObj.setProcInValue(nProcIndex3, "reqqtyunit", 	"0"); 
				daoObj.setProcInValue(nProcIndex3, "approvby", 		vo.getStrApprovedBy()); 
				daoObj.setProcInValue(nProcIndex3, "appdate", 	    vo.getStrApprovedDate()); 
				daoObj.setProcInValue(nProcIndex3, "remarks", 		vo.getStrRemarks()); 
				daoObj.setProcInValue(nProcIndex3, "seat_id",       vo.getStrSeatId()); 
				daoObj.setProcInValue(nProcIndex3, "req_no",        vo.getStrRequestNo()); 
				daoObj.setProcInValue(nProcIndex3, "transperiod",   "0"); 		
				daoObj.setProcInValue(nProcIndex3, "slNo", 			vo.getStrSlNo()); 
				daoObj.setProcInValue(nProcIndex3, "lastInsertFlag","0"); 
				daoObj.setProcInValue(nProcIndex3, "appFlag",    	vo.getStrOnlineAppStatus()); 
				daoObj.setProcInValue(nProcIndex3, "reqDate", 		vo.getStrReqDate());
				daoObj.setProcInValue(nProcIndex3, "pkKey", 		"0"); 
				daoObj.setProcInValue(nProcIndex3, "processFlag", "0");
				daoObj.setProcOutValue(nProcIndex3, "err", 			1); 
				daoObj.execute(nProcIndex3, 1);
				strStoreName = vo.getStrStoreName();
				daoObj.fire();
			
		} catch (Exception e) {
			vo.setStrMsgString("--> TransferRequestTransDAO.UPDATE()-->" + e.getMessage());
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
	 * This method is used to Cancel data into Table'.
	 * 
	 * @param vo the vo
	 */
	public static synchronized void cancel(TransferRequestTransVO vo) {

		String strProcName3 = "";
		int nProcIndex3 = 0;
		HisDAO daoObj = null;
		String strStoreName = "";
		try 
		{
		    	daoObj = new HisDAO("MMS", "TransferRequestTransDAO");
			    strProcName3 = "{call PKG_MMS_DML.dml_transfer_transreq_dtls(?,?,?,?,?,?,?,?,?,? , ?,?,?,?,?,?,?,?)}"; // 17 +1 Varibale's
			    
//				System.out.println("<--CNACEL-->");				
//				System.out.println("vo.getStrSlNo()---->"+vo.getStrSlNo());				
//				System.out.println("Request No---->"+vo.getStrRequestNo());
			    
			    nProcIndex3 = daoObj.setProcedure(strProcName3);
				daoObj.setProcInValue(nProcIndex3, "modval", 		"3"); 
				daoObj.setProcInValue(nProcIndex3, "store_id", 		vo.getStrStoreId().split("\\^")[0]);			
				daoObj.setProcInValue(nProcIndex3, "hospital_code", vo.getStrHospitalCode()); 			
				daoObj.setProcInValue(nProcIndex3, "reqqty", 		vo.getStrDemandedQty());
				daoObj.setProcInValue(nProcIndex3, "reqqtyunit", 	"0"); 
				daoObj.setProcInValue(nProcIndex3, "approvby", 		vo.getStrApprovedBy()); 
				daoObj.setProcInValue(nProcIndex3, "appdate", 	    vo.getStrApprovedDate()); 
				daoObj.setProcInValue(nProcIndex3, "remarks", 		vo.getStrCancelReson()); 
				daoObj.setProcInValue(nProcIndex3, "seat_id",       vo.getStrSeatId()); 
				daoObj.setProcInValue(nProcIndex3, "req_no",        vo.getStrRequestNo()); 
				daoObj.setProcInValue(nProcIndex3, "transperiod",   "0"); 		
				daoObj.setProcInValue(nProcIndex3, "slNo", 			vo.getStrSlNo()); 
				daoObj.setProcInValue(nProcIndex3, "lastInsertFlag","0"); 
				daoObj.setProcInValue(nProcIndex3, "appFlag",    	vo.getStrOnlineAppStatus()); 
				daoObj.setProcInValue(nProcIndex3, "reqDate", 		vo.getStrReqDate());
				daoObj.setProcInValue(nProcIndex3, "pkKey", 		"0"); 
				daoObj.setProcInValue(nProcIndex3, "processFlag", "0");
				daoObj.setProcOutValue(nProcIndex3, "err", 			1); 
				daoObj.execute(nProcIndex3, 1);
				strStoreName = vo.getStrStoreName();
				daoObj.fire();
			
		} catch (Exception e) {
			vo.setStrMsgString("--> TransferRequestTransDAO.CANCEL()-->" + e.getMessage());
			vo.setStrStoreName(strStoreName);
			vo.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;

			}
		}

	}

}
