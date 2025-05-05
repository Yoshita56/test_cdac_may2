package mms.transactions.dao;

import freemarker.cache.StrongCacheStorage;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.reports.vo.ListConsumablesExpiryDateRptVO;
import mms.reports.vo.ListItemWiseSupplierRptVO;
import mms.transactions.vo.PhysicalNewStockVerfTransVO;

public class PhysicalNewStockVerfTransDAO {

	/**
	 * for getting option value of combo on add page (store type name ).
	 * 
	 * @param vo
	 *            the vo
	 */

	public static void GetData(PhysicalNewStockVerfTransVO vo) //seen
	{
		/* Declaring Variable */
		HisDAO dao = null;
		WebRowSet wb = null;
		String str1 = null;
		HisUtil hisutil = null;
		try {

			hisutil = new HisUtil("MMSModule", "PhysicalNewStockVerfTransDAO");
			vo.setStrMode("1");
			wb = CombinedProc(vo);
			//System.out.println("ws"+wb.size());
			if (wb != null && wb.size() > 0) {
				if (wb.next()) 
				{
					vo.setStrStoreId(wb.getString(1).split("\\^")[0]);
					vo.setStrPhyDetails(wb.getString(1));
					wb.beforeFirst();
				}
				
				
				vo.setStrMode("2");
				vo.setPrevPhyStockReqHlpWS(CombinedProc(vo));
				//vo.setStrMode("3");
				//vo.setPhyStockVerifiedItemDtlsHlp(CombinedProc(vo));
				
				str1 = hisutil.getOptionValue(wb, "0", "0^Select Value", true);
				vo.setStrStoreName(str1);
			} else {
				str1 = "<option value='0'>DATA  N/A</option>";
				vo.setStrStoreName(str1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> PhysicalNewStockVerfTransDAO.GetData()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}
	
	/**
	 * for getting option value of combo on add page (store type name ).
	 * 
	 * @param vo
	 *            the vo
	 */

	public static void UtilityProc(PhysicalNewStockVerfTransVO vo) //seen
	{
		/* Declaring Variable */
		HisDAO dao = null;
		WebRowSet wb = null;
		
		try 
		{		
			
			wb = CombinedProc(vo);
			vo.setUnitlityProcWS(wb);
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("--> PhysicalNewStockVerfTransDAO.UtilityProc()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}
	/**
	 * CombinedProc(vo) -- > This Method is Used to get WebRowSet for Store
	 * Name Combo from Table.
	 * 
	 * @param vo
	 *            the vo
	 * @return the web row set
	 */
	public static WebRowSet CombinedProc(PhysicalNewStockVerfTransVO vo) //seen
	{
		String proc_name = "";

		proc_name = "{call PKG_MMS_VIEW.proc_phystock_detail(?,?,?,?,?,?,?,?)}";

		HisDAO dao = null;

		int nprocIndex = 0;

		String strerr = "";

		WebRowSet ws = null;	
		try 
		{

			dao = new HisDAO("MMSModule",
					"transactions.PhysicalNewStockVerfTransDAO.CombinedProc(VO)");

			nprocIndex = dao.setProcedure(proc_name);

			// set value
			
			dao.setProcInValue(nprocIndex, "modeval", vo.getStrMode());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "strId",vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "phyStockNo",vo.getStrPhysicalStockNo());
			dao.setProcInValue(nprocIndex, "seatId", vo.getStrSeatId());
			dao.setProcInValue(nprocIndex, "itemcatid", vo.getStrCatcode());
			dao.setProcOutValue(nprocIndex, "err", 1); // 1 for string return
			dao.setProcOutValue(nprocIndex, "resultset", 2); // 2 for object
			// execute procedure
			//System.out.println("itemcatid"+vo.getStrCatcode());
			//System.out.println("vo.getStrMode()"+ vo.getStrMode());
			//System.out.println("vo.getStrStoreId()"+vo.getStrStoreId());
			//System.out.println("vo.getStrPhysicalStockNo()"+vo.getStrPhysicalStockNo());
			//System.out.println("vo.getStrSeatId()"+vo.getStrSeatId());
			
			dao.executeProcedure(nprocIndex);

			// get value

			strerr = dao.getString(nprocIndex, "err");

			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) 
			{
				ws = dao.getWebRowSet(nprocIndex, "resultset");
				//System.out.println("ws"+ws.size());
				vo.setStrMsgType("0");
			} 
			else 
			{
				throw new Exception(strerr);
			}

		}

		catch (Exception e) {

			e.printStackTrace();

			vo.setStrMsgString("-->PhysicalNewStockVerfTransDAO.CombinedProc()"
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
	 * GROUPNAMECOMBO(vo) -- > This Method is Used to get WebRowSet for Store
	 * Name Combo from Table.
	 * 
	 * @param vo
	 *            the vo
	 * @return the store group list
	 */

	public static void groupCombo(PhysicalNewStockVerfTransVO vo) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {

			hisutil = new HisUtil("mms", "PhysicalNewStockVerfTransDAO");
			dao = new HisDAO("mms",
					"PhysicalNewStockVerfTransDAO.getItemParameters(PhysicalNewStockVerfTransVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value			
			dao.setProcInValue(procIndex1, "modeval", "2");
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "item_category", vo.getStrItemCatNo());
			dao.setProcInValue(procIndex1, "strPhyStockNo", "0");
			dao.setProcInValue(procIndex1, "strStoreId", "0");
			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object
			dao.executeProcedure(procIndex1);
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");
			str = "<option value='0'>DATA N/A</option>";
			if (ws != null) 
			{
				str = hisutil.getOptionValue(ws, "", "0^All", true);				
			}
			vo.setStrGroupNameCombo(str);

		} catch (Exception e) {
			e.printStackTrace();

			vo.setStrMsgString("PhysicalNewStockVerfTrans.groupCombo() --> "
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
	 * GROUPNAMECOMBO(vo) -- > This Method is Used to get WebRowSet for Store
	 * Name Combo from Table.
	 * 
	 * @param vo
	 *            the vo
	 * @return the store group list
	 */
	
	public static void stockStatusCombo(PhysicalNewStockVerfTransVO vo) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_stock_status_list(?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {

			hisutil = new HisUtil("mms", "PhysicalNewStockVerfTransDAO");
			dao = new HisDAO("mms",
					"PhysicalNewStockVerfTransDAO.getItemParameters(PhysicalNewStockVerfTransVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "modeval", "1");			
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "itemcat", "10");
			dao.setProcInValue(procIndex1, "itembrandid", "0");
			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object
			dao.executeProcedure(procIndex1);
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			if (ws != null) 
			{
				str = hisutil.getOptionValue(ws, "", "0^Select Value", true);
				vo.setStrStockStatusCombo(str);
			} 
			else 
			{
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrStockStatusCombo(str);
			}

		} catch (Exception e) {

			vo.setStrMsgString("PhysicalNewStockVerfTrans.stockStatusCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	
	public static void suppliedByCombo(PhysicalNewStockVerfTransVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "",str="";
		WebRowSet wb = null;
		HisUtil hisutil = null;
		try 
		{
			hisutil = new HisUtil("mms", "PhysicalNewStockVerfTransDAO");
			dao = new HisDAO("mms", "GiftedItemDetailsTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
						
			dao.setProcInValue(nprocIndex, "modeVal", "1");
			dao.setProcInValue(nprocIndex, "catCode", vo.getStrItemCatNo());
			dao.setProcInValue(nprocIndex, "branditem_id", "0");
			dao.setProcInValue(nprocIndex, "contractType", "0");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null) {
				strerr = "";
			}
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			str = "<option value='0'>DATA N/A</option>";
			if (wb != null) 
			{
				str = hisutil.getOptionValue(wb, "", "0^Select Value", true);				
			}
			vo.setStrMfgNameCombo(str);
			
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("GiftedItemDetailsTransDAO.suppliedByCombo() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/**
	 * Gets the item list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the item list
	 */
	public static void drugNameCombo(PhysicalNewStockVerfTransVO vo) {

		String err = "",str="";

		String proc_name1 = "{call pkg_mms_view.proc_item_detail_phy_stock(?,?,?,?,?,?,?,?,?,?)}"; // 10
    
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet wb = null;
		HisUtil hisutil = null;
		try 
		{
			hisutil = new HisUtil("mms", "PhysicalNewStockVerfTransDAO");
			dao = new HisDAO("mms", "global.MmsDAO.getItemList(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);
			
			// set value
			dao.setProcInValue(procIndex1, "modeval", "1",1);
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(procIndex1, "itemCat", vo.getStrItemCatNo(),3);
			dao.setProcInValue(procIndex1, "frmStrId", vo.getStrStoreId().split("\\^")[0],4);
			dao.setProcInValue(procIndex1, "grpId", vo.getStrGroupId(),5);// set 0
			dao.setProcInValue(procIndex1, "subGrpId", "0",6);// set 0
			dao.setProcInValue(procIndex1, "reqType", "69",7);// 69
			dao.setProcInValue(procIndex1, "userInfo", "0",8);
			dao.setProcOutValue(procIndex1, "err", 1,9);
			dao.setProcOutValue(procIndex1, "resultset", 2,10);
			//System.out.println("vo.getStrHospitalCode()"+vo.getStrHospitalCode());
			//System.out.println("vo.getStrStoreId().split(\\^)[0]"+vo.getStrStoreId().split("\\^")[0]);
			//System.out.println("vo.getStrGroupId()"+vo.getStrGroupId());
			
			dao.executeProcedureByPosition(procIndex1);
			err = dao.getString(procIndex1, "err");
			
			if (err == null) {
				err = "";
			}
			wb = dao.getWebRowSet(procIndex1, "resultset");
			//System.out.println("wb"+wb.size());
			str = "<option value='0'>DATA N/A</option>";
			if (wb != null) 
			{
				str = hisutil.getOptionValue(wb, "", "0^Select Value", true);				
			} 			
			vo.setStrDrugNameCombo(str);
			

		} catch (Exception e) {
            e.printStackTrace();
			vo.setStrMsgString("PhysicalNewStockVerfTransDAO.drugNameCombo() --> " + e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	
	/*
	public static void drugNameCombo(PhysicalNewStockVerfTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_Rpt.rptm_itembrand_list(?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet wb = null;
		HisDAO daoObj=null;
		String err = "",str="";
		HisUtil hisutil = null;
		try
		{
			hisutil = new HisUtil("mms", "PhysicalNewStockVerfTransDAO");
		
			daoObj=new HisDAO("Item Location","ListItemWiseSupplierRptDAO");
			//
			nProcIndex = daoObj.setProcedure(strProcName);
			
			////System.out.println( "modeval"+ "1");
			////System.out.println( "hosp_code"+ vo.getStrHospitalCode());
			////System.out.println( "catCode"+ vo.getStrItemCategoryNo());
			////System.out.println( "groupid"+ vo.getStrGroupId());
			////System.out.println( "subgrpid"+vo.getStrSubGroupId());
			
			
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", MmsConfigUtil.GLOBAL_HOSPITAL_CODE,5);
			daoObj.setProcInValue(nProcIndex, "catCode", vo.getStrItemCatNo(),2);
			daoObj.setProcInValue(nProcIndex, "groupid", vo.getStrGroupId(),3);
			daoObj.setProcInValue(nProcIndex, "subgrpid", "0",4);
			daoObj.setProcOutValue(nProcIndex, "err",1,6); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,7);
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			err = daoObj.getString(nProcIndex, "err");
			if (err == null) {
				err = "";
			}
			wb = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("wb"+wb.size());
			str = "<option value='0'>DATA N/A</option>";
			if (wb != null) 
			{
				str = hisutil.getOptionValue(wb, "", "0^Select Value", true);				
			} 			
			vo.setStrDrugNameCombo(str);
		}
			
		catch(Exception e)
		{
			vo.setStrMsgString("ListItemWiseSupplierRptDAO.ItemName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * Unit in hand name combo.
	 * 
	 * @param vo the vo
	 */
	public static void unitNameCombo(PhysicalNewStockVerfTransVO vo) 
	{

		String strProcName = "",str="";

		int nProcIndex = 0;
		String strErr = "";
		WebRowSet wb = null;
		HisDAO daoObj = null;
		HisUtil hisutil = null;
		try 
		{
			hisutil = new HisUtil("mms", "PhysicalNewStockVerfTransDAO");
			daoObj = new HisDAO("PhysicalNewStockVerfTrans", "PhysicalNewStockVerfTransDAO");

			strProcName = "{call Pkg_Mms_View.Proc_Gblt_Unit_Mst(?,?,?,?,?,?)}";

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", "100");
			daoObj.setProcInValue(nProcIndex, "unit_id",   "0");
			daoObj.setProcInValue(nProcIndex, "module_id", "63"); // Aritra
			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null) {
				strErr = "";
			}
			wb = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("ws"+wb.size());
			if (wb != null) 
			{
				str = hisutil.getOptionValue(wb, "", "", true);
				vo.setStrUnitNameCombo(str);
			} 
			else 
			{
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrUnitNameCombo(str);
			}	
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("PhysicalNewStockVerfTrans.unitNameCombo() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	/**
	 * This function is used to set details in approved By Combo.
	 * 
	 * @param _PhysicalNewStockVerfTransVO
	 *            the _ breakage item dtl trans vo
	 * @return the approved by combo
	 */
	public static void getApprovedByCombo(
			PhysicalNewStockVerfTransVO _PhysicalNewStockVerfTransVO) {

		String strProcName = "{call PKG_MMS_VIEW.proc_store_emp_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		WebRowSet ws = null;
		HisDAO daoObj = null;
		try {
			daoObj = new HisDAO("MMSModule", "PhysicalNewStockVerfTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			// Set Value
			daoObj.setProcInValue(nProcIndex, "modeVal", "1");
			daoObj.setProcInValue(nProcIndex, "storeId",
					_PhysicalNewStockVerfTransVO.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code",
					_PhysicalNewStockVerfTransVO.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			// Execute Procedure
			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				_PhysicalNewStockVerfTransVO.setApprovedByWS(ws);
			}
		} catch (Exception _err) {
			_PhysicalNewStockVerfTransVO
					.setStrMsgString("PhysicalNewStockVerfTransDAO.getApprovedByCombo() --> "
							+ _err.getMessage());
			_PhysicalNewStockVerfTransVO.setStrMsgType("1");
		}
	}

	/**
	 * This function is used to set details in view page(Brakage Item Dtl).
	 * 
	 * @param _PhysicalNewStockVerfTransVO
	 *            the _ breakageitemdtltransvo
	 * @return the view dtl
	 */
	public static void getBreakageDtl(
			PhysicalNewStockVerfTransVO _PhysicalNewStockVerfTransVO) {

		String strProcName = "{call pkg_mms_view.proc_breakkage_Item_dtl(?,?,?,?,?,  ?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		WebRowSet ws = null;
		HisDAO daoObj = null;
		try {
			daoObj = new HisDAO("MMSModule", "PhysicalNewStockVerfTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval",_PhysicalNewStockVerfTransVO.getStrMode());
			daoObj.setProcInValue(nProcIndex, "hosp_code",_PhysicalNewStockVerfTransVO.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "strId", _PhysicalNewStockVerfTransVO.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "itemCategNo",_PhysicalNewStockVerfTransVO.getStrItemCatNo());
			daoObj.setProcInValue(nProcIndex,"start_date",(_PhysicalNewStockVerfTransVO.getStrFromDate() == null || _PhysicalNewStockVerfTransVO.getStrFromDate().equals("")) ? "0": _PhysicalNewStockVerfTransVO.getStrFromDate());
			daoObj.setProcInValue(nProcIndex,"end_date",(_PhysicalNewStockVerfTransVO.getStrToDate() == null || _PhysicalNewStockVerfTransVO.getStrToDate().equals("")) ? "0": _PhysicalNewStockVerfTransVO.getStrToDate());
			daoObj.setProcInValue(nProcIndex,"status",(_PhysicalNewStockVerfTransVO.getStrStatus() == null || _PhysicalNewStockVerfTransVO.getStrStatus().equals("")) ? "0": _PhysicalNewStockVerfTransVO.getStrStatus());
			daoObj.setProcInValue(nProcIndex, "reqNo", (_PhysicalNewStockVerfTransVO.getStrReqNo() == null || _PhysicalNewStockVerfTransVO.getStrReqNo().equals("")) ? "0" : _PhysicalNewStockVerfTransVO.getStrReqNo());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			daoObj.executeProcedure(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				_PhysicalNewStockVerfTransVO.setBreakageItemWS(ws);
			}
		} catch (Exception _err) {
			_err.printStackTrace();
			_PhysicalNewStockVerfTransVO
					.setStrMsgString("PhysicalNewStockVerfTransDAO.getViewDtl() --> "
							+ _err.getMessage());
			_PhysicalNewStockVerfTransVO.setStrMsgType("1");
		}
	}
	
	/**
	 * INSERT method is used to insert value in two table HSTT_BREAKAGE_DTL &
	 * HSTT_BREAKAGE_ITEM_DTL.
	 * 
	 * @param vo
	 *            the vo
	 */

	public synchronized static void TOBEVERIFY(PhysicalNewStockVerfTransVO vo) 
	{
		HisDAO dao = null;
		String[] temp2 = null;
		String strPhyNo = null;
		String strProcName1 = "",strProcName2 = "",strProcName4 = "";
		int nProcIndex1 = 0,nProcIndex2 = 0,nProcIndex4 = 0;
		int funcIndex = 0;
		try 
		{
			temp2 = vo.getStrStoreName().replace('^', '#').split("#");
			vo.setStrStoreId(temp2[0]);
			vo.setStrTolranceLimit(temp2[2]);
			vo.setStrCurrFY(temp2[3]);		

			dao = new HisDAO("MMSModule", "PhysicalNewStockVerfTransDAO.TOBEVERIFY()");
			funcIndex = dao.setFunction("{? = call MMS_MST.generate_phystock_no(?,?)}");
			dao.setFuncInValue(funcIndex, 2, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 3, vo.getStrStoreId());			
			dao.setFuncOutValue(funcIndex, 1);
			
			dao.executeFunction(funcIndex);

			strPhyNo = dao.getFuncString(funcIndex); // Set Breakage No
			vo.setStrPhyStockNo(strPhyNo);		
			 
			strProcName1 = "{call PKG_MMS_DML.dml_physical_stock_item_dtl(?,?,?,?,?,  ?,?,?,?,? , ?,?,?,?,?,  ?,?,?,?,?,?)}"; // 21
			//System.out.println("vo.getStrVerifyCountedQty().length"+vo.getStrVerifyCountedQty().length);				
			for(int i=0;i<vo.getStrVerifyCountedQty().length;i++)
			{
				nProcIndex1  = dao.setProcedure(strProcName1);
								
				dao.setProcInValue(nProcIndex1,  "modval",   		"1",1); 
				dao.setProcInValue(nProcIndex1,  "hosp_code", 		vo.getStrHospitalCode(),2); 
				dao.setProcInValue(nProcIndex1,  "storeId",     	vo.getStrStoreId(),3);
				dao.setProcInValue(nProcIndex1,  "requestNo",    	vo.getStrPhyStockNo(),4);
				 /*
                   HSTNUM_STORE_ID, HSTNUM_ITEM_ID , HSTNUM_ITEMBRAND_ID, HSTSTR_BATCH_NO , HSTNUM_STOCK_STATUS_CODE
                */
				String hiddenvalue=vo.getStrHiddenValue()[i]+"^000";
				dao.setProcInValue(nProcIndex1,  "pkKey",      		hiddenvalue,5);
				dao.setProcInValue(nProcIndex1,  "countedQty", 		vo.getStrVerifyCountedQty()[i],6);	
				dao.setProcInValue(nProcIndex1,  "finYear",     	vo.getStrCurrFY(),7);	
				dao.setProcInValue(nProcIndex1,  "tolLimit",   	    vo.getStrTolranceLimit(),8); 
				dao.setProcInValue(nProcIndex1,  "draftSaveFlag",   vo.getStrDraftFlg(),9); 
				dao.setProcInValue(nProcIndex1,  "modifyFlag",   	vo.getStrModifyFlg(),10); 
				dao.setProcInValue(nProcIndex1,  "newItemFlag", 	vo.getStrNewItemFlg()[i],11); 
				dao.setProcInValue(nProcIndex1,  "expiryDate",      vo.getStrMultiExpiryDate()[i],12);
				dao.setProcInValue(nProcIndex1,  "manufDate",    	vo.getStrMultiMfgDate()[i],13);
				dao.setProcInValue(nProcIndex1,  "manufId",      	vo.getStrMultiSupplierId()[i],14);
				dao.setProcInValue(nProcIndex1,  "rate", 	        "1",15);	
				dao.setProcInValue(nProcIndex1,  "rateUnitId",     	vo.getStrMultiRateUnitId()[i],16);	
				dao.setProcInValue(nProcIndex1,  "tenderNo",   	    "123",17); 
				dao.setProcInValue(nProcIndex1,  "remarks",         vo.getStrItemRemarks()[i],18); 
				dao.setProcInValue(nProcIndex1,  "seatid",   	    vo.getStrSeatId(),19);
				dao.setProcInValue(nProcIndex1,  "itemcatno",   	vo.getStrCatcode(),20);
				dao.setProcOutValue(nProcIndex1, "err",       		1,21); 
				dao.execute(nProcIndex1, 1);
				//System.out.println("vo.getStrCatcode()"+vo.getStrCatcode());
				//System.out.println("vo.getStrHospitalCode()"+vo.getStrHospitalCode()+"\nvo.getStrStoreId()"+vo.getStrStoreId()+"\nvo.getStrPhyStockNo()"+vo.getStrPhyStockNo());
				//System.out.println("vo.getStrHiddenValue()[i]"+vo.getStrHiddenValue()[i]+"\nvo.getStrVerifyCountedQty()[i]"+vo.getStrVerifyCountedQty()[i]+"\nvo.getStrCurrFY()"+vo.getStrCurrFY());
				//System.out.println("vo.getStrTolranceLimit()"+vo.getStrTolranceLimit()+"\nvo.getStrDraftFlg()"+vo.getStrDraftFlg()+"\nvo.getStrModifyFlg()"+vo.getStrModifyFlg());
				//System.out.println("vo.getStrNewItemFlg()[i]"+vo.getStrNewItemFlg()[i]+"\nvo.getStrMultiExpiryDate()[i]"+vo.getStrMultiExpiryDate()[i]+"\nvo.getStrMultiMfgDate()[i]"+vo.getStrMultiMfgDate()[i]);
				////System.out.println("vo.getStrMultiSupplierId()[i]"+vo.getStrMultiSupplierId()[i]+"\nvo.getStrRateWithBaseValue()[i]"+vo.getStrRateWithBaseValue()[i]+"\nvo.getStrMultiRateUnitId()[i]"+vo.getStrMultiRateUnitId()[i]);
				////System.out.println("vo.getStrMultiTenderNo()[i]"+vo.getStrMultiTenderNo()[i]+"\nvo.getStrItemRemarks()[i]"+vo.getStrItemRemarks()[i]+"\nvo.getStrSeatId()"+vo.getStrSeatId());
				//dao.executeProcedureByPosition(nProcIndex1);
				
			}
			strProcName2 = "{call PKG_MMS_DML.dml_physical_stock_item_dtl(?,?,?,?,?,  ?,?,?,?,? , ?,?,?,?,?,  ?,?,?,?,?   ,?)}"; // 20
			
			if(vo.getStrMultiRowPKKey1().length>0)
			{	
			    for(int j=0;j<vo.getStrMultiRowPKKey1().length;j++)
				{	
						
						
			    	if(vo.getStrMultiRowPKKey1()[j].length()>0)
			    	{	
					 //       0           63000^0^1         4
					 //  Rate Base   ^   Rate Unit ^    Supplier ID
					//       5                  6           7 
					// ^ Stock Status     ^  Tender    ^  Remarks
					//       8            9          10
					// ^ Counted Qty ^ Exp Date ^ Mfg date
					
					nProcIndex2  = dao.setProcedure(strProcName2);
					
					dao.setProcInValue(nProcIndex2,  "modval",   		"1",1); 
					dao.setProcInValue(nProcIndex2,  "hosp_code", 		vo.getStrHospitalCode(),2); 
					dao.setProcInValue(nProcIndex2,  "storeId",     	vo.getStrStoreId(),3);
					dao.setProcInValue(nProcIndex2,  "requestNo",    	vo.getStrPhyStockNo(),4);
					dao.setProcInValue(nProcIndex2,  "pkKey",      		vo.getStrMultiRowPKKey1()[j],5);
					dao.setProcInValue(nProcIndex2,  "countedQty", 		vo.getStrMultiRowPKKey2()[j].split("\\^")[8],6);	
					dao.setProcInValue(nProcIndex2,  "finYear",     	vo.getStrCurrFY(),7);	
					dao.setProcInValue(nProcIndex2,  "tolLimit",   	    vo.getStrTolranceLimit(),8); 
					dao.setProcInValue(nProcIndex2,  "draftSaveFlag",   vo.getStrDraftFlg(),9); 
					dao.setProcInValue(nProcIndex2,  "modifyFlag",   	vo.getStrModifyFlg(),10); 
					dao.setProcInValue(nProcIndex2,  "newItemFlag", 	vo.getStrMultiNewItemFlg()[j],11); 
					dao.setProcInValue(nProcIndex2,  "expiryDate",      vo.getStrMultiRowPKKey2()[j].split("\\^")[9],12);
					dao.setProcInValue(nProcIndex2,  "manufDate",    	vo.getStrMultiRowPKKey2()[j].split("\\^")[10],13);				
					dao.setProcInValue(nProcIndex2,  "manufId",      	vo.getStrMultiRowPKKey2()[j].split("\\^")[4],14);
					dao.setProcInValue(nProcIndex2,  "rate", 	        vo.getStrMultiRowPKKey2()[j].split("\\^")[0],15);	
					dao.setProcInValue(nProcIndex2,  "rateUnitId",     	vo.getStrMultiRowPKKey2()[j].split("\\^")[1],16);	
					dao.setProcInValue(nProcIndex2,  "tenderNo",   	    vo.getStrMultiRowPKKey2()[j].split("\\^")[6],17); 
					dao.setProcInValue(nProcIndex2,  "remarks",         vo.getStrMultiRowPKKey2()[j].split("\\^")[7],18); 
					dao.setProcInValue(nProcIndex2,  "seatid",   	    vo.getStrSeatId(),19); 
					dao.setProcInValue(nProcIndex2,  "itemcatno",   	vo.getStrCatcode(),20);
					dao.setProcOutValue(nProcIndex2, "err",       		1,21); 
					dao.execute(nProcIndex2, 1);
					//dao.executeProcedureByPosition(nProcIndex2);
			    	}
				}		
			}		
		    	
	    	strProcName4 = "{call PKG_MMS_DML.dml_physical_stock_dtl(?,?,?,?,?,  ?,?,?,?,? , ?,?)}"; // 12
			nProcIndex4  = dao.setProcedure(strProcName4);			
			dao.setProcInValue(nProcIndex4,  "modval",   		"1",1); 
			dao.setProcInValue(nProcIndex4,  "hosp_code", 		vo.getStrHospitalCode(),2); 
			dao.setProcInValue(nProcIndex4,  "storeId",     	vo.getStrStoreId(),3);
			dao.setProcInValue(nProcIndex4,  "requestNo",    	vo.getStrPhyStockNo(),4);
			dao.setProcInValue(nProcIndex4,  "finYear",      	vo.getStrCurrFY(),5);
			dao.setProcInValue(nProcIndex4,  "tolLimit", 		vo.getStrTolranceLimit(),6);	
			dao.setProcInValue(nProcIndex4,  "draftSaveFlag",   vo.getStrDraftFlg(),7);	
			dao.setProcInValue(nProcIndex4,  "modifyFlag",   	vo.getStrModifyFlg(),8); 
			dao.setProcInValue(nProcIndex4,  "remarks",   		vo.getStrRemarks(),9); 
			dao.setProcInValue(nProcIndex4,  "seatid",   	    vo.getStrSeatId(),10);
			dao.setProcInValue(nProcIndex4,  "itemcatno",   	vo.getStrCatcode(),11);
			dao.setProcOutValue(nProcIndex4, "err",       		1,12); 
			
			dao.execute(nProcIndex4, 1);
			//dao.executeProcedureByPosition(nProcIndex4);
		    		    
	        dao.fire();

			

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> PhysicalNewStockVerfTransDAO.TOBEVERIFY()-->"+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}
	}
	
	/**
	 * INSERT method is used to insert value in two table HSTT_BREAKAGE_DTL &
	 * HSTT_BREAKAGE_ITEM_DTL.
	 * 
	 * @param vo
	 *            the vo
	 */
	
	
	public synchronized static void STOCKUPDATECANCEL(PhysicalNewStockVerfTransVO vo) 
	{
		HisDAO dao = null;
		String[] temp2 = null;
		String strProcName4 = "";
		int nProcIndex4 = 0;		
		try 
		{
			temp2 = vo.getStrStoreName().replace('^', '#').split("#");
			vo.setStrStoreId(temp2[0]);
			vo.setStrTolranceLimit(temp2[2]);
			vo.setStrCurrFY(temp2[3]);		

			dao = new HisDAO("MMSModule", "PhysicalNewStockVerfTransDAO.MODIFY()");
			vo.setStrPhyStockNo(vo.getStrRequestDtls().split("\\$")[0]);					 

		    strProcName4 = "{call PKG_MMS_DML.dml_physical_stock_dtl(?,?,?,?,?,  ?,?,?,?,? , ?,?)}"; // 12
		  
		    if(vo.getStrStockUpdateFlg().equals("1")) 
		    {		    	
				nProcIndex4  = dao.setProcedure(strProcName4);
	
				dao.setProcInValue(nProcIndex4,  "modval",   		"2",1); 
				dao.setProcInValue(nProcIndex4,  "hosp_code", 		vo.getStrHospitalCode(),2); 
				dao.setProcInValue(nProcIndex4,  "storeId",     	vo.getStrStoreId(),3);
				dao.setProcInValue(nProcIndex4,  "requestNo",    	vo.getStrPhyStockNo(),4);
				dao.setProcInValue(nProcIndex4,  "finYear",      	vo.getStrCurrFY(),5);
				dao.setProcInValue(nProcIndex4,  "tolLimit", 		vo.getStrTolranceLimit(),6);	
				dao.setProcInValue(nProcIndex4,  "draftSaveFlag",   vo.getStrDraftFlg(),7);	
				dao.setProcInValue(nProcIndex4,  "modifyFlag",   	vo.getStrModifyFlg(),8); 
				dao.setProcInValue(nProcIndex4,  "remarks",   		vo.getStrRemarks(),9); 
				dao.setProcInValue(nProcIndex4,  "seatid",   	    vo.getStrSeatId(),10);
				dao.setProcInValue(nProcIndex4,  "itemcatno",   	vo.getStrCategorycode(),11);
				dao.setProcOutValue(nProcIndex4, "err",       		1,12); 
				//System.out.println("itemcatno"+vo.getStrCatcode());
				//System.out.println("cat"+vo.getStrCategorycode());
				//System.out.println("vo.getStrHospitalCode()"+vo.getStrHospitalCode()+"\nvo.getStrStoreId()"+vo.getStrStoreId()+"\nvo.getStrPhyStockNo()"+vo.getStrPhyStockNo());
				//System.out.println("vo.getStrCurrFY()"+vo.getStrCurrFY()+"\nvo.getStrTolranceLimit()"+vo.getStrTolranceLimit()+"\nvo.getStrDraftFlg()"+vo.getStrDraftFlg());
				//System.out.println("vo.getStrRemarks()"+vo.getStrRemarks()+"\nvo.getStrSeatId()"+vo.getStrSeatId());
				//System.out.println();
				dao.execute(nProcIndex4, 1);
		    }
		    else
		    {		    	
				nProcIndex4  = dao.setProcedure(strProcName4);	
				dao.setProcInValue(nProcIndex4,  "modval",   		"4",1); 
				dao.setProcInValue(nProcIndex4,  "hosp_code", 		vo.getStrHospitalCode(),2); 
				dao.setProcInValue(nProcIndex4,  "storeId",     	vo.getStrStoreId(),3);
				dao.setProcInValue(nProcIndex4,  "requestNo",    	vo.getStrPhyStockNo(),4);
				dao.setProcInValue(nProcIndex4,  "finYear",      	vo.getStrCurrFY(),5);
				dao.setProcInValue(nProcIndex4,  "tolLimit", 		vo.getStrTolranceLimit(),6);	
				dao.setProcInValue(nProcIndex4,  "draftSaveFlag",   vo.getStrDraftFlg(),7);	
				dao.setProcInValue(nProcIndex4,  "modifyFlag",   	vo.getStrModifyFlg(),8); 
				dao.setProcInValue(nProcIndex4,  "remarks",   		vo.getStrRemarks(),9); 
				dao.setProcInValue(nProcIndex4,  "seatid",   	    vo.getStrSeatId(),10);
				dao.setProcInValue(nProcIndex4,  "itemcatno",   	vo.getStrCatcode(),11);
				dao.setProcOutValue(nProcIndex4, "err",       		1,12); 
				
				dao.execute(nProcIndex4, 1);
		    }
	        dao.fire();

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> PhysicalNewStockVerfTransDAO.INSERT()-->"+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}
	}
	public synchronized static void MODIFY(PhysicalNewStockVerfTransVO vo) 
	{
		HisDAO dao = null;
		String[] temp2 = null;
		
		String strProcName1 = "",strProcName2 = "",strProcName4 = "",strProcName5 = "";
		int nProcIndex1 = 0,nProcIndex2 = 0,nProcIndex4 = 0,nProcIndex5 = 0;
		
		try 
		{
			temp2 = vo.getStrStoreName().replace('^', '#').split("#");
			vo.setStrStoreId(temp2[0]);
			vo.setStrTolranceLimit(temp2[2]);
			vo.setStrCurrFY(temp2[3]);		

			dao = new HisDAO("MMSModule", "PhysicalNewStockVerfTransDAO.MODIFY()");
			vo.setStrPhyStockNo(vo.getStrRequestDtls().split("\\$")[0]);
			 
			strProcName1 = "{call PKG_MMS_DML.dml_physical_stock_item_dtl(?,?,?,?,?,  ?,?,?,?,? , ?,?,?,?,?,  ?,?,?,?,?, ?)}"; // 21
			//System.out.println("vo.getStrVerifyCountedQty().length"+vo.getStrVerifyCountedQty().length);
			for(int i=0;i<vo.getStrVerifyCountedQty().length;i++)
			{
				nProcIndex1  = dao.setProcedure(strProcName1);
				dao.setProcInValue(nProcIndex1,  "modval",   		"1",1); 
				dao.setProcInValue(nProcIndex1,  "hosp_code", 		vo.getStrHospitalCode(),2); 
				dao.setProcInValue(nProcIndex1,  "storeId",     	vo.getStrStoreId(),3);
				dao.setProcInValue(nProcIndex1,  "requestNo",    	vo.getStrPhyStockNo(),4);
				 /*
                   HSTNUM_STORE_ID, HSTNUM_ITEM_ID , HSTNUM_ITEMBRAND_ID, HSTSTR_BATCH_NO , HSTNUM_STOCK_STATUS_CODE
                */
				String hiddenValue=vo.getStrHiddenValue()[i]+"^000";
				dao.setProcInValue(nProcIndex1,  "pkKey",      		hiddenValue,5);
				dao.setProcInValue(nProcIndex1,  "countedQty", 		vo.getStrVerifyCountedQty()[i],6);	
				dao.setProcInValue(nProcIndex1,  "finYear",     	vo.getStrCurrFY(),7);	
				dao.setProcInValue(nProcIndex1,  "tolLimit",   	    vo.getStrTolranceLimit(),8); 
				dao.setProcInValue(nProcIndex1,  "draftSaveFlag",   vo.getStrDraftFlg(),9); 
				dao.setProcInValue(nProcIndex1,  "modifyFlag",   	vo.getStrModifyFlg(),10); 
				dao.setProcInValue(nProcIndex1,  "newItemFlag", 	vo.getStrNewItemFlg()[i],11); 
				dao.setProcInValue(nProcIndex1,  "expiryDate",      vo.getStrMultiExpiryDate()[i],12);
				dao.setProcInValue(nProcIndex1,  "manufDate",    	vo.getStrMultiMfgDate()[i],13);
				dao.setProcInValue(nProcIndex1,  "manufId",      	vo.getStrMultiSupplierId()[i],14);
				dao.setProcInValue(nProcIndex1,  "rate", 	        "1",15);	
				dao.setProcInValue(nProcIndex1,  "rateUnitId",     	vo.getStrMultiRateUnitId()[i],16);	
				dao.setProcInValue(nProcIndex1,  "tenderNo",   	    "123",17); 
				dao.setProcInValue(nProcIndex1,  "remarks",         vo.getStrMultiRemarks()[i],18); 
				dao.setProcInValue(nProcIndex1,  "seatid",   	    vo.getStrSeatId(),19);
				dao.setProcInValue(nProcIndex1,  "itemcatno",   	vo.getStrCatcode(),20);
				dao.setProcOutValue(nProcIndex1, "err",       		1,21); 
				dao.execute(nProcIndex1, 1);
				//System.out.println("vo.getStrHospitalCode()"+vo.getStrHospitalCode()+"\nvo.getStrStoreId()"+vo.getStrStoreId()+"\nvo.getStrPhyStockNo()"+vo.getStrPhyStockNo());
				//System.out.println("hiddenValue"+hiddenValue+"\nvo.getStrVerifyCountedQty()[i]"+vo.getStrVerifyCountedQty()[i]+"\nvo.getStrCurrFY()"+vo.getStrCurrFY()+"\nvo.getStrTolranceLimit()"+vo.getStrTolranceLimit());
				//System.out.println("vo.getStrDraftFlg()"+vo.getStrDraftFlg()+"\nvo.getStrModifyFlg()"+vo.getStrModifyFlg()+"\nvo.getStrMultiExpiryDate()[i]"+vo.getStrMultiExpiryDate()[i]+"\nvo.getStrMultiMfgDate()[i]"+vo.getStrMultiMfgDate()[i]+"\nvo.getStrMultiSupplierId()[i]"+vo.getStrMultiSupplierId()[i]);
				////System.out.println("vo.getStrRateWithBaseValue()[i]"+vo.getStrRateWithBaseValue()[i]+"\nvo.getStrMultiRateUnitId()[i]"+vo.getStrMultiRateUnitId()[i]+"\nvo.getStrMultiTenderNo()[i]"+vo.getStrMultiTenderNo()[i]);
				//System.out.println("vo.getStrMultiRemarks()[i]"+vo.getStrMultiRemarks()[i]+" vo.getStrSeatId()"+ vo.getStrSeatId());
				//System.out.println("vo.getStrCatcode()"+vo.getStrCatcode());
				//System.out.println();
				
			}
			strProcName2 = "{call PKG_MMS_DML.dml_physical_stock_item_dtl(?,?,?,?,?,  ?,?,?,?,? , ?,?,?,?,?,  ?,?,?,?,? ,?)}"; // 21
		
			if(vo.getStrMultiRowPKKey1().length>0)
			{	
			    for(int j=0;j<vo.getStrMultiRowPKKey1().length;j++)
				{
			    	if(vo.getStrMultiRowPKKey1()[j].length()>0 && vo.getStrMultiNewItemFlg()[j].endsWith("1"))
			    	{	
					 //       0           63000^0^1         4
					 //  Rate Base   ^   Rate Unit ^    Supplier ID
					//       5                  6           7 
					// ^ Stock Status     ^  Tender    ^  Remarks
					//       8            9          10
					// ^ Counted Qty ^ Exp Date ^ Mfg date
					
					nProcIndex2  = dao.setProcedure(strProcName2);

					dao.setProcInValue(nProcIndex2,  "modval",   		"1",1); 
					dao.setProcInValue(nProcIndex2,  "hosp_code", 		vo.getStrHospitalCode(),2); 
					dao.setProcInValue(nProcIndex2,  "storeId",     	vo.getStrStoreId(),3);
					dao.setProcInValue(nProcIndex2,  "requestNo",    	vo.getStrPhyStockNo(),4);
					dao.setProcInValue(nProcIndex2,  "pkKey",      		vo.getStrMultiRowPKKey1()[j],5);
					dao.setProcInValue(nProcIndex2,  "countedQty", 		vo.getStrMultiRowPKKey2()[j].split("\\^")[8],6);	
					dao.setProcInValue(nProcIndex2,  "finYear",     	vo.getStrCurrFY(),7);	
					dao.setProcInValue(nProcIndex2,  "tolLimit",   	    vo.getStrTolranceLimit(),8); 
					dao.setProcInValue(nProcIndex2,  "draftSaveFlag",   vo.getStrDraftFlg(),9); 
					dao.setProcInValue(nProcIndex2,  "modifyFlag",   	vo.getStrModifyFlg(),10); 
					dao.setProcInValue(nProcIndex2,  "newItemFlag", 	vo.getStrMultiNewItemFlg()[j],11); 
					dao.setProcInValue(nProcIndex2,  "expiryDate",      vo.getStrMultiRowPKKey2()[j].split("\\^")[9],12);
					dao.setProcInValue(nProcIndex2,  "manufDate",    	vo.getStrMultiRowPKKey2()[j].split("\\^")[10],13);				
					dao.setProcInValue(nProcIndex2,  "manufId",      	vo.getStrMultiRowPKKey2()[j].split("\\^")[4],14);
					dao.setProcInValue(nProcIndex2,  "rate", 	        vo.getStrMultiRowPKKey2()[j].split("\\^")[0],15);	
					dao.setProcInValue(nProcIndex2,  "rateUnitId",     	vo.getStrMultiRowPKKey2()[j].split("\\^")[1],16);	
					dao.setProcInValue(nProcIndex2,  "tenderNo",   	    vo.getStrMultiRowPKKey2()[j].split("\\^")[6],17); 
					dao.setProcInValue(nProcIndex2,  "remarks",         vo.getStrMultiRowPKKey2()[j].split("\\^")[7],18); 
					dao.setProcInValue(nProcIndex2,  "seatid",   	    vo.getStrSeatId(),19);
					dao.setProcInValue(nProcIndex2,  "itemcatno",   	vo.getStrCatcode(),20);
					dao.setProcOutValue(nProcIndex2, "err",       		1,21); 
					dao.execute(nProcIndex2, 1);
			    	}
				}		
			}			
		    	
		    	strProcName4 = "{call PKG_MMS_DML.dml_physical_stock_dtl(?,?,?,?,?,  ?,?,?,?,? , ?,?)}"; // 11
				nProcIndex4  = dao.setProcedure(strProcName4);
	
				dao.setProcInValue(nProcIndex4,  "modval",   		"3",1); 
				dao.setProcInValue(nProcIndex4,  "hosp_code", 		vo.getStrHospitalCode(),2); 
				dao.setProcInValue(nProcIndex4,  "storeId",     	vo.getStrStoreId(),3);
				dao.setProcInValue(nProcIndex4,  "requestNo",    	vo.getStrPhyStockNo(),4);
				dao.setProcInValue(nProcIndex4,  "finYear",      	vo.getStrCurrFY(),5);
				dao.setProcInValue(nProcIndex4,  "tolLimit", 		vo.getStrTolranceLimit(),6);	
				dao.setProcInValue(nProcIndex4,  "draftSaveFlag",   vo.getStrDraftFlg(),7);	
				dao.setProcInValue(nProcIndex4,  "modifyFlag",   	vo.getStrModifyFlg(),8); 
				dao.setProcInValue(nProcIndex4,  "remarks",   		vo.getStrRemarks(),9); 
				dao.setProcInValue(nProcIndex4,  "seatid",   	    vo.getStrSeatId(),10);
				dao.setProcInValue(nProcIndex4,  "itemcatno",   	vo.getStrCatcode(),11);
				dao.setProcOutValue(nProcIndex4, "err",       		1,12); 
				//System.out.println("vo.getStrHospitalCode()"+vo.getStrHospitalCode()+"\nvo.getStrStoreId()"+vo.getStrStoreId()+"\nvo.getStrPhyStockNo()"+vo.getStrPhyStockNo());
				//System.out.println("vo.getStrCurrFY()"+vo.getStrCurrFY()+"\nvo.getStrTolranceLimit()"+vo.getStrTolranceLimit()+"\nvo.getStrDraftFlg()"+vo.getStrDraftFlg());
				//System.out.println("vo.getStrModifyFlg()"+vo.getStrModifyFlg()+"\nvo.getStrRemarks()"+vo.getStrRemarks()+"\n"+vo.getStrSeatId());
				dao.execute(nProcIndex4, 1);				
				
				strProcName5 = "{call PKG_MMS_DML.dml_physical_stock_dtl(?,?,?,?,?,  ?,?,?,?,? , ?,?)}"; // 12
				nProcIndex5  = dao.setProcedure(strProcName5);
	
				dao.setProcInValue(nProcIndex5,  "modval",   		"1",1); 
				dao.setProcInValue(nProcIndex5,  "hosp_code", 		vo.getStrHospitalCode(),2); 
				dao.setProcInValue(nProcIndex5,  "storeId",     	vo.getStrStoreId(),3);
				dao.setProcInValue(nProcIndex5,  "requestNo",    	vo.getStrPhyStockNo(),4);
				dao.setProcInValue(nProcIndex5,  "finYear",      	vo.getStrCurrFY(),5);
				dao.setProcInValue(nProcIndex5,  "tolLimit", 		vo.getStrTolranceLimit(),6);	
				dao.setProcInValue(nProcIndex5,  "draftSaveFlag",   vo.getStrDraftFlg(),7);	
				dao.setProcInValue(nProcIndex5,  "modifyFlag",   	vo.getStrModifyFlg(),8); 
				dao.setProcInValue(nProcIndex5,  "remarks",   		vo.getStrRemarks(),9); 
				dao.setProcInValue(nProcIndex5,  "seatid",   	    vo.getStrSeatId(),10);
				dao.setProcInValue(nProcIndex5,  "itemcatno",   	vo.getStrCatcode(),11);
				dao.setProcOutValue(nProcIndex5, "err",       		1,12); 
				//System.out.println("itemcatno"+vo.getStrCatcode());
				//System.out.println("vo.getStrHospitalCode()"+vo.getStrHospitalCode()+"\n"+vo.getStrStoreId()+"\n"+vo.getStrPhyStockNo()+"\nvo.getStrCurrFY()"+vo.getStrCurrFY());
				//System.out.println("vo.getStrTolranceLimit()"+vo.getStrTolranceLimit()+"\nvo.getStrDraftFlg()"+vo.getStrDraftFlg()+"\nvo.getStrModifyFlg()"+vo.getStrModifyFlg());
				//System.out.println("vo.getStrRemarks()"+vo.getStrRemarks()+"\nvo.getStrSeatId()"+vo.getStrSeatId());
				dao.execute(nProcIndex5, 1);
		    
	        dao.fire();
	        
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> PhysicalNewStockVerfTransDAO.INSERT()-->"+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}
	}
	
	public synchronized static void DeleteRecord(PhysicalNewStockVerfTransVO vo) 
	{
		HisDAO dao = null;
		String[] temp2 = null;
		
		String strProcName2 = "";
		int nProcIndex2 = 0;
		
		try 
		{
			temp2 = vo.getStrStoreName().replace('^', '#').split("#");
			vo.setStrStoreId(temp2[0]);
			vo.setStrTolranceLimit(temp2[2]);
			vo.setStrCurrFY(temp2[3]);		
			dao = new HisDAO("MMSModule", "PhysicalNewStockVerfTransDAO.DeleteRecord()");
			strProcName2 = "{call PKG_MMS_DML.dml_physical_stock_item_dtl(?,?,?,?,?,  ?,?,?,?,? , ?,?,?,?,?,  ?,?,?,?,? ,?)}"; // 20							
			nProcIndex2  = dao.setProcedure(strProcName2);			dao.setProcInValue(nProcIndex2,  "modval",   		"2",1); 
			dao.setProcInValue(nProcIndex2,  "hosp_code", 		vo.getStrHospitalCode(),2); 
			dao.setProcInValue(nProcIndex2,  "storeId",     	vo.getStrStoreId(),3);
			dao.setProcInValue(nProcIndex2,  "requestNo",    	vo.getStrPhysicalStockNo(),4);
			dao.setProcInValue(nProcIndex2,  "pkKey",      		vo.getStrPKey(),5);
			dao.setProcInValue(nProcIndex2,  "countedQty", 		"0",6);	
			dao.setProcInValue(nProcIndex2,  "finYear",     	"0",7);	
			dao.setProcInValue(nProcIndex2,  "tolLimit",   	    "0",8); 
			dao.setProcInValue(nProcIndex2,  "draftSaveFlag",   "0",9); 
			dao.setProcInValue(nProcIndex2,  "modifyFlag",   	"0",10); 
			dao.setProcInValue(nProcIndex2,  "newItemFlag", 	"0",11); 
			dao.setProcInValue(nProcIndex2,  "expiryDate",      "0",12);
			dao.setProcInValue(nProcIndex2,  "manufDate",    	"0",13);				
			dao.setProcInValue(nProcIndex2,  "manufId",      	"0",14);
			dao.setProcInValue(nProcIndex2,  "rate", 	        "0",15);	
			dao.setProcInValue(nProcIndex2,  "rateUnitId",     	"0",16);	
			dao.setProcInValue(nProcIndex2,  "tenderNo",   	    "0",17); 
			dao.setProcInValue(nProcIndex2,  "remarks",         "0",18); 
			dao.setProcInValue(nProcIndex2,  "seatid",   	    vo.getStrSeatId(),19); 	
			dao.setProcInValue(nProcIndex2,  "itemcatno",   	vo.getStrCatcode(),20);
			dao.setProcOutValue(nProcIndex2, "err",       		1,21); 
			dao.execute(nProcIndex2, 1);
			    
		    	
		    	
		    
	        dao.fire();

			

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> PhysicalNewStockVerfTransDAO.DeleteRecord()-->"+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}
	}
	
	
	/**
	 * 
	 * method name : getIndentDetailsView
	 * 
	 * @param vo
	 */

	public static void getIndentDetailsView(PhysicalNewStockVerfTransVO vo) {
		WebRowSet wb = null;
		HisDAO daoObj = null;
		String strProcName = "";
		int nProcIndex = 0;
		String strErr = "";
		daoObj = new HisDAO("MMS Transactions", "PhysicalNewStockVerfTransDAO");
		try {

			strProcName = "{call PKG_MMS_VIEW.Get_Indent_Details(?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "storeId", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "reqNo", vo.getStrReqNo());
			daoObj.setProcInValue(nProcIndex, "reqTypeId", vo.getStrReqTypeId());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null) {
				strErr = "";
			}

			if (strErr.equals("")) 
			{
				wb = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				
				vo.setStrIndentDetailsWs(wb);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			vo.setStrMsgString("--> PhysicalNewStockVerfTransDAO.getIndentDetails()-->" + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
			}
			daoObj = null;
		}

	}

	/**
	 * This Function is used to get Store Name by Passing variable.
	 * 
	 * @param vo the vo
	 */
	public static void callingFunctionIndentName(PhysicalNewStockVerfTransVO vo) 
	{
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		try {
			dao = new HisDAO("MMSModule", "PhysicalNewStockVerfTransDAO");
			funcIndex = dao.setFunction("{? = call MMS_MST.get_indentType_Name(?,?,?)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, "1");
			dao.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4, vo.getStrReqTypeId());
			dao.setFuncOutValue(funcIndex, 1);
			// Execute Function
			dao.executeFunction(funcIndex);
			retVal = dao.getFuncString(funcIndex);

			if (retVal != null) {
				vo.setStrIndentName(retVal);
			} else {
				retVal = "-----";
				vo.setStrIndentName(retVal);
			}

		} catch (Exception e) {
			vo.setStrMsgString("PhysicalNewStockVerfTransDAO.callingFunctionIndentName() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * This Function is used to get Store Name by Passing variable.
	 * 
	 * @param vo the vo
	 */
	public static void getTolranceLimit(PhysicalNewStockVerfTransVO vo) 	
	{
		String retVal = null;
		int funcIndex = 0;
		HisDAO dao = null;
		try {
			dao = new HisDAO("MMSModule", "PhysicalNewStockVerfTransDAO");
			funcIndex = dao.setFunction("{? = call MMS_MST.config_dtl(?,?,?)}");
			// Set Value
			dao.setFuncInValue(funcIndex, 2, "1");
			dao.setFuncInValue(funcIndex, 3, vo.getStrHospitalCode());
			dao.setFuncInValue(funcIndex, 4, "PHY_TOLRENCE_LIMIT");
			dao.setFuncOutValue(funcIndex, 1);
			// Execute Function
			dao.executeFunction(funcIndex);
			retVal = dao.getFuncString(funcIndex);

			if (retVal != null) 
			{
				vo.setStrTolranceLimit(retVal);
			} 
			else 
			{
				retVal = "--";
				vo.setStrTolranceLimit(retVal);
			}

		} catch (Exception e) {
			vo.setStrMsgString("PhysicalNewStockVerfTransDAO.getTolranceLimit() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * Insert into Table DML_APPROVAL_DTL.
	 * 
	 * @param vo the vo
	 */
	public static void insertForApproval(PhysicalNewStockVerfTransVO vo) 
	{		
		int  nProcIndex1 = 0, nProcIndex2 = 0;	
		int funcIndex = 0;
		String appNo = "";
		HisDAO dao = null;		
		try {

			dao = new HisDAO("MMSModule", "PhysicalNewStockVerfTransDAO");
			/*********************** APPROVAL NO GENERATION **************************/
			if (vo.getStrReApprovalFlag().equals("1")) 
			{
				appNo = vo.getStrApprovalNo();
			} 
			else 
			{
				/*********************** APPROVAL NO GENERATION **************************/
				funcIndex = dao.setFunction("{? = call MMS_MST.generate_approval_no(?,?,?)}");
				// Set Value
				dao.setFuncInValue(funcIndex, 2, vo.getStrHospitalCode());
				dao.setFuncInValue(funcIndex, 3, vo.getStrReqNo());
				dao.setFuncInValue(funcIndex, 4, vo.getStrStoreId());
				dao.setFuncOutValue(funcIndex, 1);
				// Execute Function
				dao.executeFunction(funcIndex);
				appNo = dao.getFuncString(funcIndex);
			}

			
			/******************************** [ PPROCEDURE TWO ] *******************************/
			if (vo.getStrReApprovalFlag().equals("1")) {

				String strProcName2 = "{call PKG_MMS_DML.dml_approval_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // 13
				nProcIndex2 = dao.setProcedure(strProcName2);
				dao.setProcInValue(nProcIndex2, "modval", "2");
				dao.setProcInValue(nProcIndex2, "approvalNo", appNo);
				dao.setProcInValue(nProcIndex2, "strid", vo.getStrStoreId());
				dao.setProcInValue(nProcIndex2, "reqno", vo.getStrReqNo());
				dao.setProcInValue(nProcIndex2, "userId", vo.getStrUserId());
				dao.setProcInValue(nProcIndex2, "userLevel", vo.getStrUserLevel());
				dao.setProcInValue(nProcIndex2, "levelType", vo.getStrLevelType());
				dao.setProcInValue(nProcIndex2, "approvalStatus", vo.getStrApprovalType());
				dao.setProcInValue(nProcIndex2, "reApprovalFlag", vo.getStrReApprovalFlag());
				dao.setProcInValue(nProcIndex2, "ipaddress", vo.getStrIPAdd());
				dao.setProcInValue(nProcIndex2, "remarks", vo.getStrRemarks());
				dao.setProcInValue(nProcIndex2, "hosp_code", vo.getStrHospitalCode());
				dao.setProcOutValue(nProcIndex2, "err", 1);
				dao.execute(nProcIndex2, 1);
			}

			String strProcName1 = "{call PKG_MMS_DML.dml_approval_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // 13

			nProcIndex1 = dao.setProcedure(strProcName1);
			dao.setProcInValue(nProcIndex1, "modval", "1");
			dao.setProcInValue(nProcIndex1, "approvalNo", appNo);
			dao.setProcInValue(nProcIndex1, "strid", vo.getStrStoreId());
			dao.setProcInValue(nProcIndex1, "reqno", vo.getStrReqNo());
			dao.setProcInValue(nProcIndex1, "userId", vo.getStrUserId());
			dao.setProcInValue(nProcIndex1, "userLevel", vo.getStrUserLevel());
			dao.setProcInValue(nProcIndex1, "levelType", vo.getStrLevelType());
			dao.setProcInValue(nProcIndex1, "approvalStatus", vo.getStrApprovalType());
			dao.setProcInValue(nProcIndex1, "reApprovalFlag", vo.getStrReApprovalFlag());
			dao.setProcInValue(nProcIndex1, "ipaddress", vo.getStrIPAdd());
			dao.setProcInValue(nProcIndex1, "remarks", vo.getStrRemarks());
			dao.setProcInValue(nProcIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcOutValue(nProcIndex1, "err", 1);
			dao.execute(nProcIndex1, 1);

			dao.fire();

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> PhysicalNewStockVerfTransDAO.insertForApproval()-->" + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
			}
			dao = null;
		}

	}

	
	
	/**
	 * Gets the programme combo.
	 * 
	 * @param vo
	 *            the vo
	 * @return the programme combo
	 */
	public static void ProgrammeCombo(PhysicalNewStockVerfTransVO vo) {

		/*String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "",storeId="",str="";
		WebRowSet wb = null;
		HisUtil hisutil = null;
		try {
			//dao = new HisDAO("mms", "PhysicalNewStockVerfTransDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_programme_list(?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			if(vo.getStrStoreId().length()>9)
			{
				storeId=vo.getStrStoreId().split("\\^")[0];
			}
			
			else
			{
				storeId=vo.getStrStoreId();
			}
			
			dao.setProcInValue(nprocIndex, "modeval", "2");
			dao.setProcInValue(nprocIndex, "storeid", (storeId==null||storeId.equals(""))?"0":storeId);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "seatid", vo.getStrSeatId());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);

			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			str = "<option value='0'>DATA N/A</option>";
			if (wb != null) 
			{
				str = hisutil.getOptionValue(wb, "0", "0^All", true);				
			}
			vo.setStrProgNameComboWS(str);
		
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DrugInventoryTransDAO.getProgrammeCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}*/
	
	{

		String err = "";
		String proc_name1 = "{call PKG_MMS_VIEW.proc_programme_list(?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;
		String storeId="";

		try {
			if(vo.getStrStoreId().length()>9)
			{
				storeId=vo.getStrStoreId().split("\\^")[0];
			}
			
			else
			{
				storeId=vo.getStrStoreId();
			}

			hisutil = new HisUtil("mms", "PhysicalNewStockVerfTransDAO");
			dao = new HisDAO("mms",
					"PhysicalNewStockVerfTransDAO.getItemParameters(PhysicalNewStockVerfTransVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value			
			dao.setProcInValue(procIndex1, "modeval", "2");
			dao.setProcInValue(procIndex1, "storeid", (storeId==null||storeId.equals(""))?"0":storeId);
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(procIndex1, "seatid", "0");
			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object
			dao.executeProcedure(procIndex1);
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");
			str = "<option value='0'>DATA N/A</option>";
			if (ws != null) 
			{
				str = hisutil.getOptionValue(ws, "", "0^Select Value", true);				
			}
			vo.setStrProgNameComboWS(str);

		} catch (Exception e) {
			e.printStackTrace();

			vo.setStrMsgString("PhysicalNewStockVerfTrans.groupCombo() --> "
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
	public static void setItemCategCombo(PhysicalNewStockVerfTransVO _IssueDetailRptVO)
	{
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		
		try 
		{
				dao = new HisDAO("mms", "IssueDetailRptDAO");
				strproc_name = "{call pkg_mms_rpt.Rptm_item_category_list(?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				////System.out.println("modeval"+_IssueDetailRptVO.getStrMode()+"\n"+);
				dao.setProcInValue(nprocIndex, "modeval",_IssueDetailRptVO.getStrMode(),1);
				dao.setProcInValue(nprocIndex, "hosp_code", _IssueDetailRptVO.getStrHospCode(),2);
				dao.setProcInValue(nprocIndex, "storeId",_IssueDetailRptVO.getStrStoreId(),3);							
				dao.setProcOutValue(nprocIndex, "err", 1,4);
				dao.setProcOutValue(nprocIndex, "resultset", 2,5); 
				
				dao.executeProcedureByPosition(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				//System.out.println("wb"+wb.size());
				if (strerr.equals("")) 
				{
					_IssueDetailRptVO.setItemCategWS(wb);
             	} 
				else 
				{
					throw new Exception(strerr);
				}
		} 
		catch (Exception e) 
		{
			_IssueDetailRptVO.setStrMsgString("IssueDetailRptDAO.setItemCategCombo() --> "+ e.getMessage());
			_IssueDetailRptVO.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
				wb=null;
			}
		}	
	}	
	
	
}