package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.AgendaViewTransVO;

public class AgendaViewTransDAO {

	
	public static void getIndentDetails(AgendaViewTransVO _agendaViewTransVO) {
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "";
		int nProcIndex = 0;
		String strErr = "";
		try {
			daoObj = new HisDAO("mms", "AgendaViewTransDAO");

			strProcName = "{call pkg_mms_view.proc_agenda_indent_dtl(?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", _agendaViewTransVO.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "store_id", _agendaViewTransVO.getStrStoreId(),3);
			daoObj.setProcInValue(nProcIndex, "agenda_no", _agendaViewTransVO.getStrAgendaNo(),4);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_agendaViewTransVO.setIndentDetailsWS(ws);
			else 
				throw new Exception(strErr);
		} catch (Exception e) {
			e.printStackTrace();
			_agendaViewTransVO.setStrMsgString("AgendaViewTransDAO.getIndentDetails() --> "
					+ e.getMessage());
			_agendaViewTransVO.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getAgendaDetails(AgendaViewTransVO _agendaViewTransVO) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("mms", "AgendaViewTransDAO");

			strProcName = "{call pkg_mms_view.Proc_Hstt_Agenda_Dtl(?,?,?,?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modval", "3",1);
			daoObj.setProcInValue(nProcIndex, "store_id", _agendaViewTransVO.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", _agendaViewTransVO.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "agenda_no", _agendaViewTransVO.getStrAgendaNo(),4);
			
			/* start */
			daoObj.setProcInValue(nProcIndex, "item_cat", "",5);
			daoObj.setProcInValue(nProcIndex, "po_type", "",6);
			daoObj.setProcInValue(nProcIndex, "grant_type", "",7);
			/* end */
			daoObj.setProcOutValue(nProcIndex, "err", 1,8);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,9);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {
				ws.next();
				_agendaViewTransVO.setStrToStoreName(ws.getString(1));
				_agendaViewTransVO.setStrGrantType(ws.getString(2));
				_agendaViewTransVO.setStrAgendaDate(ws.getString(3));
				_agendaViewTransVO.setStrRemarks(ws.getString(4));
				_agendaViewTransVO.setStrToStore(ws.getString(5));
				_agendaViewTransVO.setStrItemCatogry(ws.getString(6));
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			_agendaViewTransVO.setStrMsgString("AgendaViewTransDAO.getIndentDetails() --> "
					+ e.getMessage());
			_agendaViewTransVO.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	public static void getCompiledItemDetails(AgendaViewTransVO _agendaViewTransVO) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("mms", "AgendaViewTransDAO");

			strProcName = "{call pkg_mms_view.proc_agenda_item_dtl(?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", _agendaViewTransVO.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "store_id", _agendaViewTransVO.getStrStoreId(),3);
			daoObj.setProcInValue(nProcIndex, "agenda_no", _agendaViewTransVO.getStrAgendaNo(),4);
			
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) 
				_agendaViewTransVO.setCompiledItemDetailsWS(ws);
			else 
				throw new Exception(strErr);

		} catch (Exception e) {

			_agendaViewTransVO
					.setStrMsgString("AgendaViewTransDAO.getCompiledItemDetails() --> "
							+ e.getMessage());
			_agendaViewTransVO.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
}
