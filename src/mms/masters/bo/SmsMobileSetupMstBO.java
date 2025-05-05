package mms.masters.bo;


import mms.masters.dao.SmsMobileSetupMstDAO;
import mms.masters.vo.SmsMobileSetupMstVO;

public class SmsMobileSetupMstBO
{

	/**
	 * to get data for Hem Config page.
	 * 
	 * @param vo_p the SmsMobileSetupMstVO
	 * 
	 */
	public void getRecord(SmsMobileSetupMstVO vo_p)
	{
		SmsMobileSetupMstDAO.getRecord(vo_p);
		if (vo_p.getStrMsgType().equals("1")) {
			vo_p.setStrMsgString("SmsMobileSetupMstBO.getRecord(vo_p) --> " + vo_p.getStrMsgString());
		}
	}
	
	
	/**
	 * to get data for Hem Config page.
	 * 
	 * @param vo_p the SmsMobileSetupMstVO
	 * 
	 */
	public void getMobileNos(SmsMobileSetupMstVO vo_p)
	{
		SmsMobileSetupMstDAO.getMobileNos(vo_p);
		if (vo_p.getStrMsgType().equals("1")) {
			vo_p.setStrMsgString("SmsMobileSetupMstBO.getRecord(vo_p) --> " + vo_p.getStrMsgString());
		}
	}
	
	
	
	
	/**
	 * to save the record.
	 * 
	 * @param vo_p the SmsMobileSetupMstVO
	 */
	public void saveRecord(SmsMobileSetupMstVO vo_p) 
	{

			SmsMobileSetupMstDAO.saveRecord(vo_p);
	
			
			if (vo_p.getStrMsgType().equals("1"))
			{
				vo_p.setStrMsgString("SmsMobileSetupMstBO.saveRecord() --> "	+ vo_p.getStrMsgString());
			}		
	}
}
