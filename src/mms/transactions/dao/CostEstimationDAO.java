package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.CostEstimationVO;

public class CostEstimationDAO 
{	
	/**
	 * <p>Method::itemCategory is Used to populate the ITEM CATEGORY COMBO on the JSP Page.
	 * <p>Invoked through AJAX At the time of on Change of From Store Combo 
	 * @param <CostEstimationVO>vo
	 */
		public static void itemCategory(CostEstimationVO vo)
		{
			String strProcName = "{call PKG_MMS_VIEW.proc_item_category_list(?,?,?,?,?,?)}";
			
			int nProcIndex = 0;
			String strErr = "";
			WebRowSet ws = null;
			HisDAO daoObj=null;
			try
			{
				daoObj=new HisDAO("Item Transfer Details","CostEstimationDAO");
				nProcIndex = daoObj.setProcedure(strProcName);
				daoObj.setProcInValue(nProcIndex, "modeval", "5");
				daoObj.setProcInValue(nProcIndex, "store_id", "0");
				daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
				daoObj.setProcInValue(nProcIndex, "reqType", "0");
				daoObj.setProcOutValue(nProcIndex, "err",1); 
				daoObj.setProcOutValue(nProcIndex, "resultset",2);
				daoObj.executeProcedure(nProcIndex);
				
				strErr = daoObj.getString(nProcIndex, "err");
				if (strErr == null)
					strErr = "";
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				if (strErr.equals("")) {
					vo.setStrItemCategoryComboWS(ws);
				} else {
					throw new Exception(strErr);
				}
			}
			catch(Exception e)
			{
				vo.setStrMsgString("CostEstimationDAO.itemCategory() --> "+ e.getMessage());
				vo.setStrMsgType("1");
			}
		}

}
