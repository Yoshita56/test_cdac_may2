/**
 * 
 */
package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import mms.transactions.vo.AgendaDeskCancelTransVO;

/**
 * @author Pankaj Kumar Creation Date:- 9-jun-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class AgendaDeskCancelTransDAO {
	public static void cancelAgenda(
			AgendaDeskCancelTransVO _AgendaDeskCancelTransVO) {
		String strproc_name = "{call pkg_mms_dml.Dml_Hstt_Agenda_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		try {
			dao = new HisDAO("MMS",
					"transactions.AgendaDeskCancelTransDAO.cancelAgenda()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modval", "3",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _AgendaDeskCancelTransVO.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "strRemarks", _AgendaDeskCancelTransVO.getStrRemarks(),9);
			dao.setProcInValue(nProcIndex, "seatId", _AgendaDeskCancelTransVO.getStrSeatId(),10);
			dao.setProcInValue(nProcIndex, "agendaNo", _AgendaDeskCancelTransVO.getStrAgendaNo(),4);
			dao.setProcInValue(nProcIndex, "strId", _AgendaDeskCancelTransVO.getStrStoreId(),3);
			
			/* Start */
			dao.setProcInValue(nProcIndex, "itemCategNo", "",5);
			dao.setProcInValue(nProcIndex, "reqType", "",6);
			dao.setProcInValue(nProcIndex, "fin_start_date", "",7);
			dao.setProcInValue(nProcIndex, "fin_end_date", "",8);
			dao.setProcInValue(nProcIndex, "agenda_date", "",11);
			dao.setProcInValue(nProcIndex, "agenda_status", "",12);
			dao.setProcInValue(nProcIndex, "isvalid", "1",13);
			dao.setProcInValue(nProcIndex, "strCondemnationType", "1",14);
			dao.setProcInValue(nProcIndex, "toStrId", "1",15);
			dao.setProcInValue(nProcIndex, "agenda_period", "",16);
			dao.setProcInValue(nProcIndex, "grant_type_id", "",17);
			dao.setProcInValue(nProcIndex, " agenda_period_value", "",18);
			/* End */
			dao.setProcInValue(nProcIndex, "strreqno","0",19);
			dao.setProcOutValue(nProcIndex, "err", 1,21);
			dao.setProcOutValue(nProcIndex, "agenda_approval_status", 1,20);
			dao.execute(nProcIndex,1);


		} catch (Exception _Err) {
			_Err.printStackTrace();
			_AgendaDeskCancelTransVO
					.setStrMsgString("AgendaDeskCancelTransDAO.cancelAgenda() --> "
							+ _Err.getMessage());
			_AgendaDeskCancelTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
}
