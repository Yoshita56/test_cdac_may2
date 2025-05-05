package mms.transactions.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
import mms.transactions.vo.ItemTenderUploadDocVO;

public class ItemTenderUploadDocDAO {
	public static void getGenericItemList(ItemTenderUploadDocVO _LocalPurchaseMRN_VO)	{
		
		String strProcName = "{call PKG_MMS_VIEW.proc_genericitem_list(?,?,?,?,?, ?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try	{
			daoObj  = new HisDAO("MMS","ItemTenderUploadDocDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeVal", 		"1",1);  			
			daoObj.setProcInValue(nProcIndex, "store_id", 		"1",2);	    
			daoObj.setProcInValue(nProcIndex, "item_id", 		"1",3);			
			daoObj.setProcInValue(nProcIndex, "cat_no", 	    "1",4);      
			daoObj.setProcInValue(nProcIndex, "group_id", 		"1",5);  
			daoObj.setProcInValue(nProcIndex, "sub_group_id", 	"1",6); 
			daoObj.setProcInValue(nProcIndex, "hosp_code", 		"1",7);
			daoObj.setProcOutValue(nProcIndex, "err",			 1,8); 												
			daoObj.setProcOutValue(nProcIndex, "resultset",		 2,9);											    
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println(" ----------> Size---------"+ ws.size());

			if(strErr.equals(""))	{
				_LocalPurchaseMRN_VO.setWrsDrugWareHouseNameCmb(ws);
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

	public static void getITEMNameValues(ItemTenderUploadDocVO vo) {
		String strProcName = "{call PKG_MMS_VIEW.proc_Item_Name_list(?,?,?,?,?, ?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		System.out.println("---vo.getStrGenericItemId()----"+vo.getStrGenericItemId());
		try	{
			daoObj  = new HisDAO("MMS","ItemTenderUploadDocDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeVal", 		"1",1);  			
			daoObj.setProcInValue(nProcIndex, "Generic_id", 	vo.getStrGenericItemId(),2);	    
			daoObj.setProcInValue(nProcIndex, "item_id", 		"1",3);			
			daoObj.setProcInValue(nProcIndex, "cat_no", 	    "1",4);      
			daoObj.setProcInValue(nProcIndex, "group_id", 		"1",5);  
			daoObj.setProcInValue(nProcIndex, "sub_group_id", 	"1",6); 
			daoObj.setProcInValue(nProcIndex, "hosp_code", 		"1",7);
			daoObj.setProcOutValue(nProcIndex, "err",			 1,8); 												
			daoObj.setProcOutValue(nProcIndex, "resultset",		 2,9);											    
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println(" ----------> Size2---------"+ ws.size());

			if(strErr.equals(""))	{
				vo.setStrStockStatusWs(ws);
			}
		}
		catch(Exception _err)
		{
			vo.setStrMsgString("IndentWiseIssueRPTDAO.getViewDtl() --> "	+ _err.getMessage());
			vo.setStrMsgType("1");
		}
		 finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
	}
	
	public static void getFtpProperties(ItemTenderUploadDocVO vo)	{
		String err = "";
		String proc_name1 = "{call pkg_bmed_view.getFtpProperties(?,?,?)}";
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
	
		try {			
			dao = new HisDAO("MMS","ItemTenderUploadDocDAO");						
			procIndex1 = dao.setProcedure(proc_name1);				
			dao.setProcInValue(procIndex1, "p_mode","1", 1);	
			dao.setProcOutValue(procIndex1, "err",1, 2); 		
			dao.setProcOutValue(procIndex1, "resultset",2, 3); 
			dao.executeProcedureByPosition(procIndex1);
			err = dao.getString(procIndex1, "err");
			ws = dao.getWebRowSet(procIndex1, "resultset");
			if (err != null && !err.equals("")) {
				throw new Exception("Data Base Error:" + err);
			}
			
			//System.out.println("Inse"+ws.size());
			vo.setWrsFTPDtls(ws);
			
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("PACDeskTransDAO.getPatientVisitDtls() ----> "+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	public static void insert(ItemTenderUploadDocVO VO, HisDAO hisDAO_p) throws Exception	{
		 
		final String strproc_name = "{CALL pkg_mms_dml.proc_hstt_warranty_dtl(?,?,?,?,?, ?,?,?,?)}";
		final int nProcedureIndex;
		
		try {			
	            HisUtil.replaceNullValueWithEmptyString(VO);
				nProcedureIndex = hisDAO_p.setProcedure(strproc_name);
				
				
				System.out.println("-----p_HSTNUM_ITEM_ID------"+VO.getStrItemId());
				System.out.println("-----p_HSTNUM_ITEMBRAND_ID------"+VO.getStrItemBrandId());
				System.out.println("-----p_GNUM_HOSPITAL_CODE------"+VO.getStrHospitalCode());
				System.out.println("-----VO.getFTPPath()------"+VO.getFTPPath());
				System.out.println("-----VO.getStrUploadFileName3()------"+VO.getStrUploadFileName3());
				System.out.println("-----VO.getStrUploadFileName4()------"+VO.getStrUploadFileName4());
				
				hisDAO_p.setProcInValue(nProcedureIndex,"p_mode",						"1",1);
				hisDAO_p.setProcInValue(nProcedureIndex,"p_HSTNUM_ITEM_ID",				VO.getStrItemId(),2);
				hisDAO_p.setProcInValue(nProcedureIndex,"p_HSTNUM_ITEMBRAND_ID",		VO.getStrItemBrandId(),3);
				hisDAO_p.setProcInValue(nProcedureIndex,"p_GNUM_HOSPITAL_CODE",			"100",4);

	              if(VO.getStrUploadFileName3().equals(""))	{	
	            	hisDAO_p.setProcInValue(nProcedureIndex,"v_po_doc" ,	        "-",5);
	              }
	              else {
	            	  hisDAO_p.setProcInValue(nProcedureIndex,"v_po_doc" ,	        VO.getFTPPath()+"1",5);
	              }
	              if(VO.getStrUploadFileName3().equals("")) {	
	            	hisDAO_p.setProcInValue(nProcedureIndex,"v_tender_doc" ,	"-",6);
	              }
	              else {
	            	  hisDAO_p.setProcInValue(nProcedureIndex,"v_tender_doc" ,	VO.getFTPPath()+"2",6);
	              }              
	              
	              if(VO.getStrUploadFileName3().equals("")) {	
	            	hisDAO_p.setProcInValue(nProcedureIndex,"v_po_doc_name" ,	        "-",7);
	              }
	              else {
	            	  hisDAO_p.setProcInValue(nProcedureIndex,"v_po_doc_name" ,	        VO.getStrUploadFileName3(),7);
	              }
	              if(VO.getStrUploadFileName3().equals("")) {	
	            	hisDAO_p.setProcInValue(nProcedureIndex,"v_tender_doc_name" ,	"-",8);
	              }
	              else {
	            	  hisDAO_p.setProcInValue(nProcedureIndex,"v_tender_doc_name" ,	VO.getStrUploadFileName4(),8);
	              }              

				hisDAO_p.setProcOutValue(nProcedureIndex, "err", 1,9);
					
				hisDAO_p.execute(nProcedureIndex, 1);
			
	} 
	catch (Exception exception) {
		exception.printStackTrace();
	   throw new Exception("ItemTenderUploadDocVO.insert(ItemTenderUploadDocVO)-->"+ exception.getMessage());
	}	
  }
	
	public static void getwarranty_sl_no(ItemTenderUploadDocVO VO) throws Exception {
		final String ItemWarrantySLNO;

		final String strFuncName = "{?= call bmed_function.gen_itemwarrantysl_no1(?,?)}";
		HisDAO hisDAO_p=null;
		final int nFuncIndex;
		try {
			hisDAO_p=new HisDAO("getwarranty_sl_no","ItemTenderUploadDocDAO");
			nFuncIndex = hisDAO_p.setFunction(strFuncName);

			HisUtil.replaceNullValueWithEmptyString(VO);

			hisDAO_p.setFuncInValue(nFuncIndex, 2,"1"); 
			hisDAO_p.setFuncInValue(nFuncIndex, 3,VO.getStrHospitalCode()); 
			hisDAO_p.setFuncOutValue(nFuncIndex, 3);
			hisDAO_p.executeFuncForNumeric(nFuncIndex);
			ItemWarrantySLNO = hisDAO_p.getFuncNumeric(nFuncIndex);
	
			VO.setItemWarrantySLNO(ItemWarrantySLNO);

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new Exception(
					"ComplaintAttendDtlDAO.setNewAttendId(ComplaintAttendDtlVO,HisDAO)-->"
							+ exception.getMessage());
		}
		

	}
	
}

	