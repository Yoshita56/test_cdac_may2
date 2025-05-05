package mms.masters.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.LetterTypeDAO;
import mms.masters.vo.LetterTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class LetterTypeMstDAO.
 */
public class LetterTypeMstDAO {

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public static void insertQuery(LetterTypeMstVO vo) {
		HisDAO dao = null;
		LetterTypeDAO letterTypeDao = null;

		try {
			letterTypeDao = new LetterTypeDAO();
			dao = new HisDAO("mms", "LetterTypeMstDAO");

			letterTypeDao.setStrHospitalCode(vo.getStrHospitalCode());
			letterTypeDao.setStrStoreTypeId(vo.getStrStoreTypeId());
			letterTypeDao.setStrLetterTypeName(vo.getStrLetterTypeName());
			letterTypeDao.setStrRemarks(vo.getStrRemarks());
			letterTypeDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			letterTypeDao.setStrSeatId(vo.getStrSeatId());
			letterTypeDao.setStrIsValid(vo.getStrIsValid());
			letterTypeDao.setStrStoreTypeId(vo.getStrStoreTypeId());
			letterTypeDao.setStrHospitalCode(vo.getStrHospitalCode());
			letterTypeDao.insert(dao);

			synchronized (dao) {
				dao.fire();

			}
		} catch (Exception e) {
			vo.setStrMsgString("LetterTypeMstDAO.insertQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

			letterTypeDao = null;

		}

	}

	/**
	 * Check the Record weather data is Duplicate or not.
	 * 
	 * @param vo -
	 * FormBean Object
	 * 
	 * @return - true -record cannot be saved ,already exist false - record will
	 * save
	 * 
	 * @throws Exception 	 */
	public static void chkDuplicate(LetterTypeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "LetterTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.LetterTypeMst.2");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrLetterTypeName());
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
			vo.setStrMsgString("LetterTypeMstDAO.chkDuplicate() --> "
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
	 * retrieves and executes modify Query.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public static void modifyQuery(LetterTypeMstVO vo) {

		HisDAO dao = new HisDAO("mms", "LetterTypeMstDAO");

		int nqryIndex;
		String strquery = new String();

		try {

			strquery = mms.qryHandler_mms.getQuery(1, "select.LetterTypeMst.3");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrLetterTypeId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrSlNo());
			
			WebRowSet web = dao.executeQry(nqryIndex);
			while (web.next()) {
				vo.setStrLetterTypeName(web.getString(1));
				vo.setStrRemarks(web.getString(2));
				vo.setStrEffectiveFrom(web.getString(3));
				vo.setStrIsValid(web.getString(4));
			}
		} catch (Exception e) {

			vo.setStrMsgString("LetterTypeMstDAO.modifyQuery() --> "
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
	 * retrieves and executes update Query.
	 * 
	 * @param vo the vo
	 */
	public static void updateQuery(LetterTypeMstVO vo) {

		HisDAO dao = null;

		LetterTypeDAO letterTypeDao = null;

		try {
			letterTypeDao = new LetterTypeDAO();
			dao = new HisDAO("mms", "LetterTypeMstDAO");

			letterTypeDao.setStrLetterTypeName(vo.getStrLetterTypeName());
			letterTypeDao.setStrRemarks(vo.getStrRemarks());
			letterTypeDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			letterTypeDao.setStrLastModifiedSeatId(vo
					.getStrLastModifiedSeatId());
			letterTypeDao.setStrSeatId(vo.getStrSeatId());
			letterTypeDao.setStrSlNo(vo.getStrSlNo());
			letterTypeDao.setStrIsValid(vo.getStrIsValid());
			letterTypeDao.setStrStoreTypeId(vo.getStrStoreTypeId());
			letterTypeDao.setStrLetterTypeId(vo.getStrLetterTypeId());
			letterTypeDao.setStrHospitalCode(vo.getStrHospitalCode());
			letterTypeDao.update(dao);

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {
			vo.setStrMsgString("LetterTypeMstDAO.updateQuery() --> "
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
	 * Check the Record weather data is Duplicate or not.
	 * 
	 * @param vo -
	 * FormBean Object
	 * 
	 * @return - true -record cannot be saved ,already exist false - record will
	 * save
	 * 
	 * @throws Exception 	 */
	public static void initialUpdateQuery(LetterTypeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "LetterTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.LetterTypeMst.4");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrLetterTypeId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrLetterTypeName());
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
			vo.setStrMsgString("LetterTypeMstDAO.initialUpdateQuery() --> "
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
