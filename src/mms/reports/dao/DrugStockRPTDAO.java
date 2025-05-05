package mms.reports.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.reports.vo.DrugStockRPTVO;

public class DrugStockRPTDAO {
	
	public static void storeName(DrugStockRPTVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}"; //4+3=7
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try{
			daoObj=new HisDAO("Gifted Item Details","IndentWiseIssueRPTDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "seatId", vo.getStrSeatId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
			daoObj.setProcOutValue(nProcIndex, "err",1,6); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,7);
			
			/* Start Adding Default value*/
			daoObj.setProcInValue(nProcIndex, "modeval","11",1);
			daoObj.setProcInValue(nProcIndex, "storeid","0",4);
			daoObj.setProcInValue(nProcIndex, "storetype_id","0",5);
			/* End Adding Default value*/
			
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
	
	
	public static void getViewDtl(DrugStockRPTVO _LocalPurchaseMRN_VO)
	{
		
		String strProcName = "{call pkg_mms_view2.issue_stock_report(?,?,?,?,?  ,?,?,?,?)}";  // 9
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj  = new HisDAO("MMS","IndentWiseIssueRPTDAO");
			
			System.out.println(" ----------pkg_mms_view2.issue_stock_report ------ " +  _LocalPurchaseMRN_VO.getStrActId());
			/*
			System.out.println(" ----------> getStrStoreId()------------ " +  _LocalPurchaseMRN_VO.getStrStoreId());
			System.out.println(" ----------> getStrItemCategoryId() ---- " +  _LocalPurchaseMRN_VO.getStrItemCategoryId());
			System.out.println(" ----------> getStrFinancialStartYear()- " +  _LocalPurchaseMRN_VO.getStrFinancialStartYear());
			System.out.println(" ----------> getStrFinancialEndYear() -- " +  _LocalPurchaseMRN_VO.getStrFinancialEndYear());
			System.out.println(" ----------> getStrItemBrandId() -- " +  _LocalPurchaseMRN_VO.getStrItemBrandId());
			*/
			
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", 		"1",1);  			
			daoObj.setProcInValue(nProcIndex, "hosp_code", 		_LocalPurchaseMRN_VO.getStrHospitalCode(),2);	    
			daoObj.setProcInValue(nProcIndex, "strid", 			_LocalPurchaseMRN_VO.getStrStoreId(),3);			
			daoObj.setProcInValue(nProcIndex, "catcode", 	    _LocalPurchaseMRN_VO.getStrItemCategoryId(),4);      
			daoObj.setProcInValue(nProcIndex, "frmdate", 	    _LocalPurchaseMRN_VO.getStrFinancialStartYear(),5);  
			daoObj.setProcInValue(nProcIndex, "todate", 		_LocalPurchaseMRN_VO.getStrFinancialEndYear(),6);  
			daoObj.setProcInValue(nProcIndex, "brandId", 		_LocalPurchaseMRN_VO.getStrItemBrandId(),7); 
			
			daoObj.setProcOutValue(nProcIndex, "err",			1,8); 												
			daoObj.setProcOutValue(nProcIndex, "resultset",		2,9);											    
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println(" ----------> Size---------"+ ws.size());

			if(strErr.equals(""))
			{
				_LocalPurchaseMRN_VO.setWsItemCategoryCombo(ws);
			}
		}
		catch(Exception _err)
		{
			_LocalPurchaseMRN_VO.setStrMsgString("IndentWiseIssueRPTDAO.getViewDtl() --> "	+ _err.getMessage());
			_LocalPurchaseMRN_VO.setStrMsgType("1");
		}
		 finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
	}

	public static void itemCategory(DrugStockRPTVO vo)
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
			daoObj.setProcInValue(nProcIndex, "hosp_code", 	vo.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "store_id", 	vo.getStrStoreId(),2);
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

	public static void getInstituteList(DrugStockRPTVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "IndentWiseIssueRPTDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_institute_list(?,?,?,?)}"; //4
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcOutValue(nprocIndex, "err", 1,3);
			dao.setProcOutValue(nprocIndex, "resultset", 2,4);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {

				vo.setWsInstituteList(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo
					.setStrMsgString("IndentWiseIssueRPTDAO.getInstituteList() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void lpitemName(DrugStockRPTVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		
		//System.out.println("--------vo.getStrItemCategoryNo()--------"+vo.getlpItemvalue());
		
		try {
			dao = new HisDAO("mms", "IndentWiseIssueRPTDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_item_name(?,?,?,?,?)}"; //4
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "6",1);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nprocIndex, "lpItemvalue", vo.getlpItemvalue(),3);
			dao.setProcOutValue(nprocIndex, "err", 1,4);
			dao.setProcOutValue(nprocIndex, "resultset", 2,5);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {

				vo.setWslpItemName(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("IndentWiseIssueRPTDAO.getlpItemName() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
//	Supplier Combo
	
	public static void getSupplierCombo(DrugStockRPTVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "IndentWiseIssueRPTDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_combo(?,?,?,?)}"; //4
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1",1);  // Mode - 2 for Nagpur For Else Use Mode - 1
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcOutValue(nprocIndex, "err", 1,3);
			dao.setProcOutValue(nprocIndex, "resultset", 2,4);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			
			if (strerr == null)
				strerr = "";
			
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			
			if (strerr.equals("")) {

				vo.setWsSupplierCombo(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("IndentWiseIssueRPTDAO.getInstituteList() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getImageHeader(DrugStockRPTVO vo)
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
			System.out.println(">>>>>>>>>>>>>>>    strLogoName  >>>>>>>>>>>>>>>>>>>>"+strLogoName);

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



}
