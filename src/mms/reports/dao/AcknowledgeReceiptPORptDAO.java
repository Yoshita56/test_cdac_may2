package mms.reports.dao;

import javax.sql.rowset.WebRowSet;
import hisglobal.transactionmgnt.HisDAO;
import mms.reports.vo.AcknowledgeReceiptPORptVO;

public class AcknowledgeReceiptPORptDAO {
	
	public static void storeName(AcknowledgeReceiptPORptVO vo){
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
	
	
	public static void getViewDtl(AcknowledgeReceiptPORptVO _AcknowledgeReceiptPORptVO)
	{
		
		String strProcName = "{call pkg_mms_view.proc_Acknowledge_Receipt_PO_Rpt_Show(?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj  = new HisDAO("MMS","LocalPurchaseMRN_DAO");
			
//			System.out.println(" ----------> _AcknowledgeReceiptPORptVO.getStrHospitalCode() -------- " + _AcknowledgeReceiptPORptVO.getStrHospitalCode());
//			System.out.println(" ----------> _AcknowledgeReceiptPORptVO.getStrItemCategoryId() -------- " + _AcknowledgeReceiptPORptVO.getStrItemCategoryId());
//			System.out.println(" ----------> _AcknowledgeReceiptPORptVO.getStrInstituteId()-------- " + _AcknowledgeReceiptPORptVO.getStrInstituteId());
//			System.out.println(" ----------> _AcknowledgeReceiptPORptVO.getStrFinancialStartYear() -------- " + _AcknowledgeReceiptPORptVO.getStrFinancialStartYear());
//			System.out.println(" ----------> _AcknowledgeReceiptPORptVO.getStrFinancialEndYear() -------- " + _AcknowledgeReceiptPORptVO.getStrFinancialEndYear());
//			System.out.println(" ----------> _AcknowledgeReceiptPORptVO.getStrSupplierName() -------- " + _AcknowledgeReceiptPORptVO.getStrSupplierName());
//			System.out.println(" ----------> _AcknowledgeReceiptPORptVO.getStrSupplierId() -------- " + _AcknowledgeReceiptPORptVO.getStrSupplierId());
//			
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);  											     	  //------------------------------------------------------------1
			daoObj.setProcInValue(nProcIndex, "hosp_code", _AcknowledgeReceiptPORptVO.getStrHospitalCode(),2);	      //------------------------------------------------------------2
			daoObj.setProcInValue(nProcIndex, "strid", "0",3);				     									  //------------------------------------------------------------3
			daoObj.setProcInValue(nProcIndex, "itemcategno",_AcknowledgeReceiptPORptVO.getStrItemCategoryId(),4);     //------------------------------------------------------------4
			daoObj.setProcInValue(nProcIndex, "InstituteId", _AcknowledgeReceiptPORptVO.getStrInstituteId(),5);	      //------------------------------------------------------------5
			daoObj.setProcInValue(nProcIndex, "start_date", _AcknowledgeReceiptPORptVO.getStrFinancialStartYear(),6); //------------------------------------------------------------6
			daoObj.setProcInValue(nProcIndex, "end_date", _AcknowledgeReceiptPORptVO.getStrFinancialEndYear(),7);     //------------------------------------------------------------7
			daoObj.setProcInValue(nProcIndex, "SupplierId", _AcknowledgeReceiptPORptVO.getStrSupplierId(),8);		  //------------------------------------------------------------8
			daoObj.setProcInValue(nProcIndex, "StrlpItemId", "0",9);		        								  //------------------------------------------------------------9
			daoObj.setProcOutValue(nProcIndex, "err",1,10); 													      //------------------------------------------------------------10
			daoObj.setProcOutValue(nProcIndex, "resultset",2,11);											          //------------------------------------------------------------11
			
			System.out.println(nProcIndex);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
//			System.out.println(" ----------> Size---------"+ ws.size());

			if(strErr.equals(""))
			{
				_AcknowledgeReceiptPORptVO.setWsItemCategoryCombo(ws);
			}
		}
		catch(Exception _err)
		{
			_AcknowledgeReceiptPORptVO.setStrMsgString("LocalPurchaseMRN_DAO.getViewDtl() --> "	+ _err.getMessage());
			_AcknowledgeReceiptPORptVO.setStrMsgType("1");
		}
		 finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
	}

	public static void itemCategory(AcknowledgeReceiptPORptVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_Acknowledge_Receipt_PO_Report(?,?,?,?,?,?)}"; //6
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
			daoObj.setProcInValue(nProcIndex, "store_id", "1",2);
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

	public static void getInstituteList(AcknowledgeReceiptPORptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			System.out.println("-----vo.getStrHospitalCode()-----"+vo.getStrHospitalCode());
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
	
	public static void lpitemName(AcknowledgeReceiptPORptVO vo) {

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
	
	public static void getSupplierCombo(AcknowledgeReceiptPORptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		
		System.out.println("--------vo.getStrHospitalCode()--------"+vo.getStrHospitalCode());
		try {
			dao = new HisDAO("mms", "LocalPurchaseMRN_DAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_receipt_combo(?,?,?,?)}"; //4
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
