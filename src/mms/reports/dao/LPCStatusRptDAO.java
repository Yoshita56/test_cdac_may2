package mms.reports.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.reports.vo.LPCStatusRptVO;

public class LPCStatusRptDAO {
	
	
	public static void getViewDtl(LPCStatusRptVO vo)
	{
		
		String strProcName = "{call pkg_mms_view2.rptm_lpc_report(?,?,?,?,? ,?,?,?,?,?)}";  // 10
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj  = new HisDAO("MMS","LPCStatusRptDAO");
			System.out.println(" ----------> getStrSeatId()------------ " +  vo.getStrSeatId());
			System.out.println(" ----------> getStrHospitalCode() ---- " +  vo.getStrHospitalCode());
			System.out.println(" ----------> getStrCategoryId() ---- " +  vo.getStrCategoryId());
			System.out.println(" ----------> getStrCategoryName() ---- " +  vo.getStrCategoryName());
			
			nProcIndex = daoObj.setProcedure(strProcName);
			
			if(vo.getStrCategoryId().equals("10")) {
				daoObj.setProcInValue(nProcIndex, "modeval","1",1);  													    
			}
			else {
				daoObj.setProcInValue(nProcIndex, "modeval","2",1); 													    
			}
			daoObj.setProcInValue(nProcIndex, "store_id","0",2);
			daoObj.setProcInValue(nProcIndex, "catg_id",vo.getStrCategoryId(),3);
			daoObj.setProcInValue(nProcIndex, "brand_id","0",4);
			daoObj.setProcInValue(nProcIndex, "fromdate","0",5);
			daoObj.setProcInValue(nProcIndex, "todate","0",6);
			daoObj.setProcInValue(nProcIndex, "seat_id",vo.getStrSeatId(),7);
			daoObj.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(),8);
			daoObj.setProcOutValue(nProcIndex, "err",1,9); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,10);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			System.out.println(" ----------> Size---------"+ ws.size());

			if(strErr.equals(""))
			{
				vo.setWsViewDtl(ws);
			}
		}
		catch(Exception _err)
		{
			vo.setStrMsgString("LPCStatusRptDAO.getViewDtl() --> "	+ _err.getMessage());
			vo.setStrMsgType("1");
		}
		 finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
	}

	public static void getImageHeader(LPCStatusRptVO vo)
	{
		String strFuncName = "";
		String strLogoName = "";
		
		int nFuncIndex = 0;
		HisDAO dao = null;
		try 
		{
			dao = new HisDAO("mms","LPCStatusRptDAO");
			
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
			vo.setStrMsgString("LPCStatusRptDAO.getImageHeader() --> "+ e.getMessage());
			
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}
		}	
	}



}
