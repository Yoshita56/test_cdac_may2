package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.MaterialInwardReisterRptVO;

public class MaterialInwardReisterRptDAO 
{
	
	/**
	 * The following procedure is used to populate the value of Supplier Name
	 * combo using Pkg_Mms_View.proc_supplier_list procedure.
	 * 
	 * 
	 */

	public static void getSuppliedByList(MaterialInwardReisterRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "DrugInventoryTransDAO");
		//	
			
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal", "9",1);
			dao.setProcInValue(nprocIndex, "catCode", "10",2);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),3);
			
			/* Start */
			dao.setProcInValue(nprocIndex, "branditem_id", vo.getStrSeatId(),4);
			dao.setProcInValue(nprocIndex, "contractType", "0",5);
			/* End */
			
			dao.setProcOutValue(nprocIndex, "err", 1,6);
			dao.setProcOutValue(nprocIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			//System.out.println("ws"+wb.size());
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
	
	
	public static void getPoDetails(MaterialInwardReisterRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "MaterialInwardReisterRptDAO");
		//	
			
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
			vo.setStrMsgString("MaterialInwardReisterRptDAO.receiveInit() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	public static void getSupplierPODtlPopUp(MaterialInwardReisterRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "MaterialInwardReisterRptDAO");
		//	
			
			strproc_name = "{call PKG_MMS_RPT.Get_SuppPo_Details(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			
			if(vo.getStrSupplierId().equals("0"))
			{	
			 dao.setProcInValue(nprocIndex, "modeval", "2",1);
			}
			else
			{
				 dao.setProcInValue(nprocIndex, "modeval", "1",1);
			}	
			
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
dao.setProcInValue(nprocIndex, "pono", vo.getStrPoNumber(),3);
 
			dao.setProcInValue(nprocIndex, "supplierId", vo.getStrSupplierId(),4);
			 
			
			
			dao.setProcInValue(nprocIndex, "storeId", "0",5);
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate(),6);
			dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate(),7);
			dao.setProcOutValue(nprocIndex, "err", 1,8);
			dao.setProcOutValue(nprocIndex, "resultset", 2,9);
			dao.executeProcedureByPosition(nprocIndex);

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
			vo.setStrMsgString("MaterialInwardReisterRptDAO.getSupplierPODtlPopUp() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	public static void getScreenTwo(MaterialInwardReisterRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "MaterialInwardReisterRptDAO");
		//	
			
			strproc_name = "{call PKG_MMS_RPT.Get_Supplier_Details(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			if(vo.getStrSupplierId().equals("0"))
			{	
			     dao.setProcInValue(nprocIndex, "modeval", "2",1);
			 	//System.out.println("moD==> 2");
			}
			else
			{
				 dao.setProcInValue(nprocIndex, "modeval", "1",1);
				 //System.out.println("moD==> 1");
			}	
		
	          
			
			/*//System.out.println("Supplier ID==>"+vo.getStrSupplierId());
			//System.out.println("pono"+ vo.getStrPoNumber());
			//System.out.println("hosp_code"+vo.getStrHospitalCode());
			//System.out.println("frmdate"+vo.getStrFromDate());
			//System.out.println("todate"+ vo.getStrToDate());*/
			
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nprocIndex, "pono", vo.getStrPoNumber(),3);
			dao.setProcInValue(nprocIndex, "supplierId", vo.getStrSupplierId(),4);
			dao.setProcInValue(nprocIndex, "storeId", "0",5);
		    dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate(),6);
			dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate(),7);
		    dao.setProcOutValue(nprocIndex, "err", 1,8);
			dao.setProcOutValue(nprocIndex, "resultset", 2,9);
			dao.executeProcedureByPosition(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");
		//System.out.println("Screen TwoSixze ==>"+wb.size());
                vo.setStrScreentTwoWs(wb); 
				

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("MaterialInwardReisterRptDAO.getScreenTwo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	public static void getChallanDetails(MaterialInwardReisterRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "MaterialInwardReisterRptDAO");
	//		
			
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
			vo.setStrMsgString("MaterialInwardReisterRptDAO.receiveInit() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getChallanItemDtlPopUp(MaterialInwardReisterRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "MaterialInwardReisterRptDAO");
		//	
			
			strproc_name = "{call PKG_MMS_RPT.proc_Get_Challan_ItemDtl(?,?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			
			
			dao.setProcInValue(nprocIndex, "modeval", "1",1);
//			//System.out.println("Challan No==>"+vo.getStrChallanNo());
//			//System.out.println("PO No==>"+vo.getStrPoNumber());
//			//System.out.println("Store ID==>"+vo.getStrStoreId());
//			//System.out.println("Hosp Code==>"+vo.getStrHospitalCode());
			
			dao.setProcInValue(nprocIndex, "challanNo", vo.getStrChallanNo(),3);
			dao.setProcInValue(nprocIndex, "poNo", vo.getStrPoNumber(),4);
		    dao.setProcInValue(nprocIndex, "storeId", vo.getStrStoreId(),6);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate(),7);
			dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate(),8);
			dao.setProcInValue(nprocIndex, "supplierId", "0",5);
			
			dao.setProcOutValue(nprocIndex, "err", 1,9);
			dao.setProcOutValue(nprocIndex, "resultset", 2,10);
			dao.executeProcedureByPosition(nprocIndex);

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
			vo.setStrMsgString("MaterialInwardReisterRptDAO.receiveInit() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	public static void getPOChallanDtlPopUp(MaterialInwardReisterRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "MaterialInwardReisterRptDAO");
		//	
			
			strproc_name = "{call PKG_MMS_RPT.proc_Get_POChallan_Dtl(?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			
		
			
			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nprocIndex, "pono", vo.getStrPoNumber(),3);

			dao.setProcInValue(nprocIndex, "supplierId", vo.getStrSupplierId(),4);

			dao.setProcInValue(nprocIndex, "storeId", vo.getStrStoreId(),5);
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate(),6);
			dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate(),7);
			
			dao.setProcOutValue(nprocIndex, "err", 1,8);
			dao.setProcOutValue(nprocIndex, "resultset", 2,9);
			dao.executeProcedureByPosition(nprocIndex);

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
			vo.setStrMsgString("MaterialInwardReisterRptDAO.getPOChallanDtlPopUp() --> "
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
