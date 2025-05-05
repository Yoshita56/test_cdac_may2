package mms.masters.bo;

import mms.masters.dao.DistrictMstDAO;
import mms.masters.vo.DistrictMstVO;


/**
 * @author Adil Wasi  
 * Creation Date:- 27-July-2011 
 * Modifying Date:- 
 * Used For:- 
 * Team Lead By:-  
 *  Module:- DWH(HIS Project)
 * 
 */
public class DistrictMstBO 
{
	
	/**
	 * to get Country Combo Value.
	 * 
	 * @param vo the vo
	 * 
	 */
	public void initializeAdd(DistrictMstVO districtMstVO_p) {

		DistrictMstDAO.getCountryName(districtMstVO_p);
		DistrictMstDAO.getStateName(districtMstVO_p);
			if (districtMstVO_p.getStrMsgType().equals("1")) 
			{
				districtMstVO_p.setStrMsgString("DistrictMstBO.initializeAdd(districtMstVO_p) --> "	+ districtMstVO_p.getStrMsgString());
			}
	}
	/**
	 * to get String State Combo Value.
	 * 
	 * @param vo the vo
	 * 
	 */
	
	public void getStrStateCombo(DistrictMstVO districtMstVO_p) {
		DistrictMstDAO.getStateName(districtMstVO_p);
		if (districtMstVO_p.getStrMsgType().equals("1")) 
		{
			districtMstVO_p.setStrMsgString("DistrictMstBO.getStrStateCombo(districtMstVO_p) --> "	+ districtMstVO_p.getStrMsgString());
		}
		
	}
	
	/**
	 * to insert data.
	 * 
	 * @param districtMstVO_p the VO
	 * 
 	 */
	public void insertRecord(DistrictMstVO districtMstVO_p) {
		
		DistrictMstDAO.chkDuplicate(districtMstVO_p,"insert");
		
		
		if (districtMstVO_p.getBExistStatus() == true)	//no duplicacy , so new record is added
		{

			DistrictMstDAO.save(districtMstVO_p);

			if (districtMstVO_p.getStrMsgType().equals("1")) 
			{
				districtMstVO_p.setStrMsgString("DistrictMstBO.insertValues(districtMstVO_p) ---->"+ districtMstVO_p.getStrMsgString());
			}
		}
		
			if (districtMstVO_p.getStrMsgType().equals("1")) 
			{
				districtMstVO_p.setStrMsgString("DistrictMstBO.insertRecord() --> "+ districtMstVO_p.getStrMsgString());
			}
	}
	
	

	
	
	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 * 
	 */
	public void modifyRecord(DistrictMstVO districtMstVO_p)
	{
		DistrictMstDAO.modifyRecord(districtMstVO_p);

		if (districtMstVO_p.getStrMsgType().equals("1")) {
			districtMstVO_p.setStrMsgString("DistrictMstBO.modifyRecord(districtMstVO_p) --> "
					+ districtMstVO_p.getStrMsgString());
		}
	}
	
	
	
	/**
	 * to update the record.
	 * 
	 * @param districtMstVO_p the vo
	 */
	public void updateRecord(DistrictMstVO districtMstVO_p) {
		
		DistrictMstDAO.chkDuplicate(districtMstVO_p,"update");
		
		if (districtMstVO_p.getBExistStatus() == true)	//no duplicacy , so new record is added
		{
			DistrictMstDAO.save(districtMstVO_p);
		}
		if (districtMstVO_p.getStrMsgType().equals("1")) 
		{
			districtMstVO_p.setStrMsgString("DistrictMstBO.updateRecord(districtMstVO_p) --> "
					+ districtMstVO_p.getStrMsgString());
		}
		
		
	}
	
	

}