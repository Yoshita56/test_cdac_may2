/**
 * 
 */
package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;


import mms.MmsConfigUtil;
import mms.reports.vo.BreakageAndLostDrugDetailsRptVO;
import mms.reports.vo.ListItemWiseSupplierRptVO;
import mms.reports.vo.ProjectionOrderRptVO;
import mms.reports.vo.ReturnDetailRptVO;

/**
 * @author user
 *
 */
public class ListItemWiseSupplierRptDAO {
	
	public static void itemCategoryName(ListItemWiseSupplierRptVO vo)
	{
		String strProcName = "{call Pkg_Mms_Rpt.Rptm_item_category_list(?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Item Location","ListItemWiseSupplierRptDAO");
			//
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", MmsConfigUtil.GLOBAL_HOSPITAL_CODE,2);
			daoObj.setProcInValue(nProcIndex, "storeid", "",3);
			daoObj.setProcOutValue(nProcIndex, "err",1,4); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,5);
			daoObj.executeProcedureByPosition(nProcIndex);
			
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
			vo.setStrMsgString("ListItemWiseSupplierRptDAO.itemCategoryName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void groupName(ListItemWiseSupplierRptVO vo)
	{
		String strProcName = "{call Pkg_Mms_Rpt.rptm_store_group_list(?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Item Location","ListItemWiseSupplierRptDAO");
			//
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", MmsConfigUtil.GLOBAL_HOSPITAL_CODE,2);
			daoObj.setProcInValue(nProcIndex, "item_category", vo.getStrItemCategoryNo(),3);
			daoObj.setProcOutValue(nProcIndex, "err",1,4); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,5);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setGroupIdWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("ListItemWiseSupplierRptDAO.groupName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void getSuppliedByList(ListItemWiseSupplierRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "ListItemWiseSupplierRptDAO");
		//	
			strproc_name = "{call PKG_MMS_VIEW.proc_supplier_list(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeVal",  vo.getStrMode(),1);
			dao.setProcInValue(nprocIndex, "catCode", "10",2);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),5);
			
			/* Start */
			dao.setProcInValue(nprocIndex, "branditem_id",  vo.getStrSeatId(),3);
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
	
	public static void subGroupName(ListItemWiseSupplierRptVO vo)
	{
		String strProcName = "{call Pkg_Mms_Rpt.rptm_store_subgroup_list(?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Item Location","ListItemWiseSupplierRptDAO");
		//	
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "groupId", vo.getStrGroupId(),2);
			daoObj.setProcOutValue(nProcIndex, "err",1,4); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,5);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setSubGroupIdWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("ListItemWiseSupplierRptDAO.subGroupName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void ItemName(ListItemWiseSupplierRptVO vo)
	{
		String strProcName = "{call Pkg_Mms_Rpt.rptm_itembrand_list(?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
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
			daoObj.setProcInValue(nProcIndex, "catCode", vo.getStrItemCategoryNo(),2);
			daoObj.setProcInValue(nProcIndex, "groupid", vo.getStrGroupId(),3);
			daoObj.setProcInValue(nProcIndex, "subgrpid", vo.getStrSubGroupId(),4);
			daoObj.setProcOutValue(nProcIndex, "err",1,6); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,7);
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setItemIdWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("ListItemWiseSupplierRptDAO.ItemName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void getHospitalName(ListItemWiseSupplierRptVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_rpt.RPT_GET_HOSPITAL_LIST(?,?,?,?,?)}";
		int nProcIndex = 0;	
		String strErr = "";

		try 
		{
			daoObj = new HisDAO("MMS","ListItemWiseSupplierRptDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue( nProcIndex, "modeval","1",1);
			daoObj.setProcInValue( nProcIndex, "hosp_code",voObj.getStrHospitalCode(),2);
			daoObj.setProcInValue( nProcIndex, "seatId",voObj.getStrSeatId(),3);
			daoObj.setProcOutValue(nProcIndex, "err", 1,4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,5);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrHospitalWs(ws);				
				
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("ItemWiseConsumptionRptDAO.getHospitalName() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getTypeCombo(ListItemWiseSupplierRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		
		try 
		{
			dao = new HisDAO("mms", "ListItemWiseSupplierRptDAO");			
			
			strproc_name = "{call PKG_MMS_VIEW2.proc_itemwise_supplier_dtl(?,?,?,?,?, ?,?,?,?,?)}";
			
			nprocIndex = dao.setProcedure(strproc_name);
			
			dao.setProcInValue(nprocIndex, "modeval", "1",1);			
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);	
			dao.setProcInValue(nprocIndex, "catcode", "10",3);	
			dao.setProcInValue(nprocIndex, "itemid", vo.getStrItemId(),4);	
			dao.setProcInValue(nprocIndex, "suppid", vo.getStrSuppId(),5);	
			dao.setProcInValue(nprocIndex, "expiryday", "0",6);	
			dao.setProcInValue(nprocIndex, "ratecontracttypeid","12",7);	
			dao.setProcInValue(nprocIndex, "groupid", "0",8);	

			dao.setProcOutValue(nprocIndex, "err", 1,9);
			dao.setProcOutValue(nprocIndex, "resultset", 2,10);

			dao.executeProcedure(nprocIndex);
			
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");

			if (strerr.equals("")) {

				vo.setStrTypeCmbWS(wb);
			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("ListItemWiseSupplierRptDAO.getActiveTypeCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
			}
		}
	
	}
	
	public static void getImageHeader(ListItemWiseSupplierRptVO voObj)
	{
		String strFuncName = "";
		String strLogoName = "";
		
		int nFuncIndex = 0;
		HisDAO dao = null;
		try 
		{
			dao = new HisDAO("DWH","ListItemWiseSupplierRptDAO");
			
			strFuncName = "{? = call MMS_MST.logo_config_dtl(?,?)}";
			nFuncIndex = dao.setFunction(strFuncName);
			
			dao.setFuncInValue(nFuncIndex, 2, voObj.getStrMode());
			dao.setFuncInValue(nFuncIndex, 3, voObj.getStrHospitalCode());
			dao.setFuncOutValue(nFuncIndex, 1);
			
			dao.executeFunction(nFuncIndex);
			
			strLogoName = dao.getFuncString(nFuncIndex);
			voObj.setStrLogoName(strLogoName);

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgType("1");
			voObj.setStrMsgString("ListItemWiseSupplierRptDAO.getImageHeader() --> "+ e.getMessage());
			
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}
		}	
	}
	
	public static void getRateContRptDtl(ListItemWiseSupplierRptVO voObj)
	{
		String strProcName = "{call pkg_mms_view2.proc_rate_contr_dtl_rpt(?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj = null;

		try 
		{
			daoObj = new HisDAO("DWH","ListItemWiseSupplierRptDAO");
			nProcIndex = daoObj.setProcedure(strProcName);	
			
			daoObj.setProcInValue(nProcIndex, "modeval",            "1",1);  	 
			daoObj.setProcInValue(nProcIndex, "hosp_code",   		voObj.getStrHospitalCode(),2);	    
			daoObj.setProcInValue(nProcIndex, "suppl_id",      	voObj.getStrSuppId(),3);				
			daoObj.setProcOutValue(nProcIndex, "err",         1,4); 	
			daoObj.setProcOutValue(nProcIndex, "resultset",   2,5);		

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				System.out.println(" ----------> Size---------"+ ws.size());
				voObj.setBreakageDtlRptWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("ListItemWiseSupplierRptDAO.getRateContRptDtl() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}


}
