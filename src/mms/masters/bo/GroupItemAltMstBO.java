package mms.masters.bo;

import mms.masters.dao.GroupItemAltMstDAO;

import mms.masters.vo.GroupItemAltMstVO;

/**
 * The Class ComponentMstBO.
 * 
 * @author amit kumar ateria
 */

public class GroupItemAltMstBO 
{

	/**
	 * for getting option value of item category name combo on add page.
	 * 
	 * @param vo the vo
	 */

	public void initAdd(GroupItemAltMstVO vo) 
	{
		GroupItemAltMstDAO.comboQuery(vo);

		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("GroupItemAltMstBO.initAdd() --> "+ vo.getStrMsgString());
		}
	}
	/**
	 * for getting option value of existing item combo on add page.
	 * 
	 * @param vo the vo
	 */
	public void getExGroup(GroupItemAltMstVO vo) 
	{
		GroupItemAltMstDAO.getExGroup(vo);

		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("GroupItemAltMstBO.getExGroup() --> "+ vo.getStrMsgString());
		}
	}
	/**
	 * for getting option value of replaced subgroup combo on add page.
	 * 
	 * @param vo the vo
	 */
	public void getRpSubGroup(GroupItemAltMstVO vo) 
	{
		GroupItemAltMstDAO.getRpSubGroup(vo);

		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("GroupItemAltMstBO.getExGroup() --> "+ vo.getStrMsgString());
		}
	}
	/**
	 * for getting option value of existing item combo on add page.
	 * 
	 * @param vo the vo
	 */
	public void getExItems(GroupItemAltMstVO vo) 
	{
		GroupItemAltMstDAO.getExItems(vo);

		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("GroupItemAltMstBO.getExGroup() --> "+ vo.getStrMsgString());
		}
	}
	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public void insertRecord(GroupItemAltMstVO vo)
	{
		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("GroupItemAltMstBO.insertRecord()"+ vo.getStrMsgString());
		}
		GroupItemAltMstDAO.insertQuery(vo);
		if (vo.getStrMsgType().equals("1")) 
		{
				vo.setStrMsgString("GroupItemAltMstBO.insertRecord()"+ vo.getStrMsgString());
		}
	}
}