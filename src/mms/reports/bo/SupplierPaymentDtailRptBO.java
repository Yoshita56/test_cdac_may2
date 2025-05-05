package mms.reports.bo;

import mms.reports.dao.SupplierPaymentDtailRptDAO;
import mms.reports.vo.SupplierPaymentDtailRptVO;

public class SupplierPaymentDtailRptBO {
	
	/**
	 * To get Supplier,Group and Drug name Combo
	 * 
	 * @param voObj
	 */
	public void getInitializedValues(SupplierPaymentDtailRptVO voObj)
	{
	
	    SupplierPaymentDtailRptDAO.getSuppliedByList(voObj);
	    if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("SupplierPaymentDtailRptBO.getInitializedValues()-->"+strErr);
		}
	}
	
	/**
	 * To get Drug name Combo
	 * 
	 * @param voObj
	 */
	public void getPOCombo(SupplierPaymentDtailRptVO voObj)
	{
		SupplierPaymentDtailRptDAO.getPOCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("SupplierPaymentDtailRptBO.getPOCombo()-->"+strErr);
		}
   }
	
	/**
	 * Get PO Details
	 * 
	 * @param voObj
	 */
	public void getSupplierPerformanceDtl(SupplierPaymentDtailRptVO voObj)
	{
	
	    SupplierPaymentDtailRptDAO.getSupplierPerformanceDtl(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("SupplierPaymentDtailRptBO.getSupplierPerformanceDtl()-->"+strErr);
		}
	}
}
