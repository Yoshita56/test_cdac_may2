/**
 * 
 */
package mms.transactions.dao;


import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.transactions.vo.AckSuppReceiptVO;

/**
 * @author user
 *
 */
public class AckSuppReceiptDAO {
	
	
	public static void save(AckSuppReceiptVO vo)
	{
		 
		HisDAO daoObj=null;		
		String lpno = "0";
		String strBrandId = "0";
		String strCatgId  = "0";
		String strProcName1 ="";
		String strProcName2 ="";
		int nProcIndex = 0 , nProcIndex1 = 0, nProcIndex2 = 0;
		String strErr = "";
		int i;
		try
		{		

			System.out.println("---------AckSuppReceiptDAO.SAVE------START-------");
			daoObj=new HisDAO("Local Purchase","AckSuppReceiptDAO"); 
			
			strProcName2 = "{call Pkg_Mms_dml.dml_supplier_receipt_unique_dtl(?,?,?,?,?   ,?,?,?,?)}";  //9 variables
		    nProcIndex2 = daoObj.setProcedure(strProcName2);						
			
			daoObj.setProcInValue(nProcIndex2, "modval",                "1",1);	
			daoObj.setProcInValue(nProcIndex2, "p_hstnum_supp_lp_no",	vo.getpKey()[0].split("\\^")[0],2);	
			daoObj.setProcInValue(nProcIndex2, "p_hstnum_store_id",		vo.getStrStoreId(),3);			
			daoObj.setProcInValue(nProcIndex2, "p_hstnum_supplier_id",	vo.getStrSupplierId(),4);
			daoObj.setProcInValue(nProcIndex2, "p_sstnum_item_cat_no", 	vo.getpKey()[0].split("\\^")[1].substring(0, 2),5);			
			daoObj.setProcInValue(nProcIndex2, "p_gnum_hospital_code", 	vo.getStrHospitalCode(),6);
			daoObj.setProcInValue(nProcIndex2, "p_gnum_seatid",         vo.getStrSeatId(),7);                               // Used To Pass Seat Id
			daoObj.setProcInValue(nProcIndex2, "p_hstnum_diff_in_amt", 	vo.getStrDifferenceAmtSign()+"$"+((vo.getStrDifferenceAmt() == null || vo.getStrDifferenceAmt().equals(""))?"0":vo.getStrDifferenceAmt()),8);    // PASS DIFF IN AMOUNT
			daoObj.setProcOutValue(nProcIndex2,"err",1,9); 
			daoObj.execute(nProcIndex2,1);
			
			for(i=0;i<vo.getStrTotalQty().length;i++)
			{
					System.out.println("--------------------"+i+"-------------------------");
					System.out.println("Store_id--------------------"+vo.getStrStoreId());
					//System.out.println("Catg_No---------------------"+vo.getStrItemCategoryNo());
					System.out.println("Invoice No------------------"+vo.getStrInvoiceNo());
					System.out.println("Invoice_Date----------------"+vo.getStrInvoiceDate());
					System.out.println("LP_NO ^ BRAND_ID------------"+vo.getpKey()[i]);
					System.out.println("vo.getStrbatchno()----------"+vo.getStrbatchno()[i]);
					System.out.println("vo.getStrOldBatchNo()----------"+vo.getStrOldBatchNo()[i]);
					System.out.println("vo.getStrTotalQty()---------"+vo.getStrTotalQty()[i]);				
					System.out.println("vo.getStrExpDate()----------"+vo.getStrExpDate()[i]);
					System.out.println("vo.getStrMfgDate()----------"+vo.getStrMfgDate()[i]);
					System.out.println("vo.getStrPurRate()----------"+vo.getStrPurRate()[i]);					
					System.out.println("vo.getStrAdmchg()-----------"+vo.getStrAdmchg()[i]);
					System.out.println("vo.getStrPurWidTax()--------"+vo.getStrPurWidTax()[i]);
					System.out.println("vo.getStrGST()--------------"+vo.getStrGST()[i]);
					System.out.println("vo.getStrSupplierId()-------"+vo.getStrSupplierId());
					System.out.println("vo.getStrDCNo()-------------"+vo.getStrDCNo());
					System.out.println("vo.getStrSeatId()--------"+vo.getStrSeatId());		
					System.out.println("vo.getStrDifferenceAmt()--------"+vo.getStrDifferenceAmt());	
					System.out.println("vo.getStrDifferenceAmtSign()--------> "+vo.getStrDifferenceAmtSign());	
					System.out.println("vo.getStrPurWidTax()--------"+vo.getStrPurWidTax()[i]);	
					System.out.println("MRP--------------------"+vo.getStrMRP()[i]);
					System.out.println("---------------------------------------------");
			            
					 /*
		                    New Logic Added on Date 01-Aug-2024
		                    a) If Sign '+'  Than Difference Amount Enter Into  hstnum_net_advance
		                    a) If Sign '-'  Than Difference Amount Enter Into  hstnum_net_penelty
		
		             */
					
				    lpno       = vo.getpKey()[i].split("\\^")[0];
				
				    strBrandId = vo.getpKey()[i].split("\\^")[1];
				    
				    strCatgId  = strBrandId.substring(0, 2);
				    
				    //System.out.println("-- Catg Code -" + i + "-" + strCatgId);
				    
				    vo.setStrLPNo(lpno);
				    vo.setStrLpoNo(lpno);
				    
				    //if(i==0)
				    //{	
				        System.out.println("---------Pkg_Mms_dml.dml_hstt_lp_dtl-[ Mode - 4 ]--[ Update  hstt_Supplier_Receipt_dtl ]--------");
					    
				        System.out.println("---formBean.getStrMRP()-"+i+"--"+vo.getStrMRP()[i]);
				        System.out.println("---formBean.BatchNo()-"+i+"--"+vo.getStrbatchno()[i]);
				        
				        String strProcName = "{call Pkg_Mms_dml.dml_hstt_lp_dtl(?,?,?,?,?   ,?,?,?,?,?   ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,? ,?,?,?,?)}";  //34 variables
					    nProcIndex = daoObj.setProcedure(strProcName);						
						
						daoObj.setProcInValue(nProcIndex, "modval",        "4",1);					
						daoObj.setProcInValue(nProcIndex, "store_id",		vo.getStrStoreId(),2);
						daoObj.setProcInValue(nProcIndex, "item_id",		(vo.getStrMRP()[i]==null||vo.getStrMRP()[i].equals("")||vo.getStrMRP()[i].equals("null"))?"0":vo.getStrMRP()[i],3);
						daoObj.setProcInValue(nProcIndex, "itembrand_id",	strBrandId,4);
						daoObj.setProcInValue(nProcIndex, "batchsl_no",		vo.getStrbatchno()[i]+"^"+vo.getStrOldBatchNo()[i] ,5);
						daoObj.setProcInValue(nProcIndex, "hosp_code", 		vo.getStrHospitalCode(),6);
						daoObj.setProcInValue(nProcIndex, "item_cat_code", 	strCatgId,7);
						daoObj.setProcInValue(nProcIndex, "group_id",		"0",8);
						//daoObj.setProcInValue(nProcIndex, "subgroup_id",	"0",9);
						daoObj.setProcInValue(nProcIndex, "subgroup_id", 	vo.getStrDifferenceAmtSign()+"$"+((vo.getStrDifferenceAmt() == null || vo.getStrDifferenceAmt().equals(""))?"0":vo.getStrDifferenceAmt()),9);    // PASS DIFF IN AMOUNT
						daoObj.setProcInValue(nProcIndex, "supplier_id",	vo.getStrSupplierId(),10);
						daoObj.setProcInValue(nProcIndex, "qty",			vo.getStrTotalQty()[i],11);
						daoObj.setProcInValue(nProcIndex, "qty_unitid",     "0",	12);
						daoObj.setProcInValue(nProcIndex, "expdate",		vo.getStrExpDate()[i],13);
						daoObj.setProcInValue(nProcIndex, "mfgdate",		vo.getStrMfgDate()[i],14);
						daoObj.setProcInValue(nProcIndex, "rate", 			vo.getStrPurRate()[i],15);
						daoObj.setProcInValue(nProcIndex, "rate_unitid",	"6301",16);
						daoObj.setProcInValue(nProcIndex, "saleprice",		vo.getStrPurWidTax()[i],17);
						daoObj.setProcInValue(nProcIndex, "saleprice_unitid","6301",18);
						daoObj.setProcInValue(nProcIndex, "seat_id", 		vo.getStrSeatId(),19);
						daoObj.setProcInValue(nProcIndex, "invno", 			vo.getStrInvoiceNo(),20);
						daoObj.setProcInValue(nProcIndex, "invdate", 		vo.getStrInvoiceDate(),21); 
						daoObj.setProcInValue(nProcIndex, "remarks",		(vo.getStrRemarks() == null || vo.getStrRemarks().equals(""))?"-":vo.getStrRemarks(),22); 
						daoObj.setProcInValue(nProcIndex, "dcno",			vo.getStrDCNo().split("\\#")[0],23); 
						daoObj.setProcInValue(nProcIndex, "challan_date",	vo.getStrInvoiceDate(),24); 
						daoObj.setProcInValue(nProcIndex, "adm_chg",		(vo.getStrAdmchg()[i]==null||vo.getStrAdmchg()[i].equals(""))?"0":vo.getStrAdmchg()[i],25); 
						daoObj.setProcInValue(nProcIndex, "tax",			vo.getStrGST()[i],26); 
						
						daoObj.setProcInValue(nProcIndex, "packsize",		"0",27); 
						daoObj.setProcInValue(nProcIndex, "packno",			"0",28); 
						daoObj.setProcInValue(nProcIndex, "transno",		lpno,29);
						daoObj.setProcInValue(nProcIndex, "pono",			lpno,30); 
						daoObj.setProcInValue(nProcIndex, "strucchk",		vo.getStrDCNo().split("\\#")[1],31);                 // Used To Pass Entry Date
						
						daoObj.setProcInValue(nProcIndex, "strInstituteId", vo.getStrSeatId(),32);                               // Used To Pass Seat Id
						daoObj.setProcInValue(nProcIndex, "mrp", vo.getStrMRP() != null ? vo.getStrMRP()[i] : "0",33);
						daoObj.setProcOutValue(nProcIndex, "err",1,34); 
						daoObj.execute(nProcIndex,1);
				   // }
					
					
			
					if(strCatgId.equals("10"))
					{
						 System.out.println("---------PKG_MMS_DML.dml_stock_update_new_lp-[ Mode - 1 ]--[ Update  hstt_Supplier_Receipt_dtl ]--------");
						 
						strProcName1 = "{call PKG_MMS_DML.dml_stock_update_new_lp(?,?,?,?,?,  ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,? ,?,?,?,?,?, ?,?,?,?,? ,?)}"; // 24+1 Variable, 1 var added to save purchase rate
	
						nProcIndex1 = daoObj.setProcedure(strProcName1);
						
						daoObj.setProcInValue(nProcIndex1, "modval",			"1",1); // 1
						daoObj.setProcInValue(nProcIndex1, "strId",				vo.getStrStoreId(),2); // 1
						daoObj.setProcInValue(nProcIndex1, "brandId",			strBrandId,3);// 2
						daoObj.setProcInValue(nProcIndex1, "v_batchNo",			vo.getStrbatchno()[i],4); // 3
						daoObj.setProcInValue(nProcIndex1, "expDate",			vo.getStrExpDate()[i],5); // 4
						daoObj.setProcInValue(nProcIndex1, "mfgDate",			vo.getStrMfgDate()[i],6); // 5
						daoObj.setProcInValue(nProcIndex1, "manufId",			vo.getStrSupplierId(),7); // 6
						daoObj.setProcInValue(nProcIndex1, "activeQty",			vo.getStrTotalQty()[i],8); // 7
						daoObj.setProcInValue(nProcIndex1, "inactiveQty",		"0",9); // 8
						daoObj.setProcInValue(nProcIndex1, "quartineQty",		"0",10); // 9
						daoObj.setProcInValue(nProcIndex1, "seatId",			vo.getStrSeatId(),11); // 10
//						daoObj.setProcInValue(nProcIndex1, "rate",				vo.getStrCosttoPat()[i],12); // 12
						daoObj.setProcInValue(nProcIndex1, "rate",				vo.getStrPurWidTax()[i],12);
						daoObj.setProcInValue(nProcIndex1, "rateUnitId",		"6301",13); // 13
						daoObj.setProcInValue(nProcIndex1, "tenderNo",			"0",14); // 15
						daoObj.setProcInValue(nProcIndex1, "poNo",				lpno,15); // 16
						daoObj.setProcInValue(nProcIndex1, "hosp_code",			vo.getStrHospitalCode(),16); // 17
						daoObj.setProcInValue(nProcIndex1, "supplierId",		vo.getStrSupplierId(),17); // 18    // Y
						daoObj.setProcInValue(nProcIndex1, "prgid",			  	"0",18); // 17
						daoObj.setProcInValue(nProcIndex1, "existingbatch",	  	"0",19); // 18
						daoObj.setProcInValue(nProcIndex1, "existstockstatus",	"10",20); // 19	
						daoObj.setProcInValue(nProcIndex1, "dcno", 			 	vo.getStrDCNo().split("\\#")[0],21);              // Y
						daoObj.setProcInValue(nProcIndex1, "invoiceno", 	 	vo.getStrInvoiceNo(),22);         // Y
						daoObj.setProcInValue(nProcIndex1, "invoicedate", 	 	vo.getStrInvoiceDate(),23);       // Y 
						daoObj.setProcInValue(nProcIndex1, "purrate",		 	vo.getStrPurRate()[i],24); // 23
						daoObj.setProcInValue(nProcIndex1, "handlingcharges",	vo.getStrAdmchg()[i],25); // 11
						daoObj.setProcInValue(nProcIndex1, "purtax",		 	vo.getStrGST()[i],26); // 11
						daoObj.setProcInValue(nProcIndex1, "flag",           	"0",27); // 11  added to chk whether data inserted offline ie from inventory process.
						
						daoObj.setProcInValue(nProcIndex1, "packsize",       	"0",28);
						daoObj.setProcInValue(nProcIndex1, "packno",         	"0",29);
						
						daoObj.setProcInValue(nProcIndex1, "invFlag",        	vo.getStrMRP()[i],30);
						daoObj.setProcOutValue(nProcIndex1, "err",            	1 ,31); // 18
						daoObj.execute(nProcIndex1, 1);
		         	}
					else
					{
						//System.out.println("vo.getStrItemCategoryNo()"+vo.getStrItemCategoryNo());
						strProcName1 = "{call PKG_MMS_DML.dml_item_stock_update_new_lp(?,?,?,?,?,  ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,? ,?,?,?,?,? ,?,?,?,?)}";
						nProcIndex1 = daoObj.setProcedure(strProcName1);
						daoObj.setProcInValue(nProcIndex1, "modval",		"1",1); // 1
						daoObj.setProcInValue(nProcIndex1, "strId",			vo.getStrStoreId(),2); // 1
						daoObj.setProcInValue(nProcIndex1, "brandId",		strBrandId,3);// 2
						daoObj.setProcInValue(nProcIndex1, "v_batchNo",		vo.getStrbatchno()[i],4); // 3
						daoObj.setProcInValue(nProcIndex1, "expDate",		vo.getStrExpDate()[i],5); // 4
						daoObj.setProcInValue(nProcIndex1, "mfgDate",		vo.getStrMfgDate()[i],6); // 5
						daoObj.setProcInValue(nProcIndex1, "manufId",		vo.getStrSupplierId(),7); // 6
						daoObj.setProcInValue(nProcIndex1, "activeQty",		vo.getStrTotalQty()[i],8); // 7
						daoObj.setProcInValue(nProcIndex1, "inactiveQty",	"0",9); // 8
						daoObj.setProcInValue(nProcIndex1, "quartineQty",	"0",10); // 9
						daoObj.setProcInValue(nProcIndex1, "seatId",		vo.getStrSeatId(),11); // 10
						daoObj.setProcInValue(nProcIndex1, "rate",			vo.getStrPurWidTax()[i],12); // 11
						daoObj.setProcInValue(nProcIndex1, "rateUnitId",	"6301",13); // 12
						daoObj.setProcInValue(nProcIndex1, "tenderNo",		"0",14); // 13
						daoObj.setProcInValue(nProcIndex1, "poNo",			lpno,15); // 14
						daoObj.setProcInValue(nProcIndex1, "hosp_code",		vo.getStrHospitalCode(),16); // 15
						daoObj.setProcInValue(nProcIndex1, "supplierId",	vo.getStrSupplierId(),17); // 16
						daoObj.setProcInValue(nProcIndex1, "prgid",			"0",18); // 17
						daoObj.setProcInValue(nProcIndex1, "existingbatch",	"0",19); // 18
						daoObj.setProcInValue(nProcIndex1, "existstockstatus", "10",20); // 19
						daoObj.setProcInValue(nProcIndex1, "item_cat_no",	strCatgId ,21); // 20
						daoObj.setProcInValue(nProcIndex1, "dcno", 			vo.getStrDCNo().split("\\#")[0],22);
						daoObj.setProcInValue(nProcIndex1, "invoiceno", 	vo.getStrInvoiceNo(),23);
						daoObj.setProcInValue(nProcIndex1, "invoicedate", 	vo.getStrInvoiceDate(),24);
						daoObj.setProcInValue(nProcIndex1, "purrate",		vo.getStrPurRate()[i],25); // 11
						daoObj.setProcInValue(nProcIndex1, "handlingcharges",vo.getStrAdmchg()[i],26); // 11
						daoObj.setProcInValue(nProcIndex1, "tax",			vo.getStrGST()[i],27); // 11
						daoObj.setProcInValue(nProcIndex1, "invFlag",		vo.getStrMRP()[i],28);
						daoObj.setProcOutValue(nProcIndex1, "err", 1,29);
						daoObj.execute(nProcIndex1, 1);
					}
					
					
					
			
			}
		
			daoObj.fire();
			
			
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			if (strErr.equals("")) 
			{
				vo.setStrMsgType("0");
			}
			else 
			{
				
				throw new Exception(strErr);
			}
			
			System.out.println("---------AckSuppReceiptDAO.SAVE------END-------");
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("SupplierReceiptDAO.stockDetails() --> "
					+ e.getMessage());
			
			vo.setStrMsgType("1");
		}
		
		
	}
	
