package mms.reports.bo;

import mms.reports.dao.HelpDeskRptDAO;
import mms.reports.vo.HelpDeskRptVO;

public class HelpDeskRptBO {
	
	/**
	 * To get Drug Warehouse Type Combo
	 * 
	 * @param voObj
	 */
	public void getInitializedValues(HelpDeskRptVO voObj)
	{
	
	    HelpDeskRptDAO.getSuppliedByList(voObj);
	    HelpDeskRptDAO.getMenuName(voObj);
	    HelpDeskRptDAO.getDeptName(voObj);
	    HelpDeskRptDAO.getStatusName(voObj);
	    
	    
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("HelpDeskRptBO.getDwhTypeCombo()-->"+strErr);
		}
	}
	
	
	
	
	public void getScreenTwo(HelpDeskRptVO voObj)
	{
	
		//System.out.println("DAO Strid"+ voObj.getStrStoreId());
		HelpDeskRptDAO.getScreenTwo(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("HelpDeskRptBO.getScreenTwo()-->"+strErr);
		}
	}
	
	
	
	
	
	
}
