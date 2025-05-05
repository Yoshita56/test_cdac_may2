package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.dao.DmlHsttPurIndentItemDtlDAO;
import mms.dao.DmlIndentDtlDAO;
import mms.transactions.vo.RoutinePurchaseVO;

public class RoutinePurchaseDAO 
{
	

	/**
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void itemCategoryCombo(RoutinePurchaseVO vo) {
		String strProcName = "{call PKG_MMS_VIEW.proc_item_category_list (?,?,?,?,?,?)}";

		int nProcIndex = 0;
		String strErr = "";
		String str = "";
		HisUtil hisutil = null;
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {
			hisutil = new HisUtil("master", "RoutinePurchaseDAO");
			daoObj = new HisDAO("Issue To Patient", "RoutinePurchaseDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);			
			daoObj.setProcInValue(nProcIndex, "reqType", "0",4); //default
			
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {
				if (ws != null && ws.size() != 0) {
					str = hisutil.getOptionValue(ws, "-1", "0^Select Value",
							true);
					vo.setStrItemCatgCombo(str);
				} else {
					str = "<option value='0'>DATA N/A</option>";
					vo.setStrItemCatgCombo(str);
				}
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			vo
					.setStrMsgString("ReceiveFromThirdPartyTransDAO.itemCategory() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * for getting option value of combo on add page (store type name )
	 * 
	 * @param vo
	 */
	public static void GetGroupNameCombo(RoutinePurchaseVO vo) {
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			hisutil = new HisUtil("master", "RoutinePurchaseDAO");
			dao = new HisDAO("mms",
					"RoutinePurchaseDAO.GetGroupNameCombo(RoutinePurchaseVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

            dao.setProcInValue(procIndex1, "modeval", "1",1);			
			dao.setProcInValue(procIndex1, "item_category", vo.getStrItemCategoryNo(),2);			
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),3);			
			/* Setting Default Value Start*/
			dao.setProcInValue(procIndex1, "strPhyStockNo", "0",4);
			dao.setProcInValue(procIndex1, "strStoreId", "0",5);
			/* Setting Default Value End */

