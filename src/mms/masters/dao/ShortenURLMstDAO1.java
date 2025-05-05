/**
 * 
 */
package mms.masters.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.StoreHierarchyDAO;
import mms.masters.vo.ShortenURLMstVO1;
import mms.masters.vo.ShortenURLMstVO1;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreHierarchyMstDAO.
 * 
 * @author Anshul Jindal
 */
public class ShortenURLMstDAO1 {
	
	/**
	 * for getting values of left store name list on add page.
	 * 
	 * @param vo the vo
	 */
	public static void initAddQuery(ShortenURLMstVO1 vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "StoreHierarchyMstDAO");

			strquery = mms.qryHandler_mms
					.getQuery(1, "select.StoreHierarchy.1");

			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			
			dao.setQryValue(nqryIndex, 2, vo.getStrItemCatId());
			
			dao.setQryValue(nqryIndex, 3, vo.getStrFromStoreId());
			dao.setQryValue(nqryIndex, 4, vo.getStrItemCatId());
			dao.setQryValue(nqryIndex, 5, vo.getStrRequestTypeId());
			dao.setQryValue(nqryIndex, 6, vo.getStrFromStoreId());

			wb = dao.executeQry(nqryIndex);
			vo.setStrLeftStoreNamesListWs(wb);

			strquery = mms.qryHandler_mms
					.getQuery(1, "select.StoreHierarchy.5");

			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrFromStoreId());
			dao.setQryValue(nqryIndex, 2, vo.getStrItemCatId());
			dao.setQryValue(nqryIndex, 3, vo.getStrRequestTypeId());
			dao.setQryValue(nqryIndex, 4, vo.getStrHospitalCode());

			wb = dao.executeQry(nqryIndex);
			vo.setStrRightStoreNamesListWs(wb);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> StoreHierarchyMstDAO.initAddQuery()-->"
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
	public static void insertQuery(ShortenURLMstVO1 vo) {

		HisDAO dao = null;
		StoreHierarchyDAO storeHierarchyDAO = null;

		try {
			dao = new HisDAO("mms", "StoreHierarchyMstDAO");
			storeHierarchyDAO = new StoreHierarchyDAO();

			storeHierarchyDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			storeHierarchyDAO.setStrHospitalCode(vo.getStrHospitalCode());
			storeHierarchyDAO.setStrIsValid(vo.getStrIsValid());
			storeHierarchyDAO.setStrRemarks(vo.getStrRemarks());
			storeHierarchyDAO.setStrSeatId(vo.getStrSeatId());
			storeHierarchyDAO.setStrFromStoreId(vo.getStrFromStoreId());
			storeHierarchyDAO.setStrToStoreId(vo.getStrToStoreId());
			storeHierarchyDAO.setStrIndentTypeId(vo.getStrRequestTypeId());
			storeHierarchyDAO.setStrItemCatId(vo.getStrItemCatId());
			storeHierarchyDAO.insert(dao);

			synchronized (dao) {
				dao.fire();

			}

		} catch (Exception e) {
			vo.setStrMsgString("--> StoreHierarchyMstDAO.insertQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			storeHierarchyDAO = null;
		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 */
	public static void modifyQuery(ShortenURLMstVO1 vo) {
		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet web = null;

		try {
			dao = new HisDAO("mms", "StoreHierarchyMstDAO");
			strquery = mms.qryHandler_mms
					.getQuery(1, "select.StoreHierarchy.3");

			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrFromStoreId());
			dao.setQryValue(nqryIndex, 2, vo.getStrRequestTypeId());
			dao.setQryValue(nqryIndex, 3, vo.getStrToStoreId());
			dao.setQryValue(nqryIndex, 4, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 5, vo.getStrSLNo());
			dao.setQryValue(nqryIndex, 6, vo.getStrItemCatId());

			web = dao.executeQry(nqryIndex);

			while (web.next()) {

				vo.setStrFromStoreName(web.getString(1));
				vo.setStrToStoreName(web.getString(2));
				vo.setStrIsValid(web.getString(3));
				vo.setStrEffectiveFrom(web.getString(4));
				vo.setStrRemarks(web.getString(5));
			}

		} catch (Exception e) {
			vo.setStrMsgString("--> StoreHierarchyMstDAO.modifyQuery()-->"
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
	public static void updateQuery(ShortenURLMstVO1 vo) {

		HisDAO dao = null;
		StoreHierarchyDAO storeHierarchyDAO = null;

		try {

			dao = new HisDAO("mms", "StoreHierarchyMstDAO");
			storeHierarchyDAO = new StoreHierarchyDAO();

			storeHierarchyDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			storeHierarchyDAO.setStrRemarks(vo.getStrRemarks());
			storeHierarchyDAO.setStrIsValid(vo.getStrIsValid());
			storeHierarchyDAO.setStrSeatId(vo.getStrSeatId());
			storeHierarchyDAO.setStrHospitalCode(vo.getStrHospitalCode());
			storeHierarchyDAO.setStrIndentTypeId(vo.getStrRequestTypeId());
			storeHierarchyDAO.setStrFromStoreId(vo.getStrFromStoreId());
			storeHierarchyDAO.setStrToStoreId(vo.getStrToStoreId());
			storeHierarchyDAO.setStrSLNo(vo.getStrSLNo());
			storeHierarchyDAO.setStrItemCatId(vo.getStrItemCatId());

			storeHierarchyDAO.update(dao);

			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> StoreHierarchyMstDAO.updateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			storeHierarchyDAO = null;
		}

	}
	
	
	/**
	 * for getting values of left store name list on add page.
	 * 
	 * @param vo the vo
	 */
	public static void getAssociatedStore(ShortenURLMstVO1 vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "StoreHierarchyMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1, "select.StoreHierarchy.11");

			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrFromStoreId());
			dao.setQryValue(nqryIndex, 4, vo.getStrItemCatId());
			dao.setQryValue(nqryIndex, 5, vo.getStrFromStoreId());
			dao.setQryValue(nqryIndex, 6, vo.getStrItemCatId());
			dao.setQryValue(nqryIndex, 7, vo.getStrRequestTypeId());

			wb = dao.executeQry(nqryIndex);
			
			vo.setStrLeftStoreNamesListWs(wb);
//            System.out.println("From Store ID::::"+vo.getStrFromStoreId());
//            System.out.println("Item Catg ID::::"+vo.getStrItemCatId());
//            System.out.println("Request Type ID::::"+vo.getStrRequestTypeId());
			
			strquery = mms.qryHandler_mms.getQuery(1, "select.StoreHierarchy.5");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrFromStoreId());
			dao.setQryValue(nqryIndex, 2, vo.getStrItemCatId());
			dao.setQryValue(nqryIndex, 3, vo.getStrRequestTypeId());
			dao.setQryValue(nqryIndex, 4, vo.getStrHospitalCode());
			wb = dao.executeQry(nqryIndex);
			vo.setStrRightStoreNamesListWs(wb);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> StoreHierarchyMstDAO.initAddQuery()-->"
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
