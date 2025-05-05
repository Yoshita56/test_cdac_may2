package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.MaterialOutwardRegisterRptVO;

public class MaterialOutwardRegisterRptDAO
{

	/**
	 * To get Drug Warehouse Type Combo
	 *  
	 * @param voObj
	 */
	public static void getDwhTypeCombo(MaterialOutwardRegisterRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_sstt_dwh_type_mst_cmb(?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("DWH","MaterialOutwardRegisterRptDAO");
			//
			
			nProcIndex = daoObj.setProcedure(strProcName);
			                   
		        
		       
			
			daoObj.setProcInValue(nProcIndex, "p_mode", "1");
			daoObj.setProcInValue(nProcIndex, "p_gnum_hospital_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_sstnum_is_district_dwh", "0");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
//				voObj.setStrDrugWarehouseTypeWs(ws);
				
				voObj.setStrStoreWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("MaterialOutwardRegisterRptDAO.getStoreList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	
	public static void getIssueItemDetails(MaterialOutwardRegisterRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "MaterialOutwardRegisterRptDAO");
			////  
			
			strproc_name = "{call PKG_MMS_RPT.proc_Outward_Issue_Item_Dtl(?,?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			
			/*modeval character varying DEFAULT '1'::character varying,
			hosp_code character varying DEFAULT NULL::character varying,
			pono character varying DEFAULT NULL::character varying, 
			supplierid character varying DEFAULT NULL::character varying, 
			issueno character varying DEFAULT NULL::character varying, 
			storeid character varying DEFAULT NULL::character varying, 
			frmdate character varying DEFAULT NULL::character varying,
			todate character varying DEFAULT NULL::character varying,
			OUT err character varying,
			OUT resultset ahiscl.ahis_type.refcursor);*/
			
			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcInValue(nprocIndex, "pono", "0",3);
			dao.setProcInValue(nprocIndex, "issueNo", vo.getStrIssueNumber(),5);
			dao.setProcInValue(nprocIndex, "storeId", vo.getStrStoreId(),6);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate(),7);
			dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate(),8);
			dao.setProcInValue(nprocIndex, "supplierId", "0",4);
			
			dao.setProcOutValue(nprocIndex, "err", 1,9);
			dao.setProcOutValue(nprocIndex, "resultset", 2,10);
			dao.executeProcedureByPosition(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");
				////System.out.println("Size Issue Item Dtl:::"+wb.size());
                vo.setStrIssueItemDtlWs(wb); 
				

			} else {
				throw new Exception(strerr);
			}

		} 
		catch (Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("MaterialOutwardRegisterRptDAO.receiveInit() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	
	public static void ToStoreCombo(MaterialOutwardRegisterRptVO vo) 
	{
       // Declaring Variables
		String        err = "";
		int    procIndex1 = 0;
		HisDAO        dao = null;
		WebRowSet      ws = null;
		HisUtil   hisutil = null;
		String        str = null;
		String proc_name1 = "{call Pkg_Mms_View.proc_hstt_toStore_mst(?,?,?,?,?,?,?)}";
		try 
		{
			// Creating Object
			  hisutil = new HisUtil("master", "MaterialOutwardRegisterRptDAO");
			      dao = new HisDAO("MMS","MaterialOutwardRegisterRptDAO.ToStoreCombo(MaterialOutwardRegisterRptVO vo)");
			    ////  //  
			      
  		   procIndex1 = dao.setProcedure(proc_name1);
			// set value
  		
	         
  				 dao.setProcInValue(procIndex1, "modeval", "4",1);
				dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode(),2);
  				dao.setProcInValue(procIndex1, "storeid", vo.getStrStoreId(),3);
  				////System.out.println("Store ID==>"+vo.getStrStoreId());
  				dao.setProcInValue(procIndex1, "reqType", "0",4);
				dao.setProcInValue(procIndex1, "catCode", "88",5); /* not in use    */
				dao.setProcOutValue(procIndex1,"ERR", 1,6); // 1 for string return
				dao.setProcOutValue(procIndex1,"RESULTSET", 2,7); // 2 for object
				// execute procedure
				dao.executeProcedureByPosition(procIndex1);
			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			if (ws != null && ws.size() != 0) {
				str = hisutil.getOptionValue(ws, "-1", "0^All", true);
				vo.setStrToStoreCombo(str);
			} else {
				str = "<option value='0'>DATA N/A</option>";
				vo.setStrToStoreCombo(str);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("MaterialOutwardRegisterRptDAO.ToStoreCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	
	
	
	public static void getIssueDetails(MaterialOutwardRegisterRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try 
		{						
			dao = new HisDAO("mms", "MaterialOutwardRegisterRptDAO");
			//  
			
			strproc_name = "{call PKG_MMS_RPT.procMaterialOutwardIssueDtl(?,?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
		
			

					dao.setProcInValue(nprocIndex, "modeval", vo.getStrMode(),1);
					dao.setProcInValue(nprocIndex, "pono", "0",3);
					dao.setProcInValue(nprocIndex, "supplierId", "0",4);			
					dao.setProcInValue(nprocIndex, "storeId", vo.getStrStoreId()!=null?vo.getStrStoreId():"0",5);
					dao.setProcInValue(nprocIndex, "toStoreId", vo.getStrToStoreId()!=null?vo.getStrToStoreId():"0",6);
					
//					//System.out.println("Mode==>"+vo.getStrMode());
//					//System.out.println("From Store ID==>"+vo.getStrStoreId());
//					//System.out.println("To Store ID==>"+vo.getStrToStoreId());
					
					dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
					dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate(),7);
					dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate(),8);
					dao.setProcOutValue(nprocIndex, "err", 1,9);
					dao.setProcOutValue(nprocIndex, "resultset", 2,10);
		  	        dao.executeProcedureByPosition(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				wb = dao.getWebRowSet(nprocIndex, "resultset");
			
                vo.setStrIssueDtlWs(wb); 
				

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			vo.setStrMsgString("MaterialOutwardRegisterRptDAO.getIssueDetails() --> "
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
	 * To get Store Combo  from the hstt_store_mst
	 *  
	 * @param voObj
	 */
	public static void getStoreList(MaterialOutwardRegisterRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

	//	String strProcName = "{call Pkg_Mms_View.poc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nprocIndex = 0;
	
		String strErr = "";

		try{
			daoObj = new HisDAO("MMS Transactions","MaterialOutwardRegisterRptDAO");
			String strproc_name = "{call pkg_mms_rpt.rptm_hstt_store_mst(?,?,?,?,?,?)}";
		nprocIndex = daoObj.setProcedure(strproc_name);
		
		daoObj.setProcInValue(nprocIndex, "modeval",voObj.getStrMode(),1);
		daoObj.setProcInValue(nprocIndex, "seatid",voObj.getStrSeatId(),2);
		daoObj.setProcInValue(nprocIndex, "hosp_code", voObj.getStrHospitalCode(),3);
		daoObj.setProcInValue(nprocIndex, "item_category", "0",4);
		daoObj.setProcOutValue(nprocIndex, "err", 1,5);
		daoObj.setProcOutValue(nprocIndex, "resultset", 2,6); 
		daoObj.executeProcedureByPosition(nprocIndex);
		strErr = daoObj.getString(nprocIndex, "err");
			strErr = daoObj.getString(nprocIndex, "err");

			if (strErr == null)
				strErr = "";
			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nprocIndex, "resultset");
		
				voObj.setStrStoreWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("MaterialOutwardRegisterRptDAO.getStoreList() --> "
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

	public static void getSuppliedByList(MaterialOutwardRegisterRptVO vo) {

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
			
			
			dao.setProcInValue(nprocIndex, "modeVal", "1",1);
			dao.setProcInValue(nprocIndex, "catCode", "10",2);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),5);
			
			/* Start */
			dao.setProcInValue(nprocIndex, "branditem_id", "0",3);
			dao.setProcInValue(nprocIndex, "contractType", "0",4);
			/* End */
			
			dao.setProcOutValue(nprocIndex, "err", 1,6);
			dao.setProcOutValue(nprocIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {
				// //System.out.println("DAO -->" + wb.size());
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
}
