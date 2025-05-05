package mms.masters.dao;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.SupplierItemDAO;

import mms.masters.vo.SupplierItemMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierItemMstDAO.
 * 
 * @author Anshul Jindal
 */
public class SupplierItemMstDAO {

	/**
	 * for getting option value of item name combo and rate unit combo on add
	 * page.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void initAddQuery(SupplierItemMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet wb = null;

		try {

			dao = new HisDAO("mms", "SupplierItemMstDAO");
			strquery = mms.qryHandler_mms
					.getQuery(1, "select.SupplierCategory.5.0");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrCategoryNo());

			wb = dao.executeQry(nqryIndex);

			while(wb.next())
			{
			vo.setStrItemCategoryName(wb.getString(1));
			}

			strquery = mms.qryHandler_mms
					.getQuery(1, "select.SupplierItem.5.0");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nqryIndex, 2, vo.getStrCategoryNo());

			wb = dao.executeQry(nqryIndex);

			vo.setStrGroupComboWs(wb);

		

		} catch (Exception e) {
			vo.setStrMsgString("--> SupplierItemMstDAO.initAddQuery()-->"
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
	 * for getting option value of left item name list based on group page.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void getLeftItemList(SupplierItemMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet wb = null;

		try {

			dao = new HisDAO("mms", "SupplierItemMstDAO");
			
			if (vo.getStrCategoryNo().equals("10")) {
			
				strquery = mms.qryHandler_mms.getQuery(1,
						"select.SupplierItem.DrugList.0");
			} else {
				
				strquery = mms.qryHandler_mms.getQuery(1,
						"select.SupplierItem.ItemList.0");
			}
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrGroupId());
			dao.setQryValue(nqryIndex, 3, vo.getStrSupplierId());
			dao.setQryValue(nqryIndex, 4, vo.getStrHospitalCode());

			wb = dao.executeQry(nqryIndex);
			vo.setLeftItemListWS(wb);
			
			dao = new HisDAO("mms", "SupplierItemMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.SupplierItem.ItemList.1");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrSupplierId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrGroupId());

			wb = dao.executeQry(nqryIndex);
			vo.setRightItemListWS(wb);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> SupplierItemMstDAO.getLeftItemList()-->"
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
	 * @param vo
	 *            the vo
	 */
	public static void insertQuery(SupplierItemMstVO vo) {

		HisDAO dao = null;
		SupplierItemDAO supplierItemDAO = null;
		String temp[] = null;

		try {

			dao = new HisDAO("mms", "SupplierItemMstDAO");
			supplierItemDAO = new SupplierItemDAO();

			/*
			 * // System.out.println("vo.getStrRightItemIds().length" +
			 * vo.getStrRightItemIds().length);
			 */
			for (int i = 0 , stopI = vo.getStrRightItemIds().length; i < stopI; i++) {
				// //
				// System.out.println("vo.getStrRightItemIds()[i]-"+vo.getStrRightItemIds()[i]);
				if (!vo.getStrRightItemIds()[i].equals("0")) {
					temp = vo.getStrRightItemIds()[i].replace("^", "#").split(
							"#");

					supplierItemDAO.setStrEffectiveFrom(vo
							.getStrEffectiveFrom());
					supplierItemDAO.setStrHospitalCode(vo.getStrHospitalCode());
					supplierItemDAO.setStrIsValid(vo.getStrIsValid());
					supplierItemDAO.setStrRemarks(vo.getStrRemarks());
					supplierItemDAO.setStrSeatId(vo.getStrSeatId());
					supplierItemDAO.setStrItemBrandId(temp[2]);
					supplierItemDAO.setStrItemId(temp[1]);
					supplierItemDAO.setStrSupplierId(vo.getStrSupplierId());
					/*
					 * supplierItemDAO.setStrDeliveryLeadTime(vo.getStrDeliveryLeadTime());
					 * supplierItemDAO.setStrDeliveryLeadTimeUnit(vo
					 * .getStrDeliveryLeadTimeUnit());
					 * supplierItemDAO.setStrRateUnitId(vo.getStrRateUnitId());
					 * supplierItemDAO.setStrItemRate(vo.getStrItemRate());
					 */
					supplierItemDAO.setStrGroupId(vo.getStrGroupId());
					supplierItemDAO.setStrSubGroupId(temp[0]);
					supplierItemDAO.setStrItemCategoryNo(vo.getStrCategoryNo());

					supplierItemDAO.insert(dao);
				}
			}

			synchronized (dao) {

				dao.fire();

			}

		} catch (Exception e) {

			e.printStackTrace();
			vo.setStrMsgString("--> SupplierItemMstDAO.insertQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			supplierItemDAO = null;
		}

	}

	/**
	 * to check duplicate before insert record.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void chkDuplicate(SupplierItemMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";

		try {
			dao = new HisDAO("mms", "SupplierItemMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.SupplierItem.2");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrItemId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrItemBrandId());
			dao.setQryValue(nqryIndex, 4, vo.getStrSupplierId());

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
			vo.setStrMsgString("--> SupplierItemMstDAO.chkDuplicate()-->"
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
	 * @param vo
	 *            the vo
	 */
	public static void modifyQuery(SupplierItemMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet web = null;

		try {
			dao = new HisDAO("mms", "SupplierItemMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1, "select.SupplierItem.3");

			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrSupplierItemSlNo());
			dao.setQryValue(nqryIndex, 3, vo.getStrItemId());
			dao.setQryValue(nqryIndex, 4, vo.getStrSupplierId());
			dao.setQryValue(nqryIndex, 5, vo.getStrItemBrandId());
			dao.setQryValue(nqryIndex, 6, vo.getStrSlNo());

			web = dao.executeQry(nqryIndex);

			while (web.next()) {
				vo.setStrItemBrandId(web.getString(1));
				vo.setStrSupplierId(web.getString(2));
				vo.setStrItemId(web.getString(3));
				vo.setStrRemarks(web.getString(4));
				vo.setStrIsValid(web.getString(5));
				vo.setStrEffectiveFrom(web.getString(6));
				vo.setStrGroupName(web.getString(7));
				vo.setStrSubGroupName(web.getString(8));
				vo.setStrItemCategoryName(web.getString(9));			
				vo.setStrGroupId(web.getString(10));
				vo.setStrCategoryNo(web.getString(11));
				
				
			}

			strquery = mms.qryHandler_mms.getQuery(1, "select.BrandName.1");

			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrItemBrandId());
			/*
			 * dao.setQryValue(nqryIndex, 3, vo.getStrItemId());
			 * dao.setQryValue(nqryIndex, 4, vo.getStrCategoryNo());
			 */

			web = dao.executeQry(nqryIndex);

			while (web.next()) {
				vo.setStrItemBrandName(web.getString(1));
			}

			strquery = mms.qryHandler_mms.getQuery(1, "select.ItemName.1.0");

			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrItemId());
			// dao.setQryValue(nqryIndex, 3, vo.getStrCategoryNo());

			web = dao.executeQry(nqryIndex);

			while (web.next()) {
				vo.setStrItemName(web.getString(1));
			}

		} catch (Exception e) {
			vo.setStrMsgString("--> SupplierItemMstDAO.modifyQuery()-->"
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
	 * @param vo
	 *            the vo
	 */
	public static void updateQuery(SupplierItemMstVO vo) {

		HisDAO dao = null;
		SupplierItemDAO supplierItemDAO = null;

		try {

			dao = new HisDAO("mms", "SupplierItemMstDAO");
			supplierItemDAO = new SupplierItemDAO();

			supplierItemDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			supplierItemDAO.setStrHospitalCode(vo.getStrHospitalCode());
			supplierItemDAO.setStrIsValid(vo.getStrIsValid());
			supplierItemDAO.setStrRemarks(vo.getStrRemarks());
			supplierItemDAO.setStrSeatId(vo.getStrSeatId());
			supplierItemDAO.setStrItemBrandId(vo.getStrItemBrandId());
			supplierItemDAO.setStrItemId(vo.getStrItemId());
			supplierItemDAO.setStrSupplierId(vo.getStrSupplierId());
			supplierItemDAO.setStrItemCategoryNo(vo.getStrCategoryNo());
			
			supplierItemDAO.setStrGroupId(vo.getStrGroupId());
			
			
			
			/*
			 * supplierItemDAO.setStrDeliveryLeadTime(vo.getStrDeliveryLeadTime());
			 * supplierItemDAO.setStrDeliveryLeadTimeUnit(vo
			 * .getStrDeliveryLeadTimeUnit());
			 * supplierItemDAO.setStrRateUnitId(vo.getStrRateUnitId());
			 * supplierItemDAO.setStrItemRate(vo.getStrItemRate());
			 */
			supplierItemDAO.setStrSupplierItemSlNo(vo.getStrSupplierItemSlNo());			
			supplierItemDAO.setStrSlNo(vo.getStrSlNo());

			supplierItemDAO.update(dao);

			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {
			vo.setStrMsgString("--> SupplierItemMstDAO.updateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			supplierItemDAO = null;
		}

	}

	/**
	 * To get option value of Brand combo
	 * 
	 * @param vo
	 */
	/*
	 * public static void getBrandNameQuery(SupplierItemMstVO vo) {
	 * 
	 * HisDAO dao = null; int nqryIndex; WebRowSet wb = null; String strquery =
	 * ""; try { dao = new HisDAO("mms", "SupplierItemMstDAO");
	 * 
	 * if(vo.getStrCategoryNo().equals("1")){
	 * 
	 * strquery = mms.qryHandler_mms.getQuery(1, "select.BrandNameCombo.0");
	 * nqryIndex = dao.setQuery(strquery);
	 * 
	 * dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
	 * dao.setQryValue(nqryIndex, 2, vo.getStrItemId());
	 * 
	 * wb = dao.executeQry(nqryIndex); }else{
	 * 
	 * strquery = mms.qryHandler_mms.getQuery(1, "select.BrandNameCombo.1");
	 * nqryIndex = dao.setQuery(strquery);
	 * 
	 * dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
	 * dao.setQryValue(nqryIndex, 2, vo.getStrItemId());
	 * 
	 * wb = dao.executeQry(nqryIndex); }
	 * 
	 * 
	 * 
	 * vo.setStrItemBrandComboWs(wb); } catch (Exception e) {
	 * vo.setStrMsgString(" --> SupplierItemMstDAO.getBrandNameQuery()-->" +
	 * e.getMessage()); vo.setStrMsgType("1"); } finally { if (dao != null)
	 * dao.free(); dao = null; } }
	 *//**
		 * To get option value of Unit combo
		 * 
		 * @param vo
		 */
	/*
	 * public static void getUnitValues(SupplierItemMstVO vo) {
	 * 
	 * HisDAO dao = null; int nQueryIndex; WebRowSet web = null; String strQuery =
	 * ""; try { dao = new HisDAO("mms", "SupplierItemMstDAO");
	 * 
	 * 
	 * strQuery =mms.qryHandler_mms.getQuery(1,
	 * "select.SupplierItem.UnitNameCombo.0"); nQueryIndex =
	 * dao.setQuery(strQuery);
	 * 
	 * dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
	 * dao.setQryValue(nQueryIndex, 2, vo.getStrInventoryUnitId());
	 * dao.setQryValue(nQueryIndex, 3, vo.getStrInventoryUnitId()); web =
	 * dao.executeQry(nQueryIndex);
	 * 
	 * vo.setStrRateUnitComboWs(web); } catch (Exception e) {
	 * vo.setStrMsgString(" --> SupplierItemMstDAO.getUnitValues()-->" +
	 * e.getMessage()); vo.setStrMsgType("1"); } finally { if (dao != null)
	 * dao.free(); dao = null; } }
	 * 
	 *//**
		 * To get option value of SubGroup combo
		 * 
		 * @param vo
		 */
	/*
	 * public static void getSubGroupComboQuery(SupplierItemMstVO vo) {
	 * 
	 * HisDAO dao = null; int nqryIndex; WebRowSet wb = null; String strquery =
	 * ""; try { dao = new HisDAO("mms", "SupplierItemMstDAO"); strquery =
	 * mms.qryHandler_mms.getQuery(1, "select.StoreItem.6"); nqryIndex =
	 * dao.setQuery(strquery);
	 * 
	 * dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
	 * dao.setQryValue(nqryIndex, 2, vo.getStrGroupId());
	 * 
	 * wb = dao.executeQry(nqryIndex); vo.setStrSubGroupComboWs(wb); } catch
	 * (Exception e) { vo .setStrMsgString(" -->
	 * SupplierItemMstDAO.getSubGroupComboQuery()-->" + e.getMessage());
	 * vo.setStrMsgType("1"); } finally { if (dao != null) dao.free(); dao =
	 * null; } }
	 * 
	 *//**
		 * To get values of Item name Combo according to Group Id & Sub Group Id
		 * 
		 * @param vo
		 */
	/*
	 * public static void getItemNameComboQuery(SupplierItemMstVO vo) {
	 * 
	 * HisDAO dao = null; int nqryIndex; WebRowSet wb = null; String strquery =
	 * ""; String strTableName = ""; try { dao = new HisDAO("mms",
	 * "SupplierItemMstDAO");
	 * 
	 * //System.out.println("vo.getStrHospitalCode()" //+
	 * vo.getStrHospitalCode());
	 * 
	 * strquery = mms.qryHandler_mms.getQuery(1, "select.TableName.0")
	 * .replace("?", vo.getStrCategoryNo()); strquery = strquery.concat(" AND " +
	 * mms.qryHandler_mms.getQuery(1, "select.HospCode.cond.0") .replace("?",
	 * vo.getStrHospitalCode())); nqryIndex = dao.setQuery(strquery); wb =
	 * dao.executeQry(nqryIndex); while (wb.next()) { strTableName =
	 * wb.getString(1); } if(vo.getStrSubGroupId().equals("") ||
	 * vo.getStrSubGroupId()==null || vo.getStrSubGroupId().equals("0")){
	 * 
	 * strquery = mms.qryHandler_mms.getQuery(1, "select.SupplierItemName.0")
	 * .replace("?", strTableName); strquery = strquery.concat(" AND " +
	 * mms.qryHandler_mms.getQuery(1, "select.SupplierItemName.cond.1"));
	 * //.replace("?", vo.getStrHospitalCode()));
	 * 
	 * nqryIndex = dao.setQuery(strquery);
	 * 
	 * strquery = mms.qryHandler_mms.getQuery(1, "select.storeItemName.0");
	 * nqryIndex = dao.setQuery(strquery);
	 * 
	 * dao.setQryValue(nqryIndex, 1, strTableName); dao.setQryValue(nqryIndex,
	 * 1, vo.getStrHospitalCode()); dao.setQryValue(nqryIndex, 2,
	 * vo.getStrGroupId());
	 * 
	 * }else{
	 * 
	 * strquery = mms.qryHandler_mms.getQuery(1, "select.SupplierItemName.0")
	 * .replace("?", strTableName); strquery = strquery.concat(" AND " +
	 * mms.qryHandler_mms.getQuery(1, "select.SupplierItemName.cond.0"));
	 * //.replace("?", vo.getStrHospitalCode()));
	 * 
	 * nqryIndex = dao.setQuery(strquery);
	 * 
	 * strquery = mms.qryHandler_mms.getQuery(1, "select.storeItemName.0");
	 * nqryIndex = dao.setQuery(strquery);
	 * 
	 * dao.setQryValue(nqryIndex, 1, strTableName); dao.setQryValue(nqryIndex,
	 * 1, vo.getStrHospitalCode()); dao.setQryValue(nqryIndex, 2,
	 * vo.getStrGroupId()); dao.setQryValue(nqryIndex, 3,
	 * vo.getStrSubGroupId()); }
	 * 
	 * wb = dao.executeQry(nqryIndex); vo.setStrItemNameComboWs(wb); } catch
	 * (Exception e) { vo .setStrMsgString(" -->
	 * SupplierItemMstDAO.getItemNameComboQuery()-->" + e.getMessage());
	 * vo.setStrMsgType("1"); } finally { if (dao != null) dao.free(); dao =
	 * null; } }
	 */
}
