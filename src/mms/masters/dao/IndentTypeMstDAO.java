package mms.masters.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.IndentTypeDAO;
import mms.masters.vo.IndentTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class IndentTypeMstDAO.
 * 
 * @author Anshul Jindal
 */
public class IndentTypeMstDAO {

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public static void insertQuery(IndentTypeMstVO vo) {

		HisDAO dao = null;
		IndentTypeDAO indentTypeDAO = null;

		try {
			dao = new HisDAO("mms", "IndentTypeMstDAO");
			indentTypeDAO = new IndentTypeDAO();

			indentTypeDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			indentTypeDAO.setStrHospitalCode(vo.getStrHospitalCode());
			indentTypeDAO.setStrIndentTypeName(vo.getStrIndentTypeName());
			indentTypeDAO.setStrIndentTypeTime(vo.getStrIndentTypeTime());
			indentTypeDAO.setStrIndentTypeTimeUnit(vo
					.getStrIndentTypeTimeUnit());
			indentTypeDAO.setStrIsValid(vo.getStrIsValid());
			indentTypeDAO.setStrRemarks(vo.getStrRemarks());
			indentTypeDAO.setStrStoreTypeId(vo.getStrStoreTypeId());
			indentTypeDAO.setStrSeatId(vo.getStrSeatId());

			indentTypeDAO.insert(dao);
			/*
			 * strquery = mms.qryHandler_mms.getQuery(1, "insert.IndentType.0");
			 * nqryIndex = dao.setQuery(strquery); dao.setQryValue(nqryIndex, 1,
			 * vo.getStrHospitalCode()); dao.setQryValue(nqryIndex, 2,
			 * vo.getStrHospitalCode()); dao.setQryValue(nqryIndex, 3,
			 * vo.getStrStoreTypeId()); dao.setQryValue(nqryIndex, 4,
			 * vo.getStrIndentTypeName()); dao.setQryValue(nqryIndex, 5,
			 * vo.getStrStoreTypeId()); dao.setQryValue(nqryIndex, 6,
			 * vo.getStrIndentTypeTime()); dao.setQryValue(nqryIndex, 7,
			 * vo.getStrIndentTypeTimeUnit()); dao.setQryValue(nqryIndex, 8,
			 * vo.getStrRemarks()); dao.setQryValue(nqryIndex, 9,
			 * vo.getStrEffectiveFrom()); dao.setQryValue(nqryIndex, 10,
			 * vo.getStrSeatId()); dao.setQryValue(nqryIndex, 11,
			 * vo.getStrIsValid()); dao.execute(nqryIndex, 0);
			 */

			synchronized (dao) {
				dao.fire();

			}

		} catch (Exception e) {
			vo.setStrMsgString("--> IndentTypeMstDAO.insertQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			indentTypeDAO = null;
		}

	}

	/**
	 * to check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */
	public static void chkDuplicate(IndentTypeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";

		try {
			dao = new HisDAO("mms", "IndentTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.IndentType.2");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrIndentTypeName());
			dao.setQryValue(nqryIndex, 2, vo.getStrStoreTypeId());
			dao.setQryValue(nqryIndex, 3, vo.getStrHospitalCode());

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
			vo.setStrMsgString("--> IndentTypeMstDAO.chkDuplicate()-->"
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
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 */
	public static void modifyQuery(IndentTypeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";

		try {
			dao = new HisDAO("mms", "IndentTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.IndentType.3");

			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrIndentTypeId());
			WebRowSet web = dao.executeQry(nqryIndex);

			while (web.next()) {
				vo.setStrStoreTypeId(web.getString(1));
				vo.setStrIndentTypeName(web.getString(2));
				vo.setStrIndentTypeTime(web.getString(3));
				vo.setStrIndentTypeTimeUnit(web.getString(4));
				vo.setStrEffectiveFrom(web.getString(5));
				vo.setStrRemarks(web.getString(6));
				vo.setStrIsValid(web.getString(7));
			}

		} catch (Exception e) {
			vo.setStrMsgString("--> IndentTypeMstDAO.modifyQuery()-->"
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
	public static void initialUpdateQuery(IndentTypeMstVO vo) {

		HisDAO hisdao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;

		try {
			hisdao = new HisDAO("mms", "IndentTypeMstDAO");
			String strquery = mms.qryHandler_mms.getQuery(1,
					"select.IndentType.4");

			nqryIndex = hisdao.setQuery(strquery);

			hisdao.setQryValue(nqryIndex, 1, vo.getStrIndentTypeName());
			hisdao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			hisdao.setQryValue(nqryIndex, 3, vo.getStrIndentTypeId());
			hisdao.setQryValue(nqryIndex, 4, vo.getStrStoreTypeId());

			wb = hisdao.executeQry(nqryIndex);

			while (wb.next()) {
				ncount = Integer.parseInt(wb.getString(1));
				// System.out.println("in dao initial update getting wb
				// ncount"+ncount);
			}
			if (ncount < 1) {
				vo.setBExistStatus(true);
			} else {
				vo.setBExistStatus(false);
			}

		} catch (Exception e) {
			vo.setStrMsgString("--> IndentTypeMstDAO.initialUpdateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (hisdao != null) {
				hisdao.free();
				hisdao = null;
			}
		}

	}

	/**
	 * to update the record.
	 * 
	 * @param vo the vo
	 */
	public static void updateQuery(IndentTypeMstVO vo) {

		HisDAO dao = null;
		IndentTypeDAO indentTypeDAO = null;

		try {

			dao = new HisDAO("mms", "IndentTypeMstDAO");
			indentTypeDAO = new IndentTypeDAO();

			indentTypeDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			indentTypeDAO.setStrHospitalCode(vo.getStrHospitalCode());
			indentTypeDAO.setStrIndentTypeName(vo.getStrIndentTypeName());
			indentTypeDAO.setStrIndentTypeTime(vo.getStrIndentTypeTime());
			indentTypeDAO.setStrIndentTypeTimeUnit(vo
					.getStrIndentTypeTimeUnit());
			indentTypeDAO.setStrIsValid(vo.getStrIsValid());
			indentTypeDAO.setStrRemarks(vo.getStrRemarks());
			indentTypeDAO.setStrStoreTypeId(vo.getStrStoreTypeId());
			indentTypeDAO.setStrSeatId(vo.getStrSeatId());
			indentTypeDAO.setStrIndentTypeId(vo.getStrIndentTypeId());

			indentTypeDAO.update(dao);

			/*
			 * strquery = mms.qryHandler_mms.getQuery(1, "update.IndentType.1");
			 * nqryIndex = dao.setQuery(strquery);
			 * 
			 * dao.setQryValue(nqryIndex, 1, vo.getStrIndentTypeName());
			 * dao.setQryValue(nqryIndex, 2, vo.getStrIndentTypeTime());
			 * dao.setQryValue(nqryIndex, 3, vo.getStrIndentTypeTimeUnit());
			 * dao.setQryValue(nqryIndex, 4, vo.getStrEffectiveFrom());
			 * dao.setQryValue(nqryIndex, 5, vo.getStrSeatId());
			 * dao.setQryValue(nqryIndex, 6, vo.getStrRemarks());
			 * dao.setQryValue(nqryIndex, 7, vo.getStrSeatId());
			 * dao.setQryValue(nqryIndex, 8, vo.getStrIsValid());
			 * dao.setQryValue(nqryIndex, 9, vo.getStrHospitalCode());
			 * dao.setQryValue(nqryIndex, 10, vo.getStrIndentTypeId());
			 * 
			 * dao.execute(nqryIndex, 0);
			 */

			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {
			vo.setStrMsgString("--> IndentTypeMstDAO.updateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			indentTypeDAO = null;
		}

	}

}
