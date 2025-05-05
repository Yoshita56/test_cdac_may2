package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.dao.DmlHsttPatEmpIssueDtlDAO;
import mms.dao.DmlHsttPatEmpIssueItemDtlDAO;
import mms.reports.vo.SupplierPerformanceDtailRptVO;
import mms.transactions.vo.IssueTransVO;

public class SupplierPerformanceDtailRptDAO 
{
	
	/**
	 * The following procedure is used to populate the value of Supplier Name
	 * combo using Pkg_Mms_View.proc_supplier_list procedure.
	 * 
	 * 
	 */

	public static void getSuppliedByList(SupplierPerformanceDtailRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "SupplierPerformanceDtailRptDAO");
			
			
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "1");
			dao.setProcInValue(nprocIndex, "catCode", "10");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			
			/* Start */
			dao.setProcInValue(nprocIndex, "branditem_id", vo.getStrSeatId());
			dao.setProcInValue(nprocIndex, "contractType", "0");
			/* End */
			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {
				 
				vo.setStrManufactureComboWS(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("SupplierPerformanceDtailRptDAO.getSuppliedByList() --> "
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
	 * The following procedure is used to populate the value of Group Name
	 * combo using Pkg_Mms_View.proc_supplier_list procedure.
	 * 
	 * 
	 */

	public static void GetGroupNameCombo(SupplierPerformanceDtailRptVO vo) {
		String err = "";
	
		String proc_name1 = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		HisUtil hisutil = null;
		String str = null;

		try {
			hisutil = new HisUtil("report", "SupplierPerformanceDtailRptDAO");
			dao = new HisDAO("mms",
					"SupplierPerformanceDtailRptDAO.GetGroupNameCombo(SupplierPerformanceDtailRptVO vo)");
			
			

			procIndex1 = dao.setProcedure(proc_name1);

			// set value

            dao.setProcInValue(procIndex1, "modeval", "2");
			
			dao.setProcInValue(procIndex1, "item_category", "10");
			
			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
			
			/*start*/
			dao.setProcInValue(procIndex1, "strPhyStockNo","");
			dao.setProcInValue(procIndex1, "strStoreId", "");
			/*end*/

			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";
			ws = dao.getWebRowSet(procIndex1, "RESULTSET");
			if (err.equals("")) {
				 
				vo.setStrGroupNameComboWS(ws);
			} else {
				throw new Exception(err);
			}
			
			
		
			
		} 
		catch (Exception e) 
		{
			vo
					.setStrMsgString("SupplierPerformanceDtailRptDAO.GetGroupNameCombo() --> "
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
	 * The following procedure is used to populate the value of ItemBrand Name
	 * combo using Pkg_Mms_View.proc_itembrand_list procedure.
	 * 
	 * 
	 */

	public static void getItemBrandName(SupplierPerformanceDtailRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "SupplierPerformanceDtailRptDAO");
			
			
			strproc_name = "{call PKG_MMS_VIEW.proc_itembrand_list(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "6");
			
			dao.setProcInValue(nprocIndex, "catCode", "10");
			dao.setProcInValue(nprocIndex, "item_id", "");
			
			if(vo.getStrGroupId()==null || vo.getStrGroupId()==""){
				dao.setProcInValue(nprocIndex, "grpId", "0");
			}else{
				dao.setProcInValue(nprocIndex, "grpId", vo.getStrGroupId());
			}
			
			dao.setProcInValue(nprocIndex, "subGrpId", "");
			dao.setProcInValue(nprocIndex, "setFlag", "");
			
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {
				 
				vo.setStrDrugNameComboWS(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("SupplierPerformanceDtailRptDAO.getItemBrandName() --> "
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
	 * The following procedure is used to populate the value of ItemBrand Name
	 * combo using Pkg_Mms_View.proc_itembrand_list procedure.
	 * 
	 * 
	 */

	public static void getPOCombo(SupplierPerformanceDtailRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "SupplierPerformanceDtailRptDAO");
			
			
			strproc_name = "{call PKG_MMS_VIEW.get_Sstt_Po_Dtl(?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nprocIndex, "modval", "1");
		    dao.setProcInValue(nprocIndex, "hoscode", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "supplierid",vo.getStrSupplierId());			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {
				 
				vo.setStrSupplierComboWS(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("SupplierPerformanceDtailRptDAO.getPOCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	public static void getPoDetails(SupplierPerformanceDtailRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "SupplierPerformanceDtailRptDAO");
			
			
			strproc_name = "{call PKG_MMS_RPT.Get_Po_Details(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			if(vo.getStrSupplierId().equals("0"))
			{	
			 dao.setProcInValue(nprocIndex, "modeval", "2");
			}
			else
			{
				 dao.setProcInValue(nprocIndex, "modeval", "1");
			}	
			 dao.setProcInValue(nprocIndex, "supplierId", vo.getStrSupplierId());
			 
			
			
			dao.setProcInValue(nprocIndex, "pono", "0");
			dao.setProcInValue(nprocIndex, "storeId", "0");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate());
			dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");
			
                vo.setStrPOWs(wb); 
				

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			vo.setStrMsgString("SupplierPerformanceDtailRptDAO.receiveInit() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	public static void getSupplierPODtlPopUp(SupplierPerformanceDtailRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "SupplierPerformanceDtailRptDAO");
			
			
			strproc_name = "{call PKG_MMS_RPT.Get_SuppPo_Details(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			if(vo.getStrSupplierId().equals("0"))
			{	
			 dao.setProcInValue(nprocIndex, "modeval", "2");
			}
			else
			{
				 dao.setProcInValue(nprocIndex, "modeval", "1");
			}	
			 dao.setProcInValue(nprocIndex, "supplierId", vo.getStrSupplierId());
			 
			
			
			dao.setProcInValue(nprocIndex, "pono", "0");
			dao.setProcInValue(nprocIndex, "storeId", "0");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate());
			dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");
			
                vo.setStrSupplierPODtlWs(wb); 
				

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			vo.setStrMsgString("SupplierPerformanceDtailRptDAO.getSupplierPODtlPopUp() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	
	
	public static void getSupplierPerformanceDtl(SupplierPerformanceDtailRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "SupplierPerformanceDtailRptDAO");
			
			
			strproc_name = "{call PKG_MMS_RPT.Get_Supplier_Performance_Dtl(?,?,?,?,?,?,?,?,?,?,?)}";   //11 variables
			nprocIndex = dao.setProcedure(strproc_name);
    		dao.setProcInValue(nprocIndex, "modeval", "2");
//    		//System.out.println("Supplier ID==>"+vo.getStrSupplierId());
//    		//System.out.println("Grp ID==>"+ vo.getStrGroupId());
//    		//System.out.println("DrugBrand  ID==>"+vo.getStrDrugId());    		    		
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());				
			dao.setProcInValue(nprocIndex, "supplierId", vo.getStrSupplierId());
			dao.setProcInValue(nprocIndex, "groupId", vo.getStrGroupId());
			dao.setProcInValue(nprocIndex, "itemId", vo.getStrDrugId());
			dao.setProcInValue(nprocIndex, "storeId", "0");
			dao.setProcInValue(nprocIndex, "poNo", vo.getStrPoNumber());			
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate());
			dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate());			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals(""))
			{

				wb = dao.getWebRowSet(nprocIndex, "resultset");
				////System.out.println("Screen TwoSixze ==>"+wb.size());
                vo.setStrScreentTwoWs(wb); 
				

			} else {
				throw new Exception(strerr);
			}

		}
		catch (Exception e) 
		
		{
			e.printStackTrace();
			vo.setStrMsgString("SupplierPerformanceDtailRptDAO.getSupplierPerformanceDtl() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getScreenTwo(SupplierPerformanceDtailRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "SupplierPerformanceDtailRptDAO");
			
			
			strproc_name = "{call PKG_MMS_RPT.Get_Supplier_Details(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			if(vo.getStrSupplierId().equals("0"))
			{	
			     dao.setProcInValue(nprocIndex, "modeval", "2");
			}
			else
			{
				 dao.setProcInValue(nprocIndex, "modeval", "1");
			}	
	
			////System.out.println("Supplier ID==>"+vo.getStrSupplierId());
			dao.setProcInValue(nprocIndex, "supplierId", vo.getStrSupplierId());
			 
			dao.setProcInValue(nprocIndex, "pono", "0");
			dao.setProcInValue(nprocIndex, "storeId", "0");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate());
			dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate());
			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");
			////System.out.println("Screen TwoSixze ==>"+wb.size());
                vo.setStrScreentTwoWs(wb); 
				

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			vo.setStrMsgString("SupplierPerformanceDtailRptDAO.getScreenTwo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	public static void getChallanDetails(SupplierPerformanceDtailRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "SupplierPerformanceDtailRptDAO");
			
			
			strproc_name = "{call PKG_MMS_RPT.proc_Get_Challan_Details(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			
			
			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "pono", vo.getStrPoNumber());
		    dao.setProcInValue(nprocIndex, "storeId", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate());
			dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate());
			dao.setProcInValue(nprocIndex, "supplierId", "0");
			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
                vo.setStrChallanWs(wb); 
				

			} else {
				throw new Exception(strerr);
			}

		} 
		catch (Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("SupplierPerformanceDtailRptDAO.receiveInit() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getChallanItemDtlPopUp(SupplierPerformanceDtailRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "SupplierPerformanceDtailRptDAO");
			
			
			strproc_name = "{call PKG_MMS_RPT.proc_Get_Challan_ItemDtl(?,?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			
			
			dao.setProcInValue(nprocIndex, "modeval", "1");
//			//System.out.println("Challan No==>"+vo.getStrChallanNo());
//			//System.out.println("PO No==>"+vo.getStrPoNumber());
//			//System.out.println("Store ID==>"+vo.getStrStoreId());
//			//System.out.println("Hosp Code==>"+vo.getStrHospitalCode());
			
			dao.setProcInValue(nprocIndex, "challanNo", vo.getStrChallanNo());
			dao.setProcInValue(nprocIndex, "poNo", vo.getStrPoNumber());
		    dao.setProcInValue(nprocIndex, "storeId", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate());
			dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate());
			dao.setProcInValue(nprocIndex, "supplierId", "0");
			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
                vo.setStrChallanItemDtlWs(wb); 
				

			} else {
				throw new Exception(strerr);
			}

		} 
		catch (Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("SupplierPerformanceDtailRptDAO.receiveInit() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	public static void getPOChallanDtlPopUp(SupplierPerformanceDtailRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "SupplierPerformanceDtailRptDAO");
			
			
			strproc_name = "{call PKG_MMS_RPT.proc_Get_POChallan_Dtl(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			
			
			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "pono", vo.getStrPoNumber());
			dao.setProcInValue(nprocIndex, "storeId", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate());
			dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate());
			dao.setProcInValue(nprocIndex, "supplierId", "0");
			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
                vo.setStrPOChallanDtlWs(wb); 
				

			} else {
				throw new Exception(strerr);
			}

		} 
		catch (Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("SupplierPerformanceDtailRptDAO.getPOChallanDtlPopUp() --> "
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
