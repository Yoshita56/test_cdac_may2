/**
 * 
 */
package mms.reports.bo;

import mms.reports.dao.ListSupplierNotSendingRptDAO;
import mms.reports.vo.ListSupplierNotSendingRptVO;

/**
 * @author user
 *
 */
public class ListSupplierNotSendingRptBO {
	
	/**
	 * To get values of Item Category Name:
	 * 
	 * @param vo
	 */
	public void initialAdd(ListSupplierNotSendingRptVO vo)
	{
		ListSupplierNotSendingRptDAO.itemCategoryName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ListSupplierNotSendingRptBO.initialAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	

}
