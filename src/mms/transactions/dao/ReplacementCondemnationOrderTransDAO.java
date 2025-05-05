
package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;
import mms.transactions.vo.ReplacementCondemnationOrderTransVO;

public class ReplacementCondemnationOrderTransDAO {

	
	public static void storeName(ReplacementCondemnationOrderTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";//
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Replacement Condemnation Order","ReplacementCondemnationOrderTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "seatId", vo.getStrSeatId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
			daoObj.setProcOutValue(nProcIndex, "err",1,6); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,7);
			
			/* Start Adding Default value*/
			daoObj.setProcInValue(nProcIndex, "modeval","12",1);
			daoObj.setProcInValue(nProcIndex, "storeid","0",4);
			daoObj.setProcInValue(nProcIndex, "storetype_id","0",5);
		    /* End Adding Default value*/
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				//System.out.println("WS>SIZE()"+ws.size());

				vo.setWbsStoreNameCombo(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("ReplacementCondemnationOrderTransDAO.storeName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void getPendingOrderDtl(ReplacementCondemnationOrderTransVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_pendingOrder_dtl(?,?,?,?,?,?,?,?,?)}"; //9 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
           
			daoObj=new HisDAO("Replacement Condemnation Order","ReplacementCondemnationOrderTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);			
			if(vo.getStrActionsId().equals("1")||vo.getStrActionsId().equals("0"))  // Replacement
			{	
			 daoObj.setProcInValue(nProcIndex, "MODEVAL", "1",1);
			}
			if(vo.getStrActionsId().equals("2"))  // Condemnation
			{	
			 daoObj.setProcInValue(nProcIndex, "MODEVAL", "2",1);
			}
			
			////System.out.println();
			daoObj.setProcInValue(nProcIndex, "p_GNUM_HOSPITAL_CODE", vo.getStrHospitalCode(),2);			
			daoObj.setProcInValue(nProcIndex, "p_HSTNUM_ACTION", vo.getStrActionsId(),3);			
			daoObj.setProcInValue(nProcIndex, "p_GNUM_SEATID", vo.getStrSeatId(),4);
			daoObj.setProcInValue(nProcIndex, "itemcatno", vo.getStrItemCatNo(),5);
			daoObj.setProcInValue(nProcIndex, "storeid", vo.getStrStoreId(),6);
			daoObj.setProcInValue(nProcIndex, "supplierid", vo.getStrSupplierId(),7);
			daoObj.setProcOutValue(nProcIndex, "ERR",1,8); 
			daoObj.setProcOutValue(nProcIndex, "RESULTSET",2,9);
			daoObj.executeProcedureByPosition(nProcIndex);
						
			strErr = daoObj.getString(nProcIndex, "ERR");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
			if (strErr.equals("")) 
			{
				
				vo.setWsPendingOrderDtl(ws);				
			} 
			else 
			{
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("ReplacementCondemnationOrderTransDAO.getPendingOrderDtl() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	public static void getNOSQDrugList(ReplacementCondemnationOrderTransVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_Drug_list(?,?,?,?,?,?)}"; //6 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			 System.out.println("--------------- ReplacementCondemnationOrderTransDAO . getNOSQDrugList ---[ pkg_mms_view.proc_Drug_list  - 1]-------------");
			 
			daoObj=new HisDAO("Replacement Condemnation Order","ReplacementCondemnationOrderTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "storeId","0",3);
			daoObj.setProcInValue(nProcIndex, "itemCatg", "10",4);			
			daoObj.setProcOutValue(nProcIndex, "err",1,5); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,6);
			daoObj.executeProcedureByPosition(nProcIndex);
						
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
				
				vo.setWsNOSQItemDetail(ws);				
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("ReplacementCondemnationOrderTransDAO.getNOSQDrugList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void getExpiryDrugList(ReplacementCondemnationOrderTransVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_Expiry_Drug_list(?,?,?,?,?,?,?)}"; //6 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			
			
			daoObj=new HisDAO("Replacement Condemnation Order","ReplacementCondemnationOrderTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			//System.out.println("vo.getStrActionsId()"+vo.getStrActionsId());
			if(vo.getStrActionsId().equalsIgnoreCase("2"))
			{
				System.out.println("--------------- ReplacementCondemnationOrderTransDAO . getExpiryDrugList ---[ pkg_mms_view.proc_Expiry_Drug_list  - 1]-------------");
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			}else{
				System.out.println("--------------- ReplacementCondemnationOrderTransDAO . getExpiryDrugList ---[ pkg_mms_view.proc_Expiry_Drug_list  - 3]-------------");
				daoObj.setProcInValue(nProcIndex, "modeval", "3",1);
			}
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "storeId",vo.getStrStoreId(),3);
			daoObj.setProcInValue(nProcIndex, "itemCatg", vo.getStrItemCatNo(),4);	
			daoObj.setProcInValue(nProcIndex, "supplierid", vo.getStrSupplierId(),5);
			daoObj.setProcOutValue(nProcIndex, "err",1,6); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,7);
			daoObj.executeProcedureByPosition(nProcIndex);
						
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
				
				vo.setWbExpiryDrug(ws);				
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("ReplacementCondemnationOrderTransDAO.getExpiryDrugList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	public static void getSuggestedDrugList(ReplacementCondemnationOrderTransVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_Expiry_Drug_list(?,?,?,?,?,?,?)}"; //6 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			System.out.println("--------------- ReplacementCondemnationOrderTransDAO . getSuggestedDrugList ---[ pkg_mms_view.proc_Expiry_Drug_list  - 4]-------------");
			daoObj=new HisDAO("Replacement Condemnation Order","ReplacementCondemnationOrderTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			//System.out.println("vo.getStrActionsId()"+vo.getStrActionsId());
			
			daoObj.setProcInValue(nProcIndex, "modeval", "4",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "storeId",vo.getStrStoreId(),3);
			daoObj.setProcInValue(nProcIndex, "itemCatg", vo.getStrItemCatNo(),4);	
			daoObj.setProcInValue(nProcIndex, "supplierid", vo.getStrSupplierId(),5);
			daoObj.setProcOutValue(nProcIndex, "err",1,6); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,7);
			daoObj.executeProcedureByPosition(nProcIndex);
						
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
				
				vo.setWbSuggestedDrug(ws);
				//System.out.println("setWbSuggestedDrug(ws)sizeeeeeee"+ws.size());
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("ReplacementCondemnationOrderTransDAO.getExpiryDrugList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	public static void getItemName(ReplacementCondemnationOrderTransVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_Expiry_Drug_list(?,?,?,?,?,?,?)}"; //6 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			System.out.println("--------------- ReplacementCondemnationOrderTransDAO . getItemName ---[ pkg_mms_view.proc_Expiry_Drug_list  - 2]-------------");
			daoObj=new HisDAO("Replacement Condemnation Order","ReplacementCondemnationOrderTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", 	"2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", 	vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "storeId",	vo.getStrStoreId(),3);
			daoObj.setProcInValue(nProcIndex, "itemCatg", 	vo.getStrItemCatNo(),4);	
			daoObj.setProcInValue(nProcIndex, "supplierid", vo.getStrSupplierId(),5);
			daoObj.setProcOutValue(nProcIndex, "err",		1,6); 
			daoObj.setProcOutValue(nProcIndex, "resultset",	2,7);
			daoObj.executeProcedureByPosition(nProcIndex);
						
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
				
				vo.setWbItemName(ws);				
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("ReplacementCondemnationOrderTransDAO.getExpiryDrugList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void getRejectedDrugList(ReplacementCondemnationOrderTransVO vo)
	{
		/*String strProcName = "{call pkg_mms_view.proc_NOSQ_Rejected_Drug_list(?,?,?,?,?,?)}"; //6 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Replacement Condemnation Order","ReplacementCondemnationOrderTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeId","0");
			daoObj.setProcInValue(nProcIndex, "itemCatg", "10");			
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
						
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
				
				vo.setWbRejectedDrug(ws);				
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("ReplacementCondemnationOrderTransDAO.getRejectedDrugList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}*/
	}
	
	
	/**
	 * This function is used to set details in approved By Combo.
	 * 
	 * @param _PODeskGenerateTransVO
	 */
	public static void getApprovedByCombo(
			ReplacementCondemnationOrderTransVO vo) {

		String strProcName = "{call PKG_MMS_VIEW.proc_store_emp_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		WebRowSet ws = null;
		HisDAO daoObj = null;
		try 
		{
			daoObj = new HisDAO("MMSModule", "PODeskGenerateTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			// Set Value
			daoObj.setProcInValue(nProcIndex, "modeVal", "2",1);
			////System.out.println("Store ID==>"+vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "storeId", vo.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),3);
			daoObj.setProcOutValue(nProcIndex, "err", 1,4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,5);
			// Execute Procedure
			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
				vo.setWbApprovedBy(ws);
			}
		} 
		catch (Exception _err) 
		{
			vo
					.setStrMsgString("PODeskGenerateTransDAO.getApprovedByCombo() --> "
							+ _err.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void getCommitteTypeCombo(
			ReplacementCondemnationOrderTransVO vo) {

		String strProcName = "{call PKG_MMS_VIEW.proc_committe_type_dtl(?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		WebRowSet ws = null;
		HisDAO daoObj = null;
		try 
		{
			System.out.println("--------------- ReplacementCondemnationOrderTransDAO . getCommitteTypeCombo ---[ pkg_mms_view.proc_committe_type_dtl  - 2]-------------");
			
			daoObj = new HisDAO("MMSModule", "PODeskGenerateTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			// Set Value
			daoObj.setProcInValue(nProcIndex, "modeVal", "2",1);
			////System.out.println("Store ID==>"+vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "catcode", "0",3);
			daoObj.setProcInValue(nProcIndex, "reqtype", "0",4);
			
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
			// Execute Procedure
			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("wswssdffffffff"+ws.size());
			if (strErr.equals("")) 
			{
				vo.setWbCommitteType(ws);
			}
		} 
		catch (Exception _err) 
		{
			_err.printStackTrace();
			vo.setStrMsgString("PODeskGenerateTransDAO.getApprovedByCombo() --> "
							+ _err.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void getAvailableStockDtls(ReplacementCondemnationOrderTransVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_QC_Drug_Batch_Details(?,?,?,?,?,?,?,?)}"; //8
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			System.out.println("--------------- ReplacementCondemnationOrderTransDAO . getAvailableStockDtls ---[ pkg_mms_view.proc_QC_Drug_Batch_Details  - 2]-------------");
			
			daoObj=new HisDAO("Replacement Condemnation Order","ReplacementCondemnationOrderTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeId", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "itemBrandId", vo.getStrItemBrandId());
			daoObj.setProcInValue(nProcIndex, "batchNo", vo.getStrBatchNo());
			daoObj.setProcInValue(nProcIndex, "reSendFlg", "10");
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
						
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setWsStockDetails(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("ReplacementCondemnationOrderTransDAO.getAvailableStockDtls() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void getOrderScheduleDtl(ReplacementCondemnationOrderTransVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_replacement_condemnation(?,?,?,?,? ,?,?,?,?,?, ?,?,?,?,?, ?,?,?,?)}"; //19 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			System.out.println("--------------- ReplacementCondemnationOrderTransDAO . getOrderScheduleDtl ---[ pkg_mms_view.proc_replacement_condemnation  - 3]-------------");
			
			daoObj=new HisDAO("Replacement Condemnation Order","ReplacementCondemnationOrderTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			/*
			 * 1.BATCH_NO
			 * 2.HSTNUM_SUPPLIER_ID
			 * 3.HSTNUM_SUPPLIED_BY
			 * 4.HSTNUM_PO_NO 
			 * 5.PO_DATE
			 * 6.HSTNUM_STORE_ID 
			 * 7.HSTNUM_ITEM_ID
			 * 8.HSTNUM_ITEMBRAND_ID
			 * 9.HSTNUM_STOCK_STATUS_CODE
			 */
			String temp[] = vo.getStrHiddenItemDtl().split("\\$"); 
									
			daoObj.setProcInValue(nProcIndex, "MODEVAL", "3");
			daoObj.setProcInValue(nProcIndex, "p_HSTNUM_REPLACEMENT_ORDER_NO", "0");
			daoObj.setProcInValue(nProcIndex, "p_HSTNUM_SUPPLIER_ID", "0");
			daoObj.setProcInValue(nProcIndex, "p_GNUM_HOSPITAL_CODE", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_HSTSTR_PO_NO", "0");
			daoObj.setProcInValue(nProcIndex, "p_HSTDT_PO_DATE", "0");
			daoObj.setProcInValue(nProcIndex, "p_HSTNUM_ITEM_ID", temp[6]);
			daoObj.setProcInValue(nProcIndex, "p_HSTNUM_ITEMBRAND_ID", temp[7]);
			daoObj.setProcInValue(nProcIndex, "p_HSTSTR_BATCH_NO", temp[0]);
			daoObj.setProcInValue(nProcIndex, "p_HSTNUM_ORDER_STATUS", "0");
			daoObj.setProcInValue(nProcIndex, "p_HSTNUM_STORE_ID", "0");
			daoObj.setProcInValue(nProcIndex, "p_HSTNUM_NEW_DELIVERY_DATE", "0");
			daoObj.setProcInValue(nProcIndex, "p_HSTSTR_REMARKS", "0");
			daoObj.setProcInValue(nProcIndex, "p_HSTNUM_ACTION", "0");
			daoObj.setProcInValue(nProcIndex, "p_HSTDT_RECEIVED_DATE", "0");
			daoObj.setProcInValue(nProcIndex, "p_HSTNUM_ORDER_TYPE", "0");
			daoObj.setProcInValue(nProcIndex, "p_GNUM_SEATID", vo.getStrSeatId());
			daoObj.setProcOutValue(nProcIndex, "ERR",1); 
			daoObj.setProcOutValue(nProcIndex, "RESULTSET",2);
			
			daoObj.executeProcedure(nProcIndex);
						
			strErr = daoObj.getString(nProcIndex, "ERR");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
			if (strErr.equals("")) {
				vo.setWsOrderScheduleDtl(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("ReplacementCondemnationOrderTransDAO.getOrderScheduleDtl() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void getScheduleQtyDtl(ReplacementCondemnationOrderTransVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_replacement_condemnation(?,?,?,?,? ,?,?,?,?,?, ?,?,?,?,?, ?,?,?,?)}"; //19 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Replacement Condemnation Order","ReplacementCondemnationOrderTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			/*
			 * 1.ORDER_QTY
			 * 2.ACCEPTED_QTY
			 * 3.AVL_QTY			 
			 */
												
			daoObj.setProcInValue(nProcIndex, "MODEVAL", "2");
			daoObj.setProcInValue(nProcIndex, "p_HSTNUM_REPLACEMENT_ORDER_NO", vo.getStrSchduleNo());
			daoObj.setProcInValue(nProcIndex, "p_HSTNUM_SUPPLIER_ID", "0");
			daoObj.setProcInValue(nProcIndex, "p_GNUM_HOSPITAL_CODE", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_HSTSTR_PO_NO", vo.getStrPoNo());
			daoObj.setProcInValue(nProcIndex, "p_HSTDT_PO_DATE", "0");
			daoObj.setProcInValue(nProcIndex, "p_HSTNUM_ITEM_ID", vo.getStrItemId());
			daoObj.setProcInValue(nProcIndex, "p_HSTNUM_ITEMBRAND_ID",vo.getStrItemBrandId());
			daoObj.setProcInValue(nProcIndex, "p_HSTSTR_BATCH_NO", vo.getStrBatchNo());
			daoObj.setProcInValue(nProcIndex, "p_HSTNUM_ORDER_STATUS", "0");
			daoObj.setProcInValue(nProcIndex, "p_HSTNUM_STORE_ID", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "p_HSTNUM_NEW_DELIVERY_DATE", "0");
			daoObj.setProcInValue(nProcIndex, "p_HSTSTR_REMARKS", "0");
			daoObj.setProcInValue(nProcIndex, "p_HSTNUM_ACTION", "0");
			daoObj.setProcInValue(nProcIndex, "p_HSTDT_RECEIVED_DATE", "0");
			daoObj.setProcInValue(nProcIndex, "p_HSTNUM_ORDER_TYPE", "0");
			daoObj.setProcInValue(nProcIndex, "p_GNUM_SEATID", vo.getStrSeatId());
			daoObj.setProcOutValue(nProcIndex, "ERR",1); 
			daoObj.setProcOutValue(nProcIndex, "RESULTSET",2);
			
			daoObj.executeProcedure(nProcIndex);
						
			strErr = daoObj.getString(nProcIndex, "ERR");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
			if (strErr.equals("")) {
				vo.setWsScheduleQty(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("ReplacementCondemnationOrderTransDAO.getScheduleQtyDtl() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public synchronized static void insert(ReplacementCondemnationOrderTransVO vo) 
	{
		String strProcName = "{call pkg_mms_dml.dml_replacement_po_dtl_order(?,?,?,?,? ,?,?,?,?,?,  ?,?,?,?,? , ?,?,?,?,?,?,?)}";// 18 Variables
		
		HisDAO dao = null;
		int nProcIndex = 0;
		String strErr = "";
		String itemDtl[]={""};		
		String finalRemarks= "";
		try 
		{
    		dao = new HisDAO("MMS",	"transactions.ReplacementCondemnationOrderTransDAO.insert()");

			nProcIndex = dao.setProcedure(strProcName);
			
			System.out.println("-----------ReplacementCondemnationOrderTransDAO  . insert-----------");
			
			System.out.println("-----------pkg_mms_dml.dml_replacement_po_dtl_order-[  Mode  -1 ]-----------");
			
			System.out.println("-----------INSERT INTO SSTT_SUPPRET_CONDEMN_DTL-----------");

			//[ HSTNUM_ITEM_ID^HSTNUM_ITEMBRAND_ID^HSTSTR_BATCH_SL_NO^HSTNUM_OLD_PO_NO^HSTNUM_OLD_SCHEDULE_NO^HSTNUM_SUPPLIER_ID^QTY]
			for(int i=0;i <vo.getStrExpiryDrugs().length;i++)
			{
			
				itemDtl = vo.getStrExpiryDrugs()[i].split("\\^");
				
				System.out.println("--- HSTNUM_ITEM_ID ^ HSTNUM_ITEMBRAND_ID ^ HSTSTR_BATCH_SL_NO ^ HSTNUM_OLD_PO_NO ^ HSTNUM_OLD_SCHEDULE_NO ^ HSTNUM_SUPPLIER_ID ^ QTY --- =>>"+vo.getStrExpiryDrugs()[i]);
				
				System.out.println( "vo.getStrActionId()----[ 1. Replacement , 2 -  Condemnation]-----"+vo.getStrActionsId());
				
				if(vo.getStrActionsId().equals("1")) // Replacement
				{
					finalRemarks = "Return/Replacement Order  For  Batch "+itemDtl[2]+"  has been successfully Generated - "+vo.getStrRemarks();
				}
				else		// Condemnation
				{
					finalRemarks = "Condemnation Order  For  Batch "+itemDtl[2]+" has been successfully Generated - "+vo.getStrRemarks();
				}
	
				System.out.println( "finalRemarks------"+finalRemarks);
				
				dao.setProcInValue(nProcIndex, "modval", 			"1",1); // 1
				dao.setProcInValue(nProcIndex, "itemId",			itemDtl[0],2);// 2
				dao.setProcInValue(nProcIndex, "itemBrandId",		itemDtl[1],3);// 3
				dao.setProcInValue(nProcIndex, "batchNo", 			itemDtl[2],4);// 4
				dao.setProcInValue(nProcIndex, "poNo",				itemDtl[3],5);// 5
				dao.setProcInValue(nProcIndex, "schNo",				itemDtl[4],6);// 6
				dao.setProcInValue(nProcIndex, "suppId",			itemDtl[5],7);// 7
				dao.setProcInValue(nProcIndex, "orderType",			vo.getStrActionMode(),8);// 8
				dao.setProcInValue(nProcIndex, "actionn",			vo.getStrActionsId(),9);// 9
				if(vo.getStrActionsId().equalsIgnoreCase("1"))
				{
				dao.setProcInValue(nProcIndex, "verifyBy",			vo.getStrVerifiedBy(),10);// 10
				}
				else
				{
				dao.setProcInValue(nProcIndex, "verifyBy",			vo.getStrCommitteType(),10);// 10
				}
				dao.setProcInValue(nProcIndex, "verifyDate",		vo.getStrVerifiedDate(),11);// 11
				dao.setProcInValue(nProcIndex, "remarks", 			vo.getStrRemarks(),12);// 12
				dao.setProcInValue(nProcIndex, "seatId",			vo.getStrSeatId(),13);// 13
				dao.setProcInValue(nProcIndex, "hospCode",			vo.getStrHospitalCode(),14);// 14
				dao.setProcInValue(nProcIndex, "deliveryDate",		vo.getStrDeliveryDate(),15);// 15	
				dao.setProcInValue(nProcIndex, "storeid", 			vo.getStrStoreId(),16);// 16
				dao.setProcInValue(nProcIndex, "itemcat", 			vo.getStrcatno(),17);// 16
				
				if(itemDtl.length != 7)
					dao.setProcInValue(nProcIndex, "condemnqty", 	itemDtl[7],18);// 16
				else
					dao.setProcInValue(nProcIndex, "condemnqty", 	itemDtl[6],18);// 16
				//}
				dao.setProcInValue(nProcIndex, "strRetActionType", 	vo.getStrRetActionType()[i],19);// 16
				dao.setProcInValue(nProcIndex, "strItemRemarks", 	finalRemarks ,20);// 16
				dao.setProcOutValue(nProcIndex, "status", 			1,21);// 17
				dao.setProcOutValue(nProcIndex, "err", 				1,22);// 18
				
				dao.executeProcedureByPosition(nProcIndex);	
				
				System.out.println("-----------ReplacementCondemnationOrderTransDAO  . insert------END-----");
				
				strErr = dao.getString(nProcIndex, "err");
				
				String strStauts=dao.getString(nProcIndex, "status");
				
				
				if(strStauts.equals("1"))
				{
					
				}
				else if(strStauts.equals("2"))
				{
					vo.setStrMsgType("2");
				}
			}
			
			
		} catch (Exception _Err) {
			_Err.printStackTrace();
			vo.setStrMsgString("ReplacementCondemnationOrderTransDAO.insert() --> "+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}	
	public synchronized static void CANCELORDER(ReplacementCondemnationOrderTransVO vo) 
	{
		String strProcName = "{call pkg_mms_dml.dml_replacement_po_dtl_cancel_order(?,?,?,?,?,?,?,?)}";	//8 Variables
		
		HisDAO dao = null;
		int nProcIndex = 0;
		String strErr = "";
		try 
		{
			System.out.println("--------------- ReplacementCondemnationOrderTransDAO . CANCELORDER ---[ pkg_mms_dml.dml_replacement_po_dtl_cancel_order  - 1]-------------");
			
			dao = new HisDAO("MMS",	"transactions.CANCELORDER.insert()");
    		nProcIndex = dao.setProcedure(strProcName);
    		dao.setProcInValue(nProcIndex, "modval", "1",1); // 1
    		dao.setProcInValue(nProcIndex, "orderType",vo.getStrActionsId(),2);// 2
			dao.setProcInValue(nProcIndex, "storeid", vo.getStrStoreId(),3);// 3
			dao.setProcInValue(nProcIndex, "itemcat", vo.getStrcatno(),4);// 4
			dao.setProcInValue(nProcIndex, "hospCode",vo.getStrHospitalCode(),5);// 5
			dao.setProcInValue(nProcIndex, "orderno",vo.getStrOrderHiddenValue(),6);// 6
			dao.setProcOutValue(nProcIndex, "status", 1,7);// 7
			dao.setProcOutValue(nProcIndex, "err", 1,8);// 8
			dao.executeProcedureByPosition(nProcIndex);	
			strErr = dao.getString(nProcIndex, "err");
			
			String strStauts=dao.getString(nProcIndex, "status");
			
			
			if(strStauts.equals("1"))
			{
				
			}
			else if(strStauts.equals("2"))
			{
				vo.setStrMsgType("2");
			}
			
			
			
		} catch (Exception _Err) {
			_Err.printStackTrace();
			vo.setStrMsgString("ReplacementCondemnationOrderTransDAO.insert() --> "+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}		
	
	public static void getregularindentdruglist(ReplacementCondemnationOrderTransVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_regular_indent_drug_list(?,?,?,?,?,?)}"; //6 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			System.out.println("--------------- ReplacementCondemnationOrderTransDAO . getregularindentdruglist ---[ pkg_mms_dml.proc_regular_indent_drug_list  - 1]-------------");
			
			daoObj=new HisDAO("Replacement Condemnation Order","ReplacementCondemnationOrderTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "storeId",vo.getStrStoreId(),3);
			daoObj.setProcInValue(nProcIndex, "itemCatg", "10",4);			
			daoObj.setProcOutValue(nProcIndex, "err",1,5); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,6);
			
	
			daoObj.executeProcedureByPosition(nProcIndex);
						
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
				
				vo.setWsRegularIndentDrugs (ws);				
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("ReplacementCondemnationOrderTransDAO.getregularindentdruglist() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void setItemCategCombo(ReplacementCondemnationOrderTransVO _IssueDetailRptVO)
	{
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		
		try 
		{
				dao = new HisDAO("mms", "IssueDetailRptDAO");
				strproc_name = "{call pkg_mms_rpt.Rptm_item_category_list(?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				//System.out.println("modeval"+_IssueDetailRptVO.getStrMode());
				dao.setProcInValue(nprocIndex, "modeval",		"2",1);
				dao.setProcInValue(nprocIndex, "hosp_code", 	_IssueDetailRptVO.getStrHospitalCode(),2);
				dao.setProcInValue(nprocIndex, "storeId",		_IssueDetailRptVO.getStrStoreId(),3);							
				dao.setProcOutValue(nprocIndex, "err", 			1,4);
				dao.setProcOutValue(nprocIndex, "resultset", 	2,5); 
				
				dao.executeProcedureByPosition(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				//System.out.println("asdasdasd"+wb.size());
				if (strerr.equals("")) 
				{
					_IssueDetailRptVO.setItemCategWS(wb);
             	} 
				else 
				{
					throw new Exception(strerr);
				}
		} 
		catch (Exception e) 
		{
			_IssueDetailRptVO.setStrMsgString("IssueDetailRptDAO.setItemCategCombo() --> "+ e.getMessage());
			_IssueDetailRptVO.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
				wb=null;
			}
		}	
	}
	
	public static void getsuppliercmb(ReplacementCondemnationOrderTransVO _IssueDetailRptVO)
	{
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		
		try 
		{
				dao = new HisDAO("mms", "IssueDetailRptDAO");
				strproc_name = "{call pkg_mms_view.proc_supplier_list(?,?,?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				//System.out.println("modeval"+_IssueDetailRptVO.getStrMode());
				dao.setProcInValue(nprocIndex, "modeval","1",1);
				dao.setProcInValue(nprocIndex, "catcode",_IssueDetailRptVO.getStrItemCatNo(),2);
				dao.setProcInValue(nprocIndex, "branditem_id", "0",3);
				dao.setProcInValue(nprocIndex, "contracttype", "0",4);
				dao.setProcInValue(nprocIndex, "hosp_code", _IssueDetailRptVO.getStrHospitalCode(),5);
				dao.setProcOutValue(nprocIndex, "err", 1,6);
				dao.setProcOutValue(nprocIndex, "resultset", 2,7); 
				
				dao.executeProcedureByPosition(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				//System.out.println("asdasdasd"+wb.size());
				if (strerr.equals("")) 
				{
					_IssueDetailRptVO.setSupplierWS(wb);
             	} 
				else 
				{
					throw new Exception(strerr);
				}
		} 
		catch (Exception e) 
		{
			_IssueDetailRptVO.setStrMsgString("IssueDetailRptDAO.setItemCategCombo() --> "+ e.getMessage());
			_IssueDetailRptVO.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
				wb=null;
			}
		}	
	}
		
}
