package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.AcknowledgeTransVO;
import mms.transactions.vo.HelpDeskVO;

/* @author 

* Developer : Brahmam Veluguri( TO CONTINUE AND CORRECTIONS)
* Version : 1.0 Date : 02/Jul/2012
* 
*/





public class HelpDeskDAO {
	

	public static void inserthelp(HelpDeskVO vo) 
	{

		String    strProcName = "";
		int        nProcIndex = 0;
		HisDAO         daoObj = null;
	  try 
		{
			     daoObj = new HisDAO("MMS", "HelpDeskDAO");
			strProcName = "{call PKG_MMS_DML.proc_hstt_help_desk_mst_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // 13 Variable

			nProcIndex = daoObj.setProcedure(strProcName);				
			
			
			////System.out.println("hstnum_store_id"+ vo.getStrStoreId()); //1
			////System.out.println("hstnum_deptcode"+vo.getStrGroupId());
			////System.out.println("gnum_menu_id"+ vo.getStrMenuId());//2
			////System.out.println("hstnum_status_flag"+ vo.getStrstatusid()); //3
			////System.out.println("hststr_prob_sub"+ vo.getStrprobsub());  //4
			////System.out.println("hststr_prob_desc"+  vo.getStrprobdesc()); //5
			////System.out.println("hstnum_priority"+ vo.getStrpriority());    //6
			////System.out.println("gnum_seatid"+ vo.getStrSeatId());             //7
			////System.out.println("gnum_hospital_code"+ vo.getStrHospitalCode());  //8    
			////System.out.println("hststr_submitted_by"+  vo.getStrsubmitby()); //9
			////System.out.println("gnum_isvalid"+ vo.getStrSeatId()); //10
			////System.out.println("File No"+  vo.getStrFileNo());
			////System.out.println("Page No"+  vo.getStrPageNo());
			////System.out.println("File Name"+  vo.getStrFileName());
			
			
			
			daoObj.setProcInValue(nProcIndex, "modval", "1");
			daoObj.setProcInValue(nProcIndex, "hstnum_store_id", vo.getStrStoreId()); 
			daoObj.setProcInValue(nProcIndex, "gnum_menu_id", vo.getStrMenuId());
			daoObj.setProcInValue(nProcIndex, "hstnum_status_flag", vo.getStrstatusid()); 
			daoObj.setProcInValue(nProcIndex, "hststr_prob_sub", vo.getStrprobsub());  
			daoObj.setProcInValue(nProcIndex, "hststr_prob_desc", vo.getStrprobdesc()); 
			daoObj.setProcInValue(nProcIndex, "hstnum_priority", vo.getStrpriority());    
			daoObj.setProcInValue(nProcIndex, "gnum_seatid", vo.getStrSeatId());             
			daoObj.setProcInValue(nProcIndex, "gnum_hospital_code", vo.getStrHospitalCode()); 
			daoObj.setProcInValue(nProcIndex, "hststr_submitted_by", vo.getStrsubmitby());
			daoObj.setProcInValue(nProcIndex, "gnum_isvalid", "1");
			daoObj.setProcInValue(nProcIndex, "hststr_dept_code",vo.getStrGroupId());
			daoObj.setProcInValue(nProcIndex, "hstnum_fileno",vo.getStrFileNo());
			daoObj.setProcInValue(nProcIndex, "hstnum_pageno",vo.getStrPageNo());
			daoObj.setProcInValue(nProcIndex, "hststr_filename",vo.getStrFileName());

			daoObj.setProcOutValue(nProcIndex, "err", 1);   

			daoObj.executeProcedure(nProcIndex);
			
								
		} 
	  catch (Exception e) 
	  {
		  		//e.printStackTrace();
		    	vo.setStrMsgString("HelpDeskDAO.getAcknowledgeVal() --> " +e.getMessage());
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
	
	public static void getAcknowledgeVal(HelpDeskVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("mms","AcknowledgeTransDAO");

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
					.setStrMsgString("HelpDeskDAO.getAcknowledgeVal() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getTransNo(HelpDeskVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("mms","HelpDeskDAO");

			strProcName = "{call PKG_MMS_VIEW.Proc_gettransno(?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			////System.out.println("transStoreId:"+voObj.getStrStoreId());
			////System.out.println("transhosp_code:"+voObj.getStrHospitalCode());
			////System.out.println("DAOtrans No:"+voObj.getStrTransNo());
			////System.out.println("DAOStoreId:");
			daoObj.setProcInValue(nProcIndex, "modval", "1");
			daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			//daoObj.setProcInValue(nProcIndex, "transNo", voObj.getStrTransNo());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			////System.out.println("DAOWS:"+ws);
			if (strErr.equals("")) {
                //System.out.println("StrErr is Entered");
				voObj.setStrTransnoWs(ws);
				

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("HelpDeskDAO.getAcknowledgeVal() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getFileName(HelpDeskVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("mms","HelpDeskDAO");

			strProcName = "{call PKG_MMS_VIEW.proc_getfilename(?,?,?,?,?,?)}";
			nProcIndex = daoObj.setProcedure(strProcName);

			////System.out.println("transStoreId:"+voObj.getStrStoreId());
			////System.out.println("transhosp_code:"+voObj.getStrHospitalCode());
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
               // //System.out.println("StrErr is Entered");
				voObj.setStrFilenameWs(ws);
				

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("HelpDeskDAO.getAcknowledgeVal() --> "
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
