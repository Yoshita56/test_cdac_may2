package mms.masters.dao;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;
import javax.sql.rowset.WebRowSet;

import mms.dao.StoreCategoryDAO;

import mms.masters.vo.StoreCategoryMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreCategoryMstDAO.
 */
public class StoreCategoryMstDAO {
	
	/**
	 * for getting values of left Req type list and right Req Type List on add
	 * page.
	 * 
	 * @param vo the vo
	 */
	public static void initAddQuery(StoreCategoryMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "StoreCategoryMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.storeCategoryMst.1");

			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nqryIndex, 2, vo.getStrStoreId());
			dao.setQryValue(nqryIndex, 3, vo.getStrHospitalCode());

			wb = dao.executeQry(nqryIndex);
			vo.setStrLeftStoreCategoryListWs(wb);

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.storeCategoryMst.2");

			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrStoreId());

			wb = dao.executeQry(nqryIndex);
			vo.setStrRightStoreCategoryListWs(wb);

		} catch (Exception e) {
			vo.setStrMsgString("--> StoreCategoryMstDAO.initAddQuery()-->"
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
	public static void insertQuery(StoreCategoryMstVO vo) 
	{
		HisDAO dao = null;
		StoreCategoryDAO storeCategoryDAO = null;
		try 
		{
			dao = new HisDAO("mms", "StoreCategoryMstDAO");
			storeCategoryDAO = new StoreCategoryDAO();
			storeCategoryDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			storeCategoryDAO.setStrHospitalCode(vo.getStrHospitalCode());
			storeCategoryDAO.setStrIsValid(vo.getStrIsValid());
			storeCategoryDAO.setStrRemarks(vo.getStrRemarks());
			storeCategoryDAO.setStrSeatId(vo.getStrSeatId());
			storeCategoryDAO.setStrStoreId(vo.getStrStoreId());
			storeCategoryDAO.setStrStoreItemCategory(vo.getStrStoreItemCategory());
			storeCategoryDAO.setStrIsNewItemFlag(vo.getStrIsNewItemFlag());
			storeCategoryDAO.setStrItemBounded(vo.getStrItemBounded());
			
			storeCategoryDAO.insert(dao);
			
			

			synchronized (dao) {
				dao.fire();

			}

		} catch (Exception e) {
			vo.setStrMsgString("--> StoreCategoryMstDAO.insertQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			storeCategoryDAO = null;
		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 */
	public static void modifyQuery(StoreCategoryMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet web = null;

		try {
			dao = new HisDAO("mms", "StoreCategoryMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.storeCategoryMst.3");

			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrStoreId());
			dao.setQryValue(nqryIndex, 2, vo.getStrItemCatNo());
			dao.setQryValue(nqryIndex, 3, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 4, vo.getStrStoreCatSlNo());

			web = dao.executeQry(nqryIndex);

			while (web.next())
			{

				vo.setStrStoreName(web.getString(1));
				vo.setStrStoreCategory(web.getString(2));
				vo.setStrIsValid(web.getString(3));
				vo.setStrEffectiveFrom(web.getString(4));
				vo.setStrRemarks(web.getString(5));
				vo.setStrItemBounded(web.getString(6));
				vo.setStrIsNewItemFlag(web.getString(7));

			}

		} catch (Exception e) {
			vo.setStrMsgString("--> StoreCategoryMstDAO.modifyQuery()-->"
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
	public static void updateQuery(StoreCategoryMstVO vo) {

		HisDAO dao = null;
		StoreCategoryDAO storeCategoryDAO = null;
		try {

			dao = new HisDAO("mms", "StoreCategoryMstDAO");
			storeCategoryDAO = new StoreCategoryDAO();

			storeCategoryDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			storeCategoryDAO.setStrRemarks(vo.getStrRemarks());
			storeCategoryDAO.setStrIsValid(vo.getStrIsValid());
			storeCategoryDAO.setStrSeatId(vo.getStrSeatId());
			storeCategoryDAO.setStrHospitalCode(vo.getStrHospitalCode());
			storeCategoryDAO.setStrStoreId(vo.getStrStoreId());
			storeCategoryDAO.setStrItemCatNo(vo.getStrStoreItemCategory());
			storeCategoryDAO.setStrStoreCatSlNo(vo.getStrStoreCatSlNo());
			storeCategoryDAO.setStrItemBounded(vo.getStrItemBounded());
			storeCategoryDAO.setStrIsNewItemFlag(vo.getStrIsNewItemFlag());
			
//			System.out.println("Item Catg Sl No:::"+vo.getStrStoreCatSlNo());
//			System.out.println("Item Catg:::"+vo.getStrStoreItemCategory());
//			System.out.println("Is New Item Flga:::"+vo.getStrIsNewItemFlag());
//			System.out.println("Item Bound::"+vo.getStrItemBounded());
//			System.out.println("Remarks::"+vo.getStrRemarks());
			
			storeCategoryDAO.update(dao);

			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {
			vo.setStrMsgString("--> StoreCategoryMstDAO.updateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			storeCategoryDAO = null;
		}

	}

}
