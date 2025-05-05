package mms.masters.dao;

import hisglobal.transactionmgnt.HisDAO;
import javax.sql.rowset.WebRowSet;
import mms.dao.ItemParameterDAO;
import mms.masters.vo.ItemParameterMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemParameterMstDAO.
 * 
 * @author manas
 */

public class ItemParameterMstDAO {

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */

	public static void insertQuery(ItemParameterMstVO vo) {

		HisDAO dao = null;
		ItemParameterDAO itemparameterdao = null;

		try {
			dao = new HisDAO("mms", "ItemParameterDAO");

			itemparameterdao = new ItemParameterDAO();
			itemparameterdao.setStrHospitalCode(vo.getStrHospitalCode());
			itemparameterdao.setStrSeatId(vo.getStrSeatId());

			itemparameterdao.setStrItemParamName(vo.getStrItemParamName());
			itemparameterdao.setStrParamType(vo.getStrParamType());
			itemparameterdao.setStrParamLength(vo.getStrParamLength());
			itemparameterdao.setStrRemarks(vo.getStrRemarks());
			itemparameterdao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			itemparameterdao.setStrCategoryNo(vo.getStrCategroyNo());
			itemparameterdao.setStrParentParamId(vo.getStrParentParamId());

			itemparameterdao.insert(dao);
			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {

			vo.setStrMsgString("ItemParameterDAO.insertQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

			itemparameterdao = null;
		}
	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 */

	public static void modifyQuery(ItemParameterMstVO vo) {

		HisDAO dao = new HisDAO("mms", "ItemParameterMstDAO");

		String strItemParamId = "";
		String strHospitalCode = "";
		int nqryIndex;
		String strquery = new String();

		try {

			strquery = mms.qryHandler_mms.getQuery(1, "modify.itemparameter.0");

			nqryIndex = dao.setQuery(strquery);
			strItemParamId = vo.getStrItemParamId();
			strHospitalCode = vo.getStrHospitalCode();
			

			dao.setQryValue(nqryIndex, 1, strItemParamId);
			dao.setQryValue(nqryIndex, 2, strHospitalCode);
			dao.setQryValue(nqryIndex, 3, vo.getStrSlNo());
			WebRowSet web = dao.executeQry(nqryIndex);
			while (web.next()) {

				vo.setStrItemParamName(web.getString(1));
				vo.setStrParamType(web.getString(2));
				vo.setStrParamLength(web.getString(3));
				vo.setStrRemarks(web.getString(4));
				vo.setStrEffectiveFrom(web.getString(5));
				vo.setStrIsValid(web.getString(6));
				vo.setStrCategroyNo(web.getString(7));
			}
		} catch (Exception e) {
			vo.setStrMsgString("ItemParameterMstDAO.modifyQuery() --> "
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
	 * to check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */

	public static void chkDuplicateInsert(ItemParameterMstVO vo) {
		HisDAO dao = new HisDAO("mms", "ItemParameterMstDAO");

		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery;

		try {
			strquery = mms.qryHandler_mms.getQuery(1,
					"Select.itemparameterunique.2");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrItemParamName());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrCategroyNo());
			wb = dao.executeQry(nqryIndex);
			while (wb.next()) {
				ncount = Integer.parseInt(wb.getString(1));
			}
			if (ncount == 0) {
				vo.setBExistsStatus(true);
			} else {
				vo.setBExistsStatus(false);
			}
		} catch (Exception e) {

			vo.setStrMsgString("ItemParameterMstDAO.chkDuplicateInsert() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

			wb = null;
		}

	}

	/**
	 * for getting option value of parent parameter name combo on add page.
	 * 
	 * @param vo the vo
	 */

	public static void getParentParameter(ItemParameterMstVO vo) {

		HisDAO dao = null;
		int nQryIndex;
		String strQuery = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "ItemParameterMstDAO");

			strQuery = mms.qryHandler_mms.getQuery(1, "select.itemparameter.6");
			nQryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQryIndex, 1, vo.getStrCategroyNo());
			dao.setQryValue(nQryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nQryIndex, 3, vo.getStrIsValid());
			wb = dao.executeQry(nQryIndex);

			vo.setStrparentCmbWs(wb);

		} catch (Exception e) {
			vo
					.setStrMsgString("--> ItemParameterMstDAO.getParentParameter()-->"
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

	public static void chkDuplicateupdate(ItemParameterMstVO vo) {
		HisDAO dao = new HisDAO("mms", "ItemParameterMstDAO");

		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery;
		try {
			strquery = mms.qryHandler_mms.getQuery(1,
					"Select.itemparameterunique.4");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrItemParamId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrItemParamName());
			dao.setQryValue(nqryIndex, 4, vo.getStrCategroyNo());
			wb = dao.executeQry(nqryIndex);

			while (wb.next()) {
				ncount = Integer.parseInt(wb.getString(1));
			}
			if (ncount == 0) {
				vo.setBExistsStatus(true);
			} else {
				vo.setBExistsStatus(false);
			}
		} catch (Exception e) {
			vo.setStrMsgString("ItemParameterMstDAO.chkDuplicateupdate() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wb = null;
		}

	}

	/**
	 * to update the record.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */

	public static void updateQuery(ItemParameterMstVO vo) {

		HisDAO dao = null;
		String strItemId = "";
		String strHospitalCode = "";

		ItemParameterDAO itemdao = null;

		try {
			dao = new HisDAO("mms", "ItemParameterMstDAO");

			strItemId = vo.getStrItemParamId();
			strHospitalCode = vo.getStrHospitalCode();

			itemdao = new ItemParameterDAO();
			
			itemdao.setStrCategoryNo(vo.getStrCategroyNo());
			itemdao.setStrItemParamName(vo.getStrItemParamName());
			itemdao.setStrParamType(vo.getStrParamType());
			itemdao.setStrParamLength(vo.getStrParamLength());
			itemdao.setStrParentParamId(vo.getStrParentParamId());
			itemdao.setStrRemarks(vo.getStrRemarks());
			itemdao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			itemdao.setStrLastModifiedSeatId(vo.getStrLastModifiedSeatId());
			itemdao.setStrSeatId(vo.getStrSeatId());
			itemdao.setStrSlNo(vo.getStrSlNo());
			itemdao.setStrIsValid(vo.getStrIsValid());
			itemdao.setStrItemParamId(strItemId);
			itemdao.setStrHospitalCode(strHospitalCode);
			itemdao.update(dao);

			synchronized (dao) {
				dao.fire();

			}

		} catch (Exception e) {

			vo.setStrMsgString("ItemParameterMstVO.updateQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			itemdao = null;
		}

	}

}
