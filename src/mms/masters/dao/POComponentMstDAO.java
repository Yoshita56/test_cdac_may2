package mms.masters.dao;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.POComponentDAO;
import mms.masters.vo.POComponentMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class POComponentMstDAO.
 * 
 * @author Anurudra Goel
 */

/**
 * @author Anshul Jindal
 *  Modify By : Tanvi Sappal
 * Modify Date : 12/05/2010
 * 
 */
public class POComponentMstDAO {

	/**
	 * Gets the cat values.
	 * 
	 * @param vo the vo
	 * 
	 * @return the cat values
	 */
	public static void getCatValues(POComponentMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;

		try {

			dao = new HisDAO("mms", "POComponentMstDAO");

			strQuery = mms.qryHandler_mms.getQuery(1,
					"select.processComponentMstItemCat.0");

			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
			web = dao.executeQry(nQueryIndex);

			vo.setItemCategoryWS(web);

		} catch (Exception e) {

			vo.setStrMsgString("POComponentMstDAO.getCatValues() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			web = null;

		}
	}

	/**
	 * Gets the component name.
	 * 
	 * @param vo the vo
	 * 
	 * @return the component name
	 */
	public static void getComponentName(POComponentMstVO vo) {
		HisDAO dao = null;
		String strquery = "";
		int nqryIndex = 0;
		WebRowSet web = null;

		try {
				dao = new HisDAO("mms", "POComponentMstDAO");
				strquery = mms.qryHandler_mms.getQuery(1, "select.processComponentMst.10");
				nqryIndex = dao.setQuery(strquery);
				
				//System.out.println("vo.getStrHospitalCode()--"+vo.getStrHospitalCode());
				//System.out.println("vo.getStrComponentTypeId()--"+vo.getStrComponentTypeId());
				
				dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
				dao.setQryValue(nqryIndex, 2, vo.getStrComponentTypeId());
				web = dao.executeQry(nqryIndex);
				vo.setWSComponentName(web);
				
				//System.out.println("Size--"+web.size());

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("POComponentMstDAO.getComponentName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			web = null;

		}
	}

	/**
	 * for getting option value of Component name combo on add page.
	 * 
	 * @param vo the vo
	 */
	/*public static void initAddQuery(POComponentMstVO vo) {

		HisDAO dao = null;
	//	int nqryIndex;
	//	String strquery = "";
	//	WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "POComponentMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.processComponentMst.4").replace("?",
					vo.getStrHospitalCode());
			nqryIndex = dao.setQuery(strquery);
			wb = dao.executeQry(nqryIndex);
			vo.setWSPOTypeName(wb);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> POComponentMstDAO.initAddQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}*/

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public static void insertQuery(POComponentMstVO vo) {

		HisDAO dao = null;
		POComponentDAO processComponentDAO = null;

		try {
			processComponentDAO = new POComponentDAO();
			dao = new HisDAO("mms", "POComponentMstDAO");
			
			/*
			 * INSERT INTO  HSTT_POTYPE_COMPONENT_MST(SSTNUM_INDENTTYPE_ID,HSTNUM_COMPONENT_ID,GNUM_HOSPITAL_CODE, \
						       HSTSTR_COMPONENT_VALUE1,HSTSTR_COMPONENT_VALUE2,GSTR_REMARKS,GDT_EFFECTIVE_FRM, \
	  					       GNUM_SEATID,GNUM_ISVALID,HSTNUM_SL_NO,SSTNUM_ITEM_CAT_NO,HSTNUM_COMP_TYPE_ID)  \
	 				           VALUES(?,?,?,TRIM(?),TRIM(?),TRIM(?),?,?,?,mms_mst.get_potype_slno(?,?,?,?,?),?,?)
			 * */
			
			processComponentDAO.setStrHospitalCode(vo.getStrHospitalCode());
			processComponentDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			processComponentDAO.setStrSeatId(vo.getStrSeatId());
			processComponentDAO.setStrIndentTypeId(vo.getStrIndentTypeId());
			processComponentDAO.setStrComponentId(vo.getStrComponentId());
			processComponentDAO.setStrComponenValue1(vo.getStrComponentValue1());
			processComponentDAO.setStrComponenValue2(vo.getStrComponentValue2());
			processComponentDAO.setStrRemarks(vo.getStrRemarks());
			processComponentDAO.setStrIsValid(vo.getStrIsValid());
			processComponentDAO.setStrCatCode(vo.getStrCatNo());
			processComponentDAO.setStrComponentTypeId(vo.getStrComponentTypeId());
			processComponentDAO.setStrParameterId(vo.getStrParameterId());
			processComponentDAO.insert(dao);

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {

			vo.setStrMsgString("--> POComponentMstDAO.insertQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			processComponentDAO = null;
		}
	}

	/**
	 * to check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */
	public static void initialAddQuery(POComponentMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";
		try {
			dao = new HisDAO("mms", "POComponentMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.processComponentMst.2");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrComponentId());
			dao.setQryValue(nqryIndex, 2, vo.getStrIndentTypeId());
			dao.setQryValue(nqryIndex, 3, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 4, vo.getStrCatNo());
			dao.setQryValue(nqryIndex, 5, vo.getStrComponentTypeId());
			
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
			vo.setStrMsgString("--> POComponentMstDAO.initialAddQuery()-->"
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
	public static void modifyQuery(POComponentMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";

		try {

			dao = new HisDAO("mms", "POComponentMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.processComponentMst.3");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrIndentTypeId());
			dao.setQryValue(nqryIndex, 2, vo.getStrComponentId());
			dao.setQryValue(nqryIndex, 3, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 4, vo.getStrPOComponentSlNo());
			dao.setQryValue(nqryIndex, 5, vo.getStrCatNo());
			dao.setQryValue(nqryIndex, 6, vo.getStrComponentTypeId());
			WebRowSet web = dao.executeQry(nqryIndex);
			while (web.next()) {
				vo.setStrComponentValue1Values(web.getString(1));
				vo.setStrComponentValue2Values(web.getString(2));
				vo.setStrRemarks(web.getString(3));
				vo.setStrEffectiveFrom(web.getString(4));

				vo.setStrIsValid(web.getString(5));
				vo.setStrComponentNameModify(web.getString(6));
				vo.setStrParameterId(web.getString(7));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("--> POComponentMstDAO.modifyQuery()-->"
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
	public static void updateQuery(POComponentMstVO vo) {

		POComponentDAO processComponent = null;
		HisDAO dao = null;

		try {
			processComponent = new POComponentDAO();
			dao = new HisDAO("mms", "POComponentMstDAO");
			processComponent.setStrComponenValue1(vo.getStrComponentValue1());
			processComponent.setStrComponenValue2(vo.getStrComponentValue2());
			processComponent.setStrRemarks(vo.getStrRemarks());
			processComponent.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			processComponent.setStrHospitalCode(vo.getStrHospitalCode());
			processComponent.setStrSeatId(vo.getStrSeatId());
			processComponent.setStrIsValid(vo.getStrIsValid());
			processComponent.setStrComponentId(vo.getStrComponentName());
			processComponent.setStrIndentTypeId(vo.getStrIndentTypeId());
			processComponent.setStrPOComponentSlno(vo.getStrPOComponentSlNo());
			processComponent.setStrCatCode(vo.getStrCatNo());
			processComponent.setStrComponentTypeId(vo.getStrComponentTypeId());
			processComponent.setStrParameterId(vo.getStrParameterId());
			processComponent.update(dao);
			synchronized (dao) {
				dao.fire();

			}
		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("--> POComponentMstDAO.updateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			processComponent = null;

		}

	}

	/**
	 * to check duplicate before update.
	 * 
	 * @param vo the vo
	 *//*
	public static void initialUpdateQuery(StoreTypeMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";
		try {
			dao = new HisDAO("mms", "POComponentMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.storeTypeMst.4");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrStoreTypeName());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrStoreTypeId());
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
			vo.setStrMsgString("--> POComponentMstDAO.initialUpdateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}*/
}
