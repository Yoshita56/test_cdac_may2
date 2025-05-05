package mms.reports.bo;

import mms.reports.dao.PurchaseOrderDtlRptDAO;
import mms.reports.vo.PurchaseOrderDtlRptVO;

public class PurchaseOrderDtlRptBO {
	
public void getStoreList(PurchaseOrderDtlRptVO voObj){
		
		PurchaseOrderDtlRptDAO.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("PurchaseOrderDtlRptBO.getStoreList()-->"+strErr);
				}
				
		}

public void getItemCatList(PurchaseOrderDtlRptVO voObj){
	
	PurchaseOrderDtlRptDAO.getItemCatList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("PurchaseOrderDtlRptBO.getItemCatList()-->"+strErr);
			}
			
	}
public void getPOTypeList(PurchaseOrderDtlRptVO voObj){
	
	PurchaseOrderDtlRptDAO.getPOTypeList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("PurchaseOrderDtlRptBO.getPOTypeList()-->"+strErr);
			}
			
	}
public void getSupplierList(PurchaseOrderDtlRptVO voObj){
	
	PurchaseOrderDtlRptDAO.getSupplierList(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("PurchaseOrderDtlRptBO.getSupplierList()-->"+strErr);
			}
			
	}


	public void getHospitalName(PurchaseOrderDtlRptVO voObj)
	{
		PurchaseOrderDtlRptDAO.getHospitalName(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
			String strErr = voObj.getStrMsgString();
			voObj.setStrMsgString("PurchaseOrderDtlRptBO.getHospitalName()-->"+strErr);
		}		
	}
}
