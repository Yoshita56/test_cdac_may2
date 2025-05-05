/**
 * 
 */
package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.ItemLocationTransVO;

/**
 * @author user
 *
 */
public class ItemLocationTransDAO {
	
	
	/**
	 * To get Drug Warehouse Combo  from the hstt_store_mst
	 *  
	 * @param voObj
	 */
	public static void getStoreList(ItemLocationTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj=new HisDAO("Item Location","ItemLocationTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			if(voObj.getStrItemCategoryNo().equals("1"))
				daoObj.setProcInValue(nProcIndex, "modeval", "9",1);
			else
				daoObj.setProcInValue(nProcIndex, "modeval", "10",1);
			daoObj.setProcInValue(nProcIndex, "seatid", voObj.getStrSeatId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "storeid", "10",4);
			daoObj.setProcInValue(nProcIndex, "storetype_id","0",5); 
			daoObj.setProcOutValue(nProcIndex, "err", 1,6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);
			
			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				//System.out.println("getStoreList size :"+ws.size());
		
				voObj.setStrStoreWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("ItemLocationTransDAO.getStoreList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	/**
	 * To get Drug Warehouse Type Combo
	 *  
	 * @param voObj
	 */
	public static void getDwhTypeCombo(ItemLocationTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_sstt_dwh_type_mst_cmb(?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj=new HisDAO("Item Location","ItemLocationTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			                   
		        
		       
			
			daoObj.setProcInValue(nProcIndex, "p_mode", "1",1);
			daoObj.setProcInValue(nProcIndex, "p_gnum_hospital_code", voObj.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "p_sstnum_is_district_dwh", "0",3);
			daoObj.setProcOutValue(nProcIndex, "err", 1,4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,5);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				//System.out.println("getDwhTypeCombo size :"+ws.size());
//				voObj.setStrDrugWarehouseTypeWs(ws);
				
				voObj.setStrStoreTypeWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("ItemLocationTransDAO.getDwhTypeCombo() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	/**
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void itemCategoryName(ItemLocationTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_itemcategory_user_list(?,?,?,?,?)}";
		String strProcName1 = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}"; //5+1=6
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Item Location","ItemLocationTransDAO");
			
		//	if(vo.getStrStoreId().equals("0")){
				nProcIndex = daoObj.setProcedure(strProcName);
				daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
				daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
				daoObj.setProcInValue(nProcIndex, "seat_id", vo.getStrSeatId(),3);
				daoObj.setProcOutValue(nProcIndex, "err",1,4); 
				daoObj.setProcOutValue(nProcIndex, "resultset",2,5);
				daoObj.executeProcedureByPosition(nProcIndex);
//			}
//			else {
//				nProcIndex = daoObj.setProcedure(strProcName1);
//				daoObj.setProcInValue(nProcIndex, "modeval", "1",1);			
//				daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId(),2);
//				daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
//				daoObj.setProcOutValue(nProcIndex, "err",1,5); 
//				daoObj.setProcOutValue(nProcIndex, "resultset",2,6);
//				
//				daoObj.setProcInValue(nProcIndex, "reqType", "0",4); // Default set for reqType
//				
//				daoObj.executeProcedureByPosition(nProcIndex);
//			}
			
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setItemCategoryWS(ws);
				//System.out.println("itemCategoryName() size :"+ws.size());
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("ItemLocationTransDAO.storeName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Group Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void groupName(ItemLocationTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_store_group_list(?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			//System.out.println("item_category"+ vo.getStrItemCategoryNo());
			daoObj=new HisDAO("Item Location","ItemLocationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "item_category", vo.getStrItemCategoryNo(),3);
			
			/* Setting Default Value Start*/
			daoObj.setProcInValue(nProcIndex, "strPhyStockNo", "",4);
			daoObj.setProcInValue(nProcIndex, "strStoreId", "",5);
			/* Setting Default Value End */
			
			daoObj.setProcOutValue(nProcIndex, "err",1,6); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,7);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("WrsGroupName size :"+ws.size());
			if (strErr.equals("")) {
				vo.setGroupWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("ItemLocationTransDAO.groupName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of SubGroup Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void subGroupName(ItemLocationTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_store_subgroup_list(?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Item Location","ItemLocationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "GROUP_ID", vo.getStrGroupId(),2);
			daoObj.setProcOutValue(nProcIndex, "err",1,4); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,5);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setSubGroupWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("ItemLocationTransDAO.subGroupName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * for getting option value of Generic Item Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void genItemName(ItemLocationTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_item_list(?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Item Location","ItemLocationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),5);
			daoObj.setProcInValue(nProcIndex, "catCode", vo.getStrItemCategoryNo(),2);
			daoObj.setProcInValue(nProcIndex, "grpId", vo.getStrGroupId(),3);
			daoObj.setProcInValue(nProcIndex, "subgroup_id", vo.getStrSubGroupId(),4);
			daoObj.setProcOutValue(nProcIndex, "err",1,6); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,7);
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setGenItemWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("ItemLocationTransDAO.genItemName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Item Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void itemName(ItemLocationTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_itembrand_list(?,?,?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Item Location","ItemLocationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			/////
			//System.out.println("************* itemName **************");
			//System.out.println("modeval"+ "7");
			//System.out.println("hosp_code"+ vo.getStrHospitalCode());
			//System.out.println("catCode"+ vo.getStrItemCategoryNo());
			//System.out.println("grpId"+ vo.getStrGroupId());
			//System.out.println("subGrpId"+ vo.getStrSubGroupId());
			//System.out.println("item_id "+ vo.getStrGenItemId());
			
			//System.out.println("setFlag"+ "0"); //Default Value.
			//////
			daoObj.setProcInValue(nProcIndex, "modeval", "7",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),7);
			if(vo.getStrItemCategoryNo().equals("1"))
				daoObj.setProcInValue(nProcIndex, "catCode", "10",2);
			else
				daoObj.setProcInValue(nProcIndex, "catCode", "11",2);
			daoObj.setProcInValue(nProcIndex, "grpId", vo.getStrGroupId(),4);
			daoObj.setProcInValue(nProcIndex, "subGrpId", vo.getStrSubGroupId(),5);
			daoObj.setProcInValue(nProcIndex, "item_id ", vo.getStrGenItemId(),3);
			
			daoObj.setProcInValue(nProcIndex, "setFlag", "0",6); //Default Value.
			
			daoObj.setProcOutValue(nProcIndex, "err",1,8); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,9);
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("itemWS size :"+ws.size());
			if (strErr.equals("")) {
				vo.setItemWS(ws);	
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("ItemLocationTransDAO.itemName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Batch No on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void batchNo(ItemLocationTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_batchSerialno_list(?,?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Item Location","ItemLocationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			/*//System.out.println("Hosp Code==>"+vo.getStrHospitalCode());
			//System.out.println("Item Catg==>"+vo.getStrItemCategoryNo());
			//System.out.println("Item ID==>"+vo.getStrGenItemId());
			//System.out.println("Item Brand==>"+vo.getStrItemId());
			//System.out.println("StoreId==>"+vo.getStrStoreId());*/
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),5);
			daoObj.setProcInValue(nProcIndex, "cat_no", vo.getStrItemCategoryNo(),4);
			daoObj.setProcInValue(nProcIndex, "itemid", vo.getStrGenItemId(),2);
			daoObj.setProcInValue(nProcIndex, "itembrandid", vo.getStrItemId(),3);
			daoObj.setProcInValue(nProcIndex, "strId", vo.getStrStoreId(),6);
			daoObj.setProcOutValue(nProcIndex, "err",1,7); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,8);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			
			if (strErr.equals("")) {
				vo.setBatchNoWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("ItemLocationTransDAO.batchNo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Batch No on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void serialNo(ItemLocationTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_batchSerialno_list(?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Item Location","ItemLocationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "cat_no", vo.getStrItemCategoryNo());
			daoObj.setProcInValue(nProcIndex, "itemid", vo.getStrGenItemId());
			daoObj.setProcInValue(nProcIndex, "itembrandid", vo.getStrItemId());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setItemSlNoWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("ItemLocationTransDAO.serialNo() --> "
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
	public static void stockDetails(ItemLocationTransVO vo)
	{
		//String strProcName = "{call Pkg_Mms_View.Proc_stock_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?)}";  //13 variables
		String strProcName = "{call Pkg_Mms_View.Proc_stock_detail(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";  //14 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
					
			daoObj=new HisDAO("Item Location","ItemLocationTransDAO");
			
			////////////////////////////////////////////////////////////
			//System.out.println("modval"+ "1");
			//System.out.println("dwhType :::"+ vo.getStrStoreTypeId());
			//System.out.println("stock_status :::"+ vo.getStrStockStatusCode());
			//System.out.println("catCode :::"+ vo.getStrItemCategoryNo());
			//System.out.println("hosp_code :::"+ vo.getStrHospitalCode());
			//System.out.println("batch_no :::"+ vo.getStrBatchNo());
			//System.out.println("itemSlNo :::"+ vo.getStrItemSlNo());			
			//System.out.println("item_id :::"+ vo.getStrGenItemId());
			//System.out.println("itembrand_id :::"+ vo.getStrItemId());
			//System.out.println("store_id :::"+ vo.getStrStoreId());
			//System.out.println("dwhType :::"+ vo.getStrStoreTypeId());
			//////////////////////////////////////////////////////////////
			
			nProcIndex = daoObj.setProcedure(strProcName);
			//daoObj.setProcInValue(nProcIndex, "modval", "2");
			daoObj.setProcInValue(nProcIndex, "modval", "2",1);
			daoObj.setProcInValue(nProcIndex, "stock_status", vo.getStrStockStatusCode(),7);
			daoObj.setProcInValue(nProcIndex, "catCode",(vo.getStrItemCategoryNo().equals("1")?"10":"11"),3);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),8);
			daoObj.setProcInValue(nProcIndex, "batch_no", "",6);
			daoObj.setProcInValue(nProcIndex, "itemSlNo", "0",9);
			
			daoObj.setProcInValue(nProcIndex, "item_id", "0",4);
			daoObj.setProcInValue(nProcIndex, "itembrand_id", vo.getStrItemId(),5);
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId(),2);
			
			/* Setting Default Value Start*/
			daoObj.setProcInValue(nProcIndex, "reservedStockFlag", "0",10);
			daoObj.setProcInValue(nProcIndex, "blockedQtyFlag", "1",11);
			/* Setting Default Value End */
			daoObj.setProcInValue(nProcIndex, "dwhType", "0",12);
			
			
			daoObj.setProcOutValue(nProcIndex, "err",1,13); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,14);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setStockDetailsWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("ItemLocationTransDAO.stockDetails() --> "
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
	public static void empStockDetails(ItemLocationTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_empstockdtl_list(?,?,?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("MMS","ItemLocationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "reqtype", vo.getStrReqTypeId(),6);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),7);
			daoObj.setProcInValue(nProcIndex, "batchno", vo.getStrBatchNo(),4);
			daoObj.setProcInValue(nProcIndex, "itemslno", "0",5);
			daoObj.setProcInValue(nProcIndex, "itemid", vo.getStrGenItemId(),2);
			daoObj.setProcInValue(nProcIndex, "itembrandid", vo.getStrItemId(),3);
			daoObj.setProcOutValue(nProcIndex, "err",1,8); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,9);
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			
			if (strErr.equals("")) 
			{
				vo.setEmplyeeStockDetailsWS(ws);
			} 
			else 
			{
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("ItemLocationTransDAO.empStockDetails() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	
	/**
	 * for getting  Item Category Name on page from HSTT_STORE_CATEGORY_MST on basis of store id
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getItemCatDtls(ItemLocationTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","ItemLocationTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "store_id", (voObj.getStrStoreId()==null || voObj.getStrStoreId().equals(""))?"0":voObj.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "reqType", "",4);
			
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setItemCategoryWS(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("ItemLocationTransDAO.getItemCatDtls() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
}
