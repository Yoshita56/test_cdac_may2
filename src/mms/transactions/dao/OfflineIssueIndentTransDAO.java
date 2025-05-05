package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.dao.DmlApprovalDtlDAO;
import mms.dao.DmlApprovalItemDtlDAO;
import mms.dao.DmlHsttIndentItemDtlDAO;
import mms.dao.DmlIndentDtlDAO;
import mms.dao.IssueDetailDAO;
import mms.dao.IssueItemDetailDAO;
import mms.transactions.vo.OfflineIssueIndentTransVO;
/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 16/Sep/2010
 * Modify:  
*/
public class OfflineIssueIndentTransDAO 
{
	/**
	 * for getting option value of combo on add page (store type name )
	 * 
	 * @param vo
	 */

	public static void GetData(OfflineIssueIndentTransVO vo) 
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
	public static void getIndentDetail(OfflineIssueIndentTransVO vo) 
	{

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_indent_dtl(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms",
					"OfflineIssueIndentTransDAO.getIndentDetail(OfflineIssueIndentTransVO vo)");

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
			vo.setStrMsgString("OfflineIssueIndentTransDAO.getIndentDetail() --> "
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
	public static void getItemDetail(OfflineIssueIndentTransVO vo) 
	{

		String err = "";
		String proc_name1 = "{call Pkg_Mms_View.proc_indentissue_item_dtls(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms", "OfflineIssueIndentTransDAO");

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

			vo.setStrMsgString("OfflineIssueIndentTransDAO.getItemDetail() --> "
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
	public static WebRowSet STORENAMECOMBO(OfflineIssueIndentTransVO vo)
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

			dao.setProcInValue(nprocIndex, "modeval", "12",1);
			dao.setProcInValue(nprocIndex, "seatid", vo.getStrSeatId(),2);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),3);
			dao.setProcInValue(nprocIndex, "storeid", "0",4);
			dao.setProcInValue(nprocIndex, "storetype_id", "0",5);
			dao.setProcOutValue(nprocIndex,"err", 1,6); // 1 for string return
			dao.setProcOutValue(nprocIndex,"resultset", 2,7); // 2 for object
			// execute procedure
			dao.executeProcedureByPosition(nprocIndex);

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
	public static void getAvalBudgetDetails(OfflineIssueIndentTransVO vo) 
	{
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_hstt_budget_dtl(?,?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

				dao = new HisDAO("MMS Transactions","OfflineIssueIndentTransDAO");
						
				procIndex1 = dao.setProcedure(proc_name1);
				
				dao.setProcInValue(procIndex1, "p_mode", "4",1);
				// set value
				
				dao.setProcInValue(procIndex1, "p_hstnum_store_id", vo.getStrIndentingStoreID(),2);
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
					
				if(ws != null && ws.size() > 0){
					
					while(ws.next())
					{
						vo.setStrAvalaibleBudget(ws.getString(1));
						vo.setStrAvalaibleBudgetDtl(ws.getString(2)+"$$"+ws.getString(3));
					}
					
				}else{
					
					vo.setStrAvalaibleBudget("0.00");
					vo.setStrAvalaibleBudgetDtl("0.00"+"$$"+"0.00");
					
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
	public static void getPendingDemand(OfflineIssueIndentTransVO vo) 
	{
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_pending_demand_dtl(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

				dao = new HisDAO("MMS Transactions","OfflineIssueIndentTransDAO");
						
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
	public static void IndentPeriodCombo(OfflineIssueIndentTransVO vo) 
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
			   hisutil = new HisUtil("master", "OfflineIssueIndentTransDAO");
			       dao = new HisDAO("mms","OfflineIssueIndentTransDAO.GetDeptCombo(OfflineIssueIndentTransVO vo)");
        	procIndex1 = dao.setProcedure(proc_name1);

			   // set value

	            dao.setProcInValue(procIndex1,  "modeval", "1",1);
				dao.setProcInValue(procIndex1,  "hosp_code", vo.getStrHospitalCode(),2);
				dao.setProcOutValue(procIndex1, "err", 1,3); // 1 for string return
				dao.setProcOutValue(procIndex1, "resultset", 2,4); // 2 for object
				// execute procedure
				dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

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
			vo.setStrMsgString("OfflineIssueIndentTransDAO.ToStoreCombo() --> "
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
	public static void itemCategoryCombo(OfflineIssueIndentTransVO vo)
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
			vo.setStrMsgString("OfflineIssueIndentDAO.itemCategoryCombo() --> "
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
	public static void itemCategoryCombo1(OfflineIssueIndentTransVO vo)
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
					
			if(ws.next())
			{
				vo.setStrItemCagID(ws.getString(1));
			}
            ws.beforeFirst();
			if (strErr.equals("")) 
			{
				if(ws!=null)
				{
					str = hisutil.getOptionValue(ws, vo.getStrItemCagID(),"0^Select Value", true);
					
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
	public static void IndentingStoreCombo(OfflineIssueIndentTransVO vo) 
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
			  hisutil = new HisUtil("master", "OfflineIssueIndentTransDAO");
			      dao = new HisDAO("MMS","OfflineIssueIndentTransDAO.GetDeptCombo(OfflineIssueIndentTransVO vo)");
  		   procIndex1 = dao.setProcedure(proc_name1);
			// set value
	            dao.setProcInValue(procIndex1, "modeval", "2",1);
				dao.setProcInValue(procIndex1, "hosp_code", vo	.getStrHospitalCode(),2);
  				dao.setProcInValue(procIndex1, "storeid", vo.getStrStoreId(),3);
  				dao.setProcInValue(procIndex1, "reqType", "17",4);
				dao.setProcInValue(procIndex1, "catCode", vo.getStrIndentingStoreID(),5);
				dao.setProcOutValue(procIndex1,"err", 1,6); // 1 for string return
				dao.setProcOutValue(procIndex1,"resultset", 2,7); // 2 for object
				// execute procedure
				dao.executeProcedureByPosition(procIndex1);
			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "-1", "0^Select Value", true);
				vo.setStrIndentStoreCombo(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrIndentStoreCombo(str);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("OfflineIssueIndentTransDAO.ToStoreCombo() --> "
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
	 * @param _OfflineIssueIndentVO
	 */
	public static void getApprovedByCombo(OfflineIssueIndentTransVO offlineIssueIndent_VO)
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
			   hisutil = new HisUtil("master", "OfflineIssueIndentTransDAO");
			   daoObj  = new HisDAO("MMS","OfflineIssueIndentDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			// set values
			daoObj.setProcInValue(nProcIndex, "modeVal", "1",1);
			daoObj.setProcInValue(nProcIndex, "storeId",   offlineIssueIndent_VO.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", offlineIssueIndent_VO.getStrHospitalCode(),3);
			daoObj.setProcOutValue(nProcIndex,"err",1,4); 
			daoObj.setProcOutValue(nProcIndex,"resultset",2,5);
			daoObj.executeProcedureByPosition(nProcIndex);
						
			// get value
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("webset size:"+ws.size());
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
			offlineIssueIndent_VO.setStrMsgString("OfflineIssueIndentDAO.getApprovedByCombo() --> "
					+ _err.getMessage());
			offlineIssueIndent_VO.setStrMsgType("1");
		}
	}
	
	/**
	 * This function is used to get details Verify By Combo. 
	 * @param _OfflineIssueIndentVO
	 */
	public static void getVerifyByCombo(OfflineIssueIndentTransVO _OfflineIssueIndentVO)
	{
		// Variable Declaration

		int     nProcIndex = 0;
		String      strErr = "";
		HisUtil    hisutil = null;
		WebRowSet       ws = null;
		HisDAO      daoObj = null;
		String         str = null;
		String strProcName = "{call pkg_mms_view.proc_store_emp_dtl(?,?,?,?,?)}";
		try
		{
			// Creating Object
		   	   hisutil = new HisUtil("master", "OfflineIssueIndentTransDAO");
			    daoObj = new HisDAO("MMS","OfflineIssueIndentDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			// Set Value
			daoObj.setProcInValue(nProcIndex, "modeVal", "2",1);
			daoObj.setProcInValue(nProcIndex, "storeId", _OfflineIssueIndentVO.getStrIndentingStoreID(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", _OfflineIssueIndentVO.getStrHospitalCode(),3);
			daoObj.setProcOutValue(nProcIndex,"err",1,4); 
			daoObj.setProcOutValue(nProcIndex,"resultset",2,5);
			// Execute Procedure
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (ws != null && ws.size() != 0) 
			{
				 str = hisutil.getOptionValue(ws, "-1", "0^Select Value", true);
				 str+="<option value='1'>Other</option>";
				_OfflineIssueIndentVO.setStrVerifiedByValues(str);
			} 
			else 
			{
				  str = "<option value='0'>DATA N/A</option>";
				  _OfflineIssueIndentVO.setStrVerifiedByValues(str);
			}
			
			
		}
		catch(Exception _err)
		{
			_OfflineIssueIndentVO.setStrMsgString("OfflineIssueIndentDAO.getApprovedByCombo() --> "
					+ _err.getMessage());
			_OfflineIssueIndentVO.setStrMsgType("1");
		}
	}
	
	/**
	 * This function is used to GET THE Issue No WISE ITEM DETAILS FOR POPUP
	 * 
	 * @param vo
	 */
	public static void getPopUpInfoProc(OfflineIssueIndentTransVO vo) 
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
			        dao = new HisDAO("MMS", "OfflineIssueIndentTransDAO");
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
			vo.setStrMsgString("OfflineIssueIndentTransDAO.getPopUpInfoProc() --> "	+ e.getMessage());
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
	public static void getIssueDetail(OfflineIssueIndentTransVO vo) 
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
			       dao = new HisDAO("MMS",	"OfflineIssueIndentTransDAO.getIssueDetail(OfflineIssueIndentTransVO vo)");
			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", "1",1);                  //1
			dao.setProcInValue(procIndex1, "storeid", vo.getStrStoreName(),2);//2
			dao.setProcInValue(procIndex1, "itemCatg", vo.getStrItemCategoryCmb(),3);//3
			dao.setProcInValue(procIndex1, "from_date", vo.getStrFromDate(),4);//4
			dao.setProcInValue(procIndex1, "too_date", vo.getStrToDate(),5);//5
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),6); //6
			dao.setProcOutValue(procIndex1,"err", 1,7); // 1 for string return //7
			// value
			dao.setProcOutValue(procIndex1, "resultset", 2,8); // 2 for object //8
			// execute procedure
			dao.executeProcedureByPosition(procIndex1);

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
			vo.setStrMsgString("OfflineIssueIndentTransDAO.getIssueDetail() --> "
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
	 * This Method is Used to Create New Demand
	 * 
	 * @param vo
	 */
	public static void InsertOffLineforExistingDemand(OfflineIssueIndentTransVO vo)
	{
		boolean retVal;
		retVal = OfflineIssueIndentTransDAO.InsertExistingDemandData(vo);
		if(!retVal)
		{
			vo.setStrMsgType("1");
		}
			
	}	
	
	/**
	 * To insert data
	 * 
	 * @param vo
	 */
	public static boolean InsertExistingDemandData(OfflineIssueIndentTransVO vo) 
	{

		HisDAO dao = null;
		IssueDetailDAO issueDetailDAO = null;
		IssueItemDetailDAO issueItemDetailDAO = null;
		String strFuncName = "";
		int nFuncIndex = 0;
		String strIssueNo = "";
		//String strRate = "0";
		//String strCost = "";
		String strNetCost = "0";
		String strIndentStatusFlag="0";
		//Float netRate = 0.0f;
		//Float netCost = 0.0f;
		//Float issueQtyBaseVal = 0.0f;
		String strStochStatusCodeArray[] = null;
		String strBatchSlNoArray[] = null;
		String strItemSlNoArray[] = null;
		String strIssueQtyBtchWsArray[] = null;
		String strIssueQtyUnitBtchWsArray[] = null;
		String strManufDateArray[] = null;
		String strExpiryDateArray[] = null;
		String strRateArray[] = null;
		String strRateUnitIdArray[] = null;
		String values[] = null;
		String temp[] = null;
		int batchLength = 0;
		int nProcIndex_U;

		String strProcName_U = "";
		HisUtil hisutil = null;
		boolean retVal = false;
		//int nProcIndex=0;

		try 
		{
			hisutil = new HisUtil("mms", "IssueDeskTransDAO");
			dao = new HisDAO("mms", "IssueDeskTransDAO");
			issueDetailDAO = new IssueDetailDAO();
			issueItemDetailDAO = new IssueItemDetailDAO();

			//System.out.println("vo.getStrStoreId()-"+vo.getStrIssuingStoreId());
			//System.out.println("vo.getStrReqTypeId()-"+vo.getStrReqTypeId());
			//System.out.println("vo.getStrItemCategoryNo()-"+vo.getStrItemCategoryNo());
			
			strFuncName = "{? = call MMS_MST.generate_issueNo(?::numeric,?::numeric,?::numeric,?::numeric)}";
			nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrIssuingStoreId());
			dao.setFuncInValue(nFuncIndex, 4, "31");
			dao.setFuncInValue(nFuncIndex, 5, "10");

			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strIssueNo = dao.getFuncString(nFuncIndex);
			////System.out.println("InsertExistingDemandData()----strIssueNo--->" + strIssueNo);
			vo.setStrIssueNo(strIssueNo);

			//insert data in

			for (int i = 0; i < vo.getStrItemDetailsChk().length; i++) 
			{       	
					
					if (!vo.getStockDtlsId()[i].equals("")) 
					{
						
						values = vo.getStockDtlsId()[i].split("#"); // StoreId^Generic_ItemId^Brand_ItemId^Stock_Status_Code^Batch_No^Serial_No
						batchLength = values.length;

						for (int j = 0; j < batchLength; j++) 
						{
							
							strStochStatusCodeArray    = new String[batchLength];
							strBatchSlNoArray          = new String[batchLength];
							strItemSlNoArray           = new String[batchLength];
							strIssueQtyBtchWsArray     = new String[batchLength];
							strIssueQtyUnitBtchWsArray = new String[batchLength];
							strManufDateArray          = new String[batchLength];
							strExpiryDateArray         = new String[batchLength];
							strRateArray               = new String[batchLength];
							strRateUnitIdArray         = new String[batchLength];
							                      temp = values[j].replace("^", "#").split("#");
							strStochStatusCodeArray[j] = temp[4];
							  	  strBatchSlNoArray[j] = temp[3];
							
						if(temp[4]==null)
								
							strStochStatusCodeArray[j] = "0";
						else
							strStochStatusCodeArray[j] = temp[4];
							
						if(temp[5]==null)
								
								   strItemSlNoArray[j] = "0";
							
						else
							
								   strItemSlNoArray[j] = temp[5];
							
						if(temp[7]==null)
								
								  strManufDateArray[j] = "";
							
						else
								
								  strManufDateArray[j] = temp[7];
							
												
							/*if(temp[6]==null)
								strExpiryDateArray[j]="";
							else
							strExpiryDateArray[j] = temp[6];*/
							if(temp[6]!=null && temp.length > 10 )
							{
								strExpiryDateArray[j] = temp[6];
							}
							else
							{
								strExpiryDateArray[j] = "";
							}
							
							////System.out.println("strStochStatusCodeArray[j]-->"+strStochStatusCodeArray[j]);
							////System.out.println("strExpiryDateArray[j]-->"+strExpiryDateArray[j]);
							//System.out.println(":::::::::::One:::::::::::::");
							strRateArray[j]               = temp[10];
							strRateUnitIdArray[j]         = temp[11];
							strIssueQtyBtchWsArray[j]     = temp[14];
							strIssueQtyUnitBtchWsArray[j] = temp[15];

							issueItemDetailDAO.setStrBalQty(vo.getStrBalQtyArray()[i]);
							issueItemDetailDAO.setStrBalQtyUnitId(vo.getStrBalQtyUnitIdArray()[i]);
							issueItemDetailDAO.setStrGroupId(vo.getStrGroupIdArray()[i]);
							issueItemDetailDAO.setStrHospitalCode(vo.getStrHospitalCode());
							issueItemDetailDAO.setStrIndentNO(vo.getStrIndentNo());
							issueItemDetailDAO.setStrInHandQty(vo.getStrAvlQtyArray()[i]);
							issueItemDetailDAO.setStrInHandQtyUnitId(vo.getStrAvlQtyUnitIdArray()[i]);
							issueItemDetailDAO.setStrIssueNO(strIssueNo);
							issueItemDetailDAO.setStrItemBrandId(vo.getStrBrandIdArray()[i]);
							issueItemDetailDAO.setStrItemId(vo.getStrItemIdArray()[i]);
							issueItemDetailDAO.setStrRemarks("NA");
							issueItemDetailDAO.setStrSeatId(vo.getStrSeatId());
							issueItemDetailDAO.setStrIssuingStoreId(vo.getStrIssuingStoreId());
							issueItemDetailDAO.setStrRaisingStoreId(vo.getStrRaisingStoreId());
							issueItemDetailDAO.setStrSubGroupId(vo.getStrSubGroupIdArray()[i]);
							issueItemDetailDAO.setStrReservedQtyFlag(vo.getStrReservedFlagArray()[i]);
							issueItemDetailDAO.setStrCategoryNo("10");
							issueItemDetailDAO.setStrReqTypeId("31");
							issueItemDetailDAO.setStrStockStatusCode(strStochStatusCodeArray[j]);
							issueItemDetailDAO.setStrConsumableFlag(vo.getStrConsumableFlagArray()[i]);
							issueItemDetailDAO.setStrBatchSlNo(strBatchSlNoArray[j]);
							issueItemDetailDAO.setStrItemSlno(strItemSlNoArray[j]);
							//issueItemDetailDAO.setStrStckStatusCode(strStochStatusCodeArray[j]);
							issueItemDetailDAO.setStrManufDate(strManufDateArray[j]);
							issueItemDetailDAO.setStrExpiryDate(strExpiryDateArray[j]);
							/*issueItemDetailDAO
							.setStrExpiryDate("21-May-2010");*/
							issueItemDetailDAO.setStrRate(strRateArray[j]);
							issueItemDetailDAO.setStrRateUnitId(strRateUnitIdArray[j]);
							issueItemDetailDAO.setStrIssueQty(strIssueQtyBtchWsArray[j]);
							issueItemDetailDAO.setStrIssueQtyUnitId(strIssueQtyUnitBtchWsArray[j]);
							
							issueItemDetailDAO.insert(dao);
							/*
							nProcIndex = issueItemDetailDAO.insert(dao);
							
							
							strCost = dao.getString(nProcIndex, "cost");
							
							netCost = netCost + Float.parseFloat(strCost);*/
									if(strIssueQtyBtchWsArray[j]!=vo.getStrBalQtyArray()[i])
									{
										strIndentStatusFlag = "1";
									}
							
							
							}
					} 
					else 
					{
						//System.out.println(":::::::::::TWO:::::::::::::");
						
						issueItemDetailDAO.setStrBalQty(vo.getStrBalQtyArray()[i]);
						issueItemDetailDAO.setStrBalQtyUnitId(vo.getStrBalQtyUnitIdArray()[i]);
						issueItemDetailDAO.setStrGroupId(vo.getStrGroupIdArray()[i]);
						issueItemDetailDAO.setStrHospitalCode(vo.getStrHospitalCode());
						issueItemDetailDAO.setStrIndentNO(vo.getStrIndentNo());
						issueItemDetailDAO.setStrInHandQty(vo.getStrAvlQtyArray()[i]);
						issueItemDetailDAO.setStrInHandQtyUnitId(vo.getStrAvlQtyUnitIdArray()[i]);
						issueItemDetailDAO.setStrIssueNO(strIssueNo);
						issueItemDetailDAO.setStrIssueQty(vo.getStrIssueQtyArray()[i]);
						temp = vo.getStrIssueQtyUnitIdArray()[i].replace("^","#").split("#");
						issueItemDetailDAO.setStrIssueQtyUnitId(temp[0]);
						issueItemDetailDAO.setStrItemBrandId(vo.getStrBrandIdArray()[i]);
						issueItemDetailDAO.setStrItemId(vo.getStrItemIdArray()[i]);
						issueItemDetailDAO.setStrRate("0"); // not used in proc mode 2
						issueItemDetailDAO.setStrRateUnitId("0"); // not used in proc mode 2
						issueItemDetailDAO.setStrRemarks("NA");
						issueItemDetailDAO.setStrSeatId(vo.getStrSeatId());
						issueItemDetailDAO.setStrIssuingStoreId(vo.getStrIssuingStoreId());
						issueItemDetailDAO.setStrRaisingStoreId(vo.getStrRaisingStoreId());
						issueItemDetailDAO.setStrSubGroupId(vo.getStrSubGroupIdArray()[i]);
						issueItemDetailDAO.setStrReservedQtyFlag(vo.getStrReservedFlagArray()[i]);
						issueItemDetailDAO.setStrCategoryNo("10");
						issueItemDetailDAO.setStrReqTypeId("31");
						issueItemDetailDAO.setStrStockStatusCode(vo.getStrStochStatusCodeArray()[i]);
						issueItemDetailDAO.setStrConsumableFlag(vo.getStrConsumableFlagArray()[i]);

						issueItemDetailDAO.insert2(dao);
						
						if(vo.getStrIssueQtyArray()[i]!=vo.getStrBalQtyArray()[i])
						{
							strIndentStatusFlag = "1";
						}
				
						
					/*	nProcIndex = issueItemDetailDAO.insert2(dao);
						
					
						strCost = dao.getString(nProcIndex, "cost");
						
						netCost = netCost + Float.parseFloat(strCost);*/
						
					}
				
				
			}
			
			//strNetCost = Float.toString(netCost);
			//strNetCost = HisUtil.getAmountWithDecimal(strNetCost, 2);
			// //////System.out.println("strNetSetRate-"+strNetSetRate);
			// //////System.out.println("strNetSalePrice-"+strNetSalePrice);

			// insert data in
            //System.out.println(":::::::THREE::::::::");
			////System.out.println("dao getStrHospitalCode-"+vo.getStrHospitalCode());
			issueDetailDAO.setStrHospitalCode(vo.getStrHospitalCode());
			issueDetailDAO.setStrFinancialEndYr(vo.getStrFinancialEndYear());
			issueDetailDAO.setStrFinancialStartYr(vo.getStrFinancialStartYear());
			issueDetailDAO.setStrHospitalCode(vo.getStrHospitalCode());
			issueDetailDAO.setStrIndentDate(vo.getStrIndentDate());
			issueDetailDAO.setStrIndentNO(vo.getStrIndentNo());
			issueDetailDAO.setStrIssueNO(strIssueNo);
			issueDetailDAO.setStrItemCategoryNo(vo.getStrItemCategoryNo());
			issueDetailDAO.setStrNetCost(strNetCost);
			issueDetailDAO.setStrReceivedBy("/");
			issueDetailDAO.setStrRemarks("/");
			issueDetailDAO.setStrReqStoreId(vo.getStrRaisingStoreId());
			issueDetailDAO.setStrSeatId(vo.getStrSeatId());
			issueDetailDAO.setStrStoreId(vo.getStrIssuingStoreId());
			issueDetailDAO.setStrReqTypeId("31");
		
			issueDetailDAO.insert(dao);
			
			issueDetailDAO.update(dao);
			
			if(vo.getStrBudgetFlg().equals("1")) //Here We Check 
			{					
			   //System.out.println(":::::::::::FOUR::::::::::::::");	
			   issueDetailDAO.setStrIssueNO(strIssueNo);
			   issueDetailDAO.setStrStoreId(vo.getStrIssuingStoreId());
			   issueDetailDAO.setStrHospitalCode(vo.getStrHospitalCode());	
			   issueDetailDAO.setStrAvalaibleBudget(vo.getStrAvalaibleBudget());  // Final Approx Amount
			   issueDetailDAO.update2(dao);
			  
			   strProcName_U = "{call pkg_mms_dml.proc_hstt_budget_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // Total 16 Values
				
				nProcIndex_U = dao.setProcedure(strProcName_U);
																		
				dao.setProcInValue(nProcIndex_U, "p_mode", "3");
				dao.setProcInValue(nProcIndex_U, "p_hstnum_store_id", vo.getStrRaisingStoreId()); 
				dao.setProcInValue(nProcIndex_U, "p_hstdt_finstart_date", vo.getStrFinancialStartDate());
				dao.setProcInValue(nProcIndex_U, "p_hstdt_finend_date",	vo.getStrFinancialEndDate());
				dao.setProcInValue(nProcIndex_U, "p_gnum_hospital_code",	vo.getStrHospitalCode());
				dao.setProcInValue(nProcIndex_U, "p_hstnum_slno",	"0");           //Dummy
				dao.setProcInValue(nProcIndex_U, "p_hstdt_alloc_date",vo.getStrIndentDate()); //Dummy
				dao.setProcInValue(nProcIndex_U, "p_hstnum_prevyear_budget",vo.getStrIndentDate());//Dummy
				dao.setProcInValue(nProcIndex_U, "p_hstnum_budget_allot", "0");//Dummy
				dao.setProcInValue(nProcIndex_U, "p_hstnum_budget_used", "0");//Dummy
				dao.setProcInValue(nProcIndex_U, "p_hststr_remarks", vo.getStrRemarks());
				dao.setProcInValue(nProcIndex_U, "p_gdt_entry_date", vo.getStrIndentDate());//Dummy
				dao.setProcInValue(nProcIndex_U, "p_gnum_seatid", vo.getStrSeatId());
				dao.setProcInValue(nProcIndex_U, "p_gnum_isvalid", "1");
				dao.setProcInValue(nProcIndex_U, "p_total_cost", vo.getStrFinalApproxAmt());
										
				/* Default Value */

				dao.setProcOutValue(nProcIndex_U, "err", 1);

				dao.execute(nProcIndex_U,1);
			  		  
			}
			if(vo.getStrIsDemandActiveFlag().equals("1"))  // Here We Check Whether Demand is in Active Mode
			{					
			   //System.out.println(":::::::::FIVE::::::::::::");
			   issueDetailDAO.setStrStoreId(vo.getStrIssuingStoreId());
			   issueDetailDAO.setStrHospitalCode(vo.getStrHospitalCode());	
			   issueDetailDAO.setStrIndentNO(vo.getStrIndentNo());
			   if(strIndentStatusFlag.equals("1"))
			   {
				   issueDetailDAO.setStrStatus("49");  // Un - Processed [If Issue Qty less than Balance Qty ]Means Some Qty Remaining 
			   }
			   else
			   {	   
			       issueDetailDAO.setStrStatus("50"); // Processed [If Issue Qty equals to Balance Qty ] Means All Qty is Issued
			   } 
			   issueDetailDAO.update3(dao);			   			  
			} 
			
			synchronized (dao) 
			{

				dao.fire();
				retVal = true;

			}

		} catch (Exception e) {

			e.printStackTrace();
			retVal = false;
			vo.setStrMsgString("IssueDeskTransDAO.insertData() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

			issueDetailDAO = null;
			issueItemDetailDAO = null;
		}
       return retVal;
	}
	
	/**
	 * This Method is Used to Create New Demand
	 * 
	 * @param vo
	 */
//	public static void InsertOffLineforNewDemand(OfflineIssueIndentTransVO vo)
//	{
//		boolean retVal =true;
//		retVal = OfflineIssueIndentTransDAO.OrignalOffLineIssue(vo);
//		if(retVal)
//		{
//			retVal = OfflineIssueIndentTransDAO.CreateNewOffLineIndent(vo);
//			
//		}
//		else
//		{
//			vo.setStrMsgType("1");
//		}
//		
//	}	
	/* This Method is Used to Insert data into following Table 
	 * SSTT_ISSUE_DTL
	 * HSTT_ISSUE_DTL
	 * HSTT_ISSUE_ITEM_DTL
	 * 
	 */
	
	public synchronized static boolean NewDemandOffLineIssueInsert(OfflineIssueIndentTransVO vo) 
	{		
		HisDAO         dao = null;
		String strFuncName = "";
		int     nFuncIndex = 0;
		int         length = 0;
		int          index = 0;
		String  strIssueNo = "";
		String[]      temp = null;
		String[]   strTemp = null;
		String[]   strTemp1 = null;
		String  proc_name1 = "";
		String  proc_name2 = "";
		String   proc_name = ""; 
	    int      procIndex = 0;
		int     procIndex1 = 0;
		int     procIndex2 = 0;
		boolean retVal = false;
    	try 
		{
    		System.out.println("------------------DAO - NewDemandOffLineIssueInsert ( INSERT METHOD )--------------------------");
    		
			                dao = new HisDAO("MMS Transactions","OfflineIssueIndentTransDAO");   		 
		    		 proc_name  = "{call PKG_MMS_DML.dml_offline_issue_item_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //32	
		    		 proc_name1 = "{call PKG_MMS_DML.dml_offline_issue_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //10+12=22
		    		 proc_name2 = "{call PKG_MMS_DML.dml_offline_issue_budget_dtl(?,?,?,?,?,?,?,?,?)}"; //9	
		    		
		    		 /*********************** ISSUE NO GENERATION  **************************/		 
					strFuncName = "{? = call MMS_MST.generate_issueNo(?::numeric,?::numeric,?::numeric,?::numeric)}";
					 nFuncIndex = dao.setFunction(strFuncName);
					 
					dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
					dao.setFuncInValue(nFuncIndex, 3, vo.getStrStoreName());
					dao.setFuncInValue(nFuncIndex, 4, "31");
					dao.setFuncInValue(nFuncIndex, 5, vo.getStrItemCategoryCmb());
					dao.setFuncOutValue(nFuncIndex, 1);
					dao.executeFunction(nFuncIndex);
					strIssueNo = dao.getFuncString(nFuncIndex);			
					vo.setStrIssueNo(strIssueNo);		
					 /***************************************************************/			
//			//System.out.println("------------------Start--PROC ONE--OrignalOffLineIssue Indent--------------------------");
//			//System.out.println("Issue No:::"+strIssueNo);
//			//System.out.println("Seat Id::"+vo.getStrSeatId());
//			//System.out.println("Hosp Code::"+vo.getStrHospitalCode());
//			//System.out.println("Fin End Yr::"+vo.getStrFinancialEndYear());
//			//System.out.println("Fin Start Yr::"+vo.getStrFinancialStartYear());
//			//System.out.println("App By::"+vo.getStrApprovedBy());
//			//System.out.println("Verify By::"+vo.getStrVerifiedByValues());
//			//System.out.println("App Date::"+vo.getStrApprovedDate());
//			//System.out.println("Verif Date::"+vo.getStrVerifiedDate());
//			//System.out.println("Rec By::"+vo.getStrReceivedBy());
//			//System.out.println("App Remarks::"+vo.getStrAprovedRemarks());
//			//System.out.println("Store Id::"+vo.getStrStoreName());
//			//System.out.println("Item Catg Cmb::"+vo.getStrItemCategoryCmb());
//			//System.out.println("Indenting Store::"+vo.getStrIndentingStoreID());
//			//System.out.println("Indent Type::"+vo.getStrIndentType());
//			//System.out.println("Indent Status::"+vo.getIsNormal());
//			//System.out.println("Indent Period::"+vo.getStrIndentPeriodValue());
//			//System.out.println("Indent No:::"+vo.getStrIndentNo());
//			//System.out.println("Indent Date::"+vo.getStrIndentDate());
//			//System.out.println("------------------End--PROC ONE---OrignalOffLineIssue Indent-------------------------");
		    /******************************** [ PPROCEDURE ONE ]*******************************/
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "modeval"    ,"1",1);                         //1
			dao.setProcInValue(procIndex1, "store_id"   ,vo.getStrStoreName(),2);        //2
			dao.setProcInValue(procIndex1, "issueNo"    ,strIssueNo,3);                  //3
			dao.setProcInValue(procIndex1, "hosp_code"  ,vo.getStrHospitalCode(),4);     //4
			dao.setProcInValue(procIndex1, "cat_No"     ,vo.getStrItemCategoryCmb(),5);  //5
			dao.setProcInValue(procIndex1, "indent_No"  ,vo.getStrIndentNo(),6);         //6
		    dao.setProcInValue(procIndex1, "indent_Date",vo.getStrIndentDate(),7);       //7
		    dao.setProcInValue(procIndex1, "reqStore_id",vo.getStrIndentingStoreID(),8); //8
		    dao.setProcInValue(procIndex1, "indentType" ,vo.getStrIndentType(),9);       //9
		    dao.setProcInValue(procIndex1, "indentPeriod",vo.getStrIndentPeriodValue(),10);    //10
		    dao.setProcInValue(procIndex1, "indentStatus",vo.getIsNormal(),11);                //11
		    dao.setProcInValue(procIndex1, "appBy"       ,vo.getStrApprovedBy(),12);           //12
		    dao.setProcInValue(procIndex1, "verifyBy"    ,vo.getStrVerifiedByValues(),13);     //13
		    dao.setProcInValue(procIndex1, "appDate"     ,vo.getStrApprovedDate(),14);         //14
		    dao.setProcInValue(procIndex1, "verifyDate"  ,vo.getStrVerifiedDate(),15);         //15
		    dao.setProcInValue(procIndex1, "receivedBy"  ,(vo.getStrReceivedBy().equals("1")?vo.getStrApprovedByOther():vo.getStrReceivedBy()),16);           //16
		    dao.setProcInValue(procIndex1, "fin_start_date",vo.getStrFinancialStartYear(),17); //17
		    dao.setProcInValue(procIndex1, "fin_end_date"  ,vo.getStrFinancialEndYear(),18);   //18
		    dao.setProcInValue(procIndex1, "remarks"       ,vo.getStrAprovedRemarks(),19);     //19
		    dao.setProcInValue(procIndex1, "seatId"        ,vo.getStrSeatId(),20);             //20
		    dao.setProcInValue(procIndex1, "indentIssueDate",vo.getStrIndentIssueDate(),21);   //21		    
		    dao.setProcOutValue(procIndex1, "err"          ,1,22); // 1 for string return      //22
	        dao.execute(procIndex1, 1);
	       
 		   /******************************** [ PPROCEDURE THREE ]*******************************/
				 			
               length = vo.getItemParamValue().length;
			    index = length-1;
 			for(int i = 0;i<length;i++)
			{
 				if(vo.getStrIssueQty()[i] != null && vo.getStrIssueQty()[i].length() > 0 && !vo.getStrIssueQty()[i].equals("0"))
				{
//		    	//System.out.println("Req Qty:::"+vo.getStrReqQty()[i]);
//		    	//System.out.println("Issue Qty:::"+vo.getStrIssueQty()[i]);
//		    	//System.out.println("Per Item Cost:::"+vo.getStrCost()[i]); 				
				temp  = vo.getItemParamValue()[i].replace('#', '#').split("#");				
//				//System.out.println("Display Value-->>>>"+temp[0]);
//				//System.out.println("Conversion  Value-->>>>"+temp[1]);
//				//System.out.println("User  Value-->>>>"+temp[2]);			    
				strTemp          = temp[2].replace('^', '#').split("#");
				strTemp1         = temp[1].replace('^', '#').split("#");				
//				//System.out.println("------------------Start--PROC TWO--OrignalOffLineIssue Indent--------------------------");
//				//System.out.println("GenricItemID-0->>"+strTemp[0]);			
//				//System.out.println("ItemID-1->>"+strTemp[1]);
//				//System.out.println("ItemBrandID-2->>"+strTemp[2]);
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
				
					procIndex = dao.setProcedure(proc_name);	
					dao.setProcInValue(procIndex, "modeval", "1",1);                             //1
					dao.setProcInValue(procIndex, "hosp_code",vo.getStrHospitalCode(),2);        //2
					dao.setProcInValue(procIndex, "store_id",vo.getStrStoreName(),3);            //3
					dao.setProcInValue(procIndex, "issueNo",strIssueNo,4);                       //4
					dao.setProcInValue(procIndex, "reqStore_id", vo.getStrIndentingStoreID(),5); //5
					dao.setProcInValue(procIndex, "indent_No", vo.getStrIndentNo(),6);           //6
				    dao.setProcInValue(procIndex, "cat_No", vo.getStrItemCategoryCmb(),7);       //7
				    dao.setProcInValue(procIndex, "item_id", strTemp[0],8);                      //8
				    dao.setProcInValue(procIndex, "item_brand_id", strTemp[1],9);                //9
				    dao.setProcInValue(procIndex, "batchSl_no", strTemp[15],10);                  //10
				    dao.setProcInValue(procIndex, "item_SlNo", strTemp[18],11);                   //11
				    dao.setProcInValue(procIndex, "stock_status_code", strTemp[32],12);           //12
				    dao.setProcInValue(procIndex, "grp_id", strTemp[2],13);                       //13
				    dao.setProcInValue(procIndex, "subgroup_id", strTemp[3],14);                  //14
				    dao.setProcInValue(procIndex, "inhand_qty", strTemp[7],15);                   //15
				    dao.setProcInValue(procIndex, "inhand_qty_unitid", strTemp[8],16);            //16
				    dao.setProcInValue(procIndex, "req_qty",vo.getStrReqQty()[i],17);             //17
				    dao.setProcInValue(procIndex, "issue_qty",vo.getStrIssueQty()[i],18);         //18
				    dao.setProcInValue(procIndex, "unitid", vo.getStrUnitName()[i].split("\\^")[0],19); //19  :: This is Unit Id Save From Page
				    dao.setProcInValue(procIndex, "manuf_date", strTemp[17],20);                  //20
				    dao.setProcInValue(procIndex, "expiry_date", strTemp[16],21);                 //21
				    dao.setProcInValue(procIndex, "rate", strTemp[9],22);                         //22
				    dao.setProcInValue(procIndex, "rate_unitid",strTemp[10],23);                  //23 
				    dao.setProcInValue(procIndex, "comsumable_flag",strTemp[4],24);               //24
				    if(index==i)
				    {	
				      dao.setProcInValue(procIndex, "lastItemFlag", "1",25);                        //25
				    }
				    else
				    {
				      dao.setProcInValue(procIndex, "lastItemFlag", "0",25);                        //25	
				    }	
				    dao.setProcInValue(procIndex, "seatId", vo.getStrSeatId(),26);                  //26
				    dao.setProcInValue(procIndex, "indentIssueDate",vo.getStrIndentIssueDate(),27); //27				    
				    dao.setProcInValue(procIndex, "budgetAvl",vo.getStrAvalaibleBudget(),28);       //28
				    dao.setProcInValue(procIndex, "finStartDate",vo.getStrFinancialStartYear(),29); //29
				    dao.setProcInValue(procIndex, "finEndDate",vo.getStrFinancialEndYear(),30);     //30
				    dao.setProcInValue(procIndex, "raisingAvlQty",vo.getStrReqStoreAvlQty()[i],31); //31				    
				    dao.setProcOutValue(procIndex, "err", 1,32); // 1 for string return             //32
					dao.execute(procIndex, 1);
				}	
								
				
			}
 			 /******************************** [ PPROCEDURE TWO ]*******************************/            
    		procIndex2 = dao.setProcedure(proc_name2);
 			dao.setProcInValue(procIndex2,  "modeval"      ,"1",1);                             //1
 			dao.setProcInValue(procIndex2,  "hosp_code"    ,vo.getStrHospitalCode(),2);         //2
 			dao.setProcInValue(procIndex2,  "store_id"     ,vo.getStrStoreName(),3);            //3
 			dao.setProcInValue(procIndex2,  "issueno"      ,strIssueNo,4);                      //4
 			dao.setProcInValue(procIndex2,  "reqstore_id"  ,vo.getStrIndentingStoreID(),5);     //5
 			dao.setProcInValue(procIndex2,  "budgetAvl"    ,vo.getStrAvalaibleBudget(),6);      //6
 		    dao.setProcInValue(procIndex2,  "finStartDate" ,vo.getStrFinancialStartYear(),7);   //7
 		    dao.setProcInValue(procIndex2,  "finEndDate"   ,vo.getStrFinancialEndYear(),8);     //8
 		    dao.setProcOutValue(procIndex2, "err"          ,1,9); // 1 for string return        //9		 	    
 		    dao.execute(procIndex2, 1);		    
 			
					dao.fire();
				    //retVal=true;
										
					vo.setStrStoreName(vo.getStrStoreName());
					vo.setStrIssueNo(strIssueNo);
					vo.setStrIndentNo(vo.getStrIndentNo());
					vo.setStrIndentDate(vo.getStrIndentDate());
					vo.setStrIndentIssueDate(vo.getStrIndentIssueDate());
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString(e.getMessage());
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
		return retVal;
	}	
	
	/**
	 * This method is used to insert data into Table'
	 * 
	 * @param vo
	 */

	public static boolean CreateNewOffLineIndent(OfflineIssueIndentTransVO vo) 
	{
		HisDAO dao = null;
		int procIndex1 = 0;
		String indentNo = "";
		String approvalFlg = "";
		DmlIndentDtlDAO globalDao = null;
		boolean retVal = false;
		try 
		{	
			globalDao = new DmlIndentDtlDAO();
			dao = new HisDAO("MMS", "transactions.OfflineIssueIndentTransDAO.CreateNewOffLineIndent()");
//			//System.out.println("------------------Start--CreateNewOffLineIndent--PROC THREE--------------------------");
//			//System.out.println("Seat Id::"+vo.getStrSeatId());
//			//System.out.println("Hosp Code::"+vo.getStrHospitalCode());
//			//System.out.println("Fin End Yr::"+vo.getStrFinancialEndYear());
//			//System.out.println("Fin Start Yr::"+vo.getStrFinancialStartYear());
//			//System.out.println("App By::"+vo.getStrApprovedBy());
//			//System.out.println("Verify By::"+vo.getStrVerifiedByValues());
//			//System.out.println("App Date::"+vo.getStrApprovedDate());
//			//System.out.println("Verif Date::"+vo.getStrVerifiedDate());
//			//System.out.println("Rec By::"+vo.getStrReceivedBy());
//			//System.out.println("App Remarks::"+vo.getStrAprovedRemarks());
//			//System.out.println("Store Id::"+vo.getStrStoreName());
//			//System.out.println("Item Catg Cmb::"+vo.getStrItemCategoryCmb());
//			//System.out.println("Indenting Store::"+vo.getStrIndentingStoreID());
//			//System.out.println("Indent Type::"+vo.getStrIndentType());
//			//System.out.println("Indent Status::"+vo.getIsNormal());
//			//System.out.println("Indent Period::"+vo.getStrIndentPeriodValue());
//			//System.out.println("Indent No:::"+vo.getStrIndentNo());
//			//System.out.println("Indent Date::"+vo.getStrIndentDate());
		
//			//System.out.println("-----------------------END CreateNewOffLineIndent--PROC THREE-------------------------");
			globalDao.setStrId(vo.getStrStoreName());
			globalDao.setHosp_code(vo.getStrHospitalCode());
			globalDao.setReqTypeId("31");
			globalDao.setToStrId(vo.getStrIndentingStoreID());
			globalDao.setItemcatNo(vo.getStrItemCategoryCmb());
			globalDao.setItemTypeId("0"); // Check
			globalDao.setUrgentFlag(vo.getIsNormal());
			globalDao.setIndentPeriod(vo.getStrIndentPeriodValue());
			globalDao.setIndentPeriodValue(vo.getStrIndentPeriodValue());
			globalDao.setFinStartDate(vo.getStrFinancialStartYear());
			globalDao.setFinEndDate(vo.getStrFinancialEndYear());
			globalDao.setRemarks(vo.getStrAprovedRemarks());
			globalDao.setSeatId(vo.getStrSeatId());
			globalDao.setGrantTypeId("0");
			globalDao.setPuk("0");
			globalDao.setEmpNo("0");
			globalDao.setAdmNo("0");
			globalDao.setEpisodeCode("0");
			globalDao.setConsultantId("0");
			globalDao.setMemoNo("0");
			globalDao.setTotCost("0");
			procIndex1 = globalDao.insert(dao);

			synchronized (dao) 
			{
				dao.fire(); // Here we Execute in Batch
				retVal = true;
			}
			indentNo = dao.getString(procIndex1, "indentNo");
			approvalFlg = dao.getString(procIndex1, "approvalFlg");
			vo.setStrIndentNo(indentNo);
			// //System.out.println("Genrated Indent No-->>"+indentNo);
			// //System.out.println("Genrated Approval Flg-->>"+approvalFlg);
			 if(retVal)
			 {	 
				 retVal = InesertNewIndentItem(vo, indentNo, approvalFlg);
				 if(retVal)
				 {
					 retVal = OfflineIssueIndentTransDAO.InsertNewIndentApprovalRaisingStore(vo, indentNo);
					 if(retVal)
					 {
						 retVal = OfflineIssueIndentTransDAO.InsertNewIndentApprovalIssuingStore(vo, indentNo);
					 }
				 }
			 } 
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			retVal = false;
			vo.setStrMsgString("--> OfflineIssueIndentTransDAO.CreateNewOffLineIndent()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null)
				dao.free();
			dao = null;
		}
       return retVal;
	}
  
	public static boolean InesertNewIndentItem(OfflineIssueIndentTransVO vo, String indentNo,String approvalFlg)
	{
		HisDAO dao = null;
		String[] temp = null;
		String[] strTemp = null;
		DmlHsttIndentItemDtlDAO tableDao = null;
		String[] reqQtyUnit = null;
		boolean retVal;

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

			dao = new HisDAO("MMS", "transactions.OfflineIssueIndentTransDAO.InesertNewIndentItem()");
			int length = vo.getItemParamValue().length;
			
			System.out.println("------------------DAO - InesertNewIndentItem--------------------------");

			for (int i = 0; i < length; i++) 
			{

				temp = vo.getItemParamValue()[i].replace('#', '#').split("#");
				strTemp = temp[2].replace('^', '#').split("#");
				
//				  //System.out.println("Display Value-->>>>"+temp[0]);
//				  //System.out.println("Conversion  Value-->>>>"+temp[1]);
//				  //System.out.println("User  Value-->>>>"+temp[2]);
//				  //System.out.println("------------------Start--InesertNewIndentItem--PROC FOUR----------------------------");
//				  //System.out.println("ItemID-1->>"+strTemp[0]);
//				  //System.out.println("ItemBrandID-2->>"+strTemp[1]);
//				  //System.out.println("GrpID-3->>"+strTemp[2]);
//				  //System.out.println("Sub_GrpID-4->>"+strTemp[3]);
//				  //System.out.println("Cosumble Flg-5->>"+strTemp[4]);
//				  //System.out.println("Re-Order Qty-6->>"+strTemp[5]);
//				  //System.out.println("Re-Order Qty unit Id-7->>"+strTemp[6]);
//				  //System.out.println("In Hand Qty-8->>"+strTemp[7]);
//				  //System.out.println("In Hand Qty Unit Id-9->>"+strTemp[8]);
//				  //System.out.println("Last Rate-10->>"+strTemp[9]);
//				  //System.out.println("Last Rate Unit Id-11->>"+strTemp[10]);
//				  
//				  
//				  //System.out.println("Inventory Unit Id-12->>"+strTemp[11]);
//				  //System.out.println("Last PO No-13->>"+strTemp[12]);
//				  //System.out.println("Last PO Date-14->>"+strTemp[13]);
//				  System.out .println("Last Supplied By [Id]-15->>"+strTemp[14]);
//				  //System.out.println("Batch No-16->>"+strTemp[15]);
//				  //System.out.println("Expiry Date-17->>"+strTemp[16]);
//				  //System.out.println("Manufacture Date-18->>"+strTemp[17]);
//				  //System.out.println("Item Serial No-19->>"+strTemp[18]);
//				  //System.out.println("Last Received Qty [PO]-20->>"+strTemp[19]);
//				  //System.out.println("Last Received Qty Unit Id [PO]-21->>"+strTemp[20]);
//				  
//				  //System.out.println("Last Indented Qty-22->>"+strTemp[21]);
//				  //System.out.println("Last Indented Qty Unit Id-23->>"+strTemp[22]);
//				  //System.out.println("Last Received Qty-24->>"+strTemp[23]);
//				  //System.out.println("Last Received Qty Unit Id-25->>"+strTemp[24]);
//				  //System.out.println("Last Year Consumption Qty-26->>"+strTemp[25]);
//				  //System.out.println("Last Year Consumption Qty Unit Id-27->>"+strTemp[26]); 
//				  //System.out.println("Prefix-28->>"+strTemp[27]);
//				  //System.out.println("Cost Parameter-29->>"+strTemp[28]);
//				  //System.out.println( "Cost Unit [on individual item or on total cost]-30->>"+strTemp[29]);
//				  //System.out.println("Purchase Lead Time-31->>"+strTemp[30]);
//				  //System.out.println("Purchase Lead Time Unit-32->>"+strTemp[31]); 
//				  //System.out.println("Stock Status-33->>"+strTemp[32]);
//				  //System.out.println("indent No-in LP DEPT .->>>"+indentNo);
//				  //System.out.println("Store ID LP DEEPT.....--->>>"+vo.getStrStoreName());
//				  //System.out.println("------------------Start--InesertNewIndentItem--PROC FOUR--------------------------");
				
				
			    	////System.out.println("Req Qty:::"+vo.getStrReqQty()[i]);
			    	////System.out.println("Issue Qty:::"+vo.getStrIssueQty()[i]);
	 				
//					temp  = vo.getItemParamValue()[i].replace('#', '#').split("#");
//					
//					////System.out.println("Display Value-->>>>"+temp[0]);
//					////System.out.println("Conversion  Value-->>>>"+temp[1]);
//					////System.out.println("User  Value-->>>>"+temp[2]);
//				    
//					strTemp         = temp[2].replace('^', '#').split("#");
//					//System.out.println("------------------Start--Item--Offline Indent--------------------------");
//					//System.out.println("GenricItemID-0->>"+strTemp[0]);			
//					//System.out.println("ItemID-1->>"+strTemp[1]);
//					//System.out.println("ItemBrandID-2->>"+strTemp[2]);
//					//System.out.println("GrpID-3->>"+strTemp[3]);
//					//System.out.println("Sub_GrpID-4->>"+strTemp[4]);
//					//System.out.println("Cosumble Flg-5->>"+strTemp[5]);
//					//System.out.println("In Hand Qty-6->>"+strTemp[7]);
//					//System.out.println("In Hand Qty Unit Id-7->>"+strTemp[8]);
//					//System.out.println("Last Rate-8->>"+strTemp[33]);
//					//System.out.println("Last Rate Unit Id-9->>"+strTemp[34]);
//					//System.out.println("Inventory Unit Id-10->>"+strTemp[11]);
//					//System.out.println("Last PO No-11->>"+strTemp[12]);
//					//System.out.println("Last PO Date-12->>"+strTemp[13]);
//					//System.out.println("Last Supplied By [Id]-13->>"+strTemp[14]);
//					//System.out.println("Batch No-14->>"+strTemp[15]);
//					//System.out.println("Expiry Date-15->>"+strTemp[16]);
//					//System.out.println("Manufacture Date-16->>"+strTemp[18]);
//					//System.out.println("Item Serial No-17->>"+strTemp[18]);
//					//System.out.println("Prefix-18->>"+strTemp[27]);
//					//System.out.println("Cost Parameter-19->>"+strTemp[28]);
//					//System.out.println("Cost Unit [on individual item or on total cost]-20->>"+strTemp[11]);
//					//System.out.println("Stock Status-21->>"+strTemp[32]);
//					//System.out.println("Brand reserv Flag-24->>"+strTemp[35]);
//					//System.out.println("------------------End--Item--Offline Indent--------------------------");
	
				strReqQty = vo.getStrReqQty()[i];

				strReqUnit = strTemp[11];

				if (approvalFlg.equals("0")) 
				{
					strSancQty = strReqQty;
					strSancQtyUnit = strTemp[11];
				} 
				else 
				{
					strSancQty = "0";
					strSancQtyUnit = "0";
				}

				tableDao.setStrIndentNo(indentNo);
				tableDao.setStrStoreId(vo.getStrStoreName());
				tableDao.setStrHospCode(vo.getStrHospitalCode());
				tableDao.setStrGroupId(strTemp[2]);
				tableDao.setStrSubGroupId(strTemp[3]);
				tableDao.setStrItemId(strTemp[0]);
				tableDao.setStrItemBrandId(strTemp[1]);
				tableDao.setStrRate(strTemp[9]);
				tableDao.setStrRateUnitId(strTemp[10]);
				tableDao.setStrIndentQty(strReqQty);
				tableDao.setStrIndentQtyUnitId(strTemp[11]);
				tableDao.setStrSancQty(strSancQty);
				tableDao.setStrSancQtyUnitId(strSancQtyUnit);
				tableDao.setStrIssueQty(vo.getStrIssueQty()[i]);
				tableDao.setStrIssueqtyUnitId(strTemp[11]);
				tableDao.setStrinHandQty(strTemp[7]);
				tableDao.setStrInHandQtyUnitId(strTemp[8]);
				tableDao.setStrConsumableFlag("1");
				tableDao.setStrReOrderLevel(strTemp[5]);
				tableDao.setStrReOrderLevelUnitId(strTemp[6]);
				tableDao.setStrLastIndentQty(strTemp[21]);
				tableDao.setStrLastIndentQtyUnitId(strTemp[22]);
				tableDao.setStrLastIssueQty("0");
				tableDao.setStrLastIssueQtyUnitId("0");
				tableDao.setStrRemarks(vo.getStrAprovedRemarks());

				tableDao.insert(dao);

			}
			synchronized (dao) 
			{
				retVal = true;
				dao.fire(); // Here we Execute in Batch
			}

		}
		catch (Exception e) 
		{
			retVal = false; 
			e.printStackTrace();
			vo.setStrMsgString("--> RequestForLPPatientDAO.InesertNewIndentItem()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}
		return retVal;

	}
	
	
	
	/**
	 *  Insert into Table  DML_APPROVAL_DTL
	 *  @param vo
	 *  
	 * */

	public static boolean InsertNewIndentApprovalRaisingStore(OfflineIssueIndentTransVO vo,String strIndentNo) 
	{
		HisDAO       dao  = null;
		DmlApprovalDtlDAO globalDao = null;
		boolean retVal = false;
		int    procIndex1 = 0;
		String strFuncName = "";
		int     nFuncIndex = 0;
		String strAppNo;
		
    	try 
		{
    		// Createing Object for Table Specific DAO
    		globalDao = new DmlApprovalDtlDAO();	
    		dao = new HisDAO("MMS","transactions.ApprovalDeskDAO.InsertNewIndentApproval()");
    		
    		System.out.println("------------------DAO - InsertNewIndentApprovalRaisingStore--------------------------");
//    		 //System.out.println("------------------Start--InesertNewIndentItem--PROC FIVE----------------------------");
//       		 //System.out.println("Indent No:::: "+strIndentNo);
// 			 //System.out.println("Issuing Store Id::::"+vo.getStrIssuingStoreId());
//  			 //System.out.println("Raising Store Id:::::"+vo.getStrRaisingStoreId());
//    		 //System.out.println("------------------END--InesertNewIndentItem--PROC FIVE----------------------------");
    		  //FUNCTION get_Approval_No (TRANS_NO NUMBER,STORE_ID NUMBER ,hosp_code NUMBER)  

    		 strFuncName = "{? = call MMS_MST.get_Approval_No(?,?,?)}";
    		 			 nFuncIndex = dao.setFunction(strFuncName);
    		 			 dao.setFuncInValue(nFuncIndex, 2, strIndentNo);
    		 			 dao.setFuncInValue(nFuncIndex, 3, vo.getStrRaisingStoreId());
    		 			 dao.setFuncInValue(nFuncIndex, 4, vo.getStrHospitalCode());
    		 			 dao.setFuncOutValue(nFuncIndex, 1);
    		 			 dao.executeFunction(nFuncIndex);
    		 			 strAppNo = dao.getFuncString(nFuncIndex);
    		 			 ////System.out.println("genrated Approval No::in Raising::"+strAppNo);
    		 
    		 
    		 
		        globalDao.setStrId(vo.getStrRaisingStoreId());            //1
				globalDao.setHosp_code(vo.getStrHospitalCode());     //2
    			globalDao.setReqNo(strIndentNo);                     //3
	    		globalDao.setLevelType("0"); // Check                //4
				globalDao.setApprovalType("1"); // Check             //5
				globalDao.setIpAddress(vo.getStrIpAddress());        //6
		    	globalDao.setFinStartDate(vo.getStrFinancialStartYear()); //7
				globalDao.setFinEndDate(vo.getStrFinancialEndYear());     //8
			    globalDao.setRemarks(vo.getStrAprovedRemarks());          //9 
				globalDao.setSeatId(vo.getStrSeatId());                   //10
				globalDao.setReqtype("31");              //11
				globalDao.setCatno("10");                //12  
				globalDao.setReqStatus("0");              //13  
				globalDao.setNewStatus("10");              //14 
				globalDao.setItemDtl("1");               //15
				globalDao.setAuthNo("0");                //16
				globalDao.setAppId("0");                 //17
				globalDao.setToStore("0"); //18
				globalDao.setInstCode("0");              //19
				globalDao.setInstSlno("0");              //20
				globalDao.setSuppId("0");                //21 
				globalDao.setAppNo(strAppNo);                //21 
			    globalDao.setModval("1");                //22
											
			    procIndex1 = globalDao.insert1(dao);  //Procedure Name DML_OFFLINE_APPROVAL_DTL
			   		   		  									
	         
			    synchronized(dao)   
				  {
		         	dao.fire();     // Here we Execute the Procedure
		         	retVal = true;
				  }
			      			      
				  		      
			      if(retVal)
			      {	  
			    	  //retVal = InsertNewIndentApprovalItemTable(vo,strAppNo,"10","0",strIndentNo);   // DML_OFFLINE_APPROVALITEM_DTL
			    	  //(OfflineIssueIndentTransVO vo,String appNo,String status,String lstStatus,String strIndentNo) 
			      }
			      if (vo.getStrMsgType().equals("1")) 
				  {
						
						throw new Exception(vo.getStrMsgString());
				  }
		      		    
		    	  
	     	}
			catch (Exception e) 
    	    {
    		e.printStackTrace();
			vo.setStrMsgString("-->IndentApprovalDeskDAO.InsertNewIndentApproval()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} 
    	finally 
    	{
			if (dao != null)
				dao.free();
			dao = null;
		}
    	return retVal;

	}
	
	
	/**
	 *  Insert into Table  DML_APPROVAL_DTL
	 *  @param vo
	 *  
	 * */

	public static boolean InsertNewIndentApprovalIssuingStore(OfflineIssueIndentTransVO vo,String strIndentNo) 
	{
		HisDAO       dao  = null;
		int    procIndex1 = 0;
		DmlApprovalDtlDAO globalDao = null;
		boolean retVal = false;
		String strFuncName = "";
		int     nFuncIndex = 0;
		String strAppNo;
		
    	try 
		{
    		// Createing Object for Table Specific DAO
    		globalDao = new DmlApprovalDtlDAO();	
    		
    		System.out.println("------------------DAO - InsertNewIndentApprovalIssuingStore--------------------------");
    		
    		dao = new HisDAO("MMS","transactions.ApprovalDeskDAO.InsertNewIndentApprovalIssuingStore()");
//    		 //System.out.println("------------------Start--InsertNewIndentApprovalIssuingStore--PROC FIVE----------------------------");
//       		 //System.out.println("Indent No:::: "+strIndentNo);
// 			 //System.out.println("Issuing Store Id::::"+vo.getStrIssuingStoreId());
//  			 //System.out.println("Raising Store Id:::::"+vo.getStrRaisingStoreId());
//    		 //System.out.println("------------------END--InsertNewIndentApprovalIssuingStore--PROC FIVE----------------------------");
    		    
    		//FUNCTION get_Approval_No (TRANS_NO NUMBER,STORE_ID NUMBER ,hosp_code NUMBER)  

    		 strFuncName = "{? = call MMS_MST.get_Approval_No(?,?,?)}";
    		 			 nFuncIndex = dao.setFunction(strFuncName);
    		 			 dao.setFuncInValue(nFuncIndex, 2, strIndentNo);
    		 			 dao.setFuncInValue(nFuncIndex, 3, vo.getStrIssuingStoreId());
    		 			 dao.setFuncInValue(nFuncIndex, 4, vo.getStrHospitalCode());
    		 			 dao.setFuncOutValue(nFuncIndex, 1);
    		 			 dao.executeFunction(nFuncIndex);
    		 			 strAppNo = dao.getFuncString(nFuncIndex);
    		 			 ////System.out.println("genrated Approval No::IN Issuing::"+strAppNo);
    		    
		        globalDao.setStrId(vo.getStrIssuingStoreId());            //1
				globalDao.setHosp_code(vo.getStrHospitalCode());     //2
    			globalDao.setReqNo(strIndentNo);                     //3
	    		globalDao.setLevelType("0"); // Check                //4
				globalDao.setApprovalType("1"); // Check             //5
				globalDao.setIpAddress(vo.getStrIpAddress());        //6
		    	globalDao.setFinStartDate(vo.getStrFinancialStartYear()); //7
				globalDao.setFinEndDate(vo.getStrFinancialEndYear());     //8
			    globalDao.setRemarks(vo.getStrAprovedRemarks());          //9 
				globalDao.setSeatId(vo.getStrSeatId());                   //10
				globalDao.setReqtype("31");              //11
				globalDao.setCatno("10");                //12  
				globalDao.setReqStatus("0");              //13  
				globalDao.setNewStatus("10");              //14 
				globalDao.setItemDtl("1");               //15
				globalDao.setAuthNo("0");                //16
				globalDao.setAppId("0");                 //17
				globalDao.setToStore("0"); //18
				globalDao.setInstCode("0");              //19
				globalDao.setInstSlno("0");              //20
				globalDao.setSuppId("0");                //21 
				globalDao.setAppNo("2");                //22 
				globalDao.setModval("1");               //23
											
			     procIndex1 = globalDao.insert1(dao);  //Procedure Name DML_OFFLINE_APPROVAL_DTL
			    
									
	         
			      synchronized(dao)   
				  {
		         	dao.fire();     // Here we Execute the Procedure
		         	retVal = true;
				  }
			      			      
				  		      
			      if(retVal)
			      {	  
			    	  //retVal = InsertNewIndentApprovalItemTable(vo,strAppNo,"40","10",strIndentNo);   // DML_OFFLINE_APPROVALITEM_DTL
			      }
			      if (vo.getStrMsgType().equals("1")) 
				  {
						
						throw new Exception(vo.getStrMsgString());
				  }
		      		    
		    	  
	     	}
			catch (Exception e) 
    	    {
				retVal = true;
    		e.printStackTrace();
			vo.setStrMsgString("-->IndentApprovalDeskDAO.InsertNewIndentApproval()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} 
    	finally 
    	{
			if (dao != null)
				dao.free();
			dao = null;
		}
    	return retVal;

	}
	
	/**
	 * INSERT method is used to insert data in following table
	 * SSTT_APPROVALREQ_DTL,SSTT_INDENT_DTL,HSTT_AGENDA_DTL
	 * HSTT_APPROVAL_DTL
	 * @param vo
	 * @param itemDetail
	 * @param appNo
	 * @param status
	 * @param lstStatus  
	 */
	
	public static boolean InsertNewIndentApprovalItemTable(OfflineIssueIndentTransVO vo,String appNo,String status,String lstStatus,String strIndentNo) 
	{
		HisDAO   dao         = null;
		HisUtil  util        = null;
		String[] temp        = null;
		String[] strTemp     = null;
		String[] reqQtyUnit  = null;
		String[] sancQtyUnit = null;
		String   strReqQty   = "";
		String   strReqUnit  = "";
		String   strSancQty  = "";
		String   strSancQtyUnit = "";
		String   strPrevSancQty = "";
		String   strPrevSancQtyUnitId  = "";
		String   strCtDate             = "";
		DmlApprovalItemDtlDAO tableDao = null;
		boolean retVal = false;
		int k =10;
		
		try 
		{
		    /*
			 vo.setStrSeatId(seatid);	
			vo.setStrHospitalCode(hosCode);
			vo.setStrIpAddr(ipAddr);
			vo.setStrReqNo(strReqNo);
			vo.setStrReqTypeId(strReqTypeId);
			vo.setStrStoreId(strStoreId);
			vo.setStrLevelType(strLevelType);
			vo.setStrItemCatgNo(strItemCatg);
			vo.setStrToStoreId(strToStoreId);
			vo.setStrApproved(formBean.getStrApproved());
			vo.setStrRejected(formBean.getStrRejected());
			vo.setStrFinancialEndYear(strFinancialEndYear);
			vo.setStrFinancialStartYear(strFinancialStartYear);
			vo.setStrInsertHiddenValue(formBean.getStrInsertHiddenValue());	
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrInsSancQty(formBean.getStrInsSancQty());
			vo.setStrInsUnitCombo(formBean.getStrInsUnitCombo());
			*/
			
			System.out.println("------------------DAO--InsertNewIndentApprovalItemTable----------------------------");
			
			            util = new HisUtil("MMS","transactions.IndentApprovalDeskDAO.InsertNewIndentApprovalItemTable()");
			       strCtDate = util.getASDate("dd-MMM-yyyy");
			        tableDao = new DmlApprovalItemDtlDAO();
    		             dao = new HisDAO("MMS","transactions.IndentApprovalDeskDAO.InsertNewIndentApprovalItemTable()");
    		 		    		
    		             int length = vo.getItemParamValue().length;

    		 			for (int i = 0; i < length; i++) 
    		 			{                           
    		 				temp = vo.getItemParamValue()[i].replace('#', '#').split("#");
    		 				strTemp = temp[2].replace('^', '#').split("#");
    		 				
//    		 				  //System.out.println("Display Value-->>>>"+temp[0]);
//    		 				  //System.out.println("Conversion  Value-->>>>"+temp[1]);
//    		 				  //System.out.println("User  Value-->>>>"+temp[2]);
//    		 				  //System.out.println("------------------Start--InesertNewIndentItem--PROC SIX----------------------------");
//    		 				  //System.out.println("ItemID-1->>"+strTemp[0]);
//    		 				  //System.out.println("ItemBrandID-2->>"+strTemp[1]);
//    		 				  //System.out.println("GrpID-3->>"+strTemp[2]);
//    		 				  //System.out.println("Sub_GrpID-4->>"+strTemp[3]);
//    		 				  //System.out.println("Cosumble Flg-5->>"+strTemp[4]);
//    		 				  //System.out.println("Re-Order Qty-6->>"+strTemp[5]);
//    		 				  //System.out.println("Re-Order Qty unit Id-7->>"+strTemp[6]);
//    		 				  //System.out.println("In Hand Qty-8->>"+strTemp[7]);
//    		 				  //System.out.println("In Hand Qty Unit Id-9->>"+strTemp[8]);
//    		 				  //System.out.println("Last Rate-10->>"+strTemp[9]);
//    		 				  //System.out.println("Last Rate Unit Id-11->>"+strTemp[10]);
//    		 				  
//    		 				  
//    		 				  //System.out.println("Inventory Unit Id-12->>"+strTemp[11]);
//    		 				  //System.out.println("Last PO No-13->>"+strTemp[12]);
//    		 				  //System.out.println("Last PO Date-14->>"+strTemp[13]);
//    		 				  System.out .println("Last Supplied By [Id]-15->>"+strTemp[14]);
//    		 				  //System.out.println("Batch No-16->>"+strTemp[15]);
//    		 				  //System.out.println("Expiry Date-17->>"+strTemp[16]);
//    		 				  //System.out.println("Manufacture Date-18->>"+strTemp[17]);
//    		 				  //System.out.println("Item Serial No-19->>"+strTemp[18]);
//    		 				  //System.out.println("Last Received Qty [PO]-20->>"+strTemp[19]);
//    		 				  //System.out.println("Last Received Qty Unit Id [PO]-21->>"+strTemp[20]);
//    		 				  
//    		 				  //System.out.println("Last Indented Qty-22->>"+strTemp[21]);
//    		 				  //System.out.println("Last Indented Qty Unit Id-23->>"+strTemp[22]);
//    		 				  //System.out.println("Last Received Qty-24->>"+strTemp[23]);
//    		 				  //System.out.println("Last Received Qty Unit Id-25->>"+strTemp[24]);
//    		 				  //System.out.println("Last Year Consumption Qty-26->>"+strTemp[25]);
//    		 				  //System.out.println("Last Year Consumption Qty Unit Id-27->>"+strTemp[26]); 
//    		 				  //System.out.println("Prefix-28->>"+strTemp[27]);
//    		 				  //System.out.println("Cost Parameter-29->>"+strTemp[28]);
//    		 				  //System.out.println( "Cost Unit [on individual item or on total cost]-30->>"+strTemp[29]);
//    		 				  //System.out.println("Purchase Lead Time-31->>"+strTemp[30]);
//    		 				  //System.out.println("Purchase Lead Time Unit-32->>"+strTemp[31]); 
//    		 				  //System.out.println("Stock Status-33->>"+strTemp[32]);
//    		 				  //System.out.println("indent No-in LP DEPT .->>>"+strIndentNo);
//    		 				  //System.out.println("Store ID LP DEEPT.....--->>>"+vo.getStrStoreId());
//    		 				  //System.out.println("------------------End--InesertNewIndentItem--PROC SIX--------------------------");
    		 				 
    		 				 strReqQty = vo.getStrReqQty()[i];

    		 				strReqUnit = strTemp[8];

    		 				
    		 					strSancQty = strReqQty;
    		 					strSancQtyUnit = strTemp[8];
    		 				
				  	
				  	tableDao.setStrRemarks("NA");
				  	tableDao.setLstStatus(status);
					tableDao.setPrevSancQty("0"); // Check
					tableDao.setPrevSancQtyUnitId("0"); // Check
				    tableDao.setStrId(vo.getStrIssuingStoreId());
				    tableDao.setToStrId(vo.getStrRaisingStoreId());
				    tableDao.setReqNo(strIndentNo); 
				 	tableDao.setReqTypeId("31");
				 	tableDao.setCatNo("10");
				 	
				 	tableDao.setItemId(strTemp[0]);
				 	tableDao.setItemBrandId(strTemp[1]);
				 	
				 	tableDao.setBatchNo("0");
					tableDao.setItemSlNo("0");
					tableDao.setStkStatus("0");			
				 		
				 	tableDao.setExpiryDate(strCtDate);
				 	tableDao.setReqQty(strReqQty);
				 	tableDao.setReqQtyUnitId(strTemp[8]);
				 	tableDao.setSancQty(strReqQty);   
				 	tableDao.setSancQtyUnitId(strTemp[8]);
				 	
				 	tableDao.setReservedFlag("0");
				 		
				  	tableDao.setStatus(status);
				  	tableDao.setLstStatus(lstStatus);
				 	tableDao.setAppNo(appNo);
				 	tableDao.setHosp_code(vo.getStrHospitalCode());
				 	tableDao.setSeatId(vo.getStrSeatId());
				 	////System.out.println("Seat Id::::"+vo.getStrSeatId());
				 	
	                tableDao.insert1(dao);   // DML_APPROVALITEM_DTL Procedure Name
	               	                
	          }
		      synchronized(dao)   
			  {
	        	dao.fire();     // Here we Execute in Batch
	        	 retVal = true;
			  }
		      
		} 
    	catch (Exception e) 
    	{
    		 retVal = false;
    		e.printStackTrace();
    		vo.setStrMsgType("1");
			vo.setStrMsgString("-->IndentApprovalDeskDAO.InsertNewIndentApprovalItemTable()-->"+ e.getMessage());
			
			
		} 
    	finally 
    	{
			if (dao != null)
				dao.free();
			dao = null;
		}
         return  retVal;
	}
	
	/**
	 * This function is used to to populate the value of Unit combo
	 * 
	 * @param vo
	 */
	public static void getUnitCombo(OfflineIssueIndentTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			dao = new HisDAO("mms", "OfflineIssueIndentTransDAO");

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

			vo.setStrMsgString("OfflineIssueIndentTransDAO.getUnitCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
	
	
	
	

	
	

}
