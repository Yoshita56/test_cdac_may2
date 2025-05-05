package mms.masters.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.CurrencyDAO;
import mms.masters.vo.CurrencyMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CurrencyMstDAO.
 */
public class CurrencyMstDAO {

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public static void insertQuery(CurrencyMstVO vo) {
		HisDAO dao = null;
		CurrencyDAO currencyDao = null;

		try {
			currencyDao = new CurrencyDAO();
			dao = new HisDAO("mms", "CurrencyMstDAO");

			currencyDao.setStrHospitalCode(vo.getStrHospitalCode());
			currencyDao.setStrCurrencyId(vo.getStrCurrencyId());
			currencyDao.setStrCurrencyName(vo.getStrCurrencyName());
			currencyDao.setStrCurrencyShortName(vo.getStrCurrencyShortName());
			currencyDao.setStrCurrencyValue(vo.getStrCurrencyValue());
			currencyDao.setStrRemarks(vo.getStrRemarks());
			currencyDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			currencyDao.setStrSeatId(vo.getStrSeatId());
			currencyDao.setStrIsValid(vo.getStrIsValid());
			currencyDao.setStrDefault(vo.getStrDefault());
			currencyDao.insert(dao);
			synchronized (dao) {
				dao.fire();

			}
		} catch (Exception e) {
			vo.setStrMsgString("CurrencyMstDAO.insertQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

			currencyDao = null;

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
	public static void chkDuplicate(CurrencyMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "CurrencyMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.CurrencyMst.2");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrCurrencyName());
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
			vo.setStrMsgString("CurrencyMstDAO.chkDuplicate() --> "
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
	public static void modifyQuery(CurrencyMstVO vo) {

		HisDAO dao = new HisDAO("mms", "CurrencyMstDAO");

		int nqryIndex;
		String strquery = new String();

		try {

			strquery = mms.qryHandler_mms.getQuery(1, "select.CurrencyMst.3");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrCurrencyId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrCurrencySlNo());

			WebRowSet web = dao.executeQry(nqryIndex);
			while (web.next()) {
				vo.setStrCurrencyName(web.getString(1));
				vo.setStrCurrencyShortName(web.getString(2));
				vo.setStrCurrencyValue(web.getString(3));
				vo.setStrRemarks(web.getString(4));
				vo.setStrEffectiveFrom(web.getString(5));
				vo.setStrIsValid(web.getString(6));
				vo.setStrDefault(web.getString(7));
			}
		} catch (Exception e) {

			vo.setStrMsgString("CurrencyMstDAO.modifyQuery() --> "
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
	public static void updateQuery(CurrencyMstVO vo) {

		HisDAO dao = null;

		CurrencyDAO currencyDao = null;

		try {
			currencyDao = new CurrencyDAO();
			dao = new HisDAO("mms", "CurrencyMstDAO");
			currencyDao.setStrCurrencyName(vo.getStrCurrencyName());
			currencyDao.setStrCurrencyShortName(vo.getStrCurrencyShortName());
			currencyDao.setStrCurrencyValue(vo.getStrCurrencyValue());
			currencyDao.setStrLastModifiedSeatId(vo.getStrSeatId());
			currencyDao.setStrRemarks(vo.getStrRemarks());
			currencyDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			currencyDao.setStrCurrencyId(vo.getStrCurrencyId());
			currencyDao.setStrHospitalCode(vo.getStrHospitalCode());
			currencyDao.setStrCurrencySlNo(vo.getStrCurrencySlNo());
			currencyDao.setStrSlNo(vo.getStrStrSerialNo());
			currencyDao.update(dao);

			currencyDao.setStrCurrencyId(vo.getStrCurrencyId());
			currencyDao.setStrHospitalCode(vo.getStrHospitalCode());
			currencyDao.setStrCurrencyName(vo.getStrCurrencyName());
			currencyDao.setStrCurrencyShortName(vo.getStrCurrencyShortName());
			currencyDao.setStrCurrencyValue(vo.getStrCurrencyValue());
			currencyDao.setStrRemarks(vo.getStrRemarks());
			currencyDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			currencyDao.setStrSeatId(vo.getStrSeatId());
			currencyDao.setStrIsValid(vo.getStrIsValid());
			currencyDao.setStrDefault(vo.getStrDefault());
			currencyDao.insert1(dao);

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {
			vo.setStrMsgString("CurrencyMstDAO.updateQuery() --> "
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
	public static void initialUpdateQuery(CurrencyMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "CurrencyMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.CurrencyMst.4");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrCurrencyId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrCurrencySlNo());
			dao.setQryValue(nqryIndex, 4, vo.getStrCurrencyName());
			dao.setQryValue(nqryIndex, 5, vo.getStrStrSerialNo());
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
			vo.setStrMsgString("CurrencyMstDAO.initialUpdateQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	public static void chkDuplicateDefault(CurrencyMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "CurrencyMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.CurrencyMst.8");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			wb = dao.executeQry(nqryIndex);
			if(wb.next()){
				
				vo.setStrDefault(wb.getString(2));
				vo.setStrCurrencyName(wb.getString(1));
			}else{
				
				vo.setStrDefault("0");
				vo.setStrCurrencyName("");
			}
			
		} catch (Exception e) {
			vo.setStrMsgString("CurrencyMstDAO.chkDuplicateDefault() --> "
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
