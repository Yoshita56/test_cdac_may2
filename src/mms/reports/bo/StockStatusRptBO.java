/**
 * 
 */
package mms.reports.bo;

import mms.reports.dao.ReturnDetailRptDAO;
import mms.reports.dao.StockStatusRptDAO;
import mms.reports.vo.ReturnDetailRptVO;
import mms.reports.vo.StockStatusRptVO;

/**
 * Developer : Tanvi Sappal
 * Version : 1.0 
 * Date : 21/July/2009
 * Module : MMS 
 */
public class StockStatusRptBO {
	
	/**
	 * To get values of Store Name:
	 * 
	 * @param vo
	 */
	public void initialAdd(StockStatusRptVO vo)
	{
		StockStatusRptDAO.storeName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("StockStatusRptBO.initialAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Store Name:
	 * 
	 * @param vo
	 */
	public void getItemCategory(StockStatusRptVO vo)
	{
		StockStatusRptDAO.itemCategory(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("StockStatusRptBO.getItemCategory---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Store Name:
	 * 
	 * @param vo
	 */
	public void getGroupName(StockStatusRptVO vo)
	{
		StockStatusRptDAO.groupName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("StockStatusRptBO.getGroupName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void getHospitalName(StockStatusRptVO voObj)
	{
		StockStatusRptDAO.getHospitalName(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
			String strErr = voObj.getStrMsgString();
			voObj.setStrMsgString("StockStatusRptBO.getHospitalName()-->"+strErr);
		}		
	}

}
