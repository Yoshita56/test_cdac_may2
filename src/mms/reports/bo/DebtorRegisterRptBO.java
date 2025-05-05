package mms.reports.bo;

import mms.reports.dao.DebtorRegisterRptDAO;
import mms.reports.vo.DebtorRegisterRptVO;

public class DebtorRegisterRptBO 
{
	
	/**
	 * To get Drug Warehouse Type Combo
	 * 
	 * @param voObj
	 */
	public void getInitializedValues(DebtorRegisterRptVO voObj)
	{
	
	    DebtorRegisterRptDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("DebtorRegisterRptBO.getInitializedValues()-->"+strErr);
		}
	}
	
	/**
	 * Get PO Details
	 * 
	 * @param voObj
	 */
	public void getUnitDetails(DebtorRegisterRptVO voObj)
	{
	
	    DebtorRegisterRptDAO.getUnitDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("DebtorRegisterRptBO.getUnitDetails()-->"+strErr);
		}
	}
	
	
	/**
	 * Get getIssuedItemDetails Details
	 * 
	 * @param voObj
	 */
	public void getDebetorItemDetails(DebtorRegisterRptVO voObj)
	{
	
	    DebtorRegisterRptDAO.getDebetorItemDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("DebtorRegisterRptBO.getDebetorItemDetails()-->"+strErr);
		}
	}
	

}
