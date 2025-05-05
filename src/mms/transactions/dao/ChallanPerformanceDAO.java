package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.ChallanPerformanceVO;

public class ChallanPerformanceDAO 
{
	/**
	 * The following procedure is used to populate the value of Supplier Name
	 * combo using Pkg_Mms_View.proc_supplier_list procedure.
	 * 
	 * 
	 */

	public static void getSuppliedByList(ChallanPerformanceVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try 
		{
			dao = new HisDAO("mms", "ChallanPerformanceDAO");
			////System.out.println("==>1");
			strproc_name = "{call PKG_MMS_VIEW.proc_challan_backlog_supp_dtl(?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			////System.out.println("Modify Flg==>"+vo.getStrModifyFlag());
			////System.out.println("Store ID==>"+vo.getStrStoreId());
            if(vo.getStrModifyFlag().equals("1"))
            {	
			    dao.setProcInValue(nprocIndex, "modval", "2");
            }
            else
            {
            	dao.setProcInValue(nprocIndex, "modval", "1");
            }
			dao.setProcInValue(nprocIndex, "strId", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			
			if (strerr.equals("")) {
				 
				vo.setStrManufactureComboWS(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("ChallanPerformanceDAO.getSuppliedByList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getDrugWareHouseNameCombo(ChallanPerformanceVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","IssueTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2");
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
e.printStackTrace();
			voObj
					.setStrMsgString("ChallanPerformanceDAO.getDrugWareHouseNameCombo() --> "
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
	public static void getData(ChallanPerformanceVO ChallanPerformanceVO_p) 
	{
		String err = "";
		String proc_name1 = "{call Pkg_Mms_View.proc_challan_backlog_po_dtl(?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {
				dao = new HisDAO("MMS Transactions","ChallanPerformanceDAO");
		
				HisUtil.replaceNullValueWithEmptyString(ChallanPerformanceVO_p);
				
				procIndex1 = dao.setProcedure(proc_name1);
				
				if(ChallanPerformanceVO_p.getStrModifyFlag().equals("1"))
	            {	
				    dao.setProcInValue(procIndex1, "modval", "2");
	            }
	            else
	            {
	            	dao.setProcInValue(procIndex1, "modval", "1");
	            }				
				dao.setProcInValue(procIndex1, "hosp_code", ChallanPerformanceVO_p.getStrHospitalCode());				
				dao.setProcInValue(procIndex1, "strId",     ChallanPerformanceVO_p.getStrStoreId());
				dao.setProcInValue(procIndex1, "suppId",    ChallanPerformanceVO_p.getStrSupplierId());
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
		
				ChallanPerformanceVO_p.setWrsData(ws);

		} catch (Exception e) {
			//e.printStackTrace();
			ChallanPerformanceVO_p.setStrMsgString("ChallanPerformanceDAO.getData() --> "	+ e.getMessage());
			ChallanPerformanceVO_p.setStrMsgType("1");

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
	public static void getItemCmb(ChallanPerformanceVO ChallanPerformanceVO_p) 
	{
		String err = "";
		String proc_name1 = "{call Pkg_Mms_View.proc_challan_backlog_item_dtl(?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {
				dao = new HisDAO("MMS Transactions","ChallanPerformanceDAO");
		
				HisUtil.replaceNullValueWithEmptyString(ChallanPerformanceVO_p);
				
				procIndex1 = dao.setProcedure(proc_name1);
				if(ChallanPerformanceVO_p.getStrModifyFlag().equals("1"))
	            {	
				    dao.setProcInValue(procIndex1, "modval", "2");
	            }
	            else
	            {
	            	dao.setProcInValue(procIndex1, "modval", "1");
	            }				
				dao.setProcInValue(procIndex1, "hosp_code", ChallanPerformanceVO_p.getStrHospitalCode());				
				dao.setProcInValue(procIndex1, "strId",     ChallanPerformanceVO_p.getStrStoreId());
				dao.setProcInValue(procIndex1, "poNo",    ChallanPerformanceVO_p.getStrPoNo());
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
		
				ChallanPerformanceVO_p.setWrsData(ws);

		} catch (Exception e) {
			//e.printStackTrace();
			ChallanPerformanceVO_p.setStrMsgString("ChallanPerformanceDAO.getItemCmb() --> "	+ e.getMessage());
			ChallanPerformanceVO_p.setStrMsgType("1");

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
	public static void getChallanDtl(ChallanPerformanceVO ChallanPerformanceVO_p) 
	{
		String err = "";
		String proc_name1 = "{call Pkg_Mms_View.proc_challan_backlog_rec_dtl(?,?,?,?,?, ?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

				dao = new HisDAO("MMS Transactions","ChallanPerformanceDAO");
		
				HisUtil.replaceNullValueWithEmptyString(ChallanPerformanceVO_p);
				
				procIndex1 = dao.setProcedure(proc_name1);
				
				if(ChallanPerformanceVO_p.getStrModifyFlag().equals("1"))
	            {	
				    dao.setProcInValue(procIndex1, "modval", "2");
	            }
	            else
	            {
	            	dao.setProcInValue(procIndex1, "modval", "1");
	            }	
				dao.setProcInValue(procIndex1, "hosp_code", ChallanPerformanceVO_p.getStrHospitalCode());
				dao.setProcInValue(procIndex1, "strId", ChallanPerformanceVO_p.getStrStoreId());
				
				
				dao.setProcInValue(procIndex1, "poNo", ChallanPerformanceVO_p.getStrPoNo());
				dao.setProcInValue(procIndex1, "itemId", ChallanPerformanceVO_p.getStrItemBrandId());
				
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
		
				ChallanPerformanceVO_p.setWrsData(ws);

		} catch (Exception e) {
			//e.printStackTrace();
			ChallanPerformanceVO_p.setStrMsgString("ChallanPerformanceDAO.getChallanDtl() --> "	+ e.getMessage());
			ChallanPerformanceVO_p.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
		
	}

	
	
	/**
	 * 
	 * @param ChallanPerformanceVO_p
	 */
	public synchronized static void insertChallanRecord(ChallanPerformanceVO vo_p) 
	{
		HisDAO daoObj = null;
		String strProcName = "";		
		int nProcIndex = 0;					
		try 
		{
			daoObj = new HisDAO("MMS", "ChallanPerformanceDAO");
			
			daoObj = new HisDAO("MMS", "DrugInventoryTransDAO");
			strProcName = "{call PKG_MMS_DML.dml_challan_backlog_dtl(?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?)}"; // 20 Variable

			int length = vo_p.getStrMultiRowBatchNo().length;
			if (vo_p.getStrMultiRowBatchNo() != null && vo_p.getStrMultiRowBatchNo().length > 0)
				
				for (int i = 0; i <length; i++) 
				{
//					//System.out.println("Hidden Challan No==>"+vo_p.getStrHiddenChallanNo()[i]);
//					//System.out.println("Hidden Challan Qty==>"+vo_p.getStrHiddenChallanQty()[i]);
//					//System.out.println("MultiRow Challan No==>"+vo_p.getStrMultiRowChallanNo()[i]);
//					//System.out.println("MultiRow Received date==>"+vo_p.getStrMultiRowChallanReceiveDate()[i]);
//					//System.out.println("Multi Row Invoice Date==>"+vo_p.getStrMultiRowInvoiceDate()[i]);
//					//System.out.println("MultiRow Batch No==>"+vo_p.getStrMultiRowBatchNo()[i]);
//					//System.out.println("MultiRow Received Qty==>"+vo_p.getStrMultiRowReceivedQty()[i]);
//					//System.out.println("MultiRow Report Submitted==>"+vo_p.getStrMultiRowWhetherTestReportSubmitted()[i]);
//					//System.out.println("MultiRow Good Condition==>"+vo_p.getStrMultiRowWhetherMedicinesInGoodCondition()[i]);
//					//System.out.println("MultiRow Supply Not For Sale==>"+vo_p.getStrMultiRowWhetherSupplyNotForSale()[i]);
//					//System.out.println("MultiRow Barnd name Not Written==>"+vo_p.getStrMultiRowWhetherBrandNameNotWritten()[i]);
//					//System.out.println("MultiRow MRP Print==>"+vo_p.getStrMultiRowWhetherMRPPrint()[i]);
				
					nProcIndex = daoObj.setProcedure(strProcName);
					daoObj.setProcInValue(nProcIndex, "modval", "1");                       //1
					daoObj.setProcInValue(nProcIndex, "hosp_code", vo_p.getStrHospitalCode());    //2
					daoObj.setProcInValue(nProcIndex, "store_id", vo_p.getStrDrugWareHouseName());//3
					daoObj.setProcInValue(nProcIndex, "suppId", vo_p.getStrSupplierId());		//4		
					daoObj.setProcInValue(nProcIndex, "poNo", vo_p.getStrPoNo());                         //5
					daoObj.setProcInValue(nProcIndex, "challanNo", vo_p.getStrHiddenChallanNo()[i]);    //6
					daoObj.setProcInValue(nProcIndex, "actRecDate", vo_p.getStrMultiRowChallanReceiveDate()[i]);  //7
					daoObj.setProcInValue(nProcIndex, "suppInvNo", vo_p.getStrMultiRowChallanNo()[i]);		//8			
					daoObj.setProcInValue(nProcIndex, "suppInvDate", vo_p.getStrMultiRowInvoiceDate()[i]);                      //9
					daoObj.setProcInValue(nProcIndex, "itembrandid", vo_p.getStrItemId().split("\\^")[0]);      //10
					daoObj.setProcInValue(nProcIndex, "batchNo", vo_p.getStrMultiRowBatchNo()[i]);     //11
					daoObj.setProcInValue(nProcIndex, "oldQty", vo_p.getStrHiddenChallanQty()[i]);		    //12			
					daoObj.setProcInValue(nProcIndex, "newQty", vo_p.getStrMultiRowReceivedQty()[i]);					        //13
					daoObj.setProcInValue(nProcIndex, "testRptFlag", vo_p.getStrMultiRowWhetherTestReportSubmitted()[i]);      //14
					daoObj.setProcInValue(nProcIndex, "drugCondFlag", vo_p.getStrMultiRowWhetherMedicinesInGoodCondition()[i]);//15
					daoObj.setProcInValue(nProcIndex, "logogramFlag",vo_p.getStrMultiRowWhetherSupplyNotForSale()[i]);	//16				
					daoObj.setProcInValue(nProcIndex, "brandFlag",vo_p.getStrMultiRowWhetherBrandNameNotWritten()[i]);                        //17
					daoObj.setProcInValue(nProcIndex, "priceFlag", vo_p.getStrMultiRowWhetherMRPPrint()[i]);        //18 
					daoObj.setProcInValue(nProcIndex, "seatId", vo_p.getStrSeatId());      //19
					daoObj.setProcInValue(nProcIndex, "counter", String.valueOf(i));      //19	
					
					daoObj.setProcOutValue(nProcIndex, "err", 1);  //20
					daoObj.execute(nProcIndex, 1);

				}
			
			daoObj.fire();

			
									

		}
		catch (Exception e) 
		{
			e.printStackTrace();
			vo_p.setStrMsgString("ChallanPerformanceDAO.Insert() --> "	+ e.getMessage());
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
