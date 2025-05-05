package mms.reports.dao;

import javax.sql.rowset.WebRowSet;
import hisglobal.transactionmgnt.HisDAO;
import mms.reports.vo.BreakageItemVO;
import mms.reports.vo.GiftedItemRptvo;

public class BreakageItemDAO {
	
	public static void storeName(BreakageItemVO vo){
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
	
	
	public static void getViewDtl(BreakageItemVO _BreakageItemVO)
	{
		
		String strProcName = "{call pkg_mms_view.rptm_breakageandlostdrugdtls(?,?,?,?,?, ?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj  = new HisDAO("MMS","LocalPurchaseMRN_DAO");
			
		
			
			System.out.println(" ----------> _BreakageItemVO.getStrHospitalCode() -------- " + _BreakageItemVO.getStrHospitalCode());
			System.out.println(" ----------> _BreakageItemVO.getStrStoreId()-------- " + _BreakageItemVO.getStrStoreId());
			System.out.println(" ----------> _BreakageItemVO.getStrItemCategoryId() -------- " + _BreakageItemVO.getStrItemCategoryId());
			System.out.println(" ----------> _BreakageItemVO.getStrFinancialStartYear() -------- " + _BreakageItemVO.getStrFinancialStartYear());
			System.out.println(" ----------> _BreakageItemVO.getStrFinancialEndYear() -------- " + _BreakageItemVO.getStrFinancialEndYear());
			System.out.println(" ----------> _BreakageItemVO.getStrlpItemId----------"+ _BreakageItemVO.getStrlpItemId());
			System.out.println(" ----------> _BreakageItemVO.getStrlpItemName----------"+ _BreakageItemVO.getStrlpItemName());
			
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);  											     //------------------------------------------------------------1
			daoObj.setProcInValue(nProcIndex, "hosp_code", _BreakageItemVO.getStrHospitalCode(),2);	     //------------------------------------------------------------2
			daoObj.setProcInValue(nProcIndex, "strid", _BreakageItemVO.getStrStoreId(),3);				     //------------------------------------------------------------3
			daoObj.setProcInValue(nProcIndex, "itemcategno", _BreakageItemVO.getStrItemCategoryId(),4);     //------------------------------------------------------------4
//			daoObj.setProcInValue(nProcIndex, "InstituteId", _BreakageItemVO.getStrInstituteId(),5);	     //------------------------------------------------------------5
			daoObj.setProcInValue(nProcIndex, "start_date", _BreakageItemVO.getStrFinancialStartYear(),5);  //------------------------------------------------------------6
			daoObj.setProcInValue(nProcIndex, "end_date", _BreakageItemVO.getStrFinancialEndYear(),6);      //------------------------------------------------------------7
//			daoObj.setProcInValue(nProcIndex, "SupplierId", _BreakageItemVO.getStrSupplierId(),8);			 //------------------------------------------------------------8
			daoObj.setProcInValue(nProcIndex, "StrlpItemId", _BreakageItemVO.getStrlpItemId(),7);		     //------------------------------------------------------------9
			daoObj.setProcOutValue(nProcIndex, "err",1,8); 													 //------------------------------------------------------------10
			daoObj.setProcOutValue(nProcIndex, "resultset",2,9);											     //------------------------------------------------------------11
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			System.out.println(" ----------> Size---------"+ ws.size());

			if(strErr.equals(""))
			{
				_BreakageItemVO.setWsItemCategoryCombo(ws);
			}
		}
		catch(Exception _err)
		{
			_BreakageItemVO.setStrMsgString("LocalPurchaseMRN_DAO.getViewDtl() --> "	+ _err.getMessage());
			_BreakageItemVO.setStrMsgType("1");
		}
		 finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
	}

	public static void itemCategory(BreakageItemVO vo)
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

	public static void getInstituteList(BreakageItemVO vo) {

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
	
	public static void lpitemName(BreakageItemVO voObj) {

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
	
	
	public static void lpitemName1(BreakageItemVO vo) {

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
	
	public static void getSupplierCombo(BreakageItemVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "LocalPurchaseMRN_DAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_combo(?,?,?,?)}"; //4
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
