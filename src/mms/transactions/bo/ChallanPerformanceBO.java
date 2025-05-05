package mms.transactions.bo;

import mms.transactions.dao.ChallanPerformanceDAO;
import mms.transactions.vo.ChallanPerformanceVO;

public class ChallanPerformanceBO {
	
	/**
	 * 
	 * @param voObj
	 */
	public void getDrugWareHouseNameCombo(ChallanPerformanceVO voObj){
		
		ChallanPerformanceDAO.getDrugWareHouseNameCombo(voObj);
		
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("ChallanPerformanceBO.getDrugWareHouseNameCombo()-->"+strErr);
				}
				
		}
	
	
     public void getSupplierCombo(ChallanPerformanceVO voObj)
     {
				
		ChallanPerformanceDAO.getSuppliedByList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("ChallanPerformanceBO.getSupplierCombo()-->"+strErr);
				}
				
		}
	
	/**
	 * 
	 * @param ChallanPerformanceVO_p
	 */
	public void insertRecord(ChallanPerformanceVO ChallanPerformanceVO_p) 
	{
		//ChallanPerformanceDAO.insert(ChallanPerformanceVO_p);

		if (ChallanPerformanceVO_p.getStrMsgType().equals("1")) 
		{
			ChallanPerformanceVO_p.setStrMsgString("ChallanPerformanceVO.insertValues(stateMstVO_p) ---->"+ ChallanPerformanceVO_p.getStrMsgString());
		}
	}

	/**
	 * 
	 * @param ChallanPerformanceVO_p
	 */
	public void insertChallanRecord(ChallanPerformanceVO ChallanPerformanceVO_p) 
	{
		ChallanPerformanceDAO.insertChallanRecord(ChallanPerformanceVO_p);

		if (ChallanPerformanceVO_p.getStrMsgType().equals("1")) 
		{
			ChallanPerformanceVO_p.setStrMsgString("ChallanPerformanceVO.insertChallanRecord(stateMstVO_p) ---->"+ ChallanPerformanceVO_p.getStrMsgString());
		}
	}

	
	/**
	 * 
	 * @param ChallanPerformanceVO_p
	 */
	public void getPoNoCmb(ChallanPerformanceVO ChallanPerformanceVO_p)
	{
		
		ChallanPerformanceDAO.getData(ChallanPerformanceVO_p);
		
		if (ChallanPerformanceVO_p.getStrMsgType().equals("1")) {
			
			String strErr = ChallanPerformanceVO_p.getStrMsgString();
				
			ChallanPerformanceVO_p.setStrMsgString("ChallanPerformanceBO.getDWHSubStoreCmb()-->"+strErr);
		}		
	}
	
	/**
	 * 
	 * @param ChallanPerformanceVO_p
	 */
	public void getSupplierCmb(ChallanPerformanceVO ChallanPerformanceVO_p)
	{
		
		ChallanPerformanceDAO.getSuppliedByList(ChallanPerformanceVO_p);
		
		if (ChallanPerformanceVO_p.getStrMsgType().equals("1")) {
			
			String strErr = ChallanPerformanceVO_p.getStrMsgString();
				
			ChallanPerformanceVO_p.setStrMsgString("ChallanPerformanceBO.getSupplierCmb()-->"+strErr);
		}		
	}
	
	
	/**
	 * 
	 * @param ChallanPerformanceVO_p
	 */
	public void getChallanNoCmb(ChallanPerformanceVO ChallanPerformanceVO_p)
	{
		
		ChallanPerformanceDAO.getData(ChallanPerformanceVO_p);
		
		if (ChallanPerformanceVO_p.getStrMsgType().equals("1")) {
			
			String strErr = ChallanPerformanceVO_p.getStrMsgString();
				
			ChallanPerformanceVO_p.setStrMsgString("ChallanPerformanceBO.getDWHSubStoreCmb()-->"+strErr);
		}		
	}
	
	/**
	 * 
	 * @param ChallanPerformanceVO_p
	 */
	public void getItemNameCmb(ChallanPerformanceVO ChallanPerformanceVO_p)
	{
		
		ChallanPerformanceDAO.getItemCmb(ChallanPerformanceVO_p);
		
		if (ChallanPerformanceVO_p.getStrMsgType().equals("1")) {
			
			String strErr = ChallanPerformanceVO_p.getStrMsgString();
				
			ChallanPerformanceVO_p.setStrMsgString("ChallanPerformanceBO.getDWHSubStoreCmb()-->"+strErr);
		}		
	}
	
	
	/**
	 * 
	 * @param ChallanPerformanceVO_p
	 */
	public void getChallanDtl(ChallanPerformanceVO ChallanPerformanceVO_p)
	{
		
		ChallanPerformanceDAO.getChallanDtl(ChallanPerformanceVO_p);
		
		if (ChallanPerformanceVO_p.getStrMsgType().equals("1")) {
			
			String strErr = ChallanPerformanceVO_p.getStrMsgString();
				
			ChallanPerformanceVO_p.setStrMsgString("ChallanPerformanceBO.getChallanDtl()-->"+strErr);
		}		
	}
	
	
	
	/**
	 *	To Get  Prev Budget Dtls
	 *
	 * @param budgetAllocationDetailProcessTransVO
	 */
	public void getSupplierPerformancePendingDtlView(ChallanPerformanceVO ChallanPerformanceVO_p) 
	{
		
		ChallanPerformanceDAO.getData(ChallanPerformanceVO_p);
		
		if (ChallanPerformanceVO_p.getStrMsgType().equals("1")) {
			
			String strErr = ChallanPerformanceVO_p.getStrMsgString();
				
			ChallanPerformanceVO_p.setStrMsgString("ChallanPerformanceBO.viewBudgetDetailsRecord()-->"+strErr);
		}
	}

	
	/**
	 * 
	 * @param ChallanPerformanceVO_p
	 */
	public void getBudgetUsed(ChallanPerformanceVO ChallanPerformanceVO_p)
	{
		ChallanPerformanceVO_p.setStrMode("1");
		ChallanPerformanceDAO.getData(ChallanPerformanceVO_p);
		
		if (ChallanPerformanceVO_p.getStrMsgType().equals("1")) {
			
			String strErr = ChallanPerformanceVO_p.getStrMsgString();
				
			ChallanPerformanceVO_p.setStrMsgString("ChallanPerformanceBO.getBudgetUsed()-->"+strErr);
		}		
	}
	
}
