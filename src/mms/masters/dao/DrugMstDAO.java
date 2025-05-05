package mms.masters.dao;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.dao.DrugBrandDAO;
import mms.masters.vo.DrugMstVO;
import mms.transactions.vo.ReturnFromTransVO;
import mms.transactions.vo.SupplierTransactionRecordVO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Anshul Jindal Version : 1.0 Date : 31/Jan/2009-May/09
 */

public class DrugMstDAO {
	
	/**
	 * Gets the item values.
	 * 
	 * @param vo
	 *            the vo
	 * 
	 * @return the item values
	 * 
	 * 
	 */
	public static void getCPACode(DrugMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("MMS", "DrugMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1,
					"select.drugbrand.cpaCode.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrGenericItemId());

			web = dao.executeQry(nQueryIndex);

			if (web.next()) {

				vo.setStrCPACode(web.getString(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DrugMstDAO.getCPACode() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if(dao != null) {
				dao.free();
			}
			dao = null;
			web = null;
		}
	}

	public static void getItemValues(DrugMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("MMS", "DrugMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1,
					"select.drugbrand.itemtype.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, "10");

			web = dao.executeQry(nQueryIndex);

			vo.setItemTypeWs(web);

		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("DrugMstDAO.getItemValues() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if(dao != null) {
				dao.free();
			}
			dao = null;
			web = null;
		}
	}

	public static void getGenericItemValues(DrugMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("MMS", "DrugMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1,
					"select.drugbrand.genitem.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, vo.getStrGroupId());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospitalCode());

			web = dao.executeQry(nQueryIndex);

			vo.setWsGenericItemValues(web);

		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("DrugMstDAO.getGenericItemValues() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if(dao != null) {
				dao.free();
			}
			dao = null;
			web = null;
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
	public static void getUnitValues(DrugMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("MMS", "DrugMstDAO");
			strQuery = mms.qryHandler_mms
					.getQuery(1, "select.drugbrand.unit.1");
			nQueryIndex = dao.setQuery(strQuery);

			//System.out.println("unit id is "+vo.getStrInventoryUnitId());
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrInventoryUnitId());

			web = dao.executeQry(nQueryIndex);

			/*
			 * This line of code is added by Aritra on 31st May, 2010 Reason: To
			 * get unit value combo.
			 */
			vo.setUnitValWs(web);

			if (web != null && web.next()) {
				vo.setStrRateUnitId(web.getString(1));
				vo.setStrRateUnitName(web.getString(2));

			}
			web.beforeFirst();// Aritra 31st May, 2010

		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("DrugMstDAO.getUnitValues() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if(dao != null) {
				dao.free();
			}
			dao = null;
			web = null;
		}
	}

	/**
	 * Gets the manufacturer values.
	 * 
	 * @param vo
	 *            the vo
	 * 
	 * @return the manufacturer values
	 */
	public static void getManufacturerValues(DrugMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("MMS", "DrugMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1,
					"select.drugbrand.manufacturer.4");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			web = dao.executeQry(nQueryIndex);
			vo.setManufacturerWs(web);
		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("DrugMstDAO.getManufacturerValues() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if(dao != null) {
				dao.free();
			}
			dao = null;
			web = null;
		}
	}

	/**
	 * Chk duplicate.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void chkDuplicate(DrugMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "DrugMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,"select.drugbrand.duplicate.1");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrDrugName());
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
			vo.setStrMsgString("DrugMstDAO.chkDuplicate() --> "
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
	 * Insert.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void insert_OLD(DrugMstVO vo) {
		HisDAO dao = null;
		DrugBrandDAO drugBrandDAO = null;
		String strQuery1 = "";
		int nQueryIndex1=0;
		WebRowSet web1 = null;
		String strTariffId = "";
		String strDrugId="";
		System.out.println("hospital code is "+vo.getHospCode());
		MmsConfigUtil mmsConfigUtil=new MmsConfigUtil(vo.getHospCode());

		try {
			drugBrandDAO = new DrugBrandDAO();

			dao = new HisDAO("MMS", "DrugMstDAO");
			
			strQuery1 = mms.qryHandler_mms.getQuery(1, "select.drugBrandId.7");
			nQueryIndex1 = dao.setQuery(strQuery1);
			dao.setQryValue(nQueryIndex1, 1,(vo.getStrHospitalCode()));
			dao.setQryValue(nQueryIndex1, 2, "10"); // /ITEM CATEGORY FOR DRUGS
			web1 = dao.executeQry(nQueryIndex1);
			if (web1.next()) {
				strDrugId = web1.getString(1);
			}
			System.out.println("strDrugId>>>>>>"+strDrugId);
			
		/*	strQuery1 = mms.qryHandler_mms.getQuery(1, "select.drug.tariff");
			nQueryIndex1 = dao.setQuery(strQuery1);
			web1 = dao.executeQry(nQueryIndex1);
			if (web1.next()) {
				strTariffId = web1.getString(1);
				System.out.println("strTariffId"+strTariffId);
			}
			drugBrandDAO.setStrItemBrandId(strDrugId);
			System.out.println("drugBrandDAO.setStrItemBrandId"+drugBrandDAO.getStrItemBrandId());*/
			
			
			//Added By VIKRANT Date 14-July-2015
			drugBrandDAO.setStrIsQuantifiable(vo.getStrIsQuantified());
			drugBrandDAO.setStrSetSachetFlag(vo.getStrIsSachet());
			drugBrandDAO.setStrBatchnoReq(vo.getStrBatchNo());
			drugBrandDAO.setStrExpiryDateReq(vo.getStrExpiryDate());
	        drugBrandDAO.setStrDrugClass(vo.getStrDrugClass());
			
			drugBrandDAO.setStrTariffId(strTariffId);
			drugBrandDAO.setStrHospitalCode(vo.getStrHospitalCode());
			drugBrandDAO.setStrItemCatNo(vo.getStrItemCatId());
			drugBrandDAO.setStrItemId(vo.getStrGenericItemId());
			drugBrandDAO.setStrHospitalCode(vo.getStrHospitalCode());
			drugBrandDAO.setStrItemCatNo(vo.getStrItemCatId());
			drugBrandDAO.setStrItemName(vo.getStrDrugName());
			drugBrandDAO.setStrManufacturerId(vo.getStrManufacturerId());
			drugBrandDAO.setStrDefaultRate(vo.getStrDefaultRate());
			drugBrandDAO.setStrRateUnitId(vo.getStrUnitId().split("\\^")[0]);
			drugBrandDAO.setStrApprovedType(vo.getStrApprovalType());
			drugBrandDAO.setStrIssueType(vo.getStrIssueType());
			drugBrandDAO.setStrSpecification(vo.getStrSpecification());
			drugBrandDAO.setStrItemMake(vo.getStrItemMake());
			drugBrandDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			drugBrandDAO.setStrSeatId(vo.getStrSeatId());
			drugBrandDAO.setStrIsValid(vo.getStrIsValid());
			drugBrandDAO.setStrSetSachetFlag(vo.getStrIsSachet());
			drugBrandDAO.setStrItemTypeId(vo.getStrItemType());
			drugBrandDAO.setStrIsQuantifiable(vo.getStrIsQuantified());
			drugBrandDAO.setStrCPACode(vo.getStrCPACode());
			drugBrandDAO.setStrItemReservedFlag(vo.getStrDrugType());
			drugBrandDAO.setStrConfigIssueRate(vo.getStrConfigIssueRate());
			drugBrandDAO.setStrQCType(vo.getStrQCType());//	Added By Vivek due to CRD by Ajay Gupta dated RAOL_DWH_27Dec2011
			
			/*System.out.println("vo.getStrMktRate()"+vo.getStrMktRate());
			System.out.println("vo.getStrMktRateUnitId()"+vo.getStrMktRateUnitId().split("\\^")[0]);*/
			
			drugBrandDAO.setStrMktRate(vo.getStrMktRate());
			drugBrandDAO.setStrMktRateUnitId(vo.getStrMktRateUnitId().split("\\^")[0]);
			drugBrandDAO.setStrGroupid(vo.getStrGroupId());
			drugBrandDAO.setStrHSNCode(vo.getStrHSNCode());
			drugBrandDAO.setStrEdlCat(vo.getStrEdlCat());
			drugBrandDAO.setStrIsMisc(vo.getStrIsMisc());
			drugBrandDAO.insert(dao);
			drugBrandDAO.setStrItemBrandId(strDrugId);
			
			
			System.out.println("billing integration is "+mmsConfigUtil.getStrBillingIntegration());
			
			//if(mmsConfigUtil.getStrBillingIntegration().equals("1"))
			//drugBrandDAO.insert2(dao);
			
			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {
			 e.printStackTrace();
			vo.setStrMsgString("DrugMstDAO.insert() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if(dao != null) {
				dao.free();
			}
			dao = null;
		}
	}
	
	
	
	/**
	 * Insert.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void insert(DrugMstVO vo) 
	{
		HisDAO dao = null;
		String strProcName = "";
		int nProcIndex = 0;
		int funcIndex;		
		try 
		{		
					
			System.out.println("getStrGenericItemId--DAO->"+vo.getStrGenericItemId()); //HSTNUM_ITEM_ID ^ GNUM_INVENTORY_UNITID ^ NVL(HSTSTR_CPA_CODE , 0 ) ^ HSTNUM_GROUP_ID ^ HSTNUM_SUBGROUP_ID
			System.out.println("getStrDrugName--->"+vo.getStrDrugName());
			System.out.println("getStrItemCatId--->"+vo.getStrItemCatId());
			System.out.println("getStrManufacturerId--->"+vo.getStrManufacturerId());			
			System.out.println("getStrDefaultRate--->"+vo.getStrDefaultRate());
			System.out.println("getStrRateUnitId--->"+vo.getStrUnitId());
			System.out.println("getStrApprovedType--->"+vo.getStrApprovalType());
			System.out.println("getStrIssueType--->"+vo.getStrIssueType());
			System.out.println("getStrSpecification--->"+vo.getStrSpecification());
			System.out.println("getStrItemMake--->"+vo.getStrItemMake());			
			System.out.println("getStrItemMake--->"+vo.getStrItemMake());
			System.out.println("getStrEffectiveFrom--->"+vo.getStrEffectiveFrom());
			System.out.println("getStrIsSachet--->"+vo.getStrIsSachet());
			System.out.println("getStrItemType--->"+vo.getStrItemType());
			System.out.println("getStrIsQuantified--->"+vo.getStrIsQuantified());
			System.out.println("getStrIsEDL--->"+vo.getStrEdlCat());
			System.out.println("getStrCPACode--->"+vo.getStrCPACode());		
			System.out.println("getStrDrugType--->"+vo.getStrDrugType());
			System.out.println("getStrConfigIssueRate--->"+vo.getStrConfigIssueRate());
			System.out.println("getStrQCType--->"+vo.getStrQCType());		
			System.out.println("getStrMktRateUnitId--->"+vo.getStrMktRateUnitId().split("\\^")[0]);
			System.out.println("getStrGroupId--->"+vo.getStrGroupId());			
			System.out.println("getStrInventoryUnitId--->"+vo.getStrInventoryUnitId());
			System.out.println("getStrIsMisc--->"+vo.getStrIsMisc());
			System.out.println("getStrIsMisc--->"+vo.getStrIsMisc());
			System.out.println("getStrBatchNo--->"+vo.getStrBatchNo());
			System.out.println("getStrExpiryDate--->"+vo.getStrExpiryDate());	
			System.out.println("StrIsValid1--->"+vo.getStrIsValid());			
			System.out.println("getMAX_VALUE--->"+vo.getMAX_VALUE());
			System.out.println("getMIN_VALUE--->"+vo.getMIN_VALUE());	
			System.out.println("StrTEMP_SENS_FLAG--->"+vo.getTEMP_SENS_FLAG());				
			
			dao = new HisDAO("MMS", "DrugMstDAO");		
				
            strProcName = "{call Pkg_Mms_Dml.dml_drug_brand_mst(?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?, ?,?)}"; // 32
            
			nProcIndex = dao.setProcedure(strProcName);
			dao.setProcInValue(nProcIndex, "modval", 			"1" ,1); 
			dao.setProcInValue(nProcIndex, "brand_id", 		    "0",2); 
			dao.setProcInValue(nProcIndex, "hosp_code", 		vo.getStrHospitalCode(),3); 
			dao.setProcInValue(nProcIndex, "catg_no",		 	vo.getStrItemCatId(),4);
			dao.setProcInValue(nProcIndex, "item_id", 			vo.getStrGenericItemId(),5); 
			dao.setProcInValue(nProcIndex, "drug_name", 		vo.getStrDrugName(),6); 
			dao.setProcInValue(nProcIndex, "mfg_id", 			vo.getStrManufacturerId(),7); 
			dao.setProcInValue(nProcIndex, "default_rate", 		vo.getStrDefaultRate(),8); 
			dao.setProcInValue(nProcIndex, "default_rate_unit", vo.getStrUnitId().split("\\^")[0],9); 
			dao.setProcInValue(nProcIndex, "app_type", 			vo.getStrApprovalType(),10); 
			dao.setProcInValue(nProcIndex, "issue_type", 		vo.getStrIssueType(),11); 
			dao.setProcInValue(nProcIndex, "drug_specification",vo.getStrSpecification().trim(),12); 
			dao.setProcInValue(nProcIndex, "item_make", 		vo.getStrItemMake(),13); 
			dao.setProcInValue(nProcIndex, "eff_from_date", 	vo.getStrEffectiveFrom(),14); 
			dao.setProcInValue(nProcIndex, "seat_id", 			vo.getStrSeatId(),15);
			dao.setProcInValue(nProcIndex, "StrIsValid",		vo.getStrIsValid(),16); 
			dao.setProcInValue(nProcIndex, "item_type", 		vo.getStrItemType(),17); 
			dao.setProcInValue(nProcIndex, "cpa_code", 			vo.getStrCPACode().replace("undefined","").trim(),18); 
			dao.setProcInValue(nProcIndex, "issue_rate", 		vo.getStrDefaultRate(),19); 
			dao.setProcInValue(nProcIndex, "qc_type", 		    (vo.getStrQCType()==null||vo.getStrQCType().equals(""))?"0":vo.getStrQCType(),20); 
			dao.setProcInValue(nProcIndex, "market_rate", 		(vo.getStrConfigIssueRate()==null||vo.getStrConfigIssueRate().equals(""))?"0":vo.getStrConfigIssueRate(),21); 
			dao.setProcInValue(nProcIndex, "market_rate_unit", 	vo.getStrUnitId().split("\\^")[0],22); 
			dao.setProcInValue(nProcIndex, "grp_id", 			(vo.getStrGroupId()==null||vo.getStrGroupId().equals(""))?"0":vo.getStrGroupId(),23); 	
			dao.setProcInValue(nProcIndex, "isbatchreq", 		vo.getStrBatchNo(),24); 
			dao.setProcInValue(nProcIndex, "isexpreq", 			vo.getStrExpiryDate(),25); 			
			dao.setProcInValue(nProcIndex, "edl_flg", 			vo.getStrEdlCat(),26); 
			dao.setProcInValue(nProcIndex, "hsncode", 			(vo.getStrHSNCode()==null||vo.getStrHSNCode().equals(""))?"0":vo.getStrHSNCode(),27); 
			dao.setProcInValue(nProcIndex, "ismisc",		    (vo.getStrIsMisc()==null||vo.getStrIsMisc().equals(""))?"0":vo.getStrIsMisc(),28); 
			dao.setProcInValue(nProcIndex, "MAX_VALUE", 		(vo.getMAX_VALUE()==null||vo.getMAX_VALUE().equals(""))?"0":vo.getMAX_VALUE(),29); 
			dao.setProcInValue(nProcIndex, "MIN_VALUE", 		(vo.getMIN_VALUE()==null||vo.getMIN_VALUE().equals(""))?"0":vo.getMIN_VALUE(),30); 
			dao.setProcInValue(nProcIndex, "TEMP_SENS_FLAG",	(vo.getTEMP_SENS_FLAG()==null||vo.getTEMP_SENS_FLAG().equals(""))?"0":vo.getTEMP_SENS_FLAG(),31);
			
			dao.setProcOutValue(nProcIndex, "err", 				1,32);	
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
	 * Modify.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void modify(DrugMstVO vo) 
	{
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try 
		{

			dao = new HisDAO("MMS", "DrugMstDAO");
			System.out.println("vo.getStrItemBrandId()------"+vo.getStrItemBrandId());
			System.out.println("vo.getStrHospitalCode()------"+vo.getStrHospitalCode());
			//System.out.println("vo.getStrSerialNo()------"+vo.getStrSerialNo());
			
			strQuery = mms.qryHandler_mms.getQuery(1,"select.drugbrand.modify.0");
			
			//System.out.println("strQuery------------>"+strQuery);
			
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrItemBrandId());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospitalCode());
			//dao.setQryValue(nQueryIndex, 3, "1,2");
			//dao.setQryValue(nQueryIndex, 3, vo.getStrSerialNo());
			web = dao.executeQry(nQueryIndex);

			if (web.next()) 
			{
				vo.setStrDrugName(web.getString(1));
				vo.setStrDefaultRate(web.getString(2));
				vo.setStrUnitId(web.getString(3));
				vo.setStrApprovalType(web.getString(4));
				vo.setStrManufacturerId(web.getString(5));
				vo.setStrIssueType(web.getString(6));
				
				vo.setStrIsSachet(web.getString(7));
				
				vo.setStrSpecification(web.getString(8));
				vo.setStrEffectiveFrom(web.getString(9));
				vo.setStrItemMake(web.getString(10));
				vo.setStrItemType(web.getString(11));
				
				vo.setStrIsValid(web.getString(12));
				vo.setStrIsQuantified(web.getString(13));
				
				/*
				 * This line of code is modified By Aritra on 31st May 2010.
				 * Reason: To extract item specific CPA No.
				 */
				/*if (vo.getStrCPACode() != null) {
					vo.setStrNewCPACode(web.getString(14).replace(
							vo.getStrCPACode(), ""));
				} else {
					vo.setStrNewCPACode(web.getString(14));
				}*/
				vo.setStrNewCPACode(web.getString(14));
				
				vo.setStrGenericItemName(web.getString(15));
				
				vo.setStrDrugType(web.getString(16));
				vo.setStrConfigIssueRate(web.getString(17));
				vo.setStrQCType(web.getString(18));//Added By Vivek due to CRD by Ajay Gupta dated RAOL_DWH_27Dec2011	
				
				vo.setStrMktRate(web.getString(19));
				
				
				vo.setStrMktRateUnitId(web.getString(20));
				vo.setStrGenericItemId(web.getString(21));
				vo.setStrRateBaseUnitId(web.getString(22));
				vo.setStrDrugClass(web.getString(23));
				
				vo.setStrBatchNo(web.getString(24));
				
				
				vo.setStrExpiryDate(web.getString(25));
				vo.setStrHSNCode(web.getString(26));
				vo.setStrEdlCat(web.getString(27));
				vo.setStrIsMisc(web.getString(28));
				vo.setStrGroupId(web.getString(29));
				
				vo.setMAX_VALUE(web.getString(30));
				vo.setMIN_VALUE(web.getString(31));
				vo.setTEMP_SENS_FLAG(web.getString(32));
				
				System.out.println("Max------"+web.getString(30));
				System.out.println("Min------"+web.getString(31));
				System.out.println("TEMP_Sen------"+web.getString(32));
				
				web.beforeFirst();
				
//				for(int i=1;i<web.size();i++)
//				{
//					if(web.next())
//					System.out.println("web.getString"+i+":"+web.getString(i));
//				}
//				
//				System.out.println("");
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DrugMstDAO.modify() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if(dao != null) {
				dao.free();
			}
			dao = null;
			web = null;
		}
	}
	
	

	/**
	 * Initial update query.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void initialUpdateQuery(DrugMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("mms", "DrugMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,"select.drugbrand.duplicate.2");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrDrugName());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrItemBrandId());
			//dao.setQryValue(nqryIndex, 4, vo.getStrSerialNo());
			/*
			 * System.out.println(""+vo.getStrDrugName());
			 * System.out.println(""+vo.getStrHospitalCode());
			 * System.out.println(""+vo.getStrItemBrandId());
			 */

			wb = dao.executeQry(nqryIndex);
			while (wb.next()) {
				ncount = Integer.parseInt(wb.getString(1));
			}
			if (ncount == 0) {
				vo.setBExistStatus(true);
			} else {
				vo.setBExistStatus(false);
			}
			// System.out.println("ncount----->"+ncount);
		} catch (Exception e) {
			vo.setStrMsgString("DrugMstDAO.initialUpdateQuery() --> "
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
	 * This function is used to update record during click of modify.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void update_org(DrugMstVO vo) {
		HisDAO dao = null;
		DrugBrandDAO drugBrandDAO = null;
		
		String strQuery1 = "";
		int nQueryIndex1=0;
		WebRowSet web1 = null;
		String strTariffId = "";
		

		try 
		{
			dao = new HisDAO("MMS", "DrugMstDAO");
			drugBrandDAO = new DrugBrandDAO();		
			
			
			System.out.println("getStrGenericItemId--->"+vo.getStrGenericItemId()); //HSTNUM_ITEM_ID ^ GNUM_INVENTORY_UNITID ^ NVL(HSTSTR_CPA_CODE , 0 ) ^ HSTNUM_GROUP_ID ^ HSTNUM_SUBGROUP_ID
			System.out.println("getStrDrugName--->"+vo.getStrDrugName());
			System.out.println("getStrItemCatId--->"+vo.getStrItemCatId());
			System.out.println("getStrManufacturerId--->"+vo.getStrManufacturerId());			
			System.out.println("getStrDefaultRate--->"+vo.getStrDefaultRate());
			System.out.println("getStrRateUnitId--->"+vo.getStrUnitId());
			System.out.println("getStrApprovedType--->"+vo.getStrApprovalType());
			System.out.println("getStrIssueType--->"+vo.getStrIssueType());									//Null Value
			System.out.println("getStrSpecification--->"+vo.getStrSpecification());
			System.out.println("getStrItemMake--->"+vo.getStrItemMake());			
			System.out.println("getStrItemMake--->"+vo.getStrItemMake());
			System.out.println("getStrEffectiveFrom--->"+vo.getStrEffectiveFrom());
			System.out.println("getStrIsSachet--->"+vo.getStrIsSachet());
			System.out.println("getStrItemType--->"+vo.getStrItemType());
			System.out.println("getStrIsQuantified--->"+vo.getStrIsQuantified());
			System.out.println("getStrIsEDL--->"+vo.getStrEdlCat());										//Null Value
			System.out.println("getStrCPACode--->"+vo.getStrCPACode());		
			System.out.println("getStrDrugType--->"+vo.getStrDrugType());
			System.out.println("getStrConfigIssueRate--->"+vo.getStrConfigIssueRate());
			System.out.println("getStrQCType--->"+vo.getStrQCType());		
			System.out.println("getStrMktRateUnitId--->"+vo.getStrMktRateUnitId().split("\\^")[0]);
			System.out.println("getStrGroupId--->"+vo.getStrGroupId());			
			System.out.println("getStrInventoryUnitId--->"+vo.getStrInventoryUnitId());						//Null Value
			System.out.println("getStrIsMisc--->"+vo.getStrIsMisc());
			System.out.println("getStrIsMisc--->"+vo.getStrIsMisc());
			System.out.println("getStrBatchNo--->"+vo.getStrBatchNo());
			System.out.println("getStrExpiryDate--->"+vo.getStrExpiryDate());	
			System.out.println("getStrItemBrandId--->"+vo.getStrItemBrandId());
			System.out.println("StrIsValid2--->"+vo.getStrIsValid());			
			
			drugBrandDAO.setStrSeatId(vo.getStrSeatId());	
			drugBrandDAO.setStrItemBrandId(vo.getStrItemBrandId());
			drugBrandDAO.setStrHospitalCode(vo.getStrHospitalCode());
			drugBrandDAO.setStrSerialNo("0");
			drugBrandDAO.update1(dao);
			
			
			strQuery1 = mms.qryHandler_mms.getQuery(1, "select.drug.tariff");
			nQueryIndex1 = dao.setQuery(strQuery1);
			web1 = dao.executeQry(nQueryIndex1);
			if (web1.next()) {
				strTariffId = web1.getString(1);
				System.out.println("strTariffId-->"+strTariffId);
			}
			/************************************************************************/
			drugBrandDAO.setStrTariffId(strTariffId);
			drugBrandDAO.setStrItemBrandId(vo.getStrItemBrandId());
			drugBrandDAO.setStrItemId(vo.getStrGenericItemId());
			drugBrandDAO.setStrHospitalCode(vo.getStrHospitalCode());			
			drugBrandDAO.setStrItemCatNo(vo.getStrItemCatId());
			drugBrandDAO.setStrItemName(vo.getStrDrugName());
			drugBrandDAO.setStrManufacturerId(vo.getStrManufacturerId());
			drugBrandDAO.setStrDefaultRate(vo.getStrDefaultRate());
			drugBrandDAO.setStrRateUnitId(vo.getStrUnitId());			
			drugBrandDAO.setStrApprovedType(vo.getStrApprovalType());
			drugBrandDAO.setStrIssueType((vo.getStrIssueType()==null || vo.getStrIssueType().equals(""))?"0":vo.getStrIssueType());			
			drugBrandDAO.setStrSpecification(vo.getStrSpecification());
			drugBrandDAO.setStrItemMake(vo.getStrItemMake());			
			drugBrandDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			drugBrandDAO.setStrSeatId(vo.getStrSeatId());
			drugBrandDAO.setStrIsValid(vo.getStrIsValid());			
			drugBrandDAO.setStrSetSachetFlag(vo.getStrIsSachet());
			drugBrandDAO.setStrItemTypeId(vo.getStrItemType());			
			drugBrandDAO.setStrIsQuantifiable(vo.getStrIsQuantified());
			drugBrandDAO.setStrCPACode(vo.getStrCPACode());			
			drugBrandDAO.setStrItemReservedFlag(vo.getStrDrugType());			
			drugBrandDAO.setStrConfigIssueRate(vo.getStrConfigIssueRate());
			drugBrandDAO.setStrQCType((vo.getStrQCType()==null || vo.getStrQCType().equals(""))?"0":vo.getStrQCType());//	Added By Vivek due to CRD by Ajay Gupta dated RAOL_DWH_27Dec2011
			drugBrandDAO.setStrMktRate(vo.getStrMktRate());
			drugBrandDAO.setStrMktRateUnitId(vo.getStrMktRateUnitId().split("\\^")[0]);				
			drugBrandDAO.setStrDrugClass(vo.getStrDrugClass());
			drugBrandDAO.setStrBatchnoReq(vo.getStrBatchNo());
			drugBrandDAO.setStrExpiryDateReq(vo.getStrExpiryDate());
			drugBrandDAO.setStrEdlCat((vo.getStrEdlCat()==null || vo.getStrEdlCat().equals(""))?"0":vo.getStrEdlCat());
			drugBrandDAO.setStrGroupid(vo.getStrGroupId());
			drugBrandDAO.setStrIsMisc(vo.getStrIsMisc());
			//drugBrandDAO.update2(dao);
			drugBrandDAO.insert1(dao);
			//drugBrandDAO.insert3(dao);

			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {
		    e.printStackTrace();
			vo.setStrMsgString("DrugMstDAO.update() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if(dao != null) {
				dao.free();
			}
			dao = null;

		}
	}
	
	
	public static void update(DrugMstVO vo) 
	{
		HisDAO dao = null;
		String strProcName = "";
		int nProcIndex = 0;
		try 
		{								
			System.out.println("getStrGenericItemId- UPDATE-->"+vo.getStrGenericItemId()); //HSTNUM_ITEM_ID ^ GNUM_INVENTORY_UNITID ^ NVL(HSTSTR_CPA_CODE , 0 ) ^ HSTNUM_GROUP_ID ^ HSTNUM_SUBGROUP_ID
			System.out.println("getStrDrugName--->"+vo.getStrDrugName());
			System.out.println("getStrItemCatId--->"+vo.getStrItemCatId());
			System.out.println("getStrManufacturerId--->"+vo.getStrManufacturerId());			
			System.out.println("getStrDefaultRate--->"+vo.getStrDefaultRate());
			System.out.println("getStrRateUnitId--->"+vo.getStrUnitId());
			System.out.println("getStrApprovedType--->"+vo.getStrApprovalType());
			System.out.println("getStrIssueType--->"+vo.getStrIssueType());
			System.out.println("getStrSpecification--->"+vo.getStrSpecification());
			System.out.println("getStrItemMake--->"+vo.getStrItemMake());			
			System.out.println("getStrItemMake--->"+vo.getStrItemMake());
			System.out.println("getStrEffectiveFrom--->"+vo.getStrEffectiveFrom());
			System.out.println("getStrIsSachet--->"+vo.getStrIsSachet());
			System.out.println("getStrItemType--->"+vo.getStrItemType());
			System.out.println("getStrIsQuantified--->"+vo.getStrIsQuantified());
			System.out.println("getStrIsEDL--->"+vo.getStrEdlCat());
			System.out.println("getStrCPACode--->"+vo.getStrCPACode());		
			System.out.println("getStrDrugType--->"+vo.getStrDrugType());
			System.out.println("getStrConfigIssueRate--->"+vo.getStrConfigIssueRate());
			System.out.println("getStrQCType--->"+vo.getStrQCType());		
			System.out.println("getStrMktRateUnitId--->"+vo.getStrMktRateUnitId().split("\\^")[0]);
			System.out.println("getStrGroupId--->"+vo.getStrGroupId());			
			System.out.println("getStrInventoryUnitId--->"+vo.getStrInventoryUnitId());
			System.out.println("getStrIsMisc--->"+vo.getStrIsMisc());
			System.out.println("getStrIsMisc--->"+vo.getStrIsMisc());
			System.out.println("getStrBatchNo--->"+vo.getStrBatchNo());
			System.out.println("getStrExpiryDate--->"+vo.getStrExpiryDate());	
			System.out.println("Brand Id--->"+vo.getStrItemBrandId());	
			System.out.println("StrIsValid3--->"+vo.getStrIsValid());
			
			System.out.println("getMAX_VALUE--->"+vo.getMAX_VALUE());
			System.out.println("getMIN_VALUE--->"+vo.getMIN_VALUE());	
			System.out.println("StrTEMP_SENS_FLAG--->"+vo.getTEMP_SENS_FLAG());
			
			dao = new HisDAO("MMS", "DrugMstDAO");		
				
            strProcName = "{call Pkg_Mms_Dml.dml_drug_brand_mst(?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?, ?,?)}"; // 32
            
			nProcIndex = dao.setProcedure(strProcName);
			dao.setProcInValue(nProcIndex, "modval", 			"2" ,1); 
			dao.setProcInValue(nProcIndex, "brand_id", 		    vo.getStrItemBrandId(),2); 
			dao.setProcInValue(nProcIndex, "hosp_code", 		vo.getStrHospitalCode(),3); 
			dao.setProcInValue(nProcIndex, "catg_no",		 	vo.getStrItemCatId(),4);
			dao.setProcInValue(nProcIndex, "item_id", 			vo.getStrGenericItemId(),5);			
			dao.setProcInValue(nProcIndex, "drug_name", 		vo.getStrDrugName(),6); 
			dao.setProcInValue(nProcIndex, "mfg_id", 			vo.getStrManufacturerId(),7); 
			dao.setProcInValue(nProcIndex, "default_rate", 		vo.getStrDefaultRate(),8); 
			dao.setProcInValue(nProcIndex, "default_rate_unit", vo.getStrUnitId().split("\\^")[0],9); 
			dao.setProcInValue(nProcIndex, "app_type", 			vo.getStrApprovalType(),10); 
			dao.setProcInValue(nProcIndex, "issue_type", 		(vo.getStrIssueType()==null || vo.getStrIssueType().equals(""))?"0":vo.getStrIssueType(),11); 
			dao.setProcInValue(nProcIndex, "drug_specification",vo.getStrSpecification().trim(),12); 
			dao.setProcInValue(nProcIndex, "item_make", 		vo.getStrItemMake(),13);			
			dao.setProcInValue(nProcIndex, "eff_from_date", 	vo.getStrEffectiveFrom(),14); 			
			dao.setProcInValue(nProcIndex, "seat_id", 			vo.getStrSeatId(),15);
			dao.setProcInValue(nProcIndex, "StrIsValid",		vo.getStrIsValid(),16); 			
			dao.setProcInValue(nProcIndex, "item_type", 		vo.getStrItemType(),17); 
			dao.setProcInValue(nProcIndex, "cpa_code", 			vo.getStrCPACode(),18); 
			dao.setProcInValue(nProcIndex, "issue_rate", 		vo.getStrDefaultRate(),19); 
			dao.setProcInValue(nProcIndex, "qc_type", 		    (vo.getStrQCType()==null || vo.getStrQCType().equals(""))?"0":vo.getStrQCType(),20); 
			dao.setProcInValue(nProcIndex, "market_rate", 		vo.getStrConfigIssueRate(),21); 
			dao.setProcInValue(nProcIndex, "market_rate_unit", 	vo.getStrUnitId().split("\\^")[0],22); 
			dao.setProcInValue(nProcIndex, "grp_id", 			vo.getStrGroupId(),23); 	
			dao.setProcInValue(nProcIndex, "isbatchreq", 		"1",24); 
			dao.setProcInValue(nProcIndex, "isexpreq", 			"1",25); 			
			dao.setProcInValue(nProcIndex, "edl_flg", 			(vo.getStrEdlCat()==null || vo.getStrEdlCat().equals(""))?"0":vo.getStrEdlCat(),26); 
			dao.setProcInValue(nProcIndex, "hsncode", 			vo.getStrHSNCode(),27); 
			dao.setProcInValue(nProcIndex, "ismisc",		    vo.getStrIsMisc(),28); 		
			
			dao.setProcInValue(nProcIndex, "MAX_VALUE", 			vo.getMAX_VALUE(),29); 
			dao.setProcInValue(nProcIndex, "MIN_VALUE", 			vo.getMIN_VALUE(),30); 
			dao.setProcInValue(nProcIndex, "TEMP_SENS_FLAG",		vo.getTEMP_SENS_FLAG(),31);
			
			
			dao.setProcOutValue(nProcIndex, "err", 				1,32);	
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
	 * View.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void view(DrugMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {

			dao = new HisDAO("MMS", "DrugMstDAO");
			strQuery = mms.qryHandler_mms
					.getQuery(1, "select.drugbrand.view.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrItemBrandId());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 3, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 4, vo.getStrHospitalCode());
			web = dao.executeQry(nQueryIndex);
			if (web.next()) {

				vo.setStrDrugName(web.getString(1));
				vo.setStrDefaultRate(web.getString(2));
				vo.setStrUnit(web.getString(3));
				vo.setStrApprovedTypeName(web.getString(4));
				vo.setStrManufacturer(web.getString(5));
				vo.setStrIssueType(web.getString(6));
				vo.setStrIsSachet(web.getString(7));
				vo.setStrSpecification(web.getString(8));
				vo.setStrEffectiveFrom(web.getString(9));
				vo.setStrItemMake(web.getString(10));
				vo.setStrItemType(web.getString(11));
				vo.setStrIsValid(web.getString(12));
				vo.setStrIsQuantified(web.getString(13));
				/*
				 * This line is added by Aritra on 31st May, 2010 to set the CPA
				 * Code in vo.
				 */
				vo.setStrCPACode(web.getString(14));
				vo.setStrGenericItemName(web.getString(15));
				vo.setStrGroupName(web.getString(16));
				vo.setStrConfigIssueRate(web.getString(17));
				vo.setStrQCType(web.getString(18));//	Added By Vivek due to CRD by Ajay Gupta dated RAOL_DWH_27Dec2011
				
				vo.setStrMktRate(web.getString(19));
				vo.setStrMktRateUnitId(web.getString(20));
				vo.setStrEdlCat(web.getString(21));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("DrugMstDAO.view() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if(dao != null) {
				dao.free();
			}
			dao = null;
			web = null;
		}
	}

	/**
	 * Gets the Flag Item Code Required
	 * 
	 * @param vo
	 *            the vo
	 * 
	 * @return the Flag Item Code Required
	 */
	public static void getItemCodeRequired(DrugMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("MMS", "GenericDrugMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.itemCatDtls.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nQueryIndex, 2, "10");
			web = dao.executeQry(nQueryIndex);

			if (web != null && web.next()) {

				vo.setStrIsItemCodeRequired(web.getString(1));

			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("GenericDrugMstDAO.getItemCodeRequired() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if(dao != null) {
				dao.free();
			}
			dao = null;
			web = null;
		}
	}

	public static void setGenericDrugCode(DrugMstVO vo) {
		HisDAO dao = null;
		String strQuery ;
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("MMS", "DrugMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.drugbrand.genericDrugCode.0");
			nQueryIndex = dao.setQuery(strQuery);
			
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrItemBrandId());
			dao.setQryValue(nQueryIndex, 3, vo.getStrHospitalCode());
			
			
			
			web = dao.executeQry(nQueryIndex);

			if (web.next()) {

				vo.setStrGenericDrugCode(web.getString(1));

			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DrugMstDAO.setGenericDrugCode() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if(dao != null) {
				dao.free();
			}
			dao = null;
			web = null;
		}
		
	}

	public static void setApprovedType(DrugMstVO vo) {
		HisDAO dao = null;
		String strQuery ;
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			
			dao = new HisDAO("MMS", "DrugMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.drugbrand.approvedType");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			web = dao.executeQry(nQueryIndex);
			vo.setWrsApprovedTypeOptions(web);
			
		} catch (Exception e) {
			
			vo.setStrMsgString("DrugMstDAO.setApprovedType() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if(dao != null) {
				dao.free();
			}
			dao = null;
			web = null;
		}
		
	}
	
	public static void getIssueType(DrugMstVO vo) 
	{
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("MMS", "DrugMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1,"select.drugbrand.issuetype.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());

			web = dao.executeQry(nQueryIndex);

			vo.setIssueTypeWs(web);

		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("DrugMstDAO.getItemValues() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		}
		finally 
		{
			if(dao != null) 
			{
				dao.free();
			}
			dao = null;
			web = null;
		}
	}
	
	
	/**
	 * Gets the unit name combo.
	 * 
	 * @param vo the vo
	 * 
	 * @return the unit name combo
	 */
	public static void getUnitNameComboBasedOnItemId(DrugMstVO vo) 
	{
		String strFuncName = "";
		String strProcName = "";

		int nFuncIndex = 0;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;
		String strUnitRate = "";

		try 
		{
			daoObj = new HisDAO("MMS", "MmsDAO");
			strFuncName = "{? = call Mms_Mst.get_inventory_unitId(?, ?, ?, ? )}"; 
			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}"; 

			
			System.out.println(vo.getStrGenericItemId());

			
			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, "1");
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 4, vo.getStrItemCatId());
			daoObj.setFuncInValue(nFuncIndex, 5, (vo.getStrGenericItemId().replace("^","#").split("#")[0]).equals("") ? "0" : vo.getStrGenericItemId().replace("^","#").split("#")[0]);
			daoObj.setFuncOutValue(nFuncIndex, 3);
			
			daoObj.executeFuncForNumeric(nFuncIndex);
			
			strUnitRate = daoObj.getFuncNumeric(nFuncIndex).toString();
			vo.setStrUnitId(strUnitRate);

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),1);
			daoObj.setProcInValue(nProcIndex, "unit_id", "6301",2);
			daoObj.setProcInValue(nProcIndex, "module_id","63",3);			
			daoObj.setProcInValue(nProcIndex, "modeval", "1",4);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
			
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			
			if (strErr.equals("")) 
			{
				vo.setWsUnitList(ws);
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("DrugMstDAO.getUnitNameComboBasedOnItemId() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * Gets the unit name combo.
	 * 
	 * @param vo the vo
	 * 
	 * @return the unit name combo
	 */
	public static void getModifyUnitNameComboBasedOnItemId(DrugMstVO vo) {
		String strFuncName = "";
		String strProcName = "";

		int nFuncIndex = 0;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;
		String strUnitRate = "";

		try {

			daoObj = new HisDAO("Mms Global", "MmsDAO");
			strFuncName = "{? = call Mms_Mst.get_inventory_unitId(?, ?, ?, ? )}"; //5
			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}"; //5+1=6
			
			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, "1");
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 4, vo.getStrItemCatId());
			daoObj.setFuncInValue(nFuncIndex, 5, vo.getStrInventoryUnitId());
			daoObj.setFuncOutValue(nFuncIndex, 3);
			//altered by anshul n 23 jan 2013 for postges 
			daoObj.executeFuncForNumeric(nFuncIndex);
			
			strUnitRate = daoObj.getFuncNumeric(nFuncIndex).toString();
			vo.setStrUnitId(strUnitRate);

//			System.out.println("StrUnitId"+vo.getStrUnitId());
			
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),1);
			daoObj.setProcInValue(nProcIndex, "unit_id", vo.getStrInventoryUnitId(),2);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1",4);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
			
			/* Start Adding Default value*/
			daoObj.setProcInValue(nProcIndex, "module_id", "",3);
			/* End Adding Default value*/
			
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {

				vo.setWsUnitList(ws);

			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DrugInventoryTrans.getModifyUnitNameComboBasedOnItemId() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	
	

public static void checkDataExists(DrugMstVO vo,String[] chk) {
	int nqryIndex = 0;
	int ncount = 0;
	WebRowSet wb = null;
	String strquery = new String();
	System.out.println(chk[0].replace("@", "#").split("#")[0]+" "+vo.getStrHospitalCode());
	HisDAO dao = null;

	try {
		
		
		dao = new HisDAO("mms", "DrugMstDAO");
		strquery = mms.qryHandler_mms.getQuery(1,"select.suppliermstitembrandid.0");
		nqryIndex = dao.setQuery(strquery);
		dao.setQryValue(nqryIndex, 1, chk[0].replace("@", "#").split("#")[0]);
		dao.setQryValue(nqryIndex, 2, MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
		wb = dao.executeQry(nqryIndex);
		while (wb.next()) {
			ncount = Integer.parseInt(wb.getString(1));
			System.out.println(ncount);
		}
		if (ncount == 0) {

			vo.setBExistStatus(false);
		} else {
			vo.setBExistStatus(true);
		}
		
		if(vo.getBExistStatus() == true)
		{
			ncount=0;
			dao = new HisDAO("mms", "DrugMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,"select.storeitembrandid.0");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, chk[0].replace("@", "#").split("#")[0]);
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			wb = dao.executeQry(nqryIndex);
			while (wb.next()) {
				ncount = Integer.parseInt(wb.getString(1));
				System.out.println(ncount);
			}
			
			if(ncount == 1)
			{
				dao = new HisDAO("mms", "DrugMstDAO");
				strquery = mms.qryHandler_mms.getQuery(1,"select.storedruginventorybrandid.0");
				nqryIndex = dao.setQuery(strquery);
				dao.setQryValue(nqryIndex, 1, chk[0].replace("@", "#").split("#")[0]);
				dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
				wb = dao.executeQry(nqryIndex);
				while (wb.next()) {
					ncount = Integer.parseInt(wb.getString(1));
					System.out.println(ncount);
				}
			}
			
			if(ncount == 1)
			{
				dao = new HisDAO("mms", "DrugMstDAO");
				strquery = mms.qryHandler_mms.getQuery(1,"select.tariffmstbrandid.0");
				nqryIndex = dao.setQuery(strquery);
				dao.setQryValue(nqryIndex, 1, chk[0].replace("@", "#").split("#")[0]);
				dao.setQryValue(nqryIndex, 2, MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
				wb = dao.executeQry(nqryIndex);
				while (wb.next()) {
					ncount = Integer.parseInt(wb.getString(1));
					System.out.println(ncount);
				}
				
			}
			
			
			
		}
		
		if(ncount == 1)
		{
			vo.setBExistStatus(true);
		}
		else
		{
			vo.setBExistStatus(false);
			DrugMstDAO.updateDelete(dao,chk);
			
			
		}
		
		
		

	} catch (Exception e) {
		e.printStackTrace();
		vo.setStrMsgString("billing.DRUGMSTDAO.deleteData -->" + e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		dao.free();
		dao = null;
	}
}


public static void updateDelete(HisDAO dao,String [] chk)
{
	
		String strquery = "";
		int nqryIndex = 0;
		try 
		{

			// System.out.println("dao update");
			strquery = mms.qryHandler_mms.getQuery(1,"update.deletedrugmstdata.0");
			nqryIndex = dao.setQuery(strquery);
			System.out.println(chk[0].replace("@", "#").split("#")[0]+" "+MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			dao.setQryValue(nqryIndex, 1, chk[0].replace("@", "#").split("#")[0]);
			dao.setQryValue(nqryIndex, 2, MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			dao.execute(nqryIndex,0);
			
			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	
}
public static void getDrugClass(DrugMstVO vo) {
	HisDAO dao = null;
	String strQuery = "";
	int nQueryIndex = 0;
	WebRowSet web = null;
	try {
		dao = new HisDAO("MMS", "DrugMstDAO");
		strQuery = mms.qryHandler_mms.getQuery(1,
				"select.drug.class");
		nQueryIndex = dao.setQuery(strQuery);


		web = dao.executeQry(nQueryIndex);

		vo.setDrugClassWs(web);

	} catch (Exception e) {
		// e.printStackTrace();
		vo.setStrMsgString("DrugMstDAO.getDrugClass() --> "
				+ e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		if(dao != null) {
			dao.free();
		}
		dao = null;
		web = null;
	}
}
public static void checkDrugDuplicacy(DrugMstVO vo) {
	String proc_name1 = "{call pkg_mms_view2.Proc_Validate_Cpa_Code_Data(?,?,?,?, ?,?,?,?)}"; // 7

	HisDAO dao = null;
	int procIndex1 = 0;
	String err = "";
	WebRowSet ws = null;
	try {

		dao = new HisDAO("mms", "DrugMstDAO");

		procIndex1 = dao.setProcedure(proc_name1);

		dao.setProcInValue(procIndex1, "modeval", vo.getStrModeVal(), 1);
		dao.setProcInValue(procIndex1, "drug_name", (vo.getStrDrugName()==null || vo.getStrDrugName().isEmpty()?"0": vo.getStrDrugName()), 2);
		dao.setProcInValue(procIndex1, "item_brand_id", (vo.getStrItemBrandId()==null || vo.getStrItemBrandId().isEmpty()?"0": vo.getStrItemBrandId()), 3);
		dao.setProcInValue(procIndex1, "item_id", (vo.getStrGenericItemId()==null || vo.getStrGenericItemId().isEmpty()?"0": vo.getStrGenericItemId()), 4);
		dao.setProcInValue(procIndex1, "cpa_code", (vo.getStrNewCPACode()==null || vo.getStrNewCPACode().isEmpty()?"-": vo.getStrNewCPACode()), 5);
		dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(), 6);
		dao.setProcOutValue(procIndex1, "err", 1, 7);
		dao.setProcOutValue(procIndex1, "resultset", 2, 8);
		dao.executeProcedureByPosition(procIndex1);

		err = dao.getString(procIndex1, "err");
		if (err == null)
			err = "";

		if (err.equals("")) {
			ws = dao.getWebRowSet(procIndex1, "resultset");
			vo.setDrugClassWs(ws);
		     System.out.println("DAO--CHECKDRUGDUPLICACY--SIZE-->" + vo.getDrugClassWs().size());
		} else {
			throw new Exception(err);
		}
	} catch (Exception e) {
		vo.setStrMsgString("DrugMstDAO.checkDrugDuplicacy() --> " + e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		if (dao != null) {
			dao.free();
			dao = null;
		}
	}
}


}

