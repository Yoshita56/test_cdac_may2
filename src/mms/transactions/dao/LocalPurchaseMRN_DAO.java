package mms.transactions.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.transactions.vo.LocalPurchaseMRN_VO;

public class LocalPurchaseMRN_DAO {
	
	public static void storeName(LocalPurchaseMRN_VO vo){
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
	
	public static void getGroupList(LocalPurchaseMRN_VO voObj) 
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.rptm_store_group_list(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "StockOnHandRptDAO");
			//
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code","100");
			daoObj.setProcInValue(nProcIndex, "item_category",voObj.getStrItemCategoryId());
					
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				//System.out.println("ws"+ws.size());
				voObj.setStrGroupCmbWS(ws);
				

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("StockOnHandRptDAO.getGroupList() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	
	public static void getViewDtl(LocalPurchaseMRN_VO _LocalPurchaseMRN_VO)
	{
		
		String strProcName = "{call pkg_mms_view.proc_local_purchase_mrn(?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj  = new HisDAO("MMS","LocalPurchaseMRN_DAO");
			
			//System.out.println(" ----------> _LocalPurchaseMRN_VO.getStrHospitalCode() -------- " + _LocalPurchaseMRN_VO.getStrHospitalCode());
			//System.out.println(" ----------> _LocalPurchaseMRN_VO.getStrStoreId()-------- " + _LocalPurchaseMRN_VO.getStrStoreId());
			//System.out.println(" ----------> _LocalPurchaseMRN_VO.getStrItemCategoryId() -------- " + _LocalPurchaseMRN_VO.getStrItemCategoryId());
			//System.out.println(" ----------> _LocalPurchaseMRN_VO.getStrInstituteId()-------- " + _LocalPurchaseMRN_VO.getStrInstituteId());
			//System.out.println(" ----------> _LocalPurchaseMRN_VO.getStrFinancialStartYear() -------- " + _LocalPurchaseMRN_VO.getStrFinancialStartYear());
			//System.out.println(" ----------> _LocalPurchaseMRN_VO.getStrFinancialEndYear() -------- " + _LocalPurchaseMRN_VO.getStrFinancialEndYear());
			//System.out.println(" ----------> _LocalPurchaseMRN_VO.getStrSupplierName() -------- " + _LocalPurchaseMRN_VO.getStrSupplierName());
			//System.out.println(" ----------> _LocalPurchaseMRN_VO.getStrSupplierId() -------- " + _LocalPurchaseMRN_VO.getStrSupplierId());
			//System.out.println(" ----------> _LocalPurchaseMRN_VO.getStrlpItemId----------"+ _LocalPurchaseMRN_VO.getStrlpItemId());
			//System.out.println(" ----------> _LocalPurchaseMRN_VO.getStrlpItemName----------"+ _LocalPurchaseMRN_VO.getStrlpItemName());
			
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", 		_LocalPurchaseMRN_VO.getStrActId(),1);  											     //------------------------------------------------------------1
			daoObj.setProcInValue(nProcIndex, "hosp_code", 		_LocalPurchaseMRN_VO.getStrGroupId(),2);	     //------------------------------------------------------------2
			daoObj.setProcInValue(nProcIndex, "strid", 			_LocalPurchaseMRN_VO.getStrStoreId(),3);				     //------------------------------------------------------------3
			daoObj.setProcInValue(nProcIndex, "itemcategno", 	_LocalPurchaseMRN_VO.getStrItemCategoryId(),4);     //------------------------------------------------------------4
			daoObj.setProcInValue(nProcIndex, "InstituteId", 	_LocalPurchaseMRN_VO.getStrInstituteId(),5);	     //------------------------------------------------------------5
			daoObj.setProcInValue(nProcIndex, "start_date", 	_LocalPurchaseMRN_VO.getStrFinancialStartYear(),6);  //------------------------------------------------------------6
			daoObj.setProcInValue(nProcIndex, "end_date", 		_LocalPurchaseMRN_VO.getStrFinancialEndYear(),7);      //------------------------------------------------------------7
			daoObj.setProcInValue(nProcIndex, "SupplierId", 	_LocalPurchaseMRN_VO.getStrSupplierId(),8);			 //------------------------------------------------------------8
			daoObj.setProcInValue(nProcIndex, "StrlpItemId", 	_LocalPurchaseMRN_VO.getStrlpItemId(),9);		     //------------------------------------------------------------9
			daoObj.setProcOutValue(nProcIndex, "err",1,10); 													 //------------------------------------------------------------10
			daoObj.setProcOutValue(nProcIndex, "resultset",2,11);											     //------------------------------------------------------------11
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
//			System.out.println(" ----------> Size---------"+ ws.size());

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

	public static void itemCategory(LocalPurchaseMRN_VO vo)
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
			daoObj.setProcInValue(nProcIndex, "modeval", "4",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "reqType", "64",4);
			daoObj.setProcOutValue(nProcIndex, "err",1,5); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,6);
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

	public static void getInstituteList(LocalPurchaseMRN_VO vo) {

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
	
	public static void lpitemName(LocalPurchaseMRN_VO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		
		System.out.println("--------vo.getStrItemCategoryNo()--------"+vo.getlpItemvalue());
		
		try {
			dao = new HisDAO("mms", "LocalPurchaseMRN_DAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_item_name(?,?,?,?,?)}"; //4
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1",1);
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
			vo
					.setStrMsgString("LocalPurchaseMRN_DAO.getlpItemName() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
//	Supplier Combo
	
	public static void getSupplierCombo(LocalPurchaseMRN_VO vo) {

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

}
