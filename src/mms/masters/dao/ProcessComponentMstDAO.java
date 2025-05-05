package mms.masters.dao;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.ProcessComponentDAO;
import mms.masters.vo.ProcessComponentMstVO;
import mms.masters.vo.StoreTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcessComponentMstDAO.
 * 
 * @author Anurudra Goel
 */
public class ProcessComponentMstDAO {

	/**
	 * for getting option value of Component name combo on add page.
	 * 
	 * @param vo the vo
	 */
	public static void initAddQuery(ProcessComponentMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "ProcessComponentMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.processComponentMst.4").replace("?",
					vo.getStrHospitalCode());
			nqryIndex = dao.setQuery(strquery);
			wb = dao.executeQry(nqryIndex);
			vo.setWSProcessName(wb);
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.processComponentMst.5").replace("?",
					Config.SUPER_USER_HOSPITAL_CODE);
			nqryIndex = dao.setQuery(strquery);
			wb = dao.executeQry(nqryIndex);
			vo.setWSComponentName(wb);
		} catch (Exception e) {
			vo.setStrMsgString("--> ProcessComponentMstDAO.initAddQuery()-->"
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
	public static void insertQuery(ProcessComponentMstVO vo) {

		HisDAO dao = null;
		ProcessComponentDAO processComponentDAO = null;

		try {
			processComponentDAO = new ProcessComponentDAO();
			dao = new HisDAO("mms", "ProcessComponentMstDAO");
			processComponentDAO.setStrHospitalCode(vo.getStrHospitalCode());
			processComponentDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			processComponentDAO.setStrSeatId(vo.getStrSeatId());
			processComponentDAO.setStrProcessId(vo.getStrProcessNameId());
			processComponentDAO.setStrComponentId(vo.getStrComponentName());
			processComponentDAO
					.setStrComponenValue1(vo.getStrComponentValue1());
			processComponentDAO
					.setStrComponenValue2(vo.getStrComponentValue2());
			processComponentDAO.setStrRemarks(vo.getStrRemarks());
			processComponentDAO.setStrIsValid(vo.getStrIsValid());
			processComponentDAO.insert(dao);

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {

			vo.setStrMsgString("--> ProcessComponentMstDAO.insertQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			processComponentDAO = null;
		}
	}

	/**
	 * to check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */
	public static void initialAddQuery(ProcessComponentMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";
		try {
			dao = new HisDAO("mms", "ProcessComponentMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.processComponentMst.2");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrComponentName());
			dao.setQryValue(nqryIndex, 2, vo.getStrProcessNameId());
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
			vo
					.setStrMsgString("--> ProcessComponentMstDAO.initialAddQuery()-->"
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
	public static void modifyQuery(ProcessComponentMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";

		try {

			dao = new HisDAO("mms", "ProcessComponentMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.processComponentMst.3");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrProcessNameId());
			dao.setQryValue(nqryIndex, 2, vo.getStrComponentId());
			dao.setQryValue(nqryIndex, 3, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 4, vo.getStrProcessComponentSlNo());
			WebRowSet web = dao.executeQry(nqryIndex);
			while (web.next()) {
				vo.setStrComponentValue1Values(web.getString(1));
				vo.setStrComponentValue2Values(web.getString(2));
				vo.setStrRemarks(web.getString(3));
				vo.setStrEffectiveFrom(web.getString(4));

				vo.setStrIsValid(web.getString(5));
				vo.setStrComponentNameModify(web.getString(6));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("--> ProcessComponentMstDAO.modifyQuery()-->"
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
	public static void updateQuery(ProcessComponentMstVO vo) {

		ProcessComponentDAO processComponent = null;
		HisDAO dao = null;

		try {
			processComponent = new ProcessComponentDAO();
			dao = new HisDAO("mms", "ProcessComponentMstDAO");
			processComponent.setStrComponenValue1(vo.getStrComponentValue1());
			processComponent.setStrComponenValue2(vo.getStrComponentValue2());
			processComponent.setStrRemarks(vo.getStrRemarks());
			processComponent.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			processComponent.setStrHospitalCode(vo.getStrHospitalCode());
			processComponent.setStrSeatId(vo.getStrSeatId());
			processComponent.setStrIsValid(vo.getStrIsValid());
			processComponent.setStrComponentId(vo.getStrComponentName());
			processComponent.setStrProcessId(vo.getStrProcessNameId());
			processComponent.setStrProcessComponentSlno(vo
					.getStrProcessComponentSlNo());
			processComponent.update(dao);
			synchronized (dao) {
				dao.fire();

			}
		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("--> ProcessComponentMstDAO.updateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			processComponent = null;

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
			dao = new HisDAO("mms", "ProcessComponentMstDAO");
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
			vo
					.setStrMsgString("--> ProcessComponentMstDAO.initialUpdateQuery()-->"
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
