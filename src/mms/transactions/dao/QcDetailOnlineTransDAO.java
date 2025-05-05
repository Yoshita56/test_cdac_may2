package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.dao.DmlApprovalDtlDAO;
import mms.dao.DmlApprovalItemDtlDAO;
import mms.dao.DmlHsttIndentItemDtlDAO;
import mms.dao.DmlIndentDtlDAO;
import mms.transactions.vo.PODeskGenerateTransVO;
import mms.transactions.vo.QcDetailOnlineTransVO;
/**
 * Developer : Vivek Aggarwal
 * Version : 1.0
 * Date : 16/Sep/2010
 * Modify:  
*/
public class QcDetailOnlineTransDAO 
{
	/**
	 * for getting option value of combo on add page (store type name )
	 * 
	 * @param qcDetailOnlineTransVO_p
	 */

	public static void GetData(QcDetailOnlineTransVO qcDetailOnlineTransVO_p) 
	{
		/* Declaring Variable */
		HisDAO dao = null;
		WebRowSet wb = null;
		String str1 = null;
		HisUtil hisutil = null;
    	try 
		{
			
    		hisutil = new HisUtil("MMS", "QcDetailOnlineTransDAO");
			wb      = STORENAMECOMBO(qcDetailOnlineTransVO_p);
			if(wb.next())
			{
				qcDetailOnlineTransVO_p.setStrStoreId(wb.getString(1));
			}
			wb.beforeFirst();
			if(wb!= null)
			{	
			   str1 = hisutil.getOptionValue(wb, qcDetailOnlineTransVO_p.getStrStoreId(),"0^Select Value", true);
			   qcDetailOnlineTransVO_p.setStrStoreName(str1);
			}
			 else
            {
               str1 = "<option value='0'>DATA N/A</option>";   
               qcDetailOnlineTransVO_p.setStrStoreName(str1);
            }
			
		
		} 
    	catch (Exception e) 
    	{
			
    		qcDetailOnlineTransVO_p.setStrMsgString("--> QcDetailOnlineTransDAO.GetData()-->"
					+ e.getMessage());
			qcDetailOnlineTransVO_p.setStrMsgType("1");
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
	 * @param qcDetailOnlineTransVO_p
	 */
	public static void getLabNameCombo(QcDetailOnlineTransVO qcDetailOnlineTransVO_p) 
	{

		String strErr;
		String proc_name1 = "{call pkg_mms_view.proc_Lab_Name_Combo(?,?,?,?,?,  ?,?,?,?,?,  ?)}";	// Total Values 11

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms",
					"QcDetailOnlineTransDAO.getIndentDetail(QcDetailOnlineTransVO qcDetailOnlineTransVO_p)");

			procIndex1 = dao.setProcedure(proc_name1);
           		
			
			// set value
			dao.setProcInValue(procIndex1, "p_mode", "1");
			dao.setProcInValue(procIndex1, "p_hstnum_item_id", "0");
			dao.setProcInValue(procIndex1, "p_hstnum_store_id", qcDetailOnlineTransVO_p.getStrStoreId());
			dao.setProcInValue(procIndex1, "p_gnum_hospital_code", qcDetailOnlineTransVO_p.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "p_sstnum_item_cat_no", "10"); // Default Value.
			dao.setProcInValue(procIndex1, "p_hstnum_lab_send_no", "0");
			dao.setProcInValue(procIndex1, "p_hstnum_itembrand_id", "0");
			dao.setProcInValue(procIndex1, "p_hststr_batch_sl_no", "0");
			dao.setProcInValue(procIndex1, "p_gnum_seatid", qcDetailOnlineTransVO_p.getStrSeatId());
			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return value
			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value
			strErr = dao.getString(procIndex1, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) 
			{

				ws = dao.getWebRowSet(procIndex1, "resultset");

				qcDetailOnlineTransVO_p.setStrWrsLabName(ws);
							
			} 
			else {
				throw new Exception(strErr);
			}
			
			
			
		} 
		catch (Exception e)
		{
            e.printStackTrace();
			qcDetailOnlineTransVO_p.setStrMsgString("QcDetailOnlineTransDAO.getIndentDetail() --> "
					+ e.getMessage());
			qcDetailOnlineTransVO_p.setStrMsgType("1");

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
	 * @param qcDetailOnlineTransVO_p
	 */
	public static void getItemDetail(QcDetailOnlineTransVO qcDetailOnlineTransVO_p) 
	{

		String err = "";
		String proc_name1 = "{call Pkg_Mms_View.proc_indentissue_item_dtls(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms", "QcDetailOnlineTransDAO");

			procIndex1 = dao.setProcedure(proc_name1);
            
			////System.out.println("frmstoreid:::"+qcDetailOnlineTransVO_p.getStrRaisingStoreId());
			////System.out.println("Issue Store::::"+qcDetailOnlineTransVO_p.getStrIssueStoreId());
				
			// set value
			dao.setProcInValue(procIndex1, "modeval", "1");
			dao.setProcInValue(procIndex1, "hosp_code", qcDetailOnlineTransVO_p.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "indentno", qcDetailOnlineTransVO_p.getStrIndentNo());
			dao.setProcInValue(procIndex1, "frmstoreid", qcDetailOnlineTransVO_p.getStrRaisingStoreId());
			dao.setProcInValue(procIndex1, "issuingStoreid", qcDetailOnlineTransVO_p.getStrIssueStoreId());
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

				qcDetailOnlineTransVO_p.setItemDetailsWS(ws);
				
			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			qcDetailOnlineTransVO_p.setStrMsgString("QcDetailOnlineTransDAO.getItemDetail() --> "
					+ e.getMessage());
			qcDetailOnlineTransVO_p.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
	
	/**
	 * STORENAMECOMBO(qcDetailOnlineTransVO_p) -- >
     * This Method is Used to get WebRowSet for Store Name  Combo 
     * from Table 
     */
	public static WebRowSet STORENAMECOMBO(QcDetailOnlineTransVO qcDetailOnlineTransVO_p)
	{
		String proc_name = "";

		proc_name = "{call PKG_MMS_VIEW.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		
		HisDAO dao = null;
			
		int nprocIndex = 0;

		String strerr = "";

		WebRowSet ws = null;

		try {

			dao = new HisDAO("MMS",
					"transactions.QcDetailOnlineTransDAO.STORENAMECOMBO(VO)");

			nprocIndex = dao.setProcedure(proc_name);

			// set value

			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "seatid", qcDetailOnlineTransVO_p.getStrSeatId());
			dao.setProcInValue(nprocIndex, "hosp_code", qcDetailOnlineTransVO_p.getStrHospitalCode());
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
				qcDetailOnlineTransVO_p.setStrMsgType("0");
			} else {
				throw new Exception(strerr);
			}

		}

		catch (Exception e)
		{		
            e.printStackTrace();
			qcDetailOnlineTransVO_p.setStrMsgString("-->QcDetailOnlineTransDAO.STORENAMECOMBO()"+ e.getMessage());

			qcDetailOnlineTransVO_p.setStrMsgType("1");

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
	public static void getAvalBudgetDetails(QcDetailOnlineTransVO qcDetailOnlineTransVO_p) 
	{
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_hstt_budget_dtl(?,?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

				dao = new HisDAO("MMS Transactions","QcDetailOnlineTransDAO");
						
				procIndex1 = dao.setProcedure(proc_name1);
				
				dao.setProcInValue(procIndex1, "p_mode", "4");
				// set value
				
				dao.setProcInValue(procIndex1, "p_hstnum_store_id", qcDetailOnlineTransVO_p.getStrIndentingStoreID());
				dao.setProcInValue(procIndex1, "p_hstdt_finstart_date", qcDetailOnlineTransVO_p.getStrFinancialStartDate());
				dao.setProcInValue(procIndex1, "p_hstdt_finend_date", qcDetailOnlineTransVO_p.getStrFinancialEndDate());
				dao.setProcInValue(procIndex1, "p_gnum_hospital_code", qcDetailOnlineTransVO_p.getStrHospitalCode());
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
					qcDetailOnlineTransVO_p.setStrAvalaibleBudget(ws.getString(1));
					qcDetailOnlineTransVO_p.setStrAvalaibleBudgetDtl(ws.getString(2)+"$$"+ws.getString(3));
				}

		} catch (Exception e) {
			e.printStackTrace();
			qcDetailOnlineTransVO_p.setStrMsgString("IssueTransDAO.getAvalBudgetDetails() --> "	+ e.getMessage());
			qcDetailOnlineTransVO_p.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
		
	}
	
	
	
	/**
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getSampleSentDtl(QcDetailOnlineTransVO vo)
	{
		String strProcName = "{call pkg_mms_view.Proc_SampleSent_Detail(?,?,?,?,?,?,?,?,?)}"; //9
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("QC Details OnLine","SampleSentTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
				
			
			daoObj.setProcInValue(nProcIndex, "p_mode", vo.getStrMode());
			daoObj.setProcInValue(nProcIndex, "p_hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_strId", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "p_catgNo", vo.getStrItemCategoryNo());
			daoObj.setProcInValue(nProcIndex, "p_frmdate", "0");
			daoObj.setProcInValue(nProcIndex, "p_todate", "0");
			daoObj.setProcInValue(nProcIndex, "p_labNo", vo.getStrLabId());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
					
				  vo.setWsLabSentHlp(ws);
				 
			} 
			else 
			{
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("SampleSentTransDAO.getSampleSentDtl() --> "	+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	
	/**
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getSampleSentDtl_withSearch(QcDetailOnlineTransVO vo)
	{
		String strProcName = "{call pkg_mms_view.Proc_SampleSent_Search_Detail(?,?,?,?,?,?,?,?,?)}"; //9
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try
		{
			daoObj=new HisDAO("QC Details On-Line","SampleSentTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
				
			
			daoObj.setProcInValue(nProcIndex, "p_mode", vo.getStrMode());
			daoObj.setProcInValue(nProcIndex, "p_catgNo", vo.getStrItemCategoryNo());
			daoObj.setProcInValue(nProcIndex, "p_strId", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "p_hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_type",vo.getStrSearchType());
			daoObj.setProcInValue(nProcIndex, "p_searchString", vo.getStrSearchString());
			daoObj.setProcInValue(nProcIndex, "p_labNo", vo.getStrLabId());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			////System.out.println("Size is::::==>"+ws.size());
			if (strErr.equals("")) 
			{
					
				  vo.setWsLabSentHlp(ws);
				 
			} 
			else 
			{
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			vo.setStrMsgString("SampleSentTransDAO.getSampleSentDtl_withSearch() --> "	+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	

	
		
	/**
	 * for getting Item category Combo by passing STORE_ID & HOSP_CODE
	 * 
	 * @param qcDetailOnlineTransVO_p
	 * @throws Exception
	 */
	public static void itemCategoryCombo(QcDetailOnlineTransVO qcDetailOnlineTransVO_p)
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
			   hisutil = new HisUtil("MMS", "QcDetailOnlineTransDAO");
			   daoObj  = new HisDAO("MMS","QcDetailOnlineTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			// Set Values
			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			////System.out.println("Store ID==>"+qcDetailOnlineTransVO_p.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "store_id", qcDetailOnlineTransVO_p.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", qcDetailOnlineTransVO_p.getStrHospitalCode());
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
			if(ws!=null && ws.size()>0)
			{
				if(ws.next())
				{
					qcDetailOnlineTransVO_p.setStrItemCategoryNo(ws.getString(1));
				}
				ws.beforeFirst();	
			}
			else
			{
				qcDetailOnlineTransVO_p.setStrItemCategoryNo("10");
			}
						
			if (strErr.equals("")) 
			{
				if(ws!=null && ws.size()>0)
				{					
                    str = hisutil.getOptionValue(ws, qcDetailOnlineTransVO_p.getStrItemCategoryNo(),"0^Select Value", true);
					qcDetailOnlineTransVO_p.setStrItemCategoryCmb(str);		
					qcDetailOnlineTransVO_p.setStrMsgType("0");
				}
				
				else
				{
					qcDetailOnlineTransVO_p.setStrItemCategoryNo("10");
					str = "<option value='0'>Select Value</option>";  
					qcDetailOnlineTransVO_p.setStrItemCategoryCmb(str);
					qcDetailOnlineTransVO_p.setStrMsgType("0");
				}			
				
				
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			qcDetailOnlineTransVO_p.setStrMsgString("QcDetailOnlineTransDAO.itemCategoryCombo() --> "
					+ e.getMessage());
			qcDetailOnlineTransVO_p.setStrMsgType("1");
		}
	}
	
	
	
	/**
	 * for getting Item category Combo by passing STORE_ID & HOSP_CODE
	 * 
	 * @param qcDetailOnlineTransVO_p
	 * @throws Exception
	 */
	public static void itemCategoryCombo1(QcDetailOnlineTransVO qcDetailOnlineTransVO_p)
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
			   hisutil = new HisUtil("MMS", "QcDetailOnlineTransDAO");
			   daoObj  = new HisDAO("MMS","QcDetailOnlineTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			// Set Values
			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			////System.out.println("Store ID==>"+qcDetailOnlineTransVO_p.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "store_id", qcDetailOnlineTransVO_p.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", qcDetailOnlineTransVO_p.getStrHospitalCode());
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
			if(ws!=null && ws.size()>0)
			{
				if(ws.next())
				{
					qcDetailOnlineTransVO_p.setStrItemCategoryNo(ws.getString(1));
				}
				ws.beforeFirst();	
			}
			else
			{
				qcDetailOnlineTransVO_p.setStrItemCategoryNo("10");
			}
						
			if (strErr.equals("")) 
			{
				if(ws!=null && ws.size()>0)
				{					
                    str = hisutil.getOptionValue(ws, qcDetailOnlineTransVO_p.getStrItemCategoryNo(),"0^Select Value", true);
					qcDetailOnlineTransVO_p.setStrItemCategoryCmb(str);		
					qcDetailOnlineTransVO_p.setStrMsgType("0");
				}
				
				else
				{
					qcDetailOnlineTransVO_p.setStrItemCategoryNo("10");
					str = "<option value='0'>Select Value</option>";  
					qcDetailOnlineTransVO_p.setStrItemCategoryCmb(str);
					qcDetailOnlineTransVO_p.setStrMsgType("0");
				}			
				
				
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			qcDetailOnlineTransVO_p.setStrMsgString("QcDetailOnlineTransDAO.itemCategoryCombo() --> "
					+ e.getMessage());
			qcDetailOnlineTransVO_p.setStrMsgType("1");
		}
	}
	
	/**
	 * Method for getting option value of Indenting Store combo on add page (store type name )
	 * 
	 * @param qcDetailOnlineTransVO_p
	 */
	public static void 	getHQNameStoreCombo(QcDetailOnlineTransVO qcDetailOnlineTransVO_p) 
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
			  hisutil = new HisUtil("master", "QcDetailOnlineTransDAO");
			      dao = new HisDAO("MMS","QcDetailOnlineTransDAO.GetDeptCombo(QcDetailOnlineTransVO qcDetailOnlineTransVO_p)");
  		   procIndex1 = dao.setProcedure(proc_name1);
			// set value
	            dao.setProcInValue(procIndex1, "modeval", "2");
				dao.setProcInValue(procIndex1, "hosp_code", qcDetailOnlineTransVO_p	.getStrHospitalCode());
  				dao.setProcInValue(procIndex1, "storeid", qcDetailOnlineTransVO_p.getStrStoreId());
  				dao.setProcInValue(procIndex1, "reqType", "72");
				dao.setProcInValue(procIndex1, "catCode", qcDetailOnlineTransVO_p.getStrIndentingStoreID());
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
				qcDetailOnlineTransVO_p.setStrIndentStoreCombo(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				qcDetailOnlineTransVO_p.setStrIndentStoreCombo(str);
			}

		} catch (Exception e) {
			e.printStackTrace();
			qcDetailOnlineTransVO_p.setStrMsgString("QcDetailOnlineTransDAO.ToStoreCombo() --> "
					+ e.getMessage());
			qcDetailOnlineTransVO_p.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	
	
	/**
	 * This function is used to set details in approved By Combo. 
	 * @param _QcDetailOnlineTransVO
	 */
	public static void getApprovedByCombo(QcDetailOnlineTransVO offlineIssueIndent_VO)
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
			   hisutil = new HisUtil("master", "QcDetailOnlineTransDAO");
			   daoObj  = new HisDAO("MMS","QcDetailOnlineTransDAO");
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
			offlineIssueIndent_VO.setStrMsgString("QcDetailOnlineTransDAO.getApprovedByCombo() --> "
					+ _err.getMessage());
			offlineIssueIndent_VO.setStrMsgType("1");
		}
	}
	
