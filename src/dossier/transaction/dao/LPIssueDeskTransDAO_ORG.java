package dossier.transaction.dao;

import hisglobal.transactionmgnt.HisDAO;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.transactions.vo.RequestForLPPatientVO;
import dossier.transaction.vo.LPIssueDeskTransVO;


public class LPIssueDeskTransDAO_ORG {
	/**
	 * To get Indent Details i.e.(Store Name,Indent No.,Indent Date,Indent
	 * Type,Item Category,Raising Store) on 'issue' page
	 * 
	 * @param vo
	 */
	public static void getLPRequestDetail(LPIssueDeskTransVO _LPIssueDeskTransVO) {

		String err = "";
		String proc_name1 = "{call pkg_dossier_view.proc_hstt_lp_req_item_dtl(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		int funcIndex;
		String BillingValue="";
		try {
			
			dao = new HisDAO("mms",
					"LPIssueDeskTransDAO.getIndentDetail(LPIssueDeskTransVO vo)");
			funcIndex = dao.setFunction("{? = call bill_mst.get_pat_accountdetails_limit(?,?,?)}");

					dao.setFuncInValue(funcIndex, 2,_LPIssueDeskTransVO.getStrHospitalCode());
					dao.setFuncInValue(funcIndex, 3,"2");
					dao.setFuncInValue(funcIndex, 4,_LPIssueDeskTransVO.getStrCrNo());
					//dao.setFuncInValue(funcIndex, 5,_LPIssueDeskTransVO.getStrItemCategNo());
					dao.setFuncOutValue(funcIndex, 1);
					dao.executeFunction(funcIndex);
					BillingValue = dao.getFuncString(funcIndex); 
					
					//System.out.println("BillingValue"+BillingValue);
					
					_LPIssueDeskTransVO.setStrBillingHiddenValue(BillingValue);
					
					
			
			

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modval", "1", 1);
			dao.setProcInValue(procIndex1, "lPRequestNo",
					_LPIssueDeskTransVO.getStrLpRequestNo(), 2);

			dao.setProcInValue(procIndex1, "strRasingStoreId",
					_LPIssueDeskTransVO.getStrRaisingStoreId(), 3);

			dao.setProcInValue(procIndex1, "hosp_code",
					_LPIssueDeskTransVO.getStrHospitalCode(), 4);

			// dao.setProcInValue(procIndex1, "strRequestDate",
			// _LPIssueDeskTransVO.getStrRequestDate());

			/* Setting Default Value Start */

			dao.setProcInValue(procIndex1, "strRequestNo", _LPIssueDeskTransVO.getStrLpRequestNo(), 5);
			/* Setting Default Value End */

			dao.setProcOutValue(procIndex1, "err", 1, 6); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2, 7); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");
				System.out.println("setRequestItemDtlWS"+ws.size());
				_LPIssueDeskTransVO.setRequestItemDtlWS(ws);

			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			e.printStackTrace();
			_LPIssueDeskTransVO
					.setStrMsgString("LPIssueDeskTransDAO.getLPRequestDetail() --> "
							+ e.getMessage());
			_LPIssueDeskTransVO.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	
	public static void getLPRequestDetail_new(LPIssueDeskTransVO _LPIssueDeskTransVO) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_hstt_lp_req_item_dtl(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		int funcIndex;
		String BillingValue="";
		try {

			dao = new HisDAO("mms",
					"LPIssueDeskTransDAO.getLPRequestDetail_new(LPIssueDeskTransVO vo)");

			funcIndex = dao.setFunction("{? = call bill_mst.get_pat_accountdetails_limit(?,?,?)}");

			dao.setFuncInValue(funcIndex, 2,_LPIssueDeskTransVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3,"2");
			dao.setFuncInValue(funcIndex, 4,_LPIssueDeskTransVO.getStrCrNo());
			//dao.setFuncInValue(funcIndex, 5,_LPIssueDeskTransVO.getStrItemCategNo());
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			BillingValue = dao.getFuncString(funcIndex); 
			System.out.println("BillingValue"+BillingValue);
			_LPIssueDeskTransVO.setStrBillingHiddenValue(BillingValue);
			
			
			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modval", "2", 1);
			dao.setProcInValue(procIndex1, "lPRequestNo",
					_LPIssueDeskTransVO.getStrBSReqNo(), 2);

			dao.setProcInValue(procIndex1, "strRasingStoreId",
					_LPIssueDeskTransVO.getStrStoreId(), 3);

			dao.setProcInValue(procIndex1, "hosp_code",
					_LPIssueDeskTransVO.getStrHospitalCode(), 4);

			// dao.setProcInValue(procIndex1, "strRequestDate",
			// _LPIssueDeskTransVO.getStrRequestDate());

			/* Setting Default Value Start */

			dao.setProcInValue(procIndex1, "strRequestNo", _LPIssueDeskTransVO.getStrLpRequestNo(), 5);
			/* Setting Default Value End */

			dao.setProcOutValue(procIndex1, "err", 1, 6); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2, 7); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");

				_LPIssueDeskTransVO.setRequestItemDtlWS(ws);

			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			e.printStackTrace();
			_LPIssueDeskTransVO
					.setStrMsgString("LPIssueDeskTransDAO.getLPRequestDetail() --> "
							+ e.getMessage());
			_LPIssueDeskTransVO.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}

	public static void getIssuedItemDtl(LPIssueDeskTransVO _LPIssueDeskTransVO) {

		String err = "";
		String proc_name1 = "{call pkg_dossier_view.Proc_patemp_issue_item_dtl(?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		

		try {

			dao = new HisDAO("mms",
					"LPIssueDeskTransDAO.getIndentDetail(LPIssueDeskTransVO vo)");

			System.out.println(_LPIssueDeskTransVO.getStrIssueNo() + " "
					+ _LPIssueDeskTransVO.getStrIssueStoreId() + " "
					+ _LPIssueDeskTransVO.getStrHospitalCode());

			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "modval", "5", 1);

			// set value
			dao.setProcInValue(procIndex1, "issue_No",
					_LPIssueDeskTransVO.getStrIssueNo()+"@"+_LPIssueDeskTransVO.getStrReturnReqNo(), 4);//Request number is being passed name is wrong......discuss

			dao.setProcInValue(procIndex1, "store_id",
					_LPIssueDeskTransVO.getStrIssueStoreId(), 2);

			dao.setProcInValue(procIndex1, "hosp_code",
					_LPIssueDeskTransVO.getStrHospitalCode(), 3);

			// dao.setProcInValue(procIndex1, "strRequestDate",
			// _LPIssueDeskTransVO.getStrRequestDate());

			dao.setProcOutValue(procIndex1, "err", 1, 5); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2, 6); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");
				_LPIssueDeskTransVO.setIssuedItemDtlWS(ws);

			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			e.printStackTrace();
			_LPIssueDeskTransVO
					.setStrMsgString("LPIssueDeskTransDAO.getIssuedItemDtl() --> "
							+ e.getMessage());
			_LPIssueDeskTransVO.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
	
	
	public static void getIssuedItemDtlview(LPIssueDeskTransVO _LPIssueDeskTransVO) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.Proc_patemp_issue_item_dtl(?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms",
					"LPIssueDeskTransDAO.getIndentDetail(LPIssueDeskTransVO vo)");

			System.out.println(_LPIssueDeskTransVO.getStrIssueNo() + " "
					+ _LPIssueDeskTransVO.getStrIssueStoreId() + " "
					+ _LPIssueDeskTransVO.getStrHospitalCode());

			procIndex1 = dao.setProcedure(proc_name1);
			if(!_LPIssueDeskTransVO.getStrRequestTypeId().equals("32"))
				dao.setProcInValue(procIndex1, "modval", "3", 1);
			else
				dao.setProcInValue(procIndex1, "modval", "4", 1);

			// set value
			dao.setProcInValue(procIndex1, "issue_No",
					_LPIssueDeskTransVO.getStrIssueNo(), 4);//Request number is being passed name is wrong......discuss

			dao.setProcInValue(procIndex1, "store_id",
					_LPIssueDeskTransVO.getStrIssueStoreId(), 2);

			dao.setProcInValue(procIndex1, "hosp_code",
					_LPIssueDeskTransVO.getStrHospitalCode(), 3);

			// dao.setProcInValue(procIndex1, "strRequestDate",
			// _LPIssueDeskTransVO.getStrRequestDate());

			dao.setProcOutValue(procIndex1, "err", 1, 5); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2, 6); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");
				_LPIssueDeskTransVO.setIssuedItemDtlWS(ws);

			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			e.printStackTrace();
			_LPIssueDeskTransVO
					.setStrMsgString("LPIssueDeskTransDAO.getIssuedItemDtl() --> "
							+ e.getMessage());
			_LPIssueDeskTransVO.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	/**
	 * This function is used to to populate the value of Unit combo
	 * 
	 * @param vo
	 */
	public static void getReturnUnitCombo(LPIssueDeskTransVO _LPIssueDeskTransVO) {
		String strProcName = "{call Pkg_Mms_View.proc_GBLT_UNIT_MST(?,?,?,?,?,?)}";
		HisDAO dao = null;
		WebRowSet ws = null;
		int nProcIndex = 0;

		String strErr = "";

		try {
			dao = new HisDAO("mms", "ReturnFromTransDAO");

			nProcIndex = dao.setProcedure(strProcName);
			dao.setProcInValue(nProcIndex, "modeval", "1", 4);
			dao.setProcInValue(nProcIndex, "hosp_code",
					_LPIssueDeskTransVO.getStrHospitalCode(), 1);
			dao.setProcInValue(nProcIndex, "unit_id",
					_LPIssueDeskTransVO.getStrBalanceQtUnitId(), 2);

			dao.setProcInValue(nProcIndex, "module_id", "", 3);// Default Value

			dao.setProcOutValue(nProcIndex, "err", 1, 5);
			dao.setProcOutValue(nProcIndex, "resultset", 2, 6);

			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				_LPIssueDeskTransVO.setUnitComboWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			_LPIssueDeskTransVO
					.setStrMsgString("LPIssueDeskTransDAO.getReturnUnitCombo() --> "
							+ e.getMessage());
			_LPIssueDeskTransVO.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	

	public static void getIssueItemDtl(LPIssueDeskTransVO _LPIssueDeskTransVO) {

		String err = "";
		String proc_name1 = "{call pkg_dossier_view.Proc_hstt_chall_verifiitem_dtl(?,?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms",
					"LPIssueDeskTransDAO.getIssueItemDtl(LPIssueDeskTransVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			if(_LPIssueDeskTransVO.getStrPatientType().equalsIgnoreCase("1"))
			{	
			   dao.setProcInValue(procIndex1, "modval", "1", 1);  // New Mode
			} 
			else
			{	
			   dao.setProcInValue(procIndex1, "modval", "2", 1);
			}
			dao.setProcInValue(procIndex1, "strId", 	 _LPIssueDeskTransVO.getStrStoreId(), 2);
			dao.setProcInValue(procIndex1, "lPRequestNo",_LPIssueDeskTransVO.getStrLpRequestNo(), 3);

			dao.setProcInValue(procIndex1, "hosp_code",  _LPIssueDeskTransVO.getStrHospitalCode(), 4);
			dao.setProcInValue(procIndex1, "poNo", 		 _LPIssueDeskTransVO.getStrPoNo(), 5);
			dao.setProcInValue(procIndex1, "poStoreId",  _LPIssueDeskTransVO.getStrPoStoreId(), 6);

			// Default Value

			// dao.setProcInValue(procIndex1, "strRequestDate",
			// _LPIssueDeskTransVO.getStrRequestDate());

			dao.setProcOutValue(procIndex1, "err", 1, 7); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2, 8); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");
				System.out.println("ws.size()" + ws.size());
				_LPIssueDeskTransVO.setIssueItemDtlWS(ws);

			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			e.printStackTrace();
			_LPIssueDeskTransVO
					.setStrMsgString("LPIssueDeskTransDAO.getIssueItemDtl() --> "
							+ e.getMessage());
			_LPIssueDeskTransVO.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
	public static void getIssueItemDtl_view(LPIssueDeskTransVO _LPIssueDeskTransVO) {

		String err = "";
		String proc_name1 = "{call pkg_dossier_view.Proc_hstt_chall_verifiitem_dtl(?,?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms",
					"LPIssueDeskTransDAO.getIssueItemDtl(LPIssueDeskTransVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			if(_LPIssueDeskTransVO.getStrPatientType().equalsIgnoreCase("1"))
			{	
				System.out.println("pkg_dossier_view.Proc_hstt_chall_verifiitem_dtl- [ Mode -3 ]--");
			   dao.setProcInValue(procIndex1, "modval", "3", 1);  // New Mode
			} 
			else
			{	
				System.out.println("pkg_dossier_view.Proc_hstt_chall_verifiitem_dtl- [ Mode -2 ]--");
			   dao.setProcInValue(procIndex1, "modval", "2", 1);
			}
			dao.setProcInValue(procIndex1, "strId", 	 _LPIssueDeskTransVO.getStrStoreId(), 2);
			dao.setProcInValue(procIndex1, "lPRequestNo",_LPIssueDeskTransVO.getStrLpRequestNo(), 3);

			dao.setProcInValue(procIndex1, "hosp_code",  _LPIssueDeskTransVO.getStrHospitalCode(), 4);
			dao.setProcInValue(procIndex1, "poNo", 		 _LPIssueDeskTransVO.getStrPoNo(), 5);
			dao.setProcInValue(procIndex1, "poStoreId",  _LPIssueDeskTransVO.getStrPoStoreId(), 6);

			// Default Value

			// dao.setProcInValue(procIndex1, "strRequestDate",
			// _LPIssueDeskTransVO.getStrRequestDate());

			dao.setProcOutValue(procIndex1, "err", 1, 7); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2, 8); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");
				System.out.println("IssueItemDtlWS--ws.size()---" + ws.size());
				_LPIssueDeskTransVO.setIssueItemDtlWS(ws);

			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			e.printStackTrace();
			_LPIssueDeskTransVO
					.setStrMsgString("LPIssueDeskTransDAO.getIssueItemDtl() --> "
							+ e.getMessage());
			_LPIssueDeskTransVO.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
	public static void getIssueItemDtl_new(LPIssueDeskTransVO _LPIssueDeskTransVO) {

		String err = "";
		String proc_name1 = "{call pkg_dossier_view.Proc_hstt_chall_verifiitem_dtl(?,?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms",
					"LPIssueDeskTransDAO.getIssueItemDtl(LPIssueDeskTransVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modval", "1", 1);
			dao.setProcInValue(procIndex1, "strId",
					_LPIssueDeskTransVO.getStrStoreId(), 2);
			dao.setProcInValue(procIndex1, "lPRequestNo",
					_LPIssueDeskTransVO.getStrBSReqNo(), 3);

			dao.setProcInValue(procIndex1, "hosp_code",
					_LPIssueDeskTransVO.getStrHospitalCode(), 4);
			dao.setProcInValue(procIndex1, "poNo",
					_LPIssueDeskTransVO.getStrPoNo(), 5);
			dao.setProcInValue(procIndex1, "poStoreId",
					_LPIssueDeskTransVO.getStrPoStoreId(), 6);

			// Default Value

			// dao.setProcInValue(procIndex1, "strRequestDate",
			// _LPIssueDeskTransVO.getStrRequestDate());

			dao.setProcOutValue(procIndex1, "err", 1, 7); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "resultset", 2, 8); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			if (err.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");
				System.out.println("ws.size()" + ws.size());
				_LPIssueDeskTransVO.setIssueItemDtlWS(ws);

			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			e.printStackTrace();
			_LPIssueDeskTransVO
					.setStrMsgString("LPIssueDeskTransDAO.getIssueItemDtl() --> "
							+ e.getMessage());
			_LPIssueDeskTransVO.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	public static void insertData(LPIssueDeskTransVO _LPIssueDeskTransVO) 
	{
		String proc_name1 = "{call pkg_mms_dml.Dml_hstt_patemp_issue_item_dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,?, ?,?,?,?,? ,?,?)}";
		String strProcName5 = "{call pkg_mms_view.proc_stock_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";
		HisDAO dao = null;
		int procIndex1 = 0;
		int procIndex3 = 0;
		int procIndex4 = 0;
		int length = 0;
		String temp[] = null;
		String strItemBrandId = "";
		String strItemId = "";
		String strRate = "";
		String strRateUnitId = "";
		String strGroupId = "";
		String strSubGroupId = "";
		String strBatchSlNo = "";
		String strExpiryDate = "";
		String strIssueQty = "";
		String strStoreId = "";
		String strIssueNo = "";
		String hosp_code = "";
		String strItemSlNo = "";
		String strStockStatus = "";
		String strManuFactDate = "";
		String strConsumableFlag = "1";
		String strRemarks = "";
		String strItemCost = "";
		int funcIndex;
		String strIssueUnitId = "0";
		int batchLength;
		String strBillTariff = "";
		String strBillBatch = "";
		String strBillRate = "";
		String stritemcat="";
		String strBillQty = "";
		String                       values[] = null;
		String bsReqNo="0";
		String strExtraItemFlg = "0";
		int pIndex = 0;
		int pIndex1;
		String p_name="";String p_name1="";
		int nProcIndex = 0;
		WebRowSet ws = null;
		String strErr = "";
		String cat="";
		double totcost=0.0;
//		String      strStochStatusCodeArray[] = null;
//		String            strBatchSlNoArray[] = null;
//		String             strItemSlNoArray[] = null;
//		String       strIssueQtyBtchWsArray[] = null;
//		String   strIssueQtyUnitBtchWsArray[] = null;
//		String            strManufDateArray[] = null;
//		String           strExpiryDateArray[] = null;
//		String                 strRateArray[] = null;
//		String           strRateUnitIdArray[] = null;
		
		MmsConfigUtil mcu;
		
		try 
		{
			
			mcu =new MmsConfigUtil(_LPIssueDeskTransVO.getStrHospitalCode());
			dao = new HisDAO("mms","LPIssueDeskTransDAO.insertData(_LPIssueDeskTransVO)");
			
			System.out.println("<<<--------------LPIssueDeskTransDAO.insertData()------START---------->>>");
			
			length = _LPIssueDeskTransVO.getStrItemParamValue().length;
			
			/*
			 * 97 - Dossier Req No
			 * 99 - Dossier Return
			 * 98 - Dossier Issue
			 * */

			funcIndex = dao.setFunction("{? = call MMS_MST.generate_dossier_issueno(?,?,?,?)}");

			dao.setFuncInValue(funcIndex, 2,_LPIssueDeskTransVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3,_LPIssueDeskTransVO.getStrStoreId());
			dao.setFuncInValue(funcIndex, 4,"98");
			dao.setFuncInValue(funcIndex, 5,"10");
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			strIssueNo = dao.getFuncString(funcIndex); 
			
			System.out.println("strIssueNo------------->"+strIssueNo);
			
			System.out.println("getStrItemParamValue().length---------->"+length);
			
			temp = _LPIssueDeskTransVO.getStrItemParamValue()[0].replace('@','#').split("#");
			
			strIssueUnitId = temp[3];
			strRateUnitId  = temp[3];					
			strIssueQty    = temp[2];
			
			if (length != 0) 
			{
				for (int i = 0; i < length; i++) 
				{

							temp 				= _LPIssueDeskTransVO.getStrItemParamValue()[i].replace('@', '#').split("#");
							strItemBrandId  	= temp[1];
							strItemId 			= temp[0];
							strRate 			= temp[6];
							cat 				= strItemBrandId.substring(0,2);
						//	strRateUnitId 		= temp[6];
							strGroupId 			= "";
							strSubGroupId 		= "";
							strBatchSlNo 		= temp[5];
						//	strExpiryDate 		= temp[8].trim();
							//strIssueQty 		= temp[2];
							strIssueQty 		= _LPIssueDeskTransVO.getStrIssueQuantity()[i].split(" ")[0];
							strStoreId 			= _LPIssueDeskTransVO.getStrStoreId();
							hosp_code 			= _LPIssueDeskTransVO.getStrHospitalCode();
							strItemSlNo 		= "0";
							strStockStatus 		= "10";
						//	strManuFactDate 	= temp[7];
							strConsumableFlag 	= "1";
							strRemarks 			= _LPIssueDeskTransVO.getStrRemarks();
							//strItemCost 		= temp[9];
							strIssueUnitId 		= temp[3];
							stritemcat 			= temp[7];
							strExtraItemFlg     = _LPIssueDeskTransVO.getStrExtraItemFlg()[i];
								
						
							if(Double.parseDouble(_LPIssueDeskTransVO.getStrIssueQuantity()[i].split(" ")[0]) > 0.0)
							{
								System.out.println("<<<--------------pkg_mms_view.proc_stock_dtl [Mode - 1]---------------->>>");
								System.out.println("-------------------------------------------");
								System.out.println("strStoreId------------>"+strStoreId);
								System.out.println("catg_code------------->"+strItemBrandId.substring(0, 2));
								System.out.println("strItemId------------->"+strItemId);
								System.out.println("itembrand_id---------->"+strItemBrandId);
								System.out.println("strExtraItemFlg------->"+strExtraItemFlg);								
								System.out.println("hosp_code------------->"+_LPIssueDeskTransVO.getStrHospitalCode());
								System.out.println("-------------------------------------------");
								
								
								nProcIndex = dao.setProcedure(strProcName5);
								dao.setProcInValue(nProcIndex, "modeval", 			"1", 1);
								dao.setProcInValue(nProcIndex, "store_id",			strStoreId, 2);
								dao.setProcInValue(nProcIndex, "catcode",			strItemBrandId.substring(0, 2),3);
								dao.setProcInValue(nProcIndex, "item_id", 			strItemId, 4);
								dao.setProcInValue(nProcIndex, "itembrand_id",		strItemBrandId, 5);
								dao.setProcInValue(nProcIndex, "batch_no", 			"0", 6);
								dao.setProcInValue(nProcIndex, "stock_status",		"10", 7);
								dao.setProcInValue(nProcIndex, "hosp_code", 		_LPIssueDeskTransVO.getStrHospitalCode(), 8);
								dao.setProcInValue(nProcIndex, "itemslno", 			"0", 9);
								dao.setProcInValue(nProcIndex, "reservedstockflag", "0", 10);
								dao.setProcInValue(nProcIndex, "blockedqtyflag", 	"0", 11);
								dao.setProcOutValue(nProcIndex, "err", 				 1, 12);
								dao.setProcOutValue(nProcIndex, "resultset", 		 2, 13);
								
								dao.executeProcedureByPosition(nProcIndex);

								strErr = dao.getString(nProcIndex, "err");

								if (strErr == null)
									strErr = "";

								ws = dao.getWebRowSet(nProcIndex, "resultset");
								
								System.out.println("ws------------"+ws.size());
								float addQty=(float) 0.00;
								float issueqty=Float.parseFloat(strIssueQty);
								if(ws.size()>0 && ws!=null)
								{
									
									while(ws.next() && issueqty > 0.00)
									{
										System.out.println("In Hand qTY -------------"+ ws.getString(20));
										if( issueqty > Float.parseFloat(ws.getString(20)) )
										{
											addQty=Float.parseFloat(ws.getString(20));
											//break ; 
										}
										else
										{
											addQty=issueqty; 
											System.out.println("strIssueQty -------------"+issueqty);
										}
										issueqty = issueqty - addQty;
										
										System.out.println("issueqty = issueqty - addQty;-------------"+issueqty);
																		
										if(strBillTariff != null && strBillTariff != "")
										{	
											strBillTariff=strBillTariff + "^"+strItemBrandId;
										}	
										else
										{	
												strBillTariff = strItemBrandId;
										}		
										
										if(strBillRate != null && strBillRate != "")
										{	
												strBillRate=strBillRate + "^"+ws.getString(38);
										}		
										else
										{	
													strBillRate = ws.getString(38);
										}			
											
										if(strBillQty != null && strBillQty != "")
										{
												strBillQty=strBillQty + "^"+String.valueOf(addQty);
										}		
										else
										{	
													strBillQty = String.valueOf(addQty);
										}			
											
										if(strBillBatch != null && strBillBatch != "")
										{	
												strBillBatch=strBillBatch + "^"+ws.getString(15);
										}		
										else
										{	
													strBillBatch = ws.getString(15);
										}			
									System.out.println("-------------------------------------------");		
									System.out.println("strBillTariff-------------"+strBillTariff);
									System.out.println("strBillRate---------------"+strBillRate);
									System.out.println("strBillQty----------------"+strBillQty);
									System.out.println("strBillBatch--------------"+strBillBatch);
									System.out.println("-------------------------------------------");									
									
									totcost = totcost + (Double.parseDouble(strRate)*addQty);
									
								System.out.println("totcost-------------"+totcost);
								System.out.println("_LPIssueDeskTransVO.getStrPatientType()-------------"+_LPIssueDeskTransVO.getStrPatientType());
								
								System.out.println("<<<------LOOP = [ "+i+"]-----pkg_mms_dml.Dml_hstt_patemp_issue_item_dtl [Mode - ( PatientType = 1)- 1   OR  - 3 ]----Patient Type---"+_LPIssueDeskTransVO.getStrPatientType()+"---------->>>");
								
								System.out.println("-------------------------------------------");
								System.out.println("strItemBrandId---------"+strItemBrandId);
								System.out.println("strItemId--------------"+strItemId);
								System.out.println("strRate----------------"+strRate);
								System.out.println("strBatchSlNo-----------"+ws.getString(15));
								System.out.println("strRate----------------"+strRate);
								System.out.println("-------------------------------------------");
								
								procIndex1 = dao.setProcedure(proc_name1);
								if(_LPIssueDeskTransVO.getStrPatientType().equalsIgnoreCase("1"))
								{
									System.out.println("Mode ->> 1 ----If Patient Type 1----------");
									dao.setProcInValue(procIndex1, "modval", 			"1", 1); // Default
								}
								else
								{
									System.out.println("Mode ->> 3 --------------");
									dao.setProcInValue(procIndex1, "modval", 			"3", 1); // Default	
								}
																					// Value.
								dao.setProcInValue(procIndex1, "strItemBrandId", 	strItemBrandId, 2); // 1
								dao.setProcInValue(procIndex1, "strItemId", 		strItemId, 3); // 2
								dao.setProcInValue(procIndex1, "strRate", 			strRate, 4); // 3
								dao.setProcInValue(procIndex1, "strRateUnitId",		strRateUnitId, 5); // 4
								dao.setProcInValue(procIndex1, "strGroupId", 		strGroupId, 6); // 5?
								dao.setProcInValue(procIndex1, "strSubGroupId",		strSubGroupId, 7); // 6?
								dao.setProcInValue(procIndex1, "strBatchSlNo",		ws.getString(15), 8); // 7
								dao.setProcInValue(procIndex1, "strExpiryDate",		strExpiryDate.trim(), 9); // 8
								dao.setProcInValue(procIndex1, "strIssueQty", 		String.valueOf(addQty),10);
								dao.setProcInValue(procIndex1, "strIssueUnitId",	strIssueUnitId, 11); // 10
								dao.setProcInValue(procIndex1, "strStoreId", 		strStoreId, 12); // 11
								dao.setProcInValue(procIndex1, "strIssueNo", 		strIssueNo, 13); // 12
								dao.setProcInValue(procIndex1, "hosp_code", 		hosp_code, 14); // 13
								dao.setProcInValue(procIndex1, "strItemSlNo", 		strItemSlNo,15); // 14
								dao.setProcInValue(procIndex1, "strStockStatus",	strStockStatus, 16); // 15
								dao.setProcInValue(procIndex1, "strManuFactDate",	strManuFactDate.trim(), 17); // 16
								dao.setProcInValue(procIndex1, "strConsumableFlag",	strExtraItemFlg, 18); // 17   // PASS As Extra Item Flag 
								dao.setProcInValue(procIndex1, "strRemarks", 		strRemarks, 19); // 18
								dao.setProcInValue(procIndex1, "strItemCost",		Double.toString((Double.parseDouble(strRate)*addQty)),20); // 19?
								dao.setProcInValue(procIndex1, "strRequestNo",		_LPIssueDeskTransVO.getStrLpRequestNo(), 21); // 20?     //   Dossier Request No
								dao.setProcInValue(procIndex1, "strRasingStoreId",	_LPIssueDeskTransVO.getStrRaisingStoreId(), 22);
								dao.setProcInValue(procIndex1, "strItemCatNo",		stritemcat, 23); // 21
								dao.setProcInValue(procIndex1, "strSeatid",			_LPIssueDeskTransVO.getStrSeatId(), 24);
								dao.setProcInValue(procIndex1, "strDescription",	_LPIssueDeskTransVO.getStrDescription(), 25);
								dao.setProcInValue(procIndex1, "crno",				_LPIssueDeskTransVO.getStrCrNo(), 26);
								dao.setProcOutValue(procIndex1, "err", 				1, 27); // 22
								dao.execute(procIndex1,1);
		
							}
						}
					}
						
				}
			}
			if(_LPIssueDeskTransVO.getStrPatientType().equalsIgnoreCase("1"))
			{
					if(mcu.getStrBillingIntegration().equals("1"))
					{
						if(!strBillTariff.equals("") && strBillTariff != null)
						{
							System.out.println("-------- If Patient Type  = 1 & --mcu.getStrBillingIntegration() = "+mcu.getStrBillingIntegration()+"  = 1 ----------");
							System.out.println("<<<--------------bill_interface.dml_online_billreq_drugs [Mode - 1]---------------->>>");
							
							int procIndex2;
							String proc_name2 = "{call bill_interface.dml_online_billreq_drugs(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}";
							procIndex2 = dao.setProcedure(proc_name2);
							System.out.println("-------------------------------------------");
							System.out.println("gnum_dept_code-------------"+_LPIssueDeskTransVO.getStrDeptCode());
							System.out.println("strIssueNo=============<>>>>>>>"+strIssueNo+"#2#"+(_LPIssueDeskTransVO.getStrDossierShortName()==null ? "0" : _LPIssueDeskTransVO.getStrDossierShortName()));
							System.out.println("gnum_treatment_cat-------------"+_LPIssueDeskTransVO.getStrTreatmentCat());
							System.out.println("hrgnum_episode_code-------------"+_LPIssueDeskTransVO.getStrEpisodeCode());
							System.out.println("hrgnum_puk-------------"+_LPIssueDeskTransVO.getStrCrNo());
							System.out.println("gnum_seatid-------------"+_LPIssueDeskTransVO.getStrSeatId());
							System.out.println("hosp_code-------------"+_LPIssueDeskTransVO.getStrHospitalCode());
							System.out.println("ward_code-------------"+_LPIssueDeskTransVO.getStrWardCode());
							System.out.println("admno-------------"+_LPIssueDeskTransVO.getStrAdmissionNo());
							System.out.println("visitno-------------"+_LPIssueDeskTransVO.getStrVisitNo());
							System.out.println("strBillRate-------------"+strBillRate);
							System.out.println("-------------------------------------------");
							
							dao.setProcInValue(procIndex2, "modval", 					"1", 1); // 1
							dao.setProcInValue(procIndex2, "gnum_dept_code", 			_LPIssueDeskTransVO.getStrDeptCode(), 2);							
							dao.setProcInValue(procIndex2, "sblnum_chargetype_id",  	"2", 3);
							dao.setProcInValue(procIndex2, "sblnum_service_id", 		"5", 4);							
							dao.setProcInValue(procIndex2, "gstr_req_no", 				strIssueNo+"#2#"+(_LPIssueDeskTransVO.getStrDossierShortName()==null ? "0" : _LPIssueDeskTransVO.getStrDossierShortName()), 5);
							dao.setProcInValue(procIndex2, "gnum_treatment_cat", 		_LPIssueDeskTransVO.getStrTreatmentCat(),6);							
							dao.setProcInValue(procIndex2, "hrgnum_episode_code", 		_LPIssueDeskTransVO.getStrEpisodeCode(), 7);							
							dao.setProcInValue(procIndex2, "hrgnum_puk", 			  	_LPIssueDeskTransVO.getStrCrNo(), 8);							
							dao.setProcInValue(procIndex2, "hblnum_pat_lfaccount_no", 	"0", 9);
							dao.setProcInValue(procIndex2, "gstr_tariff", 				strBillTariff, 10);
							dao.setProcInValue(procIndex2, "gstr_tariff_batch", 		strBillBatch, 11);
							dao.setProcInValue(procIndex2, "gstr_tariff_rates", 		strBillRate, 12);
							dao.setProcInValue(procIndex2, "gstr_reqqty", 				strBillQty, 13);
							dao.setProcInValue(procIndex2, "hblstr_patient_name", 		"", 14);
							dao.setProcInValue(procIndex2, "hblstr_pat_address", 		"", 15);
							dao.setProcInValue(procIndex2, "hblstr_contact_no", 		"", 16);
							dao.setProcInValue(procIndex2, "age", 						"1", 17);
							dao.setProcInValue(procIndex2, "ageunit",				 	"1", 18);
							dao.setProcInValue(procIndex2, "gender", 					"1", 19);
							dao.setProcInValue(procIndex2, "refdoctor", 				"1", 20);
							dao.setProcInValue(procIndex2, "refdoccontactno", 			"1", 21);
							dao.setProcInValue(procIndex2, "gnum_seatid", 				_LPIssueDeskTransVO.getStrSeatId(), 22);							
							dao.setProcInValue(procIndex2, "hosp_code", 				_LPIssueDeskTransVO.getStrHospitalCode(), 23);							
							dao.setProcInValue(procIndex2, "ward_code", 				_LPIssueDeskTransVO.getStrWardCode(), 24);							
							dao.setProcInValue(procIndex2, "admno", 					_LPIssueDeskTransVO.getStrAdmissionNo(), 25);							
							dao.setProcInValue(procIndex2, "visitno", 					_LPIssueDeskTransVO.getStrVisitNo(), 26);							
							dao.setProcOutValue(procIndex2, "err", 						1, 27);
							
							dao.execute(procIndex2, 1);
						}
					}
		    }
			if(_LPIssueDeskTransVO.getStrBSReqNo().equals("0"))
			{
				if(_LPIssueDeskTransVO.getStrBSIndent().equals("1"))
				{
						int itmln = _LPIssueDeskTransVO.getStrBSQuantity().length;
						
						System.out.println("-------- _LPIssueDeskTransVO.getStrBSReqNo() = "+_LPIssueDeskTransVO.getStrBSReqNo()+"  = 0 - & -LPIssueDeskTransVO.getStrBSIndent()-"+_LPIssueDeskTransVO.getStrBSIndent()+" = 1 ---------");
						
					
						RequestForLPPatientVO vo = new RequestForLPPatientVO();
						vo.setStrStoreId(_LPIssueDeskTransVO.getStrStoreId());
						vo.setStrHospitalCode(_LPIssueDeskTransVO.getStrHospitalCode());
						vo.setStrReqType("86");
						vo.setStrToStoreCombo(_LPIssueDeskTransVO.getStrStoreId());
						vo.setStrItemCategoryNo(_LPIssueDeskTransVO.getStrItemCategNo());
						vo.setStrUrgentFlg(_LPIssueDeskTransVO.getStrUrgentFlg());//need to change later
						vo.setStrFinancialEndYear(_LPIssueDeskTransVO.getStrFinEndDate());
						vo.setStrFinancialStartYear(_LPIssueDeskTransVO.getStrFinStartDate());
						vo.setStrRemarks(_LPIssueDeskTransVO.getStrRemarks());
						vo.setStrSeatId(_LPIssueDeskTransVO.getStrSeatId());
						vo.setStrGrantType("0");
						vo.setStrCrNo(_LPIssueDeskTransVO.getStrCrNo());
						vo.setStrEmpNo("0");
						vo.setStrAdmnNo(_LPIssueDeskTransVO.getStrAdmissionNo());
						vo.setStrApproxAmt("0");
						List<String> tArr=new ArrayList<String>();
						List<String> reqQty=new ArrayList<String>();
						List<String> reqUnit=new ArrayList<String>();
						for(int i=0;i<itmln;i++)
						{
							//10000002@10100002@11.00@6301@997533.00@gt5@2.36
							temp = _LPIssueDeskTransVO.getStrItemParamValue()[i].replace('@', '#').split("#");
						   
							 //int j=0;
							
							 if(!_LPIssueDeskTransVO.getStrBSQuantity()[i].equals("0"))
							 {
								tArr.add("0#0#"+temp[0]+"^"+temp[1]+"^0^0^0^0^0^"+temp[4]+"^"+temp[3]+"^"+temp[6]+"^"+temp[3]+"^0^0^^0^0^0^0^0^0^0^0^0^0^0^0^0") ;
								reqQty.add(_LPIssueDeskTransVO.getStrBSQuantity()[i]);
								reqUnit.add(temp[3]);
								//j++;
							 }
							 
						
						}
						
						String [] arr = tArr.toArray(new String[tArr.size()]);
						String [] arr1 = reqQty.toArray(new String[reqQty.size()]);
						String [] arr2 = reqUnit.toArray(new String[reqUnit.size()]);
						
						vo.setItemParamValue(arr);
						vo.setStrReqQty(arr1);
						vo.setStrUnitName(arr2);
						
						//RequestForLPPatientDAO.INSERT(vo);
						
						if(vo.getStrBSReqNo() != null && !vo.getStrBSReqNo().equals(""))
							bsReqNo = vo.getStrBSReqNo();
						else
							bsReqNo = "0";
						
						_LPIssueDeskTransVO.setStrBSReqNo(bsReqNo);
						
					System.out.println("<<<--------------pkg_mms_dml.Dml_update_sstt_indent_dtl [Mode - 1]-------A--------->>>");	
						// added to update Bs req no in sstt_indent_dtl table
					p_name = "{call pkg_mms_dml.Dml_update_sstt_indent_dtl(?,?,?,?,? ,?)}";
					
					pIndex = dao.setProcedure(p_name);
					
					dao.setProcInValue(pIndex, "modval", 		"1", 1);
					dao.setProcInValue(pIndex, "hosp_code", 	_LPIssueDeskTransVO.getStrHospitalCode(), 2);
					dao.setProcInValue(pIndex, "reqNo", 		_LPIssueDeskTransVO.getStrLpRequestNo(), 3);
					dao.setProcInValue(pIndex, "bsNo", 			bsReqNo, 4);
					dao.setProcInValue(pIndex, "raising_store",	_LPIssueDeskTransVO.getStrRaisingStoreId(), 5);
					dao.setProcOutValue(pIndex, "err", 			1, 6);
					dao.executeProcedureByPosition(pIndex);
						
				}
				else
				{
					System.out.println("<<<--------------pkg_mms_dml.Dml_update_sstt_indent_dtl [Mode - 1]-------B--------->>>");
					// added to update Bs req no in sstt_indent_dtl table
					p_name = "{call pkg_mms_dml.Dml_update_sstt_indent_dtl(?,?,?,?,? ,?)}";
				
				    pIndex = dao.setProcedure(p_name);
				
					dao.setProcInValue(pIndex, "modval", 		"1", 1);
					dao.setProcInValue(pIndex, "hosp_code", 	_LPIssueDeskTransVO.getStrHospitalCode(), 2);
					dao.setProcInValue(pIndex, "reqNo", 		_LPIssueDeskTransVO.getStrLpRequestNo(), 3);
					dao.setProcInValue(pIndex, "bsNo", 			"0", 4);
					dao.setProcInValue(pIndex, "raising_store",	_LPIssueDeskTransVO.getStrRaisingStoreId(), 5);
					dao.setProcOutValue(pIndex, "err", 			1, 6);
					dao.execute(pIndex,1);
				}
		}
			
			if (length != 0) 
			{
				for (int i = 0; i < length; i++) 
				{
					    strIssueQty = _LPIssueDeskTransVO.getStrIssueQuantity()[i].split(" ")[0];				
							
						if(!strIssueQty.equals("0.00") && !strIssueQty.equals("0"))
						{
							i=length;
							proc_name1 = "";
							
							System.out.println("<<<--------------pkg_mms_dml.Dml_hstt_patemp_issue_dtl [Mode - 1]---------------->>>");
							
							proc_name1 = "{call pkg_mms_dml.Dml_hstt_patemp_issue_dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?)}";
				
							procIndex3 = dao.setProcedure(proc_name1);
							dao.setProcInValue(procIndex3, "modval", 			"1", 1);
							dao.setProcInValue(procIndex3, "strIssueNo", 		strIssueNo, 2); // 1
							dao.setProcInValue(procIndex3, "hosp_code", 		_LPIssueDeskTransVO.getStrHospitalCode(), 3); // 2
							dao.setProcInValue(procIndex3, "strStoreId",		_LPIssueDeskTransVO.getStrStoreId(), 4); // 3
							dao.setProcInValue(procIndex3, "strRemarks", 		strRemarks, 5); // 18
							dao.setProcInValue(procIndex3, "strFinalCost",		Double.toString(totcost), 6); // 4
							dao.setProcInValue(procIndex3, "strRequestNo",		_LPIssueDeskTransVO.getStrLpRequestNo(), 7); // 5
							dao.setProcInValue(procIndex3, "strRequestDate",	_LPIssueDeskTransVO.getStrFinStartDate(), 8); // 6
							dao.setProcInValue(procIndex3, "strCrNo",			_LPIssueDeskTransVO.getStrCrNo(), 9); // 7
							dao.setProcInValue(procIndex3, "strReqTypeId",		_LPIssueDeskTransVO.getStrRequestTypeId(), 10);// 8
							dao.setProcInValue(procIndex3, "strAdmNo",			_LPIssueDeskTransVO.getStrAdmissionNo(), 11); // 9
							dao.setProcInValue(procIndex3, "strEmpNo",			_LPIssueDeskTransVO.getStrEmpNo(), 12); // 10
							dao.setProcInValue(procIndex3, "strItemCatNo",		cat, 13); // 11
							dao.setProcInValue(procIndex3, "strFinStartDate",	_LPIssueDeskTransVO.getStrFinStartDate(), 14); // 12
							dao.setProcInValue(procIndex3, "strFinEndDate",		_LPIssueDeskTransVO.getStrFinEndDate(), 15); // 13
							dao.setProcInValue(procIndex3, "strSeatId",			_LPIssueDeskTransVO.getStrSeatId(), 16); // 14
							dao.setProcInValue(procIndex3, "strRaisingStoreId",	_LPIssueDeskTransVO.getStrRaisingStoreId(), 17); // 15				
							dao.setProcInValue(procIndex3, "strIssueQty", 		strIssueQty, 18);
							dao.setProcInValue(procIndex3, "strIssueUnitId", 	strIssueUnitId, 19); // 17						
							dao.setProcInValue(procIndex3, "strDeptCode",		_LPIssueDeskTransVO.getStrDeptCode(), 20);
							dao.setProcInValue(procIndex3, "strDeptUnitCode",	_LPIssueDeskTransVO.getStrDeptUnitCode(), 21);
							dao.setProcInValue(procIndex3, "strWardCode",		_LPIssueDeskTransVO.getStrWardCode(), 22);
							dao.setProcInValue(procIndex3, "strEpisodeCode",	_LPIssueDeskTransVO.getStrEpisodeCode(), 23);
							dao.setProcInValue(procIndex3, "strVisitNo",		_LPIssueDeskTransVO.getStrVisitNo(), 24);
							dao.setProcInValue(procIndex3, "strVisitType",		_LPIssueDeskTransVO.getStrVisitType(), 25);
							dao.setProcInValue(procIndex3, "strRecieveBy",		_LPIssueDeskTransVO.getStrReceivedby(), 26);
							dao.setProcInValue(procIndex3, "strOrderBy", 		"", 27);
							dao.setProcInValue(procIndex3, "strOrderDate", 		"", 28);
							dao.setProcInValue(procIndex3, "days", 				"", 29);
							dao.setProcInValue(procIndex3, "strPoNo",			_LPIssueDeskTransVO.getStrPoNo(), 30);
							dao.setProcInValue(procIndex3, "strPoStoreId",		_LPIssueDeskTransVO.getStrPoStoreId(), 31);					
							dao.setProcInValue(procIndex3, "strBsReqNo", 		bsReqNo, 32);
							dao.setProcOutValue(procIndex3, "err",				1, 33);
							dao.execute(procIndex3, 1);
				
							proc_name1 = "";
							System.out.println("<<<--------------pkg_mms_dml.Dml_issue_dtls [Mode - 2]---------------->>>");
							proc_name1 = "{call pkg_mms_dml.Dml_issue_dtls(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}";
							procIndex4 = dao.setProcedure(proc_name1);
							dao.setProcInValue(procIndex4, "modeval", 			"2", 1);
							dao.setProcInValue(procIndex4, "issuing_store_id",	_LPIssueDeskTransVO.getStrStoreId(), 2);
							dao.setProcInValue(procIndex4, "issueNo", 			strIssueNo, 3); // 1
							dao.setProcInValue(procIndex4, "hospital_code", 	_LPIssueDeskTransVO.getStrHospitalCode(), 4); // 2
							dao.setProcInValue(procIndex4, "category_No",		strItemBrandId.substring(0,2), 5);
							dao.setProcInValue(procIndex4, "indent_No",			_LPIssueDeskTransVO.getStrLpRequestNo(), 6); // 5
							dao.setProcInValue(procIndex4, "reqType_id",		_LPIssueDeskTransVO.getStrRequestTypeId(), 7);// 8
							dao.setProcInValue(procIndex4, "indent_Date",		_LPIssueDeskTransVO.getStrRequestDate(), 8); // 6
							dao.setProcInValue(procIndex4, "raising_store_id",	_LPIssueDeskTransVO.getStrRaisingStoreId(), 9); // 15
							dao.setProcInValue(procIndex4, "net_cost",			Double.toString(totcost), 11); // 4
							dao.setProcInValue(procIndex4, "strCrNo",			_LPIssueDeskTransVO.getStrCrNo(), 16); // 7
							dao.setProcInValue(procIndex4, "strAmNo",			_LPIssueDeskTransVO.getStrAdmissionNo(), 17); // 9
							dao.setProcInValue(procIndex4, "strEmpNo",			_LPIssueDeskTransVO.getStrEmpNo(), 18); // 10
							dao.setProcInValue(procIndex4, "fin_start_date",	_LPIssueDeskTransVO.getStrFinStartDate(), 12); // 12
							dao.setProcInValue(procIndex4, "fin_end_date",		_LPIssueDeskTransVO.getStrFinEndDate(), 13); // 13
							dao.setProcInValue(procIndex4, "seatId",			_LPIssueDeskTransVO.getStrSeatId(), 15); // 14
							dao.setProcInValue(procIndex4, "remarks", 			strRemarks, 14); // 16
							dao.setProcInValue(procIndex4, "receivedBy",		_LPIssueDeskTransVO.getStrReceivedby(), 10); // 17
							dao.setProcInValue(procIndex4, "strPoNo",			_LPIssueDeskTransVO.getStrPoNo(), 19); // 18
							dao.setProcInValue(procIndex4, "strPoStoreId",		_LPIssueDeskTransVO.getStrPoStoreId(), 20); // 19
							dao.setProcInValue(procIndex4, "strBsReqNo",		bsReqNo, 21); // 19
							dao.setProcOutValue(procIndex4, "err", 				1, 22);
							dao.execute(procIndex4, 1);
							
						
					}	
				}
			}
			
			System.out.println("<<<--------------pkg_dossier_dml.dml_update_dossier_req_dtl [Mode - 1]---------------->>>");
			
			p_name1 = "{call pkg_dossier_dml.dml_update_dossier_req_dtl(?,?,?,?,? ,?)}";
			
			pIndex1 = dao.setProcedure(p_name1);
			
			dao.setProcInValue(pIndex1, "modval", 		"1", 1);
			dao.setProcInValue(pIndex1, "hosp_code", 	_LPIssueDeskTransVO.getStrHospitalCode(), 2);
			dao.setProcInValue(pIndex1, "reqNo", 		_LPIssueDeskTransVO.getStrLpRequestNo(), 3);
			dao.setProcInValue(pIndex1, "bsNo", 		_LPIssueDeskTransVO.getStrAdmissionNo(), 4);
			dao.setProcInValue(pIndex1, "raising_store",_LPIssueDeskTransVO.getStrStoreId(), 5);
			dao.setProcOutValue(pIndex1, "err", 		1, 6);
			dao.execute(pIndex1,1);
			
			
			
			dao.fire();
			
			
			System.out.println("<<<--------------LPIssueDeskTransDAO.insertData()-------END--------->>>");
			
			_LPIssueDeskTransVO.setStrIssueNo(strIssueNo);
			
		}						
		catch (Exception _err) 
		{
			
			_err.printStackTrace();
			_LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransDAO.insertData() --> "+ _err.getMessage());
			_LPIssueDeskTransVO.setStrMsgType("1");
		}
	}

	public static void insertRetData(LPIssueDeskTransVO _LPIssueDeskTransVO) {

		String proc_name1 = "{call pkg_mms_dml.dml_patemp_return_item_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		int procIndex1 = 0;
		int length = 0;
		String temp[] = null;
		String strItemBrandId = "";
		String strItemId = "";
		String strRate = "";
		String strRateUnitId = "";
		String strGroupId = "";
		String strSubGroupId = "";
		String strBatchSlNo = "";
		String strExpiryDate = "";
		String strReturnNo = "";
		String strItemSlNo = "";
		String strStockStatus = "";
		String strManuFactDate = "";
		String temp2[] = null;
		int funcIndex;
		String strIssueUnitId = "0";
		String strBillTariff = "";
		String strBillBatch = "";
		String strBillRate = "";
		String strBillQty = "";
		String proc_name2 = "{call bill_interface.dml_online_billreq_drugs(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}";
		MmsConfigUtil mcu;
		try {
			
			 System.out.println("------------- LPIssueDeskTransDAO.insertRetData -----------------");
			 
			mcu =new MmsConfigUtil(_LPIssueDeskTransVO.getStrHospitalCode());

			dao = new HisDAO("mms","LPIssueDeskTransDAO.insertData(_LPIssueDeskTransVO)");
			/*
			 * 97 - Dossier Req No
			 * 99 - Dossier Return
			 * 98 - Dossier Issue
			 * */

			funcIndex = dao.setFunction("{? = call MMS_MST.generate_dossier_issueno(?::numeric,?::numeric,?::numeric,?::numeric)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2,_LPIssueDeskTransVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3,_LPIssueDeskTransVO.getStrStoreId());
			dao.setFuncInValue(funcIndex, 4,"99");
			dao.setFuncInValue(funcIndex, 5,"10");			
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			strReturnNo = dao.getFuncString(funcIndex);
			_LPIssueDeskTransVO.setStrReturnNo(strReturnNo);
			proc_name1 = "";
			proc_name1 = "{call pkg_dossier_Dml.dml_patemp_return_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			procIndex1 = dao.setProcedure(proc_name1);
			
			 System.out.println("------------- pkg_dossier_Dml.dml_patemp_return_dtl [Mode - 1 ] -----------------");

			/* Setting Default Value Start */
			dao.setProcInValue(procIndex1, "modval", "1", 1);
			dao.setProcInValue(procIndex1, "store_id",_LPIssueDeskTransVO.getStrStoreId(), 2);
			dao.setProcInValue(procIndex1, "return_no", strReturnNo, 3);
			dao.setProcInValue(procIndex1, "hosp_code",_LPIssueDeskTransVO.getStrHospitalCode(), 4);
			dao.setProcInValue(procIndex1, "issue_no",_LPIssueDeskTransVO.getStrIssueNo(), 5);
			dao.setProcInValue(procIndex1, "return_date", "", 6);
			dao.setProcInValue(procIndex1, "reqtype_id",_LPIssueDeskTransVO.getStrRequestTypeId(), 7);
			dao.setProcInValue(procIndex1, "pukno",_LPIssueDeskTransVO.getStrCrNo(), 8);
			dao.setProcInValue(procIndex1, "adm_no",_LPIssueDeskTransVO.getStrAdmissionNo(), 9);
			dao.setProcInValue(procIndex1, "issue_date",_LPIssueDeskTransVO.getStrIssueDate(), 10);
			dao.setProcInValue(procIndex1, "emp_no",_LPIssueDeskTransVO.getStrEmpNo(), 11);
			dao.setProcInValue(procIndex1, "item_cat_no",_LPIssueDeskTransVO.getStrItemCategNo(), 12);
			dao.setProcInValue(procIndex1, "return_netcost",_LPIssueDeskTransVO.getStrFinalCost(), 13);
			dao.setProcInValue(procIndex1, "financial_start_date",_LPIssueDeskTransVO.getStrFinStartDate(), 14);
			dao.setProcInValue(procIndex1, "financial_end_date",_LPIssueDeskTransVO.getStrFinEndDate(), 15);
			dao.setProcInValue(procIndex1, "recommended_by",_LPIssueDeskTransVO.getStrRecommendBy(), 16);
			dao.setProcInValue(procIndex1, "recommended_date", "", 17);
			dao.setProcInValue(procIndex1, "remarks",_LPIssueDeskTransVO.getStrRemarks(), 18);
			dao.setProcInValue(procIndex1, "entry_date", "", 19);
			dao.setProcInValue(procIndex1, "seatid",_LPIssueDeskTransVO.getStrSeatId(), 20);
			dao.setProcInValue(procIndex1, "isvalid", "1", 21);
			dao.setProcOutValue(procIndex1, "err", 1, 22);
			dao.execute(procIndex1,1);
			/* Setting Default Value End */

			proc_name1 = "";
			proc_name1 = "{call pkg_dossier_dml.dml_patemp_return_item_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			System.out.println("------------- pkg_dossier_dml.dml_patemp_return_item_dtl [Mode - 2 ] -----------------");
			
			temp = _LPIssueDeskTransVO.getStrItemParamValue()[0].replace('@',
					'#').split("#");
			strIssueUnitId = temp[1];

			length = _LPIssueDeskTransVO.getStrItemParamValue().length;
			if (length != 0) {
				for (int i = 0; i < length; i++) {
					temp = _LPIssueDeskTransVO.getStrItemParamValue()[i].replace('@', '#').split("#");
					strIssueUnitId = temp[1];
					strItemBrandId = temp[3];
					strItemId = temp[4];
					strBatchSlNo = temp[5];
					strItemSlNo = temp[6];
					strStockStatus = temp[7];
					strGroupId = temp[8];
					strSubGroupId = temp[9];
					strRate = temp[10];
					temp2 = temp[11].replace('^', '#').split("#");
					strRateUnitId = temp2[0];
					strManuFactDate = temp[12];
					strExpiryDate = temp[13];

					// gives balance quantity.
					float getBalanaceQty = Float.parseFloat(_LPIssueDeskTransVO.getStrBalanceQty()[i])- Float.parseFloat(_LPIssueDeskTransVO.getStrReturnQty()[i]);
					/* Setting Default Value Start */
					temp = _LPIssueDeskTransVO.getStrUnit()[i].replace('^', '#').split("#");
					//added by shalini to insert data in billing 
					if(_LPIssueDeskTransVO.getStrReturnQty()[i]!=null && Float.parseFloat(_LPIssueDeskTransVO.getStrReturnQty()[i]) > 0.00 && Integer.parseInt(_LPIssueDeskTransVO.getStrReturnQty()[i]) > 0 )
					{
						
						if(strBillTariff != null && strBillTariff != "")
						strBillTariff=strBillTariff + "^"+strItemBrandId;
						else
							strBillTariff = strItemBrandId;
						if(strBillRate != null && strBillRate != "")
							strBillRate=strBillRate + "^"+strRate;
							else
								strBillRate = strRate;
						
						if(_LPIssueDeskTransVO.getStrPatientType().equals("1")){
							if(strBillQty != null && strBillQty != "")
								strBillQty=strBillQty + "^"+"-"+_LPIssueDeskTransVO.getStrReturnQty()[i];
								else
									strBillQty = "-"+_LPIssueDeskTransVO.getStrReturnQty()[i];
						}else{
							if(strBillQty != null && strBillQty != "")
								strBillQty=strBillQty + "^"+_LPIssueDeskTransVO.getStrReturnQty()[i];
								else
									strBillQty = _LPIssueDeskTransVO.getStrReturnQty()[i];
						}
						if(strBillBatch != null && strBillBatch != "")
							strBillBatch=strBillBatch + "^"+strBatchSlNo;
							else
								strBillBatch = strBatchSlNo;
						System.out.println("strBillTariff:::::"+strBillTariff);
						System.out.println("strBillRate:::::"+strBillRate);
						System.out.println("strBillQty:::::"+strBillQty);
						System.out.println("strBillBatch:::::"+strBillBatch);
					 }
					
					

					procIndex1 = dao.setProcedure(proc_name1);
					dao.setProcInValue(procIndex1, "modval", "2", 1); 
					dao.setProcInValue(procIndex1, "store_id",_LPIssueDeskTransVO.getStrStoreId(), 2);
					dao.setProcInValue(procIndex1, "return_no", strReturnNo, 3); 
					dao.setProcInValue(procIndex1, "item_id", strItemId, 4); 
					dao.setProcInValue(procIndex1, "itembrand_id",strItemBrandId, 5); 
					dao.setProcInValue(procIndex1, "batch_sl_no", strBatchSlNo,6); 
					dao.setProcInValue(procIndex1, "hosp_code",_LPIssueDeskTransVO.getStrHospitalCode(), 7); 
					dao.setProcInValue(procIndex1, "return_date", "", 8);
					dao.setProcInValue(procIndex1, "item_sl_no",strItemSlNo.trim(), 9); 
					dao.setProcInValue(procIndex1, "group_id", strGroupId, 10); 
					dao.setProcInValue(procIndex1, "inhand_qty", "0", 11);
					dao.setProcInValue(procIndex1, "subgroup_id",strSubGroupId, 12); 
					// dao.setProcInValue(procIndex1, "balance_qty", _LPIssueDeskTransVO.getStrBalanceQty()[i],13);
					dao.setProcInValue(procIndex1, "balance_qty",Float.toString(getBalanaceQty), 13);  // commented by vikrant after discussion
					dao.setProcInValue(procIndex1, "inhand_qty_unitid", "", 14);
					dao.setProcInValue(procIndex1, "balanceqty_unitid",strIssueUnitId, 15); 
					dao.setProcInValue(procIndex1, "return_qty",_LPIssueDeskTransVO.getStrReturnQty()[i], 16); 
					dao.setProcInValue(procIndex1, "retqty_unitid", temp[0], 17); 
					dao.setProcInValue(procIndex1, "rate", strRate, 18); 
					dao.setProcInValue(procIndex1, "rate_unitid",strRateUnitId, 19); 
					dao.setProcInValue(procIndex1, "remarks",_LPIssueDeskTransVO.getStrRemarks(), 20); 
					dao.setProcInValue(procIndex1, "isvalid", "1", 21); 
					dao.setProcInValue(procIndex1, "cost",_LPIssueDeskTransVO.getItemCost()[i], 22); 
					dao.setProcInValue(procIndex1, "stock_status_code",strStockStatus, 23);
					dao.setProcInValue(procIndex1, "issueNo",_LPIssueDeskTransVO.getStrIssueNo(), 24);
					dao.setProcInValue(procIndex1, "strItemCategNo",strItemBrandId.substring(0, 2), 25);
					dao.setProcInValue(procIndex1, "strDescription","Return From Patient having CR No. :"+_LPIssueDeskTransVO.getStrCrNo(), 26);
					dao.setProcInValue(procIndex1, "strSeatid",_LPIssueDeskTransVO.getStrSeatId(), 27);
					dao.setProcInValue(procIndex1, "expiryDate",strExpiryDate.trim(), 28);
					dao.setProcInValue(procIndex1, "strManufactDate",strManuFactDate, 29);
					dao.setProcInValue(procIndex1, "strPoNo",_LPIssueDeskTransVO.getStrPoNo(), 30);
					dao.setProcOutValue(procIndex1, "err", 1, 31); 
					dao.execute(procIndex1,1);
					/* Setting Default Value End */
				}

			}
			
			if(mcu.getStrBillingIntegration().equals("1"))		//added by shalini to enter data in billing
			{
				System.out.println("------------- bill_interface.dml_online_billreq_drugs [Mode - 1 ] -----------------");
				
				if(_LPIssueDeskTransVO.getStrPatientType().equals("1")){
				int procIndex2;
				procIndex2 = dao.setProcedure(proc_name2);
				dao.setProcInValue(procIndex2, "modval", "1", 1); // 1
				dao.setProcInValue(procIndex2, "gnum_dept_code", _LPIssueDeskTransVO.getStrDeptCode(), 2);
				dao.setProcInValue(procIndex2, "sblnum_chargetype_id", "2", 3);
				dao.setProcInValue(procIndex2, "sblnum_service_id", "5", 4);
				dao.setProcInValue(procIndex2, "gstr_req_no", strReturnNo+"#2#"+_LPIssueDeskTransVO.getStrDossierShortName(), 5);
				dao.setProcInValue(procIndex2, "gnum_treatment_cat", _LPIssueDeskTransVO.getStrTreatmentCat(),6);
				dao.setProcInValue(procIndex2, "hrgnum_episode_code", _LPIssueDeskTransVO.getStrEpisodeCode(), 7);
				dao.setProcInValue(procIndex2, "hrgnum_puk", _LPIssueDeskTransVO.getStrCrNo(), 8);
				dao.setProcInValue(procIndex2, "hblnum_pat_lfaccount_no", "0", 9);
				dao.setProcInValue(procIndex2, "gstr_tariff", strBillTariff, 10);
				dao.setProcInValue(procIndex2, "gstr_tariff_batch", strBillBatch, 11);
				dao.setProcInValue(procIndex2, "gstr_tariff_rates", strBillRate, 12);
				dao.setProcInValue(procIndex2, "gstr_reqqty", strBillQty, 13);
				dao.setProcInValue(procIndex2, "hblstr_patient_name", "", 14);
				dao.setProcInValue(procIndex2, "hblstr_pat_address", "", 15);
				dao.setProcInValue(procIndex2, "hblstr_contact_no", "", 16);
				dao.setProcInValue(procIndex2, "age", "1", 17);
				dao.setProcInValue(procIndex2, "ageunit", "1", 18);
				dao.setProcInValue(procIndex2, "gender", "1", 19);
				dao.setProcInValue(procIndex2, "refdoctor", "1", 20);
				dao.setProcInValue(procIndex2, "refdoccontactno", "1", 21);
				dao.setProcInValue(procIndex2, "gnum_seatid", _LPIssueDeskTransVO.getStrSeatId(), 22);
				dao.setProcInValue(procIndex2, "hosp_code", _LPIssueDeskTransVO.getStrHospitalCode(), 23);
				dao.setProcInValue(procIndex2, "ward_code", _LPIssueDeskTransVO.getStrWardCode(), 24);
				dao.setProcInValue(procIndex2, "admno", _LPIssueDeskTransVO.getStrAdmissionNo(), 25);
				dao.setProcInValue(procIndex2, "visitno", _LPIssueDeskTransVO.getStrVisitNo(), 26);
				dao.setProcOutValue(procIndex2, "err", 1, 27);
				dao.execute(procIndex2, 1);
				}else{
					
					
					System.out.println("------------- bill_interface.dml_online_billreq_refund [Mode - 1 ] -----------------");
					
					String strProcName3 = "{call bill_interface.dml_online_billreq_refund(?,?,?,?,? ,?,?,?,?,? ,?,?,?)}";
					int nProcIndex3 = dao.setProcedure(strProcName3);
					dao.setProcInValue(nProcIndex3, "modval", "1",1);
					dao.setProcInValue(nProcIndex3, "sblnum_chargetype_id", "1",2);
					dao.setProcInValue(nProcIndex3, "sblnum_service_id", "5",3);
					dao.setProcInValue(nProcIndex3, "gstr_req_no", _LPIssueDeskTransVO.getStrGstrReqNo(),4);
					dao.setProcInValue(nProcIndex3, "gnum_treatment_cat", "11",5);
					dao.setProcInValue(nProcIndex3, "hrgnum_puk", _LPIssueDeskTransVO.getStrCrNo(),6);
					dao.setProcInValue(nProcIndex3, "gstr_tariff", strBillTariff,7);
					dao.setProcInValue(nProcIndex3, "gstr_reqqty", strBillQty,8);
					dao.setProcInValue(nProcIndex3, "gnum_seatid", _LPIssueDeskTransVO.getStrSeatId(),9);
					dao.setProcInValue(nProcIndex3, "hosp_code", _LPIssueDeskTransVO.getStrHospitalCode(),10);
					dao.setProcInValue(nProcIndex3, "admno", "0",11);
					dao.setProcInValue(nProcIndex3, "remarks", "Return From CR No :: "+_LPIssueDeskTransVO.getStrCrNo(),12);
					dao.setProcOutValue(nProcIndex3, "err", 1,13);
					dao.execute(nProcIndex3, 1);
						
					
				}
			}
				

			// commented by vikrant after discussion

			/*
			 * proc_name1=""; proc_name1 =
			 * "{call pkg_mms_dml.DML_RETURN_SUPPLIER_DTL(?,?,?,?,?,?,?,?,?)}";
			 * procIndex1 = dao.setProcedure(proc_name1);
			 * dao.setProcInValue(procIndex1, "modval","2",1); //1
			 * dao.setProcInValue(procIndex1, "strId",
			 * _LPIssueDeskTransVO.getStrStoreId(),2); //2
			 * dao.setProcInValue(procIndex1, "hosp_code",
			 * _LPIssueDeskTransVO.getStrHospitalCode(),3); // 3
			 * dao.setProcInValue(procIndex1,
			 * "itemcatNo",_LPIssueDeskTransVO.getStrItemCategNo(),4); // 4
			 * dao.setProcInValue(procIndex1,
			 * "seatId",_LPIssueDeskTransVO.getStrSeatId(),5);
			 * dao.setProcInValue(procIndex1, "challanNo","0",6); //Default
			 * Value. dao.setProcInValue(procIndex1, "returnNo",strReturnNo,7);
			 * dao.setProcInValue(procIndex1,
			 * "issueNo",_LPIssueDeskTransVO.getStrIssueNo(),8);
			 * dao.setProcOutValue(procIndex1, "err",1,9);
			 * dao.executeProcedureByPosition(procIndex1);
			 */
			
			synchronized (dao) {
				dao.fire();
			}
			
			System.out.println("------------- END -----------------");


		} catch (Exception _err) {
			_err.printStackTrace();
			_LPIssueDeskTransVO
					.setStrMsgString("LPIssueDeskTransDAO.insertData() --> "
							+ _err.getMessage());
			_LPIssueDeskTransVO.setStrMsgType("1");
		}
	}

	/**
	 * This function is used to set details in approved By Combo.
	 * 
	 * @param _BreakageItemDtlTransVO
	 */
	public static void getApprovedByCombo(LPIssueDeskTransVO _LPIssueDeskTransVO) {

		String strProcName = "{call PKG_MMS_VIEW.proc_consultant_name(?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		WebRowSet ws = null;
		HisDAO daoObj = null;
		try {
			daoObj = new HisDAO("MMSModule", "LPIssueDeskTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code",
					_LPIssueDeskTransVO.getStrHospitalCode(), 3);
			daoObj.setProcInValue(nProcIndex, "seatId",
					_LPIssueDeskTransVO.getStrSeatId(), 4);

			daoObj.setProcInValue(nProcIndex, "deptunitcode", "0", 2); // Default
																		// value.

			daoObj.setProcOutValue(nProcIndex, "err", 1, 5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				_LPIssueDeskTransVO.setApprovedBy(ws);
			}
		} catch (Exception _err) {
			_LPIssueDeskTransVO
					.setStrMsgString("LPIssueDeskTransDAO.getApprovedByCombo() --> "
							+ _err.getMessage());
			_LPIssueDeskTransVO.setStrMsgType("1");
		}
	}

	public static void getDeptName(LPIssueDeskTransVO _LPIssueDeskTransVO) {

		HisDAO dao = null;
		int funcIndex = 0;
		String strDeptName = "";
		try {

			dao = new HisDAO("MMSModule", "LPIssueDeskTransDAO");
			funcIndex = dao
					.setFunction("{? = call MMS_MST.get_store_dtl(?,?,?)}");
			// Set Value

			dao.setFuncInValue(funcIndex, 2, "3");
			dao.setFuncInValue(funcIndex, 3,
					_LPIssueDeskTransVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4,
					_LPIssueDeskTransVO.getStrRaisingStoreId());
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			strDeptName = dao.getFuncString(funcIndex);
			if (strDeptName != null && !strDeptName.equals("null"))
				_LPIssueDeskTransVO.setStrDeptName(strDeptName);
			else
				_LPIssueDeskTransVO.setStrDeptName("-");
		} catch (Exception _err) {
			_err.printStackTrace();
			_LPIssueDeskTransVO
					.setStrMsgString("LPIssueDeskTransDAO.getDeptName() --> "
							+ _err.getMessage());
			_LPIssueDeskTransVO.setStrMsgType("1");
		}

	}
	
	/*added by shalini & is used To get the Account info.*/
	public static void getPatientAccountDetails(LPIssueDeskTransVO vo) {

	
		String strProcName = "{call PKG_MMS_VIEW.proc_hstt_pat_account_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		WebRowSet ws = null;
		HisDAO daoObj = null;
		try {
			daoObj = new HisDAO("MMSModule", "LPIssueDeskTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(), 2);
			daoObj.setProcInValue(nProcIndex, "cr_no", vo.getStrCrNo(), 3);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 5);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setPatAccountDtl(ws);
			}
		} catch (Exception _err) {
			vo
					.setStrMsgString("LPIssueDeskTransDAO.getPatientAccountBalance() --> "
							+ _err.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void getPatientDiagDetails(LPIssueDeskTransVO vo)
	{
		
		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";
		
    	try 
		{
    		String strProcName = "{call PKG_MMS_VIEW.proc_diag_emp_view(?,?::varchar,?::varchar,?,?)}";

			daoObj = new HisDAO("MMS Transactions","LPIssueDeskTransDAO");
			
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
			vo.setStrMsgString("--> LPIssueDeskTransDAO.getPatientDiagDetails()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null)
				daoObj.free();
				daoObj = null;
			}

	}

	/**
	 * This function is used to GET THE BATCH WISE ITEM DETAILS FOR POPUP.
	 * 
	 * @param vo
	 *            the vo
	 * @return the single batch item dtl
	 */
	public static void getSingleBatchItemDtl(LPIssueDeskTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			dao = new HisDAO("mms", "LPIssueDeskTransDAO");
			
			strProcName = "{call Pkg_Mms_View.proc_itemStock_dtl(?,?,?,?,?,?,?,?,?,?,?)}";
			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modeval", "6");
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nProcIndex, "item_id", vo.getStrSingleItemDtl()
					.split("\\^")[0]);
			dao.setProcInValue(nProcIndex, "itembrand_id", vo
					.getStrSingleItemDtl().split("\\^")[1]);
			dao.setProcInValue(nProcIndex, "store_id", vo.getStrSingleItemDtl()
					.split("\\^")[3]);
			dao.setProcInValue(nProcIndex, "batch_no", vo.getStrSingleItemDtl()
					.split("\\^")[2]);
			dao.setProcInValue(nProcIndex, "item_sl_no", "0");
			dao.setProcInValue(nProcIndex, "sl_no", "0");
			dao.setProcInValue(nProcIndex, "reserved_flag", "0");
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);

			dao.executeProcedure(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				vo.setStrSingleBatchDtlWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("LPIssueDeskTransDAO.getSingleBatchItemDtl() --> "
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
	 * This function is used to GET THE BATCH WISE ITEM DETAILS FOR POPUP.
	 * 
	 * @param vo
	 *            the vo
	 * @return the branded/non branded item details
	 */
	public static void getBrandDetails(LPIssueDeskTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			dao = new HisDAO("mms", "LPIssueDeskTransDAO");
			
			strProcName = "{call Pkg_Mms_View.proc_brand_list(?,?,?,?,? ,?)}";
			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modeval", "1");
			dao.setProcInValue(nProcIndex, "storeid", vo.getStrStoreId());
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nProcIndex, "itemid", vo.getStrItemId());			
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);

			dao.executeProcedure(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				vo.setBrandDtlWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("LPIssueDeskTransDAO.getSingleBatchItemDtl() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
	public static void getIssueDtlsList(LPIssueDeskTransVO vo) 
	{
		String err;
		//String strSlNoflg;
		HisDAO        dao = null;
		WebRowSet      ws = null;
		int    procIndex1 = 0;
		String proc_name1 = "{call pkg_dossier_view.Proc_Emp_Issue_Detail(?,?,?,?,?,?)}"; //6
		try 
		{
			/*
			  Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line Issue Voucher)
			  1.Hospital Name ^ DDC Name ^ Prescribe For ^ Issue No ^ Issued By Doctor ^ Date ^ Cr No ^ Hindi Text  
			  2.Drug Name
			  3.Batch No 
			  4.Exp Date
			  5.Issue Qty
			 */				
			dao = new HisDAO("mms","global.IssueTransDAO.getStockItemDtlsList(DossierRequisitionVO vo)");			
			procIndex1 = dao.setProcedure(proc_name1);
			// set value
			//System.out.println("vo.getStrStoreId()::"+vo.getStrStoreId());
			//System.out.println("issueNo::"+ vo.getStrIssueNo());
			//System.out.println("hosp_code"+ vo.getStrHospitalCode());
			
			
			if(vo.getStrMode().equals("4"))
				dao.setProcInValue(procIndex1, "modeval", "4",1);
			else
				dao.setProcInValue(procIndex1, "modeval", "3",1);
			dao.setProcInValue(procIndex1, "strId", vo.getStrStoreId(),3);
			if(vo.getStrIssueNo()==null || vo.getStrIssueNo()=="")
				dao.setProcInValue(procIndex1, "issueNo", "0",2);
			else
			dao.setProcInValue(procIndex1, "issueNo", vo.getStrIssueNo(),2);
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),4);
			dao.setProcOutValue(procIndex1,"ERR", 1,5); // 1 for string return
			dao.setProcOutValue(procIndex1, "RESULTSET", 2,6); // 2 for object
			// execute procedure
			dao.executeProcedureByPosition(procIndex1);
			// get value
			err = dao.getString(procIndex1, "ERR");
			if (err == null)
				err = "";
			ws = dao.getWebRowSet(procIndex1, "RESULTSET");
			vo.setWsIssueDetails(ws);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
            //e.printStackTrace();
			vo.setStrMsgString("IssueTransDAO.getIssueDtlsList() --> "+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
	public static void getIssueDtlsListExtra(LPIssueDeskTransVO vo) 
	{
		String err;
		//String strSlNoflg;
		HisDAO        dao = null;
		WebRowSet      ws = null;
		int    procIndex1 = 0;
		String proc_name1 = "{call pkg_dossier_view.Proc_Emp_Issue_Detail(?,?,?,?,?,?)}"; //6
		try 
		{
			
			
			
			/*
			  Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line Issue Voucher)
			  1.Hospital Name ^ DDC Name ^ Prescribe For ^ Issue No ^ Issued By Doctor ^ Date ^ Cr No ^ Hindi Text  
			  2.Drug Name
			  3.Batch No 
			  4.Exp Date
			  5.Issue Qty
			 */				
			dao = new HisDAO("mms","global.IssueTransDAO.getStockItemDtlsList(DossierRequisitionVO vo)");			
			procIndex1 = dao.setProcedure(proc_name1);
			// set value
			
			System.out.println("-------pkg_dossier_view.Proc_Emp_Issue_Detail---[ Mode - 5 ]-----");
			System.out.println("vo.getStrStoreId()--------"+ vo.getStrStoreId());
			System.out.println("issueNo-------------------"+ vo.getStrIssueNo());
			System.out.println("hosp_code-----------------"+ vo.getStrHospitalCode());
			
			dao.setProcInValue(procIndex1, "modeval", "5",1);
			dao.setProcInValue(procIndex1, "strId", vo.getStrStoreId(),3);
			
			if(vo.getStrIssueNo()==null || vo.getStrIssueNo()=="")
				dao.setProcInValue(procIndex1, "issueNo", "0",2);
			else
			dao.setProcInValue(procIndex1, "issueNo", vo.getStrIssueNo(),2);
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),4);
			dao.setProcOutValue(procIndex1,"ERR", 1,5); // 1 for string return
			dao.setProcOutValue(procIndex1, "RESULTSET", 2,6); // 2 for object
			// execute procedure
			dao.executeProcedureByPosition(procIndex1);
			// get value
			err = dao.getString(procIndex1, "ERR");
			if (err == null)
				err = "";
			ws = dao.getWebRowSet(procIndex1, "RESULTSET");
			vo.setWsExtraIssueDetails(ws);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
            //e.printStackTrace();
			vo.setStrMsgString("IssueTransDAO.getIssueDtlsList() --> "+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
	public static void getIssueNoDtls(LPIssueDeskTransVO vo) {

		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("dossier", "LPIssueDeskTransDAO");

			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.IssueNo.0");
			nQueryIndex = dao.setQuery(strQuery);
	        
	        dao.setQryValue(nQueryIndex, 1, vo.getStrLpRequestNo());
	        dao.setQryValue(nQueryIndex, 2, vo.getStrHospitalCode());
	        

	        web = dao.executeQry(nQueryIndex);
	        
	        if(web.next()){
	        	vo.setStrIssueNo(web.getString(1));
	        }
	        
	        
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DossierMstDAO.getIssueNoDtls() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			web = null;
		}
	}
	
	public static void getReturnNoDtls(LPIssueDeskTransVO vo) {

		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("dossier", "LPIssueDeskTransDAO");

			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.ReturnNo.0");
			nQueryIndex = dao.setQuery(strQuery);
	        
	        dao.setQryValue(nQueryIndex, 1, vo.getStrIssueNo());
	        dao.setQryValue(nQueryIndex, 2, vo.getStrHospitalCode());
	        

	        web = dao.executeQry(nQueryIndex);
	        
	        if(web.next()){
	        	vo.setStrReturnNo(web.getString(1));
	        }
	        
	        
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DossierMstDAO.getReturnNoDtls() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			web = null;
		}
	}
}
