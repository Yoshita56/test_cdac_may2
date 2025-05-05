package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.IssueDtlBackLogVO;

public class IssueDtlBackLogDAO 
{
	/**
	 * for getting option value of combo on add page (store type name )
	 * 
	 * @param vo
	 */

	public static void GetData(IssueDtlBackLogVO vo) 
	{
		/* Declaring Variable */
		HisDAO dao = null;
		WebRowSet wb = null;
		String str1 = null;
		HisUtil hisutil = null;
    	try 
		{
			
    		hisutil = new HisUtil("MMS", "OfflineIssueIndentDAO");
			wb      = STORENAMECOMBO(vo);
			if(wb.next())
			{
				vo.setStrStoreId(wb.getString(1));
			}
			wb.beforeFirst();
			if(wb!= null)
			{	
			   str1 = hisutil.getOptionValue(wb, vo.getStrStoreId(),"0^Select Value", true);
			   vo.setStrStoreName(str1);
			}
			 else
            {
               str1 = "<option value='0'>DATA N/A</option>";   
               vo.setStrStoreName(str1);
            }
			
		
		} 
    	catch (Exception e) 
    	{
			
    		vo.setStrMsgString("--> OfflineIssueIndentDAO.GetData()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}
	
	
	/**
	 * To get Indent Details i.e.(Store Name,Indent No.,Indent Date,Indent
	 * Type,Item Category,Raising Store) on 'issue' page
	 * 
	 * @param vo
	 */
	public static void getIndentDetail(IssueDtlBackLogVO vo) 
	{

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_indent_dtl(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms",
					"IssueDtlBackLogDAO.getIndentDetail(IssueDtlBackLogVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", "1");

			dao.setProcInValue(procIndex1, "indent_no", vo.getStrIndentNo());
			dao.setProcInValue(procIndex1, "store_id", vo.getStrStoreId());
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "itemcat_no", ""); // Default Value.


			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "RESULTSET");
				

				if (ws != null && ws.next()) 
				{

					vo.setStrIndentNo(ws.getString(1));
					vo.setStrIndentDate(ws.getString(2));
					vo.setStrIndentType(ws.getString(3));
					vo.setStrItemCategory(ws.getString(4));
					vo.setStrRaisingStoreId(ws.getString(5));
					vo.setStrRaisingStoreName(ws.getString(6));
					vo.setStrItemCategoryNo(ws.getString(7));
					vo.setStrReqStatusName(ws.getString(8));
					vo.setStrIndentPeriodValue(ws.getString(9));
					
                    
				}
				ws.beforeFirst();
				vo.setPendingIndentDemandWS(ws);

			} else {

				throw new Exception(err);
			}

		} 
		catch (Exception e)
		{
            e.printStackTrace();
			vo.setStrMsgString("IssueDtlBackLogDAO.getIndentDetail() --> "
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
	 * To get Item Details on 'Issue' page
	 * 
	 * @param vo
	 */
	public static void getItemDetail(IssueDtlBackLogVO vo) 
	{

		String err = "";
		String proc_name1 = "{call Pkg_Mms_View.proc_indentissue_item_dtls(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms", "IssueDtlBackLogDAO");

			procIndex1 = dao.setProcedure(proc_name1);
            
			////System.out.println("frmstoreid:::"+vo.getStrRaisingStoreId());
			////System.out.println("Issue Store::::"+vo.getStrIssueStoreId());
				
			// set value
			dao.setProcInValue(procIndex1, "modeval", "1");
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "indentno", vo.getStrIndentNo());
			dao.setProcInValue(procIndex1, "frmstoreid", vo.getStrRaisingStoreId());
			dao.setProcInValue(procIndex1, "issuingStoreid", vo.getStrIssueStoreId());
			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");

				vo.setItemDetailsWS(ws);
				
			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			vo.setStrMsgString("IssueDtlBackLogDAO.getItemDetail() --> "
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
	 * STORENAMECOMBO(vo) -- >
     * This Method is Used to get WebRowSet for Store Name  Combo 
     * from Table 
     */
	public static WebRowSet STORENAMECOMBO(IssueDtlBackLogVO vo)
	{
		String proc_name = "";

		proc_name = "{call PKG_MMS_VIEW.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		
		HisDAO dao = null;
			
		int nprocIndex = 0;

		String strerr = "";

		WebRowSet ws = null;

		try {

			dao = new HisDAO("MMS",
					"transactions.OfflineIssueIndentDAO.STORENAMECOMBO(VO)");

			nprocIndex = dao.setProcedure(proc_name);

			// set value

			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "seatid", vo.getStrSeatId());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "storeid", "0");
			dao.setProcInValue(nprocIndex, "storetype_id", "0");
			dao.setProcOutValue(nprocIndex,"err", 1); // 1 for string return
			dao.setProcOutValue(nprocIndex,"resultset", 2); // 2 for object
			// execute procedure
			dao.executeProcedure(nprocIndex);

			// get value

			strerr = dao.getString(nprocIndex, "err");

			if (strerr == null)
				strerr = "";

			if (strerr.equals(""))
			{
				ws = dao.getWebRowSet(nprocIndex, "resultset");
				vo.setStrMsgType("0");
			} else {
				throw new Exception(strerr);
			}

		}

		catch (Exception e)
		{		
            e.printStackTrace();
			vo.setStrMsgString("-->OfflineIssueIndentDAO.STORENAMECOMBO()"+ e.getMessage());

			vo.setStrMsgType("1");

		}

		finally
		{

			if (dao != null) 
			{

				dao.free();

				dao = null;

			}

		}

		return ws;
	}
	
	
	/**
	 * To Get Data
	 * 
	 * @param budgetAllocationDetailProcessTransVO_p
	 */
	public static void getAvalBudgetDetails(IssueDtlBackLogVO vo) 
	{
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_hstt_budget_dtl(?,?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

				dao = new HisDAO("MMS Transactions","IssueDtlBackLogDAO");
						
				procIndex1 = dao.setProcedure(proc_name1);
				
				dao.setProcInValue(procIndex1, "p_mode", "4");
				// set value
				
				dao.setProcInValue(procIndex1, "p_hstnum_store_id", vo.getStrIndentingStoreID());
				dao.setProcInValue(procIndex1, "p_hstdt_finstart_date", vo.getStrFinancialStartDate());
				dao.setProcInValue(procIndex1, "p_hstdt_finend_date", vo.getStrFinancialEndDate());
				dao.setProcInValue(procIndex1, "p_gnum_hospital_code", vo.getStrHospitalCode());
				dao.setProcInValue(procIndex1, "p_hstnum_slno", "0");
							
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
						
				while(ws.next())
				{
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
	 * To Get Data
	 * 
	 * @param budgetAllocationDetailProcessTransVO_p
	 */
	public static void getPendingDemand(IssueDtlBackLogVO vo) 
	{
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_pending_demand_dtl(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

				dao = new HisDAO("MMS Transactions","IssueDtlBackLogDAO");
						
				procIndex1 = dao.setProcedure(proc_name1);
				
//				//System.out.println("Store ID::getPendingDemand::"+vo.getStrStoreId());
//                //System.out.println("Hosp Code::getPendingDemand:::"+vo.getStrHospitalCode());
//                //System.out.println("Item Catg::getPendingDemand:::"+vo.getStrItemCagID());
//                //System.out.println("Indenting::getPendingDemand:::"+vo.getStrIndentingStoreID());
                
			
				dao.setProcInValue(procIndex1, "p_mode", "1");
				// set value
				dao.setProcInValue(procIndex1, "p_hstnum_store_id",    vo.getStrIndentingStoreID());
    			dao.setProcInValue(procIndex1, "p_SSTNUM_ITEM_CAT_NO", vo.getStrItemCagID());
				dao.setProcInValue(procIndex1, "p_gnum_hospital_code", vo.getStrHospitalCode());
				dao.setProcInValue(procIndex1, "p_HSTNUM_TOSTORE_ID",  vo.getStrStoreId());
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
							
				vo.setPendingDemandWS(ws);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("IssueTransDAO.getPendingDemand() --> "	+ e.getMessage());
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
	public static void IndentPeriodCombo(IssueDtlBackLogVO vo) 
	{
		// Declaring Variables
		String        err = "";
		int    procIndex1 = 0;
		HisDAO        dao = null;
		WebRowSet      ws = null;
		HisUtil   hisutil = null;
		String        str = null;
		String proc_name1 = "{call PKG_MMS_VIEW.proc_itembrand_list(?,?,?,?,?,?,?,?,?)}";

		try 
		{
			
			// Creating Object
			   hisutil = new HisUtil("master", "IssueDtlBackLogDAO");
			       dao = new HisDAO("mms","IssueDtlBackLogDAO.GetDeptCombo(IssueDtlBackLogVO vo)");
        	procIndex1 = dao.setProcedure(proc_name1);

			   // set value

	            dao.setProcInValue(procIndex1,  "modeval", "1");
	            
	            dao.setProcInValue(procIndex1,  "catCode", "10");
	            dao.setProcInValue(procIndex1,  "item_id", "0");
	            dao.setProcInValue(procIndex1,  "grpId", "0");
	            dao.setProcInValue(procIndex1,  "subGrpId", "0");
	            dao.setProcInValue(procIndex1,  "setFlag", "0");
	            dao.setProcInValue(procIndex1,  "hosp_code", vo.getStrHospitalCode());			
				dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
				dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object
				// execute procedure
				dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			if (ws != null && ws.size() != 0) 
			{
				str = hisutil.getOptionValue(ws, "-1", "0^Select Value", true);
				vo.setStrIndentPeriodCombo(str);
			} 
			else 
			{
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrIndentPeriodCombo(str);
			}

		} catch (Exception e) {
			vo.setStrMsgString("IssueDtlBackLogDAO.ToStoreCombo() --> "
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
	public static void itemCategoryCombo(IssueDtlBackLogVO vo)
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
			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "reqType","31");
			daoObj.setProcOutValue(nProcIndex,"err",1); 
			daoObj.setProcOutValue(nProcIndex,"resultset",2);
			// execute procedure
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			// get values
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
					
			if (strErr.equals("")) 
			{
				if(ws!=null)
				{
					str = hisutil.getOptionValue(ws, "-1","0^Select Value", true);
					
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
	
	
	/**
	 * Method for getting option value of Indenting Store combo on add page (store type name )
	 * 
	 * @param vo
	 */
	public static void IndentingStoreCombo(IssueDtlBackLogVO vo) 
	{
       // Declaring Variables
		String        err = "";
		int    procIndex1 = 0;
		HisDAO        dao = null;
		WebRowSet      ws = null;
		HisUtil   hisutil = null;
		String        str = null;
		String proc_name1 = "{call Pkg_Mms_View.proc_hstt_toStore_mst(?,?,?,?,?,?,?)}";
		try 
		{
			// Creating Object
			  hisutil = new HisUtil("master", "IssueDtlBackLogDAO");
			      dao = new HisDAO("MMS","IssueDtlBackLogDAO.IndentingStoreCombo(IssueDtlBackLogVO vo)");
  		   procIndex1 = dao.setProcedure(proc_name1);
			// set value
	            dao.setProcInValue(procIndex1, "modeval", "2");
				dao.setProcInValue(procIndex1, "hosp_code", vo	.getStrHospitalCode());
  				dao.setProcInValue(procIndex1, "storeid", vo.getStrStoreId());
  				dao.setProcInValue(procIndex1, "reqType", "17");
				dao.setProcInValue(procIndex1, "catCode", "10");
				dao.setProcOutValue(procIndex1,"ERR", 1); // 1 for string return
				dao.setProcOutValue(procIndex1,"RESULTSET", 2); // 2 for object
				// execute procedure
				dao.executeProcedure(procIndex1);
			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "-1", "0^Select Value", true);
				vo.setStrIndentStoreCombo(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrIndentStoreCombo(str);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IssueDtlBackLogDAO.IndentingStoreCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
			

	public static void VoucherDetails(IssueDtlBackLogVO vo) 
	{
	    // Declaring Variables 
		String        err = "";
		int    procIndex1 = 0;
		HisDAO        dao = null;
		WebRowSet      ws = null;
		HisUtil   hisutil = null;
		String        str = null;
		String proc_name1 = "{call Pkg_Mms_View.proc_issue_backlog_voucher_dtl(?,?,?,?,?,?,?,?)}";
		try 
		{
            // Cerating Object			
			           dao = new HisDAO("MMS",	"IssueDtlBackLogDAO.getVoucherCombo(IssueDtlBackLogVO vo)");
			       hisutil = new HisUtil("master", "IssueDtlBackLogDAO");
			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modeval", "4");                             //1
			dao.setProcInValue(procIndex1, "storeid", vo.getStrStoreId());              //2
			dao.setProcInValue(procIndex1, "toStoreId", "0");                           //3
			dao.setProcInValue(procIndex1, "itemBrandId", "0");                         //4
			dao.setProcInValue(procIndex1, "issueNo", vo.getStrVoucherNo());              //5
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());       //6
			dao.setProcOutValue(procIndex1,"err", 1); // 1 for string return            //7
			// value
			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object            //8
			// execute procedure
			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			/*if (err == null)
				err = "";*/

			if (err.equals(""))
            {

				ws = dao.getWebRowSet(procIndex1, "resultset");
				
				vo.setPopUpWS(ws);
				
			} 
			else 
			{

				throw new Exception(err);
			}

		} catch (Exception e) {
            e.printStackTrace();
			vo.setStrMsgString("IssueDtlBackLogDAO.getVoucherCombo() --> "
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
	 * To get Issue Details i.e.(Store Name,Issue No.,Issue Date,Indent
	 * Type,Item Category,Raising Store) on 'issue' page
	 * 
	 * @param vo
	 */
	public static void getVoucherCombo(IssueDtlBackLogVO vo) 
	{
	    // Declaring Variables 
		String        err = "";
		int    procIndex1 = 0;
		HisDAO        dao = null;
		WebRowSet      ws = null;
		HisUtil   hisutil = null;
		String        str = null;
		String proc_name1 = "{call Pkg_Mms_View.proc_issue_backlog_voucher_dtl(?,?,?,?,?,?,?,?)}";
		try 
		{
            // Cerating Object			
			           dao = new HisDAO("MMS",	"IssueDtlBackLogDAO.getVoucherCombo(IssueDtlBackLogVO vo)");
			       hisutil = new HisUtil("master", "IssueDtlBackLogDAO");
			procIndex1 = dao.setProcedure(proc_name1);
           // //System.out.println("Store ID:::"+ vo.getStrStoreName());
            ////System.out.println("toStoreId:::"+ vo.getStrIndentingStoreID());
            
			dao.setProcInValue(procIndex1, "modeval", "5");                             //1
			dao.setProcInValue(procIndex1, "storeid", vo.getStrStoreName());            //2
			dao.setProcInValue(procIndex1, "toStoreId", vo.getStrIndentingStoreID());   //3
			dao.setProcInValue(procIndex1, "itemBrandId", "0");                         //4
			dao.setProcInValue(procIndex1, "issueNo", "0");                             //5
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());       //6
			dao.setProcOutValue(procIndex1,"err", 1); // 1 for string return            //7
			// value
			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object            //8
			// execute procedure
			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			/*if (err == null)
				err = "";*/

			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");
				
				if (ws != null && ws.size() != 0) 
				{
					  str = hisutil.getOptionValue(ws, "", "0^Select Value", true);
					  vo.setStrVoucherCombo(str);
				} 
				else 
				{
					  str = "<option value='0'>DATA N/A</option>";
					  vo.setStrVoucherCombo(str);
				}
				
			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {
            e.printStackTrace();
			vo.setStrMsgString("IssueDtlBackLogDAO.getVoucherCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
	public static void getBatchCombo(IssueDtlBackLogVO vo) 
	{
		
		HisDAO dao = null;
		WebRowSet ws = null;
	
		String strProcName = "";
		int nProcIndex = 0;
		String str="";
	
		String strErr = "";
		HisUtil hisutil = null;
	
		try {
			dao = new HisDAO("mms", "IssueDtlBackLogDAO");
			hisutil = new HisUtil("mms", "IssueDtlBackLogDAO");
	
			strProcName = "{call Pkg_Mms_View.proc_issue_backlog_voucher_dtl(?,?,?,?,?,?,?,?)}";
			nProcIndex = dao.setProcedure(strProcName);		
				
			dao.setProcInValue(nProcIndex, "modeval", "3");                             //1
			dao.setProcInValue(nProcIndex, "storeid", "0");            //2
			dao.setProcInValue(nProcIndex, "toStoreId", "0");   //3
			dao.setProcInValue(nProcIndex, "itemBrandId", vo.getStrItemBrandId());      //4
			dao.setProcInValue(nProcIndex, "issueNo", "0");                             //5
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());       //6
			dao.setProcOutValue(nProcIndex,"err", 1); // 1 for string return            //7
			// value
			dao.setProcOutValue(nProcIndex, "resultset", 2); // 2 for object            //8
			// execute procedure
			dao.executeProcedure(nProcIndex);
			
				strErr = dao.getString(nProcIndex, "err");
	
				if (strErr == null)
					strErr = "";
	
				ws = dao.getWebRowSet(nProcIndex, "resultset");
	
				if (strErr.equals("")) 
				{
					if(ws!=null)
					{
						str = hisutil.getOptionValue(ws, vo.getStrBatchNumber(),"0^Select Value", true);
						
						vo.setStrBatchCombo(str);		
						vo.setStrMsgType("0");
					}	
					else
					{
						str = "<option value='0'>DATA N/A</option>";  
						vo.setStrBatchCombo(str);		
						vo.setStrMsgType("0");
					}
					
				} else {
					throw new Exception(strErr);
				}
			
	
		} 
		catch (Exception e) 
		{
	        e.printStackTrace();
			vo.setStrMsgString("IssueDtlBackLogDAO.getBatchCombo() --> "+ e.getMessage());
			vo.setStrMsgType("1");
	
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
	
	
	
	/*
    Item Brand Details
*/

	/**
	 * This function is used to to populate the value of Unit combo
	 * 
	 * @param vo
	 */
	public static void getUnitCombo(IssueDtlBackLogVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			dao = new HisDAO("mms", "IssueDtlBackLogDAO");

			strProcName = "{call Pkg_Mms_View.proc_GBLT_UNIT_MST(?,?,?,?,?,?)}";
			nProcIndex = dao.setProcedure(strProcName);

			
				dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
				dao.setProcInValue(nProcIndex, "unit_id", "0");
				dao.setProcInValue(nProcIndex, "modeval", "2");
				dao.setProcInValue(nProcIndex, "module_id", "63"); // default value.
				dao.setProcOutValue(nProcIndex, "err", 1);
				dao.setProcOutValue(nProcIndex, "resultset", 2);

				dao.executeProcedure(nProcIndex);

				strErr = dao.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = dao.getWebRowSet(nProcIndex, "resultset");

				if (strErr.equals("")) 
				{

					vo.setUnitComboWS(ws);

				} else {
					throw new Exception(strErr);
				}
			

		} catch (Exception e) {
            e.printStackTrace();
			vo.setStrMsgString("IssueDtlBackLogDAO.getUnitCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

		
		public static void getDrugNameCombo(IssueDtlBackLogVO vo) {
		
			HisDAO dao = null;
			WebRowSet ws = null;
		
			String strProcName = "";
			int nProcIndex = 0;
		
			String strErr = "";
		
			try {
				dao = new HisDAO("mms", "IssueDtlBackLogDAO");
		
				strProcName = "{call Pkg_Mms_View.proc_issue_backlog_voucher_dtl(?,?,?,?,?,?,?,?)}";
				nProcIndex = dao.setProcedure(strProcName);		
					
				dao.setProcInValue(nProcIndex, "modeval", "2");                             //1
				dao.setProcInValue(nProcIndex, "storeid", "0");            //2
				dao.setProcInValue(nProcIndex, "toStoreId", "0");   //3
				dao.setProcInValue(nProcIndex, "itemBrandId", "0");                         //4
				dao.setProcInValue(nProcIndex, "issueNo", "0");                             //5
				dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());       //6
				dao.setProcOutValue(nProcIndex,"err", 1); // 1 for string return            //7
				// value
				dao.setProcOutValue(nProcIndex, "resultset", 2); // 2 for object            //8
				// execute procedure
				dao.executeProcedure(nProcIndex);
				
					strErr = dao.getString(nProcIndex, "err");
		
					if (strErr == null)
						strErr = "";
		
					ws = dao.getWebRowSet(nProcIndex, "resultset");
		
					if (strErr.equals("")) 
					{
		
						vo.setDrugNameComboWS(ws);
		
					} else {
						throw new Exception(strErr);
					}
				
		
			} catch (Exception e) {
		        e.printStackTrace();
				vo.setStrMsgString("IssueDtlBackLogDAO.getDrugNameCombo() --> "
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
		 * to insert the data
		 * 
		 * @param vo
		 */
		public synchronized static void insertRecord(IssueDtlBackLogVO vo) 
		{

			HisDAO daoObj = null;
			String   strProcName2 = "";
			int       nProcIndex2 = 0;
			String strFuncName = "";
			int     nFuncIndex = 0;
			String strIssueNo= "0";
			int          index = 0;
			try 
			{
				 daoObj = new HisDAO("mms", "IssueDtlBackLogDAO");
				 if(vo.getStrVoucherNo().equals("0"))
				 {	 
					 strFuncName = "{? = call MMS_MST.generate_issueno_backlog_util(?,?,?)}";
					 nFuncIndex = daoObj.setFunction(strFuncName);
					 daoObj.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
					 daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrStoreName());
					 daoObj.setFuncInValue(nFuncIndex, 4, vo.getStrVoucherDate());
					 daoObj.setFuncOutValue(nFuncIndex, 1);
					 daoObj.executeFunction(nFuncIndex);
					 strIssueNo = daoObj.getFuncString(nFuncIndex);
				 }
				 vo.setStrIssueNo(strIssueNo);
				 index = vo.getStrDrugId().length-1;
				 strProcName2 = "{call PKG_MMS_DML.dml_issue_backlog_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";  //18
				
					for (int i = 0; i < vo.getStrDrugId().length-1; i++) 
					{						
						nProcIndex2 = daoObj.setProcedure(strProcName2);
						daoObj.setProcInValue(nProcIndex2, "modval", "1");                             //1
						daoObj.setProcInValue(nProcIndex2, "hosp_code", vo.getStrHospitalCode());      //2
						daoObj.setProcInValue(nProcIndex2, "store_id", vo.getStrStoreName());          //3
						daoObj.setProcInValue(nProcIndex2, "tostore_id", vo.getStrIndentingStoreID()); //4
						daoObj.setProcInValue(nProcIndex2, "voucherNo",vo.getStrVoucherNo());          //5
						daoObj.setProcInValue(nProcIndex2, "voucherDate",vo.getStrVoucherDate());      //6
						daoObj.setProcInValue(nProcIndex2, "indentNo",vo.getStrIndentNumber());        //7
						daoObj.setProcInValue(nProcIndex2, "indentDate",vo.getStrVoucherIndentDate()); //8
						daoObj.setProcInValue(nProcIndex2, "itemBrandId",vo.getStrDrugId()[i].split("\\^")[0]);        //9
						daoObj.setProcInValue(nProcIndex2, "oldBatchNo",vo.getStrOldBatchNo()[i]);     //10
						daoObj.setProcInValue(nProcIndex2, "batchNo",vo.getStrBatchNo()[i]);           //11
						daoObj.setProcInValue(nProcIndex2, "oldQty",vo.getStrOldIssueQty()[i]);        //12
						daoObj.setProcInValue(nProcIndex2, "newQty", vo.getStrIssueQty()[i]);          //13						
						daoObj.setProcInValue(nProcIndex2, "seatId",vo.getStrSeatId());                //14
						daoObj.setProcInValue(nProcIndex2, "counter", String.valueOf(i));                             //15
						
						if(index==i)
						{	
							daoObj.setProcInValue(nProcIndex2, "lstRecordFlag", "1");   //16		   
						}
						else
						{
							daoObj.setProcInValue(nProcIndex2, "lstRecordFlag", "0");   //16	
						}	
						
						
										
						daoObj.setProcInValue(nProcIndex2, "issueNo",strIssueNo);                      //17							
						daoObj.setProcOutValue(nProcIndex2, "err", 1);                                 //18						
						daoObj.execute(nProcIndex2, 1);						
						
						//System.out.println("DDW ID:::"+vo.getStrStoreName());
						//System.out.println("To Store ID:::"+vo.getStrIndentingStoreID());
						//System.out.println("Voucher No:::"+vo.getStrVoucherNo());
						//System.out.println("Voucher Date:::"+vo.getStrVoucherDate());
						//System.out.println("Indent No:::"+vo.getStrIndentNumber());
						//System.out.println("Indent Date:::"+vo.getStrVoucherIndentDate());
						//System.out.println("itemBrandId::"+vo.getStrDrugId()[i].split("\\^")[0]);
						//System.out.println("Old Batch No:::"+vo.getStrOldBatchNo()[i]);
						//System.out.println("New Batch NO:::"+vo.getStrBatchNo()[i]);
						//System.out.println("Old Qty::::"+vo.getStrOldIssueQty()[i]);
						//System.out.println("New Qty:::"+vo.getStrIssueQty()[i]);
						//System.out.println("Issue No::::"+strIssueNo);

					}
				
				//synchronized (daoObj) 
				//{
					daoObj.fire();

				//}

			} catch (Exception e) {
				e.printStackTrace();
				vo.setStrMsgString("--> IssueDtlBackLogDAO.insertQuery()-->"
						+ e.getMessage());
				vo.setStrMsgType("1");
			} finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			
			}

		}

}
