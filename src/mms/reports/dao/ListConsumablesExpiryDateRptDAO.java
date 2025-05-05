package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.reports.vo.BreakageAndLostDrugDetailsRptVO;
import mms.reports.vo.ListConsumablesExpiryDateRptVO;
import mms.reports.vo.StockOnHandRptVO;

public class ListConsumablesExpiryDateRptDAO {
	
	public static void getStoreList(ListConsumablesExpiryDateRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.rptm_hstt_store_mst(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","ListConsumablesExpiryDateRptDAO");
		//	
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval",       "1",1);
			daoObj.setProcInValue(nProcIndex, "seatId",        voObj.getStrSeatId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code",     voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "item_category", "0",4);
			daoObj.setProcOutValue(nProcIndex, "err",          1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset",    2,6);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrStoreWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("ListConsumablesExpiryDateRptDAO.getStoreList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	/**
	 * To get Store Combo from the hstt_store_mst
	 *  
	 * @param voObj
	 */
	public static void getDistrictStoreList(ListConsumablesExpiryDateRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("DWH","BudgetDetailRptDAO");
			//
			nProcIndex = daoObj.setProcedure(strProcName);

			
			daoObj.setProcInValue(nProcIndex, "modeval", 		voObj.getStrMode());
			daoObj.setProcInValue(nProcIndex, "seatid", 		voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", 		voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeid", 		"0");
			daoObj.setProcInValue(nProcIndex, "storetype_id",	"0"); 
			daoObj.setProcOutValue(nProcIndex, "err", 			1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 	2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrDistrictStoreWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("BudgetDetailRptDAO.getStoreList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getItemCatList(ListConsumablesExpiryDateRptVO voObj) {
		String strProcName = "{call Pkg_Mms_Rpt.Rptm_item_category_list(?,?,?,?,?)}";
				
				int nProcIndex = 0;
				String strErr = "";
				WebRowSet ws = null;
				HisDAO daoObj=null;
				
				try
				{
					daoObj=new HisDAO("Item Location","ListConsumablesExpiryDateRptDAO");
					//
					nProcIndex = daoObj.setProcedure(strProcName);
					daoObj.setProcInValue(nProcIndex, "modeval", 		"2",1);
					daoObj.setProcInValue(nProcIndex, "hosp_code", 		MmsConfigUtil.GLOBAL_HOSPITAL_CODE,2);
					daoObj.setProcInValue(nProcIndex, "storeid", 		voObj.getStrStoreId(),3);
					daoObj.setProcOutValue(nProcIndex, "err",			1,4); 
					daoObj.setProcOutValue(nProcIndex, "resultset",		2,5);
					daoObj.executeProcedureByPosition(nProcIndex);
					
					strErr = daoObj.getString(nProcIndex, "err");
					if (strErr == null)
						strErr = "";
		
					if (strErr.equals("")) {
		
						ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				
						voObj.setStrItemCatWs(ws);
									
					} else {
						throw new Exception(strErr);
					}
		
				} catch (Exception e) {
		
					voObj
							.setStrMsgString("ListConsumablesExpiryDateRptDAO.getItemCatList() --> "
									+ e.getMessage());
					voObj.setStrMsgType("1");
		
				} finally {
					if (daoObj != null) {
						daoObj.free();
						daoObj = null;
					}
				}
			}

	public static void getExpiryViewDtl(ListConsumablesExpiryDateRptVO voObj)
	{	
		String strProcName = "{call PKG_MMS_VIEW2.rptm_ExpiryDrug_Details_dtl(?,?,?,?,?,  ?,?,?,?,? , ?)}";   // 11 Variables		
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try 
		{
			System.out.println(" ---------ListConsumablesExpiryDateRptDAO.getExpiryViewDtl---------");
			System.out.println(" ---------PKG_MMS_VIEW2.rptm_ExpiryDrug_Details_dtl--[ Mode - 1 ]-------");
			
			/*
	         * ExpNonExpiryFlag - 10  Expired	
	         *                  - 20  Near - Expired 
	         * 
	         * strDateDaysFlag -  11  Days
	         *                 -  22  Due Date 
	         * 
	         * */
			System.out.println(" ------voObj.getStrDateDaysFlag()---[ 11 -  Days , 22 - Due Date ]-----"+voObj.getStrDateDaysFlag());		
			System.out.println(" ------voObj.getStrDueDate()--------"+voObj.getStrDueDate());	
			System.out.println(" ------voObj.getStrExpNonExpiryFlag()--[ 10 - Expired , 20 - Near Expiry ]------"+voObj.getStrExpNonExpiryFlag());	
			System.out.println(" ------voObj.getStrFrmExpiryDays()--------"+voObj.getStrFrmExpiryDays());	
			
			daoObj = new HisDAO("INV","ListConsumablesExpiryDateRptDAO");
			nProcIndex = daoObj.setProcedure(strProcName);	
			
			daoObj.setProcInValue(nProcIndex, "modeval",            "1",1);  	
			daoObj.setProcInValue(nProcIndex, "hosp_code",   		voObj.getStrHospitalCode(),2);	   
			daoObj.setProcInValue(nProcIndex, "catcode",   		    voObj.getStrItemCategoryId(),3);     
			daoObj.setProcInValue(nProcIndex, "duedate",   			voObj.getStrDueDate(),4);			
			daoObj.setProcInValue(nProcIndex, "nearExpFlg",   		voObj.getStrExpNonExpiryFlag(),5);	
			if(voObj.getStrDateDaysFlag().equals("0"))
			{
			    daoObj.setProcInValue(nProcIndex, "dateDaysFlg",   		"11",6);
			}
			else
			{
				daoObj.setProcInValue(nProcIndex, "dateDaysFlg",   		voObj.getStrDateDaysFlag(),6);	
			}
			daoObj.setProcInValue(nProcIndex, "frmExpiryDays",   	voObj.getStrFrmExpiryDays(),7);			
			daoObj.setProcInValue(nProcIndex, "strid",      		voObj.getStrStoreId(),8);	
			daoObj.setProcInValue(nProcIndex, "seatId",      		voObj.getStrSeatId(),9);
			daoObj.setProcOutValue(nProcIndex, "err",               1,10); 	
			daoObj.setProcOutValue(nProcIndex, "resultset",         2,11);		
			
			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) 
			{

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				
				voObj.setWsExpiryDtlRpt(ws);
							 
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			voObj.setStrMsgString("ListConsumablesExpiryDateRptDAO.getExpiryViewDtl() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getInvoiceWiseExpiryDetails(ListConsumablesExpiryDateRptVO voObj)
	{	
		String strProcName = "{call PKG_MMS_VIEW2.rptm_ExpiryDrug_Details_dtl(?,?,?,?,?,  ?,?,?,?,? , ?)}";   //  Variables		
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try 
		{
			System.out.println(" ---------ListConsumablesExpiryDateRptDAO.getInvoiceWiseExpiryDetails---------");
			System.out.println(" ---------PKG_MMS_VIEW2.rptm_ExpiryDrug_Details_dtl--[ Mode - 2 ]-------");
			
			/*
	         * ExpNonExpiryFlag - 10  Expired
	         *                  - 20  Near - Expired 
	         * 					- 30  Invoice Wise Expiry Details
	         * */
			
			daoObj = new HisDAO("INV","ListConsumablesExpiryDateRptDAO");
			nProcIndex = daoObj.setProcedure(strProcName);	
			
			
			daoObj.setProcInValue(nProcIndex, "modeval",            "2",1);  	
			daoObj.setProcInValue(nProcIndex, "hosp_code",   		voObj.getStrHospitalCode(),2);	   
			daoObj.setProcInValue(nProcIndex, "catcode",   		    voObj.getStrItemCategoryId(),3);     
			daoObj.setProcInValue(nProcIndex, "duedate",   			voObj.getStrDueDate(),4);			
			daoObj.setProcInValue(nProcIndex, "nearExpFlg",   		voObj.getStrExpNonExpiryFlag(),5);	
			if(voObj.getStrDateDaysFlag().equals("0"))
			{
			    daoObj.setProcInValue(nProcIndex, "dateDaysFlg",   		"11",6);
			}
			else
			{
				daoObj.setProcInValue(nProcIndex, "dateDaysFlg",   		voObj.getStrDateDaysFlag(),6);	
			}
			daoObj.setProcInValue(nProcIndex, "frmExpiryDays",   	voObj.getStrFrmExpiryDays(),7);			
			daoObj.setProcInValue(nProcIndex, "strid",      		voObj.getStrStoreId(),8);	
			daoObj.setProcInValue(nProcIndex, "seatId",      		voObj.getStrSeatId(),9);
			System.out.println("SEATID"+voObj.getStrSeatId());

			daoObj.setProcOutValue(nProcIndex, "err",               1,10); 	
			daoObj.setProcOutValue(nProcIndex, "resultset",         2,11);		
			
			
			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) 
			{

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				
				voObj.setWsExpiryDtlRpt(ws);
							 
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			voObj.setStrMsgString("ListConsumablesExpiryDateRptDAO.getInvoiceWiseExpiryDetails() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getImageHeader(ListConsumablesExpiryDateRptVO voObj)
	{
		String strFuncName = "";
		String strLogoName = "";
		
		int nFuncIndex = 0;
		HisDAO dao = null;
		try 
		{
			dao = new HisDAO("DWH","ListConsumablesExpiryDateRptDAO");
			
			strFuncName = "{? = call MMS_MST.logo_config_dtl(?,?)}";
			nFuncIndex = dao.setFunction(strFuncName);
			
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, voObj.getStrHospitalCode());
			dao.setFuncOutValue(nFuncIndex, 1);
			
			dao.executeFunction(nFuncIndex);
			
			strLogoName = dao.getFuncString(nFuncIndex);
			voObj.setStrLogoName(strLogoName);
			//System.out.println("======strLogoName======="+strLogoName);

		} catch (Exception e) {
			
			e.printStackTrace();
			voObj.setStrMsgType("1");
			voObj.setStrMsgString("IssueTransDAO.getImageHeader() --> "+ e.getMessage());
			
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}
		}	
	}
	
}
