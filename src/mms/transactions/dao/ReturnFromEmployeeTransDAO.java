/**
 * 
 */
package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.ReturnFromEmployeeDtlDAO;
import mms.dao.ReturnFromEmployeeItemDtlDAO;
import mms.transactions.vo.ReturnFromEmployeeTransVO;

/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Date : 17/June/2009
 * 
 */
public class ReturnFromEmployeeTransDAO {
	
	/**
	 * Get the Store Name in Combo.
	 * @param vo
	 */
	public static void storeName(ReturnFromEmployeeTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Return From","ReturnFromEmployeeTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			//System.out.println("hosp_code"+ vo.getStrHospitalCode());
			//System.out.println("seatid"+vo.getStrSeatId());
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "seatid", vo.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "storeid", "0");
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0");
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setStoreNameWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("ReturnFromEmployeeTransDAO.storeName() --> "
					+ e.getMessage());
			//System.out.println(" e.getMessage()"+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * Get the Recommend Name in Combo.
	 * @param vo
	 */
	public static void getRecommendName(ReturnFromEmployeeTransVO vo)
	{
		String strProcName = "{call PKG_MMS_VIEW.proc_consultant_name(?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Return From","ReturnFromEmployeeTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "seatId",    vo.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "deptunitcode", "0");
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setRecommendNameWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("ReturnFromEmployeeTransDAO.getRecommendName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	/**
	 * Get the Item Category
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getItemCategory(ReturnFromEmployeeTransVO vo) {

		String strProcName = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Return From","ReturnFromEmployeeTransDAO");
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
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("ReturnFromEmployeeTransDAO.getItemCategory() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}

	}
	
	/**
	 * Get the Item Category
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getIssueNoCombo(ReturnFromEmployeeTransVO vo) {

		String strProcName = "{call Pkg_Mms_View.PROC_PATEMP_ISSUE_DTL(?,?,?,?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Return From","ReturnFromEmployeeTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modval", "3");
			daoObj.setProcInValue(nProcIndex, "storeid", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hoscode", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "itemcat", vo.getStrItemCategoryNo());
			daoObj.setProcInValue(nProcIndex, "empno", vo.getStrEmpNo());
			daoObj.setProcInValue(nProcIndex, "reqtype", vo.getStrReqTypeId());
			daoObj.setProcInValue(nProcIndex, "issueno", "");
			daoObj.setProcInValue(nProcIndex, "pukno", "");
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setIssueNoWS(ws);
				
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("ReturnFromEmployeeTransDAO.getIssueNoCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}

	}
	
	/**
	 * To get Issue details on the basis of Issue no. and store id and hospital code
	 * 
	 * @param vo
	 */
	public static void getIssueDetails(ReturnFromEmployeeTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			dao = new HisDAO("mms", "ReturnFromEmployeeTransDAO");

			strProcName = "{call Pkg_Mms_View.PROC_PATEMP_ISSUE_DTL(?,?,?,?,?,?,?,?,?,?)}";

			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modval", "2");
			dao.setProcInValue(nProcIndex, "hoscode", vo.getStrHospitalCode());
			dao.setProcInValue(nProcIndex, "issueno", vo.getStrIssueNo());
			
			dao.setProcInValue(nProcIndex, "storeid", "");
			dao.setProcInValue(nProcIndex, "itemcat", "");
			dao.setProcInValue(nProcIndex, "empno", "");
			dao.setProcInValue(nProcIndex, "reqtype", "");
			dao.setProcInValue(nProcIndex, "pukno", "");
			
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);
			dao.executeProcedure(nProcIndex);
			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				while (ws.next()) {
					vo.setStrIssueDate(ws.getString(1));
					vo.setStrDepartmentUnitName(ws.getString(2));
					vo.setStrConsultantName(ws.getString(3));
				}

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("ReturnFromEmployeeTransDAO.getIssueDetails() --> "
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
	 * To get Item Details on 'Issue' page
	 * 
	 * @param vo
	 */
	public static void getItemDetail(ReturnFromEmployeeTransVO vo) {

		String err = "";
		String proc_name1 = "{call Pkg_Mms_View.proc_issue_item_dtls(?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms", "ReturnFromEmployeeTransDAO");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", "1");
			dao.setProcInValue(procIndex1, "hoscode", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "issueno", vo.getStrIssueNo());
			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return value
			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object

			// execute procedure
			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";
			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");
				vo.setItemDetailsWS(ws);
			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {

			vo.setStrMsgString("ReturnFromEmployeeTransDAO.getItemDetail() --> "
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
	 * This function is used to to populate the value of Unit combo
	 * 
	 * @param vo
	 */
	public static void getReturnUnitCombo(ReturnFromEmployeeTransVO vo) {
		String strProcName = "{call Pkg_Mms_View.proc_GBLT_UNIT_MST(?,?,?,?,?,?)}";
		HisDAO dao = null;
		WebRowSet ws = null;
		int nProcIndex = 0;

		String strErr = "";

		try {
			dao = new HisDAO("mms", "ReturnFromEmployeeTransDAO");

			nProcIndex = dao.setProcedure(strProcName);
			dao.setProcInValue(nProcIndex, "modeval", "1");
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nProcIndex, "unit_id", vo.getStrIssueQtyUnitId());
			dao.setProcInValue(nProcIndex, "module_id", "");
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);

			dao.executeProcedure(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				vo.setReturnQtyUnitWS(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			vo.setStrMsgString("ReturnFromEmployeeTransDAO.getReturnUnitCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
	public static void fetchEmpDtl(ReturnFromEmployeeTransVO vo){
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_pat_emp_dtl(?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","IssueEmployeeTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "empno", vo.getStrEmpNo());
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				if(ws.size()==0){
					vo.setStrChkEmpExist("0");
				}else{
					vo.setStrChkEmpExist("1");
					vo.setEmployeeWs(ws);
				}
					
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			vo.setStrMsgString("IssueEmployeeTransDAO.getEmployeeDtl() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	/**
	 * This function is used to to populate the value of Stock Status combo
	 * 
	 * @param vo
	 */
	public static void getStockStatus(ReturnFromEmployeeTransVO vo) {
		String strProcName = "{call Pkg_Mms_View.proc_stock_status_list(?,?,?,?,?,?)}";
		HisDAO dao = null;
		WebRowSet ws = null;
		int nProcIndex = 0;

		String strErr = "";

		try {
			dao = new HisDAO("mms", "ReturnFromEmployeeTransDAO");

			nProcIndex = dao.setProcedure(strProcName);
			dao.setProcInValue(nProcIndex, "modeval", "1");
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nProcIndex, "itemCat", "");
			dao.setProcInValue(nProcIndex, "itemBrandId", "0");
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);

			dao.executeProcedure(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				vo.setStockStatusWS(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			vo.setStrMsgString("ReturnFromEmployeeTransDAO.getReturnUnitCombo() --> "
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
	 * to insert the data. 
	 * 
	 * @param vo
	 */
	public static void insert(ReturnFromEmployeeTransVO vo)
	{
		HisDAO dao = null;
		
		ReturnFromEmployeeDtlDAO patEmpDtlDao = null;
		ReturnFromEmployeeItemDtlDAO patEmpItemDtlDao = null;
		String strFuncName = "";
		int nFuncIndex = 0;
		String strReturnNo = "";
		String strInhand = "";
		
		try {
			dao = new HisDAO("mms", "ReturnFromEmployeeTransDAO");
			
			patEmpDtlDao = new ReturnFromEmployeeDtlDAO();
			patEmpItemDtlDao = new ReturnFromEmployeeItemDtlDAO();
			
			
			strFuncName = "{? = call MMS_MST.Generate_Returnno(?,?,?,?)}";
			nFuncIndex = dao.setFunction(strFuncName);

			
			dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrReqTypeId());
			dao.setFuncInValue(nFuncIndex, 5, vo.getStrItemCategoryNo());
			dao.setFuncOutValue(nFuncIndex, 1);
			
			dao.executeFunction(nFuncIndex);
			strReturnNo = dao.getFuncString(nFuncIndex);
			
			
			patEmpDtlDao.setStrStoreId(vo.getStrStoreId());
			patEmpDtlDao.setStrReturnNo(strReturnNo);
			patEmpDtlDao.setStrHospitalCode(vo.getStrHospitalCode());//1
			patEmpDtlDao.setStrIssueNo(vo.getStrIssueNo());//2
			patEmpDtlDao.setStrReturnDate(vo.getStrReturnDate());
			patEmpDtlDao.setStrReqtypeId(vo.getStrReqTypeId());
			patEmpDtlDao.setStrCrNo(vo.getStrCrNo());
			patEmpDtlDao.setStrAdmnNo(vo.getStrAdmnNo());
			patEmpDtlDao.setStrIssueDate(vo.getStrIssueDate());
			patEmpDtlDao.setStrEmpNo(vo.getStrEmpNo());
			patEmpDtlDao.setStrItemCatNo(vo.getStrItemCategoryNo());
			patEmpDtlDao.setStrReturnNetCost(vo.getStrNetCost());
			patEmpDtlDao.setStrFinStartDate(vo.getStrFinStartDate());
			patEmpDtlDao.setStrFinEndDate(vo.getStrFinEndDate());
			patEmpDtlDao.setStrRecommendedBy(vo.getStrRecommendedBy());
			patEmpDtlDao.setStrRecommendDate(vo.getStrRecommendDate());
			patEmpDtlDao.setStrRemarks(vo.getStrRemarks());
			patEmpDtlDao.setStrSeatId(vo.getStrSeatId());
			patEmpDtlDao.setStrIsValid(vo.getStrIsValid());
			patEmpDtlDao.insert(dao);
			
			int nMultiRowLen = vo.getStrReturnQty().length;
		
			for(int i=0;i<nMultiRowLen;i++)
			{
				
				patEmpItemDtlDao.setStrStoreId(vo.getStrStoreId());
				patEmpItemDtlDao.setStrReturnNo(strReturnNo);
				patEmpItemDtlDao.setStrItemId(vo.getStrItemId()[i]);
				patEmpItemDtlDao.setStrItemBrandId(vo.getStrItemBrandId()[i]);
				patEmpItemDtlDao.setStrBatchSlNo(vo.getStrBatchSlNo()[i]);
				patEmpItemDtlDao.setStrHospitalCode(vo.getStrHospitalCode());	
				patEmpItemDtlDao.setStrReturnDate(vo.getStrReturnDate());
				patEmpItemDtlDao.setStrItemSlNo(vo.getStrItemSlNo()[i]);
				patEmpItemDtlDao.setStrGroupId(vo.getStrGroupId()[i]);
				patEmpItemDtlDao.setStrSubGroupId(vo.getStrSubGroupId()[i]);
				
				strFuncName = "{? = call MMS_MST.get_stock_dtl(?,?,?,?,?,?,?,?,?,?)}";
				nFuncIndex = dao.setFunction(strFuncName);
								
				dao.setFuncInValue(nFuncIndex, 2, "4");
				dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
				dao.setFuncInValue(nFuncIndex, 4, vo.getStrItemId()[i]);
				dao.setFuncInValue(nFuncIndex, 5, vo.getStrItemBrandId()[i]);
				dao.setFuncInValue(nFuncIndex, 6, vo.getStrBatchSlNo()[i]);
				dao.setFuncInValue(nFuncIndex, 7, vo.getStrStockStatusCode()[i]);
				dao.setFuncInValue(nFuncIndex, 8, vo.getStrStoreId());
				dao.setFuncInValue(nFuncIndex, 9, "0");
				dao.setFuncInValue(nFuncIndex, 10, vo.getStrReservedFlag());
				dao.setFuncInValue(nFuncIndex, 11, "1");
				dao.setFuncOutValue(nFuncIndex, 1);
				
				dao.executeFunction(nFuncIndex);
				strInhand = dao.getFuncString(nFuncIndex);
						
				String[] temp = strInhand.replace("^", "#").split("#");
				
				patEmpItemDtlDao.setStrInhandQty(temp[0]);
				patEmpItemDtlDao.setStrInhandQtyUnitId(temp[1]);
				patEmpItemDtlDao.setStrBalanceQty(vo.getStrBalanceQty()[i]);
				patEmpItemDtlDao.setStrBalanceQtyUnitId(vo.getStrBalanceQtyUnitId()[i]);
				patEmpItemDtlDao.setStrRateQty(vo.getStrRate()[i]);
				patEmpItemDtlDao.setStrRateQtyUnitId(vo.getStrRateQtyUnitId()[i]);
				patEmpItemDtlDao.setStrReturnQty(vo.getStrReturnQty()[i]);
				patEmpItemDtlDao.setStrReturnQtyUnitId(vo.getStrReturnQtyUnitId()[i]);
				patEmpItemDtlDao.setStrRemarks(vo.getStrRemarks());
				patEmpItemDtlDao.setStrCost(vo.getStrTotalCost()[i]);
				patEmpItemDtlDao.setStrStockStatusCode(vo.getStrStockStatusCode()[i]);
				patEmpItemDtlDao.setStrIsValid(vo.getStrIsValid());
				patEmpItemDtlDao.setStrIssueNo(vo.getStrIssueNo());
				patEmpItemDtlDao.insert(dao);
			
			
			String	strProcName2 = "{call Pkg_Mms_Dml.Dml_Stock_Update(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			
			
			int nProcIndex2 = dao.setProcedure(strProcName2);
			dao.setProcInValue(nProcIndex2, "modval", "5");
			
			dao.setProcInValue(nProcIndex2, "old_strid", vo.getStrStoreId());
			dao.setProcInValue(nProcIndex2, "old_itemid", vo.getStrItemId()[i]);
			dao.setProcInValue(nProcIndex2, "old_itembrandid", vo.getStrItemBrandId()[i]);
			dao.setProcInValue(nProcIndex2, "old_batchno", vo.getStrBatchSlNo()[i]);
			dao.setProcInValue(nProcIndex2, "old_stockstatuscode","10");
			dao.setProcInValue(nProcIndex2, "reqtypeid",vo.getStrReqTypeId());
			dao.setProcInValue(nProcIndex2, "old_itemserialno",vo.getStrItemSlNo()[i]);
			
			
			dao.setProcInValue(nProcIndex2, "transNo", strReturnNo);
			dao.setProcInValue(nProcIndex2, "transDate", vo.getStrReturnDate());
			
			dao.setProcInValue(nProcIndex2, "description", "Return From Employee:"+vo.getStrEmpNo()+":");
			
			
			dao.setProcInValue(nProcIndex2, "strid", vo.getStrStoreId());
			dao.setProcInValue(nProcIndex2, "tostrid", vo.getStrStoreId());
			dao.setProcInValue(nProcIndex2, "itemid", vo.getStrItemId()[i]);
			dao.setProcInValue(nProcIndex2, "itembrandid", vo.getStrItemBrandId()[i]);
			dao.setProcInValue(nProcIndex2, "hosp_code",vo.getStrHospitalCode());
			dao.setProcInValue(nProcIndex2, "itemcatno",vo.getStrItemCategoryNo());
			dao.setProcInValue(nProcIndex2, "inhandqty", vo.getStrReturnQty()[i]);
			dao.setProcInValue(nProcIndex2, "inhandqtyunitid", vo.getStrReturnQtyUnitId()[i]);
			dao.setProcInValue(nProcIndex2, "stockstatuscode",vo.getStrStockStatusCode()[i]);
			dao.setProcInValue(nProcIndex2, "reservedFlag", vo.getStrReservedFlag());
			dao.setProcInValue(nProcIndex2, "seatid", vo.getStrSeatId());
			
			dao.setProcInValue(nProcIndex2, "batchno", "0");
			dao.setProcInValue(nProcIndex2, "groupid", "");
			dao.setProcInValue(nProcIndex2, "subgroupid", "0");
			dao.setProcInValue(nProcIndex2, "expirydate", "");
			dao.setProcInValue(nProcIndex2, "manufdate","");
			dao.setProcInValue(nProcIndex2, "inventoryflag","");
			dao.setProcInValue(nProcIndex2, "suppid","");
			dao.setProcInValue(nProcIndex2, "rate", "0");
			dao.setProcInValue(nProcIndex2, "rateunitid","");
			dao.setProcInValue(nProcIndex2, "saleprice", "0");
			dao.setProcInValue(nProcIndex2, "salepriceunitid", "");
			
			dao.setProcInValue(nProcIndex2, "pono", "");
			dao.setProcInValue(nProcIndex2, "podate","");
			dao.setProcInValue(nProcIndex2, "suppliedby","");
			dao.setProcInValue(nProcIndex2, "recieveddate", "");
			dao.setProcInValue(nProcIndex2, "currencycode", "");
			dao.setProcInValue(nProcIndex2, "freeitemflag","0");
			dao.setProcInValue(nProcIndex2, "currencyvalue", "0");
			dao.setProcInValue(nProcIndex2, "itemparamflag", "0");
			
			dao.setProcInValue(nProcIndex2, "partflag", "0");
			dao.setProcInValue(nProcIndex2, "warrentyflag","0");
			dao.setProcInValue(nProcIndex2, "blockqtyflag","0");
			dao.setProcInValue(nProcIndex2, "blockedqty", "0");
			dao.setProcInValue(nProcIndex2, "blockedqtyunitid", "0");
			dao.setProcInValue(nProcIndex2, "releaseqty","0");
			dao.setProcInValue(nProcIndex2, "releaseqtyunitid", "0");
			dao.setProcInValue(nProcIndex2, "invoiceNo", "");
			
			dao.setProcInValue(nProcIndex2, "invoiceDate","");
			dao.setProcInValue(nProcIndex2, "item_serialNoFlag", "1");
			dao.setProcInValue(nProcIndex2, "item_specification", "");
			
			dao.setProcOutValue(nProcIndex2, "err", 1);
			dao.setProcOutValue(nProcIndex2, "retSerialNo", 1);
			
			dao.execute(nProcIndex2, 1);
		}
			synchronized (dao) {
				dao.fire();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("ReturnFromEmployeeTransDAO.insert() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	

}
