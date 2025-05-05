package mms.masters.dao;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.SparePartsDAO;
import mms.masters.vo.SparePartsMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SparePartsMstDAO.
 */
public class SparePartsMstDAO {
	
	/**
	 * for getting option value of combo on add page (store type name ).
	 * 
	 * @param vo the vo
	 */

	public static void initialAddQuery(SparePartsMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";

		try {
			/*
			 * hisutil = new HisUtil("master", "SparePartsMstDAO"); dao = new
			 * HisDAO("mms", "SparePartsMstDAO");
			 * 
			 * strquery =
			 * mms.qryHandler_mms.getQuery(1,"select.sparePartMst.combo.1");
			 * strquery1 =
			 * mms.qryHandler_mms.getQuery(1,"select.sparePartMst.data.1");
			 * 
			 * nqryIndex = dao.setQuery(strquery); nqryIndex1 =
			 * dao.setQuery(strquery1);
			 * 
			 * 
			 * dao.setQryValue(nqryIndex1, 1, "1"); dao.setQryValue(nqryIndex1,
			 * 2, vo.getStrHospitalCode());
			 * 
			 * 
			 * 
			 * wb = dao.executeQry(nqryIndex); wb1 = dao.executeQry(nqryIndex1);
			 * 
			 * vo.setStrSparePartDtlWs(wb1);
			 * 
			 * str2 = hisutil.getOptionValue(wb, "-1","0^Select Value", true);
			 * 
			 * if(str2!=null) { vo.setStrItemCategoryCombo(str2); } else { str2 = "<option
			 * value='0'>DATA N/A</option>"; vo.setStrItemCategoryCombo(str2); }
			 */
			dao = new HisDAO("mms", "ItemSetsMstDAO");
			strquery = mms.qryHandler_mms
					.getQuery(1, "select.GroupNameCombo.0");// Query for Group
															// Name Combo
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
			wb = dao.executeQry(nqryIndex);
			vo.setStrGroupComboWS(wb);

			strquery = mms.qryHandler_mms.getQuery(1, "select.sparePartMst.8");// Previous
																				// Spare
																				// Part
																				// Details
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrItemId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			wb = dao.executeQry(nqryIndex);
			vo.setStrSparePartDtlWs(wb);

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.ItemCategoryCombo.0");// Item Category Combo for
													// Add Page
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			wb = dao.executeQry(nqryIndex);
			vo.setStrSparePartCatgComboWS(wb);

		} catch (Exception e) {
			vo.setStrMsgString("--> SparePartsMstDAO.initialAddQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/*
	 * public static void getItemNameCombo(SparePartsMstVO vo) { HisDAO dao =
	 * null; int nqryIndex; WebRowSet wb = null ; String strquery = "";
	 * 
	 * String str2 = null; HisUtil hisutil = null;
	 * 
	 * try { hisutil = new HisUtil("master", "SparePartsMstDAO"); dao = new
	 * HisDAO("mms", "SparePartsMstDAO");
	 * 
	 * strquery = mms.qryHandler_mms.getQuery(1,"select.sparePartMst.combo.2");
	 * nqryIndex = dao.setQuery(strquery);
	 * 
	 * dao.setQryValue(nqryIndex, 1, "1"); dao.setQryValue(nqryIndex, 2,
	 * vo.getStrHospitalCode()); dao.setQryValue(nqryIndex, 3,
	 * vo.getStrItemId());
	 * 
	 * wb = dao.executeQry(nqryIndex);
	 * 
	 * str2 = hisutil.getOptionValue(wb, "-1","0^Select Value", true);
	 * 
	 * if(str2!=null) { vo.setStrItemNameCombo(str2); } else { str2 = "<option
	 * value='0'>DATA N/A</option>"; vo.setStrItemNameCombo(str2); }
	 * 
	 * 
	 *  } catch (Exception e) {
	 * vo.setStrMsgString("-->SparePartsMstDAO.getItemNameCombo()-->" +
	 * e.getMessage()); vo.setStrMsgType("1"); } finally { if (dao != null)
	 * dao.free(); dao = null; }
	 *  }
	 */

	/**
	 * Gets the adds the query.
	 * 
	 * @param vo the vo
	 * 
	 * @return the adds the query
	 */
	public static void getAddQuery(SparePartsMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";

		try {
			dao = new HisDAO("mms", "SparePartsMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.SubGroupNameCombo.0");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrGroupId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			wb = dao.executeQry(nqryIndex);
			vo.setStrSubGroupComboWS(wb);
		} catch (Exception e) {
			vo.setStrMsgString("SparePartsMstDAO.getAddQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * Gets the item grp query.
	 * 
	 * @param vo the vo
	 * 
	 * @return the item grp query
	 */
	public static void getItemGrpQuery(SparePartsMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";

		try {
			dao = new HisDAO("mms", "SparePartsMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.SubGroupNameCombo.15");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrSparePatCategoryNo());
			dao.setQryValue(nqryIndex, 3, vo.getStrGroupId());

			wb = dao.executeQry(nqryIndex);
			vo.setStrItemNameComboWS(wb);
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("SparePartsMstDAO.getItemGrpQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * Gets the item query.
	 * 
	 * @param vo the vo
	 * 
	 * @return the item query
	 */
	public static void getItemQuery(SparePartsMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";

		try {
			dao = new HisDAO("mms", "SparePartsMstDAO");

			if (vo.getStrSubGroupId().equals("0")) {
				strquery = mms.qryHandler_mms.getQuery(1,
						"select.SubGroupNameCombo.15");
				nqryIndex = dao.setQuery(strquery);
				dao.setQryValue(nqryIndex, 1, vo.getStrGroupId());
				dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			} else {

				strquery = mms.qryHandler_mms.getQuery(1,
						"select.ItemNameCombo1.0");
				//System.out.println("strquery ::"+strquery);
				nqryIndex = dao.setQuery(strquery);
				dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
				dao.setQryValue(nqryIndex, 2, vo.getStrSparePatCategoryNo());
				dao.setQryValue(nqryIndex, 3, vo.getStrGroupId());
				dao.setQryValue(nqryIndex, 4, vo.getStrSubGroupId());
			}
			wb = dao.executeQry(nqryIndex);
			vo.setStrItemNameComboWS(wb);

		} catch (Exception e) {
			vo.setStrMsgString("SparePartsMstDAO.getItemQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * for getting option value of combo on add page (store type name ).
	 * 
	 * @param vo the vo
	 */

	public static void initialModifyQuery(SparePartsMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";

		// String strtemp[] = null;
		// String chk1 = null;

		try {

			dao = new HisDAO("mms", "SparePartsMstDAO");

			/*
			 * chk1 = vo.getStrChk1(); chk1=chk1.replace('@', '$'); strtemp =
			 * chk1.replace('$', '#').split("#");
			 */
			
			

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.sparePartMst.modify.getData.0"); // 3 Values
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrItemId());
			dao.setQryValue(nqryIndex, 2, vo.getStrSparePartItemId());
			dao.setQryValue(nqryIndex, 3, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 4, vo.getStrItemSlNo());
			wb = dao.executeQry(nqryIndex);
			while (wb.next()) {
				vo.setStrItemCatgName(wb.getString(1));
				vo.setStrItemName(wb.getString(2));
				vo.setStrSparePartCategoryName(wb.getString(3));
				vo.setStrSparePartItemName(wb.getString(4));
				vo.setStrEffectiveFrom(wb.getString(5));
				vo.setStrRemarks(wb.getString(6));
				vo.setStrIsValid(wb.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> SparePartsMstDAO.initialModifyQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/*
	 * ---------------Calling of Function for
	 * CommttieSerialNo---------------------
	 */
	/**
	 * Calling function get spare part id.
	 * 
	 * @param vo the vo
	 * 
	 * @return the string
	 */
	public static String callingFunctionGetSparePartID(SparePartsMstVO vo) {
		HisDAO dao = null;
		// WebRowSet ws = null;
		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		// Split the Value

		try {
			dao = new HisDAO("mms", "CommitteeMemberDetailMstDAO");

			// (hosp_code NUMBER,itemId NUMBER)
			funcIndex = dao
					.setFunction("{? = call MMS_MST.get_sparepart_id(?,?)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, vo.getStrHospitalCode());
			// // System.out.println("Commite No in
			// Function::"+VO.getStrCommitNo());
			dao.setFuncInValue(funcIndex, 3, vo.getStrItemId());
			dao.setFuncOutValue(funcIndex, 1);
			// Execute Function
			dao.executeFunction(funcIndex);
			retVal = dao.getFuncString(funcIndex);
			// VO.setStrApprovalSlNo(retVal);

		} catch (Exception e) {
			vo
					.setStrMsgString("SparePartsMstDAO.callingFunctionGetSparePartID() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			// ws = null;
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
		return retVal;
	}

	/**
	 * Check the Record weather data is Duplicate or not.
	 * 
	 * @param vo -
	 * FormBean Object
	 * 
	 * @return - true -record cannot be saved ,already exist false - record will
	 * save
	 * 
	 * @throws Exception 	 */
	public static void chkDuplicate(SparePartsMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {

			dao = new HisDAO("mms", "SparePartsMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.sparePartMst.2");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrItemId());
			dao.setQryValue(nqryIndex, 2, vo.getStrSparePartItemId());
			dao.setQryValue(nqryIndex, 3, vo.getStrHospitalCode());
			// dao.setQryValue(nqryIndex, 4, vo.getStrItemSlNo());

			wb = dao.executeQry(nqryIndex);
			// System.out.println("Web Row Set Size-->"+wb.size());
			while (wb.next()) {
				// System.out.println("wb.getString(1)-->"+wb.getString(1));
				ncount = Integer.parseInt(wb.getString(1));
			}
			if (ncount == 0) {
				vo.setBExistStatus(true);
			} else {
				vo.setBExistStatus(false);
			}
		} catch (Exception e) {
			vo.setStrMsgString("SparePartsMstDAO.chkDuplicate() --> "
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
	public static void insertQuery(SparePartsMstVO vo) {

		SparePartsDAO sparepartDAO = null;
		HisDAO dao = null;
		// String EmpNo = null;

		try {
			sparepartDAO = new SparePartsDAO();
			dao = new HisDAO("mms", "SparePartsMstDAO");

			sparepartDAO.setStrHospitalCode(vo.getStrHospitalCode());
			sparepartDAO.setStrItemId(vo.getStrItemId());
			// System.out.println("vo.getStrSparePartItemId()"+vo.getStrSparePartItemId());
			sparepartDAO.setStrSparePartId(vo.getStrSparePartItemId());
			sparepartDAO.setStrItemCatNo(vo.getStrItemCatgNo());
			sparepartDAO.setStrRemarks(vo.getStrRemarks());
			sparepartDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			sparepartDAO.setStrSeatId(vo.getStrSeatId());
			sparepartDAO.setStrIsValid(vo.getStrIsValid());
			sparepartDAO.setStrSparePartCatNo(vo.getStrSparePatCategoryNo());
			sparepartDAO.insert(dao);

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> SparePartsMstMstDAO.insertQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * to update the record.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public static void updateQuery(SparePartsMstVO vo) {
		SparePartsDAO sparepartDAO = null;
		HisDAO dao = null;

		try {
			sparepartDAO = new SparePartsDAO();
			dao = new HisDAO("mms", "SparePartsMstDAO");

			sparepartDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			sparepartDAO.setStrLastModifiedSeatId(vo.getStrLastModeSeatId());
			sparepartDAO.setStrRemarks(vo.getStrRemarks());
			sparepartDAO.setStrIsValid(vo.getStrIsValid());
			sparepartDAO.setStrItemId(vo.getStrItemId());
			sparepartDAO.setStrSparePartId(vo.getStrSparePartItemId());
			sparepartDAO.setStrHospitalCode(vo.getStrHospitalCode());
			sparepartDAO.setStrItemSlNo(vo.getStrItemSlNo());
			sparepartDAO.setStrItemCatNo(vo.getStrItemCatgNo());			
			sparepartDAO.setStrSparePartCatNo(vo.getStrSparePatCategoryNo());
			
			sparepartDAO.update(dao);

			synchronized (dao) {
				dao.fire();

			}
		} catch (Exception e) {
			vo.setStrMsgString("-->SparePartsMstDAO.updateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}
	}

	/*
	 * public static void getUnitValues(SparePartsMstVO vo) { HisDAO dao = null;
	 * String strQuery=""; int nQueryIndex=0; WebRowSet web=null; try { dao =
	 * new HisDAO("mms", "SparePartsMstDAO"); strQuery
	 * =mms.qryHandler_mms.getQuery(1, "select.UnitNameCombo1.0"); nQueryIndex =
	 * dao.setQuery(strQuery); dao.setQryValue(nQueryIndex, 1,
	 * vo.getStrHospitalCode()); dao.setQryValue(nQueryIndex, 2,
	 * vo.getStrModuleId()); web = dao.executeQry(nQueryIndex); if(web.next()) {
	 * 
	 * vo.setStrUnitNameComboWS(web); }
	 *  } catch(Exception e) {
	 * vo.setStrMsgString("ItemSetsMstDAO.getUnitValues() --> " +
	 * e.getMessage()); vo.setStrMsgType("1"); } finally { dao = null; web=null; } }
	 */

}
