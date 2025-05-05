package mms.transactions.bo;

import mms.transactions.dao.ChallanModificationTransDAO;
import mms.transactions.vo.ChallanModificationTransVO;

public class ChallanModificationTransBO{
	
	/**
	 * 
	 * @param voObj
	 */
	public void getDrugWareHouseNameCombo(ChallanModificationTransVO voObj){
		
		ChallanModificationTransDAO.getDrugWareHouseNameCombo(voObj);
		
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("ChallanModificationTransBO.getDrugWareHouseNameCombo()-->"+strErr);
				}
				
		}
	
	
     public void getSupplierCombo(ChallanModificationTransVO voObj)
     {
				
		ChallanModificationTransDAO.getSuppliedByList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("ChallanModificationTransBO.getSupplierCombo()-->"+strErr);
				}
				
		}
	
	/**
	 * 
	 * @param ChallanModificationTransVO_p
	 */
	public void insertRecord(ChallanModificationTransVO ChallanModificationTransVO_p) 
	{
		//ChallanModificationTransDAO.insert(ChallanModificationTransVO_p);

		if (ChallanModificationTransVO_p.getStrMsgType().equals("1")) 
		{
			ChallanModificationTransVO_p.setStrMsgString("ChallanModificationTransVO.insertValues(stateMstVO_p) ---->"+ ChallanModificationTransVO_p.getStrMsgString());
		}
	}

	/**
	 * 
	 * @param ChallanModificationTransVO_p
	 */
	public void insertChallanRecord(ChallanModificationTransVO ChallanModificationTransVO_p) 
	{
		ChallanModificationTransDAO.insertChallanRecord(ChallanModificationTransVO_p);

		if (ChallanModificationTransVO_p.getStrMsgType().equals("1")) 
		{
			ChallanModificationTransVO_p.setStrMsgString("ChallanModificationTransVO.insertChallanRecord(stateMstVO_p) ---->"+ ChallanModificationTransVO_p.getStrMsgString());
		}
	}

	
	/**
	 * 
	 * @param ChallanModificationTransVO_p
	 */
	public void getPoNoCmb(ChallanModificationTransVO ChallanModificationTransVO_p)
	{
		
		ChallanModificationTransDAO.getData(ChallanModificationTransVO_p);
		
		if (ChallanModificationTransVO_p.getStrMsgType().equals("1")) {
			
			String strErr = ChallanModificationTransVO_p.getStrMsgString();
				
			ChallanModificationTransVO_p.setStrMsgString("ChallanModificationTransBO.getDWHSubStoreCmb()-->"+strErr);
		}		
	}
	
	/**
	 * 
	 * @param ChallanModificationTransVO_p
	 */
	public void getSupplierCmb(ChallanModificationTransVO ChallanModificationTransVO_p)
	{
		
		ChallanModificationTransDAO.getSuppliedByList(ChallanModificationTransVO_p);
		
		if (ChallanModificationTransVO_p.getStrMsgType().equals("1")) {
			
			String strErr = ChallanModificationTransVO_p.getStrMsgString();
				
			ChallanModificationTransVO_p.setStrMsgString("ChallanModificationTransBO.getSupplierCmb()-->"+strErr);
		}		
	}
	
	
	/**
	 * 
	 * @param ChallanModificationTransVO_p
	 */
	public void getChallanNoCmb(ChallanModificationTransVO ChallanModificationTransVO_p)
	{
		
		ChallanModificationTransDAO.getChallanNoCombo(ChallanModificationTransVO_p);
		
		if (ChallanModificationTransVO_p.getStrMsgType().equals("1")) {
			
			String strErr = ChallanModificationTransVO_p.getStrMsgString();
				
			ChallanModificationTransVO_p.setStrMsgString("ChallanModificationTransBO.getChallanNoCmb()-->"+strErr);
		}		
	}
	
	/**
	 * 
	 * @param ChallanModificationTransVO_p
	 */
	public void getItemNameCmb(ChallanModificationTransVO ChallanModificationTransVO_p)
	{
		
		ChallanModificationTransDAO.getItemCmb(ChallanModificationTransVO_p);
		
		if (ChallanModificationTransVO_p.getStrMsgType().equals("1")) {
			
			String strErr = ChallanModificationTransVO_p.getStrMsgString();
				
			ChallanModificationTransVO_p.setStrMsgString("ChallanModificationTransBO.getDWHSubStoreCmb()-->"+strErr);
		}		
	}
	
	
	/**
	 * 
	 * @param ChallanModificationTransVO_p
	 */
	public void getChallanDtl(ChallanModificationTransVO ChallanModificationTransVO_p)
	{
		
		ChallanModificationTransDAO.getChallanDtl(ChallanModificationTransVO_p);
		
		if (ChallanModificationTransVO_p.getStrMsgType().equals("1")) {
			
			String strErr = ChallanModificationTransVO_p.getStrMsgString();
				
			ChallanModificationTransVO_p.setStrMsgString("ChallanModificationTransBO.getChallanDtl()-->"+strErr);
		}		
	}
	
	
	
	/**
	 *	To Get  Prev Budget Dtls
	 *
	 * @param budgetAllocationDetailProcessTransVO
	 */
	public void getSupplierPerformancePendingDtlView(ChallanModificationTransVO ChallanModificationTransVO_p) 
	{
		
		ChallanModificationTransDAO.getData(ChallanModificationTransVO_p);
		
		if (ChallanModificationTransVO_p.getStrMsgType().equals("1")) {
			
			String strErr = ChallanModificationTransVO_p.getStrMsgString();
				
			ChallanModificationTransVO_p.setStrMsgString("ChallanModificationTransBO.viewBudgetDetailsRecord()-->"+strErr);
		}
	}

	
	/**
	 * 
	 * @param ChallanModificationTransVO_p
	 */
	public void getBudgetUsed(ChallanModificationTransVO ChallanModificationTransVO_p)
	{
		ChallanModificationTransVO_p.setStrMode("1");
		ChallanModificationTransDAO.getData(ChallanModificationTransVO_p);
		
		if (ChallanModificationTransVO_p.getStrMsgType().equals("1")) {
			
			String strErr = ChallanModificationTransVO_p.getStrMsgString();
				
			ChallanModificationTransVO_p.setStrMsgString("ChallanModificationTransBO.getBudgetUsed()-->"+strErr);
		}		
	}
	
}
