package mms.masters.dao;

import hisglobal.transactionmgnt.HisDAO;
import javax.sql.rowset.WebRowSet;

import mms.dao.MaintenanceTypeDAO;
import mms.masters.vo.MaintenanceTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class MaintenanceTypeMstDAO.
 */
public class MaintenanceTypeMstDAO {
	
	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public static void insertQuery(MaintenanceTypeMstVO vo) {
		HisDAO dao = null;
		MaintenanceTypeDAO maintenanceTypeDao = null;

		try {
			maintenanceTypeDao = new MaintenanceTypeDAO();
			dao = new HisDAO("mms", "MaintenanceTypeMstDAO");

			maintenanceTypeDao.setStrHospitalCode(vo.getStrHospitalCode());
			maintenanceTypeDao.setStrMaintenanceTypeName(vo
					.getStrMaintenanceTypeName());
			maintenanceTypeDao.setStrRemarks(vo.getStrRemarks());
			maintenanceTypeDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			maintenanceTypeDao.setStrSeatId(vo.getStrSeatId());
			maintenanceTypeDao.setStrIsValid(vo.getStrIsValid());
			maintenanceTypeDao.insert(dao);
			synchronized (dao) {
				dao.fire();

			}
		} catch (Exception e) {

			e.printStackTrace();

			vo.setStrMsgString("MaintenanceTypeMstDAO.insertQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

			maintenanceTypeDao = null;

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
	public static void chkDuplicate(MaintenanceTypeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "MaintenanceTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.MaintenanceTypeMst.2");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrMaintenanceTypeName());
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
			vo.setStrMsgString("MaintenanceTypeMstDAO.chkDuplicate() --> "
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
	public static void modifyQuery(MaintenanceTypeMstVO vo) {

		HisDAO dao = new HisDAO("mms", "MaintenanceTypeMstDAO");

		int nqryIndex;
		String strquery = new String();

		try {

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.MaintenanceTypeMst.3");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrMaintenanceTypeCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrSlNo());

			WebRowSet web = dao.executeQry(nqryIndex);
			while (web.next()) {
				vo.setStrMaintenanceTypeName(web.getString(1));
				vo.setStrRemarks(web.getString(2));
				vo.setStrEffectiveFrom(web.getString(3));
				vo.setStrIsValid(web.getString(4));
			}
		} catch (Exception e) {

			vo.setStrMsgString("MaintenanceTypeMstDAO.modifyQuery() --> "
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
	public static void updateQuery(MaintenanceTypeMstVO vo) {

		HisDAO dao = null;

		MaintenanceTypeDAO maintenanceTypeDao = null;

		try {
			maintenanceTypeDao = new MaintenanceTypeDAO();
			dao = new HisDAO("mms", "MaintenanceTypeMstDAO");

			maintenanceTypeDao.setStrMaintenanceTypeName(vo
					.getStrMaintenanceTypeName());
			maintenanceTypeDao.setStrRemarks(vo.getStrRemarks());
			maintenanceTypeDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			maintenanceTypeDao.setStrSeatId(vo.getStrSeatId());
			maintenanceTypeDao.setStrSlNo(vo.getStrSlNo());
			maintenanceTypeDao.setStrIsValid(vo.getStrIsValid());
			maintenanceTypeDao.setStrMaintenanceTypeCode(vo
					.getStrMaintenanceTypeCode());
			maintenanceTypeDao.setStrHospitalCode(vo.getStrHospitalCode());
			maintenanceTypeDao.update(dao);

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {
			vo.setStrMsgString("MaintenanceTypeMstDAO.updateQuery() --> "
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
	public static void initialUpdateQuery(MaintenanceTypeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "MaintenanceTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.MaintenanceTypeMst.4");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrMaintenanceTypeCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrMaintenanceTypeName());
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
					.setStrMsgString("MaintenanceTypeMstDAO.initialUpdateQuery() --> "
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
