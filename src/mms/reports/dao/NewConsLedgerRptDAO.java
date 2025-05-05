package mms.reports.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.reports.vo.NewConsLedgerRptVO;

public class NewConsLedgerRptDAO {
	
	
	public static void getFYCombo(NewConsLedgerRptVO vo) 
    {

            String strproc_name = "";
            HisDAO dao = null;
            int nprocIndex = 0;
            String strerr = "";
            WebRowSet wb = null;
            
            try 
            {
                    dao = new HisDAO("mms", "NewConsLedgerRptDAO");                        
                    
                    strproc_name = "{call PKG_MMS_VIEW2.proc_get_financial_year_combo(?,?,?,?)}";
                    nprocIndex = dao.setProcedure(strproc_name);
                    
                    dao.setProcInValue(nprocIndex, "p_mode", "1");                        
                    dao.setProcInValue(nprocIndex, "p_gnum_hospital_code", vo.getStrHospCode());                        
                    dao.setProcOutValue(nprocIndex, "err", 1);
                    dao.setProcOutValue(nprocIndex, "resultset", 2);

                    dao.executeProcedure(nprocIndex);
                    
                    strerr = dao.getString(nprocIndex, "err");
                    if (strerr == null)
                            strerr = "";

                    wb = dao.getWebRowSet(nprocIndex, "resultset");

                    if (strerr.equals("")) {

                            vo.setStrFYCmbWS(wb);
                    } else {
                            throw new Exception(strerr);
                    }

            } catch (Exception e) 
            {
                    e.printStackTrace();
                    vo.setStrMsgString("NewConsLedgerRptDAO.getFYCombo() --> "
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



	/**
	 * This function is used to fetch Store Combo Detail
	 * @param _NewConsLedgerRptVO
	 */
	public static void setStoreCombo(NewConsLedgerRptVO _NewConsLedgerRptVO)
	{
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		
		try 
		{
				dao = new HisDAO("mms", "NewConsLedgerRptDAO");
		
				strproc_name = "{call pkg_mms_rpt.rptm_hstt_store_mst(?,?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				
				dao.setProcInValue(nprocIndex, "modeval",_NewConsLedgerRptVO.getStrMode(),1);
				dao.setProcInValue(nprocIndex, "seatid",_NewConsLedgerRptVO.getStrSeatId(),2);
				dao.setProcInValue(nprocIndex, "hosp_code", _NewConsLedgerRptVO.getStrHospCode(),3);
				dao.setProcInValue(nprocIndex, "item_category", "0",4);
				dao.setProcOutValue(nprocIndex, "err", 1,5);
				dao.setProcOutValue(nprocIndex, "resultset", 2,6); 
				dao.executeProcedureByPosition(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				if(wb!= null)
				{	
				   if(wb.next())
				   {
					   _NewConsLedgerRptVO.setStrStoreId(wb.getString(1));					   
					   wb.beforeFirst();
				   }
				}				
				if (strerr.equals("")) 
				{
					_NewConsLedgerRptVO.setStrWS(wb);
				} 
				else 
				{
					throw new Exception(strerr);
				}
		} 
		catch (Exception e) 
		{
			_NewConsLedgerRptVO.setStrMsgString("NewConsLedgerRptDAO.setStoreCombo() --> "+ e.getMessage());
			_NewConsLedgerRptVO.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
				wb=null;
			}
		}	
	}
	/**
	 * This function is used to fetch ItemCategory Combo Detail
	 * @param _NewConsLedgerRptVO
	 */
	public static void setItemCategCombo(NewConsLedgerRptVO _NewConsLedgerRptVO)
	{
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		
		try 
		{
				dao = new HisDAO("mms", "NewConsLedgerRptDAO");
				strproc_name = "{call pkg_mms_rpt.Rptm_item_category_list(?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				//System.out.println("modeval"+_NewConsLedgerRptVO.getStrMode());
				dao.setProcInValue(nprocIndex, "modeval",_NewConsLedgerRptVO.getStrMode(),1);
				dao.setProcInValue(nprocIndex, "hosp_code", _NewConsLedgerRptVO.getStrHospCode(),2);
				dao.setProcInValue(nprocIndex, "storeId",_NewConsLedgerRptVO.getStrStoreId(),3);							
				dao.setProcOutValue(nprocIndex, "err", 1,4);
				dao.setProcOutValue(nprocIndex, "resultset", 2,5); 
				
				dao.executeProcedureByPosition(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
				if (strerr.equals("")) 
				{
					_NewConsLedgerRptVO.setItemCategWS(wb);
             	} 
				else 
				{
					throw new Exception(strerr);
				}
		} 
		catch (Exception e) 
		{
			_NewConsLedgerRptVO.setStrMsgString("NewConsLedgerRptDAO.setItemCategCombo() --> "+ e.getMessage());
			_NewConsLedgerRptVO.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
				wb=null;
			}
		}	
	}
	
	
	
	public static void getUserCombo(NewConsLedgerRptVO _NewConsLedgerRptVO)
	{
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		
		try 
		{
				dao = new HisDAO("mms", "NewConsLedgerRptDAO");
				strproc_name = "{call pkg_mms_rpt.Rptm_item_category_list(?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				//System.out.println("modeval"+_NewConsLedgerRptVO.getStrMode());
				dao.setProcInValue(nprocIndex, "modeval",_NewConsLedgerRptVO.getStrMode(),1);
				dao.setProcInValue(nprocIndex, "hosp_code", _NewConsLedgerRptVO.getStrHospCode(),2);
				dao.setProcInValue(nprocIndex, "storeId",_NewConsLedgerRptVO.getStrStoreId(),3);							
				dao.setProcOutValue(nprocIndex, "err", 1,4);
				dao.setProcOutValue(nprocIndex, "resultset", 2,5); 
				
				dao.executeProcedureByPosition(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
				if (strerr.equals("")) 
				{
					_NewConsLedgerRptVO.setItemCategWS(wb);
             	} 
				else 
				{
					throw new Exception(strerr);
				}
		} 
		catch (Exception e) 
		{
			_NewConsLedgerRptVO.setStrMsgString("NewConsLedgerRptDAO.setItemCategCombo() --> "+ e.getMessage());
			_NewConsLedgerRptVO.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
				wb=null;
			}
		}	
	}

	
	public static void getDrugNameCombo(NewConsLedgerRptVO vo)
	{
		
			String strproc_name = "";
			HisDAO dao = null;
			int nprocIndex = 0;
			String strerr = "";
			WebRowSet wb = null;
			try {
				dao = new HisDAO("mms", "DrugInventoryTransDAO");
				//
				strproc_name = "{call PKG_MMS_VIEW.proc_itembrand_list(?,?,?,?,?, ?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
		
				dao.setProcInValue(nprocIndex,  "modeval","1",1);
				dao.setProcInValue(nprocIndex,  "catCode",vo.getStrCategoryNo(),2);
				
				dao.setProcInValue(nprocIndex,  "item_id","0",3);
				dao.setProcInValue(nprocIndex,  "grpId","0",4);
				dao.setProcInValue(nprocIndex,  "subGrpId","0",5);
				dao.setProcInValue(nprocIndex,  "setFlag","0",6);
				
				dao.setProcInValue(nprocIndex,  "hosp_code",vo.getStrHospCode(),7);
				dao.setProcOutValue(nprocIndex, "err", 1,8);
				dao.setProcOutValue(nprocIndex, "resultset", 2,9);
				dao.executeProcedureByPosition(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null)
					strerr = "";
		
				wb = dao.getWebRowSet(nprocIndex, "resultset");
		
				if (strerr.equals(""))
				{
					vo.setStrItemNameComboWS(wb);
		
				} else {
					throw new Exception(strerr);
				}
			} 
			catch (Exception e) 
			{
				vo.setStrMsgString("NewConsLedgerRptDAO.getDrugNameCombo() --> "	+ e.getMessage());
				vo.setStrMsgType("1");
			}
			finally 
			{
				if (dao != null) 
				{
					dao.free();
					dao = null;
				}
			}
	}	
	
	/**
	 * The following procedure is used to populate the value of Already Existing Batch in 
	 * HSTT_DRUG_CURRSTOCK_DTL 
	 * combo using Pkg_Mms_View.proc_supplier_list procedure.
	 * 
	 * 
	 */

	public static void getExistingBatchList(NewConsLedgerRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try 
		{
			dao = new HisDAO("mms", "NewConsLedgerRptDAO");
			strproc_name = "{call PKG_MMS_VIEW.proc_ExistingBatch_list(?,?,?,?,?,?,?)}";
						
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "p_modeval", vo.getStrMode(),1);
			dao.setProcInValue(nprocIndex, "p_HSTNUM_STORE_ID", vo.getStrStoreId(),2);
			dao.setProcInValue(nprocIndex, "p_HSTNUM_ITEM_ID", vo.getStrItemId(),3);
			dao.setProcInValue(nprocIndex, "p_HSTNUM_ITEMBRAND_ID",vo.getStrItemBrandId(),4);
			dao.setProcInValue(nprocIndex, "p_GNUM_HOSPITAL_CODE", vo.getStrHospCode(),5);
			
			dao.setProcOutValue(nprocIndex, "err", 1,6);
			dao.setProcOutValue(nprocIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (strerr.equals("")) 
			{
				vo.setStrExistingBatchComboWS(wb);
			} 
			else 
			{
				throw new Exception(strerr);
			}
		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("NewConsLedgerRptDAO.getExistingBatchList() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
			}
		}
	}
	public static void getHospitalName(NewConsLedgerRptVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_rpt.RPT_GET_HOSPITAL_LIST(?,?,?,?,?)}";
		int nProcIndex = 0;	
		String strErr = "";

		try 
		{
			daoObj = new HisDAO("MMS","NewConsLedgerRptDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval","1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code",voObj.getStrHospCode(),2);
			daoObj.setProcInValue(nProcIndex, "seatId",voObj.getStrSeatId(),3);
			daoObj.setProcOutValue(nProcIndex, "err", 1,4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,5);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) 
			{
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
			voObj.setStrMsgString("NewConsLedgerRptDAO.getHospitalName() --> "+ e.getMessage());
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
	
	public static void getReportData(NewConsLedgerRptVO voObj) //edited recently. Check for any possible errors
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_mms_rpt.proc_consolidated_ledger_dtl_report(?,?,?,?,?,?,?,?,?)}"; //11
		int nProcIndex = 0;	
		String strErr = "";
		
		/*
		 * PROCEDURE proc_consolidated_ledger_dtl_report(modeval character varying DEFAULT '1'::character varying, 
		 * hosp_code character varying DEFAULT NULL::character varying, 
		 * strid character varying DEFAULT NULL::character varying, 
		 * itemcatgid character varying DEFAULT NULL::character varying, 
		 * monthid character varying DEFAULT NULL::character varying, 
		 * financialyear character varying DEFAULT NULL::character varying, 
		 * OUT err character varying, 
		 * OUT resultset refcursor);

		 * */

		try 
		{
			System.out.println("hosp_code"+voObj.getStrHospitalCode());
			System.out.println("strid"+voObj.getStrStoreId());
			System.out.println("itemcatcode"+voObj.getStrCategoryNo());
			System.out.println("month "+voObj.getStrMonth());
			System.out.println("financial year"+voObj.getStrYear());

			daoObj = new HisDAO("MMS","NewConsLedgerRptDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval","1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code",voObj.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "strid",voObj.getStrStoreId(),3);
			daoObj.setProcInValue(nProcIndex, "itemcatgid",voObj.getStrCategoryNo() ,4);
			daoObj.setProcInValue(nProcIndex, "monthid",voObj.getStrMonth(),5);
			daoObj.setProcInValue(nProcIndex, "financialyear",voObj.getStrYear(),6);
			daoObj.setProcInValue(nProcIndex, "item_brand_id","",7);	
			daoObj.setProcOutValue(nProcIndex, "err", 1,8);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,9);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) 
			{
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				voObj.setReportDataWS(ws);				
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("NewConsLedgerRptDAO.getReportData() --> "+ e.getMessage());
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
	
	public static void getDetailedReportData(NewConsLedgerRptVO voObj) //edited recently. Check for any possible errors
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_mms_rpt.proc_consolidated_ledger_dtl_report(?,?,?,?,?, ?, ?,?,?)}"; //11
		int nProcIndex = 0;	
		String strErr = "";
		
		/*
		 * PROCEDURE proc_consolidated_ledger_dtl_report(modeval character varying DEFAULT '1'::character varying, 
		 * hosp_code character varying DEFAULT NULL::character varying, 
		 * strid character varying DEFAULT NULL::character varying, 
		 * itemcatgid character varying DEFAULT NULL::character varying, 
		 * monthid character varying DEFAULT NULL::character varying, 
		 * financialyear character varying DEFAULT NULL::character varying, 
		 * OUT err character varying, 
		 * OUT resultset refcursor);

		 * */

		try 
		{
			System.out.println("hosp_code"+voObj.getStrHospitalCode());
			System.out.println("strid"+voObj.getStrStoreId());
			System.out.println("itemcatcode"+voObj.getStrCategoryNo());
			System.out.println("month "+voObj.getStrMonth());
			System.out.println("financial year"+voObj.getStrYear());

			daoObj = new HisDAO("MMS","NewConsLedgerRptDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval","2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code",voObj.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "strid",voObj.getStrStoreId(),3);
			daoObj.setProcInValue(nProcIndex, "itemcatgid",voObj.getStrCategoryNo() ,4);
			daoObj.setProcInValue(nProcIndex, "monthid",voObj.getStrMonth(),5);
			daoObj.setProcInValue(nProcIndex, "financialyear",voObj.getStrYear(),6);
			daoObj.setProcInValue(nProcIndex, "item_brand_id",voObj.getStrItemBrandId(),7);		//added new condition for filteration
			daoObj.setProcOutValue(nProcIndex, "err", 1,8);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,9);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) 
			{
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				voObj.setReportDataWS(ws);				
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("NewConsLedgerRptDAO.getDetailedReportData() --> "+ e.getMessage());
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
	
}
