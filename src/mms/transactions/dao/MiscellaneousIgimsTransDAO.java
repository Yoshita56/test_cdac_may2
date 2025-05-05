package mms.transactions.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
import mms.dao.MiscellaneousConsumptionDAO;
import mms.transactions.vo.MiscellaneousIgimsTransVO;

/**
 * Developer : Tanvi Sappal
 * Version : 1.0 
 * ModifyDate : 02/June/2009
 * Module:MMS
 * Process: Miscellaneous Consumptions
 *
 */

/**
 * This method is used to populate the value of Store Name combo box for this
 * activity called the proc_hstt_store_mst() procedure which is available in
 * Pkg_Mms_View package.
 * 
 * @author Administrator
 *
 */
public class MiscellaneousIgimsTransDAO {

	public static void getInitialValues(MiscellaneousIgimsTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("mms", "MiscellaneousConsumptionTransDAO");

			strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "12", 1);
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId(), 2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 3);

			/* Setting Default Value Start */
			daoObj.setProcInValue(nProcIndex, "storeid", "0", 4);
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0", 5);
			/* Setting Default Value End */

			daoObj.setProcOutValue(nProcIndex, "err", 1, 6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 7);

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

			voObj.setStrMsgString("MiscellaneousConsumptionTransDAO.getInitialValues() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * This method is used to populate the value of Item Category combo box for this
	 * activity called the proc_item_category_list() procedure which is available in
	 * Pkg_Mms_View package.
	 * 
	 * @author Administrator
	 *
	 */
	public static void getItemCategoryCmb(MiscellaneousIgimsTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("mms", "MiscellaneousConsumptionTransDAO");

			strProcName = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2", 1);
			daoObj.setProcInValue(nProcIndex, "store_id", voObj.getStrStoreValId(), 2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 3);
			daoObj.setProcInValue(nProcIndex, "reqType", voObj.getStrRequestType(), 4);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 6);

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

			voObj.setStrMsgString("MiscellaneousConsumptionTransDAO.getItemCategoryCmb() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * The following procedure is used to populate the value of Group Name combo box
	 * using Pkg_Mms_View.proc_store_group_list() procedure.
	 * 
	 * @param voObj
	 */
	public static void getGroupNameValues(MiscellaneousIgimsTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("mms", "MiscellaneousConsumptionTransDAO");

			strProcName = "{call Pkg_Mms_View.proc_store_group_list(?,?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2", 1);

			daoObj.setProcInValue(nProcIndex, "item_category", voObj.getStrItemCategoryId(), 2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 3);

			/* Setting Default Value Start */
			daoObj.setProcInValue(nProcIndex, "strPhyStockNo", "", 4);
			daoObj.setProcInValue(nProcIndex, "strStoreId", "", 5);
			/* Setting Default Value End */

			daoObj.setProcOutValue(nProcIndex, "err", 1, 6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 7);

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
			voObj.setStrMsgString("MiscellaneousConsumptionTransDAO.getGroupNameValues() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * This Method is used to insert the Miscellaneous Consumptions in database for
	 * this activity call the insert() method which is define in table specific dao
	 * MiscellaneousConsumptionDAO java file.
	 * 
	 * @param voObj
	 */
	public synchronized static void insertMiscConsumpRecord(MiscellaneousIgimsTransVO vo) {

		HisDAO daoObj = null;
		MiscellaneousConsumptionDAO miscellaneousConsumptionDAO = new MiscellaneousConsumptionDAO();

		String strFuncName = "";
		int nProcIndex = 0;
		int nFuncIndex = 0;
		String strErr = "";
		String strConsumptionNo = "";

		try {
			daoObj = new HisDAO("mms", "MiscellaneousConsumptionTransDAO");

			System.out.println("-- MiscellaneousConsumptionTransDAO.insertMiscConsumpRecord -[ START ]-");

			strFuncName = "{? = call MMS_MST.generate_issueNo(?::numeric,?::numeric,?::numeric,?::numeric)}";
			nFuncIndex = daoObj.setFunction(strFuncName);

			daoObj.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			daoObj.setFuncInValue(nFuncIndex, 3, vo.getStrStoreValId());
			daoObj.setFuncInValue(nFuncIndex, 4, "54");
			daoObj.setFuncInValue(nFuncIndex, 5, "0");
			daoObj.setFuncOutValue(nFuncIndex, 1);
			daoObj.executeFunction(nFuncIndex);
			strConsumptionNo = daoObj.getFuncNumeric(nFuncIndex).toString();
			vo.setStrConsumpNo(strConsumptionNo);

			for (int i = 0, stopI = vo.getStrConsumptionQty().length; i < stopI; i++) {

				miscellaneousConsumptionDAO.setStrStoreValId(vo.getStrStoreValId());
				miscellaneousConsumptionDAO.setStrConsumptionNo(strConsumptionNo);
				miscellaneousConsumptionDAO.setStrHospitalCode(vo.getStrHospitalCode());
				miscellaneousConsumptionDAO.setStrItemCategoryId(vo.getStrItemBrandId()[i].substring(0, 2));
				miscellaneousConsumptionDAO.setStrFinancialStartDate(vo.getStrFinancialStartDate());
				miscellaneousConsumptionDAO.setStrFinancialEndDate(vo.getStrFinancialEndDate());
				// System.out.println("--Pat Name --"+vo.getStrPatientName());
				// System.out.println("--Remarks --"+vo.getStrRemarks());

				miscellaneousConsumptionDAO.setStrRemarks(vo.getStrPatientName() + "$" + vo.getStrRemarks());
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
				miscellaneousConsumptionDAO.setStrPur(vo.getStrMRP()[i]);
				miscellaneousConsumptionDAO.setStrConsumptionDate(vo.getStrIndentIssueDate());
				miscellaneousConsumptionDAO.setStrIsValid(vo.getStrIndentNo());
				System.out.println("-- PKG_MMS_DML.dml_miss_consumption_dtl [ Mode - 1 ] --");
				miscellaneousConsumptionDAO.insert(daoObj); // PKG_MMS_DML.dml_miss_consumption_dtl [ Mode - 1 ]

				System.out.println("-- getStrItemBrandId-" + i + "-" + vo.getStrItemBrandId()[i].substring(0, 2));

				String strProcName2 = "{call Pkg_Mms_Dml.Dml_Stock_Update(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

				int nProcIndex2 = daoObj.setProcedure(strProcName2);
				daoObj.setProcInValue(nProcIndex2, "modval", "3", 1);
				daoObj.setProcInValue(nProcIndex2, "old_strid", vo.getStrStoreValId(), 34);
				daoObj.setProcInValue(nProcIndex2, "old_itemid", vo.getStrItemId()[i], 32);
				daoObj.setProcInValue(nProcIndex2, "old_itembrandid", vo.getStrItemBrandId()[i].trim(), 33);
				daoObj.setProcInValue(nProcIndex2, "old_batchno", vo.getStrBatchSlNo()[i], 30);
				daoObj.setProcInValue(nProcIndex2, "old_stockstatuscode", vo.getStrStockStatusCode()[i], 29);

				daoObj.setProcInValue(nProcIndex2, "transNo", strConsumptionNo, 40);
				daoObj.setProcInValue(nProcIndex2, "transDate", vo.getStrConsumptionDate(), 41);

				// //System.out.println("Store Name-->"+vo.getStrStoreName());
				if (!vo.getStrPatientName().equals("")) {
					daoObj.setProcInValue(nProcIndex2, "description",
							"Miscellenous Consumption For [" + vo.getStrIndentNo() + "] Patient "
									+ vo.getStrPatientName() + " With Batch " + vo.getStrBatchSlNo()[i] + " Qty - "
									+ vo.getStrConsumptionQty()[i] + " No. ",
							42);
				} else {
					daoObj.setProcInValue(nProcIndex2, "description", "Miscellenous Consumption With Batch "
							+ vo.getStrBatchSlNo()[i] + " Qty - " + vo.getStrConsumptionQty()[i] + " No. ", 42);
				}

				daoObj.setProcInValue(nProcIndex2, "strid", vo.getStrStoreValId(), 2);
				daoObj.setProcInValue(nProcIndex2, "itemid", vo.getStrItemId()[i], 3);
				daoObj.setProcInValue(nProcIndex2, "itembrandid", vo.getStrItemBrandId()[i], 4);
				daoObj.setProcInValue(nProcIndex2, "hosp_code", vo.getStrHospitalCode(), 27);
				daoObj.setProcInValue(nProcIndex2, "itemcatno", vo.getStrItemBrandId()[i].substring(0, 2), 6);
				daoObj.setProcInValue(nProcIndex2, "inhandqty", vo.getStrConsumptionQty()[i], 13);
				daoObj.setProcInValue(nProcIndex2, "inhandqtyunitid", vo.getStrUnitName()[i], 14);
				daoObj.setProcInValue(nProcIndex2, "reservedFlag", vo.getStrReservedFlag(), 39);
				daoObj.setProcInValue(nProcIndex2, "seatid", vo.getStrSeatId(), 22);

				/* Setting Default Value Start */
				daoObj.setProcInValue(nProcIndex2, "batchno", "0", 5);
				daoObj.setProcInValue(nProcIndex2, "groupid", "", 7);
				daoObj.setProcInValue(nProcIndex2, "subgroupid", "0", 8);
				daoObj.setProcInValue(nProcIndex2, "expirydate", "", 9);
				daoObj.setProcInValue(nProcIndex2, "manufdate", "", 10);
				daoObj.setProcInValue(nProcIndex2, "stockstatuscode", "1", 11);
				daoObj.setProcInValue(nProcIndex2, "inventoryflag", "", 12);
				daoObj.setProcInValue(nProcIndex2, "suppid", "", 15);
				daoObj.setProcInValue(nProcIndex2, "rate", vo.getStrMRP()[i], 16);
				daoObj.setProcInValue(nProcIndex2, "rateunitid", vo.getStrUnitName()[i], 17);
				daoObj.setProcInValue(nProcIndex2, "saleprice", vo.getStrMRP()[i], 18);
				daoObj.setProcInValue(nProcIndex2, "salepriceunitid", vo.getStrUnitName()[i], 19);
				daoObj.setProcInValue(nProcIndex2, "pono", "", 20);
				daoObj.setProcInValue(nProcIndex2, "podate", "", 21);
				daoObj.setProcInValue(nProcIndex2, "suppliedBy", "", 23);
				daoObj.setProcInValue(nProcIndex2, "recievedDate", "", 24);
				daoObj.setProcInValue(nProcIndex2, "currencyCode", "", 25);
				daoObj.setProcInValue(nProcIndex2, "freeItemFlag", "0", 26);
				daoObj.setProcInValue(nProcIndex2, "currencyValue", "0", 28);
				daoObj.setProcInValue(nProcIndex2, "old_itemSerialNo", "0", 31);
				daoObj.setProcInValue(nProcIndex2, "itemParamFlag", "0", 35);
				daoObj.setProcInValue(nProcIndex2, "partFlag", "0", 36);
				daoObj.setProcInValue(nProcIndex2, "warrentyFlag", "0", 37);
				daoObj.setProcInValue(nProcIndex2, "toStrId", "", 38);
				daoObj.setProcInValue(nProcIndex2, "reqTypeId", "54", 43);
				daoObj.setProcInValue(nProcIndex2, "blockQtyFlag", "0", 44);
				daoObj.setProcInValue(nProcIndex2, "blockedQty", "0", 45);
				daoObj.setProcInValue(nProcIndex2, "blockedQtyUnitId", "0", 46);
				daoObj.setProcInValue(nProcIndex2, "releaseQty", "0", 47);
				daoObj.setProcInValue(nProcIndex2, "releaseQtyUnitId", "0", 48);
				daoObj.setProcInValue(nProcIndex2, "invoiceNo", "", 49);
				daoObj.setProcInValue(nProcIndex2, "invoiceDate", "", 50);
				daoObj.setProcInValue(nProcIndex2, "item_serialNoFlag", "1", 51);
				daoObj.setProcInValue(nProcIndex2, "item_specification", "", 52);
				/* Setting Default Value End */

				daoObj.setProcOutValue(nProcIndex2, "err", 1, 54);
				daoObj.setProcOutValue(nProcIndex2, "retSerialNo", 1, 53);

				daoObj.execute(nProcIndex2, 1);

			}

			System.out.println("-- MiscellaneousConsumptionTransDAO.insertMiscConsumpRecord -[ END ]-");

			// synchronized (daoObj) {

			daoObj.fire();

			// }

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			e.printStackTrace();

			vo.setStrMsgString("MiscellaneousConsumptionTransDAO.insertMiscConsumpRecord --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
				miscellaneousConsumptionDAO = null;

			}
		}

	}

	public static void getImageHeader(MiscellaneousIgimsTransVO voObj) {
		String strFuncName = "";
		String strLogoName = "";

		int nFuncIndex = 0;
		HisDAO dao = null;
		try {
			dao = new HisDAO("DWH", "BreakageAndLostDrugDetailsRptDAO");

			strFuncName = "{? = call MMS_MST.logo_config_dtl(?,?)}";
			nFuncIndex = dao.setFunction(strFuncName);

			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, voObj.getStrHospitalCode());
			dao.setFuncOutValue(nFuncIndex, 1);

			dao.executeFunction(nFuncIndex);

			strLogoName = dao.getFuncString(nFuncIndex);
			voObj.setStrLogoName(strLogoName);
			// System.out.println("======strLogoName======="+strLogoName);

		} catch (Exception e) {

			e.printStackTrace();
			voObj.setStrMsgType("1");
			voObj.setStrMsgString("IssueTransDAO.getImageHeader() --> " + e.getMessage());

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/**
	 * Gets the issue dtls list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the issue dtls list This Function is Used To Get Ajax Voucher Details
	 */// Modified by Neha Sharma on 16th July 2013 ..
	public static void getIssueDtlsList(MiscellaneousIgimsTransVO vo) {
		String err;
		// String strSlNoflg;
		HisDAO dao = null;
		WebRowSet ws = null;
		int procIndex1 = 0;
		String proc_name1 = "{call pkg_mms_view.Proc_Emp_Issue_Detail(?,?,?,?,?,?)}"; // 6
		try {
			System.out.println(" ------- IssueTransODAO .getIssueDtlsList  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_Emp_Issue_Detail  --[ Mode- 4 ]------ ");

			dao = new HisDAO("mms", "global.IssueTransODAO.getStockItemDtlsList(IssueTransOVO vo)");
			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", "4", 1);
			dao.setProcInValue(procIndex1, "strId", vo.getStrStoreValId(), 3);
			dao.setProcInValue(procIndex1, "issueNo", vo.getStrConsumpNo(), 2);
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(), 4);
			dao.setProcOutValue(procIndex1, "ERR", 1, 5); // 1 for string return
			dao.setProcOutValue(procIndex1, "RESULTSET", 2, 6); // 2 for object
			// execute procedure
			dao.executeProcedureByPosition(procIndex1);
			// get value
			err = dao.getString(procIndex1, "ERR");
			if (err == null)
				err = "";
			ws = dao.getWebRowSet(procIndex1, "RESULTSET");
			vo.setWsIssueDetails(ws);
		} catch (Exception e) {
			e.printStackTrace();
			// e.printStackTrace();
			vo.setStrMsgString("IssueTransODAO.getIssueDtlsList() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	public static void GetData(MiscellaneousIgimsTransVO vo) 
	{
		HisDAO dao = null;
		WebRowSet wb = null;
		String str1 = null;
		HisUtil hisutil = null;
    	
		try 
		{
			hisutil = new HisUtil("MMS", "MiscellaneousConsumptionTransDAO");
			wb      = STORENAMECOMBO(vo);
			if(wb!= null)
			{	
			   if(wb.next())
			   {
				   vo.setStrStoreId(wb.getString(1));
				   wb.beforeFirst();
			   }
				str1 = hisutil.getOptionValue(wb, "","", true);
			    vo.setStrStoreName(str1);
			}
			 else
            {
               str1 = "<option value='0'>DATA  N/A</option>";   
               vo.setStrStoreName(str1);
            }		
		} 
    	catch (Exception e) 
    	{  
			vo.setStrMsgString("--> MiscellaneousConsumptionTransDAO.GetData()-->"+ e.getMessage());
			vo.setStrMsgType("1");
		} 
    	finally 
    	{
			if (dao != null)
				dao.free();
			dao = null;
		}
	}
	public static WebRowSet STORENAMECOMBO(MiscellaneousIgimsTransVO vo)
	{
		String proc_name = "";
		proc_name = "{call PKG_MMS_VIEW.proc_hstt_store_mst(?,?,?,?,?,?,?)}";		
		HisDAO dao = null;			
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet ws = null;

		try 
		{
			dao = new HisDAO("MMS","transactions.MiscellaneousConsumptionTransDAO.STORENAMECOMBO(VO)");
			nprocIndex = dao.setProcedure(proc_name);

			dao.setProcInValue(nprocIndex, "modeval", "11",1);
			dao.setProcInValue(nprocIndex, "seatid", vo.getStrSeatId(),2);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),3);
			dao.setProcInValue(nprocIndex, "storeid", vo.getStrStoreId(),4);
			dao.setProcInValue(nprocIndex, "storetype_id", vo.getStrStoreTypeId(),5);
			dao.setProcOutValue(nprocIndex, "err", 1,6);
			dao.setProcOutValue(nprocIndex, "resultset", 2,7);

			dao.executeProcedureByPosition(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");

			if (strerr == null)
				strerr = "";
			if (strerr.equals(""))
			{
				ws = dao.getWebRowSet(nprocIndex, "resultset");
				vo.setStrMsgType("0");
			} 
			else 
			{
				throw new Exception(strerr);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("-->MiscellaneousConsumptionTransDAO.STORENAMECOMBO()"+ e.getMessage());
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
		return ws;
	}
	public static void itemCategoryCombo(MiscellaneousIgimsTransVO vo)
	{
		System.out.println("for local purchase3");
		String strProcName = "{call PKG_MMS_VIEW.proc_item_category_list(?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		String str = "";
		HisUtil hisutil = null;
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			hisutil = new HisUtil("MMS", "MiscellaneousConsumptionTransDAO");
			daoObj  = new HisDAO("MMS","MiscellaneousConsumptionTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "reqType","56",4);
			daoObj.setProcOutValue(nProcIndex, "err",1,5); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,6);
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			
			if (strErr == null)
				strErr = "";
			
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			
			if (strErr.equals("")) 
			{
				if(ws!=null && ws.size()>0)
				{
					str = hisutil.getOptionValue(ws, "","", true);
					vo.setStrItemCatgCombo(str);
				}	
				else
				{
					str = "<option value='0'>DATA N/A</option>";  
					vo.setStrItemCatgCombo(str);
				}	
			} 
			else 
			{
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("MiscellaneousConsumptionTransDAO.itemCategoryCombo() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	 /**
	 * To get Issue Details i.e.(Store Name,Issue No.,Issue Date,Indent
	 * Type,Item Category,Raising Store) on 'issue' page
	 * 
	 * @param vo
	 */
	public static void getIssueDetail(MiscellaneousIgimsTransVO vo) 
	{
	    // Declaring Variables 
		String        err = "";
		int    procIndex1 = 0;
		HisDAO        dao = null;
		WebRowSet      ws = null;
		String proc_name1 = "{call Pkg_Mms_View.proc_OffLine_IssueNo_dtl(?,?,?,?,?,?,?,?)}";

		try 
		{
            // Cerating Object			
			       dao = new HisDAO("MMS",	"MiscellaneousConsumptionTransDAO.getIssueDetail(MiscellaneousIgimsTransVO vo)");
			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", 	"3",1);                  //1
			dao.setProcInValue(procIndex1, "storeid", 	vo.getStrStoreName(),2);//2
			dao.setProcInValue(procIndex1, "itemCatg", 	vo.getStrCrNo(),3);//3
			dao.setProcInValue(procIndex1, "from_date", vo.getStrFromDate(),4);//4
			dao.setProcInValue(procIndex1, "too_date", 	vo.getStrToDate(),5);//5
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),6); //6
			dao.setProcOutValue(procIndex1,"err", 		1,7); // 1 for string return //7
			// value
			dao.setProcOutValue(procIndex1, "resultset", 2,8); // 2 for object //8
			// execute procedure
			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			/*if (err == null)
				err = "";*/

			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");
				vo.setIssueNoDtlWs(ws);
				
			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {
            e.printStackTrace();
			vo.setStrMsgString("MiscellaneousConsumptionTransDAO.getIssueDetail() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
}
