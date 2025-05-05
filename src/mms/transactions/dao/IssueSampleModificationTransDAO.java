package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.IssueSampleModificationTransVO;
import mms.transactions.vo.ThirdPartyIssueReqTransVO;

public class IssueSampleModificationTransDAO 
{
	/**
	 * for getting option value of combo on add page (store type name )
	 * 
	 * @param vo
	 */

	public static void GetData(IssueSampleModificationTransVO vo) 
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
	public static void getIndentDetail(IssueSampleModificationTransVO vo) 
	{

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_indent_dtl(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms",
					"IssueSampleModificationTransDAO.getIndentDetail(IssueSampleModificationTransVO vo)");

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
			vo.setStrMsgString("IssueSampleModificationTransDAO.getIndentDetail() --> "
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
	public static void getItemDetail(IssueSampleModificationTransVO vo) 
	{

		String err = "";
		String proc_name1 = "{call Pkg_Mms_View.proc_indentissue_item_dtls(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms", "IssueSampleModificationTransDAO");

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

			vo.setStrMsgString("IssueSampleModificationTransDAO.getItemDetail() --> "
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
	public static WebRowSet STORENAMECOMBO(IssueSampleModificationTransVO vo)
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

			dao.setProcInValue(nprocIndex, "modeval", vo.getStrMode());
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
	public static void getAvalBudgetDetails(IssueSampleModificationTransVO vo) 
	{
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_hstt_budget_dtl(?,?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

				dao = new HisDAO("MMS Transactions","IssueSampleModificationTransDAO");
						
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
	public static void getPendingDemand(IssueSampleModificationTransVO vo) 
	{
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_pending_demand_dtl(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

				dao = new HisDAO("MMS Transactions","IssueSampleModificationTransDAO");
						
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
	 * for getting Item category Combo by passing STORE_ID & HOSP_CODE
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void itemCategoryCombo(IssueSampleModificationTransVO vo)
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
	
	
	public static void VoucherDetails(IssueSampleModificationTransVO vo) 
	{
	    // Declaring Variables 
		String        err = "";
		int    procIndex1 = 0;
		HisDAO        dao = null;
		WebRowSet      ws = null;
		HisUtil   hisutil = null;
		String        str = null;
		
		try 
		{
			String strProcName = "{call PKG_MMS_VIEW.proc_sample_issue_modify_dtl(?,?,?,?,?,?,?,?,?,?,?)}";//11 var
			dao = new HisDAO("MMS Transactions","ThirdPartyIssueReqTransDAO");
			hisutil = new HisUtil("master", "IssueSampleModificationTransDAO");
			procIndex1 = dao.setProcedure(strProcName);
			   
	        dao.setProcInValue(procIndex1, "modeval", "5");                             //1
			dao.setProcInValue(procIndex1, "storeid", vo.getStrStoreId());            //2
			dao.setProcInValue(procIndex1, "resendFlag", "0");   //3
			dao.setProcInValue(procIndex1, "itemBrandId", "0");                         //4
			dao.setProcInValue(procIndex1, "issueNo", vo.getStrIssueNo());                             //5
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());       //6
			dao.setProcInValue(procIndex1, "stkStatus", "0");       //7
			dao.setProcInValue(procIndex1, "batchNo", "0");       //8
			dao.setProcInValue(procIndex1, "issuedQty", "0");       //9
			dao.setProcOutValue(procIndex1,"err", 1); // 1 for string return            //10
			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object            //11
			
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
			vo.setStrMsgString("IssueSampleModificationTransDAO.getVoucherCombo() --> "
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
	public static void getVoucherCombo(IssueSampleModificationTransVO vo) 
	{
	    // Declaring Variables 
		String        err = "";
		int    procIndex1 = 0;
		HisDAO        dao = null;
		WebRowSet      ws = null;
		HisUtil   hisutil = null;
		String        str = null;
	   
		
		try 
		{
			String strProcName = "{call PKG_MMS_VIEW.proc_sample_issue_modify_dtl(?,?,?,?,?,?,?,?,?,?,?)}";//11 var
			dao = new HisDAO("MMS Transactions","IssueSampleModificationTransDAO");
			hisutil = new HisUtil("master", "IssueSampleModificationTransDAO");
			procIndex1 = dao.setProcedure(strProcName);
			   
			
	        dao.setProcInValue(procIndex1, "modeval", "4");                             //1
			dao.setProcInValue(procIndex1, "storeid", vo.getStrStoreId());            //2
			dao.setProcInValue(procIndex1, "resendFlag", "0");   //3
			dao.setProcInValue(procIndex1, "itemBrandId", "0");                         //4
			dao.setProcInValue(procIndex1, "issueNo", "0");                             //5
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());       //6
			dao.setProcInValue(procIndex1, "stkStatus", "0");       //7
			dao.setProcInValue(procIndex1, "batchNo", "0");       //8
			dao.setProcInValue(procIndex1, "issuedQty", "0");       //9
			dao.setProcOutValue(procIndex1,"err", 1); // 1 for string return            //10
			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object            //11
			
			// execute procedure
			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null) err = "";
			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");
				
				if (ws != null && ws.size() != 0) 
				{
					  str = hisutil.getOptionValue(ws, "", "0^Select Value", true);
					  vo.setStrVoucherCombo(str);
				} 
				else 
				{
					  str = "<option value='0'>Select Value</option>";
					  vo.setStrVoucherCombo(str);
				}
				
			} else {
				throw new Exception(err);
			}

		} catch (Exception e) {
            e.printStackTrace();
			vo.setStrMsgString("IssueSampleModificationTransDAO.getVoucherCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
	public static void getBatchCombo(IssueSampleModificationTransVO vo) 
	{
		
		HisDAO dao = null;
		WebRowSet ws = null;
	
		int procIndex1 = 0;
		String str="";
	
		String strErr = "";
		HisUtil hisutil = null;
	
		try {
			String strProcName = "{call PKG_MMS_VIEW.proc_sample_issue_modify_dtl(?,?,?,?,?,?,?,?,?,?,?)}";//11 var
			dao = new HisDAO("MMS Transactions","ThirdPartyIssueReqTransDAO");
			hisutil = new HisUtil("master", "IssueSampleModificationTransDAO");
			procIndex1 = dao.setProcedure(strProcName);
			   
	        dao.setProcInValue(procIndex1, "modeval", "2");                             //1
			dao.setProcInValue(procIndex1, "storeid", vo.getStrStoreId());            //2
			dao.setProcInValue(procIndex1, "resendFlag", vo.getStrResendFlag());   //3
			dao.setProcInValue(procIndex1, "itemBrandId", vo.getStrItemBrandId());                         //4
			dao.setProcInValue(procIndex1, "issueNo", "0");                             //5
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());       //6
			dao.setProcInValue(procIndex1, "stkStatus", vo.getStrStockStatusCode());       //7
			dao.setProcInValue(procIndex1, "batchNo", vo.getStrBatchNumber());       //8
			dao.setProcInValue(procIndex1, "issuedQty", vo.getStrIssQty());       //9
			dao.setProcOutValue(procIndex1,"err", 1); // 1 for string return            //10
			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object            //11
			
			// execute procedure
			dao.executeProcedure(procIndex1);
			
				strErr = dao.getString(procIndex1, "err");
	
				if (strErr == null)
					strErr = "";
	
				ws = dao.getWebRowSet(procIndex1, "resultset");
	
				if (strErr.equals("")) 
				{
					if(ws!=null)
					{
						vo.setBatchComboWS(ws);
						
						str = hisutil.getOptionValue(ws, vo.getStrBatchNumber(),"", true);
						
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
			vo.setStrMsgString("IssueSampleModificationTransDAO.getBatchCombo() --> "+ e.getMessage());
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
	public static void getUnitCombo(IssueSampleModificationTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			dao = new HisDAO("mms", "IssueSampleModificationTransDAO");

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
			vo.setStrMsgString("IssueSampleModificationTransDAO.getUnitCombo() --> "
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
		public synchronized static void insertRecord(IssueSampleModificationTransVO vo) 
		{

			HisDAO daoObj = null;
			String   strProcName2 = "";
			int       nProcIndex2 = 0;
			try 
			{
				 daoObj = new HisDAO("mms", "IssueSampleModificationTransDAO");			
				 
				 strProcName2 = "{call PKG_MMS_DML.dml_sample_send_modify_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";  //17
				 		
						nProcIndex2 = daoObj.setProcedure(strProcName2);
						daoObj.setProcInValue(nProcIndex2, "modeval", "1");                             //1
						daoObj.setProcInValue(nProcIndex2, "hosp_code", vo.getStrHospitalCode());      //2
						daoObj.setProcInValue(nProcIndex2, "issueNo", vo.getStrIssueNo());          //3
						daoObj.setProcInValue(nProcIndex2, "strId", vo.getStrStoreId()); //4
						daoObj.setProcInValue(nProcIndex2, "brandId",vo.getStrItemBrandId());      //6
						daoObj.setProcInValue(nProcIndex2, "oldBatchNo",vo.getStrOldBatchNo());        //7
						daoObj.setProcInValue(nProcIndex2, "newBatchNo",vo.getStrBatchNo()); //8
						daoObj.setProcInValue(nProcIndex2, "oldIssueQty",vo.getStrOldIssueQty());        //9
						daoObj.setProcInValue(nProcIndex2, "newIssueQty",vo.getStrIssueQty());     //10
						daoObj.setProcInValue(nProcIndex2, "oldStkStatus",vo.getStrOldStockStatus());           //11
						daoObj.setProcInValue(nProcIndex2, "newStkStatus",vo.getStrStockStatusCode());        //12
						daoObj.setProcInValue(nProcIndex2, "oldAvlQty", vo.getStrOldAvlQty());          //13						
						daoObj.setProcInValue(nProcIndex2, "issueDate",vo.getStrIssueDate());                //14
						daoObj.setProcInValue(nProcIndex2, "receiveBy",vo.getStrReceivedBy()); 
						daoObj.setProcInValue(nProcIndex2, "remarks",vo.getStrRemarks());						
						daoObj.setProcInValue(nProcIndex2, "seat_id",vo.getStrSeatId());  		    
					                   
						daoObj.setProcOutValue(nProcIndex2, "err", 1);//12
						
						daoObj.execute(nProcIndex2, 1);
						daoObj.fire();       
				
			} catch (Exception e)
			{
				e.printStackTrace();
				vo.setStrMsgString("--> IssueSampleModificationTransDAO.insertQuery()-->"+ e.getMessage());
				vo.setStrMsgType("1");
			} finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			
			}

		}

		
	
		
	
		
			
}
