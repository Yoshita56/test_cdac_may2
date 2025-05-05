package mms.transactions.bo;

import mms.transactions.dao.OfflineIssueIndentTransDAO;
import mms.transactions.vo.OfflineIssueIndentTransVO;

/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 16/Sep/2010
 *  
*/

public class OfflineIssueIndentTransBO 
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
	public void GetData(OfflineIssueIndentTransVO _OfflineIssueIndentVO)
	{
		OfflineIssueIndentTransDAO.GetData(_OfflineIssueIndentVO);
		OfflineIssueIndentTransDAO.itemCategoryCombo(_OfflineIssueIndentVO);
		OfflineIssueIndentTransDAO.IndentPeriodCombo(_OfflineIssueIndentVO);
		OfflineIssueIndentTransDAO.getApprovedByCombo(_OfflineIssueIndentVO);
		
		  if (_OfflineIssueIndentVO.getStrMsgType().equals("1")) 
		  {
			  _OfflineIssueIndentVO.setStrMsgString("OfflineIssueIndentBO.GetData() --> "+ _OfflineIssueIndentVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * This method is used to get Item Details
	 * 
	 * @param vo
	 */
	public void getItemDetail(OfflineIssueIndentTransVO vo) 
	{
		OfflineIssueIndentTransDAO.getItemDetail(vo);

		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("OfflineIssueIndentTransBO.getItemDetail() --> "
					+ vo.getStrMsgString());
		}

	}
	
	
	/**
	 * ItemCategoryCombo  Method is Used to Generate Item Category Combo 
	 * @param vo
	 */
	
	public void ItemCatgoryCombo(OfflineIssueIndentTransVO _OfflineIssueIndentVO)
	{
		OfflineIssueIndentTransDAO.itemCategoryCombo(_OfflineIssueIndentVO);
		
		  if (_OfflineIssueIndentVO.getStrMsgType().equals("1")) 
		  {
			  _OfflineIssueIndentVO.setStrMsgString("OfflineIssueIndentTransBO.ItemCatgoryCombo() --> "+ _OfflineIssueIndentVO.getStrMsgString());
		  }
		  
	}
	
	
	/**
	 * This method is used to get indent details
	 * 
	 * @param vo
	 */
	public void getIndentDetail(OfflineIssueIndentTransVO vo) 
	{
		OfflineIssueIndentTransDAO.getIndentDetail(vo);
				
		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("OfflineIssueIndentTransBO.getIndentDetail() --> "+ vo.getStrMsgString());
		}

	}
	
	
	/**
	 * This method is used to populate the value of Unit name combo
	 * 
	 * @param vo
	 */
	public void getUnitCombo(OfflineIssueIndentTransVO vo) {

		OfflineIssueIndentTransDAO.getUnitCombo(vo);

		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("OfflineIssueIndentTransBO.getUnitCombo() --> "
					+ vo.getStrMsgString());
		}
	}
	
	
	/**
	 * PendingDemand  Method is Used to Generate 
	 * @param vo
	 */
	
	public void PendingDemand(OfflineIssueIndentTransVO _OfflineIssueIndentVO)
	{
		OfflineIssueIndentTransDAO.getPendingDemand(_OfflineIssueIndentVO);
		
		  if (_OfflineIssueIndentVO.getStrMsgType().equals("1")) 
		  {
			  _OfflineIssueIndentVO.setStrMsgString("OfflineIssueIndentTransBO.PendingDemand() --> "+ _OfflineIssueIndentVO.getStrMsgString());
		  }
		  
	}
	
	
	/**
	 * ApprovedByCombo  Method is Used to Generate Item Category Combo 
	 * @param vo
	 */
	public void ApprovedByCombo(OfflineIssueIndentTransVO offlineIssueIndent_VO) {
		
		OfflineIssueIndentTransDAO.getApprovedByCombo(offlineIssueIndent_VO);
		
		  if (offlineIssueIndent_VO.getStrMsgType().equals("1")) 
		  {
			  offlineIssueIndent_VO.setStrMsgString("OfflineIssueIndentTransBO.ApprovedByCombo() --> "+ offlineIssueIndent_VO.getStrMsgString());
		  }
		
	}
	/**
	 * IndentingStoreCombo  Method is Used to Generate Indenting STore Combo 
	 * @param vo
	 */
	
	public void IndentingStoreCombo(OfflineIssueIndentTransVO _OfflineIssueIndentVO)
	{
		OfflineIssueIndentTransDAO.IndentingStoreCombo(_OfflineIssueIndentVO);
		
		  if (_OfflineIssueIndentVO.getStrMsgType().equals("1")) 
		  {
			  _OfflineIssueIndentVO.setStrMsgString("OfflineIssueIndentTransBO.ItemCatgoryCombo() --> "+ _OfflineIssueIndentVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * ApprovedVerifyCombo  Method is Used to Generate Approved By + Verify By Store Combo 
	 * @param vo
	 */
	
	public void ApprovedVerifyCombo(OfflineIssueIndentTransVO _OfflineIssueIndentVO)
	{
		//OfflineIssueIndentTransDAO.getApprovedByCombo(_OfflineIssueIndentVO);
		OfflineIssueIndentTransDAO.getVerifyByCombo(_OfflineIssueIndentVO);
		
		  if (_OfflineIssueIndentVO.getStrMsgType().equals("1")) 
		  {
			  _OfflineIssueIndentVO.setStrMsgString("OfflineIssueIndentTransBO.ItemCatgoryCombo() --> "+ _OfflineIssueIndentVO.getStrMsgString());
		  }
		  
	}
	
	
	/**
	 * GetStoreBudget Method is Used to get Indenting Store Budget
	 * for Breakage Item Details DAO 
	 * @param vo
	 */
	public void GetStoreBudget(OfflineIssueIndentTransVO _OfflineIssueIndentVO)
	{		
		OfflineIssueIndentTransDAO.getAvalBudgetDetails(_OfflineIssueIndentVO);
		
		  if (_OfflineIssueIndentVO.getStrMsgType().equals("1")) 
		  {
			  _OfflineIssueIndentVO.setStrMsgString("OfflineIssueIndentBO.GetStoreBudget() --> "+ _OfflineIssueIndentVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * Method is Used to Generate View page data 
	 * @param vo
	 */	
	public void initForViewPage(OfflineIssueIndentTransVO _OfflineIssueIndentTransVO){
		
		 
		OfflineIssueIndentTransDAO.GetData(_OfflineIssueIndentTransVO);
		OfflineIssueIndentTransDAO.itemCategoryCombo1(_OfflineIssueIndentTransVO);
		if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
		{
			_OfflineIssueIndentTransVO.setStrMsgString("OfflineIssueIndentTransBO.initForViewPage() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
		}
	}
	
	/**
	 * This method is used to GET POPUP VALUES
	 * 
	 * @param vo
	 */
	public void getPopUpInfo(OfflineIssueIndentTransVO vo) 
	{

		OfflineIssueIndentTransDAO.getPopUpInfoProc(vo);
		

		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("OfflineIssueIndentTransBO.getPopUpInfo() --> "+ vo.getStrMsgString());
		}
	}
	
	/**
	 * This method is used to GET Issue Details
	 * 
	 * @param vo
	 */
	
	public void setViewPageDtl(OfflineIssueIndentTransVO _OfflineIssueIndentTransVO){
		
		OfflineIssueIndentTransDAO.getIssueDetail(_OfflineIssueIndentTransVO);
		if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1")){
			_OfflineIssueIndentTransVO.setStrMsgString("OfflineIssueIndentTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
		  }
		
	}
	/**
	 * This method is used to Save Data 
	 * 
	 * @param vo
	 */
	
	public void InsertOffLineforNewDemand(OfflineIssueIndentTransVO _OfflineIssueIndentTransVO){
		
		OfflineIssueIndentTransDAO.NewDemandOffLineIssueInsert(_OfflineIssueIndentTransVO);
		
		if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
		{
			_OfflineIssueIndentTransVO.setStrMsgString("OfflineIssueIndentTransBO.InsertOffLineforNewDemand() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
		}
		
	}
	
	
	/**
	 * This method is used to Save Data 
	 * 
	 * @param vo
	 */
	
	public void InsertOffLineforExistingDemand(OfflineIssueIndentTransVO _OfflineIssueIndentTransVO){
		
		OfflineIssueIndentTransDAO.InsertOffLineforExistingDemand(_OfflineIssueIndentTransVO);
		if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
		{
			_OfflineIssueIndentTransVO.setStrMsgString("OfflineIssueIndentTransBO.insertData() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
		}
		
	}
	


}
