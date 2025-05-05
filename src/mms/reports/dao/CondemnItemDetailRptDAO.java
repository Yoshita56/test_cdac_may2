/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
*/
package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.CondemnItemDetailRptVO;


public class CondemnItemDetailRptDAO {
	public static void setItemCategCombo(CondemnItemDetailRptVO _CondemnItemDetailRptVO){
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			
			
			
				dao = new HisDAO("mms", "CondemnItemDetailRptDAO");
				
				strproc_name = "{call pkg_mms_rpt.Rptm_item_category_list(?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				dao.setProcInValue(nprocIndex, "modeval","1");
				dao.setProcInValue(nprocIndex, "hosp_code", _CondemnItemDetailRptVO.getStrHospCode());
				dao.setProcOutValue(nprocIndex, "err", 1);
				dao.setProcOutValue(nprocIndex, "resultset", 2); 
				dao.executeProcedure(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
				if (strerr.equals("")) {
				
					_CondemnItemDetailRptVO.setItemCategWS(wb);
             
				} else {
				throw new Exception(strerr);
				}
		} catch (Exception e) {
			_CondemnItemDetailRptVO.setStrMsgString("CondemnItemDetailRptDAO.setItemCategCombo() --> "
					+ e.getMessage());
			_CondemnItemDetailRptVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
				wb=null;
			}
		}
	
	}
}
