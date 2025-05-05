package mms.reports.bo;

import mms.reports.dao.MaterialInwardReisterRptDAO;
import mms.reports.vo.MaterialInwardReisterRptVO;

public class MaterialInwardReisterRptBO {
	
	/**
	 * To get Drug Warehouse Type Combo
	 * 
	 * @param voObj
	 */
	public void getInitializedValues(MaterialInwardReisterRptVO voObj)
	{
	
	    MaterialInwardReisterRptDAO.getSuppliedByList(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("MaterialInwardReisterRptBO.getDwhTypeCombo()-->"+strErr);
		}
	}
	
	/**
	 * Get PO Details
	 * 
	 * @param voObj
	 */
	public void getPODetails(MaterialInwardReisterRptVO voObj)
	{
	
	    MaterialInwardReisterRptDAO.getPoDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("MaterialInwardReisterRptBO.getPoDetails()-->"+strErr);
		}
	}
	
	
	/**
	 * Get PO Details
	 * 
	 * @param voObj
	 */
	public void getSupplierPODtlPopUp(MaterialInwardReisterRptVO voObj)
	{
	
	    MaterialInwardReisterRptDAO.getSupplierPODtlPopUp(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("MaterialInwardReisterRptBO.getSupplierPODtlPopUp()-->"+strErr);
		}
	}
	
	
	/**
	 * Get PO Details
	 * 
	 * @param voObj
	 */
	public void getScreenTwo(MaterialInwardReisterRptVO voObj)
	{
	
	    MaterialInwardReisterRptDAO.getScreenTwo(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("MaterialInwardReisterRptBO.getScreenTwo()-->"+strErr);
		}
	}
	
	
	/**
	 * Get Challan Details
	 * 
	 * @param voObj
	 */
	public void getChallanItemDtlPopUp(MaterialInwardReisterRptVO voObj)
	{
	
	    MaterialInwardReisterRptDAO.getChallanItemDtlPopUp(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("MaterialInwardReisterRptBO.getChallanItemDtlPopUp()-->"+strErr);
		}
	}
	
	/**
	 * Get Challan Details
	 * 
	 * @param voObj
	 */
	public void getChallanDetails(MaterialInwardReisterRptVO voObj)
	{
	
	    MaterialInwardReisterRptDAO.getChallanDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("MaterialInwardReisterRptBO.getPoDetails()-->"+strErr);
		}
	}
	
	
	/**
	 * Get Challan Details
	 * 
	 * @param voObj
	 */
	public void getPOChallanDtlPopUp(MaterialInwardReisterRptVO voObj)
	{
	
	    MaterialInwardReisterRptDAO.getPOChallanDtlPopUp(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("MaterialInwardReisterRptBO.getPOChallanDtlPopUp()-->"+strErr);
		}
	}
	

}
