package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.MiscellaneousConsumptionDAO;

import mms.transactions.vo.MiscellaneousConsumptionTransVO;

/**
 * Developer : Tanvi Sappal
 * Version : 1.0 
 * ModifyDate : 02/June/2009
 * Module:MMS
 * Process: Miscellaneous Consumptions
 *
 */



/**This method is used to populate the value of Store Name combo box for this activity called the 
 * proc_hstt_store_mst() procedure which is available in Pkg_Mms_View package.
 * @author Administrator
 *
 */
public class MiscellaneousConsumptionTransDAO {

	public static void getInitialValues(MiscellaneousConsumptionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("mms", "MiscellaneousConsumptionTransDAO");

			strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "12",1);
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj
					.getStrHospitalCode(),3);
			
			/* Setting Default Value Start*/
			daoObj.setProcInValue(nProcIndex, "storeid", "0",4);
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0",5);
			/* Setting Default Value End */
			
			daoObj.setProcOutValue(nProcIndex, "err", 1,6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setStoreNameValuesWS(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("MiscellaneousConsumptionTransDAO.getInitialValues() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	
	/**This method is used to populate the value of Item Category combo box for this activity called the 
	 * proc_item_category_list() procedure which is available in Pkg_Mms_View package.
	 * @author Administrator
	 *
	 */
	public static void getItemCategoryCmb(MiscellaneousConsumptionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("mms", "MiscellaneousConsumptionTransDAO");

			strProcName = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "store_id", voObj
					.getStrStoreValId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj
					.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "reqType", voObj
					.getStrRequestType(),4);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setItemCategoryWS(ws);
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("MiscellaneousConsumptionTransDAO.getItemCategoryCmb() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	
	/**The following procedure is used to populate the value of Group Name combo box using Pkg_Mms_View.proc_store_group_list() procedure.
	 * @param voObj
	 */
	public static void getGroupNameValues(MiscellaneousConsumptionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("mms","MiscellaneousConsumptionTransDAO");

			strProcName = "{call Pkg_Mms_View.proc_store_group_list(?,?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			
			daoObj.setProcInValue(nProcIndex, "item_category", voObj.getStrItemCategoryId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			
			/* Setting Default Value Start*/
			daoObj.setProcInValue(nProcIndex, "strPhyStockNo", "",4);
			daoObj.setProcInValue(nProcIndex, "strStoreId", "",5);
			/* Setting Default Value End */

			
			daoObj.setProcOutValue(nProcIndex, "err", 1,6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setGroupNameWS(ws);
				} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			
			e.printStackTrace();
			voObj
					.setStrMsgString("MiscellaneousConsumptionTransDAO.getGroupNameValues() --> "
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
	public synchronized static void insertMiscConsumpRecord(
			MiscellaneousConsumptionTransVO vo) {

		HisDAO daoObj = null;
		MiscellaneousConsumptionDAO miscellaneousConsumptionDAO = new MiscellaneousConsumptionDAO();

		String strFuncName = "";
		int nProcIndex = 0;
		int nFuncIndex = 0;
		String strErr = "";
		String strConsumptionNo = "";
	   

		try 
		{
			daoObj = new HisDAO("mms", "MiscellaneousConsumptionTransDAO");
			
			System.out.println("------------------MiscellaneousConsumptionTransDAO.insertMiscConsumpRecord--------------------");
			
			/*
			strFuncName = "{? = call MMS_MST.generate_issueno(?::numeric,?::numeric,?::numeric,?::numeric,?::numeric)}";
			
			nFuncIndex = daoObj.setFunction(strFuncName);			
		
			daoObj.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrStoreValId());
			daoObj.setFuncInValue(nFuncIndex, 4, vo.getStrRequestType());
			daoObj.setFuncInValue(nFuncIndex, 5, vo.getStrItemCategoryId());
			
			daoObj.setFuncOutValue(nFuncIndex, 3);
			
			daoObj.executeFuncForNumeric(nFuncIndex);
			strConsumptionNo = daoObj.getFuncNumeric(nFuncIndex).toString();
			*/
			System.out.println("getStrRequestType--------------------"+vo.getStrRequestType());
			
			nFuncIndex = daoObj.setFunction("{? = call MMS_MST.generate_issueNo(?,?,?,?)}");

			daoObj.setFuncInValue(nFuncIndex, 2,vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 3,vo.getStrStoreValId());
			daoObj.setFuncInValue(nFuncIndex, 4,vo.getStrRequestType());
			daoObj.setFuncInValue(nFuncIndex, 5,vo.getStrItemCategoryId());
			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);
			strConsumptionNo = daoObj.getFuncString(nFuncIndex);
			
			System.out.println("strConsumptionNo--------------------"+strConsumptionNo);
			
			
			
			System.out.println("-------------------PKG_MMS_DML.dml_miss_consumption_dtl --[ Mode - 1 ]--INSERT INTO hstt_miss_consumption_dtl----------------");
			System.out.println("-------------------Pkg_Mms_Dml.Dml_Stock_Update --[ Mode - 3 ]---------------------------------------------------------------");
	
			for(int i=0 , stopI = vo.getStrConsumptionQty().length;i<stopI;i++)
			{
								
				miscellaneousConsumptionDAO.setStrStoreValId(vo.getStrStoreValId());
				miscellaneousConsumptionDAO.setStrConsumptionNo(strConsumptionNo);
				miscellaneousConsumptionDAO.setStrHospitalCode(vo.getStrHospitalCode());
				miscellaneousConsumptionDAO.setStrItemCategoryId(vo.getStrItemCategoryId());
				miscellaneousConsumptionDAO.setStrFinancialStartDate(vo.getStrFinancialStartDate());
				miscellaneousConsumptionDAO.setStrFinancialEndDate(vo.getStrFinancialEndDate());
				miscellaneousConsumptionDAO.setStrRemarks(vo.getStrRemarks());
				miscellaneousConsumptionDAO.setStrSeatId(vo.getStrSeatId());
				miscellaneousConsumptionDAO.setStrIsValid(vo.getStrIsValid());
				
				miscellaneousConsumptionDAO.setStrItemId(vo.getStrItemId()[i]);
				miscellaneousConsumptionDAO.setStrItemBrandId(vo.getStrItemBrandId()[i]);
				miscellaneousConsumptionDAO.setStrBatchSlNo(vo.getStrBatchSlNo()[i]);
				miscellaneousConsumptionDAO.setStrInhandQty(vo.getStrInhandQty()[i]);
				miscellaneousConsumptionDAO.setStrInhandQtyUnitId(vo.getStrInhandQtyUnitId()[i]);
				miscellaneousConsumptionDAO.setStrConsumptionQty(vo.getStrConsumptionQty()[i]);
				miscellaneousConsumptionDAO.setStrConsumptionQtyUnitId(vo.getStrUnitName()[i]);
				miscellaneousConsumptionDAO.setStrStockStatusCode(vo.getStrStockStatusCode()[i]);
				miscellaneousConsumptionDAO.setStrMRP(vo.getStrMRP()[i]);
				miscellaneousConsumptionDAO.setStrPur(vo.getStrPur()[i]);
			    miscellaneousConsumptionDAO.insert(daoObj);
			    
			    
			    

			     String	strProcName2 = "{call Pkg_Mms_Dml.Dml_Stock_Update(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			
			     System.out.println("vo.getStrItemBrandId()["+i+"]--------------------"+vo.getStrItemBrandId()[i]);
			     System.out.println("vo.getStrBatchSlNo()["+i+"]--------------------"+vo.getStrBatchSlNo()[i]);
			     System.out.println("vo.getStrStoreValId()["+i+"]--------------------"+vo.getStrStoreValId());
			     System.out.println("vo.getStrStockStatusCode()["+i+"]--------------------"+vo.getStrStockStatusCode()[i]);
			     
			
				int nProcIndex2 = daoObj.setProcedure(strProcName2);
				daoObj.setProcInValue(nProcIndex2, "modval", "3",1);
				daoObj.setProcInValue(nProcIndex2, "old_strid", vo.getStrStoreValId(),34);
				daoObj.setProcInValue(nProcIndex2, "old_itemid", vo.getStrItemId()[i],32);
				daoObj.setProcInValue(nProcIndex2, "old_itembrandid", vo.getStrItemBrandId()[i].trim(),33);
				daoObj.setProcInValue(nProcIndex2, "old_batchno",vo.getStrBatchSlNo()[i],30);
				daoObj.setProcInValue(nProcIndex2, "old_stockstatuscode",vo.getStrStockStatusCode()[i],29);
				
				daoObj.setProcInValue(nProcIndex2, "transNo", strConsumptionNo,40);
				daoObj.setProcInValue(nProcIndex2, "transDate", vo.getStrConsumptionDate(),41);
				
			//	System.out.println("Store Name-->"+vo.getStrStoreName());
				
				daoObj.setProcInValue(nProcIndex2, "description", "Miscellenous Consumption",42);
				
				daoObj.setProcInValue(nProcIndex2, "strid", vo.getStrStoreValId(),2);
				daoObj.setProcInValue(nProcIndex2, "itemid", vo.getStrItemId()[i],3);
				daoObj.setProcInValue(nProcIndex2, "itembrandid", vo.getStrItemBrandId()[i],4);
				daoObj.setProcInValue(nProcIndex2, "hosp_code",vo.getStrHospitalCode(),27);
				daoObj.setProcInValue(nProcIndex2, "itemcatno",vo.getStrItemCategoryId(),6);
				daoObj.setProcInValue(nProcIndex2, "inhandqty", vo.getStrConsumptionQty()[i],13);
				daoObj.setProcInValue(nProcIndex2, "inhandqtyunitid", vo.getStrUnitName()[i],14);
				daoObj.setProcInValue(nProcIndex2, "reservedFlag", vo.getStrReservedFlag(),39);
				daoObj.setProcInValue(nProcIndex2, "seatid", vo.getStrSeatId(),22);
				
				/* Setting Default Value Start*/
				daoObj.setProcInValue(nProcIndex2, "batchno", "0",5);
				daoObj.setProcInValue(nProcIndex2, "groupid", "",7);
				daoObj.setProcInValue(nProcIndex2, "subgroupid", "0",8);
				daoObj.setProcInValue(nProcIndex2, "expirydate", "",9);
				daoObj.setProcInValue(nProcIndex2, "manufdate", "",10);
				daoObj.setProcInValue(nProcIndex2, "stockstatuscode", "1",11);
				daoObj.setProcInValue(nProcIndex2, "inventoryflag", "",12);
				daoObj.setProcInValue(nProcIndex2, "suppid", "",15);
				daoObj.setProcInValue(nProcIndex2, "rate", vo.getStrPur()[i],16);
				daoObj.setProcInValue(nProcIndex2, "rateunitid", vo.getStrUnitName()[i],17);
				daoObj.setProcInValue(nProcIndex2, "saleprice", vo.getStrMRP()[i],18);
				daoObj.setProcInValue(nProcIndex2, "salepriceunitid", vo.getStrUnitName()[i],19);
				daoObj.setProcInValue(nProcIndex2, "pono", "",20);
				daoObj.setProcInValue(nProcIndex2, "podate", "",21);
				daoObj.setProcInValue(nProcIndex2, "suppliedBy", "",23);
				daoObj.setProcInValue(nProcIndex2, "recievedDate", "",24);
				daoObj.setProcInValue(nProcIndex2, "currencyCode", "",25);
				daoObj.setProcInValue(nProcIndex2, "freeItemFlag", "0",26);
				daoObj.setProcInValue(nProcIndex2, "currencyValue", "0",28);
				daoObj.setProcInValue(nProcIndex2, "old_itemSerialNo", "0",31);
				daoObj.setProcInValue(nProcIndex2, "itemParamFlag", "0",35);
				daoObj.setProcInValue(nProcIndex2, "partFlag", "0",36);
				daoObj.setProcInValue(nProcIndex2, "warrentyFlag", "0",37);
				daoObj.setProcInValue(nProcIndex2, "toStrId", "",38);
				daoObj.setProcInValue(nProcIndex2, "reqTypeId", "54",43);
				daoObj.setProcInValue(nProcIndex2, "blockQtyFlag", "0",44);
				daoObj.setProcInValue(nProcIndex2, "blockedQty", "0",45);
				daoObj.setProcInValue(nProcIndex2, "blockedQtyUnitId", "0",46);
				daoObj.setProcInValue(nProcIndex2, "releaseQty", "0",47);
				daoObj.setProcInValue(nProcIndex2, "releaseQtyUnitId", "0",48);
				daoObj.setProcInValue(nProcIndex2, "invoiceNo", "",49);
				daoObj.setProcInValue(nProcIndex2, "invoiceDate", "",50);
				daoObj.setProcInValue(nProcIndex2, "item_serialNoFlag", "1",51);
				daoObj.setProcInValue(nProcIndex2, "item_specification", "",52);
				/* Setting Default Value End */
				
				daoObj.setProcOutValue(nProcIndex2, "err", 1,54);
				daoObj.setProcOutValue(nProcIndex2, "retSerialNo", 1,53);
				
				daoObj.execute(nProcIndex2, 1);
			    
			}
			
			//synchronized (daoObj) {

				daoObj.fire();
				
				System.out.println("------------------MiscellaneousConsumptionTransDAO.insertMiscConsumpRecord----- END ---------------");

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
			
			vo.setStrMsgString("MiscellaneousConsumptionTransDAO.insertMiscConsumpRecord --> "
							+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
				miscellaneousConsumptionDAO = null;

			}
		}

	}
	
	/**This method is used to generate consumptions no for this activity this method call the get_miss_consumption_dtl()
	 * oracle function which is define in MMS_MST package.
	 * @param vo
	 */
	/*public static void getConsumptionNo(MiscellaneousConsumptionTransVO voObj) {

		HisDAO daoObj = null;

		String strFuncName = "";
		int nProcIndex = 0;
		int nFuncIndex = 0;
		String strErr = "";
		String strConsumptionNo = "";

		try {
			daoObj = new HisDAO("mms", "MiscellaneousConsumptionTransDAO");

			strFuncName = "{? = call MMS_MST.generate_consumption_No(?,?,?,?,?)}";
			nFuncIndex = daoObj.setFunction(strFuncName);

			
			daoObj.setFuncInValue(nFuncIndex, 2, "1");
			daoObj.setFuncInValue(nFuncIndex, 3, voObj.getStrRequestType());
			daoObj.setFuncInValue(nFuncIndex, 4, voObj.getStrStoreValId());
			daoObj.setFuncInValue(nFuncIndex, 5, voObj.getStrItemCategoryId());
			daoObj.setFuncInValue(nFuncIndex, 6, voObj.getStrHospitalCode());
			
			daoObj.setFuncOutValue(nFuncIndex, 1);
			
			daoObj.executeFunction(nFuncIndex);
			strConsumptionNo = daoObj.getFuncString(nFuncIndex);

			voObj.setStrConsumpNo(strConsumptionNo);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			voObj
					.setStrMsgString("MiscellaneousConsumptionTransDAO.getConsumptionNo --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}*/
	

}
