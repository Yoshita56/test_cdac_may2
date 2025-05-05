package mms.reports.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.reports.vo.INJStoreIssueRptVO;

public class INJStoreIssueRptDAO {
	
	public static void storeName(INJStoreIssueRptVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}"; //4+3=7
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try{
			daoObj=new HisDAO("Gifted Item Details","INJStoreIssueRptDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "seatId", vo.getStrSeatId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
			daoObj.setProcOutValue(nProcIndex, "err",1,6); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,7);
			
			/* Start Adding Default value*/
			daoObj.setProcInValue(nProcIndex, "modeval","11",1);
			daoObj.setProcInValue(nProcIndex, "storeid","0",4);
			daoObj.setProcInValue(nProcIndex, "storetype_id","0",5);
			/* End Adding Default value*/
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setWsStoreNameCombo(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("INJStoreIssueRptDAO.storeName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	public static void getViewDtl(INJStoreIssueRptVO vo)
	{
		
		String strproc_name = "";  // 9
		int nprocIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO dao=null;
		
		try
		{
			dao = new HisDAO("mms", "INJStoreIssueRptDAO");	
			
			System.out.println(" ---------INJStoreIssueRptDAO--PKG_MMS_VIEW.proc_storeitem_brand_list-[Mode - 5 ]-------");
			
			strproc_name = "{call PKG_MMS_VIEW.proc_storeitem_brand_list(?,?,?,?,?, ?,?,?,?)}"; //9
			nprocIndex = dao.setProcedure(strproc_name);			

			dao.setProcInValue(nprocIndex, "modeval", 		"5",1);
			dao.setProcInValue(nprocIndex, "store_id", 		vo.getStrStoreId(),2);
			dao.setProcInValue(nprocIndex, "item_id", 		(vo.getStrItemBrandId()==null||vo.getStrItemBrandId().equals(""))?"0":vo.getStrItemBrandId(),3);
			dao.setProcInValue(nprocIndex, "cat_no", 		(vo.getStrItemCategoryId()==null||vo.getStrItemCategoryId().equals(""))?"10":vo.getStrItemCategoryId(),4);
			dao.setProcInValue(nprocIndex, "group_id", 		"0",5);
			dao.setProcInValue(nprocIndex, "sub_group_id", 	vo.getStrSeatId(),6);      // Pass Seat Id Here
			dao.setProcInValue(nprocIndex, "hosp_code", 	vo.getStrHospitalCode(),7);			
			dao.setProcOutValue(nprocIndex, "err", 			1,8);
			dao.setProcOutValue(nprocIndex, "resultset", 	2,9);
			dao.executeProcedureByPosition(nprocIndex);
			strErr = dao.getString(nprocIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = dao.getWebRowSet(nprocIndex, "resultset");
			//System.out.println(" ----------> Size---------"+ ws.size());

			if(strErr.equals(""))
			{
				vo.setWsStockDtl(ws);
			}
		}
		catch(Exception _err)
		{
			vo.setStrMsgString("INJStoreIssueRptDAO.getViewDtl() --> "	+ _err.getMessage());
			vo.setStrMsgType("1");
		}
		 finally {
				if (dao != null) {
					dao.free();
					dao = null;
				}
			}
	}
	
	public static void lpitemName(INJStoreIssueRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		
		//System.out.println("--------vo.getStrItemCategoryNo()--------"+vo.getlpItemvalue());
		
		try 
		{
					    
			dao = new HisDAO("mms", "INJStoreIssueRptDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_storeitem_brand_list(?,?,?,?,?, ?,?,?,?)}"; //9
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", 		"4",1);
			dao.setProcInValue(nprocIndex, "store_id", 		"0",2);
			dao.setProcInValue(nprocIndex, "item_id", 		(vo.getStrItemBrandId()==null||vo.getStrItemBrandId().equals(""))?"0":vo.getStrItemBrandId(),3);
			dao.setProcInValue(nprocIndex, "cat_no", 		(vo.getStrItemCategoryId()==null||vo.getStrItemCategoryId().equals(""))?"10":vo.getStrItemCategoryId(),4);
			dao.setProcInValue(nprocIndex, "group_id", 		"0",5);
			dao.setProcInValue(nprocIndex, "sub_group_id", 	vo.getStrSeatId(),6);      // Pass Seat Id Here
			dao.setProcInValue(nprocIndex, "hosp_code", 	vo.getStrHospitalCode(),7);			
			dao.setProcOutValue(nprocIndex, "err", 			1,8);
			dao.setProcOutValue(nprocIndex, "resultset", 	2,9);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {

				vo.setWslpItemName(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("INJStoreIssueRptDAO.getlpItemName() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void itemCategory(INJStoreIssueRptVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_item_category_list(?,?,?,?,?,?)}"; //6
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try
		{
			daoObj=new HisDAO("Gifted Item Details","INJStoreIssueRptDAO");
			nProcIndex = daoObj.setProcedure(strProcName);	
			daoObj.setProcInValue(nProcIndex, "modeval", 	"3",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", 	vo.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "store_id", 	vo.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "reqType", 	"64",4);
			daoObj.setProcOutValue(nProcIndex, "err",		1,5); 
			daoObj.setProcOutValue(nProcIndex, "resultset",	2,6);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setWsItemCategoryCombo(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("INJStoreIssueRptDAO.itemCategory() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	public static void getInstituteList(INJStoreIssueRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "INJStoreIssueRptDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_institute_list(?,?,?,?)}"; //4
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcOutValue(nprocIndex, "err", 1,3);
			dao.setProcOutValue(nprocIndex, "resultset", 2,4);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) {

				vo.setWsInstituteList(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo
					.setStrMsgString("INJStoreIssueRptDAO.getInstituteList() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	public static void getImageHeader(INJStoreIssueRptVO vo)
	{
		String strFuncName = "";
		String strLogoName = "";
		
		int nFuncIndex = 0;
		HisDAO dao = null;
		try 
		{
			dao = new HisDAO("DWH","New_Report_For_AcknowledgeDAO");
			
			strFuncName = "{? = call MMS_MST.logo_config_dtl(?,?)}";
			nFuncIndex = dao.setFunction(strFuncName);
			
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospitalCode());
			dao.setFuncOutValue(nFuncIndex, 1);
			
			dao.executeFunction(nFuncIndex);
			
			strLogoName = dao.getFuncString(nFuncIndex);
			vo.setStrLogoName(strLogoName);
			System.out.println(">>>>>>>>>>>>>>>    strLogoName  >>>>>>>>>>>>>>>>>>>>"+strLogoName);

		} catch (Exception e) {
			
			e.printStackTrace();
			vo.setStrMsgType("1");
			vo.setStrMsgString("IssueTransDAO.getImageHeader() --> "+ e.getMessage());
			
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}
		}	
	}
	
	
}
