package mms.transactions.dao;

import java.util.Arrays;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.transactions.vo.SupplierTransactionRecordVO;

public class SupplierTransactionRecordDAO {

	public static void getstoreNameList(SupplierTransactionRecordVO vo) {
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?, ?,?,?)}"; // 7
		
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;

		try {
			daoObj = new HisDAO("MMS", "SupplierTransactionRecordDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "11", 1);
			daoObj.setProcInValue(nProcIndex, "seatId", vo.getStrSeatId(), 2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(), 3);
			daoObj.setProcInValue(nProcIndex, "storeid", "0", 4);
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0", 5);

			daoObj.setProcOutValue(nProcIndex, "err", 1, 6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 7);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			
			if (strErr.equals("")) {
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				vo.setWsStoreNameCombo(ws);
				System.out.println("DAO:vo.setWsStoreNameCombo(ws) STORE_LIST size" + ws.size());
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("SupplierTransactionRecordDAO.storeName() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getDataTable(SupplierTransactionRecordVO vo) {
		String proc_name1 = "{call pkg_mms_view2.proc_supplier_receipt_list(?,?,?,?,?, ?,?)}"; // 7

		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		
		try {

			dao = new HisDAO("mms", "SupplierTransactionRecordDAO.getDataTable()");

			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modeval", "2", 1);
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(), 2);
			dao.setProcInValue(procIndex1, "seat_id", vo.getStrSeatId(), 3);
			dao.setProcInValue(procIndex1, "store_id", vo.getStrStoreId(), 4);
			dao.setProcInValue(procIndex1, "item_cat_no", vo.getStrItemCategoryId(), 5);
			dao.setProcOutValue(procIndex1, "err", 1, 6);
			dao.setProcOutValue(procIndex1, "resultset", 2, 7);
			dao.executeProcedureByPosition(procIndex1);

			err = dao.getString(procIndex1, "err");
			if (err == null)
				err = "";

			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");
				vo.setWrsData(ws);
				System.out.println("DAO:vo.setWrsData(ws) GETDATATABLE size" + ws.size());
			} else {
				throw new Exception(err);
			}
		} catch (Exception e) {
			vo.setStrMsgString("SupplierTransactionRecordDAO.getDataTable() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void itemCategory(SupplierTransactionRecordVO vo) {
		String strProcName = "{call pkg_mms_view.proc_item_category_list(?,?,?,?,?,?)}"; // 6

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {
			daoObj = new HisDAO("Gifted Item Details", "SupplierTransactionRecordDAO");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "3", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(), 3);
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId(), 2);
			daoObj.setProcInValue(nProcIndex, "reqType", "64", 4);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 6);
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setWsItemCategoryCombo(ws);
				System.out.println("DAO:vo.setWsItemCategoryCombo(ws) size" + ws.size());

			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("SupplierTransactionRecordDAO.itemCategory() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void getSupplierList(SupplierTransactionRecordVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_supplier_list(?,?,?,?,? ,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "SupplierTransactionRecordDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "20", 1);
			daoObj.setProcInValue(nProcIndex, "catcode", voObj.getStrReqTypeId(), 2);
			daoObj.setProcInValue(nProcIndex, "branditem_id", "0", 3);
			daoObj.setProcInValue(nProcIndex, "contracttype", "12", 4);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 5);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 7);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				voObj.setStrSupplierWs(ws);
				System.out.println("DAO:SUPPLIER vo.setStrSupplierWs(ws) size" + ws.size());

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("LocalPurchaseNewTransDAO.getItemCatDtls() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void getSuppliedByList(SupplierTransactionRecordVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "SupplierTransactionRecordDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}"; // 5+2=7
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "14", 1);
//			dao.setProcInValue(nprocIndex, "catCode", vo.getStrItemCategoryNo(), 2);
			dao.setProcInValue(nprocIndex, "catCode", vo.getStrItemCategoryId(), 2);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(), 5);
			dao.setProcOutValue(nprocIndex, "err", 1, 6);
			dao.setProcOutValue(nprocIndex, "resultset", 2, 7);

			/* Start Adding Default value*/
			dao.setProcInValue(nprocIndex, "branditem_id", "0", 3);
			dao.setProcInValue(nprocIndex, "contractType", "0", 4);
			/* End Adding Default value*/

			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			if (strerr.equals("")) {
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");

				vo.setStrManufactureComboWS(wb);
				System.out.println("DAO:MANUFACTURER :: vo.setStrManufactureComboWS(wb) size" + wb.size());
			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("SupplierTransactionRecordDAO.getmanufectuteName() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getInstituteList(SupplierTransactionRecordVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strproc_name = "{call PKG_MMS_VIEW.proc_institute_list(?,?,?,?)}"; // 4
		int nprocIndex = 0;

		String strErr = "";

		try {

			dao = new HisDAO("MMS Transactions", "SupplierTransactionRecordDAO");

			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1", 1);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(), 2);
			dao.setProcOutValue(nprocIndex, "err", 1, 3);
			dao.setProcOutValue(nprocIndex, "resultset", 2, 4);
			dao.executeProcedureByPosition(nprocIndex);
			strErr = dao.getString(nprocIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = dao.getWebRowSet(nprocIndex, "resultset");
				vo.setStrSupplierWs1(ws);
				System.out.println("DAO:PURCHASE THROUGH::vo.setStrSupplierWs1(ws) size" + ws.size());

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("LocalPurchaseNewTransDAO.getItemCatDtls() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}
	
	public static void getItemBrandName(SupplierTransactionRecordVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "SupplierTransactionRecordDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_storeitem_list(?,?,?,?,?,?,?,?,?)}"; // 9
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "2", 1);
			dao.setProcInValue(nprocIndex, "store_id",(vo.getStrStoreId() == null || vo.getStrStoreId().equals("")) ? "0" : vo.getStrStoreId(), 2);
			dao.setProcInValue(nprocIndex, "item_id",(vo.getStrItemId() == null || vo.getStrItemId().equals("")) ? "0" : vo.getStrItemId(), 3);
			dao.setProcInValue(nprocIndex, "cat_no",(vo.getStrItemCategoryId() == null || vo.getStrItemCategoryId().equals("")) ? "0": vo.getStrItemCategoryId(),4);
			dao.setProcInValue(nprocIndex, "group_id",(vo.getStrGroupId() == null || vo.getStrGroupId().equals("")) ? "0" : vo.getStrGroupId(), 5);
			dao.setProcInValue(nprocIndex, "sub_group_id",(vo.getStrSubGroupId() == null || vo.getStrSubGroupId().equals("")) ? "0" : vo.getStrSubGroupId(),6);
			dao.setProcInValue(nprocIndex, "hosp_code", "100", 7);
			dao.setProcOutValue(nprocIndex, "err", 1, 8);
			dao.setProcOutValue(nprocIndex, "resultset", 2, 9);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");

			if (strerr.equals("")) {
				vo.setStrItemBrandComboWS(wb);
				System.out.println("DAO:HIDDEN DRUG LIST :: vo.setStrItemBrandComboWS(wb) size" + wb.size());

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("SupplierTransactionRecordDAO.getItemBrandName() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void insert(SupplierTransactionRecordVO vo) {
		HisDAO daoObj = null;
		int funcIndex = 0;
		int nProcIndex = 0;

		String lpno;
		String strErr = "";
		int i;

		try {
			
			daoObj = new HisDAO("Local Purchase", "LocalPurchaseNewTransDAO");
			
			funcIndex = daoObj.setFunction("{? = call MMS_MST.generate_lp_no1(?,?,?,?)}");
			
			daoObj.setFuncInValue(funcIndex, 2, vo.getStrHospitalCode());
			daoObj.setFuncInValue(funcIndex, 3, vo.getStrStoreId());
			daoObj.setFuncInValue(funcIndex, 4, "22");
			daoObj.setFuncInValue(funcIndex, 5, "10");
			daoObj.setFuncOutValue(funcIndex, 1);
			daoObj.executeFunction_new(funcIndex);
			
			lpno = daoObj.getFuncString(funcIndex);
			vo.setStrLpoNo(lpno);

			for (i = 0; i < vo.getStrSearchDrug().length; i++) {
				
				System.out.println("Length of vo.getStrSearchDrug() array: " + vo.getStrSearchDrug().length);
				
				String strProcName = "{call Pkg_Mms_dml.dml_hstt_lp_dtl(?,?,?,?,?,  ?,?,?,?,?, ?,?,?,?,?,  ?,?,?,?,?, ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?)}"; // 33
																																					// variables
				nProcIndex = daoObj.setProcedure(strProcName);

				// PRINT DRUG LIST FIELDS
				System.out.println("DAO >> strSearchDrug: " + Arrays.toString(vo.getStrSearchDrug()));
				System.out.println("batchNo: " + Arrays.toString(vo.getStrBatchNo())); //
				System.out.println("mfgDate: " + Arrays.toString(vo.getMfgDate()));
				System.out.println("expDate: " + Arrays.toString(vo.getExpDate()));
				System.out.println("strPuRate: " + Arrays.toString(vo.getStrPuRate()));
				System.out.println("strPurQty: " + Arrays.toString(vo.getStrPurQty()));
				System.out.println("strGst: " + Arrays.toString(vo.getStrGst()));
				System.out.println("strAdm: " + Arrays.toString(vo.getStrAdm()));
				System.out.println("strPuRateWitTax: " + Arrays.toString(vo.getStrPuRateWitTax()));
				System.out.println("strPuRateWitTax: " + Arrays.toString(vo.getStrPuRateWitTax()));

		        System.out.println("strCosttoPat: " + Arrays.toString(vo.getStrCosttoPat()));
				
				daoObj.setProcInValue(nProcIndex, "modval", "3", 1);
				daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId(), 2);
				daoObj.setProcInValue(nProcIndex, "item_id", vo.getStrItemsIdTableArray()[i], 3);
				daoObj.setProcInValue(nProcIndex, "itembrand_id", vo.getStrBrandIdTableArray()[i], 4);
				daoObj.setProcInValue(nProcIndex, "batchsl_no", vo.getStrBatchNo()[i], 5);
				daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(), 6);
				daoObj.setProcInValue(nProcIndex, "item_cat_code", vo.getStrItemCategoryId(), 7);
				daoObj.setProcInValue(nProcIndex, "group_id", vo.getStrManufacturerId(), 8); // Pass ManufactreId Here
				daoObj.setProcInValue(nProcIndex, "subgroup_id",(vo.getStrExpDeliveryDate() == null || vo.getStrExpDeliveryDate().equals(""))
								? vo.getStrInvoiceDate()
								: vo.getStrExpDeliveryDate(),9); // Pass Expected Delivery Date
				daoObj.setProcInValue(nProcIndex, "supplier_id", vo.getStrSupplierId(), 10);
				daoObj.setProcInValue(nProcIndex, "qty", vo.getStrPurQty()[i], 11);
				daoObj.setProcInValue(nProcIndex, "qty_unitid", "0", 12);
				daoObj.setProcInValue(nProcIndex, "expdate", vo.getExpDate()[i], 13);
				daoObj.setProcInValue(nProcIndex, "mfgdate", vo.getMfgDate()[i] , 14);
				daoObj.setProcInValue(nProcIndex, "rate", vo.getStrPuRate()[i], 15);
				daoObj.setProcInValue(nProcIndex, "rate_unitid", "0", 16);
				daoObj.setProcInValue(nProcIndex, "saleprice", vo.getStrCosttoPat()[i], 17);
				daoObj.setProcInValue(nProcIndex, "saleprice_unitid", "0", 18);
				daoObj.setProcInValue(nProcIndex, "seat_id", vo.getStrSeatId(), 19);
				daoObj.setProcInValue(nProcIndex, "invno", vo.getStrInvoiceNo(), 20);
				daoObj.setProcInValue(nProcIndex, "invdate", vo.getStrInvoiceDate(), 21);
				daoObj.setProcInValue(nProcIndex, "remarks",
						(vo.getStrRemarks() == null || vo.getStrRemarks().equals("")) ? "-" : vo.getStrRemarks(), 22);
				daoObj.setProcInValue(nProcIndex, "dcno", vo.getStrDCNo(), 23);
				daoObj.setProcInValue(nProcIndex, "challan_date", vo.getStrChallanDate(), 24);
				daoObj.setProcInValue(nProcIndex, "adm_chg", vo.getStrAdm()[i], 25);
				daoObj.setProcInValue(nProcIndex, "tax", vo.getStrGst()[i], 26);

				daoObj.setProcInValue(nProcIndex, "packsize", "0", 27);
				daoObj.setProcInValue(nProcIndex, "packno", vo.getStrPoDate(), 28);
				daoObj.setProcInValue(nProcIndex, "transno", lpno, 29);
				daoObj.setProcInValue(nProcIndex, "pono", vo.getStrLpoNo(), 30);

				daoObj.setProcInValue(nProcIndex, "strUcChk", vo.getStrUcChk(), 31);
				daoObj.setProcInValue(nProcIndex, "strInstituteId",	vo.getStrInstituteId(), 32);
				daoObj.setProcInValue(nProcIndex, "mrp",	vo.getStrInstituteId(), 33);
				daoObj.setProcOutValue(nProcIndex, "err", 1, 34);
				daoObj.execute(nProcIndex, 1);
			}
			daoObj.fire();

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			if (strErr.equals("")) {
				
				vo.setStrMsgType("0");
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("SupplierTransactionRecordDAO.insert() --> " + e.getMessage());

			vo.setStrMsgType("1");
		}finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
		
	}
	
	public static void getPrintDetails(SupplierTransactionRecordVO vo) 
    {
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet ws = null;
		try 
		{
			dao = new HisDAO("mms", "SupplierTransactionRecordDAO");

			//System.out.println("..........PKG_MMS_VIEW2.PROC_NEW_HSTT_LP_DTL - 1  .........");
			//System.out.println("..........PKG_MMS_VIEW.PROC_HSTT_LP_DTL - 1  .........");
			System.out.println("..........[ PKG_MMS_VIEW.PROC_HSTT_SUPPLIER_RECEIPT_DTL Mode - 1].......");
			
			System.out.println("..........lpno ........."+vo.getStrLpoNo());
			System.out.println("..........hosp_code  ........."+vo.getStrHospitalCode());
			System.out.println("..........strId  ........."+vo.getStrStoreId());

			strproc_name = "{call PKG_MMS_VIEW.proc_hstt_Supplier_Receipt_dtl(?,?,?,?,? ,?)}";
			nprocIndex = dao.setProcedure(strproc_name);			
			
			dao.setProcInValue(nprocIndex, "modval", 	"1",1);
			dao.setProcInValue(nprocIndex, "strId", 	vo.getStrStoreId(),2);
			dao.setProcInValue(nprocIndex, "lpno", 		vo.getStrLpoNo(),3);        //  Generated No
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),4);	
			dao.setProcOutValue(nprocIndex, "err", 		1,5);
			dao.setProcOutValue(nprocIndex, "resultset", 2,6);
			
			dao.executeProcedureByPosition(nprocIndex);
			
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {
				ws = dao.getWebRowSet(nprocIndex, "resultset");		
				System.out.println("....PROC_HSTT_SUPPLIER_RECEIPT_DTL--WS SIZE--"+ws.size());

				vo.setWsPrint(ws);							
			} else {
				throw new Exception(strerr);
			}	

		} catch (Exception e) {
			vo.setStrMsgString("SupplierTransactionRecordDAO.getPrintDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getIssueDtlsList(SupplierTransactionRecordVO vo) 
	{
		String err;
		//String strSlNoflg;
		HisDAO        dao = null;
		WebRowSet      ws = null;
		int    procIndex1 = 0;
		String proc_name1 = "{call pkg_mms_view.Proc_Emp_Issue_Detail(?,?,?,?,?,?)}"; //6
		try 
		{
			System.out.println(" ------- SupplierTransactionRecordDAO.getIssueDtlsList  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_Emp_Issue_Detail  --[ Mode- 5 ]------ ");
				
			dao = new HisDAO("mms","SupplierTransactionRecordDAO");			
			procIndex1 = dao.setProcedure(proc_name1);
			// set value
			dao.setProcInValue(procIndex1, "modeval", 		"5",1);
			dao.setProcInValue(procIndex1, "strId", 		vo.getStrStoreId(),3);			
			dao.setProcInValue(procIndex1, "issueNo", 		vo.getStrInvoiceNo(),2);
			dao.setProcInValue(procIndex1, "hosp_code", 	vo.getStrHospitalCode(),4);
			dao.setProcOutValue(procIndex1,"ERR", 			1,5); // 1 for string return
			dao.setProcOutValue(procIndex1, "RESULTSET", 	2,6); // 2 for object
			// execute procedure
			dao.executeProcedureByPosition(procIndex1);
			// get value
			err = dao.getString(procIndex1, "ERR");
			if (err == null)
				err = "";
			ws = dao.getWebRowSet(procIndex1, "RESULTSET");
			vo.setItemWS(ws);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("SupplierTransactionRecordDAO.getIssueDtlsList() --> "+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getItemList(SupplierTransactionRecordVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_itembrand_list(?,?,?,?,? ,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions", "LocalPurchaseNewTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			if (!voObj.getStrReqTypeId().equals("0")) {
				daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
			} else {
				daoObj.setProcInValue(nProcIndex, "modeval", "8", 1);
			}
			daoObj.setProcInValue(nProcIndex, "catcode", voObj.getStrReqTypeId(), 2);
			daoObj.setProcInValue(nProcIndex, "branditem_id", "0", 3);
			daoObj.setProcInValue(nProcIndex, "grpid", "0", 4);
			daoObj.setProcInValue(nProcIndex, "subgrpid", "0", 5);
			daoObj.setProcInValue(nProcIndex, "setflag", "0", 6);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 7);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 8);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 9);

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
			voObj.setStrMsgString("LocalPurchaseNewTransDAO.getItemCatDtls() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void getReceivedItemListTwo(SupplierTransactionRecordVO vo) {
		String strProcName = "{call pkg_mms_view.proc_receivedItem_dtl(?,?,?,?,?,?,?,?)}"; // 4+4=8

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {
			daoObj = new HisDAO("Gifted Item Details", "SupplierTransactionRecordDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			if (vo.getStrStatus().equals("4")) {
				daoObj.setProcInValue(nProcIndex, "modeval", "4");
			} else {
				daoObj.setProcInValue(nProcIndex, "modeval", "5");
			}
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			/* Start Adding Default value*/
			daoObj.setProcInValue(nProcIndex, "item_cat_code", "1");
			daoObj.setProcInValue(nProcIndex, "storeid", "");
			daoObj.setProcInValue(nProcIndex, "fin_st_date", "");
			daoObj.setProcInValue(nProcIndex, "fin_end_date", "");
			/* End Adding Default value*/

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {
				vo.setWsReceivedItemList(ws);
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("SupplierTransactionRecordDAO.itemCategory() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	
	// voucher
	public static void getReceivedItemListIndividual(SupplierTransactionRecordVO vo) {
		String strProcName = "{call pkg_mms_view.proc_receivedItem_dtl_individual(?,?,?,?, ?,?,?,?,?)}"; // 9

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {
			daoObj = new HisDAO("Received Item Details", "SupplierTransactionRecordDAO");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval",
					(vo.getStrMode() != null && !vo.getStrMode().equals("")) ? vo.getStrMode() : "1", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(), 2);
			daoObj.setProcInValue(nProcIndex, "storeid", vo.getStrStoreId(), 4);
			daoObj.setProcInValue(nProcIndex, "item_cat_code", vo.getStrItemCategoryId(), 3);
			daoObj.setProcInValue(nProcIndex, "fin_st_date", vo.getStrFinancialStartYear(), 5);
			daoObj.setProcInValue(nProcIndex, "fin_end_date", vo.getStrFinancialEndYear(), 6);
			daoObj.setProcInValue(nProcIndex, "received_no", vo.getReceiveNo(), 7);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 8);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 9);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null) {
				strErr = "";
			}

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {
				// Set the received item list to the VO
				vo.setWsReceivedItemListIndividual(ws);
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("SupplierTransactionRecordDAO.getReceivedItemListIndividual() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			try {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void initAddQuery(SupplierTransactionRecordVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {

			dao = new HisDAO("mms", "SupplierTransactionRecordDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_store_group_list(?,?,?,?,?,?,?)}"; // 5+2=7
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "2", 1);
			dao.setProcInValue(nprocIndex, "item_category", vo.getStrItemCategoryNo(), 3);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(), 2);
			dao.setProcOutValue(nprocIndex, "err", 1, 6);
			dao.setProcOutValue(nprocIndex, "resultset", 2, 7);

			/* Start Adding Default value*/
			dao.setProcInValue(nprocIndex, "strPhyStockNo", "", 4);
			dao.setProcInValue(nprocIndex, "strStoreId", "", 5);
			/* End Adding Default value*/

			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");

			if (strerr.equals("")) {
				vo.setStrGroupComboWs(wb);

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			vo.setStrMsgString("SupplierTransactionRecordDAO.initAddQuery() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getSubGroupList(SupplierTransactionRecordVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "SupplierTransactionRecordDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_store_subgroup_list(?,?,?,?,?)}"; // 5
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "1", 1);
			dao.setProcInValue(nprocIndex, "group_id", vo.getStrGroupId(), 2);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(), 3);
			dao.setProcOutValue(nprocIndex, "err", 1, 4);
			dao.setProcOutValue(nprocIndex, "resultset", 2, 5);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");

			if (strerr.equals("")) {
				vo.setStrSubGroupComboWs(wb);

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {

			e.printStackTrace();

			vo.setStrMsgString("SupplierTransactionRecordDAO.getSubGroupList() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getGenericItemList(SupplierTransactionRecordVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "SupplierTransactionRecordDAO");

			strproc_name = "{call PKG_MMS_VIEW.proc_storeitem_list(?,?,?,?,?,?,?,?,?)}";// 7+2=9
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "1");
			dao.setProcInValue(nprocIndex, "cat_no", vo.getStrItemCategoryNo());
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "group_id", vo.getStrGroupId());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);

			/* Start Adding Default value*/
			dao.setProcInValue(nprocIndex, "item_id", "0");
			dao.setProcInValue(nprocIndex, "sub_group_id", "0");
			/* End Adding Default value*/

			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");

			if (strerr.equals("")) {
				vo.setStrItemNameComboWS(wb);

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			vo.setStrMsgString("SupplierTransactionRecordDAO.getGenericItemList() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

	public static void getItemName(SupplierTransactionRecordVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "SupplierTransactionRecordDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_storeitem_list(?,?,?,?,?,?,?,?,?)}"; // 8+1=9
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1", 1);
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId(), 2);
			dao.setProcInValue(nprocIndex, "item_id", "0", 3); // default set for item_id
			dao.setProcInValue(nprocIndex, "cat_no", vo.getStrItemCategoryNo(), 4);
			dao.setProcInValue(nprocIndex, "group_id", vo.getStrGroupId(), 5);
			dao.setProcInValue(nprocIndex, "sub_group_id", vo.getStrSubGroupId(), 6);
			// Passing 100 as Global hospital code,if get from vo object it would get
			// session code which is 101->not work -Priyesh
			dao.setProcInValue(nprocIndex, "hosp_code", "100", 7);

			dao.setProcOutValue(nprocIndex, "err", 1, 8);
			dao.setProcOutValue(nprocIndex, "resultset", 2, 9);

			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");

			if (strerr.equals("")) {
				vo.setStrItemNameComboWS(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("SupplierTransactionRecordDAO.getItemName() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getBrandDetails(SupplierTransactionRecordVO vo) {

		HisDAO dao = null;

		try {

			dao = new HisDAO("mms", "SupplierTransactionRecordDAO");

			String strFuncName = "{? = call mms_mst.get_brand_ResFlag(?::numeric, ?::numeric, ?::numeric)}"; // 4

			int nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrItemBrandId().split("\\$")[0]);
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction_new(nFuncIndex);

			String strRegFlag = dao.getFuncNumeric(nFuncIndex).toString();

			vo.setStrRegFlag(strRegFlag);

			String strFuncName2 = "{? = call mms_mst.get_brand_dtl(?::numeric, ?::numeric, ?::numeric)}";

			int nFuncIndex2 = dao.setFunction(strFuncName2);
			dao.setFuncInValue(nFuncIndex2, 2, "1");
			dao.setFuncInValue(nFuncIndex2, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex2, 4, vo.getStrItemBrandId().split("\\$")[0]);
			dao.setFuncOutValue(nFuncIndex2, 1);
			dao.executeFunction(nFuncIndex2);

			String strBrandDetails = dao.getFuncString(nFuncIndex2);

			vo.setStrBrandDetails(strBrandDetails);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("SupplierTransactionRecordDAO.getBrandDetails() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getWarrantyManufList(SupplierTransactionRecordVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "SupplierTransactionRecordDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}"; // 5+2=7
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "14");
			dao.setProcInValue(nprocIndex, "catCode", vo.getStrItemCategoryNo());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);

			/* Start Adding Default value*/
			dao.setProcInValue(nprocIndex, "branditem_id", "0");
			dao.setProcInValue(nprocIndex, "contractType", "0");
			/* End Adding Default value*/

			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {
				// //System.out.println("DAO -->" + wb.size());
				vo.setStrWarrantyManufactureComboWS(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("SupplierTransactionRecordDAO.getWarrantyManufList() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getCurrencyList(SupplierTransactionRecordVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "SupplierTransactionRecordDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_currency_list(?,?,?,?,?)}"; // 4+1=5
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "1", 1);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(), 2);
			dao.setProcOutValue(nprocIndex, "err", 1, 4);
			dao.setProcOutValue(nprocIndex, "resultset", 2, 5);

			dao.setProcInValue(nprocIndex, "isDefault", "0", 3); // default set for isDefault

			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {

				vo.setStrCurrencyCodeWs(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("SupplierTransactionRecordDAO.getCurrencyList() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getStockStatusList(SupplierTransactionRecordVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "SupplierTransactionRecordDAO");

			if (vo.getStrItemCategoryNo().equals("10")) {
				strproc_name = "{call PKG_MMS_VIEW.proc_stock_status_list(?,?,?,?,?,?)}"; // 6
			} else {
				strproc_name = "{call PKG_MMS_VIEW.proc_stock_status_list(?,?,?,?,?,?)}"; // 5+1=6
			}

			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval",
					(vo.getStrMode() != null && !vo.getStrMode().equals("")) ? vo.getStrMode() : "1", 1);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(), 2);

			if (vo.getStrItemCategoryNo().equals("10")) {
				dao.setProcInValue(nprocIndex, "itemCat", vo.getStrItemCategoryNo(), 3);
			} else {
				dao.setProcInValue(nprocIndex, "itemCat", "0", 3);
			}
			dao.setProcInValue(nprocIndex, "itemBrandId", vo.getStrItemBrandId().split("\\$")[0], 4);
			dao.setProcOutValue(nprocIndex, "err", 1, 5);
			dao.setProcOutValue(nprocIndex, "resultset", 2, 6);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {

				vo.setStrStockStatusWs(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("SupplierTransactionRecordDAO.getStockStatusList() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getmanufectuteName(SupplierTransactionRecordVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "SupplierTransactionRecordDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}"; // 6+1=7
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "14", 1);
			dao.setProcInValue(nprocIndex, "catCode", vo.getStrItemCategoryNo(), 2);
			dao.setProcInValue(nprocIndex, "branditem_id", vo.getStrItemBrandId(), 3);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(), 5);
			dao.setProcOutValue(nprocIndex, "err", 1, 6);
			dao.setProcOutValue(nprocIndex, "resultset", 2, 7);

			dao.setProcInValue(nprocIndex, "contractType", "0", 4); // default set for contractType

			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {
				// //System.out.println("DAO -->" + wb.size());
				vo.setStrManufactureComboWS(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("SupplierTransactionRecordDAO.getmanufectuteName() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/*	public synchronized static void insert_old(SupplierTransactionRecordVO vo) {
	
			String strProcName = "";
			String strproc_name = "";	
	
			int nProcIndex = 0;
			int nprocIndex = 0;		
	
			HisDAO daoObj = null;
			boolean flag = false;
			ItemParameterDetailDAO itemParameterDetailDAO = null;
			
			ReceivedFromThirdPartyItemDtlsDAO receivedItemDtlDAO = null; 
			try 
			{
				System.out.println("------------------- SupplierTransactionRecordDAO.insert -------------------------");
				daoObj = new HisDAO("MMS", "SupplierTransactionRecordDAO");
				itemParameterDetailDAO = new ItemParameterDetailDAO();
				
				receivedItemDtlDAO = new ReceivedFromThirdPartyItemDtlsDAO();
				
				System.out.println("Brand Id---"+vo.getStrItemBrandId());
				
				
				 * When No Group No Generic Name Selected From Page
				 * 
				 * 
				if((vo.getStrGroupId()==null||vo.getStrGroupId().equals("")||vo.getStrGroupId().equals("0"))&&(vo.getStrItemId()==null||vo.getStrItemId().equals("")||vo.getStrItemId().equals("0")))
				{
					// HSTNUM_ITEMBRAND_ID||''$''||hstnum_item_id||''$''||hstnum_grp_id||''$''||NVL(sstnum_item_cat_no,0)
					
					vo.setStrItemId(vo.getStrItemBrandId().split("\\$")[1]);
					vo.setStrGroupId(vo.getStrItemBrandId().split("\\$")[2]);	
					vo.setStrItemBrandId(vo.getStrItemBrandId().split("\\$")[0]);
				}		
				else
				{
					vo.setStrItemBrandId(vo.getStrItemBrandId().split("\\$")[0]);
				}
				System.out.println("---------------------------------------");
				System.out.println("-vo.getStrBatchNo()--------"+vo.getStrBatchNo());
				System.out.println("-vo.getStrMRPPrice()-------"+vo.getStrMRPPrice());
				System.out.println("-vo.getStrItemBrandId()----"+vo.getStrItemBrandId());
				System.out.println("-vo.getStrItemId()---------"+vo.getStrItemId());
				System.out.println("-vo.getStrGroupId()--------"+vo.getStrGroupId());
				System.out.println("---------------------------------------");
				
				System.out.println("vo.setStrGstTax(formBean.getStrGstTax());"			+vo.getStrGstTax());
				System.out.println("vo.setStrRatewithGst(formBean.getStrRatewithGst());"+vo.getStrRatewithGst());
				System.out.println("vo.setStrAdminTax(formBean.getStrAdminTax());"		+vo.getStrAdminTax());
				
				receivedItemDtlDAO.setStrStoreId(vo.getStrStoreId());
				receivedItemDtlDAO.setStrItemId(vo.getStrItemId());
				receivedItemDtlDAO.setStrBrandId(vo.getStrItemBrandId());
				//receivedItemDtlDAO.setStrBatchNo(vo.getStrInstituteId().equals("108")?vo.getStrBatchNo()+"~LP":vo.getStrBatchNo());  // Orignal Code
				receivedItemDtlDAO.setStrBatchNo(vo.getStrBatchNo());
				receivedItemDtlDAO.setStrHospitalCode(vo.getStrHospitalCode());
				receivedItemDtlDAO.setStrStockStatus(vo.getStrStockStatus());
				//receivedItemDtlDAO.setStrInstituteCode(vo.getStrInstituteId().replace("^", "#").split("#")[0]);  Orignal value
				receivedItemDtlDAO.setStrInstituteCode(vo.getStrInstituteId());
				receivedItemDtlDAO.setStrItemCatCode(vo.getStrItemCategoryNo());
				receivedItemDtlDAO.setStrGroupId(vo.getStrGroupId());
				receivedItemDtlDAO.setStrSubGroupId(vo.getStrSubGroupId());
				receivedItemDtlDAO.setStrManufacturerId(vo.getStrManufacturerId());
				receivedItemDtlDAO.setStrReceivedQuantity(vo.getStrInHandQuantity());
				receivedItemDtlDAO.setStrReceivedQuantityUnitId(vo.getStrInHandQuantityUnitID());
				receivedItemDtlDAO.setStrManufacturerDate(vo.getStrManufactureDate());
				receivedItemDtlDAO.setStrExpiryDate(vo.getStrExpiryDate());
				receivedItemDtlDAO.setStrRate(vo.getStrRate());
				receivedItemDtlDAO.setStrRateUnitId(vo.getStrUnitRateID());
				receivedItemDtlDAO.setStrCurrencyID(vo.getStrCurrencyCode());
				receivedItemDtlDAO.setStrCurrencyValue(vo.getStrCurrencyValue());
				receivedItemDtlDAO.setStrFinancialStartYear(vo.getStrFinancialStartYear());
				receivedItemDtlDAO.setStrFinancialEndYear(vo.getStrFinancialEndYear());
				receivedItemDtlDAO.setStrRemarks(vo.getStrRemarks());
				receivedItemDtlDAO.setStrSeatId(vo.getStrSeatId());
				receivedItemDtlDAO.setStrReceivedDate(vo.getStrReceivedDate());
				receivedItemDtlDAO.setStrSuppliedBy(vo.getStrSuppliedBy());
				
				receivedItemDtlDAO.setStrGstTax(vo.getStrGstTax());
				receivedItemDtlDAO.setStrRatewithGst(vo.getStrRatewithGst());
				receivedItemDtlDAO.setStrAdminTax(vo.getStrAdminTax());
				receivedItemDtlDAO.setStrMRPPrice(vo.getStrMRPPrice());
	
	
				receivedItemDtlDAO.insert(daoObj);  // PKG_MMS_DML.dml_received_item_dtls [ Mode - 1 ]
				
				Date date = new Date();  
			    SimpleDateFormat formatter =  new SimpleDateFormat("ddMMYYHHMM");  
			    String strDate = formatter.format(date);
				strProcName = "{call PKG_MMS_DML.Dml_Stock_Update(?,?,?,?,? ,?,?,?,?,?  ,?,?,?,?,?,  ?,?,?,?,? ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?,  ?,?,?,?,? ,?,?,?,?,?,  ?,?,?,?)}"; //33+21=54
	
				nProcIndex = daoObj.setProcedure(strProcName);
				
				daoObj.setProcInValue(nProcIndex, "modval",             "1",1);
				daoObj.setProcInValue(nProcIndex, "strid", 				vo.getStrStoreId(),2);
				daoObj.setProcInValue(nProcIndex, "itemid", 			vo.getStrItemId(),3);
				daoObj.setProcInValue(nProcIndex, "itembrandid", 		vo.getStrItemBrandId(),4);
				//daoObj.setProcInValue(nProcIndex, "batchno", 			vo.getStrInstituteId().equals("108")?vo.getStrBatchNo()+"~LP":vo.getStrBatchNo()+"~"+strDate,5); // Orignal Code
				daoObj.setProcInValue(nProcIndex, "batchno", 			vo.getStrBatchNo(),5);  
				daoObj.setProcInValue(nProcIndex, "itemcatno", 			vo.getStrItemCategoryNo(),6);
				daoObj.setProcInValue(nProcIndex, "groupid", 			vo.getStrGroupId(),7);
				daoObj.setProcInValue(nProcIndex, "subgroupid", 		vo.getStrSubGroupId(),8);
				daoObj.setProcInValue(nProcIndex, "expirydate", 		vo.getStrExpiryDate(),9);
				daoObj.setProcInValue(nProcIndex, "manufdate", 			vo.getStrManufactureDate(),10);
				daoObj.setProcInValue(nProcIndex, "stockstatuscode",	vo.getStrStockStatus(),11);
				daoObj.setProcInValue(nProcIndex, "inventoryflag", 		"0",12);
				daoObj.setProcInValue(nProcIndex, "inhandqty", 			vo.getStrInHandQuantity(),13);
				daoObj.setProcInValue(nProcIndex, "inhandqtyunitid",	vo.getStrInHandQuantityUnitID(),14);
				daoObj.setProcInValue(nProcIndex, "suppid", 			vo.getStrManufacturerId(),15);
				daoObj.setProcInValue(nProcIndex, "rate", 				vo.getStrRate(),16);
				daoObj.setProcInValue(nProcIndex, "rateunitid", 		vo.getStrUnitRateID(),17);
				daoObj.setProcInValue(nProcIndex, "saleprice", 			vo.getStrSalePrice(),18);
				daoObj.setProcInValue(nProcIndex, "salepriceunitid",	vo.getStrUnitSaleID(),19);
				daoObj.setProcInValue(nProcIndex, "suppliedBy", 		vo.getStrSuppliedBy(),23);
				daoObj.setProcInValue(nProcIndex, "recievedDate", 		vo.getStrReceivedDate(),24);
				daoObj.setProcInValue(nProcIndex, "seatid", 			vo.getStrSeatId(),22);
				daoObj.setProcInValue(nProcIndex, "hosp_code", 			vo.getStrHospitalCode(),27);
				daoObj.setProcInValue(nProcIndex, "description",		"Received from Third Party : "+vo.getStrReceivedFromThirdPartyName()+" With Qty - "+vo.getStrInHandQuantity(),42);
				daoObj.setProcInValue(nProcIndex, "currencyCode", 		vo.getStrCurrencyCode(),25);
				daoObj.setProcInValue(nProcIndex, "currencyValue", 		vo.getStrCurrencyValue(),28);
				
				if (vo.getStrItemOtherDtls() != null && vo.getStrItemOtherDtls().length > 0) {
					daoObj.setProcInValue(nProcIndex, "freeItemFlag", "1", 26);
				} else {
					daoObj.setProcInValue(nProcIndex, "freeItemFlag", "0", 26);
				}
	
				if (vo.getStrItemPartDtls() != null && vo.getStrItemPartDtls().length > 0) {
					daoObj.setProcInValue(nProcIndex, "partFlag", "1", 36);
				} else {
					daoObj.setProcInValue(nProcIndex, "partFlag", "0", 36);
				}
	
				if (vo.getStrWarrantyFlag().equals("1")) {
					daoObj.setProcInValue(nProcIndex, "warrentyFlag", "1", 37);
				} else {
					daoObj.setProcInValue(nProcIndex, "warrentyFlag", "0", 37);
				}
	
				if (vo.getStrItemParamDtls() != null && vo.getStrItemParamDtls().length > 0) {
					daoObj.setProcInValue(nProcIndex, "itemParamFlag", "1", 35);
				} else {
					daoObj.setProcInValue(nProcIndex, "itemParamFlag", "0", 35);
				}
	
				 Start Adding Default value
				
				  daoObj.setProcInValue(nProcIndex, "pono", 				"0",20); 
				  daoObj.setProcInValue(nProcIndex, "podate", 				"",21);
			      daoObj.setProcInValue(nProcIndex, "old_stockstatuscode", 	"1",29);  
			      daoObj.setProcInValue(nProcIndex, "old_batchno", 			"0",30);
			      daoObj.setProcInValue(nProcIndex, "old_itemserialno", 	"0",31);
			      daoObj.setProcInValue(nProcIndex, "old_itemid", 			"0",32);
			      daoObj.setProcInValue(nProcIndex, "old_itembrandid", 		"0",33);
			      daoObj.setProcInValue(nProcIndex, "old_strid", 			"0",34);
			      daoObj.setProcInValue(nProcIndex, "tostrid", 				"",38);
			      daoObj.setProcInValue(nProcIndex, "reservedflag", 		"0",39);
			      daoObj.setProcInValue(nProcIndex, "transno", 				"64000001",40);
			      daoObj.setProcInValue(nProcIndex, "transdate", 			vo.getStrReceivedDate(),41);
			      daoObj.setProcInValue(nProcIndex, "reqtypeid", 			"64",43);
			      daoObj.setProcInValue(nProcIndex, "blockqtyflag", 		"0",44);
			      daoObj.setProcInValue(nProcIndex, "blockedqty", 			"0",45);
			      daoObj.setProcInValue(nProcIndex, "blockedqtyunitid", 	"0",46);
			      daoObj.setProcInValue(nProcIndex, "releaseqty", 			"0",47);
			      daoObj.setProcInValue(nProcIndex, "releaseqtyunitid", 	"0",48);
			      daoObj.setProcInValue(nProcIndex, "invoiceNo", 			"" ,49);
			      daoObj.setProcInValue(nProcIndex, "invoiceDate", 			"" ,50); 
			      daoObj.setProcInValue(nProcIndex, "item_serialNoFlag", 	"1",51);
			       End Adding Default value			
			      daoObj.setProcInValue(nProcIndex, "item_specification", vo.getStrItemSpecification(),52);
			    
			       
			      daoObj.setProcInValue(nProcIndex, "gsttax", 		vo.getStrGstTax(),53);
				  daoObj.setProcInValue(nProcIndex, "ratewithgst", 	vo.getStrRatewithGst(),54);
				  daoObj.setProcInValue(nProcIndex, "admintax", 	vo.getStrAdminTax(),55);
				   
			      
				  daoObj.setProcOutValue(nProcIndex, "retSerialNo", 		1,53);
			  	  daoObj.setProcOutValue(nProcIndex, "err", 				1,54);
	
				  daoObj.execute(nProcIndex, 1);
		
			      strproc_name = "{call PKG_MMS_DML.Update_Rac_CurrStock(?,?,?,?,?, ?,?,?,?,?, ?)}"; // 11 variables
			   				
				  nprocIndex = daoObj.setProcedure(strproc_name);
				  daoObj.setProcInValue(nprocIndex,  "modval", 			"1",1);                 //1
				  daoObj.setProcInValue(nprocIndex,  "strid", 			vo.getStrStoreId(),5);   //2
				  daoObj.setProcInValue(nprocIndex,  "itemid", 			vo.getStrItemId(),8);   //3
				  daoObj.setProcInValue(nprocIndex,  "itembrandid", 	vo.getStrItemBrandId(),7);//4
				  daoObj.setProcInValue(nprocIndex,  "batchno", 		vo.getStrBatchNo(),6);        //5
				  daoObj.setProcInValue(nprocIndex,  "hosp_code", 		vo.getStrHospitalCode(),2); //6
				  daoObj.setProcInValue(nprocIndex,  "item_cat_no", 	vo.getStrItemCategoryNo(),3);//7
				
				  String stockStatus = vo.getStrStockStatus() + "^" + vo.getStrGstTax() + "^" + vo.getStrRatewithGst() + "^" + vo.getStrAdminTax() + "^" + vo.getStrSalePrice() +"^"+vo.getStrRate();
				  System.out.println("stockStatus String"+stockStatus);
				  daoObj.setProcInValue(nprocIndex, "stockstatuscode", stockStatus, 4); //8s
	
				  daoObj.setProcInValue(nprocIndex,  "rackNumber", 		(vo.getStrMRPPrice()==null?"0":vo.getStrMRPPrice()),9);//9
				  daoObj.setProcInValue(nprocIndex,  "old_itemserialno",  "0",10);//10
				  daoObj.setProcOutValue(nprocIndex, "err", 				1,11);//11
				  //dao.executeProcedureByPosition(nprocIndex);
				  daoObj.execute(nprocIndex, 1);
			    
			
			      daoObj.fire();
			      
	          String strSlNo = daoObj.getString(nProcIndex, "retSerialNo");
				  
				  System.out.println("strSlNo");
	
			     if (strSlNo != null)
				 vo.setStrSerialNo(strSlNo);
	
			} catch (Exception e) {
				e.printStackTrace();
				vo.setStrMsgString("SupplierTransactionRecordDAO.update() --> "
						+ e.getMessage());
				vo.setStrMsgType("1");
			} 
			finally 
			{
				if (daoObj != null) 
				{
					daoObj.free();
					daoObj = null;
	
				}
				itemParameterDetailDAO = null;
			}
	
		}
		*/
	
	
	/*
		public static void updateCurrStock(SupplierTransactionRecordVO vo, HisDAO dao) {
	
			String strproc_name = "";
			int nprocIndex = 0;
			try {
				dao = new HisDAO("mms", "DrugInventoryTransDAO");
				strproc_name = "{call PKG_MMS_DML.Update_Rac_CurrStock(?,?,?,?,?,?,?,?,?,?,?)}"; // 11 variables
	
				nprocIndex = dao.setProcedure(strproc_name);
				dao.setProcInValue(nprocIndex, "modval", "1", 1); // 1
				dao.setProcInValue(nprocIndex, "strid", vo.getStrStoreId(), 5); // 2
				dao.setProcInValue(nprocIndex, "itemid", vo.getStrItemId(), 8); // 3
				dao.setProcInValue(nprocIndex, "itembrandid", vo.getStrItemBrandId(), 7);// 4
				dao.setProcInValue(nprocIndex, "batchno", vo.getStrBatchNo(), 6); // 5
				dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(), 2); // 6
				dao.setProcInValue(nprocIndex, "item_cat_no", vo.getStrItemCategoryNo(), 3);// 7
				dao.setProcInValue(nprocIndex, "stockstatuscode", vo.getStrStockStatus(), 4); // 8
				dao.setProcInValue(nprocIndex, "rackNumber", (vo.getStrRackNumber() == null ? "0" : vo.getStrRackNumber()),
						9);// 9
				dao.setProcInValue(nprocIndex, "old_itemserialno", "0", 10);// 10
				dao.setProcOutValue(nprocIndex, "err", 1, 11);// 11
				// dao.executeProcedureByPosition(nprocIndex);
				dao.execute(nprocIndex, 1);
	
			} catch (Exception e) {
				e.printStackTrace();
				vo.setStrMsgString("SupplierTransactionRecordDAO.updateCurrStock() --> " + e.getMessage());
				vo.setStrMsgType("1");
			}
	
		}
	*/
	
	public static void unitNameCombo(SupplierTransactionRecordVO vo) {
		String strFuncName = "";
		String strProcName = "";

		int nFuncIndex = 0;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;
		String strUnitRate = "";

		try {

			daoObj = new HisDAO("ItemInventoryTrans", "SupplierTransactionRecordDAO");
			strFuncName = "{? = call mms_mst.get_inventory_unitid(?::numeric, ?::numeric, ?::numeric, ?::numeric)}"; // 5
			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}"; // 5+1=6

			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, "1");
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 4, vo.getStrItemCategoryNo());
			daoObj.setFuncInValue(nFuncIndex, 5, vo.getStrItemId());
			;
			daoObj.setFuncOutValue(nFuncIndex, 3);
			daoObj.executeFuncForNumeric(nFuncIndex);
			strUnitRate = daoObj.getFuncNumeric(nFuncIndex).toString();
			vo.setStrUnitRateID(strUnitRate);

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(), 1);
			daoObj.setProcInValue(nProcIndex, "unit_id", vo.getStrUnitRateID(), 2);
			daoObj.setProcInValue(nProcIndex, "modeval", "1", 4);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 6);

			daoObj.setProcInValue(nProcIndex, "module_id", "", 3); // Defaut set for module_id

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setStrUnitRateComboWS(ws);

			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("SupplierTransactionRecordDAO.unitNameCombo() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void unitInHandNameCombo(SupplierTransactionRecordVO vo) {

		String strProcName = "";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {

			daoObj = new HisDAO("ItemInventoryTrans", "SupplierTransactionRecordDAO");

			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}"; // 5+1=6

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "unit_id", vo.getStrInHandQuantityUnitID());
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.setProcInValue(nProcIndex, "module_id", ""); // Defaut set for module_id

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {

				vo.setStrUnitNameComboWS(ws);

			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("SupplierTransactionRecordDAO.unitInHandNameCombo() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void unitSaleNameCombo(SupplierTransactionRecordVO vo) {

		String strProcName = "";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {

			daoObj = new HisDAO("ItemInventoryTrans", "SupplierTransactionRecordDAO");

			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}"; // 5+1=6

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "unit_id", vo.getStrUnitSaleID());
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.setProcInValue(nProcIndex, "module_id", ""); // Defaut set for module_id

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {

				vo.setStrUnitSaleComboWS(ws);

			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("SupplierTransactionRecordDAO.unitSaleNameCombo() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void unitRateNameCombo(SupplierTransactionRecordVO vo) {

		String strProcName = "";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {

			daoObj = new HisDAO("ItemInventoryTrans", "SupplierTransactionRecordDAO");

			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}"; // 5+1=6

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "unit_id", vo.getStrUnitRateID());
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.setProcInValue(nProcIndex, "module_id", ""); // Defaut set for module_id

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {

				vo.setStrUnitRateComboWS(ws);

			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("SupplierTransactionRecordDAO.unitRateNameCombo() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/*public static void getVoucherDtl(SupplierTransactionRecordVO vo) {
		String strProcName = "{call pkg_mms_view.proc_Ret_And_Condemn_Register(?,?,?,?,?,?,?,?,?)}"; // 9 variables
	
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;
		try {
	
			daoObj = new HisDAO("mms", "SupplierTransactionRecordDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
	
			daoObj.setProcInValue(nProcIndex, "modeval", "3", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(), 2);
			daoObj.setProcInValue(nProcIndex, "storeId", vo.getStrStoreId(), 3);
			daoObj.setProcInValue(nProcIndex, "itemCatg", vo.getStrItemCategoryId(), 4);
	//			daoObj.setProcInValue(nProcIndex, "orderNo", 	(vo.getStrDebitNoteNo()==null||vo.getStrDebitNoteNo().equals(""))?"0":vo.getStrDebitNoteNo(),5);
			daoObj.setProcInValue(nProcIndex, "brandId",
					(vo.getStrItemBrandId() == null || vo.getStrItemBrandId().equals("")) ? "0"
							: vo.getStrItemBrandId(),
					6);
			daoObj.setProcInValue(nProcIndex, "batchNo", vo.getStrBatchNo(), 7);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 8);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 9);
			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
	//				vo.setWsNOSQItemDetail(ws);				
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("SupplierTransactionRecordDAO.getNOSQDrugList() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	*/
}
