package mms.transactions.dao;

import java.lang.reflect.Method;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
import mms.dao.DmlHsttLpReqItemDtlDAO;
import mms.dao.DmlHsttPatientDiagDtlDAO;
import mms.dao.DmlHsttPurIndentItemDtlDAO;
import mms.dao.DmlIndentDtlDAO;
import mms.transactions.vo.RequestForLPPatientVO;

public class RequestForLPPatientDAO {
	/*---------Method Not in Use------------*/

	/*
	 * public static void GetData(RequestForLPPatientVO vo) {
	 * 
	 * HisDAO daoObj = null;
	 * 
	 * WebRowSet ws = null; String strProcName = ""; int nProcIndex = 0; String
	 * strErr = "";
	 * 
	 * try {
	 * 
	 * daoObj = new HisDAO("mms", "RequestForLPPatientDAO");
	 * 
	 * strProcName = "{call pkg_mms_dml.dml_hstt_challan_dummy_dtl(?,?,?)}";
	 * nProcIndex = daoObj.setProcedure(strProcName);
	 * 
	 * daoObj.setProcInValue(nProcIndex, "modval", "1");
	 * daoObj.setProcOutValue(nProcIndex, "err", 1);
	 * daoObj.setProcOutValue(nProcIndex, "resultset", 2);
	 * 
	 * daoObj.executeProcedure(nProcIndex);
	 * 
	 * strErr = daoObj.getString(nProcIndex, "err");
	 * 
	 * if (strErr == null) strErr = "";
	 * 
	 * ws = daoObj.getWebRowSet(nProcIndex, "resultset"); if (strErr.equals(""))
	 * {
	 * 
	 * //vo.setStrDummyWs(ws);
	 * 
	 * } else { throw new Exception(strErr); }
	 * 
	 * } catch (Exception e) {
	 * 
	 * 
	 * vo.setStrMsgString("RequestForLPPatientDAO.GetData() --> " +
	 * e.getMessage()); vo.setStrMsgType("1");
	 * 
	 * } finally { if (daoObj != null) { daoObj.free(); daoObj = null; } }
	 * 
	 * }
	 */
	/**
	 * for getting Item category Combo by passing STORE_ID & HOSP_CODE
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void itemCategoryCombo(RequestForLPPatientVO vo) {
		String strProcName = "{call PKG_MMS_VIEW.proc_item_category_list(?,?,?,?,?,?)}";

		int nProcIndex = 0;
		String strErr = "";
		String str = "";
		HisUtil hisutil = null;
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try {
			System.out.println("<<------ RequestForLPPatientDAO.itemCategoryCombo        ------>>");
			System.out.println("<<------ PKG_MMS_VIEW.proc_item_category_list    [Mode - 1 ]    ------>>");
			
			hisutil = new HisUtil("master", "RequestForLPPatientDAO");
			daoObj = new HisDAO("Issue To Patient", "RequestForLPPatientDAO");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code",
					vo.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "reqType", "",4);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {
				if (ws != null && ws.size() != 0) {
					str = hisutil.getOptionValue(ws, "-1", "0^Select Value",
							true);
					vo.setStrItemCatgCombo(str);
				} else {
					str = "<option value='0'>DATA N/A</option>";
					vo.setStrItemCatgCombo(str);
				}
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("ReceiveFromThirdPartyTransDAO.itemCategoryCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * for getting option value of combo on add page (store type name )
	 * 
	 * @param vo
	 */
	public static void GetGroupNameCombo(RequestForLPPatientVO vo) {
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			System.out.println("<<------ RequestForLPPatientDAO.GetGroupNameCombo             ------>>");
			System.out.println("<<------ PKG_MMS_VIEW.proc_store_group_list    [Mode - 1 ]    ------>>");
			
			hisutil = new HisUtil("master", "RequestForLPPatientDAO");
			dao = new HisDAO("mms",
					"RequestForLPPatientDAO.GetGroupNameCombo(RequestForLPPatientVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "modeval", "1",1);

			dao.setProcInValue(procIndex1, "item_category",
					vo.getStrItemCategoryNo(),3);

			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(procIndex1, "strPhyStockNo", "",4);
			dao.setProcInValue(procIndex1, "strStoreId", "",5);

			dao.setProcOutValue(procIndex1, "ERR", 1,6); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2,7); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

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
			vo.setStrMsgString("RequestForLPPatientDAO.GetGroupNameCombo() --> "
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
	public static void callingFunctionStoreName(RequestForLPPatientVO vo) {
		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		try {
			dao = new HisDAO("MMSModule", "RequestForLPPatientDAO");
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
			vo.setStrMsgString("IndentDeskCondemnationReqTransDAO.callingFunctionStoreName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	public static void getPatientDepartmentDtls(RequestForLPPatientVO vo) 
	{
		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		try {
			dao = new HisDAO("MMSModule", "RequestForLPPatientDAO");
						
			funcIndex = dao
					.setFunction("{? = call MMS_MST.get_patient_department(?,?,?,?)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, "1");
			dao.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4, vo.getStrCrNo());
			dao.setFuncInValue(funcIndex, 5, vo.getStrStoreId());
			dao.setFuncOutValue(funcIndex, 1);
			// Execute Function
			dao.executeFunction(funcIndex);
			retVal = dao.getFuncString(funcIndex);
			if (retVal != null) 
			{
				vo.setStrPatientDepartmentDtls(retVal);
			} 
			else 
			{
				vo.setStrPatientDepartmentDtls("1$-");
			
			}

		} catch (Exception e) {
			vo.setStrMsgString("IndentDeskCondemnationReqTransDAO.callingFunctionStoreName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/*
	 * This Function is used to get Item Category Name by Passing 2 variable a)
	 * Hospital Code b) Item Category
	 */

	public static void callingItemCategory(RequestForLPPatientVO vo) {

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
			vo.setStrMsgString("IndentDeskCondemnationReqTransDAO.callingItemCategory() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * for getting option value of combo on add page (Grant Type Combo)
	 * 
	 * @param vo
	 */
	public static void GetGrantTypeCombo(RequestForLPPatientVO vo) {
		String err = "";
		String proc_name1 = "{call PKG_MMS_VIEW.proc_grant_list(?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			
			System.out.println("<<------ RequestForLPPatientDAO.GetGrantTypeCombo             ------>>");
			System.out.println("<<------ PKG_MMS_VIEW.proc_grant_list          [Mode - 1 ]    ------>>");
			
			hisutil = new HisUtil("master", "RequestForLPPatientDAO");
			dao = new HisDAO("mms",
					"RequestForLPPatientDAO.GetSoreNameCombo(RequestForLPPatientVO vo)");

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
				vo.setStrGrantTypeCombo(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrGrantTypeCombo(str);
			}
		} catch (Exception e) {
			vo.setStrMsgString("RequestForLPPatientDAO.GetGrantTypeCombo() --> "
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
	public static void GetRecommendByCombo(RequestForLPPatientVO vo) {
		String err = "";
		String proc_name1 = "{call PKG_MMS_VIEW.Proc_Consultant_Name(?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			
			System.out.println("<<------ RequestForLPPatientDAO.GetGrantTypeCombo             ------>>");
			System.out.println("<<------ PKG_MMS_VIEW.Proc_Consultant_Name     [Mode - 1 ]    ------>>");
			
			hisutil = new HisUtil("master", "RequestForLPPatientDAO");
			dao = new HisDAO("mms",
					"RequestForLPPatientDAO.GetSoreNameCombo(RequestForLPPatientVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "modeval", "1",1);

			dao.setProcInValue(procIndex1, "deptunitcode", "0",2);

			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),3);

			dao.setProcInValue(procIndex1, "seatId", vo.getStrSeatId(),4);

			dao.setProcOutValue(procIndex1, "err", 1,5); // 1 for string return

			dao.setProcOutValue(procIndex1, "resultset", 2,6); // 2 for object
			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

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
			vo.setStrMsgString("RequestForLPPatientDAO.GetRecommendByCombo() --> "
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
	public static WebRowSet GetItemCategoryCombo(RequestForLPPatientVO vo) {
		String err = "";
		String proc_name1 = "{call PKG_MMS_VIEW.proc_item_category_list(?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		try {
			// hisutil = new HisUtil("master", "RequestForLPPatientDAO");
			dao = new HisDAO("mms",
					"RequestForLPPatientDAO.GetSoreNameCombo(RequestForLPPatientVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "modeval", "1",1);

			dao.setProcInValue(procIndex1, "store_id", vo.getStrStoreId(),2); // Check
																			// It

			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),3);
			dao.setProcInValue(procIndex1, "reqType", "",4);

			dao.setProcOutValue(procIndex1, "err", 1,5); // 1 for string return

			dao.setProcOutValue(procIndex1, "resultset", 2,6); // 2 for object
			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "resultset");

		} catch (Exception e) {
			vo.setStrMsgString("RequestForLPPatientDAO.GetItemCategoryCombo() --> "
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
	public static void ToStoreCombo(RequestForLPPatientVO vo) {
		String err = "";
		String proc_name1 = "{call Pkg_Mms_View.proc_hstt_toStore_mst(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			
			//System.out.println("<<------ RequestForLPPatientDAO.ToStoreCombo             ------>>");
			//System.out.println("<<------ PKG_MMS_VIEW.proc_hstt_toStore_mst     [Mode - 1 ]    ------>>");
			
			
			hisutil = new HisUtil("master", "RequestForLPPatientDAO");
			dao = new HisDAO("mms",
					"RequestForLPPatientDAO.GetDeptCombo(RequestForLPPatientVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

			dao.setProcInValue(procIndex1, "modeval", "1",1);

			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),2);

			dao.setProcInValue(procIndex1, "storeid", vo.getStrStoreId(),3);

			dao.setProcInValue(procIndex1, "reqType", vo.getStrReqType(),4);

			dao.setProcInValue(procIndex1, "catCode", vo.getStrItemCategoryNo(),5);

			dao.setProcOutValue(procIndex1, "ERR", 1,6); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2,7); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");
			//;
			if (ws.next()) 
			{
				if(ws.size() == 1)
				{
				    str = hisutil.getOptionValue(ws,"",ws.getString(1)+"^"+ws.getString(2), true);
				}
				else
				{
					ws.beforeFirst();
				    str = hisutil.getOptionValue(ws, "0", "0^Select Value", true);
				}
				//System.out.println(" TO_Store_Cmb-->>"+str);
				
				vo.setStrToStoreCombo(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrToStoreCombo(str);
			}

		} catch (Exception e) {
			vo.setStrMsgString("RequestForLPPatientDAO.ToStoreCombo() --> "
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

	public static void INSERT_ORG(RequestForLPPatientVO vo) 
	{
		HisDAO dao = null;
		int procIndex1 = 0;
		String indentNo = "";
		String approvalFlg = "";
		DmlIndentDtlDAO globalDao = null;

		try {
			HisUtil util = new HisUtil("", "");

			String strCtDate = util.getASDate("dd-MMM-yyyy");
			globalDao = new DmlIndentDtlDAO();
			dao = new HisDAO("MMS",	"transactions.RequestForLPStaffDAO.INSERT()");
			
			System.out.println("<<------ RequestForLPPatientDAO.INSERT        ------>>");
			
			//int length = vo.getItemParamValue().length;
			
			 //Float totalCost=0.00F;

			/*
			 * vo.setStrStoreTypeId(strStoreTypeId);
			 * vo.setStrItemCategoryNo(strItemCategoryNo);
			 * vo.setStrReqType(strReqType);
			 * vo.setItemParamValue(formBean.getItemParamValue());
			 * vo.setStrUnitName(formBean.getStrUnitName());
			 * vo.setStrRemarks(formBean.getStrRemarks());
			 * vo.setStrReqQty(formBean.getStrReqQty());
			 */
			/*for (int i = 0; i < length; i++) {
			
				totalCost+=Float.parseFloat(vo.getItemParamValue()[i].replace('^', '@').split("@")[4])*(Integer.parseInt(vo.getStrReqQty()[i]));
			}
			*/
			/*if(Float.parseFloat(vo.getStrBalanceAmount()) < totalCost )
			{
				vo.setStrMsgType("5");
			}
			else
			{
            */
			globalDao.setStrId(vo.getStrStoreId());
			globalDao.setHosp_code(vo.getStrHospitalCode());
			globalDao.setReqTypeId(vo.getStrReqType());
			globalDao.setToStrId(vo.getStrToStoreCombo()); // Check
			globalDao.setItemcatNo(vo.getStrItemCategoryNo());
			globalDao.setItemTypeId("0"); // Check
			globalDao.setUrgentFlag(vo.getStrUrgentFlg());
			globalDao.setIndentPeriod("0"); // check

			globalDao.setFinStartDate(vo.getStrFinancialStartYear());//changed by shalini frm curr dt to financial start dt
			globalDao.setFinEndDate(vo.getStrFinancialEndYear());//changed by shalini frm curr dt to financial end dt
			globalDao.setRemarks(vo.getStrRemarks());
			globalDao.setSeatId(vo.getStrSeatId());

			globalDao.setGrantTypeId(vo.getStrGrantType());
			globalDao.setPuk(vo.getStrCrNo());
			globalDao.setEmpNo(vo.getStrEmpNo());
			globalDao.setAdmNo(vo.getStrAdmnNo());
			globalDao.setEpisodeCode("0");
			globalDao.setConsultantId("0");
			globalDao.setMemoNo("0");
			globalDao.setTotCost(vo.getStrApproxAmt());
			globalDao.setStrIsUtilityIndent(vo.getStrIsUtilityIndent());
			if(vo.getStrDiagCode() != null)
				globalDao.setStrDiagCode(vo.getStrDiagCode());
			else
				globalDao.setStrDiagCode("");
			if(vo.getStrEmpCode() != null)
				globalDao.setStrEmpCode(vo.getStrEmpCode());
			else
				globalDao.setStrEmpCode("");
			if(vo.getStrBSReqNo() != null && !vo.getStrBSReqNo().equals(""))
				globalDao.setStrBSReqNo(vo.getStrBSReqNo());
			procIndex1 = globalDao.insert(dao);

			synchronized (dao) {
				dao.fire(); // Here we Execute in Batch
			}
			indentNo = dao.getString(procIndex1, "indentNo");
			approvalFlg = dao.getString(procIndex1, "approvalFlg");
			 //System.out.println("Req Type Utility-->>"+vo.getStrReqType());
			 System.out.println("Indent No-->>"+indentNo);
			 System.out.println("Approval Flg-->>"+approvalFlg);
			if(vo.getStrReqType().equals("86"))
			{
				INSERTINTABLE1(vo, indentNo, approvalFlg);
			}
			else
			{
				INSERTINTABLE(vo, indentNo, approvalFlg);
			}
			
			
			String[] temp,strTemp;
			for (int i = 0; i < vo.getItemParamValue().length; i++) {
				if(!vo.getItemParamValue()[i].equals("-"))
				{
					temp = vo.getItemParamValue()[i].replace('#', '#').split("#");
				
				/*
				 * //System.out.println("Display Value-->>>>"+temp[0]);
				 * //System.out.println("Conversion  Value-->>>>"+temp[1]);
				 * //System.out.println("User  Value-->>>>"+temp[2]);
				 */
				strTemp = temp[2].replace('^', '#').split("#");
				
				String procnamee = "PKG_MMS_DML.DML_UPDATE_DRUG_DTL";
				int nInsertedIndex = 0;
				
				
				System.out.println("---J------"+procnamee+"---[ Mode -1 ]------");
				
				nInsertedIndex = dao.setProcedure("{call " + procnamee + "(?,?,?,?,? ,?)}");
				
				dao.setProcInValue(nInsertedIndex,"modval","1",1);                           
		       	dao.setProcInValue(nInsertedIndex,"hosp_code",vo.getStrHospitalCode(),2);           
				dao.setProcInValue(nInsertedIndex,"puk ",vo.getStrCrNo(),3);                                      
				dao.setProcInValue(nInsertedIndex,"admNo",vo.getStrAdmnNo(),4);  
				dao.setProcInValue(nInsertedIndex, "itembrandId",strTemp[1],5);
				dao.setProcOutValue(nInsertedIndex,"err",1,6);                               
				
				dao.executeProcedureByPosition(nInsertedIndex);
				
				}
			}
			
			System.out.println("<<------ RequestForLPPatientDAO.INSERT    END    ------>>");
				
			// used to update indent status(i.e. indent raised ) of  IPD patients for treatment detail given from IPD Doctor desk 
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> RequestForLPPatientDAO.INSERT()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}
	
	/**
	 * INSERT method is used to insert data in following table
	 * 
	 * @param vo
	 */

	public static void INSERT(RequestForLPPatientVO vo) 
	{
		HisDAO dao = null;
		int procIndex1 = 0;
		String indentNo = "";
		String approvalFlg = "";
		DmlIndentDtlDAO globalDao = null;
		
		String strProcName = "";
		int nProcIndex = 0;
		
		String strReqQty = "";
		String strSancQty = "";
		String strIndentNo = "",v_app_status="0";
		int funcIndex = 0,funcIndex1 = 0;
		
		
		String[] reqQtyUnit=null;
		
		
		String strReqUnit ="";		
		String strSancQtyUnit="";

		DmlHsttPurIndentItemDtlDAO tableDao = null;
		
		
		DmlHsttLpReqItemDtlDAO   tableDao2 = null;
		DmlHsttPatientDiagDtlDAO tableDao1 = null;

		try 
		{
			HisUtil util = new HisUtil("", "");

			String strCtDate = util.getASDate("dd-MMM-yyyy");
			
			dao = new HisDAO("MMS",	"transactions.RequestForLPPatientDAO.INSERT()");
			
			System.out.println("<<------ RequestForLPPatientDAO.INSERT        ------>>");
			
						
			System.out.println("<<------ Generate Indent No [ MMS_MST.GENERATE_INDENTNO ]   ------>>");
						
			funcIndex = dao.setFunction("{? = CALL MMS_MST.GENERATE_INDENTNO(?,?,?,?)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3, vo.getStrReqType());
			dao.setFuncInValue(funcIndex, 4, vo.getStrStoreId());
			dao.setFuncInValue(funcIndex, 5, vo.getStrItemCategoryNo());
			dao.setFuncOutValue(funcIndex, 1);
			// Execute Function
			dao.executeFunction(funcIndex);
			strIndentNo = dao.getFuncString(funcIndex);
			
			System.out.println("---------strIndentNo------"+strIndentNo);
			vo.setStrIndentNo(strIndentNo);
			
			
			System.out.println("<<------ Get Approval Status Details [ MMS_MST.get_approval_status ] ------>>");
			
			funcIndex1 = dao.setFunction("{? = CALL MMS_MST.get_approval_status(?,?,?,?,?  ,?,?,?,?,? )}");  // 10
			// Set Value
			dao.setFuncInValue(funcIndex1, 2, "2");
			dao.setFuncInValue(funcIndex1, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex1, 4, "1");			
			dao.setFuncInValue(funcIndex1, 5, vo.getStrReqType());
			dao.setFuncInValue(funcIndex1, 6, vo.getStrItemCategoryNo());
			dao.setFuncInValue(funcIndex1, 7, vo.getStrStoreId());
			dao.setFuncInValue(funcIndex1, 8, vo.getStrSeatId());
			dao.setFuncInValue(funcIndex1, 9, "0");
			dao.setFuncInValue(funcIndex1, 10, vo.getStrToStoreCombo());
			dao.setFuncInValue(funcIndex1, 11,  "1");
			dao.setFuncOutValue(funcIndex1, 1);
			// Execute Functions
			dao.executeFunction(funcIndex1);
			v_app_status = dao.getFuncString(funcIndex1);
			
			System.out.println("v_app_status   [ Mode ^ Status ]  ------>>"+v_app_status);  // 0 ^ 40 [ Mode ^ Status ]
			
			
			System.out.println("<<------ PKG_MMS_DML.DML_INDENT_NEW_DTL [ Mode = 1 ] ------>>");
						
            strProcName = "{call PKG_MMS_DML.DML_INDENT_NEW_DTL(?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?   ,?,?,?,?,?  ,?,?,?,?,?   ,?,?,?)}"; // 33
            
            nProcIndex  = dao.setProcedure(strProcName);		
			
			dao.setProcInValue(nProcIndex,"modval",			"1",1);  		
			dao.setProcInValue(nProcIndex,"indentNo",		vo.getStrIndentNo().trim(),2);
		   	dao.setProcInValue(nProcIndex,"strId",			vo.getStrStoreId().trim(),3);                  
	       	dao.setProcInValue(nProcIndex,"hosp_code",		vo.getStrHospitalCode().trim(),4);          
			dao.setProcInValue(nProcIndex,"reqTypeId ",		vo.getStrReqType().trim(),5);          
			dao.setProcInValue(nProcIndex,"toStrId",		vo.getStrToStoreCombo().trim(),6);              
			dao.setProcInValue(nProcIndex,"itemcatNo",		vo.getStrItemCategoryNo().trim(),7);           
			dao.setProcInValue(nProcIndex,"itemTypeId",		"0",8);   			
			dao.setProcInValue(nProcIndex,"urgentFlag",		vo.getStrUrgentFlg().trim(),9);
			
			dao.setProcInValue(nProcIndex,"indentPeriod",	"0",10);     
			dao.setProcInValue(nProcIndex,"finStartDate",	vo.getStrFinancialStartYear().trim(),11);         
			dao.setProcInValue(nProcIndex,"finEndDate",		vo.getStrFinancialEndYear().trim(),12);         
			dao.setProcInValue(nProcIndex,"remarks",		vo.getStrRemarks().trim(),13);   
			
			dao.setProcInValue(nProcIndex,"seatId",			vo.getStrSeatId().trim(),14);                 
			dao.setProcInValue(nProcIndex,"grantTypeId",	vo.getStrGrantType().trim(),15);       
			dao.setProcInValue(nProcIndex,"puk ",			vo.getStrCrNo().trim(),16);                       
			dao.setProcInValue(nProcIndex,"empNo",			vo.getStrEmpNo().trim(),17);                   
			dao.setProcInValue(nProcIndex,"admNo",			vo.getStrAdmnNo().trim(),18); 			
			dao.setProcInValue(nProcIndex,"episodeCode",	"0",19);       
			dao.setProcInValue(nProcIndex,"consultantId",	"0",20);     
			dao.setProcInValue(nProcIndex,"memoNo",			"0",21);          
			dao.setProcInValue(nProcIndex,"totCost", 		vo.getStrApproxAmt().trim(),22); 			
			dao.setProcInValue(nProcIndex,"indentPeriodValue", "0",23); 			
			dao.setProcInValue(nProcIndex,"cancelSeatId", 	"",24);
			dao.setProcInValue(nProcIndex,"cancelDate", 	"",25);
			dao.setProcInValue(nProcIndex,"cancelReason", 	"",26);			
			dao.setProcInValue(nProcIndex,"certificateNo", 	"0",27);
			dao.setProcInValue(nProcIndex,"certificateDate","",28);
			dao.setProcInValue(nProcIndex,"rateContSuppId", "0",29);
			dao.setProcInValue(nProcIndex, "bsReqNo", 		"0",30);			  	
			dao.setProcInValue(nProcIndex, "appStatus",     v_app_status.split("\\^")[1],31);
			dao.setProcInValue(nProcIndex, "appMode",       v_app_status.split("\\^")[0],32);
			dao.setProcOutValue(nProcIndex,"err",			 1 ,33); 
			dao.execute(nProcIndex, 1);
									
			
			if(vo.getStrReqType().equals("86"))
			{
				String[] temp = null;
				
				String[] strTemp = null;
				
				System.out.println("<<------ Req Type 86   Insert Into Hstt_Pur_Indent_Item_Dtl  --[ Drug Finder Dtls ]---->>");
				
				tableDao  = new DmlHsttPurIndentItemDtlDAO();
				
				int length = vo.getItemParamValue().length;
				
	 			for(int i = 0;i<length;i++)
				{
			    				
					temp            = vo.getItemParamValue()[i].replace('#', '#').split("#");					
					strTemp         = temp[2].replace('^', '#').split("#");
					
					
					 strReqQty      = vo.getStrReqQty()[i];
					 strReqUnit     = vo.getStrUnitName()[i];
		    	     reqQtyUnit     = strReqUnit.split("\\^");		    	    
		    	     
		    	     if (v_app_status.split("\\^")[0].equals("0")) 
		    	     {
							strSancQty = strReqQty;
							strSancQtyUnit = reqQtyUnit[0];
					 } else 
					 {
							strSancQty = "0";
							strSancQtyUnit = "0";
					 }
		    	     
		    	     System.out.println("<<------ Item Id      ------>>"+strTemp[0]);
		    	     System.out.println("<<------ Brand Id     ------>>"+strTemp[1]);
				     	  		    
					 tableDao.setStrId(vo.getStrStoreId());
					 tableDao.setStrReqNo(vo.getStrIndentNo());
					 tableDao.setItemId(strTemp[0]);
					 tableDao.setItemBrandId(strTemp[1]);
					 tableDao.setHosp_code(vo.getStrHospitalCode());
					 tableDao.setStrPurchseReqDate(strCtDate);
					 tableDao.setGroupId(strTemp[2]);
					 tableDao.setSubGroupId(strTemp[3]);
					 tableDao.setRate(strTemp[9]);
					 tableDao.setRateUnitId(strTemp[10]);
					 tableDao.setIndentQty(strReqQty);
					 tableDao.setIndentQtyUnitId(reqQtyUnit[0]);
					 tableDao.setSancQty(strSancQty);
					 tableDao.setSancQtyUnitId(strSancQtyUnit);
					 tableDao.setInHandQty(strTemp[7]);
					 tableDao.setInHandQtyUnitId(strTemp[8]);
					 tableDao.setReOrderLevel(strTemp[5]);
					 tableDao.setReOrderUnitId(strTemp[6]);
					 tableDao.setManufacturerId("0");
					 tableDao.setApproxRate(strTemp[9]);
					 tableDao.setApproxRateUnitId(strTemp[10]);
					 tableDao.setLstYearConsumption(strTemp[25]);
					 tableDao.setLstYearConsumptionUnitId(strTemp[26]);
					 tableDao.setStrJustification("0");
					 tableDao.setRemarks(vo.getStrRemarks());
					 tableDao.setIsValid("1");
					 tableDao.setStrLstPoNo(strTemp[12]); 
					 tableDao.setStrLstPoDate(strTemp[13]);
					 tableDao.setStrLstRecQty(strTemp[23]);
					 tableDao.setStrLstRecQtyUnitId(strTemp[24]);
					 tableDao.setStrLstRecDate("");   // Plz Check It....Dummy Value
					 tableDao.setStrLstSupplierId(strTemp[14]); 
					 
					 
						Class tempCls=tableDao.getClass();
						Method[] allMethods=tempCls.getMethods();
						//System.out.println("---------------------------------------------------------------------------------------------------------------------------");
						for(int j=0;j<allMethods.length;j++)
						{
							if(allMethods[j].getName().matches("get(.*)"))
							{
								//allMethods[j].setAccessible(true);
								
								//System.out.println(allMethods[j].getName()+"----------------> "+allMethods[j].invoke(tableDao));
								
							}
						}
						//System.out.println("---------------------------------------------------------------------------------------------------------------------------");
						
					 		 
					 tableDao.insert(dao);  // PKG_MMS_DML.Dml_Hstt_Pur_Indent_Item_Dtl [ Mode - 1 ]
						
		          }
			}
			else
			{
				String[] temp = null;
				
				String[] strTemp = null;
				
				tableDao2 = new DmlHsttLpReqItemDtlDAO();
				tableDao1 = new DmlHsttPatientDiagDtlDAO();
				
				int length = vo.getItemParamValue().length;
				
				System.out.println("<<------ B Insert Into HSTT_LP_REQ_ITEM_DTL  --[ IPD Drug Dtls ]---->>");

				for (int i = 0; i < length; i++) 
				{
					if(!vo.getItemParamValue()[i].equals("-"))
					{
						 System.out.println("<<------ paramvalue ---"+i+"--->>"+vo.getItemParamValue()[i]);
						 
						temp = vo.getItemParamValue()[i].replace('#', '#').split("#");
					
					
					    strTemp = temp[2].replace('^', '#').split("#");
					
						strReqQty = vo.getStrReqQty()[i];
						strReqUnit = vo.getStrUnitName()[i];
						reqQtyUnit = strReqUnit.split("\\^");
	
						
						 if (v_app_status.split("\\^")[0].equals("0")) 
			    	     {
								strSancQty = strReqQty;
								strSancQtyUnit = reqQtyUnit[0];
						 } else 
						 {
								strSancQty = "0";
								strSancQtyUnit = "0";
						 }
						 
						 System.out.println("<<--B---- Item Id      ------>>"+strTemp[0]);
			    	     System.out.println("<<--B---- Brand Id     ------>>"+strTemp[1]);
						
						tableDao2.setStrLpReqNo(vo.getStrIndentNo());
						tableDao2.setStrId(vo.getStrStoreId());
						tableDao2.setHosp_code(vo.getStrHospitalCode());
						tableDao2.setStrLpReqDate(strCtDate);
						tableDao2.setGroupId(strTemp[2]);
						tableDao2.setSubGroupId(strTemp[3]);
						tableDao2.setItemId(strTemp[0]);
						tableDao2.setItemBrandId(strTemp[1]);
						tableDao2.setRate(strTemp[9]);
						tableDao2.setRateUnitId(strTemp[10]);
						tableDao2.setReqQty(strReqQty);
						tableDao2.setReqQtyUnitId(reqQtyUnit[0]);
						tableDao2.setSancQty(strSancQty);
						tableDao2.setSancQtyUnitId(strSancQtyUnit);
						tableDao2.setIssueQty("0");
						tableDao2.setIssueQtyUnitId("0");
						tableDao2.setReturnQty("0");
						tableDao2.setReturnQtyUnitId("0");
						tableDao2.setRemarks(vo.getStrRemarks());
						tableDao2.setIsValid("1");
						tableDao2.setInHandQty(strTemp[7]);
						tableDao2.setInHandQtyUnitId(strTemp[8]);
						tableDao2.setLstRecvQty(strTemp[23]);
						tableDao2.setLstRecvQtyUnitId(strTemp[24]);
						tableDao2.setStrLstRecDate("");
	
						tableDao2.insert(dao); // PKG_MMS_DML.DML_HSTT_LP_REQ_ITEM_DTL [ Mode - 1 ]
					}

				}
					int l = vo.getStrProvisionDiagnosis().length;
					int k = 1;
					if(l==1 && vo.getStrProvisionDiagnosis()[0]!=null && "".equals(vo.getStrProvisionDiagnosis()[0].trim())) 
					{
						// Nothing to insert in patient diagnosis detail table. 
					}else {
					
						
						for (int j = 0; j < l; j++) 
						{
							tableDao1.setStrDiagnosisCode(vo.getStrProvisionDiagnosis()[j]);
							tableDao1.setStrDiagnosisType("11");
							tableDao1.setStrHospCode(vo.getStrHospitalCode());
							tableDao1.setStrLpReqNo(vo.getStrIndentNo());
							tableDao1.setStrPukNo(vo.getStrCrNo());
							tableDao1.setStrSlNo(String.valueOf(k));
							tableDao1.setStrStoreId(vo.getStrStoreId());
							k++;
							tableDao1.insert(dao); // PKG_MMS_DML.Dml_Hstt_Patient_Diagnosis_Dtl [ Mode - 1 ]
	
						}
						
					}
			}
			
			
			dao.fire(); // Here we Execute in Batch
			
			String[] temp2,strTemp2;
			for (int i = 0; i < vo.getItemParamValue().length; i++) 
			{
				if(!vo.getItemParamValue()[i].equals("-"))
				{
					temp2 = vo.getItemParamValue()[i].replace('#', '#').split("#");
				
				
				strTemp2 = temp2[2].replace('^', '#').split("#");
				
				String procnamee = "PKG_MMS_DML.DML_UPDATE_DRUG_DTL";
				int nInsertedIndex = 0;
				
				
				System.out.println("---J------"+procnamee+"---[ Mode -1 ]------");
				
				nInsertedIndex = dao.setProcedure("{call  PKG_MMS_DML.DML_UPDATE_DRUG_DTL (?,?,?,?,? ,?)}");
				
				dao.setProcInValue(nInsertedIndex,"modval","1",1);                           
		       	dao.setProcInValue(nInsertedIndex,"hosp_code",vo.getStrHospitalCode(),2);           
				dao.setProcInValue(nInsertedIndex,"puk ",vo.getStrCrNo(),3);                                      
				dao.setProcInValue(nInsertedIndex,"admNo",vo.getStrAdmnNo(),4);  
				dao.setProcInValue(nInsertedIndex, "itembrandId",strTemp2[1],5);
				dao.setProcOutValue(nInsertedIndex,"err",1,6);                               
				
				dao.executeProcedureByPosition(nInsertedIndex);
				
				}
			}
			
			
			
			System.out.println("<<------ RequestForLPPatientDAO.INSERT    END   [Indent No "+vo.getStrIndentNo()+"] ------>>");
				
			// used to update indent status(i.e. indent raised ) of  IPD patients for treatment detail given from IPD Doctor desk 
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> RequestForLPPatientDAO.INSERT()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}


	public static void INSERTINTABLE(RequestForLPPatientVO vo, String indentNo,
			String approvalFlg) {
		HisDAO dao = null;
		String[] temp = null;
		String[] strTemp = null;
		String[] reqQtyUnit = null;
		String strReqQty = "";
		String strReqUnit = "";
		String strSancQty = "";
		String strSancQtyUnit = "";
		DmlHsttLpReqItemDtlDAO tableDao = null;
		DmlHsttPatientDiagDtlDAO tableDao1 = null;
		try {
			System.out.println("<<------  RequestForLPPatientDAO.INSERTINTABLE     ------>>");
			HisUtil util = new HisUtil("", "");

			String strCtDate = util.getASDate("dd-MMM-yyyy");
			// Createing Object for Table Specific DAO
			tableDao = new DmlHsttLpReqItemDtlDAO();
			tableDao1 = new DmlHsttPatientDiagDtlDAO();
			dao = new HisDAO("MMS",
					"transactions.RequestForLPStaffDAO.INSERT()");
			int length = vo.getItemParamValue().length;

			for (int i = 0; i < length; i++) 
			{
				if(!vo.getItemParamValue()[i].equals("-"))
				{
					temp = vo.getItemParamValue()[i].replace('#', '#').split("#");
				
				/*
				 * //System.out.println("Display Value-->>>>"+temp[0]);
				 * //System.out.println("Conversion  Value-->>>>"+temp[1]);
				 * //System.out.println("User  Value-->>>>"+temp[2]);
				 */
				strTemp = temp[2].replace('^', '#').split("#");
				/*
				 * //System.out.println("ItemID-1->>"+strTemp[0]);
				 * //System.out.println("ItemBrandID-2->>"+strTemp[1]);
				 * //System.out.println("GrpID-3->>"+strTemp[2]);
				 * //System.out.println("Sub_GrpID-4->>"+strTemp[3]);
				 * //System.out.println("Cosumble Flg-5->>"+strTemp[4]);
				 * //System.out.println("Re-Order Qty-6->>"+strTemp[5]);
				 * //System.out.println("Re-Order Qty unit Id-7->>"+strTemp[6]);
				 * //System.out.println("In Hand Qty-8->>"+strTemp[7]);
				 * //System.out.println("In Hand Qty Unit Id-9->>"+strTemp[8]);
				 * //System.out.println("Last Rate-10->>"+strTemp[9]);
				 * //System.out.println("Last Rate Unit Id-11->>"+strTemp[10]);
				 * 
				 * 
				 * //System.out.println("Inventory Unit Id-12->>"+strTemp[11]);
				 * //System.out.println("Last PO No-13->>"+strTemp[12]);
				 * //System.out.println("Last PO Date-14->>"+strTemp[13]);
				 * System.out
				 * .println("Last Supplied By [Id]-15->>"+strTemp[14]);
				 * //System.out.println("Batch No-16->>"+strTemp[15]);
				 * //System.out.println("Expiry Date-17->>"+strTemp[16]);
				 * //System.out.println("Manufacture Date-18->>"+strTemp[17]);
				 * //System.out.println("Item Serial No-19->>"+strTemp[18]);
				 * System
				 * .out.println("Last Received Qty [PO]-20->>"+strTemp[19]);
				 * System
				 * .out.println("Last Received Qty Unit Id [PO]-21->>"+strTemp
				 * [20]);
				 * 
				 * //System.out.println("Last Indented Qty-22->>"+strTemp[21]);
				 * System
				 * .out.println("Last Indented Qty Unit Id-23->>"+strTemp[22]);
				 * //System.out.println("Last Received Qty-24->>"+strTemp[23]);
				 * System
				 * .out.println("Last Received Qty Unit Id-25->>"+strTemp[24]);
				 * System
				 * .out.println("Last Year Consumption Qty-26->>"+strTemp[25]);
				 * System
				 * .out.println("Last Year Consumption Qty Unit Id-27->>"+strTemp
				 * [26]); //System.out.println("Prefix-28->>"+strTemp[27]);
				 * //System.out.println("Cost Parameter-29->>"+strTemp[28]);
				 * //System.out.println(
				 * "Cost Unit [on individual item or on total cost]-30->>"
				 * +strTemp[29]);
				 * //System.out.println("Purchase Lead Time-31->>"+strTemp[30]);
				 * 
				 * //System.out.println("Purchase Lead Time Unit-32->>"+strTemp[31]
				 * ); //System.out.println("Stock Status-33->>"+strTemp[32]);
				 */
				strReqQty = vo.getStrReqQty()[i];
				strReqUnit = vo.getStrUnitName()[i];
				reqQtyUnit = strReqUnit.split("\\^");

				if (approvalFlg.equals("0")) {
					strSancQty = strReqQty;
					strSancQtyUnit = reqQtyUnit[0];
				} else {
					strSancQty = "0";
					strSancQtyUnit = "0";
				}
				// //System.out.println("indent No-in LP Patient..->>>"+indentNo);
				// //System.out.println("Store ID LP Patient.....--->>>"+vo.getStrStoreId());
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
				tableDao.setSancQtyUnitId(strSancQtyUnit);
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

				tableDao.insert(dao); // PKG_MMS_DML.DML_HSTT_LP_REQ_ITEM_DTL [ Mode - 1 ]
				}

			}
			int l = vo.getStrProvisionDiagnosis().length;
			int k = 1;
			if(l==1 && vo.getStrProvisionDiagnosis()[0]!=null && "".equals(vo.getStrProvisionDiagnosis()[0].trim())) {
				// Nothing to insert in patient diagnosis detail table. 
			}else {
			
				/* If l==0, loop will not iterate. */
				for (int j = 0; j < l; j++) {
					tableDao1.setStrDiagnosisCode(vo.getStrProvisionDiagnosis()[j]);
					tableDao1.setStrDiagnosisType("11");
					tableDao1.setStrHospCode(vo.getStrHospitalCode());
					tableDao1.setStrLpReqNo(indentNo);
					tableDao1.setStrPukNo(vo.getStrCrNo());
					tableDao1.setStrSlNo(String.valueOf(k));
					tableDao1.setStrStoreId(vo.getStrStoreId());
					k++;
					tableDao1.insert(dao);

				}
				
			}
			

			synchronized (dao) {
				dao.fire(); // Here we Execute in Batch
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> RequestForLPPatientDAO.INSERT()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}

	/**
	 * This combo is used to set initial details for Hospital diagnosis detail
	 * combo
	 * 
	 * @param voObj
	 */
	public static void getHospitalDiagnosisDtl(RequestForLPPatientVO voObj) {

		String strProcName = "{call pkg_simple_view.proc_diagnosis_hosiptal_list(?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		HisDAO daoObj = null;
		WebRowSet ws = null;

		try {
			System.out.println("<<------ RequestForLPPatientDAO.getHospitalDiagnosisDtl             ------>>");
			System.out.println("<<------ PKG_MMS_VIEW.proc_diagnosis_hosiptal_list     [Mode - 1 ]    ------>>");
			
			daoObj = new HisDAO("Admission Advice Trans",
					"DAORequestForLPPatient");

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex,"searchmode","",1);
			daoObj.setProcInValue(nProcIndex,"searchstr","",2);
			daoObj.setProcInValue(nProcIndex, "hosp_code",
					voObj.getStrHospitalCode(),3);
			daoObj.setProcOutValue(nProcIndex, "err", 1,4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,5);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setHospitalDiagnosisWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("RequestForLPPatientDAO.getHospitalDiagnosisDtl() --> "
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
	 * 
	 * @param voObj
	 */
	/*
	 * public static void getIcd10DiagnosisDtl(RequestForLPPatientVO voObj) {
	 * 
	 * String strProcName =
	 * "{call pkg_simple_view.proc_diagnosis_icd10_list(?,?)}"; int nProcIndex =
	 * 0;
	 * 
	 * String strErr = "";
	 * 
	 * HisDAO daoObj = null; WebRowSet ws = null;
	 * 
	 * try { daoObj = new HisDAO("Admission Advice Trans",
	 * "DAORequestForLPPatient");
	 * 
	 * nProcIndex = daoObj.setProcedure(strProcName);
	 * 
	 * daoObj.setProcOutValue(nProcIndex, "err", 1);
	 * daoObj.setProcOutValue(nProcIndex, "resultset", 2);
	 * 
	 * daoObj.executeProcedureByPosition(nProcIndex);
	 * 
	 * strErr = daoObj.getString(nProcIndex, "err");
	 * 
	 * if (strErr == null) strErr = "";
	 * 
	 * ws = daoObj.getWebRowSet(nProcIndex, "resultset");
	 * 
	 * if (strErr.equals("")) {
	 * 
	 * voObj.setIcd10DiagnosisWs(ws);
	 * 
	 * } else { throw new Exception(strErr); }
	 * 
	 * } catch (Exception e) {
	 * 
	 * voObj
	 * .setStrMsgString("RequestForLPPatientDAO.getIcd10DiagnosisDtl() --> " +
	 * e.getMessage()); voObj.setStrMsgType("1");
	 * 
	 * } finally { if (daoObj != null) { daoObj.free(); daoObj = null; } } }
	 */

	/**
	 * 
	 * @param voObj
	 */
	public static void getIcd10DiagnosisDtl(RequestForLPPatientVO voObj) {

		String strProcName = "{call pkg_simple_view.Proc_Diagnosis_Icd10_List(?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		HisDAO daoObj = null;
		WebRowSet ws = null;

		try {
			
			System.out.println("<<------ RequestForLPPatientDAO.getIcd10DiagnosisDtl             ------>>");
			System.out.println("<<------ PKG_MMS_VIEW.Proc_Diagnosis_Icd10_List     [Mode - 1 ]    ------>>");
			
			
			daoObj = new HisDAO("Admission Advice Trans",
					"DAOAdmissionAdviceTrans");

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "searchmode",
					voObj.getStrSearchMode(),1);
			daoObj.setProcInValue(nProcIndex, "searchstr",
					voObj.getStrSearchString(),2);
			daoObj.setProcOutValue(nProcIndex, "err", 1,3);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,4);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setIcd10DiagnosisWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("AdmissionAdviceTransDAO.getIcd10DiagnosisDtl() --> "
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
	 * 
	 * @param voObj
	 */
	public static void getPatientTreatmentDetailfrmIpd(RequestForLPPatientVO voObj) {			//added by shalini to get treatment detail given at IPD Doctor Desk

		String strErr = "";

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_IssueItem_Dtl(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	

		try {
			
			System.out.println("<<------ RequestForLPPatientDAO.getPatientTreatmentDetailfrmIpd             ------>>");
			System.out.println("<<------ PKG_MMS_VIEW.Proc_IssueItem_Dtl     [Mode - 2 ]    ------>>");

			daoObj = new HisDAO("MMS Transactions","IssueTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "reqNo", voObj.getStrItemCategoryNo(),3);
			daoObj.setProcInValue(nProcIndex, "crNo", voObj.getStrCrNo(),4);
			daoObj.setProcInValue(nProcIndex, "strId", voObj.getStrStoreId(),5);
			daoObj.setProcOutValue(nProcIndex, "err", 1,6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);

			daoObj.executeProcedureByPosition(nProcIndex);
	

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setTreatmentDetailWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("AdmissionAdviceTransDAO.getIcd10DiagnosisDtl() --> "
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
	 * 
	 * @param voObj
	 */
	public static void getUnitCombo(RequestForLPPatientVO voObj) {			

			String err = "";

			String strModeVal = "1";

			//if(vo.getStrUnitMode().equals("1")) strModeVal = "3";
			
			String proc_name1 = "{call pkg_mms_view.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";  //5+1=6

			int procIndex1 = 0;
			HisDAO dao = null;
			WebRowSet ws = null;

			try {

				dao = new HisDAO("mms", "requestforlppatientDAO.getUnitList(RequestForLPPatientVO vo)");

				procIndex1 = dao.setProcedure(proc_name1);

				// set value
				////System.out.println("Mode Value:::"+strModeVal);
				////System.out.println("Unit:::"+vo.getStrUnitId());
				
				dao.setProcInValue(procIndex1, "modeval", "2",4);
				dao.setProcInValue(procIndex1, "unit_id", "0",2);
				dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospitalCode(),1);

				dao.setProcOutValue(procIndex1, "err", 1,5); // 1 for string return
				// value

				dao.setProcOutValue(procIndex1, "resultset", 2,6); // 2 for object

				/* Start Adding Default value*/
				dao.setProcInValue(procIndex1, "module_id", "63",3);
				/* End Adding Default value*/
				// execute procedure

				dao.executeProcedureByPosition(procIndex1);

				// get value
				err = dao.getString(procIndex1, "err");

				if (err == null)
					err = "";

				ws = dao.getWebRowSet(procIndex1, "resultset");

				voObj.setUnitWs(ws);

			} catch (Exception e) {

				voObj.setStrMsgString("MmsDAO.getUnitList() --> " + e.getMessage());
				voObj.setStrMsgType("1");

			} finally {

				if (dao != null) {
					dao.free();
					dao = null;
				}

			}

		
	}
	
	public synchronized static void INSERTINTABLE1(RequestForLPPatientVO vo,String indentNo,String approvalFlg) //added by shalini to insert data for buy n supply indent
	{
		HisDAO dao = null;
		HisUtil hisutil = null;
		String[] temp = null;
	
		String[] strTemp = null;
		String[] reqQtyUnit=null;
		
		String strReqQty  = "";
		String strReqUnit ="";
		String strSancQty ="";
		String strSancQtyUnit="";

		DmlHsttPurIndentItemDtlDAO tableDao = null;
		
		
		try 
		{
			System.out.println("<<------  RequestForLPPatientDAO.INSERTINTABLE1     ------>>");
			
			// Createing Object for Table Specific DAO
			tableDao  = new DmlHsttPurIndentItemDtlDAO();
            hisutil = new HisUtil("","");
			String strCtDate = hisutil.getASDate("dd-MMM-yyyy"); 
    		dao = new HisDAO("MMS","transactions.AnnualPurchaseIndentDAO.INSERT()");
        		
 			int length = vo.getItemParamValue().length;
			
 			for(int i = 0;i<length;i++)
			{
		    				
				temp  = vo.getItemParamValue()[i].replace('#', '#').split("#");
				/*
				////System.out.println("Display Value-->>>>"+temp[0]);
				////System.out.println("Conversion  Value-->>>>"+temp[1]);
				////System.out.println("User  Value-->>>>"+temp[2]);
			    */
				strTemp         = temp[2].replace('^', '#').split("#");
				
				
				 strReqQty      = vo.getStrReqQty()[i];
				 strReqUnit     = vo.getStrUnitName()[i];
	    	     reqQtyUnit = strReqUnit.split("\\^");
	    	     ////System.out.println("strReqQty-->>"+strReqQty);
	    	     ////System.out.println("reqQtyUnit[0]-->>"+reqQtyUnit[0]);
			     if(approvalFlg.equals("0"))
			     {
			    	  strSancQty     = strReqQty;
			 		  strSancQtyUnit = reqQtyUnit[0];
			     }	
			     else
			     {
			    	 strSancQty     = "0";
			    	 strSancQtyUnit = "0";
			     }	  		    	 

				
				// ////System.out.println("indent Anual Purchase No-in 2..->>>"+indentNo);
				 //////System.out.println("Store ID 2.....--->>>"+vo.getStrStoreId());
				 
				 tableDao.setStrId(vo.getStrStoreId());
				 tableDao.setStrReqNo(indentNo);
				 tableDao.setItemId(strTemp[0]);
				 tableDao.setItemBrandId(strTemp[1]);
				 tableDao.setHosp_code(vo.getStrHospitalCode());
				 tableDao.setStrPurchseReqDate(strCtDate);
				 tableDao.setGroupId(strTemp[2]);
				 tableDao.setSubGroupId(strTemp[3]);
				 tableDao.setRate(strTemp[9]);
				 tableDao.setRateUnitId(strTemp[10]);
				 tableDao.setIndentQty(strReqQty);
				 tableDao.setIndentQtyUnitId(reqQtyUnit[0]);
				 tableDao.setSancQty(strSancQty);
				 tableDao.setSancQtyUnitId(strSancQtyUnit);
				 tableDao.setInHandQty(strTemp[7]);
				 tableDao.setInHandQtyUnitId(strTemp[8]);
				 tableDao.setReOrderLevel(strTemp[5]);
				 tableDao.setReOrderUnitId(strTemp[6]);
				 tableDao.setManufacturerId("0");
				 tableDao.setApproxRate(strTemp[9]);
				 tableDao.setApproxRateUnitId(strTemp[10]);
				 tableDao.setLstYearConsumption(strTemp[25]);
				 tableDao.setLstYearConsumptionUnitId(strTemp[26]);
				 tableDao.setStrJustification("0");
				 tableDao.setRemarks(vo.getStrRemarks());
				 tableDao.setIsValid("1");
				 tableDao.setStrLstPoNo(strTemp[12]); 
				 tableDao.setStrLstPoDate(strTemp[13]);
				 tableDao.setStrLstRecQty(strTemp[23]);
				 tableDao.setStrLstRecQtyUnitId(strTemp[24]);
				 tableDao.setStrLstRecDate("");   // Plz Check It....Dummy Value
				 tableDao.setStrLstSupplierId(strTemp[14]); 
				 
				 
					Class tempCls=tableDao.getClass();
					Method[] allMethods=tempCls.getMethods();
					//System.out.println("---------------------------------------------------------------------------------------------------------------------------");
					for(int j=0;j<allMethods.length;j++)
					{
						if(allMethods[j].getName().matches("get(.*)"))
						{
							//allMethods[j].setAccessible(true);
							
							//System.out.println(allMethods[j].getName()+"----------------> "+allMethods[j].invoke(tableDao));
							
						}
					}
					//System.out.println("---------------------------------------------------------------------------------------------------------------------------");
					
				 		 
				 tableDao.insert(dao);  // PKG_MMS_DML.Dml_Hstt_Pur_Indent_Item_Dtl [ Mode - 1 ]
					
	          }
 			
 			dao.fire();     // Here we Execute in Batch
 			vo.setStrBSReqNo(indentNo);
		    
		} 
	 
	catch (Exception e) 
	{
		e.printStackTrace();
		vo.setStrMsgString("--> LPDAO.INSERTINTABLE1()-->"
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

	
	/*Used To get the Account balance.*/
	public static void getPatientAccountBalance(RequestForLPPatientVO vo) {

	
		String strProcName = "{call PKG_MMS_VIEW.proc_hstt_pat_account_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		int funcIndex;
		String BillingValue="0^0^0";
		WebRowSet ws = null;
		HisDAO daoObj = null;
		try {
			daoObj = new HisDAO("MMSModule", "LPIssueDeskTransDAO");


			funcIndex = daoObj.setFunction("{? = call bill_mst.get_pat_accountdetails_limit(?,?,?)}");
			
			System.out.println("<<------ RequestForLPPatientDAO.getPatientAccountBalance           ------>>");
			System.out.println("<<------ PKG_MMS_VIEW.proc_hstt_pat_account_dtl     [Mode - 1 ]    ------>>");
			System.out.println("<<------ bill_mst.get_pat_accountdetails_limit      [Mode - 2 ]    ------>>");

			daoObj.setFuncInValue(funcIndex, 2,vo.getStrHospitalCode());
			daoObj.setFuncInValue(funcIndex, 3,"2");
			daoObj.setFuncInValue(funcIndex, 4,(vo.getStrCrNo()==null || vo.getStrCrNo().equals(""))?"0":vo.getStrCrNo());
			//daoObj.setFuncInValue(funcIndex, 5,_LPIssueDeskTransVO.getStrItemCategNo());
			daoObj.setFuncOutValue(funcIndex, 1);
			daoObj.executeFunction(funcIndex);
			BillingValue = daoObj.getFuncString(funcIndex); 
			//System.out.println("BillingValue"+BillingValue);
			vo.setStrBillingHiddenValue(BillingValue);
			
			
			
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(), 2);
			daoObj.setProcInValue(nProcIndex, "cr_no", (vo.getStrCrNo()==null || vo.getStrCrNo().equals(""))?"0":vo.getStrCrNo(), 3);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 5);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				if (ws != null && ws.size() != 0) 
				{
					ws.next();
					vo.setStrPatAccountNo(ws.getString("acc_no"));
					vo.setStrBalanceAmount(ws.getString("Balance_Amt"));	
				}
			}
		} catch (Exception _err) {
			_err.printStackTrace();
			vo
					.setStrMsgString("LPIssueDeskTransDAO.getPatientAccountBalance() --> "
							+ _err.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To place regular indent 
	 * 
	 * @param indentTransADDVO_p	the IndentTransADDVO
	 */
	public static void PLACEREGULARINDENT(RequestForLPPatientVO vo)
	{
		
		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";
		
    	try 
		{

			System.out.println("<<------ RequestForLPPatientDAO.PLACEREGULARINDENT                 ------>>");
			System.out.println("<<------ PKG_MMS_VIEW.PROC_GET_INDENTITEM_DTL       [Mode - 2 ]    ------>>");
			
    		String strProcName = "{call PKG_MMS_VIEW.PROC_GET_INDENTITEM_DTL(?,?,?,?,?,?,?)}";

			daoObj = new HisDAO("MMS Transactions","IndentViewTransDAO");
			//System.out.println("reqTypeId ====>>"+vo.getStrReqType());
			nProcIndex = daoObj.setProcedure(strProcName);
     		daoObj.setProcInValue(nProcIndex, "modval", "2",1);
	     	daoObj.setProcInValue(nProcIndex, "storeId",vo.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "reqNo",vo.getStrIndentNo(),4);
			daoObj.setProcInValue(nProcIndex, "reqTypeId",vo.getStrReqType(),5);
						
			daoObj.setProcOutValue(nProcIndex,"err", 1,6);
			daoObj.setProcOutValue(nProcIndex,"resultset", 2,7);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				wb = daoObj.getWebRowSet(nProcIndex, "resultset");
				
				vo.setStrItemDetailsWs(wb);
				
			} else {
				throw new Exception(strErr);
			}
    		
		
		
		} 
    	catch (Exception e) 
    	{
			vo.setStrMsgString("--> IndentViewTransDAO.getItemDetails()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null)
				daoObj.free();
				daoObj = null;
			}

	}
	
	
	/**
	 * To get Diagnosis details of patient 
	 * 
	 * @param RequestForLPPatientVO	the RequestForLPPatientVO
	 */
	public static void getPatientDiagDetails(RequestForLPPatientVO vo)
	{
		
		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";
		
    	try 
		{
    		System.out.println("<<------ RequestForLPPatientDAO.getPatientDiagDetails           ------>>");
			System.out.println("<<------ PKG_MMS_VIEW.proc_diag_emp_view       [Mode - 1 ]    ------>>");
			
    		String strProcName = "{call PKG_MMS_VIEW.proc_diag_emp_view(?,?::varchar,?::varchar,?,?)}";

			daoObj = new HisDAO("MMS Transactions","REQUESTFORLPPATIENTDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
     		daoObj.setProcInValue(nProcIndex, "modval", "1",1);
	     	daoObj.setProcInValue(nProcIndex, "crno",vo.getStrCrNo() ,2);
			daoObj.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),3);
						
			daoObj.setProcOutValue(nProcIndex,"err", 1,4);
			daoObj.setProcOutValue(nProcIndex,"resultset", 2,5);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				wb = daoObj.getWebRowSet(nProcIndex, "resultset");
				
				vo.setDiagEmpWs(wb);
				
			} else {
				throw new Exception(strErr);
			}
    		
		
		
		} 
    	catch (Exception e) 
    	{
			vo.setStrMsgString("--> RequestForLPPatientDAO.getPatientDiagDetails()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null)
				daoObj.free();
				daoObj = null;
			}

	}

}
