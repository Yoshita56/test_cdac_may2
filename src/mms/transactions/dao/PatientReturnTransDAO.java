package mms.transactions.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
import mms.dao.ReturnFromDtlDAO;
import mms.dao.ReturnFromItemDtlDAO;
import mms.transactions.vo.PatientReturnTransVO;
import mms.transactions.vo.PatientReturnTransVO;

public class PatientReturnTransDAO {

	public static void getStoreList(PatientReturnTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			System.out.println("------------ testDAO .storeName  ------------");
			System.out.println("------------  Pkg_Mms_View.proc_hstt_store_mst  - [ Mode - 12 ] -----------");
			
			daoObj=new HisDAO("Return From","testDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "12",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "seatid", vo.getStrSeatId(),2);
			daoObj.setProcInValue(nProcIndex, "storeid", "0",4);
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0",5);
			daoObj.setProcOutValue(nProcIndex, "err",1,6); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,7);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			
			if (strErr.equals("")) {
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				vo.setStrStoreWs(ws);
				
				System.out.println("DAO: StoreList ::vo.getStoreList(ws) size" + ws.size());

			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("testDAO.storeName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void getItemCatList(PatientReturnTransVO vo) {

		String strProcName = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			System.out.println("------------ testDAO .getItemCategory  ------------");
			System.out.println("------------  Pkg_Mms_View.proc_item_category_list  - [ Mode - 2 ] -----------");
			
			daoObj=new HisDAO("Return From","testDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "reqType", vo.getStrReqTypeId());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setItemCategoryWS(ws);
				System.out.println("DAO: Item Category List ::vo.setStrItemCatWs(ws) size" + ws.size());
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("testDAO.getItemCategory() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}

	}
	
	public static void getRecommendName(PatientReturnTransVO vo)
	{
		String strProcName = "{call PKG_MMS_VIEW.proc_consultant_name(?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			System.out.println("------------ PatientReturnTransDAO .getRecommendName  ------------");
			System.out.println("------------  Pkg_Mms_View.proc_consultant_name  - [ Mode - 2 ] -----------");
			
			daoObj=new HisDAO("Return From","testDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "seatId",    vo.getStrSeatId(),4);
			daoObj.setProcInValue(nProcIndex, "deptunitcode", "0",2);
			daoObj.setProcOutValue(nProcIndex, "err",1,5); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,6);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			if (strErr.equals("")) {
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				vo.setRecommendNameWS(ws);
				System.out.println("DAO: getRecommendName ::vo.setRecommendNameWS(ws) size" + ws.size());
				
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("testDAO.getRecommendName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void getpatientDemographicDetail(PatientReturnTransVO vo) 
	{
	
		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";
		//HisUtil.replaceNullValueWithEmptyString(vo);

		                    
		try {
			dao = new HisDAO("mms", "testDAO");
			
			System.out.println("------------  testDAO . getpatientDemographicDetail  ------------");
			System.out.println("------------  Pkg_Mms_View.PROC_PATEMP_ISSUE_DTL  - [ Mode - 4 ] -----------");

			strProcName = "{call Pkg_Mms_View.PROC_PATEMP_ISSUE_DTL(?,?,?,?,?, ?,?,?,?,?)}";

			nProcIndex = dao.setProcedure(strProcName);
			         
			
			dao.setProcInValue(nProcIndex, "modval", "4");
			dao.setProcInValue(nProcIndex, "storeid", vo.getStrId());
			dao.setProcInValue(nProcIndex, "issueno", vo.getStrIssueNumber());
			dao.setProcInValue(nProcIndex, "hoscode", vo.getStrHospitalCode());			
			
			dao.setProcInValue(nProcIndex, "pukno", vo.getStrCrNo());
			dao.setProcInValue(nProcIndex, "empno", vo.getStrEmpNo());
			dao.setProcInValue(nProcIndex, "itemcat", vo.getStrItemCategoryNo());
			dao.setProcInValue(nProcIndex, "reqtype", vo.getStrReqTypeId());
			
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);
			dao.executeProcedure(nProcIndex);
			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) 
			{
					vo.setWrsData(ws);
			}
			else 
			{
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("testDAO.getIssueDetails() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getItem_ALL_LIST(PatientReturnTransVO vo) {

		String err = "";
		String proc_name1 = "{call Pkg_Mms_View.proc_issue_item_dtls(?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms", "PatientReturnTransDAO");
			
			System.out.println("------------  PatientReturnTransDAO . getItem_ALL_LIST  ------------");
			System.out.println("------------  Pkg_Mms_View.proc_issue_item_dtls  - [ Mode - 4 ] -----------");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", "4",1);
			dao.setProcInValue(procIndex1, "hoscode", vo.getStrHospitalCode(),2);
			dao.setProcInValue(procIndex1, "issueno", vo.getStrCrNo(),3);
			dao.setProcOutValue(procIndex1, "err", 1,4); // 1 for string return value
			dao.setProcOutValue(procIndex1, "resultset", 2,5); // 2 for object

			// execute procedure
			dao.executeProcedureByPosition(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";
			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");
				vo.setItemDetailsWS(ws);
				System.out.println("DAO: getItem_ALL_LIST ::vo.setItemDetailsWS(ws) size" + ws.size());
			} else {

				throw new Exception(err);
			}
		} catch (Exception e) {
            e.printStackTrace();
			vo.setStrMsgString("testDAO.getItem_ALL_LIST() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
	public synchronized static void insert_LIST(PatientReturnTransVO vo)
	{
		HisDAO dao = null;
		
		ReturnFromDtlDAO patEmpDao = null;
		ReturnFromItemDtlDAO patEmpItemDao = null;
		String strFuncName = "";
		int nFuncIndex = 0;
		String strReturnNo = "";
		String strInhand = "";
		String strProcName = "";
		int nProcIndex = 0;
		
		String tariff="",qty="",tariffBatch="";
		
		try 
		{
			dao = new HisDAO("mms", "testDAO");
			
			patEmpDao = new ReturnFromDtlDAO();
			patEmpItemDao = new ReturnFromItemDtlDAO();
			
			
			System.out.println("------------  testDAO . insert_LIST  ------------");
			System.out.println("------------  MMS_MST.Generate_Returnno()  ------------");
			
			strFuncName = "{? = call MMS_MST.Generate_Returnno(?::numeric,?::numeric,?::numeric,?::numeric)}";
			nFuncIndex = dao.setFunction(strFuncName);

			
			dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrReqTypeId());
			dao.setFuncInValue(nFuncIndex, 5, "10");
			dao.setFuncOutValue(nFuncIndex, 1);
			
			dao.executeFunction(nFuncIndex);
			strReturnNo = dao.getFuncString(nFuncIndex);
			vo.setStrReturnNo(strReturnNo);
			
			System.out.println("---Store Id     -----"+vo.getStrStoreId());			
			System.out.println("---Req Type Id  -----"+vo.getStrReqTypeId());	
			System.out.println("---Return No    -----"+strReturnNo);	
			
			
			System.out.println("------------  Pkg_Mms_Dml.dml_patemp_return_dtl  -[ Mode - 1 ]-----------");
			
			
			patEmpDao.setStrStoreId(vo.getStrStoreId());
			patEmpDao.setStrReturnNo(strReturnNo);
			patEmpDao.setStrHospitalCode(vo.getStrHospitalCode());//1
			patEmpDao.setStrIssueNo((vo.getStrIssueNoList()[0].split("#")[0]!=null && !vo.getStrIssueNoList()[0].split("#")[0].equals(""))?vo.getStrIssueNoList()[0].split("#")[0]:"0");//2
			patEmpDao.setStrReturnDate(vo.getStrReturnDate());
			patEmpDao.setStrReqtypeId(vo.getStrReqTypeId());
			patEmpDao.setStrCrNo(vo.getStrCrNo());
			patEmpDao.setStrAdmnNo(vo.getStrAdmnNo());
			patEmpDao.setStrIssueDate(vo.getStrIssueDate());
			patEmpDao.setStrEmpNo(vo.getStrEmpNo());
			patEmpDao.setStrItemCatNo(vo.getStrItemCategoryNo());
			patEmpDao.setStrReturnNetCost(vo.getStrNetCost());
			patEmpDao.setStrFinStartDate(vo.getStrFinStartDate());
			patEmpDao.setStrFinEndDate(vo.getStrFinEndDate());
			patEmpDao.setStrRecommendedBy(vo.getStrRecommendedBy());
			patEmpDao.setStrRecommendDate(vo.getStrRecommendDate());
			patEmpDao.setStrRemarks(vo.getStrRemarks());
			patEmpDao.setStrSeatId(vo.getStrSeatId());
			patEmpDao.setStrIsValid(vo.getStrIsValid());
			patEmpDao.insert(dao);
			
			int nMultiRowLen = vo.getStrReturnQty().length;
			
			System.out.println("---Return Length    ---"+nMultiRowLen);		
		
			for(int i=0;i<nMultiRowLen;i++)
			{
		
				if(vo.getStrReturnQty()[i] != null && vo.getStrReturnQty()[i].length() > 0 && !vo.getStrReturnQty()[i].equals("0"))
				{
									
					System.out.println("------------  MMS_MST.get_stock_dtl()  ---[ Mode - 4 ]---------");
					
					strFuncName = "{? = call MMS_MST.get_stock_dtl(?::numeric,?::numeric,?::numeric,?::numeric,?,?::numeric,?::numeric,?,?::numeric,?::numeric)}";
					nFuncIndex = dao.setFunction(strFuncName);
					
					dao.setFuncInValue(nFuncIndex, 2, "4");
					dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
					dao.setFuncInValue(nFuncIndex, 4, vo.getStrItemId()[i]);
					dao.setFuncInValue(nFuncIndex, 5, vo.getStrItemBrandId()[i]);
					dao.setFuncInValue(nFuncIndex, 6, vo.getStrBatchSlNo()[i]);
					dao.setFuncInValue(nFuncIndex, 7, vo.getStrStockStatusCode());
					dao.setFuncInValue(nFuncIndex, 8, vo.getStrStoreId());
					dao.setFuncInValue(nFuncIndex, 9, "0");
					dao.setFuncInValue(nFuncIndex, 10, vo.getStrReservedFlag());
					dao.setFuncInValue(nFuncIndex, 11, "1");
					dao.setFuncOutValue(nFuncIndex, 1);
					
					dao.executeFunction(nFuncIndex);
					strInhand = dao.getFuncString(nFuncIndex);
					
					System.out.println("------------  Pkg_Mms_Dml.dml_patemp_return_item_dtl  ---[ Mode - 1 ]-----START----");
					
					System.out.println("---Hidden_Val    ---"+i+"--"+vo.getStrIssueNoList()[i]);
					System.out.println("---Return Qty    ---"+i+"--"+vo.getStrReturnQty()[i]);				
					System.out.println("---Issue_NO      ---"+i+"--"+vo.getStrIssueNoList()[i].split("#")[0]);
					System.out.println("---Charge Type Id---"+i+"--"+vo.getStrIssueNoList()[i].split("#")[1]);					
					System.out.println("---Brand Id      ---"+i+"--"+vo.getStrItemBrandId()[i]);	
					System.out.println("---Batch_No      ---"+i+"--"+vo.getStrBatchSlNo()[i]);	
					System.out.println("---Rate          ---"+i+"--"+vo.getStrRate()[i]);
					System.out.println("---Ret Qty       ---"+i+"--"+vo.getStrReturnQty()[i]);
							
					String[] temp = strInhand.replace("^", "#").split("#");
					
					
					System.out.println("------------ Pkg_Mms_Dml.dml_online_billreq_refund_inv -----START----");
					
					String strProcName3 = "{call Pkg_Mms_Dml.dml_online_billreq_refund_inv(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?)}";  // 14
					int nProcIndex3 = dao.setProcedure(strProcName3);
					dao.setProcInValue(nProcIndex3, "modval", 				"1",1);
					dao.setProcInValue(nProcIndex3, "sblnum_chargetype_id", vo.getStrIssueNoList()[i].split("#")[1],2);
					dao.setProcInValue(nProcIndex3, "sblnum_service_id", 	"5",3);
					dao.setProcInValue(nProcIndex3, "gstr_req_no", 			vo.getStrIssueNoList()[i].split("#")[0],4);
					dao.setProcInValue(nProcIndex3, "gnum_treatment_cat", 	"11",5);
					dao.setProcInValue(nProcIndex3, "hrgnum_puk", 			vo.getStrCrNo(),6);
					dao.setProcInValue(nProcIndex3, "gstr_tariff", 			vo.getStrItemBrandId()[i],7);
					dao.setProcInValue(nProcIndex3, "gstr_reqqty", 			vo.getStrReturnQty()[i],8);
					dao.setProcInValue(nProcIndex3, "gnum_seatid", 			vo.getStrSeatId(),9);
					dao.setProcInValue(nProcIndex3, "hosp_code", 			vo.getStrHospitalCode(),10);
					dao.setProcInValue(nProcIndex3, "admno", 				"0",11);
					dao.setProcInValue(nProcIndex3, "remarks", 				vo.getStrCrNo()+"@"+vo.getStrIssueNoList()[i]+"@"+tariff+"@"+qty+"@"+tariffBatch,12);
					dao.setProcInValue(nProcIndex3, "batchstr", 			vo.getStrBatchSlNo()[i],13);
					dao.setProcOutValue(nProcIndex3, "err", 				1,14);
					dao.execute(nProcIndex3, 1);			
					System.out.println("------------ Pkg_Mms_Dml.dml_online_billreq_refund_inv -----END----");
					
					strProcName = "{call Pkg_Mms_Dml.dml_patemp_return_item_dtl(?,?,?,?,?  ,?,?,?,?,?,  ?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?)}";
					nProcIndex  = dao.setProcedure(strProcName);
					
					dao.setProcInValue(nProcIndex, "modval", 			"1",1);
					dao.setProcInValue(nProcIndex, "store_id", 			vo.getStrStoreId(),2);
					dao.setProcInValue(nProcIndex, "return_no", 		strReturnNo,3);
					dao.setProcInValue(nProcIndex, "item_id", 			vo.getStrItemId()[i],4);//1
					dao.setProcInValue(nProcIndex, "itembrand_id", 		vo.getStrItemBrandId()[i],5);//2
					dao.setProcInValue(nProcIndex, "batch_sl_no", 		vo.getStrBatchSlNo()[i],6);
					dao.setProcInValue(nProcIndex, "hosp_code", 		vo.getStrHospitalCode(),7);
					dao.setProcInValue(nProcIndex, "return_date", 		vo.getStrReturnDate(),8);
					dao.setProcInValue(nProcIndex, "item_sl_no", 		vo.getStrItemSlNo()[i],9);
					dao.setProcInValue(nProcIndex, "group_id", 			vo.getStrGroupId()[i],10);
					dao.setProcInValue(nProcIndex, "inhand_qty", 		temp[0],11);
					dao.setProcInValue(nProcIndex, "subgroup_id",		vo.getStrSubGroupId()[i],12);					
					dao.setProcInValue(nProcIndex, "balance_qty", 		vo.getStrBalanceQty()[i],13);
					dao.setProcInValue(nProcIndex, "inhand_qty_unitid", temp[1],14);
					dao.setProcInValue(nProcIndex, "balanceqty_unitid", vo.getStrBalanceQtyUnitId()[i],15);
					dao.setProcInValue(nProcIndex, "return_qty", 		vo.getStrReturnQty()[i],16);
					dao.setProcInValue(nProcIndex, "retqty_unitid", 	vo.getStrReturnQtyUnitId()[i],17);
					dao.setProcInValue(nProcIndex, "rate", 				vo.getStrRate()[i],18);
					dao.setProcInValue(nProcIndex, "rate_unitid", 		vo.getStrRateQtyUnitId()[i],19);
					dao.setProcInValue(nProcIndex, "remarks", 			vo.getStrRemarks(),20);
					dao.setProcInValue(nProcIndex, "isvalid", 			vo.getStrIsValid(),21);
					dao.setProcInValue(nProcIndex, "cost", 				vo.getStrTotalCost()[i],22);
					dao.setProcInValue(nProcIndex, "stock_status_code", vo.getStrStockStatusCode(),23);					
					dao.setProcInValue(nProcIndex, "issueNo", 		   (vo.getStrIssueNoList()[i].split("#")[0]!=null && !vo.getStrIssueNoList()[i].split("#")[0].equals(""))?vo.getStrIssueNoList()[i].split("#")[0]:"0",24);
					dao.setProcInValue(nProcIndex, "strItemCategNo", 	"",25);
					dao.setProcInValue(nProcIndex, "strDescription", 	"",26);
					dao.setProcInValue(nProcIndex, "strSeatid", 		"",27);
					dao.setProcInValue(nProcIndex, "expiryDate",		vo.getStrExpiry()[i],28);
					dao.setProcInValue(nProcIndex, "strManufactDate", 	"",29);
					dao.setProcInValue(nProcIndex, "strPoNo", 			vo.getStrCrNo(),30);					
					dao.setProcOutValue(nProcIndex, "err", 				1,31);
					
					dao.execute(nProcIndex, 1);
					
					
					System.out.println("------------  Pkg_Mms_Dml.dml_patemp_return_item_dtl  ---[ Mode - 1 ]-----END----");
														
					System.out.println("------------ Pkg_Mms_Dml.Dml_Stock_Update  ---[ Mode - 10 ]---------");
					
					String	strProcName2 = "{call Pkg_Mms_Dml.Dml_Stock_Update(?,?,?,?,?,  ?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?   ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?,?  ,?,?,?,?)}";
					
					int nProcIndex2 = dao.setProcedure(strProcName2);
					
					dao.setProcInValue(nProcIndex2, "modval",         		"10",1);				
					dao.setProcInValue(nProcIndex2, "old_strid",       		vo.getStrStoreId(),34);
					dao.setProcInValue(nProcIndex2, "old_itemid", 	   		vo.getStrItemId()[i],32);
					dao.setProcInValue(nProcIndex2, "old_itembrandid", 		vo.getStrItemBrandId()[i],33);
					dao.setProcInValue(nProcIndex2, "old_batchno", 			vo.getStrBatchSlNo()[i],30);
					dao.setProcInValue(nProcIndex2, "old_stockstatuscode",	vo.getStrStockStatusCode(),29);
					dao.setProcInValue(nProcIndex2, "reqtypeid",			vo.getStrReqTypeId(),43);
					dao.setProcInValue(nProcIndex2, "old_itemserialno",		vo.getStrItemSlNo()[i],31);
					dao.setProcInValue(nProcIndex2, "transNo", 				strReturnNo,40);
					dao.setProcInValue(nProcIndex2, "transDate", 			vo.getStrReturnDate(),41);
					if(vo.getStrReqTypeId().equals("41"))
					{
						dao.setProcInValue(nProcIndex2, "description", "Return From Patient CR No ["+vo.getStrCrNo()+"] For Issue No ["+vo.getStrIssueNoList()[i].split("#")[0]+"]  Batch :: "+ vo.getStrBatchSlNo()[i]+"- For Brand -"+vo.getStrItemBrandId()[i]+" --and Return Qty is::"+vo.getStrReturnQty()[i] ,42);
					}
					else
					{
						dao.setProcInValue(nProcIndex2, "description", "Return From Staff, CR No. :: "+vo.getStrCrNo() + ", Emp No. :: " + vo.getStrEmpNo(),42);
					}
					//System.out.println("Brand Catg ----"+vo.getStrItemBrandId()[i].substring(0,2));
					
					dao.setProcInValue(nProcIndex2, "strid", 			vo.getStrStoreId(),2);
					dao.setProcInValue(nProcIndex2, "tostrid", 			vo.getStrOrgIssueStoreList()[i],38);  // Pass Orignal Issuing Store Id
					dao.setProcInValue(nProcIndex2, "itemid", 			vo.getStrItemId()[i],3);
					dao.setProcInValue(nProcIndex2, "itembrandid", 		vo.getStrItemBrandId()[i],4);
					dao.setProcInValue(nProcIndex2, "hosp_code",		vo.getStrHospitalCode(),27);				
					dao.setProcInValue(nProcIndex2, "itemcatno",		vo.getStrItemBrandId()[i].substring(0,2),6);
					dao.setProcInValue(nProcIndex2, "inhandqty", 		vo.getStrReturnQty()[i],13);
					dao.setProcInValue(nProcIndex2, "inhandqtyunitid", 	vo.getStrReturnQtyUnitId()[i],14);
					dao.setProcInValue(nProcIndex2, "reservedFlag", 	vo.getStrReservedFlag(),39);
					dao.setProcInValue(nProcIndex2, "seatid", 			vo.getStrSeatId(),22);				
					dao.setProcInValue(nProcIndex2, "batchno", 			"0",5);
					dao.setProcInValue(nProcIndex2, "groupid", 			"",7);
					dao.setProcInValue(nProcIndex2, "subgroupid", 		"0",8);
					dao.setProcInValue(nProcIndex2, "expirydate", 		"",9);
					dao.setProcInValue(nProcIndex2, "manufdate",		"",10);
					dao.setProcInValue(nProcIndex2, "stockstatuscode",	"1",11);
					dao.setProcInValue(nProcIndex2, "inventoryflag",	vo.getStrIssueNoList()[i].split("#")[0],12);  // Pass Issue No Here
					dao.setProcInValue(nProcIndex2, "suppid",			"",15);
					dao.setProcInValue(nProcIndex2, "rate", 			"0",16);
					dao.setProcInValue(nProcIndex2, "rateunitid",		"",17);
					dao.setProcInValue(nProcIndex2, "saleprice", 		"0",18);
					dao.setProcInValue(nProcIndex2, "salepriceunitid", 	"",19);
					
					dao.setProcInValue(nProcIndex2, "pono", 			"",20);
					dao.setProcInValue(nProcIndex2, "podate",			"",21);
					dao.setProcInValue(nProcIndex2, "suppliedby",		"",23);
					dao.setProcInValue(nProcIndex2, "recieveddate", 	"",24);
					dao.setProcInValue(nProcIndex2, "currencycode", 	"",25);
					dao.setProcInValue(nProcIndex2, "freeitemflag",		"0",26);
					dao.setProcInValue(nProcIndex2, "currencyvalue", 	"0",28);
					dao.setProcInValue(nProcIndex2, "itemparamflag", 	"0",35);
					
					dao.setProcInValue(nProcIndex2, "partflag", 		"0",36);
					dao.setProcInValue(nProcIndex2, "warrentyflag",		"0",37);
					dao.setProcInValue(nProcIndex2, "blockqtyflag",		"0",44);
					dao.setProcInValue(nProcIndex2, "blockedqty", 		"0",45);
					dao.setProcInValue(nProcIndex2, "blockedqtyunitid", "0",46);
					dao.setProcInValue(nProcIndex2, "releaseqty",		"0",47);
					dao.setProcInValue(nProcIndex2, "releaseqtyunitid", "0",48);
					dao.setProcInValue(nProcIndex2, "invoiceNo", 		"",49);				
					dao.setProcInValue(nProcIndex2, "invoiceDate",		"",50);
					dao.setProcInValue(nProcIndex2, "item_serialNoFlag",	"1",51);
					dao.setProcInValue(nProcIndex2, "item_specification",	"",52);				
					dao.setProcOutValue(nProcIndex2, "err", 				 1,54);
					dao.setProcOutValue(nProcIndex2, "retSerialNo", 		 1,53);
					
					dao.execute(nProcIndex2, 1);
					
					
					
			 }
		  }	
			
			System.out.println("------------ Pkg_Mms_Dml.Dml_Stock_Update  ---[ Mode - 10 ]-----END----");
			dao.fire();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("testDAO.insert() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
 
	public static void issueDtlsInitNEW_Voucher(PatientReturnTransVO vo) 
	{
		String err;
		//String strSlNoflg;
		HisDAO        dao = null;
		WebRowSet      ws = null;
		int    procIndex1 = 0;
		String proc_name1 = "{call pkg_mms_view.Proc_Emp_Issue_Detail(?,?,?,?,?,?)}"; //6
		try 
		{
			System.out.println(" ------- IssueTransODAO .getIssueDtlsList  -------- ");
			System.out.println(" ------- pkg_mms_view.Proc_Emp_Issue_Detail  --[ Mode- 5 ]------ ");
			
			/*
			  Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line Issue Voucher)
			  1.Hospital Name ^ DDC Name ^ Prescribe For ^ Issue No ^ Issued By Doctor ^ Date ^ Cr No ^ Hindi Text  
			  2.Drug Name
			  3.Batch No 
			  4.Exp Date
			  5.Issue Qty
			 */				
			dao = new HisDAO("mms","global.IssueTransODAO.getStockItemDtlsList(IssueTransOVO vo)");			
			procIndex1 = dao.setProcedure(proc_name1);
			// set value
			dao.setProcInValue(procIndex1, "modeval", 		"5",1);
			dao.setProcInValue(procIndex1, "strId", 		vo.getStrFromStoreId(),3);			
//			dao.setProcInValue(procIndex1, "issueNo", 		vo.getStrReturnNo().split("\\^")[0],2);
			dao.setProcInValue(procIndex1, "issueNo", 		vo.getStrReturnNo(),2);
			dao.setProcInValue(procIndex1, "hosp_code", 	vo.getStrHospitalCode(),4);
			dao.setProcOutValue(procIndex1,"ERR", 			1,5); // 1 for string return
			dao.setProcOutValue(procIndex1, "RESULTSET", 	2,6); // 2 for object
			// execute procedure
			dao.executeProcedureByPosition(procIndex1);
			// get value
			err = dao.getString(procIndex1, "ERR");
			if (err == null)
				err = "";
			ws = dao.getWebRowSet(procIndex1, "RESULTSET");
			vo.setWsIssueDetails(ws);
			System.out.println("ws SIZE"+ws.size());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
            //e.printStackTrace();
			vo.setStrMsgString("IssueTransODAO.getIssueDtlsList() --> "+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}

	
	 public static void GetData(PatientReturnTransVO vo) 
		{
			/* Declaring Variable */
			HisDAO dao = null;
			WebRowSet wb = null;
			String str1 = null;
			HisUtil hisutil = null;
	    	try 
			{
				
	    		hisutil = new HisUtil("MMS", "OfflineIssueIndentDAO");
				wb      = STORENAMECOMBO(vo);
				if(wb.next())
				{
					vo.setStrStoreId(wb.getString(1));
				}
				wb.beforeFirst();
				if(wb!= null)
				{	
				   str1 = hisutil.getOptionValue(wb, vo.getStrStoreId(),"0^Select Value", true);
				   vo.setStrStoreName(str1);
				  
				}
				 else
	            {
	               str1 = "<option value='0'>DATA N/A</option>";   
	               vo.setStrStoreName(str1);
	            }
				
			
			} 
	    	catch (Exception e) 
	    	{
				
	    		vo.setStrMsgString("--> OfflineIssueIndentDAO.GetData()-->"
						+ e.getMessage());
				vo.setStrMsgType("1");
			} finally {
				if (dao != null)
					dao.free();
				dao = null;
			}

		}
	 
	 public static WebRowSet STORENAMECOMBO(PatientReturnTransVO vo)
		{
			String proc_name = "";

			proc_name = "{call PKG_MMS_VIEW.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
			
			HisDAO dao = null;
				
			int nprocIndex = 0;

			String strerr = "";

			WebRowSet ws = null;

			try {

				dao = new HisDAO("MMS",
						"transactions.testDAO.STORENAMECOMBO(VO)");

				nprocIndex = dao.setProcedure(proc_name);
				// set value
				dao.setProcInValue(nprocIndex, "modeval", "12",1);
				dao.setProcInValue(nprocIndex, "seatid", vo.getStrSeatId(),2);
				dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),3);
				dao.setProcInValue(nprocIndex, "storeid", "0",4);
				dao.setProcInValue(nprocIndex, "storetype_id", "0",5);
				dao.setProcOutValue(nprocIndex,"err", 1,6); // 1 for string return
				dao.setProcOutValue(nprocIndex,"resultset", 2,7); // 2 for object
				// execute procedure
				dao.executeProcedureByPosition(nprocIndex);

				// get value

				strerr = dao.getString(nprocIndex, "err");

				if (strerr == null)
					strerr = "";

				if (strerr.equals(""))
				{
					ws = dao.getWebRowSet(nprocIndex, "resultset");
					System.out.println("WS SIZE"+ws.size());
					vo.setStrMsgType("0");
				} else {
					throw new Exception(strerr);
				}
			}
			catch (Exception e)
			{		
	            e.printStackTrace();
				vo.setStrMsgString("-->OfflineIssueIndentDAO.STORENAMECOMBO()"+ e.getMessage());
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
	 
	 
	 public static void getReturnDetail(PatientReturnTransVO vo) 
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
				       dao = new HisDAO("MMS",	"PatientReturnTransDAO.getIssueDetail(PatientReturnTransVO vo)");
				procIndex1 = dao.setProcedure(proc_name1);

				// set value
				dao.setProcInValue(procIndex1, "modeval", 	"2",1);                  //1
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

				if (err.equals("")) {

					ws = dao.getWebRowSet(procIndex1, "resultset");
					vo.setReturnNoDtlWs(ws);
					System.out.println("vo.setReturnNoDtlWs WS SIZE"+ws.size());
				} else {
					throw new Exception(err);
				}

			} catch (Exception e) {
	            e.printStackTrace();
				vo.setStrMsgString("PatientReturnTransDAO.getIssueDetail() --> "
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