/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         StockSummaryDateWiseRptDAO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.reports.vo.ConsolidatedChallanVO_NEW;
import mms.reports.vo.StockSummaryDateWiseRptVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StockSummaryDateWiseRptDAO.
 */
public class StockSummaryDateWiseRptDAO {

	/**
	 * Gets the circle list.
	 * 
	 * @param voObj the vo obj
	 */
	public static void getCircleList(StockSummaryDateWiseRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		MmsConfigUtil mcu = null;

		String strProcName = "{call PKG_MMS_VIEW.PROC_DISTRICT_NAME_COMBO(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			//mcu = new MmsConfigUtil();
			daoObj = new HisDAO("MMS Reports", "StockSummaryDateWiseRptDAO");
			 
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "p_mode", voObj.getStrMode()); // 2
																				// if
																				// userLevel
																				// 1,
																				// 3
																				// if
																				// userLeve
																				// 2
			daoObj.setProcInValue(nProcIndex, "p_seatid", voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "p_hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_state_code", mcu.getStrStateCode());
			daoObj.setProcInValue(nProcIndex, "p_country_code",
					voObj.getStrDistrictId() == null || voObj.getStrDistrictId().equals("") ? "0" : voObj.getStrDistrictId()); // passing dist_id
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null) {
				strErr = "";
			}

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

			voObj.setStrMsgString("StockSummaryDateWiseRptDAO.getCircleList() --> " + e.getMessage());
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
	 * @param voObj the vo obj
	 */
	public static void getDistrictList(StockSummaryDateWiseRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		MmsConfigUtil mcu = null;

		String strProcName = "{call PKG_MMS_VIEW.PROC_DISTRICT_NAME_COMBO(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			//mcu = new MmsConfigUtil();
			daoObj = new HisDAO("MMS Reports", "StockSummaryDateWiseRptDAO");
			 
			nProcIndex = daoObj.setProcedure(strProcName);

			if (voObj.getStrUserLevel().equals("1") || voObj.getStrUserLevel().equals("2")) {
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
			daoObj.setProcInValue(nProcIndex, "p_seatid", voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "p_hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_state_code", mcu.getStrStateCode());
			daoObj.setProcInValue(nProcIndex, "p_country_code",
					voObj.getStrCircleId() == null || voObj.getStrCircleId().equals("") ? "0" : voObj.getStrCircleId()); // passing circle_id
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null) {
				strErr = "";
			}

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrDistrictWS(ws);

				if (voObj.getStrDistrictWS().next()) {
					voObj.setStrDistrictId(voObj.getStrDistrictWS().getString(1));
				}
				voObj.getStrDistrictWS().beforeFirst();

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("StockSummaryDateWiseRptDAO.getDistrictList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	/**
	 * Gets the store type list.
	 * 
	 * @param voObj the vo obj
	 */
	public static void getStoreTypeList(StockSummaryDateWiseRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call PKG_MMS_VIEW.proc_institute_type_list(?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("MMS Reports", "StockSummaryDateWiseRptDAO");
			 
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "ERR", 1); // 1 for string return
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2); // 2 for object
			daoObj.executeProcedure(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "ERR");

			if (strErr == null) {
				strErr = "";
			}

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				voObj.setStrStoreTypeWS(ws);
				while (ws.next()) {
					voObj.setStrStoreTypeId(ws.getString(1));
				}
				ws.beforeFirst();

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("StockSummaryDateWiseRptDAO.getStoreTypeList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * To get Drug Store Type Combo.
	 * 
	 * @param voObj the vo obj
	 */
	public static void getDwhTypeCombo(StockSummaryDateWiseRptVO voObj) {
		
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("DWH", "StockSummaryDateWiseRptDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "8");
			daoObj.setProcInValue(nProcIndex, "seatid", voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeid", "0");
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null) {
				strErr = "";
			}

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				

				voObj.setStrStoreTypeWS(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("StockSummaryDateWiseRptDAO.getStoreList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	/**
	 * To get Drug Store Type Combo.
	 * 
	 * @param voObj the vo obj
	 */
	public static void getDwhSubTypeCombo(StockSummaryDateWiseRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_VIEW.proc_sstt_dwh_type_mst_cmb(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("DWH", "StockSummaryDateWiseRptDAO");
			 
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "p_mode", "3");
			daoObj.setProcInValue(nProcIndex, "p_gnum_hospital_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_sstnum_is_district_dwh", voObj.getStrStoreTypeId());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null) {
				strErr = "";
			}

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrStoreTypeWS(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("StockSummaryDateWiseRptDAO.getStoreList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	/**
	 * To get Drug Store Type Combo.
	 * 
	 * @param voObj the vo obj
	 */
	public static void getSubDwhTypeCombo(StockSummaryDateWiseRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_sstt_dwh_type_mst_cmb(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("DWH", "StockSummaryDateWiseRptDAO");
			 
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "p_mode", "2");
			daoObj.setProcInValue(nProcIndex, "p_gnum_hospital_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_sstnum_is_district_dwh", "0");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null) {
				strErr = "";
			}

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrStoreTypeWS(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("StockSummaryDateWiseRptDAO.getStoreList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	/**
	 * To get District Store Name Combo from the hstt_store_mst.
	 * 
	 * @param voObj the vo obj
	 */
	public static void getDistrictStoreList(StockSummaryDateWiseRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("DWH", "BudgetDetailRptDAO");
			 
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "21");
			daoObj.setProcInValue(nProcIndex, "seatid", voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeid", "0");
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null) {
				strErr = "";
			}

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrDistrictStoreWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("BudgetDetailRptDAO.getStoreList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	/**
	 * To get Store Combo from the hstt_store_mst.
	 * 
	 * @param voObj the vo obj
	 */
	

	/**
	 * To get Store Combo from the hstt_store_mst.
	 * 
	 * @param voObj the vo obj
	 */
	public static void getSubStoreList(StockSummaryDateWiseRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.get_store_based_on_district(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("DWH", "StockSummaryDateWiseRptDAO");
			 
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", voObj.getStrMode());
			daoObj.setProcInValue(nProcIndex, "seatid", voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeid", voObj.getStrDistrictStoreId().split("\\^")[0]);
			daoObj.setProcInValue(nProcIndex, "storetype_id", voObj.getStrStoreTypeId());
			daoObj.setProcInValue(nProcIndex, "cirleid", voObj.getStrCircleId());
			daoObj.setProcInValue(nProcIndex, "districtid", voObj.getStrDistrictId());

			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null) {
				strErr = "";
			}

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrStoreWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("StockSummaryDateWiseRptDAO.getStoreList() --> " + e.getMessage());
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
	 * @param voObj the vo obj
	 */
	public static void getItemCatList(StockSummaryDateWiseRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.Rptm_item_category_list(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Reports", "StockSummaryDateWiseRptDAO");
			 
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStoreId());
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

				voObj.setStrItemCatWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("StockSummaryDateWiseRptDAO.getItemCatList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	/**
	 * Gets the group list.
	 * 
	 * @param voObj the vo obj
	 */
	public static void getGroupList(StockSummaryDateWiseRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.rptm_store_group_list(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Reports", "StockSummaryDateWiseRptDAO");
			 
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "item_category", voObj.getStrItemCatId() == null ? "10" : voObj.getStrItemCatId());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null) {
				strErr = "";
			}

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				voObj.setStrGroupCmbWS(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("StockSummaryDateWiseRptDAO.getGroupList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	public static void getDrugList1(StockSummaryDateWiseRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_RPT.rptm_itembrand_list(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";
		try {

			// //passing Alphabet
			
			daoObj = new HisDAO("MMS Transactions", "StockSummaryDateWiseRptDAO");
			 
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "catCode", voObj.getStrItemCatNo());
			daoObj.setProcInValue(nProcIndex, "groupid", "0");
			daoObj.setProcInValue(nProcIndex, "subgrpid", "0"); // passing Alphabet
			daoObj.setProcInValue(nProcIndex, "hosp_code", "100");
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
				voObj.setStrDrugWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			
			voObj.setStrMsgString("StockSummaryDateWiseRptDAO.getDrugList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * Gets the drug list.
	 * 
	 * @param voObj the vo obj
	 */
	public static void getDrugList(StockSummaryDateWiseRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_RPT.rptm_itembrand_list(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";
		try {

			// //passing Alphabet
			
			daoObj = new HisDAO("MMS Transactions", "StockSummaryDateWiseRptDAO");
			 
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "4");
			daoObj.setProcInValue(nProcIndex, "catCode", voObj.getStrItemCatNo());
			daoObj.setProcInValue(nProcIndex, "groupid", "0");
			daoObj.setProcInValue(nProcIndex, "subgrpid", voObj.getStrAlphabet()); // passing Alphabet
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null) {
				strErr = "";
			}

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrDrugWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("StockSummaryDateWiseRptDAO.getDrugList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * Gets the user level.
	 * 
	 * @param voObj the vo obj
	 */
	public static void getUserLevel(StockSummaryDateWiseRptVO voObj) {
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.get_userlevel_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Reports", "StockSummaryDateWiseRptDAO");
			 
			nProcIndex = daoObj.setProcedure(strProcName);

			
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hospCode", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null) {
				strErr = "";
			}

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrUserlevelWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("DailyActivityRptDAO.getUserLevel() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * Gets the item type values.
	 * 
	 * @param vo the vo
	 */
	public static void getItemTypeValues(StockSummaryDateWiseRptVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("MMS", "StockSummaryDateWiseRptDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.drugbrand.itemtype.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, "10");

			web = dao.executeQry(nQueryIndex);

			vo.setItemTypeWs(web);

		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("StockSummaryDateWiseRptDAO.getItemValues() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
			}
			dao = null;
			web = null;
		}
	}

	/**
	 * This Method is Used to Get Indent Item List from.
	 * 
	 * @param vo the vo
	 */
	public static void getStoreListForViewPrint(StockSummaryDateWiseRptVO vo) {
		String err = "";
		String strProcName = "{call PKG_MMS_RPT.PROC_STOCK_HAND_DTL_DATE(?,?,?,?,?, ?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		try {
			dao = new HisDAO("mms", "StockSummaryDateWiseRptDAO.GetSoreNameCombo(StockSummaryDateWiseRptVO vo)");
			procIndex1 = dao.setProcedure(strProcName);

			// set value
			
				
			
			dao.setProcInValue(procIndex1, "modeval", "1");
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "p_circle_id", vo.getStrCircleId());
			dao.setProcInValue(procIndex1, "p_district_id", vo.getStrDistrictId());
			dao.setProcInValue(procIndex1, "p_hstnum_store_id", vo.getStrStoreTypeId());
			dao.setProcInValue(procIndex1, "p_dwh_type_id", vo.getStrStoreTypeId()); // As DW_TYPE
			dao.setProcInValue(procIndex1, "p_itembrand_id","0");
			dao.setProcInValue(procIndex1, "stockDate", "0");
			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object
			// execute procedure
			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null) {
				err = "";
			}

			ws = dao.getWebRowSet(procIndex1, "resultset");
			vo.setStrHeaderWS(ws);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("StockSummaryDateWiseRptDAO.GetStoreListForViewPrint() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}

	/**
	 * This Method is Used to Get Indent Item List from.
	 * 
	 * @param vo the vo
	 */
	public static void getStockDtlDateWisePrint(StockSummaryDateWiseRptVO vo) {
		String err = "";
		String strProcName = "{call PKG_MMS_RPT.PROC_STOCK_HAND_DTL_DATE(?,?,?,?,?, ?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		try {

			dao = new HisDAO("mms", "StockSummaryDateWiseRptDAO.getStockDtlDateWisePrint(StockSummaryDateWiseRptVO vo)");

			procIndex1 = dao.setProcedure(strProcName);

				
			dao.setProcInValue(procIndex1, "modeval", "2"); // Without Batch
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "p_circle_id", vo.getStrCircleId());
			dao.setProcInValue(procIndex1, "p_district_id", vo.getStrDistrictId());
			dao.setProcInValue(procIndex1, "p_hstnum_store_id", vo.getStrStoreTypeId());
			dao.setProcInValue(procIndex1, "p_dwh_type_id", vo.getStrItemBrandId()); // As DW_TYPE
			dao.setProcInValue(procIndex1, "p_itembrand_id", vo.getStrItemId());
			dao.setProcInValue(procIndex1, "stockDate", vo.getStrDate());
			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object
			// execute procedure
			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null) {
				err = "";
			}

			ws = dao.getWebRowSet(procIndex1, "resultset");
			vo.setStrDrugListWS(ws);

		} catch (Exception e) {
			 e.printStackTrace();
			vo.setStrMsgString("StockSummaryDateWiseRptDAO.getStockDtlDateWisePrint() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}

	public static void getStoreList(StockSummaryDateWiseRptVO voObj) {

		/*HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.rptm_hstt_store_mst(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","StockOnHandRptDAO");
	//		 
			nProcIndex = daoObj.setProcedure(strProcName);
			
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "seatid", voObj.getStrSeatId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "item_category", "10",4);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";*/
		HisDAO daoObj = null;
		WebRowSet ws = null;

	//	String strProcName = "{call Pkg_Mms_View.poc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nprocIndex = 0;
	
		String strErr = "";

		try{
			daoObj = new HisDAO("MMS Transactions","StockOnHandRptDAO");
			String strproc_name = "{call pkg_mms_rpt.rptm_hstt_store_mst(?,?,?,?,?,?)}";
		nprocIndex = daoObj.setProcedure(strproc_name);
		
		daoObj.setProcInValue(nprocIndex, "modeval","1",1);
		daoObj.setProcInValue(nprocIndex, "seatid",voObj.getStrSeatId(),2);
		daoObj.setProcInValue(nprocIndex, "hosp_code", voObj.getStrHospitalCode(),3);
		daoObj.setProcInValue(nprocIndex, "item_category", "10",4);
		daoObj.setProcOutValue(nprocIndex, "err", 1,5);
		daoObj.setProcOutValue(nprocIndex, "resultset", 2,6); 
		daoObj.executeProcedureByPosition(nprocIndex);
		strErr = daoObj.getString(nprocIndex, "err");
			strErr = daoObj.getString(nprocIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nprocIndex, "resultset");
					//System.out.println("ws.size()"+ws.size());
					voObj.setStrStoreWs(ws);
			
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("StockOnHandRptDAO.getStoreList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
}
