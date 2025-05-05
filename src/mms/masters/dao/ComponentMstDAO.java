package mms.masters.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.ComponentDAO;

import mms.masters.vo.ComponentMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ComponentMstDAO.
 * 
 * @author manas
 */

public class ComponentMstDAO {

	/**
	 * for getting option value of item category name combo on add page.
	 * 
	 * @param vo the vo
	 */

	public static void comboQuery(ComponentMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "ComponentMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.componentMst.5")
					.replace("?", vo.getStrHospitalCode());
			strquery = strquery.concat(" AND "
					+ mms.qryHandler_mms.getQuery(1,
							"select.componentMst.cond.5").replace("?", "1"));
			nqryIndex = dao.setQuery(strquery);

			wb = dao.executeQry(nqryIndex);
			vo.setStrItemCategoryCmbWs(wb);

		} catch (Exception e) {
			vo.setStrMsgString("--> ComponentMstDAO.comboQuery()-->"
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

	public static void checkDuplicate(ComponentMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";
		try {
			dao = new HisDAO("mms", "ComponentMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.componentMst.2");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrComponentName());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			//dao.setQryValue(nqryIndex, 3, vo.getStrItemCategoryId());

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
			vo.setStrMsgString("--> ComponentMstDAO.checkDuplicate()-->"
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

	public static void insertQuery(ComponentMstVO vo) {

		HisDAO dao = null;
		ComponentDAO componentDAO = null;

		try {
			componentDAO = new ComponentDAO();
			dao = new HisDAO("mms", "ComponentDAO");

			componentDAO.setStrHospitalCode(vo.getStrHospitalCode());
			componentDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			componentDAO.setStrIsValid(vo.getStrIsValid());
			componentDAO.setStrRemarks(vo.getStrRemarks());
			componentDAO.setStrSeatId(vo.getStrSeatId());
			//componentDAO.setStrItemCategoryNo(vo.getStrItemCategoryId());
			componentDAO.setStrComponentName(vo.getStrComponentName());

			componentDAO.insert(dao);

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> ComponentMstDAO.insertQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			componentDAO = null;
		}
	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 */

	public static void modifyQuery(ComponentMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";

		try {

			dao = new HisDAO("mms", "ComponentMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.componentMst.3");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrComponentId());
			dao.setQryValue(nqryIndex, 3, vo.getStrSlNo());
			WebRowSet web = dao.executeQry(nqryIndex);
			while (web.next()) {
				//vo.setStrItemCategoryName(web.getString(1));
				vo.setStrComponentName(web.getString(1));
				vo.setStrEffectiveFrom(web.getString(2));
				vo.setStrRemarks(web.getString(3));
				vo.setStrSeatId(web.getString(4));
				vo.setStrIsValid(web.getString(5));
			}
		} catch (Exception e) {
			vo.setStrMsgString("--> ComponentMstDAO.modifyQuery()-->"
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

	public static void checkDuplicateRecord(ComponentMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";
		try {
			dao = new HisDAO("mms", "ComponentMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.componentMst.4");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrComponentName());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrComponentId());
			//dao.setQryValue(nqryIndex, 4, vo.getStrItemCategoryId());
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
			vo.setStrMsgString("--> ComponentMstDAO.initialUpdateQuery()-->"
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

	public static void updateQuery(ComponentMstVO vo) {

		ComponentDAO componentDAO = null;
		HisDAO dao = null;

		try {
			componentDAO = new ComponentDAO();
			dao = new HisDAO("mms", "ComponentMstDAO");

			componentDAO.setStrHospitalCode(vo.getStrHospitalCode());
			componentDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			componentDAO.setStrIsValid(vo.getStrIsValid());
			componentDAO.setStrRemarks(vo.getStrRemarks());
			componentDAO.setStrSeatId(vo.getStrSeatId());
			componentDAO.setStrSlNo(vo.getStrSlNo());
		//	componentDAO.setStrItemCategoryNo(vo.getStrItemCategoryId());
			componentDAO.setStrComponentName(vo.getStrComponentName());
			componentDAO.setStrComponentId(vo.getStrComponentId());

			componentDAO.update(dao);

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
			componentDAO = null;

		}

	}
}
