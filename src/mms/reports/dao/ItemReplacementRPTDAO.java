package mms.reports.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.reports.vo.ItemReplacementRPTVO;

public class ItemReplacementRPTDAO {
	
	public static void storeName(ItemReplacementRPTVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}"; //4+3=7
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try{
			daoObj=new HisDAO("Gifted Item Details","IndentWiseIssueRPTDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval","11",1);
			daoObj.setProcInValue(nProcIndex, "seatId", vo.getStrSeatId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "storeid","0",4);
			daoObj.setProcInValue(nProcIndex, "storetype_id","0",5);
			daoObj.setProcOutValue(nProcIndex, "err",1,6); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,7);
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			
			if (strErr.equals("")) {
				vo.setWsStoreNameCombo(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("IndentWiseIssueRPTDAO.storeName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void itemCategory(ItemReplacementRPTVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_item_category_list(?,?,?,?,?,?)}"; //6
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try
		{
			daoObj=new HisDAO("Gifted Item Details","IndentWiseIssueRPTDAO");
			nProcIndex = daoObj.setProcedure(strProcName);	
			daoObj.setProcInValue(nProcIndex, "modeval", 	"3",1);
			daoObj.setProcInValue(nProcIndex, "store_id", 	vo.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", 	vo.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "reqType", 	"64",4);
			daoObj.setProcOutValue(nProcIndex, "err",		1,5); 
			daoObj.setProcOutValue(nProcIndex, "resultset",	2,6);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setWsItemCategoryCombo(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("IndentWiseIssueRPTDAO.itemCategory() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void getImageHeader(ItemReplacementRPTVO vo)
	{
		String strFuncName = "";
		String strLogoName = "";
		
		int nFuncIndex = 0;
		HisDAO dao = null;
		try 
		{
			dao = new HisDAO("DWH","New_Report_For_AcknowledgeDAO");
			
			strFuncName = "{? = call MMS_MST.logo_config_dtl(?,?)}";
			nFuncIndex = dao.setFunction(strFuncName);
			
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncOutValue(nFuncIndex, 1);
			
			dao.executeFunction(nFuncIndex);
			
			strLogoName = dao.getFuncString(nFuncIndex);
			vo.setStrLogoName(strLogoName);

		} catch (Exception e) {
			
			e.printStackTrace();
			vo.setStrMsgType("1");
			vo.setStrMsgString("IssueTransDAO.getImageHeader() --> "+ e.getMessage());
			
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}
		}	
	}

	public static void getReplacementDtl(ItemReplacementRPTVO vo)
	{
		String strProcName = "{call pkg_mms_view2.proc_item_transfer_report(?,?,?,?,?, ?,?,?,?)}"; //9
		//String strProcName = "{call pkg_mms_view2.proc_item_transfer_report(?::character varying,?::character varying,?::character varying,?::character varying,? ::character varying,?::character varying,?::character varying,?::character varying,?)}";

		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj  = new HisDAO("MMS","ItemTransferRPTDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", 		"2",1);  			
			daoObj.setProcInValue(nProcIndex, "hosp_code", 		vo.getStrHospitalCode(),2);	    
			daoObj.setProcInValue(nProcIndex, "strid", 			vo.getStrStoreId(),3);			
			daoObj.setProcInValue(nProcIndex, "catcode", 	    vo.getStrItemCategoryId(),4);      
			daoObj.setProcInValue(nProcIndex, "frmdate", 	    vo.getStrFinancialStartYear(),5);  
			daoObj.setProcInValue(nProcIndex, "todate", 		vo.getStrFinancialEndYear(),6);   
			daoObj.setProcInValue(nProcIndex, "debitNo", 		(vo.getStrDebitNoteNo()==null||vo.getStrDebitNoteNo().equals(""))?"0":vo.getStrDebitNoteNo(),7);
			daoObj.setProcOutValue(nProcIndex, "err",			1,8); 												
			daoObj.setProcOutValue(nProcIndex, "resultset",		2,9);			
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if(strErr.equals(""))
			{
				vo.setWsItemCategoryCombo(ws);
			}
		}
		catch(Exception _err)
		{
			vo.setStrMsgString("ItemTransferRPTDAO.getViewDtl() --> "	+ _err.getMessage());
			vo.setStrMsgType("1");
		}
		 finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
		}
	}
	
	public static void getVoucherDtl(ItemReplacementRPTVO vo) 
	{
		String strProcName = "{call pkg_mms_view.proc_Ret_And_Condemn_Register(?,?,?,?,? ,?,?,?,?)}"; // 9 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try
		{
			
			daoObj=new HisDAO("mms","ReturnAndCondemnationRegisterTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", 	"3",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", 	vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "storeId", 	vo.getStrStoreId(),3);
			daoObj.setProcInValue(nProcIndex, "itemCatg", 	vo.getStrItemCategoryId(),4);
			daoObj.setProcInValue(nProcIndex, "orderNo", 	(vo.getStrDebitNoteNo()==null||vo.getStrDebitNoteNo().equals(""))?"0":vo.getStrDebitNoteNo(),5);
			daoObj.setProcInValue(nProcIndex, "brandId", 	(vo.getStrItemBrandId()==null||vo.getStrItemBrandId().equals(""))?"0":vo.getStrItemBrandId(),6);
			daoObj.setProcInValue(nProcIndex, "batchNo", 	vo.getStrBatchNo(),7);
			daoObj.setProcOutValue(nProcIndex, "err",		1,8); 
			daoObj.setProcOutValue(nProcIndex, "resultset",	2,9);
			daoObj.executeProcedureByPosition(nProcIndex);
						
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");			
			if (strErr.equals("")) {
				vo.setWsNOSQItemDetail(ws);				
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("ReturnAndCondemnationRegisterTransDAO.getNOSQDrugList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	
}
