package dossier.transaction.dao;

import hisglobal.transactionmgnt.HisDAO;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.transactions.vo.RequestForLPPatientVO;
import dossier.transaction.vo.DossierDeskTransVO;


public class DossierDeskTransDAO {
	/**
	 * To get Indent Details i.e.(Store Name,Indent No.,Indent Date,Indent
	 * Type,Item Category,Raising Store) on 'issue' page
	 * 
	 * @param vo
	 */
	public static void getLPRequestDetail(DossierDeskTransVO _DossierDeskTransVO) {

		String err = "";
		String proc_name1 = "{call pkg_dossier_view.proc_hstt_lp_req_item_dtl(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		int funcIndex;
		String BillingValue="";
		try {
			
			dao = new HisDAO("mms",
					"LPIssueDeskTransDAO.getIndentDetail(DossierDeskTransVO vo)");
			funcIndex = dao.setFunction("{? = call bill_mst.get_pat_accountdetails_limit(?,?,?)}");

					dao.setFuncInValue(funcIndex, 2,_DossierDeskTransVO.getStrHospitalCode());
					dao.setFuncInValue(funcIndex, 3,"2");
					dao.setFuncInValue(funcIndex, 4,_DossierDeskTransVO.getStrCrNo());
					//dao.setFuncInValue(funcIndex, 5,_DossierDeskTransVO.getStrItemCategNo());
					dao.setFuncOutValue(funcIndex, 1);
					dao.executeFunction(funcIndex);
					BillingValue = dao.getFuncString(funcIndex); 
					System.out.println("BillingValue"+BillingValue);
					_DossierDeskTransVO.setStrBillingHiddenValue(BillingValue);
					
					
			
			

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modval", "1", 1);
			dao.setProcInValue(procIndex1, "lPRequestNo",
					_DossierDeskTransVO.getStrLpRequestNo(), 2);

			dao.setProcInValue(procIndex1, "strRasingStoreId",
					_DossierDeskTransVO.getStrRaisingStoreId(), 3);

			dao.setProcInValue(procIndex1, "hosp_code",
					_DossierDeskTransVO.getStrHospitalCode(), 4);

			// dao.setProcInValue(procIndex1, "strRequestDate",
			// _DossierDeskTransVO.getStrRequestDate());

			/* Setting Default Value Start */

			dao.setProcInValue(procIndex1, "strRequestNo", _DossierDeskTransVO.getStrLpRequestNo(), 5);
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
				_DossierDeskTransVO.setRequestItemDtlWS(ws);

			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			e.printStackTrace();
			_DossierDeskTransVO
					.setStrMsgString("LPIssueDeskTransDAO.getLPRequestDetail() --> "
							+ e.getMessage());
			_DossierDeskTransVO.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	
	public static void getLPRequestDetail_new(DossierDeskTransVO _DossierDeskTransVO) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_hstt_lp_req_item_dtl(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		int funcIndex;
		String BillingValue="";
		try {

			dao = new HisDAO("mms",
					"LPIssueDeskTransDAO.getLPRequestDetail_new(DossierDeskTransVO vo)");

			funcIndex = dao.setFunction("{? = call bill_mst.get_pat_accountdetails_limit(?,?,?)}");

			dao.setFuncInValue(funcIndex, 2,_DossierDeskTransVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3,"2");
			dao.setFuncInValue(funcIndex, 4,_DossierDeskTransVO.getStrCrNo());
			//dao.setFuncInValue(funcIndex, 5,_DossierDeskTransVO.getStrItemCategNo());
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			BillingValue = dao.getFuncString(funcIndex); 
			System.out.println("BillingValue"+BillingValue);
			_DossierDeskTransVO.setStrBillingHiddenValue(BillingValue);
			
			
			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modval", "2", 1);
			dao.setProcInValue(procIndex1, "lPRequestNo",
					_DossierDeskTransVO.getStrBSReqNo(), 2);

			dao.setProcInValue(procIndex1, "strRasingStoreId",
					_DossierDeskTransVO.getStrStoreId(), 3);

			dao.setProcInValue(procIndex1, "hosp_code",
					_DossierDeskTransVO.getStrHospitalCode(), 4);

			// dao.setProcInValue(procIndex1, "strRequestDate",
			// _DossierDeskTransVO.getStrRequestDate());

			/* Setting Default Value Start */

			dao.setProcInValue(procIndex1, "strRequestNo", _DossierDeskTransVO.getStrLpRequestNo(), 5);
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

				_DossierDeskTransVO.setRequestItemDtlWS(ws);

			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			e.printStackTrace();
			_DossierDeskTransVO
					.setStrMsgString("LPIssueDeskTransDAO.getLPRequestDetail() --> "
							+ e.getMessage());
			_DossierDeskTransVO.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}

	public static void getIssuedItemDtl(DossierDeskTransVO _DossierDeskTransVO) {

		String err = "";
		String proc_name1 = "{call pkg_dossier_view.Proc_patemp_issue_item_dtl(?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		

		try {

			dao = new HisDAO("mms",
					"LPIssueDeskTransDAO.getIndentDetail(DossierDeskTransVO vo)");

			System.out.println(_DossierDeskTransVO.getStrIssueNo() + " "
					+ _DossierDeskTransVO.getStrIssueStoreId() + " "
					+ _DossierDeskTransVO.getStrHospitalCode());

			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "modval", "2", 1);

			// set value
			dao.setProcInValue(procIndex1, "issue_No",
					_DossierDeskTransVO.getStrIssueNo(), 4);//Request number is being passed name is wrong......discuss

			dao.setProcInValue(procIndex1, "store_id",
					_DossierDeskTransVO.getStrIssueStoreId(), 2);

			dao.setProcInValue(procIndex1, "hosp_code",
					_DossierDeskTransVO.getStrHospitalCode(), 3);

			// dao.setProcInValue(procIndex1, "strRequestDate",
			// _DossierDeskTransVO.getStrRequestDate());

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
				_DossierDeskTransVO.setIssuedItemDtlWS(ws);

			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			e.printStackTrace();
			_DossierDeskTransVO
					.setStrMsgString("LPIssueDeskTransDAO.getIssuedItemDtl() --> "
							+ e.getMessage());
			_DossierDeskTransVO.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
	
	
	public static void getIssuedItemDtlview(DossierDeskTransVO _DossierDeskTransVO) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.Proc_patemp_issue_item_dtl(?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms",
					"LPIssueDeskTransDAO.getIndentDetail(DossierDeskTransVO vo)");

			System.out.println(_DossierDeskTransVO.getStrIssueNo() + " "
					+ _DossierDeskTransVO.getStrIssueStoreId() + " "
					+ _DossierDeskTransVO.getStrHospitalCode());

			procIndex1 = dao.setProcedure(proc_name1);
			if(!_DossierDeskTransVO.getStrRequestTypeId().equals("32"))
				dao.setProcInValue(procIndex1, "modval", "3", 1);
			else
				dao.setProcInValue(procIndex1, "modval", "4", 1);

			// set value
			dao.setProcInValue(procIndex1, "issue_No",
					_DossierDeskTransVO.getStrIssueNo(), 4);//Request number is being passed name is wrong......discuss

			dao.setProcInValue(procIndex1, "store_id",
					_DossierDeskTransVO.getStrIssueStoreId(), 2);

			dao.setProcInValue(procIndex1, "hosp_code",
					_DossierDeskTransVO.getStrHospitalCode(), 3);

			// dao.setProcInValue(procIndex1, "strRequestDate",
			// _DossierDeskTransVO.getStrRequestDate());

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
				_DossierDeskTransVO.setIssuedItemDtlWS(ws);

			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			e.printStackTrace();
			_DossierDeskTransVO
					.setStrMsgString("LPIssueDeskTransDAO.getIssuedItemDtl() --> "
							+ e.getMessage());
			_DossierDeskTransVO.setStrMsgType("1");

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
	public static void getReturnUnitCombo(DossierDeskTransVO _DossierDeskTransVO) {
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
					_DossierDeskTransVO.getStrHospitalCode(), 1);
			dao.setProcInValue(nProcIndex, "unit_id",
					_DossierDeskTransVO.getStrBalanceQtUnitId(), 2);

			dao.setProcInValue(nProcIndex, "module_id", "", 3);// Default Value

			dao.setProcOutValue(nProcIndex, "err", 1, 5);
			dao.setProcOutValue(nProcIndex, "resultset", 2, 6);

			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				_DossierDeskTransVO.setUnitComboWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			_DossierDeskTransVO
					.setStrMsgString("LPIssueDeskTransDAO.getReturnUnitCombo() --> "
							+ e.getMessage());
			_DossierDeskTransVO.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	public static void getIssueItemDtl(DossierDeskTransVO _DossierDeskTransVO) {

		String err = "";
		String proc_name1 = "{call pkg_dossier_view.Proc_hstt_chall_verifiitem_dtl(?,?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms",
					"LPIssueDeskTransDAO.getIssueItemDtl(DossierDeskTransVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modval", "1", 1);
			dao.setProcInValue(procIndex1, "strId",
					_DossierDeskTransVO.getStrStoreId(), 2);
			dao.setProcInValue(procIndex1, "lPRequestNo",
					_DossierDeskTransVO.getStrLpRequestNo(), 3);

			dao.setProcInValue(procIndex1, "hosp_code",
					_DossierDeskTransVO.getStrHospitalCode(), 4);
			dao.setProcInValue(procIndex1, "poNo",
					_DossierDeskTransVO.getStrPoNo(), 5);
			dao.setProcInValue(procIndex1, "poStoreId",
					_DossierDeskTransVO.getStrPoStoreId(), 6);

			// Default Value

			// dao.setProcInValue(procIndex1, "strRequestDate",
			// _DossierDeskTransVO.getStrRequestDate());

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
				_DossierDeskTransVO.setIssueItemDtlWS(ws);

			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			e.printStackTrace();
			_DossierDeskTransVO
					.setStrMsgString("LPIssueDeskTransDAO.getIssueItemDtl() --> "
							+ e.getMessage());
			_DossierDeskTransVO.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
	public static void getIssueItemDtl_new(DossierDeskTransVO _DossierDeskTransVO) {

		String err = "";
		String proc_name1 = "{call pkg_dossier_view.Proc_hstt_chall_verifiitem_dtl(?,?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms",
					"LPIssueDeskTransDAO.getIssueItemDtl(DossierDeskTransVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modval", "1", 1);
			dao.setProcInValue(procIndex1, "strId",
					_DossierDeskTransVO.getStrStoreId(), 2);
			dao.setProcInValue(procIndex1, "lPRequestNo",
					_DossierDeskTransVO.getStrBSReqNo(), 3);

			dao.setProcInValue(procIndex1, "hosp_code",
					_DossierDeskTransVO.getStrHospitalCode(), 4);
			dao.setProcInValue(procIndex1, "poNo",
					_DossierDeskTransVO.getStrPoNo(), 5);
			dao.setProcInValue(procIndex1, "poStoreId",
					_DossierDeskTransVO.getStrPoStoreId(), 6);

			// Default Value

			// dao.setProcInValue(procIndex1, "strRequestDate",
			// _DossierDeskTransVO.getStrRequestDate());

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
				_DossierDeskTransVO.setIssueItemDtlWS(ws);

			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			e.printStackTrace();
			_DossierDeskTransVO
					.setStrMsgString("LPIssueDeskTransDAO.getIssueItemDtl() --> "
							+ e.getMessage());
			_DossierDeskTransVO.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	public static void insertData(DossierDeskTransVO _DossierDeskTransVO) 
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
		String stritemcat="";
		String strBillQty = "";
		String                       values[] = null;
		String bsReqNo="0";
		int pIndex = 0;
		int pIndex1;
		String p_name="";String p_name1="";
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
			
			mcu =new MmsConfigUtil(_DossierDeskTransVO.getStrHospitalCode());
			dao = new HisDAO("mms","LPIssueDeskTransDAO.insertData(_DossierDeskTransVO)");
			length = _DossierDeskTransVO.getStrItemParamValue().length;

			funcIndex = dao.setFunction("{? = call MMS_MST.generate_issueNo(?,?,?,?)}");

			dao.setFuncInValue(funcIndex, 2,_DossierDeskTransVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3,_DossierDeskTransVO.getStrStoreId());
			dao.setFuncInValue(funcIndex, 4,_DossierDeskTransVO.getStrRequestTypeId());
			dao.setFuncInValue(funcIndex, 5,"97");
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			strIssueNo = dao.getFuncString(funcIndex); 
			temp = _DossierDeskTransVO.getStrItemParamValue()[0].replace('@','#').split("#");
			strIssueUnitId = temp[3];
			strRateUnitId = temp[3];
		
				strIssueQty = temp[2];
			if (length != 0) {
				for (int i = 0; i < length; i++) {

					temp = _DossierDeskTransVO.getStrItemParamValue()[i]
							.replace('@', '#').split("#");
					strItemBrandId = temp[1];
					strItemId = temp[0];
					strRate = temp[6];
				
					strGroupId = "";
					strSubGroupId = "";
					strBatchSlNo = temp[5];				
					strIssueQty = _DossierDeskTransVO.getStrIssueQuantity()[i].split(" ")[0];
					strStoreId = _DossierDeskTransVO.getStrStoreId();
					hosp_code = _DossierDeskTransVO.getStrHospitalCode();
					strItemSlNo = "0";
					strStockStatus = "10";
				
					strConsumableFlag = "1";
					strRemarks = _DossierDeskTransVO.getStrRemarks();
					//strItemCost = temp[9];
					strIssueUnitId = temp[3];
					stritemcat = temp[7];
								
						
							if(Double.parseDouble(_DossierDeskTransVO.getStrIssueQuantity()[i].split(" ")[0]) > 0.0)
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
									System.out.println("strBillTariff:::::"+strBillTariff);
									System.out.println("strBillRate:::::"+strBillRate);
									System.out.println("strBillQty:::::"+strBillQty);
									System.out.println("strBillBatch:::::"+strBillBatch);
									
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
								dao.setProcInValue(procIndex1, "strRequestNo",_DossierDeskTransVO.getStrLpRequestNo(), 21); // 20?
								dao.setProcInValue(procIndex1, "strRasingStoreId",_DossierDeskTransVO.getStrRaisingStoreId(), 22);
								dao.setProcInValue(procIndex1, "strItemCatNo",stritemcat, 23); // 21
								dao.setProcInValue(procIndex1, "strSeatid",_DossierDeskTransVO.getStrSeatId(), 24);
								dao.setProcInValue(procIndex1, "strDescription",_DossierDeskTransVO.getStrDescription(), 25);
								dao.setProcInValue(procIndex1, "crno",_DossierDeskTransVO.getStrCrNo(), 26);
								dao.setProcOutValue(procIndex1, "err", 1, 27); // 22
								dao.execute(procIndex1,1);
		
							}
						
				}
			}
			if(mcu.getStrBillingIntegration().equals("1"))
			{
				if(!strBillTariff.equals("") && strBillTariff != null)
				{
					int procIndex2;
					String proc_name2 = "{call bill_interface.dml_online_billreq_drugs(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}";
					procIndex2 = dao.setProcedure(proc_name2);
					dao.setProcInValue(procIndex2, "modval", "1", 1); // 1
					dao.setProcInValue(procIndex2, "gnum_dept_code", _DossierDeskTransVO.getStrDeptCode(), 2);
					System.out.println("gnum_dept_code"+_DossierDeskTransVO.getStrDeptCode());
					dao.setProcInValue(procIndex2, "sblnum_chargetype_id", "2", 3);
					dao.setProcInValue(procIndex2, "sblnum_service_id", "5", 4);
					dao.setProcInValue(procIndex2, "gstr_req_no", strIssueNo, 5);
					dao.setProcInValue(procIndex2, "gnum_treatment_cat", _DossierDeskTransVO.getStrTreatmentCat(),6);
					System.out.println("gnum_treatment_cat"+_DossierDeskTransVO.getStrTreatmentCat());
					dao.setProcInValue(procIndex2, "hrgnum_episode_code", _DossierDeskTransVO.getStrEpisodeCode(), 7);
					System.out.println("hrgnum_episode_code"+_DossierDeskTransVO.getStrEpisodeCode());
					dao.setProcInValue(procIndex2, "hrgnum_puk", _DossierDeskTransVO.getStrCrNo(), 8);
					System.out.println("hrgnum_puk"+_DossierDeskTransVO.getStrCrNo());
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
					dao.setProcInValue(procIndex2, "gnum_seatid", _DossierDeskTransVO.getStrSeatId(), 22);
					System.out.println("gnum_seatid"+_DossierDeskTransVO.getStrSeatId());
					dao.setProcInValue(procIndex2, "hosp_code", _DossierDeskTransVO.getStrHospitalCode(), 23);
					System.out.println("hosp_code"+_DossierDeskTransVO.getStrHospitalCode());
					dao.setProcInValue(procIndex2, "ward_code", _DossierDeskTransVO.getStrWardCode(), 24);
					System.out.println("ward_code"+_DossierDeskTransVO.getStrWardCode());
					dao.setProcInValue(procIndex2, "admno", _DossierDeskTransVO.getStrAdmissionNo(), 25);
					System.out.println("admno"+_DossierDeskTransVO.getStrAdmissionNo());
					dao.setProcInValue(procIndex2, "visitno", _DossierDeskTransVO.getStrVisitNo(), 26);
					System.out.println("visitno"+_DossierDeskTransVO.getStrVisitNo());
					dao.setProcOutValue(procIndex2, "err", 1, 27);
					System.out.println("strBillRate------"+strBillRate);
					dao.execute(procIndex2, 1);
				}
			}
			if(_DossierDeskTransVO.getStrBSReqNo().equals("0"))
			{
				if(_DossierDeskTransVO.getStrBSIndent().equals("1"))
				{
						int itmln = _DossierDeskTransVO.getStrBSQuantity().length;
					
						RequestForLPPatientVO vo = new RequestForLPPatientVO();
						vo.setStrStoreId(_DossierDeskTransVO.getStrStoreId());
						vo.setStrHospitalCode(_DossierDeskTransVO.getStrHospitalCode());
						vo.setStrReqType("86");
						vo.setStrToStoreCombo(_DossierDeskTransVO.getStrStoreId());
						vo.setStrItemCategoryNo(_DossierDeskTransVO.getStrItemCategNo());
						vo.setStrUrgentFlg(_DossierDeskTransVO.getStrUrgentFlg());//need to change later
						vo.setStrFinancialEndYear(_DossierDeskTransVO.getStrFinEndDate());
						vo.setStrFinancialStartYear(_DossierDeskTransVO.getStrFinStartDate());
						vo.setStrRemarks(_DossierDeskTransVO.getStrRemarks());
						vo.setStrSeatId(_DossierDeskTransVO.getStrSeatId());
						vo.setStrGrantType("0");
						vo.setStrCrNo(_DossierDeskTransVO.getStrCrNo());
						vo.setStrEmpNo("0");
						vo.setStrAdmnNo(_DossierDeskTransVO.getStrAdmissionNo());
						vo.setStrApproxAmt("0");
						List<String> tArr=new ArrayList<String>();
						List<String> reqQty=new ArrayList<String>();
						List<String> reqUnit=new ArrayList<String>();
						for(int i=0;i<itmln;i++)
						{
							//10000002@10100002@11.00@6301@997533.00@gt5@2.36
							temp = _DossierDeskTransVO.getStrItemParamValue()[i].replace('@', '#').split("#");
						   
							 //int j=0;
							
							 if(!_DossierDeskTransVO.getStrBSQuantity()[i].equals("0"))
							 {
								tArr.add("0#0#"+temp[0]+"^"+temp[1]+"^0^0^0^0^0^"+temp[4]+"^"+temp[3]+"^"+temp[6]+"^"+temp[3]+"^0^0^^0^0^0^0^0^0^0^0^0^0^0^0^0") ;
								reqQty.add(_DossierDeskTransVO.getStrBSQuantity()[i]);
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
						
						_DossierDeskTransVO.setStrBSReqNo(bsReqNo);
						// added to update Bs req no in sstt_indent_dtl table
						p_name = "{call pkg_mms_dml.Dml_update_sstt_indent_dtl(?,?,?,?,? ,?)}";
					
					pIndex = dao.setProcedure(p_name);
					
					dao.setProcInValue(pIndex, "modval", "1", 1);
					dao.setProcInValue(pIndex, "hosp_code", _DossierDeskTransVO.getStrHospitalCode(), 2);
					dao.setProcInValue(pIndex, "reqNo", _DossierDeskTransVO.getStrLpRequestNo(), 3);
					dao.setProcInValue(pIndex, "bsNo", bsReqNo, 4);
					dao.setProcInValue(pIndex, "raising_store",_DossierDeskTransVO.getStrRaisingStoreId(), 5);
					dao.setProcOutValue(pIndex, "err", 1, 6);
					dao.executeProcedureByPosition(pIndex);
						
				}
				else
				{
					// added to update Bs req no in sstt_indent_dtl table
					p_name = "{call pkg_mms_dml.Dml_update_sstt_indent_dtl(?,?,?,?,? ,?)}";
				
				pIndex = dao.setProcedure(p_name);
				
				dao.setProcInValue(pIndex, "modval", "1", 1);
				dao.setProcInValue(pIndex, "hosp_code", _DossierDeskTransVO.getStrHospitalCode(), 2);
				dao.setProcInValue(pIndex, "reqNo", _DossierDeskTransVO.getStrLpRequestNo(), 3);
				dao.setProcInValue(pIndex, "bsNo", "0", 4);
				dao.setProcInValue(pIndex, "raising_store",_DossierDeskTransVO.getStrRaisingStoreId(), 5);
				dao.setProcOutValue(pIndex, "err", 1, 6);
				dao.execute(pIndex,1);
				}
		}
			
			if (length != 0) {
				for (int i = 0; i < length; i++) {
					strIssueQty = _DossierDeskTransVO.getStrIssueQuantity()[i].split(" ")[0];
				
							
						if(!strIssueQty.equals("0.00") && !strIssueQty.equals("0"))
						{
							i=length;
							proc_name1 = "";
							proc_name1 = "{call pkg_mms_dml.Dml_hstt_patemp_issue_dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?)}";
				
							procIndex3 = dao.setProcedure(proc_name1);
							dao.setProcInValue(procIndex3, "strIssueNo", strIssueNo, 2); // 1
							dao.setProcInValue(procIndex3, "hosp_code", _DossierDeskTransVO.getStrHospitalCode(), 3); // 2
							dao.setProcInValue(procIndex3, "strStoreId",_DossierDeskTransVO.getStrStoreId(), 4); // 3
							dao.setProcInValue(procIndex3, "strFinalCost",_DossierDeskTransVO.getStrFinalCost(), 6); // 4
							dao.setProcInValue(procIndex3, "strRequestNo",_DossierDeskTransVO.getStrLpRequestNo(), 7); // 5
							dao.setProcInValue(procIndex3, "strRequestDate",_DossierDeskTransVO.getStrFinStartDate(), 8); // 6
							dao.setProcInValue(procIndex3, "strCrNo",_DossierDeskTransVO.getStrCrNo(), 9); // 7
							dao.setProcInValue(procIndex3, "strReqTypeId",_DossierDeskTransVO.getStrRequestTypeId(), 10);// 8
							dao.setProcInValue(procIndex3, "strAdmNo",_DossierDeskTransVO.getStrAdmissionNo(), 11); // 9
							dao.setProcInValue(procIndex3, "strEmpNo",_DossierDeskTransVO.getStrEmpNo(), 12); // 10
							dao.setProcInValue(procIndex3, "strItemCatNo","98", 13); // 11
							dao.setProcInValue(procIndex3, "strFinStartDate",_DossierDeskTransVO.getStrFinStartDate(), 14); // 12
							dao.setProcInValue(procIndex3, "strFinEndDate",_DossierDeskTransVO.getStrFinEndDate(), 15); // 13
							dao.setProcInValue(procIndex3, "strSeatId",_DossierDeskTransVO.getStrSeatId(), 16); // 14
							dao.setProcInValue(procIndex3, "strRaisingStoreId",_DossierDeskTransVO.getStrRaisingStoreId(), 17); // 15
							//dao.setProcInValue(procIndex3, "strIssueQty", strIssueQty, 18); // 16
							
							dao.setProcInValue(procIndex3, "strIssueQty", strIssueQty, 18);
							dao.setProcInValue(procIndex3, "strIssueUnitId", strIssueUnitId, 19); // 17
							dao.setProcInValue(procIndex3, "strRemarks", strRemarks, 5); // 18
							dao.setProcInValue(procIndex3, "strDeptCode",_DossierDeskTransVO.getStrDeptCode(), 20);
							dao.setProcInValue(procIndex3, "strDeptUnitCode",_DossierDeskTransVO.getStrDeptUnitCode(), 21);
							dao.setProcInValue(procIndex3, "strWardCode",_DossierDeskTransVO.getStrWardCode(), 22);
							dao.setProcInValue(procIndex3, "strEpisodeCode",_DossierDeskTransVO.getStrEpisodeCode(), 23);
							dao.setProcInValue(procIndex3, "strVisitNo",_DossierDeskTransVO.getStrVisitNo(), 24);
							dao.setProcInValue(procIndex3, "strVisitType",_DossierDeskTransVO.getStrVisitType(), 25);
							dao.setProcInValue(procIndex3, "strRecieveBy",_DossierDeskTransVO.getStrReceivedby(), 26);
							dao.setProcInValue(procIndex3, "strPoNo",_DossierDeskTransVO.getStrPoNo(), 30);
							dao.setProcInValue(procIndex3, "strPoStoreId",_DossierDeskTransVO.getStrPoStoreId(), 31);
				
							
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
							dao.setProcInValue(procIndex4, "issuing_store_id",_DossierDeskTransVO.getStrStoreId(), 2);
							dao.setProcInValue(procIndex4, "issueNo", strIssueNo, 3); // 1
							dao.setProcInValue(procIndex4, "hospital_code", _DossierDeskTransVO.getStrHospitalCode(), 4); // 2
							dao.setProcInValue(procIndex4, "category_No",_DossierDeskTransVO.getStrItemCategNo(), 5);
							dao.setProcInValue(procIndex4, "indent_No",_DossierDeskTransVO.getStrLpRequestNo(), 6); // 5
							dao.setProcInValue(procIndex4, "reqType_id",_DossierDeskTransVO.getStrRequestTypeId(), 7);// 8
							dao.setProcInValue(procIndex4, "indent_Date",_DossierDeskTransVO.getStrRequestDate(), 8); // 6
							dao.setProcInValue(procIndex4, "raising_store_id",_DossierDeskTransVO.getStrRaisingStoreId(), 9); // 15
							dao.setProcInValue(procIndex4, "net_cost",_DossierDeskTransVO.getStrFinalCost(), 11); // 4
							dao.setProcInValue(procIndex4, "strCrNo",_DossierDeskTransVO.getStrCrNo(), 16); // 7
							dao.setProcInValue(procIndex4, "strAmNo",_DossierDeskTransVO.getStrAdmissionNo(), 17); // 9
							dao.setProcInValue(procIndex4, "strEmpNo",_DossierDeskTransVO.getStrEmpNo(), 18); // 10
							dao.setProcInValue(procIndex4, "fin_start_date",_DossierDeskTransVO.getStrFinStartDate(), 12); // 12
							dao.setProcInValue(procIndex4, "fin_end_date",_DossierDeskTransVO.getStrFinEndDate(), 13); // 13
							dao.setProcInValue(procIndex4, "seatId",_DossierDeskTransVO.getStrSeatId(), 15); // 14
							dao.setProcInValue(procIndex4, "remarks", strRemarks, 14); // 16
							dao.setProcInValue(procIndex4, "receivedBy",_DossierDeskTransVO.getStrReceivedby(), 10); // 17
							dao.setProcInValue(procIndex4, "strPoNo",_DossierDeskTransVO.getStrPoNo(), 19); // 18
							dao.setProcInValue(procIndex4, "strPoStoreId",_DossierDeskTransVO.getStrPoStoreId(), 20); // 19
							dao.setProcInValue(procIndex4, "strBsReqNo",bsReqNo, 21); // 19
							dao.setProcOutValue(procIndex4, "err", 1, 22);
							dao.execute(procIndex4, 1);
							
						
					}	
				}
			}
			
			
			p_name1 = "{call pkg_dossier_dml.dml_update_dossier_req_dtl(?,?,?,?,? ,?)}";
			
			pIndex1 = dao.setProcedure(p_name1);
			
			dao.setProcInValue(pIndex1, "modval", "1", 1);
			dao.setProcInValue(pIndex1, "hosp_code", _DossierDeskTransVO.getStrHospitalCode(), 2);
			dao.setProcInValue(pIndex1, "reqNo", _DossierDeskTransVO.getStrLpRequestNo(), 3);
			dao.setProcInValue(pIndex1, "bsNo", _DossierDeskTransVO.getStrAdmissionNo(), 4);
			dao.setProcInValue(pIndex1, "raising_store",_DossierDeskTransVO.getStrStoreId(), 5);
			dao.setProcOutValue(pIndex1, "err", 1, 6);
			dao.execute(pIndex1,1);
			synchronized (dao) 
			{
				dao.fire();
				//dao.getString(procIndex1, "err");
			}
			
			_DossierDeskTransVO.setStrIssueNo(strIssueNo);
			
		}						
		catch (Exception _err) 
		{
			
			_err.printStackTrace();
			_DossierDeskTransVO.setStrMsgString("LPIssueDeskTransDAO.insertData() --> "+ _err.getMessage());
			_DossierDeskTransVO.setStrMsgType("1");
		}
	}

	public static void insertRetData(DossierDeskTransVO _DossierDeskTransVO) {

		String proc_name1 = "";  //"{call pkg_mms_dml.dml_patemp_return_item_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		int procIndex1 = 0, nProcIndex2 = 0, nProcIndex9 = 0, procIndex6 = 0 ,procIndex7=0 ,procIndex12 = 0;
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
		String proc_name11 ,proc_name12 = "" ,proc_name9="" ,proc_name7="" ,proc_name6="";
		String [] paramVal=null , userValue=null;
		//String proc_name2 = "{call bill_interface.dml_online_billreq_drugs(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}";
		MmsConfigUtil mcu;
		try {
			
			mcu =new MmsConfigUtil(_DossierDeskTransVO.getStrHospitalCode());
			
			System.out.println("----------------DossierDeskTransDAO.insertRetData------------------");

			dao = new HisDAO("mms","LPIssueDeskTransDAO.insertData(_DossierDeskTransVO)");
			
			//hosp_code numeric, store_id numeric, reqtype numeric, itemcat numeric
			
			funcIndex = dao.setFunction("{? = call MMS_MST.generate_issueno_new(?::numeric,?::numeric,?::numeric,?::numeric)}");
			
			System.out.println("_DossierDeskTransVO.getStrRequestTypeId()-----------------"+_DossierDeskTransVO.getStrRequestTypeId());
			System.out.println("_DossierDeskTransVO.getStrItemCategNo()-------------------"+_DossierDeskTransVO.getStrItemCategNo());
			
			// Set Value
			dao.setFuncInValue(funcIndex, 2,_DossierDeskTransVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3,_DossierDeskTransVO.getStrStoreId());
			dao.setFuncInValue(funcIndex, 4,_DossierDeskTransVO.getStrRequestTypeId());
			dao.setFuncInValue(funcIndex, 5,_DossierDeskTransVO.getStrItemCategNo());
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			strReturnNo = dao.getFuncString(funcIndex);
			_DossierDeskTransVO.setStrReturnNo(strReturnNo);
			//proc_name1 = "";
			
			System.out.println("strReturnNo----------------"+strReturnNo);
			System.out.println("Issue No-------------------"+_DossierDeskTransVO.getStrIssueNo());
			System.out.println("CrNo()---------------------"+_DossierDeskTransVO.getStrCrNo());
			
			System.out.println("----------------pkg_dossier_dml.dml_dossier_req_return_dtl [ Mode - 1 ]-- INSERT INTO hgdt_dossier_return_dtl ----------------");
			
			proc_name1 = "{call pkg_dossier_dml.dml_dossier_req_return_dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?)}";  

			procIndex1 = dao.setProcedure(proc_name1);

			/* Setting Default Value Start */
			dao.setProcInValue(procIndex1, "modval", 				"1", 1);
			dao.setProcInValue(procIndex1, "store_id",				_DossierDeskTransVO.getStrStoreId(), 2);
			dao.setProcInValue(procIndex1, "return_no", 			strReturnNo, 3);
			dao.setProcInValue(procIndex1, "hosp_code",				_DossierDeskTransVO.getStrHospitalCode(), 4);
			dao.setProcInValue(procIndex1, "issue_no",				_DossierDeskTransVO.getStrIssueNo(), 5);
			dao.setProcInValue(procIndex1, "return_date", 			_DossierDeskTransVO.getStrPatientType(), 6);  // this para is use form patient type
			dao.setProcInValue(procIndex1, "reqtype_id",			_DossierDeskTransVO.getStrRequestTypeId(), 7);
			dao.setProcInValue(procIndex1, "pukno",					_DossierDeskTransVO.getStrCrNo(), 8);
			dao.setProcInValue(procIndex1, "adm_no",				_DossierDeskTransVO.getStrAdmissionNo(), 9);
			dao.setProcInValue(procIndex1, "issue_date",			_DossierDeskTransVO.getStrIssueDate(), 10);
			dao.setProcInValue(procIndex1, "emp_no",				_DossierDeskTransVO.getStrEmpNo(), 11);
			dao.setProcInValue(procIndex1, "item_cat_no",			_DossierDeskTransVO.getStrItemCategNo(), 12);
			dao.setProcInValue(procIndex1, "return_netcost",		_DossierDeskTransVO.getStrFinalCost(), 13);
			dao.setProcInValue(procIndex1, "financial_start_date",	_DossierDeskTransVO.getStrFinStartDate(), 14);
			dao.setProcInValue(procIndex1, "financial_end_date",	_DossierDeskTransVO.getStrFinEndDate(), 15);
			dao.setProcInValue(procIndex1, "recommended_by",		_DossierDeskTransVO.getStrRecommendBy(), 16);
			dao.setProcInValue(procIndex1, "recommended_date", 		_DossierDeskTransVO.getStrDossierId(), 17);  // dossier id
			dao.setProcInValue(procIndex1, "remarks",				_DossierDeskTransVO.getStrRemarks(), 18);
			dao.setProcInValue(procIndex1, "entry_date", 			_DossierDeskTransVO.getStrServicetype(), 19); // service Type OT , Service Area
			dao.setProcInValue(procIndex1, "seatid",				_DossierDeskTransVO.getStrSeatId(), 20);
			dao.setProcInValue(procIndex1, "isvalid", 				"1", 21);
			dao.setProcInValue(procIndex1, "deptcode", 				_DossierDeskTransVO.getStrDeptCode(), 22);
			//dao.setProcInValue(procIndex1, "settlementFlag", _DossierDeskTransVO.getStrSettlementFlag(), 22);
			dao.setProcOutValue(procIndex1, "err", 1, 23);
			dao.execute(procIndex1,1);
			/* Setting Default Value End */

			
			

			temp = _DossierDeskTransVO.getStrItemParamValue()[0].replace('@',
					'#').split("#");
			strIssueUnitId = temp[1];

			length = _DossierDeskTransVO.getStrItemParamValue().length;
			if (length != 0) 
			{
				System.out.println("----------------pkg_dossier_dml.dml_dossier_req_return_item_dtl [ Mode - 1 ]--------A----INSERT INTO hgdt_dossier_return_item_dtl------");
				
				for (int i = 0; i < length; i++) 
				{
					//proc_name1 = "";
									
					proc_name9 = "{call pkg_dossier_dml.dml_dossier_req_return_item_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
					temp = _DossierDeskTransVO.getStrItemParamValue()[i].replace('@', '#').split("#");
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
					float getBalanaceQty = Float.parseFloat(_DossierDeskTransVO.getStrBalanceQty()[i])- Float.parseFloat(_DossierDeskTransVO.getStrReturnQty()[i]);
					
					if(Double.parseDouble(_DossierDeskTransVO.getStrReturnQty()[i]) > 0)
					{
						
						System.out.println("_DossierDeskTransVO.getStrReturnQty()["+i+"]-------------------"+_DossierDeskTransVO.getStrReturnQty()[i]);
						
						nProcIndex9 = dao.setProcedure(proc_name9);
						dao.setProcInValue(nProcIndex9, "modval", 			"1", 1); 
						dao.setProcInValue(nProcIndex9, "store_id",			_DossierDeskTransVO.getStrStoreId(), 2);
						dao.setProcInValue(nProcIndex9, "return_no", 		strReturnNo, 3); 
						dao.setProcInValue(nProcIndex9, "item_id", 			strItemId, 4); 
						dao.setProcInValue(nProcIndex9, "itembrand_id",		strItemBrandId, 5); 
						dao.setProcInValue(nProcIndex9, "batch_sl_no", 		strBatchSlNo,6); 
						dao.setProcInValue(nProcIndex9, "hosp_code",		_DossierDeskTransVO.getStrHospitalCode(), 7); 
						dao.setProcInValue(nProcIndex9, "return_date", 		"", 8);
						dao.setProcInValue(nProcIndex9, "item_sl_no",		strItemSlNo.trim(), 9); 
						dao.setProcInValue(nProcIndex9, "group_id", 		strGroupId, 10); 
						dao.setProcInValue(nProcIndex9, "inhand_qty",		"0", 11);
						dao.setProcInValue(nProcIndex9, "subgroup_id",		strSubGroupId, 12); 
						// dao.setProcInValue(nProcIndex9, "balance_qty", _DossierDeskTransVO.getStrBalanceQty()[i],13);
						dao.setProcInValue(nProcIndex9, "balance_qty",		Float.toString(getBalanaceQty), 13);  // commented by vikrant after discussion
						dao.setProcInValue(nProcIndex9, "inhand_qty_unitid", "", 14);
						dao.setProcInValue(nProcIndex9, "balanceqty_unitid",strIssueUnitId, 15); 
						dao.setProcInValue(nProcIndex9, "return_qty",		_DossierDeskTransVO.getStrReturnQty()[i], 16); 
						dao.setProcInValue(nProcIndex9, "retqty_unitid", 	temp[0], 17); 
						dao.setProcInValue(nProcIndex9, "rate", 			strRate, 18); 
						dao.setProcInValue(nProcIndex9, "rate_unitid",		strRateUnitId, 19); 
						dao.setProcInValue(nProcIndex9, "remarks",			_DossierDeskTransVO.getStrRemarks(), 20); 
						dao.setProcInValue(nProcIndex9, "isvalid", 			"1", 21); 
						dao.setProcInValue(nProcIndex9, "cost",				_DossierDeskTransVO.getItemCost()[i], 22); 
						dao.setProcInValue(nProcIndex9, "stock_status_code",strStockStatus, 23);
						dao.setProcInValue(nProcIndex9, "issueNo",			_DossierDeskTransVO.getStrIssueNo(), 24);
						dao.setProcInValue(nProcIndex9, "strItemCategNo",	strItemBrandId.substring(0, 2), 25);
						dao.setProcInValue(nProcIndex9, "strDescription",	"Dossier Return From Patient having C.R.No. :"+_DossierDeskTransVO.getStrCrNo(), 26);
						dao.setProcInValue(nProcIndex9, "strSeatid",		_DossierDeskTransVO.getStrSeatId(), 27);
						dao.setProcInValue(nProcIndex9, "expiryDate",		strExpiryDate.trim(), 28);
						dao.setProcInValue(nProcIndex9, "strManufactDate",	strManuFactDate, 29);
						dao.setProcInValue(nProcIndex9, "strPoNo",			_DossierDeskTransVO.getStrPoNo(), 30);
						dao.setProcOutValue(nProcIndex9, "err", 1, 31); 
						dao.execute(nProcIndex9,1);
					}
					/* Setting Default Value End */
				}

			}		
			
			/* */ 
			if(_DossierDeskTransVO.getItemParamValue() !=null)
			{
				
			
			    int  length1 = _DossierDeskTransVO.getItemParamValue().length;	
               
			    System.out.println("----------------pkg_dossier_dml.dml_dossier_item_dtl [ Mode - 1 ]---- Extra Item ------B---INSERT INTO hgdt_dossier_req_item_dtl-----");
			    
				for(int k=0;k<length1;k++)
				{
					//proc_name11 = "{call pkg_dossier_dml.dml_dossier_req_return_item_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
					if(_DossierDeskTransVO.getStrQtyText()[k] != null && _DossierDeskTransVO.getStrQtyText()[k].length() > 0 && !_DossierDeskTransVO.getStrQtyText()[k].equals("0"))
					{
						
						System.out.println("_DossierDeskTransVO.getStrQtyText()("+k+")-------"+_DossierDeskTransVO.getStrQtyText()[k]);

						paramVal = _DossierDeskTransVO.getItemParamValue()[k].split("#");						
						userValue = paramVal[2].replace('^', '#').split("#");	
						//System.out.println("userValue---------"+userValue);
						String proc_name3 = "{call pkg_dossier_dml.dml_dossier_item_dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,?)}";
						nProcIndex2 = dao.setProcedure(proc_name3);
						// set value
						
						
						dao.setProcInValue(nProcIndex2, "modval", 			"1",1);                  
						dao.setProcInValue(nProcIndex2, "req_id",  			_DossierDeskTransVO.getStrIssueNo(),2);
						dao.setProcInValue(nProcIndex2, "hosp_code", 		_DossierDeskTransVO.getStrHospitalCode(),3);  
						dao.setProcInValue(nProcIndex2, "dossier_item_id",	"0",4); 
						dao.setProcInValue(nProcIndex2, "item_id", 			userValue[0],5); 						
						dao.setProcInValue(nProcIndex2, "brand_id",			userValue[1],6); 
						dao.setProcInValue(nProcIndex2, "cat_no",			userValue[1].substring(0,2),7); 
						dao.setProcInValue(nProcIndex2, "consumable_flg", 	"0",8);   
						dao.setProcInValue(nProcIndex2, "item_ype_id",		_DossierDeskTransVO.getStrPatientType(),9);  // Used As Patient Type
						dao.setProcInValue(nProcIndex2, "req_qty",			_DossierDeskTransVO.getStrQtyText()[k],10);                 
						dao.setProcInValue(nProcIndex2, "req_avl_aty",  	"0",11);
						dao.setProcInValue(nProcIndex2, "used_qty",   		strReturnNo,12);  // Used as Return No
						dao.setProcInValue(nProcIndex2, "issue_mode",		"1",13); 
						dao.setProcInValue(nProcIndex2, "is_mic_item", 		"0",14); 
						dao.setProcInValue(nProcIndex2, "is_valid",			"1",15); 
						dao.setProcInValue(nProcIndex2, "seat_id", 			_DossierDeskTransVO.getStrSeatId(),16);
						dao.setProcInValue(nProcIndex2, "is_brought_byPat", _DossierDeskTransVO.getIsBroughtByPatient()[k],17);
						dao.setProcInValue(nProcIndex2, "default_rate", 	"0.00",18);
						dao.setProcInValue(nProcIndex2, "extra_item", 		"1",19);
						dao.setProcOutValue(nProcIndex2,"err",				 1,20);
						//dao.executeProcedureByPosition(nProcIndex2);
						dao.execute(nProcIndex2, 1);
					
						
						
						
						
					}	
						
						
					}
					
				}
			String strIssueQty2 = "";
			String strStoreId2 = "";
			String hosp_code2 = "";
			String strConsumableFlag = "1";
			String strRemarks1 = "";
			String stritemcat1="";
			if(_DossierDeskTransVO.getItemParamValue() !=null)
			{
			  length = _DossierDeskTransVO.getItemParamValue().length;	
			if (length != 0) {
				System.out.println("----------------pkg_dossier_dml.Dml_hstt_patemp_issue_item_dtl [ Mode - 1 ]--------- - C -INSERT INTO sstt_patemp_issue_item_dtl-------");
				System.out.println("--UPDATE hgdt_dossier_req_item_dtl  SET hstnum_issue_qty = ahis_gbl_util.num_default (v_addqty), hststr_batch_no =  v_batch_no -------");
				System.out.println("-- UPDATE hstt_lp_req_item_dtl  SET hstnum_issue_qty = -------");
				System.out.println("-- UPDATE sstt_indent_dtl       SET hstnum_indent_status = 50 -------");
				System.out.println("--  pkg_mms_dml.dml_stock_update  [ Mode - 3 ] -------");
				for (int i = 0; i < length; i++) 
				{
					
					
					 proc_name12 = "{call pkg_dossier_dml.Dml_hstt_patemp_issue_item_dtl(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,?, ?,?,?,?,? ,?,?)}";
					/*temp = _DossierDeskTransVO.getItemParamValue()[i]
							.replace('@', '#').split("#");*/
					
					paramVal = _DossierDeskTransVO.getItemParamValue()[i].split("#");						
					temp = paramVal[2].replace('^', '#').split("#");	
					
					strItemBrandId = temp[1];
					strItemId = temp[0];
					strRate = temp[9];
				//	strRateUnitId = temp[6];
					strGroupId = "EXT";
					strSubGroupId = "";
					strBatchSlNo = temp[15];
				//	strExpiryDate = temp[8].trim();
					//strIssueQty = temp[2];
					strIssueQty2 = _DossierDeskTransVO.getStrQtyText()[i];
					strStoreId2 = _DossierDeskTransVO.getStrStoreId();
					hosp_code2 = _DossierDeskTransVO.getStrHospitalCode();
					strItemSlNo = "0";
					strStockStatus = "10";
				//	strManuFactDate = temp[7];
					strConsumableFlag = "1";
					strRemarks1 = _DossierDeskTransVO.getStrRemarks();
					//strItemCost = temp[9];
					strIssueUnitId = "6301" ;//temp[8];
					stritemcat1 = strItemId.substring(0, 2);
								
						
							if(Double.parseDouble(_DossierDeskTransVO.getStrQtyText()[i].split(" ")[0]) > 0.0)
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
										strBillQty=strBillQty + "^"+strIssueQty2;
										else
											strBillQty = strIssueQty2;
									if(strBillBatch != null && strBillBatch != "")
										strBillBatch=strBillBatch + "^"+strBatchSlNo;
										else
											strBillBatch = strBatchSlNo;
									
									System.out.println("----------------------------------");
									
									System.out.println("strBillTariff:::::"+strBillTariff);
									System.out.println("strBillRate:::::"+strBillRate);
									System.out.println("strBillQty:::::"+strBillQty);
									System.out.println("strBillBatch:::::"+strBillBatch);
									System.out.println("----------------------------------");
									
									
									
									procIndex12 = dao.setProcedure(proc_name12);
			
								dao.setProcInValue(procIndex12, "modval", 			"1", 1); // Default
																					// Value.
								dao.setProcInValue(procIndex12, "strItemBrandId",	strItemBrandId, 2); // 1
								dao.setProcInValue(procIndex12, "strItemId", 		strItemId, 3); // 2
								dao.setProcInValue(procIndex12, "strRate", 			strRate, 4); // 3
								dao.setProcInValue(procIndex12, "strRateUnitId",	strRateUnitId, 5); // 4
								dao.setProcInValue(procIndex12, "strGroupId", 		strGroupId, 6); // 5?
								dao.setProcInValue(procIndex12, "strSubGroupId",	strSubGroupId, 7); // 6?
								dao.setProcInValue(procIndex12, "strBatchSlNo",		strBatchSlNo, 8); // 7
								dao.setProcInValue(procIndex12, "strExpiryDate",	strExpiryDate.trim(), 9); // 8
								dao.setProcInValue(procIndex12, "strIssueQty", 		strIssueQty2,10);
								dao.setProcInValue(procIndex12, "strIssueUnitId",	strIssueUnitId, 11); // 10
								dao.setProcInValue(procIndex12, "strStoreId", 		strStoreId2, 12); // 11
								dao.setProcInValue(procIndex12, "strIssueNo", 		_DossierDeskTransVO.getStrIssueNo(), 13); // 12
								dao.setProcInValue(procIndex12, "hosp_code", 		hosp_code2, 14); // 13
								dao.setProcInValue(procIndex12, "strItemSlNo", 		strItemSlNo,15); // 14
								dao.setProcInValue(procIndex12, "strStockStatus",	strStockStatus, 16); // 15
								dao.setProcInValue(procIndex12, "strManuFactDate",	strManuFactDate.trim(), 17); // 16
								dao.setProcInValue(procIndex12, "strConsumableFlag",strConsumableFlag, 18); // 17
								dao.setProcInValue(procIndex12, "strRemarks", 		strRemarks1, 19); // 18
								dao.setProcInValue(procIndex12, "strItemCost", 		"0.00",20); // 19?
								//dao.setProcInValue(procIndex12, "strRequestNo",		_DossierDeskTransVO.getStrLpRequestNo(), 21); // 20?
								dao.setProcInValue(procIndex12, "strRequestNo",		_DossierDeskTransVO.getStrIssueNo(), 21); // 20?
								dao.setProcInValue(procIndex12, "strRasingStoreId",	_DossierDeskTransVO.getStrRaisingStoreId(), 22);
								dao.setProcInValue(procIndex12, "strItemCatNo",		stritemcat1, 23); // 21
								dao.setProcInValue(procIndex12, "strSeatid",		_DossierDeskTransVO.getStrSeatId(), 24);
								dao.setProcInValue(procIndex12, "strDescription",	_DossierDeskTransVO.getStrDescription(), 25);
								dao.setProcInValue(procIndex12, "crno",				_DossierDeskTransVO.getStrCrNo(), 26);
								dao.setProcOutValue(procIndex12, "err", 1, 27); // 22
								dao.execute(procIndex12,1);
		
							}
						
				}
			}
			
			if(mcu.getStrBillingIntegration().equals("1"))
			{
				if(!strBillTariff.equals("") && strBillTariff != null)
				{
					if(_DossierDeskTransVO.getStrPatientType().equals("1")){
					int procIndex22;
					System.out.println("----------------bill_interface.dml_online_billreq_drugs [ Mode - 1 ]----- IF [ mcu.getStrBillingIntegration() = 1 ]-----A--[sblnum_chargetype_id = 2 , sblnum_service_id = 5 ]------");
					System.out.println("gnum_dept_code"+_DossierDeskTransVO.getStrDeptCode());
					System.out.println("strIssueNo=============<>>>>>>>"+_DossierDeskTransVO.getStrIssueNo()+"#2");
					System.out.println("gnum_treatment_cat"+_DossierDeskTransVO.getStrTreatmentCat());
					System.out.println("hrgnum_episode_code"+_DossierDeskTransVO.getStrEpisodeCode());
					System.out.println("hrgnum_puk"+_DossierDeskTransVO.getStrCrNo());
					System.out.println("gnum_seatid"+_DossierDeskTransVO.getStrSeatId());
					System.out.println("hosp_code"+_DossierDeskTransVO.getStrHospitalCode());
					System.out.println("ward_code"+_DossierDeskTransVO.getStrWardCode());
					System.out.println("admno"+_DossierDeskTransVO.getStrAdmissionNo());
					System.out.println("visitno"+_DossierDeskTransVO.getStrVisitNo());
					System.out.println("strBillRate------"+strBillRate);
					System.out.println("------------------------------------");
					
					
					String proc_name22 = "{call bill_interface.dml_online_billreq_drugs(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}";
					procIndex22 = dao.setProcedure(proc_name22);
					dao.setProcInValue(procIndex22, "modval", "1", 1); // 1
					dao.setProcInValue(procIndex22, "gnum_dept_code", _DossierDeskTransVO.getStrDeptCode(), 2);
					
					dao.setProcInValue(procIndex22, "sblnum_chargetype_id", "2", 3);
					dao.setProcInValue(procIndex22, "sblnum_service_id", "5", 4);
					
					
					dao.setProcInValue(procIndex22, "gstr_req_no", _DossierDeskTransVO.getStrIssueNo()+"#2#EXT", 5); 
					dao.setProcInValue(procIndex22, "gnum_treatment_cat", _DossierDeskTransVO.getStrTreatmentCat(),6);
					
					dao.setProcInValue(procIndex22, "hrgnum_episode_code", _DossierDeskTransVO.getStrEpisodeCode(), 7);
					
					dao.setProcInValue(procIndex22, "hrgnum_puk", _DossierDeskTransVO.getStrCrNo(), 8);
					
					dao.setProcInValue(procIndex22, "hblnum_pat_lfaccount_no", "0", 9);
					dao.setProcInValue(procIndex22, "gstr_tariff", strBillTariff, 10);
					dao.setProcInValue(procIndex22, "gstr_tariff_batch", strBillBatch, 11);
					dao.setProcInValue(procIndex22, "gstr_tariff_rates", strBillRate, 12);
					dao.setProcInValue(procIndex22, "gstr_reqqty", strBillQty, 13);
					dao.setProcInValue(procIndex22, "hblstr_patient_name", "", 14);
					dao.setProcInValue(procIndex22, "hblstr_pat_address", "", 15);
					dao.setProcInValue(procIndex22, "hblstr_contact_no", "", 16);
					dao.setProcInValue(procIndex22, "age", "1", 17);
					dao.setProcInValue(procIndex22, "ageunit", "1", 18);
					dao.setProcInValue(procIndex22, "gender", "1", 19);
					dao.setProcInValue(procIndex22, "refdoctor", "1", 20);
					dao.setProcInValue(procIndex22, "refdoccontactno", "1", 21);
					dao.setProcInValue(procIndex22, "gnum_seatid", _DossierDeskTransVO.getStrSeatId(), 22);
					
					dao.setProcInValue(procIndex22, "hosp_code", _DossierDeskTransVO.getStrHospitalCode(), 23);
					
					dao.setProcInValue(procIndex22, "ward_code", _DossierDeskTransVO.getStrWardCode(), 24);
					
					dao.setProcInValue(procIndex22, "admno", _DossierDeskTransVO.getStrAdmissionNo(), 25);
					
					dao.setProcInValue(procIndex22, "visitno", _DossierDeskTransVO.getStrVisitNo(), 26);
					
					dao.setProcOutValue(procIndex22, "err", 1, 27);
					
					dao.execute(procIndex22, 1);
				}
				else
				{
				
					int procIndex22;
					System.out.println("----------------bill_interface.dml_online_billreq_drugs [ Mode - 1 ]----- IF [ mcu.getStrBillingIntegration() = 0 ]-----B--------");
					System.out.println("gnum_dept_code"+_DossierDeskTransVO.getStrDeptCode());
					System.out.println("strIssueNo=============<>>>>>>>"+_DossierDeskTransVO.getStrIssueNo()+"#2");
					System.out.println("gnum_treatment_cat"+_DossierDeskTransVO.getStrTreatmentCat());
					System.out.println("hrgnum_episode_code"+_DossierDeskTransVO.getStrEpisodeCode());
					System.out.println("hrgnum_puk"+_DossierDeskTransVO.getStrCrNo());
					
					String proc_name22 = "{call bill_interface.dml_online_billreq_drugs(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}";
					procIndex22 = dao.setProcedure(proc_name22);
					dao.setProcInValue(procIndex22, "modval", "1", 1); // 1
					dao.setProcInValue(procIndex22, "gnum_dept_code", _DossierDeskTransVO.getStrDeptCode(), 2);					
					
					dao.setProcInValue(procIndex22, "sblnum_chargetype_id", "1", 3);
					dao.setProcInValue(procIndex22, "sblnum_service_id", "5", 4);					
					dao.setProcInValue(procIndex22, "gstr_req_no", _DossierDeskTransVO.getStrIssueNo()+"#2#EXT", 5); 
					dao.setProcInValue(procIndex22, "gnum_treatment_cat", _DossierDeskTransVO.getStrTreatmentCat(),6);					
					dao.setProcInValue(procIndex22, "hrgnum_episode_code", _DossierDeskTransVO.getStrEpisodeCode(), 7);					
					dao.setProcInValue(procIndex22, "hrgnum_puk", _DossierDeskTransVO.getStrCrNo(), 8);					
					dao.setProcInValue(procIndex22, "hblnum_pat_lfaccount_no", "0", 9);
					dao.setProcInValue(procIndex22, "gstr_tariff", strBillTariff, 10);
					dao.setProcInValue(procIndex22, "gstr_tariff_batch", strBillBatch, 11);
					dao.setProcInValue(procIndex22, "gstr_tariff_rates", strBillRate, 12);
					dao.setProcInValue(procIndex22, "gstr_reqqty", strBillQty, 13);
					dao.setProcInValue(procIndex22, "hblstr_patient_name", "", 14);
					dao.setProcInValue(procIndex22, "hblstr_pat_address", "", 15);
					dao.setProcInValue(procIndex22, "hblstr_contact_no", "", 16);
					dao.setProcInValue(procIndex22, "age", "1", 17);
					dao.setProcInValue(procIndex22, "ageunit", "1", 18);
					dao.setProcInValue(procIndex22, "gender", "1", 19);
					dao.setProcInValue(procIndex22, "refdoctor", "1", 20);
					dao.setProcInValue(procIndex22, "refdoccontactno", "1", 21);
					dao.setProcInValue(procIndex22, "gnum_seatid", _DossierDeskTransVO.getStrSeatId(), 22);
					//System.out.println("gnum_seatid"+_DossierDeskTransVO.getStrSeatId());
					dao.setProcInValue(procIndex22, "hosp_code", _DossierDeskTransVO.getStrHospitalCode(), 23);
					//System.out.println("hosp_code"+_DossierDeskTransVO.getStrHospitalCode());
					dao.setProcInValue(procIndex22, "ward_code", "0", 24);
					//System.out.println("ward_code"+_DossierDeskTransVO.getStrWardCode());
					dao.setProcInValue(procIndex22, "admno", "0", 25);
					//System.out.println("admno"+_DossierDeskTransVO.getStrAdmissionNo());
					dao.setProcInValue(procIndex22, "visitno", _DossierDeskTransVO.getStrVisitNo(), 26);
					//System.out.println("visitno"+_DossierDeskTransVO.getStrVisitNo());
					dao.setProcOutValue(procIndex22, "err", 1, 27);
					//System.out.println("strBillRate------"+strBillRate);
					dao.execute(procIndex22, 1);
				
				}
				}
			}
			
			
		}
		
			System.out.println("----------------DossierDeskTransDAO.insertRetData-----END -------------");

			
			synchronized (dao) {
				dao.fire();
			}


		} catch (Exception _err) {
			_err.printStackTrace();
			_DossierDeskTransVO
					.setStrMsgString("LPIssueDeskTransDAO.insertData() --> "
							+ _err.getMessage());
			_DossierDeskTransVO.setStrMsgType("1");
		}
	}

	/**
	 * This function is used to set details in approved By Combo.
	 * 
	 * @param _BreakageItemDtlTransVO
	 */
	public static void getApprovedByCombo(DossierDeskTransVO _DossierDeskTransVO) {

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
					_DossierDeskTransVO.getStrHospitalCode(), 3);
			daoObj.setProcInValue(nProcIndex, "seatId",
					_DossierDeskTransVO.getStrSeatId(), 4);

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
				_DossierDeskTransVO.setApprovedBy(ws);
			}
		} catch (Exception _err) {
			_DossierDeskTransVO
					.setStrMsgString("LPIssueDeskTransDAO.getApprovedByCombo() --> "
							+ _err.getMessage());
			_DossierDeskTransVO.setStrMsgType("1");
		}
	}

	public static void getDeptName(DossierDeskTransVO _DossierDeskTransVO) {

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
					_DossierDeskTransVO.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4,
					_DossierDeskTransVO.getStrRaisingStoreId());
			dao.setFuncOutValue(funcIndex, 1);
			dao.executeFunction(funcIndex);
			strDeptName = dao.getFuncString(funcIndex);
			if (strDeptName != null && !strDeptName.equals("null"))
				_DossierDeskTransVO.setStrDeptName(strDeptName);
			else
				_DossierDeskTransVO.setStrDeptName("-");
		} catch (Exception _err) {
			_err.printStackTrace();
			_DossierDeskTransVO
					.setStrMsgString("LPIssueDeskTransDAO.getDeptName() --> "
							+ _err.getMessage());
			_DossierDeskTransVO.setStrMsgType("1");
		}

	}
	
	/*added by shalini & is used To get the Account info.*/
	public static void getPatientAccountDetails(DossierDeskTransVO vo) {

	
		String strProcName = "{call PKG_MMS_VIEW.proc_hstt_pat_account_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		WebRowSet ws = null;
		HisDAO daoObj = null;
		int funcIndex;
		String BillingValue="";
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
					if (ws != null && ws.size() != 0) 
					{
						ws.next();
						vo.setStrPatAccountNo(ws.getString("acc_no"));
						vo.setStrBalanceAmount(ws.getString("Balance_Amt"));
						ws.beforeFirst();
					}
				vo.setPatAccountDtl(ws);
			}
			
			funcIndex = daoObj.setFunction("{? = call bill_mst.get_pat_accountdetails_limit(?,?,?)}");

			daoObj.setFuncInValue(funcIndex, 2,vo.getStrHospitalCode());
			daoObj.setFuncInValue(funcIndex, 3,"2");
			daoObj.setFuncInValue(funcIndex, 4,vo.getStrCrNo());
			//dao.setFuncInValue(funcIndex, 5,_LPIssueDeskTransVO.getStrItemCategNo());
			daoObj.setFuncOutValue(funcIndex, 1);
			daoObj.executeFunction(funcIndex);
			BillingValue = daoObj.getFuncString(funcIndex); 
			//System.out.println("BillingValue"+BillingValue);
			vo.setStrBillingHiddenValue(BillingValue);
		} catch (Exception _err) {
			vo
					.setStrMsgString("LPIssueDeskTransDAO.getPatientAccountBalance() --> "
							+ _err.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void getPatientDiagDetails(DossierDeskTransVO vo)
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
	public static void getSingleBatchItemDtl(DossierDeskTransVO vo) {

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
	public static void getBrandDetails(DossierDeskTransVO vo) {

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
	
	public static void getIssueDtlsList(DossierDeskTransVO vo) 
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
			
			System.out.println("-----------------DossierDeskTransDAO . getIssueDtlsList()---------------------"); 
			
			dao = new HisDAO("mms","global.DossierDeskTransDAO.getIssueDtlsList(DossierRequisitionVO vo)");			
			procIndex1 = dao.setProcedure(proc_name1);
			// set value
			System.out.println("vo.getStrStoreId()-------"+ vo.getStrStoreId());
			System.out.println("issueNo------------------"+ vo.getStrIssueNo());
			System.out.println("hosp_code----------------"+ vo.getStrHospitalCode());
			
			System.out.println("------------------------------------------------------------------------------"); 
			
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
	public static void getItemCatDtls(DossierDeskTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_dossier_view.proc_item_category_list(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","IssueTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "store_id", "",2);
			daoObj.setProcInValue(nProcIndex, "reqType", "",4);
			
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";
			
			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrItemCatWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("IssueTransDAO.getItemCatDtls() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void cancelDossier(DossierDeskTransVO voObj) {
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_dossier_view.proc_dossier_cancel(?,?,?,?, ?,?,?,? ,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","IssueTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "Dossierid", voObj.getStrDossierId(),3);
			daoObj.setProcInValue(nProcIndex, "remarks", voObj.getStrRemarks(),4);
			daoObj.setProcInValue(nProcIndex, "reqType", voObj.getStrVisitType(),5);
			daoObj.setProcInValue(nProcIndex, "crno", voObj.getStrCrNo(),6);
			daoObj.setProcInValue(nProcIndex, "seatid", voObj.getStrSeatId(),7);
			daoObj.setProcOutValue(nProcIndex, "err", 1,8);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,9);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";
			
			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				//voObj.setStrItemCatWs(ws);
				if(ws.next() && ws!=null)
				{
					voObj.setStrBillingCount(ws.getString(1));
					//System.out.println("Values OF Ws is "+ws.getString(1) );
				}
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("IssueTransDAO.getItemCatDtls() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getIssuedItemDtlForIssueView(DossierDeskTransVO vo) {

		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("dossier", "DossierDeskTransDAO");

			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierIssueViewItemList.0");//LEFT LIST
			nQueryIndex = dao.setQuery(strQuery);
	        
	        dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
	        dao.setQryValue(nQueryIndex, 2, vo.getStrIssueNo());
	        dao.setQryValue(nQueryIndex, 3, vo.getStrHospitalCode());
	        dao.setQryValue(nQueryIndex, 4, vo.getStrIssueNo());
	        
	        web = dao.executeQry(nQueryIndex);
	    
	        vo.setIssuedItemDtlWS(web);
			
			
		} catch (Exception e) {

			e.printStackTrace();
			vo.setStrMsgString("LPIssueDeskTransDAO.getIssuedItemDtlForIssueView() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
	
	public static void getRequestTypeDtlsForView(DossierDeskTransVO vo) {

		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("dossier", "DossierDeskTransDAO");

			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierIssueRequestTypeDtlsForView.0");//LEFT LIST
			nQueryIndex = dao.setQuery(strQuery);
	        
	        dao.setQryValue(nQueryIndex, 1, vo.getStrIssueNo());
	        dao.setQryValue(nQueryIndex, 2, vo.getStrHospitalCode());
	        
	        web = dao.executeQry(nQueryIndex);
	    
	        if(web.next()){
	        	vo.setStrDossierName(web.getString(1));
	        	vo.setStrServiceTypeName(web.getString(2));
	        	vo.setStrStoreName(web.getString(3));
	        	vo.setStrDeptName(web.getString(4).equals("0")?"":web.getString(4));
	        }
			
			
		} catch (Exception e) {

			e.printStackTrace();
			vo.setStrMsgString("LPIssueDeskTransDAO.getRequestTypeDtlsForView() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
	public static void getIssueItemDetailForReturnView(DossierDeskTransVO vo) {

		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("dossier", "DossierDeskTransDAO");

			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierReturnViewItemList.0");//LEFT LIST
			nQueryIndex = dao.setQuery(strQuery);
	        
	        dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
	        dao.setQryValue(nQueryIndex, 2, vo.getStrStoreId());
	        dao.setQryValue(nQueryIndex, 3, vo.getStrIssueNo());
	        dao.setQryValue(nQueryIndex, 4, vo.getStrHospitalCode());
	        
	        web = dao.executeQry(nQueryIndex);
	    
	        vo.setIssuedItemDtlWS(web);
			
			
		} catch (Exception e) {

			e.printStackTrace();
			vo.setStrMsgString("LPIssueDeskTransDAO.getIssueItemDetailForReturnView() --> "
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
