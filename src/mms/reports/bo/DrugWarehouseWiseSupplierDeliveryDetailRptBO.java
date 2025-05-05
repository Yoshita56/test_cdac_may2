package mms.reports.bo;

import mms.reports.dao.DrugWarehouseWiseSupplierDeliveryDetailRptDAO;
import mms.reports.vo.DrugWarehouseWiseSupplierDeliveryDetailRptVO;

public class DrugWarehouseWiseSupplierDeliveryDetailRptBO 
{

	
	/**
	 * To get Drug Warehouse Type Combo
	 * 
	 * @param voObj
	 */
	public void getInitializedValues(DrugWarehouseWiseSupplierDeliveryDetailRptVO voObj)
	{
	
//	DrugWarehouseWiseSupplierDeliveryDetailRptDAO.getDwhTypeCombo(voObj);
	DrugWarehouseWiseSupplierDeliveryDetailRptDAO.getStoreList(voObj);	
	DrugWarehouseWiseSupplierDeliveryDetailRptDAO.getSuppliedByList(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("DrugWarehouseWiseSupplierDeliveryDetailRptBO.getDwhTypeCombo()-->"+strErr);
		}
	}
}
