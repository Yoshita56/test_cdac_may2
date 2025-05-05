/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
 */
package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.reports.vo.IssueDetailRptVO_NEW;
import mms.reports.vo.ListConsumablesExpiryDateRptVO;
import mms.reports.vo.PendingIndentStatusRecordRptVO;
import mms.reports.vo.StockOnHandRptVO_NEW;

// TODO: Auto-generated Javadoc
/**
 * The Class IssueDetailRptDAO.
 */
public class IssueDetailRptDAO_NEW {

	/**
	 * This function is used to fetch Store Combo Detail.
	 * 
	 * @param _IssueDetailRptVO_NEW
	 *            the new store combo
	 */
	/*public static void setStoreCombo(IssueDetailRptVO_NEW _IssueDetailRptVO_NEW) {
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "IssueDetailRptDAO");
			//
			strproc_name = "{call pkg_mms_rpt.rptm_hstt_store_mst(?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nprocIndex, "modeval",
					_IssueDetailRptVO_NEW.getStrMode());
			dao.setProcInValue(nprocIndex, "seatid",
					_IssueDetailRptVO_NEW.getStrSeatId());
			dao.setProcInValue(nprocIndex, "hosp_code",
					_IssueDetailRptVO_NEW.getStrHospCode());
			dao.setProcInValue(nprocIndex, "item_category", "10");

			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");
			if (wb != null) {
				if (wb.next()) {
					_IssueDetailRptVO_NEW.setStrStoreId(wb.getString(1));

					wb.beforeFirst();
				}
			}

			if (strerr.equals("")) {

				_IssueDetailRptVO_NEW.setStrWS(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			_IssueDetailRptVO_NEW
					.setStrMsgString("IssueDetailRptDAO.setStoreCombo() --> "
							+ e.getMessage());
			_IssueDetailRptVO_NEW.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
				wb = null;
			}
		}

	}*/
	
