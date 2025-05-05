package mms.masters.bo;

import mms.masters.dao.CountryMstDAO;
import mms.masters.vo.CountryMstVO;

/**
 * @author:-	Adil Wasi   
 * Creation Date:- 7-Jun-2011 
 * Modifying Date:- 
 * Used For:-	
 * Team Lead By:-	
 *  Module:- DWH(HIS Project)
 * 
 */


/**
 * The Class CountryMstBO.
 */
public class CountryMstBO {

	
	
	
	/**
	 * to insert the data.
	 * 
	 * @param countryMstVO_p the vo
	 */
	public void insertRecord(CountryMstVO countryMstVO_p) {
		
		CountryMstDAO.chkDuplicate(countryMstVO_p,"insert");
	
		if (countryMstVO_p.getBExistStatus() == true)	//no duplicacy , so new record is added
		{
	
			CountryMstDAO.save(countryMstVO_p, "insert");
			if (countryMstVO_p.getStrMsgType().equals("1")) 
			{
				countryMstVO_p.setStrMsgString("CountryMstBO.insertValues(countryMstVO_p) ---->"+ countryMstVO_p.getStrMsgString());
			}
		}
		
		if (countryMstVO_p.getStrMsgType().equals("1")) 
		{
			countryMstVO_p.setStrMsgString("CountryMstBO.insertRecord() --> "+ countryMstVO_p.getStrMsgString());
		}
	}
	
	/**
	 * to get data for modify page.
	 * 
	 * @param countryMstVO_p the vo
	 * 
	 */
	public void modifyRecord(CountryMstVO countryMstVO_p)
	{
		CountryMstDAO.modifyRecord(countryMstVO_p);
		if (countryMstVO_p.getStrMsgType().equals("1")) {
			countryMstVO_p.setStrMsgString("CountryMstBO.modifyRecord(vo) --> "
					+ countryMstVO_p.getStrMsgString());
		}
	}
	
	
	/**
	 * to check duplicate before update, and update the record.
	 * 
	 * @param countryMstVO_p the vo
	 */
	public void updateRecord(CountryMstVO countryMstVO_p) 
	{
		CountryMstDAO.chkDuplicate(countryMstVO_p,"update");
		
		if (countryMstVO_p.getBExistStatus() == true)	//no duplicacy , so new record is added
		{
			CountryMstDAO.save(countryMstVO_p,"update");
		}	
			
		if (countryMstVO_p.getStrMsgType().equals("1"))
		{
			countryMstVO_p.setStrMsgString("CountryMstBO.updateRecord() --> "
			+ countryMstVO_p.getStrMsgString());
		}		
	}
}


