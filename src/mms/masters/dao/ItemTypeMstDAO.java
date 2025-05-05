package mms.masters.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.ItemTypeDAO;
import mms.masters.vo.ItemTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemTypeMstDAO.
 */
public class ItemTypeMstDAO {

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public static void insertQuery(ItemTypeMstVO vo) {

		HisDAO dao = null;
		ItemTypeDAO itemTypeDAO = null;

		try {
			dao = new HisDAO("mms", "ItemTypeMstDAO");
			itemTypeDAO = new ItemTypeDAO();

			itemTypeDAO.setStrItemCatNo(vo.getStrItemCatNo());
			itemTypeDAO.setStrItemTypeName(vo.getStrItemTypeName());
			itemTypeDAO.setStrHospitalCode(vo.getStrHospitalCode());
			itemTypeDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			itemTypeDAO.setStrIsValid(vo.getStrIsValid());
			itemTypeDAO.setStrRemarks(vo.getStrRemarks());
			itemTypeDAO.setStrSeatId(vo.getStrSeatId());
			itemTypeDAO.setStrShortName(vo.getStrShortName());

			itemTypeDAO.insert(dao);

			synchronized (dao) {
				dao.fire();

			}

		} catch (Exception e) {
			vo.setStrMsgString("--> ItemTypeMstDAO.insertQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			itemTypeDAO = null;
		}

	}

	/**
	 * to check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */

	public static void chkDuplicate(ItemTypeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";

		try {
			dao = new HisDAO("mms", "ItemTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.ItemType.2");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrItemTypeName());
			dao.setQryValue(nqryIndex, 2, vo.getStrItemCatNo());
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
			vo.setStrMsgString("--> ItemTypeMstDAO.chkDuplicate()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * to check duplicate before insert update.
	 * 
	 * @param vo the vo
	 */
	public static void initialUpdateQuery(ItemTypeMstVO vo) {

		HisDAO dao = null;
		String strquery = "";
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "ItemTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.ItemType.4");

			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrItemTypeName());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrItemTypeId());
			dao.setQryValue(nqryIndex, 4, vo.getStrItemCatNo());

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
	 * 
	 * @throws Exception 	 */
	public static void updateQuery(ItemTypeMstVO vo) {
		HisDAO dao = null;
		ItemTypeDAO itemTypeDAO = null;

		try {
			dao = new HisDAO("mms", "ItemTypeMstDAO");

			itemTypeDAO = new ItemTypeDAO();

			itemTypeDAO.setStrItemCatNo(vo.getStrItemCatNo());
			itemTypeDAO.setStrItemTypeName(vo.getStrItemTypeName());
			itemTypeDAO.setStrHospitalCode(vo.getStrHospitalCode());
			itemTypeDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			itemTypeDAO.setStrIsValid(vo.getStrIsValid());
			itemTypeDAO.setStrRemarks(vo.getStrRemarks());
			itemTypeDAO.setStrSeatId(vo.getStrSeatId());
			itemTypeDAO.setStrShortName(vo.getStrShortName());
			itemTypeDAO.setStrItemTypeId(vo.getStrItemTypeId());
			itemTypeDAO.setStrSlNo(vo.getStrSlNo());

			itemTypeDAO.update(dao);
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
			itemTypeDAO = null;
		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 */

	public static void modifyQuery(ItemTypeMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";

		try {
			dao = new HisDAO("mms", "ItemTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.ItemType.3");

			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrItemTypeId());
			dao.setQryValue(nqryIndex, 3, vo.getStrSlNo());
			WebRowSet web = dao.executeQry(nqryIndex);

			while (web.next()) {
				vo.setStrItemCatNo(web.getString(1));
				vo.setStrItemTypeName(web.getString(2));
				vo.setStrShortName(web.getString(3));
				vo.setStrEffectiveFrom(web.getString(4));
				vo.setStrRemarks(web.getString(5));
				vo.setStrIsValid(web.getString(6));
			}

		} catch (Exception e) {
			vo.setStrMsgString("--> ItemTypeMstDAO.modifyQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

}
