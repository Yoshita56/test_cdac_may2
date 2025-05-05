/**
 * 
 */
package mms.masters.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.masters.vo.SupplierTypeMstVO;

/**
 * Developer : Tanvi Sappal
 * Create Date : 26/Oct/2009
 * Process Name : Supplier Type Master
 * Version : 1.1
 * Modify By/Date : 
 */
public class SupplierTypeMstDAO {
	
	/**
	 * to insert the data
	 * 
	 * @param vo
	 */
	public static void insertQuery(SupplierTypeMstVO vo) {

		HisDAO dao = null;
		String strquery = "";
		int nqryIndex = 0;

		try {
			
			dao = new HisDAO("mms", "SupplierTypeMstDAO");
			
			 strquery = mms.qryHandler_mms.getQuery(1, "insert.supplierTypeMst.0"); 
			 nqryIndex = dao.setQuery(strquery);
			 
			
			 dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			 dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			 dao.setQryValue(nqryIndex, 3, vo.getStrSupplierTypeName());
			 dao.setQryValue(nqryIndex, 4, vo.getStrRemarks());
			 dao.setQryValue(nqryIndex, 5, vo.getStrEffectiveFrom());
			 dao.setQryValue(nqryIndex, 6, vo.getStrSeatId());
			 dao.setQryValue(nqryIndex, 7, "1"); 
			 dao.execute(nqryIndex, 0);
			

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {
			vo.setStrMsgString("--> SupplierTypeMstDAO.insertQuery()-->"
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
	public static void initialAddQuery(SupplierTypeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";
		try {
			dao = new HisDAO("mms", "SupplierTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.supplierTypeMst.2");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrSupplierTypeName());
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
			vo.setStrMsgString("--> SupplierTypeMstDAO.initialAddQuery()-->"
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
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 */
	public static void modifyQuery(SupplierTypeMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";

		try {

			dao = new HisDAO("mms", "SupplierTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.supplierTypeMst.3");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrSupplierTypeId());
			dao.setQryValue(nqryIndex, 3, vo.getStrSlNo());
			
			WebRowSet web = dao.executeQry(nqryIndex);
			while (web.next()) {
				vo.setStrSupplierTypeName(web.getString(1));
				vo.setStrEffectiveFrom(web.getString(2));
				vo.setStrRemarks(web.getString(3));
				vo.setStrSeatId(web.getString(4));
				vo.setStrIsValid(web.getString(5));
			}
		} catch (Exception e) {
			vo.setStrMsgString("--> SupplierTypeMstDAO.modifyQuery()-->"
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
	public static void updateQuery(SupplierTypeMstVO vo) {

		HisDAO dao = null;
		String strquery = "";
		int nqryIndex = 0;

		try {
			dao = new HisDAO("mms", "SupplierTypeMstDAO");

			 strquery = mms.qryHandler_mms.getQuery(1,"update.supplierTypeMst.1"); 
			 nqryIndex = dao.setQuery(strquery);
			 
			 
			 dao.setQryValue(nqryIndex, 1, vo.getStrLstmodSeatId());			 
			 dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			 dao.setQryValue(nqryIndex, 3, vo.getStrSupplierTypeId());
			 dao.setQryValue(nqryIndex, 4, vo.getStrSlNo());
			 
			 dao.execute(nqryIndex, 0);
			 
			 
			 strquery = mms.qryHandler_mms.getQuery(1, "insert.supplierTypeMst.new.record"); 
			 nqryIndex = dao.setQuery(strquery);		 
			
			 dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			 dao.setQryValue(nqryIndex, 2, vo.getStrSupplierTypeId());
			 dao.setQryValue(nqryIndex, 3, vo.getStrSupplierTypeName());
			 dao.setQryValue(nqryIndex, 4, vo.getStrRemarks());
			 dao.setQryValue(nqryIndex, 5, vo.getStrEffectiveFrom());
			 dao.setQryValue(nqryIndex, 6, vo.getStrLstmodSeatId());
			 dao.setQryValue(nqryIndex, 7, vo.getStrIsValid());
			 dao.setQryValue(nqryIndex, 8, vo.getStrHospitalCode());
			 dao.setQryValue(nqryIndex, 9, vo.getStrSupplierTypeId());
			 
			 dao.execute(nqryIndex, 0);
			
			 

			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {

			vo.setStrMsgString("--> SupplierTypeMstDAO.updateQuery()-->"
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
	public static void initialUpdateQuery(SupplierTypeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";
		try {
			dao = new HisDAO("mms", "SupplierTypeMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.supplierTypeMst.4");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrSupplierTypeName());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrSupplierTypeId());
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
			vo.setStrMsgString("--> SupplierTypeMstDAO.initialUpdateQuery()-->"
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
