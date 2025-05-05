package mms.masters.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.InvoiceTypeDAO;

import mms.masters.vo.InvoiceTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class InvoiceTypeMstDAO.
 */
public class InvoiceTypeMstDAO {

	/**
	 * to check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */
	public static void chkDuplicate(InvoiceTypeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "InvoiceTypeMstDAO");
			strquery = mms.qryHandler_mms
					.getQuery(1, "select.invoiceTypeMst.2");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrInvoiceTypeName());
			dao.setQryValue(nqryIndex, 2, "100");
			dao.setQryValue(nqryIndex, 3, vo.getStrInvoiceType());
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
			vo.setStrMsgString("InvoiceTypeMstDAO.chkDuplicate() --> "
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

	public static void insertQuery(InvoiceTypeMstVO vo) {
		HisDAO dao = null;
		InvoiceTypeDAO invoiceTypeDao = null;

		try 
		{
			invoiceTypeDao = new InvoiceTypeDAO();
			dao = new HisDAO("mms", "InvoiceTypeMstDAO");

			invoiceTypeDao.setStrHospitalCode("100");
			invoiceTypeDao.setStrInvoiceTypeId(vo.getStrInvoiceTypeId());
			invoiceTypeDao.setStrRemarks(vo.getStrRemarks());
			invoiceTypeDao.setStrInvoiceTypeName(vo.getStrInvoiceTypeName());
			invoiceTypeDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			invoiceTypeDao.setStrSeatId(vo.getStrSeatId());
			invoiceTypeDao.setStrIsValid(vo.getStrIsValid());
			invoiceTypeDao.setStrInvoiceType(vo.getStrInvoiceType());
			invoiceTypeDao.insert(dao);
			synchronized (dao)
			{
				dao.fire();
			}
		} catch (Exception e) {
			vo.setStrMsgString("InvoiceTypeMstDAO.insertQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

			invoiceTypeDao = null;

		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 */

	public static void modifyQuery(InvoiceTypeMstVO vo) {

		HisDAO dao = new HisDAO("mms", "InvoiceTypeMstDAO");

		int nqryIndex;
		String strquery = new String();

		try {

			strquery = mms.qryHandler_mms
					.getQuery(1, "select.invoiceTypeMst.3");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, "100");
			dao.setQryValue(nqryIndex, 2, vo.getStrInvoiceTypeId());

			WebRowSet web = dao.executeQry(nqryIndex);
			while (web.next()) {
				vo.setStrInvoiceTypeName(web.getString(1));
				vo.setStrRemarks(web.getString(2));
				vo.setStrEffectiveFrom(web.getString(3));
				vo.setStrSeatId(web.getString(4));
				vo.setStrIsValid(web.getString(5));
				vo.setStrInvoiceType(web.getString(6));
			}
		} catch (Exception e) {

			vo.setStrMsgString("InvoiceTypeMstDAO.modifyQuery() --> "
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

	public static void checkDuplicateRecord(InvoiceTypeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";
		try {
			dao = new HisDAO("mms", "InvoiceTypeMstDAO");
			strquery = mms.qryHandler_mms
					.getQuery(1, "select.invoiceTypeMst.4");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrInvoiceTypeName());
			dao.setQryValue(nqryIndex, 2, "100");
			dao.setQryValue(nqryIndex, 3, vo.getStrInvoiceTypeId());
			dao.setQryValue(nqryIndex, 4, vo.getStrInvoiceType());
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
					.setStrMsgString("--> InvoiceTypeMstDAO.checkDuplicateRecord()-->"
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

	public static void updateQuery(InvoiceTypeMstVO vo) {

		InvoiceTypeDAO invoiceTypeDAO = null;
		HisDAO dao = null;

		try {
			invoiceTypeDAO = new InvoiceTypeDAO();
			dao = new HisDAO("mms", "InvoiceTypeMstDAO");

			invoiceTypeDAO.setStrHospitalCode("100");
			invoiceTypeDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			invoiceTypeDAO.setStrIsValid(vo.getStrIsValid());
			invoiceTypeDAO.setStrRemarks(vo.getStrRemarks());
			invoiceTypeDAO.setStrSeatId(vo.getStrSeatId());
			invoiceTypeDAO.setStrInvoiceTypeId(vo.getStrInvoiceTypeId());
			invoiceTypeDAO.setStrInvoiceTypeName(vo.getStrInvoiceTypeName());
			invoiceTypeDAO.setStrInvoiceType(vo.getStrInvoiceType());
			invoiceTypeDAO.setStrSlNo(vo.getStrSlNo());
			invoiceTypeDAO.update(dao);

			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {

			vo.setStrMsgString("--> InvoiceTypeMstDAO.updateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			invoiceTypeDAO = null;

		}

	}

}
