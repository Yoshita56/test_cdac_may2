package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.DmlIndentReturnRequestDAO;
import mms.transactions.vo.IndentReturnTransVO;

public class IndentReturnTransDAO 
{

	/**
	 * for getting value of item details on view page
	 * 
	 * @param vo
	 */

	public static void getItemDetails(IndentReturnTransVO vo) 
	{
		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";

    	try 
		{
    		String strProcName = "{call PKG_MMS_VIEW.PROC_RETURNCONDEMN_REQ_DTL(?,?,?,?,?,?,?)}";

			daoObj = new HisDAO("MMS Transactions","IndentReturnTransDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
     		daoObj.setProcInValue(nProcIndex, "modval", "1",1);
	     	daoObj.setProcInValue(nProcIndex, "storeId",vo.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "reqNo",vo.getStrReqNo(),4);
			daoObj.setProcInValue(nProcIndex, "reqTypeId",vo.getStrReqTypeId(),5);
				
			daoObj.setProcOutValue(nProcIndex,"err", 1,6);
			daoObj.setProcOutValue(nProcIndex,"RESULTSET", 2,7);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				wb = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				
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
	
	
	/*
	 * This Function is used to get Store Name by Passing 2 variable a) Hospital
	 * Code b) Store Id
	 */
	public static void callingFunctionIndentName(IndentReturnTransVO vo) 
	{
		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		try {
			dao = new HisDAO("MMSModule", "RequestForLPStaffDAO");
			funcIndex = dao
					.setFunction("{? = call MMS_MST.get_indentType_Name(?,?,?)}");
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
	
	
	
	/*
	 * This Function is used to get Store Name by Passing 2 variable a) Hospital
	 * Code b) Store Id
	 */
	public static void callinggetStockDtl(IndentReturnTransVO vo) 
	{
		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		try {
			/*
			get_stock_dtl (modeval NUMBER,
        hosp_code NUMBER,
        itemId NUMBER,     
        itemBrandId NUMBER, 
        batchNo VARCHAR2,
        stockStatus NUMBER,
        strId NUMBER,
        slNo VARCHAR2 DEFAULT 0,
        reservedFlag NUMBER DEFAULT 1)
			*/
			dao = new HisDAO("MMSModule", "RequestForLPStaffDAO");
			funcIndex = dao
					.setFunction("{? = call MMS_MST.get_stock_dtl(?,?,?,?,?,?,?,?,?,?)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, "2");
			dao.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4, vo.getStrReqTypeId());
			
			/* Setting Default Value Start*/
			dao.setFuncInValue(funcIndex, 5, "0");//itemBrandId NUMBER
			dao.setFuncInValue(funcIndex, 6, "");//batchNo VARCHAR2
			dao.setFuncInValue(funcIndex, 7, "0");//stockStatus NUMBER
			dao.setFuncInValue(funcIndex, 8, "0");//strId NUMBER
			dao.setFuncInValue(funcIndex, 9, "0");
			dao.setFuncInValue(funcIndex, 10, "1");
			dao.setFuncInValue(funcIndex, 11, "1");
			/* Setting Default Value End */
			
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
	
	
	/**
	 * for getting value of item details on view page
	 * 
	 * @param vo
	 */
	
	//
	public static void getIndentDetails(IndentReturnTransVO vo) 
	{
		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";

    	try 
		{
    		String strProcName = "{call PKG_MMS_VIEW.Get_Indent_Details(?,?,?,?,?,?)}";

			daoObj = new HisDAO("MMS Transactions","IndentViewTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "storeId",vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "reqNo",vo.getStrReqNo());
			
			daoObj.setProcInValue(nProcIndex, "reqTypeId","");//Default value
			
			daoObj.setProcOutValue(nProcIndex,"err",1);
			daoObj.setProcOutValue(nProcIndex,"RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);

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
	 * INSERT method is used to insert data in following table
	 * 
	 * @param vo
	 */

	public synchronized static void INSERT(IndentReturnTransVO vo) 
	{
		HisDAO dao = null;
		DmlIndentReturnRequestDAO tableDao = null;
		try 
		{
			tableDao = new DmlIndentReturnRequestDAO();	
			dao = new HisDAO("MMS","transactions.IndentReturnTransDAO.INSERT()");
			/*
			vo.setStrFinancialEndYear(strFinancialEndYear);
			vo.setStrFinancialStartYear(strFinancialStartYear);
			vo.setStrItemId(temp[3]);
			vo.setStrItemBrandId(temp[4]);
			vo.setStrStockStatusCode(temp[5]);
			vo.setStrAvlQtyUnit(temp[6]);
			vo.setStrSancQtyUnit(temp[7]);
			vo.setStrReqNo(strReqNo);
			vo.setStrReqTypeId(strReqTypeId);
			vo.setStrStoreId(strStoreId);
			vo.setStrToStoreId(strToStoreId);
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrRemarsks(formBean.getStrRemarks());	
			vo.setStrRecevBy(formBean.getStrReceviedBy());
			*/	 
			
	           
				 tableDao.setStrId(vo.getStrStoreId()); 
				 tableDao.setToStoreId(vo.getStrToStoreId());
				 tableDao.setHosp_code(vo.getStrHospitalCode());
				 tableDao.setReqNo(vo.getStrReqNo()); 
				 tableDao.setItemId(vo.getStrItemId());
				 tableDao.setItemBrandId(vo.getStrItemBrandId());
				 tableDao.setReqTypeId(vo.getStrReqTypeId());
				 //tableDao.setStrBatchNo(vo.getStrBatchNo()[i]);
				
				// //System.out.println("In Dao--->>>"+vo.getStrBatchNo()[i]);
				 //tableDao.setStrCategNo("0");
				 tableDao.setStrFinancialEndDate(vo.getStrFinancialEndYear());
				 tableDao.setStrFinancialStarDate(vo.getStrFinancialStartYear());
				 tableDao.setStrIsValid("1");
				 tableDao.setStrItemCatgNo(vo.getStrItemCategory());
				// //System.out.println("At the Time Of Insert-->>"+vo.getStrItemCategory());
				 tableDao.setStrQty(vo.getStrAvlQty());
				 tableDao.setStrSancQty(vo.getStrSancQty());
				 tableDao.setStrRecevedBy(vo.getStrRecevBy());
				 tableDao.setStrRemarks(vo.getStrRemarsks());
				 tableDao.setStrSancQtyUnit(vo.getStrSancQtyUnit());
				 //tableDao.setStrStockStatusCode(vo.getStrStockStatusCode()[i]);
				 ////System.out.println("StockStatusCode--->>>"+vo.getStrStockStatusCode()[i]);
				 
				 tableDao.setStrUnitId(vo.getStrAvlQtyUnit());
				 tableDao.setStrSeatId(vo.getStrSeatId());
				 
				 if(vo.getStrReqTypeId().equals("16"))
				 {		 
					 tableDao.insertCondemnationReq(dao);
				 }
				 else
				 {
					 
					 tableDao.insert2(dao);
				 }	 
					
			  
				 dao.fire();     // Here we Execute in Batch
		    
		} 
    	catch (Exception e) 
    	{
    		e.printStackTrace();
			vo.setStrMsgString("--> IndentReturnTransDAO.INSERT()-->"
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
	
	public static void getIndentDetailsView(IndentReturnTransVO vo) 
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
			
			daoObj.setProcInValue(nProcIndex, "reqTypeId","",4);
			
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
	

	}
