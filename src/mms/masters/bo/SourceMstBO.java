package mms.masters.bo;

import mms.masters.dao.SourceMstDAO;
import mms.masters.vo.SourceMstVO;

/**
 * @author:-	Adil Wasi   
 * Creation Date:- 6-Jun-2011 
 * Modifying Date:- 
 * Used For:-	
 * Team Lead By:-	
 *  Module:- DWH(HIS Project)
 * 
 */


/**
 * The Class SourceMstBO.
 */
public class SourceMstBO {

	
	/**
	 * for getting current date value of effective from field on add page.
	 * 
	 * @param sourceMstVO_p the vo
	 * 
	 * @throws Exception 	 */
	
	
	/**
	 * to insert the data.
	 * 
	 * @param sourceMstVO_p the sourceMstVO_p
	 */
	public void insertRecord(SourceMstVO sourceMstVO_p) {
		
		/**
		 * to check duplicate before insert and insert the data.
		 * 
		 * @param sourceMstVO_p the sourceMstVO_p
		 */
		SourceMstDAO.chkDuplicate(sourceMstVO_p,"insert");
	
		if (sourceMstVO_p.getBExistStatus() == true)	//no duplicacy , so new record is added
		{
	
			SourceMstDAO.save(sourceMstVO_p, "insert");
			if (sourceMstVO_p.getStrMsgType().equals("1")) 
			{
				sourceMstVO_p.setStrMsgString("SourceMstBO.insertValues(sourceMstVO_p) ---->"+ sourceMstVO_p.getStrMsgString());
			}
		}
		
		if (sourceMstVO_p.getStrMsgType().equals("1")) 
		{
			sourceMstVO_p.setStrMsgString("SourceMstBO.insertRecord() --> "+ sourceMstVO_p.getStrMsgString());
		}
	}
	
	/**
	 * to get data for modify page.
	 * 
	 * @param sourceMstVO_p the vo
	 * 
	 */
	public void modifyRecord(SourceMstVO sourceMstVO_p)
	{
		SourceMstDAO.modifyRecord(sourceMstVO_p);
		if (sourceMstVO_p.getStrMsgType().equals("1")) {
			sourceMstVO_p.setStrMsgString("SourceMstBO.modifyRecord(vo) --> "
					+ sourceMstVO_p.getStrMsgString());
		}
	}
	
	
	/**
	 * to check duplicate before update, and update the record.
	 * 
	 * @param sourceMstVO_p the vo
	 */
	public void updateRecord(SourceMstVO sourceMstVO_p) 
	{
		SourceMstDAO.chkDuplicate(sourceMstVO_p,"update");
		
		if (sourceMstVO_p.getBExistStatus() == true)	//no duplicacy , so new record is added
		{
			SourceMstDAO.save(sourceMstVO_p,"update");
		}	
			
		if (sourceMstVO_p.getStrMsgType().equals("1"))
		{
			sourceMstVO_p.setStrMsgString("SourceMstBO.updateRecord() --> "
			+ sourceMstVO_p.getStrMsgString());
		}		
	}
}

