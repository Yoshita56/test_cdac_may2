package mms.masters.dao;

import hisglobal.exceptions.HisException;
import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.ItemSetsDAO;
import mms.masters.vo.ItemSetsMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemSetsMstDAO.
 */
public class ItemSetsMstDAO {

	/**
	 * for getting option value of combo on add page (store type name ).
	 * 
	 * @param vo
	 *            the vo
	 */

	public static void initialAddQuery(ItemSetsMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";
		try {
			dao = new HisDAO("mms", "ItemSetsMstDAO");
			/*
			 * strquery =
			 * mms.qryHandler_mms.getQuery(1,"select.GroupNameCombo.0");// Query
			 * for Group Name Combo nqryIndex = dao.setQuery(strquery);
			 * dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode()); wb =
			 * dao.executeQry(nqryIndex); vo.setStrGroupComboWS(wb);
			 */

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.SetItemCategoryCombo.1");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			wb = dao.executeQry(nqryIndex);
			vo.setStrItemCatComboWS(wb);

			strquery = mms.qryHandler_mms.getQuery(1, "select.ItemsetsMst.8");// Added
																				// Item
																				// Details
																				// Query
			nqryIndex = dao.setQuery(strquery);
			// System.out.println("vo.getStrSetId()"+vo.getStrSetId());
			// System.out.println("vo.getStrHospitalCode()"+vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 1, vo.getStrSetId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			wb = dao.executeQry(nqryIndex);
			vo.setStrItemDetails(wb);

			/*
			 * Added by Aritra. Reason populate Generic name from backend.
			 */
			strquery = mms.qryHandler_mms.getQuery(1, "select.ItemsetsMst.9");// Added
			strquery = strquery.replaceFirst("\\?", vo.getGenericTableName());
			strquery = strquery.replaceFirst("\\?", vo.getItemTableName());
			// Item
			// Details
			// Query
			nqryIndex = dao.setQuery(strquery);
			// System.out.println("vo.getStrSetId()"+vo.getStrSetId());
			// System.out.println("vo.getStrHospitalCode()"+vo.getStrHospitalCode());

			// dao.setQryValue(nqryIndex, 1, vo.getGenericTableName());
			// dao.setQryValue(nqryIndex, 2, vo.getItemTableName());
			dao.setQryValue(nqryIndex, 1, vo.getStrSetId());
			wb = dao.executeQry(nqryIndex);
			if (wb.next()) {
				vo.setStrGenItemName(wb.getString(1));
			}

		} catch (Exception e) {
			vo.setStrMsgString("ItemSetsMstDAO.initialAddQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * Gets the adds the query.
	 * 
	 * @param vo
	 *            the vo
	 * 
	 * @return the adds the query
	 */
	public static void getAddQuery(ItemSetsMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";

		try {
			dao = new HisDAO("mms", "ItemSetsMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.SubGroupNameCombo.0");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrGroupId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			wb = dao.executeQry(nqryIndex);
			vo.setStrSubGroupComboWS(wb);

		} catch (Exception e) {
			vo.setStrMsgString("ItemSetsMstDAO.getAddQuery()-->"
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
	 * @param vo
	 *            the vo
	 * 
	 * @return the item grp query
	 */
	public static void getItemGrpQuery(ItemSetsMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";

		try {

			dao = new HisDAO("mms", "ItemSetsMstDAO");

			if (vo.getStrItemCategoryNo().equals("1")) {

				strquery = mms.qryHandler_mms.getQuery(1,
						"select.ItemGroupCombo.0");

			} else {
				strquery = mms.qryHandler_mms.getQuery(1,
						"select.ItemGroupCombo.1");

			}
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrGroupId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());

			wb = dao.executeQry(nqryIndex);
			vo.setStrItemNameComboWS(wb);

		} catch (Exception e) {
			vo.setStrMsgString("ItemSetsMstDAO.getItemGrpQuery()-->"
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
	 * @param vo
	 *            the vo
	 * 
	 * @return the item query
	 */
	public static void getItemQuery(ItemSetsMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";

		try {
			dao = new HisDAO("mms", "ItemSetsMstDAO");

			if (vo.getStrItemCategoryNo().equals("10")) {
				if (vo.getStrGenItemId().equals("0")) {

					strquery = mms.qryHandler_mms.getQuery(1,
							"select.ItemCombo.2");
					nqryIndex = dao.setQuery(strquery);
					dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
					dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
					dao.setQryValue(nqryIndex, 3, vo.getStrGroupId());

				} else {
					strquery = mms.qryHandler_mms.getQuery(1,
							"select.ItemCombo.0");
					nqryIndex = dao.setQuery(strquery);
					dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
					dao.setQryValue(nqryIndex, 2, vo.getStrGenItemId());
				}

			} else {
				if (vo.getStrGenItemId().equals("0")) {
					strquery = mms.qryHandler_mms.getQuery(1,
							"select.ItemCombo.3");
					nqryIndex = dao.setQuery(strquery);
					dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
					dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
					dao.setQryValue(nqryIndex, 3, vo.getStrGroupId());

				} else {
					strquery = mms.qryHandler_mms.getQuery(1,
							"select.ItemCombo.1");
					nqryIndex = dao.setQuery(strquery);
					dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
					dao.setQryValue(nqryIndex, 2, vo.getStrGenItemId());
				}
			}

			wb = dao.executeQry(nqryIndex);

			vo.setStrItemNameComboWS(wb);

		} catch (Exception e) {
			vo.setStrMsgString("ItemSetsMstDAO.getItemQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * Gets the gen item name combo.
	 * 
	 * @param vo
	 *            the vo
	 * 
	 * @return the gen item name combo
	 */
	public static void getGenItemNameCombo(ItemSetsMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";

		try {
			dao = new HisDAO("mms", "ItemSetsMstDAO");

			if (vo.getStrSubGroupId().equals("0")) {

				/*
				 * Item Category No is 10 for drug.
				 */
				if (vo.getStrItemCategoryNo().equals("10")) {
					strquery = mms.qryHandler_mms.getQuery(1,
							"select.GenItemCombo.0");

				} else {
					strquery = mms.qryHandler_mms.getQuery(1,
							"select.GenItemCombo.1");

				}
				nqryIndex = dao.setQuery(strquery);
				dao.setQryValue(nqryIndex, 1, vo.getStrGroupId());
				dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			} else {
				if (vo.getStrItemCategoryNo().equals("10")) {
					strquery = mms.qryHandler_mms
							.getQuery(1, "select.GenItemCombo.2")
							.concat(" AND "
									+ mms.qryHandler_mms
											.getQuery(1,
													"select.GenItemCombo.cond.0")
											.replace("?",
													vo.getStrHospitalCode())
											.concat(" AND "
													+ mms.qryHandler_mms
															.getQuery(1,
																	"select.GenItemCombo.cond.1")
															.replace(
																	"?",
																	vo.getStrItemCategoryNo())
															.concat(" AND "
																	+ mms.qryHandler_mms
																			.getQuery(
																					1,
																					"select.GenItemCombo.cond.2")
																			.replace(
																					"?",
																					vo.getStrSubGroupId()))))
							.concat(" AND "
									+ mms.qryHandler_mms.getQuery(1,
											"select.GenItemCombo.cond.3")
											.replace("?", vo.getStrGroupId()));
					nqryIndex = dao.setQuery(strquery);
				} else {
					strquery = mms.qryHandler_mms
							.getQuery(1, "select.GenItemCombo.3")
							.concat(" AND "
									+ mms.qryHandler_mms
											.getQuery(1,
													"select.GenItemCombo.cond.0")
											.replace("?",
													vo.getStrHospitalCode())
											.concat(" AND "
													+ mms.qryHandler_mms
															.getQuery(1,
																	"select.GenItemCombo.cond.1")
															.replace(
																	"?",
																	vo.getStrItemCategoryNo())
															.concat(" AND "
																	+ mms.qryHandler_mms
																			.getQuery(
																					1,
																					"select.GenItemCombo.cond.2")
																			.replace(
																					"?",
																					vo.getStrSubGroupId()))))
							.concat(" AND "
									+ mms.qryHandler_mms.getQuery(1,
											"select.GenItemCombo.cond.3")
											.replace("?", vo.getStrGroupId()));
					nqryIndex = dao.setQuery(strquery);
				}

				nqryIndex = dao.setQuery(strquery);
			}

			wb = dao.executeQry(nqryIndex);

			vo.setStrGenItemNameComboWS(wb);

		} catch (Exception e) {
			vo.setStrMsgString("ItemSetsMstDAO.getGenItemNameCombo()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * Gets the group name combo.
	 * 
	 * @param vo
	 *            the vo
	 * 
	 * @return the group name combo
	 */
	public static void getGroupNameCombo(ItemSetsMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";

		try {
			dao = new HisDAO("mms", "ItemSetsMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.ItemSets.GroupNameCombo.0");// Query for Group Name
														// Combo
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nqryIndex, 2, vo.getStrItemCatId());
			wb = dao.executeQry(nqryIndex);
			vo.setStrGroupComboWS(wb);

		} catch (Exception e) {
			vo.setStrMsgString("ItemSetsMstDAO.getGroupNameCombo()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * Gets the unit values.
	 * 
	 * @param vo
	 *            the vo
	 * 
	 * @return the unit values
	 */
	public static void getUnitValues(ItemSetsMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("mms", "ItemSetsMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.UnitNameCombo.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrInventoryUnitId());
			dao.setQryValue(nQueryIndex, 3, vo.getStrInventoryUnitId());
			web = dao.executeQry(nQueryIndex);

			vo.setStrUnitNameComboWS(web);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("ItemSetsMstDAO.getUnitValues() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			web = null;
		}
	}

	/**
	 * to insert the data.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void insertQuery(ItemSetsMstVO vo) {
		HisDAO dao = null;
		ItemSetsDAO itemSetsDao = null;

		try {
			itemSetsDao = new ItemSetsDAO();
			dao = new HisDAO("mms", "ItemSetsMstDAO");

			itemSetsDao.setStrHospitalCode(vo.getStrHospitalCode());
			itemSetsDao.setStrItemId(vo.getStrItemId());
			itemSetsDao.setStrSetId(vo.getStrSetId());
			itemSetsDao.setStrItemBrandId(vo.getStrItemBrandId());
			itemSetsDao.setStrSetCatNo(vo.getStrSetCatNo());
			itemSetsDao.setStrItemCatNo(vo.getStrItemCategoryNo());
			itemSetsDao.setStrItemQuantity(vo.getStrItemQuantity());
			itemSetsDao.setStrUnitId(vo.getStrUnitId());
			itemSetsDao.setStrRemarks(vo.getStrRemarks());
			itemSetsDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			itemSetsDao.setStrSeatId(vo.getStrSeatId());
			itemSetsDao.setStrIsValid("1");

			itemSetsDao.insert(dao);

			synchronized (dao) {
				dao.fire();

			}
		} catch (Exception e) {

			vo.setStrMsgString("ItemSetsMstDAO.insertQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

			itemSetsDao = null;

		}

	}

	/**
	 * Check the Record weather data is Duplicate or not.
	 * 
	 * @param vo
	 *            - FormBean Object
	 * 
	 * @return - true -record cannot be saved ,already exist false - record will
	 *         save
	 * 
	 * @throws Exception
	 */
	public static void chkDuplicate(ItemSetsMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {

			dao = new HisDAO("mms", "ItemSetsMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.ItemSetsMst.2");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrSetId());
			dao.setQryValue(nqryIndex, 2, vo.getStrItemBrandId());
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
			vo.setStrMsgString("ItemSetsMstDAO.chkDuplicate() --> "
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
	 * retrieves and executes modify Query.
	 * 
	 * @param vo
	 *            the vo
	 * 
	 * @throws Exception
	 */
	public static void modifyQuery(ItemSetsMstVO vo) {

		HisDAO dao = new HisDAO("mms", "ItemSetsMstDAO");

		int nqryIndex;
		String strquery = new String();

		try {

			strquery = mms.qryHandler_mms.getQuery(1, "select.ItemSetsMst.3");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrSetId());
			dao.setQryValue(nqryIndex, 2, vo.getStrItemId());
			dao.setQryValue(nqryIndex, 3, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 4, vo.getStrSetSlNo());

			WebRowSet web = dao.executeQry(nqryIndex);
			while (web.next()) {
				vo.setStrSetCategoryName(web.getString(1));
				vo.setStrSetName(web.getString(2));
				vo.setStrItemCatName(web.getString(3));
				vo.setStrGenItemName(web.getString(4));
				vo.setStrItemName(web.getString(5));
				vo.setStrItemQuantity(web.getString(6));
				vo.setStrUnitId(web.getString(7));
				vo.setStrEffectiveFrom(web.getString(8));
				vo.setStrRemarks(web.getString(9));
				vo.setStrIsValid(web.getString(10));
				vo.setStrItemCategoryNo(web.getString(11));
				vo.setStrItemBrandId(web.getString(12));

			}
			if (vo.getStrItemCategoryNo().equals("10")) {
				strquery = mms.qryHandler_mms.getQuery(1,
						"select.ItemSetsMst.inventoryUnit.0");
			} else {
				strquery = mms.qryHandler_mms.getQuery(1,
						"select.ItemSetsMst.inventoryUnit.1");
			}

			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrItemId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());

			web = dao.executeQry(nqryIndex);

			while (web.next()) {
				vo.setStrInventoryUnitId(web.getString(1));
			}

			getUnitValues(vo);
		} catch (Exception e) {
			vo.setStrMsgString("ItemSetsMstDAO.modifyQuery() --> "
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
	 * retrieves and executes update Query.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void updateQuery(ItemSetsMstVO vo) {

		HisDAO dao = null;

		ItemSetsDAO itemSetsDao = null;

		try {

			itemSetsDao = new ItemSetsDAO();
			dao = new HisDAO("mms", "ItemSetsMstDAO");

			itemSetsDao.setStrItemQuantity(vo.getStrItemQuantity());
			itemSetsDao.setStrUnitId(vo.getStrUnitId());
			itemSetsDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			itemSetsDao.setStrLastModifiedSeatId(vo.getStrSeatId());
			itemSetsDao.setStrRemarks(vo.getStrRemarks());
			itemSetsDao.setStrIsValid(vo.getStrIsValid());
			itemSetsDao.setStrSetId(vo.getStrSetId());
			itemSetsDao.setStrItemId(vo.getStrItemId());
			itemSetsDao.setStrHospitalCode(vo.getStrHospitalCode());
			itemSetsDao.setStrSetSlNo(vo.getStrSetSlNo());
			itemSetsDao.update(dao);

			itemSetsDao.setStrHospitalCode(vo.getStrHospitalCode());
			itemSetsDao.setStrItemId(vo.getStrItemId());
			itemSetsDao.setStrSetId(vo.getStrSetId());
			itemSetsDao.setStrItemBrandId(vo.getStrItemBrandId());
			itemSetsDao.setStrSetCatNo(vo.getStrSetCatNo());
			itemSetsDao.setStrItemCatNo(vo.getStrItemCatId());
			itemSetsDao.setStrItemQuantity(vo.getStrItemQuantity());
			itemSetsDao.setStrUnitId(vo.getStrUnitId());
			itemSetsDao.setStrRemarks(vo.getStrRemarks());
			itemSetsDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			itemSetsDao.setStrSeatId(vo.getStrSeatId());
			itemSetsDao.setStrIsValid(vo.getStrIsValid());
			itemSetsDao.insert(dao);

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {
			vo.setStrMsgString("ItemSetsMstDAO.updateQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

	public static void getUnitValuesFromItemId(ItemSetsMstVO vo) {

		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("mms", "ItemSetsMstDAO");

			if(vo.getStrItemCategoryNo().equals("10")) {
				strQuery = mms.qryHandler_mms.getQuery(1, "select.UnitNameCombo.1");
			} else {
				strQuery = mms.qryHandler_mms.getQuery(1, "select.UnitNameCombo.2");
			}
			
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrItemId());
			dao.setQryValue(nQueryIndex, 3, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 4, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 5, vo.getStrItemId());
			dao.setQryValue(nQueryIndex, 6, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 7, vo.getStrHospitalCode());
			web = dao.executeQry(nQueryIndex);

			vo.setStrUnitNameComboWS(web);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("ItemSetsMstDAO.getUnitValuesFromItemId() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			web = null;
		}

	}

	public static void getItemId(ItemSetsMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("mms", "ItemSetsMstDAO");

			if(vo.getStrItemCategoryNo().equals("10")) {
				strQuery = mms.qryHandler_mms.getQuery(1, "select.ItemSetsMst.itemid.0");
			} else {
				strQuery = mms.qryHandler_mms.getQuery(1, "select.ItemSetsMst.itemid.1");
			}
			
			nQueryIndex = dao.setQuery(strQuery);

			
			dao.setQryValue(nQueryIndex, 1, vo.getStrItemBrandId());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospitalCode());
			
			web = dao.executeQry(nQueryIndex);
			
			if(web.next()) {
				vo.setStrItemId(web.getString(1));
			} else {
				throw new HisException("Generic name found for itembrand_id=>"
						+ vo.getStrItemBrandId()
						+ " and item category=> "
						+ ((vo.getStrItemCategoryNo().equals("10")) ? "Drug"
								: "Non Drug"));
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("ItemSetsMstDAO.getItemId() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			web = null;
		}
		
	}

	/**
	 * Check the Record weather data is Duplicate or not
	 * 
	 * @param vo
	 *            - FormBean Object
	 * @return - true -record cannot be saved ,already exist false - record will
	 *         save
	 * @throws Exception
	 */
	/*
	 * public static void initialUpdateQuery(ItemSetsMstVO vo) { HisDAO dao =
	 * null; int nqryIndex; int ncount = 0; WebRowSet wb = null; String strquery
	 * = new String();
	 * 
	 * try { dao = new HisDAO("mms", "ItemSetsMstDAO"); strquery =
	 * mms.qryHandler_mms.getQuery(1, "select.ItemSetsMst.4"); nqryIndex =
	 * dao.setQuery(strquery);
	 * 
	 * dao.setQryValue(nqryIndex, 1, vo.getStrSetId());
	 * dao.setQryValue(nqryIndex, 1, vo.getStrItemId());
	 * dao.setQryValue(nqryIndex, 1, vo.getStrItemBrandId());
	 * dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
	 * dao.setQryValue(nqryIndex, 3, vo.getStrSetSlNo()); wb =
	 * dao.executeQry(nqryIndex); while (wb.next()) { ncount =
	 * Integer.parseInt(wb.getString(1)); } if (ncount == 0) {
	 * vo.setBExistStatus(true); } else { vo.setBExistStatus(false); } } catch
	 * (Exception e) { vo.setStrMsgString("ItemSetsMstDAO.initialUpdateQuery()
	 * --> " + e.getMessage()); vo.setStrMsgType("1"); } finally {
	 * if(dao!=null){ dao.free(); dao = null; } } }
	 */

}
