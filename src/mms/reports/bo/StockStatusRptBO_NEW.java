/**
 * 
 */
package mms.reports.bo;


import mms.reports.dao.StockStatusRptDAO_NEW;

import mms.reports.vo.StockStatusRptVO_NEW;

/**
 * Developer : Tanvi Sappal
 * Version : 1.0 
 * Date : 21/July/2009
 * Module : MMS 
 */
public class StockStatusRptBO_NEW {
	
	/**
	 * To get values of Store Name:
	 * 
	 * @param vo
	 */
	public void initialAdd(StockStatusRptVO_NEW vo)
	{
		StockStatusRptDAO_NEW.storeName(vo);
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
	public void getItemCategory(StockStatusRptVO_NEW vo)
	{
		StockStatusRptDAO_NEW.itemCategory(vo);
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
	public void getGroupName(StockStatusRptVO_NEW vo)
	{
		StockStatusRptDAO_NEW.groupName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("StockStatusRptBO.getGroupName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void getHospitalName(StockStatusRptVO_NEW voObj)
	{
		StockStatusRptDAO_NEW.getHospitalName(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
			String strErr = voObj.getStrMsgString();
			voObj.setStrMsgString("StockStatusRptBO.getHospitalName()-->"+strErr);
		}		
	}

}
