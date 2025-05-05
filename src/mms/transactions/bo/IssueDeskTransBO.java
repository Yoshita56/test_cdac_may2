/**
 * 
 */
package mms.transactions.bo;

import mms.transactions.dao.IssueDeskTransDAO;
import mms.transactions.vo.IssueDeskTransVO;


/** 
 * Developer : Anshul Jindal Version : 1.1 Date : 11/June/2009
 * (Changes)
 * 
 */
/**
 * Developer : Anshul Jindal (To Continue) Version : 1.0 Date : 02/Apr/2009
 * 
 */
/**
 * @author Balasubramaniam M
 * @version 1.0
 * @since 01/Apr/2009
 * 
 */

/**
 * Developer : Anshul Jindal (To Continue) Version : 1.0 Date : 02/Apr/2009
 * 
 */
public class IssueDeskTransBO {

	/**
	 * This method is used to get indent details
	 * 
	 * @param vo
	 */
	public void viewData(IssueDeskTransVO vo)
	{
			
		 IssueDeskTransDAO.getItemDetailsView(vo);
		 IssueDeskTransDAO.getIndentDetailsView(vo);
		 IssueDeskTransDAO.callingFunctionIndentNameView(vo);
						
		
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("IssueDeskTransBO.viewData() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	public void getIndentDetail(IssueDeskTransVO vo) 
	{
	//	IssueDeskTransDAO.getAvalBudgetDetails(vo);
		IssueDeskTransDAO.getIndentDetail(vo);
		IssueDeskTransDAO.setApprovedByCombo(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IssueDeskTransBO.getIndentDetail() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * This method is used to get Item Details
	 * 
	 * @param vo
	 */
	public void getItemDetail(IssueDeskTransVO vo) {
		IssueDeskTransDAO.getItemDetail(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IssueDeskTransBO.getItemDetail() --> "
					+ vo.getStrMsgString());
		}

	}
	public void getImgHeader(IssueDeskTransVO vo){
		IssueDeskTransDAO.getImageHeader(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("IssueDeskTransBO.getIssueVoucherDtl() --> "+ strErr);
		}
	}
	
	/**
	 * Gets the issue dtls init dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the issue dtls init dtls
	 */
	public void getIssueVoucherDtl(IssueDeskTransVO vo) 
	{

		IssueDeskTransDAO.getIssueVoucherDtl(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("IssueDeskTransBO.getIssueVoucherDtl() --> "+ strErr);
		}

	}


	/**
	 * This method is used to get Issued Item Details for view page 2
	 * 
	 * @param vo
	 */
	public void getIssuedItemDetail(IssueDeskTransVO vo) {
		IssueDeskTransDAO.getItemDetail(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IssueDeskTransBO.getIssuedItemDetail() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * This method is used to populate the value of Unit name combo
	 * 
	 * @param vo
	 */
	public void getUnitCombo(IssueDeskTransVO vo) {

		IssueDeskTransDAO.getUnitCombo(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IssueDeskTransBO.getUnitCombo() --> "
					+ vo.getStrMsgString());
		}
	}
	
	/**
	 * This method is used to GET POPUP VALUES
	 * 
	 * @param vo
	 */
	public void getPopUpInfo(IssueDeskTransVO vo) {

		IssueDeskTransDAO.getPopUpInfoProc(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IssueDeskTransBO.getPopUpInfo() --> "
					+ vo.getStrMsgString());
		}
	}
	
	/**
	 * This method is used to save data 
	 * 
	 * @param vo
	 */
	public void insertData(IssueDeskTransVO vo) {
		IssueDeskTransDAO.insertData(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IssueDeskTransBO.getIndentDetail() --> "
					+ vo.getStrMsgString());
		}

	}
	
	/**
	 * This method is used to get issue details
	 * 
	 * @param vo
	 */
	public void getIssueDetail(IssueDeskTransVO vo) {
		IssueDeskTransDAO.getIssueDetail(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IssueDeskTransBO.getIssueDetail() --> "
					+ vo.getStrMsgString());
		}

	}
	/**
	 * Gets the stock item dtls init dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the stock item dtls init dtls
	 */
	public void getStockItemDtlsInitDtls(IssueDeskTransVO vo) {

		IssueDeskTransDAO.getItemDtls(vo);
		IssueDeskTransDAO.getStockItemDtlsList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("IssueDeskTransBO.getStockItemDtlsInitDtls() --> "
							+ strErr);

		}

	}
	
	/**
	 * This method is used to GET POPUP VALUES.
	 * 
	 * @param vo
	 *            the vo
	 * @return the single batch item dtl
	 */
	public void getSingleBatchItemDtl(IssueDeskTransVO vo) {

		IssueDeskTransDAO.getSingleBatchItemDtl(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IssueDeskTransBO.getSingleBatchItemDtl() --> "
					+ vo.getStrMsgString());
		}
	}

}
