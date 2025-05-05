package mms.masters.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.SupplierGradeDAO;
import mms.masters.vo.SupplierGradeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierGradeMstDAO.
 * 
 * @author Tanvi Sappal
 */
public class SupplierGradeMstDAO {

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public static void insertQuery(SupplierGradeMstVO vo) {
		HisDAO dao = null;
		SupplierGradeDAO SupplierGradeDao = null;

		try {
			SupplierGradeDao = new SupplierGradeDAO();
			dao = new HisDAO("mms", "SupplierGradeMstDAO");

			SupplierGradeDao = new SupplierGradeDAO();
			SupplierGradeDao.setStrHospitalCode(vo.getStrHospitalCode());
			SupplierGradeDao.setStrGradeName(vo.getStrGradeName());
			SupplierGradeDao.setStrGradeCriteria(vo.getStrGradeCriteria());
			SupplierGradeDao.setStrRemarks(vo.getStrRemarks());
			SupplierGradeDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			SupplierGradeDao.setStrSeatId(vo.getStrSeatId());
			SupplierGradeDao.setStrIsValid("1");
			SupplierGradeDao.setStrHospitalCode(vo.getStrHospitalCode());
			SupplierGradeDao.insert(dao);
			synchronized (dao) {
				dao.fire();

			}
		} catch (Exception e) {
			vo.setStrMsgString("SupplierGradeMstDAO.insertQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

			SupplierGradeDao = null;

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
	public static void chkDuplicate(SupplierGradeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "SupplierGradeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.SupplierGradeMst.2");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrGradeName());
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
			vo.setStrMsgString("SupplierGradeMstDAO.chkDuplicate() --> "
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
	public static void modifyQuery(SupplierGradeMstVO vo) {

		HisDAO dao = new HisDAO("mms", "SupplierGradeMstDAO");

		int nqryIndex;
		String strquery = new String();

		try {

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.SupplierGradeMst.3");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrSupplierGradeId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrSlNo());

			WebRowSet web = dao.executeQry(nqryIndex);
			while (web.next()) {
				vo.setStrGradeName(web.getString(1));
				vo.setStrGradeCriteria(web.getString(2));
				vo.setStrRemarks(web.getString(3));
				vo.setStrEffectiveFrom(web.getString(4));
				vo.setStrIsValid(web.getString(5));
			}
		} catch (Exception e) {

			vo.setStrMsgString("SupplierGradeMstDAO.modifyQuery() --> "
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
	public static void updateQuery(SupplierGradeMstVO vo) {

		HisDAO dao = null;

		SupplierGradeDAO SupplierGradeDao = null;

		try {
			SupplierGradeDao = new SupplierGradeDAO();
			dao = new HisDAO("mms", "SupplierGradeMstDAO");

			SupplierGradeDao.setStrGradeName(vo.getStrGradeName());
			SupplierGradeDao.setStrGradeCriteria(vo.getStrGradeCriteria());
			SupplierGradeDao.setStrRemarks(vo.getStrRemarks());
			SupplierGradeDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			SupplierGradeDao.setStrLastModifiedSeatId(vo.getStrLastModifiedSeatId());
			SupplierGradeDao.setStrSeatId(vo.getStrSeatId());
			SupplierGradeDao.setStrIsValid(vo.getStrIsValid());
			SupplierGradeDao.setStrSupplierGradeId(vo.getStrSupplierGradeId());
			SupplierGradeDao.setStrHospitalCode(vo.getStrHospitalCode());			
			SupplierGradeDao.setStrSlNo(vo.getStrSlNo());
			
			SupplierGradeDao.update(dao);

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {
			vo.setStrMsgString("SupplierGradeMstDAO.updateQuery() --> "
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
	public static void initialUpdateQuery(SupplierGradeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "SupplierGradeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.SupplierGradeMst.4");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrSupplierGradeId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrGradeName());
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
			vo.setStrMsgString("SupplierGradeMstDAO.initialUpdateQuery() --> "
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
