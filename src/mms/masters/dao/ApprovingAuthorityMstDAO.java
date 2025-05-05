package mms.masters.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.ApprovingAuthorityDAO;
import mms.masters.vo.ApprovingAuthorityMstVO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Pramod Kumar Mehta
 * Version : 1.0
 * Date : 14/April/2009
 * Module:MMS
 * Unit:Approving Authority Master
 */

/**
 * Developer : Anshul Jindal Version : 1.0 Modify Date : 22/May/2009
 * 
 */

public class ApprovingAuthorityMstDAO {

	/**
	 * This method is used to insert the record in database for this activity
	 * call the insert()method or insertAdmin() method from
	 * ApprovingAuthorityDAO java file which is available on mms.dao package.
	 * 
	 * @param vo the vo
	 */
	public static void insertrecord(ApprovingAuthorityMstVO vo) {
		HisDAO dao = null;

		ApprovingAuthorityDAO approvingAuthorityDAO = null;

		try {
			dao = new HisDAO("mms", "ApprovingAuthorityMstDAO");
			approvingAuthorityDAO = new ApprovingAuthorityDAO();

			if (vo.getStrApprovingTypeId().equals("1")) {
				approvingAuthorityDAO.setStrStoreId(vo.getStrStoreId());
			}
			if (vo.getStrApprovingTypeId().equals("2")) {
				approvingAuthorityDAO.setStrStoreId("0");
			}
			approvingAuthorityDAO.setStrHospitalCode(vo.getStrHospitalCode());
			approvingAuthorityDAO.setStrUserId(vo.getStrUserId());
			approvingAuthorityDAO.setStrApprovingTypeId(vo
					.getStrApprovingTypeId());

			approvingAuthorityDAO.setStrRemarks(vo.getStrRemarks());
			approvingAuthorityDAO.setStrEffectiveDate(vo.getStrEffectiveDate());
			approvingAuthorityDAO.setStrSeatId(vo.getStrSeatId());
			approvingAuthorityDAO.setStrIsValid(vo.getStrIsValid());
			approvingAuthorityDAO.setStrCommitteeFlag(vo.getStrCommitteeFlag());

			approvingAuthorityDAO.insert(dao);

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("ApprovingAuthorityMstDAO.insertrecord() --> "
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
	 * This method is use to initialize the value of list box on add page.
	 * 
	 * @param vo the vo
	 */
	public static void addUserListValue(ApprovingAuthorityMstVO vo) {
		HisDAO dao = null;
		int nqryIndex = 0;
		WebRowSet wb = null;

		String strquery = "";
		try {
			// For Left List box

			dao = new HisDAO("mms", "ApprovingAuthorityMstDAO");

			
			
			
			
			
			
			
			if("0".equals(vo.getStrCommitteeFlag())) {
				strquery = mms.qryHandler_mms.getQuery(1, "select.app_auth.leftList.1");
			} else if("1".equals(vo.getStrCommitteeFlag())) {
				strquery = mms.qryHandler_mms.getQuery(1, "select.app_auth.leftList.2");
			} else {
				throw new Exception("Commitee flag is not set.");
			}
			
			System.out.println("-Query Left-->>>"+strquery);
			
			System.out.println("-getStrHospitalCode-->>>"+vo.getStrHospitalCode());
			System.out.println("-getStrStoreId-->>>"+vo.getStrStoreId());
			System.out.println("-getStrApprovingTypeId-->>>"+vo.getStrApprovingTypeId());
			
			
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1,vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrStoreId());
			dao.setQryValue(nqryIndex, 3, vo.getStrApprovingTypeId());
			
			

			wb = dao.executeQry(nqryIndex);

			vo.setStrUserNameWS(wb);

			// for Right List box
			if("0".equals(vo.getStrCommitteeFlag())) {
				strquery = mms.qryHandler_mms.getQuery(1, "select.app_auth.rightList.1");
			} else if("1".equals(vo.getStrCommitteeFlag())) {
				strquery = mms.qryHandler_mms.getQuery(1, "select.app_auth.rightList.2");
			} else {
				throw new Exception("Commitee flag is not set.");
			}
			System.out.println("-Query Right-->>>"+strquery);
			
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrStoreId());
			dao.setQryValue(nqryIndex, 3, vo.getStrApprovingTypeId());
			
			wb = dao.executeQry(nqryIndex);

			vo.setStrRUserListWS(wb);

		} catch (Exception e) {
			//e.printStackTrace();
			vo
					.setStrMsgString("ApprovingAuthorityMstDAO.addUserListValue() --> "
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
	 * This method is used to modify the rocord .
	 * 
	 * @param vo the vo
	 */
	public static void modifyRecord(ApprovingAuthorityMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet web = null;

		try {
			dao = new HisDAO("mms", "ApprovingAuthorityMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.app_auth.3");

			nqryIndex = dao.setQuery(strquery);

			// System.out.println("dao hos" + vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 1, vo.getStrAppId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());

			web = dao.executeQry(nqryIndex);

			while (web.next()) {

				vo.setStrUserNameModify(web.getString(1));
				vo.setStrIsValid(web.getString(2));
				vo.setStrEffectiveDate(web.getString(3));
				vo.setStrRemarks(web.getString(4));

			}

		} catch (Exception e) {
			vo.setStrMsgString("--> ApprovingAuthorityMstDAO.modifyRecord()-->"
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
	 * This method is used to update the record in database for this activity
	 * call the update() method from ApprovingAuthorityDAO java file which is
	 * available on mms.dao package.
	 * 
	 * @param vo the vo
	 */
	public static void updateRecord(ApprovingAuthorityMstVO vo) {
		HisDAO dao = null;

		ApprovingAuthorityDAO approvingAuthorityDAO = null;
		try {
			dao = new HisDAO("mms", "ApprovingAuthorityMstDAO");
			approvingAuthorityDAO = new ApprovingAuthorityDAO();

			approvingAuthorityDAO.setStrEffectiveDate(vo.getStrEffectiveDate());
			approvingAuthorityDAO.setStrRemarks(vo.getStrRemarks());
			approvingAuthorityDAO.setStrIsValid(vo.getStrIsValid());
			approvingAuthorityDAO.setStrSeatId(vo.getStrSeatId());
			approvingAuthorityDAO.setStrAppId(vo.getStrAppId());
			approvingAuthorityDAO.setStrHospitalCode(vo.getStrHospitalCode());

			approvingAuthorityDAO.update(dao);

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("ApprovingAuthorityMstDAO.updateRecord() --> "
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
