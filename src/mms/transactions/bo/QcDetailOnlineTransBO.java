package mms.transactions.bo;

import mms.transactions.dao.QcDetailOnlineTransDAO;
import mms.transactions.vo.QcDetailOnlineTransVO;

/**
 * Developer : Vivek Aggarwal
 * Version : 1.0
 * Date : 16/Sep/2010
 *  
*/

public class QcDetailOnlineTransBO 
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
	public void GetData(QcDetailOnlineTransVO issueSampleForQcCheckTransVO_p)
	{
		QcDetailOnlineTransDAO.GetData(issueSampleForQcCheckTransVO_p);
		QcDetailOnlineTransDAO.itemCategoryCombo(issueSampleForQcCheckTransVO_p);
		QcDetailOnlineTransDAO.getLabNameCombo(issueSampleForQcCheckTransVO_p);
		
		
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
	public void getItemDetail(QcDetailOnlineTransVO vo) 
	{
		QcDetailOnlineTransDAO.getItemDetail(vo);

		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("QcDetailOnlineTransBO.getItemDetail() --> "
					+ vo.getStrMsgString());
		}

	}
	
	
	/**
	 * ItemCategoryCombo  Method is Used to Generate Item Category Combo 
	 * @param vo
	 */
	
	public void ItemCatgoryCombo(QcDetailOnlineTransVO issueSampleForQcCheckTransVO_p)
	{
		QcDetailOnlineTransDAO.itemCategoryCombo(issueSampleForQcCheckTransVO_p);
		
		  if (issueSampleForQcCheckTransVO_p.getStrMsgType().equals("1")) 
		  {
			  issueSampleForQcCheckTransVO_p.setStrMsgString("QcDetailOnlineTransBO.ItemCatgoryCombo() --> "+ issueSampleForQcCheckTransVO_p.getStrMsgString());
		  }
		  
	}
		
	
	/**
	 * This method is used to populate the value of Unit name combo
	 * 
	 * @param vo
	 */
	public void getUnitCombo(QcDetailOnlineTransVO vo) {

		QcDetailOnlineTransDAO.getUnitCombo(vo);

		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("QcDetailOnlineTransBO.getUnitCombo() --> "
					+ vo.getStrMsgString());
		}
	}
	
	
	/**
	 * To get Drug name Combo
	 * 
	 * @param voObj
	 */
	public void getSampleSentDtl(QcDetailOnlineTransVO voObj_p)
	{
		QcDetailOnlineTransDAO.getSampleSentDtl(voObj_p);
		
		
		
		if (voObj_p.getStrMsgType().equals("1")) 
		{
					String strErr = voObj_p.getStrMsgString();
						
					voObj_p.setStrMsgString("QcDetailOnlineTransBO.getSampleSentDtl()-->"+strErr);
		}
	}
	
	/**
	 * To get Drug name Combo
	 * 
	 * @param voObj
	 */
	public void getSampleSentDtl_WithSearch(QcDetailOnlineTransVO voObj_p)
	{
		QcDetailOnlineTransDAO.getSampleSentDtl_withSearch(voObj_p);
		
		
		
		if (voObj_p.getStrMsgType().equals("1")) 
		{
					String strErr = voObj_p.getStrMsgString();
						
					voObj_p.setStrMsgString("QcDetailOnlineTransBO.getSampleSentDtl_withSearch()-->"+strErr);
		}
	}
	
	
	/**
	 * ApprovedByCombo  Method is Used to Generate Item Category Combo 
	 * @param vo
	 */
	public void ApprovedByCombo(QcDetailOnlineTransVO offlineIssueIndent_VO) {
		
		QcDetailOnlineTransDAO.getApprovedByCombo(offlineIssueIndent_VO);
		
		  if (offlineIssueIndent_VO.getStrMsgType().equals("1")) 
		  {
			  offlineIssueIndent_VO.setStrMsgString("QcDetailOnlineTransBO.ApprovedByCombo() --> "+ offlineIssueIndent_VO.getStrMsgString());
		  }
		
	}
	/**
	 * IndentingStoreCombo  Method is Used to Generate Indenting STore Combo 
	 * @param vo
	 */
	
	public void getLabNameCombo(QcDetailOnlineTransVO issueSampleForQcCheckTransVO_p)
	{
		QcDetailOnlineTransDAO.getLabNameCombo(issueSampleForQcCheckTransVO_p);
		
		  if (issueSampleForQcCheckTransVO_p.getStrMsgType().equals("1")) 
		  {
			  issueSampleForQcCheckTransVO_p.setStrMsgString("QcDetailOnlineTransBO.ItemCatgoryCombo() --> "+ issueSampleForQcCheckTransVO_p.getStrMsgString());
		  }
		  
	}
	
	/**
	 * ApprovedVerifyCombo  Method is Used to Generate Approved By + Verify By Store Combo 
	 * @param vo
	 */
	
	public void ApprovedVerifyCombo(QcDetailOnlineTransVO issueSampleForQcCheckTransVO_p)
	{
		//QcDetailOnlineTransDAO.getApprovedByCombo(issueSampleForQcCheckTransVO_p);
		QcDetailOnlineTransDAO.getVerifyByCombo(issueSampleForQcCheckTransVO_p);
		
		  if (issueSampleForQcCheckTransVO_p.getStrMsgType().equals("1")) 
		  {
			  issueSampleForQcCheckTransVO_p.setStrMsgString("QcDetailOnlineTransBO.ItemCatgoryCombo() --> "+ issueSampleForQcCheckTransVO_p.getStrMsgString());
		  }
		  
	}
	
	
	/**
	 * GetStoreBudget Method is Used to get Indenting Store Budget
	 * for Breakage Item Details DAO 
	 * @param vo
	 */
	public void GetStoreBudget(QcDetailOnlineTransVO issueSampleForQcCheckTransVO_p)
	{		
		QcDetailOnlineTransDAO.getAvalBudgetDetails(issueSampleForQcCheckTransVO_p);
		
		  if (issueSampleForQcCheckTransVO_p.getStrMsgType().equals("1")) 
		  {
			  issueSampleForQcCheckTransVO_p.setStrMsgString("OfflineIssueIndentBO.GetStoreBudget() --> "+ issueSampleForQcCheckTransVO_p.getStrMsgString());
		  }
		  
	}
	
	/**
	 * Method is Used to Generate View page data 
	 * @param vo
	 */	
	public void initForViewPage(QcDetailOnlineTransVO _QcDetailOnlineTransVO){
		
		 
		QcDetailOnlineTransDAO.GetData(_QcDetailOnlineTransVO);
		QcDetailOnlineTransDAO.itemCategoryCombo1(_QcDetailOnlineTransVO);
		QcDetailOnlineTransDAO.getLabNameCombo(_QcDetailOnlineTransVO);
		if (_QcDetailOnlineTransVO.getStrMsgType().equals("1"))
		{
			_QcDetailOnlineTransVO.setStrMsgString("QcDetailOnlineTransBO.initForViewPage() --> "+ _QcDetailOnlineTransVO.getStrMsgString());
		}
	}
	
	/**
	 * This method is used to GET POPUP VALUES
	 * 
	 * @param vo
	 */
	public void getPopUpInfo(QcDetailOnlineTransVO vo) 
	{

		QcDetailOnlineTransDAO.getPopUpInfoProc(vo);
		

		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("QcDetailOnlineTransBO.getPopUpInfo() --> "+ vo.getStrMsgString());
		}
	}
	
	/**
	 * This method is used to GET Issue Details
	 * 
	 * @param vo
	 */
	
	public void getViewQcOnlineDetail(QcDetailOnlineTransVO _QcDetailOnlineTransVO){
		
		QcDetailOnlineTransDAO.getViewQcOnlineDetail(_QcDetailOnlineTransVO);
		if (_QcDetailOnlineTransVO.getStrMsgType().equals("1")){
			_QcDetailOnlineTransVO.setStrMsgString("QcDetailOnlineTransBO.setViewPageDtl() --> "+ _QcDetailOnlineTransVO.getStrMsgString());
		  }
		
	}
	/**
	 * This method is used to Save Data 
	 * 
	 * @param vo
	 */
	
	public void insertIssueSampleForQcCheck(QcDetailOnlineTransVO _QcDetailOnlineTransVO){
		
		QcDetailOnlineTransDAO.insertIssueSampleForQcCheck(_QcDetailOnlineTransVO);
		
		if (_QcDetailOnlineTransVO.getStrMsgType().equals("1"))
		{
			_QcDetailOnlineTransVO.setStrMsgString("QcDetailOnlineTransBO.insertData() --> "+ _QcDetailOnlineTransVO.getStrMsgString());
		}
		
	}
	
	/**
	 * This method is used to getCurrent Stock Detail
	 * 
	 * @param vo
	 */
	
	public void getCurrentStockDetail(QcDetailOnlineTransVO _QcDetailOnlineTransVO){
		
		QcDetailOnlineTransDAO.getDrugCurrStockDtl(_QcDetailOnlineTransVO);
		
		if (_QcDetailOnlineTransVO.getStrMsgType().equals("1"))
		{
			_QcDetailOnlineTransVO.setStrMsgString("QcDetailOnlineTransBO.getCurrentStockDetail() --> "+ _QcDetailOnlineTransVO.getStrMsgString());
		}
		
	}
	
	/**
	 * This method is used to Save Data 
	 * 
	 * @param vo
	 */
	
	public void saveQcDetail(QcDetailOnlineTransVO _QcDetailOnlineTransVO){
		
		QcDetailOnlineTransDAO.saveQcDetail(_QcDetailOnlineTransVO);
		
		if (_QcDetailOnlineTransVO.getStrMsgType().equals("1"))
		{
			_QcDetailOnlineTransVO.setStrMsgString("QcDetailOnlineTransBO.saveQcDetail() --> "+ _QcDetailOnlineTransVO.getStrMsgString());
		}
		
	}
	

}
