package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

/*import mms.transactions.vo.OfflineIssueIndentTransVO;*/
import mms.transactions.vo.OfflineReturnTransVO;

/**
 * Developer : Amit Kumar Version : 1.0 Date : 16/Sep/2010 Modify:
 */
public class OfflineReturnTransDAO {
	/**
	 * for getting option value of combo on add page (store type name )
	 * 
	 * @param vo
	 */

	public static void GetData(OfflineReturnTransVO vo) {
		/* Declaring Variable */
		HisDAO dao = null;
		WebRowSet wb = null;
		String str1 = null;
		HisUtil hisutil = null;
		try {

			hisutil = new HisUtil("MMS", "OfflineReturnTransDAO");
			wb = STORENAMECOMBO(vo);
			if(wb.next())
			{
				vo.setStrStoreId(wb.getString(1));
			}
			wb.beforeFirst();
			if (wb != null) 
			{
				str1 = hisutil.getOptionValue(wb, vo.getStrStoreId(), "0^Select Value", true);
				vo.setStrStoreName(str1);
			} else {
				str1 = "<option value='0'>DATA N/A</option>";
				vo.setStrStoreName(str1);
			}

		} catch (Exception e) {

			vo.setStrMsgString("--> OfflineReturnTransDAO.GetData()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * STORENAMECOMBO(vo) -- > This Method is Used to get WebRowSet for Store
	 * Name Combo from Table
	 */
	public static WebRowSet STORENAMECOMBO(OfflineReturnTransVO vo) {
		String proc_name = "";

		proc_name = "{call PKG_MMS_VIEW.proc_hstt_store_mst(?,?,?,?,?,?,?)}";

		HisDAO dao = null;

		int nprocIndex = 0;

		String strerr = "";

		WebRowSet ws = null;

		try {

			dao = new HisDAO("MMS",
					"transactions.OfflineReturnTransDAO.STORENAMECOMBO(VO)");

			nprocIndex = dao.setProcedure(proc_name);

			// set value

			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcInValue(nprocIndex, "seatid", vo.getStrSeatId(),2);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),3);
			dao.setProcInValue(nprocIndex, "storeid", "0",4);
			dao.setProcInValue(nprocIndex, "storetype_id", "0",5);
			dao.setProcOutValue(nprocIndex, "err", 1,6); // 1 for string return
			dao.setProcOutValue(nprocIndex, "resultset", 2,7); // 2 for object
			// execute procedure
			dao.executeProcedureByPosition(nprocIndex);

			// get value

			strerr = dao.getString(nprocIndex, "err");

			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {
				ws = dao.getWebRowSet(nprocIndex, "resultset");
				vo.setStrMsgType("0");
			} else {
				throw new Exception(strerr);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("-->OfflineReturnTransDAO.STORENAMECOMBO()"
					+ e.getMessage());

			vo.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

		return ws;
	}

	/**
	 * for getting option value of combo on add page (Indent Period Combo)
	 * 
	 * @param vo
	 */
	public static void IndentPeriodCombo(OfflineReturnTransVO vo) {
		// Declaring Variables
		String err = "";
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;
		String proc_name1 = "{call PKG_MMS_VIEW.PERIOD_COMBO_SSTT_PERIOD_MST(?,?,?,?)}";

		try {
			// Creating Object
			hisutil = new HisUtil("master", "OfflineReturnTransDAO");
			dao = new HisDAO("mms",
					"OfflineReturnTransDAO.GetDeptCombo(OfflineReturnTransVO vo)");
			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "modeval", "1",1);
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcOutValue(procIndex1, "err", 1,3); // 1 for string return
			dao.setProcOutValue(procIndex1, "resultset", 2,4); // 2 for object
			// execute procedure
			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "-1", "0^Select Value", true);
				vo.setStrIndentPeriodCombo(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrIndentPeriodCombo(str);
			}

		} catch (Exception e) {
			vo.setStrMsgString("OfflineReturnTransDAO.ToStoreCombo() --> "
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
	 * for getting Item category Combo by passing STORE_ID & HOSP_CODE
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void itemCategoryCombo(OfflineReturnTransVO vo) {
		int nProcIndex = 0;
		String strErr = "";
		String str = "";
		HisUtil hisutil = null;
		WebRowSet ws = null;
		HisDAO daoObj = null;
		String strProcName = "{call PKG_MMS_VIEW.proc_item_category_list(?,?,?,?,?,?)}";

		try {
			// Creating Object
			hisutil = new HisUtil("MMS", "OfflineReturnTransDAO");
			daoObj = new HisDAO("MMS", "OfflineReturnTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			// Set Values
			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "reqType", "18",4);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
			// execute procedure
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			// get values
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {
				if (ws != null) {
					str = hisutil.getOptionValue(ws, "-1", "0^Select Value",
							true);

					vo.setStrItemCategoryCmb(str);
					vo.setStrMsgType("0");
				} else {
					str = "<option value='0'>DATA N/A</option>";
					vo.setStrItemCategoryCmb(str);
					vo.setStrMsgType("0");
				}

			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("OfflineReturnTransDAO.itemCategoryCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	
	/**
	 * for getting Item category Combo by passing STORE_ID & HOSP_CODE
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void itemCategoryCombo1(OfflineReturnTransVO vo) {
		int nProcIndex = 0;
		String strErr = "";
		String str = "";
		HisUtil hisutil = null;
		WebRowSet ws = null;
		HisDAO daoObj = null;
		String strProcName = "{call PKG_MMS_VIEW.proc_item_category_list(?,?,?,?,?,?)}";

		try {
			// Creating Object
			hisutil = new HisUtil("MMS", "OfflineReturnTransDAO");
			daoObj = new HisDAO("MMS", "OfflineReturnTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			// Set Values
			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "reqType", "18",4);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
			// execute procedure
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			// get values
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if(ws.next())
			{
				vo.setStrItemCagID(ws.getString(1));
			}
            ws.beforeFirst();
			if (strErr.equals("")) {
				if (ws != null) {
					str = hisutil.getOptionValue(ws, vo.getStrItemCagID(), "0^Select Value",true);

					vo.setStrItemCategoryCmb(str);
					vo.setStrMsgType("0");
				} else {
					str = "<option value='0'>DATA N/A</option>";
					vo.setStrItemCategoryCmb(str);
					vo.setStrMsgType("0");
				}

			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("OfflineReturnTransDAO.itemCategoryCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * Method for getting option value of Indenting Store combo on add page
	 * (store type name )
	 * 
	 * @param vo
	 */
	public static void IndentingStoreCombo(OfflineReturnTransVO vo) {
		// Declaring Variables
		String err = "";
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;
		String proc_name1 = "{call Pkg_Mms_View.proc_hstt_toStore_mst(?,?,?,?,?,?,?)}";
		try {
			// Creating Object
			hisutil = new HisUtil("master", "OfflineReturnTransDAO");
			dao = new HisDAO("MMS",
					"OfflineReturnTransDAO.GetDeptCombo(OfflineReturnTransVO vo)");
			procIndex1 = dao.setProcedure(proc_name1);
			// set value
			dao.setProcInValue(procIndex1, "modeval", "2",1);
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(procIndex1, "storeid", vo.getStrStoreId(),3);
			dao.setProcInValue(procIndex1, "reqType", "18",4);
			//System.out.println("vo.getStrItemCagID()-->"+vo.getStrItemCagID());
			dao.setProcInValue(procIndex1, "catCode",vo.getStrItemCagID(),5);
			dao.setProcOutValue(procIndex1, "err", 1,6); // 1 for string return
			dao.setProcOutValue(procIndex1, "resultset", 2,7); // 2 for object
			// execute procedure
			dao.executeProcedureByPosition(procIndex1);
			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "-1", "0^Select Value", true);
				vo.setStrIndentStoreCombo(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrIndentStoreCombo(str);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("OfflineReturnTransDAO.ToStoreCombo() --> "
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
	 * This function is used to set details in approved By Combo.
	 * 
	 * @param _OfflineIssueIndentVO
	 */
	public static void getApprovedByCombo(OfflineReturnTransVO _OfflineReturnVO) 
	{
		// Declaring Variables

		int nProcIndex = 0;
		String strErr = "";
		HisUtil hisutil = null;
		WebRowSet ws = null;
		HisDAO daoObj = null;
		String str = null;
		String strProcName = "{call PKG_MMS_VIEW.proc_store_emp_dtl(?,?,?,?,?)}";
		try {
			// Creating Object
			hisutil = new HisUtil("master", "OfflineReturnTransDAO");
			daoObj = new HisDAO("MMS", "OfflineReturnTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			// set values
			daoObj.setProcInValue(nProcIndex, "modeVal", "1",1);
			daoObj.setProcInValue(nProcIndex, "storeId",   _OfflineReturnVO.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", _OfflineReturnVO.getStrHospitalCode(),3);
			daoObj.setProcOutValue(nProcIndex,"err",1,4); 
			daoObj.setProcOutValue(nProcIndex,"resultset",2,5);
			daoObj.executeProcedureByPosition(nProcIndex);
			// get value
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "-1", "0^Select Value", true);
				_OfflineReturnVO.setStrApprovedBy(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				_OfflineReturnVO.setStrApprovedBy(str);
			}

		} catch (Exception _err) {
			_OfflineReturnVO
					.setStrMsgString("OfflineReturnTransDAO.getApprovedByCombo() --> "
							+ _err.getMessage());
			_OfflineReturnVO.setStrMsgType("1");
		}
	}

	/**
	 * This function is used to get details Verify By Combo.
	 * 
	 * @param _OfflineReturnVO
	 */
	public static void getVerifyByCombo(
			OfflineReturnTransVO _OfflineReturnVO) {
		// Variable Declaration
		int nProcIndex = 0;
		String strErr = "";
		HisUtil hisutil = null;
		WebRowSet ws = null;
		HisDAO daoObj = null;
		String str = null;
		String strProcName = "{call PKG_MMS_VIEW.proc_store_emp_dtl(?,?,?,?,?)}";
		try {
			// Creating Object
			hisutil = new HisUtil("master", "OfflineReturnTransDAO");
			daoObj = new HisDAO("MMS", "OfflineReturnTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			// Set Value
			daoObj.setProcInValue(nProcIndex, "modeVal", "1",1);
			daoObj.setProcInValue(nProcIndex, "storeId",   _OfflineReturnVO.getStrIndentingStoreID(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", _OfflineReturnVO.getStrHospitalCode(),3);
			daoObj.setProcOutValue(nProcIndex,"err",1,4); 
			daoObj.setProcOutValue(nProcIndex,"resultset",2,5);
			// Execute Procedure
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "-1", "0^Select Value", true);
				_OfflineReturnVO.setStrVerifiedByValues(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				_OfflineReturnVO.setStrVerifiedByValues(str);
			}

		} catch (Exception _err) {
			_OfflineReturnVO
					.setStrMsgString("OfflineReturnTransDAO.getApprovedByCombo() --> "
							+ _err.getMessage());
			_OfflineReturnVO.setStrMsgType("1");
		}
	}

	public static void getPopUpInfoProc(OfflineReturnTransVO vo) {
		// Declaring Variables
		HisDAO dao = null;
		WebRowSet ws = null;
		String strProcName = "";
		int nProcIndex = 0;
		String strErr = "";
		try {
			// Creating Object
			dao = new HisDAO("MMS", "OfflineIssueIndentTransDAO");
			strProcName = "{call Pkg_Mms_View.PROC_RETURN_ITEM_DETAIL(?,?,?,?,?,?)}";
			nProcIndex = dao.setProcedure(strProcName);
			// Set Values
			dao.setProcInValue(nProcIndex, "MODEVAL", "1",1);
			dao.setProcInValue(nProcIndex, "RETURNNO", vo.getStrReturnNo(),2);
			dao.setProcInValue(nProcIndex, "STRID", vo.getStrStoreName(),3);
			dao.setProcInValue(nProcIndex, "HOSP_CODE", vo.getStrHospitalCode(),4);
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			// Execute Procedure
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				vo.setPopUpWS(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			vo.setStrMsgString("OfflineIssueIndentTransDAO.getPopUpInfoProc() --> "
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
	 * To get Return Details i.e.(Store Name,Return No.,Issue Date,Indent
	 * Type,Item Category,Raising Store) on 'issue' page
	 * 
	 * @param vo
	 */
	public static void getIssueDetail(OfflineReturnTransVO vo) {
		// Declaring Variables
		String err = "";
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		String proc_name1 = "{call Pkg_Mms_View.proc_OffLine_ReturnNo_dtl(?,?,?,?,?,?,?,?)}";

		try {
			// Cerating Object
			dao = new HisDAO("MMS",
					"OfflineReturnTransDAO.getIssueDetail(OfflineReturnTransVO vo)");
			procIndex1 = dao.setProcedure(proc_name1);
            
			// set value
			dao.setProcInValue(procIndex1, "modeval", "1",1); // 1
			dao.setProcInValue(procIndex1, "storeid", vo.getStrStoreName(),2);// 2			
			dao.setProcInValue(procIndex1, "itemCatg",vo.getStrItemCategoryCmb(),3);// 3
			dao.setProcInValue(procIndex1, "from_date", vo.getStrFromDate(),4);// 4
			dao.setProcInValue(procIndex1, "too_date", vo.getStrToDate(),5);// 5
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),6); // 6
			dao.setProcOutValue(procIndex1, "err", 1,7); // 1 for string return
														// //7
			// value
			dao.setProcOutValue(procIndex1, "resultset", 2,8); // 2 for object //8
			// execute procedure
			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			/*
			 * if (err == null) err = "";
			 */

			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");
				vo.setReturnItemWs(ws);

			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("OfflineReturnTransDAO.getIssueDetail() --> "
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
	 * This Method is Used to Insert data into following Table SSTT_ISSUE_DTL
	 * HSTT_ISSUE_DTL HSTT_ISSUE_ITEM_DTL
	 */

	public synchronized static void insert(OfflineReturnTransVO vo) {
		HisDAO dao = null;
		String strFuncName = "";
		int nFuncIndex = 0;
		int length = 0;
		// int index = 0;
		String strReturnNo = "";
		String[] temp = null;
		String[] strTemp = null;
		String proc_name1 = "";
		String proc_name = "";
		int procIndex = 0;
		int procIndex1 = 0;
		int batchLength = 0;
		int nProcIndex_U;

		String strProcName_U = "";
		HisUtil hisutil = null;

		try {
			dao = new HisDAO("MMS Transactions", "OfflineReturnTransDAO");
			proc_name1 = "{call PKG_MMS_DML.dml_offline_return_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // 19
			proc_name = "{call PKG_MMS_DML.dml_offline_return_item_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // 29
			strFuncName = "{? = call Mms_Mst.generate_indentno(?::numeric,?::numeric,?::numeric,?::numeric)}";
			nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrIndentingStoreID());
			dao.setFuncInValue(nFuncIndex, 3, "18");
			dao.setFuncInValue(nFuncIndex, 5, vo.getStrItemCategoryCmb());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strReturnNo = dao.getFuncString(nFuncIndex);
          
			vo.setStrReturnNo(strReturnNo);

			/***************************************************************/
			/*
			 * //System.out.println("Issue No:::"+strIssueNo);
			 * //System.out.println("Seat Id::"+vo.getStrSeatId());
			 * //System.out.println("Hosp Code::"+vo.getStrHospitalCode());
			 * //System.out.println("Fin End Yr::"+vo.getStrFinancialEndYear());
			 * System
			 * .out.println("Fin Start Yr::"+vo.getStrFinancialStartYear());
			 * //System.out.println("App By::"+vo.getStrApprovedBy());
			 * //System.out.println("Verify By::"+vo.getStrVerifiedByValues());
			 * //System.out.println("App Date::"+vo.getStrApprovedDate());
			 * //System.out.println("Verif Date::"+vo.getStrVerifiedDate());
			 * //System.out.println("Rec By::"+vo.getStrReceivedBy());
			 * //System.out.println("App Remarks::"+vo.getStrAprovedRemarks());
			 * //System.out.println("Store Id::"+vo.getStrStoreName());
			 * //System.out.println("Item Catg Cmb::"+vo.getStrItemCategoryCmb());
			 * System
			 * .out.println("Indenting Store::"+vo.getStrIndentingStoreID());
			 * //System.out.println("Indent Type::"+vo.getStrIndentType());
			 * //System.out.println("Indent Status::"+vo.getIsNormal());
			 * //System.out.println("Indent No:::"+vo.getStrIndentNo());
			 * //System.out.println("Indent Date::"+vo.getStrIndentDate());
			 */
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "modeval", "1",1); // 1
			dao.setProcInValue(procIndex1, "store_id", vo.getStrStoreName(),2); // 2
			dao.setProcInValue(procIndex1, "returnNo", strReturnNo,3); // 3
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),4); // 4
			dao.setProcInValue(procIndex1, "cat_No", vo.getStrItemCategoryCmb(),5); // 5
			dao.setProcInValue(procIndex1, "req_No", vo.getStrIndentNo(),6); // 6
			dao.setProcInValue(procIndex1, "req_Date", vo.getStrIndentDate(),7); // 7
			dao.setProcInValue(procIndex1, "reqStore_id",vo.getStrIndentingStoreID(),8); // 8
			dao.setProcInValue(procIndex1, "reqStatus", vo.getIsNormal(),9); // 9
			dao.setProcInValue(procIndex1, "appBy", vo.getStrApprovedBy(),10); // 10
			dao.setProcInValue(procIndex1, "verifyBy",vo.getStrVerifiedByValues(),11); // 11
			dao.setProcInValue(procIndex1, "appDate", vo.getStrApprovedDate(),12); // 12
			dao.setProcInValue(procIndex1, "verifyDate",vo.getStrVerifiedDate(),13); // 13
			dao.setProcInValue(procIndex1, "receivedBy", vo.getStrReceivedBy(),14); // 14
			dao.setProcInValue(procIndex1, "fin_start_date",vo.getStrFinancialStartYear(),15); // 15
			dao.setProcInValue(procIndex1, "fin_end_date",vo.getStrFinancialEndYear(),16); // 16
			dao.setProcInValue(procIndex1, "remarks", vo.getStrAprovedRemarks(),17); // 17
			dao.setProcInValue(procIndex1, "seatId", vo.getStrSeatId(),18); // 18
			dao.setProcOutValue(procIndex1, "err", 1,19); // 1 for string return
														// //19

			dao.execute(procIndex1, 1);

			procIndex = dao.setProcedure(proc_name);

			length = vo.getItemParamValue().length;
			// index = length-1;
			for (int i = 0; i < length; i++) 
			{			
				if(vo.getStrReturnQty()[i] != null && vo.getStrReturnQty()[i].length() > 0 && !vo.getStrReturnQty()[i].equals("0"))
				{	
	//				//System.out.println("Req Qty:::" + vo.getStrReqQty()[i]);
	//				//System.out.println("Issue Qty:::" + vo.getStrReturnQty()[i]);
	//				//System.out.println("Avl Qty::::" + vo.getStrAvlQty()[i]);
	
					temp = vo.getItemParamValue()[i].replace('#', '#').split("#");
	
					// //System.out.println("Display Value-->>>>"+temp[0]);
					// //System.out.println("Conversion  Value-->>>>"+temp[1]);
					// //System.out.println("User  Value-->>>>"+temp[2]);
	
					strTemp = temp[2].replace('^', '#').split("#");
	
//					 //System.out.println("GenricItemID-0->>"+strTemp[0]);
//					 //System.out.println("ItemID-1->>"+strTemp[1]);
//					 //System.out.println("ItemBrandID-2->>"+strTemp[2]);
//					 //System.out.println("GrpID-3->>"+strTemp[3]);
//					 //System.out.println("Sub_GrpID-4->>"+strTemp[4]);
//					 //System.out.println("Cosumble Flg-5->>"+strTemp[5]);
//					 //System.out.println("In Hand Qty-6->>"+strTemp[7]);
//					 //System.out.println("In Hand Qty Unit Id-7->>"+strTemp[8]);
//					 //System.out.println("Last Rate-8->>"+strTemp[33]);
//					 //System.out.println("Last Rate Unit Id-9->>"+strTemp[34]);
//					 //System.out.println("Inventory Unit Id-10->>"+strTemp[11]);
//					 //System.out.println("Last PO No-11->>"+strTemp[12]);
//					 //System.out.println("Last PO Date-12->>"+strTemp[13]);
//					 //System.out.println("Last Supplied By [Id]-13->>"+strTemp[14]);
//					 //System.out.println("Batch No-14->>"+strTemp[15]);
//					 //System.out.println("Expiry Date-15->>"+strTemp[16]);
//					 //System.out.println("Manufacture Date-16->>"+strTemp[18]);
//					 //System.out.println("Item Serial No-17->>"+strTemp[18]);
//					 //System.out.println("Prefix-18->>"+strTemp[27]);
//					 //System.out.println("Cost Parameter-19->>"+strTemp[28]);
//					 //System.out.println("Cost Unit [on individual item or on total cost]-20->>"+strTemp[11]);
//					 //System.out.println("Stock Status-21->>"+strTemp[32]);
//					 //System.out.println("Brand reserv Flag-24->>"+strTemp[35]);
	
					dao.setProcInValue(procIndex, "modeval", "1",1); // 1
					dao.setProcInValue(procIndex, "hosp_code",vo.getStrHospitalCode(),2); // 2
					dao.setProcInValue(procIndex, "store_id", vo.getStrStoreName(),3); // 3
					dao.setProcInValue(procIndex, "returnNo", strReturnNo,4); // 4
					dao.setProcInValue(procIndex, "reqStore_id",vo.getStrIndentingStoreID(),5); // 5
					dao.setProcInValue(procIndex, "req_Date", vo.getStrIndentDate(),6); // 6
					dao.setProcInValue(procIndex, "cat_No",	vo.getStrItemCategoryCmb(),7); // 7
					dao.setProcInValue(procIndex, "item_id", strTemp[0],8); // 8
					dao.setProcInValue(procIndex, "item_brand_id", strTemp[1],9); // 9
					dao.setProcInValue(procIndex, "batchSl_no", strTemp[15],10); // 10
					dao.setProcInValue(procIndex, "item_SlNo", strTemp[18],11); // 11
					dao.setProcInValue(procIndex, "stock_status_code", strTemp[32],12); // 12
					dao.setProcInValue(procIndex, "grp_id", strTemp[2],13); // 13
					dao.setProcInValue(procIndex, "subgroup_id", strTemp[3],14); // 14
					dao.setProcInValue(procIndex, "inhand_qty",	strTemp[7],15); // 15
					dao.setProcInValue(procIndex, "inhand_qty_unitid", strTemp[8],16); // 16
					dao.setProcInValue(procIndex, "req_qty", vo.getStrReqQty()[i],17); // 17
					dao.setProcInValue(procIndex, "return_qty",	vo.getStrReturnQty()[i],18); // 18
					dao.setProcInValue(procIndex, "unitid", strTemp[11],19); // 19
					dao.setProcInValue(procIndex, "manuf_date", strTemp[17],20); // 20
					dao.setProcInValue(procIndex, "expiry_date", strTemp[16],21); // 21
					dao.setProcInValue(procIndex, "rate", strTemp[33],22); // 22
					dao.setProcInValue(procIndex, "rate_unitid", strTemp[34],23); // 23    Rate Unit Save in Database
					dao.setProcInValue(procIndex, "comsumable_flag", strTemp[4],24); // 24
					//dao.setProcInValue(procIndex, "lstPONo", strTemp[12]); // 25
					//dao.setProcInValue(procIndex, "lstPODate", strTemp[13]); // 26
					
					if(!strTemp[12].equals("")||!strTemp[12].equals(" "))
					{	
					   dao.setProcInValue(procIndex, "lstPONo", strTemp[12],25); // 25
					}
					else
					{
						dao.setProcInValue(procIndex, "lstPONo", "NA",25); // 25	
					}	
					
					if(!strTemp[13].equals("")||!strTemp[13].equals(" "))
					{	
					   dao.setProcInValue(procIndex, "lstPODate", strTemp[13],26); // 26
					}
					else
					{
						dao.setProcInValue(procIndex, "lstPODate", "sysdate",26); // 26	
					}	
					
					dao.setProcInValue(procIndex, "lstRecDate", vo.getStrIndentDate(),27); // 27
					dao.setProcInValue(procIndex, "seatId", vo.getStrSeatId(),28); // 28
					dao.setProcOutValue(procIndex, "err", 1,29); // 1 for string return
																// //29
	
					dao.execute(procIndex, 1);
			  }

			}
			//Commented by Adil Wasi, Since it is not required in RAOl MMS Purchase
			/*strProcName_U = "{call pkg_mms_dml.proc_hstt_budget_dtl_oflinRetn(?,?,?,?,?,?,?,?,?)}"; // Total 9 Values
			
			nProcIndex_U = dao.setProcedure(strProcName_U);
																	
			dao.setProcInValue(nProcIndex_U, "p_mode", "1");    //1
			dao.setProcInValue(nProcIndex_U, "p_hstnum_store_id_from", vo.getStrStoreName());//2 
			dao.setProcInValue(nProcIndex_U, "p_hstnum_store_id_to", vo.getStrIndentingStoreID());//3 
			dao.setProcInValue(nProcIndex_U, "p_hstdt_finstart_date", vo.getStrFinancialStartYear());//4
			dao.setProcInValue(nProcIndex_U, "p_hstdt_finend_date",	vo.getStrFinancialEndYear()); //5
			dao.setProcInValue(nProcIndex_U, "p_gnum_hospital_code",	vo.getStrHospitalCode());//6
			dao.setProcInValue(nProcIndex_U, "p_gnum_isvalid", "1");//7
			dao.setProcInValue(nProcIndex_U, "p_total_cost", vo.getStrNewDemandFinalApproxAmt());//8
									
			// Default Value 

			dao.setProcOutValue(nProcIndex_U, "err", 1);//9

			dao.execute(nProcIndex_U,1);*/
			
			
			//synchronized (dao) {
				dao.fire();

			//}
			vo.setStrStoreName(vo.getStrStoreName());
			vo.setStrReturnNo(strReturnNo);
			vo.setStrIndentNo(vo.getStrIndentNo());
			vo.setStrIndentDate(vo.getStrIndentDate());
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgType("1");
			vo.setStrMsgString("OfflineReturnTransDAO.insert() --> "
					+ e.getMessage());
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

}
