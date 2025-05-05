package mms.transactions.bo;

import mms.transactions.dao.IssueSampleForQcCheckTransDAO;
import mms.transactions.dao.SampleSentTransDAO;
import mms.transactions.vo.IssueSampleForQcCheckTransVO;
import mms.transactions.vo.SampleSentTransVO;

/**
 * Developer : Vivek Aggarwal
 * Version : 1.0
 * Date : 16/Sep/2010
 *  
*/

public class IssueSampleForQcCheckTransBO 
{
	/**
	 * BO Method is Used To Get the DAO method
	 * to intreact with Database 
	 * @param vo
	 * @throws Exception
	 */
	
	
	/**
	 * GetData Method is Used to Populate the Data 
	 * for Breakage Item Details DAO 
	 * @param vo
	 */
	public void GetData(IssueSampleForQcCheckTransVO issueSampleForQcCheckTransVO_p)
	{
		IssueSampleForQcCheckTransDAO.GetData(issueSampleForQcCheckTransVO_p);
		IssueSampleForQcCheckTransDAO.itemCategoryCombo(issueSampleForQcCheckTransVO_p);
		IssueSampleForQcCheckTransDAO.getHQNameStoreCombo(issueSampleForQcCheckTransVO_p);
		IssueSampleForQcCheckTransDAO.IndentPeriodCombo(issueSampleForQcCheckTransVO_p);
		
		
		  if (issueSampleForQcCheckTransVO_p.getStrMsgType().equals("1")) 
		  {
			  issueSampleForQcCheckTransVO_p.setStrMsgString("OfflineIssueIndentBO.GetData() --> "+ issueSampleForQcCheckTransVO_p.getStrMsgString());
		  }
		  
	}
	
