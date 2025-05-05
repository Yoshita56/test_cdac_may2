package mms.transactions.bo;

import mms.transactions.dao.DrugDistributionMonitoringDetailTransDAO;
import mms.transactions.vo.DrugDistributionMonitoringDetailTransVO;

public class DrugDistributionMonitoringDetailTransBO 
{
	
	public void getDepartmentValues(DrugDistributionMonitoringDetailTransVO voObj){
		
		DrugDistributionMonitoringDetailTransDAO.getDepartmentValues(voObj);
		
		
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("DrugDistributionMonitoringDetailTransBO.getDepartmentValues()-->"+strErr);
				}
				
		}
	
		
	/**
	 * 
	 * @param voObj
	 */
	public void getUnitDetails(DrugDistributionMonitoringDetailTransVO voObj){
		
		DrugDistributionMonitoringDetailTransDAO.getUnitDetails(voObj);
		
		
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("DrugDistributionMonitoringDetailTransBO.getUnitDetails()-->"+strErr);
				}
				
		}
	
	
	/**
	 *	To Get Patient Details Record
	 *
	 * @param budgetAllocationDetailProcessTransVO
	 */
	public void viewPatientDetailsRecord(DrugDistributionMonitoringDetailTransVO drugDistributionMonitoringDetailTransVO_p) 
	{
		
		DrugDistributionMonitoringDetailTransDAO.getData(drugDistributionMonitoringDetailTransVO_p);
		
		if (drugDistributionMonitoringDetailTransVO_p.getStrMsgType().equals("1")) {
			
			String strErr = drugDistributionMonitoringDetailTransVO_p.getStrMsgString();
				
			drugDistributionMonitoringDetailTransVO_p.setStrMsgString("BudgetAllocationDetailProcessTransBO.viewPatientDetailsRecord()-->"+strErr);
		}
	}
	
	
	
	   public void getScanFlag(DrugDistributionMonitoringDetailTransVO voObj)
       {
		   	DrugDistributionMonitoringDetailTransDAO.getScanFlag(voObj);
			if (voObj.getStrMsgType().equals("1")) {
				String strErr = voObj.getStrMsgString();
				voObj.setStrMsgString("DrugDistributionMonitoringDetailTransBO.getScanFlag()-->"+strErr);
			}
				
		}


	public void getEpisodeVisitCmb(DrugDistributionMonitoringDetailTransVO voObj) {
		
			DrugDistributionMonitoringDetailTransDAO.getEpisodeVisitCmb(voObj);
			if (voObj.getStrMsgType().equals("1")) {
				String strErr = voObj.getStrMsgString();
				voObj.setStrMsgString("DrugDistributionMonitoringDetailTransBO.getEpisodeVisitCmb()-->"+strErr);
			}
				
		}
		
}	