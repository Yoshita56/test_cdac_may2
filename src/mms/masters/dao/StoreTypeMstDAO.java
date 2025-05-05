package mms.masters.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.dao.StoreTypeDAO;
import mms.masters.vo.StoreTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreTypeMstDAO.
 * 
 * @author Anshul Jindal
 */
public class StoreTypeMstDAO {

	/**
	 * for getting option value of item category name combo on add page.
	 * 
	 * @param vo the vo
	 */
	/*
	 * COMMENTED AFTER CHANGES IN TABLES ON 17TH-FEB-2009 public static void
	 * initAddQuery(StoreTypeMstVO vo) {
	 * 
	 * HisDAO dao = null; int nqryIndex; String strquery = ""; WebRowSet wb =
	 * null;
	 * 
	 * try { dao = new HisDAO("mms", "StoreTypeMstDAO"); strquery =
	 * mms.qryHandler_mms.getQuery(1, "select.storeTypeMst.5") .replace("?",
	 * vo.getStrHospitalCode()); strquery = strquery.concat(" AND " +
	 * mms.qryHandler_mms.getQuery(1, "select.storeTypeMst.cond.5").replace("?",
	 * "1")); nqryIndex = dao.setQuery(strquery);
	 * 
	 * wb = dao.executeQry(nqryIndex); vo.setStrItemCategoryCmbWs(wb);
	 *  } catch (Exception e) { vo.setStrMsgString("-->
	 * StoreTypeMstDAO.initAddQuery()-->" + e.getMessage());
	 * vo.setStrMsgType("1"); } finally { if (dao != null) { dao.free(); dao =
	 * null; } } }
	 */

	/**
	 * to insert the data
	 * 
	 * @param vo
	 */
	public static void insertQuery(StoreTypeMstVO vo) {

		HisDAO dao = null;
		StoreTypeDAO storeTypeDAO = null;

		try {
			storeTypeDAO = new StoreTypeDAO();
			dao = new HisDAO("mms", "StoreTypeMstDAO");

			storeTypeDAO.setStrHospitalCode(vo.getStrHospitalCode());
			storeTypeDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			storeTypeDAO.setStrIsValid(vo.getStrIsValid());
			storeTypeDAO.setStrRemarks(vo.getStrRemarks());
			storeTypeDAO.setStrSeatId(vo.getStrSeatId());
		//	storeTypeDAO.setStrItemCategoryNo(vo.getStrItemCategoryId());
			storeTypeDAO.setStrStoreTypeName(vo.getStrStoreTypeName());

			storeTypeDAO.insert(dao);

			/*
			 * strquery = mms.qryHandler_mms.getQuery(1,
			 * "insert.storeTypeMst.0"); nqryIndex = dao.setQuery(strquery);
			 * 
			 * dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			 * dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			 * dao.setQryValue(nqryIndex, 3, vo.getStrItemCategoryId());
			 * dao.setQryValue(nqryIndex, 4, vo.getStrStoreTypeName());
			 * dao.setQryValue(nqryIndex, 5, vo.getStrItemCategoryId());
			 * dao.setQryValue(nqryIndex, 6, vo.getStrRemarks());
			 * dao.setQryValue(nqryIndex, 7, vo.getStrEffectiveFrom());
			 * dao.setQryValue(nqryIndex, 8, vo.getStrSeatId());
			 * dao.setQryValue(nqryIndex, 9, "1"); dao.execute(nqryIndex, 0);
			 */

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {
			vo.setStrMsgString("--> StoreTypeMstDAO.insertQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			storeTypeDAO = null;
		}
	}

	/**
	 * to check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */
	public static void initialAddQuery(StoreTypeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";
		try {
			dao = new HisDAO("mms", "StoreTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.storeTypeMst.2");
			nqryIndex = dao.setQuery(strquery);

			//Hospital Code Will Be Global (100)
			dao.setQryValue(nqryIndex, 1, vo.getStrStoreTypeName());
			dao.setQryValue(nqryIndex, 2, MmsConfigUtil.GLOBAL_HOSPITAL_CODE);

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
			vo.setStrMsgString("--> StoreTypeMstDAO.initialAddQuery()-->"
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
	public static void modifyQuery(StoreTypeMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";

		try {

			dao = new HisDAO("mms", "StoreTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.storeTypeMst.3");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrStoreTypeId());
			WebRowSet web = dao.executeQry(nqryIndex);
			while (web.next()) {
				// vo.setStrItemCategoryName(web.getString(1));commented after
				// changes in table on 17th Feb09
				vo.setStrStoreTypeName(web.getString(1));
				vo.setStrEffectiveFrom(web.getString(2));
				vo.setStrRemarks(web.getString(3));
				vo.setStrSeatId(web.getString(4));
				vo.setStrIsValid(web.getString(5));
			}
		} catch (Exception e) {
			vo.setStrMsgString("--> StoreTypeMstDAO.modifyQuery()-->"
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
	public static void updateQuery(StoreTypeMstVO vo) {

		StoreTypeDAO storeTypeDAO = null;
		HisDAO dao = null;

		try {
			storeTypeDAO = new StoreTypeDAO();
			dao = new HisDAO("mms", "StoreTypeMstDAO");

			storeTypeDAO.setStrHospitalCode(vo.getStrHospitalCode());
			storeTypeDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			storeTypeDAO.setStrIsValid(vo.getStrIsValid());
			storeTypeDAO.setStrRemarks(vo.getStrRemarks());
			storeTypeDAO.setStrSeatId(vo.getStrSeatId());
			// storeTypeDAO.setStrItemCategoryNo(vo.getStrItemCategoryId());
			storeTypeDAO.setStrStoreTypeName(vo.getStrStoreTypeName());
			storeTypeDAO.setStrStoreTypeId(vo.getStrStoreTypeId());

			storeTypeDAO.update(dao);

			/*
			 * strquery = mms.qryHandler_mms.getQuery(1,
			 * "update.storeTypeMst.1"); nqryIndex = dao.setQuery(strquery);
			 * 
			 * dao.setQryValue(nqryIndex, 1, vo.getStrStoreTypeName());
			 * dao.setQryValue(nqryIndex, 2, vo.getStrEffectiveFrom());
			 * dao.setQryValue(nqryIndex, 3, vo.getStrSeatId());
			 * dao.setQryValue(nqryIndex, 4, vo.getStrRemarks());
			 * dao.setQryValue(nqryIndex, 5, vo.getStrSeatId());
			 * dao.setQryValue(nqryIndex, 6, vo.getStrIsValid());
			 * dao.setQryValue(nqryIndex, 7, strtemp[0]);
			 * dao.setQryValue(nqryIndex, 8, strtemp[1]); dao.execute(nqryIndex,
			 * 0);
			 */

			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {

			vo.setStrMsgString("--> StoreTypeMstDAO.updateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			storeTypeDAO = null;

		}

	}

	/**
	 * to check duplicate before update.
	 * 
	 * @param vo the vo
	 */
	public static void initialUpdateQuery(StoreTypeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";
		try {
			dao = new HisDAO("mms", "StoreTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.storeTypeMst.4");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrStoreTypeName());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrStoreTypeId());
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
			vo.setStrMsgString("--> StoreTypeMstDAO.initialUpdateQuery()-->"
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
