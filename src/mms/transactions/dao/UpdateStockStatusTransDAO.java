package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.UpdateStockStatusTransVO;

public class UpdateStockStatusTransDAO {
	
	public static void getDrugWareHouseNameCombo(UpdateStockStatusTransVO updateStockStatusTransVO_p) 
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","IssueTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "seatId", updateStockStatusTransVO_p.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", updateStockStatusTransVO_p.getStrHospitalCode());
			
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
		        if(ws.next())
		        {
		        	updateStockStatusTransVO_p.setStrDrugWareHouseTypeId(ws.getString(1));
		        }
				ws.beforeFirst();
				updateStockStatusTransVO_p.setWrsDrugWareHouseNameCmb(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			updateStockStatusTransVO_p.setStrMsgString("UpdateStockStatusTransDAO.getDrugWareHouseNameCombo() --> "	+ e.getMessage());
			updateStockStatusTransVO_p.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	/**
	 * 
	 * @param voObj
	 */
	public static void getItemCatDtls(UpdateStockStatusTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","IssueTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval",    "8");
			daoObj.setProcInValue(nProcIndex, "hosp_code",  voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "store_id",   voObj.getStrDrugWareHouseTypeId());
			daoObj.setProcInValue(nProcIndex, "reqType",    "0");
			daoObj.setProcOutValue(nProcIndex, "err",        1);
			daoObj.setProcOutValue(nProcIndex, "resultset",  2);

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
			e.printStackTrace();
			voObj.setStrMsgString("UpdateStockStatusTransDAO.getItemCatDtls() --> "+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	/**
	 * The following procedure is used to populate the value of Group Name
	 * combo using Pkg_Mms_View.proc_supplier_list procedure.
	 * 
	 * 
	 */

	public static void getGroupNameCombo(UpdateStockStatusTransVO vo) {
		String err = "";
	
		String proc_name1 = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			hisutil = new HisUtil("mms", "UpdateStockStatusTransDAO");
			dao = new HisDAO("mms",	"UpdateStockStatusTransDAO.GetGroupNameCombo(UpdateStockStatusTransVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

            dao.setProcInValue(procIndex1, "modeval", "2");
			
			dao.setProcInValue(procIndex1, "item_category", "10");
			
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			
			/*start*/
			dao.setProcInValue(procIndex1, "strPhyStockNo","0");
			dao.setProcInValue(procIndex1, "strStoreId", "0");
			/*end*/

			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";
			ws = dao.getWebRowSet(procIndex1, "RESULTSET");
			if (err.equals("")) {
				 
				vo.setStrGroupNameComboWS(ws);
			} else {
				throw new Exception(err);
			}
			
			
		
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("UpdateStockStatusTransDAO.GetGroupNameCombo() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	
	/**
	 * The following procedure is used to populate the value of ItemBrand Name
	 * combo using Pkg_Mms_View.proc_itembrand_list procedure.
	 * 
	 * 
	 */

	public static void getItemBrandName(UpdateStockStatusTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "UpdateStockStatusTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_get_Drug_list_Combo1(?,?,?,?,?,?,?,?,?,?,?)}"; // Total 11
			nprocIndex = dao.setProcedure(strproc_name);

			/*
			System.out.println("getStrItemCategoryId---"+vo.getStrItemCategoryId()); 
			System.out.println("getStrItemBrandId---"+vo.getStrItemBrandId()); 
			System.out.println("getStrGroupId---"+vo.getStrGroupId()); 
			System.out.println("getStrHospitalCode---"+vo.getStrHospitalCode());
			*/
			
			dao.setProcInValue(nprocIndex, "p_mode", 					vo.getStrMode());			
			dao.setProcInValue(nprocIndex, "p_hstnum_store_id", 		vo.getStrDrugWareHouseTypeId());
			dao.setProcInValue(nprocIndex, "p_hstnum_item_id", 			"0");
			dao.setProcInValue(nprocIndex, "p_hstnum_itembrand_id", 	vo.getStrItemBrandId());
			dao.setProcInValue(nprocIndex, "p_hststr_batch_no", 		"0");
			dao.setProcInValue(nprocIndex, "p_gnum_hospital_code",      vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "p_sstnum_item_cat_no", 		vo.getStrItemCategoryId());
			dao.setProcInValue(nprocIndex, "p_hstnum_stock_status_code","0");			
			if(vo.getStrGroupId()==null || vo.getStrGroupId()=="")
			{
				dao.setProcInValue(nprocIndex, "p_hstnum_group_id", "0");
			}
			else
			{
				dao.setProcInValue(nprocIndex, "p_hstnum_group_id", vo.getStrGroupId());
			}
			
			
			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			
			
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			
			System.out.println("wb--->>"+wb.size()); 
			
			if (strerr.equals(""))
			{
				vo.setStrDrugNameComboWS(wb);

			} 
			else 
			{
				throw new Exception(strerr);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("UpdateStockStatusTransDAO.getItemBrandName() --> "	+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	
	public static void getStockStatusList(UpdateStockStatusTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "UpdateStockStatusTransDAO");
			
			
			strproc_name = "{call PKG_MMS_VIEW.proc_stock_status_list(?,?,?,?,?,?)}";
			
			//System.out.println("Catg_Code---->>"+vo.getStrItemCategoryId());
			
			
			nprocIndex = dao.setProcedure(strproc_name);
           
			dao.setProcInValue(nprocIndex, "modeval",  "1");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			
			if(vo.getStrItemCategoryId().equals("10"))
			{
				dao.setProcInValue(nprocIndex, "itemCat", vo.getStrItemCategoryId());
			} 
			else 
			{
				dao.setProcInValue(nprocIndex, "itemCat", "0");
			}
			dao.setProcInValue(nprocIndex, "itemBrandId", vo.getStrItemBrandId());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {

				vo.setStrStockStatusWs(wb);

			} else {
				throw new Exception(strerr);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("UpdateStockStatusTransDAO.getStockStatusList() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	
	/**
	 * The following procedure is used to populate the value of Unit Name combo
	 * using Pkg_Mms_View.Proc_Gblt_Unit_Mst procedure.
	 * 
	 * 
	 */
	public static void getUnitNameCombo(UpdateStockStatusTransVO vo) {
		String strFuncName = "";
		String strFuncName1 = "";

		String strProcName = "";

		String strItemId;
		
		int nFuncIndex = 0, nFuncIndex1 = 0;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;
		String strUnitRate = "";

		try {

			daoObj = new HisDAO("SampleSentTrans", "UpdateStockStatusTransDAO");

			strFuncName1 = "{? = call mms_mst.get_genericitem_dtl(?, ?, ?)}";// To get Item id from Item Brand Id
			
			strFuncName = "{? = call mms_mst.get_inventory_unitid(?, ?, ?, ?)}";
			
			
			
			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";

			
			
			nFuncIndex1 = daoObj.setFunction(strFuncName1);
			daoObj.setFuncInValue(nFuncIndex1, 2, "1");
			daoObj.setFuncInValue(nFuncIndex1, 3, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex1, 4, vo.getStrItemBrandId());
			
			daoObj.setFuncOutValue(nFuncIndex1, 1);
			daoObj.executeFunction(nFuncIndex1);
			strItemId =  daoObj.getFuncString(nFuncIndex1);
			

			

			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, "1");
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 4, vo.getStrItemCategoryId());
			
			daoObj.setFuncInValue(nFuncIndex, 5, strItemId);
			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);
			strUnitRate = daoObj.getFuncString(nFuncIndex);
			
			vo.setStrUnitRateID(strUnitRate);

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "unit_id", vo.getStrUnitRateID());
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "module_id", "");//
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
				vo.setWsUnitCombo(ws);

			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("SampleSentTrans.unitNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	
	
	
	/**
	 * This function is used to set initial values in Received by combo.
	 * @param _ItemTransferTransVO
	 */
	public static void getApprovedByCombo(UpdateStockStatusTransVO  vo)
	
	{
		
		String strProcName = "{call PKG_MMS_VIEW.proc_store_emp_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try
		{
			daoObj  = new HisDAO("MMSModule","IssueDeskTransDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
						
			daoObj.setProcInValue(nProcIndex, "modeVal", "1");
			daoObj.setProcInValue(nProcIndex, "storeId", vo.getStrDrugWareHouseTypeId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			////System.out.println("Size is ==>"+ws.size());
			if(strErr.equals(""))
			{
				vo.setWrsRecievedByCombo(ws);
			}
		}
		catch(Exception _err)
		{
			vo.setStrMsgString("IssueDeskTransDAO.setRecievedByCombo() --> "+ _err.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	
	/**
	 * To Get Data
	 * 
	 * @param budgetAllocationDetailProcessTransVO_p
	 */
	public static void getData(UpdateStockStatusTransVO updateStockStatusTransVO_p) 
	{
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_hstt_budget_dtl(?,?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

				dao = new HisDAO("MMS Transactions","UpdateStockStatusTransDAO");
		
				HisUtil.replaceNullValueWithEmptyString(updateStockStatusTransVO_p);
				
				procIndex1 = dao.setProcedure(proc_name1);
				
				dao.setProcInValue(procIndex1, "p_mode", updateStockStatusTransVO_p.getStrMode());
				// set value
				dao.setProcInValue(procIndex1, "p_hstnum_store_id", updateStockStatusTransVO_p.getStrDrugWareHouseName());
//				dao.setProcInValue(procIndex1, "p_hstdt_finstart_date", updateStockStatusTransVO_p.getStrFinancialStartDate());
				
//				dao.setProcInValue(procIndex1, "p_hstdt_finend_date", updateStockStatusTransVO_p.getStrFinancialEndDate());
				dao.setProcInValue(procIndex1, "p_gnum_hospital_code", updateStockStatusTransVO_p.getStrHospitalCode());
//				dao.setProcInValue(procIndex1, "p_hstnum_slno", updateStockStatusTransVO_p.getStrSlNo());
				
				
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
		
				updateStockStatusTransVO_p.setWrsData(ws);

		} catch (Exception e) {
			//e.printStackTrace();
			updateStockStatusTransVO_p.setStrMsgString("UpdateStockStatusTransDAO.getData() --> "	+ e.getMessage());
			updateStockStatusTransVO_p.setStrMsgType("1");

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
	 * @param updateStockStatusTransVO_p
	 */
	public synchronized static void insertRecord(UpdateStockStatusTransVO updateStockStatusTransVO_p) 
	{

		HisDAO dao = null;

		int nProcIndex_U;

		String strProcName_U = "";

		try {
			dao = new HisDAO("dwh", "UpdateStockStatusTransDAO");

			strProcName_U = "{call pkg_mms_dml.dml_stock_status_update_dtl(?,?,?,?,?,?,?,?,?,?,   ?,?,?,?,?,? )}"; // Total 16 [10+6] Values
			
			nProcIndex_U = dao.setProcedure(strProcName_U);						
			HisUtil.replaceNullValueWithEmptyString(updateStockStatusTransVO_p);
		
			
			dao.setProcInValue(nProcIndex_U, "p_mode", 						updateStockStatusTransVO_p.getStrMode());  //1			
			dao.setProcInValue(nProcIndex_U, "p_reqtypeid", 				updateStockStatusTransVO_p.getStrRequestTypeId());//2
			dao.setProcInValue(nProcIndex_U, "p_HSTNUM_STORE_ID", 			updateStockStatusTransVO_p.getStrStoreId());//3
			dao.setProcInValue(nProcIndex_U, "p_GNUM_HOSPITAL_CODE", 		updateStockStatusTransVO_p.getStrHospitalCode());//4
			dao.setProcInValue(nProcIndex_U, "p_SSTNUM_ITEM_CAT_NO", 		updateStockStatusTransVO_p.getStrItemCategoryId());//5
			dao.setProcInValue(nProcIndex_U, "p_HSTNUM_ITEMBRAND_ID", 		updateStockStatusTransVO_p.getStrItemBrandId());//6
			dao.setProcInValue(nProcIndex_U, "p_HSTSTR_BATCH_NO", 			updateStockStatusTransVO_p.getStrBatchNo());//7
			dao.setProcInValue(nProcIndex_U, "p_HSTSTR_ITEM_SL_NO", 		updateStockStatusTransVO_p.getStrItemSlNo());//8
			dao.setProcInValue(nProcIndex_U, "p_HSTNUM_QTY", 				updateStockStatusTransVO_p.getStrQty());//9
			dao.setProcInValue(nProcIndex_U, "p_HSTNUM_OLD_STOCK_STATUS", 	updateStockStatusTransVO_p.getStrStockStatusCode());//10
			dao.setProcInValue(nProcIndex_U, "p_HSTNUM_NEW_STOCK_STATUS", 	updateStockStatusTransVO_p.getStrNewStockStatusCode());//11
			dao.setProcInValue(nProcIndex_U, "p_HSTNUM_IS_UPDATE_ALL_DWH", 	updateStockStatusTransVO_p.getStrWhetherUpdateNewStatusInAllDWH());//12
			dao.setProcInValue(nProcIndex_U, "p_HSTSTR_APPROVED_BY", 		updateStockStatusTransVO_p.getStrApprovedBy());//13
			dao.setProcInValue(nProcIndex_U, "p_GSTR_REMARKS", 				updateStockStatusTransVO_p.getStrRemarks());//14
			dao.setProcInValue(nProcIndex_U, "p_GNUM_SEATID", 				updateStockStatusTransVO_p.getStrSeatId());//15
			/* Default Value */
			dao.setProcOutValue(nProcIndex_U, "err", 						1);//16

			dao.executeProcedure(nProcIndex_U);

			updateStockStatusTransVO_p.setStrMsgType("0");

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			updateStockStatusTransVO_p.setStrMsgString("--> UpdateStockStatusTransDAO.insertRecord()-->" + e.getMessage());
			updateStockStatusTransVO_p.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	
	/**
	 * 
	 * @param updateStockStatusTransVO_p
	 */
	public static void getViewUpdatedStockStatusDetails(UpdateStockStatusTransVO updateStockStatusTransVO_p) 
	{
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_getStockStatusChange_dtl(?,?,?,?,?, ?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {			
		
				dao = new HisDAO("MMS Transactions","UpdateStockStatusTransDAO");
		
				HisUtil.replaceNullValueWithEmptyString(updateStockStatusTransVO_p);
				
				procIndex1 = dao.setProcedure(proc_name1);
				
				dao.setProcInValue(procIndex1, "p_mode", 				     updateStockStatusTransVO_p.getStrMode());				
				dao.setProcInValue(procIndex1, "p_hstnum_store_id ", 	     updateStockStatusTransVO_p.getStrDrugWareHouseTypeId());
				dao.setProcInValue(procIndex1, "p_gnum_hospital_code", 	     updateStockStatusTransVO_p.getStrHospitalCode());
				dao.setProcInValue(procIndex1, "p_sstnum_item_cat_no", 	     updateStockStatusTransVO_p.getStrItemCategoryId());
				dao.setProcInValue(procIndex1, "p_fromDate", 				 updateStockStatusTransVO_p.getStrFromDate());
				dao.setProcInValue(procIndex1, "p_toDate",					 updateStockStatusTransVO_p.getStrToDate());
				dao.setProcInValue(procIndex1, "p_hstnum_stock_change_no",   "0");
				
				
				
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
				
				//System.out.println("--SIZE--"+ws.size());
		
				updateStockStatusTransVO_p.setWrsData(ws);

		}
		catch (Exception e) 
		{
			//e.printStackTrace();
			updateStockStatusTransVO_p.setStrMsgString("UpdateStockStatusTransDAO.getViewUpdatedStockStatusDetails() --> "	+ e.getMessage());
			updateStockStatusTransVO_p.setStrMsgType("1");

		} 
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
			}

		}
	}	
}

	