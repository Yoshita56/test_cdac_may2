package mms.reports.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.reports.vo.BreakageAndLostDrugDetailsRptVO;
import mms.reports.vo.New_Report_For_AcknowledgeVO;

public class New_Report_For_AcknowledgeDAO {
	
	public static void storeName(New_Report_For_AcknowledgeVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}"; //4+3=7
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try{
			daoObj=new HisDAO("Gifted Item Details","LocalPurchaseMRN_DAO");
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
			vo.setStrMsgString("LocalPurchaseMRN_DAO.storeName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	public static void getViewDtl(New_Report_For_AcknowledgeVO _LocalPurchaseMRN_VO)
	{
		
		String strProcName = "{call pkg_mms_view.New_Report_For_Acknowledge_Transfer_Issue(?,?,?,?,?, ?,?,?,?,?, ?)}";
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj  = new HisDAO("MMS","LocalPurchaseMRN_DAO");
			
			System.out.println(" ----------pkg_mms_view.New_Report_For_Acknowledge_Transfer_Issue ------ " +  _LocalPurchaseMRN_VO.getStrActId());
			/*
			System.out.println(" ----------> getStrStoreId()------------ " +  _LocalPurchaseMRN_VO.getStrHospitalCode());
			System.out.println(" ----------> getStrItemCategoryId() ---- " +  _LocalPurchaseMRN_VO.getStrStoreId());
			System.out.println(" ----------> getStrInstituteId()-------- " +  _LocalPurchaseMRN_VO.getStrItemCategoryId());
			System.out.println(" ----------> getStrFinancialStartYear()- " +  _LocalPurchaseMRN_VO.getStrFinancialStartYear());
			System.out.println(" ----------> getStrFinancialEndYear() -- " +  _LocalPurchaseMRN_VO.getStrFinancialEndYear());
			*/
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", 		_LocalPurchaseMRN_VO.getStrActId(),1);  			
			daoObj.setProcInValue(nProcIndex, "hosp_code", 		_LocalPurchaseMRN_VO.getStrHospitalCode(),2);	    
			daoObj.setProcInValue(nProcIndex, "strid", 			_LocalPurchaseMRN_VO.getStrStoreId(),3);			
			daoObj.setProcInValue(nProcIndex, "itemcategno", 	_LocalPurchaseMRN_VO.getStrItemCategoryId(),4);     
			daoObj.setProcInValue(nProcIndex, "InstituteId", 	"0",5);	     
			daoObj.setProcInValue(nProcIndex, "start_date", 	_LocalPurchaseMRN_VO.getStrFinancialStartYear(),6);  
			daoObj.setProcInValue(nProcIndex, "end_date", 		_LocalPurchaseMRN_VO.getStrFinancialEndYear(),7);    
			daoObj.setProcInValue(nProcIndex, "SupplierId", 	"0",8);			 
			daoObj.setProcInValue(nProcIndex, "StrlpItemId", 	_LocalPurchaseMRN_VO.getStrlpItemId(),9);		     
			daoObj.setProcOutValue(nProcIndex, "err",			1,10); 												
			daoObj.setProcOutValue(nProcIndex, "resultset",		2,11);											    
			
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
			_LocalPurchaseMRN_VO.setStrMsgString("LocalPurchaseMRN_DAO.getViewDtl() --> "	+ _err.getMessage());
			_LocalPurchaseMRN_VO.setStrMsgType("1");
		}
		 finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
	}

	public static void itemCategory(New_Report_For_AcknowledgeVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_item_category_list(?,?,?,?,?,?)}"; //6
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try
		{
			daoObj=new HisDAO("Gifted Item Details","LocalPurchaseMRN_DAO");
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
			vo.setStrMsgString("LocalPurchaseMRN_DAO.itemCategory() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void getInstituteList(New_Report_For_AcknowledgeVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "LocalPurchaseMRN_DAO");
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
					.setStrMsgString("LocalPurchaseMRN_DAO.getInstituteList() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void lpitemName(New_Report_For_AcknowledgeVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		
		//System.out.println("--------vo.getStrItemCategoryNo()--------"+vo.getlpItemvalue());
		
		try {
			dao = new HisDAO("mms", "LocalPurchaseMRN_DAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_item_name(?,?,?,?,?)}"; //4
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "5",1);
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
			vo.setStrMsgString("LocalPurchaseMRN_DAO.getlpItemName() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
//	Supplier Combo
	
	public static void getSupplierCombo(New_Report_For_AcknowledgeVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "LocalPurchaseMRN_DAO");
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
			vo.setStrMsgString("LocalPurchaseMRN_DAO.getInstituteList() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getImageHeader(New_Report_For_AcknowledgeVO vo)
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
