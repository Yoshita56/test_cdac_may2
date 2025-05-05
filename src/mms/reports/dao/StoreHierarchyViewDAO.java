package mms.reports.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
//import mms.reports.vo.StoreHierarchyViewVO;
import mms.reports.vo.StoreHierarchyViewVO;


public class StoreHierarchyViewDAO {

	
	public static void setStoreCombo(StoreHierarchyViewVO _IssueDetailRptVO_NEW) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.rptm_hstt_store_mst(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","ListConsumablesExpiryDateRptDAO");
		//	
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "seatId", _IssueDetailRptVO_NEW.getStrSeatId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", _IssueDetailRptVO_NEW.getStrHospCode(),3);
			daoObj.setProcInValue(nProcIndex, "item_category", "0",4);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			
			if (ws != null) {
				if (ws.next()) {
					_IssueDetailRptVO_NEW.setStrStoreId(ws.getString(1));

					ws.beforeFirst();
				}
			}

			if (strErr.equals("")) {

				_IssueDetailRptVO_NEW.setStrWS(ws);

							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			_IssueDetailRptVO_NEW
					.setStrMsgString("ListConsumablesExpiryDateRptDAO.getStoreList() --> "
							+ e.getMessage());
			_IssueDetailRptVO_NEW.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getViewDtl(StoreHierarchyViewVO voObj)
	{
		String strProcName = "{call pkg_mms_view2.proc_store_wise_hierarchy(?,?,?,?,?, ?)}";

		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj = null;
		
		System.out.println("--voObj.getStrHospCode()---"+voObj.getStrHospCode());
		System.out.println("--voObj.getStrSeatId()---"+voObj.getStrSeatId());
		System.out.println("--voObj.setStrStoreId()----"+voObj.getStrStoreId());
		
		try 
		{
			daoObj = new HisDAO("DWH","ListofNARptDAO");
			nProcIndex = daoObj.setProcedure(strProcName);	
				
			daoObj.setProcInValue(nProcIndex, "modeval",              	"1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code",              voObj.getStrHospCode(),2);
			daoObj.setProcInValue(nProcIndex, "strid", 					voObj.getStrStoreId(),3);
			daoObj.setProcInValue(nProcIndex, "itemcategno",  			"0",4);  
			daoObj.setProcOutValue(nProcIndex, "err",        			1,5); 	
			daoObj.setProcOutValue(nProcIndex, "resultset",   			2,6);		

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				System.out.println(" ----------> Size----------"+ ws.size());
				voObj.setWsReturnReqDtlRpt(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("ListofNARptDAO.getViewDtl() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
}
