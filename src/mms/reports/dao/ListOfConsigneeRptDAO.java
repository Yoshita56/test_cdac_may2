package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.ListOfConsigneeRptVO;
//import mms.transactions.vo.DrugInventoryTransVO;
import mms.reports.vo.SampleIssueReceiveToQualityDeptRptVO;

public class ListOfConsigneeRptDAO 
{
	
	/**
	 * The following procedure is used to populate the value of Supplier Name
	 * combo using Pkg_Mms_View.proc_supplier_list procedure.
	 * 
	 * 
	 */

	public static void getSuppliedByList(ListOfConsigneeRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "ListOfConsigneeRptDAO");
			
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
			vo.setStrMsgString("ListOfConsigneeRptDAO.getSuppliedByList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	
	
	
	public static void getPoDetails(ListOfConsigneeRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "ListOfConsigneeRptDAO");
			
			strproc_name = "{call PKG_MMS_RPT.Get_Po_Details(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			
			dao.setProcInValue(nprocIndex, "modeval", "3");
			dao.setProcInValue(nprocIndex, "supplierId", vo.getStrSupplierId());
			 
			dao.setProcInValue(nprocIndex, "pono", "0");
			dao.setProcInValue(nprocIndex, "storeId", "0");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrOrderFromDate());
			dao.setProcInValue(nprocIndex, "todate", vo.getStrOrderToDate());
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
			vo.setStrMsgString("ListOfConsigneeRptDAO.getPoDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	public static void getSupplierPODtlPopUp(ListOfConsigneeRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "ListOfConsigneeRptDAO");
			
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
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrOrderFromDate());
			dao.setProcInValue(nprocIndex, "todate", vo.getStrOrderToDate());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");
			
                //vo.setStrSupplierPODtlWs(wb); 
				

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			vo.setStrMsgString("ListOfConsigneeRptDAO.getSupplierPODtlPopUp() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	
	
	public static void getSupplierPerformanceDtl(ListOfConsigneeRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "ListOfConsigneeRptDAO");
			
			strproc_name = "{call PKG_MMS_RPT.Get_Supplier_Performance_Dtl(?,?,?,?,?,?,?,?,?,?)}";   //10 variables
			nprocIndex = dao.setProcedure(strproc_name);
			
//			  modeval           VARCHAR2 DEFAULT '1',
//	          hosp_code         VARCHAR2 DEFAULT 0,
//	          supplierId        VARCHAR2 DEFAULT NULL,
//	          groupId           VARCHAR2 DEFAULT 0,
//	          itemId            VARCHAR2 DEFAULT 0,
//	          storeId           VARCHAR2 DEFAULT NULL,
//	          frmdate           VARCHAR2 DEFAULT NULL,
//	          todate            VARCHAR2 DEFAULT NULL,
//	          err         OUT   VARCHAR2,
//	          resultset   OUT   Ahis_Type.refcursor
			
			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
						////System.out.println("Supplier ID==>"+vo.getStrSupplierId());
			dao.setProcInValue(nprocIndex, "supplierId", vo.getStrSupplierId());
			//dao.setProcInValue(nprocIndex, "groupId", vo.getStrGroupId());
			//dao.setProcInValue(nprocIndex, "itemId", vo.getStrDrugId());
			dao.setProcInValue(nprocIndex, "storeId", "0");
			
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrOrderFromDate());
			dao.setProcInValue(nprocIndex, "todate", vo.getStrOrderToDate());
			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");
				//System.out.println("Screen TwoSixze ==>"+wb.size());
               // vo.setStrScreentTwoWs(wb); 
				

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			vo.setStrMsgString("ListOfConsigneeRptDAO.getSupplierPerformanceDtl() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getScreenTwo(ListOfConsigneeRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "ListOfConsigneeRptDAO");
			
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
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrOrderFromDate());
			dao.setProcInValue(nprocIndex, "todate", vo.getStrOrderToDate());
			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");
			////System.out.println("Screen TwoSixze ==>"+wb.size());
                //vo.setStrScreentTwoWs(wb); 
				

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			vo.setStrMsgString("ListOfConsigneeRptDAO.getScreenTwo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	
	
	//////////
	/**
	 * for getting option value of Store Id & Store Name 
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getStoreList(
			ListOfConsigneeRptVO voObj) {
		
		HisDAO daoObj = null;
		WebRowSet ws = null;
		HisUtil hisutil =null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("mms", "ListOfConsigneeRptDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);

			
			daoObj.setProcInValue(nProcIndex, "modeval", "4");
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
				////System.out.println("getStoreList size :"+ws.size());
		
				if(ws!=null && ws.size()>0)
				{
					voObj.setWrsStoreNameCombo(ws);
				}	
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			e.printStackTrace();
			voObj
					.setStrMsgString("ListOfConsigneeRptDAO.getStoreList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
		
	}
	



	public static void getPOConsigneeDtl(ListOfConsigneeRptVO voObj) {
		
		HisDAO daoObj = null;
		WebRowSet ws = null;
		HisUtil hisutil =null;

		String strProcName = "{call Pkg_Mms_Rpt.list_of_Consignee_Dtl_Rpt(?,?,?,?,?,?)}";		//4+2=6 variables
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("mms", "ListOfConsigneeRptDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);

			
			daoObj.setProcInValue(nProcIndex, "p_mode", "1");
			daoObj.setProcInValue(nProcIndex, "p_gnum_hospital_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_hstnum_store_id", voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "p_hstnum_po_no",voObj.getStrPoNumber()); 
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				////System.out.println("getPOConsigneeDtl size :"+ws.size());
		         
				if(ws!=null && ws.size()>0)
				{
					voObj.setWrsPoListOfConsignee(ws);
				}	
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			e.printStackTrace();
			voObj
					.setStrMsgString("ListOfConsigneeRptDAO.getPOConsigneeDtl() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

}
