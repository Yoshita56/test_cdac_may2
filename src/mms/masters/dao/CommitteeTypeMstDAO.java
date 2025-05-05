package mms.masters.dao;

import javax.sql.rowset.WebRowSet;

import mms.dao.CommitteeTypeDAO;
import mms.masters.vo.CommitteeTypeMstVO;
import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class CommitteeTypeMstDAO.
 * 
 * @author Tanvi Sappal
 */

public class CommitteeTypeMstDAO {

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public static void insertQuery(CommitteeTypeMstVO vo) {
		HisDAO dao = null;
		CommitteeTypeDAO committeeTypeDao = null;

		try {
			committeeTypeDao = new CommitteeTypeDAO();
			dao = new HisDAO("mms", "CommitteeTypeMstDAO");

			committeeTypeDao.setStrHospitalCode(vo.getStrHospitalCode());
			committeeTypeDao.setStrItemCatNo(vo.getStrItemCatNo());
			//committeeTypeDao.setStrProcessId(vo.getStrProcessId());
			committeeTypeDao.setStrCommitteeTypeName(vo.getStrCommitteeTypeName());
			committeeTypeDao.setStrCommitteePurpose(vo.getStrCommitteePurpose());
			committeeTypeDao.setStrRemarks(vo.getStrRemarks());
			committeeTypeDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			committeeTypeDao.setStrSeatId(vo.getStrSeatId());
			committeeTypeDao.setStrIsValid(vo.getStrIsValid());
			//committeeTypeDao.setStrHospitalCode(vo.getStrHospitalCode());
			committeeTypeDao.insert(dao);

			synchronized (dao) {
				dao.fire();

			}
		} catch (Exception e) {
			vo.setStrMsgString("CommitteeTypeMstDAO.insertQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

			committeeTypeDao = null;

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
	public static void chkDuplicate(CommitteeTypeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "CommitteeTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.CommitteeTypeMst.2");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrCommitteeTypeName());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			//dao.setQryValue(nqryIndex, 3, vo.getStrItemCatNo());
			//dao.setQryValue(nqryIndex, 3, vo.getStrProcessId());
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
			vo.setStrMsgString("CommitteeTypeMstDAO.chkDuplicate() --> "
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
	public static void modifyQuery(CommitteeTypeMstVO vo) {

		HisDAO dao = new HisDAO("mms", "CommitteeTypeMstDAO");

		int nqryIndex;
		String strquery = new String();

		try {

			strquery = mms.qryHandler_mms.getQuery(1,"select.CommitteeTypeMst.3");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrCommitteeTypeId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrSlNo());

			WebRowSet web = dao.executeQry(nqryIndex);
			while (web.next()) {
				vo.setStrCommitteeTypeName(web.getString(1));
				vo.setStrCommitteePurpose(web.getString(2));
				vo.setStrRemarks(web.getString(3));
				vo.setStrEffectiveFrom(web.getString(4));
				vo.setStrIsValid(web.getString(5));
			}
		} catch (Exception e) {

			vo.setStrMsgString("CommitteeTypeMstDAO.modifyQuery() --> "
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
	public static void updateQuery(CommitteeTypeMstVO vo) {

		HisDAO dao = null;

		CommitteeTypeDAO CommitteeTypeDao = null;

		try {
			CommitteeTypeDao = new CommitteeTypeDAO();
			dao = new HisDAO("mms", "CommitteeTypeMstDAO");

			CommitteeTypeDao.setStrCommitteeTypeName(vo
					.getStrCommitteeTypeName());
			CommitteeTypeDao
					.setStrCommitteePurpose(vo.getStrCommitteePurpose());
			CommitteeTypeDao.setStrRemarks(vo.getStrRemarks());
			CommitteeTypeDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			CommitteeTypeDao.setStrLastModifiedSeatId(vo
					.getStrLastModifiedSeatId());
			CommitteeTypeDao.setStrSeatId(vo.getStrSeatId());
		    CommitteeTypeDao.setStrSlNo(vo.getStrSlNo());
			CommitteeTypeDao.setStrIsValid(vo.getStrIsValid());
			/*CommitteeTypeDao.setStrItemCatNo(vo.getStrItemCatNo());
			CommitteeTypeDao.setStrProcessId(vo.getStrProcessId());*/
			CommitteeTypeDao.setStrCommitteeTypeId(vo.getStrCommitteeTypeId());
			CommitteeTypeDao.setStrHospitalCode(vo.getStrHospitalCode());
			CommitteeTypeDao.update(dao);

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {
			vo.setStrMsgString("CommitteeTypeMstDAO.updateQuery() --> "
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
	public static void initialUpdateQuery(CommitteeTypeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "CommitteeTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.CommitteeTypeMst.4");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrCommitteeTypeId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrCommitteeTypeName());
			
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
			vo.setStrMsgString("CommitteeTypeMstDAO.initialUpdateQuery() --> "
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
