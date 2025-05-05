package mms.transactions.bo;

import mms.global.dao.MmsDAO;
import mms.global.vo.MmsVO;
import mms.transactions.dao.OffLineIssueForSpPPDAO;
import mms.transactions.vo.OffLineIssueForSpPPVO;

public class OffLineIssueForSpPPBO 

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
	public void GetData(OffLineIssueForSpPPVO _OfflineIssueIndentVO)
	{
		OffLineIssueForSpPPDAO.GetData(_OfflineIssueIndentVO);
		OffLineIssueForSpPPDAO.itemCategoryCombo(_OfflineIssueIndentVO);
		OffLineIssueForSpPPDAO.IndentPeriodCombo(_OfflineIssueIndentVO);
		OffLineIssueForSpPPDAO.getApprovedByCombo(_OfflineIssueIndentVO);
		
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
	public void getItemDetail(OffLineIssueForSpPPVO vo) 
	{
		OffLineIssueForSpPPDAO.getItemDetail(vo);

		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("OffLineIssueForSpPPBO.getItemDetail() --> "
					+ vo.getStrMsgString());
		}

	}
	
	
	/**
	 * ItemCategoryCombo  Method is Used to Generate Item Category Combo 
	 * @param vo
	 */
	
	public void ItemCatgoryCombo(OffLineIssueForSpPPVO _OfflineIssueIndentVO)
	{
		OffLineIssueForSpPPDAO.itemCategoryCombo(_OfflineIssueIndentVO);
		
		  if (_OfflineIssueIndentVO.getStrMsgType().equals("1")) 
		  {
			  _OfflineIssueIndentVO.setStrMsgString("OffLineIssueForSpPPBO.ItemCatgoryCombo() --> "+ _OfflineIssueIndentVO.getStrMsgString());
		  }
		  
	}
	
	
	/**
	 * This method is used to get indent details
	 * 
	 * @param vo
	 */
	public void getIndentDetail(OffLineIssueForSpPPVO vo) 
	{
		OffLineIssueForSpPPDAO.getIndentDetail(vo);
				
		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("OffLineIssueForSpPPBO.getIndentDetail() --> "+ vo.getStrMsgString());
		}

	}
	
	
	/**
	 * This method is used to populate the value of Unit name combo
	 * 
	 * @param vo
	 */
	public void getUnitCombo(OffLineIssueForSpPPVO vo) {

		OffLineIssueForSpPPDAO.getUnitCombo(vo);

		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("OffLineIssueForSpPPBO.getUnitCombo() --> "
					+ vo.getStrMsgString());
		}
	}
	
	
	/**
	 * PendingDemand  Method is Used to Generate 
	 * @param vo
	 */
	
	public void PendingDemand(OffLineIssueForSpPPVO _OfflineIssueIndentVO)
	{
		OffLineIssueForSpPPDAO.getPendingDemand(_OfflineIssueIndentVO);
		
		  if (_OfflineIssueIndentVO.getStrMsgType().equals("1")) 
		  {
			  _OfflineIssueIndentVO.setStrMsgString("OffLineIssueForSpPPBO.PendingDemand() --> "+ _OfflineIssueIndentVO.getStrMsgString());
		  }
		  
	}
	
	
	/**
	 * ApprovedByCombo  Method is Used to Generate Item Category Combo 
	 * @param vo
	 */
	public void ApprovedByCombo(OffLineIssueForSpPPVO offlineIssueIndent_VO) {
		
		OffLineIssueForSpPPDAO.getApprovedByCombo(offlineIssueIndent_VO);
		
		  if (offlineIssueIndent_VO.getStrMsgType().equals("1")) 
		  {
			  offlineIssueIndent_VO.setStrMsgString("OffLineIssueForSpPPBO.ApprovedByCombo() --> "+ offlineIssueIndent_VO.getStrMsgString());
		  }
		
	}
	/**
	 * IndentingStoreCombo  Method is Used to Generate Indenting STore Combo 
	 * @param vo
	 */
	
	public void IndentingStoreCombo(OffLineIssueForSpPPVO _OfflineIssueIndentVO)
	{
		OffLineIssueForSpPPDAO.IndentingStoreCombo(_OfflineIssueIndentVO);
		
		  if (_OfflineIssueIndentVO.getStrMsgType().equals("1")) 
		  {
			  _OfflineIssueIndentVO.setStrMsgString("OffLineIssueForSpPPBO.ItemCatgoryCombo() --> "+ _OfflineIssueIndentVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * ApprovedVerifyCombo  Method is Used to Generate Approved By + Verify By Store Combo 
	 * @param vo
	 */
	
	public void ApprovedVerifyCombo(OffLineIssueForSpPPVO _OfflineIssueIndentVO)
	{
		//OffLineIssueForSpPPDAO.getApprovedByCombo(_OfflineIssueIndentVO);
		OffLineIssueForSpPPDAO.getVerifyByCombo(_OfflineIssueIndentVO);
		
		  if (_OfflineIssueIndentVO.getStrMsgType().equals("1")) 
		  {
			  _OfflineIssueIndentVO.setStrMsgString("OffLineIssueForSpPPBO.ItemCatgoryCombo() --> "+ _OfflineIssueIndentVO.getStrMsgString());
		  }
		  
	}
	
	
	/**
	 * GetStoreBudget Method is Used to get Indenting Store Budget
	 * for Breakage Item Details DAO 
	 * @param vo
	 */
	public void GetStoreBudget(OffLineIssueForSpPPVO _OfflineIssueIndentVO)
	{		
		OffLineIssueForSpPPDAO.getAvalBudgetDetails(_OfflineIssueIndentVO);
		
		  if (_OfflineIssueIndentVO.getStrMsgType().equals("1")) 
		  {
			  _OfflineIssueIndentVO.setStrMsgString("OfflineIssueIndentBO.GetStoreBudget() --> "+ _OfflineIssueIndentVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * Method is Used to Generate View page data 
	 * @param vo
	 */	
	public void initForViewPage(OffLineIssueForSpPPVO _OffLineIssueForSpPPVO){
		
		 
		OffLineIssueForSpPPDAO.GetData(_OffLineIssueForSpPPVO);
		OffLineIssueForSpPPDAO.itemCategoryCombo1(_OffLineIssueForSpPPVO);
		if (_OffLineIssueForSpPPVO.getStrMsgType().equals("1"))
		{
			_OffLineIssueForSpPPVO.setStrMsgString("OffLineIssueForSpPPBO.initForViewPage() --> "+ _OffLineIssueForSpPPVO.getStrMsgString());
		}
	}
	
	/**
	 * This method is used to GET POPUP VALUES
	 * 
	 * @param vo
	 */
	public void getPopUpInfo(OffLineIssueForSpPPVO vo) 
	{

		OffLineIssueForSpPPDAO.getPopUpInfoProc(vo);
		

		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("OffLineIssueForSpPPBO.getPopUpInfo() --> "+ vo.getStrMsgString());
		}
	}
	
	/**
	 * This method is used to GET Issue Details
	 * 
	 * @param vo
	 */
	
	public void setViewPageDtl(OffLineIssueForSpPPVO _OffLineIssueForSpPPVO){
		
		OffLineIssueForSpPPDAO.getIssueDetail(_OffLineIssueForSpPPVO);
		if (_OffLineIssueForSpPPVO.getStrMsgType().equals("1")){
			_OffLineIssueForSpPPVO.setStrMsgString("OffLineIssueForSpPPBO.setViewPageDtl() --> "+ _OffLineIssueForSpPPVO.getStrMsgString());
		  }
		
	}
	/**
	 * This method is used to Save Data 
	 * 
	 * @param vo
	 */
	
	public void InsertOffLineforNewDemand(OffLineIssueForSpPPVO _OffLineIssueForSpPPVO){
		
		OffLineIssueForSpPPDAO.NewDemandOffLineIssueInsert(_OffLineIssueForSpPPVO);
		
		if (_OffLineIssueForSpPPVO.getStrMsgType().equals("1"))
		{
			_OffLineIssueForSpPPVO.setStrMsgString("OffLineIssueForSpPPBO.InsertOffLineforNewDemand() --> "+ _OffLineIssueForSpPPVO.getStrMsgString());
		}
		
	}
	
	
	/**
	 * This method is used to Save Data 
	 * 
	 * @param vo
	 */
	
	public void InsertOffLineforExistingDemand(OffLineIssueForSpPPVO _OffLineIssueForSpPPVO){
		
		OffLineIssueForSpPPDAO.InsertOffLineforExistingDemand(_OffLineIssueForSpPPVO);
		if (_OffLineIssueForSpPPVO.getStrMsgType().equals("1"))
		{
			_OffLineIssueForSpPPVO.setStrMsgString("OffLineIssueForSpPPBO.insertData() --> "+ _OffLineIssueForSpPPVO.getStrMsgString());
		}
		
	}
	
	/**
	 * Gets the issue dtls init dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the issue dtls init dtls
	 */
	public void getIssueDtlsInitDtls(OffLineIssueForSpPPVO vo) {

		OffLineIssueForSpPPDAO.getIssueDtlsList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("OffLineIssueForSpPPBO.getIssueDtlsInitDtls() --> "
							+ strErr);

		}

	}
	


}