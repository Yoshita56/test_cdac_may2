/**
 * 
 */
package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.ListSupplierNotSendingRptVO;

/**
 * @author user
 *
 */
public class ListSupplierNotSendingRptDAO {
	
	/**
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void itemCategoryName(ListSupplierNotSendingRptVO vo)
	{
		String strProcName = "{call Pkg_Mms_Rpt.Rptm_item_category_list(?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Item Location","ListSupplierNotSendingRptDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setItemCategoryWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("ListSupplierNotSendingRptDAO.itemCategoryName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	

}
