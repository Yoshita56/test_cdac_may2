/**
 * 
 */
package mms.reports.bo;

import mms.reports.dao.ListItemAuctionedRptDAO;
import mms.reports.vo.ListItemAuctionedRptVO;

/**
 * Developer : Tanvi Sappal
 * Version : 1.0 Date : 17/July/2009
 * Module : MMS 
 */
public class ListItemAuctionedRptBO {
	
	/**
	 * To get values of Item Category Name:
	 * 
	 * @param vo
	 */
	public void initialAdd(ListItemAuctionedRptVO vo)
	{
		ListItemAuctionedRptDAO.itemCategoryName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ListItemAuctionedRptBO.initialAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}

}
