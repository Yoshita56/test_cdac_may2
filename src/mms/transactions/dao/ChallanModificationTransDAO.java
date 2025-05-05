package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.ChallanModificationTransVO;

public class ChallanModificationTransDAO 
{

	public static void getSuppliedByList(ChallanModificationTransVO voObj) 
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_challan_modify_dtl(?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			 
			daoObj = new HisDAO("MMS Transactions","IssueTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "storeid", voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "suppId", "0");
			daoObj.setProcInValue(nProcIndex, "poNo", "0");
			daoObj.setProcInValue(nProcIndex, "ChallanNo", "0");			
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());			
			/* Setting Default Value End */
			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
					        				
				voObj.setStrManufactureComboWS(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} 
		catch (Exception e) 
		{
            e.printStackTrace();
			voObj.setStrMsgString("ChallanModificationTransDAO.getSuppliedByList() --> "+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getDrugWareHouseNameCombo(ChallanModificationTransVO voObj) 
	{

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
					.setStrMsgString("ChallanModificationTransDAO.getDrugWareHouseNameCombo() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	

	public static void getData(ChallanModificationTransVO voObj) 
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_challan_modify_dtl(?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			 
			daoObj = new HisDAO("MMS Transactions","IssueTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "storeid", voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "suppId", voObj.getStrSupplierId());
			daoObj.setProcInValue(nProcIndex, "poNo", "0");
			daoObj.setProcInValue(nProcIndex, "ChallanNo", "0");			
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());			
			/* Setting Default Value End */
			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
					        				
				voObj.setWrsData(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} 
		catch (Exception e) 
		{
            e.printStackTrace();
			voObj.setStrMsgString("ChallanModificationTransDAO.getData() --> "+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getChallanNoCombo(ChallanModificationTransVO voObj) 
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_challan_modify_dtl(?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			 
			daoObj = new HisDAO("MMS Transactions","IssueTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "3");
			daoObj.setProcInValue(nProcIndex, "storeid", voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "suppId", voObj.getStrSupplierId());
			daoObj.setProcInValue(nProcIndex, "poNo", voObj.getStrPoNo());
			daoObj.setProcInValue(nProcIndex, "ChallanNo", "0");			
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());		
			
			/* Setting Default Value End */
			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
					        	//System.out.println("Size==>"+ws.size());			
				voObj.setWrsChallanNoCmb(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} 
		catch (Exception e) 
		{
            e.printStackTrace();
			voObj.setStrMsgString("ChallanModificationTransDAO.getChallanNoCombo() --> "+ e.getMessage());
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
	public static void getItemCmb(ChallanModificationTransVO ChallanModificationTransVO_p) 
	{
		String err = "";
		String proc_name1 = "{call Pkg_Mms_View.proc_challan_backlog_item_dtl(?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {
				dao = new HisDAO("MMS Transactions","ChallanModificationTransDAO");
		
			//	HisUtil.replaceNullValueWithEmptyString(ChallanModificationTransVO_p);
				
				procIndex1 = dao.setProcedure(proc_name1);
				if(ChallanModificationTransVO_p.getStrModifyFlag().equals("1"))
	            {	
				    dao.setProcInValue(procIndex1, "modval", "2");
	            }
	            else
	            {
	            	dao.setProcInValue(procIndex1, "modval", "3");
	            }				
				dao.setProcInValue(procIndex1, "hosp_code", ChallanModificationTransVO_p.getStrHospitalCode());				
				dao.setProcInValue(procIndex1, "strId",     ChallanModificationTransVO_p.getStrStoreId());
				dao.setProcInValue(procIndex1, "poNo",    ChallanModificationTransVO_p.getStrPoNo());
				////System.out.println("Po No==>"+ChallanModificationTransVO_p.getStrPoNo());
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
		
				ChallanModificationTransVO_p.setWrsData(ws);

		} catch (Exception e) {
			//e.printStackTrace();
			ChallanModificationTransVO_p.setStrMsgString("ChallanModificationTransDAO.getItemCmb() --> "	+ e.getMessage());
			ChallanModificationTransVO_p.setStrMsgType("1");

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
	public static void getChallanDtl(ChallanModificationTransVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_challan_modify_dtl(?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			 
			daoObj = new HisDAO("MMS Transactions","IssueTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "4");
			daoObj.setProcInValue(nProcIndex, "storeid", voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "suppId", voObj.getStrSupplierId());
			daoObj.setProcInValue(nProcIndex, "poNo", voObj.getStrPoNo());
			daoObj.setProcInValue(nProcIndex, "ChallanNo", voObj.getStrChallanNo());			
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());		
			
			/* Setting Default Value End */
			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
					        	
				voObj.setWrsData(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} 
		catch (Exception e) 
		{
            e.printStackTrace();
			voObj.setStrMsgString("ChallanModificationTransDAO.getChallanNoCombo() --> "+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
		
	}
	
	
	
	/**
	 * 
	 * @param ChallanModificationTransVO_p
	 */
	public synchronized static void insertChallanRecord(ChallanModificationTransVO vo_p) 
	{
		HisDAO daoObj = null;
		String strProcName = "";		
		int nProcIndex = 0;	
		String strerr = "";
		try 
		{
			     daoObj = new HisDAO("MMS", "ChallanModificationTransDAO");
			strProcName = "{call PKG_MMS_DML.dml_challan_modify_dtl(?,?,?,?,?,  ?,?,?,?,? ,?,?,?,?,?,  ?,?,?,?,? , ?,?,?,?,?,  ?,?,?,?,?,?)}"; // 31 Variable
						
			/*
			  1.Item Brand Id
			  2.Batch No
			  3.Accepted Qty
			  4.Breakage Qty
			  5.Rejected Qty
			  6.Excess Qty.
			  7.Manufactrer Date
			  8.Expiry Date
			  9.Unit Base e.g No.
			 10.PO Dtl[Order Qty ^ Total Accepted Qty ^ Total Rejected Qty] 
			 11.Supplier Performance Dtl[WhetherMedicinesWithTestReport ^ WhetherMedicinesInGoodCondition ^ WhetherSupplyNotForSale ^ WhetherBrandNameNotWritten ^ WhetherMRPPrint ]
			 12.Drug Name
			 13.Current Available Qty 
			*/
			
//			//System.out.println("strId==>"+vo_p.getStrDrugWareHouseName());    //2
//			//System.out.println("hosp_code==>"+vo_p.getStrHospitalCode());//3
//			//System.out.println("challanNo==>"+vo_p.getStrChallanValue().split("\\^")[0]);		//4		
//			//System.out.println("brandId==>"+vo_p.getStrPrevHiddenChallanValue().split("\\$")[0]);                         //5
//			//System.out.println("oldBatchNo==>"+vo_p.getStrPrevHiddenChallanValue().split("\\$")[1]);    //6
//			//System.out.println("newBatchNo==>"+vo_p.getStrBatchNo());  //7
//			//System.out.println("oldAccQty==>"+vo_p.getStrPrevHiddenChallanValue().split("\\$")[2]);		//8			
//			//System.out.println("newAccQty==>"+vo_p.getStrAcceptedQuantity());                      //9
//			//System.out.println("oldRejQty==>"+vo_p.getStrPrevHiddenChallanValue().split("\\$")[4]);      //10
//			//System.out.println("newRejQty==>"+vo_p.getStrRejectedQuantity());     //11
//			//System.out.println("oldBreakQty==>"+vo_p.getStrPrevHiddenChallanValue().split("\\$")[3]);		    //12			
//			//System.out.println("newBreakQty==>"+vo_p.getStrBreakageQuantity());					        //13
//			//System.out.println("oldExcessQty==>"+vo_p.getStrPrevHiddenChallanValue().split("\\$")[5]);      //14
//			//System.out.println("newExcessQty==>"+vo_p.getStrExcessQty());//15					
//			//System.out.println("newMfgDate==>"+vo_p.getStrManufactureDate());  //16
//			//System.out.println("newExpDate==>"+vo_p.getStrExpiryDate());		//17			
//			//System.out.println("orderQty==>"+(vo_p.getStrPrevHiddenChallanValue().split("\\$")[9]).split("\\^")[0]);     //18
//			//System.out.println("totAccQty==>"+(vo_p.getStrPrevHiddenChallanValue().split("\\$")[9]).split("\\^")[1]);      //19
//			//System.out.println("totRejQty==>"+(vo_p.getStrPrevHiddenChallanValue().split("\\$")[9]).split("\\^")[2]);     //20
//			//System.out.println("suppChallanNo==>"+vo_p.getStrSupplierChallanNo());		 //21			
//			//System.out.println("suppChallanDate==>"+vo_p.getStrSupplierChallanDate());		//22
//			//System.out.println("recDate==>"+vo_p.getStrChallanReceiveDate());   //23
//			//System.out.println("newTestRptFlag==>"+ vo_p.getStrWhetherMedicinesWithTestReport());//24					
//			//System.out.println("newCondFlag==>"+vo_p.getStrWhetherMedicinesInGoodCondition());	//25		
//			//System.out.println("newLogoFlag==>"+vo_p.getStrWhetherSupplyNotForSale());     //26
//			//System.out.println("newBrandFlag==>"+vo_p.getStrWhetherBrandNameNotWritten());        //27
//			//System.out.println("newPriceFlag==>"+ vo_p.getStrWhetherMRPPrint());        //28 
//			//System.out.println("remarks==>"+vo_p.getStrRemarks());      //29
//			//System.out.println("seat_id==>"+vo_p.getStrSeatId());      //30
			
			
			
					nProcIndex = daoObj.setProcedure(strProcName);
					daoObj.setProcInValue(nProcIndex, "modeval", "1");                       //1
					daoObj.setProcInValue(nProcIndex, "strId", vo_p.getStrDrugWareHouseName());    //2
					daoObj.setProcInValue(nProcIndex, "hosp_code", vo_p.getStrHospitalCode());//3
					daoObj.setProcInValue(nProcIndex, "challanNo", vo_p.getStrChallanValue().split("\\^")[0]);		//4		
					daoObj.setProcInValue(nProcIndex, "brandId",   vo_p.getStrPrevHiddenChallanValue().split("\\$")[0]);                         //5
					daoObj.setProcInValue(nProcIndex, "oldBatchNo", vo_p.getStrPrevHiddenChallanValue().split("\\$")[1]);    //6
					daoObj.setProcInValue(nProcIndex, "newBatchNo", vo_p.getStrBatchNo());  //7
					daoObj.setProcInValue(nProcIndex, "oldAccQty", vo_p.getStrPrevHiddenChallanValue().split("\\$")[2]);		//8			
					daoObj.setProcInValue(nProcIndex, "newAccQty", vo_p.getStrAcceptedQuantity());                      //9
					daoObj.setProcInValue(nProcIndex, "oldRejQty", vo_p.getStrPrevHiddenChallanValue().split("\\$")[4]);      //10
					daoObj.setProcInValue(nProcIndex, "newRejQty", vo_p.getStrRejectedQuantity());     //11
					daoObj.setProcInValue(nProcIndex, "oldBreakQty", vo_p.getStrPrevHiddenChallanValue().split("\\$")[3]);		    //12			
					daoObj.setProcInValue(nProcIndex, "newBreakQty", vo_p.getStrBreakageQuantity());					        //13
					daoObj.setProcInValue(nProcIndex, "oldExcessQty", vo_p.getStrPrevHiddenChallanValue().split("\\$")[5]);      //14
					daoObj.setProcInValue(nProcIndex, "newExcessQty", vo_p.getStrExcessQty());//15					
					daoObj.setProcInValue(nProcIndex, "newMfgDate", vo_p.getStrManufactureDate());  //16
					daoObj.setProcInValue(nProcIndex, "newExpDate", vo_p.getStrExpiryDate());		//17			
					daoObj.setProcInValue(nProcIndex, "orderQty", (vo_p.getStrPrevHiddenChallanValue().split("\\$")[9]).split("\\^")[0]);     //18
					daoObj.setProcInValue(nProcIndex, "totAccQty", (vo_p.getStrPrevHiddenChallanValue().split("\\$")[9]).split("\\^")[1]);      //19
					daoObj.setProcInValue(nProcIndex, "totRejQty", (vo_p.getStrPrevHiddenChallanValue().split("\\$")[9]).split("\\^")[2]);     //20
					daoObj.setProcInValue(nProcIndex, "suppChallanNo", vo_p.getStrSupplierChallanNo());		 //21			
					daoObj.setProcInValue(nProcIndex, "suppChallanDate", vo_p.getStrSupplierChallanDate());		//22
					daoObj.setProcInValue(nProcIndex, "recDate", vo_p.getStrChallanReceiveDate());   //23
					daoObj.setProcInValue(nProcIndex, "newTestRptFlag", vo_p.getStrWhetherMedicinesWithTestReport());//24					
					daoObj.setProcInValue(nProcIndex, "newCondFlag",vo_p.getStrWhetherMedicinesInGoodCondition());	//25		
					daoObj.setProcInValue(nProcIndex, "newLogoFlag",vo_p.getStrWhetherSupplyNotForSale());     //26
					daoObj.setProcInValue(nProcIndex, "newBrandFlag", vo_p.getStrWhetherBrandNameNotWritten());        //27
					daoObj.setProcInValue(nProcIndex, "newPriceFlag", vo_p.getStrWhetherMRPPrint());        //28 
					daoObj.setProcInValue(nProcIndex, "remarks", vo_p.getStrRemarks());      //29
					daoObj.setProcInValue(nProcIndex, "seat_id", vo_p.getStrSeatId());      //30					
					daoObj.setProcOutValue(nProcIndex, "err", 1);  //31
					daoObj.execute(nProcIndex,1);
					daoObj.fire();
					strerr = daoObj.getString(nProcIndex, "err");
					if(strerr.length()>0)
					{
						vo_p.setStrMsgString(strerr);	
					}									

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		    
			String strErrMsg = e.getMessage()+"##101##102";
			
			if(strErrMsg.split("\\##")[2].equals("999"))
		    {				
				vo_p.setStrMsgString(strErrMsg.split("\\##")[1]);
				vo_p.setStrMsgType("5");
		    }
			else
			{
				vo_p.setStrMsgString(strErrMsg.split("\\##")[0]);
				vo_p.setStrMsgType("1");
			}					
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

