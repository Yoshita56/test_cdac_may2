/**
 * 
 */
package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.AgendaDeskModifyTransVO;

/**
 * @author Pankaj Kumar
 * 
 */
public class AgendaDeskModifyTransDAO {
	public static void setToStoreValues(
			AgendaDeskModifyTransVO _AgendaDeskModifyTransVO) {
		String strproc_name = "{call pkg_mms_view.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.AgendaDeskModifyTransDAO.setGroupComboValues()");
			dao = new HisDAO("MMS",
					"transactions.AgendaDeskModifyTransDAO.setGroupComboValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "3",1);
			dao.setProcInValue(nProcIndex, "hosp_code",
					_AgendaDeskModifyTransVO.getStrHospitalCode(),3);
			dao.setProcInValue(nProcIndex, "storeid", _AgendaDeskModifyTransVO
					.getStrStoreId(),4);
			dao.setProcInValue(nProcIndex, "seatId", "1",2);
			dao.setProcInValue(nProcIndex, "storetype_id", "0",5);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.execute(nProcIndex,1);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_AgendaDeskModifyTransVO.setStrToStoreValues(util
						.getOptionValue(wsResult, _AgendaDeskModifyTransVO
								.getStrToStore(), "0^Select Value", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_AgendaDeskModifyTransVO
					.setStrMsgString("AgendaDeskModifyTransDAO.setToStoreValues() --> "
							+ _Err.getMessage());
			_AgendaDeskModifyTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}

	public static void setFetchedData(
			AgendaDeskModifyTransVO _AgendaDeskModifyTransVO) {
		String strproc_name = "{call pkg_mms_view.Proc_Hstt_Agenda_Dtl(?,?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.AgendaDeskModifyTransDAO.setGroupComboValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code",
					_AgendaDeskModifyTransVO.getStrHospitalCode(),3);
			dao.setProcInValue(nProcIndex, "store_id", _AgendaDeskModifyTransVO
					.getStrStoreId(),2);
			dao.setProcInValue(nProcIndex, "agenda_no", "1",4);
			
			/* start */
			dao.setProcInValue(nProcIndex, "item_cat", "",5);
			dao.setProcInValue(nProcIndex, "po_type", "",6);
			dao.setProcInValue(nProcIndex, "grant_type", "",7);
			/* end */
			
			dao.setProcOutValue(nProcIndex, "err", 1,8);
			dao.setProcOutValue(nProcIndex, "resultset", 2,9);
			dao.execute(nProcIndex,1);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				if (wsResult.next()) {
					_AgendaDeskModifyTransVO.setStrAgendaPeriod(wsResult
							.getString(6));
					_AgendaDeskModifyTransVO.setStrToStore(wsResult
							.getString(5));
					_AgendaDeskModifyTransVO.setStrItemCat(wsResult
							.getString(4));
				}
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_AgendaDeskModifyTransVO
					.setStrMsgString("AgendaDeskModifyTransDAO.setFetchedData() --> "
							+ _Err.getMessage());
			_AgendaDeskModifyTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}

	public static void setItemCatValues(
			AgendaDeskModifyTransVO _AgendaDeskModifyTransVO) {
		String strproc_name = "{call pkg_mms_view.PROC_SSTT_ITEM_CATEGORY_MST(?,?,?,?)}";
		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.AgendaDeskModifyTransDAO.setGroupComboValues()");
			dao = new HisDAO("MMS",
					"transactions.AgendaDeskModifyTransDAO.setGroupComboValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "mode_val", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code",
					_AgendaDeskModifyTransVO.getStrHospitalCode(),2);
			dao.setProcOutValue(nProcIndex, "err", 1,3);
			dao.setProcOutValue(nProcIndex, "resultset", 2,4);
			dao.execute(nProcIndex,1);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_AgendaDeskModifyTransVO.setStrItemCatValues(util
						.getOptionValue(wsResult, _AgendaDeskModifyTransVO
								.getStrItemCat(), "0^Select Value", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_AgendaDeskModifyTransVO
					.setStrMsgString("AgendaDeskModifyTransDAO.setItemCatValues() --> "
							+ _Err.getMessage());
			_AgendaDeskModifyTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}

	public static void setIndentDetails(
			AgendaDeskModifyTransVO _AgendaDeskModifyTransVO) {
		String strproc_name = "{call pkg_mms_dml.dml_hstt_challan_dummy_dtl(?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.AgendaDeskModifyTransDAO.setGroupComboValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modval", "1");
			// dao.setProcInValue(nProcIndex, "hosp_code",
			// _AgendaDeskModifyTransVO
			// .getStrHospitalCode());
			// dao.setProcInValue(nProcIndex, "storeid",
			// _AgendaDeskModifyTransVO.getStrSeatId());

			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);
			dao.executeProcedure(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				_AgendaDeskModifyTransVO.setWbIndentDetail(wsResult);
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_AgendaDeskModifyTransVO
					.setStrMsgString("AgendaDeskModifyTransDAO.setIndentDetails() --> "
							+ _Err.getMessage());
			_AgendaDeskModifyTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}

	public static void insert(AgendaDeskModifyTransVO _AgendaDeskModifyTransVO) {
		String strProcName = "{call pkg_mms_dml.dml_agenda_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;
		String strErr = "";

		try {
			dao = new HisDAO("MMS",
					"transactions.AgendaDeskModifyTransDAO.setGroupComboValues()");

			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modval", "1");
			dao.setProcInValue(nProcIndex, "store_id", _AgendaDeskModifyTransVO
					.getStrStoreId());
			dao.setProcInValue(nProcIndex, "agenda_no",
					_AgendaDeskModifyTransVO.getStrAgendaNo());
			dao.setProcInValue(nProcIndex, "hosp_code",
					_AgendaDeskModifyTransVO.getStrHospitalCode());
			dao.setProcInValue(nProcIndex, "item_cat_no",
					_AgendaDeskModifyTransVO.getStrItemCatNo());
			dao.setProcInValue(nProcIndex, "to_store", _AgendaDeskModifyTransVO
					.getStrToStoreId());
			dao.setProcInValue(nProcIndex, "agenda_period",
					_AgendaDeskModifyTransVO.getStrAgendaPeriod());
			dao.setProcInValue(nProcIndex, "agenda_date",
					_AgendaDeskModifyTransVO.getStrAgendaDate());
			dao.setProcInValue(nProcIndex, "agenda_status",
					_AgendaDeskModifyTransVO.getStrAgendaStatus());
			dao.setProcInValue(nProcIndex, "financial_start_date",
					_AgendaDeskModifyTransVO.getStrFinancialStartDate());
			dao.setProcInValue(nProcIndex, "financial_to_date",
					_AgendaDeskModifyTransVO.getStrFinancialToDate());
			dao.setProcInValue(nProcIndex, "remarks", _AgendaDeskModifyTransVO
					.getStrRemarks());
			dao.setProcInValue(nProcIndex, "seat_id", _AgendaDeskModifyTransVO
					.getStrSeatId());

			dao.executeProcedure(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr != null && !strErr.equals(""))
				throw new Exception(strErr);

		} catch (Exception _Err) {
			_AgendaDeskModifyTransVO
					.setStrMsgString("AgendaDeskModifyTransDAO.insert() --> "
							+ _Err.getMessage());
			_AgendaDeskModifyTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

}
