package mms.reports.bo;

import mms.reports.dao.SupplierPerformanceDtailRptDAO;
import mms.reports.vo.SupplierPerformanceDtailRptVO;

public class SupplierPerformanceDtailRptBO {
	
	/**
	 * To get Supplier,Group and Drug name Combo
	 * 
	 * @param voObj
	 */
	public void getInitializedValues(SupplierPerformanceDtailRptVO voObj)
	{
	
	    SupplierPerformanceDtailRptDAO.getSuppliedByList(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("SupplierPerformanceDtailRptBO.getSuppliedByList()-->"+strErr);
		}else {
			SupplierPerformanceDtailRptDAO.GetGroupNameCombo(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("SupplierPerformanceDtailRptBO.GetGroupNameCombo()-->"+strErr);
			}else{
				SupplierPerformanceDtailRptDAO.getItemBrandName(voObj);
				if (voObj.getStrMsgType().equals("1")) 
				{
							
							String strErr = voObj.getStrMsgString();
								
							voObj.setStrMsgString("SupplierPerformanceDtailRptBO.getItemBrandName()-->"+strErr);
				}
			}
		}
	}
	
	
	/**
	 * To get Drug name Combo
	 * 
	 * @param voObj
	 */
	public void getDrugNameComboValues(SupplierPerformanceDtailRptVO voObj)
	{
		SupplierPerformanceDtailRptDAO.getItemBrandName(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("SupplierPerformanceDtailRptBO.getDrugNameComboValues()-->"+strErr);
		}
}
	
	/**
	 * To get Drug name Combo
	 * 
	 * @param voObj
	 */
	public void getPOCombo(SupplierPerformanceDtailRptVO voObj)
	{
		SupplierPerformanceDtailRptDAO.getPOCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("SupplierPerformanceDtailRptBO.getPOCombo()-->"+strErr);
		}
   }
	
	/**
	 * Get PO Details
	 * 
	 * @param voObj
	 */
	public void getPODetails(SupplierPerformanceDtailRptVO voObj)
	{
	
	    SupplierPerformanceDtailRptDAO.getPoDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("SupplierPerformanceDtailRptBO.getPoDetails()-->"+strErr);
		}
	}
	
	
	/**
	 * Get PO Details
	 * 
	 * @param voObj
	 */
	public void getSupplierPODtlPopUp(SupplierPerformanceDtailRptVO voObj)
	{
	
	    SupplierPerformanceDtailRptDAO.getSupplierPODtlPopUp(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("SupplierPerformanceDtailRptBO.getSupplierPODtlPopUp()-->"+strErr);
		}
	}
	
	
	/**
	 * Get PO Details
	 * 
	 * @param voObj
	 */
	public void getScreenTwo(SupplierPerformanceDtailRptVO voObj)
	{
	
	    SupplierPerformanceDtailRptDAO.getScreenTwo(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("SupplierPerformanceDtailRptBO.getScreenTwo()-->"+strErr);
		}
	}
	
	/**
	 * Get PO Details
	 * 
	 * @param voObj
	 */
	public void getSupplierPerformanceDtl(SupplierPerformanceDtailRptVO voObj)
	{
	
	    SupplierPerformanceDtailRptDAO.getSupplierPerformanceDtl(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("SupplierPerformanceDtailRptBO.getSupplierPerformanceDtl()-->"+strErr);
		}
	}
	
	
	
	
	/**
	 * Get Challan Details
	 * 
	 * @param voObj
	 */
	public void getChallanItemDtlPopUp(SupplierPerformanceDtailRptVO voObj)
	{
	
	    SupplierPerformanceDtailRptDAO.getChallanItemDtlPopUp(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("SupplierPerformanceDtailRptBO.getChallanItemDtlPopUp()-->"+strErr);
		}
	}
	
	/**
	 * Get Challan Details
	 * 
	 * @param voObj
	 */
	public void getChallanDetails(SupplierPerformanceDtailRptVO voObj)
	{
	
	    SupplierPerformanceDtailRptDAO.getChallanDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("SupplierPerformanceDtailRptBO.getPoDetails()-->"+strErr);
		}
	}
	
	
	/**
	 * Get Challan Details
	 * 
	 * @param voObj
	 */
	public void getPOChallanDtlPopUp(SupplierPerformanceDtailRptVO voObj)
	{
	
	    SupplierPerformanceDtailRptDAO.getPOChallanDtlPopUp(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("SupplierPerformanceDtailRptBO.getPOChallanDtlPopUp()-->"+strErr);
		}
	}
	

}
