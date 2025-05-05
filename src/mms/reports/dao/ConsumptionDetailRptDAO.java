/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
*/
package mms.reports.dao;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;
import javax.sql.rowset.WebRowSet;
import mms.reports.vo.ConsumptionDetailRptVO;
import mms.reports.vo.ItemWiseConsumptionRptVO;



public class ConsumptionDetailRptDAO {
	
	/**
	 * This function is used to fetch Store Combo Detail
	 * @param _ConsumptionDetailRptVO
	 */
   public static void setStoreCombo(ConsumptionDetailRptVO _ConsumptionDetailRptVO){
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
				dao = new HisDAO("mms", "ConsumptionDetailRptDAO");
				//
				strproc_name = "{call pkg_mms_rpt.rptm_hstt_store_mst(?,?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				dao.setProcInValue(nprocIndex, "modeval","1",1);
				dao.setProcInValue(nprocIndex, "seatid",_ConsumptionDetailRptVO.getStrSeatId(),2);
				dao.setProcInValue(nprocIndex, "hosp_code", _ConsumptionDetailRptVO.getStrHospCode(),3);
				dao.setProcInValue(nprocIndex, "item_category", "0",4);
				dao.setProcOutValue(nprocIndex, "err", 1,5);
				dao.setProcOutValue(nprocIndex, "resultset", 2,6); 
				dao.executeProcedureByPosition(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
				if (strerr.equals("")) {
				
					_ConsumptionDetailRptVO.setStrWS(wb);
             
				} else {
				throw new Exception(strerr);
				}
		} catch (Exception e) {
			e.printStackTrace();
			_ConsumptionDetailRptVO.setStrMsgString("ConsumptionDetailRptDAO.setStoreCombo() --> "
					+ e.getMessage());
			_ConsumptionDetailRptVO.setStrMsgType("1");
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
	 * @param _ConsumptionDetailRptVO
	 */
	public static void setItemCategCombo(ConsumptionDetailRptVO _ConsumptionDetailRptVO){
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			
			
			
				dao = new HisDAO("mms", "ConsumptionDetailRptDAO");
				//
				strproc_name = "{call pkg_mms_rpt.Rptm_item_category_list(?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				dao.setProcInValue(nprocIndex, "modeval","1",1);
				dao.setProcInValue(nprocIndex, "hosp_code", Config.SUPER_USER_HOSPITAL_CODE ,2);
				dao.setProcInValue(nprocIndex, " storeId",_ConsumptionDetailRptVO.getStrStoreId(),3);
				dao.setProcOutValue(nprocIndex, "err", 1,4);
				dao.setProcOutValue(nprocIndex, "resultset", 2,5); 
				dao.executeProcedureByPosition(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
				if (strerr.equals("")) {
				
					_ConsumptionDetailRptVO.setItemCategWS(wb);
             
				} else {
				throw new Exception(strerr);
				}
		} catch (Exception e) {
			e.printStackTrace();
			_ConsumptionDetailRptVO.setStrMsgString("ConsumptionDetailRptDAO.setItemCategCombo() --> "
					+ e.getMessage());
			_ConsumptionDetailRptVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
				wb=null;
			}
		}
	
	}
	public static void getHospitalName(ConsumptionDetailRptVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_rpt.RPT_GET_HOSPITAL_LIST(?,?,?,?,?)}";
		int nProcIndex = 0;	
		String strErr = "";

		try 
		{
			daoObj = new HisDAO("MMS","ConsumptionDetailRptDAO");
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


}
