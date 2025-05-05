package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.MiscItemListingRptVO_NEW;
import mms.transactions.vo.IndentViewTransVO;

public class IndentViewTransDAO {
	
	
	/**
	 * This Method is Used to Get Indent Item List from 
	 * HSTT_DRUG_MST 
	 * @param vo
	 */
	public static void GetIndentItemList(IndentViewTransVO vo) 
	{
		String err = "";
		String proc_name1 = "{call PKG_MMS_VIEW.proc_purchase_item_dtl(?,?,?,?,?,?,?,?)}";
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		try 
		{
			dao = new HisDAO("mms","IndentViewTransDAO.GetSoreNameCombo(IndentViewTransVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);
			// set value
            dao.setProcInValue(procIndex1,  "modeval", "1");			
			dao.setProcInValue(procIndex1,  "hosp_code", vo.getStrHospitalCode());			
			dao	.setProcInValue(procIndex1, "itemCat", "10");
			dao.setProcInValue(procIndex1,  "frmStrId", vo.getStrStoreId());		
			dao	.setProcInValue(procIndex1, "reqType", "17");
			dao.setProcInValue(procIndex1,  "userInfo", "");			
			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object
			// execute procedure					
			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");
			vo.setIndentItemWS(ws);

			
		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("IndentViewTransDAO.GetIndentItemList() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	public static void getImageHeader(IndentViewTransVO vo)
	{
		String strFuncName = "";
		String strLogoName = "";
		
		int nFuncIndex = 0;
		HisDAO dao = null;
		try 
		{
			dao = new HisDAO("DWH","IndentViewTransDAO");
			
			strFuncName = "{? = call MMS_MST.logo_config_dtl(?,?)}";
			nFuncIndex = dao.setFunction(strFuncName);
			
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncOutValue(nFuncIndex, 1);
			
			dao.executeFunction(nFuncIndex);
			
			strLogoName = dao.getFuncString(nFuncIndex);
			vo.setStrLogoName(strLogoName);
			//System.out.println("------------strLogoName------------"+strLogoName);

		} catch (Exception e) {
			
			e.printStackTrace();
			vo.setStrMsgType("1");
			vo.setStrMsgString("IndentViewTransDAO.getImageHeader() --> "+ e.getMessage());
			
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

	public static void getItemDetails(IndentViewTransVO vo) 
	{
		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";
		
    	try 
		{
    		System.out.println("<<--------------PKG_MMS_VIEW.PROC_GET_INDENTITEM_DTL-[ Mode - 1 ]------------->>");
    		String strProcName = "{call PKG_MMS_VIEW.PROC_GET_INDENTITEM_DTL(?,?,?,?,?,?,?)}";

			daoObj = new HisDAO("MMS Transactions","IndentViewTransDAO");
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
	 * To Get Data
	 * 
	 * @param vo
	 */
	public static void getAvalBudgetDetails(IndentViewTransVO vo) 
	{
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_hstt_budget_dtl(?,?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {
			
			System.out.println("<<--------------pkg_mms_view.proc_hstt_budget_dtl-[ Mode - 4 ]------------->>");

				dao = new HisDAO("MMS Transactions","IndentViewTransDAO");
						
				procIndex1 = dao.setProcedure(proc_name1);
				
				dao.setProcInValue(procIndex1, "p_mode", "4",1);
				// set value
				
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
	
	
	
	/*
	 * This Function is used to get Store Name by Passing 2 variable a) Hospital
	 * Code b) Store Id
	 */
	public static void callingFunctionIndentName(IndentViewTransVO vo) 
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
	
	
	/**
	 * for getting value of item details on view page
	 * 
	 * @param vo
	 */
	
	//
	
	

	public static void getIndentDetails(IndentViewTransVO vo) 
	{
		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";

    	try 
		{
    		System.out.println("<<--------------PKG_MMS_VIEW.Get_Indent_Details_View-[ Req No--"+vo.getStrReqNo()+" ]------------->>");
    		
    		String strProcName = "{call PKG_MMS_VIEW.Get_Indent_Details_View(?,?,?,?,?, ?)}";

			daoObj = new HisDAO("MMS Transactions","IndentViewTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "storeId",vo.getStrStoreId(),1);
			daoObj.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "reqNo",vo.getStrReqNo(),3);
			
			/* Setting Default Value Start*/
			daoObj.setProcInValue(nProcIndex, "reqTypeId","",4);
			/* Setting Default Value End */
			
			
//			daoObj.setProcInValue(nProcIndex, "SeatId",vo.getStrSeatId(),5);
			
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
			vo.setStrMsgString("--> IndentViewTransDAO.getIndentDetails()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null)
				daoObj.free();
				daoObj = null;
			}

		}
	
	public static void UpdateModify(IndentViewTransVO vo)
	{
		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";
		String strItemBrandIds[];
		String strItemQty[];

    	try 
		{
    		String strProcName = "{call PKG_MMS_dml.dml_hstt_pur_indent_item_Modify_dtl(?,?,?,?,?,?,?,?,?)}";

			daoObj = new HisDAO("MMS Transactions","IndentViewTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
		
			
			//System.out.println("strid"+vo.getStrRaisingStore());
			//System.out.println("strreqno"+vo.getStrIndentNo());
			//System.out.println("hosp_code"+vo.getStrHospitalCode());

			//System.out.println("indentqty"+vo.getStrReqQty());
			
			strItemBrandIds = vo.getStrItemBrandIds().split("\\^");
			strItemQty = vo.getStrModifedQty().split("\\^");
		/*	for(int j=0;j<strItemBrandIds.length;j++)
			{
				//System.out.println("strItemBrandIds[j]"+strItemBrandIds[j]);
				//System.out.println("strItemQty"+strItemQty[j]);
			}
			*/
			for(int i=0;i<strItemBrandIds.length;i++)
			{
			daoObj.setProcInValue(nProcIndex, "modval","1",1);
			daoObj.setProcInValue(nProcIndex, "strid",vo.getStrRaisingStore(),2);
			daoObj.setProcInValue(nProcIndex, "strreqno",vo.getStrIndentNo(),3);
			daoObj.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),4);

			daoObj.setProcInValue(nProcIndex, "indentqty",strItemQty[i],5);
		
			daoObj.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),4);
			daoObj.setProcInValue(nProcIndex, "indentTypeId",vo.getStrIndentTypeId(),6);
			daoObj.setProcInValue(nProcIndex,"itemBrandIds",strItemBrandIds[i],7);
			
			daoObj.setProcInValue(nProcIndex, "remarks","okk",8);
			daoObj.setProcOutValue(nProcIndex,"err",1,9);
			
	    	daoObj.executeProcedureByPosition(nProcIndex);
			}
		//	daoObj.execute(nProcIndex,1);
			//System.out.println("Executed successfully!!");
			strErr = daoObj.getString(nProcIndex, "err");
 

		
		} 
    	catch (Exception e) 
    	{
    		e.printStackTrace();
			vo.setStrMsgString("--> AnnualPurchaseIndentVO.INSERTINTABLE()-->"
					+ e.getMessage());
			//System.out.println("Its an exception");
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

