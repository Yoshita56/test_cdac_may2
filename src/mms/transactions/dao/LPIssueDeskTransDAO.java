package mms.transactions.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.MmsConfigUtil;
import mms.transactions.vo.LPIssueDeskTransVO;
import mms.transactions.vo.RequestForLPPatientVO;


public class LPIssueDeskTransDAO 
{
	
	public static void getIndentDetail(LPIssueDeskTransVO vo) 
	{
		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_indent_dtl(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		StringBuffer sb = new StringBuffer("");

		try 
		{
			System.out.println("-------------  LPIssueDeskTransDAO . getIndentDetail  --------------");
			System.out.println("-------------  pkg_mms_view.proc_indent_dtl  --[ Mode - 1 ]------------");
			
			dao = new HisDAO("MMS","IssueDeskTransDAO.getIndentDetail(IssueDeskTransVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modeval",    "1",1);
			dao.setProcInValue(procIndex1, "hosp_code",  vo.getStrHospitalCode(),2);
			dao.setProcInValue(procIndex1, "indent_no",  vo.getStrLpRequestNo(),3);
			dao.setProcInValue(procIndex1, "store_id",   vo.getStrRaisingStoreId(),4);						
			dao.setProcInValue(procIndex1, "itemcat_no", "",5); 


			dao.setProcOutValue(procIndex1, "err", 1,6); // 1 for string return
			dao.setProcOutValue(procIndex1, "resultset", 2,7); // 2 for object

			dao.executeProcedureByPosition(procIndex1);

			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			if (err.equals("")) 
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");

				if (ws.size() > 0) 
				{
					ws.next();					
					
					
					// Suresh Bhuma @ 1 - CR No 379132000278438 Indent Approval # 2 - All Half Out of 4 In Indent
					//System.out.println("-- All Remarks------"+ws.getString(9));
					
					sb.append("<table width='width: 100%;' align='left' cellpadding='1px' cellspacing='1px' border='0px'> ");
					
					
					
					sb.append("<tr>");
					sb.append("<td><b>Indent Remarks : </b></td>");
					sb.append("<td>"+ws.getString(9).split("\\@")[0]+"</td>");
					sb.append("</tr>");
					
					String approvalRemarks = ws.getString(9).split("\\@")[1];
					
					String rArr[] = approvalRemarks.split("\\#");
					
					for(int i = 0 ; i< rArr.length ; i++)
					{
						sb.append("<tr>");
						sb.append("<td><b>App Level - "+(approvalRemarks.split("\\#")[i]).split("\\-")[0]+" Remarks : </b></td>");
						sb.append("<td>"+(approvalRemarks.split("\\#")[i]).split("\\-")[1]+"</td>");
						sb.append("</tr>");
					}
					sb.append("</table>");
					
					//System.out.println("-Remarks Table------"+sb.toString());
					
					vo.setStrRemarks(sb.toString());
					
				}
			} 
			else 
			{
				throw new Exception(err);
			}
		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("IssueDeskTransDAO.getIndentDetail() --> "+ e.getMessage());
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
	 * To get Indent Details i.e.(Store Name,Indent No.,Indent Date,Indent
	 * Type,Item Category,Raising Store) on 'issue' page
	 * 
	 * @param vo
	 */
	public static void getLPRequestDetail(LPIssueDeskTransVO _LPIssueDeskTransVO) {

		String err = "";
		

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		int funcIndex;
		String BillingValue="";
		try {
			
			System.out.println("-------------  LPIssueDeskTransDAO . getLPRequestDetail  --------------");
			System.out.println("-------------  bill_mst.get_pat_accountdetails_limit  --------------");
			
			
			
			dao = new HisDAO("mms","LPIssueDeskTransDAO.getIndentDetail(LPIssueDeskTransVO vo)");
			funcIndex = dao.setFunction("{? = call bill_mst.get_pat_accountdetails_limit(?,?,?)}");

			dao.setFuncInValue(funcIndex, 2,_LPIssueDeskTransVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3,"2");
			dao.setFuncInValue(funcIndex, 4,_LPIssueDeskTransVO.getStrCrNo());			
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			BillingValue = dao.getFuncString(funcIndex); 			
			_LPIssueDeskTransVO.setStrBillingHiddenValue(BillingValue);		
			
			System.out.println("-------------  pkg_mms_view.proc_hstt_lp_req_item_dtl  ------[Mode - 1]--------");
			
			String proc_name1 = "{call pkg_mms_view.proc_hstt_lp_req_item_dtl(?,?,?,?,?,?,?)}";

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modval", 	       "1", 1);
			dao.setProcInValue(procIndex1, "lPRequestNo",	   _LPIssueDeskTransVO.getStrLpRequestNo(), 2);
			dao.setProcInValue(procIndex1, "strRasingStoreId", _LPIssueDeskTransVO.getStrRaisingStoreId(), 3);
			dao.setProcInValue(procIndex1, "hosp_code",	       _LPIssueDeskTransVO.getStrHospitalCode(), 4);		
			dao.setProcInValue(procIndex1, "strRequestDate",   "", 5);
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
	
	public static void getLPRequestDetail_new(LPIssueDeskTransVO _LPIssueDeskTransVO) {

		String err = "";
		

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		int funcIndex;
		String BillingValue="";
		try {
			
			System.out.println("-------------  LPIssueDeskTransDAO . getLPRequestDetail_new  --------------");
			System.out.println("-------------  bill_mst.get_pat_accountdetails_limit  --------------");
			
			

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
			//System.out.println("BillingValue"+BillingValue);
			_LPIssueDeskTransVO.setStrBillingHiddenValue(BillingValue);
			
			System.out.println("-------------  pkg_mms_view.proc_hstt_lp_req_item_dtl  ------[Mode - 2]--------");
			String proc_name1 = "{call pkg_mms_view.proc_hstt_lp_req_item_dtl(?,?,?,?,?,?,?)}";
			
			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modval", "2", 1);
			dao.setProcInValue(procIndex1, "lPRequestNo",_LPIssueDeskTransVO.getStrBSReqNo(), 2);

			dao.setProcInValue(procIndex1, "strRasingStoreId",_LPIssueDeskTransVO.getStrStoreId(), 3);

			dao.setProcInValue(procIndex1, "hosp_code",	_LPIssueDeskTransVO.getStrHospitalCode(), 4);

			/* Setting Default Value Start */

			dao.setProcInValue(procIndex1, "strRequestDate", "", 5);
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
		String proc_name1 = "{call pkg_mms_view.Proc_patemp_issue_item_dtl(?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		int funcIndex;
		String BillingValue="";
		try {

			dao = new HisDAO("mms",
					"LPIssueDeskTransDAO.getIndentDetail(LPIssueDeskTransVO vo)");
			
			System.out.println("------------- bill_mst.get_pat_accountdetails_limit  --------------");
			
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

			//System.out.println(_LPIssueDeskTransVO.getStrIssueNo() + " "					+ _LPIssueDeskTransVO.getStrIssueStoreId() + " "					+ _LPIssueDeskTransVO.getStrHospitalCode());

			System.out.println("------------- pkg_mms_view.Proc_patemp_issue_item_dtl  -----[ Mode - 2]---------");
			
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "modval", "2", 1);

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
	
	
	
	public static void getIssuedItemDtlview(LPIssueDeskTransVO _LPIssueDeskTransVO) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.Proc_patemp_issue_item_dtl(?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {
			
			System.out.println("-------------  LPIssueDeskTransDAO . getIssuedItemDtlview  --------------");
			
			System.out.println("-------------  pkg_mms_view.Proc_patemp_issue_item_dtl  ------[Mode - 3,4]--------");
			

			dao = new HisDAO("mms",
					"LPIssueDeskTransDAO.getIndentDetail(LPIssueDeskTransVO vo)");

			//System.out.println(_LPIssueDeskTransVO.getStrIssueNo() + " "					+ _LPIssueDeskTransVO.getStrIssueStoreId() + " "					+ _LPIssueDeskTransVO.getStrHospitalCode());

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
			
	        System.out.println("-------------  LPIssueDeskTransDAO . getReturnUnitCombo  --------------");
			
			System.out.println("-------------  pkg_mms_view.proc_GBLT_UNIT_MST  ------[Mode - 4]--------");
			
			
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
		String proc_name1 = "{call pkg_mms_view.Proc_hstt_chall_verifiitem_dtl(?,?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {
			
			 System.out.println("-------------  LPIssueDeskTransDAO . getIssueItemDtl  --------------");
				
			 System.out.println("-------------  pkg_mms_view.Proc_hstt_chall_verifiitem_dtl  ------[Mode - 3]--------");

			dao = new HisDAO("mms","LPIssueDeskTransDAO.getIssueItemDtl(LPIssueDeskTransVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modval", "3", 1);
			dao.setProcInValue(procIndex1, "strId",	_LPIssueDeskTransVO.getStrRaisingStoreId(), 2);
			dao.setProcInValue(procIndex1, "lPRequestNo",	_LPIssueDeskTransVO.getStrLpRequestNo(), 3);
			dao.setProcInValue(procIndex1, "hosp_code",	_LPIssueDeskTransVO.getStrHospitalCode(), 4);
			dao.setProcInValue(procIndex1, "poNo",	_LPIssueDeskTransVO.getStrPoNo(), 5);
			dao.setProcInValue(procIndex1, "poStoreId",	_LPIssueDeskTransVO.getStrPoStoreId(), 6);

		
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
				//System.out.println("ws.size()" + ws.size());
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
		String proc_name1 = "{call pkg_mms_view.Proc_hstt_chall_verifiitem_dtl(?,?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {
			
			 System.out.println("-------------  LPIssueDeskTransDAO . getIssueItemDtl_new  --------------");
				
			 System.out.println("-------------  pkg_mms_view.Proc_hstt_chall_verifiitem_dtl  ------[Mode - 5]--------");

			dao = new HisDAO("mms",
					"LPIssueDeskTransDAO.getIssueItemDtl(LPIssueDeskTransVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modval", "5", 1);
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
				//System.out.println("ws.size()" + ws.size());
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

	public static void insertData_New(LPIssueDeskTransVO _LPIssueDeskTransVO) 
	{
		String proc_name1 = "";		
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
		
		String                       values[] = null;
		String bsReqNo="0";
		int pIndex;
		String p_name="";
		int nProcIndex = 0;
		WebRowSet ws = null;
		String strErr = "";
		
		try 
		{
			System.out.println("---------LPIssueDeskTransDAO.insertData---------");
			
			dao = new HisDAO("mms","LPIssueDeskTransDAO.insertData(_LPIssueDeskTransVO)");
			length = _LPIssueDeskTransVO.getStrItemParamValue().length;
			
			System.out.println("---------MMS_MST.generate_issueNo---------");
			
			System.out.println("--------["+_LPIssueDeskTransVO.getStrRequestTypeId()+" - 31- Issue To Store  , 35 - Issue To Pateint IPD , 32 - Issue To Patient Direct ]-------");

			funcIndex = dao.setFunction("{? = call MMS_MST.generate_issueNo(?,?,?,?)}");

			dao.setFuncInValue(funcIndex, 2,_LPIssueDeskTransVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3,_LPIssueDeskTransVO.getStrStoreId());
			dao.setFuncInValue(funcIndex, 4,_LPIssueDeskTransVO.getStrRequestTypeId());
			dao.setFuncInValue(funcIndex, 5,_LPIssueDeskTransVO.getStrItemCategNo());
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			strIssueNo = dao.getFuncString(funcIndex); 
			
			strIssueNo = strIssueNo.split("\\^")[0];
			
			System.out.println("-------------------------------------");
			System.out.println("strIssueNo----------"+strIssueNo);	
			System.out.println("strItemBrandId------"+strItemBrandId);
			System.out.println("strBatchSlNo--------"+strBatchSlNo);
			System.out.println("strRequestNo--------"+_LPIssueDeskTransVO.getStrLpRequestNo());
			System.out.println("deptcode------------"+_LPIssueDeskTransVO.getStrDeptCode());
			System.out.println("treatmentcatg-------"+_LPIssueDeskTransVO.getStrTreatmentCat());
			System.out.println("episodecode---------"+_LPIssueDeskTransVO.getStrEpisodeCode());
			System.out.println("wardcode------------"+_LPIssueDeskTransVO.getStrWardCode());
			System.out.println("addmissionno--------"+_LPIssueDeskTransVO.getStrAdmissionNo());
			System.out.println("visitno-------------"+_LPIssueDeskTransVO.getStrVisitNo());
			System.out.println("-----------------------------------");
			
			_LPIssueDeskTransVO.setStrIssueNo(strIssueNo);
			temp = _LPIssueDeskTransVO.getStrItemParamValue()[0].replace('@','#').split("#");
			strIssueUnitId = temp[3];
			strRateUnitId = temp[3];
			strIssueQty = temp[2];			
			proc_name1="";
			
			proc_name1 = "{call pkg_mms_dml.dml_hstt_patemp_issue_item_dtl_with_billing(?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?,  ?,?,?,?,?   ?,?,?,?,? ,  ?,?,?)}"; // 33 Variables
			
			for (int i = 0; i < _LPIssueDeskTransVO.getStrItemParamValue().length; i++) 
			{
				if (!_LPIssueDeskTransVO.getStrIssueQuantity()[i].equals("0") && !_LPIssueDeskTransVO.getStrIssueQuantity()[i].equals("0.00") ) 
				{					
					if (_LPIssueDeskTransVO.getStockDtlsId()!=null)
					{
						if (!_LPIssueDeskTransVO.getStockDtlsId()[i].equals("")) 
						{
							
							System.out.println("------- When Batch Selected From Stock  -------");
								
							values = _LPIssueDeskTransVO.getStockDtlsId()[i].split("#"); 
		                    //    0       1         		2			3	            4        5         6           7                8               9               10                  11              12      13          14           15          16   17  18      19       
							// StoreId^Generic_ItemId^Brand_ItemId^Stock_Status_Code^Batch_No^Serial_No^Expiry date^Manufactre Date^In Hand Qty ^ In Hand Qty Unit ^ Purchase Rate ^ Purchase Rate Unit ^ Rate ^ Rate Unit ^ Issue Qty ^ Issue Qty Unit ^   ^   ^ Cost ^ Cost
							// 99901120^10000067^10100067^UIT11738^10^0^31-May-2014^01-Dec-2011^24990^6301^21.54^6306^22.62^6306^10^6301^1^0^2.26^2.26
							batchLength = values.length;
							for (int j = 0; j < batchLength; j++) 
							{
								temp 				= values[j].replace("^", "#").split("#");
								strItemBrandId 		= temp[2];
								strItemId 			= temp[1];
								strRate				= temp[12];
								strRateUnitId		= temp[13];							
								strGroupId 			= "";
								strSubGroupId 		= "";
								if(temp[3].equals("-1") || (temp[3]=="-1"))
								{
								    strBatchSlNo 		= "0";
								}
								else
								{
									strBatchSlNo 		= temp[3];	
								}
								strExpiryDate 		= temp[6].trim();								
								strIssueQty 		= temp[14];
								strStoreId 			= _LPIssueDeskTransVO.getStrStoreId();
								hosp_code 			= _LPIssueDeskTransVO.getStrHospitalCode();
								strItemSlNo 		= "0";
								strStockStatus 		= "10";
								strManuFactDate 	= temp[7];
								strConsumableFlag 	= "1";
								strRemarks 			= _LPIssueDeskTransVO.getStrRemarks();								
								strIssueUnitId 		= temp[15];
								 							
								System.out.println("---A------"+proc_name1+"---[ Mode -1 ]---"+i+"---");
								
								
								
								procIndex1 = dao.setProcedure(proc_name1);										
								dao.setProcInValue(procIndex1, "modval", 			"1", 		1); 
								dao.setProcInValue(procIndex1, "strItemBrandId",	strItemBrandId, 2); // 1
								dao.setProcInValue(procIndex1, "strItemId", 		strItemId, 3); // 2
								dao.setProcInValue(procIndex1, "strRate", 			strRate, 4); // 3
								dao.setProcInValue(procIndex1, "strRateUnitId",		strRateUnitId, 5); // 4
								dao.setProcInValue(procIndex1, "strGroupId", 		strGroupId, 6); // 5?
								dao.setProcInValue(procIndex1, "strSubGroupId",		strSubGroupId, 7); // 6?
								dao.setProcInValue(procIndex1, "strBatchSlNo",		strBatchSlNo, 8); // 7
								dao.setProcInValue(procIndex1, "strExpiryDate",		strExpiryDate.trim(), 9); // 8
								dao.setProcInValue(procIndex1, "strIssueQty", 		strIssueQty,10);
								dao.setProcInValue(procIndex1, "strIssueUnitId",	strIssueUnitId, 11); // 10
								dao.setProcInValue(procIndex1, "strStoreId", 		strStoreId, 12); // 11
								dao.setProcInValue(procIndex1, "strIssueNo", 		strIssueNo, 13); // 12
								dao.setProcInValue(procIndex1, "hosp_code", 		hosp_code, 14); // 13
								dao.setProcInValue(procIndex1, "strItemSlNo", 		strItemSlNo,15); // 14
								dao.setProcInValue(procIndex1, "strStockStatus",	strStockStatus, 16); // 15
								dao.setProcInValue(procIndex1, "strManuFactDate",	strManuFactDate.trim(), 17); // 16
								dao.setProcInValue(procIndex1, "strConsumableFlag",	strConsumableFlag, 18); // 17
								dao.setProcInValue(procIndex1, "strRemarks", 		strRemarks, 19); // 18
								dao.setProcInValue(procIndex1, "strItemCost",		Double.toString(Math.round((Double.parseDouble(strIssueQty)*Double.parseDouble(strRate))*100.0)/100.0),20); // 19?
								dao.setProcInValue(procIndex1, "strRequestNo",		_LPIssueDeskTransVO.getStrLpRequestNo(), 21); // 20?
								dao.setProcInValue(procIndex1, "strRasingStoreId",	_LPIssueDeskTransVO.getStrRaisingStoreId(), 22);
								dao.setProcInValue(procIndex1, "strItemCatNo",		_LPIssueDeskTransVO.getStrItemCategNo(), 23); // 21
								dao.setProcInValue(procIndex1, "strSeatid",			_LPIssueDeskTransVO.getStrSeatId(), 24);
								dao.setProcInValue(procIndex1, "strDescription",	_LPIssueDeskTransVO.getStrDescription(), 25);
								dao.setProcInValue(procIndex1, "crno",				_LPIssueDeskTransVO.getStrCrNo(), 26);								
								dao.setProcInValue(procIndex1, "deptcode",			_LPIssueDeskTransVO.getStrDeptCode(), 27);
								dao.setProcInValue(procIndex1, "treatmentcatg",		_LPIssueDeskTransVO.getStrTreatmentCat(), 28);
								dao.setProcInValue(procIndex1, "episodecode",		_LPIssueDeskTransVO.getStrEpisodeCode(), 29);
								dao.setProcInValue(procIndex1, "wardcode",			_LPIssueDeskTransVO.getStrWardCode(), 30);
								dao.setProcInValue(procIndex1, "addmissionno",		_LPIssueDeskTransVO.getStrAdmissionNo(), 31);
								dao.setProcInValue(procIndex1, "visitno",			_LPIssueDeskTransVO.getStrVisitNo(), 32);								
								dao.setProcOutValue(procIndex1, "err",				1, 33); // 22
								dao.execute(procIndex1,1);
									
							}  // End For Loop
						}
						else
						{
							
							System.out.println("------- Auto Deduct From Stock  -------");
							
							System.out.println("---Param Value--["+i+"]----"+_LPIssueDeskTransVO.getStrItemParamValue()[i]);
							
							temp 				= _LPIssueDeskTransVO.getStrItemParamValue()[i].replace('@', '#').split("#");
							strItemBrandId 		= temp[1];
							strItemId 			= temp[0];
							strRate 			= temp[6];						
							strGroupId 			= temp[7];
							strSubGroupId 		= "";
							if(temp[5].equals("-1") || (temp[5]=="-1"))
							{
							    strBatchSlNo 		= "0";
							}
							else
							{
								strBatchSlNo 		= temp[5];	
							}
							//strBatchSlNo 		= temp[5];						
							strIssueQty 		= _LPIssueDeskTransVO.getStrIssueQuantity()[i].split(" ")[0];
							strStoreId 			= _LPIssueDeskTransVO.getStrStoreId();
							hosp_code 			= _LPIssueDeskTransVO.getStrHospitalCode();
							strItemSlNo 		= "0";
							strStockStatus 		= "10";						
							strConsumableFlag 	= "1";
							strRemarks 			= _LPIssueDeskTransVO.getStrRemarks();						
							strIssueUnitId 		= temp[3];
																		
							System.out.println("---B------"+proc_name1+"---[ Mode -1 ]---"+i+"---");
													
							procIndex1 = dao.setProcedure(proc_name1);										
							dao.setProcInValue(procIndex1, "modval", 			"1", 		1); 
							dao.setProcInValue(procIndex1, "strItemBrandId",	strItemBrandId, 2); // 1
							dao.setProcInValue(procIndex1, "strItemId", 		strItemId, 3); // 2
							dao.setProcInValue(procIndex1, "strRate", 			strRate, 4); // 3
							dao.setProcInValue(procIndex1, "strRateUnitId",		strRateUnitId, 5); // 4
							dao.setProcInValue(procIndex1, "strGroupId", 		strGroupId, 6); // 5?
							dao.setProcInValue(procIndex1, "strSubGroupId",		strSubGroupId, 7); // 6?
							dao.setProcInValue(procIndex1, "strBatchSlNo",		strBatchSlNo, 8); // 7
							dao.setProcInValue(procIndex1, "strExpiryDate",		strExpiryDate.trim(), 9); // 8
							dao.setProcInValue(procIndex1, "strIssueQty", 		strIssueQty,10);
							dao.setProcInValue(procIndex1, "strIssueUnitId",	strIssueUnitId, 11); // 10
							dao.setProcInValue(procIndex1, "strStoreId", 		strStoreId, 12); // 11
							dao.setProcInValue(procIndex1, "strIssueNo", 		strIssueNo, 13); // 12
							dao.setProcInValue(procIndex1, "hosp_code", 		hosp_code, 14); // 13
							dao.setProcInValue(procIndex1, "strItemSlNo", 		strItemSlNo,15); // 14
							dao.setProcInValue(procIndex1, "strStockStatus",	strStockStatus, 16); // 15
							dao.setProcInValue(procIndex1, "strManuFactDate",	strManuFactDate.trim(), 17); // 16
							dao.setProcInValue(procIndex1, "strConsumableFlag",	strConsumableFlag, 18); // 17
							dao.setProcInValue(procIndex1, "strRemarks", 		strRemarks, 19); // 18
							dao.setProcInValue(procIndex1, "strItemCost",		Double.toString(Math.round((Double.parseDouble(strIssueQty)*Double.parseDouble(strRate))*100.0)/100.0),20); // 19?
							dao.setProcInValue(procIndex1, "strRequestNo",		_LPIssueDeskTransVO.getStrLpRequestNo(), 21); // 20?
							dao.setProcInValue(procIndex1, "strRasingStoreId",	_LPIssueDeskTransVO.getStrRaisingStoreId(), 22);
							dao.setProcInValue(procIndex1, "strItemCatNo",		_LPIssueDeskTransVO.getStrItemCategNo(), 23); // 21
							dao.setProcInValue(procIndex1, "strSeatid",			_LPIssueDeskTransVO.getStrSeatId(), 24);
							dao.setProcInValue(procIndex1, "strDescription",	_LPIssueDeskTransVO.getStrDescription(), 25);
							dao.setProcInValue(procIndex1, "crno",				_LPIssueDeskTransVO.getStrCrNo(), 26);								
							dao.setProcInValue(procIndex1, "deptcode",			_LPIssueDeskTransVO.getStrDeptCode(), 27);
							dao.setProcInValue(procIndex1, "treatmentcatg",		_LPIssueDeskTransVO.getStrTreatmentCat(), 28);
							dao.setProcInValue(procIndex1, "episodecode",		_LPIssueDeskTransVO.getStrEpisodeCode(), 29);
							dao.setProcInValue(procIndex1, "wardcode",			_LPIssueDeskTransVO.getStrWardCode(), 30);
							dao.setProcInValue(procIndex1, "addmissionno",		_LPIssueDeskTransVO.getStrAdmissionNo(), 31);
							dao.setProcInValue(procIndex1, "visitno",			_LPIssueDeskTransVO.getStrVisitNo(), 32);								
							dao.setProcOutValue(procIndex1, "err",				1, 33); // 22
							dao.execute(procIndex1,1);
						}
					}
							
					
				}
				  
			} // For Loop End Here							
						
			if (_LPIssueDeskTransVO.getStrItemParamValue().length != 0) 
			{
				System.out.println("------- Insert Into Issue & Issue Item Table  ---- Start ---");
				
				for (int i = 0; i < _LPIssueDeskTransVO.getStrItemParamValue().length; i++) 
				{
					        strIssueQty = _LPIssueDeskTransVO.getStrIssueQuantity()[i].split(" ")[0];
				
							i=length;
							proc_name1 = "";
							proc_name1 = "{call pkg_mms_dml.dml_hstt_patemp_issue_new_dtl(?,?,?,?,?   , ?,?,?,?,? , ?,?,?,?,?   ,?,?,?,?,?   ,?,?,?,?,?   ,?,?,?,?,?   ,?,?,?)}";
											
							System.out.println("----C -----pkg_mms_dml.dml_hstt_patemp_issue_new_dtl---[ Mode -1 ]------");
							
							procIndex3 = dao.setProcedure(proc_name1);
							
							dao.setProcInValue(procIndex3, "modval",            "1", 		1);
							dao.setProcInValue(procIndex3, "strIssueNo", 		strIssueNo, 2); // 1
							dao.setProcInValue(procIndex3, "hosp_code", 		_LPIssueDeskTransVO.getStrHospitalCode(), 3); // 2
							dao.setProcInValue(procIndex3, "strStoreId",		_LPIssueDeskTransVO.getStrStoreId(), 4); // 3
							dao.setProcInValue(procIndex3, "strRemarks", 		strRemarks, 5); // 18
							dao.setProcInValue(procIndex3, "strFinalCost",		_LPIssueDeskTransVO.getStrFinalCost(), 6); // 4
							dao.setProcInValue(procIndex3, "strRequestNo",		_LPIssueDeskTransVO.getStrLpRequestNo(), 7); // 5
							dao.setProcInValue(procIndex3, "strRequestDate",	_LPIssueDeskTransVO.getStrRequestDate(), 8); // 6
							dao.setProcInValue(procIndex3, "strCrNo",			_LPIssueDeskTransVO.getStrCrNo(), 9); // 7
							dao.setProcInValue(procIndex3, "strReqTypeId",		_LPIssueDeskTransVO.getStrRequestTypeId(), 10);// 8
							dao.setProcInValue(procIndex3, "strAdmNo",			_LPIssueDeskTransVO.getStrAdmissionNo(), 11); // 9
							dao.setProcInValue(procIndex3, "strEmpNo",			_LPIssueDeskTransVO.getStrEmpNo(), 12); // 10
							dao.setProcInValue(procIndex3, "strItemCatNo",		_LPIssueDeskTransVO.getStrItemCategNo(), 13); // 11
							dao.setProcInValue(procIndex3, "strFinStartDate",	_LPIssueDeskTransVO.getStrFinStartDate(), 14); // 12
							dao.setProcInValue(procIndex3, "strFinEndDate",		_LPIssueDeskTransVO.getStrFinEndDate(), 15); // 13
							dao.setProcInValue(procIndex3, "strSeatId",			_LPIssueDeskTransVO.getStrSeatId(), 16); // 14
							dao.setProcInValue(procIndex3, "strRaisingStoreId",_LPIssueDeskTransVO.getStrRaisingStoreId(), 17); // 15
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
							dao.setProcInValue(procIndex3, "days",				"", 29);
							dao.setProcInValue(procIndex3, "strPoNo",			_LPIssueDeskTransVO.getStrPoNo(), 30);
							dao.setProcInValue(procIndex3, "strPoStoreId",		_LPIssueDeskTransVO.getStrPoStoreId(), 31);
							dao.setProcInValue(procIndex3, "strBsReqNo", 		bsReqNo, 32);
							dao.setProcOutValue(procIndex3, "err", 				1, 33);
							dao.execute(procIndex3, 1);
											
						
					
				}
				
				System.out.println("------- Insert Into Issue & Issue Item Table  ---- End ---");
			}
						
			
			 System.out.println("-------------  LPIssueDeskTransDAO . insertData  --------END ------");
				
			
			
			dao.fire();
			//dao.getString(procIndex1, "err");
			//dao.getString(procIndex3, "err");
			
			_LPIssueDeskTransVO.setStrIssueNo(strIssueNo);
			
		}						
		catch (Exception _err) 
		{
			
			_err.printStackTrace();
			_LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransDAO.insertData() --> "+ _err.getMessage());
			_LPIssueDeskTransVO.setStrMsgType("1");
		}
	}
	
	
	public static void insertData(LPIssueDeskTransVO _LPIssueDeskTransVO) 
	{
		String proc_name1 = "{call pkg_mms_dml.Dml_hstt_patemp_issue_item_dtl_new(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,?, ?,?,?,?,? ,?,?)}";
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
		String strBillQty = ""; //commented by shalini bcz issue qty was different from billed qty(issue reported from AIIMSP)
		String                       values[] = null;
		String bsReqNo="0";
		int pIndex;
		String p_name="";
		int nProcIndex = 0;
		WebRowSet ws = null;
		String strErr = "";
		
		MmsConfigUtil mcu;
		
		try 
		{
			System.out.println("---------LPIssueDeskTransDAO.insertData---------");
			
			mcu =new MmsConfigUtil(_LPIssueDeskTransVO.getStrHospitalCode());
			dao = new HisDAO("mms","LPIssueDeskTransDAO.insertData(_LPIssueDeskTransVO)");
			length = _LPIssueDeskTransVO.getStrItemParamValue().length;
			
			System.out.println("---------MMS_MST.generate_issueNo---------");
			
			System.out.println("---------RequestTypeId------"+_LPIssueDeskTransVO.getStrRequestTypeId());
			System.out.println("--------[31- Issue To Store  , 35 - Issue To Pateint IPD , 32 - Issue To Patient Direct ]-------");

			funcIndex = dao.setFunction("{? = call MMS_MST.generate_issueNo(?,?,?,?)}");

			dao.setFuncInValue(funcIndex, 2,_LPIssueDeskTransVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3,_LPIssueDeskTransVO.getStrStoreId());
			dao.setFuncInValue(funcIndex, 4,_LPIssueDeskTransVO.getStrRequestTypeId());
			dao.setFuncInValue(funcIndex, 5,_LPIssueDeskTransVO.getStrItemCategNo());
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			strIssueNo = dao.getFuncString(funcIndex); 
			
			System.out.println("---------strIssueNo---A---"+strIssueNo);
			
			strIssueNo = strIssueNo.split("\\^")[0];
			
			System.out.println("---------strIssueNo---B---"+strIssueNo);
			
			_LPIssueDeskTransVO.setStrIssueNo(strIssueNo);
			temp = _LPIssueDeskTransVO.getStrItemParamValue()[0].replace('@','#').split("#");
			strIssueUnitId = temp[3];
			strRateUnitId = temp[3];
			strIssueQty = temp[2];
			
			
			proc_name1="";
			
			
			proc_name1 = "{call pkg_mms_dml.Dml_hstt_patemp_issue_item_dtl_new(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,?, ?,?,?,?,? ,?,?)}";
			for (int i = 0; i < _LPIssueDeskTransVO.getStrItemParamValue().length; i++) 
			{
				if (!_LPIssueDeskTransVO.getStrIssueQuantity()[i].equals("0") && !_LPIssueDeskTransVO.getStrIssueQuantity()[i].equals("0.00") ) 
				{					
					if (_LPIssueDeskTransVO.getStockDtlsId()!=null)
					{
						if (!_LPIssueDeskTransVO.getStockDtlsId()[i].equals("")) 
						{
							
							  System.out.println("------- When Batch Selected From Stock  -------");
								
							values = _LPIssueDeskTransVO.getStockDtlsId()[i].split("#"); 
		                    //    0       1         		2			3	            4        5         6           7                8               9               10                  11              12      13          14           15          16   17  18      19       
							// StoreId^Generic_ItemId^Brand_ItemId^Stock_Status_Code^Batch_No^Serial_No^Expiry date^Manufactre Date^In Hand Qty ^ In Hand Qty Unit ^ Purchase Rate ^ Purchase Rate Unit ^ Rate ^ Rate Unit ^ Issue Qty ^ Issue Qty Unit ^   ^   ^ Cost ^ Cost
							// 99901120^10000067^10100067^UIT11738^10^0^31-May-2014^01-Dec-2011^24990^6301^21.54^6306^22.62^6306^10^6301^1^0^2.26^2.26
							batchLength = values.length;
							for (int j = 0; j < batchLength; j++) 
							{
									temp = values[j].replace("^", "#").split("#");
									strItemBrandId = temp[2];
									strItemId = temp[1];
									strRate=temp[12];
									strRateUnitId=temp[13];							
									strGroupId = "";
									strSubGroupId = "";
									strBatchSlNo = temp[3];
									strExpiryDate = temp[6].trim();								
									strIssueQty = temp[14];
									strStoreId = _LPIssueDeskTransVO.getStrStoreId();
									hosp_code = _LPIssueDeskTransVO.getStrHospitalCode();
									strItemSlNo = "0";
									strStockStatus = "10";
									strManuFactDate = temp[7];
									strConsumableFlag = "1";
									strRemarks = _LPIssueDeskTransVO.getStrRemarks();								
									strIssueUnitId = temp[15];
			
									
							    	System.out.println("---C------"+strProcName5+"---[ Mode -1 ]---"+i+"---Brand Id-["+strItemBrandId+"/"+strBatchSlNo+"]--");
								
									nProcIndex = dao.setProcedure(strProcName5);
									dao.setProcInValue(nProcIndex, "modeval", 			"1", 1);
									dao.setProcInValue(nProcIndex, "store_id",			strStoreId, 2);
									dao.setProcInValue(nProcIndex, "catcode",			_LPIssueDeskTransVO.getStrItemCategNo(),3);
									dao.setProcInValue(nProcIndex, "item_id", 			strItemId, 4);
									dao.setProcInValue(nProcIndex, "itembrand_id",		strItemBrandId, 5);
									dao.setProcInValue(nProcIndex, "batch_no", 			strBatchSlNo, 6);
									dao.setProcInValue(nProcIndex, "stock_status",		"10", 7);
									dao.setProcInValue(nProcIndex, "hosp_code", 		_LPIssueDeskTransVO.getStrHospitalCode(), 8);
									dao.setProcInValue(nProcIndex, "itemslno", 			"0", 9);
									dao.setProcInValue(nProcIndex, "reservedstockflag", "0", 10);
									dao.setProcInValue(nProcIndex, "blockedqtyflag", 	"0", 11);
									dao.setProcOutValue(nProcIndex, "err", 				 1, 12);
									dao.setProcOutValue(nProcIndex, "resultset",		 2, 13);
									
									dao.executeProcedureByPosition(nProcIndex);
	
									strErr = dao.getString(nProcIndex, "err");
	
									if (strErr == null)
										strErr = "";
	
									ws = dao.getWebRowSet(nProcIndex, "resultset");
									
									//System.out.println("ws::::::::::::::==="+ws.size());
									float addQty=(float) 0.00;
									float issueqty=Float.parseFloat(strIssueQty);
									if(ws.size()>0 && ws!=null)
									{
										
										while(ws.next() && issueqty > 0.00)
										{
											//System.out.println("In Hand qTY :::::::::::"+ ws.getString(20));
											if( issueqty > Float.parseFloat(ws.getString(20)) )
											{
												addQty=Float.parseFloat(ws.getString(20));
												strRate=ws.getString(38);
												strBatchSlNo=ws.getString(15);
												//break ; 
											}else
											{
												addQty=issueqty; 
												strRate=ws.getString(38);
												strBatchSlNo=ws.getString(15);
												//System.out.println("strIssueQty"+issueqty);
											}
											issueqty =issueqty - addQty;
											
											if(strBillTariff != null && strBillTariff != "")
												strBillTariff=strBillTariff + "^"+strItemBrandId;
												else
													strBillTariff = strItemBrandId;
											
												if(strBillRate != null && strBillRate != "")
													strBillRate=strBillRate + "^"+strRate;
													else
														strBillRate = strRate;
												
												if(strBillQty != null && strBillQty != "")
													strBillQty=strBillQty + "^"+strIssueQty;
													else
														strBillQty = String.valueOf(strIssueQty);
												
												if(strBillBatch != null && strBillBatch != "")
													strBillBatch=strBillBatch + "^"+strBatchSlNo;
													else
														strBillBatch = strBatchSlNo;
												
									
										
											System.out.println("---E------"+proc_name1+"---[ Mode -1 ]---"+i+"---");
											
											System.out.println("strIssueNo----------"+strIssueNo);
											
											procIndex1 = dao.setProcedure(proc_name1);
						
											dao.setProcInValue(procIndex1, "modval", "1", 		1); // Default
																								// Value.
											dao.setProcInValue(procIndex1, "strItemBrandId",	strItemBrandId, 2); // 1
											dao.setProcInValue(procIndex1, "strItemId", 		strItemId, 3); // 2
											dao.setProcInValue(procIndex1, "strRate", 			strRate, 4); // 3
											dao.setProcInValue(procIndex1, "strRateUnitId",		strRateUnitId, 5); // 4
											dao.setProcInValue(procIndex1, "strGroupId", 		strGroupId, 6); // 5?
											dao.setProcInValue(procIndex1, "strSubGroupId",		strSubGroupId, 7); // 6?
											dao.setProcInValue(procIndex1, "strBatchSlNo",		strBatchSlNo, 8); // 7
											dao.setProcInValue(procIndex1, "strExpiryDate",		strExpiryDate.trim(), 9); // 8
											dao.setProcInValue(procIndex1, "strIssueQty", 		String.valueOf(addQty),10);
											dao.setProcInValue(procIndex1, "strIssueUnitId",	strIssueUnitId, 11); // 10
											dao.setProcInValue(procIndex1, "strStoreId", 		strStoreId, 12); // 11
											dao.setProcInValue(procIndex1, "strIssueNo", 		strIssueNo, 13); // 12
											dao.setProcInValue(procIndex1, "hosp_code", 		hosp_code, 14); // 13
											dao.setProcInValue(procIndex1, "strItemSlNo", 		strItemSlNo,15); // 14
											dao.setProcInValue(procIndex1, "strStockStatus",	strStockStatus, 16); // 15
											dao.setProcInValue(procIndex1, "strManuFactDate",	strManuFactDate.trim(), 17); // 16
											dao.setProcInValue(procIndex1, "strConsumableFlag",	strConsumableFlag, 18); // 17
											dao.setProcInValue(procIndex1, "strRemarks", 		strRemarks, 19); // 18
											dao.setProcInValue(procIndex1, "strItemCost",		Double.toString(Math.round((Double.parseDouble(strIssueQty)*Double.parseDouble(strRate))*100.0)/100.0),20); // 19?
											dao.setProcInValue(procIndex1, "strRequestNo",		_LPIssueDeskTransVO.getStrLpRequestNo(), 21); // 20?
											dao.setProcInValue(procIndex1, "strRasingStoreId",	_LPIssueDeskTransVO.getStrRaisingStoreId(), 22);
											dao.setProcInValue(procIndex1, "strItemCatNo",		_LPIssueDeskTransVO.getStrItemCategNo(), 23); // 21
											dao.setProcInValue(procIndex1, "strSeatid",			_LPIssueDeskTransVO.getStrSeatId(), 24);
											dao.setProcInValue(procIndex1, "strDescription",	_LPIssueDeskTransVO.getStrDescription(), 25);
											dao.setProcInValue(procIndex1, "crno",				_LPIssueDeskTransVO.getStrCrNo(), 26);
											dao.setProcOutValue(procIndex1, "err",				1, 27); // 22
											dao.execute(procIndex1,1);
											
										
											}
									}
								}
						}
						else
						{
							
								    System.out.println("------- Auto Deduct From Stock  -------");
								 
									temp = _LPIssueDeskTransVO.getStrItemParamValue()[i].replace('@', '#').split("#");
									strItemBrandId = temp[1];
									strItemId = temp[0];
									strRate = temp[6];								
									strGroupId = temp[7];
									strSubGroupId = "";
									strBatchSlNo = temp[5];								
									strIssueQty = _LPIssueDeskTransVO.getStrIssueQuantity()[i].split(" ")[0];
									strStoreId = _LPIssueDeskTransVO.getStrStoreId();
									hosp_code = _LPIssueDeskTransVO.getStrHospitalCode();
									strItemSlNo = "0";
									strStockStatus = "10";								
									strConsumableFlag = "1";
									strRemarks = _LPIssueDeskTransVO.getStrRemarks();									
									strIssueUnitId = temp[3];
										
								
									if(Double.parseDouble(_LPIssueDeskTransVO.getStrIssueQuantity()[i].split(" ")[0]) > 0.0)
									{
										
										System.out.println("---F------"+strProcName5+"---[ Mode -1 ]--Brand Id-["+strItemBrandId+"]--");
										
										nProcIndex = dao.setProcedure(strProcName5);
										dao.setProcInValue(nProcIndex, "modeval", 			"1", 1);
										dao.setProcInValue(nProcIndex, "store_id",			strStoreId, 2);
										dao.setProcInValue(nProcIndex, "catcode",			_LPIssueDeskTransVO.getStrItemCategNo(),3);
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
										
										////System.out.println("ws::::::::::::::==="+ws.size());
										float addQty=(float) 0.00;
										float issueqty=Float.parseFloat(strIssueQty);
										if(ws.size()>0 && ws!=null)
										{
											
											while(ws.next() && issueqty > 0.00)
											{
											//	//System.out.println("In Hand qTY :::::::::::"+ ws.getString(20));
												if( issueqty > Float.parseFloat(ws.getString(20)) )
												{
													addQty=Float.parseFloat(ws.getString(20));
													strRate=ws.getString(38);
													strBatchSlNo=ws.getString(15);
													//break ; 
												}
												else
												{
													addQty=issueqty; 
													strRate=ws.getString(38);
													strBatchSlNo=ws.getString(15);
													//System.out.println("strIssueQty"+issueqty);
												}
												issueqty =issueqty - addQty;
												
												if(strBillTariff != null && strBillTariff != "")
													strBillTariff=strBillTariff + "^"+strItemBrandId;
													else
														strBillTariff = strItemBrandId;
												
													if(strBillRate != null && strBillRate != "")
														strBillRate=strBillRate + "^"+strRate;
														else
															strBillRate = strRate;
													
													if(strBillQty != null && strBillQty != "")
														strBillQty=strBillQty + "^"+addQty;
														else
															strBillQty = String.valueOf(addQty);
													
													if(strBillBatch != null && strBillBatch != "")
														strBillBatch=strBillBatch + "^"+strBatchSlNo;
														else
															strBillBatch = strBatchSlNo;
													
												System.out.println("---G------"+proc_name1+"---[ Mode -1 ]------");
												
												System.out.println("strIssueNo----------"+strIssueNo);
												
												procIndex1 = dao.setProcedure(proc_name1);
							
												dao.setProcInValue(procIndex1, "modval", 			"1", 1); // Default
																									// Value.
												dao.setProcInValue(procIndex1, "strItemBrandId",	strItemBrandId, 2); // 1
												dao.setProcInValue(procIndex1, "strItemId", 		strItemId, 3); // 2
												dao.setProcInValue(procIndex1, "strRate", 			strRate, 4); // 3
												dao.setProcInValue(procIndex1, "strRateUnitId",		strRateUnitId, 5); // 4
												dao.setProcInValue(procIndex1, "strGroupId", 		strGroupId, 6); // 5?
												dao.setProcInValue(procIndex1, "strSubGroupId",		strSubGroupId, 7); // 6?
												dao.setProcInValue(procIndex1, "strBatchSlNo",		strBatchSlNo, 8); // 7
												dao.setProcInValue(procIndex1, "strExpiryDate",		strExpiryDate.trim(), 9); // 8
												dao.setProcInValue(procIndex1, "strIssueQty", 		String.valueOf(addQty),10);
												dao.setProcInValue(procIndex1, "strIssueUnitId",	strIssueUnitId, 11); // 10
												dao.setProcInValue(procIndex1, "strStoreId", 		strStoreId, 12); // 11
												dao.setProcInValue(procIndex1, "strIssueNo", 		strIssueNo, 13); // 12
												dao.setProcInValue(procIndex1, "hosp_code", 		hosp_code, 14); // 13
												dao.setProcInValue(procIndex1, "strItemSlNo", 		strItemSlNo,15); // 14
												dao.setProcInValue(procIndex1, "strStockStatus",	strStockStatus, 16); // 15
												dao.setProcInValue(procIndex1, "strManuFactDate",	strManuFactDate.trim(), 17); // 16
												dao.setProcInValue(procIndex1, "strConsumableFlag", strConsumableFlag, 18); // 17
												dao.setProcInValue(procIndex1, "strRemarks", 		strRemarks, 19); // 18
												dao.setProcInValue(procIndex1, "strItemCost",		Double.toString(Math.round((Double.parseDouble(String.valueOf(addQty))*Double.parseDouble(strRate))*100.0)/100.0),20); // 19?
												dao.setProcInValue(procIndex1, "strRequestNo",		_LPIssueDeskTransVO.getStrLpRequestNo(), 21); // 20?
												dao.setProcInValue(procIndex1, "strRasingStoreId",	_LPIssueDeskTransVO.getStrRaisingStoreId(), 22);
												dao.setProcInValue(procIndex1, "strItemCatNo",		_LPIssueDeskTransVO.getStrItemCategNo(), 23); // 21
												dao.setProcInValue(procIndex1, "strSeatid",			_LPIssueDeskTransVO.getStrSeatId(), 24);
												dao.setProcInValue(procIndex1, "strDescription",	_LPIssueDeskTransVO.getStrDescription(), 25);
												dao.setProcInValue(procIndex1, "crno", 				_LPIssueDeskTransVO.getStrCrNo(),26);
												dao.setProcOutValue(procIndex1, "err", 				1, 27); // 22
												dao.execute(procIndex1,1);
												
												
									  }  // Issue Qty  > 0
									} // Size > 0 
								}
							}
						}
							
					
					}
				    			
			} // For Loop End Here			
			
					int procIndex2;
					
					System.out.println("-------------------------- BILLING START HERE --------------------------------");		
					System.out.println("---J------bill_interface.dml_online_billreq_drugs---[ Mode -1 ]------");
					
					System.out.println("--------------------------------");		
					System.out.println("strBillTariff:::::"+strBillTariff);
					System.out.println("strBillRate:::::"+strBillRate);
					System.out.println("strBillQty:::::"+strBillQty);
					System.out.println("strBillBatch:::::"+strBillBatch);
					System.out.println("--------------------------------");			
					//System.out.println("gnum_dept_code"+_LPIssueDeskTransVO.getStrDeptCode());
					//System.out.println("gnum_treatment_cat"+_LPIssueDeskTransVO.getStrTreatmentCat());
					//System.out.println("hrgnum_episode_code"+_LPIssueDeskTransVO.getStrEpisodeCode());
					//System.out.println("hrgnum_puk"+_LPIssueDeskTransVO.getStrCrNo());
					//System.out.println("gnum_seatid"+_LPIssueDeskTransVO.getStrSeatId());
					//System.out.println("hosp_code"+_LPIssueDeskTransVO.getStrHospitalCode());
					//System.out.println("ward_code"+_LPIssueDeskTransVO.getStrWardCode());
					//System.out.println("admno"+_LPIssueDeskTransVO.getStrAdmissionNo());
					//System.out.println("visitno"+_LPIssueDeskTransVO.getStrVisitNo());
				    //System.out.println("strBillRate------"+strBillRate);
					
					String proc_name2 = "{call bill_interface.dml_online_billreq_drugs(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}";
					procIndex2 = dao.setProcedure(proc_name2);
					dao.setProcInValue(procIndex2, "modval", 					"1", 1); // 1
					dao.setProcInValue(procIndex2, "gnum_dept_code", 			_LPIssueDeskTransVO.getStrDeptCode(), 2);					
					dao.setProcInValue(procIndex2, "sblnum_chargetype_id", 		"2", 3);
					dao.setProcInValue(procIndex2, "sblnum_service_id", 		"5", 4);
					dao.setProcInValue(procIndex2, "gstr_req_no", 				strIssueNo, 5);
					dao.setProcInValue(procIndex2, "gnum_treatment_cat", 		_LPIssueDeskTransVO.getStrTreatmentCat(),6);					
					dao.setProcInValue(procIndex2, "hrgnum_episode_code", 		_LPIssueDeskTransVO.getStrEpisodeCode(), 7);					
					dao.setProcInValue(procIndex2, "hrgnum_puk", 				_LPIssueDeskTransVO.getStrCrNo(), 8);					
					dao.setProcInValue(procIndex2, "hblnum_pat_lfaccount_no", 	"0", 9);
					dao.setProcInValue(procIndex2, "gstr_tariff", 				strBillTariff, 10);
					dao.setProcInValue(procIndex2, "gstr_tariff_batch", 		strBillBatch, 11);
					dao.setProcInValue(procIndex2, "gstr_tariff_rates", 		strBillRate, 12);
					dao.setProcInValue(procIndex2, "gstr_reqqty", 				strBillQty, 13);
					dao.setProcInValue(procIndex2, "hblstr_patient_name", 		"", 14);
					dao.setProcInValue(procIndex2, "hblstr_pat_address", 		"", 15);
					dao.setProcInValue(procIndex2, "hblstr_contact_no", 		"", 16);
					dao.setProcInValue(procIndex2, "age", 						"1", 17);
					dao.setProcInValue(procIndex2, "ageunit", 					"1", 18);
					dao.setProcInValue(procIndex2, "gender", 					"1", 19);
					dao.setProcInValue(procIndex2, "refdoctor",					"1", 20);
					dao.setProcInValue(procIndex2, "refdoccontactno", 			"1", 21);
					dao.setProcInValue(procIndex2, "gnum_seatid", 				_LPIssueDeskTransVO.getStrSeatId(), 22);					
					dao.setProcInValue(procIndex2, "hosp_code", 				_LPIssueDeskTransVO.getStrHospitalCode(), 23);					
					dao.setProcInValue(procIndex2, "ward_code", 				_LPIssueDeskTransVO.getStrWardCode(), 24);					
					dao.setProcInValue(procIndex2, "admno", 					_LPIssueDeskTransVO.getStrAdmissionNo(), 25);					
					dao.setProcInValue(procIndex2, "visitno", 					_LPIssueDeskTransVO.getStrVisitNo(), 26);					
					dao.setProcOutValue(procIndex2, "err",                      1, 27);					
					dao.execute(procIndex2, 1);
							
			
			System.out.println("-------------------------- BILLING END HERE --------------------------------");				
						
			if (_LPIssueDeskTransVO.getStrItemParamValue().length != 0) 
			{
				System.out.println("------- Insert Into Issue & Issue Item Table  ---- Start ---");
				
				for (int i = 0; i < _LPIssueDeskTransVO.getStrItemParamValue().length; i++) 
				{
					    strIssueQty = _LPIssueDeskTransVO.getStrIssueQuantity()[i].split(" ")[0];
				
							
						if(!strIssueQty.equals("0.00") && !strIssueQty.equals("0"))
						{
							i=length;
							proc_name1 = "";
							proc_name1 = "{call pkg_mms_dml.Dml_hstt_patemp_issue_dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?)}";
				
							System.out.println("----A -----pkg_mms_dml.Dml_hstt_patemp_issue_dtl---[ Mode -1 ]------");
							
							procIndex3 = dao.setProcedure(proc_name1);
							dao.setProcInValue(procIndex3, "strIssueNo", 		strIssueNo, 2); // 1
							dao.setProcInValue(procIndex3, "hosp_code", 		_LPIssueDeskTransVO.getStrHospitalCode(), 3); // 2
							dao.setProcInValue(procIndex3, "strStoreId",		_LPIssueDeskTransVO.getStrStoreId(), 4); // 3
							dao.setProcInValue(procIndex3, "strFinalCost",		_LPIssueDeskTransVO.getStrFinalCost(), 6); // 4
							dao.setProcInValue(procIndex3, "strRequestNo",		_LPIssueDeskTransVO.getStrLpRequestNo(), 7); // 5
							dao.setProcInValue(procIndex3, "strRequestDate",	_LPIssueDeskTransVO.getStrRequestDate(), 8); // 6
							dao.setProcInValue(procIndex3, "strCrNo",			_LPIssueDeskTransVO.getStrCrNo(), 9); // 7
							dao.setProcInValue(procIndex3, "strReqTypeId",		_LPIssueDeskTransVO.getStrRequestTypeId(), 10);// 8
							dao.setProcInValue(procIndex3, "strAdmNo",			_LPIssueDeskTransVO.getStrAdmissionNo(), 11); // 9
							dao.setProcInValue(procIndex3, "strEmpNo",			_LPIssueDeskTransVO.getStrEmpNo(), 12); // 10
							dao.setProcInValue(procIndex3, "strItemCatNo",		_LPIssueDeskTransVO.getStrItemCategNo(), 13); // 11
							dao.setProcInValue(procIndex3, "strFinStartDate",	_LPIssueDeskTransVO.getStrFinStartDate(), 14); // 12
							dao.setProcInValue(procIndex3, "strFinEndDate",		_LPIssueDeskTransVO.getStrFinEndDate(), 15); // 13
							dao.setProcInValue(procIndex3, "strSeatId",			_LPIssueDeskTransVO.getStrSeatId(), 16); // 14
							dao.setProcInValue(procIndex3, "strRaisingStoreId",_LPIssueDeskTransVO.getStrRaisingStoreId(), 17); // 15
							dao.setProcInValue(procIndex3, "strIssueQty", 		strIssueQty, 18);
							dao.setProcInValue(procIndex3, "strIssueUnitId", 	strIssueUnitId, 19); // 17
							dao.setProcInValue(procIndex3, "strRemarks", 		strRemarks, 5); // 18
							dao.setProcInValue(procIndex3, "strDeptCode",		_LPIssueDeskTransVO.getStrDeptCode(), 20);
							dao.setProcInValue(procIndex3, "strDeptUnitCode",	_LPIssueDeskTransVO.getStrDeptUnitCode(), 21);
							dao.setProcInValue(procIndex3, "strWardCode",		_LPIssueDeskTransVO.getStrWardCode(), 22);
							dao.setProcInValue(procIndex3, "strEpisodeCode",	_LPIssueDeskTransVO.getStrEpisodeCode(), 23);
							dao.setProcInValue(procIndex3, "strVisitNo",		_LPIssueDeskTransVO.getStrVisitNo(), 24);
							dao.setProcInValue(procIndex3, "strVisitType",		_LPIssueDeskTransVO.getStrVisitType(), 25);
							dao.setProcInValue(procIndex3, "strRecieveBy",		_LPIssueDeskTransVO.getStrReceivedby(), 26);
							dao.setProcInValue(procIndex3, "strPoNo",			_LPIssueDeskTransVO.getStrPoNo(), 30);
							dao.setProcInValue(procIndex3, "strPoStoreId",		_LPIssueDeskTransVO.getStrPoStoreId(), 31);
				
							
							dao.setProcInValue(procIndex3, "modval", "1", 		1);
							dao.setProcInValue(procIndex3, "strOrderBy", 	"", 27);
							dao.setProcInValue(procIndex3, "strOrderDate", 	"", 28);
							dao.setProcInValue(procIndex3, "days",			"", 29);
							
				
							dao.setProcInValue(procIndex3, "strBsReqNo", bsReqNo, 32);
							dao.setProcOutValue(procIndex3, "err", 1, 33);
							dao.execute(procIndex3, 1);
				
							proc_name1 = "";
							proc_name1 = "{call pkg_mms_dml.Dml_issue_dtls(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}";
							procIndex4 = dao.setProcedure(proc_name1);
							
							System.out.println("---B------pkg_mms_dml.Dml_issue_dtls---[ Mode -2 ]------");
							
							dao.setProcInValue(procIndex4, "modeval",			 "2", 1);
							dao.setProcInValue(procIndex4, "issuing_store_id",	 _LPIssueDeskTransVO.getStrStoreId(), 2);
							dao.setProcInValue(procIndex4, "issueNo", 			 strIssueNo, 3); // 1
							dao.setProcInValue(procIndex4, "hospital_code",      _LPIssueDeskTransVO.getStrHospitalCode(), 4); // 2
							dao.setProcInValue(procIndex4, "category_No",		 _LPIssueDeskTransVO.getStrItemCategNo(), 5);
							dao.setProcInValue(procIndex4, "indent_No",			 _LPIssueDeskTransVO.getStrLpRequestNo(), 6); // 5
							dao.setProcInValue(procIndex4, "reqType_id",		 _LPIssueDeskTransVO.getStrRequestTypeId(), 7);// 8
							dao.setProcInValue(procIndex4, "indent_Date",		 _LPIssueDeskTransVO.getStrRequestDate(), 8); // 6
							dao.setProcInValue(procIndex4, "raising_store_id",   _LPIssueDeskTransVO.getStrRaisingStoreId(), 9); // 15
							dao.setProcInValue(procIndex4, "net_cost",			 _LPIssueDeskTransVO.getStrFinalCost(), 11); // 4
							dao.setProcInValue(procIndex4, "strCrNo",			 _LPIssueDeskTransVO.getStrCrNo(), 16); // 7
							dao.setProcInValue(procIndex4, "strAmNo",			 _LPIssueDeskTransVO.getStrAdmissionNo(), 17); // 9
							dao.setProcInValue(procIndex4, "strEmpNo",			 _LPIssueDeskTransVO.getStrEmpNo(), 18); // 10
							dao.setProcInValue(procIndex4, "fin_start_date",	 _LPIssueDeskTransVO.getStrFinStartDate(), 12); // 12
							dao.setProcInValue(procIndex4, "fin_end_date",		 _LPIssueDeskTransVO.getStrFinEndDate(), 13); // 13
							dao.setProcInValue(procIndex4, "seatId",			 _LPIssueDeskTransVO.getStrSeatId(), 15); // 14
							dao.setProcInValue(procIndex4, "remarks", 			 strRemarks, 14); // 16
							dao.setProcInValue(procIndex4, "receivedBy",		 _LPIssueDeskTransVO.getStrReceivedby(), 10); // 17
							dao.setProcInValue(procIndex4, "strPoNo",			 _LPIssueDeskTransVO.getStrPoNo(), 19); // 18
							dao.setProcInValue(procIndex4, "strPoStoreId",		 _LPIssueDeskTransVO.getStrPoStoreId(), 20); // 19
							dao.setProcInValue(procIndex4, "strBsReqNo",         bsReqNo, 21); // 19
							dao.setProcOutValue(procIndex4, "err", 				 1, 22);
							dao.execute(procIndex4, 1);
							
						
					}	
				}
				
				System.out.println("------- Insert Into Issue & Issue Item Table  ---- End ---");
			}
			
			
			 System.out.println("-------------  LPIssueDeskTransDAO . insertData  --------END ------");
				
			
			
			dao.fire();
			dao.getString(procIndex1, "err");
			
			_LPIssueDeskTransVO.setStrIssueNo(strIssueNo);
			
		}						
		catch (Exception _err) 
		{
			
			_err.printStackTrace();
			_LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransDAO.insertData() --> "+ _err.getMessage());
			_LPIssueDeskTransVO.setStrMsgType("1");
		}
	}

	
	public static void insertDataNew(LPIssueDeskTransVO _LPIssueDeskTransVO) 
	{
		String proc_name1 = "{call pkg_mms_dml.Dml_hstt_patemp_issue_item_dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,?, ?,?,?,?,? ,?,?)}";
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
		String strBillQty = "";
		String                       values[] = null;
		String bsReqNo="0";
		int pIndex;
		String p_name="";
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
			length = _LPIssueDeskTransVO.getStrIssueQuantity().length ;  //_LPIssueDeskTransVO.getStrItemParamValue().length;

			funcIndex = dao.setFunction("{? = call MMS_MST.generate_issueNo(?,?,?,?)}");

			dao.setFuncInValue(funcIndex, 2,_LPIssueDeskTransVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3,_LPIssueDeskTransVO.getStrStoreId());
			dao.setFuncInValue(funcIndex, 4,_LPIssueDeskTransVO.getStrRequestTypeId());
			dao.setFuncInValue(funcIndex, 5,_LPIssueDeskTransVO.getStrItemCategNo());
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			strIssueNo = dao.getFuncString(funcIndex); 
			//temp = _LPIssueDeskTransVO.getStrItemParamValue()[0].replace('@','#').split("#");
			strIssueUnitId = "6301";
			strRateUnitId = "6301";
		/*	strIssueQty = temp[4];
			
			for (int i = 0; i < _LPIssueDeskTransVO.getStrItemParamValue().length; i++) 
			{
				if (!_LPIssueDeskTransVO.getStrIssueQuantity()[i].equals("0") && !_LPIssueDeskTransVO.getStrIssueQuantity()[i].equals("0.00") ) 
				{
					if (_LPIssueDeskTransVO.getStockDtlsId()!=null)
					{
						if (!_LPIssueDeskTransVO.getStockDtlsId()[i].equals("")) 
						{
						values = _LPIssueDeskTransVO.getStockDtlsId()[i].split("#"); 
	                    //    0       1         		2			3	            4        5         6           7                8               9               10                  11              12      13          14           15          16   17  18      19       
						// StoreId^Generic_ItemId^Brand_ItemId^Stock_Status_Code^Batch_No^Serial_No^Expiry date^Manufactre Date^In Hand Qty ^ In Hand Qty Unit ^ Purchase Rate ^ Purchase Rate Unit ^ Rate ^ Rate Unit ^ Issue Qty ^ Issue Qty Unit ^   ^   ^ Cost ^ Cost
						// 99901120^10000067^10100067^UIT11738^10^0^31-May-2014^01-Dec-2011^24990^6301^21.54^6306^22.62^6306^10^6301^1^0^2.26^2.26
						batchLength = values.length;
						for (int j = 0; j < batchLength; j++) 
						{
							temp = values[j].replace("^", "#").split("#");
							strItemBrandId = temp[2];
							strItemId = temp[1];
							strRate=temp[12];
							strRateUnitId=temp[13];
						//	strRate = temp[5];
						//	strRateUnitId = temp[6];
							strGroupId = "";
							strSubGroupId = "";
							strBatchSlNo = temp[3];
							strExpiryDate = temp[6].trim();
							//strIssueQty = temp[2];
							strIssueQty = temp[14];
							strStoreId = _LPIssueDeskTransVO.getStrStoreId();
							hosp_code = _LPIssueDeskTransVO.getStrHospitalCode();
							strItemSlNo = "0";
							strStockStatus = "10";
							strManuFactDate = temp[7];
							strConsumableFlag = "1";
							strRemarks = _LPIssueDeskTransVO.getStrRemarks();
							//strItemCost = temp[9];
							strIssueUnitId = temp[15];*/
				strIssueQty = "" ; //LPIssueDeskTransVO.getStrIssueQuantity();
			if (length != 0) {
				for (int i = 0; i < length; i++) {

					/*temp = _LPIssueDeskTransVO.getStrItemParamValue()[i]
							.replace('@', '#').split("#");*/
					strItemBrandId = _LPIssueDeskTransVO.getStrItembrandIdNew()[i];
					strItemId = _LPIssueDeskTransVO.getStrItemIdNew()[i];
					strRate = _LPIssueDeskTransVO.getStrRateNew()[i];
				//	strRateUnitId = temp[6];
					strGroupId = "";
					strSubGroupId = "";
					strBatchSlNo = _LPIssueDeskTransVO.getStrBatchNoNew()[i];
				//	strExpiryDate = temp[8].trim();
					//strIssueQty = temp[2];
					strIssueQty = _LPIssueDeskTransVO.getStrIssueQuantity()[i];
					strStoreId = _LPIssueDeskTransVO.getStrStoreId();
					hosp_code = _LPIssueDeskTransVO.getStrHospitalCode();
					strItemSlNo = "0";
					strStockStatus = "10";
				//	strManuFactDate = temp[7];
					strConsumableFlag = "1";
					strRemarks = _LPIssueDeskTransVO.getStrRemarks();
					//strItemCost = temp[9];
					strIssueUnitId = "6301";
								
						
							if(Double.parseDouble(strIssueQty) > 0.0 || Double.parseDouble(strIssueQty) > 0)
							{
								
								if(strBillTariff != null && strBillTariff != "")
									strBillTariff=strBillTariff + "^"+strItemBrandId;
									else
										strBillTariff = strItemBrandId;
									if(strBillRate != null && strBillRate != "")
										strBillRate=strBillRate + "^"+strRate;
										else
											strBillRate = strRate;
									if(strBillQty != null && strBillQty != "")
										strBillQty=strBillQty + "^"+strIssueQty;
										else
											strBillQty = strIssueQty;
									if(strBillBatch != null && strBillBatch != "")
										strBillBatch=strBillBatch + "^"+strBatchSlNo;
										else
											strBillBatch = strBatchSlNo;
									//System.out.println("strBillTariff:::::"+strBillTariff);
									//System.out.println("strBillRate:::::"+strBillRate);
									//System.out.println("strBillQty:::::"+strBillQty);
									//System.out.println("strBillBatch:::::"+strBillBatch);
									
								procIndex1 = dao.setProcedure(proc_name1);
			
								dao.setProcInValue(procIndex1, "modval", "1", 1); // Default
																					// Value.
								dao.setProcInValue(procIndex1, "strItemBrandId",
										strItemBrandId, 2); // 1
								dao.setProcInValue(procIndex1, "strItemId", strItemId, 3); // 2
								dao.setProcInValue(procIndex1, "strRate", strRate, 4); // 3
								dao.setProcInValue(procIndex1, "strRateUnitId",strRateUnitId, 5); // 4
								dao.setProcInValue(procIndex1, "strGroupId", strGroupId, 6); // 5?
								dao.setProcInValue(procIndex1, "strSubGroupId",strSubGroupId, 7); // 6?
								dao.setProcInValue(procIndex1, "strBatchSlNo",strBatchSlNo, 8); // 7
								dao.setProcInValue(procIndex1, "strExpiryDate",strExpiryDate.trim(), 9); // 8
								dao.setProcInValue(procIndex1, "strIssueQty", strIssueQty,10);
								dao.setProcInValue(procIndex1, "strIssueUnitId",strIssueUnitId, 11); // 10
								dao.setProcInValue(procIndex1, "strStoreId", strStoreId, 12); // 11
								dao.setProcInValue(procIndex1, "strIssueNo", strIssueNo, 13); // 12
								dao.setProcInValue(procIndex1, "hosp_code", hosp_code, 14); // 13
								dao.setProcInValue(procIndex1, "strItemSlNo", strItemSlNo,15); // 14
								dao.setProcInValue(procIndex1, "strStockStatus",strStockStatus, 16); // 15
								dao.setProcInValue(procIndex1, "strManuFactDate",strManuFactDate.trim(), 17); // 16
								dao.setProcInValue(procIndex1, "strConsumableFlag",strConsumableFlag, 18); // 17
								dao.setProcInValue(procIndex1, "strRemarks", strRemarks, 19); // 18
								dao.setProcInValue(procIndex1, "strItemCost", strItemCost,20); // 19?
								dao.setProcInValue(procIndex1, "strRequestNo",_LPIssueDeskTransVO.getStrLpRequestNo(), 21); // 20?
								dao.setProcInValue(procIndex1, "strRasingStoreId",_LPIssueDeskTransVO.getStrRaisingStoreId(), 22);
								dao.setProcInValue(procIndex1, "strItemCatNo",_LPIssueDeskTransVO.getStrItemCategNo(), 23); // 21
								dao.setProcInValue(procIndex1, "strSeatid",_LPIssueDeskTransVO.getStrSeatId(), 24);
								dao.setProcInValue(procIndex1, "strDescription",_LPIssueDeskTransVO.getStrDescription()+"Data Inserted From Issue Desk", 25);
								dao.setProcInValue(procIndex1, "crno", _LPIssueDeskTransVO.getStrCrNo(), 26);
								dao.setProcOutValue(procIndex1, "err", 1, 27); // 22
								dao.execute(procIndex1,1);
		
							}
						
				}
			}
			
				if(!strBillTariff.equals("") && strBillTariff != null)
				{
					int procIndex2;
					String proc_name2 = "{call bill_interface.dml_online_billreq_drugs(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}";
					procIndex2 = dao.setProcedure(proc_name2);
					dao.setProcInValue(procIndex2, "modval", "1", 1); // 1
					dao.setProcInValue(procIndex2, "gnum_dept_code", _LPIssueDeskTransVO.getStrDeptCode(), 2);
					//System.out.println("gnum_dept_code"+_LPIssueDeskTransVO.getStrDeptCode());
					dao.setProcInValue(procIndex2, "sblnum_chargetype_id", "2", 3);
					dao.setProcInValue(procIndex2, "sblnum_service_id", "5", 4);
					dao.setProcInValue(procIndex2, "gstr_req_no", strIssueNo, 5);
					dao.setProcInValue(procIndex2, "gnum_treatment_cat", _LPIssueDeskTransVO.getStrTreatmentCat(),6);
					//System.out.println("gnum_treatment_cat"+_LPIssueDeskTransVO.getStrTreatmentCat());
					dao.setProcInValue(procIndex2, "hrgnum_episode_code", _LPIssueDeskTransVO.getStrEpisodeCode(), 7);
					//System.out.println("hrgnum_episode_code"+_LPIssueDeskTransVO.getStrEpisodeCode());
					dao.setProcInValue(procIndex2, "hrgnum_puk", _LPIssueDeskTransVO.getStrCrNo(), 8);
					//System.out.println("hrgnum_puk"+_LPIssueDeskTransVO.getStrCrNo());
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
					//System.out.println("gnum_seatid"+_LPIssueDeskTransVO.getStrSeatId());
					dao.setProcInValue(procIndex2, "hosp_code", _LPIssueDeskTransVO.getStrHospitalCode(), 23);
					//System.out.println("hosp_code"+_LPIssueDeskTransVO.getStrHospitalCode());
					dao.setProcInValue(procIndex2, "ward_code", _LPIssueDeskTransVO.getStrWardCode(), 24);
					//System.out.println("ward_code"+_LPIssueDeskTransVO.getStrWardCode());
					dao.setProcInValue(procIndex2, "admno", _LPIssueDeskTransVO.getStrAdmissionNo(), 25);
					//System.out.println("admno"+_LPIssueDeskTransVO.getStrAdmissionNo());
					dao.setProcInValue(procIndex2, "visitno", _LPIssueDeskTransVO.getStrVisitNo(), 26);
					//System.out.println("visitno"+_LPIssueDeskTransVO.getStrVisitNo());
					dao.setProcOutValue(procIndex2, "err", 1, 27);
					dao.execute(procIndex2, 1);
				}
			
			int itmln1 = _LPIssueDeskTransVO.getStrBSQuantity().length;
			double lpTemp = 0.00;
			for(int i=0;i<itmln1;i++)
			{
				lpTemp+=Double.parseDouble(_LPIssueDeskTransVO.getStrBSQuantity()[i]);
			}
			if(_LPIssueDeskTransVO.getStrBSReqNo().equals("0") && lpTemp> 0.00)
			{
				if(_LPIssueDeskTransVO.getStrBSIndent().equals("1"))
				{
						int itmln = _LPIssueDeskTransVO.getStrBSQuantity().length;
					
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
							//temp = _LPIssueDeskTransVO.getStrItemParamValue()[i].replace('@', '#').split("#");
						   
							
							
							 if(!_LPIssueDeskTransVO.getStrBSQuantity()[i].equals("0"))
							 {
								 strItemBrandId = _LPIssueDeskTransVO.getStrItembrandIdNew()[i];
								strItemId = _LPIssueDeskTransVO.getStrItemIdNew()[i];
								strRate = _LPIssueDeskTransVO.getStrRateNew()[i];
								strBatchSlNo = _LPIssueDeskTransVO.getStrBatchNoNew()[i];
								strIssueQty = _LPIssueDeskTransVO.getStrIssueQuantity()[i];
								String RateUnitId="6301";
								tArr.add("0#0#"+strItemId+"^"+strItemBrandId+"^0^0^0^0^0^"+"0"+"^"+RateUnitId+"^"+strRate+"^"+RateUnitId+"^0^0^^0^0^0^0^0^0^0^0^0^0^0^0^0") ;
								reqQty.add(_LPIssueDeskTransVO.getStrBSQuantity()[i]);
								reqUnit.add(RateUnitId);
								//j++;
							 }
							 
						
						}
						
						String [] arr = tArr.toArray(new String[tArr.size()]);
						String [] arr1 = reqQty.toArray(new String[reqQty.size()]);
						String [] arr2 = reqUnit.toArray(new String[reqUnit.size()]);
						
						vo.setItemParamValue(arr);
						vo.setStrReqQty(arr1);
						vo.setStrUnitName(arr2);
						
						RequestForLPPatientDAO.INSERT(vo);
						
						if(vo.getStrBSReqNo() != null && !vo.getStrBSReqNo().equals(""))
							bsReqNo = vo.getStrBSReqNo();
						else
							bsReqNo = "0";
						
						_LPIssueDeskTransVO.setStrBSReqNo(bsReqNo);
						// added to update Bs req no in sstt_indent_dtl table
						p_name = "{call pkg_mms_dml.Dml_update_sstt_indent_dtl(?,?,?,?,? ,?)}";
					
					pIndex = dao.setProcedure(p_name);
					
					dao.setProcInValue(pIndex, "modval", "1", 1);
					dao.setProcInValue(pIndex, "hosp_code", _LPIssueDeskTransVO.getStrHospitalCode(), 2);
					dao.setProcInValue(pIndex, "reqNo", _LPIssueDeskTransVO.getStrLpRequestNo(), 3);
					dao.setProcInValue(pIndex, "bsNo", bsReqNo, 4);
					dao.setProcInValue(pIndex, "raising_store",_LPIssueDeskTransVO.getStrRaisingStoreId(), 5);
					dao.setProcOutValue(pIndex, "err", 1, 6);
					dao.executeProcedureByPosition(pIndex);
						
				}
				else
				{
					// added to update Bs req no in sstt_indent_dtl table
					p_name = "{call pkg_mms_dml.Dml_update_sstt_indent_dtl(?,?,?,?,? ,?)}";
				
				pIndex = dao.setProcedure(p_name);
				
				dao.setProcInValue(pIndex, "modval", "1", 1);
				dao.setProcInValue(pIndex, "hosp_code", _LPIssueDeskTransVO.getStrHospitalCode(), 2);
				dao.setProcInValue(pIndex, "reqNo", _LPIssueDeskTransVO.getStrLpRequestNo(), 3);
				dao.setProcInValue(pIndex, "bsNo", "0", 4);
				dao.setProcInValue(pIndex, "raising_store",_LPIssueDeskTransVO.getStrRaisingStoreId(), 5);
				dao.setProcOutValue(pIndex, "err", 1, 6);
				dao.execute(pIndex,1);
				}
		}
			
			if (length != 0) {
				for (int i = 0; i < length; i++) {
					strIssueQty = _LPIssueDeskTransVO.getStrIssueQuantity()[i];
				
							
						if(!strIssueQty.equals("0.00") && !strIssueQty.equals("0"))
						{
							i=length;
							proc_name1 = "";
							proc_name1 = "{call pkg_mms_dml.Dml_hstt_patemp_issue_dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?)}";
				
							procIndex3 = dao.setProcedure(proc_name1);
							dao.setProcInValue(procIndex3, "strIssueNo", strIssueNo, 2); // 1
							dao.setProcInValue(procIndex3, "hosp_code", _LPIssueDeskTransVO.getStrHospitalCode(), 3); // 2
							dao.setProcInValue(procIndex3, "strStoreId",_LPIssueDeskTransVO.getStrStoreId(), 4); // 3
							dao.setProcInValue(procIndex3, "strFinalCost",_LPIssueDeskTransVO.getStrFinalCost(), 6); // 4
							dao.setProcInValue(procIndex3, "strRequestNo",_LPIssueDeskTransVO.getStrLpRequestNo(), 7); // 5
							dao.setProcInValue(procIndex3, "strRequestDate",_LPIssueDeskTransVO.getStrRequestDate(), 8); // 6
							dao.setProcInValue(procIndex3, "strCrNo",_LPIssueDeskTransVO.getStrCrNo(), 9); // 7
							dao.setProcInValue(procIndex3, "strReqTypeId",_LPIssueDeskTransVO.getStrRequestTypeId(), 10);// 8
							dao.setProcInValue(procIndex3, "strAdmNo",_LPIssueDeskTransVO.getStrAdmissionNo(), 11); // 9
							dao.setProcInValue(procIndex3, "strEmpNo",_LPIssueDeskTransVO.getStrEmpNo(), 12); // 10
							dao.setProcInValue(procIndex3, "strItemCatNo",_LPIssueDeskTransVO.getStrItemCategNo(), 13); // 11
							dao.setProcInValue(procIndex3, "strFinStartDate",_LPIssueDeskTransVO.getStrFinStartDate(), 14); // 12
							dao.setProcInValue(procIndex3, "strFinEndDate",_LPIssueDeskTransVO.getStrFinEndDate(), 15); // 13
							dao.setProcInValue(procIndex3, "strSeatId",_LPIssueDeskTransVO.getStrSeatId(), 16); // 14
							dao.setProcInValue(procIndex3, "strRaisingStoreId",_LPIssueDeskTransVO.getStrRaisingStoreId(), 17); // 15
							//dao.setProcInValue(procIndex3, "strIssueQty", strIssueQty, 18); // 16
							
							dao.setProcInValue(procIndex3, "strIssueQty", strIssueQty, 18);
							dao.setProcInValue(procIndex3, "strIssueUnitId", strIssueUnitId, 19); // 17
							dao.setProcInValue(procIndex3, "strRemarks", strRemarks, 5); // 18
							dao.setProcInValue(procIndex3, "strDeptCode",_LPIssueDeskTransVO.getStrDeptCode(), 20);
							dao.setProcInValue(procIndex3, "strDeptUnitCode",_LPIssueDeskTransVO.getStrDeptUnitCode(), 21);
							dao.setProcInValue(procIndex3, "strWardCode",_LPIssueDeskTransVO.getStrWardCode(), 22);
							dao.setProcInValue(procIndex3, "strEpisodeCode",_LPIssueDeskTransVO.getStrEpisodeCode(), 23);
							dao.setProcInValue(procIndex3, "strVisitNo",_LPIssueDeskTransVO.getStrVisitNo(), 24);
							dao.setProcInValue(procIndex3, "strVisitType",_LPIssueDeskTransVO.getStrVisitType(), 25);
							dao.setProcInValue(procIndex3, "strRecieveBy",_LPIssueDeskTransVO.getStrReceivedby(), 26);
							dao.setProcInValue(procIndex3, "strPoNo",_LPIssueDeskTransVO.getStrPoNo(), 30);
							dao.setProcInValue(procIndex3, "strPoStoreId",_LPIssueDeskTransVO.getStrPoStoreId(), 31);
				
							
							dao.setProcInValue(procIndex3, "modval", "1", 1);
							dao.setProcInValue(procIndex3, "strOrderBy", "", 27);
							dao.setProcInValue(procIndex3, "strOrderDate", "", 28);
							dao.setProcInValue(procIndex3, "days", "", 29);
							
				
							dao.setProcInValue(procIndex3, "strBsReqNo", bsReqNo, 32);
							dao.setProcOutValue(procIndex3, "err", 1, 33);
							dao.execute(procIndex3, 1);
				
							proc_name1 = "";
							proc_name1 = "{call pkg_mms_dml.Dml_issue_dtls(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}";
							procIndex4 = dao.setProcedure(proc_name1);
							dao.setProcInValue(procIndex4, "modeval", "2", 1);
							dao.setProcInValue(procIndex4, "issuing_store_id",_LPIssueDeskTransVO.getStrStoreId(), 2);
							dao.setProcInValue(procIndex4, "issueNo", strIssueNo, 3); // 1
							dao.setProcInValue(procIndex4, "hospital_code", _LPIssueDeskTransVO.getStrHospitalCode(), 4); // 2
							dao.setProcInValue(procIndex4, "category_No",_LPIssueDeskTransVO.getStrItemCategNo(), 5);
							dao.setProcInValue(procIndex4, "indent_No",_LPIssueDeskTransVO.getStrLpRequestNo(), 6); // 5
							dao.setProcInValue(procIndex4, "reqType_id",_LPIssueDeskTransVO.getStrRequestTypeId(), 7);// 8
							dao.setProcInValue(procIndex4, "indent_Date",_LPIssueDeskTransVO.getStrRequestDate(), 8); // 6
							dao.setProcInValue(procIndex4, "raising_store_id",_LPIssueDeskTransVO.getStrRaisingStoreId(), 9); // 15
							dao.setProcInValue(procIndex4, "net_cost",_LPIssueDeskTransVO.getStrFinalCost(), 11); // 4
							dao.setProcInValue(procIndex4, "strCrNo",_LPIssueDeskTransVO.getStrCrNo(), 16); // 7
							dao.setProcInValue(procIndex4, "strAmNo",_LPIssueDeskTransVO.getStrAdmissionNo(), 17); // 9
							dao.setProcInValue(procIndex4, "strEmpNo",_LPIssueDeskTransVO.getStrEmpNo(), 18); // 10
							dao.setProcInValue(procIndex4, "fin_start_date",_LPIssueDeskTransVO.getStrFinStartDate(), 12); // 12
							dao.setProcInValue(procIndex4, "fin_end_date",_LPIssueDeskTransVO.getStrFinEndDate(), 13); // 13
							dao.setProcInValue(procIndex4, "seatId",_LPIssueDeskTransVO.getStrSeatId(), 15); // 14
							dao.setProcInValue(procIndex4, "remarks", strRemarks, 14); // 16
							dao.setProcInValue(procIndex4, "receivedBy",_LPIssueDeskTransVO.getStrReceivedby(), 10); // 17
							dao.setProcInValue(procIndex4, "strPoNo",_LPIssueDeskTransVO.getStrPoNo(), 19); // 18
							dao.setProcInValue(procIndex4, "strPoStoreId",_LPIssueDeskTransVO.getStrPoStoreId(), 20); // 19
							dao.setProcInValue(procIndex4, "strBsReqNo",bsReqNo, 21); // 19
							dao.setProcOutValue(procIndex4, "err", 1, 22);
							dao.execute(procIndex4, 1);
							synchronized (dao) 
							{
								dao.fire();
							}
							
							_LPIssueDeskTransVO.setStrIssueNo(strIssueNo);
						
					}	
				}
			}
			
		
			
		}						
		catch (Exception _err) 
		{
			_err.printStackTrace();
			_LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransDAO.insertData() --> "+ _err.getMessage());
			_LPIssueDeskTransVO.setStrMsgType("1");
		}
	}

	public static void insertRetData(LPIssueDeskTransVO _LPIssueDeskTransVO) 
	{

		//String proc_name1 = "{call pkg_mms_dml.dml_patemp_return_item_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		String proc_name1 = "";
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
		
		MmsConfigUtil mcu;
		try {
			
			mcu =new MmsConfigUtil(_LPIssueDeskTransVO.getStrHospitalCode());

			dao = new HisDAO("mms","LPIssueDeskTransDAO.insertRetData(_LPIssueDeskTransVO)");
			
			System.out.println("----------------------- LPIssueDeskTransDAO.insertRetData [ Patinet Return Start ]----------------------------------");
			
			funcIndex = dao.setFunction("{? = call MMS_MST.Generate_Returnno(?::numeric,?::numeric,?::numeric,?::numeric)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2,_LPIssueDeskTransVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3,_LPIssueDeskTransVO.getStrStoreId());
			dao.setFuncInValue(funcIndex, 4,_LPIssueDeskTransVO.getStrRequestTypeId());
			dao.setFuncInValue(funcIndex, 5,_LPIssueDeskTransVO.getStrItemCategNo());
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			strReturnNo = dao.getFuncString(funcIndex);
			_LPIssueDeskTransVO.setStrReturnNo(strReturnNo);
			
			System.out.println("-------------------------- pkg_mms_dml.dml_patemp_return_dtl Mode -[ 1 ] --------------------------");
			
			proc_name1 = "";
			proc_name1 = "{call pkg_mms_dml.dml_patemp_return_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			procIndex1 = dao.setProcedure(proc_name1);

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

			temp = _LPIssueDeskTransVO.getStrItemParamValue()[0].replace('@',
					'#').split("#");
			strIssueUnitId = temp[1];

			length = _LPIssueDeskTransVO.getStrItemParamValue().length;
			
			System.out.println("-------------------------- pkg_mms_dml.dml_patemp_return_item_dtl Mode -[ 2 ] ------[ length "+length+"]--------------------");
			
			if (length != 0) 
			{
				for (int i = 0; i < length; i++) 
				{
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
					if(strBillTariff != null && strBillTariff != "")
					strBillTariff=strBillTariff + "^"+strItemBrandId;
					else
						strBillTariff = strItemBrandId;
					if(strBillRate != null && strBillRate != "")
						strBillRate=strBillRate + "^"+strRate;
						else
							strBillRate = strRate;
					if(strBillQty != null && strBillQty != "")
						strBillQty=strBillQty + "^"+"-"+_LPIssueDeskTransVO.getStrReturnQty()[i];
						else
							strBillQty = "-"+_LPIssueDeskTransVO.getStrReturnQty()[i];
					if(strBillBatch != null && strBillBatch != "")
						strBillBatch=strBillBatch + "^"+strBatchSlNo;
						else
							strBillBatch = strBatchSlNo;
					
					proc_name1 = "{call pkg_mms_dml.dml_patemp_return_item_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
					procIndex1 = dao.setProcedure(proc_name1);
					dao.setProcInValue(procIndex1, "modval", 			"2", 1); 
					dao.setProcInValue(procIndex1, "store_id",			_LPIssueDeskTransVO.getStrStoreId(), 2);
					dao.setProcInValue(procIndex1, "return_no", 		strReturnNo, 3); 
					dao.setProcInValue(procIndex1, "item_id", 			strItemId, 4); 
					dao.setProcInValue(procIndex1, "itembrand_id",		strItemBrandId, 5); 
					dao.setProcInValue(procIndex1, "batch_sl_no", 		strBatchSlNo,6); 
					dao.setProcInValue(procIndex1, "hosp_code",			_LPIssueDeskTransVO.getStrHospitalCode(), 7); 
					dao.setProcInValue(procIndex1, "return_date", 		"", 8);
					dao.setProcInValue(procIndex1, "item_sl_no",		strItemSlNo.trim(), 9); 
					dao.setProcInValue(procIndex1, "group_id", 			strGroupId, 10); 
					dao.setProcInValue(procIndex1, "inhand_qty", 		"0", 11);
					dao.setProcInValue(procIndex1, "subgroup_id",		strSubGroupId, 12); 					
					dao.setProcInValue(procIndex1, "balance_qty",		Float.toString(getBalanaceQty), 13);  // commented by vikrant after discussion
					dao.setProcInValue(procIndex1, "inhand_qty_unitid", "", 14);
					dao.setProcInValue(procIndex1, "balanceqty_unitid",	strIssueUnitId, 15); 
					dao.setProcInValue(procIndex1, "return_qty",		_LPIssueDeskTransVO.getStrReturnQty()[i], 16); 
					dao.setProcInValue(procIndex1, "retqty_unitid", 	temp[0], 17); 
					dao.setProcInValue(procIndex1, "rate", 				strRate, 18); 
					dao.setProcInValue(procIndex1, "rate_unitid",		strRateUnitId, 19); 
					dao.setProcInValue(procIndex1, "remarks",			_LPIssueDeskTransVO.getStrRemarks(), 20); 
					dao.setProcInValue(procIndex1, "isvalid", 			"1", 21); 
					dao.setProcInValue(procIndex1, "cost",				_LPIssueDeskTransVO.getItemCost()[i], 22); 
					dao.setProcInValue(procIndex1, "stock_status_code",	strStockStatus, 23);
					dao.setProcInValue(procIndex1, "issueNo",			_LPIssueDeskTransVO.getStrIssueNo(), 24);
					dao.setProcInValue(procIndex1, "strItemCategNo",	_LPIssueDeskTransVO.getStrItemCategNo(), 25);
					dao.setProcInValue(procIndex1, "strDescription",	"Return From Patient having CR No. :"+_LPIssueDeskTransVO.getStrCrNo(), 26);
					dao.setProcInValue(procIndex1, "strSeatid",			_LPIssueDeskTransVO.getStrSeatId(), 27);
					dao.setProcInValue(procIndex1, "expiryDate",		strExpiryDate.trim(), 28);
					dao.setProcInValue(procIndex1, "strManufactDate",	strManuFactDate, 29);
					dao.setProcInValue(procIndex1, "strPoNo",			_LPIssueDeskTransVO.getStrPoNo(), 30);
					dao.setProcOutValue(procIndex1, "err", 				1, 31); 
					dao.execute(procIndex1,1);
					/* Setting Default Value End */
				}

			}
			
			    System.out.println("-------------------------- bill_interface.dml_online_billreq_drugs Mode -[ 1 ] --------------------------");
				int procIndex2;
				String proc_name2 = "{call bill_interface.dml_online_billreq_drugs(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}";
				procIndex2 = dao.setProcedure(proc_name2);
				dao.setProcInValue(procIndex2, "modval", 					"1", 1); // 1
				dao.setProcInValue(procIndex2, "gnum_dept_code", 			_LPIssueDeskTransVO.getStrDeptCode(), 2);
				dao.setProcInValue(procIndex2, "sblnum_chargetype_id", 		"2", 3);
				dao.setProcInValue(procIndex2, "sblnum_service_id", 		"5", 4);
				dao.setProcInValue(procIndex2, "gstr_req_no", 				strReturnNo, 5);
				dao.setProcInValue(procIndex2, "gnum_treatment_cat", 		_LPIssueDeskTransVO.getStrTreatmentCat(),6);
				dao.setProcInValue(procIndex2, "hrgnum_episode_code", 		_LPIssueDeskTransVO.getStrEpisodeCode(), 7);
				dao.setProcInValue(procIndex2, "hrgnum_puk", 				_LPIssueDeskTransVO.getStrCrNo(), 8);
				dao.setProcInValue(procIndex2, "hblnum_pat_lfaccount_no", 	"0", 9);
				dao.setProcInValue(procIndex2, "gstr_tariff", 				strBillTariff, 10);
				dao.setProcInValue(procIndex2, "gstr_tariff_batch", 		strBillBatch, 11);
				dao.setProcInValue(procIndex2, "gstr_tariff_rates", 		strBillRate, 12);
				dao.setProcInValue(procIndex2, "gstr_reqqty", 				strBillQty, 13);
				dao.setProcInValue(procIndex2, "hblstr_patient_name", 		"", 14);
				dao.setProcInValue(procIndex2, "hblstr_pat_address", 		"", 15);
				dao.setProcInValue(procIndex2, "hblstr_contact_no", 		"", 16);
				dao.setProcInValue(procIndex2, "age", 						"1", 17);
				dao.setProcInValue(procIndex2, "ageunit", 					"1", 18);
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
				
				System.out.println("----------------------- [ Patinet Return END ]----------------------------------");
			

			
			
			synchronized (dao) {
				dao.fire();
			}


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
			
			System.out.println("------------- pkg_mms_view.proc_consultant_name  -----[ Mode - 2]---------");
			
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
			
			System.out.println("------------- MMS_MST.get_store_dtl  -----[ Mode - 3]---------");

			dao.setFuncInValue(funcIndex, 2, "3");
			dao.setFuncInValue(funcIndex, 3,
					_LPIssueDeskTransVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4,
					_LPIssueDeskTransVO.getStrRaisingStoreId());
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			strDeptName = dao.getFuncString(funcIndex);
			//System.out.println("------------- strDeptName  ------"+strDeptName);
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
	
	public static void getRaisingStoreName(LPIssueDeskTransVO _LPIssueDeskTransVO) 
	{

		HisDAO dao = null;
		int funcIndex = 0;
		String strRaisingStoreName = "";
		try {

			dao = new HisDAO("MMSModule", "LPIssueDeskTransDAO");
			funcIndex = dao
					.setFunction("{? = call MMS_MST.get_store_dtl(?,?,?)}");
			// Set Value
			
			System.out.println("------------- MMS_MST.get_store_dtl  -----[ Mode - 3]---------");

			dao.setFuncInValue(funcIndex, 2, "1");
			dao.setFuncInValue(funcIndex, 3,_LPIssueDeskTransVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4,_LPIssueDeskTransVO.getStrRaisingStoreId());
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			strRaisingStoreName = dao.getFuncString(funcIndex);
			//System.out.println("------------- Store_Name  ------"+strRaisingStoreName);
			if (strRaisingStoreName != null && !strRaisingStoreName.equals("null"))
				_LPIssueDeskTransVO.setStrRaisingStoreName(strRaisingStoreName);
			else
				_LPIssueDeskTransVO.setStrRaisingStoreName("-");
		} catch (Exception _err) {
			_err.printStackTrace();
			_LPIssueDeskTransVO
					.setStrMsgString("LPIssueDeskTransDAO.getRaisingStoreName() --> "
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
			 System.out.println("-------------  LPIssueDeskTransDAO . getPatientAccountDetails  --------------");
				
			 System.out.println("-------------  pkg_mms_view.proc_hstt_pat_account_dtl  ------[Mode - 1]--------");
			 
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
    		
    		System.out.println("-------------  LPIssueDeskTransDAO . getPatientDiagDetails  --------------");
			
			 System.out.println("-------------  pkg_mms_view.proc_diag_emp_view  ------[Mode - 1]--------");
			 
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
			
			System.out.println("-------------  LPIssueDeskTransDAO . getSingleBatchItemDtl  --------------");
			
			 System.out.println("-------------  pkg_mms_view.proc_itemStock_dtl  ------[Mode - 6]--------");
			 
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
			
			System.out.println("-------------  LPIssueDeskTransDAO . getBrandDetails  --------------");
			
			 System.out.println("-------------  pkg_mms_view.proc_brand_list  ------[Mode - 1]--------");
			
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
	public static void getPatientAccountDetailsNew(LPIssueDeskTransVO vo) {

		
		String strProcName = "{call PKG_MMS_VIEW.proc_hstt_pat_account_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		WebRowSet ws = null;
		HisDAO daoObj = null;
		try {
			
			System.out.println("-------------  LPIssueDeskTransDAO . getPatientAccountDetailsNew  --------------");
			
			 System.out.println("-------------  pkg_mms_view.proc_hstt_pat_account_dtl  ------[Mode - 2]--------");
			 
			daoObj = new HisDAO("MMSModule", "LPIssueDeskTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2", 1);
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
	
	
	public static void getItemDetailsPrint(LPIssueDeskTransVO vo) 
	{
		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";

    	try 
		{
    		System.out.println("----- LPIssueDeskTransDAO . getItemDetailsView--PKG_MMS_VIEW.PROC_GET_INDENTITEM_DTL--- [ Mode- 1] -------");
    		////System.out.println("vo.getStrReqTypeId()"+vo.getStrReqTypeId());
    		String strProcName = "{call PKG_MMS_VIEW.PROC_GET_INDENTITEM_DTL(?,?,?,?,?,?,?)}";

			daoObj = new HisDAO("MMS Transactions","LPIssueDeskTransDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
     		daoObj.setProcInValue(nProcIndex, "modval", "1",1);
	     	daoObj.setProcInValue(nProcIndex, "storeId",vo.getStrRaisingStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "reqNo",vo.getStrLpRequestNo(),4);
			daoObj.setProcInValue(nProcIndex, "reqTypeId",vo.getStrRequestTypeId(),5);
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
			vo.setStrMsgString("--> LPIssueDeskTransDAO.getItemDetails()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null)
				daoObj.free();
				daoObj = null;
			}

		}
	
	public static void getIndentDetailsPrint(LPIssueDeskTransVO vo) 
	{
		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";

    	try 
		{
    		System.out.println("----- LPIssueDeskTransDAO . getIndentDetailsView--PKG_MMS_VIEW.Get_Indent_Details--- [ Mode- 1] -------");
    		
    		daoObj = new HisDAO("MMS Transactions","LPIssueDeskTransDAO");
    		
			String strProcName = "{call PKG_MMS_VIEW.Get_Indent_Details(?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "storeId",vo.getStrRaisingStoreId(),1);
			////System.out.println("Store Id->>"+vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "reqNo",vo.getStrLpRequestNo(),3);
			daoObj.setProcInValue(nProcIndex, "reqTypeId","",4); // Default value
			////System.out.println("Req no-->>"+vo.getStrReqNo());
				
				
			daoObj.setProcOutValue(nProcIndex,"err",1,5);
			daoObj.setProcOutValue(nProcIndex,"resultset", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) 
			{
    			wb = daoObj.getWebRowSet(nProcIndex, "resultset");
				vo.setStrIndentDetailsWs(wb);
				
			 }
			 else 
			 {
				throw new Exception(strErr);
			 }
    	} 
    	catch (Exception e) 
    	{
			vo.setStrMsgString("--> LPIssueDeskTransDAO.getIndentDetails()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null)
				daoObj.free();
				daoObj = null;
			}

		}
	
	
	public static void callingFunctionIndentNameView(LPIssueDeskTransVO vo) 
	{
		// Declearing Variable
		String retVal = null;
		int funcIndex = 0;
		HisDAO    dao = null;
		try 
		{
			dao = new HisDAO("MMSModule", "LPIssueDeskTransDAO");
			funcIndex = dao.setFunction("{? = call MMS_MST.get_indentType_Name(?::numeric,?::numeric,?::numeric)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, "1");
			dao.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4, vo.getStrRequestTypeId());
			dao.setFuncOutValue(funcIndex, 1);
			// Execute Function
			dao.executeFunction(funcIndex);
			retVal = dao.getFuncString(funcIndex);
			if (retVal != null) 
			{
				vo.setStrIndentName(retVal);
			} 
			else 
			{
				retVal = "-----";
				vo.setStrIndentName(retVal);
			}

		} catch (Exception e) {
			vo
					.setStrMsgString("LPIssueDeskTransDAO.callingFunctionIndentName() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
}
