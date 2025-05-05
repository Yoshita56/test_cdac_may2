package mms.masters.dao;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.GenericItemDAO;
import mms.global.dao.ItemParameterDetailDAO;
import mms.masters.vo.GenericItemMstVO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Anshul Jindal Version : 1.0 Date : 31/Jan/2009-May/09
 * 
 * 
 * Developer : Balasubramaniam M 
 * Version : 1.1 
 * Modified Date : 13/Jan/2010
 * Desc : Generic Master Inventory Unit cannot be Modified.
 * 
 */

public class GenericItemMstDAO {

	/**
	 * This function is used to check duplicate name.
	 * 
	 * @param vo the vo
	 */
	public static void duplicacyAddQuery(GenericItemMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		int ncount = 0;
		try {

			dao = new HisDAO("MMS", "GenericItemMstDAO");
			strQuery = mms.qryHandler_mms
					.getQuery(1, "select.item.duplicate.1");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrItemName());
			dao.setQryValue(nQueryIndex, 2, vo.getStrCatNo());
			dao.setQryValue(nQueryIndex, 3, vo.getStrHospCode());
			web = dao.executeQry(nQueryIndex);
			if (web.next()) {
				ncount = Integer.parseInt(web.getString(1));

			}
			if (ncount == 0) {
				vo.setBExistStatus(true);
			} else {
				vo.setBExistStatus(false);
			}

		} catch (Exception e) {

			vo.setStrMsgString("GenericItemMstDAO.duplicacyAddQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			web = null;
		}
	}

	/**
	 * This function is used to insert the data into database.
	 * 
	 * @param vo the vo
	 */

