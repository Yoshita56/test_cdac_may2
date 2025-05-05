/**********************************************************
 Project:	   DWH_CMSS	
 File:         SupplierDeskInterfaceTransDAO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.SupplierDeskInterfaceTransVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierDeskInterfaceTransDAO.
 */
public class SupplierDeskInterfaceTransDAO 
{

	/**
	 * Gets the PO details.
	 * 
	 * @param vo the _ po desk generate trans vo
	 * @return the PO details
	 */
	public static void getPODetails(SupplierDeskInterfaceTransVO vo) 
	{
		String strproc_name = "{call pkg_mms_view.Proc_Po_Details(?,?,?,?,?,?)}"; // 6
		HisDAO dao = null;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS", "transactions.SupplierDeskInterfaceTransDAO.getPODetails()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex,  "modeval", "9");
			dao.setProcInValue(nProcIndex,  "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nProcIndex,  "pono",      vo.getStrPONo());
			dao.setProcInValue(nProcIndex,  "storeId",   vo.getStrStoreId());
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);
			dao.executeProcedure(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				// //System.out.println("Size of WS-->"+wsResult.size());
				wsResult.next();
				vo.setStrPODate(wsResult.getString(1));
				vo.setStrSupplierName(wsResult.getString(2));
				vo.setStrPOType(wsResult.getString(3));
				vo.setStrSupplierId(wsResult.getString(5));
				vo.setStrPOTypeId(wsResult.getString(8));
				vo.setStrItemCat(wsResult.getString(9));
				vo.setStrItemCatName(wsResult.getString(10));
				vo.setStrNextPoDate(wsResult.getString(22));
				vo.setStrPOAuthTypeId(wsResult.getString(30));				
				vo.setStrPrgId(wsResult.getString(35));
				vo.setStrFSId(wsResult.getString(36));
				vo.setStrFSName(wsResult.getString(39));
				vo.setStrPrgName(wsResult.getString(38));
				vo.setStrItemNameNew(wsResult.getString(42));
				vo.setStrBatchExdateFlag(wsResult.getString(51));
				
				////System.out.println("vo.setStrItemNameNew"+vo.getStrItemNameNew());

				/********************************** We Row Set Index *********************************************/
				// (1)PO_DATE ^ (2)SUPP NAME ^ (3)PO TYPE ^ (4)PO NET AMOUNT ^(5) Supplier ID
				// ^ (6)PO Type Id ^(7) Currency Id ^(8)Currency Value ^(9)Catg No
				// ^ (10)Catg Name ^ (11)Purchase Source ID ^ (12)Po Number ^
				// (13)PO Prefix ^(14) Tax
				// ^ (15)Tender Number ^ (16)Tender Date ^ (17)Qutation No ^
				// (18)Qutation Date ^
				// ^ (19) Verify Date
				// ^ (20) Verify BY ^ (21) Financial Period(2013-2014)
				// ^ (22) Next PO Date ^ (23) Purchase Commite date ^ (24)
				// Negotiation Meeting Date ^ (25)Remarks
				// ^ (26) Verified By ^(27)Verify Date ^ (28) Total Amendment ^
				// (29) Rate Contracted Flg ^(30)PO Type Auth id ^ (31) PO Ref
				// No^(32) Store Name {PO Created}^(33)Purchase Source Name ^(34) HSTNUM_RC_ID
				// ^(35)HSTNUM_PROGRAMME_ID^(36)HSTNUM_FUNDING_SOURCE_ID^(37)HSTNUM_REF_PO_NO,
                // (38)programme_name^
                //(39)funding_source_name^
				//(40)hstnum_draft_flg
				//(41)Rate_Cont_qty
				
				
				
				/**********************************************************************************/
				vo.setStrPOHiddenValue(wsResult.getString(1) + "^" + wsResult.getString(2) + "^" + wsResult.getString(3) + "^"
						+ wsResult.getString(4) + "^" + wsResult.getString(5) + "^" + wsResult.getString(6) + "^" + wsResult.getString(7) + "^"
						+ wsResult.getString(8) + "^" + wsResult.getString(9) + "^" + wsResult.getString(10) + "^" + wsResult.getString(11) + "^"
						+ wsResult.getString(12) + "^" + wsResult.getString(13) + "^" + wsResult.getString(14) + "^" + wsResult.getString(15) + "^"
						+ wsResult.getString(16) + "^" + wsResult.getString(17) + "^" + wsResult.getString(18) + "^" + wsResult.getString(19) + "^"
						+ wsResult.getString(20) + "^" + wsResult.getString(21) + "^" + wsResult.getString(22) + "^" + wsResult.getString(23) + "^"
						+ wsResult.getString(24) + "^" + wsResult.getString(25) + "^" + wsResult.getString(26) + "^" + wsResult.getString(27) + "^"
						+ wsResult.getString(28) + "^" + wsResult.getString(29) + "^" + wsResult.getString(30) + "^" + wsResult.getString(31) 
						+ "^" + wsResult.getString(32)+ "^" + wsResult.getString(33)+"^"+wsResult.getString(34)+"^"+wsResult.getString(35)+"^"+wsResult.getString(36)+"^"+wsResult.getString(37)+"^"+wsResult.getString(38)
						+"^"+wsResult.getString(39)+"^"+wsResult.getString(40)+"^"+wsResult.getString(41));
				
				 //System.out.println(" resuklt set ----->"+vo.getStrPOHiddenValue());
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception _Err) {
			_Err.printStackTrace();
			vo.setStrMsgString("SupplierDeskInterfaceTransDAO.getPODetails() --> " + _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}	
	

	/**
	 * Gets the PO item list for modify.
	 * 
	 * @param vo the _po desk generate trans vo
	 * @return the PO item list for modify
	 */
	public static void getPOItemName(SupplierDeskInterfaceTransVO vo) 
	{
		
		
		

		String strproc_name = "{call pkg_mms_view.proc_item_list_for_po(?,?,?,?,?,?,?,?,?,?,?)}"; // 11
																								// Variables
		HisUtil util = null;
		HisDAO dao = null;
		

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet wsResult = null;
		try {
			
			dao = new HisDAO("MMS", "transactions.SupplierDeskInterfaceTransDAO.getPOItemList()");
			util = new HisUtil("MMS", "transactions.SupplierDeskInterfaceTransDAO.setPurchaseSourceValues()");

			nProcIndex = dao.setProcedure(strproc_name);
 
			
			dao.setProcInValue(nProcIndex, "modeval", "2");
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nProcIndex, "catCode", vo.getStrPONo());
			dao.setProcInValue(nProcIndex, "po_store_id", vo.getStrStoreId());
			dao.setProcInValue(nProcIndex, "startDate", vo.getStrFinancialStartDate());
			dao.setProcInValue(nProcIndex, "endDate", vo.getStrFinancialToDate());
			dao.setProcInValue(nProcIndex, "suppId", vo.getStrSupplierId());
			dao.setProcInValue(nProcIndex, "poRefDate", vo.getStrPORefrenceDate()==null ? "0" :vo.getStrPORefrenceDate());
			dao.setProcInValue(nProcIndex, "drugbrandid", vo.getStrItemBrandIds());
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);

			dao.executeProcedure(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) 
			{
				if(wsResult.size()>0)
				{
					if(wsResult.next())
					{
						vo.setStrItemBrandIds(wsResult.getString(1));
						vo.setStrPOItemCmb(wsResult.getString(2));
					}
					wsResult.beforeFirst();
					//String strVal="<option value='10100009@10000009@1012124@99@630002^1^0@1@99.1@15@0^0@99 ml/Amp@Test Drug@Lakhani Healthcare@No.' selected='' title='Tes Drug'>Test Item [2.3]</option>";
					vo.setStrPOItemCmb(util.getOptionValue(wsResult, "","", false));
					
				}
			
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} catch (Exception _Err) {
			_Err.printStackTrace();
			vo.setStrMsgString("SupplierDeskInterfaceTransDAO.getPOItemName() --> " + _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			
			wsResult = null;
		}
	}
	
	/**
	 * Sets the purchase source values.
	 * 
	 * @param vo the new purchase source values
	 */
	public static void setPurchaseSourceValues(SupplierDeskInterfaceTransVO vo) {

		String strproc_name = "{call pkg_mms_view.Proc_sstt_purchase_source_mst(?,?,?,?)}";

		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS", "transactions.SupplierDeskInterfaceTransDAO.setPurchaseSourceValues()");
			dao = new HisDAO("MMS", "transactions.SupplierDeskInterfaceTransDAO.setPurchaseSourceValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1");
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);
			dao.executeProcedure(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) 
			{
				
			   if(vo.getStrViewMode().equals("3")||vo.getStrViewMode().equals("2"))	
			   {
				  if(wsResult.size()>0)
				  {
					  if(wsResult.next())
					  {
						  vo.setStrPurchaseSourceValues(wsResult.getString(2));
					  }
					  wsResult.beforeFirst();
				  }
			   }
			   else
			   {
				  vo.setStrPurchaseSourceValues(util.getOptionValue(wsResult, vo.getStrPurchaseSourceId(),"0^Select Value", false));
			   }	
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} catch (Exception _Err) {
			vo.setStrMsgString("SupplierDeskInterfaceTransDAO.setPurchaseSourceValues() --> " + _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}
	
	
	/**
	 * Item name list.
	 * 
	 * @param vo the vo
	 */
	public static void getCommonProcedure(SupplierDeskInterfaceTransVO vo) 
	{
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		HisUtil util = null;
		String strBarCodeString="0",batch="",cartonSize="",boxId="", quantity="",expDate= "",gtinNo="";
		
		//String strBarCodeString="0",batch="",cartonSize="",boxId="";
		
		try 
		{
			/*
			 * Mode-->1=Consignee Name
			 * Mode-->2=Schedule No
			 * Mode-->3=Drug Name
			 * Mode-->4=Batch Combo
			 * 
			 * */
			dao = new HisDAO("mms", "SupplierDeskInterfaceTransDAO");
			util = new HisUtil("MMS", "transactions.SupplierDeskInterfaceTransDAO.getDeliveryDrugNameList()");
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_interface_dtl(?,?,?,?,?,?,?,?,?)}"; // 9
		
			
			if(vo.getStrMode().equals("9"))
		
			{	
				//System.out.println("<---------For Bar Code--------->");
			//System.out.println("modeval---->"+vo.getStrMode());
			//System.out.println("getStrPONo---->"+vo.getStrPONo());
			//System.out.println("getStrPOStoreId---->"+vo.getStrPOStoreId());
			//System.out.println("getStrHospitalCode---->"+vo.getStrHospitalCode());
			//System.out.println("getStrDeliveryStoreId---->"+vo.getStrDeliveryStoreId());
			//System.out.println("getStrScheduleNo---->"+vo.getStrScheduleNo());
			//System.out.println("getStrDrugBrandId---->"+vo.getStrDrugBrandId());
			}
			else
			{
//				//System.out.println("modeval---->"+vo.getStrMode());
//				//System.out.println("getStrPONo---->"+vo.getStrPONo());
//				//System.out.println("getStrPOStoreId---->"+vo.getStrPOStoreId());
//				//System.out.println("getStrHospitalCode---->"+vo.getStrHospitalCode());
//				//System.out.println("getStrDeliveryStoreId---->"+vo.getStrDeliveryStoreId());
//				//System.out.println("getStrScheduleNo---->"+vo.getStrScheduleNo());
//				//System.out.println("getStrDrugBrandId---->"+vo.getStrDrugBrandId());
			}
			
			nprocIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nprocIndex, "modeval",     vo.getStrMode());
			dao.setProcInValue(nprocIndex, "po_no",       vo.getStrPONo());
			dao.setProcInValue(nprocIndex, "po_storeid",  vo.getStrPOStoreId());
			dao.setProcInValue(nprocIndex, "hosp_code",   vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "delstoreid",  vo.getStrDeliveryStoreId());
			dao.setProcInValue(nprocIndex, "schNo",       vo.getStrScheduleNo());
			dao.setProcInValue(nprocIndex, "itemBrandId", vo.getStrDrugBrandId());
			dao.setProcOutValue(nprocIndex, "err",        1);
			dao.setProcOutValue(nprocIndex, "resultset",  2);
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null) {
				strerr = "";
			}

			if (strerr.equals("")) 
			{

				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
				if (wb.size()>0) 
				{
					if(vo.getStrMode().equals("1"))
					{						
						vo.setStrConsigneeStoreCombo(util.getOptionValue(wb,"0","0^Select Value", false));
					}	
					if(vo.getStrMode().equals("2")||vo.getStrMode().equals("10")||vo.getStrMode().equals("11"))
					{						
						vo.setStrSchedule(util.getOptionValue(wb,"0","0^Select Value", false));
					}
					if(vo.getStrMode().equals("3")||vo.getStrMode().equals("14")||vo.getStrMode().equals("15"))
					{						
						vo.setStrDrugNameCombo(util.getOptionValue(wb,"0","0^Select Value", false));
					}
					if(vo.getStrMode().equals("4"))
					{						
						vo.setStrBatchCombo(util.getOptionValue(wb,"0","0^Select Value", false)+"<option value='1'>New Batch</option>");
					}
					if(vo.getStrMode().equals("5")||vo.getStrMode().equals("6")||vo.getStrMode().equals("7")||vo.getStrMode().equals("12")||vo.getStrMode().equals("13"))
					{						
						vo.setWsItemList(wb);
					}
					if(vo.getStrMode().equals("8"))
					{
						if(wb.size()>0)
						{
							if(wb.next())
							{
								vo.setStrItemBrandIds(wb.getString(1));
								vo.setStrPOItemCmb(wb.getString(2));
							}
							wb.beforeFirst();
							//String strVal="<option value='10100009@10000009@1012124@99@630002^1^0@1@99.1@15@0^0@99 ml/Amp@Test Drug@Lakhani Healthcare@No.' selected='' title='Tes Drug'>Test Item [2.3]</option>";
							vo.setStrPOItemCmb(util.getOptionValue(wb, "","", false));
							
						}
					}
					
					
					if(vo.getStrMode().equals("7"))
					{
						if(wb.size()>0)
						{
							if(wb.next())
							{
								vo.setStrQrStoreId(wb.getString(15));
								vo.setStrQrItemId(wb.getString(17));
								vo.setStrQrSupplierId(wb.getString(18));
								vo.setStrQrPono(wb.getString(14));
								vo.setStrSchno(wb.getString(16));
								vo.setStrDelno(wb.getString(19));
								
							}
							wb.beforeFirst();							
						}
					}
					if(vo.getStrMode().equals("9"))
					{
						int i=1;
						if(wb.size()>0)
						{	
							while (wb.next()) 
							{
				                  if(i==1)
				                  {
				                	  
				                	 batch = wb.getString(1);
				                	  cartonSize = wb.getString(2);
				                	  boxId = wb.getString(3);
				                	  
				                	  
				                	 /* batch = wb.getString(1);
				                	  cartonSize = wb.getString(2);
				                	  boxId = wb.getString(3);
				                	 gtinNo = wb.getString(4);
				                	  expDate = wb.getString(5);
				                	  quantity = wb.getString(6);*/
				                  }
				                  else
				                  {
				                	  
				                	  batch = batch +","+wb.getString(1);
				                	  cartonSize = cartonSize +","+wb.getString(2);
				                	  boxId = boxId +","+wb.getString(3);
				                	/*  gtinNo = gtinNo +","+wb.getString(4);
				                	  expDate = expDate +","+wb.getString(5);
				                	  quantity = quantity +","+wb.getString(6);*/
				                	  
				                  }
				                  i++;
							}
							//strBarCodeString = batch+"#"+cartonSize+"#"+boxId+"#"+gtinNo+"#"+expDate+"#"+quantity;
							
							strBarCodeString = batch+"#"+cartonSize+"#"+boxId;
						}
						
						
						vo.setStrBarCodeString(strBarCodeString);
					}
				}
				else
				{
					vo.setStrConsigneeStoreCombo("<option value='0'>Select Value</option>");
					vo.setStrSchedule("<option value='0'>Select Value</option>");
					vo.setStrDrugNameCombo("<option value='0'>Select Value</option>");
					if(vo.getStrMode().equals("4"))
					{
					   vo.setStrBatchCombo("<option value='1'>New Batch</option>");
					}
				}
				
				
			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("SupplierDeskInterfaceTransDAO.getDeliveryDrugNameList() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	/**
	 * Gets the manufacturer list.
	 * 
	 * @param vo the vo
	 * @return the manufacturer list
	 */
	public static void getManufacturerList(SupplierDeskInterfaceTransVO vo) {
		String strproc_name = "{call pkg_mms_view.proc_supplier_list(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS", "transactions.SupplierDeskInterfaceTransDAO.setManufacturerValues()");
			dao = new HisDAO("MMS", "transactions.SupplierDeskInterfaceTransDAO.setManufacturerValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "15");
			dao.setProcInValue(nProcIndex, "catCode", "10");
			dao.setProcInValue(nProcIndex, "branditem_id", "0");
			dao.setProcInValue(nProcIndex, "contractType", vo.getStrStoreId());
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());			
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);
			dao.executeProcedure(nProcIndex);
			 ////System.out.println("Supplier Id():::"+vo.getStrSupplierId());
			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");
			String str = "";
			if (strErr.equals("")) {
				if (wsResult != null && wsResult.size() != 0) {
					str = util.getOptionValue(wsResult, vo.getStrSupplierId(), "", true);
					vo.setStrManufacturerValues(str);
				} else {
					str = "<option value='0'>Select Value</option>";
					vo.setStrManufacturerValues(str);
				}

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception _Err) {
			_Err.printStackTrace();
			vo.setStrMsgString("PODeskGenerateTransDAO.getManufacturerList() --> " + _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}
	
	public static void getConsigneeStoreLIst(SupplierDeskInterfaceTransVO vo)
	{
		
		String strproc_name = "{call PKG_MMS_VIEW.Proc_Schedule_Dtl_new(?,?,?,?,?,?,?,?)}";
		int nprocIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO dao=null;
		try
		{
			dao  = new HisDAO("MMSModule","SupplierDeskInterfaceTransDAO");
						
			nprocIndex = dao.setProcedure(strproc_name);
			
			dao.setProcInValue(nprocIndex, "modeval", "2");
			dao.setProcInValue(nprocIndex, "po_no", vo.getStrPONo());
			dao.setProcInValue(nprocIndex, "po_storeId", vo.getStrPOStoreId());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "delStoreId", vo.getStrStoreId());

			////System.out.println("Del getStrPoNo=>"+vo.getStrPONo());
			////System.out.println("Del getStrPOStoreId=>"+vo.getStrPOStoreId());			
			
			dao.setProcInValue(nprocIndex, "recDate", "NA");
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			
			strErr = dao.getString(nprocIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = dao.getWebRowSet(nprocIndex, "resultset");
			////System.out.println("size of store ws"+ws.size());
			if(strErr.equals(""))
			{
				vo.setWsStoreList(ws);
			}
		}
		catch(Exception _err)
		{
			_err.printStackTrace();
			vo.setStrMsgString("SupplierDeskInterfaceTransDAO.setRecievedByCombo() --> "
					+ _err.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	
	
	/**
	 * This function is used to set details in approved By Combo.
	 * 
	 * @param vo the _ po desk generate trans vo
	 * @return the approved by combo
	 */
	public static void getApprovedByCombo(SupplierDeskInterfaceTransVO vo) {

		String strProcName = "{call PKG_MMS_VIEW.proc_store_emp_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		WebRowSet ws = null;
		HisDAO daoObj = null;
		try {
			daoObj = new HisDAO("MMSModule", "SupplierDeskInterfaceTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			// Set Value
			daoObj.setProcInValue(nProcIndex, "modeVal", "1");
			daoObj.setProcInValue(nProcIndex, "storeId", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			// Execute Procedure
			daoObj.executeProcedure(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null) {
				strErr = "";
			}
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setWbApprovedBy(ws);
			}
		} catch (Exception _err) {
			vo.setStrMsgString("SupplierDeskInterfaceTransDAO.getApprovedByCombo() --> " + _err.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	/**
	 * To get the item category values.
	 * 
	 * @param vo the _po desk generate trans vo
	 * @return the PO prefix cmb
	 */
	public static void getPOPrefixCmb(SupplierDeskInterfaceTransVO vo) {
		String strproc_name = "{call pkg_mms_view.proc_POPrefix_list(?,?,?,?)}";
		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS", "transactions.SupplierDeskInterfaceTransDAO.setPOPrefixCmb()");
			dao = new HisDAO("MMS", "transactions.SupplierDeskInterfaceTransDAO.getPOPrefixCmb()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1");
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);
			dao.executeProcedure(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				vo.setStrPoRefrenceNoCmb(util.getOptionValue(wsResult, vo.getStrPoRefrenceNo(),
						"0^Select Value", false));
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception _Err) {
			vo.setStrMsgString("SupplierDeskInterfaceTransDAO.setPOPrefixCmb() --> " + _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}
	
	/**
	 * Gets the financial year combo from db.
	 * 
	 * @param vo the vo
	 * @return the financial year combo from db
	 */
	public static void getFinancialYearComboFromDB(SupplierDeskInterfaceTransVO vo) {
		int nProcIndex = 0;
		HisDAO daoObj = null;
		String strErr = "";
		WebRowSet wb = null;
		HisUtil util = null;
		try {
			util = new HisUtil("MMS", "transactions.SupplierDeskInterfaceTransDAO.setItemCatValues()");
			String strProcName = "{call PKG_MMS_VIEW.proc_financial_year_list(?,?,?,?,?)}";

			daoObj = new HisDAO("MMS Transactions", "IndentViewTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "demandStrId", vo.getStrStoreId());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null) {
				strErr = "";
			}

			if (strErr.equals("")) {
				wb = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				vo.setStrFinancialYearCombo(util.getOptionValue(wb, "", "", false));

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			vo.setStrMsgString("--> SupplierDeskInterfaceTransDAO.getFinancialYearComboFromDB()-->" + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
			}
			daoObj = null;
		}

	}
	
	/**
	 * To get the PO Type values.
	 * 
	 * @param vo the new PO type values
	 */
	public static void setPOTypeValues(SupplierDeskInterfaceTransVO vo) {
		String strproc_name = "{call pkg_mms_view.Proc_Sstt_indenttype_Dtl(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS", "transactions.SupplierDeskInterfaceTransDAO.setItemCatValues()");
			dao = new HisDAO("MMS", "transactions.SupplierDeskInterfaceTransDAO.setItemCatValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "2");
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nProcIndex, "req_for", "2");
			dao.setProcInValue(nProcIndex, "item_cat", vo.getStrItemCat());
			dao.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId());
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);
			dao.executeProcedure(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				vo.setStrPOTypeValues(util.getOptionValue(wsResult, "", "", false));
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception _Err) {
			vo.setStrMsgString("SupplierDeskInterfaceTransDAO.setPOTypeValues() --> " + _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}

	
	
	/**
	 * Gets the PO no.
	 * 
	 * @param vo the _po desk generate trans vo
	 * @return the PO no
	 */
	public static String getStoreDWH_TYPE_ID(SupplierDeskInterfaceTransVO vo) 
	{
		String strProcName = "{? = call MMS_MST.get_store_type_flg(?,?)}";
		HisDAO dao = null;

		int funcIndex = 0;
		String strPONo = "";

		try {
			dao = new HisDAO("MMS", "transactions.SupplierDeskInterfaceTransDAO.getStoreDWH_TYPE_ID()");

			funcIndex = dao.setFunction(strProcName);

			dao.setFuncInValue(funcIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3, vo.getStrStoreId());			
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			strPONo = dao.getFuncString(funcIndex);
			vo.setStrDwhTypeId(strPONo);

		} catch (Exception _Err) {
			_Err.printStackTrace();
			vo.setStrMsgString("SupplierDeskInterfaceTransDAO.getStoreDWH_TYPE_ID() --> " + _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
		return strPONo;
	}
	
	/**
	 * Gets the schedule delivery date.
	 * 
	 * @param vo the _po desk generate trans vo
	 * @return the schedule delivery date
	 */
	public static void getScheduleDeliveryDate(SupplierDeskInterfaceTransVO vo) {
		String strproc_name = "{call PKG_MMS_VIEW.proc_PO_Schedule_DateList(?,?,?,?,?,?,?,?,?)}"; // Total  9 Variables
		HisDAO dao = null;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet wsResult = null;
		try {
			dao = new HisDAO("MMS", "transactions.SupplierDeskInterfaceTransDAO.getProgrammeDetails()");
			nProcIndex = dao.setProcedure(strproc_name);
			new HisUtil("DWH Transaction", "SupplierDeskInterfaceTransDATA");

			// //System.out.println("store_id=>"+vo.getStrDeliveryLocationValues());
			// //System.out.println("brandId=>"+vo.getStrItemBrandIds());
			// //System.out.println("getStrIndentPeriodValue=>"+vo.getStrIndentPeriodValue());
			// //System.out.println("getStrPONo=>"+vo.getStrPONo());
			// //System.out.println("poStoreId=>"+vo.getStrStoreId());
			dao.setProcInValue(nProcIndex, "modeval", "1");
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nProcIndex, "store_id", vo.getStrDeliveryLocationValues()==null || vo.getStrDeliveryLocationValues().equals("") ? "0" :vo.getStrDeliveryLocationValues());
			dao.setProcInValue(nProcIndex, "brandId", vo.getStrItemBrandIds());
			dao.setProcInValue(nProcIndex, "indentPeriod", vo.getStrIndentPeriodValue()==null || vo.getStrIndentPeriodValue().equals("") ? "0" :vo.getStrIndentPeriodValue());
			dao.setProcInValue(nProcIndex, "poNo", vo.getStrPONo());
			dao.setProcInValue(nProcIndex, "poStoreId", vo.getStrStoreId());
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);
			dao.executeProcedure(nProcIndex);
			strErr = dao.getString(nProcIndex, "err");
			if (strErr.equals("")) {
				strErr = null;
			}
			if (strErr == null) {
				strErr = "";
				wsResult = dao.getWebRowSet(nProcIndex, "resultset");
				vo.setWbsProgrammeDtl(wsResult);
			} else {

				throw new Exception(strErr);
			}
			wsResult.size();
			String[] strComponentID = new String[wsResult.size()];
			for (int nTmpI = 0; wsResult.next(); nTmpI++) {
				strComponentID[nTmpI] = wsResult.getString(1);
				if (strComponentID[nTmpI].split("\\^")[1].equals("1")) {
					vo.setStrDDeliveryDays(strComponentID[nTmpI].split("\\^")[0]);
				}
				if (strComponentID[nTmpI].split("\\^")[1].equals("2")) {
					vo.setStrDDeliveryDays2(strComponentID[nTmpI].split("\\^")[0]);
				}

				if (strComponentID[nTmpI].split("\\^")[1].equals("3")) {
					vo.setStrDDeliveryDays3(strComponentID[nTmpI].split("\\^")[0]);
				}

				if (strComponentID[nTmpI].split("\\^")[1].equals("4")) {
					vo.setStrDDeliveryDays4(strComponentID[nTmpI].split("\\^")[0]);
				}
				if (strComponentID[nTmpI].split("\\^")[1].equals("5")) {
					vo.setStrDDeliveryDays5(strComponentID[nTmpI].split("\\^")[0]);
				}
				if (strComponentID[nTmpI].split("\\^")[1].equals("6")) {
					vo.setStrDDeliveryDays6(strComponentID[nTmpI].split("\\^")[0]);
				}
				if (strComponentID[nTmpI].split("\\^")[1].equals("7")) {
					vo.setStrDDeliveryDays7(strComponentID[nTmpI].split("\\^")[0]);
				}
				if (strComponentID[nTmpI].split("\\^")[1].equals("8")) {
					vo.setStrDDeliveryDays8(strComponentID[nTmpI].split("\\^")[0]);
				}

			}

			if (vo.getStrDDeliveryDays() == null || vo.getStrDDeliveryDays().equals("")) {
				vo.setStrDDeliveryDays("0");
			}

			if (vo.getStrDDeliveryDays2() == null || vo.getStrDDeliveryDays2().equals("")) {
				vo.setStrDDeliveryDays2("0");
			}

			if (vo.getStrDDeliveryDays3() == null || vo.getStrDDeliveryDays3().equals("")) {
				vo.setStrDDeliveryDays3("0");
			}

			if (vo.getStrDDeliveryDays4() == null || vo.getStrDDeliveryDays4().equals("")) {
				vo.setStrDDeliveryDays4("0");
			}
			
			if (vo.getStrDDeliveryDays5() == null || vo.getStrDDeliveryDays5().equals("")) {
				vo.setStrDDeliveryDays5("0");
			}
			
			if (vo.getStrDDeliveryDays6() == null || vo.getStrDDeliveryDays6().equals("")) {
				vo.setStrDDeliveryDays6("0");
			}
			
			if (vo.getStrDDeliveryDays7() == null || vo.getStrDDeliveryDays7().equals("")) {
				vo.setStrDDeliveryDays7("0");
			}
			
			if (vo.getStrDDeliveryDays8() == null || vo.getStrDDeliveryDays8().equals("")) {
				vo.setStrDDeliveryDays8("0");
			}

		} catch (Exception _Err) {
			_Err.printStackTrace();
			vo.setStrMsgString("SupplierDeskInterfaceTransDAO.getScheduleProgrammeDetails() --> " + _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}

	
	/**
	 * Gets the schedule total qty.
	 * 
	 * @param vo the _ po desk generate trans vo
	 * @return the schedule total qty
	 */
	public static void getScheduleTotalQty(SupplierDeskInterfaceTransVO vo) {
		String strproc_name = "{call pkg_mms_view.Proc_Po_Details(?,?,?,?,?,?)}"; // 6
		HisDAO dao = null;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS", "transactions.SupplierDeskInterfaceTransDAO.getScheduleTotalQty()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "4");

			// //System.out.println("vo.getStrHospitalCode() = "
			// + vo.getStrHospitalCode());
			// //System.out.println("vo.getStrPONo() = " +
			// vo.getStrPONo());
			// //System.out.println("vo.getStrStoreId() = " +
			// vo.getStrStoreId());

			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nProcIndex, "pono", vo.getStrPONo());
			dao.setProcInValue(nProcIndex, "storeId", vo.getStrStoreId());
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);
			dao.executeProcedure(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				wsResult.next();
				vo.setStrSchedule(wsResult.getString(1));
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception _Err) {
			vo.setStrMsgString("SupplierDeskInterfaceTransDAO.getScheduleTotalQty() --> " + _Err.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}
	
	
	/**
	 * Sets the unit values.
	 * 
	 * @param vo the new unit values
	 */
	public static void setUnitValues(SupplierDeskInterfaceTransVO vo) {
		String strProcName = "";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;
		HisUtil util = null;

		try {

			daoObj = new HisDAO("PO Register", "PO Register DAO");
			util = new HisUtil("MMS", "transactions.SupplierDeskInterfaceTransDAO.setUnitValues()");

			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "unit_id", vo.getStrItemId()==null || vo.getStrItemId().equals("") ? "6301" : vo.getStrItemId());
			daoObj.setProcInValue(nProcIndex, "module_id", "0");
			daoObj.setProcInValue(nProcIndex, "modeval", "5");			 
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null) {
				strErr = "";
			}
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				vo.setStrRateUnitValues(util.getOptionValue(ws, "6301", "0^Select", false, false));
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("SampleSentTrans.setUnitValues() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void getCartonSizeList(SupplierDeskInterfaceTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "ReceiveFromThirdPartyTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_carton_size_dtl(?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
            
			dao.setProcInValue(nprocIndex, "modeval",    "1");
			dao.setProcInValue(nprocIndex, "hosp_code",  vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "item_id",    vo.getStrDrugBrandId());
			dao.setProcOutValue(nprocIndex, "err",       1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null) {
				strerr = "";
			}

			wb = dao.getWebRowSet(nprocIndex, "resultset");
           
			if (strerr.equals("")) 
			{
				vo.setCartonSizeWs(wb);

			} 
			else 
			{
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("ReceiveFromThirdPartyTransDAO.getCartonSizeList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}




	/**
	 * This Method is Used to Get Indent Item List from.
	 * 
	 * @param vo the vo
	 */
	public static void getStoreListForViewPrint(SupplierDeskInterfaceTransVO vo) {
		String err = "";
		String strProcName = "{call PKG_MMS_VIEW.PROC_PO_PROGRAMME_LIST(?,?,?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		try {
			dao = new HisDAO("mms", "SupplierDeskInterfaceTransDAO.GetSoreNameCombo(SupplierDeskInterfaceTransVO vo)");
			procIndex1 = dao.setProcedure(strProcName);
			// set value
//			//System.out.println("vo.getStrHospitalCode()--2-->"+vo.getStrHospitalCode());
//			//System.out.println("brandid---->"+vo.getStrItemBrandIds().split("\\@")[0]);
//			//System.out.println("indentperiod---->"+vo.getStrPOHiddenValue().split("\\^")[20]);
//			//System.out.println("vo.getStrPONo()---->"+vo.getStrPONo());
//			//System.out.println("vo.getStrStoreId()---->"+vo.getStrStoreId());
			
			
			dao.setProcInValue(procIndex1, "modeval", "2");
			dao.setProcInValue(procIndex1, "hosp_code",    vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "store_id",     "0");
			dao.setProcInValue(procIndex1, "brandid",      vo.getStrItemBrandIds().split("\\@")[0]);
			dao.setProcInValue(procIndex1, "indentperiod", vo.getStrPOHiddenValue().split("\\^")[20]);
			dao.setProcInValue(procIndex1, "pono",         vo.getStrPONo()); // As DW_TYPE
			dao.setProcInValue(procIndex1, "postoreid",    vo.getStrStoreId());
			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object
			// execute procedure
			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null) {
				err = "";
			}

			ws = dao.getWebRowSet(procIndex1, "resultset");
			
			vo.setStrHeaderWS(ws);

		} catch (Exception e) {
			vo.setStrMsgString("SupplierDeskInterfaceTransDAO.GetStoreListForViewPrint() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}

	/**
	 * This Method is Used to Get Indent Item List from.
	 * 
	 * @param vo the vo
	 */
	public static void GetVitalDrugDtlPrint(SupplierDeskInterfaceTransVO vo) 
	{
		String err = "";
		String strProcName = "{call PKG_MMS_VIEW.PROC_PO_PROGRAMME_LIST(?,?,?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		try {

			dao = new HisDAO("mms", "SupplierDeskInterfaceTransDAO.GetSoreNameCombo(SupplierDeskInterfaceTransVO vo)");

			procIndex1 = dao.setProcedure(strProcName);
//			//System.out.println("vo.getStrHospitalCode()--3-->"+vo.getStrHospitalCode());
//			//System.out.println("brandid---->"+vo.getStrItemBrandIds().split("\\@")[0]);
//			//System.out.println("indentperiod---->"+vo.getStrPOHiddenValue().split("\\^")[20]);
//			//System.out.println("vo.getStrPONo()---->"+vo.getStrPONo());
//			//System.out.println("vo.getStrStoreId()---->"+vo.getStrStoreId());
			
			dao.setProcInValue(procIndex1, "modeval",      "3");
			dao.setProcInValue(procIndex1, "hosp_code",    vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "store_id",     "0");
			dao.setProcInValue(procIndex1, "brandid",      vo.getStrItemBrandIds().split("\\@")[0]);
			dao.setProcInValue(procIndex1, "indentperiod", vo.getStrPOHiddenValue().split("\\^")[20]);
			dao.setProcInValue(procIndex1, "pono",         vo.getStrPONo()); // As DW_TYPE
			dao.setProcInValue(procIndex1, "postoreid",    vo.getStrStoreId());
			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object
			// execute procedure
			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null) {
				err = "";
			}

			ws = dao.getWebRowSet(procIndex1, "resultset");
			////System.out.println("Size in DATA=>"+ws.size());
			vo.setStrDrugListWS(ws);

		} catch (Exception e) {
			vo.setStrMsgString("SupplierDeskInterfaceTransDAO.GetVitalDrugDtlPrint() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	/**
	 * Delivery mode list.
	 * 
	 * @param vo the vo
	 */
	public static void deliveryModeList(SupplierDeskInterfaceTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		HisUtil util = null;
		try {
			util = new HisUtil("MMS", "transactions.SupplierDeskInterfaceTransDAO.getDeliveryDrugNameList()");
			dao = new HisDAO("mms", "SupplierDeskInterfaceTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_deliverymode_dtl(?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null) {
				strerr = "";
			}

			if (strerr.equals("")) 
			{

				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
				vo.setStrDeliveryMode(util.getOptionValue(wb,"","", false));
				

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			vo.setStrMsgString("SupplierDeskInterfaceTransDAO.deliveryModeList() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	/**
	 * Gets the unit name combo.
	 * 
	 * @param vo the vo
	 * 
	 * @return the unit name combo
	 */
	public static void getUnitNameCombo(SupplierDeskInterfaceTransVO vo) 
	{
		String strFuncName = "";
		String strProcName = "";

		int nFuncIndex = 0;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;
		String strUnitRate = "";

		try {

			daoObj = new HisDAO("Mms Global", "MmsDAO");
			strFuncName = "{? = call Mms_Mst.get_inventory_unitId(?, ?, ?, ? )}"; // 5
			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}"; // 5+1=6

			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, "2");
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 4, "10");
			daoObj.setFuncInValue(nFuncIndex, 5, vo.getStrItemId());
			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);
			strUnitRate = daoObj.getFuncString(nFuncIndex);
			vo.setStrUnitId(strUnitRate);
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "unit_id", vo.getStrUnitId().split("\\^")[0]);
			daoObj.setProcInValue(nProcIndex, "module_id", "0");
			daoObj.setProcInValue(nProcIndex, "modeval", "1"); // Orignal Value
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null) {
				strErr = "";
			}
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {

				vo.setWsUnitList(ws);

			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("SupplierDeskInterfaceTrans.unitNameCombo() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	/**
	 * getRejectedBatchDtl
	 * 
	 * @param vo
	 */
	public static void getRejectedBatchDtl(SupplierDeskInterfaceTransVO vo) 
	{

		HisDAO dao = null;
		int funcIndex = 0;
		String strTemp="";		
		try 
		{
			dao = new HisDAO("mms", "SupplierDeskInterfaceTransDAO");
			funcIndex = dao.setFunction("{? = call MMS_MST.get_rejected_batch_dtl(?,?,?,?)}");		      
			// Set Value			
			
			dao.setFuncInValue(funcIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3, vo.getStrDrugBrandId());
			dao.setFuncInValue(funcIndex, 4, vo.getStrPONo());
			dao.setFuncInValue(funcIndex, 5, vo.getStrPOStoreId());
			dao.setFuncOutValue(funcIndex, 1);
			// Execute Function
			dao.executeFunction(funcIndex);
			strTemp = dao.getFuncString(funcIndex);
			if(strTemp!=null && !strTemp.equals(""))
			{				
				
				vo.setStrRejectedBatchList(strTemp);
			}
			else
			{
				vo.setStrRejectedBatchList("-");
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("SupplierDeskInterfaceTransDAO.deliveryModeList() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	
	
	public static void getprevInvoiceNo(SupplierDeskInterfaceTransVO vo) 
	
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";
		String strBrandName = "";
		String strItemName = "";
		StringBuffer htmlVal = new StringBuffer("");
		String strPaymentMode ="";
		try {
			daoObj = new HisDAO("mms", "SupplierDeskInterfaceTransDAO");
			strProcName = "{call PKG_MMS_VIEW.Proc_Po_Details(?,?,?,?,?,?)}";		
			
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "8");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "pono",vo.getStrPONo());
			daoObj.setProcInValue(nProcIndex, "storeId", vo.getStrDeliveryStoreId());			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			daoObj.executeProcedure(nProcIndex);
			

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {
				
				while (ws.next()) {
					
					vo.setStrPreInvoiceNo(ws.getString(1));
				}



			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();

			vo.setStrMsgString("SupplierDeskInterfaceTransDAO.viewDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	
	
	
		
	
	/**
	 * Insert freeze challan.
	 * 
	 * @param vo the vo
	 */
	public synchronized static void insertAcceptance(SupplierDeskInterfaceTransVO vo) {

		HisDAO dao = null;

		// String strFuncName = "";
		// String strChallanNo = "";
		// String strReqTypeId = "68";
		String strProcName = "";
		int nProcIndex = 0;
		try 
		{
			dao = new HisDAO("MMS", "SupplierDeskInterfaceTransDAO");

			/** ******************************************************************************* */
			//   (0) PO_DATE ^ (1)SUPP NAME ^ (2)PO TYPE ^ (3)PO NET AMOUNT ^(4) Supplier ID
			// ^ (5) PO Type Id ^(6) Currency Id ^(7)Currency Value ^(8) Item Catg No
			// ^ (9) Catg Name ^ (10)Purchase Source ID ^ (11)Po Number ^ (12)PO Prefix ^(13) Tax
			// ^ (14)Tender Number ^ (15)Tender Date ^ (16)Qutation No ^ (17)Qutation Date ^(18) Verify Date
			// ^ (19)Verify BY ^ (20) Financial Period(2013-2014) ^ (21) Next PO Date ^ (22) Purchase Commite date 
			// ^ (23)Negotiation Meeting Date ^ (24)Remarks ^ (25) Verified By Name ^(26)Verify Date ^ (27) Total Amendment 
			// ^ (28)Rate Contracted Flg ^(29)PO Type Authantication ID^(30) POREF NO 
			// ^ (31)PO Prefix ^ (32) Store Name{PO Creater} ^ (33) Purchae Source Name ^ (34) Rate Contract Id
	       /** ******************************************************************************* */
			//13-Dec-2013^Ciron Drugs And Pharmaceuticals Pvt Ltd^Central Purchase (Repeat)^252450^1010002^22^100^1^10
			//^Drug^12^10221300026^343/C-7/E-26/PHENYTOIN TAB/REPEAT ORDER /2013-14/2013/1^null^E 26^04-Jul-2013^-^ ^
			//18-Dec-2013^MPHD1000002465^2013-2014^null^24-Oct-2013^null^NA^Mumbai- Ho  ^18-Dec-2013^0^1^3^NA^Mumbai-HO^Direct Purchase
			
			/*********************************************** 1 ******************************************************/

			strProcName = "{call PKG_MMS_DML.dml_supp_interface_accept_dtl(?,?,?,?,?,?,?,?)}"; // 8
			nProcIndex = dao.setProcedure(strProcName);
			// int len = vo.getStrHiddenVerifiedChallanValue().length;
			
			 /*
	        Used in Supplier Interface (Acceptance) 

	        acceptanceFlag = 1 >> Accepted
	                       = 2 >> Rejected
	    */	   						
				dao.setProcInValue(nProcIndex, "modval", "1");
				dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
				dao.setProcInValue(nProcIndex, "poStrId", vo.getStrStoreId());
				dao.setProcInValue(nProcIndex, "poNo", vo.getStrPOHiddenValue().split("\\^")[11]);
				dao.setProcInValue(nProcIndex, "acceptanceFlag", vo.getStrApprovalFlag());				
				dao.setProcInValue(nProcIndex, "remarks", vo.getStrRemarks());
				dao.setProcInValue(nProcIndex, "seatId", vo.getStrSeatId());						
				dao.setProcOutValue(nProcIndex, "err", 1); // 12 Variable
//				 //System.out.println("vo.getStrStoreId()-->"+vo.getStrStoreId());
//				 //System.out.println("vo.poNo()-->"+vo.getStrPOHiddenValue().split("\\^")[11]);
//				 //System.out.println("vo.acceptanceFlag()-->"+vo.getStrApprovalFlag());
				

				dao.execute(nProcIndex, 1);
			
			dao.fire();

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("SupplierDeskInterfaceTransDAO.insertAcceptance() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;

			}

		}

	}
	
	/**
	 * Insert freeze challan.
	 * 
	 * @param vo the vo
	 */
	public synchronized static void deleteRecords(SupplierDeskInterfaceTransVO vo) 
	{

		HisDAO dao = null;
		String strProcName = "";
		int nProcIndex = 0;
		try 
		{
				dao = new HisDAO("MMS", "SupplierDeskInterfaceTransDAO");	
			 
				strProcName = "{call PKG_MMS_DML.dml_si_delivery_cancel_dtl(?,?,?,?,?,?,?,?,?,?)}"; // 10
				nProcIndex = dao.setProcedure(strProcName);
			    
			    dao.setProcInValue(nProcIndex, "modval", "1");
				dao.setProcInValue(nProcIndex, "hosp_code", 	vo.getStrHospitalCode());				
				dao.setProcInValue(nProcIndex, "poNo",      	vo.getStrPONo());
				dao.setProcInValue(nProcIndex, "poStrId",   	vo.getStrPOStoreId());				
				dao.setProcInValue(nProcIndex, "schNo",      	vo.getStrScheduleNo());				
				dao.setProcInValue(nProcIndex, "deliveryLocId", vo.getStrDeliveryStoreId());				
				dao.setProcInValue(nProcIndex, "deliveryNo", 	vo.getStrDeliveryNo());				
				dao.setProcInValue(nProcIndex, "remarks", 		vo.getStrDeleteRemarks());
				dao.setProcInValue(nProcIndex, "seatId", 		vo.getStrSeatId());						
				dao.setProcOutValue(nProcIndex, "err", 1); // 12 Variable

				dao.execute(nProcIndex, 1);
			
			    dao.fire();

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("SupplierDeskInterfaceTransDAO.deleteRecords() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;

			}

		}

	}
	
	/**
	 * Insert freeze challan.
	 * 
	 * @param vo the vo
	 */
	public synchronized static void insertDelivery(SupplierDeskInterfaceTransVO vo) 
	{
		HisDAO dao = null;
		String strProcName = "",strProcName3="";
		int nProcIndex = 0,counter=1,nProcIndex3=0;
		String strFuncName ="";
		boolean flag = false;
		try 
		{
			dao = new HisDAO("MMS", "SupplierDeskInterfaceTransDAO");
			
		
			strFuncName = "{? = call mms_mst.gen_si_deliveryNo(?,?,?,?)}";
			int nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrDeliveryStoreId());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrScheduleNo());
			dao.setFuncInValue(nFuncIndex, 5, vo.getStrPOHiddenValue().split("\\^")[11]);
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			
			vo.setStrDeliveryNo(dao.getFuncString(nFuncIndex));

			/** ******************************************************************************* */
			//   (0) PO_DATE ^ (1)SUPP NAME ^ (2)PO TYPE ^ (3)PO NET AMOUNT ^(4) Supplier ID
			// ^ (5) PO Type Id ^(6) Currency Id ^(7)Currency Value ^(8) Item Catg No
			// ^ (9) Catg Name ^ (10)Purchase Source ID ^ (11)Po Number ^ (12)PO Prefix ^(13) Tax
			// ^ (14)Tender Number ^ (15)Tender Date ^ (16)Qutation No ^ (17)Qutation Date ^(18) Verify Date
			// ^ (19)Verify BY ^ (20) Financial Period(2013-2014) ^ (21) Next PO Date ^ (22) Purchase Commite date 
			// ^ (23)Negotiation Meeting Date ^ (24)Remarks ^ (25) Verified By Name ^(26)Verify Date ^ (27) Total Amendment 
			// ^ (28)Rate Contracted Flg ^(29)PO Type Authantication ID^(30) POREF NO 
			// ^ (31)PO Prefix ^ (32) Store Name{PO Creater} ^ (33) Purchae Source Name ^ (34) Rate Contract Id
	       /** ******************************************************************************* */
			//13-Dec-2013^Ciron Drugs And Pharmaceuticals Pvt Ltd^Central Purchase (Repeat)^252450^1010002^22^100^1^10
			//^Drug^12^10221300026^343/C-7/E-26/PHENYTOIN TAB/REPEAT ORDER /2013-14/2013/1^null^E 26^04-Jul-2013^-^ ^
			//18-Dec-2013^MPHD1000002465^2013-2014^null^24-Oct-2013^null^NA^Mumbai- Ho  ^18-Dec-2013^0^1^3^NA^Mumbai-HO^Direct Purchase
			
			
			/*********************************************** 1 ******************************************************/
			//System.out.println("vo.getStrHiddenValue()------->"+vo.getStrHiddenValue());
	
			for(int i=0;i<vo.getStrHiddenValue().length;i++)
			{	
//				//System.out.println("<----------------"+i+"--------------->");
//				//System.out.println("Delivery No-->"+vo.getStrDeliveryNo());
//				//System.out.println("hosp_code-->"+vo.getStrHospitalCode());
//				//System.out.println("poNo-->"+vo.getStrPOHiddenValue().split("\\^")[11]);
//				//System.out.println("poStrId-->"+vo.getStrPOStoreId());
//				//System.out.println("getStrScheduleNo-->"+vo.getStrScheduleNo());					
//				//System.out.println("getStrDeliveryStoreId-->"+vo.getStrDeliveryStoreId());
//				//System.out.println("getStrSupplierReceiptNo--->"+vo.getStrSupplierReceiptNo());
//				//System.out.println("getStrSupplierInvoiceNo--->"+vo.getStrSupplierInvoiceNo());
//				//System.out.println("getStrFSId--->"+vo.getStrFSId());
//				//System.out.println("getStrPrgId--->"+vo.getStrPrgId());
//				//System.out.println("File Name--->"+vo.getStrFileName());
				
				
//				//System.out.println("getStrSupplierReceiptNo-->"+vo.getStrSupplierReceiptNo());
//				//System.out.println("getStrSupplierReceiptDate-->"+vo.getStrSupplierReceiptDate());
//				//System.out.println("getStrDeliveryMode-->"+vo.getStrDeliveryMode());
//				//System.out.println("getStrTransporterName-->"+vo.getStrTransporterName());					
//				//System.out.println("getStrLorryNo-->"+vo.getStrLorryNo());				
//				//10000009^10100009^Lakhani Healthcare^ASAS^01-Apr-2015^31-May-2016^630001^1^0^10^10^4
//				//System.out.println("Hidden Value--->"+vo.getStrHiddenValue()[i]);
//				//System.out.println("itemBrandId-->"+vo.getStrHiddenValue()[i].split("\\^")[1]);
//				//System.out.println("batchNo-->"+vo.getStrHiddenValue()[i].split("\\^")[3]);
//				//System.out.println("expiryDate-->"+vo.getStrHiddenValue()[i].split("\\^")[5]);
//				//System.out.println("mfgDate-->"+vo.getStrHiddenValue()[i].split("\\^")[4]);
//				//System.out.println("balanceQty-->"+vo.getStrHiddenValue()[i].split("\\^")[9]);
//				//System.out.println("deliverQty-->"+vo.getStrHiddenValue()[i].split("\\^")[10]);
//				//System.out.println("Rece Qty-->"+vo.getStrHiddenValue()[i].split("\\^")[17]);
//				//System.out.println("deliverQty Unit-->"+vo.getStrHiddenValue()[i].split("\\^")[6]);
//				//System.out.println("pktCount-->"+vo.getStrHiddenValue()[i].split("\\^")[11]);
				
				
									
					 /* Hidden Value Contains 
				     *   Item Id ^ Itembrand Id ^ Manufactere Name ^ Batch No ^ Manufactere Date 
				     * ^ Expiry Date ^ Unit Id[630001 ^ 1 ^ 0] ^ Balance Qty ^ Total Received Qty ^ Carton No ^ Carton Size ^ No of Carton ^ Mfg Id ^ Multi Row Receive Qty      
				     * */
					//10000013^10101077^Ciron Drugs And Pharmaceuticals Pvt Ltd^ert^01-Aug-2015^31-Aug-2016^[630001^1.000^0]^500^500^0^[101^1000.00^100]^1 ^ 1060001 ^ 10
					////System.out.println("Prg Id-->"+strTemp[u].split("\\@")[0]);			
					////System.out.println("itemBrandId-->"+vo.getStrHiddenValue()[i].split("\\^")[1]);
//					//System.out.println("Carton No--->"+vo.getStrHiddenValue()[i].split("\\^")[11]);
//					//System.out.println("Carton Id--->"+vo.getStrHiddenValue()[i].split("\\^")[12]);
//					//System.out.println("No of Carton--->"+vo.getStrHiddenValue()[i].split("\\^")[15]);
//					//System.out.println("Manufacter Id--->"+vo.getStrHiddenValue()[i].split("\\^")[16]);
//					//System.out.println("String.valueOf(counter)-Before->"+String.valueOf(counter));
//					//System.out.println("cartonautoflag->"+vo.getStrCartonGene());
									
				
					strProcName = "{call PKG_MMS_DML.dml_si_delivery_dtl(?,?,?,?,?,?,?,?,?,?  ,?,?,?,?,?,?,?,?,?,?  , ?,?,?,?,?,?,?,?,?,?   ,?,?,?,?,?,  ?,?,?,?,?)}"; 
					nProcIndex = dao.setProcedure(strProcName);			
					dao.setProcInValue(nProcIndex, "modval", 			"1");
					dao.setProcInValue(nProcIndex, "hosp_code", 		vo.getStrHospitalCode());				
					dao.setProcInValue(nProcIndex, "poNo", 				vo.getStrPOHiddenValue().split("\\^")[11]);
					dao.setProcInValue(nProcIndex, "poStrId",			vo.getStrPOStoreId());
					dao.setProcInValue(nProcIndex, "schNo", 			vo.getStrScheduleNo());		
					dao.setProcInValue(nProcIndex, "deliveryLocId", 	vo.getStrDeliveryStoreId());	
					dao.setProcInValue(nProcIndex, "deliveryNo", 		vo.getStrDeliveryNo());  // Generated By Function	
					dao.setProcInValue(nProcIndex, "suppRecNo", 		(vo.getStrSupplierReceiptNo() == null || vo.getStrSupplierReceiptNo().equals("")|| vo.getStrSupplierReceiptNo().equals("---")) ? "0" : vo.getStrSupplierReceiptNo());		
					dao.setProcInValue(nProcIndex, "suppRecDate", 		vo.getStrSupplierReceiptDate());	
					dao.setProcInValue(nProcIndex, "deliveryModeDtl", 	"");	
					dao.setProcInValue(nProcIndex, "deliveryModeId", 	vo.getStrDeliveryMode());		
					dao.setProcInValue(nProcIndex, "transporterName", 	vo.getStrTransporterName());	
					dao.setProcInValue(nProcIndex, "lrNo", 				vo.getStrLorryNo());											
					dao.setProcInValue(nProcIndex, "itemBrandId", 		vo.getStrHiddenValue()[i].split("\\^")[1]);	
					dao.setProcInValue(nProcIndex, "batchNo", 			vo.getStrHiddenValue()[i].split("\\^")[3]);	
					dao.setProcInValue(nProcIndex, "prgId", 			vo.getStrPrgId());	
					dao.setProcInValue(nProcIndex, "expiryDate", 		vo.getStrHiddenValue()[i].split("\\^")[5]==null || vo.getStrHiddenValue()[i].split("\\^")[5].equals("") ? " " :vo.getStrHiddenValue()[i].split("\\^")[5]);	
					dao.setProcInValue(nProcIndex, "mfgDate", 			vo.getStrHiddenValue()[i].split("\\^")[4]);	
					dao.setProcInValue(nProcIndex, "balanceQty", 		vo.getStrHiddenValue()[i].split("\\^")[9]);	
					dao.setProcInValue(nProcIndex, "deliverQty", 		vo.getStrHiddenValue()[i].split("\\^")[17]);					
					dao.setProcInValue(nProcIndex, "deliveryQtyUnit", 	vo.getStrHiddenValue()[i].split("\\^")[6]);	
					dao.setProcInValue(nProcIndex, "pktCount", 			vo.getStrHiddenValue()[i].split("\\^")[11]);	
					dao.setProcInValue(nProcIndex, "remarks", 			vo.getStrRemarks());
					dao.setProcInValue(nProcIndex, "firstRecordFlag",	String.valueOf(counter));	
					dao.setProcInValue(nProcIndex, "seatId", 			vo.getStrSeatId());						
					dao.setProcInValue(nProcIndex, "suppInvoiceNo", 	vo.getStrSupplierInvoiceNo());	
					dao.setProcInValue(nProcIndex, "boxId", 			vo.getStrHiddenValue()[i].split("\\^")[11]);	
					dao.setProcInValue(nProcIndex, "cartonSizeId", 		vo.getStrHiddenValue()[i].split("\\^")[12]);	
					dao.setProcInValue(nProcIndex, "fileName", 			vo.getStrFileName());	
					dao.setProcInValue(nProcIndex, "fsId", 			    vo.getStrFSId());					
					dao.setProcInValue(nProcIndex, "cartonautoflag", 	vo.getStrCartonGene());	
					
					//System.out.println("chkvalues"+vo.getStrHiddenValue()[i]);
					dao.setProcInValue(nProcIndex, "noOfCarton", 		vo.getStrHiddenValue()[i].split("\\^")[15]);
					dao.setProcInValue(nProcIndex, "mfgId", 		    vo.getStrHiddenValue()[i].split("\\^")[16]);
					
					dao.setProcInValue(nProcIndex, "driverName", 		vo.getStrDriverName());
					dao.setProcInValue(nProcIndex, "driverMobileNo", 	vo.getStrDriverMobileNo());
					dao.setProcInValue(nProcIndex, "dateOfDelivery", 	vo.getStrDateOfDelivery());
					dao.setProcInValue(nProcIndex, "dateofDispatch", 	vo.getStrDateOfDispatch());
					dao.setProcInValue(nProcIndex, "replacementflag",	vo.getStrReplacementDirectBatchFlag());
					dao.setProcInValue(nProcIndex, "tranchePDIFlag",	vo.getStrPoPreFlag());
					
					
				
										
					dao.setProcOutValue(nProcIndex, "err", 				1); 		
					dao.execute(nProcIndex, 1);
					counter++;
					vo.setStrItemBrandIds(vo.getStrHiddenValue()[i].split("\\^")[1]);
					vo.setStrItemId(vo.getStrHiddenValue()[i].split("\\^")[0]);
				

//				//System.out.println("remarks-->"+vo.getStrRemarks());
//				//System.out.println("String.valueOf(counter)-->"+String.valueOf(counter));					
//				//System.out.println("seatId-->"+vo.getStrSeatId());
//				//System.out.println("<------------------------------->");
				
			}
			
			if(vo.getStrReplacementDirectBatchFlag().equals("1") || vo.getStrReplacementDirectBatchFlag().equals("2"))
			{
		
			strProcName3 = "{call PKG_MMS_DML.dml_challan_prefailed_batch_dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}"; // 22
			nProcIndex3 = dao.setProcedure(strProcName3);
			dao.setProcInValue(nProcIndex3, "modval", "1");
			dao.setProcInValue(nProcIndex3, "store_id", vo.getStrDeliveryStoreId());
			dao.setProcInValue(nProcIndex3, "challanno", "0");//todo
			dao.setProcInValue(nProcIndex3, "item_id", vo.getStrItemId());
			dao.setProcInValue(nProcIndex3, "itembrand_id", vo.getStrItemBrandIds());
			dao.setProcInValue(nProcIndex3, "po_no", vo.getStrPOHiddenValue().split("\\^")[11]);
			dao.setProcInValue(nProcIndex3, "po_store_id", vo.getStrPOStoreId());
			dao.setProcInValue(nProcIndex3, "schNo", vo.getStrScheduleNo());
			dao.setProcInValue(nProcIndex3, "stRecDate", "");//todo
			dao.setProcInValue(nProcIndex3, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nProcIndex3, "seat_id", vo.getStrSeatId());
			dao.setProcInValue(nProcIndex3, "remarks", vo.getStrRemarks());
			dao.setProcInValue(nProcIndex3, "oldBatchNo", vo.getStrBatchNo());
			dao.setProcInValue(nProcIndex3, "newBatchNo", "0");
			dao.setProcInValue(nProcIndex3, "unitId", "0");
			dao.setProcInValue(nProcIndex3, "expiryDate", "0");
			dao.setProcInValue(nProcIndex3, "manufDate", "0");
			dao.setProcInValue(nProcIndex3, "stockPageNo", "0");			
			dao.setProcInValue(nProcIndex3, "rackNo", "0");
			dao.setProcInValue(nProcIndex3, "manufacterId", vo.getStrManufacturerId());
			dao.setProcInValue(nProcIndex3, "replacementflag",vo.getStrReplacementDirectBatchFlag());
			dao.setProcOutValue(nProcIndex3, "err", 1); 
			dao.execute(nProcIndex3, 1);
			}
		    dao.fire();
		    flag = true;

			if (flag) 
			{
				vo.setStrMode("9");					
				vo.setStrPONo(vo.getStrPOHiddenValue().split("\\^")[11]);
				vo.setStrPOStoreId(vo.getStrPOStoreId());
				vo.setStrScheduleNo(vo.getStrScheduleNo());
				vo.setStrDeliveryStoreId(vo.getStrDeliveryStoreId());
				vo.setStrDrugBrandId(vo.getStrDeliveryNo());			
				SupplierDeskInterfaceTransDAO.getCommonProcedure(vo);
				 
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("SupplierDeskInterfaceTransDAO.insertDelivery() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;

			}

		}

	}
	
	
	public static void getBatchCombo(SupplierDeskInterfaceTransVO voObj) 
	
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call Pkg_Mms_View.proc_supplier_delivery_batch_dtl(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "IssueTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1");						
			daoObj.setProcInValue(nProcIndex, "poNo", voObj.getStrPONo());			
			daoObj.setProcInValue(nProcIndex, "hosp_code",voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "sch_no",voObj.getStrScheduleNo());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);			
	

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null) {
				strErr = "";
			}

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				voObj.setStrBatchNoWs(ws);
				
				////System.out.println("voObj.setStrBatchNoWs"+voObj.getStrBatchNoWs());

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("SupplierDeskInterfaceTransDAO.getBatchCombo() --> "
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
	 * Gets the balance qty details.
	 * 
	 * @param vo the vo
	 * @return the balance qty details
	 */
	public static void generateBatchBarCode(SupplierDeskInterfaceTransVO vo) 
	{
		
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_challan_barcode(?,?,?,?,?,?)}";		 
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		int i=1;
		String strBarCodeString="0",batch="",cartonSize="",boxId="";
		

		try {

			dao = new HisDAO("mms", "global.MmsDAO.getBalanceQtyDetails(MmsVO vo)");
			procIndex1 = dao.setProcedure(proc_name1);
			// set value
//			//System.out.println("<--Bar Code-->");
//			//System.out.println("vo.getStrChallanNo()--->"+vo.getStrChallanNo());
//			//System.out.println("vo.getStrStoreId()--->"+vo.getStrStoreId());
			dao.setProcInValue(procIndex1, "modeval",   "1");
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			//dao.setProcInValue(procIndex1, "challanNo", vo.getStrChallanNo());			
			dao.setProcInValue(procIndex1, "store_id",  vo.getStrStoreId());
			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object
			// execute
			// procedure

			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null) 
			{
				err = "";
			}
			ws = dao.getWebRowSet(procIndex1, "RESULTSET");	
			if(ws.size()>0)
			{	
				while (ws.next()) 
				{
	                  if(i==1)
	                  {
	                	  
	                	  batch = ws.getString(1);
	                	  cartonSize = ws.getString(2);
	                	  boxId = ws.getString(3);
	                  }
	                  else
	                  {
	                	  
	                	  batch = batch +","+ws.getString(1);
	                	  cartonSize = cartonSize +","+ws.getString(2);
	                	  boxId = boxId +","+ws.getString(3);
	                  }
	                  i++;
				}
				strBarCodeString = batch+"#"+cartonSize+"#"+boxId;
			}
			
			
			vo.setStrBarCodeString(strBarCodeString);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("MmsDAO.getBalanceQtyDetails() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	public static void getBatchNoList(SupplierDeskInterfaceTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "SupplierDeskInterfaceTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_po_item_dtl(?,?,?,?,?,?,?,?,?)}"; // 9
			nprocIndex = dao.setProcedure(strproc_name);
			
			//System.out.println(vo.getStrPOStoreId());
			//System.out.println(vo.getStrStoreId());
			if(vo.getStrReplacementDirectBatchFlag().equals("1"))
			{
				dao.setProcInValue(nprocIndex, "modeval", "21");
			}
			else if(vo.getStrReplacementDirectBatchFlag().equals("2"))
			{
				dao.setProcInValue(nprocIndex, "modeval", "22");
			}
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "storeid", vo.getStrPOStoreId());
			dao.setProcInValue(nprocIndex, "pono", vo.getStrPONo());
			dao.setProcInValue(nprocIndex, "item_id", "0");
			dao.setProcInValue(nprocIndex, "item_brand_id", vo.getStrDeliveryStoreId());
			dao.setProcInValue(nprocIndex, "schedule_no", vo.getStrScheduleNo());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null) {
				strerr = "";
			}

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");
				vo.setWsBatchList(wb);

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("SupplierDeskInterfaceTransDAO.getBatchNoList() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getSupplierInterfacedataList(SupplierDeskInterfaceTransVO vo) 
	{
			String strproc_name = "";
			HisDAO dao = null;
			int nprocIndex = 0;
			String strerr = "";
			WebRowSet wb = null;
			try {
				dao = new HisDAO("mms", "SupplierDeskInterfaceTransDAO");
				strproc_name = "{call PKG_MMS_JQGRIDVIEW.proc_supplier_interface_list(?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);

				dao.setProcInValue(nprocIndex, "modeval", "1");				
				dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
				dao.setProcInValue(nprocIndex, "seatid", vo.getStrSeatId());
				dao.setProcOutValue(nprocIndex, "err", 1);
				dao.setProcOutValue(nprocIndex, "resultset", 2);
				dao.executeProcedure(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null) {
					strerr = "";
				}

				wb = dao.getWebRowSet(nprocIndex, "resultset");

				if (strerr.equals("")) 
				{
					vo.setWbSupplierInterfaceListDtl(wb);

				}
				else 
				{
					throw new Exception(strerr);
				}

			} catch (Exception e) {
				vo.setStrMsgString("SupplierDeskInterfaceTransDAO.getSupplierInterfaceList() --> " + e.getMessage());
				vo.setStrMsgType("1");
			} finally {
				if (dao != null) {
					dao.free();
					dao = null;
				}
			}
		
	}
	
	public static void getSupplierInterfaceRpt(SupplierDeskInterfaceTransVO vo) 
	{
			String strproc_name = "";
			HisDAO dao = null;
			int nprocIndex = 0;
			String strerr = "";
			WebRowSet wb = null;
			try {
				dao = new HisDAO("mms", "SupplierDeskInterfaceTransDAO");
				strproc_name = "{call PKG_MMS_JQGRIDVIEW.rptm_supplier_interface_trans_list(?,?,?,?,?  ,?,?,?,?,?  ,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);

				
				
				//System.out.println("vo.StatusValue() "+vo.getStatus());
				dao.setProcInValue(nprocIndex, "modeval", "1");				
				dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
				dao.setProcInValue(nprocIndex, "seatid", vo.getStrSeatId());
				dao.setProcInValue(nprocIndex, "suppliername", vo.getStrSupplierName().equals("") ? "NA" : vo.getStrSupplierName());
				dao.setProcInValue(nprocIndex, "prefixpo", vo.getPrefixpono().equals("") ? "NA" : vo.getPrefixpono());
				dao.setProcInValue(nprocIndex, "podate", vo.getStrPODate().equals("") ? "NA" : vo.getStrPODate());
				dao.setProcInValue(nprocIndex, "orderqty", vo.getOrderdqty().equals("") ? "NA" : vo.getOrderdqty());
				dao.setProcInValue(nprocIndex, "balanceqty", vo.getBalanceqty().equals("") ? "NA" : vo.getBalanceqty());
				dao.setProcInValue(nprocIndex, "itemname", vo.getStrItemNameNew().equals("") ? "NA" : vo.getStrItemNameNew());
				dao.setProcInValue(nprocIndex, "status", vo.getStatus());
				
				
				
				dao.setProcOutValue(nprocIndex, "err", 1);
				dao.setProcOutValue(nprocIndex, "resultset", 2);
				dao.executeProcedure(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null) {
					strerr = "";
				}

				wb = dao.getWebRowSet(nprocIndex, "resultset");

				if (strerr.equals("")) 
				{
					vo.setWsSupplierInterfaceRptList(wb);

				}
				else 
				{
					throw new Exception(strerr);
				}

			} catch (Exception e) {
				e.printStackTrace();
				vo.setStrMsgString("SupplierDeskInterfaceTransDAO.getDrugMstList() --> " + e.getMessage());
				vo.setStrMsgType("1");
			} finally {
				if (dao != null) {
					dao.free();
					dao = null;
				}
			}
		
	}
}
