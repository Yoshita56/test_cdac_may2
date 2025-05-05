package mms.masters.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.DispatchModeDAO;
import mms.masters.vo.DispatchModeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class DispatchModeMstDAO.
 */
public class DispatchModeMstDAO {

	/**
	 * to check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */

	public static void chkDuplicate(DispatchModeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "DispatchModeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.dispatchModeMst.2");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrDispatchModeName());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			wb = dao.executeQry(nqryIndex);
			while (wb.next()) {
				ncount = Integer.parseInt(wb.getString(1));
			}
			if (ncount == 0) {
				vo.setBExistStatus(true);
			} else {
				vo.setBExistStatus(false);
			}
		} catch (Exception e) {
			vo.setStrMsgString("DispatchModeMstDAO.chkDuplicate() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */

	public static void insertQuery(DispatchModeMstVO vo) {
		HisDAO dao = null;
		DispatchModeDAO dispatchModeDao = null;

		try {
			dispatchModeDao = new DispatchModeDAO();
			dao = new HisDAO("mms", "DispatchModeMstDAO");

			dispatchModeDao.setStrHospitalCode(vo.getStrHospitalCode());
			dispatchModeDao.setStrDispatchModeId(vo.getStrDispatchModeId());
			dispatchModeDao.setStrRemarks(vo.getStrRemarks());
			dispatchModeDao.setStrDispatchModeName(vo.getStrDispatchModeName());
			dispatchModeDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			dispatchModeDao.setStrSeatId(vo.getStrSeatId());
			dispatchModeDao.setStrIsValid(vo.getStrIsValid());

			dispatchModeDao.insert(dao);
			synchronized (dao) {
				dao.fire();

			}
		} catch (Exception e) {
			vo.setStrMsgString("DispatchModeMstDAO.insertQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

			dispatchModeDao = null;

		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 */

	public static void modifyQuery(DispatchModeMstVO vo) {

		HisDAO dao = new HisDAO("mms", "DispatchModeMstDAO");

		int nqryIndex;
		String strquery = new String();

		try {

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.dispatchModeMst.3");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrDispatchModeId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());

			WebRowSet web = dao.executeQry(nqryIndex);
			while (web.next()) {
				vo.setStrDispatchModeName(web.getString(1));
				vo.setStrRemarks(web.getString(2));
				vo.setStrEffectiveFrom(web.getString(3));
				vo.setStrSeatId(web.getString(4));
				vo.setStrIsValid(web.getString(5));
			}
		} catch (Exception e) {

			vo.setStrMsgString("DispatchModeMstDAO.modifyQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/**
	 * to check duplicate before update.
	 * 
	 * @param vo the vo
	 */

	public static void checkDuplicateRecord(DispatchModeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";
		try {
			dao = new HisDAO("mms", "DispatchModeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.dispatchModeMst.4");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrDispatchModeName());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrDispatchModeId());
			wb = dao.executeQry(nqryIndex);
			while (wb.next()) {
				ncount = Integer.parseInt(wb.getString(1));
			}
			if (ncount < 1) {
				vo.setBExistStatus(true);
			} else {
				vo.setBExistStatus(false);
			}

		} catch (Exception e) {
			vo
					.setStrMsgString("--> DispatchModeMstDAO.checkDuplicateRecord()-->"
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}

	/**
	 * to update the record.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */

	public static void updateQuery(DispatchModeMstVO vo) {

		DispatchModeDAO dispatchModeDAO = null;
		HisDAO dao = null;

		try {
			dispatchModeDAO = new DispatchModeDAO();
			dao = new HisDAO("mms", "DispatchModeMstDAO");

			dispatchModeDAO.setStrHospitalCode(vo.getStrHospitalCode());
			dispatchModeDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			dispatchModeDAO.setStrIsValid(vo.getStrIsValid());
			dispatchModeDAO.setStrRemarks(vo.getStrRemarks());
			dispatchModeDAO.setStrSeatId(vo.getStrSeatId());
			dispatchModeDAO.setStrDispatchModeId(vo.getStrDispatchModeId());
			dispatchModeDAO.setStrDispatchModeName(vo.getStrDispatchModeName());
			dispatchModeDAO.setStrSlNo(vo.getStrSlNo());

			dispatchModeDAO.update(dao);

			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {

			vo.setStrMsgString("--> DispatchModeMstDAO.updateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			dispatchModeDAO = null;

		}

	}

}
