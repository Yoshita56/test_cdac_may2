package mms.masters.bo;

import mms.masters.dao.SchemeMstDAO;
import mms.masters.vo.SchemeMstVO;

/**
 * @author:-	Adil Wasi   
 * Creation Date:- 1-Jun-2011 
 * Modifying Date:- 
 * Used For:-	
 * Team Lead By:-	
 *  Module:- DWH(HIS Project)
 * 
 */


/**
 * The Class SchemeMstBO.
 */
public class SchemeMstBO {

	
	/**
	 * for getting current date value of effective from field on add page.
	 * 
	 * @param schemeMstVO_p the vo
	 * 
	 * @throws Exception 	 */
	
	
	/**
	 * to insert the data.
	 * 
	 * @param schemeMstVO_p the schemeMstVO_p
	 */
	public void insertRecord(SchemeMstVO schemeMstVO_p) {
		
		/**
		 * to check duplicate before insert and insert the data.
		 * 
		 * @param schemeMstVO_p the schemeMstVO_p
		 */
		SchemeMstDAO.chkDuplicate(schemeMstVO_p,"insert");
	
		if (schemeMstVO_p.getBExistStatus() == true)	//no duplicacy , so new record is added
		{
	
			SchemeMstDAO.save(schemeMstVO_p, "insert");
			if (schemeMstVO_p.getStrMsgType().equals("1")) 
			{
				schemeMstVO_p.setStrMsgString("SchemeMstBO.insertValues(schemeMstVO_p) ---->"+ schemeMstVO_p.getStrMsgString());
			}
		}
		
		if (schemeMstVO_p.getStrMsgType().equals("1")) 
		{
			schemeMstVO_p.setStrMsgString("SchemeMstBO.insertRecord() --> "+ schemeMstVO_p.getStrMsgString());
		}
	}
	
	/**
	 * to get data for modify page.
	 * 
	 * @param schemeMstVO_p the vo
	 * 
	 */
	public void modifyRecord(SchemeMstVO schemeMstVO_p)
	{
		SchemeMstDAO.modifyRecord(schemeMstVO_p);
		if (schemeMstVO_p.getStrMsgType().equals("1")) {
			schemeMstVO_p.setStrMsgString("SchemeMstBO.modifyRecord(vo) --> "
					+ schemeMstVO_p.getStrMsgString());
		}
	}
	
	
	/**
	 * to check duplicate before update, and update the record.
	 * 
	 * @param schemeMstVO_p the vo
	 */
	public void updateRecord(SchemeMstVO schemeMstVO_p) 
	{
		SchemeMstDAO.chkDuplicate(schemeMstVO_p,"update");
		
		if (schemeMstVO_p.getBExistStatus() == true)	//no duplicacy , so new record is added
		{
			SchemeMstDAO.save(schemeMstVO_p,"update");
		}	
			
		if (schemeMstVO_p.getStrMsgType().equals("1"))
		{
			schemeMstVO_p.setStrMsgString("SchemeMstBO.updateRecord() --> "
			+ schemeMstVO_p.getStrMsgString());
		}		
	}
}
