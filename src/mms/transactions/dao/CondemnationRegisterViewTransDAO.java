package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.CondemnationRegisterViewTransVO;


public class CondemnationRegisterViewTransDAO {
	
	
	public static void getCondemnationDetails(CondemnationRegisterViewTransVO vo) 
	{
		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";

    	try 
		{
    		String strProcName = "{call Pkg_mms_view.Proc_Hstt_Condemnation_Dtl(?,?,?,?,?,?)}";

			daoObj = new HisDAO("MMS Transactions","CondemnationRegisterViewTransDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modval", "1");
			
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			
			daoObj.setProcInValue(nProcIndex, "strId", vo.getStrStoreId());
			
			daoObj.setProcInValue(nProcIndex, "agenda_no", vo.getStrAgendaNo());
			
			daoObj.setProcOutValue(nProcIndex,"err", 1);
			
			daoObj.setProcOutValue(nProcIndex,"resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {
				wb = daoObj.getWebRowSet(nProcIndex, "resultset");
				vo.setStrCondemnDetailsWs(wb);	
			} else {
				throw new Exception(strErr);
			}
    	} 
    	catch (Exception e) 
    	{
    		e.printStackTrace();
			vo.setStrMsgString("--> CondemnationRegisterViewTransDAO.getCondemnationDetails()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {			
			if (daoObj != null)
				daoObj.free();
				daoObj = null;
			}
		}
	
	public static void getRequestDetails(CondemnationRegisterViewTransVO vo) 
	{
		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";

    	try 
		{
    		String strProcName = "{call Pkg_mms_view.Proc_agenda_indent_dtl(?,?,?,?,?,?)}";

			daoObj = new HisDAO("MMS Transactions","CondemnationRegisterViewTransDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId());
			
			daoObj.setProcInValue(nProcIndex, "agenda_no", vo.getStrAgendaNo());
			
			daoObj.setProcOutValue(nProcIndex,"err", 1);
			
			daoObj.setProcOutValue(nProcIndex,"resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {
				wb = daoObj.getWebRowSet(nProcIndex, "resultset");
	
				vo.setStrRequestDetailsWs(wb);	
			} 
			else {
				throw new Exception(strErr);
			}
    	} 
    	catch (Exception e) 
    	{
    		e.printStackTrace();
			vo.setStrMsgString("--> CondemnationRegisterViewTransDAO.getRequestDetails()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {		
			if (daoObj != null)
				daoObj.free();
				daoObj = null;
			}
		}
	
	public static void getItemDetails(CondemnationRegisterViewTransVO vo) 
	{
		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";

    	try 
		{
    		String strProcName = "{call Pkg_mms_view.Proc_agenda_item_dtl(?,?,?,?,?,?)}";

			daoObj = new HisDAO("MMS Transactions","CondemnationRegisterViewTransDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId());
			
			daoObj.setProcInValue(nProcIndex, "agenda_no", vo.getStrAgendaNo());
			
			daoObj.setProcOutValue(nProcIndex,"err", 1);
			
			daoObj.setProcOutValue(nProcIndex,"resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {
				wb = daoObj.getWebRowSet(nProcIndex, "resultset");
				vo.setStrItemDetailsWs(wb);
			} 
			else {
				throw new Exception(strErr);
			}
    	} 
    	catch (Exception e) 
    	{
    		e.printStackTrace();
			vo.setStrMsgString("--> CondemnationRegisterViewTransDAO.getItemDetails()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {		
			if (daoObj != null)
				daoObj.free();
				daoObj = null;
			}
		}
	
	public static void getLotsDetails(CondemnationRegisterViewTransVO vo) 
	{
		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";

    	try 
		{
    		String strProcName = "{call  Pkg_mms_view.proc_lot_view_dtl(?,?,?,?,?,?,?,?)}";

			daoObj = new HisDAO("MMS Transactions","CondemnationRegisterViewTransDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "strId", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "agendaNo", vo.getStrAgendaNo());
			
			/* Start */
			daoObj.setProcInValue(nProcIndex, "itemId", "");
			daoObj.setProcInValue(nProcIndex, "itemBrandId", "");
			/* End */
		
			daoObj.setProcOutValue(nProcIndex,"err", 1);
			daoObj.setProcOutValue(nProcIndex,"resultset", 2);
			daoObj.executeProcedure(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {
				wb = daoObj.getWebRowSet(nProcIndex, "resultset");
				vo.setItemDtlWS(wb);
				if(wb.next()){
					vo.setStrCondemnationType(wb.getString(5));
					vo.setStrRemarks(wb.getString(14));
					
				}
				
			} else {
				throw new Exception(strErr);
			}
    	} 
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		vo.setStrMsgString("--> CondemnationRegisterViewTransDAO.getLotsDetails()-->"
					+ e.getMessage());
    		vo.setStrMsgType("1");
		} finally {			
			if (daoObj != null)
				daoObj.free();
				daoObj = null;
			}
		}

	
	}
