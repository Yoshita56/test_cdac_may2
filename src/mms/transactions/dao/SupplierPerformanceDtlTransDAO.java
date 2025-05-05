package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.SupplierPerformanceDtlTransVO;

public class SupplierPerformanceDtlTransDAO {
	
	public static void getDrugWareHouseNameCombo(SupplierPerformanceDtlTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","IssueTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "4");
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			
			/* Setting Default Value Start*/
			daoObj.setProcInValue(nProcIndex, "storeid", "0");
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0");
			/* Setting Default Value End */
			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
		
				voObj.setWrsDrugWareHouseNameCmb(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("SupplierPerformanceDtlTransDAO.getDrugWareHouseNameCombo() --> "
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
	 * To Get Data
	 * 
	 * @param budgetAllocationDetailProcessTransVO_p
	 */
	public static void getData(SupplierPerformanceDtlTransVO supplierPerformanceDtlTransVO_p) 
	{
		String err = "";
		String proc_name1 = "{call Pkg_Mms_View.proc_SuppPerformance_Dtls(?,?,?,?,?, ?,?,?,?,?, ?,? )}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

				dao = new HisDAO("MMS Transactions","SupplierPerformanceDtlTransDAO");
		
				HisUtil.replaceNullValueWithEmptyString(supplierPerformanceDtlTransVO_p);
				
				procIndex1 = dao.setProcedure(proc_name1);
				
//				---------------
				/*//System.out.println( "p_mode"+ supplierPerformanceDtlTransVO_p.getStrMode());
				//System.out.println( "p_seatId"+ supplierPerformanceDtlTransVO_p.getStrSeatId());
				//System.out.println( "p_hosp_code"+ supplierPerformanceDtlTransVO_p.getStrHospitalCode());
				
				
				//System.out.println( "p_dwhId"+ supplierPerformanceDtlTransVO_p.getStrDWHId());
				//System.out.println( "p_pono"+ supplierPerformanceDtlTransVO_p.getStrPoNo());
				//System.out.println( "p_challanNo"+ supplierPerformanceDtlTransVO_p.getStrChallanNo());
				//System.out.println( "p_supplierId"+ "0");
				//System.out.println( "p_storeId"+ supplierPerformanceDtlTransVO_p.getStrStoreId());
				
				//System.out.println( "p_fromDate"+ supplierPerformanceDtlTransVO_p.getStrFromDate());

				//System.out.println( "p_toDate"+ supplierPerformanceDtlTransVO_p.getStrToDate());*/
				
//				---------------
				
				dao.setProcInValue(procIndex1, "p_mode", supplierPerformanceDtlTransVO_p.getStrMode());
				dao.setProcInValue(procIndex1, "p_seatId", supplierPerformanceDtlTransVO_p.getStrSeatId());
				dao.setProcInValue(procIndex1, "p_hosp_code", supplierPerformanceDtlTransVO_p.getStrHospitalCode());
				
				
				dao.setProcInValue(procIndex1, "p_dwhId", supplierPerformanceDtlTransVO_p.getStrDWHId());
				dao.setProcInValue(procIndex1, "p_pono", supplierPerformanceDtlTransVO_p.getStrPoNo());
				dao.setProcInValue(procIndex1, "p_challanNo", supplierPerformanceDtlTransVO_p.getStrChallanNo());
				dao.setProcInValue(procIndex1, "p_supplierId", "0");
				dao.setProcInValue(procIndex1, "p_storeId", supplierPerformanceDtlTransVO_p.getStrStoreId());
				
				dao.setProcInValue(procIndex1, "p_fromDate", supplierPerformanceDtlTransVO_p.getStrFromDate());

				dao.setProcInValue(procIndex1, "p_toDate", supplierPerformanceDtlTransVO_p.getStrToDate());
			
				
				
				
				
				/* Setting Default Value End */
				
				dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
				// value
				dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object
		
				// execute procedure
		
				dao.executeProcedure(procIndex1);
		
				// get value
				err = dao.getString(procIndex1, "err");
		
				if (err == null)
					err = "";
		
				ws = dao.getWebRowSet(procIndex1, "resultset");
		
				supplierPerformanceDtlTransVO_p.setWrsData(ws);

		} catch (Exception e) {
			//e.printStackTrace();
			supplierPerformanceDtlTransVO_p.setStrMsgString("SupplierPerformanceDtlTransDAO.getData() --> "	+ e.getMessage());
			supplierPerformanceDtlTransVO_p.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
		
	}

	/**
	 * To Get Data
	 * 
	 * @param budgetAllocationDetailProcessTransVO_p
	 */
	public static void getBatchCmb(SupplierPerformanceDtlTransVO supplierPerformanceDtlTransVO_p) 
	{
		String err = "";
		String proc_name1 = "{call Pkg_Mms_View.proc_SuppPerformance_Dtls(?,?,?,?,?, ?,?,?,?,?, ?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

				dao = new HisDAO("MMS Transactions","SupplierPerformanceDtlTransDAO");
		
				HisUtil.replaceNullValueWithEmptyString(supplierPerformanceDtlTransVO_p);
				
				procIndex1 = dao.setProcedure(proc_name1);
				
				dao.setProcInValue(procIndex1, "p_mode", "6");
				dao.setProcInValue(procIndex1, "p_seatId", supplierPerformanceDtlTransVO_p.getStrSeatId());
				dao.setProcInValue(procIndex1, "p_hosp_code", supplierPerformanceDtlTransVO_p.getStrHospitalCode());
				dao.setProcInValue(procIndex1, "p_dwhId", supplierPerformanceDtlTransVO_p.getStrDWHId());
				dao.setProcInValue(procIndex1, "p_pono", supplierPerformanceDtlTransVO_p.getStrPoNo());
				dao.setProcInValue(procIndex1, "p_challanNo", supplierPerformanceDtlTransVO_p.getStrChallanNo());
				dao.setProcInValue(procIndex1, "p_supplierId", "0");
				dao.setProcInValue(procIndex1, "p_storeId", supplierPerformanceDtlTransVO_p.getStrStoreId());
				dao.setProcInValue(procIndex1, "p_fromDate", supplierPerformanceDtlTransVO_p.getStrItemBrandId());   // Temprary Used As Item Brand Id in procedure
				dao.setProcInValue(procIndex1, "p_toDate", supplierPerformanceDtlTransVO_p.getStrToDate());
				/* Setting Default Value End */
				dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
				// value
				dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object
				// execute procedure
				dao.executeProcedure(procIndex1);
								
				ws = dao.getWebRowSet(procIndex1, "resultset");
		
				supplierPerformanceDtlTransVO_p.setWrsData(ws);

		} catch (Exception e) {
			e.printStackTrace();
			supplierPerformanceDtlTransVO_p.setStrMsgString("SupplierPerformanceDtlTransDAO.getData() --> "	+ e.getMessage());
			supplierPerformanceDtlTransVO_p.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
		
	}
	
	/**
	 * 
	 * @param supplierPerformanceDtlTransVO_p
	 */
	public synchronized static void insert(SupplierPerformanceDtlTransVO vo_p) 
	{
		HisDAO daoObj = null;

		
		String strProcName = "";
		
		String strGenericItemId;
		int nProcIndex = 0;

		
		HisUtil hisutil = null;
		boolean flag = false;
		int funcIndex;
		try 
		{
			daoObj = new HisDAO("MMS", "SupplierPerformanceDtlTransDAO");
			hisutil = new HisUtil("mms", "SupplierPerformanceDtlTransDAO");
			
			
			 funcIndex = daoObj.setFunction("{? = call MMS_MST.get_genericitem_dtl(?,?,?)}"); //3
			  
				// Set Value
				
			 daoObj.setFuncInValue(funcIndex, 2, "1");
			 daoObj.setFuncInValue(funcIndex, 3, vo_p.getStrHospitalCode());
			 daoObj.setFuncInValue(funcIndex, 4, vo_p.getStrItemBrandId());
			 daoObj.setFuncOutValue(funcIndex, 1);
			 daoObj.executeFunction(funcIndex);
				  strGenericItemId = daoObj.getFuncString(funcIndex);
				  vo_p.setStrGenericItemId(strGenericItemId);
			
			
			 strProcName = "{call PKG_MMS_DML.proc_HSTT_SUPP_PERFORMPRAM_DTL(?,?,?,?,?,?,?,?,?,?  ,?,?,?,?,?,?,?,?,?,? ,?,?,?,?,? ,?)}";// 26 Varibale's
		        nProcIndex = daoObj.setProcedure(strProcName);		
		        
		        
		        HisUtil.replaceNullValueWithEmptyString(vo_p);

//		       //System.out.println( "p_HSTNUM_STORE_ID"+ vo_p.getStrDWHId());          	     //2
//				//System.out.println( "p_HSTNUM_CHALLAN_NO"+vo_p.getStrChallanNo());  	     //3
//				//System.out.println( "p_GNUM_HOSPITAL_CODE"+ vo_p.getStrHospitalCode());                //4
//				//System.out.println( "p_HSTDT_CHALLAN_DATE"+"");               //5
//				//System.out.println( "p_HSTSTR_SUPP_RECIEPT_NO"+vo_p.getStrReceiptNo());        //6
//				//System.out.println( "p_HSTNUM_SUPPLIER_ID"+"0");         //7
//				//System.out.println( "p_HSTNUM_ITEM_ID"+vo_p.getStrGenericItemId());   //Challan Verify Insert      //8
//				//System.out.println( "p_HSTNUM_ITEMBRAND_ID"+vo_p.getStrItemBrandId());      	 //9
//				
//				 //System.out.println( "p_HSTSTR_REPORT_NO"+	vo_p.getStrReportNumber());         	 //10
//				 //System.out.println( "p_HSTDT_REPORT_DATE"+vo_p.getStrReportDate());    	  	 //11
//				
//				//System.out.println( "p_HSTSTR_DRUG_CONDITION"+	vo_p.getStrWhetherMedicinesInGoodCondition());         //12
//				//System.out.println( "p_HSTSTR_IS_QC_PRINTED"+ vo_p.getStrWhetherSupplyNotForSale());  	 	 //13
//				//System.out.println( "p_HSTSTR_IS_GENERIC"+vo_p.getStrWhetherBrandNameNotWritten());      //14
//				//System.out.println( "p_HSTSTR_IS_MRP_PRINTED"+vo_p.getStrWhetherMRPPrint()); 	 //15
//				//System.out.println( "p_GNUM_SEATID"+vo_p.getStrSeatId());                     //16
//				//System.out.println( "p_GDT_ENTRY_DATE"+"");    				                         //17
//				//System.out.println( "p_GNUM_ISVALID"+"1");                              //18
//				
//				//System.out.println( "p_HSTNUM_PO_NO"+vo_p.getStrPoNo());    			          //19
//				//System.out.println( "p_HSTDT_PO_DATE"+"");                     //20
//				//System.out.println( "p_HSTNUM_STOCK_PAGE_NO"+vo_p.getStrPageNo());          //21
//				//System.out.println( "p_HSTNUM_ONLINE_FLAG"+"0");                              //22
//				//System.out.println( "p_SSTSTR_PO_PREFIX"+"");   //23
//				//System.out.println( "p_accepted_qty"+vo_p.getStrAcceptedQty());	//24
				
						
				
				daoObj.setProcInValue(nProcIndex, "p_mode", "1");                                    	     //1
				daoObj.setProcInValue(nProcIndex, "p_HSTNUM_STORE_ID", vo_p.getStrDWHId());          	     //2
				daoObj.setProcInValue(nProcIndex, "p_HSTNUM_CHALLAN_NO",vo_p.getStrChallanNo());  	     //3
				daoObj.setProcInValue(nProcIndex, "p_GNUM_HOSPITAL_CODE", vo_p.getStrHospitalCode());                //4
				daoObj.setProcInValue(nProcIndex, "p_HSTDT_CHALLAN_DATE","");               //5
				daoObj.setProcInValue(nProcIndex, "p_HSTSTR_SUPP_RECIEPT_NO","0");        //6
				daoObj.setProcInValue(nProcIndex, "p_HSTNUM_SUPPLIER_ID","0");         //7
				daoObj.setProcInValue(nProcIndex, "p_HSTNUM_ITEM_ID",vo_p.getStrGenericItemId());   //Challan Verify Insert      //8
				daoObj.setProcInValue(nProcIndex, "p_HSTNUM_ITEMBRAND_ID",vo_p.getStrItemBrandId());      	 //9
				
				 daoObj.setProcInValue(nProcIndex, "p_HSTSTR_REPORT_NO",	vo_p.getStrReportNumber());         	 //10
				 daoObj.setProcInValue(nProcIndex, "p_HSTDT_REPORT_DATE",vo_p.getStrReportDate());    	  	 //11
				
				daoObj.setProcInValue(nProcIndex, "p_HSTSTR_DRUG_CONDITION",	vo_p.getStrWhetherMedicinesInGoodCondition());         //12
				daoObj.setProcInValue(nProcIndex, "p_HSTSTR_IS_QC_PRINTED", vo_p.getStrWhetherSupplyNotForSale());  	 	 //13
				daoObj.setProcInValue(nProcIndex, "p_HSTSTR_IS_GENERIC",vo_p.getStrWhetherBrandNameNotWritten());      //14
				daoObj.setProcInValue(nProcIndex, "p_HSTSTR_IS_MRP_PRINTED",vo_p.getStrWhetherMRPPrint()); 	 //15
				daoObj.setProcInValue(nProcIndex, "p_GNUM_SEATID",vo_p.getStrSeatId());                     //16
				daoObj.setProcInValue(nProcIndex, "p_GDT_ENTRY_DATE","");    				                         //17
				daoObj.setProcInValue(nProcIndex, "p_GNUM_ISVALID","1");                              //18
				
				daoObj.setProcInValue(nProcIndex, "p_HSTNUM_PO_NO",vo_p.getStrPoNo());    			          //19
				daoObj.setProcInValue(nProcIndex, "p_HSTDT_PO_DATE","");                     //20
				daoObj.setProcInValue(nProcIndex, "p_HSTNUM_STOCK_PAGE_NO",vo_p.getStrPageNo());          //21
				daoObj.setProcInValue(nProcIndex, "p_HSTNUM_ONLINE_FLAG","0");                              //22
				daoObj.setProcInValue(nProcIndex, "p_SSTSTR_PO_PREFIX","");                              //23
				daoObj.setProcInValue(nProcIndex, "p_accepted_qty",vo_p.getStrAcceptedQty());                              //24
				daoObj.setProcInValue(nProcIndex, "p_HSTSTR_BATCH_NO",vo_p.getStrBatchNo());                   //25
				daoObj.setProcOutValue(nProcIndex, "err", 1);                                        //26

				daoObj.executeProcedure(nProcIndex);                            //19
			
									

		}
		catch (Exception e) 
		{
			//e.printStackTrace();
			vo_p.setStrMsgString("SupplierPerformanceDtlTransDAO.Insert() --> "	+ e.getMessage());
			vo_p.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;

			}

		}

	}
	
	
	
}
