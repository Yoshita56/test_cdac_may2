package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.IssueSampleForQcCheckTransVO;
import mms.transactions.vo.SampleSentTransVO;

/**
 * Developer : Vivek Aggarwal
 * Version : 1.0
 * Date : 13-Jan-2012
 * Modify:  
*/
public class IssueSampleForQcCheckTransDAO 
{
	/**
	 * for getting option value of combo on add page (store type name )
	 * 
	 * @param vo
	 */

	public static void GetData(IssueSampleForQcCheckTransVO vo) 
	{
		/* Declaring Variable */
		HisDAO dao = null;
		WebRowSet wb = null;
		String str1 = null;
		HisUtil hisutil = null;
    	try 
		{
			
    		hisutil = new HisUtil("MMS", "IssueSampleForQcCheckTransDAO");
			wb      = STORENAMECOMBO(vo);
			if(wb.next())
			{
				vo.setStrStoreId(wb.getString(1));
				wb.beforeFirst();
			}
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
			
    		vo.setStrMsgString("--> IssueSampleForQcCheckTransDAO.GetData()-->"
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
	public static void getIndentDetail(IssueSampleForQcCheckTransVO vo) 
	{

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_indent_dtl(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms",
					"IssueSampleForQcCheckTransDAO.getIndentDetail(IssueSampleForQcCheckTransVO vo)");

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
			vo.setStrMsgString("IssueSampleForQcCheckTransDAO.getIndentDetail() --> "
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
	public static void getItemDetail(IssueSampleForQcCheckTransVO vo) 
	{

		String err = "";
		String proc_name1 = "{call Pkg_Mms_View.proc_indentissue_item_dtls(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms", "IssueSampleForQcCheckTransDAO");

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

			vo.setStrMsgString("IssueSampleForQcCheckTransDAO.getItemDetail() --> "
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
	public static WebRowSet STORENAMECOMBO(IssueSampleForQcCheckTransVO vo)
	{
		String proc_name = "";

		proc_name = "{call PKG_MMS_VIEW.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		
		HisDAO dao = null;
			
		int nprocIndex = 0;

		String strerr = "";

		WebRowSet ws = null;

		try {

			dao = new HisDAO("MMS",
					"transactions.IssueSampleForQcCheckTransDAO.STORENAMECOMBO(VO)");

			nprocIndex = dao.setProcedure(proc_name);

			// set value

			dao.setProcInValue(nprocIndex, "modeval", "5");
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
			vo.setStrMsgString("-->IssueSampleForQcCheckTransDAO.STORENAMECOMBO()"+ e.getMessage());

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
	public static void getAvalBudgetDetails(IssueSampleForQcCheckTransVO vo) 
	{
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_hstt_budget_dtl(?,?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

				dao = new HisDAO("MMS Transactions","IssueSampleForQcCheckTransDAO");
						
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
	public static void getPendingDemand(IssueSampleForQcCheckTransVO vo) 
	{
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_pending_demand_dtl(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

				dao = new HisDAO("MMS Transactions","IssueSampleForQcCheckTransDAO");
						
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
	public static void IndentPeriodCombo(IssueSampleForQcCheckTransVO vo) 
	{
		// Declaring Variables
		String        err = "";
		int    procIndex1 = 0;
		HisDAO        dao = null;
		WebRowSet      ws = null;
		HisUtil   hisutil = null;
		String        str = null;
		String proc_name1 = "{call PKG_MMS_VIEW.PERIOD_COMBO_SSTT_PERIOD_MST(?,?,?,?)}";

		try 
		{
			// Creating Object
			   hisutil = new HisUtil("master", "IssueSampleForQcCheckTransDAO");
			       dao = new HisDAO("mms","IssueSampleForQcCheckTransDAO.GetDeptCombo(IssueSampleForQcCheckTransVO vo)");
        	procIndex1 = dao.setProcedure(proc_name1);

			   // set value

	            dao.setProcInValue(procIndex1,  "modeval", "1");
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
			vo.setStrMsgString("IssueSampleForQcCheckTransDAO.ToStoreCombo() --> "
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
	public static void itemCategoryCombo(IssueSampleForQcCheckTransVO vo)
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
			   hisutil = new HisUtil("MMS", "IssueSampleForQcCheckTransDAO");
			   daoObj  = new HisDAO("MMS","IssueSampleForQcCheckTransDAO");
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
			if(ws.next())
			{
				vo.setStrIndentingStoreID(ws.getString(1));
			}
			ws.beforeFirst();
			
			if (strErr.equals("")) 
			{
				if(ws!=null)
				{
					str = hisutil.getOptionValue(ws, vo.getStrIndentingStoreID(),"0^Select Value", true);  // vo.setStrIndentingStoreID  Variable Used As Catg ID
					
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
			vo.setStrMsgString("IssueSampleForQcCheckTransDAO.itemCategoryCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	/**
	 * for getting Item category Combo by passing STORE_ID & HOSP_CODE
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void itemCategoryCombo1(IssueSampleForQcCheckTransVO vo)
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
			   hisutil = new HisUtil("MMS", "IssueSampleForQcCheckTransDAO");
			   daoObj  = new HisDAO("MMS","IssueSampleForQcCheckTransDAO");
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
					str = hisutil.getOptionValue(ws, "0","0^Select Value", true);  
					
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
			vo.setStrMsgString("IssueSampleForQcCheckTransDAO.itemCategoryCombo1() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * Method for getting option value of Indenting Store combo on add page (store type name )
	 * 
	 * @param vo
	 */
	public static void 	getHQNameStoreCombo(IssueSampleForQcCheckTransVO vo) 
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
			  hisutil = new HisUtil("master", "IssueSampleForQcCheckTransDAO");
			      dao = new HisDAO("MMS","IssueSampleForQcCheckTransDAO.GetDeptCombo(IssueSampleForQcCheckTransVO vo)");
  		   procIndex1 = dao.setProcedure(proc_name1);
			// set value
  		        
	            dao.setProcInValue(procIndex1, "modeval", "2");
				dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
  				dao.setProcInValue(procIndex1, "storeid", vo.getStrStoreId());
  				dao.setProcInValue(procIndex1, "reqType", "72");
				dao.setProcInValue(procIndex1, "catCode", vo.getStrIndentingStoreID());
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
			vo.setStrMsgString("IssueSampleForQcCheckTransDAO.ToStoreCombo() --> "
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
	 * This function is used to set details in approved By Combo. 
	 * @param _IssueSampleForQcCheckTransVO
	 */
	public static void getApprovedByCombo(IssueSampleForQcCheckTransVO offlineIssueIndent_VO)
	{
		// Declaring Variables
		
		int     nProcIndex = 0;
		String      strErr = "";
		HisUtil    hisutil = null;
		WebRowSet       ws = null;
		HisDAO      daoObj = null;
		String         str = null;
		String strProcName = "{call PKG_MMS_VIEW.proc_store_emp_dtl(?,?,?,?,?)}";
		try
		{
			// Creating Object
			   hisutil = new HisUtil("master", "IssueSampleForQcCheckTransDAO");
			   daoObj  = new HisDAO("MMS","IssueSampleForQcCheckTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			// set values
			daoObj.setProcInValue(nProcIndex, "modeVal", "1");
			daoObj.setProcInValue(nProcIndex, "storeId",   offlineIssueIndent_VO.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", offlineIssueIndent_VO.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex,"err",1); 
			daoObj.setProcOutValue(nProcIndex,"resultset",2);
			daoObj.executeProcedure(nProcIndex);
						
			// get value
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			
			if (ws != null && ws.size() != 0) 
			{
				 str = hisutil.getOptionValue(ws, "-1", "0^Select Value", true);
				 offlineIssueIndent_VO.setStrApprovedBy(str);
			} 
			else 
			{
				  str = "<option value='0'>DATA N/A</option>";
				  offlineIssueIndent_VO.setStrApprovedBy(str);
			}		
			
			
		}
		catch(Exception _err)
		{
			offlineIssueIndent_VO.setStrMsgString("IssueSampleForQcCheckTransDAO.getApprovedByCombo() --> "
					+ _err.getMessage());
			offlineIssueIndent_VO.setStrMsgType("1");
		}
	}
	
	/**
	 * This function is used to get details Verify By Combo. 
	 * @param _IssueSampleForQcCheckTransVO
	 */
	public static void getVerifyByCombo(IssueSampleForQcCheckTransVO _IssueSampleForQcCheckTransVO)
	{
		// Variable Declaration
		int     nProcIndex = 0;
		String      strErr = "";
		HisUtil    hisutil = null;
		WebRowSet       ws = null;
		HisDAO      daoObj = null;
		String         str = null;
		String strProcName = "{call PKG_MMS_VIEW.proc_store_emp_dtl(?,?,?,?,?)}";
		try
		{
			// Creating Object
		   	   hisutil = new HisUtil("master", "IssueSampleForQcCheckTransDAO");
			    daoObj = new HisDAO("MMS","IssueSampleForQcCheckTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			// Set Value
			daoObj.setProcInValue(nProcIndex, "modeVal", "1");
			daoObj.setProcInValue(nProcIndex, "storeId", _IssueSampleForQcCheckTransVO.getStrIndentingStoreID());
			daoObj.setProcInValue(nProcIndex, "hosp_code", _IssueSampleForQcCheckTransVO.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex,"err",1); 
			daoObj.setProcOutValue(nProcIndex,"resultset",2);
			// Execute Procedure
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (ws != null && ws.size() != 0) 
			{
				 str = hisutil.getOptionValue(ws, "-1", "0^Select Value", true);
				_IssueSampleForQcCheckTransVO.setStrVerifiedByValues(str);
			} 
			else 
			{
				  str = "<option value='0'>DATA N/A</option>";
				  _IssueSampleForQcCheckTransVO.setStrVerifiedByValues(str);
			}
			
			
		}
		catch(Exception _err)
		{
			_IssueSampleForQcCheckTransVO.setStrMsgString("IssueSampleForQcCheckTransDAO.getApprovedByCombo() --> "
					+ _err.getMessage());
			_IssueSampleForQcCheckTransVO.setStrMsgType("1");
		}
	}
	
	/**
	 * This function is used to GET THE Issue No WISE ITEM DETAILS FOR POPUP
	 * 
	 * @param vo
	 */
	public static void getPopUpInfoProc(IssueSampleForQcCheckTransVO vo) 
	{
        // Declaring Variables
		HisDAO         dao = null;
		WebRowSet       ws = null;
		String strProcName = "";
		int     nProcIndex = 0;
		String      strErr = "";
		try 
		{
			// Creating Object
			        dao = new HisDAO("MMS", "IssueSampleForQcCheckTransDAO");
			strProcName = "{call Pkg_Mms_View.PROC_ISSUE_ITEM_DETAIL(?,?,?,?,?,?)}";
			 nProcIndex = dao.setProcedure(strProcName);
			// Set Values 
			dao.setProcInValue(nProcIndex,  "MODEVAL", "1");
		    dao.setProcInValue(nProcIndex,  "ISSUENO", vo.getStrIssueNo());
			dao.setProcInValue(nProcIndex,  "STRID", vo.getStrStoreName());
			dao.setProcInValue(nProcIndex,  "HOSP_CODE", vo.getStrHospitalCode());
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);
            // Execute Procedure
			dao.executeProcedure(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(nProcIndex, "resultset"); 
			

			if (strErr.equals(""))
			{

				vo.setPopUpWS(ws);

			} 
			else 
			{
				throw new Exception(strErr);
			}

		}
		catch (Exception e) 
		{
			vo.setStrMsgString("IssueSampleForQcCheckTransDAO.getPopUpInfoProc() --> "	+ e.getMessage());
			vo.setStrMsgType("1");

		}
		finally
		{
			

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
	public static void getIssueDetail(IssueSampleForQcCheckTransVO vo) 
	{
	    // Declaring Variables 
		String        err = "";
		int    procIndex1 = 0;
		HisDAO        dao = null;
		WebRowSet      ws = null;
		String proc_name1 = "{call Pkg_Mms_View.proc_OffLine_IssueNo_dtl(?,?,?,?,?,?,?,?)}";

		try 
		{
            // Cerating Object			
			       dao = new HisDAO("MMS",	"IssueSampleForQcCheckTransDAO.getIssueDetail(IssueSampleForQcCheckTransVO vo)");
			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", "1");                  //1
			dao.setProcInValue(procIndex1, "storeid", vo.getStrStoreName());//2
			dao.setProcInValue(procIndex1, "itemCatg", vo.getStrItemCategoryCmb());//3
			dao.setProcInValue(procIndex1, "from_date", vo.getStrFromDate());//4
			dao.setProcInValue(procIndex1, "too_date", vo.getStrToDate());//5
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode()); //6
			dao.setProcOutValue(procIndex1,"err", 1); // 1 for string return //7
			// value
			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object //8
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
				vo.setIssueNoDtlWs(ws);
				
			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {
            e.printStackTrace();
			vo.setStrMsgString("IssueSampleForQcCheckTransDAO.getIssueDetail() --> "
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
	 * 
	 * @param voObj
	 */
	public static void getViewIssueSampleHlp(IssueSampleForQcCheckTransVO voObj_p) 
	{
		
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_SampleReceive_Detail(?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","SampleReceiveDetailProcessTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			////System.out.println("Mode==>"+voObj_p.getStrSearchNameType());
            if(voObj_p.getStrSearchNameType().equals("1"))
            {	
			    daoObj.setProcInValue(nProcIndex, "modeval", "3");
            }
            else
            {
            	daoObj.setProcInValue(nProcIndex, "modeval", "4");	
            }
			daoObj.setProcInValue(nProcIndex, "itemCatNo", voObj_p.getStrItemCategoryCmb());
			daoObj.setProcInValue(nProcIndex, "strId", voObj_p.getStrStoreName());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj_p.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "fromDate", voObj_p.getStrFromDate());
			daoObj.setProcInValue(nProcIndex, "toDate", voObj_p.getStrToDate());
			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
		
				voObj_p.setWrsViewIssueSampleDetail(ws);
				
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			
			voObj_p.setStrMsgString("SampleReceiveDetailProcessTransDAO.getViewSampleReceiveHlp() --> "+ e.getMessage());
			voObj_p.setStrMsgType("1");
			e.printStackTrace();

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
		
	}
	
	
	
	
	
	
	/* This Method is Used to Insert data into following Table 
	 * SSTT_ISSUE_DTL
	 * HSTT_ISSUE_DTL
	 * HSTT_ISSUE_ITEM_DTL
	 * 
	 */
	
	
	public synchronized static void insertIssueSampleForQcCheck(IssueSampleForQcCheckTransVO vo) //To be used
	{		
		HisDAO         dao = null;

		int         length = 0;
		int          index = 0;

		String[]      temp = null;
		String[]   strTemp = null;
		String[]   strTemp1 = null;
		String  proc_name1 = "";
		String  strProcName_U = "";
		String strProcName = "";
	    int      procIndex = 0;

    	try 
		{
			                   dao = new HisDAO("MMS Transactions","IssueSampleForQcCheckTransDAO");
								
			        
			        
    		 proc_name1 = "{call PKG_MMS_DML.proc_hstt_qc_issue_rec_dtl(?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?,  ?,?,?,?)}"; //34
			
			
    		 procIndex = dao.setProcedure(proc_name1);

			
		 			
            length = vo.getItemParamValue().length;
			index = length-1;
 			for(int i = 0;i<length;i++)
			{
 				
 				if(!vo.getStrIssueQty()[i].equals("0"))
				{
//		    	//System.out.println("Req Qty:::"+vo.getStrReqQty()[i]);
//		    	//System.out.println("Issue Qty:::"+vo.getStrIssueQty()[i]);
//		    	//System.out.println("Per Item Cost:::"+vo.getStrCost()[i]);
 				
				temp  = vo.getItemParamValue()[i].replace('#', '#').split("#");
				
//				//System.out.println("Display Value-->>>>"+temp[0]);
//				//System.out.println("Conversion  Value-->>>>"+temp[1]);
//				//System.out.println("User  Value-->>>>"+temp[2]);
			    
				strTemp          = temp[2].replace('^', '#').split("#");
//				strTemp1         = temp[1].replace('^', '#').split("#");
				
//				//System.out.println("------------------Start--PROC TWO--OrignalOffLineIssue Indent--------------------------");
//				//System.out.println("GenricItemID-0->>"+strTemp[0]);			
//				////System.out.println("ItemID-1->>"+strTemp[1]);
//				//System.out.println("ItemBrandID-2->>"+strTemp[1]);
//				//System.out.println("GrpID-3->>"+strTemp[3]);
//				//System.out.println("Sub_GrpID-4->>"+strTemp[4]);
//				//System.out.println("Cosumble Flg-5->>"+strTemp[5]);
//				//System.out.println("In Hand Qty-6->>"+strTemp[7]);
//				//System.out.println("In Hand Qty Unit Id-7->>"+strTemp[8]);
//				//System.out.println("Last Rate-8->>"+strTemp[9]);
//				//System.out.println("Last Rate Unit Id [Mode = 3, it will be actual rate unit id]==>"+strTemp[10]);
//				//System.out.println("Last Rate Unit Id-9->>"+strTemp[34]);
//				//System.out.println("Inventory Unit Id-10->>"+strTemp[11]);
//				//System.out.println("Last PO No-11->>"+strTemp[12]);
//				//System.out.println("Last PO Date-12->>"+strTemp[13]);
//				//System.out.println("Last Supplied By [Id]-13->>"+strTemp[14]);
//				//System.out.println("Batch No-14->>"+strTemp[15]);
//				//System.out.println("Expiry Date-15->>"+strTemp[16]);
//				//System.out.println("Manufacture Date-16->>"+strTemp[18]);
//				//System.out.println("Item Serial No-17->>"+strTemp[18]);
//				//System.out.println("Prefix-18->>"+strTemp[27]);
//				//System.out.println("Cost Parameter-19->>"+strTemp[28]);
//				//System.out.println("Cost Unit [on individual item or on total cost]-20->>"+strTemp[11]);
//				//System.out.println("Stock Status-21->>"+strTemp[32]);
//				//System.out.println("Brand reserv Flag-24->>"+strTemp[35]);
//				//System.out.println("------------------End--PROC TWO--OrignalOffLineIssue Indent--------------------------");
				
			
                   dao.setProcInValue(procIndex, "p_mode", "1");                             //1
			       dao.setProcInValue(procIndex, "p_reqtypeid","72");                       //2
			       dao.setProcInValue(procIndex, "p_HSTNUM_STORE_ID",vo.getStrStoreName());            //3
			       dao.setProcInValue(procIndex, "p_HSTNUM_QC_ISSUE_NO", "0");           //4
			       dao.setProcInValue(procIndex, "p_HSTNUM_ITEMBRAND_ID", strTemp[1]);                //5
				   dao.setProcInValue(procIndex, "p_HSTSTR_BATCH_NO", strTemp[15]);                  //6
				   dao.setProcInValue(procIndex, "p_HSTSTR_ITEM_SL_NO", strTemp[18]);                   //7
				   dao.setProcInValue(procIndex, "p_HSTNUM_STOCK_STATUS_CODE", strTemp[32]);           //8
				   dao.setProcInValue(procIndex, "p_GNUM_HOSPITAL_CODE",vo.getStrHospitalCode());        //9
				   dao.setProcInValue(procIndex, "p_HSTDT_ISSUE_DATE", vo.getStrIssueDate()); // 10
				   dao.setProcInValue(procIndex, "p_SSTNUM_ITEM_CAT_NO", vo.getStrItemCategoryCmb());       //11
				   dao.setProcInValue(procIndex, "p_HSTNUM_ITEM_ID", strTemp[0]);                      //12
				   dao.setProcInValue(procIndex, "p_HSTNUM_TOSTORE_ID", vo.getStrIndentingStoreID()); //13
				   dao.setProcInValue(procIndex, "p_HSTNUM_INHAND_QTY", strTemp[7]);                   //14
				   dao.setProcInValue(procIndex, "p_HSTNUM_INHANDQTY_UNITID", strTemp[8]);            //15
				   dao.setProcInValue(procIndex, "p_HSTNUM_ISSUE_QTY",vo.getStrIssueQty()[i]);         //16
				   dao.setProcInValue(procIndex, "p_HSTNUM_ISSUEQTY_UNITID", vo.getStrUnitName()[i].split("\\^")[0]); //17  :: This is Unit Id Save From Page  
				   dao.setProcInValue(procIndex, "p_HSTNUM_RATE", strTemp[9]);                         //18
				   dao.setProcInValue(procIndex, "p_HSTNUM_RATE_UNITID",strTemp[10]);                  //19  
				   dao.setProcInValue(procIndex, "p_HSTDT_MFG_DATE", strTemp[17]);                  //20
				   dao.setProcInValue(procIndex, "p_HSTDT_EXPIRY_DATE", strTemp[16]);                 //21
				   dao.setProcInValue(procIndex, "p_HSTNUM_SUPPLIER_ID", strTemp[14]); // 22
				   dao.setProcInValue(procIndex, "p_HSTNUM_MFG_ID", "0"); // 23
				   dao.setProcInValue(procIndex, "p_HSTSTR_PO_NO",strTemp[12]); // 24
				   dao.setProcInValue(procIndex, "p_HSTDT_PO_DATE"  ,strTemp[13]);   // 25
				   dao.setProcInValue(procIndex, "p_HSTDT_RECEIVE_DATE", "0");  // 26
				   dao.setProcInValue(procIndex, "p_HSTNUM_IS_REISSUE", vo.getStrIsReIssue()); // 27 
				   dao.setProcInValue(procIndex, "p_GSTR_REMARKS",vo.getStrRemarks());    // 28            
				   dao.setProcInValue(procIndex, "p_HSTDT_FINANCIAL_START_DATE",vo.getStrFinancialStartYear()); // 29
				   dao.setProcInValue(procIndex, "p_HSTDT_FINANCIAL_END_DATE"  ,vo.getStrFinancialEndYear());   //30
				   dao.setProcInValue(procIndex, "p_GDT_ENTRY_DATE", "0"); //31
				   dao.setProcInValue(procIndex, "p_GNUM_ISVALID", "1");   // 32
				   dao.setProcInValue(procIndex, "p_GNUM_SEATID", vo.getStrSeatId());  //33
				   dao.setProcOutValue(procIndex, "err", 1); // 1 for string return    //34			    
				  
					dao.execute(procIndex,1);
				}	
								
				
			}		   			 
 			
 			
						
							dao.fire();
							
						
					
		}
		catch (Exception e) 
		{
			    
			vo.setStrMsgString("--> IssueSampleForQcCheckTransDAO.insertIssueSampleForQcCheck()-->" + e.getMessage());
		    	vo.setStrMsgString(e.getMessage());
				vo.setStrMsgType("1");
		   	
			
			
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}
			
		}
		
	}
	
	
	
	
	/**
	 * This function is used to to populate the value of Unit combo
	 * 
	 * @param vo
	 */
	public static void getUnitCombo(IssueSampleForQcCheckTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			dao = new HisDAO("mms", "IssueSampleForQcCheckTransDAO");

			strProcName = "{call Pkg_Mms_View.proc_GBLT_UNIT_MST(?,?,?,?,?,?)}";
			nProcIndex = dao.setProcedure(strProcName);

			if (!vo.getStrSancUnitId().equals("0")) 
			{
				dao.setProcInValue(nProcIndex, "hosp_code", vo
						.getStrHospitalCode());
				dao
						.setProcInValue(nProcIndex, "unit_id", vo
								.getStrSancUnitId());
				dao.setProcInValue(nProcIndex, "modeval", "1");
				dao.setProcInValue(nProcIndex, "module_id", ""); // default value.
				dao.setProcOutValue(nProcIndex, "err", 1);
				dao.setProcOutValue(nProcIndex, "resultset", 2);

				dao.executeProcedure(nProcIndex);

				strErr = dao.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = dao.getWebRowSet(nProcIndex, "resultset");

				if (strErr.equals("")) {

					vo.setUnitComboWS(ws);

				} else {
					throw new Exception(strErr);
				}
			}

		} catch (Exception e) {

			vo.setStrMsgString("IssueSampleForQcCheckTransDAO.getUnitCombo() --> "
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
	 * INSERT method is used to insert value in two table
	 * HSTT_BREAKAGE_DTL & HSTT_BREAKAGE_ITEM_DTL
	 * @param vo
	 */

	public synchronized static void CANCELRECORDS(IssueSampleForQcCheckTransVO vo) 
	{
		/* Declaring Variable */ 
			
		String   strProcName3 = "";
		int       nProcIndex3 = 0;
		HisDAO         daoObj = null;
	
    	try 
		{
    		    daoObj = new HisDAO("MMSModule","IssueSampleForQcCheckTransDAO.INSERT()");
  			    strProcName3 = "{call PKG_MMS_DML.dml_iss_sample_rmsc_cancel_dtl(?,?,?,?,?,?,?,?,?,?,?)}";// 11 Varibale's   	        
		        nProcIndex3 = daoObj.setProcedure(strProcName3);   
		        
		        
		        /*
			    1.  receiveDate, 
				2.  storeName,
				3.  itemName,
				4.  batch no
				5.  mfgDate,
				6.  expiryDate,
				7.  issueQty,
				8.  HSTNUM_QC_ISSUE_NO, 
				9.  HSTNUM_ITEMBRAND_ID, 
				10. HSTSTR_ITEM_SL_NO, 
				11. HSTNUM_STOCK_STATUS_CODE,
				12. HSTNUM_TOSTORE_ID, 
				13. HSTNUM_INHAND_QTY, 
				14. HSTNUM_INHANDQTY_UNITID, 
				15. HSTNUM_RATE, 
				16. HSTNUM_RATE_UNITID, 
				17. HSTNUM_SUPPLIER_ID, 
				18. HSTNUM_MFG_ID, 
				19. HSTSTR_PO_NO, 
				20. HSTDT_PO_DATE, 
				21. HSTDT_RECEIVE_DATE, 
				22. HSTNUM_IS_REISSUE, 
				23. GSTR_REMARKS, 
				24. HSTDT_FINANCIAL_START_DATE, 
				25. HSTDT_FINANCIAL_END_DATE, 
				26. GDT_ENTRY_DATE, 
				27. GNUM_SEATID, 
				28  GNUM_ISVALID
				29. HSTNUM_ITEM_ID  
				30. issueDate	
				31.REPORT_RECEIVE_STATUS				
             */
		        for(int i=0;i<vo.getChkFlg().length;i++)
				{
					if(vo.getChkFlg()[i].equals("1"))
					{
//						//System.out.println("Store Id==>"+vo.getStrStoreId());
//						//System.out.println("ISSUE_NO==>"+vo.getStrCheckHidValue()[i].split("\\^")[7]);
//						//System.out.println("ITEM BRAND==>"+vo.getStrCheckHidValue()[i].split("\\^")[8]);
//						//System.out.println("BATCH ==>"+vo.getStrCheckHidValue()[i].split("\\^")[3]);
//						//System.out.println("Item_SlNo==>"+vo.getStrCheckHidValue()[i].split("\\^")[9]);
//						//System.out.println("Remarsk==>"+vo.getStrRemarks());
						daoObj.setProcInValue(nProcIndex3, "p_mode", "1");                             	     //1
						daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_STORE_ID", vo.getStrStoreId());          	     //2
						daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_QC_ISSUE_NO",vo.getStrCheckHidValue()[i].split("\\^")[7]);	     //3
						daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_ITEMBRAND_ID",vo.getStrCheckHidValue()[i].split("\\^")[8]);  //4
						daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_BATCH_NO",vo.getStrCheckHidValue()[i].split("\\^")[3]);            	     //5
						daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_ITEM_SL_NO",vo.getStrCheckHidValue()[i].split("\\^")[9]);        	         //6
						daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_STOCK_STATUS_CODE",vo.getStrCheckHidValue()[i].split("\\^")[10]);  //7
						daoObj.setProcInValue(nProcIndex3, "p_GNUM_HOSPITAL_CODE",vo.getStrHospitalCode());            	     //8
						daoObj.setProcInValue(nProcIndex3, "p_GSTR_REMARKS",vo.getStrRemarks());        	         //9
						daoObj.setProcInValue(nProcIndex3, "p_GNUM_SEATID",vo.getStrSeatId());        	         //10
						daoObj.setProcOutValue(nProcIndex3, "err", 1);                                       //11
						daoObj.execute(nProcIndex3, 1);		
					}
				}
				daoObj.fire();     
				
		
		} 
    	catch (Exception e) 
    	{
    	    e.printStackTrace();
    		vo.setStrMsgString("--> IssueSampleForQcCheckTransDAO.CANCELRECORDS()-->"	+ e.getMessage());
			vo.setStrMsgType("1");
		} 
    	finally 
    	{
			if (daoObj != null)
				daoObj.free();
			daoObj = null;
		}

	}
	
	
	

	
	

}
