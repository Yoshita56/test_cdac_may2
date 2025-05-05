package mms.masters.dao;

import hisglobal.transactionmgnt.HisDAO;
import javax.sql.rowset.WebRowSet;
import mms.dao.AuthorizationDAO;
import mms.masters.vo.AuthorizationMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthorizationMstDAO.
 */
public class AuthorizationMstDAO {

	/**
	 * Gets the user name.
	 * 
	 * @param vo the vo
	 * 
	 * @return the user name
	 */
	public static void getUserName(AuthorizationMstVO vo) {

		HisDAO dao = null;
		int nQryIndex;
		String strQuery = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "AuthorizationMstDAO");

			strQuery = mms.qryHandler_mms.getQuery(1, "select.authorization.6")
					.replace("?", vo.getStrHospitalCode());

			strQuery = strQuery.concat(" AND "
					+ mms.qryHandler_mms.getQuery(1,
							"select.authorization.cond.7").replace("?", "1"));
			nQryIndex = dao.setQuery(strQuery);

			wb = dao.executeQry(nQryIndex);

			vo.setStrUserNameComboWS(wb);

		} catch (Exception e) {
			vo.setStrMsgString("AuthorizationMstDAO.getUserName()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}
	}

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public static void insertQuery(AuthorizationMstVO vo) {
		HisDAO dao = null;
		AuthorizationDAO authorizationDao = null;

		try {
			authorizationDao = new AuthorizationDAO();
			dao = new HisDAO("mms", "AuthorizationMstDAO");

			authorizationDao.setStrHospitalCode(vo.getStrHospitalCode());
			authorizationDao.setStrStoreId(vo.getStrStoreId());
			authorizationDao.setStrAuthorizationTypeId(vo
					.getStrAuthorizationTypeId());
			authorizationDao.setStrUserId(vo.getStrUserId());
			authorizationDao.setStrAuthorizationLevel(vo
					.getStrAuthorizationLevel());
			authorizationDao.setStrCostForm(vo.getStrCostForm());
			authorizationDao.setStrCost(vo.getStrCost());
			authorizationDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			authorizationDao.setStrSeatId(vo.getStrSeatId());
			authorizationDao.setStrIsValid(vo.getStrIsValid());

			authorizationDao.insert(dao);

			synchronized (dao) {
				dao.fire();

			}
		} catch (Exception e) {
			vo.setStrMsgString("AuthorizationMstDAO.insertQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

			authorizationDao = null;

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
	public static void chkDuplicate(AuthorizationMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "AuthorizationMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.authorization.8");
			nqryIndex = dao.setQuery(strquery);
			// System.out.println("vo.getStrStoreId()"+vo.getStrStoreId());
			// System.out.println("vo.getStrAuthorizationType()"+vo.getStrAuthorizationTypeId());
			// System.out.println("vo.getStrUserId()"+vo.getStrStoreId());
			// System.out.println("vo.getStrHospitalCode()"+vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 1, vo.getStrStoreId());
			dao.setQryValue(nqryIndex, 2, vo.getStrAuthorizationTypeId());
			dao.setQryValue(nqryIndex, 3, vo.getStrUserId());
			dao.setQryValue(nqryIndex, 4, vo.getStrHospitalCode());
			wb = dao.executeQry(nqryIndex);
			while (wb.next()) {
				ncount = Integer.parseInt(wb.getString(1));
			}
			// System.out.println("ncount"+ncount);
			if (ncount == 0) {
				vo.setBExistStatus(true);
			} else {
				vo.setBExistStatus(false);
			}
		} catch (Exception e) {
			vo.setStrMsgString("AuthorizationMstDAO.chkDuplicate() --> "
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
	public static void modifyQuery(AuthorizationMstVO vo) {

		HisDAO dao = new HisDAO("mms", "AuthorizationMstDAO");

		int nqryIndex;
		String strquery = new String();

		try {
			strquery = mms.qryHandler_mms.getQuery(1, "select.authorization.3");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrAuthorizationSlNo());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());

			WebRowSet web = dao.executeQry(nqryIndex);
			while (web.next()) {
				vo.setStrAuthorizationType(web.getString(2));
				vo.setStrAuthorizationLevel(web.getString(3));
				vo.setStrCostForm(web.getString(1));
				vo.setStrCost(web.getString(4));
				vo.setStrEffectiveFrom(web.getString(5));
				vo.setStrIsValid(web.getString(6));
				vo.setStrUserId(web.getString(7));
			}

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.authorization.cond.3");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrUserId());

			WebRowSet wb = dao.executeQry(nqryIndex);
			while (wb.next()) {
				vo.setStrUserName(wb.getString(1));
			}

		} catch (Exception e) {
			vo.setStrMsgString("AuthorizationMstDAO.modifyQuery() --> "
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
	public static void updateQuery(AuthorizationMstVO vo) {

		HisDAO dao = null;
		AuthorizationDAO authorizationDao = null;
		try {
			authorizationDao = new AuthorizationDAO();
			dao = new HisDAO("mms", "AuthorizationMstDAO");

			authorizationDao.setStrCostForm(vo.getStrCostForm());
			authorizationDao.setStrCost(vo.getStrCost());
			authorizationDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			authorizationDao.setStrLastModifiedSeatId(vo
					.getStrLastModifiedSeatId());
			authorizationDao.setStrIsValid(vo.getStrIsValid());
			authorizationDao.setStrAuthorizationTypeId(vo
					.getStrAuthorizationTypeId());
			authorizationDao.setStrUserId(vo.getStrUserId());
			authorizationDao.setStrHospitalCode(vo.getStrHospitalCode());
			authorizationDao
					.setStrAuthorizationNo(vo.getStrAuthorizationSlNo());
			authorizationDao.update(dao);

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {
			vo.setStrMsgString("AuthorizationMstDAO.updateQuery() --> "
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
