package mms.masters.dao;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.StoreSubGroupDAO;
import mms.masters.vo.StoreSubGroupMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreSubGroupMstDAO.
 */
public class StoreSubGroupMstDAO {

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public static void insertQuery(StoreSubGroupMstVO vo) {

		HisDAO dao = null;
		StoreSubGroupDAO storeSubGroupDAO = null;

		try {
			dao = new HisDAO("mms", "StoreSubGroupMstDAO");
			storeSubGroupDAO = new StoreSubGroupDAO();

			storeSubGroupDAO.setStrHospitalCode(vo.getStrHospitalCode());
			storeSubGroupDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			storeSubGroupDAO.setStrSubGroupName(vo.getStrSubGroupName());
			storeSubGroupDAO.setStrIsValid(vo.getStrIsValid());
			storeSubGroupDAO.setStrRemarks(vo.getStrRemarks());
			storeSubGroupDAO.setStrSeatId(vo.getStrSeatId());
			storeSubGroupDAO.setStrGroupId(vo.getStrGroupId());

			storeSubGroupDAO.insert(dao);

			synchronized (dao) {
				dao.fire();

			}

		} catch (Exception e) {
			vo.setStrMsgString("--> StoreSubGroupMstDAO.insertQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			storeSubGroupDAO = null;
		}
	}

	/**
	 * for getting group name combo on add page.
	 * 
	 * @param vo the vo
	 */
	public static void initAddQuery(StoreSubGroupMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "StoreSubGroupMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1, "select.itemCatName.1");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrItemCatId());

			wb = dao.executeQry(nqryIndex);

			while (wb.next()) {
				vo.setStrItemCatName(wb.getString(1));
			}

			strquery = mms.qryHandler_mms.getQuery(1, "select.groupName.1")
					.replace("?", Config.SUPER_USER_HOSPITAL_CODE);
			strquery = strquery.concat(" AND "
					+ mms.qryHandler_mms.getQuery(1, "select.groupName.cond.0")
							.replace("?", vo.getStrItemCatId()));
			nqryIndex = dao.setQuery(strquery);

			wb = dao.executeQry(nqryIndex);
			vo.setStrGrpNameComboWS(wb);

		} catch (Exception e) {
			vo.setStrMsgString("--> StoreSubGroupMstDAO.initAddQuery()-->"
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
	 * to check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */
	public static void initialAddQuery(StoreSubGroupMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";

		try {
			dao = new HisDAO("mms", "StoreSubGroupMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.subGroup.2");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrSubGroupName());
			dao.setQryValue(nqryIndex, 2, vo.getStrGroupId());
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
			vo.setStrMsgString("--> StoreSubGroupMstDAO.initialAddQuery()-->"
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
	public static void modifyQuery(StoreSubGroupMstVO vo) {

		HisDAO dao = null;

		int nqryIndex;
		String strquery = "";
		WebRowSet wb = null;
		WebRowSet web = null;
		WebRowSet wb1 = null;

		try {

			dao = new HisDAO("mms", "StoreSubGroupMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1, "select.itemCatName.1");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrItemCatId());

			wb = dao.executeQry(nqryIndex);

			while (wb.next()) {
				vo.setStrItemCatName(wb.getString(1));
			}
			strquery = mms.qryHandler_mms.getQuery(1, "select.subGroup.3");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrSubGroupId());

			web = dao.executeQry(nqryIndex);
			while (web.next()) {

				vo.setStrGroupId(web.getString(1));
				vo.setStrSubGroupName(web.getString(2));
				vo.setStrEffectiveFrom(web.getString(3));
				vo.setStrRemarks(web.getString(4));
				vo.setStrSeatId(web.getString(5));
				vo.setStrIsValid(web.getString(6));

			}

			strquery = mms.qryHandler_mms.getQuery(1, "select.subGroup.3.1");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrGroupId());

			wb1 = dao.executeQry(nqryIndex);
			while (wb1.next()) {
				vo.setStrGroupName(wb1.getString(1));

			}
			/*
			 * synchronized (dao) { dao.fire(); }
			 */
		} catch (Exception e) {
			vo.setStrMsgString("--> StoreSubGroupMstDAO.modifyQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wb = null;
			wb1 = null;
			web = null;
		}
	}

	/**
	 * to check duplicate before update.
	 * 
	 * @param vo the vo
	 */
	public static void updateQuery(StoreSubGroupMstVO vo) {

		HisDAO dao = null;
		StoreSubGroupDAO storeSubGroupDAO = null;

		try {

			dao = new HisDAO("mms", "StoreSubGroupMstDAO");
			storeSubGroupDAO = new StoreSubGroupDAO();

			storeSubGroupDAO.setStrHospitalCode(vo.getStrHospitalCode());
			storeSubGroupDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			storeSubGroupDAO.setStrSubGroupName(vo.getStrSubGroupName());
			storeSubGroupDAO.setStrIsValid(vo.getStrIsValid());
			storeSubGroupDAO.setStrRemarks(vo.getStrRemarks());
			storeSubGroupDAO.setStrSeatId(vo.getStrSeatId());
			storeSubGroupDAO.setStrSubGroupId(vo.getStrSubGroupId());
			
			storeSubGroupDAO.setStrGroupId(vo.getStrGroupId());
			storeSubGroupDAO.setStrSlNo(vo.getStrSlNo());
			
			
			storeSubGroupDAO.update(dao);

			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {
			vo.setStrMsgString("--> StoreSubGroupMstDAO.updateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			storeSubGroupDAO = null;
		}
	}

	/**
	 * to check duplicate before update.
	 * 
	 * @param vo the vo
	 */
	public static void initialUpdateQuery(StoreSubGroupMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";
		try {
			dao = new HisDAO("mms", "StoreSubGroupMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1, "select.subGroup.5");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrSubGroupId());

			wb = dao.executeQry(nqryIndex);
			while (wb.next()) {
				vo.setStrGroupId(wb.getString(1));
			}

			strquery = mms.qryHandler_mms.getQuery(1, "select.subGroup.4");

			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrSubGroupName());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrSubGroupId());
			dao.setQryValue(nqryIndex, 4, vo.getStrGroupId());

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
					.setStrMsgString("--> StoreSubGroupMstDAO.initialUpdateQuery()-->"
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
