/**
 * 
 */
package mms.masters.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.sql.rowset.WebRowSet;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;
import mms.MmsConfigUtil;
import mms.qryHandler_mms;
import mms.dao.ItemDAO;
import mms.masters.vo.DrugMstVO;
import mms.masters.vo.ItemMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemMstDAO.
 * 
 * @author user
 */
public class ItemMstDAO {
	
	/**
	 * for getting option value of combo on add page (store type name ).
	 * 
	 * @param vo the vo
	 */

	public static void initialAddQuery(ItemMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";
		try {
			dao = new HisDAO("mms", "ItemMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1,
					"select.itemBrandMstType.0");// Query for Item Type Name
													// Combo
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrItemCatNo());
			wb = dao.executeQry(nqryIndex);
			vo.setItemTypeWS(wb);

			strquery = mms.qryHandler_mms.getQuery(1,
					"select.itemBrandMstManuf.0");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrItemCatNo());
			wb = dao.executeQry(nqryIndex);
			vo.setManufacturerWS(wb);

			strquery = mms.qryHandler_mms.getQuery(1,"select.itemBrandMstRate.1");// Query For Unit Id
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrHospCode());
			//dao.setQryValue(nqryIndex, 2, vo.getStrInventoryUnitId());
			wb = dao.executeQry(nqryIndex);
			
			if(wb != null && wb.next()){
				
				vo.setStrRateUnitId(wb.getString(1));
				vo.setStrRateUnitName(wb.getString(2));
				
			}
			
			
			strquery = mms.qryHandler_mms.getQuery(1,
			"select.itemBrandMstGenItem.1");// Query for Generic Item Name Combo
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrItemCatNo());
			dao.setQryValue(nqryIndex, 2, vo.getStrGroupId().equalsIgnoreCase("")?"0":vo.getStrGroupId());
			dao.setQryValue(nqryIndex, 3, "100");
			wb = dao.executeQry(nqryIndex);
			
			vo.setWsGenericItems(wb);
			

		} catch (Exception e) {
			vo.setStrMsgString("ItemMstDAO.initialAddQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

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

/*	public static void chkDuplicate(ItemMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {

			dao = new HisDAO("mms", "ItemMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.itemBrandMst.2");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrItemName());
			dao.setQryValue(nqryIndex, 2, vo.getStrItemCatNo());
			dao.setQryValue(nqryIndex, 3, vo.getStrHospCode());

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
			vo.setStrMsgString("ItemMstDAO.chkDuplicate() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}	*/

	 public static void chkDuplicate(ItemMstVO vo) {
	      HisDAO dao = null;
	      int ncount = 0;
	      WebRowSet wb = null;
	      new String();
System.out.println("----------ItemMstDAO edited chkDuplicate()");
	      try {
	         dao = new HisDAO("mms", "ItemMstDAO");
	         String strquery = qryHandler_mms.getQuery(1, "select.itemBrandMst.2");		//new sql query file imported
	        System.out.println("Query for Duplicate value: "+strquery);	         
	         int nqryIndex = dao.setQuery(strquery);
	         dao.setQryValue(nqryIndex, 1, vo.getStrItemName());
	         dao.setQryValue(nqryIndex, 2, vo.getStrItemCatNo());
	         dao.setQryValue(nqryIndex, 3, vo.getStrHospCode());

	        for(wb = dao.executeQry(nqryIndex); wb.next(); ncount = Integer.parseInt(wb.getString(1))) 
	         {
	         
	         }

	         if (ncount == 0) {
	            vo.setBExistStatus(true);
	         } else {
	            vo.setBExistStatus(false);
	         }
	         
	         String strqry2= qryHandler_mms.getQuery(1, "select.itemBrandMst.duplicateList");
	         int yqryIndex= dao.setQuery(strqry2);
	         dao.setQryValue(yqryIndex, 1, vo.getStrItemName());
	         dao.setQryValue(yqryIndex, 2, vo.getStrItemCatNo());
	         dao.setQryValue(yqryIndex, 3, vo.getStrHospCode());
	         
	         wb = dao.executeQry(yqryIndex);
	         
	         vo.setDuplicateItemsWS(wb);
	         
	         
	      } catch (Exception var10) {
	         vo.setStrMsgString("ItemMstDAO.chkDuplicate() --> " + var10.getMessage());
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
	public static void insertQuery_ORG(ItemMstVO vo) {
		HisDAO dao = null;
		ItemDAO itemDao = null;
		String strQuery1 = "";
		int nQueryIndex1=0;
		WebRowSet web1 = null;
		String strTariffId = "";
		String strItemId="";

		try {
			itemDao = new ItemDAO();
			dao = new HisDAO("mms", "ItemMstDAO");
			MmsConfigUtil mmsConfigUtil=new MmsConfigUtil(vo.getStrHospiCode());
			
			System.out.println("------------ ItemMstDAO.insertQuery()-------------");
			
			strQuery1 = mms.qryHandler_mms.getQuery(1, "select.brandItem.1");
			nQueryIndex1 = dao.setQuery(strQuery1);
			dao.setQryValue(nQueryIndex1, 1,(vo.getStrHospCode()));
			dao.setQryValue(nQueryIndex1, 2, vo.getStrItemCatNo()); // /ITEM CATEGORY FOR item
			web1 = dao.executeQry(nQueryIndex1);
			if (web1.next()) {
				strItemId = web1.getString(1);
			}
			
			itemDao.setStrItemBrandId(strItemId);
			itemDao.setStrHospitalCode(vo.getStrHospCode());
			itemDao.setStrItemCatNO(vo.getStrItemCatNo());
			itemDao.setStrGenItemId(vo.getStrGenItemId().replace("^", "#").split("#")[0]);
			itemDao.setStrItemTypeId(vo.getStrItemTypeId().equalsIgnoreCase("")?"0":vo.getStrItemTypeId());
			itemDao.setStrItemName(vo.getStrItemName());
			itemDao.setStrManufacturerId(vo.getStrManufacturerId());
			itemDao.setStrDefaultRate(vo.getStrDefaultRate().equalsIgnoreCase("")?"0":vo.getStrDefaultRate());
			itemDao.setStrRateUnitId(vo.getStrRateUnitId());
			itemDao.setStrApprovedType(vo.getStrApprovedType());
			itemDao.setStrIssueType(vo.getStrIssueType());
			itemDao.setStrItemMake(vo.getStrItemMake());
			itemDao.setStrSparePartFlag(vo.getStrSparePartFlag().equalsIgnoreCase("")?"0":vo.getStrSparePartFlag());
			itemDao.setStrSetSachetFlag(vo.getStrSetSachetFlag().equalsIgnoreCase("")?"0":vo.getStrSetSachetFlag());
			itemDao.setStrIsQuantified(vo.getStrIsQuantified().equalsIgnoreCase("")?"0":vo.getStrIsQuantified());

			itemDao.setStrSeatId(vo.getStrSeatId());
			itemDao.setStrIsValid("1");
			itemDao.setStrSpecification(vo.getStrSpecification());
			itemDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			itemDao.setStrItemReservedFlag(vo.getStrItemType());
			itemDao.setStrItemCode(vo.getStrCPACode());
			
			itemDao.setStrItemClass("0");
			itemDao.setStrBatchnoReq(vo.getStrBatchNo());
			itemDao.setStrExpiryDateReq(vo.getStrExpiryDate());
			itemDao.setStrConsumableType(vo.getStrConsumableType());
			itemDao.setStrManufDate(vo.getStrManufDate());
			itemDao.setStrIsMisc(vo.getStrIsMisc());
			
			
			itemDao.setMAX_VALUE(vo.getMAX_VALUE());
			itemDao.setMIN_VALUE(vo.getMIN_VALUE());
			itemDao.setTEMP_SENS_FLAG(vo.getTEMP_SENS_FLAG());
			
			/*if(vo.getStrUploadFlag().equals("1"))
			{
				itemDao.setStrUploadFileId(vo.getStrUploadFileId());
				itemDao.setStrUploadFileName(vo.getStrUploadFileName());
			}	
			else
			{	*/
				itemDao.setStrUploadFileId("0");
				itemDao.setStrUploadFileName("");
			//}	
			if(vo.getStrSterilizationFlag().equals("1"))
			{	
				itemDao.setStrSterilizationFlag(vo.getStrSterilizationFlag());
				itemDao.setStrSterilizationLife(vo.getStrSterilizationLife());
			}
			else
			{
				itemDao.setStrSterilizationFlag(vo.getStrSterilizationFlag());
				itemDao.setStrSterilizationLife("0");
			}	
			itemDao.setStrHSNCode(vo.getStrHSNCode());
			itemDao.insert(dao);
			
			
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

			itemDao = null;

		}

	}
	
	/**
	 * Insert.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void insertQuery(ItemMstVO vo) 
	{
		HisDAO dao = null;
		String strProcName = "";
		int nProcIndex = 0;	
		
		try 
		{	
			/*
			System.out.println("<<--------------INSERT_ITEM---------------->>");		
			System.out.println(" getStrItemBrandId -->>"+vo.getStrItemBrandId());
			System.out.println(" getStrGenItemId -->>"+vo.getStrGenItemId());
			System.out.println(" getStrHospitalCode -->>"+vo.getStrHospCode());
			System.out.println(" getStrItemCatNO -->>"+vo.getStrItemCatNo());
		    System.out.println(" getStrItemTypeId-->>"+vo.getStrItemTypeId());
		    System.out.println(" getStrItemName -->>"+vo.getStrItemName());
			System.out.println(" getStrManufacturerId -->>"+vo.getStrManufacturerId());	
			System.out.println(" getStrDefaultRate -->>"+vo.getStrDefaultRate());
			System.out.println(" getStrRateUnitId -->>"+vo.getStrRateUnitId());
			System.out.println(" getStrApprovedType -->>"+vo.getStrApprovedType());
			System.out.println(" getStrIssueType -->>"+vo.getStrIssueType());
		    System.out.println(" getStrItemMake -->>"+vo.getStrItemMake());
			System.out.println(" getStrSparePartFlag -->>"+vo.getStrSparePartFlag());
		    System.out.println(" getStrSetSachetFlag -->>"+vo.getStrSetSachetFlag());
			System.out.println(" getStrIsQuantified -->>"+vo.getStrIsQuantified());
			System.out.println(" getStrSeatId -->>"+vo.getStrSeatId());
			System.out.println(" getStrIsValid -->>"+vo.getStrIsValid());
			System.out.println(" getStrSpecification -->>"+vo.getStrSpecification());
			System.out.println(" getStrEffectiveFrom -->>"+vo.getStrEffectiveFrom());
			System.out.println(" getStrItemReservedFlag -->>"+vo.getStrItemType());
			System.out.println(" getStrItemCode -->>"+vo.getStrCPACode());			
			System.out.println(" getStrUploadFileId -->>"+vo.getStrUploadFileId());
			System.out.println(" getStrUploadFileName -->>"+vo.getStrUploadFileName());		
			System.out.println(" getStrSterilizationFlag -->>"+vo.getStrSterilizationFlag());
			System.out.println(" getStrSterilizationLife -->>"+vo.getStrSterilizationLife());
			System.out.println(" getStrManufDate -->>"+vo.getStrManufDate());			
			System.out.println(" getMAX_VALUE -->>"+vo.getMAX_VALUE());
			System.out.println(" getMIN_VALUE --->>"+vo.getMIN_VALUE());
			System.out.println(" getTEMP_SENS_FLAG --->>"+vo.getTEMP_SENS_FLAG());
		*/
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yy");
			LocalDateTime now = LocalDateTime.now();
			//System.out.println("dtf.format(now)-->"+dtf.format(now));
			    dao = new HisDAO("MMS", "ItemMstDAO");		
			    

			    strProcName = "{call Pkg_Mms_Dml.dml_item_brand_mst(?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,? , ?,?,?,?,? , ?,?,?,?,?,? ,?)}"; // 36
				nProcIndex = dao.setProcedure(strProcName);
				dao.setProcInValue(nProcIndex, "modval", 			"1" ,1); 
				dao.setProcInValue(nProcIndex, "brand_id", 		    "0",2); 
				dao.setProcInValue(nProcIndex, "hosp_code", 		vo.getStrHospCode(),3); 
				dao.setProcInValue(nProcIndex, "ItemCatNO",		 	vo.getStrItemCatNo(),4);
				dao.setProcInValue(nProcIndex, "ItemTypeId", 		vo.getStrItemTypeId(),5);			
				dao.setProcInValue(nProcIndex, "ItemName", 			vo.getStrItemName(),6); 
				dao.setProcInValue(nProcIndex, "ManufacturerId", 	vo.getStrManufacturerId(),7); 
				dao.setProcInValue(nProcIndex, "DefaultRate", 		vo.getStrDefaultRate(),8); 
				dao.setProcInValue(nProcIndex, "RateUnitId", 		vo.getStrRateUnitId(),9); 
				dao.setProcInValue(nProcIndex, "ApprovedType", 		vo.getStrApprovedType(),10); 						
				dao.setProcInValue(nProcIndex, "IssueType", 		(vo.getStrIssueType()==null || vo.getStrIssueType().equals(""))?"0":vo.getStrIssueType(),11); 
				dao.setProcInValue(nProcIndex, "ItemMake",          vo.getStrItemMake().trim(),12); 
				dao.setProcInValue(nProcIndex, "SparePartFlag", 	vo.getStrSparePartFlag(),13);			
				dao.setProcInValue(nProcIndex, "SetSachetFlag", 	vo.getStrSetSachetFlag(),14); 			
				dao.setProcInValue(nProcIndex, "IsQuantified", 		vo.getStrIsQuantified(),15);
				dao.setProcInValue(nProcIndex, "SeatId",		    vo.getStrSeatId(),16); 	
				dao.setProcInValue(nProcIndex, "IsValid", 		    (vo.getStrIsValid()==null || vo.getStrIsValid().equals(""))?"1":vo.getStrIsValid(),17); 
				dao.setProcInValue(nProcIndex, "Specification", 	vo.getStrSpecification(),18); 
				dao.setProcInValue(nProcIndex, "ItemReservedFlag",  (vo.getStrBrandReserveFlag()==null || vo.getStrBrandReserveFlag().equals(""))?"1":vo.getStrBrandReserveFlag(),19); 
				dao.setProcInValue(nProcIndex, "ItemCode", 		    (vo.getStrCPACode()==null || vo.getStrCPACode().equals(""))?"0":vo.getStrCPACode(),20); 
				dao.setProcInValue(nProcIndex, "UploadFileId", 		"0",21); 
				dao.setProcInValue(nProcIndex, "UploadFileName", 	"NA",22); 
				dao.setProcInValue(nProcIndex, "SterilizationFlag", (vo.getStrSterilizationFlag()==null || vo.getStrSterilizationFlag().equals(""))?"0":vo.getStrSterilizationFlag(),23); 	
				dao.setProcInValue(nProcIndex, "SterilizationLife", (vo.getStrSterilizationLife()==null || vo.getStrSterilizationLife().equals(""))?"0":vo.getStrSterilizationLife(),24); 
				dao.setProcInValue(nProcIndex, "ConsumableType", 	(vo.getStrConsumableType()==null || vo.getStrConsumableType().equals(""))?"1":vo.getStrConsumableType(),25); 			
				dao.setProcInValue(nProcIndex, "BatchnoReq", 		"0",26); 			
				dao.setProcInValue(nProcIndex, "ExpiryDateReq", 	"0",27);
				dao.setProcInValue(nProcIndex, "ItemClass", 		vo.getStrEclCat(),28); //in place of ItemClass we are passing ECL checkbox value as vo.getStrEclCat()
				dao.setProcInValue(nProcIndex, "HSNCode", 			"0",29);			
				dao.setProcInValue(nProcIndex, "ManufDate", 		"0",30);
				dao.setProcInValue(nProcIndex, "IsMisc", 			"0",31);	
				
				dao.setProcInValue(nProcIndex, "MAX_VALUE", 		vo.getMAX_VALUE(),32);	
				dao.setProcInValue(nProcIndex, "MIN_VALUE", 		vo.getMIN_VALUE(),33);	
				dao.setProcInValue(nProcIndex, "TEMP_SENS_FLAG", 	vo.getTEMP_SENS_FLAG(),34);	
				//dao.setProcInValue(nProcIndex, "strEclCat", 	vo.getStrEclCat(),35);	
				dao.setProcInValue(nProcIndex, "item_id", 	        vo.getStrGenItemId().split("\\^")[0],35);	
			    
				dao.setProcInValue(nProcIndex, "SerialNo", 	        "0",36);	
				dao.setProcInValue(nProcIndex, "MACNo", 	        "0",37);
				dao.setProcInValue(nProcIndex, "loc", 	        	"0",38);
				dao.setProcInValue(nProcIndex, "WarrantyStartDate",	dtf.format(now),39);
				dao.setProcInValue(nProcIndex, "WarrantyUpTo", 	    "0",40);
				dao.setProcInValue(nProcIndex, "UnitId", 	        "0",41);
				dao.setProcOutValue(nProcIndex, "err", 				1,42);	
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
	
	
	public static void updateQuery(ItemMstVO vo) 
	{
		HisDAO dao = null;
		String strProcName = "";
		int nProcIndex = 0;
		try 
		{	
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yy");
			LocalDateTime now = LocalDateTime.now();
			
			System.out.println("<<--------------UPDATE_ITEM----Pkg_Mms_Dml.dml_item_brand_mst [ Mode - 2 ]------------>>");
			/*
			System.out.println(" getStrItemBrandId -->>"+vo.getStrItemBrandId());
			System.out.println(" getStrGenItemId -->>"+vo.getStrGenItemId());
			System.out.println(" getStrHospitalCode -->>"+vo.getStrHospCode());
			System.out.println(" getStrItemCatNO -->>"+vo.getStrItemCatNo());
		    System.out.println(" getStrItemTypeId-->>"+vo.getStrItemTypeId());
		    System.out.println(" getStrItemName -->>"+vo.getStrItemName());
			System.out.println(" getStrManufacturerId -->>"+vo.getStrManufacturerId());	
			System.out.println(" getStrDefaultRate -->>"+vo.getStrDefaultRate());
			System.out.println(" getStrRateUnitId -->>"+vo.getStrRateUnitId());
			System.out.println(" getStrApprovedType -->>"+vo.getStrApprovedType());
			System.out.println(" getStrIssueType -->>"+vo.getStrIssueType());
		    System.out.println(" getStrItemMake -->>"+vo.getStrItemMake());
			System.out.println(" getStrSparePartFlag -->>"+vo.getStrSparePartFlag());
		    System.out.println(" getStrSetSachetFlag -->>"+vo.getStrSetSachetFlag());
			System.out.println(" getStrIsQuantified -->>"+vo.getStrIsQuantified());
			System.out.println(" getStrSeatId -->>"+vo.getStrSeatId());
			System.out.println(" getStrIsValid -->>"+vo.getStrIsValid());
			System.out.println(" getStrSpecification -->>"+vo.getStrSpecification());
			System.out.println(" getStrEffectiveFrom -->>"+vo.getStrEffectiveFrom());
			System.out.println(" getStrItemReservedFlag -->>"+vo.getStrItemType());
			System.out.println(" getStrItemCode -->>"+vo.getStrCPACode());			
			System.out.println(" getStrUploadFileId -->>"+vo.getStrUploadFileId());
			System.out.println(" getStrUploadFileName -->>"+vo.getStrUploadFileName());		
			System.out.println(" getStrSterilizationFlag -->>"+vo.getStrSterilizationFlag());
			System.out.println(" getStrSterilizationLife -->>"+vo.getStrSterilizationLife());
			System.out.println(" getStrManufDate -->>"+vo.getStrManufDate());	
			*/		
			System.out.println(" getMAX_VALUE -->>"+vo.getMAX_VALUE());
			System.out.println(" getMIN_VALUE -->>"+vo.getMIN_VALUE());
			System.out.println(" getTEMP_SENS_FLAG -->>"+vo.getTEMP_SENS_FLAG());
			System.out.println(" getStrEclCat -->>"+vo.getStrEclCat());
			
			dao = new HisDAO("MMS", "DrugMstDAO");		
				
            
            strProcName = "{call Pkg_Mms_Dml.dml_item_brand_mst(?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,? , ?,?,?,?,? , ?,?,?,?,?,   ?,?)}"; // 42
            
			nProcIndex = dao.setProcedure(strProcName);
			dao.setProcInValue(nProcIndex, "modval", 			"2" ,1); 
			dao.setProcInValue(nProcIndex, "brand_id", 		    vo.getStrItemBrandId(),2); 
			dao.setProcInValue(nProcIndex, "hosp_code", 		vo.getStrHospCode(),3); 
			dao.setProcInValue(nProcIndex, "ItemCatNO",		 	vo.getStrItemCatNo(),4);
			dao.setProcInValue(nProcIndex, "ItemTypeId", 		vo.getStrItemTypeId(),5);			
			dao.setProcInValue(nProcIndex, "ItemName", 			vo.getStrItemName(),6); 
			dao.setProcInValue(nProcIndex, "ManufacturerId", 	vo.getStrManufacturerId(),7); 
			dao.setProcInValue(nProcIndex, "DefaultRate", 		vo.getStrDefaultRate(),8); 
			dao.setProcInValue(nProcIndex, "RateUnitId", 		vo.getStrRateUnitId(),9); 
			dao.setProcInValue(nProcIndex, "ApprovedType", 		vo.getStrApprovedType(),10); 						
			dao.setProcInValue(nProcIndex, "IssueType", 		(vo.getStrIssueType()==null || vo.getStrIssueType().equals(""))?"0":vo.getStrIssueType(),11); 
			dao.setProcInValue(nProcIndex, "ItemMake",          vo.getStrItemMake().trim(),12); 
			dao.setProcInValue(nProcIndex, "SparePartFlag", 	vo.getStrSparePartFlag(),13);			
			dao.setProcInValue(nProcIndex, "SetSachetFlag", 	vo.getStrSetSachetFlag(),14); 			
			dao.setProcInValue(nProcIndex, "IsQuantified", 		vo.getStrIsQuantified(),15);
			dao.setProcInValue(nProcIndex, "SeatId",		    vo.getStrSeatId(),16); 			
			dao.setProcInValue(nProcIndex, "IsValid", 		    vo.getStrIsValid(),17); 
			dao.setProcInValue(nProcIndex, "Specification", 	vo.getStrSpecification(),18); 
			dao.setProcInValue(nProcIndex, "ItemReservedFlag",  vo.getStrBrandReserveFlag(),19); 
			dao.setProcInValue(nProcIndex, "ItemCode", 		    (vo.getStrCPACode()==null || vo.getStrCPACode().equals(""))?"0":vo.getStrCPACode(),20); 
			dao.setProcInValue(nProcIndex, "UploadFileId", 		"0",21); 
			dao.setProcInValue(nProcIndex, "UploadFileName", 	"NA",22); 
			dao.setProcInValue(nProcIndex, "SterilizationFlag", vo.getStrSterilizationFlag(),23); 	
			dao.setProcInValue(nProcIndex, "SterilizationLife", vo.getStrSterilizationLife(),24); 
			dao.setProcInValue(nProcIndex, "ConsumableType", 	vo.getStrConsumableType(),25); 			
			dao.setProcInValue(nProcIndex, "BatchnoReq", 		"0",26); 			
			dao.setProcInValue(nProcIndex, "ExpiryDateReq", 	"0",27);
			dao.setProcInValue(nProcIndex, "ItemClass", 		vo.getStrEclCat(),28); //in place of ItemClass we are passing ECL checkbox value as vo.getStrEclCat()
			dao.setProcInValue(nProcIndex, "HSNCode", 			"0",29);			
			dao.setProcInValue(nProcIndex, "ManufDate", 		"0",30);
			dao.setProcInValue(nProcIndex, "IsMisc", 			"0",31);	
			
			dao.setProcInValue(nProcIndex, "MAX_VALUE", 		vo.getMAX_VALUE(),32);	
			dao.setProcInValue(nProcIndex, "MIN_VALUE", 		vo.getMIN_VALUE(),33);	
			dao.setProcInValue(nProcIndex, "TEMP_SENS_FLAG", 	vo.getTEMP_SENS_FLAG(),34);		
			//dao.setProcInValue(nProcIndex, "strEclCat", 	vo.getStrEclCat(),35);	

			dao.setProcInValue(nProcIndex, "item_id", 	        vo.getStrGenItemId().split("\\^")[0],35);			    
			dao.setProcInValue(nProcIndex, "SerialNo", 	        "0",36);	
			dao.setProcInValue(nProcIndex, "MACNo", 	        "0",37);
			dao.setProcInValue(nProcIndex, "loc", 	        	"0",38);
			dao.setProcInValue(nProcIndex, "WarrantyStartDate",	dtf.format(now),39);
			dao.setProcInValue(nProcIndex, "WarrantyUpTo", 	    "0",40);
			dao.setProcInValue(nProcIndex, "UnitId", 	        "0",41);
			dao.setProcOutValue(nProcIndex, "err", 				1,42);	
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
	 * retrieves and executes modify Query.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public static void modifyQuery(ItemMstVO vo) {

		HisDAO dao = new HisDAO("mms", "ItemMstDAO");

		int nqryIndex;
		String strquery = new String();

		try {

			strquery = mms.qryHandler_mms.getQuery(1, "select.itemBrandMst.3");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrItemBrandId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospCode());
//			dao.setQryValue(nqryIndex, 3, vo.getStrSerialNo());

			System.out.println("vo.getStrItemBrandId()------"+vo.getStrItemBrandId());
			System.out.println("vo.getStrHospCode()------"+vo.getStrHospCode());
			System.out.println("vo.getStrSerialNo()-----"+vo.getStrSerialNo());
			
			
			WebRowSet web = dao.executeQry(nqryIndex);
			if (web.next()) {

				vo.setStrItemCatNo(web.getString(1));
				vo.setStrGenItemId(web.getString(2));
				vo.setStrItemTypeId(web.getString(3));
				vo.setStrItemName(web.getString(4));
				vo.setStrManufacturerId(web.getString(5));
				vo.setStrDefaultRate(web.getString(6));

				vo.setStrRateUnitId(web.getString(7));
				vo.setStrInventoryUnitId(web.getString(8));
				vo.setStrApprovedType(web.getString(9));
				vo.setStrIssueType(web.getString(10));
				vo.setStrItemMake(web.getString(11));
				vo.setStrSparePartFlag(web.getString(12));
				vo.setStrSetSachetFlag(web.getString(13));
				vo.setStrIsQuantified(web.getString(14));
				vo.setStrSpecification(web.getString(15));
				vo.setStrEffectiveFrom(web.getString(16));
				vo.setStrIsValid(web.getString(17));
				vo.setStrNewCPACode(web.getString(18));
				vo.setStrGenItemName(web.getString(19));
				vo.setStrBrandReserveFlag(web.getString(20));
                vo.setStrSterilizationFlag(web.getString(21));
                vo.setStrSterilizationLife(web.getString(22));
                vo.setStrUploadFileId(web.getString(23));
                vo.setStrUploadFileName(web.getString(24));
                
                vo.setStrItemClass(web.getString(25));
                vo.setStrBatchNo(web.getString(26));
                vo.setStrExpiryDate(web.getString(27));
                vo.setStrConsumableType(web.getString(28));
                vo.setStrHSNCode(web.getString(29));
                vo.setStrManufDate(web.getString(30));
                vo.setStrIsMisc(web.getString(31));
                
                vo.setMAX_VALUE(web.getString(32));
                vo.setMIN_VALUE(web.getString(33));
                vo.setTEMP_SENS_FLAG(web.getString(34));
                vo.setStrEclCat(web.getString(35));
                
                  /*             
                
                System.out.println("web.getString(32)---------->"+web.getString(1));
                System.out.println("web.getString(33)---------->"+web.getString(2));
                System.out.println("web.getString(34)---------->"+web.getString(3)); 
                System.out.println("web.getString(32)---------->"+web.getString(4));
                System.out.println("web.getString(33)---------->"+web.getString(5));
                System.out.println("web.getString(34)---------->"+web.getString(6)); 
                System.out.println("web.getString(32)---------->"+web.getString(7));
                System.out.println("web.getString(33)---------->"+web.getString(8));
                System.out.println("web.getString(34)---------->"+web.getString(9)); 
                System.out.println("web.getString(32)---------->"+web.getString(10));
                System.out.println("web.getString(33)---------->"+web.getString(11));
                System.out.println("web.getString(34)---------->"+web.getString(12)); 
                System.out.println("web.getString(32)---------->"+web.getString(13));
                System.out.println("web.getString(33)---------->"+web.getString(14));
                System.out.println("web.getString(34)---------->"+web.getString(15)); 
                System.out.println("web.getString(32)---------->"+web.getString(16));
                System.out.println("web.getString(33)---------->"+web.getString(17));
                System.out.println("web.getString(34)---------->"+web.getString(18)); 
                System.out.println("web.getString(32)---------->"+web.getString(19));
                System.out.println("web.getString(33)---------->"+web.getString(20));
                System.out.println("web.getString(34)---------->"+web.getString(21)); 
                System.out.println("web.getString(32)---------->"+web.getString(22));
                System.out.println("web.getString(33)---------->"+web.getString(23));
                System.out.println("web.getString(34)---------->"+web.getString(24));
                System.out.println("web.getString(32)---------->"+web.getString(25));
                System.out.println("web.getString(33)---------->"+web.getString(26));
                System.out.println("web.getString(34)---------->"+web.getString(27));
                System.out.println("web.getString(33)---------->"+web.getString(28));
                System.out.println("web.getString(34)---------->"+web.getString(29)); 
                System.out.println("web.getString(32)---------->"+web.getString(30));
                System.out.println("web.getString(33)---------->"+web.getString(31));
                System.out.println("web.getString(34)---------->"+web.getString(32));
                System.out.println("web.getString(32)---------->"+web.getString(33));
                System.out.println("web.getString(33)---------->"+web.getString(34));
                */
                System.out.println("EDL or ECL--------->"+web.getString(35));
                
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo
					.setStrMsgString("ItemMstDAO.modifyQuery() --> "
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
	 * Check the Record weather data is Duplicate or not.
	 * 
	 * @param vo -
	 * FormBean Object
	 * 
	 * @return - true -record cannot be saved ,already exist false - record will
	 * save
	 * 
	 * @throws Exception 	 */
	public static void chkUpdateDuplicate(ItemMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {

			dao = new HisDAO("mms", "ItemMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.itemBrandMst.4");
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrItemName());
			dao.setQryValue(nqryIndex, 2, vo.getStrItemCatNo());
			dao.setQryValue(nqryIndex, 3, vo.getStrItemBrandId());
			dao.setQryValue(nqryIndex, 4, vo.getStrHospCode());

			wb = dao.executeQry(nqryIndex);
			while (wb.next()) {
				ncount = Integer.parseInt(wb.getString(1));
			}
			if (ncount == 0) {
				vo.setBExistStatus(false);
			} else {
				vo.setBExistStatus(true);
			}
		} catch (Exception e) {
			vo.setStrMsgString("ItemMstDAO.chkUpdateDuplicate() --> "
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
	 * @param vo the vo
	 */
	public static void updateQuery_ORG(ItemMstVO vo) {

		HisDAO dao = null;
		String strQuery1 = "";
		ItemDAO itemDao = null;
		int nQueryIndex1=0;
		WebRowSet web1 = null;
		String strTariffId = "";
		try {

			itemDao = new ItemDAO();
			dao = new HisDAO("mms", "ItemMstDAO");
			
			//itemDao.setStrSeatId(vo.getStrSeatId());					
			itemDao.setStrItemBrandId(vo.getStrItemBrandId());
			itemDao.setStrHospitalCode(vo.getStrHospCode());
			itemDao.setStrSerialNo(vo.getStrSerialNo());
			itemDao.update1(dao);	
			
			strQuery1 = mms.qryHandler_mms.getQuery(1, "select.drug.tariff");
			nQueryIndex1 = dao.setQuery(strQuery1);
			web1 = dao.executeQry(nQueryIndex1);
			if (web1.next()) {
				strTariffId = web1.getString(1);
				//System.out.println("strTariffId"+strTariffId);
			}
			/************************************************************************/
			itemDao.setStrTariffId(strTariffId);
			/*****************************************************************/
			/*
			System.out.println("--strTariffId-->>"+strTariffId);
			System.out.println("--Is Valid-->>"+vo.getStrIsValid());
			System.out.println("--getStrHospCode-->>"+vo.getStrHospCode());			
			System.out.println("--getStrHospCode-->>"+vo.getStrHospCode());
			System.out.println("--getStrItemCatNo-->>"+vo.getStrItemCatNo());
			System.out.println("--vo.getStrGenItemId()-->>"+vo.getStrGenItemId().replace("^", "#").split("#")[0]);
			System.out.println("--getStrItemTypeId-->>"+vo.getStrItemTypeId());
			System.out.println("--getStrItemName-->>"+vo.getStrItemName().replaceAll("\\s",""));
			System.out.println("--getStrManufacturerId-->>"+vo.getStrManufacturerId());
			System.out.println("--getStrDefaultRate-->>"+vo.getStrDefaultRate());
			System.out.println("--getStrRateUnitId-->>"+vo.getStrRateUnitId());
			System.out.println("--getStrApprovedType-->>"+vo.getStrApprovedType());
			System.out.println("--getStrIssueType-->>"+vo.getStrIssueType());
			System.out.println("--getStrItemMake-->>"+vo.getStrItemMake());			
			System.out.println("--getStrSparePartFlag-->>"+vo.getStrSparePartFlag());
			System.out.println("--getStrSetSachetFlag-->>"+vo.getStrSetSachetFlag());
			System.out.println("--getStrIsQuantified-->>"+vo.getStrIsQuantified());
			System.out.println("--getStrIsMisc-->>"+vo.getStrIsMisc());
			System.out.println("--getStrSeatId-->>"+vo.getStrSeatId());
			System.out.println("--getStrSpecification-->>"+vo.getStrSpecification());
			System.out.println("--getStrEffectiveFrom-->>"+vo.getStrEffectiveFrom());
			System.out.println("--getStrBrandReserveFlag-->>"+vo.getStrBrandReserveFlag());
			System.out.println("--getStrCPACode-->>"+vo.getStrCPACode());
			System.out.println("--getStrConsumableType-->>"+vo.getStrConsumableType());
			System.out.println("--getStrBatchNo-->>"+vo.getStrBatchNo());
			System.out.println("--getStrExpiryDate-->>"+vo.getStrExpiryDate());
			System.out.println("--getStrManufDate-->>"+vo.getStrManufDate());
			System.out.println("--getStrUploadFileId-->>"+vo.getStrUploadFileId());
			System.out.println("--getStrUploadFileName-->>"+vo.getStrUploadFileName());
			System.out.println("--getStrSterilizationFlag-->>"+vo.getStrSterilizationFlag());
			System.out.println("--getStrSterilizationLife-->>"+vo.getStrSterilizationLife());
			*/			
			itemDao.setStrHospitalCode(vo.getStrHospCode());
			itemDao.setStrItemCatNO(vo.getStrItemCatNo());
			itemDao.setStrGenItemId(vo.getStrGenItemId().replace("^", "#").split("#")[0]);
			itemDao.setStrItemTypeId(vo.getStrItemTypeId().equalsIgnoreCase("")?"0":vo.getStrItemTypeId());
			itemDao.setStrItemName(vo.getStrItemName().replaceAll("\\s",""));
			itemDao.setStrManufacturerId(vo.getStrManufacturerId());
			itemDao.setStrDefaultRate(vo.getStrDefaultRate().equalsIgnoreCase("")?"0":vo.getStrDefaultRate());			
			
			itemDao.setStrRateUnitId(vo.getStrRateUnitId());
			itemDao.setStrApprovedType(vo.getStrApprovedType());
			itemDao.setStrIssueType(vo.getStrIssueType());
			itemDao.setStrItemMake(vo.getStrItemMake());			
			
			itemDao.setStrSparePartFlag(vo.getStrSparePartFlag().equalsIgnoreCase("")?"0":vo.getStrSparePartFlag());
			itemDao.setStrSetSachetFlag(vo.getStrSetSachetFlag().equalsIgnoreCase("")?"0":vo.getStrSetSachetFlag());
			itemDao.setStrIsQuantified(vo.getStrIsQuantified().equalsIgnoreCase("")?"0":vo.getStrIsQuantified());
			itemDao.setStrIsMisc(vo.getStrIsMisc().equalsIgnoreCase("")?"0":vo.getStrIsMisc());		
			
			itemDao.setMAX_VALUE(vo.getMAX_VALUE());
			itemDao.setMIN_VALUE(vo.getMIN_VALUE());
			itemDao.setTEMP_SENS_FLAG(vo.getTEMP_SENS_FLAG());
			
			itemDao.setStrSeatId(vo.getStrSeatId());			
			itemDao.setStrIsValid(vo.getStrIsValid());
			itemDao.setStrSpecification(vo.getStrSpecification());
			itemDao.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			itemDao.setStrItemReservedFlag(vo.getStrBrandReserveFlag());
			
			
			itemDao.setStrItemCode(vo.getStrCPACode().equalsIgnoreCase("")?"0":vo.getStrCPACode());		
			itemDao.setStrConsumableType("0");
			itemDao.setStrBatchnoReq(vo.getStrBatchNo().equalsIgnoreCase("")?"0":vo.getStrBatchNo());			
			itemDao.setStrExpiryDateReq(vo.getStrExpiryDate().equalsIgnoreCase("")?"0":vo.getStrExpiryDate());
			itemDao.setStrItemClass("0");
			itemDao.setStrManufDate("0");
			//if(vo.getStrUploadFlag().equals("1"))
			//{
			//	itemDao.setStrUploadFileId(vo.getStrUploadFileId());
			//	itemDao.setStrUploadFileName(vo.getStrUploadFileName());
			//}	
			//else
			//{	
				itemDao.setStrUploadFileId("");
				itemDao.setStrUploadFileName("");
			//}	
			if(vo.getStrSterilizationFlag().equals("1"))
			{	
				itemDao.setStrSterilizationFlag(vo.getStrSterilizationFlag());
				itemDao.setStrSterilizationLife(vo.getStrSterilizationLife().equalsIgnoreCase("")?"0":vo.getStrSterilizationLife());
			}
			else
			{
				itemDao.setStrSterilizationFlag(vo.getStrSterilizationFlag());
				itemDao.setStrSterilizationLife("0");
			}	
			
			
			
		//	itemDao.update2(dao);
			itemDao.update(dao);
			//itemDao.insert3(dao);

			synchronized (dao) 
			{
				dao.fire();
			}

		} catch (Exception e) 
		{
			e.printStackTrace();
			vo
					.setStrMsgString("ItemMstDAO.updateQuery() --> "
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
	 * View.
	 * 
	 * @param vo the vo
	 */
	public static void view(ItemMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {

			dao = new HisDAO("MMS", "ItemMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "view.itemBrandMst.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrItemBrandId());
			dao.setQryValue(nQueryIndex, 2, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nQueryIndex, 3, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nQueryIndex, 4, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nQueryIndex, 5, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nQueryIndex, 6, vo.getStrSerialNo());
			web = dao.executeQry(nQueryIndex);
			if (web.next()) {
				vo.setStrItemTypeName(web.getString(1));
				vo.setStrItemName(web.getString(2));
				vo.setStrDefaultRate(web.getString(3));
				vo.setStrRateUnitName(web.getString(4));
				// vo.setStrInventoryUnitId(web.getString(5));
				vo.setStrManufacturerName(web.getString(5));
				vo.setStrApprovedTypeName(web.getString(6));

				vo.setStrIssueType(web.getString(7));
				vo.setStrItemMake(web.getString(8));
				vo.setStrSparePartFlag(web.getString(9));
				vo.setStrSetSachetFlag(web.getString(10));
				vo.setStrIsQuantified(web.getString(11));
				vo.setStrSpecification(web.getString(12));
				vo.setStrEffectiveFrom(web.getString(13));
				vo.setStrIsValid(web.getString(14));
				vo.setStrGenItemName(web.getString(15));
				vo.setStrGroupName(web.getString(16));
				vo.setStrItemCatName(web.getString(17));
				vo.setStrBrandReserveFlag(web.getString(18));
				vo.setStrCPACode(web.getString(19));

			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("ItemMstDAO.view() --> " + e.getMessage());
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
	public static void getItemCodeRequired(ItemMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("MMS", "GenericDrugMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.itemCatDtls.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrItemCatNo());
			web = dao.executeQry(nQueryIndex);
			
			if(web != null && web.next()){
				
				vo.setStrIsItemCodeRequired(web.getString(1));
				
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
			vo
					.setStrMsgString("ItemMstDAO.getItemCodeRequired() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			web = null;
		}
	}

	public static void setGenericItemCode(ItemMstVO vo) {
		HisDAO dao = null;
		String strQuery ;
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("MMS", "ItemMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.itembrand.genericitemCode.0");
			nQueryIndex = dao.setQuery(strQuery);
			
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrItemBrandId());
			dao.setQryValue(nQueryIndex, 3, vo.getStrHospCode());
			
			
			
			web = dao.executeQry(nQueryIndex);

			if (web.next()) {

				vo.setStrGenericItemCode(web.getString(1));

			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("ItemMstDAO.setGenericDrugCode() --> "
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
	
	public static void setApprovedType(ItemMstVO vo) {
		HisDAO dao = null;
		String strQuery ;
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			
			dao = new HisDAO("MMS", "ItemMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.itembrand.approvedType");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			web = dao.executeQry(nQueryIndex);
			vo.setWrsApprovedTypeOptions(web);
			
		} catch (Exception e) {
			
			vo.setStrMsgString("ItemMstDAO.setApprovedType() --> "
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
	
	public static void consumeCombo(ItemMstVO vo) {
		
		HisDAO dao = null;
		String strQuery ;
		int nQueryIndex = 0;
		WebRowSet web = null;
        try {
			
			dao = new HisDAO("MMS", "ItemMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.itembrand.ConsumeType");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrItemBrandId());
			dao.setQryValue(nQueryIndex, 2, vo.getStrInventoryUnitId());
			dao.setQryValue(nQueryIndex, 3, vo.getStrGenericItem());
			web = dao.executeQry(nQueryIndex);

			if (web.next()) {
				vo.setStrConsumableType(web.getString(1));
			}
			
		} catch (Exception e) {
			
			vo.setStrMsgString("ItemMstDAO.setConsumeComboValue() --> "
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

	
}
