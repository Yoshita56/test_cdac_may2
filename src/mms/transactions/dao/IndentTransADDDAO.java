package mms.transactions.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
import mms.dao.DmlHsttIndentItemDtlDAO;
import mms.dao.DmlIndentDtlDAO;
import mms.transactions.vo.IndentTransADDVO;

/**
 * @author Amit Kumar Date of Creation : 31/3/2009 Date of Modification : / /
 *         Version : 1.0 Module : Store
 */
public class IndentTransADDDAO 
{
	
	/**
	 * Gets the item brand list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the item brand list
	 */
	public static void getItemBrandList(IndentTransADDVO vo) 
	{

		String err = "";
		String proc_name1 = "";

		proc_name1 = "{call pkg_mms_view.Proc_Itembrand_Detail(?,?,?,?,?   ,?,?,?,?,?   ,?)}"; // 11

		System.out.println("-- MMSDAO . getItemBrandList -- - " + proc_name1 + " - [ Mode - 1 ]---");

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try 
		{

			dao = new HisDAO("mms", "IssueToPatOPDTransDAO.getItemBrandList(IssueToPatOPDTransVO vo)");
			
			System.out.println("-- vo.getStrHospitalCode() -- - " + vo.getStrHospitalCode());
			System.out.println("-- vo.getStrItemCategory() -- - " + vo.getStrItemCategory());
			System.out.println("-- vo.getStrStoreId() -- - " + vo.getStrStoreId());
			System.out.println("-- vo.getStrToStore() -- - " + vo.getStrToStore());			
			System.out.println("-- vo.getStrIndentTypeId() -- - " + vo.getStrIndentTypeId());
		
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "modeval",   	"1", 1);
			dao.setProcInValue(procIndex1, "hosp_code", 	vo.getStrHospitalCode(), 2);
			dao.setProcInValue(procIndex1, "itemCat",   	vo.getStrItemCategory(), 3);
			dao.setProcInValue(procIndex1, "frmStrId",  	vo.getStrStoreId(), 4);
			dao.setProcInValue(procIndex1, "genericItemId", "0", 5);
			dao.setProcInValue(procIndex1, "reqType", 		vo.getStrIndentTypeId(), 6);
			dao.setProcInValue(procIndex1, "userInfo", 		vo.getStrToStore(), 7);
			dao.setProcInValue(procIndex1, "grpId", 		"0", 8);
			dao.setProcInValue(procIndex1, "subGrpId", 		"0", 9);
			dao.setProcOutValue(procIndex1, "err", 			1, 10); // 1 for string return
			dao.setProcOutValue(procIndex1, "resultset",	2, 11); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			vo.setStrBrandItemListWs(ws);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("MmsDAO.getItemBrandList() --> " + e.getMessage());
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
	public static void GetData(IndentTransADDVO vo) {
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			hisutil = new HisUtil("master", "IndentTransADDDAO");
			dao = new HisDAO("MMSModule",
					"IndentTransADDDAO.GetData(IndentTransADDVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "modeval", "1",1);

			dao.setProcInValue(procIndex1, "item_category",
					vo.getStrItemCategory(),2);

			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),3);

			/* Setting Default Value Start */
			dao.setProcInValue(procIndex1, "strPhyStockNo", "",4);
			dao.setProcInValue(procIndex1, "strStoreId", "",5);
			/* Setting Default Value End */

			dao.setProcOutValue(procIndex1, "err", 1,6); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2,7); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "-1", "0^Select Value", true);
				vo.setStrGroupIdForItemSearch(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrGroupIdForItemSearch(str);
			}
		} catch (Exception e) {
			vo.setStrMsgString("IndentTransADDDAO.GetData() --> "
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
	 * for getting Item category Combo by passing STORE_ID & HOSP_CODE
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void itemCategoryCombo(IndentTransADDVO vo)
	{
		int     nProcIndex = 0;
		String      strErr = "";
		String         str = "";
		HisUtil    hisutil = null;
		WebRowSet       ws = null;
		HisDAO      daoObj = null;		
		String strProcName = "{call PKG_MMS_VIEW.proc_item_category_list(?,?,?,?,?,?)}";
	      
		try
		{
			// Creating Object
			   hisutil = new HisUtil("MMS", "OfflineIssueIndentDAO");
			   daoObj  = new HisDAO("MMS","OfflineIssueIndentDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			// Set Values
			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "reqType","31",4);
			daoObj.setProcOutValue(nProcIndex,"err",1,5); 
			daoObj.setProcOutValue(nProcIndex,"resultset",2,6);
			// execute procedure
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			// get values
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
					
			if (strErr.equals("")) 
			{
				if(ws!=null)
				{
					str = hisutil.getOptionValue(ws, vo.getStrItemCategory(),"0^Select Value", true);
					
					vo.setStrItemCategoryCmb(str);		
					vo.setStrMsgType("0");
				}	
				else
				{
					str = "<option value='0'>DATA N/A</option>";  
					vo.setStrItemCategoryCmb(str);
					vo.setStrMsgType("0");
				}
				
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			vo.setStrMsgString("OfflineIssueIndentDAO.itemCategoryCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	public static void getIssueDtlsList(IndentTransADDVO vo) 
	{
		String err;
		String strSlNoflg;
		HisDAO     dao = null;
		WebRowSet   ws = null;
		int procIndex1 = 0;
		int nFuncIndex = 0;
		 /* Function Added By Amit on Date 24/09/2010  */
		 /* Function Used to get Flag whether SlNo Coloum will be shown or not in Report*/
		String strFuncName = "{? = call MMS_MST.get_reqperfix(?::numeric,?::numeric,?::numeric)}";
		
		
		
		String proc_name1 = "{call pkg_mms_view.proc_view_issue_desk_dtl(?,?,?,?,?  ,?,?)}"; //7
		try 
		{
			
			dao = new HisDAO("mms","global.MmsDAO.getStockItemDtlsList(IndentTransADDVO vo)");
			
			
			nFuncIndex = dao.setFunction(strFuncName);
			
			System.out.println("IndentTransADDCNT -> issueDetails_util.js --> IndentTransADDCNT -->> ISSUEDTLSINIT --> MmsDAO.getIssueDtlsList() --------------------");
			
			System.out.println("----------IssueDesk Voucher PRINT-----pkg_mms_view.proc_view_issue_desk_dtl [ Mode - 1 ]---------------------");	       
		   
			procIndex1 = dao.setProcedure(proc_name1);

			// set value			
			
			dao.setProcInValue(procIndex1, "modeval"  ,   "1",1);
			dao.setProcInValue(procIndex1, "hosp_code",   vo.getStrHospitalCode(),2);
			dao.setProcInValue(procIndex1, "indent_no",   vo.getStrIndentNo(),3);			
			dao.setProcInValue(procIndex1, "store_id",    vo.getStrStoreId(),4);
			dao.setProcInValue(procIndex1, "to_store_id", vo.getStrToStore(),5);	
			dao.setProcOutValue(procIndex1,"err"      ,   1,6); // 1 for string return
			// value
			dao.setProcOutValue(procIndex1, "resultset",  2,7); // 2 for object
			// execute procedure
			dao.executeProcedureByPosition(procIndex1);
			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");
            //System.out.println("MMs DAO size:::"+ws.size());
			if (ws != null && ws.size() > 0) {

				if (ws.next()) 
				{
					/*
					 * 1.Item Name
					 * 2.Avl Qty
					 * 3.Indenty Qty
					 * 4.Sanc Qty
					 * 5.Indent No
					 * 6.Indent Date
					 * 7.To Store Name
					 * 8.Indent Period
					 * 9.Indent Type Name
					 * 10.Gen By User Name
					 * 11.From Store Name					
					 * 12. remarsk
					 * */
					vo.setStrIndentNo(ws.getString(5));
					vo.setStrIndentDate(ws.getString(6));				
					vo.setStrStoreName(ws.getString(11));
					vo.setStrToStoreName(ws.getString(7));
					
					vo.setStrIndentTypeName(ws.getString(9));
					vo.setStrIndentGenByName(ws.getString(10));
					vo.setStrIndentPeriodName(ws.getString(8));
					/*
					System.out.println("Store ID==>"+vo.getStrIndentNo());
					System.out.println("StrIndentDate==>"+vo.getStrIndentDate());
					System.out.println("StoreName==>"+vo.getStrStoreName());
					System.out.println("StrIndentTypeName==>"+vo.getStrIndentTypeName());
					System.out.println("StrIndentGenByName==>"+vo.getStrIndentGenByName());
					System.out.println("StrIndentPeriodName==>"+vo.getStrIndentPeriodName());
					*/
									    
					
				}
  
				ws.beforeFirst();

			}

			vo.setWsIndentDetails(ws);

		} catch (Exception e) {
            e.printStackTrace();
			vo.setStrMsgString("MmsDAO.getIssueDtlsList() --> "
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
	 * To Get Data
	 * 
	 * @param vo
	 */
	public static void getAvalBudgetDetails(IndentTransADDVO vo) 
	{
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_hstt_budget_dtl(?,?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

				dao = new HisDAO("MMS Transactions","IndentTransADDDAO");
						
				procIndex1 = dao.setProcedure(proc_name1);
				
				dao.setProcInValue(procIndex1, "p_mode", "4",1);
				// set value
				////System.out.println("Store ID==>"+vo.getStrStoreId());
				////System.out.println("Start==>"+vo.getStrFinancialStartDate());
				////System.out.println("END==>"+vo.getStrFinancialEndDate());
				
				dao.setProcInValue(procIndex1, "p_hstnum_store_id", vo.getStrStoreId(),2);
				dao.setProcInValue(procIndex1, "p_hstdt_finstart_date", vo.getStrFinancialStartDate(),3);
				dao.setProcInValue(procIndex1, "p_hstdt_finend_date", vo.getStrFinancialEndDate(),4);
				dao.setProcInValue(procIndex1, "p_gnum_hospital_code", vo.getStrHospitalCode(),5);
				dao.setProcInValue(procIndex1, "p_hstnum_slno", "0",6);
							
				/* Setting Default Value End */
				
				dao.setProcOutValue(procIndex1, "err", 1,7); // 1 for string return
				// value
				dao.setProcOutValue(procIndex1, "resultset", 2,8); // 2 for object
		
				// execute procedure
		
				dao.executeProcedureByPosition(procIndex1);
		
				// get value
				err = dao.getString(procIndex1, "err");
		
				if (err == null)
					err = "";
		
				ws = dao.getWebRowSet(procIndex1, "resultset");
						
				while(ws.next())
				{
					////System.out.println("Avl budget==>"+ws.getString(1));
					////System.out.println("Budget Dtl==>"+ws.getString(2)+"$$"+ws.getString(3));
					vo.setStrAvalaibleBudget(ws.getString(1));
					vo.setStrAvalaibleBudgetDtl(ws.getString(2)+"$$"+ws.getString(3));
				}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IssueTransDAO.getAvalBudgetDetails() --> "	+ e.getMessage());
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
	public static void ToStoreCombo(IndentTransADDVO vo) {
		String err = "";
		String proc_name1 = "{call Pkg_Mms_View.proc_hstt_toStore_mst(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			hisutil = new HisUtil("master", "IndentTransADDDAO");
			dao = new HisDAO("mms",
					"IndentTransADDDAO.GetDeptCombo(IndentTransADDVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "modeval", "1",1);

			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),2);

			dao.setProcInValue(procIndex1, "storeid", vo.getStrStoreId(),3);

			dao.setProcInValue(procIndex1, "reqType", vo.getStrIndentTypeId(),4);

			dao.setProcInValue(procIndex1, "catCode", vo.getStrItemCategory(),5);

			dao.setProcOutValue(procIndex1, "err", 1,6); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2,7); // 2 for object
			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			if (ws != null && ws.size() != 0) 
			{
				while(ws.next())
				{
					vo.setStrToStore(ws.getString(1));
				}
				ws.beforeFirst();
				
				str = hisutil.getOptionValue(ws, "", "", true);
				vo.setStrToStoreCombo(str);
			} 
			else 
			{
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrToStoreCombo(str);
			}

		} catch (Exception e) {
			vo.setStrMsgString("IndentTransADDDAO.ToStoreCombo() --> "
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
	 * for getting option value of combo on add page (Indent Period Combo)
	 * 
	 * @param vo
	 */
	public static void IndentPeriodCombo(IndentTransADDVO vo) {
		String err = "";
		String proc_name1 = "{call PKG_MMS_VIEW.PERIOD_COMBO_SSTT_PERIOD_MST(?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			hisutil = new HisUtil("master", "IndentTransADDDAO");
			dao = new HisDAO("mms",
					"IndentTransADDDAO.GetDeptCombo(IndentTransADDVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "modeval", "1",1);

			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),2);

			dao.setProcOutValue(procIndex1, "err", 1,3); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2,4); // 2 for object
			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "13", "0^Select Value", true);
				vo.setStrIndentPeriodCombo(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrIndentPeriodCombo(str);
			}

		} catch (Exception e) {
			vo.setStrMsgString("IndentTransADDDAO.ToStoreCombo() --> "
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
	 * This Function return Store Name on the basis of Hospital Code and Store
	 * Id
	 * 
	 * @param vo
	 * */

	public static void callingFunctionStoreName(IndentTransADDVO vo) {
		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;

		try {
			dao = new HisDAO("MMSModule", "IndentTransADDDAO");
			funcIndex = dao
					.setFunction("{? = call MMS_MST.get_store_dtl(?::numeric,?::numeric,?::numeric)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, "1");
			dao.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4, vo.getStrStoreId());
			dao.setFuncOutValue(funcIndex, 1);
			// Execute Function
			dao.executeFunction(funcIndex);
			retVal = dao.getFuncString(funcIndex);

			if (retVal != null) {
				vo.setStrStoreNameFunc(retVal);
			} else {
				retVal = "-----";
				vo.setStrStoreNameFunc(retVal);
			}

		} catch (Exception e) {
			vo.setStrMsgString("IndentTransADDDAO.callingFunctionStoreName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * This Function return Indent Type on the basis of Hospital Code and Indent
	 * Type Id
	 * 
	 * @param vo
	 * */
	public static void callingFunctionIndentType(IndentTransADDVO vo) {
		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		try {
			dao = new HisDAO("MMSModule", "IndentTransADDDAO");
			funcIndex = dao
					.setFunction("{? = call MMS_MST.get_indentType_Name(?,?,?)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, "1");
			dao.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4, vo.getStrIndentTypeId());
			dao.setFuncOutValue(funcIndex, 1);
			// Execute Function
			dao.executeFunction(funcIndex);
			retVal = dao.getFuncString(funcIndex);
			if (retVal != null) {
				vo.setStrIndentTypeFunc(retVal);
			} else {
				retVal = "-----";
				vo.setStrIndentTypeFunc(retVal);
			}

		} catch (Exception e) {
			vo.setStrMsgString("IndentTransADDDAO.callingFunctionIndentType() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/*
	 * This Function return Item Category on the basis of Hospital Code and Item
	 * Category
	 * 
	 * @param vo
	 */
	public static void callingItemCategory(IndentTransADDVO vo) {

		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		try {
			dao = new HisDAO("MMSModule", "IndentTransADDDAO");
			funcIndex = dao
					.setFunction("{? = call MMS_MST.get_itemcat_dtl(?,?,?)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, "1");
			dao.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4, vo.getStrItemCategory());
			dao.setFuncOutValue(funcIndex, 1);
			// Execute Function
			dao.executeFunction(funcIndex);
			retVal = dao.getFuncString(funcIndex);
			if (retVal != null) {
				vo.setStrItemCategoryFunc(retVal);
			} else {
				retVal = "-----";
				vo.setStrItemCategoryFunc(retVal);
			}

		} catch (Exception e) {
			vo.setStrMsgString("IndentTransADDDAO.callingItemCategory() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void INSERT_NEW(IndentTransADDVO vo) 
	{
		HisDAO dao = null;
		int nInsertedIndex=0,nInsertedIndex2=0;
		String indentNo = "";
		String approvalFlg ="";
		String approvalDtls ="";
		
		String[] temp = null;
		String[] strTemp = null;
		String[] reqQtyUnit=null;
		String strReqQty  = "";
		String strReqUnit ="";
		String strSancQty ="";
		String strSancQtyUnit="";		
		System.out.println("-------IndentTransADDDAO.INSERT_NEW()----------");		
		
		try
		{
			
				String strReturnReqNo="0";	    	  
				int funcIndex = 0;			
				
				System.out.println("-------mms_mst.generate_indentno----------");	
				
				System.out.println("getStrHospitalCode--->>>"+vo.getStrHospitalCode());
				System.out.println("getStrReqType--->>>"+vo.getStrReqType());
				System.out.println("getStrStoreId--->>>"+vo.getStrStoreId());
				System.out.println("getStrItemCatg--->>>"+vo.getStrItemCatNo());
				
				dao = new HisDAO("MMS","transactions.ReturnRequestTransDAO.INSERT_NEW()");	  
				
				funcIndex = dao.setFunction("{? = call  mms_mst.generate_indentno (?, ?, ?, ?)}");					
				dao.setFuncInValue(funcIndex, 2, vo.getStrHospitalCode());
				dao.setFuncInValue(funcIndex, 3, vo.getStrReqType());
				dao.setFuncInValue(funcIndex, 4, vo.getStrStoreId());
				dao.setFuncInValue(funcIndex, 5, vo.getStrItemCatNo());	
				dao.setFuncOutValue(funcIndex, 1);	
				// Execute Function
				dao.executeFunction(funcIndex);
				strReturnReqNo = dao.getFuncString(funcIndex);
				indentNo = strReturnReqNo;								
				System.out.println("indentNo--->>>"+indentNo);		
				vo.setStrIndentNo(indentNo);
				
                int appfuncIndex = 0;		
                
                System.out.println("getStrToStore--->>>"+vo.getStrToStore());
				System.out.println("getStrSeatId--->>>"+vo.getStrSeatId());
				
				
				System.out.println("-------mms_mst.generate_indentno----------");	
				
				appfuncIndex = dao.setFunction("{? = call  mms_mst.get_approval_status (?, ?, ?, ? ,?  ,?,?,?,?,?)}");				
				dao.setFuncInValue(appfuncIndex, 2, "2");
				dao.setFuncInValue(appfuncIndex, 3, vo.getStrHospitalCode());
				dao.setFuncInValue(appfuncIndex, 4, "1");
				dao.setFuncInValue(appfuncIndex, 5, vo.getStrReqType());
				dao.setFuncInValue(appfuncIndex, 6, vo.getStrItemCatNo());
				dao.setFuncInValue(appfuncIndex, 7, vo.getStrStoreId());
				dao.setFuncInValue(appfuncIndex, 8, vo.getStrSeatId());
				dao.setFuncInValue(appfuncIndex, 9, "0");
				dao.setFuncInValue(appfuncIndex, 10,vo.getStrToStore());
				dao.setFuncInValue(appfuncIndex, 11,"1");
				dao.setFuncOutValue(appfuncIndex, 1);	
				// Execute Function
				dao.executeFunction(appfuncIndex);
				approvalDtls = dao.getFuncString(appfuncIndex);
				
				System.out.println("approvalDtls-0^40-->>>"+approvalDtls);
				
				approvalFlg = approvalDtls.split("\\^")[0];
			
	    			
	    			nInsertedIndex = dao.setProcedure("{call PKG_MMS_DML.dml_indent_new_dtl (?,?,?,?,? , ?,?,?,?,?  ,?,?,?,?,? ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?,  ?,?,?)}");
	    			
	    			
	    			
	    			dao.setProcInValue(nInsertedIndex,"modval",				"1",1); 
	    			dao.setProcInValue(nInsertedIndex,"indentno",			indentNo,2);
	    		   	dao.setProcInValue(nInsertedIndex,"strId",				vo.getStrStoreId(),3);                  
	    	       	dao.setProcInValue(nInsertedIndex,"hosp_code",			vo.getStrHospitalCode(),4);          
	    			dao.setProcInValue(nInsertedIndex,"reqTypeId ",			vo.getStrReqType(),5);         
	    			dao.setProcInValue(nInsertedIndex,"toStrId",			vo.getStrToStoreCombo(),6);              
	    			dao.setProcInValue(nInsertedIndex,"itemcatNo",			vo.getStrItemCatNo(),7);           
	    			dao.setProcInValue(nInsertedIndex,"itemTypeId", 		"0",8);        
	    			dao.setProcInValue(nInsertedIndex,"urgentFlag", 		vo.getStrUrgentFlg(),9);
	    			//8
	    			dao.setProcInValue(nInsertedIndex,"indentPeriod",		"0",10);    
	    			dao.setProcInValue(nInsertedIndex,"finStartDate",		vo.getStrFinancialStartYear(),11);          
	    			dao.setProcInValue(nInsertedIndex,"finEndDate",			vo.getStrFinancialEndYear(),12);         
	    			dao.setProcInValue(nInsertedIndex,"remarks",			vo.getStrRemarks(),13);   
	    			    		
	    			dao.setProcInValue(nInsertedIndex,"seatId",				vo.getStrSeatId(),14);                 
	    			dao.setProcInValue(nInsertedIndex,"grantTypeId",		"0",15);       
	    			dao.setProcInValue(nInsertedIndex,"puk ",				"0",16);                     
	    			dao.setProcInValue(nInsertedIndex,"empNo",				"0",17);                  
	    			dao.setProcInValue(nInsertedIndex,"admNo",				"0",18);  
	    			
	    			dao.setProcInValue(nInsertedIndex,"episodeCode",		"0",19);     
	    			dao.setProcInValue(nInsertedIndex,"consultantId",		"0",20);    
	    			dao.setProcInValue(nInsertedIndex,"memoNo",				"0",21);           
	    			dao.setProcInValue(nInsertedIndex,"totCost", 			"0",22);  
	    			
	    			dao.setProcInValue(nInsertedIndex,"indentPeriodValue", 	"0",23); 	    			
	    			dao.setProcInValue(nInsertedIndex,"cancelSeatId", 		"",24);
	    			dao.setProcInValue(nInsertedIndex,"cancelDate", 		"",25);
	    			dao.setProcInValue(nInsertedIndex,"cancelReason", 		"",26);
	    			
	    			dao.setProcInValue(nInsertedIndex,"certificateNo", 		"0",27);
	    			dao.setProcInValue(nInsertedIndex,"certificateDate", 	"",28);
	    			dao.setProcInValue(nInsertedIndex,"rateContSuppId", 	"0",29);
	    			dao.setProcInValue(nInsertedIndex, "bsReqNo", 			"0",30);
	    			dao.setProcInValue(nInsertedIndex, "appstatus", 		approvalDtls.split("\\^")[1],31);   // Approval Status 10,40
	    			dao.setProcInValue(nInsertedIndex, "appmode", 			approvalDtls.split("\\^")[0],32);	// Approval Mode 0 , 1 etc    			    			
	    			dao.setProcOutValue(nInsertedIndex,"err",				 1, 33);   
	    			    			
	    			
	    			dao.execute(nInsertedIndex,1);
	    				    							
					
					
					int length = vo.getItemParamValue().length;
					
		 			for(int i = 0;i<length;i++)
					{
				    				
						     temp  = vo.getItemParamValue()[i].replace('#', '#').split("#");
					
						     strTemp         = temp[2].replace('^', '#').split("#");
						
						     strReqQty      = vo.getStrReqQty()[i];
							 strReqUnit     = vo.getStrUnitName()[i];
				    	     reqQtyUnit = strReqUnit.split("\\^");

					    	 
						     if(approvalFlg.equals("0"))
						     {
						    	  strSancQty     = strReqQty;
						 		  strSancQtyUnit = reqQtyUnit[0];
						     }	
						     else
						     {
						    	 strSancQty     = "0";
						    	 strSancQtyUnit = "0";
						     }	  		    	 				
					
						     nInsertedIndex2 = dao.setProcedure("{call PKG_MMS_DML.Dml_Hstt_Indent_Item_Dtl (?,?,?,?,? ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,? ,?,?,?,?,?  ,?,?)}"); //27
								
								dao.setProcInValue(nInsertedIndex2,"modval",				"1",1);                           				
							   	dao.setProcInValue(nInsertedIndex2,"strIndentNo",		indentNo,2);                	
						       	dao.setProcInValue(nInsertedIndex2,"strId",				vo.getStrStoreId(),3);           				
								dao.setProcInValue(nInsertedIndex2,"hosp_code ",		vo.getStrHospitalCode(),4);          			
								dao.setProcInValue(nInsertedIndex2,"groupId",			strTemp[2],5);        					
								dao.setProcInValue(nInsertedIndex2,"subGroupId",		strTemp[3],6);           		
								dao.setProcInValue(nInsertedIndex2,"itemId",			strTemp[0],7);         					
								dao.setProcInValue(nInsertedIndex2,"itemBrandId",		strTemp[1],8); 			
								dao.setProcInValue(nInsertedIndex2,"rate",				strTemp[9],9); 								
								dao.setProcInValue(nInsertedIndex2,"rateUnitId",		"6301".trim(),10); 					
								dao.setProcInValue(nInsertedIndex2,"indentQty",			strReqQty,11);  
								dao.setProcInValue(nInsertedIndex2,"indentQtyUnitId",	"6301".trim(),12);      	
								dao.setProcInValue(nInsertedIndex2,"sancQty",			strSancQty.trim(),13);       				
								dao.setProcInValue(nInsertedIndex2,"sancQtyUnitId ",	"6301".trim(),14);			
								dao.setProcInValue(nInsertedIndex2,"issueQty",			"0",15);     					
								dao.setProcInValue(nInsertedIndex2,"issueQtyUnitId",	"6301".trim(),16);			
								dao.setProcInValue(nInsertedIndex2,"inHandQty",			strTemp[7],17);        				
								dao.setProcInValue(nInsertedIndex2,"inHandQtyUnitId",	"6301".trim(),18);			
								dao.setProcInValue(nInsertedIndex2,"consumableFlag",	"1",19);     		
								dao.setProcInValue(nInsertedIndex2,"reOrderLevel", 		strTemp[5],20);			
								dao.setProcInValue(nInsertedIndex2,"reOrderLevelUnitId","6301",21);   
								dao.setProcInValue(nInsertedIndex2,"lstIndentQty",		strTemp[21],22);				
								dao.setProcInValue(nInsertedIndex2,"lstIndentUnitId",	"6301",23);		
								dao.setProcInValue(nInsertedIndex2,"lstIssueQty",		"0",24);					
								dao.setProcInValue(nInsertedIndex2,"lstIssueUnitId",	"0",25);			
								dao.setProcInValue(nInsertedIndex2,"remarks",			vo.getStrRemarks().trim(),26);  
								//output value                        
								dao.setProcOutValue(nInsertedIndex2,"err",               1,27);        
								//keep in batch
								dao.execute(nInsertedIndex2,1);
					
					}
				 			
				 	dao.fire();
	    		        
							
				}
			  catch (Exception e) 
    	      {
	    		e.printStackTrace();
				vo.setStrMsgString("--> IndentTransADDDAO.INSERT_NEW()-->"	+ e.getMessage());
				vo.setStrMsgType("1");
		      } 
	    	  finally 
	    	  {
				if (dao != null)
					dao.free();
				dao = null;
			  }

	}
	public static void INSERT_NEW_FINDER_DATA(IndentTransADDVO vo) 
	{
		HisDAO dao = null;
		int nInsertedIndex=0,nInsertedIndex2=0;
		String indentNo = "";
		String approvalFlg ="";
		String approvalDtls ="";
		
		String[] temp = null;
		String[] strTemp = null;
		String[] reqQtyUnit=null;
		String strReqQty  = "";
		String strReqUnit ="";
		String strSancQty ="";
		String strSancQtyUnit="";		
		System.out.println("-------IndentTransADDDAO.INSERT_NEW_FINDER_DATA()----------");		
		
		try
		{
			
				String strReturnReqNo="0";	    	  
				int funcIndex = 0;			
				
				System.out.println("-------mms_mst.generate_indentno----------");	
				
				System.out.println("getStrHospitalCode--->>>"+vo.getStrHospitalCode());
				System.out.println("getStrReqType--->>>"+vo.getStrReqType());
				System.out.println("getStrStoreId--->>>"+vo.getStrStoreId());
				System.out.println("getStrItemCatg--->>>"+vo.getStrItemCatNo());
				
				dao = new HisDAO("MMS","transactions.ReturnRequestTransDAO.INSERT_NEW()");	  
				
				funcIndex = dao.setFunction("{? = call  mms_mst.generate_indentno (?, ?, ?, ?)}");					
				dao.setFuncInValue(funcIndex, 2, vo.getStrHospitalCode());
				dao.setFuncInValue(funcIndex, 3, vo.getStrReqType());
				dao.setFuncInValue(funcIndex, 4, vo.getStrStoreId());
				dao.setFuncInValue(funcIndex, 5, vo.getStrItemCatNo());	
				dao.setFuncOutValue(funcIndex, 1);	
				// Execute Function
				dao.executeFunction(funcIndex);
				strReturnReqNo = dao.getFuncString(funcIndex);
				indentNo = strReturnReqNo;								
				System.out.println("indentNo--->>>"+indentNo);		
				vo.setStrIndentNo(indentNo);
				
                int appfuncIndex = 0;		
                
                System.out.println("getStrToStore--->>>"+vo.getStrToStore());
				System.out.println("getStrSeatId--->>>"+vo.getStrSeatId());
				
				
				System.out.println("-------mms_mst.generate_indentno----------");	
				
				appfuncIndex = dao.setFunction("{? = call  mms_mst.get_approval_status (?, ?, ?, ? ,?  ,?,?,?,?,?)}");				
				dao.setFuncInValue(appfuncIndex, 2, "2");
				dao.setFuncInValue(appfuncIndex, 3, vo.getStrHospitalCode());
				dao.setFuncInValue(appfuncIndex, 4, "1");
				dao.setFuncInValue(appfuncIndex, 5, vo.getStrReqType());
				dao.setFuncInValue(appfuncIndex, 6, vo.getStrItemCatNo());
				dao.setFuncInValue(appfuncIndex, 7, vo.getStrStoreId());
				dao.setFuncInValue(appfuncIndex, 8, vo.getStrSeatId());
				dao.setFuncInValue(appfuncIndex, 9, "0");
				dao.setFuncInValue(appfuncIndex, 10,vo.getStrToStore());
				dao.setFuncInValue(appfuncIndex, 11,"1");
				dao.setFuncOutValue(appfuncIndex, 1);	
				// Execute Function
				dao.executeFunction(appfuncIndex);
				approvalDtls = dao.getFuncString(appfuncIndex);
				
				System.out.println("approvalDtls-0^40-->>>"+approvalDtls);
				
				approvalFlg = approvalDtls.split("\\^")[0];
			
	    			
	    			nInsertedIndex = dao.setProcedure("{call PKG_MMS_DML.dml_indent_new_dtl (?,?,?,?,? , ?,?,?,?,?  ,?,?,?,?,? ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?,  ?,?,?)}");
	    			
	    			
	    			
	    			dao.setProcInValue(nInsertedIndex,"modval",				"1",1); 
	    			dao.setProcInValue(nInsertedIndex,"indentno",			indentNo,2);
	    		   	dao.setProcInValue(nInsertedIndex,"strId",				vo.getStrStoreId(),3);                  
	    	       	dao.setProcInValue(nInsertedIndex,"hosp_code",			vo.getStrHospitalCode(),4);          
	    			dao.setProcInValue(nInsertedIndex,"reqTypeId ",			vo.getStrReqType(),5);         
	    			dao.setProcInValue(nInsertedIndex,"toStrId",			vo.getStrToStoreCombo(),6);              
	    			dao.setProcInValue(nInsertedIndex,"itemcatNo",			vo.getStrItemCatNo(),7);           
	    			dao.setProcInValue(nInsertedIndex,"itemTypeId", 		"0",8);        
	    			dao.setProcInValue(nInsertedIndex,"urgentFlag", 		vo.getStrUrgentFlg(),9);
	    			//8
	    			dao.setProcInValue(nInsertedIndex,"indentPeriod",		"0",10);    
	    			dao.setProcInValue(nInsertedIndex,"finStartDate",		vo.getStrFinancialStartYear(),11);          
	    			dao.setProcInValue(nInsertedIndex,"finEndDate",			vo.getStrFinancialEndYear(),12);         
	    			dao.setProcInValue(nInsertedIndex,"remarks",			vo.getStrRemarks(),13);   
	    			    		
	    			dao.setProcInValue(nInsertedIndex,"seatId",				vo.getStrSeatId(),14);                 
	    			dao.setProcInValue(nInsertedIndex,"grantTypeId",		"0",15);       
	    			dao.setProcInValue(nInsertedIndex,"puk ",				"0",16);                     
	    			dao.setProcInValue(nInsertedIndex,"empNo",				"0",17);                  
	    			dao.setProcInValue(nInsertedIndex,"admNo",				"0",18);  
	    			
	    			dao.setProcInValue(nInsertedIndex,"episodeCode",		"0",19);     
	    			dao.setProcInValue(nInsertedIndex,"consultantId",		"0",20);    
	    			dao.setProcInValue(nInsertedIndex,"memoNo",				"0",21);           
	    			dao.setProcInValue(nInsertedIndex,"totCost", 			"0",22);  
	    			
	    			dao.setProcInValue(nInsertedIndex,"indentPeriodValue", 	"0",23); 	    			
	    			dao.setProcInValue(nInsertedIndex,"cancelSeatId", 		"",24);
	    			dao.setProcInValue(nInsertedIndex,"cancelDate", 		"",25);
	    			dao.setProcInValue(nInsertedIndex,"cancelReason", 		"",26);
	    			
	    			dao.setProcInValue(nInsertedIndex,"certificateNo", 		"0",27);
	    			dao.setProcInValue(nInsertedIndex,"certificateDate", 	"",28);
	    			dao.setProcInValue(nInsertedIndex,"rateContSuppId", 	"0",29);
	    			dao.setProcInValue(nInsertedIndex, "bsReqNo", 			"0",30);
	    			dao.setProcInValue(nInsertedIndex, "appstatus", 		approvalDtls.split("\\^")[1],31);   // Approval Status 10,40
	    			dao.setProcInValue(nInsertedIndex, "appmode", 			approvalDtls.split("\\^")[0],32);	// Approval Mode 0 , 1 etc    			    			
	    			dao.setProcOutValue(nInsertedIndex,"err",				 1, 33);   
	    			    			
	    			
	    			dao.execute(nInsertedIndex,1);
	    				    													
					int length = 0;
					
					length = vo.getItemParamValue().length;
					
					/*
					    1.Generic Item Id
						2.Item Id
						3.Group Id
						4.Sub-Grp Id
						5.Consumable Flg
						6.Re-Order Qty
						7.Re-Order Qty Unit id
						8.In-Hand Qty
						9.In-Hand Qty Unit Id
						10.Last Rate
						11.Last Rate Unit
						12.Invntory Unit Id
						13.Last PO No
						14.Last PO Date
						15.Supplier Id
						16.Batch No
						17.Expiry Date
						18.Mfg Date
						19.Serial No
						20.Last Rec Qty
						21.Last Rec Qty Unit
						22.Last Indent Qty
						23.Last Indent Qty Unit
						24.Last Rec Qty
						25.Last Rec Qty Unit
						26.Last Year Consumption
						27.Last Year Consumption Unit
						28.Prefix if Any
						29.Cost
						30.Cost Unit
						31.Purchase Lead Time
						32.Purchase Lead Time Unit
						33.Stock Status
						34.Last Rate
						35.Last Rate Unit
						36.Brand Reserve Flag
						37.Item Make
						38.Item Code
						39.Up-Load File Id
						40.Upload File Name
					 */
					
					System.out.println("length--->>>"+length);
					
		 			for(int i = 0;i<length;i++)
					{  
		 				
		 				   System.out.println("vo.getStrReqQty()["+i+"]--->>>"+vo.getStrReqQty()[i]);
		 				   System.out.println("User Value--->>>"+vo.getItemUserValue()[i]);
				    				
						   //  temp  = vo.getItemParamValue()[i].replace('#', '#').split("#");
					
						     strTemp         = vo.getItemUserValue()[i].replace('^', '#').split("#");						
						     strReqQty       = vo.getStrReqQty()[i];
											    	 
						     if(approvalFlg.equals("0"))
						     {
						    	  strSancQty     = strReqQty;
						 		  strSancQtyUnit = "6301";
						     }	
						     else
						     {
						    	 strSancQty     = "0";
						    	 strSancQtyUnit = "0";
						     }	  		    	 				
					
						        nInsertedIndex2 = dao.setProcedure("{call PKG_MMS_DML.Dml_Hstt_Indent_Item_Dtl (?,?,?,?,? ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,? ,?,?,?,?,?  ,?,?)}"); //27
								
								dao.setProcInValue(nInsertedIndex2,"modval",			"1",1);                           				
							   	dao.setProcInValue(nInsertedIndex2,"strIndentNo",		indentNo,2);                	
						       	dao.setProcInValue(nInsertedIndex2,"strId",				vo.getStrStoreId(),3);           				
								dao.setProcInValue(nInsertedIndex2,"hosp_code ",		vo.getStrHospitalCode(),4);          			
								dao.setProcInValue(nInsertedIndex2,"groupId",			strTemp[2],5);        					
								dao.setProcInValue(nInsertedIndex2,"subGroupId",		strTemp[3],6);           		
								dao.setProcInValue(nInsertedIndex2,"itemId",			strTemp[0],7);         					
								dao.setProcInValue(nInsertedIndex2,"itemBrandId",		strTemp[1],8); 			
								dao.setProcInValue(nInsertedIndex2,"rate",				strTemp[9],9); 								
								dao.setProcInValue(nInsertedIndex2,"rateUnitId",		"6301".trim(),10); 					
								dao.setProcInValue(nInsertedIndex2,"indentQty",			strReqQty,11);  
								dao.setProcInValue(nInsertedIndex2,"indentQtyUnitId",	"6301".trim(),12);      	
								dao.setProcInValue(nInsertedIndex2,"sancQty",			strSancQty.trim(),13);       				
								dao.setProcInValue(nInsertedIndex2,"sancQtyUnitId ",	"6301".trim(),14);			
								dao.setProcInValue(nInsertedIndex2,"issueQty",			"0",15);     					
								dao.setProcInValue(nInsertedIndex2,"issueQtyUnitId",	"6301".trim(),16);			
								dao.setProcInValue(nInsertedIndex2,"inHandQty",			strTemp[7],17);        				
								dao.setProcInValue(nInsertedIndex2,"inHandQtyUnitId",	"6301".trim(),18);			
								dao.setProcInValue(nInsertedIndex2,"consumableFlag",	"1",19);     		
								dao.setProcInValue(nInsertedIndex2,"reOrderLevel", 		strTemp[5],20);			
								dao.setProcInValue(nInsertedIndex2,"reOrderLevelUnitId","6301",21);   
								dao.setProcInValue(nInsertedIndex2,"lstIndentQty",		strTemp[21],22);				
								dao.setProcInValue(nInsertedIndex2,"lstIndentUnitId",	"6301",23);		
								dao.setProcInValue(nInsertedIndex2,"lstIssueQty",		"0",24);					
								dao.setProcInValue(nInsertedIndex2,"lstIssueUnitId",	"0",25);			
								dao.setProcInValue(nInsertedIndex2,"remarks",			vo.getStrRemarks().trim(),26);  
								//output value                        
								dao.setProcOutValue(nInsertedIndex2,"err",               1,27);        
								//keep in batch
								dao.execute(nInsertedIndex2,1);
					
					}				 			
				 	dao.fire();
	    		        
							
				}
			  catch (Exception e) 
    	      {
	    		e.printStackTrace();
				vo.setStrMsgString("--> IndentTransADDDAO.INSERT_NEW()-->"	+ e.getMessage());
				vo.setStrMsgType("1");
		      } 
	    	  finally 
	    	  {
				if (dao != null)
					dao.free();
				dao = null;
			  }

	}
	
	public static void INSERT_NA_NEW(IndentTransADDVO vo) 
	{
		HisDAO dao = null;
		int nInsertedIndex=0,nInsertedIndex2=0;
		String indentNo = "";
		String approvalFlg ="";
		String approvalDtls ="";
		
		String[] temp = null;
		String[] strTemp = null;
		String[] reqQtyUnit=null;
		String strReqQty  = "";
		String strReqUnit ="";
		String strSancQty ="";
		String strSancQtyUnit="";		
		System.out.println("-------IndentTransADDDAO.INSERT_NA_NEW()----------");		
		
		try
		{
			
				String strReturnReqNo="0";	    	  
				int funcIndex = 0;			
				
				System.out.println("-------mms_mst.generate_indentno----------");	
				
				System.out.println("getStrHospitalCode--->>>"+vo.getStrHospitalCode());
				System.out.println("getStrReqType--->>>"+vo.getStrReqType());
				System.out.println("getStrStoreId--->>>"+vo.getStrStoreId());
				System.out.println("getStrItemCatg--->>>"+vo.getStrItemCatNo());
				
				dao = new HisDAO("MMS","transactions.ReturnRequestTransDAO.INSERT_NEW()");	  
				
				funcIndex = dao.setFunction("{? = call  mms_mst.generate_indentno (?, ?, ?, ?)}");					
				dao.setFuncInValue(funcIndex, 2, vo.getStrHospitalCode());
				dao.setFuncInValue(funcIndex, 3, vo.getStrReqType());
				dao.setFuncInValue(funcIndex, 4, vo.getStrStoreId());
				dao.setFuncInValue(funcIndex, 5, vo.getStrItemCatNo());	
				dao.setFuncOutValue(funcIndex, 1);	
				// Execute Function
				dao.executeFunction(funcIndex);
				strReturnReqNo = dao.getFuncString(funcIndex);
				indentNo = strReturnReqNo;								
				System.out.println("indentNo--->>>"+indentNo);		
				vo.setStrIndentNo(indentNo);
				
                int appfuncIndex = 0;		
                
                System.out.println("getStrToStore--->>>"+vo.getStrToStore());
				System.out.println("getStrSeatId--->>>"+vo.getStrSeatId());
				
				
				System.out.println("-------mms_mst.generate_indentno----------");	
				
				appfuncIndex = dao.setFunction("{? = call  mms_mst.get_approval_status (?, ?, ?, ? ,?  ,?,?,?,?,?)}");				
				dao.setFuncInValue(appfuncIndex, 2, "2");
				dao.setFuncInValue(appfuncIndex, 3, vo.getStrHospitalCode());
				dao.setFuncInValue(appfuncIndex, 4, "1");
				dao.setFuncInValue(appfuncIndex, 5, vo.getStrReqType());
				dao.setFuncInValue(appfuncIndex, 6, vo.getStrItemCatNo());
				dao.setFuncInValue(appfuncIndex, 7, vo.getStrStoreId());
				dao.setFuncInValue(appfuncIndex, 8, vo.getStrSeatId());
				dao.setFuncInValue(appfuncIndex, 9, "0");
				dao.setFuncInValue(appfuncIndex, 10,vo.getStrToStore());
				dao.setFuncInValue(appfuncIndex, 11,"1");
				dao.setFuncOutValue(appfuncIndex, 1);	
				// Execute Function
				dao.executeFunction(appfuncIndex);
				approvalDtls = dao.getFuncString(appfuncIndex);
				
				System.out.println("approvalDtls-0^40-->>>"+approvalDtls);
				
				approvalFlg = approvalDtls.split("\\^")[0];
			
	    			
	    			nInsertedIndex = dao.setProcedure("{call PKG_MMS_DML.dml_indent_new_dtl (?,?,?,?,? , ?,?,?,?,?  ,?,?,?,?,? ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?,  ?,?,?)}");
	    			
	    			
	    			
	    			dao.setProcInValue(nInsertedIndex,"modval",				"2",1); 
	    			dao.setProcInValue(nInsertedIndex,"indentno",			indentNo,2);
	    		   	dao.setProcInValue(nInsertedIndex,"strId",				vo.getStrStoreId(),3);                  
	    	       	dao.setProcInValue(nInsertedIndex,"hosp_code",			vo.getStrHospitalCode(),4);          
	    			dao.setProcInValue(nInsertedIndex,"reqTypeId ",			vo.getStrReqType(),5);         
	    			dao.setProcInValue(nInsertedIndex,"toStrId",			vo.getStrToStoreCombo(),6);              
	    			dao.setProcInValue(nInsertedIndex,"itemcatNo",			vo.getStrItemCatNo(),7);           
	    			dao.setProcInValue(nInsertedIndex,"itemTypeId", 		"0",8);        
	    			dao.setProcInValue(nInsertedIndex,"urgentFlag", 		vo.getStrUrgentFlg(),9);
	    			//8
	    			dao.setProcInValue(nInsertedIndex,"indentPeriod",		"0",10);    
	    			dao.setProcInValue(nInsertedIndex,"finStartDate",		vo.getStrFinancialStartYear(),11);          
	    			dao.setProcInValue(nInsertedIndex,"finEndDate",			vo.getStrFinancialEndYear(),12);         
	    			dao.setProcInValue(nInsertedIndex,"remarks",			vo.getStrRemarks(),13);   
	    			    		
	    			dao.setProcInValue(nInsertedIndex,"seatId",				vo.getStrSeatId(),14);                 
	    			dao.setProcInValue(nInsertedIndex,"grantTypeId",		"0",15);       
	    			dao.setProcInValue(nInsertedIndex,"puk ",				"0",16);                     
	    			dao.setProcInValue(nInsertedIndex,"empNo",				"0",17);                  
	    			dao.setProcInValue(nInsertedIndex,"admNo",				"0",18);  
	    			
	    			dao.setProcInValue(nInsertedIndex,"episodeCode",		"0",19);     
	    			dao.setProcInValue(nInsertedIndex,"consultantId",		"0",20);    
	    			dao.setProcInValue(nInsertedIndex,"memoNo",				"0",21);           
	    			dao.setProcInValue(nInsertedIndex,"totCost", 			"0",22);  
	    			
	    			dao.setProcInValue(nInsertedIndex,"indentPeriodValue", 	"0",23); 	    			
	    			dao.setProcInValue(nInsertedIndex,"cancelSeatId", 		"",24);
	    			dao.setProcInValue(nInsertedIndex,"cancelDate", 		"",25);
	    			dao.setProcInValue(nInsertedIndex,"cancelReason", 		"",26);
	    			
	    			dao.setProcInValue(nInsertedIndex,"certificateNo", 		"0",27);
	    			dao.setProcInValue(nInsertedIndex,"certificateDate", 	"",28);
	    			dao.setProcInValue(nInsertedIndex,"rateContSuppId", 	"0",29);
	    			dao.setProcInValue(nInsertedIndex, "bsReqNo", 			"0",30);
	    			dao.setProcInValue(nInsertedIndex, "appstatus", 		approvalDtls.split("\\^")[1],31);   // Approval Status 10,40
	    			dao.setProcInValue(nInsertedIndex, "appmode", 			approvalDtls.split("\\^")[0],32);	// Approval Mode 0 , 1 etc    			    			
	    			dao.setProcOutValue(nInsertedIndex,"err",				 1, 33);   
	    			    			
	    			
	    			dao.execute(nInsertedIndex,1);
	    				    							
					
					
					int length = vo.getItemParamValue().length;
					
		 			for(int i = 0;i<length;i++)
					{
				    				
						     temp  = vo.getItemParamValue()[i].replace('#', '#').split("#");
					
						     strTemp         = temp[2].replace('^', '#').split("#");
						
						     strReqQty      = vo.getStrReqQty()[i];
							 strReqUnit     = vo.getStrUnitName()[i];
				    	     reqQtyUnit = strReqUnit.split("\\^");

					    	 
						     if(approvalFlg.equals("0"))
						     {
						    	  strSancQty     = strReqQty;
						 		  strSancQtyUnit = reqQtyUnit[0];
						     }	
						     else
						     {
						    	 strSancQty     = "0";
						    	 strSancQtyUnit = "0";
						     }	  		    	 				
					
						       nInsertedIndex2 = dao.setProcedure("{call PKG_MMS_DML.Dml_Hstt_Indent_Item_Dtl (?,?,?,?,? ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,? ,?,?,?,?,?  ,?,?)}"); //27
								
								dao.setProcInValue(nInsertedIndex2,"modval",				"1",1);                           				
							   	dao.setProcInValue(nInsertedIndex2,"strIndentNo",		indentNo,2);                	
						       	dao.setProcInValue(nInsertedIndex2,"strId",				vo.getStrStoreId(),3);           				
								dao.setProcInValue(nInsertedIndex2,"hosp_code ",		vo.getStrHospitalCode(),4);          			
								dao.setProcInValue(nInsertedIndex2,"groupId",			strTemp[2],5);        					
								dao.setProcInValue(nInsertedIndex2,"subGroupId",		strTemp[3],6);           		
								dao.setProcInValue(nInsertedIndex2,"itemId",			strTemp[0],7);         					
								dao.setProcInValue(nInsertedIndex2,"itemBrandId",		strTemp[1],8); 			
								dao.setProcInValue(nInsertedIndex2,"rate",				strTemp[9],9); 								
								dao.setProcInValue(nInsertedIndex2,"rateUnitId",		"6301".trim(),10); 					
								dao.setProcInValue(nInsertedIndex2,"indentQty",			strReqQty,11);  
								dao.setProcInValue(nInsertedIndex2,"indentQtyUnitId",	"6301".trim(),12);      	
								dao.setProcInValue(nInsertedIndex2,"sancQty",			strSancQty.trim(),13);       				
								dao.setProcInValue(nInsertedIndex2,"sancQtyUnitId ",	"6301".trim(),14);			
								dao.setProcInValue(nInsertedIndex2,"issueQty",			"0",15);     					
								dao.setProcInValue(nInsertedIndex2,"issueQtyUnitId",	"6301".trim(),16);			
								dao.setProcInValue(nInsertedIndex2,"inHandQty",			strTemp[7],17);        				
								dao.setProcInValue(nInsertedIndex2,"inHandQtyUnitId",	"6301".trim(),18);			
								dao.setProcInValue(nInsertedIndex2,"consumableFlag",	"1",19);     		
								dao.setProcInValue(nInsertedIndex2,"reOrderLevel", 		strTemp[5],20);			
								dao.setProcInValue(nInsertedIndex2,"reOrderLevelUnitId","6301",21);   
								dao.setProcInValue(nInsertedIndex2,"lstIndentQty",		strTemp[21],22);				
								dao.setProcInValue(nInsertedIndex2,"lstIndentUnitId",	"6301",23);		
								dao.setProcInValue(nInsertedIndex2,"lstIssueQty",		"0",24);					
								dao.setProcInValue(nInsertedIndex2,"lstIssueUnitId",	"0",25);			
								dao.setProcInValue(nInsertedIndex2,"remarks",			vo.getStrRemarks().trim(),26);  
								//output value                        
								dao.setProcOutValue(nInsertedIndex2,"err",               1,27);        
								//keep in batch
								dao.execute(nInsertedIndex2,1);
					
					}
				 			
				 	dao.fire();
	    		        
							
				}
			  catch (Exception e) 
    	      {
	    		e.printStackTrace();
				vo.setStrMsgString("--> IndentTransADDDAO.INSERT_NEW()-->"	+ e.getMessage());
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
	 * This method is used to insert data into Table'
	 * 
	 * @param vo
	 */

	public synchronized static void INSERT(IndentTransADDVO vo) {
		HisDAO dao = null;
		int procIndex1 = 0;
		String indentNo = "";
		String approvalFlg = "";
		DmlIndentDtlDAO globalDao = null;
		try {
			// Createing Object for Table Specific DAO
			globalDao = new DmlIndentDtlDAO();
			dao = new HisDAO("MMS", "transactions.IndentTransADDDAO.INSERT()");
			// int length = vo.getItemParamValue().length;
			/*
			 * vo.setStrReqType(strReqType); vo.setStrStoreId(strStoreId);
			 * vo.setStrStoreTypeId(strStoreTypeId);
			 * vo.setStrItemCatNo(strItemCategoryNo);
			 * vo.setStrFinancialEndYear(strFinancialEndYear);
			 * vo.setStrFinancialStartYear(strFinancialStartYear);
			 * vo.setStrHospitalCode(hosCode); vo.setStrSeatId(seatid);
			 * vo.setIsNormal(formBean.getIsNormal());
			 * vo.setIsUrgent(formBean.getIsUrgent());
			 * vo.setStrIndentPeriod(formBean.getStrIndentPeriod());
			 * vo.setItemParamValue(formBean.getItemParamValue());
			 * vo.setStrBkgEntryDate(util.getASDate("dd-MMM-yyyy"));
			 * vo.setStrReqQty(formBean.getStrReqQty());
			 * vo.setStrUnitName(formBean.getStrUnitName());
			 * vo.setStrRemarks(formBean.getStrRemarks());
			 * vo.setStrStoreName(formBean.getStrStoreName());
			 * //System.out.println
			 * ("strIndentPeriod--->>>"+formBean.getStrIndentPeriod());
			 * //System.out.println("isNormal--->>>"+formBean.getIsNormal());
			 * //System.out.println("isUrgent--->>>"+formBean.getIsUrgent());
			 * System
			 * .out.println("To Store--->>>"+formBean.getStrToStoreCombo());
			 */

			globalDao.setStrId(vo.getStrStoreId());
			globalDao.setHosp_code(vo.getStrHospitalCode());
			globalDao.setReqTypeId(vo.getStrReqType());
			globalDao.setToStrId(vo.getStrToStoreCombo());
			globalDao.setItemcatNo(vo.getStrItemCatNo());
			globalDao.setItemTypeId("0"); // Check
			globalDao.setUrgentFlag(vo.getStrUrgentFlg());
			globalDao.setIndentPeriod(vo.getStrIndentPeriod());
			globalDao.setIndentPeriodValue(vo.getStrIndentPeriodValue());
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
			globalDao.setTotCost("0");
			if(vo.getStrBSReqNo() != null && !vo.getStrBSReqNo().equals(""))
				globalDao.setStrBSReqNo(vo.getStrBSReqNo());
			
			procIndex1 = globalDao.insert(dao);

			boolean bFlag = false;
			
			dao.fire(); // Here we Execute in Batch
			
			bFlag=true;
			
			indentNo = dao.getString(procIndex1, "indentNo");
			approvalFlg = dao.getString(procIndex1, "approvalFlg");
			vo.setStrIndentNo(indentNo);
			// //System.out.println("Indent No-->>"+indentNo);
			// //System.out.println("Approval Flg-->>"+approvalFlg);
			INSERTINTABLE(vo, indentNo, approvalFlg);
			
			if(bFlag){
				vo.setStrMode("1");
				//updateBudgetDetailsForIndentDesk(vo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> IndentTransADDDAO.INSERT()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	public static void INSERTINTABLE(IndentTransADDVO vo, String indentNo,
			String approvalFlg) {
		HisDAO dao = null;
		String[] temp = null;
		String[] strTemp = null;
		DmlHsttIndentItemDtlDAO tableDao = null;
		String[] reqQtyUnit = null;

		// String[] sancQtyUnit=null;

		String strReqQty = "";
		String strReqUnit = "";
		String strSancQty = "";
		String strSancQtyUnit = "";

		try {
			// Createing Object for Table Specific DAO
			tableDao = new DmlHsttIndentItemDtlDAO();
			// HisUtil util = new HisUtil("","");
			// String strCtDate = util.getASDate("dd-MMM-yyyy");

			dao = new HisDAO("MMS", "transactions.IndentTransADDDAO.INSERT()");
			int length = vo.getItemParamValue().length;

			for (int i = 0; i < length; i++) {

				temp = vo.getItemParamValue()[i].replace('#', '#').split("#");
				/*
				 * //System.out.println("Display Value-->>>>"+temp[0]);
				 * //System.out.println("Conversion  Value-->>>>"+temp[1]);
				 * //System.out.println("User  Value-->>>>"+temp[2]);
				 */
				strTemp = temp[2].replace('^', '#').split("#");
				/*
				 * //System.out.println("ItemID-1->>"+strTemp[0]);
				 * //System.out.println("ItemBrandID-2->>"+strTemp[1]);
				 * //System.out.println("GrpID-3->>"+strTemp[2]);
				 * //System.out.println("Sub_GrpID-4->>"+strTemp[3]);
				 * //System.out.println("Cosumble Flg-5->>"+strTemp[4]);
				 * //System.out.println("Re-Order Qty-6->>"+strTemp[5]);
				 * //System.out.println("Re-Order Qty unit Id-7->>"+strTemp[6]);
				 * //System.out.println("In Hand Qty-8->>"+strTemp[7]);
				 * //System.out.println("In Hand Qty Unit Id-9->>"+strTemp[8]);
				 * //System.out.println("Last Rate-10->>"+strTemp[9]);
				 * //System.out.println("Last Rate Unit Id-11->>"+strTemp[10]);
				 * 
				 * 
				 * //System.out.println("Inventory Unit Id-12->>"+strTemp[11]);
				 * //System.out.println("Last PO No-13->>"+strTemp[12]);
				 * //System.out.println("Last PO Date-14->>"+strTemp[13]);
				 * System.out
				 * .println("Last Supplied By [Id]-15->>"+strTemp[14]);
				 * //System.out.println("Batch No-16->>"+strTemp[15]);
				 * //System.out.println("Expiry Date-17->>"+strTemp[16]);
				 * //System.out.println("Manufacture Date-18->>"+strTemp[17]);
				 * //System.out.println("Item Serial No-19->>"+strTemp[18]);
				 * System
				 * .out.println("Last Received Qty [PO]-20->>"+strTemp[19]);
				 * System
				 * .out.println("Last Received Qty Unit Id [PO]-21->>"+strTemp
				 * [20]);
				 * 
				 * //System.out.println("Last Indented Qty-22->>"+strTemp[21]);
				 * System
				 * .out.println("Last Indented Qty Unit Id-23->>"+strTemp[22]);
				 * //System.out.println("Last Received Qty-24->>"+strTemp[23]);
				 * System
				 * .out.println("Last Received Qty Unit Id-25->>"+strTemp[24]);
				 * System
				 * .out.println("Last Year Consumption Qty-26->>"+strTemp[25]);
				 * System
				 * .out.println("Last Year Consumption Qty Unit Id-27->>"+strTemp
				 * [26]); //System.out.println("Prefix-28->>"+strTemp[27]);
				 * //System.out.println("Cost Parameter-29->>"+strTemp[28]);
				 * //System.out.println(
				 * "Cost Unit [on individual item or on total cost]-30->>"
				 * +strTemp[29]);
				 * //System.out.println("Purchase Lead Time-31->>"+strTemp[30]);
				 * 
				 * //System.out.println("Purchase Lead Time Unit-32->>"+strTemp[31]
				 * ); //System.out.println("Stock Status-33->>"+strTemp[32]);
				 * 
				 * //System.out.println("indent No-in LP DEPT .->>>"+indentNo);
				 * System
				 * .out.println("Store ID LP DEEPT.....--->>>"+vo.getStrStoreId
				 * ());
				 */
				strReqQty = vo.getStrReqQty()[i].split(" ")[0];

				strReqUnit = vo.getStrUnitName()[i];
				reqQtyUnit = strReqUnit.split("\\^");

				if (approvalFlg.equals("0")) {
					strSancQty = strReqQty;
					strSancQtyUnit = reqQtyUnit[0];
				} else {
					strSancQty = "0";
					strSancQtyUnit = "0";
				}

				tableDao.setStrIndentNo(indentNo);
				tableDao.setStrStoreId(vo.getStrStoreId());
				tableDao.setStrHospCode(vo.getStrHospitalCode());
				tableDao.setStrGroupId(strTemp[2]);
				tableDao.setStrSubGroupId(strTemp[3]);
				tableDao.setStrItemId(strTemp[0]);
				tableDao.setStrItemBrandId(strTemp[1]);
				tableDao.setStrRate(strTemp[9]);
				tableDao.setStrRateUnitId(strTemp[10]);
				tableDao.setStrIndentQty(strReqQty);
				tableDao.setStrIndentQtyUnitId(reqQtyUnit[0]);
				tableDao.setStrSancQty(strSancQty);
				tableDao.setStrSancQtyUnitId(strSancQtyUnit);
				tableDao.setStrIssueQty("0");
				tableDao.setStrIssueqtyUnitId("0");
				tableDao.setStrinHandQty(strTemp[7]);
				tableDao.setStrInHandQtyUnitId(strTemp[8]);
				tableDao.setStrConsumableFlag("1");
				tableDao.setStrReOrderLevel(strTemp[5]);
				tableDao.setStrReOrderLevelUnitId(strTemp[6]);
				tableDao.setStrLastIndentQty(strTemp[21]);
				tableDao.setStrLastIndentQtyUnitId(strTemp[22]);
				tableDao.setStrLastIssueQty("0");
				tableDao.setStrLastIssueQtyUnitId("0");
				tableDao.setStrRemarks(vo.getStrRemarks());

				tableDao.insert(dao);   // Dml_Hstt_Indent_Item_Dtl  Mode 1

			}
			synchronized (dao) {
				dao.fire(); // Here we Execute in Batch
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> IndentTransADDDAO.INSERTINTABLE()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	
	/**
	 * To insert the data
	 * 
	 * @param indentTransADDVO_p	the IndentTransADDVO
	 */
	public static void updateBudgetDetailsForIndentDesk(IndentTransADDVO indentTransADDVO_p)
	{

		HisDAO dao = null;

		int nProcIndex_U;

		String strProcName_U = "";

		try {
			dao = new HisDAO("mms", "IndentTransADDDAO");

			strProcName_U = "{call PKG_mms_DML.dml_update_indent_budget_dtls(?,?,?, ?,?,?)}"; // Total 6 Values
			
			nProcIndex_U = dao.setProcedure(strProcName_U);
						
			//HisUtil.replaceNullValueWithEmptyString(indentTransADDVO_p);
			
			dao.setProcInValue(nProcIndex_U, "p_mode", indentTransADDVO_p.getStrMode(),1);
			dao.setProcInValue(nProcIndex_U, "p_raising_store_id", indentTransADDVO_p.getStrStoreId(),2); 
			dao.setProcInValue(nProcIndex_U, "p_indentNo", indentTransADDVO_p.getStrIndentNo(),3);
			dao.setProcInValue(nProcIndex_U, "p_gnum_hospital_code",	indentTransADDVO_p.getStrHospitalCode(),4);
			dao.setProcInValue(nProcIndex_U, "p_hstnum_budget_available",	indentTransADDVO_p.getStrAvalaibleBudget(),5);
			
			/* Default Value */

			dao.setProcOutValue(nProcIndex_U, "err", 1,6);

			dao.executeProcedureByPosition(nProcIndex_U);

			indentTransADDVO_p.setStrMsgType("0");

		} 
		catch (Exception e) 
		{
			indentTransADDVO_p.setStrMsgString("--> IndentTransADDDAO.updateIndentBudgetDts()-->" + e.getMessage());
			indentTransADDVO_p.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void PLACEREGULARINDENT(IndentTransADDVO vo)
	{
		
		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";
		
    	try 
		{
    		String strProcName = "{call PKG_MMS_VIEW.PROC_GET_INDENTITEM_DTL(?,?,?,?,?,?,?)}";

			daoObj = new HisDAO("MMS Transactions","IndentViewTransDAO");
			//System.out.println("reqTypeId ====>>"+vo.getStrReqType());
			nProcIndex = daoObj.setProcedure(strProcName);
     		daoObj.setProcInValue(nProcIndex, "modval", "2",1);
	     	daoObj.setProcInValue(nProcIndex, "storeId",vo.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "reqNo",vo.getStrIndentNo(),4);
			daoObj.setProcInValue(nProcIndex, "reqTypeId",vo.getStrReqType(),5);
						
			daoObj.setProcOutValue(nProcIndex,"err", 1,6);
			daoObj.setProcOutValue(nProcIndex,"resultset", 2,7);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				wb = daoObj.getWebRowSet(nProcIndex, "resultset");
				
				vo.setStrItemDetailsWs(wb);
				
			} else {
				throw new Exception(strErr);
			}
    		
		
		
		} 
    	catch (Exception e) 
    	{
			vo.setStrMsgString("--> IndentViewTransDAO.getItemDetails()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null)
				daoObj.free();
				daoObj = null;
			}

	}
	
	/**
	 * To insert the data
	 * 
	 * @param indentTransADDVO_p	the IndentTransADDVO
	 */
	public static void rejectIndentBczNA(IndentTransADDVO indentTransADDVO_p)
	{

		HisDAO dao = null;

		int nProcIndex_U;

		String strProcName_U = "";

		try {
			dao = new HisDAO("mms", "IndentTransADDDAO");

			strProcName_U = "{call PKG_mms_DML.dml_update_indent_for_na_certificate(?,?,?, ?,?)}"; // Total 5 Values
			
			nProcIndex_U = dao.setProcedure(strProcName_U);
						
			//HisUtil.replaceNullValueWithEmptyString(indentTransADDVO_p);
			
			dao.setProcInValue(nProcIndex_U, "p_mode", 						"1",1);
			dao.setProcInValue(nProcIndex_U, "p_raising_store_id", 			indentTransADDVO_p.getStrStoreId(),2); 
			dao.setProcInValue(nProcIndex_U, "p_indentNo", 					indentTransADDVO_p.getStrIndentNo(),3);
			dao.setProcInValue(nProcIndex_U, "p_gnum_hospital_code",		indentTransADDVO_p.getStrHospitalCode(),4);			
			
					
			/* Default Value */

			dao.setProcOutValue(nProcIndex_U, "err", 1,5);

			dao.executeProcedureByPosition(nProcIndex_U);

			indentTransADDVO_p.setStrMsgType("0");

		} 
		catch (Exception e) 
		{
			indentTransADDVO_p.setStrMsgString("--> IndentTransADDDAO.rejectIndentBczNA()-->" + e.getMessage());
			indentTransADDVO_p.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

}
