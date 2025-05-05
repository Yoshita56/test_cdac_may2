package mms.transactions.bo;

import mms.transactions.dao.SupplierPerformanceDtlTransDAO;
import mms.transactions.vo.SupplierPerformanceDtlTransVO;

public class SupplierPerformanceDtlTransBO {
	
	/**
	 * 
	 * @param voObj
	 */
	public void getDrugWareHouseNameCombo(SupplierPerformanceDtlTransVO voObj){
		
		SupplierPerformanceDtlTransDAO.getDrugWareHouseNameCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("SupplierPerformanceDtlTransBO.getDrugWareHouseNameCombo()-->"+strErr);
				}
				
		}
	
	
	/**
	 * 
	 * @param supplierPerformanceDtlTransVO_p
	 */
	public void insertRecord(SupplierPerformanceDtlTransVO supplierPerformanceDtlTransVO_p) 
	{
		SupplierPerformanceDtlTransDAO.insert(supplierPerformanceDtlTransVO_p);

		if (supplierPerformanceDtlTransVO_p.getStrMsgType().equals("1")) 
		{
			supplierPerformanceDtlTransVO_p.setStrMsgString("SupplierPerformanceDtlTransVO.insertValues(stateMstVO_p) ---->"+ supplierPerformanceDtlTransVO_p.getStrMsgString());
		}
	}

	
	/**
	 * 
	 * @param supplierPerformanceDtlTransVO_p
	 */
	public void getPoNoCmb(SupplierPerformanceDtlTransVO supplierPerformanceDtlTransVO_p)
	{
		
		SupplierPerformanceDtlTransDAO.getData(supplierPerformanceDtlTransVO_p);
		
		if (supplierPerformanceDtlTransVO_p.getStrMsgType().equals("1")) {
			
			String strErr = supplierPerformanceDtlTransVO_p.getStrMsgString();
				
			supplierPerformanceDtlTransVO_p.setStrMsgString("SupplierPerformanceDtlTransBO.getDWHSubStoreCmb()-->"+strErr);
		}		
	}
	
	
	/**
	 * 
	 * @param supplierPerformanceDtlTransVO_p
	 */
	public void getChallanNoCmb(SupplierPerformanceDtlTransVO supplierPerformanceDtlTransVO_p)
	{
		
		SupplierPerformanceDtlTransDAO.getData(supplierPerformanceDtlTransVO_p);
		
		if (supplierPerformanceDtlTransVO_p.getStrMsgType().equals("1")) {
			
			String strErr = supplierPerformanceDtlTransVO_p.getStrMsgString();
				
			supplierPerformanceDtlTransVO_p.setStrMsgString("SupplierPerformanceDtlTransBO.getDWHSubStoreCmb()-->"+strErr);
		}		
	}
	
	/**
	 * 
	 * @param supplierPerformanceDtlTransVO_p
	 */
	public void getItemNameCmb(SupplierPerformanceDtlTransVO supplierPerformanceDtlTransVO_p)
	{
		
		SupplierPerformanceDtlTransDAO.getData(supplierPerformanceDtlTransVO_p);
		
		if (supplierPerformanceDtlTransVO_p.getStrMsgType().equals("1")) {
			
			String strErr = supplierPerformanceDtlTransVO_p.getStrMsgString();
				
			supplierPerformanceDtlTransVO_p.setStrMsgString("SupplierPerformanceDtlTransBO.getDWHSubStoreCmb()-->"+strErr);
		}		
	}
	
	
	/**
	 * 
	 * @param supplierPerformanceDtlTransVO_p
	 */
	public void getBatchCmb(SupplierPerformanceDtlTransVO supplierPerformanceDtlTransVO_p)
	{
		
		SupplierPerformanceDtlTransDAO.getBatchCmb(supplierPerformanceDtlTransVO_p);
		
		if (supplierPerformanceDtlTransVO_p.getStrMsgType().equals("1")) {
			
			String strErr = supplierPerformanceDtlTransVO_p.getStrMsgString();
				
			supplierPerformanceDtlTransVO_p.setStrMsgString("SupplierPerformanceDtlTransBO.getDWHSubStoreCmb()-->"+strErr);
		}		
	}
	
	
	
	/**
	 *	To Get  Prev Budget Dtls
	 *
	 * @param budgetAllocationDetailProcessTransVO
	 */
	public void getSupplierPerformancePendingDtlView(SupplierPerformanceDtlTransVO supplierPerformanceDtlTransVO_p) 
	{
		
		SupplierPerformanceDtlTransDAO.getData(supplierPerformanceDtlTransVO_p);
		
		if (supplierPerformanceDtlTransVO_p.getStrMsgType().equals("1")) {
			
			String strErr = supplierPerformanceDtlTransVO_p.getStrMsgString();
				
			supplierPerformanceDtlTransVO_p.setStrMsgString("SupplierPerformanceDtlTransBO.viewBudgetDetailsRecord()-->"+strErr);
		}
	}

	
	/**
	 * 
	 * @param supplierPerformanceDtlTransVO_p
	 */
	public void getBudgetUsed(SupplierPerformanceDtlTransVO supplierPerformanceDtlTransVO_p)
	{
		supplierPerformanceDtlTransVO_p.setStrMode("1");
		SupplierPerformanceDtlTransDAO.getData(supplierPerformanceDtlTransVO_p);
		
		if (supplierPerformanceDtlTransVO_p.getStrMsgType().equals("1")) {
			
			String strErr = supplierPerformanceDtlTransVO_p.getStrMsgString();
				
			supplierPerformanceDtlTransVO_p.setStrMsgString("SupplierPerformanceDtlTransBO.getBudgetUsed()-->"+strErr);
		}		
	}
	
}
