/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
*/
package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.IssuePatDetailRptVO;

public class IssuePatDetailRptDAO {
	
	/**
	 * This function is used to fetch Store Combo Detail
	 * @param _IssuePatDetailRptVO
	 */
	public static void setStoreCombo(IssuePatDetailRptVO _IssuePatDetailRptVO){
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
				dao = new HisDAO("mms", "IssuePatDetailRptDAO");
				
				strproc_name = "{call pkg_mms_rpt.rptm_hstt_store_mst(?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				dao.setProcInValue(nprocIndex, "modeval","3");
				dao.setProcInValue(nprocIndex, "hosp_code", _IssuePatDetailRptVO.getStrHospCode());
				dao.setProcInValue(nprocIndex, "seatid",_IssuePatDetailRptVO.getStrSeatId());
				dao.setProcOutValue(nprocIndex, "err", 1);
				dao.setProcOutValue(nprocIndex, "resultset", 2); 
				dao.executeProcedure(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
				if (strerr.equals("")) {
				
					_IssuePatDetailRptVO.setStrWS(wb);
             
				} else {
				throw new Exception(strerr);
				}
		} catch (Exception e) {
			_IssuePatDetailRptVO.setStrMsgString("IssuePatDetailRptDAO.setStoreCombo() --> "
					+ e.getMessage());
			_IssuePatDetailRptVO.setStrMsgType("1");
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
	 * @param _IssuePatDetailRptVO
	 */
	public static void setItemCategCombo(IssuePatDetailRptVO _IssuePatDetailRptVO){
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			
			
			
				dao = new HisDAO("mms", "IssuePatDetailRptDAO");
				
				strproc_name = "{call pkg_mms_rpt.Rptm_item_category_list(?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				
				dao.setProcInValue(nprocIndex, "modeval","2");
				dao.setProcInValue(nprocIndex, "hosp_code", _IssuePatDetailRptVO.getStrHospCode());
				dao.setProcInValue(nprocIndex, " storeId",_IssuePatDetailRptVO.getStrStoreId());
							
				dao.setProcOutValue(nprocIndex, "err", 1);
				dao.setProcOutValue(nprocIndex, "resultset", 2); 
				
				
				dao.executeProcedure(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
				if (strerr.equals("")) {
				
					_IssuePatDetailRptVO.setItemCategWS(wb);
             
				} else {
				throw new Exception(strerr);
				}
		} catch (Exception e) {
			_IssuePatDetailRptVO.setStrMsgString("IssuePatDetailRptDAO.setItemCategCombo() --> "
					+ e.getMessage());
			_IssuePatDetailRptVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
				wb=null;
			}
		}
	
	}


}
