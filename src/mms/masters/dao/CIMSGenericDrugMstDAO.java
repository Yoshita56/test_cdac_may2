package mms.masters.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;
import mms.MmsConfigUtil;
import mms.dao.BrandItemDAO;
import mms.dao.GenericDrugDAO;
import mms.masters.vo.CIMSGenericDrugMstVO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Anshul Jindal Version : 1.0 Date : 31/Jan/2009-May/09
 */

public class CIMSGenericDrugMstDAO {

	/**
	 * This function is used to check duplicate name.
	 * 
	 * @param vo the vo
	 */
	public static void duplicacyAddQuery(CIMSGenericDrugMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		int ncount = 0;
		try {

			dao = new HisDAO("MMS", "GenericDrugMstDAO");
			strQuery = mms.qryHandler_mms
					.getQuery(1, "select.drug.duplicate.1");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrDrugName().trim());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
			web = dao.executeQry(nQueryIndex);
			// //System.out.println(dao.getQryResult(strQuery));
			if (web.next()) {

				ncount = Integer.parseInt(web.getString(1));
			}
			if (ncount == 0) {
				vo.setBExistStatus(true);
			} else {
				vo.setBExistStatus(false);
			}

		} catch (Exception e) {

			vo.setStrMsgString("GenericDrugMstDAO.modify() --> "
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
	public static void insert(CIMSGenericDrugMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		
		String strQuery1 = "";
		int nQueryIndex1 = 0;
		WebRowSet web1 = null;
		
		GenericDrugDAO drugDAO = null;
		// BrandItemDAO brandItem = null;

		String strDrugId = "";
		String strTariffId = "";
		//System.out.println("hospital code is "+vo.getStrHospitalCode());
		MmsConfigUtil mmsConfigUtil=new MmsConfigUtil(vo.getStrHospitalCode());
		// String strBrandItemId = "";
		try 
		{
			drugDAO = new GenericDrugDAO();
			// brandItem = new BrandItemDAO();

			dao = new HisDAO("MMS", "CIMSGenericDrugMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.drug.7");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 2, "10"); // /ITEM CATEGORY FOR DRUGS
			web = dao.executeQry(nQueryIndex);
			if (web.next()) {
				strDrugId = web.getString(1);
			}
			
			strQuery1 = mms.qryHandler_mms.getQuery(1, "select.drug.tariff");
			nQueryIndex1 = dao.setQuery(strQuery1);
			web1 = dao.executeQry(nQueryIndex1);
			if (web1.next()) {
				strTariffId = web1.getString(1);
			}
			////System.out.println("Tariff ID:::   "+strTariffId);
			drugDAO.setStrItemId(strDrugId);
			drugDAO.setStrTariffId(strTariffId);
			// drugDAO.setStrApprovedType(vo.getStrApprovedBy()); //change on 13
			// may09 after changes in table
			

			//Removed From Front End So Default Value will be 0
			//drugDAO.setStrBatchNoReq(vo.getStrBatchNo());
			drugDAO.setStrBatchNoReq("0");
			
			
			drugDAO.setStrConsumableFlag(vo.getStrConsumableType());
			// drugDAO.setStrDefaultRate(vo.getStrDefaultRate()); //change on 13
			// may09 after changes in table
			drugDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			
			//Removed From Front End So Default Value will be 0
			//drugDAO.setStrExpiryDateReq(vo.getStrExpiryDate());
			drugDAO.setStrExpiryDateReq("0");
			
			drugDAO.setStrGroupId(vo.getStrGroupId());
			drugDAO.setStrHospitalCode(vo.getStrHospCode());
			drugDAO.setStrInventoryUnitId(vo.getStrStockMaintain());
			drugDAO.setStrIsNarcotic(vo.getStrIsItemNarcotic());
			// drugDAO.setStrIssueType(vo.getStrIssueType()); //change on 13
			// may09 after changes in table
			drugDAO.setStrIsValid("1");
			drugDAO.setStrItemCatNO("10");
			drugDAO.setStrItemName(vo.getStrDrugName());
			// drugDAO.setStrItemTypeId(vo.getStrItemType());
			drugDAO.setStrPurchasedLeadTime(vo.getStrPurchaseLeadTime().equalsIgnoreCase("")?"0":vo.getStrPurchaseLeadTime());
			drugDAO.setStrPurLeadTimeUnit(vo.getStrTimeFormat());
			// drugDAO.setStrRateUnitId(vo.getStrUnit()); //change on 13 may09
			// after changes in table
			drugDAO.setStrRemarks(vo.getStrRemarks());
			drugDAO.setStrSeatId(vo.getStrSeatId());
			// drugDAO.setStrSetSachetFlag(vo.getStrIsItemSachet()); //change on
			// 13 may09 after changes in table
			drugDAO.setStrShelfLife(vo.getStrShelfLife().equalsIgnoreCase("")?"0":vo.getStrShelfLife());
			drugDAO.setStrShelfLifeUnit(vo.getStrShelfTimeFormat());
			drugDAO.setStrSubGroupId(vo.getStrSubGroupId());
			// drugDAO.setStrStockUpdate(vo.getStrStockUpdate()); //change on 13
			// may09 after changes in table
			drugDAO.setStrConsentReq(vo.getStrConsentReq());
			
			//Removed From Front End So Default Value will be 0
			//drugDAO.setStrCPACode(vo.getStrCPACode());
			drugDAO.setStrCPACode(vo.getStrCPACode());
			
			
			/*Aritra*/
			drugDAO.setStrPregnancySafeFlag(vo.getStrPregnancySafeFlag());
			drugDAO.setStrTrimester(vo.getStrTrimester());
			drugDAO.setStrEffectsOnFoetus(vo.getStrEffectsOnFoetus());
			
			drugDAO.insert(dao);
			
			//System.out.println("billing integration is "+mmsConfigUtil.getStrBillingIntegration());
			if(mmsConfigUtil.getStrBillingIntegration().equals("1"))
			drugDAO.insert2(dao);

			// change on 13 may09 after changes in table

			// //System.out.println("vo.getStrBrandedApprovedBy().length-"+
			// vo.getStrBrandedApprovedBy().length);
			/*
			 * if( vo.getStrBrandedApprovedBy()!=null) { for (int i = 0; i <
			 * vo.getStrBrandedApprovedBy().length; i++) {
			 * brandItem.setStrApprovedType(vo.getStrBrandedApprovedBy()[i]);
			 * brandItem.setStrDefaultRate(vo.getStrBrandedRate()[i]);
			 * brandItem.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			 * brandItem.setStrHospitalCode(vo.getStrHospCode());
			 * brandItem.setStrIsValid("1");
			 * brandItem.setStrItemBrandId(strBrandItemId);
			 * brandItem.setStrItemBrandSlNo("1");
			 * brandItem.setStrItemCatNO(drugDAO.getStrItemCatNO());
			 * brandItem.setStrItemId(strDrugId);
			 * brandItem.setStrItemMake(vo.getStrBrandedItemMaker()[i]);
			 * brandItem.setStrItemName(vo.getStrBrandName()[i]); //
			 * brandItem.setStrItemStatus(vo.getStrBrandedItemStatus()[i]);
			 * brandItem.setStrRateUnitId(vo.getStrBrandedUnit()[i]); brandItem
			 * .setStrManuFacturerId(vo.getStrBrandedManufacturer()[i]);
			 * brandItem.setStrRemarks(vo.getStrRemarks());
			 * brandItem.setStrSeatId(vo.getStrSeatId());
			 * brandItem.setStrIssuseType(vo.getStrBrandedIssueType()[i]);
			 * brandItem.insert(dao); } }
			 */
			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("GenericDrugMstDAO.insert() --> "
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
	public static void modify(CIMSGenericDrugMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		String strQuery1= "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {

			dao = new HisDAO("MMS", "GenericDrugMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.cims.modify");
		
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrItemId());
			dao.setQryValue(nQueryIndex, 2, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nQueryIndex, 3, vo.getStrSerialNo());
			web = dao.executeQry(nQueryIndex);
			if (web.next()) 
			{
				vo.setStrDrugName(web.getString(1));
				vo.setStrBatchNo(web.getString(2));
				vo.setStrExpiryDate(web.getString(3));
				vo.setStrShelfLife(web.getString(4));
				vo.setStrShelfTimeFormat(web.getString(5));
				vo.setStrStockMaintainedCode(web.getString(6));
				
				vo.setStrConsumableType(web.getString(7));
				vo.setStrIsItemNarcotic(web.getString(8));
				
				vo.setStrIsValid(web.getString(9));
				vo.setStrConsentReq(web.getString(10));
				vo.setStrSubGroupNameValue(web.getString(11));
				vo.setStrGroupNameValue(web.getString(12));
			
				vo.setStrInventoryUnitName(web.getString(13));
				vo.setStrIsItemCodeRequired(web.getString(14));
				vo.setStrCPACode(web.getString(15));
				vo.setStrPregnancySafeFlag(web.getString(16));
				vo.setStrContraindictioncode(web.getString(17));
				vo.setStrDrugAdmincode(web.getString(18));
				vo.setStrStoragecode(web.getString(19));
				vo.setStrdosageadult(web.getString(20));
				vo.setStrsprecau(web.getString(21));
				vo.setStradvdrug(web.getString(22));
				vo.setStrmechact(web.getString(23));
				vo.setStrlabintfrnce(web.getString(24));
				vo.setStrAdminRoute(web.getString(25));
				vo.setStrdosagepeads(web.getString(26));
			}
			strQuery1 = mms.qryHandler_mms.getQuery(1, "select.drug.contradiction");
			nQueryIndex = dao.setQuery(strQuery1);
			dao.setQryValue(nQueryIndex, 1, vo.getStrItemId());
			dao.setQryValue(nQueryIndex, 2, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nQueryIndex, 3, vo.getStrSerialNo());
			web = dao.executeQry(nQueryIndex);
			if (web.next()) 
			{
				vo.setStrDrugval(web.getString(1));
				vo.setStrDrugIdval(web.getString(2));
			}
		} catch (Exception e) {

			vo.setStrMsgString("GenericDrugMstDAO.modify() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			web = null;
		}
	}

	/**
	 * This function is used to check duplicate name FOR UPDATE.
	 * 
	 * @param vo the vo
	 */
	public static void dupliUpdateQuery(CIMSGenericDrugMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		int ncount = 0;
		try {

			dao = new HisDAO("MMS", "GenericDrugMstDAO");
			strQuery = mms.qryHandler_mms
					.getQuery(1, "select.drug.duplicate.2");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrDrugName());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 3, vo.getStrItemId());
			web = dao.executeQry(nQueryIndex);
			if (web.next()) {
				ncount = Integer.parseInt(web.getString(1));

			}
			if (ncount < 1) {
				vo.setBExistStatus(true);
			} else {
				vo.setBExistStatus(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("GenericDrugMstDAO.modify() --> "
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
	public static void update1(CIMSGenericDrugMstVO vo) 
	{
		HisDAO dao = null;
		GenericDrugDAO drugDAO = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		String strDrugId="";
		try 
		{
			    dao = new HisDAO("MMS", "GenericDrugMstDAO");			
			drugDAO = new GenericDrugDAO();			
			
			drugDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			drugDAO.setStrRemarks(vo.getStrRemarks());			
			drugDAO.setStrIsValid("2");			
			drugDAO.setStrSeatId(vo.getStrSeatId());		
			drugDAO.setStrHospitalCode(vo.getStrHospCode());
			drugDAO.setStrItemId(vo.getStrItemId());
			drugDAO.setStrSerialNo(vo.getStrSerialNo());
			drugDAO.update1(dao);
			drugDAO.update2(dao);
			/**************************************************************************/			
			
			
			//Removed from the front end so default will be 0
            //drugDAO.setStrBatchNoReq(vo.getStrBatchNo());
			drugDAO.setStrBatchNoReq("0");
			
			drugDAO.setStrConsumableFlag(vo.getStrConsumableType());
			drugDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			
			//Removed from the front end so default will be 0
			//drugDAO.setStrExpiryDateReq(vo.getStrExpiryDate());
			drugDAO.setStrExpiryDateReq(vo.getStrExpiryDate());
			
			drugDAO.setStrGroupId(vo.getStrGroupId());
			drugDAO.setStrHospitalCode(vo.getStrHospCode());
			drugDAO.setStrInventoryUnitId(vo.getStrStockMaintainedCode());
			drugDAO.setStrIsNarcotic(vo.getStrIsItemNarcotic());
			drugDAO.setStrIsValid("1");
			drugDAO.setStrItemCatNO("10");
			drugDAO.setStrItemName(vo.getStrDrugName());
			drugDAO.setStrPurchasedLeadTime(vo.getStrPurchaseLeadTime());
			drugDAO.setStrPurLeadTimeUnit(vo.getStrTimeFormat());
			drugDAO.setStrRemarks(vo.getStrRemarks());
			drugDAO.setStrSeatId(vo.getStrSeatId());
			drugDAO.setStrShelfLife(vo.getStrShelfLife().equalsIgnoreCase("")?"0":vo.getStrShelfLife());
			drugDAO.setStrShelfLifeUnit(vo.getStrShelfTimeFormat());
			drugDAO.setStrSubGroupId(vo.getStrSubGroupId());
			drugDAO.setStrConsentReq(vo.getStrConsentReq());
			
			//Removed from the front end so default will be 0
			//drugDAO.setStrCPACode(vo.getStrCPACode());		
			drugDAO.setStrCPACode("0");			
			
			drugDAO.setStrPregnancySafeFlag(vo.getStrPregnancySafeFlag());
			drugDAO.setStrTrimester(vo.getStrTrimester());
			drugDAO.setStrEffectsOnFoetus(vo.getStrEffectsOnFoetus());
			
			drugDAO.insert1(dao);
			drugDAO.insert3(dao);
			
			
			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("GenericDrugMstDAO.update() --> "
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
	public static void CheckDuplicayAdd(CIMSGenericDrugMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		Boolean chkFlag = false;
		try {

			dao = new HisDAO("MMS", "GenericDrugMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.drug.12");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrDrugName());
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
			vo.setStrMsgString("GenericDrugMstDAO.CheckDuplicayAdd() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			web = null;
		}

	}

	/*
	 * public static void getUnitValues(CIMSGenericDrugMstVO vo) { HisDAO dao =
	 * null; String strQuery = ""; int nQueryIndex = 0; WebRowSet web = null;
	 * try { dao = new HisDAO("MMS", "GenericDrugMstDAO");
	 * ////System.out.println(" DAO vo.getStrModuleId()"+ vo.getStrModuleId());
	 * strQuery = mms.qryHandler_mms.getQuery(1, "select.drug.3"); nQueryIndex =
	 * dao.setQuery(strQuery); dao.setQryValue(nQueryIndex, 1,
	 * vo.getStrHospCode()); dao.setQryValue(nQueryIndex, 2,
	 * vo.getStrModuleId()); web = dao.executeQry(nQueryIndex); if (web.next()) {
	 * vo.setUnitWS(web); } } catch (Exception e) { e.printStackTrace();
	 * vo.setStrMsgString("GenericDrugMstDAO.getUnitValues() --> " +
	 * e.getMessage()); vo.setStrMsgType("1"); } finally { dao = null; web =
	 * null; } }
	 */
	// change on 13 may09 after changes in table
	/*
	 * public static void getManufacturerValues(CIMSGenericDrugMstVO vo) { HisDAO
	 * dao = null; String strQuery = ""; int nQueryIndex = 0; WebRowSet web =
	 * null; try { dao = new HisDAO("MMS", "GenericDrugMstDAO"); strQuery =
	 * mms.qryHandler_mms.getQuery(1, "select.drug.4"); nQueryIndex =
	 * dao.setQuery(strQuery); dao.setQryValue(nQueryIndex, 1,
	 * vo.getStrHospCode()); web = dao.executeQry(nQueryIndex);
	 * vo.setManufacturerWS(web); } catch (Exception e) { e.printStackTrace();
	 * vo.setStrMsgString("GenericDrugMstDAO.getManufacturerValues() --> " +
	 * e.getMessage()); vo.setStrMsgType("1"); } finally { dao = null; web =
	 * null; } }
	 * 
	 */
	// change on 14 may09 after changes in table
	/*
	 * public static void getItemValues(CIMSGenericDrugMstVO vo) { HisDAO dao =
	 * null; String strQuery = ""; int nQueryIndex = 0; WebRowSet web = null;
	 * try { dao = new HisDAO("MMS", "GenericDrugMstDAO"); strQuery =
	 * mms.qryHandler_mms.getQuery(1, "select.drug.6"); nQueryIndex =
	 * dao.setQuery(strQuery);
	 * 
	 * dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
	 * dao.setQryValue(nQueryIndex, 2, "1");
	 * 
	 * web = dao.executeQry(nQueryIndex);
	 * 
	 * vo.setItemTypeWS(web);
	 * 
	 *  } catch (Exception e) { e.printStackTrace();
	 * vo.setStrMsgString("GenericDrugMstDAO.getItemValues() --> " +
	 * e.getMessage()); vo.setStrMsgType("1"); } finally { dao = null; web =
	 * null; } }
	 */

	/**
	 * Gets the brand item dtl.
	 * 
	 * @param vo the vo
	 * 
	 * @return the brand item dtl
	 */
	public static void getBrandItemDtl(CIMSGenericDrugMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {

			dao = new HisDAO("MMS", "GenericDrugMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.drug.8");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrItemId());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
			web = dao.executeQry(nQueryIndex);
			vo.setBrandItemDtlWS(web);
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("GenericDrugMstDAO.getBrandItemDtl() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			web = null;
		}
	}

	// get Slno during modify case of brand Item Master
	/**
	 * Gets the sl no brand mst.
	 * 
	 * @param vo the vo
	 * 
	 * @return the sl no brand mst
	 */
	public static void getSlNoBrandMst(CIMSGenericDrugMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("MMS", "GenericDrugMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.brandItem.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrItemId());
			dao.setQryValue(nQueryIndex, 3, vo.getStrBrandId());
			web = dao.executeQry(nQueryIndex);
			if (web.next()) {
				vo.setStrBrandItemSlNo(web.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("GenericDrugMstDAO.getSlNoBrandMst() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * Insert modify brand item.
	 * 
	 * @param vo the vo
	 * @param dao the dao
	 * @param dao1 the dao1
	 */
	public static void insertModifyBrandItem(CIMSGenericDrugMstVO vo,
			BrandItemDAO dao, HisDAO dao1) {
		try {
			getSlNoBrandMst(vo);
			dao.setStrApprovedType(vo.getStrApprovedBy());
			dao.setStrDefaultRate(vo.getStrDefaultRate());
			dao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			dao.setStrHospitalCode(vo.getStrHospCode());
			dao.setStrIsValid("1");
			dao.setStrItemBrandId(vo.getStrBrandId());
			dao.setStrItemBrandSlNo(vo.getStrBrandItemSlNo());
			dao.setStrItemCatNO("10");
			dao.setStrItemId(vo.getStrItemId());
			dao.setStrItemMake(vo.getStrItemMaker());
			dao.setStrItemName(vo.getStrItemName());
			// dao.setStrItemStatus(vo.getStrItemstatus());
			dao.setStrRateUnitId(vo.getStrUnit());
			dao.setStrManuFacturerId(vo.getStrManufacturer());
			dao.setStrRemarks(vo.getStrRemarks());
			dao.setStrSeatId(vo.getStrSeatId());
			dao.setStrIssuseType(vo.getStrIssueType());
			dao.modifyInsert(dao1);
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("GenericDrugMstDAO.insertModifyBrandItem() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * Insert modify brand item.
	 * 
	 * @param vo the vo
	 * @param dao the dao
	 * @param dao1 the dao1
	 */
	

	/**
	 * View.
	 * 
	 * @param vo the vo
	 */
	public static void view(CIMSGenericDrugMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		String strQuery1= "";
		String strQuery2= "";
		WebRowSet web = null;
		try {

			dao = new HisDAO("MMS", "CIMSGenericDrugMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.cims.view");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrItemId());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 3, vo.getStrSerialNo());
			web = dao.executeQry(nQueryIndex);
			if (web.next()) {

				vo.setStrDrugName(web.getString(1));
				
				/*
				 * This block of code is inactivated by Aritra on 31st May, 2010
				 * Reason: 
				 			ws.getString(2) corresponds to group name.
				 			ws.getString(3) corresponds to subgroup name.
				 ****************************************************************
				 
				vo.setStrSubGroupNameValue(web.getString(2));
				vo.setStrGroupNameValue(web.getString(3));
				
				*/
				
				/*
				 * This block of code is added by Aritra on 31st May, 2010
				 * Reason: 	To set data for group name and sub group name, 
				 			fetched from database, in vo.
				 */
				vo.setStrSubGroupNameValue(web.getString(3));
				vo.setStrGroupNameValue(web.getString(2));
				/*
				 *				--- End of addition on 31/May/2010 ---        *
				 */
				
				vo.setStrBatchNo(web.getString(4));
				vo.setStrExpiryDatereq(web.getString(5));
				vo.setStrShelfLife(web.getString(6));
				vo.setStrShelfTimeFormat(web.getString(7));
				vo.setStrStockMaintain(web.getString(8));

				vo.setStrConsumableType(web.getString(9));
				vo.setStrIsItemNarcotic(web.getString(10));
		
				vo.setStrIsValid(web.getString(11));
				vo.setStrConsentReq(web.getString(12));
				vo.setStrInventoryUnitName(web.getString(13));
				vo.setStrIsItemCodeRequired(web.getString(14));
				vo.setStrAtcClassCode(web.getString(15));
				vo.setStrPregnancySafeFlag(web.getString(16));
				vo.setStrContraindictioncode(web.getString(17));
				vo.setStrDrugAdmincode(web.getString(18));
				vo.setStrStoragecode(web.getString(19));
				vo.setStrdosageadult(web.getString(20));
				vo.setStrsprecau(web.getString(21));
				vo.setStradvdrug(web.getString(22));
				vo.setStrmechact(web.getString(23));
				vo.setStrlabintfrnce(web.getString(24));
				vo.setStrAdminRoute(web.getString(25));
				vo.setStrdosagepeads(web.getString(26));
				

			}
			strQuery1 = mms.qryHandler_mms.getQuery(1, "select.drug.contradiction");
			nQueryIndex = dao.setQuery(strQuery1);
			dao.setQryValue(nQueryIndex, 1, vo.getStrItemId());
			dao.setQryValue(nQueryIndex, 2, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nQueryIndex, 3, vo.getStrSerialNo());
			web = dao.executeQry(nQueryIndex);
			if (web.next()) 
			{
				vo.setStrDrugval(web.getString(1));
			}
			strQuery2 = mms.qryHandler_mms.getQuery(1, "select.drug.brand");
			nQueryIndex = dao.setQuery(strQuery2);
			dao.setQryValue(nQueryIndex, 1, vo.getStrItemId());
			dao.setQryValue(nQueryIndex, 2, Config.SUPER_USER_HOSPITAL_CODE);
			web = dao.executeQry(nQueryIndex);
			if (web.next()) 
			{
				vo.setStrBrand(web.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo
					.setStrMsgString("CIMSGenericDrugMstDAO.view() --> "
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
	public static void getStockMaintainedValues(CIMSGenericDrugMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("MMS", "GenericDrugMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.drug.5");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrModuleId());
			web = dao.executeQry(nQueryIndex);
			vo.setStockMaintainedWS(web);
		} catch (Exception e) {
			e.printStackTrace();
			vo
					.setStrMsgString("GenericDrugMstDAO.getStockMaintainedValues() --> "
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
	public static void getItemCodeRequired(CIMSGenericDrugMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("MMS", "GenericDrugMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.itemCatDtls.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, "100");
			dao.setQryValue(nQueryIndex, 2, "10");
			web = dao.executeQry(nQueryIndex);
			
			if(web != null && web.next()){
				
				vo.setStrIsItemCodeRequired(web.getString(1));
				
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
			vo
					.setStrMsgString("GenericDrugMstDAO.getItemCodeRequired() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			web = null;
		}
	}

	public static void getSubgroupName(CIMSGenericDrugMstVO vo) {
		
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("MMS", "GenericDrugMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "genericDrugMst.subgroupName");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrSubGroupId());
			web = dao.executeQry(nQueryIndex);
			
			if(web != null && web.next()){
				
				vo.setStrSubGroupNameValue(web.getString(1));
				
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
			vo
					.setStrMsgString("GenericDrugMstDAO.getSubgroupName() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			web = null;
		}
		
	}
	
	
	
public static void checkDataExists(CIMSGenericDrugMstVO vo,String[] chk) {
	int nIndex1 = 0;
	int nIndex2 = 0;
	String strQry1 = "";
	String strQry2 = "";

	HisDAO hisdao = new HisDAO("billing.GenericDrugMstDAO", "deleteData");

	try {
		strQry1 = billing.qryHandler_billing.getQuery(1,"delete.chargeMst.0");

		for(int nTmpI = 0; nTmpI < chk.length; nTmpI++){
							
			String[] strTemp =  chk[nTmpI].replace("@", "#").replace("|", "#").split("#");
							
			nIndex1 = hisdao.setQuery(strQry1);
			hisdao.setQryValue(nIndex1, 1, strTemp[0]);
			hisdao.setQryValue(nIndex1, 2, strTemp[1]);
			hisdao.setQryValue(nIndex1, 3, strTemp[2]);
			hisdao.setQryValue(nIndex1, 4, strTemp[3]);
			hisdao.setQryValue(nIndex1, 5, strTemp[4]);
			hisdao.setQryValue(nIndex1, 6, strTemp[8]);

			hisdao.execute(nIndex1, 0);
		}

		strQry2 = billing.qryHandler_billing.getQuery(1,"delete.chargeMst.1");

		for(int nTmpI = 0; nTmpI < chk.length; nTmpI++){
			
			String[] strTemp =  chk[nTmpI].replace("@", "#").replace("|", "#").split("#");
			
			nIndex2 = hisdao.setQuery(strQry2);
			hisdao.setQryValue(nIndex2, 1, strTemp[0]);
			hisdao.setQryValue(nIndex2, 2, strTemp[1]);
			hisdao.setQryValue(nIndex2, 3, strTemp[2]);
			hisdao.setQryValue(nIndex2, 4, strTemp[3]);
			hisdao.setQryValue(nIndex2, 5, strTemp[4]);
			hisdao.setQryValue(nIndex2, 6, strTemp[5]);

			hisdao.execute(nIndex2, 0);
		}	
		
		synchronized (hisdao) {
			hisdao.fire();
		}

	} catch (Exception e) {
		 
		vo.setStrMsgString("billing.DAOChargeMst.deleteData -->" + e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		hisdao.free();
		hisdao = null;
	}
}

public static void getPregCatValues(CIMSGenericDrugMstVO vo) {
	
	HisDAO dao = null;
	String strQuery = "";
	int nQueryIndex = 0;
	WebRowSet web = null;
	try {
		dao = new HisDAO("MMS", "CIMSGenericDrugMstDAO");
		strQuery = mms.qryHandler_mms.getQuery(1, "select.preg.cat");
		nQueryIndex = dao.setQuery(strQuery);
		web = dao.executeQry(nQueryIndex);
		
		vo.setPregcatDtlWS(web);
		
	} catch (Exception e) {
		e.printStackTrace();
		vo
				.setStrMsgString("CIMSGenericDrugMstDAO.getPregCatValues() --> "
						+ e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		dao = null;
		web = null;
	}
	
}
public static void getContracdictoryDrugList(CIMSGenericDrugMstVO vo) {
	
	HisDAO dao = null;
	String strQuery = "";
	int nQueryIndex = 0;
	WebRowSet web = null;
	try {
		dao = new HisDAO("MMS", "CIMSGenericDrugMstDAO");
		strQuery = mms.qryHandler_mms.getQuery(1, "select.drug.val");
		nQueryIndex = dao.setQuery(strQuery);
		web = dao.executeQry(nQueryIndex);
		
		vo.setDrugvalWS(web);
		
	} catch (Exception e) {
		e.printStackTrace();
		vo
				.setStrMsgString("CIMSGenericDrugMstDAO.getDrugValues() --> "
						+ e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		dao = null;
		web = null;
	}
	
}	
public static void save(CIMSGenericDrugMstVO vo) {
	HisDAO dao = null;
	String strQuery = "";
	int nQueryIndex = 0;
	WebRowSet web = null;
	String strQuery1 = "";
	
	int nQueryIndex1 = 0;
	WebRowSet web1 = null;
	String strQuery2 = "";
	String strQuery3 = "";
	
	// BrandItemDAO brandItem = null;
	GenericDrugDAO drugDAO = null;
	String strDrugId = "";

	String strTariffId = "";
	//System.out.println("hospital code is "+vo.getStrHospitalCode());
	
	MmsConfigUtil mmsConfigUtil=new MmsConfigUtil(vo.getStrHospitalCode());
	// String strBrandItemId = "";
	try 
	{
		drugDAO = new GenericDrugDAO();
		// brandItem = new BrandItemDAO();

		dao = new HisDAO("MMS", "CIMSGenericDrugMstDAO");
		strQuery = mms.qryHandler_mms.getQuery(1, "select.drug.7");
		nQueryIndex = dao.setQuery(strQuery);
		dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
		dao.setQryValue(nQueryIndex, 2, "10"); // /ITEM CATEGORY FOR DRUGS
		web = dao.executeQry(nQueryIndex);
		if (web.next()) {
			strDrugId = web.getString(1);
		}
		strQuery1 = mms.qryHandler_mms.getQuery(1, "select.drug.tariff");
		nQueryIndex1 = dao.setQuery(strQuery1);
		web1 = dao.executeQry(nQueryIndex1);
		if (web1.next()) {
			strTariffId = web1.getString(1);
		}
		////System.out.println("Tariff ID:::   "+strTariffId);
		
		drugDAO.setStrTariffId(strTariffId);
		strQuery2 = mms.qryHandler_mms.getQuery(1, "insert.drug.cims");
		nQueryIndex = dao.setQuery(strQuery2);

		/*//System.out.println("---->"+this.getStrItemId());
		//System.out.println("---->"+this.getStrHospitalCode());
		//System.out.println("----->"+this.getStrGroupId());
		//System.out.println("----->"+this.getStrSubGroupId());
		//System.out.println("----->"+this.getStrItemCatNO());
		*/
		
		dao.setQryValue(nQueryIndex, 1, strDrugId);
		dao.setQryValue(nQueryIndex, 2, vo.getStrItemCatNo().equalsIgnoreCase("")?"0":vo.getStrItemCatNo());
		dao.setQryValue(nQueryIndex, 3, vo.getStrDrugName().equalsIgnoreCase("")?"0":vo.getStrDrugName());
		dao.setQryValue(nQueryIndex, 4, vo.getStrGroupId().equalsIgnoreCase("")?"0":vo.getStrGroupId());
		dao.setQryValue(nQueryIndex, 5, vo.getStrSubGroupId().equalsIgnoreCase("")?"0":vo.getStrSubGroupId());
		dao.setQryValue(nQueryIndex, 6, vo.getStrCPACode().equalsIgnoreCase("")?"0":vo.getStrCPACode().toUpperCase());
		dao.setQryValue(nQueryIndex, 7, vo.getStrConsumableType().equalsIgnoreCase("")?"0":vo.getStrConsumableType());
		dao.setQryValue(nQueryIndex, 8, vo.getStrPregnancySafeFlag().equalsIgnoreCase("")?"0":vo.getStrPregnancySafeFlag());
		dao.setQryValue(nQueryIndex, 9, vo.getStrContraindictioncode().equalsIgnoreCase("")?"0":vo.getStrContraindictioncode());
		dao.setQryValue(nQueryIndex, 10, vo.getStrDrugAdmincode().equalsIgnoreCase("")?"0":vo.getStrDrugAdmincode());
		dao.setQryValue(nQueryIndex, 11, vo.getStrStoragecode().equalsIgnoreCase("")?"0":vo.getStrStoragecode());
		dao.setQryValue(nQueryIndex, 12, vo.getStrbatchnoreq().equalsIgnoreCase("")?"0":vo.getStrbatchnoreq());
		dao.setQryValue(nQueryIndex, 13, vo.getStrExpiryDatereq().equalsIgnoreCase("")?"0":vo.getStrExpiryDatereq());
		dao.setQryValue(nQueryIndex, 14, vo.getStrShelfLife().equalsIgnoreCase("")?"0":vo.getStrShelfLife());
		dao.setQryValue(nQueryIndex, 15, vo.getStrShelfTimeFormat().equalsIgnoreCase("")?"0":vo.getStrShelfTimeFormat());
		dao.setQryValue(nQueryIndex, 16, vo.getStrStockMaintain().equalsIgnoreCase("")?"0":vo.getStrStockMaintain());
		dao.setQryValue(nQueryIndex, 17, vo.getStrIsItemNarcotic().equalsIgnoreCase("")?"0":vo.getStrIsItemNarcotic());
		dao.setQryValue(nQueryIndex, 18, vo.getStrConsentReq().equalsIgnoreCase("")?"0":vo.getStrConsentReq());
		dao.setQryValue(nQueryIndex, 19, vo.getStrdosagepeads().equalsIgnoreCase("")?"0":vo.getStrdosagepeads());
		dao.setQryValue(nQueryIndex, 20, vo.getStrsprecau().equalsIgnoreCase("")?"0":vo.getStrsprecau());
		dao.setQryValue(nQueryIndex, 21, vo.getStradvdrug().equalsIgnoreCase("")?"0":vo.getStradvdrug());
		dao.setQryValue(nQueryIndex, 22, vo.getStrmechact().equalsIgnoreCase("")?"0":vo.getStrmechact());
		dao.setQryValue(nQueryIndex, 23, vo.getStrlabintfrnce().equalsIgnoreCase("")?"0":vo.getStrlabintfrnce());
		//dao.setQryValue(nQueryIndex, 24, "0");
		//dao.setQryValue(nQueryIndex, 25, "0");
		//dao.setQryValue(nQueryIndex, 26, vo.getStrEffectiveFrom());
		dao.setQryValue(nQueryIndex, 24, vo.getStrSeatId().equalsIgnoreCase("")?"0":vo.getStrSeatId());
		dao.setQryValue(nQueryIndex, 25, vo.getStrIsValid().equalsIgnoreCase("")?"0":vo.getStrIsValid());
		dao.setQryValue(nQueryIndex, 26, vo.getStrAdminRoute().equalsIgnoreCase("")?"0":vo.getStrAdminRoute());
		dao.setQryValue(nQueryIndex, 27, vo.getStrHospCode().equalsIgnoreCase("")?"0":vo.getStrHospCode());
		dao.setQryValue(nQueryIndex, 28, vo.getStrSerialNo().equalsIgnoreCase("")?"0":vo.getStrSerialNo());
		dao.setQryValue(nQueryIndex, 29, vo.getStrdosageadult().equalsIgnoreCase("")?"0":vo.getStrdosageadult());
		dao.execute(nQueryIndex, 0);
		//System.out.println("billing integration is "+mmsConfigUtil.getStrBillingIntegration());
		if(mmsConfigUtil.getStrBillingIntegration().equals("1"))
		drugDAO.insert2(dao);
		if(!vo.getStrDrugval().equals("") && vo.getStrDrugval() != null)
		{		String[] drugIdTemp = vo.getStrDrugIdval().replace(",","#").split("#");
				String[] drugTemp = vo.getStrDrugval().replace(",","#").split("#");
				for (int k=0;k< drugIdTemp.length;k++)
				{
					strQuery3 = mms.qryHandler_mms.getQuery(1, "insert.drug.contraind");
					nQueryIndex1 = dao.setQuery(strQuery3);
					dao.setQryValue(nQueryIndex1, 1, strDrugId);
					dao.setQryValue(nQueryIndex1, 2, vo.getStrHospCode());
					dao.setQryValue(nQueryIndex1, 3, drugTemp[k]);
					dao.setQryValue(nQueryIndex1, 4, vo.getStrSerialNo().equalsIgnoreCase("")?"0":vo.getStrSerialNo());
					dao.setQryValue(nQueryIndex1, 5, vo.getStrSeatId().equalsIgnoreCase("")?"0":vo.getStrSeatId());
					dao.setQryValue(nQueryIndex1, 6, vo.getStrIsValid().equalsIgnoreCase("")?"0":vo.getStrIsValid());
					dao.setQryValue(nQueryIndex1, 7, drugIdTemp[k]);
					dao.execute(nQueryIndex1, 0);
				}
		}
		synchronized (dao) {
			dao.fire();
		}
		

	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		dao = null;
		web = null;
	}
}
public static void update(CIMSGenericDrugMstVO vo) 
{
	HisDAO dao = null;
	GenericDrugDAO drugDAO = null;
	String strQuery = "";
	String strQuery1 = "";
	String strQuery2 = "";
	String strQuery3 = "";
	String strQuery4 = "";
	int nQueryIndex = 0;
	int nQueryIndex1 = 0;
	WebRowSet web = null;
	String strDrugId="";
	try 
	{
		    dao = new HisDAO("MMS", "CIMSGenericDrugMstDAO");			
		drugDAO = new GenericDrugDAO();			
		dao = new HisDAO("MMS", "CIMSGenericDrugMstDAO");
		
		//drugDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
		//drugDAO.setStrRemarks(vo.getStrRemarks());			
		//drugDAO.setStrIsValid("2");			
		drugDAO.setStrSeatId(vo.getStrSeatId());		
		//drugDAO.setStrHospitalCode(vo.getStrHospCode());
		drugDAO.setStrItemId(vo.getStrItemId());
		drugDAO.setStrSerialNo(vo.getStrSerialNo());
		//drugDAO.update1(dao);
		strQuery1 = mms.qryHandler_mms.getQuery(1, "update.drug.cims");
		nQueryIndex = dao.setQuery(strQuery1);
		dao.setQryValue(nQueryIndex, 1, vo.getStrSeatId().equalsIgnoreCase("")?"0":vo.getStrSeatId());			
		dao.setQryValue(nQueryIndex, 2, vo.getStrItemId().equalsIgnoreCase("")?"0":vo.getStrItemId());
		dao.execute(nQueryIndex, 0);
		
		strQuery4 = mms.qryHandler_mms.getQuery(1, "update.drug.contraind");
		nQueryIndex1 = dao.setQuery(strQuery4);
		dao.setQryValue(nQueryIndex1, 1, vo.getStrSeatId().equalsIgnoreCase("")?"0":vo.getStrSeatId());			
		dao.setQryValue(nQueryIndex1, 2, vo.getStrItemId().equalsIgnoreCase("")?"0":vo.getStrItemId());
		dao.execute(nQueryIndex1, 0);
		drugDAO.update2(dao);
		
		/**************************************************************************/			
		
		
		//Removed from the front end so default will be 0
        //drugDAO.setStrBatchNoReq(vo.getStrBatchNo());
		/*drugDAO.setStrBatchNoReq("0");
		
		drugDAO.setStrConsumableFlag(vo.getStrConsumableType());
		drugDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
		
		//Removed from the front end so default will be 0
		//drugDAO.setStrExpiryDateReq(vo.getStrExpiryDate());
		drugDAO.setStrExpiryDateReq(vo.getStrExpiryDate());
		
		drugDAO.setStrGroupId(vo.getStrGroupId());
		drugDAO.setStrHospitalCode(vo.getStrHospCode());
		drugDAO.setStrInventoryUnitId(vo.getStrStockMaintainedCode());
		drugDAO.setStrIsNarcotic(vo.getStrIsItemNarcotic());
		drugDAO.setStrIsValid("1");
		drugDAO.setStrItemCatNO("10");
		drugDAO.setStrItemName(vo.getStrDrugName());
		drugDAO.setStrPurchasedLeadTime(vo.getStrPurchaseLeadTime());
		drugDAO.setStrPurLeadTimeUnit(vo.getStrTimeFormat());
		drugDAO.setStrRemarks(vo.getStrRemarks());
		drugDAO.setStrSeatId(vo.getStrSeatId());
		drugDAO.setStrShelfLife(vo.getStrShelfLife().equalsIgnoreCase("")?"0":vo.getStrShelfLife());
		drugDAO.setStrShelfLifeUnit(vo.getStrShelfTimeFormat());
		drugDAO.setStrSubGroupId(vo.getStrSubGroupId());
		drugDAO.setStrConsentReq(vo.getStrConsentReq());
		
		//Removed from the front end so default will be 0
		//drugDAO.setStrCPACode(vo.getStrCPACode());		
		drugDAO.setStrCPACode("0");			
		
		drugDAO.setStrPregnancySafeFlag(vo.getStrPregnancySafeFlag());
		drugDAO.setStrTrimester(vo.getStrTrimester());
		drugDAO.setStrEffectsOnFoetus(vo.getStrEffectsOnFoetus());
		
		drugDAO.insert1(dao);
		drugDAO.insert3(dao);*/
		strQuery = mms.qryHandler_mms.getQuery(1, "select.drug.7");
		nQueryIndex = dao.setQuery(strQuery);
		dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
		dao.setQryValue(nQueryIndex, 2, "10"); // /ITEM CATEGORY FOR DRUGS
		web = dao.executeQry(nQueryIndex);
		if (web.next()) {
			strDrugId = web.getString(1);
		}
		strQuery2 = mms.qryHandler_mms.getQuery(1, "insert.drug.cims.1");
		nQueryIndex = dao.setQuery(strQuery2);

		/*//System.out.println("---->"+this.getStrItemId());
		//System.out.println("---->"+this.getStrHospitalCode());
		//System.out.println("----->"+this.getStrGroupId());
		//System.out.println("----->"+this.getStrSubGroupId());
		//System.out.println("----->"+this.getStrItemCatNO());
		*/
		
		dao.setQryValue(nQueryIndex, 1, strDrugId);
		dao.setQryValue(nQueryIndex, 2, "10");
		dao.setQryValue(nQueryIndex, 3, vo.getStrDrugName().equalsIgnoreCase("")?"0":vo.getStrDrugName());
		dao.setQryValue(nQueryIndex, 4, vo.getStrGroupId().equalsIgnoreCase("")?"0":vo.getStrGroupId());
		dao.setQryValue(nQueryIndex, 5, vo.getStrSubGroupId().equalsIgnoreCase("")?"0":vo.getStrSubGroupId());
		dao.setQryValue(nQueryIndex, 6, vo.getStrCPACode().equalsIgnoreCase("")?"0":vo.getStrCPACode().toUpperCase());
		dao.setQryValue(nQueryIndex, 7, vo.getStrConsumableType().equalsIgnoreCase("")?"0":vo.getStrConsumableType());
		dao.setQryValue(nQueryIndex, 8, vo.getStrPregnancySafeFlag().equalsIgnoreCase("")?"0":vo.getStrPregnancySafeFlag());
		dao.setQryValue(nQueryIndex, 9, vo.getStrContraindictioncode().equalsIgnoreCase("")?"0":vo.getStrContraindictioncode());
		dao.setQryValue(nQueryIndex, 10, vo.getStrDrugAdmincode().equalsIgnoreCase("")?"0":vo.getStrDrugAdmincode());
		dao.setQryValue(nQueryIndex, 11, vo.getStrStoragecode().equalsIgnoreCase("")?"0":vo.getStrStoragecode());
		dao.setQryValue(nQueryIndex, 12, vo.getStrbatchnoreq().equalsIgnoreCase("")?"1":vo.getStrbatchnoreq());
		dao.setQryValue(nQueryIndex, 13, vo.getStrExpiryDatereq().equalsIgnoreCase("")?"1":vo.getStrExpiryDatereq());
		dao.setQryValue(nQueryIndex, 14, vo.getStrShelfLife().equalsIgnoreCase("")?"0":vo.getStrShelfLife());
		dao.setQryValue(nQueryIndex, 15, vo.getStrShelfTimeFormat().equalsIgnoreCase("")?"0":vo.getStrShelfTimeFormat());
		dao.setQryValue(nQueryIndex, 16, vo.getStrStockMaintain().equalsIgnoreCase("")?"0":vo.getStrStockMaintain());
		dao.setQryValue(nQueryIndex, 17, vo.getStrIsItemNarcotic().equalsIgnoreCase("")?"0":vo.getStrIsItemNarcotic());
		dao.setQryValue(nQueryIndex, 18, vo.getStrConsentReq().equalsIgnoreCase("")?"0":vo.getStrConsentReq());
		dao.setQryValue(nQueryIndex, 19, vo.getStrdosageadult().equalsIgnoreCase("")?"0":vo.getStrdosageadult());
		dao.setQryValue(nQueryIndex, 20, vo.getStrsprecau().equalsIgnoreCase("")?"0":vo.getStrsprecau());
		dao.setQryValue(nQueryIndex, 21, vo.getStradvdrug().equalsIgnoreCase("")?"0":vo.getStradvdrug());
		dao.setQryValue(nQueryIndex, 22, vo.getStrmechact().equalsIgnoreCase("")?"0":vo.getStrmechact());
		dao.setQryValue(nQueryIndex, 23, vo.getStrlabintfrnce().equalsIgnoreCase("")?"0":vo.getStrlabintfrnce());
		dao.setQryValue(nQueryIndex, 24, vo.getStrSeatId().equalsIgnoreCase("")?"0":vo.getStrSeatId());
		//dao.setQryValue(nQueryIndex, 25, "0");
		//dao.setQryValue(nQueryIndex, 26, vo.getStrEffectiveFrom());
		dao.setQryValue(nQueryIndex, 25, vo.getStrSeatId().equalsIgnoreCase("")?"0":vo.getStrSeatId());
		dao.setQryValue(nQueryIndex, 26, vo.getStrIsValid().equalsIgnoreCase("")?"0":vo.getStrIsValid());
		dao.setQryValue(nQueryIndex, 27, vo.getStrAdminRoute().equalsIgnoreCase("")?"0":vo.getStrAdminRoute());
		dao.setQryValue(nQueryIndex, 28, vo.getStrHospCode().equalsIgnoreCase("")?"0":vo.getStrHospCode());
		dao.setQryValue(nQueryIndex, 29, vo.getStrSerialNo().equalsIgnoreCase("")?"0":vo.getStrSerialNo());
		dao.setQryValue(nQueryIndex, 30, vo.getStrdosagepeads().equalsIgnoreCase("")?"0":vo.getStrdosagepeads());
		dao.execute(nQueryIndex, 0);
		if(!vo.getStrDrugval().equals("") && vo.getStrDrugval() != null)
		{
			String[] drugIdTemp = vo.getStrDrugIdval().replace(",","#").split("#");
			String[] drugTemp = vo.getStrDrugval().replace(",","#").split("#");
			for (int k=0;k< drugIdTemp.length;k++)
			{
				strQuery3 = mms.qryHandler_mms.getQuery(1, "insert.drug.contraind.1");
				nQueryIndex1 = dao.setQuery(strQuery3);
				dao.setQryValue(nQueryIndex1, 1, strDrugId);
				dao.setQryValue(nQueryIndex1, 2, vo.getStrHospCode());
				dao.setQryValue(nQueryIndex1, 3,  drugTemp[k]);
				dao.setQryValue(nQueryIndex1, 4, vo.getStrSerialNo().equalsIgnoreCase("")?"0":vo.getStrSerialNo());
				dao.setQryValue(nQueryIndex1, 5, vo.getStrSeatId().equalsIgnoreCase("")?"0":vo.getStrSeatId());
				dao.setQryValue(nQueryIndex1, 6, vo.getStrSeatId().equalsIgnoreCase("")?"0":vo.getStrSeatId());
				dao.setQryValue(nQueryIndex1, 7, vo.getStrIsValid().equalsIgnoreCase("")?"0":vo.getStrIsValid());
				dao.setQryValue(nQueryIndex1, 8, drugIdTemp[k]);
				dao.execute(nQueryIndex1, 0);
			}
		}
		synchronized (dao) {
			dao.fire();
		}
	} catch (Exception e) {
		e.printStackTrace();
		vo.setStrMsgString("GenericDrugMstDAO.update() --> "
				+ e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		dao = null;

	}
}
public static void getAdministartion(CIMSGenericDrugMstVO vo) {
	
	HisDAO dao = null;
	String strQuery = "";
	int nQueryIndex = 0;
	WebRowSet web = null;
	try {
		dao = new HisDAO("MMS", "CIMSGenericDrugMstDAO");
		strQuery = mms.qryHandler_mms.getQuery(1, "select.drug.admin");
		nQueryIndex = dao.setQuery(strQuery);
		web = dao.executeQry(nQueryIndex);
		
		vo.setAdminWS(web);
		
	} catch (Exception e) {
		e.printStackTrace();
		vo
				.setStrMsgString("CIMSGenericDrugMstDAO.getAdmin() --> "
						+ e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		dao = null;
		web = null;
	}
	
}	
public static void getStorage(CIMSGenericDrugMstVO vo) {
	
	HisDAO dao = null;
	String strQuery = "";
	int nQueryIndex = 0;
	WebRowSet web = null;
	try {
		dao = new HisDAO("MMS", "CIMSGenericDrugMstDAO");
		strQuery = mms.qryHandler_mms.getQuery(1, "select.drug.storage");
		nQueryIndex = dao.setQuery(strQuery);
		web = dao.executeQry(nQueryIndex);
		
		vo.setStorageWS(web);
		
	} catch (Exception e) {
		e.printStackTrace();
		vo
				.setStrMsgString("CIMSGenericDrugMstDAO.getStorage() --> "
						+ e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		dao = null;
		web = null;
	}
	
}	
public static void getContraindicationsList(CIMSGenericDrugMstVO vo) {
	
	HisDAO dao = null;
	String strQuery = "";
	int nQueryIndex = 0;
	WebRowSet web = null;
	try {
		dao = new HisDAO("MMS", "CIMSGenericDrugMstDAO");
		strQuery = mms.qryHandler_mms.getQuery(1, "select.drug.Contraind");
		nQueryIndex = dao.setQuery(strQuery);
		web = dao.executeQry(nQueryIndex);
		
		vo.setContraindWS(web);
		
	} catch (Exception e) {
		e.printStackTrace();
		vo
				.setStrMsgString("CIMSGenericDrugMstDAO.getContraind() --> "
						+ e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		dao = null;
		web = null;
	}
	
}	
public static void getAdminRoute(CIMSGenericDrugMstVO vo) {
	
	HisDAO dao = null;
	String strQuery = "";
	int nQueryIndex = 0;
	WebRowSet web = null;
	try {
		dao = new HisDAO("MMS", "CIMSGenericDrugMstDAO");
		strQuery = mms.qryHandler_mms.getQuery(1, "select.drug.admin.route");
		nQueryIndex = dao.setQuery(strQuery);
		web = dao.executeQry(nQueryIndex);
		
		vo.setAdminRouteWS(web);
		
	} catch (Exception e) {
		e.printStackTrace();
		vo
				.setStrMsgString("CIMSGenericDrugMstDAO.getAdminRoute() --> "
						+ e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		dao = null;
		web = null;
	}
	
}	
}

