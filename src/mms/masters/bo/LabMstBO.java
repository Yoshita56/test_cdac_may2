package mms.masters.bo;

import mms.masters.dao.LabMstDAO;
import mms.masters.vo.LabMstVO;

/**
 * @author:-	Adil Wasi   
 * Creation Date:- 7-Jan-2012 
 * Modifying Date:- 
 * Used For:-	
 * Team Lead By:-	
 *  Module:- DWH(HIS Project)
 * 
 */


/**
 * The Class LabMstBO.
 */
public class LabMstBO {

	
	/**
	 * for getting current date value of effective from field on add page.
	 * 
	 * @param labMstVO_p the vo
	 * 
	 * @throws Exception 	 */
	
	
	/**
	 * to insert the data.
	 * 
	 * @param labMstVO_p the labMstVO_p
	 */
	public void insertRecord(LabMstVO labMstVO_p) {
		
		/**
		 * to check duplicate before insert and insert the data.
		 * 
		 * @param labMstVO_p the labMstVO_p
		 */
	
		LabMstDAO.chkDuplicate(labMstVO_p,"insert");
		if (labMstVO_p.getBExistStatus() == true)	//no duplicacy , so new record is added
		{
	
			LabMstDAO.save(labMstVO_p, "insert");
			if (labMstVO_p.getStrMsgType().equals("1")) 
			{
				labMstVO_p.setStrMsgString("LabMstBO.insertValues(labMstVO_p) ---->"+ labMstVO_p.getStrMsgString());
			}
		}
		
		if (labMstVO_p.getStrMsgType().equals("1")) 
		{
			labMstVO_p.setStrMsgString("LabMstBO.insertRecord() --> "+ labMstVO_p.getStrMsgString());
		}
	}
	
	/**
	 * to get data for modify page.
	 * 
	 * @param labMstVO_p the vo
	 * 
	 */
	public void modifyRecord(LabMstVO labMstVO_p)
	{
		LabMstDAO.modifyRecord(labMstVO_p);
		if (labMstVO_p.getStrMsgType().equals("1")) {
			labMstVO_p.setStrMsgString("LabMstBO.modifyRecord(vo) --> "
					+ labMstVO_p.getStrMsgString());
		}
	}
	
	
	/**
	 * to check duplicate before update, and update the record.
	 * 
	 * @param labMstVO_p the vo
	 */
	public void updateRecord(LabMstVO labMstVO_p) 
	{
		LabMstDAO.chkDuplicate(labMstVO_p,"update");
		
		if (labMstVO_p.getBExistStatus() == true)	//no duplicacy , so new record is added
		{
			LabMstDAO.save(labMstVO_p,"update");
			
		}	
			
		if (labMstVO_p.getStrMsgType().equals("1"))
		{
			labMstVO_p.setStrMsgString("LabMstBO.updateRecord() --> "
			+ labMstVO_p.getStrMsgString());
		}		
	}
}

