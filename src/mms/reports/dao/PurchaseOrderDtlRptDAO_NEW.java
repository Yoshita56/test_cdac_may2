/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         PurchaseOrderDtlRptDAO.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.reports.vo.IssueDetailRptVO_NEW;
import mms.reports.vo.PurchaseOrderDtlRptVO;
import mms.reports.vo.PurchaseOrderDtlRptVO_NEW;

// TODO: Auto-generated Javadoc
/**
 * The Class PurchaseOrderDtlRptDAO.
 */
public class PurchaseOrderDtlRptDAO_NEW {

	/**
	 * Gets the circle list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the circle list
	 */
	public static void getCircleList(PurchaseOrderDtlRptVO_NEW voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		MmsConfigUtil mcu = null;

		String strProcName = "{call PKG_MMS_VIEW.PROC_DISTRICT_NAME_COMBO(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			//mcu = new MmsConfigUtil();
			daoObj = new HisDAO("MMS Transactions", "StockOnHandRptDAO");
			 
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "p_mode", voObj.getStrMode()); // 2
																				// if
																				// userLevel
																				// 1,
																				// 3
																				// if
																				// userLevel
																				// 2
			daoObj.setProcInValue(nProcIndex, "p_country_code",
					voObj.getStrDistrictId() == null
							|| voObj.getStrDistrictId().equals("") ? "0"
							: voObj.getStrDistrictId()); // passing dist_id
			daoObj.setProcInValue(nProcIndex, "p_hosp_code",
					voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_state_code",
					mcu.getStrStateCode());
			daoObj.setProcInValue(nProcIndex, "p_seatid", voObj.getStrSeatId());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrCircleWS(ws);

