package mms.reports.bo;

import mms.reports.dao.ListBlackListedSupplierRptDAO;
import mms.reports.dao.ReturnDetailRptDAO;
import mms.reports.vo.ListBlackListedSupplierRptVO;
import mms.reports.vo.ReturnDetailRptVO;

public class ListBlackListedSupplierRptBO {
	
	public void getItemCatList(ListBlackListedSupplierRptVO voObj){
		
		ListBlackListedSupplierRptDAO.getItemCatList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("ListBlackListedSupplierRptBO.getItemCatList()-->"+strErr);
				}
				
		}
	public void getHospitalName(ListBlackListedSupplierRptVO voObj)
	{
		ListBlackListedSupplierRptDAO.getHospitalName(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
			String strErr = voObj.getStrMsgString();
			voObj.setStrMsgString("ListBlackListedSupplierRptBO.getHospitalName()-->"+strErr);
		}		
	}

}
