package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import javax.sql.rowset.WebRowSet;
import mms.transactions.vo.SerialNoGenerationTransVO;

/**
 * @author Niharika Srivastava 
 * Date Of Creation : 15-Sep-2010 
 * Team Lead : Mr. Ajay Kumar Gupta 
 * Module : MMS 
 * Process : Serial No Generation Transaction
 * Description : Data Access Object for Serial No Generation Transaction
 * Version : 1.0
 * Last Modified By :-- 
 * Last Modification Date :--
 */

public class SerialNoGenerationTransDAO {
	
	/**
	 * for getting option value of Store Name Combo.
	 * @param vo
	 */
	
	public static void getStoreName(SerialNoGenerationTransVO vo_p)
	{
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Serial No Generation","SerialNoGenerationTransDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "seatId", vo_p.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo_p.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "storeid", "0");
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0");
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo_p.setWsStoreNameCombo(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo_p.setStrMsgString("SerialNoGenerationTransDAO.getStoreName() --> "
					+ e.getMessage());
			vo_p.setStrMsgType("1");
		}
	}
	/**
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 **/
	public static void getItemCategory(SerialNoGenerationTransVO vo_p)
	{
		String strProcName = "{call pkg_mms_view.proc_item_category_list(?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Serial No Generation","SerialNoGenerationTransDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
						  		
			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo_p.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "store_id", vo_p.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "reqType", "63");
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo_p.setWsItemCategoryCombo(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo_p.setStrMsgString("SerialNoGenerationTransDAO.getItemCategory() --> "
					+ e.getMessage());
			vo_p.setStrMsgType("1");
		}
	}
	/**
	 * for getting option value of Item Name Combo on page
	 * 
	 * @param vo
	 **/
	public static void getItemName(SerialNoGenerationTransVO vo_p)
	{
		String strProcName = "{call pkg_mms_view.proc_item_serialno_list(?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Serial No Generation","SerialNoGenerationTransDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
						  		
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "itemcat", vo_p.getStrItemCatId());
			daoObj.setProcInValue(nProcIndex, "storeid", vo_p.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo_p.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo_p.setWsItemNameCombo(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo_p.setStrMsgString("SerialNoGenerationTransDAO.getItemName() --> "
					+ e.getMessage());
			vo_p.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Report Name Combo on Reprint page
	 * @param vo
	 */
	public static void getReportName(SerialNoGenerationTransVO vo_p)
	{
		String strProcName = "{call pkg_mms_view.proc_get_reportname_list(?,?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Serial No Generation","SerialNoGenerationTransDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "itemcat", vo_p.getStrItemCatId());
			daoObj.setProcInValue(nProcIndex, "storeid", vo_p.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo_p.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "fromDate", vo_p.getStrFromDate());
			daoObj.setProcInValue(nProcIndex, "toDate", vo_p.getStrToDate());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo_p.setWsReportNameCombo(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo_p.setStrMsgString("SerialNoGenerationTransDAO.getReportName() --> "
					+ e.getMessage());
			vo_p.setStrMsgType("1");
		}
	}
}

