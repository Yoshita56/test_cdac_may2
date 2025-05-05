package mms.reports.bo;

import mms.reports.dao.ListOfConsigneeRptDAO;
import mms.reports.dao.SampleIssueReceiveToQualityDeptRptDAO;
import mms.reports.vo.ListOfConsigneeRptVO;
import mms.reports.vo.SampleIssueReceiveToQualityDeptRptVO;

public class ListOfConsigneeRptBO {
	
	/**
	 * To get Supplier Combo
	 * 
	 * @param voObj
	 */
	public void getInitializedValues(ListOfConsigneeRptVO voObj)
	{
	
	    ListOfConsigneeRptDAO.getSuppliedByList(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("ListOfConsigneeRptBO.getSuppliedByList()-->"+strErr);
		}
	}
	
	
	
	
	/**
	 * Get PO Details
	 * 
	 * @param voObj
	 */
	public void getPODetails(ListOfConsigneeRptVO voObj)
	{
	
	    ListOfConsigneeRptDAO.getPoDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("ListOfConsigneeRptBO.getPoDetails()-->"+strErr);
		}
	}
	
	
	/**
	 * Get PO Details
	 * 
	 * @param voObj
	 */
	public void getSupplierPODtlPopUp(ListOfConsigneeRptVO voObj)
	{
	
	    ListOfConsigneeRptDAO.getSupplierPODtlPopUp(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("ListOfConsigneeRptBO.getSupplierPODtlPopUp()-->"+strErr);
		}
	}
	
	
	/**
	 * Get PO Details
	 * 
	 * @param voObj
	 */
	public void getScreenTwo(ListOfConsigneeRptVO voObj)
	{
	
	    ListOfConsigneeRptDAO.getScreenTwo(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("ListOfConsigneeRptBO.getScreenTwo()-->"+strErr);
		}
	}
	
	/**
	 * Get PO Consignee  Details
	 * 
	 * @param voObj
	 */
	public void getPOConsigneeDtl(ListOfConsigneeRptVO voObj)
	{
	
	    ListOfConsigneeRptDAO.getPOConsigneeDtl(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("ListOfConsigneeRptBO.getPOConsigneeDtl()-->"+strErr);
		}
	}
	
	
	
	
	


	public void getStoreList(ListOfConsigneeRptVO voObj) {
		// TODO Auto-generated method stub
		
		ListOfConsigneeRptDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("ListOfConsigneeRptBO.getPOChallanDtlPopUp()-->"+strErr);
		}
		
	}
	

}
