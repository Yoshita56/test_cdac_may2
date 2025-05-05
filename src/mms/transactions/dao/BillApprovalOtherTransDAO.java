/**
 * 
 */
package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.BillApprovalOtherTransVO;


/**
 * Developer : Anshul Jindal 
 * Version : 1.0 Date : 23/June/2009
 * 
 */
public class BillApprovalOtherTransDAO {
	
	/**
	 * The following procedure is used to populate the value of PO No combo
	 * using Pkg_Mms_View.proc_store_group_list procedure.
	 * 
	 * @param voObj
	 */
	public static void getPOCombo(BillApprovalOtherTransVO vo) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("mms", "BillApprovalOtherTransDAO");

			strProcName = "{call Pkg_Mms_View.proc_sstt_PO_dtl(?,?,?,?,?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo
					.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "deliveryLocation", vo
					.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "POStatus", "1");
			daoObj.setProcInValue(nProcIndex, "POType","24"); 
			daoObj.setProcInValue(nProcIndex, "billType",vo.getStrBillType()); 
			
			/*Start*/
			
			daoObj.setProcInValue(nProcIndex, "store_Id","");
			daoObj.setProcInValue(nProcIndex, "poNo","");
		    
			/*End*/
			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				vo.setPONoCmbWS(ws);
				//System.out.println("vo.setGroupCmbWS()-" + ws.size());

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			vo
					.setStrMsgString("BillApprovalOtherTransDAO.getGroupCombo() --> "
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
	 * The following procedure is used to populate the value of PO No combo
	 * using Pkg_Mms_View.proc_store_group_list procedure.
	 * 
	 * @param voObj
	 */
	public static void getPODetails(BillApprovalOtherTransVO vo) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("mms", "BillApprovalOtherTransDAO");

			strProcName = "{call Pkg_Mms_View.proc_sstt_PO_dtl(?,?,?,?,?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "store_Id", vo.getStrPOStoreId());
			daoObj.setProcInValue(nProcIndex, "poNo", vo.getStrPONo());
			
			/* start */
			
			daoObj.setProcInValue(nProcIndex, "deliveryLocation", "");
			daoObj.setProcInValue(nProcIndex, "POStatus", "");
			daoObj.setProcInValue(nProcIndex, "POType", "");
			daoObj.setProcInValue(nProcIndex, "billType", "");
			
			/* end */
			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				vo.setPODetailsWs(ws);
				//System.out.println("vo.setPODetailsWs()-" + ws.size());

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			vo
					.setStrMsgString("BillApprovalOtherTransDAO.getPODetails() --> "
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
	 * The following procedure is used INSERT the data
	 * 
	 * @param voObj
	 */
	public static void insertData(BillApprovalOtherTransVO vo) {

		HisDAO daoObj = null;
		String strProcName = "";
		int nProcIndex = 0;
		
		String strFuncName = "";
		int nFuncIndex = 0;

		String strErr = "";
		String strInvoiceNo = "";

		try {
			daoObj = new HisDAO("mms", "BillApprovalOtherTransDAO");

			
			//System.out.println( "modeval"+ "5");
			//System.out.println( "hosp_code"+ vo.getStrHospitalCode());
			//System.out.println( "storeId"+ vo.getStrStoreId());
			//System.out.println( "getStrPOTypeId"+ vo.getStrPOTypeId());
			//System.out.println( "getStrItemCategoryNoH"+ vo.getStrItemCategoryNoH());
			
			strFuncName = "{? = call MMS_MST.generate_invoice_no(?,?,?,?)}";
			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId());
			daoObj.setFuncInValue(nFuncIndex, 4, "70");
			daoObj.setFuncInValue(nFuncIndex, 5, vo.getStrItemCategoryNoH());

			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);
			strInvoiceNo = daoObj.getFuncString(nFuncIndex);
			
			//System.out.println("strInvoiceNo-"+strInvoiceNo);
			strProcName = "{call Pkg_Mms_Dml.Dml_Hstt_Invoice_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";//28
			nProcIndex = daoObj.setProcedure(strProcName);
   
			//System.out.println( "modeval"+ "1");
			//System.out.println( "hosp_code"+ vo.getStrHospitalCode());
			//System.out.println( "storeId"+ vo.getStrStoreId());
			//System.out.println( "po_no"+ vo.getStrPONo());
			//System.out.println( "invoice_no"+ strInvoiceNo);//generate 
			//System.out.println( "invoice_typeId"+vo.getStrBillType());
			////System.out.println( "invoice_date"+vo.getStrBillDate());
			//System.out.println( "supplierId"+ vo.getStrSupplierId());
			//System.out.println( "po_storeId"+ vo.getStrPOStoreId());
			//System.out.println( "supp_invoice_no"+ vo.getStrBillNo());
			//System.out.println( "supp_invoice_date"+ vo.getStrBillDate());
			//System.out.println( "po_date"+vo.getStrPODate());
			//System.out.println( "currencyId"+ vo.getStrCurrencyId());
			//System.out.println( "supp_invoice_amt"+ vo.getStrBillAmount());
			//System.out.println( "financial_start_date"+ vo.getStrFinStartYr());
			//System.out.println( "financial_end_date"+ vo.getStrFinEndYr());
			//System.out.println( "remarks"+vo.getStrRemarks());
			//System.out.println( "seatId"+ vo.getStrSeatId());
			//System.out.println( "item_cat_no"+ vo.getStrItemCategoryNoH());
			
			 			   
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeId", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "po_no", vo.getStrPONo());
			daoObj.setProcInValue(nProcIndex, "invoice_no", strInvoiceNo);//generate 
			daoObj.setProcInValue(nProcIndex, "invoice_typeId",vo.getStrBillType());
			//daoObj.setProcInValue(nProcIndex, "invoice_date",vo.getStrBillDate());
			daoObj.setProcInValue(nProcIndex, "supplierId", vo.getStrSupplierId());
			daoObj.setProcInValue(nProcIndex, "po_storeId", vo.getStrPOStoreId());
			daoObj.setProcInValue(nProcIndex, "supp_invoice_no", vo.getStrBillNo());
			daoObj.setProcInValue(nProcIndex, "supp_invoice_date", vo.getStrBillDate());
			daoObj.setProcInValue(nProcIndex, "po_date",vo.getStrPODate());
			daoObj.setProcInValue(nProcIndex, "currencyId", vo.getStrCurrencyId());
			daoObj.setProcInValue(nProcIndex, "supp_invoice_amt", vo.getStrBillAmount());
			daoObj.setProcInValue(nProcIndex, "financial_start_date", vo.getStrFinStartYr());
			daoObj.setProcInValue(nProcIndex, "financial_end_date", vo.getStrFinEndYr());
			daoObj.setProcInValue(nProcIndex, "remarks",vo.getStrRemarks());
			daoObj.setProcInValue(nProcIndex, "seatId", vo.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "item_cat_no", vo.getStrItemCategoryNoH());
			
			/* Start */
			daoObj.setProcInValue(nProcIndex, "invoice_date", "");
			daoObj.setProcInValue(nProcIndex, "advance_amt", "0");
			daoObj.setProcInValue(nProcIndex, "adjusted_advance_amt", "0");
			daoObj.setProcInValue(nProcIndex, "penalty_amt", "0");
			daoObj.setProcInValue(nProcIndex, "penalty_waive_amt", "0");
			daoObj.setProcInValue(nProcIndex, "waivepenelty_app_by", "");
			daoObj.setProcInValue(nProcIndex, "waivepenelty_app_date", "");
			daoObj.setProcInValue(nProcIndex, "overall_tax", "0");
			daoObj.setProcInValue(nProcIndex, "calculated_cost", "0");
			/* End */
		
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			
			daoObj.execute(nProcIndex,1);
			
			synchronized (daoObj) {
				daoObj.fire();
			}
			strErr = daoObj.getString(nProcIndex, "err");

		
			if (strErr == null)
				strErr = "";
			if (strErr.equals("")) {

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			e.printStackTrace();
			vo
					.setStrMsgString("BillApprovalOtherTransDAO.getPODetails() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

}
