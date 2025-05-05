/**
 * 
 */
package mms.reports.bo;

import mms.reports.dao.ItemWiseConsumptionRptDAO;
import mms.reports.dao.PurchaseOrderDtlRptDAO;
import mms.reports.vo.ItemWiseConsumptionRptVO;
import mms.reports.vo.PurchaseOrderDtlRptVO;

/**
 * Developer : Tanvi Sappal
 * Version : 1.0 Date : 17/July/2009
 * Module : MMS 
 */
public class ItemWiseConsumptionRptBO {

	/**
	 * To get values of Item Category Name:
	 * 
	 * @param vo
	 */
	public void initialAdd(ItemWiseConsumptionRptVO vo)
	{
		ItemWiseConsumptionRptDAO.itemCategoryName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ItemWiseConsumptionRptBO.initialAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Group Name associate with Item Category:
	 * 
	 * @param vo
	 */
	public void getGroupName(ItemWiseConsumptionRptVO vo)
	{
		ItemWiseConsumptionRptDAO.groupName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ItemWiseConsumptionRptBO.getGroupName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of SubGroup Name associate with Group Name:
	 * 
	 * @param vo
	 */
	public void getSubGroupName(ItemWiseConsumptionRptVO vo)
	{
		ItemWiseConsumptionRptDAO.subGroupName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ItemWiseConsumptionRptBO.getSubGroupName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Generic Item Name associate with Store, Item Category, Group Name, SubGrp:
	 * 
	 * @param vo
	 */
	public void getItemName(ItemWiseConsumptionRptVO vo)
	{
		ItemWiseConsumptionRptDAO.ItemName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ItemWiseConsumptionRptBO.getGenItemName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	public void getHospitalName(ItemWiseConsumptionRptVO voObj)
	{
		ItemWiseConsumptionRptDAO.getHospitalName(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
			String strErr = voObj.getStrMsgString();
			voObj.setStrMsgString("ItemWiseConsumptionRptBO.getHospitalName()-->"+strErr);
		}		
	}
	
	public void showReportNew(ItemWiseConsumptionRptVO voObj)
	{
		ItemWiseConsumptionRptDAO.showReportNew(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
			String strErr = voObj.getStrMsgString();
			voObj.setStrMsgString("ItemWiseConsumptionRptBO.showReportNew()-->"+strErr);
		}		
	}
	
}
