package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.AdvanceDetailsDAO;
import mms.dao.DispatchDeatilsDAO;
import mms.dao.InvoceDetailsDAO;
import mms.dao.SsttPoDetailsDAO;
import mms.transactions.vo.DispatchDetailsTransVO;


/**
 * Developer :Baisakhi Roy
 * Changes : Kapil Khurana
 * Version : 1.1 
 * Start Date : 08/May/2009
 * End Date : 12/May/2009
 * Module:MMS
 * Process: Dispatch Details
 *
 */
public class DispatchDetailsTransDAO 
{

	/** This method is used to populate the value of Dispatch Mode combo box.
	 * @param voObj
	 * 
	 */
	public static void getDispatchModeCombo(DispatchDetailsTransVO voObj) {

		HisDAO daoObj = null;
		

		String strProcName = "";
		int nProcIndex = 0;
		WebRowSet ws=null;
		String strErr = "";

		try {
			
			daoObj = new HisDAO("mms",
					"DispatchDetailsTransDAO");

			strProcName = "{call Pkg_Mms_View.proc_dispatchmode_dtl(?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setStrDispatchModeNameValuesWS(ws);
				

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			
					voObj
					.setStrMsgString("DispatchDetailsTransDAO.getDispatchModeCombo() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	/** This method is used to populate the value of Store name combo box.
	 * @param voObj
	 *
	 */
	public static void getStoreNameCombo(DispatchDetailsTransVO voObj) {

		HisDAO daoObj = null;
		

		String strProcName = "";
		int nProcIndex = 0;
		WebRowSet ws=null;
		String strErr = "";

		try {
			daoObj = new HisDAO("mms",
					"DispatchDetailsTransDAO");

			strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId());
			
			/* Start */

			daoObj.setProcInValue(nProcIndex, "storeid", "0");
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0");

			/* End */
			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setStrStoreNameValuesWS(ws);
				

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			
					voObj
					.setStrMsgString("DispatchDetailsTransDAO.getStoreNameCombo() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	/** This method is used to populate the value of Item Category name combo box.
	 * @param voObj
	 * 
	 */
	public static void getItemCategoryCombo(DispatchDetailsTransVO voObj) {

		HisDAO daoObj = null;
		

		String strProcName = "";
		int nProcIndex = 0;
		WebRowSet ws=null;
		String strErr = "";

		try {
			daoObj = new HisDAO("mms",
					"DispatchDetailsTransDAO");

			strProcName = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "store_id", voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "reqType", voObj.getStrReqTypeId());
			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setStrItemCategoryValuesWS(ws);
				

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
					voObj
					.setStrMsgString("DispatchDetailsTransDAO.getItemCategoryCombo() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	
	/** This method is used to populate the value of BILL NO Combo box. this method called the procedure pkg_mms_view.
	 * @param voObj
	 */
	/*public static void getBillNOCombo(DispatchDetailsTransVO voObj) { (commented by baisakhi)

		HisDAO daoObj = null;
		

		String strProcName = "";
		int nProcIndex = 0;
		WebRowSet ws=null;
		String strErr = "";

		try {
			daoObj = new HisDAO("mms",
					"DispatchDetailsTransDAO");

			strProcName = "{call billno_dummy_dtl(?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modval", "1");
			daoObj.setProcInValue(nProcIndex, "hoscode", voObj.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setStrBillNoValuesWS(ws);
				

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			
					voObj
					.setStrMsgString("DispatchDetailsTransDAO.getBillNOCombo() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}*/
	
	/** This method is used to populate the value of PO NO Combo box
	 * @param voObj
	 */
	public static void getPONOCombo(DispatchDetailsTransVO voObj) {

		HisDAO daoObj = null;
		

		String strProcName = "";
		int nProcIndex = 0;
		WebRowSet ws=null;
		String strErr = "";

		try {
			daoObj = new HisDAO("mms",
					"DispatchDetailsTransDAO");

			strProcName = "{call Pkg_Mms_View.proc_pono_dtl(?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", voObj.getModeValue());
			
		/*	//System.out.println("modeval---->"+voObj.getModeValue());
			//System.out.println("HOSPCODE---->"+voObj.getStrHospitalCode());
			//System.out.println("storeid---->"+voObj.getStrStrId());
			//System.out.println("itemxcat---->"+voObj.getStrItemCatId());*/
			
			
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "itemcat_no", voObj.getStrItemCatId());
			daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStrId());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			
			if (strErr.equals("")) {

				voObj.setStrPONONameValuesWS(ws);
				////System.out.println("ws size---"+ws.size());

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
					voObj
					.setStrMsgString("DispatchDetailsTransDAO.getPONOCombo() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	/** This method is used to get PO No Details.
	 * @param voObj
	 * 
	 */
	public static void getPONODetails(DispatchDetailsTransVO voObj) {

		HisDAO daoObj = null;
		

		String strProcName = "";
		int nProcIndex = 0;
		WebRowSet ws=null;
		String strErr = "";

		try {
		
			daoObj = new HisDAO("mms",
					"DispatchDetailsTransDAO");

			strProcName = "{call Pkg_Mms_View.proc_po_details(?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "poNo", voObj.getStrPONO());
			daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrPOStoreId());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setStrPONODetailsWS(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
					voObj
					.setStrMsgString("DispatchDetailsTransDAO.getPONODetails() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	/** This method is used to get Request Details.
	 * @param voObj
	 * 
	 */
	public static void getRequestDetails(DispatchDetailsTransVO voObj) {

		HisDAO daoObj = null;
		

		String strProcName = "";
		int nProcIndex = 0;
		WebRowSet ws=null;
		String strErr = "";

		try {
			
			daoObj = new HisDAO("mms",
					"DispatchDetailsTransDAO");

			strProcName = "{call Pkg_Mms_View.proc_request_details(?,?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);
		
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "itemcat_no", voObj.getStrItemCatId());
			daoObj.setProcInValue(nProcIndex, "store_Id", voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "poNo", voObj.getStrPONO());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			
						
			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setStrRequestDetailsValuesWS(ws);
				

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			
					voObj
					.setStrMsgString("DispatchDetailsTransDAO.getRequestDetails() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	/** This method is used to get Bill Details.
	 * @param voObj
	 * 
	 */
	public static void getBillDetails(DispatchDetailsTransVO voObj) {

		HisDAO daoObj = null;
		

		String strProcName = "";
		int nProcIndex = 0;
		WebRowSet ws=null;
		String strErr = "";

		try {
		
			daoObj = new HisDAO("mms",
					"DispatchDetailsTransDAO");

			strProcName = "{call Pkg_Mms_View.proc_bill_details(?,?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

		
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "itemcat_no", voObj.getStrItemCatId());
			daoObj.setProcInValue(nProcIndex, "store_Id", voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "poNo", voObj.getStrPONO());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setStrBillDetilsValuesWS(ws);
				

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			
					voObj
					.setStrMsgString("DispatchDetailsTransDAO.getBillDetails() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	/**This method is used to insert and Update the data in case of Advance mode
	 * @param vo
	 */
	public static void insertAdvance(DispatchDetailsTransVO vo) {

		HisDAO daoObj = null;
		AdvanceDetailsDAO advanceDetailsDAO=null;
		DispatchDeatilsDAO dispatchDetailsDAO=null;
		SsttPoDetailsDAO ssttPODetailsDAO=null;
	//	HsttPoDetailsDAO hsttPODetailsDAO=null;
		
		
		String strFuncName = "";
	
		int nFuncIndex = 0;
 		
		String strDispatchNo = "";

		try {
			daoObj = new HisDAO("mms","DispatchDetailsTransDAO");
			
			advanceDetailsDAO=new AdvanceDetailsDAO();
			dispatchDetailsDAO=new DispatchDeatilsDAO();
			ssttPODetailsDAO=new SsttPoDetailsDAO();
	//		hsttPODetailsDAO=new HsttPoDetailsDAO();
			
			strFuncName = "{? = call MMS_MST.generate_dispatchno(?,?,?)}";
			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId());
			daoObj.setFuncInValue(nFuncIndex, 4, vo.getStrItemCatId());
			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);
			strDispatchNo = daoObj.getFuncString(nFuncIndex);
			
			
			
			dispatchDetailsDAO.setStrDispatchFor("1");
			dispatchDetailsDAO.setStrDispatchModeId(vo.getStrDispatchMode());
			dispatchDetailsDAO.setStrDispatchNo(strDispatchNo);
			dispatchDetailsDAO.setStrHospitalCode(vo.getStrHospitalCode());
			dispatchDetailsDAO.setStrInsAmt(vo.getStrInstrAmt());
			dispatchDetailsDAO.setStrInsDate(vo.getStrInstrDate());
			dispatchDetailsDAO.setStrInsNo(vo.getStrInstrNo());
			dispatchDetailsDAO.setStrInsRecDate(vo.getStrInstrReceivedDate());
			dispatchDetailsDAO.setStrInsType(vo.getStrInstrType());
			dispatchDetailsDAO.setStrPoDate(vo.getStrPODate());
			dispatchDetailsDAO.setStrPoNo(vo.getStrPONO());
			dispatchDetailsDAO.setStrRemarks(vo.getStrRemarks());
			dispatchDetailsDAO.setStrSeatId(vo.getStrSeatId());
			dispatchDetailsDAO.setStrStoreId(vo.getStrStoreId());
			dispatchDetailsDAO.setStrSupplierId(vo.getStrSupplierId());
			dispatchDetailsDAO.setStrValidity(vo.getStrInstrValidity());
			dispatchDetailsDAO.setStrBankName(vo.getStrDraweeBank());
			dispatchDetailsDAO.setStrFinStartDate(vo.getStrFinStartDate());
			dispatchDetailsDAO.setStrFinEndDate(vo.getStrFinEndDate());
			dispatchDetailsDAO.setStrCurrencyId(vo.getStrCurrencyId());
			dispatchDetailsDAO.setStrPOStoreId(vo.getStrPOStoreId());
		
			if(!vo.getStrDefCurrId().equals(vo.getStrCurrencyId())){
				dispatchDetailsDAO.setStrCurrValue(vo.getStrCurrValue());
				dispatchDetailsDAO.setStrCurrValuePO(vo.getStrCurrValuePo());
			}else{
				dispatchDetailsDAO.setStrCurrValue("1");
				dispatchDetailsDAO.setStrCurrValuePO("1");
			}
			
			dispatchDetailsDAO.insert(daoObj);
			
			for(int i=0 , stopI = vo.getStrReqNo().length ;i<stopI;i++)
			{
				advanceDetailsDAO.setStrDispatchNo(strDispatchNo);
				advanceDetailsDAO.setStrHospitalCode(vo.getStrHospitalCode());
				advanceDetailsDAO.setStrReqNo(vo.getStrReqNo()[i]);
			//	advanceDetailsDAO.setStrPoNo(vo.getStrPONO());
			
				advanceDetailsDAO.update(daoObj);
			}
			
			ssttPODetailsDAO.setStrHospitalCode(vo.getStrHospitalCode());
			ssttPODetailsDAO.setStrInsAmount(vo.getStrInstrAmt());
			ssttPODetailsDAO.setStrModevalue("1");
			ssttPODetailsDAO.setStrPONO(vo.getStrPONO());
			
			ssttPODetailsDAO.update(daoObj);
			
		// changes by Anshul on 23-july-09 	
		/*	hsttPODetailsDAO.setStrHospitalCode(vo.getStrHospitalCode());
			hsttPODetailsDAO.setStrInsAmount(vo.getStrInstrAmt());
			hsttPODetailsDAO.setStrModevalue("1");
			hsttPODetailsDAO.setStrPONO(vo.getStrPONO());
			
			hsttPODetailsDAO.update(daoObj);*/
			
			synchronized(daoObj)   
			  {
				daoObj.fire();     // Here we Execute in Batch
			  }

		} catch (Exception e) {
			vo
					.setStrMsgString("DispatchDetailsTransDAO.insertAdvance --> "
							+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
				advanceDetailsDAO=null;
				dispatchDetailsDAO=null;
				ssttPODetailsDAO=null;
		//		hsttPODetailsDAO=null;
				
			}
		}

	}
	
	/**This method is used to insert and Update the data in case of Advance mode
	 * @param vo
	 */
	public static void insertBill(DispatchDetailsTransVO vo) {

		HisDAO daoObj = null;
		InvoceDetailsDAO invoiceDetailsDAO=null;
		DispatchDeatilsDAO dispatchDetailsDAO=null;
		SsttPoDetailsDAO ssttPODetailsDAO=null;
	//	HsttPoDetailsDAO hsttPODetailsDAO=null;
		
	
		String strFuncName = "";
	
		int nFuncIndex = 0;
	 		
		String strDispatchNo = "";

		try {
			daoObj = new HisDAO("mms","DispatchDetailsTransDAO");
			invoiceDetailsDAO=new InvoceDetailsDAO();
			dispatchDetailsDAO=new DispatchDeatilsDAO();
			ssttPODetailsDAO=new SsttPoDetailsDAO();
	//		hsttPODetailsDAO=new HsttPoDetailsDAO();
			
			
			strFuncName = "{? = call MMS_MST.generate_dispatchno(?,?,?)}";
			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId());
			daoObj.setFuncInValue(nFuncIndex, 4, vo.getStrItemCatId());
			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);
			strDispatchNo = daoObj.getFuncString(nFuncIndex);
			
			
			dispatchDetailsDAO.setStrDispatchFor("2");
			dispatchDetailsDAO.setStrDispatchModeId(vo.getStrDispatchMode());
			dispatchDetailsDAO.setStrDispatchNo(strDispatchNo);
			dispatchDetailsDAO.setStrHospitalCode(vo.getStrHospitalCode());
			dispatchDetailsDAO.setStrInsAmt(vo.getStrInstrAmt());
			dispatchDetailsDAO.setStrInsDate(vo.getStrInstrDate());
			dispatchDetailsDAO.setStrInsNo(vo.getStrInstrNo());
			dispatchDetailsDAO.setStrInsRecDate(vo.getStrInstrReceivedDate());
			dispatchDetailsDAO.setStrInsType(vo.getStrInstrType());
			dispatchDetailsDAO.setStrPoDate(vo.getStrPODate());
			dispatchDetailsDAO.setStrPoNo(vo.getStrPONO());
			dispatchDetailsDAO.setStrRemarks(vo.getStrRemarks());
			dispatchDetailsDAO.setStrSeatId(vo.getStrSeatId());
			dispatchDetailsDAO.setStrStoreId(vo.getStrStoreId());
			dispatchDetailsDAO.setStrSupplierId(vo.getStrSupplierId());
			dispatchDetailsDAO.setStrValidity(vo.getStrInstrValidity());
			dispatchDetailsDAO.setStrBankName(vo.getStrDraweeBank());
			dispatchDetailsDAO.setStrFinStartDate(vo.getStrFinStartDate());
			dispatchDetailsDAO.setStrFinEndDate(vo.getStrFinEndDate());
			dispatchDetailsDAO.setStrCurrencyId(vo.getStrCurrencyId());
			dispatchDetailsDAO.setStrPOStoreId(vo.getStrPOStoreId());
			
		
			if(!vo.getStrDefCurrId().equals(vo.getStrCurrencyId())){
				dispatchDetailsDAO.setStrCurrValue(vo.getStrCurrValue());
				dispatchDetailsDAO.setStrCurrValuePO(vo.getStrCurrValuePo());
			}else{
				dispatchDetailsDAO.setStrCurrValue("1");
				dispatchDetailsDAO.setStrCurrValuePO("1");
			}
			
			dispatchDetailsDAO.insert(daoObj);
			
			for(int i=0, stopI = vo.getStrBillNo().length;i<stopI;i++)
			{
				invoiceDetailsDAO.setStrDispatchNo(strDispatchNo);
				invoiceDetailsDAO.setStrHospitalCode(vo.getStrHospitalCode());
				invoiceDetailsDAO.setStrBillNo(vo.getStrBillNo()[i]);
			//	invoiceDetailsDAO.setStrPoNo(vo.getStrPONO());
				
				invoiceDetailsDAO.update(daoObj);
			}
			
			ssttPODetailsDAO.setStrHospitalCode(vo.getStrHospitalCode());
			ssttPODetailsDAO.setStrInsAmount(vo.getStrInstrAmt());
			ssttPODetailsDAO.setStrModevalue("2");
			ssttPODetailsDAO.setStrPONO(vo.getStrPONO());
			
			ssttPODetailsDAO.update(daoObj);
			
			// changes by Anshul on 23-july-09 	
		/*	hsttPODetailsDAO.setStrHospitalCode(vo.getStrHospitalCode());
			hsttPODetailsDAO.setStrInsAmount(vo.getStrInstrAmt());
			hsttPODetailsDAO.setStrModevalue("2");
			hsttPODetailsDAO.setStrPONO(vo.getStrPONO());
			
			hsttPODetailsDAO.update(daoObj);*/
			
			synchronized(daoObj)   
			  {
				daoObj.fire();     // Here we Execute in Batch
			  }

		} catch (Exception e) {
		

			vo
					.setStrMsgString("DispatchDetailsTransDAO.insertBill --> "
							+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
				invoiceDetailsDAO=null;
				dispatchDetailsDAO=null;
				ssttPODetailsDAO=null;
		//		hsttPODetailsDAO=null;
				
			}
		}

	}
	
	public static void getViewDetails(DispatchDetailsTransVO voObj) {

		HisDAO daoObj = null;
		

		String strProcName = "";
		int nProcIndex = 0;
		WebRowSet ws=null;
		String strErr = "";

		try {
			
			daoObj = new HisDAO("mms","DispatchDetailsTransDAO");

			strProcName = "{call Pkg_Mms_View.proc_dispatch_view_dtl(?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeid", voObj.getStrStoreId());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setStrViewDetailsWS(ws);
				

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
					voObj
					.setStrMsgString("DispatchDetailsTransDAO.getViewDetails() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
}
