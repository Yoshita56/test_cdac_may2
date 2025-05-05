package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.InstallationTransVO;

public class InstallationTransDAO {
	
	/**
	 * for getting option value of Store Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getStoreCmb(InstallationTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Installation Details","InstallationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "seatId", vo.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			
			/* Setting Default Value Start*/
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "storeid", "0");
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0");
			/* Setting Default Value End */
			
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			
			if (strErr.equals("")) {
				vo.setStrStoreComboWs(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("InstallationTransDAO.storeName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getItemCatCmb(InstallationTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Quality Check Control","InstallationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1");			
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "reqType", "0");// Default Value		
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setStrItemCatComboWs(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("InstallationTransDAO.getItemCatCmb() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Group Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getGroupCmb(InstallationTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_store_group_list(?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Quality Check Control","InstallationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "item_category", vo.getStrItemCatNo());
			
			/* Setting Default Value Start*/
			daoObj.setProcInValue(nProcIndex, "strPhyStockNo", "");
			daoObj.setProcInValue(nProcIndex, "strStoreId", "");
			/* Setting Default Value End */
			
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setStrGroupComboWs(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("InstallationTransDAO.getGroupCmb() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of SubGroup Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getSubGroupCmb(InstallationTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_store_subgroup_list(?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Quality Check Control","InstallationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "group_id", vo.getStrGroupId());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setStrSubGroupComboWs(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("InstallationTransDAO.getSubGroupCmb() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Generic Item Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getGenItemCmb(InstallationTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_item_list(?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Item Location","ItemLocationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "catCode", vo.getStrItemCatNo());
			daoObj.setProcInValue(nProcIndex, "grpId", vo.getStrGroupId());
			daoObj.setProcInValue(nProcIndex, "subgroup_id", vo.getStrSubGroupId());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setStrGenItemComboWs(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("InstallationTransDAO.getGenItemCmb() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Item Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getItemCmb(InstallationTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_storeitem_brand_list(?,?,?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Quality Check Control","InstallationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "3");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "cat_no", vo.getStrItemCatNo());
			daoObj.setProcInValue(nProcIndex, "group_id", vo.getStrGroupId());
			daoObj.setProcInValue(nProcIndex, "sub_group_id", vo.getStrSubGroupId());
			daoObj.setProcInValue(nProcIndex, "item_id", vo.getStrGenItemId());
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId());
			
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setStrItemComboWs(ws);
				
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("InstallationTransDAO.getItemCmb() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	/**
	 * for getting option value of Batch No on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getBatchSlNo(InstallationTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_batchno_list(?,?,?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Item Location","InstallationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "cat_no", vo.getStrItemCatNo());
			daoObj.setProcInValue(nProcIndex, "itemid", vo.getStrGenItemId());
			daoObj.setProcInValue(nProcIndex, "itembrandid", vo.getStrItemBrandId());
			
			if(vo.getStrItemCatNo().equals("10")){
				daoObj.setProcInValue(nProcIndex, "stockstatuscode", vo.getStrStockStatusCode());
			}else{
				daoObj.setProcInValue(nProcIndex, "stockstatuscode", "0");
			}
			
			daoObj.setProcInValue(nProcIndex, "storeid", vo.getStrStoreId());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setStrBatchSlNoComboWs(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("InstallationTransDAO.getBatchSlNo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Batch No on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getItemSlNo(InstallationTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_batchno_list(?,?,?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			
			daoObj=new HisDAO("Quality Check Control","InstallationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "cat_no", vo.getStrItemCatNo());
			daoObj.setProcInValue(nProcIndex, "itemid", vo.getStrGenItemId());
			daoObj.setProcInValue(nProcIndex, "itembrandid", vo.getStrItemBrandId());
			daoObj.setProcInValue(nProcIndex, "stockstatuscode", vo.getStrStockStatusCode());
			daoObj.setProcInValue(nProcIndex, "storeid", vo.getStrStoreId());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setStrItemSlNoComboWs(ws);
				
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("InstallationTransDAO.getItemSlNo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To insert the value into the Database
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void insert(InstallationTransVO vo)
	{
		
		HisDAO dao=null;
				
		try
		{
			dao=new HisDAO("Quality Check Control","InstallationTransDAO");
			
		
			
			
			
			
			synchronized (dao) {
				dao.fire();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("InstallationTransDAO.insert() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}	
	
	/**
	 * for Existing value of Item Category on View page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void goView(InstallationTransVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_quality_viewdetails_dtls(?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Quality Check Control","InstallationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "itemcat", vo.getStrItemCatNo());
			daoObj.setProcInValue(nProcIndex, "start_date", vo.getStrFinStartDate());
			daoObj.setProcInValue(nProcIndex, "end_date", vo.getStrFinEndDate());
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setStrInstallationDtlWs(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("InstallationTransDAO.goView() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

}
