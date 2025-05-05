package mms.transactions.bo;

import mms.transactions.dao.BudgetAllocationDetailProcessTransDAO;
import mms.transactions.vo.BudgetAllocationDetailProcessTransVO;

public class BudgetAllocationDetailProcessTransBO {
	
	/**
	 * 
	 * @param voObj
	 */
	public void getDrugWareHouseNameCombo(BudgetAllocationDetailProcessTransVO voObj){
		
		BudgetAllocationDetailProcessTransDAO.getDrugWareHouseNameCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("BudgetAllocationDetailProcessTransBO.getDrugWareHouseNameCombo()-->"+strErr);
				}
				
		}
	
	/**
	 * 
	 * @param voObj
	 */
	public void getDWHSubTypeCombo(BudgetAllocationDetailProcessTransVO voObj){
		
		BudgetAllocationDetailProcessTransDAO.getDWHSubTypeCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("BudgetAllocationDetailProcessTransBO.getDWHSubTypeCombo()-->"+strErr);
				}
				
		}
	
	
	/**
	 *	To Get  Prev Budget Dtls
	 *
	 * @param budgetAllocationDetailProcessTransVO
	 */
	public void getPrevRemainingBudgetDtls(BudgetAllocationDetailProcessTransVO budgetAllocationDetailProcessTransVO_p) 
	{
		budgetAllocationDetailProcessTransVO_p.setStrMode("2");
		BudgetAllocationDetailProcessTransDAO.getData(budgetAllocationDetailProcessTransVO_p);
		
		if (budgetAllocationDetailProcessTransVO_p.getStrMsgType().equals("1")) {
			
			String strErr = budgetAllocationDetailProcessTransVO_p.getStrMsgString();
				
			budgetAllocationDetailProcessTransVO_p.setStrMsgString("BudgetAllocationDetailProcessTransBO.getPrevRemainingBudgetDtls()-->"+strErr);
		}
	}
	
	/**
	 *	To Get  Prev Budget Dtls
	 *
	 * @param budgetAllocationDetailProcessTransVO
	 */
	public void getLastAllocatedBudgetDtls(BudgetAllocationDetailProcessTransVO budgetAllocationDetailProcessTransVO_p) 
	{
		budgetAllocationDetailProcessTransVO_p.setStrMode("2");
		BudgetAllocationDetailProcessTransDAO.getData(budgetAllocationDetailProcessTransVO_p);
	
		if (budgetAllocationDetailProcessTransVO_p.getStrMsgType().equals("1")) {
			
			String strErr = budgetAllocationDetailProcessTransVO_p.getStrMsgString();
				
			budgetAllocationDetailProcessTransVO_p.setStrMsgString("BudgetAllocationDetailProcessTransBO.getLastAllocatedBudgetDtls()-->"+strErr);
		}
	}
	
	/**
	 * 
	 * @param budgetAllocationDetailProcessTransVO_p
	 */
	public void insertRecord(BudgetAllocationDetailProcessTransVO budgetAllocationDetailProcessTransVO_p) 
	{
		BudgetAllocationDetailProcessTransDAO.insert(budgetAllocationDetailProcessTransVO_p);

		if (budgetAllocationDetailProcessTransVO_p.getStrMsgType().equals("1")) 
		{
			budgetAllocationDetailProcessTransVO_p.setStrMsgString("BudgetAllocationDetailProcessTransVO.insertRecord(budgetAllocationDetailProcessTransVO_p) ---->"+ budgetAllocationDetailProcessTransVO_p.getStrMsgString());
		}
	}

	
	/**
	 * 
	 * @param budgetAllocationDetailProcessTransVO_p
	 */
	public void getFinancialYearComboForViewPage(BudgetAllocationDetailProcessTransVO budgetAllocationDetailProcessTransVO_p)
	{
		budgetAllocationDetailProcessTransVO_p.setStrMode("1");
		BudgetAllocationDetailProcessTransDAO.getFinancialYearComboForViewPage(budgetAllocationDetailProcessTransVO_p);
		
		if (budgetAllocationDetailProcessTransVO_p.getStrMsgType().equals("1")) {
			
			String strErr = budgetAllocationDetailProcessTransVO_p.getStrMsgString();
				
			budgetAllocationDetailProcessTransVO_p.setStrMsgString("BudgetAllocationDetailProcessTransBO.getPrevRemainingBudgetDtls()-->"+strErr);
		}		
	}
	
	
	/**
	 * 
	 * @param budgetAllocationDetailProcessTransVO_p
	 */
	public void getDWHSubStoreCmb(BudgetAllocationDetailProcessTransVO budgetAllocationDetailProcessTransVO_p)
	{
		budgetAllocationDetailProcessTransVO_p.setStrMode("1");
		BudgetAllocationDetailProcessTransDAO.getDWHSubStoreCmb(budgetAllocationDetailProcessTransVO_p);
		
		if (budgetAllocationDetailProcessTransVO_p.getStrMsgType().equals("1")) {
			
			String strErr = budgetAllocationDetailProcessTransVO_p.getStrMsgString();
				
			budgetAllocationDetailProcessTransVO_p.setStrMsgString("BudgetAllocationDetailProcessTransBO.getDWHSubStoreCmb()-->"+strErr);
		}		
	}
	
	
	
	/**
	 *	To Get  Prev Budget Dtls
	 *
	 * @param budgetAllocationDetailProcessTransVO
	 */
	public void viewBudgetDetailsRecord(BudgetAllocationDetailProcessTransVO budgetAllocationDetailProcessTransVO_p) 
	{
		budgetAllocationDetailProcessTransVO_p.setStrMode("4");
		BudgetAllocationDetailProcessTransDAO.getData(budgetAllocationDetailProcessTransVO_p);
		
		if (budgetAllocationDetailProcessTransVO_p.getStrMsgType().equals("1")) {
			
			String strErr = budgetAllocationDetailProcessTransVO_p.getStrMsgString();
				
			budgetAllocationDetailProcessTransVO_p.setStrMsgString("BudgetAllocationDetailProcessTransBO.viewBudgetDetailsRecord()-->"+strErr);
		}
	}

	
	/**
	 * 
	 * @param budgetAllocationDetailProcessTransVO_p
	 */
	public void getBudgetUsed(BudgetAllocationDetailProcessTransVO budgetAllocationDetailProcessTransVO_p)
	{
		budgetAllocationDetailProcessTransVO_p.setStrMode("1");
		BudgetAllocationDetailProcessTransDAO.getData(budgetAllocationDetailProcessTransVO_p);
		
		if (budgetAllocationDetailProcessTransVO_p.getStrMsgType().equals("1")) {
			
			String strErr = budgetAllocationDetailProcessTransVO_p.getStrMsgString();
				
			budgetAllocationDetailProcessTransVO_p.setStrMsgString("BudgetAllocationDetailProcessTransBO.getBudgetUsed()-->"+strErr);
		}		
	}
	
}
