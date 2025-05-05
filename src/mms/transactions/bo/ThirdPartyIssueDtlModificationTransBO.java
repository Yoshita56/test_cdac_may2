package mms.transactions.bo;

import mms.transactions.dao.ThirdPartyIssueDtlModificationTransDAO;
import mms.transactions.dao.ThirdPartyIssueReqTransDAO;
import mms.transactions.vo.ThirdPartyIssueDtlModificationTransVO;
import mms.transactions.vo.ThirdPartyIssueReqTransVO;

public class ThirdPartyIssueDtlModificationTransBO 
{
	
	
	/**
	 * GetData Method is Used to Populate the Data 
	 * for Breakage Item Details DAO 
	 * @param vo
	 */
	public void GetData(ThirdPartyIssueDtlModificationTransVO _ThirdPartyIssueDtlModificationTransVO)
	{
		ThirdPartyIssueDtlModificationTransDAO.GetData(_ThirdPartyIssueDtlModificationTransVO);
		ThirdPartyIssueDtlModificationTransDAO.IndentPeriodCombo(_ThirdPartyIssueDtlModificationTransVO);
		
		
		  if (_ThirdPartyIssueDtlModificationTransVO.getStrMsgType().equals("1")) 
		  {
			  _ThirdPartyIssueDtlModificationTransVO.setStrMsgString("ThirdPartyIssueDtlModificationTransBO.GetData() --> "+ _ThirdPartyIssueDtlModificationTransVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * This method is used to get Item Details
	 * 
	 * @param vo
	 */
	public void getItemDetail(ThirdPartyIssueDtlModificationTransVO vo) 
	{
		ThirdPartyIssueDtlModificationTransDAO.getItemDetail(vo);

		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("ThirdPartyIssueDtlModificationTransBO.getItemDetail() --> "
					+ vo.getStrMsgString());
		}

	}
	
	/**
	 * To insert record
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void insertRecord(ThirdPartyIssueDtlModificationTransVO vo)
	{
		
		
		ThirdPartyIssueDtlModificationTransDAO.insertRecord(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ThirdPartyIssueDtlModificationTransBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}
		
	}
	
	
	
	/**
	 * ItemCategoryCombo  Method is Used to Generate Item Category Combo 
	 * @param vo
	 */
	
	public void ItemCatgoryCombo(ThirdPartyIssueDtlModificationTransVO _ThirdPartyIssueDtlModificationTransVO)
	{
		ThirdPartyIssueDtlModificationTransDAO.itemCategoryCombo(_ThirdPartyIssueDtlModificationTransVO);
		
		  if (_ThirdPartyIssueDtlModificationTransVO.getStrMsgType().equals("1")) 
		  {
			  _ThirdPartyIssueDtlModificationTransVO.setStrMsgString("ThirdPartyIssueDtlModificationTransBO.ItemCatgoryCombo() --> "+ _ThirdPartyIssueDtlModificationTransVO.getStrMsgString());
		  }
		  
	}
	
	
	/**
	 * This method is used to get indent details
	 * 
	 * @param vo
	 */
	public void getIndentDetail(ThirdPartyIssueDtlModificationTransVO vo) 
	{
		ThirdPartyIssueDtlModificationTransDAO.getIndentDetail(vo);
				
		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("ThirdPartyIssueDtlModificationTransBO.getIndentDetail() --> "+ vo.getStrMsgString());
		}

	}
	
	
	/**
	 * This method is used to populate the value of Unit name combo
	 * 
	 * @param vo
	 */
	public void getUnitCombo(ThirdPartyIssueDtlModificationTransVO vo) {

		ThirdPartyIssueDtlModificationTransDAO.getUnitCombo(vo);

		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("ThirdPartyIssueDtlModificationTransBO.getUnitCombo() --> "
					+ vo.getStrMsgString());
		}
	}
	
	
	/**
	 * PendingDemand  Method is Used to Generate 
	 * @param vo
	 */
	
