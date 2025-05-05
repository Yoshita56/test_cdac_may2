package mms.reports.bo;

import mms.reports.dao.ReturnDetailRptDAO;
import mms.reports.dao.SummaryListIndentPurchaseRptDAO;
import mms.reports.vo.ReturnDetailRptVO;
import mms.reports.vo.SummaryListIndentPurchaseRptVO;

public class SummaryListIndentPurchaseRptBO {
public void getItemCatList(SummaryListIndentPurchaseRptVO voObj){
		
		SummaryListIndentPurchaseRptDAO.getItemCatList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("SummaryListIndentPurchaseRptBO.getItemCatList()-->"+strErr);
				}
				
		}

public void getPurchaseTypeList(SummaryListIndentPurchaseRptVO voObj){
	
	SummaryListIndentPurchaseRptDAO.getPurchaseTypeList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("SummaryListIndentPurchaseRptBO.getPurchaseTypeList()-->"+strErr);
			}
			
	}
public void getHospitalName(SummaryListIndentPurchaseRptVO voObj)
{
	SummaryListIndentPurchaseRptDAO.getHospitalName(voObj);
	if (voObj.getStrMsgType().equals("1")) 
	{
		String strErr = voObj.getStrMsgString();
		voObj.setStrMsgString("IssueDetailRptBO.getHospitalName()-->"+strErr);
	}		
}
}
