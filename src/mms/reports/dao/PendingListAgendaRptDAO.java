/**
 * 
 */
package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.PendingListAgendaRptVO;

/**
 * Developer:Anshul Jindal Creation Date: 17-07-2009 Modifying Date:- Used
 * For:-MMS Reports Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PendingListAgendaRptDAO {

	public static void getStoreNames(PendingListAgendaRptVO vo) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.rptm_hstt_store_mst(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Report", "PendingListAgendaRptDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "seatid", vo.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo
					.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				vo.setStoreComboWS(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			vo.setStrMsgString("PendingListAgendaRptDAO.getStoreNames() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	public static void getCategoryValues(PendingListAgendaRptVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.Rptm_item_category_list(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			dao = new HisDAO("MMS Report", "PendingListAgendaRptDAO");
			
			nProcIndex = dao.setProcedure(strProcName);

			
			dao.setProcInValue(nProcIndex, "modeval", "2");
			dao
			.setProcInValue(nProcIndex, "hosp_code", vo
					.getStrHospitalCode()); 
			
			dao.setProcInValue(nProcIndex, "storeId", vo.getStrStoreId());
		
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);
			dao.executeProcedure(nProcIndex);
			strErr = dao.getString(nProcIndex, "err");
			if (strErr == null)
				
				strErr = "";
			if (strErr.equals("")) {
			ws = dao.getWebRowSet(nProcIndex, "resultset");
				vo.setCategoryComboWS(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			vo.setStrMsgString("PendingListAgendaRptDAO.getCategoryValues() --> "
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
