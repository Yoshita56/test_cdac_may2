package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.IssueToThirdPartyRptVO;
import mms.reports.vo.ConsumptionRptVO;

public class ConsumptionRptDAO {
	
	public static void getStoreList(ConsumptionRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		int nprocIndex = 0;
		String strErr = "";
	
		try {

			daoObj = new HisDAO("MMS Transactions","ConsumptionRptDAO");
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

			voObj.setStrMsgString("ConsumptionRptDAO.getStoreList() --> "+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getItemCatList(ConsumptionRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		int nprocIndex = 0;
		String strErr = "";
		/*String strProcName = "{call Pkg_Mms_Rpt.Rptm_item_category_list(?,?,?,?,?)}";
		
	
		

		try {

			daoObj = new HisDAO("MMS Transactions","ConsumptionRptDAO");
		//	
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", voObj.getStrMode());
			daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");*/
		
		try
		{daoObj = new HisDAO("mms", "ConsumptionRptDAO");
		String strProcName = "{call pkg_mms_rpt.Rptm_item_category_list(?,?,?,?,?)}";
		nprocIndex = daoObj.setProcedure(strProcName);
		//System.out.println("modeval"+voObj.getStrMode());
		daoObj.setProcInValue(nprocIndex, "modeval",voObj.getStrMode(),1);
		daoObj.setProcInValue(nprocIndex, "hosp_code", voObj.getStrHospitalCode(),2);
		daoObj.setProcInValue(nprocIndex, "storeId",voObj.getStrStoreId(),3);							
		daoObj.setProcOutValue(nprocIndex, "err", 1,4);
		daoObj.setProcOutValue(nprocIndex, "resultset", 2,5); 
		
		daoObj.executeProcedureByPosition(nprocIndex);
		strErr = daoObj.getString(nprocIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nprocIndex, "resultset");
		
				voObj.setStrItemCatWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("ConsumptionRptDAO.getItemCatList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getItemList(ConsumptionRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		int nprocIndex = 0;
		String strErr = "";

		try
		{daoObj = new HisDAO("mms", "ConsumptionRptDAO");
		
		String strProcName = "{call pkg_mms_rpt.rptm_itembrand_list(?,?,?,?,? ,?,?)}";
		nprocIndex = daoObj.setProcedure(strProcName);
		//System.out.println("modeval"+voObj.getStrMode());
		daoObj.setProcInValue(nprocIndex, "modeval",voObj.getStrMode(),1);
		daoObj.setProcInValue(nprocIndex, "catcode", voObj.getStrItemCatId(),2);
		daoObj.setProcInValue(nprocIndex, "groupid","0",3);
		daoObj.setProcInValue(nprocIndex, "subgrpid","0",4);
		daoObj.setProcInValue(nprocIndex, "hosp_code",voObj.getStrHospitalCode(),5);
		daoObj.setProcOutValue(nprocIndex, "err", 1,6);
		daoObj.setProcOutValue(nprocIndex, "resultset", 2,7); 
		
		daoObj.executeProcedureByPosition(nprocIndex);
		strErr = daoObj.getString(nprocIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nprocIndex, "resultset");
		
				voObj.setStrItemWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("ConsumptionRptDAO.getItemCatList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getSupplierList(ConsumptionRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		int nprocIndex = 0;
		String strErr = "";

		try
		{daoObj = new HisDAO("mms", "ConsumptionRptDAO");
		
		String strProcName = "{call pkg_mms_rpt.rptm_supplier_list(?,?,?,?,? )}";
		nprocIndex = daoObj.setProcedure(strProcName);
		//System.out.println("modeval"+voObj.getStrMode());
		daoObj.setProcInValue(nprocIndex, "modeval","2",1);
		daoObj.setProcInValue(nprocIndex, "hosp_code", "100",2);
		daoObj.setProcInValue(nprocIndex, "item_cat",voObj.getStrItemCatId(),3);
		daoObj.setProcOutValue(nprocIndex, "err", 1,4);
		daoObj.setProcOutValue(nprocIndex, "resultset", 2,5); 
		
		daoObj.executeProcedureByPosition(nprocIndex);
		strErr = daoObj.getString(nprocIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nprocIndex, "resultset");
		
				voObj.setStrSuppWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("ConsumptionRptDAO.getItemCatList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void GetUserLevel(ConsumptionRptVO voObj) {
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.get_userlevel_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","ConsumptionRptDAO");
		//	
			nProcIndex = daoObj.setProcedure(strProcName);
			
			////System.out.println("seatid"+voObj.getStrSeatId());
			////System.out.println("hosp_code"+voObj.getStrHospitalCode());

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hospCode", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrUserlevelWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("ConsumptionRptDAO.getUserLevel() --> "	+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
		
	}

}
