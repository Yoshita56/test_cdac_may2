/**
 * 
 */
package mms.transactions.bo;

import mms.transactions.dao.ReturnFromEmployeeTransDAO;
import mms.transactions.vo.ReturnFromEmployeeTransVO;

/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Date : 17/June/2009
 * 
 */
public class ReturnFromEmployeeTransBO {

	/**
	 * To get the Store Name
	 * 
	 * @param vo
	 */
	public void storeName(ReturnFromEmployeeTransVO vo)
	{
		ReturnFromEmployeeTransDAO.storeName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ReturnFromEmployeeTransBO.storeName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get the Recommend By
	 * 
	 * @param vo
	 */
	public void getRecommendName(ReturnFromEmployeeTransVO vo)
	{
		ReturnFromEmployeeTransDAO.getRecommendName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ReturnFromEmployeeTransBO.getRecommendName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	/**
	 * To get the values of Item Category
	 * 
	 * @param vo
	 */
	public void getItemCategory(ReturnFromEmployeeTransVO vo)
	{
		ReturnFromEmployeeTransDAO.getItemCategory(vo);
		if (vo.getStrMsgType().equals("1")) {
			
			String strErr = vo.getStrMsgString();
			
			vo.setStrMsgString("ReturnFromEmployeeTransBO.getItemCategory() --> "
					+ strErr);
		}
		
	}
	
	/**
	 * To get the value of Issue No
	 * 
	 * @param vo
	 */
	public void getIssueNoCombo(ReturnFromEmployeeTransVO vo)
	{
		ReturnFromEmployeeTransDAO.getIssueNoCombo(vo);
		if (vo.getStrMsgType().equals("1")) {
			
			String strErr = vo.getStrMsgString();
			
			vo.setStrMsgString("ReturnFromEmployeeTransBO.getIssueCombo() --> "
					+ strErr);
		}
		
	}
	
	/**
	 * To get Issue Details
	 * 
	 * @param vo
	 */
	public void getIssueDetails(ReturnFromEmployeeTransVO vo) {

		ReturnFromEmployeeTransDAO.getIssueDetails(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("ReturnFromEmployeeTransBO.getIssueDetails() --> "
							+ vo.getStrMsgString());
		}
	
	}
	
	/**
	 * To get Issue Item Details
	 * @param vo
	 */
	public void getItemDetail(ReturnFromEmployeeTransVO vo) {
		ReturnFromEmployeeTransDAO.getItemDetail(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ReturnFromEmployeeTransBO.getItemDetail() --> "
					+ vo.getStrMsgString());
		}

	}
	
	/**
	 * This method is used to populate the value of Unit name combo
	 * 
	 * @param vo
	 */
	public void getReturnQtyUnit(ReturnFromEmployeeTransVO vo) {

		ReturnFromEmployeeTransDAO.getReturnUnitCombo(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ReturnFromEmployeeTransBO.getReturnQtyUnit() --> "
					+ vo.getStrMsgString());
		}
	}
	
	public void getStockStatus(ReturnFromEmployeeTransVO vo) {

		ReturnFromEmployeeTransDAO.getStockStatus(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ReturnFromTransBO.getStockStatus() --> "
					+ vo.getStrMsgString());
		}
	}
	
	/**
	 * This method is used to insert the Record.
	 * 
	 * @param vo
	 */
	public void insert(ReturnFromEmployeeTransVO vo) {
	
		ReturnFromEmployeeTransDAO.insert(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ReturnFromEmployeeTransBO.insert() --> "
					+ vo.getStrMsgString());
		}
	}
	public void getEmpDtl(ReturnFromEmployeeTransVO vo){
		
		ReturnFromEmployeeTransDAO.fetchEmpDtl(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ReturnFromEmployeeTransBO.getEmpDtl() --> "
					+ vo.getStrMsgString());
		}
	}
}