	/**
	 * This function is used to get details Verify By Combo. 
	 * @param _QcDetailOnlineTransVO
	 */
	public static void getVerifyByCombo(QcDetailOnlineTransVO _QcDetailOnlineTransVO)
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
		   	   hisutil = new HisUtil("master", "QcDetailOnlineTransDAO");
			    daoObj = new HisDAO("MMS","QcDetailOnlineTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			// Set Value
			daoObj.setProcInValue(nProcIndex, "modeVal", "1");
			daoObj.setProcInValue(nProcIndex, "storeId", _QcDetailOnlineTransVO.getStrIndentingStoreID());
			daoObj.setProcInValue(nProcIndex, "hosp_code", _QcDetailOnlineTransVO.getStrHospitalCode());
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
				_QcDetailOnlineTransVO.setStrVerifiedByValues(str);
			} 
			else 
			{
				  str = "<option value='0'>DATA N/A</option>";
				  _QcDetailOnlineTransVO.setStrVerifiedByValues(str);
			}
			
			
		}
		catch(Exception _err)
		{
			_QcDetailOnlineTransVO.setStrMsgString("QcDetailOnlineTransDAO.getApprovedByCombo() --> "
					+ _err.getMessage());
			_QcDetailOnlineTransVO.setStrMsgType("1");
		}
	}
	
	/**
	 * This function is used to GET THE Issue No WISE ITEM DETAILS FOR POPUP
	 * 
	 * @param qcDetailOnlineTransVO_p
	 */
	public static void getPopUpInfoProc(QcDetailOnlineTransVO qcDetailOnlineTransVO_p) 
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
			        dao = new HisDAO("MMS", "QcDetailOnlineTransDAO");
			strProcName = "{call Pkg_Mms_View.PROC_ISSUE_ITEM_DETAIL(?,?,?,?,?,?)}";
			 nProcIndex = dao.setProcedure(strProcName);
			// Set Values 
			dao.setProcInValue(nProcIndex,  "MODEVAL", "1");
		    dao.setProcInValue(nProcIndex,  "ISSUENO", qcDetailOnlineTransVO_p.getStrIssueNo());
			dao.setProcInValue(nProcIndex,  "STRID", qcDetailOnlineTransVO_p.getStrStoreName());
			dao.setProcInValue(nProcIndex,  "HOSP_CODE", qcDetailOnlineTransVO_p.getStrHospitalCode());
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

				qcDetailOnlineTransVO_p.setPopUpWS(ws);

			} 
			else 
			{
				throw new Exception(strErr);
			}

		}
		catch (Exception e) 
		{
			qcDetailOnlineTransVO_p.setStrMsgString("QcDetailOnlineTransDAO.getPopUpInfoProc() --> "	+ e.getMessage());
			qcDetailOnlineTransVO_p.setStrMsgType("1");

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
	 * @param qcDetailOnlineTransVO_p
	 */
	public static void getIssueDetail(QcDetailOnlineTransVO qcDetailOnlineTransVO_p) 
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
			       dao = new HisDAO("MMS",	"QcDetailOnlineTransDAO.getIssueDetail(QcDetailOnlineTransVO qcDetailOnlineTransVO_p)");
			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", "1");                  //1
			dao.setProcInValue(procIndex1, "storeid", qcDetailOnlineTransVO_p.getStrStoreName());//2
			dao.setProcInValue(procIndex1, "itemCatg", qcDetailOnlineTransVO_p.getStrItemCategoryCmb());//3
			dao.setProcInValue(procIndex1, "from_date", qcDetailOnlineTransVO_p.getStrFromDate());//4
			dao.setProcInValue(procIndex1, "too_date", qcDetailOnlineTransVO_p.getStrToDate());//5
			dao.setProcInValue(procIndex1, "hosp_code", qcDetailOnlineTransVO_p.getStrHospitalCode()); //6
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
				qcDetailOnlineTransVO_p.setIssueNoDtlWs(ws);
				
			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {
            e.printStackTrace();
			qcDetailOnlineTransVO_p.setStrMsgString("QcDetailOnlineTransDAO.getIssueDetail() --> "
					+ e.getMessage());
			qcDetailOnlineTransVO_p.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
	/**
	 * 
	 * @param qcDetailOnlineTransVO_pObj
	 */
	public static void getViewQcOnlineDetail(QcDetailOnlineTransVO qcDetailOnlineTransVO_p) 
	{
		
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Get_Hstt_Qc_Dtl(?,?,?,?,?,  ?,?,?,?)}"; // Total 8
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","QcDetailOnlineTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			              	      
			daoObj.setProcInValue(nProcIndex, "p_mode", "1");
			daoObj.setProcInValue(nProcIndex, "p_itemCatNo", qcDetailOnlineTransVO_p.getStrItemCategoryCmb());
			daoObj.setProcInValue(nProcIndex, "p_strId", qcDetailOnlineTransVO_p.getStrStoreName());
			daoObj.setProcInValue(nProcIndex, "p_hosp_code", qcDetailOnlineTransVO_p.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_fromdate", qcDetailOnlineTransVO_p.getStrFromDate());
			daoObj.setProcInValue(nProcIndex, "p_todate", qcDetailOnlineTransVO_p.getStrToDate());
			daoObj.setProcInValue(nProcIndex, "p_labNo", qcDetailOnlineTransVO_p.getStrLabId());
			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				qcDetailOnlineTransVO_p.setWrsViewIssueSampleDetail(ws);
				
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			
			qcDetailOnlineTransVO_p.setStrMsgString("QcDetailOnlineTransDAO.getViewQcOnlineDetail() --> "+ e.getMessage());
			qcDetailOnlineTransVO_p.setStrMsgType("1");
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
	
	
	public synchronized static void insertIssueSampleForQcCheck(QcDetailOnlineTransVO vo) //To be used
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
			                   dao = new HisDAO("MMS Transactions","QcDetailOnlineTransDAO");
								
			        
			        
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
			    
			vo.setStrMsgString("--> QcDetailOnlineTransDAO.insertIssueSampleForQcCheck()-->" + e.getMessage());
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
	 * This method is used to insert data into Table'
	 * 
	 * @param vo
	 */

	public static boolean CreateNewOffLineIndent(QcDetailOnlineTransVO vo) 
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
			dao = new HisDAO("MMS", "transactions.QcDetailOnlineTransDAO.CreateNewOffLineIndent()");
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
					 retVal = QcDetailOnlineTransDAO.InsertNewIndentApprovalRaisingStore(vo, indentNo);
					 if(retVal)
					 {
						 retVal = QcDetailOnlineTransDAO.InsertNewIndentApprovalIssuingStore(vo, indentNo);
					 }
				 }
			 } 
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			retVal = false;
			vo.setStrMsgString("--> QcDetailOnlineTransDAO.CreateNewOffLineIndent()-->"
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
  
	public static boolean InesertNewIndentItem(QcDetailOnlineTransVO vo, String indentNo,String approvalFlg)
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

			dao = new HisDAO("MMS", "transactions.QcDetailOnlineTransDAO.InesertNewIndentItem()");
			int length = vo.getItemParamValue().length;

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

	public static boolean InsertNewIndentApprovalRaisingStore(QcDetailOnlineTransVO vo,String strIndentNo) 
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
			    	  //(QcDetailOnlineTransVO vo,String appNo,String status,String lstStatus,String strIndentNo) 
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

	public static boolean InsertNewIndentApprovalIssuingStore(QcDetailOnlineTransVO vo,String strIndentNo) 
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
	
	public static boolean InsertNewIndentApprovalItemTable(QcDetailOnlineTransVO vo,String appNo,String status,String lstStatus,String strIndentNo) 
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
	public static void getUnitCombo(QcDetailOnlineTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			dao = new HisDAO("mms", "QcDetailOnlineTransDAO");

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

			vo.setStrMsgString("QcDetailOnlineTransDAO.getUnitCombo() --> "
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
	 * Created by Adil Wasi
	 * Date: 24-Jan-2011
	 * Used to get Current Stock Status Detail
	 */
	
	public static void getDrugCurrStockDtl(QcDetailOnlineTransVO voObj) 
	{
		
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_drug_currstock_view(?,?,?,  ?,?,?,  ?,?,?)}";	//9 variables
		String[] str =voObj.getStrCheckHiddenValues().replace("^","#").split("#");
		
		String strTmp;
		
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			daoObj = new HisDAO("MMS Transactions","getDrugCurrStockDtl");
			/* Value in strCheckHiddenValues
			 * :10000069^06-Jan-2012^Ajmer_Dwh^Ibuprofen Tablets IP 400 mg (Coated) [24]^Ibuprofen Tablets IP 400 mg (Coated) [24.24]^IBBT28-16^30-Sep-2014^1 No.^99901100^10000069^10100069^.32 No.^1^1^6301^1^/^0^10^73100020120001^Quality Check Lab^CTR001^0.32^324^26-Sep-2011^01-Oct-2011^No^1000^Ms Unicure India Pvt Ltd^Passed^/^999
			 */
		    /*
				      			   
			    
			   
			    	1- Item Id
					2- Lab Sent Date
					3- Sent Store Name
					4- Generic Name
					5-Brand Name
					6- Batch
					7-Exp Date
					8-Transfer Qty
					9-Store Id Sent
					10-Item Id
					11-Item Brand ID
					12-Rate With Unit
					13-Rate Base value
					14-Consumed Qty
					15=Consumed Qty Wit Unit
					16-Qty Base Value
					17-Item Sl No
					18-Item Sl No
					19-Catg Code
					20- Lab Send No
					21-Lab Name
					22-CTR Number
					23-Net Cost
					24-PO No
					25-PO Date
					26-Mfd Date
					27-Is Send Decode Value
                    28 Lab No
                    29 Manufacter By
                    30. ITEM_STATUS
                    31. REPORT_DATE
                    32. GNUM_HOSPITAL_CODE
                    
                    33.	HSTNUM_STOCK_STATUS_CODE
                    34.	HSTNUM_INHAND_QTY, 
                    35.	HSTNUM_INHAND_QTY_UNITID, 
                    36.	HSTNUM_SUPPLIER_ID, 
                    37.	HSTNUM_MANUFACTURER_ID, 
                    38.	HSTSTR_SAMPLE_CODE_NO, 
                    39.	HSTSTR_CTR_NO, 
                    40.	GSTR_SEND_REAMRKS
					   			
              */
		  
		 
			nProcIndex = daoObj.setProcedure(strProcName);
			//System.out.println("Inside Current Stock for Record");
			//System.out.println( "item_id"+ str[9]);
			//System.out.println( "itembrand_id"+ str[10]);
			//System.out.println( "batch_no"+ str[5]);
			//System.out.println( "stockStatus"+str[32]);
			//System.out.println( "hosp_code"+ voObj.getStrHospitalCode());
			
			daoObj.setProcInValue(nProcIndex, "modval", "2");
			daoObj.setProcInValue(nProcIndex, "store_id", voObj.getStrStoreName());
			daoObj.setProcInValue(nProcIndex, "item_id", str[9]);
			daoObj.setProcInValue(nProcIndex, "itembrand_id", str[10]);
			daoObj.setProcInValue(nProcIndex, "batch_no", str[5]);
			daoObj.setProcInValue(nProcIndex, "stockStatus",str[32]);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);
			
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				//strCurrStockStatusDtl = new String[ws.size()]; 
				//System.out.println("WRS SIZE :"+ws.size());
				if(ws != null){
					while(ws.next()){
//						//System.out.println("ws.getString(1):::::::::"+ws.getString(1));
//						//System.out.println("ws.getString(2):::::::::"+ws.getString(2));
//						//System.out.println("ws.getString(3):::::::::"+ws.getString(3));
//						//System.out.println("ws.getString(4):::::::::"+ws.getString(4));
//						//System.out.println("ws.getString(5):::::::::"+ws.getString(5));
//						//System.out.println("ws.getString(6):::::::::"+ws.getString(6));
//						//System.out.println("ws.getString(7):::::::::"+ws.getString(7));
//						//System.out.println("ws.getString(8):::::::::"+ws.getString(8));
//						//System.out.println("ws.getString(9):::::::::"+ws.getString(9));
//						//System.out.println("ws.getString(10):::::::::"+ws.getString(10));
//						//System.out.println("ws.getString(11):::::::::"+ws.getString(11));
//						//System.out.println("ws.getString(12):::::::::"+ws.getString(12));
//						//System.out.println("ws.getString(13):::::::::"+ws.getString(13));
//						//System.out.println("ws.getString(14):::::::::"+ws.getString(14));
//						//System.out.println("ws.getString(15):::::::::"+ws.getString(15));
//						//System.out.println("ws.getString(16):::::::::"+ws.getString(16));
//						//System.out.println("ws.getString(17):::::::::"+ws.getString(17));
//						//System.out.println("ws.getString(18):::::::::"+ws.getString(18));
//						//System.out.println("ws.getString(19):::::::::"+ws.getString(19));
//						//System.out.println("ws.getString(20):::::::::"+ws.getString(20));
//						//System.out.println("ws.getString(21):::::::::"+ws.getString(21));
//						//System.out.println("ws.getString(22):::::::::"+ws.getString(22));
//						//System.out.println("ws.getString(23):::::::::"+ws.getString(23));
//						//System.out.println("ws.getString(24):::::::::"+ws.getString(24));
//						//System.out.println("ws.getString(25):::::::::"+ws.getString(25));
//						//System.out.println("ws.getString(26):::::::::"+ws.getString(26));
//						//System.out.println("ws.getString(27):::::::::"+ws.getString(27));
//						//System.out.println("ws.getString(28):::::::::"+ws.getString(28));
//						//System.out.println("ws.getString(29):::::::::"+ws.getString(29));
//						//System.out.println("ws.getString(30):::::::::"+ws.getString(30));
//						//System.out.println("ws.getString(31):::::::::"+ws.getString(31));
//						//System.out.println("ws.getString(32):::::::::"+ws.getString(32));

						
						strTmp=ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+
								ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+
								ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)+"^"+
								ws.getString(10)+"^"+ws.getString(11)+"^"+ws.getString(12)+"^"+
								ws.getString(13)+"^"+ws.getString(14)+"^"+ws.getString(15)+"^"+
								ws.getString(16)+"^"+ws.getString(17)+"^"+ws.getString(18)+"^"+
								ws.getString(19)+"^"+ws.getString(20)+"^"+ws.getString(21)+"^"+
								ws.getString(22)+"^"+ws.getString(23)+"^"+ws.getString(24)+"^"+
								ws.getString(25)+"^"+ws.getString(26)+"^"+ws.getString(27)+"^"+
								ws.getString(28)+"^"+ws.getString(29)+"^"+ws.getString(30)+"^"+
								ws.getString(31)+"^"+ws.getString(32);
						//strTmp=strTmp+"^"+str[16]+"^"+str[6]+"^"+str[28]+"^"+str[7]+"^"+str[3]+"^"+str[8]+"^"+str[5]+"^"+str[29]+"^"+str[9]+"^"+str[22]+"^"+str[26]+"^"+str[25]+"^"+str[27]+"^"+str[30];
						voObj.setStrCurrentStockDetail(strTmp);
						
					}
				}
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("QcDetailOnlineTransDAO.getDrugCurrStockDtl() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");
			e.printStackTrace();

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
			
			
			
			
		
	}


	public synchronized static void saveQcDetail(QcDetailOnlineTransVO qcDetailOnlineTransVO_p) {
		
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call PKG_MMS_DML.dml_quality_check_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";// 48 Varibale's
		
		
		String[] strCheckHiddenValues =qcDetailOnlineTransVO_p.getStrCheckHiddenValues().replace("^","#").split("#");
		String[] strChkFlag=qcDetailOnlineTransVO_p.getStrChkFlag().split("\\^");
		              	      
		
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			daoObj = new HisDAO("MMS Transactions","saveQcDetail");
			//String[] strTmpCurrStockValues=qcDetailOnlineTransVO_p.getStrCurrentStockDetail().replace("^","@").split("@");
			
			//if(qcDetailOnlineTransVO_p.getStrCurrentStockDetail()!=null && !qcDetailOnlineTransVO_p.getStrCurrentStockDetail().equals(""))
			//{
				/************************************************************************/
				/* Value in voObj.getStrCurrentStockDetail();
				 		
				 		1.  STORE_NAME  
						2.  groupname 
						3.  sub_groupname 
						4.  itemname
						5.  item_brandname 
						6.  suppliername 
						7.  BATCH_NO 
						8.  EXPIRY_DATE
						9.  MANUF_DATE
						10. INHAND_QTY
						11. INHAND_UNIT_NAME
						12. INHAND_QTY_UNITID
						13. RATE
						14. RATE_UNIT_NAME
						15. RATE_UNITID
						16. SALEPRICE
						17. SALEPRICE_UNIT_NAME
						18. SALEPRICE_UNITID
						19. PO_NO
						20. PO_DATE
						21. SUPPLIED_BY
						22. RECIEVED_DATE
						23. CURRENCY_ID
						24. CURRENT_VALUE
						25. INVOICE_NO
						26. INVOICE_DATE
						27. ITEM_SPECIFICATION
						28. manufacturer_id
						29. RACK_NO 
						30. HSTNUM_FREEITEM_FLAG 
						31. GROUP_ID
						32. SUBGROUP_ID
				 * */
			 
				nProcIndex = daoObj.setProcedure(strProcName);
				
		
//				//System.out.println("p_HSTNUM_ITEM_ID::::"+strCheckHiddenValues[0]);                     
//				//System.out.println("p_HSTNUM_STORE_ID::::"+qcDetailOnlineTransVO_p.getStrStoreName());                    
//				//System.out.println("p_HSTNUM_LAB_SEND_NO::::"+strCheckHiddenValues[19]);                
//				//System.out.println("p_HSTNUM_ITEMBRAND_ID::::"+strCheckHiddenValues[10]);               
//				//System.out.println("p_HSTSTR_BATCH_SL_NO::::"+strCheckHiddenValues[5]);                 
//				//System.out.println("p_HSTDT_LAB_SEND_DATE::::"+strCheckHiddenValues[1]);                
//				//System.out.println("p_HSTSTR_ITEM_SL_NO::::"+strCheckHiddenValues[16]);                  
//				//System.out.println("p_HSTDT_REPORT_DATE::::"+strCheckHiddenValues[30]);                  
//			    //System.out.println("p_HSTNUM_STOCK_STATUS_CODE::::"+strCheckHiddenValues[32]);           
//			    //System.out.println("p_HSTNUM_LAB_NO::::"+strCheckHiddenValues[27]);                      
//			    //System.out.println("p_GNUM_HOSPITAL_CODE::::"+qcDetailOnlineTransVO_p.getStrHospitalCode());                 
//			    //System.out.println("p_SSTNUM_ITEM_CAT_NO::::"+qcDetailOnlineTransVO_p.getStrItemCategoryCmb());                 
//			    //System.out.println("p_HSTNUM_INHAND_QTY::::"+strCheckHiddenValues[33]);                  
//			    //System.out.println("p_HSTNUM_INHAND_QTY_UNITID::::"+strCheckHiddenValues[34]);           
//			    //System.out.println("p_HSTNUM_CONSUMED_QTY::::"+strCheckHiddenValues[13]);                
//			    //System.out.println("p_HSTNUM_CONSUMED_QTY_UNITID::::"+strCheckHiddenValues[14]);         
//			    //System.out.println("p_HSTNUM_PO_NO::::"+strCheckHiddenValues[23]);                       
//			    //System.out.println("p_HSTNUM_RATE::::"+strCheckHiddenValues[40]);                        
//			    //System.out.println("p_HSTDT_PO_DATE::::"+strCheckHiddenValues[24]);                      
//			    //System.out.println("p_HSTNUM_RATE_UNITID::::"+strCheckHiddenValues[41]);                 
//			    //System.out.println("p_HSTDT_MFG_DATE::::"+strCheckHiddenValues[8]);                     
//			    //System.out.println("p_HSTNUM_SUPPLIER_ID::::"+strCheckHiddenValues[35]);                 
//			    //System.out.println("p_HSTNUM_MANUFACTURER_ID::::"+strCheckHiddenValues[36]);             
//			    //System.out.println("p_HSTDT_EXPIRY_DATE::::"+strCheckHiddenValues[6]);                  
//			    //System.out.println("p_HSTSTR_FINAL_RESULT::::"+qcDetailOnlineTransVO_p.getStrRemarksLab());                
//			    //System.out.println("p_HSTNUM_ITEM_STATUS::::"+qcDetailOnlineTransVO_p.getStrQcStatus());                 
//			    //System.out.println("p_HSTSTR_SAMPLE_CODE_NO::::"+strCheckHiddenValues[37]);              
//			    //System.out.println("p_HSTSTR_CTR_NO::::"+strCheckHiddenValues[38]);                      
//			    //System.out.println("p_HSTDT_FINANCIAL_START_DATE::::"+" ");         
//			    //System.out.println("p_HSTDT_FINANCIAL_END_DATE::::"+" ");           
//			    //System.out.println("p_GDT_ENTRY_DATE::::"+qcDetailOnlineTransVO_p.getStrCurrentDate());                     
//			    //System.out.println("p_HSTNUM_IS_ONLINE_PROCESS::::"+"0");           
//			    //System.out.println("p_GNUM_SEATID::::"+qcDetailOnlineTransVO_p.getStrSeatId());                        
//			    //System.out.println("p_HSTSTR_LAB_INCHARGE_NAME::::"+qcDetailOnlineTransVO_p.getStrLabInchargeName());           
//			    //System.out.println("p_GNUM_ISVALID::::"+"1");                       
//			    //System.out.println("p_GSTR_SEND_REAMRKS::::"+strCheckHiddenValues[39]);                  
//			    //System.out.println("p_GSTR_RECEIVE_REAMRKS::::"+qcDetailOnlineTransVO_p.getStrRemarks());               
//			    //System.out.println("p_HSTSTR_FILE_NO::::"+qcDetailOnlineTransVO_p.getStrFileNo());                     
//			    //System.out.println("p_HSTNUM_PAGE_NO::::"+qcDetailOnlineTransVO_p.getStrPageNo());                     
//			    //System.out.println("p_HSTNUM_IS_RESEND::::"+"0");                   
//			    //System.out.println("p_HSTSTR_FILE_NAME::::"+qcDetailOnlineTransVO_p.getStrFileName());                  
//			    //System.out.println("p_description3::::"+"Through QC Detail Process (Stock Status Change)>>Old Stock Status : "+strCheckHiddenValues[15]+" ,New Stock Status :"+(qcDetailOnlineTransVO_p.getStrQcStatus().equals("1")?"10":"11"));
//			    //System.out.println("p_description1::::"+"Through QC Detail Process (Stock Status Change)>>HQ Name : "+strCheckHiddenValues[7]+" ,Lab Name :"+qcDetailOnlineTransVO_p.getStrLabName());
				qcDetailOnlineTransVO_p.setStrLabSendNumber(strCheckHiddenValues[19]);
				daoObj.setProcInValue(nProcIndex, "p_mode", "2");                                    	     //1
		        daoObj.setProcInValue(nProcIndex, "p_reqtypeid","73");          	                         //2
				daoObj.setProcInValue(nProcIndex, "p_HSTNUM_ITEM_ID",strCheckHiddenValues[0]);                     
				daoObj.setProcInValue(nProcIndex, "p_HSTNUM_STORE_ID",qcDetailOnlineTransVO_p.getStrStoreName());                    
				daoObj.setProcInValue(nProcIndex, "p_HSTNUM_LAB_SEND_NO",strCheckHiddenValues[19]);                
				daoObj.setProcInValue(nProcIndex, "p_HSTNUM_ITEMBRAND_ID",strCheckHiddenValues[10]);               
				daoObj.setProcInValue(nProcIndex, "p_HSTSTR_BATCH_SL_NO",strCheckHiddenValues[5]);                 
				daoObj.setProcInValue(nProcIndex, "p_HSTDT_LAB_SEND_DATE",strCheckHiddenValues[1]);                
				daoObj.setProcInValue(nProcIndex, "p_HSTSTR_ITEM_SL_NO",strCheckHiddenValues[16]);     
				daoObj.setProcInValue(nProcIndex, "p_HSTDT_REPORT_DATE",qcDetailOnlineTransVO_p.getStrReportDate());     
				daoObj.setProcInValue(nProcIndex, "p_HSTNUM_STOCK_STATUS_CODE",strCheckHiddenValues[32]);           
			    daoObj.setProcInValue(nProcIndex, "p_HSTNUM_LAB_NO",strCheckHiddenValues[27]);                      
			    daoObj.setProcInValue(nProcIndex, "p_GNUM_HOSPITAL_CODE",qcDetailOnlineTransVO_p.getStrHospitalCode());                 
			    daoObj.setProcInValue(nProcIndex, "p_SSTNUM_ITEM_CAT_NO",qcDetailOnlineTransVO_p.getStrItemCategoryCmb());                 
			    daoObj.setProcInValue(nProcIndex, "p_HSTNUM_INHAND_QTY",strCheckHiddenValues[33]);                  
			    daoObj.setProcInValue(nProcIndex, "p_HSTNUM_INHAND_QTY_UNITID",strCheckHiddenValues[34]);           
			    daoObj.setProcInValue(nProcIndex, "p_HSTNUM_CONSUMED_QTY",strCheckHiddenValues[13]);                
			    daoObj.setProcInValue(nProcIndex, "p_HSTNUM_CONSUMED_QTY_UNITID",strCheckHiddenValues[14]);         
			    daoObj.setProcInValue(nProcIndex, "p_HSTNUM_PO_NO",strCheckHiddenValues[23]);                       
			    daoObj.setProcInValue(nProcIndex, "p_HSTNUM_RATE",strCheckHiddenValues[40]);                        
			    daoObj.setProcInValue(nProcIndex, "p_HSTDT_PO_DATE",strCheckHiddenValues[24]);  			    
			    daoObj.setProcInValue(nProcIndex, "p_HSTNUM_RATE_UNITID",strCheckHiddenValues[41]);                 
			    daoObj.setProcInValue(nProcIndex, "p_HSTDT_MFG_DATE",strCheckHiddenValues[8]);                     
			    daoObj.setProcInValue(nProcIndex, "p_HSTNUM_SUPPLIER_ID",strCheckHiddenValues[35]);                 
			    daoObj.setProcInValue(nProcIndex, "p_HSTNUM_MANUFACTURER_ID",strCheckHiddenValues[36]);             
			    daoObj.setProcInValue(nProcIndex, "p_HSTDT_EXPIRY_DATE",strCheckHiddenValues[6]);                  
			    daoObj.setProcInValue(nProcIndex, "p_HSTSTR_FINAL_RESULT",qcDetailOnlineTransVO_p.getStrRemarksLab());                
			    daoObj.setProcInValue(nProcIndex, "p_HSTNUM_ITEM_STATUS",qcDetailOnlineTransVO_p.getStrQcStatus());                 
			    daoObj.setProcInValue(nProcIndex, "p_HSTSTR_SAMPLE_CODE_NO",strCheckHiddenValues[37]);              
			    //daoObj.setProcInValue(nProcIndex, "p_HSTSTR_CTR_NO",strCheckHiddenValues[38]);    // Orignal Value Change By Amit Kumar 
			    daoObj.setProcInValue(nProcIndex, "p_HSTSTR_CTR_NO",qcDetailOnlineTransVO_p.getStrCTRNumber());
			    daoObj.setProcInValue(nProcIndex, "p_HSTDT_FINANCIAL_START_DATE",qcDetailOnlineTransVO_p.getStrFinancialStartDate());         
			    daoObj.setProcInValue(nProcIndex, "p_HSTDT_FINANCIAL_END_DATE",qcDetailOnlineTransVO_p.getStrFinancialEndDate());           
			    daoObj.setProcInValue(nProcIndex, "p_GDT_ENTRY_DATE",qcDetailOnlineTransVO_p.getStrCurrentDate());                     
			    daoObj.setProcInValue(nProcIndex, "p_HSTNUM_IS_ONLINE_PROCESS","1");           
			    daoObj.setProcInValue(nProcIndex, "p_GNUM_SEATID",qcDetailOnlineTransVO_p.getStrSeatId());                        
			    daoObj.setProcInValue(nProcIndex, "p_HSTSTR_LAB_INCHARGE_NAME",qcDetailOnlineTransVO_p.getStrLabInchargeName());           
			    daoObj.setProcInValue(nProcIndex, "p_GNUM_ISVALID","1");                       
			    daoObj.setProcInValue(nProcIndex, "p_GSTR_SEND_REAMRKS",strCheckHiddenValues[39]);                  
			    daoObj.setProcInValue(nProcIndex, "p_GSTR_RECEIVE_REAMRKS",qcDetailOnlineTransVO_p.getStrRemarks());               
			    daoObj.setProcInValue(nProcIndex, "p_HSTSTR_FILE_NO",qcDetailOnlineTransVO_p.getStrFileNo());                     
			    daoObj.setProcInValue(nProcIndex, "p_HSTNUM_PAGE_NO",qcDetailOnlineTransVO_p.getStrPageNo());                     
			    daoObj.setProcInValue(nProcIndex, "p_HSTNUM_IS_RESEND","0");                   
			    daoObj.setProcInValue(nProcIndex, "p_HSTSTR_FILE_NAME",qcDetailOnlineTransVO_p.getStrFileName());   
			    daoObj.setProcInValue(nProcIndex, "p_HSTSTR_REPORT_NO",qcDetailOnlineTransVO_p.getStrReportNumber()); 
			    daoObj.setProcInValue(nProcIndex, "p_HSTDT_RPT_RECEIVED_DATE",qcDetailOnlineTransVO_p.getStrReceiveDate()); //45		
			    daoObj.setProcInValue(nProcIndex, "p_description3","Through QC Detail Process (Stock Status Change)>>Old Stock Status : "+strCheckHiddenValues[15]+" ,New Stock Status :"+(qcDetailOnlineTransVO_p.getStrQcStatus().equals("1")?"10":"11"));
			    daoObj.setProcInValue(nProcIndex, "p_description1","Through QC Detail Process (Stock Status Change)>>HQ Name : "+strCheckHiddenValues[7]+" ,Lab Name :"+qcDetailOnlineTransVO_p.getStrLabName());                  
			    daoObj.setProcOutValue(nProcIndex, "err", 1);			
				/**********************************************************************************/				
				daoObj.executeProcedure(nProcIndex);
				
				strErr = daoObj.getString(nProcIndex, "err");
			
				if (strErr.trim().length() > 0)
				{
					throw new Exception(strErr);
				}
				else
				{
					qcDetailOnlineTransVO_p.setStrMobileMsgMode("4");
					QcDetailOnlineTransDAO.getMobileMsgDtl(qcDetailOnlineTransVO_p);	
				}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			qcDetailOnlineTransVO_p.setStrMsgString("QcDetailOnlineTransDAO.saveQcDetail() --> "
							+ e.getMessage());
			qcDetailOnlineTransVO_p.setStrMsgType("1");
			

		}
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
		
	}
	
	public static void getMobileMsgDtl(QcDetailOnlineTransVO _QcDetailOnlineTransVO) 
	{
		String strProcName = "{? = call MMS_MST.MOB_SMS_MSG(?,?,?,?)}";
		HisDAO dao = null;
		int funcIndex = 0;
		String strReturnMsg = "";
		try 
		{
			dao = new HisDAO("MMS","transactions.QcDetailOnlineTransDAO.getMobileMsgDtl()");

			funcIndex = dao.setFunction(strProcName);
			dao.setFuncInValue(funcIndex, 2, _QcDetailOnlineTransVO.getStrMobileMsgMode());
			dao.setFuncInValue(funcIndex, 3, _QcDetailOnlineTransVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4, _QcDetailOnlineTransVO.getStrStoreId());
			dao.setFuncInValue(funcIndex, 5, _QcDetailOnlineTransVO.getStrLabSendNumber());
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			strReturnMsg = dao.getFuncString(funcIndex);
			if(!strReturnMsg.split("\\^")[0].equals("")||!strReturnMsg.split("\\^")[0].equals("0"))
			{
				_QcDetailOnlineTransVO.setStrMobileNoList(strReturnMsg.split("\\^")[0]);
				_QcDetailOnlineTransVO.setStrMobileMsg(strReturnMsg.split("\\^")[1]);
				_QcDetailOnlineTransVO.setStrMobileUserName(strReturnMsg.split("\\^")[2].split("\\@")[0]);
				_QcDetailOnlineTransVO.setStrMobilePwd(strReturnMsg.split("\\^")[2].split("\\@")[1]);
				_QcDetailOnlineTransVO.setStrMobileSenderId(strReturnMsg.split("\\^")[2].split("\\@")[2]);
			}

		} 
		catch (Exception _Err) 
		{
			_Err.printStackTrace();
			_QcDetailOnlineTransVO.setStrMsgString("QcDetailOnlineTransDAO.getMobileMsgDtl() --> "+ _Err.getMessage());
			_QcDetailOnlineTransVO.setStrMsgType("1");
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
