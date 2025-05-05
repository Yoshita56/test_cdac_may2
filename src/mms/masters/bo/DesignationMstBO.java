package mms.masters.bo;

import mms.masters.dao.DesignationMstDAO;
import mms.masters.vo.DesignationMstVO;

public class DesignationMstBO 
{
  
	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public void insertQuery(DesignationMstVO vo) 
	{
		DesignationMstDAO.chkDuplicate(vo);
		
		if (vo.getStrMsgType().equals("1")) 
		{

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("DesignationMstBO.insertQuery() --> " + strErr);
		}
		if (vo.getBExistStatus() == true)
		{
			DesignationMstDAO.insert(vo);

			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("DesignationMstBO.insertQuery() --> "
						+ strErr);
			}
		}
	}
	
	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */

	public void modifyRecord(DesignationMstVO vo) 
	{
		DesignationMstDAO.modifyQuery(vo);

		if (vo.getStrMsgType().equals("1")) 
		{

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("DesignationMstBO.modifyRecord() --> " + strErr);
		}

	}
	
	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(DesignationMstVO vo) 
	{
		DesignationMstDAO.initialUpdateQuery(vo);
		if (vo.getStrMsgType().equals("1")) 
		{

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("DesignationMstBO.updateRecord() --> " + strErr);
		}
		if (vo.getBExistStatus() == true)
		{
			DesignationMstDAO.insert(vo);
			if (vo.getStrMsgType().equals("1")) 
			{

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("DesignationMstBO.updateRecord() --> "
						+ strErr);
			}
		}
	}
	

}