			dao.setProcOutValue(procIndex1, "ERR", 1,6); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2,7); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "-1", "0^Select Value", true);
				vo.setStrGroupIdForItemSearch(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrGroupIdForItemSearch(str);
			}
		} catch (Exception e) {
			vo.setStrMsgString("RoutinePurchaseDAO.GetGroupNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}

	/*
	 * This Function is used to get Store Name by Passing 2 variable a) Hospital
	 * Code b) Store Id
	 */
	public static void callingFunctionStoreName(RoutinePurchaseVO vo) {
		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		try {
			dao = new HisDAO("MMSModule", "RoutinePurchaseDAO");
			funcIndex = dao
					.setFunction("{? = call MMS_MST.get_store_dtl(?,?,?)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, "1");
			dao.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4, vo.getStrStoreId());
			dao.setFuncOutValue(funcIndex, 1);
			// Execute Function
			dao.executeFunction(funcIndex);
			retVal = dao.getFuncString(funcIndex);
			if (retVal != null) {
				vo.setStrStoreName(retVal);
			} else {
				retVal = "-----";
				vo.setStrStoreName(retVal);
			}

		} catch (Exception e) {
			vo
					.setStrMsgString("IndentDeskCondemnationReqTransDAO.callingFunctionStoreName() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/*
	 * This Function is used to get Item Category Name by Passing 2 variable a)
	 * Hospital Code b) Item Category
	 */

	public static void callingItemCategory(RoutinePurchaseVO vo) {

		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		// Split the Value

		try {
			dao = new HisDAO("MMSModule", "IndentDeskCondemnationReqTransDAO");
			funcIndex = dao
					.setFunction("{? = call MMS_MST.get_itemcat_dtl(?,?,?)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, "1");
			dao.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4, vo.getStrItemCategoryNo());
			dao.setFuncOutValue(funcIndex, 1);
			// Execute Function
			dao.executeFunction(funcIndex);
			retVal = dao.getFuncString(funcIndex);

			if (retVal != null) {
				vo.setStrItemCatg(retVal);
			} else {
				retVal = "-----";
				vo.setStrItemCatg(retVal);
			}

		} catch (Exception e) {
			vo
					.setStrMsgString("IndentDeskCondemnationReqTransDAO.callingItemCategory() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of combo on add page (Indent Period Combo)
	 * 
	 * @param vo
	 */
	public static void IndentPeriodCombo(RoutinePurchaseVO vo)
	{
		String err = "";
		String proc_name1 = "{call PKG_MMS_VIEW.PERIOD_COMBO_SSTT_PERIOD_MST(?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;
		MmsConfigUtil mcu=null;

		try {
			hisutil = new HisUtil("master", "RoutinePurchaseDAO");
			dao = new HisDAO("mms","RoutinePurchaseDAO.GetDeptCombo(RoutinePurchaseVO vo)");
			mcu= new MmsConfigUtil(vo.getStrHospitalCode());

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

	            dao.setProcInValue(procIndex1, "modeval", "2",1);
				dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),2);				
				dao.setProcOutValue(procIndex1, "ERR", 1,3); // 1 for string return				// value

				dao.setProcOutValue(procIndex1, "RESULTSET", 2,4); // 2 for object
				// execute procedure

				dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			if (ws != null && ws.size() != 0) 
			{
				str = hisutil.getOptionValue(ws, mcu.INDENT_PERIOD_ANNUALY, "0^Select Value", true);
				vo.setStrIndentPeriodCombo(str);
			}
			else 
			{
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrIndentPeriodCombo(str);
			}

		} catch (Exception e) {
			vo.setStrMsgString("RoutinePurchaseDAO.ToStoreCombo() --> "
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
	 * for getting option value of combo on add page (Grant Type Combo)
	 * 
	 * @param vo
	 */
	public static void GetGrantTypeCombo(RoutinePurchaseVO vo) {
		String err = "";
		String proc_name1 = "{call PKG_MMS_VIEW.proc_grant_list(?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			hisutil = new HisUtil("master", "RoutinePurchaseDAO");
			dao = new HisDAO("mms",
					"RoutinePurchaseDAO.GetSoreNameCombo(RoutinePurchaseVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "modeval", "1",1);

			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode(),2);

			dao.setProcOutValue(procIndex1, "err", 1,3); // 1 for string return

			dao.setProcOutValue(procIndex1, "resultset", 2,4); // 2 for object
			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "-1", "0^Select Value", true);
				vo.setStrGrantTypeCombo(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrGrantTypeCombo(str);
			}
		} catch (Exception e) {
			vo.setStrMsgString("RoutinePurchaseDAO.GetGrantTypeCombo() --> "
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
	 * for getting option value of combo on add page (Recommende Combo)
	 * 
	 * @param vo
	 */
	public static void GetRecommendByCombo(RoutinePurchaseVO vo) {
		String err = "";
		String proc_name1 = "{call PKG_MMS_VIEW.Proc_Consultant_Name(?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			hisutil = new HisUtil("master", "RoutinePurchaseDAO");
			dao = new HisDAO("mms",
					"RoutinePurchaseDAO.GetSoreNameCombo(RoutinePurchaseVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

            dao.setProcInValue(procIndex1, "modeval", "1",1);
			
			dao.setProcInValue(procIndex1, "deptunitcode", "0",2);
			
			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode(),3);

			dao.setProcInValue(procIndex1, "seatId", vo.getStrSeatId(),4);
						
			dao.setProcOutValue(procIndex1, "err", 1,5); // 1 for string return

			dao.setProcOutValue(procIndex1, "resultset", 2,6); // 2 for object
			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "-1", "0^Select Value", true);
				vo.setStrRecmndByCombo(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrRecmndByCombo(str);
			}
		} catch (Exception e) {
			vo.setStrMsgString("RoutinePurchaseDAO.GetRecommendByCombo() --> "
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
	 * for getting value of item details on view page
	 * 
	 * @param vo
	 */
	
	//
	
	

	public static void getIndentDetails(RoutinePurchaseVO vo) 
	{
		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";

    	try 
		{
    		String strProcName = "{call PKG_MMS_VIEW.Get_Indent_Details_View(?,?,?,?,?,?)}";

			daoObj = new HisDAO("MMS Transactions","IndentViewTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "storeId",vo.getStrStoreId(),1);
			daoObj.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "reqNo",vo.getStrReqNo(),3);			
			/* Setting Default Value Start*/
			daoObj.setProcInValue(nProcIndex, "reqTypeId","0",4);
			/* Setting Default Value End */
			
			daoObj.setProcOutValue(nProcIndex,"err",1,5);
			daoObj.setProcOutValue(nProcIndex,"RESULTSET", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) 
			{
    			wb = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				vo.setStrIndentDetailsWs(wb);
				
			} else {
				throw new Exception(strErr);
			}
    		
		
		
		} 
    	catch (Exception e) 
    	{
			vo.setStrMsgString("--> IndentViewTransDAO.getIndentDetails()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null)
				daoObj.free();
				daoObj = null;
			}

		}
	
	/**
	 * This Method is Used to Get Indent Item List from 
	 * HSTT_DRUG_MST 
	 * @param vo
	 */
	public static void GetIndentItemList(RoutinePurchaseVO vo) 
	{
		String err = "";
		String proc_name1 = "{call PKG_MMS_VIEW.proc_purchase_item_dtl(?,?,?,?,?,?,?,?)}";
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		try 
		{
			dao = new HisDAO("mms","RoutinePurchaseDAO.GetSoreNameCombo(RoutinePurchaseVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);
			// set value
            dao.setProcInValue(procIndex1,  "modeval", "1",1);			
			dao.setProcInValue(procIndex1,  "hosp_code", vo.getStrHospitalCode(),2);			
			dao	.setProcInValue(procIndex1, "itemCat", vo.getStrItemCategoryNo(),3);
			dao.setProcInValue(procIndex1,  "frmStrId", vo.getStrStoreId(),4);		
			dao	.setProcInValue(procIndex1, "reqType", "86",5);
			dao.setProcInValue(procIndex1,  "userInfo", "0",6);			
			dao.setProcOutValue(procIndex1, "err", 1,7); // 1 for string return
			dao.setProcOutValue(procIndex1, "resultset", 2,8); // 2 for object
			// execute procedure					
			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");
			vo.setIndentItemWS(ws);

			
		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("RoutinePurchaseDAO.GetIndentItemList() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	
	/**
	 * This Method is Used to Get Indent Item List from 
	 * HSTT_DRUG_MST 
	 * @param vo
	 */
	public static void GetIndentItemListForModify(RoutinePurchaseVO vo) 
	{
		String err = "";
		String proc_name1 = "{call PKG_MMS_VIEW.proc_purchase_item_modify_dtl(?,?,?,?,?,?,?,?,?)}";
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		try 
		{
			dao = new HisDAO("mms","RoutinePurchaseDAO.GetSoreNameCombo(RoutinePurchaseVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);
			// set value
            dao.setProcInValue(procIndex1,  "modeval", "1",1);			
			dao.setProcInValue(procIndex1,  "hosp_code", vo.getStrHospitalCode(),2);			
			dao	.setProcInValue(procIndex1, "itemCat", vo.getStrItemCategoryNo(),3);
			dao.setProcInValue(procIndex1,  "frmStrId", vo.getStrStoreId(),4);		
			dao	.setProcInValue(procIndex1, "reqType", "86",5);
			dao.setProcInValue(procIndex1,  "userInfo", "0",6);
			dao	.setProcInValue(procIndex1, "indentNo", vo.getStrReqNo(),7);
			dao.setProcOutValue(procIndex1, "err", 1,8); // 1 for string return
			dao.setProcOutValue(procIndex1, "resultset", 2,8); // 2 for object
			// execute procedure					
			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");
			vo.setIndentItemWS(ws);

			
		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("RoutinePurchaseDAO.GetIndentItemList() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	
	/**
	 * for getting option value of combo on add page (store type name )
	 * 
	 * @param vo
	 */
	public static WebRowSet GetItemCategoryCombo(RoutinePurchaseVO vo) {
		String err = "";
		String proc_name1 = "{call PKG_MMS_VIEW.proc_item_category_list(?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		try {
			// hisutil = new HisUtil("master", "RoutinePurchaseDAO");
			dao = new HisDAO("mms",
					"RoutinePurchaseDAO.GetSoreNameCombo(RoutinePurchaseVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "modeval", "1",1);

			dao.setProcInValue(procIndex1, "store_id", vo.getStrStoreId(),2); // Check
																			// It

			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode(),3);
			
			dao.setProcInValue(procIndex1, "reqType", "0",4); //default value.
			  

			dao.setProcOutValue(procIndex1, "err", 1,5); // 1 for string return

			dao.setProcOutValue(procIndex1, "resultset", 2,6); // 2 for object
			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

		} catch (Exception e) {
			vo.setStrMsgString("RoutinePurchaseDAO.GetItemCategoryCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

		return ws;
	}

	/**
	 * for getting option value of combo on add page (store type name )
	 * 
	 * @param vo
	 */
	public static void ToStoreCombo(RoutinePurchaseVO vo) {
		String err = "";
		String proc_name1 = "{call Pkg_Mms_View.proc_hstt_toStore_mst(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			hisutil = new HisUtil("master", "RoutinePurchaseDAO");
			dao = new HisDAO("mms",
					"RoutinePurchaseDAO.GetDeptCombo(RoutinePurchaseVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

           dao.setProcInValue(procIndex1, "modeval", "1",1);

			

			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode(),2);

			dao.setProcInValue(procIndex1, "storeid", vo.getStrStoreId(),3);

			dao.setProcInValue(procIndex1, "reqType", vo.getStrReqType(),4);
			
			dao.setProcInValue(procIndex1, "catCode", vo.getStrItemCategoryNo(),5);
			

			dao.setProcOutValue(procIndex1, "ERR", 1,6); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2,7); // 2 for object
			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "-1", "0^Select Value", true);
				vo.setStrToStoreCombo(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrToStoreCombo(str);
			}

		} catch (Exception e) {
			vo.setStrMsgString("RoutinePurchaseDAO.ToStoreCombo() --> "
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
	 * INSERT method is used to insert data in following table
	 * 
	 * @param vo
	 */

	public synchronized static void INSERT(RoutinePurchaseVO vo) 
	{
		HisDAO dao = null;
		int procIndex1 = 0;
		String indentNo = "";
		String approvalFlg="";
		DmlIndentDtlDAO globalDao = null;
		try 
		{
			HisUtil util = new HisUtil("","");
			String strCtDate = util.getASDate("dd-MMM-yyyy"); 
			globalDao = new DmlIndentDtlDAO();	
			dao = new HisDAO("MMS","transactions.RoutinePurchaseDAO.INSERT()");
			
//			    //System.out.println("Store ID:::"+vo.getStrStoreId()); 
//			    //System.out.println("Hosp Code:::"+vo.getStrHospitalCode());
//			    //System.out.println("Req Type:::"+vo.getStrReqType());
//			    //System.out.println("Item Catg No:::"+vo.getStrItemCategoryNo());
//			    //System.out.println("Urgent Flag:::"+vo.getStrIsUrgent());
//			    //System.out.println("Indent Period:::"+vo.getStrIndentPeriod());
//			    //System.out.println("Financial Strat Year:::"+vo.getStrFinancialStartYear());
//			    //System.out.println("Financial End Year:::"+vo.getStrFinancialEndYear());
//			    //System.out.println("Remarks:::"+vo.getStrRemarks());
//			    //System.out.println("Seat Id:::"+vo.getStrSeatId());
//			    //System.out.println("Cost req:::"+vo.getStrCostRequired());
//			    //System.out.println("Total Cost:::"+vo.getStrTotalCost());
//			    //System.out.println("Indent Period value:::"+vo.getStrIndentPeriodValue());
			    
			    
				globalDao.setStrId(vo.getStrStoreId());
				globalDao.setHosp_code(vo.getStrHospitalCode());
				globalDao.setReqTypeId(vo.getStrReqType());
				globalDao.setToStrId(vo.getStrToStoreCombo()); 
				globalDao.setItemcatNo(vo.getStrItemCategoryNo());
				globalDao.setItemTypeId("0");  
				globalDao.setUrgentFlag(vo.getStrIsUrgent()); 
				globalDao.setIndentPeriod(vo.getStrIndentPeriod());		
				globalDao.setFinStartDate(vo.getStrFinancialStartYear());
				globalDao.setFinEndDate(vo.getStrFinancialEndYear());
			    globalDao.setRemarks(vo.getStrRemarks());
				globalDao.setSeatId(vo.getStrSeatId());
				globalDao.setGrantTypeId("0");     
				globalDao.setPuk("0");
				globalDao.setEmpNo("0");
				globalDao.setAdmNo("0");
				globalDao.setEpisodeCode("0");
				globalDao.setConsultantId("0");
				globalDao.setMemoNo("0");
				if(vo.getStrCostRequired().equals("0"))
				{	
				   globalDao.setTotCost("0");	
				}
				else
				{
					globalDao.setTotCost(vo.getStrTotalCost());	
				}	
				globalDao.setIndentPeriodValue(vo.getStrIndentPeriodValue());
				
				procIndex1 = globalDao.insert(dao);
			
				dao.fire();     // Here we Execute in Batch
				
		      indentNo    = dao.getString(procIndex1, "indentNo");
		      approvalFlg = dao.getString(procIndex1, "approvalFlg");
//			  //System.out.println("Gnerated Indent No(Routine Purchase)-->>"+indentNo);
//			  //System.out.println("Approval Flg(Routine Purchase)-->>"+approvalFlg);
			  INSERTINTABLE(vo,indentNo,approvalFlg); 
		} 
    	catch (Exception e) 
    	{
    		e.printStackTrace();
			vo.setStrMsgString("--> RoutinePurchaseDAO.INSERT()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} 
    	finally 
    	{
			if (dao != null)
				dao.free();
			dao = null;
		}

	}
	public static void INSERTINTABLE(RoutinePurchaseVO vo,String indentNo,String approvalFlg) 
	{
		HisDAO dao = null;
		String[] temp = null;
		String[] strTemp = null;
		String[] reqQtyUnit=null;
		String strReqQty  = "";
		String strReqUnit ="";
		String strSancQty ="";
		String strSancQtyUnit="";
   	    //DmlHsttLpReqItemDtlDAO tableDao = null;
		DmlHsttPurIndentItemDtlDAO  tableDao = null;
		try 
		{
			HisUtil util = new HisUtil("","");
			String strCtDate = util.getASDate("dd-MMM-yyyy"); 
			// Createing Object for Table Specific DAO
			tableDao  = new DmlHsttPurIndentItemDtlDAO();
    		dao = new HisDAO("MMS","transactions.RequestForRoutinePurchaseDAO.INSERTINTABLE()");
 			int length = vo.getItemParamValue().length;
 			for(int i = 0;i<length;i++)
			{		        
				
				strTemp         = vo.getItemUserValue()[i].replace('^', '#').split("#");
				if(!vo.getStrReqQty()[i].equals("0") && !vo.getStrReqQty()[i].equals("")&& !vo.getStrReqQty()[i].equals("  "))
				{	
				
				//System.out.println("ItemID-1->>"+strTemp[0]);
				//System.out.println("ItemBrandID-2->>"+strTemp[1]);
				//System.out.println("GrpID-3->>"+strTemp[2]);
				//System.out.println("Sub_GrpID-4->>"+strTemp[3]);
				//System.out.println("Cosumble Flg-5->>"+strTemp[4]);
				//System.out.println("Re-Order Qty-6->>"+strTemp[5]);
				//System.out.println("Re-Order Qty unit Id-7->>"+strTemp[6]);
				//System.out.println("In Hand Qty-8->>"+strTemp[7]);
				//System.out.println("In Hand Qty Unit Id-9->>"+strTemp[8]);
				//System.out.println("Last Rate-10->>"+strTemp[9]);
				//System.out.println("Last Rate Unit Id-11->>"+strTemp[10]);				
				//System.out.println("Inventory Unit Id-12->>"+strTemp[11]);
				//System.out.println("Last PO No-13->>"+strTemp[12]);
				//System.out.println("Last PO Date-14->>"+strTemp[13]);
				//System.out.println("Last Supplied By [Id]-15->>"+strTemp[14]);
				//System.out.println("Batch No-16->>"+strTemp[15]);
				//System.out.println("Expiry Date-17->>"+strTemp[16]);
				//System.out.println("Manufacture Date-18->>"+strTemp[17]);
				//System.out.println("Item Serial No-19->>"+strTemp[18]);
				//System.out.println("Last Received Qty [PO]-20->>"+strTemp[19]);
				//System.out.println("Last Received Qty Unit Id [PO]-21->>"+strTemp[20]);				
				//System.out.println("Last Indented Qty-22->>"+strTemp[21]);
				//System.out.println("Last Indented Qty Unit Id-23->>"+strTemp[22]);
				//System.out.println("Last Received Qty-24->>"+strTemp[23]);
				//System.out.println("Last Received Qty Unit Id-25->>"+strTemp[24]);
				//System.out.println("Last Year Consumption Qty-26->>"+strTemp[25]);
				//System.out.println("Last Year Consumption Qty Unit Id-27->>"+strTemp[26]);
				//System.out.println("Prefix-28->>"+strTemp[27]);
				//System.out.println("Cost Parameter-29->>"+strTemp[28]);
				//System.out.println("Cost Unit [on individual item or on total cost]-30->>"+strTemp[29]);
				//System.out.println("Purchase Lead Time-31->>"+strTemp[30]);				
				//System.out.println("Purchase Lead Time Unit-32->>"+strTemp[31]);
				//System.out.println("Stock Status-33->>"+strTemp[32]);
				
				 strReqQty      = vo.getStrReqQty()[i];				
	    	     ////System.out.println("strReqQty-->>"+strReqQty);
	    	     ////System.out.println("reqQtyUnit[0]-->>"+reqQtyUnit[0]);
			     if(approvalFlg.equals("0"))
			     {
			    	  strSancQty     = strReqQty;
			 		  strSancQtyUnit = strTemp[11];
			     }	
			     else
			     {
			    	 strSancQty     = "0";
			    	 strSancQtyUnit = "0";
			     }	  		    	 

				
				// ////System.out.println("indent Anual Purchase No-in 2..->>>"+indentNo);
				 //////System.out.println("Store ID 2.....--->>>"+vo.getStrStoreId());
				 
				 tableDao.setStrId(vo.getStrStoreId());
				 tableDao.setStrReqNo(indentNo);
				 tableDao.setItemId(strTemp[0]);
				 tableDao.setItemBrandId(strTemp[1]);
				 tableDao.setHosp_code(vo.getStrHospitalCode());
				 tableDao.setStrPurchseReqDate(strCtDate);
				 tableDao.setGroupId(strTemp[2]);
				 tableDao.setSubGroupId(strTemp[3]);
				 tableDao.setRate(strTemp[9]);
				 tableDao.setRateUnitId(strTemp[10]);
				 tableDao.setIndentQty(strReqQty);
				 tableDao.setIndentQtyUnitId(strTemp[11]);
				 tableDao.setSancQty(strSancQty);
				 tableDao.setSancQtyUnitId(strSancQtyUnit);
				 tableDao.setInHandQty(strTemp[7]);
				 tableDao.setInHandQtyUnitId(strTemp[8]);
				 tableDao.setReOrderLevel(strTemp[5]);
				 tableDao.setReOrderUnitId(strTemp[6]);
				 tableDao.setManufacturerId("0");
				 tableDao.setApproxRate(strTemp[9]);
				 tableDao.setApproxRateUnitId(strTemp[10]);
				 tableDao.setLstYearConsumption(strTemp[25]);
				 tableDao.setLstYearConsumptionUnitId(strTemp[26]);
				 tableDao.setStrJustification("0");
				 tableDao.setRemarks(vo.getStrRemarks());
				 tableDao.setIsValid("1");
				 tableDao.setStrLstPoNo(strTemp[12]); 
				 tableDao.setStrLstPoDate(strTemp[13]);
				 tableDao.setStrLstRecQty(strTemp[23]);
				 tableDao.setStrLstRecQtyUnitId(strTemp[24]);
				 tableDao.setStrLstRecDate("01-01-2013");   // Plz Check It....Dummy Value
				 tableDao.setStrLstSupplierId(strTemp[14]); 
				 		 
				 tableDao.insert(dao);
				}	
					
	          }
		      synchronized(dao)   
			  {
	        	dao.fire();     // Here we Execute in Batch
			  }
		    
		} 
    	catch (Exception e) 
    	{
    		e.printStackTrace();
			vo.setStrMsgString("--> RoutinePurchaseDAO.INSERTINTABLE()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} 
    	finally 
    	{
			if (dao != null)
				dao.free();
			dao = null;
		}

	}
	
	public synchronized static void MODIFY(RoutinePurchaseVO vo) 
	{
		HisDAO dao = null;
		String[] temp = null;
		String[] strTemp = null;
		String[] reqQtyUnit=null;
		String strReqQty  = "";
		String strReqUnit ="";
		String strSancQty ="";
		String strSancQtyUnit="";
   	    //DmlHsttLpReqItemDtlDAO tableDao = null;
		DmlHsttPurIndentItemDtlDAO  tableDao = null;
		try 
		{
			HisUtil util = new HisUtil("","");
			String strCtDate = util.getASDate("dd-MMM-yyyy"); 
			// Createing Object for Table Specific DAO
			//tableDao  = new DmlHsttLpReqItemDtlDAO();
			tableDao  = new DmlHsttPurIndentItemDtlDAO();
    		dao = new HisDAO("MMS","transactions.RequestForRoutinePurchaseDAO.MODIFY()");
 			int length = vo.getItemParamValue().length;
 			for(int i = 0;i<length;i++)
			{		        
				
				strTemp         = vo.getItemParamValue()[i].replace('^', '#').split("#");
				/*			
				/*
					  	 1.Group Name
					  	 2.CPA Code
					  	 3.Item Name
					  	 4.Avalaible Quantity
					  	 5.Last Indent Quantity
					  	 6.Total Qty
					  	 7.Approx Cost
					  	 
					  	 8.Item Brand Id
					  	 9.Item ID
					  	 10.Rate With Unit
					  	 11.Rate for Calculation	
					  	 ---------------------------------				  	 
					  	   12(0).Item Id
					  	   12(1).Item Brand ID
					  	   12(2).Group ID
					  	   12(3).Sub-Grp Id
					  	   12(4).Cosumable Flag
					  	   12(5).Re-Order Qty
					  	   12(6).Re-Order Qty Unit Id
					  	   12(7).In-Hand Qty
					  	   12(8).In-Hand Qty Unit Id
					  	   12(9).Last Rate
					  	   12(10).Last Rate Unit Id
					  	   12(11).Inventory Unit Id
					  	   12(12).Last PO No. 
					  	   12(13).Last PO Date
	                       12(14).Last Supplied By
	                       12(15).Batch No
	                       12(16).Expiry date
	                       12(17).Manufactrer Date
	                       12(18).Item Serial No
	                       12(19).Last Received Qty
	                       12(20).Last Received Qty Unit
	                       12(21).Last Indented Qty
	                       12(22).Last Indented Qty Unit Id
	                       12(23).Last Received Qty
	                       12(24).Last Received Qty Unit ID
	                       12(25).Last Year Consumption Qty
	                       12(26).Last Year Consumption Qty Unit Id
	                       12(27).Prefix
	                       12(28).Cost Parameter
	                       12(29).Cost Unit
	                       12(30).Purchase Lead Time
	                       12(31).Purchase Lead Time Unit
	                       12(32).Stock Status 
	                       12(33).Dummy
	                       12(34).Dummy
	                       12(35).Brand Reserved Flg
	                       12(36).Item Make
	                       12(37).CPA Code
	                       12(38).Dummy
	                       12(39).NA
                       -----------------------------
                       13.CHM_QTY
                       14.MC_QTY*/
				 
				 strReqQty      = vo.getStrTotalQty()[i];
				// strReqUnit     = vo.getStrUnitName()[i];
		    	 
			     
			     strSancQty     = strReqQty;
			 	 strSancQtyUnit = strTemp[11];
			      		    	 
			     tableDao.setStrId(vo.getStrStoreId());
				 tableDao.setStrReqNo(vo.getStrReqNo());
				 tableDao.setItemId(strTemp[0]);
				 tableDao.setItemBrandId(strTemp[1]);
				 tableDao.setHosp_code(vo.getStrHospitalCode());
				 tableDao.setStrPurchseReqDate(strCtDate);
				 tableDao.setGroupId(strTemp[2]);
				 tableDao.setSubGroupId(strTemp[3]);
				 tableDao.setRate(strTemp[9]);
				 tableDao.setRateUnitId(strTemp[10]);
				 tableDao.setIndentQty(strReqQty);
				 tableDao.setIndentQtyUnitId(strTemp[11]);
				 tableDao.setSancQty(strSancQty);
				 tableDao.setSancQtyUnitId(strSancQtyUnit);
				 tableDao.setInHandQty(strTemp[7]);
				 tableDao.setInHandQtyUnitId(strTemp[8]);
				 tableDao.setReOrderLevel(strTemp[5]);
				 tableDao.setReOrderUnitId(strTemp[6]);
				 tableDao.setManufacturerId("0");
				 tableDao.setApproxRate(strTemp[9]);
				 tableDao.setApproxRateUnitId(strTemp[10]);
				 tableDao.setLstYearConsumption(strTemp[25]);
				 tableDao.setLstYearConsumptionUnitId(strTemp[26]);
				 tableDao.setStrJustification("0");
				 tableDao.setRemarks(vo.getStrRemarks());
				 tableDao.setIsValid("1");
				 tableDao.setStrLstPoNo(strTemp[12]); 
				 tableDao.setStrLstPoDate(strTemp[13]);
				 tableDao.setStrLstRecQty(strTemp[23]);
				 tableDao.setStrLstRecQtyUnitId(strTemp[24]);
				 tableDao.setStrLstRecDate("");   // Plz Check It....Dummy Value
				 tableDao.setStrLstSupplierId(strTemp[14]);
				 tableDao.setStrMCQty(vo.getStrMCQty()[i]);
				 tableDao.setStrCHMOQty(vo.getStrCHMOQty()[i]);
				 tableDao.insert(dao);
	          }
 			
 			dao.fire();     // Here we Execute in Batch
		    
		} 
    	catch (Exception e) 
    	{
    		e.printStackTrace();
			vo.setStrMsgString("--> RoutinePurchaseDAO.INSERTINTABLE()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} 
    	finally 
    	{
			if (dao != null)
				dao.free();
			dao = null;
		}

	}
	
	
	
	
	/**
	 * *****************This Method is Used for Insert Logic in Add * Services**************
	 * */
	public static void UpdatePurItemOrderQty(RoutinePurchaseVO vo, HisDAO dao, int i,String indentNo,String approvalFlg,String strItemID,String strItemBrandID,String orderQty,String orderQtyUnit) 
	{
		String proc_name = "";
		proc_name = "{call pkg_mms_dml.Update_PUR_INDENT_Order(?,?,?,?,?,?,?,?,?,?)}";
		int nprocIndex = 0;
		
		try 
		{			
			
			nprocIndex = dao.setProcedure(proc_name);

			dao.setProcInValue(nprocIndex, "modval", "1",1); // 1

			dao.setProcInValue(nprocIndex, "p_GNUM_HOSPITAL_CODE", vo.getStrHospitalCode(),2); // 2

			dao.setProcInValue(nprocIndex, "p_HSTNUM_PUR_REQNO", indentNo,3); // 3

			dao.setProcInValue(nprocIndex, "p_HSTNUM_ITEM_ID", strItemID,4); // 4

			dao.setProcInValue(nprocIndex, "p_HSTNUM_ITEMBRAND_ID", strItemBrandID,5); // 5

			dao.setProcInValue(nprocIndex, "p_HSTNUM_ITEM_SLNO", "0",6); // 6

			dao.setProcInValue(nprocIndex, "p_HSTNUM_ORDER_QTY", orderQty,7); // 7
			
			dao.setProcInValue(nprocIndex, "p_HSTNUM_ORDERQTY_UNITID", orderQtyUnit,8); // 8
			
			dao.setProcInValue(nprocIndex, "p_HSTNUM_STORE_ID", vo.getStrStoreId(),9); // 9
						
			dao.setProcOutValue(nprocIndex, "err", 1,10); // 10 for return string
			// //26

			// execute procedure

			dao.execute(nprocIndex, 1);

		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("RefundApprovalTransDAO.UpdatePurItemOrderQty() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		}

	}
	
	
	/**
	 * **************This Method i****************
	 * */
	public static void UpdateIndentDetails(RoutinePurchaseVO vo)
	{
		String proc_name = "";
		proc_name = "{call pkg_mms_dml.dml_pur_indent_modify(?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?)}";  // 17 Variables
		int nprocIndex = 0;
		int counter = 1;
		HisDAO dao = null;
		try 
		{			
			dao = new HisDAO("MMS","transactions.RequestForRoutinePurchaseDAO.UpdateIndentDetails()");
			
			nprocIndex = dao.setProcedure(proc_name);

			for (int i = 0; i < vo.getStrMCQty().length; i++) 
			{
				if(!vo.getStrTotalQty()[i].equals("0"))
				{
					dao.setProcInValue(nprocIndex, "modval", "1",1); // 1
		
					dao.setProcInValue(nprocIndex, "counter", String.valueOf(counter),2); // 2
		
					dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId(),3); // 3
		
					dao.setProcInValue(nprocIndex, "indentNo", vo.getStrReqNo(),4); // 4
		
					dao.setProcInValue(nprocIndex, "hosp_code",vo.getStrHospitalCode(),5); // 5
		
					dao.setProcInValue(nprocIndex, "itemId", vo.getItemId()[i],6); // 6
		
					dao.setProcInValue(nprocIndex, "itemBrandId", vo.getItemBrandId()[i],7); // 7
					
					dao.setProcInValue(nprocIndex, "mcQty", vo.getStrCHMOQty()[i],8); // 8
					dao.setProcInValue(nprocIndex, "chmoQty", vo.getStrMCQty()[i],9); // 9
					
					////System.out.println("Index:::"+counter+"::::CHMO QTy:::"+vo.getStrCHMOQty()[i]);
					////System.out.println("Index:::"+counter+"::::MCQty:::"+vo.getStrMCQty()[i]);	
					
					////System.out.println("Index:::"+counter+"::::rate:::"+vo.getItemParamValue()[i].split("\\#")[0]);
					////System.out.println("Index:::"+counter+"::::totalQty:::"+vo.getStrTotalQty()[i]);
					
					//dao.setProcInValue(nprocIndex, "mcQty", vo.getStrMCQty()[i]); // 9
					
					dao.setProcInValue(nprocIndex, "rate", vo.getItemParamValue()[i].split("\\#")[0],10); // 10
		
					dao.setProcInValue(nprocIndex, "rateUnit", vo.getItemParamValue()[i].split("\\#")[1],11); // 11
					
					dao.setProcInValue(nprocIndex, "totalQty", vo.getStrTotalQty()[i],12); // 12
					
					dao.setProcInValue(nprocIndex, "indentSts", vo.getStrIndentStatus(),13); // 13
					
		            dao.setProcInValue(nprocIndex, "totalCost", vo.getStrTotalCost(),14); // 14
		           
					
					dao.setProcInValue(nprocIndex, "remarks", vo.getStrRemarks(),15); // 15
					
					////System.out.println("Indent Date==>"+vo.getStrTmpIndentDate());
					
					dao.setProcInValue(nprocIndex, "indentDate", vo.getStrTmpIndentDate(),16); // 16				
								
					dao.setProcOutValue(nprocIndex, "err", 1,17); // 17 for return string
					dao.execute(nprocIndex, 1);
					counter++;
					
				}
			}
			synchronized (dao) 
			{
				dao.fire();
				
			}

		} catch (Exception e) {
			// e.printStackTrace();
			vo
					.setStrMsgString("RefundApprovalTransDAO.UpdateIndentDetails() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		}

	}
	
	
}
