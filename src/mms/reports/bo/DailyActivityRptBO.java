package mms.reports.bo;

import mms.reports.dao.DailyActivityRptDAO;
import mms.reports.dao.MaterialOutwardRegisterRptDAO;
import mms.reports.dao.StockReceiptRegisterRptDAO;
import mms.reports.vo.DailyActivityRptVO;
import mms.reports.vo.MaterialOutwardRegisterRptVO;
import mms.reports.vo.StockReceiptRegisterRptVO;

public class DailyActivityRptBO 
{

	
	/**
	 * To get Drug Warehouse Type Combo
	 * 
	 * @param voObj
	 */
	public void getInitializedValues(DailyActivityRptVO voObj)
	{
	
//	DailyActivityRptDAO.getDwhTypeCombo(voObj);
	DailyActivityRptDAO.getStoreList(voObj);	
	DailyActivityRptDAO.getSuppliedByList(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("DailyActivityRptBO.getDwhTypeCombo()-->"+strErr);
		}
	}
	
	public void GetUserLevel(DailyActivityRptVO voObj){
		DailyActivityRptDAO.GetUserLevel(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("DailyActivityRptBO.GetUserLevel()-->"+strErr);
				}
	}
	
	/**
	 * Get PO Details
	 * 
	 * @param voObj
	 */
	public void getIssueDetails(DailyActivityRptVO voObj)
	{
	
	    DailyActivityRptDAO.getIssueDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("DailyActivityRptBO.getIssueDetails()-->"+strErr);
		}
	}
	
	/**
	 * Get PO Details
	 * 
	 * @param voObj
	 */
	public void getIssueVoucherDetailsPoUp(DailyActivityRptVO voObj)
	{
	
	    DailyActivityRptDAO.getIssueVoucherDetailsPopUp(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("DailyActivityRptBO.getIssueVoucherDetailsPopUp()-->"+strErr);
		}
	}
	
	/**
	 * Get PO Details
	 * 
	 * @param voObj
	 */
	public void getRecieveVoucherDetailsPoUp(DailyActivityRptVO voObj)
	{
	
	    DailyActivityRptDAO.getRecieveVoucherDetailsPopUp(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("DailyActivityRptBO.getRecieveVoucherDetailsPoUp()-->"+strErr);
		}
	}
	
	
	public void getSampleSendDetailsPoUp(DailyActivityRptVO voObj)
	{
	
	    DailyActivityRptDAO.getSampleSendDetailsPopUp(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("DailyActivityRptBO.getSampleSendDetailsPoUp()-->"+strErr);
		}
	}
	
	
	public void getSampleSendItemBatchDetailsPoUp(DailyActivityRptVO voObj)
	{
	
	    DailyActivityRptDAO.getSampleSendItemBatchDetailsPopUp(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("DailyActivityRptBO.getSampleSendItemBatchDetailsPoUp()-->"+strErr);
		}
	}
	
	
	
	/**
	 * Get PO Details
	 * 
	 * @param voObj
	 */
	public void getInstituteIssueDetailsPopUp(DailyActivityRptVO voObj)
	{
	
	    DailyActivityRptDAO.getInstituteIssueDetailsPopUp(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("DailyActivityRptBO.getInstituteIssueDetailsPopUp()-->"+strErr);
		}
	}
	
	/**
	 * Get PO Details
	 * 
	 * @param voObj
	 */
	public void getPOChallanDetailyPopUp(DailyActivityRptVO voObj)
	{
	
	    DailyActivityRptDAO.getPOChallanDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("DailyActivityRptBO.getPOChallanDetails()-->"+strErr);
		}
	}
	
	/**
	 * Get Challan Item Details
	 * 
	 * @param voObj
	 */
	public void getChallanItemDetailyPopUp(DailyActivityRptVO voObj)
	{
	
	    DailyActivityRptDAO.getChallanItemDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("DailyActivityRptBO.getChallanItemDetailyPopUp()-->"+strErr);
		}
	}
	
	
	/**
	 * Get PO Details
	 * 
	 * @param voObj
	 */
	public void getIssueNoDetailsPopUp(DailyActivityRptVO voObj)
	{
	
	    DailyActivityRptDAO.getIssueNoDetailsPopUp(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("DailyActivityRptBO.getIssueNoDetailsPopUp()-->"+strErr);
		}
	}
	
	
	
	/**
	 * Get Challan Details
	 * 
	 * @param voObj
	 */
	public void getIssueItemDetails(DailyActivityRptVO voObj)
	{
	
	    DailyActivityRptDAO.getIssueItemDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("DailyActivityRptBO.getIssueItemDetails()-->"+strErr);
		}
	}
	
	
	/**
	 * Get Challan Details
	 * 
	 * @param voObj
	 */
	public void getReceivedDetails(DailyActivityRptVO voObj)
	{
	
	    DailyActivityRptDAO.getReceivedDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("DailyActivityRptBO.getReceivedDetails()-->"+strErr);
		}
	}
	
	
	
	
	
}

