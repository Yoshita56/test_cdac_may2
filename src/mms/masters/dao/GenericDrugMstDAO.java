package mms.masters.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;
import mms.MmsConfigUtil;
import mms.dao.BrandItemDAO;
import mms.dao.GenericDrugDAO;
import mms.masters.vo.GenericDrugMstVO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Anshul Jindal Version : 1.0 Date : 31/Jan/2009-May/09
 */

public class GenericDrugMstDAO {

	/**
	 * This function is used to check duplicate name.
	 * 
	 * @param vo the vo
	 */
	public static void duplicacyAddQuery(GenericDrugMstVO vo) {
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
			// System.out.println(dao.getQryResult(strQuery));
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
	public static void insert_ORG(GenericDrugMstVO vo) {
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
		System.out.println("hospital code is "+vo.getStrHospitalCode());
		MmsConfigUtil mmsConfigUtil=new MmsConfigUtil(vo.getStrHospitalCode());
		// String strBrandItemId = "";
		try 
		{
			drugDAO = new GenericDrugDAO();
			// brandItem = new BrandItemDAO();

			dao = new HisDAO("MMS", "GenericDrugMstDAO");
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
			//System.out.println("Tariff ID:::   "+strTariffId);
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
			drugDAO.setStrCPACode("0");
			
			
			/*Aritra*/
			drugDAO.setStrPregnancySafeFlag(vo.getStrPregnancySafeFlag());
			drugDAO.setStrTrimester(vo.getStrTrimester());
			drugDAO.setStrEffectsOnFoetus(vo.getStrEffectsOnFoetus());
			
			drugDAO.insert(dao);
			
			System.out.println("billing integration is "+mmsConfigUtil.getStrBillingIntegration());
			if(mmsConfigUtil.getStrBillingIntegration().equals("1"))
			drugDAO.insert2(dao);

			// change on 13 may09 after changes in table

			// System.out.println("vo.getStrBrandedApprovedBy().length-"+
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
	 * Insert.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void insert(GenericDrugMstVO vo) 
	{
		HisDAO dao = null;
		String strProcName = "";
		int nProcIndex = 0;	
		
		try 
		{		
			System.out.println("<<--------------INSERT_GENERIC_DRUG---------------->>");		
		
			
			    dao = new HisDAO("MMS", "ItemMstDAO");		
			    
			  
				
			    strProcName = "{call Pkg_Mms_Dml.dml_generic_drug_mst(?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?)}"; // 27
	            
			   
				nProcIndex = dao.setProcedure(strProcName);
								
				dao.setProcInValue(nProcIndex, "modval", 			"1" ,1); 
				dao.setProcInValue(nProcIndex, "item_id", 		    (vo.getStrItemId()==null || vo.getStrItemId().equals(""))?"0":vo.getStrItemId(),2); 
				dao.setProcInValue(nProcIndex, "hosp_code", 		vo.getStrHospCode(),3); 
				dao.setProcInValue(nProcIndex, "grp_id",		 	vo.getStrGroupId(),4);
				dao.setProcInValue(nProcIndex, "sub_grp_id", 		vo.getStrSubGroupId(),5);			
				dao.setProcInValue(nProcIndex, "itemcatno", 		"10",6); 
				dao.setProcInValue(nProcIndex, "itemname",      	vo.getStrDrugName(),7); 
				dao.setProcInValue(nProcIndex, "batch_req", 		"0",8); 
				dao.setProcInValue(nProcIndex, "exp_date_req", 		"0",9); 
				dao.setProcInValue(nProcIndex, "shelf_life", 		vo.getStrShelfLife().equalsIgnoreCase("")?"0":vo.getStrShelfLife(),10); 						
				dao.setProcInValue(nProcIndex, "shelf_life_unit", 	(vo.getStrShelfTimeFormat()==null || vo.getStrShelfTimeFormat().equals(""))?"0":vo.getStrShelfTimeFormat(),11); 
				dao.setProcInValue(nProcIndex, "inv_unit_id",       vo.getStrStockMaintain(),12); 
				dao.setProcInValue(nProcIndex, "pur_lead_time", 	vo.getStrPurchaseLeadTime().equalsIgnoreCase("")?"0":vo.getStrPurchaseLeadTime(),13);			
				dao.setProcInValue(nProcIndex, "pur_lead_time_unit",vo.getStrTimeFormat(),14); 			
				dao.setProcInValue(nProcIndex, "CONSUMABLE_FLAG", 	vo.getStrConsumableType(),15);
				dao.setProcInValue(nProcIndex, "IS_NARCOTIC",		"0",16); 			
				dao.setProcInValue(nProcIndex, "remarks", 		    vo.getStrIsValid(),17); 
				dao.setProcInValue(nProcIndex, "EFFECTIVE_FRM", 	"SYSDATE",18); 
				dao.setProcInValue(nProcIndex, "ENTRY_DATE",        "SYSDATE",19); 
				dao.setProcInValue(nProcIndex, "seatid", 		    vo.getStrSeatId(),20); 
				dao.setProcInValue(nProcIndex, "isValid", 		    "1",21); 
				dao.setProcInValue(nProcIndex, "consentReq_Flag",   vo.getStrConsentReq(),22); 
				
				dao.setProcInValue(nProcIndex, "cpa_code", 	        "0",23); 
				
				dao.setProcInValue(nProcIndex, "PREGNANCY_SAFE_FLAG", (vo.getStrPregnancySafeFlag()==null || vo.getStrPregnancySafeFlag().equals(""))?"0":vo.getStrPregnancySafeFlag(),24); 	
				dao.setProcInValue(nProcIndex, "TRIMESTER",           (vo.getStrTrimester()==null || vo.getStrTrimester().equals(""))?"0":vo.getStrTrimester(),25); 
				dao.setProcInValue(nProcIndex, "FOETUS_EFFECTS", 	  (vo.getStrEffectsOnFoetus()==null || vo.getStrEffectsOnFoetus().equals(""))?"0":vo.getStrEffectsOnFoetus(),26); 			
				
				dao.setProcOutValue(nProcIndex, "err", 				1,27);	
				dao.execute(nProcIndex, 1);
				
			    dao.fire();
			
		} catch (Exception e) {
			 e.printStackTrace();
			vo.setStrMsgString("DrugMstDAO.insert() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
			}
			dao = null;
		}
	}

	/**
	 * This function is used set initial parameters for modify page.
	 * 
	 * @param vo the vo
	 */
	public static void modify(GenericDrugMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {

			dao = new HisDAO("MMS", "GenericDrugMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.drug.9");
//			System.out.println(" vo.getStrItemId() -->>"+vo.getStrItemId());
//			System.out.println(" vo.getStrHospCode() -->>"+vo.getStrHospCode());
//			System.out.println(" vo.getStrSerialNo() -->>"+vo.getStrSerialNo());
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
				vo.setStrPurchaseLeadTime(web.getString(7));
				vo.setStrTimeFormat(web.getString(8));
				vo.setStrConsumableType(web.getString(9));
				vo.setStrIsItemNarcotic(web.getString(10));
				vo.setStrRemarks(web.getString(11));
				vo.setStrEffectiveFrom(web.getString(12));
				vo.setStrIsValid(web.getString(13));
				vo.setStrConsentReq(web.getString(14));
				vo.setStrSubGroupNameValue(web.getString(15));
				vo.setStrGroupNameValue(web.getString(16));
				vo.setStrCPACode(web.getString(17));
				vo.setStrInventoryUnitName(web.getString(18));
				vo.setStrPregnancySafeFlag(web.getString(19));
				vo.setStrTrimester(web.getString(20));
				vo.setStrEffectsOnFoetus(web.getString(21));
				vo.setStrIsItemCodeRequired(web.getString(22));
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
	public static void dupliUpdateQuery(GenericDrugMstVO vo) {
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
	public static void update(GenericDrugMstVO vo) 
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
			drugDAO.setStrIsValid(vo.getStrIsValid());
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
			
			drugDAO.update2(dao);
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
	public static void CheckDuplicayAdd(GenericDrugMstVO vo) {
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
	 * public static void getUnitValues(GenericDrugMstVO vo) { HisDAO dao =
	 * null; String strQuery = ""; int nQueryIndex = 0; WebRowSet web = null;
	 * try { dao = new HisDAO("MMS", "GenericDrugMstDAO");
	 * //System.out.println(" DAO vo.getStrModuleId()"+ vo.getStrModuleId());
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
	 * public static void getManufacturerValues(GenericDrugMstVO vo) { HisDAO
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
	 * public static void getItemValues(GenericDrugMstVO vo) { HisDAO dao =
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
	public static void getBrandItemDtl(GenericDrugMstVO vo) {
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
	public static void getSlNoBrandMst(GenericDrugMstVO vo) {
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
	public static void insertModifyBrandItem(GenericDrugMstVO vo,
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
	public static void view(GenericDrugMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {

			dao = new HisDAO("MMS", "GenericDrugMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.drug.11");
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
				vo.setStrExpiryDate(web.getString(5));
				vo.setStrShelfLife(web.getString(6));
				vo.setStrShelfTimeFormat(web.getString(7));
				vo.setStrStockMaintain(web.getString(8));

				vo.setStrPurchaseLeadTime(web.getString(9));
				vo.setStrTimeFormat(web.getString(10));
				vo.setStrConsumableType(web.getString(11));
				vo.setStrIsItemNarcotic(web.getString(12));
				vo.setStrRemarks(web.getString(13));
				vo.setStrEffectiveFrom(web.getString(14));
				vo.setStrIsValid(web.getString(15));
				vo.setStrConsentReq(web.getString(16));
				
				/*Aritra*/
				vo.setStrPregnancySafeFlag(web.getString(17));
				vo.setStrTrimester(web.getString(18));
				vo.setStrEffectsOnFoetus(web.getString(19));

			}
		} catch (Exception e) {
			e.printStackTrace();
			vo
					.setStrMsgString("GenericDrugMstDAO.view() --> "
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
	public static void getStockMaintainedValues(GenericDrugMstVO vo) {
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
	public static void getItemCodeRequired(GenericDrugMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("MMS", "GenericDrugMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.itemCatDtls.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
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

	public static void getSubgroupName(GenericDrugMstVO vo) {
		
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
	
	
	
public static void checkDataExists(GenericDrugMstVO vo,String[] chk) {
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

	
}
