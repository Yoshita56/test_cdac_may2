package mms.masters.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.PurposeDAO;
import mms.masters.vo.PurposeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PurposeMstDAO.
 * 
 * @author Baisakhi Roy
 */

public class PurposeMstDAO {
	
	/**
	 * to check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */

	public static void chkDuplicate(PurposeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "PurposeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.PurposeMst.2");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrPurpose());
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
			vo.setStrMsgString("PurposeMstDAO.chkDuplicate() --> "
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

	public static void insertQuery(PurposeMstVO vo) {
		HisDAO dao = null;
		PurposeDAO purposeDao = null;

		try {
			purposeDao = new PurposeDAO();
			dao = new HisDAO("mms", "PurposeMstDAO");

			purposeDao.setStrHospitalCode(vo.getStrHospitalCode());
			purposeDao.setStrRemarks(vo.getStrRemarks());
			purposeDao.setStrPurpose(vo.getStrPurpose());
			purposeDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			purposeDao.setStrSeatId(vo.getStrSeatId());
			purposeDao.setStrIsValid(vo.getStrIsValid());

			purposeDao.insert(dao);
			synchronized (dao) {
				dao.fire();

			}
		} catch (Exception e) {
			vo.setStrMsgString("PurposeMstDAO.insertQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

			purposeDao = null;

		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 */

	public static void modifyQuery(PurposeMstVO vo) {

		HisDAO dao = new HisDAO("mms", "PurposeMstDAO");

		int nqryIndex;
		String strquery = new String();

		try {

			strquery = mms.qryHandler_mms.getQuery(1, "select.PurposeMst.3");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrPurposeId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());

			WebRowSet web = dao.executeQry(nqryIndex);
			while (web.next()) {
				vo.setStrPurpose(web.getString(1));
				vo.setStrRemarks(web.getString(2));
				vo.setStrEffectiveFrom(web.getString(3));
				vo.setStrSeatId(web.getString(4));
				vo.setStrIsValid(web.getString(5));
			}
		} catch (Exception e) {

			vo.setStrMsgString("PurposeMstDAO.modifyQuery() --> "
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

	public static void checkDuplicateRecord(PurposeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";
		try {
			dao = new HisDAO("mms", "PurposeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.PurposeMst.4");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrPurpose());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrPurposeId());
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
			vo.setStrMsgString("--> PurposeMstDAO.checkDuplicateRecord()-->"
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

	public static void updateQuery(PurposeMstVO vo) {

		PurposeDAO purposeDao = null;
		HisDAO dao = null;

		try {
			purposeDao = new PurposeDAO();
			dao = new HisDAO("mms", "PurposeMstDAO");

			purposeDao.setStrHospitalCode(vo.getStrHospitalCode());
			purposeDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			purposeDao.setStrIsValid(vo.getStrIsValid());
			purposeDao.setStrRemarks(vo.getStrRemarks());
			purposeDao.setStrSeatId(vo.getStrSeatId());
			purposeDao.setStrPurposeId(vo.getStrPurposeId());
			purposeDao.setStrPurpose(vo.getStrPurpose());

			purposeDao.update(dao);

			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {

			vo.setStrMsgString("--> PurposeMstDAO.updateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			purposeDao = null;

		}

	}
}