	public static void REJECT(AckSuppReceiptVO vo)
	{
		 
		HisDAO daoObj=null;		
		String lpno = "0";
		String strBrandId = "0";		
		int nProcIndex = 0;
		String strErr = "";
		
		try
		{		
			
					System.out.println("vo.getStrRemarks()--------------->"+vo.getStrRemarks());		
					System.out.println("vo.getStrLpoNo()----------------->"+vo.getStrLpoNo());
					System.out.println("vo.getStrStoreId----------------->"+vo.getStrStoreId());
			

			                    daoObj     = new HisDAO("Local Purchase","AckSuppReceiptDAO"); 
			
																 
					    String strProcName = "{call Pkg_Mms_dml.dml_hstt_lp_dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?)}";  //34 variables
					    
					    nProcIndex = daoObj.setProcedure(strProcName);						
						
						daoObj.setProcInValue(nProcIndex, "modval",        "5",1);					
						daoObj.setProcInValue(nProcIndex, "store_id",		vo.getStrStoreId(),2);
						daoObj.setProcInValue(nProcIndex, "item_id",		"0",3);
						daoObj.setProcInValue(nProcIndex, "itembrand_id",	strBrandId,4);
						daoObj.setProcInValue(nProcIndex, "batchsl_no",		"0",5);
						daoObj.setProcInValue(nProcIndex, "hosp_code", 		vo.getStrHospitalCode(),6);
						daoObj.setProcInValue(nProcIndex, "item_cat_code", 	"0",7);
						daoObj.setProcInValue(nProcIndex, "group_id",		"0",8);
						daoObj.setProcInValue(nProcIndex, "subgroup_id",	"0",9);
						daoObj.setProcInValue(nProcIndex, "supplier_id",	"0",10);
						daoObj.setProcInValue(nProcIndex, "qty",			"0",11);
						daoObj.setProcInValue(nProcIndex, "qty_unitid",     "0",12);
						daoObj.setProcInValue(nProcIndex, "expdate",		"0",13);
						daoObj.setProcInValue(nProcIndex, "mfgdate",		"0",14);
						daoObj.setProcInValue(nProcIndex, "rate", 			"0",15);
						daoObj.setProcInValue(nProcIndex, "rate_unitid",	"6301",16);
						daoObj.setProcInValue(nProcIndex, "saleprice",		"0",17);
						daoObj.setProcInValue(nProcIndex, "saleprice_unitid","6301",18);
						daoObj.setProcInValue(nProcIndex, "seat_id", 		vo.getStrSeatId(),19);
						daoObj.setProcInValue(nProcIndex, "invno", 			"0",20);
						daoObj.setProcInValue(nProcIndex, "invdate", 		"0",21); 
						daoObj.setProcInValue(nProcIndex, "remarks",		(vo.getStrRemarks() == null || vo.getStrRemarks().equals(""))?"-":vo.getStrRemarks(),22); 
						daoObj.setProcInValue(nProcIndex, "dcno",			"0",23); 
						daoObj.setProcInValue(nProcIndex, "challan_date",	"0",24); 
						daoObj.setProcInValue(nProcIndex, "adm_chg",		"0",25); 
						daoObj.setProcInValue(nProcIndex, "tax",			"0",26); 						
						daoObj.setProcInValue(nProcIndex, "packsize",       "0",27); 
						daoObj.setProcInValue(nProcIndex, "packno",         "0",28); 	
						daoObj.setProcInValue(nProcIndex, "transno",		vo.getStrLpoNo(),29); 						
						daoObj.setProcInValue(nProcIndex, "pono",			vo.getStrLpoNo(),30); 
						daoObj.setProcInValue(nProcIndex, "strUcChk",		"0",31);                 // Used To Pass Entry Date						
						daoObj.setProcInValue(nProcIndex, "strInstituteId", vo.getStrSeatId(),32);                               // Used To Pass Seat Id
						daoObj.setProcInValue(nProcIndex, "mrp", "0",33);
						daoObj.setProcOutValue(nProcIndex, "err",1,33); 
						
						
						daoObj.executeProcedureByPosition(nProcIndex);
				  
			
		
						strErr = daoObj.getString(nProcIndex, "err");
						if (strErr == null)
							strErr = "";
						if (strErr.equals("")) 
						{
							vo.setStrMsgType("0");
						}
						else 
						{
							
							throw new Exception(strErr);
						}
						
			System.out.println("-------------------- REJECT_END -----[ DAO ]----------------");
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("SupplierReceiptDAO.stockDetails() --> "
					+ e.getMessage());
			
			vo.setStrMsgType("1");
		}
		
		
	}
	/**
	 * for getting  Supplier List on page from HSTT_Supplier_MST
	 * 
	 * @param vo
	 * @throws Exception
	 */
	
	
	
	
//	public static void getInstituteList(AckSuppReceiptVO vo) {
//
//		String strproc_name = "";
//		HisDAO dao = null;
//		int nprocIndex = 0;
//		String strerr = "";
//		WebRowSet wb = null;
//
//		try {
//			dao = new HisDAO("mms", "LocalPurchaseMRN_DAO");
//			strproc_name = "{call PKG_MMS_VIEW.proc_institute_list(?,?,?,?)}"; //4
//			nprocIndex = dao.setProcedure(strproc_name);
//
//			dao.setProcInValue(nprocIndex, "modeval", "1",1);
//			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
//			dao.setProcOutValue(nprocIndex, "err", 1,3);
//			dao.setProcOutValue(nprocIndex, "resultset", 2,4);
//			dao.executeProcedureByPosition(nprocIndex);
//			strerr = dao.getString(nprocIndex, "err");
//			if (strerr == null)
//				strerr = "";
//			wb = dao.getWebRowSet(nprocIndex, "resultset");
//			if (strerr.equals("")) {
//
//				vo.setInstituteListWs(wb);
//
//			} else {
//				throw new Exception(strerr);
//			}
//		} catch (Exception e) {
//			vo
//					.setStrMsgString("AckSuppReceiptDAO.getInstituteList() --> "
//							+ e.getMessage());
//			vo.setStrMsgType("1");
//		} finally {
//			if (dao != null) {
//				dao.free();
//				dao = null;
//			}
//		}
//	}
//	
	
	
	//------------------------------------insitute Dao-------------------------------------------------//
	public static void getInstituteList1(AckSuppReceiptVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strproc_name = "{call PKG_MMS_VIEW.proc_institute_list(?,?,?,?)}"; //4
		int nprocIndex = 0;
	
		String strErr = "";

		try {

			dao = new HisDAO("MMS Transactions","AckSuppReceiptDAO");

			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcOutValue(nprocIndex, "err", 1,3);
			dao.setProcOutValue(nprocIndex, "resultset", 2,4);
			dao.executeProcedureByPosition(nprocIndex);
			strErr = dao.getString(nprocIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = dao.getWebRowSet(nprocIndex, "resultset");
		
				vo.setStrSupplierWs1(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo
					.setStrMsgString("AckSuppReceiptDAO.getItemCatDtls() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}
	//-------------------------------------------------------END-------------------------------------------------
	
	
	
	
	
	public static void getSupplierList(AckSuppReceiptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_supplier_list(?,?,?,?,? ,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","AckSuppReceiptDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "catcode", voObj.getStrReqTypeId(),2);
			daoObj.setProcInValue(nProcIndex, "branditem_id", "0",3);
			daoObj.setProcInValue(nProcIndex, "contracttype", "12",4);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),5);
			daoObj.setProcOutValue(nProcIndex, "err", 1,6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrSupplierWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("AckSuppReceiptDAO.getItemCatDtls() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	/**
	 * for getting  Supplier List on page from HSTT_Supplier_MST
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getItemList(AckSuppReceiptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_itembrand_list(?,?,?,?,? ,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","AckSuppReceiptDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "catcode", voObj.getStrReqTypeId(),2);
			daoObj.setProcInValue(nProcIndex, "branditem_id", "0",3);
			daoObj.setProcInValue(nProcIndex, "grpid", "0",4);
			daoObj.setProcInValue(nProcIndex, "subgrpid", "0",5);
			daoObj.setProcInValue(nProcIndex, "setflag", "0",6);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),7);
			daoObj.setProcOutValue(nProcIndex, "err", 1,8);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,9);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setItemWS(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("AckSuppReceiptDAO.getItemCatDtls() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	public static void getPrintDetails(AckSuppReceiptVO vo) {
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet ws = null;
		System.out.println("-------------------AckSuppReceiptDAO.getPrintDetails------[PKG_MMS_VIEW.proc_hstt_Supplier_Receipt_dtl Mode - 1 ]--------------");
		
		try {
			dao = new HisDAO("mms", "AckSuppReceiptDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_hstt_Supplier_Receipt_dtl(?,?,?,?,? ,?)}";
			nprocIndex = dao.setProcedure(strproc_name);			
			/*
			System.out.println("vo.getStrStoreId()------>"+vo.getStrStoreId());
			System.out.println("vo.getStrLpoNo()------>"+vo.getStrLpoNo());
			System.out.println("vo.getStrHospitalCode()------>"+vo.getStrHospitalCode());
			*/
			
			dao.setProcInValue(nprocIndex, "modval", 		"1",1);
			dao.setProcInValue(nprocIndex, "strId", 		vo.getStrStoreId(),2);
			dao.setProcInValue(nprocIndex, "lpno", 			vo.getStrLpoNo(),3);
			dao.setProcInValue(nprocIndex, "hosp_code", 	vo.getStrHospitalCode(),4);	
			dao.setProcOutValue(nprocIndex, "err", 			1,5);
			dao.setProcOutValue(nprocIndex, "resultset", 	2,6);
			
			dao.executeProcedureByPosition(nprocIndex);
			
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {
				ws = dao.getWebRowSet(nprocIndex, "resultset");		
				vo.setWsPrint(ws);							
			} else {
				throw new Exception(strerr);
			}	

		} catch (Exception e) {
			vo.setStrMsgString("AckSuppReceiptDAO.getPrintDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getPrintDetailsAfterModify(AckSuppReceiptVO vo) {
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet ws = null;
		System.out.println("-------------------AckSuppReceiptDAO.getPrintDetailsAfterModify------[PKG_MMS_VIEW.proc_hstt_Supplier_Receipt_dtl Mode - 1 ]--------------");
		
		try {
			dao = new HisDAO("mms", "AckSuppReceiptDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_hstt_Supplier_Receipt_dtl(?,?,?,?,? ,?)}";
			nprocIndex = dao.setProcedure(strproc_name);			
			/*
			System.out.println("vo.getStrStoreId()------>"+vo.getStrStoreId());
			System.out.println("vo.getStrLpoNo()------>"+vo.getStrLpoNo());
			System.out.println("vo.getStrHospitalCode()------>"+vo.getStrHospitalCode());
			*/
			
			dao.setProcInValue(nprocIndex, "modval", 		"1",1);
			dao.setProcInValue(nprocIndex, "strId", 		vo.getStrStoreId(),2);
			dao.setProcInValue(nprocIndex, "lpno", 			vo.getStrMrnNo(),3);
			dao.setProcInValue(nprocIndex, "hosp_code", 	vo.getStrHospitalCode(),4);	
			dao.setProcOutValue(nprocIndex, "err", 			1,5);
			dao.setProcOutValue(nprocIndex, "resultset", 	2,6);
			
			dao.executeProcedureByPosition(nprocIndex);
			
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {
				ws = dao.getWebRowSet(nprocIndex, "resultset");		
				vo.setWsPrint(ws);							
			} else {
				throw new Exception(strerr);
			}	

		} catch (Exception e) {
			vo.setStrMsgString("AckSuppReceiptDAO.getPrintDetailsAfterModify() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void modifySave(AckSuppReceiptVO vo)
	{
		 
		HisDAO daoObj=null;		
		String lpno = "0";
		String strBrandId = "0";		
		int nProcIndex = 0;
		String strErr = "";
		
		try
		{	
			
			
			System.out.println("vo.getStrMrnNo()--------------->"+vo.getStrMrnNo()); //
			System.out.println("vo.getStrStoreId()--------------->"+vo.getStrStoreId()); //
			System.out.println("vo.getStrPoDate()--------------->"+vo.getStrPoDate()); //
			System.out.println("vo.getStrSupplierId()--------------->"+vo.getStrSupplierId());	//
			System.out.println("vo.getStrDCNo()--------------->"+vo.getStrDCNo());//
			System.out.println("vo.getStrChallanDate()--------------->"+vo.getStrChallanDate());	//
			System.out.println("vo.getStrInvoiceNo()--------------->"+vo.getStrInvoiceNo());	//
			System.out.println("vo.getStrInvoiceDate()----------------->"+vo.getStrInvoiceDate()); //
			System.out.println("vo.getStrExpDeliveryDate----------------->"+vo.getStrExpDeliveryDate()); //
			System.out.println("vo.getStrLpoNo----------------->"+vo.getStrLpoNo()); //
			System.out.println("vo.getStrInstituteId----------------->"+vo.getStrInstituteId()); //
			System.out.println("vo.getStrManufacturer----------------->"+vo.getStrManufacturer()); //
			System.out.println("vo.getStrRemarks----------------->"+vo.getStrRemarks()); //
	

	          daoObj     = new HisDAO("Local Purchase","AckSuppReceiptDAO"); 
	
														 
			    String strProcName = "{call Pkg_Mms_dml.dml_hstt_lp_dtl(?,?,?,?,?,  ?,?,?,?,?,   ?,?,?,?,?  ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?)}";  //34 variables
			    
			    nProcIndex = daoObj.setProcedure(strProcName);						
				
				daoObj.setProcInValue(nProcIndex, "modval",        "7",1);					
				daoObj.setProcInValue(nProcIndex, "store_id",		vo.getStrStoreId(),2);
				daoObj.setProcInValue(nProcIndex, "item_id",		"0",3);
				daoObj.setProcInValue(nProcIndex, "itembrand_id",	strBrandId,4);
				daoObj.setProcInValue(nProcIndex, "batchsl_no",		vo.getStrMrnNo(),5); // used for MRN no 
				daoObj.setProcInValue(nProcIndex, "hosp_code", 		vo.getStrHospitalCode(),6);
				daoObj.setProcInValue(nProcIndex, "item_cat_code", 	"0",7);
				daoObj.setProcInValue(nProcIndex, "group_id",		vo.getStrSeatId(),8);  // used for seat id
				daoObj.setProcInValue(nProcIndex, "subgroup_id",	vo.getStrManufacturer(),9); // used for manufacturer id
				daoObj.setProcInValue(nProcIndex, "supplier_id",	vo.getStrSupplierId(),10);
				daoObj.setProcInValue(nProcIndex, "qty",			"0",11);
				daoObj.setProcInValue(nProcIndex, "qty_unitid",     "0",12);
				daoObj.setProcInValue(nProcIndex, "expdate",		vo.getStrPoDate(),13);  // used for PO date
				daoObj.setProcInValue(nProcIndex, "mfgdate",		vo.getStrExpDeliveryDate(),14); // used for ExpDeliveryDate
				daoObj.setProcInValue(nProcIndex, "rate", 			"0",15);
				daoObj.setProcInValue(nProcIndex, "rate_unitid",	"6301",16);
				daoObj.setProcInValue(nProcIndex, "saleprice",		"0",17);
				daoObj.setProcInValue(nProcIndex, "saleprice_unitid","6301",18);
				daoObj.setProcInValue(nProcIndex, "seat_id", 		vo.getStrSeatId(),19);
				daoObj.setProcInValue(nProcIndex, "invno", 			vo.getStrInvoiceNo(),20);
				daoObj.setProcInValue(nProcIndex, "invdate", 		vo.getStrInvoiceDate(),21); 
				daoObj.setProcInValue(nProcIndex, "remarks",		(vo.getStrRemarks() == null || vo.getStrRemarks().equals(""))?"-":vo.getStrRemarks(),22); 
				daoObj.setProcInValue(nProcIndex, "dcno",			vo.getStrDCNo(),23); 
				daoObj.setProcInValue(nProcIndex, "challan_date",	vo.getStrChallanDate(),24); 
				daoObj.setProcInValue(nProcIndex, "adm_chg",		"0",25); 
				daoObj.setProcInValue(nProcIndex, "tax",			"0",26); 						
				daoObj.setProcInValue(nProcIndex, "packsize",       "0",27); 
				daoObj.setProcInValue(nProcIndex, "packno",         "0",28); 	
				daoObj.setProcInValue(nProcIndex, "transno",		vo.getStrLpoNo(),29); 						
				daoObj.setProcInValue(nProcIndex, "pono",			vo.getStrLpoNo(),30); 
				daoObj.setProcInValue(nProcIndex, "strUcChk",		"0",31);                 // Used To Pass Entry Date						
				daoObj.setProcInValue(nProcIndex, "strInstituteId", vo.getStrInstituteId(),32);      // vo.getStrInstituteId()             
				daoObj.setProcInValue(nProcIndex, "mrp",  "0",33);
				daoObj.setProcOutValue(nProcIndex, "err",1,34); 
				
				
				daoObj.executeProcedureByPosition(nProcIndex);
		  
	
	
				strErr = daoObj.getString(nProcIndex, "err");
				
				if (strErr == null)
					strErr = "";
				if (strErr.equals("")) 
				{
					vo.setStrMsgType("0");
				}
				else 
				{
					
					throw new Exception(strErr);
				}
						
			System.out.println("-------------------- modifySave_END -----[ DAO ]----------------");
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("SupplierReceiptDAO.modifySave() --> "
					+ e.getMessage());
			
			vo.setStrMsgType("1");
		}
		
		
	}
}
