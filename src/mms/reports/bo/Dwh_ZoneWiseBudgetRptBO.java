package mms.reports.bo;

import mms.reports.dao.Dwh_ZoneWiseBudgetRptDAO;
import mms.reports.vo.Dwh_ZoneWiseBudgetRptVO;

public class Dwh_ZoneWiseBudgetRptBO {
	
	
	
	
	
	
	public void getZoneWiseBudgetDtl(Dwh_ZoneWiseBudgetRptVO voObj)
	{
	
	    Dwh_ZoneWiseBudgetRptDAO.getZoneWiseBudgetDtl(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("Dwh_ZoneWiseBudgetRptBO.getZoneWiseBudgetDtl()-->"+strErr);
		}
	}

}
