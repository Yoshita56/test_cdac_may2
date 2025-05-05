/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
*/
package mms.reports.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.reports.vo.ItemMstforBMEDRptVO;

public class ItemMstforBMEDRptDAO {
	
	/**
	 * This function is used to fetch Store Combo Detail
	 * @param _ItemMstforBMEDRptVO
	 */
	public static void setStoreCombo(ItemMstforBMEDRptVO _ItemMstforBMEDRptVO){
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
				dao.setProcInValue(nprocIndex, "hosp_code", _ItemMstforBMEDRptVO.getStrHospCode(),3);
				dao.setProcInValue(nprocIndex, "seatid",_ItemMstforBMEDRptVO.getStrSeatId(),2);
				dao.setProcInValue(nprocIndex, "item_category","10",4);

				dao.setProcOutValue(nprocIndex, "err",1,5);
				dao.setProcOutValue(nprocIndex, "resultset",2,6); 
				dao.executeProcedureByPosition(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
				if (strerr.equals("")) {
				
					_ItemMstforBMEDRptVO.setStrWS(wb);
             
				} else {
				throw new Exception(strerr);
				}
		} catch (Exception e) {
			_ItemMstforBMEDRptVO.setStrMsgString("IssueToPatientDetailRptDAO.setStoreCombo() --> "
					+ e.getMessage());
			_ItemMstforBMEDRptVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
				wb=null;
			}
		}
	
	}
	
	public static void getDrugNameCombo(ItemMstforBMEDRptVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.rptm_getItemCategoryGroupName(?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";


		System.out.println("-------voObj.getStrItemCategNo()----"+voObj.getStrItemCategNo());
		try {
			daoObj = new HisDAO("MMS Transactions", "StockOnHandRptDAO");
			//
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "p_mode", "1");
			daoObj.setProcInValue(nProcIndex, "p_hstnum_store_id","0");
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
	 * @param _ItemMstforBMEDRptVO
	 */
	public static void setItemCategCombo(ItemMstforBMEDRptVO _ItemMstforBMEDRptVO){
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			
			
			
				dao = new HisDAO("mms", "IssueToPatientDetailRptDAO");
				
				strproc_name = "{call pkg_mms_rpt.Rptm_getItemCategoryCombo(?,?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
			
				dao.setProcInValue(nprocIndex, "modeval","3",1);
				dao.setProcInValue(nprocIndex, "hosp_code", _ItemMstforBMEDRptVO.getStrHospCode(),2);
				dao.setProcInValue(nprocIndex, "storeId","0",3);
				dao.setProcInValue(nprocIndex, "seatId",_ItemMstforBMEDRptVO.getStrSeatId(),4);
				dao.setProcOutValue(nprocIndex, "err", 1,5);
				dao.setProcOutValue(nprocIndex, "resultset", 2,6); 
				dao.executeProcedureByPosition(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
				if (strerr.equals("")) {
				
					_ItemMstforBMEDRptVO.setItemCategWS(wb);
             
				} else {
				throw new Exception(strerr);
				}
		} catch (Exception e) {
			_ItemMstforBMEDRptVO.setStrMsgString("IssueToPatientDetailRptDAO.setItemCategCombo() --> "
					+ e.getMessage());
			_ItemMstforBMEDRptVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
				wb=null;
			}
		}
	
	}
	
	
	public static void getPrintDetails(ItemMstforBMEDRptVO vo) 
	{
			
			String strproc_name = "";
			HisDAO dao = null;
			int nprocIndex = 0;
			String strerr = "";
			WebRowSet ws = null;
			try {
				dao = new HisDAO("mms", "IssueToPatientDetailRptDAO");								
				
				strproc_name = "{call pkg_mms_rpt.rptm_BMED_Item_MST_dtls(?,?,?,?,?, ?)}";

				nprocIndex = dao.setProcedure(strproc_name);	
					
					dao.setProcInValue(nprocIndex,  "modeval", 		   		"1",1);
					dao.setProcInValue(nprocIndex,  "hosp_code", 			vo.getStrHospCode(),2);
					dao.setProcInValue(nprocIndex,  "catcode", 	        	vo.getStrItemCategNo(),3);	
					dao.setProcInValue(nprocIndex,  "brandId", 	        	vo.getStrItemBrandId(),4);
					dao.setProcOutValue(nprocIndex, "err",		 			1,5);
					dao.setProcOutValue(nprocIndex, "resultset", 			2,6);				
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


}
