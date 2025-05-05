package mms.transactions.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.transactions.vo.StockBarCodeTransVO;

public class StockBarCodeTransDAO {
	
	public static void storeName(StockBarCodeTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}"; //4+3=7
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try{
			daoObj=new HisDAO("Gifted Item Details","StockBarCodeTransDAO");
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
			vo.setStrMsgString("StockBarCodeTransDAO.storeName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	public static void getViewDtl(StockBarCodeTransVO vo)
	{
		
		String strproc_name = "";  // 9
		int nprocIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO dao=null;
		
		try
		{
			 			    
			dao = new HisDAO("mms", "StockBarCodeTransDAO");			
			strproc_name = "{call PKG_MMS_VIEW2.proc_CopiesWise_BarCode(?,?,?,?,?, ?,?,?,?,?  , ?,?)}"; //11
			nprocIndex = dao.setProcedure(strproc_name);			
			if(vo.getStrBatchNo().equals("0")) {
				dao.setProcInValue(nprocIndex, "modeval", 		"3",1);
			}else {
				dao.setProcInValue(nprocIndex, "modeval", 		"2",1);
			}
			dao.setProcInValue(nprocIndex, "store_id", 		vo.getStrStoreId(),2);
			dao.setProcInValue(nprocIndex, "item_id", 		(vo.getStrItemId()==null||vo.getStrItemId().equals(""))?"0":vo.getStrItemId(),3);
			dao.setProcInValue(nprocIndex, "cat_no", 		(vo.getStrItemCategoryId()==null||vo.getStrItemCategoryId().equals(""))?"10":vo.getStrItemCategoryId(),4);
			dao.setProcInValue(nprocIndex, "group_id", 		(vo.getStrGroupId()==null||vo.getStrGroupId().equals(""))?"0":vo.getStrGroupId(),5);  
			dao.setProcInValue(nprocIndex, "sub_group_id", 	vo.getStrSeatId(),6);      // Pass Seat Id Here
			dao.setProcInValue(nprocIndex, "hosp_code", 	vo.getStrHospitalCode(),7);	
			dao.setProcInValue(nprocIndex, "batch_no ", 	(vo.getStrBatchNo()==null||vo.getStrBatchNo().equals(""))?"0":vo.getStrBatchNo(),8);
			dao.setProcInValue(nprocIndex, "item_brand_id", (vo.getStrItemBrandId()==null||vo.getStrItemBrandId().equals(""))?"0":vo.getStrItemBrandId(),9);
			dao.setProcInValue(nprocIndex, "batchAllot",	(vo.getStrSizeId()==null||vo.getStrSizeId().equals(""))?"0":vo.getStrSizeId() ,10);
			dao.setProcOutValue(nprocIndex, "err", 			1,11);
			dao.setProcOutValue(nprocIndex, "resultset", 	2,12);
			dao.executeProcedureByPosition(nprocIndex);
			strErr = dao.getString(nprocIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = dao.getWebRowSet(nprocIndex, "resultset");
			//System.out.println(" ----------> Size---------"+ ws.size());

			if(strErr.equals(""))
			{
				vo.setWsStockDtl(ws);
			}
		}
		catch(Exception _err)
		{
			vo.setStrMsgString("StockBarCodeTransDAO.getViewDtl() --> "	+ _err.getMessage());
			vo.setStrMsgType("1");
		}
		 finally {
				if (dao != null) {
					dao.free();
					dao = null;
				}
			}
	}
	
	public static void lpitemName(StockBarCodeTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		
		//System.out.println("--------vo.getStrItemCategoryNo()--------"+vo.getlpItemvalue());
		
		try 
		{
					    
			dao = new HisDAO("mms", "StockBarCodeTransDAO");			
			strproc_name = "{call PKG_MMS_VIEW2.proc_storewise_brand_list(?,?,?,?,?, ?,?,?,?,?  , ?)}"; //11
			nprocIndex = dao.setProcedure(strproc_name);			

			dao.setProcInValue(nprocIndex, "modeval", 		"1",1);
			dao.setProcInValue(nprocIndex, "store_id", 		vo.getStrStoreId(),2);
			dao.setProcInValue(nprocIndex, "item_id", 		(vo.getStrItemId()==null||vo.getStrItemId().equals(""))?"0":vo.getStrItemId(),3);
			dao.setProcInValue(nprocIndex, "cat_no", 		(vo.getStrItemCategoryId()==null||vo.getStrItemCategoryId().equals(""))?"10":vo.getStrItemCategoryId(),4);
			dao.setProcInValue(nprocIndex, "group_id", 		(vo.getStrGroupId()==null||vo.getStrGroupId().equals(""))?"0":vo.getStrGroupId(),5);  
			dao.setProcInValue(nprocIndex, "sub_group_id", 	vo.getStrSeatId(),6);      // Pass Seat Id Here
			dao.setProcInValue(nprocIndex, "hosp_code", 	vo.getStrHospitalCode(),7);	
			dao.setProcInValue(nprocIndex, "batch_no ", 	(vo.getStrBatchNo()==null||vo.getStrBatchNo().equals(""))?"0":vo.getStrBatchNo(),8);
			dao.setProcInValue(nprocIndex, "item_brand_id", (vo.getStrItemBrandId()==null||vo.getStrItemBrandId().equals(""))?"0":vo.getStrItemBrandId(),9);
//			dao.setProcInValue(nprocIndex, "batchAllot",	"12" ,10);
			dao.setProcOutValue(nprocIndex, "err", 			1,10);
			dao.setProcOutValue(nprocIndex, "resultset", 	2,11);
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
			vo.setStrMsgString("StockBarCodeTransDAO.getlpItemName() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getItemBatch(StockBarCodeTransVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try 
		{
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			
			System.out.println("----- DrugInventoryTransDAO .PKG_MMS_VIEW.proc_ExistingBatch_list [ Mode - 5]-----");
			
			strproc_name = "{call PKG_MMS_VIEW.proc_ExistingBatch_list(?,?,?,?,?,?,?)}";
						
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "p_modeval", 			"5",1);
			dao.setProcInValue(nprocIndex, "p_HSTNUM_STORE_ID", 	vo.getStrStoreId(),2);
			dao.setProcInValue(nprocIndex, "p_HSTNUM_ITEM_ID", 		(vo.getStrItemId()==null||vo.getStrItemId().equals(""))?"0":vo.getStrItemId(),3);
			dao.setProcInValue(nprocIndex, "p_HSTNUM_ITEMBRAND_ID",	vo.getStrItemBrandId(),4);
			dao.setProcInValue(nprocIndex, "p_GNUM_HOSPITAL_CODE", 	vo.getStrHospitalCode(),5);
			
			dao.setProcOutValue(nprocIndex, "err", 1,6);
			dao.setProcOutValue(nprocIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) 
			{
				////System.out.println("DAO -->" + wb.size());
				vo.setStrExistingBatchComboWS(wb);

			} 
			else 
			{
				throw new Exception(strerr);
			}
		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("DrugInventoryTransDAO.getExistingBatchList() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
			}
		}
	}

	public static void itemCategory(StockBarCodeTransVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_item_category_list(?,?,?,?,?,?)}"; //6
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try
		{
			daoObj=new HisDAO("Gifted Item Details","StockBarCodeTransDAO");
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
			vo.setStrMsgString("StockBarCodeTransDAO.itemCategory() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void getInstituteList(StockBarCodeTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "StockBarCodeTransDAO");
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
					.setStrMsgString("StockBarCodeTransDAO.getInstituteList() --> "
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
	
	public static void getSupplierCombo(StockBarCodeTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "StockBarCodeTransDAO");
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
			vo.setStrMsgString("StockBarCodeTransDAO.getInstituteList() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getImageHeader(StockBarCodeTransVO vo)
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
	
	public synchronized static void insert(StockBarCodeTransVO vo) 
	{
				
		HisDAO dao = null;			
		
		int                        nProcIndex2  = 0;
		String                     strProcName2 = "";	
		String 					   strerr = "";
				
		try 
		{
    		    dao = new HisDAO("Inventroy",	"transactions.StockBarCodeTransDAO.insert()");

			    System.out.println("-----------StockBarCodeTransDAO  . insert-----------");
			
			    //hstnum_store_id||''^''||hstnum_item_id||''^''||hstnum_itembrand_id||''^''||hststr_batch_no 
			    
			    strProcName2 = "{call pkg_mms_dml.dml_barcode_update(?,?,?,?,?  ,?,?,?,?)}"; // 9 
			    
				for(int i=0;i <vo.getStrVerifyCountedQty().length;i++)
				{
					    System.out.println("hstnum_store_id ^  hstnum_item_id ^  hstnum_itembrand_id ^  hststr_batch_no ");
					  
					    System.out.println("P_Key   --"+i+"--"+vo.getStrPKey()[i]);
					    System.out.println("Bar_Code--"+i+"--"+vo.getStrVerifyCountedQty()[i]);					    
					    System.out.println("store_id--"+i+"--"+vo.getStrPKey()[i].split("\\^")[0]);
					    System.out.println("item_id--"+i+"--"+vo.getStrPKey()[i].split("\\^")[1]);
					    System.out.println("item_brand_id--"+i+"--"+vo.getStrPKey()[i].split("\\^")[2]);
					    System.out.println("batchsl_no--"+i+"--"+vo.getStrPKey()[i].split("\\^")[3]);					   					    
					   
						nProcIndex2  = dao.setProcedure(strProcName2);					  
					    dao.setProcInValue(nProcIndex2, "modval", 			 "1",1);					    		    
						dao.setProcInValue(nProcIndex2, "store_id",   	     vo.getStrPKey()[i].split("\\^")[0],2);
						dao.setProcInValue(nProcIndex2, "item_id", 		     vo.getStrPKey()[i].split("\\^")[1],3);
						dao.setProcInValue(nProcIndex2, "hospital_code",     vo.getStrHospitalCode(),4);
						dao.setProcInValue(nProcIndex2, "item_brand_id", 	 vo.getStrPKey()[i].split("\\^")[2],5);
						dao.setProcInValue(nProcIndex2, "batchsl_no",  		 vo.getStrPKey()[i].split("\\^")[3],6);	
						dao.setProcInValue(nProcIndex2, "bar_code",          vo.getStrVerifyCountedQty()[i],7);
						dao.setProcInValue(nProcIndex2, "seat_id",           vo.getStrSeatId(),8);
						dao.setProcOutValue(nProcIndex2, "err",              1,9); 
						dao.execute(nProcIndex2,1);						
																					  
				}
				
			    dao.fire();
			
			
		} catch (Exception _Err) {
			_Err.printStackTrace();
			vo.setStrMsgString("StockBarCodeTransDAO.insert() --> "+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}	



}
