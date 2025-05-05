/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         LocationWiseStockSummaryRptDAO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.reports.vo.LocationWiseStockSummaryRptVO;

// TODO: Auto-generated Javadoc
/**
 * The Class LocationWiseStockSummaryRptDAO.
 */
public class LocationWiseStockSummaryRptDAO {

	/**
	 * Gets the circle list.
	 * 
	 * @param voObj the vo obj
	 */
	public static void getCircleList(LocationWiseStockSummaryRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		MmsConfigUtil mcu = null;

		String strProcName = "{call PKG_MMS_VIEW.PROC_DISTRICT_NAME_COMBO(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			
			daoObj = new HisDAO("MMS Transactions", "LocationWiseStockSummaryRptDAO");
			
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

			voObj.setStrMsgString("LocationWiseStockSummaryRptDAO.getCircleList() --> " + e.getMessage());
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
	public static void getDistrictList(LocationWiseStockSummaryRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		MmsConfigUtil mcu = null;

		String strProcName = "{call PKG_MMS_VIEW.PROC_DISTRICT_NAME_COMBO(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			
			daoObj = new HisDAO("MMS Transactions", "LocationWiseStockSummaryRptDAO");
			
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

			voObj.setStrMsgString("LocationWiseStockSummaryRptDAO.getDistrictList() --> " + e.getMessage());
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
	public static void getStoreTypeList(LocationWiseStockSummaryRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call PKG_MMS_VIEW.proc_institute_type_list(?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("MMS Transactions", "LocationWiseStockSummaryRptDAO");
			
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

			voObj.setStrMsgString("LocationWiseStockSummaryRptDAO.getStoreTypeList() --> " + e.getMessage());
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
	public static void getDwhTypeCombo(LocationWiseStockSummaryRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_sstt_dwh_type_mst_cmb(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			
			daoObj = new HisDAO("DWH", "LocationWiseStockSummaryRptDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);			
			daoObj.setProcInValue(nProcIndex, "p_mode", "1");			
			daoObj.setProcInValue(nProcIndex, "p_gnum_hospital_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_sstnum_is_district_dwh", (voObj.getStrStoreTypeId() == null || voObj.getStrStoreTypeId().equals(""))? "0" : voObj.getStrStoreTypeId());
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

			voObj.setStrMsgString("LocationWiseStockSummaryRptDAO.getStoreList() --> " + e.getMessage());
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
	public static void getDwhSubTypeCombo(LocationWiseStockSummaryRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_sstt_dwh_type_mst_cmb(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("DWH", "StockOnHandRptDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "p_mode", "8");
			daoObj.setProcInValue(nProcIndex, "p_gnum_hospital_code",voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_sstnum_is_district_dwh",voObj.getStrStoreId());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);			
			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				
				voObj.setStrStoreTypeWS(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("StockOnHandRptDAO.getStoreList() --> "
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
	 * To get Drug Store Type Combo.
	 * 
	 * @param voObj the vo obj
	 */
	public static void getSubDwhTypeCombo(LocationWiseStockSummaryRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_sstt_dwh_type_mst_cmb(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			
			daoObj = new HisDAO("DWH", "LocationWiseStockSummaryRptDAO");
			
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

			voObj.setStrMsgString("LocationWiseStockSummaryRptDAO.getStoreList() --> " + e.getMessage());
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
	public static void getDistrictStoreList(LocationWiseStockSummaryRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("DWH", "BudgetDetailRptDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "13");
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

				voObj.setStrStoreWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

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
	public static void getStoreList(LocationWiseStockSummaryRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.get_store_based_on_district(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("DWH", "LocationWiseStockSummaryRptDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
			
			

			daoObj.setProcInValue(nProcIndex, "modeval", voObj.getStrMode());
			daoObj.setProcInValue(nProcIndex, "seatid", voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeid", "0");
			daoObj.setProcInValue(nProcIndex, "storetype_id",
					voObj.getStrStoreTypeId() == null || voObj.getStrStoreTypeId().equals("") ? "0" : voObj.getStrStoreTypeId());
			daoObj.setProcInValue(nProcIndex, "cirleid",
					voObj.getStrCircleId() == null || voObj.getStrCircleId().equals("") ? "0" : voObj.getStrCircleId());
			daoObj.setProcInValue(nProcIndex, "districtid",
					voObj.getStrDistrictId() == null || voObj.getStrDistrictId().equals("") ? "0" : voObj.getStrDistrictId());

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

			voObj.setStrMsgString("LocationWiseStockSummaryRptDAO.getStoreList() --> " + e.getMessage());
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
	public static void getSubStoreList(LocationWiseStockSummaryRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.get_store_based_on_district(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("DWH", "LocationWiseStockSummaryRptDAO");
			
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

			voObj.setStrMsgString("LocationWiseStockSummaryRptDAO.getStoreList() --> " + e.getMessage());
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
	public static void getItemCatList(LocationWiseStockSummaryRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.Rptm_item_category_list(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "LocationWiseStockSummaryRptDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "storeId", "0");
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

				voObj.setStrItemCatWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
            e.printStackTrace();
			voObj.setStrMsgString("LocationWiseStockSummaryRptDAO.getItemCatList() --> " + e.getMessage());
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
	public static void getGroupList(LocationWiseStockSummaryRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.rptm_store_group_list(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "LocationWiseStockSummaryRptDAO");
			
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

			voObj.setStrMsgString("LocationWiseStockSummaryRptDAO.getGroupList() --> " + e.getMessage());
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
	public static void getDrugList(LocationWiseStockSummaryRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_RPT.rptm_itembrand_list(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			
			// //passing Alphabet
		

			daoObj = new HisDAO("MMS Transactions", "LocationWiseStockSummaryRptDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "4");
			daoObj.setProcInValue(nProcIndex, "catcode", voObj.getStrCatgId());
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
			e.printStackTrace();
			voObj.setStrMsgString("LocationWiseStockSummaryRptDAO.getDrugList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * Gets the drug classification value.
	 * 
	 * @param vo the vo
	 */
	public static void getDrugClassificationValue(LocationWiseStockSummaryRptVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("MMS", "DrugMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.drug.classification");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			web = dao.executeQry(nQueryIndex);
			vo.setDrugClassWs(web);
		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("LocationWiseStockSummaryRptDAO.getDrugClassificationValue() --> " + e.getMessage());
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
	 * Gets the user level.
	 * 
	 * @param voObj the vo obj
	 */
	public static void getUserLevel(LocationWiseStockSummaryRptVO voObj) {
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.get_userlevel_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "LocationWiseStockSummaryRptDAO");
			
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
	public static void getItemTypeValues(LocationWiseStockSummaryRptVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("MMS", "LocationWiseStockSummaryRptDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.drugbrand.itemtype.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, "10");

			web = dao.executeQry(nQueryIndex);

			vo.setItemTypeWs(web);

		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("LocationWiseStockSummaryRptDAO.getItemValues() --> " + e.getMessage());
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
	public static void getStoreListForViewPrint(LocationWiseStockSummaryRptVO vo) {
		String err = "";
		String strProcName = "{call PKG_MMS_RPT.PROC_LOCATION_STOCK_HAND_DTL(?,?,?,?,?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		try {
			dao = new HisDAO("mms", "LocationWiseStockSummaryRptDAO.GetSoreNameCombo(LocationWiseStockSummaryRptVO vo)");
			procIndex1 = dao.setProcedure(strProcName);
			// set value

			dao.setProcInValue(procIndex1, "modeval", "1");
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "p_circle_id", vo.getStrCircleId());
			dao.setProcInValue(procIndex1, "p_district_id", vo.getStrDistrictId());
			dao.setProcInValue(procIndex1, "p_hstnum_store_id", vo.getStrDistrictStoreId());
			dao.setProcInValue(procIndex1, "p_dwh_type_id", vo.getStrItemBrandId()); // As DW_TYPE
			dao.setProcInValue(procIndex1, "p_itembrand_id", vo.getStrItemId());
			dao.setProcInValue(procIndex1, "p_drug_class", "0");
			//dao.setProcInValue(procIndex1, "prgid", "0");
			dao.setProcInValue(procIndex1, "stockstatus", "0");	
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
			vo.setStrMsgString("LocationWiseStockSummaryRptDAO.GetStoreListForViewPrint() --> " + e.getMessage());
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
	public static void GetVitalDrugDtlPrint(LocationWiseStockSummaryRptVO vo) {
		String err = "";
		String strProcName = "{call PKG_MMS_RPT.PROC_LOCATION_STOCK_HAND_DTL(?,?,?,?,?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		try {

			
			dao = new HisDAO("mms", "LocationWiseStockSummaryRptDAO.GetSoreNameCombo(LocationWiseStockSummaryRptVO vo)");

			procIndex1 = dao.setProcedure(strProcName);

			if (vo.getStrBatchWiseChkFlg().equals("1")) {
				dao.setProcInValue(procIndex1, "modeval", "3"); // Batch Wise
			} else {
				dao.setProcInValue(procIndex1, "modeval", "2"); // Without Batch
			}
		
			dao.setProcInValue(procIndex1, "hosp_code", 		vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "p_circle_id", 		vo.getStrCatgId());
			dao.setProcInValue(procIndex1, "p_district_id", 	"0");
			dao.setProcInValue(procIndex1, "p_hstnum_store_id", vo.getStrDistrictStoreId());
			dao.setProcInValue(procIndex1, "p_dwh_type_id", 	vo.getStrItemBrandId()); // As DW_TYPE
			dao.setProcInValue(procIndex1, "p_itembrand_id", 	vo.getStrItemId());
			dao.setProcInValue(procIndex1, "p_drug_class", 		vo.getStrCatgId());			
			dao.setProcInValue(procIndex1, "p_stkstatus", 		vo.getStrStatusId());			
			dao.setProcOutValue(procIndex1, "err", 				1); // 1 for string return
			dao.setProcOutValue(procIndex1, "resultset", 		2); // 2 for object
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
			vo.setStrMsgString("LocationWiseStockSummaryRptDAO.GetVitalDrugDtlPrint() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	
	/**
	 * Gets the programme combo.
	 * 
	 * @param vo
	 *            the vo
	 * @return the programme combo
	 */
	public static void getProgrammeCombo(LocationWiseStockSummaryRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_programme_list(?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);			
			
			dao.setProcInValue(nprocIndex, "modeval", "2");
			dao.setProcInValue(nprocIndex, "storeid", vo.getStrStoreId().split("\\^")[0]);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "seatid", vo.getStrSeatId());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);

			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");

			
			if (strerr.equals("")) {

				vo.setStrProgNameComboWS(wb);

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("LocationWiseStockSummaryRptDAO.getProgrammeCombo() --> "	+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

}