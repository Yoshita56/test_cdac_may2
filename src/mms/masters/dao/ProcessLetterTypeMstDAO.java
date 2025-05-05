package mms.masters.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;
import mms.dao.ProcessLetterTypeDAO;
import mms.masters.vo.ProcessLetterTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcessLetterTypeMstDAO.
 * 
 * @author Tanvi Sappal
 */
public class ProcessLetterTypeMstDAO {

	/**
	 * for getting option value of combo on add page (store type name ).
	 * 
	 * @param vo the vo
	 */

	public static void initialAddQuery(ProcessLetterTypeMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";

		try {
			dao = new HisDAO("mms", "ProcessLetterTypeMstDAO");
			strquery = mms.qryHandler_mms
					.getQuery(1, "select.StoreTypeCombo.0");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
			wb = dao.executeQry(nqryIndex);
			vo.setStoreTypeComboWS(wb);
		} catch (Exception e) {
			vo
					.setStrMsgString("--> ProcessLetterTypeMstDAO.initialAddQuery()-->"
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * Left list add query.
	 * 
	 * @param vo the vo
	 */
	public static void leftListAddQuery(ProcessLetterTypeMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";

		try {
			dao = new HisDAO("mms", "ProcessLetterTypeMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.LeftSideListBox.0");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrStoreTypeId());
			wb = dao.executeQry(nqryIndex);
			vo.setLeftListWS(wb);
		} catch (Exception e) {
			vo
					.setStrMsgString("--> ProcessLetterTypeMstDAO.initialAddQuery()-->"
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * Right list add query.
	 * 
	 * @param vo the vo
	 */
	public static void rightListAddQuery(ProcessLetterTypeMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";

		try {
			dao = new HisDAO("mms", "ProcessLetterTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.RightSideListBox.0");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrProcessId());
			wb = dao.executeQry(nqryIndex);
			{
				vo.setRightListWS(wb);
			}
		} catch (Exception e) {
			e.printStackTrace();

			vo
					.setStrMsgString("--> ProcessLetterTypeMstDAO.rightListAddQuery()-->"
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
	public static void insertQuery(ProcessLetterTypeMstVO vo) {
		HisDAO dao = null;
		ProcessLetterTypeDAO processLetterTypeDao = null;

		try {
			processLetterTypeDao = new ProcessLetterTypeDAO();
			dao = new HisDAO("mms", "ProcessLetterTypeMstDAO");
			String strTemp[] = vo.getStrRightLetterName();
			for (int i = 0 , stopI = strTemp.length; i < stopI; i++) {

				processLetterTypeDao
						.setStrHospitalCode(vo.getStrHospitalCode());
				processLetterTypeDao.setStrRightLetterTypeId(strTemp[i]);
				processLetterTypeDao.setStrProcessId(vo.getStrProcessId());
				/*
				 * processLetterTypeDao.setStrLetterTypeId(strTemp[i]);
				 * processLetterTypeDao.setStrProcessId(vo.getStrProcessId());
				 * processLetterTypeDao.setStrHospitalCode(vo.getStrHospitalCode());
				 */
				processLetterTypeDao.setStrEffectiveFrom(vo
						.getStrEffectiveFrom());
				processLetterTypeDao.setStrRemarks(vo.getStrRemarks());
				processLetterTypeDao.setStrSeatId(vo.getStrSeatId());
				processLetterTypeDao.setStrIsValid(vo.getStrIsValid());
				processLetterTypeDao.insert(dao);
			}

			synchronized (dao) {
				dao.fire();

			}
		} catch (Exception e) {
			vo.setStrMsgString("ProcessLetterTypeMstDAO.insertQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

			processLetterTypeDao = null;

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
	public static void chkDuplicate(ProcessLetterTypeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "ProcessLetterTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.ProcessLetterTypeMst.2");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrLetterTypeName());
			dao.setQryValue(nqryIndex, 2, vo.getStrLetterTypeId());
			dao.setQryValue(nqryIndex, 3, vo.getStrProcessId());
			dao.setQryValue(nqryIndex, 4, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 5, vo.getStrProcessSlNo().equalsIgnoreCase("")?"0":vo.getStrProcessSlNo());
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
			vo.setStrMsgString("ProcessLetterTypeMstDAO.chkDuplicate() --> "
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
	public static void modifyQuery(ProcessLetterTypeMstVO vo) {

		HisDAO dao = new HisDAO("mms", "ProcessLetterTypeMstDAO");

		int nqryIndex;
		String strquery = new String();

		try {

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.ProcessLetterTypeMst.3");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrLetterTypeId());
			dao.setQryValue(nqryIndex, 2, vo.getStrProcessId());
			dao.setQryValue(nqryIndex, 3, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 4, vo.getStrProcessSlNo());

			WebRowSet web = dao.executeQry(nqryIndex);
			while (web.next()) {
				vo.setStrLetterTypeName(web.getString(1));
				vo.setStrRemarks(web.getString(2));
				vo.setStrEffectiveFrom(web.getString(3));
				vo.setStrIsValid(web.getString(4));
			}
		} catch (Exception e) {

			vo.setStrMsgString("ProcessLetterTypeMstDAO.modifyQuery() --> "
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
	public static void updateQuery(ProcessLetterTypeMstVO vo) {

		HisDAO dao = null;

		ProcessLetterTypeDAO processLetterTypeDao = null;

		try {
			processLetterTypeDao = new ProcessLetterTypeDAO();
			dao = new HisDAO("mms", "ProcessLetterTypeMstDAO");

			processLetterTypeDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			processLetterTypeDao.setStrLastModifiedSeatId(vo
					.getStrLastModifiedSeatId());
			processLetterTypeDao.setStrRemarks(vo.getStrRemarks());
			processLetterTypeDao.setStrIsValid(vo.getStrIsValid());
			processLetterTypeDao.setStrLetterTypeId(vo.getStrLetterTypeId());
			processLetterTypeDao.setStrProcessId(vo.getStrProcessId());
			processLetterTypeDao.setStrHospitalCode(vo.getStrHospitalCode());
			processLetterTypeDao.setStrProcessSlNo(vo.getStrProcessSlNo());
			processLetterTypeDao.update(dao);

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {
			vo.setStrMsgString("ProcessLetterTypeMstDAO.updateQuery() --> "
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
	public static void initialUpdateQuery(ProcessLetterTypeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "ProcessLetterTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.LetterTypeMst.4");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrLetterTypeId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrLetterTypeName());
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
					.setStrMsgString("ProcessLetterTypeMstDAO.initialUpdateQuery() --> "
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