				if (voObj.getStrCircleWS().next()) {
					voObj.setStrCircleId(voObj.getStrCircleWS().getString(1));
				}
				voObj.getStrCircleWS().beforeFirst();

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("StockOnHandRptDAO.getCircleList() --> "
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
	 * Gets the district list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the district list
	 */
	public static void getDistrictList(PurchaseOrderDtlRptVO_NEW voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		MmsConfigUtil mcu = null;

		String strProcName = "{call PKG_MMS_VIEW.PROC_DISTRICT_NAME_COMBO(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			//mcu = new MmsConfigUtil();
			daoObj = new HisDAO("MMS Transactions", "StockOnHandRptDAO");
			 
			nProcIndex = daoObj.setProcedure(strProcName);

			if (voObj.getStrUserLevel().equals("1")
					|| voObj.getStrUserLevel().equals("2")) {
				voObj.setStrMode("4");
			} else {
				voObj.setStrMode("5");
			}

			daoObj.setProcInValue(nProcIndex, "p_mode", voObj.getStrMode()); // 4
																				// if
																				// userLevel
																				// 1
																				// or
																				// 2,
																				// 5
																				// if
																				// userLevel
																				// 3
			daoObj.setProcInValue(
					nProcIndex,
					"p_country_code",
					voObj.getStrCircleId() == null
							|| voObj.getStrCircleId().equals("") ? "0" : voObj
							.getStrCircleId()); // passing circle_id
			daoObj.setProcInValue(nProcIndex, "p_hosp_code",
					voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_state_code",
					mcu.getStrStateCode());
			daoObj.setProcInValue(nProcIndex, "p_seatid", voObj.getStrSeatId());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrDistrictWS(ws);

				if (voObj.getStrDistrictWS().next()) {
					voObj.setStrDistrictId(voObj.getStrDistrictWS()
							.getString(1));
				}
				voObj.getStrDistrictWS().beforeFirst();

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("StockOnHandRptDAO.getDistrictList() --> "
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
	 * To get District Store Name Combo from the hstt_store_mst
	 * 
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the district store list
	 */
	public static void getDistrictStoreList(PurchaseOrderDtlRptVO_NEW voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("DWH", "BudgetDetailRptDAO");
			 
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", voObj.getStrMode());
			daoObj.setProcInValue(nProcIndex, "seatid", voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code",
					voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeid", "0");
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrDistrictStoreWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("BudgetDetailRptDAO.getStoreList() --> "
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
	 * To get Store Combo from the hstt_store_mst
	 * 
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the store list
	 */
/*	public static void getStoreList(PurchaseOrderDtlRptVO_NEW voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.get_store_based_on_district(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("DWH", "PurchaseOrderDtlRptDAO");
			 
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", voObj.getStrMode());
			daoObj.setProcInValue(nProcIndex, "seatid", voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code",
					voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeid", "0");
			daoObj.setProcInValue(nProcIndex, "storetype_id", (voObj
					.getStrStoreTypeId() == null || voObj.getStrStoreTypeId()
					.equals("")) ? "0" : voObj.getStrStoreTypeId());
			daoObj.setProcInValue(nProcIndex, "cirleid",
					(voObj.getStrCircleId() == null || voObj.getStrCircleId()
							.equals("")) ? "0" : voObj.getStrCircleId());
			daoObj.setProcInValue(nProcIndex, "districtid",
					voObj.getStrDistrictId());

			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

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

			voObj.setStrMsgString("PurchaseOrderDtlRptDAO.getStoreList() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}*/
	public static void getStoreList(PurchaseOrderDtlRptVO_NEW voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.rptm_hstt_store_mst(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","ListConsumablesExpiryDateRptDAO");
		//	
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "item_category", "0",4);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("ws"+ws.size());
			if (ws != null) {
				if (ws.next()) {
					voObj.setStrStoreId(ws.getString(1));

					ws.beforeFirst();
				}
			}

			if (strErr.equals("")) {

				voObj.setStrStoreWs(ws);

							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("ListConsumablesExpiryDateRptDAO.getStoreList() --> "
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
	 * Gets the item cat list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the item cat list
	 */
	/*public static void getItemCatList(PurchaseOrderDtlRptVO_NEW voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		WebRowSet ws = null;
		String proc_name1 = "{call Pkg_Mms_View.proc_hstt_drug_classification(?,?,?,?)}";
		String strErr = "";

		try {

			dao = new HisDAO("mms","PurchaseOrderDtlRptDAO.ItemCategoryCombo(PurchaseOrderDtlRptVO_NEW vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modeval", "1");
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospitalCode());
			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return value
			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object
			dao.executeProcedure(procIndex1);

			// get value
			strErr = dao.getString(procIndex1, "err");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");
			
			
			if (ws != null && ws.size() != 0) {				
				voObj.setStrItemCatWs(ws);
			} 

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("ItemBatchWiseSuppRecDtlRptDAO.getItemCatList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}*/
	
	public static void getItemCatList(PurchaseOrderDtlRptVO_NEW voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		int nprocIndex = 0;
		String strErr = "";
		try
		{daoObj = new HisDAO("mms", "PendingIndentStatusRecordRptDAO");
		String strProcName = "{call pkg_mms_rpt.Rptm_item_category_list(?,?,?,?,?)}";
		nprocIndex = daoObj.setProcedure(strProcName);
		daoObj.setProcInValue(nprocIndex, "modeval","2",1);
		daoObj.setProcInValue(nprocIndex, "hosp_code", voObj.getStrHospitalCode(),2);
		daoObj.setProcInValue(nprocIndex, "storeId",voObj.getStrStoreId(),3);							
		daoObj.setProcOutValue(nprocIndex, "err", 1,4);
		daoObj.setProcOutValue(nprocIndex, "resultset", 2,5); 
		
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

			voObj
					.setStrMsgString("StockReceiptRegisterRptDAO.getItemCatList() --> "
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
	 * Gets the PO type list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the PO type list
	 */
	public static void getPOTypeList(PurchaseOrderDtlRptVO_NEW voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.Rptm_potype_List(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "PurchaseOrderDtlRptDAO");
			 
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code",
					voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "store_Id", voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "item_cat",
					"10");
			daoObj.setProcInValue(nProcIndex, "req_For", voObj.getStrReqFor());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			
			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrPOTypeWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("PurchaseOrderDtlRptDAO.getPOTypeList() --> "
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
	 * Gets the supplier list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the supplier list
	 */
	/*public static void getSupplierList(PurchaseOrderDtlRptVO_NEW voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			if (voObj.getStrUserLevel().equals("2")) {
				voObj.setStrMode("1");
			} else
				voObj.setStrMode("12");

			daoObj = new HisDAO("MMS Transactions", "PurchaseOrderDtlRptDAO");
			 
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeVal", voObj.getStrMode());
			daoObj.setProcInValue(nProcIndex, "catCode", "10");
			daoObj.setProcInValue(nProcIndex, "branditem_id",
					voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "contractType", "0");
			daoObj.setProcInValue(nProcIndex, "hosp_code",
					voObj.getStrHospitalCode());

			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrSupplierWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("PurchaseOrderDtlRptDAO.getSupplierList() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	*/
	public static void getSupplierList(PurchaseOrderDtlRptVO_NEW voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","PurchaseOrderDtlRptDAO");
		//
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeVal", "1",1);
			daoObj.setProcInValue(nProcIndex, "catCode", voObj.getStrItemCatNo(),2);
			daoObj.setProcInValue(nProcIndex, "branditem_id", voObj.getStrSeatId(),3);
			daoObj.setProcInValue(nProcIndex, "contractType", "0",4);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),5);
			daoObj.setProcOutValue(nProcIndex, "err", 1,6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				//System.out.println("ws"+ws.size());
				voObj.setStrSupplierWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("PurchaseOrderDtlRptDAO.getSupplierList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	public static void getFinancialYearCombo(PurchaseOrderDtlRptVO_NEW voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_financial_year_list(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("DWH", "PurchaseOrderDtlRptDAO");
			 
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "4");
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "demandStrId", "0");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null) {
				strErr = "";
			}

			if (strErr.equals("")) {
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				//System.out.println("ws"+ws.size());
				voObj.setFinancialYearWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("PurchaseOrderDtlRptDAO.getFinancialYearCombo() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getProgrammeCombo(PurchaseOrderDtlRptVO_NEW vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try 
		{
			
			dao = new HisDAO("mms", "PurchaseOrderDtlRptDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_programme_list(?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "storeid", "0");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "seatid", vo.getStrSeatId());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);

			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");

			if (strerr.equals("")) 
			{
				vo.setStrProgNameComboWS(wb);

			} 
			else 
			{
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("ItemBatchWiseSuppRecDtlRptDAO.programmeCombo() --> "
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