	public static void setStoreCombo(IssueDetailRptVO_NEW _IssueDetailRptVO_NEW) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.rptm_hstt_store_mst(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","IssueDetailRptDAO_NEW");
		//	
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "seatId", _IssueDetailRptVO_NEW.getStrSeatId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", _IssueDetailRptVO_NEW.getStrHospCode(),3);
			daoObj.setProcInValue(nProcIndex, "item_category", "0",4);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("ws"+ws.size());
			if (ws != null) {
				if (ws.next()) {
					_IssueDetailRptVO_NEW.setStrStoreId(ws.getString(1));

					ws.beforeFirst();
				}
			}

			if (strErr.equals("")) {

				_IssueDetailRptVO_NEW.setStrWS(ws);

							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			_IssueDetailRptVO_NEW
					.setStrMsgString("IssueDetailRptDAO_NEW.getStoreList() --> "
							+ e.getMessage());
			_IssueDetailRptVO_NEW.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	/**
	 * This function is used to fetch ItemCategory Combo Detail.
	 * 
	 * @param _IssueDetailRptVO_NEW
	 *            the new item categ combo
	 */
	/*public static void setItemCategCombo(IssueDetailRptVO_NEW _IssueDetailRptVO_NEW) {
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
			dao.setProcInValue(nprocIndex, "modeval",
					_IssueDetailRptVO_NEW.getStrMode());
			dao.setProcInValue(nprocIndex, "hosp_code",
					_IssueDetailRptVO_NEW.getStrHospCode());
			dao.setProcInValue(nprocIndex, " storeId",
					_IssueDetailRptVO_NEW.getStrStoreId());

			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");

			if (strerr.equals("")) {

				_IssueDetailRptVO_NEW.setItemCategWS(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			_IssueDetailRptVO_NEW
					.setStrMsgString("IssueDetailRptDAO.setItemCategCombo() --> "
							+ e.getMessage());
			_IssueDetailRptVO_NEW.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
				wb = null;
			}
		}

	}*/
	public static void setItemCategCombo(IssueDetailRptVO_NEW _IssueDetailRptVO_NEW) {

			HisDAO daoObj = null;
			WebRowSet ws = null;
			int nprocIndex = 0;
			String strErr = "";
			try
			{daoObj = new HisDAO("mms", "IssueDetailRptDAO_NEW");
			String strProcName = "{call pkg_mms_rpt.Rptm_item_category_list(?,?,?,?,?)}";
			nprocIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nprocIndex, "modeval","2",1);
			daoObj.setProcInValue(nprocIndex, "hosp_code", _IssueDetailRptVO_NEW.getStrHospCode(),2);
			daoObj.setProcInValue(nprocIndex, "storeId",_IssueDetailRptVO_NEW.getStrStoreId(),3);							
			daoObj.setProcOutValue(nprocIndex, "err", 1,4);
			daoObj.setProcOutValue(nprocIndex, "resultset", 2,5); 
			
			daoObj.executeProcedureByPosition(nprocIndex);
			strErr = daoObj.getString(nprocIndex, "err");

				if (strErr == null)
					strErr = "";

				if (strErr.equals("")) {

					ws = daoObj.getWebRowSet(nprocIndex, "resultset");
			
					_IssueDetailRptVO_NEW.setItemCategWS(ws);
								
				} else {
					throw new Exception(strErr);
				}

			} catch (Exception e) {

				_IssueDetailRptVO_NEW
						.setStrMsgString("IssueDetailRptDAO_NEW.getItemCatList() --> "
								+ e.getMessage());
				_IssueDetailRptVO_NEW.setStrMsgType("1");

			} finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
			
			}
	

	/**
	 * Gets the drug name combo.
	 * 
	 * @param vo
	 *            the vo
	 * @return the drug name combo
	 */
	/*public static void getDrugNameCombo(IssueDetailRptVO_NEW vo) {

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

			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "catCode", vo.getStrCategoryNo());

			dao.setProcInValue(nprocIndex, "item_id", "0");
			dao.setProcInValue(nprocIndex, "grpId", "0");
			dao.setProcInValue(nprocIndex, "subGrpId", "0");
			dao.setProcInValue(nprocIndex, "setFlag", "0");

			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospCode());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");

			if (strerr.equals("")) {
				vo.setStrItemNameComboWS(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			vo.setStrMsgString("IssueDetailRptDAO.getDrugNameCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}*/

	/**
	 * The following procedure is used to populate the value of Already Existing
	 * Batch in HSTT_DRUG_CURRSTOCK_DTL combo using
	 * Pkg_Mms_View.proc_supplier_list procedure.
	 * 
	 * @param vo
	 *            the vo
	 * @return the existing batch list
	 */
	public static void getDrugNameCombo(IssueDetailRptVO_NEW voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_get_Drug_list_Combo1(?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";



		try {
			daoObj = new HisDAO("MMS Transactions", "IssueDetailRptDAO_NEW");
			//
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "p_mode", "4");
			daoObj.setProcInValue(nProcIndex, "p_hstnum_store_id",voObj.getStrStoreId().equals("")||voObj.getStrStoreId()==null?"0":voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "p_hstnum_item_id", "0");
			daoObj.setProcInValue(nProcIndex, "p_hstnum_itembrand_id", "0");
			daoObj.setProcInValue(nProcIndex, "p_hststr_batch_no", "0");
			daoObj.setProcInValue(nProcIndex, "p_gnum_hospital_code",voObj.getStrHospCode());
			daoObj.setProcInValue(nProcIndex, "p_sstnum_item_cat_no",voObj.getStrCategoryNo());
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
			voObj.setStrMsgString("IssueDetailRptDAO_NEW.getDrugList() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void getExistingBatchList(IssueDetailRptVO_NEW vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "IssueDetailRptDAO_NEW");
			//
			strproc_name = "{call PKG_MMS_RPT.proc_existingbatch_list(?,?,?,?,?,?,?,?)}";

			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "p_modeval", vo.getStrMode(),1);
			dao.setProcInValue(nprocIndex, "p_hstnum_store_id",vo.getStrStoreId(),2);
			dao.setProcInValue(nprocIndex, "p_hstnum_item_id",vo.getStrItemId(),3);
			dao.setProcInValue(nprocIndex, "p_hstnum_itembrand_id",vo.getStrItemBrandId(),4);
			dao.setProcInValue(nprocIndex, "p_gnum_hospital_code",vo.getStrHospCode(),5);
			dao.setProcInValue(nprocIndex, "catcode",vo.getStrCategoryNo(),6);

			dao.setProcOutValue(nprocIndex, "err", 1,7);
			dao.setProcOutValue(nprocIndex, "resultset", 2,8);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			wb = dao.getWebRowSet(nprocIndex, "resultset");
			//System.out.println("wb"+wb.size());
			if (strerr.equals("")) {
				
				vo.setStrExistingBatchComboWS(wb);

			} else {
				throw new Exception(strerr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IssueDetailRptDAO_NEW.getExistingBatchList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/**
	 * Gets the programme combo.
	 * 
	 * @param vo
	 *            the vo
	 * @return the programme combo
	 */
	public static void getProgrammeCombo(IssueDetailRptVO_NEW vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "IssueDetailRptDAO_NEW");
			strproc_name = "{call PKG_MMS_VIEW.proc_programme_list(?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);

			dao.setProcInValue(nprocIndex, "modeval", "2");
			dao.setProcInValue(nprocIndex, "storeid", vo.getStrStoreId());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospCode());
			dao.setProcInValue(nprocIndex, "seatid", vo.getStrSeatId());
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);

			dao.executeProcedure(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");

			if (strerr.equals("")) {

				vo.setStrProgNameComboWS(wb);

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IssueDetailRptDAO_NEW.getProgrammeCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void showReportNew(IssueDetailRptVO_NEW vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "IssueDetailRptDAO_NEW");
			strproc_name = "{call PKG_MMS_RPT.proc_rpt_issue_dtls(?,?,?,?,?,  ?,?,?,?,?,   ?)}"; //11
			nprocIndex = dao.setProcedure(strproc_name);
			System.out.println(" vo.getStrStoreId() ---"+  vo.getStrStoreId());
			System.out.println(" vo.getStrItemId() ---"+  vo.getStrItemId());
			System.out.println(" vo.getStrBatchhNo() ---"+  vo.getStrBatchhNo());
			System.out.println(" vo.getStrCategoryNo() ---"+  vo.getStrCategoryNo());
			System.out.println(" vo.getStrFromDate() ---"+  vo.getStrFromDate());
			System.out.println(" vo.getStrToDate() ---"+  vo.getStrToDate());
			System.out.println(" vo.getStrProgramId() ---"+  vo.getStrProgramId());
			
			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospCode(),2);
			dao.setProcInValue(nprocIndex, "strid", vo.getStrStoreId(),3);
			dao.setProcInValue(nprocIndex, "itemid", "0",4);
			dao.setProcInValue(nprocIndex, "batchno", "0",5);
			dao.setProcInValue(nprocIndex, "catcode", vo.getStrCategoryNo(),6);
			dao.setProcInValue(nprocIndex, "frmdate", vo.getStrFromDate(),7);
			dao.setProcInValue(nprocIndex, "todate", vo.getStrToDate(),8);
			dao.setProcInValue(nprocIndex, "prog_id", "0",9);
			dao.setProcOutValue(nprocIndex, "err", 1,10);
			dao.setProcOutValue(nprocIndex, "resultset", 2,11);

			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			wb = dao.getWebRowSet(nprocIndex, "resultset");

			if (strerr.equals("")) {

				vo.setReportDataWS(wb);

			} else {
				throw new Exception(strerr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IssueDetailRptDAO_NEW.showReportNew() --> "
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
