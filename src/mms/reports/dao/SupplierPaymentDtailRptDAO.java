package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.dao.DmlHsttPatEmpIssueDtlDAO;
import mms.dao.DmlHsttPatEmpIssueItemDtlDAO;
import mms.reports.vo.SupplierPaymentDtailRptVO;
import mms.transactions.vo.IssueTransVO;

public class SupplierPaymentDtailRptDAO 
{
	
	/**
	 * The following procedure is used to populate the value of Supplier Name
	 * combo using Pkg_Mms_View.proc_supplier_list procedure.
	 * 
	 * 
	 */

	public static void getSuppliedByList(SupplierPaymentDtailRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "SupplierPaymentDtailRptDAO");
			
			
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", vo.getStrMode());
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
			vo.setStrMsgString("SupplierPaymentDtailRptDAO.getSuppliedByList() --> "
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

	public static void getPOCombo(SupplierPaymentDtailRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "SupplierPaymentDtailRptDAO");
			
			
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
			vo.setStrMsgString("SupplierPaymentDtailRptDAO.getPOCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
		
	public static void getSupplierPerformanceDtl(SupplierPaymentDtailRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "SupplierPaymentDtailRptDAO");
			
			
			strproc_name = "{call PKG_MMS_RPT.Get_Supplier_Performance_Dtl(?,?,?,?,?,?,?,?,?,?,?)}";   //11 variables
			nprocIndex = dao.setProcedure(strproc_name);
    		dao.setProcInValue(nprocIndex, "modeval", "2");
//    		//System.out.println("Supplier ID==>"+vo.getStrSupplierId());
//    		//System.out.println("Grp ID==>"+ vo.getStrGroupId());
//    		//System.out.println("DrugBrand  ID==>"+vo.getStrDrugId());    		    		
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());				
			dao.setProcInValue(nprocIndex, "supplierId", vo.getStrSupplierId());
			dao.setProcInValue(nprocIndex, "groupId", "0");
			dao.setProcInValue(nprocIndex, "itemId", "0");
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
			vo.setStrMsgString("SupplierPaymentDtailRptDAO.getSupplierPerformanceDtl() --> "
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
