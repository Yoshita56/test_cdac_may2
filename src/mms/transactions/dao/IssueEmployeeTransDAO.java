package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.DmlHsttPatEmpIssueDtlDAO;
import mms.dao.DmlHsttPatEmpIssueItemDtlDAO;
import mms.transactions.vo.IssueEmployeeTransVO;

public class IssueEmployeeTransDAO {
	
	public static void getStoreList(IssueEmployeeTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","IssueEmployeeTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			
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

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrStoreWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("IssueEmployeeTransDAO.getStoreList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	public static void getEmployeeDtl(IssueEmployeeTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_pat_emp_dtl(?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","IssueEmployeeTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "empno", voObj.getStrEmployeeNo(),1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),2);
			daoObj.setProcOutValue(nProcIndex, "err", 1,3);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,4);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				
							
				if(ws.size()==0){
					voObj.setStrChkEmpExist("0");
				}else{
					voObj.setStrChkEmpExist("1");
					voObj.setStrEmployeeWs(ws);
					
				}
		
			
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("IssueEmployeeTransDAO.getEmployeeDtl() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	
	public static void getItemCatDtls(IssueEmployeeTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","IssueEmployeeTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "store_id", voObj.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "reqType", voObj.getStrReqTypeId(),4);
			
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrItemCatWs(ws);
				//System.out.println("size"+voObj.getStrItemCatWs().size());
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("IssueEmployeeTransDAO.getItemCatDtls() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	
	
	public static void getPrescribedBy(IssueEmployeeTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Consultant_Name(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","IssueEmployeeTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId(),4);
			daoObj.setProcInValue(nProcIndex, "deptunitcode", "0",2); //Default value.
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrConsultantWs(ws);
				////System.out.println("ws size----->"+ws.size());
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("IssueEmployeeTransDAO.getPrescribedBy() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getStoreGroupList(IssueEmployeeTransVO vo) {
		

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

				dao = new HisDAO("MMS Transactions", "IssueEmployeeTransDAO");
		
				procIndex1 = dao.setProcedure(proc_name1);
				dao.setProcInValue(procIndex1, "modeval", "2",1);
				// set value
				dao.setProcInValue(procIndex1, "item_category", vo.getStrItemCat(),2);
				dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),3);
				/* Setting Default Value Start*/
				dao.setProcInValue(procIndex1, "strPhyStockNo", "",4);
				dao.setProcInValue(procIndex1, "strStoreId", "",5);

				/* Setting Default Value End */
				dao.setProcOutValue(procIndex1, "err", 1,6); // 1 for string return
				// value
				dao.setProcOutValue(procIndex1, "resultset", 2,7); // 2 for object
		
				// execute procedure
		
				dao.executeProcedureByPosition(procIndex1);
		
				// get value
				err = dao.getString(procIndex1, "err");
		
				if (err == null)
					err = "";
		
				ws = dao.getWebRowSet(procIndex1, "resultset");
		
				vo.setStrGroupWs(ws);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IssueEmployeeTransDAO.getStoreGroupList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	
	public static void getIssueDetail(IssueEmployeeTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.Proc_Issue_Details(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","IssueEmployeeTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			
			daoObj.setProcInValue(nProcIndex, "modval", "2",1);
			daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "empNo", voObj.getStrEmployeeNo(),4);
			daoObj.setProcInValue(nProcIndex, "catCode", voObj.getStrCatCode(),5);
			daoObj.setProcInValue(nProcIndex, "days", voObj.getStrEmployeeDays(),6);
			daoObj.setProcInValue(nProcIndex, "crNo", "",7);// default value
			daoObj.setProcOutValue(nProcIndex, "err", 1,8);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,9);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrIssueDetailWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("IssueEmployeeTransDAO.getIssueDetail() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void insert(IssueEmployeeTransVO vo) {
		
		HisDAO dao = null;
		String strFuncName = "";
		int nFuncIndex = 0;
		
		int length = 0;
	
		String paramVal[] = null;
		String userValue[] = null;
		String strIssueNo = "";
		
		Double netCost = 0.00;
		
		DmlHsttPatEmpIssueItemDtlDAO dmlhsttpatempissueitemdtl = null;
		DmlHsttPatEmpIssueDtlDAO dmlhsttpatempissuedtl = null;

		try {
			dao = new HisDAO("MMS Transactions","IssueTransDAO");
			dmlhsttpatempissueitemdtl = new DmlHsttPatEmpIssueItemDtlDAO();
			dmlhsttpatempissuedtl = new DmlHsttPatEmpIssueDtlDAO();
			
			strFuncName = "{? = call MMS_MST.generate_issueNo(?::numeric,?::numeric,?::numeric,?::numeric)}";
			nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrReqTypeId());
			dao.setFuncInValue(nFuncIndex, 5, vo.getStrItemCat());
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strIssueNo = dao.getFuncString(nFuncIndex);
			vo.setStrIssueNumber(strIssueNo);
	
			////System.out.println("inissue mode 1");
			
			length = vo.getItemParamValue().length;	
			
			////System.out.println("item param value------>"+vo.getItemParamValue());
			
				for(int k=0;k<length;k++){
				
				/**
				 * Hidden Values corresponding to particular
				 * ITEM DETAILS
				 */	
						
					paramVal  = vo.getItemParamValue()[k].split("#");
				
					userValue = paramVal[2].replace('^', '#').split("#");
									
					netCost+=Double.parseDouble(userValue[29]);
					
					String strtemp[] = vo.getStrUnitName()[k].replace("^", "#").split("#");
				
					////System.out.println("Last Rate Unit Id-11->>"+userValue[10]);	
						/*
						////System.out.println("Display Value-->>>>"+temp[0]);
						////System.out.println("Conversion  Value-->>>>"+temp[1]);
						////System.out.println("User  Value-->>>>"+temp[2]);
					    */
				
						/*			
						////System.out.println("ItemID-1->>"+strTemp[0]);
						////System.out.println("ItemBrandID-2->>"+strTemp[1]);
						////System.out.println("GrpID-3->>"+strTemp[2]);
						////System.out.println("Sub_GrpID-4->>"+strTemp[3]);
						////System.out.println("Cosumble Flg-5->>"+strTemp[4]);
						////System.out.println("Re-Order Qty-6->>"+strTemp[5]);
						////System.out.println("Re-Order Qty unit Id-7->>"+strTemp[6]);
						////System.out.println("In Hand Qty-8->>"+strTemp[7]);
						////System.out.println("In Hand Qty Unit Id-9->>"+strTemp[8]);
						////System.out.println("Last Rate-10->>"+strTemp[9]);
						
						
						
						////System.out.println("Inventory Unit Id-12->>"+strTemp[11]);
						////System.out.println("Last PO No-13->>"+strTemp[12]);
						////System.out.println("Last PO Date-14->>"+strTemp[13]);
						////System.out.println("Last Supplied By [Id]-15->>"+strTemp[14]);
						////System.out.println("Batch No-16->>"+strTemp[15]);
						////System.out.println("Expiry Date-17->>"+strTemp[16]);
						////System.out.println("Manufacture Date-18->>"+strTemp[17]);
						////System.out.println("Item Serial No-19->>"+strTemp[18]);
						////System.out.println("Last Received Qty [PO]-20->>"+strTemp[19]);
						////System.out.println("Last Received Qty Unit Id [PO]-21->>"+strTemp[20]);
						
						////System.out.println("Last Indented Qty-22->>"+strTemp[21]);
						////System.out.println("Last Indented Qty Unit Id-23->>"+strTemp[22]);
						////System.out.println("Last Received Qty-24->>"+strTemp[23]);
						////System.out.println("Last Received Qty Unit Id-25->>"+strTemp[24]);
						////System.out.println("Last Year Consumption Qty-26->>"+strTemp[25]);
						////System.out.println("Last Year Consumption Qty Unit Id-27->>"+strTemp[26]);
						////System.out.println("Prefix-28->>"+strTemp[27]);
						////System.out.println("Cost Parameter-29->>"+strTemp[28]);
						////System.out.println("Cost Unit [on individual item or on total cost]-30->>"+strTemp[29]);
						////System.out.println("Purchase Lead Time-31->>"+strTemp[30]);
						
						////System.out.println("Purchase Lead Time Unit-32->>"+strTemp[31]);
						////System.out.println("Stock Status-33->>"+strTemp[32]);
							
						 ////System.out.println("indent No-in LP DEPT .->>>"+indentNo);
						////System.out.println("Store ID LP DEEPT.....--->>>"+vo.getStrStoreId());
						*/
					
					
					
					dmlhsttpatempissueitemdtl.setStrStoreId(vo.getStrStoreId());
					dmlhsttpatempissueitemdtl.setStrIssueNo(vo.getStrIssueNumber().split("\\^")[0]);
					dmlhsttpatempissueitemdtl.setStrItemId(userValue[0]);
					dmlhsttpatempissueitemdtl.setStrItemBrandId(userValue[1]);
					dmlhsttpatempissueitemdtl.setStrBatchSlNo(userValue[15]);
					dmlhsttpatempissueitemdtl.setStrHospitalCode(vo.getStrHospitalCode());
					dmlhsttpatempissueitemdtl.setStrItemSlNo(userValue[18]);
					dmlhsttpatempissueitemdtl.setStrStockStatusCode(userValue[32]);
					dmlhsttpatempissueitemdtl.setStrGroupId(userValue[2]);
					dmlhsttpatempissueitemdtl.setStrSubGroupId(userValue[3]);
					dmlhsttpatempissueitemdtl.setStrRate(userValue[9]);
					dmlhsttpatempissueitemdtl.setStrRateUnitId(userValue[10]);
					dmlhsttpatempissueitemdtl.setStrBalQty("0");
					dmlhsttpatempissueitemdtl.setStrBalQtyUnitId("");
					dmlhsttpatempissueitemdtl.setStrIssueQty(vo.getStrReqQty()[k]);
					dmlhsttpatempissueitemdtl.setStrIssueQtyUnitId(strtemp[0]);
					dmlhsttpatempissueitemdtl.setStrExpiryDate(userValue[16]);
					dmlhsttpatempissueitemdtl.setStrRemarks(vo.getStrRemarks());
					dmlhsttpatempissueitemdtl.setStrCost(vo.getStrCostFinal()[k]);
					dmlhsttpatempissueitemdtl.setStrInHandQty(userValue[7]);
					dmlhsttpatempissueitemdtl.setStrInHandQtyUnitId(userValue[8]);
					dmlhsttpatempissueitemdtl.setStrManufDate(userValue[17]);
					dmlhsttpatempissueitemdtl.setStrReqNo("");
					dmlhsttpatempissueitemdtl.setStrCrNo("");
					dmlhsttpatempissueitemdtl.setStrReqTypeId(vo.getStrReqTypeId());
					dmlhsttpatempissueitemdtl.setStrEmpNo(vo.getStrEmployeeNo());
					dmlhsttpatempissueitemdtl.setStrItemCatNo(vo.getStrItemCat());
					dmlhsttpatempissueitemdtl.setStrSeatId(vo.getStrSeatId());
					dmlhsttpatempissueitemdtl.insert2(dao);
			
				}			
		
					dmlhsttpatempissuedtl.setStrStoreId(vo.getStrStoreId());
					dmlhsttpatempissuedtl.setStrIssueNo(vo.getStrIssueNumber().split("\\^")[0]);
					dmlhsttpatempissuedtl.setStrHospitalCode(vo.getStrHospitalCode());
					dmlhsttpatempissuedtl.setStrRequestNo("");
					dmlhsttpatempissuedtl.setStrOrderBy(vo.getStrPrescribedBy());
					dmlhsttpatempissuedtl.setStrOrderDate(vo.getStrPrescriptionDate());
					dmlhsttpatempissuedtl.setStrDays("0");
					dmlhsttpatempissuedtl.setStrCrNo("0");
					dmlhsttpatempissuedtl.setStrReqTypeId(vo.getStrReqTypeId());
					dmlhsttpatempissuedtl.setStrAdmNo("0");
					dmlhsttpatempissuedtl.setStrEmpNo(vo.getStrEmployeeNo());
					dmlhsttpatempissuedtl.setStrItemCatNo(vo.getStrItemCat());
					dmlhsttpatempissuedtl.setStrFinalCost(vo.getStrApproxAmt());
					dmlhsttpatempissuedtl.setStrFinStartDate(vo.getStrFinStartDate());
					dmlhsttpatempissuedtl.setStrFinEndDate(vo.getStrFinEndDate());
					//System.out.println("vo.getStrSeatId()"+vo.getStrSeatId());
					
					dmlhsttpatempissuedtl.setStrSeatId(vo.getStrSeatId());
					dmlhsttpatempissuedtl.setStrDeptUnitCode("0");
					dmlhsttpatempissuedtl.setStrVisitType("0");
					dmlhsttpatempissuedtl.setStrDeptCode(vo.getStrDeptId());
					dmlhsttpatempissuedtl.setStrWardCode("0");
					dmlhsttpatempissuedtl.setStrReceiveBy(vo.getStrReceiveBy());
					dmlhsttpatempissuedtl.setStrRemarks(vo.getStrRemarks());
					dmlhsttpatempissuedtl.setStrReqDate(vo.getStrFinEndDate());
					dmlhsttpatempissuedtl.setStrEpisoCode("0");
					dmlhsttpatempissuedtl.setStrVisitNo("0");
					
					dmlhsttpatempissuedtl.insert(dao);
					synchronized(dao)
					{
						dao.fire();
					}
		
					
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgType("1");
			vo.setStrMsgString("IssueTransDAO.insert() --> "
					+ e.getMessage());
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
}


