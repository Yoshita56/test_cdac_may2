package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.DML_ReturnToSupplierDAO;
import mms.dao.DML_ReturnToSupplierItemDAO;
import mms.transactions.controller.data.SupplierReturnReqTransDATA;
import mms.transactions.vo.SupplierReturnReqTransVO;
/**
 * Developer : Deepak Tiwari 
 * Version   : 1.0 
 * Date      : 23/Jan/2009
 * Module    : MMS
 * Unit      : Supplier Return Request Details
 */

public class SupplierReturnReqTransDAO {
	
	public static  String DATE_FORMAT_NOWwt = "dd-MMM-yyyy/HH:mm:ss";
	 public static  String DATE_FORMAT_NOW = "dd-MMM-yyyy";
	/**
	 * This method is used to call the procedure and set the values
	 * corresponding to it for populating the 
	 * ITEM CATEGORY LIST
	 */
	public static void getItemCategoryCmb(SupplierReturnReqTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call PKG_MMS_VIEW.proc_item_category_list(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			daoObj = new HisDAO("MMS Transactions","SupplierReturnReqTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "store_id", voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "reqType", "47");
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
				voObj.setStrItemCatWs(ws);
			} 
			else 
			{
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			voObj
					.setStrMsgString("SupplierReturnReqTransDAO.getItemCategoryCmb() --> "
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
	 * This method is used to call the procedure and set the values
	 * corresponding to it for populating the 
	 * GROUP LIST
	 */
	public static void getGroupCmb(SupplierReturnReqTransVO voObj) {

			HisDAO daoObj = null;
			WebRowSet ws = null;

			String strProcName = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";
			int nProcIndex = 0;
		
			String strErr = "";

			try {
				daoObj = new HisDAO("MMS Transactions","SupplierReturnReqTransDAO");

				nProcIndex = daoObj.setProcedure(strProcName);

				daoObj.setProcInValue(nProcIndex, "modeval", "1");
				daoObj.setProcInValue(nProcIndex, "item_category", voObj.getStrItemCatNo());
				daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
				
				/* Setting Default Value Start*/
				daoObj.setProcInValue(nProcIndex, "strPhyStockNo", "");
				daoObj.setProcInValue(nProcIndex, "strStoreId", "");
				/* Setting Default Value End */
				
				daoObj.setProcOutValue(nProcIndex, "err", 1);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2);

				daoObj.executeProcedure(nProcIndex);
				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				if (strErr.equals("")) {

					ws = daoObj.getWebRowSet(nProcIndex, "resultset");
					voObj.setStrGroupWs(ws);
				} else {
					throw new Exception(strErr);
				}

			} catch (Exception e) {
				voObj
						.setStrMsgString("SupplierReturnReqTransDAO.getGroupCmb() --> "
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
	 * This method is used to call the procedure and set the values
	 * corresponding to it for populating the 
	 * GROUP LIST
	 */
	public static void getPODetails(SupplierReturnReqTransVO voObj) {

			HisDAO daoObj = null;
			WebRowSet ws = null;

			String strProcName = "{call Pkg_Mms_View.Proc_Po_Detail_Info(?,?,?,?,?,?,?,?,?,?)}";
			int nProcIndex = 0;
		
			String strErr = "";

			try {
				daoObj = new HisDAO("MMS Transactions","SupplierReturnReqTransDAO");

				nProcIndex = daoObj.setProcedure(strProcName);

				daoObj.setProcInValue(nProcIndex, "modval", "1");
				daoObj.setProcInValue(nProcIndex, "item_category", voObj.getStrItemCatNo());
				daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
				daoObj.setProcInValue(nProcIndex, "store_Id", voObj.getStrStoreId());
				daoObj.setProcInValue(nProcIndex, "poNo", voObj.getStrPONo());
				daoObj.setProcInValue(nProcIndex, "po_frmdate", "0");
				daoObj.setProcInValue(nProcIndex, "po_todate", "0");
				
				daoObj.setProcInValue(nProcIndex, "schedule_no", "0"); // DEFAULT VALUE 
				
				daoObj.setProcOutValue(nProcIndex, "err", 1);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2);

				daoObj.executeProcedure(nProcIndex);
				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				if (strErr.equals("")) {

					ws = daoObj.getWebRowSet(nProcIndex, "resultset");
					voObj.setStrPODetailsWs(ws);
				} else {
					throw new Exception(strErr);
				}

			} catch (Exception e) {
				voObj
						.setStrMsgString("SupplierReturnReqTransDAO.getPODetails() --> "
								+ e.getMessage());
				voObj.setStrMsgType("1");

			} finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
		}
    
	public static void getPODetailsSearchList(SupplierReturnReqTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Po_Detail_Info(?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {
			daoObj = new HisDAO("MMS Transactions","SupplierReturnReqTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modval", "2");
			daoObj.setProcInValue(nProcIndex, "item_category", voObj.getStrItemCatNo());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "store_Id", voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "poNo", "0");
			daoObj.setProcInValue(nProcIndex, "po_frmdate", voObj.getStrSearchListPODtlFromDate());
			daoObj.setProcInValue(nProcIndex, "po_todate", voObj.getStrSearchListPODtlToDate());
			
			daoObj.setProcInValue(nProcIndex, "schedule_no", "0"); // DEFAULT VALUE
			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				voObj.setStrPODetailsWs(ws);
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			voObj.setStrMsgString("SupplierReturnReqTransDAO.getPODetails() --> "+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	/**
	 * This method is used to call the procedure and set the values
	 * corresponding to it for inserting the details.
	 * i.e, issue the store material to the third party.
	 */
	public static void CANCEL_REQUEST(SupplierReturnReqTransVO voObj) 
	{
		String strProcName = "{call Pkg_Mms_Dml.Dml_Return_To_Supplier(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	    int nProcIndex = 0;
	    HisDAO daoObj = null;
			
		try {
			
			//check mandatory information
			
			if(voObj.getStrReqNo().equals("0") || voObj.getStrReqNo().equals("")) {
				throw new Exception("ReqNo can not be blank");
			}
			if(voObj.getStrHospitalCode().equals("0") || voObj.getStrHospitalCode().equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			/*//System.out.println("t1---reqno------------->"+voObj.getStrReqNo());
			//System.out.println("t1---hospcode---------->"+voObj.getStrHospitalCode());
			//System.out.println("t1---itemcat----------->"+voObj.getStrItemCatNo());
			//System.out.println("t1---storeid----------->"+voObj.getStrStoreId());
			//System.out.println("t1---remarks----------->"+voObj.getStrRemarks());
			//System.out.println("t1---seatid------------>"+voObj.getStrSeatId());*/
		
			daoObj = new HisDAO("Third Party Issue","SupplierReturnReqTransDAO");
		    nProcIndex = daoObj.setProcedure(strProcName);
			
		    daoObj.setProcInValue(nProcIndex, "modval", "3");
		    daoObj.setProcInValue(nProcIndex, "ret_no", voObj.getStrReqNo());
		    daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
		    daoObj.setProcInValue(nProcIndex, "itemcat_no", voObj.getStrItemCatNo());
		    daoObj.setProcInValue(nProcIndex, "store_id", voObj.getStrStoreId());
		    daoObj.setProcInValue(nProcIndex, "remarks", voObj.getStrRemarks());
		    daoObj.setProcInValue(nProcIndex, "seat_id", voObj.getStrSeatId());
		    daoObj.setProcInValue(nProcIndex, "isvalid", "1");
		    
		    /* Setting Default Value Start*/
		    daoObj.setProcInValue(nProcIndex, "po_no", "");
		    daoObj.setProcInValue(nProcIndex, "req_date", "");
		    daoObj.setProcInValue(nProcIndex, "ret_date", "");
		    daoObj.setProcInValue(nProcIndex, "po_store_id", "");
		    daoObj.setProcInValue(nProcIndex, "potype_id", "47");
		    daoObj.setProcInValue(nProcIndex, "po_date", "");
		    daoObj.setProcInValue(nProcIndex, "supp_id", "");
		    daoObj.setProcInValue(nProcIndex, "ret_status", "1");
		    daoObj.setProcInValue(nProcIndex, "ret_flag", "1");
		    daoObj.setProcInValue(nProcIndex, "ret_type", "1");
		    daoObj.setProcInValue(nProcIndex, "delivery_date", "");
		    daoObj.setProcInValue(nProcIndex, "challan_no", "");
		    daoObj.setProcInValue(nProcIndex, "challan_date", "");
		    daoObj.setProcInValue(nProcIndex, "online_flg", "0");
		    daoObj.setProcInValue(nProcIndex, "financial_start_date", "");
		    daoObj.setProcInValue(nProcIndex, "financial_end_date", "");
		    daoObj.setProcInValue(nProcIndex, "entry_date", "");
		    daoObj.setProcInValue(nProcIndex, "net_cost", "0");
		    daoObj.setProcInValue(nProcIndex, "cancel_seatid", "");
		    daoObj.setProcInValue(nProcIndex, "cancel_date", "");
		    daoObj.setProcInValue(nProcIndex, "cancel_remarks", "");
		    daoObj.setProcInValue(nProcIndex, "puk", "0");
		    daoObj.setProcInValue(nProcIndex, "schedule_no", "1");
		    /* Setting Default Value End */
		    
		    daoObj.setProcOutValue(nProcIndex, "err", 1);
		    daoObj.setProcOutValue(nProcIndex, "retSerialNo", 1);
		    daoObj.setProcOutValue(nProcIndex, "dml_count", 1);
		    daoObj.setProcOutValue(nProcIndex, "approval_level", 1);
		    daoObj.executeProcedure(nProcIndex);
		   /* //System.out.println("approval_level->"+daoObj.getString(nProcIndex, "approval_level"));
		    //System.out.println("updateCount->"+daoObj.getString(nProcIndex, "dml_count"));*/
		   
		} 
		catch(Exception e) {
			voObj.setStrMsgString("SupplierReturnReqTransDAO.CANCEL_REQUEST() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		}
		finally {
			daoObj=null;	//to reset the variables
		}
	}

	/**
	 * This method is used to call the procedure and set the values
	 * corresponding to it for inserting the details.
	 * i.e, issue the store material to the third party.
	 */
	public static void insert(SupplierReturnReqTransVO voObj) {

		HisDAO daoObj = null;
 
		int funcIndex = 0;
		
		String strReqNo = "";
		
		String strItemId = null;						
		String strItemBrandId  = null;					
		String strBatchSlNo = null;						
		String strExpiryDate = null;					
		String strMaufDate = null;						
		String strRate = null;							
		String strRateUnitId = null;					
		String strGroupId = null;						
		String strSubGroupId = null;					
		String strSanctionQty ="0";
		String strSanctionQtyUnitId ="";
		String strReturnQty ="0";
		String strAccQty = null;
		String strAccQtyUnitId = null;
		String strInhandQty = null;
		String strInhandQtyUnitId = null;
		String strItemSlNo="0";
		String strStock_status_code="0";
		String[] temp = null;
		DML_ReturnToSupplierDAO returnToSupplierDAO = null;
		DML_ReturnToSupplierItemDAO returnToSupplierItemDAO = null;
        int returnToSupplierReqDAOProcIndex=0; 
		try 
		{
			daoObj = new HisDAO("MMS Module", "Return To Supplier");
			returnToSupplierDAO = new DML_ReturnToSupplierDAO();
			returnToSupplierItemDAO = new DML_ReturnToSupplierItemDAO();
		    //generate_third_party_req_no (hosp_code NUMBER,store_id NUMBER,reqType NUMBER,itemCat NUMBER)	 	 
			funcIndex = daoObj.setFunction("{? = call MMS_MST.generate_supplier_return_no(?,?,?,?)}");
				// Set Value
			daoObj.setFuncInValue(funcIndex,2,voObj.getStrHospitalCode());
			daoObj.setFuncInValue(funcIndex,3,voObj.getStrStoreId());
			daoObj.setFuncInValue(funcIndex,4,"47");
			daoObj.setFuncInValue(funcIndex,5,voObj.getStrItemCategoryNoH());
			daoObj.setFuncOutValue(funcIndex,1);
			daoObj.executeFunction(funcIndex);
			
			strReqNo = daoObj.getFuncString(funcIndex); // getting the req no.	
			 /**
			  * insert data into [ hstt_supp_return_dtl & sstt_approvalreq_dtl ]
			  */
			
//		    //System.out.println("t1---reqno------------->"+strReqNo);
//			//System.out.println("t1---hospcode---------->"+voObj.getStrHospitalCode());
//			//System.out.println("t1---itemcat----------->"+voObj.getStrItemCategoryNoH());
//			//System.out.println("t1---storeid----------->"+voObj.getStrStoreId());
//			//System.out.println("t1---financialstartyr-->"+voObj.getStrFinancialStartYear());
//			//System.out.println("t1---financialendyr---->"+voObj.getStrFinancialEndYear());
//			//System.out.println("t1---remarks----------->"+voObj.getStrRemarks());
//			//System.out.println("t1---seatid------------>"+voObj.getStrSeatId());
			
			voObj.setStrCurrentDate(SupplierReturnReqTransDATA.now(DATE_FORMAT_NOW));
			 returnToSupplierDAO.setStrReturnNo(strReqNo);											//1
			 returnToSupplierDAO.setStrHospitalCode(voObj.getStrHospitalCode());					//2
			 returnToSupplierDAO.setStrItemCatNo(voObj.getStrItemCategoryNoH());		//3	
			 returnToSupplierDAO.setStrStoreId(voObj.getStrStoreId());							//4
			 returnToSupplierDAO.setStrReturnStatus("0");
			 returnToSupplierDAO.setStrPODate(voObj.getStrPODate());
			 returnToSupplierDAO.setStrPONo(voObj.getStrPONo());
			 returnToSupplierDAO.setStrPOStoreId(voObj.getStrPOStoreId());
			 returnToSupplierDAO.setStrReturnFlag(voObj.getStrReturnReason());
			 if(voObj.getStrReturnReason().trim().equals("1"))
			    returnToSupplierDAO.setStrDeliveryDate(voObj.getStrDeliveryDate());
			 else
				returnToSupplierDAO.setStrDeliveryDate(""); 
			 returnToSupplierDAO.setStrNetCost(voObj.getStrTotalReturnCost());
			 returnToSupplierDAO.setStrOnLineFlag("1");
			 returnToSupplierDAO.setStrReturnType(voObj.getStrReturnType());
			 returnToSupplierDAO.setStrSupplierId(voObj.getStrSupplierId());
			 returnToSupplierDAO.setStrFinancialStartYear(voObj.getStrFinancialStartYear());		//7
			 returnToSupplierDAO.setStrFinancialEndYear(voObj.getStrFinancialEndYear());			//8
			 returnToSupplierDAO.setStrRemarks(voObj.getStrReturnReason());							//9
			 returnToSupplierDAO.setStrSeatId(voObj.getStrSeatId());		
			 returnToSupplierDAO.setStrEntryDate(voObj.getStrCurrentDate());//10
			 returnToSupplierDAO.setStrReqDate(voObj.getStrCurrentDate());
			 //returnToSupplierDAO.setStrIssueDate(strIssueDate)
			 returnToSupplierDAO.setStrGnumIsValid("1");
			 returnToSupplierReqDAOProcIndex=returnToSupplierDAO.insert(daoObj);
			/**
			 * Hidden Values corresponding to particular
			 * ITEM DETAILS
			 */	
			for(int i=0 , stopI = voObj.getStrReturnQty().length;i<stopI;i++)
			{
				
				 temp  = voObj.getItemUserValue()[i].replace('^', '#').split("#");
				 strItemSlNo=temp[18];	
				 strStock_status_code=temp[32];
				 strItemId =temp[0];
				 
				 if(temp[1]== null||temp[1].equals(""))
        	     {               
					 strItemBrandId  = "0";
        	     }
        	     else
        	     {
        	    	 strItemBrandId = temp[1];
        	     }
				 
				 strBatchSlNo = temp[15];
				 if(temp[16].trim().equals("/"))
					 strExpiryDate = ""; 
				 else	 
					 strExpiryDate = temp[16];
				 
				 strMaufDate = temp[17];
				 strAccQty=temp[19];
				 strAccQtyUnitId=temp[20];
				 strInhandQty=temp[7];
				 strInhandQtyUnitId=temp[8];
				 strRate = temp[9];
				 strRateUnitId = temp[10];
		//		 strConsumablesFlag = temp[4];
				 strGroupId = temp[2];
				 strSubGroupId = temp[3];
				 /**
				  * insert data into hstt_supp_return_item_dtl
				  */
//				//System.out.println("/**************************************************/"); 
//				//System.out.println("t2---approval LEVEL------------>"+returnToSupplierDAO.getStrApproval_level());
//				//System.out.println("t2---storeid----------->"+voObj.getStrStoreId());
//				//System.out.println("t2---reqno------------>"+strReqNo);
//				//System.out.println("t2---itemSlNo------------>"+strItemSlNo);
//				//System.out.println("t2---stock_status_code------------>"+strStock_status_code);
//				//System.out.println("t2---itemid----------->"+strItemId);
//				//System.out.println("t2---itembrandid------>"+strItemBrandId);
//				//System.out.println("t2---batchslno-------->"+strBatchSlNo);
//				//System.out.println("t2---hospcode--------->"+voObj.getStrHospitalCode());
//				//System.out.println("t2---groupid---------->"+strGroupId);
//				//System.out.println("t2---subgroupid------->"+strSubGroupId);
//				//System.out.println("t2---inhandqty-------->"+strInhandQty);
//				//System.out.println("t2---inhandqtyid------>"+strInhandQtyUnitId);
//				//System.out.println("t2---rate------------->"+strRate);
//				//System.out.println("t2---rateunitid------->"+strRateUnitId);
//				//System.out.println("t2---expiryid--------->"+strExpiryDate);
//				//System.out.println("t2---suppid--------->"+voObj.getStrSupplierId());
//				//System.out.println("t2---cost--------->"+voObj.getStrReturnCost()[i]);
//				//System.out.println("t2---strMaufDate--------->"+strMaufDate);
//				//System.out.println("t2---strAccQty--------->"+strAccQty);
//				//System.out.println("t2---strAccQtyUnitId--------->"+strAccQtyUnitId);
//				//System.out.println("t2---req Qty-->"+voObj.getStrReturnQty()[i]);
//				//System.out.println("t2---req Qty UnitId-->"+voObj.getStrUnitName()[i].replace('^', '#').split("#")[0]);
				
				returnToSupplierItemDAO.setStrApproval_level(returnToSupplierDAO.getStrApproval_level());
				returnToSupplierItemDAO.setStrReqNo(strReqNo);								 		//1
				returnToSupplierItemDAO.setStrHstNumStoreId(voObj.getStrStoreId());
				returnToSupplierItemDAO.setStrSstNumItemCatNo(voObj.getStrItemCategoryNoH());
				returnToSupplierItemDAO.setStrHstNumItemSlNo(strItemSlNo);
				returnToSupplierItemDAO.setStrHstNumStockStatusCode(strStock_status_code);
				returnToSupplierItemDAO.setStrItemId(strItemId);								 		//2
				returnToSupplierItemDAO.setStrItemBrandId(strItemBrandId);					 		//3
				returnToSupplierItemDAO.setStrBatchSlNo(strBatchSlNo);						 		//4	
				returnToSupplierItemDAO.setStrHospitalCode(voObj.getStrHospitalCode());	
				returnToSupplierItemDAO.setStrSeatId(voObj.getStrSeatId());//5
				returnToSupplierItemDAO.setStrGroupId(strGroupId);							 		//6
				returnToSupplierItemDAO.setStrSubGroupId(strSubGroupId);		
				returnToSupplierItemDAO.setStrAccQty(strAccQty);
				returnToSupplierItemDAO.setStrAccQtyUnitId(strAccQtyUnitId);
				returnToSupplierItemDAO.setStrCost(voObj.getStrReturnCost()[i]);
				returnToSupplierItemDAO.setStrSupplierId(voObj.getStrSupplierId());
				//7
				returnToSupplierItemDAO.setStrReqQty(voObj.getStrReturnQty()[i]);					 		//8
				returnToSupplierItemDAO.setStrReqQtyUnitId(voObj.getStrUnitName()[i].replace('^', '#').split("#")[0]);	
				if(returnToSupplierDAO.getStrApproval_level().equals("0"))//if Approval_level=0 then no approval req::Sanc Qty & Unit Id updated
				{
				   returnToSupplierItemDAO.setStrSanctionQty(voObj.getStrReturnQty()[i]);//9
				   returnToSupplierItemDAO.setStrSanctionQtyUnitId(voObj.getStrUnitName()[i].replace('^', '#').split("#")[0]);//10
				}
				else
				{
				   returnToSupplierItemDAO.setStrSanctionQty(strSanctionQty);//9
				   returnToSupplierItemDAO.setStrSanctionQtyUnitId(strSanctionQtyUnitId);//10	
				}
				returnToSupplierItemDAO.setStrReturnQty(strReturnQty);
				returnToSupplierItemDAO.setStrReturnQtyUnitId("");
				returnToSupplierItemDAO.setStrInhandQty(strInhandQty);						 		//10
				returnToSupplierItemDAO.setStrInhandQtyUnitId(strInhandQtyUnitId);			 		//11	
				returnToSupplierItemDAO.setStrRate(strRate);									 		//12
				returnToSupplierItemDAO.setStrRateUnitId(strRateUnitId);	
				if(strMaufDate.trim().equals("/"))                                                //13
					strMaufDate="";
				returnToSupplierItemDAO.setStrManufactureDate(strMaufDate);	
				if(strExpiryDate.trim().equals("/"))                                                //13
					strExpiryDate="";
				returnToSupplierItemDAO.setStrExpiryDate(strExpiryDate);						 		//14
				returnToSupplierItemDAO.insert(daoObj);
			 }	
			synchronized(daoObj)
			{
				daoObj.fire();
				returnToSupplierItemDAO.setStrApproval_level(daoObj.getString(returnToSupplierReqDAOProcIndex, "approval_level"));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			voObj.setStrMsgString("SupplierReturnReqTransDAO.insert() --> "+ e.getMessage());
			voObj.setStrMsgType("1");

		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
			returnToSupplierItemDAO = null;
			returnToSupplierDAO = null;
		}
	}
	
}
