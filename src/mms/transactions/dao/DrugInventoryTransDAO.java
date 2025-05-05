package mms.transactions.dao;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import java.util.Date;

import javax.sql.rowset.WebRowSet;

import com.ibm.icu.text.SimpleDateFormat;

import mms.transactions.vo.DrugInventoryTransVO;

/**
 * @author manas meher
 * 
 */

/**
 * ( MODIFY/UPDATE WAS NOT WORKING) Developer : Anshul Jindal ( TO CONTINUE AND
 * CORRECTIONS) Version : 1.0 Date : 20/Apr/2009
 * MODIFY BY AmIt KuMaR 30-Dec-2010
 * 
 */

public class DrugInventoryTransDAO 
{

	/**
	 * for getting option value of combo on add page (subgroup name )
	 * 
	 * 
	 */

	public static void initAddQuery(DrugInventoryTransVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			System.out.println("----- DrugInventoryTransDAO .PKG_MMS_VIEW.proc_store_subgroup_list [ Mode - 1] -----");
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

			if (strerr.equals("")) 
			{
				vo.setStrSubGroupComboWs(wb);

			} 
			else 
			{
				throw new Exception(strerr);
			}

			strproc_name = "{call PKG_MMS_VIEW.proc_storeitem_list(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "1",1);
			dao.setProcInValue(nprocIndex, "cat_no", vo.getStrItemCategoryNo(),2);
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId(),3);
			dao.setProcInValue(nprocIndex, "group_id", vo.getStrGroupId(),4);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),5);
			
			/* Start */
			dao.setProcInValue(nprocIndex, "item_id", "0",6);
			dao.setProcInValue(nprocIndex, "sub_group_id", "0",7);
			/* End */
			
			dao.setProcOutValue(nprocIndex, "err", 1,8);
			dao.setProcOutValue(nprocIndex, "resultset", 2,9);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");

			if (strerr.equals("")) 
			{
				
				vo.setStrItemNameComboWS(wb);

			} 
			else 
			{
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			vo.setStrMsgString("DrugInventoryTransDAO.initAddQuery() --> "
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
	 * for getting option value of combo on add page (subgroup name )
	 * 
	 * 
	 */

	public static void initAddQuery1(DrugInventoryTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
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

			if (strerr.equals("")) 
			{
				vo.setStrSubGroupComboWs(wb);

			} 
			else 
			{
				throw new Exception(strerr);
			}

			

		} catch (Exception e) {
			vo.setStrMsgString("DrugInventoryTransDAO.initAddQuery() --> "
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

	public static void getItemName(DrugInventoryTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			
			System.out.println("----- DrugInventoryTransDAO .PKG_MMS_VIEW.proc_storeitem_list [ Mode - 1] -----");
			strproc_name = "{call PKG_MMS_VIEW.proc_storeitem_list(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcInValue(nprocIndex, "group_id", vo.getStrGroupId(),5);
			dao.setProcInValue(nprocIndex, "sub_group_id", vo.getStrSubGroupId(),6);
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId(),2);
			dao.setProcInValue(nprocIndex, "cat_no", vo.getStrItemCategoryNo(),4);
			dao.setProcInValue(nprocIndex, "hosp_code", Config.SUPER_USER_HOSPITAL_CODE,7);
			/* Start */    
			dao.setProcInValue(nprocIndex, "item_id", "0",3);  
			/* End */
			dao.setProcOutValue(nprocIndex, "err", 1,8);
			dao.setProcOutValue(nprocIndex, "resultset", 2,9);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");

			if (strerr.equals("")) {
				vo.setStrItemNameComboWS(wb);
				//System.out.println("vo.getStrItemNameComboWS().size() :"+vo.getStrItemNameComboWS().size()); 

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("DrugInventoryTransDAO.getItemName() --> "
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

	public static void getDummyItemName(DrugInventoryTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			
			System.out.println("----- DrugInventoryTransDAO .PKG_MMS_VIEW.proc_itembrand_list [ Mode - 1] -----");
			strproc_name = "{call PKG_MMS_VIEW.proc_itembrand_list(?,?,?,?,?, ?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
   
			dao.setProcInValue(nprocIndex,  "modeval","1",1);
			dao.setProcInValue(nprocIndex,  "catCode","10",2);
			
			dao.setProcInValue(nprocIndex,  "item_id","0",3);
			dao.setProcInValue(nprocIndex,  "grpId","0",4);
			dao.setProcInValue(nprocIndex,  "subGrpId","0",5);
			dao.setProcInValue(nprocIndex,  "setFlag","0",6);
			
			dao.setProcInValue(nprocIndex,  "hosp_code",vo.getStrHospitalCode(),7);
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
			vo.setStrMsgString("DrugInventoryTransDAO.getDummyItemName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	

	public static void GetGroupNameCombo(DrugInventoryTransVO vo) {
		String err = "";
	
		String proc_name1 = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			hisutil = new HisUtil("master", "DrugInventoryTransDAO");
			dao = new HisDAO("mms",
					"DrugInventoryTransDAO.GetGroupNameCombo(DrugInventoryTransVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

            dao.setProcInValue(procIndex1, "modeval", "2",1);
			
			dao.setProcInValue(procIndex1, "item_category", vo.getStrItemCategoryNo(),2);
			
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),3);
			
			/*start*/
			dao.setProcInValue(procIndex1, "strPhyStockNo","",4);
			dao.setProcInValue(procIndex1, "strStoreId", "",5);
			/*end*/

			dao.setProcOutValue(procIndex1, "err", 1,6); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2,7); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			if (ws != null && ws.size() != 0) 
			{
				str = hisutil.getOptionValue(ws, "-1", "0^All", true);
				vo.setStrGroupNameCombo(str);
			}
			else 
			{
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrGroupNameCombo(str);
			}
		} 
		catch (Exception e) 
		{
			vo
					.setStrMsgString("DrugInventoryTransDAO.GetGroupNameCombo() --> "
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

	public static void getItemBrandName(DrugInventoryTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			
			System.out.println("----- DrugInventoryTransDAO .PKG_MMS_VIEW.proc_storeitem_list [ Mode - 2] -----");
			
			strproc_name = "{call PKG_MMS_VIEW.proc_storeitem_list(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "2",1);
			
			
			dao.setProcInValue(nprocIndex, "item_id", vo.getStrItemId(),3);
			dao.setProcInValue(nprocIndex, "group_id", vo.getStrGroupId(),5);
			dao.setProcInValue(nprocIndex, "sub_group_id", vo.getStrSubGroupId(),6);
			dao.setProcInValue(nprocIndex, "store_id", vo.getStrStoreId(),2);
			dao.setProcInValue(nprocIndex, "cat_no", vo.getStrItemCategoryNo(),4);
			dao.setProcInValue(nprocIndex, "hosp_code", Config.SUPER_USER_HOSPITAL_CODE,7);
			
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
			vo.setStrMsgString("DrugInventoryTransDAO.getItemBrandName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getGroupId(DrugInventoryTransVO vo) 
	{

		HisDAO dao = null;

		try 
		{

			dao = new HisDAO("mms", "DrugInventoryTransDAO");

			String strFuncName = "{? = call mms_mst.get_groupNameAndId_dtl(?::numeric, ?::numeric, ?::numeric)}";
			//FUNCTION get_groupNameAndId_dtl (modeval NUMBER, hosp_code NUMBER, itemId NUMBER)
			int nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrItemId());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);

			String strRegFlag = dao.getFuncString(nFuncIndex);
			
            vo.setStrGroupId(strRegFlag.split("\\^")[0]);
			vo.setStrGroupName(strRegFlag.split("\\^")[1]);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DrugInventoryTransDAO.getGroupId() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getItemQCType(DrugInventoryTransVO vo) 
	{

		HisDAO dao = null;

		try 
		{

			dao = new HisDAO("mms", "DrugInventoryTransDAO");

			String strFuncName = "{? = call mms_mst.get_ItemQc_Type(?::numeric, ?::numeric, ?::numeric)}";

			int nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrItemBrandId());
			dao.setFuncOutValue(nFuncIndex, 3);
			dao.executeFuncForNumeric(nFuncIndex);

			String strRegFlag = dao.getFuncNumeric(nFuncIndex).toString();

			vo.setStrQcTypeFlg(strRegFlag);
			

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("DrugInventoryTransDAO.getItemQCType() --> "
					+ e.getMessage());
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

	public static void getBrandDetails(DrugInventoryTransVO vo) 
	{

		HisDAO dao = null;

		try 
		{

			dao = new HisDAO("mms", "DrugInventoryTransDAO");

			String strFuncName = "{? = call mms_mst.get_brand_ResFlag(?::numeric, ?::numeric, ?::numeric)}";

			int nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrItemBrandId());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);

			String strRegFlag = dao.getFuncString(nFuncIndex);

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

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("DrugInventoryTransDAO.getBrandDetails() --> "
					+ e.getMessage());
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
	 * The following procedure is used to populate the value of Already Existing Batch in 
	 * HSTT_DRUG_CURRSTOCK_DTL 
	 * combo using Pkg_Mms_View.proc_supplier_list procedure.
	 * 
	 * 
	 */

	public static void getExistingBatchInStock(DrugInventoryTransVO vo) 
	{

		HisDAO dao = null;

		try 
		{

			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			
			System.out.println("----- DrugInventoryTransDAO .mms_mst.get_BatchExist_Flag -----");

			String strFuncName = "{? = call mms_mst.get_BatchExist_Flag(?::numeric,?::numeric,?::numeric,?::numeric,?,?::numeric,?::numeric)}";
		    	      
			int nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrItemId());
			dao.setFuncInValue(nFuncIndex, 5, vo.getStrItemBrandId());
			dao.setFuncInValue(nFuncIndex, 6, vo.getStrBatchNo());
			dao.setFuncInValue(nFuncIndex, 7, "0");
			dao.setFuncInValue(nFuncIndex, 8, vo.getStrStoreId());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			String strRegFlag = dao.getFuncString(nFuncIndex);
			vo.setStrBatchExistInStockFlg(strRegFlag);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("DrugInventoryTransDAO.getExistingBatchInStock() --> "
					+ e.getMessage());
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
	 * The following procedure is used to populate the value of Already Existing Batch in 
	 * HSTT_DRUG_CURRSTOCK_DTL 
	 * combo using Pkg_Mms_View.proc_supplier_list procedure.
	 * 
	 * 
	 */

	public static void getExistingBatchList(DrugInventoryTransVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try 
		{
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			
			System.out.println("----- DrugInventoryTransDAO .PKG_MMS_VIEW.proc_ExistingBatch_list [ Mode - "+vo.getStrMode()+"]-----");
			
			strproc_name = "{call PKG_MMS_VIEW.proc_ExistingBatch_list(?,?,?,?,?,?,?)}";
						
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "p_modeval", vo.getStrMode(),1);
			dao.setProcInValue(nprocIndex, "p_HSTNUM_STORE_ID", vo.getStrStoreId(),2);
			dao.setProcInValue(nprocIndex, "p_HSTNUM_ITEM_ID", vo.getStrItemId(),3);
			dao.setProcInValue(nprocIndex, "p_HSTNUM_ITEMBRAND_ID",vo.getStrItemBrandId(),4);
			dao.setProcInValue(nprocIndex, "p_GNUM_HOSPITAL_CODE", vo.getStrHospitalCode(),5);
			
			dao.setProcOutValue(nprocIndex, "err", 1,6);
			dao.setProcOutValue(nprocIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) 
			{
				////System.out.println("DAO -->" + wb.size());
				vo.setStrExistingBatchComboWS(wb);

			} 
			else 
			{
				throw new Exception(strerr);
			}
		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("DrugInventoryTransDAO.getExistingBatchList() --> "+ e.getMessage());
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
	 * The following procedure is used to populate the value of Supplier Name
	 * combo using Pkg_Mms_View.proc_supplier_list procedure.
	 * 
	 * 
	 */

	public static void getSuppliedByList(DrugInventoryTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			
			System.out.println("----- DrugInventoryTransDAO .PKG_MMS_VIEW.proc_supplier_list [ Mode - 1 ]-----");
			
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "1",1);
			dao
					.setProcInValue(nprocIndex, "catCode", vo
							.getStrItemCategoryNo(),2);
			dao
					.setProcInValue(nprocIndex, "hosp_code", vo
							.getStrHospitalCode(),5);
			
			/* Start */
			dao.setProcInValue(nprocIndex, "branditem_id", "0",3);
			dao.setProcInValue(nprocIndex, "contractType", "0",4);
			/* End */
			
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
			vo.setStrMsgString("DrugInventoryTransDAO.getSuppliedByList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getCurrencyList(DrugInventoryTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_currency_list(?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "1",1);
			dao
					.setProcInValue(nprocIndex, "hosp_code", vo
							.getStrHospitalCode(),2);
			
			/* Start */
			dao.setProcInValue(nprocIndex, "isDefault", "0",3);
			/* End */
			
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
			vo.setStrMsgString("DrugInventoryTransDAO.getCurrencyList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void getStockStatusList(DrugInventoryTransVO vo) {

        String strproc_name = "";
        HisDAO dao = null;
        int nprocIndex = 0;
        String strerr = "";
        WebRowSet wb = null;

        try {
            dao = new HisDAO("mms", "DrugInventoryTransDAO");
            strproc_name = "{call PKG_MMS_VIEW.proc_stock_status_list(?,?,?,?,?,?)}";
            nprocIndex = dao.setProcedure(strproc_name);

            dao.setProcInValue(nprocIndex, "modeval", "1",1);
            dao
                    .setProcInValue(nprocIndex, "hosp_code", vo
                            .getStrHospitalCode(),2);
            dao.setProcInValue(nprocIndex, "itemCat", "",3); //Aritra
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
                    .setStrMsgString("DrugInventoryTransDAO.getStockStatusList() --> "
                            + e.getMessage());
            vo.setStrMsgType("1");
        } finally {
            if (dao != null) {
                dao.free();
                dao = null;
            }
        }
    }
    

	public static void getmanufectuteName(DrugInventoryTransVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			
			System.out.println("----- DrugInventoryTransDAO .PKG_MMS_VIEW.proc_supplier_list [ Mode - 6 ]-----");
			
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "6",1);
			
			dao.setProcInValue(nprocIndex, "catCode", vo
							.getStrItemCategoryNo(),2);
			dao.setProcInValue(nprocIndex, "branditem_id", vo
					.getStrItemBrandId(),3);
		
			dao.setProcInValue(nprocIndex, "hosp_code", vo
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
					.setStrMsgString("DrugInventoryTransDAO.getmanufectuteName() --> "
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
	 * to insert the data
	 * 
	 * 
	 */

	/*
	 * public static void insert(DrugInventoryTransVO vo) { String strErr1 = "";
	 * int nProcIndex = 0; HisDAO daoObj = null; DrugInventoryDAO
	 * drugnventoryDAO = null;
	 * 
	 * try {
	 * 
	 * daoObj = new HisDAO("DrugInventoryTrans", "DrugInventoryTransDAO");
	 * drugnventoryDAO = new DrugInventoryDAO();
	 * 
	 * drugnventoryDAO.setStrStoreId(vo.getStrStoreId());
	 * drugnventoryDAO.setStrItemId(vo.getStrItemId());
	 * drugnventoryDAO.setStrItemBrandId(vo.getStrItemBrandId());
	 * drugnventoryDAO.setStrBatchNo(vo.getStrBatchNo());
	 * drugnventoryDAO.setStrHospitalCode(vo.getStrHospitalCode());
	 * //drugnventoryDAO.setStrSlno("1"); // (commented by Anshul )it will be
	 * generated by function in procedure
	 * drugnventoryDAO.setStrItemCategoryNo("1");
	 * drugnventoryDAO.setStrGroupId(vo.getStrGroupId());
	 * drugnventoryDAO.setStrSubGroupId(vo.getStrSubGroupId());
	 * drugnventoryDAO.setStrExpirydate(vo.getStrExpirydate());
	 * drugnventoryDAO.setStrManufactureDate(vo.getStrManufactureDate());
	 * 
	 * 
	 * drugnventoryDAO.setStrInHandQuantity(vo.getStrInHandQuantity());
	 * System.out .println("dai in hend qty unit
	 * id-"+vo.getStrInHandQuantityUnitID()); drugnventoryDAO
	 * .setStrInHandQuantityUnitID(vo.getStrInHandQuantityUnitID().replace("^",
	 * "#").split("#")[0]);
	 * drugnventoryDAO.setStrUnitRateID(vo.getStrUnitRateID());
	 * drugnventoryDAO.setStrManufactureId(vo.getStrManufactureId());
	 * drugnventoryDAO.setStrRate(vo.getStrRate());
	 * drugnventoryDAO.setStrUnitRateID(vo.getStrUnitRateID());
	 * drugnventoryDAO.setStrSalePrice(vo.getStrSalePrice());
	 * drugnventoryDAO.setStrUnitIdSale(vo.getStrUnitSaleID().replace("^",
	 * "#").split("#")[0]); drugnventoryDAO.setStrConsumable_flag("1");
	 * drugnventoryDAO.setStrPoNo(vo.getStrPoNo());
	 * drugnventoryDAO.setStrItemStatus(vo.getStrItemStatus());
	 * drugnventoryDAO.setStrSeatId(vo.getStrSeatId());
	 * drugnventoryDAO.setStrIsValid("1");
	 * 
	 * drugnventoryDAO.insert(daoObj);
	 * 
	 * synchronized (daoObj) { daoObj.fire(); } strErr1 =
	 * daoObj.getString(nProcIndex, "err");
	 * 
	 * if (strErr1 == null) strErr1 = ""; if (strErr1.equals("")) {
	 *  } else { throw new Exception(strErr1); } } catch (Exception e) {
	 * 
	 * vo.setStrMsgString("DrugInventoryTransDAO.insert() --> " +
	 * e.getMessage()); vo.setStrMsgType("1");
	 *  } finally { if (daoObj != null) { daoObj.free(); daoObj = null; } }
	 *  }
	 */

	public synchronized static void insert(DrugInventoryTransVO vo) {

		String    strProcName = "";
		String   strProcName2 = "";
		String   strProcName3 = "";
		int        nProcIndex = 0;
		int       nProcIndex2 = 0;
		int       nProcIndex3 = 0;
		HisDAO         daoObj = null;
		int j=0,    actualQty = 0,freeItemQty=0,actQtyplusFreeQty=0,k=0;
		String[]  freeItemDtl = null;
		boolean flag = false;
	  try 
		{
			     daoObj = new HisDAO("MMS", "DrugInventoryTransDAO");
			     Date date = new Date();  
				    SimpleDateFormat formatter =  new SimpleDateFormat("ddMMYYHHMM");  
				    String strDate = formatter.format(date);
				    System.out.println("----------------- INSERT --------------------");
			strProcName = "{call PKG_MMS_DML.Dml_Stock_Update(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // 54 Variable
			 nProcIndex = daoObj.setProcedure(strProcName);
			// Start Logic Here to add Free Item Qty with In-hand Qty if Free Item is in Same Category
			// And Save data into Drug Current Stock Details OtherWise If Different Category then save into 
			// Free Item Table [Added By Amit Kr 10-Dec-2010]
			if (vo.getStrItemOtherDtls() != null && vo.getStrItemOtherDtls().length > 0)
			{ 	
				                 freeItemDtl = new String[vo.getStrItemOtherDtls().length];
				for (int i = 0; i < vo.getStrItemOtherDtls().length; i++) 
				{

					String           strTemp = vo.getStrItemOtherDtls()[i];
					String[] strItemOtherVal = strTemp.replace("^", "#").split("#");
					             
					if(!strItemOtherVal[0].equals(vo.getStrItemCategoryNo()))
					{
						
						////System.out.println("Free Item Mai Add Hogga!!! Batch No:::::"+strItemOtherVal[3]+"!!!Iski Qty::::"+strItemOtherVal[6]);
						freeItemDtl[k] = strItemOtherVal[0]+"^"+strItemOtherVal[1]+"^"+strItemOtherVal[2]+"^"+strItemOtherVal[3]+"^"+strItemOtherVal[4]+"^"+strItemOtherVal[5]+"^"+strItemOtherVal[6];
						k++;
						
					}
					else
					{
						
						     actualQty  = Integer.parseInt(vo.getStrInHandQuantity());
						   freeItemQty  = Integer.parseInt(strItemOtherVal[6]);
						   
					    if(j>0)
					    {
					    	actQtyplusFreeQty = actQtyplusFreeQty + freeItemQty;
					    }
					    else
					    {
					    	actQtyplusFreeQty = actualQty + freeItemQty;
					    }							 
												 
						////System.out.println("Act Qty + Free Item Qty:::[Active Stock Mai Update Hogga]::::"+String.valueOf(actQtyplusFreeQty));
						j++;
					}	
				}
			}// Logic End Here			
			daoObj.setProcInValue(nProcIndex, "modval", "1",1);               //1
			daoObj.setProcInValue(nProcIndex, "strid", vo.getStrStoreId(),2); //2
			daoObj.setProcInValue(nProcIndex, "itemid", vo.getStrItemId(),3); //3
			daoObj.setProcInValue(nProcIndex, "itembrandid", vo.getStrItemBrandId(),4);//4
			daoObj.setProcInValue(nProcIndex, "batchno", vo.getStrBatchNo()+"~"+strDate,5); //5
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
			daoObj.setProcInValue(nProcIndex, "old_stockstatuscode", "1",29); //33
			daoObj.setProcInValue(nProcIndex, "old_batchno", "0",30);   //34
			daoObj.setProcInValue(nProcIndex, "old_itemSerialNo", "0",31); //35
			daoObj.setProcInValue(nProcIndex, "old_itemid", "0",32);  //36
			daoObj.setProcInValue(nProcIndex, "old_itembrandid", "0",33); //37
			daoObj.setProcInValue(nProcIndex, "old_strid", "0",34);  //38
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
			
								

			strProcName2 = "{call PKG_MMS_DML.Dml_Hstt_Free_Items_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			if (vo.getStrItemOtherDtls() != null && vo.getStrItemOtherDtls().length > 0)
				for (int i = 0; i < vo.getStrItemOtherDtls().length; i++) 
				{

					String strTemp = vo.getStrItemOtherDtls()[i];
					String[] strItemOtherVal = strTemp.replace("^", "#").split("#");

					nProcIndex2 = daoObj.setProcedure(strProcName2);

					String strFreeBatch = strItemOtherVal[3];

					if (strFreeBatch == null || strFreeBatch.length() == 0) 
					{
						strFreeBatch = "0";
					}

					daoObj.setProcInValue(nProcIndex2, "modval", "1",1);                         //1
					daoObj.setProcInValue(nProcIndex2, "itemid", vo.getStrItemId(),2);           //2
					daoObj.setProcInValue(nProcIndex2, "itembrandid", vo.getStrItemBrandId(),3); //3
					daoObj.setProcInValue(nProcIndex2, "batchno", vo.getStrBatchNo(),4);         //4
					daoObj.setProcInValue(nProcIndex2, "freeitemid",strItemOtherVal[1],5);       //5
					daoObj.setProcInValue(nProcIndex2, "freeitembrandid",strItemOtherVal[2],6);  //6
					daoObj.setProcInValue(nProcIndex2, "freeitembatchno",strFreeBatch,7);        //7
					daoObj.setProcInValue(nProcIndex2, "freeitemcatno",strItemOtherVal[0],8);    //8
					daoObj.setProcInValue(nProcIndex2, "expirydate",strItemOtherVal[4],9);       //9
					daoObj.setProcInValue(nProcIndex2, "manufdate",	strItemOtherVal[5],10);       //10
					daoObj.setProcInValue(nProcIndex2, "qty",strItemOtherVal[6],11);              //11
					daoObj.setProcInValue(nProcIndex2, "qtyunitid",	strItemOtherVal[7],12);       //12
					daoObj.setProcInValue(nProcIndex2, "hosp_code", vo.getStrHospitalCode(),13);  //13
					
					/* Start */
					daoObj.setProcInValue(nProcIndex2, "transNo","0",14); //14
					daoObj.setProcInValue(nProcIndex2, "strId","0",15); //15
					/* End */

					daoObj.setProcOutValue(nProcIndex2, "err", 1,16);//16
					daoObj.setProcOutValue(nProcIndex2, "dml_count", 1,17); //17

					daoObj.execute(nProcIndex2, 1);

				}
			
			   strProcName3 = "{call PKG_MMS_DML.proc_HSTT_SUPP_CONS_DELVRY_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";// 26 Varibale's

			
			        nProcIndex3 = daoObj.setProcedure(strProcName3);								
					daoObj.setProcInValue(nProcIndex3, "p_mode", "1",1);                                    	     //1
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_STORE_ID", vo.getStrStoreId(),2);          	     //2
					daoObj.setProcInValue(nProcIndex3, "p_GNUM_HOSPITAL_CODE",vo.getStrHospitalCode(),3);  	     //3
					daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_PO_NO", (vo.getStrPoNo()==null || vo.getStrPoNo().equals("") || vo.getStrPoNo().equals("---"))?"0":vo.getStrPoNo(),4 );            	         //4
					daoObj.setProcInValue(nProcIndex3, "p_HSTDT_PO_DATE",(vo.getStrPoDate()==null ||vo.getStrPoDate().equals("null") || vo.getStrPoDate().equals("") || vo.getStrPoDate().equals("---"))?"":vo.getStrPoDate(),5);            	     //5
					daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_CHALLAN_NO",(vo.getStrBillNo()==null || vo.getStrBillNo().equals("") || vo.getStrBillNo().equals("---"))?"0":vo.getStrBillNo(),6);        	     //6
					daoObj.setProcInValue(nProcIndex3, "p_HSTDT_CHALLAN_DATE",(vo.getStrBillDate()==null||vo.getStrBillDate().equals("null") || vo.getStrBillDate().equals("") || vo.getStrBillDate().equals("---")) ? vo.getStrReceivedDate():vo.getStrBillDate(),7); //7
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_REQTYPE_ID","58",8);   //Drug Inventory  		 //8
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_SUPPLIER_ID",vo.getStrSuppliedBy(),9);      	 	 //9
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_GROUP_ID",	vo.getStrGroupId(),10);         		 //10
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_ITEMBRAND_ID",vo.getStrItemBrandId(),11);    	  	 //11
					daoObj.setProcInValue(nProcIndex3, "p_HSTSTR_BATCH_NO",	vo.getStrBatchNo(),12);         		 //12
					daoObj.setProcInValue(nProcIndex3, "p_HSTDT_EXPIRY_DATE", vo.getStrExpiryDate(),13);  	 		//13
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_RECIEVED_QTY",vo.getStrInHandQuantity(),14);      	 //14
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_RECQTY_UNITID",vo.getStrInHandQuantityUnitID(),15); 	 //15
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_RETURNED_QTY","0",16);       				   //16
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_RETQTY_UNITID","",17);    				 //17
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_PURCHASE_RATE", vo.getStrRate(),18);     //18
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_ISSUE_RATE",vo.getStrSalePrice(),19);   //19
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_RATE_UNITID",vo.getStrUnitRateID(),20); //20
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_RECIEVE_COST",(vo.getStrDrugTotCost()==null || vo.getStrDrugTotCost().equals(""))?"0":vo.getStrDrugTotCost() ,21); 			//21
					daoObj.setProcInValue(nProcIndex3, "p_HSTNUM_RETURN_COST","0",22);			 //22
					daoObj.setProcInValue(nProcIndex3, "p_GNUM_ISVALID","1",23); 				//23
					daoObj.setProcInValue(nProcIndex3, "p_GDT_ENTRY_DATE","",24); 				//24
					daoObj.setProcInValue(nProcIndex3, "p_GNUM_SEATID",vo.getStrSeatId(),25); //25
					daoObj.setProcOutValue(nProcIndex3, "err", 1,26);                         //26

					daoObj.execute(nProcIndex3, 1);

					daoObj.fire();
					flag = true;
					
			if(flag)
			{
				DrugInventoryTransDAO.updateCurrStock(vo);
			}
		} 
	  catch (Exception e) 
	  {
			e.printStackTrace();
			//vo.setStrMsgString("DrugInventoryTransDAO.insert() --> "+ e.getMessage());
		   // //System.out.println("Err Msg::::"+e.getMessage().split("\\##")[1]);
		    
			 if(vo.getStrMsgString().split("\\##")[2].equals("999"))
			    {
 				////System.out.println("In Insufficent Drug:::"+vo.getStrMsgString().split("\\##")[1]);
				 vo.setStrMsgString(vo.getStrMsgString().split("\\##")[1]);
				 vo.setStrMsgType("5");
			    }
				else
				{
					vo.setStrMsgString(e.getMessage());
					vo.setStrMsgType("1");
				}				
		   
		} 
	  finally
	  {
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;

			}
		}

	}
	
	
	public synchronized static void insertDummy(DrugInventoryTransVO vo) 
	{

		String    strProcName = "";
		int        nProcIndex = 0;
		HisDAO         daoObj = null;
	  try 
		{
			     daoObj = new HisDAO("MMS", "DrugInventoryTransDAO");
			strProcName = "{call PKG_MMS_DML.dml_dummy_stock_update(?,?,?,?,?,  ?,?,?,?,?,  ?)}"; // 10 Variable

			nProcIndex = daoObj.setProcedure(strProcName);				
			
			 System.out.println("----------------- INSERT DUMMY--------------------");
			
			/*//System.out.println("strId"+ vo.getStrStoreId()); //1
			//System.out.println("brandId"+ vo.getStrItemBrandId());//2
			//System.out.println("batchNo"+ vo.getStrBatchNo()); //3
			//System.out.println("expDate"+ vo.getStrExpiryDate());  //4
			//System.out.println("mfgDate"+ vo.getStrManufactureDate()); //5
			//System.out.println("manufId"+ "0");    //6
			//System.out.println("activeQty"+ vo.getStrActiveQty());             //7
			//System.out.println("inactiveQty"+ vo.getStrInActiveQty());  //8    
			//System.out.println("quartineQty"+ vo.getStrQuarantineQty()); //9
			//System.out.println("seatId"+ vo.getStrSeatId()); //10
*/			
			
			
			
			
			daoObj.setProcInValue(nProcIndex, "strId", vo.getStrStoreId()); //1
			daoObj.setProcInValue(nProcIndex, "brandId", vo.getStrItemBrandId());//2
			daoObj.setProcInValue(nProcIndex, "batchNo", vo.getStrBatchNo()); //3
			daoObj.setProcInValue(nProcIndex, "expDate", vo.getStrExpiryDate());  //4
			daoObj.setProcInValue(nProcIndex, "mfgDate", vo.getStrManufactureDate()); //5
			daoObj.setProcInValue(nProcIndex, "manufId", "0");    //6
			daoObj.setProcInValue(nProcIndex, "activeQty", vo.getStrActiveQty());             //7
			daoObj.setProcInValue(nProcIndex, "inactiveQty", vo.getStrInActiveQty());  //8    
			daoObj.setProcInValue(nProcIndex, "quartineQty", vo.getStrQuarantineQty()); //9
			daoObj.setProcInValue(nProcIndex, "seatId", vo.getStrSeatId()); //10

			daoObj.setProcOutValue(nProcIndex, "err", 1);   //53

			daoObj.executeProcedureByPosition(nProcIndex);
			
								
		} 
	  catch (Exception e) 
	  {
		  		//e.printStackTrace();
		    	vo.setStrMsgString(e.getMessage());
				vo.setStrMsgType("1");
		} 
	  finally
	  {
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	
	public synchronized static void updateCurrStock(DrugInventoryTransVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try 
		{
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			
			
			strproc_name = "{call PKG_MMS_DML.Update_Rac_CurrStock(?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying,?::character varying)}"; // 11 variables
   
			
			nprocIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nprocIndex,  "modval", "1",1);                 //1
			dao.setProcInValue(nprocIndex,  "strid", vo.getStrStoreId(),5);   //2
			dao.setProcInValue(nprocIndex,  "itemid", vo.getStrItemId(),8);   //3
			dao.setProcInValue(nprocIndex,  "itembrandid", vo.getStrItemBrandId(),7);//4
			dao.setProcInValue(nprocIndex,  "batchno", vo.getStrBatchNo(),6);        //5
			dao.setProcInValue(nprocIndex,  "hosp_code", vo.getStrHospitalCode(),2); //6
			dao.setProcInValue(nprocIndex,  "item_cat_no", vo.getStrItemCategoryNo(),3);//7
			dao.setProcInValue(nprocIndex,  "stockstatuscode", "10",4);        //8
			dao.setProcInValue(nprocIndex,  "rackNumber", vo.getStrRackNumber(),9);//9
			dao.setProcInValue(nprocIndex,  "old_itemserialno", "0",10);//10
			dao.setProcOutValue(nprocIndex, "err", 1,11);//11
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("DrugInventoryTransDAO.updateCurrStock() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	

	/**
	 * retrieves and executes modify
	 */

	public synchronized static void modifyRecord(DrugInventoryTransVO vo) 
	{

		String strProcName = "";
		int nProcIndex = 0;
		HisDAO daoObj = null;
		WebRowSet web = null;

		try {
			daoObj = new HisDAO("MMS", "DrugInventoryTransDAO");
			
			System.out.println("----- DrugInventoryTransDAO .PKG_MMS_VIEW.proc_hstt_drug_currstock_view [ Mode - 1 ]-----");
			
			strProcName = "{call PKG_MMS_VIEW.proc_hstt_drug_currstock_view(?,?,?,?,?,?,?,?,?)}";

			nProcIndex = daoObj.setProcedure(strProcName);
			
	//System.out.println("Store Id:::"+vo.getStrStoreId());
		//System.out.println("Item Id::::"+vo.getStrItemId());
		//System.out.println("Item Brand Id:::::"+vo.getStrItemBrandId());
		//System.out.println("Batch No::::"+vo.getStrBatchNo());
		//System.out.println("Stock Status:::::"+vo.getStrStockStatus());
			
			daoObj.setProcInValue(nProcIndex, "modval", "1",1);
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "item_id", vo.getStrItemId(),3);
			daoObj.setProcInValue(nProcIndex, "itembrand_id", vo.getStrItemBrandId(),4);
			daoObj.setProcInValue(nProcIndex, "batch_no", vo.getStrBatchNo(),5);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),7);
			daoObj.setProcInValue(nProcIndex, "stockStatus", vo.getStrStockStatus(),6);
			daoObj.setProcOutValue(nProcIndex, "err", 1,8);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,9);

			// daoObj.execute(nProcIndex, 1);
			daoObj.executeProcedureByPosition(nProcIndex);

			/*
			 * synchronized (daoObj) { daoObj.fire(); }
			 */
			web = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("the sixe of web is:::::"+web.size());
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
				////System.out.println("Sale Price:::"+web.getString(16));
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
				vo.setStrManufactureId(web.getString("manufacturer_id"));
				vo.setStrRackNumber(web.getString(29));
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DrugInventoryTransDAO.modifyRecord() --> "
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

	public synchronized static void update(DrugInventoryTransVO vo) {

		String strProcName = "";
		String strProcName2 = "";
		String strProcName3 = "";

		int nProcIndex = 0;
		int nProcIndex2 = 0;
		int nProcIndex3 = 0;
		boolean flag = false;

		HisDAO daoObj = null;

		try {
			 System.out.println("----------------- UPDATE --------------------");
			daoObj = new HisDAO("MMS", "DrugInventoryTransDAO");
			/*strProcName = "{call PKG_MMS_DML.Dml_Stock_Update(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modval", "2");

			daoObj.setProcInValue(nProcIndex, "strid", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "itemid", vo.getStrItemId());
			daoObj.setProcInValue(nProcIndex, "itembrandid", vo.getStrItemBrandId());

			daoObj.setProcInValue(nProcIndex, "old_strid", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "old_itemid", vo.getStrItemId());
			daoObj.setProcInValue(nProcIndex, "old_itembrandid", vo.getStrItemBrandId());

			daoObj.setProcInValue(nProcIndex, "old_stockstatuscode", vo.getStrOldStockStatus());

			daoObj.setProcInValue(nProcIndex, "old_batchno", vo.getStrBatchNo());

			daoObj.setProcInValue(nProcIndex, "batchno", vo.getStrBatchNo());
			daoObj.setProcInValue(nProcIndex, "itemcatno", vo.getStrItemCategoryNo());
			daoObj.setProcInValue(nProcIndex, "expirydate", vo.getStrExpiryDate());
			daoObj.setProcInValue(nProcIndex, "manufdate", vo.getStrManufactureDate());
			daoObj.setProcInValue(nProcIndex, "stockstatuscode", vo.getStrStockStatus());
			daoObj.setProcInValue(nProcIndex, "inhandqty", vo.getStrInHandQuantity());
			daoObj.setProcInValue(nProcIndex, "inhandqtyunitid", vo.getStrInHandQuantityUnitID());
			daoObj.setProcInValue(nProcIndex, "suppid", vo.getStrManufactureId());
			daoObj.setProcInValue(nProcIndex, "rate", vo.getStrRate());
			////System.out.println("Update Rate Unit ID==>"+vo.getStrUnitRateID());
			daoObj.setProcInValue(nProcIndex, "rateunitid", vo.getStrUnitRateID());
			daoObj.setProcInValue(nProcIndex, "saleprice", vo.getStrSalePrice());
			////System.out.println("Update Sale Price Unit ID==>"+vo.getStrUnitSaleID());
			daoObj.setProcInValue(nProcIndex, "salepriceunitid", vo.getStrUnitSaleID());
			daoObj.setProcInValue(nProcIndex, "pono", vo.getStrPoNo());
			daoObj.setProcInValue(nProcIndex, "podate", vo.getStrPoDate());
			daoObj.setProcInValue(nProcIndex, "seatid", vo.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "suppliedBy", vo.getStrSuppliedBy());
			daoObj.setProcInValue(nProcIndex, "recievedDate", vo.getStrReceivedDate());
			daoObj.setProcInValue(nProcIndex, "description","Stock Qty Modified through Inventory Process");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());

			daoObj.setProcInValue(nProcIndex, "currencyCode", vo.getStrCurrencyCode());
			daoObj.setProcInValue(nProcIndex, "currencyValue", vo.getStrCurrencyValue());

			if (vo.getStrItemOtherDtls() != null && vo.getStrItemOtherDtls().length > 0) 
			{

				daoObj.setProcInValue(nProcIndex, "freeItemFlag", "1");

			} 
			else 
			{

				daoObj.setProcInValue(nProcIndex, "freeItemFlag", "0");
			}
			daoObj.setProcInValue(nProcIndex, "invoiceNo", vo.getStrBillNo());
			daoObj.setProcInValue(nProcIndex, "invoiceDate", vo.getStrBillDate());
			daoObj.setProcInValue(nProcIndex, "item_specification", vo.getStrItemSpecification());
			
			
			daoObj.setProcInValue(nProcIndex, "groupid", "");
			daoObj.setProcInValue(nProcIndex, "subgroupid", "0");
			daoObj.setProcInValue(nProcIndex, "inventoryflag", "");
			daoObj.setProcInValue(nProcIndex, "old_itemSerialNo", "0");
			daoObj.setProcInValue(nProcIndex, "itemParamFlag", "0");
			daoObj.setProcInValue(nProcIndex, "partFlag", "0");
			daoObj.setProcInValue(nProcIndex, "warrentyFlag", "0");
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

			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "retSerialNo", 1);

			daoObj.execute(nProcIndex, 1);*/
			Date date = new Date();  
		    SimpleDateFormat formatter =  new SimpleDateFormat("ddMMYYHHMM");  
		    String strDate = formatter.format(date);
			
			//altered by anshul for postgres compatability
			strProcName = "{call PKG_MMS_DML.Dml_Stock_Update(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,? ,?,?,?,?)}"; // 54 Variable
			 nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modval", "2",1);               //1
			daoObj.setProcInValue(nProcIndex, "strid", vo.getStrStoreId(),2); //2
			daoObj.setProcInValue(nProcIndex, "itemid", vo.getStrItemId(),3); //3
			daoObj.setProcInValue(nProcIndex, "itembrandid", vo.getStrItemBrandId(),4);//4
			daoObj.setProcInValue(nProcIndex, "batchno", vo.getStrBatchNo()+"~"+strDate,5); //5
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
			daoObj.setProcInValue(nProcIndex, "old_stockstatuscode", "1",29); //33
			daoObj.setProcInValue(nProcIndex, "old_batchno", "0",30);   //34
			daoObj.setProcInValue(nProcIndex, "old_itemSerialNo", "0",31); //35
			daoObj.setProcInValue(nProcIndex, "old_itemid", "0",32);  //36
			daoObj.setProcInValue(nProcIndex, "old_itembrandid", "0",33); //37
			daoObj.setProcInValue(nProcIndex, "old_strid", "0",34);  //38
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

			daoObj.fire();
			flag = true;
			
			if(flag)
			{
				DrugInventoryTransDAO.updateCurrStock(vo);
			}

			vo.setBExistStatus(true);

		} catch (Exception e) {
			e.printStackTrace();

			vo.setBExistStatus(false);

			vo.setStrMsgString("DrugInventoryTransDAO.update() --> "
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
	public static void unitNameCombo(DrugInventoryTransVO vo) {
		String strFuncName = "";
		String strProcName = "";

		int nFuncIndex = 0;
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;
		String strUnitRate = "";

		try {
			
			System.out.println("----- DrugInventoryTransDAO.unitNameCombo .PKG_MMS_VIEW.Proc_Gblt_Unit_Mst [ Mode - 1 ]-----");

			daoObj = new HisDAO("DrugInventoryTrans", "DrugInventoryTransDAO");
			strFuncName = "{? = call mms_mst.get_inventory_unitid(?::numeric, ?::numeric, ?::numeric, ?::numeric)}";
			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";

			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, "1");
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 4, "1");
			
			daoObj.setFuncInValue(nFuncIndex, 5, vo.getStrItemId());
			daoObj.setFuncOutValue(nFuncIndex, 3);
			daoObj.executeFuncForNumeric(nFuncIndex);
			strUnitRate = daoObj.getFuncNumeric(nFuncIndex).toString();
			vo.setStrUnitRateID(strUnitRate);
			//System.out.println("strUnitRate >>>"+strUnitRate);

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo
					.getStrHospitalCode(),1);
			daoObj.setProcInValue(nProcIndex, "unit_id", "6301",2);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",4);
			daoObj.setProcInValue(nProcIndex, "module_id", "63",3);//Aritra
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
			vo.setStrMsgString("DrugInventoryTrans.unitNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void unitInHandNameCombo(DrugInventoryTransVO vo) {

		String strProcName = "";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {

			daoObj = new HisDAO("DrugInventoryTrans", "DrugInventoryTransDAO");
			
			System.out.println("----- DrugInventoryTransDAO.unitInHandNameCombo .PKG_MMS_VIEW.Proc_Gblt_Unit_Mst [ Mode - 1 ]-----");

			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?, ?,?, ?,?)}";

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),1);
			daoObj.setProcInValue(nProcIndex, "unit_id", "6301",2);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",4);
			daoObj.setProcInValue(nProcIndex, "module_id", "63",3);//Aritra
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
			vo.setStrMsgString("DrugInventoryTrans.unitInHandNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void unitSaleNameCombo(DrugInventoryTransVO vo) {

		String strProcName = "";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {

			daoObj = new HisDAO("DrugInventoryTrans", "DrugInventoryTransDAO");
			
			System.out.println("----- DrugInventoryTransDAO.unitSaleNameCombo .PKG_MMS_VIEW.Proc_Gblt_Unit_Mst [ Mode - 1 ]-----");

			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo
					.getStrHospitalCode(),1);
			daoObj.setProcInValue(nProcIndex, "unit_id", "6301",2);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",4);
			daoObj.setProcInValue(nProcIndex, "module_id", "63",3);//Aritra
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
			vo.setStrMsgString("DrugInventoryTrans.unitSaleNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void unitRateNameCombo(DrugInventoryTransVO vo) {

		String strProcName = "";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {

			daoObj = new HisDAO("DrugInventoryTrans", "DrugInventoryTransDAO");
			
			System.out.println("----- DrugInventoryTransDAO.unitRateNameCombo .PKG_MMS_VIEW.Proc_Gblt_Unit_Mst [ Mode - 1 ]-----");

			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo
					.getStrHospitalCode(),1);
			daoObj.setProcInValue(nProcIndex, "unit_id", "6301",2);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",4);
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
			vo.setStrMsgString("DrugInventoryTrans.unitRateNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void getStockModifyValue(DrugInventoryTransVO vo) {
		String strFuncName = "";

		int nFuncIndex = 0;

		HisDAO daoObj = null;
		String strModify = "";

		try {

			daoObj = new HisDAO("DrugInventoryTrans", "DrugInventoryTransDAO");
			

			System.out.println("----- DrugInventoryTransDAO.getStockModifyValue .Mms_Mst.get_StockModify_Dtls-----");
			
			strFuncName = "{? = call Mms_Mst.get_StockModify_Dtls(?::numeric, ?::numeric, ?::numeric, ?, ?, ?::numeric, ?::numeric)}";

			nFuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 3, "1");
			daoObj.setFuncInValue(nFuncIndex, 4, vo.getStrStoreId());
			daoObj.setFuncInValue(nFuncIndex, 5, "0");
			daoObj.setFuncInValue(nFuncIndex, 6, vo.getStrBatchNo());
			daoObj.setFuncInValue(nFuncIndex, 7, vo.getStrItemId());
			daoObj.setFuncInValue(nFuncIndex, 8, vo.getStrItemBrandId());
			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);
			strModify = daoObj.getFuncString(nFuncIndex);

			vo.setStrModifyValue(strModify);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DrugInventoryTrans.getStockModifyValue() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

}
