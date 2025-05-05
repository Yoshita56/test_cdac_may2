package mms.transactions.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.dao.DmlIndentCancelDtlDAO;
import mms.dao.DmlIndentReturnRequestDAO;
import mms.transactions.vo.IndentTransVO;

public class IndentTransDAO 
{
	
	public static void getStoreList(IndentTransVO vo) 
	{

		HisDAO      daoObj = null;
		WebRowSet       ws = null;
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int     nProcIndex = 0;	
		String strErr = "";
		try
		{
			System.out.println(" ------- IndentTransDAO .getStoreList  -------- ");
			System.out.println(" ------- pkg_mms_view.proc_hstt_store_mst  --[ Mode- 12 ]------ ");
			
			    daoObj = new HisDAO("MMS Transactions","IndentTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			////System.out.println("In DAO==>"+nProcIndex);
             
			daoObj.setProcInValue(nProcIndex, "modeval",     "12",1);
			daoObj.setProcInValue(nProcIndex, "seatId",      vo.getStrSeatId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code",   vo.getStrHospCode(),3);
			
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
			vo.setStrMsgString("IndentTransDAO.getStoreList() --> "+ e.getMessage());
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
	
	public static void getRequestTypeCombo(IndentTransVO vo) 
	{
		
		
		HisDAO      daoObj = null;
		WebRowSet       ws = null;
		String strProcName = "{call pkg_mms_view2.proc_lstpage_requesttype_dtl(?,?,?,?,?   ,?,?)}"; // 7
		int     nProcIndex = 0;	
		String strErr = "";
		try
		{
			System.out.println(" ------- IndentTransDAO .getRequestTypeCombo  -------- ");
			System.out.println(" ------- pkg_mms_view2.proc_lstpage_requesttype_dtl  --[ Mode- 1 ]------ ");
			
			    daoObj = new HisDAO("MMS Transactions","IndentTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			             
			daoObj.setProcInValue(nProcIndex, "modeval"   , "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code" , vo.getStrHospCode(),2);
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
			vo.setStrMsgString("IndentTransDAO.getRequestTypeCombo() --> "+ e.getMessage());
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
		
	public static void getCatgCombo(IndentTransVO vo) 
	{
		
		
		HisDAO      daoObj = null;
		WebRowSet       ws = null;
		String strProcName = "{call pkg_mms_view2.proc_lstpage_catgcombo_dtl(?,?,?,?,?   ,?,?)}"; // 7
		int     nProcIndex = 0;	
		String strErr = "";
		try
		{
			System.out.println(" ------- IndentTransDAO .getCatgCombo  -------- ");
			System.out.println(" ------- pkg_mms_view2.proc_lstpage_requesttype_dtl  --[ Mode- 2 ]------ ");
			
			    daoObj = new HisDAO("MMS Transactions","IndentTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			             
			daoObj.setProcInValue(nProcIndex, "modeval"   , "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code" , vo.getStrHospCode(),2);
			daoObj.setProcInValue(nProcIndex, "req_for"   , "0",3);
			daoObj.setProcInValue(nProcIndex, "item_cat"  , (vo.getStrItemCategNo() == null ? "10"   : vo.getStrItemCategNo()),4);
			daoObj.setProcInValue(nProcIndex, "store_id"  , (vo.getStrStoreId() == null ? "0" : vo.getStrStoreId()),5);
			daoObj.setProcOutValue(nProcIndex, "err"      , 1,6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			   strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) 
			{

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				vo.setStrCatgWs(ws);
							
			} 
			else
			{
				throw new Exception(strErr);
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("IndentTransDAO.getCatgCombo() --> "+ e.getMessage());
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
	
	
	public static void getListPageData(IndentTransVO vo) 
	{
		
		
		HisDAO      daoObj = null;
		WebRowSet       ws = null;
		String strProcName = "{call Pkg_Mms_View2.proc_central_indent_lstpage_data(?,?,?,?,?   ,?,?,?)}"; // 8
		int     nProcIndex = 0;	
		String strErr = "";
		try
		{
			System.out.println(" ------- IndentTransDAO .getListPageData  -------- ");
			System.out.println(" ------- pkg_mms_view2.proc_central_indent_lstpage_data  --[ Mode- 1 ]------ ");
			
			    daoObj = new HisDAO("MMS Transactions","IndentTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			             
			daoObj.setProcInValue(nProcIndex, "modeval"      , "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code"    , vo.getStrHospCode(),2);
			daoObj.setProcInValue(nProcIndex, "req_for"      , (vo.getStrRequestTypeId() == null ? "0"   : vo.getStrRequestTypeId()),3);
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
			vo.setStrMsgString("IndentTransDAO.getRequestTypeCombo() --> "+ e.getMessage());
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
	
	
	/**
	 * This method is used to Cancel data into Table'
	 *  
	 * @param vo
	 */
	public synchronized static void CANCEL(IndentTransVO vo) 
	{
		HisDAO dao = null;
		DmlIndentCancelDtlDAO globalDao = null;
		DmlIndentReturnRequestDAO tableDao = null;
		try 
		{
			     dao = new HisDAO("MMS","transactions.IndentTransDAO.CANCEL()");
			     tableDao   = new DmlIndentReturnRequestDAO();	
			     globalDao  = new DmlIndentCancelDtlDAO();
			     
			     
			     globalDao.setStoreId(vo.getStrStoreId());
   			     globalDao.setHosp_code(vo.getStrHospCode());
   			     globalDao.setReqNo(vo.getStrReqNo());
   			     globalDao.setReqTypeId(vo.getStrRequestTypeId());
   			     globalDao.setRemarks(vo.getStrCancelReson());
   			     globalDao.setSeatId(vo.getStrSeatId());
   			     globalDao.setItemcatNo(vo.getStrItemCatgNo()); 
   			    
   			     tableDao.setStrId(vo.getStrStoreId()); 
   			     tableDao.setStrItemCatgNo(vo.getStrItemCatgNo());
				 tableDao.setHosp_code(vo.getStrHospCode());
				 tableDao.setReqNo(vo.getStrReqNo()); 
				 tableDao.setReqTypeId(vo.getStrRequestTypeId());
				 tableDao.setStrRemarks(vo.getStrCancelReson());
				 
				 if(vo.getStrRequestTypeId().equals("16")||vo.getStrRequestTypeId().equals("19"))
				 {	 
   			       tableDao.insert12(dao);
				 }
				 if(vo.getStrRequestTypeId().equals("18"))
				 {
				   tableDao.insert11(dao);
				 }	 
     		     globalDao.Update(dao);
			    				     
     		    dao.fire();     // Here we Execute in Batch
		     
		} 
    	catch (Exception e) 
    	{
    		e.printStackTrace();
			vo.setStrMsgString("--> IndentTransDAO.CANCEL()-->"
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

}
