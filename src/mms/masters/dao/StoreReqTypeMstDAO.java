package mms.masters.dao;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.dao.StoreReqTypeDAO;
import mms.masters.vo.StoreReqTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreReqTypeMstDAO.
 */
public class StoreReqTypeMstDAO {
	
	/**
	 * for getting values of left Req type list and right Req Type List on add
	 * page.
	 * 
	 * @param vo the vo
	 */
	public static void initAddQuery(StoreReqTypeMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "StoreReqTypeMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.storeReqTypeMst.1");

			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nqryIndex, 2, vo.getStrStoreId());
			dao.setQryValue(nqryIndex, 3, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 4, vo.getStrStoreCatId());

			wb = dao.executeQry(nqryIndex);
			vo.setStrLeftRequestTypesListWs(wb);

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.storeReqTypeMst.2");

			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrStoreId());
			dao.setQryValue(nqryIndex, 3, vo.getStrStoreCatId());

			wb = dao.executeQry(nqryIndex);
			vo.setStrRightRequestTypeListWs(wb);

		} catch (Exception e) {
			vo.setStrMsgString("--> StoreReqTypeMstDAO.initAddQuery()-->"
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
	public static void insertQuery(StoreReqTypeMstVO vo) {

		HisDAO dao = null;
		StoreReqTypeDAO storeReqTypeDAO = null;
		int nRightListLen = 0;
		try {
			dao = new HisDAO("mms", "StoreReqTypeMstDAO");
			storeReqTypeDAO = new StoreReqTypeDAO();
			nRightListLen = vo.getStrIndentTypeArray().length;

			for (int i = 0; i < nRightListLen; i++) {
				if (!vo.getStrIndentTypeArray()[i].equals("0")) {
					vo.setStrIndentTypeId(vo.getStrIndentTypeArray()[i]);
					storeReqTypeDAO.setStrEffectiveFrom(vo
							.getStrEffectiveFrom());
					storeReqTypeDAO.setStrHospitalCode(vo.getStrHospitalCode());
					storeReqTypeDAO.setStrIsValid(vo.getStrIsValid());
					storeReqTypeDAO.setStrRemarks(vo.getStrRemarks());
					storeReqTypeDAO.setStrSeatId(vo.getStrSeatId());
					storeReqTypeDAO.setStrStoreId(vo.getStrStoreId());
					storeReqTypeDAO.setStrStoreCatId(vo.getStrStoreCatId());

					storeReqTypeDAO.setStrIndentTypeId(vo.getStrIndentTypeId());

					storeReqTypeDAO.insert(dao);
				}

			}

			synchronized (dao) {
				dao.fire();

			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> StoreReqTypeMstDAO.insertQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			storeReqTypeDAO = null;
		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 */
	public static void modifyQuery(StoreReqTypeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet web = null;

		try {
			dao = new HisDAO("mms", "StoreReqTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.storeReqTypeMst.3");

			nqryIndex = dao.setQuery(strquery);

			//System.out.println(vo.getStrStoreId()+" "+vo.getStrStoreCatId()+" "+vo.getStrIndentTypeId()+" "+ vo.getStrHospitalCode()+" "+vo.getStrReqTypeSlNo());
			
			
			
			dao.setQryValue(nqryIndex, 1, vo.getStrStoreId());
			dao.setQryValue(nqryIndex, 2, vo.getStrStoreCatId());
			dao.setQryValue(nqryIndex, 3, vo.getStrIndentTypeId());
			dao.setQryValue(nqryIndex, 4, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 5, vo.getStrReqTypeSlNo());

			web = dao.executeQry(nqryIndex);

			while (web.next()) {

				vo.setStrStoreName(web.getString(1));

				vo.setStrReqType(web.getString(2));
				vo.setStrIsValid(web.getString(3));
				vo.setStrEffectiveFrom(web.getString(4));
				vo.setStrRemarks(web.getString(5));

			}

		} catch (Exception e) {
			vo.setStrMsgString("--> StoreReqTypeMstDAO.modifyQuery()-->"
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
	public static void updateQuery(StoreReqTypeMstVO vo) {

		HisDAO dao = null;
		StoreReqTypeDAO storeReqTypeDAO = null;
		try {

			dao = new HisDAO("mms", "StoreReqTypeMstDAO");
			storeReqTypeDAO = new StoreReqTypeDAO();

			storeReqTypeDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			storeReqTypeDAO.setStrRemarks(vo.getStrRemarks());
			storeReqTypeDAO.setStrIsValid(vo.getStrIsValid());
			storeReqTypeDAO.setStrSeatId(vo.getStrSeatId());
			storeReqTypeDAO.setStrHospitalCode(vo.getStrHospitalCode());
			storeReqTypeDAO.setStrStoreId(vo.getStrStoreId());
			storeReqTypeDAO.setStrStoreCatId(vo.getStrStoreCatId());
			storeReqTypeDAO.setStrIndentTypeId(vo.getStrIndentTypeId());
			storeReqTypeDAO.setStrReqTypeSlNo(vo.getStrReqTypeSlNo());

			storeReqTypeDAO.update(dao);

			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {
			vo.setStrMsgString("--> StoreReqTypeMstDAO.updateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			storeReqTypeDAO = null;
		}

	}

}
