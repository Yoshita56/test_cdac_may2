package mms.reports.bo;

import mms.reports.dao.TotalValueDrugsSupplyRptDAO;
import mms.reports.vo.TotalValueDrugsSupplyRptVO;

public class TotalValueDrugsSupplyRptBO 
{

	
	/**
	 * To get Drug Warehouse Type Combo
	 * 
	 * @param voObj
	 */
	public void getInitializedValues(TotalValueDrugsSupplyRptVO voObj)
	{
	
//	TotalValueDrugsSupplyRptDAO.getDwhTypeCombo(voObj);
	TotalValueDrugsSupplyRptDAO.getStoreList(voObj);	
	TotalValueDrugsSupplyRptDAO.getSuppliedByList(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("TotalValueDrugsSupplyRptBO.getDwhTypeCombo()-->"+strErr);
		}
	}
}
