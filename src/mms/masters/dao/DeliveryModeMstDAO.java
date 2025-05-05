package mms.masters.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.DeliveryModeDAO;

import mms.masters.vo.DeliveryModeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class DeliveryModeMstDAO.
 * 
 * @author manas meher
 */

public class DeliveryModeMstDAO {

	/**
	 * to check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */

	public static void chkDuplicate(DeliveryModeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "DeliveryModeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,"select.deliveryModeMst.2");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrDeliveryModeName());
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
			vo.setStrMsgString("DeliveryModeMstDAO.chkDuplicate() --> "
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

	public static void insertQuery(DeliveryModeMstVO vo) {
		HisDAO dao = null;
		DeliveryModeDAO deliveryModeDao = null;

		try {
			deliveryModeDao = new DeliveryModeDAO();
			dao = new HisDAO("mms", "DeliveryModeMstDAO");

			deliveryModeDao.setStrHospitalCode(vo.getStrHospitalCode());
			deliveryModeDao.setStrDeliveryModeId(vo.getStrDeliveryModeId());
			deliveryModeDao.setStrRemarks(vo.getStrRemarks());
			deliveryModeDao.setStrDeliveryModeName(vo.getStrDeliveryModeName());
			deliveryModeDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			deliveryModeDao.setStrSeatId(vo.getStrSeatId());
			deliveryModeDao.setStrIsValid(vo.getStrIsValid());

			deliveryModeDao.insert(dao);
			synchronized (dao) {
				dao.fire();

			}
		} catch (Exception e) {
			vo.setStrMsgString("DeliveryModeMstDAO.insertQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

			deliveryModeDao = null;

		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 */

	public static void modifyQuery(DeliveryModeMstVO vo) {

		HisDAO dao = new HisDAO("mms", "DeliveryModeMstDAO");

		int nqryIndex;
		String strquery = new String();

		try {

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.deliveryModeMst.3");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrDeliveryModeId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());

			WebRowSet web = dao.executeQry(nqryIndex);
			while (web.next()) {
				vo.setStrDeliveryModeName(web.getString(1));
				vo.setStrRemarks(web.getString(2));
				vo.setStrEffectiveFrom(web.getString(3));
				vo.setStrSeatId(web.getString(4));
				vo.setStrIsValid(web.getString(5));
			}
		} catch (Exception e) {

			vo.setStrMsgString("DeliveryModeMstDAO.modifyQuery() --> "
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

	public static void checkDuplicateRecord(DeliveryModeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";
		try {
			dao = new HisDAO("mms", "DeliveryModeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.deliveryMst.4");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrDeliveryModeName());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrDeliveryModeId());
			dao.setQryValue(nqryIndex, 4, vo.getStrSerialNo());
			wb = dao.executeQry(nqryIndex);
			while (wb.next()) {
				ncount = Integer.parseInt(wb.getString(1));
			}
			if (ncount < 1) {
				vo.setBExistStatus(true);
			} else {
				vo.setBExistStatus(false);
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
			vo
					.setStrMsgString("--> DeliveryModeMstDAO.checkDuplicateRecord()-->"
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

	public static void updateQuery(DeliveryModeMstVO vo) {

		DeliveryModeDAO deliveryModeDAO = null;
		HisDAO dao = null;

		try 
		{
			deliveryModeDAO = new DeliveryModeDAO();
			dao = new HisDAO("mms", "DeliveryModeMstDAO");

			deliveryModeDAO.setStrHospitalCode(vo.getStrHospitalCode());
			deliveryModeDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			deliveryModeDAO.setStrIsValid(vo.getStrIsValid());
			deliveryModeDAO.setStrRemarks(vo.getStrRemarks());
			deliveryModeDAO.setStrSeatId(vo.getStrSeatId());
			deliveryModeDAO.setStrDeliveryModeId(vo.getStrDeliveryModeId());
			deliveryModeDAO.setStrDeliveryModeName(vo.getStrDeliveryModeName());
			deliveryModeDAO.setStrSerialNo(vo.getStrSerialNo());
			deliveryModeDAO.update(dao);
			
			deliveryModeDAO.setStrHospitalCode(vo.getStrHospitalCode());
			deliveryModeDAO.setStrDeliveryModeId(vo.getStrDeliveryModeId());
			deliveryModeDAO.setStrRemarks(vo.getStrRemarks());
			deliveryModeDAO.setStrDeliveryModeName(vo.getStrDeliveryModeName());
			deliveryModeDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			deliveryModeDAO.setStrSeatId(vo.getStrSeatId());
			deliveryModeDAO.setStrIsValid(vo.getStrIsValid());
			deliveryModeDAO.insert1(dao);
			

			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {

			vo.setStrMsgString("--> DeliveryModeMstDAO.updateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			deliveryModeDAO = null;

		}

	}
}
