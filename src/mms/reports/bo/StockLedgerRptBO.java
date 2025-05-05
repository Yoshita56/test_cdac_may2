package mms.reports.bo;

import mms.reports.dao.StockLedgerRptDAO;
import mms.reports.vo.StockLedgerRptVO;

/**
 * Developer : Vivek Aggarwal
 * Version : 1.0
 * Date : 16-Mar-2012
 * Modification Date: 
 *  
*/
public class StockLedgerRptBO 
{
	
	/**
	 * 
	 * @param voObj
	 */
	public void getStoreList(StockLedgerRptVO voObj){
		
		StockLedgerRptDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("StockLedgerRptBO.getStoreList()-->"+strErr);
				}
				
		}
	/**
	 * 
	 * @param voObj
	 */
	public void getItemCatList(StockLedgerRptVO voObj){
	
	StockLedgerRptDAO.getItemCatList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("StockLedgerRptBO.getItemCatList()-->"+strErr);
			}
			
	}

	/**
	 * 
	 * @param voObj
	 */
	public void getGroupList(StockLedgerRptVO voObj){
	
	StockLedgerRptDAO.getGroupList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("StockLedgerRptBO.getGroupList()-->"+strErr);
			}
			
	}
	
	/**
	 * 
	 * @param voObj
	 */
	public void getItemList(StockLedgerRptVO voObj){
	
	StockLedgerRptDAO.getItemList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("StockLedgerRptBO.getItemList()-->"+strErr);
			}
			
	}


	/**
	 * 
	 * @param voObj
	 */
	public void getConsolidatedStockLedgerDtl(StockLedgerRptVO voObj)
	{
		
		StockLedgerRptDAO.getData(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("StockLedgerRptBO.getItemList()-->"+strErr);
		}
			
	}
	
	/**
	 * 
	 * @param voObj
	 */
	public void getDetailedStockLedgerDtl(StockLedgerRptVO voObj)
	{
	
		StockLedgerRptDAO.getDetailedStockLedgerDtl(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("StockLedgerRptBO.getItemList()-->"+strErr);
		}
			
	}
}
