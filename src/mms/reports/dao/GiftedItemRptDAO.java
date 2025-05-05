package mms.reports.dao;

import javax.sql.rowset.WebRowSet;
import hisglobal.transactionmgnt.HisDAO;

import mms.reports.vo.GiftedItemRptvo;
import mms.reports.vo.IssueToPatientDetailRptVO;

public class GiftedItemRptDAO {
	
	public static void storeName(GiftedItemRptvo vo){
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
	
	
	public static void getViewDtl(GiftedItemRptvo _GiftedItemRptvo)
	{
		
		String strProcName = "{call pkg_mms_view.proc_gifteditem_RPT(?,?,?,?,?, ?,?,?,?,?, ?)}";
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		
	
		try
		{
			daoObj  = new HisDAO("MMS","LocalPurchaseMRN_DAO");
			
//			System.out.println(" ----------> _GiftedItemRptvo.getStrHospitalCode() -------- " + _GiftedItemRptvo.getStrHospitalCode());
//			System.out.println(" ----------> _GiftedItemRptvo.getStrStoreId()-------- " + _GiftedItemRptvo.getStrStoreId());
//			System.out.println(" ----------> _GiftedItemRptvo.getStrItemCategoryId() -------- " + _GiftedItemRptvo.getStrItemCategoryId());
//			System.out.println(" ----------> _GiftedItemRptvo.getStrInstituteId()-------- " + _GiftedItemRptvo.getStrInstituteId());
//			System.out.println(" ----------> _GiftedItemRptvo.getStrFinancialStartYear() -------- " + _GiftedItemRptvo.getStrFinancialStartYear());
//			System.out.println(" ----------> _GiftedItemRptvo.getStrFinancialEndYear() -------- " + _GiftedItemRptvo.getStrFinancialEndYear());
//			System.out.println(" ----------> _GiftedItemRptvo.getStrSupplierName() -------- " + _GiftedItemRptvo.getStrSupplierName());
//			System.out.println(" ----------> _GiftedItemRptvo.getStrSupplierId() -------- " + _GiftedItemRptvo.getStrSupplierId());
//			System.out.println(" ----------> _GiftedItemRptvo.getStrlpItemId----------"+ _GiftedItemRptvo.getStrlpItemId());
//			System.out.println(" ----------> _GiftedItemRptvo.getStrlpItemName----------"+ _GiftedItemRptvo.getStrlpItemName());

			nProcIndex = daoObj.setProcedure(strProcName);
			

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);  											    //------------------------------------------------------------1
			daoObj.setProcInValue(nProcIndex, "hosp_code", _GiftedItemRptvo.getStrHospitalCode(),2);	     	//------------------------------------------------------------2
			daoObj.setProcInValue(nProcIndex, "item_cat_code", _GiftedItemRptvo.getStrItemCategoryId(),3);     	//------------------------------------------------------------4
			daoObj.setProcInValue(nProcIndex, "storeid",        _GiftedItemRptvo.getStrStoreId(),4);	     		//------------------------------------------------------------5
			daoObj.setProcInValue(nProcIndex, "fin_st_date", _GiftedItemRptvo.getStrFinancialStartYear(),5);  	//------------------------------------------------------------6
			daoObj.setProcInValue(nProcIndex, "fin_end_date", _GiftedItemRptvo.getStrFinancialEndYear(),6);     //------------------------------------------------------------7
			
			daoObj.setProcInValue(nProcIndex, "Item_Id",_GiftedItemRptvo.getStrlpItemId(),7);
			daoObj.setProcInValue(nProcIndex, "InstituteId",  "0",8);
			daoObj.setProcInValue(nProcIndex, "Supplier_Id", "0",9);
			
			daoObj.setProcOutValue(nProcIndex, "err",1,10); 													 	//------------------------------------------------------------8
			daoObj.setProcOutValue(nProcIndex, "resultset",2,11);											    //------------------------------------------------------------9
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
//			System.out.println(" ----------> Size---------"+ ws.size());

			if(strErr.equals(""))
			{
				_GiftedItemRptvo.setWsItemCategoryCombo(ws);
			}
		}
		catch(Exception _err)
		{
			_GiftedItemRptvo.setStrMsgString("LocalPurchaseMRN_DAO.getViewDtl() --> "	+ _err.getMessage());
			_GiftedItemRptvo.setStrMsgType("1");
		}
		 finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
	}

	
	
	public static void lpitemName(GiftedItemRptvo voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_get_Drug_list_Combo1(?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		System.out.println("voObj.getStrStoreId()-------->"+voObj.getStrStoreId());
		System.out.println("--------vo.getStrItemCategoryNo()--------"+voObj.getlpItemvalue());

		try {
			daoObj = new HisDAO("MMS Transactions", "StockOnHandRptDAO");
			//
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "p_mode", "4");
			daoObj.setProcInValue(nProcIndex, "p_hstnum_store_id",voObj.getStrStoreId().equals("")||voObj.getStrStoreId()==null?"0":voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "p_hstnum_item_id", "0");
			daoObj.setProcInValue(nProcIndex, "p_hstnum_itembrand_id", "0");
			daoObj.setProcInValue(nProcIndex, "p_hststr_batch_no", "0");
			daoObj.setProcInValue(nProcIndex, "p_gnum_hospital_code",voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_sstnum_item_cat_no",voObj.getlpItemvalue());
			daoObj.setProcInValue(nProcIndex, "p_hstnum_stock_status_code","0");
			daoObj.setProcInValue(nProcIndex, "p_hstnum_group_id","0");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			daoObj.executeProcedure(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");
			
			
			
			
			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				//System.out.println("no of item"+ws.size());
//				voObj.setWsItemCategoryCombo(ws);
				voObj.setWslpItemName(ws);
				System.out.println(voObj.getWslpItemName().size());
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			e.printStackTrace();
			voObj.setStrMsgString("StockOnHandRptDAO.getDrugList() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	public static void itemCategory(GiftedItemRptvo vo)
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

	public static void getInstituteList(GiftedItemRptvo vo) {

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
	
	public static void lpitemName1(GiftedItemRptvo vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		
		System.out.println("--------vo.getStrItemCategoryNo()--------"+vo.getlpItemvalue());
		
		try {
			dao = new HisDAO("mms", "LocalPurchaseMRN_DAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_item_name(?,?,?,?,?)}"; //5
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "4",1);
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
				System.out.println(vo.getWslpItemName().size());

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
	
	public static void getSupplierCombo(GiftedItemRptvo vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "LocalPurchaseMRN_DAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_combo(?,?,?,?)}"; //4
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "2",1);
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
