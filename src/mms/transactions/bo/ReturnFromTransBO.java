/**
 * 
 */
package mms.transactions.bo;

import mms.transactions.dao.ReturnFromTransDAO;
import mms.transactions.vo.ReturnFromTransVO;

/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Date : 23/April/2009
 * Mod Date : 11/June/2009
 * 
 */
public class ReturnFromTransBO {
	
	/**
	 * To get the Store Name
	 * 
	 * @param vo
	 */
	public void storeName(ReturnFromTransVO vo)
	{
		ReturnFromTransDAO.storeName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ReturnFromTransBO.storeName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * Gets the issue dtls init dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the issue dtls init dtls
	 */
	public void getIssueDtlsInitDtls(ReturnFromTransVO vo) 
	{

		ReturnFromTransDAO.getIssueDtlsList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("ReturnFromTransBO.getStockItemDtlsInitDtls() --> "
							+ strErr);

		}

	}
	
	/**
	 * To get the Recommend By
	 * 
	 * @param vo
	 */
	public void getRecommendName(ReturnFromTransVO vo)
	{
		ReturnFromTransDAO.getRecommendName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ReturnFromTransBO.getRecommendName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	/**
	 * To get the values of Item Category
	 * 
	 * @param vo
	 */
	public void getItemCategory(ReturnFromTransVO vo)
	{
		ReturnFromTransDAO.getItemCategory(vo);
		if (vo.getStrMsgType().equals("1")) {
			
			String strErr = vo.getStrMsgString();
			
			vo.setStrMsgString("ReturnFromTransBO.getItemCategory() --> "
					+ strErr);
		}
		
	}
	
	/**
	 * To get the value of Issue No
	 * 
	 * @param vo
	 */
	public void getIssueNoCombo(ReturnFromTransVO vo)
	{
		ReturnFromTransDAO.getIssueNoCombo(vo);
		if (vo.getStrMsgType().equals("1")) {
			
			String strErr = vo.getStrMsgString();
			
			vo.setStrMsgString("ReturnFromTransBO.getIssueCombo() --> "
					+ strErr);
		}
		
	}
	
	/**
	 * To get Issue Details
	 * 
	 * @param vo
	 */
	public void getIssueDetails(ReturnFromTransVO vo) {

		ReturnFromTransDAO.getIssueDetails(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("ReturnFromTransBO.getIssueDetails() --> "
							+ vo.getStrMsgString());
		}
	
	}
	
	/**
	 * To get Issue Item Details
	 * @param vo
	 */
	public void getItemDetail(ReturnFromTransVO vo) {
		ReturnFromTransDAO.getItemDetail(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ReturnFromTransBO.getItemDetail() --> "
					+ vo.getStrMsgString());
		}

	}
	
	/**
	 * To get Issue Item Details
	 * @param vo
	 */
	public void getItem_ALL_LIST(ReturnFromTransVO vo) {
		ReturnFromTransDAO.getItem_ALL_LIST(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ReturnFromTransBO.getItem_ALL_LIST() --> "
					+ vo.getStrMsgString());
		}

	}
	
	/**
	 * This method is used to populate the value of Unit name combo
	 * 
	 * @param vo
	 */
	public void getReturnQtyUnit(ReturnFromTransVO vo) {

		ReturnFromTransDAO.getReturnUnitCombo(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ReturnFromTransBO.getReturnQtyUnit() --> "
					+ vo.getStrMsgString());
		}
	}
	
	/**
	 * This method is used to insert the Record.
	 * 
	 * @param vo
	 */
	public void insert_LIST(ReturnFromTransVO vo) {
	
		ReturnFromTransDAO.insert_LIST(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ReturnFromTransBO.insert_LIST() --> "
					+ vo.getStrMsgString());
		}
	}
	
	/**
	 * This method is used to insert the Record.
	 * 
	 * @param vo
	 */
	public void insert(ReturnFromTransVO vo) {
	
		ReturnFromTransDAO.insert(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ReturnFromTransBO.insert() --> "
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
	public void validateIssueNumber(ReturnFromTransVO vo)
	{
		ReturnFromTransDAO.validateIssueNumber(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ReturnFromTransBO.validateIssueNumber---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}

	public void getIssueDetailsBasedOnPatientNameOrCrNo(ReturnFromTransVO vo) 
	{
		
		ReturnFromTransDAO.getIssueDetailsBasedOnPatientNameOrCrNo(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ReturnFromTransBO.getIssueDetails() --> "+ vo.getStrMsgString());
		}
		
	}

	public void getpatientDemographicDetail(ReturnFromTransVO vo) 
	{
		ReturnFromTransDAO.getpatientDemographicDetail(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ReturnFromTransBO.getpatientDemographicDetail() --> "+ vo.getStrMsgString());
		}
		
	}
	
	public void getImgHeader(ReturnFromTransVO voObj){
		ReturnFromTransDAO.getImageHeader(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("ReturnFromTransBO.getImgHeader() --> "+ voObj.getStrMsgString());
		  }
	}
	/**
	 * Method is Used to Generate View page data 
	 * @param vo
	 */	
	public void initForViewPage(ReturnFromTransVO voObj){
		ReturnFromTransDAO.GetData(voObj);
		ReturnFromTransDAO.itemCategoryCombo1(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("ReturnFromTransBO.initForViewPage() --> "+ voObj.getStrMsgString());
		}
	}
	
	
	/**
	 * This method is used to GET Issue Details
	 * 
	 * @param vo
	 */
	
	public void setViewPageDtl(ReturnFromTransVO voObj){
		
		ReturnFromTransDAO.getReturnDetail(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("OfflineIssueIndentTransBO.setViewPageDtl() --> "+ voObj.getStrMsgString());
		  }
		
	}
	
	
}
