package mms.masters.dao;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.dao.StoreItemDAO;
import mms.masters.vo.StoreItemMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreItemMstDAO.
 * 
 * @author Anshul Jindal
 */
/**
 * Developer : Tanvi Sappal Version : 1.0 Modify Date : 13/May/2009
 * Modify By Amit Kr 29-Dec-2010
 */
public class StoreItemMstDAO {

	/**
	 * for getting option value of item name combo and level unit combo on add
	 * page.
	 * 
	 * @param vo the vo
	 */
	public static void getUnitCombo(StoreItemMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet wb = null;

		// String strTableName = "";
		try {
			dao = new HisDAO("mms", "StoreItemMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1, "select.LevelUnit.2");

			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrInventoryUnitId());
		 
			wb = dao.executeQry(nqryIndex);
			
			if(wb != null && wb.next()){
				
				vo.setStrLevelUnitId(wb.getString(1));
				vo.setStrLevelUnitName(wb.getString(2));
				
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> StoreItemMstDAO.getUnitCombo()-->"
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
	 * for getting option value of item name combo and level unit combo on add
	 * page.
	 * 
	 * @param vo the vo
	 */
	public static void initAddQuery(StoreItemMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet wb = null;

		// String strTableName = "";
		try {
			dao = new HisDAO("mms", "StoreItemMstDAO");

			strquery = mms.qryHandler_mms.getQuery(1, "select.StoreItem.5");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
			// dao.setQryValue(nqryIndex, 2, vo.getStrStoreTypeId());
			dao.setQryValue(nqryIndex, 2, vo.getStrCategoryNo());

			wb = dao.executeQry(nqryIndex);

			vo.setStrGroupComboWs(wb);

			/*
			 * strquery = mms.qryHandler_mms.getQuery(1, "select.TableName.0")
			 * .replace("?", vo.getStrCategoryNo()); strquery =
			 * strquery.concat(" AND " + mms.qryHandler_mms.getQuery(1,
			 * "select.HospCode.cond.0") .replace("?",
			 * vo.getStrHospitalCode())); nqryIndex = dao.setQuery(strquery); wb =
			 * dao.executeQry(nqryIndex); while (wb.next()) { strTableName =
			 * wb.getString(1); }
			 * 
			 * strquery = mms.qryHandler_mms.getQuery(1,
			 * "select.storeItemName.0") .replace("?", strTableName); strquery =
			 * strquery.concat(" AND " + mms.qryHandler_mms.getQuery(1,
			 * "select.HospCode.cond.0") .replace("?",
			 * vo.getStrHospitalCode())); nqryIndex = dao.setQuery(strquery); wb =
			 * dao.executeQry(nqryIndex); vo.setStrItemNameComboWs(wb);
			 */

			/*
			 * strquery = mms.qryHandler_mms.getQuery(1, "select.BrandName.0")
			 * .replace("?", vo.getStrHospitalCode()); strquery =
			 * strquery.concat(" AND " + mms.qryHandler_mms.getQuery(1,
			 * "select.BrandName.cond.0").replace("?", vo.getStrCategoryNo()));
			 * strquery = strquery.concat(" AND " +
			 * mms.qryHandler_mms.getQuery(1,
			 * "select.BrandName.cond.1").replace("?",
			 * vo.getStrHospitalCode())); nqryIndex = dao.setQuery(strquery); wb =
			 * dao.executeQry(nqryIndex); vo.setStrItemBrandComboWs(wb);
			 */

		/*	strquery = mms.qryHandler_mms.getQuery(1, "select.LevelUnit.0")
					.replace("?", vo.getStrHospitalCode());
			strquery = strquery.concat(" AND "
					+ mms.qryHandler_mms.getQuery(1, "select.LevelUnit.cond.0")
							.replace("?", vo.getStrModuleId()));
			nqryIndex = dao.setQuery(strquery);
			wb = dao.executeQry(nqryIndex);
			vo.setStrLevelUnitComboWs(wb);*/

		} catch (Exception e) {
			vo.setStrMsgString("--> StoreItemMstDAO.initAddQuery()-->"
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
	 * To get option value of All Item Of Selected Group Value.
	 * 
	 * @param vo the vo
	 */
	public static void getGrpAllItemNameCombo(StoreItemMstVO vo) 
	{
		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";
		try 
		{
			dao = new HisDAO("mms", "StoreItemMstDAO");
			
			if(vo.getStrCategoryNo().equals("10"))
            {	
				strquery = mms.qryHandler_mms.getQuery(1, "select.storeName.201");
            }
            else
            {
            	strquery = mms.qryHandler_mms.getQuery(1, "select.storeName.202");
            }	
			nqryIndex = dao.setQuery(strquery);
								
			dao.setQryValue(nqryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nqryIndex, 2, vo.getStrGroupId());
			dao.setQryValue(nqryIndex, 3, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 4, vo.getStrStoreId());
												
			wb = dao.executeQry(nqryIndex);
			vo.setStrItemBrandComboWs(wb);
			

		} 
		catch (Exception e) 
		{
			vo.setStrMsgString(" --> StoreItemMstDAO.getGrpAllItemNameCombo()-->"+ e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null)
				dao.free();
			dao = null;
		}
	}

	
	/**
	 * to insert the data.
	 * Modify By Amit Kr Date 29-Dec-2010
	 * @param vo the vo
	 */
	public static void InsertQueryLogic(StoreItemMstVO vo) 
	{
		/* In This Logic three Logic placed
		 * a) First  ::: All the item of selected Group enter into the store without selecting Sub-Group , Generic Name and Brand Name
		 * b) Second ::: First Select the Group and then Select the Brand Name and Enter into the Store without selecting Sub-Group Name and Generic Name 
		 * c) Third  ::: First Select Group-->Sub-Group-->Generic Name-->Brand Name store data into table. 
		 */
		// Logic First
		if(!vo.getStrGroupId().equals("0") && vo.getStrSubGroupId().equals("0") && vo.getStrItemId().equals("0") && vo.getStrItemBrandId().equals("0"))
		{
			HisDAO             dao = null;
			int          nqryIndex = 0;
			WebRowSet          web = null;
			String        strquery = "";
			String[]        itemId = null;
			String[]   itemBrandId = null;
			String      compItemId = null;
			String compItemBrandId = null;
			String[]    rateUnitId = null;
								
			try
			{
		                       dao = new HisDAO("mms", "StoreItemMstDAO");
					
		            if(vo.getStrCategoryNo().equals("10"))
		            {	
						  strquery = mms.qryHandler_mms.getQuery(1, "select.storeName.101");
		            }
		            else
		            {
		            	  strquery = mms.qryHandler_mms.getQuery(1, "select.storeName.102");
		            }	
		            
				/*
				 * System.out.println("strquery-->"+strquery);
				 * System.out.println("getStrStoreId-->"+vo.getStrStoreId());
				 * System.out.println("getStrItemBrandId-->"+vo.getStrItemBrandId());
				 * System.out.println("getStrGroupId-->"+vo.getStrGroupId());
				 * System.out.println("Hosp Code-->"+Config.SUPER_USER_HOSPITAL_CODE);
				 */
                    
					nqryIndex = dao.setQuery(strquery);
										
					dao.setQryValue(nqryIndex, 1, MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
					dao.setQryValue(nqryIndex, 2, vo.getStrGroupId());
					dao.setQryValue(nqryIndex, 3, vo.getStrStoreId());
					
					
					web = dao.executeQry(nqryIndex);
					
					
					if (web != null) 
					{			
						if(web.size() != 0)
						{
							     itemId = new  String[web.size()];
							itemBrandId = new  String[web.size()];
							 rateUnitId = new  String[web.size()]; 
							for(int i=0;i<web.size();i++)
							{
								web.next();
								
								if(!web.getString(1).equals(compItemId))
								{
								          itemId[i] = web.getString(1);
								}
								if(!web.getString(1).equals(compItemBrandId))
								{
									 itemBrandId[i] = web.getString(2);
									  rateUnitId[i] = web.getString(3);
									 
								}
								         compItemId = itemId[i];
								    compItemBrandId = itemBrandId[i];
							}
						  insertAllQuery(vo,itemId,itemBrandId,rateUnitId);	
						}
						else
						{
							vo.setStrMsgType("2");
							vo.setStrMsgString("No Item Avalaible in Selected Group!!!!!");
							
						}	
						
					}
					
			}
			catch (Exception e) 
			{
				//e.printStackTrace();
				vo.setStrMsgString("--> StoreItemMstDAO.InsertQueryLogic()-->"
						+ e.getMessage());
				vo.setStrMsgType("1");
			} finally {
				if (dao != null) {
					dao.free();
					dao = null;
				}
			}
					
			
		}
		else
		{
			 // Logic Second 
			if(!vo.getStrGroupId().equals("0") && !vo.getStrItemBrandId().equals("0"))
			{
					 HisDAO      dao = null;
					 int   nqryIndex = 0;
					 WebRowSet   web = null;
					 String strquery = "";
					 String   itemId = null;
													
				try
				{
			                     dao = new HisDAO("mms", "StoreItemMstDAO");
			                    
			                     
			                     
			            if(vo.getStrCategoryNo().equals("10"))
			            {	
							strquery = mms.qryHandler_mms.getQuery(1, "select.storeName.301");
			            }
			            else
			            {
			            	strquery = mms.qryHandler_mms.getQuery(1, "select.storeName.302");
			            }	
						   nqryIndex = dao.setQuery(strquery);
											
						dao.setQryValue(nqryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
						dao.setQryValue(nqryIndex, 2, vo.getStrItemBrandId());
						dao.setQryValue(nqryIndex, 3, vo.getStrGroupId());
												
						web = dao.executeQry(nqryIndex);
						
						
						if (web != null) 
						{			
							if(web.size() != 0)
							{
								     web.next();
								     itemId = web.getString(1);
							 
							}
							else
							{
								vo.setStrMsgType("2");
								vo.setStrMsgString("No Generic Item Avalaible for Selected Brand!!!!!");
								
							}	
							
						}
						vo.setStrItemId(itemId);
						insertQuery(vo);
						
				}
				catch (Exception e) 
				{
					//e.printStackTrace();
					vo.setStrMsgString("--> StoreItemMstDAO.InsertQueryLogic()-->"
							+ e.getMessage());
					vo.setStrMsgType("1");
				} finally {
					if (dao != null) {
						dao.free();
						dao = null;
					}
				}
						
				
			}
			else
			{		
				// Logic Third
			   insertQuery(vo);
			}  
		}	
		
	}
	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public static void insertAllQuery(StoreItemMstVO vo,String[] itemId ,String[] itemBrandId ,String[] rateUnitId) 
	{
		HisDAO                dao = null;
		StoreItemDAO storeItemDAO = null;
		try 
			{
				dao = new HisDAO("mms", "StoreItemMstDAO");
				storeItemDAO = new StoreItemDAO();               
				
				for (int i = 0; i <itemId.length; i++) 
				{

					    
//					    //System.out.println("Eff Frm-->"+vo.getStrEffectiveFrom());
//					    //System.out.println("Hosp Code-->"+vo.getStrHospitalCode());
//					    //System.out.println("Is valid-->"+vo.getStrIsValid());
//					    //System.out.println("Remarks-->"+vo.getStrRemarks());
//					    //System.out.println("Seat id-->"+vo.getStrSeatId());
//					    //System.out.println("Item Id -->"+itemId[i]);
//					    //System.out.println("Genric Item Id -->"+itemBrandId[i]);
//					    //System.out.println("Fore Cast-->"+vo.getStrForeCast());
//					    //System.out.println("Reserv Qty-->"+vo.getStrReservedQty());
//					    //System.out.println("Is return -->"+vo.getStrIsReturnable());					    
//					    //System.out.println("Issuable Flg -->"+vo.getStrIssueableFlag());
//					    //System.out.println("Level unit id-->"+vo.getStrLevelUnitId());
//					    //System.out.println("VED-->"+vo.getStrVEDCategory());
//					    //System.out.println("Store Id -->"+vo.getStrStoreId());		
//					    //System.out.println("Re-Order -->"+vo.getStrReorderQty());
//					    //System.out.println("Grp Id-->"+vo.getStrGroupId());
//					    //System.out.println("Sub Grp Id-->"+vo.getStrSubGroupId());
//					    //System.out.println("Catg No -->"+vo.getStrCategoryNo());		
					 
					 
					    storeItemDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
						storeItemDAO.setStrHospitalCode(vo.getStrHospitalCode());
						storeItemDAO.setStrIsValid(vo.getStrIsValid());
						storeItemDAO.setStrRemarks(vo.getStrRemarks());
						storeItemDAO.setStrSeatId(vo.getStrSeatId());

						storeItemDAO.setStrItemBrandId(itemId[i]);            // Show As Item Name
						storeItemDAO.setStrItemId(itemBrandId[i]);            // Show As Generic Item Name 
						storeItemDAO.setStrForeCast(vo.getStrForeCast());
						storeItemDAO.setStrReservedQty(vo.getStrReservedQty());
						storeItemDAO.setStrIsReturnable(vo.getStrIsReturnable());
						storeItemDAO.setStrIssueableFlag(vo.getStrIssueableFlag());
						storeItemDAO.setStrItemShortName("----");
						storeItemDAO.setStrLevelUnitId(rateUnitId[i]);
						// storeItemDAO.setStrMaxQty(vo.getStrMaxQty());
						storeItemDAO.setStrVEDCategory(vo.getStrVEDCategory());
						storeItemDAO.setStrStoreId(vo.getStrStoreId());
						// storeItemDAO.setStrMinQty(vo.getStrMinQty());
						storeItemDAO.setStrReorderQty(vo.getStrReorderQty());

						storeItemDAO.setStrGroupId(vo.getStrGroupId());       // Show As Group Id
						storeItemDAO.setStrSubGroupId(vo.getStrSubGroupId()); // Show As Sub-Group Id

						storeItemDAO.setStrItemCategoryNo(vo.getStrCategoryNo());
						storeItemDAO.setStrToleranceLimit(vo.getStrToleranceLimit());
						storeItemDAO.setStrMaxQty(vo.getStrMaxQty());
						storeItemDAO.setStrMaxIndentQty(vo.getStrMaxIndentQty());  // Max Indent Qty
						
						storeItemDAO.insert(dao);

						synchronized (dao) 
						{
							dao.fire();

						}
				}
			} 
			catch (Exception e) 
			{
				
				vo.setStrMsgString("--> StoreItemMstDAO.insertAllQuery()-->"
						+ e.getMessage());
				vo.setStrMsgType("1");
			} finally {
				if (dao != null) {
					dao.free();
					dao = null;
				}
				storeItemDAO = null;
			}
	}

	
	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public static void insertQuery(StoreItemMstVO vo) {

		HisDAO dao = null;
		StoreItemDAO storeItemDAO = null;

		try 
		{
			dao = new HisDAO("MMS", "StoreItemMstDAO");
			storeItemDAO = new StoreItemDAO();
			
			System.out.println("Item Id::::::::::"+vo.getStrItemId());	
			System.out.println("Item Brand Id::::"+vo.getStrItemBrandId());	
			System.out.println("Hosp Code::::::::"+vo.getStrHospitalCode());	
			System.out.println("Store Id:::::::::"+vo.getStrStoreId());	
            
			storeItemDAO.setStrStoreId(vo.getStrStoreId());
			storeItemDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			storeItemDAO.setStrHospitalCode(vo.getStrHospitalCode());
			storeItemDAO.setStrIsValid(vo.getStrIsValid());
			storeItemDAO.setStrRemarks(vo.getStrRemarks());
			storeItemDAO.setStrSeatId(vo.getStrSeatId());
            ////System.out.println("Item Brand Id::::"+vo.getStrItemBrandId());			
			storeItemDAO.setStrItemBrandId(vo.getStrItemBrandId());  // Show As Item Name
			storeItemDAO.setStrItemId(vo.getStrItemId());            // Show As Generic Item Name 
			storeItemDAO.setStrForeCast(vo.getStrForeCast());
			storeItemDAO.setStrReservedQty(vo.getStrReservedQty());
			storeItemDAO.setStrIsReturnable(vo.getStrIsReturnable());
			storeItemDAO.setStrIssueableFlag(vo.getStrIssueableFlag());
			storeItemDAO.setStrItemShortName("----");
			storeItemDAO.setStrLevelUnitId(vo.getStrLevelUnitId());
			// storeItemDAO.setStrMaxQty(vo.getStrMaxQty());
			storeItemDAO.setStrVEDCategory(vo.getStrVEDCategory());
			storeItemDAO.setStrStoreId(vo.getStrStoreId());
			// storeItemDAO.setStrMinQty(vo.getStrMinQty());
			storeItemDAO.setStrReorderQty(vo.getStrReorderQty());

			storeItemDAO.setStrGroupId(vo.getStrGroupId());       // Show As Group Id
			storeItemDAO.setStrSubGroupId(vo.getStrSubGroupId()); // Show As Sub-Group Id

			storeItemDAO.setStrItemCategoryNo(vo.getStrCategoryNo());
			storeItemDAO.setStrToleranceLimit(vo.getStrToleranceLimit());
			storeItemDAO.setStrMaxQty(vo.getStrMaxQty());
			storeItemDAO.setStrMaxIndentQty(vo.getStrMaxIndentQty());  // Max Indent Qty
			storeItemDAO.insert(dao);

			synchronized (dao)
			{
				dao.fire();

			}

		} catch (Exception e) {
			vo.setStrMsgString("--> StoreItemMstDAO.insertQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			storeItemDAO = null;
		}

	}

	/**
	 * to check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */
	public static void chkDuplicate(StoreItemMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";

		try {
			dao = new HisDAO("mms", "StoreItemMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.StoreItem.2");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrItemBrandId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrStoreId());

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
			vo.setStrMsgString("--> StoreItemMstDAO.chkDuplicate()-->"
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
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 */
	public static void modifyQuery(StoreItemMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";
		WebRowSet web = null;

		try 
		{
			dao = new HisDAO("mms", "StoreItemMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.StoreItem.3");

//			//System.out.println("Item Serial No:::"+vo.getStrItemSlNo());
//			//System.out.println("Item Id:::"+vo.getStrItemId());
//			//System.out.println("Store Id::"+ vo.getStrStoreId());
//			//System.out.println("Item Brand Id"+vo.getStrItemBrandId());
//			//System.out.println("Grp Id:::"+vo.getStrGroupId());
//			//System.out.println("Sub-Grp Id:::"+vo.getStrSubGroupId());
			
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrItemSlNo());
			
			dao.setQryValue(nqryIndex, 3, vo.getStrItemId());
			
			dao.setQryValue(nqryIndex, 4, vo.getStrStoreId());
			
			dao.setQryValue(nqryIndex, 5, vo.getStrItemBrandId());
			

			web = dao.executeQry(nqryIndex);

			while (web.next()) {
				vo.setStrItemBrandId(web.getString(1));
				vo.setStrStoreId(web.getString(2));
				vo.setStrItemId(web.getString(3));
				vo.setStrItemShortName(web.getString(4));
				vo.setStrVEDCategory(web.getString(5));
				vo.setStrForeCast(web.getString(6));
				vo.setStrReservedQty(web.getString(7));
				// vo.setStrMaxQty(web.getString(7));
				vo.setStrReorderQty(web.getString(8));
				// vo.setStrMinQty(web.getString(9));
				vo.setStrLevelUnitId(web.getString(9));
				vo.setStrRemarks(web.getString(10));
				vo.setStrIssueableFlag(web.getString(11));
				vo.setStrIsReturnable(web.getString(12));
				vo.setStrIsValid(web.getString(13));
				vo.setStrEffectiveFrom(web.getString(14));
				vo.setStrGroupId(web.getString(15));
				vo.setStrSubGroupId(web.getString(16));
				vo.setStrToleranceLimit(web.getString(17));
				vo.setStrMaxQty(web.getString(18));
				vo.setStrLevelUnitName(web.getString(19));
				vo.setStrMaxIndentQty(web.getString(20));

			}

			if (vo.getStrCategoryNo().equals("10")) {
				strquery = mms.qryHandler_mms
						.getQuery(1, "select.BrandName2.2");
			} else {
				strquery = mms.qryHandler_mms
						.getQuery(1, "select.BrandName1.1");
			}
			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nqryIndex, 2, vo.getStrItemBrandId());

			web = dao.executeQry(nqryIndex);

			while (web.next()) {
				vo.setStrItemBrandName(web.getString(1));
			}

			strquery = mms.qryHandler_mms.getQuery(1, "select.ItemName.1.0");

			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrItemId());

			web = dao.executeQry(nqryIndex);

			while (web.next()) {
				vo.setStrItemName(web.getString(1));
			}

			strquery = mms.qryHandler_mms.getQuery(1, "select.StoreItem.7");

			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrGroupId());

			web = dao.executeQry(nqryIndex);

			while (web.next()) {
				vo.setStrGroupName(web.getString(1));
			}

			strquery = mms.qryHandler_mms.getQuery(1, "select.StoreItem.8");

			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrSubGroupId());

			web = dao.executeQry(nqryIndex);

			while (web.next()) 
			{				
				   vo.setStrSubGroupName(web.getString(1));				
			}

			if (vo.getStrCategoryNo().equals("10")) {
				strquery = mms.qryHandler_mms.getQuery(1,
						"select.StoreItem.inventoryUnit.0");
			} else {
				strquery = mms.qryHandler_mms.getQuery(1,
						"select.StoreItem.inventoryUnit.1");
			}

			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrItemId());
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());

			web = dao.executeQry(nqryIndex);

			while (web.next()) {
				vo.setStrInventoryUnitId(web.getString(1));
			}

			//getUnitCombo(vo);
		} catch (Exception e) {
			vo.setStrMsgString("--> StoreItemMstDAO.modifyQuery()-->"
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
	 * to check duplicate before update.
	 * 
	 * @param vo the vo
	 */
	public static void initialUpdateQuery(StoreItemMstVO vo) {

		HisDAO hisdao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;

		try {

			hisdao = new HisDAO("mms", "StoreItemMstDAO");
			String strquery = mms.qryHandler_mms.getQuery(1,
					"select.StoreItem.4");

			nqryIndex = hisdao.setQuery(strquery);

			hisdao.setQryValue(nqryIndex, 1, vo.getStrItemShortName());
			hisdao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			hisdao.setQryValue(nqryIndex, 3, vo.getStrItemSlNo());
			hisdao.setQryValue(nqryIndex, 4, vo.getStrStoreId());

			wb = hisdao.executeQry(nqryIndex);

			while (wb.next()) {
				ncount = Integer.parseInt(wb.getString(1));

			}
			if (ncount < 1) {
				vo.setBExistStatus(true);
			} else {
				vo.setBExistStatus(false);
			}

		} catch (Exception e) {
			vo.setStrMsgString("--> StoreItemMstDAO.initialUpdateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (hisdao != null) {
				hisdao.free();
				hisdao = null;
			}
		}

	}

	/**
	 * to update the record.
	 * 
	 * @param vo the vo
	 */
	public static void updateQuery(StoreItemMstVO vo) {

		HisDAO dao = null;
		StoreItemDAO storeItemDAO = null;

		try {

			dao = new HisDAO("mms", "StoreItemMstDAO");
			storeItemDAO = new StoreItemDAO();
           
//			//System.out.println("Hosp Code:::"+vo.getStrHospitalCode());
//			//System.out.println("Item Brand ID::::"+vo.getStrItemBrandId());
//			//System.out.println("Item Id:::"+vo.getStrItemId());
//			//System.out.println("Store Id:::"+vo.getStrStoreId());
//			//System.out.println("Item Sl No::::"+vo.getStrItemSlNo());
//			//System.out.println("Grp Id:::"+vo.getStrGroupId());
//			//System.out.println("Sub Grp Id:::"+vo.getStrSubGroupId());
			
			storeItemDAO.setStrHospitalCode(vo.getStrHospitalCode());
			storeItemDAO.setStrItemBrandId(vo.getStrItemBrandId());
			storeItemDAO.setStrItemId(vo.getStrItemId());
			storeItemDAO.setStrStoreId(vo.getStrStoreId());
			storeItemDAO.setStrItemSlNo(vo.getStrItemSlNo());
			storeItemDAO.setStrGroupId(vo.getStrGroupId());
			storeItemDAO.setStrSubGroupId(vo.getStrSubGroupId());

			storeItemDAO.update(dao);
            
			storeItemDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			storeItemDAO.setStrHospitalCode(vo.getStrHospitalCode());
			storeItemDAO.setStrIsValid(vo.getStrIsValid());
			storeItemDAO.setStrRemarks(vo.getStrRemarks());
			storeItemDAO.setStrSeatId(vo.getStrSeatId());
			storeItemDAO.setStrItemBrandId(vo.getStrItemBrandId());
			storeItemDAO.setStrItemId(vo.getStrItemId());
			storeItemDAO.setStrForeCast(vo.getStrForeCast());
			storeItemDAO.setStrReservedQty(vo.getStrReservedQty());
			storeItemDAO.setStrIsReturnable(vo.getStrIsReturnable());
			storeItemDAO.setStrIssueableFlag(vo.getStrIssueableFlag());
			if(vo.getStrItemShortName()=="" || vo.getStrItemShortName().equals(""))
			{	
			    storeItemDAO.setStrItemShortName("NA");
			}
			else
			{
				storeItemDAO.setStrItemShortName(vo.getStrItemShortName());	
			}	
			storeItemDAO.setStrLevelUnitId(vo.getStrLevelUnitId());
			// storeItemDAO.setStrMaxQty(vo.getStrMaxQty());
			storeItemDAO.setStrVEDCategory(vo.getStrVEDCategory());
			storeItemDAO.setStrStoreId(vo.getStrStoreId());
			// storeItemDAO.setStrMinQty(vo.getStrMinQty());
			storeItemDAO.setStrReorderQty(vo.getStrReorderQty());
			storeItemDAO.setStrItemSlNo(vo.getStrItemSlNo());
			storeItemDAO.setStrGroupId(vo.getStrGroupId());
			storeItemDAO.setStrSubGroupId(vo.getStrSubGroupId());
			// // //System.out.println("Groupid:::"+vo.getStrGroupId());
			storeItemDAO.setStrItemCategoryNo(vo.getStrCategoryNo());
			storeItemDAO.setStrToleranceLimit(vo.getStrToleranceLimit());
			storeItemDAO.setStrMaxQty(vo.getStrMaxQty());
			storeItemDAO.setStrMaxIndentQty(vo.getStrMaxIndentQty());
			
			storeItemDAO.insert(dao);

			synchronized (dao) {
				dao.fire();
			}
			vo.setStrMsgType("0");
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> StoreItemMstDAO.updateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			storeItemDAO = null;
		}

	}

	/**
	 * To get option value of Brand combo.
	 * 
	 * @param vo the vo
	 */
	public static void getBrandNameQuery(StoreItemMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";
		try {

			dao = new HisDAO("mms", "StoreItemMstDAO");

			if (vo.getStrCategoryNo().equals("10")) 
			{
				strquery = mms.qryHandler_mms.getQuery(1, "select.BrandName.90");

				nqryIndex = dao.setQuery(strquery);

			} 
			else
			{

				strquery = mms.qryHandler_mms.getQuery(1, "select.BrandName.0");

				nqryIndex = dao.setQuery(strquery);
			}

			dao.setQryValue(nqryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nqryIndex, 2, vo.getStrCategoryNo());
			dao.setQryValue(nqryIndex, 3, vo.getStrItemId());
			dao.setQryValue(nqryIndex, 4, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nqryIndex, 5, vo.getStrItemId());
			dao.setQryValue(nqryIndex, 6, vo.getStrStoreId());

			wb = dao.executeQry(nqryIndex);
			vo.setStrItemBrandComboWs(wb);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString(" --> StoreItemMstDAO.getBrandNameQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}
	}

	/**
	 * To get option value of SubGroup combo.
	 * 
	 * @param vo the vo
	 */
	public static void getSubGroupComboQuery(StoreItemMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";
		try {
			dao = new HisDAO("mms", "StoreItemMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.StoreItem.6");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, Config.SUPER_USER_HOSPITAL_CODE);
			dao.setQryValue(nqryIndex, 2, vo.getStrGroupId());

			wb = dao.executeQry(nqryIndex);
			vo.setStrSubGroupComboWs(wb);

		} catch (Exception e) {
			vo
					.setStrMsgString(" --> StoreItemMstDAO.getSubGroupComboQuery()-->"
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}
	}
	
	

	/**
	 * To get option value of Item Name combo associate with Group Id.
	 * 
	 * @param vo the vo
	 */
	public static void getItemGrpComboQuery(StoreItemMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";
		String strTableName = "";

		try {

			dao = new HisDAO("mms", "StoreItemMstDAO");

			/*
			 * if (vo.getStrCategoryNo().equals("1")) { strquery =
			 * mms.qryHandler_mms .getQuery(1, "select.StoreItem.24");
			 *  } else { strquery = mms.qryHandler_mms .getQuery(1,
			 * "select.StoreItem.23"); }
			 * 
			 * nqryIndex = dao.setQuery(strquery);
			 * //System.out.println("vo.getStrGroupId()-->" + vo.getStrGroupId());
			 * //System.out.println("vo.getStrHospitalCode()-->" +
			 * vo.getStrHospitalCode());
			 * //System.out.println("vo.getStrCategoryNo()-->" +
			 * vo.getStrCategoryNo());
			 * 
			 * dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			 * dao.setQryValue(nqryIndex, 2, vo.getStrGroupId());
			 * dao.setQryValue(nqryIndex, 3, vo.getStrCategoryNo());
			 */

			/*
			 * //System.out.println("getItemNameComboQuery vo.getStrGroupId()-->" +
			 * vo.getStrGroupId());
			 */

			strquery = mms.qryHandler_mms.getQuery(1, "select.TableName.0")
					.replace("?", vo.getStrCategoryNo());
			strquery = strquery.concat(" AND "
					+ mms.qryHandler_mms.getQuery(1, "select.HospCode.cond.0")
							.replace("?", Config.SUPER_USER_HOSPITAL_CODE));
			nqryIndex = dao.setQuery(strquery);
			wb = dao.executeQry(nqryIndex);
			while (wb.next()) {
				strTableName = wb.getString(1);
			}

			strquery = mms.qryHandler_mms.getQuery(1, "select.storeItemName.0")
					.replace("?", strTableName);
			strquery = strquery.concat(" AND "
					+ mms.qryHandler_mms.getQuery(1,
							"select.storeItemName.cond.1"));

			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			dao.setQryValue(nqryIndex, 2, vo.getStrGroupId());
			dao.setQryValue(nqryIndex, 3, vo.getStrCategoryNo());

			// //System.out.println("strquery-"+strquery);
			wb = dao.executeQry(nqryIndex);
			vo.setStrItemNameComboWs(wb);
			// // //System.out.println("size-" +
			// vo.getStrItemNameComboWs().size());

		} catch (Exception e) {
			vo.setStrMsgString("ItemSetsMstDAO.getAddQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * To get values of Item name Combo according to Group Id & Sub Group Id.
	 * 
	 * @param vo the vo
	 */
	public static void getItemNameComboQuery(StoreItemMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";
		String strTableName = "";
		try {
			dao = new HisDAO("mms", "StoreItemMstDAO");
			
			strquery = mms.qryHandler_mms.getQuery(1, "select.TableName.0").replace("?", vo.getStrCategoryNo());
			strquery = strquery.concat(" AND " + mms.qryHandler_mms.getQuery(1, "select.HospCode.cond.0").replace("?", Config.SUPER_USER_HOSPITAL_CODE));
			nqryIndex = dao.setQuery(strquery);
			
			wb = dao.executeQry(nqryIndex);
			
			while (wb.next()) 
			{
				strTableName = wb.getString(1);
			}

			if (vo.getStrSubGroupId().equals("0")) 
			{
				strquery = mms.qryHandler_mms.getQuery(1,"select.storeItemName.0").replace("?", strTableName);
				strquery = strquery.concat(" AND " + mms.qryHandler_mms.getQuery(1,"select.storeItemName.cond.1"));

				nqryIndex = dao.setQuery(strquery);

				dao.setQryValue(nqryIndex, 1, MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
				dao.setQryValue(nqryIndex, 2, vo.getStrGroupId());
				dao.setQryValue(nqryIndex, 3, vo.getStrCategoryNo());
			}
			else 
			{
				strquery = mms.qryHandler_mms.getQuery(1,"select.storeItemName.0").replace("?", strTableName);
				strquery = strquery.concat(" AND " + mms.qryHandler_mms.getQuery(1,"select.storeItemName.cond.0"));
				nqryIndex = dao.setQuery(strquery);
				
				dao.setQryValue(nqryIndex, 1, MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
				dao.setQryValue(nqryIndex, 2, vo.getStrGroupId());
				dao.setQryValue(nqryIndex, 3, vo.getStrSubGroupId());
				dao.setQryValue(nqryIndex, 4, vo.getStrCategoryNo());
			}

			wb = dao.executeQry(nqryIndex);
			vo.setStrItemNameComboWs(wb);

		} 
		catch (Exception e) 
		{
			vo.setStrMsgString(" --> StoreItemMstDAO.getItemNameComboQuery()-->"+ e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null)
				dao.free();
			dao = null;
		}
	}

	/**
	 * To get option value of Brand combo.
	 * 
	 * @param vo the vo
	 */
	public static void getBatchUpdateStoreCombo(StoreItemMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";
		try {
			dao = new HisDAO("mms", "StoreItemMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.storeName.1");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrStoreTypeId());
			dao.setQryValue(nqryIndex, 3, vo.getStrStoreId());

			wb = dao.executeQry(nqryIndex);
			vo.setStrStoreComboWs(wb);

		} catch (Exception e) {
			vo
					.setStrMsgString(" --> StoreItemMstDAO.getBatchUpdateStoreCombo()-->"
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}
	}

}
