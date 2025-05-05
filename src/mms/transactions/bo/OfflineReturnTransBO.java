package mms.transactions.bo;

import mms.transactions.dao.OfflineReturnTransDAO;
import mms.transactions.vo.OfflineReturnTransVO;

/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 16/Sep/2010
 *  
*/

public class OfflineReturnTransBO 
{
	/**
	 * BO Method is Used To Get the DAO method
	 * to intreact with Database 
	 * @param vo
	 * @throws Exception
	 */
	
	
	/**
	 * ApprovedByCombo  Method is Used to Generate Item Category Combo 
	 * @param vo
	 */
	public void ApprovedByCombo(OfflineReturnTransVO offlineReturn_VO) {
		
		OfflineReturnTransDAO.getApprovedByCombo(offlineReturn_VO);
		
		  if (offlineReturn_VO.getStrMsgType().equals("1")) 
		  {
			  offlineReturn_VO.setStrMsgString("OfflineReturnTransBO.ApprovedByCombo() --> "+ offlineReturn_VO.getStrMsgString());
		  }
		
	}
	
	/**
	 * GetData Method is Used to Populate the Data 
	 * for Breakage Item Details DAO 
	 * @param vo
	 */
	public void GetData(OfflineReturnTransVO _OfflineIssueIndentVO)
	{
		OfflineReturnTransDAO.GetData(_OfflineIssueIndentVO);
		OfflineReturnTransDAO.itemCategoryCombo(_OfflineIssueIndentVO);
		OfflineReturnTransDAO.IndentPeriodCombo(_OfflineIssueIndentVO);
		
		  if (_OfflineIssueIndentVO.getStrMsgType().equals("1")) 
		  {
			  _OfflineIssueIndentVO.setStrMsgString("OfflineIssueIndentBO.GetData() --> "+ _OfflineIssueIndentVO.getStrMsgString());
		  }
		  
	}
	/**
	 * ItemCategoryCombo  Method is Used to Generate Item Category Combo 
	 * @param vo
	 */
	
	public void ItemCatgoryCombo(OfflineReturnTransVO _OfflineIssueIndentVO)
	{
		OfflineReturnTransDAO.itemCategoryCombo(_OfflineIssueIndentVO);
		
		  if (_OfflineIssueIndentVO.getStrMsgType().equals("1")) 
		  {
			  _OfflineIssueIndentVO.setStrMsgString("OfflineReturnTransBO.ItemCatgoryCombo() --> "+ _OfflineIssueIndentVO.getStrMsgString());
		  }
		  
	}
	/**
	 * IndentingStoreCombo  Method is Used to Generate Indenting STore Combo 
	 * @param vo
	 */
	
	public void IndentingStoreCombo(OfflineReturnTransVO _OfflineIssueIndentVO)
	{
		OfflineReturnTransDAO.IndentingStoreCombo(_OfflineIssueIndentVO);
		
		  if (_OfflineIssueIndentVO.getStrMsgType().equals("1")) 
		  {
			  _OfflineIssueIndentVO.setStrMsgString("OfflineReturnTransBO.ItemCatgoryCombo() --> "+ _OfflineIssueIndentVO.getStrMsgString());
		  }
		  
	}
	/**
	 * Method is Used to Generate View page data 
	 * @param vo
	 */	
	public void initForViewPage(OfflineReturnTransVO _OfflineReturnTransVO){
		
		 
		OfflineReturnTransDAO.GetData(_OfflineReturnTransVO);
		OfflineReturnTransDAO.itemCategoryCombo1(_OfflineReturnTransVO);
		if (_OfflineReturnTransVO.getStrMsgType().equals("1"))
		{
			_OfflineReturnTransVO.setStrMsgString("OfflineReturnTransBO.initForViewPage() --> "+ _OfflineReturnTransVO.getStrMsgString());
		}
	}
	/**
	 * ApprovedVerifyCombo  Method is Used to Generate Approved By + Verify By Store Combo 
	 * @param vo
	 */
	
	public void ApprovedVerifyCombo(OfflineReturnTransVO _OfflineIssueIndentVO)
	{
		
		OfflineReturnTransDAO.getVerifyByCombo(_OfflineIssueIndentVO);
		
		  if (_OfflineIssueIndentVO.getStrMsgType().equals("1")) 
		  {
			  _OfflineIssueIndentVO.setStrMsgString("OfflineReturnTransBO.ItemCatgoryCombo() --> "+ _OfflineIssueIndentVO.getStrMsgString());
		  }
		  
	}
	/**
	 * This method is used to Save Data 
	 * 
	 * @param vo
	 */
	
	public void insertData(OfflineReturnTransVO _OfflineReturnTransVO){
		
		OfflineReturnTransDAO.insert(_OfflineReturnTransVO);
		if (_OfflineReturnTransVO.getStrMsgType().equals("1")){
			_OfflineReturnTransVO.setStrMsgString("OfflineReturnTransBO.insertData() --> "+ _OfflineReturnTransVO.getStrMsgString());
		  }
		
	}
	
	
	/**
	 * This method is used to GET POPUP VALUES
	 * 
	 * @param vo
	 */
	public void getPopUpInfo(OfflineReturnTransVO vo) 
	{
		OfflineReturnTransDAO.getPopUpInfoProc(vo);
		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("OfflineReturnTransBO.getPopUpInfo() --> "+ vo.getStrMsgString());
		}
	}
	
	
	public void setViewPageDtl(OfflineReturnTransVO _OfflineReturnTransVO){
		
		OfflineReturnTransDAO.getIssueDetail(_OfflineReturnTransVO);
		if (_OfflineReturnTransVO.getStrMsgType().equals("1")){
			_OfflineReturnTransVO.setStrMsgString("OfflineReturnTransBO.setViewPageDtl() --> "+ _OfflineReturnTransVO.getStrMsgString());
		  }
		
	}


}
