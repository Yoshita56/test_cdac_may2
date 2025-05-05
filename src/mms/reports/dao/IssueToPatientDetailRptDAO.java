/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
*/
package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.IssueDetailRptVO_NEW;
import mms.reports.vo.IssueToPatientDetailRptVO;

public class IssueToPatientDetailRptDAO {
	
	/**
	 * This function is used to fetch Store Combo Detail
	 * @param _IssueToPatientDetailRptVO
	 */
	public static void setStoreCombo(IssueToPatientDetailRptVO _IssueToPatientDetailRptVO){
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
				dao = new HisDAO("mms", "IssueToPatientDetailRptDAO");
			//	
				
			/*	(modeval character varying DEFAULT '1'::character varying,
						seatid character varying DEFAULT '0'::character varying, 
						hosp_code character varying DEFAULT '0'::character varying,
						item_category character varying DEFAULT '0'::character varying, 
						OUT err character varying, OUT resultset ahiscl.ahis_type.refcursor) IS*/
				
								strproc_name = "{call pkg_mms_rpt.rptm_hstt_store_mst(?,?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				dao.setProcInValue(nprocIndex, "modeval","1",1);
				dao.setProcInValue(nprocIndex, "hosp_code", _IssueToPatientDetailRptVO.getStrHospCode(),3);
				dao.setProcInValue(nprocIndex, "seatid",_IssueToPatientDetailRptVO.getStrSeatId(),2);
				dao.setProcInValue(nprocIndex, "item_category","10",4);

				dao.setProcOutValue(nprocIndex, "err",1,5);
				dao.setProcOutValue(nprocIndex, "resultset",2,6); 
				dao.executeProcedureByPosition(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
				if (strerr.equals("")) {
				
					_IssueToPatientDetailRptVO.setStrWS(wb);
             
				} else {
				throw new Exception(strerr);
				}
		} catch (Exception e) {
			_IssueToPatientDetailRptVO.setStrMsgString("IssueToPatientDetailRptDAO.setStoreCombo() --> "
					+ e.getMessage());
			_IssueToPatientDetailRptVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
				wb=null;
			}
		}
	
	}
	
	public static void getDrugNameCombo(IssueToPatientDetailRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_get_Drug_list_Combo1(?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";



		try {
			daoObj = new HisDAO("MMS Transactions", "StockOnHandRptDAO");
			//
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "p_mode", "4");
			daoObj.setProcInValue(nProcIndex, "p_hstnum_store_id",voObj.getStrStoreId().equals("")||voObj.getStrStoreId()==null?"0":voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "p_hstnum_item_id", "0");
			daoObj.setProcInValue(nProcIndex, "p_hstnum_itembrand_id", "0");
			daoObj.setProcInValue(nProcIndex, "p_hststr_batch_no", "0");
			daoObj.setProcInValue(nProcIndex, "p_gnum_hospital_code",voObj.getStrHospCode());
			daoObj.setProcInValue(nProcIndex, "p_sstnum_item_cat_no",voObj.getStrItemCategNo());
			daoObj.setProcInValue(nProcIndex, "p_hstnum_stock_status_code","0");
			daoObj.setProcInValue(nProcIndex, "p_hstnum_group_id","0");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);
			daoObj.executeProcedure(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				//System.out.println("no of item"+ws.size());
				voObj.setStrItemNameComboWS(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			e.printStackTrace();
			voObj.setStrMsgString("StockOnHandRptDAO.getDrugList() --> "
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
	 * This function is used to fetch ItemCategory Combo Detail
	 * @param _IssueToPatientDetailRptVO
	 */
	public static void setItemCategCombo(IssueToPatientDetailRptVO _IssueToPatientDetailRptVO){
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			
			
			
				dao = new HisDAO("mms", "IssueToPatientDetailRptDAO");
			//	
				strproc_name = "{call pkg_mms_rpt.Rptm_getItemCategoryCombo(?,?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
			/*	(modeval character varying DEFAULT '1'::character varying, 
						hosp_code character varying DEFAULT '0'::character varying, 
						storeid character varying DEFAULT '0'::character varying, 
						seatid character varying DEFAULT '0'::character varying,
						OUT err character varying,
						OUT resultset ahiscl.ahis_type.refcursor) IS*/
				dao.setProcInValue(nprocIndex, "modeval","1",1);
				dao.setProcInValue(nprocIndex, "hosp_code", _IssueToPatientDetailRptVO.getStrHospCode(),2);
				dao.setProcInValue(nprocIndex, " storeId",_IssueToPatientDetailRptVO.getStrStoreId(),3);
				dao.setProcInValue(nprocIndex, "seatId",_IssueToPatientDetailRptVO.getStrSeatId(),4);
				dao.setProcOutValue(nprocIndex, "err", 1,5);
				dao.setProcOutValue(nprocIndex, "resultset", 2,6); 
				dao.executeProcedureByPosition(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
				if (strerr.equals("")) {
				
					_IssueToPatientDetailRptVO.setItemCategWS(wb);
             
				} else {
				throw new Exception(strerr);
				}
		} catch (Exception e) {
			_IssueToPatientDetailRptVO.setStrMsgString("IssueToPatientDetailRptDAO.setItemCategCombo() --> "
					+ e.getMessage());
			_IssueToPatientDetailRptVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
				wb=null;
			}
		}
	
	}
	
	
	public static void getPrintDetails(IssueToPatientDetailRptVO vo) 
	{
			
			String strproc_name = "";
			HisDAO dao = null;
			int nprocIndex = 0;
			String strerr = "";
			WebRowSet ws = null;
			try {
				dao = new HisDAO("mms", "IssueToPatientDetailRptDAO");								
				System.out.println("..........PKG_MMS_RPT.rptm_patient_issue_return_dtls  .........");
				strproc_name = "{call PKG_MMS_RPT.rptm_patient_issue_return_dtls(?,?,?,?,? ,?,?,?,?,?, ?)}";
				
				//formBean.getStrConsolidatedOrDetailed().equalsIgnoreCase("1") ---  Issue To Patient
				//formBean.getStrConsolidatedOrDetailed().equalsIgnoreCase("2") ---  Return from Patient
				//formBean.getStrConsolidatedOrDetailed().equalsIgnoreCase("3") ---  Date waise Sales & Return  From Patient 
				
				/*
				 * Mode - 1 - Issue To Sub Store
				 * Mode - 2 - Issue To Patient
				 * Mode - 3 - PATIENT WAISE RETURN REPORT  Only For Drug
				 * Mode - 4 - DATE WISE NET SALE REPORT ONLY FOR PATIENT AND DRUG
				 * 
				 * */
				
				nprocIndex = dao.setProcedure(strproc_name);	
				if(vo.getStrConsolidatedOrDetailed().equalsIgnoreCase("2"))
				{	
					dao.setProcInValue(nprocIndex,  "modeval", 		   		"2",1);
				}
				if(vo.getStrConsolidatedOrDetailed().equalsIgnoreCase("3"))
				{	
					dao.setProcInValue(nprocIndex,  "modeval", 		   		"3",1);
				}
				if(vo.getStrConsolidatedOrDetailed().equalsIgnoreCase("4"))
				{	
					dao.setProcInValue(nprocIndex,  "modeval", 		   		"4",1);
				}
					dao.setProcInValue(nprocIndex,  "hosp_code", 			vo.getStrHospCode(),2);
					dao.setProcInValue(nprocIndex,  "strid", 		    	vo.getStrStoreId(),3);
					dao.setProcInValue(nprocIndex,  "catcode", 	        	vo.getStrItemCategNo(),4);					
					dao.setProcInValue(nprocIndex,  "frmdate", 	        	vo.getStrFromDate(),5);	
					dao.setProcInValue(nprocIndex,  "todate", 	        	vo.getStrToDate(),6);	
					dao.setProcInValue(nprocIndex,  "p_reportcriteriaflag", (vo.getStrItemBrandId() == null || vo.getStrItemBrandId().equals(""))?"0":vo.getStrItemBrandId(),7);	
					dao.setProcInValue(nprocIndex,  "dossierflag", 			"0",8);	
					dao.setProcInValue(nprocIndex,  "crno", 			    vo.getStrCrNo(),9);	
					dao.setProcOutValue(nprocIndex, "err",		 			1,10);
					dao.setProcOutValue(nprocIndex, "resultset", 			2,11);				
					dao.executeProcedureByPosition(nprocIndex);
				
					strerr = dao.getString(nprocIndex, "err");
					if (strerr == null)
						strerr = "";
		
					if (strerr.equals("")) {
						ws = dao.getWebRowSet(nprocIndex, "resultset");		
						vo.setWsPrint(ws);							
					} else {
						throw new Exception(strerr);
					}	
	
			} catch (Exception e) {
				vo.setStrMsgString("IssueToPatientDetailRptDAO.getPrintDetails() --> "
						+ e.getMessage());
				vo.setStrMsgType("1");
			} finally {
				if (dao != null) {
					dao.free();
					dao = null;
				}
			}
		}
	
	public static void getImageHeader(IssueToPatientDetailRptVO vo)
	{
		String strFuncName = "";
		String strLogoName = "";
		
		int nFuncIndex = 0;
		HisDAO dao = null;
		try 
		{
			dao = new HisDAO("DWH","IssueToPatientDetailRptDAO");
			
			strFuncName = "{? = call MMS_MST.logo_config_dtl(?,?)}";
			nFuncIndex = dao.setFunction(strFuncName);
			
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, vo.getStrHospCode());
			dao.setFuncOutValue(nFuncIndex, 1);
			
			dao.executeFunction(nFuncIndex);
			
			strLogoName = dao.getFuncString(nFuncIndex);
			vo.setStrLogoName(strLogoName);

		} catch (Exception e) {
			
			e.printStackTrace();
			vo.setStrMsgType("1");
			vo.setStrMsgString("IssueToPatientDetailRptDAO.getImageHeader() --> "+ e.getMessage());
			
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}
		}	
	}


}
