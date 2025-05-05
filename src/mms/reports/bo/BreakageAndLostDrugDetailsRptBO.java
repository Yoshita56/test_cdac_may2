package mms.reports.bo;

import mms.reports.dao.BreakageAndLostDrugDetailsRptDAO;
import mms.reports.vo.BreakageAndLostDrugDetailsRptVO;


public class BreakageAndLostDrugDetailsRptBO 
{

	
	/**
	 * To get Drug Warehouse Type Combo
	 * 
	 * @param voObj
	 */
	public void getInitializedValues(BreakageAndLostDrugDetailsRptVO voObj)
	{
	
    	BreakageAndLostDrugDetailsRptDAO.getStoreList(voObj);
//	BreakageAndLostDrugDetailsRptDAO.getDistrictStoreList(voObj);
	
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("BreakageAndLostDrugDetailsRptBO.getDwhTypeCombo()-->"+strErr);
		}
	}
	

	public void getItemCatList(BreakageAndLostDrugDetailsRptVO voObj){
		
		BreakageAndLostDrugDetailsRptDAO.getItemCatList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("BreakageAndLostDrugDetailsRptBO.getItemCatList()-->"+strErr);
				}
				
		}
	
	
	public void setViewPageDtl(BreakageAndLostDrugDetailsRptVO voObj){
		BreakageAndLostDrugDetailsRptDAO.getViewDtl(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("BreakageAndLostDrugDetailsRptBO.setViewPageDtl() --> "+ voObj.getStrMsgString());
		  }
	}
	
	public void getImgHeader(BreakageAndLostDrugDetailsRptVO voObj){
		BreakageAndLostDrugDetailsRptDAO.getImageHeader(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("BreakageAndLostDrugDetailsRptBO.setViewPageDtl() --> "+ voObj.getStrMsgString());
		  }
	}
	
	
}
