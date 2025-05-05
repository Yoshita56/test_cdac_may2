package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.DebtorRegisterRptVO;

public class DebtorRegisterRptDAO 
{
	
	/**
	 * To get Store Combo  from the hstt_store_mst
	 *  
	 * @param voObj
	 */
	public static void getStoreList(DebtorRegisterRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("DWH","DebtorRegisterRptDAO");
			

			nProcIndex = daoObj.setProcedure(strProcName);

			
			daoObj.setProcInValue(nProcIndex, "modeval", voObj.getStrMode());
			daoObj.setProcInValue(nProcIndex, "seatid", voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeid", "0");
			daoObj.setProcInValue(nProcIndex, "storetype_id","0"); 
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
	
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
					.setStrMsgString("DebtorRegisterRptDAO.getStoreList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	/**
	 * The following procedure is used to populate the value of Supplier Name
	 * combo using Pkg_Mms_View.proc_supplier_list procedure.
	 * 
	 * 
	 */
	
	public static void getSuppliedByList(DebtorRegisterRptVO vo) 
	{
	
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
	
		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
			
			
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
	
			dao.setProcInValue(nprocIndex, "modeVal", "1");
			dao.setProcInValue(nprocIndex, "catCode", "10");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			
			/* Start */
			dao.setProcInValue(nprocIndex, "branditem_id", "0");
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
			vo.setStrMsgString("DrugInventoryTransDAO.getSuppliedByList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	public static void getUnitDetails(DebtorRegisterRptVO vo)
	{
	
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "DebtorRegisterRptDAO");
			
			strproc_name = "{call PKG_MMS_RPT.proc_Debotar_Issue_Rpt(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
									
			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "pono", "0");
			dao.setProcInValue(nprocIndex, "supplierId", "0");
			
			dao.setProcInValue(nprocIndex, "storeId", vo.getStrStoreId());
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
			
	            vo.setStrConsolidatedStoreWs(wb); 
				
	
			} else {
				throw new Exception(strerr);
			}
	
		} catch (Exception e) {
			vo.setStrMsgString("DebtorRegisterRptDAO.getUnitDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	public static void getDebetorItemDetails(DebtorRegisterRptVO vo) 
	{
	
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try 
		{
			dao = new HisDAO("mms", "MaterialOutwardRegisterRptDAO");
			
			strproc_name = "{call PKG_MMS_RPT.proc_Outward_Issue_Item_Dtl(?,?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			
			
			dao.setProcInValue(nprocIndex, "modeval", "2");
			dao.setProcInValue(nprocIndex, "pono", "0");
			////System.out.println("Issue No:::"+vo.getStrIssueNumber());
			////System.out.println("Store ID:::"+vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "issueNo", vo.getStrIssueNumber());
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
				////System.out.println("Size CHallan Dtl:::"+wb.size());
	            vo.setStrConsolidatedIssuedItemWs(wb); 
				
	
			} else {
				throw new Exception(strerr);
			}
	
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("DebtorRegisterRptDAO.getIssuedItemDetails() --> "
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
