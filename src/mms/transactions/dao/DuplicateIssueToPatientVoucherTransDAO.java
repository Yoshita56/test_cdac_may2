/**
 * 
 */
package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;


import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.dao.ReturnFromDtlDAO;
import mms.dao.ReturnFromItemDtlDAO;
import mms.transactions.vo.DuplicateIssueToPatientVoucherTransVO;

/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Date : 23/April/2009
 * Mod Date : 11/June/2009
 * 
 */
public class DuplicateIssueToPatientVoucherTransDAO {
	/**
	 * Get the Store Name in Combo.
	 * @param vo
	 */
	public static void storeName(DuplicateIssueToPatientVoucherTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Duplicate OPDVoucher","DuplicateIssueToPatientVoucherTransDAO");
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
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setStoreNameWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("DuplicateIssueToPatientVoucherTransDAO.storeName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * Get the Recommend Name in Combo.
	 * @param vo
	 */
	public static void getRecommendName(DuplicateIssueToPatientVoucherTransVO vo)
	{
		String strProcName = "{call PKG_MMS_VIEW.proc_consultant_name(?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Duplicate OPDVoucher","DuplicateIssueToPatientVoucherTransDAO");
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
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setRecommendNameWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("DuplicateIssueToPatientVoucherTransDAO.getRecommendName() --> "
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
	public static void getItemCategory(DuplicateIssueToPatientVoucherTransVO vo) {

		String strProcName = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Duplicate OPDVoucher","DuplicateIssueToPatientVoucherTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "reqType", "41");
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
			vo.setStrMsgString("DuplicateIssueToPatientVoucherTransDAO.getItemCategory() --> "
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
	public static void getIssueNoCombo(DuplicateIssueToPatientVoucherTransVO vo) {

		String strProcName = "{call Pkg_Mms_View.PROC_PATEMP_ISSUE_DTL(?,?,?,?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Duplicate OPDVoucher","DuplicateIssueToPatientVoucherTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modval", "1",1);
			daoObj.setProcInValue(nProcIndex, "storeid", vo.getStrStoreId(),3);
			daoObj.setProcInValue(nProcIndex, "hoscode", vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "itemcat", vo.getStrItemCategoryNo(),7);
			daoObj.setProcInValue(nProcIndex, "pukno", vo.getStrCrNo(),5);
			daoObj.setProcInValue(nProcIndex, "reqtype", vo.getStrReqTypeId(),8);
			daoObj.setProcInValue(nProcIndex, "issueno", "",4);
			daoObj.setProcInValue(nProcIndex, "empno", "",6);
			daoObj.setProcOutValue(nProcIndex, "err",1,9); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,10);
			daoObj.executeProcedureByPosition(nProcIndex);
//			//System.out.println("itemcat:::"+vo.getStrItemCategoryNo());
//			//System.out.println("storeID:::"+vo.getStrStoreId());
//			//System.out.println("reqType:::"+vo.getStrReqTypeId());
//			//System.out.println("vo.getStrCrNo()==>"+vo.getStrCrNo());
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setIssueNoWS(ws);
				////System.out.println("Size-->"+ws.size());
				
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("DuplicateIssueToPatientVoucherTransDAO.getIssueNoCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}

	}

	
	public static void getIssueNoDateCombo(DuplicateIssueToPatientVoucherTransVO vo) {

		String strProcName = "{call Pkg_Mms_View.PROC_PATEMP_ISSUE_DTL(?,?,?,?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Duplicate OPDVoucher","DuplicateIssueToPatientVoucherTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modval", "5",1);
			daoObj.setProcInValue(nProcIndex, "storeid", vo.getStrStoreId(),3);
			daoObj.setProcInValue(nProcIndex, "hoscode", vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "itemcat", vo.getStrItemCategoryNo(),7);
			daoObj.setProcInValue(nProcIndex, "pukno", vo.getStrCrNo(),5);
			daoObj.setProcInValue(nProcIndex, "reqtype", vo.getStrReqTypeId(),8);
			daoObj.setProcInValue(nProcIndex, "issueno", "",4);
			daoObj.setProcInValue(nProcIndex, "empno", "",6);
			daoObj.setProcOutValue(nProcIndex, "err",1,9); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,10);
			daoObj.executeProcedureByPosition(nProcIndex);
//			//System.out.println("itemcat:::"+vo.getStrItemCategoryNo());
//			//System.out.println("storeID:::"+vo.getStrStoreId());
//			//System.out.println("reqType:::"+vo.getStrReqTypeId());
//			//System.out.println("vo.getStrCrNo()==>"+vo.getStrCrNo());
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setIssueNoWS(ws);
				////System.out.println("Size-->"+ws.size());
				
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("DuplicateIssueToPatientVoucherTransDAO.getIssueNoCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}

	}

	
	
	/**
	 * To get Issue details on the basis of Issue no. and store id and hospital code
	 * 
	 * @param vo
	 */
	public static void getIssueDetails(DuplicateIssueToPatientVoucherTransVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			dao = new HisDAO("mms", "DuplicateIssueToPatientVoucherTransDAO");

			strProcName = "{call Pkg_Mms_View.PROC_PATEMP_ISSUE_DTL(?,?,?,?,?,?,?,?,?,?)}";

			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modval", "2",1);
			dao.setProcInValue(nProcIndex, "hoscode", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "issueno", vo.getStrIssueNo(),4);
			dao.setProcInValue(nProcIndex, "storeid", "",3);
			dao.setProcInValue(nProcIndex, "pukno", "",5);
			dao.setProcInValue(nProcIndex, "empno", "",6);
			dao.setProcInValue(nProcIndex, "itemcat", "",7);
			dao.setProcInValue(nProcIndex, "reqtype", "",8);
			dao.setProcOutValue(nProcIndex, "err", 1,9);
			dao.setProcOutValue(nProcIndex, "resultset", 2,10);
			dao.executeProcedureByPosition(nProcIndex);
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
			vo.setStrMsgString("DuplicateIssueToPatientVoucherTransDAO.getIssueDetails() --> "
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
	public static void getItemDetail(DuplicateIssueToPatientVoucherTransVO vo) {

		String err = "";
		String proc_name1 = "{call Pkg_Mms_View.proc_issue_item_dtls(?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms", "DuplicateIssueToPatientVoucherTransDAO");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "modeval", "2",1);
			dao.setProcInValue(procIndex1, "hoscode", vo.getStrHospitalCode(),2);
			dao.setProcInValue(procIndex1, "issueno", vo.getStrIssueNo(),3);
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
			} else {

				throw new Exception(err);
			}

		} catch (Exception e) {
            e.printStackTrace();
			vo.setStrMsgString("DuplicateIssueToPatientVoucherTransDAO.getItemDetail() --> "
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
	public static void getReturnUnitCombo(DuplicateIssueToPatientVoucherTransVO vo) {
		String strProcName = "{call Pkg_Mms_View.proc_GBLT_UNIT_MST(?,?,?,?,?,?)}";
		HisDAO dao = null;
		WebRowSet ws = null;
		int nProcIndex = 0;

		String strErr = "";

		try {
			dao = new HisDAO("mms", "DuplicateIssueToPatientVoucherTransDAO");

			nProcIndex = dao.setProcedure(strProcName);
			dao.setProcInValue(nProcIndex, "modeval", "1",4);
			dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),1);
			dao.setProcInValue(nProcIndex, "unit_id", vo.getStrIssueQtyUnitId(),2);
			dao.setProcInValue(nProcIndex, "module_id", "",3);
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);

			dao.executeProcedureByPosition(nProcIndex);

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

			vo.setStrMsgString("DuplicateIssueToPatientVoucherTransDAO.getReturnUnitCombo() --> "
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
	public synchronized static void insert(DuplicateIssueToPatientVoucherTransVO vo)
	{
		HisDAO dao = null;
		
		ReturnFromDtlDAO patEmpDao = null;
		ReturnFromItemDtlDAO patEmpItemDao = null;
		String strFuncName = "";
		int nFuncIndex = 0;
		String strReturnNo = "";
		String strInhand = "";
		MmsConfigUtil mcu=null;
		String tariff="",qty="";
		try {
			dao = new HisDAO("mms", "DuplicateIssueToPatientVoucherTransDAO");
			
			patEmpDao = new ReturnFromDtlDAO();
			patEmpItemDao = new ReturnFromItemDtlDAO();
			mcu = new MmsConfigUtil(vo.getStrHospitalCode());
			
			strFuncName = "{? = call MMS_MST.Generate_Returnno(?::numeric,?::numeric,?::numeric,?::numeric)}";
			nFuncIndex = dao.setFunction(strFuncName);

			
			dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrStoreId());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrReqTypeId());
			dao.setFuncInValue(nFuncIndex, 5, vo.getStrItemCategoryNo());
			dao.setFuncOutValue(nFuncIndex, 1);
			
			dao.executeFunction(nFuncIndex);
			strReturnNo = dao.getFuncString(nFuncIndex);
			vo.setStrReturnNo(strReturnNo);
			
			patEmpDao.setStrStoreId(vo.getStrStoreId());
			patEmpDao.setStrReturnNo(strReturnNo);
			patEmpDao.setStrHospitalCode(vo.getStrHospitalCode());//1
			patEmpDao.setStrIssueNo((vo.getStrIssueNo()!=null && !vo.getStrIssueNo().equals(""))?vo.getStrIssueNo():vo.getStrIssueNumber());//2
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
		
			for(int i=0;i<nMultiRowLen;i++)
			{
		
				if(vo.getStrReturnQty()[i] != null && vo.getStrReturnQty()[i].length() > 0 && !vo.getStrReturnQty()[i].equals("0"))
				{
				////System.out.println("item id ["+i+"] : "+vo.getStrItemId()[i]);
				////System.out.println("item brand id ["+i+"] : "+vo.getStrItemBrandId()[i]);
					if(i==0)
					{
						tariff=vo.getStrItemBrandId()[i];
						qty=vo.getStrReturnQty()[i];
					}
					else
					{
						tariff=tariff+"^"+vo.getStrItemBrandId()[i];
						qty=qty+"^"+vo.getStrReturnQty()[i];
					}
				patEmpItemDao.setStrStoreId(vo.getStrStoreId());
				patEmpItemDao.setStrReturnNo(strReturnNo);
				patEmpItemDao.setStrItemId(vo.getStrItemId()[i]);
				patEmpItemDao.setStrItemBrandId(vo.getStrItemBrandId()[i]);
				patEmpItemDao.setStrBatchSlNo(vo.getStrBatchSlNo()[i]);
				patEmpItemDao.setStrHospitalCode(vo.getStrHospitalCode());	
				patEmpItemDao.setStrReturnDate(vo.getStrReturnDate());
				patEmpItemDao.setStrItemSlNo(vo.getStrItemSlNo()[i]);
				patEmpItemDao.setStrGroupId(vo.getStrGroupId()[i]);
				patEmpItemDao.setStrSubGroupId(vo.getStrSubGroupId()[i]);
				
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
						
				String[] temp = strInhand.replace("^", "#").split("#");
							
				patEmpItemDao.setStrInhandQty(temp[0]);
				patEmpItemDao.setStrInhandQtyUnitId(temp[1]);
				patEmpItemDao.setStrBalanceQty(vo.getStrBalanceQty()[i]);
				patEmpItemDao.setStrBalanceQtyUnitId(vo.getStrBalanceQtyUnitId()[i]);
				patEmpItemDao.setStrRateQty(vo.getStrRate()[i]);
				patEmpItemDao.setStrRateQtyUnitId(vo.getStrRateQtyUnitId()[i]);
				patEmpItemDao.setStrReturnQty(vo.getStrReturnQty()[i]);
				patEmpItemDao.setStrReturnQtyUnitId(vo.getStrReturnQtyUnitId()[i]);
				patEmpItemDao.setStrRemarks(vo.getStrRemarks());
				patEmpItemDao.setStrCost(vo.getStrTotalCost()[i]);
				patEmpItemDao.setStrStockStatusCode(vo.getStrStockStatusCode());
				patEmpItemDao.setStrIsValid(vo.getStrIsValid());
				patEmpItemDao.setStrIssueNo((vo.getStrIssueNo()!=null && !vo.getStrIssueNo().equals(""))?vo.getStrIssueNo():vo.getStrIssueNumber());
				patEmpItemDao.setStrExpiry(vo.getStrExpiry()[i]);
				patEmpItemDao.insert(dao);
			
			
				String	strProcName2 = "{call Pkg_Mms_Dml.Dml_Stock_Update(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				
				int nProcIndex2 = dao.setProcedure(strProcName2);
				dao.setProcInValue(nProcIndex2, "modval", "5",1);
				
				
				dao.setProcInValue(nProcIndex2, "old_strid", vo.getStrStoreId(),34);
				dao.setProcInValue(nProcIndex2, "old_itemid", vo.getStrItemId()[i],32);
				dao.setProcInValue(nProcIndex2, "old_itembrandid", vo.getStrItemBrandId()[i],33);
				dao.setProcInValue(nProcIndex2, "old_batchno", vo.getStrBatchSlNo()[i],30);
				dao.setProcInValue(nProcIndex2, "old_stockstatuscode",vo.getStrStockStatusCode(),29);
				dao.setProcInValue(nProcIndex2, "reqtypeid",vo.getStrReqTypeId(),43);
				dao.setProcInValue(nProcIndex2, "old_itemserialno",vo.getStrItemSlNo()[i],31);
				
				
				dao.setProcInValue(nProcIndex2, "transNo", strReturnNo,40);
				dao.setProcInValue(nProcIndex2, "transDate", vo.getStrReturnDate(),41);
				if(vo.getStrReqTypeId().equals("41")){
					dao.setProcInValue(nProcIndex2, "description", "Duplicate OPDVoucher Patient, CR No :: "+vo.getStrCrNo(),42);
				}else{
					dao.setProcInValue(nProcIndex2, "description", "Duplicate OPDVoucher Staff, CR No. :: "+vo.getStrCrNo() + ", Emp No. :: " + vo.getStrEmpNo(),42);
				}
				
				dao.setProcInValue(nProcIndex2, "strid", vo.getStrStoreId(),2);
				dao.setProcInValue(nProcIndex2, "tostrid", vo.getStrStoreId(),38);
				dao.setProcInValue(nProcIndex2, "itemid", vo.getStrItemId()[i],3);
				dao.setProcInValue(nProcIndex2, "itembrandid", vo.getStrItemBrandId()[i],4);
				dao.setProcInValue(nProcIndex2, "hosp_code",vo.getStrHospitalCode(),27);
				dao.setProcInValue(nProcIndex2, "itemcatno",vo.getStrItemCategoryNo(),6);
				dao.setProcInValue(nProcIndex2, "inhandqty", vo.getStrReturnQty()[i],13);
				dao.setProcInValue(nProcIndex2, "inhandqtyunitid", vo.getStrReturnQtyUnitId()[i],14);
				dao.setProcInValue(nProcIndex2, "reservedFlag", vo.getStrReservedFlag(),39);
				dao.setProcInValue(nProcIndex2, "seatid", vo.getStrSeatId(),22);
				
				dao.setProcInValue(nProcIndex2, "batchno", "0",5);
				dao.setProcInValue(nProcIndex2, "groupid", "",7);
				dao.setProcInValue(nProcIndex2, "subgroupid", "0",8);
				dao.setProcInValue(nProcIndex2, "expirydate", "",9);
				dao.setProcInValue(nProcIndex2, "manufdate","",10);
				dao.setProcInValue(nProcIndex2, "stockstatuscode","1",11);
				dao.setProcInValue(nProcIndex2, "inventoryflag","",12);
				dao.setProcInValue(nProcIndex2, "suppid","",15);
				dao.setProcInValue(nProcIndex2, "rate", "0",16);
				dao.setProcInValue(nProcIndex2, "rateunitid","",17);
				dao.setProcInValue(nProcIndex2, "saleprice", "0",18);
				dao.setProcInValue(nProcIndex2, "salepriceunitid", "",19);
				
				dao.setProcInValue(nProcIndex2, "pono", "",20);
				dao.setProcInValue(nProcIndex2, "podate","",21);
				dao.setProcInValue(nProcIndex2, "suppliedby","",23);
				dao.setProcInValue(nProcIndex2, "recieveddate", "",24);
				dao.setProcInValue(nProcIndex2, "currencycode", "",25);
				dao.setProcInValue(nProcIndex2, "freeitemflag","0",26);
				dao.setProcInValue(nProcIndex2, "currencyvalue", "0",28);
				dao.setProcInValue(nProcIndex2, "itemparamflag", "0",35);
				
				dao.setProcInValue(nProcIndex2, "partflag", "0",36);
				dao.setProcInValue(nProcIndex2, "warrentyflag","0",37);
				dao.setProcInValue(nProcIndex2, "blockqtyflag","0",44);
				dao.setProcInValue(nProcIndex2, "blockedqty", "0",45);
				dao.setProcInValue(nProcIndex2, "blockedqtyunitid", "0",46);
				dao.setProcInValue(nProcIndex2, "releaseqty","0",47);
				dao.setProcInValue(nProcIndex2, "releaseqtyunitid", "0",48);
				dao.setProcInValue(nProcIndex2, "invoiceNo", "",49);
				
				dao.setProcInValue(nProcIndex2, "invoiceDate","",50);
				dao.setProcInValue(nProcIndex2, "item_serialNoFlag", "1",51);
				dao.setProcInValue(nProcIndex2, "item_specification", "",52);
				
				dao.setProcOutValue(nProcIndex2, "err", 1,54);
				dao.setProcOutValue(nProcIndex2, "retSerialNo", 1,53);
				
				dao.execute(nProcIndex2, 1);
				
				
				
				
			}
		}
			
			if(mcu.getStrBillingIntegration().equals("1"))
			{
				String strProcName3 = "{call bill_interface.dml_online_billreq_refund(?,?,?,?,? ,?,?,?,?,? ,?,?,?)}";
				int nProcIndex3 = dao.setProcedure(strProcName3);
				dao.setProcInValue(nProcIndex3, "modval", "1",1);
				dao.setProcInValue(nProcIndex3, "sblnum_chargetype_id", vo.getStrChargeTypeId(),2);
				dao.setProcInValue(nProcIndex3, "sblnum_service_id", "5",3);
				dao.setProcInValue(nProcIndex3, "gstr_req_no", vo.getStrIssueNo().split("\\^")[0],4);
				dao.setProcInValue(nProcIndex3, "gnum_treatment_cat", "11",5);
				dao.setProcInValue(nProcIndex3, "hrgnum_puk", vo.getStrCrNo(),6);
				dao.setProcInValue(nProcIndex3, "gstr_tariff", tariff,7);
				dao.setProcInValue(nProcIndex3, "gstr_reqqty", qty,8);
				dao.setProcInValue(nProcIndex3, "gnum_seatid", vo.getStrSeatId(),9);
				dao.setProcInValue(nProcIndex3, "hosp_code", vo.getStrHospitalCode(),10);
				dao.setProcInValue(nProcIndex3, "admno", "0",11);
				dao.setProcInValue(nProcIndex3, "remarks", "Duplicate OPDVoucher CR No :: "+vo.getStrCrNo(),12);
				dao.setProcOutValue(nProcIndex3, "err", 1,13);
				dao.execute(nProcIndex3, 1);
			}
			
			dao.fire();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("DuplicateIssueToPatientVoucherTransDAO.insert() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * Change Request
	 * @param vo
	 */
	public static void validateIssueNumber(DuplicateIssueToPatientVoucherTransVO vo)
	{
		String strFuncName = "";
		String strIssueNoCount = "";
		
		int nFuncIndex = 0;
		HisDAO dao = null;
		try 
		{
			dao = new HisDAO("MMS Transactions","IssueTransDAO");
			
			strFuncName = "{? = call MMS_MST.validate_IssueNo_dtls(?,?,?)}";
			nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrIssueNumber());
			dao.setFuncInValue(nFuncIndex, 4, vo.getStrReturnDrugValidity());
			
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strIssueNoCount = dao.getFuncString(nFuncIndex);
			vo.setStrIssueNumberValidationFlag(strIssueNoCount);
			
			
		}	
		catch (Exception e) {
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

	public static void getIssueDetailsBasedOnPatientNameOrCrNo(DuplicateIssueToPatientVoucherTransVO vo) 
	{
		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";
	//	HisUtil.replaceNullValueWithEmptyString(vo);

		                    
		try {
			dao = new HisDAO("mms", "DuplicateIssueToPatientVoucherTransDAO");

			strProcName = "{call Pkg_Mms_View.Proc_IssueDtl_On_CrNoOrPatName(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";

			nProcIndex = dao.setProcedure(strProcName);

			////////
		/*	
			//System.out.println( "p_mode"+ vo.getStrMode());
			//System.out.println( "p_hstnum_store_id"+ vo.getStrStoreId());
			//System.out.println( "p_hstnum_issue_no"+ vo.getStrIssueNo());
			//System.out.println( "p_gnum_hospital_code"+ vo.getStrHospitalCode());			
			//System.out.println( "p_hstnum_req_no"+ vo.getStrReqNo());
			
			//System.out.println( "p_hrgnum_puk"+ vo.getStrCrNo());
			//System.out.println( "p_hipnum_adm_no"+ vo.getStrAdmnNo());
			//System.out.println( "p_pistr_emp_no"+ vo.getStrEmpNo());
			//System.out.println( "p_sstnum_item_cat_no"+ vo.getStrItemCategoryNo());
			//System.out.println( "p_sstnum_reqtype_id"+ vo.getStrReqTypeId());
			
			//System.out.println( "p_hstdt_issue_date"+ vo.getStrIssueDate());
			//System.out.println( "p_hststr_patient_name"+ vo.getStrPatName());
			//System.out.println( "p_fromdate"+ vo.getStrFromDate());
			//System.out.println( "p_todate"+ vo.getStrToDate());
			//System.out.println( "p_days"+ vo.getStrDays());
			//System.out.println( "p_returnDrugValidityDays"+ vo.getStrReturnDrugValidity());

			*/
			
			
			//////////////////////
			dao.setProcInValue(nProcIndex, "p_mode", vo.getStrMode());
			dao.setProcInValue(nProcIndex, "p_hstnum_store_id", vo.getStrStoreId());
			dao.setProcInValue(nProcIndex, "p_hstnum_issue_no", vo.getStrIssueNo());
			dao.setProcInValue(nProcIndex, "p_gnum_hospital_code", vo.getStrHospitalCode());			
			dao.setProcInValue(nProcIndex, "p_hstnum_req_no", vo.getStrReqNo());
			
			dao.setProcInValue(nProcIndex, "p_hrgnum_puk", vo.getStrCrNo());
			dao.setProcInValue(nProcIndex, "p_hipnum_adm_no", vo.getStrAdmnNo());
			dao.setProcInValue(nProcIndex, "p_pistr_emp_no", vo.getStrEmpNo());
			dao.setProcInValue(nProcIndex, "p_sstnum_item_cat_no", vo.getStrItemCategoryNo());
			dao.setProcInValue(nProcIndex, "p_sstnum_reqtype_id", vo.getStrReqTypeId());
			
			dao.setProcInValue(nProcIndex, "p_hstdt_issue_date", vo.getStrIssueDate());
			dao.setProcInValue(nProcIndex, "p_hststr_patient_name", vo.getStrPatName());
			dao.setProcInValue(nProcIndex, "p_fromdate", vo.getStrFromDate());
			dao.setProcInValue(nProcIndex, "p_todate", vo.getStrToDate());
			dao.setProcInValue(nProcIndex, "p_days", vo.getStrDays());
			
			
			
			dao.setProcInValue(nProcIndex, "p_returnDrugValidityDays", vo.getStrReturnDrugValidity());


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
			vo.setStrMsgString("DuplicateIssueToPatientVoucherTransDAO.getIssueDetails() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
		
	}

	public static void getpatientDemographicDetail(DuplicateIssueToPatientVoucherTransVO vo) 
	{
	
		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";
		//HisUtil.replaceNullValueWithEmptyString(vo);

		                    
		try {
			dao = new HisDAO("mms", "DuplicateIssueToPatientVoucherTransDAO");

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
			vo.setStrMsgString("DuplicateIssueToPatientVoucherTransDAO.getIssueDetails() --> "
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
