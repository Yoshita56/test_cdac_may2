/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         StockOnHandRptDAO.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.dao;
import javax.sql.rowset.WebRowSet;
import hisglobal.transactionmgnt.HisDAO;
import mms.MmsConfigUtil;
import mms.reports.vo.StockOnHandIgimsRptVO;
import mms.reports.vo.StockOnHandRptVO_NEW;

public class StockOnHandIgimsRptDAO {

	/**
	 * To get Store Combo from the hstt_store_mst
	 * 
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the store list
	 */
	public static void getStoreList(StockOnHandIgimsRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws  = null;
	
		int nprocIndex = 0;
	
		String strErr = "";

		try{
			daoObj = new HisDAO("MMS Transactions","StockOnHandRptDAO");
		
		String strproc_name = "{call pkg_mms_rpt.rptm_hstt_store_mst(?,?,?, ?,?,?)}";
		
		nprocIndex = daoObj.setProcedure(strproc_name);
		
		daoObj.setProcInValue(nprocIndex, "modeval","9",1);
		daoObj.setProcInValue(nprocIndex, "seatid",voObj.getStrSeatId(),2);
		daoObj.setProcInValue(nprocIndex, "hosp_code", voObj.getStrHospitalCode(),3);
		daoObj.setProcInValue(nprocIndex, "item_category", "10",4);
		daoObj.setProcOutValue(nprocIndex, "err", 1,5);
		daoObj.setProcOutValue(nprocIndex, "resultset", 2,6);
		
		daoObj.executeProcedureByPosition(nprocIndex);
		
		strErr = daoObj.getString(nprocIndex, "err");

		if (strErr == null)
			strErr = "";

		if (strErr.equals("")) {

			ws = daoObj.getWebRowSet(nprocIndex, "resultset");
			System.out.println("ws.size()"+ws.size());
			voObj.setStrStoreWs(ws);
		} else {
			throw new Exception(strErr);
		}

		} catch (Exception e) {

			voObj.setStrMsgString("StockOnHandRptDAO.getStoreList() --> "+ e.getMessage());
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
	public static void getItemCatList(StockOnHandIgimsRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.Rptm_item_category_list(?::character varying,?::character varying,?::character varying,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","ListBlackListedSupplierRptDAO");
			//
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", MmsConfigUtil.GLOBAL_HOSPITAL_CODE,2);
			daoObj.setProcInValue(nProcIndex, " storeId","",3);
			daoObj.setProcOutValue(nProcIndex, "err", 1,4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,5);

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

			voObj
					.setStrMsgString("StockOnHandRptDAO.getItemCatList() --> "
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
	 * Gets the circle list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the circle list
	 */
	public static void getCircleList(StockOnHandIgimsRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		MmsConfigUtil mcu = null;

		String strProcName = "{call PKG_MMS_VIEW.PROC_DISTRICT_NAME_COMBO(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			//mcu = new MmsConfigUtil();
			daoObj = new HisDAO("MMS Transactions", "StockOnHandRptDAO");
			//
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "p_mode", voObj.getStrMode()); // 2
																				// if
																				// userLevel
																				// 1,
																				// 3
																				// if
																				// userLeve
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
	public static void getDistrictList(StockOnHandIgimsRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		MmsConfigUtil mcu = null;

		String strProcName = "{call PKG_MMS_VIEW.PROC_DISTRICT_NAME_COMBO(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			//mcu = new MmsConfigUtil();
			daoObj = new HisDAO("MMS Transactions", "StockOnHandRptDAO");
			//
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
	 * Gets the store type list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the store type list
	 */
	/*public static void getStoreTypeList(StockOnHandIgimsRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call PKG_MMS_VIEW.proc_institute_type_list(?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("MMS Transactions", "StockOnHandRptDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "hosp_code",
					voObj.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "ERR", 1); // 1 for string return
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2); // 2 for object
			daoObj.executeProcedure(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "ERR");

			if (strErr == null)
				strErr = "";

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

			voObj.setStrMsgString("StockOnHandRptDAO.getStoreTypeList() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}*/

	/**
	 * To get Drug Store Type Combo
	 * 
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the dwh type combo
	 */
	public static void getDwhTypeCombo(StockOnHandIgimsRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_sstt_dwh_type_mst_cmb(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("DWH", "StockOnHandRptDAO");
			//
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "p_mode", "7");
			daoObj.setProcInValue(nProcIndex, "p_gnum_hospital_code",voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_sstnum_is_district_dwh",voObj.getStrStoreId().split("\\^")[0]);
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


	
	
	/*
	public static void getStoreList(StockOnHandIgimsRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.get_store_based_on_district(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("DWH", "StockOnHandRptDAO");
			//
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
	 * To get Store Combo from the hstt_store_mst
	 * 
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the sub store list
	 */
	public static void getSubStoreList(StockOnHandIgimsRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.get_store_based_on_district(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("DWH", "StockOnHandRptDAO");
			//
			nProcIndex = daoObj.setProcedure(strProcName);			

			daoObj.setProcInValue(nProcIndex, "modeval", voObj.getStrMode());
			daoObj.setProcInValue(nProcIndex, "seatid", voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code",voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeid", voObj.getStrDistrictStoreId().split("\\^")[0]);
			daoObj.setProcInValue(nProcIndex, "storetype_id",voObj.getStrStoreTypeId());
			daoObj.setProcInValue(nProcIndex, "cirleid", voObj.getStrCircleId());
			daoObj.setProcInValue(nProcIndex, "districtid",	voObj.getStrDistrictId());
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
			
			if (voObj.getStrStoreWs().next()) {
				voObj.setStrDistrictStoreId(voObj.getStrStoreWs().getString(1));
			}
			voObj.getStrStoreWs().beforeFirst();

		} catch (Exception e) {
            e.printStackTrace();
			voObj.setStrMsgString("StockOnHandRptDAO.getStoreList() --> "+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	
	/*public static void getItemCatList(StockOnHandIgimsRptVO voObj) {

		HisDAO dao = null;
		int procIndex1 = 0;
		WebRowSet ws = null;
		String proc_name1 = "{call Pkg_Mms_View.proc_hstt_drug_classification(?,?,?,?)}";
		String strErr = "";

		try {

			dao = new HisDAO("mms","IndentTransADDDAO.ItemCategoryCombo(IndentTransADDVO vo)");

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
			voObj.setStrMsgString("StockOnHandRptDAO.getItemCatList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
-*/
	/**
	 * Gets the group list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the group list
	 */
	public static void getGroupList(StockOnHandIgimsRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.rptm_store_group_list(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "StockOnHandRptDAO");
			//
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code","100");
			daoObj.setProcInValue(nProcIndex, "item_category",voObj.getStrItemCatId());// voObj
					
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				//System.out.println("ws"+ws.size());
				voObj.setStrGroupCmbWS(ws);
				

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("StockOnHandRptDAO.getGroupList() --> "
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
	 * Gets the drug list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the drug list
	 */
	public static void getDrugList(StockOnHandIgimsRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_get_Drug_list_Combo1(?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";



		try {
			daoObj = new HisDAO("MMS Transactions", "StockOnHandRptDAO");
		
			String storeid=voObj.getStrStoreId().equals("")||voObj.getStrStoreId()==null?"0":voObj.getStrStoreId();
			String stock_status_code=(voObj.getStrStatusId() == null || voObj.getStrStatusId().equals("")) ? "0" : voObj.getStrStatusId();
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "p_mode", "4");
			daoObj.setProcInValue(nProcIndex, "p_hstnum_store_id",voObj.getStrStoreId().equals("")||voObj.getStrStoreId()==null?"0":voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "p_hstnum_item_id", "0");
			daoObj.setProcInValue(nProcIndex, "p_hstnum_itembrand_id", "0");
			daoObj.setProcInValue(nProcIndex, "p_hststr_batch_no", "0");
			daoObj.setProcInValue(nProcIndex, "p_gnum_hospital_code",voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_sstnum_item_cat_no",voObj.getStrItemCatId());
			daoObj.setProcInValue(nProcIndex, "p_hstnum_stock_status_code",stock_status_code);
			daoObj.setProcInValue(nProcIndex, "p_hstnum_group_id",voObj.getStrGroupId());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			daoObj.executeProcedure(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");
			//System.out.println("storeid"+storeid+"\nstock_status_code"+stock_status_code+"\nvoObj.getStrGroupId()"+voObj.getStrGroupId());
			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				//System.out.println("no of item"+ws.size());
				voObj.setStrDrugWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			e.printStackTrace();
			voObj.setStrMsgString("StockOnHandRptDAO.getDrugList() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	
	/*public static void getDrugList(StockOnHandIgimsRptVO vo) {
		String strProcName = "{call Pkg_Mms_Rpt.rptm_itembrand_list(?,?,?,?,?,?,?)}";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {
			daoObj = new HisDAO("Item Location", "StockOnHandRptDAO_NEW");
			//
			nProcIndex = daoObj.setProcedure(strProcName);

		
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "catCode",vo.getStrItemCatId(),2);
			daoObj.setProcInValue(nProcIndex, "groupid", vo.getStrGroupId(),3);
			daoObj.setProcInValue(nProcIndex, "subgrpid", "0",4);
			daoObj.setProcInValue(nProcIndex, "hosp_code","100",5);
			//daoObj.setProcInValue(nProcIndex, "drug_class", "0");
			daoObj.setProcOutValue(nProcIndex, "err", 1,6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			
			System.out.println("ws item name "+ws.size());
			if (strErr.equals("")) {
				//vo.setItemIdWS(ws);
				vo.setStrDrugWs(ws);
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("ListItemWiseSupplierRptDAO.ItemName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
*/
	public static void GetUserLevel(StockOnHandIgimsRptVO voObj) {
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.get_userlevel_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "StockOnHandRptDAO");
			//
			nProcIndex = daoObj.setProcedure(strProcName);

			
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hospCode",
					voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				voObj.setStrUserlevelWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("DailyActivityRptDAO.getUserLevel() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void getItemTypeValues(StockOnHandIgimsRptVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("MMS", "StockOnHandRptDAO");
			strQuery = mms.qryHandler_mms.getQuery(1,
					"select.drugbrand.itemtype.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, "100");
			dao.setQryValue(nQueryIndex, 2, vo.getStrItemCatId());

			web = dao.executeQry(nQueryIndex);
			System.out.println("web"+web.size());
			vo.setItemTypeWs(web);

		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("StockOnHandRptDAO.getItemValues() --> "
					+ e.getMessage());
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
	 * Gets the programme combo.
	 * 
	 * @param vo
	 *            the vo
	 * @return the programme combo
	 */
	public static void getProgrammeCombo(StockOnHandIgimsRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		String storeId ="0";
		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_programme_list(?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			storeId=vo.getStrDistrictStoreId();
			dao.setProcInValue(nprocIndex, "modeval", "2");
			dao.setProcInValue(nprocIndex, "storeid", (vo.getStrDistrictStoreId() == null || vo.getStrDistrictStoreId().equals("")) ? "0" : vo.getStrDistrictStoreId());
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
			vo.setStrMsgString("DrugInventoryTransDAO.phdItemCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	
	}

	public static void getReport_1(StockOnHandIgimsRptVO vo) 
	{	
		HisDAO dao = null;
		WebRowSet ws = null;
		int procIndex1 = 0;
	
		String strErr = "";

		try{
			dao = new HisDAO("MMS Transactions","StockOnHandRptDAO");
			String strProcName = "{call PKG_MMS_VIEW2.proc_rptm_new(?,?,?,?,?,?,?,?,?,?,   ?,?,?)}";
			procIndex1 = dao.setProcedure(strProcName);
		
		
			dao.setProcInValue(procIndex1, "modeval", 			vo.getStrMode(),1);			
			dao.setProcInValue(procIndex1, "hosp_code", 		vo.getStrHospitalCode(),2);			
			dao.setProcInValue(procIndex1, "grpid", 			vo.getStrGroupId(),3);
			dao.setProcInValue(procIndex1, "statusid", 			vo.getStrStatusId(),4);
			dao.setProcInValue(procIndex1, "catcode", 			vo.getStrCatCode(),5);
			dao.setProcInValue(procIndex1, "p_circle_id", 		vo.getStrCircleId(),6);
			dao.setProcInValue(procIndex1, "p_district_id", 	vo.getStrDistrictId(),7);
			dao.setProcInValue(procIndex1, "p_hstnum_store_id", vo.getStrStoreId(),8);
			dao.setProcInValue(procIndex1, "p_dwh_type_id", 	vo.getStrStoreTypeId(),9);
			dao.setProcInValue(procIndex1, "p_substore_id", 	"0",10);
			dao.setProcInValue(procIndex1, "p_itembrand_id", 	vo.getStrItemBrandId(),11);		
			dao.setProcOutValue(procIndex1, "err",              1,12); // 1 for string return
			dao.setProcOutValue(procIndex1, "resultset",        2,13); // 2 for object
		
		
			dao.executeProcedureByPosition(procIndex1);
			strErr = dao.getString(procIndex1, "err");	
			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");
				
				System.out.println("WebRowSet---->"+ws.size());
				vo.setStrStockInHandRptWS(ws);
				
			
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
           e.printStackTrace();
			vo
					.setStrMsgString("StockOnHandRptDAO.getStoreList() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getImageHeader(StockOnHandIgimsRptVO voObj)
	{
		String strFuncName = "";
		String strLogoName = "";
		
		int nFuncIndex = 0;
		HisDAO dao = null;
		try 
		{
			dao = new HisDAO("DWH","ListofNARptDAO");
			
			strFuncName = "{? = call MMS_MST.logo_config_dtl(?,?)}";
			nFuncIndex = dao.setFunction(strFuncName);
			
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, voObj.getStrHospitalCode());
			dao.setFuncOutValue(nFuncIndex, 1);
			
			dao.executeFunction(nFuncIndex);
			
			strLogoName = dao.getFuncString(nFuncIndex);
			voObj.setStrLogoName(strLogoName);
			System.out.println("--------------strLogoName--------------"+strLogoName);

		} catch (Exception e) {
			
			e.printStackTrace();
			voObj.setStrMsgType("1");
			voObj.setStrMsgString("StockOnHandRptDAO_NEW.getImageHeader() --> "+ e.getMessage());
			
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}
		}	
	}
/*	
	public static void getReport(StockOnHandIgimsRptVO vo) 
	{
		
		String err = "";
		String strProcName = "{call PKG_MMS_VIEW2.proc_rptm_new_igims_peripheral(?,?,?,?,?  ,?,?,?,?,?,   ?,?,?,?)}"; //14
		System.out.println("-----vo.getStrItemBrandId()-----"+vo.getStrItemBrandId());
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		try {

			dao = new HisDAO("mms", "StockOnHandRptDAO.GetSoreNameCombo(StockOnHandRptVO vo)");
			
			procIndex1 = dao.setProcedure(strProcName);
			// set value
			dao.setProcInValue(procIndex1, "modeval", 			vo.getStrMode());	
			//dao.setProcInValue(procIndex1, "modeval", 			"4");			

			dao.setProcInValue(procIndex1, "hosp_code", 		vo.getStrHospitalCode());			
			dao.setProcInValue(procIndex1, "grpid", 			vo.getStrGroupId());
			dao.setProcInValue(procIndex1, "statusid", 			"2");
			dao.setProcInValue(procIndex1, "catcode", 			vo.getStrItemCatNo());
			dao.setProcInValue(procIndex1, "storeId",   		(vo.getStrStoreId() == null || vo.getStrStoreId().equals("")) ? "0" : vo.getStrStoreId());
			dao.setProcInValue(procIndex1, "storeTypeId", 	    (vo.getStrStoreTypeId() == null || vo.getStrStoreTypeId().equals("")) ? "0" : vo.getStrStoreTypeId());
			dao.setProcInValue(procIndex1, "isItemWise",        (vo.getStrIsItemWise() == null || vo.getStrIsItemWise().equals("")) ? "0" : vo.getStrIsItemWise());
			dao.setProcInValue(procIndex1, "isGroupWise", 	    (vo.getStrIsGroupWise() == null || vo.getStrIsGroupWise().equals("")) ? "0" : vo.getStrIsGroupWise());
			dao.setProcInValue(procIndex1, "itemTypeId", 	    (vo.getStrItemType() == null || vo.getStrItemType().equals("")) ? "0" : vo.getStrItemType());
			dao.setProcInValue(procIndex1, "itembrand_id", 	    (vo.getStrItemBrandId() == null || vo.getStrItemBrandId().equals("")) ? "0" : vo.getStrItemBrandId());	
			dao.setProcInValue(procIndex1, "seat_id",   	    vo.getStrSeatId());	
			dao.setProcOutValue(procIndex1, "err",              1); // 1 for string return
			dao.setProcOutValue(procIndex1, "resultset",        2); // 2 for object
			// execute procedure
			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null) {
				err = "";
			}

			ws = dao.getWebRowSet(procIndex1, "resultset");
			//vo.setStrStockInHandRecordRptWS(ws);
			vo.setStrStockInHandRptWS(ws);
			System.out.println("WebRowSet---->"+ws);

		} catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("StockOnHandRptDAO.getReport() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	} */
	
//Added due to Invalid Column Index
public static void getReport(StockOnHandIgimsRptVO vo) 
	{
		
		String err = "";
		String strProcName = "{call PKG_MMS_VIEW2.proc_rptm_new_igims_peripheral(?,?,?,?,?  ,?,?,?,?,?,   ?,?,?,?)}"; //14
		System.out.println("-----vo.getStrItemBrandId()-----"+vo.getStrItemBrandId());
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		try {
			dao = new HisDAO("mms", "StockOnHandRptDAO.GetSoreNameCombo(StockOnHandRptVO vo)");
			
			procIndex1 = dao.setProcedure(strProcName);
			// set value
			dao.setProcInValue(procIndex1, "modeval", 			vo.getStrMode());	
			//dao.setProcInValue(procIndex1, "modeval", 			"4");			

			dao.setProcInValue(procIndex1, "hosp_code", 		vo.getStrHospitalCode());			
			dao.setProcInValue(procIndex1, "grpid", 			vo.getStrGroupId());
			dao.setProcInValue(procIndex1, "statusid", 			"2");
			dao.setProcInValue(procIndex1, "catcode", 			vo.getStrItemCatNo());
			dao.setProcInValue(procIndex1, "storeid",   		(vo.getStrStoreId() == null || vo.getStrStoreId().equals("")) ? "0" : vo.getStrStoreId());
			dao.setProcInValue(procIndex1, "storetypeid", 	    (vo.getStrStoreTypeId() == null || vo.getStrStoreTypeId().equals("")) ? "0" : vo.getStrStoreTypeId());
			dao.setProcInValue(procIndex1, "isitemwise",        (vo.getStrIsItemWise() == null || vo.getStrIsItemWise().equals("")) ? "0" : vo.getStrIsItemWise());
			dao.setProcInValue(procIndex1, "isgroupwise", 	    (vo.getStrIsGroupWise() == null || vo.getStrIsGroupWise().equals("")) ? "0" : vo.getStrIsGroupWise());
			dao.setProcInValue(procIndex1, "itemtypeid", 	    (vo.getStrItemType() == null || vo.getStrItemType().equals("")) ? "0" : vo.getStrItemType());
			dao.setProcInValue(procIndex1, "itembrand_id", 	    (vo.getStrItemBrandId() == null || vo.getStrItemBrandId().equals("")) ? "0" : vo.getStrItemBrandId());	
			dao.setProcInValue(procIndex1, "seat_id",   	    vo.getStrSeatId());	
			dao.setProcOutValue(procIndex1, "err",              1); // 1 for string return
			dao.setProcOutValue(procIndex1, "resultset",        2); // 2 for object
			// execute procedure
			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null) {
				err = "";
			}

			ws = dao.getWebRowSet(procIndex1, "resultset");
			//vo.setStrStockInHandRecordRptWS(ws);
			vo.setStrStockInHandRptWS(ws);
			System.out.println("WebRowSet---->"+ws);

		} catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("StockOnHandRptDAO.getReport() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	} 
	

public static void getReportZeroStock(StockOnHandIgimsRptVO vo) 
{
	String err = "";
	String strProcName = "{call PKG_MMS_VIEW2.proc_rptm_new(?,?,?,?,?  ,?,?,?,?,?,   ?,?,?,?,?)}"; //14
	System.out.println("-----vo.getStrItemBrandId()-----"+vo.getStrItemBrandId());
	int procIndex1 = 0;
	HisDAO dao = null;
	WebRowSet ws = null;
	try {

		dao = new HisDAO("mms", "StockOnHandIgimsRptDAO.GetSoreNameCombo(StockOnHandRptVO vo)");
		
		procIndex1 = dao.setProcedure(strProcName);
		
				
		// set value
		dao.setProcInValue(procIndex1, "modeval", 			vo.getStrMode());			
		dao.setProcInValue(procIndex1, "hosp_code", 		vo.getStrHospitalCode());			
		dao.setProcInValue(procIndex1, "grpid", 			vo.getStrGroupId());
//			dao.setProcInValue(procIndex1, "statusid", 			"2");
		dao.setProcInValue(procIndex1, "statusid", 			vo.getStrStatusId());

		dao.setProcInValue(procIndex1, "catcode", 			vo.getStrItemCatNo());
		dao.setProcInValue(procIndex1, "storeId",   		vo.getStrStoreId());
		dao.setProcInValue(procIndex1, "storeTypeId", 	    vo.getStrStoreTypeId());
		dao.setProcInValue(procIndex1, "isItemWise",        vo.getStrIsItemWise());
		dao.setProcInValue(procIndex1, "isGroupWise", 	    vo.getStrIsGroupWise());
		dao.setProcInValue(procIndex1, "itemTypeId", 	    vo.getStrItemType());
		dao.setProcInValue(procIndex1, "itembrand_id", 	    vo.getStrItemBrandId());	
		dao.setProcInValue(procIndex1, "seat_id",   	    vo.getStrSeatId());	
		dao.setProcOutValue(procIndex1, "err",              1); // 1 for string return
		dao.setProcOutValue(procIndex1, "resultset",        2); // 2 for object
		// execute procedure
		dao.executeProcedure(procIndex1);

		// get value
		err = dao.getString(procIndex1, "err");

		if (err == null) {
			err = "";
		}

		ws = dao.getWebRowSet(procIndex1, "resultset");
		//vo.setStrStockInHandRecordRptWS(ws);
		vo.setStrStockInHandRptWS(ws);
		System.out.println("WebRowSet---->"+ws);

	} catch (Exception e) 
	{
		e.printStackTrace();
		vo.setStrMsgString("StockOnHandRptDAO.getReport() --> " + e.getMessage());
		vo.setStrMsgType("1");
	} finally {

		if (dao != null) {
			dao.free();
			dao = null;
		}

	}
}
}
