/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
*/
package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.IssueDetailRptVO;
import mms.reports.vo.ItemWiseConsumptionRptVO;

public class ItemInventoryRptDAO {
	
	/**
	 * This function is used to fetch Store Combo Detail
	 * @param _IssueDetailRptVO
	 */
	public static void setStoreCombo(IssueDetailRptVO _IssueDetailRptVO)
	{
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		
		try 
		{
				dao = new HisDAO("mms", "IssueDetailRptDAO");
		
				strproc_name = "{call pkg_mms_rpt.rptm_hstt_store_mst(?,?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				
				dao.setProcInValue(nprocIndex, "modeval",_IssueDetailRptVO.getStrMode(),1);
				dao.setProcInValue(nprocIndex, "seatid",_IssueDetailRptVO.getStrSeatId(),2);
				dao.setProcInValue(nprocIndex, "hosp_code", _IssueDetailRptVO.getStrHospCode(),3);
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
					   _IssueDetailRptVO.setStrStoreId(wb.getString(1));					   
					   wb.beforeFirst();
				   }
				}				
				if (strerr.equals("")) 
				{
					_IssueDetailRptVO.setStrWS(wb);
				} 
				else 
				{
					throw new Exception(strerr);
				}
		} 
		catch (Exception e) 
		{
			_IssueDetailRptVO.setStrMsgString("IssueDetailRptDAO.setStoreCombo() --> "+ e.getMessage());
			_IssueDetailRptVO.setStrMsgType("1");
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
	 * @param _IssueDetailRptVO
	 */
	public static void setItemCategCombo(IssueDetailRptVO _IssueDetailRptVO)
	{
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		
		try 
		{
				dao = new HisDAO("mms", "IssueDetailRptDAO");
				strproc_name = "{call pkg_mms_rpt.Rptm_item_category_list(?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				//System.out.println("modeval"+_IssueDetailRptVO.getStrMode());
				dao.setProcInValue(nprocIndex, "modeval",_IssueDetailRptVO.getStrMode(),1);
				dao.setProcInValue(nprocIndex, "hosp_code", _IssueDetailRptVO.getStrHospCode(),2);
				dao.setProcInValue(nprocIndex, "storeId",_IssueDetailRptVO.getStrStoreId(),3);							
				dao.setProcOutValue(nprocIndex, "err", 1,4);
				dao.setProcOutValue(nprocIndex, "resultset", 2,5); 
				
				dao.executeProcedureByPosition(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
				if (strerr.equals("")) 
				{
					_IssueDetailRptVO.setItemCategWS(wb);
             	} 
				else 
				{
					throw new Exception(strerr);
				}
		} 
		catch (Exception e) 
		{
			_IssueDetailRptVO.setStrMsgString("IssueDetailRptDAO.setItemCategCombo() --> "+ e.getMessage());
			_IssueDetailRptVO.setStrMsgType("1");
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
	
	
	
	public static void getUserCombo(IssueDetailRptVO _IssueDetailRptVO)
	{
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		
		try 
		{
				dao = new HisDAO("mms", "IssueDetailRptDAO");
				strproc_name = "{call pkg_mms_rpt.get_User_list(?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				//System.out.println("modeval"+_IssueDetailRptVO.getStrMode());
				dao.setProcInValue(nprocIndex, "modeval",_IssueDetailRptVO.getStrMode(),1);
				dao.setProcInValue(nprocIndex, "hosp_code", _IssueDetailRptVO.getStrHospCode(),2);
				dao.setProcInValue(nprocIndex, "storeId",_IssueDetailRptVO.getStrStoreId(),3);							
				dao.setProcOutValue(nprocIndex, "err", 1,4);
				dao.setProcOutValue(nprocIndex, "resultset", 2,5); 
				
				dao.executeProcedureByPosition(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
				if (strerr.equals("")) 
				{
					_IssueDetailRptVO.setItemCategWS(wb);
             	} 
				else 
				{
					throw new Exception(strerr);
				}
		} 
		catch (Exception e) 
		{
			_IssueDetailRptVO.setStrMsgString("IssueDetailRptDAO.setItemCategCombo() --> "+ e.getMessage());
			_IssueDetailRptVO.setStrMsgType("1");
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

	
	public static void getDrugNameCombo(IssueDetailRptVO vo)
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
				vo.setStrMsgString("IssueDetailRptDAO.getDrugNameCombo() --> "	+ e.getMessage());
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

	public static void getExistingBatchList(IssueDetailRptVO vo) 
	{

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try 
		{
			dao = new HisDAO("mms", "IssueDetailRptDAO");
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
			vo.setStrMsgString("IssueDetailRptDAO.getExistingBatchList() --> "+ e.getMessage());
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
	public static void getHospitalName(IssueDetailRptVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_rpt.RPT_GET_HOSPITAL_LIST(?,?,?,?,?)}";
		int nProcIndex = 0;	
		String strErr = "";

		try 
		{
			daoObj = new HisDAO("MMS","IssueDetailRptDAO");
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
			voObj.setStrMsgString("IssueDetailRptDAO.getHospitalName() --> "+ e.getMessage());
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