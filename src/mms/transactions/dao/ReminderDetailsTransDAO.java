package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.ReminderDetailsDAO;
import mms.transactions.vo.ReminderDetailsTransVO;

public class ReminderDetailsTransDAO {
	
	public static void getStoreList(ReminderDetailsTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","ReminderDetailsTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
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
		
				voObj.setStrStoreWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("ReminderDetailsTransDAO.getStoreList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getPONo(ReminderDetailsTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call PKG_MMS_VIEW.proc_po_reminder_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","ReminderDetailsTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStoreId());
			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrPONoWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("ReminderDetailsTransDAO.getPONo() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	public static void getScheduleNo(ReminderDetailsTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call PKG_MMS_VIEW.Proc_Po_Schedule_Dtl(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","ReminderDetailsTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "poNo", voObj.getStrPONo());
			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrScheduleNoWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("ReminderDetailsTransDAO.getScheduleNo() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	public static void getPODetails(ReminderDetailsTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_po_details(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","ReminderDetailsTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "poNo", voObj.getStrPONo());
			daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrPOStoreId());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrPODtlsWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("ReminderDetailsTransDAO.getPODetails() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	public static void getPrevReminderDtl(ReminderDetailsTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Prev_Reminder_Details(?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","ReminderDetailsTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modval", "1");
			
			daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "po_storeId", voObj.getStrPOStoreId());
			daoObj.setProcInValue(nProcIndex, "scheduleNo", voObj.getStrScheduleNo());
			daoObj.setProcInValue(nProcIndex, "poNo", voObj.getStrPONo());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrPrevReminderDtlWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("ReminderDetailsTransDAO.getPrevReminderDtl() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	public static void insert(ReminderDetailsTransVO vo) {

		HisDAO dao = null;

		String strFuncName = "";
		String strReminderNo ="";
		String strReminderPrefix = "";
		int nFuncIndex = 0;
		
		ReminderDetailsDAO reminderDetailsDAO = null;

		try {
			dao = new HisDAO("mms", "ReminderDetailsTransDAO");
			reminderDetailsDAO = new ReminderDetailsDAO();
			
			strFuncName = "{? = call MMS_MST.generate_reminderNo(?,?,?,?,?)}";
			nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrPONo());
			dao.setFuncInValue(nFuncIndex, 5, vo.getStrPOStoreId());
			dao.setFuncInValue(nFuncIndex, 6, vo.getStrScheduleNo());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strReminderNo = dao.getFuncString(nFuncIndex);
			vo.setStrReminderNo(strReminderNo);
			
			
			strFuncName = "{? = call MMS_MST.get_reqPerfix(?,?,?)}";
			nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, "2");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrItemCatId());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strReminderPrefix = dao.getFuncString(nFuncIndex);
			
			
			vo.setStrReminderPrefix(strReminderPrefix);
			
			reminderDetailsDAO.setStrStoreId(vo.getStrStoreId());
			reminderDetailsDAO.setStrPONo(vo.getStrPONo());
			reminderDetailsDAO.setStrReminderNo(vo.getStrReminderNo());
			reminderDetailsDAO.setStrHospitalCode(vo.getStrHospitalCode());
			reminderDetailsDAO.setStrItemCatNo(vo.getStrItemCatId());
			reminderDetailsDAO.setStrPOPrefix(vo.getStrPOPrefix());
			reminderDetailsDAO.setStrReminderPrefix(vo.getStrReminderPrefix());
			reminderDetailsDAO.setStrReminderType(vo.getStrReminderType());
			reminderDetailsDAO.setStrSupplierId(vo.getStrSuppId());
			reminderDetailsDAO.setStrScheduleNo(vo.getStrScheduleNo());
			reminderDetailsDAO.setStrPODate(vo.getStrPODate());
			reminderDetailsDAO.setStrPOStoreId(vo.getStrPOStoreId());
			
			
			reminderDetailsDAO.insert(dao);
			
				synchronized(dao)
				{
					dao.fire();
				}
			} catch (Exception e) {
				e.printStackTrace();
				vo
						.setStrMsgString("ReminderDetailsTransDAO.insert() --> "
								+ e.getMessage());
				vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	

}
