package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.HelpDeskRptVO;

public class HelpDeskRptDAO 
{
	
	/**
	 * The following procedure is used to populate the value of Supplier Name
	 * combo using Pkg_Mms_View.proc_supplier_list procedure.
	 * 
	 * 
	 */
	//status name
	
	public static void getStatusName(HelpDeskRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "HelpDeskRptDAO");
			
			strproc_name = "{call PKG_MMS_RPT.proc_status_dtl(?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1");
			
			//dao.setProcInValue(nprocIndex, "seatid", vo.getStrSeatId());
			//dao.setProcInValue(nprocIndex, "catCode", "10");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			//dao.setProcInValue(nprocIndex, "storeid", "0");
			//dao.setProcInValue(nprocIndex, "storetype_id", "0");
			/* Start */
			//dao.setProcInValue(nprocIndex, "branditem_id", "0");
			//dao.setProcInValue(nprocIndex, "contractType", "0");
			/* End */
			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {
				 
				vo.setStrStatusCmbWs(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("HelpDeskRptDAO.getDeptName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	// department list 
	public static void getDeptName(HelpDeskRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "HelpDeskRptDAO");
			
			strproc_name = "{call PKG_MMS_RPT.proc_dept_list_dtl(?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1");
			
			dao.setProcInValue(nprocIndex, "seatid", vo.getStrSeatId());
			//dao.setProcInValue(nprocIndex, "catCode", "10");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			//dao.setProcInValue(nprocIndex, "storeid", "0");
			//dao.setProcInValue(nprocIndex, "storetype_id", "0");
			/* Start */
			//dao.setProcInValue(nprocIndex, "branditem_id", "0");
			//dao.setProcInValue(nprocIndex, "contractType", "0");
			/* End */
			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {
				 
				vo.setStrDeptCmbWs(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("HelpDeskRptDAO.getDeptName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	
	
	//menu list
	public static void getMenuName(HelpDeskRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "HelpDeskRptDAO");
			
			strproc_name = "{call PKG_MMS_RPT.proc_menu_list_dtl(?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1");
			
			//dao.setProcInValue(nprocIndex, "seatid", vo.getStrSeatId());
			//dao.setProcInValue(nprocIndex, "catCode", "10");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			//dao.setProcInValue(nprocIndex, "storeid", "0");
			//dao.setProcInValue(nprocIndex, "storetype_id", "0");
			/* Start */
			//dao.setProcInValue(nprocIndex, "branditem_id", "0");
			//dao.setProcInValue(nprocIndex, "contractType", "0");
			/* End */
			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {
				 
				vo.setStrMenuCmbWs(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("HelpDeskRptDAO.getMenuName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
// supplied by list
	
	public static void getSuppliedByList(HelpDeskRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "HelpDeskRptDAO");
			
			strproc_name = "{call PKG_MMS_VIEW.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "5");
			dao.setProcInValue(nprocIndex, "seatid", vo.getStrSeatId());
			//dao.setProcInValue(nprocIndex, "catCode", "10");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "storeid", "0");
			dao.setProcInValue(nprocIndex, "storetype_id", "0");
			/* Start */
			//dao.setProcInValue(nprocIndex, "branditem_id", "0");
			//dao.setProcInValue(nprocIndex, "contractType", "0");
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
			vo.setStrMsgString("HelpDeskRptDAO.getSuppliedByList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	
	
	
	
	
	
	public static void getScreenTwo(HelpDeskRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "HelpDeskRptDAO");
			
			strproc_name = "{call PKG_MMS_RPT.Rptm_HelpDeskDtl(?,?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			
			
			////System.out.println("DAO Strid"+ vo.getStrStoreId());
			
			////System.out.println("vo.getStrHospitalCode()"+vo.getStrHospitalCode());
			////System.out.println("vo.getStrMenuId()"+vo.getStrMenuId());
			////System.out.println("vo.getStrStatusId()"+vo.getStrStatusId());
			////System.out.println("vo.getStrDeptId()"+vo.getStrDeptId());
			////System.out.println("vo.getStrFromDate()"+vo.getStrFromDate());
			////System.out.println("vo.getStrToDate()"+vo.getStrToDate());
			////System.out.println("HLP Entered");
			////System.out.println("HLP Entered");
			
			/*if(vo.getStrSupplierId().equals("0"))
			{	
			     dao.setProcInValue(nprocIndex, "modeval", "2");
			}
			else
			{
				 dao.setProcInValue(nprocIndex, "modeval", "1");
			}	
	*/
			////System.out.println("Supplier ID==>"+vo.getStrSupplierId());
			
			dao.setProcInValue(nprocIndex, "p_mode", "1");
			//dao.setProcInValue(nprocIndex, "supplierId", vo.getStrSupplierId());
			 
			//dao.setProcInValue(nprocIndex, "pono", vo.getStrPoNumber());
			dao.setProcInValue(nprocIndex, "p_hstnum_store_id", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "p_gnum_hospital_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "p_menu_id", vo.getStrMenuId());
			dao.setProcInValue(nprocIndex, "p_status_id", vo.getStrStatusId());
			dao.setProcInValue(nprocIndex, "p_dept_id", vo.getStrDeptId());
			
			dao.setProcInValue(nprocIndex, "p_hstdt_frm_date", vo.getStrFromDate());
			dao.setProcInValue(nprocIndex, "p_hstdt_to_date", vo.getStrToDate());
			
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
			vo.setStrMsgString("HelpDeskRptDAO.getScreenTwo() --> "
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
