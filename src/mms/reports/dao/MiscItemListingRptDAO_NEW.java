/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
 */
package mms.reports.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.MmsConfigUtil;
import mms.reports.vo.MiscItemListingRptVO_NEW;

// TODO: Auto-generated Javadoc
/**
 * The Class IssueDetailRptDAO.
 */
public class MiscItemListingRptDAO_NEW
{

	
	public static void setStoreCombo(MiscItemListingRptVO_NEW _IssueDetailRptVO_NEW) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.rptm_hstt_store_mst(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","ListConsumablesExpiryDateRptDAO");
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
			System.out.println("ws setStoreCombo->"+ws.size());
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
					.setStrMsgString("ListConsumablesExpiryDateRptDAO.getStoreList() --> "
							+ e.getMessage());
			_IssueDetailRptVO_NEW.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void setItemCategCombo(MiscItemListingRptVO_NEW _IssueDetailRptVO_NEW) {

			HisDAO daoObj = null;
			WebRowSet ws = null;
			int nprocIndex = 0;
			String strErr = "";
			try
			{daoObj = new HisDAO("mms", "PendingIndentStatusRecordRptDAO");
			String strProcName = "{call pkg_mms_rpt.Rptm_item_category_list(?,?,?,?,?)}";
			nprocIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nprocIndex, "modeval","1",1);
			daoObj.setProcInValue(nprocIndex, "hosp_code","100",2);
			daoObj.setProcInValue(nprocIndex, "storeId","0",3);							
			daoObj.setProcOutValue(nprocIndex, "err", 1,4);
			daoObj.setProcOutValue(nprocIndex, "resultset", 2,5); 
			
			daoObj.executeProcedureByPosition(nprocIndex);
			strErr = daoObj.getString(nprocIndex, "err");

				if (strErr == null)
					strErr = "";

				if (strErr.equals("")) {

					ws = daoObj.getWebRowSet(nprocIndex, "resultset");
					System.out.println("ws setItemCategCombo->"+ws.size());

					_IssueDetailRptVO_NEW.setItemCategWS(ws);
								
				} else {
					throw new Exception(strErr);
				}

			} catch (Exception e) {

				_IssueDetailRptVO_NEW
						.setStrMsgString("StockReceiptRegisterRptDAO.getItemCatList() --> "
								+ e.getMessage());
				_IssueDetailRptVO_NEW.setStrMsgType("1");

			} finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
			
			}
	
	
	public static void groupName(MiscItemListingRptVO_NEW vo)
	{
		String strProcName = "{call Pkg_Mms_Rpt.rptm_store_group_list(?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("MMS","MiscItemListingRptDAO_NEW");
		//	
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", MmsConfigUtil.GLOBAL_HOSPITAL_CODE,2);
			daoObj.setProcInValue(nProcIndex, "item_category", vo.getStrItemCatId(),3);
			daoObj.setProcOutValue(nProcIndex, "err",1,4); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,5);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			System.out.println("DAO :: groupName :: ws size-->"+ws.size());
			if (strErr.equals("")) {
				vo.setGroupIdWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("MiscItemListingRptDAO_NEW.groupName() --> "	+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}


	/**
	 * The following procedure is used to populate the value of Already Existing
	 * Batch in HSTT_DRUG_CURRSTOCK_DTL combo using
	 * Pkg_Mms_View.proc_supplier_list procedure.
	 * 
	 * @param vo
	 *            the vo
	 * @return the existing batch list
	 */
	public static void getDrugNameCombo(MiscItemListingRptVO_NEW voObj) {

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

	public static void getExistingBatchList(MiscItemListingRptVO_NEW vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;

		try {
			dao = new HisDAO("mms", "MiscItemListingRptDAO_NEW");
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
			vo.setStrMsgString("IssueDetailRptDAO.getExistingBatchList() --> "
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
	public static void getProgrammeCombo(MiscItemListingRptVO_NEW vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "MiscItemListingRptDAO_NEW");
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
			vo.setStrMsgString("DrugInventoryTransDAO.phdItemCombo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getViewDtl(MiscItemListingRptVO_NEW voObj)
	{
		String strProcName = "{call PKG_MMS_VIEW2.MISCITEM_LISTING_RPT(?,?,?,?,? , ?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj = null;
		try 
		{
			daoObj = new HisDAO("mms","MiscItemListingRptDAO_NEW");
			nProcIndex = daoObj.setProcedure(strProcName);	
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);		
			daoObj.setProcInValue(nProcIndex, "catcode",voObj.getStrItemCatId(),2);
			daoObj.setProcInValue(nProcIndex, "store",voObj.getStrStoreId(),3);
			
			daoObj.setProcInValue(nProcIndex, "frmdate",voObj.getStrFromDate(),4);
			daoObj.setProcInValue(nProcIndex, "todate",voObj.getStrToDate(),5);
			daoObj.setProcInValue(nProcIndex, "hospcode",voObj.getStrHospCode(),6);
			daoObj.setProcInValue(nProcIndex, "crno",    "0",7);
			daoObj.setProcInValue(nProcIndex, "groupid", voObj.getStrGroupId(),8);

			daoObj.setProcOutValue(nProcIndex, "err", 1,9);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,10);
			daoObj.executeProcedureByPosition(nProcIndex);

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				//System.out.println(" ----------> Size---------"+ ws.size());
				voObj.setWsMiscellaneousConsDtlRpt(ws);
					 		
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("MiscItemListingRptDAO_NEW.getViewDtl() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	public static void getImageHeader(MiscItemListingRptVO_NEW voObj)
	{
		String strFuncName = "";
		String strLogoName = "";
		
		int nFuncIndex = 0;
		HisDAO dao = null;
		try 
		{
			dao = new HisDAO("DWH","MiscItemListingRptDAO_NEW");
			
			strFuncName = "{? = call MMS_MST.logo_config_dtl(?,?)}";
			nFuncIndex = dao.setFunction(strFuncName);
			
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, voObj.getStrHospCode());
			dao.setFuncOutValue(nFuncIndex, 1);
			
			dao.executeFunction(nFuncIndex);
			
			strLogoName = dao.getFuncString(nFuncIndex);
			voObj.setStrLogoName(strLogoName);
			//System.out.println("------------strLogoName------------"+strLogoName);

		} catch (Exception e) {
			
			e.printStackTrace();
			voObj.setStrMsgType("1");
			voObj.setStrMsgString("MiscItemListingRptDAO_NEW.getImageHeader() --> "+ e.getMessage());
			
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}
		}	
	}
	
	
}
