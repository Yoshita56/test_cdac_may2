package mms.reports.bo;

import mms.reports.dao.TotalDrugCountRptDAO;
import mms.reports.vo.TotalDrugCountRptVO;

	public class TotalDrugCountRptBO {
	
	public void getStoreList(TotalDrugCountRptVO voObj,String strUserLevel){
		
		if(strUserLevel.equals("6")){
			voObj.setStrMode("6");
		}
		else
			voObj.setStrMode("1");
		TotalDrugCountRptDAO.getStoreList(voObj);
		
		if(strUserLevel.equals("6")){
			voObj.setStrMode("4");
		}
		else
			voObj.setStrMode("5");
		
	//	TotalDrugCountRptDAO.getDistrictStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("TotalDrugCountRptBO.getStoreList()-->"+strErr);
				}
				
		}

	public void getItemCatList(TotalDrugCountRptVO voObj){
	
	TotalDrugCountRptDAO.getItemCatList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("TotalDrugCountRptBO.getItemCatList()-->"+strErr);
			}
			
	}


}
