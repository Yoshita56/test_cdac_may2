package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.BudgetAllocationDetailProcessTransVO;

public class BudgetAllocationDetailProcessTransDAO {
	
	public static void getDrugWareHouseNameCombo(BudgetAllocationDetailProcessTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","IssueTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", voObj.getStrMode());
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			
			/* Setting Default Value Start*/
			daoObj.setProcInValue(nProcIndex, "storeid", "0");
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0");
			/* Setting Default Value End */
			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
		
				voObj.setWrsDrugWareHouseNameCmb(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("BudgetAllocationDetailProcessTransDAO.getDrugWareHouseNameCombo() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	public static void getDWHSubTypeCombo(BudgetAllocationDetailProcessTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_DWHSubType_Cmb(?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","IssueTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
		
				voObj.setWrsDWHSubTypeCmb(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("BudgetAllocationDetailProcessTransDAO.getDWHSubTypeCombo() --> "
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
	 * To Get Data
	 * 
	 * @param budgetAllocationDetailProcessTransVO_p
	 */
	public static void getData(BudgetAllocationDetailProcessTransVO budgetAllocationDetailProcessTransVO_p) 
	{
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_hstt_budget_dtl_new(?,?,?,?,?,  ?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

				dao = new HisDAO("MMS Transactions","BudgetAllocationDetailProcessTransDAO");
		
				//HisUtil.replaceNullValueWithEmptyString(budgetAllocationDetailProcessTransVO_p);
				
				procIndex1 = dao.setProcedure(proc_name1);
				
				dao.setProcInValue(procIndex1, "p_mode", budgetAllocationDetailProcessTransVO_p.getStrMode());
				// set value
				dao.setProcInValue(procIndex1, "p_ddwId", budgetAllocationDetailProcessTransVO_p.getStrDrugWareHouseName());
				dao.setProcInValue(procIndex1, "p_store_type", budgetAllocationDetailProcessTransVO_p.getStrDWHSubTypeId());
				
				dao.setProcInValue(procIndex1, "p_hstnum_store_id", budgetAllocationDetailProcessTransVO_p.getStrSubStoreId());
				dao.setProcInValue(procIndex1, "p_hstdt_finstart_date", budgetAllocationDetailProcessTransVO_p.getStrFinancialStartDate());
				
				dao.setProcInValue(procIndex1, "p_hstdt_finend_date", budgetAllocationDetailProcessTransVO_p.getStrFinancialEndDate());
				dao.setProcInValue(procIndex1, "p_gnum_hospital_code", budgetAllocationDetailProcessTransVO_p.getStrHospitalCode());
				dao.setProcInValue(procIndex1, "p_hstnum_slno", budgetAllocationDetailProcessTransVO_p.getStrSlNo());
				
				
				/* Setting Default Value End */
				
				dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
				// value
				dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object
		
				// execute procedure
		
				dao.executeProcedure(procIndex1);
		
				// get value
				err = dao.getString(procIndex1, "err");
		
				if (err == null)
					err = "";
		
				ws = dao.getWebRowSet(procIndex1, "resultset");
		
				budgetAllocationDetailProcessTransVO_p.setWrsData(ws);

		} catch (Exception e) {
			//e.printStackTrace();
			budgetAllocationDetailProcessTransVO_p.setStrMsgString("BudgetAllocationDetailProcessTransDAO.getData() --> "	+ e.getMessage());
			budgetAllocationDetailProcessTransVO_p.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
		
	}

	/**
	 * To Save Data
	 * 
	 * @param budgetAllocationDetailProcessTransVO_p
	 */
	public synchronized static void insert(BudgetAllocationDetailProcessTransVO budgetAllocationDetailProcessTransVO_p) 
	{

		HisDAO dao = null;

		int nProcIndex_U;

		String strProcName_U = "";

		try {
			dao = new HisDAO("dwh", "BudgetAllocationDetailProcessTransDAO");

			strProcName_U = "{call pkg_mms_dml.dml_budget_dtl(?,?,?,?,?,  ?,?,?,?,?,  ?)}"; // Total 16 Values
			
			nProcIndex_U = dao.setProcedure(strProcName_U);
						
			//HisUtil.replaceNullValueWithEmptyString(budgetAllocationDetailProcessTransVO_p);
			
			
//			System.out.println("p_mode"+ budgetAllocationDetailProcessTransVO_p.getStrMode());
//			System.out.println("p_ddw_id"+ budgetAllocationDetailProcessTransVO_p.getStrDrugWareHouseName());
//			System.out.println("p_ddw_type"+ budgetAllocationDetailProcessTransVO_p.getStrDWHSubTypeId());
//			System.out.println("p_substore_id"+ budgetAllocationDetailProcessTransVO_p.getStrSubStoreId());
//			System.out.println("p_hstdt_finstart_date"+ budgetAllocationDetailProcessTransVO_p.getStrFinancialStartDate());
//			System.out.println("p_hstdt_finend_date"+ budgetAllocationDetailProcessTransVO_p.getStrFinancialEndDate());
//			System.out.println("p_gnum_hospital_code"+ budgetAllocationDetailProcessTransVO_p.getStrHospitalCode());
//			System.out.println("p_hstnum_budget_allot"+ budgetAllocationDetailProcessTransVO_p.getStrNewAllocatedBudget());
//			System.out.println("p_hststr_remarks"+ budgetAllocationDetailProcessTransVO_p.getStrRemarks());
//			System.out.println("p_gnum_seatid"+ budgetAllocationDetailProcessTransVO_p.getStrSeatId());
			
			          			
			dao.setProcInValue(nProcIndex_U, "p_mode", budgetAllocationDetailProcessTransVO_p.getStrMode());
			dao.setProcInValue(nProcIndex_U, "p_ddw_id", budgetAllocationDetailProcessTransVO_p.getStrDrugWareHouseName());
			dao.setProcInValue(nProcIndex_U, "p_ddw_type", budgetAllocationDetailProcessTransVO_p.getStrDWHSubTypeId());
			dao.setProcInValue(nProcIndex_U, "p_substore_id", budgetAllocationDetailProcessTransVO_p.getStrSubStoreId());
			dao.setProcInValue(nProcIndex_U, "p_hstdt_finstart_date", budgetAllocationDetailProcessTransVO_p.getStrFinancialStartDate());
			dao.setProcInValue(nProcIndex_U, "p_hstdt_finend_date", budgetAllocationDetailProcessTransVO_p.getStrFinancialEndDate());
			dao.setProcInValue(nProcIndex_U, "p_gnum_hospital_code", budgetAllocationDetailProcessTransVO_p.getStrHospitalCode());
			dao.setProcInValue(nProcIndex_U, "p_hstnum_budget_allot", budgetAllocationDetailProcessTransVO_p.getStrNewAllocatedBudget());
			dao.setProcInValue(nProcIndex_U, "p_hststr_remarks", budgetAllocationDetailProcessTransVO_p.getStrRemarks());
			dao.setProcInValue(nProcIndex_U, "p_gnum_seatid", budgetAllocationDetailProcessTransVO_p.getStrSeatId());
			
			
			// Default Value 

			dao.setProcOutValue(nProcIndex_U, "err", 1);

			dao.executeProcedure(nProcIndex_U);

			budgetAllocationDetailProcessTransVO_p.setStrMsgType("0");

		} 
		catch (Exception e) 
		{
			budgetAllocationDetailProcessTransVO_p.setStrMsgString("--> BudgetAllocationDetailProcessTransDAO.insert()-->" + e.getMessage());
			budgetAllocationDetailProcessTransVO_p.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}



	

	public static void getDWHSubStoreCmb(BudgetAllocationDetailProcessTransVO voObj) 
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_sub_store_cmb(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","IssueTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", voObj.getStrMode());
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			
			/* Setting Default Value Start*/
			daoObj.setProcInValue(nProcIndex, "storeid", voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "sub_type_id", voObj.getStrStoreSubType());
			/* Setting Default Value End */
			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
		
				voObj.setWrsDWHSubStoreCmb(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("BudgetAllocationDetailProcessTransDAO.getDrugWareHouseNameCombo() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getFinancialYearComboForViewPage(BudgetAllocationDetailProcessTransVO budgetAllocationDetailProcessTransVO_p) 
	{
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_get_Financial_Year_Combo(?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

				dao = new HisDAO("MMS Transactions","BudgetAllocationDetailProcessTransDAO");
		
				//HisUtil.replaceNullValueWithEmptyString(budgetAllocationDetailProcessTransVO_p);
				
				procIndex1 = dao.setProcedure(proc_name1);
				
				dao.setProcInValue(procIndex1, "p_mode", budgetAllocationDetailProcessTransVO_p.getStrMode());
				dao.setProcInValue(procIndex1, "p_gnum_hospital_code", budgetAllocationDetailProcessTransVO_p.getStrHospitalCode());
				
				/* Setting Default Value End */
				
				dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
				// value
				dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object
		
				// execute procedure
		
				dao.executeProcedure(procIndex1);
		
				// get value
				err = dao.getString(procIndex1, "err");
		
				if (err == null)
					err = "";
		
				ws = dao.getWebRowSet(procIndex1, "resultset");
		
				budgetAllocationDetailProcessTransVO_p.setWrsFinancialYearCmb(ws);

		} catch (Exception e) {
			//e.printStackTrace();
			budgetAllocationDetailProcessTransVO_p.setStrMsgString("BudgetAllocationDetailProcessTransDAO.getFinancialYearComboForViewPage() --> "	+ e.getMessage());
			budgetAllocationDetailProcessTransVO_p.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}		
	}
}