	public static void insert(GenericItemMstVO vo) 
	{
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		GenericItemDAO itemDAO = null;
		// BrandItemDAO brandItem = null;
		String strItemId = "";
		// String strBrandItemId = "";
		try 
		{
			itemDAO = new GenericItemDAO();
			// brandItem = new BrandItemDAO();
			dao = new HisDAO("mms", "GenericItemMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.item.7");
			nQueryIndex = dao.setQuery(strQuery);
			// // System.out.println("item dao
			// vo.getStrCatNo()"+vo.getStrCatNo());
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrCatNo());
			web = dao.executeQry(nQueryIndex);

			if (web.next()) {
				strItemId = web.getString(1);
			}
			itemDAO.setStrItemId(strItemId);
			// itemDAO.setStrApprovedType(vo.getStrApprovedBy());
			
			//Removed From The Front End So Default Value would be 0
			//itemDAO.setStrBatchNoReq(vo.getStrBatchNo());
			itemDAO.setStrBatchNoReq("0");
			
			itemDAO.setStrConsumableFlag(vo.getStrConsumableType());
			// itemDAO.setStrDefaultRate(vo.getStrDefaultRate());
			itemDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			
			//Removed From The Front End So Default Value Will Be 0
			//itemDAO.setStrExpiryDateReq(vo.getStrExpiryDate());
			itemDAO.setStrExpiryDateReq("0");
			
			
			itemDAO.setStrGroupId(vo.getStrGroupId());
			itemDAO.setStrHospitalCode(vo.getStrHospCode());
			itemDAO.setStrInventoryUnitId(vo.getStrStockMaintain());
			// itemDAO.setStrIssueType(vo.getStrIssueType());
			itemDAO.setStrIsValid("1");

			itemDAO.setStrItemCatNO(vo.getStrCatNo());
			itemDAO.setStrItemName(vo.getStrItemName());
			// itemDAO.setStrItemTypeId(vo.getStrItemType());
			itemDAO.setStrPurchasedLeadTime(vo.getStrPurchaseLeadTime().equalsIgnoreCase("")?"0":vo.getStrPurchaseLeadTime());
			itemDAO.setStrPurLeadTimeUnit(vo.getStrTimeFormat());
			// itemDAO.setStrRateUnitId(vo.getStrUnit());
			itemDAO.setStrRemarks(vo.getStrRemarks());
			itemDAO.setStrSeatId(vo.getStrSeatId());
			// itemDAO.setStrSetSachetFlag(vo.getStrIsItemSachet());
			itemDAO.setStrShelfLife(vo.getStrShelfLife().equalsIgnoreCase("")?"0":vo.getStrShelfLife());
			itemDAO.setStrShelfLifeUnit(vo.getStrShelfTimeFormat());
			itemDAO.setStrSubGroupId(vo.getStrSubGroupId());
			itemDAO.setStrParam(vo.getStrParam());
			// itemDAO.setStrItemComposit(vo.getStrItemComposit());
			itemDAO.setStrSerialNo(vo.getStrSerialNo());
		//	itemDAO.setStrSparePart(vo.getStrSparePart());
		 
			itemDAO.setStrAssetsReq(vo.getStrAssetsReq());
			itemDAO.setStrDepreciationcost(vo.getStrDepreciationcost());
			
			//Removed Form The Front End So Default Value would Be 0
			//itemDAO.setStrItemCode(vo.getStrCPACode());
			itemDAO.setStrItemCode("0");
			
			// itemDAO.setStrStockUpdate(vo.getStrStockUpdate());
			itemDAO.insert(dao);

			/*
			 * if (vo.getStrBrandedApprovedBy() != null) { for (int i = 0; i <
			 * vo.getStrBrandedApprovedBy().length; i++) { brandItem
			 * .setStrApprovedType(vo.getStrBrandedApprovedBy()[i]);
			 * brandItem.setStrDefaultRate(vo.getStrBrandedRate()[i]);
			 * brandItem.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			 * brandItem.setStrHospitalCode(vo.getStrHospCode());
			 * brandItem.setStrIsValid("1");
			 * brandItem.setStrItemBrandId(strBrandItemId);
			 * brandItem.setStrItemBrandSlNo(vo.getStrCatNo());
			 * brandItem.setStrItemCatNO(vo.getStrCatNo());
			 * brandItem.setStrItemId(strItemId);
			 * brandItem.setStrItemMake(vo.getStrBrandedItemMaker()[i]);
			 * brandItem.setStrItemName(vo.getStrBrandName()[i]); //
			 * brandItem.setStrItemStatus(vo.getStrBrandedItemStatus()[i]);
			 * brandItem.setStrRateUnitId(vo.getStrBrandedUnit()[i]);
			 * brandItem.setStrManuFacturerId(vo
			 * .getStrBrandedManufacturer()[i]);
			 * brandItem.setStrRemarks(vo.getStrRemarks());
			 * brandItem.setStrSeatId(vo.getStrSeatId());
			 * brandItem.setStrIssuseType(vo.getStrBrandedIssueType()[i]);
			 * brandItem.insert(dao); } }
			 */
			int nLen = 0;
			if (vo.getStrParamCheck() != null)
				nLen = vo.getStrParamCheck().length;

			for (int i = 0; i < nLen; i++) {
				String[] chkVal = vo.getStrParamCheck()[i].replace("^", "#")
						.split("#");
				ItemParameterDetailDAO itemParamDao = new ItemParameterDetailDAO();
				itemParamDao.setStrHospitalCode(vo.getStrHospCode());
				itemParamDao.setStrParentParamId(chkVal[0]);
				itemParamDao.setStrParamId(chkVal[1]);
				itemParamDao.setStrItemId(strItemId);
				itemParamDao.setStrParamValue(vo.getStrParamValue()[i]);
				itemParamDao.setStrSeatId(vo.getStrSeatId());
				// itemParamDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
				// itemParamDao.insert(dao);
				itemParamDao.insertItemParameterDtls(dao);
			}
			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("GenericItemMstDAO.insert() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			web = null;
		}
	}

