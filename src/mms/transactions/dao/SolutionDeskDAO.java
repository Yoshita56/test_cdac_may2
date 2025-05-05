package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;


import mms.transactions.vo.SolutionDeskVO;


public class SolutionDeskDAO {
	
	public static void insertsol(SolutionDeskVO vo) 
	{

		String    strProcName = "";
		int        nProcIndex = 0;
		HisDAO         daoObj = null;
	  try 
		{
			     daoObj = new HisDAO("MMS", "SolutionDeskDAO");
			strProcName = "{call PKG_MMS_DML.proc_hstt_solution_desk_dtl(?,?,?,?,?,?,?,?,?)}"; // 13 Variable

			nProcIndex = daoObj.setProcedure(strProcName);				
			
		
			////System.out.println("DAO SOL hstnum_prob_id "+vo.getSolTransid());
			////System.out.println("DAO SOL hstnum_store_id "+vo.getSolStrid());
			////System.out.println("DAO SOL gnum_hospital_code "+vo.getStrHospitalCode());
			////System.out.println("DAO SOL hststr_solution "+vo.getStrprobsol());
			////System.out.println("DAO SOL gstr_remarks "+vo.getStrremarks());
			////System.out.println("DAO ModVAL" +vo.getStrMode());
			////System.out.println("DAO Submit by:"+vo.getStrsubmitby());
			////System.out.println("DAO Seat Id:"+vo.getStrSeatId());
			
			
			
			daoObj.setProcInValue(nProcIndex, "modval", vo.getStrMode());
			daoObj.setProcInValue(nProcIndex, "hstnum_prob_id", vo.getSolTransid());
			daoObj.setProcInValue(nProcIndex, "hstnum_store_id", vo.getSolStrid());
			daoObj.setProcInValue(nProcIndex, "gnum_hospital_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "hststr_solution", vo.getStrprobsol());
			//daoObj.setProcInValue(nProcIndex, "gstr_remarks", vo.getStrremarks());
			daoObj.setProcInValue(nProcIndex, "gstr_remarks",vo.getStrremarks());
			daoObj.setProcInValue(nProcIndex, "hstnum_sol_seatid",vo.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hststr_sol_submit_by",vo.getStrsubmitby());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			//daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
			
								
		} 
	  catch (Exception e) 
	  {
		  		//e.printStackTrace();
		    	vo.setStrMsgString("SolutionDeskDAO.getAcknowledgeVal() --> " +e.getMessage());
				vo.setStrMsgType("1");
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
	
	public static void getAcknowledgeVal(SolutionDeskVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("mms","SolutionDeskDAO");

			strProcName = "{call PKG_MMS_VIEW.Proc_HelpDeskView_Details(?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			////System.out.println("DAOStoreId:"+voObj.getStrStoreId());
			////System.out.println("DAOhosp_code:"+voObj.getStrHospitalCode());
			////System.out.println("DAOtrans No:"+voObj.getStrTransNo());
			////System.out.println("DAOStoreId:");
			daoObj.setProcInValue(nProcIndex, "modval", "1");
			daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "transNo", voObj.getStrTransNo());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			////System.out.println("DAOWS:"+ws);
			if (strErr.equals("")) {

				voObj.setStrAcknowledgeDtlWs(ws);
				

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("SolutionDeskDAO.getAcknowledgeVal() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	public static void getSolViewVal(SolutionDeskVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("mms","SolutionDeskDAO");

			strProcName = "{call PKG_MMS_VIEW.Proc_HelpDeskView_Details(?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			////System.out.println("DAOStoreId:"+voObj.getStrStoreId());
			////System.out.println("DAOhosp_code:"+voObj.getStrHospitalCode());
			////System.out.println("DAOtrans No:"+voObj.getStrTransNo());
			////System.out.println("DAOStoreId:");
			daoObj.setProcInValue(nProcIndex, "modval", "1");
			daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "transNo", voObj.getStrTransNo());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			////System.out.println("DAOWS:"+ws);
			if (strErr.equals("")) {

				voObj.setStrSolViewWs(ws);
				

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("SolutionDeskDAO.getSolViewVal() --> "
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
