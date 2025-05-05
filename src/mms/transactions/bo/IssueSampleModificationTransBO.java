package mms.transactions.bo;

import mms.transactions.dao.IssueSampleModificationTransDAO;
import mms.transactions.vo.IssueSampleModificationTransVO;
import mms.transactions.vo.ThirdPartyIssueReqTransVO;

public class IssueSampleModificationTransBO 
{
	
	
	/**
	 * GetData Method is Used to Populate the Data 
	 * for Breakage Item Details DAO 
	 * @param vo
	 */
	public void GetData(IssueSampleModificationTransVO _IssueSampleModificationTransVO)
	{
		IssueSampleModificationTransDAO.GetData(_IssueSampleModificationTransVO);
		
		
		  if (_IssueSampleModificationTransVO.getStrMsgType().equals("1")) 
		  {
			  _IssueSampleModificationTransVO.setStrMsgString("IssueSampleModificationTransBO.GetData() --> "+ _IssueSampleModificationTransVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * This method is used to get Item Details
	 * 
	 * @param vo
	 */
	public void getItemDetail(IssueSampleModificationTransVO vo) 
	{
		IssueSampleModificationTransDAO.getItemDetail(vo);

		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("IssueSampleModificationTransBO.getItemDetail() --> "
					+ vo.getStrMsgString());
		}

	}
	
	/**
	 * To insert record
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void insertRecord(IssueSampleModificationTransVO vo)
	{
		
		
		IssueSampleModificationTransDAO.insertRecord(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IssueSampleModificationTransBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}
		
	}
	
	
	
	/**
	 * ItemCategoryCombo  Method is Used to Generate Item Category Combo 
	 * @param vo
	 */
	
	public void ItemCatgoryCombo(IssueSampleModificationTransVO _IssueSampleModificationTransVO)
	{
		IssueSampleModificationTransDAO.itemCategoryCombo(_IssueSampleModificationTransVO);
		
		  if (_IssueSampleModificationTransVO.getStrMsgType().equals("1")) 
		  {
			  _IssueSampleModificationTransVO.setStrMsgString("IssueSampleModificationTransBO.ItemCatgoryCombo() --> "+ _IssueSampleModificationTransVO.getStrMsgString());
		  }
		  
	}
	
	
	/**
	 * This method is used to get indent details
	 * 
	 * @param vo
	 */
	public void getIndentDetail(IssueSampleModificationTransVO vo) 
	{
		IssueSampleModificationTransDAO.getIndentDetail(vo);
				
		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("IssueSampleModificationTransBO.getIndentDetail() --> "+ vo.getStrMsgString());
		}

	}
	
	
	/**
	 * This method is used to populate the value of Unit name combo
	 * 
	 * @param vo
	 */
	public void getUnitCombo(IssueSampleModificationTransVO vo) {

		IssueSampleModificationTransDAO.getUnitCombo(vo);

		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("IssueSampleModificationTransBO.getUnitCombo() --> "
					+ vo.getStrMsgString());
		}
	}
	
	
	/**
	 * PendingDemand  Method is Used to Generate 
	 * @param vo
	 */
	
	public void PendingDemand(IssueSampleModificationTransVO _IssueSampleModificationTransVO)
	{
		IssueSampleModificationTransDAO.getPendingDemand(_IssueSampleModificationTransVO);
		
		  if (_IssueSampleModificationTransVO.getStrMsgType().equals("1")) 
		  {
			  _IssueSampleModificationTransVO.setStrMsgString("IssueSampleModificationTransBO.PendingDemand() --> "+ _IssueSampleModificationTransVO.getStrMsgString());
		  }
		  
	}

	
	
	/**
	 * BatchCombo  Method is Used to Generate Indenting STore Combo 
	 * @param vo
	 */
	
	public static void BatchCombo(IssueSampleModificationTransVO _IssueSampleModificationTransVO)
	{
		IssueSampleModificationTransDAO.getBatchCombo(_IssueSampleModificationTransVO);
		
		  if (_IssueSampleModificationTransVO.getStrMsgType().equals("1")) 
		  {
			  _IssueSampleModificationTransVO.setStrMsgString("IssueSampleModificationTransBO.BatchCombo() --> "+ _IssueSampleModificationTransVO.getStrMsgString());
		  }
		  
	}
	/**
	 * IndentingStoreCombo  Method is Used to Generate Indenting STore Combo 
	 * @param vo
	 */
	
	public void VoucherDetails(IssueSampleModificationTransVO _IssueSampleModificationTransVO)
	{
		IssueSampleModificationTransDAO.VoucherDetails(_IssueSampleModificationTransVO);
		//IssueSampleModificationTransDAO.VoucherItemDetails(_IssueSampleModificationTransVO);
		
		  if (_IssueSampleModificationTransVO.getStrMsgType().equals("1")) 
		  {
			  _IssueSampleModificationTransVO.setStrMsgString("IssueSampleModificationTransBO.VoucherDetails() --> "+ _IssueSampleModificationTransVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * IndentingStoreCombo  Method is Used to Generate Indenting STore Combo 
	 * @param vo
	 */
	
	public void VoucherCombo(IssueSampleModificationTransVO _IssueSampleModificationTransVO)
	{
		IssueSampleModificationTransDAO.getVoucherCombo(_IssueSampleModificationTransVO);

		if (_IssueSampleModificationTransVO.getStrMsgType().equals("1")) 
		  {
			  _IssueSampleModificationTransVO.setStrMsgString("IssueSampleModificationTransBO.VoucherCombo() --> "+ _IssueSampleModificationTransVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * GetStoreBudget Method is Used to get Indenting Store Budget
	 * for Breakage Item Details DAO 
	 * @param vo
	 */
	public void GetStoreBudget(IssueSampleModificationTransVO _IssueSampleModificationTransVO)
	{		
		IssueSampleModificationTransDAO.getAvalBudgetDetails(_IssueSampleModificationTransVO);
		
		  if (_IssueSampleModificationTransVO.getStrMsgType().equals("1")) 
		  {
			  _IssueSampleModificationTransVO.setStrMsgString("IssueSampleModificationTransBO.GetStoreBudget() --> "+ _IssueSampleModificationTransVO.getStrMsgString());
		  }
		  
	}
	
	/**
	 * Method is Used to Generate View page data 
	 * @param vo
	 */	
	public void initForViewPage(IssueSampleModificationTransVO _IssueSampleModificationTransVO){
		
		 
		IssueSampleModificationTransDAO.GetData(_IssueSampleModificationTransVO);
		IssueSampleModificationTransDAO.getVoucherCombo(_IssueSampleModificationTransVO);
		if (_IssueSampleModificationTransVO.getStrMsgType().equals("1"))
		{
			_IssueSampleModificationTransVO.setStrMsgString("IssueSampleModificationTransBO.initForViewPage() --> "+ _IssueSampleModificationTransVO.getStrMsgString());
		}
	}
	
	/**
	 * This method is used to GET Issue Details
	 * 
	 * @param vo
	 */
	
	public void getVoucherCombo(IssueSampleModificationTransVO _IssueSampleModificationTransVO){
		
		IssueSampleModificationTransDAO.getVoucherCombo(_IssueSampleModificationTransVO);
		if (_IssueSampleModificationTransVO.getStrMsgType().equals("1")){
			_IssueSampleModificationTransVO.setStrMsgString("IssueSampleModificationTransBO.getVoucherCombo() --> "+ _IssueSampleModificationTransVO.getStrMsgString());
		  }
		
	}

	
	
	
}