	/**
	 * This function is used set initial parameters for modify page.
	 * 
	 * @param vo the vo
	 */
	public static void modify(GenericItemMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {

			dao = new HisDAO("mms", "GenericItemMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.item.9");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, vo.getStrItemId());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 3, vo.getStrSerialNo());
			web = dao.executeQry(nQueryIndex);
			if (web.next()) 
			{
				vo.setStrItemName(web.getString(1));
				vo.setStrBatchNo(web.getString(2));
				vo.setStrExpiryDate(web.getString(3));
				vo.setStrShelfLife(web.getString(4));
				vo.setStrShelfTimeFormat(web.getString(5));
				vo.setStrStockMaintainedCode(web.getString(6));
				vo.setStrPurchaseLeadTime(web.getString(7));
				vo.setStrTimeFormat(web.getString(8));
				vo.setStrConsumableType(web.getString(9));
				vo.setStrRemarks(web.getString(10));
				vo.setStrEffectiveFrom(web.getString(11));
				vo.setStrIsValid(web.getString(12));
				vo.setStrSerialNo(web.getString(13));
				vo.setStrParam(web.getString(14));
				vo.setStrCatNo(web.getString(15));
				vo.setStrSubGroupNameValue(web.getString(16));
				vo.setStrGroupNameValue(web.getString(17));
				vo.setStrAssetsReq(web.getString(18));
				vo.setStrDepreciationcost(web.getString(19));
				vo.setStrInventoryUnitName(web.getString(20));
				vo.setStrCPACode(web.getString(21));				 
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("GenericItemMstDAO.modify() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			web = null;
		}
	}

