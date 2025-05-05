package mms.masters.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.PurchaseTypeDAO;
import mms.masters.vo.PurchaseTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PurchaseTypeMstDAO.
 * 
 * @author Anshul Jindal
 */
public class PurchaseTypeMstDAO {

	/**
	 * to check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */
	public static void initialAddQuery(PurchaseTypeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";

		try {
			dao = new HisDAO("mms", "PurchaseTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.PurchaseType.2");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrPurchaseTypeName());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrStoreTypeId());
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
			vo.setStrMsgString("--> PurchaseTypeMstDAO.initialAddQuery()-->"
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
	public static void insertQuery(PurchaseTypeMstVO vo) {

		HisDAO dao = null;
		PurchaseTypeDAO purchaseTypeDAO = null;

		try {
			dao = new HisDAO("mms", "PurchaseTypeMstDAO");
			purchaseTypeDAO = new PurchaseTypeDAO();

			purchaseTypeDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			purchaseTypeDAO.setStrHospitalCode(vo.getStrHospitalCode());
			purchaseTypeDAO.setStrIsValid(vo.getStrIsValid());
			purchaseTypeDAO.setStrPurchaseTypeLimit(vo
					.getStrPurchaseTypeLimit());
			purchaseTypeDAO.setStrPurchaseTypeName(vo.getStrPurchaseTypeName());
			purchaseTypeDAO.setStrRemarks(vo.getStrRemarks());
			purchaseTypeDAO.setStrSeatId(vo.getStrSeatId());
			purchaseTypeDAO.setStrStoreTypeId(vo.getStrStoreTypeId());

			purchaseTypeDAO.insert(dao);

			synchronized (dao) {
				dao.fire();

			}
		} catch (Exception e) {
			vo.setStrMsgString("--> PurchaseTypeMstDAO.insertQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			purchaseTypeDAO = null;
		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 */
	public static void modifyQuery(PurchaseTypeMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";

		try {

			dao = new HisDAO("mms", "PurchaseTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.PurchaseType.3");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrPurchaseTypeId());
			WebRowSet web = dao.executeQry(nqryIndex);
			while (web.next()) {
				vo.setStrPurchaseTypeName(web.getString(1));
				vo.setStrPurchaseTypeLimit(web.getString(2));
				vo.setStrEffectiveFrom(web.getString(3));
				vo.setStrRemarks(web.getString(4));
				vo.setStrIsValid(web.getString(5));
			}
		} catch (Exception e) {
			vo.setStrMsgString("--> PurchaseTypeMstDAO.modifyQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * to check duplicate before update.
	 * 
	 * @param vo the vo
	 */
	public static void initialUpdateQuery(PurchaseTypeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";
		try {
			dao = new HisDAO("mms", "PurchaseTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.PurchaseType.4");

			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrPurchaseTypeName());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrPurchaseTypeId());
			dao.setQryValue(nqryIndex, 4, vo.getStrStoreTypeId());

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
			vo.setStrMsgString("--> IndentTypeMstDAO.initialUpdateQuery()-->"
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
	 */
	public static void updateQuery(PurchaseTypeMstVO vo) {

		HisDAO dao = null;
		PurchaseTypeDAO purchaseTypeDAO = null;

		try {
			dao = new HisDAO("mms", "PurchaseTypeMstDAO");
			purchaseTypeDAO = new PurchaseTypeDAO();

			purchaseTypeDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			purchaseTypeDAO.setStrHospitalCode(vo.getStrHospitalCode());
			purchaseTypeDAO.setStrIsValid(vo.getStrIsValid());
			purchaseTypeDAO.setStrPurchaseTypeLimit(vo
					.getStrPurchaseTypeLimit());
			purchaseTypeDAO.setStrPurchaseTypeName(vo.getStrPurchaseTypeName());
			purchaseTypeDAO.setStrRemarks(vo.getStrRemarks());
			purchaseTypeDAO.setStrSeatId(vo.getStrSeatId());
			purchaseTypeDAO.setStrStoreTypeId(vo.getStrStoreTypeId());
			purchaseTypeDAO.setStrPurchaseTypeId(vo.getStrPurchaseTypeId());

			purchaseTypeDAO.update(dao);
			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {
			vo.setStrMsgString("--> IndentTypeMstDAO.updateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			purchaseTypeDAO = null;
		}

	}

}