package mms.masters.dao;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.StoreGroupDAO;
import mms.masters.vo.StoreGroupMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreGroupMstDAO.
 * 
 * @author Anshul Jindal
 */

public class StoreGroupMstDAO {

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public static void insertQuery(StoreGroupMstVO vo) {

		StoreGroupDAO storeGroupDAO = null;
		HisDAO dao = null;

		try {
			storeGroupDAO = new StoreGroupDAO();
			dao = new HisDAO("mms", "DAOStoreGroupMst");

			storeGroupDAO.setStrHospitalCode(vo.getStrHospitalCode());
			storeGroupDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			storeGroupDAO.setStrGroupName(vo.getStrGroupName());
			storeGroupDAO.setStrIsValid(vo.getStrIsValid());
			storeGroupDAO.setStrRemarks(vo.getStrRemarks());
			storeGroupDAO.setStrSeatId(vo.getStrSeatId());
			storeGroupDAO.setStrItemCatId(vo.getStrItemCatId());

			storeGroupDAO.insert(dao);

			synchronized (dao) {
				dao.fire();

			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> StoreGroupMstDAO.insertQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			storeGroupDAO = null;
		}

	}

	/**
	 * to check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */
	public static void chkDuplicate(StoreGroupMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";

		try {
			dao = new HisDAO("mms", "DAOStoreGroupMst");
			strquery = mms.qryHandler_mms.getQuery(1, "select.StoreGroup.2");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrGroupName());
			dao.setQryValue(nqryIndex, 2, vo.getStrItemCatId());
			dao.setQryValue(nqryIndex, 3, Config.SUPER_USER_HOSPITAL_CODE);

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
			vo.setStrMsgString("--> StoreGroupMstDAO.chkDuplicate()-->"
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
	public static void modifyQuery(StoreGroupMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";

		try {

			dao = new HisDAO("mms", "DAOStoreGroupMst");
			strquery = mms.qryHandler_mms.getQuery(1, "select.storeGroup.3");

			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nqryIndex, 2, vo.getStrGroupId());

			WebRowSet web = dao.executeQry(nqryIndex);

			while (web.next()) {
				vo.setStrItemCatId(web.getString(1));
				vo.setStrGroupName(web.getString(2));
				vo.setStrEffectiveFrom(web.getString(3));
				vo.setStrRemarks(web.getString(4));
				vo.setStrIsValid(web.getString(5));

			}

		} catch (Exception e) {
			vo.setStrMsgString("--> StoreGroupMstDAO.modifyQuery()-->"
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
	public static void initialUpdateQuery(StoreGroupMstVO vo) {

		HisDAO dao = null;
		String strquery = "";
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "DAOStoreGroupMst");
			strquery = mms.qryHandler_mms.getQuery(1, "select.storeGroup.4");

			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrGroupName());
			dao.setQryValue(nqryIndex, 2, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nqryIndex, 3, vo.getStrGroupId());
			dao.setQryValue(nqryIndex, 4, vo.getStrItemCatId());

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
			vo.setStrMsgString("--> StoreGroupMstDAO.initialUpdateQuery()-->"
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
	public static void updateQuery(StoreGroupMstVO vo) {

		StoreGroupDAO storeGroupDAO = null;
		HisDAO dao = null;
		try {
			storeGroupDAO = new StoreGroupDAO();
			dao = new HisDAO("mms", "DAOStoreGroupMst");

			storeGroupDAO.setStrHospitalCode(vo.getStrHospitalCode());
			storeGroupDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			storeGroupDAO.setStrGroupName(vo.getStrGroupName());
			storeGroupDAO.setStrIsValid(vo.getStrIsValid());
			storeGroupDAO.setStrRemarks(vo.getStrRemarks());
			storeGroupDAO.setStrSeatId(vo.getStrSeatId());
			storeGroupDAO.setStrGroupId(vo.getStrGroupId());
			storeGroupDAO.setStrSlNo(vo.getStrSlNo());
			storeGroupDAO.setStrItemCatId(vo.getStrItemCatId());
			
			storeGroupDAO.update(dao);

			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {
			vo.setStrMsgString("--> StoreGroupMstDAO.updateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			storeGroupDAO = null;
		}
	}

}
