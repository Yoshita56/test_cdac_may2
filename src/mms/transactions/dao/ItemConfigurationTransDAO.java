package mms.transactions.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.transactions.vo.ItemConfigurationTransVO;

public class ItemConfigurationTransDAO {
	
	
	/**
	 * To get Drug Warehouse Combo  from the hstt_store_mst
	 *  
	 * @param voObj
	 */
	public static void getStoreList(ItemConfigurationTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj=new HisDAO("Item Location","ItemConfigurationTransDAO");

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
					.setStrMsgString("ItemConfigurationTransDAO.getStoreList() --> "
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
	 * for getting option value of Generic Item Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void genItemName(ItemConfigurationTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_item_list(?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Item Location","ItemConfigurationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "6",1);
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
			vo.setStrMsgString("ItemConfigurationTransDAO.genItemName() --> "
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
	public static void itemName_NEW(ItemConfigurationTransVO vo)
	{				
		
				String strProcName = "{call Pkg_Mms_View.proc_stock_detail(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";  //14 variables
				
				int nProcIndex = 0;
				String strErr = "";
				WebRowSet ws = null;
				HisDAO daoObj=null;
				
				try
				{
							
					daoObj=new HisDAO("Item Location","ItemConfigurationTransDAO");
								
					nProcIndex = daoObj.setProcedure(strProcName);			
					daoObj.setProcInValue(nProcIndex, "modval", 			"4",1);
					daoObj.setProcInValue(nProcIndex, "store_id", 			(vo.getStrStoreId()==null||vo.getStrStoreId().equals(""))?"0":vo.getStrStoreId(),2);
					daoObj.setProcInValue(nProcIndex, "catCode",			(vo.getStrItemCategoryNo().equals("1")?"10":"11"),3);
					daoObj.setProcInValue(nProcIndex, "item_id", 			"0",4);
					daoObj.setProcInValue(nProcIndex, "itembrand_id", 		(vo.getStrItemId()==null||vo.getStrItemId().equals(""))?"0":vo.getStrItemId(),5);
					daoObj.setProcInValue(nProcIndex, "batch_no", 			"",6);
					daoObj.setProcInValue(nProcIndex, "stock_status", 		vo.getStrStockStatusCode(),7);					
					daoObj.setProcInValue(nProcIndex, "hosp_code", 			vo.getStrHospitalCode(),8);					
					daoObj.setProcInValue(nProcIndex, "itemSlNo", 			"0",9);	
					daoObj.setProcInValue(nProcIndex, "reservedStockFlag",  "0",10);
					daoObj.setProcInValue(nProcIndex, "blockedQtyFlag", 	"1",11);			
					daoObj.setProcInValue(nProcIndex, "dwhType", 			"0",12);			
					daoObj.setProcOutValue(nProcIndex, "err",				1,13); 
					daoObj.setProcOutValue(nProcIndex, "resultset",			2,14);
					daoObj.executeProcedureByPosition(nProcIndex);
					
					strErr = daoObj.getString(nProcIndex, "err");
					if (strErr == null)
						strErr = "";
					ws = daoObj.getWebRowSet(nProcIndex, "resultset");
					if (strErr.equals("")) {
						vo.setItemWS(ws);
					} else {
						throw new Exception(strErr);
					}
				}
				catch(Exception e)
				{
					vo.setStrMsgString("ItemConfigurationTransDAO.stockDetails() --> "
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
	public static void stockDetails(ItemConfigurationTransVO vo)
	{
		
		String strProcName = "{call Pkg_Mms_View.proc_stock_detail(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";  //14 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
					
			daoObj=new HisDAO("Item Location","ItemConfigurationTransDAO");
						
			nProcIndex = daoObj.setProcedure(strProcName);			
			daoObj.setProcInValue(nProcIndex, "modval", 			"3",1);
			daoObj.setProcInValue(nProcIndex, "stock_status", 		vo.getStrStockStatusCode(),7);
			daoObj.setProcInValue(nProcIndex, "catCode",			(vo.getStrItemCategoryNo().equals("1")?"10":"11"),3);
			daoObj.setProcInValue(nProcIndex, "hosp_code", 			vo.getStrHospitalCode(),8);
			daoObj.setProcInValue(nProcIndex, "batch_no", 			"",6);
			daoObj.setProcInValue(nProcIndex, "itemSlNo", 			"0",9);			
			daoObj.setProcInValue(nProcIndex, "item_id", 			"0",4);
			daoObj.setProcInValue(nProcIndex, "itembrand_id", 		vo.getStrItemId(),5);
			daoObj.setProcInValue(nProcIndex, "store_id", 			vo.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "reservedStockFlag",  "0",10);
			daoObj.setProcInValue(nProcIndex, "blockedQtyFlag", 	"1",11);			
			daoObj.setProcInValue(nProcIndex, "dwhType", 			"0",12);			
			daoObj.setProcOutValue(nProcIndex, "err",				1,13); 
			daoObj.setProcOutValue(nProcIndex, "resultset",			2,14);
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
			vo.setStrMsgString("ItemConfigurationTransDAO.stockDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	/**
	 * for getting  Item Category Name on page from HSTT_STORE_CATEGORY_MST on basis of store id
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getItemCatDtls(ItemConfigurationTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","ItemConfigurationTransDAO");

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
					.setStrMsgString("ItemConfigurationTransDAO.getItemCatDtls() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	
	/**This Method is used to insert the Miscellaneous Consumptions in database for this activity call the insert()
	 * method which is define in table specific dao MiscellaneousConsumptionDAO java file.
	 * @param voObj
	 */
	public synchronized static void SAVE(ItemConfigurationTransVO vo) 
	{

		HisDAO daoObj = null;
		String strProcName = "";
		int nProcIndex = 0;
		String strErr = "";	
		String strStoreId ="0";
		String strItemId="0";
		String strBrandId = "0";
		String strBatchNo="0";
		try 
		{
			daoObj = new HisDAO("mms", "ItemConfigurationTransDAO");
			
			System.out.println("------------------ItemConfigurationTransDAO.SAVE--------------------");
			
						
			System.out.println("-------------------PKG_MMS_DML.update_currstock_configuration----------------");
			
			for(int i=0 , stopI = vo.getStrChkFlg().length;i<stopI;i++)
			{
				if(!vo.getStrChkFlg()[i].equals("0"))
				{	
				  strProcName = "{call PKG_MMS_DML.update_currstock_configuration(?,?,?,?,?,?,?,?,?,?,?)}"; // 11 variables
				  
				 
				     strStoreId   = vo.getStrChkFlg()[i].split("\\^")[0];
					 strItemId    = vo.getStrChkFlg()[i].split("\\^")[1];
					 strBrandId   = vo.getStrChkFlg()[i].split("\\^")[2];
					 strBatchNo   = vo.getStrChkFlg()[i].split("\\^")[3];
					 /*
					 System.out.println("strStoreId----"+strStoreId);
					 System.out.println("strItemId----"+strItemId);
					 System.out.println("strBrandId----"+strBrandId);
					 System.out.println("strBatchNo----"+strBatchNo);
					 */
				  nProcIndex = daoObj.setProcedure(strProcName);
				  daoObj.setProcInValue(nProcIndex,  "modval", 			"1",1);       
				  daoObj.setProcInValue(nProcIndex,  "hosp_code", 		vo.getStrHospitalCode(),2); 
				  daoObj.setProcInValue(nProcIndex,  "item_cat_no", 	strBrandId.substring(0, 2),3);
				  daoObj.setProcInValue(nProcIndex,  "stockstatuscode",  "10", 4);
				  daoObj.setProcInValue(nProcIndex,  "strid", 			strStoreId,5);  
				  daoObj.setProcInValue(nProcIndex,  "batchno", 		strBatchNo,6);       
				  daoObj.setProcInValue(nProcIndex,  "itembrandid", 	strBrandId,7);
				  daoObj.setProcInValue(nProcIndex,  "itemid", 			strItemId,8);  
				  daoObj.setProcInValue(nProcIndex,  "seatId", 		    vo.getStrSeatId(),9);//9
				  daoObj.setProcInValue(nProcIndex,  "old_itemserialno","0",10);//10
				  daoObj.setProcOutValue(nProcIndex, "err", 			1,11);//11				
				  daoObj.execute(nProcIndex, 1);
				} 
			
			    
			} 
			    
				daoObj.fire();
				
				System.out.println("------------------ItemConfigurationTransDAO.insertMiscConsumpRecord----- END ---------------");

			//}

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			
			e.printStackTrace();
			
			vo.setStrMsgString("ItemConfigurationTransDAO.insertMiscConsumpRecord --> "
							+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
				

			}
		}

	}
}
