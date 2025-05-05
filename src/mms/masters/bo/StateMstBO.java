package mms.masters.bo;

import mms.masters.dao.StateMstDAO;
import mms.masters.vo.StateMstVO;


/**
 * @author Vivek Aggarwal  
 * Creation Date:- 1-June-2011 
 * Modifying Date:- 3-June-2011
 * Used For:- 
 * Team Lead By:-  
 *  Module:- DWH(HIS Project)
 * 
 */
public class StateMstBO 
{
	
	/**
	 * to get Country Combo Value.
	 * 
	 * @param vo the vo
	 * 
	 */
	public void initializeAdd(StateMstVO stateMstVO_p) {

		StateMstDAO.getCountryName(stateMstVO_p);

			if (stateMstVO_p.getStrMsgType().equals("1")) 
			{
				stateMstVO_p.setStrMsgString("StateMstBO.initializeAdd(stateMstVO_p) --> "	+ stateMstVO_p.getStrMsgString());
			}
	}
	
	
	/**
	 * To insert data.
	 * 
	 * @param vo the vo
	 * 
 	 */
	public void insertRecord(StateMstVO stateMstVO_p) {
		
		StateMstDAO.chkDuplicate(stateMstVO_p,"insert");
		
		if (stateMstVO_p.isBExistStatus() == true)	//no duplicacy , so new record is added
		{

			StateMstDAO.save(stateMstVO_p);

			if (stateMstVO_p.getStrMsgType().equals("1")) 
			{
				stateMstVO_p.setStrMsgString("StateMstBO.insertValues(stateMstVO_p) ---->"+ stateMstVO_p.getStrMsgString());
			}
		}
		
			if (stateMstVO_p.getStrMsgType().equals("1")) 
			{
				stateMstVO_p.setStrMsgString("StateMstBO.insertRecord() --> "+ stateMstVO_p.getStrMsgString());
			}
	}
	
	
	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 * 
	 */
	public void modifyRecord(StateMstVO stateMstVO_p)
	{
		StateMstDAO.modifyRecord(stateMstVO_p);
		if (stateMstVO_p.getStrMsgType().equals("1")) {
			stateMstVO_p.setStrMsgString("StateMstBO.modifyRecord(stateMstVO_p) --> "
					+ stateMstVO_p.getStrMsgString());
		}
	}
	
	/**
	 * to update the record.
	 * 
	 * @param stateMstVO_p the vo
	 */
	public void updateRecord(StateMstVO stateMstVO_p) 
	{
		StateMstDAO.chkDuplicate(stateMstVO_p,"update");
		
		if (stateMstVO_p.isBExistStatus() == true)	//no duplicacy , so new record is added
		{
			StateMstDAO.save(stateMstVO_p);
		}	
			
			if (stateMstVO_p.getStrMsgType().equals("1"))
			{
				stateMstVO_p.setStrMsgString("StateMstBO.updateRecord() --> " + stateMstVO_p.getStrMsgString());
			}		
	}
}