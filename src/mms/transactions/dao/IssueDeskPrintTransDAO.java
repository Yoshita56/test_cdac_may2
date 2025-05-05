package mms.transactions.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.MmsConfigUtil;
import mms.transactions.vo.IssueDeskPrintTransVO;

public class IssueDeskPrintTransDAO 
{
	
	/*
	 * This Function is used to get Store Name by Passing 2 variable a) Hospital
	 * Code b) Store Id
	 */
	public static void callingFunctionIndentName(IssueDeskPrintTransVO vo) 
	{
		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		try {
			dao = new HisDAO("MMSModule", "RequestForLPStaffDAO");
			funcIndex = dao
					.setFunction("{? = call MMS_MST.get_indentType_Name(?::numeric,?::numeric,?::numeric)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, "1");
			dao.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4, vo.getStrReqTypeId());
			dao.setFuncOutValue(funcIndex, 1);
			// Execute Function
			dao.executeFunction(funcIndex);
			retVal = dao.getFuncString(funcIndex);
			if (retVal != null) 
			{
				vo.setStrIndentName(retVal);
			} 
			else 
			{
				retVal = "-----";
				vo.setStrIndentName(retVal);
			}

		} catch (Exception e) {
			vo
					.setStrMsgString("IndentDeskCondemnationReqTransDAO.callingFunctionIndentName() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void getStoreList(IssueDeskPrintTransVO vo) 
	{

		HisDAO      daoObj = null;
		WebRowSet       ws = null;
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int     nProcIndex = 0;	
		String strErr = "";
		try
		{
			System.out.println(" ------- IssueToPatientTransDAO .getStoreList  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_hstt_store_mst  --[ Mode- 12 ]------ ");
			
			    daoObj = new HisDAO("MMS Transactions","IssueDeskPrintTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			////System.out.println("In DAO==>"+nProcIndex);
             
			daoObj.setProcInValue(nProcIndex, "modeval",     "12",1);
			daoObj.setProcInValue(nProcIndex, "seatId",      vo.getStrSeatId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code",   vo.getStrHospitalCode(),3);
			
			/* Setting Default Value Start*/
			daoObj.setProcInValue(nProcIndex, "storeid",      "0",4);
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0",5);
			/* Setting Default Value End */
			
			daoObj.setProcOutValue(nProcIndex, "err",          1,6);
			daoObj.setProcOutValue(nProcIndex, "resultset",    2,7);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			   strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) 
			{
				

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				
				if(ws.next())
				{
					// HSTNUM_STORE_ID|| '^' ||HSTNUM_STORETYPE_ID
					vo.setStrStoreId(ws.getString(1).split("\\^")[0]);
				}
		        ws.beforeFirst();
		        
				vo.setStrStoreWs(ws);
							
			} 
			else
			{
				throw new Exception(strErr);
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("IssueDeskPrintTransDAO.getStoreList() --> "+ e.getMessage());
			vo.setStrMsgType("1");

		} 
		finally 
		{
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getRequestTypeCombo(IssueDeskPrintTransVO vo) 
	{
		
		
		HisDAO      daoObj = null;
		WebRowSet       ws = null;
		String strProcName = "{call pkg_mms_view2.proc_lstpage_requesttype_dtl(?,?,?,?,?   ,?,?)}"; // 7
		int     nProcIndex = 0;	
		String strErr = "";
		try
		{
			System.out.println(" ------- IssueToPatientTransDAO .getRequestTypeCombo  -------- ");
			System.out.println(" ------- pkg_mms_view2.proc_lstpage_requesttype_dtl  --[ Mode- 2 ]------ ");
			
			    daoObj = new HisDAO("MMS Transactions","IssueDeskPrintTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			             
			daoObj.setProcInValue(nProcIndex, "modeval"   , "2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code" , vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "req_for"   , "0",3);
			daoObj.setProcInValue(nProcIndex, "item_cat"  , (vo.getStrItemCategNo() == null ? "10"   : vo.getStrItemCategNo()),4);
			daoObj.setProcInValue(nProcIndex, "store_id"  , (vo.getStrStoreId() == null ? "10100001" : vo.getStrStoreId()),5);
			daoObj.setProcOutValue(nProcIndex, "err"      , 1,6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			   strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) 
			{

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				vo.setStrRequestTypeWs(ws);
							
			} 
			else
			{
				throw new Exception(strErr);
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("IssueDeskPrintTransDAO.getRequestTypeCombo() --> "+ e.getMessage());
			vo.setStrMsgType("1");

		} 
		finally 
		{
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	public static void getListPageData(IssueDeskPrintTransVO vo) 
	{
		
		
		HisDAO      daoObj = null;
		WebRowSet       ws = null;
		String strProcName = "{call Pkg_Mms_View2.proc_indent_print_lstpage_data(?,?,?,?,?   ,?,?,?)}"; // 8
		int     nProcIndex = 0;	
		String strErr = "";
		try
		{
			System.out.println(" ------- IssueToPatientTransDAO .getListPageData  -------- ");
			System.out.println(" ------- pkg_mms_view2.proc_indent_print_lstpage_data  --[ Mode- 1 ]------ ");
			System.out.println("------vo.setStrRequestTypeId------"+vo.getStrRequestTypeId());
			
				
			
		    daoObj = new HisDAO("MMS Transactions","IssueDeskPrintTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			if(vo.getStrRequestTypeId().equals("17"))
			{	
				daoObj.setProcInValue(nProcIndex, "modeval"      , "3",1);
			}else {
				daoObj.setProcInValue(nProcIndex, "modeval"      , "2",1);
			}      
			
//			daoObj.setProcInValue(nProcIndex, "modeval"      , "2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code"    , vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "req_for"      , (vo.getStrRequestTypeId() == null ? "35"   : vo.getStrRequestTypeId()),3);
			daoObj.setProcInValue(nProcIndex, "item_cat"  	 , (vo.getStrItemCategNo() == null ? "10"   : vo.getStrItemCategNo()),4);
			daoObj.setProcInValue(nProcIndex, "store_id"  	 , (vo.getStrStoreId() == null ? "10100001" : vo.getStrStoreId()),5);
			daoObj.setProcInValue(nProcIndex, "status_code"  , (vo.getStrStatusCode() == null ? "1" : vo.getStrStatusCode()),6);
			
			daoObj.setProcOutValue(nProcIndex, "err"         , 1,7);
			daoObj.setProcOutValue(nProcIndex, "resultset"   , 2,8);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			   strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) 
			{

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				vo.setStrDataTableWs(ws);
							
			} 
			else
			{
				throw new Exception(strErr);
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("IssueDeskPrintTransDAO.getRequestTypeCombo() --> "+ e.getMessage());
			vo.setStrMsgType("1");

		} 
		finally 
		{
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	public static void getIndentDetails(IssueDeskPrintTransVO vo) 
	{
		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";

    	try 
		{
    		System.out.println("<<--------------PKG_MMS_VIEW.Get_Indent_Details_View-[ Req No--"+vo.getStrLpRequestNo()+" ]------------->>");
    		
    		String strProcName = "{call PKG_MMS_VIEW.get_ipd_indent_details_view(?,?,?,?,?,?)}";

			daoObj = new HisDAO("MMS Transactions","IssueDeskPrintTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "storeId"   ,vo.getStrRaisingStoreId(),1);
			daoObj.setProcInValue(nProcIndex, "hosp_code" ,vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "reqNo"     ,vo.getStrLpRequestNo(),3);			
			daoObj.setProcInValue(nProcIndex, "reqTypeId","",4);			
			daoObj.setProcOutValue(nProcIndex,"err",1,5);
			daoObj.setProcOutValue(nProcIndex,"resultset", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) 
			{
    			wb = daoObj.getWebRowSet(nProcIndex, "resultset");
				vo.setStrIndentDetailsWs(wb);
				
			} else {
				throw new Exception(strErr);
			}
    		
		
		
		} 
    	catch (Exception e) 
    	{
			vo.setStrMsgString("--> IssueDeskPrintTransDAO.getIndentDetails()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null)
				daoObj.free();
				daoObj = null;
			}

		}
	
	/**
	 * To get Indent Details i.e.(Store Name,Indent No.,Indent Date,Indent
	 * Type,Item Category,Raising Store) on 'issue' page
	 * 
	 * @param vo
	 */
	public static void getLPRequestDetail(IssueDeskPrintTransVO _IssueDeskPrintTransVO) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_hstt_lp_req_item_dtl(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		int funcIndex;
		String BillingValue="";
		try {
			
			System.out.println("-------------  IssueDeskPrintTransDAO . getLPRequestDetail  --------------");
			System.out.println("-------------  bill_mst.get_pat_accountdetails_limit  --------------");
			System.out.println("-------------  pkg_mms_view.proc_hstt_lp_req_item_dtl  ------[Mode - 2]--------");
			
			
			dao = new HisDAO("mms",
					"IssueDeskPrintTransDAO.getIndentDetail(IssueDeskPrintTransVO vo)");
			funcIndex = dao.setFunction("{? = call bill_mst.get_pat_accountdetails_limit(?,?,?)}");

					dao.setFuncInValue(funcIndex, 2,_IssueDeskPrintTransVO.getStrHospitalCode());
					dao.setFuncInValue(funcIndex, 3,"2");
					dao.setFuncInValue(funcIndex, 4,_IssueDeskPrintTransVO.getStrCrNo());
					//dao.setFuncInValue(funcIndex, 5,_IssueDeskPrintTransVO.getStrItemCategNo());
					dao.setFuncOutValue(funcIndex, 1);
					dao.executeFunction(funcIndex);
					BillingValue = dao.getFuncString(funcIndex); 
					//System.out.println("BillingValue"+BillingValue);
					_IssueDeskPrintTransVO.setStrBillingHiddenValue(BillingValue);
					
					
			
			

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modval", "1", 1);
			dao.setProcInValue(procIndex1, "lPRequestNo",
					_IssueDeskPrintTransVO.getStrLpRequestNo(), 2);

			dao.setProcInValue(procIndex1, "strRasingStoreId",
					_IssueDeskPrintTransVO.getStrRaisingStoreId(), 3);

			dao.setProcInValue(procIndex1, "hosp_code",
					_IssueDeskPrintTransVO.getStrHospitalCode(), 4);

			// dao.setProcInValue(procIndex1, "strRequestDate",
			// _IssueDeskPrintTransVO.getStrRequestDate());

			/* Setting Default Value Start */

			dao.setProcInValue(procIndex1, "strRequestDate", "", 5);
			/* Setting Default Value End */

			dao.setProcOutValue(procIndex1, "err", 1, 6); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2, 7); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");

				_IssueDeskPrintTransVO.setRequestItemDtlWS(ws);

			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			e.printStackTrace();
			_IssueDeskPrintTransVO
					.setStrMsgString("IssueDeskPrintTransDAO.getLPRequestDetail() --> "
							+ e.getMessage());
			_IssueDeskPrintTransVO.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	
	public static void getLPRequestDetail_new(IssueDeskPrintTransVO _IssueDeskPrintTransVO) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_hstt_lp_req_item_dtl(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		int funcIndex;
		String BillingValue="";
		try {
			
			System.out.println("-------------  IssueDeskPrintTransDAO . getLPRequestDetail_new  --------------");
			System.out.println("-------------  bill_mst.get_pat_accountdetails_limit  --------------");
			System.out.println("-------------  pkg_mms_view.proc_hstt_lp_req_item_dtl  ------[Mode - 2]--------");
			

			dao = new HisDAO("mms",
					"IssueDeskPrintTransDAO.getLPRequestDetail_new(IssueDeskPrintTransVO vo)");

			funcIndex = dao.setFunction("{? = call bill_mst.get_pat_accountdetails_limit(?,?,?)}");

			dao.setFuncInValue(funcIndex, 2,_IssueDeskPrintTransVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3,"2");
			dao.setFuncInValue(funcIndex, 4,_IssueDeskPrintTransVO.getStrCrNo());
			//dao.setFuncInValue(funcIndex, 5,_IssueDeskPrintTransVO.getStrItemCategNo());
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			BillingValue = dao.getFuncString(funcIndex); 
			//System.out.println("BillingValue"+BillingValue);
			_IssueDeskPrintTransVO.setStrBillingHiddenValue(BillingValue);
			
			
			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modval", "2", 1);
			dao.setProcInValue(procIndex1, "lPRequestNo",
					_IssueDeskPrintTransVO.getStrBSReqNo(), 2);

			dao.setProcInValue(procIndex1, "strRasingStoreId",
					_IssueDeskPrintTransVO.getStrStoreId(), 3);

			dao.setProcInValue(procIndex1, "hosp_code",
					_IssueDeskPrintTransVO.getStrHospitalCode(), 4);

			// dao.setProcInValue(procIndex1, "strRequestDate",
			// _IssueDeskPrintTransVO.getStrRequestDate());

			/* Setting Default Value Start */

			dao.setProcInValue(procIndex1, "strRequestDate", "", 5);
			/* Setting Default Value End */

			dao.setProcOutValue(procIndex1, "err", 1, 6); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2, 7); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");

				_IssueDeskPrintTransVO.setRequestItemDtlWS(ws);

			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			e.printStackTrace();
			_IssueDeskPrintTransVO
					.setStrMsgString("IssueDeskPrintTransDAO.getLPRequestDetail() --> "
							+ e.getMessage());
			_IssueDeskPrintTransVO.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}

	public static void getIssuedItemDtl(IssueDeskPrintTransVO _IssueDeskPrintTransVO) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.Proc_patemp_issue_item_dtl(?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		int funcIndex;
		String BillingValue="";
		try {

			dao = new HisDAO("mms",
					"IssueDeskPrintTransDAO.getIndentDetail(IssueDeskPrintTransVO vo)");
			
			System.out.println("------------- bill_mst.get_pat_accountdetails_limit  --------------");
			
			funcIndex = dao.setFunction("{? = call bill_mst.get_pat_accountdetails_limit(?,?,?)}");

			dao.setFuncInValue(funcIndex, 2,_IssueDeskPrintTransVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3,"2");
			dao.setFuncInValue(funcIndex, 4,_IssueDeskPrintTransVO.getStrCrNo());
			//dao.setFuncInValue(funcIndex, 5,_IssueDeskPrintTransVO.getStrItemCategNo());
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			BillingValue = dao.getFuncString(funcIndex); 
			//System.out.println("BillingValue"+BillingValue);
			_IssueDeskPrintTransVO.setStrBillingHiddenValue(BillingValue);

			//System.out.println(_IssueDeskPrintTransVO.getStrIssueNo() + " "					+ _IssueDeskPrintTransVO.getStrIssueStoreId() + " "					+ _IssueDeskPrintTransVO.getStrHospitalCode());

			System.out.println("------------- pkg_mms_view.Proc_patemp_issue_item_dtl  -----[ Mode - 2]---------");
			
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "modval", "2", 1);

			// set value
			dao.setProcInValue(procIndex1, "issue_No",
					_IssueDeskPrintTransVO.getStrIssueNo(), 4);//Request number is being passed name is wrong......discuss

			dao.setProcInValue(procIndex1, "store_id",
					_IssueDeskPrintTransVO.getStrIssueStoreId(), 2);

			dao.setProcInValue(procIndex1, "hosp_code",
					_IssueDeskPrintTransVO.getStrHospitalCode(), 3);

			// dao.setProcInValue(procIndex1, "strRequestDate",
			// _IssueDeskPrintTransVO.getStrRequestDate());

			dao.setProcOutValue(procIndex1, "err", 1, 5); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2, 6); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");
				_IssueDeskPrintTransVO.setIssuedItemDtlWS(ws);

			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			e.printStackTrace();
			_IssueDeskPrintTransVO
					.setStrMsgString("IssueDeskPrintTransDAO.getIssuedItemDtl() --> "
							+ e.getMessage());
			_IssueDeskPrintTransVO.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
	
	
	public static void getIssuedItemDtlview(IssueDeskPrintTransVO _IssueDeskPrintTransVO) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.Proc_patemp_issue_item_dtl(?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {
			
			System.out.println("-------------  IssueDeskPrintTransDAO . getIssuedItemDtlview  --------------");
			
			System.out.println("-------------  pkg_mms_view.Proc_patemp_issue_item_dtl  ------[Mode - 3,4]--------");
			

			dao = new HisDAO("mms",
					"IssueDeskPrintTransDAO.getIndentDetail(IssueDeskPrintTransVO vo)");

			//System.out.println(_IssueDeskPrintTransVO.getStrIssueNo() + " "					+ _IssueDeskPrintTransVO.getStrIssueStoreId() + " "					+ _IssueDeskPrintTransVO.getStrHospitalCode());

			procIndex1 = dao.setProcedure(proc_name1);
			if(!_IssueDeskPrintTransVO.getStrRequestTypeId().equals("32"))
				dao.setProcInValue(procIndex1, "modval", "3", 1);
			else
				dao.setProcInValue(procIndex1, "modval", "4", 1);

			// set value
			dao.setProcInValue(procIndex1, "issue_No",
					_IssueDeskPrintTransVO.getStrIssueNo(), 4);//Request number is being passed name is wrong......discuss

			dao.setProcInValue(procIndex1, "store_id",
					_IssueDeskPrintTransVO.getStrIssueStoreId(), 2);

			dao.setProcInValue(procIndex1, "hosp_code",
					_IssueDeskPrintTransVO.getStrHospitalCode(), 3);

			// dao.setProcInValue(procIndex1, "strRequestDate",
			// _IssueDeskPrintTransVO.getStrRequestDate());

			dao.setProcOutValue(procIndex1, "err", 1, 5); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2, 6); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");
				_IssueDeskPrintTransVO.setIssuedItemDtlWS(ws);

			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			e.printStackTrace();
			_IssueDeskPrintTransVO
					.setStrMsgString("IssueDeskPrintTransDAO.getIssuedItemDtl() --> "
							+ e.getMessage());
			_IssueDeskPrintTransVO.setStrMsgType("1");

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
	public static void getReturnUnitCombo(IssueDeskPrintTransVO _IssueDeskPrintTransVO) {
		String strProcName = "{call Pkg_Mms_View.proc_GBLT_UNIT_MST(?,?,?,?,?,?)}";
		HisDAO dao = null;
		WebRowSet ws = null;
		int nProcIndex = 0;

		String strErr = "";

		try {
			
	        System.out.println("-------------  IssueDeskPrintTransDAO . getReturnUnitCombo  --------------");
			
			System.out.println("-------------  pkg_mms_view.proc_GBLT_UNIT_MST  ------[Mode - 4]--------");
			
			
			dao = new HisDAO("mms", "ReturnFromTransDAO");

			nProcIndex = dao.setProcedure(strProcName);
			dao.setProcInValue(nProcIndex, "modeval", "1", 4);
			dao.setProcInValue(nProcIndex, "hosp_code",
					_IssueDeskPrintTransVO.getStrHospitalCode(), 1);
			dao.setProcInValue(nProcIndex, "unit_id",
					_IssueDeskPrintTransVO.getStrBalanceQtUnitId(), 2);

			dao.setProcInValue(nProcIndex, "module_id", "", 3);// Default Value

			dao.setProcOutValue(nProcIndex, "err", 1, 5);
			dao.setProcOutValue(nProcIndex, "resultset", 2, 6);

			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				_IssueDeskPrintTransVO.setUnitComboWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			_IssueDeskPrintTransVO
					.setStrMsgString("IssueDeskPrintTransDAO.getReturnUnitCombo() --> "
							+ e.getMessage());
			_IssueDeskPrintTransVO.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	public static void getIssueItemDtl(IssueDeskPrintTransVO _IssueDeskPrintTransVO) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.Proc_hstt_chall_verifiitem_dtl(?,?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {
			
			 System.out.println("-------------  IssueDeskPrintTransDAO . getIssueItemDtl  --------------");
				
			 System.out.println("-------------  pkg_mms_view.Proc_hstt_chall_verifiitem_dtl  ------[Mode - 3]--------");

			dao = new HisDAO("mms",
					"IssueDeskPrintTransDAO.getIssueItemDtl(IssueDeskPrintTransVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modval", "3", 1);
			dao.setProcInValue(procIndex1, "strId",
					_IssueDeskPrintTransVO.getStrRaisingStoreId(), 2);
			dao.setProcInValue(procIndex1, "lPRequestNo",
					_IssueDeskPrintTransVO.getStrLpRequestNo(), 3);

			dao.setProcInValue(procIndex1, "hosp_code",
					_IssueDeskPrintTransVO.getStrHospitalCode(), 4);
			dao.setProcInValue(procIndex1, "poNo",
					_IssueDeskPrintTransVO.getStrPoNo(), 5);
			dao.setProcInValue(procIndex1, "poStoreId",
					_IssueDeskPrintTransVO.getStrPoStoreId(), 6);

			// Default Value

			// dao.setProcInValue(procIndex1, "strRequestDate",
			// _IssueDeskPrintTransVO.getStrRequestDate());

			dao.setProcOutValue(procIndex1, "err", 1, 7); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2, 8); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");
				//System.out.println("ws.size()" + ws.size());
				_IssueDeskPrintTransVO.setIssueItemDtlWS(ws);

			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			e.printStackTrace();
			_IssueDeskPrintTransVO
					.setStrMsgString("IssueDeskPrintTransDAO.getIssueItemDtl() --> "
							+ e.getMessage());
			_IssueDeskPrintTransVO.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
	public static void getItemDetails(IssueDeskPrintTransVO vo) 
	{
		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";
		
    	try 
		{
    		System.out.println("<<--------------PKG_MMS_VIEW.PROC_GET_INDENTITEM_DTL-[ Mode - 3 ]----  HSTT_LP_REQ_DTL , HSTT_LP_REQ_ITEM_DTL--------->>");
    		String strProcName = "{call PKG_MMS_VIEW.PROC_GET_INDENTITEM_DTL(?,?,?,?,?,?,?)}";

			daoObj = new HisDAO("MMS Transactions","IssueDeskPrintTransDAO");
			//System.out.println("reqTypeId ====>>"+vo.getStrReqTypeId());
			nProcIndex = daoObj.setProcedure(strProcName);
     		daoObj.setProcInValue(nProcIndex, "modval", 	"3",1);
	     	daoObj.setProcInValue(nProcIndex, "storeId",	vo.getStrRaisingStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code",	vo.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "reqNo",		vo.getStrLpRequestNo(),4);
			daoObj.setProcInValue(nProcIndex, "reqTypeId",	"0",5);
						
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
			vo.setStrMsgString("--> IssueDeskPrintTransDAO.getItemDetails()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null)
				daoObj.free();
				daoObj = null;
			}

		}
	
	
	
	
	public static void getIssueItemDtl_new(IssueDeskPrintTransVO _IssueDeskPrintTransVO) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.Proc_hstt_chall_verifiitem_dtl(?,?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {
			
			 System.out.println("-------------  IssueDeskPrintTransDAO . getIssueItemDtl_new  --------------");
				
			 System.out.println("-------------  pkg_mms_view.Proc_hstt_chall_verifiitem_dtl  ------[Mode - 5]--------");

			dao = new HisDAO("mms",
					"IssueDeskPrintTransDAO.getIssueItemDtl(IssueDeskPrintTransVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modval", "5", 1);
			dao.setProcInValue(procIndex1, "strId",
					_IssueDeskPrintTransVO.getStrStoreId(), 2);
			dao.setProcInValue(procIndex1, "lPRequestNo",
					_IssueDeskPrintTransVO.getStrBSReqNo(), 3);

			dao.setProcInValue(procIndex1, "hosp_code",
					_IssueDeskPrintTransVO.getStrHospitalCode(), 4);
			dao.setProcInValue(procIndex1, "poNo",
					_IssueDeskPrintTransVO.getStrPoNo(), 5);
			dao.setProcInValue(procIndex1, "poStoreId",
					_IssueDeskPrintTransVO.getStrPoStoreId(), 6);

			// Default Value

			// dao.setProcInValue(procIndex1, "strRequestDate",
			// _IssueDeskPrintTransVO.getStrRequestDate());

			dao.setProcOutValue(procIndex1, "err", 1, 7); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2, 8); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");
				//System.out.println("ws.size()" + ws.size());
				_IssueDeskPrintTransVO.setIssueItemDtlWS(ws);

			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			e.printStackTrace();
			_IssueDeskPrintTransVO
					.setStrMsgString("IssueDeskPrintTransDAO.getIssueItemDtl() --> "
							+ e.getMessage());
			_IssueDeskPrintTransVO.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	public static void insertData_New(IssueDeskPrintTransVO _IssueDeskPrintTransVO) 
	{
		String proc_name1 = "";		
		HisDAO dao = null;
		int procIndex1 = 0;
		int procIndex3 = 0;
		int procIndex4 = 0;
		int length = 0;
		String temp[] = null;
		String strItemBrandId = "";
		String strItemId = "";
		String strRate = "";
		String strRateUnitId = "";
		String strGroupId = "";
		String strSubGroupId = "";
		String strBatchSlNo = "";
		String strExpiryDate = "";
		String strIssueQty = "";
		String strStoreId = "";
		String strIssueNo = "";
		String hosp_code = "";
		String strItemSlNo = "";
		String strStockStatus = "";
		String strManuFactDate = "";
		String strConsumableFlag = "1";
		String strRemarks = "";
		String strItemCost = "";
		int funcIndex;
		String strIssueUnitId = "0";
		int batchLength;
		
		String                       values[] = null;
		String bsReqNo="0";
		int pIndex;
		String p_name="";
		int nProcIndex = 0;
		WebRowSet ws = null;
		String strErr = "";
		
		try 
		{
			System.out.println("---------IssueDeskPrintTransDAO.insertData---------");
			
			dao = new HisDAO("mms","IssueDeskPrintTransDAO.insertData(_IssueDeskPrintTransVO)");
			length = _IssueDeskPrintTransVO.getStrItemParamValue().length;
			
			System.out.println("---------MMS_MST.generate_issueNo---------");
			
			System.out.println("--------["+_IssueDeskPrintTransVO.getStrRequestTypeId()+" - 31- Issue To Store  , 35 - Issue To Pateint IPD , 32 - Issue To Patient Direct ]-------");

			funcIndex = dao.setFunction("{? = call MMS_MST.generate_issueNo(?,?,?,?)}");

			dao.setFuncInValue(funcIndex, 2,_IssueDeskPrintTransVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3,_IssueDeskPrintTransVO.getStrStoreId());
			dao.setFuncInValue(funcIndex, 4,_IssueDeskPrintTransVO.getStrRequestTypeId());
			dao.setFuncInValue(funcIndex, 5,_IssueDeskPrintTransVO.getStrItemCategNo());
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			strIssueNo = dao.getFuncString(funcIndex); 
			
			
			System.out.println("-------------------------------------");
			System.out.println("strIssueNo----------"+strIssueNo);	
			System.out.println("strItemBrandId------"+strItemBrandId);
			System.out.println("strBatchSlNo--------"+strBatchSlNo);
			System.out.println("strRequestNo--------"+_IssueDeskPrintTransVO.getStrLpRequestNo());
			System.out.println("deptcode------------"+_IssueDeskPrintTransVO.getStrDeptCode());
			System.out.println("treatmentcatg-------"+_IssueDeskPrintTransVO.getStrTreatmentCat());
			System.out.println("episodecode---------"+_IssueDeskPrintTransVO.getStrEpisodeCode());
			System.out.println("wardcode------------"+_IssueDeskPrintTransVO.getStrWardCode());
			System.out.println("addmissionno--------"+_IssueDeskPrintTransVO.getStrAdmissionNo());
			System.out.println("visitno-------------"+_IssueDeskPrintTransVO.getStrVisitNo());
			System.out.println("-----------------------------------");
			
			_IssueDeskPrintTransVO.setStrIssueNo(strIssueNo);
			temp = _IssueDeskPrintTransVO.getStrItemParamValue()[0].replace('@','#').split("#");
			strIssueUnitId = temp[3];
			strRateUnitId = temp[3];
			strIssueQty = temp[2];			
			proc_name1="";
			
			proc_name1 = "{call pkg_mms_dml.dml_hstt_patemp_issue_item_dtl_with_billing(?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?,  ?,?,?,?,?   ?,?,?,?,? ,  ?,?,?)}"; // 33 Variables
			
			for (int i = 0; i < _IssueDeskPrintTransVO.getStrItemParamValue().length; i++) 
			{
				if (!_IssueDeskPrintTransVO.getStrIssueQuantity()[i].equals("0") && !_IssueDeskPrintTransVO.getStrIssueQuantity()[i].equals("0.00") ) 
				{					
					if (_IssueDeskPrintTransVO.getStockDtlsId()!=null)
					{
						if (!_IssueDeskPrintTransVO.getStockDtlsId()[i].equals("")) 
						{
							
							System.out.println("------- When Batch Selected From Stock  -------");
								
							values = _IssueDeskPrintTransVO.getStockDtlsId()[i].split("#"); 
		                    //    0       1         		2			3	            4        5         6           7                8               9               10                  11              12      13          14           15          16   17  18      19       
							// StoreId^Generic_ItemId^Brand_ItemId^Stock_Status_Code^Batch_No^Serial_No^Expiry date^Manufactre Date^In Hand Qty ^ In Hand Qty Unit ^ Purchase Rate ^ Purchase Rate Unit ^ Rate ^ Rate Unit ^ Issue Qty ^ Issue Qty Unit ^   ^   ^ Cost ^ Cost
							// 99901120^10000067^10100067^UIT11738^10^0^31-May-2014^01-Dec-2011^24990^6301^21.54^6306^22.62^6306^10^6301^1^0^2.26^2.26
							batchLength = values.length;
							for (int j = 0; j < batchLength; j++) 
							{
								temp 				= values[j].replace("^", "#").split("#");
								strItemBrandId 		= temp[2];
								strItemId 			= temp[1];
								strRate				= temp[12];
								strRateUnitId		= temp[13];							
								strGroupId 			= "";
								strSubGroupId 		= "";
								if(temp[3].equals("-1") || (temp[3]=="-1"))
								{
								    strBatchSlNo 		= "0";
								}
								else
								{
									strBatchSlNo 		= temp[3];	
								}
								strExpiryDate 		= temp[6].trim();								
								strIssueQty 		= temp[14];
								strStoreId 			= _IssueDeskPrintTransVO.getStrStoreId();
								hosp_code 			= _IssueDeskPrintTransVO.getStrHospitalCode();
								strItemSlNo 		= "0";
								strStockStatus 		= "10";
								strManuFactDate 	= temp[7];
								strConsumableFlag 	= "1";
								strRemarks 			= _IssueDeskPrintTransVO.getStrRemarks();								
								strIssueUnitId 		= temp[15];
								 							
								System.out.println("---A------"+proc_name1+"---[ Mode -1 ]---"+i+"---");
								
								
								
								procIndex1 = dao.setProcedure(proc_name1);										
								dao.setProcInValue(procIndex1, "modval", 			"1", 		1); 
								dao.setProcInValue(procIndex1, "strItemBrandId",	strItemBrandId, 2); // 1
								dao.setProcInValue(procIndex1, "strItemId", 		strItemId, 3); // 2
								dao.setProcInValue(procIndex1, "strRate", 			strRate, 4); // 3
								dao.setProcInValue(procIndex1, "strRateUnitId",		strRateUnitId, 5); // 4
								dao.setProcInValue(procIndex1, "strGroupId", 		strGroupId, 6); // 5?
								dao.setProcInValue(procIndex1, "strSubGroupId",		strSubGroupId, 7); // 6?
								dao.setProcInValue(procIndex1, "strBatchSlNo",		strBatchSlNo, 8); // 7
								dao.setProcInValue(procIndex1, "strExpiryDate",		strExpiryDate.trim(), 9); // 8
								dao.setProcInValue(procIndex1, "strIssueQty", 		strIssueQty,10);
								dao.setProcInValue(procIndex1, "strIssueUnitId",	strIssueUnitId, 11); // 10
								dao.setProcInValue(procIndex1, "strStoreId", 		strStoreId, 12); // 11
								dao.setProcInValue(procIndex1, "strIssueNo", 		strIssueNo, 13); // 12
								dao.setProcInValue(procIndex1, "hosp_code", 		hosp_code, 14); // 13
								dao.setProcInValue(procIndex1, "strItemSlNo", 		strItemSlNo,15); // 14
								dao.setProcInValue(procIndex1, "strStockStatus",	strStockStatus, 16); // 15
								dao.setProcInValue(procIndex1, "strManuFactDate",	strManuFactDate.trim(), 17); // 16
								dao.setProcInValue(procIndex1, "strConsumableFlag",	strConsumableFlag, 18); // 17
								dao.setProcInValue(procIndex1, "strRemarks", 		strRemarks, 19); // 18
								dao.setProcInValue(procIndex1, "strItemCost",		Double.toString(Math.round((Double.parseDouble(strIssueQty)*Double.parseDouble(strRate))*100.0)/100.0),20); // 19?
								dao.setProcInValue(procIndex1, "strRequestNo",		_IssueDeskPrintTransVO.getStrLpRequestNo(), 21); // 20?
								dao.setProcInValue(procIndex1, "strRasingStoreId",	_IssueDeskPrintTransVO.getStrRaisingStoreId(), 22);
								dao.setProcInValue(procIndex1, "strItemCatNo",		_IssueDeskPrintTransVO.getStrItemCategNo(), 23); // 21
								dao.setProcInValue(procIndex1, "strSeatid",			_IssueDeskPrintTransVO.getStrSeatId(), 24);
								dao.setProcInValue(procIndex1, "strDescription",	_IssueDeskPrintTransVO.getStrDescription(), 25);
								dao.setProcInValue(procIndex1, "crno",				_IssueDeskPrintTransVO.getStrCrNo(), 26);								
								dao.setProcInValue(procIndex1, "deptcode",			_IssueDeskPrintTransVO.getStrDeptCode(), 27);
								dao.setProcInValue(procIndex1, "treatmentcatg",		_IssueDeskPrintTransVO.getStrTreatmentCat(), 28);
								dao.setProcInValue(procIndex1, "episodecode",		_IssueDeskPrintTransVO.getStrEpisodeCode(), 29);
								dao.setProcInValue(procIndex1, "wardcode",			_IssueDeskPrintTransVO.getStrWardCode(), 30);
								dao.setProcInValue(procIndex1, "addmissionno",		_IssueDeskPrintTransVO.getStrAdmissionNo(), 31);
								dao.setProcInValue(procIndex1, "visitno",			_IssueDeskPrintTransVO.getStrVisitNo(), 32);								
								dao.setProcOutValue(procIndex1, "err",				1, 33); // 22
								dao.execute(procIndex1,1);
									
							}  // End For Loop
						}
						else
						{
							
							System.out.println("------- Auto Deduct From Stock  -------");
							
							System.out.println("---Param Value--["+i+"]----"+_IssueDeskPrintTransVO.getStrItemParamValue()[i]);
							
							temp 				= _IssueDeskPrintTransVO.getStrItemParamValue()[i].replace('@', '#').split("#");
							strItemBrandId 		= temp[1];
							strItemId 			= temp[0];
							strRate 			= temp[6];						
							strGroupId 			= temp[7];
							strSubGroupId 		= "";
							if(temp[5].equals("-1") || (temp[5]=="-1"))
							{
							    strBatchSlNo 		= "0";
							}
							else
							{
								strBatchSlNo 		= temp[5];	
							}
							//strBatchSlNo 		= temp[5];						
							strIssueQty 		= _IssueDeskPrintTransVO.getStrIssueQuantity()[i].split(" ")[0];
							strStoreId 			= _IssueDeskPrintTransVO.getStrStoreId();
							hosp_code 			= _IssueDeskPrintTransVO.getStrHospitalCode();
							strItemSlNo 		= "0";
							strStockStatus 		= "10";						
							strConsumableFlag 	= "1";
							strRemarks 			= _IssueDeskPrintTransVO.getStrRemarks();						
							strIssueUnitId 		= temp[3];
																		
							System.out.println("---B------"+proc_name1+"---[ Mode -1 ]---"+i+"---");
													
							procIndex1 = dao.setProcedure(proc_name1);										
							dao.setProcInValue(procIndex1, "modval", 			"1", 		1); 
							dao.setProcInValue(procIndex1, "strItemBrandId",	strItemBrandId, 2); // 1
							dao.setProcInValue(procIndex1, "strItemId", 		strItemId, 3); // 2
							dao.setProcInValue(procIndex1, "strRate", 			strRate, 4); // 3
							dao.setProcInValue(procIndex1, "strRateUnitId",		strRateUnitId, 5); // 4
							dao.setProcInValue(procIndex1, "strGroupId", 		strGroupId, 6); // 5?
							dao.setProcInValue(procIndex1, "strSubGroupId",		strSubGroupId, 7); // 6?
							dao.setProcInValue(procIndex1, "strBatchSlNo",		strBatchSlNo, 8); // 7
							dao.setProcInValue(procIndex1, "strExpiryDate",		strExpiryDate.trim(), 9); // 8
							dao.setProcInValue(procIndex1, "strIssueQty", 		strIssueQty,10);
							dao.setProcInValue(procIndex1, "strIssueUnitId",	strIssueUnitId, 11); // 10
							dao.setProcInValue(procIndex1, "strStoreId", 		strStoreId, 12); // 11
							dao.setProcInValue(procIndex1, "strIssueNo", 		strIssueNo, 13); // 12
							dao.setProcInValue(procIndex1, "hosp_code", 		hosp_code, 14); // 13
							dao.setProcInValue(procIndex1, "strItemSlNo", 		strItemSlNo,15); // 14
							dao.setProcInValue(procIndex1, "strStockStatus",	strStockStatus, 16); // 15
							dao.setProcInValue(procIndex1, "strManuFactDate",	strManuFactDate.trim(), 17); // 16
							dao.setProcInValue(procIndex1, "strConsumableFlag",	strConsumableFlag, 18); // 17
							dao.setProcInValue(procIndex1, "strRemarks", 		strRemarks, 19); // 18
							dao.setProcInValue(procIndex1, "strItemCost",		Double.toString(Math.round((Double.parseDouble(strIssueQty)*Double.parseDouble(strRate))*100.0)/100.0),20); // 19?
							dao.setProcInValue(procIndex1, "strRequestNo",		_IssueDeskPrintTransVO.getStrLpRequestNo(), 21); // 20?
							dao.setProcInValue(procIndex1, "strRasingStoreId",	_IssueDeskPrintTransVO.getStrRaisingStoreId(), 22);
							dao.setProcInValue(procIndex1, "strItemCatNo",		_IssueDeskPrintTransVO.getStrItemCategNo(), 23); // 21
							dao.setProcInValue(procIndex1, "strSeatid",			_IssueDeskPrintTransVO.getStrSeatId(), 24);
							dao.setProcInValue(procIndex1, "strDescription",	_IssueDeskPrintTransVO.getStrDescription(), 25);
							dao.setProcInValue(procIndex1, "crno",				_IssueDeskPrintTransVO.getStrCrNo(), 26);								
							dao.setProcInValue(procIndex1, "deptcode",			_IssueDeskPrintTransVO.getStrDeptCode(), 27);
							dao.setProcInValue(procIndex1, "treatmentcatg",		_IssueDeskPrintTransVO.getStrTreatmentCat(), 28);
							dao.setProcInValue(procIndex1, "episodecode",		_IssueDeskPrintTransVO.getStrEpisodeCode(), 29);
							dao.setProcInValue(procIndex1, "wardcode",			_IssueDeskPrintTransVO.getStrWardCode(), 30);
							dao.setProcInValue(procIndex1, "addmissionno",		_IssueDeskPrintTransVO.getStrAdmissionNo(), 31);
							dao.setProcInValue(procIndex1, "visitno",			_IssueDeskPrintTransVO.getStrVisitNo(), 32);								
							dao.setProcOutValue(procIndex1, "err",				1, 33); // 22
							dao.execute(procIndex1,1);
						}
					}
							
					
				}
				  
			} // For Loop End Here							
						
			if (_IssueDeskPrintTransVO.getStrItemParamValue().length != 0) 
			{
				System.out.println("------- Insert Into Issue & Issue Item Table  ---- Start ---");
				
				for (int i = 0; i < _IssueDeskPrintTransVO.getStrItemParamValue().length; i++) 
				{
					        strIssueQty = _IssueDeskPrintTransVO.getStrIssueQuantity()[i].split(" ")[0];
				
							i=length;
							proc_name1 = "";
							proc_name1 = "{call pkg_mms_dml.dml_hstt_patemp_issue_new_dtl(?,?,?,?,?   , ?,?,?,?,? , ?,?,?,?,?   ,?,?,?,?,?   ,?,?,?,?,?   ,?,?,?,?,?   ,?,?,?)}";
											
							System.out.println("----C -----pkg_mms_dml.dml_hstt_patemp_issue_new_dtl---[ Mode -1 ]------");
							
							procIndex3 = dao.setProcedure(proc_name1);
							
							dao.setProcInValue(procIndex3, "modval",            "1", 		1);
							dao.setProcInValue(procIndex3, "strIssueNo", 		strIssueNo, 2); // 1
							dao.setProcInValue(procIndex3, "hosp_code", 		_IssueDeskPrintTransVO.getStrHospitalCode(), 3); // 2
							dao.setProcInValue(procIndex3, "strStoreId",		_IssueDeskPrintTransVO.getStrStoreId(), 4); // 3
							dao.setProcInValue(procIndex3, "strRemarks", 		strRemarks, 5); // 18
							dao.setProcInValue(procIndex3, "strFinalCost",		_IssueDeskPrintTransVO.getStrFinalCost(), 6); // 4
							dao.setProcInValue(procIndex3, "strRequestNo",		_IssueDeskPrintTransVO.getStrLpRequestNo(), 7); // 5
							dao.setProcInValue(procIndex3, "strRequestDate",	_IssueDeskPrintTransVO.getStrRequestDate(), 8); // 6
							dao.setProcInValue(procIndex3, "strCrNo",			_IssueDeskPrintTransVO.getStrCrNo(), 9); // 7
							dao.setProcInValue(procIndex3, "strReqTypeId",		_IssueDeskPrintTransVO.getStrRequestTypeId(), 10);// 8
							dao.setProcInValue(procIndex3, "strAdmNo",			_IssueDeskPrintTransVO.getStrAdmissionNo(), 11); // 9
							dao.setProcInValue(procIndex3, "strEmpNo",			_IssueDeskPrintTransVO.getStrEmpNo(), 12); // 10
							dao.setProcInValue(procIndex3, "strItemCatNo",		_IssueDeskPrintTransVO.getStrItemCategNo(), 13); // 11
							dao.setProcInValue(procIndex3, "strFinStartDate",	_IssueDeskPrintTransVO.getStrFinStartDate(), 14); // 12
							dao.setProcInValue(procIndex3, "strFinEndDate",		_IssueDeskPrintTransVO.getStrFinEndDate(), 15); // 13
							dao.setProcInValue(procIndex3, "strSeatId",			_IssueDeskPrintTransVO.getStrSeatId(), 16); // 14
							dao.setProcInValue(procIndex3, "strRaisingStoreId",_IssueDeskPrintTransVO.getStrRaisingStoreId(), 17); // 15
							dao.setProcInValue(procIndex3, "strIssueQty", 		strIssueQty, 18);
							dao.setProcInValue(procIndex3, "strIssueUnitId", 	strIssueUnitId, 19); // 17
							
							dao.setProcInValue(procIndex3, "strDeptCode",		_IssueDeskPrintTransVO.getStrDeptCode(), 20);
							dao.setProcInValue(procIndex3, "strDeptUnitCode",	_IssueDeskPrintTransVO.getStrDeptUnitCode(), 21);
							dao.setProcInValue(procIndex3, "strWardCode",		_IssueDeskPrintTransVO.getStrWardCode(), 22);
							dao.setProcInValue(procIndex3, "strEpisodeCode",	_IssueDeskPrintTransVO.getStrEpisodeCode(), 23);
							dao.setProcInValue(procIndex3, "strVisitNo",		_IssueDeskPrintTransVO.getStrVisitNo(), 24);
							dao.setProcInValue(procIndex3, "strVisitType",		_IssueDeskPrintTransVO.getStrVisitType(), 25);
							dao.setProcInValue(procIndex3, "strRecieveBy",		_IssueDeskPrintTransVO.getStrReceivedby(), 26);
							dao.setProcInValue(procIndex3, "strOrderBy", 		"", 27);
							dao.setProcInValue(procIndex3, "strOrderDate", 		"", 28);
							dao.setProcInValue(procIndex3, "days",				"", 29);
							dao.setProcInValue(procIndex3, "strPoNo",			_IssueDeskPrintTransVO.getStrPoNo(), 30);
							dao.setProcInValue(procIndex3, "strPoStoreId",		_IssueDeskPrintTransVO.getStrPoStoreId(), 31);
							dao.setProcInValue(procIndex3, "strBsReqNo", 		bsReqNo, 32);
							dao.setProcOutValue(procIndex3, "err", 				1, 33);
							dao.execute(procIndex3, 1);
											
						
					
				}
				
				System.out.println("------- Insert Into Issue & Issue Item Table  ---- End ---");
			}
						
			
			 System.out.println("-------------  IssueDeskPrintTransDAO . insertData  --------END ------");
				
			
			
			dao.fire();
			//dao.getString(procIndex1, "err");
			//dao.getString(procIndex3, "err");
			
			_IssueDeskPrintTransVO.setStrIssueNo(strIssueNo);
			
		}						
		catch (Exception _err) 
		{
			
			_err.printStackTrace();
			_IssueDeskPrintTransVO.setStrMsgString("IssueDeskPrintTransDAO.insertData() --> "+ _err.getMessage());
			_IssueDeskPrintTransVO.setStrMsgType("1");
		}
	}
	
	
	public static void insertData(IssueDeskPrintTransVO _IssueDeskPrintTransVO) 
	{
		String proc_name1 = "{call pkg_mms_dml.Dml_hstt_patemp_issue_item_dtl_new(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,?, ?,?,?,?,? ,?,?)}";
		String strProcName5 = "{call pkg_mms_view.proc_stock_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";
		HisDAO dao = null;
		int procIndex1 = 0;
		int procIndex3 = 0;
		int procIndex4 = 0;
		int length = 0;
		String temp[] = null;
		String strItemBrandId = "";
		String strItemId = "";
		String strRate = "";
		String strRateUnitId = "";
		String strGroupId = "";
		String strSubGroupId = "";
		String strBatchSlNo = "";
		String strExpiryDate = "";
		String strIssueQty = "";
		String strStoreId = "";
		String strIssueNo = "";
		String hosp_code = "";
		String strItemSlNo = "";
		String strStockStatus = "";
		String strManuFactDate = "";
		String strConsumableFlag = "1";
		String strRemarks = "";
		String strItemCost = "";
		int funcIndex;
		String strIssueUnitId = "0";
		int batchLength;
		String strBillTariff = "";
		String strBillBatch = "";
		String strBillRate = "";
		String strBillQty = ""; //commented by shalini bcz issue qty was different from billed qty(issue reported from AIIMSP)
		String                       values[] = null;
		String bsReqNo="0";
		int pIndex;
		String p_name="";
		int nProcIndex = 0;
		WebRowSet ws = null;
		String strErr = "";
		
		MmsConfigUtil mcu;
		
		try 
		{
			System.out.println("---------IssueDeskPrintTransDAO.insertData---------");
			
			mcu =new MmsConfigUtil(_IssueDeskPrintTransVO.getStrHospitalCode());
			dao = new HisDAO("mms","IssueDeskPrintTransDAO.insertData(_IssueDeskPrintTransVO)");
			length = _IssueDeskPrintTransVO.getStrItemParamValue().length;
			
			System.out.println("---------MMS_MST.generate_issueNo---------");
			
			System.out.println("---------RequestTypeId------"+_IssueDeskPrintTransVO.getStrRequestTypeId());
			System.out.println("--------[31- Issue To Store  , 35 - Issue To Pateint IPD , 32 - Issue To Patient Direct ]-------");

			funcIndex = dao.setFunction("{? = call MMS_MST.generate_issueNo(?,?,?,?)}");

			dao.setFuncInValue(funcIndex, 2,_IssueDeskPrintTransVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3,_IssueDeskPrintTransVO.getStrStoreId());
			dao.setFuncInValue(funcIndex, 4,_IssueDeskPrintTransVO.getStrRequestTypeId());
			dao.setFuncInValue(funcIndex, 5,_IssueDeskPrintTransVO.getStrItemCategNo());
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			strIssueNo = dao.getFuncString(funcIndex); 
			
			System.out.println("---------strIssueNo------"+strIssueNo);
			
			_IssueDeskPrintTransVO.setStrIssueNo(strIssueNo);
			temp = _IssueDeskPrintTransVO.getStrItemParamValue()[0].replace('@','#').split("#");
			strIssueUnitId = temp[3];
			strRateUnitId = temp[3];
			strIssueQty = temp[2];
			
			
			proc_name1="";
			
			
			proc_name1 = "{call pkg_mms_dml.Dml_hstt_patemp_issue_item_dtl_new(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,?, ?,?,?,?,? ,?,?)}";
			for (int i = 0; i < _IssueDeskPrintTransVO.getStrItemParamValue().length; i++) 
			{
				if (!_IssueDeskPrintTransVO.getStrIssueQuantity()[i].equals("0") && !_IssueDeskPrintTransVO.getStrIssueQuantity()[i].equals("0.00") ) 
				{					
					if (_IssueDeskPrintTransVO.getStockDtlsId()!=null)
					{
						if (!_IssueDeskPrintTransVO.getStockDtlsId()[i].equals("")) 
						{
							
							  System.out.println("------- When Batch Selected From Stock  -------");
								
							values = _IssueDeskPrintTransVO.getStockDtlsId()[i].split("#"); 
		                    //    0       1         		2			3	            4        5         6           7                8               9               10                  11              12      13          14           15          16   17  18      19       
							// StoreId^Generic_ItemId^Brand_ItemId^Stock_Status_Code^Batch_No^Serial_No^Expiry date^Manufactre Date^In Hand Qty ^ In Hand Qty Unit ^ Purchase Rate ^ Purchase Rate Unit ^ Rate ^ Rate Unit ^ Issue Qty ^ Issue Qty Unit ^   ^   ^ Cost ^ Cost
							// 99901120^10000067^10100067^UIT11738^10^0^31-May-2014^01-Dec-2011^24990^6301^21.54^6306^22.62^6306^10^6301^1^0^2.26^2.26
							batchLength = values.length;
							for (int j = 0; j < batchLength; j++) 
							{
									temp = values[j].replace("^", "#").split("#");
									strItemBrandId = temp[2];
									strItemId = temp[1];
									strRate=temp[12];
									strRateUnitId=temp[13];							
									strGroupId = "";
									strSubGroupId = "";
									strBatchSlNo = temp[3];
									strExpiryDate = temp[6].trim();								
									strIssueQty = temp[14];
									strStoreId = _IssueDeskPrintTransVO.getStrStoreId();
									hosp_code = _IssueDeskPrintTransVO.getStrHospitalCode();
									strItemSlNo = "0";
									strStockStatus = "10";
									strManuFactDate = temp[7];
									strConsumableFlag = "1";
									strRemarks = _IssueDeskPrintTransVO.getStrRemarks();								
									strIssueUnitId = temp[15];
			
									
							    	System.out.println("---C------"+strProcName5+"---[ Mode -1 ]---"+i+"---Brand Id-["+strItemBrandId+"/"+strBatchSlNo+"]--");
								
									nProcIndex = dao.setProcedure(strProcName5);
									dao.setProcInValue(nProcIndex, "modeval", 			"1", 1);
									dao.setProcInValue(nProcIndex, "store_id",			strStoreId, 2);
									dao.setProcInValue(nProcIndex, "catcode",			_IssueDeskPrintTransVO.getStrItemCategNo(),3);
									dao.setProcInValue(nProcIndex, "item_id", 			strItemId, 4);
									dao.setProcInValue(nProcIndex, "itembrand_id",		strItemBrandId, 5);
									dao.setProcInValue(nProcIndex, "batch_no", 			strBatchSlNo, 6);
									dao.setProcInValue(nProcIndex, "stock_status",		"10", 7);
									dao.setProcInValue(nProcIndex, "hosp_code", 		_IssueDeskPrintTransVO.getStrHospitalCode(), 8);
									dao.setProcInValue(nProcIndex, "itemslno", 			"0", 9);
									dao.setProcInValue(nProcIndex, "reservedstockflag", "0", 10);
									dao.setProcInValue(nProcIndex, "blockedqtyflag", 	"0", 11);
									dao.setProcOutValue(nProcIndex, "err", 				 1, 12);
									dao.setProcOutValue(nProcIndex, "resultset",		 2, 13);
									
									dao.executeProcedureByPosition(nProcIndex);
	
									strErr = dao.getString(nProcIndex, "err");
	
									if (strErr == null)
										strErr = "";
	
									ws = dao.getWebRowSet(nProcIndex, "resultset");
									
									//System.out.println("ws::::::::::::::==="+ws.size());
									float addQty=(float) 0.00;
									float issueqty=Float.parseFloat(strIssueQty);
									if(ws.size()>0 && ws!=null)
									{
										
										while(ws.next() && issueqty > 0.00)
										{
											//System.out.println("In Hand qTY :::::::::::"+ ws.getString(20));
											if( issueqty > Float.parseFloat(ws.getString(20)) )
											{
												addQty=Float.parseFloat(ws.getString(20));
												strRate=ws.getString(38);
												strBatchSlNo=ws.getString(15);
												//break ; 
											}else
											{
												addQty=issueqty; 
												strRate=ws.getString(38);
												strBatchSlNo=ws.getString(15);
												//System.out.println("strIssueQty"+issueqty);
											}
											issueqty =issueqty - addQty;
											
											if(strBillTariff != null && strBillTariff != "")
												strBillTariff=strBillTariff + "^"+strItemBrandId;
												else
													strBillTariff = strItemBrandId;
											
												if(strBillRate != null && strBillRate != "")
													strBillRate=strBillRate + "^"+strRate;
													else
														strBillRate = strRate;
												
												if(strBillQty != null && strBillQty != "")
													strBillQty=strBillQty + "^"+strIssueQty;
													else
														strBillQty = String.valueOf(strIssueQty);
												
												if(strBillBatch != null && strBillBatch != "")
													strBillBatch=strBillBatch + "^"+strBatchSlNo;
													else
														strBillBatch = strBatchSlNo;
												
									
										
											System.out.println("---E------"+proc_name1+"---[ Mode -1 ]---"+i+"---");
											
											System.out.println("strIssueNo----------"+strIssueNo);
											
											procIndex1 = dao.setProcedure(proc_name1);
						
											dao.setProcInValue(procIndex1, "modval", "1", 		1); // Default
																								// Value.
											dao.setProcInValue(procIndex1, "strItemBrandId",	strItemBrandId, 2); // 1
											dao.setProcInValue(procIndex1, "strItemId", 		strItemId, 3); // 2
											dao.setProcInValue(procIndex1, "strRate", 			strRate, 4); // 3
											dao.setProcInValue(procIndex1, "strRateUnitId",		strRateUnitId, 5); // 4
											dao.setProcInValue(procIndex1, "strGroupId", 		strGroupId, 6); // 5?
											dao.setProcInValue(procIndex1, "strSubGroupId",		strSubGroupId, 7); // 6?
											dao.setProcInValue(procIndex1, "strBatchSlNo",		strBatchSlNo, 8); // 7
											dao.setProcInValue(procIndex1, "strExpiryDate",		strExpiryDate.trim(), 9); // 8
											dao.setProcInValue(procIndex1, "strIssueQty", 		String.valueOf(addQty),10);
											dao.setProcInValue(procIndex1, "strIssueUnitId",	strIssueUnitId, 11); // 10
											dao.setProcInValue(procIndex1, "strStoreId", 		strStoreId, 12); // 11
											dao.setProcInValue(procIndex1, "strIssueNo", 		strIssueNo, 13); // 12
											dao.setProcInValue(procIndex1, "hosp_code", 		hosp_code, 14); // 13
											dao.setProcInValue(procIndex1, "strItemSlNo", 		strItemSlNo,15); // 14
											dao.setProcInValue(procIndex1, "strStockStatus",	strStockStatus, 16); // 15
											dao.setProcInValue(procIndex1, "strManuFactDate",	strManuFactDate.trim(), 17); // 16
											dao.setProcInValue(procIndex1, "strConsumableFlag",	strConsumableFlag, 18); // 17
											dao.setProcInValue(procIndex1, "strRemarks", 		strRemarks, 19); // 18
											dao.setProcInValue(procIndex1, "strItemCost",		Double.toString(Math.round((Double.parseDouble(strIssueQty)*Double.parseDouble(strRate))*100.0)/100.0),20); // 19?
											dao.setProcInValue(procIndex1, "strRequestNo",		_IssueDeskPrintTransVO.getStrLpRequestNo(), 21); // 20?
											dao.setProcInValue(procIndex1, "strRasingStoreId",	_IssueDeskPrintTransVO.getStrRaisingStoreId(), 22);
											dao.setProcInValue(procIndex1, "strItemCatNo",		_IssueDeskPrintTransVO.getStrItemCategNo(), 23); // 21
											dao.setProcInValue(procIndex1, "strSeatid",			_IssueDeskPrintTransVO.getStrSeatId(), 24);
											dao.setProcInValue(procIndex1, "strDescription",	_IssueDeskPrintTransVO.getStrDescription(), 25);
											dao.setProcInValue(procIndex1, "crno",				_IssueDeskPrintTransVO.getStrCrNo(), 26);
											dao.setProcOutValue(procIndex1, "err",				1, 27); // 22
											dao.execute(procIndex1,1);
											
										
											}
									}
								}
						}
						else
						{
							
								    System.out.println("------- Auto Deduct From Stock  -------");
								 
									temp = _IssueDeskPrintTransVO.getStrItemParamValue()[i].replace('@', '#').split("#");
									strItemBrandId = temp[1];
									strItemId = temp[0];
									strRate = temp[6];								
									strGroupId = temp[7];
									strSubGroupId = "";
									strBatchSlNo = temp[5];								
									strIssueQty = _IssueDeskPrintTransVO.getStrIssueQuantity()[i].split(" ")[0];
									strStoreId = _IssueDeskPrintTransVO.getStrStoreId();
									hosp_code = _IssueDeskPrintTransVO.getStrHospitalCode();
									strItemSlNo = "0";
									strStockStatus = "10";								
									strConsumableFlag = "1";
									strRemarks = _IssueDeskPrintTransVO.getStrRemarks();									
									strIssueUnitId = temp[3];
										
								
									if(Double.parseDouble(_IssueDeskPrintTransVO.getStrIssueQuantity()[i].split(" ")[0]) > 0.0)
									{
										
										System.out.println("---F------"+strProcName5+"---[ Mode -1 ]--Brand Id-["+strItemBrandId+"]--");
										
										nProcIndex = dao.setProcedure(strProcName5);
										dao.setProcInValue(nProcIndex, "modeval", 			"1", 1);
										dao.setProcInValue(nProcIndex, "store_id",			strStoreId, 2);
										dao.setProcInValue(nProcIndex, "catcode",			_IssueDeskPrintTransVO.getStrItemCategNo(),3);
										dao.setProcInValue(nProcIndex, "item_id", 			strItemId, 4);
										dao.setProcInValue(nProcIndex, "itembrand_id",		strItemBrandId, 5);
										dao.setProcInValue(nProcIndex, "batch_no", 			"0", 6);
										dao.setProcInValue(nProcIndex, "stock_status",		"10", 7);
										dao.setProcInValue(nProcIndex, "hosp_code", 		_IssueDeskPrintTransVO.getStrHospitalCode(), 8);
										dao.setProcInValue(nProcIndex, "itemslno", 			"0", 9);
										dao.setProcInValue(nProcIndex, "reservedstockflag", "0", 10);
										dao.setProcInValue(nProcIndex, "blockedqtyflag", 	"0", 11);
										dao.setProcOutValue(nProcIndex, "err", 				 1, 12);
										dao.setProcOutValue(nProcIndex, "resultset", 		 2, 13);
										
										dao.executeProcedureByPosition(nProcIndex);

										strErr = dao.getString(nProcIndex, "err");

										if (strErr == null)
											strErr = "";

										ws = dao.getWebRowSet(nProcIndex, "resultset");
										
										////System.out.println("ws::::::::::::::==="+ws.size());
										float addQty=(float) 0.00;
										float issueqty=Float.parseFloat(strIssueQty);
										if(ws.size()>0 && ws!=null)
										{
											
											while(ws.next() && issueqty > 0.00)
											{
											//	//System.out.println("In Hand qTY :::::::::::"+ ws.getString(20));
												if( issueqty > Float.parseFloat(ws.getString(20)) )
												{
													addQty=Float.parseFloat(ws.getString(20));
													strRate=ws.getString(38);
													strBatchSlNo=ws.getString(15);
													//break ; 
												}
												else
												{
													addQty=issueqty; 
													strRate=ws.getString(38);
													strBatchSlNo=ws.getString(15);
													//System.out.println("strIssueQty"+issueqty);
												}
												issueqty =issueqty - addQty;
												
												if(strBillTariff != null && strBillTariff != "")
													strBillTariff=strBillTariff + "^"+strItemBrandId;
													else
														strBillTariff = strItemBrandId;
												
													if(strBillRate != null && strBillRate != "")
														strBillRate=strBillRate + "^"+strRate;
														else
															strBillRate = strRate;
													
													if(strBillQty != null && strBillQty != "")
														strBillQty=strBillQty + "^"+addQty;
														else
															strBillQty = String.valueOf(addQty);
													
													if(strBillBatch != null && strBillBatch != "")
														strBillBatch=strBillBatch + "^"+strBatchSlNo;
														else
															strBillBatch = strBatchSlNo;
													
												System.out.println("---G------"+proc_name1+"---[ Mode -1 ]------");
												
												System.out.println("strIssueNo----------"+strIssueNo);
												
												procIndex1 = dao.setProcedure(proc_name1);
							
												dao.setProcInValue(procIndex1, "modval", 			"1", 1); // Default
																									// Value.
												dao.setProcInValue(procIndex1, "strItemBrandId",	strItemBrandId, 2); // 1
												dao.setProcInValue(procIndex1, "strItemId", 		strItemId, 3); // 2
												dao.setProcInValue(procIndex1, "strRate", 			strRate, 4); // 3
												dao.setProcInValue(procIndex1, "strRateUnitId",		strRateUnitId, 5); // 4
												dao.setProcInValue(procIndex1, "strGroupId", 		strGroupId, 6); // 5?
												dao.setProcInValue(procIndex1, "strSubGroupId",		strSubGroupId, 7); // 6?
												dao.setProcInValue(procIndex1, "strBatchSlNo",		strBatchSlNo, 8); // 7
												dao.setProcInValue(procIndex1, "strExpiryDate",		strExpiryDate.trim(), 9); // 8
												dao.setProcInValue(procIndex1, "strIssueQty", 		String.valueOf(addQty),10);
												dao.setProcInValue(procIndex1, "strIssueUnitId",	strIssueUnitId, 11); // 10
												dao.setProcInValue(procIndex1, "strStoreId", 		strStoreId, 12); // 11
												dao.setProcInValue(procIndex1, "strIssueNo", 		strIssueNo, 13); // 12
												dao.setProcInValue(procIndex1, "hosp_code", 		hosp_code, 14); // 13
												dao.setProcInValue(procIndex1, "strItemSlNo", 		strItemSlNo,15); // 14
												dao.setProcInValue(procIndex1, "strStockStatus",	strStockStatus, 16); // 15
												dao.setProcInValue(procIndex1, "strManuFactDate",	strManuFactDate.trim(), 17); // 16
												dao.setProcInValue(procIndex1, "strConsumableFlag", strConsumableFlag, 18); // 17
												dao.setProcInValue(procIndex1, "strRemarks", 		strRemarks, 19); // 18
												dao.setProcInValue(procIndex1, "strItemCost",		Double.toString(Math.round((Double.parseDouble(String.valueOf(addQty))*Double.parseDouble(strRate))*100.0)/100.0),20); // 19?
												dao.setProcInValue(procIndex1, "strRequestNo",		_IssueDeskPrintTransVO.getStrLpRequestNo(), 21); // 20?
												dao.setProcInValue(procIndex1, "strRasingStoreId",	_IssueDeskPrintTransVO.getStrRaisingStoreId(), 22);
												dao.setProcInValue(procIndex1, "strItemCatNo",		_IssueDeskPrintTransVO.getStrItemCategNo(), 23); // 21
												dao.setProcInValue(procIndex1, "strSeatid",			_IssueDeskPrintTransVO.getStrSeatId(), 24);
												dao.setProcInValue(procIndex1, "strDescription",	_IssueDeskPrintTransVO.getStrDescription(), 25);
												dao.setProcInValue(procIndex1, "crno", 				_IssueDeskPrintTransVO.getStrCrNo(),26);
												dao.setProcOutValue(procIndex1, "err", 				1, 27); // 22
												dao.execute(procIndex1,1);
												
												
									  }  // Issue Qty  > 0
									} // Size > 0 
								}
							}
						}
							
					
					}
				    			
			} // For Loop End Here			
			
					int procIndex2;
					
					System.out.println("-------------------------- BILLING START HERE --------------------------------");		
					System.out.println("---J------bill_interface.dml_online_billreq_drugs---[ Mode -1 ]------");
					
					System.out.println("--------------------------------");		
					System.out.println("strBillTariff:::::"+strBillTariff);
					System.out.println("strBillRate:::::"+strBillRate);
					System.out.println("strBillQty:::::"+strBillQty);
					System.out.println("strBillBatch:::::"+strBillBatch);
					System.out.println("--------------------------------");			
					//System.out.println("gnum_dept_code"+_IssueDeskPrintTransVO.getStrDeptCode());
					//System.out.println("gnum_treatment_cat"+_IssueDeskPrintTransVO.getStrTreatmentCat());
					//System.out.println("hrgnum_episode_code"+_IssueDeskPrintTransVO.getStrEpisodeCode());
					//System.out.println("hrgnum_puk"+_IssueDeskPrintTransVO.getStrCrNo());
					//System.out.println("gnum_seatid"+_IssueDeskPrintTransVO.getStrSeatId());
					//System.out.println("hosp_code"+_IssueDeskPrintTransVO.getStrHospitalCode());
					//System.out.println("ward_code"+_IssueDeskPrintTransVO.getStrWardCode());
					//System.out.println("admno"+_IssueDeskPrintTransVO.getStrAdmissionNo());
					//System.out.println("visitno"+_IssueDeskPrintTransVO.getStrVisitNo());
				    //System.out.println("strBillRate------"+strBillRate);
					
					String proc_name2 = "{call bill_interface.dml_online_billreq_drugs(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}";
					procIndex2 = dao.setProcedure(proc_name2);
					dao.setProcInValue(procIndex2, "modval", 					"1", 1); // 1
					dao.setProcInValue(procIndex2, "gnum_dept_code", 			_IssueDeskPrintTransVO.getStrDeptCode(), 2);					
					dao.setProcInValue(procIndex2, "sblnum_chargetype_id", 		"2", 3);
					dao.setProcInValue(procIndex2, "sblnum_service_id", 		"5", 4);
					dao.setProcInValue(procIndex2, "gstr_req_no", 				strIssueNo, 5);
					dao.setProcInValue(procIndex2, "gnum_treatment_cat", 		_IssueDeskPrintTransVO.getStrTreatmentCat(),6);					
					dao.setProcInValue(procIndex2, "hrgnum_episode_code", 		_IssueDeskPrintTransVO.getStrEpisodeCode(), 7);					
					dao.setProcInValue(procIndex2, "hrgnum_puk", 				_IssueDeskPrintTransVO.getStrCrNo(), 8);					
					dao.setProcInValue(procIndex2, "hblnum_pat_lfaccount_no", 	"0", 9);
					dao.setProcInValue(procIndex2, "gstr_tariff", 				strBillTariff, 10);
					dao.setProcInValue(procIndex2, "gstr_tariff_batch", 		strBillBatch, 11);
					dao.setProcInValue(procIndex2, "gstr_tariff_rates", 		strBillRate, 12);
					dao.setProcInValue(procIndex2, "gstr_reqqty", 				strBillQty, 13);
					dao.setProcInValue(procIndex2, "hblstr_patient_name", 		"", 14);
					dao.setProcInValue(procIndex2, "hblstr_pat_address", 		"", 15);
					dao.setProcInValue(procIndex2, "hblstr_contact_no", 		"", 16);
					dao.setProcInValue(procIndex2, "age", 						"1", 17);
					dao.setProcInValue(procIndex2, "ageunit", 					"1", 18);
					dao.setProcInValue(procIndex2, "gender", 					"1", 19);
					dao.setProcInValue(procIndex2, "refdoctor",					"1", 20);
					dao.setProcInValue(procIndex2, "refdoccontactno", 			"1", 21);
					dao.setProcInValue(procIndex2, "gnum_seatid", 				_IssueDeskPrintTransVO.getStrSeatId(), 22);					
					dao.setProcInValue(procIndex2, "hosp_code", 				_IssueDeskPrintTransVO.getStrHospitalCode(), 23);					
					dao.setProcInValue(procIndex2, "ward_code", 				_IssueDeskPrintTransVO.getStrWardCode(), 24);					
					dao.setProcInValue(procIndex2, "admno", 					_IssueDeskPrintTransVO.getStrAdmissionNo(), 25);					
					dao.setProcInValue(procIndex2, "visitno", 					_IssueDeskPrintTransVO.getStrVisitNo(), 26);					
					dao.setProcOutValue(procIndex2, "err",                      1, 27);					
					dao.execute(procIndex2, 1);
							
			
			System.out.println("-------------------------- BILLING END HERE --------------------------------");				
						
			if (_IssueDeskPrintTransVO.getStrItemParamValue().length != 0) 
			{
				System.out.println("------- Insert Into Issue & Issue Item Table  ---- Start ---");
				
				for (int i = 0; i < _IssueDeskPrintTransVO.getStrItemParamValue().length; i++) 
				{
					    strIssueQty = _IssueDeskPrintTransVO.getStrIssueQuantity()[i].split(" ")[0];
				
							
						if(!strIssueQty.equals("0.00") && !strIssueQty.equals("0"))
						{
							i=length;
							proc_name1 = "";
							proc_name1 = "{call pkg_mms_dml.Dml_hstt_patemp_issue_dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?)}";
				
							System.out.println("----A -----pkg_mms_dml.Dml_hstt_patemp_issue_dtl---[ Mode -1 ]------");
							
							procIndex3 = dao.setProcedure(proc_name1);
							dao.setProcInValue(procIndex3, "strIssueNo", 		strIssueNo, 2); // 1
							dao.setProcInValue(procIndex3, "hosp_code", 		_IssueDeskPrintTransVO.getStrHospitalCode(), 3); // 2
							dao.setProcInValue(procIndex3, "strStoreId",		_IssueDeskPrintTransVO.getStrStoreId(), 4); // 3
							dao.setProcInValue(procIndex3, "strFinalCost",		_IssueDeskPrintTransVO.getStrFinalCost(), 6); // 4
							dao.setProcInValue(procIndex3, "strRequestNo",		_IssueDeskPrintTransVO.getStrLpRequestNo(), 7); // 5
							dao.setProcInValue(procIndex3, "strRequestDate",	_IssueDeskPrintTransVO.getStrRequestDate(), 8); // 6
							dao.setProcInValue(procIndex3, "strCrNo",			_IssueDeskPrintTransVO.getStrCrNo(), 9); // 7
							dao.setProcInValue(procIndex3, "strReqTypeId",		_IssueDeskPrintTransVO.getStrRequestTypeId(), 10);// 8
							dao.setProcInValue(procIndex3, "strAdmNo",			_IssueDeskPrintTransVO.getStrAdmissionNo(), 11); // 9
							dao.setProcInValue(procIndex3, "strEmpNo",			_IssueDeskPrintTransVO.getStrEmpNo(), 12); // 10
							dao.setProcInValue(procIndex3, "strItemCatNo",		_IssueDeskPrintTransVO.getStrItemCategNo(), 13); // 11
							dao.setProcInValue(procIndex3, "strFinStartDate",	_IssueDeskPrintTransVO.getStrFinStartDate(), 14); // 12
							dao.setProcInValue(procIndex3, "strFinEndDate",		_IssueDeskPrintTransVO.getStrFinEndDate(), 15); // 13
							dao.setProcInValue(procIndex3, "strSeatId",			_IssueDeskPrintTransVO.getStrSeatId(), 16); // 14
							dao.setProcInValue(procIndex3, "strRaisingStoreId",_IssueDeskPrintTransVO.getStrRaisingStoreId(), 17); // 15
							dao.setProcInValue(procIndex3, "strIssueQty", 		strIssueQty, 18);
							dao.setProcInValue(procIndex3, "strIssueUnitId", 	strIssueUnitId, 19); // 17
							dao.setProcInValue(procIndex3, "strRemarks", 		strRemarks, 5); // 18
							dao.setProcInValue(procIndex3, "strDeptCode",		_IssueDeskPrintTransVO.getStrDeptCode(), 20);
							dao.setProcInValue(procIndex3, "strDeptUnitCode",	_IssueDeskPrintTransVO.getStrDeptUnitCode(), 21);
							dao.setProcInValue(procIndex3, "strWardCode",		_IssueDeskPrintTransVO.getStrWardCode(), 22);
							dao.setProcInValue(procIndex3, "strEpisodeCode",	_IssueDeskPrintTransVO.getStrEpisodeCode(), 23);
							dao.setProcInValue(procIndex3, "strVisitNo",		_IssueDeskPrintTransVO.getStrVisitNo(), 24);
							dao.setProcInValue(procIndex3, "strVisitType",		_IssueDeskPrintTransVO.getStrVisitType(), 25);
							dao.setProcInValue(procIndex3, "strRecieveBy",		_IssueDeskPrintTransVO.getStrReceivedby(), 26);
							dao.setProcInValue(procIndex3, "strPoNo",			_IssueDeskPrintTransVO.getStrPoNo(), 30);
							dao.setProcInValue(procIndex3, "strPoStoreId",		_IssueDeskPrintTransVO.getStrPoStoreId(), 31);
				
							
							dao.setProcInValue(procIndex3, "modval", "1", 		1);
							dao.setProcInValue(procIndex3, "strOrderBy", 	"", 27);
							dao.setProcInValue(procIndex3, "strOrderDate", 	"", 28);
							dao.setProcInValue(procIndex3, "days",			"", 29);
							
				
							dao.setProcInValue(procIndex3, "strBsReqNo", bsReqNo, 32);
							dao.setProcOutValue(procIndex3, "err", 1, 33);
							dao.execute(procIndex3, 1);
				
							proc_name1 = "";
							proc_name1 = "{call pkg_mms_dml.Dml_issue_dtls(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}";
							procIndex4 = dao.setProcedure(proc_name1);
							
							System.out.println("---B------pkg_mms_dml.Dml_issue_dtls---[ Mode -2 ]------");
							
							dao.setProcInValue(procIndex4, "modeval",			 "2", 1);
							dao.setProcInValue(procIndex4, "issuing_store_id",	 _IssueDeskPrintTransVO.getStrStoreId(), 2);
							dao.setProcInValue(procIndex4, "issueNo", 			 strIssueNo, 3); // 1
							dao.setProcInValue(procIndex4, "hospital_code",      _IssueDeskPrintTransVO.getStrHospitalCode(), 4); // 2
							dao.setProcInValue(procIndex4, "category_No",		 _IssueDeskPrintTransVO.getStrItemCategNo(), 5);
							dao.setProcInValue(procIndex4, "indent_No",			 _IssueDeskPrintTransVO.getStrLpRequestNo(), 6); // 5
							dao.setProcInValue(procIndex4, "reqType_id",		 _IssueDeskPrintTransVO.getStrRequestTypeId(), 7);// 8
							dao.setProcInValue(procIndex4, "indent_Date",		 _IssueDeskPrintTransVO.getStrRequestDate(), 8); // 6
							dao.setProcInValue(procIndex4, "raising_store_id",   _IssueDeskPrintTransVO.getStrRaisingStoreId(), 9); // 15
							dao.setProcInValue(procIndex4, "net_cost",			 _IssueDeskPrintTransVO.getStrFinalCost(), 11); // 4
							dao.setProcInValue(procIndex4, "strCrNo",			 _IssueDeskPrintTransVO.getStrCrNo(), 16); // 7
							dao.setProcInValue(procIndex4, "strAmNo",			 _IssueDeskPrintTransVO.getStrAdmissionNo(), 17); // 9
							dao.setProcInValue(procIndex4, "strEmpNo",			 _IssueDeskPrintTransVO.getStrEmpNo(), 18); // 10
							dao.setProcInValue(procIndex4, "fin_start_date",	 _IssueDeskPrintTransVO.getStrFinStartDate(), 12); // 12
							dao.setProcInValue(procIndex4, "fin_end_date",		 _IssueDeskPrintTransVO.getStrFinEndDate(), 13); // 13
							dao.setProcInValue(procIndex4, "seatId",			 _IssueDeskPrintTransVO.getStrSeatId(), 15); // 14
							dao.setProcInValue(procIndex4, "remarks", 			 strRemarks, 14); // 16
							dao.setProcInValue(procIndex4, "receivedBy",		 _IssueDeskPrintTransVO.getStrReceivedby(), 10); // 17
							dao.setProcInValue(procIndex4, "strPoNo",			 _IssueDeskPrintTransVO.getStrPoNo(), 19); // 18
							dao.setProcInValue(procIndex4, "strPoStoreId",		 _IssueDeskPrintTransVO.getStrPoStoreId(), 20); // 19
							dao.setProcInValue(procIndex4, "strBsReqNo",         bsReqNo, 21); // 19
							dao.setProcOutValue(procIndex4, "err", 				 1, 22);
							dao.execute(procIndex4, 1);
							
						
					}	
				}
				
				System.out.println("------- Insert Into Issue & Issue Item Table  ---- End ---");
			}
			
			
			 System.out.println("-------------  IssueDeskPrintTransDAO . insertData  --------END ------");
				
			
			
			dao.fire();
			dao.getString(procIndex1, "err");
			
			_IssueDeskPrintTransVO.setStrIssueNo(strIssueNo);
			
		}						
		catch (Exception _err) 
		{
			
			_err.printStackTrace();
			_IssueDeskPrintTransVO.setStrMsgString("IssueDeskPrintTransDAO.insertData() --> "+ _err.getMessage());
			_IssueDeskPrintTransVO.setStrMsgType("1");
		}
	}

	
	

	/**
	 * This function is used to set details in approved By Combo.
	 * 
	 * @param _BreakageItemDtlTransVO
	 */
	public static void getApprovedByCombo(IssueDeskPrintTransVO _IssueDeskPrintTransVO) {

		String strProcName = "{call PKG_MMS_VIEW.proc_consultant_name(?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		WebRowSet ws = null;
		HisDAO daoObj = null;
		try {
			
			System.out.println("------------- pkg_mms_view.proc_consultant_name  -----[ Mode - 2]---------");
			
			daoObj = new HisDAO("MMSModule", "IssueDeskPrintTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code",
					_IssueDeskPrintTransVO.getStrHospitalCode(), 3);
			daoObj.setProcInValue(nProcIndex, "seatId",
					_IssueDeskPrintTransVO.getStrSeatId(), 4);

			daoObj.setProcInValue(nProcIndex, "deptunitcode", "0", 2); // Default
																		// value.

			daoObj.setProcOutValue(nProcIndex, "err", 1, 5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				_IssueDeskPrintTransVO.setApprovedBy(ws);
			}
		} catch (Exception _err) {
			_IssueDeskPrintTransVO
					.setStrMsgString("IssueDeskPrintTransDAO.getApprovedByCombo() --> "
							+ _err.getMessage());
			_IssueDeskPrintTransVO.setStrMsgType("1");
		}
	}

	public static void getDeptName(IssueDeskPrintTransVO _IssueDeskPrintTransVO) {

		HisDAO dao = null;
		int funcIndex = 0;
		String strDeptName = "";
		try {

			dao = new HisDAO("MMSModule", "IssueDeskPrintTransDAO");
			funcIndex = dao
					.setFunction("{? = call MMS_MST.get_store_dtl(?,?,?)}");
			// Set Value
			
			System.out.println("------------- MMS_MST.get_store_dtl  -----[ Mode - 3]---------");

			dao.setFuncInValue(funcIndex, 2, "3");
			dao.setFuncInValue(funcIndex, 3,
					_IssueDeskPrintTransVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4,
					_IssueDeskPrintTransVO.getStrRaisingStoreId());
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			strDeptName = dao.getFuncString(funcIndex);
			if (strDeptName != null && !strDeptName.equals("null"))
				_IssueDeskPrintTransVO.setStrDeptName(strDeptName);
			else
				_IssueDeskPrintTransVO.setStrDeptName("-");
		} catch (Exception _err) {
			_err.printStackTrace();
			_IssueDeskPrintTransVO
					.setStrMsgString("IssueDeskPrintTransDAO.getDeptName() --> "
							+ _err.getMessage());
			_IssueDeskPrintTransVO.setStrMsgType("1");
		}

	}
	
	/*added by shalini & is used To get the Account info.*/
	public static void getPatientAccountDetails(IssueDeskPrintTransVO vo) {

	
		String strProcName = "{call PKG_MMS_VIEW.proc_hstt_pat_account_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		WebRowSet ws = null;
		HisDAO daoObj = null;
		try {
			 System.out.println("-------------  IssueDeskPrintTransDAO . getPatientAccountDetails  --------------");
				
			 System.out.println("-------------  pkg_mms_view.proc_hstt_pat_account_dtl  ------[Mode - 1]--------");
			 
			daoObj = new HisDAO("MMSModule", "IssueDeskPrintTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(), 2);
			daoObj.setProcInValue(nProcIndex, "cr_no", vo.getStrCrNo(), 3);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 5);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setPatAccountDtl(ws);
			}
		} catch (Exception _err) {
			vo
					.setStrMsgString("IssueDeskPrintTransDAO.getPatientAccountBalance() --> "
							+ _err.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void getPatientDiagDetails(IssueDeskPrintTransVO vo)
	{
		
		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";
		
    	try 
		{
    		
    		System.out.println("-------------  IssueDeskPrintTransDAO . getPatientDiagDetails  --------------");
			
			 System.out.println("-------------  pkg_mms_view.proc_diag_emp_view  ------[Mode - 1]--------");
			 
    		String strProcName = "{call PKG_MMS_VIEW.proc_diag_emp_view(?,?::varchar,?::varchar,?,?)}";

			daoObj = new HisDAO("MMS Transactions","IssueDeskPrintTransDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
     		daoObj.setProcInValue(nProcIndex, "modval", "1",1);
	     	daoObj.setProcInValue(nProcIndex, "crno",vo.getStrCrNo() ,2);
			daoObj.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),3);
						
			daoObj.setProcOutValue(nProcIndex,"err", 1,4);
			daoObj.setProcOutValue(nProcIndex,"resultset", 2,5);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				wb = daoObj.getWebRowSet(nProcIndex, "resultset");
				
				vo.setDiagEmpWs(wb);
				
			} else {
				throw new Exception(strErr);
			}
    		
		
		
		} 
    	catch (Exception e) 
    	{
			vo.setStrMsgString("--> IssueDeskPrintTransDAO.getPatientDiagDetails()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null)
				daoObj.free();
				daoObj = null;
			}

	}

	/**
	 * This function is used to GET THE BATCH WISE ITEM DETAILS FOR POPUP.
	 * 
	 * @param vo
	 *            the vo
	 * @return the single batch item dtl
	 */
	public static void getSingleBatchItemDtl(IssueDeskPrintTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			
			System.out.println("-------------  IssueDeskPrintTransDAO . getSingleBatchItemDtl  --------------");
			
			 System.out.println("-------------  pkg_mms_view.proc_itemStock_dtl  ------[Mode - 6]--------");
			 
			dao = new HisDAO("mms", "IssueDeskPrintTransDAO");
			
			strProcName = "{call Pkg_Mms_View.proc_itemStock_dtl(?,?,?,?,?,?,?,?,?,?,?)}";
			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modeval", "6");
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nProcIndex, "item_id", vo.getStrSingleItemDtl()
					.split("\\^")[0]);
			dao.setProcInValue(nProcIndex, "itembrand_id", vo
					.getStrSingleItemDtl().split("\\^")[1]);
			dao.setProcInValue(nProcIndex, "store_id", vo.getStrSingleItemDtl()
					.split("\\^")[3]);
			dao.setProcInValue(nProcIndex, "batch_no", vo.getStrSingleItemDtl()
					.split("\\^")[2]);
			dao.setProcInValue(nProcIndex, "item_sl_no", "0");
			dao.setProcInValue(nProcIndex, "sl_no", "0");
			dao.setProcInValue(nProcIndex, "reserved_flag", "0");
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);

			dao.executeProcedure(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				vo.setStrSingleBatchDtlWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IssueDeskPrintTransDAO.getSingleBatchItemDtl() --> "
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
	 * This function is used to GET THE BATCH WISE ITEM DETAILS FOR POPUP.
	 * 
	 * @param vo
	 *            the vo
	 * @return the branded/non branded item details
	 */
	public static void getBrandDetails(IssueDeskPrintTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			dao = new HisDAO("mms", "IssueDeskPrintTransDAO");
			
			System.out.println("-------------  IssueDeskPrintTransDAO . getBrandDetails  --------------");
			
			 System.out.println("-------------  pkg_mms_view.proc_brand_list  ------[Mode - 1]--------");
			
			strProcName = "{call Pkg_Mms_View.proc_brand_list(?,?,?,?,? ,?)}";
			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modeval", "1");
			dao.setProcInValue(nProcIndex, "storeid", vo.getStrStoreId());
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nProcIndex, "itemid", vo.getStrItemId());			
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);

			dao.executeProcedure(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				vo.setBrandDtlWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IssueDeskPrintTransDAO.getSingleBatchItemDtl() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	public static void getPatientAccountDetailsNew(IssueDeskPrintTransVO vo) {

		
		String strProcName = "{call PKG_MMS_VIEW.proc_hstt_pat_account_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		WebRowSet ws = null;
		HisDAO daoObj = null;
		try {
			
			System.out.println("-------------  IssueDeskPrintTransDAO . getPatientAccountDetailsNew  --------------");
			
			 System.out.println("-------------  pkg_mms_view.proc_hstt_pat_account_dtl  ------[Mode - 2]--------");
			 
			daoObj = new HisDAO("MMSModule", "IssueDeskPrintTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(), 2);
			daoObj.setProcInValue(nProcIndex, "cr_no", vo.getStrCrNo(), 3);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 5);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setPatAccountDtl(ws);
			}
		} catch (Exception _err) {
			vo
					.setStrMsgString("IssueDeskPrintTransDAO.getPatientAccountBalance() --> "
							+ _err.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	/**
	 * for getting value of item details on view page
	 * 
	 * @param vo
	 */

	public static void getIndent_ItemDetails(IssueDeskPrintTransVO vo) 
	{
		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";
		
    	try 
		{
    		System.out.println("<<--------------PKG_MMS_VIEW.PROC_GET_INDENTITEM_DTL-[ Mode - 1 ]------------->>");
    		String strProcName = "{call PKG_MMS_VIEW.PROC_GET_INDENTITEM_DTL(?,?,?,?,?,?,?)}";

			daoObj = new HisDAO("MMS Transactions","IssueDeskPrintTransDAO");
			//System.out.println("reqTypeId ====>>"+vo.getStrReqTypeId());
			nProcIndex = daoObj.setProcedure(strProcName);
     		daoObj.setProcInValue(nProcIndex, "modval", "1",1);
	     	daoObj.setProcInValue(nProcIndex, "storeId",vo.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "reqNo",vo.getStrReqNo(),4);
			daoObj.setProcInValue(nProcIndex, "reqTypeId",vo.getStrReqTypeId(),5);
						
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
			vo.setStrMsgString("--> IssueDeskPrintTransDAO.getItemDetails()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null)
				daoObj.free();
				daoObj = null;
			}

		}
	
	
	public static void getIndentDetails_NEW(IssueDeskPrintTransVO vo) 
	{
		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";

    	try 
		{
    		System.out.println("<<--------------PKG_MMS_VIEW.Get_Indent_Details_View-[ Req No--"+vo.getStrReqNo()+" ]------------->>");
    		
    		String strProcName = "{call PKG_MMS_VIEW.Get_Indent_Details_View(?,?,?,?,?,?)}";

			daoObj = new HisDAO("MMS Transactions","IssueDeskPrintTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "storeId",vo.getStrStoreId(),1);
			daoObj.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "reqNo",vo.getStrReqNo(),3);
			
			/* Setting Default Value Start*/
			daoObj.setProcInValue(nProcIndex, "reqTypeId","",4);
			/* Setting Default Value End */
			
			daoObj.setProcOutValue(nProcIndex,"err",1,5);
			daoObj.setProcOutValue(nProcIndex,"resultset", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) 
			{
    			wb = daoObj.getWebRowSet(nProcIndex, "resultset");
				vo.setStrIndentDetailsWs(wb);
				
			} else {
				throw new Exception(strErr);
			}
    		
		
		
		} 
    	catch (Exception e) 
    	{
			vo.setStrMsgString("--> IssueDeskPrintTransDAO.getIndentDetails()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null)
				daoObj.free();
				daoObj = null;
			}

		}
}
