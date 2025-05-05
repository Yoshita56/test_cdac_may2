package mms.reports.bo;

import mms.reports.dao.ListSuppPerformanceRptDAO;
import mms.reports.vo.ListSuppPerformanceRptVO;

public class ListSuppPerformanceRptBO {
	
	/**
	 * To get values of Item Category Name:
	 * 
	 * @param vo
	 */
	
		public void initialAdd(ListSuppPerformanceRptVO vo)
		{
			ListSuppPerformanceRptDAO.itemCategoryName(vo);
			if(vo.getStrMsgType().equals("1"))
			{
					vo.setStrMsgString("ListSuppPerformanceRptBO.initialAdd---->"+vo.getStrMsgString());
					vo.setStrMsgType("1");
			}
		}
		

}
