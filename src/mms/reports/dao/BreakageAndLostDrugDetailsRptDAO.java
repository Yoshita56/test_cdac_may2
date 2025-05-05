package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.BreakageAndLostDrugDetailsRptVO;
import mms.transactions.vo.ReturnFromTransVO;

public class BreakageAndLostDrugDetailsRptDAO
{

	/**
	 * To get Drug Warehouse Type Combo
	 *  
	 * @param voObj
	 */
	public static void getDwhTypeCombo(BreakageAndLostDrugDetailsRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_sstt_dwh_type_mst_cmb(?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("DWH","BreakageAndLostDrugDetailsRptDAO");
			//daoObj.setConnType("1");
			nProcIndex = daoObj.setProcedure(strProcName);
			                   
		        
		       
			
			daoObj.setProcInValue(nProcIndex, "p_mode", "1");
			daoObj.setProcInValue(nProcIndex, "p_gnum_hospital_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_sstnum_is_district_dwh", "0");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrDrugWarehouseTypeWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("BreakageAndLostDrugDetailsRptDAO.getStoreList() --> "
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
	 * To get District Drug Warehouse Name Combo from the hstt_store_mst 
	 *  
	 * @param voObj
	 */
	public static void getDistrictStoreList(BreakageAndLostDrugDetailsRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("DWH","BudgetDetailRptDAO");
			//
			nProcIndex = daoObj.setProcedure(strProcName);

			
			daoObj.setProcInValue(nProcIndex, "modeval", voObj.getStrMode());
			daoObj.setProcInValue(nProcIndex, "seatid", voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeid", "0");
			daoObj.setProcInValue(nProcIndex, "storetype_id","0"); 
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

			voObj
					.setStrMsgString("BudgetDetailRptDAO.getStoreList() --> "
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
	 * To get Store Combo  from the hstt_store_mst
	 *  
	 * @param voObj
	 */
	public static void getStoreList(BreakageAndLostDrugDetailsRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			
			System.out.println("---------BreakageAndLostDrugDetailsRptDAO.getStoreList---------");

			daoObj = new HisDAO("DWH","BreakageAndLostDrugDetailsRptDAO");
			//
			nProcIndex = daoObj.setProcedure(strProcName);

			
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "seatid", voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeid", "0");
			daoObj.setProcInValue(nProcIndex, "storetype_id","0"); 
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

			voObj
					.setStrMsgString("BreakageAndLostDrugDetailsRptDAO.getStoreList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getItemCatList(BreakageAndLostDrugDetailsRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.Rptm_item_category_list(?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","BreakageAndLostDrugDetailsRptDAO");
			//
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval"    ,"2");
			daoObj.setProcInValue(nProcIndex, "storeId"    ,voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code"  ,voObj.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err"       ,1);
			daoObj.setProcOutValue(nProcIndex, "resultset" ,2);

			daoObj.executeProcedure(nProcIndex);
	
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

			voObj.setStrMsgString("BreakageAndLostDrugDetailsRptDAO.getItemCatList() --> "	+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getViewDtl(BreakageAndLostDrugDetailsRptVO voObj)
	{
		String strProcName = "{call Pkg_Mms_RPT.rptm_breakageandlostdrugdtls(?,?,?,?,?   ,?,?,?,?)}";
		//PKG_MMS_RPT.RPTM_BREAKAGEANDLOSTDRUGDTLS
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try 
		{
			daoObj = new HisDAO("DWH","BreakageAndLostDrugDetailsRptDAO");
			nProcIndex = daoObj.setProcedure(strProcName);	
			
			
			
			daoObj.setProcInValue(nProcIndex, "p_mode",                 		"1",1);  	 
			daoObj.setProcInValue(nProcIndex, "p_gnum_hospital_code",   		voObj.getStrHospitalCode(),2);	    
			daoObj.setProcInValue(nProcIndex, "p_hstnum_store_id",      		voObj.getStrStoreId(),3);				
			daoObj.setProcInValue(nProcIndex, "p_sstnum_item_cat_no",   		voObj.getStrItemCategoryId(),4);   
			
			daoObj.setProcInValue(nProcIndex, "p_hstdt_finstart_date",  		voObj.getStrStartDate(),5);  
			daoObj.setProcInValue(nProcIndex, "p_hstdt_finend_date",    		voObj.getStrEndDate(),6);    
			daoObj.setProcInValue(nProcIndex, "p_hstnum_breakable_lost_flag",   "1",7);			 
			
			daoObj.setProcOutValue(nProcIndex, "err",         1,8); 	
			daoObj.setProcOutValue(nProcIndex, "resultset",   2,9);		

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				//System.out.println(" ----------> Size---------"+ ws.size());
				voObj.setWsBreakageDtlRpt(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("BreakageAndLostDrugDetailsRptDAO.getViewDtl() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getImageHeader(BreakageAndLostDrugDetailsRptVO voObj)
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
			
			dao.setFuncInValue(nFuncIndex, 2, voObj.getStrMode());
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
	
}

