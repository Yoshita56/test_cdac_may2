package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.dao.AdvanceRequestDAO;
import mms.transactions.vo.AdvanceRequestTransVO;

public class AdvanceRequestTransDAO {
	
	public static void getStoreList(AdvanceRequestTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","AdvanceRequestTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeid", "0");
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
		
				voObj.setStrStoreWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("AdvanceRequestTransDAO.getStoreList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	
	public static void getItemCatDtls(AdvanceRequestTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","AdvanceRequestTransDAO");

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

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrItemCatWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("AdvanceRequestTransDAO.getItemCatDtls() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	public static void getPONODtls(AdvanceRequestTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_pono_dtl(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","AdvanceRequestTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "itemcat_no", voObj.getStrItemCategoryId());
			daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStoreId());
					
			if(voObj.getStrChkAdvanceReq().equals("1")){
				
			
				
				daoObj.setProcInValue(nProcIndex, "modeval", "1");
				
				
			}else{
								
				daoObj.setProcInValue(nProcIndex, "modeval", "5");
				
			}
			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				
		
				voObj.setStrPONOWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("AdvanceRequestTransDAO.getPONODtls() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	public static void getPODetails(AdvanceRequestTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_po_details(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","AdvanceRequestTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			
			daoObj.setProcInValue(nProcIndex, "poNo", voObj.getStrPONO());
			daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrPOStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrPODtlsWs(ws);
				
				//System.out.println("ws size--->"+ws.size());
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("AdvanceRequestTransDAO.getPODetails() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	public static void getBankDetails(AdvanceRequestTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_po_details(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","AdvanceRequestTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "3");
			
			daoObj.setProcInValue(nProcIndex, "poNo", voObj.getStrPONO());
			daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrBankDtlsWs(ws);
				
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("AdvanceRequestTransDAO.getBankDetails() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	public static void getReqDetails(AdvanceRequestTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_request_details(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","AdvanceRequestTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "itemcat_no", voObj.getStrItemCatDup());
			daoObj.setProcInValue(nProcIndex, "store_Id", voObj.getStrStrDup());
			daoObj.setProcInValue(nProcIndex, "poNo", voObj.getStrPONoDup());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrReqDetailsWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("AdvanceRequestTransDAO.getReqDetails() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	public static void insertNew(AdvanceRequestTransVO vo)  {
		HisDAO dao = null;
		AdvanceRequestDAO advanceRequestDao = null;
		String strFuncName = "";
		int nFuncIndex = 0;
		
		String strRequestNo = "";
		String strRequestPrefix = "";
		MmsConfigUtil mcu = null;
		
		try 
		{
			mcu = new MmsConfigUtil(vo.getStrHospitalCode());
			advanceRequestDao = new AdvanceRequestDAO();
			dao = new HisDAO("mms", "AdvanceRequestDAO");
			
			
			
			strFuncName = "{? = call MMS_MST.generate_advanceno(?,?,?)}";
			nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrItemCategoryId());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strRequestNo = dao.getFuncString(nFuncIndex);
			vo.setStrRequestNumber(strRequestNo);
			
			
			strFuncName = "{? = call MMS_MST.get_reqPerfix(?,?,?)}";
			nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrItemCategoryId());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strRequestPrefix = dao.getFuncString(nFuncIndex);
			vo.setStrRequestPrefix(strRequestPrefix);
			
			advanceRequestDao.setStrStoreId(vo.getStrStoreId());
			advanceRequestDao.setStrReqNo(vo.getStrRequestNumber());
			advanceRequestDao.setStrHospitalCode(vo.getStrHospitalCode());
			advanceRequestDao.setStrSupplierId(vo.getStrSuppId());
			advanceRequestDao.setStrPONo(vo.getStrPONO());
			advanceRequestDao.setStrPODate(vo.getStrPODate());
			advanceRequestDao.setStrPOAmt(vo.getStrPOAmt());
			advanceRequestDao.setStrItemCatId(vo.getStrItemCategoryId());
			advanceRequestDao.setStrAdvAmt(vo.getStrAdvRequest());
			advanceRequestDao.setStrCurrencyId(vo.getStrCurrId());
			advanceRequestDao.setStrAdvStatus(vo.getStrAdvStatus());
			advanceRequestDao.setStrRemarks(vo.getStrRemarks());
			advanceRequestDao.setStrSeatId(vo.getStrSeatId());
			advanceRequestDao.setStrIsValid(vo.getStrIsValid());
			advanceRequestDao.setStrReqPrefix(vo.getStrRequestPrefix());
			advanceRequestDao.setStrFinStartDate(mcu.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			advanceRequestDao.setStrFinEndDate(mcu.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			advanceRequestDao.setStrPOStoreId(vo.getStrPOStoreId());
			advanceRequestDao.setStrBankAccName(vo.getStrBankAccName());
			advanceRequestDao.setStrBankAccNo(vo.getStrBankAccNo());
		
			advanceRequestDao.insert(dao);
			
				synchronized(dao)
				{
					dao.fire();
				}
			} catch (Exception e) {
				e.printStackTrace();
			vo.setStrMsgString("AdvanceRequestTransDAO.insertNew() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if
			(dao!=null){
			dao.free();
			dao = null;
			}
			
			advanceRequestDao = null;
		}
	}
}
