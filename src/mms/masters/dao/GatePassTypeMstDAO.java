package mms.masters.dao;

import hisglobal.transactionmgnt.HisDAO;
import javax.sql.rowset.WebRowSet;

import mms.dao.GatePassTypeDAO;
import mms.masters.vo.GatePassTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class GatePassTypeMstDAO.
 */
public class GatePassTypeMstDAO {

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public static void insertQuery(GatePassTypeMstVO vo) {

		HisDAO dao = null;
		GatePassTypeDAO gatePassTypeDao = null;

		try {
			gatePassTypeDao = new GatePassTypeDAO();
			dao = new HisDAO("mms", "GatePassTypeMstDAO");

			gatePassTypeDao.setStrHospitalCode(vo.getStrHospitalCode());
			gatePassTypeDao.setStrGatePassTypeName(vo.getStrGatePassTypeName());
			gatePassTypeDao.setStrRemarks(vo.getStrRemarks());
			gatePassTypeDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			gatePassTypeDao.setStrSeatId(vo.getStrSeatId());
			gatePassTypeDao.setStrIsValid(vo.getStrIsValid());
			gatePassTypeDao.insert(dao);
			synchronized (dao) {
				dao.fire();

			}
		} catch (Exception e) {

			e.printStackTrace();

			vo.setStrMsgString("GatePassTypeMstDAO.insertQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

			gatePassTypeDao = null;

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
	public static void chkDuplicate(GatePassTypeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "GatePassTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.GatePassMst.2");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrGatePassTypeName());
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
			vo.setStrMsgString("GatePassTypeMstDAO.chkDuplicate() --> "
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
	public static void modifyQuery(GatePassTypeMstVO vo) {

		HisDAO dao = new HisDAO("mms", "GatePassTypeMstDAO");

		int nqryIndex;
		String strquery = new String();

		try {

			strquery = mms.qryHandler_mms.getQuery(1, "select.GatePassMst.3");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrGatePassTypeCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrSlNo());

			WebRowSet web = dao.executeQry(nqryIndex);
			while (web.next()) {
				vo.setStrGatePassTypeName(web.getString(1));
				vo.setStrRemarks(web.getString(2));
				vo.setStrEffectiveFrom(web.getString(3));
				vo.setStrIsValid(web.getString(4));
			}
		} catch (Exception e) {

			vo.setStrMsgString("GatePassTypeMstDAO.modifyQuery() --> "
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
	public static void updateQuery(GatePassTypeMstVO vo) {

		HisDAO dao = null;

		GatePassTypeDAO gatePassTypeDao = null;

		try {
			gatePassTypeDao = new GatePassTypeDAO();
			dao = new HisDAO("mms", "GatePassTypeMstDAO");

			gatePassTypeDao.setStrGatePassTypeName(vo.getStrGatePassTypeName());
			gatePassTypeDao.setStrRemarks(vo.getStrRemarks());
			gatePassTypeDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			gatePassTypeDao.setStrLastModifiedSeatId(vo
					.getStrLastModifiedSeatId());
			gatePassTypeDao.setStrSeatId(vo.getStrSeatId());
			gatePassTypeDao.setStrSlNo(vo.getStrSlNo());
			gatePassTypeDao.setStrIsValid(vo.getStrIsValid());
			gatePassTypeDao.setStrGatePassTypeCode(vo.getStrGatePassTypeCode());
			gatePassTypeDao.setStrHospitalCode(vo.getStrHospitalCode());
			gatePassTypeDao.update(dao);

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {
			vo.setStrMsgString("GatePassTypeMstDAO.updateQuery() --> "
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
	public static void initialUpdateQuery(GatePassTypeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "GatePassTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.GatePassMst.4");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrGatePassTypeCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrGatePassTypeName());
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
			vo.setStrMsgString("GatePassTypeMstDAO.initialUpdateQuery() --> "
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
