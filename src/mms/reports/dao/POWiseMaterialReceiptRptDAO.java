package mms.reports.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.reports.vo.POWiseMaterialReceiptRptVO;

public class POWiseMaterialReceiptRptDAO {
	
	public static void storeName(POWiseMaterialReceiptRptVO vo){
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}"; //4+3=7
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try{
			daoObj=new HisDAO("Gifted Item Details","POWiseMaterialReceiptRptDAO");
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
			e.printStackTrace();
			vo.setStrMsgString("POWiseMaterialReceiptRptDAO.storeName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	public static void getViewDtl(POWiseMaterialReceiptRptVO _POWiseMaterialReceiptRptVO)
	{
		
		String strProcName = "{call pkg_mms_view2.proc_supplier_purchase_mrn(?,?,?,?,?  ,?,?,?,?,?  ,?,?,?)}"; //12
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj  = new HisDAO("MMS","POWiseMaterialReceiptRptDAO");
			
			//System.out.println(" ----------> _POWiseMaterialReceiptRptVO.getStrHospitalCode() -------- " + _POWiseMaterialReceiptRptVO.getStrHospitalCode());
			//System.out.println(" ----------> _POWiseMaterialReceiptRptVO.getStrStoreId()-------- " + _POWiseMaterialReceiptRptVO.getStrStoreId());
			//System.out.println(" ----------> _POWiseMaterialReceiptRptVO.getStrItemCategoryId() -------- " + _POWiseMaterialReceiptRptVO.getStrItemCategoryId());
			//System.out.println(" ----------> _POWiseMaterialReceiptRptVO.getStrInstituteId()-------- " + _POWiseMaterialReceiptRptVO.getStrInstituteId());
			//System.out.println(" ----------> _POWiseMaterialReceiptRptVO.getStrFinancialStartYear() -------- " + _POWiseMaterialReceiptRptVO.getStrFinancialStartYear());
			//System.out.println(" ----------> _POWiseMaterialReceiptRptVO.getStrFinancialEndYear() -------- " + _POWiseMaterialReceiptRptVO.getStrFinancialEndYear());
			//System.out.println(" ----------> _POWiseMaterialReceiptRptVO.getStrSupplierName() -------- " + _POWiseMaterialReceiptRptVO.getStrSupplierName());
			//System.out.println(" ----------> _POWiseMaterialReceiptRptVO.getStrSupplierId() -------- " + _POWiseMaterialReceiptRptVO.getStrSupplierId());
			//System.out.println(" ----------> _POWiseMaterialReceiptRptVO.getStrlpItemId----------"+ _POWiseMaterialReceiptRptVO.getStrlpItemId());
			//System.out.println(" ----------> _POWiseMaterialReceiptRptVO.getStrlpItemName----------"+ _POWiseMaterialReceiptRptVO.getStrlpItemName());
			System.out.println(" ----------> _POWiseMaterialReceiptRptVO.getStrGroupId()----------"+ _POWiseMaterialReceiptRptVO.getStrGroupId());
			

			System.out.println("-----_POWiseMaterialReceiptRptVO.getStrActId()------"+_POWiseMaterialReceiptRptVO.getStrActId());
			
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", 	_POWiseMaterialReceiptRptVO.getStrActId(),1);  						
			daoObj.setProcInValue(nProcIndex, "hosp_code", 	_POWiseMaterialReceiptRptVO.getStrHospitalCode(),2);	     
			daoObj.setProcInValue(nProcIndex, "strid", 		_POWiseMaterialReceiptRptVO.getStrStoreId(),3);				 
			daoObj.setProcInValue(nProcIndex, "itemcategno",_POWiseMaterialReceiptRptVO.getStrItemCategoryId(),4); 
			daoObj.setProcInValue(nProcIndex, "InstituteId",_POWiseMaterialReceiptRptVO.getStrInstituteId(),5);	 
			daoObj.setProcInValue(nProcIndex, "start_date", _POWiseMaterialReceiptRptVO.getStrFinancialStartYear(),6);
			daoObj.setProcInValue(nProcIndex, "end_date", 	_POWiseMaterialReceiptRptVO.getStrFinancialEndYear(),7);  
			daoObj.setProcInValue(nProcIndex, "SupplierId", _POWiseMaterialReceiptRptVO.getStrSupplierId(),8);			 
			daoObj.setProcInValue(nProcIndex, "StrlpItemId",_POWiseMaterialReceiptRptVO.getStrlpItemId(),9);		 
			daoObj.setProcInValue(nProcIndex, "grpId",      _POWiseMaterialReceiptRptVO.getStrGroupId(),10);
			daoObj.setProcInValue(nProcIndex,  "pono",     _POWiseMaterialReceiptRptVO.getStrPoNo(),11);	

			daoObj.setProcOutValue(nProcIndex, "err",		1,12); 													 
			daoObj.setProcOutValue(nProcIndex, "resultset",	2,13);											 
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
//			System.out.println(" ----------> Size---------"+ ws.size());

			if(strErr.equals(""))
			{
				_POWiseMaterialReceiptRptVO.setWsItemCategoryCombo(ws);
			}
		}
		catch(Exception _err)
		{
			_err.printStackTrace();
			_POWiseMaterialReceiptRptVO.setStrMsgString("POWiseMaterialReceiptRptDAO.getViewDtl() --> "	+ _err.getMessage());
			_POWiseMaterialReceiptRptVO.setStrMsgType("1");
		}
		 finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
	}

	public static void itemCategory(POWiseMaterialReceiptRptVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_item_category_list(?,?,?,?,?,?)}"; //6
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Gifted Item Details","POWiseMaterialReceiptRptDAO");
			nProcIndex = daoObj.setProcedure(strProcName);	
			daoObj.setProcInValue(nProcIndex, "modeval", "3",1);
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
			e.printStackTrace();
			vo.setStrMsgString("POWiseMaterialReceiptRptDAO.itemCategory() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void getInstituteList(POWiseMaterialReceiptRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "POWiseMaterialReceiptRptDAO");
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
			e.printStackTrace();
			vo
					.setStrMsgString("POWiseMaterialReceiptRptDAO.getInstituteList() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void lpitemName(POWiseMaterialReceiptRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		
		System.out.println("--------vo.getStrItemCategoryNo()--------"+vo.getlpItemvalue());
		
		try {
			dao = new HisDAO("mms", "POWiseMaterialReceiptRptDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_item_name(?,?,?,?,?)}"; //4
			System.out.println("vo.getlpItemvalue()"+vo.getlpItemvalue());
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

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo
					.setStrMsgString("POWiseMaterialReceiptRptDAO.getlpItemName() --> "
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
	
	public static void getSupplierCombo(POWiseMaterialReceiptRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "POWiseMaterialReceiptRptDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_combo(?,?,?,?)}"; //4
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "2",1);  // Mode - 2 for Nagpur For Else Use Mode - 1
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
			e.printStackTrace();
			vo
					.setStrMsgString("POWiseMaterialReceiptRptDAO.getInstituteList() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getImageHeader(POWiseMaterialReceiptRptVO vo)
	{
		String strFuncName = "";
		String strLogoName = "";
		
		int nFuncIndex = 0;
		HisDAO dao = null;
		try 
		{
			dao = new HisDAO("DWH","ListofNARptDAO");
			
			strFuncName = "{? = call MMS_MST.logo_config_dtl(?,?)}";
			nFuncIndex = dao.setFunction(strFuncName);
			
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncOutValue(nFuncIndex, 1);
			
			dao.executeFunction(nFuncIndex);
			
			strLogoName = dao.getFuncString(nFuncIndex);
			vo.setStrLogoName(strLogoName);
			//System.out.println("======strLogoName======="+strLogoName);

		} catch (Exception e) {
			
			e.printStackTrace();
			vo.setStrMsgType("1");
			vo.setStrMsgString("POWiseMaterialReceiptRptDAO.getImageHeader() --> "+ e.getMessage());
			
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}
		}	
	}

}
