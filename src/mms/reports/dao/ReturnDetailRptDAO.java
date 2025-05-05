/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
*/
package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.ReturnDetailRptVO;

public class ReturnDetailRptDAO {
	/**
	 * This function is used to fetch Store Combo Detail
	 * @param _IssueDetailRptVO
	
	 */
	
	public static void getHospitalName(ReturnDetailRptVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_rpt.RPT_GET_HOSPITAL_LIST(?,?,?,?,?)}";
		int nProcIndex = 0;	
		String strErr = "";

		try 
		{
			daoObj = new HisDAO("MMS","ItemWiseConsumptionRptDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue( nProcIndex, "modeval","1",1);
			daoObj.setProcInValue( nProcIndex, "hosp_code",voObj.getStrHospCode(),2);
			daoObj.setProcInValue( nProcIndex, "seatId",voObj.getStrSeatId(),3);
			daoObj.setProcOutValue(nProcIndex, "err", 1,4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,5);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

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
			voObj.setStrMsgString("ItemWiseConsumptionRptDAO.getHospitalName() --> "+ e.getMessage());
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
	
	
	
	
	
	public static void setStoreCombo(ReturnDetailRptVO _ReturnDetailRptVO){
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
				dao = new HisDAO("mms", "IssueDetailRptDAO");
			//	
				strproc_name = "{call Pkg_Mms_Rpt.rptm_hstt_store_mst(?,?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);

				dao.setProcInValue(nprocIndex, "modeval", "5",1);
				dao.setProcInValue(nprocIndex, "seatid", _ReturnDetailRptVO.getStrSeatId(),2);
				dao.setProcInValue(nprocIndex, "hosp_code", _ReturnDetailRptVO.getStrHospCode(),3);
				dao.setProcInValue(nprocIndex, "item_category", _ReturnDetailRptVO.getStrItemCatId(),4);
				dao.setProcOutValue(nprocIndex, "err", 1,5);
				dao.setProcOutValue(nprocIndex, "resultset", 2,6); 
				dao.executeProcedureByPosition(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				//System.out.println("size"+wb.size());
				if (strerr.equals("")) {
				
					_ReturnDetailRptVO.setStrStoreWs(wb);
             
				} else {
				throw new Exception(strerr);
				}
		} catch (Exception e) {
			e.printStackTrace();
			_ReturnDetailRptVO.setStrMsgString("IssueDetailRptDAO.setStoreCombo() --> "
					+ e.getMessage());
			_ReturnDetailRptVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
				wb=null;
			}
		}
	
	}
	/**
	 * This function is used to fetch ItemCategory Combo Detail
	 * @param _ReturnDetailRptVO
	 */
	public static void setItemCategCombo(ReturnDetailRptVO _ReturnDetailRptVO){
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			
			
			
				dao = new HisDAO("mms", "IssueDetailRptDAO");
			//	
				strproc_name = "{call pkg_mms_rpt.Rptm_item_category_list(?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				dao.setProcInValue(nprocIndex, "modeval","2",1);
				dao.setProcInValue(nprocIndex, "hosp_code", _ReturnDetailRptVO.getStrHospCode(),2);
				dao.setProcInValue(nprocIndex, " storeId",_ReturnDetailRptVO.getStrStoreId(),3);
				dao.setProcOutValue(nprocIndex, "err", 1,4);
				dao.setProcOutValue(nprocIndex, "resultset", 2,5); 
				dao.executeProcedureByPosition(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
				if (strerr.equals("")) {
				
					_ReturnDetailRptVO.setItemCategWS(wb);
             
				} else {
				throw new Exception(strerr);
				}
		} catch (Exception e) {
			_ReturnDetailRptVO.setStrMsgString("IssueDetailRptDAO.setItemCategCombo() --> "
					+ e.getMessage());
			_ReturnDetailRptVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
				wb=null;
			}
		}
	
	}

}
