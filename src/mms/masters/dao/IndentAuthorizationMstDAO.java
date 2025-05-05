package mms.masters.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.IndentAuthorizationDAO;
import mms.masters.vo.IndentAuthorizationMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class IndentAuthorizationMstDAO.
 */
public class IndentAuthorizationMstDAO {
	
	/**
	 * Inits the add query.
	 * 
	 * @param vo the vo
	 */
	public static void initAddQuery(IndentAuthorizationMstVO vo) {

		HisDAO dao = null;
		int nqryIndex = 0;
		int nqryIndex1 = 0;
		String strquery = "";
		String strquery1 = "";
		WebRowSet wb = null;

		// String strTableName = "";
		try {
			dao = new HisDAO("mms", "IndentAuthorizationMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.indentauthorization.previousdata.0");// Added
			// Item
			// Details
			// Query
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrIsValid());
			dao.setQryValue(nqryIndex, 3, vo.getStrStoreId());
			dao.setQryValue(nqryIndex, 4, vo.getStrItemCatNo());
			dao.setQryValue(nqryIndex, 5, vo.getStrAuthtypeForId());
			dao.setQryValue(nqryIndex, 6, vo.getStrTypeId());
			wb = dao.executeQry(nqryIndex);
			vo.setStrIndentAuthorizationDetails(wb);

			strquery1 = mms.qryHandler_mms.getQuery(1,
					"select.indentauthorization.empname.0");// Emp Name Combo
			// Query
			nqryIndex1 = dao.setQuery(strquery1);
			dao.setQryValue(nqryIndex1, 1, vo.getStrHospitalCode());

			wb = dao.executeQry(nqryIndex1);
			vo.setStrEmployeeNameComboWs(wb);

		} catch (Exception e) {
			vo
					.setStrMsgString("--> IndentAuthorizationMstDAO.initAddQuery()-->"
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
	public static void chkDuplicate(IndentAuthorizationMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();
		boolean flag = false;

		try {

			dao = new HisDAO("mms", "IndentAuthorizationMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.IndentAuthorizationMst.checkduplicate.0");
			nqryIndex = dao.setQuery(strquery);
			int nMultiRowLen = vo.getStrEmpId().length;
			for (int i = 0; i < nMultiRowLen; i++) {
				dao.setQryValue(nqryIndex, 1, vo.getStrEmpId()[i]);
				dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());

				wb = dao.executeQry(nqryIndex);
				while (wb.next()) {
					ncount = Integer.parseInt(wb.getString(1));
				}
				if (ncount != 0) {
					flag = true;
					break;
				}
			}
			if (flag)
				vo.setBExistStatus(false);
			else
				vo.setBExistStatus(true);

		} catch (Exception e) {
			vo.setStrMsgString("IndentAuthorizationMstDAO.chkDuplicate() --> "
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
	public static void insertQuery(IndentAuthorizationMstVO vo) {
		HisDAO dao = null;
		IndentAuthorizationDAO indentDao = null;

		try {
			indentDao = new IndentAuthorizationDAO();
			dao = new HisDAO("mms", "IndentAuthorizationMstDAO");

			int nMultiRowLen = vo.getStrEmpId().length;
			for (int i = 0; i < nMultiRowLen; i++) {
				indentDao.setStrHospitalCode(vo.getStrHospitalCode());
				indentDao.setStrAuthTypeId(vo.getStrAuthtypeForId());
				indentDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
				indentDao.setStrEmpId(vo.getStrEmpId()[i]);
				indentDao.setStrIndentTypeId(vo.getStrTypeId());
				indentDao.setStrIsValid(vo.getStrIsValid());
				indentDao.setStrItemCatNo(vo.getStrItemCatNo());
				indentDao.setStrLevel(vo.getStrLevel()[i]);
				indentDao.setStrSeatId(vo.getStrSeatId());
				indentDao.setStrStoreId(vo.getStrStoreId());
				indentDao.setStrRemarks(vo.getStrRemarks());
				indentDao.insert(dao);
			}
			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {

			vo.setStrMsgString("IndentAuthorizationMstDAO.insertQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

			indentDao = null;

		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 */
	public static void modifyQuery(IndentAuthorizationMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet web = null;
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "IndentAuthorizationMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.IndentAuthorizationMst.2");

			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());

			dao.setQryValue(nqryIndex, 2, vo.getStrAuthorizationNo());

			web = dao.executeQry(nqryIndex);

			while (web.next()) {
				vo.setStrAuthorizationNo(web.getString(1));
				vo.setStrEmployeeId(web.getString(2));
				vo.setStrLevel1(web.getString(3));
				vo.setStrRemarks(web.getString(4));
				vo.setStrIsValid(web.getString(5));
				vo.setStrEffectiveFrom(web.getString(6));

			}

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.indentauthorization.empname.0");// Emp Name Combo
			// Query
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());

			wb = dao.executeQry(nqryIndex);
			vo.setStrEmployeeNameComboWs(wb);

		} catch (Exception e) {
			vo.setStrMsgString("--> IndentAuthorizationMstDAO.modifyQuery()-->"
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
	public static void initialUpdateQuery(IndentAuthorizationMstVO vo) {

		HisDAO hisdao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;

		try {
			hisdao = new HisDAO("mms", "IndentAuthorizationMstDAO");
			String strquery = mms.qryHandler_mms.getQuery(1,
					"select.IndentAuthorizationMst.checkduplicate.1");

			nqryIndex = hisdao.setQuery(strquery);

			hisdao.setQryValue(nqryIndex, 1, vo.getStrEmployeeId());
			hisdao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			hisdao.setQryValue(nqryIndex, 3, vo.getStrAuthorizationNo());

			wb = hisdao.executeQry(nqryIndex);

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
					.setStrMsgString("--> IndentAuthorizationMstDAO.initialUpdateQuery()-->"
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
	public static void updateQuery(IndentAuthorizationMstVO vo) {

		HisDAO dao = null;
		IndentAuthorizationDAO indentDao = null;

		try {

			dao = new HisDAO("mms", "IndentAuthorizationMstDAO");
			indentDao = new IndentAuthorizationDAO();

			indentDao.setStrHospitalCode(vo.getStrHospitalCode());
			indentDao.setStrAuthorizationNo(vo.getStrAuthorizationNo());
			indentDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			indentDao.setStrEmpId(vo.getStrEmployeeId());

			indentDao.setStrIsValid(vo.getStrIsValid());

			indentDao.setStrLevel(vo.getStrLevel1());
			indentDao.setStrSeatId(vo.getStrSeatId());

			indentDao.setStrRemarks(vo.getStrRemarks());

			indentDao.update(dao);

			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {
			vo.setStrMsgString("--> IndentAuthorizationMstDAO.updateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			indentDao = null;
		}

	}

}