	/**
	 * This method is used to get Item Details
	 * 
	 * @param vo
	 */
	public void getItemDetail(IssueSampleForQcCheckTransVO vo) 
	{
		IssueSampleForQcCheckTransDAO.getItemDetail(vo);

		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("IssueSampleForQcCheckTransBO.getItemDetail() --> "
					+ vo.getStrMsgString());
		}

	}
	
	
	/**
	 * ItemCategoryCombo  Method is Used to Generate Item Category Combo 
	 * @param vo
	 */
	
	public void ItemCatgoryCombo(IssueSampleForQcCheckTransVO issueSampleForQcCheckTransVO_p)
	{
		IssueSampleForQcCheckTransDAO.itemCategoryCombo1(issueSampleForQcCheckTransVO_p);
		
		  if (issueSampleForQcCheckTransVO_p.getStrMsgType().equals("1")) 
		  {
			  issueSampleForQcCheckTransVO_p.setStrMsgString("IssueSampleForQcCheckTransBO.ItemCatgoryCombo() --> "+ issueSampleForQcCheckTransVO_p.getStrMsgString());
		  }
		  
	}
	
	
	/**
	 * This method is used to get indent details
	 * 
	 * @param vo
	 */
	public void getIndentDetail(IssueSampleForQcCheckTransVO vo) 
	{
		IssueSampleForQcCheckTransDAO.getIndentDetail(vo);
				
		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("IssueSampleForQcCheckTransBO.getIndentDetail() --> "+ vo.getStrMsgString());
		}

	}
	
	
	/**
	 * This method is used to populate the value of Unit name combo
	 * 
	 * @param vo
	 */
	public void getUnitCombo(IssueSampleForQcCheckTransVO vo) {

		IssueSampleForQcCheckTransDAO.getUnitCombo(vo);

		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("IssueSampleForQcCheckTransBO.getUnitCombo() --> "
					+ vo.getStrMsgString());
		}
	}
	
	
	/**
	 * PendingDemand  Method is Used to Generate 
	 * @param vo
	 */
	
	public void PendingDemand(IssueSampleForQcCheckTransVO issueSampleForQcCheckTransVO_p)
	{
		IssueSampleForQcCheckTransDAO.getPendingDemand(issueSampleForQcCheckTransVO_p);
		
		  if (issueSampleForQcCheckTransVO_p.getStrMsgType().equals("1")) 
		  {
			  issueSampleForQcCheckTransVO_p.setStrMsgString("IssueSampleForQcCheckTransBO.PendingDemand() --> "+ issueSampleForQcCheckTransVO_p.getStrMsgString());
		  }
		  
	}
	
	
	/**
	 * ApprovedByCombo  Method is Used to Generate Item Category Combo 
	 * @param vo
	 */
	public void ApprovedByCombo(IssueSampleForQcCheckTransVO offlineIssueIndent_VO) {
		
		IssueSampleForQcCheckTransDAO.getApprovedByCombo(offlineIssueIndent_VO);
		
		  if (offlineIssueIndent_VO.getStrMsgType().equals("1")) 
		  {
			  offlineIssueIndent_VO.setStrMsgString("IssueSampleForQcCheckTransBO.ApprovedByCombo() --> "+ offlineIssueIndent_VO.getStrMsgString());
		  }
		
	}
	/**
	 * IndentingStoreCombo  Method is Used to Generate Indenting STore Combo 
	 * @param vo
	 */
	
	public void getHQNameStoreCombo(IssueSampleForQcCheckTransVO issueSampleForQcCheckTransVO_p)
	{
		IssueSampleForQcCheckTransDAO.getHQNameStoreCombo(issueSampleForQcCheckTransVO_p);
		
		  if (issueSampleForQcCheckTransVO_p.getStrMsgType().equals("1")) 
		  {
			  issueSampleForQcCheckTransVO_p.setStrMsgString("IssueSampleForQcCheckTransBO.ItemCatgoryCombo() --> "+ issueSampleForQcCheckTransVO_p.getStrMsgString());
		  }
		  
	}
	
	/**
	 * ApprovedVerifyCombo  Method is Used to Generate Approved By + Verify By Store Combo 
	 * @param vo
	 */
	
	public void ApprovedVerifyCombo(IssueSampleForQcCheckTransVO issueSampleForQcCheckTransVO_p)
	{
		//IssueSampleForQcCheckTransDAO.getApprovedByCombo(issueSampleForQcCheckTransVO_p);
		IssueSampleForQcCheckTransDAO.getVerifyByCombo(issueSampleForQcCheckTransVO_p);
		
		  if (issueSampleForQcCheckTransVO_p.getStrMsgType().equals("1")) 
		  {
			  issueSampleForQcCheckTransVO_p.setStrMsgString("IssueSampleForQcCheckTransBO.ItemCatgoryCombo() --> "+ issueSampleForQcCheckTransVO_p.getStrMsgString());
		  }
		  
	}
	
	
	/**
	 * GetStoreBudget Method is Used to get Indenting Store Budget
	 * for Breakage Item Details DAO 
	 * @param vo
	 */
	public void GetStoreBudget(IssueSampleForQcCheckTransVO issueSampleForQcCheckTransVO_p)
	{		
		IssueSampleForQcCheckTransDAO.getAvalBudgetDetails(issueSampleForQcCheckTransVO_p);
		
		  if (issueSampleForQcCheckTransVO_p.getStrMsgType().equals("1")) 
		  {
			  issueSampleForQcCheckTransVO_p.setStrMsgString("OfflineIssueIndentBO.GetStoreBudget() --> "+ issueSampleForQcCheckTransVO_p.getStrMsgString());
		  }
		  
	}
	
	/**
	 * Method is Used to Generate View page data 
	 * @param vo
	 */	
	public void initForViewPage(IssueSampleForQcCheckTransVO _IssueSampleForQcCheckTransVO){
		
		 
		IssueSampleForQcCheckTransDAO.GetData(_IssueSampleForQcCheckTransVO);
		IssueSampleForQcCheckTransDAO.itemCategoryCombo(_IssueSampleForQcCheckTransVO);
		if (_IssueSampleForQcCheckTransVO.getStrMsgType().equals("1"))
		{
			_IssueSampleForQcCheckTransVO.setStrMsgString("IssueSampleForQcCheckTransBO.initForViewPage() --> "+ _IssueSampleForQcCheckTransVO.getStrMsgString());
		}
	}
	
	/**
	 * This method is used to GET POPUP VALUES
	 * 
	 * @param vo
	 */
	public void getPopUpInfo(IssueSampleForQcCheckTransVO vo) 
	{

		IssueSampleForQcCheckTransDAO.getPopUpInfoProc(vo);
		

		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("IssueSampleForQcCheckTransBO.getPopUpInfo() --> "+ vo.getStrMsgString());
		}
	}
	
	/**
	 * This method is used to GET Issue Details
	 * 
	 * @param vo
	 */
	
	public void setViewPageDtl(IssueSampleForQcCheckTransVO _IssueSampleForQcCheckTransVO){
		
		IssueSampleForQcCheckTransDAO.getViewIssueSampleHlp(_IssueSampleForQcCheckTransVO);
		if (_IssueSampleForQcCheckTransVO.getStrMsgType().equals("1")){
			_IssueSampleForQcCheckTransVO.setStrMsgString("IssueSampleForQcCheckTransBO.setViewPageDtl() --> "+ _IssueSampleForQcCheckTransVO.getStrMsgString());
		  }
		
	}
	/**
	 * This method is used to Save Data 
	 * 
	 * @param vo
	 */
	
	public void insertIssueSampleForQcCheck(IssueSampleForQcCheckTransVO _IssueSampleForQcCheckTransVO){
		
		IssueSampleForQcCheckTransDAO.insertIssueSampleForQcCheck(_IssueSampleForQcCheckTransVO);
		
		if (_IssueSampleForQcCheckTransVO.getStrMsgType().equals("1"))
		{
			_IssueSampleForQcCheckTransVO.setStrMsgString("IssueSampleForQcCheckTransBO.insertData() --> "+ _IssueSampleForQcCheckTransVO.getStrMsgString());
		}
		
	}
	
	/**
	 * CANCELRECORDS  Method is Used to transfer Value Object to Data Access Object 
	 * @param vo
	 */
	public void CANCELRECORDS(IssueSampleForQcCheckTransVO vo)
	{
		IssueSampleForQcCheckTransDAO.CANCELRECORDS(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("SampleSentTransBO.CANCELRECORDS() --> "+ vo.getStrMsgString());
		  }
		  
	}
	

}
