package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.dao.DmlHsttLpReqItemDtlDAO;
import mms.dao.DmlIndentDtlDAO;
import mms.transactions.vo.RequestForLPDeptVO;

/**
 * Developer : Amit Kumar Version : 1.0 Date : 1/May/2009 Modif Date : / /2009
 */
public class RequestForLPDeptDAO 
{
	/*------Not in Use-----*/
	/*public static void GetData(RequestForLPDeptVO vo) {

		HisDAO daoObj = null;

		WebRowSet ws = null;
		String strProcName = "";
		int nProcIndex = 0;
		String strErr = "";

		try {

			daoObj = new HisDAO("mms", "RequestForLPDeptDAO");

			strProcName = "{call pkg_mms_dml.dml_hstt_challan_dummy_dtl(?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modval", "1");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {

				// vo.setStrDummyWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			vo.setStrMsgString("RequestForLPDeptDAO.GetData() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}*/

	/**
	 * for getting Item category Combo by passing STORE_ID & HOSP_CODE
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void itemCategoryCombo(RequestForLPDeptVO vo)
	{
		String strProcName = "{call PKG_MMS_VIEW.proc_item_category_list(?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		String str = "";
		HisUtil hisutil = null;
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			hisutil    = new HisUtil("master", "RequestForLPPatientDAO");
			daoObj=new HisDAO("Issue To Patient","RequestForLPPatientDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
				
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			
			daoObj.setProcInValue(nProcIndex, "reqType", "0"); // Default
			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			
			
			if (strErr.equals("")) 
			{
				if(ws!=null && ws.size()!=0)
				{
					str = hisutil.getOptionValue(ws, "-1","0^Select Value", true);
					vo.setStrItemCatgCombo(str);					
				}	
				else
				{
					str = "<option value='0'>DATA N/A</option>";  
					vo.setStrItemCatgCombo(str);
				}	
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("ReceiveFromThirdPartyTransDAO.itemCategory() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of combo on add page (store type name )
	 * 
	 * @param vo
	 */
	public static void GetGroupNameCombo(RequestForLPDeptVO vo) {
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			hisutil = new HisUtil("master", "RequestForLPDeptDAO");
			dao = new HisDAO("mms",
					"RequestForLPDeptDAO.GetGroupNameCombo(RequestForLPDeptVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

            dao.setProcInValue(procIndex1, "modeval", "1");
			
			dao.setProcInValue(procIndex1, "item_category", vo.getStrItemCategoryNo());
			
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			
			/* Setting Default Value Start*/
			dao.setProcInValue(procIndex1, "strPhyStockNo", "");
			dao.setProcInValue(procIndex1, "strStoreId", "");
			/* Setting Default Value End */


			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "-1", "0^Select Value", true);
				vo.setStrGroupIdForItemSearch(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrGroupIdForItemSearch(str);
			}
		} catch (Exception e) {
			vo.setStrMsgString("RequestForLPDeptDAO.GetGroupNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}

	/*
	 * This Function is used to get Store Name by Passing 2 variable a) Hospital
	 * Code b) Store Id
	 */
	public static void callingFunctionStoreName(RequestForLPDeptVO vo) {
		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		try {
			dao = new HisDAO("MMSModule", "RequestForLPDeptDAO");
			funcIndex = dao
					.setFunction("{? = call MMS_MST.get_store_dtl(?,?,?)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, "1");
			dao.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4, vo.getStrStoreId());
			dao.setFuncOutValue(funcIndex, 1);
			// Execute Function
			dao.executeFunction(funcIndex);
			retVal = dao.getFuncString(funcIndex);
			if (retVal != null) {
				vo.setStrStoreName(retVal);
			} else {
				retVal = "-----";
				vo.setStrStoreName(retVal);
			}

		} catch (Exception e) {
			vo
					.setStrMsgString("IndentDeskCondemnationReqTransDAO.callingFunctionStoreName() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/*
	 * This Function is used to get Item Category Name by Passing 2 variable a)
	 * Hospital Code b) Item Category
	 */

	public static void callingItemCategory(RequestForLPDeptVO vo) {

		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		// Split the Value

		try {
			dao = new HisDAO("MMSModule", "IndentDeskCondemnationReqTransDAO");
			funcIndex = dao
					.setFunction("{? = call MMS_MST.get_itemcat_dtl(?,?,?)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, "1");
			dao.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4, vo.getStrItemCategoryNo());
			dao.setFuncOutValue(funcIndex, 1);
			// Execute Function
			dao.executeFunction(funcIndex);
			retVal = dao.getFuncString(funcIndex);

			if (retVal != null) {
				vo.setStrItemCatg(retVal);
			} else {
				retVal = "-----";
				vo.setStrItemCatg(retVal);
			}

		} catch (Exception e) {
			vo
					.setStrMsgString("IndentDeskCondemnationReqTransDAO.callingItemCategory() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * for getting option value of combo on add page (Grant Type Combo)
	 * 
	 * @param vo
	 */
	public static void GetGrantTypeCombo(RequestForLPDeptVO vo) {
		String err = "";
		String proc_name1 = "{call PKG_MMS_VIEW.proc_grant_list(?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			hisutil = new HisUtil("master", "RequestForLPDeptDAO");
			dao = new HisDAO("mms",
					"RequestForLPDeptDAO.GetSoreNameCombo(RequestForLPDeptVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "modeval", "1");

			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode());

			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return

			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object
			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "-1", "0^Select Value", true);
				vo.setStrGrantTypeCombo(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrGrantTypeCombo(str);
			}
		} catch (Exception e) {
			vo.setStrMsgString("RequestForLPDeptDAO.GetGrantTypeCombo() --> "
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
	 * for getting option value of combo on add page (Recommende Combo)
	 * 
	 * @param vo
	 */
	public static void GetRecommendByCombo(RequestForLPDeptVO vo) {
		String err = "";
		String proc_name1 = "{call PKG_MMS_VIEW.Proc_Consultant_Name(?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			hisutil = new HisUtil("master", "RequestForLPDeptDAO");
			dao = new HisDAO("mms",
					"RequestForLPDeptDAO.GetSoreNameCombo(RequestForLPDeptVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "modeval", "1");

			dao.setProcInValue(procIndex1, "deptunitcode", "0");
			
			
			
			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode());
			
			dao.setProcInValue(procIndex1, "seatId", vo.getStrSeatId());
			
			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return

			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object
			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "-1", "0^Select Value", true);
				vo.setStrRecmndByCombo(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrRecmndByCombo(str);
			}
		} catch (Exception e) {
			vo.setStrMsgString("RequestForLPDeptDAO.GetRecommendByCombo() --> "
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
	 * for getting option value of combo on add page (store type name )
	 * 
	 * @param vo
	 */
	public static WebRowSet GetItemCategoryCombo(RequestForLPDeptVO vo) {
		String err = "";
		String proc_name1 = "{call PKG_MMS_VIEW.proc_item_category_list(?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		try {
			// hisutil = new HisUtil("master", "RequestForLPDeptDAO");
			dao = new HisDAO("mms",
					"RequestForLPDeptDAO.GetSoreNameCombo(RequestForLPDeptVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "modeval", "1");

			dao.setProcInValue(procIndex1, "store_id", vo.getStrStoreId()); // Check
																			// It

			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode());
			
			dao.setProcInValue(procIndex1, "reqType", "0"); // Default Value

			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return

			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object
			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

		} catch (Exception e) {
			vo.setStrMsgString("RequestForLPDeptDAO.GetItemCategoryCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

		return ws;
	}

	/**
	 * for getting option value of combo on add page (store type name )
	 * 
	 * @param vo
	 */
	public static void ToStoreCombo(RequestForLPDeptVO vo) {
		String err = "";
		String proc_name1 = "{call Pkg_Mms_View.proc_hstt_toStore_mst(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			hisutil = new HisUtil("master", "RequestForLPDeptDAO");
			dao = new HisDAO("mms",
					"RequestForLPDeptDAO.GetDeptCombo(RequestForLPDeptVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

             dao.setProcInValue(procIndex1, "modeval", "1");

			

			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode());

			dao.setProcInValue(procIndex1, "storeid", vo.getStrStoreId());

			dao.setProcInValue(procIndex1, "reqType", vo.getStrReqType());
			
			dao.setProcInValue(procIndex1, "catCode", vo.getStrItemCategoryNo());
			

			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "", "", true);
				vo.setStrToStoreCombo(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrToStoreCombo(str);
			}

		} catch (Exception e) {
			vo.setStrMsgString("RequestForLPDeptDAO.ToStoreCombo() --> "
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
	 * INSERT method is used to insert data in following table
	 * 
	 * @param vo
	 */

	public static void INSERT(RequestForLPDeptVO vo) 
	{
		HisDAO dao = null;
        int procIndex1 = 0;
		DmlIndentDtlDAO globalDao = null;
		String indentNo = "";
		String approvalFlg ="";
		try 
		{
    		  		
    		    dao = new HisDAO("MMS","transactions.RequestForLPDeptDAO.INSERT()");
    		 // Createing Object for Table Specific DAO
    		    globalDao = new DmlIndentDtlDAO(); 		
 			
				globalDao.setStrId(vo.getStrStoreId());
				globalDao.setHosp_code(vo.getStrHospitalCode());
				globalDao.setReqTypeId(vo.getStrReqType());
				globalDao.setToStrId(vo.getStrToStoreCombo());  
				globalDao.setItemcatNo(vo.getStrItemCategoryNo());
				globalDao.setItemTypeId("0"); 
				globalDao.setUrgentFlag(vo.getStrUregentFlg());  
				globalDao.setIndentPeriod("0");	 	
				globalDao.setFinStartDate(vo.getStrFinancialStartYear());
				globalDao.setFinEndDate(vo.getStrFinancialEndYear());
			    globalDao.setRemarks(vo.getStrRemarks());
				globalDao.setSeatId(vo.getStrSeatId());
			    
				globalDao.setGrantTypeId("0");
				globalDao.setPuk("0");
				globalDao.setEmpNo("0");
				globalDao.setAdmNo("0");
				globalDao.setEpisodeCode("0");
				globalDao.setConsultantId("0");
				globalDao.setMemoNo("0");
				globalDao.setTotCost("0");	
				
				procIndex1 = globalDao.insert(dao);
									
	         
		      synchronized(dao)   
			  {
	        	dao.fire();     // Here we Execute in Batch
			  }
		      indentNo    = dao.getString(procIndex1, "indentNo");
		      approvalFlg = dao.getString(procIndex1, "approvalFlg");
			  // ////System.out.println("Indent No-->>"+indentNo);
			  // ////System.out.println("Approval Flg-->>"+approvalFlg);
			  INSERTINTABLE(vo,indentNo,approvalFlg); 
		} 
    	catch (Exception e) 
    	{
    		e.printStackTrace();
			vo.setStrMsgString("--> RequestForLPDeptDAO.INSERT()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} 
    	finally 
    	{
			if (dao != null)
				dao.free();
			dao = null;
		}

	}
	
	public static void INSERTINTABLE(RequestForLPDeptVO vo,String indentNo,String approvalFlg) 
	{
		HisDAO dao = null;
		String[] temp = null;
    	String[] strTemp = null;
		String[] reqQtyUnit=null;
		
	//	String[] sancQtyUnit=null;
		
		String strReqQty  = "";
		String strReqUnit ="";
		String strSancQty ="0";
	//	String strSancQtyUnit="0";

    	DmlHsttLpReqItemDtlDAO tableDao = null;
		// Createing Object for Table Specific DAO
		
		try 
		{
			HisUtil util = new HisUtil("","");
			
			String strCtDate = util.getASDate("dd-MMM-yyyy"); 
			
			tableDao  = new DmlHsttLpReqItemDtlDAO();
    		dao = new HisDAO("MMS","transactions.RequestForLPStaffDAO.INSERT()");
 			int length = vo.getItemParamValue().length;
			
 			for(int i = 0;i<length;i++)
			{
		    	temp  = vo.getItemParamValue()[i].replace('#', '#').split("#");
				
				// ////System.out.println("Display Value-->>>>"+temp[0]);
				// ////System.out.println("Conversion  Value-->>>>"+temp[1]);
				// ////System.out.println("User  Value-->>>>"+temp[2]);
			    
				strTemp         = temp[2].replace('^', '#').split("#");
				/*			
				// ////System.out.println("ItemID-1->>"+strTemp[0]);
				// ////System.out.println("ItemBrandID-2->>"+strTemp[1]);
				// ////System.out.println("GrpID-3->>"+strTemp[2]);
				// ////System.out.println("Sub_GrpID-4->>"+strTemp[3]);
				// ////System.out.println("Cosumble Flg-5->>"+strTemp[4]);
				// ////System.out.println("Re-Order Qty-6->>"+strTemp[5]);
				// ////System.out.println("Re-Order Qty unit Id-7->>"+strTemp[6]);
				// ////System.out.println("In Hand Qty-8->>"+strTemp[7]);
				// ////System.out.println("In Hand Qty Unit Id-9->>"+strTemp[8]);
				// ////System.out.println("Last Rate-10->>"+strTemp[9]);
				// ////System.out.println("Last Rate Unit Id-11->>"+strTemp[10]);
				
				
				// ////System.out.println("Inventory Unit Id-12->>"+strTemp[11]);
				// ////System.out.println("Last PO No-13->>"+strTemp[12]);
				// ////System.out.println("Last PO Date-14->>"+strTemp[13]);
				// ////System.out.println("Last Supplied By [Id]-15->>"+strTemp[14]);
				// ////System.out.println("Batch No-16->>"+strTemp[15]);
				// ////System.out.println("Expiry Date-17->>"+strTemp[16]);
				// ////System.out.println("Manufacture Date-18->>"+strTemp[17]);
				// ////System.out.println("Item Serial No-19->>"+strTemp[18]);
				// ////System.out.println("Last Received Qty [PO]-20->>"+strTemp[19]);
				// ////System.out.println("Last Received Qty Unit Id [PO]-21->>"+strTemp[20]);
				
				// ////System.out.println("Last Indented Qty-22->>"+strTemp[21]);
				// ////System.out.println("Last Indented Qty Unit Id-23->>"+strTemp[22]);
				// ////System.out.println("Last Received Qty-24->>"+strTemp[23]);
				// ////System.out.println("Last Received Qty Unit Id-25->>"+strTemp[24]);
				// ////System.out.println("Last Year Consumption Qty-26->>"+strTemp[25]);
				// ////System.out.println("Last Year Consumption Qty Unit Id-27->>"+strTemp[26]);
				// ////System.out.println("Prefix-28->>"+strTemp[27]);
				// ////System.out.println("Cost Parameter-29->>"+strTemp[28]);
				// ////System.out.println("Cost Unit [on individual item or on total cost]-30->>"+strTemp[29]);
				// ////System.out.println("Purchase Lead Time-31->>"+strTemp[30]);
				
				// ////System.out.println("Purchase Lead Time Unit-32->>"+strTemp[31]);
				// ////System.out.println("Stock Status-33->>"+strTemp[32]);
			*/		
				 strReqQty      = vo.getStrReqQty()[i];
				 strReqUnit     = vo.getStrUnitName()[i];
	    	     reqQtyUnit = strReqUnit.split("\\^");

		    	 
			     if(approvalFlg.equals("0"))
			     {
			    	  strSancQty     = strReqQty;
			 	//	  strSancQtyUnit = reqQtyUnit[0];
			     }	
			     else
			     {
			    	 strSancQty     = "0";
			    //	 strSancQtyUnit = "0";
			     }	  		    	 

				 // ////System.out.println("indent No-in LP DEPT .->>>"+indentNo);
				// ////System.out.println("Store ID LP DEEPT.....--->>>"+vo.getStrStoreId());
				 tableDao.setStrLpReqNo(indentNo);
				 tableDao.setStrId(vo.getStrStoreId());  
				 tableDao.setHosp_code(vo.getStrHospitalCode());
				 tableDao.setStrLpReqDate(strCtDate); 
				 tableDao.setGroupId(strTemp[2]);
				 tableDao.setSubGroupId(strTemp[3]);
				 tableDao.setItemId(strTemp[0]);
				 tableDao.setItemBrandId(strTemp[1]);
				 tableDao.setRate(strTemp[9]);
				 tableDao.setRateUnitId(strTemp[10]);
				 tableDao.setReqQty(strReqQty);
				 tableDao.setReqQtyUnitId(reqQtyUnit[0]);
				 tableDao.setSancQty(strSancQty);
				 tableDao.setSancQtyUnitId(strSancQty);
				 tableDao.setIssueQty("0");
				 tableDao.setIssueQtyUnitId("0");
				 tableDao.setReturnQty("0");
				 tableDao.setReturnQtyUnitId("0");
				 tableDao.setRemarks(vo.getStrRemarks());
				 tableDao.setIsValid("1");
				 tableDao.setInHandQty(strTemp[7]);
				 tableDao.setInHandQtyUnitId(strTemp[8]);
				 tableDao.setLstRecvQty(strTemp[23]);
				 tableDao.setLstRecvQtyUnitId(strTemp[24]);
				 tableDao.setStrLstRecDate("");
				 
				 tableDao.insert(dao);
					
	          }
		      synchronized(dao)   
			  {
	        	dao.fire();     // Here we Execute in Batch
			  }
		    
		} 
    	catch (Exception e) 
    	{
    		e.printStackTrace();
			vo.setStrMsgString("--> RequestForLPPatientDAO.INSERTINTABLE()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} 
    	finally 
    	{
			if (dao != null)
				dao.free();
			dao = null;
		}

	}
	
	
}
