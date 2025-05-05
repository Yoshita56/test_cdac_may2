package mms.transactions.bo;

import mms.transactions.dao.DispatchDetailsTransDAO;

import mms.transactions.vo.DispatchDetailsTransVO;

/**
* Developer : Pramod Kumar Mehta 
* Version : 1.0 
* Date : 09/April/2009
*  Module:MMS
* Process: Dispatch Details
*
*/
/**
 * Developer :Baisakhi Roy
 * Version : 1.1 
 * Start Date : 08/May/2009
 * End Date : 12/May/2009
 *  Module:MMS
 * Process: Dispatch Details
 *
 */

public class DispatchDetailsTransBO 
{

	/** This method is used to populate the value of Store name combo box.
	 * @param vo
	 *
	 */
	public void getInitialValues(DispatchDetailsTransVO vo)
	{

		
		DispatchDetailsTransDAO.getStoreNameCombo(vo);
		

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DispatchDetailsTransBO.getInitialValues() --> "
					+ vo.getStrMsgString());
		}
	}
	/** This method is used to populate the value of Item Category name combo box.
	 * @param vo
	 * 
	 */
	public void getItemCategoryCombo(DispatchDetailsTransVO vo)
	{

		
		DispatchDetailsTransDAO.getItemCategoryCombo(vo);
		

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DispatchDetailsTransBO.getItemCategoryCombo() --> "
					+ vo.getStrMsgString());
		}
	}
	/** This method is used to populate the value of PO No combo box.
	 * @param vo
	 * 
	 */
	public void getPONOCombo(DispatchDetailsTransVO vo)
	{

		
		DispatchDetailsTransDAO.getPONOCombo(vo);
		

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DispatchDetailsTransBO.getPONOCombo() --> "
					+ vo.getStrMsgString());
		}
	}
	/** This method is used to populate the value of Dispatch Mode combo box.
	 * @param vo
	 * 
	 */
	public void getDispatchModeCombo(DispatchDetailsTransVO vo)
	{

		
		DispatchDetailsTransDAO.getDispatchModeCombo(vo);
		

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DispatchDetailsTransBO.getDispatchModeCombo() --> "
					+ vo.getStrMsgString());
		}
	}
	/** This method is used to get PO No Details.
	 * @param vo
	 * 
	 */
	public void getPONODetails(DispatchDetailsTransVO vo)
	{

		
		DispatchDetailsTransDAO.getPONODetails(vo);
		

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DispatchDetailsTransBO.getPONODetails() --> "
					+ vo.getStrMsgString());
		}
	}
	/** This method is used to get Request Details.
	 * @param vo
	 * 
	 */
	
	public void getRequestDetails(DispatchDetailsTransVO vo)
	{

	
		DispatchDetailsTransDAO.getRequestDetails(vo);
		

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DispatchDetailsTransBO.getRequestDetails() --> "
					+ vo.getStrMsgString());
		}
	}
	/** This method is used to get Bill Details.
	 * @param vo
	 * 
	 */
	public void getBillDetails(DispatchDetailsTransVO vo)
	{

	
		DispatchDetailsTransDAO.getBillDetails(vo);
		

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DispatchDetailsTransBO.getBillDetails() --> "
					+ vo.getStrMsgString());
		}
	}
	/** This method is used to insert and Update the data in Advance Mode..
	 * @param vo
	 */
	public void insertAdvance(DispatchDetailsTransVO vo) {
		DispatchDetailsTransDAO.insertAdvance(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("DispatchDetailsTransBO.insertAdvance() --> "
							+ vo.getStrMsgString());
		}
	}
	/** This method is used to insert and Update the data in Bill Mode..
	 * @param vo
	 */
	public void insertBill(DispatchDetailsTransVO vo) {
		DispatchDetailsTransDAO.insertBill(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("DispatchDetailsTransBO.insertBill() --> "
							+ vo.getStrMsgString());
		}
	}
	
	public void getViewDetails(DispatchDetailsTransVO vo) {
		DispatchDetailsTransDAO.getViewDetails(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("DispatchDetailsTransBO.getViewDetails() --> "
							+ vo.getStrMsgString());
		}
	}
	
}
