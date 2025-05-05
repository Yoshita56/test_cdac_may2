package mms.transactions.dao;

import hisglobal.exceptions.HisDataAccessException;
import hisglobal.exceptions.HisRecordNotFoundException;
import hisglobal.exceptions.TransactionException;
import hisglobal.persistence.DataAccessObject;
import hisglobal.persistence.HelperMethodsDAO;
import hisglobal.persistence.TransactionContext;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.Sequence;

import java.util.*;
import java.sql.*;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.DupSupplierReturnFromTransVO;

public class DupSupplierReturnFromTransDAO{




	public static void storeName(DupSupplierReturnFromTransVO vo)
	{
String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";//
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Replacement Condemnation Order","ReplacementCondemnationOrderTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "seatId", vo.getStrSeatId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
			daoObj.setProcOutValue(nProcIndex, "err",1,6); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,7);
			
			/* Start Adding Default value*/
			daoObj.setProcInValue(nProcIndex, "modeval","12",1);
			daoObj.setProcInValue(nProcIndex, "storeid","0",4);
			daoObj.setProcInValue(nProcIndex, "storetype_id","0",5);
		    /* End Adding Default value*/
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("ws.size()"+ws.size());
			if (strErr.equals("")) {
				vo.setWbsStoreNameCombo(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("DupSupplierReturnFromTransDAO.storeName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	public static void getCondemnationTypeCombo(DupSupplierReturnFromTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_condemnation_type_mst_cmb(?,?,?,?)}";//
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("mms","DupSupplierReturnFromTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "p_mode","1",1);
			daoObj.setProcInValue(nProcIndex, "p_gnum_hospital_code", vo.getStrHospitalCode(),2);
			daoObj.setProcOutValue(nProcIndex, "err",1,3); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,4);
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setWsCondemnationTypeDtl(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("DupSupplierReturnFromTransDAO.storeName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void getReturnOrCondemnDrugListHlp(DupSupplierReturnFromTransVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_Ret_And_Condemn_Register(?,?,?,?,?,?,?,?,?)}"; // 9 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try
		{
			daoObj=new HisDAO("mms","DupSupplierReturnFromTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			//daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			//System.out.println("hosp_code"+ vo.getStrHospitalCode());
			//System.out.println("storeId"+ vo.getStrStoreId());
			//System.out.println("itemCatg"+ vo.getStrItemCatNo());
			
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "storeId", vo.getStrStoreId(),3);
			daoObj.setProcInValue(nProcIndex, "itemCatg", vo.getStrItemCatNo(),4);
			daoObj.setProcInValue(nProcIndex, "orderNo", vo.getStrActionId(),5); // use as action id 
			daoObj.setProcInValue(nProcIndex, "brandId", vo.getStrSupplierId(),6); // use as a supplier id
			daoObj.setProcInValue(nProcIndex, "batchNo", "0",7);
			daoObj.setProcOutValue(nProcIndex, "err",1,8); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,9);
			daoObj.executeProcedureByPosition(nProcIndex);
						
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("ws.size"+ws.size());
			
			if (strErr.equals("")) {
				vo.setWsNOSQItemDetail(ws);				
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("DupSupplierReturnFromTransDAO.getNOSQDrugList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	//	created by shivani varshney
	public static void getSupplierDebitNumberListHlp(DupSupplierReturnFromTransVO vo)
	{
		
		//String query="select hstnum_debitnote_no from hstt_suppret_condemn_dtl where hstnum_debitnote_no is not null and sstnum_item_cat_no = ? and hstnum_store_id = ? and hstnum_supplier_id = ?";
		
		String strProcName = "{call pkg_mms_view.proc_dupsupplierdebitnote_list(?,?,?,?,?,?,?,?,?)}"; // 8 variables
			//proc_dupsupplierdebitnote_list
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try
		{
			daoObj=new HisDAO("mms","DupSupplierReturnFromTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "storeid", vo.getStrStoreId(),3);
			daoObj.setProcInValue(nProcIndex, "itemcatg", vo.getStrItemCatNo(),4);
			daoObj.setProcInValue(nProcIndex, "supplierid", vo.getStrSupplierId(),5);
			daoObj.setProcInValue(nProcIndex, "fromDate", vo.getStrFromDate(),6);
			daoObj.setProcInValue(nProcIndex, "toDate", vo.getStrToDate(),7);
			
			
			daoObj.setProcOutValue(nProcIndex, "err",1,8); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,9);
			daoObj.executeProcedureByPosition(nProcIndex);
						
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("ws.size"+ws.size());
			
			if (strErr.equals("")) {
				vo.setWsNOSQItemDetail(ws);
				
			} else {
				throw new Exception(strErr);
			}

		
				
		} 		catch (HisRecordNotFoundException e)
		{

			throw new HisRecordNotFoundException(e.getMessage());
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("" + e);
		}
	

	}
	
	
	
	public static void getSupplierDebitNumberDetailHlp(DupSupplierReturnFromTransVO vo)
	{
		
		//String query="select hstnum_debitnote_no from hstt_suppret_condemn_dtl where hstnum_debitnote_no is not null and sstnum_item_cat_no = ? and hstnum_store_id = ? and hstnum_supplier_id = ?";
		
		String strProcName = "{call pkg_mms_view.proc_dupsupplierdebitnote_list(?,?,?,?,?,?,?,?,?)}"; // 8 variables
			//proc_dupsupplierdebitnote_list
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try
		{
			
			

			daoObj=new HisDAO("mms","DupSupplierReturnFromTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "storeid", vo.getStrStoreId(),3);
			daoObj.setProcInValue(nProcIndex, "itemcatg", vo.getStrItemCatNo(),4);
			daoObj.setProcInValue(nProcIndex, "supplierid", vo.getStrSupplierId(),5);
			daoObj.setProcInValue(nProcIndex, "fromDate", vo.getStrFromDate(),6);
			daoObj.setProcInValue(nProcIndex, "toDate", vo.getStrToDate(),7);
			
			
			daoObj.setProcOutValue(nProcIndex, "err",1,8); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,9);
			daoObj.executeProcedureByPosition(nProcIndex);
						
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			
			System.out.println("getSupplierDebitNumberDetailHlp---ws.size"+ws.size());
			
			if (strErr.equals("")) {
				vo.setWsNOSQItemDetail(ws);
				
			} else {
				throw new Exception(strErr);
			}

		
				
		} 		catch (HisRecordNotFoundException e)
		{

			throw new HisRecordNotFoundException(e.getMessage());
		}
		catch (Exception e)
		{
			throw new HisDataAccessException("" + e);
		}
	

	}
	
	public synchronized static void insert(DupSupplierReturnFromTransVO vo) 
	{
		String strProcName = "{call pkg_mms_dml.dml_suppret_condemn_dtl(?,?,?,?,? ,?,?,?,?,?,  ?,?,?,?,? ,?,?,?,?,?)}";// 19 Variables
		
		HisDAO dao = null;
		int nProcIndex = 0;
		String strErr = "";	
		int     nFuncIndex = 0;
		String strFuncName = "",strRetuenNo="";
			
		try 
		{
			dao = new HisDAO("MMS",	"transactions.DupSupplierReturnFromTransDAO.insert()");
			
			strFuncName = "{? = call MMS_MST.generate_debitnote_no(?::numeric)}";
			            nFuncIndex = dao.setFunction(strFuncName);
			            
			dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strRetuenNo = dao.getFuncString(nFuncIndex);
			//System.out.println("return Noo ::::::::::::"+strRetuenNo);

			nProcIndex = dao.setProcedure(strProcName);
			//System.out.println("vo.getStrNosqDrugs().length()"+vo.getStrNosqDrugs().length);
			for(int i=0 ; i< vo.getStrNosqDrugs().length;i++)
			{
			String []strHiddenItemDtl = vo.getStrNosqDrugs()[i].split("\\^");

			/*
			 *	1 HSTNUM_ITEM_ID || ''^'' || 
			 *  2 HSTNUM_ITEMBRAND_ID || ''^'' || 
			 *  3 HSTSTR_BATCH_SL_NO || ''^'' || 
                4 HSTNUM_OLD_PO_NO || ''^'' || 
                5 HSTNUM_NEW_ORDER_NO || ''^'' || 
                6 HSTNUM_SUPPLIER_ID || ''^'' || 
                7 HSTNUM_DRUG_TYPE_FLAG||''^''||
                8 HSTNUM_NEW_ORDER_TYPE)||''^''||
                9 AVL_QTY
                     
			 */
			
			
//			//System.out.println( "modval"+ "1"); // 1
//			//System.out.println( "storeId"+vo.getStrStoreId());// 2						
//			//System.out.println( "itemId"+strHiddenItemDtl[0]);// 3
//			//System.out.println( "itemBrandId"+strHiddenItemDtl[1]);//4
//			//System.out.println( "batchNo"+strHiddenItemDtl[2]);//5
//			//System.out.println( "avlQty"+strHiddenItemDtl[8]);//6
//			//System.out.println( "oldPONo"+strHiddenItemDtl[3]);//7
//			//System.out.println( "newPONo"+strHiddenItemDtl[4]);//8
//			//System.out.println( "suppId"+strHiddenItemDtl[5]);//9
//			//System.out.println( "drugType"+strHiddenItemDtl[6]);//10
//			//System.out.println( "action"+vo.getStrActionId());//11
			
			if(strHiddenItemDtl[7].equals("1") && vo.getStrActionId().equals("2"))
			{
				
			}
			
			if(vo.getStrActionId().equals("1")) // Replacement
			{
				////System.out.println( "retCondDate"+vo.getStrReturnDate());//12
			}
			else		// Condemnation
			{
				////System.out.println(  "retCondDate"+vo.getStrCondemnationDate());//12
			}
//			//System.out.println( "condType"+vo.getStrCondemnationType());//13
//			//System.out.println( "remarks"+vo.getStrRemarks());//14
//			//System.out.println( "seatId"+vo.getStrSeatId());//15
//			//System.out.println( "hospCode"+vo.getStrHospitalCode());//16
//			//System.out.println( "returnTo"+vo.getStrReturnTo());//17
			
			
				
						dao.setProcInValue(nProcIndex, "modval", "1",1); // 1
						dao.setProcInValue(nProcIndex, "storeId",vo.getStrStoreId(),2);// 2						
						dao.setProcInValue(nProcIndex, "itemId",strHiddenItemDtl[0],3);// 3
						dao.setProcInValue(nProcIndex, "itemBrandId",strHiddenItemDtl[1],4);//4
						dao.setProcInValue(nProcIndex, "batchNo",strHiddenItemDtl[2],5);//5
						dao.setProcInValue(nProcIndex, "avlQty",strHiddenItemDtl[8],6);//6
						dao.setProcInValue(nProcIndex, "oldPONo",strHiddenItemDtl[3],7);//7
						dao.setProcInValue(nProcIndex, "newPONo",strHiddenItemDtl[4],8);//8
						dao.setProcInValue(nProcIndex, "suppId",strHiddenItemDtl[5],9);//9
						dao.setProcInValue(nProcIndex, "drugType",strHiddenItemDtl[6],10);//10
						dao.setProcInValue(nProcIndex, "action",vo.getStrActionId(),11);//11
						
						if(vo.getStrActionId().equals("1")) // Replacement
						{
							dao.setProcInValue(nProcIndex, "retCondDate",vo.getStrReturnDate(),12);//12
						}
						else		// Condemnation
						{
							dao.setProcInValue(nProcIndex, "retCondDate",vo.getStrCondemnationDate(),12);//12
						}
							
						
						
						dao.setProcInValue(nProcIndex, "condType",(vo.getStrCondemnationType()==null||vo.getStrCondemnationType().equals(""))?"0":vo.getStrCondemnationType(),13);//13
						
						if(vo.getStrActionId().equals("2"))
						{
							dao.setProcInValue(nProcIndex, "remarks",vo.getStrRemarks(),14);//14
						}
						else
						{
							dao.setProcInValue(nProcIndex, "remarks",vo.getStrRemarks(),14);//14
						}
						
						dao.setProcInValue(nProcIndex, "seatId",vo.getStrSeatId(),15);//15
						dao.setProcInValue(nProcIndex, "hospCode",vo.getStrHospitalCode(),16);//16
						dao.setProcInValue(nProcIndex, "returnTo",(vo.getStrReturnTo()==null||vo.getStrReturnTo().equals(""))?"0":vo.getStrReturnTo(),17);//17
						dao.setProcInValue(nProcIndex, "itemcatno",vo.getStrcatno(),18);//16
						dao.setProcInValue(nProcIndex, "strDebinoteNumber",strRetuenNo,19);//16
						dao.setProcOutValue(nProcIndex, "err", 1,20);// 18
						dao.executeProcedureByPosition(nProcIndex);						
			
			}	
			if (strErr != null && !strErr.equals(""))
			{				    
				throw new Exception(strErr);
			}				
			
		} catch (Exception _Err) {
			_Err.printStackTrace();
			vo.setStrMsgString("DupSupplierReturnFromTransDAO.insert() --> "+ _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}


	public static void getVoucherDtl(DupSupplierReturnFromTransVO vo) {
		String strProcName = "{call pkg_mms_view.proc_Ret_And_Condemn_Register(?,?,?,?,?,?,?,?,?)}"; // 9 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try
		{
			daoObj=new HisDAO("mms","DupSupplierReturnFromTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "storeId", vo.getStrStoreId(),3);
			daoObj.setProcInValue(nProcIndex, "itemCatg", vo.getStrcatno(),4);
			daoObj.setProcInValue(nProcIndex, "orderNo", vo.getStrOrderNo(),5);
			daoObj.setProcInValue(nProcIndex, "brandId", vo.getStrItemBrandId(),6);
			daoObj.setProcInValue(nProcIndex, "batchNo", vo.getStrBatchNo(),7);
			daoObj.setProcOutValue(nProcIndex, "err",1,8); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,9);
			daoObj.executeProcedureByPosition(nProcIndex);
						
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("ssdffffffffasfasd"+ws.size());
			if (strErr.equals("")) {
				vo.setWsNOSQItemDetail(ws);				
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("DupSupplierReturnFromTransDAO.getNOSQDrugList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void getDuplicateVoucherDtl(DupSupplierReturnFromTransVO vo) {
		String strProcName = "{call pkg_mms_view.proc_duplicateVoucherDtl(?,?,?,?,?,?,?)}"; // 7 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try
		{
			daoObj=new HisDAO("mms","DupSupplierReturnFromTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			//daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),1);
			daoObj.setProcInValue(nProcIndex, "storeid", vo.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "itemcatg", vo.getStrcatno(),3);
			//daoObj.setProcInValue(nProcIndex, "orderNo", vo.getStrOrderNo(),5);
			//daoObj.setProcInValue(nProcIndex, "brandId", vo.getStrItemBrandId(),6);
			//daoObj.setProcInValue(nProcIndex, "batchNo", vo.getStrBatchNo(),7);
			daoObj.setProcInValue(nProcIndex, "supplierid", vo.getStrSupplierId(),4);
			daoObj.setProcInValue(nProcIndex, "debitNumber", vo.getStrdebitNoteNumber(),5);
			//daoObj.setProcInValue(nProcIndex, "fromDate", vo.getStrFromDate(),6);
			//daoObj.setProcInValue(nProcIndex, "toDate", vo.getStrToDate(),7);
			
			
			daoObj.setProcOutValue(nProcIndex, "err",1,6); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,7);
			daoObj.executeProcedureByPosition(nProcIndex);
						
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("ssdffffffffasfasd"+ws.size());
			if (strErr.equals("")) {
				vo.setWsNOSQItemDetail(ws);				
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("DupSupplierReturnFromTransDAO.getNOSQDrugList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	
	public static void setItemCategCombo(DupSupplierReturnFromTransVO _IssueDetailRptVO)
	{
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		
		try 
		{
				dao = new HisDAO("mms", "IssueDetailRptDAO");
				strproc_name = "{call pkg_mms_rpt.Rptm_item_category_list(?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				//System.out.println("modeval"+_IssueDetailRptVO.getStrMode());
				dao.setProcInValue(nprocIndex, "modeval","2",1);
				dao.setProcInValue(nprocIndex, "hosp_code", _IssueDetailRptVO.getStrHospitalCode(),2);
				dao.setProcInValue(nprocIndex, "storeId",_IssueDetailRptVO.getStrStoreId(),3);							
				dao.setProcOutValue(nprocIndex, "err", 1,4);
				dao.setProcOutValue(nprocIndex, "resultset", 2,5); 
				
				dao.executeProcedureByPosition(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				//System.out.println("asdasdasd"+wb.size());
				if (strerr.equals("")) 
				{
					_IssueDetailRptVO.setItemCategWS(wb);
             	} 
				else 
				{
					throw new Exception(strerr);
				}
		} 
		catch (Exception e) 
		{
			_IssueDetailRptVO.setStrMsgString("IssueDetailRptDAO.setItemCategCombo() --> "+ e.getMessage());
			_IssueDetailRptVO.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
				wb=null;
			}
		}	
	}
	
	public static void getsuppliercmb(DupSupplierReturnFromTransVO _IssueDetailRptVO)
	{
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		
		try 
		{
				dao = new HisDAO("mms", "IssueDetailRptDAO");
				strproc_name = "{call pkg_mms_view.proc_supplier_list(?,?,?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				//System.out.println("modeval"+_IssueDetailRptVO.getStrMode());
				dao.setProcInValue(nprocIndex, "modeval","1",1);
				dao.setProcInValue(nprocIndex, "catcode",_IssueDetailRptVO.getStrItemCatNo(),2);
				dao.setProcInValue(nprocIndex, "branditem_id", "0",3);
				dao.setProcInValue(nprocIndex, "contracttype", "0",4);
				dao.setProcInValue(nprocIndex, "hosp_code", _IssueDetailRptVO.getStrHospitalCode(),5);
				dao.setProcOutValue(nprocIndex, "err", 1,6);
				dao.setProcOutValue(nprocIndex, "resultset", 2,7); 
				
				dao.executeProcedureByPosition(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				//System.out.println("asdasdasd"+wb.size());
				if (strerr.equals("")) 
				{
					_IssueDetailRptVO.setSupplierWS(wb);
             	} 
				else 
				{
					throw new Exception(strerr);
				}
		} 
		catch (Exception e) 
		{
			_IssueDetailRptVO.setStrMsgString("IssueDetailRptDAO.setItemCategCombo() --> "+ e.getMessage());
			_IssueDetailRptVO.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
				wb=null;
			}
		}	
	}
	
		
}