	public void PendingDemand(ThirdPartyIssueDtlModificationTransVO _ThirdPartyIssueDtlModificationTransVO)
	{
		ThirdPartyIssueDtlModificationTransDAO.getPendingDemand(_ThirdPartyIssueDtlModificationTransVO);
		
		  if (_ThirdPartyIssueDtlModificationTransVO.getStrMsgType().equals("1")) 
		  {
			  _ThirdPartyIssueDtlModificationTransVO.setStrMsgString("ThirdPartyIssueDtlModificationTransBO.PendingDemand() --> "+ _ThirdPartyIssueDtlModificationTransVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * This method is used for THIRD PARTY LIST
	 * @param voObj
	 */
	public void getThirdPartyCmb(ThirdPartyIssueDtlModificationTransVO voObj){
		
		ThirdPartyIssueDtlModificationTransDAO.getThirdPartyCmb(voObj);
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("ThirdPartyIssueReqTransBO.getThirdPartyCmb()-->"+strErr);
		}
		
	}
	
	
	/**
	 * BatchCombo  Method is Used to Generate Indenting STore Combo 
	 * @param vo
	 */
	
	public static void BatchCombo(ThirdPartyIssueDtlModificationTransVO _ThirdPartyIssueDtlModificationTransVO)
	{
		ThirdPartyIssueDtlModificationTransDAO.getBatchCombo(_ThirdPartyIssueDtlModificationTransVO);
		
		  if (_ThirdPartyIssueDtlModificationTransVO.getStrMsgType().equals("1")) 
		  {
			  _ThirdPartyIssueDtlModificationTransVO.setStrMsgString("ThirdPartyIssueDtlModificationTransBO.BatchCombo() --> "+ _ThirdPartyIssueDtlModificationTransVO.getStrMsgString());
		  }
		  
	}
	/**
	 * IndentingStoreCombo  Method is Used to Generate Indenting STore Combo 
	 * @param vo
	 */
	
	public void VoucherDetails(ThirdPartyIssueDtlModificationTransVO _ThirdPartyIssueDtlModificationTransVO)
	{
		ThirdPartyIssueDtlModificationTransDAO.VoucherDetails(_ThirdPartyIssueDtlModificationTransVO);
		//ThirdPartyIssueDtlModificationTransDAO.VoucherItemDetails(_ThirdPartyIssueDtlModificationTransVO);
		
		  if (_ThirdPartyIssueDtlModificationTransVO.getStrMsgType().equals("1")) 
		  {
			  _ThirdPartyIssueDtlModificationTransVO.setStrMsgString("ThirdPartyIssueDtlModificationTransBO.VoucherDetails() --> "+ _ThirdPartyIssueDtlModificationTransVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * IndentingStoreCombo  Method is Used to Generate Indenting STore Combo 
	 * @param vo
	 */
	
	public void VoucherCombo(ThirdPartyIssueDtlModificationTransVO _ThirdPartyIssueDtlModificationTransVO)
	{
		ThirdPartyIssueDtlModificationTransDAO.getVoucherCombo(_ThirdPartyIssueDtlModificationTransVO);
		ThirdPartyIssueDtlModificationTransDAO.getVerifyByCombo(_ThirdPartyIssueDtlModificationTransVO);
		  if (_ThirdPartyIssueDtlModificationTransVO.getStrMsgType().equals("1")) 
		  {
			  _ThirdPartyIssueDtlModificationTransVO.setStrMsgString("ThirdPartyIssueDtlModificationTransBO.VoucherCombo() --> "+ _ThirdPartyIssueDtlModificationTransVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * GetStoreBudget Method is Used to get Indenting Store Budget
	 * for Breakage Item Details DAO 
	 * @param vo
	 */
	public void GetStoreBudget(ThirdPartyIssueDtlModificationTransVO _ThirdPartyIssueDtlModificationTransVO)
	{		
		ThirdPartyIssueDtlModificationTransDAO.getAvalBudgetDetails(_ThirdPartyIssueDtlModificationTransVO);
		
		  if (_ThirdPartyIssueDtlModificationTransVO.getStrMsgType().equals("1")) 
		  {
			  _ThirdPartyIssueDtlModificationTransVO.setStrMsgString("ThirdPartyIssueDtlModificationTransBO.GetStoreBudget() --> "+ _ThirdPartyIssueDtlModificationTransVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * Method is Used to Generate View page data 
	 * @param vo
	 */	
	public void initForViewPage(ThirdPartyIssueDtlModificationTransVO _ThirdPartyIssueDtlModificationTransVO){
		
		 
		ThirdPartyIssueDtlModificationTransDAO.GetData(_ThirdPartyIssueDtlModificationTransVO);
		ThirdPartyIssueDtlModificationTransDAO.getUnitCombo(_ThirdPartyIssueDtlModificationTransVO);
		ThirdPartyIssueDtlModificationTransDAO.getDrugNameCombo(_ThirdPartyIssueDtlModificationTransVO);
		ThirdPartyIssueDtlModificationTransDAO.getThirdPartyCmb(_ThirdPartyIssueDtlModificationTransVO);
		if (_ThirdPartyIssueDtlModificationTransVO.getStrMsgType().equals("1"))
		{
			_ThirdPartyIssueDtlModificationTransVO.setStrMsgString("ThirdPartyIssueDtlModificationTransBO.initForViewPage() --> "+ _ThirdPartyIssueDtlModificationTransVO.getStrMsgString());
		}
	}
	
	/**
	 * This method is used to GET Issue Details
	 * 
	 * @param vo
	 */
	
	public void getVoucherCombo(ThirdPartyIssueDtlModificationTransVO _ThirdPartyIssueDtlModificationTransVO){
		
		ThirdPartyIssueDtlModificationTransDAO.getVoucherCombo(_ThirdPartyIssueDtlModificationTransVO);
		if (_ThirdPartyIssueDtlModificationTransVO.getStrMsgType().equals("1")){
			_ThirdPartyIssueDtlModificationTransVO.setStrMsgString("ThirdPartyIssueDtlModificationTransBO.getVoucherCombo() --> "+ _ThirdPartyIssueDtlModificationTransVO.getStrMsgString());
		  }
		
	}

	
	
	/**
	 * getAvlQty  Method 
	 * @param vo
	 */
	
	public void getAvlQty(ThirdPartyIssueDtlModificationTransVO _ThirdPartyIssueDtlModificationTransVO)
	{
		ThirdPartyIssueDtlModificationTransDAO.getAvlQty(_ThirdPartyIssueDtlModificationTransVO);
		
		  if (_ThirdPartyIssueDtlModificationTransVO.getStrMsgType().equals("1")) 
		  {
			  _ThirdPartyIssueDtlModificationTransVO.setStrMsgString("ThirdPartyIssueDtlModificationTransBO.getAvlQty() --> "+ _ThirdPartyIssueDtlModificationTransVO.getStrMsgString());
		  }
		  
	}
	
	
}
