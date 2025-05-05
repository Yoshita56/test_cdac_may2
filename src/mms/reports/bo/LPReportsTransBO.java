package mms.reports.bo;

import mms.reports.dao.LPReportsTransDAO;
import mms.reports.vo.LPReportsTransVO;

public class LPReportsTransBO {
	
public void getStoreList(LPReportsTransVO voObj){
		
		LPReportsTransDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("LPReportsTransBO.getStoreList()-->"+strErr);
				}
				
		}

public void getItemCatList(LPReportsTransVO voObj){
	
	LPReportsTransDAO.getItemCatList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("LPReportsTransBO.getItemCatList()-->"+strErr);
			}
			
	}
public void getPOTypeList(LPReportsTransVO voObj){
	
	LPReportsTransDAO.getPOTypeList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("LPReportsTransBO.getPOTypeList()-->"+strErr);
			}
			
	}
public void getSupplierList(LPReportsTransVO voObj){
	
	LPReportsTransDAO.getSupplierList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("LPReportsTransBO.getSupplierList()-->"+strErr);
			}
			
	}


	public void getHospitalName(LPReportsTransVO voObj)
	{
		LPReportsTransDAO.getHospitalName(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
			String strErr = voObj.getStrMsgString();
			voObj.setStrMsgString("LPReportsTransBO.getHospitalName()-->"+strErr);
		}		
	}
	
	public void getReport(LPReportsTransVO voObj)
	{
		LPReportsTransDAO.getReport(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
			String strErr = voObj.getStrMsgString();
			voObj.setStrMsgString("LPReportsTransBO.getReport()-->"+strErr);
		}		
	}
}
