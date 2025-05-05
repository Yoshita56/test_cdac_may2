/**
 * 
 */
package mms.transactions.dao;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.global.dao.ItemParameterDetailDAO;
import mms.transactions.vo.ItemInventorySurgicalTransVO;

/**
 * @author pankaj
 * 
 */

/**
 * ( NOT INSERTING CORRECT VALUES, MODIFY/UPDATE WAS NOT WORKING AND SUBGROUP
 * SHOULD NOT BE MANDATORY ON ADD) Developer : Anshul Jindal ( TO CONTINUE AND
 * CORRECTIONS ) Version : 1.0 Date : 21/Apr/2009
 * 
 */
public class ItemInventorySurgicalTransDAO {
	/**
	 * for getting option value of combo on add page (subgroup name )
	 * 
	 * 
	 */

	public static void initAddQuery(ItemInventorySurgicalTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "ItemInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_store_subgroup_list(?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "1",1);
			dao.setProcInValue(nprocIndex, "group_id", vo.getStrGroupId(),2);
			dao
					.setProcInValue(nprocIndex, "hosp_code", vo
							.getStrHospitalCode(),3);
			dao.setProcOutValue(nprocIndex, "err", 1,4);
			dao.setProcOutValue(nprocIndex, "resultset", 2,5);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");

			if (strerr.equals("")) {
				vo.setStrSubGroupComboWs(wb);

			} else {
				throw new Exception(strerr);
			}

			strproc_name = "{call PKG_MMS_VIEW.proc_storeitem_list(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "1",1);
			dao.setProcInValue(nprocIndex, "cat_no", vo.getStrItemCategoryNo(),4);
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId(),2);
			dao.setProcInValue(nprocIndex, "group_id", vo.getStrGroupId(),5);
			dao
					.setProcInValue(nprocIndex, "hosp_code", vo
							.getStrHospitalCode(),7);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nprocIndex, "item_id", "0",3);
			dao.setProcInValue(nprocIndex, "sub_group_id", "0",6);
			/* Setting Default Value End */
			
			dao.setProcOutValue(nprocIndex, "err", 1,8);
			dao.setProcOutValue(nprocIndex, "resultset", 2,9);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");

			if (strerr.equals("")) {
				vo.setStrItemNameComboWS(wb);

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			vo.setStrMsgString("ItemInventoryTransDAO.initAddQuery() --> "
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
	 * The following procedure is used to populate the value of Item Name combo
	 * using Pkg_Mms_View.proc_storeitem_list procedure.
	 * 
	 * 
	 */

	public static void getItemName(ItemInventorySurgicalTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "ItemInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_storeitem_list(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			
			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcInValue(nprocIndex, "group_id", vo.getStrGroupId(),5);
			dao.setProcInValue(nprocIndex, "sub_group_id", vo
					.getStrSubGroupId(),6);
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId(),2);
			dao.setProcInValue(nprocIndex, "cat_no", vo.getStrItemCategoryNo(),4);
			dao
					.setProcInValue(nprocIndex, "hosp_code", Config.SUPER_USER_HOSPITAL_CODE,7);
			
			dao.setProcInValue(nprocIndex, "item_id", "0",3); //Default value.
			
			dao.setProcOutValue(nprocIndex, "err", 1,8);
			dao.setProcOutValue(nprocIndex, "resultset", 2,9);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");
//System.out.println("size of item:::  "+wb.size());
			if (strerr.equals("")) {
				vo.setStrItemNameComboWS(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("ItemInventoryTransDAO.getItemName() --> "
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
	 * The following procedure is used to populate the value of ItemBrand Name
	 * combo using Pkg_Mms_View.proc_itembrand_list procedure.
	 * 
	 * 
	 */

	public static void getItemBrandName(ItemInventorySurgicalTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "ItemInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_storeitem_list(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "2",1);
			dao.setProcInValue(nprocIndex, "item_id", vo.getStrItemId(),3);
			dao.setProcInValue(nprocIndex, "group_id", vo.getStrGroupId(),5);
			dao.setProcInValue(nprocIndex, "sub_group_id", vo
					.getStrSubGroupId(),6);
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId(),2);
			dao.setProcInValue(nprocIndex, "cat_no", vo.getStrItemCategoryNo(),4);
			dao
					.setProcInValue(nprocIndex, "hosp_code", Config.SUPER_USER_HOSPITAL_CODE,7);
			dao.setProcOutValue(nprocIndex, "err", 1,8);
			dao.setProcOutValue(nprocIndex, "resultset", 2,9);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");

			if (strerr.equals("")) {
				vo.setStrItemBrandComboWS(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("ItemInventoryTransDAO.getItemBrandName() --> "
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
	 * The following procedure is used to populate the value of Supplier Name
	 * combo using Pkg_Mms_View.proc_supplier_list procedure.
	 * 
	 * 
	 */

	public static void getSuppliedByList(ItemInventorySurgicalTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "ItemInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "1",1);
			dao
					.setProcInValue(nprocIndex, "catCode", vo
							.getStrItemCategoryNo(),2);
			dao
					.setProcInValue(nprocIndex, "hosp_code", vo
							.getStrHospitalCode(),5);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nprocIndex, "branditem_id", "0",3);
			dao.setProcInValue(nprocIndex, "contractType", "0",4);
			/* Setting Default Value End */
			
			dao.setProcOutValue(nprocIndex, "err", 1,6);
			dao.setProcOutValue(nprocIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {
				// //System.out.println("DAO -->" + wb.size());
				vo.setStrManufactureComboWS(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo
					.setStrMsgString("ItemInventoryTransDAO.getSuppliedByList() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getWarrantyManufList(ItemInventorySurgicalTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "ItemInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "1",1);
			dao
					.setProcInValue(nprocIndex, "catCode", vo
							.getStrItemCategoryNo(),2);
			dao
					.setProcInValue(nprocIndex, "hosp_code", vo
							.getStrHospitalCode(),5);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nprocIndex, "branditem_id", "0",3);
			dao.setProcInValue(nprocIndex, "contractType", "0",4);
			/* Setting Default Value End */
			
			dao.setProcOutValue(nprocIndex, "err", 1,6);
			dao.setProcOutValue(nprocIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {
				// //System.out.println("DAO -->" + wb.size());
				vo.setStrWarrantyManufactureComboWS(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo
					.setStrMsgString("ItemInventoryTransDAO.getWarrantyManufList() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getCurrencyList(ItemInventorySurgicalTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "ItemInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_currency_list(?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "1",1);
			dao
					.setProcInValue(nprocIndex, "hosp_code", vo
							.getStrHospitalCode(),2);
			dao.setProcInValue(nprocIndex, "isDefault", "0",3);//Default Value
			dao.setProcOutValue(nprocIndex, "err", 1,4);
			dao.setProcOutValue(nprocIndex, "resultset", 2,5);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {

				vo.setStrCurrencyCodeWs(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("ItemInventoryTransDAO.getCurrencyList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getStockStatusList(ItemInventorySurgicalTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "ItemInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_stock_status_list(?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao
					.setProcInValue(nprocIndex, "hosp_code", vo
							.getStrHospitalCode(),2);
			dao.setProcInValue(nprocIndex, "itemCat", "",3); // Default Value
			dao.setProcInValue(nprocIndex, "itemBrandId", "0",4);
			dao.setProcOutValue(nprocIndex, "err", 1,5);
			dao.setProcOutValue(nprocIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {

				vo.setStrStockStatusWs(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo
					.setStrMsgString("ItemInventoryTransDAO.getStockStatusList() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getmanufectuteName(ItemInventorySurgicalTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "6",1);
			dao
					.setProcInValue(nprocIndex, "catCode", vo
							.getStrItemCategoryNo(),2);
			dao.setProcInValue(nprocIndex, "branditem_id", vo
					.getStrItemBrandId(),3);
			dao
					.setProcInValue(nprocIndex, "hosp_code", vo
							.getStrHospitalCode(),5);
			dao.setProcInValue(nprocIndex, "contractType", "0",4); //Aritra
			dao.setProcOutValue(nprocIndex, "err", 1,6);
			dao.setProcOutValue(nprocIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {
				 //System.out.println("DAO -->" + wb.size());
				vo.setStrManufactureComboWS(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo
					.setStrMsgString("itemInventory.getmanufectuteName() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	
	public static void getBrandDetails(ItemInventorySurgicalTransVO vo) {

		 
		HisDAO dao = null;
	  
		try {
			
			dao = new HisDAO("mms", "ItemInventoryTransDAO");
			
			String strFuncName = "{? = call mms_mst.get_brand_ResFlag(?::numeric, ?::numeric, ?::numeric)}";
			
			int nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrItemBrandId());
			dao.setFuncOutValue(nFuncIndex,1);
			dao.executeFuncForNumeric(nFuncIndex);
			
			String strRegFlag = dao.getFuncNumeric(nFuncIndex).toString();
			
			vo.setStrRegFlag(strRegFlag);
			
			
			String strFuncName2 = "{? = call mms_mst.get_brand_dtl(?::numeric, ?::numeric, ?::numeric)}";
			
			int nFuncIndex2 = dao.setFunction(strFuncName2);
			dao.setFuncInValue(nFuncIndex2, 2, "1");
			dao.setFuncInValue(nFuncIndex2, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex2, 4, vo.getStrItemBrandId());
			dao.setFuncOutValue(nFuncIndex2, 1);
			dao.executeFunction(nFuncIndex2);
			
			String strBrandDetails = dao.getFuncString(nFuncIndex2);
			
			vo.setStrBrandDetails(strBrandDetails);
			
		} catch (Exception e) {
			e.printStackTrace();
			vo
					.setStrMsgString("ItemInventoryTransDAO.getBrandDetails() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	
	public static void insert(ItemInventorySurgicalTransVO vo) {

		String strProcName = "";
		String strProcName2 = "";
		String strProcName3 = "";
		String strProcName4 = "";
		String strProcName5 = "";

		int nProcIndex = 0;
		int nProcIndex2 = 0;
		int nProcIndex3 = 0;
		int nProcIndex4 = 0;
		int nProcIndex5 = 0;

		HisDAO daoObj = null;
		ItemParameterDetailDAO itemParameterDetailDAO = null;
		try {
			daoObj = new HisDAO("MMS", "ItemInventoryTransDAO");
			itemParameterDetailDAO = new ItemParameterDetailDAO();

			//strProcName = "{call PKG_MMS_DML.Dml_Stock_Update(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			
			strProcName = "{call PKG_MMS_DML.Dml_Stock_Update(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // 54 Variable
			nProcIndex = daoObj.setProcedure(strProcName);

			
			
			daoObj.setProcInValue(nProcIndex, "modval", "1",1);               //1
			daoObj.setProcInValue(nProcIndex, "strid", vo.getStrStoreId(),2); //2
			daoObj.setProcInValue(nProcIndex, "itemid", vo.getStrItemId(),3); //3
			daoObj.setProcInValue(nProcIndex, "itembrandid", vo.getStrItemBrandId(),4);//4
			daoObj.setProcInValue(nProcIndex, "batchno", vo.getStrBatchNo(),5); //5
			daoObj.setProcInValue(nProcIndex, "itemcatno", vo.getStrItemCategoryNo(),6);    //6
			daoObj.setProcInValue(nProcIndex, "groupid", vo.getStrGroupId(),7);             //7
			daoObj.setProcInValue(nProcIndex, "subgroupid", vo.getStrSubGroupId(),8);  //8 
			//System.out.println("expirydate"+ vo.getStrExpiryDate());
			daoObj.setProcInValue(nProcIndex, "expirydate", vo.getStrExpiryDate(),9);  //9
			daoObj.setProcInValue(nProcIndex, "manufdate", vo.getStrManufactureDate(),10); //10
			daoObj.setProcInValue(nProcIndex, "stockstatuscode", vo.getStrStockStatus(),11); //11
			daoObj.setProcInValue(nProcIndex, "inventoryflag", "0",12); //12
			daoObj.setProcInValue(nProcIndex, "inhandqty", vo.getStrInHandQuantity(),13);//13
			daoObj.setProcInValue(nProcIndex, "inhandqtyunitid", vo.getStrInHandQuantityUnitID(),14);//14
			daoObj.setProcInValue(nProcIndex, "suppid", vo.getStrManufactureId(),15); //15
			////System.out.println("Supplied ID(Inv DAO 15)==>"+vo.getStrManufactureId());
			daoObj.setProcInValue(nProcIndex, "rate", vo.getStrRate(),16); //16
			////System.out.println("In Save Rate:::::"+vo.getStrRate());
			////System.out.println("In Save Sale Price::::"+vo.getStrSalePrice());
			////System.out.println("Rate Unit ID==>"+vo.getStrUnitRateID());
			////System.out.println("Sale Unit ID==>"+vo.getStrUnitSaleID());
			daoObj.setProcInValue(nProcIndex, "rateunitid", vo.getStrUnitRateID(),17); //17
			daoObj.setProcInValue(nProcIndex, "saleprice", vo.getStrSalePrice(),18); //18
			daoObj.setProcInValue(nProcIndex, "salepriceunitid", vo.getStrUnitSaleID(),19); //19
			daoObj.setProcInValue(nProcIndex, "pono", vo.getStrPoNo(),20); //20
			daoObj.setProcInValue(nProcIndex, "podate", vo.getStrPoDate(),21); //21
			daoObj.setProcInValue(nProcIndex, "seatid", vo.getStrSeatId(),22); //24
			
			daoObj.setProcInValue(nProcIndex, "suppliedBy", vo.getStrSuppliedBy(),23); //22
			
			////System.out.println("Supplied By(Inv DAO 22)==>"+vo.getStrSuppliedBy());
			daoObj.setProcInValue(nProcIndex, "recievedDate", vo.getStrReceivedDate(),24); //23
			daoObj.setProcInValue(nProcIndex, "currencyCode", vo.getStrCurrencyCode(),25); //27
			
			if (vo.getStrItemOtherDtls() != null && vo.getStrItemOtherDtls().length > 0) 
			{
				daoObj.setProcInValue(nProcIndex, "freeItemFlag", "1",26);  //30
			} 
			else 
			{
				daoObj.setProcInValue(nProcIndex, "freeItemFlag", "0",26); //30
			}
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),27); //25
			daoObj.setProcInValue(nProcIndex, "currencyValue", vo.getStrCurrencyValue(),28); //28
			daoObj.setProcInValue(nProcIndex, "old_stockstatuscode", "1",29); //33
			daoObj.setProcInValue(nProcIndex, "old_batchno", "0",30);   //34
			daoObj.setProcInValue(nProcIndex, "old_itemSerialNo", "0",31); //35
			daoObj.setProcInValue(nProcIndex, "old_itemid", "0",32);  //36
			daoObj.setProcInValue(nProcIndex, "old_itembrandid", "0",33); //37
			daoObj.setProcInValue(nProcIndex, "old_strid", "0",34);  //38
		
			if (vo.getStrItemParamDtls() != null
					&& vo.getStrItemParamDtls().length > 0) {

				daoObj.setProcInValue(nProcIndex, "itemParamFlag", "1",35);

			} else {

				daoObj.setProcInValue(nProcIndex, "itemParamFlag", "0",35);
			}
			
			if (vo.getStrItemPartDtls() != null
					&& vo.getStrItemPartDtls().length > 0) {

				daoObj.setProcInValue(nProcIndex, "partFlag", "1",36);

			} else {

				daoObj.setProcInValue(nProcIndex, "partFlag", "0",36);
			}
	
			if ("1".equals(vo.getStrIsWarrantyDetails())) {

				daoObj.setProcInValue(nProcIndex, "warrentyFlag", "1",37);

			} else {

				daoObj.setProcInValue(nProcIndex, "warrentyFlag", "0",37);
			}
			daoObj.setProcInValue(nProcIndex, "toStrId", "",38); //42
			daoObj.setProcInValue(nProcIndex, "reservedFlag", "0",39); //43
			daoObj.setProcInValue(nProcIndex, "transNo", "0",40); //44
			daoObj.setProcInValue(nProcIndex, "transDate", "",41); //45
			daoObj.setProcInValue(nProcIndex, "description","Through Item Inventory Process",42); //26
			
			daoObj.setProcInValue(nProcIndex, "reqTypeId", "58",43); //46
			daoObj.setProcInValue(nProcIndex, "blockQtyFlag", "0",44); //47
			daoObj.setProcInValue(nProcIndex, "blockedQty", "0",45);   //48
			daoObj.setProcInValue(nProcIndex, "blockedQtyUnitId", "0",46); //49
			daoObj.setProcInValue(nProcIndex, "releaseQty", "0",47);  //50
			daoObj.setProcInValue(nProcIndex, "releaseQtyUnitId", "0",48); //51
		
			
		
			daoObj.setProcInValue(nProcIndex, "item_specification", vo.getStrItemSpecification(),52); //29
			

			daoObj.setProcInValue(nProcIndex, "invoiceNo", vo.getStrBillNo(),49); //31
			daoObj.setProcInValue(nProcIndex, "invoiceDate", vo.getStrBillDate(),50); //32
			/* Start */
			
			daoObj.setProcInValue(nProcIndex, "item_serialNoFlag", "1",51); //52
			/* End */

			daoObj.setProcOutValue(nProcIndex, "err", 1,54);   //53
			daoObj.setProcOutValue(nProcIndex, "retSerialNo", 1,53); //54

			daoObj.execute(nProcIndex, 1);

			
			/*
			daoObj.setProcInValue(nProcIndex, "modval", "1");
			daoObj.setProcInValue(nProcIndex, "strid", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "itemid", vo.getStrItemId());
			daoObj.setProcInValue(nProcIndex, "itembrandid", vo
					.getStrItemBrandId());
			daoObj.setProcInValue(nProcIndex, "batchno", vo.getStrBatchNo());
			daoObj.setProcInValue(nProcIndex, "itemcatno", vo
					.getStrItemCategoryNo());
			daoObj.setProcInValue(nProcIndex, "groupid", vo.getStrGroupId());
			daoObj.setProcInValue(nProcIndex, "subgroupid", vo
					.getStrSubGroupId());
			daoObj.setProcInValue(nProcIndex, "expirydate", vo
					.getStrExpiryDate());
			daoObj.setProcInValue(nProcIndex, "manufdate", vo
					.getStrManufactureDate());
			daoObj.setProcInValue(nProcIndex, "stockstatuscode", vo
					.getStrStockStatus());
			daoObj.setProcInValue(nProcIndex, "inventoryflag", "0");
			daoObj.setProcInValue(nProcIndex, "inhandqty", vo
					.getStrInHandQuantity());
			daoObj.setProcInValue(nProcIndex, "inhandqtyunitid", vo
					.getStrInHandQuantityUnitID());
			daoObj.setProcInValue(nProcIndex, "suppid", vo
					.getStrManufactureId());
			daoObj.setProcInValue(nProcIndex, "rate", vo.getStrRate());
			daoObj.setProcInValue(nProcIndex, "rateunitid", vo
					.getStrUnitRateID());
			daoObj
					.setProcInValue(nProcIndex, "saleprice", vo
							.getStrSalePrice());
			daoObj.setProcInValue(nProcIndex, "salepriceunitid", vo
					.getStrUnitSaleID());
			daoObj.setProcInValue(nProcIndex, "pono", vo.getStrPoNo());
			daoObj.setProcInValue(nProcIndex, "podate", vo.getStrPoDate());
			daoObj.setProcInValue(nProcIndex, "suppliedBy", vo
					.getStrSuppliedBy());
			daoObj.setProcInValue(nProcIndex, "recievedDate", vo
					.getStrReceivedDate());
			daoObj.setProcInValue(nProcIndex, "seatid", vo.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo
					.getStrHospitalCode());

			daoObj.setProcInValue(nProcIndex, "description",
					"Through Item Inventory Process");

			daoObj.setProcInValue(nProcIndex, "currencyCode", vo
					.getStrCurrencyCode());
			daoObj.setProcInValue(nProcIndex, "currencyValue", vo
					.getStrCurrencyValue());

			daoObj.setProcInValue(nProcIndex, "item_specification", vo.getStrItemSpecification());
			
			
			
			if (vo.getStrItemOtherDtls() != null
					&& vo.getStrItemOtherDtls().length > 0) {

				daoObj.setProcInValue(nProcIndex, "freeItemFlag", "1");

			} else {

				daoObj.setProcInValue(nProcIndex, "freeItemFlag", "0");
			}

			if (vo.getStrItemPartDtls() != null
					&& vo.getStrItemPartDtls().length > 0) {

				daoObj.setProcInValue(nProcIndex, "partFlag", "1");

			} else {

				daoObj.setProcInValue(nProcIndex, "partFlag", "0");
			}

			
			 * Commented by Aritra on July 07, 2010. 
			 * Reason: WarrentyFlag is being set to 0 all the time. 			
			if (vo.getStrWarrantyFlag().equals("1")) {

				daoObj.setProcInValue(nProcIndex, "warrentyFlag", "1");

			} else {

				daoObj.setProcInValue(nProcIndex, "warrentyFlag", "0");
			}
			
			
			 * Added by Aritra to solve above mentioned problem.
			 
			if ("1".equals(vo.getStrIsWarrantyDetails())) {

				daoObj.setProcInValue(nProcIndex, "warrentyFlag", "1");

			} else {

				daoObj.setProcInValue(nProcIndex, "warrentyFlag", "0");
			}

			
			 * Commented by Aritra on July 07, 2010. 
			 * Reason: itemParamFlag is being set to 0 all the time. 
			if (vo.getStrItemParamDtls() != null
					&& vo.getStrItemParamDtls().length > 0) {

				daoObj.setProcInValue(nProcIndex, "itemParamFlag", "1");

			} else {

				daoObj.setProcInValue(nProcIndex, "itemParamFlag", "0");
			}
			
			
			 * Added by Aritra to solve above mentioned problem.
			 
			if (vo.getStrParamCheck() != null
					&& vo.getStrParamCheck().length > 0) {

				daoObj.setProcInValue(nProcIndex, "itemParamFlag", "1");

			} else {

				daoObj.setProcInValue(nProcIndex, "itemParamFlag", "0");
			}
			
			
			 daoObj.setProcInValue(nProcIndex, "invoiceNo",vo.getStrBillNo());                 
			 daoObj.setProcInValue(nProcIndex, "invoiceDate",vo.getStrBillDate());
			 
			  Setting Default Value Start
			 daoObj.setProcInValue(nProcIndex, "old_stockstatuscode", "1");
			 daoObj.setProcInValue(nProcIndex, "old_batchno", "0");
			 daoObj.setProcInValue(nProcIndex, "old_itemSerialNo", "0");
			 daoObj.setProcInValue(nProcIndex, "old_itemid", "0");
			 daoObj.setProcInValue(nProcIndex, "old_itembrandid", "0");
			 daoObj.setProcInValue(nProcIndex, "old_strid", "0");
			 daoObj.setProcInValue(nProcIndex, "toStrId", "");
			 daoObj.setProcInValue(nProcIndex, "reservedFlag", "0");
			 daoObj.setProcInValue(nProcIndex, "transNo", "0");
			 daoObj.setProcInValue(nProcIndex, "transDate", "");
			 daoObj.setProcInValue(nProcIndex, "reqTypeId", "0");
			 daoObj.setProcInValue(nProcIndex, "blockQtyFlag", "0");
			 daoObj.setProcInValue(nProcIndex, "blockedQty", "0");
			 daoObj.setProcInValue(nProcIndex, "blockedQtyUnitId", "0");
			 daoObj.setProcInValue(nProcIndex, "releaseQty", "0");
			 daoObj.setProcInValue(nProcIndex, "releaseQtyUnitId", "0");
			 daoObj.setProcInValue(nProcIndex, "item_serialNoFlag", "1");
			  Setting Default Value End 
			 
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "retSerialNo", 1);

			daoObj.execute(nProcIndex, 1);
*/
			strProcName2 = "{call PKG_MMS_DML.Dml_Hstt_Free_Items_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			if (vo.getStrItemOtherDtls() != null && vo.getStrItemOtherDtls().length > 0)
				for (int i = 0; i < vo.getStrItemOtherDtls().length; i++) 
				{

					String strTemp = vo.getStrItemOtherDtls()[i];
					String[] strItemOtherVal = strTemp.replace("^", "#").split(
							"#");

					nProcIndex2 = daoObj.setProcedure(strProcName2);

					daoObj.setProcInValue(nProcIndex2, "modval", "1");
					daoObj.setProcInValue(nProcIndex2, "itemid", vo
							.getStrItemId());
					daoObj.setProcInValue(nProcIndex2, "itembrandid", vo
							.getStrItemBrandId());
					daoObj.setProcInValue(nProcIndex2, "batchno", vo
							.getStrBatchNo());
					daoObj.setProcInValue(nProcIndex2, "freeitemid",
							strItemOtherVal[1]);
					daoObj.setProcInValue(nProcIndex2, "freeitembrandid",
							strItemOtherVal[2]);
					
					if(strItemOtherVal[3] != null && strItemOtherVal[3].length() != 0){
						
						daoObj.setProcInValue(nProcIndex2, "freeitembatchno",
								strItemOtherVal[3]);
					}else{
						daoObj.setProcInValue(nProcIndex2, "freeitembatchno",
								"0");
					}
					
					
					daoObj.setProcInValue(nProcIndex2, "freeitemcatno",
							strItemOtherVal[0]);
					daoObj.setProcInValue(nProcIndex2, "expirydate",
							strItemOtherVal[4]);
					daoObj.setProcInValue(nProcIndex2, "manufdate",
							strItemOtherVal[5]);
					daoObj.setProcInValue(nProcIndex2, "qty",
							strItemOtherVal[6]);
					daoObj.setProcInValue(nProcIndex2, "qtyunitid",
							strItemOtherVal[7]);
					daoObj.setProcInValue(nProcIndex2, "hosp_code", vo
							.getStrHospitalCode());
					
					/* Setting Default Value Start*/
					daoObj.setProcInValue(nProcIndex2, "transNo","0");
					daoObj.setProcInValue(nProcIndex2, "strId","0");
					/* Setting Default Value End */

					daoObj.setProcOutValue(nProcIndex2, "err", 1);
					daoObj.setProcOutValue(nProcIndex2, "dml_count", 1);

					daoObj.execute(nProcIndex2, 1);

				}

			strProcName3 = "{call PKG_MMS_DML.Dml_Hstt_Part_Items_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			if (vo.getStrItemPartDtls() != null
					&& vo.getStrItemPartDtls().length > 0)
				for (int i = 0; i < vo.getStrItemPartDtls().length; i++) {

					String strTemp = vo.getStrItemPartDtls()[i];
					String[] strItemPartVal = strTemp.replace("^", "#").split(
							"#");

					nProcIndex3 = daoObj.setProcedure(strProcName3);

					daoObj.setProcInValue(nProcIndex3, "modval", "1");
					daoObj.setProcInValue(nProcIndex3, "itemid", vo
							.getStrItemId());
					daoObj.setProcInValue(nProcIndex3, "itembrandid", vo
							.getStrItemBrandId());
					daoObj.setProcInValue(nProcIndex3, "batchno", vo
							.getStrBatchNo());
					daoObj.setProcInValue(nProcIndex3, "partitemid",
							strItemPartVal[1]);
					daoObj.setProcInValue(nProcIndex3, "partitembrandid",
							strItemPartVal[2]);
					
					if(strItemPartVal[3] != null && strItemPartVal[3].length() != 0){
						
						daoObj.setProcInValue(nProcIndex3, "partitembatchno",
								strItemPartVal[3]);
					}else{
						daoObj.setProcInValue(nProcIndex3, "partitembatchno",
								"0");
					}
					
					
					daoObj.setProcInValue(nProcIndex3, "partitemcatno",
							strItemPartVal[0]);
					daoObj.setProcInValue(nProcIndex3, "expirydate",
							strItemPartVal[4]);
					daoObj.setProcInValue(nProcIndex3, "manufdate",
							strItemPartVal[5]);
					daoObj
							.setProcInValue(nProcIndex3, "qty",
									strItemPartVal[6]);
					daoObj.setProcInValue(nProcIndex3, "qtyunitid",
							strItemPartVal[7]);

					daoObj.setProcInValue(nProcIndex3, "manufid",
							strItemPartVal[8]);

					daoObj.setProcInValue(nProcIndex3, "comp_type",
							strItemPartVal[9]);
					
					daoObj.setProcInValue(nProcIndex3, "is_separate",
							strItemPartVal[10]);
					
					daoObj.setProcInValue(nProcIndex3, "warranty_period",
							strItemPartVal[11]);
					
					daoObj.setProcInValue(nProcIndex3, "warranty_Unit",
							strItemPartVal[12]);
					
					daoObj.setProcInValue(nProcIndex3, "hosp_code", vo
							.getStrHospitalCode());
					
					/* Setting Default Value Start*/
					daoObj.setProcInValue(nProcIndex3, "transNo","0");
					daoObj.setProcInValue(nProcIndex3, "strId","0");
					/* Setting Default Value End */

					daoObj.setProcOutValue(nProcIndex3, "err", 1);
					daoObj.setProcOutValue(nProcIndex3, "dml_count", 1);

					daoObj.execute(nProcIndex3, 1);

				}

			if (vo.getStrIsWarrantyDetails().equals("1")) {

				strProcName4 = "{call PKG_MMS_DML.dml_warrenty_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				nProcIndex4 = daoObj.setProcedure(strProcName4);

				daoObj.setProcInValue(nProcIndex4, "modval", "1");
				daoObj
						.setProcInValue(nProcIndex4, "item_id", vo
								.getStrItemId());
				daoObj.setProcInValue(nProcIndex4, "item_brand_id", vo
						.getStrItemBrandId());
				daoObj.setProcInValue(nProcIndex4, "batch_sl_no", vo
						.getStrBatchNo());
				daoObj.setProcInValue(nProcIndex4, "hosp_code", vo
						.getStrHospitalCode());
				daoObj.setProcInValue(nProcIndex4, "warrenty_date", vo
						.getStrWarrantyDate());
				daoObj.setProcInValue(nProcIndex4, "manuf_id", vo
						.getStrWarantyManufacturer());
				daoObj.setProcInValue(nProcIndex4, "po_no", vo.getStrPoNo());
				daoObj.setProcInValue(nProcIndex4, "warrenty_upto", vo
						.getStrWarrantyUpTo());
				daoObj.setProcInValue(nProcIndex4, "warrenty_unitid", vo
						.getStrWarrantyUpToUnit());
				daoObj.setProcInValue(nProcIndex4, "fin_start_yr", vo
						.getStrFinancialStartYear());
				daoObj.setProcInValue(nProcIndex4, "fin_end_yr", vo
						.getStrFinancialEndYear());
				daoObj.setProcInValue(nProcIndex4, "remarks", vo
						.getStrWarrantyRemarks());
				daoObj
						.setProcInValue(nProcIndex4, "seat_id", vo
								.getStrSeatId());
				
				/* Setting Default Value Start*/
				daoObj.setProcInValue(nProcIndex4, "strId", "0");
				daoObj.setProcInValue(nProcIndex4, "transno", "0");
				/* Setting Default Value End */

				daoObj.setProcOutValue(nProcIndex4, "err", 1);

				daoObj.execute(nProcIndex4, 1);

			}

			if (vo.getStrIsInstallDetails().equals("1")) {

				strProcName5 = "{call PKG_MMS_DML.dml_installation_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				nProcIndex5 = daoObj.setProcedure(strProcName5);

				daoObj.setProcInValue(nProcIndex5, "modval", "1");
				daoObj
						.setProcInValue(nProcIndex5, "item_id", vo
								.getStrItemId());
				daoObj.setProcInValue(nProcIndex5, "item_brand_id", vo
						.getStrItemBrandId());
				daoObj.setProcInValue(nProcIndex5, "batch_sl_no", vo
						.getStrBatchNo());
				daoObj.setProcInValue(nProcIndex5, "hosp_code", vo
						.getStrHospitalCode());
				daoObj.setProcInValue(nProcIndex5, "install_start_date", vo
						.getStrInstallStartDate());

				daoObj.setProcInValue(nProcIndex5, "install_end_date", vo
						.getStrInstallEndDate());

				daoObj.setProcInValue(nProcIndex5, "po_no", vo.getStrPoNo());
				daoObj.setProcInValue(nProcIndex5, "install_status", vo
						.getStrInstallStatus());
				daoObj.setProcInValue(nProcIndex5, "install_by", vo
						.getStrInstallBy());

				daoObj.setProcInValue(nProcIndex5, "installer_contactNo", vo
						.getStrInstallerContactNo());

				daoObj.setProcInValue(nProcIndex5, "fin_start_yr", vo
						.getStrFinancialStartYear());
				daoObj.setProcInValue(nProcIndex5, "fin_end_yr", vo
						.getStrFinancialEndYear());
				daoObj.setProcInValue(nProcIndex5, "remarks", vo.getStrInstallRemarks());
				
				/* Setting Default Value Start*/
				daoObj.setProcInValue(nProcIndex5, "strId", "0");
				daoObj.setProcInValue(nProcIndex5, "transno", "0");
				
				daoObj
						.setProcInValue(nProcIndex5, "seat_id", vo
								.getStrSeatId());

				daoObj.setProcOutValue(nProcIndex5, "err", 1);

				daoObj.execute(nProcIndex5, 1);

			}
			
			if(vo.getStrParamCheck() != null)
			if (vo.getStrParamCheck().length > 0) {

				for (int i = 0; i < vo.getStrParamCheck().length; i++) {

					String[] strTemp = vo.getStrParamCheck()[i].replace("^",
							"#").split("#");

					itemParameterDetailDAO.setStrHospitalCode(vo
							.getStrHospitalCode());
					itemParameterDetailDAO.setStrSeatId(vo.getStrSeatId());
					itemParameterDetailDAO.setStrItemId(vo.getStrItemBrandId());
					itemParameterDetailDAO.setStrParentParamId(strTemp[0]);
					itemParameterDetailDAO.setStrParamId(strTemp[1]);
					itemParameterDetailDAO.setStrParamValue(vo
							.getStrParamValue()[i]);
					itemParameterDetailDAO.setStrRemarks("");

					itemParameterDetailDAO.insertItemParameterDtls(daoObj);

				}

			}

			synchronized (daoObj) {
				daoObj.fire();
			}

			String strSlNo = daoObj.getString(nProcIndex, "retSerialNo");

			if (strSlNo != null)
				vo.setStrSerialNo(strSlNo);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("ItemInventoryTransDAO.insert() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;

			}

			itemParameterDetailDAO = null;

		}

	}

	/**
	 * retrieves and executes modify
	 */

	public static void modifyRecord(ItemInventorySurgicalTransVO vo) {

		String strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		String strProcName2 = "";
		int nProcIndex2 = 0;

		String strProcName3 = "";
		int nProcIndex3 = 0;

		HisDAO daoObj = null;
		WebRowSet web = null;
		WebRowSet warrantyWs = null;
		WebRowSet installWs = null;

		try {
			daoObj = new HisDAO("MMS", "ItemInventoryTransDAO");
			strProcName = "{call  PKG_MMS_VIEW.proc_hstt_item_currstock_view(?,?,?,?,?,?,?,?,?,?)}";

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modval", "1",1);
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "item_id", vo.getStrItemId(),3);
			daoObj.setProcInValue(nProcIndex, "itembrand_id", vo
					.getStrItemBrandId(),4);
			daoObj.setProcInValue(nProcIndex, "batch_no", vo.getStrBatchNo(),5);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo
					.getStrHospitalCode(),8);
			daoObj.setProcInValue(nProcIndex, "stockStatus", vo
					.getStrStockStatus(),6);
			daoObj.setProcInValue(nProcIndex, "itemSlNo", vo.getStrSerialNo(),7);
			
			daoObj.setProcOutValue(nProcIndex, "err", 1,9);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,10);

			// daoObj.execute(nProcIndex, 1);
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (!strErr.equals(""))
				throw new Exception(strErr);

			web = daoObj.getWebRowSet(nProcIndex, "resultset");
			if(web != null){
							
			while (web.next()) {
				vo.setStrStoreName(web.getString(1));
				vo.setStrGroupName(web.getString(2));
				vo.setStrSubGroupName(web.getString(3));
				vo.setStrItemName(web.getString(4));
				vo.setStrItemBrandName(web.getString(5));
				vo.setStrManufactureName(web.getString(6));
				vo.setStrBatchNo(web.getString(7));
				vo.setStrExpiryDate(web.getString(8));
				vo.setStrManufactureDate(web.getString(9));
				vo.setStrInHandQuantity(web.getString(10));
				vo.setStrInHandQuantityUnitName(web.getString(11));
				vo.setStrInHandQuantityUnitID(web.getString(12));
				vo.setStrRate(web.getString(13));
				vo.setStrUnitRateName(web.getString(14));
				vo.setStrUnitRateID(web.getString(15));
				vo.setStrSalePrice(web.getString(16));
				vo.setStrUnitNameSale(web.getString(17));
				vo.setStrUnitSaleID(web.getString(18));
				vo.setStrPoNo(web.getString(19));
				vo.setStrPoDate(web.getString(20));
				vo.setStrSuppliedBy(web.getString(21));
				vo.setStrReceivedDate(web.getString(22));
				vo.setStrCurrencyCode(web.getString(23));
				vo.setStrCurrencyValue(web.getString(24));
				vo.setStrBillNo(web.getString(25));
				vo.setStrBillDate(web.getString(26));
				vo.setStrItemSpecification(web.getString(27));
				/*
				 * Added by Aritra on 08/July/2010
				 * Reason: To set Manufacturer Id.
				 * Note: In database, HSTNUM_SUPPLIER_ID corresponds to Manufacturer Id
				 * and HSTNUM_SUPPLIED_BY corresponds to Supplier Id.
				 */
				vo.setStrManufactureId(web.getString(28));
				//vo.setStrRackNumber(web.getString(29));

			}
			}
			if (vo.getStrWarrantyFlag().equals("1")) {
				strProcName2 = "{call pkg_mms_view.proc_itemwarranty_dtl(?,?,?,?,?,?,?)}";

				nProcIndex2 = daoObj.setProcedure(strProcName2);

				daoObj.setProcInValue(nProcIndex2, "modeval", "2",1);
				daoObj.setProcInValue(nProcIndex2, "itemid", vo.getStrItemId(),3);
				daoObj.setProcInValue(nProcIndex2, "itembrandid", vo
						.getStrItemBrandId(),4);
				daoObj.setProcInValue(nProcIndex2, "batchslno", vo
						.getStrBatchNo(),5);
				daoObj.setProcInValue(nProcIndex2, "hosp_code", vo
						.getStrHospitalCode(),2);

				daoObj.setProcOutValue(nProcIndex2, "err", 1,6);
				daoObj.setProcOutValue(nProcIndex2, "resultset", 2,7);

				daoObj.executeProcedureByPosition(nProcIndex2);

				strErr = daoObj.getString(nProcIndex2, "err");

				if (strErr == null)
					strErr = "";

				if (!strErr.equals(""))
					throw new Exception(strErr);

				warrantyWs = daoObj.getWebRowSet(nProcIndex2, "resultset");

				if (warrantyWs != null && warrantyWs.size() > 0)
					if (warrantyWs.next()) {
						vo.setStrIsWarrantyDetails("1");
						vo.setStrWarrantyDate(warrantyWs.getString(1));
						vo.setStrWarantyManufacturer(warrantyWs.getString(2));
						vo.setStrWarrantyUpTo(warrantyWs.getString(3));
						vo.setStrWarrantyUpToUnit(warrantyWs.getString(4));
						vo.setStrWarrantyRemarks(warrantyWs.getString(5));
					}

			}

			if (vo.getStrInstallFlag().equals("1")) {
				strProcName3 = "{call pkg_mms_view.proc_installation_dtl(?,?,?,?,?,?,?)}";

				nProcIndex3 = daoObj.setProcedure(strProcName3);

				daoObj.setProcInValue(nProcIndex3, "modeval", "1",1);
				daoObj.setProcInValue(nProcIndex3, "itemid", vo.getStrItemId(),3);
				daoObj.setProcInValue(nProcIndex3, "itembrandid", vo
						.getStrItemBrandId(),4);
				daoObj.setProcInValue(nProcIndex3, "batchslno", vo
						.getStrBatchNo(),5);
				daoObj.setProcInValue(nProcIndex3, "hosp_code", vo
						.getStrHospitalCode(),2);

				daoObj.setProcOutValue(nProcIndex3, "err", 1,6);
				daoObj.setProcOutValue(nProcIndex3, "resultset", 2,7);

				daoObj.executeProcedureByPosition(nProcIndex3);

				strErr = daoObj.getString(nProcIndex3, "err");

				if (strErr == null)
					strErr = "";

				if (!strErr.equals(""))
					throw new Exception(strErr);

				installWs = daoObj.getWebRowSet(nProcIndex3, "resultset");

				if (installWs != null && installWs.size() > 0)
					if (installWs.next()) {
						vo.setStrIsInstallDetails("1");

						vo.setStrInstallStartDate(installWs.getString(1));
						vo.setStrInstallEndDate(installWs.getString(2));
						vo.setStrInstallStatus(installWs.getString(3));
						vo.setStrInstallBy(installWs.getString(4));
						vo.setStrInstallerContactNo(installWs.getString(5));
						vo.setStrInstallRemarks(installWs.getString(6));

					}

			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("ItemInventoryTransDAO.modifyRecord() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	/**
	 * retrieves and executes update
	 * 
	 * 
	 * 
	 */

	public static void update(ItemInventorySurgicalTransVO vo) {

		String strProcName = "";
		String strProcName2 = "";
		String strProcName3 = "";

		String strProcName4 = "";
		String strProcName5 = "";

		String strProcName6 = "";
		String strProcName7 = "";

		String strProcName8 = "";
		String strProcName9 = "";

		int nProcIndex = 0;
		int nProcIndex2 = 0;
		int nProcIndex3 = 0;

		int nProcIndex4 = 0;
		int nProcIndex5 = 0;

		int nProcIndex6 = 0;
		int nProcIndex7 = 0;

		int nProcIndex8 = 0;
		int nProcIndex9 = 0;

		HisDAO daoObj = null;
		ItemParameterDetailDAO itemParameterDetailDAO = null;

		try {
			daoObj = new HisDAO("MMS", "ItemInventoryTransDAO");

			itemParameterDetailDAO = new ItemParameterDetailDAO();
/*
			strProcName = "{call PKG_MMS_DML.Dml_Stock_Update(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modval", "2");

			daoObj.setProcInValue(nProcIndex, "strid", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "itemid", vo.getStrItemId());
			daoObj.setProcInValue(nProcIndex, "itembrandid", vo
					.getStrItemBrandId());

			daoObj.setProcInValue(nProcIndex, "old_itemSerialNo", vo
					.getStrSerialNo());

			daoObj.setProcInValue(nProcIndex, "old_strid", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "old_itemid", vo.getStrItemId());
			daoObj.setProcInValue(nProcIndex, "old_itembrandid", vo
					.getStrItemBrandId());

			daoObj.setProcInValue(nProcIndex, "old_stockstatuscode", vo
					.getStrOldStockStatus());

			daoObj
					.setProcInValue(nProcIndex, "old_batchno", vo
							.getStrBatchNo());

			daoObj.setProcInValue(nProcIndex, "batchno", vo.getStrBatchNo());
			daoObj.setProcInValue(nProcIndex, "itemcatno", vo
					.getStrItemCategoryNo());
			daoObj.setProcInValue(nProcIndex, "expirydate", vo
					.getStrExpiryDate());
			daoObj.setProcInValue(nProcIndex, "manufdate", vo
					.getStrManufactureDate());
			daoObj.setProcInValue(nProcIndex, "stockstatuscode", vo
					.getStrStockStatus());
			daoObj.setProcInValue(nProcIndex, "inhandqty", vo
					.getStrInHandQuantity());
			daoObj.setProcInValue(nProcIndex, "inhandqtyunitid", vo
					.getStrInHandQuantityUnitID());
			daoObj.setProcInValue(nProcIndex, "suppid", vo
					.getStrManufactureId());
			daoObj.setProcInValue(nProcIndex, "rate", vo.getStrRate());
			daoObj.setProcInValue(nProcIndex, "rateunitid", vo
					.getStrUnitRateID());
			daoObj
					.setProcInValue(nProcIndex, "saleprice", vo
							.getStrSalePrice());
			daoObj.setProcInValue(nProcIndex, "salepriceunitid", vo
					.getStrUnitSaleID());
			daoObj.setProcInValue(nProcIndex, "pono", vo.getStrPoNo());
			daoObj.setProcInValue(nProcIndex, "podate", vo.getStrPoDate());
			daoObj.setProcInValue(nProcIndex, "seatid", vo.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "suppliedBy", vo
					.getStrSuppliedBy());
			daoObj.setProcInValue(nProcIndex, "recievedDate", vo
					.getStrReceivedDate());
			daoObj.setProcInValue(nProcIndex, "description",
					"Through Item Inventory Process");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo
					.getStrHospitalCode());

			daoObj.setProcInValue(nProcIndex, "currencyCode", vo
					.getStrCurrencyCode());
			daoObj.setProcInValue(nProcIndex, "currencyValue", vo
					.getStrCurrencyValue());
			 daoObj.setProcInValue(nProcIndex, "invoiceNo",vo.getStrBillNo());                 
			 daoObj.setProcInValue(nProcIndex, "invoiceDate",vo.getStrBillDate());
			 
			  * Added by Aritra on 8th Jul 2010.
			  * Reason: To set item specification and different flag values.
			  
				if(vo.getStrItemOtherDtls() != null
						&& vo.getStrItemOtherDtls().length > 0) {
					
					daoObj.setProcInValue(nProcIndex3, "freeitemflag", "1");
					
				} else {
					
					daoObj.setProcInValue(nProcIndex3, "freeitemflag", "0");
					
				}
				if (vo.getStrItemPartDtls() != null
						&& vo.getStrItemPartDtls().length > 0) {

					daoObj.setProcInValue(nProcIndex, "partFlag", "1");

				} else {

					daoObj.setProcInValue(nProcIndex, "partFlag", "0");
				}
				if ("1".equals(vo.getStrIsWarrantyDetails())) {

					daoObj.setProcInValue(nProcIndex, "warrentyFlag", "1");

				} else {

					daoObj.setProcInValue(nProcIndex, "warrentyFlag", "0");
				}
				if (vo.getStrParamDtls() != null
						&& vo.getStrParamDtls().length > 0) {

					daoObj.setProcInValue(nProcIndex, "itemParamFlag", "1");

				} else {

					daoObj.setProcInValue(nProcIndex, "itemParamFlag", "0");
				}
				daoObj.setProcInValue(nProcIndex, "item_specification", vo.getStrItemSpecification());
				
				 * ************************** - 0 - ***************************
				 
			
				 Setting Default Value Start
				daoObj.setProcInValue(nProcIndex, "groupid", "");
				daoObj.setProcInValue(nProcIndex, "subgroupid", "0");
				daoObj.setProcInValue(nProcIndex, "inventoryflag", "");
				daoObj.setProcInValue(nProcIndex, "toStrId", "");
				daoObj.setProcInValue(nProcIndex, "reservedFlag", "0");
				daoObj.setProcInValue(nProcIndex, "transNo", "0");
				daoObj.setProcInValue(nProcIndex, "transDate", "");
				daoObj.setProcInValue(nProcIndex, "reqTypeId", "0");
				daoObj.setProcInValue(nProcIndex, "blockQtyFlag", "0");
				daoObj.setProcInValue(nProcIndex, "blockedQty", "0");
				daoObj.setProcInValue(nProcIndex, "blockedQtyUnitId", "0");
				daoObj.setProcInValue(nProcIndex, "releaseQty", "0");
				daoObj.setProcInValue(nProcIndex, "releaseQtyUnitId", "0");
				daoObj.setProcInValue(nProcIndex, "item_serialNoFlag", "1");
				 Setting Default Value End 
				
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "retSerialNo", 1);

			daoObj.execute(nProcIndex, 1);*/
			//altered by anshul for postgres compatability
			strProcName = "{call PKG_MMS_DML.Dml_Stock_Update(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,? ,?,?,?,?)}"; // 54 Variable
			 nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modval", "2",1);               //1
			daoObj.setProcInValue(nProcIndex, "strid", vo.getStrStoreId(),2); //2
			daoObj.setProcInValue(nProcIndex, "itemid", vo.getStrItemId(),3); //3
			daoObj.setProcInValue(nProcIndex, "itembrandid", vo.getStrItemBrandId(),4);//4
			daoObj.setProcInValue(nProcIndex, "batchno", vo.getStrBatchNo(),5); //5
			daoObj.setProcInValue(nProcIndex, "itemcatno", vo.getStrItemCategoryNo(),6);    //6
			daoObj.setProcInValue(nProcIndex, "groupid", vo.getStrGroupId(),7);             //7
			daoObj.setProcInValue(nProcIndex, "subgroupid", vo.getStrSubGroupId(),8);  //8    
			daoObj.setProcInValue(nProcIndex, "expirydate", vo.getStrExpiryDate(),9);  //9
			daoObj.setProcInValue(nProcIndex, "manufdate", vo.getStrManufactureDate(),10); //10
			daoObj.setProcInValue(nProcIndex, "stockstatuscode", vo.getStrStockStatus(),11); //11
			daoObj.setProcInValue(nProcIndex, "inventoryflag", "0",12); //12
			daoObj.setProcInValue(nProcIndex, "inhandqty", vo.getStrInHandQuantity(),13);//13
			daoObj.setProcInValue(nProcIndex, "inhandqtyunitid", vo.getStrInHandQuantityUnitID(),14);//14
			daoObj.setProcInValue(nProcIndex, "suppid", vo.getStrManufactureId(),15); //15
			////System.out.println("Supplied ID(Inv DAO 15)==>"+vo.getStrManufactureId());
			daoObj.setProcInValue(nProcIndex, "rate", vo.getStrRate(),16); //16
			////System.out.println("In Save Rate:::::"+vo.getStrRate());
			////System.out.println("In Save Sale Price::::"+vo.getStrSalePrice());
			////System.out.println("Rate Unit ID==>"+vo.getStrUnitRateID());
			////System.out.println("Sale Unit ID==>"+vo.getStrUnitSaleID());
			daoObj.setProcInValue(nProcIndex, "rateunitid", vo.getStrUnitRateID(),17); //17
			daoObj.setProcInValue(nProcIndex, "saleprice", vo.getStrSalePrice(),18); //18
			daoObj.setProcInValue(nProcIndex, "salepriceunitid", vo.getStrUnitSaleID(),19); //19
			daoObj.setProcInValue(nProcIndex, "pono", vo.getStrPoNo(),20); //20
			daoObj.setProcInValue(nProcIndex, "podate", vo.getStrPoDate(),21); //21
			daoObj.setProcInValue(nProcIndex, "seatid", vo.getStrSeatId(),22); //24
			
			daoObj.setProcInValue(nProcIndex, "suppliedBy", vo.getStrSuppliedBy(),23); //22
			
			////System.out.println("Supplied By(Inv DAO 22)==>"+vo.getStrSuppliedBy());
			daoObj.setProcInValue(nProcIndex, "recievedDate", vo.getStrReceivedDate(),24); //23
			daoObj.setProcInValue(nProcIndex, "currencyCode", vo.getStrCurrencyCode(),25); //27
			
			if (vo.getStrItemOtherDtls() != null && vo.getStrItemOtherDtls().length > 0) 
			{
				daoObj.setProcInValue(nProcIndex, "freeItemFlag", "1",26);  //30
			} 
			else 
			{
				daoObj.setProcInValue(nProcIndex, "freeItemFlag", "0",26); //30
			}
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),27); //25
			daoObj.setProcInValue(nProcIndex, "currencyValue", vo.getStrCurrencyValue(),28); //28
			daoObj.setProcInValue(nProcIndex, "old_stockstatuscode",  vo
					.getStrOldStockStatus(),29); //33
			daoObj.setProcInValue(nProcIndex, "old_batchno", vo
					.getStrBatchNo(),30);   //34
			daoObj.setProcInValue(nProcIndex, "old_itemSerialNo", vo
					.getStrSerialNo(),31); //35
			daoObj.setProcInValue(nProcIndex, "old_itemid", vo.getStrItemId(),32);  //36
			daoObj.setProcInValue(nProcIndex, "old_itembrandid",vo
					.getStrItemBrandId(),33); //37
			daoObj.setProcInValue(nProcIndex, "old_strid", vo.getStrStoreId(),34);  //38
			daoObj.setProcInValue(nProcIndex, "itemParamFlag", "0",35); //39
			daoObj.setProcInValue(nProcIndex, "partFlag", "0",36);  //40
			daoObj.setProcInValue(nProcIndex, "warrentyFlag", "0",37); //41
			daoObj.setProcInValue(nProcIndex, "toStrId", "",38); //42
			daoObj.setProcInValue(nProcIndex, "reservedFlag", "0",39); //43
			daoObj.setProcInValue(nProcIndex, "transNo", "0",40); //44
			daoObj.setProcInValue(nProcIndex, "transDate", "",41); //45
			daoObj.setProcInValue(nProcIndex, "description","Stock Quantity added though Inventory Process",42); //26
			
			daoObj.setProcInValue(nProcIndex, "reqTypeId", "58",43); //46
			daoObj.setProcInValue(nProcIndex, "blockQtyFlag", "0",44); //47
			daoObj.setProcInValue(nProcIndex, "blockedQty", "0",45);   //48
			daoObj.setProcInValue(nProcIndex, "blockedQtyUnitId", "0",46); //49
			daoObj.setProcInValue(nProcIndex, "releaseQty", "0",47);  //50
			daoObj.setProcInValue(nProcIndex, "releaseQtyUnitId", "0",48); //51
		
			
		
			daoObj.setProcInValue(nProcIndex, "item_specification", vo.getStrItemSpecification(),52); //29
			

			daoObj.setProcInValue(nProcIndex, "invoiceNo", vo.getStrBillNo(),49); //31
			daoObj.setProcInValue(nProcIndex, "invoiceDate", vo.getStrBillDate(),50); //32
			/* Start */
			
			daoObj.setProcInValue(nProcIndex, "item_serialNoFlag", "1",51); //52
			/* End */

			daoObj.setProcOutValue(nProcIndex, "err", 1,54);   //53
			daoObj.setProcOutValue(nProcIndex, "retSerialNo", 1,53); //54

			daoObj.execute(nProcIndex, 1);
			
			

			strProcName3 = "{call PKG_MMS_DML.Dml_Hstt_Free_Items_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			nProcIndex3 = daoObj.setProcedure(strProcName3);

			daoObj.setProcInValue(nProcIndex3, "modval", "2",1);
			daoObj.setProcInValue(nProcIndex3, "itemid", vo.getStrItemId(),2);
			daoObj.setProcInValue(nProcIndex3, "itembrandid", vo.getStrItemBrandId(),3);
			daoObj.setProcInValue(nProcIndex3, "batchno", vo.getStrBatchNo(),4);
	
			
			/* Start */
			daoObj.setProcInValue(nProcIndex3, "freeitemid", "",5);
			daoObj.setProcInValue(nProcIndex3, "freeitembrandid", "0",6);
			daoObj.setProcInValue(nProcIndex3, "freeitembatchno", "0",7);
			daoObj.setProcInValue(nProcIndex3, "freeitemcatno", "1",8);
			daoObj.setProcInValue(nProcIndex3, "expirydate", "",9);
			daoObj.setProcInValue(nProcIndex3, "manufdate", "",10);
			daoObj.setProcInValue(nProcIndex3, "qty", "0",11);
			daoObj.setProcInValue(nProcIndex3, "qtyunitid", "0",12);
			daoObj.setProcInValue(nProcIndex3, "hosp_code", vo.getStrHospitalCode(),13);
			daoObj.setProcInValue(nProcIndex3, "transNo", "0",14);
			daoObj.setProcInValue(nProcIndex3, "strId", "0",15);
			/* End */

			daoObj.setProcOutValue(nProcIndex3, "err", 1,17);
			daoObj.setProcOutValue(nProcIndex3, "dml_count", 1,16);

			daoObj.execute(nProcIndex3, 1);


			strProcName2 = "{call PKG_MMS_DML.Dml_Hstt_Free_Items_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			if (vo.getStrItemOtherDtls() != null && vo.getStrItemOtherDtls().length > 0)
				for (int i = 0; i < vo.getStrItemOtherDtls().length; i++) 
				{

					String strTemp = vo.getStrItemOtherDtls()[i];
					String[] strItemOtherVal = strTemp.replace("^", "#").split("#");

					nProcIndex2 = daoObj.setProcedure(strProcName2);

					daoObj.setProcInValue(nProcIndex2, "modval", "1");
					daoObj.setProcInValue(nProcIndex2, "itemid", vo.getStrItemId());
					daoObj.setProcInValue(nProcIndex2, "itembrandid", vo.getStrItemBrandId());
					daoObj.setProcInValue(nProcIndex2, "batchno", vo.getStrBatchNo());
					daoObj.setProcInValue(nProcIndex2, "freeitemid",strItemOtherVal[1]);
					daoObj.setProcInValue(nProcIndex2, "freeitembrandid",strItemOtherVal[2]);
					daoObj.setProcInValue(nProcIndex2, "freeitembatchno",strItemOtherVal[3]);
					daoObj.setProcInValue(nProcIndex2, "freeitemcatno",	strItemOtherVal[0]);
					daoObj.setProcInValue(nProcIndex2, "expirydate",strItemOtherVal[4]);
					daoObj.setProcInValue(nProcIndex2, "manufdate",	strItemOtherVal[5]);
					daoObj.setProcInValue(nProcIndex2, "qty",strItemOtherVal[6]);
					daoObj.setProcInValue(nProcIndex2, "qtyunitid",	strItemOtherVal[7]);
					daoObj.setProcInValue(nProcIndex2, "hosp_code", vo.getStrHospitalCode());
					
					/* Start*/
					daoObj.setProcInValue(nProcIndex2, "transNo", "0");
					daoObj.setProcInValue(nProcIndex2, "strId", "0");
					/* End */

					daoObj.setProcOutValue(nProcIndex2, "err", 1);
					daoObj.setProcOutValue(nProcIndex2, "dml_count", 1);

					daoObj.execute(nProcIndex2, 1);


				}

			strProcName4 = "{call  PKG_MMS_DML.Dml_Hstt_Part_Items_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			nProcIndex4 = daoObj.setProcedure(strProcName4);

			daoObj.setProcInValue(nProcIndex4, "modval", "2",1);
			daoObj.setProcInValue(nProcIndex4, "itemid", vo.getStrItemId(),2);
			daoObj.setProcInValue(nProcIndex4, "itembrandid", vo
					.getStrItemBrandId(),3);
			daoObj.setProcInValue(nProcIndex4, "batchno", vo.getStrBatchNo(),4);
			daoObj.setProcInValue(nProcIndex4, "hosp_code", vo
					.getStrHospitalCode(),13);
			
			/* Setting Default Value Start*/
			daoObj.setProcInValue(nProcIndex4, "partitemid", "",5);
			daoObj.setProcInValue(nProcIndex4, "partitembrandid", "",6);
			daoObj.setProcInValue(nProcIndex4, "partitembatchno", "0",7);
			daoObj.setProcInValue(nProcIndex4, "partitemcatno", "1",8);
			daoObj.setProcInValue(nProcIndex4, "expirydate", "",9);
			daoObj.setProcInValue(nProcIndex4, "manufdate", "",10);
			daoObj.setProcInValue(nProcIndex4, "manufid", "",11);
			daoObj.setProcInValue(nProcIndex4, "qty", "0",12);
			daoObj.setProcInValue(nProcIndex4, "qtyunitid", "0",14);
			daoObj.setProcInValue(nProcIndex4, "comp_type", "0",15);
			daoObj.setProcInValue(nProcIndex4, "is_separate", "0",16);
			daoObj.setProcInValue(nProcIndex4, "warranty_period", "0",17);
			daoObj.setProcInValue(nProcIndex4, "warranty_Unit", "0",18);
			daoObj.setProcInValue(nProcIndex4, "transNo", "0",19);
			daoObj.setProcInValue(nProcIndex4, "strId", "0",20);
			/* Setting Default Value End */
			

			daoObj.setProcOutValue(nProcIndex4, "err", 1,22);
			daoObj.setProcOutValue(nProcIndex4, "dml_count", 1,21);

			daoObj.execute(nProcIndex4, 1);

			strProcName5 = "{call  PKG_MMS_DML.Dml_Hstt_Part_Items_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			if (vo.getStrItemPartDtls() != null
					&& vo.getStrItemPartDtls().length > 0)
				for (int i = 0; i < vo.getStrItemPartDtls().length; i++) {

					String strTemp = vo.getStrItemPartDtls()[i];
					String[] strItemOtherVal = strTemp.replace("^", "#").split(
							"#");

					nProcIndex5 = daoObj.setProcedure(strProcName5);
	
					
					daoObj.setProcInValue(nProcIndex5, "modval", "1",1);
					daoObj.setProcInValue(nProcIndex5, "itemid", vo
							.getStrItemId(),2);
					daoObj.setProcInValue(nProcIndex5, "itembrandid", vo
							.getStrItemBrandId(),3);
					daoObj.setProcInValue(nProcIndex5, "batchno", vo
							.getStrBatchNo(),4);
					daoObj.setProcInValue(nProcIndex5, "partitemid",
							strItemOtherVal[1],5);
					daoObj.setProcInValue(nProcIndex5, "partitembrandid",
							strItemOtherVal[2],6);
					daoObj.setProcInValue(nProcIndex5, "partitembatchno",
							strItemOtherVal[3],7);
					daoObj.setProcInValue(nProcIndex5, "partitemcatno",
							strItemOtherVal[0],8);
					daoObj.setProcInValue(nProcIndex5, "expirydate",
							strItemOtherVal[4],9);
					daoObj.setProcInValue(nProcIndex5, "manufdate",
							strItemOtherVal[5],10);
					daoObj.setProcInValue(nProcIndex5, "qty",
							strItemOtherVal[6],11);
					daoObj.setProcInValue(nProcIndex5, "qtyunitid",
							strItemOtherVal[7],12);

					daoObj.setProcInValue(nProcIndex5, "manufid",
							strItemOtherVal[8],13);
					
					daoObj.setProcInValue(nProcIndex5, "comp_type",
							strItemOtherVal[9],14);
					
					daoObj.setProcInValue(nProcIndex5, "is_separate",
							strItemOtherVal[10],15);
					
					daoObj.setProcInValue(nProcIndex5, "warranty_period",
							strItemOtherVal[11],16);
					
					daoObj.setProcInValue(nProcIndex5, "warranty_Unit",
							strItemOtherVal[12],17);

					daoObj.setProcInValue(nProcIndex5, "hosp_code", vo
							.getStrHospitalCode(),18);
					
					
					/* Setting Default Value Start*/
					daoObj.setProcInValue(nProcIndex5, "transNo", "0");
					daoObj.setProcInValue(nProcIndex5, "strId", "0");
					/* Setting Default Value End */

					daoObj.setProcOutValue(nProcIndex5, "err", 1);
					daoObj.setProcOutValue(nProcIndex5, "dml_count", 1);

					daoObj.execute(nProcIndex5, 1);

				}

		/*	if (vo.getStrIsWarrantyDetails().equals("1")) {

				strProcName6 = "{call  PKG_MMS_DML.dml_warrenty_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				nProcIndex6 = daoObj.setProcedure(strProcName6);

				daoObj.setProcInValue(nProcIndex6, "modval", "2");
				daoObj
						.setProcInValue(nProcIndex6, "item_id", vo
								.getStrItemId());
				daoObj.setProcInValue(nProcIndex6, "item_brand_id", vo
						.getStrItemBrandId());
				daoObj.setProcInValue(nProcIndex6, "batch_sl_no", vo
						.getStrBatchNo());
				daoObj.setProcInValue(nProcIndex6, "hosp_code", vo
						.getStrHospitalCode());
				daoObj.setProcInValue(nProcIndex6, "warrenty_date", vo
						.getStrWarrantyDate());
				daoObj.setProcInValue(nProcIndex6, "manuf_id", vo
						.getStrWarantyManufacturer());
				daoObj.setProcInValue(nProcIndex6, "po_no", vo.getStrPoNo());
				daoObj.setProcInValue(nProcIndex6, "warrenty_upto", vo
						.getStrWarrantyUpTo());
				daoObj.setProcInValue(nProcIndex6, "warrenty_unitid", vo
						.getStrWarrantyUpToUnit());
				daoObj.setProcInValue(nProcIndex6, "fin_start_yr", vo
						.getStrFinancialStartYear());
				daoObj.setProcInValue(nProcIndex6, "fin_end_yr", vo
						.getStrFinancialEndYear());
				daoObj.setProcInValue(nProcIndex6, "remarks", vo
						.getStrWarrantyRemarks());
				daoObj
						.setProcInValue(nProcIndex6, "seat_id", vo
								.getStrSeatId());
				
				 Setting Default Value Start
				daoObj.setProcInValue(nProcIndex6, "strId", "0");
				daoObj.setProcInValue(nProcIndex6, "transno", "0");
				 Setting Default Value End 

				daoObj.setProcOutValue(nProcIndex6, "err", 1);

				daoObj.execute(nProcIndex6, 1);

			} else {

				strProcName7 = "{call  PKG_MMS_DML.dml_warrenty_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

				nProcIndex7 = daoObj.setProcedure(strProcName7);

				daoObj.setProcInValue(nProcIndex7, "modval", "3");
				daoObj
						.setProcInValue(nProcIndex7, "item_id", vo
								.getStrItemId());
				daoObj.setProcInValue(nProcIndex7, "item_brand_id", vo
						.getStrItemBrandId());
				daoObj.setProcInValue(nProcIndex7, "batch_sl_no", vo
						.getStrBatchNo());
				daoObj.setProcInValue(nProcIndex7, "hosp_code", vo
						.getStrHospitalCode());
				
				 Setting Default Value Start
				daoObj.setProcInValue(nProcIndex7, "warrenty_date", "");
				daoObj.setProcInValue(nProcIndex7, "manuf_id", "");
				daoObj.setProcInValue(nProcIndex7, "po_no", "");
				daoObj.setProcInValue(nProcIndex7, "warrenty_upto", "");
				daoObj.setProcInValue(nProcIndex7, "warrenty_unitid", "");
				daoObj.setProcInValue(nProcIndex7, "fin_start_yr", "");
				daoObj.setProcInValue(nProcIndex7, "fin_end_yr", "");
				daoObj.setProcInValue(nProcIndex7, "remarks", "");
				daoObj.setProcInValue(nProcIndex7, "seat_id", "");
				daoObj.setProcInValue(nProcIndex7, "strId", "0");
				daoObj.setProcInValue(nProcIndex7, "transno", "0");
				 Setting Default Value End 

				daoObj.setProcOutValue(nProcIndex7, "err", 1);

				daoObj.execute(nProcIndex7, 1);

			}

			if (vo.getStrIsInstallDetails().equals("1")) {

				strProcName8 = "{call  PKG_MMS_DML.dml_installation_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				nProcIndex8 = daoObj.setProcedure(strProcName8);

				daoObj.setProcInValue(nProcIndex8, "modval", "2");
				daoObj
						.setProcInValue(nProcIndex8, "item_id", vo
								.getStrItemId());
				daoObj.setProcInValue(nProcIndex8, "item_brand_id", vo
						.getStrItemBrandId());
				daoObj.setProcInValue(nProcIndex8, "batch_sl_no", vo
						.getStrBatchNo());
				daoObj.setProcInValue(nProcIndex8, "hosp_code", vo
						.getStrHospitalCode());

				daoObj.setProcInValue(nProcIndex8, "install_start_date", vo
						.getStrInstallStartDate());

				daoObj.setProcInValue(nProcIndex8, "install_end_date", vo
						.getStrInstallEndDate());

				daoObj.setProcInValue(nProcIndex8, "install_status", vo
						.getStrInstallStatus());
				daoObj.setProcInValue(nProcIndex8, "install_by", vo
						.getStrInstallBy());

				daoObj.setProcInValue(nProcIndex8, "installer_contactNo", vo
						.getStrInstallerContactNo());

				daoObj.setProcInValue(nProcIndex8, "po_no", vo.getStrPoNo());

				daoObj.setProcInValue(nProcIndex8, "remarks", vo
						.getStrInstallRemarks());
				daoObj
						.setProcInValue(nProcIndex8, "seat_id", vo
								.getStrSeatId());
				
				 Setting Default Value Start
				daoObj.setProcInValue(nProcIndex8, "fin_start_yr", "");
				daoObj.setProcInValue(nProcIndex8, "fin_end_yr", "");
				daoObj.setProcInValue(nProcIndex8, "strId", "0");
				daoObj.setProcInValue(nProcIndex8, "transno", "0");
				 Setting Default Value End 
				

				daoObj.setProcOutValue(nProcIndex8, "err", 1);

				daoObj.execute(nProcIndex8, 1);

			} else {

				strProcName9 = "{call  PKG_MMS_DML.dml_installation_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

				nProcIndex9 = daoObj.setProcedure(strProcName9);

				daoObj.setProcInValue(nProcIndex9, "modval", "3");
				daoObj
						.setProcInValue(nProcIndex9, "item_id", vo
								.getStrItemId());
				daoObj.setProcInValue(nProcIndex9, "item_brand_id", vo
						.getStrItemBrandId());
				daoObj.setProcInValue(nProcIndex9, "batch_sl_no", vo
						.getStrBatchNo());
				daoObj.setProcInValue(nProcIndex9, "hosp_code", vo
						.getStrHospitalCode());
				
				 Setting Default Value Start
				daoObj.setProcInValue(nProcIndex9, "install_start_date", "");
				daoObj.setProcInValue(nProcIndex9, "install_end_date", "");
				daoObj.setProcInValue(nProcIndex9, "po_no", "");
				daoObj.setProcInValue(nProcIndex9, "install_status", "");
				daoObj.setProcInValue(nProcIndex9, "install_by", "");
				daoObj.setProcInValue(nProcIndex9, "installer_contactNo", "");
				daoObj.setProcInValue(nProcIndex9, "fin_start_yr", "");
				daoObj.setProcInValue(nProcIndex9, "fin_end_yr", "");
				daoObj.setProcInValue(nProcIndex9, "remarks", "");
				daoObj.setProcInValue(nProcIndex9, "seat_id", "");
				daoObj.setProcInValue(nProcIndex9, "strId", "0");
				daoObj.setProcInValue(nProcIndex9, "transno", "0");
				 Setting Default Value End 

				daoObj.setProcOutValue(nProcIndex9, "err", 1);

				daoObj.execute(nProcIndex9, 1);

			}

			int paramValInitLen = 0;
			
			if(vo.getStrParamDtls() != null)
			if ( vo.getStrParamDtls().length > 0) {

				for (int i = 0; i < vo.getStrParamDtls().length; i++) {

					String[] strTemp = vo.getStrParamDtls()[i]
							.replace("^", "#").split("#");

					if (vo.getStrParamStatus()[i].equals("2")) {

						itemParameterDetailDAO.setStrParamId(strTemp[0]);
						itemParameterDetailDAO.setStrParamSlNo(strTemp[1]);
						itemParameterDetailDAO.setStrItemId(vo
								.getStrItemBrandId());
						itemParameterDetailDAO.setStrHospitalCode(vo
								.getStrHospitalCode());
						itemParameterDetailDAO.setStrSeatId(vo.getStrSeatId());

						itemParameterDetailDAO.deleteItemParameterDtls(daoObj);

					} else {

						paramValInitLen = paramValInitLen + 1;
						
						itemParameterDetailDAO.setStrParamId(strTemp[0]);
						itemParameterDetailDAO.setStrParamSlNo(strTemp[1]);
						itemParameterDetailDAO.setStrItemId(vo
								.getStrItemBrandId());
						itemParameterDetailDAO.setStrParamValue(vo
								.getStrParamValue()[i]);
						itemParameterDetailDAO.setStrHospitalCode(vo
								.getStrHospitalCode());
						itemParameterDetailDAO.setStrSeatId(vo.getStrSeatId());

						itemParameterDetailDAO.updateItemParameterDtls(daoObj);

					}

				}

			}

			

			if(vo.getStrParamCheck() != null){
				
						
						
			if (vo.getStrParamCheck().length > 0) {

				for (int i = 0; i < vo.getStrParamCheck().length; i++) {

					String[] strTemp = vo.getStrParamCheck()[i].replace("^",
							"#").split("#");

					itemParameterDetailDAO.setStrHospitalCode(vo
							.getStrHospitalCode());
					itemParameterDetailDAO.setStrSeatId(vo.getStrSeatId());
					itemParameterDetailDAO.setStrItemId(vo.getStrItemBrandId());
					itemParameterDetailDAO.setStrParentParamId(strTemp[0]);
					itemParameterDetailDAO.setStrParamId(strTemp[1]);
					itemParameterDetailDAO.setStrParamValue(vo
							.getStrParamValue()[paramValInitLen + i]);
					itemParameterDetailDAO.setStrRemarks("");

					itemParameterDetailDAO.insertItemParameterDtls(daoObj);

				}

			}
			}*/
			synchronized (daoObj) {
				daoObj.fire();
			}

			vo.setBExistStatus(true);

		} catch (Exception e) {

			e.printStackTrace();

			vo.setBExistStatus(false);

			vo.setStrMsgString("ItemInventoryTransDAO.update() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;

			}
		}

	}

	/**
	 * The following procedure is used to populate the value of Unit Name combo
	 * using Pkg_Mms_View.Proc_Gblt_Unit_Mst procedure.
	 * 
	 * 
	 */
	/*public static void unitNameCombo(ItemInventorySurgicalTransVO vo) {
		String strFuncName = "";
		String strProcName = "";

		int nFuncIndex = 0;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;
		String strUnitRate = "";

		try {

			daoObj = new HisDAO("ItemInventoryTrans", "ItemInventoryTransDAO");
			strFuncName = "{? = call mms_mst.get_inventory_unitid(?::numeric, ?::numeric, ?::numeric, ?::numeric)}";
			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";

			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, "1");
			daoObj.setFuncInValue(nFuncIndex, 3, Config.SUPER_USER_HOSPITAL_CODE);
			daoObj.setFuncInValue(nFuncIndex, 4, vo.getStrItemCategoryNo().equalsIgnoreCase("")?"0":vo.getStrItemCategoryNo());
			daoObj.setFuncInValue(nFuncIndex, 5, vo.getStrItemId());
			//daoObj.setFuncInValue(nFuncIndex, 5, vo.getStrModuleId());
			//daoObj.setFuncInValue(nFuncIndex, 6, "1");
			daoObj.setFuncOutValue(nFuncIndex,1);
			
						
			daoObj.executeFuncForNumeric(nFuncIndex);
			strUnitRate = daoObj.getFuncNumeric(nFuncIndex).toString();
           
			daoObj.executeFunction(nProcIndex);
			strUnitRate=daoObj.getFuncString(nProcIndex);
			//System.out.println("strUnitRate>>>>>>>>> --->>"+strUnitRate);

			vo.setStrUnitRateID(strUnitRate);
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", Config.SUPER_USER_HOSPITAL_CODE,1);
			daoObj.setProcInValue(nProcIndex, "unit_id", vo.getStrUnitRateID(),2);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",4);
			
			daoObj.setProcInValue(nProcIndex, "module_id", "0",3);// DEFAULT VALUE.
			
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setStrUnitRateComboWS(ws);

			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("ItemInventoryTrans.unitNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
*/
	
	public static void unitNameCombo(ItemInventorySurgicalTransVO vo) {
		String strFuncName = "";
		String strProcName = "";

		int nFuncIndex = 0;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;
		String strUnitRate = "";

		try {

			daoObj = new HisDAO("ItemInventoryTrans", "ItemInventoryTransDAO");
			strFuncName = "{? = call mms_mst.get_inventory_unitid(?::numeric, ?::numeric, ?::numeric, ?::numeric)}";
			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";

			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, "1");
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 4, "0");
			
			daoObj.setFuncInValue(nFuncIndex, 5, vo.getStrItemId());
			daoObj.setFuncOutValue(nFuncIndex, 3);
			daoObj.executeFuncForNumeric(nFuncIndex);
			strUnitRate = daoObj.getFuncNumeric(nFuncIndex).toString();
			vo.setStrUnitRateID(strUnitRate);
//System.out.println("strUnitRate>>>>"+strUnitRate);
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo
					.getStrHospitalCode(),1);
			daoObj.setProcInValue(nProcIndex, "unit_id", vo.getStrUnitRateID(),2);
			if(vo.getStrUnitRateID().length() == 4)
				daoObj.setProcInValue(nProcIndex, "modeval", "5",4);
			else
				daoObj.setProcInValue(nProcIndex, "modeval", "1",4);
			//daoObj.setProcInValue(nProcIndex, "modeval", "5",4);
			daoObj.setProcInValue(nProcIndex, "module_id", "",3);//Aritra
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setStrUnitRateComboWS(ws);
 
				
				
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("ItemInventoryTrans.unitNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	public static void unitInHandNameCombo(ItemInventorySurgicalTransVO vo) {

		String strProcName = "";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {

			daoObj = new HisDAO("ItemInventoryTrans", "ItemInventoryTransDAO");

			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", Config.SUPER_USER_HOSPITAL_CODE,1);
			daoObj.setProcInValue(nProcIndex, "unit_id", vo
					.getStrInHandQuantityUnitID(),2);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",4);
			
			daoObj.setProcInValue(nProcIndex, "module_id", "",3);// Default Value.
			
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {

				vo.setStrUnitNameComboWS(ws);

			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("ItemInventoryTrans.unitInHandNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void unitSaleNameCombo(ItemInventorySurgicalTransVO vo) {

		String strProcName = "";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {

			daoObj = new HisDAO("ItemInventoryTrans", "ItemInventoryTransDAO");

			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", Config.SUPER_USER_HOSPITAL_CODE,1);
			daoObj.setProcInValue(nProcIndex, "unit_id", vo.getStrUnitSaleID(),2);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",4);
			daoObj.setProcInValue(nProcIndex, "module_id", "",3); //Default value
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {

				vo.setStrUnitSaleComboWS(ws);

			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("ItemInventoryTrans.unitSaleNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void unitRateNameCombo(ItemInventorySurgicalTransVO vo) {

		String strProcName = "";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {

			daoObj = new HisDAO("ItemInventoryTrans", "ItemInventoryTransDAO");

			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code",Config.SUPER_USER_HOSPITAL_CODE,1);
			daoObj.setProcInValue(nProcIndex, "unit_id", vo.getStrUnitRateID(),2);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",4);
			daoObj.setProcInValue(nProcIndex, "module_id", "",3);  // Default Value.
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {

				vo.setStrUnitRateComboWS(ws);

			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("ItemInventoryTrans.unitRateNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void getStockModifyValue(ItemInventorySurgicalTransVO vo) {
		String strFuncName = "";
	
		int nFuncIndex = 0;
	
		HisDAO daoObj = null;
		String strModify = "";

		try {

			daoObj = new HisDAO("ItemInventoryTrans", "ItemInventoryTransDAO");
			strFuncName = "{? = call Mms_Mst.get_StockModify_Dtls(?::numeric, ?::numeric, ?::numeric, ?, ?, ?::numeric, ?::numeric)}";
	

			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrItemCategoryNo());
			daoObj.setFuncInValue(nFuncIndex, 4, vo.getStrStoreId());
			daoObj.setFuncInValue(nFuncIndex, 5, vo.getStrSerialNo());
			daoObj.setFuncInValue(nFuncIndex, 6, vo.getStrBatchNo());
			daoObj.setFuncInValue(nFuncIndex, 7, vo.getStrItemId());
			daoObj.setFuncInValue(nFuncIndex, 8, vo.getStrItemBrandId());
			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);
			strModify = daoObj.getFuncString(nFuncIndex);
			
			vo.setStrModifyValue(strModify);
			
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("ItemInventoryTrans.getStockModifyValue() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
}
