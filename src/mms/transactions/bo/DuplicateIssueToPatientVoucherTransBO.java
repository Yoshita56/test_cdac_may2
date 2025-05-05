/**
 * 
 */
package mms.transactions.bo;

import mms.transactions.dao.DuplicateIssueToPatientVoucherTransDAO;
import mms.transactions.vo.DuplicateIssueToPatientVoucherTransVO;

/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Date : 23/April/2009
 * Mod Date : 11/June/2009
 * 
 */
public class DuplicateIssueToPatientVoucherTransBO {
	
	/**
	 * To get the Store Name
	 * 
	 * @param vo
	 */
	public void storeName(DuplicateIssueToPatientVoucherTransVO vo)
	{
		DuplicateIssueToPatientVoucherTransDAO.storeName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("DuplicateIssueToPatientVoucherTransBO.storeName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get the Recommend By
	 * 
	 * @param vo
	 */
	public void getRecommendName(DuplicateIssueToPatientVoucherTransVO vo)
	{
		DuplicateIssueToPatientVoucherTransDAO.getRecommendName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("DuplicateIssueToPatientVoucherTransBO.getRecommendName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	/**
	 * To get the values of Item Category
	 * 
	 * @param vo
	 */
	public void getItemCategory(DuplicateIssueToPatientVoucherTransVO vo)
	{
		DuplicateIssueToPatientVoucherTransDAO.getItemCategory(vo);
		if (vo.getStrMsgType().equals("1")) {
			
			String strErr = vo.getStrMsgString();
			
			vo.setStrMsgString("DuplicateIssueToPatientVoucherTransBO.getItemCategory() --> "
					+ strErr);
		}
		
	}
	
	/**
	 * To get the value of Issue No
	 * 
	 * @param vo
	 */
	public void getIssueNoCombo(DuplicateIssueToPatientVoucherTransVO vo)
	{
		DuplicateIssueToPatientVoucherTransDAO.getIssueNoCombo(vo);
		if (vo.getStrMsgType().equals("1")) {
			
			String strErr = vo.getStrMsgString();
			
			vo.setStrMsgString("DuplicateIssueToPatientVoucherTransBO.getIssueCombo() --> "
					+ strErr);
		}
		
	}
	
	
	public void getIssueNoDateCombo(DuplicateIssueToPatientVoucherTransVO vo)
	{
		DuplicateIssueToPatientVoucherTransDAO.getIssueNoDateCombo(vo);
		if (vo.getStrMsgType().equals("1")) {
			
			String strErr = vo.getStrMsgString();
			
			vo.setStrMsgString("DuplicateIssueToPatientVoucherTransBO.getIssueCombo() --> "
					+ strErr);
		}
		
	}
	
	/**
	 * To get Issue Details
	 * 
	 * @param vo
	 */
	public void getIssueDetails(DuplicateIssueToPatientVoucherTransVO vo) {

		DuplicateIssueToPatientVoucherTransDAO.getIssueDetails(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("DuplicateIssueToPatientVoucherTransBO.getIssueDetails() --> "
							+ vo.getStrMsgString());
		}
	
	}
	
	/**
	 * To get Issue Item Details
	 * @param vo
	 */
	public void getItemDetail(DuplicateIssueToPatientVoucherTransVO vo) {
		DuplicateIssueToPatientVoucherTransDAO.getItemDetail(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DuplicateIssueToPatientVoucherTransBO.getItemDetail() --> "
					+ vo.getStrMsgString());
		}

	}
	
	/**
	 * This method is used to populate the value of Unit name combo
	 * 
	 * @param vo
	 */
	public void getReturnQtyUnit(DuplicateIssueToPatientVoucherTransVO vo) {

		DuplicateIssueToPatientVoucherTransDAO.getReturnUnitCombo(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DuplicateIssueToPatientVoucherTransBO.getReturnQtyUnit() --> "
					+ vo.getStrMsgString());
		}
	}
	
	/**
	 * This method is used to insert the Record.
	 * 
	 * @param vo
	 */
	public void insert(DuplicateIssueToPatientVoucherTransVO vo) {
	
		DuplicateIssueToPatientVoucherTransDAO.insert(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DuplicateIssueToPatientVoucherTransBO.insert() --> "
					+ vo.getStrMsgString());
		}
	}

	
	/**
	 * Change Request
	 */
	/**
	 * To get the Store Name
	 * 
	 * @param vo
	 */
	public void validateIssueNumber(DuplicateIssueToPatientVoucherTransVO vo)
	{
		DuplicateIssueToPatientVoucherTransDAO.validateIssueNumber(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("DuplicateIssueToPatientVoucherTransBO.validateIssueNumber---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}

	public void getIssueDetailsBasedOnPatientNameOrCrNo(DuplicateIssueToPatientVoucherTransVO vo) 
	{
		
		DuplicateIssueToPatientVoucherTransDAO.getIssueDetailsBasedOnPatientNameOrCrNo(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DuplicateIssueToPatientVoucherTransBO.getIssueDetails() --> "+ vo.getStrMsgString());
		}
		
	}

	public void getpatientDemographicDetail(DuplicateIssueToPatientVoucherTransVO vo) 
	{
		DuplicateIssueToPatientVoucherTransDAO.getpatientDemographicDetail(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DuplicateIssueToPatientVoucherTransBO.getpatientDemographicDetail() --> "+ vo.getStrMsgString());
		}
		
	}
	
}
