package mms.reports.bo;

import mms.reports.dao.MaterialOutwardRegisterRptDAO;
import mms.reports.vo.MaterialOutwardRegisterRptVO;

public class MaterialOutwardRegisterRptBO 
{

	
	/**
	 * To get Drug Warehouse Type Combo
	 * 
	 * @param voObj
	 */
	public void getInitializedValues(MaterialOutwardRegisterRptVO voObj)
	{
	

	MaterialOutwardRegisterRptDAO.getStoreList(voObj);	
	MaterialOutwardRegisterRptDAO.getSuppliedByList(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("MaterialOutwardRegisterRptBO.getDwhTypeCombo()-->"+strErr);
		}
	}
	
	
	/**
	 * Get PO Details
	 * 
	 * @param voObj
	 */
	public void getIssueDetails(MaterialOutwardRegisterRptVO voObj)
	{
		voObj.setStrMode("4");
	    MaterialOutwardRegisterRptDAO.getIssueDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("MaterialOutwardRegisterRptBO.getIssueDetails()-->"+strErr);
		}
	}
	
	/**
	 * Get PO Details
	 * 
	 * @param voObj
	 */
	public void getToStoreCmb(MaterialOutwardRegisterRptVO voObj)
	{
	
	    MaterialOutwardRegisterRptDAO.ToStoreCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("MaterialOutwardRegisterRptBO.getToStoreCmb()-->"+strErr);
		}
	}
	
	
	/**
	 * Get Issue Dtl PopUp
	 * 
	 * @param voObj
	 */
	public void getIssueDtlPopUp1(MaterialOutwardRegisterRptVO voObj)	// Screen 3
	{
		
		voObj.setStrMode("5");
	    MaterialOutwardRegisterRptDAO.getIssueDetails(voObj);
		
//	    MaterialOutwardRegisterRptDAO.getIssueItemDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("MaterialOutwardRegisterRptBO.getIssueItemDetails()-->"+strErr);
		}
	}
	
	
	/**
	 * Get Challan Details
	 * 
	 * @param voObj
	 */
	public void getIssueDtlPopUp2(MaterialOutwardRegisterRptVO voObj)	//Screen 4
	{
		
		voObj.setStrMode("3");
	    MaterialOutwardRegisterRptDAO.getIssueDetails(voObj);
		
//	    MaterialOutwardRegisterRptDAO.getIssueItemDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("MaterialOutwardRegisterRptBO.getIssueItemDetails()-->"+strErr);
		}
	}

	/**
	 * Get Challan Details
	 * 
	 * @param voObj
	 */
	public void getIssueItemDetails(MaterialOutwardRegisterRptVO voObj)
	{
		
	
		
	    MaterialOutwardRegisterRptDAO.getIssueItemDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("MaterialOutwardRegisterRptBO.getIssueItemDetails()-->"+strErr);
		}
	}
	
}