	/**
	 * This function is used to check duplicate name for update.
	 * 
	 * @param vo the vo
	 */
	public static void duplicacyUpdateQuery(GenericItemMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		int ncount = 0;
		try {

			dao = new HisDAO("MMS", "GenericItemMstDAO");
			strQuery = mms.qryHandler_mms
					.getQuery(1, "select.item.duplicate.2");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrItemName());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 3, vo.getStrItemId());
			dao.setQryValue(nQueryIndex, 4, vo.getStrCatNo());
			web = dao.executeQry(nQueryIndex);
			if (web.next()) {
				ncount = Integer.parseInt(web.getString(1));

			}
			if (ncount == 0) {
				vo.setBExistStatus(true);
			} else {
				vo.setBExistStatus(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("GenericItemMstDAO.duplicacyUpdateQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			web = null;
		}
	}

	/**
	 * This function is used to update record during click of modify.
	 * 
	 * @param vo the vo
	 */
	public static void update(GenericItemMstVO vo) {
		HisDAO dao = null;
		GenericItemDAO itemDAO = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		String strItemId="";

		try
		{
			    dao = new HisDAO("mms", "GenericItemMstDAO");
			itemDAO = new GenericItemDAO();	
			 
			itemDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			itemDAO.setStrRemarks(vo.getStrRemarks());
			itemDAO.setStrSeatId(vo.getStrSeatId());			
			itemDAO.setStrItemId(vo.getStrItemId());
			itemDAO.setStrSerialNo(vo.getStrSerialNo());
			itemDAO.setStrHospitalCode(vo.getStrHospCode());
			itemDAO.update1(dao);
			
			
			itemDAO.setStrItemId(vo.getStrItemId());
			
			//Removed from the front end so default value will be 0
			//itemDAO.setStrBatchNoReq(vo.getStrBatchNo());
			itemDAO.setStrBatchNoReq("0");
			
			
			itemDAO.setStrConsumableFlag(vo.getStrConsumableType());
			itemDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			
			//Removed from the front end so default value will be 0
			//itemDAO.setStrExpiryDateReq(vo.getStrExpiryDate());
			itemDAO.setStrExpiryDateReq("0");
			
			itemDAO.setStrGroupId(vo.getStrGroupId());
			itemDAO.setStrHospitalCode(vo.getStrHospCode());
			itemDAO.setStrInventoryUnitId(vo.getStrStockMaintainedCode());
			itemDAO.setStrIsValid("1");
			itemDAO.setStrItemCatNO(vo.getStrCatNo());
			itemDAO.setStrItemName(vo.getStrItemName());
			itemDAO.setStrPurchasedLeadTime(vo.getStrPurchaseLeadTime().equalsIgnoreCase("")?"0":vo.getStrPurchaseLeadTime());
			itemDAO.setStrPurLeadTimeUnit(vo.getStrTimeFormat());
			itemDAO.setStrRemarks(vo.getStrRemarks());
			itemDAO.setStrSeatId(vo.getStrSeatId());
			itemDAO.setStrShelfLife(vo.getStrShelfLife().equalsIgnoreCase("")?"0":vo.getStrShelfLife());
			itemDAO.setStrShelfLifeUnit(vo.getStrShelfTimeFormat());
			itemDAO.setStrSubGroupId(vo.getStrSubGroupId());
			itemDAO.setStrParam(vo.getStrParam());
			itemDAO.setStrSerialNo(vo.getStrSerialNo());
			itemDAO.setStrAssetsReq(vo.getStrAssetsReq());
			itemDAO.setStrDepreciationcost(vo.getStrDepreciationcost());
			
			//Removed from the front end so default value will be 0
			//itemDAO.setStrItemCode(vo.getStrCPACode());
			itemDAO.setStrItemCode("0");
			
			itemDAO.setStrSerialNo(vo.getStrSerialNo());
			itemDAO.insert1(dao);
			
			
			int nParamCount = 0;
			int nLen1 = 0;
			if (vo.getStrParamDtls() != null)
				nLen1 = vo.getStrParamDtls().length;

			for (int i = 0; i < nLen1; i++) 
			{

				String[] chkVal = vo.getStrParamDtls()[i].replace("^", "#")
						.split("#");

				ItemParameterDetailDAO itemParamDao = new ItemParameterDetailDAO();

				itemParamDao.setStrHospitalCode(vo.getStrHospCode());
				itemParamDao.setStrParamId(chkVal[0]);
				itemParamDao.setStrParamSlNo(chkVal[1]);
				itemParamDao.setStrItemId(vo.getStrItemId());

				itemParamDao.setStrSeatId(vo.getStrSeatId());

				if (vo.getStrParamStatus()[i].equals("1")) 
				{
					itemParamDao.setStrParamValue(vo.getStrParamValue()[nParamCount]);
					itemParamDao.updateItemParameterDtls(dao);
					nParamCount = nParamCount + 1;
				} else if (vo.getStrParamStatus()[i].equals("2")) 
				{
					itemParamDao.deleteItemParameterDtls(dao);					
				}

			}
			int nLen = 0;
			// if (vo.getStrParamDtls() != null)
			if (vo.getStrParamCheck() != null)
				nLen = vo.getStrParamCheck().length;

			for (int i = 0; i < nLen; i++) {

				String[] chkVal = vo.getStrParamCheck()[i].replace("^", "#")
						.split("#");

				ItemParameterDetailDAO itemParamDao = new ItemParameterDetailDAO();

				itemParamDao.setStrHospitalCode(vo.getStrHospCode());
				itemParamDao.setStrParentParamId(chkVal[0]);
				itemParamDao.setStrParamId(chkVal[1]);
				itemParamDao.setStrItemId(vo.getStrItemId());
				itemParamDao.setStrParamValue(vo.getStrParamValue()[nParamCount
						+ i]);
				itemParamDao.setStrSeatId(vo.getStrSeatId());
				// /itemParamDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());

				itemParamDao.insertItemParameterDtls(dao);

				// itemParamDao.insert(dao);

			}

			if (vo.getStrParam() == null || vo.getStrParam().equals("0")) 
			{
				 strQuery = mms.qryHandler_mms.getQuery(1,"delete.item.parameter.1");
				 nQueryIndex = dao.setQuery(strQuery);

				dao.setQryValue(nQueryIndex, 1, vo.getStrItemId());
				dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
				dao.execute(nQueryIndex, 0);
			}
			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("GenericItemMstDAO.update() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
		}
	}

	/*
	 * This function check whether data of same name is already exist for same
	 * supplier type id
	 * 
	 */
	/**
	 * Check duplicay add.
	 * 
	 * @param vo the vo
	 */
	public static void CheckDuplicayAdd(GenericItemMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		Boolean chkFlag = false;
		try {

			dao = new HisDAO("mms", "GenericItemMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.item.12");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrItemName());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
			web = dao.executeQry(nQueryIndex);
			if (web.next()) {
				if (Integer.parseInt(web.getString(1)) >= 1)
					chkFlag = false;
				else
					chkFlag = true;
			}
			vo.setIsFlag(chkFlag);
		} catch (Exception e) {
			vo.setStrMsgString("GenericItemMstDAO.CheckDuplicayAdd() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			web = null;
		}

	}

	
	/**
	 * Gets the stock maintained values.
	 * 
	 * @param vo the vo
	 * 
	 * @return the stock maintained values
	 */
	public static void getStockMaintainedValues(GenericItemMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("mms", "GenericItemMstDAO");

			if (vo.getStrConsumableType().equals("0")) 
			{
				strQuery = mms.qryHandler_mms.getQuery(1,"select.item.inventoryunit.0");

			} else {
				strQuery = mms.qryHandler_mms.getQuery(1,"select.item.5");

			}			
			
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1,Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nQueryIndex, 2, vo.getStrModuleId());
			web = dao.executeQry(nQueryIndex);
			vo.setStockMaintainedWS(web);

		} catch (Exception e) {
			e.printStackTrace();
			vo
					.setStrMsgString("GenericItemMstDAO.getStockMaintainedValues() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			web = null;
		}
	}

	
	/**
	 * Gets the Flag Item Code Required 
	 * 
	 * @param vo the vo
	 * 
	 * @return the Flag Item Code Required 
	 */
	public static void getItemCodeRequired(GenericItemMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("MMS", "GenericDrugMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.itemCatDtls.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrCatNo());
			
			web = dao.executeQry(nQueryIndex);
			
			if(web != null && web.next()){
				
				vo.setStrIsItemCodeRequired(web.getString(1));
				
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
			vo
					.setStrMsgString("GenericItemMstDAO.getItemCodeRequired() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			web = null;
		}
	}

	
	/*
	 * public static void getItemValues(GenericItemMstVO vo) { HisDAO dao =
	 * null; String strQuery = ""; int nQueryIndex = 0; WebRowSet web = null;
	 * try { //// System.out.println("vo.getStrCatNo()"+vo.getStrCatNo()); dao =
	 * new HisDAO("mms", "GenericItemMstDAO"); strQuery =
	 * mms.qryHandler_mms.getQuery(1, "select.item.6"); nQueryIndex =
	 * dao.setQuery(strQuery); dao.setQryValue(nQueryIndex, 1,
	 * vo.getStrHospCode()); dao.setQryValue(nQueryIndex, 2, vo.getStrCatNo());
	 * 
	 * web = dao.executeQry(nQueryIndex);
	 * 
	 * vo.setItemTypeWS(web);
	 *  } catch (Exception e) { e.printStackTrace();
	 * vo.setStrMsgString("GenericItemMstDAO.getItemValues() --> " +
	 * e.getMessage()); vo.setStrMsgType("1"); } finally { dao = null; web =
	 * null; } }
	 * 
	 * public static void getBrandItemDtl(GenericItemMstVO vo) { HisDAO dao =
	 * null; String strQuery = ""; int nQueryIndex = 0; WebRowSet web = null;
	 * try {
	 * 
	 * dao = new HisDAO("mms", "GenericItemMstDAO"); strQuery =
	 * mms.qryHandler_mms.getQuery(1, "select.item.8"); nQueryIndex =
	 * dao.setQuery(strQuery);
	 * 
	 * dao.setQryValue(nQueryIndex, 1, vo.getStrItemId());
	 * dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode()); web =
	 * dao.executeQry(nQueryIndex); vo.setBrandItemDtlWS(web);
	 *  } catch (Exception e) { e.printStackTrace();
	 * vo.setStrMsgString("GenericItemMstDAO.getBrandItemDtl() --> " +
	 * e.getMessage()); vo.setStrMsgType("1"); } finally { dao = null; web =
	 * null; } }
	 */
	/*
	 * // get Slno during modify case of brand Item Master public static void
	 * getSlNoBrandMst(GenericItemMstVO vo) { HisDAO dao = null; String strQuery =
	 * ""; int nQueryIndex = 0; WebRowSet web = null; try { dao = new
	 * HisDAO("mms", "GenericItemMstDAO"); strQuery =
	 * mms.qryHandler_mms.getQuery(1, "select.brandItem.0"); nQueryIndex =
	 * dao.setQuery(strQuery); dao.setQryValue(nQueryIndex, 1,
	 * vo.getStrHospCode()); dao.setQryValue(nQueryIndex, 2, vo.getStrItemId());
	 * dao.setQryValue(nQueryIndex, 3, vo.getStrBrandId()); web =
	 * dao.executeQry(nQueryIndex); if (web.next()) {
	 * vo.setStrBrandItemSlNo(web.getString(1)); } } catch (Exception e) {
	 * e.printStackTrace();
	 * vo.setStrMsgString("GenericItemMstDAO.getSlNoBrandMst() --> " +
	 * e.getMessage()); vo.setStrMsgType("1"); } }
	 * 
	 * public static void insertModifyBrandItem(GenericItemMstVO vo,
	 * BrandItemDAO dao, HisDAO dao1) { try { getSlNoBrandMst(vo);
	 * dao.setStrApprovedType(vo.getStrApprovedBy());
	 * dao.setStrDefaultRate(vo.getStrDefaultRate());
	 * dao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
	 * dao.setStrHospitalCode(vo.getStrHospCode()); dao.setStrIsValid("1");
	 * dao.setStrItemBrandId(vo.getStrBrandId());
	 * dao.setStrItemBrandSlNo(vo.getStrBrandItemSlNo());
	 * dao.setStrItemCatNO("1"); dao.setStrItemId(vo.getStrItemId());
	 * dao.setStrItemMake(vo.getStrItemMaker());
	 * dao.setStrItemName(vo.getStrItemName()); //
	 * dao.setStrItemStatus(vo.getStrItemstatus());
	 * dao.setStrRateUnitId(vo.getStrUnit());
	 * dao.setStrManuFacturerId(vo.getStrManufacturer());
	 * dao.setStrRemarks(vo.getStrRemarks());
	 * dao.setStrSeatId(vo.getStrSeatId());
	 * dao.setStrIssuseType(vo.getStrIssueType()); dao.modifyInsert(dao1); }
	 * catch (Exception e) { e.printStackTrace();
	 * vo.setStrMsgString("GenericItemMstDAO.insertModifyBrandItem() --> " +
	 * e.getMessage()); vo.setStrMsgType("1"); } }
	 */

	/**
	 * View.
	 * 
	 * @param vo the vo
	 */
	public static void view(GenericItemMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {

			dao = new HisDAO("mms", "GenericItemMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.item.11");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrItemId());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 3, vo.getStrSerialNo());
			web = dao.executeQry(nQueryIndex);
			if (web.next()) {
				vo.setStrItemName(web.getString(1));
				vo.setStrSubGroupNameValue(web.getString(3));
				vo.setStrGroupNameValue(web.getString(2));
				vo.setStrCatValues(web.getString(4));
				vo.setStrBatchNo(web.getString(5));
				vo.setStrExpiryDate(web.getString(6));
				vo.setStrSerialNo(web.getString(7));
				vo.setStrShelfLife(web.getString(8));
				vo.setStrShelfTimeFormat(web.getString(9));
				vo.setStrStockMaintain(web.getString(10));
				vo.setStrPurchaseLeadTime(web.getString(11));
				vo.setStrTimeFormat(web.getString(12));
				vo.setStrConsumableType(web.getString(13));
				vo.setStrParam(web.getString(14));
				vo.setStrRemarks(web.getString(15));
				vo.setStrEffectiveFrom(web.getString(16));
				vo.setStrIsValid(web.getString(17));
				vo.setStrConsumableFlag(web.getString(18));
				vo.setStrAssetsReq(web.getString(19));
				vo.setStrDepreciationcost(web.getString(20));
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo
					.setStrMsgString("GenericItemMstDAO.view() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			web = null;
		}
	}
}
