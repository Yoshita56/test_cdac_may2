package mms.transactions.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
import mms.dao.GiftedItemDtlDAO;
import mms.global.dao.ItemParameterDetailDAO;
import mms.transactions.vo.GiftedItemDetailsTransVO;


/**
 * 
 * @author Tanvi Sappal
 *
 */
public class GiftedItemDetailsTransDAO {
	
	/**
	 * for getting option value of Store Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void storeName(GiftedItemDetailsTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Gifted Item Details","GiftedItemDetailsTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "seatId", vo.getStrSeatId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
			
			/* Setting Default Value Start*/
			daoObj.setProcInValue(nProcIndex, "modeval", "11",1);
			daoObj.setProcInValue(nProcIndex, "storeid", "0",4);
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0",5);
			/* Setting Default Value End */
			
			daoObj.setProcOutValue(nProcIndex, "err",1,6); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,7);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setWsStoreNameCombo(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("GiftedItemDetailsTransDAO.storeName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void itemCategory(GiftedItemDetailsTransVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_item_category_list(?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Gifted Item Details","GiftedItemDetailsTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			  		
			daoObj.setProcInValue(nProcIndex, "modeval", "4",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "reqType", "63",4);
			daoObj.setProcOutValue(nProcIndex, "err",1,5); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,6);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setWsItemCategoryCombo(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("GiftedItemDetailsTransDAO.itemCategory() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getGiftedItemList(GiftedItemDetailsTransVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_giftedItem_dtl(?,?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Gifted Item Details","GiftedItemDetailsTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			System.out.println("getStrMode-----"+vo.getStrMode());
			System.out.println("getStrHospitalCode-----"+vo.getStrHospitalCode());
			System.out.println("getStrStoreId-----"+vo.getStrStoreId());
			System.out.println("getStrItemCategoryId-----"+vo.getStrItemCategoryId());
			System.out.println("getStrFinancialStartYear-----"+vo.getStrFinancialStartYear());
			System.out.println("getStrFinancialEndYear-----"+vo.getStrFinancialEndYear());
				  		
			daoObj.setProcInValue(nProcIndex, "modeval",      (vo.getStrMode()!=null && !vo.getStrMode().equals("")) ? vo.getStrMode() : "1" ,1 );
			daoObj.setProcInValue(nProcIndex, "hosp_code",     vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "storeid",       vo.getStrStoreId(),4);
			daoObj.setProcInValue(nProcIndex, "item_cat_code", vo.getStrItemCategoryId(),3);
			daoObj.setProcInValue(nProcIndex, "fin_st_date",   vo.getStrFinancialStartYear(),5);
			daoObj.setProcInValue(nProcIndex, "fin_end_date",  vo.getStrFinancialEndYear(),6);
			daoObj.setProcOutValue(nProcIndex, "err",          1,7); 
			daoObj.setProcOutValue(nProcIndex, "resultset",    2,8);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			
						
			if (strErr.equals("")) {
				vo.setWsGiftedItemList(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("GiftedItemDetailsTransDAO.getGiftedItemList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	public static void initAddQuery(GiftedItemDetailsTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			
					
			dao = new HisDAO("mms", "GiftedItemDetailsTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_store_group_list(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "2",1);
			dao.setProcInValue(nprocIndex, "item_category", vo.getStrItemCategoryNo(),3);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nprocIndex, "strPhyStockNo", "0",4);
			dao.setProcInValue(nprocIndex, "strStoreId", "0",5);
			/* Setting Default Value End */
			
			dao.setProcOutValue(nprocIndex, "err", 1,6);
			dao.setProcOutValue(nprocIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");
			
			if (strerr.equals("")) {
				vo.setStrGroupComboWs(wb);

			} else {
				throw new Exception(strerr);
			}

			

		} catch (Exception e) {
			vo.setStrMsgString("GiftedItemDetailsTransDAO.initAddQuery() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getSubGroupList(GiftedItemDetailsTransVO vo){
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "GiftedItemDetailsTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_store_subgroup_list(?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "1",1);
			dao.setProcInValue(nprocIndex, "group_id", vo.getStrGroupId(),2);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),3);
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

		} catch (Exception e) {
			
			e.printStackTrace();
			
			vo.setStrMsgString("GiftedItemDetailsTransDAO.getSubGroupList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getGenericItemList(GiftedItemDetailsTransVO vo){
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "GiftedItemDetailsTransDAO");
		
			strproc_name = "{call PKG_MMS_VIEW.proc_storeitem_list(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "1",1);
			dao.setProcInValue(nprocIndex, "cat_no", vo.getStrItemCategoryNo(),4);
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId(),2);
			dao.setProcInValue(nprocIndex, "group_id", vo.getStrGroupId(),5);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),7);
			
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
			vo.setStrMsgString("GiftedItemDetailsTransDAO.getGenericItemList() --> "
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

	public static void getItemName(GiftedItemDetailsTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "GiftedItemDetailsTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_storeitem_list(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcInValue(nprocIndex, "group_id", vo.getStrGroupId(),5);
			dao.setProcInValue(nprocIndex, "sub_group_id", vo.getStrSubGroupId(),6);
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId(),2);
			dao.setProcInValue(nprocIndex, "cat_no", vo.getStrItemCategoryNo(),4);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),7);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nprocIndex, "item_id", "0",3);
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
			vo.setStrMsgString("GiftedItemDetailsTransDAO.getItemName() --> "
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

	public static void getItemBrandName(GiftedItemDetailsTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "GiftedItemDetailsTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_storeitem_list(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "2",1);
			dao.setProcInValue(nprocIndex, "item_id", vo.getStrItemId(),3);
			dao.setProcInValue(nprocIndex, "group_id", vo.getStrGroupId(),5);
			dao.setProcInValue(nprocIndex, "sub_group_id", vo.getStrSubGroupId(),6);
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId(),2);
			dao.setProcInValue(nprocIndex, "cat_no", vo.getStrItemCategoryNo(),4);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),7);
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
			vo.setStrMsgString("GiftedItemDetailsTransDAO.getItemBrandName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getBrandDetails(GiftedItemDetailsTransVO vo) {

		 
		HisDAO dao = null;
	  
		try {
			
			dao = new HisDAO("mms", "GiftedItemDetailsTransDAO");
			
			String strFuncName = "{? = call mms_mst.get_brand_ResFlag(?::numeric, ?::numeric, ?::numeric)}";
			
			int nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrItemBrandId());
			dao.setFuncOutValue(nFuncIndex, 1);
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
					.setStrMsgString("GiftedItemDetailsTransDAO.getBrandDetails() --> "
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

	public static void getSuppliedByList(GiftedItemDetailsTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "GiftedItemDetailsTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal",   "19",1);
			dao.setProcInValue(nprocIndex, "catCode",   vo.getStrItemCategoryNo(),2);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),5);
			
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
					.setStrMsgString("GiftedItemDetailsTransDAO.getSuppliedByList() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getWarrantyManufList(GiftedItemDetailsTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "GiftedItemDetailsTransDAO");
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
					.setStrMsgString("GiftedItemDetailsTransDAO.getWarrantyManufList() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getCurrencyList(GiftedItemDetailsTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "GiftedItemDetailsTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_currency_list(?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "1",1);
			dao
					.setProcInValue(nprocIndex, "hosp_code", vo
							.getStrHospitalCode(),2);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nprocIndex, "isDefault", "0",3);
			/* Setting Default Value End */
			
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
			vo.setStrMsgString("GiftedItemDetailsTransDAO.getCurrencyList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getStockStatusList(GiftedItemDetailsTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "GiftedItemDetailsTransDAO");
			
			if(vo.getStrItemCategoryNo().equals("10")){
				strproc_name = "{call PKG_MMS_VIEW.proc_stock_status_list(?,?,?,?,?,?)}";
			}else{
				strproc_name = "{call PKG_MMS_VIEW.proc_stock_status_list(?,?,?,?,?,?)}";
			}
			
			
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", (vo.getStrMode()!=null && !vo.getStrMode().equals("")) ? vo.getStrMode() : "1" ,1 );
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
			
			if(vo.getStrItemCategoryNo().equals("10")){
				dao.setProcInValue(nprocIndex, "itemCat", vo.getStrItemCategoryNo(),3);
			} else {
				dao.setProcInValue(nprocIndex, "itemCat", "0",3);
			}
			dao.setProcInValue(nprocIndex, "itemBrandId", vo.getStrItemBrandId(),4);
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
			vo.setStrMsgString("GiftedItemDetailsTransDAO.getStockStatusList() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getmanufectuteName(GiftedItemDetailsTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "GiftedItemDetailsTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "19",1);
			dao.setProcInValue(nprocIndex, "catCode", vo.getStrItemCategoryNo(),2);
			dao.setProcInValue(nprocIndex, "branditem_id", vo.getStrItemBrandId(),3);
			dao.setProcInValue(nprocIndex, "hosp_code", vo	.getStrHospitalCode(),5);
			
			/* Setting Default Value Start*/
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
					.setStrMsgString("GiftedItemDetailsTransDAO.getmanufectuteName() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public synchronized static void insert(GiftedItemDetailsTransVO vo) {
		
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
        boolean flag = false;
		HisDAO daoObj = null;
		HisUtil hisutil = null;
		String strCurrentDate="";
		ItemParameterDetailDAO itemParameterDetailDAO = null;
		
		GiftedItemDtlDAO giftedItemDtlDAO = null; 
		try {
			hisutil = new HisUtil("mms", "GiftedItemDetailsTransDATA");
			strCurrentDate = hisutil.getASDate("dd-MMM-yyyy");
			daoObj = new HisDAO("MMS", "GiftedItemDetailsTransDAO");
			itemParameterDetailDAO = new ItemParameterDetailDAO();
			
			giftedItemDtlDAO = new GiftedItemDtlDAO();
			
			
			//HSTNUM_ITEMBRAND_ID||''$''||hstnum_item_id||''$''||hstnum_group_id||''$''||NVL(sstnum_item_cat_no,0)
			
			String strItemBrandId =  vo.getStrItemBrandId().split("\\$")[0];
			String strItemId      =  vo.getStrItemBrandId().split("\\$")[1];
			String strGroupId     =  vo.getStrItemBrandId().split("\\$")[2];
			
			
			giftedItemDtlDAO.setStrStoreId(vo.getStrStoreId());
			giftedItemDtlDAO.setStrItemId(strItemId);
			giftedItemDtlDAO.setStrBrandId(strItemBrandId);
			giftedItemDtlDAO.setStrBatchNo(vo.getStrBatchNo());
			giftedItemDtlDAO.setStrHospitalCode(vo.getStrHospitalCode());
			giftedItemDtlDAO.setStrStockStatus(vo.getStrStockStatus());
			giftedItemDtlDAO.setStrItemCatCode(vo.getStrItemCategoryNo());
			giftedItemDtlDAO.setStrGroupId(strGroupId);
			giftedItemDtlDAO.setStrSubGroupId(vo.getStrSubGroupId());
			giftedItemDtlDAO.setStrManufacturerId(vo.getStrManufactureId());
			giftedItemDtlDAO.setStrGiftedBy(vo.getStrGiftedBy());
			giftedItemDtlDAO.setStrGiftedByAddress(vo.getStrAddress());
			giftedItemDtlDAO.setStrGiftQuantity(vo.getStrInHandQuantity());
			giftedItemDtlDAO.setStrGiftQuantityUnitId("6301");
			giftedItemDtlDAO.setStrManufacturerDate(vo.getStrManufactureDate());
			giftedItemDtlDAO.setStrExpiryDate(vo.getStrExpiryDate());
			giftedItemDtlDAO.setStrRate(vo.getStrRate());
			giftedItemDtlDAO.setStrRateUnitId("6301");
			giftedItemDtlDAO.setStrCurrencyID(vo.getStrCurrencyCode());
			giftedItemDtlDAO.setStrCurrencyValue(vo.getStrCurrencyValue());
			giftedItemDtlDAO.setStrIsTaxCertified("0");
			giftedItemDtlDAO.setStrFinancialStartYear(vo.getStrFinancialStartYear());
			giftedItemDtlDAO.setStrFinancialEndYear(vo.getStrFinancialEndYear());
			giftedItemDtlDAO.setStrRemarks(vo.getStrRemarks());
			giftedItemDtlDAO.setStrSeatId(vo.getStrSeatId());
			giftedItemDtlDAO.setReceivedBy(vo.getRecievedBy());
			giftedItemDtlDAO.insert(daoObj);
			
			strProcName = "{call PKG_MMS_DML.Dml_Stock_Update(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);
			
			

			daoObj.setProcInValue(nProcIndex, "modval", "1",1);
			daoObj.setProcInValue(nProcIndex, "strid", vo.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "itemid", strItemId,3);
			daoObj.setProcInValue(nProcIndex, "itembrandid",strItemBrandId,4);
			daoObj.setProcInValue(nProcIndex, "batchno", vo.getStrBatchNo(),5);
			daoObj.setProcInValue(nProcIndex, "itemcatno", vo.getStrItemCategoryNo(),6);
			daoObj.setProcInValue(nProcIndex, "groupid", strGroupId,7);
			daoObj.setProcInValue(nProcIndex, "subgroupid", vo.getStrSubGroupId(),8);
			daoObj.setProcInValue(nProcIndex, "expirydate", vo.getStrExpiryDate(),9);
			daoObj.setProcInValue(nProcIndex, "manufdate", vo.getStrManufactureDate(),10);
			daoObj.setProcInValue(nProcIndex, "stockstatuscode", vo.getStrStockStatus(),11);
			daoObj.setProcInValue(nProcIndex, "inventoryflag", "0",12);
			daoObj.setProcInValue(nProcIndex, "inhandqty", vo.getStrInHandQuantity(),13);
			daoObj.setProcInValue(nProcIndex, "inhandqtyunitid", "6301",14);
			daoObj.setProcInValue(nProcIndex, "suppid", vo.getStrSuppliedBy(),15);
			daoObj.setProcInValue(nProcIndex, "rate", vo.getStrRate(),16);
			daoObj.setProcInValue(nProcIndex, "rateunitid", "6301",17);
			daoObj.setProcInValue(nProcIndex, "saleprice", vo.getStrSalePrice(),18);
			daoObj.setProcInValue(nProcIndex, "salepriceunitid", "6301",19);
			//daoObj.setProcInValue(nProcIndex, "pono", vo.getStrPONumber(),20);
			//daoObj.setProcInValue(nProcIndex, "pono", "0",20);
			daoObj.setProcInValue(nProcIndex, "pono", (vo.getStrPONumber()==null||vo.getStrPONumber()==""||vo.getStrPONumber().length()==0)?"0":vo.getStrPONumber(),20);
			daoObj.setProcInValue(nProcIndex, "podate", "0",21);
			daoObj.setProcInValue(nProcIndex, "seatid", (vo.getStrSeatId()==null||vo.getStrSeatId()=="")?"0":vo.getStrSeatId(),22);
			daoObj.setProcInValue(nProcIndex, "suppliedBy",(vo.getStrSuppliedBy()==null||vo.getStrSuppliedBy()=="")?"0":vo.getStrSuppliedBy(),23);
			daoObj.setProcInValue(nProcIndex, "recievedDate",(vo.getStrReceivedDate()==null||vo.getStrReceivedDate()=="")?"0":vo.getStrReceivedDate(),24);
			daoObj.setProcInValue(nProcIndex, "currencyCode",(vo.getStrCurrencyCode()==null||vo.getStrCurrencyCode()=="")?"0":vo.getStrCurrencyCode(),25);
			
			System.out.println("vo.getStrExpiryDate()------------>"+vo.getStrExpiryDate());
			System.out.println("vo.getStrPONumber()-------->"+vo.getStrPONumber());
			

			
			if (vo.getStrItemOtherDtls() != null && vo.getStrItemOtherDtls().length > 0) 
			{
				daoObj.setProcInValue(nProcIndex, "freeItemFlag", "1",26);

			} 
			else 
			{
				daoObj.setProcInValue(nProcIndex, "freeItemFlag", "0",26);
			}

			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),27);
			daoObj.setProcInValue(nProcIndex, "currencyValue",(vo.getStrCurrencyValue()==null||vo.getStrCurrencyValue()=="")?"0":vo.getStrCurrencyValue(),28);
			daoObj.setProcInValue(nProcIndex, "old_stockstatuscode", "1",29);
			daoObj.setProcInValue(nProcIndex, "old_batchno", "0",30);
			daoObj.setProcInValue(nProcIndex, "old_itemSerialNo", "0",31);
			daoObj.setProcInValue(nProcIndex, "old_itemid", "0",32);
			daoObj.setProcInValue(nProcIndex, "old_itembrandid", "0",33);
			daoObj.setProcInValue(nProcIndex, "old_strid", "0",34);
			if (vo.getStrItemParamDtls() != null && vo.getStrItemParamDtls().length > 0) 
			{
				daoObj.setProcInValue(nProcIndex, "itemParamFlag", "1",35);
			} 
			else 
			{
				daoObj.setProcInValue(nProcIndex, "itemParamFlag", "0",35);
			}
			if (vo.getStrItemPartDtls() != null && vo.getStrItemPartDtls().length > 0) 
			{
				daoObj.setProcInValue(nProcIndex, "partFlag", "1",36);
			} 
			else 
			{
				daoObj.setProcInValue(nProcIndex, "partFlag", "0",36);
			}

			if (vo.getStrWarrantyFlag().equals("1")) 
			{
				daoObj.setProcInValue(nProcIndex, "warrentyFlag", "1",37);
			} 
			else 
			{
				daoObj.setProcInValue(nProcIndex, "warrentyFlag", "0",37);
			}
			daoObj.setProcInValue(nProcIndex, "toStrId", "0",38);
			daoObj.setProcInValue(nProcIndex, "reservedFlag", "0",39);
			daoObj.setProcInValue(nProcIndex, "transNo", "63000001",40);
			daoObj.setProcInValue(nProcIndex, "transDate",(vo.getStrReceivedDate()==null||vo.getStrReceivedDate()=="")?strCurrentDate:vo.getStrReceivedDate(),41);
			daoObj.setProcInValue(nProcIndex, "description","Gifted Item By :: " + vo.getStrGiftedBy()+" wth Batch "+vo.getStrBatchNo()+"  Qty "+vo.getStrInHandQuantity()+" No.",42);
			daoObj.setProcInValue(nProcIndex, "reqTypeId", "63",43);
			daoObj.setProcInValue(nProcIndex, "blockQtyFlag", "0",44);
			daoObj.setProcInValue(nProcIndex, "blockedQty", "0",45);
			daoObj.setProcInValue(nProcIndex, "blockedQtyUnitId", "0",46);
			daoObj.setProcInValue(nProcIndex, "releaseQty", "0",47);
			daoObj.setProcInValue(nProcIndex, "releaseQtyUnitId", "0",48);
			daoObj.setProcInValue(nProcIndex, "invoiceNo", "0",49);
			daoObj.setProcInValue(nProcIndex, "invoiceDate", "0",50);
			daoObj.setProcInValue(nProcIndex, "item_serialNoFlag", "1",51);			
			daoObj.setProcInValue(nProcIndex, "item_specification",(vo.getStrItemSpecification()==null||vo.getStrItemSpecification()=="")?"0":vo.getStrItemSpecification(),52);
			daoObj.setProcOutValue(nProcIndex, "retSerialNo", 1,53);
			daoObj.setProcOutValue(nProcIndex, "err", 1,54);
			

			daoObj.execute(nProcIndex, 1);

			strProcName2 = "{call pkg_mms_dml.Dml_Hstt_Free_Items_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			if (vo.getStrItemOtherDtls() != null && vo.getStrItemOtherDtls().length > 0)
				for (int i = 0; i < vo.getStrItemOtherDtls().length; i++) 
				{
					String strTemp = vo.getStrItemOtherDtls()[i];
					String[] strItemOtherVal = strTemp.replace("^", "#").split("#");

					nProcIndex2 = daoObj.setProcedure(strProcName2);
					

					daoObj.setProcInValue(nProcIndex2, "modval", "1",1);
					daoObj.setProcInValue(nProcIndex2, "itemid",(strItemId==null||strItemId=="")?"0":strItemId,2);
					daoObj.setProcInValue(nProcIndex2, "itembrandid",(strItemBrandId==null||strItemBrandId=="")?"0":strItemBrandId,3);
					daoObj.setProcInValue(nProcIndex2, "batchno",(vo.getStrBatchNo()==null||vo.getStrBatchNo()=="")?"0":vo.getStrBatchNo(),4);
					daoObj.setProcInValue(nProcIndex2, "freeitemid",strItemOtherVal[1],5);
					daoObj.setProcInValue(nProcIndex2, "freeitembrandid",strItemOtherVal[2],6);
					daoObj.setProcInValue(nProcIndex2, "freeitembatchno",strItemOtherVal[3],7);
					daoObj.setProcInValue(nProcIndex2, "freeitemcatno",strItemOtherVal[0],8);
					daoObj.setProcInValue(nProcIndex2, "expirydate",strItemOtherVal[4],9);
					daoObj.setProcInValue(nProcIndex2, "manufdate",strItemOtherVal[5],10);
					daoObj.setProcInValue(nProcIndex2, "qty",strItemOtherVal[6],11);
					daoObj.setProcInValue(nProcIndex2, "qtyunitid",strItemOtherVal[7],12);
					daoObj.setProcInValue(nProcIndex2, "hosp_code",(vo.getStrSuppliedBy()==null||vo.getStrHospitalCode()=="")?"0":vo.getStrHospitalCode(),13);
					daoObj.setProcInValue(nProcIndex2, "transNo","0",14);
					daoObj.setProcInValue(nProcIndex2, "strId","0",15);
					daoObj.setProcOutValue(nProcIndex2, "dml_count", 1,16);
					daoObj.setProcOutValue(nProcIndex2, "err", 1,17);					

					daoObj.execute(nProcIndex2, 1);
				}

			strProcName3 = "{call PKG_MMS_DML.Dml_Hstt_Part_Items_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			/*
			if (vo.getStrItemPartDtls() != null && vo.getStrItemPartDtls().length > 0)
				for (int i = 0; i < vo.getStrItemPartDtls().length; i++) 
				{
					String strTemp = vo.getStrItemPartDtls()[i];
					String[] strItemPartVal = strTemp.replace("^", "#").split("#");

					nProcIndex3 = daoObj.setProcedure(strProcName3);

					daoObj.setProcInValue(nProcIndex3, "modval", "1",1);
					daoObj.setProcInValue(nProcIndex3, "itemid",(vo.getStrItemId()==null||vo.getStrItemId()=="")?"0":vo.getStrItemId(),2);
					daoObj.setProcInValue(nProcIndex3, "itembrandid",(vo.getStrItemBrandId()==null||vo.getStrItemBrandId()=="")?"0":vo.getStrItemBrandId(),3);
					daoObj.setProcInValue(nProcIndex3, "batchno",(vo.getStrBatchNo()==null||vo.getStrBatchNo()=="")?"0":vo.getStrBatchNo(),4);
					daoObj.setProcInValue(nProcIndex3, "partitemid",strItemPartVal[1],5);
					daoObj.setProcInValue(nProcIndex3, "partitembrandid",strItemPartVal[2],6);
					
					if(strItemPartVal[3] != null && strItemPartVal[3].length() != 0)
					{
						daoObj.setProcInValue(nProcIndex3, "partitembatchno",strItemPartVal[3],7);
					}
					else
					{
						daoObj.setProcInValue(nProcIndex3, "partitembatchno","0",8);
					}					
					
					daoObj.setProcInValue(nProcIndex3, "partitemcatno",strItemPartVal[0],9);
					daoObj.setProcInValue(nProcIndex3, "expirydate",strItemPartVal[4],10);
					daoObj.setProcInValue(nProcIndex3, "manufdate",strItemPartVal[5],11);
					daoObj.setProcInValue(nProcIndex3, "manufid",strItemPartVal[8],12);
					daoObj.setProcInValue(nProcIndex3, "qty",strItemPartVal[6],13);
					daoObj.setProcInValue(nProcIndex3, "qtyunitid",strItemPartVal[7],14);
					daoObj.setProcInValue(nProcIndex3, "hosp_code", vo.getStrHospitalCode(),15);
					daoObj.setProcInValue(nProcIndex3, "comp_type",strItemPartVal[9],16);
					daoObj.setProcInValue(nProcIndex3, "is_separate",strItemPartVal[10],17);
					daoObj.setProcInValue(nProcIndex3, "warranty_period",strItemPartVal[11],18);
					daoObj.setProcInValue(nProcIndex3, "warranty_Unit",strItemPartVal[12],19);					
					daoObj.setProcInValue(nProcIndex3, "transNo","0",20);
					daoObj.setProcInValue(nProcIndex3, "strId","0",21);
					daoObj.setProcOutValue(nProcIndex3, "dml_count", 1,22);
					daoObj.setProcOutValue(nProcIndex3, "err", 1,23);					

					daoObj.execute(nProcIndex3, 1);
				}

			if (vo.getStrIsWarrantyDetails().equals("1")) 
			{

				strProcName4 = "{call pkg_mms_dml.dml_warrenty_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				nProcIndex4 = daoObj.setProcedure(strProcName4);

				daoObj.setProcInValue(nProcIndex4, "modval", "1",1);
				daoObj.setProcInValue(nProcIndex4, "item_id",(vo.getStrItemId()==null||vo.getStrItemId()=="")?"0":vo.getStrItemId(),2);
				daoObj.setProcInValue(nProcIndex4, "item_brand_id",(vo.getStrItemBrandId()==null||vo.getStrItemBrandId()=="")?"0":vo.getStrItemBrandId(),3);
				daoObj.setProcInValue(nProcIndex4, "batch_sl_no",(vo.getStrBatchNo()==null||vo.getStrBatchNo()=="")?"0":vo.getStrBatchNo() ,4);
				daoObj.setProcInValue(nProcIndex4, "hosp_code",(vo.getStrHospitalCode()==null||vo.getStrHospitalCode()=="")?"0":vo.getStrHospitalCode() ,5);
				daoObj.setProcInValue(nProcIndex4, "warrenty_date",(vo.getStrWarrantyDate()==null||vo.getStrWarrantyDate()=="")?"0":vo.getStrWarrantyDate(),6);
				daoObj.setProcInValue(nProcIndex4, "manuf_id",(vo.getStrWarantyManufacturer()==null||vo.getStrWarantyManufacturer()=="")?"0":vo.getStrWarantyManufacturer(),7);
				daoObj.setProcInValue(nProcIndex4, "po_no", "0",8);
				daoObj.setProcInValue(nProcIndex4, "warrenty_upto",(vo.getStrWarrantyUpTo()==null||vo.getStrWarrantyUpTo()=="")?"0":vo.getStrWarrantyUpTo(),9);
				daoObj.setProcInValue(nProcIndex4, "warrenty_unitid",(vo.getStrWarrantyUpToUnit()==null||vo.getStrWarrantyUpToUnit()=="")?"0":vo.getStrWarrantyUpToUnit(),10);
				daoObj.setProcInValue(nProcIndex4, "fin_start_yr",(vo.getStrFinancialStartYear()==null||vo.getStrFinancialStartYear()=="")?"0":vo.getStrFinancialStartYear() ,11);
				daoObj.setProcInValue(nProcIndex4, "fin_end_yr",(vo.getStrFinancialEndYear()==null||vo.getStrFinancialEndYear()=="")?"0":vo.getStrFinancialEndYear() ,12);
				daoObj.setProcInValue(nProcIndex4, "remarks",(vo.getStrWarrantyRemarks()==null||vo.getStrWarrantyRemarks()=="")?"0":vo.getStrWarrantyRemarks() ,13);
				daoObj.setProcInValue(nProcIndex4, "seat_id",(vo.getStrSeatId()==null||vo.getStrSeatId()=="")?"0":vo.getStrSeatId() ,14);				
				daoObj.setProcInValue(nProcIndex4, "strId", "0",15);
				daoObj.setProcInValue(nProcIndex4, "transno", "0",16);
				daoObj.setProcOutValue(nProcIndex4, "err", 1,17);

				daoObj.execute(nProcIndex4, 1);
			}

			if (vo.getStrIsInstallDetails().equals("1")) 
			{
				strProcName5 = "{call pkg_mms_dml.dml_installation_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				nProcIndex5 = daoObj.setProcedure(strProcName5);

				daoObj.setProcInValue(nProcIndex5, "modval", "1",1);
				daoObj.setProcInValue(nProcIndex5, "item_id",(vo.getStrItemId()==null||vo.getStrItemId()=="")?"0":vo.getStrItemId() ,2);
				daoObj.setProcInValue(nProcIndex5, "item_brand_id",(vo.getStrItemBrandId()==null||vo.getStrItemBrandId()=="")?"0":vo.getStrItemBrandId() ,2);
				daoObj.setProcInValue(nProcIndex5, "batch_sl_no",(vo.getStrBatchNo()==null||vo.getStrBatchNo()=="")?"0":vo.getStrBatchNo() ,3);
				daoObj.setProcInValue(nProcIndex5, "hosp_code",(vo.getStrHospitalCode()==null||vo.getStrHospitalCode()=="")?"0":vo.getStrHospitalCode() ,4);
				daoObj.setProcInValue(nProcIndex5, "install_start_date",(vo.getStrInstallStartDate()==null||vo.getStrInstallStartDate()=="")?"0":vo.getStrInstallStartDate(),5);
				daoObj.setProcInValue(nProcIndex5, "install_end_date",(vo.getStrInstallEndDate()==null||vo.getStrInstallEndDate()=="")?"0":vo.getStrInstallEndDate(),6);
				daoObj.setProcInValue(nProcIndex5, "po_no","0",7);
				daoObj.setProcInValue(nProcIndex5, "install_status",(vo.getStrInstallStatus()==null||vo.getStrInstallStatus()=="")?"0":vo.getStrInstallStatus(),8);
				daoObj.setProcInValue(nProcIndex5, "install_by",(vo.getStrInstallBy()==null||vo.getStrInstallBy()=="")?"0":vo.getStrInstallBy() ,9);
				daoObj.setProcInValue(nProcIndex5, "installer_contactNo",(vo.getStrInstallerContactNo()==null||vo.getStrInstallerContactNo()=="")?"0":vo.getStrInstallerContactNo(),10);
				daoObj.setProcInValue(nProcIndex5, "fin_start_yr",(vo.getStrFinancialStartYear()==null||vo.getStrFinancialStartYear()=="")?"0":vo.getStrFinancialStartYear(),11);
				daoObj.setProcInValue(nProcIndex5, "fin_end_yr",(vo.getStrFinancialEndYear()==null||vo.getStrFinancialEndYear()=="")?"0":vo.getStrFinancialEndYear(),12);
				daoObj.setProcInValue(nProcIndex5, "remarks",(vo.getStrWarrantyRemarks()==null||vo.getStrWarrantyRemarks()=="")?"0":vo.getStrWarrantyRemarks() ,13);
				daoObj.setProcInValue(nProcIndex5, "seat_id",(vo.getStrSeatId()==null||vo.getStrSeatId()=="")?"0":vo.getStrSeatId() ,14);				
				daoObj.setProcInValue(nProcIndex5, "strId","0",15);
				daoObj.setProcInValue(nProcIndex5, "transno","0",16);
				daoObj.setProcOutValue(nProcIndex5, "err", 1,17);

				daoObj.execute(nProcIndex5, 1);
			}
			
			if(vo.getStrParamCheck() != null) 
				if (vo.getStrParamCheck().length > 0) 
				{
					for (int i = 0; i < vo.getStrParamCheck().length; i++) 
					{

					String[] strTemp = vo.getStrParamCheck()[i].replace("^","#").split("#");

					itemParameterDetailDAO.setStrHospitalCode(vo.getStrHospitalCode());
					itemParameterDetailDAO.setStrSeatId(vo.getStrSeatId());
					itemParameterDetailDAO.setStrItemId(vo.getStrItemBrandId());
					itemParameterDetailDAO.setStrParentParamId(strTemp[0]);
					itemParameterDetailDAO.setStrParamId(strTemp[1]);
					itemParameterDetailDAO.setStrParamValue(vo.getStrParamValue()[i]);
					itemParameterDetailDAO.setStrRemarks("0");

					itemParameterDetailDAO.insertItemParameterDtls(daoObj);
				}
			}
			*/

			daoObj.fire();
			flag = true;

			if(flag)
			{
				GiftedItemDetailsTransDAO.updateCurrStock(vo);
			}			
			String strSlNo = daoObj.getString(nProcIndex, "retSerialNo");

			if (strSlNo != null)
				vo.setStrSerialNo(strSlNo);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("GiftedItemDetailsTransDAO.insert() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
			itemParameterDetailDAO = null;
		}
	}
	
	
	public static void updateCurrStock(GiftedItemDetailsTransVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try 
		{
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			strproc_name = "{call PKG_MMS_DML.Update_Rac_CurrStock(?,?,?,?,?,?,?,?,?,?,?)}"; // 11 variables
   
			String strItemBrandId =  vo.getStrItemBrandId().split("\\$")[0];
			String strItemId      =  vo.getStrItemBrandId().split("\\$")[1];
			String strGroupId     =  vo.getStrItemBrandId().split("\\$")[2];
			
		
			nprocIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nprocIndex,  "modval", "1",1);                 //1
			dao.setProcInValue(nprocIndex,  "hosp_code", vo.getStrHospitalCode(),2); //6
			dao.setProcInValue(nprocIndex,  "item_cat_no", vo.getStrItemCategoryNo(),3);//7
			dao.setProcInValue(nprocIndex,  "stockstatuscode",vo.getStrStockStatus(),4);        //8		
			dao.setProcInValue(nprocIndex,  "strid", vo.getStrStoreId(),5);   //2
			dao.setProcInValue(nprocIndex,  "batchno", vo.getStrBatchNo(),6);        //5
			dao.setProcInValue(nprocIndex,  "itembrandid", strItemBrandId,7);//4		
			dao.setProcInValue(nprocIndex,  "itemid", strItemId,8);   //3
			dao.setProcInValue(nprocIndex,  "rackNumber", (vo.getStrRackNumber()==null?"0":vo.getStrRackNumber()),9);//9
			dao.setProcInValue(nprocIndex,  "old_itemserialno", "0",10);//10
			dao.setProcOutValue(nprocIndex, "err", 1,11);//11
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("GiftedItemDetailsTransDAO.updateCurrStock() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null) 
			{				
				dao.free();
				dao = null;
			}
		}
	}
	

	/**
	 * The following procedure is used to populate the value of Unit Name combo
	 * using Pkg_Mms_View.Proc_Gblt_Unit_Mst procedure.
	 * 
	 * 
	 */
	public static void unitNameCombo(GiftedItemDetailsTransVO vo) {
		String strFuncName = "";
		String strProcName = "";

		int nFuncIndex = 0;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;
		String strUnitRate = "";

		try {

			daoObj = new HisDAO("ItemInventoryTrans", "GiftedItemDetailsTransDAO");
			strFuncName = "{? = call mms_mst.get_inventory_unitid(?::numeric, ?::numeric, ?::numeric, ?::numeric)}";
			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";

			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, "1");
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 4, vo.getStrItemCategoryNo().equalsIgnoreCase("")?"0": vo.getStrItemCategoryNo());
			daoObj.setFuncInValue(nFuncIndex, 5, vo.getStrItemId());
		
			daoObj.setFuncOutValue(nFuncIndex, 3);
			daoObj.executeFuncForNumeric(nFuncIndex);
			strUnitRate = daoObj.getFuncNumeric(nFuncIndex).toString();
			vo.setStrUnitRateID(strUnitRate);
			
//			System.out.println("vo.getStrUnitRateID()---------->"+vo.getStrUnitRateID());
			
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo
					.getStrHospitalCode(),1);
			daoObj.setProcInValue(nProcIndex, "unit_id", vo.getStrUnitRateID(),2);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",4);
			daoObj.setProcInValue(nProcIndex, "module_id", "",3); // Default value
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
			vo.setStrMsgString("GiftedItemDetailsTransDAO.unitNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	
	  public static void getVoucherDtl(GiftedItemDetailsTransVO vo) 
	  { 
		  String strProcName = "{call pkg_mms_view.proc_gift_voucher_dtl(?,?,?,?)}"; // variables	  
		  int nProcIndex = 0; String strErr = ""; 
		  WebRowSet ws = null; HisDAO
		  daoObj=null; 
		  try 
		  { 
				  daoObj=new HisDAO("ItemInventoryTrans", "GiftedItemDetailsTransDAO"); 
			      nProcIndex = daoObj.setProcedure(strProcName);
			
			      daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),1);
			      daoObj.setProcInValue(nProcIndex, "transaction_No", vo.getTransactionNumber(),2);
			  
			  
			      daoObj.setProcOutValue(nProcIndex, "err",1,3);
			      daoObj.setProcOutValue(nProcIndex, "resultset",2,4);
			      daoObj.executeProcedureByPosition(nProcIndex);
			  
			      strErr = daoObj.getString(nProcIndex, "err"); 
			      if (strErr == null) 
			    	  strErr =""; 
			      ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			 
			  if (strErr.equals(""))
		      {
			  vo.setWsGiftItemDetail(ws);; 
			  } 
			  else 
			  { 
				  throw new Exception(strErr);
			  }
	      }
		  catch(Exception e) 
		  { e.printStackTrace();
		  vo.setStrMsgString("GiftedItemDetailsTransDAO.getVoucherDtl() --> " +
		  e.getMessage()); vo.setStrMsgType("1"); 
		  } 
	  }
	 	
	
	public static void unitInHandNameCombo(GiftedItemDetailsTransVO vo) {

		String strProcName = "";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {

			daoObj = new HisDAO("ItemInventoryTrans", "GiftedItemDetailsTransDAO");

			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo
					.getStrHospitalCode(),1);
			daoObj.setProcInValue(nProcIndex, "unit_id", vo
					.getStrInHandQuantityUnitID(),2);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",4);
			daoObj.setProcInValue(nProcIndex, "module_id", "",3);// default value
		      
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
			daoObj.executeProcedureByPosition(
					nProcIndex);

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
			vo.setStrMsgString("GiftedItemDetailsTransDAO.unitInHandNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void unitSaleNameCombo(GiftedItemDetailsTransVO vo) {

		String strProcName = "";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {

			daoObj = new HisDAO("ItemInventoryTrans", "GiftedItemDetailsTransDAO");

			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo
					.getStrHospitalCode(),1);
			daoObj.setProcInValue(nProcIndex, "unit_id", vo.getStrUnitSaleID(),2);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",4);
			daoObj.setProcInValue(nProcIndex, "module_id", "",3);// Default value
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
			vo.setStrMsgString("GiftedItemDetailsTransDAO.unitSaleNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void unitRateNameCombo(GiftedItemDetailsTransVO vo) {

		String strProcName = "";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {

			daoObj = new HisDAO("ItemInventoryTrans", "GiftedItemDetailsTransDAO");

			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo
					.getStrHospitalCode(),1);
			daoObj.setProcInValue(nProcIndex, "unit_id", vo.getStrUnitRateID(),2);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",4);
			daoObj.setProcInValue(nProcIndex, "module_id", "",3);// Default value
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
			vo.setStrMsgString("GiftedItemDetailsTransDAO.unitRateNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	
}
