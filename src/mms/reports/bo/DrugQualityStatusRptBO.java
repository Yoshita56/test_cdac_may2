package mms.reports.bo;

import mms.reports.dao.DrugQualityStatusRptDAO;
import mms.reports.vo.DrugQualityStatusRptVO;

public class DrugQualityStatusRptBO 
{
	/**
	 * To get values of Group Name associate with Item Category:
	 * 
	 * @param vo
	 */
	public void getGroupName(DrugQualityStatusRptVO vo)
	{
		DrugQualityStatusRptDAO.groupName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("DrugQualityStatusRptBO.getGroupName()-->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}

	/**
	 * To get values of Group Name associate with Item Category:
	 * 
	 * @param vo
	 */
	public void getDrugName(DrugQualityStatusRptVO vo)
	{
		DrugQualityStatusRptDAO.ItemName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("DrugQualityStatusRptBO.getDrugName()---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}

}
